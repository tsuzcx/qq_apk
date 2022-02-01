package android.support.v4.text.util;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat
{
  private static final Comparator<LinkSpec> COMPARATOR = new Comparator()
  {
    public int compare(LinkifyCompat.LinkSpec paramAnonymousLinkSpec1, LinkifyCompat.LinkSpec paramAnonymousLinkSpec2)
    {
      if (paramAnonymousLinkSpec1.start < paramAnonymousLinkSpec2.start) {
        return -1;
      }
      if (paramAnonymousLinkSpec1.start > paramAnonymousLinkSpec2.start) {
        return 1;
      }
      if (paramAnonymousLinkSpec1.end < paramAnonymousLinkSpec2.end) {
        return 1;
      }
      if (paramAnonymousLinkSpec1.end > paramAnonymousLinkSpec2.end) {
        return -1;
      }
      return 0;
    }
  };
  private static final String[] EMPTY_STRING = new String[0];
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView)
  {
    MovementMethod localMovementMethod = paramTextView.getMovementMethod();
    if (((localMovementMethod == null) || (!(localMovementMethod instanceof LinkMovementMethod))) && (paramTextView.getLinksClickable())) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return;
    }
    SpannableString localSpannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter))
    {
      paramTextView.setText(localSpannableString);
      addLinkMovementMethod(paramTextView);
    }
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return Linkify.addLinks(paramSpannable, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i = localObject1.length - 1;
    while (i >= 0)
    {
      paramSpannable.removeSpan(localObject1[i]);
      i -= 1;
    }
    if ((paramInt & 0x4) != 0) {
      Linkify.addLinks(paramSpannable, 4);
    }
    localObject1 = new ArrayList();
    Object localObject2;
    if ((paramInt & 0x1) != 0)
    {
      localObject2 = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter localMatchFilter = Linkify.sUrlMatchFilter;
      gatherLinks((ArrayList)localObject1, paramSpannable, (Pattern)localObject2, new String[] { "http://", "https://", "rtsp://" }, localMatchFilter, null);
    }
    if ((paramInt & 0x2) != 0) {
      gatherLinks((ArrayList)localObject1, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null);
    }
    if ((paramInt & 0x8) != 0) {
      gatherMapLinks((ArrayList)localObject1, paramSpannable);
    }
    pruneOverlaps((ArrayList)localObject1, paramSpannable);
    if (((ArrayList)localObject1).size() == 0) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LinkSpec)((Iterator)localObject1).next();
      if (((LinkSpec)localObject2).frameworkAddedSpan == null) {
        applyLink(((LinkSpec)localObject2).url, ((LinkSpec)localObject2).start, ((LinkSpec)localObject2).end, paramSpannable);
      }
    }
    return true;
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramArrayOfString != null)
    {
      paramString = paramArrayOfString;
      if (paramArrayOfString.length >= 1) {}
    }
    else
    {
      paramString = EMPTY_STRING;
    }
    String[] arrayOfString = new String[paramString.length + 1];
    arrayOfString[0] = str.toLowerCase(Locale.ROOT);
    int i = 0;
    while (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      i += 1;
      if (paramArrayOfString == null) {
        paramArrayOfString = "";
      } else {
        paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT);
      }
      arrayOfString[i] = paramArrayOfString;
    }
    paramPattern = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    while (paramPattern.find())
    {
      i = paramPattern.start();
      int j = paramPattern.end();
      boolean bool2;
      if (paramMatchFilter != null) {
        bool2 = paramMatchFilter.acceptMatch(paramSpannable, i, j);
      } else {
        bool2 = true;
      }
      if (bool2)
      {
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), i, j, paramSpannable);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean addLinks(@NonNull TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return Linkify.addLinks(paramTextView, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject = paramTextView.getText();
    if ((localObject instanceof Spannable))
    {
      if (addLinks((Spannable)localObject, paramInt))
      {
        addLinkMovementMethod(paramTextView);
        return true;
      }
      return false;
    }
    localObject = SpannableString.valueOf((CharSequence)localObject);
    if (addLinks((Spannable)localObject, paramInt))
    {
      addLinkMovementMethod(paramTextView);
      paramTextView.setText((CharSequence)localObject);
      return true;
    }
    return false;
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    paramPattern = paramPattern.matcher(paramSpannable);
    while (paramPattern.find())
    {
      int i = paramPattern.start();
      int j = paramPattern.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        LinkSpec localLinkSpec = new LinkSpec();
        localLinkSpec.url = makeUrl(paramPattern.group(0), paramArrayOfString, paramPattern, paramTransformFilter);
        localLinkSpec.start = i;
        localLinkSpec.end = j;
        paramArrayList.add(localLinkSpec);
      }
    }
  }
  
  /* Error */
  private static void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 256	java/lang/Object:toString	()Ljava/lang/String;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_1
    //   8: invokestatic 262	android/webkit/WebView:findAddress	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnull +116 -> 131
    //   18: aload_1
    //   19: aload 6
    //   21: invokevirtual 266	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore 4
    //   26: iload 4
    //   28: ifge +4 -> 32
    //   31: return
    //   32: new 8	android/support/v4/text/util/LinkifyCompat$LinkSpec
    //   35: dup
    //   36: invokespecial 242	android/support/v4/text/util/LinkifyCompat$LinkSpec:<init>	()V
    //   39: astore 5
    //   41: aload 6
    //   43: invokevirtual 267	java/lang/String:length	()I
    //   46: iload 4
    //   48: iadd
    //   49: istore_3
    //   50: aload 5
    //   52: iload 4
    //   54: iload_2
    //   55: iadd
    //   56: putfield 175	android/support/v4/text/util/LinkifyCompat$LinkSpec:start	I
    //   59: iload_2
    //   60: iload_3
    //   61: iadd
    //   62: istore_2
    //   63: aload 5
    //   65: iload_2
    //   66: putfield 178	android/support/v4/text/util/LinkifyCompat$LinkSpec:end	I
    //   69: aload_1
    //   70: iload_3
    //   71: invokevirtual 270	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: astore_1
    //   75: aload 6
    //   77: ldc_w 272
    //   80: invokestatic 278	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 6
    //   85: new 280	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   92: astore 7
    //   94: aload 7
    //   96: ldc_w 283
    //   99: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: aload 6
    //   107: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: aload 7
    //   115: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: putfield 172	android/support/v4/text/util/LinkifyCompat$LinkSpec:url	Ljava/lang/String;
    //   121: aload_0
    //   122: aload 5
    //   124: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   127: pop
    //   128: goto -121 -> 7
    //   131: return
    //   132: astore_0
    //   133: return
    //   134: astore 5
    //   136: goto -129 -> 7
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayList	ArrayList<LinkSpec>
    //   0	139	1	paramSpannable	Spannable
    //   6	60	2	i	int
    //   49	22	3	j	int
    //   24	32	4	k	int
    //   39	84	5	localLinkSpec	LinkSpec
    //   134	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   11	95	6	str	String
    //   92	22	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	13	132	java/lang/UnsupportedOperationException
    //   18	26	132	java/lang/UnsupportedOperationException
    //   32	59	132	java/lang/UnsupportedOperationException
    //   63	75	132	java/lang/UnsupportedOperationException
    //   75	85	132	java/lang/UnsupportedOperationException
    //   85	128	132	java/lang/UnsupportedOperationException
    //   75	85	134	java/io/UnsupportedEncodingException
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramTransformFilter != null) {
      str = paramTransformFilter.transformUrl(paramMatcher, paramString);
    }
    int i = 0;
    for (;;)
    {
      j = paramArrayOfString.length;
      int k = 1;
      if (i >= j) {
        break;
      }
      if (str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        j = k;
        paramString = str;
        if (str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label146;
        }
        paramString = new StringBuilder();
        paramString.append(paramArrayOfString[i]);
        paramString.append(str.substring(paramArrayOfString[i].length()));
        paramString = paramString.toString();
        j = k;
        break label146;
      }
      i += 1;
    }
    int j = 0;
    paramString = str;
    label146:
    paramMatcher = paramString;
    if (j == 0)
    {
      paramMatcher = paramString;
      if (paramArrayOfString.length > 0)
      {
        paramMatcher = new StringBuilder();
        paramMatcher.append(paramArrayOfString[0]);
        paramMatcher.append(paramString);
        paramMatcher = paramMatcher.toString();
      }
    }
    return paramMatcher;
  }
  
  private static void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    int i = paramSpannable.length();
    int j = 0;
    Object localObject = (URLSpan[])paramSpannable.getSpans(0, i, URLSpan.class);
    i = 0;
    LinkSpec localLinkSpec;
    while (i < localObject.length)
    {
      localLinkSpec = new LinkSpec();
      localLinkSpec.frameworkAddedSpan = localObject[i];
      localLinkSpec.start = paramSpannable.getSpanStart(localObject[i]);
      localLinkSpec.end = paramSpannable.getSpanEnd(localObject[i]);
      paramArrayList.add(localLinkSpec);
      i += 1;
    }
    Collections.sort(paramArrayList, COMPARATOR);
    int m = paramArrayList.size();
    while (j < m - 1)
    {
      localObject = (LinkSpec)paramArrayList.get(j);
      int k = j + 1;
      localLinkSpec = (LinkSpec)paramArrayList.get(k);
      if ((((LinkSpec)localObject).start <= localLinkSpec.start) && (((LinkSpec)localObject).end > localLinkSpec.start))
      {
        if (localLinkSpec.end <= ((LinkSpec)localObject).end) {
          i = k;
        } else if (((LinkSpec)localObject).end - ((LinkSpec)localObject).start > localLinkSpec.end - localLinkSpec.start) {
          i = k;
        } else if (((LinkSpec)localObject).end - ((LinkSpec)localObject).start < localLinkSpec.end - localLinkSpec.start) {
          i = j;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          localObject = ((LinkSpec)paramArrayList.get(i)).frameworkAddedSpan;
          if (localObject != null) {
            paramSpannable.removeSpan(localObject);
          }
          paramArrayList.remove(i);
          m -= 1;
          continue;
        }
      }
      j = k;
    }
  }
  
  private static class LinkSpec
  {
    int end;
    URLSpan frameworkAddedSpan;
    int start;
    String url;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface LinkifyMask {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.text.util.LinkifyCompat
 * JD-Core Version:    0.7.0.1
 */