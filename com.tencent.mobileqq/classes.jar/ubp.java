import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;

public class ubp
  extends TroopObserver
{
  public ubp(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new ubr(this, paramString2), 8, null, true);
  }
  
  protected void a(String paramString, boolean paramBoolean, List paramList, int paramInt, long paramLong)
  {
    if (!this.a.jdField_b_of_type_JavaLangString.equals(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:" + this.a.jdField_b_of_type_JavaLangString + "|troopUin:" + paramString);
      }
    }
    do
    {
      int i;
      do
      {
        return;
        i = TroopMemberListActivity.d(this.a);
        if (i == paramInt) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,realReqType != reqType, realReqType:" + i + "|reqType:" + paramInt);
      return;
      if (this.a.jdField_a_of_type_Long == paramLong) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:" + this.a.jdField_a_of_type_Long + "|reqTimestamp:" + paramLong);
    return;
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("Thread id:").append(Thread.currentThread().getId()).append(",threadName:").append(Thread.currentThread().getName()).append("|onUpdateTroopGetMemberList:").append(paramBoolean).append("|troopMemberInfoList size:");
      if (paramList == null)
      {
        paramString = "";
        label254:
        localStringBuilder2.append(paramString).append("|time:").append((paramLong - this.a.jdField_a_of_type_Long) / 1000L).append("s");
        QLog.d("TroopMemberListActivityget_troop_member", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label557;
      }
    }
    for (;;)
    {
      try
      {
        this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 0).edit().putLong("key_last_update_time" + this.a.jdField_b_of_type_JavaLangString, System.currentTimeMillis()).commit();
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        if ((this.a.d == 13) || (this.a.d == 21)) {
          break label509;
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, paramList);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList:" + paramString.toString());
      return;
      paramString = Integer.valueOf(paramList.size());
      break label254;
      label509:
      paramString = this.a.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_e_of_type_JavaUtilList);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
    label557:
    if ((this.a.d != 13) && (this.a.d != 21)) {
      this.a.a(this.a.jdField_b_of_type_JavaLangString, null);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.a.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_e_of_type_JavaUtilList);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.k = true;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.a.a(str);
        }
        if (this.a.d == 15) {
          TroopMemberListActivity.a(this.a, paramArrayList);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) && (paramBoolean)) {
        ThreadManager.post(new ubt(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new ubu(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onGetTroopInfoResult, isSuccess:" + paramBoolean + " returnUin:" + paramString + " mTroopUin:" + this.a.jdField_b_of_type_JavaLangString + " time:" + (System.currentTimeMillis() - this.a.jdField_b_of_type_Long) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.jdField_b_of_type_JavaLangString.equals(paramString))) {}
    do
    {
      return;
      this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 0).edit().putLong("key_troop_info_last_update" + this.a.jdField_b_of_type_JavaLangString, System.currentTimeMillis()).commit();
      paramString = ((TroopManager)this.a.app.getManager(51)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    paramString = this.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
    {
      paramBoolean = true;
      paramString.jdField_b_of_type_Boolean = paramBoolean;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
        this.a.jdField_e_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
        this.a.f = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
      }
      paramString = this.a;
      if (!this.a.app.getCurrentAccountUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin))
      {
        paramBoolean = bool;
        if (this.a.f != null)
        {
          paramBoolean = bool;
          if (!this.a.f.contains(this.a.app.getCurrentAccountUin())) {}
        }
      }
      else
      {
        paramBoolean = true;
      }
      paramString.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.a.jdField_e_of_type_JavaLangString == null) || (!this.a.jdField_e_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label463;
      }
    }
    for (this.a.n = "0";; this.a.n = "1") {
      label463:
      do
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
      } while ((this.a.f == null) || (!this.a.f.contains(this.a.app.getCurrentAccountUin())));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_b_of_type_JavaLangString)) && (this.a.i == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ubv(this, paramList));
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    this.a.runOnUiThread(new ubq(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3));
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + paramBoolean);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
      localATroopMember.a = (localGroupFeeMember.uint64_uin.get() + "");
      localATroopMember.jdField_b_of_type_JavaLangString = localGroupFeeMember.string_nick_name.get();
      localArrayList.add(localATroopMember);
    }
    this.a.c = paramList.size();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubp
 * JD-Core Version:    0.7.0.1
 */