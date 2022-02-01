package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import jxl;
import obt;

public class RecentItemPublicAccountADFolderData
  extends RecentItemPublicAccountChatMsgData
{
  private static final String TAG = "RecentItemPublicAccountADFolderData";
  public String trueUin = "";
  
  public RecentItemPublicAccountADFolderData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.mUnreadFlag = 1;
    this.trueUin = jxl.a().dY(paramRecentUser.uin);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    paramQQAppInterface = paramQQAppInterface.b();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(this.mUser.uin, this.mUser.getType());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_uin");
        paramQQAppInterface = paramQQAppInterface.getExtInfoFromExtStr("recent_list_advertisement_message_name");
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          this.mTitleName = paramQQAppInterface;
        }
      }
    }
    if (this.mUnreadNum > 0) {
      this.mUnreadNum = 1;
    }
    if (obt.adT) {}
    for (this.mMenuFlag |= 0x1;; this.mMenuFlag &= 0xFFFFFFFE)
    {
      if (AppSetting.enableTalkBack)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.mTitleName).append(",");
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentItemPublicAccountADFolderData", 2, "mTitleName:" + this.mTitleName + ", mDisplayTime:" + this.mDisplayTime + ", mUnreadNum:" + this.mUnreadNum + ", mUnreadFlag:" + this.mUnreadFlag + ", mShowTime:" + this.mShowTime + ", mStatus:" + this.mStatus + ", mMsgExtroInfo:" + this.mMsgExtroInfo + ", mExtraInfoColor:" + this.mExtraInfoColor + ", mLastMsg:" + this.mLastMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData
 * JD-Core Version:    0.7.0.1
 */