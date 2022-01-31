import android.content.Context;
import android.net.Uri;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import java.lang.ref.WeakReference;

public final class yyc
{
  private static gdt_analysis_event a(Context paramContext, int paramInt1, GdtAd paramGdtAd, int paramInt2, int paramInt3, String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    paramGdtAd = AdReporterForAnalysis.createEventForAd(paramContext, paramInt1, paramGdtAd);
    if (paramInt2 == 0)
    {
      paramGdtAd.statisticsType = 101;
      paramGdtAd.businessId = String.valueOf(paramInt3);
      if (paramString == null) {
        break label79;
      }
    }
    label79:
    for (paramContext = paramString.getHost();; paramContext = null)
    {
      paramGdtAd.hostName = paramContext;
      return paramGdtAd;
      if (paramInt2 == 1)
      {
        paramGdtAd.statisticsType = 102;
        break;
      }
      if (paramInt2 != 2) {
        break;
      }
      paramGdtAd.statisticsType = 105;
      break;
    }
  }
  
  public static void a(Context paramContext)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1081, localgdt_analysis_event);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt)
  {
    long l = -2147483648L;
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    if (paramLong != -2147483648L) {
      l = System.currentTimeMillis() - paramLong;
    }
    localgdt_analysis_event.duration = l;
    localgdt_analysis_event.status = paramInt;
    AdAnalysisUtil.initEvent(paramContext, 1083, localgdt_analysis_event);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    long l = -2147483648L;
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1082, localgdt_analysis_event);
    if (paramLong != -2147483648L) {
      l = System.currentTimeMillis() - paramLong;
    }
    localgdt_analysis_event.duration = l;
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramGdtAd = a(paramContext, 1058, paramGdtAd, paramInt1, paramInt2, null);
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = 4)
    {
      paramGdtAd.internalErrorCode = paramInt1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtAd, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    long l2 = -2147483648L;
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null)) {}
    for (GdtAd localGdtAd = paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a;; localGdtAd = null)
    {
      long l1 = l2;
      if (paramGdtInterstitialParams != null)
      {
        l1 = l2;
        if (paramGdtInterstitialParams.jdField_a_of_type_Long != -2147483648L) {
          l1 = System.currentTimeMillis() - paramGdtInterstitialParams.jdField_a_of_type_Long;
        }
      }
      paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(paramContext, 1077, localGdtAd);
      paramGdtInterstitialParams.duration = l1;
      paramGdtInterstitialParams.status = yul.a().a();
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt)
  {
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null)) {}
    for (paramGdtInterstitialParams = paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a;; paramGdtInterstitialParams = null)
    {
      paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(paramContext, 1076, paramGdtInterstitialParams);
      paramGdtInterstitialParams.internalErrorCode = paramInt;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt1, int paramInt2)
  {
    long l2 = -2147483648L;
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null)) {}
    for (GdtAd localGdtAd = paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a;; localGdtAd = null)
    {
      long l1 = l2;
      if (paramGdtInterstitialParams != null)
      {
        l1 = l2;
        if (paramGdtInterstitialParams.jdField_a_of_type_Long != -2147483648L) {
          l1 = System.currentTimeMillis() - paramGdtInterstitialParams.jdField_a_of_type_Long;
        }
      }
      paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(paramContext, 1078, localGdtAd);
      paramGdtInterstitialParams.internalErrorCode = paramInt1;
      paramGdtInterstitialParams.errorCode1 = paramInt2;
      paramGdtInterstitialParams.duration = l1;
      paramGdtInterstitialParams.status = yul.a().a();
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = -2147483648L;
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null)) {}
    for (GdtAd localGdtAd = paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a;; localGdtAd = null)
    {
      long l1 = l2;
      if (paramGdtInterstitialParams != null)
      {
        l1 = l2;
        if (paramGdtInterstitialParams.jdField_a_of_type_Long != -2147483648L) {
          l1 = System.currentTimeMillis() - paramGdtInterstitialParams.jdField_a_of_type_Long;
        }
      }
      paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(paramContext, 1080, localGdtAd);
      paramGdtInterstitialParams.internalErrorCode = paramInt1;
      paramGdtInterstitialParams.errorCode1 = paramInt2;
      paramGdtInterstitialParams.errorCode2 = paramInt3;
      paramGdtInterstitialParams.duration = l1;
      paramGdtInterstitialParams.status = yul.a().a();
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
      return;
    }
  }
  
  public static void a(Context paramContext, yyf paramyyf, int paramInt, long paramLong)
  {
    paramyyf = a(paramContext, 1059, new GdtAd(paramyyf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyyf.jdField_a_of_type_Int, paramyyf.b, null);
    if (paramInt == 0)
    {
      paramyyf.internalErrorCode = 0;
      paramyyf.errorCode1 = paramInt;
      if (paramLong == -2147483648L) {
        break label120;
      }
    }
    label120:
    for (paramLong = System.currentTimeMillis() - paramLong;; paramLong = -2147483648L)
    {
      paramyyf.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyyf, 102));
      return;
      if (paramInt == 1)
      {
        paramyyf.internalErrorCode = 2;
        break;
      }
      if (paramInt == 2)
      {
        paramyyf.internalErrorCode = 4;
        break;
      }
      paramyyf.internalErrorCode = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, yyf paramyyf, String paramString)
  {
    paramyyf = a(paramContext, 1056, new GdtAd(paramyyf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyyf.jdField_a_of_type_Int, paramyyf.b, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyyf, 102));
  }
  
  public static void a(Context paramContext, yyf paramyyf, String paramString, int paramInt)
  {
    paramyyf = a(paramContext, 1060, new GdtAd(paramyyf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyyf.jdField_a_of_type_Int, paramyyf.b, paramString);
    paramyyf.httpErrorCode = paramInt;
    if (paramyyf.httpErrorCode == 200) {
      paramyyf.internalErrorCode = 0;
    }
    for (;;)
    {
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyyf, 102));
      return;
      if (paramyyf.httpErrorCode == -1) {
        paramyyf.internalErrorCode = 3;
      } else {
        paramyyf.internalErrorCode = 5;
      }
    }
  }
  
  public static void a(Context paramContext, yyf paramyyf, String paramString, int paramInt, long paramLong)
  {
    paramyyf = a(paramContext, 1057, new GdtAd(paramyyf.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyyf.jdField_a_of_type_Int, paramyyf.b, paramString);
    paramyyf.httpErrorCode = paramInt;
    if (paramyyf.httpErrorCode == 200) {
      paramyyf.internalErrorCode = 0;
    }
    for (;;)
    {
      paramyyf.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyyf, 102));
      return;
      if (paramyyf.httpErrorCode == -1) {
        paramyyf.internalErrorCode = 3;
      } else {
        paramyyf.internalErrorCode = 5;
      }
    }
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams)
  {
    long l2 = -2147483648L;
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options != null)) {}
    for (GdtAd localGdtAd = paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.a;; localGdtAd = null)
    {
      long l1 = l2;
      if (paramGdtInterstitialParams != null)
      {
        l1 = l2;
        if (paramGdtInterstitialParams.jdField_a_of_type_Long != -2147483648L) {
          l1 = System.currentTimeMillis() - paramGdtInterstitialParams.jdField_a_of_type_Long;
        }
      }
      paramGdtInterstitialParams = AdReporterForAnalysis.createEventForAd(paramContext, 1079, localGdtAd);
      paramGdtInterstitialParams.duration = l1;
      paramGdtInterstitialParams.status = yul.a().a();
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyc
 * JD-Core Version:    0.7.0.1
 */