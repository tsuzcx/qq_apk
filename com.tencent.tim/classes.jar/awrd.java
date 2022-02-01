import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class awrd
{
  @SuppressLint({"InlinedApi"})
  public static final int eCs;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      eCs = i;
      return;
    }
  }
  
  public static String a(Iterator<String> paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (paramIterator.hasNext())
    {
      String str = (String)paramIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        if (i == 0) {
          localStringBuffer.append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append(":").append(str);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static void au(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", eCs).edit().remove(wrapKey(paramString1, paramString2)).commit();
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", eCs).getString(wrapKey(paramString1, paramString2), null);
    if (paramContext == null) {
      return paramBoolean;
    }
    return Boolean.valueOf(paramContext).booleanValue();
  }
  
  public static List<String> h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length <= 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(paramString.length);
    Collections.addAll(localArrayList, paramString);
    return localArrayList;
  }
  
  public static String u(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", eCs).getString(wrapKey(paramString1, paramString2), null);
  }
  
  private static String wrapKey(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static void z(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", eCs).edit().putString(wrapKey(paramString1, paramString2), paramString3).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrd
 * JD-Core Version:    0.7.0.1
 */