import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.mobileqq.activity.Leba;

public class crn
  implements ViewStub.OnInflateListener
{
  public crn(Leba paramLeba) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.a.f();
    if (!Leba.a(this.a)) {
      this.a.a(true);
    }
    Leba.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crn
 * JD-Core Version:    0.7.0.1
 */