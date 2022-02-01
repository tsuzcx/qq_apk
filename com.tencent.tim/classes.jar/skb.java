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
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class skb
{
  public static final Pattern O = Pattern.compile("\\{img:(.*),w:(\\d+),h:(\\d+)\\}");
  private static Map<String, Integer> gu = new RichTextParser.1();
  private static HashMap<String, Drawable> mMap = new HashMap();
  
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
  
  private static VerticalCenterImageSpan a(skb.b paramb, Drawable paramDrawable)
  {
    int i = (int)paramb.oj;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramb.verticalAlignment);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, skb.a parama, int paramInt, sju.a parama1)
  {
    paramContext = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(parama)) {}
    Object localObject2;
    for (;;)
    {
      return localObject1;
      Matcher localMatcher = sdy.q.matcher(parama);
      int i = 0;
      localObject1 = paramContext;
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          parama.aLP = true;
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
          parama.replace(j, k - i, str2);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - str2.length();
          localObject2 = paramContext;
          k = str2.length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            parama.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          parama.setSpan(new sju(str1, paramInt, parama1), j, k, 33);
          localObject2 = paramContext;
          parama.setSpan(new StyleSpan(1), j, k, 33);
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
  
  private static HashMap<String, ImageSpan> a(skb.b paramb)
  {
    int i = 0;
    paramb = paramb.D;
    if ((paramb != null) && ((paramb instanceof Spannable)))
    {
      paramb = (Spannable)paramb;
      paramb = (ImageSpan[])paramb.getSpans(0, paramb.length(), ImageSpan.class);
      if (paramb != null)
      {
        HashMap localHashMap = new HashMap();
        int j = paramb.length;
        while (i < j)
        {
          Object localObject = paramb[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static skb.a a(skb.b paramb, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, sju.a parama, sjt.a parama1, sjs.a parama2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama1 = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        parama1 = "";
      }
      paramCharSequence = new skb.a(parama1);
      if (paramBoolean1) {
        b(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, parama);
        a(paramContext, paramCharSequence, paramInt1, parama);
      }
      a(paramb, parama1, a(paramb), paramCharSequence);
      a(paramb, parama1, a(paramb), paramCharSequence, paramURLDrawableListener);
      return paramCharSequence;
    }
    catch (Exception paramb)
    {
      QLog.e("RichTextParser", 2, paramb.getStackTrace());
    }
    return new skb.a("");
  }
  
  public static void a(Context paramContext, skb.a parama, ColorStateList paramColorStateList, sju.a parama1)
  {
    if ((TextUtils.isEmpty(parama)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = sdy.s.matcher(parama);
      int i = 0;
      while (localMatcher.find())
      {
        parama.aLP = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        parama.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          parama.setSpan(new TextAppearanceSpan(null, 1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().density), paramColorStateList, null), j, n, 33);
        }
        parama.setSpan(new sju(str2, paramColorStateList, parama1), j, n, 33);
        i += k - m;
      }
    }
  }
  
  public static void a(skb.b paramb, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, skb.a parama)
  {
    a(paramb, paramCharSequence, paramHashMap, parama, true);
  }
  
  private static void a(skb.b paramb, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, skb.a parama, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if (TextUtils.isEmpty(parama)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = O.matcher(parama);
      try
      {
        while (localMatcher.find())
        {
          String str2 = localMatcher.group(1);
          if (str2.startsWith("https://qzonestyle.gtimg.cn/"))
          {
            localMatcher.group(2);
            localMatcher.group(3);
            int i = localMatcher.start();
            int j = localMatcher.end();
            String str1 = parama.subSequence(i, j).toString();
            paramCharSequence = null;
            if (mMap.containsKey(str1)) {
              paramCharSequence = (Drawable)mMap.get(str1);
            }
            paramHashMap = paramCharSequence;
            if (paramCharSequence == null)
            {
              paramCharSequence = URLDrawable.URLDrawableOptions.obtain();
              paramCharSequence.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130849108);
              paramCharSequence = URLDrawable.getDrawable(str2, paramCharSequence);
              paramHashMap = paramCharSequence;
              if (paramCharSequence != null)
              {
                paramHashMap = paramCharSequence;
                if (paramURLDrawableListener != null)
                {
                  paramCharSequence.setURLDrawableListener(paramURLDrawableListener);
                  paramHashMap = paramCharSequence;
                }
              }
            }
            if (paramHashMap != null)
            {
              mMap.put(str1, paramHashMap);
              paramCharSequence = a(paramb, paramHashMap);
              if (paramCharSequence != null) {
                parama.setSpan(paramCharSequence, i, j, 33);
              }
            }
          }
        }
        return;
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
      }
    }
  }
  
  public static void a(skb.b paramb, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, skb.a parama, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    Matcher localMatcher = sdy.N.matcher(parama);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      parama.aLR = true;
      i = localMatcher.start();
      j = localMatcher.end();
      str = parama.subSequence(i, j).toString();
      paramCharSequence = null;
      paramHashMap = paramCharSequence;
      if (paramBoolean)
      {
        paramHashMap = paramCharSequence;
        if (mMap.containsKey(str)) {
          paramHashMap = (Drawable)mMap.get(str);
        }
      }
      paramCharSequence = paramHashMap;
      if (paramHashMap == null)
      {
        if (afky.cM(str) == -1) {
          break label157;
        }
        paramCharSequence = afky.z(afky.cM(str));
      }
    }
    for (;;)
    {
      if (paramCharSequence != null)
      {
        if (paramBoolean) {
          mMap.put(str, paramCharSequence);
        }
        paramCharSequence = a(paramb, paramCharSequence);
        if (paramCharSequence == null) {
          break label14;
        }
        parama.setSpan(paramCharSequence, i, j, 33);
        break label14;
        break;
        label157:
        if (afku.cM(str) == -1) {
          break label178;
        }
        paramCharSequence = afku.x(afku.cM(str));
        continue;
      }
      break label14;
      label178:
      int k = str.indexOf("[em]") + "[em]".length();
      int m = str.indexOf("[/em]");
      if ((k == -1) || (m == -1)) {
        break;
      }
      paramHashMap = str.substring(k, m);
      try
      {
        paramCharSequence = awif.sl(paramHashMap);
        paramHashMap = URLDrawable.URLDrawableOptions.obtain();
        paramHashMap.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130849108);
        paramCharSequence = URLDrawable.getDrawable(paramCharSequence, paramHashMap);
      }
      catch (Exception paramCharSequence)
      {
        for (;;)
        {
          paramCharSequence = "https://qzonestyle.gtimg.cn/qzone/em/" + paramHashMap + ".gif";
        }
      }
    }
  }
  
  private static void b(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {
      return;
    }
    Matcher localMatcher = sdy.C.matcher(paramSpannableStringBuilder);
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
        break label270;
      }
      localObject = str2.substring(i1 + n, i2);
      n = str2.indexOf(",color:");
      str1 = str2.substring("text:".length() + m, n);
      localObject = (Integer)gu.get(localObject);
      if (localObject == null) {
        break label264;
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
      label264:
      localObject = null;
      continue;
      label270:
      localObject = null;
    }
  }
  
  public static class a
    extends SpannableStringBuilder
  {
    public boolean aLP;
    public boolean aLQ;
    public boolean aLR;
    
    public a(CharSequence paramCharSequence)
    {
      super();
    }
  }
  
  public static class b
  {
    public CharSequence D;
    public float oj;
    public int verticalAlignment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */