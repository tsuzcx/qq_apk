package com.tencent.mobileqq.multiaio.presenter;

import ajhz;
import ajil;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MultiAioContext$1
  implements Runnable
{
  public MultiAioContext$1(ajil paramajil, FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = ajhz.a(this.b, this.val$app, this.bRz, this.djk, this.bRA, this.bRB);
    if (((List)localObject1).size() > 0) {
      ThreadManager.getSubThreadHandler().postDelayed(new MultiAioContext.1.1(this), 100L);
    }
    ajil.a(this.this$0, (List)localObject1);
    QQMessageFacade localQQMessageFacade = this.val$app.b();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (RecentBaseData)((Iterator)localObject1).next();
      if ((localObject2 instanceof RecentUserBaseData))
      {
        localObject2 = ((RecentUserBaseData)localObject2).a();
        localQQMessageFacade.j(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType(), 8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.presenter.MultiAioContext.1
 * JD-Core Version:    0.7.0.1
 */