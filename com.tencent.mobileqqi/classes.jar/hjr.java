import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.CameraFrameLayout;

public class hjr
  implements Runnable
{
  public hjr(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void run()
  {
    CameraFrameLayout.a(this.a, true);
    synchronized (CameraFrameLayout.a(this.a))
    {
      if (CameraFrameLayout.a(this.a) != null)
      {
        CameraFrameLayout.a(this.a, new ImageView(this.a.getContext()));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(3, CameraFrameLayout.a(this.a));
        CameraFrameLayout.a(this.a).setLayoutParams(localLayoutParams);
        CameraFrameLayout.a(this.a).setImageDrawable(this.a.getResources().getDrawable(2130837673));
        CameraFrameLayout.a(this.a).addView(CameraFrameLayout.a(this.a));
        CameraFrameLayout.a(this.a).setOnClickListener(new hjs(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjr
 * JD-Core Version:    0.7.0.1
 */