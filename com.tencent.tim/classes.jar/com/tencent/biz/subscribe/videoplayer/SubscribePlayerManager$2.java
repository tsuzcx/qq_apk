package com.tencent.biz.subscribe.videoplayer;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jqi;
import shq;
import xaf.a;

public class SubscribePlayerManager$2
  implements Runnable
{
  public SubscribePlayerManager$2(shq paramshq) {}
  
  public void run()
  {
    if (jqi.getNetworkType(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    while ((shq.a(this.this$0)) || (shq.a(this.this$0).size() <= 0)) {
      return;
    }
    shq.a(this.this$0, true);
    Object localObject = shq.a(this.this$0).keySet().iterator();
    int i = 0;
    label73:
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (localInteger.intValue() <= i) {
        break label145;
      }
      i = localInteger.intValue();
    }
    label145:
    for (;;)
    {
      break label73;
      localObject = (xaf.a)shq.a(this.this$0).get(Integer.valueOf(i));
      if (localObject == null) {
        break;
      }
      shq.a(this.this$0, (xaf.a)localObject, ((xaf.a)localObject).pos);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2
 * JD-Core Version:    0.7.0.1
 */