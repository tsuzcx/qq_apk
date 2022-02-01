import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.tencent.tim.cloudfile.anima.DynamicButton;

public class atjf
{
  public static void a(atjf.b paramb)
  {
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { atjf.b.a(paramb), atjf.b.b(paramb) });
    localValueAnimator1.addUpdateListener(new atjg(paramb));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { atjf.b.c(paramb), atjf.b.d(paramb) });
    localValueAnimator2.addUpdateListener(new atjh(paramb));
    Object localObject = atjf.b.a(paramb).a();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "cornerRadius", new float[] { atjf.b.a(paramb), atjf.b.b(paramb) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(localObject, "strokeWidth", new int[] { atjf.b.e(paramb), atjf.b.f(paramb) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofInt(localObject, "strokeColor", new int[] { atjf.b.g(paramb), atjf.b.h(paramb) });
    localObject = ObjectAnimator.ofInt(localObject, "color", new int[] { atjf.b.i(paramb), atjf.b.j(paramb) });
    ((ObjectAnimator)localObject).setEvaluator(new ArgbEvaluator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(atjf.b.a(paramb));
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator3).with(localObjectAnimator2).with(localValueAnimator2).with(localValueAnimator1).with((Animator)localObject);
    localAnimatorSet.addListener(new atji(paramb));
    localAnimatorSet.start();
  }
  
  public static abstract interface a
  {
    public abstract void etQ();
  }
  
  public static class b
  {
    private float Cu;
    private float Cv;
    private atjf.a jdField_a_of_type_Atjf$a;
    private DynamicButton jdField_a_of_type_ComTencentTimCloudfileAnimaDynamicButton;
    private long duration;
    private int epP;
    private int epQ;
    private int epR;
    private int epS;
    private int epT;
    private int epU;
    private int epV;
    private int epW;
    private int epX;
    private int epY;
    private String txt;
    
    public b(DynamicButton paramDynamicButton)
    {
      this.jdField_a_of_type_ComTencentTimCloudfileAnimaDynamicButton = paramDynamicButton;
    }
    
    public static b a(DynamicButton paramDynamicButton)
    {
      return new b(paramDynamicButton);
    }
    
    public b a(float paramFloat1, float paramFloat2)
    {
      this.Cu = paramFloat1;
      this.Cv = paramFloat2;
      return this;
    }
    
    public b a(int paramInt1, int paramInt2)
    {
      this.epP = paramInt1;
      this.epQ = paramInt2;
      return this;
    }
    
    public b a(long paramLong)
    {
      this.duration = paramLong;
      return this;
    }
    
    public b a(atjf.a parama)
    {
      this.jdField_a_of_type_Atjf$a = parama;
      return this;
    }
    
    public b a(String paramString)
    {
      this.txt = paramString;
      return this;
    }
    
    public b b(int paramInt1, int paramInt2)
    {
      this.epR = paramInt1;
      this.epS = paramInt2;
      return this;
    }
    
    public b c(int paramInt1, int paramInt2)
    {
      this.epV = paramInt1;
      this.epW = paramInt2;
      return this;
    }
    
    public b d(int paramInt1, int paramInt2)
    {
      this.epX = paramInt1;
      this.epY = paramInt2;
      return this;
    }
    
    public b e(int paramInt1, int paramInt2)
    {
      this.epT = paramInt1;
      this.epU = paramInt2;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjf
 * JD-Core Version:    0.7.0.1
 */