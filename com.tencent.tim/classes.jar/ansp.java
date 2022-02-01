import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class ansp
  implements zxx.a
{
  ansp(anso paramanso, StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext) {}
  
  public void bL(Bundle paramBundle)
  {
    int i = paramBundle.getInt("retCode");
    String str = paramBundle.getString("retMsg");
    int j = paramBundle.getInt("payTime");
    paramBundle = paramBundle.getString("orderId");
    this.jdField_a_of_type_Anso.a.Vt(i);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.savePayInfo(this.val$context, this.jdField_a_of_type_Anso.a.cif, i);
    VACDReportUtil.a("ret_code=" + i + "|ret_str=" + str + "|pay_time=" + j + "|order_id=" + paramBundle, "qqwallet", "publicpaymsg.pay.result", null, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansp
 * JD-Core Version:    0.7.0.1
 */