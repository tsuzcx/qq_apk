import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.SQLiteDatabase;

public class fkp
  implements Runnable
{
  fkp(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "transaction exception!", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkp
 * JD-Core Version:    0.7.0.1
 */