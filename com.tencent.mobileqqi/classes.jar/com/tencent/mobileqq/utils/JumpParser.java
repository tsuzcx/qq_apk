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
  public static final String c = "http://clientui.3g.qq.com/mqq/";
  private static final int d = 1;
  public static final String d = "mqq://";
  public static final String e = "http://qm.qq.com/cgi-bin/";
  public static final String f = "mqqopensdkapi://bizAgent/";
  public static final String g = "mqqflyticket://";
  public static final String h = "mqqwpa://";
  public static final String i = "wtloginmqq://";
  public static final String j = "mqqapi://readingcenter";
  public static final String k = "mqqapi://qzone/groupalbum";
  public static final String l = "mqqapi://qzone/to_publish_queue";
  public static final String m = "mqqtribe://";
  public static final String n = "mqqapi://wallet/open";
  public static final String o = "mqqapi://wallet/open?src_type=web&viewtype=0&version=1";
  public static final String p = "mqq://shop/";
  private static final String q = "JumpAction";
  
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + paramString);
    }
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("mqqapi://qzone/to_publish_queue"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.bf = paramString;
      paramQQAppInterface.bg = "qzone";
      paramQQAppInterface.bh = "to_publish_queue";
      return paramQQAppInterface;
    }
    int i1;
    if (paramString.startsWith("mqqapi://wallet/open"))
    {
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.bf = paramString;
      paramQQAppInterface.bg = "wallet";
      paramQQAppInterface.bh = "open";
      paramContext = paramString.split("\\?");
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
    String str2;
    if (paramString.startsWith("mqqapi://qzone/groupalbum"))
    {
      Object localObject1 = paramString.split("\\?");
      if (localObject1.length != 2) {
        return null;
      }
      localJumpAction = localObject1[0];
      str2 = localObject1[1];
      localObject1 = "";
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
        else
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (localJumpAction.startsWith("mqqtribe://")) {
            paramQQAppInterface = localJumpAction.substring("mqqtribe://".length());
          }
        }
      }
      paramContext.bf = paramString;
      paramContext.bg = paramQQAppInterface[0];
      paramContext.bh = paramQQAppInterface[1];
      paramQQAppInterface = str2.split("&");
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
    boolean bool2 = paramString.startsWith("mqqapi://readingcenter");
    boolean bool3 = paramString.startsWith("wtloginmqq://");
    boolean bool4 = paramString.startsWith("mqqwpa://");
    boolean bool5 = paramString.startsWith("mqqtribe://");
    String str1;
    if ((!paramString.startsWith("mqqopensdkapi://bizAgent/")) && (!bool2) && (!bool3) && (!bool4) && (!bool5))
    {
      i1 = 1;
      str1 = paramString;
      if (i1 == 0) {
        break label728;
      }
      if (bool2) {
        break label722;
      }
    }
    label722:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString = a(paramString, bool1);
      str1 = paramString;
      if (paramString != null) {
        break label728;
      }
      return null;
      i1 = 0;
      break;
    }
    label728:
    if ((bool2) || (bool3) || (bool4) || (bool5)) {}
    for (paramString = a(str1, "?"); paramString.length != 2; paramString = str1.split("\\?")) {
      return null;
    }
    Object localObject2 = paramString[0];
    paramString = paramString[1];
    if (i1 != 0) {
      if (!bool2)
      {
        bool1 = true;
        paramString = a(paramString, bool1);
      }
    }
    for (;;)
    {
      str2 = "";
      localJumpAction = new JumpAction(paramQQAppInterface, paramContext);
      if (localObject2.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localObject2.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break label1079;
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
        else
        {
          paramQQAppInterface = str2;
          if (localObject2.startsWith("mqqtribe://")) {
            paramQQAppInterface = localObject2.substring("mqqtribe://".length());
          }
        }
      }
      label1079:
      localJumpAction.bf = str1;
      localJumpAction.bg = paramQQAppInterface[0];
      localJumpAction.bh = paramQQAppInterface[1];
      if (bool3)
      {
        paramQQAppInterface = paramString.split("&");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length != 2)) {
          break label1399;
        }
        if ((paramQQAppInterface[1] != null) && (paramQQAppInterface[1].contains("schemacallback=")))
        {
          paramContext = paramQQAppInterface[1];
          paramQQAppInterface = paramQQAppInterface[0];
          paramString = paramQQAppInterface;
          if (paramContext.length() > 0)
          {
            if (bool2) {
              break label1278;
            }
            bool1 = true;
            label1166:
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
      label1284:
      label1329:
      label1374:
      label1391:
      label1399:
      for (;;)
      {
        if ((paramString != null) && (paramString.length() > 0)) {
          if (bool2) {
            break label1284;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          paramQQAppInterface = a(a(paramString, bool1), "=");
          if (paramQQAppInterface.length == 2) {
            localJumpAction.a(paramQQAppInterface[0], paramQQAppInterface[1]);
          }
          return localJumpAction;
          if ((paramQQAppInterface[0] == null) || (!paramQQAppInterface[0].contains("schemacallback="))) {
            break label1391;
          }
          paramContext = paramQQAppInterface[0];
          paramQQAppInterface = paramQQAppInterface[1];
          break;
          label1278:
          bool1 = false;
          break label1166;
        }
        paramContext = paramString.split("&");
        i1 = 0;
        if (i1 < paramContext.length)
        {
          if ((bool2) || (bool4) || (bool5))
          {
            paramQQAppInterface = a(paramContext[i1], "=");
            if (paramQQAppInterface.length == 2)
            {
              if (!bool4) {
                break label1374;
              }
              localJumpAction.a(paramQQAppInterface[0], a(paramQQAppInterface[1], false));
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            paramQQAppInterface = paramContext[i1].split("=");
            break label1329;
            localJumpAction.a(paramQQAppInterface[0], paramQQAppInterface[1]);
          }
        }
        return localJumpAction;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */