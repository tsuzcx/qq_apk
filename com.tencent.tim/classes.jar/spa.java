import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class spa
{
  private final spf a;
  private boolean aMt;
  private boolean aMu;
  private final List<Animator> animatorList = new ArrayList();
  private Interpolator h;
  private final View[] r;
  
  public spa(spf paramspf, View... paramVarArgs)
  {
    this.a = paramspf;
    this.r = paramVarArgs;
  }
  
  public boolean Nf()
  {
    return this.aMt;
  }
  
  public spa a(long paramLong)
  {
    this.a.a(paramLong);
    return this;
  }
  
  protected spa a(Animator paramAnimator)
  {
    this.animatorList.add(paramAnimator);
    return this;
  }
  
  public spa a(String paramString, float... paramVarArgs)
  {
    View[] arrayOfView = this.r;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      this.animatorList.add(ObjectAnimator.ofFloat(localView, paramString, c(paramVarArgs)));
      i += 1;
    }
    return this;
  }
  
  public spa a(spe.c paramc)
  {
    this.a.a(paramc);
    return this;
  }
  
  public spa a(spe.e parame, float... paramVarArgs)
  {
    View[] arrayOfView = this.r;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(c(paramVarArgs));
      if (parame != null) {
        localValueAnimator.addUpdateListener(new spb(this, parame, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public spa a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public spa a(View... paramVarArgs)
  {
    return this.a.c(paramVarArgs);
  }
  
  public spf a()
  {
    return this.a.a(new AccelerateInterpolator());
  }
  
  public spf a(float paramFloat)
  {
    return this.a.a(new DecelerateInterpolator(paramFloat));
  }
  
  public spa b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public spf b()
  {
    this.a.b();
    return this.a;
  }
  
  public Interpolator c()
  {
    return this.h;
  }
  
  public spa c(float... paramVarArgs)
  {
    return a(new spc(this), paramVarArgs);
  }
  
  protected float[] c(float... paramVarArgs)
  {
    if (!this.aMu) {
      return paramVarArgs;
    }
    float[] arrayOfFloat = new float[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfFloat[i] = r(paramVarArgs[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected List<Animator> cp()
  {
    return this.animatorList;
  }
  
  public spa d(float... paramVarArgs)
  {
    return a(new spd(this), paramVarArgs);
  }
  
  public View getView()
  {
    return this.r[0];
  }
  
  protected float r(float paramFloat)
  {
    return this.r[0].getContext().getResources().getDisplayMetrics().density * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spa
 * JD-Core Version:    0.7.0.1
 */