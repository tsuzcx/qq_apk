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
  private static final int EXPIRE_FIELD = 65535;
  public long _create_time;
  public long _expire_time;
  public Map<String, Long> _pskey_expire = new HashMap();
  public Map<String, byte[]> _pskey_map = new HashMap();
  public Map<String, Long> _pt4token_expire = new HashMap();
  public Map<String, byte[]> _pt4token_map = new HashMap();
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
        break label103;
      }
    }
    label103:
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
        break label124;
      }
    }
    label124:
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
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label141;
      }
    }
    label141:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong;
      this._expire_time = (86400L + paramLong);
      parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire);
      parsePsBuf(paramArrayOfByte4, this._create_time, this._pt4token_map, this._pt4token_expire);
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private String __getPskey(String paramString, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    if (paramMap == null) {
      return null;
    }
    byte[] arrayOfByte = (byte[])paramMap.get(paramString);
    if (arrayOfByte == null) {
      return null;
    }
    if (paramMap1 != null)
    {
      Long localLong = (Long)paramMap1.get(paramString);
      if ((localLong != null) && (localLong.longValue() <= t.f()))
      {
        paramMap1.remove(paramString);
        paramMap.remove(paramString);
        return null;
      }
    }
    return new String(arrayOfByte);
  }
  
  protected static byte[] packPsBuf(Map<String, byte[]> paramMap, long paramLong, Map<String, Long> paramMap1)
  {
    util.LOGI("pskeyMap " + paramMap.size(), "");
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
  
  protected static void parsePsBuf(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    Object localObject2 = new StringBuilder().append("ps_buf ");
    Object localObject1;
    if (paramArrayOfByte == null)
    {
      localObject1 = "null";
      util.LOGI(localObject1, "");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 2)) {
        break label58;
      }
    }
    label58:
    long l2;
    int i;
    int j;
    label101:
    int m;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = Integer.valueOf(paramArrayOfByte.length);
          break;
          l2 = t.f();
          int k = util.buf_to_int16(paramArrayOfByte, 0);
          i = 2;
          util.LOGI("domainCnt " + k, "");
          j = 0;
          if ((j >= k) || (paramArrayOfByte.length < i + 2)) {
            break label341;
          }
          m = util.buf_to_int16(paramArrayOfByte, i);
          i += 2;
        } while (paramArrayOfByte.length < i + m);
        localObject1 = new String(paramArrayOfByte, i, m);
        i = m + i;
      } while (paramArrayOfByte.length < i + 2);
      m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
    } while (paramArrayOfByte.length < i + m);
    localObject2 = new byte[m];
    System.arraycopy(paramArrayOfByte, i, localObject2, 0, m);
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
        paramMap.put(localObject1, localObject2);
        paramMap1.put(localObject1, Long.valueOf(l1));
      }
      util.LOGI((String)localObject1 + " pskey:" + m + " expire: " + l1, "");
      j += 1;
      break label101;
      label341:
      break;
      l1 = 86400L + paramLong;
    }
  }
  
  protected static void parseSvrPs(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap1, Map<String, Long> paramMap2, Map<String, byte[]> paramMap3, Map<String, Long> paramMap4)
  {
    util.LOGI("pskeyMap " + paramMap1.size() + ", tokenMap " + paramMap3.size(), "");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {}
    for (;;)
    {
      return;
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      int j = paramArrayOfByte.getShort();
      int i = 0;
      while (i < j)
      {
        Object localObject = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject);
        localObject = new String((byte[])localObject);
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte1);
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte2);
        long l = 86400L + paramLong;
        if (arrayOfByte1.length > 0)
        {
          paramMap1.put(localObject, arrayOfByte1);
          paramMap2.put(localObject, Long.valueOf(l));
        }
        if (arrayOfByte2.length > 0)
        {
          paramMap3.put(localObject, arrayOfByte2);
          paramMap4.put(localObject, Long.valueOf(l));
        }
        util.LOGI((String)localObject + " pskey:" + arrayOfByte1.length + " pt4token " + arrayOfByte2.length + " expire: " + l, "");
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getPSkey(String paramString)
  {
    return __getPskey(paramString, this._pskey_map, this._pskey_expire);
  }
  
  public String getPt4Token(String paramString)
  {
    return __getPskey(paramString, this._pt4token_map, this._pt4token_expire);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */