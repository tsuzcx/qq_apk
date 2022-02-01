import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.JuBaoAction.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tpl
  extends tpg
{
  tpl(tpd paramtpd1, Activity paramActivity, tpd paramtpd2, JSONObject paramJSONObject)
  {
    super(paramtpd1, paramActivity, paramtpd2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ThreadManager.executeOnSubThread(new SheetItemClickProcessor.JuBaoAction.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */