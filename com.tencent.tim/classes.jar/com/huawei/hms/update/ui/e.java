package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.text.NumberFormat;

public class e
  extends b
{
  private ProgressBar a;
  private TextView b;
  private int c = 0;
  private DialogInterface.OnKeyListener d = new a(null);
  
  public AlertDialog a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
    View localView = View.inflate(f(), ResourceLoaderUtil.getLayoutId("hms_download_progress"), null);
    localBuilder.setView(localView);
    localBuilder.setCancelable(false);
    localBuilder.setOnKeyListener(this.d);
    this.a = ((ProgressBar)localView.findViewById(ResourceLoaderUtil.getIdId("download_info_progress")));
    this.b = ((TextView)localView.findViewById(ResourceLoaderUtil.getIdId("hms_progress_text")));
    b(this.c);
    return localBuilder.create();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  void b(int paramInt)
  {
    Object localObject = f();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      HMSLog.w("DownloadProgress", "In setDownloading, The activity is null or finishing.");
    }
    while ((this.b == null) || (this.a == null)) {
      return;
    }
    this.a.setProgress(paramInt);
    localObject = NumberFormat.getPercentInstance().format(paramInt / 100.0F);
    this.b.setText((CharSequence)localObject);
  }
  
  static class a
    implements DialogInterface.OnKeyListener
  {
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      return (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.e
 * JD-Core Version:    0.7.0.1
 */