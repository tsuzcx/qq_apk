package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ADInfo
  extends JceStruct
{
  static SoftKey dw;
  public int adid = 0;
  public int adtype = 0;
  public int categoryid = 0;
  public String description = "";
  public int jumptype = 0;
  public String picalt = "";
  public String picurl = "";
  public SoftKey softkey = null;
  public String url = "";
  
  public ADInfo() {}
  
  public ADInfo(int paramInt1, String paramString1, String paramString2, SoftKey paramSoftKey, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4)
  {
    this.adid = paramInt1;
    this.picurl = paramString1;
    this.picalt = paramString2;
    this.softkey = paramSoftKey;
    this.description = paramString3;
    this.adtype = paramInt2;
    this.url = paramString4;
    this.jumptype = paramInt3;
    this.categoryid = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.adid = paramJceInputStream.read(this.adid, 0, true);
    this.picurl = paramJceInputStream.readString(1, true);
    this.picalt = paramJceInputStream.readString(2, true);
    if (dw == null) {
      dw = new SoftKey();
    }
    this.softkey = ((SoftKey)paramJceInputStream.read(dw, 3, true));
    this.description = paramJceInputStream.readString(4, true);
    this.adtype = paramJceInputStream.read(this.adtype, 5, false);
    this.url = paramJceInputStream.readString(6, false);
    this.jumptype = paramJceInputStream.read(this.jumptype, 7, false);
    this.categoryid = paramJceInputStream.read(this.categoryid, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.adid, 0);
    paramJceOutputStream.write(this.picurl, 1);
    paramJceOutputStream.write(this.picalt, 2);
    paramJceOutputStream.write(this.softkey, 3);
    paramJceOutputStream.write(this.description, 4);
    paramJceOutputStream.write(this.adtype, 5);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 6);
    }
    paramJceOutputStream.write(this.jumptype, 7);
    paramJceOutputStream.write(this.categoryid, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ADInfo
 * JD-Core Version:    0.7.0.1
 */