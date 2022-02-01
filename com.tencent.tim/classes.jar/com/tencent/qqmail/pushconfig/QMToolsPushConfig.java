package com.tencent.qqmail.pushconfig;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;
import org.apache.commons.lang3.StringUtils;

public class QMToolsPushConfig
  extends QMPushConfig
{
  private static final String TAG = "QMToolsPushConfig";
  private String schema;
  
  public QMToolsPushConfig(QMPushConfig paramQMPushConfig)
  {
    super(paramQMPushConfig);
  }
  
  public String getSchema()
  {
    return this.schema;
  }
  
  public void parseWithDictionary()
  {
    try
    {
      if (!StringUtils.isBlank(this.content))
      {
        JSONObject localJSONObject = JSONObject.parseObject(this.content);
        String str = "";
        if (localJSONObject.getString("schema") != null) {
          str = localJSONObject.getString("schema");
        }
        setSchema(str);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMToolsPushConfig", localException.getMessage());
    }
  }
  
  public void setSchema(String paramString)
  {
    this.schema = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMToolsPushConfig
 * JD-Core Version:    0.7.0.1
 */