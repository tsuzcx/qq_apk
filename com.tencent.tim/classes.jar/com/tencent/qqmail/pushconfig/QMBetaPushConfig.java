package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import org.apache.commons.lang3.StringUtils;

public class QMBetaPushConfig
  extends QMPushConfig
{
  private static final String TAG = "QMBetaPushConfig";
  private String betaVersion;
  private int clickType;
  private QMPushConfigDialog dialog;
  private String downloadUrl;
  private String notificationDesp;
  private String notificationTitle;
  private String notificationUrl;
  private boolean open;
  
  public QMBetaPushConfig(QMPushConfig paramQMPushConfig)
  {
    super(paramQMPushConfig);
  }
  
  public String getBetaVersion()
  {
    return this.betaVersion;
  }
  
  public int getClickType()
  {
    return this.clickType;
  }
  
  public QMPushConfigDialog getDialog()
  {
    return this.dialog;
  }
  
  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }
  
  public String getNotificationDesp()
  {
    return this.notificationDesp;
  }
  
  public String getNotificationTitle()
  {
    return this.notificationTitle;
  }
  
  public String getNotificationUrl()
  {
    return this.notificationUrl;
  }
  
  public boolean isOpen()
  {
    return this.open;
  }
  
  public void parseWithDictionary()
  {
    try
    {
      if (!StringUtils.isBlank(this.content))
      {
        Object localObject2 = JSONObject.parseObject(this.content);
        Object localObject1 = "";
        if (((JSONObject)localObject2).getString("version") != null) {
          localObject1 = ((JSONObject)localObject2).getString("version");
        }
        setBetaVersion((String)localObject1);
        if (((JSONObject)localObject2).getBoolean("open") != null) {}
        for (this.open = ((JSONObject)localObject2).getBoolean("open").booleanValue();; this.open = false)
        {
          localObject1 = "";
          if (((JSONObject)localObject2).getString("notificationTitle") != null) {
            localObject1 = ((JSONObject)localObject2).getString("notificationTitle");
          }
          setNotificationTitle((String)localObject1);
          localObject1 = "";
          if (((JSONObject)localObject2).getString("notificationDesp") != null) {
            localObject1 = ((JSONObject)localObject2).getString("notificationDesp");
          }
          setNotificationDesp((String)localObject1);
          localObject1 = "";
          if (((JSONObject)localObject2).getString("notificationUrl") != null) {
            localObject1 = ((JSONObject)localObject2).getString("notificationUrl");
          }
          setNotificationUrl((String)localObject1);
          if (((JSONObject)localObject2).getInteger("clickType") != null) {
            setClickType(((JSONObject)localObject2).getInteger("clickType").intValue());
          }
          localObject1 = "";
          if (((JSONObject)localObject2).getString("downloadUrl") != null) {
            localObject1 = ((JSONObject)localObject2).getString("downloadUrl");
          }
          setDownloadUrl((String)localObject1);
          localObject1 = ((JSONObject)localObject2).getJSONObject("featureDialog");
          localObject2 = new QMPushConfigDialog();
          if (localObject1 != null) {
            ((QMPushConfigDialog)localObject2).parseWithDictionary((JSONObject)localObject1);
          }
          setDialog((QMPushConfigDialog)localObject2);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMBetaPushConfig", localException.getMessage());
    }
  }
  
  public void setBetaVersion(String paramString)
  {
    this.betaVersion = paramString;
  }
  
  public void setClickType(int paramInt)
  {
    this.clickType = paramInt;
  }
  
  public void setDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    this.dialog = paramQMPushConfigDialog;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public void setNotificationDesp(String paramString)
  {
    this.notificationDesp = paramString;
  }
  
  public void setNotificationTitle(String paramString)
  {
    this.notificationTitle = paramString;
  }
  
  public void setNotificationUrl(String paramString)
  {
    this.notificationUrl = paramString;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.open = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMBetaPushConfig
 * JD-Core Version:    0.7.0.1
 */