package com.tencent.qqmail.attachment.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.reademl.QMReadEmlActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.animation.SlideViewAnimation.SlideAction;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderFileInfoView;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.FileCharsetDetector;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.io.File;
import java.util.Date;
import moai.core.utilities.Utils;
import moai.oss.OssHelper;

public class AttachFolderPreviewActivity
  extends BaseActivityEx
{
  private static final String ARG_ATTACH = "attach";
  public static final int PW_NO_FAV = 2;
  public static final int PW_ONLY_FAV = 1;
  private static final int REQUEST_CODE_ATTACH_SAVE_AS = 100;
  public static final String TAG = "AttachFolderPreviewActivity";
  public static Attach paramAttach;
  private int accountId;
  private Attach attach;
  private AttachFolderFileInfoView attachInfoLayout;
  private QMBaseView baseView;
  private QMBottomBar bottomBar;
  private ToggleButton downloadButton;
  private String downloadDir = FileUtil.getAttachDownloadDir();
  private String downloadUrl;
  private boolean isFromEml;
  private boolean isFromICS;
  private boolean isRenderInfo;
  private long lastProgressTime;
  private AttachDownloadManager mAttachDownloadManager;
  private Intent mIntent;
  private View.OnClickListener onFavorite = new AttachFolderPreviewActivity.11(this);
  private View.OnClickListener onMore = new AttachFolderPreviewActivity.12(this);
  private int previewType = 1;
  private ProgressBar progressBar;
  private TextView progressTextView;
  private QMTips qmTips;
  private View scrollView;
  private SlideViewAnimation slideViewAnim;
  private QMTopBar topBar;
  private ViewFlipper viewFlipper;
  private WebView webView;
  
  private void backToMail()
  {
    long l = this.mIntent.getLongExtra("id", 0L);
    int i = this.mIntent.getIntExtra("accountId", 0);
    int j = this.mIntent.getIntExtra("folderId", 0);
    Object localObject = this.mIntent.getStringExtra("subject");
    String str1 = this.mIntent.getStringExtra("fromnickname");
    String str2 = this.mIntent.getStringExtra("fromaddress");
    localObject = MailFragmentActivity.createIntentToReadmailFromPush(i, j, l, this.mIntent.getStringExtra("remoteid"), (String)localObject, str1, str2, false, false, true);
    overridePendingTransition(2130772421, 2130772420);
    startActivity((Intent)localObject);
  }
  
  private boolean canOnlinePreview()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.attach != null)
    {
      bool1 = bool2;
      if (FileUtil.isCompressSuffix(FileUtil.getFileNameSuffix(this.attach.getName())))
      {
        bool1 = bool2;
        if (!this.attach.isProtocol()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static Intent createIntentToPreview(Context paramContext, Attach paramAttach1)
  {
    paramContext = new Intent(paramContext, AttachFolderPreviewActivity.class);
    paramAttach = paramAttach1;
    return AttachFolderHelper.setBackToMail(paramAttach1, paramContext);
  }
  
  private void doOnlinePreview()
  {
    startActivity(ZipOnlinePreviewActivity.createIntentForNormalAttach(this.attach, String.valueOf(this.attach.getBelongMailId())));
  }
  
  private void doOpenDownloadManager()
  {
    QMAttachUtils.attachOpenOssLog(String.valueOf(this.attach.getHashId()), this.attach.getPreview().getMyDisk());
    startActivity(DownloadActivity.createIntent());
    DataCollector.logEvent("Event_Enter_DownloadManager");
  }
  
  private void doOpenFile()
  {
    String str = this.attach.getPreview().getMyDisk();
    QMAttachUtils.attachOpenOssLog(String.valueOf(this.attach.getHashId()), str);
    if (this.isFromEml)
    {
      startActivity(QMReadEmlActivity.createIntentFromEml(this.accountId, this.attach, true, false));
      overridePendingTransition(2130772422, 2130772419);
      OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", "eml", "" });
      return;
    }
    if (this.isFromICS)
    {
      startActivity(MailFragmentActivity.createIntentToReadIcsEvent(str));
      OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", "ics", "" });
      return;
    }
    IntentUtil.openFile(this, str, this.attach.getSuffix(), AttachPreviewType.MailNormalAttachPreview);
  }
  
  private void doSaveToWeiYun()
  {
    if (StringExtention.sizeStrToLong(this.attach.getSize()) >= 1073741824L)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new AttachFolderPreviewActivity.2(this))).create().show();
      return;
    }
    startActivity(AttachSaveToWeiYunActivity.createIntent(this.attach, false, this.accountId, true, false, false));
    getActivity().overridePendingTransition(2130772401, 2130772430);
  }
  
  private AttachDownloadListener getAttachDownloadListener()
  {
    return new AttachFolderPreviewActivity.1(this);
  }
  
  private int getInitialScale()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay();
    switch (localDisplayMetrics.densityDpi)
    {
    }
    return 150;
  }
  
  private void handleDownloadOrPreview()
  {
    if (!isFileDownloadDirReady()) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.mAttachDownloadManager.getStatusByKey(this.downloadUrl);
      } while (this.attach == null);
      if (this.attach.isExist())
      {
        QMLog.log(4, "AttachFolderPreviewActivity", "attach has downloaded:" + this.attach.getName());
        endDownload(this.attach);
        return;
      }
      if (i == 2)
      {
        QMLog.log(4, "AttachFolderPreviewActivity", "attach is downloading:" + this.attach.getName());
        AttachDownloadManager.shareInstance().addAttachDownloadListener(this.downloadUrl, getAttachDownloadListener());
        return;
      }
      renderDownloadView();
    } while (this.previewType != 2);
    renderTipsView(canOnlinePreview());
  }
  
  private void initAll(Intent paramIntent)
  {
    initData(paramIntent);
    initView();
    init();
  }
  
  private void initBottomBar()
  {
    if (this.bottomBar == null)
    {
      this.bottomBar = new QMBottomBar(this);
      this.baseView.addView(this.bottomBar);
      this.bottomBar.addButton(2130840805, this.onFavorite).setId(2131366721);
      this.bottomBar.addButton(2130840806, this.onMore).setId(2131366724);
      this.bottomBar.getBottomBarButton(0).setContentDescription(getString(2131720833));
      this.bottomBar.getBottomBarButton(1).setContentDescription(getString(2131720837));
    }
  }
  
  private void initData(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    this.mAttachDownloadManager = AttachDownloadManager.shareInstance();
    this.attach = paramAttach;
    paramAttach = null;
    if (this.attach == null)
    {
      finish();
      return;
    }
    paramIntent = FileUtil.getFileNameSuffix(this.attach.getName());
    this.attach.setSuffix(paramIntent);
    paramIntent = AttachType.valueOf(QMAttachUtils.attachFileType(paramIntent));
    this.attach.getPreview().setItype(paramIntent);
    this.accountId = this.attach.getAccountId();
    this.downloadUrl = DownloadUtil.getDownloadUrl(this.attach);
    this.isFromEml = AttachToolbox.isAttachEml(this.attach.getName());
    this.isFromICS = AttachToolbox.isAttachICS(this.attach.getName());
    this.previewType = FileUtil.getOpenType(this, this.attach.getSuffix());
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setTitle(this.attach.getName());
    this.topBar.setButtonLeftBack();
    this.topBar.setButtonLeftOnclickListener(new AttachFolderPreviewActivity.9(this));
    this.topBar.setButtonRightIcon(2130841093);
    this.topBar.getButtonRight().setContentDescription(getString(2131720857));
    this.topBar.setButtonRightOnclickListener(new AttachFolderPreviewActivity.10(this));
  }
  
  private void initView()
  {
    if (this.attach == null)
    {
      finish();
      return;
    }
    this.qmTips = new QMTips(this);
    initTopBar();
    resetBottomBar();
    initBottomBar();
    ((TextView)findViewById(2131363040)).setText(this.attach.getSize());
    this.scrollView = findViewById(2131377766);
    this.webView = ((WebView)findViewById(2131382171));
    this.attachInfoLayout = ((AttachFolderFileInfoView)findViewById(2131367056));
    int i = ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(this.attach.getName()), ImageResourceUtil.IMAGE_SIZE_58);
    if (i != -1) {
      this.attachInfoLayout.setFileThumbDrawable(i);
    }
    String[] arrayOfString = DateExtension.fullDateName_yyyyMMddHHmm(new Date(this.attach.getFavTime())).split(" ");
    this.attachInfoLayout.setSendTime(arrayOfString[0]);
    this.attachInfoLayout.setFileName(this.attach.getName());
    this.attachInfoLayout.setSender(this.attach.getMailSender());
    this.attachInfoLayout.setSubject(this.attach.getMailSubject());
    this.attachInfoLayout.setFileSize(this.attach.getSize());
    this.attachInfoLayout.setBackToMailOnClickListener(new AttachFolderPreviewActivity.6(this));
    this.viewFlipper = ((ViewFlipper)findViewById(2131381892));
    this.viewFlipper.setBackgroundResource(2131167682);
    this.viewFlipper.removeView(this.webView);
    this.slideViewAnim = new SlideViewAnimation(new AttachInfoSlideAction(null));
    this.downloadButton = ((ToggleButton)findViewById(2131363045));
    this.downloadButton.setOnCheckedChangeListener(new AttachFolderPreviewActivity.7(this));
    this.progressTextView = ((TextView)findViewById(2131363043));
    this.progressTextView.setText("0 / " + this.attach.getSize().replace("字节", "B"));
    this.progressBar = ((ProgressBar)findViewById(2131363042));
    ((ImageView)findViewById(2131363041)).setImageResource(ImageResourceUtil.getImageResource(this.attach.getPreview().getItype().name(), ImageResourceUtil.IMAGE_SIZE_124));
    ((TextView)findViewById(2131363039)).setText(this.attach.getName());
  }
  
  private void initWebView(AttachType paramAttachType, String paramString)
  {
    this.webView = new QMWebView(getActivity());
    QMUIHelper.setZoomControlGone(this.webView);
    this.webView.setHorizontalScrollBarEnabled(true);
    this.webView.setVisibility(0);
    this.webView.setWebViewClient(new AttachFolderPreviewActivity.8(this));
    this.webView.getSettings().setAllowFileAccess(true);
    this.webView.getSettings().setLoadsImagesAutomatically(true);
    this.webView.getSettings().setSavePassword(false);
    this.webView.getSettings().setSaveFormData(false);
    this.webView.getSettings().setJavaScriptEnabled(false);
    this.webView.getSettings().setDefaultTextEncodingName(paramString);
    this.webView.getSettings().setSupportZoom(true);
    this.webView.getSettings().setBuiltInZoomControls(true);
    this.webView.getSettings().setAppCacheEnabled(false);
    this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.webView.getSettings().setUseWideViewPort(true);
    if (paramAttachType == AttachType.HTML) {
      this.webView.setInitialScale(getInitialScale());
    }
    if (Utils.hasHoneycomb()) {
      this.webView.setLayerType(1, null);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.viewFlipper.removeView(this.scrollView);
    if (this.webView.getParent() == null) {
      this.viewFlipper.addView(this.webView, 0);
    }
    this.viewFlipper.setDisplayedChild(0);
  }
  
  private boolean isFileDownloadDirReady()
  {
    if (this.downloadDir == null)
    {
      String str = FileUtil.getAttachDownloadDir();
      this.downloadDir = str;
      if (str == null)
      {
        QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download without ready dir" + this.attach.getName());
        renderErrorView(getResources().getString(2131693642));
        return false;
      }
    }
    return true;
  }
  
  private boolean isProtocol()
  {
    if (this.attach != null) {
      return this.attach.isProtocol();
    }
    return false;
  }
  
  private boolean isShowSaveToWeiYun()
  {
    boolean bool2 = false;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    boolean bool1 = bool2;
    if (localAccount != null)
    {
      bool1 = bool2;
      if (localAccount.isQQMail())
      {
        bool1 = bool2;
        if (!localAccount.isBizMail()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void openFileExplorer()
  {
    Intent localIntent = new Intent(getActivity(), SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 100);
  }
  
  private void recoveryProgress()
  {
    if (!isProtocol())
    {
      DownloadInfo localDownloadInfo2 = AttachDownloadManager.shareInstance().getDownloadInfoByKey(this.downloadUrl);
      DownloadInfo localDownloadInfo1 = localDownloadInfo2;
      if (localDownloadInfo2 == null)
      {
        localDownloadInfo1 = new DownloadInfo();
        localDownloadInfo1.setDownloadSize(0L);
      }
      updateDownloadProgress(localDownloadInfo1);
    }
  }
  
  private void renderDownloadView()
  {
    resetLayout();
    findViewById(2131366066).setVisibility(0);
    findViewById(2131366067).setOnClickListener(new AttachFolderPreviewActivity.16(this));
  }
  
  private void renderErrorView(String paramString)
  {
    renderErrorView(paramString, false);
  }
  
  private void renderErrorView(String paramString, boolean paramBoolean)
  {
    resetLayout();
    View localView = findViewById(2131366496);
    localView.setVisibility(0);
    ((TextView)findViewById(2131366515)).setText(paramString);
    if (paramBoolean)
    {
      paramString = (Button)findViewById(2131366068);
      paramString.setVisibility(0);
      paramString.setOnClickListener(new AttachFolderPreviewActivity.14(this, localView));
    }
  }
  
  private void renderGoToManagerView()
  {
    resetLayout();
    findViewById(2131371113).setVisibility(0);
    findViewById(2131371114).setOnClickListener(new AttachFolderPreviewActivity.18(this));
  }
  
  private void renderOpenFileView()
  {
    resetLayout();
    findViewById(2131372675).setVisibility(0);
    findViewById(2131372676).setOnClickListener(new AttachFolderPreviewActivity.17(this));
  }
  
  private void renderProgress()
  {
    resetLayout();
    findViewById(2131372458).setVisibility(0);
  }
  
  private void renderTipsView(boolean paramBoolean)
  {
    findViewById(2131379724).setVisibility(0);
    if (paramBoolean)
    {
      findViewById(2131364247).setVisibility(8);
      findViewById(2131372636).setVisibility(0);
      findViewById(2131372635).setOnClickListener(new AttachFolderPreviewActivity.19(this));
      return;
    }
    findViewById(2131364247).setVisibility(0);
    findViewById(2131372636).setVisibility(8);
  }
  
  private void renderWaitForDownloadView()
  {
    resetLayout();
    findViewById(2131382103).setVisibility(0);
    findViewById(2131382104).setOnClickListener(new AttachFolderPreviewActivity.15(this));
  }
  
  private void resetBottomBar()
  {
    if (this.bottomBar != null)
    {
      View localView1 = this.bottomBar.getBottomBarButton(0);
      View localView2 = this.bottomBar.getBottomBarButton(1);
      if (localView1 != null)
      {
        localView1.setVisibility(0);
        localView1.setEnabled(true);
      }
      if (localView2 != null)
      {
        localView2.setVisibility(0);
        localView2.setEnabled(true);
      }
    }
  }
  
  private void resetLayout()
  {
    View localView = findViewById(2131372458);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131366066);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131372675);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131371113);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131379724);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  private void setBottomBarBtnSelected(View paramView)
  {
    int i = 0;
    if (i < this.bottomBar.getChildCount())
    {
      View localView = this.bottomBar.getBottomBarButton(i);
      if (localView == paramView) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof QMImageButton)) {
          ((QMImageButton)localView).setEnabled(true);
        } else {
          localView.setSelected(false);
        }
      }
    }
  }
  
  private void showBottomSheetDialog(int paramInt)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (paramInt != 1) {
      localBottomListSheetBuilder.addItem(2130840819, getString(2131690550), getString(2131690550));
    }
    if (paramInt != 2)
    {
      if (QMAttachManager.sharedInstance().isAttachFavorite(this.attach.getHashId())) {
        break label217;
      }
      localBottomListSheetBuilder.addItem(2130840824, getString(2131690532), getString(2131690532));
    }
    for (;;)
    {
      if ((paramInt != 1) && (this.attach.isExist()))
      {
        localBottomListSheetBuilder.addItem(2130840836, getString(2131690582), getString(2131690582));
        localBottomListSheetBuilder.addItem(2130840830, getString(2131690558), getString(2131690558));
        localBottomListSheetBuilder.addItem(2130840838, getString(2131690586), getString(2131690586));
      }
      if ((paramInt != 1) && (isShowSaveToWeiYun()) && (DeviceUtil.isQCloudInstalled())) {
        localBottomListSheetBuilder.addItem(2130840840, getString(2131690572), getString(2131690572));
      }
      localBottomListSheetBuilder.setOnSheetItemClickListener(new AttachFolderPreviewActivity.13(this));
      localBottomListSheetBuilder.build().show();
      return;
      label217:
      localBottomListSheetBuilder.addItem(2130840826, getString(2131690535), getString(2131690535));
    }
  }
  
  private void toPreviewInWebView(String paramString, Attach paramAttach1)
  {
    if ((paramAttach1 != null) && (FileUtil.hasSdcard()))
    {
      QMAttachUtils.attachOpenOssLog(String.valueOf(paramAttach1.getHashId()), paramAttach1.getPreview().getMyDisk());
      if (!FileUtil.isFileExist(paramString)) {
        OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", FileUtil.getFileNameSuffix(paramAttach1.getName()), "file not exist" });
      }
      try
      {
        Object localObject1 = new File(paramString);
        Object localObject3 = FileUtil.getFileNameSuffix(paramAttach1.getName());
        Object localObject2 = new FileCharsetDetector().guestFileEncoding((File)localObject1);
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase("UTF-8")) {
          localObject1 = "GBK";
        }
        initWebView(AttachToolbox.getAttachType(paramAttach1), (String)localObject1);
        localObject1 = paramString;
        if (localObject3 != null)
        {
          localObject1 = paramString;
          if (((String)localObject3).equalsIgnoreCase("xml"))
          {
            localObject2 = new File(paramString);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(".txt");
            localObject1 = paramString;
            if (FileUtil.copyFile((File)localObject2, new File(((StringBuilder)localObject3).toString())) == 0) {
              localObject1 = ((StringBuilder)localObject3).toString();
            }
          }
        }
        this.webView.loadUrl("file://" + StringExtention.replaceIllegalUrl((String)localObject1));
        QMLog.log(4, "AttachFolderPreviewActivity", "Preview local file path: " + StringExtention.replaceIllegalUrl((String)localObject1));
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", FileUtil.getFileNameSuffix(paramAttach1.getName()), "" });
        return;
      }
      catch (Exception paramString)
      {
        QMUIHelper.showToast(this, 2131696497, "文件过大，请重新加载！");
        OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", FileUtil.getFileNameSuffix(paramAttach1.getName()), paramString.getMessage() });
        return;
      }
    }
    OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "AttachFolderPreviewActivity", FileUtil.getFileNameSuffix(paramAttach1.getName()), "has no sdcard" });
  }
  
  private void updateDownloadComplete(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      this.attach.getPreview().setMyDisk(paramDownloadInfo.getFilePath());
    }
    Threads.runOnMainThread(new AttachFolderPreviewActivity.4(this));
  }
  
  private void updateDownloadError()
  {
    updateDownloadError(false);
  }
  
  private void updateDownloadError(boolean paramBoolean)
  {
    Threads.runOnMainThread(new AttachFolderPreviewActivity.5(this, paramBoolean));
  }
  
  private void updateDownloadProgress(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      this.attach.getState().setDownloadSize(paramDownloadInfo.getDownloadSize() + "");
    }
    Threads.runOnMainThread(new AttachFolderPreviewActivity.3(this));
  }
  
  public void abortDownload()
  {
    this.mAttachDownloadManager.abort(this.downloadUrl);
  }
  
  public void abortDownload(Attach paramAttach1)
  {
    if (paramAttach1 != null) {
      this.mAttachDownloadManager.abort(this.downloadUrl);
    }
  }
  
  public void directDownload()
  {
    resetLayout();
    boolean bool1;
    boolean bool2;
    if (this.mAttachDownloadManager.getStatusByKey(this.downloadUrl) == 0)
    {
      renderWaitForDownloadView();
      bool1 = QMNetworkUtils.isNetworkConnected(this);
      bool2 = FileUtil.hasSdcard();
      if ((!bool1) || (!bool2)) {
        break label55;
      }
      newDownload();
    }
    label55:
    do
    {
      return;
      renderProgress();
      recoveryProgress();
      break;
      if (!bool1)
      {
        QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download without network:" + this.attach.getName());
        QMUIHelper.showToast(this, 2131696288, "");
        renderErrorView(getResources().getString(2131697131));
        return;
      }
    } while (bool2);
    QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download without sdcard:" + this.attach.getName());
    QMUIHelper.showToast(this, 2131719246, "");
    renderErrorView(getResources().getString(2131697131));
  }
  
  public void downloadAttachWithInfo()
  {
    QMLog.log(4, "AttachFolderPreviewActivity", "download attach with info:" + this.attach.getName());
    this.downloadButton.setChecked(true);
    if (this.attach.isExist())
    {
      endDownload(this.attach);
      return;
    }
    if ((QMNetworkUtils.isNetworkConnected()) && (FileUtil.hasSdcard()))
    {
      DownloadInfo localDownloadInfo = DownloadUtil.createDownloadInfoForNormal(this.attach, "", true);
      localDownloadInfo.setAttachDownloadListener(getAttachDownloadListener());
      this.mAttachDownloadManager.fetchAttach(localDownloadInfo);
      return;
    }
    this.downloadButton.setOnCheckedChangeListener(null);
    renderErrorView(getResources().getString(2131697131));
    if (!QMNetworkUtils.isNetworkConnected(this))
    {
      QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download without network:" + this.attach.getName());
      QMUIHelper.showToast(this, 2131696289, "");
      return;
    }
    QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download without sdcard:" + this.attach.getName());
    QMUIHelper.showToast(this, 2131719246, "");
  }
  
  public void endDownload(Attach paramAttach1)
  {
    QMLog.log(4, "AttachFolderPreviewActivity", "attach end download to open:" + paramAttach1.getName() + ",preview type:" + this.previewType);
    if (this.previewType == 0) {
      toPreviewInWebView(paramAttach1.getPreview().getMyDisk(), paramAttach1);
    }
    do
    {
      return;
      if (this.previewType == 1)
      {
        renderOpenFileView();
        return;
      }
      renderGoToManagerView();
    } while (this.previewType != 2);
    renderTipsView(canOnlinePreview());
  }
  
  public void init()
  {
    if (this.attach == null)
    {
      finish();
      return;
    }
    String str = StringExtention.MD5With32Charactor(this.attach.getBelongMailId() + this.attach.getName() + this.attach.getSize() + this.attach.getPreview().getDownloadUrl());
    Attach localAttach = QMAttachManager.sharedInstance().getAttach(this.attach.getHashId());
    if (localAttach != null)
    {
      localAttach.getPreview().setItype(this.attach.getPreview().getItype());
      localAttach.setSuffix(this.attach.getSuffix());
      this.attach = localAttach;
      this.attach.getState().setKeyName(str);
    }
    handleDownloadOrPreview();
  }
  
  public void initDataSource()
  {
    initData(getIntent());
  }
  
  public void initDom()
  {
    initView();
    init();
  }
  
  public void initUI()
  {
    getWindow().addFlags(128);
    this.baseView = initBaseView(this, 2131558474);
    setContentView(this.baseView);
  }
  
  public void newDownload()
  {
    if (!isFileDownloadDirReady()) {
      return;
    }
    downloadAttachWithInfo();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramIntent == null);
    paramIntent = paramIntent.getStringExtra("savePath");
    Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + paramIntent, 0).show();
    DownloadUtil.existFileSaveAs(this.attach, paramIntent, false);
  }
  
  public void onBackground()
  {
    super.onBackground();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    overridePendingTransition(2130772421, 2130772420);
    return true;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    initAll(paramIntent);
  }
  
  public void onRelease()
  {
    if (this.webView != null)
    {
      this.webView.removeAllViews();
      this.webView.destroy();
      this.webView = null;
    }
    if (this.qmTips != null) {
      this.qmTips.dismissTipsManually();
    }
  }
  
  public void refreshData() {}
  
  public void render() {}
  
  public void restoreDownload()
  {
    if ((this.attach == null) || (!isFileDownloadDirReady())) {
      return;
    }
    downloadAttachWithInfo();
    updateDownloadProgress(null);
  }
  
  class AttachInfoSlideAction
    implements SlideViewAnimation.SlideAction
  {
    private AttachInfoSlideAction() {}
    
    public void slideBottom2TopAction()
    {
      AttachFolderPreviewActivity.access$002(AttachFolderPreviewActivity.this, false);
      AttachFolderPreviewActivity.this.attachInfoLayout.setVisibility(8);
      if (AttachFolderPreviewActivity.this.topBar.getButtonRight() != null)
      {
        AttachFolderPreviewActivity.this.topBar.setButtonRightIconView(2130841093);
        AttachFolderPreviewActivity.this.topBar.getButtonRight().setEnabled(true);
      }
    }
    
    public void slideLeft2RightAction() {}
    
    public void slideRight2LeftAction() {}
    
    public void slideTop2BottomAction()
    {
      AttachFolderPreviewActivity.access$002(AttachFolderPreviewActivity.this, true);
      AttachFolderPreviewActivity.this.attachInfoLayout.setVisibility(0);
      if (AttachFolderPreviewActivity.this.topBar.getButtonRight() != null)
      {
        AttachFolderPreviewActivity.this.topBar.setButtonRightIconView(2130841092);
        AttachFolderPreviewActivity.this.topBar.getButtonRight().setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity
 * JD-Core Version:    0.7.0.1
 */