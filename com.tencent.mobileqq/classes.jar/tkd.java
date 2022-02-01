import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkd
  extends tkf
{
  tkd(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, paramString3, null, 3096, 1, this.jdField_a_of_type_OrgJsonJSONObject.optString("nick_name"), null, null, null, null);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkd
 * JD-Core Version:    0.7.0.1
 */