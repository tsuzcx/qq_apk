import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tkm
  extends tkf
{
  tkm(tkc paramtkc1, Activity paramActivity, tkc paramtkc2, JSONObject paramJSONObject)
  {
    super(paramtkc1, paramActivity, paramtkc2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = tkc.a(this.a).mShareHelper.a(tkc.a(this.b), tkc.b(this.b), paramInt);
    if ((paramString1 instanceof udw)) {
      BridgeModule.saveImageToLocal(((udw)paramString1).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkm
 * JD-Core Version:    0.7.0.1
 */