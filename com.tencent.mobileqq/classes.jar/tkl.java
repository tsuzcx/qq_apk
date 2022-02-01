import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkl
  extends tkf
{
  tkl(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if ((paramString2 != null) && (paramString2.contains("kandianshare.html5.qq.com")))
    {
      tkc.a(this.a).mShareHelper.a(paramString2);
      return;
    }
    tkc.a(this.a).mShareHelper.a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkl
 * JD-Core Version:    0.7.0.1
 */