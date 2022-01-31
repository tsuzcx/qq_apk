package cooperation.qlink;

import java.io.Serializable;
import java.util.Random;

public class QLAndQQStructDef$ReportNbFileFileRecvInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final int _id;
  public boolean eResult;
  public QLAndQQStructDef.Ql2QQExtraTransInfo etinfo;
  public String fromUin;
  public String param_errMsg;
  public int param_exErrCode;
  public int param_failCode;
  public String param_fileName;
  public long param_fileSize;
  public int param_source;
  public long param_speed;
  public long param_speed_in;
  public long param_speed_out;
  public String reserved;
  public long rpSize;
  public String sessionid;
  public long startTime;
  
  public QLAndQQStructDef$ReportNbFileFileRecvInfo(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, long paramLong3, long paramLong4, String paramString2, int paramInt3, String paramString3, String paramString4, QLAndQQStructDef.Ql2QQExtraTransInfo paramQl2QQExtraTransInfo, String paramString5)
  {
    this.eResult = paramBoolean;
    this.startTime = 0L;
    this.rpSize = 0L;
    this.param_failCode = paramInt1;
    this.param_source = paramInt2;
    this.param_fileSize = paramLong1;
    this.param_fileName = paramString1;
    this.param_speed = paramLong2;
    this.param_speed_in = paramLong3;
    this.param_speed_out = paramLong4;
    this.param_errMsg = paramString2;
    this.param_exErrCode = paramInt3;
    this.sessionid = paramString3;
    this.fromUin = paramString4;
    this.etinfo = paramQl2QQExtraTransInfo;
    this.reserved = paramString5;
    this._id = new Random().nextInt();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("_id[").append(this._id).append("]eResult[").append(this.eResult).append("] startTime[").append(this.startTime).append("] rpSize[").append(this.rpSize).append("] param_failCode[").append(this.param_failCode).append("] param_source[").append(this.param_source).append("] param_fileSize[").append(this.param_fileSize).append("] param_fileName[").append(this.param_fileName).append("] param_speed[").append(this.param_speed).append("] param_speed_in[").append(this.param_speed_in).append("] param_speed_out[").append(this.param_speed_out).append("] param_errMsg[").append(this.param_errMsg).append("] param_exErrCode[").append(this.param_exErrCode).append("] sessionid[").append(this.sessionid).append("] fromUin[").append(this.fromUin).append("] etinfo{");
    if (this.etinfo != null) {}
    for (String str = this.etinfo.toString();; str = "null") {
      return str + "} reserved[" + this.reserved + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.ReportNbFileFileRecvInfo
 * JD-Core Version:    0.7.0.1
 */