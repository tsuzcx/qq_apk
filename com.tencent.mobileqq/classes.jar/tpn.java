import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tpn
  extends tpg
{
  tpn(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = tpd.a(this.a).mShareHelper.a(tpd.a(this.b), tpd.b(this.b), paramInt);
    if ((paramString1 instanceof txe))
    {
      paramString1 = ((txe)paramString1).b;
      tpd.a(this.a);
      BridgeModule.saveImageToLocal(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpn
 * JD-Core Version:    0.7.0.1
 */