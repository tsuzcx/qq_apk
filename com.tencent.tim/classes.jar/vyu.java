import android.content.Intent;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity.a;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class vyu
  extends acnd
{
  public vyu(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onGetTroopInfoResult, isSuc=" + paramBoolean + ", groupUin : " + paramString);
    }
    TroopDisbandActivity localTroopDisbandActivity;
    if ((paramBoolean) && (aqft.equalsWithNullCheck(paramString, this.this$0.mTroopUin)))
    {
      paramString = (TroopManager)this.this$0.app.getManager(52);
      localTroopDisbandActivity = this.this$0;
      if (paramString != null) {
        break label106;
      }
    }
    label106:
    for (paramString = null;; paramString = paramString.b(this.this$0.mTroopUin))
    {
      localTroopDisbandActivity.b = paramString;
      this.this$0.a(this.this$0.b, false);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!aqft.equalsWithNullCheck(String.valueOf(paramLong1), this.this$0.mTroopUin)) {}
    Object localObject;
    label132:
    label190:
    label320:
    label590:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(150);
          ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
          QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
        }
        switch (paramInt1)
        {
        default: 
          return;
        case 4: 
          if (paramBoolean)
          {
            if (paramList == null)
            {
              paramInt1 = 0;
              paramInt2 = 0;
              if (paramInt2 >= paramInt1) {
                break label320;
              }
              paramString = (oidb_0x899.memberlist)paramList.get(paramInt2);
              if ((paramString != null) && (paramString.uint64_member_uin.has())) {
                break label190;
              }
            }
            do
            {
              paramInt2 += 1;
              break label132;
              paramInt1 = paramList.size();
              break;
              localObject = String.valueOf(paramString.uint64_member_uin.get());
            } while ((this.this$0.pG.contains(localObject)) || (localObject == null) || ("".equals(((String)localObject).trim())) || (aqft.equalsWithNullCheck(this.this$0.mSelfUin, localObject)));
            if (paramString.uint32_uin_flag.has()) {}
            for (int i = paramString.uint32_uin_flag.get();; i = 0)
            {
              this.this$0.pG.add((String)localObject + "|" + String.valueOf(i));
              break;
            }
          }
          if (this.this$0.pG.size() <= 0) {
            break label590;
          }
          paramList = (acms)this.this$0.app.getBusinessHandler(20);
          if ((paramList == null) || (!paramBoolean) || (paramLong2 <= 0L) || (this.this$0.Hb != 0L)) {
            break label418;
          }
          this.this$0.Hb = paramLong2;
          paramList.a(paramLong1, this.this$0.Hb, 4, 0, 0);
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopdisband.", 2, "handle_oidb_0x899_0|need get another package");
      return;
      if (this.this$0.jdField_a_of_type_Arib != null) {
        this.this$0.jdField_a_of_type_Arib.dismiss();
      }
      paramList = this.this$0;
      paramList.bFO &= 0xFFFFFFFD;
      paramList = new Intent(this.this$0, TroopTransferActivity.class);
      paramList.putExtra("leftViewText", this.this$0.getString(2131717262));
      paramList.putExtra("TROOP_INFO_FLAG_EXT", this.this$0.Ha);
      paramList.putExtra("troop_auth_submit_time", this.this$0.bFL);
      paramList.putStringArrayListExtra("troopVipMembers", this.this$0.pG);
      paramList.putExtra("troop_uin", this.this$0.mTroopUin);
      paramList.putExtra("troop_code", this.this$0.aKI);
      paramList.putExtra("uinname", this.this$0.mTroopName);
      this.this$0.startActivityForResult(paramList, 0);
      return;
      if (paramBoolean)
      {
        paramList = this.this$0;
        paramList.bFO &= 0xFFFFFFFD;
        if (this.this$0.jdField_a_of_type_Arib == null) {
          this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
        }
        this.this$0.jdField_a_of_type_Arib.aq(2, 2131721331, 1500);
        return;
      }
      paramList = this.this$0;
      paramList.bFO &= 0xFFFFFFFD;
      if (this.this$0.jdField_a_of_type_Arib == null) {
        this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
      }
      this.this$0.jdField_a_of_type_Arib.aq(2, 2131721326, 1500);
      return;
    } while (!paramBoolean);
    label418:
    if (paramList == null)
    {
      paramInt1 = 0;
      if ((paramInt1 > 0) && (paramInt1 < 6))
      {
        paramString = (TroopManager)this.this$0.app.getManager(52);
        localObject = this.this$0;
        if (paramString != null) {
          break label868;
        }
      }
    }
    label868:
    for (paramString = null;; paramString = paramString.b(this.this$0.mTroopUin))
    {
      ((TroopDisbandActivity)localObject).b = paramString;
      if ((this.this$0.b != null) && (this.this$0.b.wMemberNum != paramInt1)) {
        this.this$0.b.wMemberNum = paramList.size();
      }
      this.this$0.a(this.this$0.b, false);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity$a.setData(paramList);
      return;
      paramInt1 = paramList.size();
      break;
    }
  }
  
  protected void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    TroopInfo localTroopInfo = null;
    int i = 0;
    label21:
    if ((localTroopInfo == null) && (i < paramArrayList.size()))
    {
      localTroopInfo = (TroopInfo)paramArrayList.get(i);
      if (localTroopInfo != null) {
        break label56;
      }
    }
    label56:
    while (!aqft.equalsWithNullCheck(localTroopInfo.troopuin, this.this$0.mTroopUin))
    {
      i += 1;
      break label21;
      break;
    }
    this.this$0.b = localTroopInfo;
    this.this$0.a(localTroopInfo, false);
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 9)
    {
      Object localObject = this.this$0;
      ((TroopDisbandActivity)localObject).bFO &= 0xFFFFFFFE;
      if (paramInt2 == 8)
      {
        if (this.this$0.jdField_a_of_type_Arib != null) {
          this.this$0.jdField_a_of_type_Arib.dismiss();
        }
        localObject = aqha.a(this.this$0, 230);
        ((aqju)localObject).setTitle(this.this$0.getString(2131698362));
        ((aqju)localObject).setMessage(this.this$0.getString(2131698363));
        ((aqju)localObject).setNegativeButton(this.this$0.getString(2131698394), new vyv(this, (aqju)localObject));
        ((aqju)localObject).setPositiveButton(this.this$0.getString(2131720227), new vyw(this, (aqju)localObject));
        ((aqju)localObject).show();
      }
    }
    else
    {
      return;
    }
    if (this.this$0.jdField_a_of_type_Arib == null) {
      this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
    }
    this.this$0.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (!aqft.equalsWithNullCheck(paramString, this.this$0.mTroopUin)) {}
    while (paramInt1 != 9) {
      return;
    }
    paramString = this.this$0;
    paramString.bFO &= 0xFFFFFFFE;
    if (paramInt2 == 0)
    {
      if (this.this$0.jdField_a_of_type_Arib != null) {
        this.this$0.jdField_a_of_type_Arib.dismiss();
      }
      paramString = new Intent();
      paramString.putExtra("isNeedFinish", true);
      paramString.putExtra("fin_tip_msg", this.this$0.getString(2131693297));
      this.this$0.setResult(-1, paramString);
      this.this$0.finish();
      return;
    }
    if (this.this$0.jdField_a_of_type_Arib == null) {
      this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
    }
    this.this$0.jdField_a_of_type_Arib.aq(2, 2131693293, 1500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyu
 * JD-Core Version:    0.7.0.1
 */