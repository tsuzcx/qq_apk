import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class apgj
  implements Manager
{
  public apgi a;
  private long arv;
  
  public apgj(QQAppInterface paramQQAppInterface) {}
  
  public void RH(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.RH(paramBoolean);
    }
  }
  
  public void WH(int paramInt)
  {
    if ((this.a instanceof apml)) {
      this.a.RG(apqz.mg(paramInt));
    }
  }
  
  public apgi a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.arv);
    }
    if ((paramLong != this.arv) && (this.a != null)) {
      this.a.a(false, paramTroopChatPie, paramBoolean);
    }
    this.a = a(paramTroopChatPie, paramString);
    if (this.a != null) {
      this.a.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.arv = paramLong;
      return this.a;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public apgi a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.app, paramString))
    {
      if (!(this.a instanceof apml)) {
        this.a = new apml(paramTroopChatPie.app, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.arv = 32L;
    }
    for (;;)
    {
      return this.a;
      if (TroopInfo.isFansTroop(paramTroopChatPie.app, paramString))
      {
        this.arv = 27L;
      }
      else
      {
        this.a = null;
        this.arv = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void dZr()
  {
    if (this.a != null) {
      this.a.dZr();
    }
  }
  
  public void dZs()
  {
    if (this.a != null) {
      this.a.dZs();
    }
  }
  
  public void dZt()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    this.a = null;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgj
 * JD-Core Version:    0.7.0.1
 */