package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class PullRefreshHeader
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  int d;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
  }
  
  private void d(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131562275), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    Drawable localDrawable = null;
    String str = "";
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839645);
    }
    for (;;)
    {
      Object localObject = str;
      if (localDrawable != null)
      {
        paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        localObject = new SpannableString("[O]" + " " + str);
        ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, "[O]".length(), 17);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      localDrawable = getResources().getDrawable(2130839647);
      str = getResources().getString(2131563136);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839647);
      continue;
      localDrawable = getResources().getDrawable(2130839645);
      str = getResources().getString(2131562097);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839645);
      continue;
      localDrawable = getResources().getDrawable(2130839646);
      str = getResources().getString(2131562097);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839645);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131563139);
    d(paramLong);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getDrawable().getConstantState().equals(getResources().getDrawable(2130839647).getConstantState());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562744);
    d(paramLong);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839643);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562673);
    d(paramLong);
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231066));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131232082));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232083));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232084));
    c(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */