import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abqb
  implements yjf
{
  public TextView PR;
  public TextView PS;
  private Animation aA;
  public RelativeLayout el;
  public RelativeLayout jj;
  public RelativeLayout jk;
  public WeakReference<Context> mContextRef;
  private Animation mCurrentAnimation;
  private AnimationSet u;
  private View.OnClickListener x;
  
  public abqb(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
    this.mContextRef = new WeakReference(paramContext);
    this.el = new RelativeLayout((Context)this.mContextRef.get());
    this.el.setBackgroundColor(-1);
    this.el.setOnClickListener(this.x);
    this.jj = new RelativeLayout((Context)this.mContextRef.get());
    paramContext = new RelativeLayout.LayoutParams(-1, wja.dp2px(44.0F, ((Context)this.mContextRef.get()).getResources()));
    this.el.addView(this.jj, paramContext);
    this.PR = new TextView((Context)this.mContextRef.get());
    this.PR.setTextColor(-16777216);
    this.PR.setTextSize(16.0F);
    this.PR.setGravity(17);
    this.PR.setText(acfp.m(2131704140));
    this.PR.setCompoundDrawablePadding(wja.dp2px(8.0F, ((Context)this.mContextRef.get()).getResources()));
    paramOnClickListener = u(2130838609);
    paramOnClickListener.setBounds(0, 0, paramOnClickListener.getIntrinsicWidth(), paramOnClickListener.getIntrinsicHeight());
    this.PR.setCompoundDrawables(paramOnClickListener, null, null, null);
    paramContext = new RelativeLayout.LayoutParams(-2, wja.dp2px(44.0F, ((Context)this.mContextRef.get()).getResources()));
    paramContext.addRule(15);
    paramContext.leftMargin = wja.dp2px(12.0F, ((Context)this.mContextRef.get()).getResources());
    paramContext.addRule(9);
    this.jj.addView(this.PR, paramContext);
    Object localObject = new ImageView((Context)this.mContextRef.get());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = wja.dp2px(12.0F, ((Context)this.mContextRef.get()).getResources());
    paramContext = new StateListDrawable();
    Drawable localDrawable1 = u(2130838709);
    Drawable localDrawable2 = u(2130838710);
    paramContext.addState(new int[] { 16842919, 16842910 }, localDrawable2);
    paramContext.addState(new int[0], localDrawable1);
    ((ImageView)localObject).setImageDrawable(paramContext);
    ((ImageView)localObject).setDuplicateParentStateEnabled(true);
    this.jj.addView((View)localObject, localLayoutParams);
    this.jk = new RelativeLayout((Context)this.mContextRef.get());
    localObject = new RelativeLayout.LayoutParams(-1, wja.dp2px(44.0F, ((Context)this.mContextRef.get()).getResources()));
    this.el.addView(this.jk, (ViewGroup.LayoutParams)localObject);
    this.PS = new TextView((Context)this.mContextRef.get());
    this.PS.setTextColor(-16777216);
    this.PS.setTextSize(16.0F);
    this.PS.setGravity(17);
    this.PS.setText(acfp.m(2131704141));
    this.PS.setCompoundDrawablePadding(wja.dp2px(8.0F, ((Context)this.mContextRef.get()).getResources()));
    this.PS.setCompoundDrawables(paramOnClickListener, null, null, null);
    paramOnClickListener = new RelativeLayout.LayoutParams(-2, wja.dp2px(44.0F, ((Context)this.mContextRef.get()).getResources()));
    paramOnClickListener.addRule(15);
    paramOnClickListener.leftMargin = wja.dp2px(12.0F, ((Context)this.mContextRef.get()).getResources());
    paramOnClickListener.addRule(9);
    this.jk.addView(this.PS, paramOnClickListener);
    paramOnClickListener = new ImageView((Context)this.mContextRef.get());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(12.0F, ((Context)this.mContextRef.get()).getResources());
    paramOnClickListener.setImageDrawable(paramContext);
    paramOnClickListener.setDuplicateParentStateEnabled(true);
    this.jk.addView(paramOnClickListener, (ViewGroup.LayoutParams)localObject);
    this.jk.setVisibility(4);
    this.aA = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.aA.setDuration(500L);
    this.aA.setFillAfter(true);
    this.mCurrentAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.mCurrentAnimation.setDuration(500L);
    this.mCurrentAnimation.setFillAfter(true);
    this.u = new AnimationSet(false);
    paramContext = new AlphaAnimation(0.0F, 1.0F);
    paramContext.setDuration(500L);
    this.u.addAnimation(paramContext);
    paramContext = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(500L);
    paramContext.setInterpolator(new OvershootInterpolator(1.3F));
    this.u.addAnimation(paramContext);
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.el;
  }
  
  public void cEc()
  {
    this.jj.clearAnimation();
    this.jj.setVisibility(0);
    this.mCurrentAnimation.reset();
    this.jj.startAnimation(this.mCurrentAnimation);
    this.jk.setVisibility(0);
    this.aA.reset();
    this.jk.clearAnimation();
    this.jk.startAnimation(this.aA);
  }
  
  public void cEd()
  {
    this.jj.clearAnimation();
    this.jj.setVisibility(0);
    this.aA.reset();
    this.jj.startAnimation(this.aA);
    this.jk.setVisibility(0);
    this.mCurrentAnimation.reset();
    this.jk.clearAnimation();
    this.jk.startAnimation(this.mCurrentAnimation);
  }
  
  public int getType()
  {
    return 15;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public Drawable u(int paramInt)
  {
    try
    {
      Drawable localDrawable = ((Context)this.mContextRef.get()).getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-1);
      localThrowable.printStackTrace();
      QLog.e("CmGameTipsBar", 2, localThrowable.getMessage());
      return localColorDrawable;
    }
  }
  
  public int wM()
  {
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqb
 * JD-Core Version:    0.7.0.1
 */