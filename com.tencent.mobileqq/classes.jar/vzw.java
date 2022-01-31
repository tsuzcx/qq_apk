import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;

public class vzw
  implements Runnable
{
  public vzw(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    Object localObject = LightalkBlueTipsBar.a(this.a).getPreferences();
    if (((SharedPreferences)localObject).getInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).getCurrentAccountUin(), 5) != 5)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).getCurrentAccountUin(), 5);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzw
 * JD-Core Version:    0.7.0.1
 */