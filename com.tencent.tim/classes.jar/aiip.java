import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.io.File;
import org.json.JSONObject;

public class aiip
  implements aolm.b
{
  public aiip(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mErrCode == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AECameraPlugin.a(this.this$0, 2);
      paramaomh = AECameraPlugin.a(this.this$0, this.val$videoUrl, "downloading succeeded");
      this.this$0.callJs(this.val$callbackId, new String[] { paramaomh.toString() });
      if (AECameraPlugin.bo(this.this$0.mRuntime.getActivity())) {
        rox.a(BaseApplicationImpl.getApplication(), new File(this.axN));
      }
      return;
    }
    AECameraPlugin.a(this.this$0, 3);
    paramaomh = AECameraPlugin.b(this.this$0, this.val$videoUrl, "downloading failed");
    this.this$0.callJs(this.val$callbackId, new String[] { paramaomh.toString() });
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiip
 * JD-Core Version:    0.7.0.1
 */