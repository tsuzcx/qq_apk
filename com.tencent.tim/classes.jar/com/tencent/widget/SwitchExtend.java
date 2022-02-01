package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;

public class SwitchExtend
  extends Switch
{
  private a a;
  
  public SwitchExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 2131035328);
  }
  
  public SwitchExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean performClick()
  {
    if ((this.a == null) || (this.a.a(this))) {
      return super.performClick();
    }
    return false;
  }
  
  public void setOnSwitchListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(SwitchExtend paramSwitchExtend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.widget.SwitchExtend
 * JD-Core Version:    0.7.0.1
 */