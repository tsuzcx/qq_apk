import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1.1.1;
import com.tencent.viola.core.ViolaEnvironment;

public class tjc
  implements bhgv
{
  public tjc(ViolaBaseView.10.1 param1) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (ViolaBaseView.a(this.a.a.a) == 0.0D)
    {
      ViolaBaseView.a(this.a.a.a, paramDouble);
      ViolaBaseView.a(this.a.a.a).addReportData(ViolaEnvironment.KEY_FRAME_PAGE, String.format("%.2f", new Object[] { Double.valueOf(ViolaBaseView.a(this.a.a.a)) }));
    }
    new Handler().postDelayed(new ViolaBaseView.10.1.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjc
 * JD-Core Version:    0.7.0.1
 */