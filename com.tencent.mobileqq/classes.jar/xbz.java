import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import cooperation.qwallet.plugin.QWalletHelper;
import org.json.JSONObject;

public class xbz
  implements Runnable
{
  public xbz(TransactionActivity paramTransactionActivity) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = QWalletHelper.loadUnifiedConfig(TransactionActivity.a(this.a));
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject("qpayment");
        if (localJSONObject != null)
        {
          TransactionActivity.a(this.a, localJSONObject.optInt("large_transfer_remind_fee"));
          TransactionActivity.a(this.a, localJSONObject.optString("large_transfer_remind_msg"));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbz
 * JD-Core Version:    0.7.0.1
 */