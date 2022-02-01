package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Color
  extends JceStruct
{
  public long B;
  public long G;
  public long R;
  
  public Color() {}
  
  public Color(long paramLong1, long paramLong2, long paramLong3)
  {
    this.R = paramLong1;
    this.G = paramLong2;
    this.B = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.R = paramJceInputStream.read(this.R, 0, true);
    this.G = paramJceInputStream.read(this.G, 1, true);
    this.B = paramJceInputStream.read(this.B, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.R, 0);
    paramJceOutputStream.write(this.G, 1);
    paramJceOutputStream.write(this.B, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NearbyGroup.Color
 * JD-Core Version:    0.7.0.1
 */