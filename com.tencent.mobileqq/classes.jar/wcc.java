import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

class wcc
  implements Runnable
{
  wcc(wcb paramwcb) {}
  
  public void run()
  {
    if (this.a.a.o != null) {
      this.a.a.o.clearAnimation();
    }
    PublicAccountChatPie.b(this.a.a).removeView(this.a.a.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcc
 * JD-Core Version:    0.7.0.1
 */