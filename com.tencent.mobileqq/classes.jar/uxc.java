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
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uxc
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private static ArrayList<uxh> a(uxf paramuxf, uxb paramuxb)
  {
    if (TextUtils.isEmpty(paramuxf)) {
      return null;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramuxf);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        uxh localuxh = a(str1, ",nick:");
        String str2 = localuxh.a;
        String str3 = " @" + localuxh.b + " ";
        paramuxf.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramuxf.setSpan(new uxd(paramuxb, str2), j, k, 33);
        paramuxf.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localuxh);
      }
      return localArrayList;
    }
    catch (Exception paramuxb)
    {
      paramuxb.printStackTrace();
      paramuxf.a(localArrayList);
    }
  }
  
  public static uxf a(CharSequence paramCharSequence, int paramInt, uxb paramuxb, Drawable.Callback paramCallback)
  {
    uxf localuxf = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localuxf = new uxf(paramCharSequence);
      a(localuxf, paramuxb);
      b(localuxf, paramuxb);
      a(localuxf, paramInt, paramCallback);
    }
    return localuxf;
  }
  
  private static uxg a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new uxg("", "");
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
    return new uxg(str, paramString1);
  }
  
  private static uxh a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new uxh("", "");
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
    return new uxh(str, paramString1);
  }
  
  private static void a(uxf paramuxf, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramuxf == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramuxf);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramuxf.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label288;
      }
    }
    label288:
    for (Object localObject = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null) {
        paramCallback = QzoneEmotionUtils.getDrawable(str);
      }
      localObject = paramCallback;
      int k;
      if (paramCallback == null)
      {
        k = zhb.a(str);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < zhb.b.length) {
            localObject = zgr.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null)
      {
        k = zhb.b(str);
        uya.b("emotion", "emotion code:" + str + ",index:" + k);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < zhb.c.length) {
            paramCallback = zgr.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramCallback == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramCallback);
      paramCallback.setBounds(new Rect(0, 0, paramInt, paramInt));
      paramuxf.setSpan(new VerticalCenterImageSpan(paramCallback, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<uxg> b(uxf paramuxf, uxb paramuxb)
  {
    if (TextUtils.isEmpty(paramuxf)) {
      return null;
    }
    Matcher localMatcher = b.matcher(paramuxf);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        uxg localuxg = a(str1, ",name:");
        String str2 = localuxg.a;
        String str3 = " #" + localuxg.b + " ";
        paramuxf.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramuxf.setSpan(new uxe(paramuxb, str2), j, k, 33);
        paramuxf.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localuxg);
      }
      return localArrayList;
    }
    catch (Exception paramuxb)
    {
      paramuxb.printStackTrace();
      paramuxf.b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */