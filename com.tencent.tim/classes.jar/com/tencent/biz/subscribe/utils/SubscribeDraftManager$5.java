package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.util.Pair;
import shg;
import shg.a;

public class SubscribeDraftManager$5
  implements Runnable
{
  public SubscribeDraftManager$5(shg paramshg, String paramString1, String paramString2, shg.a parama) {}
  
  public void run()
  {
    Object localObject = shg.a(this.this$0, this.val$uin, this.aEf);
    if (localObject != null)
    {
      localObject = shg.a(this.this$0, (String)((Pair)localObject).first);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label74;
      }
      if (this.a != null) {
        this.a.b(6, true, this.aEf, new Object[] { localObject });
      }
    }
    label74:
    while (this.a == null) {
      return;
    }
    this.a.b(6, false, this.aEf, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.5
 * JD-Core Version:    0.7.0.1
 */