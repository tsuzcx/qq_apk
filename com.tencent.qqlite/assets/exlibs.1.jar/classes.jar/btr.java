import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class btr
  implements Runnable
{
  public btr(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.a.d();
    QQToast.a(this.a.a, this.a.a.getString(2131362988), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btr
 * JD-Core Version:    0.7.0.1
 */