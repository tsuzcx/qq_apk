import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uph
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private static ArrayList<upm> a(upk paramupk, upg paramupg)
  {
    if (TextUtils.isEmpty(paramupk)) {
      return null;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramupk);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        upm localupm = a(str1, ",nick:");
        String str2 = localupm.a;
        String str3 = " @" + localupm.b + " ";
        paramupk.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramupk.setSpan(new upi(paramupg, str2), j, k, 33);
        paramupk.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localupm);
      }
      return localArrayList;
    }
    catch (Exception paramupg)
    {
      paramupg.printStackTrace();
      paramupk.a(localArrayList);
    }
  }
  
  public static upk a(CharSequence paramCharSequence, int paramInt, upg paramupg, Drawable.Callback paramCallback)
  {
    upk localupk = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localupk = new upk(paramCharSequence);
      a(localupk, paramupg);
      b(localupk, paramupg);
      a(localupk, paramInt, paramCallback);
    }
    return localupk;
  }
  
  private static upl a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new upl("", "");
    }
    String str = paramString1.substring(j + k, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
    return new upl(str, paramString1);
  }
  
  private static upm a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new upm("", "");
    }
    String str = paramString1.substring(j + k, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
    return new upm(str, paramString1);
  }
  
  private static void a(upk paramupk, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramupk == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramupk);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramupk.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label288;
      }
    }
    label288:
    for (Object localObject = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null) {
        paramCallback = bnqj.a(str);
      }
      localObject = paramCallback;
      int k;
      if (paramCallback == null)
      {
        k = aakd.a(str);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < aakd.b.length) {
            localObject = aajt.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null)
      {
        k = aakd.b(str);
        uqf.b("emotion", "emotion code:" + str + ",index:" + k);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < aakd.c.length) {
            paramCallback = aajt.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramCallback == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramCallback);
      paramCallback.setBounds(new Rect(0, 0, paramInt, paramInt));
      paramupk.setSpan(new VerticalCenterImageSpan(paramCallback, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<upl> b(upk paramupk, upg paramupg)
  {
    if (TextUtils.isEmpty(paramupk)) {
      return null;
    }
    Matcher localMatcher = b.matcher(paramupk);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        upl localupl = a(str1, ",name:");
        String str2 = localupl.a;
        String str3 = " #" + localupl.b + " ";
        paramupk.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramupk.setSpan(new upj(paramupg, str2), j, k, 33);
        paramupk.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localupl);
      }
      return localArrayList;
    }
    catch (Exception paramupg)
    {
      paramupg.printStackTrace();
      paramupk.b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */