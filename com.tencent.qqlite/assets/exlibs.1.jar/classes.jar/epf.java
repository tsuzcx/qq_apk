import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class epf
  extends TroopObserver
{
  public epf(TroopGagMgr paramTroopGagMgr) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopGagMgr", 2, localStringBuilder.toString());
    }
    int i = 0;
    if (paramInt1 != 6)
    {
      paramInt2 = i;
      if (paramInt1 != 3) {}
    }
    else
    {
      paramInt2 = i;
      if (paramBoolean)
      {
        paramList = paramList.iterator();
        for (paramInt1 = 0; paramList.hasNext(); paramInt1 = 1)
        {
          label115:
          paramString = (oidb_0x899.memberlist)paramList.next();
          if ((paramString == null) || (!paramString.uint64_member_uin.has()) || (!paramString.uint32_shutup_timestap.has())) {
            break label115;
          }
          paramLong2 = paramString.uint32_shutup_timestap.get();
          long l = paramString.uint64_member_uin.get();
          ((FriendsManagerImp)this.a.a.getManager(8)).a(paramLong1 + "", l + "", null, -100, null, null, -100, -100, -100, -100L, paramLong2);
        }
        paramInt2 = paramInt1;
      }
    }
    if (paramInt2 != 0) {
      TroopGagMgr.a(this.a, String.valueOf(paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     epf
 * JD-Core Version:    0.7.0.1
 */