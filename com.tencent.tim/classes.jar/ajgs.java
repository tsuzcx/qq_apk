import android.support.annotation.NonNull;
import java.util.ArrayList;

public class ajgs
{
  public long acA;
  public long acB;
  public long acC;
  public long acD;
  public long acE;
  public long acF;
  public long acG;
  public long acq;
  public long acr;
  public long acs;
  public long act;
  public long acu;
  public long acv;
  public long acw;
  public long acx;
  public long acy;
  public long acz;
  public int bizType;
  public double cN;
  public int connectType;
  public boolean cos;
  public int errorCode;
  public int platForm;
  public long totalCost;
  public boolean udpDetected;
  public ArrayList<ajgs.a> xI = new ArrayList();
  
  public void clear()
  {
    this.bizType = 0;
    this.platForm = 0;
    this.cos = false;
    this.errorCode = 0;
    this.totalCost = 0L;
    this.cN = 0.0D;
    this.acq = 0L;
    this.acr = 0L;
    this.acs = 0L;
    this.act = 0L;
    this.acu = 0L;
    this.acv = 0L;
    this.acw = 0L;
    this.acx = 0L;
    this.acy = 0L;
    this.acz = 0L;
    this.acA = 0L;
    this.acB = 0L;
    this.acC = 0L;
    this.acD = 0L;
    this.udpDetected = false;
    this.connectType = 0;
    this.acE = 0L;
    this.acF = 0L;
    this.acG = 0L;
    this.xI.clear();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[bizType = ").append(this.bizType).append("\n platForm = ").append(this.platForm).append("\n requestStatus = ").append(this.cos).append("\n errorCode = ").append(this.errorCode).append("\n totalCost = ").append(this.totalCost).append("\n averageSpeed = ").append(this.cN).append("\n totalSessionCount = ").append(this.acq).append("\n finishedSessionCount = ").append(this.acr).append("\n resSessionContains = ").append(this.acs).append("\n resTotalSize = ").append(this.act).append("\n dbTotalSize = ").append(this.acu).append("\n resRequestCount = ").append(this.acv).append("\n resRequestFailedCount = ").append(this.acw).append("\n resRequestCancelCount = ").append(this.acx).append("\n resTrivialCount = ").append(this.acy).append("\n resTrivialFailedCount = ").append(this.acz).append("\n resTrivialCancelCount = ").append(this.acA).append("\n dbRequestCount = ").append(this.acB).append("\n dbRequestFailedCount = ").append(this.acC).append("\n dbRequestCancelCount = ").append(this.acD).append("\n connectType = ").append(this.connectType).append("\n connectElipse = ").append(this.acE).append("\n sessionReadyAllTimes = ").append(this.acF).append("\n fileFailedCount = ").append(this.acG).append("\n fileErrorList = ").append(this.xI).append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int diY;
    public int errorCode;
    public int fileType;
    
    @NonNull
    public String toString()
    {
      return "[errorCode = " + this.errorCode + ", fileType = " + this.fileType + ", fileTrivial = " + this.diY + "]";
    }
  }
  
  public static class b
  {
    public boolean cot;
    public long fileSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgs
 * JD-Core Version:    0.7.0.1
 */