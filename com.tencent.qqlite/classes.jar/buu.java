import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class buu
  implements FileManagerUtil.TipsClickedInterface
{
  public buu(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void a(View paramView)
  {
    int i = SharedPreUtils.a(GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).a(), "renewal_tail_tip_exit");
    ReportController.b(GrayTipsItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), "CliOper", "", GrayTipsItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).jdField_a_of_type_JavaLangString, "aio_pay", "aio_payclk", 0, 0, "" + i, "", "", "");
    paramView = new JSONObject();
    try
    {
      paramView.put("userId", GrayTipsItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder).a());
      paramView.put("openMonth", 1);
      paramView.put("aid", "mvip.gexinghua.android.aio_pay");
      paramView.put("offerId", "1450000515");
      paramView.put("serviceName", this.jdField_a_of_type_JavaLangString);
      paramView.put("serviceCode", this.b);
      paramView = paramView.toString();
      PayBridgeActivity.a((Activity)GrayTipsItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder), paramView, 4, "AioVIP");
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     buu
 * JD-Core Version:    0.7.0.1
 */