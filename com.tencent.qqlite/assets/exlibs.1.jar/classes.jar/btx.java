import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class btx
  implements Runnable
{
  public btx(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    QQToast.a(ListenChangeVoicePanel.a(this.a).a(), "播放变音error", 0);
    this.a.a[ListenChangeVoicePanel.a(this.a)].a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btx
 * JD-Core Version:    0.7.0.1
 */