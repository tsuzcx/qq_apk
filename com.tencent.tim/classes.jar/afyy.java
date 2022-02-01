import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class afyy
  implements Animation.AnimationListener
{
  afyy(afyv paramafyv, AnimatorSet paramAnimatorSet) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    while (i < this.c.AB.size())
    {
      paramAnimation = (ImageView)this.c.AB.get(i);
      paramAnimation.clearAnimation();
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (i < this.c.uinList.size()))
      {
        Object localObject2 = (String)this.c.uinList.get(i);
        Drawable localDrawable = aqhu.c(true);
        localObject1 = aqdj.a((AppInterface)localObject1, 1, (String)localObject2, 4, localDrawable, localDrawable);
        localObject2 = paramAnimation.getDrawable();
        if ((localObject2 != null) && (localObject2 != localObject1) && ((localObject2 instanceof aqdj))) {
          ((aqdj)localObject2).cancel();
        }
        paramAnimation.setImageDrawable((Drawable)localObject1);
      }
      i += 1;
    }
    this.c.zt.clearAnimation();
    this.ao.cancel();
    this.c.zs.setTranslationX(0.0F);
    this.c.zs.setAlpha(1.0F);
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setFillAfter(true);
    paramAnimation.setDuration(200L);
    paramAnimation.setAnimationListener(new afyz(this));
    this.c.zt.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyy
 * JD-Core Version:    0.7.0.1
 */