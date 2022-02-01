import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkp
  extends tkf
{
  tkp(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
      paramString1.putExtra("uin", paramString3);
      paramString1.putExtra("from_js", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */