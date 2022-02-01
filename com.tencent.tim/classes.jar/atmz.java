import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class atmz
  implements DialogInterface.OnClickListener
{
  public atmz(WpsFilePreviewFragment paramWpsFilePreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("sha", WpsFilePreviewFragment.e(this.a));
      paramDialogInterface.put("auto", false);
      WpsFilePreviewFragment.a(this.a).dispatchJsEvent("downloadFile", paramDialogInterface, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(WpsFilePreviewFragment.TAG, 1, localJSONException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmz
 * JD-Core Version:    0.7.0.1
 */