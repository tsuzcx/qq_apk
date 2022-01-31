package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponsePacket
  extends JceStruct
{
  static int cache_iCmdID;
  static int cache_iUploadType;
  static byte[] cache_vRspData;
  public int iCmdID = 0;
  public int iRetCode = 0;
  public int iRetSubCode = 0;
  public long iUin = 0L;
  public int iUploadType = 0;
  public String sDescMD5 = "";
  public String sFileMD5 = "";
  public String sResultDes = "";
  public String seq = "";
  public byte[] vRspData = null;
  
  public SvcResponsePacket() {}
  
  public SvcResponsePacket(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.iRetCode = paramInt1;
    this.iRetSubCode = paramInt2;
    this.sResultDes = paramString1;
    this.iUploadType = paramInt3;
    this.iCmdID = paramInt4;
    this.vRspData = paramArrayOfByte;
    this.seq = paramString2;
    this.iUin = paramLong;
    this.sFileMD5 = paramString3;
    this.sDescMD5 = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, true);
    this.iRetSubCode = paramJceInputStream.read(this.iRetSubCode, 1, true);
    this.sResultDes = paramJceInputStream.readString(2, false);
    this.iUploadType = paramJceInputStream.read(this.iUploadType, 3, true);
    this.iCmdID = paramJceInputStream.read(this.iCmdID, 4, true);
    if (cache_vRspData == null)
    {
      cache_vRspData = new byte[1];
      cache_vRspData[0] = 0;
    }
    this.vRspData = paramJceInputStream.read(cache_vRspData, 5, false);
    this.seq = paramJceInputStream.readString(6, false);
    this.iUin = paramJceInputStream.read(this.iUin, 7, false);
    this.sFileMD5 = paramJceInputStream.readString(8, false);
    this.sDescMD5 = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    paramJceOutputStream.write(this.iRetSubCode, 1);
    if (this.sResultDes != null) {
      paramJceOutputStream.write(this.sResultDes, 2);
    }
    paramJceOutputStream.write(this.iUploadType, 3);
    paramJceOutputStream.write(this.iCmdID, 4);
    if (this.vRspData != null) {
      paramJceOutputStream.write(this.vRspData, 5);
    }
    if (this.seq != null) {
      paramJceOutputStream.write(this.seq, 6);
    }
    paramJceOutputStream.write(this.iUin, 7);
    if (this.sFileMD5 != null) {
      paramJceOutputStream.write(this.sFileMD5, 8);
    }
    if (this.sDescMD5 != null) {
      paramJceOutputStream.write(this.sDescMD5, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.SvcResponsePacket
 * JD-Core Version:    0.7.0.1
 */