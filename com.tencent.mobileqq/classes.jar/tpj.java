import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tpj
  extends tpg
{
  tpj(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = (QQAppInterface)pha.a();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getAccount();
      paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
      paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
      bljl.a(0, paramString2, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, paramString3, paramActionSheetItem, null, null, false, -1L).c(paramString1).b(this.jdField_a_of_type_AndroidAppActivity, paramString1, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpj
 * JD-Core Version:    0.7.0.1
 */