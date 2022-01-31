import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;

public final class bsh
  implements Runnable
{
  public bsh(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.a.edit().putInt("open_times", AIOInputTypeHelper.b).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsh
 * JD-Core Version:    0.7.0.1
 */