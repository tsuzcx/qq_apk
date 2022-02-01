package com.tencent.mobileqq.activity.recent.data;

import aale;
import aevk;
import altq;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import nyn;
import obt;

public class RecentItemServiceAccountFolderData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemServiceAccountFolderData";
  private static int tryResetServiceAccountFolderDeleteFlag;
  public String mReportKeyBytesOacMsgxtend;
  
  public RecentItemServiceAccountFolderData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    this.mUnreadFlag = 0;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    boolean bool = obt.adT;
    label35:
    nyn localnyn;
    if (bool)
    {
      this.mMenuFlag |= 0x1;
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + ", canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag);
      }
      localnyn = nyn.a();
      this.mTitleName = nyn.d(paramQQAppInterface);
      this.mDisplayTime = localnyn.c(paramQQAppInterface);
      this.mUnreadNum = localnyn.rc();
      Manager localManager = paramQQAppInterface.getManager(36);
      if ((localManager instanceof altq))
      {
        int i = ((altq)localManager).ag("104000.104001", 100);
        if (i > 0) {
          this.mUnreadNum += i;
        }
        QLog.d("RecentItemServiceAccountFolderData", 2, "uin:" + paramQQAppInterface.getCurrentUin() + "getSubscribeAccountRedDotNum  numRedNumByAppIdAndMsgType:" + i + "   mUnreadNum: " + this.mUnreadNum);
      }
      if (this.mUnreadNum > 0) {
        break label665;
      }
      if ((!localnyn.Gr()) || (this.mDisplayTime <= localnyn.jdMethod_do())) {
        break label657;
      }
      this.mUnreadFlag = 2;
      this.mUnreadNum = 1;
      label253:
      if (this.mDisplayTime == 0L) {
        break label673;
      }
      this.mShowTime = aale.a().t(qx(), this.mDisplayTime);
      label280:
      this.mReportKeyBytesOacMsgxtend = localnyn.kS();
      this.mLastMsg = localnyn.a(paramQQAppInterface);
      if (!localnyn.Gs()) {
        break label686;
      }
      this.mStatus = 4;
      label312:
      if ((this.mUnreadNum <= 0) || (this.mUnreadFlag != 1)) {
        break label694;
      }
      this.mMsgExtroInfo = localnyn.kT();
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
    }
    for (;;)
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
      QLog.d("RecentItemServiceAccountFolderData", 2, "mTitleName:" + this.mTitleName + ", mDisplayTime:" + this.mDisplayTime + ", mUnreadNum:" + this.mUnreadNum + ", mUnreadFlag:" + this.mUnreadFlag + ", mShowTime:" + this.mShowTime + ", mStatus:" + this.mStatus + ", mMsgExtroInfo:" + this.mMsgExtroInfo + ", mExtraInfoColor:" + this.mExtraInfoColor + ", mLastMsg:" + this.mLastMsg);
      return;
      this.mMenuFlag &= 0xFFFFFFFE;
      if (tryResetServiceAccountFolderDeleteFlag >= 3) {
        break label35;
      }
      QLog.d("RecentItemServiceAccountFolderData", 1, "canDelete:" + bool + ", mMenuFlag:" + this.mMenuFlag + " tryResetServiceAccountFolderDeleteFlag = " + tryResetServiceAccountFolderDeleteFlag);
      aevk.Z(paramQQAppInterface, paramQQAppInterface.getCurrentUin());
      tryResetServiceAccountFolderDeleteFlag += 1;
      break label35;
      label657:
      this.mUnreadFlag = 0;
      break label253;
      label665:
      this.mUnreadFlag = 1;
      break label253;
      label673:
      this.mShowTime = localnyn.e(paramQQAppInterface);
      break label280;
      label686:
      this.mStatus = 0;
      break label312;
      label694:
      this.mMsgExtroInfo = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData
 * JD-Core Version:    0.7.0.1
 */