package todolist.ir;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface NoteDao {

    @Insert
    long insertNote(NoteTable noteTable);

    @Query("SELECT * FROM note_table")
    List<NoteTable> getNotes();

    @Query("SELECT * FROM note_table WHERE note=:search")
    List<NoteTable> searchNote(String search);

    @Delete
    int deleteNote(NoteTable noteTable);

    @Update
    void updateNote(NoteTable noteTable);
}
