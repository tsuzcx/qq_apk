import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class ytw
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    yxs.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static ytv a(ytu paramytu)
  {
    if ((paramytu == null) || (!paramytu.a()) || (!paramytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()))
    {
      yxs.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramytu.jdField_a_of_type_Int == 0) {}
    for (ytz localytz = new ytz((Context)paramytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localytz = null)
    {
      if ((localytz != null) && (localytz.a() != null) && (ytv.a != null))
      {
        localytz.a().setOnTouchListener(new ytx(localytz));
        localytz.a().setOnClickListener(new yty(localytz, paramytu));
      }
      if (localytz != null) {
        localytz.a(paramytu.b, paramytu.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_JavaLangRefWeakReference.get(), paramytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localytz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytw
 * JD-Core Version:    0.7.0.1
 */