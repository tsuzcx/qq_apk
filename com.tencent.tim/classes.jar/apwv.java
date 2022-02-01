import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import org.json.JSONObject;

public class apwv
  implements View.OnTouchListener
{
  public apwv(TroopGiftActionButton paramTroopGiftActionButton, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.val$textView.clearAnimation();
      paramMotionEvent = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
      paramMotionEvent.setDuration(100L);
      paramMotionEvent.setAnimationListener(new apww(this));
      this.val$textView.startAnimation(paramMotionEvent);
      paramMotionEvent = new ImageView(this.this$0.getContext());
      Object localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(1);
      ((GradientDrawable)localObject).setCornerRadius(aqcx.dip2px(this.this$0.getContext(), 56.0F));
      ((GradientDrawable)localObject).setColor(Color.parseColor(TroopGiftActionButton.a(this.this$0).optString("buttonEffectColor")));
      ((GradientDrawable)localObject).setAlpha(192);
      paramMotionEvent.setImageDrawable((Drawable)localObject);
      localObject = new RelativeLayout.LayoutParams(aqcx.dip2px(this.this$0.getContext(), 56.0F), aqcx.dip2px(this.this$0.getContext(), 56.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.this$0.addView(paramMotionEvent, (ViewGroup.LayoutParams)localObject);
      localObject = new ScaleAnimation(1.0F, 1.7F, 1.0F, 1.7F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(150L);
      ((ScaleAnimation)localObject).setAnimationListener(new apwx(this, paramMotionEvent));
      paramMotionEvent.startAnimation((Animation)localObject);
      if (this.this$0.x != null) {
        this.this$0.x.onClick(paramView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwv
 * JD-Core Version:    0.7.0.1
 */