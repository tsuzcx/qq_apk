package com.tencent.mobileqq.emosm;

import acbn;
import acfi;
import afgn;
import afhu;
import afhv;
import afpg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavRoamingStrategy$3
  implements Runnable
{
  public FavRoamingStrategy$3(afgn paramafgn, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (afhu)this.this$0.app.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-1 from doDelete.");
    }
    Object localObject2 = ((afhu)localObject1).ez();
    if (localObject2 != null)
    {
      int i = 1;
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= ((List)localObject2).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject2).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
        i = j;
      }
    }
    int j = 1;
    localObject2 = new ArrayList();
    Iterator localIterator = this.this$0.zx.iterator();
    while (localIterator.hasNext())
    {
      afpg localafpg = (afpg)localIterator.next();
      if (!this.zD.contains(localafpg))
      {
        CustomEmotionData localCustomEmotionData = new CustomEmotionData();
        localCustomEmotionData.uin = this.this$0.app.getCurrentAccountUin();
        localCustomEmotionData.url = localafpg.path;
        localCustomEmotionData.eId = localafpg.eId;
        localCustomEmotionData.md5 = localafpg.action;
        j += 1;
        localCustomEmotionData.emoId = j;
        localCustomEmotionData.emoPath = (acbn.bmd + acfi.jj(localafpg.path));
        ((afhu)localObject1).c(localCustomEmotionData);
        ((List)localObject2).add(localCustomEmotionData);
      }
    }
    localObject1 = (afhv)this.this$0.app.getManager(103);
    if ((localObject1 != null) && (!((List)localObject2).isEmpty())) {
      ((afhv)localObject1).kj((List)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */