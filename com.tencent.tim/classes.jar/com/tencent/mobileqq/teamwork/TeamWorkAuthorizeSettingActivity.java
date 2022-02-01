package com.tencent.mobileqq.teamwork;

import acfd;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import anzx;
import anzy;
import anzz;
import aoaa;
import aoab;
import aoac;
import aoad;
import aoae;
import aoae.a;
import aoae.b;
import aobh;
import aobo;
import aqha;
import aqju;
import ausj;
import auss;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  List<aoae.b> GQ;
  XListView U;
  TextView ZC;
  TextView ZD;
  TextView ZE;
  TextView ZF;
  acfd jdField_a_of_type_Acfd = new anzx(this);
  public aoae a;
  private aobh jdField_a_of_type_Aobh;
  aobo b = new aoab(this);
  boolean ceP = false;
  String cjl;
  int dNK;
  int dNL = -1;
  Map<Integer, List<aoae.b>> nr;
  
  private void QG(boolean paramBoolean)
  {
    int k = 0;
    ViewGroup localViewGroup1 = (ViewGroup)findViewById(2131367521);
    ViewGroup localViewGroup2 = (ViewGroup)findViewById(2131368017);
    ViewGroup localViewGroup3 = (ViewGroup)findViewById(2131362164);
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
      QLog.e("TeamWorkAuthorizeSettingActivity", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.ZF.setText(2131720870);
    switch (paramInt)
    {
    default: 
      QLog.w("TeamWorkAuthorizeSettingActivity", 1, "no process PUBFLAG:" + paramInt);
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
    parama = (ausj)auss.a(this, null);
    SparseArray localSparseArray = new SparseArray();
    if (this.dNL != 2)
    {
      parama.addButton(getString(2131720872), 5);
      localSparseArray.put(0, Integer.valueOf(2131720872));
      parama.addButton(getString(2131720873), 5);
      localSparseArray.put(1, Integer.valueOf(2131720873));
    }
    for (;;)
    {
      parama.addButton(getString(2131691404), 3);
      localSparseArray.put(i, Integer.valueOf(2131691404));
      parama.a(new anzy(this, parama));
      parama.addCancelButton(2131721058);
      parama.show();
      return;
      i = 0;
    }
  }
  
  private void dTZ()
  {
    View localView1 = findViewById(2131365566);
    View localView2 = findViewById(2131368017);
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
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
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
    ausj localausj = (ausj)auss.a(this, null);
    SparseArray localSparseArray = new SparseArray();
    localausj.addButton(getString(2131720872), 5);
    localSparseArray.put(0, Integer.valueOf(2131720872));
    localausj.addButton(getString(2131720873), 5);
    localSparseArray.put(1, Integer.valueOf(2131720873));
    localausj.a(new anzz(this, localSparseArray, localausj));
    localausj.setMainTitle("获得文档的人");
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  private void dUc()
  {
    ausj localausj = (ausj)auss.a(this, null);
    SparseArray localSparseArray = new SparseArray();
    localausj.addButton(getString(2131720874), 5);
    localSparseArray.put(0, Integer.valueOf(2131720874));
    localausj.addButton(getString(2131720875), 5);
    localSparseArray.put(1, Integer.valueOf(2131720875));
    localausj.addButton(getString(2131720876), 5);
    localSparseArray.put(2, Integer.valueOf(2131720876));
    localausj.a(new aoaa(this, localSparseArray, localausj));
    localausj.setMainTitle("对谁公开");
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  private void initUI()
  {
    this.ZC = ((TextView)findViewById(2131366005));
    this.ZD = ((TextView)findViewById(2131367520));
    this.ZE = ((TextView)findViewById(2131368016));
    this.U = ((XListView)findViewById(2131381439));
    this.ZF = ((TextView)findViewById(2131366260));
    setLeftViewName(2131690700);
    setRightButton(2131721079, this);
    setTitle(2131720877);
  }
  
  private void parseIntent()
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("team_work_name");
    this.ZC.setText("对\"" + str + "\"进行设置");
    this.cjl = localIntent.getStringExtra("team_work_pad_url");
    this.dNK = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.dNL = localIntent.getIntExtra("team_work_public_tag", -1);
    this.nr = new HashMap();
    this.GQ = new ArrayList();
    this.jdField_a_of_type_Aoae = new aoae(this.app, this, this, this.GQ);
    this.U.setAdapter(this.jdField_a_of_type_Aoae);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    startTitleProgress();
    setContentView(2131563163);
    this.app.addObserver(this.b);
    initUI();
    parseIntent();
    this.jdField_a_of_type_Aobh = ((aobh)this.app.getBusinessHandler(122));
    this.jdField_a_of_type_Aobh.dL(this.dNK, this.cjl);
    QG(false);
    addObserver(this.jdField_a_of_type_Acfd);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.b);
    removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  public boolean onBackEvent()
  {
    if (this.ceP)
    {
      aqha.a(this, 230, getString(2131720866), "", 2131720865, 2131720867, new aoac(this), new aoad(this)).show();
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
      continue;
      dUc();
      continue;
      dUb();
      continue;
      a((aoae.a)paramView.getTag());
      if (this.dNL != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkAuthorizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */