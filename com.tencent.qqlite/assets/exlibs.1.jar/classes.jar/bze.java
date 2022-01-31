import android.os.Handler;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.MessageObserver;

public class bze
  extends MessageObserver
{
  public bze(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    BusinessCmrTmpChatPie.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bze
 * JD-Core Version:    0.7.0.1
 */