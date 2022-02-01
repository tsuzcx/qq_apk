import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axwc
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new axwd(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new aqnc(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new axwe(paramView));
  }
  
  public static void a(List<axwc.a> paramList, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        axwc.a locala = (axwc.a)paramList.next();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locala.view, locala.cWv, new float[] { locala.xP, locala.Fl }).setDuration(locala.duration);
        localObjectAnimator.setStartDelay(locala.delay);
        localArrayList.add(localObjectAnimator);
      }
      paramList = new AnimatorSet();
      paramList.playTogether(localArrayList);
      paramList.addListener(paramAnimatorListener);
      paramList.start();
    }
  }
  
  public static class a
  {
    public float Fl;
    public String cWv;
    public long delay;
    public long duration;
    public View view;
    public float xP;
    
    public a(View paramView, String paramString, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
    {
      this.view = paramView;
      this.cWv = paramString;
      this.xP = paramFloat1;
      this.Fl = paramFloat2;
      this.duration = paramLong1;
      this.delay = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwc
 * JD-Core Version:    0.7.0.1
 */