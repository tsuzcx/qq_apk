import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class apkm
  extends apku
{
  public boolean mIsPlaying;
  public String mPath;
  public int mSize;
  public int mTime;
  public String mTroopUin;
  public String mUrl;
  
  public apkm(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.mPath = paramString1;
    this.mUrl = paramString2;
    this.mTime = paramInt1;
    this.mSize = paramInt2;
    this.mTroopUin = paramString3;
    if (TextUtils.isEmpty(this.mUrl)) {}
    for (this.mUploadStatus = 0;; this.mUploadStatus = 3)
    {
      this.mData = new JSONObject();
      try
      {
        this.mData.put("type", "voice");
        if (!TextUtils.isEmpty(this.mPath)) {
          this.mData.put("path", this.mPath);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
          this.mData.put("url", this.mUrl);
        }
        if (this.mTime > 0) {
          this.mData.put("time", this.mTime);
        }
        if (this.mSize > 0) {
          this.mData.put("size", this.mSize);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public apkm(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
  }
  
  public boolean aBi()
  {
    return jqc.isValidUrl(this.mUrl);
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mData = paramJSONObject;
    this.mPath = paramJSONObject.optString("path");
    this.mUrl = paramJSONObject.optString("url");
    this.mTime = paramJSONObject.optInt("time");
    this.mSize = paramJSONObject.optInt("size");
    if (TextUtils.isEmpty(this.mUrl))
    {
      this.mUploadStatus = 0;
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
    return 3;
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
    try
    {
      this.mData.put("path", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
    try
    {
      this.mData.put("url", paramString);
      if (TextUtils.isEmpty(this.mUrl))
      {
        this.mUploadStatus = 0;
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      this.mUploadStatus = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkm
 * JD-Core Version:    0.7.0.1
 */