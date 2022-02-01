package com.tencent.qqmail.ftn.activity;

import Override;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.activity.reademl.QMReadEmlActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.animation.ProgressBarCallback;
import com.tencent.qqmail.animation.RotationAction;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.animation.SlideViewAnimation.SlideAction;
import com.tencent.qqmail.animation.SmoothProgressBar;
import com.tencent.qqmail.attachment.activity.AttachImagePagerActivity;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.activity.DownloadActivity;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnLogicStorage;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.ftn.watcher.FtnDownloadWatcher;
import com.tencent.qqmail.ftn.watcher.FtnGetDownloadUrlWatcher;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.TextUtil;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.FtnFileInformationView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMPopupWindow.PopupMenuItem;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.NoDialWebView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import moai.core.watcher.Watchers;
import moai.oss.OssHelper;

public class FtnAttachmentActivity
  extends BaseActivityEx
  implements RotationAction
{
  private static final String ARG_ATTACH = "attach";
  private static final String ARG_FID = "fid";
  private static final String ARG_FILE_INFO = "fileinfo";
  public static final int REQUEST_CODE_SAVE_FILE = 0;
  private static final int SHOW_DISABLE_DOWNLOAD = 24;
  private static final int SHOW_DOWNLOAD_ON_PROGRESS = 5;
  private static final int SHOW_ENABLE_DOWNLOAD = 25;
  public static final String TAG = "FtnAttachmentActivity";
  private int DOWNLOAD_ERROR_TYPE_ABORT = 3;
  private int accountId = 0;
  private QMBottomBar bottomBar = null;
  private View cannotPreviewTips;
  private QQMailAccount defaultFtnAccount;
  private View downloadBig;
  private LinearLayout downloadFailLayout;
  private Button downloadFileBtn;
  private View.OnClickListener downloadFileClickListener = new FtnAttachmentActivity.19(this);
  private CompoundButton.OnCheckedChangeListener downloadPauseOrContinueClickListener = new FtnAttachmentActivity.20(this);
  private ToggleButton downloadToggleBtn;
  private TextView failText;
  private String fid;
  private FileInfo fileInfo;
  private FtnFileInformationView fileInfoLayout;
  private String filePath;
  private String fileSizeFormat = "";
  private FtnDownloadWatcher ftnDownloadWatcher = new FtnAttachmentActivity.1(this);
  private FtnManager ftnManager;
  private View ftnPreviewContainer;
  private FtnGetDownloadUrlWatcher getDownloadUrlWatcher = new FtnAttachmentActivity.2(this);
  private boolean isDownloadComplete = false;
  private boolean isDownloadFail = false;
  private boolean isPageError = false;
  private boolean isShowInfo = false;
  private boolean isWebViewOpen = false;
  private SafeHandler mHandler = new SafeHandler(this);
  private MailBigAttach mailAttach;
  private View manager;
  private Button managerBtn;
  private View.OnClickListener managerOnClickListener = new FtnAttachmentActivity.22(this);
  private TextView nameTextView;
  private IObserver observerDelFileError = new FtnAttachmentActivity.6(this, null);
  private IObserver observerDelFileSuccess = new FtnAttachmentActivity.5(this, null);
  private IObserver observerGetShareUrlError = new FtnAttachmentActivity.4(this, null);
  private IObserver observerGetShareUrlSuccess = new FtnAttachmentActivity.3(this, null);
  private IObserver observerRenewFileError = new FtnAttachmentActivity.8(this, null);
  private IObserver observerRenewFileSuccess = new FtnAttachmentActivity.7(this, null);
  private Button onlinePreviewBtn;
  private View.OnClickListener onlinePreviewClickListener = new FtnAttachmentActivity.23(this);
  private View onlinePreviewTips;
  private View openFile;
  private Button openFileBtn;
  private View.OnClickListener openFileOnClickListener = new FtnAttachmentActivity.21(this);
  private int previewType = 1;
  private View progress;
  private SmoothProgressBar progressBar;
  private ProgressBarCallback progressBarCallback;
  private TextView progressTextView;
  private QMUIDialog qmDialog;
  private QMTips qmTips;
  private View scrollView;
  private TextView sizeTextView;
  private SlideViewAnimation slideViewAnim;
  private View tips;
  private QMTopBar topBar;
  private ViewFlipper viewFlipper;
  private View waitForDownload;
  private NoDialWebView webView;
  
  private void autoDownload()
  {
    checkFile();
    recoveryProgress();
  }
  
  private int calcProgress(long paramLong1, long paramLong2, double paramDouble)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    return (int)(100L * paramLong1 / paramLong2 * paramDouble);
  }
  
  private int calcProgress(String paramString1, String paramString2, double paramDouble)
  {
    long l = Long.parseLong(paramString2);
    return calcProgress(Long.parseLong(paramString1), l, paramDouble);
  }
  
  private boolean canOnlinePreview()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mailAttach != null)
    {
      bool1 = bool2;
      if (FileUtil.isCompressSuffix(FileUtil.getFileNameSuffix(this.mailAttach.getName())))
      {
        bool1 = bool2;
        if (!this.mailAttach.isProtocol()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void checkFile()
  {
    try
    {
      if (FtnCommonUtils.isBigAttachDownloadComplete(this.mailAttach))
      {
        this.progressTextView.setText(this.fileSizeFormat + "/" + this.fileSizeFormat);
        this.progressBar.setProgressSmooth(100, false);
        doSelfOpen(this.mailAttach.getPreview().getItype());
        return;
      }
      if (StringExtention.isNullOrEmpty(FileUtil.getAttachDownloadDir()))
      {
        QMLog.log(5, "FtnAttachmentActivity", "ftn download without dir ready");
        String str = getString(2131697133);
        Toast.makeText(QMApplicationContext.sharedInstance(), str, 1).show();
        renderDownloadFail(str);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    QMLog.log(4, "FtnAttachmentActivity", "ftn get real download url");
    this.ftnManager.getDownloadUrl(DownloadUtil.createDownloadInfoForFtn(this.mailAttach));
    this.downloadToggleBtn.setEnabled(false);
  }
  
  private QMUIDialog createDeleteDialog()
  {
    QMLog.log(4, "FtnAttachmentActivity", "ftn click delete");
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131692499)).setMessage(2131692506).addAction(2131691246, new FtnAttachmentActivity.16(this))).addAction(0, 2131694052, 2, new FtnAttachmentActivity.15(this))).create();
    localQMUIDialog.setOnDismissListener(new FtnAttachmentActivity.17(this));
    localQMUIDialog.setCanceledOnTouchOutside(true);
    localQMUIDialog.show();
    return localQMUIDialog;
  }
  
  public static Intent createIntentToPreview(Context paramContext, MailBigAttach paramMailBigAttach)
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount == null) {
      throw new IllegalStateException("ftn account null");
    }
    paramMailBigAttach.setAccountId(localQQMailAccount.getId());
    paramContext = new Intent(paramContext, FtnAttachmentActivity.class);
    paramContext.putExtra("attach", paramMailBigAttach);
    paramContext.putExtra("fid", paramMailBigAttach.getFid());
    paramContext.putExtra("fileinfo", paramMailBigAttach.getInfoBytes());
    return paramContext;
  }
  
  private void createMoreDialog(Boolean paramBoolean, boolean paramBoolean1)
  {
    int k = 0;
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    List localList = QMPopupWindow.praseShareMenuItem(2131886085, this);
    boolean bool = DeviceUtil.isQCloudInstalled();
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    int i;
    if ((localObject != null) && (((Account)localObject).isBizMail()))
    {
      i = 1;
      localObject = localList.iterator();
    }
    int j;
    for (;;)
    {
      j = k;
      if (!((Iterator)localObject).hasNext()) {
        break label202;
      }
      j = ((QMPopupWindow.PopupMenuItem)((Iterator)localObject).next()).getButtonId();
      if ((j == 2131367766) && (!paramBoolean.booleanValue()))
      {
        ((Iterator)localObject).remove();
        continue;
        i = 0;
        break;
      }
      if ((j == 2131367768) && (!paramBoolean.booleanValue()) && (!paramBoolean1)) {
        ((Iterator)localObject).remove();
      } else if (j == 2131367769) {
        ((Iterator)localObject).remove();
      } else if ((j == 2131367771) && ((!bool) || (i != 0))) {
        ((Iterator)localObject).remove();
      }
    }
    label202:
    while (j < localList.size())
    {
      localBottomListSheetBuilder.addItem(((QMPopupWindow.PopupMenuItem)localList.get(j)).getIconResId(), ((QMPopupWindow.PopupMenuItem)localList.get(j)).getTitle(), ((QMPopupWindow.PopupMenuItem)localList.get(j)).getTitle());
      j += 1;
    }
    localBottomListSheetBuilder.setOnSheetItemClickListener(new FtnAttachmentActivity.14(this));
    localBottomListSheetBuilder.build().show();
  }
  
  private void createRenewDialog()
  {
    QMLog.log(4, "FtnAttachmentActivity", "ftn click renew");
    String str1 = getString(2131718796) + "为" + getFtnRenewDay() + "天";
    String str2 = getString(2131718797) + "为" + getFtnRenewDay() + "天";
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.addItem(2130840833, str1, str1);
    localBottomListSheetBuilder.addItem(2130840814, str2, str2);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new FtnAttachmentActivity.18(this, str1, str2));
    localBottomListSheetBuilder.build().show();
  }
  
  private void deleteAttach()
  {
    if ((this.fid == null) || (this.fid.equals(""))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fid);
    FtnManager.sharedInstance().delFile(localArrayList);
    showTipsDelFileLoading();
  }
  
  private void doGetShareLink(int paramInt)
  {
    showTipsCopyShareLinkLoading();
    this.ftnManager.getShareUrl(this.fid, this.mailAttach.getName(), this.mailAttach.getKey(), this.mailAttach.getCode(), paramInt);
  }
  
  private void doGoToManager()
  {
    startActivity(DownloadActivity.createIntent());
  }
  
  private void doOnlinePreview()
  {
    startActivity(ZipOnlinePreviewActivity.createIntentForFtnAttach(this.mailAttach, String.valueOf(this.mailAttach.getBelongMailId())));
  }
  
  private void doOpenFile()
  {
    QMAttachUtils.attachOpenOssLog(this.fid, getAttachSavePath());
    Object localObject = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(this.mailAttach.getName()))).name().toLowerCase(Locale.getDefault());
    if (AttachToolbox.isAttachEml(this.mailAttach.getName()))
    {
      localObject = QMReadEmlActivity.createIntentFromEml(this.accountId, this.mailAttach, false, true);
      OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnAttachmentActivity", "eml", "" });
      startActivity((Intent)localObject);
      return;
    }
    if (AttachToolbox.isAttachICS(this.mailAttach.getName()))
    {
      startActivity(MailFragmentActivity.createIntentToReadIcsEvent(this.filePath));
      OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnAttachmentActivity", "ics", "" });
      return;
    }
    if (((String)localObject).equals("image"))
    {
      localObject = new ArrayList(1);
      MediaItemInfo localMediaItemInfo = new MediaItemInfo();
      localMediaItemInfo.setDataPath(getAttachSavePath());
      localMediaItemInfo.setSourcePath(getAttachSavePath());
      localMediaItemInfo.setImageType(3);
      this.mailAttach.getPreview().setMyDisk(getAttachSavePath());
      localMediaItemInfo.setAttach(this.mailAttach);
      localMediaItemInfo.setFileName(this.mailAttach.getName());
      localMediaItemInfo.setBucketName("");
      ((ArrayList)localObject).add(localMediaItemInfo);
      startActivity(AttachImagePagerActivity.createIntent(0, (List)localObject, 0));
      return;
    }
    IntentUtil.openFile(this, getAttachSavePath(), this.mailAttach.getSuffix(), AttachPreviewType.FTNBigAttachPreview);
  }
  
  private void doSaveToWeiYun()
  {
    if (StringExtention.sizeStrToLong(this.mailAttach.getSize()) >= 1073741824L)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new FtnAttachmentActivity.25(this))).create().show();
      return;
    }
    startActivity(AttachSaveToWeiYunActivity.createIntent(this.mailAttach, false, this.accountId, false, true, false));
    getActivity().overridePendingTransition(2130772401, 2130772430);
  }
  
  private void doSelectSavePath()
  {
    Intent localIntent = new Intent(getActivity(), SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 0);
  }
  
  /* Error */
  private void doSelfOpen(AttachType paramAttachType)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 224	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:mailAttach	Lcom/tencent/qqmail/model/qmdomain/MailBigAttach;
    //   4: ifnull +198 -> 202
    //   7: aload_0
    //   8: getfield 308	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:filePath	Ljava/lang/String;
    //   11: invokestatic 1004	com/tencent/qqmail/utilities/fileextention/FileUtil:isFileExist	(Ljava/lang/String;)Z
    //   14: ifne +81 -> 95
    //   17: bipush 10
    //   19: anewarray 880	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 881
    //   27: invokestatic 886	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: iconst_1
    //   34: invokestatic 886	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: ldc 133
    //   42: aastore
    //   43: dup
    //   44: iconst_3
    //   45: ldc 133
    //   47: aastore
    //   48: dup
    //   49: iconst_4
    //   50: ldc 133
    //   52: aastore
    //   53: dup
    //   54: iconst_5
    //   55: ldc 133
    //   57: aastore
    //   58: dup
    //   59: bipush 6
    //   61: ldc 133
    //   63: aastore
    //   64: dup
    //   65: bipush 7
    //   67: ldc 37
    //   69: aastore
    //   70: dup
    //   71: bipush 8
    //   73: aload_0
    //   74: getfield 224	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:mailAttach	Lcom/tencent/qqmail/model/qmdomain/MailBigAttach;
    //   77: invokevirtual 452	com/tencent/qqmail/model/qmdomain/MailBigAttach:getName	()Ljava/lang/String;
    //   80: invokestatic 458	com/tencent/qqmail/utilities/fileextention/FileUtil:getFileNameSuffix	(Ljava/lang/String;)Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: bipush 9
    //   87: ldc_w 1006
    //   90: aastore
    //   91: invokestatic 1009	moai/oss/OssHelper:ftnattachOpenFail	([Ljava/lang/Object;)V
    //   94: return
    //   95: new 1011	java/io/File
    //   98: dup
    //   99: aload_0
    //   100: getfield 308	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:filePath	Ljava/lang/String;
    //   103: invokespecial 1012	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_2
    //   107: aload_0
    //   108: getfield 286	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:fid	Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 308	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:filePath	Ljava/lang/String;
    //   115: invokestatic 846	com/tencent/qqmail/attachment/util/QMAttachUtils:attachOpenOssLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 1014	com/tencent/qqmail/utilities/FileCharsetDetector
    //   121: dup
    //   122: invokespecial 1015	com/tencent/qqmail/utilities/FileCharsetDetector:<init>	()V
    //   125: aload_2
    //   126: invokevirtual 1019	com/tencent/qqmail/utilities/FileCharsetDetector:guestFileEncoding	(Ljava/io/File;)Ljava/lang/String;
    //   129: astore_2
    //   130: aload_2
    //   131: astore_3
    //   132: aload_2
    //   133: ldc_w 1021
    //   136: invokevirtual 784	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +19 -> 158
    //   142: aload_2
    //   143: astore_3
    //   144: aload_2
    //   145: ldc_w 1023
    //   148: invokevirtual 784	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifne +7 -> 158
    //   154: ldc_w 1025
    //   157: astore_3
    //   158: aload_0
    //   159: new 475	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 476	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 1027
    //   169: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: getfield 308	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:filePath	Ljava/lang/String;
    //   176: invokevirtual 480	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 485	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload_3
    //   183: aload_1
    //   184: invokespecial 1031	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:previewSelfOpen	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqmail/attachment/model/AttachType;)V
    //   187: return
    //   188: astore_3
    //   189: ldc_w 1025
    //   192: astore_2
    //   193: aload_3
    //   194: invokevirtual 550	java/lang/Exception:printStackTrace	()V
    //   197: aload_2
    //   198: astore_3
    //   199: goto -41 -> 158
    //   202: bipush 10
    //   204: anewarray 880	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: ldc_w 881
    //   212: invokestatic 886	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: iconst_1
    //   219: invokestatic 886	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: ldc 133
    //   227: aastore
    //   228: dup
    //   229: iconst_3
    //   230: ldc 133
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: ldc 133
    //   237: aastore
    //   238: dup
    //   239: iconst_5
    //   240: ldc 133
    //   242: aastore
    //   243: dup
    //   244: bipush 6
    //   246: ldc 133
    //   248: aastore
    //   249: dup
    //   250: bipush 7
    //   252: ldc 37
    //   254: aastore
    //   255: dup
    //   256: bipush 8
    //   258: aload_0
    //   259: getfield 224	com/tencent/qqmail/ftn/activity/FtnAttachmentActivity:mailAttach	Lcom/tencent/qqmail/model/qmdomain/MailBigAttach;
    //   262: invokevirtual 452	com/tencent/qqmail/model/qmdomain/MailBigAttach:getName	()Ljava/lang/String;
    //   265: invokestatic 458	com/tencent/qqmail/utilities/fileextention/FileUtil:getFileNameSuffix	(Ljava/lang/String;)Ljava/lang/String;
    //   268: aastore
    //   269: dup
    //   270: bipush 9
    //   272: ldc_w 1033
    //   275: aastore
    //   276: invokestatic 1009	moai/oss/OssHelper:ftnattachOpenFail	([Ljava/lang/Object;)V
    //   279: aload_0
    //   280: ldc_w 1034
    //   283: ldc 133
    //   285: invokestatic 1040	com/tencent/qqmail/utilities/ui/QMUIHelper:showToast	(Landroid/content/Context;ILjava/lang/String;)V
    //   288: return
    //   289: astore_3
    //   290: goto -97 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	FtnAttachmentActivity
    //   0	293	1	paramAttachType	AttachType
    //   106	92	2	localObject1	Object
    //   131	52	3	localObject2	Object
    //   188	6	3	localException1	Exception
    //   198	1	3	localObject3	Object
    //   289	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   118	130	188	java/lang/Exception
    //   132	142	289	java/lang/Exception
    //   144	154	289	java/lang/Exception
  }
  
  private void doSendMail()
  {
    FtnCommonUtils.buildComposeData(FtnLogicStorage.getComposeInfos(), this.defaultFtnAccount.getUin(), this.fileInfo);
    startActivity(ComposeMailActivity.createIntentFromFtn(getClass().getName()));
  }
  
  private void doShareLink()
  {
    Threads.runOnMainThread(new FtnAttachmentActivity.24(this));
  }
  
  private void endDownload()
  {
    if (this.previewType == 0)
    {
      prepareWebView();
      doSelfOpen(this.mailAttach.getPreview().getItype());
      return;
    }
    if (this.previewType == 1)
    {
      renderOpenFile();
      return;
    }
    renderGoToManager();
    renderTips(canOnlinePreview());
  }
  
  private void ftnDirectDownload()
  {
    renderProgressBar();
    if (QMNetworkUtils.isNetworkConnected())
    {
      autoDownload();
      return;
    }
    renderDownloadFail(getString(2131697131));
  }
  
  private String getAttachSavePath()
  {
    String str = "";
    FtnDownloadInfo localFtnDownloadInfo = FtnManager.sharedInstance().getDownloadInfo(this.fid);
    if (localFtnDownloadInfo != null) {
      str = localFtnDownloadInfo.getSavePath();
    }
    return str;
  }
  
  private int getFtnRenewDay()
  {
    FtnUserProfile localFtnUserProfile = FtnManager.sharedInstance().getUserProfile(this.defaultFtnAccount.getUin());
    if (localFtnUserProfile == null) {}
    int i;
    do
    {
      return 7;
      i = localFtnUserProfile.getRenewDay();
    } while (i <= 7);
    return i;
  }
  
  private void hideFileInfo()
  {
    this.isShowInfo = false;
    this.fileInfoLayout.setVisibility(8);
  }
  
  private void hideSelfOpen()
  {
    this.isShowInfo = true;
    this.webView.setVisibility(8);
  }
  
  private void init()
  {
    if (FtnCommonUtils.isBigAttachDownloadComplete(this.mailAttach))
    {
      this.isDownloadComplete = true;
      endDownload();
    }
    do
    {
      return;
      renderDownload();
    } while (this.previewType != 2);
    renderTips(canOnlinePreview());
  }
  
  private void initData(Intent paramIntent)
  {
    this.defaultFtnAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    this.fid = paramIntent.getStringExtra("fid");
    this.mailAttach = ((MailBigAttach)paramIntent.getSerializableExtra("attach"));
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    this.accountId = this.mailAttach.getAccountId();
    this.previewType = FileUtil.getOpenType(this, this.mailAttach.getSuffix());
    QMLog.log(4, "FtnAttachmentActivity", "name:" + this.mailAttach.getName() + ",previewType:" + this.previewType);
    try
    {
      paramIntent = paramIntent.getByteArrayExtra("fileinfo");
      if (paramIntent != null)
      {
        this.fileInfo = new FileInfo();
        this.fileInfo.parseFrom(paramIntent);
      }
    }
    catch (IOException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        continue;
        this.filePath = "";
        continue;
        if (StringExtention.isNullOrEmpty(this.fid)) {}
        this.filePath = "";
      }
    }
    this.ftnManager = FtnManager.sharedInstance();
    if ((this.ftnManager != null) && (!StringExtention.isNullOrEmpty(this.fid)))
    {
      paramIntent = this.ftnManager.getDownloadInfo(this.fid);
      if (paramIntent != null)
      {
        this.filePath = paramIntent.getSavePath();
        this.mailAttach.getPreview().setMyDisk(this.filePath);
        try
        {
          this.fileSizeFormat = StringExtention.getHumanReadableSizeString(Long.parseLong(this.mailAttach.getSize()));
          return;
        }
        catch (Exception paramIntent)
        {
          this.fileSizeFormat = this.mailAttach.getSize();
          return;
        }
      }
    }
  }
  
  private void initFootBar()
  {
    QMImageButton localQMImageButton;
    if (this.bottomBar == null)
    {
      this.bottomBar = new QMBottomBar(this);
      ((FrameLayout)findViewById(2131367751)).addView(this.bottomBar);
      localQMImageButton = this.bottomBar.addButton(2130840803, new FtnAttachmentActivity.11(this));
      localQMImageButton.setId(2131367752);
      localQMImageButton.setContentDescription(getString(2131720814));
      localQMImageButton = this.bottomBar.addButton(2130840807, new FtnAttachmentActivity.12(this));
      localQMImageButton.setId(2131367777);
      localQMImageButton.setContentDescription(getString(2131694070));
      if (!FtnCommonUtils.isSupportRenew()) {
        break label159;
      }
      localQMImageButton.setEnabled(true);
    }
    for (;;)
    {
      localQMImageButton = this.bottomBar.addButton(2130840806, new FtnAttachmentActivity.13(this));
      localQMImageButton.setId(2131367773);
      localQMImageButton.setContentDescription(getString(2131720837));
      return;
      label159:
      localQMImageButton.setEnabled(false);
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    this.topBar.setTitle(this.mailAttach.getName());
    this.topBar.getTitleView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new FtnAttachmentActivity.9(this));
    this.topBar.setButtonRightIcon(2130841093);
    this.topBar.getButtonRight().setOnClickListener(new FtnAttachmentActivity.10(this));
    View localView = this.topBar.getButtonRight();
    if (this.isShowInfo) {}
    for (int i = 2131720828;; i = 2131720829)
    {
      localView.setContentDescription(getString(i));
      return;
    }
  }
  
  private void initView()
  {
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    this.viewFlipper = ((ViewFlipper)findViewById(2131381892));
    this.viewFlipper.setBackgroundResource(2131167682);
    initTopBar();
    initFootBar();
    initWebView(this.mailAttach.getPreview().getItype(), "GBK");
    this.qmTips = new QMTips(this);
    this.progress = findViewById(2131373659);
    this.downloadBig = findViewById(2131366066);
    this.waitForDownload = findViewById(2131382103);
    this.openFile = findViewById(2131372675);
    this.manager = findViewById(2131371113);
    this.tips = findViewById(2131379724);
    this.cannotPreviewTips = findViewById(2131364247);
    this.onlinePreviewTips = findViewById(2131372636);
    this.nameTextView = ((TextView)findViewById(2131367745));
    this.sizeTextView = ((TextView)findViewById(2131367746));
    TextUtil.setFileInfoTextStyle(this.sizeTextView, getString(2131694060), this.mailAttach.getSize());
    this.fileInfoLayout = ((FtnFileInformationView)findViewById(2131367056));
    Object localObject2 = new Date(this.mailAttach.getCreateTime() * 1000L);
    Object localObject1 = new Date(this.mailAttach.getExpire().getTime());
    int i = ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(this.mailAttach.getName()), ImageResourceUtil.IMAGE_SIZE_58);
    if (i != -1) {
      this.fileInfoLayout.setFileThumbDrawable(i, null);
    }
    localObject2 = DateExtension.fullDateName_yyyyMMddHHmm((Date)localObject2).split(" ");
    this.fileInfoLayout.setFileName(this.mailAttach.getName());
    this.fileInfoLayout.setFileCreatedDate(localObject2[0]);
    this.fileInfoLayout.setFileValidTime(FtnCommonUtils.getExpireTimeString((Date)localObject1));
    this.fileInfoLayout.setFileSize(this.fileSizeFormat);
    this.fileInfoLayout.setFileDownloadCount(this.mailAttach.getDownloadTimes());
    this.downloadFileBtn = ((Button)findViewById(2131366067));
    this.downloadFileBtn.setOnClickListener(this.downloadFileClickListener);
    this.openFileBtn = ((Button)findViewById(2131372676));
    this.openFileBtn.setOnClickListener(this.openFileOnClickListener);
    this.managerBtn = ((Button)findViewById(2131371114));
    this.managerBtn.setOnClickListener(this.managerOnClickListener);
    this.onlinePreviewBtn = ((Button)findViewById(2131372635));
    this.onlinePreviewBtn.setOnClickListener(this.onlinePreviewClickListener);
    this.downloadFailLayout = ((LinearLayout)findViewById(2131366077));
    this.ftnPreviewContainer = findViewById(2131367750);
    this.scrollView = findViewById(2131377766);
    this.progressBar = ((SmoothProgressBar)findViewById(2131367748));
    this.progressBarCallback = new ProgressBarCallback();
    this.progressBar.setMax(100);
    this.progressBar.setDuration(20);
    this.progressBar.setSchedule(0);
    this.progressBar.setPbCallback(this.progressBarCallback);
    this.progressTextView = ((TextView)findViewById(2131367749));
    this.downloadToggleBtn = ((ToggleButton)findViewById(2131373690));
    this.downloadToggleBtn.setOnCheckedChangeListener(this.downloadPauseOrContinueClickListener);
    this.failText = ((TextView)this.downloadFailLayout.findViewById(2131366078));
    localObject1 = (ImageView)findViewById(2131367747);
    i = ImageResourceUtil.getImageResource(FtnCommonUtils.getFileType(this.mailAttach.getName()), ImageResourceUtil.IMAGE_SIZE_124);
    if ((i != -1) && (localObject1 != null)) {
      ((ImageView)localObject1).setImageResource(i);
    }
    this.progressTextView.setText("0K / " + this.fileSizeFormat);
    this.nameTextView.setText(this.mailAttach.getName());
    this.sizeTextView.setText(this.fileSizeFormat);
    this.slideViewAnim = new SlideViewAnimation(new AttachInfoSlideAction(null));
    this.viewFlipper.removeView(this.webView);
  }
  
  @SuppressLint({"NewApi"})
  private void initWebView(AttachType paramAttachType, String paramString)
  {
    this.webView = ((NoDialWebView)findViewById(2131382171));
    this.webView.setWebViewClient(new WabClient(null));
    this.webView.getSettings().setAllowFileAccess(true);
    this.webView.getSettings().setLoadsImagesAutomatically(true);
    this.webView.getSettings().setSavePassword(false);
    this.webView.getSettings().setSaveFormData(false);
    this.webView.getSettings().setJavaScriptEnabled(false);
    this.webView.getSettings().setDefaultTextEncodingName(paramString);
    this.webView.getSettings().setUseWideViewPort(true);
    if (paramAttachType == AttachType.HTML) {
      this.webView.setInitialScale(150);
    }
    this.webView.getSettings().setSupportZoom(true);
    this.webView.getSettings().setBuiltInZoomControls(true);
    this.webView.getSettings().setAppCacheEnabled(false);
    QMUIHelper.setZoomControlGone(this.webView);
  }
  
  private boolean isOpenByOthers()
  {
    return this.mailAttach.getPreview().getItype() == AttachType.TXT;
  }
  
  private void prepareWebView()
  {
    this.webView.setVisibility(0);
    this.viewFlipper.removeView(this.scrollView);
    if (this.webView.getParent() == null) {
      this.viewFlipper.addView(this.webView, 0);
    }
    this.viewFlipper.setDisplayedChild(0);
  }
  
  private void previewSelfOpen(String paramString1, String paramString2, AttachType paramAttachType)
  {
    try
    {
      this.isWebViewOpen = true;
      initWebView(paramAttachType, paramString2);
      paramString1 = FileUtil.copyXMLForWebview(this.mailAttach.getName(), paramString1);
      this.webView.loadUrl(StringExtention.replaceIllegalUrl(paramString1));
      OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnAttachmentActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), "" });
      return;
    }
    catch (Exception paramString1)
    {
      OssHelper.ftnattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnAttachmentActivity", FileUtil.getFileNameSuffix(this.mailAttach.getName()), paramString1.getMessage() });
      QMUIHelper.showToast(this, 2131696497, "文件过大，请重新加载！");
    }
  }
  
  private void recoveryProgress()
  {
    if (this.mailAttach == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.filePath);
    } while ((localFile == null) || (!localFile.exists()));
    this.mailAttach.getState().setDownloadSize(localFile.length() + "");
    this.mHandler.sendEmptyMessage(5);
  }
  
  private void renderDownload()
  {
    resetLayout();
    this.downloadBig.setVisibility(0);
  }
  
  private void renderDownloadFail(String paramString)
  {
    this.isDownloadFail = true;
    this.downloadFailLayout.setVisibility(0);
    if (this.failText != null)
    {
      if (!StringExtention.isNullOrEmpty(paramString)) {
        break label80;
      }
      if (!QMNetworkUtils.isNetworkConnected(getApplicationContext())) {
        break label66;
      }
      renderDownloadFail(getString(2131697132));
    }
    for (;;)
    {
      this.downloadToggleBtn.setBackgroundDrawable(getResources().getDrawable(2130850468));
      return;
      label66:
      renderDownloadFail(getString(2131697131));
      continue;
      label80:
      this.failText.setText(paramString);
    }
  }
  
  private void renderFileInfo()
  {
    this.isShowInfo = true;
    this.fileInfoLayout.setVisibility(0);
  }
  
  private void renderGoToManager()
  {
    resetLayout();
    this.manager.setVisibility(0);
  }
  
  private void renderOpenFile()
  {
    resetLayout();
    this.openFile.setVisibility(0);
  }
  
  private void renderProgressBar()
  {
    resetLayout();
    this.progress.setVisibility(0);
    this.nameTextView.setVisibility(0);
    this.sizeTextView.setVisibility(8);
  }
  
  private void renderSelfOpen()
  {
    this.isShowInfo = false;
    this.webView.setVisibility(0);
  }
  
  private void renderTips(boolean paramBoolean)
  {
    this.tips.setVisibility(0);
    if (paramBoolean)
    {
      this.cannotPreviewTips.setVisibility(8);
      this.onlinePreviewTips.setVisibility(0);
      return;
    }
    this.cannotPreviewTips.setVisibility(0);
    this.onlinePreviewTips.setVisibility(8);
  }
  
  private void renewAllAttach()
  {
    showTipsRenewLoading();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FtnUI localFtnUI = FtnManager.sharedInstance().getFtnList();
    int i = 0;
    while (i < localFtnUI.getCount())
    {
      FileInfo localFileInfo = localFtnUI.get(i);
      localArrayList1.add(localFileInfo.fid);
      localArrayList2.add(Integer.valueOf(localFileInfo.expiretime - 2));
      i += 1;
    }
    localFtnUI.release();
    FtnManager.sharedInstance().renewFile(localArrayList1, localArrayList2);
  }
  
  private void renewAttach()
  {
    if ((this.fid == null) || (this.fid.equals(""))) {
      return;
    }
    showTipsRenewLoading();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(this.fid);
    localArrayList2.add(Integer.valueOf(this.fileInfo.expiretime - 2));
    FtnManager.sharedInstance().renewFile(localArrayList1, localArrayList2);
  }
  
  private void resetLayout()
  {
    this.progress.setVisibility(8);
    this.openFile.setVisibility(8);
    this.downloadBig.setVisibility(8);
    this.waitForDownload.setVisibility(8);
    this.manager.setVisibility(8);
    this.tips.setVisibility(8);
    this.nameTextView.setVisibility(0);
    this.sizeTextView.setVisibility(0);
  }
  
  private void retryDownload()
  {
    this.isDownloadFail = false;
    this.downloadFailLayout.setVisibility(8);
    this.downloadToggleBtn.setBackgroundDrawable(getResources().getDrawable(2130850472));
    if (!QMNetworkUtils.isNetworkConnected())
    {
      renderDownloadFail(getString(2131697131));
      return;
    }
    File localFile = new File(this.filePath);
    if (localFile.exists())
    {
      localFile.delete();
      QMLog.log(5, "FtnAttachmentActivity", "Retry-download fail! retry to fix and continue");
    }
    autoDownload();
  }
  
  private void showTipsCopyShareLinkLoading()
  {
    this.qmTips.showLoading("复制分享链接");
  }
  
  private void showTipsDelFileError()
  {
    this.qmTips.showError(getResources().getString(2131692468));
  }
  
  private void showTipsDelFileLoading()
  {
    this.qmTips.showLoading(getString(2131692499));
    this.qmTips.setCanceledOnTouchOutside(false);
  }
  
  private void showTipsRenewError()
  {
    this.qmTips.showError("续期失败");
  }
  
  private void showTipsRenewLoading()
  {
    this.qmTips.showLoading("续期中...");
  }
  
  private void showTipsRenewSuccess()
  {
    this.qmTips.showSuccess("续期成功");
  }
  
  public void doAfterRotationBack() {}
  
  public void doAfterRotationFront() {}
  
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
    setContentView(2131558475);
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
    DownloadUtil.existFileSaveAs(this.mailAttach, paramIntent, true);
  }
  
  public void onBackPressed()
  {
    this.topBar.getButtonLeft().setSelected(true);
    if (this.ftnManager != null) {
      this.ftnManager.abortAndRemoveRequest(this.fid);
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Watchers.bind(this.getDownloadUrlWatcher);
      Watchers.bind(this.ftnDownloadWatcher);
      QMNotification.registNotification("actiongetshareurlsucc", this.observerGetShareUrlSuccess);
      QMNotification.registNotification("actiongetshareurlerror", this.observerGetShareUrlError);
      QMNotification.registNotification("actiondelfilesucc", this.observerDelFileSuccess);
      QMNotification.registNotification("actiondelfileerror", this.observerDelFileError);
      QMNotification.registNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
      QMNotification.registNotification("actionrenewfileerror", this.observerRenewFileError);
      return;
    }
    Watchers.unbind(this.getDownloadUrlWatcher);
    Watchers.unbind(this.ftnDownloadWatcher);
    QMNotification.unregistNotification("actiongetshareurlsucc", this.observerGetShareUrlSuccess);
    QMNotification.unregistNotification("actiongetshareurlerror", this.observerGetShareUrlError);
    QMNotification.unregistNotification("actiondelfilesucc", this.observerDelFileSuccess);
    QMNotification.unregistNotification("actiondelfileerror", this.observerDelFileError);
    QMNotification.unregistNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
    QMNotification.unregistNotification("actionrenewfileerror", this.observerRenewFileError);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (!this.isWebViewOpen) || (this.isShowInfo);
  }
  
  public void onRelease()
  {
    this.qmTips = null;
    this.bottomBar = null;
    if (this.topBar != null) {
      this.topBar = null;
    }
    if (this.qmDialog != null) {
      this.qmDialog.dismiss();
    }
  }
  
  public void refreshData()
  {
    recoveryProgress();
  }
  
  public void render() {}
  
  class AttachInfoSlideAction
    implements SlideViewAnimation.SlideAction
  {
    private AttachInfoSlideAction() {}
    
    public void slideBottom2TopAction()
    {
      FtnAttachmentActivity.this.hideFileInfo();
      if (FtnAttachmentActivity.this.previewType == 0) {
        FtnAttachmentActivity.this.renderSelfOpen();
      }
      for (;;)
      {
        if (FtnAttachmentActivity.this.topBar.getButtonRight() != null)
        {
          FtnAttachmentActivity.this.topBar.setButtonRightIconView(2130841093);
          FtnAttachmentActivity.this.topBar.getButtonRight().setEnabled(true);
        }
        return;
        FtnAttachmentActivity.this.ftnPreviewContainer.setVisibility(0);
      }
    }
    
    public void slideLeft2RightAction() {}
    
    public void slideRight2LeftAction() {}
    
    public void slideTop2BottomAction()
    {
      FtnAttachmentActivity.this.renderFileInfo();
      if (FtnAttachmentActivity.this.previewType == 0) {
        FtnAttachmentActivity.this.hideSelfOpen();
      }
      for (;;)
      {
        if (FtnAttachmentActivity.this.topBar.getButtonRight() != null)
        {
          FtnAttachmentActivity.this.topBar.setButtonRightIconView(2130841092);
          FtnAttachmentActivity.this.topBar.getButtonRight().setEnabled(true);
        }
        return;
        FtnAttachmentActivity.this.ftnPreviewContainer.setVisibility(8);
      }
    }
  }
  
  static class SafeHandler
    extends Handler
  {
    private final WeakReference<FtnAttachmentActivity> activity;
    
    public SafeHandler(FtnAttachmentActivity paramFtnAttachmentActivity)
    {
      this.activity = new WeakReference(paramFtnAttachmentActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      FtnAttachmentActivity localFtnAttachmentActivity = (FtnAttachmentActivity)this.activity.get();
      if (localFtnAttachmentActivity == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 5: 
        int i = localFtnAttachmentActivity.calcProgress(localFtnAttachmentActivity.mailAttach.getState().getDownloadSize(), localFtnAttachmentActivity.mailAttach.getSize(), 1.0D);
        if (localFtnAttachmentActivity.progressBar.getProgress() <= 0) {
          localFtnAttachmentActivity.progressBar.setProgress(i);
        }
        for (;;)
        {
          long l1 = -1L;
          try
          {
            l2 = Long.parseLong(localFtnAttachmentActivity.mailAttach.getState().getDownloadSize());
            l1 = l2;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              long l2;
              String str;
              QMLog.log(5, "FtnAttachmentActivity", "show download on progress", paramMessage);
            }
          }
          l2 = l1;
          if (l1 < 0L)
          {
            l2 = Math.pow(2.0D, 31.0D);
            l2 = l1 + l2 + l2;
          }
          paramMessage = StringExtention.getHumanReadableSizeString(l2);
          str = StringExtention.getHumanReadableSizeString(Long.parseLong(localFtnAttachmentActivity.mailAttach.getSize()));
          localFtnAttachmentActivity.progressTextView.setText(paramMessage + "/" + str);
          return;
          localFtnAttachmentActivity.progressBar.setProgressSmooth(i, false);
        }
      case 24: 
        localFtnAttachmentActivity.downloadToggleBtn.setEnabled(false);
        return;
      }
      localFtnAttachmentActivity.downloadToggleBtn.setEnabled(true);
    }
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
      if (!FtnAttachmentActivity.this.isPageError)
      {
        FtnAttachmentActivity.access$4202(FtnAttachmentActivity.this, true);
        QMUIHelper.showToast(FtnAttachmentActivity.this, 2131696497, "附件文本格式不兼容，将使用兼容格式打开");
        paramWebView.loadDataWithBaseURL(paramString2, FileUtil.file2String(FtnAttachmentActivity.this.filePath), "text/html", "GBK", paramString2);
        return;
      }
      QMUIHelper.showToast(FtnAttachmentActivity.this, 2131696497, "不支持该附件原本格式,请尝试使用其他应用打开");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity
 * JD-Core Version:    0.7.0.1
 */