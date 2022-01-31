import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wwx
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new RichTextParser.1();
  
  public static CertifiedAccountMeta.StUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uin:");
    int k = "uin:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new CertifiedAccountMeta.StUser();
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
      label72:
      break label72;
    }
    paramString2 = new CertifiedAccountMeta.StUser();
    paramString2.nick.set(paramString1);
    paramString2.id.set(str);
    return paramString2;
  }
  
  private static VerticalCenterImageSpan a(wwz paramwwz, Drawable paramDrawable)
  {
    int i = (int)paramwwz.jdField_a_of_type_Float;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramwwz.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, wwy paramwwy, int paramInt, wwq paramwwq)
  {
    paramContext = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramwwy)) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      Matcher localMatcher = wou.c.matcher(paramwwy);
      int i = 0;
      localObject1 = paramContext;
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          paramwwy.a = true;
          localObject2 = paramContext;
          int j = localMatcher.start() - i;
          localObject2 = paramContext;
          int k = localMatcher.end();
          localObject2 = paramContext;
          localObject1 = localMatcher.group();
          localObject2 = paramContext;
          CertifiedAccountMeta.StUser localStUser = a((String)localObject1, ",nickname:");
          localObject2 = paramContext;
          String str1 = localStUser.id.get();
          localObject2 = paramContext;
          String str2 = "@" + localStUser.nick + " ";
          localObject2 = paramContext;
          paramwwy.replace(j, k - i, str2);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - str2.length();
          localObject2 = paramContext;
          k = str2.length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            paramwwy.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          paramwwy.setSpan(new wwp(str1, paramInt, paramwwq), j, k, 33);
          localObject2 = paramContext;
          paramwwy.setSpan(new StyleSpan(1), j, k, 33);
          localObject1 = paramContext;
          if (paramContext == null)
          {
            localObject2 = paramContext;
            localObject1 = new ArrayList();
          }
          localObject2 = localObject1;
          ((ArrayList)localObject1).add(localStUser);
          paramContext = (Context)localObject1;
        }
      }
      catch (Exception paramContext) {}
    }
    return localObject2;
  }
  
  private static HashMap<String, ImageSpan> a(wwz paramwwz)
  {
    int i = 0;
    paramwwz = paramwwz.jdField_a_of_type_JavaLangCharSequence;
    if ((paramwwz != null) && ((paramwwz instanceof Spannable)))
    {
      paramwwz = (Spannable)paramwwz;
      paramwwz = (ImageSpan[])paramwwz.getSpans(0, paramwwz.length(), ImageSpan.class);
      if (paramwwz != null)
      {
        HashMap localHashMap = new HashMap();
        int j = paramwwz.length;
        while (i < j)
        {
          Object localObject = paramwwz[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static wwy a(wwz paramwwz, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, wwq paramwwq, wwo paramwwo, wwm paramwwm, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramwwo = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramwwo = "";
      }
      paramCharSequence = new wwy(paramwwo);
      if (paramBoolean1) {
        a(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, paramwwq);
        a(paramContext, paramCharSequence, paramInt1, paramwwq);
      }
      a(paramwwz, paramwwo, a(paramwwz), paramCharSequence);
      return paramCharSequence;
    }
    catch (Exception paramwwz)
    {
      QLog.e("RichTextParser", 2, paramwwz.getStackTrace());
    }
    return new wwy("");
  }
  
  private static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return;
    }
    Matcher localMatcher = wou.i.matcher(paramSpannableStringBuilder);
    int i = 0;
    label23:
    int j;
    int k;
    String str2;
    int n;
    String str1;
    int m;
    Object localObject;
    if (localMatcher.find())
    {
      j = localMatcher.start() - i;
      k = localMatcher.end();
      str2 = localMatcher.group();
      n = str2.indexOf(",color:");
      int i1 = ",color:".length();
      int i2 = str2.indexOf(",useDefaultFont:");
      str1 = "";
      m = str2.indexOf("text:");
      if (m == -1) {
        break label264;
      }
      localObject = str2.substring(i1 + n, i2);
      n = str2.indexOf(",color:");
      str1 = str2.substring("text:".length() + m, n);
      localObject = (Integer)jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localObject == null) {
        break label258;
      }
      localObject = paramContext.getResources().getColorStateList(((Integer)localObject).intValue());
    }
    for (;;)
    {
      paramSpannableStringBuilder.replace(j, k - i, str1);
      k = str2.length();
      m = str1.length();
      n = str1.length();
      if (localObject != null) {
        paramSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), (ColorStateList)localObject, null), j, j + n, 33);
      }
      i += k - m;
      break label23;
      break;
      label258:
      localObject = null;
      continue;
      label264:
      localObject = null;
    }
  }
  
  public static void a(Context paramContext, wwy paramwwy, ColorStateList paramColorStateList, wwq paramwwq)
  {
    if ((TextUtils.isEmpty(paramwwy)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = wou.a.matcher(paramwwy);
      int i = 0;
      while (localMatcher.find())
      {
        paramwwy.a = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        paramwwy.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          paramwwy.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), paramColorStateList, null), j, n, 33);
        }
        paramwwy.setSpan(new wwp(str2, paramColorStateList, paramwwq), j, n, 33);
        i += k - m;
      }
    }
  }
  
  private static void a(wwz paramwwz, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, wwy paramwwy)
  {
    if (paramwwy == null) {
      return;
    }
    Matcher localMatcher = wou.g.matcher(paramwwy);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      paramwwy.c = true;
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramwwy.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label171;
      }
    }
    label171:
    for (paramCharSequence = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; paramCharSequence = null)
    {
      paramHashMap = paramCharSequence;
      if (paramCharSequence == null)
      {
        int k = wou.a(str);
        paramHashMap = paramCharSequence;
        if (k > -1)
        {
          paramHashMap = paramCharSequence;
          if (k < wou.b.length) {
            paramHashMap = wok.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramHashMap == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramHashMap);
      paramCharSequence = a(paramwwz, paramHashMap);
      if (paramCharSequence == null) {
        break label14;
      }
      paramwwy.setSpan(paramCharSequence, i, j, 33);
      break label14;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wwx
 * JD-Core Version:    0.7.0.1
 */