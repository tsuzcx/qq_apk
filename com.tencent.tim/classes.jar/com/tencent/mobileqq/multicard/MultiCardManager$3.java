package com.tencent.mobileqq.multicard;

import ajjz;
import ajjz.c;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MultiCardManager$3
  implements Runnable
{
  public MultiCardManager$3(ajjz paramajjz, long paramLong, ajjz.c paramc) {}
  
  public void run()
  {
    ArrayList localArrayList = ajjz.a(this.this$0, this.Bf);
    if (localArrayList != null) {}
    for (;;)
    {
      synchronized (ajjz.a(this.this$0))
      {
        ajjz.a(this.this$0).put(Long.valueOf(this.Bf), (ArrayList)localArrayList.clone());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("callbackWithNativeUinList ").append(this.Bf).append(" ");
          if (localArrayList != null)
          {
            ??? = localArrayList.toString();
            QLog.d("MultiCardManager", 2, (String)???);
          }
        }
        else
        {
          ThreadManager.getUIHandler().post(new MultiCardManager.3.1(this, localArrayList));
          return;
        }
      }
      ??? = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.3
 * JD-Core Version:    0.7.0.1
 */