package com.tencent.mobileqq.international;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LocaleString
{
  private static final String jdField_a_of_type_JavaLangString = "MicroMsg.LocaleUtil";
  private static Map jdField_a_of_type_JavaUtilMap;
  
  static
  {
    a = new HashMap();
    a.put("同意", Integer.valueOf(2131561087));
    a.put("拒绝", Integer.valueOf(2131561088));
    a.put("邀请", Integer.valueOf(2131562250));
    a.put("加入", Integer.valueOf(2131560188));
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("我的好友")) {}
    do
    {
      return 2131559858;
      if (paramString.equals("兴趣爱好")) {
        return 2131559859;
      }
      if (paramString.equals("自我个性")) {
        return 2131559860;
      }
      if (paramString.equals("现在状态")) {
        return 2131559861;
      }
      if (paramString.equals("年代星座")) {
        return 2131559862;
      }
    } while (paramString.equals("社会名片"));
    return 2131559862;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    LocaleUtil.a(paramContext);
    ServerPushStringMap localServerPushStringMap = ServerPushStringMap.getInstance();
    if ((localServerPushStringMap != null) && (localServerPushStringMap.containsKey(paramString))) {
      return paramContext.getString(((Integer)localServerPushStringMap.get(paramString)).intValue());
    }
    QLog.d("MicroMsg.LocaleUtil", 2, "login tips: " + paramString);
    return paramContext.getString(2131562324);
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return paramString1;
      paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    } while ((!paramString2.find()) || (paramString2.groupCount() != 1));
    paramString1 = paramString2.group(1);
    return String.format(paramContext.getString(paramInt), new Object[] { paramString1 });
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("Recent Contacts")) {
      str = "Recent";
    }
    return str;
  }
  
  public static void a(String paramString, TextView paramTextView)
  {
    if (a(paramString))
    {
      paramTextView.setText(b(paramString));
      return;
    }
    paramTextView.setText(paramString);
  }
  
  private static boolean a(String paramString)
  {
    return paramString.equals("我的好友");
  }
  
  private static int b(String paramString)
  {
    if (paramString.equals("我的好友")) {
      return 2131559856;
    }
    return 2131559857;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.equals("我的好友")) {
      str = paramContext.getString(2131559856);
    }
    return str;
  }
  
  public static final String c(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.equals("当前网络连接不稳定"));
    return paramContext.getString(2131560260);
  }
  
  public static final String d(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.equals("下线通知")) {
        break;
      }
      str = paramString;
    } while (!paramString.equals("Offline notifications"));
    return paramContext.getString(2131562534);
  }
  
  public static final String e(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.contains("Your account is logged in on")) {
        break;
      }
      str = paramString;
    } while (!paramString.contains("你的帐号于"));
    return paramContext.getString(2131561495);
  }
  
  public static String f(Context paramContext, String paramString)
  {
    String str;
    if ((paramContext == null) || (paramString == null)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.contains("该手机号码已经与其他QQ号码绑定，并且尚未设置密码，无法使用该手机号码继续注册"));
    return paramContext.getString(2131559107);
  }
  
  public static String g(Context paramContext, String paramString)
  {
    String str;
    if ((paramContext == null) || (paramString == null)) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.contains("评论")) {
        return paramContext.getString(2131559905);
      }
      if (paramString.contains("提到我")) {
        return paramContext.getString(2131559906);
      }
      if (paramString.contains("回复")) {
        return paramContext.getString(2131559907);
      }
      if (paramString.contains("赞了照片")) {
        return paramContext.getString(2131559908);
      }
      str = paramString;
    } while (!paramString.contains("赞了相册"));
    return paramContext.getString(2131559909);
  }
  
  public static String h(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Integer localInteger;
    do
    {
      return paramString;
      if (paramString.contains("查看相册")) {
        return a(paramContext, paramString, "查看相册《(.*)》", 2131559834);
      }
      if (paramString.contains("查看日志")) {
        return a(paramContext, paramString, "查看日志《(.*)》", 2131559835);
      }
      if (paramString.contains("查看说说")) {
        return a(paramContext, paramString, "查看说说《(.*)》", 2131559838);
      }
      if (paramString.contains("听了语音")) {
        return a(paramContext, paramString, "听了语音《(.*)》", 2131559841);
      }
      if (paramString.contains("看了视频")) {
        return a(paramContext, paramString, "看了视频《(.*)》", 2131559840);
      }
      if (paramString.contains("收听音乐")) {
        return a(paramContext, paramString, "收听音乐《(.*)》", 2131559836);
      }
      localInteger = (Integer)ServerPushStringMap.getInstance().get(paramString);
    } while (localInteger == null);
    return paramContext.getString(localInteger.intValue());
  }
  
  public static String i(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    Integer localInteger;
    do
    {
      return paramString;
      localInteger = (Integer)ServerPushStringMap.getInstance().get(paramString);
    } while (localInteger == null);
    return paramContext.getString(localInteger.intValue());
  }
  
  public static String j(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    Integer localInteger;
    do
    {
      return paramString;
      localInteger = (Integer)ServerPushStringMap.getInstance().get(paramString);
    } while (localInteger == null);
    return paramContext.getString(localInteger.intValue());
  }
  
  public static String k(Context paramContext, String paramString)
  {
    String str;
    if (paramString.endsWith("建议通过电话等方式核实好友身份")) {
      str = paramContext.getString(2131558670);
    }
    Matcher localMatcher;
    do
    {
      do
      {
        do
        {
          return str;
          if (paramString.equals("发表了说说")) {
            return paramContext.getString(2131558671);
          }
          if (paramString.contains("安全提醒：")) {
            return paramContext.getString(2131558672);
          }
          str = paramString;
        } while (!paramString.contains("与讨论组其他成员都不是QQ好友关系，请注意隐私安全"));
        localMatcher = Pattern.compile("(.*)与讨论组其他成员都不是QQ好友关系，请注意隐私安全").matcher(paramString);
        str = paramString;
      } while (!localMatcher.find());
      str = paramString;
    } while (localMatcher.groupCount() != 1);
    return paramContext.getString(2131559952, new Object[] { localMatcher.group(1) });
  }
  
  public static String l(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Integer localInteger;
    do
    {
      return paramString;
      localInteger = (Integer)a.get(paramString);
    } while (localInteger == null);
    return paramContext.getString(localInteger.intValue());
  }
  
  public static String m(Context paramContext, String paramString)
  {
    String str;
    if (paramString.contains("米")) {
      str = paramString.replace("米", paramContext.getString(2131562335));
    }
    do
    {
      return str;
      if (paramString.contains("小时")) {
        return paramString.replace("小时", paramContext.getString(2131562222));
      }
      if (paramString.contains("分钟")) {
        return paramString.replace("分钟", paramContext.getString(2131562378));
      }
      str = paramString;
    } while (!paramString.contains("秒"));
    return paramString.replace("秒", paramContext.getString(2131562796));
  }
  
  public static String n(Context paramContext, String paramString)
  {
    String str;
    if (paramString.contains("该讨论组已升级成QQ群")) {
      str = paramString.replace("该讨论组已升级成QQ群", paramContext.getString(2131559926));
    }
    do
    {
      return str;
      if (paramString.contains("群号：")) {
        return paramString.replace("群号：", paramContext.getString(2131562197));
      }
      str = paramString;
    } while (!paramString.contains("群名称："));
    return paramString.replace("群名称：", paramContext.getString(2131559927));
  }
  
  public static String o(Context paramContext, String paramString)
  {
    String str;
    if (paramString.contains("查询余额")) {
      str = paramString.replace("查询余额", paramContext.getString(2131559930));
    }
    do
    {
      return str;
      if (paramString.contains("话费充值")) {
        return paramString.replace("话费充值", paramContext.getString(2131559931));
      }
      if (paramString.contains("更多")) {
        return paramString.replace("更多", paramContext.getString(2131559932));
      }
      if (paramString.contains("通话详单")) {
        return paramString.replace("通话详单", paramContext.getString(2131559933));
      }
      if (paramString.contains("通话费率")) {
        return paramString.replace("通话费率", paramContext.getString(2131559934));
      }
      if (paramString.contains("使用帮助")) {
        return paramString.replace("使用帮助", paramContext.getString(2131559935));
      }
      str = paramString;
    } while (!paramString.contains("提醒自己"));
    return paramString.replace("提醒自己", paramContext.getString(2131559953));
  }
  
  public static String p(Context paramContext, String paramString)
  {
    String str;
    if ((paramContext == null) || (paramString == null)) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.equals("对不起，您输入的手机号错误。")) {
        return paramContext.getString(2131563318);
      }
      if (paramString.equals("最大操作次数限制。")) {
        return paramContext.getString(2131563319);
      }
      str = paramString;
    } while (!paramString.equals("您操作太过频繁，请稍后重试。"));
    return paramContext.getString(2131563320);
  }
  
  public static String q(Context paramContext, String paramString)
  {
    String str;
    if ((paramContext == null) || (paramString == null)) {
      str = null;
    }
    do
    {
      return str;
      int i = paramString.indexOf("被管理员禁言10分钟");
      if (i > 0)
      {
        paramString = paramString.substring(0, i);
        return String.format(paramContext.getString(2131559911), new Object[] { paramString });
      }
      i = paramString.indexOf("被管理员禁言1小时");
      if (i > 0)
      {
        paramString = paramString.substring(0, i);
        return String.format(paramContext.getString(2131559912), new Object[] { paramString });
      }
      i = paramString.indexOf("被管理员禁言12小时");
      if (i > 0)
      {
        paramString = paramString.substring(0, i);
        return String.format(paramContext.getString(2131559913), new Object[] { paramString });
      }
      i = paramString.indexOf("被管理员禁言1天");
      if (i > 0)
      {
        paramString = paramString.substring(0, i);
        return String.format(paramContext.getString(2131559914), new Object[] { paramString });
      }
      i = paramString.indexOf("被管理员解除禁言");
      if (i > 0)
      {
        paramString = paramString.substring(0, i);
        return String.format(paramContext.getString(2131559915), new Object[] { paramString });
      }
      if (paramString.equals("管理员开启了全员禁言，只有群主和管理员才能发言")) {
        return paramContext.getString(2131559916);
      }
      str = paramString;
    } while (!paramString.equals("管理员关闭了全员禁言"));
    return paramContext.getString(2131559917);
  }
  
  public static String r(Context paramContext, String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    for (;;)
    {
      return str;
      if (paramString.contains("最新日志")) {
        return paramString.replace("最新日志", paramContext.getString(2131561384));
      }
      if (paramString.contains("更新了说说")) {
        return paramString.replace("更新了说说", paramContext.getString(2131561386));
      }
      if (paramString.contains("更新了日志")) {
        return paramString.replace("更新了日志", paramContext.getString(2131561385));
      }
      if (paramString.contains("更新了分享")) {
        return paramString.replace("更新了分享", paramContext.getString(2131561387));
      }
      if ((paramString.contains("upload")) && (paramString.contains("pictures to")))
      {
        Object localObject = Pattern.compile("upload ([0-9]+) pictures to (.*)").matcher(paramString);
        str = paramString;
        if (!((Matcher)localObject).find()) {
          continue;
        }
        str = paramString;
        if (((Matcher)localObject).groupCount() != 2) {
          continue;
        }
        str = ((Matcher)localObject).group(1);
        try
        {
          i = Integer.parseInt(str);
          localObject = ((Matcher)localObject).group(2);
          str = paramString;
          if (localObject != null) {
            return paramContext.getString(2131559936, new Object[] { Integer.valueOf(i), localObject });
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i = 0;
          }
        }
      }
    }
    return t(paramContext, paramString);
  }
  
  public static String s(Context paramContext, String paramString)
  {
    String str;
    if ((paramContext == null) || (paramString == null)) {
      str = null;
    }
    do
    {
      Object localObject1;
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
                  Object localObject2;
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return str;
                          if (paramString.equals("来自群相册")) {
                            return paramContext.getString(2131563335);
                          }
                          if (paramString.equals("来自群相册 的分享")) {
                            return paramContext.getString(2131563336);
                          }
                          if (paramString.equals("群相册")) {
                            return paramContext.getString(2131559581);
                          }
                          if (paramString.equals("评论了照片")) {
                            return paramContext.getString(2131563340);
                          }
                          if ((!paramString.contains("新增")) || (!paramString.contains("张"))) {
                            break;
                          }
                          localObject2 = Pattern.compile("《(.*)》新增(\\d)张").matcher(paramString);
                          str = paramString;
                        } while (!((Matcher)localObject2).find());
                        str = paramString;
                      } while (((Matcher)localObject2).groupCount() != 2);
                      str = ((Matcher)localObject2).group(1);
                      localObject1 = str;
                      if (str != null)
                      {
                        localObject1 = str;
                        if (str.equals("群相册")) {
                          localObject1 = paramContext.getString(2131561120);
                        }
                      }
                      localObject2 = ((Matcher)localObject2).group(2);
                      str = paramString;
                    } while (localObject1 == null);
                    str = paramString;
                  } while (localObject2 == null);
                  return String.format(paramContext.getString(2131563337), new Object[] { localObject1, localObject2 });
                  if ((!paramString.contains("评论")) || (!paramString.contains("的照片"))) {
                    break;
                  }
                  localObject1 = Pattern.compile("评论(.*)的照片").matcher(paramString);
                  str = paramString;
                } while (!((Matcher)localObject1).find());
                str = paramString;
              } while (((Matcher)localObject1).groupCount() != 1);
              localObject1 = ((Matcher)localObject1).group(1);
              str = paramString;
            } while (localObject1 == null);
            return String.format(paramContext.getString(2131563339), new Object[] { localObject1 });
            if (!paramString.contains("新建群相册")) {
              break;
            }
            localObject1 = Pattern.compile("新建群相册《(.*)》").matcher(paramString);
            str = paramString;
          } while (!((Matcher)localObject1).find());
          str = paramString;
        } while (((Matcher)localObject1).groupCount() != 1);
        localObject1 = ((Matcher)localObject1).group(1);
        str = paramString;
      } while (localObject1 == null);
      return String.format(paramContext.getString(2131563338), new Object[] { localObject1 });
      if (paramString.equals("邀请加群")) {
        return paramContext.getString(2131563404);
      }
      str = paramString;
    } while (!paramString.startsWith("[公告]"));
    return paramString.replaceFirst("\\[公告]", paramContext.getString(2131563405));
  }
  
  public static String t(Context paramContext, String paramString)
  {
    Object localObject = Pattern.compile("上传([0-9]+)张照片到《(.*)》");
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (localObject != null)
      {
        localObject = ((Pattern)localObject).matcher(paramString);
        str = paramString;
        if (((Matcher)localObject).find())
        {
          str = paramString;
          if (((Matcher)localObject).groupCount() == 2) {
            str = ((Matcher)localObject).group(1);
          }
        }
      }
    }
    try
    {
      i = Integer.parseInt(str);
      localObject = ((Matcher)localObject).group(2);
      str = paramString;
      if (localObject != null) {
        str = paramContext.getString(2131559936, new Object[] { Integer.valueOf(i), localObject });
      }
      return str;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static String u(Context paramContext, String paramString)
  {
    Matcher localMatcher = Pattern.compile("(.*) 的分享").matcher(paramString);
    String str = paramString;
    if (localMatcher.find())
    {
      str = paramString;
      if (localMatcher.groupCount() == 1)
      {
        paramString = paramContext.getString(2131563341, new Object[] { localMatcher.group(1) });
        str = paramString;
        if (paramString.contains("QQ空间")) {
          str = paramString.replace("QQ空间", paramContext.getString(2131562710));
        }
      }
    }
    return str;
  }
  
  public static String v(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.contains("【链接】")) {
      str = paramString.replace("【链接】", paramContext.getString(2131559950));
    }
    return u(paramContext, str);
  }
  
  public static String w(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.contains("推荐群：")) {
      str = paramString.replace("推荐群：", paramContext.getString(2131559951));
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.LocaleString
 * JD-Core Version:    0.7.0.1
 */