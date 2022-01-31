package com.tencent.mobileqq.activity.voip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VoipDetailActivity$VoipHistoryListDivider
  extends LinearLayout
{
  private TextView a;
  
  public VoipDetailActivity$VoipHistoryListDivider(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130904052, this);
    this.a = ((TextView)findViewById(2131234667));
    this.a.setText(paramString);
  }
  
  public VoipDetailActivity$VoipHistoryListDivider(Context paramContext, String paramString)
  {
    this(paramContext, null, paramString);
  }
  
  public void setTextViewText(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDetailActivity.VoipHistoryListDivider
 * JD-Core Version:    0.7.0.1
 */