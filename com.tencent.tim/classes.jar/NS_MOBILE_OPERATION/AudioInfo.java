package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AudioInfo
  extends JceStruct
{
  public String playkey = "";
  public int time;
  
  public AudioInfo() {}
  
  public AudioInfo(String paramString, int paramInt)
  {
    this.playkey = paramString;
    this.time = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.playkey = paramJceInputStream.readString(0, false);
    this.time = paramJceInputStream.read(this.time, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.playkey != null) {
      paramJceOutputStream.write(this.playkey, 0);
    }
    paramJceOutputStream.write(this.time, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.AudioInfo
 * JD-Core Version:    0.7.0.1
 */