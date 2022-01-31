import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class dbo
  extends Handler
{
  private QQAnimationDrawable a;
  
  public dbo(QQAnimationDrawable paramQQAnimationDrawable)
  {
    this.a = paramQQAnimationDrawable;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof Long)) {
      this.a.scheduleSelf(this.a, ((Long)paramMessage.obj).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbo
 * JD-Core Version:    0.7.0.1
 */