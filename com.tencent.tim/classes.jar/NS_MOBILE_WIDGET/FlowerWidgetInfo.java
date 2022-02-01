package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FlowerWidgetInfo
  extends JceStruct
{
  public String flowerpicurl = "";
  public int love;
  public int lovemax;
  public int nutri;
  public int nutrimax;
  public int rain;
  public int rainmax;
  public int sun;
  public int sunmax;
  
  public FlowerWidgetInfo() {}
  
  public FlowerWidgetInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    this.sun = paramInt1;
    this.sunmax = paramInt2;
    this.rain = paramInt3;
    this.rainmax = paramInt4;
    this.love = paramInt5;
    this.lovemax = paramInt6;
    this.nutri = paramInt7;
    this.nutrimax = paramInt8;
    this.flowerpicurl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sun = paramJceInputStream.read(this.sun, 0, false);
    this.sunmax = paramJceInputStream.read(this.sunmax, 1, false);
    this.rain = paramJceInputStream.read(this.rain, 2, false);
    this.rainmax = paramJceInputStream.read(this.rainmax, 3, false);
    this.love = paramJceInputStream.read(this.love, 4, false);
    this.lovemax = paramJceInputStream.read(this.lovemax, 5, false);
    this.nutri = paramJceInputStream.read(this.nutri, 6, false);
    this.nutrimax = paramJceInputStream.read(this.nutrimax, 7, false);
    this.flowerpicurl = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sun, 0);
    paramJceOutputStream.write(this.sunmax, 1);
    paramJceOutputStream.write(this.rain, 2);
    paramJceOutputStream.write(this.rainmax, 3);
    paramJceOutputStream.write(this.love, 4);
    paramJceOutputStream.write(this.lovemax, 5);
    paramJceOutputStream.write(this.nutri, 6);
    paramJceOutputStream.write(this.nutrimax, 7);
    if (this.flowerpicurl != null) {
      paramJceOutputStream.write(this.flowerpicurl, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.FlowerWidgetInfo
 * JD-Core Version:    0.7.0.1
 */