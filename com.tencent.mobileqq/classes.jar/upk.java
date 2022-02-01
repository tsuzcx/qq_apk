import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.1;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.2;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.4;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.5;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.6;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class upk
  extends MqqHandler
{
  public upk(SubscriptFeedsActivity paramSubscriptFeedsActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1002: 
            try
            {
              paramMessage = uqx.a().b(this.a.app);
              this.a.runOnUiThread(new SubscriptFeedsActivity.14.1(this, paramMessage));
              return;
            }
            catch (Exception paramMessage) {}
          }
        } while (!QLog.isColorLevel());
        QLog.i("SubscriptFeedsActivity", 2, paramMessage.toString());
        return;
        this.a.runOnUiThread(new SubscriptFeedsActivity.14.2(this));
        return;
        paramMessage = paramMessage.getData();
      } while ((paramMessage == null) || (!bmhv.a()));
      paramMessage = paramMessage.getSerializable("ReadInJoyArticleList");
    } while ((paramMessage == null) || (!(paramMessage instanceof ArrayList)));
    if ((!SubscriptFeedsActivity.a(this.a, (ArrayList)paramMessage)) && (QLog.isColorLevel())) {
      QLog.d("SubscriptFeedsActivity", 2, "onGetRecommendReadInJoyArticleList data save to sp fail");
    }
    this.a.runOnUiThread(new SubscriptFeedsActivity.14.3(this, paramMessage));
    return;
    this.a.runOnUiThread(new SubscriptFeedsActivity.14.4(this));
    return;
    this.a.runOnUiThread(new SubscriptFeedsActivity.14.5(this));
    return;
    this.a.runOnUiThread(new SubscriptFeedsActivity.14.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upk
 * JD-Core Version:    0.7.0.1
 */