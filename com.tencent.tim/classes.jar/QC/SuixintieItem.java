package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SuixintieItem
  extends JceStruct
{
  public int appid;
  public int feeType;
  public String image = "";
  public int itemid;
  public String name = "";
  
  public SuixintieItem() {}
  
  public SuixintieItem(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.appid = paramInt1;
    this.itemid = paramInt2;
    this.name = paramString1;
    this.feeType = paramInt3;
    this.image = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.itemid = paramJceInputStream.read(this.itemid, 1, false);
    this.name = paramJceInputStream.readString(2, false);
    this.feeType = paramJceInputStream.read(this.feeType, 3, false);
    this.image = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.itemid, 1);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 2);
    }
    paramJceOutputStream.write(this.feeType, 3);
    if (this.image != null) {
      paramJceOutputStream.write(this.image, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.SuixintieItem
 * JD-Core Version:    0.7.0.1
 */