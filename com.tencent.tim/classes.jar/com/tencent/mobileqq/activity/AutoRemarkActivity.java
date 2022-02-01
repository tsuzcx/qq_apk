package com.tencent.mobileqq.activity;

import acbs;
import acfd;
import acff;
import acfp;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqdj;
import aqft;
import aqha;
import aqiw;
import avfw;
import avfw.d;
import avpw;
import avpw.d;
import azcl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import uhz;
import uia;
import uib;
import wja;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  TextView BJ = null;
  private TextView Cp;
  private TextView Cq;
  Bundle Y;
  private a jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$a = new a(null);
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  String aLx;
  boolean aSb = false;
  EditText as = null;
  private ViewTreeObserver.OnGlobalLayoutListener b = new uib(this);
  int bDA = 0;
  int bDB;
  private RelativeLayout gm;
  int mMode;
  int mRetryCount;
  private ImageView po;
  private View rp;
  private View rw;
  private View rx;
  private View ry;
  private Switch y;
  public Dialog z;
  private Switch z;
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "startAutoRemarkActivity, " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("k_msg_key", paramLong);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    while ((paramInt1 == 100) && (!paramBoolean)) {
      return true;
    }
    return false;
  }
  
  public static int bC(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  private void bGC()
  {
    ThreadManager.getSubThreadHandler().post(new AutoRemarkActivity.3(this));
  }
  
  public static String e(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).a(paramInt + "");
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.group_name;
    }
    return "";
  }
  
  public static boolean fU(int paramInt)
  {
    return (azcl.oD(paramInt)) || (paramInt == 3016) || (paramInt == 3003) || (paramInt == 3093);
  }
  
  public static String hb(String paramString)
  {
    while (bC(paramString) > 32)
    {
      int i = paramString.length();
      if ((i >= 2) && (Character.isHighSurrogate(paramString.charAt(i - 2)))) {
        paramString = paramString.substring(0, i - 2);
      } else {
        paramString = paramString.substring(0, i - 1);
      }
    }
    return paramString;
  }
  
  public static boolean i(int paramInt, String paramString)
  {
    return (!azcl.oD(paramInt)) && (paramInt != 3016) && (paramInt != 3024) && (!TextUtils.isEmpty(paramString)) && (paramInt != 3093) && (!paramString.equals(String.valueOf(0L)));
  }
  
  private void initUI(int paramInt)
  {
    Object localObject1;
    label163:
    String str;
    label236:
    label368:
    Object localObject2;
    if (this.mMode == 0)
    {
      localObject1 = getString(2131695966);
      setTitle((CharSequence)localObject1);
      this.rw = findViewById(2131377468);
      this.rx = findViewById(2131377427);
      this.as = ((EditText)findViewById(2131366540));
      this.BJ = ((TextView)findViewById(2131380745));
      this.BJ.setText(e(this.app, this.bDA));
      this.rx.setContentDescription(acfp.m(2131702969) + e(this.app, this.bDA));
      this.as.addTextChangedListener(this);
      this.rx.setOnClickListener(this);
      if (!aqft.rj(this.aLx)) {
        break label778;
      }
      this.rw.setVisibility(8);
      str = "";
      if (!fU(this.bDB)) {
        break label789;
      }
      str = getIntent().getStringExtra("nick_name");
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        QLog.d("AutoRemarkActivity", 2, "initUI remark = " + str + ", source id=" + this.bDB);
        localObject1 = str;
      }
      this.as.setText((CharSequence)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.as.setSelection(((String)localObject1).length());
      }
      if ((!azcl.oD(this.bDB)) && (this.bDB != 3016)) {
        break label821;
      }
      paramInt = 1;
      label284:
      if (paramInt == 0)
      {
        this.rp = findViewById(2131376250);
        this.rp.setVisibility(0);
        findViewById(2131376252).setVisibility(0);
        this.y = ((Switch)findViewById(2131376251));
        this.y.setOnCheckedChangeListener(this);
      }
      if (this.mMode != 0) {
        break label826;
      }
      setRightHighlightButton(2131719505, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
      this.gm = ((RelativeLayout)findViewById(2131377394));
      this.po = ((ImageView)findViewById(2131373517));
      this.Cp = ((TextView)findViewById(2131372384));
      this.Cq = ((TextView)findViewById(2131381503));
      if (this.Y == null) {
        break label1010;
      }
      this.gm.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.rw.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = wja.dp2px(0.0F, getResources());
      this.rw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.Y.getString("base_uin");
      str = this.Y.getString("base_nick");
      this.Y.getInt("verfy_type");
      localObject2 = this.Y.getString("verfy_msg");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label969;
      }
      localObject2 = (LinearLayout.LayoutParams)this.Cp.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).topMargin = wja.dp2px(15.0F, getResources());
      this.Cp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label559:
      this.po.setImageDrawable(aqdj.a(this.app, 1, (String)localObject1));
      this.Cp.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363711));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new uhz(this));
      if (AppSetting.enableTalkBack)
      {
        this.leftView.setContentDescription(acfp.m(2131702968) + this.leftView.getText().toString() + acfp.m(2131702971));
        this.rw.setFocusable(true);
        this.rw.setContentDescription(getResources().getString(2131694937) + this.as.getText().toString());
        this.as.setContentDescription(null);
        if (paramInt == 0)
        {
          this.rp.setFocusable(true);
          this.rp.setContentDescription(getResources().getString(2131718001));
          findViewById(2131376252).setFocusable(true);
        }
      }
      return;
      localObject1 = acfp.m(2131702973);
      break;
      label778:
      this.rw.setVisibility(0);
      break label163;
      label789:
      localObject1 = str;
      if (this.Y == null) {
        break label236;
      }
      localObject1 = str;
      if (!this.aSb) {
        break label236;
      }
      localObject1 = this.Y.getString("base_nick");
      break label236;
      label821:
      paramInt = 0;
      break label284;
      label826:
      setRightHighlightButton(2131721066, this);
      enableRightHighlight(true);
      setLeftButton(2131721058, this);
      if (this.mMode != 1) {
        break label368;
      }
      this.ry = findViewById(2131378089);
      this.ry.setVisibility(0);
      localObject1 = (TextView)findViewById(2131376252);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131719557);
      ((TextView)localObject1).setContentDescription(getString(2131719557));
      this.jdField_z_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131378114));
      if (AppSetting.enableTalkBack)
      {
        this.ry.setContentDescription(acfp.m(2131702972));
        this.ry.setFocusable(true);
      }
      this.jdField_z_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.leftView.setVisibility(8);
      break label368;
      label969:
      this.Cq.setText(getString(2131689928) + ": " + (String)localObject2);
      break label559;
      label1010:
      this.gm.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.rw.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = wja.dp2px(10.0F, getResources());
      this.rw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  private void uU(String paramString)
  {
    if ((this.jdField_z_of_type_AndroidAppDialog != null) && (this.jdField_z_of_type_AndroidAppDialog.isShowing()) && (this.jdField_z_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_z_of_type_AndroidAppDialog.dismiss();
      label34:
      this.jdField_z_of_type_AndroidAppDialog = aqha.a(this, paramString, 0, 2131721079, null, new uia(this));
      try
      {
        this.jdField_z_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.as.getText().toString();
    if (bC(paramEditable) > 32)
    {
      int i = this.as.getSelectionStart();
      paramEditable = hb(paramEditable);
      this.as.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.as.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.enableTalkBack) {
      this.rw.setContentDescription(getResources().getString(2131694937) + this.as.getText().toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.bDA = paramInt1;
      this.BJ.setText(e(this.app, paramInt1));
    } while (!AppSetting.enableTalkBack);
    this.rx.setContentDescription(acfp.m(2131702970) + e(this.app, paramInt1));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558761);
    setContentBackgroundResource(2130838900);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    Intent localIntent = getIntent();
    this.mMode = localIntent.getIntExtra("param_mode", 0);
    this.aLx = localIntent.getStringExtra("uin");
    this.bDB = getIntent().getIntExtra("source_id", 3999);
    this.Y = localIntent.getExtras();
    this.aSb = this.Y.getBoolean("isFromWzry", false);
    initUI(this.bDB);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$a);
    if ((paramBundle == null) || (this.mMode == 1))
    {
      if ((aqiw.isNetSupport(this)) && (i(this.bDB, this.aLx))) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ac(this.aLx, this.bDB, getIntent().getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.b);
    }
    bGC();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_z_of_type_AndroidAppDialog != null) && (this.jdField_z_of_type_AndroidAppDialog.isShowing()) && (this.jdField_z_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_z_of_type_AndroidAppDialog.dismiss();
      label34:
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.b);
      }
      for (;;)
      {
        super.doOnDestroy();
        this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAutoRemarkActivity$a);
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.b);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  void goBack()
  {
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null)
    {
      try
      {
        localObject = Class.forName((String)localObject);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.tim", ((Class)localObject).getName()));
        if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class))) {
          ProfileActivity.b(this, this.aLx, localIntent2);
        }
        for (;;)
        {
          localIntent2.setFlags(67108864);
          localIntent2.putExtra("key_back_from_add_friend", true);
          startActivity(localIntent2);
          return;
          if (localObject.equals(NearbyPeopleProfileActivity.class))
          {
            localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.aLx, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        if (!getIntent().getBooleanExtra("from_newer_guide", false)) {
          break label257;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    else
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.aLx);
      setResult(-1, localIntent1);
    }
    for (;;)
    {
      finish();
      return;
      label257:
      setResult(-1);
    }
  }
  
  public boolean onBackEvent()
  {
    setResult(-1);
    finish();
    overridePendingTransition(2130772002, 2130772369);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this.app.getApp(), 1, getString(2131696348), 0).show(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      Object localObject;
      if (paramCompoundButton == this.jdField_z_of_type_ComTencentWidgetSwitch)
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.aLx);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((short)1, (List)localObject, paramBoolean);
        if (this.jdField_z_of_type_ComTencentWidgetSwitch.isChecked()) {
          anot.a(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        if ((this.app.aT(true)) && (paramBoolean) && (this.y != null)) {
          this.y.setChecked(true);
        }
      }
      else if (paramCompoundButton == this.y)
      {
        if (AppSetting.enableTalkBack) {
          this.rp.setContentDescription(getResources().getString(2131718001));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.aLx);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        avfw.d locald = new avfw.d(0);
        locald.mPluginName = "QQ空间";
        locald.mPluginID = QzonePluginProxyActivity.Gg();
        locald.mUin = this.app.getCurrentAccountUin();
        locald.cKu = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        locald.mIntent = ((Intent)localObject);
        avfw.b(this.app.getApp(), locald);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      setResult(-1);
      finish();
      overridePendingTransition(2130772002, 2130772369);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.aLx).putExtra("mgid", (byte)this.bDA);
      ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult((Intent)localObject, 1001);
      continue;
      localObject = avpw.d.a();
      ((avpw.d)localObject).cMP = this.app.getCurrentAccountUin();
      ((avpw.d)localObject).nickname = this.app.getCurrentNickname();
      avpw.a(this, (avpw.d)localObject, Long.valueOf(this.aLx).longValue(), -1);
      continue;
      if (!aqiw.isNetSupport(this))
      {
        QQToast.a(this.app.getApp(), 1, getString(2131696348), 0).show(getTitleBarHeight());
      }
      else
      {
        j(2131719519, 1000L, true);
        if (this.mMode == 0)
        {
          localObject = getIntent();
          int k = ((Intent)localObject).getIntExtra("sub_source_id", 0);
          int j = ((Intent)localObject).getIntExtra("friend_setting", 0);
          int i = j;
          if (j == 3) {
            i = 100;
          }
          boolean bool = ((Intent)localObject).getBooleanExtra("contact_bothway", false);
          String str = ((Intent)localObject).getStringExtra("src_name");
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.aLx, ((Intent)localObject).getStringExtra("extra"), i, (byte)this.bDA, ((Intent)localObject).getStringExtra("msg"), this.bDB, k, true, ((Intent)localObject).getByteArrayExtra("sig"), bool, this.as.getText().toString(), str, ((Intent)localObject).getByteExtra("show_my_card", (byte)0), "", ((Intent)localObject).getBundleExtra("flc_extra_param"));
          if (!a(i, this.bDB, bool)) {
            ((acff)this.app.getManager(51)).bF(this.aLx, true);
          }
        }
        else if (this.mMode == 1)
        {
          j(2131719519, 1000L, true);
          this.mRetryCount = 0;
          localObject = this.as.getText().toString().trim();
          if (((String)localObject).length() != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.C(this.aLx, (String)localObject, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.aLx, (byte)this.bDA, (byte)0);
          }
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  class a
    extends acfd
  {
    private a() {}
    
    public void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
    {
      if (!TextUtils.equals(AutoRemarkActivity.this.aLx, paramString1)) {
        return;
      }
      if (paramBoolean)
      {
        if ((!AutoRemarkActivity.fU(AutoRemarkActivity.this.bDB)) && (!AutoRemarkActivity.this.aSb))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + paramString2);
          }
          AutoRemarkActivity.this.as.setText(paramString2);
        }
        try
        {
          AutoRemarkActivity.this.as.setSelection(AutoRemarkActivity.this.as.getText().length());
          if (AppSetting.enableTalkBack) {
            AutoRemarkActivity.a(AutoRemarkActivity.this).setContentDescription(AutoRemarkActivity.this.getResources().getString(2131694937) + AutoRemarkActivity.this.as.getText().toString());
          }
          AutoRemarkActivity.this.bDA = paramInt;
          AutoRemarkActivity.this.BJ.setText(AutoRemarkActivity.e(AutoRemarkActivity.this.app, AutoRemarkActivity.this.bDA));
          return;
        }
        catch (IndexOutOfBoundsException paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
            }
          }
        }
      }
      AutoRemarkActivity.this.bDA = 0;
      AutoRemarkActivity.this.BJ.setText(AutoRemarkActivity.e(AutoRemarkActivity.this.app, AutoRemarkActivity.this.bDA));
    }
    
    public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
    {
      if ((AutoRemarkActivity.this.mMode == 1) && (TextUtils.equals(paramString1, AutoRemarkActivity.this.aLx)))
      {
        AutoRemarkActivity.this.getIntent().getLongExtra("k_msg_key", 0L);
        if ((paramBoolean) && (aqiw.isNetSupport(AutoRemarkActivity.this)))
        {
          AutoRemarkActivity.this.mRetryCount = 0;
          AutoRemarkActivity.this.aLx = paramString1;
          AutoRemarkActivity.this.a.b(AutoRemarkActivity.this.aLx, (byte)AutoRemarkActivity.this.bDA, (byte)0);
        }
      }
      else
      {
        return;
      }
      if ((AutoRemarkActivity.this.mRetryCount == 2) || (!aqiw.isNetSupport(AutoRemarkActivity.this)))
      {
        AutoRemarkActivity.f(AutoRemarkActivity.this);
        AutoRemarkActivity.a(AutoRemarkActivity.this, AutoRemarkActivity.this.getString(2131718832));
        return;
      }
      paramString2 = AutoRemarkActivity.this;
      paramString2.mRetryCount += 1;
      AutoRemarkActivity.this.a.C(paramString1, AutoRemarkActivity.this.as.getText().toString(), false);
    }
    
    public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
    {
      if (!TextUtils.equals(paramString, AutoRemarkActivity.this.aLx)) {}
      do
      {
        return;
        if (paramBoolean1)
        {
          if (paramBundle.getInt("resultCode") == 0)
          {
            int i = paramBundle.getInt("friend_setting");
            if (paramBundle.getString("nick_name") == null) {}
            switch (i)
            {
            default: 
              AutoRemarkActivity.c(AutoRemarkActivity.this);
              QQToast.a(AutoRemarkActivity.this, 2, 2131719506, 0).show(AutoRemarkActivity.this.getTitleBarHeight());
              AutoRemarkActivity.this.goBack();
            }
            for (;;)
            {
              ((acbs)AutoRemarkActivity.this.app.getBusinessHandler(53)).de(AutoRemarkActivity.this.getIntent());
              return;
              AutoRemarkActivity.a(AutoRemarkActivity.this);
              QQToast.a(AutoRemarkActivity.this, 2, 2131689767, 0).show(AutoRemarkActivity.this.getTitleBarHeight());
              AutoRemarkActivity.this.goBack();
              continue;
              AutoRemarkActivity.b(AutoRemarkActivity.this);
              QQToast.a(AutoRemarkActivity.this, 2, 2131719506, 0).show(AutoRemarkActivity.this.getTitleBarHeight());
              AutoRemarkActivity.this.goBack();
            }
          }
          AutoRemarkActivity.d(AutoRemarkActivity.this);
          paramBundle = paramBundle.getString("ErrorString");
          if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + paramBundle);
          }
          paramString = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            paramString = AutoRemarkActivity.this.getString(2131718832);
          }
          AutoRemarkActivity.a(AutoRemarkActivity.this, paramString);
          return;
        }
        AutoRemarkActivity.e(AutoRemarkActivity.this);
        AutoRemarkActivity.a(AutoRemarkActivity.this, AutoRemarkActivity.this.getString(2131718832));
      } while (!QLog.isColorLevel());
      QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
    }
    
    public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
    {
      if (AutoRemarkActivity.this.mMode == 1)
      {
        if (paramString != null) {
          break label40;
        }
        AutoRemarkActivity.g(AutoRemarkActivity.this);
        AutoRemarkActivity.a(AutoRemarkActivity.this, AutoRemarkActivity.this.getString(2131718832));
      }
      label40:
      while (!paramString.equals(AutoRemarkActivity.this.aLx)) {
        return;
      }
      AutoRemarkActivity.this.setResult(-1);
      AutoRemarkActivity.this.finish();
      AutoRemarkActivity.this.overridePendingTransition(2130772002, 2130772369);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */