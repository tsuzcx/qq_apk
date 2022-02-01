import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class awif
{
  public static final Pattern SMILEY_PATTERN = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final Pattern ap = Pattern.compile("\\[/美女\\]|\\[/钱\\]");
  private static Pattern aq = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
  private static Pattern ar = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
  private static boolean bInit;
  public static final String cQA;
  public static final String cQz = acfp.m(2131713069);
  private static Pattern pattern;
  
  static
  {
    cQA = acfp.m(2131713066);
  }
  
  public static String EmoCode2Text(String paramString)
  {
    Matcher localMatcher = SMILEY_PATTERN.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = sm(str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String ct(String paramString1, String paramString2)
  {
    Matcher localMatcher = SMILEY_PATTERN.matcher(paramString1);
    while (localMatcher.find()) {
      paramString1 = paramString1.replace(localMatcher.group(), paramString2);
    }
    return paramString1;
  }
  
  public static void eDF() {}
  
  public static Drawable getDrawable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (afky.cM(paramString) != -1) {
        return afky.z(afky.cM(paramString));
      }
    } while (afku.cM(paramString) == -1);
    return afku.x(afku.cM(paramString));
  }
  
  public static int gg(String paramString)
  {
    int i = 0;
    paramString = SMILEY_PATTERN.matcher(paramString);
    while (paramString.find()) {
      i += 1;
    }
    return i;
  }
  
  private static void init()
  {
    int i = 1;
    try
    {
      ArrayList localArrayList = afky.cV();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer("(" + afky.ea(((Integer)localArrayList.get(0)).intValue()) + ")");
        while (i < localArrayList.size())
        {
          localStringBuffer.append("|(" + afky.ea(((Integer)localArrayList.get(i)).intValue()) + ")");
          i += 1;
        }
        pattern = Pattern.compile(localStringBuffer.toString().replace("吃瓜", "chigua"));
      }
      bInit = true;
      return;
    }
    finally {}
  }
  
  public static String sg(String paramString)
  {
    Matcher localMatcher = ar.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = sm(str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString = paramString.replace(str1, "[" + str2.substring(1) + "]");
      }
    }
    return paramString;
  }
  
  public static String sh(String paramString)
  {
    if (!bInit) {
      init();
    }
    if ((pattern == null) || (paramString == null)) {
      return paramString;
    }
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Matcher localMatcher = aq.matcher(paramString);
    while (localMatcher.find())
    {
      if (localMatcher.start() >= i)
      {
        localStringBuilder.append(si(paramString.substring(i, localMatcher.start())));
        localStringBuilder.append(paramString.substring(localMatcher.start(), localMatcher.end()));
      }
      i = localMatcher.end();
    }
    localStringBuilder.append(si(paramString.substring(i, paramString.length())));
    return localStringBuilder.toString();
  }
  
  private static String si(String paramString)
  {
    Matcher localMatcher = pattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null)
      {
        String str2 = afky.kF(str1);
        if (str2 != null)
        {
          str1 = paramString.replace(str1, str2);
          if (str1 != null) {
            paramString = str1;
          }
        }
      }
    }
    return paramString;
  }
  
  public static String sj(String paramString)
  {
    Matcher localMatcher = ar.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = sk(str1);
      if (str2 != null) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String sk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (afky.cM(paramString) != -1) {
        return afky.eb(afky.cM(paramString));
      }
    } while (afku.cM(paramString) == -1);
    return afku.hi(afku.cM(paramString)) + "";
  }
  
  public static String sl(String paramString)
    throws Exception
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  public static String sm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (afky.cM(paramString) != -1) {
        return afky.ea(afky.cM(paramString));
      }
    } while (afku.cM(paramString) == -1);
    return afku.dZ(afku.cM(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awif
 * JD-Core Version:    0.7.0.1
 */