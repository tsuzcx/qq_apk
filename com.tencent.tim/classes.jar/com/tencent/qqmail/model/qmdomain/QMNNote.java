package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;

public class QMNNote
  extends QMDomain
{
  public static final int SIZE_LARGE = 3;
  public static final int SIZE_MEDIUM = 2;
  public static final int SIZE_ORIGINAL = 0;
  public static final int SIZE_SMALL = 1;
  public QMNoteAttachList attachList = new QMNoteAttachList();
  public String content;
  public boolean edit;
  public QMNNoteInformation information = new QMNNoteInformation();
  public boolean offline;
  public boolean read;
  public QMNNoteStatus status = new QMNNoteStatus();
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    Object localObject = paramJSONObject.getJSONObject("inf");
    if (localObject != null)
    {
      if (this.information == null)
      {
        this.information = ((QMNNoteInformation)QMNNoteInformation.fromDictionary((JSONObject)localObject, new QMNNoteInformation()));
        bool1 = true;
      }
    }
    else
    {
      localObject = paramJSONObject.getJSONObject("st");
      if (localObject == null) {
        break label333;
      }
      if (this.status != null) {
        break label307;
      }
      this.status = ((QMNNoteStatus)QMNNoteStatus.fromDictionary((JSONObject)localObject, new QMNNoteStatus()));
      bool1 = true;
    }
    label307:
    label320:
    label333:
    for (;;)
    {
      label84:
      localObject = (String)paramJSONObject.get("cont");
      boolean bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (!((String)localObject).equals(this.content))
        {
          this.content = ((String)localObject);
          bool2 = true;
        }
      }
      localObject = paramJSONObject.getJSONObject("attlist");
      bool1 = bool2;
      if (localObject != null)
      {
        if (this.attachList != null) {
          break label320;
        }
        this.attachList = ((QMNoteAttachList)QMNoteAttachList.fromDictionary((JSONObject)localObject, new QMNoteAttachList()));
      }
      for (bool1 = true;; bool1 = this.attachList.parseWithDictionary((JSONObject)localObject))
      {
        localObject = getBoolean(paramJSONObject.get("rd"));
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((Boolean)localObject).booleanValue() != this.read)
          {
            this.read = ((Boolean)localObject).booleanValue();
            bool2 = true;
          }
        }
        localObject = getBoolean(paramJSONObject.get("edit"));
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((Boolean)localObject).booleanValue() != this.edit)
          {
            this.edit = ((Boolean)localObject).booleanValue();
            bool1 = true;
          }
        }
        paramJSONObject = getBoolean(paramJSONObject.get("offline"));
        bool2 = bool1;
        if (paramJSONObject != null)
        {
          bool2 = bool1;
          if (paramJSONObject.booleanValue() != this.offline)
          {
            this.offline = paramJSONObject.booleanValue();
            bool2 = true;
          }
        }
        return bool2;
        bool1 = this.information.parseWithDictionary((JSONObject)localObject);
        break;
        bool1 = this.status.parseWithDictionary((JSONObject)localObject);
        break label84;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"QMNNote\"");
    if (this.information != null) {
      localStringBuffer.append(",\"inf\":" + this.information.toString());
    }
    if (this.status != null) {
      localStringBuffer.append(",\"st\":" + this.status.toString());
    }
    if (this.content != null) {
      localStringBuffer.append(",\"cont\":\"" + this.content.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"") + "\"");
    }
    if (this.attachList != null) {
      localStringBuffer.append(",\"attlist\":" + this.attachList.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder().append(",\"rd\":\"");
    if (this.read)
    {
      str = "1";
      localStringBuffer.append(str + "\"");
      localStringBuilder = new StringBuilder().append(",\"edit\":\"");
      if (!this.edit) {
        break label327;
      }
      str = "1";
      label250:
      localStringBuffer.append(str + "\"");
      localStringBuilder = new StringBuilder().append(",\"offline\":\"");
      if (!this.offline) {
        break label333;
      }
    }
    label327:
    label333:
    for (String str = "1";; str = "0")
    {
      localStringBuffer.append(str + "\"");
      localStringBuffer.append("}");
      return localStringBuffer.toString();
      str = "0";
      break;
      str = "0";
      break label250;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMNNote
 * JD-Core Version:    0.7.0.1
 */