package com.tencent.mobileqq.matchchat;

import afsi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import aofk;
import aqgv;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import tog;
import top;

public class RecentMatchChatListItem
  extends RecentBaseData
{
  public int age = -1;
  public int career = -1;
  public int charmLevel;
  public String common;
  public int constellation = -1;
  public int gender = -1;
  public boolean mExtendFriendOnline;
  public boolean mHasFlowerMsg;
  MessageRecord messageRecord;
  public int vip = -1;
  
  public RecentMatchChatListItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentMatchChatListItem data is null");
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
  
  protected void b(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = ((afsi)paramQQAppInterface.getManager(264)).a(paramMessage.frienduin, false);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isSignalBomb()) && (paramQQAppInterface.distance >= 0) && (paramQQAppInterface.showDistanceHLight))
    {
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      this.mMsgExtroInfo = String.format(paramContext.getResources().getString(2131701197), new Object[] { Integer.valueOf(paramQQAppInterface.distance) });
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.b();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(qx(), ng());; localObject1 = null)
    {
      this.mExtraInfoColor = 0;
      this.mMsgExtroInfo = null;
      if (localObject1 != null)
      {
        this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((tog)localObject2).A(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (top.v((MessageRecord)localObject1)) {
            this.mUnreadFlag = 3;
          }
          b(paramQQAppInterface, paramContext, (QQMessageFacade.Message)localObject1);
          label95:
          localObject2 = super.a();
          super.a((QQMessageFacade.Message)localObject1, ng(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          this.mHasFlowerMsg = false;
          this.mTitleName = aqgv.b(paramQQAppInterface, qx(), true);
          this.mAuthenIconId = 0;
          super.bI(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          super.a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          if (AppSetting.enableTalkBack)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.mTitleName);
            if (this.mUnreadNum != 0) {
              break label274;
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
        break label95;
        label274:
        if (this.mUnreadNum == 1) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131701325));
        } else if (this.mUnreadNum == 2) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131701326));
        } else if (this.mUnreadNum > 0) {
          paramQQAppInterface.append(paramContext.getResources().getString(2131701324, new Object[] { Integer.valueOf(this.mUnreadNum) }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.RecentMatchChatListItem
 * JD-Core Version:    0.7.0.1
 */