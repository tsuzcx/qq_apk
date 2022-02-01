import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class appw
  extends acnd
{
  public appw(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify noVerify:" + paramInt);
      }
      this.this$0.dVl = paramInt;
      if (this.this$0.dVl == 1)
      {
        if (this.this$0.a.isHomeworkTroop())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify isHomeworkTroop true");
          }
          this.this$0.Ax(1);
          return;
        }
        this.this$0.bLs();
        return;
      }
      VisitorTroopCardFragment.b(this.this$0);
      return;
    }
    VisitorTroopCardFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appw
 * JD-Core Version:    0.7.0.1
 */