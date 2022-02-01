package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespSetSettings
  extends JceStruct
{
  public int Revision;
  
  public RespSetSettings() {}
  
  public RespSetSettings(int paramInt)
  {
    this.Revision = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Revision = paramJceInputStream.read(this.Revision, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Revision, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     GeneralSettings.RespSetSettings
 * JD-Core Version:    0.7.0.1
 */