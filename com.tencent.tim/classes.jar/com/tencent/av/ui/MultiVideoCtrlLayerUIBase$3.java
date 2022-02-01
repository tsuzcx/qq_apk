package com.tencent.av.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$3
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$3(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if ((this.this$0.mRootView == null) || (this.this$0.mZ == null) || (this.this$0.mRes == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.this$0.TAG, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
      }
      return;
    }
    int i = this.this$0.mRes.getDimensionPixelSize(2131299740);
    this.this$0.mZ.setMaxWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.3
 * JD-Core Version:    0.7.0.1
 */