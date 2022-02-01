package com.tencent.qqmail.attachment.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AttachmentUI
  extends QMDomain
  implements Cloneable
{
  public static final String TYPE_BACK = "back";
  public static final String TYPE_COMPRESSED = "compressed";
  public static final String TYPE_DIR = "dir";
  public static final String TYPE_FILE = "file";
  private static final long serialVersionUID = -123312332738993475L;
  private String Type;
  private List<AttachmentUI> attachmentUIs = new ArrayList();
  private int dirFileCount;
  private String dirName;
  private String dirPath;
  private String downHost;
  private String iviewType;
  private String keyName;
  private String size;
  private String urlEncodeDirName;
  private String urlEncodeDirPath;
  private String urlEncodeFullPath;
  private String vKey;
  private String viewType;
  private String zipFileName;
  
  public Object clone()
    throws CloneNotSupportedException
  {
    try
    {
      AttachmentUI localAttachmentUI = (AttachmentUI)super.clone();
      return localAttachmentUI;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public List<AttachmentUI> getAttachmentUIs()
  {
    return this.attachmentUIs;
  }
  
  public int getDirFileCount()
  {
    return this.dirFileCount;
  }
  
  public String getDirName()
  {
    return this.dirName;
  }
  
  public String getDirPath()
  {
    return this.dirPath;
  }
  
  public String getDownHost()
  {
    return this.downHost;
  }
  
  public String getIviewType()
  {
    return this.iviewType;
  }
  
  public String getKeyName()
  {
    return this.keyName;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getType()
  {
    return this.Type;
  }
  
  public String getUrlEncodeDirName()
  {
    return this.urlEncodeDirName;
  }
  
  public String getUrlEncodeDirPath()
  {
    return this.urlEncodeDirPath;
  }
  
  public String getUrlEncodeFullPath()
  {
    return this.urlEncodeFullPath;
  }
  
  public String getViewType()
  {
    return this.viewType;
  }
  
  public String getZipFileName()
  {
    return this.zipFileName;
  }
  
  public String getvKey()
  {
    return this.vKey;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    String str = paramJSONObject.getString("keyname");
    boolean bool1 = bool2;
    if (str != null) {
      if (getKeyName() != "")
      {
        bool1 = bool2;
        if (getKeyName() == str) {}
      }
      else
      {
        setKeyName(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("zipname");
    bool2 = bool1;
    if (str != null) {
      if (getZipFileName() != "")
      {
        bool2 = bool1;
        if (getZipFileName() == str) {}
      }
      else
      {
        setZipFileName(str);
        bool2 = true;
      }
    }
    str = paramJSONObject.getString("type");
    bool1 = bool2;
    if (str != null) {
      if (getType() != "")
      {
        bool1 = bool2;
        if (getType() == str) {}
      }
      else
      {
        setType(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("iviewtype");
    bool2 = bool1;
    if (str != null) {
      if (getIviewType() != "")
      {
        bool2 = bool1;
        if (getIviewType() == str) {}
      }
      else
      {
        setIviewType(str);
        bool2 = true;
      }
    }
    str = paramJSONObject.getString("viewtype");
    bool1 = bool2;
    if (str != null) {
      if (getViewType() != "")
      {
        bool1 = bool2;
        if (getViewType() == str) {}
      }
      else
      {
        setViewType(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("sz");
    bool2 = bool1;
    if (str != null) {
      if (getSize() != "")
      {
        bool2 = bool1;
        if (getSize() == str) {}
      }
      else
      {
        setSize(str);
        bool2 = true;
      }
    }
    str = paramJSONObject.getString("key");
    bool1 = bool2;
    if (str != null) {
      if (getKeyName() != "")
      {
        bool1 = bool2;
        if (getKeyName() == str) {}
      }
      else
      {
        setKeyName(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("dirname");
    bool2 = bool1;
    if (str != null) {
      if (getDirName() != "")
      {
        bool2 = bool1;
        if (getDirName() == str) {}
      }
      else
      {
        setDirName(str);
        bool2 = true;
      }
    }
    str = paramJSONObject.getString("dirpath");
    bool1 = bool2;
    if (str != null) {
      if (getDirPath() != "")
      {
        bool1 = bool2;
        if (getDirPath() == str) {}
      }
      else
      {
        setDirPath(str);
        bool1 = true;
      }
    }
    str = paramJSONObject.getString("redn");
    bool2 = bool1;
    if (str != null) {
      if (getUrlEncodeDirName() != "")
      {
        bool2 = bool1;
        if (getUrlEncodeDirName() == str) {}
      }
      else
      {
        setUrlEncodeDirName(str);
        bool2 = true;
      }
    }
    str = paramJSONObject.getString("uedp");
    bool1 = bool2;
    if (str != null) {
      if (getUrlEncodeDirPath() != "")
      {
        bool1 = bool2;
        if (getUrlEncodeDirPath() == str) {}
      }
      else
      {
        setUrlEncodeDirPath(str);
        bool1 = true;
      }
    }
    paramJSONObject = paramJSONObject.getString("uefp");
    bool2 = bool1;
    if (paramJSONObject != null) {
      if (getUrlEncodeFullPath() != "")
      {
        bool2 = bool1;
        if (getUrlEncodeFullPath() == paramJSONObject) {}
      }
      else
      {
        setUrlEncodeFullPath(paramJSONObject);
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void setAttachmentUIs(List<AttachmentUI> paramList)
  {
    this.attachmentUIs = paramList;
  }
  
  public void setDirFileCount(int paramInt)
  {
    this.dirFileCount = paramInt;
  }
  
  public void setDirName(String paramString)
  {
    this.dirName = paramString;
  }
  
  public void setDirPath(String paramString)
  {
    this.dirPath = paramString;
  }
  
  public void setDownHost(String paramString)
  {
    this.downHost = paramString;
  }
  
  public void setIviewType(String paramString)
  {
    this.iviewType = paramString;
  }
  
  public void setKeyName(String paramString)
  {
    this.keyName = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setType(String paramString)
  {
    this.Type = paramString;
  }
  
  public void setUrlEncodeDirName(String paramString)
  {
    this.urlEncodeDirName = paramString;
  }
  
  public void setUrlEncodeDirPath(String paramString)
  {
    this.urlEncodeDirPath = paramString;
  }
  
  public void setUrlEncodeFullPath(String paramString)
  {
    this.urlEncodeFullPath = paramString;
  }
  
  public void setViewType(String paramString)
  {
    this.viewType = paramString;
  }
  
  public void setZipFileName(String paramString)
  {
    this.zipFileName = paramString;
  }
  
  public void setvKey(String paramString)
  {
    this.vKey = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"AttachmentUI\",");
    if ((this.attachmentUIs != null) && (this.attachmentUIs.size() > 0))
    {
      localStringBuilder.append("\"item\":[");
      Iterator localIterator = this.attachmentUIs.iterator();
      while (localIterator.hasNext())
      {
        AttachmentUI localAttachmentUI = (AttachmentUI)localIterator.next();
        localStringBuilder.append(localAttachmentUI.toString() + ",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append("],");
    }
    if (getKeyName() != null) {
      localStringBuilder.append("\"keyname\":\"" + getKeyName() + "\",");
    }
    if (getZipFileName() != null) {
      localStringBuilder.append("\"zipname\":\"" + getZipFileName() + "\",");
    }
    if (getType() != null) {
      localStringBuilder.append("\"type\":\"" + getType() + "\",");
    }
    if (getIviewType() != null) {
      localStringBuilder.append("\"iviewtype\":\"" + getIviewType() + "\",");
    }
    if (getViewType() != null) {
      localStringBuilder.append("\"viewtype\":\"" + getViewType() + "\",");
    }
    if (getSize() != null) {
      localStringBuilder.append("\"sz\":\"" + getSize() + "\",");
    }
    if (getDirName() != null) {
      localStringBuilder.append("\"dirname\":\"" + getDirName() + "\",");
    }
    if (getDirPath() != null) {
      localStringBuilder.append("\"dirpath\":\"" + getDirPath() + "\",");
    }
    if (getUrlEncodeDirName() != null) {
      localStringBuilder.append("\"redn\":\"" + getUrlEncodeDirName() + "\",");
    }
    if (getUrlEncodeDirPath() != null) {
      localStringBuilder.append("\"uedp\":\"" + getUrlEncodeDirPath() + "\",");
    }
    if (getUrlEncodeFullPath() != null) {
      localStringBuilder.append("\"uefp\":\"" + getUrlEncodeFullPath() + "\",");
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
 * Qualified Name:     com.tencent.qqmail.attachment.model.AttachmentUI
 * JD-Core Version:    0.7.0.1
 */