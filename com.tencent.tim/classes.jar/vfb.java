import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.activity.Leba;

public class vfb
  implements ViewSwitcher.ViewFactory
{
  public vfb(Leba paramLeba) {}
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(this.this$0.a());
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    return localImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfb
 * JD-Core Version:    0.7.0.1
 */