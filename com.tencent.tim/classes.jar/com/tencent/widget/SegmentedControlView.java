package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import atau.a;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiRadioGroupBase;
import com.tencent.qphone.base.util.QLog;

public class SegmentedControlView
  extends KapalaiRadioGroupBase
{
  private Drawable gI;
  private Drawable gJ;
  private Drawable gK;
  private Drawable gL;
  
  public SegmentedControlView(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
  }
  
  public SegmentedControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rZ);
    try
    {
      this.gI = paramContext.getDrawable(1);
      this.gJ = paramContext.getDrawable(2);
      this.gK = paramContext.getDrawable(3);
      this.gL = paramContext.getDrawable(4);
      setOrientation(paramContext.getInt(0, 0));
      paramContext.recycle();
      return;
    }
    catch (Exception paramAttributeSet)
    {
      for (;;)
      {
        paramAttributeSet.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, paramAttributeSet.toString());
        }
      }
    }
  }
  
  private void exm()
  {
    int j = getChildCount();
    if (j > 1)
    {
      if (this.gI != null) {
        getChildAt(0).setBackgroundDrawable(this.gI);
      }
      if (this.gK != null)
      {
        i = j - 2;
        while (i > 0)
        {
          getChildAt(i).setBackgroundDrawable(this.gK);
          i -= 1;
        }
      }
      if (this.gJ != null) {
        getChildAt(j - 1).setBackgroundDrawable(this.gJ);
      }
    }
    while ((j != 1) || (this.gL == null))
    {
      int i;
      return;
    }
    getChildAt(0).setBackgroundDrawable(this.gL);
  }
  
  public void init()
  {
    super.init();
    exm();
  }
  
  public void setBackgroundFirstButton(Drawable paramDrawable)
  {
    this.gI = paramDrawable;
  }
  
  public void setBackgroundLastButton(Drawable paramDrawable)
  {
    this.gJ = paramDrawable;
  }
  
  public void setBackgroundMiddleButton(Drawable paramDrawable)
  {
    this.gK = paramDrawable;
  }
  
  public void setBackgroundUniqueButton(Drawable paramDrawable)
  {
    this.gL = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.SegmentedControlView
 * JD-Core Version:    0.7.0.1
 */