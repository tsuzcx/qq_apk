package com.tencent.mobileqq.datareportviewer;

import afbx;
import android.widget.TextView;
import java.util.ArrayList;

class DataReportViewer$3
  implements Runnable
{
  DataReportViewer$3(DataReportViewer paramDataReportViewer) {}
  
  public void run()
  {
    if (!this.this$0.mList.isEmpty())
    {
      this.this$0.mList.remove(0);
      this.this$0.Rh.setText(String.valueOf(this.this$0.mList.size()));
      this.this$0.a.notifyDataSetChanged();
      this.this$0.cYm();
    }
    while (!afbx.bXd) {
      return;
    }
    afbx.a().hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.3
 * JD-Core Version:    0.7.0.1
 */