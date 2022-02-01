package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.Switch;

public class FormSwitchSimpleItem
  extends FormSwitchItem
{
  private TextView kK;
  
  public FormSwitchSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    sT();
  }
  
  private void sT()
  {
    if (this.kK == null)
    {
      this.kK = new TextView(getContext());
      this.kK.setTextSize(2, 14.0F);
      this.kK.setTextColor(getResources().getColorStateList(2131167393));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131297562);
      localLayoutParams.addRule(0, this.u.getId());
      localLayoutParams.addRule(15);
      addView(this.kK, localLayoutParams);
    }
  }
  
  public TextView ad()
  {
    return this.kK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchSimpleItem
 * JD-Core Version:    0.7.0.1
 */