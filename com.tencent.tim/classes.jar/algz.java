import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class algz
  implements ValueAnimator.AnimatorUpdateListener
{
  public algz(ProfileTagView paramProfileTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.this$0.a.getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.this$0.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = (FrameLayout)this.this$0.mActivity.findViewById(16908290);
        if ((localObject != null) && (((FrameLayout)localObject).getChildCount() > 0))
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if (localObject != null)
          {
            localObject = ((View)localObject).getBackground();
            if ((localObject instanceof BitmapDrawable))
            {
              int j = (int)(255.0F * paramValueAnimator.getAnimatedFraction());
              int i = j;
              if (paramValueAnimator == this.this$0.aI) {
                i = 255 - j;
              }
              ((Drawable)localObject).setAlpha(i);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algz
 * JD-Core Version:    0.7.0.1
 */