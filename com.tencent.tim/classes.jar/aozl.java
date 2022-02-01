import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class aozl
{
  protected View If;
  protected aozk a;
  protected aoyk.a b;
  protected final aozl.a b;
  protected final Context mContext;
  protected boolean mHasInit;
  protected final View.OnClickListener mOnClickListener;
  protected final ViewStub n;
  
  public aozl(ViewStub paramViewStub, Context paramContext, View.OnClickListener paramOnClickListener, aozl.a parama)
  {
    this.n = paramViewStub;
    this.mContext = paramContext;
    this.mOnClickListener = paramOnClickListener;
    this.jdField_b_of_type_Aozl$a = parama;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, Interpolator paramInterpolator, boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(paramInterpolator);
    localValueAnimator.addUpdateListener(new aozm(this, paramView));
    localValueAnimator.addListener(new aozn(this, paramBoolean, paramView, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(aoyk.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });; localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 }))
    {
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new aozo(this, parama));
      localValueAnimator.start();
      return;
    }
  }
  
  private void init()
  {
    if (this.mHasInit) {
      return;
    }
    this.mHasInit = true;
    this.If = this.n.inflate();
    GridView localGridView = (GridView)this.If.findViewById(2131378909);
    this.a = new aozk(this.mContext, this.mOnClickListener);
    localGridView.setAdapter(this.a);
  }
  
  public boolean a(aoyk.a parama, aozp.a parama1)
  {
    init();
    int i;
    if (this.jdField_b_of_type_Aoyk$a != null)
    {
      i = ((LinearLayout.LayoutParams)this.If.getLayoutParams()).height;
      if (this.jdField_b_of_type_Aoyk$a == parama)
      {
        a(parama, false);
        a(this.If, i, 0, new DecelerateInterpolator(), true);
        this.jdField_b_of_type_Aoyk$a = null;
        return false;
      }
      a(this.jdField_b_of_type_Aoyk$a, false);
    }
    for (;;)
    {
      this.a.b(parama1);
      this.jdField_b_of_type_Aoyk$a = parama;
      int[] arrayOfInt = new int[2];
      parama.icon.getLocationInWindow(arrayOfInt);
      int j = (int)Math.ceil(parama1.list.size() / 3.0F);
      j = rpq.dip2px(this.mContext, j * 56 - 13 + 30);
      this.If.setVisibility(0);
      a(parama, true);
      a(this.If, i, j, new AccelerateInterpolator(), false);
      return true;
      i = 0;
    }
  }
  
  public void dYf()
  {
    this.jdField_b_of_type_Aoyk$a = null;
    if (this.mHasInit) {
      this.If.setVisibility(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bB(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozl
 * JD-Core Version:    0.7.0.1
 */