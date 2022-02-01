import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import org.json.JSONObject;

class arpd
  implements DialogInterface.OnClickListener
{
  arpd(arpb paramarpb, SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Arpb.this$0.k(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$GetAuthApiListResponse.ret.get(), this.val$json.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpd
 * JD-Core Version:    0.7.0.1
 */