package com.tencent.biz.pubaccount.AccountDetail.activity;

import aced;
import acja;
import adai;
import adam;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqiy;
import asgx;
import ausj;
import auss;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jnl;
import jqs;
import jsu;
import jsv;
import jsw;
import jsx;
import jsy;
import jsz;
import jta;
import jtb;
import jtc;
import jtd;
import jte;
import jtg;
import jzs;
import jzs.a;
import kbp;
import kbs;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import smu;
import smu.a;

public class EqqAccountDetailActivity
  extends AccountDetailActivity
{
  public String TAG = "EqqAccountDetailActivity";
  adai jdField_a_of_type_Adai;
  asgx jdField_a_of_type_Asgx;
  public mobileqq_mp.GetEqqAccountDetailInfoResponse a;
  public int aCX = 0;
  boolean abA = true;
  public boolean abB = false;
  public EqqDetail b;
  NewIntent b;
  NewIntent c;
  LinearLayout dq;
  TextView statusTextView;
  
  public EqqAccountDetailActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail = null;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramInt3 == 0) {
        if (paramInt3 == paramInt2 - 1) {
          if (paramInt1 != 1) {}
        }
      }
    }
    while (paramInt1 <= 1)
    {
      do
      {
        do
        {
          return 0;
        } while (paramInt1 <= 1);
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 2;
        }
        return 3;
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 5;
        }
        return 3;
        if (paramInt3 > 0)
        {
          if (paramInt3 == paramInt2 - 1)
          {
            if (paramInt4 == paramInt1 - 1) {
              return 2;
            }
            if (paramInt4 == 0) {
              return 4;
            }
            return 3;
          }
          if (paramInt4 == 0) {
            return 4;
          }
          if (paramInt4 == paramInt1 - 1) {
            return 5;
          }
          return 3;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "getItemBgType error groupId < 0");
      return 0;
    }
    if (paramInt4 == 0) {
      return 1;
    }
    if (paramInt4 == paramInt1 - 1) {
      return 5;
    }
    return 3;
  }
  
  protected View a(jzs.a parama)
  {
    View localView = super.getLayoutInflater().inflate(2131558771, null);
    ((ImageView)localView.findViewById(2131369459)).setImageResource(2130838939);
    ((ImageView)localView.findViewById(2131362978)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131365360);
    String str = parama.content;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new jtd(this, parama, str));
      return localView;
    }
    return null;
  }
  
  public smu.a a()
  {
    return new smu.a(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.uin, this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.summary);
  }
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (paramBoolean)
    {
      this.bI.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.iW.setVisibility(0);
      }
    }
    while (yp())
    {
      this.iW.setVisibility(0);
      return;
      this.iW.setVisibility(8);
      continue;
      this.bI.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.iW.setVisibility(0);
      } else {
        this.iW.setVisibility(8);
      }
    }
    this.iW.setVisibility(8);
  }
  
  void a(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.cLg();
  }
  
  public void a(EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.3(this, paramEqqDetail, paramBoolean), 10L);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    this.mIntent.getBooleanExtra("need_finish", false);
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
    {
      paramString2 = new Intent(this, ChatActivity.class);
      paramString2.putExtra("chat_subType", 1);
      paramString2.putExtra("cSpecialFlag", this.mIntent.getExtras().getInt("cSpecialFlag"));
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 0);
      paramString2.putExtra("uinname", this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name);
      paramString2.putExtra("isforceRequestDetail", paramBoolean);
      paramString2.putExtra("jump_from", 2);
      startActivity(paramString2);
      return;
    }
    paramString2 = new Intent(this, ChatActivity.class);
    paramString2.putExtra("chat_subType", 1);
    paramString2.putExtra("uin", paramString1);
    paramString2.putExtra("uintype", 1024);
    paramString2.putExtra("uinname", this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name);
    paramString2.putExtra("isforceRequestDetail", paramBoolean);
    paramString2.putExtra("jump_from", 2);
    startActivity(paramString2);
  }
  
  public void a(jzs.a parama)
  {
    int i = parama.state;
    this.abA = false;
    if ((i == 1) || (i == 2))
    {
      this.statusTextView.setText(2131695281);
      return;
    }
    this.statusTextView.setText(2131695282);
  }
  
  public void a(jzs.a parama, int paramInt)
  {
    int i = 1;
    ausj localausj = (ausj)auss.b(this, null);
    localausj.addRadioButton(2131695281, 5, false);
    localausj.addRadioButton(2131695282, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localausj.setRadioButtonChecked(0);
    }
    for (;;)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        i = 0;
      }
      localausj.addCancelButton(2131721058);
      localausj.setOnDismissListener(new jsz(this));
      localausj.a(new jta(this, parama, localausj, i));
      if (!localausj.isShowing())
      {
        this.abB = false;
        localausj.show();
      }
      return;
      localausj.setRadioButtonChecked(1);
    }
  }
  
  boolean a(ViewGroup paramViewGroup, jzs.a parama, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addCrmDetailItem");
    }
    Object localObject = super.getLayoutInflater();
    int j = (int)(10.0F * this.density);
    int k = (int)(15.0F * this.density);
    int i;
    if (parama.type == 3)
    {
      if (parama.aGH == 3)
      {
        this.bI.setVisibility(0);
        return false;
      }
      if (parama.aGH == 10)
      {
        localObject = e(parama);
        if (localObject != null) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        switch (paramInt)
        {
        default: 
          ((View)localObject).setBackgroundResource(2130837606);
        case 4: 
          label148:
          if (parama.type == 4)
          {
            ((View)localObject).setPadding(k, k, k, k);
            parama = (jzs.a)localObject;
          }
          break;
        }
        for (;;)
        {
          paramViewGroup.addView((View)localObject);
          if ((i != 0) && (paramInt == 2))
          {
            parama = new View(parama.getContext());
            parama.setBackgroundColor(Color.parseColor("#dedfe0"));
            paramViewGroup.addView(parama, new ViewGroup.LayoutParams(-1, 1));
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addCrmDetailItem exit");
          }
          return true;
          return false;
          if (parama.aGH == 7)
          {
            parama.lat = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.latitude;
            parama.lng = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.longitude;
            localObject = a(parama);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (parama.aGH == 8)
          {
            localObject = b(parama);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (parama.aGH == 9)
          {
            localObject = d(parama);
            if (localObject != null)
            {
              i = 1;
              break;
            }
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "unhandled event_id: " + parama.aGH);
          }
          return false;
          if (parama.type == 1)
          {
            localObject = ((LayoutInflater)localObject).inflate(2131558771, null);
            ((ImageView)((View)localObject).findViewById(2131369459)).setImageResource(2130838940);
            ((ImageView)((View)localObject).findViewById(2131362978)).setVisibility(0);
            String str = parama.url;
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            ((TextView)((View)localObject).findViewById(2131365360)).setText(str);
            if (parama.title.contains("")) {
              anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
            }
            ((View)localObject).setOnClickListener(new jsu(this, str, parama));
            i = 0;
            break;
          }
          if (parama.type == 2)
          {
            localObject = f(parama);
            if (localObject != null) {
              break label867;
            }
            return false;
          }
          if (parama.type == 4)
          {
            localObject = c(parama);
            if (localObject != null)
            {
              i = 0;
              break;
            }
            return false;
          }
          if (parama.type == 5) {
            return false;
          }
          localObject = ((LayoutInflater)localObject).inflate(2131558771, null);
          i = 0;
          break;
          ((View)localObject).setBackgroundResource(2130837606);
          break label148;
          ((View)localObject).setBackgroundResource(2130837609);
          break label148;
          ((View)localObject).setBackgroundResource(2130837608);
          break label148;
          ((View)localObject).setBackgroundResource(2130837608);
          break label148;
          ((View)localObject).setBackgroundResource(2130837608);
          break label148;
          if (parama.type == 2)
          {
            if (parama.aGI == 5)
            {
              ((View)localObject).setPadding(k, j, k, k);
              parama = (jzs.a)localObject;
            }
            else
            {
              ((View)localObject).setPadding(k, 0, k, 0);
              parama = (jzs.a)localObject;
            }
          }
          else
          {
            ((View)localObject).setPadding(k, j, k, k);
            parama = (jzs.a)localObject;
          }
        }
      }
      parama = ((View)localObject).findViewById(2131365383);
      switch (paramInt)
      {
      default: 
        parama.setBackgroundResource(2130837606);
      }
      for (;;)
      {
        parama.setPadding(0, k, k, k);
        break;
        parama.setBackgroundResource(2130837606);
        continue;
        parama.setBackgroundResource(2130837609);
        continue;
        parama.setBackgroundResource(2130837607);
        continue;
        parama.setBackgroundResource(2130837608);
        continue;
        parama.setBackgroundResource(2130837608);
      }
      label867:
      i = 1;
    }
  }
  
  public boolean a(jzs paramjzs, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup start");
    }
    ViewGroup localViewGroup = i();
    paramjzs = b(paramjzs.fR, paramBoolean1);
    Object localObject = paramjzs.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((jzs.a)((Iterator)localObject).next()).aGI == 5) {
        ((Iterator)localObject).remove();
      }
    }
    int j = paramjzs.size();
    if ((paramBoolean1) && (paramInt1 > 0) && (j > 0) && (paramBoolean2))
    {
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.density)));
      ((View)localObject).setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView((View)localObject);
    }
    int i = 0;
    paramBoolean2 = false;
    if (i < j)
    {
      int k = b(j, paramInt2, paramInt1, i, paramBoolean1);
      if ((a(localViewGroup, (jzs.a)paramjzs.get(i), k, paramBoolean1)) || (paramBoolean2)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        i += 1;
        break;
      }
    }
    if ((!paramBoolean1) && (paramInt1 == paramInt2 - 1))
    {
      paramjzs = new View(this);
      paramjzs.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      paramjzs.setBackgroundColor(Color.parseColor("#d6d6d6"));
      localViewGroup.addView(paramjzs);
    }
    a(localViewGroup, paramBoolean1);
    this.dq.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected void azA()
  {
    this.dq.removeAllViews();
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList != null)
    {
      List localList = jzs.D(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);
      int j = localList.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool = a((jzs)localList.get(i), i, j, false, bool);
        i += 1;
      }
    }
    azq();
  }
  
  public void azB()
  {
    aqiy.bk(null, "pubAcc_follow_confirm", this.uin);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "follow uin=" + this.uin);
    }
    this.abX = true;
    this.iS.postDelayed(new EqqAccountDetailActivity.11(this), 3000L);
    oq(2131697407);
    ((FriendListHandler)this.app.getBusinessHandler(1)).DG(this.uin);
    this.e = new NewIntent(super.getApplicationContext(), kbs.class);
    this.e.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.Ut)) && (this.abW)) {
      localFollowRequest.ext.set(this.Ut);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.uin));
    localFollowRequest.account_type.set(getAccountType());
    this.e.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new jsw(this);
    this.e.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.app.startServlet(this.e);
    this.aDG += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "follow exit");
    }
  }
  
  public void azC()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void azD()
  {
    super.azD();
    if ((TextUtils.isEmpty(this.uin)) || (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_Smu == null) {
      this.jdField_a_of_type_Smu = new smu(this.app, this, a(), getAccountType(), getShareUrl());
    }
    this.jdField_a_of_type_Smu.Qq();
    PublicAccountHandler.a(this.app, this.uin, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  public void azo()
  {
    super.azo();
    this.dq = new LinearLayout(this);
    this.dq.setOrientation(1);
    this.dq.setBackgroundColor(Color.parseColor("#FFFFFF"));
  }
  
  protected void azp()
  {
    int i = 0;
    this.dq.removeAllViews();
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    for (List localList = jzs.D(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);; localList = null)
    {
      if (localList != null)
      {
        int j = localList.size();
        boolean bool = false;
        while (i < j)
        {
          bool = a((jzs)localList.get(i), i, j, true, bool);
          i += 1;
        }
      }
      azq();
      return;
    }
  }
  
  protected void azq()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.realSummary))) {
      return;
    }
    TextView localTextView = new TextView(getActivity().getBaseContext());
    localTextView.setText(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.realSummary);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getActivity().getBaseContext().getResources().getColor(2131165381));
    int i = (int)(this.density * 16.5D);
    int j = (int)(this.density * 16.5D);
    int k = (int)(this.density * 22.5D);
    int m = (int)(this.density * 22.5D);
    int n = (int)(5.0F * this.density);
    localTextView.setPadding(i, k, j, m);
    localTextView.setLineSpacing(n, 1.0F);
    localTextView.setVisibility(0);
    this.dq.addView(localTextView);
  }
  
  public void azr()
  {
    azs();
  }
  
  void azs()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendDetailInfoRequest");
    }
    if (this.d != null) {
      this.d.setObserver(null);
    }
    this.d = new NewIntent(super.getApplicationContext(), jnl.class);
    this.d.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
    localGetEqqDetailInfoRequest.version.set(2);
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      localGetEqqDetailInfoRequest.seqno.set(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.uin));
        label151:
        this.d.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new jtc(this);
        this.d.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.app.startServlet(this.d);
        this.aDG += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "sendCrmDetailInfoRequest exit");
        }
        return;
        localGetEqqDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  public void azt()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      a(this.uin, 1008, this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name, ChatActivity.class);
    }
  }
  
  public void azu()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.5(this), 10L);
  }
  
  public void azv()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.6(this), 10L);
  }
  
  public void azw()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new EqqAccountDetailActivity.7(this), 10L);
  }
  
  public void azx()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {}
    label145:
    label164:
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
      {
        this.bI.setVisibility(0);
        this.iS.setVisibility(8);
        this.iU.setVisibility(0);
        if (!yp()) {
          break label145;
        }
        this.iV.setVisibility(0);
        this.iW.setVisibility(0);
        this.iW.setOnClickListener(this);
      }
      for (;;)
      {
        if ((this.bI.getVisibility() != 8) || (this.iS.getVisibility() != 8)) {
          break label164;
        }
        this.iU.setVisibility(8);
        return;
        this.iS.setVisibility(0);
        this.iS.setOnClickListener(this);
        this.bI.setVisibility(8);
        this.iU.setVisibility(0);
        break;
        this.iV.setVisibility(8);
        this.iW.setVisibility(8);
      }
    }
  }
  
  public void azy()
  {
    if ((this.jdField_a_of_type_Jtg == null) || (this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_Jtg.a() == null)))
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((jtg)this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).destroy();
        this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Jtg = new jtg(this.app, this, this.uin, this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.hI, this.hJ, this.ez, this.hK, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Jtg.D(aj());
      this.jdField_a_of_type_Jtg.bR(this.dq);
      if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
        this.jdField_a_of_type_Jtg.d(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.lz(false);
      this.jdField_a_of_type_Jtg.oi(mZ());
      this.jdField_b_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Jtg);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_Jtg.d(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail);
    }
    this.jdField_a_of_type_Jtg.D(aj());
    this.jdField_a_of_type_Jtg.bR(this.dq);
    this.jdField_a_of_type_Jtg.oi(mZ());
    this.jdField_a_of_type_Jtg.notifyDataSetChanged();
  }
  
  void azz()
  {
    if (yq())
    {
      azp();
      return;
    }
    azA();
  }
  
  protected View b(jzs.a parama)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131558771, null);
    ((ImageView)localView.findViewById(2131369459)).setImageResource(2130838942);
    ((ImageView)localView.findViewById(2131362978)).setVisibility(0);
    String str = parama.content;
    boolean bool1;
    boolean bool2;
    if (str != null)
    {
      str = str.trim();
      bool1 = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility();
      bool2 = Pattern.compile("[\\d-]+?").matcher(str).matches();
      if (!bool2) {
        break label171;
      }
      ((TextView)localView.findViewById(2131365360)).setText(str);
    }
    for (;;)
    {
      localView.setOnClickListener(new jte(this, bool2, str, bool1, parama));
      anot.a(this.app, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.uin, "", "", "");
      return localView;
      return null;
      label171:
      if (!bool1) {
        break;
      }
      ((TextView)localView.findViewById(2131365360)).setText(2131721238);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "buildPhoneItem no phone ability and no ivr ability");
    }
    return null;
  }
  
  void b(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache");
    }
    Object localObject = (aced)this.app.getManager(69);
    if (localObject != null) {
      ((aced)localObject).f(paramEqqDetail);
    }
    localObject = this.app.a().createEntityManager();
    if ((this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, paramEqqDetail.name);
      }
      this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.clone(paramEqqDetail);
      if (!((EntityManager)localObject).update(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail)) {
        ((EntityManager)localObject).drop(EqqDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
      {
        localObject = (acja)this.app.getManager(56);
        if (localObject != null) {
          ((acja)localObject).c(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "saveEqqDetailToDBAndCache exit");
      }
      return;
      this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
      ((EntityManager)localObject).persist(paramEqqDetail);
    }
  }
  
  public void b(jzs.a parama, int paramInt)
  {
    int i = parama.aGI;
    String str1;
    String str2;
    if (paramInt == 1)
    {
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2B", "0X8005A2B", 0, 0, "", "", "", "", false);
      i = 1;
      oq(2131697483);
      this.app.removeObserver(this.jdField_a_of_type_Adai);
      this.jdField_a_of_type_Adai = new adai(new jtb(this, parama, i, paramInt));
      this.app.addObserver(this.jdField_a_of_type_Adai);
      parama = this.app;
      str1 = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.uin;
      str2 = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name;
      if (paramInt != 1) {
        break label194;
      }
    }
    label194:
    for (paramInt = 1;; paramInt = 0)
    {
      adam.f(parama, str1, str2, paramInt);
      this.aDG += 1;
      return;
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.uin, "0X8005A2A", "0X8005A2A", 0, 0, "", "", "", "", false);
      i = 3;
      break;
    }
  }
  
  public void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      ln(paramString);
    }
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          lq(paramString);
          return;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null);
      jqs.a(this.app, this, this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name, this.uin, "IvrEnterpriseDetailEngineFalse");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "showCallConfirm no phone ability and no ivr ability");
  }
  
  protected View c(jzs.a parama)
  {
    Object localObject = parama.title;
    localObject = super.getLayoutInflater().inflate(2131558771, null);
    ((ImageView)((View)localObject).findViewById(2131369459)).setImageResource(2130838941);
    ((TextView)((View)localObject).findViewById(2131365360)).setText(parama.title + " " + parama.content);
    return localObject;
  }
  
  void c(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.remove(paramEqqDetail);
    localEntityManager.close();
  }
  
  protected View d(jzs.a parama)
  {
    View localView = super.getLayoutInflater().inflate(2131563112, null);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131378717)).setText(parama.content);
    localView.setOnClickListener(new jsv(this));
    return localView;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    if ((this.uin != null) && (this.jdField_a_of_type_Asgx.R(this.uin, false)))
    {
      paramBundle = new Intent(this, QidianProfileCardActivity.class);
      paramBundle.putExtra("uin", this.uin);
      startActivity(paramBundle);
      finish();
    }
    return true;
  }
  
  View e(jzs.a parama)
  {
    if (parama.aGI != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "Unhandled ConfigInfo(" + parama.type + ", " + parama.aGH + ", " + parama.aGI + ")");
      }
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2131563112, null);
    this.statusTextView = ((TextView)localView.findViewById(2131378717));
    if ((parama.state == 1) || (parama.state == 2)) {
      this.statusTextView.setText(2131695281);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131379769)).setText(parama.title);
      localView.setOnClickListener(new jsy(this, parama));
      return localView;
      this.statusTextView.setText(2131695282);
    }
  }
  
  View f(jzs.a parama)
  {
    return null;
  }
  
  public String getAccountName()
  {
    String str = "";
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      str = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.name;
    }
    return str;
  }
  
  public int getAccountType()
  {
    return 2;
  }
  
  public String getShareUrl()
  {
    if (this.shareUrl == null) {
      this.shareUrl = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin + "&account_flag=" + this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm");
    }
    return this.shareUrl;
  }
  
  ViewGroup i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "createGroupLayout exit");
    }
    return localLinearLayout;
  }
  
  void ln(String paramString)
  {
    ausj localausj = (ausj)auss.b(this, null);
    localausj.addButton(2131721238);
    localausj.addButton(getString(2131692643) + paramString);
    localausj.addCancelButton(2131721058);
    localausj.a(new jsx(this, localausj, paramString));
    localausj.show();
  }
  
  public void og(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      this.jdField_b_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    if (this.c != null)
    {
      this.c.setObserver(null);
      this.c = null;
    }
  }
  
  public void updateView()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateView");
    }
    azz();
    azx();
    azy();
  }
  
  public boolean yo()
  {
    Object localObject = this.app.a().createEntityManager();
    this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail = ((EqqDetail)((EntityManager)localObject).find(EqqDetail.class, this.uin));
    ((EntityManager)localObject).close();
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.mergeFrom(this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.accountData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.config_group_info;
      if (localObject != null) {
        this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList = ((PBRepeatMessageField)localObject).get();
      }
    }
    catch (Exception localException)
    {
      label90:
      break label90;
    }
    return true;
  }
  
  public boolean yp()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility());
  }
  
  public boolean yq()
  {
    int i = -1;
    if (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) {
      i = this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.followType;
    }
    return i == 1;
  }
  
  public boolean yr()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_b_of_type_ComTencentMobileqqDataEqqDetail.followType == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */