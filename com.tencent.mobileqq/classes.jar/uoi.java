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

public class uoi
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private static ArrayList<uon> a(uol paramuol, uoh paramuoh)
  {
    if (TextUtils.isEmpty(paramuol)) {
      return null;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramuol);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        uon localuon = a(str1, ",nick:");
        String str2 = localuon.a;
        String str3 = " @" + localuon.b + " ";
        paramuol.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramuol.setSpan(new uoj(paramuoh, str2), j, k, 33);
        paramuol.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localuon);
      }
      return localArrayList;
    }
    catch (Exception paramuoh)
    {
      paramuoh.printStackTrace();
      paramuol.a(localArrayList);
    }
  }
  
  public static uol a(CharSequence paramCharSequence, int paramInt, uoh paramuoh, Drawable.Callback paramCallback)
  {
    uol localuol = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localuol = new uol(paramCharSequence);
      a(localuol, paramuoh);
      b(localuol, paramuoh);
      a(localuol, paramInt, paramCallback);
    }
    return localuol;
  }
  
  private static uom a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new uom("", "");
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
    return new uom(str, paramString1);
  }
  
  private static uon a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new uon("", "");
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
    return new uon(str, paramString1);
  }
  
  private static void a(uol paramuol, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramuol == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramuol);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramuol.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label288;
      }
    }
    label288:
    for (Object localObject = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null) {
        paramCallback = bmpg.a(str);
      }
      localObject = paramCallback;
      int k;
      if (paramCallback == null)
      {
        k = aagc.a(str);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < aagc.b.length) {
            localObject = aafs.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null)
      {
        k = aagc.b(str);
        upe.b("emotion", "emotion code:" + str + ",index:" + k);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < aagc.c.length) {
            paramCallback = aafs.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramCallback == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramCallback);
      paramCallback.setBounds(new Rect(0, 0, paramInt, paramInt));
      paramuol.setSpan(new VerticalCenterImageSpan(paramCallback, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<uom> b(uol paramuol, uoh paramuoh)
  {
    if (TextUtils.isEmpty(paramuol)) {
      return null;
    }
    Matcher localMatcher = b.matcher(paramuol);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        uom localuom = a(str1, ",name:");
        String str2 = localuom.a;
        String str3 = " #" + localuom.b + " ";
        paramuol.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
        paramuol.setSpan(new uok(paramuoh, str2), j, k, 33);
        paramuol.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localuom);
      }
      return localArrayList;
    }
    catch (Exception paramuoh)
    {
      paramuoh.printStackTrace();
      paramuol.b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoi
 * JD-Core Version:    0.7.0.1
 */