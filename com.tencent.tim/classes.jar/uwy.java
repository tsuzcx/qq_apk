import android.os.Message;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.FontSettingActivity.a;
import mqq.os.MqqHandler;

public class uwy
  extends MqqHandler
{
  public uwy(FontSettingActivity paramFontSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      acej.a(this.a, FontSettingActivity.a(this.a), false);
      this.a.needRefresh = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwy
 * JD-Core Version:    0.7.0.1
 */