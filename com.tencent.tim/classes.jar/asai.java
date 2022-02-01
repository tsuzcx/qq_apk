import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.export.js.VipDownloadInterface;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asai
  implements arzf
{
  public asai(VipDownloadInterface paramVipDownloadInterface) {}
  
  public void F(int paramInt, String paramString)
  {
    arwt.e(this.this$0.TAG, "getQueryDownloadAction onException code = " + paramInt + " msg= ");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      paramString = "javascript:publicAccountDownload.queryProcess(" + localJSONObject.toString() + ")";
      this.this$0.jsCallBack(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void bl(List<DownloadInfo> paramList)
  {
    arwt.v(this.this$0.TAG, "getQueryDownloadAction onResult = " + paramList.size());
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
    paramList = "javascript:publicAccountDownload.queryProcess(" + localJSONArray.toString() + ")";
    arwt.v(this.this$0.TAG, "getQueryDownloadAction callback url = " + paramList);
    this.this$0.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asai
 * JD-Core Version:    0.7.0.1
 */