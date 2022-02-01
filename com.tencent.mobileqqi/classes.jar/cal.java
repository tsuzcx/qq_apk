import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigObserver;
import java.io.File;
import java.util.List;

public class cal
  extends ConfigObserver
{
  public cal(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      Object localObject = new File(AppConstants.aU);
      List localList = null;
      if (((File)localObject).exists()) {
        localList = ChatBackgroundSettingActivity.a();
      }
      if (localList != null)
      {
        localObject = this.a.getSharedPreferences("chat_background_version", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong("chat_background_version", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        this.a.runOnUiThread(new cam(this, localList));
      }
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cal
 * JD-Core Version:    0.7.0.1
 */