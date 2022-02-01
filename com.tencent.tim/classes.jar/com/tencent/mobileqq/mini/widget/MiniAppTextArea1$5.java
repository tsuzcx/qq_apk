package com.tencent.mobileqq.mini.widget;

import com.tencent.qphone.base.util.QLog;

class MiniAppTextArea1$5
  implements Runnable
{
  MiniAppTextArea1$5(MiniAppTextArea1 paramMiniAppTextArea1) {}
  
  public void run()
  {
    QLog.d("MiniAppTextArea1", 1, "hideCurrentInput set isFocused false");
    MiniAppTextArea1.access$102(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.5
 * JD-Core Version:    0.7.0.1
 */