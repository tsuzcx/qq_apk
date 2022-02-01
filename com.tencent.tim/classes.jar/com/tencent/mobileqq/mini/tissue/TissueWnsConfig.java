package com.tencent.mobileqq.mini.tissue;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

public class TissueWnsConfig
{
  public static final String LOG_TAG = "TissueWnsConfig";
  
  public static BaseLibInfo getBaseLibInfo()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "tissue_baselib_url", QzoneConfig.DEFAULT_TISSUE_BASELIB_URL);
    QLog.i("TissueWnsConfig", 1, "getBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("TissueWnsConfig", 1, "getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static BaseLibInfo getQFlutterSoInfo()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "tissue_qflutter_url", QzoneConfig.DEFAULT_QFLUTTER_URL);
    QLog.i("TissueWnsConfig", 1, "getQFlutterSoInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("TissueWnsConfig", 1, "getWnsQFlutterSoUrl failed", localException);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tissue.TissueWnsConfig
 * JD-Core Version:    0.7.0.1
 */