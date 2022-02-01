package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stNewsRedDot
  extends JceStruct
{
  public int newsCount;
  
  public stNewsRedDot() {}
  
  public stNewsRedDot(int paramInt)
  {
    this.newsCount = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.newsCount = paramJceInputStream.read(this.newsCount, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.newsCount, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stNewsRedDot
 * JD-Core Version:    0.7.0.1
 */