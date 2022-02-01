package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DiscussReqHeader
  extends JceStruct
{
  public int Version;
  
  public DiscussReqHeader() {}
  
  public DiscussReqHeader(int paramInt)
  {
    this.Version = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Version = paramJceInputStream.read(this.Version, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Version, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.DiscussReqHeader
 * JD-Core Version:    0.7.0.1
 */