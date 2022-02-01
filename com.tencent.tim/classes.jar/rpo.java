import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class rpo
{
  boolean aJk = false;
  int btR = 0;
  ColorStateList d;
  RelativeLayout dR;
  ImmersiveTitleBar2 e;
  TextView kK;
  ImageView mRightImageView;
  float nQ = 1.0F;
  TextView xs;
  TextView xt;
  
  public rpo(BaseActivity paramBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (;;)
    {
      this.aJk = bool;
      if (this.aJk)
      {
        paramBaseActivity.mActNeedImmersive = false;
        paramBaseActivity.mNeedStatusTrans = false;
        paramBaseActivity.getWindow().addFlags(67108864);
      }
      this.btR = riw.dip2px(paramBaseActivity, paramInt);
      return;
      bool = false;
    }
  }
  
  private void ai(float paramFloat)
  {
    int i = (int)(255.0F * paramFloat);
    Drawable localDrawable = this.dR.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setAlpha(i);
      this.dR.invalidateDrawable(localDrawable);
    }
    this.e.setAlpha(paramFloat);
    this.xs.setAlpha(paramFloat);
    if (this.d == null) {
      this.d = this.xt.getTextColors();
    }
    if (paramFloat > 0.5D)
    {
      this.mRightImageView.setImageResource(2130840663);
      this.xt.setBackgroundResource(2130851758);
      this.xt.setTextColor(this.d);
      this.kK.setTextColor(this.d);
      return;
    }
    this.mRightImageView.setImageResource(2130840663);
    this.xt.setBackgroundResource(2130851758);
    this.xt.setTextColor(this.xt.getContext().getResources().getColorStateList(2131167301));
    this.kK.setTextColor(this.kK.getContext().getResources().getColorStateList(2131167301));
  }
  
  public boolean LP()
  {
    return this.nQ > 0.5D;
  }
  
  public void aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (float f = 1.0F; this.nQ == f; f = 0.0F) {
      return;
    }
    if (paramBoolean2)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setFloatValues(new float[] { this.nQ, f });
      localValueAnimator.addUpdateListener(new rpp(this));
      localValueAnimator.setDuration(500L);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.nQ = f;
      return;
      ai(f);
    }
  }
  
  public void onListViewScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramInt1 = -paramAbsListView.getChildAt(0).getTop();
      if ((paramInt1 > this.btR) && (!LP())) {
        aw(true, true);
      }
    }
    while ((paramInt1 <= 0) || (LP()))
    {
      do
      {
        return;
      } while ((paramInt1 >= this.btR) || (!LP()));
      aw(false, true);
      return;
    }
    aw(true, true);
  }
  
  public void u(View paramView)
  {
    this.dR = ((RelativeLayout)paramView.findViewById(2131379823));
    this.xs = ((TextView)paramView.findViewById(2131369627));
    this.xt = ((TextView)paramView.findViewById(2131369579));
    this.kK = ((TextView)paramView.findViewById(2131369612));
    this.mRightImageView = ((ImageView)paramView.findViewById(2131369594));
    this.e = ((ImmersiveTitleBar2)paramView.findViewById(2131379866));
    if (this.aJk)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpo
 * JD-Core Version:    0.7.0.1
 */