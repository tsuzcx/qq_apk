package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileQueryResp
  extends JceStruct
{
  static int cache_cType;
  static ArrayList cache_vFileInfo;
  public short cIsEnd = 0;
  public byte cQueryType = 0;
  public int cType = 0;
  public long lFromUIN = 0L;
  public long lToUIN = 0L;
  public int nRetCode = 0;
  public short shBegin = 0;
  public short shCount = 0;
  public short shTotalCount = 0;
  public String strRetMessage = "";
  public ArrayList vFileInfo = null;
  
  public FileQueryResp() {}
  
  public FileQueryResp(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, byte paramByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, ArrayList paramArrayList)
  {
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.cType = paramInt1;
    this.nRetCode = paramInt2;
    this.strRetMessage = paramString;
    this.cQueryType = paramByte;
    this.shTotalCount = paramShort1;
    this.shBegin = paramShort2;
    this.shCount = paramShort3;
    this.cIsEnd = paramShort4;
    this.vFileInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.nRetCode = paramJceInputStream.read(this.nRetCode, 3, true);
    this.strRetMessage = paramJceInputStream.readString(4, true);
    this.cQueryType = paramJceInputStream.read(this.cQueryType, 5, true);
    this.shTotalCount = paramJceInputStream.read(this.shTotalCount, 6, true);
    this.shBegin = paramJceInputStream.read(this.shBegin, 7, true);
    this.shCount = paramJceInputStream.read(this.shCount, 8, true);
    this.cIsEnd = paramJceInputStream.read(this.cIsEnd, 9, true);
    if (cache_vFileInfo == null)
    {
      cache_vFileInfo = new ArrayList();
      TransFileInfo localTransFileInfo = new TransFileInfo();
      cache_vFileInfo.add(localTransFileInfo);
    }
    this.vFileInfo = ((ArrayList)paramJceInputStream.read(cache_vFileInfo, 10, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.nRetCode, 3);
    paramJceOutputStream.write(this.strRetMessage, 4);
    paramJceOutputStream.write(this.cQueryType, 5);
    paramJceOutputStream.write(this.shTotalCount, 6);
    paramJceOutputStream.write(this.shBegin, 7);
    paramJceOutputStream.write(this.shCount, 8);
    paramJceOutputStream.write(this.cIsEnd, 9);
    paramJceOutputStream.write(this.vFileInfo, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FileQueryResp
 * JD-Core Version:    0.7.0.1
 */