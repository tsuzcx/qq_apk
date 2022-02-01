package com.tencent.mobileqq.activity;

import abeg;
import abeg.a;
import acfd;
import acfp;
import acnd;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqft;
import aqha;
import aqhu;
import aqju;
import arib;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import wek;
import wel;
import wem;
import wen;
import weo;
import wep;
import weq;
import wet;
import weu;
import wev;
import wew;
import wex;

public class TroopTransferActivity
  extends BaseActivity
  implements AdapterView.c
{
  protected TextView Bi;
  protected TextView GS;
  protected TextView Gk;
  protected long Ha;
  protected Integer N = Integer.valueOf(0);
  public arib a;
  protected a a;
  public e a;
  protected String aKI;
  public Dialog aa;
  protected ImageButton ae;
  public EditText ay;
  protected int bFL;
  public boolean bbR;
  protected RelativeLayout ex;
  acnd h = new weq(this);
  acfd k = new wep(this);
  protected XListView listView;
  public LinearLayout mRootView;
  protected List<d> mSearchResultList = new ArrayList();
  protected TextView mTitle;
  public View mTitleBar;
  protected String mTroopName;
  public String mTroopUin;
  protected XListView o;
  protected View root;
  protected View sq;
  
  private void bcu()
  {
    Object localObject = (ViewGroup)findViewById(2131377361);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131379791);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369579);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected boolean QU()
  {
    if (this.N.intValue() >= 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "too many update thread|total = " + this.N);
      }
      return false;
    }
    synchronized (this.N)
    {
      Integer localInteger2 = this.N;
      this.N = Integer.valueOf(this.N.intValue() + 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "add update thread |nTotalThreadCount = " + this.N);
      }
      return true;
    }
  }
  
  protected void a(d paramd)
  {
    Object localObject;
    if (((this.Ha & 0x800) != 0L) || (this.bFL != 0))
    {
      localObject = getString(2131691982, new Object[] { acfp.m(2131716151), acfp.m(2131716151) });
      aqju localaqju = aqha.a(this, 230);
      String str = paramd.memberUin;
      localaqju.setTitle(2131721270);
      localaqju.setMessage((CharSequence)localObject);
      localaqju.setPositiveButton(getString(2131721079), new wem(this, str, localaqju));
      localaqju.setPositiveButtonContentDescription(getString(2131692243));
      localaqju.setNegativeButton(getString(2131721058), new wen(this, localaqju));
      localaqju.setNegativeButtonContentDescription(getString(2131692242));
      localaqju.show();
      localObject = this.app;
      if (paramd.bMF != 1) {
        break label203;
      }
    }
    label203:
    for (paramd = "1";; paramd = "0")
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramd, "", "", "");
      return;
      localObject = String.format(getString(2131721335), new Object[] { paramd.displayName });
      break;
    }
  }
  
  public void a(d paramd, Friends paramFriends)
  {
    if (!QU()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramd), 5, null, true);
  }
  
  public void ayl()
  {
    int i = getTitleBarHeight();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    Object localObject2 = new wet(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
    localTranslateAnimation.setFillAfter(true);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setAnimationListener((Animation.AnimationListener)localObject2);
    if (this.aa == null)
    {
      this.aa = new ReportDialog(this);
      this.aa.setCanceledOnTouchOutside(true);
      this.aa.requestWindowFeature(1);
      this.aa.getWindow().setSoftInputMode(36);
      this.aa.setContentView(2131563018);
      localObject2 = this.aa.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.aa.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.aa.setOnDismissListener(new weu(this, i, (TranslateAnimation)localObject1));
      this.root = this.aa.findViewById(2131377546);
      this.ay = ((EditText)this.aa.findViewById(2131366542));
      this.ay.addTextChangedListener(new c(null));
      this.ay.setSelection(0);
      this.ay.requestFocus();
      this.ae = ((ImageButton)this.aa.findViewById(2131368696));
      this.ae.setOnClickListener(new wev(this));
      localObject1 = (Button)this.aa.findViewById(2131363801);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new wew(this));
      this.sq = this.aa.findViewById(2131372437);
      this.ex = ((RelativeLayout)this.aa.findViewById(2131377207));
      this.ex.setOnClickListener(new wex(this));
      this.o = ((XListView)this.aa.findViewById(2131377779));
      this.o.setBackgroundResource(2130838900);
      this.o.setDividerHeight(0);
      this.mSearchResultList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$a = new a(this.mSearchResultList);
      this.o.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$a);
      this.o.setOnTouchListener(new wel(this));
      this.o.setOnItemClickListener(this);
    }
    this.mRootView.startAnimation(localTranslateAnimation);
  }
  
  protected void cT(ArrayList<String> paramArrayList)
  {
    this.mRootView = ((LinearLayout)findViewById(2131380405));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.mRootView.setFitsSystemWindows(true);
    }
    this.mTitleBar = findViewById(2131379791);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.Bi = ((TextView)findViewById(2131369579));
    this.GS = ((TextView)findViewById(2131369581));
    this.GS.setVisibility(4);
    this.Gk = ((TextView)findViewById(2131369612));
    this.Gk.setVisibility(4);
    this.listView = ((XListView)findViewById(2131365101));
    this.mTitle.setText(2131698449);
    this.Bi.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131691039);
    }
    this.Bi.setText((CharSequence)localObject);
    this.Bi.setOnClickListener(new wek(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131563007, this.listView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363801)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131366542)).setOnTouchListener(new weo(this));
    this.listView.addHeaderView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$e = new e(this, paramArrayList);
    this.listView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$e);
    this.listView.setOnItemClickListener(this);
  }
  
  public void cU(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!aqft.equalsWithNullCheck(localTroopMemberCardInfo.troopuin, this.mTroopUin))) {}
    while (!QU()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.14(this, paramArrayList), 5, null, true);
  }
  
  protected void checkParams()
  {
    try
    {
      long l = Long.parseLong(this.mTroopUin);
      Long.parseLong(this.aKI);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, localException.toString());
      }
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.bbR = false;
    paramBundle = getIntent().getExtras();
    this.mTroopUin = paramBundle.getString("troop_uin");
    this.aKI = paramBundle.getString("troop_code");
    this.mTroopName = paramBundle.getString("uinname");
    this.Ha = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
    this.bFL = paramBundle.getInt("troop_auth_submit_time");
    paramBundle = paramBundle.getStringArrayList("troopVipMembers");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate").append("| mTroopUin = ").append(this.mTroopUin).append("| mTroopCode = ").append(this.aKI).append("| mTroopName = ").append(this.mTroopName).append("| mVipMemberList").append(paramBundle);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    checkParams();
    super.setContentView(2131561755);
    cT(paramBundle);
    this.app.addObserver(this.h);
    this.app.addObserver(this.k);
    bcu();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.h);
    this.app.removeObserver(this.k);
    if (this.jdField_a_of_type_Arib != null)
    {
      this.jdField_a_of_type_Arib.dismiss();
      this.jdField_a_of_type_Arib = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$e != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$e.destroy();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.bbR) {}
    for (;;)
    {
      return;
      paramAdapterView = (f)paramView.getTag();
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.b; (paramAdapterView != null) && (paramAdapterView.bME == 1); paramAdapterView = null)
      {
        a(paramAdapterView);
        return;
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void vv(String paramString)
  {
    this.mSearchResultList.clear();
    this.root.getLayoutParams().height = -1;
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.ae.setVisibility(8);
      this.o.setVisibility(8);
      this.sq.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$a.notifyDataSetChanged();
      return;
    }
    this.ae.setVisibility(0);
    this.o.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$e.be();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      d locald = (d)localList.get(i);
      locald.aRf = "";
      locald.aRg = "";
      if ((locald.aRl.equals(paramString)) || (locald.aRn.equals(paramString)) || (locald.aRm.equals(paramString)))
      {
        locald.aRf = locald.aRl;
        localArrayList1.add(locald);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((locald.remark.equals(paramString)) || (locald.aRk.equals(paramString)) || (locald.aRj.equals(paramString)))
        {
          locald.aRf = locald.remark;
          localArrayList1.add(locald);
        }
        else if ((locald.nickname.equals(paramString)) || (locald.aRi.equals(paramString)) || (locald.aRh.equals(paramString)))
        {
          locald.aRf = locald.nickname;
          localArrayList1.add(locald);
        }
        else if (locald.memberUin.equals(paramString))
        {
          locald.aRf = locald.memberUin;
          localArrayList1.add(locald);
        }
        else if ((locald.aRl.indexOf(paramString) == 0) || (locald.aRn.indexOf(paramString) == 0) || (locald.aRm.indexOf(paramString) == 0))
        {
          locald.aRf = locald.aRl;
          locald.aRg = locald.aRm;
          localArrayList2.add(locald);
        }
        else if ((locald.remark.indexOf(paramString) == 0) || (locald.aRk.indexOf(paramString) == 0) || (locald.aRj.indexOf(paramString) == 0))
        {
          locald.aRf = locald.remark;
          locald.aRg = locald.aRj;
          localArrayList2.add(locald);
        }
        else if ((locald.nickname.indexOf(paramString) == 0) || (locald.aRi.indexOf(paramString) == 0) || (locald.aRh.indexOf(paramString) == 0))
        {
          locald.aRf = locald.nickname;
          locald.aRg = locald.aRh;
          localArrayList2.add(locald);
        }
        else if (locald.memberUin.indexOf(paramString) == 0)
        {
          locald.aRf = locald.memberUin;
          locald.aRg = locald.memberUin;
          localArrayList2.add(locald);
        }
        else if ((locald.aRl.indexOf(paramString) > 0) || (locald.aRn.indexOf(paramString) > 0) || (locald.aRm.indexOf(paramString) > 0))
        {
          locald.aRf = locald.aRl;
          localArrayList3.add(locald);
        }
        else if ((locald.remark.indexOf(paramString) > 0) || (locald.aRk.indexOf(paramString) > 0) || (locald.aRj.indexOf(paramString) > 0))
        {
          locald.aRf = locald.remark;
          localArrayList3.add(locald);
        }
        else if ((locald.nickname.indexOf(paramString) > 0) || (locald.aRi.indexOf(paramString) > 0) || (locald.aRh.indexOf(paramString) > 0))
        {
          locald.aRf = locald.nickname;
          localArrayList3.add(locald);
        }
        else if (locald.memberUin.indexOf(paramString) > 0)
        {
          locald.aRf = locald.memberUin;
          localArrayList3.add(locald);
        }
      }
    }
    Collections.sort(localArrayList2, new b(null));
    this.mSearchResultList.addAll(localArrayList1);
    this.mSearchResultList.addAll(localArrayList2);
    this.mSearchResultList.addAll(localArrayList3);
    if (this.mSearchResultList.isEmpty()) {
      this.sq.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$a.notifyDataSetChanged();
      return;
      this.sq.setVisibility(8);
    }
  }
  
  protected void yi(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new TroopTransferActivity.13(this));
    }
    synchronized (this.N)
    {
      Integer localInteger2 = this.N;
      this.N = Integer.valueOf(this.N.intValue() - 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "finUpdateThread|[" + this.N + ", needUpdateUI = " + paramBoolean + "]");
      }
      return;
    }
  }
  
  class a
    extends abeg
  {
    private List<TroopTransferActivity.d> mList;
    
    public a()
    {
      super(TroopTransferActivity.this.app, TroopTransferActivity.this.o, 1, true);
      Object localObject;
      this.mList = localObject;
    }
    
    public int getCount()
    {
      if (this.mList == null) {
        return 0;
      }
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = TroopTransferActivity.this.getLayoutInflater().inflate(2131563067, paramViewGroup, false);
        paramView = new TroopTransferActivity.f(null);
        paramView.pQ = ((ImageView)localView.findViewById(2131369767));
        paramView.fe = ((TextView)localView.findViewById(2131380814));
        ((TextView)localView.findViewById(2131380940)).setText("");
        localView.setTag(paramView);
        localObject = (TroopTransferActivity.d)this.mList.get(paramInt);
        if ((TextUtils.isEmpty(((TroopTransferActivity.d)localObject).aRf)) || (((TroopTransferActivity.d)localObject).aRf.equals(((TroopTransferActivity.d)localObject).displayName))) {
          break label231;
        }
        paramView.fe.setText(((TroopTransferActivity.d)localObject).displayName + "(" + ((TroopTransferActivity.d)localObject).aRf + ")");
      }
      for (;;)
      {
        paramView.uin = ((TroopTransferActivity.d)localObject).memberUin;
        paramView.b = ((TroopTransferActivity.d)localObject);
        paramView.pQ.setImageBitmap(a(1, ((TroopTransferActivity.d)localObject).memberUin));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (TroopTransferActivity.f)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label231:
        paramView.fe.setText(((TroopTransferActivity.d)localObject).displayName);
      }
    }
  }
  
  class b
    implements Comparator<TroopTransferActivity.d>
  {
    private b() {}
    
    public int a(TroopTransferActivity.d paramd1, TroopTransferActivity.d paramd2)
    {
      return paramd1.aRg.compareToIgnoreCase(paramd2.aRg);
    }
  }
  
  class c
    implements TextWatcher
  {
    private c() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = TroopTransferActivity.this.ay.getText().toString().trim();
      TroopTransferActivity.this.vv(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static class d
  {
    public String aRf = "";
    public String aRg = "";
    public String aRh = "";
    public String aRi = "";
    public String aRj = "";
    public String aRk = "";
    public String aRl = "";
    public String aRm = "";
    public String aRn = "";
    public int bME;
    public int bMF;
    public String displayName = "";
    public String memberUin = "";
    public String nickname = "";
    public String pinyinAll = "";
    public String pinyinFirst = "";
    public String remark = "";
  }
  
  public class e
    extends abeg
  {
    protected LayoutInflater mLayoutInflater;
    protected ArrayList<TroopTransferActivity.d> mList;
    
    public e(ArrayList<String> paramArrayList)
    {
      super(TroopTransferActivity.this.app, TroopTransferActivity.this.listView, 1, true);
      this.mLayoutInflater = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
      this.mList = new ArrayList();
      TroopTransferActivity.d locald;
      int i;
      ArrayList localArrayList;
      int j;
      label71:
      Object localObject;
      if (locald == null)
      {
        i = 0;
        localArrayList = new ArrayList();
        paramArrayList = new ArrayList();
        j = 0;
        if (j >= i) {
          break label272;
        }
        localObject = (String)locald.get(j);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject))) {
          break label125;
        }
      }
      for (;;)
      {
        j += 1;
        break label71;
        i = locald.size();
        break;
        label125:
        int k = ((String)localObject).indexOf('|');
        String str = ((String)localObject).substring(0, k);
        k = Integer.parseInt(((String)localObject).substring(k + 1));
        if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
        {
          localObject = new TroopTransferActivity.d();
          ((TroopTransferActivity.d)localObject).bME = 1;
          ((TroopTransferActivity.d)localObject).memberUin = str;
          ((TroopTransferActivity.d)localObject).bMF = k;
          localArrayList.add(localObject);
        }
        else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
        {
          localObject = new TroopTransferActivity.d();
          ((TroopTransferActivity.d)localObject).bME = 1;
          ((TroopTransferActivity.d)localObject).memberUin = str;
          ((TroopTransferActivity.d)localObject).bMF = k;
          paramArrayList.add(localObject);
        }
      }
      label272:
      if (localArrayList.size() > 0)
      {
        locald = new TroopTransferActivity.d();
        locald.bME = 0;
        locald.bMF = 1;
        this.mList.add(0, locald);
        this.mList.addAll(localArrayList);
      }
      if (paramArrayList.size() > 0)
      {
        locald = new TroopTransferActivity.d();
        locald.bME = 0;
        locald.bMF = 0;
        this.mList.add(locald);
        this.mList.addAll(paramArrayList);
      }
      ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, TroopTransferActivity.this), 8, null, false);
    }
    
    public TroopTransferActivity.d a(String paramString)
    {
      Object localObject = null;
      int i = 0;
      if ((localObject == null) && (i < this.mList.size()))
      {
        TroopTransferActivity.d locald = (TroopTransferActivity.d)this.mList.get(i);
        if ((locald == null) || (!aqft.equalsWithNullCheck(locald.memberUin, paramString))) {
          break label61;
        }
        localObject = locald;
      }
      label61:
      for (;;)
      {
        i += 1;
        break;
        return localObject;
      }
    }
    
    public List<TroopTransferActivity.d> be()
    {
      return this.mList;
    }
    
    public int getCount()
    {
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.mList.size()) {
          localObject1 = (TroopTransferActivity.d)this.mList.get(paramInt);
        }
      }
      return localObject1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      TroopTransferActivity.d locald = (TroopTransferActivity.d)getItem(paramInt);
      if ((locald != null) && (locald.bME == 0)) {
        return 0;
      }
      if ((locald != null) && (locald.bME == 1)) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      TroopTransferActivity.d locald = (TroopTransferActivity.d)getItem(paramInt);
      Object localObject1;
      if (i == 0) {
        if (paramView == null)
        {
          localObject1 = this.mLayoutInflater.inflate(2131559496, paramViewGroup, false);
          paramView = new TroopTransferActivity.f(null);
          paramView.pQ = null;
          paramView.fe = ((TextView)localObject1);
          ((View)localObject1).setTag(paramView);
          paramView.b = locald;
          if ((locald == null) || (locald.bMF != 1)) {
            break label156;
          }
          paramView.fe.setText(2131695658);
        }
      }
      label281:
      label410:
      for (;;)
      {
        if ((paramView != null) && (paramView.fe != null)) {
          ((View)localObject1).setContentDescription(paramView.fe.getText());
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        Object localObject2 = (TroopTransferActivity.f)paramView.getTag();
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
        label156:
        if ((locald != null) && (locald.bMF == 0))
        {
          paramView.fe.setText(2131721332);
        }
        else
        {
          paramView.fe.setText("");
          continue;
          if (i == 1)
          {
            if (paramView == null)
            {
              paramView = this.mLayoutInflater.inflate(2131563267, paramViewGroup, false);
              paramView.findViewById(2131380551).setVisibility(8);
              paramView.findViewById(2131363898).setVisibility(8);
              localObject1 = new TroopTransferActivity.f(null);
              ((TroopTransferActivity.f)localObject1).pQ = ((ImageView)paramView.findViewById(2131369767));
              ((TroopTransferActivity.f)localObject1).fe = ((TextView)paramView.findViewById(2131380814));
              paramView.setTag(localObject1);
              ((TroopTransferActivity.f)localObject1).b = locald;
              if (locald == null) {
                break label376;
              }
              localObject2 = locald.memberUin;
              label300:
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("0"))) {
                break label382;
              }
              ((TroopTransferActivity.f)localObject1).pQ.setImageDrawable(aqhu.at());
              label329:
              if (locald == null) {
                break label410;
              }
            }
            for (localObject2 = locald.displayName;; localObject2 = "")
            {
              ((TroopTransferActivity.f)localObject1).fe.setText((CharSequence)localObject2);
              localObject2 = paramView;
              paramView = (View)localObject1;
              localObject1 = localObject2;
              break;
              localObject1 = (TroopTransferActivity.f)paramView.getTag();
              break label281;
              label376:
              localObject2 = null;
              break label300;
              label382:
              ((TroopTransferActivity.f)localObject1).uin = ((String)localObject2);
              ((TroopTransferActivity.f)localObject1).pQ.setImageBitmap(a(1, locald.memberUin));
              break label329;
            }
          }
          localObject2 = null;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
  
  static class f
    extends abeg.a
  {
    public TroopTransferActivity.d b;
    public TextView fe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */