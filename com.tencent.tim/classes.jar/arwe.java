import android.text.TextUtils;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arwe
  implements arzf
{
  public arwe(DINewForCommonWebView paramDINewForCommonWebView, String paramString) {}
  
  public void F(int paramInt, String paramString)
  {
    arwt.e("DINewForCommonWebView", "[innerQuery] [onException] errorCode=" + paramInt + ", errorMsg=" + paramString);
  }
  
  public void bl(List<DownloadInfo> paramList)
  {
    arwt.d("DINewForCommonWebView", "[innerQuery] onResult = " + paramList.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.appId);
          localJSONObject.put("packagename", localDownloadInfo.packageName);
          localJSONObject.put("versioncode", localDownloadInfo.versionCode);
          localJSONObject.put("url", localDownloadInfo.urlStr);
          localJSONObject.put("pro", localDownloadInfo.progress);
          localJSONObject.put("state", localDownloadInfo.getState());
          localJSONObject.put("ismyapp", localDownloadInfo.downloadType);
          localJSONObject.put("download_from", localDownloadInfo.from);
          localJSONObject.put("writecodestate", localDownloadInfo.elm);
          if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
            localJSONObject.put("final_file_exits", "false");
          }
          for (;;)
          {
            localJSONArray.put(localJSONObject);
            i += 1;
            break;
            localJSONObject.put("final_file_exits", new File(localDownloadInfo.filePath).exists());
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramList = "javascript:" + this.val$callback + "(" + localJSONArray.toString() + ")";
    arwt.d("DINewForCommonWebView", "[innerQuery] querySucess : " + paramList);
    DINewForCommonWebView.a(this.this$0, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwe
 * JD-Core Version:    0.7.0.1
 */