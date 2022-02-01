import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class aart
  implements Animation.AnimationListener
{
  public aart(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NewFlowCameraActivity.a(this.this$0).setVisibility(4);
    NewFlowCameraActivity.a(this.this$0).setEnabled(false);
    this.this$0.mTip.setVisibility(4);
    aaqi.h("", "0X8007C05", this.this$0.ciN + "", "", "", "");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    NewFlowCameraActivity.a(this.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aart
 * JD-Core Version:    0.7.0.1
 */