package com.tencent.qqmail.utilities.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.observer.QMNotification;

public class QMTipsDialog
  extends ReportDialog
{
  private QMTipsDialogCallback callback;
  private LinearLayout containerLL;
  private long hideDelayId;
  private ImageView icon;
  private TextView label;
  private QMLoading mLoadingView;
  private RelativeLayout progressBar;
  private TextView subTitleLabel;
  private ViewStub subTitleViewStub;
  private View upload;
  
  public QMTipsDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMTipsDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QMTipsDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  private void hideAllViews()
  {
    this.label.setVisibility(8);
    this.icon.setVisibility(8);
    this.upload.setVisibility(8);
    this.progressBar.setVisibility(8);
    if (this.subTitleLabel != null) {
      this.subTitleLabel.setVisibility(8);
    }
  }
  
  private void initViews()
  {
    this.containerLL = ((LinearLayout)findViewById(2131374710));
    this.icon = ((ImageView)findViewById(2131374708));
    this.progressBar = ((RelativeLayout)findViewById(2131374711));
    this.label = ((TextView)findViewById(2131374712));
    this.subTitleViewStub = ((ViewStub)findViewById(2131374714));
    this.subTitleViewStub.setOnInflateListener(new QMTipsDialog.1(this));
    this.upload = findViewById(2131374709);
    this.containerLL.setVisibility(0);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.progressBar.removeAllViews();
  }
  
  public QMTipsDialogCallback getCallback()
  {
    return this.callback;
  }
  
  public long getHideDelayId()
  {
    return this.hideDelayId;
  }
  
  public void hide()
  {
    super.hide();
    this.progressBar.removeAllViews();
  }
  
  public void init()
  {
    Log.v("__angusdu__", "dialog init");
    initViews();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QMNotification.postNotification("QMTIP_ONKEYDOWN", Integer.valueOf(paramInt));
    if (paramInt == 4)
    {
      if (this.callback != null) {
        this.callback.onBackKeyDown(this);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void recycle()
  {
    this.callback = null;
    this.containerLL = null;
    this.icon = null;
    this.label = null;
    this.upload = null;
    this.progressBar.removeAllViews();
    this.progressBar = null;
    this.mLoadingView = null;
    this.subTitleLabel = null;
    this.subTitleViewStub = null;
  }
  
  public void setCallback(QMTipsDialogCallback paramQMTipsDialogCallback)
  {
    this.callback = paramQMTipsDialogCallback;
  }
  
  public void setHideDelayId(long paramLong)
  {
    this.hideDelayId = paramLong;
  }
  
  public void showError(String paramString)
  {
    hideAllViews();
    this.label.setText(paramString);
    this.label.setVisibility(0);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841016);
  }
  
  public void showInfo(String paramString)
  {
    hideAllViews();
    this.label.setText(paramString);
    this.label.setVisibility(0);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841017);
  }
  
  public void showLoading(String paramString)
  {
    showLoading(paramString, null);
  }
  
  public void showLoading(String paramString1, String paramString2)
  {
    hideAllViews();
    if (!paramString1.equals(""))
    {
      this.label.setVisibility(0);
      this.label.setText(paramString1);
    }
    this.progressBar.setVisibility(0);
    this.progressBar.addView(new QMLoading(QMApplicationContext.sharedInstance(), QMUIKit.dpToPx(36), 1));
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      if (this.subTitleLabel == null) {
        this.subTitleViewStub.setVisibility(0);
      }
      if (this.subTitleLabel != null)
      {
        this.subTitleLabel.setVisibility(0);
        this.subTitleLabel.setText(paramString2);
      }
    }
  }
  
  public void showSuccess(String paramString)
  {
    hideAllViews();
    this.label.setText(paramString);
    this.label.setVisibility(0);
    this.icon.setVisibility(0);
    this.icon.setBackgroundResource(2130841015);
  }
  
  public void showUpload(String paramString)
  {
    hideAllViews();
    this.label.setText(paramString);
    this.label.setVisibility(0);
    this.upload.setVisibility(0);
  }
  
  public void updateUploadMessage(String paramString)
  {
    this.label.setText(paramString);
  }
  
  static abstract interface QMTipsDialogCallback
  {
    public abstract void onBackKeyDown(QMTipsDialog paramQMTipsDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTipsDialog
 * JD-Core Version:    0.7.0.1
 */