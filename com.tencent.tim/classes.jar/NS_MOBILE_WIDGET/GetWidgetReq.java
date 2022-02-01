package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetWidgetReq
  extends JceStruct
{
  public String attach_info = "";
  public int time;
  public int widgetid;
  public int zone;
  
  public GetWidgetReq() {}
  
  public GetWidgetReq(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.widgetid = paramInt1;
    this.time = paramInt2;
    this.zone = paramInt3;
    this.attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.widgetid = paramJceInputStream.read(this.widgetid, 0, true);
    this.time = paramJceInputStream.read(this.time, 1, false);
    this.zone = paramJceInputStream.read(this.zone, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.widgetid, 0);
    paramJceOutputStream.write(this.time, 1);
    paramJceOutputStream.write(this.zone, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.GetWidgetReq
 * JD-Core Version:    0.7.0.1
 */