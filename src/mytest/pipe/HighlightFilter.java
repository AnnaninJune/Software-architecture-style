package mytest.pipe;

// 高亮过滤器类
class HighlightFilter extends Filter {
    @Override
    public String handle(String input) {
        String[] paragraphs = input.split("\n\n");
        StringBuilder sb = new StringBuilder();
        for (String paragraph : paragraphs) {
            if (!paragraph.trim().isEmpty()) {
                // 找到首段第一个汉字或字符
                char firstChar = '\0';
                for (int i = 0; i < paragraph.length(); i++) {
                    char c = paragraph.charAt(i);
                    if (isChineseCharacter(c) || Character.isLetter(c)) {
                        firstChar = c;
                        break;
                    }
                }

                // 将首段第一个汉字或字符用 ANSI 转义序列突出显示
                if (firstChar != '\0') {
                    sb.append("\033[38;2;255;255;0m"); // 设置字体颜色为黄色
                    sb.append("\033[1m"); // 设置字体加粗
                    sb.append(firstChar);
                    sb.append("\033[0m"); // 重置字体样式
                    sb.append("\033[0m"); // 重置颜色属性
                    sb.append(paragraph.substring(1));
                } else {
                    sb.append(paragraph);
                }
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }

    // 判断字符是否为汉字
    private boolean isChineseCharacter(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }
}