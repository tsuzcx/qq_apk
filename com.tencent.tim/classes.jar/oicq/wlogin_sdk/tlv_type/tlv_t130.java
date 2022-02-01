package oicq.wlogin_sdk.tlv_type;

public class tlv_t130
  extends tlv_t
{
  public tlv_t130()
  {
    this._cmd = 304;
  }
  
  public byte[] get_ipaddr()
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(this._buf, this._head_len + 2 + 4, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] get_time()
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void get_tlv_130(byte[] paramArrayOfByte, int paramInt)
  {
    set_buf(paramArrayOfByte, paramInt);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 14) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t130
 * JD-Core Version:    0.7.0.1
 */