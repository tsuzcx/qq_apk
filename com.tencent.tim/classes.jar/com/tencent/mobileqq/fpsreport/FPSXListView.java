package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.XListView;
import txn;
import txo;

public class FPSXListView
  extends XListView
{
  private txo b;
  private String bKV;
  private boolean chx = true;
  private int reportType;
  
  public FPSXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.chx) && (this.b != null)) {
      this.b.bEQ();
    }
  }
  
  public void pause()
  {
    if (this.b != null) {
      this.b.printLog();
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.b != null) {
      this.b.zD(paramInt);
    }
    if (this.reportType == 1) {
      if (paramInt == 0) {
        txn.a().stopMonitorScene("list_leba_new", false);
      }
    }
    while (this.reportType != 2)
    {
      return;
      txn.a().startMonitorScene("list_leba_new");
      return;
    }
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("list_leba", false);
      return;
    }
    txn.a().startMonitorScene("list_leba");
  }
  
  public void setActTAG(String paramString)
  {
    this.bKV = paramString;
    this.b = new txo();
    this.b.setActTAG(paramString);
  }
  
  public void setReportType(int paramInt)
  {
    this.reportType = paramInt;
  }
  
  public void xE(boolean paramBoolean)
  {
    this.chx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */