package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aqgm;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

class PendantInfo$2
  implements Runnable
{
  PendantInfo$2(PendantInfo paramPendantInfo, int paramInt, long paramLong, Drawable paramDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    Object localObject = aqgm.m(this.this$0.atD, this.ebZ);
    if (2 == this.ebZ) {
      localObject = aqgm.m(this.this$0.atD, 8);
    }
    if (aqhq.fileExists((String)localObject))
    {
      if (2 == this.ebZ)
      {
        this.this$0.eeX();
        if (this.this$0.cA == null) {
          this.this$0.aw(this.ebZ, this.atE);
        }
        label248:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((this.this$0.mType == -1) || (this.this$0.ebY == -1)) {
                  break;
                }
              } while ((this.this$0.mType == 0) || (this.this$0.b == null));
              localObject = this.this$0.b.obtainMessage(20);
            } while (!PendantInfo.a((Message)localObject, this.atE));
            this.this$0.b.sendMessage((Message)localObject);
            return;
            localObject = new File(aqgm.m(this.this$0.atD, 4));
            if (this.this$0.a((File)localObject, this.ebZ) > -1) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label295;
              }
              if (this.this$0.mType != 0) {
                break label248;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PendantInfo", 2, "static type request dynamic resources");
              return;
            }
          } while (this.this$0.b == null);
          localObject = this.this$0.b.obtainMessage(20);
        } while (!PendantInfo.a((Message)localObject, this.atE));
        this.this$0.b.sendMessage((Message)localObject);
        return;
        label295:
        this.this$0.aw(this.ebZ, this.atE);
        return;
      }
      this.this$0.a(this.fS, false, this.atE);
      return;
    }
    this.this$0.aw(this.ebZ, this.atE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.2
 * JD-Core Version:    0.7.0.1
 */