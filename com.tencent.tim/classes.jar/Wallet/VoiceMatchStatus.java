package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VoiceMatchStatus
  extends JceStruct
{
  public int clientTryTime;
  public int isCliVoiceSDKReady;
  public String libVersion = "";
  public int serverTryTime;
  
  public VoiceMatchStatus() {}
  
  public VoiceMatchStatus(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.isCliVoiceSDKReady = paramInt1;
    this.clientTryTime = paramInt2;
    this.serverTryTime = paramInt3;
    this.libVersion = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isCliVoiceSDKReady = paramJceInputStream.read(this.isCliVoiceSDKReady, 0, false);
    this.clientTryTime = paramJceInputStream.read(this.clientTryTime, 1, false);
    this.serverTryTime = paramJceInputStream.read(this.serverTryTime, 2, false);
    this.libVersion = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isCliVoiceSDKReady, 0);
    paramJceOutputStream.write(this.clientTryTime, 1);
    paramJceOutputStream.write(this.serverTryTime, 2);
    if (this.libVersion != null) {
      paramJceOutputStream.write(this.libVersion, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.VoiceMatchStatus
 * JD-Core Version:    0.7.0.1
 */