package oicq.wlogin_sdk.tlv_type;

public class tlv_t145
  extends tlv_t
{
  public int _t145_body_len = 0;
  
  public tlv_t145()
  {
    this._cmd = 325;
  }
  
  public byte[] get_tlv_145(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this._t145_body_len = arrayOfByte.length;
    paramArrayOfByte = new byte[this._t145_body_len];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramArrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t145
 * JD-Core Version:    0.7.0.1
 */