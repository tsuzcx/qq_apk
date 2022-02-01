package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import ikk;
import iwu;

public class EffectPendantTips$3
  implements Runnable
{
  public EffectPendantTips$3(ikk paramikk, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.aof != 0)
      {
        String str = this.this$0.c(ikk.a(this.this$0), this.aof);
        if (!TextUtils.isEmpty(str)) {
          iwu.a(ikk.a(this.this$0), 1016, str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTips.3
 * JD-Core Version:    0.7.0.1
 */