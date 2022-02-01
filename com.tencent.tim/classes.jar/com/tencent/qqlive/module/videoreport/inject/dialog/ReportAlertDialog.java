package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ReportAlertDialog
  extends AlertDialog
{
  public ReportAlertDialog(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ReportAlertDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ReportAlertDialog(@NonNull Context paramContext, boolean paramBoolean, @Nullable DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  protected void onStop()
  {
    super.onStop();
    EventCollector.getInstance().onDialogStop(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    EventCollector.getInstance().onDialogFocusChanged(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.dialog.ReportAlertDialog
 * JD-Core Version:    0.7.0.1
 */