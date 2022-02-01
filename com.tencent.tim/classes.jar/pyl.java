import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

public class pyl<REQ extends MessageMicro>
  extends ppw<pzy>
{
  public final REQ b;
  public final Bundle mBundle;
  public final String mCmd;
  
  public pyl(String paramString, REQ paramREQ, Bundle paramBundle)
  {
    this.mCmd = paramString;
    this.b = paramREQ;
    this.mBundle = paramBundle;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    return new pzy(paramArrayOfByte);
  }
  
  protected byte[] encode()
  {
    return this.b.toByteArray();
  }
  
  public String mg()
  {
    return this.mCmd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyl
 * JD-Core Version:    0.7.0.1
 */