package com.tencent.qqmail.attachment.activity;

import Override;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.TextUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;

public class ZipInnerAttachDownloadActivity
  extends BaseActivityEx
{
  private static final String ARG_ATTACH = "attach";
  private static final String ARG_FID = "fid";
  private static final String ARG_FTN_FILE_DIR_PATH = "ftnFileDirPath";
  private static final String ARG_PACKAGE_NAME = "packageName";
  private static final int REQUEST_CODE_SAVE_AS = 1;
  private static final String RESULT_FILE_PATH = "filePath";
  public static final String TAG = "CompressFilePreviewDownloadActivity";
  private Animation animBarGone;
  private Animation animBarVisible;
  private Attach attach;
  private MailBigAttach bigAttach;
  private ViewGroup container;
  private ToggleButton downloadToggleBtn;
  private String downloadUrl = "";
  private String fid;
  private String filePath;
  private String ftnFileDirPath;
  private Intent intent;
  private boolean isPageError;
  private String packageName;
  private View previewContainer;
  private int previewType = 2;
  private ProgressBar progressBar;
  private TextView progressTextView;
  private QMTips qmTips;
  private QMTopBar topBar;
  private WebView webView;
  
  private boolean canDirDownload()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((isFileTypeImage()) || (QMNetworkUtils.isNetworkConnected())) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!QMNetworkUtils.isMobileConnected());
      bool1 = bool2;
    } while (StringExtention.sizeStrToLong(this.attach.getSize()) <= 2097152L);
    return false;
  }
  
  private void chooseSaveAsPath()
  {
    Intent localIntent = this.intent.setClass(this, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("iscomplete", 1);
    localIntent.putExtra("url", this.filePath);
    localIntent.putExtra("attachfile", this.attach);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 1);
  }
  
  public static Intent createIntentForMailBig(Context paramContext, MailBigAttach paramMailBigAttach, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new Intent(paramContext, ZipInnerAttachDownloadActivity.class);
    paramContext.putExtra("attach", paramMailBigAttach);
    paramContext.putExtra("fid", paramString1);
    paramContext.putExtra("packageName", paramString2);
    paramContext.putExtra("ftnFileDirPath", paramString3);
    return paramContext;
  }
  
  public static Intent createIntentForNormal(Context paramContext, Attach paramAttach)
  {
    paramContext = new Intent(paramContext, ZipInnerAttachDownloadActivity.class);
    paramContext.putExtra("attach", paramAttach);
    return paramContext;
  }
  
  private void doDownload()
  {
    renderProgressBar();
    Attach localAttach = this.attach;
    if (isMaiBigZip()) {}
    for (Object localObject = generateBigZipInnerAttachKey();; localObject = this.downloadUrl)
    {
      localObject = DownloadUtil.createDownloadInfoForZipInnerAttach(localAttach, (String)localObject);
      ((DownloadInfo)localObject).setAttachDownloadListener(new ZipInnerAttachDownloadActivity.10(this));
      AttachDownloadManager.shareInstance().fetchAttach((DownloadInfo)localObject);
      return;
    }
  }
  
  private void doOpenBy()
  {
    IntentUtil.openFile(this, this.filePath, this.attach.getSuffix(), AttachPreviewType.MailNormalAttachPreview);
  }
  
  private void doOpenDownloadManager()
  {
    startActivity(DownloadActivity.createIntent());
    DataCollector.logEvent("Event_Enter_DownloadManager");
  }
  
  private void handleDownloadSuccess()
  {
    if (this.previewType == 0)
    {
      toPreviewSelfOpen(this.filePath, this.attach.getPreview().getItype());
      return;
    }
    if ((this.previewType == 1) || (isFileTypeMedia()))
    {
      renderOpenByView();
      doOpenBy();
      return;
    }
    renderCanNotOpenFileView();
  }
  
  private void handleProgressBar(long paramLong1, long paramLong2)
  {
    resetLayout();
    findViewById(2131373659).setVisibility(0);
    findViewById(2131373659).setVisibility(0);
    findViewById(2131382442).setVisibility(8);
    if (this.progressBar.getMax() == 100) {
      this.progressBar.setMax((int)paramLong1);
    }
    this.progressBar.setProgress((int)StringExtention.sizeStrToLong(this.attach.getState().getDownloadSize()));
    this.progressTextView.setText(StringExtention.getHumanReadableSizeString(paramLong2) + " / " + StringExtention.getHumanReadableSizeString(paramLong1));
  }
  
  private void hideTopBarRight()
  {
    this.topBar.getButtonRight().setVisibility(8);
  }
  
  private void init()
  {
    if (this.attach != null)
    {
      if ((!FileUtil.isFileDir(this.filePath)) && (FileUtil.isFileExist(this.filePath)))
      {
        if (this.previewType == 0) {
          toPreviewSelfOpen(this.filePath, this.attach.getPreview().getItype());
        }
        for (;;)
        {
          showTopBarRight();
          return;
          if ((this.previewType == 1) || (isFileTypeMedia()))
          {
            renderOpenByView();
            doOpenBy();
          }
          else
          {
            renderCanNotOpenFileView();
          }
        }
      }
      if (this.previewType == 2) {
        renderDownloadView(false);
      }
      for (;;)
      {
        hideTopBarRight();
        return;
        if (canDirDownload()) {
          doDownload();
        } else {
          renderDownloadView(true);
        }
      }
    }
    QMUIHelper.showToast(this, 2131695454, "");
  }
  
  private void initData()
  {
    this.intent = getIntent();
    this.attach = ((Attach)this.intent.getSerializableExtra("attach"));
    if (this.attach == null)
    {
      finish();
      return;
    }
    if ((this.attach instanceof MailBigAttach))
    {
      this.bigAttach = ((MailBigAttach)this.attach);
      this.fid = this.intent.getStringExtra("fid");
      this.packageName = this.intent.getStringExtra("packageName");
      this.ftnFileDirPath = this.intent.getStringExtra("ftnFileDirPath");
    }
    this.downloadUrl = this.attach.getPreview().getDownloadUrl();
    this.previewType = QMAttachUtils.getPreviewType(this, FileUtil.getFileNameSuffix(this.attach.getName()));
    DownloadInfo localDownloadInfo;
    if (isMaiBigZip())
    {
      localDownloadInfo = DownloadInfoManager.shareInstance().getDownloadInfoByKey(generateBigZipInnerAttachKey());
      if (localDownloadInfo == null) {
        break label210;
      }
      this.attach.getState().setDownloadSize(StringExtention.getHumanReadableSizeString(localDownloadInfo.getDownloadSize()));
      this.attach.getPreview().setMyDisk(localDownloadInfo.getFilePath());
    }
    for (;;)
    {
      this.filePath = this.attach.getPreview().getMyDisk();
      return;
      localDownloadInfo = DownloadInfoManager.shareInstance().getDownloadInfoByKey(this.downloadUrl);
      break;
      label210:
      this.attach.getPreview().setMyDisk("");
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(this.attach.getName());
    this.topBar.getTitleView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ZipInnerAttachDownloadActivity.1(this));
    this.topBar.setButtonRightIcon(2130841095);
    this.topBar.getButtonRight().setEnabled(true);
    this.topBar.getButtonRight().setOnClickListener(new ZipInnerAttachDownloadActivity.2(this));
  }
  
  private void initView()
  {
    if (this.attach == null)
    {
      finish();
      return;
    }
    Object localObject = new QMLoading(getApplicationContext(), QMLoading.SIZE_MINI);
    ((RelativeLayout)findViewById(2131370787)).addView((View)localObject);
    initTopBar();
    this.qmTips = new QMTips(this);
    this.webView = ((WebView)findViewById(2131382171));
    this.webView.setVisibility(8);
    if ((!FileUtil.isFileDir(this.filePath)) && (FileUtil.isFileExist(this.filePath))) {
      this.topBar.getButtonRight().setVisibility(0);
    }
    for (;;)
    {
      this.animBarGone = AnimationUtils.loadAnimation(this, 2130772037);
      this.animBarVisible = AnimationUtils.loadAnimation(this, 2130772038);
      this.container = ((ViewGroup)findViewById(2131373572));
      this.container.setOnClickListener(new ZipInnerAttachDownloadActivity.4(this));
      this.container.setVisibility(8);
      this.previewContainer = findViewById(2131382447);
      this.previewContainer.setVisibility(0);
      ((ImageView)findViewById(2131382443)).setImageResource(ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(this.attach.getName()), ImageResourceUtil.IMAGE_SIZE_124));
      ((TextView)findViewById(2131382441)).setText(this.attach.getName());
      localObject = (TextView)findViewById(2131382442);
      String str = StringExtention.getHumanReadable(StringExtention.sizeStrToLong(this.attach.getSize()));
      ((TextView)localObject).setText(str);
      TextUtil.setFileInfoTextStyle((TextView)localObject, getString(2131694060), str);
      this.progressBar = ((ProgressBar)findViewById(2131382445));
      this.progressBar.setMax((int)StringExtention.sizeStrToLong(this.attach.getSize()));
      this.progressTextView = ((TextView)findViewById(2131382446));
      this.downloadToggleBtn = ((ToggleButton)findViewById(2131373690));
      this.downloadToggleBtn.setOnCheckedChangeListener(new ZipInnerAttachDownloadActivity.5(this));
      findViewById(2131382104).setOnClickListener(new ZipInnerAttachDownloadActivity.6(this));
      findViewById(2131366067).setOnClickListener(new ZipInnerAttachDownloadActivity.7(this));
      findViewById(2131372676).setOnClickListener(new ZipInnerAttachDownloadActivity.8(this));
      return;
      this.topBar.getButtonRight().setVisibility(8);
    }
  }
  
  private boolean isFileTypeAudio()
  {
    return this.attach.getPreview().getItype() == AttachType.AUDIO;
  }
  
  private boolean isFileTypeImage()
  {
    return this.attach.getPreview().getItype() == AttachType.IMAGE;
  }
  
  private boolean isFileTypeMedia()
  {
    return (isFileTypeAudio()) || (isFileTypeVideo());
  }
  
  private boolean isFileTypeVideo()
  {
    return this.attach.getPreview().getItype() == AttachType.VIDEO;
  }
  
  private boolean isMaiBigZip()
  {
    return (this.bigAttach != null) && (!StringExtention.isNullOrEmpty(this.fid)) && (!StringExtention.isNullOrEmpty(this.packageName));
  }
  
  private void openFileDir()
  {
    if (StringExtention.isNullOrEmpty(this.attach.getPreview().getMyDisk()))
    {
      Toast.makeText(getActivity(), getString(2131692956), 0).show();
      return;
    }
    IntentUtil.openAttachFileLocation(getActivity(), this.attach.getPreview().getMyDisk());
  }
  
  private void previewSelfOpen(String paramString, AttachType paramAttachType, RelativeLayout.LayoutParams paramLayoutParams, RelativeLayout paramRelativeLayout)
  {
    try
    {
      QMUIHelper.setZoomControlGone(this.webView);
      this.webView.setVisibility(0);
      this.webView.setWebViewClient(new WabClient(null));
      this.webView.getSettings().setAllowFileAccess(true);
      this.webView.getSettings().setLoadsImagesAutomatically(true);
      this.webView.getSettings().setSavePassword(false);
      this.webView.getSettings().setSaveFormData(false);
      this.webView.getSettings().setJavaScriptEnabled(false);
      this.webView.getSettings().setDefaultTextEncodingName("GBK");
      if (paramAttachType == AttachType.HTML) {
        this.webView.setInitialScale(40);
      }
      this.webView.getSettings().setSupportZoom(true);
      this.webView.getSettings().setBuiltInZoomControls(true);
      this.webView.getSettings().setAppCacheEnabled(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      this.webView.loadUrl(StringExtention.replaceIllegalUrl(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QMUIHelper.showToast(this, 2131696497, "文件过大，请重新加载！");
    }
  }
  
  private void renderCanNotOpenFileView()
  {
    resetLayout();
    findViewById(2131371113).setVisibility(0);
    findViewById(2131371114).setVisibility(0);
    findViewById(2131371114).setOnClickListener(new ZipInnerAttachDownloadActivity.9(this));
  }
  
  private void renderDownloadView(boolean paramBoolean)
  {
    resetLayout();
    findViewById(2131366066).setVisibility(0);
    if (!paramBoolean)
    {
      findViewById(2131371113).setVisibility(0);
      findViewById(2131371114).setVisibility(8);
      findViewById(2131364220).setVisibility(0);
    }
  }
  
  private void renderOpenByView()
  {
    resetLayout();
    findViewById(2131372675).setVisibility(0);
    this.topBar.getButtonRight().setEnabled(true);
  }
  
  private void renderProgressBar()
  {
    resetLayout();
    findViewById(2131373659).setVisibility(0);
    findViewById(2131373659).setVisibility(0);
    findViewById(2131382442).setVisibility(8);
    String str;
    if (isMaiBigZip())
    {
      str = generateBigZipInnerAttachKey();
      DownloadInfo localDownloadInfo = AttachDownloadManager.shareInstance().getDownloadInfoByKey(str);
      if (localDownloadInfo == null) {
        break label109;
      }
      this.attach.getState().setDownloadSize(StringExtention.getHumanReadableSizeString(localDownloadInfo.getDownloadSize()));
    }
    for (;;)
    {
      this.progressBar.setProgress((int)StringExtention.sizeStrToLong(this.attach.getState().getDownloadSize()));
      return;
      str = this.downloadUrl;
      break;
      label109:
      this.attach.getState().setDownloadSize(StringExtention.getHumanReadable(DownloadFileUtil.getTmpFileSize(DownloadUtil.getDownloadTaskId(str))));
    }
  }
  
  private void resetLayout()
  {
    findViewById(2131370787).setVisibility(8);
    findViewById(2131373659).setVisibility(8);
    findViewById(2131372675).setVisibility(8);
    findViewById(2131366066).setVisibility(8);
    findViewById(2131382103).setVisibility(8);
    findViewById(2131371113).setVisibility(8);
    findViewById(2131382442).setVisibility(0);
  }
  
  private void showFileErrorTips()
  {
    QMUIHelper.showToast(this, 2131693718, "");
  }
  
  private void showMoreDialog(View paramView)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131690582));
    ((List)localObject).add(getString(2131690558));
    localObject = new ZipInnerAttachDownloadActivity.3(this, this, paramView, new PopupAdapter(this, 2131559771, 2131373495, (List)localObject));
    ((QMPopupWindow)localObject).setAnchor(paramView);
    ((QMPopupWindow)localObject).showDown();
  }
  
  private void showNetworkBusyTips()
  {
    QMUIHelper.showToast(this, 2131696289, "");
  }
  
  private void showNetworkTips()
  {
    this.downloadToggleBtn.setChecked(false);
    QMUIHelper.showToast(this, 2131696288, "");
  }
  
  private void showSpaceLimitTips()
  {
    this.downloadToggleBtn.setChecked(false);
    QMUIHelper.showToast(this, 2131719260, "");
  }
  
  private void showTopBarRight()
  {
    this.topBar.getButtonRight().setVisibility(0);
  }
  
  private void showZipDownloadTips()
  {
    this.downloadToggleBtn.setChecked(false);
    QMUIHelper.showToast(this, 2131694082, "");
  }
  
  public String generateBigZipInnerAttachKey()
  {
    return this.fid + "&" + this.packageName + "&" + this.ftnFileDirPath;
  }
  
  public void initDataSource()
  {
    initData();
  }
  
  public void initDom()
  {
    initView();
    init();
  }
  
  public void initUI()
  {
    getWindow().addFlags(128);
    setContentView(2131558525);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt1 == 1))
    {
      paramIntent = FileUtil.getParentPath(paramIntent.getStringExtra("filePath"));
      if (FileUtil.isFileExist(this.filePath)) {
        DownloadUtil.existFileSaveAs(this.attach, paramIntent, false);
      }
    }
  }
  
  public void onBackground()
  {
    super.onBackground();
    AttachDownloadManager localAttachDownloadManager = AttachDownloadManager.shareInstance();
    if (isMaiBigZip()) {}
    for (String str = generateBigZipInnerAttachKey();; str = this.downloadUrl)
    {
      localAttachDownloadManager.abort(str);
      return;
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  public void setVisibilityOfBar()
  {
    if (this.topBar.getVisibility() == 0)
    {
      this.topBar.setVisibility(8);
      this.topBar.startAnimation(this.animBarGone);
      return;
    }
    this.topBar.setVisibility(0);
    this.topBar.startAnimation(this.animBarVisible);
  }
  
  public void toPreviewSelfOpen(String paramString, AttachType paramAttachType)
  {
    if ((this.attach != null) && (FileUtil.hasSdcard()))
    {
      this.filePath = paramString;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      previewSelfOpen("file://" + paramString, paramAttachType, localLayoutParams, null);
      return;
    }
    QMUIHelper.showToast(this, 2131719246, "");
  }
  
  class WabClient
    extends BaseSafeWebViewClient
  {
    private WabClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      super.onSafePageFinished(paramWebView, paramString);
    }
    
    public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (!ZipInnerAttachDownloadActivity.this.isPageError)
      {
        ZipInnerAttachDownloadActivity.access$1802(ZipInnerAttachDownloadActivity.this, true);
        QMUIHelper.showToast(ZipInnerAttachDownloadActivity.this, 2131696497, "附件文本格式不兼容，将使用兼容格式打开");
        paramWebView.loadDataWithBaseURL(paramString2, FileUtil.file2String(ZipInnerAttachDownloadActivity.this.filePath), "text/html", "GBK", paramString2);
        return;
      }
      QMUIHelper.showToast(ZipInnerAttachDownloadActivity.this, 2131696497, "不支持该附件原本格式,请尝试使用其他应用打开");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity
 * JD-Core Version:    0.7.0.1
 */