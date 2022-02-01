import android.view.View;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class ubl
  implements bjoe
{
  public ubl(SubscriptFeedsActivity paramSubscriptFeedsActivity, String paramString, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
    }
    uda.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity, null);
    paramInt = ugf.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString);
    akms.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app.getMessageFacade().setReaded(this.jdField_a_of_type_JavaLangString, 1008);
    odq.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
    paramView = SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity).iterator();
    ucy localucy;
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
      localucy = (ucy)paramView.next();
    } while ((localucy.jdField_a_of_type_JavaLangString == null) || (!localucy.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)));
    for (paramInt = localucy.b;; paramInt = 0)
    {
      bcef.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80064CF", "0X80064CF", 0, 0, "" + paramInt, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubl
 * JD-Core Version:    0.7.0.1
 */