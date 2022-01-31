package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class single_count
  extends JceStruct
{
  public byte iControl = 0;
  public long uCount = 0L;
  
  public single_count() {}
  
  public single_count(long paramLong, byte paramByte)
  {
    this.uCount = paramLong;
    this.iControl = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCount = paramJceInputStream.read(this.uCount, 0, false);
    this.iControl = paramJceInputStream.read(this.iControl, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCount, 0);
    paramJceOutputStream.write(this.iControl, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_UNDEAL_COUNT.single_count
 * JD-Core Version:    0.7.0.1
 */