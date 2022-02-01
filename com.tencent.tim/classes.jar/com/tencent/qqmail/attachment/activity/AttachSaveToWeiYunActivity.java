package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.watcher.ForwardToWeiYunWatcher;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMTopBar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.core.watcher.Watchers;

public class AttachSaveToWeiYunActivity
  extends BaseActivityEx
{
  public static String ARG_ACCOUNTID;
  public static String ARG_ATTACH;
  public static String ARG_FILE_NAME;
  public static String ARG_FROM_ATTACH_FOLDER;
  public static String ARG_FROM_FTN_LIST;
  public static String ARG_FROM_PUSH;
  public static String ARG_FROM_READMAIL;
  public static String ARG_IS_FROM_GROUP_MAIL;
  private static final long ATTACH_SIZE_IS_ONE_MEGABYTE = 1048576L;
  public static int ERR_SAVE_TO_WEIYUN_ALL_FAIL = 0;
  public static int ERR_SAVE_TO_WEIYUN_FILE_COUNT_MORE_THAN_FIFTY = 0;
  public static int ERR_SAVE_TO_WEIYUN_FILE_IS_EXIST = 0;
  public static int ERR_SAVE_TO_WEIYUN_FTN_FAIL = 10;
  public static int ERR_SAVE_TO_WEIYUN_PART_FAIL = 0;
  public static int ERR_SAVE_TO_WEIYUN_ROOM_LIMIT = 0;
  public static int ERR_SAVE_TO_WEIYUN_STORAGE_LIMIT = 0;
  public static int ERR_SAVE_TO_WEIYUN_SUCCESS = 0;
  public static int ERR_SAVE_TO_WEIYUN_TODAY_LIMIT = 0;
  public static boolean IS_TASK_LOADING = false;
  private static final long MAX_TRANSPORT_SPEED = 1572864L;
  private static final long MIN_TRANSPORT_SPEED = 524288L;
  private static final String TAG = "AttachSaveToWeiYunActivity";
  private int accountId;
  private TextView attachName;
  private TextView attachSize;
  private int checkingCount = 0;
  private String fileName = "";
  private final ForwardToWeiYunWatcher forwardToWeiYunWatcher = new AttachSaveToWeiYunActivity.4(this);
  private boolean isFirstIn = true;
  private boolean isFromAttachFolder = false;
  private boolean isFromFtnList = false;
  private boolean isFromGroupMail = false;
  private boolean isFromPush = false;
  private boolean isFromReadMail = false;
  private boolean isLoading = true;
  private Attach mailAttach;
  private LinearLayout outputErrorLayout;
  private LinearLayout outputLoadingLayout;
  private LinearLayout outputSucessLayout;
  private QMTopBar qmTopBar;
  private QQMailAccount qqMailAccount;
  private Button saveToWeiYunErrorRetryButton;
  private TextView saveToWeiYunErrorTitle;
  private LinearLayout saveToWeiYunOutputLayout;
  private Button saveToWeiYunSuccessCheckButton;
  private TextView saveToWeiYunSuccessTitle;
  private TextView saveToWeiYunTips;
  private String uin = "";
  private long waitForCheckingFirstTime = 2000L;
  private long waitForCheckingPerTime = 2000L;
  
  static
  {
    ARG_ATTACH = "arg_attach";
    ARG_ACCOUNTID = "arg_accountId";
    ARG_IS_FROM_GROUP_MAIL = "arg_is_from_group_mail";
    ARG_FROM_ATTACH_FOLDER = "arg_from_attach_folder";
    ARG_FROM_FTN_LIST = "arg_from_ftn_list";
    ARG_FROM_READMAIL = "arg_from_readmail";
    ARG_FROM_PUSH = "arg_from_push";
    ARG_FILE_NAME = "arg_file_name";
    ERR_SAVE_TO_WEIYUN_SUCCESS = 0;
    ERR_SAVE_TO_WEIYUN_FILE_IS_EXIST = 1;
    ERR_SAVE_TO_WEIYUN_ALL_FAIL = 2;
    ERR_SAVE_TO_WEIYUN_PART_FAIL = 3;
    ERR_SAVE_TO_WEIYUN_FILE_COUNT_MORE_THAN_FIFTY = 4;
    ERR_SAVE_TO_WEIYUN_ROOM_LIMIT = 6;
    ERR_SAVE_TO_WEIYUN_STORAGE_LIMIT = 7;
    ERR_SAVE_TO_WEIYUN_TODAY_LIMIT = 8;
  }
  
  public static Intent createIntent(Attach paramAttach, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), AttachSaveToWeiYunActivity.class);
    localIntent.putExtra(ARG_ATTACH, paramAttach);
    localIntent.putExtra(ARG_IS_FROM_GROUP_MAIL, paramBoolean1);
    localIntent.putExtra(ARG_ACCOUNTID, paramInt);
    localIntent.putExtra(ARG_FROM_ATTACH_FOLDER, paramBoolean2);
    localIntent.putExtra(ARG_FROM_FTN_LIST, paramBoolean3);
    localIntent.putExtra(ARG_FROM_READMAIL, paramBoolean4);
    return localIntent;
  }
  
  public static Intent createIntent(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), AttachSaveToWeiYunActivity.class);
    localIntent.putExtra(ARG_FROM_PUSH, paramBoolean);
    localIntent.putExtra(ARG_FILE_NAME, paramString);
    return localIntent;
  }
  
  private String handleTips(String paramString)
  {
    TextPaint localTextPaint = this.saveToWeiYunErrorTitle.getPaint();
    float f1 = localTextPaint.measureText(paramString);
    float f2 = QMUIKit.dpToPx(26);
    String str = paramString;
    if (f1 > this.saveToWeiYunOutputLayout.getWidth() - this.saveToWeiYunOutputLayout.getPaddingLeft() - this.saveToWeiYunOutputLayout.getPaddingRight() - f2)
    {
      int i = localTextPaint.breakText(paramString, true, f1 * 0.6F, null);
      str = paramString.substring(0, i) + '\n' + paramString.substring(i, paramString.length());
    }
    return str;
  }
  
  private void initTopBar()
  {
    this.qmTopBar = ((QMTopBar)findViewById(2131374707));
    this.qmTopBar.setTitle(2131690572);
    this.qmTopBar.setButtonLeftIcon(2130841088);
    this.qmTopBar.setButtonLeftOnclickListener(new AttachSaveToWeiYunActivity.1(this));
  }
  
  private void initView()
  {
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    this.attachName = ((TextView)findViewById(2131382207));
    this.attachSize = ((TextView)findViewById(2131382208));
    this.saveToWeiYunOutputLayout = ((LinearLayout)findViewById(2131377634));
    this.outputLoadingLayout = ((LinearLayout)this.saveToWeiYunOutputLayout.findViewById(2131377638));
    this.outputSucessLayout = ((LinearLayout)this.saveToWeiYunOutputLayout.findViewById(2131377640));
    this.saveToWeiYunSuccessTitle = ((TextView)this.outputSucessLayout.findViewById(2131377642));
    this.outputErrorLayout = ((LinearLayout)this.saveToWeiYunOutputLayout.findViewById(2131377635));
    this.saveToWeiYunErrorTitle = ((TextView)this.outputErrorLayout.findViewById(2131377637));
    this.saveToWeiYunErrorRetryButton = ((Button)this.saveToWeiYunOutputLayout.findViewById(2131377636));
    this.saveToWeiYunSuccessCheckButton = ((Button)this.saveToWeiYunOutputLayout.findViewById(2131377641));
    this.saveToWeiYunTips = ((TextView)findViewById(2131377643));
    Object localObject = (ImageView)findViewById(2131368746);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    Drawable localDrawable = getResources().getDrawable(2130841114);
    localLayoutParams.setMargins(0, (this.saveToWeiYunErrorTitle.getLineHeight() - localDrawable.getIntrinsicHeight()) / 2, localLayoutParams.rightMargin, 0);
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    if (!this.isFromPush)
    {
      this.attachName.setText(this.mailAttach.getName());
      localObject = this.mailAttach.getSize().replaceAll("\\.", "");
      if (!Pattern.compile("[0-9]*").matcher((CharSequence)localObject).matches()) {
        break label369;
      }
      this.attachSize.setText(StringExtention.getHumanReadableSizeString(Long.parseLong(this.mailAttach.getSize())));
    }
    for (;;)
    {
      if (((String)localObject).equals("0")) {
        this.attachSize.setVisibility(8);
      }
      this.saveToWeiYunErrorRetryButton.setOnClickListener(new AttachSaveToWeiYunActivity.2(this));
      this.saveToWeiYunSuccessCheckButton.setOnClickListener(new AttachSaveToWeiYunActivity.3(this));
      return;
      label369:
      this.attachSize.setText(this.mailAttach.getSize());
    }
  }
  
  private void resetSaveToWeiYunLoading()
  {
    this.isLoading = true;
    this.outputLoadingLayout.setVisibility(0);
    this.outputSucessLayout.setVisibility(8);
    this.outputErrorLayout.setVisibility(8);
    this.saveToWeiYunTips.setVisibility(0);
    this.saveToWeiYunTips.setText(getString(2131690578));
    this.saveToWeiYunErrorRetryButton.setVisibility(8);
    this.saveToWeiYunSuccessCheckButton.setVisibility(8);
  }
  
  private void showErrorPage(String paramString)
  {
    this.isLoading = false;
    this.outputErrorLayout.setVisibility(0);
    this.outputLoadingLayout.setVisibility(8);
    this.outputSucessLayout.setVisibility(8);
    this.attachName.setText(paramString);
    this.attachSize.setVisibility(8);
    this.saveToWeiYunTips.setVisibility(8);
    this.saveToWeiYunErrorRetryButton.setVisibility(8);
    this.saveToWeiYunSuccessCheckButton.setVisibility(8);
  }
  
  private void showNetworkError()
  {
    this.isLoading = false;
    this.outputErrorLayout.setVisibility(0);
    this.outputSucessLayout.setVisibility(8);
    this.outputLoadingLayout.setVisibility(8);
    this.saveToWeiYunErrorTitle.setText(getString(2131690576));
    this.saveToWeiYunTips.setVisibility(8);
    this.saveToWeiYunErrorRetryButton.setVisibility(0);
    this.saveToWeiYunSuccessCheckButton.setVisibility(8);
  }
  
  private void toggleSaveToWeiYunStateView(int paramInt, String paramString)
  {
    this.isLoading = false;
    IS_TASK_LOADING = false;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      if (paramInt != 0) {
        break label51;
      }
    }
    label51:
    for (String str = getString(2131690577);; str = getString(2131690574))
    {
      runOnMainThread(new AttachSaveToWeiYunActivity.11(this, str, paramInt));
      return;
    }
  }
  
  public void initDataSource()
  {
    this.isFromPush = getIntent().getBooleanExtra(ARG_FROM_PUSH, false);
    StringBuilder localStringBuilder;
    if (this.isFromPush)
    {
      this.fileName = getIntent().getStringExtra(ARG_FILE_NAME);
      localStringBuilder = new StringBuilder().append("initDataSource: isFromPush:").append(this.isFromPush).append(",fileName:");
      if (this.fileName == null) {
        break label460;
      }
      str = this.fileName;
      label76:
      localStringBuilder = localStringBuilder.append(str).append(",accountId:").append(this.accountId).append(",isFromAttachFolder:").append(this.isFromAttachFolder).append(",isFromGroupMail:").append(this.isFromGroupMail).append(",isFromFtnList:").append(this.isFromFtnList).append(",uin:");
      if (this.uin == null) {
        break label466;
      }
    }
    label460:
    label466:
    for (String str = this.uin;; str = "")
    {
      QMLog.log(4, "AttachSaveToWeiYunActivity", str + ",isFromReadMail:" + this.isFromReadMail);
      return;
      this.mailAttach = ((Attach)getIntent().getSerializableExtra(ARG_ATTACH));
      this.accountId = getIntent().getIntExtra(ARG_ACCOUNTID, 0);
      this.isFromAttachFolder = getIntent().getBooleanExtra(ARG_FROM_ATTACH_FOLDER, false);
      this.isFromGroupMail = getIntent().getBooleanExtra(ARG_IS_FROM_GROUP_MAIL, false);
      this.isFromReadMail = getIntent().getBooleanExtra(ARG_FROM_READMAIL, false);
      this.isFromFtnList = getIntent().getBooleanExtra(ARG_FROM_FTN_LIST, false);
      this.qqMailAccount = ((QQMailAccount)AccountManager.shareInstance().getAccountList().getAccountById(this.accountId));
      if (this.qqMailAccount != null) {
        this.uin = this.qqMailAccount.getUin();
      }
      if ((this.mailAttach != null) && (!this.mailAttach.isBigAttach()))
      {
        long l = StringExtention.sizeStrToLong(this.mailAttach.getSize());
        if (l > 1572864L) {
          this.waitForCheckingFirstTime = (l / 1572864L * 1000L);
        }
        this.waitForCheckingPerTime = ((l / 524288L - l / 1572864L) / 10L * 1000L);
        if (this.waitForCheckingPerTime < 2000L) {
          this.waitForCheckingPerTime = 2000L;
        }
      }
      if (this.isFromReadMail)
      {
        DataCollector.logEvent("Event_Weiyun_Launch_From_Readmail");
        break;
      }
      if (this.isFromAttachFolder)
      {
        DataCollector.logEvent("Event_Weiyun_Launch_From_Attachlist");
        break;
      }
      if (this.isFromFtnList)
      {
        DataCollector.logEvent("Event_Weiyun_Launch_From_Ftnlist");
        break;
      }
      DataCollector.logEvent("Event_Weiyun_Launch_From_Preview_Attach");
      break;
      str = "";
      break label76;
    }
  }
  
  public void initDom()
  {
    initView();
  }
  
  public void initUI()
  {
    setContentView(2131558476);
    initTopBar();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.isLoading)
    {
      DataCollector.logEvent("Event_Weiyun_Close_Transfering_Page");
      IS_TASK_LOADING = true;
    }
    finish();
    overridePendingTransition(0, 2130772402);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.forwardToWeiYunWatcher, paramBoolean);
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    if (this.isFromPush) {
      showErrorPage(this.fileName);
    }
    do
    {
      return;
      if (!QMNetworkUtils.isNetworkConnected(getActivity()))
      {
        showNetworkError();
        return;
      }
      if (IS_TASK_LOADING)
      {
        resetSaveToWeiYunLoading();
        return;
      }
    } while (!this.isFirstIn);
    this.isFirstIn = false;
    resetSaveToWeiYunLoading();
    if ((this.mailAttach.isBigAttach()) || (this.isFromFtnList))
    {
      QMLog.log(2, "AttachSaveToWeiYunActivity", "render bigAttach");
      saveBigAttachToWeiYun(this.mailAttach);
      return;
    }
    QMLog.log(2, "AttachSaveToWeiYunActivity", "render normalAttach");
    saveNormalAttachToWeiYunBuildTask(this.mailAttach);
  }
  
  public void saveBigAttachToWeiYun(Attach paramAttach)
  {
    Object localObject = MailManagerDefines.PARAM_SAVE_BIG_ATTACH_TO_WEIYUN;
    if (((MailBigAttach)paramAttach).getFid() != null) {}
    for (paramAttach = ((MailBigAttach)paramAttach).getFid();; paramAttach = "")
    {
      paramAttach = ((String)localObject).replace("$fid$", paramAttach);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnSuccess(new AttachSaveToWeiYunActivity.9(this));
      ((QMCallback)localObject).setOnError(new AttachSaveToWeiYunActivity.10(this));
      CGIManager.httpPost(this.accountId, "ftnTagMgr", paramAttach, (QMCallback)localObject);
      return;
    }
  }
  
  public void saveNormalAttachToWeiYunBuildTask(Attach paramAttach)
  {
    if (this.isFromGroupMail)
    {
      localObject = paramAttach.getDownloadKey();
      if (!this.isFromAttachFolder) {
        break label146;
      }
      localObject = MailManagerDefines.PARAM_SAVE_NORMAL_ATTACH_TO_WEIYUN_BUILD_TASK.replace("$mailattach$", Uri.encode(paramAttach.getRemoteId() + "|" + Uri.encode(paramAttach.getName())));
      if (this.uin == null) {
        break label140;
      }
    }
    label140:
    for (paramAttach = this.uin;; paramAttach = "")
    {
      paramAttach = ((String)localObject).replace("$userid$", paramAttach);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnSuccess(new AttachSaveToWeiYunActivity.5(this));
      ((QMCallback)localObject).setOnError(new AttachSaveToWeiYunActivity.6(this));
      CGIManager.httpPost(this.accountId, "netdriveupload", paramAttach, (QMCallback)localObject);
      return;
      localObject = paramAttach.getAlias();
      break;
    }
    label146:
    Object localObject = MailManagerDefines.PARAM_SAVE_NORMAL_ATTACH_TO_WEIYUN_BUILD_TASK.replace("$mailattach$", Uri.encode(paramAttach.getRemoteId() + "|" + (String)localObject + "|" + Uri.encode(paramAttach.getName())));
    if (this.uin != null) {}
    for (paramAttach = this.uin;; paramAttach = "")
    {
      paramAttach = ((String)localObject).replace("$userid$", paramAttach);
      break;
    }
  }
  
  public void saveNormalAttachToWeiYunChecking(String paramString)
  {
    Object localObject = MailManagerDefines.PARAM_SAVE_NORMAL_ATTACH_TO_WEIYUN_CHECKING;
    if (paramString != null) {}
    for (String str = paramString;; str = "")
    {
      str = ((String)localObject).replace("$taskid$", str);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnSuccess(new AttachSaveToWeiYunActivity.7(this, paramString));
      ((QMCallback)localObject).setOnError(new AttachSaveToWeiYunActivity.8(this, paramString));
      CGIManager.httpPost(this.accountId, "netdriveupload", str, (QMCallback)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity
 * JD-Core Version:    0.7.0.1
 */