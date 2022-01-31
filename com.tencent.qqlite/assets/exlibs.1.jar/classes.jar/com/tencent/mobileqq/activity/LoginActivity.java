package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import asw;
import asx;
import asz;
import atb;
import atc;
import atd;
import ate;
import atf;
import ath;
import ati;
import atk;
import atl;
import atm;
import atn;
import ato;
import atp;
import atq;
import atr;
import ats;
import att;
import atu;
import atv;
import atw;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class LoginActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, TextWatcher, View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1;
  private static LoginActivity jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
  public static final String a = "from_register_guide";
  public static final int b = 20140107;
  public static final String b = "jump_action_from_h5";
  public static final int c = 20140319;
  public static final String c = "package_from_h5";
  public static final int d = 20140325;
  static final String jdField_d_of_type_JavaLangString = "!@#ewaGbhkc$!!=";
  private static final boolean e = true;
  private static final String jdField_f_of_type_JavaLangString = "LoginActivity";
  private static final int jdField_g_of_type_Int = 0;
  private static final int h = 2;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  Handler jdField_a_of_type_AndroidOsHandler = new asw(this);
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ath(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atk(this);
  public View a;
  public AlphaAnimation a;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  public Button a;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ClearableEditText a;
  public DropdownView a;
  public InputMethodRelativeLayout a;
  public PadQQCheckBox a;
  public SimpleAccount a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public List a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new atf(this);
  boolean jdField_a_of_type_Boolean = false;
  public TextWatcher b;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  boolean jdField_b_of_type_Boolean = true;
  public View c;
  private Button jdField_c_of_type_AndroidWidgetButton;
  boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView = null;
  private boolean jdField_d_of_type_Boolean = true;
  public int e;
  public String e;
  public final int f;
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = false;
  
  public LoginActivity()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 2000;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    this.jdField_b_of_type_AndroidTextTextWatcher = new atm(this);
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131362916, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131362917, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin() == null)) {}
        while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(str))
        {
          i += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("userguide", 2, "login");
    }
    com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Long = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = true;
      try
      {
        showDialog(0);
        getAppRuntime().login(paramView, arrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    RecentDataListManager.a().a(paramQQAppInterface, paramQQAppInterface.a(), false);
    try
    {
      StatisticCollector.a(paramQQAppInterface.a()).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(paramQQAppInterface.getApplication().getApplicationContext(), paramString, true);
      paramQQAppInterface.saveLastAccountState();
      paramQQAppInterface.getApplication().refreAccountList();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("!@#ewaGbhkc$!!=");
          a(paramSimpleAccount.getUin());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_b_of_type_Boolean = true;
    if (bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramString);
      setResult(-1, (Intent)localObject);
      return true;
    }
    if (JumpActivity.jdField_a_of_type_Boolean)
    {
      setResult(-1);
      return true;
    }
    paramString = getIntent().getStringExtra("scheme_content");
    if (getIntent().getBooleanExtra("isActionSend", false))
    {
      setResult(-1);
      return true;
    }
    Object localObject = getIntent().getStringExtra("pkg_name");
    if ((paramString != null) && (paramString.length() > 0))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, paramString);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localJumpAction.b((String)localObject);
        localJumpAction.b();
        return true;
      }
      if (("h5".equalsIgnoreCase(localJumpAction.a("jump_from"))) && (localJumpAction.c()))
      {
        getIntent().putExtra("package_from_h5", "pakage_from_h5");
        getIntent().putExtra("jump_action_from_h5", paramString);
        e();
        return true;
      }
    }
    return false;
  }
  
  private void c(String paramString)
  {
    int i;
    if ((getIntent().getFlags() & 0x100000) != 0)
    {
      i = 1;
      if (!c()) {
        break label40;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        finish();
      }
      return;
      i = 0;
      break;
      label40:
      if (((i != 0) || (!a(paramString))) && (!d())) {
        if (getIntent().getParcelableExtra("shortcut_jump_key") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("shortcut_jump_key");
          paramString.setClass(this, ShortcutRouterActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getBooleanExtra("jump_shortcut_dataline", false))
        {
          paramString = new Intent();
          paramString.putExtras(getIntent().getExtras());
          paramString.setClass(this, qfileJumpActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qlink_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else
        {
          setResult(-1);
          if (!getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) {
            e();
          }
        }
      }
    }
  }
  
  private boolean c()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open")) || (((String)localObject).startsWith("mqqmdpass://wallet/modify_pass")) || (((String)localObject).startsWith("mqqapi://qqdataline/openqqdataline")) || (((String)localObject).startsWith("mqqapi://dating/"))))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private void d()
  {
    Object localObject = (ViewGroup)findViewById(2131296894);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131297145);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131296901);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private boolean d()
  {
    boolean bool = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(this, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity(localIntent);
      moveTaskToBack(true);
      finish();
    }
    return bool;
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (localBundle.containsKey("tab_index")) {
        localIntent.putExtra("tab_index", getIntent().getExtras().getInt("tab_index"));
      }
      if (localBundle.containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", getIntent().getExtras().getString("jump_action_from_h5"));
      }
      if (localBundle.containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", getIntent().getExtras().getString("package_from_h5"));
      }
    }
    startActivity(localIntent);
    overridePendingTransition(2130968615, 0);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return this.app.a(paramString, (byte)3, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new asz(this, paramString));
  }
  
  public boolean a()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    if (getIntent().getBooleanExtra("key_req_by_contact_sync", false))
    {
      if (bool2) {
        moveTaskToBack(true);
      }
      for (;;)
      {
        finish();
        return true;
        this.app.b(false);
      }
    }
    if ((bool1) || (bool2))
    {
      if (bool1) {
        setResult(-1);
      }
      finish();
      return true;
    }
    finish();
    this.app.b(false);
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_g_of_type_JavaLangString = null;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void b_()
  {
    super.b_();
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      w();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_g_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362900);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131362901);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362790);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new atn(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ato(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void c_()
  {
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.a()) == 21)) {
      w();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.doOnCreate(paramBundle);
    if (!getIntent().getBooleanExtra("from_register_guide", false))
    {
      paramBundle = getAppRuntime().getApplication().getAllAccounts();
      if ((paramBundle == null) || (paramBundle.isEmpty()))
      {
        paramBundle = new Intent(this, RegisterGuideActivity.class);
        paramBundle.addFlags(67108864);
        startActivity(paramBundle);
        overridePendingTransition(0, 0);
        finish();
      }
    }
    setContentView(2130903230);
    if (jdField_a_of_type_ComTencentMobileqqActivityLoginActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = this;
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297145);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131297284)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131362904));
    boolean bool = getIntent().getBooleanExtra("is_change_account", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131297285));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131362905));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297287));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131362906));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297289));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131362907));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131297280));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297282);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297281);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new atl(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(new atp(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296439));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131362908));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131297288));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131362898));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296901));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131297284));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    String str;
    int i;
    int j;
    label645:
    SimpleAccount localSimpleAccount;
    int m;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramBundle = getAppRuntime().getApplication().getAllAccounts();
      if (paramBundle != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramBundle);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1140;
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new atw(this, this));
      if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (!bool)) {
        break label786;
      }
      paramBundle = getIntent().getStringExtra("uin");
      str = getIntent().getStringExtra("befault_uin");
      if ((!bool) || (paramBundle == null) || (paramBundle.length() <= 0)) {
        break label1120;
      }
      i = 0;
      j = -1;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label770;
      }
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i);
      m = j;
      if (localSimpleAccount != null)
      {
        if (localSimpleAccount.getUin() != null) {
          break label714;
        }
        m = j;
      }
    }
    for (;;)
    {
      i += 1;
      j = m;
      break label645;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label714:
      int k = j;
      if (str != null)
      {
        k = j;
        if (str.equals(localSimpleAccount.getUin())) {
          k = i;
        }
      }
      m = k;
      if (paramBundle.equals(localSimpleAccount.getUin()))
      {
        a(localSimpleAccount);
        m = k;
      }
    }
    label770:
    if (j != -1) {
      this.jdField_a_of_type_JavaUtilList.remove(j);
    }
    label786:
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new atq(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new atr(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(false);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new ats(this));
    if (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      ((TextView)findViewById(2131296895)).setText(2131362920);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362920);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new att(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131297283);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTextClearedListener(new atv(this));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      if ((getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      d();
      if (getIntent().getBooleanExtra("reason_for_upgrade", false)) {
        showDialog(2);
      }
      if ((getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
      {
        ((TextView)findViewById(2131296895)).setText(2131364349);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(getIntent().getStringExtra("key_uin_to_login"));
      }
      return true;
      label1120:
      a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
      break;
      label1140:
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      break;
      if (bool)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new atu(this));
      }
      else
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = null;
    this.app.a(getClass());
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("userguide", 2, "fight....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    this.jdField_e_of_type_Int = paramBundle.getInt("position", -1);
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("main", 2, "onResume in LoginActivity");
    }
    if (this.app != null) {
      this.app.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putInt("position", this.jdField_e_of_type_Int);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.post(new asx(this));
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.app.a(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      String str = this.app.a();
      if (!this.jdField_e_of_type_JavaLangString.equalsIgnoreCase(str)) {
        SharedPreUtils.a(this.app.getApplication().getApplicationContext(), this.jdField_e_of_type_JavaLangString, true);
      }
    }
    if (PhoneNumLoginImpl.a().a()) {}
    do
    {
      return;
      a(this.app, this.app.getAccount());
      c(this.app.getAccount());
    } while (isFinishing());
    dismissDialog(0);
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_e_of_type_Int != -1)
    {
      paramDialogInterface = new QQProgressDialog(this, getTitleBarHeight());
      paramDialogInterface.d(true);
      paramDialogInterface.setContentView(2130903615);
      paramDialogInterface.b(2131363248);
      paramDialogInterface.show();
      atw localatw = (atw)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      String str1 = localatw.b(this.jdField_e_of_type_Int);
      String str2 = localatw.a(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Int = -1;
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (str2.equals(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString())))
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      }
      localatw.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_e_of_type_JavaLangString = null;
      }
      new Thread(new ati(this, str1, paramDialogInterface), "delete_account in login").start();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297287) {
      a(paramView);
    }
    while ((i != 2131297289) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    Intent localIntent = new Intent(this, RegisterPhoneNumActivity.class);
    localIntent.putExtra("key_register_now_account", paramView);
    startActivity(localIntent);
    this.jdField_f_of_type_Boolean = false;
    new Handler().postDelayed(new ate(this), 1000L);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return null;
        localObject = new QQProgressDialog(this);
        ((QQProgressDialog)localObject).a(getString(2131362910));
        return localObject;
      } while (!isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject = getLayoutInflater().inflate(2130903170, null);
      return DialogUtil.a(this, 230).setTitle(getString(2131362921)).setPositiveButton(2131362924, this).setNegativeButton(2131362929, new atb(this)).addView((View)localObject);
    }
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("StrTitle");
    String str2 = ((Intent)localObject).getStringExtra("StrUpgradeDesc");
    ((Intent)localObject).getStringExtra("StrUrl");
    localObject = DialogUtil.a(this, 230).setTitle(str1).setMessage(str2);
    ((QQCustomDialog)localObject).setPositiveButton("升级", new atc(this));
    ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131363149));
    ((QQCustomDialog)localObject).setNegativeButton("取消", new atd(this));
    return localObject;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131296764);
      String str = getString(2131362922);
      atw localatw = (atw)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_e_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", localatw.a(this.jdField_e_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131297001));
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (this.jdField_g_of_type_JavaLangString != null) && (this.jdField_g_of_type_JavaLangString.length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        this.app.getApplication().refreAccountList();
      }
      a(null);
      if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_g_of_type_JavaLangString.length() + 1))
        {
          this.app.getApplication().refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, this.jdField_g_of_type_JavaLangString.length()).equals(this.jdField_g_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_g_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(1);
    }
    this.jdField_g_of_type_JavaLangString = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */