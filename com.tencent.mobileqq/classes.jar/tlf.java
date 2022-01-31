import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSchema;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.util.Date;
import java.util.List;

public class tlf
{
  public static int a(int paramInt, stMetaUgcVideoSeg paramstMetaUgcVideoSeg)
  {
    if ((paramstMetaUgcVideoSeg == null) || (paramstMetaUgcVideoSeg.width == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[getClippedVideoHeight] ");
      if (paramstMetaUgcVideoSeg == null) {}
      for (paramstMetaUgcVideoSeg = "video is null";; paramstMetaUgcVideoSeg = "video width is zero")
      {
        tlo.d("WSFeedUtils", paramstMetaUgcVideoSeg);
        return paramInt * 4 / 3;
      }
    }
    tlo.b("WSFeedUtils", "[getClippedVideoHeight] width: " + paramstMetaUgcVideoSeg.width + ", height: " + paramstMetaUgcVideoSeg.height);
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
  
  public static SpannableStringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new SpannableStringBuilder(paramString1).append("：").append(paramString2);
    new tli(paramString3);
    paramString2.setSpan(new StyleSpan(1), 0, paramString1.length() + 1, 33);
    return paramString2;
  }
  
  public static WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 9;
    localWSDownloadParams.mLinkStrategyType = tee.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = tlv.a(1);
    localWSDownloadParams.mStReportItem = tjr.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  public static String a(int paramInt)
  {
    tlo.b("WSFeedUtils", "feed create time: " + paramInt + ", corresponding date: " + new Date(paramInt * 1000));
    long l = System.currentTimeMillis() / 1000L - paramInt;
    if ((l >= 0L) && (l < 60L)) {
      return b(2131693799);
    }
    if ((l >= 60L) && (l < 3600L)) {
      return String.format(b(2131693800), new Object[] { Long.valueOf(l / 60L) });
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return a(2131693798, new Object[] { Long.valueOf(l / 3600L) });
    }
    if ((l >= 86400L) && (l < 2592000L)) {
      return a(2131693794, new Object[] { Long.valueOf(l / 86400L) });
    }
    return a(2131693794, new Object[] { Integer.valueOf(30) });
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return String.format(BaseApplicationImpl.getApplication().getString(paramInt), paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(2131693801);
    }
    return str;
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
      MiniAppLauncher.startMiniApp(paramActivity, paramstSchema.miniAppSchema, -1, null);
      return;
    case 2: 
      a(paramActivity, paramstSchema.schema, paramInt1, paramInt2, paramString);
      return;
    }
    tch.a(paramActivity, paramstSchema.H5Url);
  }
  
  public static void a(Activity paramActivity, stSchema paramstSchema, int paramInt, String paramString)
  {
    a(paramActivity, paramstSchema, paramInt);
    if (paramstSchema.type == 1)
    {
      if (TextUtils.equals(paramString, tlv.f())) {
        tlv.c("homepage_main");
      }
    }
    else {
      return;
    }
    tlv.c("homepage_guest");
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    tlo.b("WSFeedUtils", "[openWeishiViaScheme] scheme: " + paramString1 + ", eventId: " + paramInt1);
    if (paramActivity == null) {
      return;
    }
    WSDownloadParams localWSDownloadParams = a(paramString1, paramInt1);
    if (xsx.a(paramActivity))
    {
      tky.a(paramActivity, new tlj(paramActivity, paramString1, localWSDownloadParams, paramString2, paramInt2));
      return;
    }
    tfa.a(paramActivity, localWSDownloadParams, true);
  }
  
  public static void a(Context paramContext, bhuk parambhuk, bhum parambhum)
  {
    paramContext = bhuf.a(paramContext);
    paramContext.a("取消关注", 3);
    paramContext.d("取消");
    paramContext.a(new tlg(parambhuk, paramContext));
    paramContext.a(new tlh(parambhum));
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
      paramTextView.setBackgroundResource(2130850222);
      return;
    case 3: 
      paramTextView.setBackgroundResource(2130850220);
      return;
    case 5: 
      paramTextView.setBackgroundResource(2130850221);
      return;
    }
    paramTextView.setBackgroundResource(2130850223);
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
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlf
 * JD-Core Version:    0.7.0.1
 */