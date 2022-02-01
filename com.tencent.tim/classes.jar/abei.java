import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;

public class abei
  implements ValueAnimator.AnimatorUpdateListener
{
  public abei(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.v.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.d.je.setLayoutParams(this.v);
    this.d.checkBox.setChecked(false);
    this.d.Pq.setMaxWidth(this.d.cnX);
    if (AppSetting.enableTalkBack) {
      this.d.setContentDescription(this.d.name);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     abei
 * JD-Core Version:    0.7.0.1
 */