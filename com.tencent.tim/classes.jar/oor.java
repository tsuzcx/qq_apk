import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSchema;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class oor
{
  private static final Pattern M = Pattern.compile("[@#]\\w+", 2);
  private static String[] bJ;
  public static int bfy = 1;
  
  static
  {
    bJ = new String[] { "[em]e212[/em]", "[em]e219[/em]", "[em]e226[/em]", "[em]e233[/em]", "[em]e234[/em]", "[em]e221[/em]", "[em]e228[/em]", "[em]e208[/em]", "[em]e222[/em]", "[em]e229[/em]", "[em]e223[/em]", "[em]e230[/em]", "[em]e240[/em]", "[em]e224[/em]", "[em]e231[/em]", "[em]e211[/em]", "[em]e218[/em]", "[em]e225[/em]", "[em]e232[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e280[/em]", "[em]e256[/em]", "[em]e261[/em]", "[em]e259[/em]", "[em]e235[/em]", "[em]e236[/em]", "[em]e239[/em]" };
  }
  
  public static int a(int paramInt, stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    if ((paramstMetaUgcVideoSeg == null) || (paramstMetaUgcVideoSeg.width == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[getClippedVideoHeight] ");
      if (paramstMetaUgcVideoSeg == null) {}
      for (paramstMetaUgcVideoSeg = "video is null";; paramstMetaUgcVideoSeg = "video width is zero")
      {
        ooz.e("WSFeedUtils", paramstMetaUgcVideoSeg);
        return paramInt * 4 / 3;
      }
    }
    ooz.d("WSFeedUtils", "[getClippedVideoHeight] width: " + paramstMetaUgcVideoSeg.width + ", height: " + paramstMetaUgcVideoSeg.height);
    if (paramstMetaUgcVideoSeg.height > paramstMetaUgcVideoSeg.width) {
      return paramInt * 4 / 3;
    }
    return paramstMetaUgcVideoSeg.height * paramInt / paramstMetaUgcVideoSeg.width;
  }
  
  public static SpannableStringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SpannableStringBuilder(paramString1).append("：").append(a(paramString2));
    new oou(paramString3);
    paramString2.setSpan(new StyleSpan(1), 0, paramString1.length() + 1, 33);
    d(paramString2);
    return paramString2;
  }
  
  public static WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 9;
    localWSDownloadParams.mLinkStrategyType = ohy.a().rp();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = opn.getSceneTypeTestId(1);
    localWSDownloadParams.mStReportItem = ond.getInitialReportItem();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    String[] arrayOfString = bJ;
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
      ogj.a(paramActivity, paramstSchema.miniAppSchema, null);
      return;
    case 2: 
      a(paramActivity, paramstSchema.schema, paramInt1, paramInt2, paramString);
      return;
    }
    ogj.aM(paramActivity, paramstSchema.H5Url);
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt, String paramString)
  {
    a(paramActivity, paramstSchema, paramInt);
    if (paramstSchema.type == 1)
    {
      if (TextUtils.equals(paramString, opn.getPersonId())) {
        opn.pQ("homepage_main");
      }
    }
    else {
      return;
    }
    opn.pQ("homepage_guest");
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ooz.d("WSFeedUtils", "[openWeishiViaScheme] scheme: " + paramString1 + ", eventId: " + paramInt1);
    if (paramActivity == null) {
      return;
    }
    WSDownloadParams localWSDownloadParams = a(paramString1, paramInt1);
    if (rpw.isWeishiInstalled(paramActivity))
    {
      ool.a(paramActivity, new oov(paramActivity, paramString1, localWSDownloadParams, paramString2, paramInt2));
      return;
    }
    oir.a(paramActivity, localWSDownloadParams, true);
  }
  
  public static void a(Context paramContext, ausj.a parama, ausj.c paramc)
  {
    paramContext = ausj.b(paramContext);
    paramContext.addButton("取消关注", 3);
    paramContext.addCancelButton("取消");
    paramContext.a(new oos(parama, paramContext));
    paramContext.a(new oot(paramc));
    paramContext.show();
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
      paramTextView.setBackgroundResource(2130851944);
      return;
    case 3: 
      paramTextView.setBackgroundResource(2130851942);
      return;
    case 5: 
      paramTextView.setBackgroundResource(2130851943);
      return;
    }
    paramTextView.setBackgroundResource(2130851945);
  }
  
  public static String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(BaseApplicationImpl.getApplication().getString(paramInt), paramVarArgs);
  }
  
  public static String bM(int paramInt)
  {
    ooz.d("WSFeedUtils", "feed create time: " + paramInt + ", corresponding date: " + new Date(paramInt * 1000));
    long l = System.currentTimeMillis() / 1000L - paramInt;
    if ((l >= 0L) && (l < 60L)) {
      return getString(2131695138);
    }
    if ((l >= 60L) && (l < 3600L)) {
      return String.format(getString(2131695139), new Object[] { Long.valueOf(l / 60L) });
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return b(2131695137, new Object[] { Long.valueOf(l / 3600L) });
    }
    if ((l >= 86400L) && (l < 2592000L)) {
      return b(2131695133, new Object[] { Long.valueOf(l / 86400L) });
    }
    return b(2131695133, new Object[] { Integer.valueOf(30) });
  }
  
  private static void d(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {}
    for (;;)
    {
      return;
      Matcher localMatcher = M.matcher(paramSpannableStringBuilder);
      while (localMatcher.find())
      {
        int i = localMatcher.start();
        int j = localMatcher.end();
        String str = paramSpannableStringBuilder.subSequence(i, j).toString();
        ooz.w("WSFeedUtils", "subStr:" + str);
        paramSpannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
      }
    }
  }
  
  public static boolean eu(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean ev(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  public static String fy(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131695140);
    }
    return str;
  }
  
  public static int getColor(int paramInt)
  {
    return getContext().getResources().getColor(paramInt);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static Drawable getDrawable(int paramInt)
  {
    return getContext().getResources().getDrawable(paramInt);
  }
  
  public static String getString(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getString(paramInt);
  }
  
  public static int h(View paramView)
  {
    Rect localRect = new Rect();
    if (paramView.getLocalVisibleRect(localRect)) {
      return localRect.height() * 100 / paramView.getHeight();
    }
    return -1;
  }
  
  public static boolean isDebug()
  {
    return false;
  }
  
  public static int j(float paramFloat)
  {
    return ankt.dip2px(paramFloat);
  }
  
  public static boolean v(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oor
 * JD-Core Version:    0.7.0.1
 */