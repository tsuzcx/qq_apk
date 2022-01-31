package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetSoftwaresOnTop
  extends JceStruct
{
  public int pageno = 0;
  public int pagesize = 0;
  public byte sorttype = 0;
  
  public ReqGetSoftwaresOnTop() {}
  
  public ReqGetSoftwaresOnTop(byte paramByte, int paramInt1, int paramInt2)
  {
    this.sorttype = paramByte;
    this.pageno = paramInt1;
    this.pagesize = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sorttype = paramJceInputStream.read(this.sorttype, 0, true);
    this.pageno = paramJceInputStream.read(this.pageno, 1, false);
    this.pagesize = paramJceInputStream.read(this.pagesize, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sorttype, 0);
    paramJceOutputStream.write(this.pageno, 1);
    paramJceOutputStream.write(this.pagesize, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     acs.ReqGetSoftwaresOnTop
 * JD-Core Version:    0.7.0.1
 */