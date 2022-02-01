package com.tencent.qqmail.attachment.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.Serializable;

public class AttachProtocol
  extends QMDomain
{
  private static final long serialVersionUID = -506970557739314572L;
  private long attachId;
  private MailItemBodyInfo bodyInfo = new MailItemBodyInfo();
  private String cid;
  private byte[] data;
  private String exchangeFileUid;
  private String fileContentType;
  private int isexist;
  private long mailId;
  private int protocolType;
  private String type;
  
  public long getAttachId()
  {
    return this.attachId;
  }
  
  public MailItemBodyInfo getBodyInfo()
  {
    return this.bodyInfo;
  }
  
  public String getCid()
  {
    return this.cid;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public String getExchangeFileUid()
  {
    return this.exchangeFileUid;
  }
  
  public String getFileContentType()
  {
    return this.fileContentType;
  }
  
  public int getIsexist()
  {
    return this.isexist;
  }
  
  public long getMailId()
  {
    return this.mailId;
  }
  
  public int getProtocolType()
  {
    return this.protocolType;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.getString("cid");
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(this.cid))
        {
          this.cid = str;
          bool1 = true;
        }
      }
      str = paramJSONObject.getString("attachId");
      bool2 = bool1;
      long l;
      if (str != null)
      {
        l = Long.parseLong(str);
        bool2 = bool1;
        if (this.attachId != l)
        {
          this.attachId = l;
          bool2 = true;
        }
      }
      str = paramJSONObject.getString("mailId");
      bool1 = bool2;
      if (str != null)
      {
        l = Long.parseLong(str);
        bool1 = bool2;
        if (this.mailId != l)
        {
          this.mailId = l;
          bool1 = true;
        }
      }
      str = paramJSONObject.getString("type");
      bool2 = bool1;
      if (str != null)
      {
        bool2 = bool1;
        if (!str.equals(this.type))
        {
          this.type = str;
          bool2 = true;
        }
      }
      str = paramJSONObject.getString("protocolType");
      bool1 = bool2;
      int i;
      if (str != null)
      {
        i = Integer.parseInt(str);
        bool1 = bool2;
        if (this.protocolType != i)
        {
          this.protocolType = i;
          bool1 = true;
        }
      }
      str = paramJSONObject.getString("isexist");
      bool2 = bool1;
      if (str != null)
      {
        i = Integer.parseInt(str);
        bool2 = bool1;
        if (this.isexist != i)
        {
          this.isexist = i;
          bool2 = true;
        }
      }
      str = paramJSONObject.getString("exchangeFileUid");
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(this.exchangeFileUid))
        {
          this.exchangeFileUid = str;
          bool1 = true;
        }
      }
      str = paramJSONObject.getString("fileContentType");
      bool2 = bool1;
      if (str != null)
      {
        bool2 = bool1;
        if (!str.equals(this.fileContentType))
        {
          this.fileContentType = str;
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (this.protocolType == 1)
      {
        this.bodyInfo = new MailItemBodyInfo();
        str = paramJSONObject.getString("bodyInfo_hashId");
        if (str != null)
        {
          l = Long.parseLong(str);
          if (this.bodyInfo.hashId != l) {
            this.bodyInfo.hashId = l;
          }
        }
        str = paramJSONObject.getString("bodyInfo_attachId");
        if (str != null)
        {
          l = Long.parseLong(str);
          if (this.bodyInfo.attachId != l) {
            this.bodyInfo.attachId = l;
          }
        }
        str = paramJSONObject.getString("bodyInfo_mailId");
        if (str != null)
        {
          l = Long.parseLong(str);
          if (this.bodyInfo.mailId != l) {
            this.bodyInfo.mailId = l;
          }
        }
        str = paramJSONObject.getString("bodyInfo_id");
        if (str != null)
        {
          l = Long.parseLong(str);
          if (this.bodyInfo.id != l) {
            this.bodyInfo.id = l;
          }
        }
        str = paramJSONObject.getString("bodyInfo_itemId");
        if (str != null)
        {
          l = Long.parseLong(str);
          if (this.bodyInfo.itemId != l) {
            this.bodyInfo.itemId = l;
          }
        }
        str = paramJSONObject.getString("bodyInfo_bodyId");
        if ((str != null) && (!str.equals(this.bodyInfo.bodyId))) {
          this.bodyInfo.bodyId = str;
        }
        str = paramJSONObject.getString("bodyInfo_itemType");
        if ((str != null) && (!str.equals(this.bodyInfo.itemType))) {
          this.bodyInfo.itemType = str;
        }
        str = paramJSONObject.getString("bodyInfo_contentType");
        if ((str != null) && (!str.equals(this.bodyInfo.contentType))) {
          this.bodyInfo.contentType = str;
        }
        str = paramJSONObject.getString("bodyInfo_contentSubType");
        if ((str != null) && (!str.equals(this.bodyInfo.contentSubType))) {
          this.bodyInfo.contentSubType = str;
        }
        str = paramJSONObject.getString("bodyInfo_contentTypeParams");
        if ((str != null) && (!str.equals(this.bodyInfo.contentTypeParams))) {
          this.bodyInfo.contentTypeParams = str;
        }
        str = paramJSONObject.getString("bodyInfo_contentDescription");
        if ((str != null) && (!str.equals(this.bodyInfo.contentDescription))) {
          this.bodyInfo.contentDescription = str;
        }
        str = paramJSONObject.getString("bodyInfo_transferEncoding");
        if ((str != null) && (!str.equals(this.bodyInfo.transferEncoding))) {
          this.bodyInfo.transferEncoding = str;
        }
        str = paramJSONObject.getString("bodyInfo_contentLineSize");
        if ((str != null) && (!str.equals(this.bodyInfo.contentLineSize))) {
          this.bodyInfo.contentLineSize = str;
        }
        paramJSONObject = paramJSONObject.getString("bodyInfo_contentDisposition");
        bool1 = bool2;
        if (paramJSONObject != null)
        {
          bool1 = bool2;
          if (!paramJSONObject.equals(this.bodyInfo.contentDisposition))
          {
            this.bodyInfo.contentDisposition = paramJSONObject;
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public void setAttachId(long paramLong)
  {
    this.attachId = paramLong;
  }
  
  public void setBodyInfo(MailItemBodyInfo paramMailItemBodyInfo)
  {
    this.bodyInfo = paramMailItemBodyInfo;
  }
  
  public void setCid(String paramString)
  {
    this.cid = paramString;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void setExchangeFileUid(String paramString)
  {
    this.exchangeFileUid = paramString;
  }
  
  public void setFileContentType(String paramString)
  {
    this.fileContentType = paramString;
  }
  
  public void setIsexist(int paramInt)
  {
    this.isexist = paramInt;
  }
  
  public void setMailId(long paramLong)
  {
    this.mailId = paramLong;
  }
  
  public void setProtocolType(int paramInt)
  {
    this.protocolType = paramInt;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public String toPlainString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.cid != null) {
      localStringBuilder.append("\"cid\":\"").append(this.cid).append("\",");
    }
    localStringBuilder.append("\"attachId\":\"").append(this.attachId).append("\",");
    localStringBuilder.append("\"mailId\":\"").append(this.mailId).append("\",");
    if (this.type != null) {
      localStringBuilder.append("\"type\":\"").append(this.type).append("\",");
    }
    localStringBuilder.append("\"protocolType\":\"").append(this.protocolType).append("\",");
    localStringBuilder.append("\"isexist\":\"").append(this.isexist).append("\",");
    if (this.exchangeFileUid != null) {
      localStringBuilder.append("\"exchangeFileUid\":\"").append(this.exchangeFileUid).append("\",");
    }
    if (this.fileContentType != null) {
      localStringBuilder.append("\"fileContentType\":\"").append(this.fileContentType.replaceAll("\"", "\\\\\"")).append("\",");
    }
    if ((this.protocolType == 1) && (this.bodyInfo != null))
    {
      localStringBuilder.append("\"bodyInfo_hashId\":\"").append(this.bodyInfo.hashId).append("\",");
      localStringBuilder.append("\"bodyInfo_attachId\":\"").append(this.bodyInfo.attachId).append("\",");
      localStringBuilder.append("\"bodyInfo_mailId\":\"").append(this.bodyInfo.mailId).append("\",");
      localStringBuilder.append("\"bodyInfo_id\":\"").append(this.bodyInfo.id).append("\",");
      localStringBuilder.append("\"bodyInfo_itemId\":\"").append(this.bodyInfo.itemId).append("\",");
      if (this.bodyInfo.bodyId != null) {
        localStringBuilder.append("\"bodyInfo_bodyId\":\"").append(this.bodyInfo.bodyId).append("\",");
      }
      if (this.bodyInfo.itemType != null) {
        localStringBuilder.append("\"bodyInfo_itemType\":\"").append(this.bodyInfo.itemType).append("\",");
      }
      if (this.bodyInfo.contentType != null) {
        localStringBuilder.append("\"bodyInfo_contentType\":\"").append(this.bodyInfo.contentType.replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (this.bodyInfo.contentSubType != null) {
        localStringBuilder.append("\"bodyInfo_contentSubType\":\"").append(this.bodyInfo.contentSubType.replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (this.bodyInfo.contentTypeParams != null) {
        localStringBuilder.append("\"bodyInfo_contentTypeParams\":\"").append(this.bodyInfo.contentTypeParams.replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (this.bodyInfo.contentDescription != null) {
        localStringBuilder.append("\"bodyInfo_contentDescription\":\"").append(StringExtention.safeStringLiteral(this.bodyInfo.contentDescription)).append("\",");
      }
      if (this.bodyInfo.transferEncoding != null) {
        localStringBuilder.append("\"bodyInfo_transferEncoding\":\"").append(this.bodyInfo.transferEncoding.replaceAll("\"", "\\\\\"")).append("\",");
      }
      if (this.bodyInfo.contentLineSize != null) {
        localStringBuilder.append("\"bodyInfo_contentLineSize\":\"").append(this.bodyInfo.contentLineSize).append("\",");
      }
      if (this.bodyInfo.contentDisposition != null) {
        localStringBuilder.append("\"bodyInfo_contentDisposition\":\"").append(this.bodyInfo.contentDisposition.replaceAll("\"", "\\\\\"")).append("\",");
      }
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
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static class MailItemBodyInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public long attachId;
    public String bodyId;
    public String contentDescription;
    public String contentDisposition;
    public String contentLineSize;
    public String contentSubType;
    public String contentType;
    public String contentTypeParams;
    public long hashId;
    public long id;
    public long itemId;
    public String itemType;
    public long mailId;
    public String transferEncoding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.AttachProtocol
 * JD-Core Version:    0.7.0.1
 */