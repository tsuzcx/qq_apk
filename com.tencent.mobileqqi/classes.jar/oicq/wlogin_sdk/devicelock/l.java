package oicq.wlogin_sdk.devicelock;

public class l
  extends e
{
  public int a = 0;
  
  public l()
  {
    this._type = 5;
  }
  
  public byte[] a(long paramLong)
  {
    fill_head();
    fill_body(new byte[4], 4);
    put_int32(paramLong, this._head_len);
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.l
 * JD-Core Version:    0.7.0.1
 */