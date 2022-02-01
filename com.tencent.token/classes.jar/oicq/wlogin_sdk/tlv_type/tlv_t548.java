package oicq.wlogin_sdk.tlv_type;

public class tlv_t548
  extends tlv_t
{
  public tlv_t548()
  {
    this._cmd = 1352;
  }
  
  public byte[] get_tlv_548(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    int i = arrayOfByte.length;
    paramArrayOfByte = new byte[i];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, i);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t548
 * JD-Core Version:    0.7.0.1
 */