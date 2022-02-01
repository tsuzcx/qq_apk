package com.tencent.open.agent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import aqha;
import aqju;
import arqz;
import arra;
import arrb;
import arrc;
import arrd;
import artw;
import arwx;
import aryn;
import asaw;
import ausj;
import auss;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class OpenAuthorityAccountView
  extends LinearLayout
  implements View.OnClickListener
{
  private View JM;
  private View JN;
  private View JZ;
  private OpenCardContainer.a jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$a;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  public WtloginManager a;
  protected SharedPreferences ac;
  protected ArrayList<String> accountList;
  private ausj ar;
  protected SharedPreferences.Editor c;
  boolean dcz = false;
  protected float density;
  private float jG;
  private LinearLayout lE;
  private LinearLayout lF;
  private RelativeLayout mC;
  private Context mContext;
  private BounceScrollView n;
  private float of;
  public aqju x;
  
  public OpenAuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initData();
    initUI();
  }
  
  private int Nc()
  {
    float f1 = aqcx.dip2px(this.mContext, 72.0F);
    float f2 = (int)(2.0D * this.jG / 3.0D / f1) - 2;
    f1 = f1 / 2.0F + f2 * f1;
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityAccountView", 2, "--> getMaxListHeight maxHeight = " + f1);
    }
    return (int)f1;
  }
  
  private void initData()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)((BaseActivity)this.mContext).getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.ac = this.mContext.getSharedPreferences("accountList", 0);
    this.c = this.ac.edit();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
      aryn.WE(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
    }
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.of = localDisplayMetrics.widthPixels;
    this.jG = localDisplayMetrics.heightPixels;
    this.density = getResources().getDisplayMetrics().density;
  }
  
  private void initUI()
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.JM = LayoutInflater.from(this.mContext).inflate(2131559867, null);
    addView(this.JM, (ViewGroup.LayoutParams)localObject);
    this.JN = LayoutInflater.from(this.mContext).inflate(2131559866, null);
    this.mC = ((RelativeLayout)this.JN.findViewById(2131363101));
    if ((this.mContext instanceof PublicFragmentActivityForOpenSDK)) {
      this.mC.setOnClickListener(new arqz(this));
    }
    for (;;)
    {
      this.n = ((BounceScrollView)this.JN.findViewById(2131361916));
      int i = Nc();
      this.n.setMaxHeight(i);
      this.lF = ((LinearLayout)this.JN.findViewById(2131361878));
      this.ar = ((ausj)auss.a(getContext(), null));
      this.ar.setActionContentView(this.JN, null);
      localObject = this.ar.getRootView();
      if ((localObject instanceof DispatchActionMoveScrollView)) {
        ((DispatchActionMoveScrollView)localObject).cZW = true;
      }
      localObject = this.ar.getActionContentView();
      ((RelativeLayout)localObject).addOnLayoutChangeListener(new arra(this, (RelativeLayout)localObject));
      this.lE = new LinearLayout(this.mContext);
      this.lE.setOrientation(1);
      this.lF.addView(this.lE);
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityAccountView", 2, "--> AuthorityAccountView initUI");
      }
      ekK();
      ekL();
      this.JZ = findViewById(2131377946);
      return;
      if ((this.mContext instanceof QuickLoginAuthorityActivity)) {
        this.mC.setOnClickListener((QuickLoginAuthorityActivity)this.mContext);
      }
    }
  }
  
  public void WK(String paramString)
  {
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    localObject = new String(((WloginSimpleInfo)localObject)._nick);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = paramString;
    }
    for (;;)
    {
      if (this.JM != null)
      {
        ImageView localImageView = (ImageView)this.JM.findViewById(2131363098);
        ((TextView)this.JM.findViewById(2131363099)).setText(arwx.h((String)localObject, 12, true));
        f(paramString, localImageView);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityAccountView", 2, "当前帐号：" + paramString);
      }
      return;
    }
  }
  
  public void WL(String paramString)
  {
    this.x = aqha.a(this.mContext, 230);
    this.x.setContentView(2131559127);
    this.x.setTitle(getResources().getString(2131700725));
    this.x.setMessageTextSize(18.0F);
    this.x.setMessage(paramString + "?");
    paramString = new arrd(this, paramString);
    this.x.setNegativeButton(2131691518, paramString);
    this.x.setPositiveButton(2131691519, paramString);
    this.x.show();
  }
  
  protected void deleteAccount(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityAccountView", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    aryn.WF(paramString);
    if (this.ac == null) {}
    do
    {
      return;
      if (this.ac.getString("accList", null) != null) {
        localObject1 = this.ac.getString("accList", null).split(",");
      }
      Object localObject2 = new ArrayList();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (((ArrayList)localObject2).contains(paramString))
      {
        ((ArrayList)localObject2).remove(paramString);
        localObject2 = ((ArrayList)localObject2).iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + str) {
          str = (String)((Iterator)localObject2).next();
        }
        this.c.putString("accList", (String)localObject1);
        this.c.commit();
      }
      if (paramString.equals(this.ac.getString("last_account", "")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenAuthorityAccountView", 2, "-->deleteAccount--account to delete equals last account, clear last account");
        }
        this.c.remove("last_account").commit();
      }
      long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
      paramString = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri("" + l));
    } while (paramString.exists());
    paramString.delete();
  }
  
  public void ekI() {}
  
  public void ekJ()
  {
    if ((this.ar != null) && (this.ar.isShowing())) {
      this.ar.dismiss();
    }
  }
  
  public void ekK()
  {
    asaw.a().emz();
    this.accountList = aryn.eh();
    if (QLog.isColorLevel())
    {
      if (this.accountList != null)
      {
        QLog.d("OpenAuthorityAccountView", 2, "-->initOrUpdateAccountList");
        int i = 0;
        while (i < this.accountList.size())
        {
          QLog.d("OpenAuthorityAccountView", 2, " 第" + i + "帐号: " + (String)this.accountList.get(i));
          i += 1;
        }
      }
      QLog.d("OpenAuthorityAccountView", 2, "-->initOrUpdateAccountList account list = null");
    }
  }
  
  protected void ekL()
  {
    QLog.d("OpenAuthorityAccountView", 1, "-->updateDropDownViews");
    this.lE.removeAllViews();
    if ((this.accountList == null) || (this.accountList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.accountList.size())
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559864, null);
        localRelativeLayout.setBackgroundResource(2130842747);
        String str = (String)this.accountList.get(i);
        ((TextView)localRelativeLayout.findViewById(2131361947)).setText(str);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131361920);
        localTextView.setMaxWidth((int)(3.0F * this.of / 5.0F));
        Object localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localRelativeLayout.findViewById(2131361910);
        ((ImageView)localRelativeLayout.findViewById(2131369486)).setVisibility(8);
        localObject2 = (ImageView)localRelativeLayout.findViewById(2131369426);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130846280);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new arrb(this));
        f(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new arrc(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 72.0F));
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        this.lE.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i += 1;
      }
    }
  }
  
  public void eli()
  {
    if (!this.dcz)
    {
      ekL();
      this.dcz = true;
    }
    this.ar.show();
  }
  
  protected void f(String paramString, ImageView paramImageView)
  {
    QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace uin = " + artw.qx(paramString));
    ThreadManager.executeOnSubThread(new OpenAuthorityAccountView.5(this, paramString, paramImageView));
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
      eli();
    }
  }
  
  public void setAccountEventListener(OpenCardContainer.a parama)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$a = parama;
  }
  
  public void setMainAccountSelect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.JZ.setVisibility(0);
      return;
    }
    this.JZ.setVisibility(8);
  }
  
  public class DelAccountRunnable
    implements Runnable
  {
    private String mAccount;
    
    public DelAccountRunnable(String paramString)
    {
      this.mAccount = paramString;
    }
    
    public void run()
    {
      OpenAuthorityAccountView.this.deleteAccount(this.mAccount);
      String str = ((TextView)OpenAuthorityAccountView.a(OpenAuthorityAccountView.this).findViewById(2131361947)).getText().toString();
      if ((str != null) && (str.equals(this.mAccount)))
      {
        if (OpenAuthorityAccountView.this.accountList.size() != 1) {
          break label206;
        }
        if ((OpenAuthorityAccountView.a(OpenAuthorityAccountView.this) == null) || (!(OpenAuthorityAccountView.a(OpenAuthorityAccountView.this) instanceof PublicFragmentActivityForOpenSDK))) {
          break label152;
        }
        if (OpenAuthorityAccountView.a(OpenAuthorityAccountView.this) != null) {
          OpenAuthorityAccountView.a(OpenAuthorityAccountView.this).elp();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenAuthorityAccountView", 2, "--> after delete account");
        }
        OpenAuthorityAccountView.this.ekK();
        ((BaseActivity)OpenAuthorityAccountView.a(OpenAuthorityAccountView.this)).runOnUiThread(new OpenAuthorityAccountView.DelAccountRunnable.2(this));
        return;
        label152:
        if ((OpenAuthorityAccountView.a(OpenAuthorityAccountView.this) != null) && ((OpenAuthorityAccountView.a(OpenAuthorityAccountView.this) instanceof QuickLoginAuthorityActivity)))
        {
          ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(OpenAuthorityAccountView.this)).aIE = null;
          ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(OpenAuthorityAccountView.this)).WO(null);
        }
      }
      label206:
      int i = 0;
      label208:
      if (i < OpenAuthorityAccountView.this.accountList.size())
      {
        str = (String)OpenAuthorityAccountView.this.accountList.get(i);
        if (this.mAccount.equals(str)) {}
      }
      for (;;)
      {
        ((BaseActivity)OpenAuthorityAccountView.a(OpenAuthorityAccountView.this)).runOnUiThread(new OpenAuthorityAccountView.DelAccountRunnable.1(this, str));
        break;
        i += 1;
        break label208;
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */