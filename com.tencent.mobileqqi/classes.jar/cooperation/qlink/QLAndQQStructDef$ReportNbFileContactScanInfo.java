package cooperation.qlink;

import java.io.Serializable;
import java.util.Random;

public class QLAndQQStructDef$ReportNbFileContactScanInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final int _id;
  public boolean eResult;
  public int param_connApCount;
  public int param_count;
  public int param_count_fromnb;
  public int param_count_fromsvr;
  public int param_crApCount;
  public String param_errMsg;
  public int param_failCode;
  public int param_method;
  public int param_onenetCount;
  public int param_result;
  public int param_sid;
  public String reserved;
  public long rpSize;
  public long startTime;
  
  public QLAndQQStructDef$ReportNbFileContactScanInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String paramString2)
  {
    this.eResult = paramBoolean;
    this.startTime = 0L;
    this.rpSize = 0L;
    this.param_method = paramInt1;
    this.param_failCode = paramInt2;
    this.param_sid = paramInt3;
    this.param_result = paramInt4;
    this.param_errMsg = paramString1;
    this.param_count = paramInt5;
    this.param_onenetCount = paramInt6;
    this.param_crApCount = paramInt7;
    this.param_connApCount = paramInt8;
    this.param_count_fromnb = paramInt9;
    this.param_count_fromsvr = paramInt10;
    this.reserved = paramString2;
    this._id = new Random().nextInt();
  }
  
  public String toString()
  {
    return "_id[" + this._id + "] eResult[" + this.eResult + "] startTime[" + this.startTime + "] rpSize[" + this.rpSize + "] param_method[" + this.param_method + "] param_failCode[" + this.param_failCode + "] param_sid[" + this.param_sid + "] param_result[" + this.param_result + "] param_errMsg[" + this.param_errMsg + "] param_count[" + this.param_count + "] param_onenetCount[" + this.param_onenetCount + "] param_crApCount[" + this.param_crApCount + "] param_connApCount[" + this.param_connApCount + "] param_count_fromnb[" + this.param_count_fromnb + "] param_count_fromsvr[" + this.param_count_fromsvr + "] reserved[" + this.reserved + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.ReportNbFileContactScanInfo
 * JD-Core Version:    0.7.0.1
 */