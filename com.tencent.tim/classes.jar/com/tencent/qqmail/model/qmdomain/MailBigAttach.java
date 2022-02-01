package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.utilities.common.CommUtils;
import java.util.Date;

public class MailBigAttach
  extends Attach
{
  private static final long serialVersionUID = -7720919466519996216L;
  private String code;
  private int createTime;
  private int downloadTimes;
  private Date expire;
  private long expireTimeMilli;
  private String fid;
  private byte[] infoBytes;
  private String key;
  private String md5;
  private String sha;
  private String type;
  
  public MailBigAttach() {}
  
  public MailBigAttach(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof MailBigAttach))) {}
    do
    {
      return false;
      paramObject = (MailBigAttach)paramObject;
    } while (!getFid().equals(paramObject.getFid()));
    return true;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public int getCreateTime()
  {
    return this.createTime;
  }
  
  public int getDownloadTimes()
  {
    return this.downloadTimes;
  }
  
  public Date getExpire()
  {
    return this.expire;
  }
  
  public long getExpireTimeMilli()
  {
    return this.expireTimeMilli;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public byte[] getInfoBytes()
  {
    return this.infoBytes;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getSha()
  {
    return this.sha;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public boolean isBigAttach()
  {
    return true;
  }
  
  public boolean isBizNetDiskAttach()
  {
    return (this.fid != null) && (this.fid.startsWith("5/")) && (this.expireTimeMilli == -1L);
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool4;
    boolean bool1;
    try
    {
      super.parseWithDictionary(paramJSONObject);
      bool2 = bool4;
      String str = paramJSONObject.getString("fid");
      if (str != null)
      {
        bool2 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getFid(), str))
        {
          bool2 = bool4;
          setFid(str);
        }
      }
      bool2 = bool4;
      str = paramJSONObject.getString("sha");
      if (str != null)
      {
        bool2 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getSha(), str))
        {
          bool2 = bool4;
          setSha(str);
        }
      }
      bool2 = bool4;
      str = paramJSONObject.getString("code");
      if (str != null)
      {
        bool2 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getCode(), str))
        {
          bool2 = bool4;
          setCode(str);
        }
      }
      bool2 = bool4;
      str = paramJSONObject.getString("key");
      if (str != null)
      {
        bool2 = bool4;
        if (CommUtils.isNullorBlankorNotEquals(getKey(), str))
        {
          bool2 = bool4;
          setKey(str);
        }
      }
      bool2 = bool4;
      str = paramJSONObject.getString("type");
      bool1 = bool3;
      if (str != null)
      {
        bool2 = bool4;
        bool4 = CommUtils.isNullorBlankorNotEquals(getType(), str);
        bool1 = bool3;
        if (!bool4) {}
      }
      try
      {
        setType(str);
        bool1 = true;
        bool2 = bool1;
        if (paramJSONObject.get("expire") != null)
        {
          bool2 = bool1;
          long l1 = paramJSONObject.getLong("expire").longValue();
          if (l1 == -1L)
          {
            setExpireTimeMilli(-1L);
            setExpire(new Date(0L));
            return true;
          }
          if (l1 != -2L)
          {
            bool2 = bool1;
            l1 = Long.valueOf(l1).longValue() * 1000L;
            bool2 = bool1;
            paramJSONObject = new Date(l1);
            bool2 = bool1;
            if (getExpire() != null)
            {
              bool2 = bool1;
              long l2 = getExpire().getTime();
              bool2 = bool1;
              long l3 = paramJSONObject.getTime();
              if (l2 == l3) {
                return bool1;
              }
            }
            setExpireTimeMilli(l1);
            setExpire(paramJSONObject);
            return true;
          }
          setExpireTimeMilli(-2L);
          setExpire(null);
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        return true;
      }
      return bool1;
    }
    catch (Exception paramJSONObject)
    {
      return bool2;
    }
    return bool1;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setCreateTime(int paramInt)
  {
    this.createTime = paramInt;
  }
  
  public void setDownloadTimes(int paramInt)
  {
    this.downloadTimes = paramInt;
  }
  
  public void setExpire(long paramLong)
  {
    if (paramLong == -1L)
    {
      setExpireTimeMilli(paramLong);
      setExpire(new Date(0L));
    }
    Date localDate;
    do
    {
      return;
      if (paramLong == -2L) {
        break;
      }
      localDate = new Date(paramLong);
    } while ((getExpire() != null) && (getExpire().getTime() == localDate.getTime()));
    setExpireTimeMilli(paramLong);
    setExpire(localDate);
    return;
    setExpireTimeMilli(-2L);
    setExpire(null);
  }
  
  public void setExpire(Date paramDate)
  {
    this.expire = paramDate;
  }
  
  public void setExpireTimeMilli(long paramLong)
  {
    this.expireTimeMilli = paramLong;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setInfoBytes(byte[] paramArrayOfByte)
  {
    this.infoBytes = paramArrayOfByte;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setSha(String paramString)
  {
    this.sha = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailBigAttach\",");
    String str;
    if (getPreview().getDownloadUrl() != null)
    {
      str = getPreview().getDownloadUrl().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"download\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getName() != null)
    {
      str = getName().replaceAll("\\\\", "\\\\\\\\");
      localStringBuffer.append("\"name\":\"" + str.replaceAll("\"", "\\\\\"") + "\",");
    }
    if (getSize() != null) {
      localStringBuffer.append("\"sz\":\"" + getSize() + "\",");
    }
    if (getType() != null) {
      localStringBuffer.append("\"type\":\"" + getType() + "\",");
    }
    if (getExpire() != null) {
      localStringBuffer.append("\"expire\":" + getExpire().getTime() / 1000L + ",");
    }
    if (getKey() != null) {
      localStringBuffer.append("\"key\":\"" + getKey() + "\",");
    }
    if (getCode() != null) {
      localStringBuffer.append("\"code\":\"" + getCode() + "\",");
    }
    if (getFid() != null) {
      localStringBuffer.append("\"fid\":\"" + getFid() + "\",");
    }
    if (getSha() != null) {
      localStringBuffer.append("\"sha\":\"" + getSha() + "\"");
    }
    int i = localStringBuffer.length() - 1;
    if (localStringBuffer.charAt(i) == ',') {
      localStringBuffer.deleteCharAt(i);
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailBigAttach
 * JD-Core Version:    0.7.0.1
 */