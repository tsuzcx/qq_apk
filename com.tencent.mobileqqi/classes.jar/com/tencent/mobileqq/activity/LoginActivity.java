package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
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
import com.tencent.mobileqq.activity.language.SelectLanguageActivity;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
import com.tencent.util.EUCountryUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cyu;
import cyv;
import cyw;
import cyx;
import cyz;
import czb;
import czc;
import czd;
import cze;
import czf;
import czg;
import czi;
import czj;
import czk;
import czm;
import czn;
import czo;
import czp;
import czq;
import czr;
import czs;
import czt;
import czu;
import czv;
import czw;
import czx;
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
  static final String jdField_a_of_type_JavaLangString = "!@#ewaGbhkc$!!=";
  public static final int b = 14825;
  public static final int c = 14826;
  private static final String jdField_c_of_type_JavaLangString = "LoginActivity";
  public static final int d = 14827;
  private static final boolean jdField_d_of_type_Boolean = true;
  private static final int g = 0;
  private static final int h = 2;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  Handler jdField_a_of_type_AndroidOsHandler = new cyu(this);
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new czj(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new czm(this);
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
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new czg(this);
  boolean jdField_a_of_type_Boolean = false;
  public TextWatcher b;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  public String b;
  boolean jdField_b_of_type_Boolean = true;
  public View c;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView = null;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private String jdField_d_of_type_JavaLangString = null;
  public int e;
  private String jdField_e_of_type_JavaLangString = null;
  private boolean jdField_e_of_type_Boolean = true;
  public final int f;
  private boolean f;
  
  public LoginActivity()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 2000;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    this.jdField_b_of_type_AndroidTextTextWatcher = new czn(this);
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void a(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.t())
    {
      paramButton.setText(getString(2131562838));
      return;
    }
    paramButton.setText(getString(2131562314));
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
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(paramSimpleAccount.getUin()));
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
    Object localObject = getIntent().getStringExtra("scheme_content");
    if (getIntent().getBooleanExtra("isActionSend", false))
    {
      setResult(-1);
      return true;
    }
    paramString = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && (paramString != null) && (((String)localObject).length() > 0) && (paramString.length() > 0))
    {
      localObject = JumpParser.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, (String)localObject);
      ((JumpAction)localObject).b(paramString);
      if (("share".equals(((JumpAction)localObject).bg)) && ("to_qzone".equals(((JumpAction)localObject).bh))) {
        this.jdField_b_of_type_Boolean = false;
      }
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private boolean b(Intent paramIntent)
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
  
  private void c(String paramString)
  {
    if (c()) {}
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        finish();
      }
      return;
      if ((!a(paramString)) && (!d())) {
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
        else
        {
          setResult(-1);
          if (!getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) {
            f();
          }
        }
      }
    }
  }
  
  private boolean c()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open"))))
    {
      localObject = JumpParser.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private void d()
  {
    Object localObject = (ViewGroup)findViewById(2131231448);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = findViewById(2131231374);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
    }
    localObject = (TextView)findViewById(2131231456);
    if (localObject != null) {
      IphoneTitleBarActivity.b((View)localObject);
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
    try
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.containsKey("tab_index"))) {
      localIntent.putExtra("tab_index", getIntent().getExtras().getInt("tab_index"));
    }
    startActivity(localIntent);
    overridePendingTransition(2130968617, 0);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a().post(new cyz(this, paramString));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_d_of_type_JavaLangString = null;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public boolean b()
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
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k();
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k();
    return true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131561791);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562940);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new czo(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new czp(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void c_()
  {
    super.c_();
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (GesturePWDUtils.getGesturePWDState(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 21)) {
      B();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!PrivacyDeclareHelper.a(this, paramInt1, paramInt2)) {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2130903272);
    if (jdField_a_of_type_ComTencentMobileqqActivityLoginActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = this;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131231374);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131230735)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131562626));
    boolean bool = getIntent().getBooleanExtra("is_change_account", false);
    if (getIntent().getBooleanExtra("isFbLogin", false))
    {
      paramBundle = DialogUtil.a(this, 230).setTitle(null).setMessage(getString(2131563349));
      paramBundle.setPositiveButton(getString(2131563363), new czi(this));
      paramBundle.setNegativeButton(getString(2131561842), new czq(this));
      paramBundle.show();
      getIntent().putExtra("isFbLogin", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131231905));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131562028));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231907));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562315));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131231909));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131562461));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131231900));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setBackgroundResource(2130838104);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131231902);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131231901);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new czr(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(new czs(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131230985));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562669));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131231908));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131562126));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131230735));
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
      this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
          break label1240;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new czx(this, this));
        if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (!bool)) {
          break label848;
        }
        paramBundle = getIntent().getStringExtra("uin");
        str = getIntent().getStringExtra("befault_uin");
        if ((!bool) || (paramBundle == null) || (paramBundle.length() <= 0)) {
          break label1220;
        }
        i = 0;
        for (j = -1;; j = m)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label832;
          }
          localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i);
          m = j;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break;
            }
            m = j;
          }
          i += 1;
        }
      }
    }
    catch (Exception paramBundle)
    {
      int j;
      for (;;)
      {
        String str;
        int i;
        SimpleAccount localSimpleAccount;
        if (QLog.isColorLevel()) {
          paramBundle.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setBackgroundResource(2131361863);
        continue;
        this.jdField_a_of_type_JavaUtilList.clear();
        continue;
        int k = j;
        if (str != null)
        {
          k = j;
          if (str.equals(localSimpleAccount.getUin())) {
            k = i;
          }
        }
        int m = k;
        if (paramBundle.equals(localSimpleAccount.getUin()))
        {
          a(localSimpleAccount);
          m = k;
        }
      }
      label832:
      if (j != -1) {
        this.jdField_a_of_type_JavaUtilList.remove(j);
      }
    }
    label848:
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131231903));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new czt(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new czu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(false);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new czv(this));
    if (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false))
    {
      findViewById(2131231376).setVisibility(0);
      ((TextView)findViewById(2131231376)).setText(2131561593);
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561692);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new czw(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131231904);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTextClearedListener(new cyw(this));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      if ((getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      d();
      if (getIntent().getBooleanExtra("reason_for_upgrade", false)) {
        showDialog(2);
      }
      if ((getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
      {
        ((TextView)findViewById(2131231376)).setText(2131562317);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(getIntent().getStringExtra("key_uin_to_login"));
      }
      this.jdField_e_of_type_JavaLangString = null;
      return true;
      label1220:
      a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
      break;
      label1240:
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      break;
      if (bool)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(4);
        findViewById(2131231376).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561692);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new cyv(this));
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    b(paramIntent);
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
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
    boolean bool = getIntent().getBooleanExtra("is_change_account", false);
    if (getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false))
    {
      e();
      g(getString(2131561593));
      return;
    }
    if (bool)
    {
      e();
      return;
    }
    hideActionBar();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putInt("position", this.jdField_e_of_type_Int);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView.post(new cyx(this));
    }
  }
  
  protected void e_()
  {
    if ((getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (GesturePWDUtils.getGesturePWDState(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 2) && (GesturePWDUtils.getGesturePWDMode(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 21)) {
      B();
    }
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str)) {
        SharedPreUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_JavaLangString, true);
      }
    }
    if (PhoneNumLoginImpl.a().a()) {}
    do
    {
      return;
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
      paramDialogInterface = new QQProgressDialog(this, d());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2130903940);
      paramDialogInterface.b(2131561934);
      paramDialogInterface.show();
      czx localczx = (czx)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      String str1 = localczx.b(this.jdField_e_of_type_Int);
      String str2 = localczx.a(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Int = -1;
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (str2.equals(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString())))
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      }
      localczx.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_b_of_type_JavaLangString = null;
      }
      new Thread(new czk(this, str1, paramDialogInterface), "delete_account in login").start();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131231907)
    {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      localObject1 = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
      if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
      {
        QQToast.a(this, 2131562628, 0).a();
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      }
    }
    do
    {
      do
      {
        return;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
        if ((localObject2 == null) || (((String)localObject2).length() < 1))
        {
          QQToast.a(this, 2131562033, 0).a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
          this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
          return;
        }
        if (!EUCountryUtils.e(paramView))
        {
          QQToast.a(this, 2131563354, 0).a();
          return;
        }
        localObject2 = new Bundle();
        this.jdField_e_of_type_JavaLangString = paramView.trim();
        ((Bundle)localObject2).putString("key_privacy_uin", this.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject2).putInt("key_privacy_type", 1);
        PrivacyDeclareHelper.a(this, (Bundle)localObject2, new cze(this, paramView, (byte[])localObject1));
        return;
        if (i != 2131231909) {
          break;
        }
      } while (!this.jdField_e_of_type_Boolean);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      localObject1 = new Intent(this, RegisterPhoneNumActivity.class);
      ((Intent)localObject1).putExtra("key_register_now_account", paramView);
      startActivity((Intent)localObject1);
      this.jdField_e_of_type_Boolean = false;
      new Handler().postDelayed(new czf(this), 1000L);
      return;
    } while (i != 2131231903);
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "language_setting_external", "click_language_setting", 0, 1, 0);
    startActivity(new Intent(a(), SelectLanguageActivity.class));
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
        ((QQProgressDialog)localObject).a(getString(2131562310));
        return localObject;
      } while (!isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject = getLayoutInflater().inflate(2130903197, null);
      return DialogUtil.a(this, 230).setTitle(getString(2131561583)).setPositiveButton(2131562750, this).setNegativeButton(2131561748, new czb(this)).addView((View)localObject);
    }
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("StrTitle");
    String str2 = ((Intent)localObject).getStringExtra("StrUpgradeDesc");
    ((Intent)localObject).getStringExtra("StrUrl");
    localObject = DialogUtil.a(this, 230).setTitle(str1).setMessage(str2);
    ((QQCustomDialog)localObject).setPositiveButton(getResources().getString(2131559087), new czc(this));
    ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131561984));
    ((QQCustomDialog)localObject).setNegativeButton(getResources().getString(2131559088), new czd(this));
    return localObject;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131231294);
      String str = getString(2131561972);
      czx localczx = (czx)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_e_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", localczx.a(this.jdField_e_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131231552));
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
      }
      a(null);
      if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_d_of_type_JavaLangString.length() + 1))
        {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, this.jdField_d_of_type_JavaLangString.length()).equals(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_d_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(1);
    }
    this.jdField_d_of_type_JavaLangString = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */