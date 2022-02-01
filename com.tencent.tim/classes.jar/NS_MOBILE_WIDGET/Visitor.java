package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Visitor
  extends JceStruct
{
  public long uin;
  public int visit_time;
  
  public Visitor() {}
  
  public Visitor(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.visit_time = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.visit_time = paramJceInputStream.read(this.visit_time, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.visit_time, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.Visitor
 * JD-Core Version:    0.7.0.1
 */