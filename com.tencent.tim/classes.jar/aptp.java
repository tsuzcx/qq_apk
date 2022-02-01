import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class aptp
  extends acnd
{
  public aptp(TroopNameHelper paramTroopNameHelper) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    this.this$0.iU.put(paramString, Long.valueOf(paramLong));
    paramList = (TroopNameHelper.GenTroopNameTask)this.this$0.iV.get(paramString);
    if (paramList != null)
    {
      TroopNameHelper.a(this.this$0, paramList);
      this.this$0.iV.remove(paramString);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopNameHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramString = String.valueOf(paramLong1);
    if ((paramInt1 == 1) && (paramBoolean) && (this.this$0.iV.containsKey(paramString)))
    {
      localObject = this.this$0.a.b(paramString);
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    if (paramList == null) {}
    for (paramInt1 = 0;; paramInt1 = paramList.size())
    {
      if (paramInt1 == 1)
      {
        paramList = (oidb_0x899.memberlist)paramList.get(0);
        if ((paramList == null) || (!paramList.uint64_member_uin.has())) {
          break;
        }
        paramList = String.valueOf(paramList.uint64_member_uin.get());
        if ((paramList != null) && (!"".equals(paramList.trim()))) {
          ((TroopInfo)localObject).troopowneruin = paramList.trim();
        }
      }
      this.this$0.a.i((TroopInfo)localObject);
      paramList = (TroopNameHelper.GenTroopNameTask)this.this$0.iV.get(paramString);
      if ((paramList == null) || (paramList.isRunning)) {
        break;
      }
      TroopNameHelper.a(this.this$0, paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptp
 * JD-Core Version:    0.7.0.1
 */