package com.tencent.mobileqq.activity.recent.data;

import aale;
import aalj;
import aalo;
import aamb;
import acdt;
import acdu;
import acfp;
import alkm;
import alkm.a;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import aofk;
import aofy;
import aqgv;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import tog;
import top;

public class RecentItemDiscussionMsgData
  extends RecentUserBaseData
{
  private static final String TAG = "RecentItemDiscussionMsgData";
  
  public RecentItemDiscussionMsgData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private void dx(Context paramContext)
  {
    if (a().msg == null) {
      this.mContentDesc = "";
    }
    for (;;)
    {
      return;
      if ((a().msg instanceof aalj))
      {
        aalj localaalj = (aalj)a().msg;
        this.mMsgExtroInfo = localaalj.content;
        this.mContentDesc = localaalj.contentDescription;
        if ((a().msg instanceof aalo)) {
          this.mContentDesc = String.format(acfp.m(2131713681), new Object[] { this.mTitleName });
        }
      }
      for (int i = 2131167410; (!TextUtils.isEmpty(this.mMsgExtroInfo)) && (i > 0); i = 0)
      {
        this.mExtraInfoColor = paramContext.getResources().getColor(i);
        return;
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    Object localObject1 = null;
    Object localObject2 = paramQQAppInterface.b();
    if (localObject2 != null) {
      localObject1 = ((QQMessageFacade)localObject2).a(this.mUser.uin, this.mUser.getType());
    }
    if (localObject1 != null) {
      if ((((QQMessageFacade.Message)localObject1).istroop == 3000) && (((QQMessageFacade.Message)localObject1).msg == null) && (((QQMessageFacade.Message)localObject1).time == 0L)) {
        this.mDisplayTime = this.mUser.lastmsgtime;
      }
    }
    for (;;)
    {
      localObject2 = paramQQAppInterface.a();
      label125:
      acdu localacdu;
      if (localObject2 != null)
      {
        this.mUnreadNum = ((tog)localObject2).A(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        localObject2 = alkm.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, this.mUnreadNum, (QQMessageFacade.Message)localObject1);
        this.mUnreadNum += ((alkm.a)localObject2).HF();
        if (((alkm.a)localObject2).HF() > 0)
        {
          this.mMsgExtroInfo = ((alkm.a)localObject2).xZ();
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
        }
        label191:
        localObject2 = null;
        localacdu = (acdu)paramQQAppInterface.getManager(53);
        if (localacdu != null) {
          localObject2 = localacdu.a(this.mUser.uin);
        }
        if ((this.mUnreadNum <= 0) || (!top.g(paramQQAppInterface, this.mUser.uin, this.mUser.getType()))) {
          break label898;
        }
        this.mUnreadFlag = 3;
        if ((localObject2 != null) || (aale.a().iQ(this.mUser.uin))) {}
      }
      try
      {
        long l = Long.parseLong(this.mUser.uin);
        ((acdt)paramQQAppInterface.getBusinessHandler(6)).hk(l);
        aale.a().bq(this.mUser.uin, true);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).senderuin)))
        {
          if (((QQMessageFacade.Message)localObject1).senderuin.equals(((QQMessageFacade.Message)localObject1).frienduin)) {
            ((QQMessageFacade.Message)localObject1).nickName = "";
          }
        }
        else
        {
          this.mTitleName = aqgv.u(paramQQAppInterface, this.mUser.uin);
          if (TextUtils.isEmpty(this.mTitleName)) {
            this.mTitleName = aqgv.a(paramContext, (DiscussionInfo)localObject2);
          }
          if (!TextUtils.isEmpty(this.mTitleName)) {
            this.mTitleName_cs = new aofk(this.mTitleName, 1);
          }
          MsgSummary localMsgSummary = a();
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
          String str = "";
          localObject2 = str;
          if (localacdu != null)
          {
            int i = localacdu.cn(this.mUser.uin);
            localObject2 = str;
            if (i > 0) {
              localObject2 = "(" + i + ")";
            }
          }
          this.mExtraInfo = ((CharSequence)localObject2);
          bI(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          if (((a().msg instanceof aamb)) && (this.mUnreadNum > 0))
          {
            localMsgSummary.suffix = "";
            localMsgSummary.strPrefix = "";
          }
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (localMsgSummary.bShowDraft) {
            break label1011;
          }
          dx(paramContext);
          if ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).msgtype == -2025) && (this.mUnreadNum > 0) && (!localMsgSummary.bShowDraft))
          {
            localObject1 = paramContext.getString(2131694637);
            if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith((String)localObject1)))
            {
              if (this.mExtraInfoColor == 0) {
                this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
              }
              if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                break label1044;
              }
              paramQQAppInterface = (QQAppInterface)localObject1;
              this.mMsgExtroInfo = paramQQAppInterface;
              this.mLastMsg = this.mLastMsg.toString().replace((CharSequence)localObject1, "");
            }
          }
          paramQQAppInterface = a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
            paramQQAppInterface.reParse();
          }
          if (AppSetting.enableTalkBack)
          {
            if (this.mTitleName == null) {
              break label1070;
            }
            paramQQAppInterface = this.mTitleName + acfp.m(2131713682);
            paramContext = new StringBuilder();
            paramContext.append(paramQQAppInterface).append(",");
            if (this.mUnreadNum != 0) {
              break label1080;
            }
            if (this.mMsgExtroInfo != null) {
              paramContext.append(this.mMsgExtroInfo + ",");
            }
            paramContext.append(aofy.og(this.mLastMsg.toString())).append(",").append(this.mShowTime);
            this.mContentDesc = paramContext.toString();
          }
          cvo();
          return;
          this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
          continue;
          this.mUnreadNum = 0;
          break label125;
          this.mUnreadNum = 0;
          this.mDisplayTime = 0L;
          break label191;
          label898:
          this.mUnreadFlag = 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("discussion", 2, localNumberFormatException.toString());
            continue;
            if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).frienduin)) {
              ((QQMessageFacade.Message)localObject1).nickName = aqgv.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).senderuin, (MessageRecord)localObject1);
            }
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName)) {
              ((QQMessageFacade.Message)localObject1).nickName = aqgv.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, true);
            }
            label1044:
            label1070:
            label1080:
            if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).nickName))
            {
              ((QQMessageFacade.Message)localObject1).nickName = ((QQMessageFacade.Message)localObject1).senderuin;
              continue;
              label1011:
              if ((a().msg instanceof aalj))
              {
                this.mMsgExtroInfo = ((aalj)a().msg).content;
                continue;
                paramQQAppInterface = this.mMsgExtroInfo + (String)localObject1;
                continue;
                paramQQAppInterface = acfp.m(2131713682);
                continue;
                if (this.mUnreadNum == 1) {
                  paramContext.append("有一条未读");
                } else if (this.mUnreadNum == 2) {
                  paramContext.append("有两条未读");
                } else if (this.mUnreadNum > 0) {
                  paramContext.append("有").append(this.mUnreadNum).append("条未读,");
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData
 * JD-Core Version:    0.7.0.1
 */