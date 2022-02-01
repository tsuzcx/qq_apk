import android.app.Activity;
import android.content.ClipboardManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class txu
  extends txt
{
  txu(txq paramtxq1, Activity paramActivity, txq paramtxq2, JSONObject paramJSONObject)
  {
    super(paramtxq1, paramActivity, paramtxq2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString1);
    znl.a(2, 2131691266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txu
 * JD-Core Version:    0.7.0.1
 */