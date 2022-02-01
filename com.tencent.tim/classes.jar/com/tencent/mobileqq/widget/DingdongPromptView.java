package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atau.a;

public class DingdongPromptView
  extends RelativeLayout
{
  protected ImageView Fw;
  protected TextView abR;
  protected String cAl;
  protected int efB;
  protected int efC;
  protected Drawable gb;
  
  public DingdongPromptView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public DingdongPromptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DingdongPromptView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ac);
    this.cAl = paramAttributeSet.getString(2);
    this.gb = paramAttributeSet.getDrawable(0);
    this.efB = paramAttributeSet.getInt(1, 0);
    this.efC = paramAttributeSet.getInt(3, 0);
    paramAttributeSet.recycle();
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559240, this, true);
  }
  
  protected void ax(View paramView, int paramInt)
  {
    if (paramView != null) {}
    switch (paramInt)
    {
    default: 
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.abR = ((TextView)findViewById(2131380855));
    this.Fw = ((ImageView)findViewById(2131369848));
    this.abR.setText(this.cAl);
    this.abR.setVisibility(this.efC);
    this.Fw.setImageDrawable(this.gb);
    this.Fw.setVisibility(this.efB);
  }
  
  public void setPromptIconDrawable(int paramInt)
  {
    if (this.Fw != null)
    {
      this.Fw.setImageResource(paramInt);
      this.gb = null;
    }
  }
  
  public void setPromptIconDrawable(Drawable paramDrawable)
  {
    if (this.gb != paramDrawable)
    {
      this.gb = paramDrawable;
      if (this.Fw != null) {
        this.Fw.setImageDrawable(this.gb);
      }
    }
  }
  
  public void setPromptIconVisibility(int paramInt)
  {
    if (this.efB != paramInt)
    {
      this.efB = paramInt;
      ax(this.Fw, paramInt);
    }
  }
  
  public void setPromptText(String paramString)
  {
    if ((this.cAl == null) || (!this.cAl.equals(paramString)))
    {
      this.cAl = paramString;
      if (this.abR != null) {
        this.abR.setText(this.cAl);
      }
    }
  }
  
  public void setPromptTextVisibility(int paramInt)
  {
    if (this.efC != paramInt)
    {
      this.efC = paramInt;
      ax(this.abR, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DingdongPromptView
 * JD-Core Version:    0.7.0.1
 */