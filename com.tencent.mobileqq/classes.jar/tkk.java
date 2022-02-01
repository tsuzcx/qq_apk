import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.JuBaoAction.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkk
  extends tkf
{
  tkk(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ThreadManager.executeOnSubThread(new SheetItemClickProcessor.JuBaoAction.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkk
 * JD-Core Version:    0.7.0.1
 */