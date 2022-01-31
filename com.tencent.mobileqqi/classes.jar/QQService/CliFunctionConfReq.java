package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CliFunctionConfReq
  extends JceStruct
{
  static byte[] cache_strCompany;
  static byte[] cache_strModel;
  static byte[] cache_strROM;
  static ArrayList cache_vParaInfo;
  static ArrayList cache_vReqFuncInfo;
  public long iCPUFrequency = 0L;
  public long iCPUNum = 0L;
  public long iHeight = 0L;
  public long iOSVersion = 0L;
  public long iProcessMem = 0L;
  public long iTotalMem = 0L;
  public long iWidth = 0L;
  public byte[] strCompany = null;
  public byte[] strModel = null;
  public byte[] strROM = null;
  public ArrayList vParaInfo = null;
  public ArrayList vReqFuncInfo = null;
  
  public CliFunctionConfReq() {}
  
  public CliFunctionConfReq(ArrayList paramArrayList1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, ArrayList paramArrayList2)
  {
    this.vReqFuncInfo = paramArrayList1;
    this.iOSVersion = paramLong1;
    this.iCPUNum = paramLong2;
    this.iCPUFrequency = paramLong3;
    this.iTotalMem = paramLong4;
    this.iProcessMem = paramLong5;
    this.iWidth = paramLong6;
    this.iHeight = paramLong7;
    this.strCompany = paramArrayOfByte1;
    this.strModel = paramArrayOfByte2;
    this.strROM = paramArrayOfByte3;
    this.vParaInfo = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_vReqFuncInfo == null)
    {
      cache_vReqFuncInfo = new ArrayList();
      localObject = new ReqFunInfo();
      cache_vReqFuncInfo.add(localObject);
    }
    this.vReqFuncInfo = ((ArrayList)paramJceInputStream.read(cache_vReqFuncInfo, 1, true));
    this.iOSVersion = paramJceInputStream.read(this.iOSVersion, 2, true);
    this.iCPUNum = paramJceInputStream.read(this.iCPUNum, 3, true);
    this.iCPUFrequency = paramJceInputStream.read(this.iCPUFrequency, 4, true);
    this.iTotalMem = paramJceInputStream.read(this.iTotalMem, 5, true);
    this.iProcessMem = paramJceInputStream.read(this.iProcessMem, 6, true);
    this.iWidth = paramJceInputStream.read(this.iWidth, 7, true);
    this.iHeight = paramJceInputStream.read(this.iHeight, 8, true);
    if (cache_strCompany == null)
    {
      cache_strCompany = (byte[])new byte[1];
      ((byte[])cache_strCompany)[0] = 0;
    }
    this.strCompany = ((byte[])paramJceInputStream.read(cache_strCompany, 9, true));
    if (cache_strModel == null)
    {
      cache_strModel = (byte[])new byte[1];
      ((byte[])cache_strModel)[0] = 0;
    }
    this.strModel = ((byte[])paramJceInputStream.read(cache_strModel, 10, true));
    if (cache_strROM == null)
    {
      cache_strROM = (byte[])new byte[1];
      ((byte[])cache_strROM)[0] = 0;
    }
    this.strROM = ((byte[])paramJceInputStream.read(cache_strROM, 11, false));
    if (cache_vParaInfo == null)
    {
      cache_vParaInfo = new ArrayList();
      localObject = new ReqParaInfo();
      cache_vParaInfo.add(localObject);
    }
    this.vParaInfo = ((ArrayList)paramJceInputStream.read(cache_vParaInfo, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vReqFuncInfo, 1);
    paramJceOutputStream.write(this.iOSVersion, 2);
    paramJceOutputStream.write(this.iCPUNum, 3);
    paramJceOutputStream.write(this.iCPUFrequency, 4);
    paramJceOutputStream.write(this.iTotalMem, 5);
    paramJceOutputStream.write(this.iProcessMem, 6);
    paramJceOutputStream.write(this.iWidth, 7);
    paramJceOutputStream.write(this.iHeight, 8);
    paramJceOutputStream.write(this.strCompany, 9);
    paramJceOutputStream.write(this.strModel, 10);
    if (this.strROM != null) {
      paramJceOutputStream.write(this.strROM, 11);
    }
    if (this.vParaInfo != null) {
      paramJceOutputStream.write(this.vParaInfo, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.CliFunctionConfReq
 * JD-Core Version:    0.7.0.1
 */