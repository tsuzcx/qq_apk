package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class SoftInputDetectView
  extends RelativeLayout
{
  private a a;
  private Rect bF = new Rect();
  private int cUE;
  private boolean cwW = true;
  private int dtI;
  private int dtJ = -1;
  private int mScreenHeight;
  
  public SoftInputDetectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SoftInputDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(this.bF);
    int i = this.dtI;
    if (this.cwW)
    {
      paramInt2 = this.bF.bottom - this.bF.top;
      if (this.mScreenHeight == 0) {
        this.mScreenHeight = paramInt2;
      }
      if (this.dtJ < 0) {
        this.dtJ = this.bF.top;
      }
      this.dtI = paramInt2;
      if ((paramInt2 != 0) && (i != 0) && (paramInt2 != i))
      {
        if (this.dtJ != this.bF.top)
        {
          if (this.cwW) {
            this.mScreenHeight -= this.bF.top - this.dtJ;
          }
          this.dtJ = this.bF.top;
        }
        if (paramInt2 >= this.mScreenHeight) {
          break label255;
        }
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.cUE = (this.mScreenHeight - paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SoftInputDetectView", 2, "Detected layout change. Input Method is showing? " + bool + " Input Method Height is " + this.cUE);
      }
      if (this.a != null) {
        this.a.aq(bool, this.cUE);
      }
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, 1073741824));
      return;
      paramInt2 = this.bF.bottom;
      break;
    }
  }
  
  public void setExcludeStatusBar(boolean paramBoolean)
  {
    this.cwW = paramBoolean;
  }
  
  public void setOnImStateChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aq(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SoftInputDetectView
 * JD-Core Version:    0.7.0.1
 */