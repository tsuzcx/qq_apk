package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WidGetInfo
  extends JceStruct
{
  static int cache_eWid;
  static int cache_type;
  public int eWid = 0;
  public String iconUrl = "";
  public String name = "";
  public long pluginId = 0L;
  public int type = 0;
  public long uIsNew = 0L;
  public String widgetUrl = "";
  
  public WidGetInfo() {}
  
  public WidGetInfo(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, int paramInt2)
  {
    this.type = paramInt1;
    this.name = paramString1;
    this.iconUrl = paramString2;
    this.widgetUrl = paramString3;
    this.uIsNew = paramLong1;
    this.pluginId = paramLong2;
    this.eWid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.iconUrl = paramJceInputStream.readString(2, false);
    this.widgetUrl = paramJceInputStream.readString(3, false);
    this.uIsNew = paramJceInputStream.read(this.uIsNew, 4, false);
    this.pluginId = paramJceInputStream.read(this.pluginId, 5, false);
    this.eWid = paramJceInputStream.read(this.eWid, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 1);
    }
    if (this.iconUrl != null) {
      paramJceOutputStream.write(this.iconUrl, 2);
    }
    if (this.widgetUrl != null) {
      paramJceOutputStream.write(this.widgetUrl, 3);
    }
    paramJceOutputStream.write(this.uIsNew, 4);
    paramJceOutputStream.write(this.pluginId, 5);
    paramJceOutputStream.write(this.eWid, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.WidGetInfo
 * JD-Core Version:    0.7.0.1
 */