import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.1;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.2;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.3;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.4;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.5;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.6;
import com.tencent.mobileqq.activity.TroopMemberListActivity.40.7;
import com.tencent.mobileqq.activity.TroopMemberListActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

public class wcd
  extends acnd
{
  public wcd(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void H(boolean paramBoolean, String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.this$0.mTroopUin.equals(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:" + this.this$0.mTroopUin + "|troopUin:" + paramString);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = TroopMemberListActivity.d(this.this$0);
        if (paramInt2 == paramInt1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,realReqType != reqType, realReqType:" + paramInt2 + "|reqType:" + paramInt1);
      return;
      if (this.this$0.Hm == paramLong) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopMemberListActivityget_troop_member", 2, "onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:" + this.this$0.Hm + "|reqTimestamp:" + paramLong);
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
        localStringBuilder2.append(paramString).append("|time:").append((paramLong - this.this$0.Hm) / 1000L).append("s");
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
        this.this$0.getSharedPreferences("last_update_time" + this.this$0.app.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.this$0.mTroopUin, System.currentTimeMillis()).commit();
        this.this$0.mHandler.removeMessages(1);
        if ((this.this$0.mFrom == 13) || (this.this$0.mFrom == 21)) {
          break label509;
        }
        this.this$0.q(this.this$0.mTroopUin, paramList);
        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
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
      paramString = this.this$0.a(this.this$0.mTroopUin, this.this$0.rp);
      this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(2, paramString));
    }
    label557:
    if ((this.this$0.mFrom != 13) && (this.this$0.mFrom != 21)) {
      this.this$0.q(this.this$0.mTroopUin, null);
    }
    for (;;)
    {
      this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.this$0.a(this.this$0.mTroopUin, this.this$0.rp);
      this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(2, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!aqft.equalsWithNullCheck(String.valueOf(paramLong1), this.this$0.mTroopUin)) {}
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
        ThreadManager.post(new TroopMemberListActivity.40.3(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new TroopMemberListActivity.40.4(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.this$0.mTroopUin)) && (this.this$0.BL == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.5(this, paramList));
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    this.this$0.runOnUiThread(new TroopMemberListActivity.40.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
  
  protected void ac(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.this$0.b.troopuin == null) || (!paramString1.equals(this.this$0.b.troopuin))) {
      return;
    }
    this.this$0.a(paramString2);
    this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(9));
  }
  
  protected void ag(String paramString1, String paramString2, String paramString3)
  {
    if (!this.this$0.mTroopUin.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new TroopMemberListActivity.40.2(this, paramString2), 8, null, true);
  }
  
  protected void b(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.this$0.bbx = true;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.this$0.a(str);
        }
        if (this.this$0.mFrom == 15) {
          TroopMemberListActivity.a(this.this$0, paramArrayList);
        }
        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(6));
      }
      return;
    }
    if (paramInt == 2)
    {
      this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(15));
      return;
    }
    this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(7));
  }
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onOIDB0X899_1_Ret, isSuccess:" + paramBoolean + " returnUin:" + paramLong1 + " mTroopUin:" + this.this$0.mTroopUin + " time:" + (System.currentTimeMillis() - this.this$0.Hn) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.this$0.mTroopUin.equals(Long.toString(paramLong1)))) {}
    do
    {
      return;
      this.this$0.getSharedPreferences("last_update_time" + this.this$0.app.getCurrentAccountUin(), 4).edit().putLong("key_troop_info_last_update" + this.this$0.mTroopUin, System.currentTimeMillis()).commit();
    } while (this.this$0.b == null);
    paramString = this.this$0;
    if ((this.this$0.b != null) && (this.this$0.b.isHomeworkTroop()))
    {
      paramBoolean = true;
      paramString.aLZ = paramBoolean;
      if (this.this$0.b.troopowneruin != null) {
        this.this$0.aPW = this.this$0.b.troopowneruin;
      }
      this.this$0.aPX = apuh.a(this.this$0.app, this.this$0.b, paramList, false);
      paramList = this.this$0;
      if ((!this.this$0.app.getCurrentAccountUin().equals(this.this$0.b.troopowneruin)) && ((this.this$0.aPX == null) || (!this.this$0.aPX.contains(this.this$0.app.getCurrentAccountUin())))) {
        break label455;
      }
      paramBoolean = true;
      label377:
      paramList.bap = paramBoolean;
      if ((this.this$0.aPW == null) || (!this.this$0.aPW.equals(this.this$0.app.getCurrentAccountUin()))) {
        break label460;
      }
    }
    for (this.this$0.aQS = "0";; this.this$0.aQS = "1") {
      label455:
      label460:
      do
      {
        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label377;
      } while ((this.this$0.aPX == null) || (!this.this$0.aPX.contains(this.this$0.app.getCurrentAccountUin())));
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.this$0.mTroopUin)) && (this.this$0.BL == 5) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.6(this, paramList));
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.this$0.mTroopUin)) && (this.this$0.BL == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.7(this, paramList));
    }
  }
  
  protected void v(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
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
      TroopMemberListActivity.a locala = new TroopMemberListActivity.a();
      locala.uin = (localGroupFeeMember.uint64_uin.get() + "");
      locala.displayName = localGroupFeeMember.string_nick_name.get();
      if (this.this$0.a != null) {
        this.this$0.a.b(locala);
      }
      localArrayList.add(locala);
    }
    this.this$0.bLI = paramList.size();
    this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */