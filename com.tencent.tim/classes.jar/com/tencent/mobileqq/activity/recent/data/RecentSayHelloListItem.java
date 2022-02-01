package com.tencent.mobileqq.activity.recent.data;

import afck;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import aofk;
import aqft;
import aqgv;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.qphone.base.util.QLog;
import tog;
import top;

public class RecentSayHelloListItem
  extends RecentBaseData
{
  public int age = -1;
  public int career = -1;
  public boolean charmIcon;
  public int charmLevel;
  public String common;
  public int commonId;
  public int constellation = -1;
  public int gender = -1;
  public boolean haveInitFlag;
  public boolean mHasFlowerMsg;
  MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentSayHelloListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    paramQQAppInterface = paramQQAppInterface.b();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(qx(), ng());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.mDisplayTime > l);
    this.mDisplayTime = l;
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new aofk(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    boolean bool = false;
    if ((this.age != paramFansEntity.age) || (this.gender != paramFansEntity.gender) || (this.career != paramFansEntity.career) || (this.constellation != paramFansEntity.constellation) || (this.vip != paramFansEntity.vip) || (this.charmIcon != paramFansEntity.charmIcon) || (this.charmLevel != paramFansEntity.charmLevel) || (this.commonId != paramFansEntity.commonId) || (!aqft.equalsWithNullCheck(this.common, paramFansEntity.common)))
    {
      this.age = paramFansEntity.age;
      this.gender = paramFansEntity.gender;
      this.career = paramFansEntity.career;
      this.constellation = paramFansEntity.constellation;
      this.vip = paramFansEntity.vip;
      this.charmIcon = paramFansEntity.charmIcon;
      this.haveInitFlag = true;
      this.charmLevel = paramFansEntity.charmLevel;
      this.commonId = paramFansEntity.commonId;
      this.common = paramFansEntity.common;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg_box", 4, "haveChange:" + bool + ",FansEntity:" + paramFansEntity.toString());
    }
    return bool;
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.b();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(qx(), ng());; localObject1 = null)
    {
      label78:
      MsgSummary localMsgSummary;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((tog)localObject2).A(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (top.v((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          localMsgSummary = super.a();
          this.mHasFlowerMsg = false;
          this.mExtraInfoColor = 0;
          this.mMsgExtroInfo = null;
          if (!afck.l(paramQQAppInterface, qx(), 1001)) {
            break label367;
          }
          this.mMsgExtroInfo = paramContext.getResources().getString(2131694637);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
          if (localObject2 != null) {
            localMsgSummary.strContent = ((tog)localObject2).a(qx(), 1001, paramContext.getResources().getString(2131694636), 0);
          }
          label171:
          localObject2 = aqgv.G(paramQQAppInterface, qx());
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = aqgv.b(paramQQAppInterface, qx(), false);
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = qx();
          }
          this.mTitleName = ((String)localObject2);
          this.mAuthenIconId = 0;
          super.bI(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          super.a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.enableTalkBack)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.mTitleName);
            if (this.mUnreadNum != 0) {
              break label432;
            }
          }
        }
      }
      for (;;)
      {
        if (this.mMsgExtroInfo != null) {
          paramQQAppInterface.append(this.mMsgExtroInfo + ",");
        }
        paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
        this.mContentDesc = paramQQAppInterface.toString();
        return;
        this.mUnreadNum = 0;
        break;
        this.mUnreadNum = 0;
        this.mDisplayTime = 0L;
        break label78;
        label367:
        if (afck.m(paramQQAppInterface, qx(), 1001))
        {
          this.mHasFlowerMsg = true;
          this.mMsgExtroInfo = paramContext.getResources().getString(2131696061);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
          break label171;
        }
        super.a((QQMessageFacade.Message)localObject1, ng(), paramQQAppInterface, paramContext, localMsgSummary);
        break label171;
        label432:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
        }
      }
    }
  }
  
  public long eI()
  {
    return this.messageRecord.time;
  }
  
  public long eJ()
  {
    return 0L;
  }
  
  public int ng()
  {
    return this.messageRecord.istroop;
  }
  
  public String qx()
  {
    return this.messageRecord.senderuin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem
 * JD-Core Version:    0.7.0.1
 */