package oicq.wlogin_sdk.tlv_type;

public class tlv_t143
  extends tlv_t
{
  public int _t143_body_len = 0;
  
  public tlv_t143()
  {
    this._cmd = 323;
  }
  
  public byte[] get_tlv_143(byte[] paramArrayOfByte)
  {
    this._t143_body_len = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this._t143_body_len];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t143_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t143
 * JD-Core Version:    0.7.0.1
 */