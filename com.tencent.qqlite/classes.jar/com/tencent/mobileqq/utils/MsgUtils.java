package com.tencent.mobileqq.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MsgUtils
{
  private static final int a = 16;
  
  private static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).fProgress == 1.0D) {
        return 1;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.a(), paramMessage.frienduin });
    ((EntityManager)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = FileManagerUtil.c(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence1, String paramString, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    paramDrawable1 = new StringBuffer();
    if (paramCharSequence1 != null)
    {
      paramDrawable1.append(paramCharSequence1);
      paramDrawable1.append(": ");
    }
    for (int i = paramCharSequence1.length();; i = 0)
    {
      if (paramBoolean1)
      {
        paramDrawable1.append("F ");
        if (paramString != null) {
          paramDrawable1.append(paramString);
        }
        if (paramCharSequence2 != null) {
          paramDrawable1.append(paramCharSequence2);
        }
        paramCharSequence1 = new SpannableStringBuilder(paramDrawable1.toString());
        if (!paramBoolean1) {
          break label151;
        }
        paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
        paramCharSequence1.setSpan(new ImageSpan(paramDrawable3), i, i + 1, 33);
      }
      label151:
      while (!paramBoolean2)
      {
        return paramCharSequence1;
        if (!paramBoolean2) {
          break;
        }
        paramDrawable1.append("S ");
        break;
      }
      paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
      paramCharSequence1.setSpan(new ImageSpan(paramDrawable2), i, i + 1, 33);
      return paramCharSequence1;
    }
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.a().getString(2131363963);
    }
    return paramQQAppInterface.a().getString(2131363961) + paramContext.messagetail + paramQQAppInterface.a().getString(2131363962);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, QQMessageFacade.Message paramMessage)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessage.msgtype))
    {
      str1 = null;
      switch (paramMessage.msgtype)
      {
      default: 
        paramContext = str1;
        String str2 = TroopSystemMsgUtil.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessage.senderuin))) {
                break label274;
              }
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface).append(paramContext);
              str1 = paramString.toString();
            }
          }
        }
        break;
      }
    }
    label274:
    label439:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return str1;
                  paramContext = paramContext.getString(2131363472);
                  break;
                  paramContext = paramContext.getString(2131363473);
                  break;
                  paramContext = paramContext.getString(2131363474);
                  break;
                  paramContext = paramContext.getString(2131363477);
                  break;
                  paramContext = paramContext.getString(2131363478);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = TroopSystemMsgUtil.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return TroopSystemMsgUtil.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label462:
    paramString = TroopSystemMsgUtil.a(paramString, paramQQAppInterface);
    paramMessage = TroopSystemMsgUtil.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = TroopSystemMsgUtil.a(paramString, paramMessage, paramQQAppInterface);
            }
          }
        }
      }
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append("[文件]");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMessage == null) {
      return;
    }
    if ((AnonymousChatHelper.a(paramMessage)) && ((TextUtils.isEmpty(paramString)) || (!paramString.equals(ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true))))) {
      paramString = AnonymousChatHelper.a(paramMessage).b;
    }
    for (;;)
    {
      Object localObject1 = paramString;
      if (!paramBoolean1) {
        if (!paramMessage.isSendFromLocal())
        {
          localObject1 = paramString;
          if (paramMessage.selfuin != null)
          {
            localObject1 = paramString;
            if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      if (paramMessage.msgtype == -2005) {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 12) {
          localObject2 = ((String)localObject1).substring(0, 11) + "...";
        }
      }
      if (paramMessage.msgtype == -2011)
      {
        paramBoolean1 = a(paramQQAppInterface, paramMessage);
        paramBoolean2 = b(paramQQAppInterface, paramMessage);
        a((CharSequence)localObject2, null, paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
        return;
      }
      boolean bool;
      if (paramMessage.msgtype == -2000)
      {
        paramBoolean2 = false;
        bool = false;
      }
      label1692:
      label1720:
      label1886:
      label1895:
      label1901:
      for (;;)
      {
        long l;
        try
        {
          paramString = paramMessage.frienduin;
          if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
            break label1901;
          }
          paramString = paramMessage.senderuin;
          localObject1 = (MessageForPic)paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
          paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramMessage.uniseq);
        }
        catch (Exception paramMessage)
        {
          paramQQAppInterface = null;
        }
        try
        {
          if ((!paramMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localObject1 == null)) {
            continue;
          }
          l = ((MessageForPic)localObject1).size;
          if (l > 0L) {
            continue;
          }
          paramBoolean1 = true;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            label1659:
            continue;
            paramContext = paramString;
            continue;
            paramBoolean1 = false;
          }
          paramBoolean1 = false;
          continue;
          paramBoolean1 = false;
          continue;
        }
        paramBoolean2 = paramBoolean1;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramQQAppInterface = (BaseTransProcessor)paramQQAppInterface;
          if (paramQQAppInterface.c() != 1003L)
          {
            paramBoolean1 = true;
            if (QLog.isColorLevel())
            {
              if (paramQQAppInterface.a != null)
              {
                l = paramQQAppInterface.a.a;
                QLog.d("sendingpic", 2, "uniseq:" + l + ",key:" + paramQQAppInterface.a());
              }
            }
            else
            {
              a((CharSequence)localObject2, paramContext.getString(2131363809), null, paramBoolean2, paramBoolean1, paramMsgSummary);
              return;
              if ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof BaseTransProcessor))) {
                break label1895;
              }
              l = ((BaseTransProcessor)paramQQAppInterface).c();
              paramInt = (int)l;
              if ((paramInt != 1005) && (paramInt != 1004)) {
                break label1895;
              }
              paramBoolean1 = true;
              continue;
              paramMessage.printStackTrace();
              continue;
            }
            l = -1L;
            continue;
          }
        }
        else
        {
          paramBoolean1 = bool;
          if (paramQQAppInterface == null) {
            continue;
          }
          bool = true;
          paramBoolean1 = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("sendingpic", 2, "processor:" + paramQQAppInterface);
          paramBoolean1 = bool;
          continue;
          if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
          {
            paramString = paramMessage.frienduin;
            if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
              break label1886;
            }
            paramString = paramMessage.senderuin;
            paramBoolean2 = false;
            paramContext = paramContext.getString(2131363810);
            localObject1 = paramQQAppInterface.a().b(paramString, paramMessage.istroop, paramMessage.uniseq);
            if ((localObject1 instanceof MessageForPtt))
            {
              localObject1 = (MessageForPtt)localObject1;
              if (paramMessage.isSendFromLocal())
              {
                if (((MessageForPtt)localObject1).fileSize == -1L) {
                  paramBoolean1 = true;
                }
                for (;;)
                {
                  a((CharSequence)localObject2, paramContext, null, paramBoolean1, paramBoolean2, paramMsgSummary);
                  return;
                  if (((MessageForPtt)localObject1).fileSize > 0L) {
                    break;
                  }
                  paramInt = paramQQAppInterface.a().d(paramString, ((MessageForPtt)localObject1).url, ((MessageForPtt)localObject1).uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    paramBoolean1 = true;
                  }
                  else
                  {
                    paramBoolean2 = true;
                    paramBoolean1 = false;
                  }
                }
              }
            }
          }
          else
          {
            if (paramMessage.msgtype == -3008)
            {
              paramMsgSummary.b = (paramContext.getString(2131362031) + "\"" + paramMessage.msg + "\"");
              return;
            }
            if (ActionMsgUtil.a(paramMessage.msgtype))
            {
              a((CharSequence)localObject2, a(paramContext, paramQQAppInterface, paramMessage), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2017)
            {
              a((CharSequence)localObject2, paramContext.getString(2131362600), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              a((CharSequence)localObject2, paramContext.getString(2131364093), null, a(paramQQAppInterface, paramMessage), b(paramQQAppInterface, paramMessage), paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1013)
            {
              a(null, null, MessageForGrayTips.getOrginMsg(paramMessage.msg), false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1019)
            {
              a(null, null, "对方通过" + paramMessage.msg + "加你为好友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -1018)
            {
              a(null, null, "通过" + paramMessage.msg + "加的新朋友，一起聊聊吧！", false, false, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -2019)
            {
              paramMsgSummary.b = paramContext.getString(2131364298);
              return;
            }
            if (paramMessage.msgtype == -2005)
            {
              paramString = FileManagerUtil.a(paramQQAppInterface, paramMessage);
              paramBoolean1 = a(paramQQAppInterface, paramMessage);
              paramBoolean2 = b(paramQQAppInterface, paramMessage);
              a((CharSequence)localObject2, paramContext.getString(2131363812), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              if (paramString == null) {
                break;
              }
              paramMsgSummary.b = paramString;
              return;
            }
            if (paramMessage.msgtype == -2022)
            {
              paramBoolean1 = false;
              bool = false;
              paramQQAppInterface = paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if (!(paramQQAppInterface instanceof MessageForShortVideo)) {
                break;
              }
              paramQQAppInterface = (MessageForShortVideo)paramQQAppInterface;
              if ((paramQQAppInterface.videoFileStatus == 1005) || (paramMessage.extraflag == 32768)) {
                paramBoolean1 = true;
              }
              paramBoolean2 = bool;
              if (paramMessage.isSendFromLocal()) {
                if (paramQQAppInterface.videoFileStatus != 1001)
                {
                  paramBoolean2 = bool;
                  if (paramQQAppInterface.videoFileStatus != 1002) {}
                }
                else
                {
                  paramBoolean2 = true;
                }
              }
              a((CharSequence)localObject2, paramContext.getString(2131363813), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            }
            if (paramMessage.msgtype == -5002)
            {
              paramContext = new MessageForIncompatibleGrayTips();
              paramContext.msgData = paramMessage.msgData;
              paramContext.parse();
              if (paramContext.msg == null) {
                break;
              }
              paramMsgSummary.b = paramContext.msg;
              return;
            }
            if (paramMessage.msgtype == -2025)
            {
              paramMsgSummary.b = paramMessage.msg;
              return;
            }
            if (paramMessage.msg == null)
            {
              paramMsgSummary.b = "";
              return;
            }
            paramBoolean1 = a(paramQQAppInterface, paramMessage);
            paramBoolean2 = b(paramQQAppInterface, paramMessage);
            switch (paramMessage.fileType)
            {
            default: 
              if ((AppConstants.Y.equalsIgnoreCase(paramMessage.frienduin)) && (paramMessage.istroop == 0))
              {
                paramMsgSummary.b = SystemMsgController.a().a(paramQQAppInterface);
                return;
              }
              break;
            case 65536: 
              a((CharSequence)localObject2, "", paramMessage.msg, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            case 1: 
              if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
              {
                paramMsgSummary.b = paramContext.getString(2131364095);
                return;
              }
              a((CharSequence)localObject2, paramContext.getString(2131363809), null, paramBoolean1, paramBoolean2, paramMsgSummary);
              return;
            case 65538: 
              a((CharSequence)localObject2, paramContext.getString(2131363809), null, false, false, paramMsgSummary);
              return;
            case 2: 
            case 8: 
              paramContext = paramContext.getString(2131363810);
              if ((Utils.a(paramMessage.senderuin, paramQQAppInterface.a())) && (paramInt != 0))
              {
                a((CharSequence)localObject2, paramContext, "", paramBoolean1, paramBoolean2, paramMsgSummary);
                return;
              }
              a((CharSequence)localObject2, paramContext, "", false, false, paramMsgSummary);
              return;
            }
            paramString = paramMessage.getMessageText();
            if ((paramMessage.emoRecentMsg != null) && (paramString != null))
            {
              paramContext = new StringBuilder();
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                paramContext.append((String)localObject2);
                paramContext.append(":");
              }
              if (!AnonymousChatHelper.a(paramMessage))
              {
                if (paramBoolean1) {
                  paramContext.append("F ");
                }
              }
              else
              {
                if (!(paramString instanceof QQText)) {
                  break label1692;
                }
                paramContext = ((QQText)paramString).a(paramContext.toString(), true, new int[0]);
                paramMsgSummary.g = 1;
                if (!paramBoolean1) {
                  break label1720;
                }
                paramMsgSummary.f = 2;
              }
              for (;;)
              {
                paramMsgSummary.b = paramContext;
                return;
                if (!paramBoolean2) {
                  break;
                }
                paramContext.append("S ");
                break;
                paramContext.append(paramString);
                paramContext = new SpannableString(paramContext.toString());
                paramMsgSummary.g = 0;
                break label1659;
                if (paramBoolean2) {
                  paramMsgSummary.f = 1;
                } else {
                  paramMsgSummary.f = 0;
                }
              }
            }
            if (paramString != null) {
              paramString = paramString.toString().trim();
            }
            while ((AppConstants.Y.equalsIgnoreCase(paramMessage.frienduin)) && (paramString != null) && (paramString.length() > 0))
            {
              paramContext = a(paramContext, paramQQAppInterface, paramString, paramMessage);
              a((CharSequence)localObject2, null, paramContext, paramBoolean1, paramQQAppInterface.a().b(paramMessage), paramMsgSummary);
              if ((paramMessage.msgtype == -1000) && (paramMsgSummary.b != null))
              {
                paramMsgSummary.b = new QQText(paramMsgSummary.b, 1, 16);
                paramMsgSummary.g = 1;
                return;
                paramString = null;
              }
              else
              {
                paramMsgSummary.g = 0;
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private static void a(CharSequence paramCharSequence1, String paramString, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.a = paramCharSequence1;
    paramMsgSummary.b = paramString;
    paramMsgSummary.c = paramCharSequence2;
    if (paramBoolean1)
    {
      paramMsgSummary.f = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.f = 1;
      return;
    }
    paramMsgSummary.f = 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    return a(paramContext, paramQQAppInterface, paramMessage, paramTextView, paramInt, paramDrawable1, paramDrawable2, paramDrawable3, null, null);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, CountDownTimer.CountDownTimerListener paramCountDownTimerListener, CountDownTimer paramCountDownTimer)
  {
    if ((paramTextView == null) || (paramMessage == null)) {
      return true;
    }
    paramTextView.setVisibility(0);
    paramCountDownTimer = paramMessage.nickName;
    if (!paramMessage.isSendFromLocal())
    {
      paramCountDownTimerListener = paramCountDownTimer;
      if (paramMessage.selfuin != null)
      {
        paramCountDownTimerListener = paramCountDownTimer;
        if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
      }
    }
    else
    {
      paramCountDownTimerListener = null;
    }
    paramCountDownTimer = paramCountDownTimerListener;
    if (paramCountDownTimerListener != null)
    {
      paramCountDownTimer = paramCountDownTimerListener;
      if (paramCountDownTimerListener.length() > 12) {
        paramCountDownTimer = paramCountDownTimerListener.substring(0, 11) + "...";
      }
    }
    boolean bool1 = a(paramQQAppInterface, paramMessage);
    boolean bool2 = b(paramQQAppInterface, paramMessage);
    paramContext.getResources();
    paramContext.getString(2131363811);
    paramCountDownTimerListener = paramContext.getString(2131363812);
    if (paramMessage.msgtype == -2011)
    {
      paramContext = StructMsgFactory.a(paramMessage.msgData);
      if (paramContext != null) {
        paramTextView.setText(a(paramCountDownTimer, null, paramContext.mMsgBrief, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      }
      return false;
    }
    String str;
    Object localObject;
    if (paramMessage.msgtype == -2000)
    {
      str = paramMessage.frienduin;
      bool1 = false;
      bool2 = false;
      localObject = null;
      paramCountDownTimerListener = (CountDownTimer.CountDownTimerListener)localObject;
    }
    for (;;)
    {
      long l1;
      try
      {
        MessageForPic localMessageForPic = (MessageForPic)paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        paramCountDownTimerListener = (CountDownTimer.CountDownTimerListener)localObject;
        paramQQAppInterface = paramQQAppInterface.a().a(str, paramMessage.uniseq);
        paramCountDownTimerListener = paramQQAppInterface;
        if ((!paramMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localMessageForPic == null)) {
          continue;
        }
        paramCountDownTimerListener = paramQQAppInterface;
        l1 = localMessageForPic.size;
        if (l1 > 0L) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = paramCountDownTimerListener;
        continue;
      }
      if (paramQQAppInterface != null) {
        bool2 = true;
      }
      paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131363809), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      return false;
      if (paramQQAppInterface != null)
      {
        paramCountDownTimerListener = paramQQAppInterface;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramCountDownTimerListener = paramQQAppInterface;
          l1 = ((BaseTransProcessor)paramQQAppInterface).c();
          paramInt = (int)l1;
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            bool1 = true;
            continue;
            if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
            {
              paramCountDownTimerListener = paramMessage.frienduin;
              boolean bool4 = false;
              boolean bool3 = false;
              localObject = paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if ((localObject instanceof MessageForPtt))
              {
                localObject = (MessageForPtt)localObject;
                bool1 = bool4;
                bool2 = bool3;
                if (paramMessage.isSendFromLocal())
                {
                  if (((MessageForPtt)localObject).fileSize != -1L) {
                    break label537;
                  }
                  bool1 = true;
                  bool2 = bool3;
                }
              }
              for (;;)
              {
                paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131363810), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                return false;
                label537:
                bool1 = bool4;
                bool2 = bool3;
                if (((MessageForPtt)localObject).fileSize <= 0L)
                {
                  paramInt = paramQQAppInterface.a().d(paramCountDownTimerListener, ((MessageForPtt)localObject).url, ((MessageForPtt)localObject).uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    bool1 = true;
                    bool2 = bool3;
                  }
                  else
                  {
                    bool2 = true;
                    bool1 = bool4;
                  }
                }
              }
            }
            if (paramMessage.msgtype == -3008)
            {
              paramTextView.setText(BaseApplicationImpl.getContext().getString(2131362031) + "\"" + paramMessage.msg + "\"");
              return false;
            }
            if (ActionMsgUtil.a(paramMessage.msgtype))
            {
              paramTextView.setText(a(paramCountDownTimer, a(paramContext, paramQQAppInterface, paramMessage), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -2017)
            {
              if (paramMessage.isSend()) {}
              for (paramContext = a(null);; paramContext = a(paramCountDownTimer))
              {
                paramTextView.setText(paramContext);
                return false;
              }
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131364093), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -2017)
            {
              paramTextView.setText("[群文件]");
              return false;
            }
            switch (paramMessage.fileType)
            {
            default: 
              if (paramMessage.msg == null) {
                paramTextView.setText("");
              }
              break;
            case 1: 
            case 0: 
            case 65538: 
            case 2: 
            case 8: 
            case 65536: 
              for (;;)
              {
                return true;
                if (paramMessage.msg == null)
                {
                  paramTextView.setText("");
                }
                else if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
                {
                  paramTextView.setText(2131364095);
                }
                else
                {
                  paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131363809), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                  continue;
                  if (paramMessage.msg == null)
                  {
                    paramTextView.setText("");
                  }
                  else
                  {
                    paramContext = FileManagerUtil.a(paramQQAppInterface, paramMessage);
                    if (paramContext == null)
                    {
                      paramTextView.setText(a(paramCountDownTimer, paramCountDownTimerListener, null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                    }
                    else
                    {
                      paramTextView.setText(paramContext);
                      continue;
                      if (paramMessage.msg == null)
                      {
                        paramTextView.setText("");
                      }
                      else
                      {
                        paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131363809), null, false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                        continue;
                        if (paramMessage.msg == null)
                        {
                          paramTextView.setText("");
                        }
                        else
                        {
                          long l2 = 0L;
                          if (paramMessage.fileSize > 0L)
                          {
                            l1 = paramMessage.fileSize;
                            label1100:
                            if (l1 <= 0L) {
                              break label1238;
                            }
                            new StringBuilder().append(l1).append("\"").toString();
                          }
                          label1238:
                          for (;;)
                          {
                            paramContext = paramContext.getString(2131363810);
                            if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(paramQQAppInterface.a())) || (paramInt == 0)) {
                              break label1241;
                            }
                            paramTextView.setText(a(paramCountDownTimer, paramContext, "", bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                            break;
                            l1 = l2;
                            if (paramMessage.pttUrl == null) {
                              break label1100;
                            }
                            l1 = l2;
                            if (paramMessage.pttUrl.toLowerCase().startsWith("http")) {
                              break label1100;
                            }
                            l1 = QQRecorder.a(paramMessage.pttUrl);
                            paramMessage.fileSize = l1;
                            break label1100;
                          }
                          label1241:
                          paramTextView.setText(a(paramCountDownTimer, paramContext, "", false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                          continue;
                          paramTextView.setText(a(paramCountDownTimer, "", paramMessage.msg, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                        }
                      }
                    }
                  }
                }
              }
            }
            if ((String.valueOf(AppConstants.Y).equalsIgnoreCase(paramMessage.frienduin)) && (paramMessage.istroop == 0))
            {
              paramTextView.setText(SystemMsgController.a().a(paramQQAppInterface));
              return true;
            }
            paramCountDownTimerListener = paramMessage.getMessageText();
            if ((paramMessage.emoRecentMsg != null) && (paramCountDownTimerListener != null))
            {
              paramContext = new StringBuilder();
              int i = 0;
              paramInt = i;
              if (paramCountDownTimer != null)
              {
                paramInt = i;
                if (paramCountDownTimer.length() > 0)
                {
                  paramContext.append(paramCountDownTimer);
                  paramContext.append(":");
                  paramInt = paramCountDownTimer.length() + 1;
                }
              }
              if (bool1)
              {
                paramContext.append("F ");
                label1414:
                if (!(paramCountDownTimerListener instanceof QQText)) {
                  break label1518;
                }
                paramContext = ((QQText)paramCountDownTimerListener).a(paramContext.toString(), true, new int[0]);
                label1439:
                if (!bool1) {
                  break label1540;
                }
                paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
                ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable3), paramInt, paramInt + 1, 33);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                if (!bool2) {
                  break label1414;
                }
                paramContext.append("S ");
                break label1414;
                label1518:
                paramContext.append(paramCountDownTimerListener);
                paramContext = new SpannableString(paramContext.toString());
                break label1439;
                label1540:
                if (bool2)
                {
                  paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
                  ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable2), paramInt, paramInt + 1, 33);
                }
              }
            }
            if (paramCountDownTimerListener != null)
            {
              paramCountDownTimerListener = paramCountDownTimerListener.toString().trim();
              label1614:
              if ((!String.valueOf(AppConstants.Y).equalsIgnoreCase(paramMessage.frienduin)) || (paramCountDownTimerListener == null) || (paramCountDownTimerListener.length() <= 0)) {
                break label1719;
              }
            }
            label1719:
            for (paramContext = a(paramContext, paramQQAppInterface, paramCountDownTimerListener, paramMessage);; paramContext = paramCountDownTimerListener)
            {
              paramContext = a(paramCountDownTimer, null, paramContext, bool1, paramQQAppInterface.a().b(paramMessage), paramDrawable1, paramDrawable2, paramDrawable3);
              if ((paramMessage.msgtype == -1000) && (paramContext != null)) {
                paramContext = new QQText(paramContext, 1, 16);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                paramCountDownTimerListener = null;
                break label1614;
              }
            }
          }
        }
      }
      bool1 = false;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null) {
        localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
      }
    }
    if (localMessage.msgtype == -2005) {
      if (a(paramQQAppInterface, localMessage) != 0) {}
    }
    int i;
    do
    {
      return true;
      return false;
      if (localMessage.fileType != 1) {
        break;
      }
      i = paramQQAppInterface.a().d(localMessage.frienduin, null, localMessage.uniseq);
    } while ((i == 1005) || (i == 1004));
    label110:
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (localMessage.msgtype != -2017) {
        break label110;
      }
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b == 3)) {
          break;
        }
      }
      return false;
    }
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null) {
        localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
      }
    }
    if (localMessage.msgtype == -2005) {
      return 2 == a(paramQQAppInterface, localMessage);
    }
    if (localMessage.msgtype == -2017)
    {
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.b == 1) || (paramQQAppInterface.b == 0))) {
          return true;
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).b() >= 0) && (((BuddyTransfileProcessor)paramMessage).b() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().b(localMessage);
  }
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */