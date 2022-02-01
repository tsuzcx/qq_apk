import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@SuppressLint({"ClickableViewAccessibility"})
public class uwd
  extends uwq
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private static int jdField_a_of_type_Int = bdep.a(60.0F);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private final HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final uwf jdField_a_of_type_Uwf = new uwf(this, null);
  private uwg jdField_a_of_type_Uwg;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private final TextView c;
  private final TextView d;
  
  public uwd(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131368194));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370196));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370627));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131370628));
    this.c = ((TextView)a(2131370629));
    this.d = ((TextView)a(2131370630));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.c.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(8);
    Drawable localDrawable = a().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(uqs.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramObject);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(uqs.jdField_b_of_type_Int);
    this.c.setText(paramString);
    this.c.setTag(paramObject);
  }
  
  public void a(uwg paramuwg)
  {
    this.jdField_a_of_type_Uwg = paramuwg;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.d.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void b(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    Drawable localDrawable = a().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(uqs.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramObject);
    this.d.setCompoundDrawables(localDrawable, null, null, null);
    this.d.setCompoundDrawablePadding(uqs.jdField_b_of_type_Int);
    this.d.setText(paramString);
    this.d.setTag(paramObject);
  }
  
  public void c()
  {
    f();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    int i;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      i = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth();
      this.jdField_b_of_type_Int = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_Int += this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_Int += this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
      }
      if (this.jdField_b_of_type_Int - i < 1)
      {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        return;
      }
      uqf.a("WSMarqueeDirector", "startAnim:  A text:" + this.jdField_a_of_type_AndroidWidgetTextView.getText() + ",B text:" + this.jdField_b_of_type_AndroidWidgetTextView.getText() + " , A width:" + this.jdField_a_of_type_AndroidWidgetTextView.getWidth() + " , B width:" + this.jdField_b_of_type_AndroidWidgetTextView.getWidth() + " , " + this.jdField_b_of_type_Int);
    } while (!this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidWidgetTextView.isShown())
    {
      this.c.setVisibility(0);
      if (!this.jdField_b_of_type_AndroidWidgetTextView.isShown()) {
        break label361;
      }
      this.d.setVisibility(0);
    }
    for (;;)
    {
      i = this.jdField_b_of_type_Int * 2;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(i * 1000 / jdField_a_of_type_Int + 1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_Uwf);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Uwf);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      this.c.setVisibility(8);
      break;
      label361:
      this.d.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.pause();
      return;
    }
    f();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.resume();
      return;
    }
    c();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Uwg != null)
      {
        this.jdField_a_of_type_Uwg.a(paramView.getTag());
        continue;
        if (this.jdField_a_of_type_Uwg != null) {
          this.jdField_a_of_type_Uwg.b(paramView.getTag());
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    uqf.a("WSMarqueeDirector", "onGlobalLayout: ");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwd
 * JD-Core Version:    0.7.0.1
 */