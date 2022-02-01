import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class tkr
  extends tkf
{
  tkr(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("topicId", "");
    paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("title", "");
    if (!TextUtils.isEmpty(paramString2))
    {
      tkc.a(this.jdField_a_of_type_Tkc).rijWatchWordPresenter.a(paramString2, paramString1, paramString3, paramActionSheetItem);
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      tkc.a(this.jdField_a_of_type_Tkc).rijWatchWordPresenter.a(paramString3, paramString1, paramActionSheetItem);
      return;
    }
    QLog.e(tkc.a, 1, "args is illegal: " + this.jdField_a_of_type_OrgJsonJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */