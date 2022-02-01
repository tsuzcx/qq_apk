import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1.1.1;
import com.tencent.viola.core.ViolaEnvironment;

public class nxd
  implements aqda.a
{
  public nxd(ViolaBaseView.10.1 param1) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (ViolaBaseView.a(this.a.a.this$0) == 0.0D)
    {
      ViolaBaseView.a(this.a.a.this$0, paramDouble);
      ViolaBaseView.a(this.a.a.this$0).addReportData(ViolaEnvironment.KEY_FRAME_PAGE, String.format("%.2f", new Object[] { Double.valueOf(ViolaBaseView.a(this.a.a.this$0)) }));
    }
    new Handler().postDelayed(new ViolaBaseView.10.1.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxd
 * JD-Core Version:    0.7.0.1
 */