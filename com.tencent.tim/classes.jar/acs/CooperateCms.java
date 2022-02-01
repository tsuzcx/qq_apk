package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CooperateCms
  extends JceStruct
{
  public String androidPackage = "";
  public int elementid;
  public int fileid;
  public String picUrl = "";
  public int productid;
  public int softid;
  public String title = "";
  public String url = "";
  
  public CooperateCms() {}
  
  public CooperateCms(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4)
  {
    this.elementid = paramInt1;
    this.picUrl = paramString1;
    this.title = paramString2;
    this.url = paramString3;
    this.androidPackage = paramString4;
    this.productid = paramInt2;
    this.softid = paramInt3;
    this.fileid = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.elementid = paramJceInputStream.read(this.elementid, 0, true);
    this.picUrl = paramJceInputStream.readString(1, true);
    this.title = paramJceInputStream.readString(2, true);
    this.url = paramJceInputStream.readString(3, true);
    this.androidPackage = paramJceInputStream.readString(4, true);
    this.productid = paramJceInputStream.read(this.productid, 5, true);
    this.softid = paramJceInputStream.read(this.softid, 6, true);
    this.fileid = paramJceInputStream.read(this.fileid, 7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.elementid, 0);
    paramJceOutputStream.write(this.picUrl, 1);
    paramJceOutputStream.write(this.title, 2);
    paramJceOutputStream.write(this.url, 3);
    paramJceOutputStream.write(this.androidPackage, 4);
    paramJceOutputStream.write(this.productid, 5);
    paramJceOutputStream.write(this.softid, 6);
    paramJceOutputStream.write(this.fileid, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acs.CooperateCms
 * JD-Core Version:    0.7.0.1
 */