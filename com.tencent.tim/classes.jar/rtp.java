import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class rtp
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener e;
  private View mContentView;
  
  private rtp(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.mContentView = paramView;
    setObjectValues(new Object[] { new rtp.b(paramFloat1, paramFloat2, paramFloat3), new rtp.b(paramFloat4, paramFloat5, paramFloat6) });
    setEvaluator(new rtp.c(null));
    this.e = new rtq(this, a(paramView));
    addUpdateListener(this.e);
  }
  
  private CircularRevealCompatLayout a(View paramView)
  {
    if ((paramView instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)localViewGroup;
    }
    CircularRevealCompatLayout localCircularRevealCompatLayout = new CircularRevealCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localCircularRevealCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localCircularRevealCompatLayout, i, localLayoutParams);
    return localCircularRevealCompatLayout;
  }
  
  public static rtp a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return new rtp(paramView, paramInt1, paramInt2, paramFloat1, paramInt1, paramInt2, paramFloat2);
  }
  
  public void bws()
  {
    Object localObject = this.mContentView.getParent();
    if ((localObject instanceof CircularRevealCompatLayout))
    {
      localObject = (CircularRevealCompatLayout)localObject;
      ((CircularRevealCompatLayout)localObject).removeView(this.mContentView);
      ViewGroup localViewGroup = (ViewGroup)((CircularRevealCompatLayout)localObject).getParent();
      ViewGroup.LayoutParams localLayoutParams = ((CircularRevealCompatLayout)localObject).getLayoutParams();
      int i = localViewGroup.indexOfChild((View)localObject);
      localViewGroup.removeView((View)localObject);
      localViewGroup.addView(this.mContentView, i, localLayoutParams);
    }
  }
  
  public void removeAllUpdateListeners()
  {
    super.removeAllUpdateListeners();
    addUpdateListener(this.e);
  }
  
  static final class a
    extends AnimatorListenerAdapter
  {
    private int bvm;
    private int bvn;
    private View pk;
    
    a(View paramView, int paramInt)
    {
      this.pk = paramView;
      this.bvm = paramInt;
      this.bvn = paramView.getLayerType();
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.pk.setLayerType(this.bvn, null);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.pk.setLayerType(this.bvn, null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      this.pk.setLayerType(this.bvm, null);
    }
  }
  
  static final class b
  {
    public float centerX;
    public float centerY;
    public float radius;
    
    public b(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
  }
  
  static final class c
    implements TypeEvaluator<rtp.b>
  {
    private rtp.b a;
    
    public rtp.b a(float paramFloat, rtp.b paramb1, rtp.b paramb2)
    {
      float f1 = paramb1.centerX + (paramb2.centerX - paramb1.centerX) * paramFloat;
      float f2 = paramb1.centerY + (paramb2.centerY - paramb1.centerY) * paramFloat;
      paramFloat = paramb1.radius + (paramb2.radius - paramb1.radius) * paramFloat;
      if (this.a == null) {
        this.a = new rtp.b(f1, f2, paramFloat);
      }
      for (;;)
      {
        return this.a;
        this.a.centerX = f1;
        this.a.centerY = f2;
        this.a.radius = paramFloat;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtp
 * JD-Core Version:    0.7.0.1
 */