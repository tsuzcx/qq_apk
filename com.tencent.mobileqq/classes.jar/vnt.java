import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vnt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public vnt(BaseTroopChatPie paramBaseTroopChatPie) {}
  
  public void onGlobalLayout()
  {
    if (this.a.O)
    {
      this.a.O = false;
      BaseTroopChatPie.a(this.a).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnt
 * JD-Core Version:    0.7.0.1
 */