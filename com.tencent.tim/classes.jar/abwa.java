import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.channel.KSAppChannel;
import com.tencent.TMG.sdk.AVContext.StartParam;

public class abwa
  extends KSAppChannel
{
  public static String TAG = "SSOChannel";
  public AVContext.StartParam startParam_;
  
  public long getTinyId()
  {
    try
    {
      long l = Long.valueOf(this.startParam_.identifier).longValue();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public boolean loginWithParam(AVContext.StartParam paramStartParam)
  {
    this.startParam_ = paramStartParam;
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.e(TAG, 1, "requestAppCmd enter");
      if ((this.startParam_ instanceof abvp))
      {
        asrt.a().a(paramArrayOfByte, "", this.startParam_.identifier, this.startParam_.sdkAppId, ((abvp)this.startParam_).ctd, ((abvp)this.startParam_).ON, new abwb(this, paramArrayOfByte, paramCsCmdCallback));
        return true;
      }
      return false;
    }
    catch (NumberFormatException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("0", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramString.equals("VideoCCSvc.opensdk")) {
      return super.requestCmd(paramString, paramArrayOfByte, paramCsCmdCallback);
    }
    return super.requestCmd(paramString, paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("1", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramArrayOfByte.length >= 0) {
      return requestCmd("3", nativeConvertToIMReportData(paramArrayOfByte, paramInt, this.startParam_.sdkAppId, getTinyId(), (int)System.currentTimeMillis() / 1000), paramCsCmdCallback);
    }
    com.tencent.TMG.utils.QLog.e(TAG, 0, "requestReportCmd reportData == NULL");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwa
 * JD-Core Version:    0.7.0.1
 */