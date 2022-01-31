import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class bug
  implements Runnable
{
  public bug(RecordSoundPanel paramRecordSoundPanel) {}
  
  public void run()
  {
    this.a.g();
    QQToast.a(RecordSoundPanel.a(this.a).a(), RecordSoundPanel.a(this.a).a().getString(2131362978), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bug
 * JD-Core Version:    0.7.0.1
 */