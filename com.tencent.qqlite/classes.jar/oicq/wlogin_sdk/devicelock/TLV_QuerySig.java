package oicq.wlogin_sdk.devicelock;

public class TLV_QuerySig
  extends e
{
  public byte[] QuerySig = new byte[0];
  
  public TLV_QuerySig()
  {
    this._type = 8;
  }
  
  public void parse()
  {
    this.QuerySig = get_data();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.TLV_QuerySig
 * JD-Core Version:    0.7.0.1
 */