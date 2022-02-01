package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemRecommendTroopData
  extends RecentUserBaseData
{
  public RecentItemRecommendTroopData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.c(paramQQAppInterface, paramContext);
    if (a().uin.equals("sp_uin_for_title"))
    {
      this.mMenuFlag = 0;
      return;
    }
    this.mMenuFlag = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData
 * JD-Core Version:    0.7.0.1
 */