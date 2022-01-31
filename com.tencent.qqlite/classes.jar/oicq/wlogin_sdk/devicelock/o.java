package oicq.wlogin_sdk.devicelock;

public class o
  extends e
{
  public o()
  {
    this._type = 7;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 2];
    fill_head();
    fill_body(arrayOfByte, arrayOfByte.length);
    put_block(paramArrayOfByte, this._head_len);
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.o
 * JD-Core Version:    0.7.0.1
 */