import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class tvb
  implements nmg
{
  public tvb(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptFeedsActivity", 2, "HtmlOffline.checkUpByBusinessId businessId=2278, code=" + paramInt);
    }
    this.a.app.getApplication();
    int i = bhnv.a(MobileQQ.getContext());
    paramString = new HashMap();
    paramString.put("network", "" + i);
    paramString.put("status_code", "" + paramInt);
    bdmc.a(this.a).a(null, "subscription_htmloffline", true, 0L, 0L, paramString, "", false);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvb
 * JD-Core Version:    0.7.0.1
 */