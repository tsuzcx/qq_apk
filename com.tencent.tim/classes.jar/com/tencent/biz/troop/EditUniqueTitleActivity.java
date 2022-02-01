package com.tencent.biz.troop;

import acms;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import anot;
import aqha;
import aqju;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jnl;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import ske;
import skf;
import skg;
import skh;
import ski;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class EditUniqueTitleActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TextView As;
  protected TextView At;
  public ImageButton G;
  protected String aEs;
  public boolean aLS = true;
  public EditText ai;
  protected final int bxu = 6;
  protected int bxv;
  protected arhz g;
  protected int mFrom = 0;
  protected String mMemberUin;
  protected TextWatcher mTextWatcher = new skf(this);
  protected String mTroopUin;
  protected String mUniqueTitle;
  protected View qf;
  
  private void Q(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, gc=" + paramString1 + ", memberUin=" + paramString2 + ", from=" + this.mFrom);
    }
    if (paramString3.equals(this.mUniqueTitle))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, equals and return");
      }
      finish();
      return;
    }
    if (this.mFrom != 2) {
      atg();
    }
    a(this.app, paramString1, paramString2, paramString3, new ski(this));
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    paramContext = new Intent(paramContext, EditUniqueTitleActivity.class);
    paramContext.putExtra("from", String.valueOf(paramInt1));
    paramContext.putExtra("memberUin", paramString2);
    paramContext.putExtra("troopUin", paramString1);
    paramContext.putExtra("memberRole", paramInt2);
    paramContext.putExtra("uniqueTitle", paramString3);
    return paramContext;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
      Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
      Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
      try
      {
        localObject = ((TroopManager)localObject).aM(paramString1, paramString2);
        localReqBody.uint64_group_code.set(Long.parseLong(paramString1));
        localMemberInfo.uint64_uin.set(Long.parseLong(paramString2));
        localMemberInfo.bytes_uin_name.set(ByteStringMicro.copyFromUtf8((String)localObject));
        if (paramString3 != null) {
          localMemberInfo.bytes_special_title.set(ByteStringMicro.copyFromUtf8(paramString3));
        }
        localMemberInfo.uint32_special_title_expire_time.set(-1);
        localReqBody.rpt_mem_level_info.add(localMemberInfo);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(2300);
        paramString1.uint32_service_type.set(2);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramString2 = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
        paramString2.putExtra("cmd", "OidbSvc.0x8fc_2");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(paramBusinessObserver);
        paramQQAppInterface.startServlet(paramString2);
        return;
      }
      catch (NumberFormatException paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("EditUniqueTitleActivity", 2, "setUniqueTitle exp", paramQQAppInterface);
  }
  
  private void bcH()
  {
    this.As.setTextColor(getResources().getColorStateList(2131167385));
    this.As.setText("0/6");
    if (TextUtils.isEmpty(this.mUniqueTitle)) {
      if (this.bxv == 2) {
        this.ai.setText(getString(2131695658));
      }
    }
    for (;;)
    {
      this.ai.setSelection(this.ai.length());
      return;
      if (this.bxv == 3)
      {
        this.ai.setText(getString(2131721449));
        continue;
        this.ai.setText(this.mUniqueTitle);
      }
    }
  }
  
  private void bzi()
  {
    String str = this.ai.getEditableText().toString();
    this.aEs = str;
    switch (this.bxv)
    {
    default: 
      return;
    case 2: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131695658))))
      {
        Q(this.mTroopUin, this.mMemberUin, this.aEs);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.mUniqueTitle != null) && (this.mUniqueTitle.equals(getString(2131695658)))) || ((TextUtils.isEmpty(this.mUniqueTitle)) && (str != null) && (str.equals(getString(2131695658)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.mUniqueTitle)) && (str.equals(getString(2131695658))) && (this.mUniqueTitle.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.mUniqueTitle))))
      {
        finish();
        return;
      }
      this.aEs = "";
      Q(this.mTroopUin, this.mMemberUin, this.aEs);
      return;
    case 3: 
      if ((!TextUtils.isEmpty(str)) && (!str.equals(getString(2131721449))))
      {
        Q(this.mTroopUin, this.mMemberUin, this.aEs);
        return;
      }
      if (((TextUtils.isEmpty(str)) && (this.mUniqueTitle != null) && (this.mUniqueTitle.equals(getString(2131721449)))) || ((TextUtils.isEmpty(this.mUniqueTitle)) && (str != null) && (str.equals(getString(2131721449)))) || ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.mUniqueTitle)) && (str.equals(getString(2131721449))) && (this.mUniqueTitle.equals(str))) || ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.mUniqueTitle))))
      {
        finish();
        return;
      }
      this.aEs = "";
      Q(this.mTroopUin, this.mMemberUin, this.aEs);
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      Q(this.mTroopUin, this.mMemberUin, this.aEs);
      return;
    }
    if (TextUtils.isEmpty(this.mUniqueTitle))
    {
      finish();
      return;
    }
    this.aEs = "";
    Q(this.mTroopUin, this.mMemberUin, this.aEs);
  }
  
  private boolean init()
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.mFrom = Integer.parseInt(localIntent.getStringExtra("from"));
        this.mMemberUin = localIntent.getStringExtra("memberUin");
        this.mTroopUin = localIntent.getStringExtra("troopUin");
        this.bxv = localIntent.getIntExtra("memberRole", 1);
        this.mUniqueTitle = localIntent.getStringExtra("uniqueTitle");
        if (this.mFrom == 2)
        {
          anot.a(this.app, "P_CliOper", "Grp_manage", "", "grp_aio", "Clk_expire", 0, 0, this.mTroopUin, "", "", "");
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return false;
  }
  
  private void yA(int paramInt)
  {
    if (this.mFrom != 2) {
      ath();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "onSetUniqueTitle, errCode=" + paramInt);
    }
    if (paramInt == 0)
    {
      Object localObject = (TroopManager)this.app.getManager(52);
      ((TroopManager)localObject).F(this.mTroopUin, this.mMemberUin, false);
      ((TroopManager)localObject).o(this.mTroopUin, this.mMemberUin, this.aEs, -1);
      if (this.mFrom == 2) {
        QQToast.a(this, getResources().getString(2131698539), 1).show();
      }
      localObject = getIntent();
      ((Intent)localObject).putExtra("newUniqueTitle", this.aEs);
      setResult(-1, (Intent)localObject);
      finish();
      ((acms)this.app.getBusinessHandler(20)).notifyUI(64, true, new Object[] { this.mTroopUin, this.mMemberUin, this.aEs });
      return;
    }
    if (this.mFrom == 2)
    {
      setResult(0, getIntent());
      finish();
      QQToast.a(this, getResources().getString(2131698540), 1).show();
      return;
    }
    if (paramInt == 1281)
    {
      QQToast.a(this, getResources().getString(2131698537), 1).show();
      return;
    }
    QQToast.a(this, getResources().getString(2131698541), 1).show();
  }
  
  public void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(this, getTitleBarHeight());
        this.g.setMessage(2131696693);
        this.g.setBackAndSearchFilter(false);
      }
      this.g.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  public void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing())) {
        this.g.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("EditUniqueTitleActivity", 2, localException.toString());
    }
  }
  
  protected void bzh()
  {
    anot.a(this.app, "dc00899", "Grp_title", "", "grp_data", "clk_finish", 0, 0, "", "", "", "");
    String str = this.ai.getEditableText().toString();
    if ((!TextUtils.isEmpty(this.mUniqueTitle)) && (TextUtils.isEmpty(str)))
    {
      aqha.a(this, getString(2131698377), 2131721058, 2131698376, new skg(this), new skh(this)).show();
      return;
    }
    bzi();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!init())
    {
      finish();
      return false;
    }
    super.setContentView(2131560787);
    setTitle(2131698426);
    setLeftButton(2131721058, new ske(this));
    this.ai = ((EditText)findViewById(2131366225));
    this.G = ((ImageButton)findViewById(2131364659));
    this.As = ((TextView)findViewById(2131366244));
    this.At = ((TextView)findViewById(2131381466));
    this.ai.addTextChangedListener(this.mTextWatcher);
    this.G.setOnClickListener(this);
    this.aLS = "1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setRightHighlightButton(2131721066, this);
    if (!this.aLS) {
      this.rightViewText.setAlpha(0.5F);
    }
    this.qf = findViewById(2131377195);
    this.qf.setOnClickListener(this);
    this.qf.setVisibility(8);
    if (this.bxv == 2)
    {
      paramBundle = getString(2131695658);
      if ((!TextUtils.isEmpty(this.mUniqueTitle)) && (!paramBundle.equals(this.mUniqueTitle)))
      {
        this.qf.setVisibility(0);
        anot.a(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.mTroopUin, "", "", "");
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00899", "Grp_title", "", "grp_data", "edit_exp", 0, 0, "", "", "", "");
      bcH();
      return false;
      if (this.bxv == 3)
      {
        paramBundle = getString(2131721449);
        if ((!TextUtils.isEmpty(this.mUniqueTitle)) && (!paramBundle.equals(this.mUniqueTitle)))
        {
          this.qf.setVisibility(0);
          anot.a(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "exp_default", 0, 0, this.mTroopUin, "", "", "");
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
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
      this.ai.setText("");
      continue;
      bzh();
      continue;
      this.aEs = "";
      Q(this.mTroopUin, this.mMemberUin, this.aEs);
      anot.a(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "suc_title", 0, 0, this.mTroopUin, "0", "0", "0");
      anot.a(this.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_default", 0, 0, this.mTroopUin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity
 * JD-Core Version:    0.7.0.1
 */