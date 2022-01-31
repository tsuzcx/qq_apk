import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import org.json.JSONObject;

class hiq
  implements DialogInterface.OnClickListener
{
  hiq(hio paramhio, SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Hio.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$GetAuthApiListResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hiq
 * JD-Core Version:    0.7.0.1
 */