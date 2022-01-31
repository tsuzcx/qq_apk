import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class ytt
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    yxp.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static yts a(ytr paramytr)
  {
    if ((paramytr == null) || (!paramytr.a()) || (!paramytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      yxp.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramytr.jdField_a_of_type_Int == 0) {}
    for (ytw localytw = new ytw((Context)paramytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localytw = null)
    {
      if ((localytw != null) && (localytw.a() != null) && (yts.a != null))
      {
        localytw.a().setOnTouchListener(new ytu(localytw));
        localytw.a().setOnClickListener(new ytv(localytw, paramytr));
      }
      if (localytw != null) {
        localytw.a(paramytr.b, paramytr.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localytw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytt
 * JD-Core Version:    0.7.0.1
 */