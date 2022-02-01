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
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong1;
    this._expire_time = paramLong2;
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong;
    this._expire_time = (paramLong + 86400L);
    parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire);
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong;
    this._expire_time = (paramLong + 86400L);
    parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire);
    parsePsBuf(paramArrayOfByte4, this._create_time, this._pt4token_map, this._pt4token_expire);
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private String __getPskey(String paramString, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    Object localObject1 = new StringBuilder("__getPskey get domain ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" pskey or pt4token");
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    if (paramMap == null) {
      return null;
    }
    Object localObject2 = (byte[])paramMap.get(paramString);
    if (localObject2 == null)
    {
      paramMap = new StringBuilder("__getPskey get domain ");
      paramMap.append(paramString);
      paramMap.append(" pskey or pt4token null");
      util.LOGI(paramMap.toString(), "");
      return null;
    }
    if (paramMap1 != null)
    {
      localObject1 = (Long)paramMap1.get(paramString);
      if ((localObject1 != null) && (((Long)localObject1).longValue() <= t.f()))
      {
        localObject2 = new StringBuilder("__getPskey delete domain ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" expired pskey or pt4token expire time ");
        ((StringBuilder)localObject2).append(localObject1);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        paramMap1.remove(paramString);
        paramMap.remove(paramString);
        return null;
      }
    }
    paramMap = new String((byte[])localObject2);
    paramMap1 = new StringBuilder("__getPskey get domain ");
    paramMap1.append(paramString);
    paramMap1.append(" pskey or pt4token len ");
    paramMap1.append(paramMap.length());
    paramMap1.append(" ");
    paramMap1.append(paramMap.substring(0, 5));
    paramMap1.append("***");
    paramMap1.append(paramMap.substring(paramMap.length() - 5, paramMap.length()));
    util.LOGI(paramMap1.toString(), "");
    return paramMap;
  }
  
  private String getPskeyOrPt4tokenContent()
  {
    String str1 = "";
    Iterator localIterator = this._pskey_map.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(":");
      localStringBuilder.append(util.getMaskBytes((byte[])this._pskey_map.get(str2), 3, 3));
      localStringBuilder.append("|");
      str1 = localStringBuilder.toString();
    }
    return str1;
  }
  
  public static boolean isPskeyExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isPskeyStorageExpired(long paramLong)
  {
    long l = t.f();
    StringBuilder localStringBuilder = new StringBuilder("isPskeyStorageExpired expireTime:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|current: ");
    localStringBuilder.append(l);
    util.LOGI(localStringBuilder.toString(), "");
    return l > paramLong + 86400L;
  }
  
  public static boolean isPt4TokenExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isSkeyExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isTicketExpired(long paramLong)
  {
    long l = t.f();
    if (l > paramLong) {
      return true;
    }
    if (paramLong > 86400L + l)
    {
      StringBuilder localStringBuilder = new StringBuilder("time for system may be  modified manually expireTime ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" current ");
      localStringBuilder.append(l);
      util.LOGI(localStringBuilder.toString(), "");
      return true;
    }
    return false;
  }
  
  protected static byte[] packPsBuf(Map<String, byte[]> paramMap, long paramLong, Map<String, Long> paramMap1)
  {
    Object localObject1 = new StringBuilder("pskeyMap ");
    ((StringBuilder)localObject1).append(paramMap.size());
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = ByteBuffer.allocate(4096);
    ((ByteBuffer)localObject1).putShort((short)paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      ((ByteBuffer)localObject1).putShort((short)((String)localObject2).length());
      ((ByteBuffer)localObject1).put(((String)localObject2).getBytes());
      byte[] arrayOfByte = (byte[])paramMap.get(localObject2);
      ((ByteBuffer)localObject1).putShort((short)arrayOfByte.length);
      ((ByteBuffer)localObject1).put(arrayOfByte);
      ((ByteBuffer)localObject1).putShort((short)-1);
      localObject2 = (Long)paramMap1.get(localObject2);
      if (localObject2 != null) {
        ((ByteBuffer)localObject1).putLong(((Long)localObject2).longValue());
      } else {
        ((ByteBuffer)localObject1).putLong(86400L + paramLong);
      }
    }
    ((ByteBuffer)localObject1).flip();
    paramMap = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get(paramMap);
    return paramMap;
  }
  
  protected static void parsePsBuf(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    Object localObject2 = new StringBuilder("ps_buf ");
    Object localObject1;
    if (paramArrayOfByte == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
    }
    ((StringBuilder)localObject2).append(localObject1);
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2) {
        return;
      }
      long l2 = t.f();
      int k = util.buf_to_int16(paramArrayOfByte, 0);
      util.LOGI("domainCnt ".concat(String.valueOf(k)), "");
      int j = 0;
      int i = 2;
      while (j < k)
      {
        int n = paramArrayOfByte.length;
        int m = i + 2;
        if (n < m) {
          break;
        }
        n = util.buf_to_int16(paramArrayOfByte, i);
        int i1 = paramArrayOfByte.length;
        i = m + n;
        if (i1 < i) {
          break;
        }
        localObject1 = new String(paramArrayOfByte, m, n);
        m = paramArrayOfByte.length;
        n = i + 2;
        if (m < n) {
          break;
        }
        m = util.buf_to_int16(paramArrayOfByte, i);
        i1 = paramArrayOfByte.length;
        i = n + m;
        if (i1 < i) {
          break;
        }
        localObject2 = new byte[m];
        System.arraycopy(paramArrayOfByte, n, localObject2, 0, m);
        n = paramArrayOfByte.length;
        i1 = i + 2;
        long l1;
        if ((n > i1) && (util.buf_to_int16(paramArrayOfByte, i) == 65535))
        {
          l1 = util.buf_to_int64(paramArrayOfByte, i1);
          i = i1 + 8;
        }
        else
        {
          l1 = 86400L + paramLong;
        }
        if (l1 > l2)
        {
          paramMap.put(localObject1, localObject2);
          paramMap1.put(localObject1, Long.valueOf(l1));
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" pskey or pt4token:");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" expire: ");
        ((StringBuilder)localObject2).append(l1);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        j += 1;
      }
      return;
    }
  }
  
  protected static void parseSvrPs(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap1, Map<String, Long> paramMap2, Map<String, byte[]> paramMap3, Map<String, Long> paramMap4)
  {
    Object localObject1 = new StringBuilder("pskeyMap ");
    ((StringBuilder)localObject1).append(paramMap1.size());
    ((StringBuilder)localObject1).append(", tokenMap ");
    ((StringBuilder)localObject1).append(paramMap3.size());
    ((StringBuilder)localObject1).append(" create time:");
    ((StringBuilder)localObject1).append(paramLong);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2) {
        return;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      int j = paramArrayOfByte.getShort();
      int i = 0;
      while (i < j)
      {
        localObject1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject1);
        localObject1 = new String((byte[])localObject1);
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte1);
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte2);
        long l = 86400L + paramLong;
        if (arrayOfByte1.length > 0)
        {
          localObject2 = new StringBuilder("parseSvrPs add domain ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" pskey len ");
          ((StringBuilder)localObject2).append(arrayOfByte1.length);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(l);
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          paramMap1.put(localObject1, arrayOfByte1);
          paramMap2.put(localObject1, Long.valueOf(l));
        }
        if (arrayOfByte2.length > 0)
        {
          localObject2 = new String(arrayOfByte2);
          StringBuilder localStringBuilder = new StringBuilder("parseSvrPs add domain ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" pt4token len ");
          localStringBuilder.append(arrayOfByte2.length);
          localStringBuilder.append(" ");
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append(((String)localObject2).substring(0, 5));
          localStringBuilder.append("***");
          localStringBuilder.append(((String)localObject2).substring(((String)localObject2).length() - 5));
          util.LOGI(localStringBuilder.toString(), "");
          paramMap3.put(localObject1, arrayOfByte2);
          paramMap4.put(localObject1, Long.valueOf(l));
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" pskey:");
        ((StringBuilder)localObject2).append(arrayOfByte1.length);
        ((StringBuilder)localObject2).append(" pt4token ");
        ((StringBuilder)localObject2).append(arrayOfByte2.length);
        ((StringBuilder)localObject2).append(" expire: ");
        ((StringBuilder)localObject2).append(l);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        i += 1;
      }
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContent()
  {
    if (4096 == this._type)
    {
      StringBuilder localStringBuilder = new StringBuilder("skey:");
      localStringBuilder.append(util.getMaskBytes(this._sig, 2, 2));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String getPSkey(String paramString)
  {
    return __getPskey(paramString, this._pskey_map, this._pskey_expire);
  }
  
  public String getPt4Token(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("getPt4Token get domain ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" pt4token");
    util.LOGI(localStringBuilder.toString(), "");
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
    this._pt4token_map = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this._type);
    paramParcel.writeByteArray(this._sig);
    paramParcel.writeByteArray(this._sig_key);
    paramParcel.writeLong(this._create_time);
    paramParcel.writeLong(this._expire_time);
    paramParcel.writeMap(this._pskey_map);
    paramParcel.writeMap(this._pt4token_map);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */