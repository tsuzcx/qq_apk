package com.tencent.mobileqq.activity.recent.data;

import acbn;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anxk;
import aqgv;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public String showSubUin;
  
  public RecentItemSubAccount(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label172:
    do
    {
      return;
      super.c(paramQQAppInterface, paramContext);
      MsgSummary localMsgSummary = a();
      if (!acbn.bku.equals(this.mUser.uin)) {
        break;
      }
      this.mTitleName = paramContext.getString(2131720509);
      this.mUnreadNum = 0;
      anxk.a(paramQQAppInterface, paramContext, this, localMsgSummary);
      if (!TextUtils.isEmpty(localMsgSummary.strContent)) {
        localMsgSummary.mEmojiFlag = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.mUser.uin + " mUser.type=" + this.mUser.getType() + " mUnreadNum=" + this.mUnreadNum + " mUnreadFlag=" + this.mUnreadFlag);
      }
      if (TextUtils.isEmpty(this.mMsgExtroInfo)) {
        break label377;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      this.mShowTime = "";
      this.mDisplayTime = eI();
      bI(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, localMsgSummary);
    } while (!AppSetting.enableTalkBack);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.mTitleName).append(",");
    if (this.mUnreadNum == 0) {}
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        paramQQAppInterface.append(this.mMsgExtroInfo + ",");
      }
      paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      this.mContentDesc = paramQQAppInterface.toString();
      return;
      this.mTitleName = aqgv.c(paramQQAppInterface, this.mUser.uin, true);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mUser.uin;
      }
      this.mTitleName = (paramContext.getString(2131720542) + "（" + this.mTitleName + "）");
      break;
      label377:
      this.mMsgExtroInfo = "";
      this.mExtraInfoColor = 0;
      break label172;
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */