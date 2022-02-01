package com.tencent.mobileqq.activity.recent.data;

import afck;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import aqgv;
import aqiu;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tog;
import ton;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  private static final int MAX_UNREADER_MSG_ICON = 6;
  public Object lock = new Object();
  public boolean mHasFlowerMsg;
  public List<MessageRecord> mUnreadMRList = new ArrayList(6);
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
  }
  
  private void bM(QQAppInterface arg1)
  {
    Object localObject2 = ???.a(ng()).g(qx(), ng());
    tog localtog = ???.a();
    int i;
    if (localObject2 == null) {
      i = 0;
    }
    synchronized (this.lock)
    {
      this.mUnreadMRList.clear();
      this.mUnreadNum = localtog.A(qx(), ng());
      if (i > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
          if ((localtog.A(localMessageRecord.senderuin, localMessageRecord.istroop) > 0) && (this.mUnreadMRList.size() < 6)) {
            this.mUnreadMRList.add(localMessageRecord);
          }
        } while (this.mUnreadMRList.size() < 6);
      }
      if ((this.mUnreadNum == 0) && (!this.mUnreadMRList.isEmpty())) {
        this.mUnreadMRList.clear();
      }
      return;
      i = ((List)localObject2).size();
    }
  }
  
  private void cvn()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.enableTalkBack)
    {
      localStringBuilder = new StringBuilder(24);
      localStringBuilder.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label96;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
      return;
      label96:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读");
      }
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = paramQQAppInterface.a();
    this.mUnreadFlag = 3;
    this.mLastMsg = "";
    this.mExtraInfoColor = 0;
    this.mMsgExtroInfo = "";
    Object localObject2 = null;
    Object localObject3 = paramQQAppInterface.b();
    if (localObject3 != null) {
      localObject2 = ((QQMessageFacade)localObject3).a(qx(), ng());
    }
    if (afck.l(paramQQAppInterface, qx(), 1001))
    {
      this.mMsgExtroInfo = paramContext.getResources().getString(2131694637);
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      localObject2 = a();
      ((MsgSummary)localObject2).strContent = ((tog)localObject1).a(qx(), 1001, paramContext.getResources().getString(2131694636), 0);
      a(paramQQAppInterface, (MsgSummary)localObject2);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "boxUin" + qx() + ",boxType" + ng() + ",HasUnreadRedPacketMsg");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_box", 2, "boxUin" + qx() + ",boxType" + ng() + ",unreadNum:" + this.mUnreadNum);
      }
      return;
      if (afck.m(paramQQAppInterface, qx(), 1001))
      {
        this.mHasFlowerMsg = true;
        this.mUnreadFlag = 1;
        this.mMsgExtroInfo = paramContext.getResources().getString(2131696061);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
        this.mLastMsg = "";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "boxUin" + qx() + ",boxType" + ng() + ",HasUnreadGiftMsg");
        }
      }
      else
      {
        if (this.mUnreadNum <= 0) {
          break;
        }
        this.mLastMsg = "";
      }
    }
    localObject1 = null;
    if (localObject2 != null)
    {
      localObject3 = aqgv.G(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin);
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = aqgv.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, false);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label469;
      }
      localObject1 = "";
    }
    label469:
    for (;;)
    {
      localObject3 = a();
      aqiu.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, ng(), (MsgSummary)localObject3, (String)localObject1, false, false);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    bM(paramQQAppInterface);
    f(paramQQAppInterface, paramContext);
    cvn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem
 * JD-Core Version:    0.7.0.1
 */