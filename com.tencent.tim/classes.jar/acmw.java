import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acmw
  extends acnd
{
  public acmw(TroopManager paramTroopManager) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onGetTroopInfoResult success: troopUin: " + paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("onUpdateTroopGetMemberList(memberLimit), troopUin:").append(paramString).append(", mGetTroopMemberListTroops == null:");
      if (TroopManager.a(this.this$0) == null)
      {
        bool = true;
        QLog.i("Q.contacttab.troop", 2, bool);
      }
    }
    else
    {
      paramList = new ArrayList();
      paramList.add(paramString);
      if (TroopManager.a(this.this$0) != null) {
        break label95;
      }
      this.this$0.dO(paramList);
    }
    label95:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (TroopManager.a(this.this$0).size() <= 0);
        localTroopInfo = (TroopInfo)TroopManager.a(this.this$0).get(0);
      } while (!localTroopInfo.troopuin.equals(paramString));
      acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
      if (paramBoolean) {
        break label280;
      }
      if (TroopManager.a(this.this$0) >= 3) {
        break label236;
      }
      localacms.b(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 4);
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:" + TroopManager.b(this.this$0) + ", troopUin" + localTroopInfo.troopuin);
    return;
    label236:
    this.this$0.Fx(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.contacttab.troop", 2, "notifyTroopMembersUpdate, troopUin:" + paramString);
      }
      cMY();
      return;
      label280:
      this.this$0.dO(paramList);
    }
  }
  
  protected void aw(boolean paramBoolean, String paramString)
  {
    QLog.i("troop_ext", 1, "onActiveExtTroop success: " + paramBoolean + " troopUin: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      ((acms)this.this$0.app.getBusinessHandler(20)).Fa(paramString);
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramString = (TroopMemberCardInfo)paramArrayList.get(i);
        this.this$0.fb(paramString.troopuin, paramString.memberuin);
        i += 1;
      }
    }
  }
  
  protected void cMY()
  {
    synchronized (this.this$0)
    {
      TroopManager.a(this.this$0).remove(0);
      if (TroopManager.a(this.this$0).size() > 0)
      {
        ??? = (TroopInfo)TroopManager.a(this.this$0).get(0);
        TroopManager.a(this.this$0, 0);
        ((acms)this.this$0.app.getBusinessHandler(20)).b(true, ((TroopInfo)???).troopuin, ((TroopInfo)???).troopcode, 4);
        return;
      }
    }
    synchronized (this.this$0)
    {
      TroopManager.a(this.this$0, null);
      return;
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    }
    Object localObject2;
    do
    {
      return;
      this.this$0.Fw(paramString);
      synchronized (this.this$0)
      {
        if (TroopManager.a(this.this$0) != null)
        {
          localObject2 = TroopManager.a(this.this$0).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((TroopInfo)((Iterator)localObject2).next()).troopuin.equals(paramString)) {
              ((Iterator)localObject2).remove();
            }
          }
        }
        return;
      }
      ??? = new ArrayList();
      ((ArrayList)???).add(paramString);
      this.this$0.dO((ArrayList)???);
      return;
      localObject2 = this.this$0.b(paramString);
    } while ((localObject2 == null) || (!TroopManager.a(this.this$0, (TroopInfo)localObject2, true)));
    acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (TroopManager.a(this.this$0) == null)
        {
          TroopManager.a(this.this$0, new ArrayList());
          TroopManager.a(this.this$0).add(localObject2);
          localacms.b(true, paramString, ((TroopInfo)localObject2).troopcode, 9);
          return;
        }
      }
      TroopManager.a(this.this$0).add(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmw
 * JD-Core Version:    0.7.0.1
 */