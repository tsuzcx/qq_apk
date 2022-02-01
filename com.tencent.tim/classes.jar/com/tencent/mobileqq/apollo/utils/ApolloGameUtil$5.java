package com.tencent.mobileqq.apollo.utils;

import abxk;
import android.text.TextUtils;
import aqrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ApolloGameUtil$5
  implements Runnable
{
  ApolloGameUtil$5(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    if (this.val$appInterface == null) {
      QLog.e("ApolloGameUtil", 1, "[highLightGame] app is null");
    }
    abxk localabxk;
    do
    {
      return;
      localabxk = (abxk)this.val$appInterface.getManager(155);
      localObject1 = localabxk.dN();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      localObject2 = (ApolloGameRoamData)((List)localObject1).get(0);
    } while ((localObject2 != null) && (((ApolloGameRoamData)localObject2).gameId == this.val$gameId));
    Object localObject1 = new LinkedList((Collection)localObject1);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    int i = 0;
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ApolloGameRoamData)((Iterator)localObject2).next();
      if ((localObject3 != null) && (!TextUtils.isEmpty(((ApolloGameRoamData)localObject3).tagUrl))) {}
    }
    else
    {
      localObject2 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ApolloGameRoamData)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((ApolloGameRoamData)localObject3).gameId == this.val$gameId))
        {
          ((LinkedList)localObject1).remove(localObject3);
          if (!TextUtils.isEmpty(((ApolloGameRoamData)localObject3).tagUrl)) {
            break label327;
          }
        }
      }
    }
    for (;;)
    {
      ((LinkedList)localObject1).add(i, localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "[highLightGame] ", Integer.valueOf(this.val$gameId) });
      }
      localObject1 = new ArrayList((Collection)localObject1);
      localObject2 = new int[((ArrayList)localObject1).size()];
      localObject3 = ((ArrayList)localObject1).iterator();
      i = j;
      while (((Iterator)localObject3).hasNext())
      {
        ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)((Iterator)localObject3).next();
        localObject2[i] = localApolloGameRoamData.gameId;
        i += 1;
        localApolloGameRoamData.setStatus(1000);
      }
      i += 1;
      break;
      label327:
      i = 0;
    }
    if (this.bGn) {
      ((aqrb)this.val$appInterface.getBusinessHandler(71)).a(this.val$appInterface, (int[])localObject2);
    }
    localabxk.cGb();
    localabxk.dw((ArrayList)localObject1);
    ApolloGameUtil.cGk();
    return;
    QLog.e("ApolloGameUtil", 1, "[highLightGame] no game in list");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.5
 * JD-Core Version:    0.7.0.1
 */