import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aqfs
{
  public static void A(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_option_" + paramString;
    paramContext.edit().putInt(paramString, paramInt).commit();
  }
  
  public static String I(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals(paramString3)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    return paramString1.replace("\"" + paramString2 + "\"", localStringBuilder.toString());
  }
  
  public static String J(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_name_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static String K(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_question_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static void K(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString1 = "troop_name_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static String L(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_answer_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static void L(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString1 = "troop_question_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static void M(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString1 = "troop_answer_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  private static List<String> be(String paramString)
  {
    Object localObject = Pattern.compile("\"\\d+\"", 2);
    Pattern localPattern = Pattern.compile("\\d+", 2);
    ArrayList localArrayList = new ArrayList();
    paramString = ((Pattern)localObject).matcher(paramString);
    while (paramString.find())
    {
      localObject = localPattern.matcher(paramString.group());
      while (((Matcher)localObject).find()) {
        localArrayList.add(((Matcher)localObject).group());
      }
    }
    return localArrayList;
  }
  
  public static String cu(String paramString)
  {
    Object localObject = null;
    Matcher localMatcher = Pattern.compile("\\d+", 2).matcher(paramString);
    for (paramString = localObject; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static long f(Context paramContext, String paramString)
  {
    long l = 0L;
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_flagEx_" + paramString;
    if (paramContext.contains(paramString)) {
      l = paramContext.getLong(paramString, 0L);
    }
    return l;
  }
  
  public static String f(String paramString, QQAppInterface paramQQAppInterface)
  {
    List localList = be(paramString);
    String str2;
    if (localList.size() > 0)
    {
      int i = 0;
      String str1 = paramString;
      str2 = str1;
      if (i < localList.size())
      {
        String str3 = (String)localList.get(i);
        str2 = "\"" + str3 + "\"";
        int j = paramString.indexOf(str2);
        if (str2.length() + j == paramString.length()) {}
        for (str2 = aqgv.a(paramQQAppInterface, str3, true);; str2 = aqgv.b(paramQQAppInterface, str3, true))
        {
          str1 = I(str1, str3, str2);
          i += 1;
          break;
        }
      }
    }
    else
    {
      str2 = paramString;
    }
    return str2;
  }
  
  public static void l(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(acbn.bkD), 0);
    paramString = "troop_flagEx_" + paramString;
    paramContext.edit().putLong(paramString, paramLong).commit();
  }
  
  public static String pj(String paramString)
  {
    Object localObject = null;
    Matcher localMatcher = Pattern.compile("\"\\d+\"", 2).matcher(paramString);
    paramString = localObject;
    if (localMatcher.find()) {
      paramString = localMatcher.group();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfs
 * JD-Core Version:    0.7.0.1
 */