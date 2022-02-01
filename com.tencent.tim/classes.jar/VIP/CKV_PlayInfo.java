package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CKV_PlayInfo
  extends JceStruct
{
  public long iLstPlayTime;
  public String sSongId = "";
  
  public CKV_PlayInfo() {}
  
  public CKV_PlayInfo(String paramString, long paramLong)
  {
    this.sSongId = paramString;
    this.iLstPlayTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSongId = paramJceInputStream.readString(0, false);
    this.iLstPlayTime = paramJceInputStream.read(this.iLstPlayTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSongId != null) {
      paramJceOutputStream.write(this.sSongId, 0);
    }
    paramJceOutputStream.write(this.iLstPlayTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.CKV_PlayInfo
 * JD-Core Version:    0.7.0.1
 */