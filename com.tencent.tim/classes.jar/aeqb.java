import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class aeqb
  implements aehx<String>, aepl
{
  private long WE = 20971520L;
  private long WF = 20971520L;
  private ExcitingTransferDownloadConfig jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  private ExcitingTransferUploadChnConfigInfo jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
  private boolean bVM;
  private boolean bVN;
  public String byc = "";
  
  private void ba(JSONObject paramJSONObject)
  {
    try
    {
      this.bVM = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = paramJSONObject.getLong("slicesize");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSpeedDuration = paramJSONObject.getInt("speedduration");
      this.WE = paramJSONObject.getInt("limitedsize");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  private void bb(JSONObject paramJSONObject)
  {
    try
    {
      this.bVN = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = paramJSONObject.getLong("mulifilesizelimit");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMaxChannelNum = paramJSONObject.getInt("maxchannelnum");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uPieceSize = paramJSONObject.getInt("piecesize");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = paramJSONObject.getInt("maxeachhosttotalusecount");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = paramJSONObject.getInt("maxeachhosterrorcount");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = paramJSONObject.getInt("maxeachhostparallelusecount");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nConnectTimeout = paramJSONObject.getLong("connecttimeout");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nDataTimeout = paramJSONObject.getLong("datatimeout");
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nTotoalDataTimeout = paramJSONObject.getLong("totoaldatatimeout");
      this.WF = paramJSONObject.getLong("limitedsize");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  public ExcitingTransferDownloadConfig b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig;
  }
  
  public void lR(String paramString)
  {
    this.byc = paramString.toLowerCase();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(this.byc);
        if (paramString.length() == 0) {
          return;
        }
        JSONArray localJSONArray = paramString.names();
        i = 0;
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getString(i).trim();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label115;
          }
          localObject = paramString.optJSONObject((String)localObject);
          ((JSONObject)localObject).names();
          ba(((JSONObject)localObject).getJSONObject("download"));
          bb(((JSONObject)localObject).getJSONObject("upload"));
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      }
      return;
      label115:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqb
 * JD-Core Version:    0.7.0.1
 */