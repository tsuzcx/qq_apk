import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tpi
  extends tpg
{
  tpi(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = null;
    if (paramActionSheetItem.action == 72) {
      paramString1 = paramActionSheetItem.uin;
    }
    tpd.a(this.jdField_a_of_type_Tpd).mShareUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, paramInt, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpi
 * JD-Core Version:    0.7.0.1
 */