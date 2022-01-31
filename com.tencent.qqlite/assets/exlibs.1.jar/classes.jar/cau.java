import android.os.Handler;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class cau
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public cau(TroopChatPie paramTroopChatPie) {}
  
  public void onGlobalLayout()
  {
    if ((TroopChatPie.a(this.a)) && (TroopChatPie.a(this.a) != null))
    {
      TroopChatPie.a(this.a, false);
      TroopChatPie.b(this.a).sendEmptyMessageDelayed(23, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cau
 * JD-Core Version:    0.7.0.1
 */