package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
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
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.international.LocaleString;
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
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
      return paramQQAppInterface.a().getString(2131561662);
    }
    return paramQQAppInterface.a().getString(2131563302) + paramContext.messagetail + paramQQAppInterface.a().getString(2131562904);
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
                  paramContext = paramContext.getString(2131561412);
                  break;
                  paramContext = paramContext.getString(2131561403);
                  break;
                  paramContext = paramContext.getString(2131561405);
                  break;
                  paramContext = paramContext.getString(2131561407);
                  break;
                  paramContext = paramContext.getString(2131561406);
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
  
  public static String a(Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() < 4));
    String str1 = ((Matcher)localObject).group(0);
    String str2 = ((Matcher)localObject).group(1);
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0) {
        i = Integer.parseInt(((Matcher)localObject).group(2));
      }
    }
    j = Integer.parseInt(((Matcher)localObject).group(3));
    int k = Integer.parseInt(((Matcher)localObject).group(4));
    Object localObject = new StringBuffer();
    if (i > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131562222));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131562378));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131561401));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2)
  {
    if (paramArrayOfString == null) {
      return "";
    }
    if (paramArrayOfString.length > 1) {
      try
      {
        i = Integer.parseInt(paramArrayOfString[1]);
        switch (i)
        {
        default: 
          return paramContext.getResources().getString(2131560115);
        }
      }
      catch (NumberFormatException paramArrayOfString)
      {
        for (;;)
        {
          int i = 0;
        }
        paramArrayOfString = ContactUtils.a(paramQQAppInterface, paramString2, paramString1, 2, 0);
        paramContext = paramContext.getResources().getString(2131560115);
        paramQQAppInterface = paramArrayOfString;
        if (paramArrayOfString.length() > 11)
        {
          paramQQAppInterface = paramArrayOfString.substring(0, 10);
          paramQQAppInterface = paramQQAppInterface + "...";
        }
        return paramQQAppInterface + paramContext;
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = BaseApplicationImpl.getContext().getString(2131559320);
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    if (paramArrayOfString == null) {
      return "";
    }
    if (paramArrayOfString.length > 1)
    {
      int j;
      try
      {
        i = Integer.parseInt(paramArrayOfString[1]);
        j = k;
        if (paramArrayOfString.length > 3)
        {
          if ("1".equals(paramArrayOfString[3])) {
            j = k;
          }
        }
        else {
          switch (i)
          {
          default: 
            if (j == 0) {
              break label862;
            }
            return paramContext.getResources().getString(2131560100);
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = 0;
          continue;
          j = 0;
        }
        if (paramArrayOfString[0] == null) {
          break label876;
        }
      }
      if (paramContext.getString(2131560133).equals(paramArrayOfString[0]))
      {
        if (j != 0) {
          return paramContext.getResources().getString(2131560107);
        }
        return paramContext.getResources().getString(2131560113);
      }
      if (j != 0) {
        return paramContext.getResources().getString(2131560100) + " " + paramArrayOfString[0];
      }
      return paramContext.getResources().getString(2131560101) + " " + paramArrayOfString[0];
      if (paramArrayOfString[0] != null)
      {
        if (paramContext.getString(2131560131).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131560106);
            }
            return paramContext.getResources().getString(2131560104);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131560112);
          }
          return paramContext.getResources().getString(2131560110);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131560100) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131560101) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131560106);
          }
          return paramContext.getResources().getString(2131560104);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131560112);
        }
        return paramContext.getResources().getString(2131560110);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131560106);
          }
          return paramContext.getResources().getString(2131560104);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131560112);
        }
        return paramContext.getResources().getString(2131560110);
        if (j != 0) {
          return paramContext.getResources().getString(2131560103);
        }
        return paramContext.getResources().getString(2131560109);
        if (j != 0) {
          return paramContext.getResources().getString(2131560100);
        }
        return paramContext.getResources().getString(2131560101);
        if (j != 0) {
          return paramContext.getResources().getString(2131560108);
        }
        return paramContext.getResources().getString(2131560114);
        if (j != 0) {
          return paramContext.getResources().getString(2131560107);
        }
        return paramContext.getResources().getString(2131560113);
        if (paramArrayOfString[0] != null)
        {
          if (paramContext.getString(2131560133).equals(paramArrayOfString[0]))
          {
            if (j != 0) {
              return paramContext.getResources().getString(2131560107);
            }
            return paramContext.getResources().getString(2131560113);
          }
          if (j != 0) {
            return paramContext.getResources().getString(2131560100) + " " + paramArrayOfString[0];
          }
          return paramContext.getResources().getString(2131560101) + " " + paramArrayOfString[0];
          if (paramArrayOfString[0] != null)
          {
            return paramContext.getResources().getString(2131560101) + " " + paramArrayOfString[0];
            label862:
            return paramContext.getResources().getString(2131560101);
          }
        }
      }
    }
    else
    {
      return "";
    }
    label876:
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: iload 6
    //   7: ifne +1692 -> 1699
    //   10: aload_2
    //   11: invokevirtual 352	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   14: ifne +24 -> 38
    //   17: aload_2
    //   18: getfield 355	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   21: ifnull +1678 -> 1699
    //   24: aload_2
    //   25: getfield 355	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   28: aload_2
    //   29: getfield 225	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   32: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +1664 -> 1699
    //   38: aconst_null
    //   39: astore 5
    //   41: aload 5
    //   43: astore 12
    //   45: aload 5
    //   47: ifnull +46 -> 93
    //   50: aload 5
    //   52: astore 12
    //   54: aload 5
    //   56: invokevirtual 232	java/lang/String:length	()I
    //   59: bipush 12
    //   61: if_icmple +32 -> 93
    //   64: new 193	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   71: aload 5
    //   73: iconst_0
    //   74: bipush 11
    //   76: invokevirtual 315	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 317
    //   85: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 12
    //   93: aload_2
    //   94: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   97: sipush -2011
    //   100: if_icmpne +34 -> 134
    //   103: aload_1
    //   104: aload_2
    //   105: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   108: istore 6
    //   110: aload_1
    //   111: aload_2
    //   112: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   115: istore 7
    //   117: aload 12
    //   119: aconst_null
    //   120: aload_2
    //   121: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   124: iload 6
    //   126: iload 7
    //   128: aload 4
    //   130: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   133: return
    //   134: aload_2
    //   135: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   138: sipush -2000
    //   141: if_icmpne +334 -> 475
    //   144: iconst_0
    //   145: istore 7
    //   147: iconst_0
    //   148: istore 8
    //   150: aload_2
    //   151: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   154: astore 5
    //   156: aload_2
    //   157: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   160: aload_2
    //   161: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   164: invokestatic 371	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   167: ifeq +1529 -> 1696
    //   170: aload_2
    //   171: getfield 225	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   174: astore 5
    //   176: aload_1
    //   177: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   180: aload 5
    //   182: aload_2
    //   183: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   186: aload_2
    //   187: getfield 24	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   190: invokevirtual 379	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   193: checkcast 381	com/tencent/mobileqq/data/MessageForPic
    //   196: astore 13
    //   198: aload_1
    //   199: invokevirtual 384	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   202: aload 5
    //   204: aload_2
    //   205: getfield 24	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   208: invokevirtual 389	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   211: astore_1
    //   212: aload_2
    //   213: invokevirtual 352	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   216: ifeq +142 -> 358
    //   219: aload_1
    //   220: ifnonnull +138 -> 358
    //   223: aload 13
    //   225: ifnull +133 -> 358
    //   228: aload 13
    //   230: getfield 392	com/tencent/mobileqq/data/MessageForPic:size	J
    //   233: lstore 10
    //   235: lload 10
    //   237: lconst_0
    //   238: lcmp
    //   239: ifgt +119 -> 358
    //   242: iconst_1
    //   243: istore 6
    //   245: iload 6
    //   247: istore 7
    //   249: aload_1
    //   250: instanceof 394
    //   253: ifeq +167 -> 420
    //   256: aload_1
    //   257: checkcast 394	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 397	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   265: ldc2_w 398
    //   268: lcmp
    //   269: ifeq +1415 -> 1684
    //   272: iconst_1
    //   273: istore 6
    //   275: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +60 -> 338
    //   281: aload_1
    //   282: getfield 407	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   285: ifnull +127 -> 412
    //   288: aload_1
    //   289: getfield 407	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   292: getfield 411	com/tencent/mobileqq/transfile/TransferRequest:a	J
    //   295: lstore 10
    //   297: ldc_w 413
    //   300: iconst_2
    //   301: new 193	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 415
    //   311: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 10
    //   316: invokevirtual 418	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc_w 420
    //   322: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 421	com/tencent/mobileqq/transfile/BaseTransProcessor:a	()Ljava/lang/String;
    //   329: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 12
    //   340: aload_0
    //   341: ldc_w 426
    //   344: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   347: aconst_null
    //   348: iload 7
    //   350: iload 6
    //   352: aload 4
    //   354: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   357: return
    //   358: aload_1
    //   359: ifnull +1331 -> 1690
    //   362: aload_1
    //   363: instanceof 394
    //   366: ifeq +1324 -> 1690
    //   369: aload_1
    //   370: checkcast 394	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   373: invokevirtual 397	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   376: lstore 10
    //   378: lload 10
    //   380: l2i
    //   381: istore_3
    //   382: iload_3
    //   383: sipush 1005
    //   386: if_icmpeq +10 -> 396
    //   389: iload_3
    //   390: sipush 1004
    //   393: if_icmpne +1297 -> 1690
    //   396: iconst_1
    //   397: istore 6
    //   399: goto -154 -> 245
    //   402: astore_2
    //   403: aconst_null
    //   404: astore_1
    //   405: aload_2
    //   406: invokevirtual 429	java/lang/Exception:printStackTrace	()V
    //   409: goto -160 -> 249
    //   412: ldc2_w 32
    //   415: lstore 10
    //   417: goto -120 -> 297
    //   420: iload 8
    //   422: istore 6
    //   424: aload_1
    //   425: ifnull -87 -> 338
    //   428: iconst_1
    //   429: istore 8
    //   431: iload 8
    //   433: istore 6
    //   435: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq -100 -> 338
    //   441: ldc_w 413
    //   444: iconst_2
    //   445: new 193	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 431
    //   455: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_1
    //   459: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: iload 8
    //   470: istore 6
    //   472: goto -134 -> 338
    //   475: aload_2
    //   476: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   479: sipush -2002
    //   482: if_icmpeq +13 -> 495
    //   485: aload_2
    //   486: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   489: sipush -1031
    //   492: if_icmpne +182 -> 674
    //   495: aload_2
    //   496: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   499: astore 5
    //   501: iconst_0
    //   502: istore 9
    //   504: iconst_0
    //   505: istore 8
    //   507: aload_1
    //   508: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   511: aload_2
    //   512: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   515: aload_2
    //   516: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   519: aload_2
    //   520: getfield 24	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   523: invokevirtual 379	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   526: astore 13
    //   528: aload 13
    //   530: instanceof 436
    //   533: ifeq -529 -> 4
    //   536: aload 13
    //   538: checkcast 436	com/tencent/mobileqq/data/MessageForPtt
    //   541: astore 13
    //   543: iload 9
    //   545: istore 6
    //   547: iload 8
    //   549: istore 7
    //   551: aload_2
    //   552: invokevirtual 352	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   555: ifeq +22 -> 577
    //   558: aload 13
    //   560: getfield 439	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   563: ldc2_w 32
    //   566: lcmp
    //   567: ifne +30 -> 597
    //   570: iconst_1
    //   571: istore 6
    //   573: iload 8
    //   575: istore 7
    //   577: aload 12
    //   579: aload_0
    //   580: ldc_w 440
    //   583: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   586: aconst_null
    //   587: iload 6
    //   589: iload 7
    //   591: aload 4
    //   593: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   596: return
    //   597: iload 9
    //   599: istore 6
    //   601: iload 8
    //   603: istore 7
    //   605: aload 13
    //   607: getfield 439	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   610: lconst_0
    //   611: lcmp
    //   612: ifgt -35 -> 577
    //   615: aload_1
    //   616: invokevirtual 384	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   619: aload 5
    //   621: aload 13
    //   623: getfield 443	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   626: aload 13
    //   628: getfield 444	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   631: invokevirtual 447	com/tencent/mobileqq/transfile/TransFileController:d	(Ljava/lang/String;Ljava/lang/String;J)I
    //   634: istore_3
    //   635: iload_3
    //   636: sipush 1005
    //   639: if_icmpeq +15 -> 654
    //   642: iload_3
    //   643: sipush 1004
    //   646: if_icmpeq +8 -> 654
    //   649: iload_3
    //   650: iconst_m1
    //   651: if_icmpne +13 -> 664
    //   654: iconst_1
    //   655: istore 6
    //   657: iload 8
    //   659: istore 7
    //   661: goto -84 -> 577
    //   664: iconst_1
    //   665: istore 7
    //   667: iload 9
    //   669: istore 6
    //   671: goto -94 -> 577
    //   674: aload_2
    //   675: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   678: sipush -1038
    //   681: if_icmpne +47 -> 728
    //   684: aload_2
    //   685: getfield 451	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   688: astore_0
    //   689: new 453	com/tencent/mobileqq/data/MessageForPlayTogetherResult$PlayTogetherResultInfo
    //   692: dup
    //   693: invokespecial 454	com/tencent/mobileqq/data/MessageForPlayTogetherResult$PlayTogetherResultInfo:<init>	()V
    //   696: astore 5
    //   698: aload 5
    //   700: aload_0
    //   701: invokevirtual 458	com/tencent/mobileqq/data/MessageForPlayTogetherResult$PlayTogetherResultInfo:fromBytes	([B)V
    //   704: aload 12
    //   706: aconst_null
    //   707: aload 5
    //   709: getfield 461	com/tencent/mobileqq/data/MessageForPlayTogetherResult$PlayTogetherResultInfo:mGameName	Ljava/lang/String;
    //   712: aload_1
    //   713: aload_2
    //   714: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   717: aload_1
    //   718: aload_2
    //   719: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   722: aload 4
    //   724: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   727: return
    //   728: aload_2
    //   729: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   732: sipush -3008
    //   735: if_icmpne +48 -> 783
    //   738: aload 4
    //   740: new 193	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   747: aload_0
    //   748: ldc_w 462
    //   751: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   754: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: ldc_w 464
    //   760: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_2
    //   764: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   767: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: ldc_w 464
    //   773: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   782: return
    //   783: aload_2
    //   784: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   787: sipush -2015
    //   790: if_icmpne +11 -> 801
    //   793: aload 4
    //   795: ldc 153
    //   797: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   800: return
    //   801: aload_2
    //   802: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   805: invokestatic 473	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   808: ifeq +28 -> 836
    //   811: aload 12
    //   813: aload_0
    //   814: aload_1
    //   815: aload_2
    //   816: invokestatic 475	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   819: aconst_null
    //   820: aload_1
    //   821: aload_2
    //   822: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   825: aload_1
    //   826: aload_2
    //   827: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   830: aload 4
    //   832: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   835: return
    //   836: aload_2
    //   837: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   840: sipush -2017
    //   843: if_icmpne +29 -> 872
    //   846: aload 12
    //   848: aload_0
    //   849: ldc_w 476
    //   852: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   855: aconst_null
    //   856: aload_1
    //   857: aload_2
    //   858: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   861: aload_1
    //   862: aload_2
    //   863: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   866: aload 4
    //   868: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   871: return
    //   872: aload_2
    //   873: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   876: invokestatic 478	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   879: ifeq +35 -> 914
    //   882: aload_2
    //   883: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   886: invokestatic 483	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   889: astore_1
    //   890: aload_1
    //   891: ifnull -887 -> 4
    //   894: aload 4
    //   896: aload_1
    //   897: aload_0
    //   898: aload_2
    //   899: getfield 486	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   902: invokestatic 487	com/tencent/mobileqq/utils/MsgUtils:b	(I)Z
    //   905: iload 7
    //   907: invokestatic 489	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   910: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   913: return
    //   914: aload_2
    //   915: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   918: invokestatic 491	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   921: ifeq +38 -> 959
    //   924: aload_2
    //   925: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   928: invokestatic 483	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   931: astore 5
    //   933: aload 5
    //   935: ifnull -931 -> 4
    //   938: aload 4
    //   940: aload_1
    //   941: aload 5
    //   943: aload_0
    //   944: aload_2
    //   945: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   948: aload_2
    //   949: getfield 225	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   952: invokestatic 493	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   955: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   958: return
    //   959: aload_2
    //   960: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   963: invokestatic 495	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   966: ifeq +29 -> 995
    //   969: aload 12
    //   971: aload_0
    //   972: ldc_w 496
    //   975: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   978: aconst_null
    //   979: aload_1
    //   980: aload_2
    //   981: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   984: aload_1
    //   985: aload_2
    //   986: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   989: aload 4
    //   991: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   994: return
    //   995: aload_2
    //   996: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   999: sipush -1013
    //   1002: if_icmpne +17 -> 1019
    //   1005: aconst_null
    //   1006: aconst_null
    //   1007: aload_2
    //   1008: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1011: iconst_0
    //   1012: iconst_0
    //   1013: aload 4
    //   1015: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1018: return
    //   1019: aload_2
    //   1020: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1023: sipush -2019
    //   1026: if_icmpne +16 -> 1042
    //   1029: aload 4
    //   1031: aload_0
    //   1032: ldc_w 497
    //   1035: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1038: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1041: return
    //   1042: aload_2
    //   1043: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1046: sipush -2005
    //   1049: if_icmpne +56 -> 1105
    //   1052: aload_1
    //   1053: aload_2
    //   1054: invokestatic 500	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1057: astore 5
    //   1059: aload_1
    //   1060: aload_2
    //   1061: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1064: istore 6
    //   1066: aload_1
    //   1067: aload_2
    //   1068: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1071: istore 7
    //   1073: aload 12
    //   1075: aload_0
    //   1076: ldc_w 501
    //   1079: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1082: aconst_null
    //   1083: iload 6
    //   1085: iload 7
    //   1087: aload 4
    //   1089: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1092: aload 5
    //   1094: ifnull -1090 -> 4
    //   1097: aload 4
    //   1099: aload 5
    //   1101: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1104: return
    //   1105: aload_2
    //   1106: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1109: ifnonnull +11 -> 1120
    //   1112: aload 4
    //   1114: ldc 153
    //   1116: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1119: return
    //   1120: aload_1
    //   1121: aload_2
    //   1122: invokestatic 358	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1125: istore 6
    //   1127: aload_1
    //   1128: aload_2
    //   1129: invokestatic 360	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1132: istore 7
    //   1134: aload_2
    //   1135: getfield 504	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   1138: lookupswitch	default:+50->1188, 1:+101->1239, 2:+172->1310, 8:+172->1310, 65536:+83->1221, 65538:+154->1292
    //   1189: aconst_null
    //   1190: <illegal opcode>
    //   1191: aload_2
    //   1192: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1195: invokevirtual 512	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1198: ifeq +166 -> 1364
    //   1201: aload_2
    //   1202: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1205: ifne +159 -> 1364
    //   1208: aload 4
    //   1210: invokestatic 517	com/tencent/mobileqq/systemmsg/SystemMsgController:a	()Lcom/tencent/mobileqq/systemmsg/SystemMsgController;
    //   1213: aload_1
    //   1214: invokevirtual 520	com/tencent/mobileqq/systemmsg/SystemMsgController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   1217: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1220: return
    //   1221: aload 12
    //   1223: ldc 153
    //   1225: aload_2
    //   1226: getfield 363	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1229: iload 6
    //   1231: iload 7
    //   1233: aload 4
    //   1235: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1238: return
    //   1239: aload_2
    //   1240: getfield 31	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1243: sipush 1001
    //   1246: if_icmpne +26 -> 1272
    //   1249: aload_2
    //   1250: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1253: sipush -3001
    //   1256: if_icmpne +16 -> 1272
    //   1259: aload 4
    //   1261: aload_0
    //   1262: ldc_w 521
    //   1265: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1268: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1271: return
    //   1272: aload 12
    //   1274: aload_0
    //   1275: ldc_w 426
    //   1278: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1281: aconst_null
    //   1282: iload 6
    //   1284: iload 7
    //   1286: aload 4
    //   1288: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1291: return
    //   1292: aload 12
    //   1294: aload_0
    //   1295: ldc_w 426
    //   1298: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1301: aconst_null
    //   1302: iconst_0
    //   1303: iconst_0
    //   1304: aload 4
    //   1306: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1309: return
    //   1310: aload_0
    //   1311: ldc_w 440
    //   1314: invokevirtual 236	android/content/Context:getString	(I)Ljava/lang/String;
    //   1317: astore_0
    //   1318: aload_2
    //   1319: getfield 225	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1322: aload_1
    //   1323: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1326: invokestatic 526	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1329: ifeq +22 -> 1351
    //   1332: iload_3
    //   1333: ifeq +18 -> 1351
    //   1336: aload 12
    //   1338: aload_0
    //   1339: ldc 153
    //   1341: iload 6
    //   1343: iload 7
    //   1345: aload 4
    //   1347: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1350: return
    //   1351: aload 12
    //   1353: aload_0
    //   1354: ldc 153
    //   1356: iconst_0
    //   1357: iconst_0
    //   1358: aload 4
    //   1360: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1363: return
    //   1364: aload_2
    //   1365: invokevirtual 530	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   1368: astore 5
    //   1370: aload_2
    //   1371: getfield 533	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   1374: ifnull +171 -> 1545
    //   1377: aload 5
    //   1379: ifnull +166 -> 1545
    //   1382: new 193	java/lang/StringBuilder
    //   1385: dup
    //   1386: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1389: astore_0
    //   1390: aload 12
    //   1392: ifnull +26 -> 1418
    //   1395: aload 12
    //   1397: invokevirtual 232	java/lang/String:length	()I
    //   1400: ifle +18 -> 1418
    //   1403: aload_0
    //   1404: aload 12
    //   1406: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: aload_0
    //   1411: ldc_w 535
    //   1414: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: iload 6
    //   1420: ifeq +59 -> 1479
    //   1423: aload_0
    //   1424: ldc 116
    //   1426: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload 5
    //   1432: instanceof 537
    //   1435: ifeq +59 -> 1494
    //   1438: aload 5
    //   1440: checkcast 537	com/tencent/mobileqq/text/QQText
    //   1443: aload_0
    //   1444: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: iconst_1
    //   1448: iconst_0
    //   1449: newarray int
    //   1451: invokevirtual 540	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   1454: astore_0
    //   1455: aload 4
    //   1457: iconst_1
    //   1458: putfield 543	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   1461: iload 6
    //   1463: ifeq +59 -> 1522
    //   1466: aload 4
    //   1468: iconst_2
    //   1469: putfield 546	com/tencent/mobileqq/activity/recent/MsgSummary:f	I
    //   1472: aload 4
    //   1474: aload_0
    //   1475: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1478: return
    //   1479: iload 7
    //   1481: ifeq -51 -> 1430
    //   1484: aload_0
    //   1485: ldc 147
    //   1487: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: goto -61 -> 1430
    //   1494: aload_0
    //   1495: aload 5
    //   1497: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: new 551	android/text/SpannableString
    //   1504: dup
    //   1505: aload_0
    //   1506: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokespecial 552	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   1512: astore_0
    //   1513: aload 4
    //   1515: iconst_0
    //   1516: putfield 543	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   1519: goto -58 -> 1461
    //   1522: iload 7
    //   1524: ifeq +12 -> 1536
    //   1527: aload 4
    //   1529: iconst_1
    //   1530: putfield 546	com/tencent/mobileqq/activity/recent/MsgSummary:f	I
    //   1533: goto -61 -> 1472
    //   1536: aload 4
    //   1538: iconst_0
    //   1539: putfield 546	com/tencent/mobileqq/activity/recent/MsgSummary:f	I
    //   1542: goto -70 -> 1472
    //   1545: aload 5
    //   1547: ifnull +114 -> 1661
    //   1550: aload 5
    //   1552: invokeinterface 553 1 0
    //   1557: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   1560: astore 5
    //   1562: getstatic 509	com/tencent/mobileqq/app/AppConstants:U	Ljava/lang/String;
    //   1565: aload_2
    //   1566: getfield 28	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1569: invokevirtual 512	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1572: ifeq +106 -> 1678
    //   1575: aload 5
    //   1577: ifnull +101 -> 1678
    //   1580: aload 5
    //   1582: invokevirtual 232	java/lang/String:length	()I
    //   1585: ifle +93 -> 1678
    //   1588: aload_0
    //   1589: aload_1
    //   1590: aload 5
    //   1592: aload_2
    //   1593: invokestatic 555	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1596: astore_0
    //   1597: aload 12
    //   1599: aconst_null
    //   1600: aload_0
    //   1601: iload 6
    //   1603: aload_1
    //   1604: invokevirtual 558	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1607: aload_2
    //   1608: invokevirtual 563	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1611: aload 4
    //   1613: invokestatic 366	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1616: aload_2
    //   1617: getfield 204	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1620: sipush -1000
    //   1623: if_icmpne +44 -> 1667
    //   1626: aload 4
    //   1628: getfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1631: ifnull +36 -> 1667
    //   1634: aload 4
    //   1636: new 537	com/tencent/mobileqq/text/QQText
    //   1639: dup
    //   1640: aload 4
    //   1642: getfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1645: iconst_1
    //   1646: bipush 16
    //   1648: invokespecial 566	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   1651: putfield 469	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1654: aload 4
    //   1656: iconst_1
    //   1657: putfield 543	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   1660: return
    //   1661: aconst_null
    //   1662: astore 5
    //   1664: goto -102 -> 1562
    //   1667: aload 4
    //   1669: iconst_0
    //   1670: putfield 543	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   1673: return
    //   1674: astore_2
    //   1675: goto -1270 -> 405
    //   1678: aload 5
    //   1680: astore_0
    //   1681: goto -84 -> 1597
    //   1684: iconst_0
    //   1685: istore 6
    //   1687: goto -1412 -> 275
    //   1690: iconst_0
    //   1691: istore 6
    //   1693: goto -1448 -> 245
    //   1696: goto -1520 -> 176
    //   1699: goto -1658 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1702	0	paramContext	Context
    //   0	1702	1	paramQQAppInterface	QQAppInterface
    //   0	1702	2	paramMessage	QQMessageFacade.Message
    //   0	1702	3	paramInt	int
    //   0	1702	4	paramMsgSummary	MsgSummary
    //   0	1702	5	paramString	String
    //   0	1702	6	paramBoolean1	boolean
    //   0	1702	7	paramBoolean2	boolean
    //   148	510	8	bool1	boolean
    //   502	166	9	bool2	boolean
    //   233	183	10	l	long
    //   43	1555	12	str	String
    //   196	431	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   150	176	402	java/lang/Exception
    //   176	212	402	java/lang/Exception
    //   212	219	1674	java/lang/Exception
    //   228	235	1674	java/lang/Exception
    //   362	378	1674	java/lang/Exception
  }
  
  public static void a(TextView paramTextView, QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramQQAppInterface, paramArrayOfString, paramContext, paramString1, paramString2));
  }
  
  public static void a(TextView paramTextView, String[] paramArrayOfString, Context paramContext, int paramInt)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramArrayOfString, paramContext, b(paramInt), false));
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
    paramContext.getString(2131561419);
    paramCountDownTimerListener = paramContext.getString(2131561539);
    if (paramMessage.msgtype == -2011)
    {
      paramQQAppInterface = StructMsgFactory.a(paramMessage.msgData);
      if (paramQQAppInterface != null) {
        paramTextView.setText(a(paramCountDownTimer, null, LocaleString.s(paramContext, paramQQAppInterface.mMsgBrief), bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
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
      paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131561544), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
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
                    break label541;
                  }
                  bool1 = true;
                  bool2 = bool3;
                }
              }
              for (;;)
              {
                paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131561555), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                return false;
                label541:
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
            if (paramMessage.msgtype == -1038)
            {
              paramContext = paramMessage.msgData;
              paramQQAppInterface = new MessageForPlayTogetherResult.PlayTogetherResultInfo();
              paramQQAppInterface.fromBytes(paramContext);
              paramTextView.setText(a(paramCountDownTimer, null, paramQQAppInterface.mGameName, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -3008)
            {
              paramTextView.setText(BaseApplicationImpl.getContext().getString(2131558773) + "\"" + paramMessage.msg + "\"");
              return false;
            }
            if (paramMessage.msgtype == -2015)
            {
              paramTextView.setText("");
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
            if (ActionMsgUtil.b(paramMessage.msgtype))
            {
              paramInt = paramMessage.issend;
              a(paramTextView, TransfileUtile.a(paramMessage.msg), paramContext, paramInt);
              return false;
            }
            if (ActionMsgUtil.c(paramMessage.msgtype))
            {
              a(paramTextView, paramQQAppInterface, TransfileUtile.a(paramMessage.msg), paramContext, paramMessage.frienduin, paramMessage.senderuin);
              return false;
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131561548), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == -2017)
            {
              paramTextView.setText(BaseApplicationImpl.getContext().getString(2131559319));
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
                  paramTextView.setText(2131562723);
                }
                else
                {
                  paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131561544), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
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
                        paramTextView.setText(a(paramCountDownTimer, paramContext.getString(2131561544), null, false, false, paramDrawable1, paramDrawable2, paramDrawable3));
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
                            label1248:
                            if (l1 <= 0L) {
                              break label1386;
                            }
                            new StringBuilder().append(l1).append("\"").toString();
                          }
                          label1386:
                          for (;;)
                          {
                            paramContext = paramContext.getString(2131561555);
                            if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(paramQQAppInterface.a())) || (paramInt == 0)) {
                              break label1389;
                            }
                            paramTextView.setText(a(paramCountDownTimer, paramContext, "", bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                            break;
                            l1 = l2;
                            if (paramMessage.pttUrl == null) {
                              break label1248;
                            }
                            l1 = l2;
                            if (paramMessage.pttUrl.toLowerCase().startsWith("http")) {
                              break label1248;
                            }
                            l1 = QQRecorder.a(paramMessage.pttUrl);
                            paramMessage.fileSize = l1;
                            break label1248;
                          }
                          label1389:
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
            if ((String.valueOf(AppConstants.U).equalsIgnoreCase(paramMessage.frienduin)) && (paramMessage.istroop == 0))
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
                label1562:
                if (!(paramCountDownTimerListener instanceof QQText)) {
                  break label1666;
                }
                paramContext = ((QQText)paramCountDownTimerListener).a(paramContext.toString(), true, new int[0]);
                label1587:
                if (!bool1) {
                  break label1688;
                }
                paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
                ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable3), paramInt, paramInt + 1, 33);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                if (!bool2) {
                  break label1562;
                }
                paramContext.append("S ");
                break label1562;
                label1666:
                paramContext.append(paramCountDownTimerListener);
                paramContext = new SpannableString(paramContext.toString());
                break label1587;
                label1688:
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
              label1764:
              if ((!String.valueOf(AppConstants.U).equalsIgnoreCase(paramMessage.frienduin)) || (paramCountDownTimerListener == null) || (paramCountDownTimerListener.length() <= 0)) {
                break label1869;
              }
            }
            label1869:
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
                break label1764;
              }
            }
          }
        }
      }
      bool1 = false;
    }
  }
  
  public static boolean a(Context paramContext, MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null) {}
    String str;
    do
    {
      return false;
      str = paramMessageForVideo.text;
    } while ((paramMessageForVideo.isSend()) || (!str.contains(paramContext.getString(2131560131))));
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MsgUtils
 * JD-Core Version:    0.7.0.1
 */