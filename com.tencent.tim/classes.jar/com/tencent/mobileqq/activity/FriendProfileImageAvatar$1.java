package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import vbg;
import vbi.b;

public class FriendProfileImageAvatar$1
  implements Runnable
{
  public FriendProfileImageAvatar$1(vbg paramvbg, vbi.b paramb) {}
  
  public void run()
  {
    localEntityManager = this.this$0.app.a().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      Setting localSetting = (Setting)localEntityManager.find(Setting.class, this.b.toUin);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localEntityManager.update(localSetting);
        this.this$0.app.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localEntityManager.close();
      }
    }
    finally
    {
      localEntityManager.close();
    }
    this.this$0.app.EH(this.this$0.toUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */