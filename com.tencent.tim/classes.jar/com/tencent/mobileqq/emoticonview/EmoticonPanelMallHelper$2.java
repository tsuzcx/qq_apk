package com.tencent.mobileqq.emoticonview;

import afnh;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelMallHelper$2
  implements Runnable
{
  public EmoticonPanelMallHelper$2(afnh paramafnh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "func updateLastEmoticonPanel begins.");
    }
    if (this.this$0.a.a != null) {
      this.this$0.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2
 * JD-Core Version:    0.7.0.1
 */