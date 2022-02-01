package com.tencent.mobileqq.activity.richmedia;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class NewPreFlowCamera$2
  implements Runnable
{
  NewPreFlowCamera$2(NewPreFlowCamera paramNewPreFlowCamera, String paramString) {}
  
  public void run()
  {
    this.this$0.Oy.setText(this.bdY);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "setTipsTextData: textData=" + this.bdY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera.2
 * JD-Core Version:    0.7.0.1
 */