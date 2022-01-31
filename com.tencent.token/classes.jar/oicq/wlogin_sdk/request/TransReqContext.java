package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransReqContext
  implements Parcelable
{
  public static final Parcelable.Creator<TransReqContext> CREATOR = new TransReqContext.1();
  public byte[] _body;
  public int _subcmd = 0;
  public int _type = 0;
  public long _uin = 0L;
  
  public TransReqContext() {}
  
  private TransReqContext(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] get_body()
  {
    return this._body;
  }
  
  public int get_subcmd()
  {
    return this._subcmd;
  }
  
  public long get_uin()
  {
    return this._uin;
  }
  
  public boolean is_code2d_func_req()
  {
    return this._type == 3;
  }
  
  public boolean is_devlock_req()
  {
    return this._type == 5;
  }
  
  public boolean is_name_func_req()
  {
    return this._type == 2;
  }
  
  public boolean is_oidb_func_req()
  {
    return this._type == 4;
  }
  
  public boolean is_register_req()
  {
    return this._type == 1;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._body = paramParcel.createByteArray();
    this._type = paramParcel.readInt();
    this._subcmd = paramParcel.readInt();
    this._uin = paramParcel.readLong();
  }
  
  public void set_body(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this._body = new byte[0];
      return;
    }
    this._body = paramArrayOfByte;
  }
  
  public void set_code2d_func_req()
  {
    this._type = 3;
  }
  
  public void set_devlock_req()
  {
    this._type = 5;
  }
  
  public void set_name_func_req()
  {
    this._type = 2;
  }
  
  public void set_oidb_func_req()
  {
    this._type = 4;
  }
  
  public void set_register_req()
  {
    this._type = 1;
  }
  
  public void set_subcmd(int paramInt)
  {
    this._subcmd = paramInt;
  }
  
  public void set_uin(long paramLong)
  {
    this._uin = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this._body);
    paramParcel.writeInt(this._type);
    paramParcel.writeInt(this._subcmd);
    paramParcel.writeLong(this._uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.TransReqContext
 * JD-Core Version:    0.7.0.1
 */