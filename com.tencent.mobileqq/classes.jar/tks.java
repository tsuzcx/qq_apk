import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.SpannableStringBuilder;
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

public class tks
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private static ArrayList<tkx> a(SpannableStringBuilder paramSpannableStringBuilder, tkr paramtkr)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      localObject = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject;
      Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramSpannableStringBuilder);
      int i = 0;
      localArrayList = new ArrayList();
      localObject = localArrayList;
      try
      {
        if (localMatcher.find())
        {
          int j = localMatcher.start() - i;
          int k = localMatcher.end();
          localObject = localMatcher.group();
          tkx localtkx = a((String)localObject, ",nick:");
          String str1 = localtkx.a;
          String str2 = " @" + localtkx.b + " ";
          paramSpannableStringBuilder.replace(j, k - i, str2);
          i += ((String)localObject).length() - str2.length();
          k = str2.length() + j;
          paramSpannableStringBuilder.setSpan(new tkt(paramtkr, str1), j, k, 33);
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, k, 33);
          localArrayList.add(localtkx);
        }
      }
      catch (Exception paramSpannableStringBuilder)
      {
        paramSpannableStringBuilder.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static tkv a(CharSequence paramCharSequence, int paramInt, tkr paramtkr, Drawable.Callback paramCallback)
  {
    tkv localtkv = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localtkv = new tkv(paramCharSequence);
      a(localtkv, paramtkr);
      b(localtkv, paramtkr);
      a(localtkv, paramInt, paramCallback);
    }
    return localtkv;
  }
  
  private static tkw a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new tkw("", "");
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
    return new tkw(str, paramString1);
  }
  
  private static tkx a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new tkx("", "");
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
    return new tkx(str, paramString1);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramSpannableStringBuilder);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramSpannableStringBuilder.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label278;
      }
    }
    label278:
    for (Object localObject = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      int k;
      if (localObject == null)
      {
        k = yhp.a(str);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < yhp.b.length) {
            paramCallback = yhf.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      localObject = paramCallback;
      if (paramCallback == null)
      {
        k = yhp.c(str);
        tlo.b("emotion", "emotion code:" + str + ",index:" + k);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < yhp.c.length) {
            localObject = yhf.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (localObject == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      ((Drawable)localObject).setBounds(new Rect(0, 0, paramInt, paramInt));
      paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan((Drawable)localObject, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<tkw> b(SpannableStringBuilder paramSpannableStringBuilder, tkr paramtkr)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      localObject = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject;
      Matcher localMatcher = b.matcher(paramSpannableStringBuilder);
      int i = 0;
      localArrayList = new ArrayList();
      localObject = localArrayList;
      try
      {
        if (localMatcher.find())
        {
          int j = localMatcher.start() - i;
          int k = localMatcher.end();
          localObject = localMatcher.group();
          tkw localtkw = a((String)localObject, ",name:");
          String str1 = localtkw.a;
          String str2 = " #" + localtkw.b + " ";
          paramSpannableStringBuilder.replace(j, k - i, str2);
          i += ((String)localObject).length() - str2.length();
          k = str2.length() + j;
          paramSpannableStringBuilder.setSpan(new tku(paramtkr, str1), j, k, 33);
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, k, 33);
          localArrayList.add(localtkw);
        }
      }
      catch (Exception paramSpannableStringBuilder)
      {
        paramSpannableStringBuilder.printStackTrace();
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tks
 * JD-Core Version:    0.7.0.1
 */