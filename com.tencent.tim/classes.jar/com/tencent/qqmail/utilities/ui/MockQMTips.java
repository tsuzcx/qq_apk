package com.tencent.qqmail.utilities.ui;

import android.content.DialogInterface;

public class MockQMTips
  extends QMTips
{
  public void dismissTipsManually() {}
  
  public QMTips.QMTipsCallback getCallback()
  {
    return null;
  }
  
  public QMTipsDialog getDialog()
  {
    return null;
  }
  
  public Object getTag()
  {
    return null;
  }
  
  public void hide() {}
  
  public void hideDelay(long paramLong) {}
  
  public void hideDialog() {}
  
  public boolean isCanceledOnTouchOutside()
  {
    return false;
  }
  
  public boolean isCanceledWithBackKey()
  {
    return false;
  }
  
  public boolean isHidden()
  {
    return true;
  }
  
  public void onBackKeyDown(QMTipsDialog paramQMTipsDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void recycle() {}
  
  public void setCallback(QMTips.QMTipsCallback paramQMTipsCallback) {}
  
  public void setCanceledOnTouchOutside(boolean paramBoolean) {}
  
  public void setCanceledWithBackKey(boolean paramBoolean) {}
  
  public void setTag(Object paramObject) {}
  
  public void showError(int paramInt) {}
  
  public void showError(int paramInt, long paramLong) {}
  
  public void showError(String paramString) {}
  
  public void showError(String paramString, long paramLong) {}
  
  public void showInfo(int paramInt) {}
  
  public void showInfo(String paramString) {}
  
  public void showInfo(String paramString, long paramLong) {}
  
  public void showInfo(String paramString, QMTips.QMCompleteCallback paramQMCompleteCallback) {}
  
  public void showLoading(int paramInt) {}
  
  public void showLoading(String paramString) {}
  
  public void showLoading(String paramString1, String paramString2) {}
  
  public void showSuccess(int paramInt) {}
  
  public void showSuccess(int paramInt, long paramLong) {}
  
  public void showSuccess(String paramString) {}
  
  public void showSuccess(String paramString, long paramLong) {}
  
  public void showUpload(QMTips.QMTipsCallback paramQMTipsCallback) {}
  
  public void updateLoadingInfo(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.MockQMTips
 * JD-Core Version:    0.7.0.1
 */