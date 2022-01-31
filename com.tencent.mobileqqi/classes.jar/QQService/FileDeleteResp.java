package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileDeleteResp
  extends JceStruct
{
  static int cache_cType;
  public int cType = 0;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public int nRetCode = 0;
  public String strRetMessage = "";
  
  public FileDeleteResp() {}
  
  public FileDeleteResp(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt1;
    this.nRetCode = paramInt2;
    this.strRetMessage = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.nRetCode = paramJceInputStream.read(this.nRetCode, 3, true);
    this.strRetMessage = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.nRetCode, 3);
    if (this.strRetMessage != null) {
      paramJceOutputStream.write(this.strRetMessage, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileDeleteResp
 * JD-Core Version:    0.7.0.1
 */