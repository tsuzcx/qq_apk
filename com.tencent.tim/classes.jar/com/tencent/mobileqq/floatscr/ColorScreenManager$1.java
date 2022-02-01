package com.tencent.mobileqq.floatscr;

import aher;
import ahes;
import aqrg.a;
import com.tencent.qphone.base.util.QLog;

public class ColorScreenManager$1
  implements Runnable
{
  public ColorScreenManager$1(ahes paramahes, int paramInt, aqrg.a parama) {}
  
  public void run()
  {
    String str = "colorScreen.android." + this.val$id;
    this.this$0.a(str, this.a, null);
    aher localaher = this.this$0.a(this.val$id);
    if (localaher == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      this.this$0.OZ(this.val$id);
      return;
    }
    this.this$0.A(str, localaher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.ColorScreenManager.1
 * JD-Core Version:    0.7.0.1
 */