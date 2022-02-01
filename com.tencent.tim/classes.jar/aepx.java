import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aepx
  implements aehx<String>, aepj
{
  static boolean bVK = true;
  static boolean bVL = true;
  private long WD = 20971520L;
  private ExcitingTransferDownloadConfig a = new ExcitingTransferDownloadConfig();
  public String byc = "";
  private boolean mEnable;
  
  private void ba(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.mEnable = paramJSONObject.getBoolean("enableaqq");
        paramJSONObject = paramJSONObject.getJSONObject("config");
        if (paramJSONObject == null) {
          break label221;
        }
        if (paramJSONObject.has("oneslicesize"))
        {
          this.a.mSliceSize = paramJSONObject.getLong("oneslicesize");
          this.a.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
          this.a.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
          this.a.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
          this.a.uSpeedDuration = paramJSONObject.getInt("speedduration");
          this.WD = paramJSONObject.getInt("limitedsize");
          if (paramJSONObject.has("slicenum"))
          {
            this.a.uSliceNum = paramJSONObject.getInt("slicenum");
            QLog.i("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "parse Exciting-C2C-Download config: enable:" + this.mEnable + " LimitedSize:" + this.WD + " " + this.a.toString());
          }
        }
        else
        {
          this.a.mSliceSize = 524288L;
          continue;
        }
        this.a.uSliceNum = 10;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
        return;
      }
      continue;
      label221:
      this.WD = 20971520L;
      this.a = new ExcitingTransferDownloadConfig();
    }
  }
  
  private void cXn()
  {
    this.WD = 20971520L;
    this.mEnable = false;
    this.a = new ExcitingTransferDownloadConfig();
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    return this.a;
  }
  
  public boolean ahs()
  {
    return this.mEnable;
  }
  
  public long fx()
  {
    return this.WD;
  }
  
  public void lR(String paramString)
  {
    int k = 0;
    this.byc = paramString.toLowerCase();
    if (TextUtils.isEmpty(this.byc))
    {
      QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      cXn();
      return;
    }
    try
    {
      paramString = new JSONObject(this.byc);
      if (paramString.length() == 0)
      {
        QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
        cXn();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      return;
    }
    JSONArray localJSONArray = paramString.names();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.getString(i).trim();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("download");
          if (localObject != null)
          {
            ba((JSONObject)localObject);
            j = 1;
          }
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent no Exciting-C2C-Download config, use default value");
        cXn();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepx
 * JD-Core Version:    0.7.0.1
 */