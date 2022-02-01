import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkh
  extends tkf
{
  tkh(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = null;
    if (paramActionSheetItem.action == 72) {
      paramString1 = paramActionSheetItem.uin;
    }
    tkc.a(this.jdField_a_of_type_Tkc).mShareUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, paramInt, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkh
 * JD-Core Version:    0.7.0.1
 */