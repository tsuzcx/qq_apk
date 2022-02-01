import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.32.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;

public class uqd
  extends acnd
{
  public uqd(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!aqft.equalsWithNullCheck(paramString, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.this$0.app.getManager(52)).b(paramString);
    } while (paramString == null);
    this.this$0.b = paramString;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, this.this$0.getResources(), this.this$0.app.getCurrentAccountUin());
    this.this$0.mUIHandler.sendEmptyMessage(5);
  }
  
  protected void S(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_file_new", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
      this.this$0.mUIHandler.sendEmptyMessage(8);
    }
  }
  
  protected void T(boolean paramBoolean, String paramString) {}
  
  protected void a(oidb_0xea4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      str = String.valueOf(paramRspBody.group_id.get());
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + str + ", current uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (paramInt != 1);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 1 refresh");
        }
        this.this$0.a(paramRspBody);
        paramRspBody = this.this$0.p[29];
        if ((paramRspBody != null) && (paramRspBody.isShown())) {
          aqfr.b("Grp_game", "Grp_data", "rank_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        }
        paramRspBody = this.this$0.p[30];
      } while ((paramRspBody == null) || (!paramRspBody.isShown()));
      aqfr.b("Grp_game", "Grp_data", "feeds_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!aqft.equalsWithNullCheck(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong)));
        if ((this.this$0.qy != null) && (this.this$0.qy.contains(Integer.valueOf(paramInt))))
        {
          this.this$0.qy.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.this$0.b = paramTroopInfo;
          }
          if (this.this$0.jdField_a_of_type_Arib == null) {
            this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
          }
          if (paramBoolean)
          {
            this.this$0.jdField_a_of_type_Arib.aa(1, this.this$0.getString(2131694967), 1000);
            return;
          }
          this.this$0.jdField_a_of_type_Arib.aa(2, this.this$0.getString(2131694966), 1000);
          ChatSettingForTroop.b(this.this$0, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.this$0.b = paramTroopInfo;
    } while ((this.this$0.qy != null) && (this.this$0.qy.size() != 0));
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.this$0.app.getCurrentAccountUin());
    this.this$0.mUIHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.this$0.ath();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break label197;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.this$0.cf(2131721381, 0);
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (this.this$0.isResume()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onOIDB0X88D_1_Ret return----------------");
    return;
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      ChatSettingForTroop.c(this.this$0, 2);
      return;
    }
    ChatSettingForTroop.a(this.this$0, null);
    return;
    label197:
    this.this$0.cf(2131719483, 1);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((!TextUtils.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong1))) || (paramInt1 != 5)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ChatSettingForTroop.a(this.this$0, paramList);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    int i = 0;
    if ((this.this$0.dx != null) && (this.this$0.mTitleTv != null)) {
      this.this$0.mTitleTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", mTroopInfoData IsNull=");
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
      {
        paramBoolean = true;
        localStringBuilder = localStringBuilder.append(paramBoolean).append(", resp IsNull=");
        if (paramRespBatchProcess != null) {
          break label171;
        }
        paramBoolean = true;
        label101:
        QLog.d("Q.chatopttroop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
        break label176;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label171:
    label176:
    label248:
    int j;
    do
    {
      do
      {
        do
        {
          return;
          paramBoolean = false;
          break;
          paramBoolean = false;
          break label101;
          if (String.valueOf(paramLong).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label248;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.chatopttroop", 2, "onBatchGetTroopInfoResp  fiter resp, curTroopUin = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ",respUin = " + paramLong);
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("from", 0) != 1));
      j = paramRespBatchProcess.batch_response_list.size();
      if (i < j)
      {
        paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((paramBundle == null) || (paramBundle.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (paramBundle.type == 1) {
            this.this$0.a(paramBundle);
          }
        }
      }
    } while (j <= 0);
    apuh.a(this.this$0.b, this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    this.this$0.ww(true);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.this$0, this.this$0.getString(2131698424), 0).show(this.this$0.getTitleBarHeight());
      ChatSettingForTroop.k(this.this$0);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    ThreadManager.post(new ChatSettingForTroop.32.1(this), 8, null, true);
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    boolean bool;
    do
    {
      return;
      if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
      for (bool = false;; bool = y(paramArrayList))
      {
        if (this.this$0.jdField_a_of_type_Arib == null) {
          this.this$0.jdField_a_of_type_Arib = new arib(this.this$0);
        }
        if ((paramBoolean) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        this.this$0.jdField_a_of_type_Arib.aa(2, paramString, 1000);
        return;
      }
      if ((!paramBoolean) && ((this.this$0.bFE & 0x1) == 1))
      {
        paramArrayList = this.this$0;
        paramArrayList.bFE &= 0xFFFFFFFE;
        this.this$0.jdField_a_of_type_Arib.aq(2, 2131695968, 1000);
        return;
      }
    } while ((!bool) || ((this.this$0.bFE & 0x1) != 1));
    paramArrayList = this.this$0;
    paramArrayList.bFE &= 0xFFFFFFFE;
    this.this$0.jdField_a_of_type_Arib.aq(1, 2131695969, 1000);
  }
  
  protected void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0));
      localObject = null;
      int i = 0;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!aqft.equalsWithNullCheck(localTroopInfo.troopuin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.this$0.b = localObject;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(localObject, this.this$0.getResources(), this.this$0.app.getCurrentAccountUin());
    this.this$0.mUIHandler.sendEmptyMessage(5);
    try
    {
      long l1 = Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      long l2 = Long.parseLong(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      aptr.a(this.this$0.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  protected void di(String paramString1, String paramString2)
  {
    if (this.this$0.b != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.this$0.b.getTroopName();
      this.this$0.bLc();
    }
  }
  
  protected void e(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    y(paramArrayList);
  }
  
  protected void h(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if ((paramBoolean2) && (this.this$0.app != null)) {
        ((apys)this.this$0.app.getManager(234)).Ue(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
    }
    for (;;)
    {
      ChatSettingForTroop.l(this.this$0);
      return;
      QQToast.a(BaseApplication.getContext(), 2131698346, 0).show(this.this$0.getTitleBarHeight());
    }
  }
  
  protected void j(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.this$0.bFL = paramInt;
    }
  }
  
  protected void k(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.this$0.b != null) && (TextUtils.equals(paramString1, this.this$0.b.troopuin)))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = this.this$0.b.getLatestMemo();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("get last memo [%s, %s]", new Object[] { paramString1, str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = this.this$0.mUIHandler.obtainMessage();
        paramString1.what = 20;
        paramString1.obj = str;
        this.this$0.mUIHandler.sendMessage(paramString1);
      }
      ChatSettingForTroop.a(this.this$0, str);
    }
  }
  
  protected void u(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.this$0.qC != null)) {
      this.this$0.fH(this.this$0.qC);
    }
  }
  
  protected boolean y(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    int i = 0;
    Object localObject = null;
    if ((localObject == null) && (i < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      if (localTroopMemberCardInfo == null) {
        localObject = localTroopMemberCardInfo;
      }
      for (;;)
      {
        i += 1;
        break;
        if (aqft.equalsWithNullCheck(localTroopMemberCardInfo.troopuin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          localObject = localTroopMemberCardInfo;
          if (aqft.equalsWithNullCheck(localTroopMemberCardInfo.memberuin, this.this$0.app.getCurrentAccountUin())) {}
        }
        else
        {
          localObject = null;
        }
      }
    }
    paramArrayList = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    if ((localObject != null) && (!aqft.equalsWithNullCheck(paramArrayList, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)))
    {
      paramArrayList = localObject.name;
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = localObject.colorNick;
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localObject.name;
      this.this$0.mUIHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqd
 * JD-Core Version:    0.7.0.1
 */