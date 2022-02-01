package com.tencent.mobileqq.activity.recent.data;

import acde;
import acqp;
import ahav;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aofk;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import tog;

public class RecentItemPcDataLine
  extends RecentUserBaseData
{
  CharSequence MsgDescreption;
  int dev_type;
  String mTitle;
  
  public RecentItemPcDataLine(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    CharSequence localCharSequence = paramMessage.getMessageText();
    if (localCharSequence != null)
    {
      if (paramBoolean1) {
        paramMessage = "F " + localCharSequence;
      }
      for (;;)
      {
        paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new aofk(paramMessage, 1, 16), paramMsgSummary);
        return;
        paramMessage = localCharSequence;
        if (paramBoolean2) {
          paramMessage = "S " + localCharSequence;
        }
      }
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean1)
    {
      localStringBuffer.append("F ");
      if (localCharSequence == null) {
        break label185;
      }
    }
    label185:
    for (paramMessage = localCharSequence.toString().trim();; paramMessage = "")
    {
      localStringBuffer.append(paramMessage);
      try
      {
        paramMsgSummary.strContent = a(null, paramBoolean1, paramBoolean2, new aofk(localStringBuffer, 1, 16), paramMsgSummary);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
      if (!paramBoolean2) {
        break;
      }
      localStringBuffer.append("S ");
      break;
    }
  }
  
  private boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {}
    while ((!paramDataLineMsgSet.isSendFromLocal()) || (!paramDataLineMsgSet.hasSendingOrRecving())) {
      return false;
    }
    return true;
  }
  
  private boolean b(DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramDataLineMsgSet == null) {}
    while ((!paramDataLineMsgSet.hasFailed()) || (paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) {
      return false;
    }
    return true;
  }
  
  protected CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
      }
    }
    for (paramMsgSummary.mEmojiFlag = 0;; paramMsgSummary.mEmojiFlag = 1)
    {
      if (!paramBoolean1) {
        break label76;
      }
      paramMsgSummary.nState = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label76:
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return paramCharSequence;
    }
    paramMsgSummary.nState = 0;
    return paramCharSequence;
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    paramContext = (acde)paramQQAppInterface.getBusinessHandler(8);
    if ((paramContext != null) && (paramContext.ip(this.dev_type)))
    {
      this.mDisplayTime = paramContext.A(this.dev_type);
      paramMsgSummary.strContent = this.MsgDescreption;
      return;
    }
    if ((paramMessage != null) && (paramMessage.msg != null))
    {
      paramContext = paramQQAppInterface.b().a(this.dev_type).a(paramMessage.msgId);
      boolean bool2 = b(paramContext);
      boolean bool3 = a(paramContext);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!paramMessage.isSend()) {
          bool1 = false;
        }
      }
      switch (paramMessage.msgtype)
      {
      default: 
        return;
      case -2335: 
      case -2009: 
      case -2005: 
      case -2000: 
        if (paramContext == null)
        {
          paramMsgSummary.strContent = "";
          return;
        }
      case -1000: 
        a(paramMessage, paramMsgSummary, bool1, bool3);
        return;
        paramMsgSummary.strContent = a(ahav.a(paramQQAppInterface, paramContext.getFirstItem()), bool1, bool3, null, paramMsgSummary);
        return;
      }
      paramMsgSummary.strContent = "";
      return;
    }
    paramMsgSummary.strContent = "";
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label126:
    do
    {
      return;
      super.c(paramQQAppInterface, paramContext);
      if (this.mUser.getType() != 6000) {
        break;
      }
      this.mTitle = paramContext.getString(2131695446);
      this.MsgDescreption = paramContext.getString(2131695436);
      this.dev_type = 0;
      QQMessageFacade.Message localMessage = null;
      Object localObject = paramQQAppInterface.b();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).a(this.mUser.uin, this.mUser.getType());
      }
      if (localMessage == null) {
        break label339;
      }
      this.mDisplayTime = localMessage.time;
      localObject = paramQQAppInterface.a();
      if (localObject == null) {
        break label331;
      }
      this.mUnreadNum = ((tog)localObject).A(localMessage.frienduin, localMessage.istroop);
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = this.mTitle;
      }
      localObject = a();
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject);
      bI(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
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
      if (this.mUser.getType() != 6003) {
        break;
      }
      this.mTitle = paramContext.getString(2131695447);
      this.MsgDescreption = paramContext.getString(2131695435);
      this.dev_type = 1;
      break;
      label331:
      this.mUnreadNum = 0;
      break label126;
      label339:
      this.mUnreadNum = 0;
      this.mDisplayTime = 0L;
      break label126;
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
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */