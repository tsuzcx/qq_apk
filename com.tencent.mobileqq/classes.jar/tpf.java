import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public class tpf
  extends tpg
{
  tpf(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramInt = this.jdField_a_of_type_OrgJsonJSONObject.optInt("from_page");
    if (paramString1.isEmpty())
    {
      QLog.e(tpd.a, 1, "click add video to topic fail, rowkey=" + paramString1);
      return;
    }
    rjh.b(tpd.a(this.jdField_a_of_type_Tpd).getViolaInstance().getActivity(), paramString1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpf
 * JD-Core Version:    0.7.0.1
 */