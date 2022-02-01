package com.tencent.mobileqq.gamecenter.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQGamePubAccountFragment$16
  implements Runnable
{
  QQGamePubAccountFragment$16(QQGamePubAccountFragment paramQQGamePubAccountFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.uD.iterator();
    while (localIterator.hasNext())
    {
      WadlResult localWadlResult = (WadlResult)localIterator.next();
      if ((localWadlResult != null) && (localWadlResult.a != null) && (localWadlResult.a.appId.equals(this.this$0.b().gameAppId)) && (localWadlResult.bBa == 6) && (!TextUtils.isEmpty(localWadlResult.aJb)))
      {
        QQGamePubAccountFragment.a(this.this$0).eO(localWadlResult.a.appId, 6);
        QQGamePubAccountFragment.a(this.this$0).KK(localWadlResult.aJb);
        this.this$0.lb.put(localWadlResult.a.appId, localWadlResult.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.16
 * JD-Core Version:    0.7.0.1
 */