package com.tencent.mobileqq.emoticonview;

import afnh;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelMallHelper$7
  implements Runnable
{
  public EmoticonPanelMallHelper$7(afnh paramafnh, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!this.this$0.a.zY.contains(this.c)) {
      this.this$0.a.zY.add(this.c);
    }
    this.this$0.a.bZi = true;
    this.this$0.a.b().bZe = false;
    if (this.this$0.a.b().getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "refresh magic emoji.");
      }
      this.this$0.a.MC(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7
 * JD-Core Version:    0.7.0.1
 */