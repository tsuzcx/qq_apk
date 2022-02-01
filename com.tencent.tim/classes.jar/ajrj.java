import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;

public class ajrj
  extends apuv
{
  private NearbyAppInterface a;
  
  public ajrj(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.a = paramNearbyAppInterface;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.a == null) {
      return null;
    }
    return (UsingTimeReportManager)this.a.getManager(221);
  }
  
  public void kj(long paramLong)
  {
    if (this.a != null) {
      this.a.reportClickEvent("dc00899", this.mDepartment, "", this.mOpType, this.mOpName, 0, 0, String.valueOf(paramLong), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrj
 * JD-Core Version:    0.7.0.1
 */