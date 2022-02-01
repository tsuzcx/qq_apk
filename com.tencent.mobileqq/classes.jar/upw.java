import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFeed;
import UserGrowth.stSchema;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class upw
{
  public static int a;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[@#]\\w+", 2);
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "[em]e212[/em]", "[em]e219[/em]", "[em]e226[/em]", "[em]e233[/em]", "[em]e234[/em]", "[em]e221[/em]", "[em]e228[/em]", "[em]e208[/em]", "[em]e222[/em]", "[em]e229[/em]", "[em]e223[/em]", "[em]e230[/em]", "[em]e240[/em]", "[em]e224[/em]", "[em]e231[/em]", "[em]e211[/em]", "[em]e218[/em]", "[em]e225[/em]", "[em]e232[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e256[/em]", "[em]e261[/em]", "[em]e259[/em]", "[em]e235[/em]", "[em]e236[/em]", "[em]e239[/em]" };
  }
  
  public static int a(float paramFloat)
  {
    return bdep.a(paramFloat);
  }
  
  public static int a(int paramInt)
  {
    return a().getResources().getColor(paramInt);
  }
  
  public static int a(int paramInt, stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    if ((paramstMetaUgcVideoSeg == null) || (paramstMetaUgcVideoSeg.width == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[getClippedVideoHeight] ");
      if (paramstMetaUgcVideoSeg == null) {}
      for (paramstMetaUgcVideoSeg = "video is null";; paramstMetaUgcVideoSeg = "video width is zero")
      {
        uqf.d("WSFeedUtils", paramstMetaUgcVideoSeg);
        return paramInt * 4 / 3;
      }
    }
    uqf.b("WSFeedUtils", "[getClippedVideoHeight] width: " + paramstMetaUgcVideoSeg.width + ", height: " + paramstMetaUgcVideoSeg.height);
    if (paramstMetaUgcVideoSeg.height > paramstMetaUgcVideoSeg.width) {
      return paramInt * 4 / 3;
    }
    return paramstMetaUgcVideoSeg.height * paramInt / paramstMetaUgcVideoSeg.width;
  }
  
  public static int a(View paramView)
  {
    Rect localRect = new Rect();
    if (paramView.getLocalVisibleRect(localRect)) {
      return localRect.height() * 100 / paramView.getHeight();
    }
    return -1;
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static Drawable a(int paramInt)
  {
    return a().getResources().getDrawable(paramInt);
  }
  
  public static SpannableStringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SpannableStringBuilder(paramString1).append("：").append(a(paramString2));
    new upz(paramString3);
    paramString3 = new StyleSpan(1);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-16777216);
    paramString2.setSpan(paramString3, 0, paramString1.length() + 1, 33);
    paramString2.setSpan(localForegroundColorSpan, 0, paramString1.length() + 1, 33);
    a(paramString2);
    return paramString2;
  }
  
  public static WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 9;
    localWSDownloadParams.mLinkStrategyType = ugd.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = uqt.a(1);
    localWSDownloadParams.mStReportItem = uno.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      paramCharSequence = paramCharSequence.toString().replace(str, "");
      i += 1;
    }
    return paramCharSequence;
  }
  
  public static String a(int paramInt)
  {
    uqf.b("WSFeedUtils", "feed create time: " + paramInt + ", corresponding date: " + new Date(paramInt * 1000));
    long l = System.currentTimeMillis() / 1000L - paramInt;
    if ((l >= 0L) && (l < 60L)) {
      return b(2131693149);
    }
    if ((l >= 60L) && (l < 3600L)) {
      return String.format(b(2131693150), new Object[] { Long.valueOf(l / 60L) });
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return a(2131693148, new Object[] { Long.valueOf(l / 3600L) });
    }
    if ((l >= 86400L) && (l < 2592000L)) {
      return a(2131693144, new Object[] { Long.valueOf(l / 86400L) });
    }
    return a(2131693144, new Object[] { Integer.valueOf(30) });
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(BaseApplicationImpl.getApplication().getString(paramInt), paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(2131693151);
    }
    return str;
  }
  
  public static List<ull> a(List<stFeed> paramList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    if (paramBoolean)
    {
      i = paramInt + 1;
      while (i < paramInt + 1 + 3)
      {
        a(localArrayList, paramList, i);
        i += 1;
      }
    }
    int i = paramInt - 1;
    while (i > paramInt - 1 - 3)
    {
      a(localArrayList, paramList, i);
      i -= 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    LocalMultiProcConfig.putBool("weishi_usergrowth" + uqt.a(), "key_player_mute_guide_show", true);
  }
  
  public static void a(int paramInt, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView.getVisibility() != paramInt) {
        localView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt)
  {
    a(paramActivity, paramstSchema, paramInt, 0, "");
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt1, int paramInt2, String paramString)
  {
    if (paramstSchema == null) {
      return;
    }
    switch (paramstSchema.type)
    {
    default: 
      return;
    case 1: 
      ueg.a(paramActivity, paramstSchema.miniAppSchema, null);
      return;
    case 2: 
      a(paramActivity, paramstSchema.schema, paramInt1, paramInt2, paramString);
      return;
    }
    ueg.a(paramActivity, paramstSchema.H5Url);
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt, String paramString)
  {
    a(paramActivity, paramstSchema, paramInt);
    if (paramstSchema.type == 1)
    {
      if (TextUtils.equals(paramString, uqt.f())) {
        uqt.d("homepage_main");
      }
    }
    else {
      return;
    }
    uqt.d("homepage_guest");
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    uqf.b("WSFeedUtils", "[openWeishiViaScheme] scheme: " + paramString1 + ", eventId: " + paramInt1);
    if (paramActivity == null) {
      return;
    }
    WSDownloadParams localWSDownloadParams = a(paramString1, paramInt1);
    if (zqd.a(paramActivity))
    {
      upn.a(paramActivity, new uqa(paramActivity, paramString1, localWSDownloadParams, paramString2, paramInt2));
      return;
    }
    ugz.a(paramActivity, localWSDownloadParams, true);
  }
  
  public static void a(Context paramContext, bliz parambliz, bljb parambljb)
  {
    paramContext = blir.a(paramContext);
    paramContext.a("取消关注", 3);
    paramContext.d("取消");
    paramContext.a(new upx(parambliz, paramContext));
    paramContext.a(new upy(parambljb));
    paramContext.show();
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {}
    for (;;)
    {
      return;
      Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramSpannableStringBuilder);
      while (localMatcher.find())
      {
        int i = localMatcher.start();
        int j = localMatcher.end();
        String str = paramSpannableStringBuilder.subSequence(i, j).toString();
        uqf.c("WSFeedUtils", "subStr:" + str);
        paramSpannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
      }
    }
  }
  
  public static void a(View.OnClickListener paramOnClickListener, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(paramOnClickListener);
      }
      i += 1;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    if ((paramTextView == null) || (paramBoolean)) {
      return;
    }
    paramTextView.setVisibility(0);
    switch (paramInt)
    {
    default: 
      paramTextView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      paramTextView.setBackgroundResource(2130850842);
      return;
    case 3: 
      paramTextView.setBackgroundResource(2130850840);
      return;
    case 5: 
      paramTextView.setBackgroundResource(2130850841);
      return;
    }
    paramTextView.setBackgroundResource(2130850843);
  }
  
  private static void a(List<ull> paramList, List<stFeed> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (stFeed)paramList1.get(paramInt);
      if (paramList1.feed != null) {}
    }
    else
    {
      return;
    }
    paramList.add(usd.a(paramList1.feed));
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static String b(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getString(paramInt);
  }
  
  public static boolean b()
  {
    return LocalMultiProcConfig.getBool("weishi_usergrowth" + uqt.a(), "key_player_mute_guide_show", false);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upw
 * JD-Core Version:    0.7.0.1
 */