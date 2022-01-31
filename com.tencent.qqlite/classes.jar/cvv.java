import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SQLiteDatabase;

public class cvv
  implements Runnable
{
  cvv(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "transaction exception!", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvv
 * JD-Core Version:    0.7.0.1
 */