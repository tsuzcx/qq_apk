import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.JuBaoAction.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class txy
  extends txt
{
  txy(txq paramtxq1, Activity paramActivity, txq paramtxq2, JSONObject paramJSONObject)
  {
    super(paramtxq1, paramActivity, paramtxq2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ThreadManager.executeOnSubThread(new SheetItemClickProcessor.JuBaoAction.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txy
 * JD-Core Version:    0.7.0.1
 */