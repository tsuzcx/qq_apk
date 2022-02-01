package com.tencent.qqmail.utilities.qmnetwork.service;

import android.net.Uri;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.ByteConvert;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils.NetworkType;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class SendPacket
{
  private static final HashMap<String, Integer> networkName2Value;
  public static int version = 20004;
  public int appid = 2;
  public byte[] body;
  public int body_len = 0;
  public int cmd_id;
  private String headExt_deviceId;
  public int header_len = 28;
  public int msg_id = 0;
  public long uin = 0L;
  public int unused = 0;
  
  static
  {
    String[] arrayOfString = AppConfig.getCodeVersionName().split("\\.");
    int i;
    if (arrayOfString.length > 2)
    {
      i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      version = Integer.parseInt(arrayOfString[2]) + (i * 10000 + j * 100);
    }
    for (;;)
    {
      networkName2Value = new HashMap();
      networkName2Value.put("Wifi", Integer.valueOf(1));
      networkName2Value.put("2G", Integer.valueOf(2));
      networkName2Value.put("3G", Integer.valueOf(3));
      networkName2Value.put("4G", Integer.valueOf(4));
      networkName2Value.put("VPN", Integer.valueOf(5));
      networkName2Value.put("BlueTooth", Integer.valueOf(6));
      networkName2Value.put("Ethernet", Integer.valueOf(7));
      networkName2Value.put("Other", Integer.valueOf(8));
      networkName2Value.put("Mobile", Integer.valueOf(9));
      networkName2Value.put("Moblie_DUN", Integer.valueOf(10));
      return;
      if (arrayOfString.length == 2)
      {
        i = Integer.parseInt(arrayOfString[0]);
        version = Integer.parseInt(arrayOfString[1]) * 100 + i * 10000;
      }
    }
  }
  
  public SendPacket(String paramString)
  {
    Object localObject = QMNetworkUtils.getActiveNetworkType().getTypeName();
    Integer localInteger = (Integer)networkName2Value.get(localObject);
    localObject = new StringBuilder().append("deviceid=").append(Uri.encode(paramString));
    if (localInteger != null) {}
    for (paramString = "&nt=" + localInteger;; paramString = "")
    {
      this.headExt_deviceId = paramString;
      return;
    }
  }
  
  private String getBodyString()
  {
    if ((this.body_len > 0) && (this.body != null)) {
      try
      {
        if (this.body_len <= this.body.length) {}
        for (int i = this.body_len;; i = this.body.length) {
          return new String(this.body, 0, i, "UTF-8");
        }
        return "";
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return "";
      }
    }
  }
  
  public byte[] toByteArray()
  {
    this.header_len = 32;
    if (this.body != null) {
      this.body_len = this.body.length;
    }
    Object localObject = this.headExt_deviceId.getBytes();
    int i = localObject.length + 2;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    arrayOfByte[(i - 2)] = 13;
    arrayOfByte[(i - 1)] = 10;
    localObject = ByteBuffer.allocate(this.header_len + i + this.body_len);
    ((ByteBuffer)localObject).putInt(i + this.body_len);
    ((ByteBuffer)localObject).putInt(this.header_len);
    ((ByteBuffer)localObject).putInt(version);
    ((ByteBuffer)localObject).put(ByteConvert.uintToBytes(this.uin));
    ((ByteBuffer)localObject).putInt(this.appid);
    ((ByteBuffer)localObject).putInt(this.cmd_id);
    ((ByteBuffer)localObject).putInt(this.msg_id);
    ((ByteBuffer)localObject).putInt(this.unused);
    ((ByteBuffer)localObject).put(arrayOfByte);
    if (this.body != null) {
      ((ByteBuffer)localObject).put(this.body, 0, this.body_len);
    }
    ((ByteBuffer)localObject).flip();
    return ((ByteBuffer)localObject).array();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    localStringBuilder1.append("Header:{");
    localStringBuilder1.append("body_len = ").append(this.body_len).append(',');
    localStringBuilder1.append("header_len = ").append(this.header_len).append(',');
    localStringBuilder1.append("version = ").append(version).append(',');
    localStringBuilder1.append("uin = ").append(this.uin).append(',');
    localStringBuilder1.append("appid = ").append(this.appid).append(',');
    localStringBuilder1.append("cmd_id = ").append(this.cmd_id).append(',');
    localStringBuilder1.append("msg_id = ").append(this.msg_id).append('}');
    StringBuilder localStringBuilder2 = localStringBuilder1.append("{headExt_did = ");
    if (this.headExt_deviceId == null) {}
    for (String str = null;; str = this.headExt_deviceId)
    {
      localStringBuilder2.append(str);
      localStringBuilder1.append("}");
      if ((this.body != null) && (this.body_len > 0))
      {
        localStringBuilder1.append("Body:");
        localStringBuilder1.append(getBodyString());
      }
      return localStringBuilder1.toString();
    }
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(toByteArray());
    paramOutputStream.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.SendPacket
 * JD-Core Version:    0.7.0.1
 */