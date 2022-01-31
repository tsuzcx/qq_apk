import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class bsq
  implements Runnable
{
  public bsq(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.a.edit().putBoolean("input_type_changed", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsq
 * JD-Core Version:    0.7.0.1
 */