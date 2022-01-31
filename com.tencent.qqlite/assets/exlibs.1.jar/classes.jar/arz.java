import android.view.ViewStub;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.main.CommonLoadingView;

public class arz
  implements Runnable
{
  public arz(Leba paramLeba) {}
  
  public void run()
  {
    ViewStub localViewStub = (ViewStub)this.a.a(2131297255);
    ((CommonLoadingView)this.a.a(2131296836)).setVisibility(8);
    localViewStub.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     arz
 * JD-Core Version:    0.7.0.1
 */