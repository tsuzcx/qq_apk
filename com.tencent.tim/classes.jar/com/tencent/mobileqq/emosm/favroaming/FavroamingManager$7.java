package com.tencent.mobileqq.emosm.favroaming;

import afhv;
import aooi;
import aool;
import aqhq;
import aquz;
import aqva;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FavroamingManager$7
  implements Runnable
{
  public FavroamingManager$7(afhv paramafhv, String[] paramArrayOfString, aool paramaool) {}
  
  public void run()
  {
    if (!aqhq.fileExists(this.eY[1]))
    {
      Object localObject = new File(this.eY[1]);
      localObject = new aquz(this.eY[0], (File)localObject);
      ((aquz)localObject).cWw = true;
      if (aqva.a((aquz)localObject, afhv.o(this.this$0)) != 0) {
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.eY[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */