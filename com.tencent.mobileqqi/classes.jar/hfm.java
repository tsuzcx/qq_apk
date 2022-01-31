import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.QQToast;

public class hfm
  implements Runnable
{
  public hfm(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    QQToast.a(this.a.getContext(), 0, this.a.getContext().getString(2131561697), 0).b(((BaseActivity)this.a.getContext()).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfm
 * JD-Core Version:    0.7.0.1
 */