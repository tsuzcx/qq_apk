import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class txv
  extends txt
{
  txv(txq paramtxq1, Activity paramActivity, txq paramtxq2, JSONObject paramJSONObject)
  {
    super(paramtxq1, paramActivity, paramtxq2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = null;
    if (paramActionSheetItem.action == 72) {
      paramString1 = paramActionSheetItem.uin;
    }
    txq.a(this.jdField_a_of_type_Txq).mShareUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, paramInt, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txv
 * JD-Core Version:    0.7.0.1
 */