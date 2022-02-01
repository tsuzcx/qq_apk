import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ooi
{
  private static final Pattern K = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern L = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern SMILEY_PATTERN = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  private static HashMap<String, Drawable> mMap = new HashMap();
  
  private static ArrayList<ooi.c> a(SpannableStringBuilder paramSpannableStringBuilder, FeedRichTextView.a parama)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      localObject = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject;
      Matcher localMatcher = K.matcher(paramSpannableStringBuilder);
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
          ooi.c localc = a((String)localObject, ",nick:");
          String str1 = localc.uid;
          String str2 = " @" + localc.nick + " ";
          paramSpannableStringBuilder.replace(j, k - i, str2);
          i += ((String)localObject).length() - str2.length();
          k = str2.length() + j;
          paramSpannableStringBuilder.setSpan(new ooj(parama, str1), j, k, 33);
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, k, 33);
          localArrayList.add(localc);
        }
      }
      catch (Exception paramSpannableStringBuilder)
      {
        paramSpannableStringBuilder.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static ooi.a a(CharSequence paramCharSequence, int paramInt, FeedRichTextView.a parama, Drawable.Callback paramCallback)
  {
    ooi.a locala = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      locala = new ooi.a(paramCharSequence);
      a(locala, parama);
      b(locala, parama);
      a(locala, paramInt, paramCallback);
    }
    return locala;
  }
  
  private static ooi.b a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new ooi.b("", "");
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
    return new ooi.b(str, paramString1);
  }
  
  private static ooi.c a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new ooi.c("", "");
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
    return new ooi.c(str, paramString1);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Matcher localMatcher = SMILEY_PATTERN.matcher(paramSpannableStringBuilder);
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramSpannableStringBuilder.subSequence(i, j).toString();
      if (!mMap.containsKey(str)) {
        break label278;
      }
    }
    label278:
    for (Object localObject = (Drawable)mMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      int k;
      if (localObject == null)
      {
        k = sdy.bm(str);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < sdy.EMO_FAST_SYMBOL.length) {
            paramCallback = sdp.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      localObject = paramCallback;
      if (paramCallback == null)
      {
        k = sdy.bn(str);
        ooz.d("emotion", "emotion code:" + str + ",index:" + k);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < sdy.cc.length) {
            localObject = sdp.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (localObject == null) {
        break label14;
      }
      mMap.put(str, localObject);
      ((Drawable)localObject).setBounds(new Rect(0, 0, paramInt, paramInt));
      paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan((Drawable)localObject, 0), i, j, 33);
      break label14;
      break;
    }
  }
  
  private static ArrayList<ooi.b> b(SpannableStringBuilder paramSpannableStringBuilder, FeedRichTextView.a parama)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      localObject = null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      return localObject;
      Matcher localMatcher = L.matcher(paramSpannableStringBuilder);
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
          ooi.b localb = a((String)localObject, ",name:");
          String str1 = localb.tid;
          String str2 = " #" + localb.name + " ";
          paramSpannableStringBuilder.replace(j, k - i, str2);
          i += ((String)localObject).length() - str2.length();
          k = str2.length() + j;
          paramSpannableStringBuilder.setSpan(new ook(parama, str1), j, k, 33);
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), j, k, 33);
          localArrayList.add(localb);
        }
      }
      catch (Exception paramSpannableStringBuilder)
      {
        paramSpannableStringBuilder.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public static class a
    extends SpannableStringBuilder
  {
    a(CharSequence paramCharSequence)
    {
      super();
    }
  }
  
  static class b
  {
    public String name;
    public String tid;
    
    public b() {}
    
    public b(String paramString1, String paramString2)
    {
      this.tid = paramString1;
      this.name = paramString2;
    }
  }
  
  static class c
  {
    public String nick;
    public String uid;
    
    public c() {}
    
    public c(String paramString1, String paramString2)
    {
      this.uid = paramString1;
      this.nick = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooi
 * JD-Core Version:    0.7.0.1
 */