import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class txx
  extends txt
{
  txx(txq paramtxq1, Activity paramActivity, txq paramtxq2, JSONObject paramJSONObject)
  {
    super(paramtxq1, paramActivity, paramtxq2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      paramString1.putExtra("uin", paramString3);
      paramString1.putExtra("uintype", 0);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txx
 * JD-Core Version:    0.7.0.1
 */