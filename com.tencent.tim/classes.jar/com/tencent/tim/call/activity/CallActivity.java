package com.tencent.tim.call.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aajb;
import aalb;
import accn;
import acdu;
import acdv;
import acfd;
import acnd;
import ajdo;
import aljw;
import alkm;
import anaz;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqgw;
import aqhs;
import aqiw;
import atcr;
import atcs;
import atct;
import atcu;
import atcv;
import atcw;
import atcx;
import atcy;
import atcz;
import atdc;
import atdh;
import auuo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnCardInfo;
import com.tencent.tim.call.qcall.PstnSessionInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import inh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import jkm;
import jll;
import jqs;
import mqq.os.MqqHandler;
import yui;

public class CallActivity
  extends BaseActivity
  implements aajb, Handler.Callback, ViewStub.OnInflateListener, auuo, AbsListView.e, Observer
{
  private TextView Dh;
  private accn jdField_a_of_type_Accn = new atcx(this);
  private acfd jdField_a_of_type_Acfd = new atcu(this);
  protected Handler.Callback a;
  private atdh jdField_a_of_type_Atdh;
  private inh jdField_a_of_type_Inh = new atcy(this);
  private boolean aUT;
  private BroadcastReceiver aw = new atcz(this);
  acdv jdField_b_of_type_Acdv = new atcw(this);
  private acnd jdField_b_of_type_Acnd = new atcv(this);
  private ImmersiveTitleBar2 jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public boolean dhb;
  public boolean dhc;
  boolean dhd = false;
  protected MqqHandler g;
  View.OnClickListener go = new atcs(this);
  private RelativeLayout gv;
  private RelativeLayout gw;
  private boolean isDestroy;
  boolean isFirstEnter = true;
  private boolean isInited;
  private MqqHandler k;
  private boolean mIsForeground;
  private LinearLayout mRootView;
  private int mScrollState = 0;
  
  public CallActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new atct(this);
  }
  
  private void YG(String paramString)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(BaseApplication.getContext(), 2131693404, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    while (paramString == null) {
      return;
    }
    Object localObject = (acdu)this.app.getManager(53);
    Intent localIntent = new Intent(getActivity(), MultiVideoEnterPageActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    ArrayList localArrayList = ((acdu)localObject).z(paramString);
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      localObject = new long[j];
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i);
        if (localDiscussionMemberInfo != null) {
          localObject[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("Type", 3);
      localIntent.putExtra("GroupId", paramString);
      long l = Long.valueOf(paramString).longValue();
      localIntent.putExtra("MultiAVType", this.app.a().z(l));
      ChatActivityUtils.a(this.app, localIntent);
      startActivity(localIntent);
      getActivity().overridePendingTransition(2130772004, 0);
      return;
      localObject = null;
    }
  }
  
  private void bMc()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "setFirstDrawComplete, " + this.isInited);
    }
    if (this.isInited) {
      return;
    }
    this.g.removeMessages(1025);
    this.isInited = true;
    if (!this.aUT) {
      this.g.sendEmptyMessage(1020);
    }
    etd();
  }
  
  private void bMt()
  {
    if (this.aUT) {
      return;
    }
    this.aUT = true;
    ((FriendListHandler)this.app.getBusinessHandler(1)).e(this.app.getCurrentAccountUin(), (byte)2);
  }
  
  private void bMu()
  {
    ((FriendListHandler)this.app.getBusinessHandler(1)).e(this.app.getCurrentAccountUin(), (byte)2);
  }
  
  private void bpM()
  {
    this.app.setHandler(getClass(), this.g);
    this.app.addObserver(this.jdField_a_of_type_Acfd, true);
    this.app.addObserver(this.jdField_b_of_type_Acnd, true);
    this.app.addObserver(this.jdField_a_of_type_Accn, true);
    this.app.addObserver(this.jdField_b_of_type_Acdv, true);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      getActivity().registerReceiver(this.aw, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  private boolean f(String paramString, List<InviteBaseData> paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramString = ((ajdo)this.app.getManager(11)).b(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.uin)) && (!paramString.uin.equals("0")))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        InviteBaseData localInviteBaseData = (InviteBaseData)paramList.next();
        if ((localInviteBaseData.uin != null) && (localInviteBaseData.uin.equals(paramString.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void initUI()
  {
    setContentView(2131558814);
    setContentBackgroundResource(2130838900);
    this.mRootView = ((LinearLayout)findViewById(2131377546));
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mRootView.findViewById(2131379866));
    this.gw = ((RelativeLayout)this.mRootView.findViewById(2131364180));
    this.gv = ((RelativeLayout)this.mRootView.findViewById(2131378743));
    int i = getResources().getColor(2131167361);
    if (ImmersiveUtils.a(getWindow(), true)) {
      i = getResources().getColor(2131167562);
    }
    this.gv.setBackgroundColor(i);
    this.Dh = ((TextView)findViewById(2131369579));
    this.Dh.setOnClickListener(new atcr(this));
    if (this.jdField_a_of_type_Atdh == null) {
      this.jdField_a_of_type_Atdh = new atdh(this.app, this.mRootView, this);
    }
    this.jdField_a_of_type_Atdh.etl();
  }
  
  private void removeObserver()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Acfd);
      this.app.removeObserver(this.jdField_b_of_type_Acnd);
      this.app.removeObserver(this.jdField_a_of_type_Accn);
      this.app.removeObserver(this.jdField_b_of_type_Acdv);
      if (this.app.a() != null) {
        this.app.a().deleteObserver(this.jdField_a_of_type_Inh);
      }
      if (this.app.b() != null) {
        this.app.b().deleteObserver(this);
      }
      alkm localalkm = (alkm)this.app.getManager(38);
      if (localalkm != null) {
        localalkm.deleteObserver(this);
      }
      this.app.removeHandler(getClass());
    }
    try
    {
      getActivity().unregisterReceiver(this.aw);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("CallTab", 2, localException.toString());
    }
  }
  
  protected boolean Pr()
  {
    return (this.mScrollState != 0) && (this.mScrollState != 1);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.a(paramInt, paramView, paramListView);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    Object localObject2 = "99";
    Object localObject1;
    if ((paramRecentBaseData instanceof RecentCallItem))
    {
      localObject2 = (RecentCallItem)paramRecentBaseData;
      localObject1 = ((RecentCallItem)localObject2).a();
      switch (((RecentCallItem)localObject2).getNetWorkType())
      {
      case 2: 
      default: 
        localObject2 = "99";
      }
    }
    for (;;)
    {
      Object localObject4 = (atdc)this.app.getManager(746);
      int i = ((atdc)localObject4).Og();
      Object localObject5 = ((atdc)localObject4).a(this.app.getCurrentAccountUin());
      int j;
      label141:
      Object localObject3;
      label175:
      String str;
      label290:
      label300:
      long l1;
      long l2;
      if (localObject1 != null)
      {
        j = this.app.a().ap(((QCallRecent)localObject1).uin);
        if ((j == 2) || (j == 4))
        {
          ((QCallRecent)localObject1).isVideo = 1;
          j = ((QCallRecent)localObject1).type;
          localObject3 = null;
          paramRecentBaseData = null;
          if ((j != 1006) && (j != 2016)) {
            break label290;
          }
          paramRecentBaseData = ((QCallRecent)localObject1).uin;
          str = ((QCallRecent)localObject1).troopUin;
          if ((paramView == null) || (paramView.getId() != 2131364182)) {
            break label1818;
          }
          if (i != 0) {
            break label1187;
          }
          paramBoolean = true;
          if (((QCallRecent)localObject1).isVideo()) {
            paramBoolean = false;
          }
          if (((QCallRecent)localObject1).type != 26) {
            break label300;
          }
          aljw.a(this.app, getActivity(), ((QCallRecent)localObject1).uin, 0, null, 3);
        }
        label769:
        label809:
        label826:
        label873:
        do
        {
          return;
          localObject2 = "0";
          break;
          localObject2 = "1";
          break;
          localObject2 = "2";
          break;
          if ((j != 1) && (j != 3)) {
            break label141;
          }
          ((QCallRecent)localObject1).isVideo = 0;
          break label141;
          localObject3 = ((QCallRecent)localObject1).uin;
          break label175;
          if (((QCallRecent)localObject1).isSystemCall == 1)
          {
            if (((QCallRecent)localObject1).phoneNumber != null) {
              paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
            }
            for (;;)
            {
              if (paramRecentBaseData != null)
              {
                paramView = yui.hN(paramRecentBaseData);
                l1 = anaz.gQ();
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                this.app.a().b(((QCallRecent)localObject1).uin, j, ((QCallRecent)localObject1).contactId, l1, paramView);
              }
              anot.a(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
              return;
              if ((j == 1006) || (j == 56938))
              {
                paramRecentBaseData = ((QCallRecent)localObject1).uin;
              }
              else
              {
                paramView = ((ajdo)this.app.getManager(11)).a(((QCallRecent)localObject1).uin);
                if (paramView != null) {
                  paramRecentBaseData = paramView.mobileNo;
                }
              }
            }
          }
          if ((((QCallRecent)localObject1).type == 3000) || (((QCallRecent)localObject1).type == 1)) {
            try
            {
              l1 = Long.parseLong((String)localObject3);
              i = jll.cL(((QCallRecent)localObject1).type);
              l2 = this.app.a().d(i, l1);
              if ((this.app.a().i(i, l1)) || (this.app.bF()) || (this.app.a().uo()))
              {
                ChatActivityUtils.a(this.app, this, ((QCallRecent)localObject1).type, ((QCallRecent)localObject1).uin, true, true, null, null);
                anot.a(this.app, "dc01331", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject2, "", "", "");
                return;
              }
            }
            catch (NumberFormatException paramView)
            {
              for (;;)
              {
                l1 = 0L;
                continue;
                if (l2 == 0L) {
                  ChatActivityUtils.a(this.app, this, ((QCallRecent)localObject1).type, ((QCallRecent)localObject1).uin, true, true, null, null);
                } else {
                  YG((String)localObject3);
                }
              }
            }
          }
          if (j != 1024) {
            break label949;
          }
          if (jqs.c(this.app, (String)localObject3, j))
          {
            jqs.a(this.app, getActivity(), paramString, (String)localObject3, "IvrCallItemEngineFalse");
            anot.a(this.app, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
            if (!paramBoolean) {
              break label1135;
            }
            anot.a(this.app, "dc01331", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject2, "", "", "");
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject1).isVideo()) {
              break label1173;
            }
            paramView = "1";
            anot.a(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject2, "", "");
            paramRecentBaseData = this.app;
            if (!((QCallRecent)localObject1).isMissedCall()) {
              break label1180;
            }
            paramView = "0";
            anot.a(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
            return;
          }
          QQToast.a(paramView.getContext(), 2131697893, 1).show(paramView.getContext().getResources().getDimensionPixelSize(2131299627));
        } while (!QLog.isColorLevel());
        QLog.d("CallTab", 2, "Don't support ivr");
        return;
        label949:
        localObject4 = null;
        if ((((QCallRecent)localObject1).bindType != 2) && (((QCallRecent)localObject1).bindType != 3) && (((QCallRecent)localObject1).extraType != 25)) {
          break label3985;
        }
        localObject4 = new HashMap();
        ((Map)localObject4).put("dstClient", "Lightalk");
        ((Map)localObject4).put("bindType", String.valueOf(((QCallRecent)localObject1).bindType));
        ((Map)localObject4).put("bindId", ((QCallRecent)localObject1).bindId);
        ((Map)localObject4).put("extraType", String.valueOf(((QCallRecent)localObject1).extraType));
        localObject5 = ((QCallRecent)localObject1).phoneNumber;
        paramView = (View)localObject5;
        paramRecentBaseData = (RecentBaseData)localObject4;
        if (((QCallRecent)localObject1).lightalkSig != null)
        {
          ((Map)localObject4).put("sig", aqhs.bytes2HexStr(((QCallRecent)localObject1).lightalkSig));
          paramRecentBaseData = (RecentBaseData)localObject4;
          paramView = (View)localObject5;
        }
      }
      for (;;)
      {
        ChatActivityUtils.a(this.app, getActivity(), j, (String)localObject3, paramString, paramView, paramBoolean, str, true, true, null, "from_internal", paramRecentBaseData);
        break label769;
        label1135:
        anot.a(this.app, "dc01331", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject2, "", "", "");
        break label809;
        label1173:
        paramView = "0";
        break label826;
        label1180:
        paramView = "1";
        break label873;
        label1187:
        if (i != 1) {
          break;
        }
        paramView = new Intent(getActivity(), QCallDetailActivity.class);
        paramView.putExtra("uin", ((QCallRecent)localObject1).uin);
        paramView.putExtra("troop_uin", ((QCallRecent)localObject1).troopUin);
        paramView.putExtra("uintype", j);
        paramView.putExtra("uinname", paramString);
        paramView.putExtra("bind_type", ((QCallRecent)localObject1).bindType);
        paramView.putExtra("bind_id", ((QCallRecent)localObject1).bindId);
        paramView.putExtra("extra_type", ((QCallRecent)localObject1).extraType);
        paramView.putExtra("phonenum", ((QCallRecent)localObject1).phoneNumber);
        paramView.putExtra("sig", ((QCallRecent)localObject1).lightalkSig);
        paramView.putExtra("entrance", "Call");
        if (((QCallRecent)localObject1).type == 3000)
        {
          localObject3 = ((acdu)this.app.getManager(53)).n(((QCallRecent)localObject1).troopUin);
          paramString = jkm.a(this.app, ((QCallRecent)localObject1).troopUin, 3000);
          paramRecentBaseData = (ajdo)this.app.getManager(11);
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = jkm.q(paramString);
            if ((localObject3 == null) || (((Map)localObject3).keySet() == null)) {
              break label3973;
            }
            localObject3 = ((Map)localObject3).keySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              if ((paramString != null) && (localObject4 != null) && (!paramString.contains(paramRecentBaseData.di((String)localObject4))) && (!((String)localObject4).equals(this.app.getCurrentAccountUin())))
              {
                paramBoolean = false;
                label1495:
                paramView.putExtra("key_from_lightalk_phone_num", paramBoolean);
              }
            }
          }
        }
        for (;;)
        {
          startActivity(paramView);
          anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
          if (((QCallRecent)localObject1).type == 3000) {
            anot.a(this.app, "dc01331", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject2, "", "", "");
          }
          for (;;)
          {
            if (((QCallRecent)localObject1).type == 3000)
            {
              if (paramBoolean)
              {
                anot.a(this.app, "CliOper", "", "", "0X80063F6", "0X80063F6", 4, 0, "", "", "", "");
                return;
                paramBoolean = false;
                break;
                anot.a(this.app, "dc01331", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject2, "", "", "");
                continue;
              }
              anot.a(this.app, "CliOper", "", "", "0X80063F6", "0X80063F6", 3, 0, "", "", "", "");
              return;
            }
          }
          if (((QCallRecent)localObject1).callType == 1)
          {
            anot.a(this.app, "CliOper", "", "", "0X80063F6", "0X80063F6", 1, 0, "", "", "", "");
            return;
          }
          if (((QCallRecent)localObject1).callType != 2) {
            break;
          }
          anot.a(this.app, "CliOper", "", "", "0X80063F6", "0X80063F6", 2, 0, "", "", "", "");
          return;
          label1818:
          if (i == 0)
          {
            paramView = new Intent(getActivity(), QCallDetailActivity.class);
            paramView.putExtra("uin", ((QCallRecent)localObject1).uin);
            paramView.putExtra("troop_uin", ((QCallRecent)localObject1).troopUin);
            paramView.putExtra("uintype", j);
            paramView.putExtra("uinname", paramString);
            paramView.putExtra("bind_type", ((QCallRecent)localObject1).bindType);
            paramView.putExtra("bind_id", ((QCallRecent)localObject1).bindId);
            paramView.putExtra("extra_type", ((QCallRecent)localObject1).extraType);
            paramView.putExtra("phonenum", ((QCallRecent)localObject1).phoneNumber);
            paramView.putExtra("sig", ((QCallRecent)localObject1).lightalkSig);
            paramView.putExtra("entrance", "Call");
            startActivity(paramView);
            anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_info", 0, 0, "", "", "", "");
            if (((QCallRecent)localObject1).type == 3000)
            {
              anot.a(this.app, "dc01331", "", "", "0X8004F8E", "0X8004F8E", 0, 0, (String)localObject2, "", "", "");
              return;
            }
            anot.a(this.app, "dc01331", "", "", "0X8004F87", "0X8004F87", 0, 0, (String)localObject2, "", "", "");
            return;
          }
          paramBoolean = true;
          if (((QCallRecent)localObject1).isVideo()) {
            paramBoolean = false;
          }
          if (((QCallRecent)localObject1).type == 26)
          {
            paramView = new PstnSessionInfo();
            paramView = jkm.a(this.app, paramView, ((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type);
            if ((paramView.cGF != null) && (paramView.cGG != null))
            {
              j = 1;
              int m = 0;
              i = m;
              if (j != 0)
              {
                i = m;
                if (localObject5 != null)
                {
                  if (((PstnCardInfo)localObject5).pstn_c2c_call_time <= 0) {
                    break label2209;
                  }
                  i = 1;
                }
              }
            }
            for (;;)
            {
              aljw.a(this.app, getActivity(), ((QCallRecent)localObject1).uin, i, paramView, 2);
              return;
              j = 0;
              break;
              label2209:
              if ((((atdc)localObject4).Oh() == 1) && (((PstnCardInfo)localObject5).pstn_c2c_try_status == 0)) {
                i = 2;
              } else {
                i = 5;
              }
            }
          }
          if (((QCallRecent)localObject1).isSystemCall == 1)
          {
            if (((QCallRecent)localObject1).phoneNumber != null) {
              paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
            }
            for (;;)
            {
              if (paramRecentBaseData != null)
              {
                paramView = yui.hN(paramRecentBaseData);
                l1 = anaz.gQ();
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView)));
                this.app.a().b(((QCallRecent)localObject1).uin, j, ((QCallRecent)localObject1).contactId, l1, paramView);
              }
              anot.a(null, "CliOper", "", "", "0X8005422", "0X8005422", 0, 0, "", "", "", "");
              return;
              if ((j == 1006) || (j == 56938))
              {
                paramRecentBaseData = ((QCallRecent)localObject1).uin;
              }
              else
              {
                paramView = ((ajdo)this.app.getManager(11)).a(((QCallRecent)localObject1).uin);
                if (paramView != null) {
                  paramRecentBaseData = paramView.mobileNo;
                }
              }
            }
          }
          if ((((QCallRecent)localObject1).type == 3000) || (((QCallRecent)localObject1).type == 1))
          {
            try
            {
              l1 = Long.parseLong((String)localObject3);
              i = jll.cL(((QCallRecent)localObject1).type);
              l2 = this.app.a().d(i, l1);
              if (!this.app.a().i(i, l1)) {
                break label2770;
              }
              paramRecentBaseData = jkm.a(this.app, (String)localObject3, ((QCallRecent)localObject1).type);
              paramView = new ArrayList();
              if (!TextUtils.isEmpty(paramRecentBaseData))
              {
                paramRecentBaseData = jkm.p(paramRecentBaseData);
                if (paramRecentBaseData != null)
                {
                  i = 0;
                  while (i < paramRecentBaseData.size())
                  {
                    paramView.add(((AVPhoneUserInfo)paramRecentBaseData.get(i)).telInfo.mobile);
                    i += 1;
                  }
                }
              }
            }
            catch (NumberFormatException paramView)
            {
              for (;;)
              {
                l1 = 0L;
              }
              if (paramView.size() > 0)
              {
                paramRecentBaseData = jkm.i(paramView);
                if (QLog.isColorLevel()) {
                  QLog.d("CallTab", 2, "R.id.qq_call_bottom_left --> jsonString = " + paramRecentBaseData);
                }
              }
              if (TextUtils.isEmpty(((QCallRecent)localObject1).pstnInfo)) {
                break label2707;
              }
            }
            ChatActivityUtils.a(this.app, getActivity(), 3000, ((QCallRecent)localObject1).troopUin, true, true, true, null, paramView, 2, 3);
            for (;;)
            {
              anot.a(this.app, "dc01331", "", "", "0X800486A", "0X800486A", 0, 0, (String)localObject2, "", "", "");
              return;
              label2707:
              anot.a(null, "dc01331", "", "", "0X800552A", "0X800552A", 0, 0, "", "", "", "");
              ChatActivityUtils.a(this.app, getActivity(), 3000, ((QCallRecent)localObject1).troopUin, true, true, true, null, paramView, 3, 3);
              continue;
              label2770:
              if (l2 == 0L)
              {
                paramView = (acdu)this.app.getManager(53);
                if (paramView != null)
                {
                  paramRecentBaseData = paramView.z((String)localObject3);
                  paramView = new ArrayList();
                  paramRecentBaseData = paramRecentBaseData.iterator();
                  while (paramRecentBaseData.hasNext())
                  {
                    paramString = (DiscussionMemberInfo)paramRecentBaseData.next();
                    if (!paramString.memberUin.equals(this.app.getCurrentAccountUin())) {
                      paramView.add(new InviteBaseData(paramString));
                    }
                  }
                  paramString = jkm.a(this.app, (String)localObject3, ((QCallRecent)localObject1).type);
                  paramRecentBaseData = new ArrayList();
                  if (!TextUtils.isEmpty(paramString))
                  {
                    paramString = jkm.p(paramString);
                    if (paramString != null)
                    {
                      paramString = paramString.iterator();
                      while (paramString.hasNext())
                      {
                        localObject1 = (AVPhoneUserInfo)paramString.next();
                        if (!f(((AVPhoneUserInfo)localObject1).telInfo.mobile, paramView)) {
                          paramView.add(new InviteBaseData((AVPhoneUserInfo)localObject1, this.app));
                        }
                        paramRecentBaseData.add(((AVPhoneUserInfo)localObject1).telInfo.mobile);
                      }
                    }
                  }
                }
              }
              else
              {
                YG((String)localObject3);
              }
            }
          }
          if (j == 1024)
          {
            if (jqs.c(this.app, (String)localObject3, j))
            {
              jqs.a(this.app, getActivity(), paramString, (String)localObject3, "IvrCallItemEngineFalse");
              anot.a(this.app, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
              label3066:
              if (!paramBoolean) {
                break label3884;
              }
              anot.a(this.app, "dc01331", "", "", "0X8004866", "0X8004866", 0, 0, (String)localObject2, "", "", "");
              label3106:
              paramRecentBaseData = this.app;
              if (!((QCallRecent)localObject1).isVideo()) {
                break label3922;
              }
              paramView = "1";
              label3123:
              anot.a(paramRecentBaseData, "CliOper", "", "", "Two_call", "Tc_msg_launch", 0, 0, paramView, (String)localObject2, "", "");
              paramRecentBaseData = this.app;
              if (!((QCallRecent)localObject1).isMissedCall()) {
                break label3929;
              }
              paramView = "0";
              label3170:
              anot.a(paramRecentBaseData, "CliOper", "", "", "Msg_tab", "Call_history_dtl", 0, 0, paramView, "", "", "");
              return;
            }
            QQToast.a(paramView.getContext(), 2131697893, 1).show(paramView.getContext().getResources().getDimensionPixelSize(2131299627));
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("CallTab", 2, "Don't support ivr");
            return;
          }
          if ((j == 1006) || (j == 56938)) {
            paramRecentBaseData = ((QCallRecent)localObject1).uin;
          }
          for (;;)
          {
            if ((((QCallRecent)localObject1).bindType == 2) || (((QCallRecent)localObject1).bindType == 3) || (((QCallRecent)localObject1).extraType == 25))
            {
              paramView = new HashMap();
              paramView.put("dstClient", "Lightalk");
              paramView.put("bindType", String.valueOf(((QCallRecent)localObject1).bindType));
              paramView.put("bindId", ((QCallRecent)localObject1).bindId);
              paramView.put("extraType", String.valueOf(((QCallRecent)localObject1).extraType));
              if (((QCallRecent)localObject1).lightalkSig != null) {
                paramView.put("sig", aqhs.bytes2HexStr(((QCallRecent)localObject1).lightalkSig));
              }
              paramRecentBaseData = ((QCallRecent)localObject1).phoneNumber;
              ChatActivityUtils.a(this.app, getActivity(), j, (String)localObject3, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal", paramView);
              return;
              if (j == 0)
              {
                localObject4 = (ajdo)this.app.getManager(11);
                if (localObject4 != null)
                {
                  localObject4 = ((ajdo)localObject4).a(((QCallRecent)localObject1).uin);
                  if (localObject4 != null) {
                    paramRecentBaseData = ((PhoneContact)localObject4).mobileNo;
                  }
                }
              }
            }
            else
            {
              if (((QCallRecent)localObject1).isVideo())
              {
                ChatActivityUtils.a(this.app, getActivity(), j, (String)localObject3, paramString, paramRecentBaseData, paramBoolean, str, true, true, null, "from_internal", null);
                return;
              }
              if (j == 1024)
              {
                if (jqs.c(this.app, (String)localObject3, j))
                {
                  jqs.a(this.app, getActivity(), paramString, (String)localObject3, "IvrCallItemEngineFalse");
                  anot.a(this.app, "CliOper", "", "", "0X80049D8", "0X80049D8", 0, 0, "", "", "", "");
                  break label3066;
                }
                QQToast.a(paramView.getContext(), 2131697893, 1).show(paramView.getContext().getResources().getDimensionPixelSize(2131299627));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("CallTab", 2, "Don't support ivr");
                return;
              }
              if ((j == 1008) || ((((QCallRecent)localObject1).getState(this.app) != 5) && (((QCallRecent)localObject1).getState(this.app) != 6) && (!this.app.bF()) && (!this.app.a().uo()))) {
                break label3066;
              }
              if (((QCallRecent)localObject1).callType == 1)
              {
                ChatActivityUtils.a(this.app, getActivity(), j, (String)localObject3, paramString, paramRecentBaseData, true, null, true, true, null, "from_internal");
                break label3066;
              }
              if (((QCallRecent)localObject1).callType == 2)
              {
                if (j == 2016) {
                  paramRecentBaseData = (RecentBaseData)localObject3;
                }
                paramView = ((ajdo)this.app.getManager(11)).a();
                localObject4 = new PstnSessionInfo();
                ((PstnSessionInfo)localObject4).cGG = (paramView.nationCode + paramView.mobileNo);
                ((PstnSessionInfo)localObject4).cGF = paramRecentBaseData;
                ((PstnSessionInfo)localObject4).mNickName = paramString;
                ((PstnSessionInfo)localObject4).mPeerUin = ((String)localObject3);
                ((PstnSessionInfo)localObject4).mUinType = j;
                ChatActivityUtils.a(this.app, getActivity(), (PstnSessionInfo)localObject4, 3);
                break label3066;
              }
              ChatActivityUtils.a(this.app, this, j, (String)localObject3, paramString, paramRecentBaseData, true, null, true, true, null, null, 3, true);
              break label3066;
              label3884:
              anot.a(this.app, "dc01331", "", "", "0X8004868", "0X8004868", 0, 0, (String)localObject2, "", "", "");
              break label3106;
              label3922:
              paramView = "0";
              break label3123;
              label3929:
              paramView = "1";
              break label3170;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("CallTab", 2, "onRecentBaseDataClick|call is null, data = " + paramRecentBaseData);
              return;
            }
          }
          label3973:
          paramBoolean = true;
          break label1495;
          paramBoolean = true;
        }
        label3985:
        paramView = paramRecentBaseData;
        paramRecentBaseData = (RecentBaseData)localObject4;
      }
      localObject1 = null;
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    alkm localalkm = (alkm)this.app.getManager(38);
    if ((localalkm != null) && (paramRecentBaseData != null)) {}
    try
    {
      localalkm.fD(paramRecentBaseData.qx(), paramRecentBaseData.ng());
      anot.a(this.app, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
      if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2")))
      {
        if (paramRecentBaseData.ng() == 3000) {
          anot.a(this.app, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
        }
      }
      else {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CallTab", 2, "delRecentCallByUin Error");
        }
      }
      anot.a(this.app, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_Atdh != null)
    {
      boolean bool = aqiw.isNetSupport(BaseApplication.getContext());
      return this.jdField_a_of_type_Atdh.a(paramInt, paramView, paramListView, this.app, this.g, bool);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 == 1400)
          {
            str1 = paramIntent.getStringExtra("roomId");
            localObject = paramIntent.getStringArrayListExtra("qqPhoneUserList");
            paramInt1 = paramIntent.getIntExtra("from", 6);
            this.app.a().r().put(Long.valueOf(str1), "CREATE_FROM_CALL");
            ChatActivityUtils.a(this.app, getActivity(), 3000, str1, true, true, true, null, (ArrayList)localObject, 4, paramInt1);
            if (this.dhc)
            {
              anot.a(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 10, 0, "", "", "", "");
              this.dhc = false;
              return;
            }
            anot.a(this.app, "CliOper", "", "", "0X8006407", "0X8006407", 7, 0, "", "", "", "");
            return;
          }
        } while (paramInt1 != 111);
        paramInt1 = paramIntent.getIntExtra("audioType", -1);
        if (paramInt1 == 1)
        {
          paramInt1 = paramIntent.getIntExtra("uinType", 0);
          str1 = paramIntent.getStringExtra("peerUin");
          localObject = paramIntent.getStringExtra("name");
          str2 = paramIntent.getStringExtra("phoneNum");
          paramIntent = paramIntent.getStringExtra("from");
          ChatActivityUtils.a(this.app, getActivity(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, paramIntent);
          return;
        }
      } while (paramInt1 == 2);
      if (paramInt1 == 3)
      {
        paramInt1 = paramIntent.getIntExtra("uinType", 0);
        str1 = paramIntent.getStringExtra("peerUin");
        localObject = paramIntent.getStringExtra("name");
        str2 = paramIntent.getStringExtra("phoneNum");
        paramInt2 = paramIntent.getIntExtra("from", 3);
        ChatActivityUtils.a(this.app, getActivity(), paramInt1, str1, (String)localObject, str2, true, null, true, true, null, null, paramInt2, true);
        anot.a(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 4);
    paramInt1 = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("peerUin");
    Object localObject = paramIntent.getStringExtra("name");
    String str2 = paramIntent.getStringExtra("phoneNum");
    String str3 = paramIntent.getStringExtra("selfPhoneNum");
    paramInt2 = paramIntent.getIntExtra("from", 3);
    paramIntent = new PstnSessionInfo();
    paramIntent.mUinType = paramInt1;
    paramIntent.mPeerUin = str1;
    paramIntent.mNickName = ((String)localObject);
    paramIntent.cGF = str2;
    paramIntent.cGG = str3;
    ChatActivityUtils.a(this.app, getActivity(), paramIntent, paramInt2);
    anot.a(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.bIn);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.g = new aqgw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    initUI();
    wI(false);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.isDestroy = true;
    this.dhb = false;
    removeObserver();
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.onDestory();
    }
    if (this.k != null) {
      this.k.removeCallbacksAndMessages(null);
    }
    if (this.g != null) {
      this.g.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mIsForeground = false;
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.onPause();
    }
    if (this.k != null) {
      this.k.removeMessages(16);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.dhd = true;
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.onResume();
    }
    this.mIsForeground = true;
    getWindow().setSoftInputMode(32);
    this.mScrollState = 0;
    if (this.isInited)
    {
      if (!this.aUT) {
        this.g.sendEmptyMessage(1020);
      }
      etd();
      this.g.sendEmptyMessageDelayed(1030, 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atdh != null)
      {
        this.jdField_a_of_type_Atdh.b(this.app, 0, false);
        if (this.jdField_a_of_type_Atdh.dhe) {
          this.jdField_a_of_type_Atdh.a(true, true, this.k);
        }
      }
      if (this.app != null)
      {
        alkm localalkm = (alkm)this.app.getManager(38);
        if (localalkm != null) {
          localalkm.kH(anaz.gQ());
        }
      }
      if (this.dhb)
      {
        this.dhc = true;
        this.dhb = false;
      }
      return;
      this.g.sendEmptyMessageDelayed(1025, 3000L);
    }
  }
  
  public void etd()
  {
    atdh localatdh;
    if (this.jdField_a_of_type_Atdh != null)
    {
      if (!this.mIsForeground) {
        break label44;
      }
      localatdh = this.jdField_a_of_type_Atdh;
      if (Pr()) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localatdh.a(bool, true, this.k);
      return;
    }
    label44:
    this.jdField_a_of_type_Atdh.dhe = true;
  }
  
  /* Error */
  public void ete()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 143	com/tencent/tim/call/activity/CallActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1069	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 143	com/tencent/tim/call/activity/CallActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: bipush 38
    //   23: invokevirtual 149	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 491	alkm
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +8 -> 39
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual 1071	alkm:addObserver	(Ljava/util/Observer;)V
    //   39: aload_0
    //   40: getfield 143	com/tencent/tim/call/activity/CallActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 1074	com/tencent/mobileqq/app/QQAppInterface:a	()Lacjq;
    //   46: invokevirtual 1079	acjq:cLY	()V
    //   49: aload_0
    //   50: getfield 143	com/tencent/tim/call/activity/CallActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 225	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   56: aload_0
    //   57: getfield 98	com/tencent/tim/call/activity/CallActivity:jdField_a_of_type_Inh	Linh;
    //   60: invokevirtual 1080	com/tencent/av/gaudio/AVNotifyCenter:addObserver	(Ljava/util/Observer;)V
    //   63: goto -49 -> 14
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	CallActivity
    //   9	2	1	bool	boolean
    //   29	6	2	localalkm	alkm
    //   66	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	66	finally
    //   17	30	66	finally
    //   34	39	66	finally
    //   39	63	66	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.isDestroy) || (getActivity() == null) || (getActivity().isFinishing())) {}
    do
    {
      do
      {
        return true;
      } while ((paramMessage.what != 16) || (!n(paramMessage)) || (this.jdField_a_of_type_Atdh == null));
      this.jdField_a_of_type_Atdh.a(this.app, getActivity(), this.g);
    } while (!QLog.isColorLevel());
    QLog.d("CallTab", 2, "Call.handleMessage");
    return true;
  }
  
  protected boolean n(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "isRefreshRecentDataNecesary: mIsForeground|" + this.mIsForeground + ", msg.arg1|" + paramMessage.arg1);
    }
    return ((this.mIsForeground) || (paramMessage.arg1 != 0)) && (this.app.isLogin());
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    do
    {
      return;
      if (paramView.getId() == 2131363764)
      {
        anot.a(this.app, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(getActivity(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        startActivity(paramView);
        return;
      }
    } while (paramView.getId() != 2131365430);
    paramView = getActivity();
    paramObject = (PhoneContactManagerImp)this.app.getManager(11);
    if (!paramObject.Uy())
    {
      startActivity(new Intent(paramView, GuideBindPhoneActivity.class));
      return;
    }
    if ((paramObject.a() != null) && (paramObject.a().isStopFindMatch))
    {
      paramObject = new Intent(paramView, PhoneLaunchActivity.class);
      paramObject.putExtra("needAlert", true);
      paramObject.putExtra("fromStopAndMatch", true);
      paramObject.putExtra("fromCall", true);
      paramObject.putExtra("leftViewText", "返回");
      paramView.startActivity(paramObject);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004F82", "0X8004F82", 0, 0, "", "", "", "");
      return;
      paramView = new Intent(getActivity(), PhoneFrameActivity.class);
      paramView.putExtra("key_req_type", 4);
      paramView.putExtra("kSrouce", 6);
      getActivity().startActivity(paramView);
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.a(this, paramViewStub, paramView, this.app, this.mRootView, this.gw, this, this, this);
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_Atdh != null) {
      this.jdField_a_of_type_Atdh.etl();
    }
    int i = getResources().getColor(2131167361);
    if (ImmersiveUtils.a(getWindow(), true)) {
      i = getResources().getColor(2131167562);
    }
    if (this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null) {
      this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(i);
    }
    if (this.gv != null) {
      this.gv.setBackgroundColor(i);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        return;
        this.mScrollState = paramInt;
      } while (this.jdField_a_of_type_Atdh == null);
      this.jdField_a_of_type_Atdh.onScrollStateChanged(paramAbsListView, paramInt);
    } while ((paramInt != 0) || (!this.jdField_a_of_type_Atdh.dhe));
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onScrollStateChanged list idle refresh list");
    }
    this.jdField_a_of_type_Atdh.a(true, true, this.k);
  }
  
  public String setLastActivityName()
  {
    return getString(2131720734);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof alkm))
    {
      if (!(paramObject instanceof Boolean)) {
        break label103;
      }
      if (((Boolean)paramObject).booleanValue())
      {
        paramObservable = null;
        if (this.app != null) {
          paramObservable = (alkm)this.app.getManager(38);
        }
        if (paramObservable != null) {
          paramObservable.NR(false);
        }
      }
    }
    for (;;)
    {
      if ((!this.mIsForeground) && (this.g != null) && (aalb.bwh) && (!this.g.hasMessages(1027))) {
        this.g.sendEmptyMessageDelayed(1027, 100L);
      }
      return;
      label103:
      getActivity().runOnUiThread(new CallActivity.10(this));
      etd();
    }
  }
  
  protected void wI(boolean paramBoolean)
  {
    if (this.k == null) {
      this.k = new aqgw(ThreadManager.getRecentThreadLooper(), this);
    }
    bpM();
    if ((paramBoolean) && (this.jdField_a_of_type_Atdh != null))
    {
      this.jdField_a_of_type_Atdh.aq(this.app, false);
      if (this.k != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CallTab", 2, "filldata|change account, clear data ,and refresh");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 16;
        localMessage.arg1 = 1;
        this.k.sendMessage(localMessage);
      }
    }
    ete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.call.activity.CallActivity
 * JD-Core Version:    0.7.0.1
 */