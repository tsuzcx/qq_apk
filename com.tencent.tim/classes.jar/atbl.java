import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

class atbl
  extends acnd
{
  atbl(atbj paramatbj) {}
  
  protected void v(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileModel", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.this$0.c.troopUin))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileModel", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.this$0.c.troopUin);
          }
        }
        else if (paramObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("ProfileModel", 2, "onGetTroopMemberCard: cardInfo==null");
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("ProfileModel", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        l = paramObject.memberUin;
        if (l != Long.parseLong(this.this$0.c.d.uin))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileModel", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.this$0.c.d.uin);
          }
        }
        else if ((this.this$0.c == null) || (this.this$0.c.d == null) || (this.this$0.c.e == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileModel", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.card == null || cardInfo.allinone == null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileModel", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
          }
          this.this$0.c.c = paramObject;
          this.this$0.c.cwd = true;
          if ((paramObject.result == 260) && (paramObject.memberRole == 0))
          {
            atbj.a(this.this$0, 2);
            this.this$0.c.c = paramObject;
            if (!TroopInfo.isQidianPrivateTroop(this.this$0.mApp, this.this$0.c.troopUin))
            {
              this.this$0.c.cwc = false;
              atbj.a(this.this$0, 1000, true, "");
              return;
            }
            this.this$0.c.cwd = false;
            return;
          }
          if (paramObject.titleId == 0)
          {
            Object localObject = (TroopManager)this.this$0.mApp.getManager(52);
            if (localObject != null)
            {
              localObject = ((TroopManager)localObject).b(this.this$0.c.troopUin, this.this$0.c.d.uin);
              if (localObject != null)
              {
                paramObject.titleId = ((TroopMemberInfo)localObject).level;
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileModel", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbl
 * JD-Core Version:    0.7.0.1
 */