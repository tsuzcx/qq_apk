package com.tencent.mobileqq.model;

import ajdg;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$9
  implements Runnable
{
  public EmoticonManager$9(ajdg paramajdg, Emoticon paramEmoticon) {}
  
  public void run()
  {
    ajdg.a(this.this$0, this.a);
    if (!ajdg.a(this.this$0, this.a)) {
      QLog.e("EmoticonManager", 1, "saveEmoticon fail epId = " + this.a.epId + ", eId = " + this.a.eId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.9
 * JD-Core Version:    0.7.0.1
 */