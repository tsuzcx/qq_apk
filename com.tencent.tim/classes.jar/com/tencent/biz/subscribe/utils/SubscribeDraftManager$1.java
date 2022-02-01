package com.tencent.biz.subscribe.utils;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import shg;
import shg.a;

public class SubscribeDraftManager$1
  implements Runnable
{
  public SubscribeDraftManager$1(shg paramshg, String paramString1, String paramString2, String paramString3, String paramString4, shg.a parama) {}
  
  public void run()
  {
    Pair localPair = shg.a(this.this$0, this.afw, this.aEf);
    if (localPair != null)
    {
      int i;
      if ((this.this$0.S((String)localPair.first, this.aEg)) && (this.this$0.S((String)localPair.second, this.aEh)))
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        if (this.a != null) {
          this.a.b(3, true, this.aEf, new Object[0]);
        }
      }
      label100:
      do
      {
        return;
        i = 0;
        break;
        aqhq.deleteFile((String)localPair.first);
        aqhq.deleteFile((String)localPair.second);
      } while (this.a == null);
      this.a.b(3, false, this.aEf, new Object[0]);
      return;
    }
    if (this.a != null) {
      this.a.b(3, false, this.aEf, new Object[0]);
    }
    QLog.d(shg.TAG, 4, "modify new draft failed because cat't new folder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */