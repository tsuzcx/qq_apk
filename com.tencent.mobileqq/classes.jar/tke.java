import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public class tke
  extends tkf
{
  tke(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramInt = this.jdField_a_of_type_OrgJsonJSONObject.optInt("from_page");
    if (paramString1.isEmpty())
    {
      QLog.e(tkc.a, 1, "click add video to topic fail, rowkey=" + paramString1);
      return;
    }
    rha.b(tkc.a(this.jdField_a_of_type_Tkc).getViolaInstance().getActivity(), paramString1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tke
 * JD-Core Version:    0.7.0.1
 */