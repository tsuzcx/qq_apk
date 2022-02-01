import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.a;
import com.tencent.qphone.base.util.QLog;

public class vfd
  implements Leba.a
{
  public vfd(Leba paramLeba, View paramView, aevs paramaevs) {}
  
  public void onSuccess()
  {
    try
    {
      this.this$0.a(this.val$view, false, this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("Leba", 1, "clickAction", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfd
 * JD-Core Version:    0.7.0.1
 */