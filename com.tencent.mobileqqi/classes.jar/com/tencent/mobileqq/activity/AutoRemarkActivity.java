package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bwg;
import bwh;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AutoRemarkActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final String a = "AutoRemarkActivity";
  public static final int b = 1;
  public static final String b = "param_mode";
  private static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 2;
  public static final String c = "param_return_addr";
  static final int d = 0;
  public static final String d = "key_back_from_add_friend";
  public static final String e = "result_extra_direct_succeeded";
  private static final int i = 1000;
  private static final int j = 1001;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  private bwh jdField_a_of_type_Bwh = new bwh(this, null);
  public FriendListHandler a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new bwg(this);
  public QQProgressDialog a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  private RelativeLayout c;
  int e;
  public int f;
  public String f;
  public int g;
  String g;
  int h;
  
  public AutoRemarkActivity()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  private static int a(String paramString)
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
  
  public static String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int k = paramString.length();
      if ((k >= 2) && (Character.isHighSurrogate(paramString.charAt(k - 2)))) {
        paramString = paramString.substring(0, k - 2);
      } else {
        paramString = paramString.substring(0, k - 1);
      }
    }
    return paramString;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = FriendSystemMsgController.a().b();
    structmsg.StructMsg localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    int k;
    long l2;
    int m;
    int n;
    int i1;
    int i2;
    Object localObject;
    int i3;
    String str;
    if (localStructMsg != null)
    {
      k = localStructMsg.msg_type.get();
      l1 = localStructMsg.msg_seq.get();
      l2 = localStructMsg.req_uin.get();
      m = localStructMsg.msg.sub_type.get();
      n = localStructMsg.msg.src_id.get();
      i1 = localStructMsg.msg.sub_src_id.get();
      i2 = localStructMsg.msg.group_msg_type.get();
      localObject = localStructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          i3 = this.jdField_f_of_type_Int;
          str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (str != null) {
            break label255;
          }
          str = "";
        }
      }
    }
    label255:
    for (;;)
    {
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set(str);
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(i3);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(k, l1, l2, m, n, i1, i2, (structmsg.SystemMsgActionInfo)localObject, paramInt, localStructMsg);
      bool1 = true;
      return bool1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {}
    while ((paramInt1 == 100) && (!paramBoolean)) {
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    return (!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.equals(String.valueOf(0L)));
  }
  
  private void d()
  {
    int k;
    label97:
    String str;
    if (this.e == 0)
    {
      k = 2131562139;
      setTitle(k);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231148));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231152));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231151));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231150));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231154));
      if (this.e != 0) {
        break label486;
      }
      k = 2131562857;
      b(k, this);
      LocaleString.a(a(this.jdField_f_of_type_Int), this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!f()) {
        break label507;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label493;
      }
      str = getIntent().getStringExtra("friend_mobile_name");
      label175:
      if (QLog.isColorLevel()) {
        QLog.d("AutoRemarkActivity", 2, "initUI remark = " + str + ", source id=" + this.h);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      }
    }
    for (;;)
    {
      d(true);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.c = ((RelativeLayout)findViewById(2131231156));
        this.c.setVisibility(0);
        findViewById(2131231158).setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131231157));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      this.k.setContentDescription("返回" + this.k.getText().toString() + "界面");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getResources().getString(2131562433) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(null);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.c.setFocusable(true);
        this.c.setContentDescription(getResources().getString(2131562283) + "关闭");
        findViewById(2131231158).setFocusable(true);
      }
      return;
      k = 2131561597;
      break;
      label486:
      k = 2131561977;
      break label97;
      label493:
      str = getIntent().getStringExtra("nick_name");
      break label175;
      label507:
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  private void e()
  {
    this.e = getIntent().getIntExtra("param_mode", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("k_add_friend_by_mobile", false);
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.g = getIntent().getStringExtra("friend_mobile_number");
  }
  
  private void f()
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562875);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      Object localObject = getIntent();
      int m = ((Intent)localObject).getIntExtra("friend_setting", 0);
      int k = m;
      if (m == 3) {
        k = 100;
      }
      m = ((Intent)localObject).getIntExtra("source_id", 10004);
      boolean bool = ((Intent)localObject).getBooleanExtra("contact_bothway", false);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, k, ((Intent)localObject).getBooleanExtra("allow_flag", true), (byte)this.jdField_f_of_type_Int, ((Intent)localObject).getStringExtra("msg"), m, ((Intent)localObject).getIntExtra("sub_source_id", 0), this.g, (byte)1, ((Intent)localObject).getByteArrayExtra("sig"), ((Intent)localObject).getStringExtra("troop_uin"), bool, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      if (!a(k, m, bool)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label191;
        }
      }
      label191:
      for (localObject = this.g;; localObject = this.jdField_f_of_type_JavaLangString)
      {
        ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a((String)localObject, true);
        return;
      }
    }
    QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, getString(2131562488), 0).b(d());
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Boolean) || (this.h == 3003);
  }
  
  private void g()
  {
    if (NetworkUtil.e(this))
    {
      if (a(0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562875);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, getString(2131562488), 0).b(d());
  }
  
  private void h()
  {
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562875);
      Intent localIntent = getIntent();
      long l1 = localIntent.getLongExtra("lToMobile", 0L);
      byte[] arrayOfByte = localIntent.getByteArrayExtra("sig");
      String str = localIntent.getStringExtra("nick_name");
      long l2 = localIntent.getLongExtra("infotime", 0L);
      long l3 = localIntent.getLongExtra("db_id", 0L);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(0, Long.parseLong(this.jdField_f_of_type_JavaLangString), l1, arrayOfByte, (byte)this.jdField_f_of_type_Int, str, l2, l3);
      return;
    }
    QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, getString(2131562488), 0).b(d());
  }
  
  public String a(int paramInt)
  {
    Groups localGroups = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AutoRemarkActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null) {
      try
      {
        localObject = Class.forName((String)localObject);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.tencent.mobileqqi", ((Class)localObject).getName()));
        localIntent.setFlags(67108864);
        localIntent.putExtra("key_back_from_add_friend", true);
        startActivity(localIntent);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = " + Log.getStackTraceString(localClassNotFoundException));
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    setResult(-1);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramEditable.length() == 0) {}
    for (int k = 4;; k = 0)
    {
      localImageView.setVisibility(k);
      if (a(paramEditable) > 32)
      {
        k = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        paramEditable = a(paramEditable);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
        if (k >= paramEditable.length()) {
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
        }
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getResources().getString(2131562433) + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1000: 
      paramIntent = paramIntent.getStringExtra("result");
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramIntent);
      return;
    }
    this.jdField_f_of_type_Int = paramIntent.getByteExtra("result", (byte)0);
    LocaleString.a(a(this.jdField_f_of_type_Int), this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.h = getIntent().getIntExtra("source_id", 10004);
    setContentView(2130903095);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    e();
    d();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Bwh);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    if (((paramBundle == null) || (this.e == 1)) && (NetworkUtil.e(this)) && (c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_f_of_type_JavaLangString, getIntent().getIntExtra("source_id", 10004), getIntent().getIntExtra("sub_source_id", 0));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562411);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Bwh);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, getString(2131562488), 0).b(d());
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        return;
      }
    }
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder().append(getResources().getString(2131562283));
    if (paramBoolean) {}
    for (paramCompoundButton = getResources().getString(2131559032);; paramCompoundButton = getResources().getString(2131559033))
    {
      ((RelativeLayout)localObject).setContentDescription(paramCompoundButton);
      paramCompoundButton = new Intent("com.tencent.qzone.action.OperateQZonePermission");
      paramCompoundButton.putExtra("qzone_permission_uin", this.jdField_f_of_type_JavaLangString);
      paramCompoundButton.putExtra("qzone_permission_operateType", 1);
      paramCompoundButton.putExtra("qzone_permission_value", paramBoolean);
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).d = getResources().getString(2131559031);
      ((IPluginManager.PluginParams)localObject).b = QzonePluginProxyActivity.a();
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((IPluginManager.PluginParams)localObject).e = "com.qzone.permissionsetting.business.QZonePermissionReciver";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramCompoundButton;
      IPluginManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), (IPluginManager.PluginParams)localObject);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetRelativeLayout)
    {
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131562429).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("hint", getResources().getString(2131562022)).putExtra("multiLine", false);
      if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)) {
        paramView.putExtra("current", this.jdField_a_of_type_AndroidWidgetEditText.getText());
      }
      startActivityForResult(paramView, 1000);
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout)
      {
        paramView = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.jdField_f_of_type_JavaLangString).putExtra("mgid", (byte)this.jdField_f_of_type_Int);
        paramView.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
        startActivityForResult(paramView, 1001);
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        return;
      }
      if (paramView == this.c)
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramView.b = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
        paramView.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue(), -1);
        return;
      }
      if (this.e == 0)
      {
        f();
        return;
      }
      if (this.e == 1)
      {
        g();
        return;
      }
    } while (this.e != 2);
    h();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */