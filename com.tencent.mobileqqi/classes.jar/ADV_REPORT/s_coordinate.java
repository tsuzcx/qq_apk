package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_coordinate
  extends JceStruct
{
  public int x_axis = 0;
  public int y_axis = 0;
  
  public s_coordinate() {}
  
  public s_coordinate(int paramInt1, int paramInt2)
  {
    this.x_axis = paramInt1;
    this.y_axis = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x_axis = paramJceInputStream.read(this.x_axis, 0, false);
    this.y_axis = paramJceInputStream.read(this.y_axis, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x_axis, 0);
    paramJceOutputStream.write(this.y_axis, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ADV_REPORT.s_coordinate
 * JD-Core Version:    0.7.0.1
 */