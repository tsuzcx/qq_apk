package com.tencent.mobileqq.datareportviewer;

import acfp;
import afbk;
import afbx;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class DataReportSettingFragment$4$1
  implements Runnable
{
  public DataReportSettingFragment$4$1(afbk paramafbk, ArrayList paramArrayList) {}
  
  public void run()
  {
    afbx.a().ec(this.vU);
    this.a.a.a.notifyDataSetChanged();
    QQToast.a(this.a.a.getActivity(), acfp.m(2131704646), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */