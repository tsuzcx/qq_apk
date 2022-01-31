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

public class ysq
{
  private WeakReference<ysr> jdField_a_of_type_JavaLangRefWeakReference;
  private yss jdField_a_of_type_Yss;
  
  public ysq(yss paramyss, WeakReference<ysr> paramWeakReference)
  {
    this.jdField_a_of_type_Yss = paramyss;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void a()
  {
    new Handler(Looper.getMainLooper()).post(new GdtAdLoader.2(this));
  }
  
  private void b(WeakReference<Context> paramWeakReference)
  {
    if ((this.jdField_a_of_type_Yss == null) || (this.jdField_a_of_type_Yss.a == null))
    {
      yxs.d("GdtAdLoader", "reportForAnalysis error");
      return;
    }
    int i = 0;
    label27:
    if (i < this.jdField_a_of_type_Yss.a.position_info.size()) {
      if (paramWeakReference == null) {
        break label90;
      }
    }
    label90:
    for (Context localContext = (Context)paramWeakReference.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForLoadAd(localContext, ((qq_ad_get.QQAdGet.PositionInfo)this.jdField_a_of_type_Yss.a.position_info.get(i)).pos_id.get());
      i += 1;
      break label27;
      break;
    }
  }
  
  public yss a()
  {
    return this.jdField_a_of_type_Yss;
  }
  
  public void a(WeakReference<Context> paramWeakReference)
  {
    ThreadManager.post(new GdtAdLoader.1(this, paramWeakReference), 5, null, true);
    b(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysq
 * JD-Core Version:    0.7.0.1
 */