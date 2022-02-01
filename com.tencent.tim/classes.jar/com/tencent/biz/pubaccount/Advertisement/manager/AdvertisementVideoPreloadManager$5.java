package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jxo;
import kew;

public class AdvertisementVideoPreloadManager$5
  implements Runnable
{
  public AdvertisementVideoPreloadManager$5(jxo paramjxo, String paramString) {}
  
  public void run()
  {
    synchronized (jxo.a(this.this$0))
    {
      jxo.Log("loadLocalConfigTask uin:" + this.val$uin);
      Object localObject2 = jxo.a(this.this$0);
      if (localObject2 != null)
      {
        localObject2 = ((kew)localObject2).query(PAAdPreloadTask.class, true, "mUserUin = ?", new String[] { this.val$uin }, null, null, "mExpireTime asc", null);
        if (localObject2 != null)
        {
          jxo.a(this.this$0).clear();
          jxo.a(this.this$0).addAll((Collection)localObject2);
          jxo.Log("loadLocalConfigTask taskSize:" + ((List)localObject2).size());
          ThreadManager.executeOnNetWorkThread(new AdvertisementVideoPreloadManager.5.1(this));
        }
      }
      else
      {
        return;
      }
      jxo.Log("loadLocalConfigTask tasklist null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */