import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;

public class abx
  extends UniPayHandler.UniPayUpdateListener
{
  public abx(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new aby(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abx
 * JD-Core Version:    0.7.0.1
 */