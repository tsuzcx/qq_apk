import android.view.View;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class upi
  implements bkzq
{
  public upi(SubscriptFeedsActivity paramSubscriptFeedsActivity, String paramString, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    uqx.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity, null);
    paramInt = uuc.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString);
    alik.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app.getMessageFacade().setReaded(this.jdField_a_of_type_JavaLangString, 1008);
    olh.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
    paramView = SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity).iterator();
    uqv localuqv;
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
      localuqv = (uqv)paramView.next();
    } while ((localuqv.jdField_a_of_type_JavaLangString == null) || (!localuqv.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)));
    for (paramInt = localuqv.b;; paramInt = 0)
    {
      bdla.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80064CF", "0X80064CF", 0, 0, "" + paramInt, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upi
 * JD-Core Version:    0.7.0.1
 */