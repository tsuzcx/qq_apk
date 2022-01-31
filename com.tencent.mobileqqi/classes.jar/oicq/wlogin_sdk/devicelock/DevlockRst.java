package oicq.wlogin_sdk.devicelock;

public class DevlockRst
{
  public static final int E_RST_UNKOWN = -1;
  public static final int E_SEND_QUERYSIG = 1201;
  public static final int E_VERIFY_QUERYSIG = 1301;
  public static final int S_OK = 0;
  public TLV_CommRsp commRsp = new TLV_CommRsp();
  public h devGuideInfo = new h();
  public i devSetupInfo = new i();
  public j mbGuideInfo = new j();
  public k mbMobileInfo = new k();
  public TLV_QuerySig querySig = new TLV_QuerySig();
  public m smsInfo = new m();
  public TLV_SppKey sppKey = new TLV_SppKey();
  public e transferInfo = new e();
  
  public void setSppKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.sppKey = new TLV_SppKey();
    this.sppKey.set_data(paramArrayOfByte, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.DevlockRst
 * JD-Core Version:    0.7.0.1
 */