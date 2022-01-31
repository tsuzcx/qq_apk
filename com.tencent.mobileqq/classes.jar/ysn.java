import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAdLoader.1;
import com.tencent.gdtad.aditem.GdtAdLoader.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

public class ysn
{
  private WeakReference<yso> jdField_a_of_type_JavaLangRefWeakReference;
  private ysp jdField_a_of_type_Ysp;
  
  public ysn(ysp paramysp, WeakReference<yso> paramWeakReference)
  {
    this.jdField_a_of_type_Ysp = paramysp;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void a()
  {
    new Handler(Looper.getMainLooper()).post(new GdtAdLoader.2(this));
  }
  
  private void b(WeakReference<Context> paramWeakReference)
  {
    if ((this.jdField_a_of_type_Ysp == null) || (this.jdField_a_of_type_Ysp.a == null))
    {
      yxp.d("GdtAdLoader", "reportForAnalysis error");
      return;
    }
    int i = 0;
    label27:
    if (i < this.jdField_a_of_type_Ysp.a.position_info.size()) {
      if (paramWeakReference == null) {
        break label90;
      }
    }
    label90:
    for (Context localContext = (Context)paramWeakReference.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForLoadAd(localContext, ((qq_ad_get.QQAdGet.PositionInfo)this.jdField_a_of_type_Ysp.a.position_info.get(i)).pos_id.get());
      i += 1;
      break label27;
      break;
    }
  }
  
  public ysp a()
  {
    return this.jdField_a_of_type_Ysp;
  }
  
  public void a(WeakReference<Context> paramWeakReference)
  {
    ThreadManager.post(new GdtAdLoader.1(this, paramWeakReference), 5, null, true);
    b(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysn
 * JD-Core Version:    0.7.0.1
 */