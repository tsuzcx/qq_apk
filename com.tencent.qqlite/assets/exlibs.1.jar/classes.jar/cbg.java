import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class cbg
  extends TroopObserver
{
  public cbg(TroopChatPie paramTroopChatPie) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      TroopChatPie.a(this.a).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder(150);
            ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
            QLog.i("TroopChatPie", 2, ((StringBuilder)localObject1).toString());
          }
        } while ((paramInt1 != 2) || (!paramBoolean));
        paramString = (TroopManager)TroopChatPie.b(this.a).getManager(44);
      } while (paramString.a(String.valueOf(paramLong1)));
      localObject1 = paramString.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject1 == null) || (StringUtil.b(((TroopInfo)localObject1).troopowneruin)));
    ((TroopInfo)localObject1).Administrator = "";
    label186:
    Object localObject2;
    if (paramList == null)
    {
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 >= paramInt1) {
        break label327;
      }
      localObject2 = (oidb_0x899.memberlist)paramList.get(paramInt2);
      if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
        break label244;
      }
    }
    for (;;)
    {
      paramInt2 += 1;
      break label186;
      paramInt1 = paramList.size();
      break;
      label244:
      localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
      if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!((TroopInfo)localObject1).troopowneruin.equals(((String)localObject2).trim()))) {
        ((TroopInfo)localObject1).Administrator = (((TroopInfo)localObject1).Administrator + (String)localObject2 + "|");
      }
    }
    label327:
    paramString.b((TroopInfo)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("TroopChatPie", 2, ((TroopInfo)localObject1).Administrator);
    }
    TroopChatPie.c(this.a).removeMessages(1);
    TroopChatPie.c(this.a).sendEmptyMessage(1);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      paramString = ((FriendManager)TroopChatPie.d(this.a).getManager(8)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.troopname;
        TroopChatPie.c(this.a).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        AnonymousChatHelper.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null);
        TroopChatPie.e(this.a).postDelayed(new cbh(this), 500L);
        return;
      }
      this.a.a(3, paramString3);
      return;
    }
    this.a.a(1, TroopChatPie.c(this.a).getResources().getString(2131362632));
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPie", 2, "onTroopNewFeedsComing");
      }
      if (!paramBoolean2) {
        break label43;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.d();
      }
    }
    label43:
    do
    {
      do
      {
        return;
        paramString = ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopChatPie.e(this.a).a());
        if ((paramString == null) || (-1 != paramString.intValue())) {
          break;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(true);
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b(false);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    TroopChatPie.f(this.a).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((TroopChatPie.a(this.a) == null) || (!TroopChatPie.b(this.a).isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(TroopChatPie.f(this.a).a(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      return;
      if (!paramBoolean)
      {
        i = 1;
        continue;
        if (TroopChatPie.c(this.a) != null) {
          TroopChatPie.d(this.a).dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          MultiMsgManager.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (MultiMsgManager.a().b.size() == 0)
        {
          QQToast.a(TroopChatPie.e(this.a), 2131363010, 0).b(TroopChatPie.d(this.a).getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
        this.a.a((Map)paramObject, MultiMsgManager.a().a);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label50:
    label191:
    label192:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
      {
        int i = 0;
        if (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localTroopMemberCardInfo.memberuin)))
          {
            paramArrayList = localTroopMemberCardInfo.name;
            if ((paramArrayList != null) && (!"".equals(paramArrayList))) {
              break label191;
            }
            paramArrayList = localTroopMemberCardInfo.nick;
          }
        }
        for (;;)
        {
          if ((paramArrayList == null) || ("".equals(paramArrayList))) {
            break label192;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramArrayList;
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
          TroopChatPie.b(this.a).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          return;
          i += 1;
          break label50;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbg
 * JD-Core Version:    0.7.0.1
 */