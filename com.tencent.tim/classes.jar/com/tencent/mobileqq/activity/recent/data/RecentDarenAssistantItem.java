package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import anov;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class RecentDarenAssistantItem
  extends RecentMsgBoxItem
{
  private boolean mIsHasReportExp;
  
  public RecentDarenAssistantItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.c(paramQQAppInterface, paramContext);
    this.mTitleName = BaseApplicationImpl.getContext().getString(2131696057);
    if (!this.mIsHasReportExp)
    {
      this.mIsHasReportExp = true;
      new anov(null).a("dc00899").b("grp_lbs").c("vip_tips").d("exp").report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentDarenAssistantItem
 * JD-Core Version:    0.7.0.1
 */