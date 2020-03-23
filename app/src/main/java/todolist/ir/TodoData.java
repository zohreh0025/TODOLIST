package todolist.ir;

public class TodoData {
    private String titel;
    private String edittxt;

    public TodoData(String titel, String edittxt) {
        this.titel = titel;
        this.edittxt = edittxt;
    }

    public String getEdittxt() {
        return edittxt;
    }

    public String getTitel() {
        return titel;
    }
}
