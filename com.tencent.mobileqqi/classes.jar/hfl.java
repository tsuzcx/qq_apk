import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.CameraFrameLayout;
import com.tencent.mobileqq.widget.QQToast;

public class hfl
  implements Runnable
{
  public hfl(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    QQToast.a(this.a.getContext(), 0, this.a.getContext().getString(2131561697), 0).b(((BaseActivity)this.a.getContext()).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfl
 * JD-Core Version:    0.7.0.1
 */