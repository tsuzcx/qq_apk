package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPoints
  extends JceStruct
{
  public int x;
  public int y;
  
  public stPoints() {}
  
  public stPoints(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x = paramJceInputStream.read(this.x, 0, false);
    this.y = paramJceInputStream.read(this.y, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x, 0);
    paramJceOutputStream.write(this.y, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stPoints
 * JD-Core Version:    0.7.0.1
 */