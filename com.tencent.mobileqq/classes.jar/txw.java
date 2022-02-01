import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class txw
  extends txt
{
  txw(txq paramtxq1, Activity paramActivity, txq paramtxq2, JSONObject paramJSONObject)
  {
    super(paramtxq1, paramActivity, paramtxq2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = (QQAppInterface)pkh.a();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getAccount();
      paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
      paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
      bmad.a(0, paramString2, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, paramString3, paramActionSheetItem, null, null, false, -1L).c(paramString1).b(this.jdField_a_of_type_AndroidAppActivity, paramString1, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txw
 * JD-Core Version:    0.7.0.1
 */