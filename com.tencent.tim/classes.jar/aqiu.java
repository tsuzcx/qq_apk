import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aqiu
{
  private static float AF = 0.0F;
  private static float AG = 0.0F;
  private static float AH;
  private static long asK;
  private static long asL;
  private static int dZo;
  
  public static String N(Context paramContext, String paramString)
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
      ((StringBuffer)localObject).append(i).append(paramContext.getString(2131694709));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131695950));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131719352));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
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
      if ((((FileManagerEntity)localObject).status == 0) && (!((FileManagerEntity)localObject).isSend())) {
        return 1;
      }
      if ((((FileManagerEntity)localObject).status == 16) && (((FileManagerEntity)localObject).bSend) && (!((FileManagerEntity)localObject).bOnceSuccess)) {
        return 0;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).find(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessage.frienduin });
    ((EntityManager)localObject).close();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = ahav.hM(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(aqgb.bM(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.getApp().getString(2131690418);
    }
    return paramQQAppInterface.getApp().getString(2131690420) + paramContext.messagetail + paramQQAppInterface.getApp().getString(2131690421);
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
        String str2 = aqfs.cu(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = aqgv.b(paramQQAppInterface, paramMessage.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessage.senderuin))) {
                break label279;
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
    label279:
    label444:
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
                  paramContext = paramContext.getString(2131689802);
                  break;
                  paramContext = paramContext.getString(2131689600);
                  break;
                  paramContext = paramContext.getString(2131689599);
                  break;
                  paramContext = paramContext.getString(2131718685);
                  break;
                  paramContext = paramContext.getString(2131689856);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != -1020) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != -1023) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label444;
                }
                paramContext = aqfs.pj(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = aqgv.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return aqfs.I(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == -1021) {
        break label467;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != -1022);
    label467:
    paramString = aqfs.f(paramString, paramQQAppInterface);
    paramMessage = aqfs.pj(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = aqgv.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = aqfs.I(paramString, paramMessage, paramQQAppInterface);
            }
          }
        }
      }
    }
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    if (paramArrayOfString == null)
    {
      paramArrayOfString = "";
      label10:
      return paramArrayOfString;
    }
    if ((paramInt == 1) || (paramInt == 5000)) {}
    for (int i = 1;; i = 2)
    {
      for (;;)
      {
        if (paramArrayOfString.length <= 1) {
          break label366;
        }
        try
        {
          j = Integer.parseInt(paramArrayOfString[1]);
          switch (j)
          {
          default: 
            paramString1 = paramContext.getResources().getString(2131697750);
            if ((paramInt == 1) || (paramInt == 5000)) {
              paramString1 = paramContext.getResources().getString(2131697773);
            }
            if (paramArrayOfString.length <= 5) {
              break;
            }
          case 13: 
            try
            {
              paramInt = Integer.parseInt(paramArrayOfString[4]);
            }
            catch (Exception paramArrayOfString)
            {
              label150:
              for (;;)
              {
                boolean bool;
                label126:
                paramInt = 0;
              }
            }
            try
            {
              bool = Boolean.parseBoolean(paramArrayOfString[5]);
              k = bool;
            }
            catch (Exception paramArrayOfString)
            {
              break label126;
            }
            paramArrayOfString = paramString1;
            if (paramInt != 2) {
              break label10;
            }
            if (k == 0) {
              break label352;
            }
            paramArrayOfString = paramQQAppInterface.getApp().getString(2131697775);
            paramArrayOfString = ":" + paramArrayOfString;
            return paramString1.replace(paramQQAppInterface.getApp().getString(2131697773), paramArrayOfString);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int j = 0;
          }
          if (paramString2 == null) {
            break label310;
          }
        }
      }
      paramString2 = aqgv.a(paramQQAppInterface, paramString2, paramString1, i, 0);
      paramString1 = paramContext.getResources().getString(2131697750);
      if ((paramInt == 1) || (paramInt == 5000)) {
        paramString1 = paramContext.getResources().getString(2131697773);
      }
      if (paramString2.length() > 11) {
        paramContext = paramString2.substring(0, 10);
      }
      for (paramContext = paramContext + "...";; paramContext = paramString2)
      {
        paramString1 = paramContext + paramString1;
        break;
        label310:
        if ((paramInt == 1) || (paramInt == 5000))
        {
          paramString1 = paramContext.getResources().getString(2131697770);
          break;
        }
        paramString1 = paramContext.getResources().getString(2131697702);
        break;
        label352:
        paramArrayOfString = paramQQAppInterface.getApp().getString(2131697770);
        break label150;
        label366:
        return "";
        paramInt = 0;
        break label126;
      }
    }
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      label11:
      return localObject;
    }
    if (paramArrayOfString.length > 1) {
      for (;;)
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
                break label913;
              }
              paramContext = paramContext.getResources().getString(2131698159);
              localObject = paramContext;
              if (TextUtils.isEmpty(paramArrayOfString[0])) {
                break label11;
              }
              return paramContext + " " + paramArrayOfString[0];
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i = 0;
          continue;
          j = 0;
          continue;
          if (paramArrayOfString[0] == null) {
            break label930;
          }
        }
        if (paramContext.getString(2131721716).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131698176);
          }
          return paramContext.getResources().getString(2131697569);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131698159) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131697555) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131721720).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131698172);
            }
            return paramContext.getResources().getString(2131698171);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131697564);
          }
          return paramContext.getResources().getString(2131697563);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131698159) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131697555) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131698172);
          }
          return paramContext.getResources().getString(2131698171);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131697564);
        }
        return paramContext.getResources().getString(2131697563);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131698172);
          }
          return paramContext.getResources().getString(2131698171);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131697564);
        }
        return paramContext.getResources().getString(2131697563);
        if (j != 0) {
          return paramContext.getResources().getString(2131698173);
        }
        return paramContext.getResources().getString(2131697565);
        if (j != 0) {
          return paramContext.getResources().getString(2131698159);
        }
        return paramContext.getResources().getString(2131697555);
        if (j != 0) {
          return paramContext.getResources().getString(2131698160);
        }
        return paramContext.getResources().getString(2131697557);
        if (j != 0) {
          return paramContext.getResources().getString(2131698175);
        }
        return paramContext.getResources().getString(2131697568);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131721716).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131698176);
          }
          return paramContext.getResources().getString(2131697569);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131698159) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131697555) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131697555) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131697555);
      }
    }
    return "";
    label930:
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: iload_3
    //   9: aload 4
    //   11: aload 5
    //   13: iload 6
    //   15: iload 7
    //   17: invokestatic 346	aqiu:b	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;ILcom/tencent/mobileqq/activity/recent/MsgSummary;Ljava/lang/String;ZZ)Z
    //   20: ifne -16 -> 4
    //   23: aload 5
    //   25: astore 16
    //   27: aload_2
    //   28: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   31: ifeq +7829 -> 7860
    //   34: aload 5
    //   36: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +24 -> 63
    //   42: aload 5
    //   44: astore 16
    //   46: aload 5
    //   48: aload_1
    //   49: aload_2
    //   50: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: iconst_1
    //   54: invokestatic 353	aqgv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   57: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +7800 -> 7860
    //   63: aload_1
    //   64: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   67: aload_2
    //   68: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   71: aload_2
    //   72: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   75: aload_2
    //   76: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   79: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   82: astore 16
    //   84: aload 16
    //   86: instanceof 363
    //   89: ifeq +11 -> 100
    //   92: aload 16
    //   94: checkcast 363	com/tencent/mobileqq/data/ChatMessage
    //   97: invokevirtual 366	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   100: aload 16
    //   102: ifnull +13 -> 115
    //   105: aload 16
    //   107: invokestatic 369	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljof$a;
    //   110: getfield 374	jof$a:TG	Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: astore 16
    //   119: aload 5
    //   121: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifeq +7736 -> 7860
    //   127: aload_2
    //   128: invokestatic 369	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljof$a;
    //   131: getfield 374	jof$a:TG	Ljava/lang/String;
    //   134: astore 5
    //   136: aload 5
    //   138: astore 16
    //   140: iload 6
    //   142: ifne +42 -> 184
    //   145: aload_2
    //   146: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   149: ifne +32 -> 181
    //   152: aload 5
    //   154: astore 16
    //   156: aload_2
    //   157: getfield 380	com/tencent/imcore/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   160: ifnull +24 -> 184
    //   163: aload 5
    //   165: astore 16
    //   167: aload_2
    //   168: getfield 380	com/tencent/imcore/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   171: aload_2
    //   172: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   175: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   178: ifeq +6 -> 184
    //   181: aconst_null
    //   182: astore 16
    //   184: aload_2
    //   185: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   188: invokestatic 385	top:fD	(I)Z
    //   191: ifeq +6 -> 197
    //   194: aconst_null
    //   195: astore 16
    //   197: aload_2
    //   198: invokestatic 390	apsb:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lapsb$a;
    //   201: astore 5
    //   203: aload 5
    //   205: ifnull +10 -> 215
    //   208: aload 5
    //   210: getfield 395	apsb$a:nickname	Ljava/lang/String;
    //   213: astore 16
    //   215: aload 16
    //   217: invokestatic 398	aqiu:pD	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 19
    //   222: aload_2
    //   223: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   226: sipush -2034
    //   229: if_icmpne +16 -> 245
    //   232: aload 4
    //   234: aload_2
    //   235: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   238: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   244: return
    //   245: aload_2
    //   246: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   249: sipush -2011
    //   252: if_icmpne +157 -> 409
    //   255: iconst_0
    //   256: istore_3
    //   257: iconst_0
    //   258: istore 8
    //   260: aload_2
    //   261: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   264: sipush -2011
    //   267: if_icmpne +29 -> 296
    //   270: aload_2
    //   271: getfield 415	com/tencent/imcore/message/QQMessageFacade$Message:extInt	I
    //   274: bipush 61
    //   276: if_icmpne +20 -> 296
    //   279: aload_2
    //   280: aload_1
    //   281: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: invokevirtual 416	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   287: ldc_w 417
    //   290: invokevirtual 299	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   293: putfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   296: aload_2
    //   297: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   300: iconst_1
    //   301: if_icmpne +73 -> 374
    //   304: aload_1
    //   305: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   308: aload_2
    //   309: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   312: aload_2
    //   313: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   316: aload_2
    //   317: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   320: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   323: astore_0
    //   324: iload 8
    //   326: istore_3
    //   327: aload_0
    //   328: invokestatic 422	ajpt:aL	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   331: ifeq +21 -> 352
    //   334: aconst_null
    //   335: aconst_null
    //   336: aload_0
    //   337: checkcast 424	com/tencent/mobileqq/data/MessageForStructing
    //   340: invokestatic 428	ajpt:h	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   343: iconst_0
    //   344: iconst_0
    //   345: aload 4
    //   347: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   350: iconst_1
    //   351: istore_3
    //   352: aload_0
    //   353: invokestatic 436	apsa:B	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   356: ifeq +18 -> 374
    //   359: aconst_null
    //   360: aconst_null
    //   361: aload_2
    //   362: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   365: iconst_0
    //   366: iconst_0
    //   367: aload 4
    //   369: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   372: iconst_1
    //   373: istore_3
    //   374: iload_3
    //   375: ifne -371 -> 4
    //   378: aload_1
    //   379: aload_2
    //   380: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   383: istore 6
    //   385: aload_1
    //   386: aload_2
    //   387: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   390: istore 7
    //   392: aload 19
    //   394: aconst_null
    //   395: aload_2
    //   396: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   399: iload 6
    //   401: iload 7
    //   403: aload 4
    //   405: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   408: return
    //   409: aload_2
    //   410: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   413: sipush -2000
    //   416: if_icmpeq +13 -> 429
    //   419: aload_2
    //   420: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   423: sipush -5015
    //   426: if_icmpne +453 -> 879
    //   429: iconst_0
    //   430: istore 7
    //   432: iconst_0
    //   433: istore 10
    //   435: aconst_null
    //   436: astore 18
    //   438: aconst_null
    //   439: astore 5
    //   441: aload_2
    //   442: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   445: astore 17
    //   447: aload_2
    //   448: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   451: aload_2
    //   452: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   455: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   458: ifeq +7399 -> 7857
    //   461: aload_2
    //   462: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   465: astore 17
    //   467: aload_1
    //   468: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   471: aload 17
    //   473: aload_2
    //   474: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   477: aload_2
    //   478: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   481: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   484: checkcast 449	com/tencent/mobileqq/data/MessageForPic
    //   487: astore 16
    //   489: aload 18
    //   491: astore 5
    //   493: aload_1
    //   494: invokevirtual 452	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   497: aload 17
    //   499: aload_2
    //   500: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   503: invokevirtual 457	aooi:a	(Ljava/lang/String;J)Laqoi;
    //   506: astore_1
    //   507: aload_1
    //   508: astore 5
    //   510: aload_2
    //   511: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   514: ifeq +231 -> 745
    //   517: aload 16
    //   519: ifnull +201 -> 720
    //   522: aload_1
    //   523: astore 5
    //   525: aload 16
    //   527: getfield 460	com/tencent/mobileqq/data/MessageForPic:size	J
    //   530: lstore 14
    //   532: lload 14
    //   534: lconst_0
    //   535: lcmp
    //   536: ifgt +184 -> 720
    //   539: aload_1
    //   540: ifnonnull +7311 -> 7851
    //   543: iconst_1
    //   544: istore 6
    //   546: aload 16
    //   548: astore 5
    //   550: iload 6
    //   552: istore 7
    //   554: aload_1
    //   555: astore 16
    //   557: aload 16
    //   559: instanceof 462
    //   562: ifeq +260 -> 822
    //   565: aload 16
    //   567: checkcast 462	aojn
    //   570: astore_1
    //   571: aload_1
    //   572: invokevirtual 466	aojn:hh	()J
    //   575: ldc2_w 467
    //   578: lcmp
    //   579: ifeq +7266 -> 7845
    //   582: iconst_1
    //   583: istore 6
    //   585: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq +60 -> 648
    //   591: aload_1
    //   592: getfield 476	aojn:h	Laool;
    //   595: ifnull +219 -> 814
    //   598: aload_1
    //   599: getfield 476	aojn:h	Laool;
    //   602: getfield 481	aool:mUniseq	J
    //   605: lstore 14
    //   607: ldc_w 483
    //   610: iconst_2
    //   611: new 230	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 485
    //   621: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: lload 14
    //   626: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: ldc_w 490
    //   632: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_1
    //   636: invokevirtual 493	aojn:getKey	()Ljava/lang/String;
    //   639: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 496	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aload_0
    //   649: ldc_w 497
    //   652: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   655: astore_1
    //   656: aload_2
    //   657: invokestatic 502	acfx:W	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   660: ifne +10 -> 670
    //   663: aload_2
    //   664: invokestatic 505	acei:W	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   667: ifeq +11 -> 678
    //   670: aload_0
    //   671: ldc_w 506
    //   674: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   677: astore_1
    //   678: aload_2
    //   679: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   682: sipush -5015
    //   685: if_icmpne +11 -> 696
    //   688: aload_0
    //   689: ldc_w 507
    //   692: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   695: astore_1
    //   696: aload 5
    //   698: invokestatic 510	aqiu:c	(Lcom/tencent/mobileqq/data/MessageForPic;)Ljava/lang/String;
    //   701: astore_0
    //   702: aload_0
    //   703: ifnull +7137 -> 7840
    //   706: aload 19
    //   708: aload_0
    //   709: aconst_null
    //   710: iload 7
    //   712: iload 6
    //   714: aload 4
    //   716: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   719: return
    //   720: aload 16
    //   722: ifnull +7129 -> 7851
    //   725: aload_1
    //   726: astore 5
    //   728: aload 16
    //   730: getfield 513	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   733: ldc_w 514
    //   736: if_icmpne +7131 -> 7867
    //   739: iconst_1
    //   740: istore 6
    //   742: goto -196 -> 546
    //   745: aload_1
    //   746: ifnull +7105 -> 7851
    //   749: aload_1
    //   750: astore 5
    //   752: aload_1
    //   753: instanceof 462
    //   756: ifeq +7095 -> 7851
    //   759: aload_1
    //   760: astore 5
    //   762: aload_1
    //   763: checkcast 462	aojn
    //   766: invokevirtual 466	aojn:hh	()J
    //   769: lstore 14
    //   771: lload 14
    //   773: l2i
    //   774: istore_3
    //   775: iload_3
    //   776: sipush 1005
    //   779: if_icmpeq +10 -> 789
    //   782: iload_3
    //   783: sipush 1004
    //   786: if_icmpne +7065 -> 7851
    //   789: iconst_1
    //   790: istore 6
    //   792: goto -246 -> 546
    //   795: astore 16
    //   797: aconst_null
    //   798: astore_1
    //   799: aload 16
    //   801: invokevirtual 517	java/lang/Exception:printStackTrace	()V
    //   804: aload 5
    //   806: astore 16
    //   808: aload_1
    //   809: astore 5
    //   811: goto -254 -> 557
    //   814: ldc2_w 114
    //   817: lstore 14
    //   819: goto -212 -> 607
    //   822: iload 10
    //   824: istore 6
    //   826: aload 16
    //   828: ifnull -180 -> 648
    //   831: iconst_1
    //   832: istore 10
    //   834: iload 10
    //   836: istore 6
    //   838: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq -193 -> 648
    //   844: ldc_w 483
    //   847: iconst_2
    //   848: new 230	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 519
    //   858: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload 16
    //   863: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 496	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: iload 10
    //   874: istore 6
    //   876: goto -228 -> 648
    //   879: aload_2
    //   880: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   883: sipush -2002
    //   886: if_icmpeq +13 -> 899
    //   889: aload_2
    //   890: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   893: sipush -1031
    //   896: if_icmpne +265 -> 1161
    //   899: aload_2
    //   900: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   903: astore 16
    //   905: aload_2
    //   906: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   909: aload_2
    //   910: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   913: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   916: ifeq +6921 -> 7837
    //   919: aload_2
    //   920: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   923: astore 16
    //   925: iconst_0
    //   926: istore 6
    //   928: aload_0
    //   929: ldc_w 523
    //   932: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   935: astore_0
    //   936: aload_1
    //   937: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   940: aload 16
    //   942: aload_2
    //   943: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   946: aload_2
    //   947: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   950: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   953: astore 5
    //   955: aload 5
    //   957: instanceof 525
    //   960: ifeq +6871 -> 7831
    //   963: aload 5
    //   965: checkcast 525	com/tencent/mobileqq/data/MessageForPtt
    //   968: astore 17
    //   970: aload 17
    //   972: invokevirtual 528	com/tencent/mobileqq/data/MessageForPtt:getSummaryMsg	()Ljava/lang/String;
    //   975: astore 5
    //   977: aload 5
    //   979: astore_0
    //   980: aload_2
    //   981: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   984: ifeq +6847 -> 7831
    //   987: aload 17
    //   989: getfield 531	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   992: ldc2_w 114
    //   995: lcmp
    //   996: ifne +52 -> 1048
    //   999: iconst_1
    //   1000: istore 6
    //   1002: aload 5
    //   1004: astore_0
    //   1005: iconst_0
    //   1006: istore 7
    //   1008: ldc_w 533
    //   1011: iconst_2
    //   1012: anewarray 4	java/lang/Object
    //   1015: dup
    //   1016: iconst_0
    //   1017: iload 6
    //   1019: invokestatic 536	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_1
    //   1025: iload 7
    //   1027: invokestatic 536	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1030: aastore
    //   1031: invokestatic 542	afck:l	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: aload 19
    //   1036: aload_0
    //   1037: aconst_null
    //   1038: iload 6
    //   1040: iload 7
    //   1042: aload 4
    //   1044: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1047: return
    //   1048: aload 5
    //   1050: astore_0
    //   1051: aload 17
    //   1053: getfield 531	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1056: lconst_0
    //   1057: lcmp
    //   1058: ifgt +6773 -> 7831
    //   1061: aload_1
    //   1062: invokevirtual 452	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   1065: aload 16
    //   1067: aload 17
    //   1069: getfield 545	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   1072: aload 17
    //   1074: getfield 546	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   1077: invokevirtual 549	aooi:c	(Ljava/lang/String;Ljava/lang/String;J)I
    //   1080: istore_3
    //   1081: iload_3
    //   1082: sipush 1005
    //   1085: if_icmpeq +15 -> 1100
    //   1088: iload_3
    //   1089: sipush 1004
    //   1092: if_icmpeq +8 -> 1100
    //   1095: iload_3
    //   1096: iconst_m1
    //   1097: if_icmpne +55 -> 1152
    //   1100: iconst_1
    //   1101: istore 7
    //   1103: iconst_0
    //   1104: istore 6
    //   1106: ldc_w 533
    //   1109: iconst_2
    //   1110: anewarray 4	java/lang/Object
    //   1113: dup
    //   1114: iconst_0
    //   1115: aload 17
    //   1117: getfield 531	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   1120: invokestatic 554	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1123: aastore
    //   1124: dup
    //   1125: iconst_1
    //   1126: iload_3
    //   1127: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1130: aastore
    //   1131: invokestatic 542	afck:l	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1134: aload 5
    //   1136: astore_0
    //   1137: iload 6
    //   1139: istore 10
    //   1141: iload 7
    //   1143: istore 6
    //   1145: iload 10
    //   1147: istore 7
    //   1149: goto -141 -> 1008
    //   1152: iconst_1
    //   1153: istore 6
    //   1155: iconst_0
    //   1156: istore 7
    //   1158: goto -52 -> 1106
    //   1161: aload_2
    //   1162: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1165: sipush -3008
    //   1168: if_icmpne +48 -> 1216
    //   1171: aload 4
    //   1173: new 230	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1180: aload_0
    //   1181: ldc_w 558
    //   1184: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   1187: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: ldc_w 560
    //   1193: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_2
    //   1197: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1200: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: ldc_w 560
    //   1206: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1215: return
    //   1216: aload_2
    //   1217: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1220: sipush -2015
    //   1223: if_icmpeq +73 -> 1296
    //   1226: aload_2
    //   1227: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1230: sipush -2060
    //   1233: if_icmpeq +63 -> 1296
    //   1236: aload_2
    //   1237: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1240: sipush -2065
    //   1243: if_icmpeq +53 -> 1296
    //   1246: aload_2
    //   1247: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1250: sipush -7010
    //   1253: if_icmpeq +43 -> 1296
    //   1256: aload_2
    //   1257: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1260: sipush -7009
    //   1263: if_icmpeq +33 -> 1296
    //   1266: aload_2
    //   1267: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1270: sipush -7011
    //   1273: if_icmpeq +23 -> 1296
    //   1276: aload_2
    //   1277: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1280: sipush -4023
    //   1283: if_icmpeq +13 -> 1296
    //   1286: aload_2
    //   1287: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1290: sipush -4024
    //   1293: if_icmpne +11 -> 1304
    //   1296: aload 4
    //   1298: ldc 191
    //   1300: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1303: return
    //   1304: aload_2
    //   1305: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1308: invokestatic 565	aqfw:mn	(I)Z
    //   1311: ifeq +28 -> 1339
    //   1314: aload 19
    //   1316: aload_0
    //   1317: aload_1
    //   1318: aload_2
    //   1319: invokestatic 567	aqiu:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1322: aconst_null
    //   1323: aload_1
    //   1324: aload_2
    //   1325: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1328: aload_1
    //   1329: aload_2
    //   1330: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1333: aload 4
    //   1335: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1338: return
    //   1339: aload_2
    //   1340: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1343: sipush -2017
    //   1346: if_icmpne +94 -> 1440
    //   1349: aload_0
    //   1350: ldc_w 568
    //   1353: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   1356: astore 5
    //   1358: aload_2
    //   1359: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1362: astore_0
    //   1363: aload_2
    //   1364: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1367: aload_2
    //   1368: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1371: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   1374: ifeq +8 -> 1382
    //   1377: aload_2
    //   1378: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1381: astore_0
    //   1382: aload_1
    //   1383: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1386: aload_0
    //   1387: aload_2
    //   1388: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   1391: aload_2
    //   1392: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   1395: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1398: astore 16
    //   1400: aload 5
    //   1402: astore_0
    //   1403: aload 16
    //   1405: instanceof 570
    //   1408: ifeq +12 -> 1420
    //   1411: aload 16
    //   1413: checkcast 570	com/tencent/mobileqq/data/MessageForTroopFile
    //   1416: invokevirtual 571	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1419: astore_0
    //   1420: aload 19
    //   1422: aload_0
    //   1423: aconst_null
    //   1424: aload_1
    //   1425: aload_2
    //   1426: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1429: aload_1
    //   1430: aload_2
    //   1431: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1434: aload 4
    //   1436: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1439: return
    //   1440: aload_2
    //   1441: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1444: invokestatic 574	aqfw:fJ	(I)Z
    //   1447: ifeq +35 -> 1482
    //   1450: aload_2
    //   1451: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1454: invokestatic 580	aoon:t	(Ljava/lang/String;)[Ljava/lang/String;
    //   1457: astore_1
    //   1458: aload_1
    //   1459: ifnull -1455 -> 4
    //   1462: aload 4
    //   1464: aload_1
    //   1465: aload_0
    //   1466: aload_2
    //   1467: getfield 583	com/tencent/imcore/message/QQMessageFacade$Message:issend	I
    //   1470: invokestatic 586	aqiu:mt	(I)Z
    //   1473: iload 7
    //   1475: invokestatic 588	aqiu:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1478: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1481: return
    //   1482: aload_2
    //   1483: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1486: invokestatic 591	aqfw:cJ	(I)Z
    //   1489: ifeq +39 -> 1528
    //   1492: aload_2
    //   1493: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1496: invokestatic 580	aoon:t	(Ljava/lang/String;)[Ljava/lang/String;
    //   1499: astore 5
    //   1501: aload 5
    //   1503: ifnull -1499 -> 4
    //   1506: aload 4
    //   1508: aload_1
    //   1509: aload 5
    //   1511: aload_0
    //   1512: aload_2
    //   1513: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1516: aload_2
    //   1517: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1520: iload_3
    //   1521: invokestatic 593	aqiu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1524: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   1527: return
    //   1528: aload_2
    //   1529: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1532: invokestatic 596	aqfw:mo	(I)Z
    //   1535: ifeq +134 -> 1669
    //   1538: aload_1
    //   1539: aload_2
    //   1540: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1543: istore 6
    //   1545: aload_1
    //   1546: aload_2
    //   1547: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1550: istore 7
    //   1552: aload_2
    //   1553: ldc_w 598
    //   1556: invokevirtual 601	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: astore 5
    //   1561: getstatic 606	com/tencent/mobileqq/emoticon/EmojiStickerManager:bYE	Z
    //   1564: ifeq +96 -> 1660
    //   1567: aload 5
    //   1569: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1572: ifne +88 -> 1660
    //   1575: aload_0
    //   1576: aload_2
    //   1577: invokestatic 611	afgc:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1580: astore_0
    //   1581: aload_2
    //   1582: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1585: aload_1
    //   1586: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1589: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1592: ifeq +41 -> 1633
    //   1595: new 230	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 612
    //   1605: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   1608: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload_0
    //   1612: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: astore_0
    //   1619: aload 19
    //   1621: aload_0
    //   1622: aconst_null
    //   1623: iload 6
    //   1625: iload 7
    //   1627: aload 4
    //   1629: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1632: return
    //   1633: new 230	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1640: ldc_w 618
    //   1643: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   1646: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: aload_0
    //   1650: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1656: astore_0
    //   1657: goto -38 -> 1619
    //   1660: aload_0
    //   1661: aload_2
    //   1662: invokestatic 611	afgc:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1665: astore_0
    //   1666: goto -47 -> 1619
    //   1669: aload_2
    //   1670: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   1673: sipush -2058
    //   1676: if_icmpne +1070 -> 2746
    //   1679: ldc 191
    //   1681: astore 18
    //   1683: aload_1
    //   1684: aload_2
    //   1685: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1688: istore 12
    //   1690: aload_1
    //   1691: aload_2
    //   1692: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   1695: istore 13
    //   1697: iconst_0
    //   1698: istore 8
    //   1700: aload 18
    //   1702: astore 17
    //   1704: aload_2
    //   1705: ldc_w 620
    //   1708: invokevirtual 601	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1711: astore 5
    //   1713: aload 18
    //   1715: astore 16
    //   1717: aload 18
    //   1719: astore 17
    //   1721: aload 5
    //   1723: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1726: ifne +270 -> 1996
    //   1729: aload 18
    //   1731: astore 17
    //   1733: new 622	org/json/JSONObject
    //   1736: dup
    //   1737: aload 5
    //   1739: invokespecial 625	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1742: ldc_w 627
    //   1745: invokevirtual 630	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1748: istore 9
    //   1750: iload 8
    //   1752: istore_3
    //   1753: aload 18
    //   1755: astore 5
    //   1757: aload 18
    //   1759: astore 17
    //   1761: aload_2
    //   1762: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1765: ifnull +114 -> 1879
    //   1768: iload 8
    //   1770: istore_3
    //   1771: aload 18
    //   1773: astore 5
    //   1775: iload 9
    //   1777: sipush -2007
    //   1780: if_icmpne +99 -> 1879
    //   1783: iload 8
    //   1785: istore_3
    //   1786: aload 18
    //   1788: astore 5
    //   1790: aload 18
    //   1792: astore 17
    //   1794: aload_2
    //   1795: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   1798: invokestatic 639	aczw:c	([B)Ljava/lang/Object;
    //   1801: instanceof 641
    //   1804: ifeq +75 -> 1879
    //   1807: aload 18
    //   1809: astore 17
    //   1811: getstatic 606	com/tencent/mobileqq/emoticon/EmojiStickerManager:bYE	Z
    //   1814: ifeq +232 -> 2046
    //   1817: aload 18
    //   1819: astore 17
    //   1821: aload_0
    //   1822: aload_2
    //   1823: invokestatic 611	afgc:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1826: astore 5
    //   1828: aload 18
    //   1830: astore 17
    //   1832: aload_2
    //   1833: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1836: aload_1
    //   1837: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1840: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1843: ifeq +170 -> 2013
    //   1846: aload 18
    //   1848: astore 17
    //   1850: new 230	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1857: ldc_w 642
    //   1860: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   1863: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: aload 5
    //   1868: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: astore 5
    //   1876: goto +5997 -> 7873
    //   1879: aload 5
    //   1881: astore 16
    //   1883: iload_3
    //   1884: ifne +112 -> 1996
    //   1887: aload 5
    //   1889: astore 17
    //   1891: getstatic 606	com/tencent/mobileqq/emoticon/EmojiStickerManager:bYE	Z
    //   1894: ifeq +208 -> 2102
    //   1897: aload 5
    //   1899: astore 17
    //   1901: aload_2
    //   1902: ldc_w 598
    //   1905: invokevirtual 601	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1908: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1911: ifne +5914 -> 7825
    //   1914: aload 5
    //   1916: astore 17
    //   1918: aload_1
    //   1919: aload_2
    //   1920: aload 4
    //   1922: invokestatic 645	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laofk;
    //   1925: astore_0
    //   1926: new 230	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   1933: astore_1
    //   1934: aload 19
    //   1936: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1939: ifne +16 -> 1955
    //   1942: aload_1
    //   1943: aload 19
    //   1945: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc_w 647
    //   1951: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: pop
    //   1955: aload_2
    //   1956: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1959: ifne +16 -> 1975
    //   1962: iload 12
    //   1964: ifeq +98 -> 2062
    //   1967: aload_1
    //   1968: ldc_w 649
    //   1971: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: pop
    //   1975: aload_0
    //   1976: checkcast 651	aofk
    //   1979: aload_1
    //   1980: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1983: iconst_1
    //   1984: iconst_0
    //   1985: newarray int
    //   1987: invokevirtual 654	aofk:a	(Ljava/lang/String;Z[I)Laofk;
    //   1990: astore_1
    //   1991: aload_1
    //   1992: astore_0
    //   1993: aload_0
    //   1994: astore 16
    //   1996: aload 16
    //   1998: astore_2
    //   1999: aload 19
    //   2001: aload_2
    //   2002: aconst_null
    //   2003: iload 12
    //   2005: iload 13
    //   2007: aload 4
    //   2009: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2012: return
    //   2013: aload 18
    //   2015: astore 17
    //   2017: new 230	java/lang/StringBuilder
    //   2020: dup
    //   2021: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2024: ldc_w 655
    //   2027: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   2030: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: aload 5
    //   2035: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2041: astore 5
    //   2043: goto +5830 -> 7873
    //   2046: aload 18
    //   2048: astore 17
    //   2050: aload_0
    //   2051: aload_2
    //   2052: invokestatic 611	afgc:a	(Landroid/content/Context;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   2055: astore 5
    //   2057: iconst_1
    //   2058: istore_3
    //   2059: goto -180 -> 1879
    //   2062: iload 13
    //   2064: ifeq -89 -> 1975
    //   2067: aload_1
    //   2068: ldc_w 657
    //   2071: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2074: pop
    //   2075: goto -100 -> 1975
    //   2078: astore_1
    //   2079: aload_0
    //   2080: astore_2
    //   2081: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2084: ifeq -85 -> 1999
    //   2087: ldc_w 659
    //   2090: iconst_2
    //   2091: ldc 191
    //   2093: aload_1
    //   2094: invokestatic 663	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2097: aload_0
    //   2098: astore_2
    //   2099: goto -100 -> 1999
    //   2102: iload 9
    //   2104: sipush -1000
    //   2107: if_icmpne +153 -> 2260
    //   2110: aload 5
    //   2112: astore 17
    //   2114: aload_2
    //   2115: invokestatic 666	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;)Laofk;
    //   2118: astore_0
    //   2119: aload_0
    //   2120: ifnull -2116 -> 4
    //   2123: aload 5
    //   2125: astore 17
    //   2127: new 230	java/lang/StringBuilder
    //   2130: dup
    //   2131: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2134: astore_1
    //   2135: aload 5
    //   2137: astore 17
    //   2139: aload 19
    //   2141: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2144: ifne +20 -> 2164
    //   2147: aload 5
    //   2149: astore 17
    //   2151: aload_1
    //   2152: aload 19
    //   2154: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: ldc_w 647
    //   2160: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: pop
    //   2164: aload 5
    //   2166: astore 17
    //   2168: aload_2
    //   2169: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2172: ifne +20 -> 2192
    //   2175: iload 12
    //   2177: ifeq +63 -> 2240
    //   2180: aload 5
    //   2182: astore 17
    //   2184: aload_1
    //   2185: ldc_w 649
    //   2188: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: pop
    //   2192: aload 5
    //   2194: astore 17
    //   2196: aload_0
    //   2197: checkcast 651	aofk
    //   2200: aload_1
    //   2201: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2204: iconst_1
    //   2205: iconst_0
    //   2206: newarray int
    //   2208: invokevirtual 654	aofk:a	(Ljava/lang/String;Z[I)Laofk;
    //   2211: astore_0
    //   2212: aload 5
    //   2214: astore 17
    //   2216: aload 4
    //   2218: iconst_1
    //   2219: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   2222: aload 5
    //   2224: astore 17
    //   2226: aload 19
    //   2228: aload_0
    //   2229: aconst_null
    //   2230: iload 12
    //   2232: iload 13
    //   2234: aload 4
    //   2236: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2239: return
    //   2240: iload 13
    //   2242: ifeq -50 -> 2192
    //   2245: aload 5
    //   2247: astore 17
    //   2249: aload_1
    //   2250: ldc_w 657
    //   2253: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: pop
    //   2257: goto -65 -> 2192
    //   2260: aload 5
    //   2262: astore 16
    //   2264: iload 9
    //   2266: sipush -2000
    //   2269: if_icmpne -273 -> 1996
    //   2272: iconst_0
    //   2273: istore 11
    //   2275: iconst_0
    //   2276: istore 7
    //   2278: aconst_null
    //   2279: astore 18
    //   2281: aload 18
    //   2283: astore 16
    //   2285: aload_2
    //   2286: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2289: astore 17
    //   2291: aload 18
    //   2293: astore 16
    //   2295: aload_2
    //   2296: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2299: aload_2
    //   2300: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2303: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   2306: ifeq +5516 -> 7822
    //   2309: aload 18
    //   2311: astore 16
    //   2313: aload_2
    //   2314: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2317: astore 17
    //   2319: aload 18
    //   2321: astore 16
    //   2323: aload_1
    //   2324: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   2327: aload 17
    //   2329: aload_2
    //   2330: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   2333: aload_2
    //   2334: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2337: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2340: checkcast 449	com/tencent/mobileqq/data/MessageForPic
    //   2343: astore 20
    //   2345: aload 18
    //   2347: astore 16
    //   2349: aload_1
    //   2350: invokevirtual 452	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   2353: aload 17
    //   2355: aload_2
    //   2356: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   2359: invokevirtual 457	aooi:a	(Ljava/lang/String;J)Laqoi;
    //   2362: astore_1
    //   2363: aload_1
    //   2364: astore 16
    //   2366: aload_2
    //   2367: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2370: ifeq +245 -> 2615
    //   2373: aload_1
    //   2374: astore 16
    //   2376: aload 20
    //   2378: getfield 460	com/tencent/mobileqq/data/MessageForPic:size	J
    //   2381: lstore 14
    //   2383: lload 14
    //   2385: lconst_0
    //   2386: lcmp
    //   2387: ifgt +208 -> 2595
    //   2390: aload_1
    //   2391: ifnonnull +5425 -> 7816
    //   2394: aload 20
    //   2396: ifnull +5420 -> 7816
    //   2399: iconst_1
    //   2400: istore 6
    //   2402: iload 6
    //   2404: istore 10
    //   2406: aload 5
    //   2408: astore 17
    //   2410: aload_1
    //   2411: instanceof 462
    //   2414: ifeq +269 -> 2683
    //   2417: aload 5
    //   2419: astore 17
    //   2421: aload_1
    //   2422: checkcast 462	aojn
    //   2425: astore_1
    //   2426: aload 5
    //   2428: astore 17
    //   2430: aload_1
    //   2431: invokevirtual 466	aojn:hh	()J
    //   2434: ldc2_w 467
    //   2437: lcmp
    //   2438: ifeq +6 -> 2444
    //   2441: iconst_1
    //   2442: istore 7
    //   2444: iload 7
    //   2446: istore 6
    //   2448: aload 5
    //   2450: astore 17
    //   2452: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2455: ifeq +76 -> 2531
    //   2458: aload 5
    //   2460: astore 17
    //   2462: aload_1
    //   2463: getfield 476	aojn:h	Laool;
    //   2466: ifnull +5425 -> 7891
    //   2469: aload 5
    //   2471: astore 17
    //   2473: aload_1
    //   2474: getfield 476	aojn:h	Laool;
    //   2477: getfield 481	aool:mUniseq	J
    //   2480: lstore 14
    //   2482: aload 5
    //   2484: astore 17
    //   2486: ldc_w 483
    //   2489: iconst_2
    //   2490: new 230	java/lang/StringBuilder
    //   2493: dup
    //   2494: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2497: ldc_w 485
    //   2500: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: lload 14
    //   2505: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2508: ldc_w 490
    //   2511: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2514: aload_1
    //   2515: invokevirtual 493	aojn:getKey	()Ljava/lang/String;
    //   2518: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2524: invokestatic 496	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2527: iload 7
    //   2529: istore 6
    //   2531: aload 5
    //   2533: astore 17
    //   2535: aload_0
    //   2536: ldc_w 497
    //   2539: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   2542: astore_1
    //   2543: aload 5
    //   2545: astore 17
    //   2547: aload_2
    //   2548: invokestatic 502	acfx:W	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2551: ifne +14 -> 2565
    //   2554: aload 5
    //   2556: astore 17
    //   2558: aload_2
    //   2559: invokestatic 505	acei:W	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   2562: ifeq +15 -> 2577
    //   2565: aload 5
    //   2567: astore 17
    //   2569: aload_0
    //   2570: ldc_w 506
    //   2573: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   2576: astore_1
    //   2577: aload 5
    //   2579: astore 17
    //   2581: aload 19
    //   2583: aload_1
    //   2584: aconst_null
    //   2585: iload 10
    //   2587: iload 6
    //   2589: aload 4
    //   2591: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2594: return
    //   2595: aload_1
    //   2596: astore 16
    //   2598: aload 20
    //   2600: getfield 513	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   2603: ldc_w 514
    //   2606: if_icmpne +5279 -> 7885
    //   2609: iconst_1
    //   2610: istore 6
    //   2612: goto -210 -> 2402
    //   2615: aload_1
    //   2616: ifnull +5200 -> 7816
    //   2619: aload_1
    //   2620: astore 16
    //   2622: aload_1
    //   2623: instanceof 462
    //   2626: ifeq +5190 -> 7816
    //   2629: aload_1
    //   2630: astore 16
    //   2632: aload_1
    //   2633: checkcast 462	aojn
    //   2636: invokevirtual 466	aojn:hh	()J
    //   2639: lstore 14
    //   2641: lload 14
    //   2643: l2i
    //   2644: istore_3
    //   2645: iload_3
    //   2646: sipush 1005
    //   2649: if_icmpeq +10 -> 2659
    //   2652: iload_3
    //   2653: sipush 1004
    //   2656: if_icmpne +5160 -> 7816
    //   2659: iconst_1
    //   2660: istore 6
    //   2662: goto -260 -> 2402
    //   2665: astore_1
    //   2666: aload 5
    //   2668: astore 17
    //   2670: aload_1
    //   2671: invokevirtual 517	java/lang/Exception:printStackTrace	()V
    //   2674: aload 16
    //   2676: astore_1
    //   2677: iconst_0
    //   2678: istore 10
    //   2680: goto -274 -> 2406
    //   2683: iload 11
    //   2685: istore 6
    //   2687: aload_1
    //   2688: ifnull -157 -> 2531
    //   2691: iconst_1
    //   2692: istore 7
    //   2694: iload 7
    //   2696: istore 6
    //   2698: aload 5
    //   2700: astore 17
    //   2702: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2705: ifeq -174 -> 2531
    //   2708: aload 5
    //   2710: astore 17
    //   2712: ldc_w 483
    //   2715: iconst_2
    //   2716: new 230	java/lang/StringBuilder
    //   2719: dup
    //   2720: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2723: ldc_w 519
    //   2726: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2729: aload_1
    //   2730: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2733: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2736: invokestatic 496	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2739: iload 7
    //   2741: istore 6
    //   2743: goto -212 -> 2531
    //   2746: aload_2
    //   2747: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   2750: invokestatic 672	aqfw:mp	(I)Z
    //   2753: ifeq +267 -> 3020
    //   2756: new 674	com/tencent/mobileqq/data/MessageForApollo
    //   2759: dup
    //   2760: invokespecial 675	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   2763: astore 5
    //   2765: aload 5
    //   2767: aload_2
    //   2768: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   2771: putfield 676	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   2774: aload 5
    //   2776: invokevirtual 677	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   2779: aload_1
    //   2780: aload_2
    //   2781: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2784: istore 6
    //   2786: aload_1
    //   2787: aload_2
    //   2788: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   2791: istore 7
    //   2793: aload 5
    //   2795: getfield 679	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2798: invokestatic 684	com/tencent/mobileqq/apollo/utils/ApolloGameUtil:ib	(I)Z
    //   2801: ifeq +209 -> 3010
    //   2804: ldc_w 685
    //   2807: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   2810: astore_0
    //   2811: aload 5
    //   2813: getfield 679	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   2816: iconst_4
    //   2817: if_icmpne +155 -> 2972
    //   2820: aload 5
    //   2822: getfield 688	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2825: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2828: ifeq +43 -> 2871
    //   2831: new 230	java/lang/StringBuilder
    //   2834: dup
    //   2835: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2838: aload_0
    //   2839: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: ldc_w 689
    //   2845: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   2848: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2854: astore_1
    //   2855: aload_1
    //   2856: astore_0
    //   2857: aload 19
    //   2859: aload_0
    //   2860: aconst_null
    //   2861: iload 6
    //   2863: iload 7
    //   2865: aload 4
    //   2867: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2870: return
    //   2871: new 622	org/json/JSONObject
    //   2874: dup
    //   2875: aload 5
    //   2877: getfield 688	com/tencent/mobileqq/data/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   2880: invokespecial 625	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2883: ldc_w 691
    //   2886: invokevirtual 694	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2889: astore_1
    //   2890: aload_1
    //   2891: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2894: ifeq +32 -> 2926
    //   2897: new 230	java/lang/StringBuilder
    //   2900: dup
    //   2901: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2904: aload_0
    //   2905: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: ldc_w 695
    //   2911: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   2914: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2920: astore_1
    //   2921: aload_1
    //   2922: astore_0
    //   2923: goto -66 -> 2857
    //   2926: new 230	java/lang/StringBuilder
    //   2929: dup
    //   2930: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2933: aload_0
    //   2934: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2937: ldc_w 325
    //   2940: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2943: aload_1
    //   2944: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2947: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2950: astore_1
    //   2951: aload_1
    //   2952: astore_0
    //   2953: goto -96 -> 2857
    //   2956: astore_1
    //   2957: ldc_w 659
    //   2960: iconst_1
    //   2961: aload_1
    //   2962: iconst_0
    //   2963: anewarray 4	java/lang/Object
    //   2966: invokestatic 698	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   2969: goto -112 -> 2857
    //   2972: aload_1
    //   2973: aload 5
    //   2975: invokestatic 703	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   2978: astore_1
    //   2979: new 230	java/lang/StringBuilder
    //   2982: dup
    //   2983: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   2986: aload_0
    //   2987: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2990: ldc_w 704
    //   2993: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   2996: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2999: aload_1
    //   3000: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3003: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3006: astore_0
    //   3007: goto -150 -> 2857
    //   3010: aload_1
    //   3011: aload 5
    //   3013: invokestatic 706	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   3016: astore_0
    //   3017: goto -160 -> 2857
    //   3020: aload_2
    //   3021: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3024: sipush -1013
    //   3027: if_icmpeq +13 -> 3040
    //   3030: aload_2
    //   3031: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3034: sipush -1047
    //   3037: if_icmpne +20 -> 3057
    //   3040: aconst_null
    //   3041: aconst_null
    //   3042: aload_2
    //   3043: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3046: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3049: iconst_0
    //   3050: iconst_0
    //   3051: aload 4
    //   3053: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3056: return
    //   3057: aload_2
    //   3058: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3061: sipush -2042
    //   3064: if_icmpeq +13 -> 3077
    //   3067: aload_2
    //   3068: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3071: sipush -2043
    //   3074: if_icmpne +20 -> 3094
    //   3077: aconst_null
    //   3078: aload_2
    //   3079: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3082: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3085: aconst_null
    //   3086: iconst_0
    //   3087: iconst_0
    //   3088: aload 4
    //   3090: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3093: return
    //   3094: aload_2
    //   3095: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3098: sipush -2051
    //   3101: if_icmpne +155 -> 3256
    //   3104: aload_1
    //   3105: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3108: aload_2
    //   3109: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3112: aload_2
    //   3113: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3116: aload_2
    //   3117: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3120: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3123: astore_0
    //   3124: aload_0
    //   3125: ifnull +50 -> 3175
    //   3128: aload_0
    //   3129: instanceof 708
    //   3132: ifeq +43 -> 3175
    //   3135: aload_0
    //   3136: checkcast 708	com/tencent/mobileqq/data/MessageForQQStory
    //   3139: astore_0
    //   3140: aload_0
    //   3141: invokevirtual 709	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   3144: aload_1
    //   3145: aload_2
    //   3146: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3149: istore 6
    //   3151: aload_1
    //   3152: aload_2
    //   3153: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3156: istore 7
    //   3158: aload 19
    //   3160: aconst_null
    //   3161: aload_0
    //   3162: invokevirtual 710	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   3165: iload 6
    //   3167: iload 7
    //   3169: aload 4
    //   3171: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3174: return
    //   3175: new 230	java/lang/StringBuilder
    //   3178: dup
    //   3179: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3182: ldc 2
    //   3184: invokevirtual 715	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3187: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: ldc_w 717
    //   3193: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3196: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3199: astore_1
    //   3200: new 230	java/lang/StringBuilder
    //   3203: dup
    //   3204: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3207: ldc_w 719
    //   3210: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3213: aload_2
    //   3214: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3217: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3220: ldc_w 721
    //   3223: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: astore_2
    //   3227: aload_0
    //   3228: ifnull +22 -> 3250
    //   3231: aload_0
    //   3232: invokevirtual 724	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3235: astore_0
    //   3236: aload_1
    //   3237: iconst_1
    //   3238: aload_2
    //   3239: aload_0
    //   3240: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3243: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3246: invokestatic 726	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3249: return
    //   3250: ldc 191
    //   3252: astore_0
    //   3253: goto -17 -> 3236
    //   3256: aload_2
    //   3257: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3260: sipush -7002
    //   3263: if_icmpne +148 -> 3411
    //   3266: aload_1
    //   3267: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3270: aload_2
    //   3271: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3274: aload_2
    //   3275: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3278: aload_2
    //   3279: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3282: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3285: checkcast 728	com/tencent/mobileqq/data/MessageForTribeShortVideo
    //   3288: astore_0
    //   3289: aload_0
    //   3290: ifnull +38 -> 3328
    //   3293: aload_0
    //   3294: invokevirtual 729	com/tencent/mobileqq/data/MessageForTribeShortVideo:parse	()V
    //   3297: aload_1
    //   3298: aload_2
    //   3299: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3302: istore 6
    //   3304: aload_1
    //   3305: aload_2
    //   3306: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3309: istore 7
    //   3311: aload 19
    //   3313: aconst_null
    //   3314: aload_0
    //   3315: invokevirtual 730	com/tencent/mobileqq/data/MessageForTribeShortVideo:getSummaryMsg	()Ljava/lang/String;
    //   3318: iload 6
    //   3320: iload 7
    //   3322: aload 4
    //   3324: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3327: return
    //   3328: new 230	java/lang/StringBuilder
    //   3331: dup
    //   3332: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3335: ldc 2
    //   3337: invokevirtual 715	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3340: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3343: ldc_w 717
    //   3346: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3349: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3352: astore_1
    //   3353: new 230	java/lang/StringBuilder
    //   3356: dup
    //   3357: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3360: ldc_w 732
    //   3363: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: aload_2
    //   3367: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3370: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3373: ldc_w 721
    //   3376: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3379: astore 4
    //   3381: aload_2
    //   3382: ifnull +23 -> 3405
    //   3385: aload_2
    //   3386: invokevirtual 733	com/tencent/imcore/message/QQMessageFacade$Message:toString	()Ljava/lang/String;
    //   3389: astore_0
    //   3390: aload_1
    //   3391: iconst_1
    //   3392: aload 4
    //   3394: aload_0
    //   3395: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3401: invokestatic 726	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3404: return
    //   3405: ldc 191
    //   3407: astore_0
    //   3408: goto -18 -> 3390
    //   3411: aload_2
    //   3412: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3415: sipush -2054
    //   3418: if_icmpne +153 -> 3571
    //   3421: aload_1
    //   3422: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3425: aload_2
    //   3426: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3429: aload_2
    //   3430: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3433: aload_2
    //   3434: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3437: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3440: astore_0
    //   3441: aload_0
    //   3442: instanceof 735
    //   3445: ifeq +42 -> 3487
    //   3448: aload_0
    //   3449: checkcast 735	com/tencent/mobileqq/data/MessageForTroopSign
    //   3452: astore_0
    //   3453: ldc_w 736
    //   3456: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   3459: pop
    //   3460: aload_0
    //   3461: invokevirtual 737	com/tencent/mobileqq/data/MessageForTroopSign:parse	()V
    //   3464: aload 19
    //   3466: aconst_null
    //   3467: aload_0
    //   3468: invokevirtual 738	com/tencent/mobileqq/data/MessageForTroopSign:getSummaryMsg	()Ljava/lang/String;
    //   3471: aload_1
    //   3472: aload_2
    //   3473: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3476: aload_1
    //   3477: aload_2
    //   3478: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   3481: aload 4
    //   3483: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3486: return
    //   3487: new 230	java/lang/StringBuilder
    //   3490: dup
    //   3491: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3494: ldc 2
    //   3496: invokevirtual 715	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3499: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: ldc_w 740
    //   3505: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3508: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3511: astore_1
    //   3512: new 230	java/lang/StringBuilder
    //   3515: dup
    //   3516: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3519: ldc_w 742
    //   3522: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3525: aload_2
    //   3526: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3529: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3532: ldc_w 721
    //   3535: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: astore_2
    //   3539: aload_0
    //   3540: ifnull +25 -> 3565
    //   3543: aload_0
    //   3544: getfield 743	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3547: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3550: astore_0
    //   3551: aload_1
    //   3552: iconst_1
    //   3553: aload_2
    //   3554: aload_0
    //   3555: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3558: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3561: invokestatic 726	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3564: return
    //   3565: ldc 191
    //   3567: astore_0
    //   3568: goto -17 -> 3551
    //   3571: aload_2
    //   3572: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3575: sipush -2035
    //   3578: if_icmpne +20 -> 3598
    //   3581: aconst_null
    //   3582: aload_2
    //   3583: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3586: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3589: aconst_null
    //   3590: iconst_0
    //   3591: iconst_0
    //   3592: aload 4
    //   3594: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3597: return
    //   3598: aload_2
    //   3599: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3602: sipush -2038
    //   3605: if_icmpne +205 -> 3810
    //   3608: aload_2
    //   3609: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3612: astore_0
    //   3613: getstatic 748	acbn:blg	Ljava/lang/String;
    //   3616: aload_0
    //   3617: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3620: ifeq +4193 -> 7813
    //   3623: aload_2
    //   3624: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3627: astore_0
    //   3628: aload_0
    //   3629: astore 5
    //   3631: getstatic 751	acbn:bkE	Ljava/lang/String;
    //   3634: aload_0
    //   3635: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3638: ifeq +59 -> 3697
    //   3641: getstatic 748	acbn:blg	Ljava/lang/String;
    //   3644: aload_2
    //   3645: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3648: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3651: ifeq +103 -> 3754
    //   3654: aload_1
    //   3655: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3658: getstatic 748	acbn:blg	Ljava/lang/String;
    //   3661: aload_2
    //   3662: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3665: aload_2
    //   3666: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3669: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3672: checkcast 753	com/tencent/mobileqq/data/MessageForTroopGift
    //   3675: astore 16
    //   3677: aload_0
    //   3678: astore 5
    //   3680: aload 16
    //   3682: ifnull +15 -> 3697
    //   3685: aload 16
    //   3687: invokevirtual 754	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3690: aload 16
    //   3692: getfield 755	com/tencent/mobileqq/data/MessageForTroopGift:senderuin	Ljava/lang/String;
    //   3695: astore 5
    //   3697: aload_1
    //   3698: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3701: aload 5
    //   3703: aload_2
    //   3704: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3707: aload_2
    //   3708: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3711: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3714: astore_0
    //   3715: aload_0
    //   3716: instanceof 753
    //   3719: ifeq +50 -> 3769
    //   3722: aload_0
    //   3723: checkcast 753	com/tencent/mobileqq/data/MessageForTroopGift
    //   3726: astore_0
    //   3727: aload_0
    //   3728: invokevirtual 754	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   3731: aload_0
    //   3732: getfield 756	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3735: ifnull +28 -> 3763
    //   3738: aload_0
    //   3739: getfield 756	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   3742: astore_0
    //   3743: aconst_null
    //   3744: aload_0
    //   3745: aconst_null
    //   3746: iconst_0
    //   3747: iconst_0
    //   3748: aload 4
    //   3750: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3753: return
    //   3754: aload_2
    //   3755: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3758: astore 5
    //   3760: goto -63 -> 3697
    //   3763: ldc 191
    //   3765: astore_0
    //   3766: goto -23 -> 3743
    //   3769: aload_0
    //   3770: ifnull -3766 -> 4
    //   3773: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3776: ifeq -3772 -> 4
    //   3779: ldc_w 659
    //   3782: iconst_2
    //   3783: new 230	java/lang/StringBuilder
    //   3786: dup
    //   3787: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   3790: ldc_w 758
    //   3793: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3796: aload_0
    //   3797: invokevirtual 724	com/tencent/mobileqq/data/MessageRecord:toString	()Ljava/lang/String;
    //   3800: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3806: invokestatic 726	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3809: return
    //   3810: aload_2
    //   3811: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3814: sipush -2036
    //   3817: if_icmpne +48 -> 3865
    //   3820: aload_1
    //   3821: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3824: aload_2
    //   3825: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3828: aload_2
    //   3829: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3832: aload_2
    //   3833: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3836: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3839: checkcast 760	com/tencent/mobileqq/data/MessageForTroopFee
    //   3842: astore_0
    //   3843: aload_0
    //   3844: ifnull -3840 -> 4
    //   3847: aload_0
    //   3848: invokevirtual 761	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   3851: aconst_null
    //   3852: aload_0
    //   3853: getfield 762	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   3856: aconst_null
    //   3857: iconst_0
    //   3858: iconst_0
    //   3859: aload 4
    //   3861: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3864: return
    //   3865: aload_2
    //   3866: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3869: sipush -2069
    //   3872: if_icmpne +48 -> 3920
    //   3875: aload_1
    //   3876: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3879: aload_2
    //   3880: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3883: aload_2
    //   3884: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3887: aload_2
    //   3888: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3891: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3894: checkcast 764	com/tencent/mobileqq/data/MessageForStarLeague
    //   3897: astore_0
    //   3898: aload_0
    //   3899: ifnull -3895 -> 4
    //   3902: aload_0
    //   3903: invokevirtual 765	com/tencent/mobileqq/data/MessageForStarLeague:parse	()V
    //   3906: aconst_null
    //   3907: aload_0
    //   3908: getfield 766	com/tencent/mobileqq/data/MessageForStarLeague:msg	Ljava/lang/String;
    //   3911: aconst_null
    //   3912: iconst_0
    //   3913: iconst_0
    //   3914: aload 4
    //   3916: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3919: return
    //   3920: aload_2
    //   3921: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3924: sipush -2048
    //   3927: if_icmpne +49 -> 3976
    //   3930: aload_1
    //   3931: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3934: aload_2
    //   3935: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3938: aload_2
    //   3939: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3942: aload_2
    //   3943: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   3946: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3949: checkcast 768	com/tencent/mobileqq/data/MessageForTroopReward
    //   3952: astore_0
    //   3953: aload_0
    //   3954: ifnull -3950 -> 4
    //   3957: aload_0
    //   3958: invokevirtual 769	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   3961: aload 19
    //   3963: aload_0
    //   3964: getfield 770	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   3967: aconst_null
    //   3968: iconst_0
    //   3969: iconst_0
    //   3970: aload 4
    //   3972: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3975: return
    //   3976: aload_2
    //   3977: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   3980: iconst_1
    //   3981: if_icmpne +85 -> 4066
    //   3984: aload_2
    //   3985: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   3988: sipush -3006
    //   3991: if_icmpne +75 -> 4066
    //   3994: aload_1
    //   3995: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3998: aload_2
    //   3999: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4002: aload_2
    //   4003: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4006: aload_2
    //   4007: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4010: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4013: checkcast 772	com/tencent/mobileqq/data/MessageForPubAccount
    //   4016: astore_0
    //   4017: aload_0
    //   4018: ifnull -4014 -> 4
    //   4021: aload_0
    //   4022: invokevirtual 773	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   4025: aload_1
    //   4026: aload_0
    //   4027: iconst_0
    //   4028: invokestatic 777	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   4031: astore_2
    //   4032: aload_0
    //   4033: invokevirtual 780	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   4036: ifne +16 -> 4052
    //   4039: aconst_null
    //   4040: astore_0
    //   4041: aload_0
    //   4042: aload_2
    //   4043: aconst_null
    //   4044: iconst_0
    //   4045: iconst_0
    //   4046: aload 4
    //   4048: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4051: return
    //   4052: aload_1
    //   4053: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4056: ldc_w 781
    //   4059: invokevirtual 228	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   4062: astore_0
    //   4063: goto -22 -> 4041
    //   4066: aload_2
    //   4067: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4070: sipush -1034
    //   4073: if_icmpne +106 -> 4179
    //   4076: new 783	com/tencent/mobileqq/data/MessageForRichState
    //   4079: dup
    //   4080: invokespecial 784	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   4083: astore_0
    //   4084: aload_0
    //   4085: aload_2
    //   4086: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4089: putfield 785	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   4092: aload_0
    //   4093: invokevirtual 786	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   4096: new 230	java/lang/StringBuilder
    //   4099: dup
    //   4100: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   4103: astore_1
    //   4104: aload_0
    //   4105: getfield 789	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4108: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4111: ifne +38 -> 4149
    //   4114: aload_1
    //   4115: aload_0
    //   4116: getfield 789	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   4119: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4122: pop
    //   4123: aload_0
    //   4124: getfield 792	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4127: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4130: ifne +12 -> 4142
    //   4133: aload_1
    //   4134: aload_0
    //   4135: getfield 792	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   4138: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: pop
    //   4142: aload_1
    //   4143: bipush 32
    //   4145: invokevirtual 795	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   4148: pop
    //   4149: aload_1
    //   4150: aload_0
    //   4151: invokevirtual 798	com/tencent/mobileqq/data/MessageForRichState:getPlainMsg	()Ljava/lang/String;
    //   4154: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4157: pop
    //   4158: aload_1
    //   4159: invokevirtual 799	java/lang/StringBuilder:length	()I
    //   4162: ifle -4158 -> 4
    //   4165: aconst_null
    //   4166: aload_1
    //   4167: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4170: aconst_null
    //   4171: iconst_0
    //   4172: iconst_0
    //   4173: aload 4
    //   4175: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4178: return
    //   4179: aload_2
    //   4180: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4183: sipush -2074
    //   4186: if_icmpne +47 -> 4233
    //   4189: new 801	com/tencent/mobileqq/data/MessageForAIOStoryVideo
    //   4192: dup
    //   4193: invokespecial 802	com/tencent/mobileqq/data/MessageForAIOStoryVideo:<init>	()V
    //   4196: astore_0
    //   4197: aload_0
    //   4198: aload_2
    //   4199: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4202: putfield 803	com/tencent/mobileqq/data/MessageForAIOStoryVideo:msg	Ljava/lang/String;
    //   4205: aload_0
    //   4206: invokevirtual 804	com/tencent/mobileqq/data/MessageForAIOStoryVideo:parse	()V
    //   4209: aload_0
    //   4210: getfield 807	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4213: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4216: ifne -4212 -> 4
    //   4219: aconst_null
    //   4220: aload_0
    //   4221: getfield 807	com/tencent/mobileqq/data/MessageForAIOStoryVideo:text	Ljava/lang/String;
    //   4224: aconst_null
    //   4225: iconst_0
    //   4226: iconst_0
    //   4227: aload 4
    //   4229: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4232: return
    //   4233: aload_2
    //   4234: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4237: sipush -1019
    //   4240: if_icmpne +48 -> 4288
    //   4243: aconst_null
    //   4244: aconst_null
    //   4245: new 230	java/lang/StringBuilder
    //   4248: dup
    //   4249: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   4252: ldc_w 808
    //   4255: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   4258: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4261: aload_2
    //   4262: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4265: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4268: ldc_w 809
    //   4271: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   4274: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4277: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4280: iconst_0
    //   4281: iconst_0
    //   4282: aload 4
    //   4284: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4287: return
    //   4288: aload_2
    //   4289: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4292: sipush -1018
    //   4295: if_icmpne +48 -> 4343
    //   4298: aconst_null
    //   4299: aconst_null
    //   4300: new 230	java/lang/StringBuilder
    //   4303: dup
    //   4304: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   4307: ldc_w 810
    //   4310: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   4313: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4316: aload_2
    //   4317: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   4320: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4323: ldc_w 811
    //   4326: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   4329: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4332: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4335: iconst_0
    //   4336: iconst_0
    //   4337: aload 4
    //   4339: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4342: return
    //   4343: aload_2
    //   4344: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4347: sipush -2019
    //   4350: if_icmpne +16 -> 4366
    //   4353: aload 4
    //   4355: aload_0
    //   4356: ldc_w 812
    //   4359: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4362: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4365: return
    //   4366: aload_2
    //   4367: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4370: sipush -7006
    //   4373: if_icmpne +16 -> 4389
    //   4376: aload 4
    //   4378: aload_0
    //   4379: ldc_w 813
    //   4382: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4385: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4388: return
    //   4389: aload_2
    //   4390: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4393: sipush -1026
    //   4396: if_icmpne +16 -> 4412
    //   4399: aload 4
    //   4401: aload_0
    //   4402: ldc_w 814
    //   4405: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4408: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4411: return
    //   4412: aload_2
    //   4413: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4416: sipush -1027
    //   4419: if_icmpne +16 -> 4435
    //   4422: aload 4
    //   4424: aload_0
    //   4425: ldc_w 815
    //   4428: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4431: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4434: return
    //   4435: aload_2
    //   4436: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4439: sipush -2005
    //   4442: if_icmpne +56 -> 4498
    //   4445: aload_1
    //   4446: aload_2
    //   4447: invokestatic 818	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   4450: astore 5
    //   4452: aload_1
    //   4453: aload_2
    //   4454: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4457: istore 6
    //   4459: aload_1
    //   4460: aload_2
    //   4461: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   4464: istore 7
    //   4466: aload 19
    //   4468: aload_0
    //   4469: ldc_w 819
    //   4472: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4475: aconst_null
    //   4476: iload 6
    //   4478: iload 7
    //   4480: aload 4
    //   4482: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   4485: aload 5
    //   4487: ifnull -4483 -> 4
    //   4490: aload 4
    //   4492: aload 5
    //   4494: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   4497: return
    //   4498: aload_2
    //   4499: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4502: sipush -2022
    //   4505: if_icmpeq +13 -> 4518
    //   4508: aload_2
    //   4509: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   4512: sipush -2071
    //   4515: if_icmpne +700 -> 5215
    //   4518: iconst_0
    //   4519: istore 7
    //   4521: iconst_0
    //   4522: istore 10
    //   4524: aload_1
    //   4525: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4528: aload_2
    //   4529: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4532: aload_2
    //   4533: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4536: aload_2
    //   4537: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4540: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4543: astore 5
    //   4545: aload 5
    //   4547: instanceof 821
    //   4550: ifeq -4546 -> 4
    //   4553: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4556: ifeq +33 -> 4589
    //   4559: ldc_w 823
    //   4562: iconst_2
    //   4563: new 230	java/lang/StringBuilder
    //   4566: dup
    //   4567: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   4570: ldc_w 825
    //   4573: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4576: aload_2
    //   4577: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4580: invokevirtual 488	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4583: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4586: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4589: aload 5
    //   4591: checkcast 821	com/tencent/mobileqq/data/MessageForShortVideo
    //   4594: astore 16
    //   4596: aload 16
    //   4598: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4601: sipush 1005
    //   4604: if_icmpeq +60 -> 4664
    //   4607: aload_2
    //   4608: getfield 832	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   4611: ldc_w 514
    //   4614: if_icmpeq +50 -> 4664
    //   4617: aload 16
    //   4619: getfield 835	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4622: ifne +14 -> 4636
    //   4625: aload 16
    //   4627: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4630: sipush 1004
    //   4633: if_icmpeq +31 -> 4664
    //   4636: iload 7
    //   4638: istore 6
    //   4640: aload 16
    //   4642: getfield 835	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   4645: iconst_1
    //   4646: if_icmpne +37 -> 4683
    //   4649: iload 7
    //   4651: istore 6
    //   4653: aload 16
    //   4655: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4658: sipush 1004
    //   4661: if_icmpne +22 -> 4683
    //   4664: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4667: ifeq +13 -> 4680
    //   4670: ldc_w 823
    //   4673: iconst_2
    //   4674: ldc_w 837
    //   4677: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4680: iconst_1
    //   4681: istore 6
    //   4683: aload_2
    //   4684: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4687: astore 5
    //   4689: aload_2
    //   4690: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   4693: aload_2
    //   4694: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   4697: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   4700: ifeq +9 -> 4709
    //   4703: aload_2
    //   4704: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   4707: astore 5
    //   4709: aload_1
    //   4710: invokevirtual 452	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   4713: aload 5
    //   4715: aload_2
    //   4716: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   4719: invokevirtual 457	aooi:a	(Ljava/lang/String;J)Laqoi;
    //   4722: astore_1
    //   4723: aload 16
    //   4725: getfield 840	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4728: ifnull +337 -> 5065
    //   4731: ldc 191
    //   4733: aload 16
    //   4735: getfield 840	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4738: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4741: ifne +324 -> 5065
    //   4744: aload_2
    //   4745: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4748: ifeq +317 -> 5065
    //   4751: aload_1
    //   4752: ifnonnull +313 -> 5065
    //   4755: aload 16
    //   4757: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4760: sipush 1003
    //   4763: if_icmpeq +302 -> 5065
    //   4766: aload 16
    //   4768: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4771: sipush 1004
    //   4774: if_icmpeq +291 -> 5065
    //   4777: aload 16
    //   4779: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4782: sipush 2003
    //   4785: if_icmpeq +280 -> 5065
    //   4788: aload 16
    //   4790: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4793: sipush 2009
    //   4796: if_icmpeq +269 -> 5065
    //   4799: aload 16
    //   4801: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4804: sipush 2002
    //   4807: if_icmpeq +258 -> 5065
    //   4810: aload 16
    //   4812: getfield 843	com/tencent/mobileqq/data/MessageForShortVideo:isAllowAutoDown	Z
    //   4815: iconst_1
    //   4816: if_icmpne +249 -> 5065
    //   4819: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4822: ifeq +13 -> 4835
    //   4825: ldc_w 823
    //   4828: iconst_2
    //   4829: ldc_w 845
    //   4832: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4835: iconst_1
    //   4836: istore 7
    //   4838: iload 7
    //   4840: istore 6
    //   4842: iload 10
    //   4844: istore 7
    //   4846: aload_2
    //   4847: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   4850: ifeq +81 -> 4931
    //   4853: aload 16
    //   4855: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4858: sipush 1001
    //   4861: if_icmpeq +51 -> 4912
    //   4864: aload 16
    //   4866: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4869: sipush 1002
    //   4872: if_icmpeq +40 -> 4912
    //   4875: aload 16
    //   4877: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4880: sipush 998
    //   4883: if_icmpeq +29 -> 4912
    //   4886: aload 16
    //   4888: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4891: sipush 999
    //   4894: if_icmpeq +18 -> 4912
    //   4897: iload 10
    //   4899: istore 7
    //   4901: aload 16
    //   4903: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4906: sipush 1000
    //   4909: if_icmpne +22 -> 4931
    //   4912: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4915: ifeq +13 -> 4928
    //   4918: ldc_w 823
    //   4921: iconst_2
    //   4922: ldc_w 847
    //   4925: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4928: iconst_1
    //   4929: istore 7
    //   4931: aload 16
    //   4933: instanceof 849
    //   4936: ifeq +235 -> 5171
    //   4939: aload_0
    //   4940: ldc_w 850
    //   4943: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   4946: astore_0
    //   4947: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4950: ifeq +101 -> 5051
    //   4953: ldc_w 823
    //   4956: iconst_2
    //   4957: new 230	java/lang/StringBuilder
    //   4960: dup
    //   4961: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   4964: ldc_w 852
    //   4967: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4970: aload 16
    //   4972: getfield 840	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   4975: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4978: ldc_w 854
    //   4981: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4984: aload 16
    //   4986: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   4989: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4992: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4995: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4998: aload_1
    //   4999: ifnonnull +203 -> 5202
    //   5002: ldc_w 823
    //   5005: iconst_2
    //   5006: ldc_w 859
    //   5009: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5012: ldc_w 823
    //   5015: iconst_2
    //   5016: new 230	java/lang/StringBuilder
    //   5019: dup
    //   5020: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   5023: ldc_w 861
    //   5026: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5029: iload 6
    //   5031: invokevirtual 864	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5034: ldc_w 866
    //   5037: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5040: iload 7
    //   5042: invokevirtual 864	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5045: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5048: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5051: aload 19
    //   5053: aload_0
    //   5054: aconst_null
    //   5055: iload 6
    //   5057: iload 7
    //   5059: aload 4
    //   5061: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5064: return
    //   5065: iload 6
    //   5067: istore 7
    //   5069: aload_2
    //   5070: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   5073: ifeq -235 -> 4838
    //   5076: iload 6
    //   5078: istore 7
    //   5080: aload 16
    //   5082: instanceof 849
    //   5085: ifeq -247 -> 4838
    //   5088: iload 6
    //   5090: istore 7
    //   5092: aload 16
    //   5094: getfield 840	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   5097: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5100: ifeq -262 -> 4838
    //   5103: iload 6
    //   5105: istore 7
    //   5107: aload_1
    //   5108: ifnonnull -270 -> 4838
    //   5111: aload 16
    //   5113: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5116: sipush 1004
    //   5119: if_icmpeq +18 -> 5137
    //   5122: iload 6
    //   5124: istore 7
    //   5126: aload 16
    //   5128: getfield 831	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   5131: sipush 1001
    //   5134: if_icmpne -296 -> 4838
    //   5137: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5140: ifeq +13 -> 5153
    //   5143: ldc_w 823
    //   5146: iconst_2
    //   5147: ldc_w 868
    //   5150: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5153: iconst_1
    //   5154: istore 7
    //   5156: goto -318 -> 4838
    //   5159: astore 5
    //   5161: aconst_null
    //   5162: astore_1
    //   5163: aload 5
    //   5165: invokevirtual 517	java/lang/Exception:printStackTrace	()V
    //   5168: goto -326 -> 4842
    //   5171: aload 16
    //   5173: getfield 835	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   5176: iconst_2
    //   5177: if_icmpne +14 -> 5191
    //   5180: aload_0
    //   5181: ldc_w 869
    //   5184: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5187: astore_0
    //   5188: goto -241 -> 4947
    //   5191: aload_0
    //   5192: ldc_w 870
    //   5195: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5198: astore_0
    //   5199: goto -252 -> 4947
    //   5202: ldc_w 823
    //   5205: iconst_2
    //   5206: ldc_w 872
    //   5209: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5212: goto -200 -> 5012
    //   5215: aload_2
    //   5216: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5219: sipush -5002
    //   5222: if_icmpne +40 -> 5262
    //   5225: new 874	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   5228: dup
    //   5229: invokespecial 875	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   5232: astore_0
    //   5233: aload_0
    //   5234: aload_2
    //   5235: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5238: putfield 876	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   5241: aload_0
    //   5242: invokevirtual 877	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   5245: aload_0
    //   5246: getfield 878	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5249: ifnull -5245 -> 4
    //   5252: aload 4
    //   5254: aload_0
    //   5255: getfield 878	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   5258: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5261: return
    //   5262: aload_2
    //   5263: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5266: sipush -2029
    //   5269: if_icmpne +145 -> 5414
    //   5272: aload_1
    //   5273: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5276: aload_2
    //   5277: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5280: aload_2
    //   5281: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5284: aload_2
    //   5285: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5288: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5291: astore_0
    //   5292: invokestatic 473	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5295: ifeq +30 -> 5325
    //   5298: ldc_w 823
    //   5301: iconst_2
    //   5302: new 230	java/lang/StringBuilder
    //   5305: dup
    //   5306: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   5309: ldc_w 880
    //   5312: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: aload_0
    //   5316: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5319: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5322: invokestatic 828	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5325: aload_0
    //   5326: instanceof 882
    //   5329: ifeq -5325 -> 4
    //   5332: aload_0
    //   5333: checkcast 882	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   5336: astore_0
    //   5337: aload_0
    //   5338: aload_2
    //   5339: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5342: putfield 883	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   5345: aload_0
    //   5346: invokevirtual 884	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   5349: aload_0
    //   5350: aload_1
    //   5351: aload_1
    //   5352: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5355: aconst_null
    //   5356: invokevirtual 888	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   5359: aload_0
    //   5360: getfield 890	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5363: ifnull -5359 -> 4
    //   5366: aload_0
    //   5367: getfield 893	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   5370: iconst_1
    //   5371: if_icmpne +33 -> 5404
    //   5374: aload_0
    //   5375: new 230	java/lang/StringBuilder
    //   5378: dup
    //   5379: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   5382: ldc_w 894
    //   5385: invokestatic 617	acfp:m	(I)Ljava/lang/String;
    //   5388: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5391: aload_0
    //   5392: getfield 890	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5395: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5398: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5401: putfield 890	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5404: aload 4
    //   5406: aload_0
    //   5407: getfield 890	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   5410: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5413: return
    //   5414: aload_2
    //   5415: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5418: sipush -2025
    //   5421: if_icmpeq +13 -> 5434
    //   5424: aload_2
    //   5425: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5428: sipush -2072
    //   5431: if_icmpne +13 -> 5444
    //   5434: aload 4
    //   5436: aload_2
    //   5437: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5440: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5443: return
    //   5444: aload_2
    //   5445: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5448: sipush -2076
    //   5451: if_icmpne +58 -> 5509
    //   5454: new 896	com/tencent/mobileqq/data/MessageForLocationShare
    //   5457: dup
    //   5458: invokespecial 897	com/tencent/mobileqq/data/MessageForLocationShare:<init>	()V
    //   5461: astore_1
    //   5462: aload_1
    //   5463: aload_2
    //   5464: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5467: putfield 898	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   5470: aload_1
    //   5471: invokevirtual 899	com/tencent/mobileqq/data/MessageForLocationShare:parse	()V
    //   5474: aload_1
    //   5475: getfield 900	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   5478: astore_2
    //   5479: aload_2
    //   5480: astore_1
    //   5481: aload_2
    //   5482: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5485: ifeq +11 -> 5496
    //   5488: aload_0
    //   5489: ldc_w 901
    //   5492: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5495: astore_1
    //   5496: aload 19
    //   5498: ldc 191
    //   5500: aload_1
    //   5501: iconst_0
    //   5502: iconst_0
    //   5503: aload 4
    //   5505: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5508: return
    //   5509: aload_2
    //   5510: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5513: sipush -2052
    //   5516: if_icmpne +75 -> 5591
    //   5519: aload_2
    //   5520: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5523: astore_0
    //   5524: aload_2
    //   5525: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5528: aload_2
    //   5529: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5532: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   5535: ifeq +8 -> 5543
    //   5538: aload_2
    //   5539: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5542: astore_0
    //   5543: aload_1
    //   5544: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5547: aload_0
    //   5548: aload_2
    //   5549: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5552: aload_2
    //   5553: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5556: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5559: astore_0
    //   5560: aload_0
    //   5561: instanceof 903
    //   5564: ifeq -5560 -> 4
    //   5567: aload_0
    //   5568: checkcast 903	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   5571: astore_0
    //   5572: aload_0
    //   5573: invokevirtual 904	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   5576: aload 19
    //   5578: aload_0
    //   5579: invokevirtual 905	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   5582: aconst_null
    //   5583: iconst_0
    //   5584: iconst_0
    //   5585: aload 4
    //   5587: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5590: return
    //   5591: aload_2
    //   5592: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5595: sipush -2047
    //   5598: if_icmpne +51 -> 5649
    //   5601: new 907	com/tencent/mobileqq/data/MessageForVIPDonate
    //   5604: dup
    //   5605: invokespecial 908	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   5608: astore_0
    //   5609: aload_0
    //   5610: aload_2
    //   5611: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5614: putfield 909	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   5617: aload_0
    //   5618: invokevirtual 910	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   5621: aload_0
    //   5622: invokevirtual 911	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   5625: astore_0
    //   5626: aload_0
    //   5627: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5630: ifne +10 -> 5640
    //   5633: aload 4
    //   5635: aload_0
    //   5636: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5639: return
    //   5640: aload 4
    //   5642: ldc_w 913
    //   5645: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5648: return
    //   5649: aload_2
    //   5650: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5653: sipush -2040
    //   5656: if_icmpne +29 -> 5685
    //   5659: new 915	com/tencent/mobileqq/data/MessageForApproval
    //   5662: dup
    //   5663: invokespecial 916	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   5666: astore_0
    //   5667: aload_0
    //   5668: aload_2
    //   5669: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   5672: putfield 917	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   5675: aload 4
    //   5677: aload_0
    //   5678: invokevirtual 920	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   5681: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5684: return
    //   5685: aload_2
    //   5686: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5689: sipush -2041
    //   5692: if_icmpne +49 -> 5741
    //   5695: aload_0
    //   5696: ldc_w 921
    //   5699: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5702: astore_1
    //   5703: aload_0
    //   5704: ldc_w 922
    //   5707: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5710: astore_0
    //   5711: aload 4
    //   5713: new 230	java/lang/StringBuilder
    //   5716: dup
    //   5717: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   5720: aload_1
    //   5721: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5724: ldc_w 325
    //   5727: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5730: aload_0
    //   5731: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5734: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5737: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5740: return
    //   5741: aload_2
    //   5742: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5745: sipush -7001
    //   5748: if_icmpne +157 -> 5905
    //   5751: aload_2
    //   5752: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5755: astore 5
    //   5757: aload_2
    //   5758: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   5761: aload_2
    //   5762: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5765: invokestatic 447	top:x	(Ljava/lang/String;I)Z
    //   5768: ifeq +9 -> 5777
    //   5771: aload_2
    //   5772: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   5775: astore 5
    //   5777: aload_1
    //   5778: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   5781: aload 5
    //   5783: aload_2
    //   5784: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   5787: aload_2
    //   5788: getfield 106	com/tencent/imcore/message/QQMessageFacade$Message:uniseq	J
    //   5791: invokevirtual 361	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5794: checkcast 924	com/tencent/mobileqq/data/MessageForScribble
    //   5797: astore_1
    //   5798: aload_1
    //   5799: invokevirtual 925	com/tencent/mobileqq/data/MessageForScribble:isSendFromLocal	()Z
    //   5802: ifeq +56 -> 5858
    //   5805: aload_1
    //   5806: getfield 928	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5809: istore_3
    //   5810: iload_3
    //   5811: iconst_2
    //   5812: if_icmpne +29 -> 5841
    //   5815: iconst_1
    //   5816: istore 7
    //   5818: iconst_0
    //   5819: istore 6
    //   5821: aload 19
    //   5823: aload_0
    //   5824: ldc_w 929
    //   5827: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   5830: aconst_null
    //   5831: iload 7
    //   5833: iload 6
    //   5835: aload 4
    //   5837: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5840: return
    //   5841: aload_1
    //   5842: getfield 928	com/tencent/mobileqq/data/MessageForScribble:fileUploadStatus	I
    //   5845: iconst_3
    //   5846: if_icmpne +1958 -> 7804
    //   5849: iconst_1
    //   5850: istore 6
    //   5852: iconst_0
    //   5853: istore 7
    //   5855: goto -34 -> 5821
    //   5858: aload_1
    //   5859: getfield 932	com/tencent/mobileqq/data/MessageForScribble:fileDownloadStatus	I
    //   5862: iconst_2
    //   5863: if_icmpne +1941 -> 7804
    //   5866: aload_1
    //   5867: invokestatic 937	amjb:c	(Lcom/tencent/mobileqq/data/MessageForScribble;)I
    //   5870: istore_3
    //   5871: getstatic 940	amjb:dCo	I
    //   5874: istore 8
    //   5876: iload_3
    //   5877: iload 8
    //   5879: if_icmpeq +1925 -> 7804
    //   5882: iconst_1
    //   5883: istore 7
    //   5885: iconst_0
    //   5886: istore 6
    //   5888: goto -67 -> 5821
    //   5891: astore_1
    //   5892: aload_1
    //   5893: invokevirtual 517	java/lang/Exception:printStackTrace	()V
    //   5896: iconst_0
    //   5897: istore 6
    //   5899: iconst_0
    //   5900: istore 7
    //   5902: goto -81 -> 5821
    //   5905: aload_1
    //   5906: aload_2
    //   5907: invokestatic 944	ajoq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   5910: ifeq +18 -> 5928
    //   5913: aload 19
    //   5915: aload_2
    //   5916: invokevirtual 948	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5919: aconst_null
    //   5920: iconst_0
    //   5921: iconst_0
    //   5922: aload 4
    //   5924: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5927: return
    //   5928: aload_2
    //   5929: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   5932: ifnonnull +11 -> 5943
    //   5935: aload 4
    //   5937: ldc 191
    //   5939: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5942: return
    //   5943: aload_2
    //   5944: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5947: sipush -5003
    //   5950: if_icmpne +13 -> 5963
    //   5953: aload 4
    //   5955: aload_2
    //   5956: invokevirtual 948	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   5959: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   5962: return
    //   5963: aload_2
    //   5964: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5967: sipush -2033
    //   5970: if_icmpne +16 -> 5986
    //   5973: aconst_null
    //   5974: getstatic 953	com/tencent/mobileqq/data/ShareHotChatGrayTips:SHARE_GRAY_TIP_CONTENT	Ljava/lang/String;
    //   5977: aconst_null
    //   5978: iconst_0
    //   5979: iconst_0
    //   5980: aload 4
    //   5982: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   5985: return
    //   5986: aload_2
    //   5987: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   5990: sipush -5010
    //   5993: if_icmpne +33 -> 6026
    //   5996: new 955	com/tencent/tim/dingdong/MessageForDingdongSchedule
    //   5999: dup
    //   6000: invokespecial 956	com/tencent/tim/dingdong/MessageForDingdongSchedule:<init>	()V
    //   6003: astore_0
    //   6004: aload_0
    //   6005: aload_2
    //   6006: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6009: putfield 957	com/tencent/tim/dingdong/MessageForDingdongSchedule:msgData	[B
    //   6012: aload_0
    //   6013: invokevirtual 958	com/tencent/tim/dingdong/MessageForDingdongSchedule:parse	()V
    //   6016: aload 4
    //   6018: aload_0
    //   6019: getfield 959	com/tencent/tim/dingdong/MessageForDingdongSchedule:msg	Ljava/lang/String;
    //   6022: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6025: return
    //   6026: aload_2
    //   6027: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6030: sipush -8002
    //   6033: if_icmpne +53 -> 6086
    //   6036: new 961	com/tencent/tim/todo/MessageForToDo
    //   6039: dup
    //   6040: invokespecial 962	com/tencent/tim/todo/MessageForToDo:<init>	()V
    //   6043: astore_1
    //   6044: aload_1
    //   6045: aload_2
    //   6046: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6049: putfield 963	com/tencent/tim/todo/MessageForToDo:msgData	[B
    //   6052: aload_1
    //   6053: invokevirtual 964	com/tencent/tim/todo/MessageForToDo:parse	()V
    //   6056: aload 4
    //   6058: aload_0
    //   6059: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6062: ldc_w 965
    //   6065: invokevirtual 299	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   6068: iconst_1
    //   6069: anewarray 4	java/lang/Object
    //   6072: dup
    //   6073: iconst_0
    //   6074: aload_1
    //   6075: getfield 968	com/tencent/tim/todo/MessageForToDo:title	Ljava/lang/String;
    //   6078: aastore
    //   6079: invokestatic 972	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6082: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6085: return
    //   6086: aload_2
    //   6087: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6090: sipush -2049
    //   6093: if_icmpne +16 -> 6109
    //   6096: aload 4
    //   6098: aload_2
    //   6099: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6102: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6105: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6108: return
    //   6109: aload_2
    //   6110: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6113: sipush -1035
    //   6116: if_icmpne +287 -> 6403
    //   6119: iconst_0
    //   6120: istore 10
    //   6122: iconst_0
    //   6123: istore 11
    //   6125: iload 10
    //   6127: istore 6
    //   6129: iload 11
    //   6131: istore 7
    //   6133: aload_2
    //   6134: invokevirtual 377	com/tencent/imcore/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   6137: ifeq +31 -> 6168
    //   6140: aload_2
    //   6141: getfield 832	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6144: ldc_w 973
    //   6147: if_icmpne +171 -> 6318
    //   6150: aload_1
    //   6151: invokevirtual 976	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   6154: aload_2
    //   6155: invokevirtual 981	anaz:aR	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6158: ifne +150 -> 6308
    //   6161: iconst_1
    //   6162: istore 6
    //   6164: iload 11
    //   6166: istore 7
    //   6168: aload_2
    //   6169: invokevirtual 948	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6172: astore_0
    //   6173: aload_2
    //   6174: invokestatic 986	aptw:bg	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6177: ifeq +1624 -> 7801
    //   6180: aload_2
    //   6181: invokestatic 989	aptw:bi	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6184: ifne +7 -> 6191
    //   6187: aload_2
    //   6188: invokestatic 993	aptw:aI	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   6191: aload_2
    //   6192: invokestatic 996	aptw:x	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   6195: astore_1
    //   6196: aload_1
    //   6197: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6200: ifne +1601 -> 7801
    //   6203: aload_1
    //   6204: astore_0
    //   6205: aload_2
    //   6206: getfield 999	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   6209: ifnull +177 -> 6386
    //   6212: aload_0
    //   6213: ifnull +173 -> 6386
    //   6216: new 230	java/lang/StringBuilder
    //   6219: dup
    //   6220: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   6223: astore_1
    //   6224: aload 19
    //   6226: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6229: ifne +16 -> 6245
    //   6232: aload_1
    //   6233: aload 19
    //   6235: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6238: ldc_w 647
    //   6241: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6244: pop
    //   6245: aload_2
    //   6246: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6249: ifne +16 -> 6265
    //   6252: iload 6
    //   6254: ifeq +89 -> 6343
    //   6257: aload_1
    //   6258: ldc_w 649
    //   6261: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6264: pop
    //   6265: aload_0
    //   6266: instanceof 651
    //   6269: ifeq +90 -> 6359
    //   6272: aload_0
    //   6273: checkcast 651	aofk
    //   6276: aload_1
    //   6277: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6280: iconst_1
    //   6281: iconst_0
    //   6282: newarray int
    //   6284: invokevirtual 654	aofk:a	(Ljava/lang/String;Z[I)Laofk;
    //   6287: astore_0
    //   6288: aload 4
    //   6290: iconst_1
    //   6291: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6294: aload 19
    //   6296: aload_0
    //   6297: aconst_null
    //   6298: iload 6
    //   6300: iload 7
    //   6302: aload 4
    //   6304: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6307: return
    //   6308: iconst_1
    //   6309: istore 7
    //   6311: iload 10
    //   6313: istore 6
    //   6315: goto -147 -> 6168
    //   6318: iconst_0
    //   6319: istore 7
    //   6321: aload_2
    //   6322: getfield 832	com/tencent/imcore/message/QQMessageFacade$Message:extraflag	I
    //   6325: ldc_w 514
    //   6328: if_icmpne +9 -> 6337
    //   6331: iconst_1
    //   6332: istore 6
    //   6334: goto -166 -> 6168
    //   6337: iconst_0
    //   6338: istore 6
    //   6340: goto -6 -> 6334
    //   6343: iload 7
    //   6345: ifeq -80 -> 6265
    //   6348: aload_1
    //   6349: ldc_w 657
    //   6352: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6355: pop
    //   6356: goto -91 -> 6265
    //   6359: aload_1
    //   6360: aload_0
    //   6361: invokevirtual 1002	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   6364: pop
    //   6365: new 1004	android/text/SpannableString
    //   6368: dup
    //   6369: aload_1
    //   6370: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6373: invokespecial 1007	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   6376: astore_0
    //   6377: aload 4
    //   6379: iconst_0
    //   6380: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   6383: goto -89 -> 6294
    //   6386: aload 19
    //   6388: aload_0
    //   6389: invokestatic 1010	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6392: aconst_null
    //   6393: iload 6
    //   6395: iload 7
    //   6397: aload 4
    //   6399: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6402: return
    //   6403: aload_2
    //   6404: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6407: sipush -2057
    //   6410: if_icmpne +17 -> 6427
    //   6413: aload 19
    //   6415: getstatic 1015	com/tencent/mobileqq/data/MessageForTroopStory:MSG_CONTENT	Ljava/lang/String;
    //   6418: aconst_null
    //   6419: iconst_0
    //   6420: iconst_0
    //   6421: aload 4
    //   6423: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6426: return
    //   6427: aload_2
    //   6428: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6431: sipush -1012
    //   6434: if_icmpne +70 -> 6504
    //   6437: aload_2
    //   6438: invokevirtual 948	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   6441: invokeinterface 1018 1 0
    //   6446: invokestatic 406	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   6449: astore_1
    //   6450: aload_0
    //   6451: ldc_w 1019
    //   6454: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   6457: astore_2
    //   6458: aload_1
    //   6459: invokevirtual 62	java/lang/String:length	()I
    //   6462: aload_2
    //   6463: invokevirtual 62	java/lang/String:length	()I
    //   6466: isub
    //   6467: iconst_1
    //   6468: isub
    //   6469: istore_3
    //   6470: aload_1
    //   6471: astore_0
    //   6472: aload_1
    //   6473: aload_2
    //   6474: invokevirtual 195	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6477: ifeq +16 -> 6493
    //   6480: aload_1
    //   6481: astore_0
    //   6482: iload_3
    //   6483: ifle +10 -> 6493
    //   6486: aload_1
    //   6487: iconst_0
    //   6488: iload_3
    //   6489: invokevirtual 315	java/lang/String:substring	(II)Ljava/lang/String;
    //   6492: astore_0
    //   6493: aconst_null
    //   6494: aload_0
    //   6495: aconst_null
    //   6496: iconst_0
    //   6497: iconst_0
    //   6498: aload 4
    //   6500: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6503: return
    //   6504: aload_2
    //   6505: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6508: sipush -2059
    //   6511: if_icmpne +33 -> 6544
    //   6514: new 1021	com/tencent/mobileqq/data/MessageForTroopPobing
    //   6517: dup
    //   6518: invokespecial 1022	com/tencent/mobileqq/data/MessageForTroopPobing:<init>	()V
    //   6521: astore_0
    //   6522: aload_0
    //   6523: aload_2
    //   6524: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6527: putfield 1023	com/tencent/mobileqq/data/MessageForTroopPobing:msgData	[B
    //   6530: aload_0
    //   6531: invokevirtual 1026	com/tencent/mobileqq/data/MessageForTroopPobing:doParse	()V
    //   6534: aload 4
    //   6536: aload_0
    //   6537: invokevirtual 1027	com/tencent/mobileqq/data/MessageForTroopPobing:getSummaryMsg	()Ljava/lang/String;
    //   6540: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6543: return
    //   6544: aload_2
    //   6545: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6548: sipush -2066
    //   6551: if_icmpne +87 -> 6638
    //   6554: new 1029	com/tencent/mobileqq/data/MessageForConfessCard
    //   6557: dup
    //   6558: invokespecial 1030	com/tencent/mobileqq/data/MessageForConfessCard:<init>	()V
    //   6561: astore_0
    //   6562: aload_0
    //   6563: aload_2
    //   6564: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   6567: putfield 1031	com/tencent/mobileqq/data/MessageForConfessCard:msg	Ljava/lang/String;
    //   6570: aload_0
    //   6571: invokevirtual 1032	com/tencent/mobileqq/data/MessageForConfessCard:doParse	()V
    //   6574: aload_2
    //   6575: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   6578: sipush 1032
    //   6581: if_icmpne +18 -> 6599
    //   6584: aload 19
    //   6586: aload_0
    //   6587: getfield 1035	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6590: aconst_null
    //   6591: iconst_0
    //   6592: iconst_0
    //   6593: aload 4
    //   6595: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6598: return
    //   6599: ldc 191
    //   6601: new 230	java/lang/StringBuilder
    //   6604: dup
    //   6605: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   6608: aload 19
    //   6610: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6613: ldc_w 1037
    //   6616: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6619: aload_0
    //   6620: getfield 1035	com/tencent/mobileqq/data/MessageForConfessCard:strConfessorDesc	Ljava/lang/String;
    //   6623: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6626: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6629: aconst_null
    //   6630: iconst_0
    //   6631: iconst_0
    //   6632: aload 4
    //   6634: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6637: return
    //   6638: aload_2
    //   6639: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6642: sipush -2067
    //   6645: if_icmpne +38 -> 6683
    //   6648: new 1039	com/tencent/mobileqq/data/MessageForTroopConfess
    //   6651: dup
    //   6652: invokespecial 1040	com/tencent/mobileqq/data/MessageForTroopConfess:<init>	()V
    //   6655: astore_0
    //   6656: aload_0
    //   6657: aload_2
    //   6658: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6661: putfield 1041	com/tencent/mobileqq/data/MessageForTroopConfess:msgData	[B
    //   6664: aload_0
    //   6665: invokevirtual 1042	com/tencent/mobileqq/data/MessageForTroopConfess:doParse	()V
    //   6668: aload 19
    //   6670: aload_0
    //   6671: getfield 1043	com/tencent/mobileqq/data/MessageForTroopConfess:msg	Ljava/lang/String;
    //   6674: aconst_null
    //   6675: iconst_0
    //   6676: iconst_0
    //   6677: aload 4
    //   6679: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6682: return
    //   6683: aload_2
    //   6684: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6687: sipush -5008
    //   6690: if_icmpeq +23 -> 6713
    //   6693: aload_2
    //   6694: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6697: sipush -5016
    //   6700: if_icmpeq +13 -> 6713
    //   6703: aload_2
    //   6704: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6707: sipush -5017
    //   6710: if_icmpne +113 -> 6823
    //   6713: aload_2
    //   6714: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   6717: sipush -5016
    //   6720: if_icmpne +64 -> 6784
    //   6723: new 1045	com/tencent/mobileqq/data/MessageForArkBabyqReply
    //   6726: dup
    //   6727: invokespecial 1046	com/tencent/mobileqq/data/MessageForArkBabyqReply:<init>	()V
    //   6730: astore_0
    //   6731: aload_0
    //   6732: aload_2
    //   6733: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6736: putfield 1047	com/tencent/mobileqq/data/MessageForArkBabyqReply:msgData	[B
    //   6739: aload_0
    //   6740: invokevirtual 1048	com/tencent/mobileqq/data/MessageForArkBabyqReply:doParse	()V
    //   6743: aload 4
    //   6745: aload_0
    //   6746: invokevirtual 1051	com/tencent/mobileqq/data/MessageForArkBabyqReply:getSummery	()Ljava/lang/String;
    //   6749: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6752: aload_1
    //   6753: aload_2
    //   6754: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6757: istore 6
    //   6759: aload_1
    //   6760: aload_2
    //   6761: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6764: istore 7
    //   6766: aload 19
    //   6768: aload 4
    //   6770: getfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6773: aconst_null
    //   6774: iload 6
    //   6776: iload 7
    //   6778: aload 4
    //   6780: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6783: return
    //   6784: new 1053	com/tencent/mobileqq/data/MessageForArkApp
    //   6787: dup
    //   6788: invokespecial 1054	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   6791: astore_0
    //   6792: aload_0
    //   6793: aload_2
    //   6794: getfield 634	com/tencent/imcore/message/QQMessageFacade$Message:msgData	[B
    //   6797: putfield 1055	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   6800: aload_0
    //   6801: invokevirtual 1056	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   6804: aload 4
    //   6806: aload_0
    //   6807: invokevirtual 1057	com/tencent/mobileqq/data/MessageForArkApp:getSummery	()Ljava/lang/String;
    //   6810: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   6813: aload_2
    //   6814: aload 4
    //   6816: aload_1
    //   6817: invokestatic 1060	aqiu:a	(Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   6820: goto -68 -> 6752
    //   6823: aload_1
    //   6824: aload_2
    //   6825: invokestatic 440	aqiu:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6828: istore 6
    //   6830: aload_1
    //   6831: aload_2
    //   6832: invokestatic 443	aqiu:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Z
    //   6835: istore 7
    //   6837: aload_2
    //   6838: getfield 1063	com/tencent/imcore/message/QQMessageFacade$Message:fileType	I
    //   6841: lookupswitch	default:+51->6892, 1:+174->7015, 2:+255->7096, 8:+255->7096, 65536:+156->6997, 65538:+237->7078
    //   6893: ldc_w 598
    //   6896: invokevirtual 601	com/tencent/imcore/message/QQMessageFacade$Message:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   6899: astore 5
    //   6901: getstatic 606	com/tencent/mobileqq/emoticon/EmojiStickerManager:bYE	Z
    //   6904: ifeq +295 -> 7199
    //   6907: aload 5
    //   6909: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6912: ifne +287 -> 7199
    //   6915: aload_1
    //   6916: aload_2
    //   6917: aload 4
    //   6919: invokestatic 645	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/imcore/message/QQMessageFacade$Message;Lcom/tencent/mobileqq/activity/recent/MsgSummary;)Laofk;
    //   6922: astore_0
    //   6923: new 230	java/lang/StringBuilder
    //   6926: dup
    //   6927: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   6930: astore_1
    //   6931: aload 19
    //   6933: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6936: ifne +16 -> 6952
    //   6939: aload_1
    //   6940: aload 19
    //   6942: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6945: ldc_w 647
    //   6948: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6951: pop
    //   6952: aload_2
    //   6953: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   6956: ifne +16 -> 6972
    //   6959: iload 6
    //   6961: ifeq +222 -> 7183
    //   6964: aload_1
    //   6965: ldc_w 649
    //   6968: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6971: pop
    //   6972: aload 19
    //   6974: aload_0
    //   6975: aload_1
    //   6976: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6979: iconst_1
    //   6980: iconst_0
    //   6981: newarray int
    //   6983: invokevirtual 654	aofk:a	(Ljava/lang/String;Z[I)Laofk;
    //   6986: aconst_null
    //   6987: iload 6
    //   6989: iload 7
    //   6991: aload 4
    //   6993: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   6996: return
    //   6997: aload 19
    //   6999: ldc 191
    //   7001: aload_2
    //   7002: getfield 401	com/tencent/imcore/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   7005: iload 6
    //   7007: iload 7
    //   7009: aload 4
    //   7011: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7014: return
    //   7015: aload_2
    //   7016: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   7019: sipush 1001
    //   7022: if_icmpeq +13 -> 7035
    //   7025: aload_2
    //   7026: getfield 113	com/tencent/imcore/message/QQMessageFacade$Message:istroop	I
    //   7029: sipush 10002
    //   7032: if_icmpne +26 -> 7058
    //   7035: aload_2
    //   7036: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7039: sipush -3001
    //   7042: if_icmpne +16 -> 7058
    //   7045: aload 4
    //   7047: aload_0
    //   7048: ldc_w 1064
    //   7051: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   7054: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7057: return
    //   7058: aload 19
    //   7060: aload_0
    //   7061: ldc_w 497
    //   7064: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   7067: aconst_null
    //   7068: iload 6
    //   7070: iload 7
    //   7072: aload 4
    //   7074: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7077: return
    //   7078: aload 19
    //   7080: aload_0
    //   7081: ldc_w 497
    //   7084: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   7087: aconst_null
    //   7088: iconst_0
    //   7089: iconst_0
    //   7090: aload 4
    //   7092: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7095: return
    //   7096: ldc_w 533
    //   7099: iconst_3
    //   7100: anewarray 4	java/lang/Object
    //   7103: dup
    //   7104: iconst_0
    //   7105: iload_3
    //   7106: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7109: aastore
    //   7110: dup
    //   7111: iconst_1
    //   7112: iload 6
    //   7114: invokestatic 536	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7117: aastore
    //   7118: dup
    //   7119: iconst_2
    //   7120: iload 7
    //   7122: invokestatic 536	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7125: aastore
    //   7126: invokestatic 542	afck:l	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   7129: aload_0
    //   7130: ldc_w 523
    //   7133: invokevirtual 81	android/content/Context:getString	(I)Ljava/lang/String;
    //   7136: astore_0
    //   7137: aload_2
    //   7138: getfield 262	com/tencent/imcore/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   7141: aload_1
    //   7142: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7145: invokestatic 1070	aqft:equalsWithNullCheck	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7148: ifeq +22 -> 7170
    //   7151: iload_3
    //   7152: ifeq +18 -> 7170
    //   7155: aload 19
    //   7157: aload_0
    //   7158: ldc 191
    //   7160: iload 6
    //   7162: iload 7
    //   7164: aload 4
    //   7166: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7169: return
    //   7170: aload 19
    //   7172: aload_0
    //   7173: ldc 191
    //   7175: iconst_0
    //   7176: iconst_0
    //   7177: aload 4
    //   7179: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7182: return
    //   7183: iload 7
    //   7185: ifeq -213 -> 6972
    //   7188: aload_1
    //   7189: ldc_w 657
    //   7192: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7195: pop
    //   7196: goto -224 -> 6972
    //   7199: aload_2
    //   7200: invokevirtual 948	com/tencent/imcore/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   7203: astore 5
    //   7205: aload_2
    //   7206: invokestatic 986	aptw:bg	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7209: ifeq +589 -> 7798
    //   7212: aload_2
    //   7213: invokestatic 989	aptw:bi	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7216: ifne +7 -> 7223
    //   7219: aload_2
    //   7220: invokestatic 993	aptw:aI	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   7223: aload_2
    //   7224: invokestatic 996	aptw:x	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   7227: astore 16
    //   7229: aload 16
    //   7231: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7234: ifne +564 -> 7798
    //   7237: aload 16
    //   7239: astore 5
    //   7241: aload_2
    //   7242: getfield 999	com/tencent/imcore/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   7245: ifnull +389 -> 7634
    //   7248: aload 5
    //   7250: ifnull +384 -> 7634
    //   7253: new 230	java/lang/StringBuilder
    //   7256: dup
    //   7257: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   7260: astore_0
    //   7261: aload 19
    //   7263: invokestatic 31	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7266: ifne +16 -> 7282
    //   7269: aload_0
    //   7270: aload 19
    //   7272: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7275: ldc_w 647
    //   7278: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7281: pop
    //   7282: aload_2
    //   7283: invokestatic 351	jof:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7286: ifne +16 -> 7302
    //   7289: iload 6
    //   7291: ifeq +299 -> 7590
    //   7294: aload_0
    //   7295: ldc_w 649
    //   7298: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7301: pop
    //   7302: aload 5
    //   7304: instanceof 651
    //   7307: ifeq +299 -> 7606
    //   7310: aload 5
    //   7312: checkcast 651	aofk
    //   7315: aload_0
    //   7316: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7319: iconst_1
    //   7320: iconst_3
    //   7321: newarray int
    //   7323: dup
    //   7324: iconst_0
    //   7325: aload 5
    //   7327: checkcast 651	aofk
    //   7330: getfield 1073	aofk:mFlags	I
    //   7333: iastore
    //   7334: dup
    //   7335: iconst_1
    //   7336: bipush 16
    //   7338: iastore
    //   7339: dup
    //   7340: iconst_2
    //   7341: iconst_1
    //   7342: iastore
    //   7343: invokevirtual 654	aofk:a	(Ljava/lang/String;Z[I)Laofk;
    //   7346: astore_0
    //   7347: aload 4
    //   7349: iconst_1
    //   7350: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7353: aload_2
    //   7354: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7357: sipush -5040
    //   7360: if_icmpne +435 -> 7795
    //   7363: new 230	java/lang/StringBuilder
    //   7366: dup
    //   7367: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   7370: ldc_w 325
    //   7373: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7376: invokestatic 1079	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7379: ldc_w 1080
    //   7382: invokevirtual 1081	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   7385: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7388: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7391: astore 5
    //   7393: aload_0
    //   7394: invokeinterface 1018 1 0
    //   7399: astore 16
    //   7401: aload 16
    //   7403: ifnull +386 -> 7789
    //   7406: aload 16
    //   7408: aload 5
    //   7410: invokevirtual 1084	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7413: ifeq +376 -> 7789
    //   7416: aload 16
    //   7418: aload 5
    //   7420: ldc 191
    //   7422: invokevirtual 94	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   7425: astore 5
    //   7427: aload 5
    //   7429: astore_0
    //   7430: iload_3
    //   7431: ifne +77 -> 7508
    //   7434: aload_1
    //   7435: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7438: aload_2
    //   7439: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7442: iconst_0
    //   7443: invokevirtual 1087	com/tencent/imcore/message/QQMessageFacade:d	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7446: astore 16
    //   7448: aload 5
    //   7450: astore_0
    //   7451: aload 16
    //   7453: instanceof 1089
    //   7456: ifeq +52 -> 7508
    //   7459: aload 5
    //   7461: astore_0
    //   7462: aload 16
    //   7464: checkcast 1089	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7467: getfield 1093	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lahwa;
    //   7470: ifnull +38 -> 7508
    //   7473: aload 5
    //   7475: astore_0
    //   7476: aload 16
    //   7478: checkcast 1089	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7481: getfield 1093	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lahwa;
    //   7484: getfield 1098	ahwa:dbK	I
    //   7487: invokestatic 1103	ajnu:ky	(I)Z
    //   7490: ifeq +18 -> 7508
    //   7493: aload_1
    //   7494: invokevirtual 224	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7497: aload 5
    //   7499: invokeinterface 1018 1 0
    //   7504: invokestatic 1106	ajoq:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    //   7507: astore_0
    //   7508: aload_2
    //   7509: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7512: invokestatic 1109	top:fB	(I)Z
    //   7515: ifeq +271 -> 7786
    //   7518: aload_1
    //   7519: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   7522: aload_2
    //   7523: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7526: iload_3
    //   7527: invokevirtual 1087	com/tencent/imcore/message/QQMessageFacade:d	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7530: astore_1
    //   7531: aload_1
    //   7532: ifnull +254 -> 7786
    //   7535: aload_1
    //   7536: instanceof 1089
    //   7539: ifeq +247 -> 7786
    //   7542: aload_1
    //   7543: checkcast 1089	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7546: getfield 1093	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lahwa;
    //   7549: ifnull +237 -> 7786
    //   7552: aload_1
    //   7553: checkcast 1089	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7556: getfield 1093	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lahwa;
    //   7559: getfield 1098	ahwa:dbK	I
    //   7562: ldc_w 1110
    //   7565: if_icmpne +221 -> 7786
    //   7568: aload_1
    //   7569: checkcast 1089	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   7572: invokevirtual 1111	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:getSummaryMsg	()Ljava/lang/String;
    //   7575: astore_0
    //   7576: aload 19
    //   7578: aload_0
    //   7579: aconst_null
    //   7580: iload 6
    //   7582: iload 7
    //   7584: aload 4
    //   7586: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7589: return
    //   7590: iload 7
    //   7592: ifeq -290 -> 7302
    //   7595: aload_0
    //   7596: ldc_w 657
    //   7599: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7602: pop
    //   7603: goto -301 -> 7302
    //   7606: aload_0
    //   7607: aload 5
    //   7609: invokevirtual 1002	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   7612: pop
    //   7613: new 1004	android/text/SpannableString
    //   7616: dup
    //   7617: aload_0
    //   7618: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7621: invokespecial 1007	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   7624: astore_0
    //   7625: aload 4
    //   7627: iconst_0
    //   7628: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7631: goto -278 -> 7353
    //   7634: aload 5
    //   7636: ifnull +114 -> 7750
    //   7639: aload 5
    //   7641: invokeinterface 1018 1 0
    //   7646: invokevirtual 256	java/lang/String:trim	()Ljava/lang/String;
    //   7649: astore 5
    //   7651: getstatic 1114	acbn:bkD	Ljava/lang/String;
    //   7654: aload_2
    //   7655: getfield 110	com/tencent/imcore/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   7658: invokevirtual 1117	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   7661: ifeq +119 -> 7780
    //   7664: aload 5
    //   7666: ifnull +114 -> 7780
    //   7669: aload 5
    //   7671: invokevirtual 62	java/lang/String:length	()I
    //   7674: ifle +106 -> 7780
    //   7677: aload_0
    //   7678: aload_1
    //   7679: aload 5
    //   7681: aload_2
    //   7682: invokestatic 1119	aqiu:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/imcore/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   7685: astore_0
    //   7686: aload 19
    //   7688: aconst_null
    //   7689: aload_0
    //   7690: iload 6
    //   7692: aload_1
    //   7693: invokevirtual 976	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   7696: aload_2
    //   7697: invokevirtual 981	anaz:aR	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   7700: aload 4
    //   7702: invokestatic 431	aqiu:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   7705: aload_2
    //   7706: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:msgtype	I
    //   7709: sipush -1000
    //   7712: if_icmpne +44 -> 7756
    //   7715: aload 4
    //   7717: getfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7720: ifnull +36 -> 7756
    //   7723: aload 4
    //   7725: new 651	aofk
    //   7728: dup
    //   7729: aload 4
    //   7731: getfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7734: iconst_1
    //   7735: bipush 16
    //   7737: invokespecial 1122	aofk:<init>	(Ljava/lang/CharSequence;II)V
    //   7740: putfield 412	com/tencent/mobileqq/activity/recent/MsgSummary:strContent	Ljava/lang/CharSequence;
    //   7743: aload 4
    //   7745: iconst_1
    //   7746: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7749: return
    //   7750: aconst_null
    //   7751: astore 5
    //   7753: goto -102 -> 7651
    //   7756: aload 4
    //   7758: iconst_0
    //   7759: putfield 669	com/tencent/mobileqq/activity/recent/MsgSummary:mEmojiFlag	I
    //   7762: return
    //   7763: astore 5
    //   7765: goto -2602 -> 5163
    //   7768: astore 17
    //   7770: aload 16
    //   7772: astore_1
    //   7773: aload 17
    //   7775: astore 16
    //   7777: goto -6978 -> 799
    //   7780: aload 5
    //   7782: astore_0
    //   7783: goto -97 -> 7686
    //   7786: goto -210 -> 7576
    //   7789: aload_0
    //   7790: astore 5
    //   7792: goto -365 -> 7427
    //   7795: goto -287 -> 7508
    //   7798: goto -557 -> 7241
    //   7801: goto -1596 -> 6205
    //   7804: iconst_0
    //   7805: istore 6
    //   7807: iconst_0
    //   7808: istore 7
    //   7810: goto -1989 -> 5821
    //   7813: goto -4185 -> 3628
    //   7816: iconst_0
    //   7817: istore 6
    //   7819: goto -5417 -> 2402
    //   7822: goto -5503 -> 2319
    //   7825: aload 5
    //   7827: astore_0
    //   7828: goto -5835 -> 1993
    //   7831: iconst_0
    //   7832: istore 7
    //   7834: goto -6826 -> 1008
    //   7837: goto -6912 -> 925
    //   7840: aload_1
    //   7841: astore_0
    //   7842: goto -7136 -> 706
    //   7845: iconst_0
    //   7846: istore 6
    //   7848: goto -7263 -> 585
    //   7851: iconst_0
    //   7852: istore 6
    //   7854: goto -7308 -> 546
    //   7857: goto -7390 -> 467
    //   7860: aload 16
    //   7862: astore 5
    //   7864: goto -7728 -> 136
    //   7867: iconst_0
    //   7868: istore 6
    //   7870: goto -7324 -> 546
    //   7873: iconst_1
    //   7874: istore_3
    //   7875: goto -5996 -> 1879
    //   7878: astore_1
    //   7879: aload 17
    //   7881: astore_0
    //   7882: goto -5803 -> 2079
    //   7885: iconst_0
    //   7886: istore 6
    //   7888: goto -5486 -> 2402
    //   7891: ldc2_w 114
    //   7894: lstore 14
    //   7896: goto -5414 -> 2482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7899	0	paramContext	Context
    //   0	7899	1	paramQQAppInterface	QQAppInterface
    //   0	7899	2	paramMessage	QQMessageFacade.Message
    //   0	7899	3	paramInt	int
    //   0	7899	4	paramMsgSummary	MsgSummary
    //   0	7899	5	paramString	String
    //   0	7899	6	paramBoolean1	boolean
    //   0	7899	7	paramBoolean2	boolean
    //   258	5622	8	i	int
    //   1748	522	9	j	int
    //   433	5879	10	bool1	boolean
    //   2273	3892	11	bool2	boolean
    //   1688	543	12	bool3	boolean
    //   1695	546	13	bool4	boolean
    //   530	7365	14	l	long
    //   25	704	16	localObject1	Object
    //   795	5	16	localException1	Exception
    //   806	7055	16	localObject2	Object
    //   445	2266	17	localObject3	Object
    //   7768	112	17	localException2	Exception
    //   436	1910	18	str1	String
    //   220	7467	19	str2	String
    //   2343	256	20	localMessageForPic	MessageForPic
    // Exception table:
    //   from	to	target	type
    //   441	467	795	java/lang/Exception
    //   467	489	795	java/lang/Exception
    //   1926	1955	2078	java/lang/Exception
    //   1955	1962	2078	java/lang/Exception
    //   1967	1975	2078	java/lang/Exception
    //   1975	1991	2078	java/lang/Exception
    //   2067	2075	2078	java/lang/Exception
    //   2285	2291	2665	java/lang/Exception
    //   2295	2309	2665	java/lang/Exception
    //   2313	2319	2665	java/lang/Exception
    //   2323	2345	2665	java/lang/Exception
    //   2349	2363	2665	java/lang/Exception
    //   2366	2373	2665	java/lang/Exception
    //   2376	2383	2665	java/lang/Exception
    //   2598	2609	2665	java/lang/Exception
    //   2622	2629	2665	java/lang/Exception
    //   2632	2641	2665	java/lang/Exception
    //   2820	2855	2956	java/lang/Throwable
    //   2871	2921	2956	java/lang/Throwable
    //   2926	2951	2956	java/lang/Throwable
    //   4683	4689	5159	java/lang/Exception
    //   4689	4709	5159	java/lang/Exception
    //   4709	4723	5159	java/lang/Exception
    //   5751	5757	5891	java/lang/Exception
    //   5757	5777	5891	java/lang/Exception
    //   5777	5810	5891	java/lang/Exception
    //   5841	5849	5891	java/lang/Exception
    //   5858	5876	5891	java/lang/Exception
    //   4723	4751	7763	java/lang/Exception
    //   4755	4835	7763	java/lang/Exception
    //   5069	5076	7763	java/lang/Exception
    //   5080	5088	7763	java/lang/Exception
    //   5092	5103	7763	java/lang/Exception
    //   5111	5122	7763	java/lang/Exception
    //   5126	5137	7763	java/lang/Exception
    //   5137	5153	7763	java/lang/Exception
    //   493	507	7768	java/lang/Exception
    //   510	517	7768	java/lang/Exception
    //   525	532	7768	java/lang/Exception
    //   728	739	7768	java/lang/Exception
    //   752	759	7768	java/lang/Exception
    //   762	771	7768	java/lang/Exception
    //   1704	1713	7878	java/lang/Exception
    //   1721	1729	7878	java/lang/Exception
    //   1733	1750	7878	java/lang/Exception
    //   1761	1768	7878	java/lang/Exception
    //   1794	1807	7878	java/lang/Exception
    //   1811	1817	7878	java/lang/Exception
    //   1821	1828	7878	java/lang/Exception
    //   1832	1846	7878	java/lang/Exception
    //   1850	1876	7878	java/lang/Exception
    //   1891	1897	7878	java/lang/Exception
    //   1901	1914	7878	java/lang/Exception
    //   1918	1926	7878	java/lang/Exception
    //   2017	2043	7878	java/lang/Exception
    //   2050	2057	7878	java/lang/Exception
    //   2114	2119	7878	java/lang/Exception
    //   2127	2135	7878	java/lang/Exception
    //   2139	2147	7878	java/lang/Exception
    //   2151	2164	7878	java/lang/Exception
    //   2168	2175	7878	java/lang/Exception
    //   2184	2192	7878	java/lang/Exception
    //   2196	2212	7878	java/lang/Exception
    //   2216	2222	7878	java/lang/Exception
    //   2226	2239	7878	java/lang/Exception
    //   2249	2257	7878	java/lang/Exception
    //   2410	2417	7878	java/lang/Exception
    //   2421	2426	7878	java/lang/Exception
    //   2430	2441	7878	java/lang/Exception
    //   2452	2458	7878	java/lang/Exception
    //   2462	2469	7878	java/lang/Exception
    //   2473	2482	7878	java/lang/Exception
    //   2486	2527	7878	java/lang/Exception
    //   2535	2543	7878	java/lang/Exception
    //   2547	2554	7878	java/lang/Exception
    //   2558	2565	7878	java/lang/Exception
    //   2569	2577	7878	java/lang/Exception
    //   2581	2594	7878	java/lang/Exception
    //   2670	2674	7878	java/lang/Exception
    //   2702	2708	7878	java/lang/Exception
    //   2712	2739	7878	java/lang/Exception
  }
  
  private static void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessage.istroop == 10007) && (paramMessage.msgtype == -5008)) {
      paramMsgSummary.strContent += paramQQAppInterface.getApp().getString(2131694206);
    }
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.strPrefix = paramCharSequence1;
    paramMsgSummary.strContent = paramCharSequence2;
    paramMsgSummary.suffix = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.nState = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.nState = 1;
      return;
    }
    paramMsgSummary.nState = 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramMessageForPic.isMultiMsg) {}
    while (!paramMessageForPic.isSendFromLocal()) {
      return false;
    }
    if (paramMessageForPic.size <= 0L)
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      if ((paramQQAppInterface instanceof aojn))
      {
        long l = ((aojn)paramQQAppInterface).hh();
        if ((l == 1005L) || ((l == 1006L) && (!paramBoolean)) || (l == 1004L)) {}
        for (paramBoolean = true;; paramBoolean = false) {
          return paramBoolean;
        }
      }
      return true;
    }
    if (paramMessageForPic.extraflag == 32768) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static String b(String paramString, float paramFloat)
  {
    Object localObject3 = paramString;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label20;
      }
      localObject3 = paramString;
    }
    label20:
    float f1;
    for (;;)
    {
      return localObject3;
      long l1 = 0L;
      if (QLog.isDevelopLevel()) {
        l1 = SystemClock.elapsedRealtime();
      }
      if (dZo == 0) {}
      label803:
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
        localObject3 = acfp.m(2131708558);
        TextPaint localTextPaint = new TextPaint();
        localTextPaint.setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
        f1 = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
        float f2 = ((DisplayMetrics)localObject1).density;
        f1 -= f2 * 72.0F;
        if (f1 <= 0.0F)
        {
          localObject3 = paramString;
          return paramString;
        }
        AH = 0.7F * f1;
        AF = localTextPaint.measureText((String)localObject3);
        AG = localTextPaint.measureText("AaJjIiMm") / "AaJjIiMm".length();
        if (AF > 1.0F) {
          dZo = (int)(f1 * 0.8F / AF);
        }
        if (AG > 1.0F) {
          dZo = Math.min(dZo, (int)(AH / AG));
        }
        if (dZo <= 0) {
          dZo = 14;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          localException.printStackTrace();
          dZo = 14;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder(120);
            localStringBuilder.append("trimName").append(", sMaxWidth = ").append(AH).append(", sMinLen = ").append(dZo).append(", sZhW = ").append(AF).append(", sEnW = ").append(AG);
            QLog.i("Q.recent", 2, localStringBuilder.toString());
          }
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
          dZo = 14;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(120);
            ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(AH).append(", sMinLen = ").append(dZo).append(", sZhW = ").append(AF).append(", sEnW = ").append(AG);
            QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label803;
        }
        localObject2 = new StringBuilder(120);
        ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(AH).append(", sMinLen = ").append(dZo).append(", sZhW = ").append(AF).append(", sEnW = ").append(AG);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
      }
    }
    int k = paramString.length();
    localObject1 = paramString;
    if (k >= dZo)
    {
      localObject1 = paramString;
      if (AG >= 1.0F)
      {
        if (AF >= 1.0F) {
          break label805;
        }
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      long l2 = asK;
      asK = SystemClock.elapsedRealtime() - l1 + l2;
      asL += 1L;
      localObject3 = localObject1;
      if (asL % 10L != 1L) {
        break;
      }
      QLog.i("Q.recent", 4, "trimName, cost = " + asK / asL);
      return localObject1;
      StringBuilder localStringBuilder;
      label805:
      f1 = 0.0F;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        int m = paramString.charAt(i);
        if ((m >= 32) && (m <= 126)) {}
        for (f1 += AG;; f1 += AF)
        {
          if (AH * paramFloat - f1 <= 1.0F) {
            break label884;
          }
          j += 1;
          i += 1;
          break;
        }
      }
      label884:
      Object localObject2 = paramString;
      if (j < k)
      {
        localObject2 = paramString;
        if (j > 0) {
          localObject2 = paramString.substring(0, j - 1) + "...";
        }
      }
    }
  }
  
  private static boolean b(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = paramQQAppInterface.b().a().cy().iterator();
    while (localIterator.hasNext()) {
      if (((tpg)localIterator.next()).a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramString, paramBoolean1, paramBoolean2)) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {}
    do
    {
      return null;
      if (paramMessageForPic.picExtraData != null)
      {
        String str = paramMessageForPic.picExtraData.textSummary;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("msgSummary", 2, "textSummary: " + aqft.pk(str));
          }
          return str;
        }
      }
      if ((paramMessageForPic.picExtraData != null) && ((paramMessageForPic.picExtraData.isHotPics()) || (paramMessageForPic.picExtraData.isCustomFace()) || (ykm.e(paramMessageForPic)) || (afdw.ap(paramMessageForPic)) || (yhf.c(paramMessageForPic)))) {
        return BaseApplicationImpl.getApplication().getString(2131692307);
      }
    } while (!paramMessageForPic.checkGif());
    return BaseApplicationImpl.getApplication().getString(2131692307);
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    QQMessageFacade.Message localMessage;
    label105:
    label112:
    do
    {
      do
      {
        do
        {
          return false;
          localMessage = paramMessage;
          if (!top.x(paramMessage.frienduin, paramMessage.istroop)) {
            break;
          }
          localMessage = paramMessage;
          if (paramMessage.senderuin == null) {
            break;
          }
        } while (top.gR(paramMessage.senderuin));
        int i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label105;
          }
        }
        for (i = 1033;; i = 1034)
        {
          localMessage = paramQQAppInterface.b().a(paramMessage.senderuin, i);
          if (localMessage.msgtype != -2005) {
            break label112;
          }
          if (a(paramQQAppInterface, localMessage) != 0) {
            break;
          }
          return true;
        }
        if (localMessage.fileType == 1)
        {
          i = paramQQAppInterface.a().c(localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break label284;
          }
          return true;
        }
        if (localMessage.msgtype != -2017) {
          break label284;
        }
        paramMessage = paramQQAppInterface.b().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
        if (!(paramMessage instanceof MessageForTroopFile)) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramMessage;
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = apsv.a(paramQQAppInterface, paramMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.Status != 3));
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgTypeError", 2, "uniseq:" + localMessage.uniseq + ",msgtype:" + localMessage.msgtype);
    }
    label284:
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    QQMessageFacade.Message localMessage = paramMessage;
    if (top.x(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (top.gR(paramMessage.senderuin)) {
          return false;
        }
        i = paramMessage.istroop;
        if (paramMessage.istroop == 1032) {
          if (!paramMessage.isSelfConfessor()) {
            break label103;
          }
        }
      }
    }
    label103:
    for (int i = 1033;; i = 1034)
    {
      localMessage = paramQQAppInterface.b().a(paramMessage.senderuin, i);
      if (localMessage.msgtype != -2005) {
        break label112;
      }
      if (2 != a(paramQQAppInterface, localMessage)) {
        break;
      }
      return true;
    }
    return false;
    label112:
    if (localMessage.msgtype == -2017)
    {
      paramMessage = paramQQAppInterface.b().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && ((paramMessage instanceof MessageForTroopFile)))
      {
        paramMessage = (MessageForTroopFile)paramMessage;
        if ((paramMessage != null) && (paramMessage.frienduin != null))
        {
          paramQQAppInterface = apsv.a(paramQQAppInterface, paramMessage);
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.Status == 1) || (paramQQAppInterface.Status == 0))) {
            return true;
          }
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof aojs)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((aojs)paramMessage).getProgress() >= 0) && (((aojs)paramMessage).getProgress() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().aR(localMessage);
  }
  
  public static boolean ms(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean mt(int paramInt)
  {
    return 1 == paramInt;
  }
  
  public static boolean mu(int paramInt)
  {
    return 2 == paramInt;
  }
  
  public static String pC(String paramString)
  {
    String str = acfp.m(2131708549);
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String pD(String paramString)
  {
    return b(paramString, 1.0F);
  }
  
  public static String pE(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int j;
    int i;
    do
    {
      return paramString;
      localObject = paramString.toCharArray();
      j = paramString.length();
      i = 0;
      j -= 1;
      while ((i <= j) && (localObject[i] <= ' ') && (localObject[i] != '\024')) {
        i += 1;
      }
    } while (i == 0);
    Object localObject = paramString.substring(i, j + 1);
    if (QLog.isDevelopLevel()) {
      QLog.i("MsgUtils", 4, "trimBegin source:" + paramString + ", temp:" + (String)localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqiu
 * JD-Core Version:    0.7.0.1
 */