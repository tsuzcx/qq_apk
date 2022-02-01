import com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class woi
  implements ajny.b
{
  woi(wog paramwog, wop.a parama) {}
  
  public void yG(boolean paramBoolean)
  {
    QLog.i("LottieAnimDirector", 1, "onZipDownloadResult success:" + paramBoolean + " mPaused:" + wog.a(this.this$0) + " mDestroyed:" + wog.b(this.this$0));
    if ((wog.b(this.this$0)) || (wog.a(this.this$0))) {
      return;
    }
    ThreadManager.getUIHandler().post(new LottieAnimDirector.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woi
 * JD-Core Version:    0.7.0.1
 */