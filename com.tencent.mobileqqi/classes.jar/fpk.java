import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

public class fpk
  implements Runnable
{
  public fpk(QQAnimationDrawable paramQQAnimationDrawable) {}
  
  public void run()
  {
    QQAnimationDrawable.a(this.a, true);
    Process.setThreadPriority(10);
    QQAnimationDrawable.b(this.a, QQAnimationDrawable.a(this.a, QQAnimationDrawable.a(this.a, true, 0)));
    QQAnimationDrawable.a(this.a, 1);
    if (QQAnimationDrawable.a(this.a))
    {
      Message localMessage = QQAnimationDrawable.a(this.a).obtainMessage();
      localMessage.obj = Integer.valueOf(0);
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpk
 * JD-Core Version:    0.7.0.1
 */