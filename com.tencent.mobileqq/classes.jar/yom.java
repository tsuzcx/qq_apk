import android.content.Context;
import android.net.Uri;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;

public final class yom
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
  
  public static void a(Context paramContext, yop paramyop, int paramInt, long paramLong)
  {
    paramyop = a(paramContext, 1059, new GdtAd(paramyop.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyop.jdField_a_of_type_Int, paramyop.b, null);
    if (paramInt == 0)
    {
      paramyop.internalErrorCode = 0;
      paramyop.errorCode1 = paramInt;
      if (paramLong == -2147483648L) {
        break label120;
      }
    }
    label120:
    for (paramLong = System.currentTimeMillis() - paramLong;; paramLong = -2147483648L)
    {
      paramyop.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyop, 102));
      return;
      if (paramInt == 1)
      {
        paramyop.internalErrorCode = 2;
        break;
      }
      if (paramInt == 2)
      {
        paramyop.internalErrorCode = 4;
        break;
      }
      paramyop.internalErrorCode = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, yop paramyop, String paramString)
  {
    paramyop = a(paramContext, 1056, new GdtAd(paramyop.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyop.jdField_a_of_type_Int, paramyop.b, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyop, 102));
  }
  
  public static void a(Context paramContext, yop paramyop, String paramString, int paramInt)
  {
    paramyop = a(paramContext, 1060, new GdtAd(paramyop.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyop.jdField_a_of_type_Int, paramyop.b, paramString);
    paramyop.httpErrorCode = paramInt;
    if (paramyop.httpErrorCode == 200) {
      paramyop.internalErrorCode = 0;
    }
    for (;;)
    {
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyop, 102));
      return;
      if (paramyop.httpErrorCode == -1) {
        paramyop.internalErrorCode = 3;
      } else {
        paramyop.internalErrorCode = 5;
      }
    }
  }
  
  public static void a(Context paramContext, yop paramyop, String paramString, int paramInt, long paramLong)
  {
    paramyop = a(paramContext, 1057, new GdtAd(paramyop.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo), paramyop.jdField_a_of_type_Int, paramyop.b, paramString);
    paramyop.httpErrorCode = paramInt;
    if (paramyop.httpErrorCode == 200) {
      paramyop.internalErrorCode = 0;
    }
    for (;;)
    {
      paramyop.duration = paramLong;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramyop, 102));
      return;
      if (paramyop.httpErrorCode == -1) {
        paramyop.internalErrorCode = 3;
      } else {
        paramyop.internalErrorCode = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yom
 * JD-Core Version:    0.7.0.1
 */