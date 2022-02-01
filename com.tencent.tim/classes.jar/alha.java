import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.BreatheEffectView.a;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

public class alha
  implements BreatheEffectView.a
{
  public alha(ProfileTagView paramProfileTagView) {}
  
  public void dFE()
  {
    Object localObject1;
    if (this.this$0.ab != null)
    {
      localObject1 = this.this$0.x;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 != null) && (localObject2.getVisibility() != 8))
        {
          RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localObject2.getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.x = this.this$0.ab.x;
            localLayoutParams.y = this.this$0.ab.y;
            localObject2.setLayoutParams(localLayoutParams);
          }
        }
        i += 1;
      }
      this.this$0.dFM();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = (FrameLayout)this.this$0.mActivity.findViewById(16908290);
      if (localObject1 != null)
      {
        this.this$0.fq = ((FrameLayout)localObject1).getBackground();
        if (!aqsj.i(this.this$0.fq)) {
          ((FrameLayout)localObject1).setBackgroundDrawable(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alha
 * JD-Core Version:    0.7.0.1
 */