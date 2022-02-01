import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public class apnv
{
  private long Hm;
  private long arN;
  private TroopManager b;
  private int dVa;
  private QQAppInterface mApp;
  
  public apnv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = ((TroopManager)this.mApp.getManager(52));
  }
  
  private boolean d(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    long l;
    do
    {
      do
      {
        return true;
        if (this.dVa != paramTroopInfo.wMemberNum) {
          return false;
        }
        l = System.currentTimeMillis();
        if (paramTroopInfo.wMemberNum > 500) {
          break;
        }
      } while (l - this.arN < 180000L);
      return false;
    } while (l - this.arN < 1800000L);
    return false;
  }
  
  public void Tp(String paramString)
  {
    TroopInfo localTroopInfo = this.b.b(paramString);
    acms localacms = (acms)this.mApp.getBusinessHandler(20);
    if ((localacms != null) && (this.b != null))
    {
      this.Hm = System.currentTimeMillis();
      localacms.a(true, paramString, localTroopInfo.troopcode, true, 2, this.Hm, 0);
      this.dVa = localTroopInfo.wMemberNum;
      this.arN = System.currentTimeMillis();
    }
  }
  
  public boolean qE(String paramString)
  {
    return d(this.b.b(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnv
 * JD-Core Version:    0.7.0.1
 */