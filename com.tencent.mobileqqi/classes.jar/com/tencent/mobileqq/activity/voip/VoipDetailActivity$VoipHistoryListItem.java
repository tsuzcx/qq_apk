package com.tencent.mobileqq.activity.voip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VoipDetailActivity$VoipHistoryListItem
  extends LinearLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public VoipDetailActivity$VoipHistoryListItem(Context paramContext, AttributeSet paramAttributeSet, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130904053, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234668));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234669));
    this.b = ((TextView)findViewById(2131234670));
    this.c = ((TextView)findViewById(2131234671));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.b.setText(paramString2);
    this.c.setText(paramString3);
    if (paramInt == 0) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840374);
      return;
    }
    catch (Exception paramContext) {}
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840372);
      return;
    }
    if (paramInt == 2) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840373);
    }
    return;
  }
  
  public VoipDetailActivity$VoipHistoryListItem(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this(paramContext, null, paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDetailActivity.VoipHistoryListItem
 * JD-Core Version:    0.7.0.1
 */