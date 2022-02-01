import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;

public class abeh
  implements ValueAnimator.AnimatorUpdateListener
{
  public abeh(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.v.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.d.je.setLayoutParams(this.v);
    this.d.Pq.setMaxWidth(this.d.cnX - this.d.width);
    if (AppSetting.enableTalkBack)
    {
      paramValueAnimator = this.d.getResources();
      if (!this.d.checkBox.isChecked()) {
        break label124;
      }
    }
    label124:
    for (int i = 2131691504;; i = 2131721546)
    {
      paramValueAnimator = paramValueAnimator.getString(i);
      this.d.setContentDescription(this.d.name + paramValueAnimator);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     abeh
 * JD-Core Version:    0.7.0.1
 */