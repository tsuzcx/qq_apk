package com.tencent.qqmail.account.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.setting.AvatarSelector;
import com.tencent.qqmail.activity.setting.SettingCalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.SyncNickWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMAvatarView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import moai.fragment.app.FragmentActivity;

public class LoginInfoFragment
  extends LoginBaseFragment
{
  private static final String TAG = "LoginInfoFragment";
  private int CALENDAR_REQUEST_CODE = 1111;
  private Account account;
  private QMAvatarView avatar;
  private QMBaseView baseView;
  private boolean calendarItemFistClick = true;
  private final Object calendarLockObject = new Object();
  private UITableItemView calendarSwitchItemView;
  private UITableView.ClickListener calendarSwitchListener = new LoginInfoFragment.7(this);
  private UITableView calendarSwitchTable;
  private EditText editTextNickNameInput;
  private boolean hasInitAccount;
  private LinearLayout informationContainer;
  private boolean isQuickLogin;
  private AccountType mAccountType;
  private Bitmap mAvatarBitmap = null;
  private AvatarSelector mAvatarSelector;
  private String password;
  private String serverNickName;
  private SyncNickWatcher syncNickWatcher = new LoginInfoFragment.1(this);
  private SyncPhotoWatcher syncPhotoWatcher = new LoginInfoFragment.2(this);
  private QMTopBar topBar;
  
  public LoginInfoFragment(Account paramAccount, String paramString, AccountType paramAccountType, boolean paramBoolean)
  {
    this.account = paramAccount;
    this.password = paramString;
    this.isQuickLogin = paramBoolean;
    this.mAccountType = paramAccountType;
  }
  
  private void finishAddAccount()
  {
    int j = 0;
    if (hasBonusAccount()) {
      QMSettingManager.sharedInstance().setBonusTest(true);
    }
    initAccount();
    QMSyncErrorManager.sharedInstance().removeUnAuthError(this.account.getId());
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Object localObject1 = this.editTextNickNameInput.getText().toString();
    int i;
    if ((!((String)localObject1).equals(this.serverNickName)) && (!StringExtention.isNullOrEmpty((String)localObject1)))
    {
      QMLog.log(4, "LoginInfoFragment", "sync nick name");
      if (localAccountList.getAccountById(this.account.getId()).isQQMail())
      {
        QMComposeDataManager.sharedInstance().setQMDefaultNick(this.account.getId(), (String)localObject1);
        QMAliasManager.shareInstance().syncQMAccountDefaultNick(this.account.getId(), (String)localObject1, null);
      }
    }
    else
    {
      QMActivityManager.shareInstance().finishAllActivity();
      QMLog.log(4, "LoginInfoFragment", "finish add account");
      Object localObject2 = (Intent)getActivity().getIntent().getParcelableExtra("arg_goto_intent");
      if ((localObject2 == null) || (!((Intent)localObject2).getComponent().getClassName().equals(MailFragmentActivity.class.getName()))) {
        break label385;
      }
      i = 1;
      label184:
      if ((localObject2 == null) || (i != 0))
      {
        if (localAccountList.size() != 1) {
          break label390;
        }
        localObject1 = MailFragmentActivity.createIntentToFolderList(this.account.getId());
        AccountManager.shareInstance().setDefaultMailAccount(this.account.getId());
        label226:
        localObject2 = localObject1;
        if (i != 0)
        {
          ((Intent)localObject1).putExtra("fromController", "otherapp");
          localObject2 = localObject1;
        }
      }
      startActivity((Intent)localObject2);
      getActivity().overridePendingTransition(2130772401, 2130772423);
      QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      QMSyncAdapterManager.updateSyncTime(this.account.getEmail());
      QMSyncAdapterManager.checkAccount(true);
      if (localAccountList.size() == 1) {
        KeepAliveManager.markFirstAddAccount();
      }
      if (this.account.isQQMail()) {
        break label405;
      }
      localObject1 = localAccountList.iterator();
      i = j;
      label323:
      if (!((Iterator)localObject1).hasNext()) {
        break label397;
      }
      if (((Account)((Iterator)localObject1).next()).isQQMail()) {
        break label406;
      }
      i += 1;
    }
    label385:
    label390:
    label397:
    label405:
    label406:
    for (;;)
    {
      break label323;
      QMSettingManager.sharedInstance().setAccountNick(this.account.getId(), (String)localObject1);
      QMPrivateProtocolManager.sharedInstance().setAccountNick(this.account.getId(), (String)localObject1);
      break;
      i = 0;
      break label184;
      localObject1 = MailFragmentActivity.createIntentToAccountList();
      break label226;
      if (i == 1) {
        KeepAliveManager.markFirstAddNonQQAccount();
      }
      return;
    }
  }
  
  /* Error */
  private boolean hasBonusAccount()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: invokestatic 383	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   13: invokevirtual 387	com/tencent/qqmail/QMApplicationContext:getResources	()Landroid/content/res/Resources;
    //   16: invokevirtual 393	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   19: ldc_w 395
    //   22: invokevirtual 401	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 6
    //   27: aload 6
    //   29: astore 4
    //   31: aload 6
    //   33: astore 5
    //   35: new 403	java/io/BufferedReader
    //   38: dup
    //   39: new 405	java/io/InputStreamReader
    //   42: dup
    //   43: aload 6
    //   45: invokespecial 408	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 411	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore 7
    //   53: aload 6
    //   55: astore 4
    //   57: aload 6
    //   59: astore 5
    //   61: aload 7
    //   63: invokevirtual 414	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 8
    //   68: iload_2
    //   69: istore_1
    //   70: aload 8
    //   72: ifnull +51 -> 123
    //   75: aload 6
    //   77: astore 4
    //   79: aload 6
    //   81: astore 5
    //   83: aload_0
    //   84: getfield 81	com/tencent/qqmail/account/fragment/LoginInfoFragment:account	Lcom/tencent/qqmail/account/model/Account;
    //   87: invokevirtual 417	com/tencent/qqmail/account/model/Account:getUin	()Ljava/lang/String;
    //   90: invokestatic 202	com/tencent/qqmail/utilities/stringextention/StringExtention:isNullOrEmpty	(Ljava/lang/String;)Z
    //   93: ifne -40 -> 53
    //   96: aload 6
    //   98: astore 4
    //   100: aload 6
    //   102: astore 5
    //   104: aload_0
    //   105: getfield 81	com/tencent/qqmail/account/fragment/LoginInfoFragment:account	Lcom/tencent/qqmail/account/model/Account;
    //   108: invokevirtual 417	com/tencent/qqmail/account/model/Account:getUin	()Ljava/lang/String;
    //   111: aload 8
    //   113: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: istore_1
    //   117: iload_1
    //   118: ifeq -65 -> 53
    //   121: iconst_1
    //   122: istore_1
    //   123: iload_1
    //   124: istore_2
    //   125: aload 6
    //   127: ifnull +10 -> 137
    //   130: aload 6
    //   132: invokevirtual 422	java/io/InputStream:close	()V
    //   135: iload_1
    //   136: istore_2
    //   137: iload_2
    //   138: ireturn
    //   139: astore 6
    //   141: aload 4
    //   143: astore 5
    //   145: bipush 6
    //   147: ldc_w 424
    //   150: new 426	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 429
    //   160: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 6
    //   165: invokevirtual 434	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 210	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   177: iload_3
    //   178: istore_2
    //   179: aload 4
    //   181: ifnull -44 -> 137
    //   184: aload 4
    //   186: invokevirtual 422	java/io/InputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore 4
    //   193: iconst_0
    //   194: ireturn
    //   195: astore 4
    //   197: aload 5
    //   199: ifnull +8 -> 207
    //   202: aload 5
    //   204: invokevirtual 422	java/io/InputStream:close	()V
    //   207: aload 4
    //   209: athrow
    //   210: astore 4
    //   212: iload_1
    //   213: ireturn
    //   214: astore 5
    //   216: goto -9 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	LoginInfoFragment
    //   69	144	1	bool1	boolean
    //   9	170	2	bool2	boolean
    //   7	171	3	bool3	boolean
    //   4	181	4	localObject1	Object
    //   191	1	4	localException1	java.lang.Exception
    //   195	13	4	localObject2	Object
    //   210	1	4	localException2	java.lang.Exception
    //   1	202	5	localObject3	Object
    //   214	1	5	localException3	java.lang.Exception
    //   25	106	6	localInputStream	java.io.InputStream
    //   139	25	6	localIOException	java.io.IOException
    //   51	11	7	localBufferedReader	java.io.BufferedReader
    //   66	46	8	str	String
    // Exception table:
    //   from	to	target	type
    //   10	27	139	java/io/IOException
    //   35	53	139	java/io/IOException
    //   61	68	139	java/io/IOException
    //   83	96	139	java/io/IOException
    //   104	117	139	java/io/IOException
    //   184	189	191	java/lang/Exception
    //   10	27	195	finally
    //   35	53	195	finally
    //   61	68	195	finally
    //   83	96	195	finally
    //   104	117	195	finally
    //   145	177	195	finally
    //   130	135	210	java/lang/Exception
    //   202	207	214	java/lang/Exception
  }
  
  private void initAccount()
  {
    boolean bool1 = true;
    QMLog.log(4, "LoginInfoFragment", "initAccount:" + this.hasInitAccount);
    if (this.hasInitAccount) {
      return;
    }
    this.hasInitAccount = true;
    String str = this.editTextNickNameInput.getText().toString();
    LoginManager localLoginManager = LoginManager.shareInstance();
    Account localAccount = this.account;
    int i = this.password.length();
    Bitmap localBitmap;
    boolean bool2;
    if ((this.serverNickName != null) && (!this.serverNickName.equals(str)))
    {
      localBitmap = this.mAvatarBitmap;
      bool2 = this.isQuickLogin;
      if ((this.calendarSwitchItemView == null) || (!this.calendarSwitchItemView.isChecked())) {
        break label143;
      }
    }
    for (;;)
    {
      localLoginManager.initNewAccount(localAccount, i, str, localBitmap, bool2, bool1);
      return;
      str = null;
      break;
      label143:
      bool1 = false;
    }
  }
  
  private void initCalendarTable()
  {
    if ((this.mAccountType == AccountType.gmail) || (this.account.isBizMail()) || (this.account.isGMail()) || (this.account.isICloud()) || (this.account.isOutlook()))
    {
      this.calendarSwitchTable = new UITableView(getActivity());
      this.informationContainer.addView(this.calendarSwitchTable);
      this.calendarSwitchItemView = this.calendarSwitchTable.addItem(2131691226);
      this.calendarSwitchItemView.setChecked(false);
      this.calendarSwitchTable.setClickListener(this.calendarSwitchListener);
      this.calendarSwitchTable.commit();
      this.calendarSwitchItemView.getChildAt(1).setEnabled(true);
    }
  }
  
  private void initInformation()
  {
    String str;
    if ((this.account != null) && (this.account.getEmail().toLowerCase().endsWith("@tencent.com")))
    {
      this.informationContainer.findViewById(2131363199).setEnabled(false);
      this.informationContainer.findViewById(2131372368).setEnabled(false);
      this.informationContainer.findViewById(2131363199).setOnClickListener(new LoginInfoFragment.5(this));
      str = this.account.getEmail().split("@")[0];
      Bitmap localBitmap = QMSettingManager.sharedInstance().getAccountIconLocal(this.account.getEmail(), 2);
      this.avatar = ((QMAvatarView)this.informationContainer.findViewById(2131363175));
      if (localBitmap == null) {
        break label216;
      }
      this.avatar.setAvatar(localBitmap, null);
    }
    for (;;)
    {
      this.mAvatarSelector = new AvatarSelector(getBaseActivityImpl(), new LoginInfoFragment.6(this));
      this.editTextNickNameInput = ((EditText)this.informationContainer.findViewById(2131372384));
      this.editTextNickNameInput.setText(str);
      return;
      this.informationContainer.findViewById(2131363199).setEnabled(true);
      this.informationContainer.findViewById(2131372368).setEnabled(true);
      break;
      label216:
      this.avatar.setAvatar(null, str);
    }
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.setTitle(getString(this.mAccountType.getResId()));
    this.topBar.setButtonRightBlue(getString(2131693745));
    this.topBar.setButtonRightOnclickListener(new LoginInfoFragment.3(this));
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginInfoFragment.4(this));
    this.topBar.getButtonLeft().setVisibility(8);
  }
  
  private void loginCalendar()
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnError(new LoginInfoFragment.8(this));
    localMailManagerDelegate.setOnSuccess(new LoginInfoFragment.9(this));
    if (this.calendarItemFistClick) {
      initAccount();
    }
    synchronized (this.calendarLockObject)
    {
      QMCalendarManager.getInstance().login(this.account, null, localMailManagerDelegate);
      return;
    }
  }
  
  private void logoutCalendar()
  {
    synchronized (this.calendarLockObject)
    {
      QMCalendarManager.getInstance().logout(this.account);
      return;
    }
  }
  
  private void refreshTopBar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.topBar.getButtonRight().setEnabled(false);
      this.topBar.setTitle(2131719699);
      this.topBar.getButtonLeft().setVisibility(0);
      this.topBar.showLoading(true);
      return;
    }
    this.topBar.getButtonRight().setEnabled(true);
    this.topBar.setTitle(getString(this.mAccountType.getResId()));
    this.topBar.getButtonLeft().setVisibility(8);
    this.topBar.showLoading(false);
  }
  
  private void settingCalendar()
  {
    SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.SERVER_SETTING;
    SettingCalendarFragmentActivity.settingAccount = this.account;
    startActivityForResult(SettingCalendarFragmentActivity.createIntent(), this.CALENDAR_REQUEST_CODE);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initInformation();
    if (QMCalendarManager.calendarEnable) {
      initCalendarTable();
    }
    TimMailLoginManager.notifyLoginChange(getActivity(), true, this.account);
    paramView = AccountType.domainOf(this.account.getEmail());
    if (this.account.getProtocol() == 2)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FB", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if ((this.account.getProtocol() == 13) || (this.account.getProtocol() == 14))
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FC", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.qqmail)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088F9", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.mail163)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FD", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.mail126)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FE", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.exmail)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FB", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.gmail)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X80088FF", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    if (paramView == AccountType.outlook)
    {
      TimReportManager.reportClickEvent(getActivity(), "0X8008900", 0, 0, 0, 0, 0, "", "", "", "");
      return;
    }
    TimReportManager.reportClickEvent(getActivity(), "0X8008901", 0, 0, 0, 0, 0, "", "", "", "");
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.informationContainer = ((LinearLayout)View.inflate(getActivity(), 2131559515, null));
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.baseView.addContentView(this.informationContainer);
    return this.baseView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mAvatarSelector.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finishAddAccount();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncNickWatcher(this.syncNickWatcher, paramBoolean);
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    QMPrivateProtocolManager.sharedInstance().syncAccountNick(this.account.getEmail());
    QMPrivateProtocolManager.sharedInstance().loadEmailIconDirectly(this.account.getEmail());
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment
 * JD-Core Version:    0.7.0.1
 */