import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class toi
  implements DialogInterface.OnCancelListener
{
  public toi(BridgeModule paramBridgeModule, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 11)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.reportVideoShareClick(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, -1, -1, true, this.jdField_a_of_type_Int, this.c, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     toi
 * JD-Core Version:    0.7.0.1
 */