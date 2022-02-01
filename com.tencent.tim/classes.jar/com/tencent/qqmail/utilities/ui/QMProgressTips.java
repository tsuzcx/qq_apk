package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.qmui.dialog.QMUITipDialog;
import com.tencent.qqmail.qmui.dialog.QMUITipDialog.CustomBuilder;

public class QMProgressTips
{
  private QMTips.QMTipsCallback callback;
  private double mProgress = 0.0D;
  private TextView mSaveBigAttachProgressTv;
  private QMUITipDialog mTipDialog;
  
  public QMProgressTips(Context paramContext)
  {
    if (this.mTipDialog == null) {
      this.mTipDialog = new QMUITipDialog.CustomBuilder(paramContext).setContent(2131562990).create();
    }
    this.mSaveBigAttachProgressTv = ((TextView)this.mTipDialog.findViewById(2131377633));
    updateProgress(0.0D);
    this.mTipDialog.findViewById(2131364677).setOnClickListener(new QMProgressTips.1(this));
    this.mTipDialog.setOnDismissListener(new QMProgressTips.2(this));
  }
  
  public void dismiss()
  {
    this.mTipDialog.dismiss();
  }
  
  public QMTips.QMTipsCallback getCallback()
  {
    return this.callback;
  }
  
  public double getProgress()
  {
    return this.mProgress;
  }
  
  public void setCallback(QMTips.QMTipsCallback paramQMTipsCallback)
  {
    this.callback = paramQMTipsCallback;
  }
  
  public void showDialog()
  {
    if (this.mTipDialog != null) {
      this.mTipDialog.show();
    }
  }
  
  public void updateProgress(double paramDouble)
  {
    this.mProgress = paramDouble;
    if (this.mTipDialog == null) {}
    int i;
    do
    {
      return;
      i = (int)(100.0D * paramDouble);
      if (i >= 100)
      {
        this.mTipDialog.dismiss();
        return;
      }
    } while (this.mSaveBigAttachProgressTv == null);
    this.mSaveBigAttachProgressTv.setText(String.format("正在保存 %1$s%%", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMProgressTips
 * JD-Core Version:    0.7.0.1
 */