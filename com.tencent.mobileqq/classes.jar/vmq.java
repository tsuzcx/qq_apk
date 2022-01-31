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

public class vmq
{
  float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  boolean jdField_a_of_type_Boolean = false;
  TextView b;
  TextView c;
  
  public vmq(BaseActivity paramBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        paramBaseActivity.mActNeedImmersive = false;
        paramBaseActivity.mNeedStatusTrans = false;
        paramBaseActivity.getWindow().addFlags(67108864);
      }
      this.jdField_a_of_type_Int = vct.a(paramBaseActivity, paramInt);
      return;
      bool = false;
    }
  }
  
  private void a(float paramFloat)
  {
    int i = (int)(255.0F * paramFloat);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setAlpha(i);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidateDrawable(localDrawable);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setAlpha(paramFloat);
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = this.b.getTextColors();
    }
    if (paramFloat > 0.5D)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
      this.b.setBackgroundResource(2130849303);
      this.b.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      this.c.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839704);
    this.b.setBackgroundResource(2130849303);
    this.b.setTextColor(this.b.getContext().getResources().getColorStateList(2131101257));
    this.c.setTextColor(this.c.getContext().getResources().getColorStateList(2131101257));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131311586));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302847));
    this.b = ((TextView)paramView.findViewById(2131302804));
    this.c = ((TextView)paramView.findViewById(2131302832));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302816));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131311626));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramInt1 = -paramAbsListView.getChildAt(0).getTop();
      if ((paramInt1 > this.jdField_a_of_type_Int) && (!a())) {
        a(true, true);
      }
    }
    while ((paramInt1 <= 0) || (a()))
    {
      do
      {
        return;
      } while ((paramInt1 >= this.jdField_a_of_type_Int) || (!a()));
      a(false, true);
      return;
    }
    a(true, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (float f = 1.0F; this.jdField_a_of_type_Float == f; f = 0.0F) {
      return;
    }
    if (paramBoolean2)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setFloatValues(new float[] { this.jdField_a_of_type_Float, f });
      localValueAnimator.addUpdateListener(new vmr(this));
      localValueAnimator.setDuration(500L);
      localValueAnimator.start();
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = f;
      return;
      a(f);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Float > 0.5D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmq
 * JD-Core Version:    0.7.0.1
 */