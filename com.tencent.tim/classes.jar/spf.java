import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class spf
{
  private long CZ;
  private spe.a jdField_a_of_type_Spe$a;
  private spe.b jdField_a_of_type_Spe$b;
  private spe.c jdField_a_of_type_Spe$c;
  private boolean aMv;
  private List<spa> animationList = new ArrayList();
  private spe.d jdField_b_of_type_Spe$d;
  private spf jdField_b_of_type_Spf;
  private spf c;
  private long duration = 3000L;
  private Interpolator interpolator;
  private View qy;
  private int repeatCount;
  private int repeatMode = 1;
  private AnimatorSet z;
  
  public static spa b(View... paramVarArgs)
  {
    return new spf().c(paramVarArgs);
  }
  
  protected AnimatorSet a()
  {
    this.aMv = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.animationList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (spa)((Iterator)localObject1).next();
      List localList = ((spa)localObject2).cp();
      if (((spa)localObject2).c() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((spa)localObject2).c());
        }
      }
      localArrayList.addAll(localList);
    }
    localObject1 = this.animationList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (spa)((Iterator)localObject1).next();
      if (((spa)localObject2).Nf()) {
        this.qy = ((spa)localObject2).getView();
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Animator)((Iterator)localObject1).next();
      if ((localObject2 instanceof ValueAnimator))
      {
        localObject2 = (ValueAnimator)localObject2;
        ((ValueAnimator)localObject2).setRepeatCount(this.repeatCount);
        ((ValueAnimator)localObject2).setRepeatMode(this.repeatMode);
        if (!this.aMv)
        {
          ((ValueAnimator)localObject2).addListener(new spg(this));
          this.aMv = true;
        }
      }
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).setDuration(this.duration);
    ((AnimatorSet)localObject1).setStartDelay(this.CZ);
    if (this.interpolator != null) {
      ((AnimatorSet)localObject1).setInterpolator(this.interpolator);
    }
    ((AnimatorSet)localObject1).addListener(new sph(this));
    return localObject1;
  }
  
  public spf a(long paramLong)
  {
    this.duration = paramLong;
    return this;
  }
  
  public spf a(Interpolator paramInterpolator)
  {
    this.interpolator = paramInterpolator;
    return this;
  }
  
  public spf a(spe.c paramc)
  {
    this.jdField_a_of_type_Spe$c = paramc;
    return this;
  }
  
  public spf a(spe.d paramd)
  {
    this.jdField_b_of_type_Spe$d = paramd;
    return this;
  }
  
  public spf b()
  {
    if (this.jdField_b_of_type_Spf != null)
    {
      this.jdField_b_of_type_Spf.b();
      return this;
    }
    this.z = a();
    if (this.qy != null)
    {
      this.qy.getViewTreeObserver().addOnPreDrawListener(new spi(this));
      return this;
    }
    this.z.start();
    return this;
  }
  
  public spa c(View... paramVarArgs)
  {
    paramVarArgs = new spa(this, paramVarArgs);
    this.animationList.add(paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spf
 * JD-Core Version:    0.7.0.1
 */