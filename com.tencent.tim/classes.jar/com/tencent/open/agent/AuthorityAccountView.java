package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import aqha;
import aqju;
import aroo;
import arop;
import aroq;
import aror;
import aros;
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
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import wja;

public class AuthorityAccountView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView Gb;
  private View JM;
  private View JN;
  private a jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$a;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  public WtloginManager a;
  protected SharedPreferences ac;
  protected TextView acC;
  private TextView acD;
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
  
  public AuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      QLog.d("AuthorityAccountView", 2, "--> getMaxListHeight maxHeight = " + f1);
    }
    return (int)f1;
  }
  
  private void ekH()
  {
    ImageView localImageView = (ImageView)this.JM.findViewById(2131363098);
    localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new arop(this, localImageView));
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
    this.JM = LayoutInflater.from(this.mContext).inflate(2131559865, null);
    ((LinearLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this.mContext, 37.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = aqcx.dip2px(this.mContext, 37.0F);
    addView(this.JM, (ViewGroup.LayoutParams)localObject);
    this.Gb = ((ImageView)this.JM.findViewById(2131361908));
    this.acD = ((TextView)this.JM.findViewById(2131361881));
    this.acC = ((TextView)this.JM.findViewById(2131361893));
    int i = wja.dp2px(10.0F, getResources());
    wja.i(this.acC, i, i, i, i);
    this.acC.setOnClickListener(this);
    this.JN = LayoutInflater.from(this.mContext).inflate(2131559866, null);
    this.mC = ((RelativeLayout)this.JN.findViewById(2131363101));
    if ((this.mContext instanceof AuthorityActivity)) {
      this.mC.setOnClickListener((AuthorityActivity)this.mContext);
    }
    for (;;)
    {
      this.n = ((BounceScrollView)this.JN.findViewById(2131361916));
      i = Nc();
      this.n.setMaxHeight(i);
      this.lF = ((LinearLayout)this.JN.findViewById(2131361878));
      this.ar = ((ausj)auss.a(getContext(), null));
      this.ar.setActionContentView(this.JN, null);
      localObject = this.ar.getRootView();
      if ((localObject instanceof DispatchActionMoveScrollView)) {
        ((DispatchActionMoveScrollView)localObject).cZW = true;
      }
      localObject = this.ar.getActionContentView();
      ((RelativeLayout)localObject).addOnLayoutChangeListener(new aroo(this, (RelativeLayout)localObject));
      this.lE = new LinearLayout(this.mContext);
      this.lE.setOrientation(1);
      this.lF.addView(this.lE);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityAccountView", 2, "--> AuthorityAccountView initUI");
      }
      ekK();
      ekL();
      ekH();
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
      StringBuilder localStringBuilder = new StringBuilder("updateLoginAccount() uin=");
      localStringBuilder.append(paramString).append(",nick=").append((String)localObject);
      if (this.JM != null)
      {
        ImageView localImageView = (ImageView)this.JM.findViewById(2131363098);
        TextView localTextView = (TextView)this.JM.findViewById(2131363099);
        localObject = arwx.h((String)localObject, 12, true);
        localTextView.setText((CharSequence)localObject);
        f(paramString, localImageView);
        localStringBuilder.append(",dealStr=").append((String)localObject);
      }
      QLog.i("AuthorityAccountView", 1, localStringBuilder.toString());
      return;
    }
  }
  
  public void WL(String paramString)
  {
    QLog.i("AuthorityAccountView", 1, "show delete account = " + paramString);
    this.x = aqha.a(this.mContext, 230);
    this.x.setContentView(2131559127);
    this.x.setTitle(getResources().getString(2131700725));
    this.x.setMessageTextSize(18.0F);
    this.x.setMessage(paramString + "?");
    paramString = new aros(this, paramString);
    this.x.setNegativeButton(2131691518, paramString);
    this.x.setPositiveButton(2131691519, paramString);
    this.x.show();
  }
  
  protected void deleteAccount(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, "-->deleteAccount--account to delete is " + paramString);
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
          QLog.d("AuthorityAccountView", 2, "-->deleteAccount--account to delete equals last account, clear last account");
        }
        this.c.remove("last_account").commit();
      }
      long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
      paramString = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri("" + l));
    } while (paramString.exists());
    paramString.delete();
  }
  
  public void ekI()
  {
    this.acC.setVisibility(8);
  }
  
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
    if (this.accountList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("-->initOrUpdateAccountList:");
      int i = 0;
      while (i < this.accountList.size())
      {
        localStringBuilder.append(" 第").append(i).append("帐号:").append((String)this.accountList.get(i));
        i += 1;
      }
      QLog.i("AuthorityAccountView", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("AuthorityAccountView", 1, "-->initOrUpdateAccountList account list = null");
  }
  
  public void ekL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, "-->updateDropDownViews");
    }
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
        ((ImageView)localObject2).setOnClickListener(new aroq(this));
        f(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new aror(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this.mContext, 72.0F));
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        this.lE.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i += 1;
      }
    }
  }
  
  protected void f(String paramString, ImageView paramImageView)
  {
    QLog.d("AuthorityAccountView", 1, "-->updateAccountFace uin=" + artw.qx(paramString));
    ThreadManager.executeOnSubThread(new AuthorityAccountView.5(this, paramString, paramImageView));
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
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$a != null) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$a.ekM();
      }
      if (!this.dcz)
      {
        ekL();
        this.dcz = true;
      }
      this.ar.show();
    }
  }
  
  public void setAppInfo(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = arwx.h(paramString, 12, true);
      this.acD.setText(paramString);
    }
    if (paramBitmap != null)
    {
      QLog.i("AuthorityAccountView", 1, "setAppInfo appIcon=" + paramBitmap);
      this.Gb.setImageBitmap(paramBitmap);
    }
  }
  
  public void setAppType(String paramString)
  {
    TextView localTextView;
    String str;
    if (this.JM != null)
    {
      localTextView = (TextView)this.JM.findViewById(2131361879);
      str = this.mContext.getResources().getString(2131696626);
      if (!"web".equals(paramString)) {
        break label91;
      }
      str = this.mContext.getResources().getString(2131696627);
    }
    for (;;)
    {
      localTextView.setText(str);
      QLog.i("AuthorityAccountView", 1, "setAppType=" + str);
      return;
      label91:
      if ("android".equals(paramString)) {
        str = this.mContext.getResources().getString(2131696626);
      }
    }
  }
  
  public void setChangeAccountListener(a parama)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$a = parama;
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
      AuthorityAccountView.this.deleteAccount(this.mAccount);
      Object localObject = ((TextView)AuthorityAccountView.a(AuthorityAccountView.this).findViewById(2131361947)).getText().toString();
      if ((localObject != null) && (((String)localObject).equals(this.mAccount)))
      {
        if (AuthorityAccountView.this.accountList.size() != 1) {
          break label246;
        }
        if ((AuthorityAccountView.a(AuthorityAccountView.this) == null) || (!(AuthorityAccountView.a(AuthorityAccountView.this) instanceof AuthorityActivity))) {
          break label192;
        }
        localObject = new Intent(AuthorityAccountView.a(AuthorityAccountView.this), Login.class);
        ((Intent)localObject).putExtra("key_req_src", 1);
        ((Intent)localObject).putExtra("is_first_login", true);
        ((AuthorityActivity)AuthorityAccountView.a(AuthorityAccountView.this)).aIE = null;
        ((AuthorityActivity)AuthorityAccountView.a(AuthorityAccountView.this)).startActivityForResult((Intent)localObject, 1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityAccountView", 2, "--> after delete account");
        }
        AuthorityAccountView.this.ekK();
        ((BaseActivity)AuthorityAccountView.a(AuthorityAccountView.this)).runOnUiThread(new AuthorityAccountView.DelAccountRunnable.2(this));
        return;
        label192:
        if ((AuthorityAccountView.a(AuthorityAccountView.this) != null) && ((AuthorityAccountView.a(AuthorityAccountView.this) instanceof QuickLoginAuthorityActivity)))
        {
          ((QuickLoginAuthorityActivity)AuthorityAccountView.a(AuthorityAccountView.this)).aIE = null;
          ((QuickLoginAuthorityActivity)AuthorityAccountView.a(AuthorityAccountView.this)).WO(null);
        }
      }
      label246:
      int i = 0;
      label248:
      if (i < AuthorityAccountView.this.accountList.size())
      {
        localObject = (String)AuthorityAccountView.this.accountList.get(i);
        if (this.mAccount.equals(localObject)) {}
      }
      for (;;)
      {
        ((BaseActivity)AuthorityAccountView.a(AuthorityAccountView.this)).runOnUiThread(new AuthorityAccountView.DelAccountRunnable.1(this, (String)localObject));
        break;
        i += 1;
        break label248;
        localObject = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ekM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */