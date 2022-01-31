package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  public int Version = 0;
  
  public ReqHeader() {}
  
  public ReqHeader(int paramInt)
  {
    this.Version = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Version = paramJceInputStream.read(this.Version, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Version, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GeneralSettings.ReqHeader
 * JD-Core Version:    0.7.0.1
 */