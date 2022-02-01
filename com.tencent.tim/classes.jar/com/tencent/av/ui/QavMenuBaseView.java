package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavMenuBaseView
  extends RelativeLayout
{
  public String TAG;
  protected QavPanel b;
  public VideoAppInterface mApp;
  
  public QavMenuBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void K(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onShow, seq[" + paramLong + "], onBegin[" + paramBoolean + "]");
    }
  }
  
  public void L(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onHide, seq[" + paramLong + "], onBegin[" + paramBoolean + "]");
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onCreate, panel[" + paramQavPanel + "]");
    }
    this.b = paramQavPanel;
    if (paramQavPanel != null) {
      this.mApp = paramQavPanel.mApp;
    }
  }
  
  public void onDestroy(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "onDestroy, seq[" + paramLong + "]");
    }
    this.b = null;
    this.mApp = null;
  }
  
  public void refreshUI()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "refreshUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavMenuBaseView
 * JD-Core Version:    0.7.0.1
 */