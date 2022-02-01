package com.tencent.qqmail.qmui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QMUISwitch
  extends LinearLayout
  implements CompoundButton.OnCheckedChangeListener
{
  private boolean ignoreCallback;
  private CompoundButton.OnCheckedChangeListener listener;
  private TextView textView;
  
  public QMUISwitch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QMUISwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QMUISwitch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    this.textView = new TextView(paramContext);
    this.textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.textView.setVisibility(8);
    addView(this.textView);
    this.textView.setText("未选中");
    setChecked(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((this.listener == null) || (this.ignoreCallback)) || (paramBoolean)) {
      this.textView.setText("选中");
    }
    for (;;)
    {
      this.textView.setSelected(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.textView.setText("未选中");
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.ignoreCallback = true;
    this.ignoreCallback = false;
  }
  
  public void setOnCheckedListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.listener = paramOnCheckedChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.view.QMUISwitch
 * JD-Core Version:    0.7.0.1
 */