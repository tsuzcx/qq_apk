package com.tencent.av.ui;

import android.widget.RelativeLayout;
import aqwu;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import iiv;

class AVActivity$7
  implements Runnable
{
  AVActivity$7(AVActivity paramAVActivity, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.b().state == 4) || (this.this$0.mSessionType != 1) || (this.this$0.Ta) || (this.this$0.dX == null) || (this.this$0.dX.getParent() == null));
      if (this.this$0.b != null) {
        this.this$0.b.avC();
      }
    } while (aqwu.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, this.QY, this.avn, this.this$0.jdField_a_of_type_Aqxa, this.avo, false));
    QLog.e(this.this$0.TAG, 1, "funcall --> play false :" + this.QY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.7
 * JD-Core Version:    0.7.0.1
 */