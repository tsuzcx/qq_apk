import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.lang.ref.WeakReference;

public class ykv
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    yny.d("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
  
  public static yku a(ykt paramykt)
  {
    if ((paramykt == null) || (!paramykt.a()) || (!paramykt.jdField_a_of_type_Yjs.a()))
    {
      yny.d("GdtBannerViewBuilder", "build error");
      return null;
    }
    if (paramykt.jdField_a_of_type_Int == 0) {}
    for (yky localyky = new yky((Context)paramykt.jdField_a_of_type_Yjs.jdField_a_of_type_JavaLangRefWeakReference.get(), paramykt.jdField_a_of_type_Yjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd);; localyky = null)
    {
      if ((localyky != null) && (localyky.a() != null) && (yku.a != null))
      {
        localyky.a().setOnTouchListener(new ykw(localyky));
        localyky.a().setOnClickListener(new ykx(localyky, paramykt));
      }
      if (localyky != null) {
        localyky.a(paramykt.b, paramykt.c);
      }
      AdReporterForAnalysis.reportForBanner((Context)paramykt.jdField_a_of_type_Yjs.jdField_a_of_type_JavaLangRefWeakReference.get(), paramykt.jdField_a_of_type_Yjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
      return localyky;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykv
 * JD-Core Version:    0.7.0.1
 */