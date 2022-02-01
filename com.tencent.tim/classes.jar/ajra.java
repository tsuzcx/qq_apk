import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ajra
  implements Manager
{
  NearbyAppInterface a;
  public boolean cpR;
  aure<ajra.a> k = new aure();
  
  public ajra(NearbyAppInterface paramNearbyAppInterface)
  {
    this.a = paramNearbyAppInterface;
  }
  
  public void g(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ajra.a locala = (ajra.a)this.k.get(paramLong);
    if (locala == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    locala.dkK += 1;
    locala.dkL += paramInt1;
    if (paramInt2 > locala.dkM) {
      locala.dkM = paramInt2;
    }
    locala.dkN |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.k.clear();
  }
  
  public void report()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    aure localaure = this.k.a();
    acig localacig = (acig)this.a.getBusinessHandler(3);
    boolean bool = this.cpR;
    this.k.clear();
    ThreadManager.post(new NearbyReportManager.1(this, localaure, localacig, bool), 5, null, false);
  }
  
  public static class a
  {
    public long DM;
    public int dkJ;
    public int dkK;
    public int dkL;
    public int dkM;
    public int dkN;
    public int mPosition;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTinyID:").append(this.DM).append(",mPosition:").append(this.mPosition).append(",mAlgotithmID:").append(this.dkJ).append(",mEnterCount:").append(this.dkK).append(",mProfileCardDuration:").append(this.dkL).append(",mVisitPhotoCount:").append(this.dkM).append(",mOpflag:").append(this.dkN).append("|").append(Integer.toBinaryString(this.dkN));
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajra
 * JD-Core Version:    0.7.0.1
 */