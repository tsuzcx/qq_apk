package com.tencent.mobileqq.activity;

import acfp;
import achq;
import acnd;
import acrp;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import apuh;
import aqdj;
import aqfr;
import aqgv;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import jll.a;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import vzy;
import vzz;
import waa;
import yxe.a;

public class TroopInviteStatusFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  TextView Gb;
  TextView Gc;
  public arhz J;
  yxe.a a = new vzy(this);
  String aQy;
  achq jdField_b_of_type_Achq = new vzz(this);
  private acnd jdField_b_of_type_Acnd = new waa(this);
  public int bLC = 0;
  public int bLD = 0;
  public boolean bbe = false;
  public boolean bbf = false;
  Button dH;
  public Runnable eb = new TroopInviteStatusFragment.1(this);
  public Runnable ec = new TroopInviteStatusFragment.2(this);
  public Runnable ed = new TroopInviteStatusFragment.3(this);
  SingleLineTextView i;
  public int iStatus = 0;
  boolean isFirst = true;
  SingleLineTextView j;
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Handler mUiHandler;
  long msgSeq;
  public ArrayList<String> pK = null;
  View root;
  ImageView rs;
  String senderNick;
  String senderUin;
  String troopCode;
  TroopInfo troopInfo;
  String troopName;
  View vs;
  View vt;
  View vu;
  View vv;
  
  private void BN(int paramInt)
  {
    long l1 = this.msgSeq;
    long l2 = Long.valueOf(this.aQy).longValue();
    structmsg.SystemMsgActionInfo localSystemMsgActionInfo = new structmsg.SystemMsgActionInfo();
    localSystemMsgActionInfo.group_code.set(Long.valueOf(this.troopCode).longValue());
    localSystemMsgActionInfo.type.set(11);
    this.mApp.a().a().a(1, l1, l2, 1, 3, 10016, paramInt, localSystemMsgActionInfo, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "troopCode:" + paramString1 + " invitedUin:" + paramString3 + " msgSeq:" + paramLong + " senderUin:" + paramString4 + " currentUin:" + paramQQAppInterface.getCurrentUin());
    }
    String str = paramString5;
    if (TextUtils.equals(paramString5, paramString4)) {
      str = aqgv.n(paramQQAppInterface, paramString4);
    }
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtra("public_fragment_window_feature", 1);
    paramQQAppInterface.putExtra("troopCode", paramString1);
    paramQQAppInterface.putExtra("troopName", paramString2);
    paramQQAppInterface.putExtra("invitedUin", paramString3);
    paramQQAppInterface.putExtra("senderUin", paramString4);
    paramQQAppInterface.putExtra("senderNick", str);
    paramQQAppInterface.putExtra("msgSeq", paramLong);
    PublicFragmentActivity.b.start(paramContext, paramQQAppInterface, PublicTransFragmentActivity.class, TroopInviteStatusFragment.class);
  }
  
  private void bWO()
  {
    if (this.vs == null) {
      return;
    }
    if ((this.iStatus == 6) || ((this.troopInfo != null) && (this.troopInfo.isExited())))
    {
      this.vs.setVisibility(8);
      this.vt.setVisibility(8);
      this.vu.setVisibility(8);
      this.vv.setVisibility(0);
      this.root.setBackgroundResource(2130851428);
      return;
    }
    this.root.setBackgroundResource(2130838900);
    Object localObject3;
    if (this.bbe)
    {
      this.vs.setVisibility(0);
      this.vt.setVisibility(8);
      this.vu.setVisibility(0);
      this.vv.setVisibility(8);
      this.j.setVisibility(8);
      this.dH.setVisibility(8);
      this.Gb.setVisibility(8);
      switch (this.iStatus)
      {
      }
      for (;;)
      {
        localObject1 = aqdj.a(this.mApp, 4, this.troopCode);
        this.rs.setImageDrawable((Drawable)localObject1);
        localObject3 = "";
        if (this.troopInfo != null) {
          localObject3 = this.troopInfo.getTroopName();
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = this.troopName;
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = localObject1;
          if (this.bLC > 0) {
            localObject3 = (String)localObject1 + "(" + this.bLC + ")";
          }
        }
        this.i.setText((CharSequence)localObject3);
        return;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715830));
        continue;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715823));
        continue;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715822));
        continue;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715829));
        continue;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715821));
        continue;
        this.Gb.setVisibility(0);
        this.Gb.setText(acfp.m(2131715824));
      }
    }
    this.vs.setVisibility(0);
    this.vu.setVisibility(0);
    this.vv.setVisibility(8);
    this.j.setVisibility(0);
    Object localObject1 = acfp.m(2131715826);
    localObject1 = f(this.senderNick, this.senderUin, 8) + (String)localObject1;
    this.j.setText((CharSequence)localObject1);
    if ((TextUtils.isEmpty(this.senderUin)) || ("0".equals(this.senderUin))) {
      this.j.setVisibility(8);
    }
    label984:
    label1127:
    for (;;)
    {
      try
      {
        if ((this.pK != null) && (this.pK.contains(this.senderUin)))
        {
          this.pK.remove(this.senderUin);
          this.bLD -= 1;
        }
        if ((this.bLD <= 0) || (this.pK == null) || (this.pK.isEmpty())) {
          break label984;
        }
        localObject1 = new StringBuilder();
        localObject3 = this.pK.iterator();
        float f1 = 0.0F;
        int k = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label1127;
        }
        String str1 = (String)((Iterator)localObject3).next();
        String str2 = aqgv.d(this.mApp, str1, 0);
        float f2 = aqgv.d(str2);
        if (f1 + f2 < 20)
        {
          if (k > 0) {
            ((StringBuilder)localObject1).append("、");
          }
          ((StringBuilder)localObject1).append(str2);
          k += 1;
          f1 += f2;
          continue;
        }
        if (k != 0) {
          break label1127;
        }
        ((StringBuilder)localObject1).append(f(str2, str1, 20));
        k += 1;
        if (this.bLD > 99)
        {
          ((StringBuilder)localObject1).append("等99+人也在群聊中");
          this.vt.setVisibility(0);
          this.Gc.setText(((StringBuilder)localObject1).toString());
          this.dH.setVisibility(8);
          this.Gb.setVisibility(8);
        }
        switch (this.iStatus)
        {
        case 0: 
        case 6: 
        default: 
          break;
        case -1: 
          this.Gb.setVisibility(0);
          this.Gb.setText("");
          break;
          if (k < this.bLD)
          {
            ((StringBuilder)localObject1).append("等").append(this.bLD).append("人也在群聊中");
            continue;
          }
          localObject2.append("也在群聊中");
        }
      }
      finally {}
      continue;
      this.vt.setVisibility(8);
      continue;
      this.dH.setVisibility(0);
      break;
      this.Gb.setVisibility(0);
      this.Gb.setText(acfp.m(2131715818));
      break;
      this.Gb.setVisibility(0);
      this.Gb.setText(acfp.m(2131715820));
      break;
      this.Gb.setVisibility(0);
      this.Gb.setText(acfp.m(2131715817));
      break;
      this.Gb.setVisibility(0);
      this.Gb.setText(acfp.m(2131715828));
      break;
      this.Gb.setVisibility(0);
      this.Gb.setText(acfp.m(2131715825));
      break;
    }
  }
  
  private String f(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return aqgv.a(paramString1, paramInt);
  }
  
  private void initViews()
  {
    this.root = this.mContentView.findViewById(2131377546);
    this.vs = this.mContentView.findViewById(2131380300);
    this.vt = this.mContentView.findViewById(2131371239);
    this.vu = this.mContentView.findViewById(2131378725);
    this.vv = this.mContentView.findViewById(2131366586);
    this.dH = ((Button)this.mContentView.findViewById(2131362353));
    this.Gb = ((TextView)this.mContentView.findViewById(2131378717));
    this.rs = ((ImageView)this.mContentView.findViewById(2131380296));
    this.i = ((SingleLineTextView)this.mContentView.findViewById(2131380362));
    this.j = ((SingleLineTextView)this.mContentView.findViewById(2131369361));
    this.Gc = ((TextView)this.mContentView.findViewById(2131371243));
    this.rs.setOnClickListener(this);
    this.rs.setOnTouchListener(new jll.a());
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(new jll.a());
    this.dH.setOnClickListener(this);
    bWO();
  }
  
  private boolean vz()
  {
    Object localObject = this.mActivity.getIntent();
    this.troopCode = ((Intent)localObject).getStringExtra("troopCode");
    if (this.troopCode != null) {
      this.troopCode = this.troopCode.trim();
    }
    this.troopName = ((Intent)localObject).getStringExtra("troopName");
    this.aQy = ((Intent)localObject).getStringExtra("invitedUin");
    this.senderUin = ((Intent)localObject).getStringExtra("senderUin");
    this.senderNick = ((Intent)localObject).getStringExtra("senderNick");
    this.msgSeq = ((Intent)localObject).getLongExtra("msgSeq", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "initData troopCode:" + this.troopCode + " invitedUin:" + this.aQy + " msgSeq:" + this.msgSeq + " sendUin:" + this.senderUin + " currentUin:" + this.mApp.getCurrentUin() + " troopName:" + this.troopName);
    }
    if (TextUtils.equals(this.senderUin, this.mApp.getCurrentUin())) {}
    for (this.bbe = true;; this.bbe = false)
    {
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
      this.mApp.addObserver(this.jdField_b_of_type_Achq);
      this.mUiHandler = new Handler();
      this.J = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
      if (aqiw.isNetSupport(getActivity())) {
        break label341;
      }
      QQToast.a(this.mActivity, getActivity().getString(2131696270), 0).show(this.mActivity.getTitleBarHeight()).show();
      return true;
      if (!TextUtils.equals(this.aQy, this.mApp.getCurrentUin())) {
        break;
      }
    }
    this.mActivity.finish();
    return false;
    label341:
    localObject = (TroopManager)this.mApp.getManager(52);
    if (localObject != null) {
      this.troopInfo = ((TroopManager)localObject).b(this.troopCode);
    }
    this.mUiHandler.postDelayed(this.eb, 1000L);
    this.mUiHandler.post(this.ec);
    return true;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity = getActivity();
    if ((this.mActivity == null) || (this.mActivity.app == null) || (this.mContentView == null)) {
      QLog.e("TroopInviteStatusFragment", 1, "doOnCreateView error mActivity:" + this.mActivity + " mContentView:" + this.mContentView);
    }
    do
    {
      return;
      this.mApp = this.mActivity.app;
    } while (!vz());
    initViews();
  }
  
  public int getContentLayoutId()
  {
    return 2131560842;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqfr.b("Grp_AIO", "invite", "in_clk", 0, 0, new String[0]);
      Object localObject = TroopInfoActivity.c(this.troopCode, 4);
      ((Bundle)localObject).putInt("t_s_f", 1001);
      apuh.a(this.mActivity, (Bundle)localObject, 2);
      continue;
      aqfr.b("Grp_AIO", "invite", "in_agree", 0, 0, new String[0]);
      if (!aqiw.isNetSupport(getActivity()))
      {
        QQToast.a(this.mActivity, getActivity().getString(2131696270), 0).show(this.mActivity.getTitleBarHeight()).show();
      }
      else
      {
        localObject = this.troopCode;
        if (QLog.isColorLevel()) {
          QLog.d("TroopInviteStatusFragment", 2, "doCheckPayTroopReq start: " + (String)localObject);
        }
        TroopRequestActivity.a(this.mActivity, this.mApp, (String)localObject, null, this.a);
        if ((this.J != null) && (this.J.isShowing())) {
          this.J.dismiss();
        }
        if (this.J != null)
        {
          this.J.setMessage(2131719519);
          this.J.show();
        }
      }
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(acfp.m(2131715819));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
      this.mApp.removeObserver(this.jdField_b_of_type_Achq);
    }
    if ((this.J != null) && (this.J.isShowing())) {
      this.J.dismiss();
    }
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacks(this.eb);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.isFirst) {
      bWO();
    }
    this.isFirst = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment
 * JD-Core Version:    0.7.0.1
 */