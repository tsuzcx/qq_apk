package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RedTouchInfo
  extends JceStruct
{
  public boolean hasRed = true;
  
  public RedTouchInfo() {}
  
  public RedTouchInfo(boolean paramBoolean)
  {
    this.hasRed = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasRed = paramJceInputStream.read(this.hasRed, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasRed, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VIP.RedTouchInfo
 * JD-Core Version:    0.7.0.1
 */