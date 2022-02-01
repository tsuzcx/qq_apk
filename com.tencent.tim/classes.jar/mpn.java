import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SlidingUpDialog.slidingDown.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SlidingUpDialog.slidingUp.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SlidingUpDialog;", "Landroid/app/Dialog;", "context", "Landroid/app/Activity;", "customView", "Landroid/view/View;", "customViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "(Landroid/app/Activity;Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "rootView", "Landroid/widget/RelativeLayout;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelOnTouchOutside", "setTranslucentStatusBar", "sliding", "view", "startY", "", "endY", "duration", "", "animEndCallback", "Lkotlin/Function0;", "slidingDown", "slidingUp", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mpn
  extends ReportDialog
{
  private RelativeLayout ff;
  private final View lr;
  private final RelativeLayout.LayoutParams q;
  
  public mpn(@NotNull Activity paramActivity, @NotNull View paramView, @NotNull RelativeLayout.LayoutParams paramLayoutParams)
  {
    super((Context)paramActivity, 16973833);
    this.lr = paramView;
    this.q = paramLayoutParams;
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Function0<Unit> paramFunction0)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new mpr(paramView));
    if (paramFunction0 != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new mps(paramFunction0));
    }
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "valueAnimator");
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void aQX()
  {
    findViewById(2131365371).setOnTouchListener((View.OnTouchListener)new mpp(this));
    RelativeLayout localRelativeLayout = this.ff;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.setOnTouchListener((View.OnTouchListener)mpq.a);
  }
  
  private final void aQY()
  {
    RelativeLayout localRelativeLayout = this.ff;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.post((Runnable)new SlidingUpDialog.slidingUp.1(this));
  }
  
  private final void aQZ()
  {
    Object localObject = this.ff;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = this.ff;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    a((View)localObject, 0.0F, localRelativeLayout.getHeight(), 200L, (Function0)new SlidingUpDialog.slidingDown.1(this));
  }
  
  private final void aRa()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label47;
      }
      View localView = localWindow.getDecorView();
      Intrinsics.checkExpressionValueIsNotNull(localView, "decorView");
      localView.setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(0);
    }
    for (;;)
    {
      return;
      label47:
      if (Build.VERSION.SDK_INT == 19) {
        localWindow.addFlags(67108864);
      }
    }
  }
  
  public void dismiss()
  {
    aQZ();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).requestFeature(1);
      ((Window)localObject).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((Window)localObject).setLayout(-1, -1);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
    }
    aRa();
    super.onCreate(paramBundle);
    setContentView(2131560408);
    this.lr.setId(2131376732);
    paramBundle = findViewById(2131363561);
    localObject = findViewById(2131377551);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.rootView)");
    this.ff = ((RelativeLayout)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "blank");
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    ((RelativeLayout.LayoutParams)paramBundle).addRule(3, this.lr.getId());
    paramBundle = this.ff;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramBundle.addView(this.lr, (ViewGroup.LayoutParams)this.q);
    aQX();
    findViewById(2131364221).setOnClickListener((View.OnClickListener)new mpo(this));
    aQY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpn
 * JD-Core Version:    0.7.0.1
 */