package com.tencent.mobileqq.activity;

import accn;
import acfd;
import acmf;
import ajqp;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
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
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anxk;
import anxo;
import anxr;
import aqdj;
import aqgv;
import aqht;
import aqiw;
import arhz;
import ausj;
import ausj.a;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import ugp;
import ugq;
import ugr;
import ugs;
import ugt;
import ugu;
import ugv;
import ugw;

public class AssociatedAccountManageActivity
  extends SubAccountBaseActivity
  implements CompoundButton.OnCheckedChangeListener
{
  Dialog A;
  ausj P = null;
  ausj Q = null;
  private acmf jdField_a_of_type_Acmf = new ugw(this);
  private arhz jdField_a_of_type_Arhz;
  private a jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$a = new a();
  private c jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$c = new c();
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  private String aKz;
  public boolean aRA;
  public boolean aRw = true;
  public boolean aRy;
  private Toast jdField_b_of_type_AndroidWidgetToast;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new ugp(this);
  private View.OnClickListener cW = new ugs(this);
  private View.OnClickListener cX = new ugu(this);
  private accn cardObserver = new ugq(this);
  private View.OnClickListener dc = new ugt(this);
  public LinearLayout fP;
  public LinearLayout fQ;
  acfd g = new ugv(this);
  public List<SimpleAccount> qi;
  public List<SubAccountInfo> qj;
  public View ru;
  public View rv;
  private FormSwitchItem s;
  
  private View a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinearLayout localLinearLayout;
    if (paramInt == 0) {
      localLinearLayout = this.fQ;
    }
    for (;;)
    {
      if (localLinearLayout == null)
      {
        return null;
        if (paramInt == 1) {
          localLinearLayout = this.fP;
        }
      }
      else
      {
        int j = localLinearLayout.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = localLinearLayout.getChildAt(i);
          Object localObject = localView.getTag();
          if (paramInt == 0)
          {
            if ((localObject != null) && ((localObject instanceof SubAccountInfo)) && (paramString.equals(((SubAccountInfo)localObject).subuin))) {
              return localView;
            }
          }
          else if ((paramInt == 1) && (localObject != null) && ((localObject instanceof SimpleAccount)) && (paramString.equals(((SimpleAccount)localObject).getUin()))) {
            return localView;
          }
          i += 1;
        }
        return null;
      }
      localLinearLayout = null;
    }
  }
  
  private void aM(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.aKz, this.app.jm(this.aKz), new b(paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "am.deleteAccount " + this.aKz);
    }
    if (paramBoolean) {
      ajqp.ML(paramString);
    }
  }
  
  private void bFl()
  {
    this.fP.removeAllViews();
    if ((this.qi == null) || (this.qi.isEmpty()))
    {
      this.ru.setVisibility(8);
      return;
    }
    this.ru.setVisibility(0);
    int j = this.qi.size();
    int i = 0;
    while (i < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "bindAccountListView i=" + i + ", account=" + this.qi.get(i));
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)this.qi.get(i);
      if (localSimpleAccount == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2131563132, this.fP, false);
        if ((localView instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(false);
          if (i != j - 1) {
            break label267;
          }
          ((FormItemRelativeLayout)localView).setBGType(3);
        }
        for (;;)
        {
          ((FormItemRelativeLayout)localView).setNeedFocusBg(true);
          localView.setTag(localSimpleAccount);
          ((ImageView)localView.findViewById(2131368698)).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((RotateSwitchImageView)localView.findViewById(2131365700)).setOnClickListener(this.cW);
          ((Button)localView.findViewById(2131365671)).setOnClickListener(this.cX);
          this.fP.addView(localView);
          break;
          label267:
          ((FormItemRelativeLayout)localView).setBGType(2);
        }
      }
    }
    bFn();
  }
  
  private void bFn()
  {
    if ((this.fP == null) || (this.fP.getChildCount() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateAccountListView mAccountListView is null or size is 0.");
      }
      return;
    }
    int j = this.fP.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateAccountListView account size=" + j);
    }
    int i = 0;
    label75:
    View localView;
    Object localObject;
    if (i < j)
    {
      localView = this.fP.getChildAt(i);
      localObject = (SimpleAccount)localView.getTag();
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateAccountListView i=" + i + ", view tag=" + localObject);
      }
      if (localObject != null) {
        break label153;
      }
    }
    for (;;)
    {
      i += 1;
      break label75;
      break;
      label153:
      ImageView localImageView = (ImageView)localView.findViewById(2131368698);
      SingleLineTextView localSingleLineTextView = (SingleLineTextView)localView.findViewById(2131372190);
      String str = anxk.a(this.app, (SimpleAccount)localObject);
      localSingleLineTextView.setText(str);
      localObject = aqdj.a(this.app, ((SimpleAccount)localObject).getUin(), (byte)1);
      if ((localObject != null) && (localImageView != null)) {
        localImageView.setImageDrawable((Drawable)localObject);
      }
      if (AppSetting.enableTalkBack) {
        localView.setContentDescription(str);
      }
    }
  }
  
  private void bGe()
  {
    bGf();
    initAccountList();
    if (((this.qj == null) || (this.qj.size() == 0)) && ((this.qi == null) || (this.qi.size() == 0))) {
      onBackEvent();
    }
  }
  
  private void bGf()
  {
    StringBuilder localStringBuilder;
    if (this.qj == null)
    {
      this.qj = new ArrayList();
      localObject = (anxr)this.app.getManager(61);
      this.qj.addAll(((anxr)localObject).dL());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("initSubAccountList subaccountList=").append(this.qj).append(", size=");
        if (this.qj == null) {
          break label129;
        }
      }
    }
    label129:
    for (Object localObject = Integer.valueOf(this.qj.size());; localObject = "null")
    {
      QLog.i("AssociatedAccountManage", 2, localObject);
      bGg();
      return;
      this.qj.clear();
      break;
    }
  }
  
  private void bGg()
  {
    this.fQ.removeAllViews();
    if ((this.qj == null) || (this.qj.isEmpty()))
    {
      this.rv.setVisibility(8);
      return;
    }
    this.rv.setVisibility(0);
    int j = this.qj.size();
    int i = 0;
    if (i < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "bindSubAccountListView i=" + i + ", subaccount=" + this.qj.get(i));
      }
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)this.qj.get(i);
      if (localSubAccountInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        View localView = getLayoutInflater().inflate(2131563133, this.fQ, false);
        localView.setTag(localSubAccountInfo);
        localView.setBackgroundResource(2130839682);
        ((Button)localView.findViewById(2131381227)).setOnClickListener(this.dc);
        this.fQ.addView(localView);
      }
    }
    bGh();
  }
  
  private void bGh()
  {
    if ((this.fQ == null) || (this.fQ.getChildCount() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView mSubAccountListView is null or size is 0.");
      }
      return;
    }
    int j = this.fQ.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView subaccount size=" + j);
    }
    int i = 0;
    label75:
    View localView;
    SubAccountInfo localSubAccountInfo;
    if (i < j)
    {
      localView = this.fQ.getChildAt(i);
      localSubAccountInfo = (SubAccountInfo)this.qj.get(i);
      if (localSubAccountInfo != null) {
        break label117;
      }
    }
    label187:
    label335:
    label344:
    for (;;)
    {
      i += 1;
      break label75;
      break;
      label117:
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView i=" + i + ", view tag=" + localSubAccountInfo);
      }
      Object localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
      ImageView localImageView2;
      if (i > 0)
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131296609);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131368698);
        localImageView2 = (ImageView)localView.findViewById(2131368713);
        SingleLineTextView localSingleLineTextView = (SingleLineTextView)localView.findViewById(2131372190);
        Object localObject2 = aqgv.b(this.app, localSubAccountInfo.subuin, false);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localSubAccountInfo.subuin;
        }
        localSingleLineTextView.setText((CharSequence)localObject1);
        localObject2 = aqdj.a(this.app, localSubAccountInfo.subuin, (byte)1);
        if (localObject2 != null) {
          localImageView1.setImageDrawable((Drawable)localObject2);
        }
        if (localSubAccountInfo.status != 1) {
          break label335;
        }
        localImageView2.setBackgroundDrawable(null);
      }
      for (;;)
      {
        if (!AppSetting.enableTalkBack) {
          break label344;
        }
        localView.setContentDescription((CharSequence)localObject1);
        break;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        break label187;
        localImageView2.setBackgroundResource(2130851378);
      }
    }
  }
  
  private void bGi()
  {
    if ((this.qi != null) && (this.qi.size() > 0))
    {
      this.ru.setVisibility(0);
      this.fP.setVisibility(0);
      this.s.setVisibility(0);
      findViewById(2131365977).setVisibility(0);
      return;
    }
    this.s.setVisibility(8);
    findViewById(2131365977).setVisibility(8);
  }
  
  private void bGj()
  {
    try
    {
      if (this.A == null)
      {
        this.A = new ReportDialog(this, 2131756467);
        this.A.setContentView(2131558460);
        ((TextView)this.A.findViewById(2131365863)).setText(getString(2131692539));
        this.A.setCancelable(false);
      }
      this.A.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AssociatedAccountManage", 2, localException.toString());
    }
  }
  
  private View f(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131378161);
    }
    return null;
  }
  
  private View h(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131372190);
    }
    return null;
  }
  
  private void initAccountList()
  {
    Object localObject2;
    Object localObject1;
    label81:
    SimpleAccount localSimpleAccount;
    int i;
    if (this.qi == null)
    {
      this.qi = new ArrayList();
      if ((!this.aRw) || (this.aRy)) {
        break label237;
      }
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(getAppRuntime().getApplication().getAllAccounts());
      if (localObject2 == null) {
        break label237;
      }
      localObject1 = this.app.getAccount();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
          if ((localSimpleAccount != null) && (!((String)localObject1).equals(localSimpleAccount.getUin())))
          {
            int j = 0;
            i = j;
            if (this.qj != null)
            {
              i = j;
              if (this.qj.size() > 0)
              {
                Iterator localIterator = this.qj.iterator();
                i = 0;
                label158:
                if (localIterator.hasNext())
                {
                  SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
                  if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                    break label322;
                  }
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label315:
    label322:
    for (;;)
    {
      break label158;
      this.qi.clear();
      break;
      if (i != 0) {
        break label81;
      }
      this.qi.add(localSimpleAccount);
      break label81;
      label237:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList mAccountList=").append(this.qi).append(", size=");
        if (this.qi == null) {
          break label315;
        }
      }
      for (localObject1 = Integer.valueOf(this.qi.size());; localObject1 = "null")
      {
        QLog.i("AssociatedAccountManage", 2, localObject1);
        bFl();
        bGi();
        return;
      }
    }
  }
  
  private void vR(boolean paramBoolean)
  {
    this.s.setOnCheckedChangeListener(null);
    this.s.setChecked(paramBoolean);
    this.s.setOnCheckedChangeListener(this);
  }
  
  public void a(SubAccountInfo paramSubAccountInfo)
  {
    if (paramSubAccountInfo == null) {}
    do
    {
      return;
      this.Q = ((ausj)auss.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130969880);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.Q.addButton(arrayOfString[i], 3);
        i += 1;
      }
      this.Q.addCancelButton(2131721058);
      this.Q.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$c);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$c.c(paramSubAccountInfo);
      this.Q.setMainTitle(getString(2131721529));
    } while (this.Q.isShowing());
    this.Q.show();
  }
  
  void a(SimpleAccount paramSimpleAccount, boolean paramBoolean)
  {
    if (paramSimpleAccount == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "deleteAccount account == null");
      }
    }
    String str;
    do
    {
      return;
      bGj();
      str = paramSimpleAccount.getUin();
      this.aKz = str;
      if (!TextUtils.equals(str, this.app.getCurrentUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AssociatedAccountManage", 2, "deleteAccount error delete current uin");
    return;
    this.aRA = true;
    aM(this.aKz, paramBoolean);
    aqht.UE(str);
    this.qi.remove(paramSimpleAccount);
    GesturePWDUtils.clearGestureData(this, paramSimpleAccount.getUin());
    ThreadManager.post(new AssociatedAccountManageActivity.7(this, paramBoolean, str), 8, null, true);
  }
  
  void b(SubAccountInfo paramSubAccountInfo)
  {
    if ((paramSubAccountInfo == null) || (TextUtils.isEmpty(paramSubAccountInfo.subuin))) {}
    anxo localanxo;
    do
    {
      do
      {
        return;
      } while (!QN());
      this.aRA = true;
      yC(2131720616);
      localanxo = (anxo)this.app.getManager(28);
    } while (localanxo == null);
    localanxo.Rw(paramSubAccountInfo.subuin);
  }
  
  public void b(SimpleAccount paramSimpleAccount)
  {
    if (paramSimpleAccount == null) {}
    do
    {
      return;
      this.P = ((ausj)auss.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.P.addButton(arrayOfString[i], 1);
        i += 1;
      }
      this.P.addCancelButton(2131721058);
      this.P.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity$a.c(paramSimpleAccount);
      paramSimpleAccount = getString(2131691520).replace("${account}", paramSimpleAccount.getUin());
      this.P.setMainTitle(paramSimpleAccount);
    } while (this.P.isShowing());
    this.P.show();
  }
  
  public void bGk()
  {
    try
    {
      if ((this.A != null) && (this.A.isShowing())) {
        this.A.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AssociatedAccountManage", 2, localException.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563131);
    setContentBackgroundResource(2130838900);
    this.aRw = anxk.l(this.app, false);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.aRy = true;
    }
    initUI();
    bGf();
    initAccountList();
    addObserver(this.g);
    addObserver(this.cardObserver);
    addObserver(this.jdField_a_of_type_Acmf);
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "doOnDestroy");
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.g);
    removeObserver(this.cardObserver);
    removeObserver(this.jdField_a_of_type_Acmf);
    bGk();
    ath();
    super.doOnDestroy();
  }
  
  public void initUI()
  {
    setTitle(2131690530);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131721066);
    this.rightViewText.setOnClickListener(new ugr(this));
    this.ru = findViewById(2131361944);
    this.rv = findViewById(2131378933);
    this.fP = ((LinearLayout)findViewById(2131361877));
    this.fQ = ((LinearLayout)findViewById(2131378900));
    this.leftView.setText(2131691039);
    this.leftView.setVisibility(4);
    this.s = ((FormSwitchItem)findViewById(2131365976));
    vR(anxk.bH(this.app));
    if (AppSetting.enableTalkBack)
    {
      this.s.setContentDescription(getString(2131720551));
      this.leftView.setContentDescription(getString(2131691039));
      this.rightViewText.setContentDescription(getString(2131721066));
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.aRA) {
      setResult(-1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "onBackEvent, finish mChanged = " + this.aRA);
      }
      boolean bool = super.onBackEvent();
      overridePendingTransition(2130772002, 2130772013);
      return bool;
      setResult(0);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramCompoundButton == this.s.a())
    {
      if (!aqiw.isNetworkAvailable(this)) {
        break label58;
      }
      ((CardHandler)this.app.getBusinessHandler(2)).ED(paramBoolean);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(8193, 800L);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label58:
      Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(8195);
      localMessage.arg1 = 0;
      localMessage.arg2 = 2131693404;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      if (!paramBoolean) {
        bool = true;
      }
      vR(bool);
    }
  }
  
  void uO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  class a
    implements ausj.a
  {
    SimpleAccount mAccount;
    
    a() {}
    
    public void OnClick(View paramView, int paramInt)
    {
      if (AssociatedAccountManageActivity.this.P != null) {
        AssociatedAccountManageActivity.this.P.dismiss();
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        AssociatedAccountManageActivity.this.a(this.mAccount, false);
        return;
      }
      AssociatedAccountManageActivity.this.a(this.mAccount, true);
    }
    
    public void c(SimpleAccount paramSimpleAccount)
    {
      this.mAccount = paramSimpleAccount;
    }
  }
  
  class b
    extends AccountObserver
  {
    private String aKC;
    private boolean aQZ;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.aKC = paramString;
      this.aQZ = paramBoolean;
    }
    
    public void onDeleteAccount(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + paramBoolean + ",peerUin:" + this.aKC + ",isDeleteHistory:" + this.aQZ);
      }
      Object localObject = AssociatedAccountManageActivity.this;
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        localObject = ((AssociatedAccountManageActivity)localObject).getSharedPreferences("Last_Login", i);
        if ((paramBoolean) && (localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.aKC)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountManage", 2, "delete Last_Login");
          }
        }
        if ((paramBoolean) && (this.aQZ)) {
          AssociatedAccountManageActivity.this.uO(this.aKC);
        }
        return;
      }
    }
  }
  
  class c
    implements ausj.a
  {
    SubAccountInfo b;
    
    c() {}
    
    public void OnClick(View paramView, int paramInt)
    {
      if (AssociatedAccountManageActivity.this.Q != null) {
        AssociatedAccountManageActivity.this.Q.dismiss();
      }
      switch (paramInt)
      {
      default: 
        return;
      }
      AssociatedAccountManageActivity.this.b(this.b);
    }
    
    public void c(SubAccountInfo paramSubAccountInfo)
    {
      this.b = paramSubAccountInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity
 * JD-Core Version:    0.7.0.1
 */