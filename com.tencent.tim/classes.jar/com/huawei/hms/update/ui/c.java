package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class c
  extends b
{
  public AlertDialog a()
  {
    ReportProgressDialog localReportProgressDialog = new ReportProgressDialog(f(), g());
    localReportProgressDialog.setMessage(ResourceLoaderUtil.getString("hms_checking"));
    localReportProgressDialog.setCanceledOnTouchOutside(false);
    return localReportProgressDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.c
 * JD-Core Version:    0.7.0.1
 */