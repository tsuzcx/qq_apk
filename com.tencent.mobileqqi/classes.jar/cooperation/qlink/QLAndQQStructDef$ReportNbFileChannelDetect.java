package cooperation.qlink;

import java.io.Serializable;
import java.util.Random;

public class QLAndQQStructDef$ReportNbFileChannelDetect
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final int _id;
  public boolean eResult;
  public String param_peer;
  public int param_source;
  public String reserved;
  public long rpSize;
  public long startTime;
  
  public QLAndQQStructDef$ReportNbFileChannelDetect(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.eResult = paramBoolean;
    this.startTime = 0L;
    this.rpSize = 0L;
    this.param_peer = paramString1;
    this.param_source = paramInt;
    this.reserved = paramString2;
    this._id = new Random().nextInt();
  }
  
  public String toString()
  {
    return "_id[" + this._id + "]eResult[" + this.eResult + "] startTime[" + this.startTime + "] rpSize[" + this.rpSize + "] param_source[" + this.param_source + "] param_peer[" + this.param_peer + "] reserved[" + this.reserved + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.ReportNbFileChannelDetect
 * JD-Core Version:    0.7.0.1
 */