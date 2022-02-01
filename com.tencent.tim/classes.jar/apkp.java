import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apkp
  extends apku
  implements apkr
{
  public List<Integer> HW = Collections.EMPTY_LIST;
  public awjs.c a;
  public long arE;
  public int bGG;
  public String bIS;
  public int clt;
  public String cpK;
  public String cpO;
  public String cpP;
  public int dUH;
  public int dUR = -1;
  public String mDesc;
  public int mDownloadStatus = 0;
  public String mFilePath;
  public boolean mIsPlaying;
  public String mTroopUin;
  
  public apkp(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
  }
  
  public static JSONObject a(apkp paramapkp)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject().put("type", "recite").put("troop_uin", paramapkp.mTroopUin).put("subtype", 1).put("title", paramapkp.cpO).put("desc", paramapkp.mDesc).put("kid", paramapkp.cpK).put("error_count", paramapkp.clt).put("remind_count", paramapkp.dUH).put("waste_time", paramapkp.arE).put("grade", paramapkp.dUR).put("lyric", paramapkp.cpP);
    if (!TextUtils.isEmpty(paramapkp.bIS)) {
      localJSONObject.put("file_url", paramapkp.bIS);
    }
    if (!TextUtils.isEmpty(paramapkp.mFilePath)) {
      localJSONObject.put("file_path", paramapkp.mFilePath);
    }
    if (paramapkp.HW != null) {
      localJSONObject.put("pid_list", new JSONArray(paramapkp.HW));
    }
    return localJSONObject;
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, List<Integer> paramList)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131707345)).append(paramString2);
    if ((paramList != null) && (!paramList.isEmpty())) {
      localStringBuilder.append(apka.R(paramList));
    }
    paramString1 = new JSONObject().put("type", "recite").put("troop_uin", paramString1).put("subtype", 2).put("title", paramString2).put("desc", localStringBuilder.toString()).put("kid", paramString3);
    if (paramList != null) {
      paramString1.put("pid_list", new JSONArray(paramList));
    }
    return paramString1;
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, int paramInt)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131707347)).append(paramString2);
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() != paramInt)) {
      localStringBuilder.append(apka.R(paramList));
    }
    paramString1 = new JSONObject().put("type", "recite").put("troop_uin", paramString1).put("subtype", 2).put("title", paramString2).put("desc", localStringBuilder.toString()).put("kid", paramString3);
    if (paramList != null) {
      paramString1.put("pid_list", new JSONArray(paramList));
    }
    return paramString1;
  }
  
  public int Lv()
  {
    if (this.mUploadStatus == 3) {
      return 1;
    }
    return 0;
  }
  
  public void SX(String paramString)
  {
    super.SX(paramString);
    try
    {
      bN(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mData = paramJSONObject;
    this.bGG = paramJSONObject.optInt("subtype");
    this.cpK = paramJSONObject.optString("kid");
    this.cpO = paramJSONObject.optString("title");
    this.mDesc = paramJSONObject.optString("desc");
    this.clt = paramJSONObject.optInt("error_count");
    this.dUH = paramJSONObject.optInt("remind_count");
    this.arE = paramJSONObject.optLong("waste_time");
    this.mFilePath = paramJSONObject.optString("file_path");
    this.bIS = paramJSONObject.optString("file_url");
    this.dUR = paramJSONObject.optInt("grade", -1);
    this.mTroopUin = paramJSONObject.optString("troop_uin");
    this.cpP = paramJSONObject.optString("lyric");
    paramJSONObject = paramJSONObject.optJSONArray("pid_list");
    if (paramJSONObject != null)
    {
      int j = paramJSONObject.length();
      if (j != 0)
      {
        this.HW = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          this.HW.add(Integer.valueOf(paramJSONObject.getInt(i)));
          i += 1;
        }
      }
    }
    else
    {
      this.HW = Collections.EMPTY_LIST;
    }
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HWReciteInfo", 2, "cancel uploadFileTask");
      }
      this.a.cancel();
      this.a = null;
    }
    if (this.bGG == 1)
    {
      if (TextUtils.isEmpty(this.bIS)) {
        this.mUploadStatus = 0;
      }
    }
    else {
      return;
    }
    this.mUploadStatus = 3;
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public void setUrl(String paramString)
  {
    this.bIS = paramString;
    try
    {
      this.mData.put("file_url", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkp
 * JD-Core Version:    0.7.0.1
 */