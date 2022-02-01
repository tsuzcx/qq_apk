import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aepz
  implements aehx<String>, aepk
{
  static boolean bVK = true;
  static boolean bVL = true;
  private long WD = 20971520L;
  private ExcitingTransferUploadChnConfigInfo a = new ExcitingTransferUploadChnConfigInfo();
  public String byc = "";
  private boolean mEnable;
  
  private void bb(JSONObject paramJSONObject)
  {
    try
    {
      this.mEnable = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      if (paramJSONObject != null)
      {
        this.a.uMuliFileSizeLimit = paramJSONObject.getLong("mulifilesizelimit");
        this.a.uMaxChannelNum = paramJSONObject.getInt("maxchannelnum");
        this.a.uPieceSize = paramJSONObject.getInt("piecesize");
        this.a.nMaxEachHostTotalUseCount = paramJSONObject.getInt("maxeachhosttotalusecount");
        this.a.nMaxEachHostErrorCount = paramJSONObject.getInt("maxeachhosterrorcount");
        this.a.nMaxEachHostParallelUseCount = paramJSONObject.getInt("maxeachhostparallelusecount");
        this.a.nConnectTimeout = paramJSONObject.getLong("connecttimeout");
        this.a.nDataTimeout = paramJSONObject.getLong("datatimeout");
        this.a.nTotoalDataTimeout = paramJSONObject.getLong("totoaldatatimeout");
        this.WD = paramJSONObject.getLong("limitedsize");
      }
      for (;;)
      {
        QLog.i("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "parse Exciting-C2C-Upload config: enable:" + this.mEnable + " LimitedSize:" + this.WD + " " + this.a.toString());
        return;
        this.WD = 20971520L;
        this.a = new ExcitingTransferUploadChnConfigInfo();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  private void cXn()
  {
    this.WD = 20971520L;
    this.mEnable = false;
    this.a = new ExcitingTransferUploadChnConfigInfo();
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
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
      QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      cXn();
      return;
    }
    try
    {
      paramString = new JSONObject(this.byc);
      if (paramString.length() == 0)
      {
        QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
        cXn();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
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
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("upload");
          if (localObject != null)
          {
            bb((JSONObject)localObject);
            j = 1;
          }
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent no Exciting-C2C-Upload config, use default value");
        cXn();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepz
 * JD-Core Version:    0.7.0.1
 */