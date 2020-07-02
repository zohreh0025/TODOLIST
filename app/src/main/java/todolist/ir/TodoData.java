package todolist.ir;

public class TodoData {

    private Integer noteId;

    private String edittxt;

    public TodoData(Integer noteId, String edittxt) {
        this.edittxt = edittxt;
        this.noteId = noteId;
    }

    public String getEdittxt() {
        return edittxt;
    }

    public Integer getNoteId() {
        return noteId;
    }
}
