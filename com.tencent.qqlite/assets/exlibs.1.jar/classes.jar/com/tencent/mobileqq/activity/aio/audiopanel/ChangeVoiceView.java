package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static final int a = 0;
  public static final String a;
  public static String[] a;
  public static final int b = 1;
  public static String b;
  public static final int c = 2;
  private long jdField_a_of_type_Long = 0L;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TextView b;
  public int d;
  public int e = 0;
  private int f = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = ChangeVoiceView.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "原声音效", "萝莉音效", "大叔音效", "惊悚音效", "搞怪音效", "空灵音效" };
    jdField_b_of_type_JavaLangString = "停止";
  }
  
  public ChangeVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    if (paramInt == 2) {
      setContentDescription(jdField_b_of_type_JavaLangString);
    }
    while (this.e == paramInt)
    {
      return;
      setContentDescription(jdField_a_of_type_ArrayOfJavaLangString[this.d]);
    }
    this.e = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837646);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131427421));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.f, 0, this.f, 0);
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837647);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837647);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 /= 1000;
      paramInt1 = paramInt2 / 60;
      paramInt2 %= 60;
      localStringBuilder.append(paramInt1).append(":");
      if (paramInt2 < 10) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(paramInt2);
      if (!localStringBuilder.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt3);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    this.f = DisplayUtil.a(getContext(), 4.0F);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298120));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298125));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131298121));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298123));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131298124));
    switch (this.d)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      i = 2130837643;
      paramInt = 2131364528;
      continue;
      i = 2130837640;
      paramInt = 2131364529;
      continue;
      i = 2130837642;
      paramInt = 2131364530;
      continue;
      i = 2130837645;
      paramInt = 2131364531;
      continue;
      i = 2130837644;
      paramInt = 2131364532;
      continue;
      i = 2130837641;
      paramInt = 2131364533;
    }
  }
  
  public int b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView
 * JD-Core Version:    0.7.0.1
 */