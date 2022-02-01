import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;

class ucs
  implements ViewStub.OnInflateListener
{
  ucs(ucp paramucp) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.a.a = paramView;
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucs
 * JD-Core Version:    0.7.0.1
 */