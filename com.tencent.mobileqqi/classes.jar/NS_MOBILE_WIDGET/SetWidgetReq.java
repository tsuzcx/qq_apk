package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetWidgetReq
  extends JceStruct
{
  public int widgetid = 0;
  
  public SetWidgetReq() {}
  
  public SetWidgetReq(int paramInt)
  {
    this.widgetid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.widgetid = paramJceInputStream.read(this.widgetid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.widgetid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.SetWidgetReq
 * JD-Core Version:    0.7.0.1
 */