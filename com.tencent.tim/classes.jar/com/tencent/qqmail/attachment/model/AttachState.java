package com.tencent.qqmail.attachment.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import com.tencent.qqmail.utilities.common.CommUtils;

public class AttachState
  extends QMDomain
{
  private static final long serialVersionUID = -8514747147951612555L;
  private int attr;
  private String downloadSize = "0";
  private long downloadSizeByte = 0L;
  private String isDownload = "0";
  private boolean isFavLocal = false;
  private String keyName;
  
  public static long getSerialVersionUID()
  {
    return -8514747147951612555L;
  }
  
  public int getAttr()
  {
    return this.attr;
  }
  
  public String getDownloadSize()
  {
    return this.downloadSize;
  }
  
  public long getDownloadSizeByte()
  {
    return this.downloadSizeByte;
  }
  
  public String getIsDownload()
  {
    return this.isDownload;
  }
  
  public String getKeyName()
  {
    return this.keyName;
  }
  
  public boolean isFavLocal()
  {
    return this.isFavLocal;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    String str = paramJSONObject.getString("isdownload");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (CommUtils.isNullorBlankorNotEquals(getIsDownload(), str))
      {
        setIsDownload(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("key");
    bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (CommUtils.isNullorBlankorNotEquals(getKeyName(), str))
      {
        setKeyName(str);
        bool2 = true;
      }
    }
    paramJSONObject = paramJSONObject.getString("dsz");
    bool1 = bool2;
    if (paramJSONObject != null)
    {
      bool1 = bool2;
      if (CommUtils.isNullorBlankorNotEquals(getDownloadSize(), paramJSONObject))
      {
        setDownloadSize(paramJSONObject);
        bool1 = true;
      }
    }
    int j = getAttr();
    int i = j;
    if (isFavLocal()) {
      i = j | 0x40;
    }
    setAttr(i);
    return bool1;
  }
  
  public void setAttr(int paramInt)
  {
    this.attr = paramInt;
  }
  
  public void setDownloadSize(String paramString)
  {
    this.downloadSize = paramString;
  }
  
  public void setDownloadSizeByte(long paramLong)
  {
    this.downloadSizeByte = paramLong;
  }
  
  public void setIsDownload(String paramString)
  {
    this.isDownload = paramString;
  }
  
  public void setIsFavLocal(boolean paramBoolean)
  {
    this.isFavLocal = paramBoolean;
  }
  
  public void setKeyName(String paramString)
  {
    this.keyName = paramString;
  }
  
  public String toPlainString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (getIsDownload() != null) {
      localStringBuilder.append("\"download\":\"" + getIsDownload() + "\",");
    }
    if (getKeyName() != null) {
      localStringBuilder.append("\"key\":\"" + getKeyName() + "\",");
    }
    if (getDownloadSize() != null) {
      localStringBuilder.append("\"dsz\":\"" + getDownloadSize() + "\",");
    }
    int i = localStringBuilder.length() - 1;
    if (localStringBuilder.charAt(i) == ',') {
      localStringBuilder.deleteCharAt(i);
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"AttachState\",");
    if (getIsDownload() != null) {
      localStringBuilder.append("\"download\":\"" + getIsDownload() + "\",");
    }
    if (getKeyName() != null) {
      localStringBuilder.append("\"key\":\"" + getKeyName() + "\",");
    }
    if (getDownloadSize() != null) {
      localStringBuilder.append("\"dsz\":\"" + getDownloadSize() + "\",");
    }
    int i = localStringBuilder.length() - 1;
    if (localStringBuilder.charAt(i) == ',') {
      localStringBuilder.deleteCharAt(i);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.AttachState
 * JD-Core Version:    0.7.0.1
 */