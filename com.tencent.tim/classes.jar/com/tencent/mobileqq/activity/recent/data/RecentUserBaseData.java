package com.tencent.mobileqq.activity.recent.data;

import aamh.a;
import ajpd;
import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.RecentUser;

public abstract class RecentUserBaseData
  extends RecentBaseData
{
  protected static final String DES_DEFAULT_HAVE_MSG = "%s,%s,%d条未读,%s";
  protected static final String DES_DEFAULT_NO_MSG = "%s,%s,%s";
  @aamh.a
  public RecentUser mUser;
  
  public RecentUserBaseData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    if (paramRecentUser == null) {
      throw new NullPointerException("RecentUser is null");
    }
    this.mUser = paramRecentUser;
    switch (this.mUser.getType())
    {
    default: 
      cvo();
      this.mMenuFlag &= 0xFFFFFF0F;
      if (this.mUser.showUpTime != 0L) {
        break;
      }
    }
    for (this.mMenuFlag |= 0x10;; this.mMenuFlag |= 0x20)
    {
      this.mMenuFlag &= 0xF0FFFFFF;
      if (this.mUser.isHiddenChat == 1) {
        this.mMenuFlag |= 0x1000000;
      }
      return;
      this.mMenuFlag |= 0x1000;
      break;
      this.mMenuFlag |= 0x2000;
      break;
    }
  }
  
  public final boolean Gq()
  {
    return (this.mUnreadFlag == 1) || (this.mUnreadFlag == 4);
  }
  
  public RecentUser a()
  {
    return this.mUser;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mMsgExtroInfo = "";
    this.mMenuFlag &= 0xFFFFFF0F;
    int i;
    if ((this.mUser.getType() == 1) && (!ajpd.d(paramQQAppInterface, this.mUser)))
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      int j = this.mMenuFlag;
      if (paramQQAppInterface.kv(this.mUser.uin))
      {
        i = 32;
        this.mMenuFlag = (i | j);
      }
    }
    for (;;)
    {
      this.mMenuFlag &= 0xF0FFFFFF;
      if (this.mUser.isHiddenChat == 1) {
        this.mMenuFlag |= 0x1000000;
      }
      return;
      i = 16;
      break;
      FriendsStatusUtil.b(paramQQAppInterface, this.mUser);
      if ((this.mUser.showUpTime == 0L) && (9223372036854775807L - this.mUser.lastmsgtime > 4L)) {
        this.mMenuFlag |= 0x10;
      } else {
        this.mMenuFlag |= 0x20;
      }
    }
  }
  
  public void cvo()
  {
    switch (this.mUser.getType())
    {
    }
    do
    {
      return;
    } while (!Gq());
    this.mMenuFlag &= 0xFFF0FFFF;
    if (this.mUnreadNum != 0)
    {
      this.mMenuFlag |= 0x10000;
      return;
    }
    this.mMenuFlag |= 0x20000;
  }
  
  public void d(RecentUser paramRecentUser)
  {
    this.mUser = paramRecentUser;
  }
  
  public long eI()
  {
    return this.mUser.lastmsgtime;
  }
  
  public long eJ()
  {
    return this.mUser.lastmsgdrafttime;
  }
  
  public int ng()
  {
    return this.mUser.getType();
  }
  
  public String qx()
  {
    return this.mUser.uin;
  }
  
  public String qz()
  {
    return this.mUser.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentUserBaseData
 * JD-Core Version:    0.7.0.1
 */