package com.tencent.mobileqq.activity.recent.data;

import acfp;
import anaz;
import android.content.Context;
import android.text.SpannableStringBuilder;
import aofk;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import top;

public class RecentItemRouterDataLine
  extends RecentUserBaseData
{
  public RecentItemRouterDataLine(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private QQMessageFacade.Message a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.b();
    if (paramQQAppInterface != null)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a(this.mUser.uin, this.mUser.getType());
      if (localMessage != null)
      {
        paramQQAppInterface = localMessage;
        if (localMessage.msgtype != 0) {}
      }
      else
      {
        return null;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
        paramCharSequence = new SpannableStringBuilder(paramCharSequence.toString());
      }
    }
    for (paramMsgSummary.mEmojiFlag = 0;; paramMsgSummary.mEmojiFlag = 1)
    {
      if (!paramBoolean1) {
        break label90;
      }
      paramMsgSummary.nState = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label90:
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
    boolean bool2 = false;
    if (paramMessage != null)
    {
      paramInt = paramMessage.extInt;
      if (paramInt != 4) {
        break label522;
      }
    }
    label519:
    label522:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      if (paramMessage.msgtype == -1000)
      {
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null) {
          if (bool1) {
            paramQQAppInterface = "F " + paramQQAppInterface;
          }
        }
      }
      for (;;)
      {
        paramMsgSummary.strContent = a(null, bool1, bool2, new aofk(paramQQAppInterface, 1, 16), paramMsgSummary);
        for (;;)
        {
          if (paramMessage != null) {
            QLog.d("RecentItemRouterDataLine", 2, "msg info: " + paramMessage.extInt + ":" + paramMessage.msgtype + "msgSummary.strContent:" + paramMsgSummary.strContent);
          }
          return;
          if (!bool2) {
            break label519;
          }
          paramQQAppInterface = "S " + paramQQAppInterface;
          break;
          paramQQAppInterface = new StringBuffer();
          if (bool1) {
            paramQQAppInterface.append("F ");
          }
          for (;;)
          {
            for (;;)
            {
              paramQQAppInterface.append("");
              try
              {
                paramMsgSummary.strContent = a(null, bool1, bool2, new aofk(paramQQAppInterface, 1, 16), paramMsgSummary);
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
              }
            }
            break;
            if (bool2) {
              paramQQAppInterface.append("S ");
            }
          }
          if (paramMessage.msgtype == -2000)
          {
            paramMsgSummary.strContent = a(paramContext.getString(2131719004), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2005)
          {
            paramMsgSummary.strContent = a(paramContext.getString(2131721065), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2009)
          {
            paramMsgSummary.strContent = a(paramContext.getString(2131721685), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2335)
          {
            paramMsgSummary.strContent = a(paramContext.getString(2131721065), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2015)
          {
            paramMsgSummary.strContent = "";
          }
          else if ((paramMessage.msgtype == -2060) || (paramMessage.msgtype == -2066) || (paramMessage.msgtype == -4023) || (paramMessage.msgtype == -4024) || (paramMessage.msgtype == -7010) || (paramMessage.msgtype == -7009) || (paramMessage.msgtype == -7011))
          {
            paramMsgSummary.strContent = "";
            continue;
            paramMsgSummary.strContent = "";
          }
        }
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    this.mUnreadNum = 0;
    this.mDisplayTime = 0L;
    RouterHandler localRouterHandler = (RouterHandler)paramQQAppInterface.getBusinessHandler(48);
    Object localObject2 = a(paramQQAppInterface);
    Object localObject1 = localObject2;
    QQMessageFacade localQQMessageFacade;
    String str;
    if (localObject2 == null)
    {
      localQQMessageFacade = paramQQAppInterface.b();
      str = top.u(this.mUser.uin, 6002);
      localObject2 = localRouterHandler.a(this.mUser.uin);
      if (localObject2 != null) {
        break label256;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).extInt = 0;
      ((QQMessageFacade.Message)localObject1).time = anaz.gQ();
      ((QQMessageFacade.Message)localObject1).msgtype = 0;
    }
    for (;;)
    {
      localQQMessageFacade.gP.put(str, localObject1);
      this.mTitleName = localRouterHandler.bk(Long.parseLong(this.mUser.uin));
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = a();
      a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      bI(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      this.mContentDesc = (acfp.m(2131713676) + this.mUnreadNum + acfp.m(2131713679) + " " + ((MsgSummary)localObject2).strContent + this.mShowTime);
      return;
      label256:
      if (localQQMessageFacade == null) {
        break;
      }
      localObject1 = localObject2;
      if (localQQMessageFacade.gP.containsKey(str))
      {
        localQQMessageFacade.gP.remove(str);
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine
 * JD-Core Version:    0.7.0.1
 */