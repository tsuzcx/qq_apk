package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import aqgv;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemQCallData
  extends RecentUserBaseData
{
  public RecentItemQCallData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mTitleName = aqgv.b(paramQQAppInterface, this.mUser.uin, true);
    this.mDisplayTime = this.mUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, this.msgSummary);
    super.c(paramQQAppInterface, paramContext);
    if (AppSetting.enableTalkBack)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.mTitleName).append(",");
      if (this.mUnreadNum != 0) {
        break label142;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      label142:
      if (this.mUnreadNum == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读,");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemQCallData
 * JD-Core Version:    0.7.0.1
 */