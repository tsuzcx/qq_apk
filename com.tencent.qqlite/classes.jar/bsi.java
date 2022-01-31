import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;

public final class bsi
  implements Runnable
{
  public bsi(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.a.edit().putInt("open_times", AIOInputTypeHelper.b).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsi
 * JD-Core Version:    0.7.0.1
 */