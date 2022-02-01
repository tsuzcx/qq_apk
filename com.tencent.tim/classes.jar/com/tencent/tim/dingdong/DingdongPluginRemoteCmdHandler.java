package com.tencent.tim.dingdong;

import QQService.AddDiscussMemberInfo;
import acdt;
import acdu;
import acdv;
import acff;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import anqu;
import anqv;
import anrd;
import anst;
import anub;
import apsw;
import apsw.f;
import aqft;
import aqgv;
import aqgx;
import aqmf;
import atnd;
import atne;
import atnf;
import atni;
import atnk;
import atnm;
import atnn;
import atno;
import atnp;
import auga;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class DingdongPluginRemoteCmdHandler
{
  private ArrayList<ResultRecord> Eg;
  private RemoteCommand jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand = new atnm(this, "dingDongRemoteCmd");
  private DCThread jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler$DCThread = new DCThread(this);
  private acdv b = new atnp(this);
  private String cHH = "";
  private boolean din;
  private int eqE = 0;
  private int eqF;
  
  private int a(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle2 = paramBundle1.getString("schedule_msg_frienduin", "");
    String str = paramBundle1.getString("schedule_msg_extstring", "");
    int i = paramBundle1.getInt("schedule_msg_istroop");
    long l = paramBundle1.getLong("schedule_msg_uniseq");
    paramBundle1.getInt("schedule_msg_extlong");
    if (!TextUtils.isEmpty(paramBundle2)) {
      ThreadManager.executeOnSubThread(new DingdongPluginRemoteCmdHandler.2(this, paramBundle2, i, l, str));
    }
    return 0;
  }
  
  private void aaA(int paramInt)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      QLog.e("DingdongPluginRemoteCmdHandler", 1, "handleDiscussCreate2 fatal error, app is null");
    }
    Object localObject2;
    do
    {
      return;
      if (paramInt == 0)
      {
        long l = this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler$DCThread.ayB;
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("reqCode", 5);
        if (l > 0L) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject5).putExtra("isSuccess", bool);
          ((Intent)localObject5).putExtra("roomId", this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler$DCThread.ayB);
          ((Intent)localObject5).putExtra("createdFlag", 0);
          ((Intent)localObject5).putExtra("discuss_create_reason", this.eqF);
          if (l > 0L)
          {
            localObject2 = aqgv.u(localQQAppInterface, l + "");
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (!((String)localObject2).equals("")) {}
            }
            else
            {
              localObject1 = l + "";
            }
            ((Intent)localObject5).putExtra("discussName", (String)localObject1);
          }
          if (this.eqE != 1) {
            break;
          }
          atni.K(10, (Intent)localObject5);
          return;
        }
        atni.K(2, (Intent)localObject5);
        return;
      }
    } while (paramInt != 1);
    if (!this.din)
    {
      localQQAppInterface.addObserver(this.b);
      this.din = true;
    }
    Object localObject5 = new ArrayList();
    Object localObject1 = aqgv.n(localQQAppInterface, localQQAppInterface.getCurrentAccountUin());
    acff localacff = (acff)localQQAppInterface.getManager(51);
    paramInt = this.Eg.size() - 1;
    ResultRecord localResultRecord;
    String str;
    if (paramInt >= 0)
    {
      localResultRecord = (ResultRecord)this.Eg.get(paramInt);
      localObject2 = new AddDiscussMemberInfo();
      if (localResultRecord.type == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.uin;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.type;
        ((ArrayList)localObject5).add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.type != 0) {
          break label534;
        }
        localObject1 = localacff.e(localResultRecord.uin);
        if (localObject1 == null) {
          break label860;
        }
        localObject1 = ((Friends)localObject1).name;
      }
    }
    for (;;)
    {
      label418:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.uin;
      }
      for (;;)
      {
        for (;;)
        {
          paramInt -= 1;
          break;
          try
          {
            ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.uin).longValue();
            ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.QD).longValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DingdongPluginRemoteCmdHandler", 2, "doCreateDiscussForDingdong, NumberFormatException!!! uin=" + localResultRecord.uin);
            }
          }
        }
        continue;
        label534:
        Object localObject6;
        if (localResultRecord.type == 1)
        {
          localObject6 = aqgx.a().a(localQQAppInterface, localResultRecord.QD, localResultRecord.uin);
          localObject1 = localNumberFormatException;
          if (localObject6 == null) {
            break label418;
          }
          localObject1 = localNumberFormatException;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject6).friendnick)) {
            break label418;
          }
          localObject1 = ((TroopMemberInfo)localObject6).friendnick;
          break label418;
        }
        if (localResultRecord.type == 2)
        {
          localObject6 = ((acdu)localQQAppInterface.getManager(53)).a(localResultRecord.QD, localResultRecord.uin);
          localObject1 = localNumberFormatException;
          if (localObject6 == null) {
            break label418;
          }
          localObject1 = localNumberFormatException;
          if (((DiscussionMemberInfo)localObject6).inteRemark == null) {
            break label418;
          }
          localObject1 = localNumberFormatException;
          if (((DiscussionMemberInfo)localObject6).inteRemark.length() <= 0) {
            break label418;
          }
          localObject1 = ((DiscussionMemberInfo)localObject6).inteRemark;
          break label418;
        }
        if (localResultRecord.type == 3)
        {
          localObject1 = localResultRecord.name;
          break label418;
        }
        localObject1 = localNumberFormatException;
        if (localResultRecord.type != 4) {
          break label418;
        }
        localObject1 = localResultRecord.name;
        break label418;
        localObject1 = str + (String)localObject1;
      }
      Object localObject3 = localObject1;
      for (;;)
      {
        try
        {
          if (((String)localObject1).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject1).length();
            paramInt = i;
            localObject3 = localObject1;
            if (paramInt <= j)
            {
              if (((String)localObject1).substring(0, paramInt).getBytes("utf-8").length <= 48) {
                continue;
              }
              localObject3 = ((String)localObject1).substring(0, paramInt - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Object localObject4 = localObject1;
          continue;
        }
        localObject1 = (acdt)localQQAppInterface.getBusinessHandler(6);
        if (localObject1 == null) {
          break;
        }
        ((acdt)localObject1).c((String)localObject3, (ArrayList)localObject5, 1004);
        return;
        paramInt += 1;
      }
      label860:
      localObject1 = null;
    }
  }
  
  private void aaz(int paramInt)
  {
    Looper localLooper = Looper.getMainLooper();
    if (localLooper != Looper.myLooper())
    {
      new Handler(localLooper).post(new DingdongPluginRemoteCmdHandler.5(this, paramInt));
      return;
    }
    aaA(paramInt);
  }
  
  private int b(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle2 = paramBundle1.getString("schedule_msg_fromuin", "");
    String str = paramBundle1.getString("schedule_troop_num", "");
    paramBundle1 = paramBundle1.getString("schedule_discuss_num", "");
    ((auga)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(182)).bt(paramBundle2, str, paramBundle1);
    return 0;
  }
  
  private int c(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle1.getInt("_attachment_count");
    int i = paramBundle1.getInt("_source_type_");
    paramBundle2 = paramBundle1.getString("_source_id_");
    Object localObject1 = paramBundle1.getString("_feed_id_");
    paramBundle1.getString("_from_uin_");
    paramBundle1.getString("_concern_uin_list_str_");
    paramBundle1 = paramBundle1.getString("_feed_brief_");
    Object localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class);
    localObject1 = "mqqapi://asyncmsg/showdetail?src_type=internal&version=1&feedsid=" + (String)localObject1 + "&fsc=" + paramBundle2 + "&fst=" + i;
    localObject1 = ((AbsShareMsg.a)localObject2).c(61).a(BaseApplicationImpl.getApplication().getString(2131692775) + paramBundle1).a(11).a("plugin", "", (String)localObject1, "", "").d(BaseApplicationImpl.getApplication().getString(2131692721)).a();
    localObject2 = anrd.a(2);
    ((anqv)localObject2).t(BaseApplicationImpl.getApplication().getString(2131692802), BaseApplicationImpl.getApplication().getString(2131692801), paramBundle1, 0);
    paramBundle1 = new anub();
    paramBundle1.a(new anst());
    ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
    ((AbsShareMsg)localObject1).addItem(paramBundle1);
    aqmf.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle2, paramBundle2, atni.lb(i), (AbsStructMsg)localObject1, null);
    return 0;
  }
  
  private int d(Bundle paramBundle1, Bundle paramBundle2)
  {
    int i = paramBundle1.getInt("_source_type_");
    Object localObject = paramBundle1.getString("_source_id_");
    String str = paramBundle1.getString("_create_uin_");
    apsw localapsw;
    if (1 == i)
    {
      paramBundle1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localapsw = (apsw)paramBundle1.getManager(48);
      if (localapsw.bg((String)localObject, str)) {
        paramBundle1 = paramBundle1.getApplication().getString(2131692729);
      }
    }
    for (;;)
    {
      if (paramBundle1 != null) {
        paramBundle2.putString("_create_err_msg_", paramBundle1);
      }
      return 0;
      localObject = localapsw.a((String)localObject);
      if ((localObject != null) && (((apsw.f)localObject).gagTimeStamp > 0L)) {
        paramBundle1 = paramBundle1.getApplication().getString(2131692733);
      } else {
        paramBundle1 = null;
      }
    }
  }
  
  private int e(Bundle paramBundle1, Bundle paramBundle2)
  {
    int i = paramBundle1.getInt("_req_code_", 0);
    if (i == 1) {
      atnd.a().eL((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    do
    {
      do
      {
        return 0;
        if (i == 2)
        {
          paramBundle1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          atne.a().S("officecenter_red_point_flag_" + paramBundle1.getLongAccountUin(), false);
          ((atnf)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(75)).notifyUI(5, false, null);
          return 0;
        }
      } while (i != 3);
      paramBundle1 = paramBundle1.getLongArray("_troop_uin_long_array_");
    } while ((paramBundle1 == null) || (paramBundle1.length <= 0));
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBundle2 = new long[paramBundle1.length];
    i = 0;
    while (i < paramBundle1.length)
    {
      paramBundle2[i] = 0L;
      Iterator localIterator = ((TroopManager)((QQAppInterface)localObject).getManager(52)).cE().iterator();
      while (localIterator.hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
        if ((localTroopInfo != null) && (localTroopInfo.troopuin.equals(paramBundle1[i] + ""))) {
          paramBundle2[i] = 1L;
        }
      }
      i += 1;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("reqCode", 6);
    ((Intent)localObject).putExtra("_troop_uin_long_array_", paramBundle1);
    ((Intent)localObject).putExtra("_troop_FLAG_long_array_", paramBundle2);
    atni.K(2, (Intent)localObject);
    return 0;
  }
  
  private int f(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (!this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler$DCThread.mIsRunning)
    {
      this.Eg = null;
      this.Eg = paramBundle1.getParcelableArrayList("resultRecords");
      this.cHH = paramBundle1.getString("discussName");
      this.eqF = paramBundle1.getInt("discuss_create_reason");
      this.eqE = paramBundle1.getInt("discuss_create_form", 0);
      if ((this.Eg == null) || (this.Eg.size() == 0)) {
        return 1;
      }
      this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginRemoteCmdHandler$DCThread.W(this.Eg);
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginRemoteCmdHandler", 2, "doCreateDiscussForDingdong, is running!!!");
    }
    return 1;
  }
  
  private int g(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.Eg = null;
    this.eqE = paramBundle1.getInt("discuss_create_form", 0);
    this.Eg = paramBundle1.getParcelableArrayList("resultRecords");
    this.cHH = paramBundle1.getString("discussName");
    String str1 = paramBundle1.getString("discussRoomId");
    if (TextUtils.isEmpty(str1)) {}
    QQAppInterface localQQAppInterface;
    acdu localacdu;
    String str2;
    for (long l = 0L;; l = Long.valueOf(str1).longValue())
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localacdu = (acdu)localQQAppInterface.getManager(53);
      str2 = localQQAppInterface.getCurrentAccountUin();
      if (localacdu.a(str1, str2) != null) {
        break;
      }
      paramBundle1.putInt("discuss_create_reason", 2);
      f(paramBundle1, paramBundle2);
      return 0;
    }
    new atnn(this, localacdu, str1, str2, l, localQQAppInterface).execute(new Void[] { null, null, null });
    return 0;
  }
  
  private int h(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.Eg = null;
    this.eqE = paramBundle1.getInt("discuss_create_form", 0);
    paramBundle2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    acdu localacdu = (acdu)paramBundle2.getManager(53);
    this.Eg = new ArrayList();
    String str = paramBundle1.getString("toUin");
    int i = paramBundle1.getInt("toUinType", -1);
    Object localObject1 = paramBundle1.getString("uinSource");
    Object localObject2;
    if (i != -1) {
      if (i == 3000)
      {
        localObject1 = localacdu.A(str);
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ResultRecord localResultRecord = new ResultRecord();
            localResultRecord.uin = ((String)localObject2);
            localResultRecord.type = 2;
            localResultRecord.QD = str;
            this.Eg.add(localResultRecord);
          }
        }
      }
      else
      {
        localObject2 = new ResultRecord();
        ((ResultRecord)localObject2).uin = str;
        ((ResultRecord)localObject2).QD = ((String)localObject1);
        if (i != 1000) {
          break label262;
        }
        ((ResultRecord)localObject2).type = 1;
        this.Eg.add(localObject2);
      }
    }
    this.cHH = paramBundle1.getString("discussName");
    paramBundle1 = paramBundle1.getString("discussRoomId");
    if (TextUtils.isEmpty(paramBundle1)) {}
    for (long l = 0L;; l = Long.valueOf(paramBundle1).longValue())
    {
      if (localacdu.a(paramBundle1, paramBundle2.getCurrentAccountUin()) != null) {
        break label299;
      }
      return 0;
      label262:
      if (i == 1004)
      {
        ((ResultRecord)localObject2).type = 2;
        break;
      }
      ((ResultRecord)localObject2).type = 0;
      break;
    }
    label299:
    new atno(this, localacdu, paramBundle1, l, paramBundle2).execute(new Void[] { null, null, null });
    return 0;
  }
  
  private int i(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle2 = paramBundle1.getString("discussRoomId");
    if (TextUtils.isEmpty(paramBundle2)) {
      return 1;
    }
    boolean bool1 = paramBundle1.getBoolean("isTroop");
    boolean bool2 = paramBundle1.getBoolean("fetchAll");
    paramBundle1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = paramBundle1.getCurrentAccountUin();
    ArrayList localArrayList = new ArrayList();
    Intent localIntent = new Intent();
    Object localObject1;
    Object localObject2;
    if (bool1)
    {
      localObject1 = (TroopManager)paramBundle1.getManager(52);
      localObject2 = ((TroopManager)localObject1).b(paramBundle2);
      if (localObject2 != null) {
        localIntent.putExtra("memberCount", ((TroopInfo)localObject2).wMemberNum - 1);
      }
      if ((bool2) || (localObject2 == null) || (((TroopInfo)localObject2).wMemberNum <= 100)) {}
    }
    for (;;)
    {
      localIntent.putExtra("reqCode", 8);
      localIntent.putExtra("isSuccess", true);
      localIntent.putExtra("fetchAll", bool2);
      localIntent.putParcelableArrayListExtra("discusMembers", localArrayList);
      atni.K(12, localIntent);
      return 0;
      localObject1 = ((TroopManager)localObject1).al(paramBundle2);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        ResultRecord localResultRecord;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TroopMemberInfo)((Iterator)localObject1).next();
          if ((aqft.rl(((TroopMemberInfo)localObject2).memberuin)) && (!str.equals(((TroopMemberInfo)localObject2).memberuin)))
          {
            localResultRecord = new ResultRecord();
            localResultRecord.uin = ((TroopMemberInfo)localObject2).memberuin;
            localResultRecord.name = aqgv.b(paramBundle1, (TroopMemberInfo)localObject2);
            localResultRecord.type = 1;
            localResultRecord.QD = paramBundle2;
            localArrayList.add(localResultRecord);
          }
        }
        continue;
        localObject1 = ((acdu)paramBundle1.getManager(53)).z(paramBundle2);
        localIntent.putExtra("memberCount", ((List)localObject1).size() - 1);
        if ((bool2) || (((List)localObject1).size() <= 20))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
            if (!str.equals(((DiscussionMemberInfo)localObject2).memberUin))
            {
              localResultRecord = new ResultRecord();
              localResultRecord.uin = ((DiscussionMemberInfo)localObject2).memberUin;
              localResultRecord.name = aqgv.a((DiscussionMemberInfo)localObject2, paramBundle1);
              localResultRecord.type = 2;
              localResultRecord.QD = paramBundle2;
              localArrayList.add(localResultRecord);
            }
          }
        }
      }
    }
  }
  
  private int j(Bundle paramBundle1, Bundle paramBundle2)
  {
    paramBundle1 = paramBundle1.getString("_uin_");
    if (paramBundle1 != null) {
      ((atnk)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(115)).YW(paramBundle1);
    }
    return 0;
  }
  
  @TargetApi(23)
  private int k(Bundle paramBundle1, Bundle paramBundle2)
  {
    bool2 = true;
    paramBundle1 = BaseApplicationImpl.getContext().getApplicationContext().getPackageName();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 23) {
          continue;
        }
        AppOpsManager localAppOpsManager = (AppOpsManager)BaseApplicationImpl.getContext().getSystemService("appops");
        int j = BaseApplicationImpl.getContext().getApplicationInfo().uid;
        int i = localAppOpsManager.noteOpNoThrow("android:write_calendar", j, paramBundle1);
        j = localAppOpsManager.noteOpNoThrow("android:read_calendar", j, paramBundle1);
        if ((i != 0) || (j != 0)) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramBundle1)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("hasCalendarPermission", 2, "checkPermission failed");
        bool1 = bool2;
        continue;
      }
      paramBundle2.putBoolean("calendar_check_permission", bool1);
      return 0;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  private void o(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    String str1 = paramString;
    for (;;)
    {
      try
      {
        if (paramString.getBytes("utf-8").length > 48)
        {
          int j = paramString.length();
          i = 1;
          str1 = paramString;
          if (i <= j)
          {
            if (paramString.substring(0, i).getBytes("utf-8").length <= 48) {
              continue;
            }
            str1 = paramString.substring(0, i - 1);
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        String str2 = paramString;
        continue;
      }
      paramQQAppInterface = (acdt)paramQQAppInterface.getBusinessHandler(6);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.ad(paramLong, str1);
      }
      return;
      i += 1;
    }
  }
  
  public Bundle a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    long l = paramBundle.getLong("_cmd_seq_");
    int k = paramBundle.getInt("_inner_cmd_");
    int j = 1;
    Bundle localBundle = new Bundle();
    localBundle.putLong("_cmd_seq_", l);
    int i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (paramOnInvokeFinishLinstener != null) {
        paramOnInvokeFinishLinstener.onInvokeFinish(localBundle);
      }
      localBundle.putLong("_cmd_seq_", l);
      localBundle.putInt("_result_code_", i);
      return localBundle;
      i = c(paramBundle, localBundle);
      continue;
      i = d(paramBundle, localBundle);
      continue;
      i = e(paramBundle, localBundle);
      continue;
      i = f(paramBundle, localBundle);
      continue;
      i = g(paramBundle, localBundle);
      continue;
      i = j(paramBundle, localBundle);
      continue;
      i = k(paramBundle, localBundle);
      continue;
      i = h(paramBundle, localBundle);
      continue;
      i = i(paramBundle, localBundle);
      continue;
      i = a(paramBundle, localBundle);
      continue;
      i = b(paramBundle, localBundle);
    }
  }
  
  public void euj()
  {
    if (!PluginCommunicationHandler.getInstance().containsCmd("dingDongRemoteCmd")) {
      PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand);
    }
  }
  
  static class DCThread
    implements Runnable
  {
    public volatile long ayB;
    private volatile WeakReference<DingdongPluginRemoteCmdHandler> bk;
    private volatile WeakReference<ArrayList<ResultRecord>> bl;
    public volatile boolean mIsRunning;
    
    public DCThread(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler)
    {
      this.bk = new WeakReference(paramDingdongPluginRemoteCmdHandler);
    }
    
    private boolean h(ArrayList<DiscussionMemberInfo> paramArrayList, ArrayList<ResultRecord> paramArrayList1)
    {
      if (paramArrayList.size() != paramArrayList1.size() + 1) {
        return false;
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {}
      for (localObject = ((QQAppInterface)localObject).getCurrentAccountUin();; localObject = null)
      {
        HashSet localHashSet = new HashSet();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localHashSet.add(localObject);
          paramArrayList1 = paramArrayList1.iterator();
          while (paramArrayList1.hasNext()) {
            localHashSet.add(((ResultRecord)paramArrayList1.next()).uin);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("DingdongPluginRemoteCmdHandler", 2, "checkEqualList, something error when get self uin");
        }
        return false;
        int i = localHashSet.size();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localHashSet.add(((DiscussionMemberInfo)paramArrayList.next()).memberUin);
        }
        return i == localHashSet.size();
      }
    }
    
    private long iw()
    {
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (this.bl != null) {}
      for (Object localObject1 = (ArrayList)this.bl.get();; localObject1 = null)
      {
        long l;
        int i;
        if ((localObject2 != null) && (localObject1 != null))
        {
          Object localObject3 = (acdu)((QQAppInterface)localObject2).getManager(53);
          if (localObject3 == null) {
            break label311;
          }
          Object localObject4 = ((acdu)localObject3).getDiscussList();
          if ((localObject4 == null) || (((ArrayList)localObject4).size() == 0)) {
            return 0L;
          }
          ArrayList localArrayList1 = new ArrayList();
          localObject4 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
            ArrayList localArrayList2 = ((acdu)localObject3).z(localDiscussionInfo.uin);
            if ((localArrayList2 != null) && (h(localArrayList2, (ArrayList)localObject1))) {
              localArrayList1.add(localDiscussionInfo.uin);
            }
          }
          int j = localArrayList1.size();
          if (j == 1)
          {
            l = Long.valueOf((String)localArrayList1.get(0)).longValue();
            return l;
          }
          if (j <= 1) {
            break label311;
          }
          localObject1 = (String)localArrayList1.get(0);
          localObject3 = ((QQAppInterface)localObject2).b();
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            l = 0L;
            i = 0;
            label224:
            localObject2 = localObject1;
            if (i < j)
            {
              localObject2 = ((QQMessageFacade)localObject3).a((String)localArrayList1.get(i), 3000);
              if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).time <= l)) {
                break label316;
              }
              localObject1 = (String)localArrayList1.get(i);
              l = ((QQMessageFacade.Message)localObject2).time;
            }
          }
        }
        label311:
        label316:
        for (;;)
        {
          i += 1;
          break label224;
          l = Long.valueOf((String)localObject2).longValue();
          break;
          QLog.d("DingdongPluginRemoteCmdHandler", 4, "if (app != null && rr != null) { ... } else { ... }");
          l = 0L;
          break;
        }
      }
    }
    
    public boolean W(ArrayList<ResultRecord> paramArrayList)
    {
      if (!this.mIsRunning)
      {
        this.mIsRunning = true;
        this.ayB = 0L;
        this.bl = new WeakReference(paramArrayList);
        ThreadManager.post(this, 8, null, true);
        return true;
      }
      return false;
    }
    
    public void run()
    {
      DingdongPluginRemoteCmdHandler localDingdongPluginRemoteCmdHandler = (DingdongPluginRemoteCmdHandler)this.bk.get();
      if (localDingdongPluginRemoteCmdHandler != null)
      {
        this.ayB = iw();
        if (this.ayB <= 0L) {
          break label43;
        }
        DingdongPluginRemoteCmdHandler.a(localDingdongPluginRemoteCmdHandler, 0);
      }
      for (;;)
      {
        this.mIsRunning = false;
        return;
        label43:
        DingdongPluginRemoteCmdHandler.a(localDingdongPluginRemoteCmdHandler, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler
 * JD-Core Version:    0.7.0.1
 */