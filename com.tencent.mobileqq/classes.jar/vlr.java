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

public class vlr
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private static ArrayList<vlw> a(vlu paramvlu, vlq paramvlq)
  {
    if (TextUtils.isEmpty(paramvlu)) {
      return null;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramvlu);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        vlw localvlw = a(str1, ",nick:");
        String str2 = localvlw.a;
        String str3 = " @" + localvlw.b + " ";
        paramvlu.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramvlu.setSpan(new vls(paramvlq, str2), j, k, 33);
        paramvlu.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localvlw);
      }
      return localArrayList;
    }
    catch (Exception paramvlq)
    {
      paramvlq.printStackTrace();
      paramvlu.a(localArrayList);
    }
  }
  
  public static vlu a(CharSequence paramCharSequence, int paramInt, vlq paramvlq, Drawable.Callback paramCallback)
  {
    vlu localvlu = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localvlu = new vlu(paramCharSequence);
      a(localvlu, paramvlq);
      b(localvlu, paramvlq);
      a(localvlu, paramInt, paramCallback);
    }
    return localvlu;
  }
  
  private static vlv a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new vlv("", "");
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
    return new vlv(str, paramString1);
  }
  
  private static vlw a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new vlw("", "");
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
    return new vlw(str, paramString1);
  }
  
  private static void a(vlu paramvlu, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramvlu == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramvlu);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramvlu.subSequence(i, j).toString();
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
        k = zwg.a(str);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < zwg.b.length) {
            localObject = zvw.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null)
      {
        k = zwg.b(str);
        vmp.b("emotion", "emotion code:" + str + ",index:" + k);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < zwg.c.length) {
            paramCallback = zvw.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramCallback == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramCallback);
      paramCallback.setBounds(new Rect(0, 0, paramInt, paramInt));
      paramvlu.setSpan(new VerticalCenterImageSpan(paramCallback, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<vlv> b(vlu paramvlu, vlq paramvlq)
  {
    if (TextUtils.isEmpty(paramvlu)) {
      return null;
    }
    Matcher localMatcher = b.matcher(paramvlu);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        vlv localvlv = a(str1, ",name:");
        String str2 = localvlv.a;
        String str3 = " #" + localvlv.b + " ";
        paramvlu.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramvlu.setSpan(new vlt(paramvlq, str2), j, k, 33);
        paramvlu.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localvlv);
      }
      return localArrayList;
    }
    catch (Exception paramvlq)
    {
      paramvlq.printStackTrace();
      paramvlu.b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */