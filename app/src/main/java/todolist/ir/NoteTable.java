package todolist.ir;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
class NoteTable {

    @PrimaryKey(autoGenerate = true)
    private Integer noteId;

    private String note;

    public NoteTable(Integer noteId, String note) {
        this.noteId = noteId;
        this.note = note;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
