package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import org.apache.commons.lang3.StringUtils;

public class QMUpgradePushConfig
  extends QMPushConfig
{
  private static final String TAG = "QMUpgradePushConfig";
  private int clickType;
  private QMPushConfigDialog featureDialog;
  private QMPushConfigDialog forceDialog;
  private int forceShowType;
  private int forceType;
  private String minVersion;
  private String upgradeVersion;
  private String url;
  private String webViewUrl;
  
  public QMUpgradePushConfig(QMPushConfig paramQMPushConfig)
  {
    super(paramQMPushConfig);
  }
  
  public int getClickType()
  {
    return this.clickType;
  }
  
  public QMPushConfigDialog getFeatureDialog()
  {
    return this.featureDialog;
  }
  
  public QMPushConfigDialog getForceDialog()
  {
    return this.forceDialog;
  }
  
  public int getForceShowType()
  {
    return this.forceShowType;
  }
  
  public int getForceType()
  {
    return this.forceType;
  }
  
  public String getMinVersion()
  {
    return this.minVersion;
  }
  
  public String getUpgradeVersion()
  {
    return this.upgradeVersion;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getWebViewUrl()
  {
    return this.webViewUrl;
  }
  
  public void parseWithDictionary()
  {
    try
    {
      if (!StringUtils.isBlank(this.content))
      {
        Object localObject2 = JSONObject.parseObject(this.content);
        if (localObject2 != null)
        {
          Object localObject1 = "";
          if (((JSONObject)localObject2).getString("version") != null) {
            localObject1 = ((JSONObject)localObject2).getString("version");
          }
          setUpgradeVersion((String)localObject1);
          localObject1 = "";
          if (((JSONObject)localObject2).getString("minVersion") != null) {
            localObject1 = ((JSONObject)localObject2).getString("minVersion");
          }
          setMinVersion((String)localObject1);
          if (((JSONObject)localObject2).getInteger("forceType") != null) {
            setForceType(((JSONObject)localObject2).getInteger("forceType").intValue());
          }
          if (((JSONObject)localObject2).getInteger("forceShowType") != null) {
            setForceShowType(((JSONObject)localObject2).getInteger("forceShowType").intValue());
          }
          localObject1 = "";
          if (((JSONObject)localObject2).getString("downloadUrl") != null) {
            localObject1 = ((JSONObject)localObject2).getString("downloadUrl");
          }
          setUrl((String)localObject1);
          localObject1 = "";
          if (((JSONObject)localObject2).getString("webViewUrl") != null) {
            localObject1 = ((JSONObject)localObject2).getString("webViewUrl");
          }
          setWebViewUrl((String)localObject1);
          if (((JSONObject)localObject2).getInteger("clickType") != null) {
            setClickType(((JSONObject)localObject2).getInteger("clickType").intValue());
          }
          localObject1 = ((JSONObject)localObject2).getJSONObject("featureDialog");
          QMPushConfigDialog localQMPushConfigDialog = new QMPushConfigDialog();
          if (localObject1 != null) {
            localQMPushConfigDialog.parseWithDictionary((JSONObject)localObject1);
          }
          setFeatureDialog(localQMPushConfigDialog);
          localObject1 = ((JSONObject)localObject2).getJSONObject("forceDialog");
          localObject2 = new QMPushConfigDialog();
          if (localObject1 != null) {
            ((QMPushConfigDialog)localObject2).parseWithDictionary((JSONObject)localObject1);
          }
          setForceDialog((QMPushConfigDialog)localObject2);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMUpgradePushConfig", localException.getMessage());
    }
  }
  
  public void setClickType(int paramInt)
  {
    this.clickType = paramInt;
  }
  
  public void setFeatureDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    this.featureDialog = paramQMPushConfigDialog;
  }
  
  public void setForceDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    this.forceDialog = paramQMPushConfigDialog;
  }
  
  public void setForceShowType(int paramInt)
  {
    this.forceShowType = paramInt;
  }
  
  public void setForceType(int paramInt)
  {
    this.forceType = paramInt;
  }
  
  public void setMinVersion(String paramString)
  {
    this.minVersion = paramString;
  }
  
  public void setUpgradeVersion(String paramString)
  {
    this.upgradeVersion = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWebViewUrl(String paramString)
  {
    this.webViewUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMUpgradePushConfig
 * JD-Core Version:    0.7.0.1
 */