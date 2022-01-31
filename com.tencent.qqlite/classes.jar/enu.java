import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class enu
  extends TroopObserver
{
  public enu(NearbyOpenTroop paramNearbyOpenTroop) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("NearbyOpenTroop", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt1 == 2) && (paramBoolean))
    {
      localObject1 = (FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      paramString = ((FriendManager)localObject1).a(this.a.jdField_a_of_type_JavaLangString);
      if (paramString != null) {
        break label338;
      }
      paramString = new OpenTroopInfo();
    }
    label168:
    label338:
    for (;;)
    {
      paramString.troopAdminList = "";
      Object localObject2;
      if (paramList == null)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        if (paramInt2 >= paramInt1) {
          break label293;
        }
        localObject2 = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break label226;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label168;
        paramInt1 = paramList.size();
        break;
        label226:
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim()))) {
          paramString.troopAdminList = (paramString.troopAdminList + (String)localObject2 + "|");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyOpenTroop", 2, paramString.troopAdminList);
      }
      ((FriendManager)localObject1).a(paramString, true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     enu
 * JD-Core Version:    0.7.0.1
 */