package com.tencent.biz.qqstory.settings;

import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pmb;
import qov;

public class QQStoryShieldListActivity$1$1
  implements Runnable
{
  public QQStoryShieldListActivity$1$1(qov paramqov, List paramList) {}
  
  public void run()
  {
    if (this.a.a.c == null) {}
    for (;;)
    {
      return;
      Object localObject = this.a.a.c;
      if (this.a.a.bnq == 2) {}
      QQStoryUserInfo localQQStoryUserInfo;
      for (boolean bool = true;; bool = false)
      {
        localObject = ((pmb)localObject).f(bool).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
          if (this.a.a.c.em != null) {
            this.a.a.c.em.remove(localQQStoryUserInfo);
          }
        }
      }
      localObject = this.nY.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject).next();
        if (this.a.a.c.em != null) {
          this.a.a.c.em.persistOrReplace(localQQStoryUserInfo);
        }
        if (this.a.a.c.bR != null) {
          this.a.a.c.bR.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity.1.1
 * JD-Core Version:    0.7.0.1
 */