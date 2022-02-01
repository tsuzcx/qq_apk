package com.tencent.mobileqq.teamwork.fragment;

import acfd;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import anot;
import aoae;
import aoae.a;
import aoae.b;
import aobh;
import aobo;
import aoch;
import aoci;
import aocj;
import aock;
import aocl;
import aoco;
import aocp;
import aqha;
import aqju;
import ausj;
import auss;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public List<aoae.b> GQ;
  XListView U;
  TextView ZC;
  TextView ZD;
  TextView ZE;
  TextView ZF;
  acfd jdField_a_of_type_Acfd = new aoch(this);
  public aoae a;
  private aobh jdField_a_of_type_Aobh;
  private QQAppInterface app;
  aobo b = new aoci(this);
  public boolean ceP = false;
  public String cjl;
  public int dNK;
  public int dNL = -1;
  Map<Integer, List<aoae.b>> nr;
  
  private void QG(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)this.mContentView.findViewById(2131367521);
    ViewGroup localViewGroup2 = (ViewGroup)this.mContentView.findViewById(2131368017);
    ViewGroup localViewGroup3 = (ViewGroup)this.mContentView.findViewById(2131362164);
    int i = 0;
    while (i < localViewGroup1.getChildCount())
    {
      localViewGroup1.getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= localViewGroup2.getChildCount()) {
        break;
      }
      localViewGroup2.getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
    while (j < localViewGroup3.getChildCount())
    {
      localViewGroup3.getChildAt(j).setEnabled(paramBoolean);
      j += 1;
    }
    localViewGroup1.setEnabled(paramBoolean);
    localViewGroup2.setEnabled(paramBoolean);
    localViewGroup3.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      VE(this.dNL);
      dTZ();
      localViewGroup1.setOnClickListener(this);
      localViewGroup2.setOnClickListener(this);
      localViewGroup3.setOnClickListener(this);
      return;
    }
    localViewGroup1.setOnClickListener(null);
    localViewGroup2.setOnClickListener(null);
    localViewGroup3.setOnClickListener(null);
  }
  
  private void VE(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.ZF.setText(2131720870);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + paramInt);
      return;
    case 2: 
      this.ZD.setText(2131720874);
      this.ZE.setText(2131720872);
      this.ZF.setText(2131720871);
    }
    for (;;)
    {
      if (this.dNL != paramInt)
      {
        this.ceP = true;
        if ((this.dNL == 2) || (this.dNL == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(this.GQ);
          this.nr.put(Integer.valueOf(this.dNL), localArrayList);
        }
        this.GQ.clear();
      }
      this.dNL = paramInt;
      if (this.nr.containsKey(Integer.valueOf(paramInt))) {
        this.GQ.addAll((Collection)this.nr.get(Integer.valueOf(paramInt)));
      }
      if (this.jdField_a_of_type_Aoae == null) {
        break;
      }
      this.jdField_a_of_type_Aoae.VF(this.dNL);
      return;
      this.ZD.setText(2131720874);
      this.ZE.setText(2131720873);
      continue;
      this.ZD.setText(2131720875);
      continue;
      this.ZD.setText(2131720876);
    }
  }
  
  private void a(aoae.a parama)
  {
    int i = 2;
    ausj localausj = (ausj)auss.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    if (this.dNL != 2)
    {
      localausj.addButton(getString(2131720872), 5);
      localSparseArray.put(0, Integer.valueOf(2131720872));
      localausj.addButton(getString(2131720873), 5);
      localSparseArray.put(1, Integer.valueOf(2131720873));
    }
    for (;;)
    {
      localausj.addButton(getString(2131691404), 3);
      localSparseArray.put(i, Integer.valueOf(2131691404));
      localausj.a(new aocl(this, parama, localSparseArray, localausj));
      localausj.addCancelButton(2131721058);
      localausj.show();
      return;
      i = 0;
    }
  }
  
  private void dTZ()
  {
    View localView1 = this.mContentView.findViewById(2131365566);
    View localView2 = this.mContentView.findViewById(2131368017);
    if (this.dNL == 2)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    if (this.dNL == 3)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(8);
      return;
    }
    if (this.dNL == 1)
    {
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      return;
    }
    localView1.setVisibility(8);
    localView2.setVisibility(8);
  }
  
  private void dUa()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.GQ.size())
    {
      localArrayList.add(String.valueOf(((aoae.b)this.GQ.get(i)).uin));
      i += 1;
    }
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_type", 9504);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 31);
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("param_max", 2000);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    startActivityForResult(localIntent, 1001);
  }
  
  private void dUb()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localausj.addButton(getString(2131720872), 5);
    localSparseArray.put(0, Integer.valueOf(2131720872));
    localausj.addButton(getString(2131720873), 5);
    localSparseArray.put(1, Integer.valueOf(2131720873));
    localausj.a(new aock(this, localSparseArray, localausj));
    localausj.setMainTitle(acfp.m(2131715206));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  private void dUc()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    SparseArray localSparseArray = new SparseArray();
    localausj.addButton(getString(2131720874), 5);
    localSparseArray.put(0, Integer.valueOf(2131720874));
    localausj.addButton(getString(2131720875), 5);
    localSparseArray.put(1, Integer.valueOf(2131720875));
    localausj.addButton(getString(2131720876), 5);
    localSparseArray.put(2, Integer.valueOf(2131720876));
    localausj.a(new aocj(this, localSparseArray, localausj));
    localausj.setMainTitle(acfp.m(2131715161));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  private void initUI()
  {
    this.vg.changeBg(true);
    this.ZC = ((TextView)this.mContentView.findViewById(2131366005));
    this.ZD = ((TextView)this.mContentView.findViewById(2131367520));
    this.ZE = ((TextView)this.mContentView.findViewById(2131368016));
    this.U = ((XListView)this.mContentView.findViewById(2131381439));
    this.ZF = ((TextView)this.mContentView.findViewById(2131366260));
    setLeftViewName(2131690700);
    setRightButton(2131721079, this);
    setTitle(getActivity().getResources().getString(2131720877));
  }
  
  private void parseIntent()
  {
    Intent localIntent = getActivity().getIntent();
    String str = localIntent.getStringExtra("team_work_name");
    if (TextUtils.isEmpty(str)) {
      this.ZC.setVisibility(8);
    }
    this.ZC.setText("对\"" + str + "\"进行设置");
    this.cjl = localIntent.getStringExtra("team_work_pad_url");
    this.dNK = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.dNL = localIntent.getIntExtra("team_work_public_tag", -1);
    this.nr = new HashMap();
    this.GQ = new ArrayList();
    this.jdField_a_of_type_Aoae = new aoae(this.app, getActivity(), this, this.GQ);
    this.U.setAdapter(this.jdField_a_of_type_Aoae);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    startTitleProgress();
    this.app = getActivity().app;
    this.app.addObserver(this.b);
    initUI();
    parseIntent();
    this.jdField_a_of_type_Aobh = ((aobh)this.app.getBusinessHandler(122));
    this.jdField_a_of_type_Aobh.dL(this.dNK, this.cjl);
    anot.a(this.app, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
    QG(false);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  public int getContentLayoutId()
  {
    return 2131563163;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (-1 == paramInt2))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)paramIntent.next();
          TimDocSSOMsg.UinRightInfo localUinRightInfo = new TimDocSSOMsg.UinRightInfo();
          localUinRightInfo.uint64_uin.set(Long.parseLong(localResultRecord.uin));
          localUinRightInfo.uint32_right.set(2);
          localUinRightInfo.uint32_uin_type.set(0);
          aoae.b localb = new aoae.b();
          localb.uin = localResultRecord.uin;
          localb.nickName = localResultRecord.name;
          localb.cjm = localResultRecord.QD;
          localb.uinType = localResultRecord.type;
          localb.b = localUinRightInfo;
          this.jdField_a_of_type_Aoae.a(localb);
          this.ceP = true;
        }
      }
      this.jdField_a_of_type_Aoae.notifyDataSetChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    anot.a(this.app, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
    if (this.ceP)
    {
      aqha.a(getActivity(), 230, getString(2131720866), "", 2131720865, 2131720867, new aoco(this), new aocp(this)).show();
      return false;
    }
    return super.onBackEvent();
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
      dUa();
      anot.a(this.app, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      dUc();
      anot.a(this.app, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      dUb();
      anot.a(this.app, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
      continue;
      a((aoae.a)paramView.getTag());
      if (this.dNL == 1)
      {
        anot.a(this.app, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.GQ.iterator();
        while (localIterator.hasNext())
        {
          aoae.b localb = (aoae.b)localIterator.next();
          if (this.dNL == 2) {
            localb.b.uint32_right.set(2);
          }
          localArrayList.add(localb.b);
        }
        this.jdField_a_of_type_Aobh.a(this.dNL, this.cjl, this.dNK, localArrayList);
        QG(false);
        getRightTextView().setEnabled(false);
        startTitleProgress();
      }
    }
  }
  
  public void onDestroyView()
  {
    if (this.app != null) {
      this.app.removeObserver(this.b);
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment
 * JD-Core Version:    0.7.0.1
 */