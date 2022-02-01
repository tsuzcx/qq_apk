package com.tencent.biz.subscribe.utils;

import android.text.TextUtils;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.util.Pair;
import oba;
import shg;
import shg.a;

public class SubscribeDraftManager$3
  implements Runnable
{
  public void run()
  {
    Object localObject = shg.a(this.this$0, this.val$uin, this.aEf);
    if (localObject != null)
    {
      localObject = shg.a(this.this$0, (String)((Pair)localObject).second);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label90;
      }
      localObject = (SubscribeDraftBean)oba.a().fromJson((String)localObject, SubscribeDraftBean.class);
      if ((localObject != null) && (this.a != null)) {
        this.a.b(5, true, this.aEf, new Object[] { localObject });
      }
    }
    label90:
    while (this.a == null) {
      return;
    }
    this.a.b(5, false, this.aEf, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.3
 * JD-Core Version:    0.7.0.1
 */