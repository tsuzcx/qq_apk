import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class tyn
{
  private int jdField_a_of_type_Int = 3;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private tyr jdField_a_of_type_Tyr;
  private volatile boolean jdField_a_of_type_Boolean;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private ObjectAnimator c;
  private ObjectAnimator d;
  
  public tyn(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    c();
  }
  
  private Interpolator a()
  {
    return PathInterpolatorCompat.create(0.25F, 0.1F, 0.25F, 1.0F);
  }
  
  private ImageView a()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    Object localObject = new LinearLayout.LayoutParams(ImmersiveUtils.a(50.0F), ImmersiveUtils.a(165.0F));
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130850075);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850072);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
    tql.a("https://qzonestyle.gtimg.cn/aoi/sola/20200228153849_2Ep5Zbq1da.png", this.jdField_a_of_type_ComTencentImageURLImageView, (URLDrawable.URLDrawableOptions)localObject, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#33000000"));
    a();
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tyo(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new typ(this));
  }
  
  private void d()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    localTextView.setTextSize(1, 16.0F);
    localTextView.setText("上下滑动查看更多哟");
    localTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_b_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        c();
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null);
    this.jdField_a_of_type_Int -= 1;
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(RecyclerViewCompat paramRecyclerViewCompat)
  {
    if (paramRecyclerViewCompat != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramRecyclerViewCompat.getChildAt(0);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(a());
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "scrollY", new int[] { 0, ImmersiveUtils.a(134.0F) });
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(a());
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(800L);
      this.c = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 1.0F, 0.0F });
      this.c.setInterpolator(a());
      this.c.setDuration(300L);
      this.d = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "scrollY", new int[] { ImmersiveUtils.a(134.0F), 0 });
      this.d.setInterpolator(a());
      this.d.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { this.jdField_a_of_type_AndroidAnimationObjectAnimator, this.jdField_b_of_type_AndroidAnimationObjectAnimator, this.c, this.d });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new tyq(this, paramRecyclerViewCompat));
    }
  }
  
  public void a(tyr paramtyr)
  {
    this.jdField_a_of_type_Tyr = paramtyr;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyn
 * JD-Core Version:    0.7.0.1
 */