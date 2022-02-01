import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class nzn
  implements jox
{
  public nzn(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptFeedsActivity", 2, "HtmlOffline.checkUpByBusinessId businessId=2278, code=" + paramInt);
    }
    this.this$0.app.getApplication();
    int i = aqiw.getSystemNetwork(MobileQQ.getContext());
    paramString = new HashMap();
    paramString.put("network", "" + i);
    paramString.put("status_code", "" + paramInt);
    anpc.a(this.this$0).collectPerformance(null, "subscription_htmloffline", true, 0L, 0L, paramString, "", false);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzn
 * JD-Core Version:    0.7.0.1
 */