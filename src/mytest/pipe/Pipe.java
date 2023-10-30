package mytest.pipe;

// 管道类
abstract class Pipe {
    protected Pipe nextPipe;

    public void setNextPipe(Pipe pipe) {
        this.nextPipe = pipe;
    }

    public abstract String handle(String input);
}