package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcRequestHead
  extends JceStruct
{
  static int cache_iCmdID;
  static int cache_iUploadType;
  static Map<String, byte[]> cache_mapExt;
  static byte[] cache_vLoginData;
  static byte[] cache_vLoginKey;
  public int appid = 0;
  public int httpRspProcess = 0;
  public int iCmdID = 0;
  public int iDescLen = 0;
  public long iFileLen = 0L;
  public int iFileType = 0;
  public int iLoginType = 0;
  public int iNetType = 0;
  public long iOffset = 0L;
  public long iPartDataLen = 0L;
  public int iSource = 0;
  public int iSync = 0;
  public long iUin = 0L;
  public int iUploadType = 0;
  public short iVersionId = 0;
  public Map<String, byte[]> mapExt = null;
  public int md5filelen = 0;
  public int md5type = 0;
  public int noRspProcess = 0;
  public String pengyouId = "";
  public int preupload = 0;
  public String sDescMD5 = "";
  public String sDeviceInfo = "";
  public String sFileMD5 = "";
  public String sOperator = "";
  public String sQua = "";
  public String sRefer = "";
  public String seq = "";
  public int uintype = 0;
  public byte[] vLoginData = null;
  public byte[] vLoginKey = null;
  
  public SvcRequestHead() {}
  
  public SvcRequestHead(short paramShort, long paramLong1, String paramString1, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt4, String paramString4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte2, int paramInt8, String paramString5, String paramString6, long paramLong4, int paramInt9, int paramInt10, int paramInt11, String paramString7, int paramInt12, int paramInt13, String paramString8, int paramInt14, Map<String, byte[]> paramMap, int paramInt15)
  {
    this.iVersionId = paramShort;
    this.iUin = paramLong1;
    this.sRefer = paramString1;
    this.iLoginType = paramInt1;
    this.vLoginData = paramArrayOfByte1;
    this.iUploadType = paramInt2;
    this.iCmdID = paramInt3;
    this.sFileMD5 = paramString2;
    this.sDescMD5 = paramString3;
    this.iFileLen = paramLong2;
    this.iOffset = paramLong3;
    this.iNetType = paramInt4;
    this.sOperator = paramString4;
    this.iSync = paramInt5;
    this.iSource = paramInt6;
    this.iFileType = paramInt7;
    this.vLoginKey = paramArrayOfByte2;
    this.iDescLen = paramInt8;
    this.sQua = paramString5;
    this.sDeviceInfo = paramString6;
    this.iPartDataLen = paramLong4;
    this.md5type = paramInt9;
    this.md5filelen = paramInt10;
    this.noRspProcess = paramInt11;
    this.seq = paramString7;
    this.httpRspProcess = paramInt12;
    this.uintype = paramInt13;
    this.pengyouId = paramString8;
    this.preupload = paramInt14;
    this.mapExt = paramMap;
    this.appid = paramInt15;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersionId = paramJceInputStream.read(this.iVersionId, 0, true);
    this.iUin = paramJceInputStream.read(this.iUin, 1, true);
    this.sRefer = paramJceInputStream.readString(2, true);
    this.iLoginType = paramJceInputStream.read(this.iLoginType, 3, true);
    if (cache_vLoginData == null)
    {
      cache_vLoginData = new byte[1];
      cache_vLoginData[0] = 0;
    }
    this.vLoginData = paramJceInputStream.read(cache_vLoginData, 4, true);
    this.iUploadType = paramJceInputStream.read(this.iUploadType, 5, true);
    this.iCmdID = paramJceInputStream.read(this.iCmdID, 6, true);
    this.sFileMD5 = paramJceInputStream.readString(7, true);
    this.sDescMD5 = paramJceInputStream.readString(8, true);
    this.iFileLen = paramJceInputStream.read(this.iFileLen, 9, true);
    this.iOffset = paramJceInputStream.read(this.iOffset, 10, false);
    this.iNetType = paramJceInputStream.read(this.iNetType, 11, false);
    this.sOperator = paramJceInputStream.readString(12, false);
    this.iSync = paramJceInputStream.read(this.iSync, 13, false);
    this.iSource = paramJceInputStream.read(this.iSource, 14, false);
    this.iFileType = paramJceInputStream.read(this.iFileType, 15, false);
    if (cache_vLoginKey == null)
    {
      cache_vLoginKey = new byte[1];
      cache_vLoginKey[0] = 0;
    }
    this.vLoginKey = paramJceInputStream.read(cache_vLoginKey, 16, false);
    this.iDescLen = paramJceInputStream.read(this.iDescLen, 17, false);
    this.sQua = paramJceInputStream.readString(18, false);
    this.sDeviceInfo = paramJceInputStream.readString(19, false);
    this.iPartDataLen = paramJceInputStream.read(this.iPartDataLen, 20, false);
    this.md5type = paramJceInputStream.read(this.md5type, 21, false);
    this.md5filelen = paramJceInputStream.read(this.md5filelen, 22, false);
    this.noRspProcess = paramJceInputStream.read(this.noRspProcess, 23, false);
    this.seq = paramJceInputStream.readString(24, false);
    this.httpRspProcess = paramJceInputStream.read(this.httpRspProcess, 25, false);
    this.uintype = paramJceInputStream.read(this.uintype, 26, false);
    this.pengyouId = paramJceInputStream.readString(27, false);
    this.preupload = paramJceInputStream.read(this.preupload, 28, false);
    if (cache_mapExt == null)
    {
      cache_mapExt = new HashMap();
      cache_mapExt.put("", new byte[] { 0 });
    }
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 29, false));
    this.appid = paramJceInputStream.read(this.appid, 30, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersionId, 0);
    paramJceOutputStream.write(this.iUin, 1);
    paramJceOutputStream.write(this.sRefer, 2);
    paramJceOutputStream.write(this.iLoginType, 3);
    paramJceOutputStream.write(this.vLoginData, 4);
    paramJceOutputStream.write(this.iUploadType, 5);
    paramJceOutputStream.write(this.iCmdID, 6);
    paramJceOutputStream.write(this.sFileMD5, 7);
    paramJceOutputStream.write(this.sDescMD5, 8);
    paramJceOutputStream.write(this.iFileLen, 9);
    paramJceOutputStream.write(this.iOffset, 10);
    paramJceOutputStream.write(this.iNetType, 11);
    if (this.sOperator != null) {
      paramJceOutputStream.write(this.sOperator, 12);
    }
    paramJceOutputStream.write(this.iSync, 13);
    paramJceOutputStream.write(this.iSource, 14);
    paramJceOutputStream.write(this.iFileType, 15);
    if (this.vLoginKey != null) {
      paramJceOutputStream.write(this.vLoginKey, 16);
    }
    paramJceOutputStream.write(this.iDescLen, 17);
    if (this.sQua != null) {
      paramJceOutputStream.write(this.sQua, 18);
    }
    if (this.sDeviceInfo != null) {
      paramJceOutputStream.write(this.sDeviceInfo, 19);
    }
    paramJceOutputStream.write(this.iPartDataLen, 20);
    paramJceOutputStream.write(this.md5type, 21);
    paramJceOutputStream.write(this.md5filelen, 22);
    paramJceOutputStream.write(this.noRspProcess, 23);
    if (this.seq != null) {
      paramJceOutputStream.write(this.seq, 24);
    }
    paramJceOutputStream.write(this.httpRspProcess, 25);
    paramJceOutputStream.write(this.uintype, 26);
    if (this.pengyouId != null) {
      paramJceOutputStream.write(this.pengyouId, 27);
    }
    paramJceOutputStream.write(this.preupload, 28);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 29);
    }
    paramJceOutputStream.write(this.appid, 30);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.SvcRequestHead
 * JD-Core Version:    0.7.0.1
 */