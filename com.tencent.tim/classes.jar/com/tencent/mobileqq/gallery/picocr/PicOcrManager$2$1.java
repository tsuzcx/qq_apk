package com.tencent.mobileqq.gallery.picocr;

import ahqt.a;
import ahqv;
import aqhq;
import com.tencent.qphone.base.util.QLog;

public class PicOcrManager$2$1
  implements Runnable
{
  public PicOcrManager$2$1(ahqv paramahqv) {}
  
  public void run()
  {
    aqhq.deleteFile(this.a.b.compressPath);
    if (QLog.isColorLevel()) {
      QLog.d("PicOcrManager", 2, "clear path!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.2.1
 * JD-Core Version:    0.7.0.1
 */