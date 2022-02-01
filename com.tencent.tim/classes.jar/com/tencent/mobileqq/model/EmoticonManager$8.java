package com.tencent.mobileqq.model;

import ajdg;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$8
  implements Runnable
{
  public EmoticonManager$8(ajdg paramajdg, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!ajdg.a(this.this$0, this.c)) {
      QLog.e("EmoticonManager", 1, "saveEmoticonPackage fail epId = " + this.c.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.8
 * JD-Core Version:    0.7.0.1
 */