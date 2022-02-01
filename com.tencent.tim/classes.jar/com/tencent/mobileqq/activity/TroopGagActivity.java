package com.tencent.mobileqq.activity;

import abeg;
import abeg.a;
import accd;
import acfp;
import acms;
import acnd;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import apsw;
import apsw.f;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import vyy;
import vyz;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public b a;
  accd b = new vyy(this);
  public Switch d;
  acnd f = new vyz(this);
  LinearLayout gA;
  LinearLayout gB;
  public List<a> rl = new ArrayList();
  public String troopCode;
  TroopInfo troopInfo;
  public View vp;
  XListView w;
  
  private boolean eL(String paramString)
  {
    return (!TextUtils.isEmpty(this.troopInfo.troopowneruin)) && (paramString.equals(this.troopInfo.troopowneruin));
  }
  
  private boolean hs(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.troopInfo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.troopInfo.Administrator))
      {
        arrayOfString = this.troopInfo.Administrator.split("\\|");
        bool1 = bool2;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.app.getManager(52);
    this.troopCode = getIntent().getStringExtra("troopuin");
    this.troopInfo = paramBundle.c(this.troopCode);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131560099, null);
    this.w = ((XListView)paramBundle.findViewById(2131365101));
    this.w.setVerticalScrollBarEnabled(false);
    this.w.setDivider(null);
    this.w.setFocusable(false);
    this.gA = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.gA.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.gA.setOrientation(1);
    localObject = View.inflate(this, 2131561775, null);
    this.gA.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298887), 0, getResources().getDimensionPixelSize(2131298887), getResources().getDimensionPixelSize(2131298884));
    ((TextView)localObject).setTextAppearance(this, 2131756702);
    ((TextView)localObject).setText(getResources().getString(2131698385));
    this.gA.addView((View)localObject);
    this.gB = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.gB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.gB.setOrientation(1);
    this.vp = View.inflate(this, 2131561775, null);
    this.vp.setVisibility(8);
    this.gB.addView(this.vp);
    localObject = View.inflate(this, 2131560084, null);
    this.d = ((Switch)((View)localObject).findViewById(2131378107));
    apsw.f localf = ((apsw)this.app.getManager(48)).a(this.troopCode);
    if ((localf != null) && (localf.gagTimeStamp != 0L))
    {
      this.d.setChecked(true);
      this.d.setOnCheckedChangeListener(this);
      this.gB.addView((View)localObject);
      localObject = View.inflate(this, 2131561775, null);
      this.gB.addView((View)localObject);
      this.w.addFooterView(this.gB);
      this.a = new b();
      this.w.setAdapter(this.a);
      this.w.setBackgroundResource(2130838900);
      super.setContentView(paramBundle);
      setTitle(acfp.m(2131715745));
      if (!aqiw.isNetSupport(BaseApplication.getContext())) {
        QQToast.a(this, 2131696270, 0).show(getTitleBarHeight());
      }
      addObserver(this.b);
      addObserver(this.f);
      long l = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.troopCode, 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label711;
      }
      paramBundle = (TroopManager)this.app.getManager(52);
      if (paramBundle == null) {
        break label711;
      }
      paramBundle = paramBundle.b(this.troopCode);
      ((acms)this.app.getBusinessHandler(20)).b(true, this.troopCode, paramBundle.troopcode, 8);
    }
    label711:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ThreadManager.post(new TroopGagActivity.1(this, (apsw)this.app.getManager(48)), 8, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "doOnCreate: isRequestedTroopList=" + bool);
      }
      return true;
      this.d.setChecked(false);
      break;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    removeObserver(this.b);
    removeObserver(this.f);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    apsw localapsw = (apsw)this.app.getManager(48);
    if (paramBoolean)
    {
      localapsw.H(this.troopCode, 268435455L);
      anot.a(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.troopCode + "", localapsw.lO(this.troopCode), "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      localapsw.H(this.troopCode, 0L);
      anot.a(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.troopCode + "", localapsw.lO(this.troopCode), "", "");
    }
  }
  
  public static class a
  {
    public long Hc;
    String nickname;
    public String uin;
  }
  
  public class b
    extends abeg
    implements View.OnClickListener
  {
    public b()
    {
      super(TroopGagActivity.this.app, TroopGagActivity.this.w, 1, false);
    }
    
    protected String aW(long paramLong)
    {
      String str = ((apsw)TroopGagActivity.this.app.getManager(48)).j(TroopGagActivity.this, paramLong);
      if (!TextUtils.isEmpty(str)) {
        return "" + str;
      }
      return "";
    }
    
    public int getCount()
    {
      int j = TroopGagActivity.this.rl.size();
      int i = j;
      if (j > 0) {
        i = j + 1;
      }
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      if (paramInt > 0) {
        return TroopGagActivity.this.rl.get(paramInt - 1);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1;
      Object localObject2;
      if (paramInt > 0) {
        if ((paramView == null) || (paramView.getTag() == null))
        {
          paramView = ((LayoutInflater)TroopGagActivity.this.getSystemService("layout_inflater")).inflate(2131560086, paramViewGroup, false);
          localObject1 = new a(null);
          ((a)localObject1).pQ = ((ImageView)paramView.findViewById(2131361802));
          ((a)localObject1).nickName = ((TextView)paramView.findViewById(2131372384));
          ((a)localObject1).Ga = ((TextView)paramView.findViewById(2131367830));
          ((a)localObject1).dG = ((Button)paramView.findViewById(2131378383));
          paramView.setTag(localObject1);
          localObject2 = (TroopGagActivity.a)getItem(paramInt);
          ((a)localObject1).pQ.setImageBitmap(a(1, ((TroopGagActivity.a)localObject2).uin));
          if ((TextUtils.isEmpty(((TroopGagActivity.a)localObject2).nickname)) || (((TroopGagActivity.a)localObject2).nickname.equals(((TroopGagActivity.a)localObject2).uin))) {
            ((TroopGagActivity.a)localObject2).nickname = ((TroopManager)TroopGagActivity.this.app.getManager(52)).getTroopMemberName(TroopGagActivity.this.troopCode, ((TroopGagActivity.a)localObject2).uin);
          }
          ((a)localObject1).nickName.setText(((TroopGagActivity.a)localObject2).nickname);
          ((a)localObject1).dG.setTag(localObject2);
          ((a)localObject1).Ga.setText(aW(((TroopGagActivity.a)localObject2).Hc));
          ((a)localObject1).dG.setOnClickListener(this);
          ((a)localObject1).dG.setEnabled(true);
          ((a)localObject1).uin = ((TroopGagActivity.a)localObject2).uin;
          if ((!TroopGagActivity.a(TroopGagActivity.this, TroopGagActivity.this.app.getCurrentAccountUin())) && ((TroopGagActivity.b(TroopGagActivity.this, ((TroopGagActivity.a)localObject2).uin)) || (TroopGagActivity.a(TroopGagActivity.this, ((TroopGagActivity.a)localObject2).uin)))) {
            ((a)localObject1).dG.setEnabled(false);
          }
          if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
            break label378;
          }
          paramView.setBackgroundResource(2130839689);
          label346:
          localObject1 = paramView;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (a)paramView.getTag();
        break;
        label378:
        paramView.setBackgroundResource(2130839701);
        break label346;
        localObject2 = TroopGagActivity.this.gA;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    
    public void onClick(View paramView)
    {
      Object localObject = paramView.getTag();
      if (!(localObject instanceof TroopGagActivity.a)) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = (TroopGagActivity.a)localObject;
        String str = ((TroopGagActivity.a)localObject).uin;
        apsw localapsw = (apsw)TroopGagActivity.this.app.getManager(48);
        localapsw.f(TroopGagActivity.this.troopCode, str, 0L);
        TroopGagActivity.this.rl.remove(localObject);
        notifyDataSetChanged();
        if (QLog.isColorLevel()) {
          QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + str);
        }
        anot.a(TroopGagActivity.this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, TroopGagActivity.this.troopCode + "", localapsw.lO(TroopGagActivity.this.troopCode), "", "");
      }
    }
    
    class a
      extends abeg.a
    {
      TextView Ga;
      Button dG;
      TextView nickName;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity
 * JD-Core Version:    0.7.0.1
 */