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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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

public class yln
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
  
  private static VerticalCenterImageSpan a(ylp paramylp, Drawable paramDrawable)
  {
    int i = (int)paramylp.jdField_a_of_type_Float;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramylp.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, ylo paramylo, int paramInt, ylg paramylg)
  {
    paramContext = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramylo)) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      Matcher localMatcher = ydg.c.matcher(paramylo);
      int i = 0;
      localObject1 = paramContext;
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          paramylo.a = true;
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
          paramylo.replace(j, k - i, str2);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - str2.length();
          localObject2 = paramContext;
          k = str2.length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            paramylo.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          paramylo.setSpan(new ylf(str1, paramInt, paramylg), j, k, 33);
          localObject2 = paramContext;
          paramylo.setSpan(new StyleSpan(1), j, k, 33);
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
  
  private static HashMap<String, ImageSpan> a(ylp paramylp)
  {
    int i = 0;
    paramylp = paramylp.jdField_a_of_type_JavaLangCharSequence;
    if ((paramylp != null) && ((paramylp instanceof Spannable)))
    {
      paramylp = (Spannable)paramylp;
      paramylp = (ImageSpan[])paramylp.getSpans(0, paramylp.length(), ImageSpan.class);
      if (paramylp != null)
      {
        HashMap localHashMap = new HashMap();
        int j = paramylp.length;
        while (i < j)
        {
          Object localObject = paramylp[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static ylo a(ylp paramylp, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, ylg paramylg, yle paramyle, ylc paramylc, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramyle = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramyle = "";
      }
      paramCharSequence = new ylo(paramyle);
      if (paramBoolean1) {
        a(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, paramylg);
        a(paramContext, paramCharSequence, paramInt1, paramylg);
      }
      a(paramylp, paramyle, a(paramylp), paramCharSequence);
      return paramCharSequence;
    }
    catch (Exception paramylp)
    {
      QLog.e("RichTextParser", 2, paramylp.getStackTrace());
    }
    return new ylo("");
  }
  
  private static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return;
    }
    Matcher localMatcher = ydg.i.matcher(paramSpannableStringBuilder);
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
  
  public static void a(Context paramContext, ylo paramylo, ColorStateList paramColorStateList, ylg paramylg)
  {
    if ((TextUtils.isEmpty(paramylo)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = ydg.a.matcher(paramylo);
      int i = 0;
      while (localMatcher.find())
      {
        paramylo.a = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        paramylo.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          paramylo.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), paramColorStateList, null), j, n, 33);
        }
        paramylo.setSpan(new ylf(str2, paramColorStateList, paramylg), j, n, 33);
        i += k - m;
      }
    }
  }
  
  public static void a(ylp paramylp, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, ylo paramylo)
  {
    if (paramylo == null) {}
    Matcher localMatcher;
    label14:
    do
    {
      return;
      localMatcher = ydg.g.matcher(paramylo);
    } while (!localMatcher.find());
    paramylo.c = true;
    int i = localMatcher.start();
    int j = localMatcher.end();
    String str = paramylo.subSequence(i, j).toString();
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {}
    for (paramCharSequence = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; paramCharSequence = null) {
      for (;;)
      {
        paramHashMap = paramCharSequence;
        if (paramCharSequence == null)
        {
          int k = ydg.b(str);
          paramHashMap = paramCharSequence;
          if (k > -1)
          {
            paramHashMap = paramCharSequence;
            if (k < bjwo.c.length) {
              paramHashMap = ycw.c(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
            }
          }
          if (k == -1)
          {
            k = str.indexOf("[em]") + "[em]".length();
            int m = str.indexOf("[/em]");
            if ((k == -1) || (m == -1)) {
              break;
            }
            paramHashMap = str.substring(k, m);
          }
        }
        try
        {
          paramCharSequence = bjwp.f(paramHashMap);
          paramHashMap = URLDrawable.URLDrawableOptions.obtain();
          paramHashMap.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130847698);
          paramHashMap = URLDrawable.getDrawable(paramCharSequence, paramHashMap);
          if (paramHashMap == null) {
            break label14;
          }
          jdField_a_of_type_JavaUtilHashMap.put(str, paramHashMap);
          paramCharSequence = a(paramylp, paramHashMap);
          if (paramCharSequence == null) {
            break label14;
          }
          paramylo.setSpan(paramCharSequence, i, j, 33);
        }
        catch (Exception paramCharSequence)
        {
          for (;;)
          {
            paramCharSequence = "http://qzonestyle.gtimg.cn/qzone/em/" + paramHashMap + ".gif";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yln
 * JD-Core Version:    0.7.0.1
 */