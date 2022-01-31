package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.tools.util;

public class Ticket
  implements Parcelable
{
  public static final Parcelable.Creator<Ticket> CREATOR = new Ticket.1();
  public long _create_time;
  public long _expire_time;
  public Map<String, Long> _pskey_expire = new HashMap();
  public Map<String, byte[]> _pskey_map = new HashMap();
  public byte[] _sig;
  public byte[] _sig_key;
  public int _type;
  
  public Ticket() {}
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label81;
      }
    }
    label81:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong1;
      this._expire_time = paramLong2;
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label102;
      }
    }
    label102:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong;
      this._expire_time = (86400L + paramLong);
      parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire);
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public static byte[] packPsBuf(Map<String, byte[]> paramMap, long paramLong, Map<String, Long> paramMap1)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4096);
    localByteBuffer.putShort((short)paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localByteBuffer.putShort((short)((String)localObject).length());
      localByteBuffer.put(((String)localObject).getBytes());
      byte[] arrayOfByte = (byte[])paramMap.get(localObject);
      localByteBuffer.putShort((short)arrayOfByte.length);
      localByteBuffer.put(arrayOfByte);
      localByteBuffer.putShort((short)-1);
      localObject = (Long)paramMap1.get(localObject);
      if (localObject != null) {
        localByteBuffer.putLong(((Long)localObject).longValue());
      } else {
        localByteBuffer.putLong(86400L + paramLong);
      }
    }
    localByteBuffer.flip();
    paramMap = new byte[localByteBuffer.limit()];
    localByteBuffer.get(paramMap);
    return paramMap;
  }
  
  public static void parsePsBuf(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    long l2 = t.f();
    int i;
    int j;
    if (paramArrayOfByte == null)
    {
      util.LOGI("ps_buf null", "");
      util.LOGI("pskeyMap " + paramMap.size(), "");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 2))
      {
        int k = util.buf_to_int16(paramArrayOfByte, 0);
        i = 2;
        j = 0;
        if ((j < k) && (paramArrayOfByte.length >= i + 2)) {
          break label111;
        }
      }
    }
    label111:
    int m;
    String str;
    do
    {
      do
      {
        do
        {
          return;
          util.LOGI("ps_buf len " + paramArrayOfByte.length);
          break;
          m = util.buf_to_int16(paramArrayOfByte, i);
          i += 2;
        } while (paramArrayOfByte.length < i + m);
        str = new String(paramArrayOfByte, i, m);
        i = m + i;
      } while (paramArrayOfByte.length < i + 2);
      m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
    } while (paramArrayOfByte.length < i + m);
    byte[] arrayOfByte = new byte[m];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, m);
    i += m;
    long l1;
    if ((paramArrayOfByte.length > i + 2) && (util.buf_to_int16(paramArrayOfByte, i) == 65535))
    {
      i += 2;
      l1 = util.buf_to_int64(paramArrayOfByte, i);
      i += 8;
    }
    for (;;)
    {
      if (l1 > l2)
      {
        paramMap.put(str, arrayOfByte);
        paramMap1.put(str, Long.valueOf(l1));
      }
      util.LOGI(str + " pskey:" + m + " expire: " + l1, "");
      j += 1;
      break;
      l1 = 86400L + paramLong;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._type = paramParcel.readInt();
    this._sig = paramParcel.createByteArray();
    this._sig_key = paramParcel.createByteArray();
    this._create_time = paramParcel.readLong();
    this._expire_time = paramParcel.readLong();
    this._pskey_map = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this._type);
    paramParcel.writeByteArray(this._sig);
    paramParcel.writeByteArray(this._sig_key);
    paramParcel.writeLong(this._create_time);
    paramParcel.writeLong(this._expire_time);
    paramParcel.writeMap(this._pskey_map);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */