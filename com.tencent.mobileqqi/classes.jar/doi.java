import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.troop.activity.TroopAssistantFeedsActivity;
import com.tencent.qphone.base.util.QLog;

public class doi
  implements View.OnClickListener
{
  public doi(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.a >= 1500L) {}
    try
    {
      this.a.e();
      paramView = new Intent(this.a, TroopAssistantFeedsActivity.class);
      paramView.putExtra("url", "http://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200");
      paramView.putExtra("webStyle", "noBottomBar");
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("isShowAd", false);
      this.a.startActivity(paramView);
      this.a.a = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick, url:http://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200");
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopAssistantFeedsJsHandler", 2, "feedsTitle onClick:" + paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doi
 * JD-Core Version:    0.7.0.1
 */