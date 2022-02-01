import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import org.json.JSONObject;

class arpf
  implements DialogInterface.OnClickListener
{
  arpf(arpb paramarpb, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.this$0.k(this.b.ret.get(), this.val$json.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpf
 * JD-Core Version:    0.7.0.1
 */