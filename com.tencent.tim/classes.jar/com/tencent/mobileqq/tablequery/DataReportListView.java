package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ListView;

public class DataReportListView
  extends ListView
{
  private int dNE;
  private WindowManager mWindowManager;
  
  public DataReportListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.dNE = (this.mWindowManager.getDefaultDisplay().getHeight() / 3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (getMeasuredHeight() > this.dNE) {
      setMeasuredDimension(paramInt1, this.dNE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.DataReportListView
 * JD-Core Version:    0.7.0.1
 */