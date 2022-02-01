package com.tencent.qqmail.utilities.qmnetwork.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmail.utilities.ByteConvert;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ReceivePacket
  implements Parcelable
{
  public static final Parcelable.Creator<ReceivePacket> CREATOR = new ReceivePacket.1();
  public static final int MAX_BODY_LEN = 2097152;
  public static final String PUSH_CHARSET = "UTF-8";
  public int appid = 1;
  public byte[] body;
  public int body_len = 0;
  public int cmd_id;
  public int header_len = 28;
  public int msg_id = 0;
  public int retcode;
  public long uin = 0L;
  public int version = 0;
  
  public ReceivePacket() {}
  
  public ReceivePacket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBodyString()
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
  
  public int read(InputStream paramInputStream)
    throws IOException
  {
    Object localObject = new byte[32];
    byte[] arrayOfByte = new byte[32];
    int j = 32;
    int k = 0;
    int i = 0;
    int m;
    int n;
    int i1;
    while (k < 32)
    {
      m = paramInputStream.read(arrayOfByte, 0, j);
      i = m;
      if (m <= 0) {
        break;
      }
      System.arraycopy(arrayOfByte, 0, localObject, k, m);
      n = k + m;
      i1 = 32 - n;
      j = i1;
      i = m;
      k = n;
      if (i1 >= 32)
      {
        j = 32;
        i = m;
        k = n;
      }
    }
    if (i == -1)
    {
      QMLog.log(5, "webpush", "end of stream has been reached!");
      throw new IOException("end of stream has been reached!");
    }
    localObject = new ByteArrayInputStream((byte[])localObject);
    if (k > 0)
    {
      arrayOfByte = new byte[4];
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.body_len = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.header_len = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.version = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.uin = ByteConvert.bytesToUint(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.appid = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.cmd_id = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.msg_id = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).read(arrayOfByte);
      this.retcode = ByteConvert.bytesToInt(arrayOfByte);
      ((ByteArrayInputStream)localObject).close();
      if (this.header_len != 32)
      {
        QMLog.log(5, "webpush", "read header error: " + this.header_len);
        throw new IOException("read error!");
      }
      if ((this.body_len > 0) && (this.body_len < 2097152))
      {
        this.body = new byte[this.body_len];
        if (this.body_len < 1024) {}
        for (j = this.body_len;; j = 1024)
        {
          localObject = new byte[j];
          m = 0;
          while (m < this.body_len)
          {
            n = paramInputStream.read((byte[])localObject, 0, j);
            i = n;
            if (n <= 0) {
              break;
            }
            System.arraycopy(localObject, 0, this.body, m, n);
            i1 = m + n;
            int i2 = this.body_len - i1;
            j = i2;
            m = i1;
            i = n;
            if (i2 >= 1024)
            {
              j = 1024;
              m = i1;
              i = n;
            }
          }
        }
        if (i == -1)
        {
          QMLog.log(5, "webpush", "end of stream has been reached!");
          throw new IOException("end of stream has been reached!");
        }
      }
    }
    return k;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    int i = 2097152;
    this.body_len = paramParcel.readInt();
    this.header_len = paramParcel.readInt();
    this.version = paramParcel.readInt();
    this.uin = paramParcel.readLong();
    this.appid = paramParcel.readInt();
    this.cmd_id = paramParcel.readInt();
    this.msg_id = paramParcel.readInt();
    this.retcode = paramParcel.readInt();
    if (this.body_len > 0)
    {
      if (this.body_len < 2097152) {
        i = this.body_len;
      }
      this.body = new byte[i];
      paramParcel.readByteArray(this.body);
    }
  }
  
  public byte[] toByteArray()
  {
    this.header_len = 32;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(this.body_len + this.header_len);
    localByteBuffer.putInt(this.body_len);
    localByteBuffer.putInt(this.header_len);
    localByteBuffer.putInt(this.version);
    localByteBuffer.put(ByteConvert.uintToBytes(this.uin));
    localByteBuffer.putInt(this.appid);
    localByteBuffer.putInt(this.cmd_id);
    localByteBuffer.putInt(this.msg_id);
    localByteBuffer.putInt(this.retcode);
    if (this.body != null) {
      localByteBuffer.put(this.body, 0, this.body_len);
    }
    localByteBuffer.flip();
    return localByteBuffer.array();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Header:{");
    localStringBuilder.append("body_len = ").append(this.body_len).append(',');
    localStringBuilder.append("header_len = ").append(this.header_len).append(',');
    localStringBuilder.append("version = ").append(this.version).append(',');
    localStringBuilder.append("uin = ").append(this.uin).append(',');
    localStringBuilder.append("appid = ").append(this.appid).append(',');
    localStringBuilder.append("cmd_id = ").append(this.cmd_id).append(',');
    localStringBuilder.append("msg_id = ").append(this.msg_id).append(',');
    localStringBuilder.append("recode = ").append(this.retcode).append("},");
    if ((this.body != null) && (this.body_len > 0))
    {
      localStringBuilder.append("Body:");
      localStringBuilder.append(getBodyString());
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.body_len);
    paramParcel.writeInt(this.header_len);
    paramParcel.writeInt(this.version);
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.appid);
    paramParcel.writeInt(this.cmd_id);
    paramParcel.writeInt(this.msg_id);
    paramParcel.writeInt(this.retcode);
    if (this.body != null) {
      paramParcel.writeByteArray(this.body);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket
 * JD-Core Version:    0.7.0.1
 */