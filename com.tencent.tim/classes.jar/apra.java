import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.b;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

final class apra
  implements TroopManager.b
{
  apra(String paramString1, String paramString2, boolean paramBoolean, QQAppInterface paramQQAppInterface, apqz.a parama) {}
  
  public void b(TroopMemberInfo paramTroopMemberInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkHomeworkTroopIdentity. troopUin=").append(this.Uf).append(", memberUin=").append(this.aMs).append(", level=");
      if (paramTroopMemberInfo != null) {
        break label150;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append(localObject).append(", reqMemberInfo=").append(this.cRZ).append(", hwIdentity=");
      if (paramTroopMemberInfo != null) {
        break label162;
      }
    }
    label150:
    label162:
    for (Object localObject = "";; localObject = Integer.valueOf(paramTroopMemberInfo.hwIdentity))
    {
      QLog.i("hw_troop", 2, localObject);
      if (paramTroopMemberInfo != null) {
        break label216;
      }
      if (this.cRZ) {}
      try
      {
        long l1 = Long.parseLong(this.Uf);
        long l2 = Long.parseLong(this.aMs);
        ((acms)this.val$app.getBusinessHandler(20)).i(l1, l2, true);
        return;
      }
      catch (NumberFormatException paramTroopMemberInfo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("hw_troop", 2, new Object[] { "checkIdentity NumberFormatException,info.troopuin=", this.Uf, ", memberuin=", this.aMs });
        return;
      }
      localObject = Integer.valueOf(paramTroopMemberInfo.level);
      break;
    }
    label216:
    if (!apqz.mf(paramTroopMemberInfo.hwIdentity))
    {
      ((acms)this.val$app.getBusinessHandler(20)).eY(this.Uf, this.aMs);
      return;
    }
    apqz.b(this.b, paramTroopMemberInfo.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apra
 * JD-Core Version:    0.7.0.1
 */