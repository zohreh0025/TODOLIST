package todolist.ir;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {NoteTable.class})
public abstract class NoteDatabase extends RoomDatabase {

    abstract NoteDao getNoteDao();
}
