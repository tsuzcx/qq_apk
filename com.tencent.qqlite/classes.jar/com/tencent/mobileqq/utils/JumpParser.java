package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class JumpParser
{
  private static final int a = 0;
  public static final String a = "http://clientui.3g.qq.com/mqqapi/";
  private static final int b = 1;
  public static final String b = "mqqapi://";
  private static final int c = 0;
  public static final String c = "mqqmdpass://";
  private static final int d = 1;
  public static final String d = "http://clientui.3g.qq.com/mqq/";
  public static final String e = "mqq://";
  public static final String f = "qapp://";
  public static final String g = "http://qm.qq.com/cgi-bin/";
  public static final String h = "mqqopensdkapi://bizAgent/";
  public static final String i = "mqqflyticket://";
  public static final String j = "mqqwpa://";
  public static final String k = "wtloginmqq://";
  public static final String l = "mqqapi://readingcenter";
  public static final String m = "mqqapi://qzone/groupalbum";
  public static final String n = "mqqtribe://";
  public static final String o = "mqqapi://wallet/open";
  public static final String p = "mqqapi://im/chat";
  public static final String q = "mqqapi://wallet/open?src_type=web&viewtype=0&version=1";
  public static final String r = "mqqmdpass://wallet/modify_pass";
  public static final String s = "mqqapi://qqdataline/openqqdataline";
  public static final String t = "mqqverifycode://";
  public static final String u = "mqq://shop/";
  public static final String v = "mqqvoipivr://";
  public static final String w = "mqqapi://dating/";
  private static final String x = "JumpAction";
  
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = paramString;
    if (paramString.contains("videochat"))
    {
      str1 = paramString;
      if (paramString.contains("uinType=21")) {
        str1 = URLDecoder.decode(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + str1);
    }
    if (str1 == null) {
      return null;
    }
    int i1;
    if (str1.startsWith("mqqapi://wallet/open"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cd = str1;
      paramQQAppInterface.ce = "wallet";
      paramQQAppInterface.cf = "open";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    if (str1.startsWith("mqqmdpass://wallet/modify_pass"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.cd = str1;
      paramQQAppInterface.ce = "wallet";
      paramQQAppInterface.cf = "modify_pass";
      paramContext = str1.split("\\?");
      if (paramContext.length != 2) {
        return paramQQAppInterface;
      }
      paramContext = paramContext[1].split("&");
      if (paramContext != null)
      {
        i1 = 0;
        while (i1 < paramContext.length)
        {
          paramString = paramContext[i1].split("=");
          if ((paramString != null) && (paramString.length == 2)) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i1 += 1;
        }
      }
      return paramQQAppInterface;
    }
    JumpAction localJumpAction;
    Object localObject1;
    if (str1.startsWith("mqqapi://qzone/groupalbum"))
    {
      paramString = str1.split("\\?");
      if (paramString.length != 2) {
        return null;
      }
      localJumpAction = paramString[0];
      localObject1 = paramString[1];
      paramString = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (localJumpAction.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localJumpAction.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break;
        }
        return null;
        if (localJumpAction.startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localJumpAction.substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (localJumpAction.startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localJumpAction.substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localJumpAction.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqapi://".length());
        }
        else if (localJumpAction.startsWith("mqq://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqq://".length());
        }
        else if (localJumpAction.startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localJumpAction.substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (localJumpAction.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqflyticket://".length());
        }
        else if (localJumpAction.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqwpa://".length());
        }
        else if (localJumpAction.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localJumpAction.substring("wtloginmqq://".length());
        }
        else if (localJumpAction.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqtribe://".length());
        }
        else if (localJumpAction.startsWith("mqqvoipivr://"))
        {
          paramQQAppInterface = localJumpAction.substring("mqqvoipivr://".length());
        }
        else
        {
          paramQQAppInterface = paramString;
          if (localJumpAction.startsWith("qapp://")) {
            paramQQAppInterface = localJumpAction.substring("qapp://".length());
          }
        }
      }
      paramContext.cd = str1;
      paramContext.ce = paramQQAppInterface[0];
      paramContext.cf = paramQQAppInterface[1];
      paramQQAppInterface = ((String)localObject1).split("&");
      i1 = 0;
      for (;;)
      {
        if (i1 < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i1].split("=");
          if (paramString.length == 2) {}
          try
          {
            paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
            paramContext.a(paramString[0], paramString[1]);
            i1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException);
              }
            }
          }
        }
      }
      return paramContext;
    }
    boolean bool2 = localException.startsWith("mqqapi://readingcenter");
    boolean bool3 = localException.startsWith("wtloginmqq://");
    boolean bool4 = localException.startsWith("mqqwpa://");
    boolean bool5 = localException.startsWith("mqqvoipivr://");
    boolean bool6 = localException.startsWith("mqqtribe://");
    boolean bool7 = localException.startsWith("mqqverifycode://");
    int i2;
    if ((localException.startsWith("mqqapi://im/chat")) && (localException.contains("chat_type=crm")) && (localException.contains("kfnick=")))
    {
      i1 = 1;
      if ((localException.startsWith("mqqopensdkapi://bizAgent/")) || (bool2) || (bool3) || (bool4) || (bool6) || (bool5)) {
        break label945;
      }
      i2 = 1;
      label902:
      localObject1 = localException;
      if (i2 == 0) {
        break label957;
      }
      if ((bool2) || (i1 != 0)) {
        break label951;
      }
    }
    label945:
    label951:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString = a(localException, bool1);
      localObject1 = paramString;
      if (paramString != null) {
        break label957;
      }
      return null;
      i1 = 0;
      break;
      i2 = 0;
      break label902;
    }
    label957:
    if ((bool2) || (bool3) || (bool4) || (bool6) || (bool7) || (bool5)) {}
    for (paramString = a((String)localObject1, "?"); paramString.length != 2; paramString = ((String)localObject1).split("\\?")) {
      return null;
    }
    Object localObject2 = paramString[0];
    paramString = paramString[1];
    if (i2 != 0) {
      if ((!bool2) && (i1 == 0))
      {
        bool1 = true;
        paramString = a(paramString, bool1);
      }
    }
    for (;;)
    {
      String str2 = "";
      localJumpAction = new JumpAction(paramQQAppInterface, paramContext);
      if (localObject2.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localObject2.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break label1371;
        }
        return null;
        bool1 = false;
        break;
        if (localObject2.startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localObject2.substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localObject2.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localObject2.substring("mqqapi://".length());
        }
        else if (localObject2.startsWith("mqq://"))
        {
          paramQQAppInterface = localObject2.substring("mqq://".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (localObject2.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localObject2.substring("mqqflyticket://".length());
        }
        else if (localObject2.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localObject2.substring("mqqwpa://".length());
        }
        else if (localObject2.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localObject2.substring("wtloginmqq://".length());
        }
        else if (localObject2.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localObject2.substring("mqqtribe://".length());
        }
        else if (localObject2.startsWith("mqqverifycode://"))
        {
          paramQQAppInterface = localObject2.substring("mqqverifycode://".length());
        }
        else
        {
          paramQQAppInterface = str2;
          if (localObject2.startsWith("mqqvoipivr://")) {
            paramQQAppInterface = localObject2.substring("mqqvoipivr://".length());
          }
        }
      }
      label1371:
      localJumpAction.cd = ((String)localObject1);
      localJumpAction.ce = paramQQAppInterface[0];
      localJumpAction.cf = paramQQAppInterface[1];
      if (bool3)
      {
        paramQQAppInterface = paramString.split("&");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length != 2)) {
          break label1664;
        }
        if ((paramQQAppInterface[1] != null) && (paramQQAppInterface[1].contains("schemacallback=")))
        {
          paramContext = paramQQAppInterface[1];
          paramQQAppInterface = paramQQAppInterface[0];
          paramString = paramQQAppInterface;
          if (paramContext.length() > 0)
          {
            if (bool2) {
              break label1570;
            }
            bool1 = true;
            label1458:
            paramContext = a(a(paramContext, bool1), "=");
            paramString = paramQQAppInterface;
            if (paramContext.length == 2)
            {
              localJumpAction.a(paramContext[0], paramContext[1]);
              paramString = paramQQAppInterface;
            }
          }
        }
      }
      label1664:
      for (;;)
      {
        if ((paramString != null) && (paramString.length() > 0)) {
          if (bool2) {
            break label1576;
          }
        }
        label1570:
        label1576:
        for (bool1 = true;; bool1 = false)
        {
          paramQQAppInterface = a(a(paramString, bool1), "=");
          if (paramQQAppInterface.length == 2) {
            localJumpAction.a(paramQQAppInterface[0], paramQQAppInterface[1]);
          }
          return localJumpAction;
          if ((paramQQAppInterface[0] == null) || (!paramQQAppInterface[0].contains("schemacallback="))) {
            break label1656;
          }
          paramContext = paramQQAppInterface[0];
          paramQQAppInterface = paramQQAppInterface[1];
          break;
          bool1 = false;
          break label1458;
        }
        paramQQAppInterface = paramString.split("&");
        i1 = 0;
        if (i1 < paramQQAppInterface.length)
        {
          paramContext = a(paramQQAppInterface[i1], "=");
          if (paramContext.length == 2)
          {
            if (!bool4) {
              break label1639;
            }
            localJumpAction.a(paramContext[0], a(paramContext[1], false));
          }
          for (;;)
          {
            i1 += 1;
            break;
            label1639:
            localJumpAction.a(paramContext[0], paramContext[1]);
          }
        }
        return localJumpAction;
        label1656:
        paramQQAppInterface = paramString;
        paramContext = "";
        break;
      }
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      String str2 = URLDecoder.decode(paramString);
      str1 = str2;
      if (paramBoolean)
      {
        localObject1 = str2;
        str1 = str2.replaceAll(" ", "+");
      }
    }
    catch (Exception localException)
    {
      do
      {
        String str1;
        Object localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "JumpParser parser Exception =" + paramString);
    }
    return str1;
    return localObject1;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i1 = paramString1.indexOf(paramString2);
    if (i1 == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i1), paramString1.substring(i1 + paramString2.length(), paramString1.length()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */