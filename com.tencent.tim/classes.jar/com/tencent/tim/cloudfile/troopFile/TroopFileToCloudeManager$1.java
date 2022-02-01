package com.tencent.tim.cloudfile.troopFile;

import acxw;
import android.content.SharedPreferences;
import atmv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class TroopFileToCloudeManager$1
  implements Runnable
{
  public void run()
  {
    atmv.a(this.this$0, false);
    ??? = atmv.a(this.this$0).getApplication().getSharedPreferences(atmv.a(this.this$0).getCurrentAccountUin(), 0);
    if (((SharedPreferences)???).getBoolean("tim_cloudfile_autosave_flag", true)) {
      atmv.a(this.this$0, true);
    }
    if (!atmv.a(this.this$0)) {
      return;
    }
    long l = ((SharedPreferences)???).getLong("cloud_key_last_get_list_time", 0L);
    if (NetConnInfoCenter.getServerTime() - l < 86400000L)
    {
      QLog.i("TroopFileToCloudeManager.TroopAutoSaveToCloud", 1, "getList less than one day, so retry faild record!");
      atmv.a(this.this$0).euf();
      return;
    }
    Object localObject2 = atmv.a(this.this$0).a().a().q(false);
    ??? = new ArrayList();
    RecentUser localRecentUser;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser.getType() == 1) {
          ((List)???).add(localRecentUser);
        }
      }
    }
    if (((List)???).size() == 0)
    {
      QLog.w("TroopFileToCloudeManager.TroopAutoSaveToCloud", 1, "can't find troop AIO,return!");
      return;
    }
    localObject2 = ((List)???).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label372;
      }
      localRecentUser = (RecentUser)((Iterator)localObject2).next();
      try
      {
        synchronized (this.this$0)
        {
          l = Long.parseLong(localRecentUser.uin);
          boolean bool = atmv.a(this.this$0).containsKey(Long.valueOf(l));
          if (!bool) {}
        }
        atmv.a(this.this$0).put(Long.valueOf(l), new AutoProcessFileListTask(atmv.a(this.this$0), l, this.this$0));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          QLog.e("TroopFileToCloudeManager.TroopAutoSaveToCloud", 1, localException.toString());
        }
      }
    }
    label372:
    synchronized (this.this$0)
    {
      if (atmv.a(this.this$0).keySet().size() > 0)
      {
        l = ((Long)atmv.a(this.this$0).keySet().iterator().next()).longValue();
        ((AutoProcessFileListTask)atmv.a(this.this$0).get(Long.valueOf(l))).run();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.TroopFileToCloudeManager.1
 * JD-Core Version:    0.7.0.1
 */