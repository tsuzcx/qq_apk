import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1.1;
import com.tencent.viola.core.ViolaEnvironment;

public class uca
  implements bgyw
{
  public uca(ViolaBaseView.10 param10) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (ViolaBaseView.a(this.a.this$0) == 0.0D)
    {
      ViolaBaseView.a(this.a.this$0, paramDouble);
      ViolaBaseView.a(this.a.this$0).addReportData(ViolaEnvironment.KEY_FRAME_PAGE, String.format("%.2f", new Object[] { Double.valueOf(ViolaBaseView.a(this.a.this$0)) }));
    }
    new Handler().postDelayed(new ViolaBaseView.10.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */