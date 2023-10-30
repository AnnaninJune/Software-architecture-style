package mytest.pipe;

// 输入过滤器类
class InputFilter extends Filter {
    @Override
    public String handle(String input) {
        if (nextPipe != null) {
            return nextPipe.handle(input);
        } else {
            return input;
        }
    }
}
