package com.tencent.qqmail.activity.setting;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigDialog;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class SettingAboutActivity
  extends BaseActivityEx
{
  private static String EXTRA_FROM = "extra_from";
  private static String FROM_BETA = "From_Popwindow_Beta";
  public static final String TAG = "SettingAboutActivity";
  private static ArrayList<Long> downloadIdList = new ArrayList();
  private final UITableView.ClickListener appRelationListOnClickListener = new SettingAboutActivity.6(this);
  private UITableItemView checkUpdateItemView;
  private boolean detailVersion = false;
  private String from;
  private UITableItemView funcItemView;
  private boolean hasBeta = false;
  private boolean hasUpgrade = false;
  private String period = ".";
  private UITableItemView scoreItemView;
  private UITableItemView splashListItemView;
  private QMTopBar topBar;
  private UITableItemView welcomeItemView;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingAboutActivity.class);
  }
  
  public static Intent createIntentForBeta()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingAboutActivity.class);
    localIntent.putExtra(EXTRA_FROM, FROM_BETA);
    return localIntent;
  }
  
  private TextView generateConTextView()
  {
    TextView localTextView = new TextView(new ContextThemeWrapper(this, 2131756101), null, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297123);
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }
  
  private TextView generateTipTextView()
  {
    TextView localTextView = new TextView(new ContextThemeWrapper(this, 2131756102), null, 0);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localTextView;
  }
  
  private TextView generateTitleTextView()
  {
    TextView localTextView = new TextView(new ContextThemeWrapper(this, 2131756101), null, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297127);
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }
  
  private void handleBeta()
  {
    int i = QMPushConfigUtil.getBetaClickType();
    if (i == 0)
    {
      localObject = QMPushConfigUtil.getBetaVersionUrl();
      if (!StringExtention.isNullOrEmpty((String)localObject))
      {
        if (!QMNetworkUtils.isWifiConnected(getApplicationContext())) {
          break label108;
        }
        DataCollector.logEvent("Event_Setting_Download_Beta_Click");
        if ((downloadIdList == null) || (downloadIdList.size() <= 0)) {
          break label65;
        }
        Toast.makeText(getApplicationContext(), 2131692973, 0).show();
      }
    }
    label65:
    label108:
    do
    {
      return;
      long l = QMAttachUtils.goToDownload(getActivity(), (String)localObject, 1, "", null);
      downloadIdList.add(Long.valueOf(l));
      Toast.makeText(getApplicationContext(), 2131719974, 0).show();
      QMPushConfigUtil.sendDownloadBeta();
      return;
      showCommonDialog(false, getString(2131696311), getString(2131719901), getString(2131691246), getString(2131690536), (String)localObject);
      return;
      if (i == 2)
      {
        startActivity(SimpleWebViewExplorer.createIntent(QMPushConfigUtil.getBetaWebViewUrl(), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON));
        return;
      }
    } while (i != 1);
    Object localObject = QMPushConfigUtil.getBetaFeatureDialog();
    if ((localObject != null) && (!StringExtention.isNullOrEmpty(((QMPushConfigDialog)localObject).getDespTitle())) && (!StringExtention.isNullOrEmpty(((QMPushConfigDialog)localObject).getTitle())) && (((QMPushConfigDialog)localObject).getDespLines() != null) && (((QMPushConfigDialog)localObject).getDespLines().size() > 0))
    {
      showFeatureDialog(false, (QMPushConfigDialog)localObject, QMPushConfigUtil.getBetaVersionUrl());
      return;
    }
    showCommonDialog(false, getString(2131719882), getString(2131719883), getString(2131691246), getString(2131719717), QMPushConfigUtil.getBetaVersionUrl());
  }
  
  private void handleUpgrade()
  {
    int i = QMPushConfigUtil.getUpgradeClickType();
    if (i == 0)
    {
      localObject = QMPushConfigUtil.getNewVersionUrl();
      if (!StringExtention.isNullOrEmpty((String)localObject))
      {
        if (!QMNetworkUtils.isWifiConnected(getApplicationContext())) {
          break label127;
        }
        DataCollector.logEvent("Event_Setting_Download_Upgrade_Click");
        if (!IntentUtil.intentToPriorityMarket(this, QMApplicationContext.sharedInstance().getPackageName(), true)) {
          break label55;
        }
        QMPushConfigUtil.sendDownloadUpgrade();
      }
    }
    label55:
    label127:
    do
    {
      return;
      if ((downloadIdList != null) && (downloadIdList.size() > 0))
      {
        Toast.makeText(getApplicationContext(), 2131692973, 0).show();
        return;
      }
      long l = QMAttachUtils.goToDownload(getActivity(), (String)localObject, 1, "", null);
      downloadIdList.add(Long.valueOf(l));
      Toast.makeText(getApplicationContext(), 2131719974, 0).show();
      QMPushConfigUtil.sendDownloadUpgrade();
      return;
      showCommonDialog(true, getString(2131696311), getString(2131719901), getString(2131691246), getString(2131690536), (String)localObject);
      return;
      if (i == 2)
      {
        startActivity(SimpleWebViewExplorer.createIntent(QMPushConfigUtil.getUpgradeWebViewUrl(), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON));
        return;
      }
    } while (i != 1);
    Object localObject = QMPushConfigUtil.getUpgradeFeatureDialog();
    if ((localObject != null) && (!StringExtention.isNullOrEmpty(((QMPushConfigDialog)localObject).getDespTitle())) && (!StringExtention.isNullOrEmpty(((QMPushConfigDialog)localObject).getTitle())) && (((QMPushConfigDialog)localObject).getDespLines() != null) && (((QMPushConfigDialog)localObject).getDespLines().size() > 0))
    {
      showFeatureDialog(true, (QMPushConfigDialog)localObject, QMPushConfigUtil.getNewVersionUrl());
      return;
    }
    showCommonDialog(true, getString(2131720006), getString(2131720007), getString(2131691246), getString(2131719717), QMPushConfigUtil.getNewVersionUrl());
  }
  
  public static void registerDownLoadReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    DownloadReceiver localDownloadReceiver = new DownloadReceiver();
    QMApplicationContext.sharedInstance().registerReceiver(localDownloadReceiver, localIntentFilter);
  }
  
  private void setCheckUpdateItemView()
  {
    Object localObject1 = QMPushConfigUtil.getNewVersion();
    Object localObject2 = QMPushConfigUtil.getBetaVersion();
    this.checkUpdateItemView.setEnabled(true);
    if (QMPushConfigUtil.showUpgradeVersion())
    {
      this.hasUpgrade = true;
      this.hasBeta = false;
      this.checkUpdateItemView.setTitle(getString(2131720005));
      if (QMPushConfigUtil.getUpgradeItemShowNew()) {
        this.checkUpdateItemView.showNew(true);
      }
      for (;;)
      {
        DataCollector.logEvent("Event_Upgrade_Button_Show");
        localObject2 = ((String)localObject1).split("\\.");
        if (localObject2.length >= 3) {
          localObject1 = localObject2[0] + "." + localObject2[1] + "." + localObject2[2];
        }
        this.checkUpdateItemView.setDetail((String)localObject1);
        DataCollector.logEvent("Event_Setting_Upgrade_Show");
        return;
        this.checkUpdateItemView.showNew(false);
      }
    }
    if (QMPushConfigUtil.showBetaVersion())
    {
      this.hasUpgrade = false;
      this.hasBeta = true;
      this.checkUpdateItemView.setTitle(getString(2131719882));
      localObject1 = ((String)localObject2).split("\\.");
      if (localObject1.length < 3) {
        break label310;
      }
    }
    label310:
    for (localObject1 = localObject1[0] + "." + localObject1[1] + "." + localObject1[2];; localObject1 = localObject2)
    {
      if (QMPushConfigUtil.getBetaItemShowNew()) {
        this.checkUpdateItemView.showNew(true);
      }
      for (;;)
      {
        this.checkUpdateItemView.setDetail((String)localObject1);
        DataCollector.logEvent("Event_Setting_Join_Beta_Show");
        return;
        this.checkUpdateItemView.showNew(false);
      }
      this.hasUpgrade = false;
      this.hasBeta = false;
      this.checkUpdateItemView.showNew(false);
      this.checkUpdateItemView.setDetail("");
      this.checkUpdateItemView.setTitle(getString(2131719707));
      return;
    }
  }
  
  private void showCommonDialog(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(paramString1)).setMessage(paramString2).addAction(paramString3, new SettingAboutActivity.8(this))).addAction(paramString4, new SettingAboutActivity.7(this, paramBoolean, paramString5))).create().show();
  }
  
  private void showFeatureDialog(boolean paramBoolean, QMPushConfigDialog paramQMPushConfigDialog, String paramString)
  {
    if (paramQMPushConfigDialog != null)
    {
      if (!paramBoolean) {
        break label77;
      }
      DataCollector.logEvent("Event_Setting_Upgrade_Dialog_Show");
    }
    for (;;)
    {
      ((PushConfigBuilder)((PushConfigBuilder)((PushConfigBuilder)new PushConfigBuilder(this, paramQMPushConfigDialog).setTitle(paramQMPushConfigDialog.getTitle())).addAction(2131691246, new SettingAboutActivity.10(this))).addAction(2131719717, new SettingAboutActivity.9(this, paramBoolean, paramString))).create().show();
      return;
      label77:
      DataCollector.logEvent("Event_Setting_Beta_Dialog_Show");
    }
  }
  
  private void showVersion(boolean paramBoolean)
  {
    TextView localTextView = (TextView)findViewById(2131362867);
    int i;
    String str2;
    if (AppConfig.isBeta())
    {
      i = 2131690424;
      str2 = getString(i);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (String str1 = AppConfig.getPatchVersion() + ": " + ChannelDefine.getChannelId();; str1 = AppConfig.getSystemVersionName())
    {
      localTextView.setText(String.format(str2, new Object[] { str1 }));
      return;
      i = 2131690423;
      break;
    }
  }
  
  public void initDataSource()
  {
    if (getIntent() != null) {
      this.from = getIntent().getStringExtra(EXTRA_FROM);
    }
  }
  
  public void initDom()
  {
    findViewById(2131375055).setOnLongClickListener(new SettingAboutActivity.1(this));
    findViewById(2131375055).setOnClickListener(new SettingAboutActivity.2(this));
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(getString(2131689594)).setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new SettingAboutActivity.3(this));
    showVersion(false);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131370541);
    UITableView localUITableView = new UITableView(getActivity());
    if (!AppConfig.isBeta())
    {
      this.funcItemView = localUITableView.addItem(2131719880);
      this.welcomeItemView = localUITableView.addItem(2131720012);
      this.scoreItemView = localUITableView.addItem(2131719874);
    }
    this.splashListItemView = localUITableView.addItem(2131719972);
    if (QMSettingManager.sharedInstance().getShowSplashList()) {
      this.splashListItemView.setVisibility(0);
    }
    for (;;)
    {
      this.checkUpdateItemView = localUITableView.addItem(2131719707);
      this.checkUpdateItemView.hideArrow();
      this.checkUpdateItemView.setDetail("");
      if ((!StringExtention.isNullOrEmpty(this.from)) && (this.from.equals(FROM_BETA)))
      {
        this.checkUpdateItemView.setTitle(getString(2131719882));
        this.checkUpdateItemView.postDelayed(new SettingAboutActivity.4(this), 300L);
      }
      localUITableView.setClickListener(this.appRelationListOnClickListener);
      localUITableView.commit();
      localLinearLayout.addView(localUITableView);
      findViewById(2131362838).setOnClickListener(new SettingAboutActivity.5(this));
      ((TextView)findViewById(2131365458)).setText(String.format(getString(2131719637), new Object[] { Integer.valueOf(Calendar.getInstance().get(1)) }));
      return;
      this.splashListItemView.setVisibility(8);
    }
  }
  
  public void initUI()
  {
    setContentView(2131558515);
  }
  
  public void onBackPressed()
  {
    if ((!StringExtention.isNullOrEmpty(this.from)) && (this.from.equals(FROM_BETA)))
    {
      Intent localIntent = SettingActivity.createIntent("from_none");
      localIntent.addFlags(65536);
      startActivity(localIntent);
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render()
  {
    setCheckUpdateItemView();
    if (((QMPushConfigUtil.showUpgradeVersion()) || (QMPushConfigUtil.showBetaVersion())) && (!QMSettingManager.sharedInstance().getNewVersionRead())) {
      QMSettingManager.sharedInstance().setNewVersionRead(true);
    }
  }
  
  public static class DownloadReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      for (;;)
      {
        int i;
        try
        {
          if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
          {
            long l = paramIntent.getLongExtra("extra_download_id", -1L);
            if ((SettingAboutActivity.downloadIdList != null) && (SettingAboutActivity.downloadIdList.size() > 0))
            {
              paramIntent = SettingAboutActivity.downloadIdList.iterator();
              if (paramIntent.hasNext())
              {
                if (l != ((Long)paramIntent.next()).longValue()) {
                  continue;
                }
                QMLog.log(4, "SettingAboutActivity", "new apk download complete");
                Cursor localCursor = ((DownloadManager)paramContext.getSystemService("download")).query(new DownloadManager.Query().setFilterById(new long[] { l }));
                if (localCursor == null) {
                  continue;
                }
                if (localCursor.moveToFirst())
                {
                  Uri localUri = Uri.parse(localCursor.getString(localCursor.getColumnIndex("local_uri")));
                  i = localCursor.getInt(localCursor.getColumnIndex("status"));
                  if (i != 8) {
                    break label235;
                  }
                  SettingAboutActivity.downloadIdList.clear();
                  Intent localIntent = new Intent("android.intent.action.VIEW");
                  localIntent.setDataAndType(localUri, "application/vnd.android.package-archive");
                  localIntent.addFlags(268435456);
                  paramContext.startActivity(localIntent);
                }
                localCursor.close();
                continue;
              }
            }
          }
          return;
        }
        catch (Exception paramContext)
        {
          QMLog.log(6, "SettingAboutActivity", Log.getStackTraceString(paramContext));
        }
        label235:
        if (i == 16) {
          SettingAboutActivity.downloadIdList.clear();
        }
      }
    }
  }
  
  class PushConfigBuilder
    extends QMUIDialogBuilder<PushConfigBuilder>
  {
    QMPushConfigDialog mQMPushConfigDialog;
    
    public PushConfigBuilder(Context paramContext, QMPushConfigDialog paramQMPushConfigDialog)
    {
      super();
      this.mQMPushConfigDialog = paramQMPushConfigDialog;
    }
    
    public void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      paramQMUIDialog = new LinearLayout(this.mContext);
      paramQMUIDialog.setOrientation(1);
      paramQMUIDialog.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramQMUIDialog.setPadding(this.mContext.getResources().getDimensionPixelSize(2131298544), this.mContext.getResources().getDimensionPixelSize(2131298538), this.mContext.getResources().getDimensionPixelSize(2131298544), QMUIKit.dpToPx(16));
      Object localObject1 = SettingAboutActivity.this.generateTitleTextView();
      ((TextView)localObject1).setText(this.mQMPushConfigDialog.getDespTitle());
      paramQMUIDialog.addView((View)localObject1);
      localObject1 = this.mQMPushConfigDialog.getDespLines();
      Object localObject2;
      if (localObject1 != null)
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = new LinearLayout(SettingAboutActivity.this);
          ((LinearLayout)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout)localObject2).setGravity(48);
          TextView localTextView = SettingAboutActivity.this.generateConTextView();
          localTextView.setText(i + 1 + SettingAboutActivity.this.period);
          ((LinearLayout)localObject2).addView(localTextView);
          localTextView = SettingAboutActivity.this.generateConTextView();
          localTextView.setText((CharSequence)((List)localObject1).get(i));
          ((LinearLayout)localObject2).addView(localTextView);
          paramQMUIDialog.addView((View)localObject2);
          i += 1;
        }
      }
      localObject1 = this.mQMPushConfigDialog.getTips();
      if (!StringExtention.isNullOrEmpty((String)localObject1))
      {
        localObject2 = SettingAboutActivity.this.generateTipTextView();
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setGravity(17);
        paramQMUIDialog.addView((View)localObject2);
      }
      paramViewGroup.addView(paramQMUIDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAboutActivity
 * JD-Core Version:    0.7.0.1
 */