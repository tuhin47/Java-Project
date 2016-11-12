
import javafx.scene.control.TextArea;

public class LogTextArea extends TextArea {

    private boolean pausedScroll = false;
    private double scrollPosition = 0;

    public LogTextArea() {
        super();
    }

    public void setMessage(String data) {
        if (pausedScroll) {
            scrollPosition = this.getScrollTop();
            this.setText(data);
            this.setScrollTop(scrollPosition);
        } else {
            this.setText(data);
            this.setScrollTop(Double.MAX_VALUE);
        }
    }

    public void pauseScroll(Boolean pause) {
        pausedScroll = pause;
    }

    public static void main(String args[]) {
        LogTextArea ll = new LogTextArea();
        ll.setMessage("I love u.\n"
                + "Bangladesh"
                + "tamim kala para na\n");
    }

}
