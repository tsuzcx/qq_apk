package com.tencent.mobileqq.vas;

import android.os.Handler;
import aqpm;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class ColorNickManager$2
  implements Runnable
{
  public ColorNickManager$2(aqpm paramaqpm, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(aqpm.pP(String.valueOf(this.val$id)));
    if (((File)localObject).exists())
    {
      localObject = aqpm.a(this.this$0, (File)localObject, this.val$id);
      if (localObject != null)
      {
        this.this$0.jd.put(Integer.valueOf(this.val$id), localObject);
        if (this.this$0.dK != null) {
          this.this$0.dK.sendEmptyMessage(258);
        }
      }
      return;
    }
    aqpm.a(this.this$0, this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.2
 * JD-Core Version:    0.7.0.1
 */