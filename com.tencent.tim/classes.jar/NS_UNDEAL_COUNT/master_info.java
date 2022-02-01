package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class master_info
  extends JceStruct
{
  public long host_unimbitmap;
  public int iLevel;
  public String strMessage = "";
  
  public master_info() {}
  
  public master_info(int paramInt, String paramString, long paramLong)
  {
    this.iLevel = paramInt;
    this.strMessage = paramString;
    this.host_unimbitmap = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLevel = paramJceInputStream.read(this.iLevel, 0, false);
    this.strMessage = paramJceInputStream.readString(1, false);
    this.host_unimbitmap = paramJceInputStream.read(this.host_unimbitmap, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLevel, 0);
    if (this.strMessage != null) {
      paramJceOutputStream.write(this.strMessage, 1);
    }
    paramJceOutputStream.write(this.host_unimbitmap, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.master_info
 * JD-Core Version:    0.7.0.1
 */