package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.thread.Threads;

public class QMTips
  implements DialogInterface.OnDismissListener, QMTipsDialog.QMTipsDialogCallback
{
  public static final String QMTipsNotification = "QMTipsNotification";
  private static final String TAG = "tower";
  public static final long TIPS_INVALID_ID = 0L;
  public static final long TIPS_SHOW_TIME = 1000L;
  private QMTipsCallback callback;
  private boolean canceledOnTouchOutside;
  private boolean canceledWithBackKey;
  private Context context;
  private QMTipsDialog dialog;
  private boolean hasBackKeyPressed;
  private boolean hidden;
  private Runnable hideDelay;
  private Object tag;
  
  protected QMTips() {}
  
  public QMTips(Context paramContext)
  {
    this.context = QMApplicationContext.sharedInstance();
    this.hidden = true;
    this.hasBackKeyPressed = false;
    this.dialog = new QMTipsDialog(paramContext, 2131755490);
    this.dialog.setContentView(2131561142);
    this.dialog.init();
    setCanceledOnTouchOutside(false);
    setCanceledWithBackKey(true);
    this.dialog.setOnDismissListener(this);
    this.dialog.setCallback(this);
  }
  
  private void handleHide()
  {
    this.hidden = true;
    this.hasBackKeyPressed = false;
    if (this.dialog != null) {}
    try
    {
      if (this.dialog != null) {
        this.dialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void handleShow()
  {
    removeHideDelay();
    this.hidden = false;
    this.hasBackKeyPressed = false;
    if (this.dialog != null) {}
    try
    {
      this.dialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void removeHideDelay()
  {
    Threads.removeCallbackOnMain(this.hideDelay);
  }
  
  public void dismissTipsManually()
  {
    handleHide();
  }
  
  public QMTipsCallback getCallback()
  {
    return this.callback;
  }
  
  public QMTipsDialog getDialog()
  {
    return this.dialog;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public void hide()
  {
    Threads.runOnMainThread(new QMTips.12(this));
  }
  
  public void hideDelay(long paramLong)
  {
    if (this.hidden) {
      return;
    }
    removeHideDelay();
    this.hideDelay = new QMTips.13(this);
    Threads.runOnMainThread(this.hideDelay, paramLong);
  }
  
  public void hideDialog()
  {
    Threads.runOnMainThread(new QMTips.11(this));
  }
  
  public void hideWithoutCallback()
  {
    setCallback(new QMTips.15(this, getCallback()));
    hide();
  }
  
  public boolean isCanceledOnTouchOutside()
  {
    return this.canceledOnTouchOutside;
  }
  
  public boolean isCanceledWithBackKey()
  {
    return this.canceledWithBackKey;
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public void onBackKeyDown(QMTipsDialog paramQMTipsDialog)
  {
    if (this.canceledWithBackKey)
    {
      this.hasBackKeyPressed = true;
      if (this.callback != null) {
        this.callback.onCancel(this);
      }
      if (this.hasBackKeyPressed) {
        handleHide();
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.callback != null) {
      this.callback.onHide(this);
    }
  }
  
  public void recycle()
  {
    Threads.runOnMainThread(new QMTips.14(this));
  }
  
  public void setCallback(QMTipsCallback paramQMTipsCallback)
  {
    this.callback = paramQMTipsCallback;
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    this.canceledOnTouchOutside = paramBoolean;
    this.dialog.setCanceledOnTouchOutside(paramBoolean);
  }
  
  public void setCanceledWithBackKey(boolean paramBoolean)
  {
    this.canceledWithBackKey = paramBoolean;
    this.canceledWithBackKey = paramBoolean;
    this.dialog.setCancelable(paramBoolean);
  }
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void showError(int paramInt)
  {
    showError(this.context.getString(paramInt));
  }
  
  public void showError(int paramInt, long paramLong)
  {
    showError(this.context.getString(paramInt, new Object[] { Long.valueOf(paramLong) }));
  }
  
  public void showError(String paramString)
  {
    showError(paramString, 0L);
  }
  
  public void showError(String paramString, long paramLong)
  {
    Threads.runOnMainThread(new QMTips.10(this, paramString, paramLong));
  }
  
  public void showInfo(int paramInt)
  {
    showInfo(this.context.getString(paramInt));
  }
  
  public void showInfo(String paramString)
  {
    Threads.runOnMainThread(new QMTips.5(this, paramString));
  }
  
  public void showInfo(String paramString, long paramLong)
  {
    Threads.runOnMainThread(new QMTips.6(this, paramString, paramLong));
  }
  
  public void showInfo(String paramString, QMCompleteCallback paramQMCompleteCallback)
  {
    Threads.runOnMainThread(new QMTips.4(this, paramString));
  }
  
  public void showLoading(int paramInt)
  {
    showLoading(this.context.getString(paramInt), null);
  }
  
  public void showLoading(String paramString)
  {
    showLoading(paramString, null);
  }
  
  public void showLoading(String paramString1, String paramString2)
  {
    Threads.runOnMainThread(new QMTips.8(this, paramString1, paramString2));
  }
  
  public void showSuccess(int paramInt)
  {
    showSuccess(this.context.getString(paramInt));
  }
  
  public void showSuccess(int paramInt, long paramLong)
  {
    showSuccess(this.context.getString(paramInt), paramLong);
  }
  
  public void showSuccess(String paramString)
  {
    showSuccess(paramString, 0L);
  }
  
  public void showSuccess(String paramString, long paramLong)
  {
    Threads.runOnMainThread(new QMTips.9(this, paramString, paramLong));
  }
  
  public void showUpload(QMTipsCallback paramQMTipsCallback)
  {
    this.callback = paramQMTipsCallback;
    Threads.runOnMainThread(new QMTips.1(this));
  }
  
  public void showUploadFile(QMTipsCallback paramQMTipsCallback)
  {
    this.callback = paramQMTipsCallback;
    Threads.runOnMainThread(new QMTips.2(this));
  }
  
  public void updateLoadingInfo(String paramString)
  {
    Threads.runOnMainThread(new QMTips.7(this, paramString));
  }
  
  public void updateUploadImageProcess(int paramInt)
  {
    updateUploadMessage("照片上传中 " + paramInt + "%");
  }
  
  public void updateUploadMessage(String paramString)
  {
    Threads.runOnMainThread(new QMTips.3(this, paramString));
  }
  
  public void updateUploadScanFileProcess(int paramInt)
  {
    updateUploadMessage("文件上传中 " + paramInt + "%");
  }
  
  public static abstract interface QMCompleteCallback
  {
    public abstract void done();
  }
  
  public static abstract class QMTipsCallback
  {
    public void onCancel(QMTips paramQMTips) {}
    
    public void onHide(QMTips paramQMTips) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips
 * JD-Core Version:    0.7.0.1
 */