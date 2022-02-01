import com.tencent.open.appstore.js.DownloadInterfaceNew;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arwg
  implements arzf
{
  public arwg(DownloadInterfaceNew paramDownloadInterfaceNew, String paramString) {}
  
  public void F(int paramInt, String paramString)
  {
    arwt.e("DownloadInterfaceNew", "[innerQuery] [onException] errorCode=" + paramInt + ", errorMsg=" + paramString);
  }
  
  public void bl(List<DownloadInfo> paramList)
  {
    arwt.d("DownloadInterfaceNew", "[innerQuery] onResult = " + paramList.size());
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
          localJSONArray.put(localJSONObject);
          i += 1;
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
    paramList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.cCv + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    arwt.d("DownloadInterfaceNew", "[innerQuery] querySucess : " + paramList);
    DownloadInterfaceNew.a(this.this$0, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwg
 * JD-Core Version:    0.7.0.1
 */