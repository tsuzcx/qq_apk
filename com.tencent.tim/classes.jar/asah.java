import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.export.js.VipDownloadInterface;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asah
  implements arzf
{
  public asah(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void F(int paramInt, String paramString)
  {
    arwt.e(this.this$0.TAG, "getQueryDownloadAction ERROR");
  }
  
  public void bl(List<DownloadInfo> paramList)
  {
    arwt.d(this.this$0.TAG, "getQueryDownloadAction onResult = " + paramList.size());
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
          localJSONObject.put("pro", localDownloadInfo.progress);
          localJSONObject.put("state", localDownloadInfo.getState());
          localJSONObject.put("ismyapp", localDownloadInfo.downloadType);
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
    arwt.d(this.this$0.TAG, "querySucess : " + paramList);
    this.this$0.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asah
 * JD-Core Version:    0.7.0.1
 */