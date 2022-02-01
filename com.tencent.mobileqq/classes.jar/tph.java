import android.app.Activity;
import android.content.ClipboardManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tph
  extends tpg
{
  tph(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString1);
    zvc.a(2, 2131691142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tph
 * JD-Core Version:    0.7.0.1
 */