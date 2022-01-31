import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;

class aap
  implements Runnable
{
  aap(aao paramaao) {}
  
  public void run()
  {
    if ((BaseChatPie.b(this.a.a.a) != null) && (BaseChatPie.b(this.a.a.a).getParent() != null)) {
      ((ViewGroup)BaseChatPie.b(this.a.a.a).getParent()).removeView(BaseChatPie.b(this.a.a.a));
    }
    BaseChatPie.b(this.a.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aap
 * JD-Core Version:    0.7.0.1
 */