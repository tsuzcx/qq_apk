import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class fpl
  extends Handler
{
  private QQAnimationDrawable a;
  
  public fpl(QQAnimationDrawable paramQQAnimationDrawable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpl
 * JD-Core Version:    0.7.0.1
 */