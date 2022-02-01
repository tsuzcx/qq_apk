package com.tencent.mobileqq.multicard;

import ajjz;
import ajjz.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class MultiCardManager$1
  implements Runnable
{
  public MultiCardManager$1(ajjz paramajjz, ArrayList paramArrayList, long paramLong, ajjz.b paramb) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap(50);
    Object localObject2;
    if (this.ef != null)
    {
      localObject1 = (TroopManager)ajjz.a(this.this$0).getManager(52);
      localObject2 = this.ef.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        String str = ((TroopManager)localObject1).getTroopMemberName(this.Bf + "", localLong + "");
        if (str != null) {
          localHashMap.put(localLong, str);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("callbackWithNativeMemberNick ").append(this.Bf).append(" ");
      if (localHashMap == null) {
        break label217;
      }
    }
    label217:
    for (Object localObject1 = localHashMap.size() + localHashMap.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      ThreadManager.getUIHandler().post(new MultiCardManager.1.1(this, localHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.1
 * JD-Core Version:    0.7.0.1
 */