package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqgz;

public class SelectTouchBarView
  extends RelativeLayout
{
  protected MutliSeletedBottomLine a;
  protected TextView acp;
  protected MutliSeletedBottomLine b;
  protected int eif;
  private int eig = -1;
  protected CharSequence mContent;
  private Context mContext;
  
  public SelectTouchBarView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131558687, this);
    this.acp = ((TextView)findViewById(2131362509));
    D((RelativeLayout)findViewById(2131362508));
  }
  
  private void D(RelativeLayout paramRelativeLayout)
  {
    int i = (int)aqgz.i(true);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.acp.measure(j, j);
    j = (i - this.acp.getMeasuredWidth() - aqcx.dip2px(this.mContext, 16.0F)) / 2;
    i = j;
    if (j < 0) {
      i = 0;
    }
    this.a = new MutliSeletedBottomLine(this.mContext, i, false);
    this.b = new MutliSeletedBottomLine(this.mContext, i, true);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams1.addRule(9);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams2.addRule(11);
    paramRelativeLayout.addView(this.a, localLayoutParams1);
    paramRelativeLayout.addView(this.b, localLayoutParams2);
  }
  
  public SelectTouchBarView a()
  {
    if (this.eif <= 0) {
      this.eif = 30;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = this.eif;
    localLayoutParams.width = -1;
    setLayoutParams(localLayoutParams);
    eiT();
    return this;
  }
  
  public SelectTouchBarView a(int paramInt)
  {
    this.eif = paramInt;
    if (paramInt <= 0) {
      this.eif = 0;
    }
    setMinimumHeight(this.eif);
    return this;
  }
  
  public SelectTouchBarView a(CharSequence paramCharSequence)
  {
    if ((this.acp != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.mContent = paramCharSequence;
      this.acp.setText(paramCharSequence);
      this.acp.setContentDescription(paramCharSequence);
    }
    return this;
  }
  
  public void eiT()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131362508);
    localRelativeLayout.removeView(this.a);
    localRelativeLayout.removeView(this.b);
    D(localRelativeLayout);
    invalidate();
  }
  
  public void setCheckedNum(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      localStringBuilder.append("选择到这里");
    }
    for (;;)
    {
      this.acp.setText(localStringBuilder.toString());
      this.acp.setContentDescription(localStringBuilder.toString());
      eiT();
      return;
      localStringBuilder.append("选择到这里(已选" + paramInt + "条)");
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.acp.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SelectTouchBarView
 * JD-Core Version:    0.7.0.1
 */