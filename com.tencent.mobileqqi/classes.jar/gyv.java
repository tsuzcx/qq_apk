import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity;

public class gyv
  implements Runnable
{
  public gyv(TroopNewcomerNoticeActivity paramTroopNewcomerNoticeActivity) {}
  
  public void run()
  {
    BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0).edit().putBoolean(this.a.c, false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyv
 * JD-Core Version:    0.7.0.1
 */