package com.tencent.av.utils;

import acdu;
import aiyw;
import alkm;
import alkq;
import anaz;
import anbi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import anot;
import anqu;
import anqv;
import anrd;
import ansj;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aoon;
import aqft;
import aqgv;
import aqjg;
import aqji;
import aqmf;
import aqmj;
import aurr;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jjk.b;
import jlc;
import jll;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import szy;

public class VideoMsgTools
{
  static Map<String, String> dm = new HashMap();
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131721720))) {
      return 2131167439;
    }
    if (paramBoolean) {
      return 2131167326;
    }
    return 2131167322;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2130842991;
    if (paramInt == 13) {
      if (paramBoolean1)
      {
        paramInt = i;
        if (paramBoolean2) {
          paramInt = 2130842992;
        }
      }
    }
    do
    {
      return paramInt;
      if (paramBoolean2) {
        return 2130842769;
      }
      return 2130842768;
      if (paramString.contains(paramContext.getString(2131721734)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (paramString.contains(paramContext.getString(2131721716)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (paramString.contains(paramContext.getString(2131721720)))
      {
        if (paramBoolean1) {
          return 2130843148;
        }
        return 2130842767;
      }
      if (paramString.contains(paramContext.getString(2131721723)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (paramString.contains(paramContext.getString(2131721724)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (paramString.contains(paramContext.getString(2131721722)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (paramString.contains(paramContext.getString(2131721725)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130843150;
          }
          return 2130843149;
        }
        if (paramBoolean2) {
          return 2130842769;
        }
        return 2130842768;
      }
      if (!paramBoolean1) {
        break;
      }
      paramInt = i;
    } while (!paramBoolean2);
    return 2130842992;
    if (paramBoolean2) {
      return 2130842769;
    }
    return 2130842768;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
    case 48: 
    case 57: 
    case 62: 
    case 63: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131721734);
        return paramContext + " " + paramString;
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721717);
      }
      return paramContext.getString(2131721716);
    case 2: 
    case 24: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131721734);
        return paramContext + " " + paramString;
      }
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131721717);
        }
        return paramContext.getString(2131721716);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721721);
      }
      return paramContext.getString(2131721720);
    case 1: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721721);
      }
      return paramContext.getString(2131721720);
    case 3: 
      return paramContext.getString(2131721723);
    case 10: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721721);
      }
      return paramContext.getString(2131721720);
    case 7: 
      return paramContext.getString(2131721724);
    case 12: 
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131721736);
        }
        return paramContext.getString(2131721735);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721721);
      }
      return paramContext.getString(2131721720);
    case 42: 
    case 43: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131721717);
      }
      return paramContext.getString(2131721716);
    case 49: 
      return paramContext.getString(2131721725);
    case 53: 
      return paramContext.getString(2131721718);
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131721721);
    }
    return paramContext.getString(2131721720);
  }
  
  private static void a(long paramLong1, BaseApplicationImpl paramBaseApplicationImpl, int paramInt, boolean paramBoolean, long paramLong2, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 2, "sendResultBroadcastToVideoBySwitch, seq[" + paramLong1 + "], roomId[" + paramLong2 + "], seq[" + paramLong1 + "], uinType[" + paramInt + "]");
    }
    Intent localIntent = new Intent("tencent.video.q2v.SwitchToMultiAudo");
    localIntent.setPackage(paramBaseApplicationImpl.getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong2);
    localIntent.putExtra("uinType", paramInt);
    jlc.a(localIntent, paramLong1);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).uin);
    }
    localIntent.putStringArrayListExtra("memberUin", localArrayList);
    paramBaseApplicationImpl.sendBroadcast(localIntent);
    if ((paramInt == 3000) && (paramBoolean)) {
      ((alkm)paramBaseApplicationImpl.getRuntime().getManager(38)).d(1, paramLong2, "", "");
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + paramString + "]");
    Intent localIntent = new Intent(paramActivity, GAudioMembersCtrlActivity.class);
    localIntent.putExtra("discussUin", paramString);
    localIntent.putExtra("Owner", paramBoolean1);
    localIntent.putExtra("isInRoom", paramBoolean2);
    localIntent.putExtra("isFromMeeting", false);
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  static void a(BaseApplicationImpl paramBaseApplicationImpl, boolean paramBoolean, long paramLong, ArrayList<ResultRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "sendAddMemberResultBroadcastToVideo");
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramArrayList.next()).uin);
    }
    paramArrayList = new Intent("tencent.video.q2v.AddDiscussMember");
    paramArrayList.setPackage(paramBaseApplicationImpl.getPackageName());
    paramArrayList.putExtra("result", paramBoolean);
    paramArrayList.putExtra("roomId", paramLong);
    paramArrayList.putStringArrayListExtra("newMemberUin", localArrayList);
    paramBaseApplicationImpl.sendBroadcast(paramArrayList);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, Object... paramVarArgs)
  {
    if (paramString1 != null) {}
    for (long l = Long.valueOf(paramString1).longValue();; l = 0L)
    {
      int j = paramQQAppInterface.a().z(l);
      int i = j;
      if (paramVarArgs != null)
      {
        i = j;
        if (paramVarArgs.length > 0)
        {
          i = j;
          if (paramVarArgs[0] != null)
          {
            i = j;
            if ((paramVarArgs[0] instanceof Integer)) {
              i = ((Integer)paramVarArgs[0]).intValue();
            }
          }
        }
      }
      if (paramInt3 != 0) {
        i = paramInt3;
      }
      if (paramInt1 == 3000) {
        i = 1;
      }
      String str = paramQQAppInterface.getCurrentAccountUin();
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.b();
      Object localObject;
      boolean bool;
      if (localQQMessageFacade != null)
      {
        paramVarArgs = null;
        localObject = null;
        switch (paramInt2)
        {
        default: 
          paramVarArgs = paramQQAppInterface.getApp().getString(2131697749);
          bool = false;
        }
      }
      for (;;)
      {
        localObject = paramVarArgs;
        if (59 != paramInt2)
        {
          localObject = paramVarArgs;
          if (paramInt2 != 60)
          {
            localObject = paramVarArgs;
            if (i == 2)
            {
              localObject = paramVarArgs;
              if (paramVarArgs != null)
              {
                if (paramInt1 != 1) {
                  break label1434;
                }
                localObject = paramQQAppInterface.a().a(l, i);
                if ((localObject == null) || (((AVNotifyCenter.h)localObject).ang != 2) || (((AVNotifyCenter.h)localObject).gameId != 4)) {
                  break label1434;
                }
              }
            }
          }
        }
        label1422:
        label1434:
        for (paramInt3 = 1;; paramInt3 = 0)
        {
          if (paramInt3 == 0)
          {
            localObject = paramVarArgs.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721246));
            label382:
            paramQQAppInterface = anbi.d(-4008);
            paramQQAppInterface.selfuin = str;
            paramQQAppInterface.frienduin = paramString1;
            paramQQAppInterface.senderuin = str;
            paramQQAppInterface.msg = ((String)localObject);
            paramQQAppInterface.msgtype = -4008;
            paramQQAppInterface.isread = true;
            paramQQAppInterface.issend = 1;
            paramQQAppInterface.istroop = paramInt1;
            paramQQAppInterface.extraflag = 3;
            paramQQAppInterface.time = anaz.gQ();
            paramVarArgs = new ArrayList();
            paramVarArgs.add(paramQQAppInterface);
            if (!bool) {
              break label1422;
            }
            localQQMessageFacade.s(paramVarArgs, str);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("VideoMsgTools", 1, "addTipsMultiVideoMsg, msgType[" + paramInt2 + "], discussionUin[" + paramString1 + "], memberUin[" + paramString2 + "], uinType[" + paramInt1 + "], extra[" + paramString3 + "], avtype[" + i + "], msgStr[" + (String)localObject + "], bSaveDB[" + bool + "]");
            }
            do
            {
              return;
              if (str.equals(paramString2))
              {
                if (paramInt1 == 3000)
                {
                  paramVarArgs = paramQQAppInterface.getApp().getString(2131697748);
                  bool = false;
                  break;
                }
                if (paramInt1 != 1) {
                  break label1440;
                }
                paramVarArgs = paramQQAppInterface.getApp().getString(2131697772);
                bool = false;
                break;
              }
              localObject = aqgv.m(paramQQAppInterface, paramString1, paramString2);
              if (paramInt1 == 3000) {
                paramVarArgs = (String)localObject + paramQQAppInterface.getApp().getString(2131697747);
              }
              for (;;)
              {
                bool = false;
                break;
                if (paramInt1 == 1) {
                  paramVarArgs = (String)localObject + paramQQAppInterface.getApp().getString(2131697770);
                }
              }
              paramQQAppInterface.a().k(1, l, 0);
            } while (!dm.containsKey(paramString1 + String.valueOf(i)));
            dm.remove(paramString1 + String.valueOf(i));
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697749);
            bool = true;
            break;
            paramQQAppInterface.a().k(2, l, 0);
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697724);
            bool = false;
            break;
            paramQQAppInterface.a().k(3, l, 0);
            if (paramInt1 == 3000)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697723);
              bool = false;
              break;
            }
            if (paramInt1 == 1)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697765);
              bool = false;
              break;
            }
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697781);
            bool = false;
            break;
            paramQQAppInterface.a().k(4, l, 0);
            if (paramInt1 == 3000)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697700);
              bool = false;
              break;
            }
            if (paramInt1 != 1) {
              break label1440;
            }
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697764);
            bool = false;
            break;
            paramQQAppInterface.a().k(5, l, 0);
            if (paramInt1 == 3000)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697697);
              bool = false;
              break;
            }
            if (paramInt1 != 1) {
              break label1440;
            }
            paramInt3 = 0;
            if (paramString3 != null) {
              paramInt3 = Integer.parseInt(paramString3);
            }
            if (paramInt3 == 19) {}
            for (paramVarArgs = paramQQAppInterface.getApp().getString(2131697762);; paramVarArgs = paramQQAppInterface.getApp().getString(2131697761))
            {
              bool = false;
              break;
            }
            paramQQAppInterface.a().k(13, l, 0);
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697766);
            bool = false;
            break;
            paramQQAppInterface.a().k(15, l, 0);
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697766);
            bool = false;
            break;
            paramQQAppInterface.a().k(14, l, 0);
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697769);
            bool = false;
            break;
            paramQQAppInterface.a().k(16, l, 0);
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697769);
            bool = false;
            break;
            paramQQAppInterface.a().k(6, l, 0);
            if (paramInt1 == 3000)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697698);
              bool = false;
              break;
            }
            if (paramInt1 != 1) {
              break label1440;
            }
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697763);
            bool = false;
            break;
            if (paramInt1 == 3000)
            {
              paramVarArgs = paramQQAppInterface.getApp().getString(2131697713);
              bool = false;
              break;
            }
            if (paramInt1 != 1) {
              break label1440;
            }
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697713);
            bool = false;
            break;
            paramVarArgs = paramQQAppInterface.getApp().getString(2131721727) + paramString3;
            bool = false;
            break;
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697785);
            bool = false;
            break;
            paramVarArgs = paramQQAppInterface.getApp().getString(2131697784);
            bool = false;
            break;
            localObject = paramVarArgs.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721249));
            break label382;
            localQQMessageFacade.t(paramVarArgs, str);
          }
        }
        label1440:
        bool = false;
        paramVarArgs = (Object[])localObject;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    igd.aK("VideoMsgTools", "addTipsVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", extra=" + paramString2);
    if (paramInt1 == -1) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = paramQQAppInterface.b();
    } while (localQQMessageFacade == null);
    switch (paramInt2)
    {
    case 6: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 26: 
    case 27: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 36: 
    case 37: 
    case 38: 
    case 42: 
    case 43: 
    case 44: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 65: 
    default: 
      paramString2 = paramQQAppInterface.getApp().getString(2131697669);
    }
    label1170:
    for (;;)
    {
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = aoon.a(paramString2, 0L, 3, paramBoolean);
      int i;
      if (paramInt1 == 9500)
      {
        ((szy)paramQQAppInterface.getBusinessHandler(49)).a(paramString1, paramString2, anaz.gQ(), false, false, true);
        return;
        paramString2 = paramQQAppInterface.getApp().getString(2131721693);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721745);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721692);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721744);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721772);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721707);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721710);
        continue;
        paramString2 = paramQQAppInterface.getApp().getString(2131721761);
        continue;
        if (paramBoolean)
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131721706);
        }
        else
        {
          paramString2 = paramQQAppInterface.getApp().getString(2131721704);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721746);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721702);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721709);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721773);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721696);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721691);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721767);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131697548);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721727) + paramString2;
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131697669);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721726);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721733);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721731);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721732);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131697632);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131698058);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131697896);
          anot.a(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 1, 0, "", "", "", "");
          continue;
          boolean bool = TextUtils.isEmpty(jll.b(paramQQAppInterface, paramString1));
          paramString2 = paramQQAppInterface.getApp();
          if (bool) {}
          for (i = 2131721728;; i = 2131721729)
          {
            paramString2 = paramString2.getString(i);
            if (bool) {
              break label1170;
            }
            anot.a(null, "CliOper", "", "", "0X800A8D9", "0X800A8D9", 2, 0, "", "", "", "");
            break;
          }
          paramString2 = paramQQAppInterface.getApp().getString(2131721719);
          continue;
          paramString2 = paramQQAppInterface.getApp().getString(2131721730);
        }
      }
      else
      {
        if (paramInt2 == 66)
        {
          i = 1;
          paramString2 = anbi.d(-1001);
          paramString2.selfuin = str1;
          paramString2.frienduin = paramString1;
          paramString2.senderuin = str1;
          paramString2.msg = str2;
          paramString2.msgtype = -1001;
          paramString2.isread = true;
          paramString2.issend = 0;
          paramString2.istroop = paramInt1;
          paramString2.extraflag = 3;
          paramString2.time = anaz.gQ();
          if (i != 0) {
            break label1121;
          }
          localQQMessageFacade.b(paramString2, str1);
        }
        for (;;)
        {
          if ((paramInt2 != 2) && (paramInt2 != 24)) {
            break label1138;
          }
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "0", "", "", "");
          return;
          i = 0;
          break;
          label1121:
          ThreadManager.executeOnSubThread(new VideoMsgTools.4(localQQMessageFacade, paramString2));
        }
        label1138:
        if (paramInt2 != 0) {
          break;
        }
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "0", "", "", "");
        return;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "showGuideBar uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", isVideoMsg: " + paramBoolean + ", friendUin: " + paramString1 + ", selfUin: " + paramString2 + ", videoTime: " + paramString3 + ", msgStr: " + paramString4);
    }
    if (1008 == paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "public account should not show guide bar.");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new VideoMsgTools.3(paramInt2, paramQQAppInterface, paramBoolean, paramString3, paramString2, paramString1));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, int paramInt3, Object... paramVarArgs)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("addVideoMsgWithAvtype uinType = ").append(paramInt1).append(", msgType = ").append(paramInt2).append(", isVideoMsg = ").append(paramBoolean1).append(", friendUin = ").append(paramString1).append(", senderUin = ").append(paramString2).append(", isSender = ").append(paramBoolean2).append(", extra = ").append(paramString3).append(", isRead = ").append(paramBoolean3).append(", avtype = ").append(paramInt3).append(", listSize = ");
      if (paramVarArgs == null)
      {
        localObject = "null";
        QLog.d("VideoMsgTools", 2, localObject);
      }
    }
    else
    {
      if (paramInt1 != 2) {
        break label179;
      }
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
    }
    label179:
    label223:
    do
    {
      do
      {
        do
        {
          return;
          localObject = Integer.valueOf(paramVarArgs.length);
          break;
          if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
            break label223;
          }
        } while (!QLog.isColorLevel());
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
        return;
      } while ((paramInt1 == 1011) || (paramInt1 == -1));
      if (paramInt1 != 10003) {
        break label258;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
    return;
    label258:
    if (paramInt1 == 1000)
    {
      localObject = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localObject != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = ((TroopManager)localObject).b(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (((paramQQAppInterface.a().getSessionType() == 1) || (paramQQAppInterface.a().getSessionType() == 2)) && ((paramInt2 == 15) || (paramInt2 == 9) || (paramInt2 == 62) || (paramInt2 == 63))) {
        if ((paramQQAppInterface.a().getSessionType() != 2) || (paramInt2 != 15)) {
          break label552;
        }
      }
      label552:
      for (boolean bool = true;; bool = paramBoolean1)
      {
        b(paramQQAppInterface, paramInt1, paramInt2, bool, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        new Handler().postDelayed(new VideoMsgTools.1(paramInt2, paramQQAppInterface, paramInt1, paramBoolean1, paramString1, paramString3, paramString2, paramInt3, paramVarArgs), 500L);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't find troop info!");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("VideoMsgTools", 2, "can't get friend manager!");
        return;
        if (cI(paramInt2))
        {
          if (cJ(paramInt2))
          {
            a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, paramInt3, paramVarArgs);
            return;
          }
          b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
          return;
        }
        if (cJ(paramInt2))
        {
          a(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramVarArgs);
          return;
        }
        a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    QLog.d("VideoMsgTools", 1, "addVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", isVideoMsg = " + paramBoolean1 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", extra = " + paramString3 + ", isRead = " + paramBoolean3);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoMsgTools", 2, "friendUin & senderUin can't empty!");
      }
    }
    label144:
    do
    {
      break label144;
      do
      {
        return;
      } while ((paramInt1 == 1011) || (paramInt1 == -1));
      if (paramInt1 != 10003) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoMsgTools", 2, "uinType is nearbyVideo, return");
    return;
    if (paramInt1 == 1000)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localTroopManager != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString2 = localTroopManager.b(paramString2);
        if (paramString2 != null) {
          paramString2 = paramString2.troopcode;
        }
      }
    }
    for (;;)
    {
      if (cI(paramInt2))
      {
        if (cJ(paramInt2))
        {
          a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramBoolean2, paramBoolean3, 0, paramVarArgs);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't find troop info!");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoMsgTools", 2, "can't get friend manager!");
          return;
        }
        b(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString2, paramBoolean2, paramString3, paramBoolean3, paramVarArgs);
        return;
      }
      if (cJ(paramInt2))
      {
        a(paramQQAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramString3, 0, paramVarArgs);
        return;
      }
      a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, paramString3);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Object... paramVarArgs)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramQQAppInterface.a();
    long l1 = Long.valueOf(paramString1).longValue();
    int i = ((AVNotifyCenter)localObject1).z(l1);
    if (paramInt2 != 0) {
      i = paramInt2;
    }
    if (paramInt1 == 3000) {}
    for (paramInt2 = 1;; paramInt2 = i)
    {
      if (!dm.containsKey(paramString1 + String.valueOf(paramInt2))) {
        dm.put(paramString1 + String.valueOf(paramInt2), "add");
      }
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoMsgTools", 1, "addMultiVideoMsg, err, uinType[" + paramInt1 + "], friendUin[" + paramString1 + "], senderUin[" + paramString2 + "]");
        }
        return;
      }
      boolean bool;
      if (paramInt1 == 3000)
      {
        localObject1 = paramQQAppInterface.getApp().getString(2131697747);
        bool = false;
      }
      for (;;)
      {
        label211:
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (paramVarArgs != null)
        {
          localObject2 = localObject3;
          if (paramVarArgs.length > 0)
          {
            localObject2 = localObject3;
            if (paramVarArgs[0] != null)
            {
              localObject2 = localObject3;
              if ((paramVarArgs[0] instanceof msg_comm.Msg)) {
                localObject2 = (msg_comm.Msg)paramVarArgs[0];
              }
            }
          }
        }
        l1 = 0L;
        if (localObject2 != null) {
          l1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).msg_time.get();
        }
        long l2 = l1;
        long l3;
        if (paramVarArgs != null)
        {
          l2 = l1;
          if (paramVarArgs.length >= 2)
          {
            l2 = l1;
            if (paramVarArgs[0] != null)
            {
              l2 = l1;
              if ((paramVarArgs[0] instanceof Long))
              {
                l2 = l1;
                if (paramVarArgs[1] != null)
                {
                  l2 = l1;
                  if ((paramVarArgs[1] instanceof Long))
                  {
                    l2 = ((Long)paramVarArgs[0]).longValue();
                    l3 = ((Long)paramVarArgs[1]).longValue();
                    if (l2 != 0L) {
                      l1 = l2;
                    }
                    l2 = l1;
                    if (l3 != 0L) {
                      l2 = l1;
                    }
                  }
                }
              }
            }
          }
        }
        for (l1 = l3;; l1 = 0L)
        {
          paramVarArgs = aoon.a((String)localObject1, 13L, 3, true);
          localObject2 = anbi.d(-2016);
          ((MessageRecord)localObject2).selfuin = str;
          ((MessageRecord)localObject2).frienduin = paramString1;
          ((MessageRecord)localObject2).senderuin = paramString2;
          ((MessageRecord)localObject2).msg = (paramVarArgs + "|" + paramInt2 + "|" + bool);
          ((MessageRecord)localObject2).msgtype = -2016;
          ((MessageRecord)localObject2).isread = paramBoolean2;
          if (paramInt1 == 3000) {
            ((MessageRecord)localObject2).isread = true;
          }
          if (paramBoolean1)
          {
            ((MessageRecord)localObject2).issend = 1;
            label539:
            ((MessageRecord)localObject2).istroop = paramInt1;
            ((MessageRecord)localObject2).extraflag = 3;
            if (l1 != 0L) {
              ((MessageRecord)localObject2).shmsgseq = l1;
            }
            ((MessageRecord)localObject2).extInt = paramInt2;
            if (l2 <= 0L) {
              break label961;
            }
          }
          label961:
          for (((MessageRecord)localObject2).time = l2;; ((MessageRecord)localObject2).time = anaz.gQ())
          {
            if (QLog.isColorLevel()) {
              QLog.w("VideoMsgTools", 2, "addMultiVideoMsg, [before add], uinType[" + paramInt1 + "], friendUin[" + paramString1 + "], senderUin[" + paramString2 + "], time[" + ((MessageRecord)localObject2).time + "], seq[" + ((MessageRecord)localObject2).shmsgseq + "], sendTime[" + l2 + "], msgSeq[" + l1 + "], uniseq[" + ((MessageRecord)localObject2).uniseq + "]");
            }
            paramQQAppInterface.a().e((MessageRecord)localObject2, paramBoolean2);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              aiyw.a(paramQQAppInterface, ((MessageRecord)localObject2).frienduin, paramInt1, true, "qav");
            }
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.w("VideoMsgTools", 4, "addMultiVideoMsg, [after add], uinType[" + paramInt1 + "], friendUin[" + paramString1 + "], senderUin[" + paramString2 + "], time[" + ((MessageRecord)localObject2).time + "], seq[" + ((MessageRecord)localObject2).shmsgseq + "], sendTime[" + l2 + "], msgSeq[" + l1 + "], uniseq[" + ((MessageRecord)localObject2).uniseq + "]");
            return;
            if (paramInt1 != 1) {
              break label978;
            }
            if (paramInt2 == 10)
            {
              localObject1 = paramQQAppInterface.getApp().getString(2131697771);
              bool = false;
              break label211;
            }
            localObject1 = paramQQAppInterface.a().a(l1, paramInt2);
            if ((localObject1 != null) && (((AVNotifyCenter.h)localObject1).ut()))
            {
              localObject1 = paramQQAppInterface.getApp().getString(2131697775);
              bool = true;
              break label211;
            }
            localObject1 = paramQQAppInterface.getApp().getString(2131697770);
            bool = false;
            break label211;
            ((MessageRecord)localObject2).issend = 0;
            break label539;
          }
        }
        label978:
        bool = false;
        localObject1 = null;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    switch (paramInt)
    {
    case 1006: 
    default: 
      return;
    }
    paramQQAppInterface.y(paramString1, paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    int i = aqji.LY();
    int j = aqji.pD();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramQQAppInterface.getCurrentAccountUin());
    j -= 1;
    i = Math.min(i - 1, j);
    boolean bool = aqji.ab(paramQQAppInterface, paramString1);
    QLog.w("VideoMsgTools", 1, "selectMemberToStartGAudioChat, uinType[" + paramInt + "], groupUin[" + paramString1 + "], gruopName[" + paramString2 + "], bVideo[" + paramBoolean + "], leftAutoSelectNum[" + i + "], leftMaxSelect[" + j + "], canShowInviteEntry[" + bool + "], fromWhere[" + paramString3 + "]");
    Resources localResources = paramQQAppInterface.getApplication().getResources();
    String str2 = localResources.getString(2131697691);
    String str1 = localResources.getString(2131697693);
    if ("AIOShareScreen".equals(paramString3))
    {
      str2 = localResources.getString(2131697930);
      str1 = localResources.getString(2131697694);
      bool = false;
    }
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_all_select_max_num", i);
    localIntent.putExtra("param_max", j);
    localIntent.putExtra("group_uin", paramString1);
    localIntent.putExtra("group_name", paramString2);
    localIntent.putExtra("param_type", paramInt);
    localIntent.putExtra("param_subtype", 5);
    localIntent.putExtra("param_entrance", 35);
    localIntent.putExtra("param_title", localResources.getString(2131697743));
    localIntent.putExtra("param_done_button_wording", str2);
    localIntent.putExtra("param_done_button_highlight_wording", str1);
    localIntent.putExtra("show_invite_entry", bool);
    localIntent.putExtra("param_show_myself", false);
    paramString2 = new ArrayList();
    paramString2.add("2854196310");
    localIntent.putStringArrayListExtra("param_uins_hide", paramString2);
    if (paramInt == 1) {
      localIntent.putExtra("param_only_troop_member", true);
    }
    for (;;)
    {
      paramContext = new WeakReference(paramContext);
      localIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.7(new Handler(), paramBoolean, paramContext, paramInt, paramString1, paramString3));
      b(paramQQAppInterface, paramQQAppInterface.getApp(), localIntent);
      return;
      localIntent.putExtra("param_only_discussion_member", true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      AudioHelper.b("VideoMsgTools.addGroupMember", paramIntent.getExtras(), true);
    }
    String str = paramIntent.getStringExtra("uin");
    long l1 = paramIntent.getLongExtra("room_id", 0L);
    int i = paramIntent.getIntExtra("room_create_time", 0);
    ArrayList localArrayList1 = paramIntent.getParcelableArrayListExtra("memberlist");
    long l2 = jlc.a(paramIntent);
    paramIntent = new StringBuilder().append("addGroupMember begin, uin[").append(str).append("], roomID[").append(l1).append("], sTopActivity[");
    if (BaseActivity.sTopActivity != null) {}
    ArrayList localArrayList2;
    for (boolean bool = true;; bool = false)
    {
      QLog.w("VideoMsgTools", 1, bool + "], seq[" + l2 + "]");
      paramIntent = new Intent(paramContext, SelectMemberActivity.class);
      paramIntent.addFlags(268435456);
      localArrayList2 = new ArrayList(localArrayList1.size());
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (aqft.rl(localResultRecord.uin)) {
          localArrayList2.add(localResultRecord.uin);
        }
      }
    }
    bool = aqji.ab(paramQQAppInterface, str);
    if (bool) {
      jjk.b.showEntry();
    }
    int j = Math.max(aqji.LZ() - localArrayList1.size(), 0);
    j = Math.min(aqji.pD(), j);
    paramIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList2);
    paramIntent.putExtra("room_create_time", i);
    paramIntent.putExtra("room_id", l1);
    paramIntent.putExtra("group_uin", str);
    paramIntent.putExtra("param_groupcode", str);
    paramIntent.putExtra("param_type", 1);
    paramIntent.putExtra("param_subtype", 1);
    paramIntent.putExtra("param_entrance", 11);
    paramIntent.putExtra("param_max", j);
    paramIntent.putExtra("show_invite_entry", bool);
    paramIntent.putExtra("param_donot_need_contacts", true);
    paramIntent.putExtra("param_title", paramContext.getString(2131697864));
    paramIntent.putExtra("group_name", paramContext.getString(2131697863));
    paramIntent.putExtra("param_done_button_wording", paramContext.getString(2131692643));
    paramIntent.putExtra("param_done_button_highlight_wording", paramContext.getString(2131692644));
    AudioHelper.b("VideoMsgToolsaddGroupMember", paramIntent.getExtras(), true);
    paramIntent.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.8(new Handler(), l2, str));
    b(paramQQAppInterface, paramContext, paramIntent);
    QLog.w("VideoMsgTools", 1, "addGroupMember end, uin[" + str + "], seq[" + l2 + "]");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, aolm.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "sendHttpReq requestUrl  = " + paramString1 + ", actid = " + paramString2);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    long l2 = 0L;
    Object localObject2 = "";
    String str2 = "";
    try
    {
      String str3 = new URL(paramString1).getHost();
      String str1 = str2;
      Object localObject1 = localObject2;
      long l1 = l2;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str2;
        localObject1 = localObject2;
        l1 = l2;
        if (str3.endsWith(".qq.com"))
        {
          localObject1 = (TicketManager)paramQQAppInterface.getManager(2);
          str1 = paramQQAppInterface.getAccount();
          localObject1 = ((TicketManager)localObject1).getSkey(str1);
          l1 = aA((String)localObject1);
        }
      }
      localObject2 = new aoll();
      ((aoll)localObject2).jdField_f_of_type_Aolm$b = paramb;
      ((aoll)localObject2).mHttpMethod = 0;
      ((aoll)localObject2).jdField_f_of_type_JavaIoOutputStream = new aqjg(ByteArrayPool.getMaxBufInstance(), 153600);
      paramb = paramString3;
      if (paramString3 == null) {
        paramb = "";
      }
      ((aoll)localObject2).bZ = (paramString1 + "g_tk=" + l1 + "&actid=" + paramString2 + "&mp_ext_params=" + aurr.encodeUrl(paramb));
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "req.mReqUrl=" + ((aoll)localObject2).bZ);
      }
      ((aoll)localObject2).cMY = true;
      ((aoll)localObject2).mExcuteTimeLimit = 30000L;
      ((aoll)localObject2).u.put("Connection", "Keep-Alive");
      ((aoll)localObject2).u.put("Cookie", String.format("uin=o%s; skey=%s;", new Object[] { str1, localObject1 }));
      paramQQAppInterface.getNetEngine(0).a((aomg)localObject2);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "sendHttpReq : ", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Object localObject = paramQQAppInterface.a();
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = null;
    }
    label546:
    for (;;)
    {
      if (paramQQAppInterface != null)
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < paramQQAppInterface.length)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoMsgTools", 2, "sig[" + paramInt + "]:" + (paramQQAppInterface[paramInt] & 0xFF));
            }
            paramInt += 1;
            continue;
            byte[] arrayOfByte = new byte[3];
            tmp164_162 = arrayOfByte;
            tmp164_162[0] = 1;
            tmp170_164 = tmp164_162;
            tmp170_164[1] = 1;
            tmp176_170 = tmp170_164;
            tmp176_170[2] = 124;
            tmp176_170;
            localObject = ((anaz)localObject).T(paramString);
            int i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label546;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            arrayOfByte = new byte[3];
            tmp255_253 = arrayOfByte;
            tmp255_253[0] = 1;
            tmp261_255 = tmp255_253;
            tmp261_255[1] = 1;
            tmp267_261 = tmp261_255;
            tmp267_261[2] = -107;
            tmp267_261;
            localObject = ((anaz)localObject).R(paramString);
            i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label546;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramQQAppInterface = null;
            break;
            paramQQAppInterface = ((anaz)localObject).O(paramString);
            break;
            arrayOfByte = new byte[3];
            tmp361_359 = arrayOfByte;
            tmp361_359[0] = 1;
            tmp367_361 = tmp361_359;
            tmp367_361[1] = 1;
            tmp373_367 = tmp367_361;
            tmp373_367[2] = 58;
            tmp373_367;
            localObject = paramQQAppInterface.a().K(paramString);
            i = arrayOfByte.length;
            paramInt = i;
            if (localObject != null) {
              paramInt = i + localObject.length;
            }
            paramString = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, paramString, 0, arrayOfByte.length);
            paramQQAppInterface = paramString;
            if (localObject == null) {
              break label546;
            }
            System.arraycopy(localObject, 0, paramString, arrayOfByte.length, localObject.length);
            paramQQAppInterface = paramString;
            break;
            paramString = ((anaz)localObject).W(paramString);
            if (paramString != null)
            {
              paramQQAppInterface = new byte[paramString.length + 3];
              paramQQAppInterface[0] = 1;
              paramQQAppInterface[1] = 1;
              paramQQAppInterface[2] = -119;
              System.arraycopy(paramString, 0, paramQQAppInterface, 3, paramString.length);
              break;
            }
            paramQQAppInterface = new byte[] { 1, 1, -119 };
            break;
            paramQQAppInterface = ((anaz)localObject).e(paramString, paramQQAppInterface.getCurrentUin());
            break;
            paramQQAppInterface = ((anaz)localObject).a(paramString, paramQQAppInterface.getCurrentUin(), false);
            break;
          }
        }
      }
      return paramQQAppInterface;
    }
  }
  
  static int aA(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String paramString3, boolean paramBoolean3, Object... paramVarArgs)
  {
    QLog.d("VideoMsgTools", 1, "addBubbleVideoMsg uinType = " + paramInt1 + ", msgType = " + paramInt2 + ", friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", isSender = " + paramBoolean2 + ", time = " + paramString3 + ", isRead = " + paramBoolean3);
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = a(paramQQAppInterface.getApp(), paramInt2, paramInt1, paramBoolean2, paramString3);
    String str3 = aoon.a(str2, paramInt2, 3, paramBoolean1);
    if (paramInt1 == 9500)
    {
      ((szy)paramQQAppInterface.getBusinessHandler(49)).a(paramString1, str2, anaz.gQ(), false, false, true);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof msg_comm.Msg))) {}
    for (paramVarArgs = (msg_comm.Msg)paramVarArgs[0];; paramVarArgs = null)
    {
      if (paramVarArgs != null) {}
      for (long l1 = ((msg_comm.MsgHead)paramVarArgs.msg_head.get()).msg_time.get();; l1 = 0L)
      {
        if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || ("0".equals(paramString1)))
        {
          QLog.i("VideoMsgTools", 1, "addBubbleVideoMsg, illegal param, [" + paramString2 + "," + paramString1 + "]");
          return;
        }
        paramVarArgs = anbi.d(-2009);
        paramVarArgs.selfuin = str1;
        paramVarArgs.frienduin = paramString1;
        paramVarArgs.senderuin = paramString2;
        paramVarArgs.msg = str3;
        paramVarArgs.msgtype = -2009;
        if (paramString2.equals(paramString1)) {
          paramBoolean2 = false;
        }
        paramVarArgs.isread = paramBoolean3;
        if ((paramInt1 == 0) || (paramInt1 == 1000) || (paramInt1 == 1004) || (paramInt1 == 1006) || (paramInt1 == 1021) || (paramInt1 == 1010) || (paramInt1 == 1001) || (paramInt1 == 10002)) {
          paramVarArgs.isread = true;
        }
        label420:
        long l3;
        if (paramBoolean2)
        {
          paramVarArgs.issend = 1;
          paramVarArgs.istroop = paramInt1;
          paramVarArgs.extraflag = 3;
          paramString2 = (alkm)paramQQAppInterface.getManager(38);
          if (paramString2 == null) {
            break label664;
          }
          paramString2 = paramString2.a().b(paramString1, paramInt1);
          if (paramString2 == null) {
            break label664;
          }
          l3 = paramString2.lastCallTime;
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "VideoMsgTools updateDoubleCallStatus lastCallTime = " + paramString2.lastCallTime);
          }
        }
        label664:
        for (long l2 = l3;; l2 = 0L)
        {
          if (l1 > 0L) {
            paramVarArgs.time = l1;
          }
          for (;;)
          {
            ThreadManager.executeOnSubThread(new VideoMsgTools.2(paramQQAppInterface, paramVarArgs, paramBoolean3, str1, str2, paramInt1, paramBoolean1));
            a(paramQQAppInterface, paramInt1, paramInt2, paramBoolean1, paramString1, str1, paramString3, str3);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoMsgTools", 2, "addBubbleVideoMsg end");
            return;
            paramVarArgs.issend = 0;
            break label420;
            if (str2.equals(paramQQAppInterface.getApp().getString(2131721720))) {
              paramVarArgs.time = anaz.gQ();
            } else if ((l2 > 0L) && (paramInt2 != 7)) {
              paramVarArgs.time = anaz.gQ();
            } else {
              paramVarArgs.time = (anaz.gQ() - paramQQAppInterface.a().bI());
            }
          }
        }
      }
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext.startActivity(paramIntent, ActivityOptions.makeCustomAnimation(paramContext, 2130772009, 0).toBundle());
      return;
    }
    paramQQAppInterface.getApp().startActivity(paramIntent);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.w("VideoMsgTools", 1, "openMeetingMember, discussUin[" + paramString + "]");
    Intent localIntent = new Intent(paramQQAppInterface.getApplication(), GAudioMembersCtrlActivity.class);
    localIntent.putExtra("discussUin", paramString);
    localIntent.addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity(localIntent);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addDiscussMember discussUin = " + paramString);
    }
    Object localObject1 = ((acdu)paramQQAppInterface.getManager(53)).z(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      int j = ((ArrayList)localObject1).size();
      int i = 0;
      while (i < j)
      {
        localObject2 = (DiscussionMemberInfo)((ArrayList)localObject1).get(i);
        if (localObject2 != null) {
          localArrayList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
        i += 1;
      }
    }
    localObject1 = new VideoMsgTools.5(new Handler());
    Object localObject2 = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    ((Intent)localObject2).putStringArrayListExtra("param_uins_selected_default", localArrayList);
    ((Intent)localObject2).putExtra("param_groupcode", paramString);
    ((Intent)localObject2).putExtra("param_type", 3000);
    ((Intent)localObject2).putExtra("param_subtype", 1);
    ((Intent)localObject2).putExtra("param_entrance", 11);
    ((Intent)localObject2).putExtra("param_max", 100 - localArrayList.size());
    ((Intent)localObject2).putExtra("param_donot_need_contacts", true);
    ((Intent)localObject2).putExtra("param_title", paramQQAppInterface.getApplication().getString(2131697864));
    ((Intent)localObject2).putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131692643));
    ((Intent)localObject2).putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131692644));
    ((Intent)localObject2).putExtra("PARAM_ActivityResultReceiver", (Parcelable)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    paramQQAppInterface.getApplication().startActivity((Intent)localObject2);
  }
  
  public static boolean cI(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 24) || (paramInt == 3) || (paramInt == 7) || (paramInt == 10) || (paramInt == 12) || (paramInt == 42) || (paramInt == 43) || (paramInt == 13) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 53) || (paramInt == 6) || (paramInt == 9);
  }
  
  public static boolean cJ(int paramInt)
  {
    return (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 20) || (paramInt == 19) || (paramInt == 44) || (paramInt == 59) || (paramInt == 60) || (paramInt == 22) || (paramInt == 69) || (paramInt == 68) || (paramInt == 71) || (paramInt == 70);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l = AudioHelper.hG();
    int i = 48;
    if (paramInt == 1) {
      i = 8;
    }
    if (QLog.isColorLevel()) {
      QLog.w("double_2_multi", 1, "addMemberFromC2C, seq[" + l + "], peerUin[" + paramString + "], supportUinType[" + paramInt + "], max[" + i + "]");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new Intent(paramQQAppInterface.getApplication(), SelectMemberActivity.class);
    paramString.putExtra("param_type", paramInt);
    paramString.putExtra("param_subtype", 0);
    paramString.putExtra("param_from", 1001);
    paramString.putExtra("param_entrance", 36);
    paramString.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    paramString.putExtra("param_add_passed_members_to_result_set", true);
    paramString.putExtra("param_max", i);
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_title", paramQQAppInterface.getApplication().getString(2131697864));
    paramString.putExtra("param_done_button_wording", paramQQAppInterface.getApplication().getString(2131692643));
    paramString.putExtra("param_done_button_highlight_wording", paramQQAppInterface.getApplication().getString(2131692644));
    paramString.putExtra("PARAM_ActivityResultReceiver", new VideoMsgTools.6(new Handler(), l));
    paramString.addFlags(268435456);
    b(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "send_struct_massage_upgrade.peerUin = " + paramString + ", type = " + paramInt);
    }
    Object localObject = aqmj.f(paramQQAppInterface.getCurrentAccountUin());
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoMsgTools", 2, "configXML : " + (String)localObject);
      }
      if (localObject == null) {
        break label178;
      }
      localObject = ansj.a((String)localObject);
      if (localObject == null) {
        break;
      }
      aqmf.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject, null);
      return;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_video", null);
      continue;
      localObject = ((SharedPreferences)localObject).getString("qav_upgrade_invite_multi", null);
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "absMsg is null! use default");
    }
    f(paramQQAppInterface, paramString, paramInt);
    return;
    label178:
    if (QLog.isColorLevel()) {
      QLog.i("VideoMsgTools", 2, "configXML is null! use default");
    }
    f(paramQQAppInterface, paramString, paramInt);
  }
  
  static void f(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getApp().getApplicationContext().getString(2131698148);
    Object localObject2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131698147);
    localObject1 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(62).a((String)localObject2).e("https://im.qq.com/mobileqq/touch").a((String)localObject1, null).a();
    localObject2 = anrd.a(2);
    String str = paramQQAppInterface.getApp().getApplicationContext().getString(2131698151);
    ((anqv)localObject2).aU("https://url.cn/hw298C", paramQQAppInterface.getApp().getApplicationContext().getString(2131698153), str);
    ((AbsShareMsg)localObject1).addItem((anqu)localObject2);
    aqmf.a(paramQQAppInterface, paramString, 0, (AbsStructMsg)localObject1, null);
  }
  
  static class MygetGroupInfoRunnable
    implements Runnable
  {
    WeakReference<QQAppInterface> bT = null;
    long seq = 0L;
    String uin = null;
    
    public MygetGroupInfoRunnable(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
    {
      this.seq = paramLong;
      this.bT = new WeakReference(paramQQAppInterface);
      this.uin = paramString;
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.bT.get();
      if (localQQAppInterface != null) {
        aqji.c("addGroupMember_" + this.seq, localQQAppInterface, this.uin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */