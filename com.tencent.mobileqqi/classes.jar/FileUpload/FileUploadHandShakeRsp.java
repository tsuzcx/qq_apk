package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FileUploadHandShakeRsp
  extends JceStruct
{
  static ArrayList<IpInfo> cache_vRedirectIp;
  public long iClientIP = 0L;
  public int iProtocal = 0;
  public long iServerTime = 0L;
  public ArrayList<IpInfo> vRedirectIp = null;
  
  public FileUploadHandShakeRsp() {}
  
  public FileUploadHandShakeRsp(ArrayList<IpInfo> paramArrayList, int paramInt, long paramLong1, long paramLong2)
  {
    this.vRedirectIp = paramArrayList;
    this.iProtocal = paramInt;
    this.iServerTime = paramLong1;
    this.iClientIP = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vRedirectIp == null)
    {
      cache_vRedirectIp = new ArrayList();
      IpInfo localIpInfo = new IpInfo();
      cache_vRedirectIp.add(localIpInfo);
    }
    this.vRedirectIp = ((ArrayList)paramJceInputStream.read(cache_vRedirectIp, 0, false));
    this.iProtocal = paramJceInputStream.read(this.iProtocal, 1, false);
    this.iServerTime = paramJceInputStream.read(this.iServerTime, 2, false);
    this.iClientIP = paramJceInputStream.read(this.iClientIP, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vRedirectIp != null) {
      paramJceOutputStream.write(this.vRedirectIp, 0);
    }
    paramJceOutputStream.write(this.iProtocal, 1);
    paramJceOutputStream.write(this.iServerTime, 2);
    paramJceOutputStream.write(this.iClientIP, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.FileUploadHandShakeRsp
 * JD-Core Version:    0.7.0.1
 */