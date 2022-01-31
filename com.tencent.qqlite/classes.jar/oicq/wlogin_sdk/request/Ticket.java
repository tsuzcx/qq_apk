package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;

public class Ticket
  implements Parcelable
{
  public static final Parcelable.Creator<Ticket> CREATOR = new b();
  public long _create_time;
  public long _expire_time;
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
        break label70;
      }
    }
    label70:
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
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, byte[] paramArrayOfByte3)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label76;
      }
    }
    label76:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong1;
      this._expire_time = paramLong2;
      parsePsBuf(paramArrayOfByte3);
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private void parsePsBuf(byte[] paramArrayOfByte)
  {
    int k;
    int j;
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 2))
    {
      k = util.buf_to_int16(paramArrayOfByte, 0);
      j = 2;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (paramArrayOfByte.length < j + 2)) {}
      int m;
      String str;
      do
      {
        do
        {
          do
          {
            return;
            m = util.buf_to_int16(paramArrayOfByte, j);
            j += 2;
          } while (paramArrayOfByte.length < j + m);
          str = new String(paramArrayOfByte, j, m);
          m = j + m;
        } while (paramArrayOfByte.length < m + 2);
        j = util.buf_to_int16(paramArrayOfByte, m);
        m += 2;
      } while (paramArrayOfByte.length < m + j);
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramArrayOfByte, m, arrayOfByte, 0, j);
      j = m + j;
      this._pskey_map.put(str, arrayOfByte);
      util.LOGD("domain:" + str + " pskey:" + util.buf_to_string(arrayOfByte));
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */