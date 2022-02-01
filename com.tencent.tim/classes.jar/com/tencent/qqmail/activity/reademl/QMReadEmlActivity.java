package com.tencent.qqmail.activity.reademl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.UrlQuerySanitizer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity;
import com.tencent.qqmail.activity.media.ImageAttachData;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.WebViewPreviewActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.loader.BigAttachDownloader;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.download.watcher.DownloadWatcher;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.mail.watcher.ParseEmlWatcher;
import com.tencent.qqmail.model.mail.watcher.ReadMailDefaultWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.CustomDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewLongClickSaverListener;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.AttachNamesHandlerTextView;
import com.tencent.qqmail.view.DownloadThumbProgressBar;
import com.tencent.qqmail.view.DropdownWebViewLayout;
import com.tencent.qqmail.view.QMReadMailView;
import com.tencent.qqmail.view.QMReadMailView.VIEW_ITEM;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.ReadMailDetailView;
import com.tencent.qqmail.view.ReadMailTitle;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import moai.core.watcher.Watchers;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public class QMReadEmlActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_readmail_accountid";
  private static final String ARG_CONV_PARENT_MAILID = "arg_readmail_parent_mailid";
  public static final String ARG_EML_ANIM_SCALE = "arg_eml_anim_scale";
  public static final String ARG_EML_ATTACH = "arg_eml_attach";
  public static final String ARG_EML_ENCODE = "arg_eml_encode";
  public static final String ARG_EML_IS_FTN = "arg_eml_is_ftn";
  public static final String ARG_FROM_EML = "arg_from_eml";
  private static final String ARG_FROM_FOLDERID = "arg_readmail_from_folderid";
  private static final String ARG_ID = "arg_readmail_mailid";
  private static final String ARG_IS_GROUP = "is_group";
  private static final String ARG_MAIL_SENDER_NICKNAME = "arg_readmail_mail_sender_nickname";
  private static final String ARG_MAIL_SUBJECT = "arg_readmail_mail_subject";
  private static final String FOXMAIL_ATTACH_URL = "/cgi-bin/ftnExs_download?";
  private static final int REQUEST_CODE_ATTACH_DOWNLOAD = 100;
  private static final int REQUEST_CODE_ATTACH_SAVE_AS = 101;
  private static final int REQUEST_CODE_IMAGE_SAVE_AS = 102;
  private static final int REQUEST_CODE_IMAGE_SEQ_DOWNLOAD = 103;
  private static final int REQUEST_CODE_SAVE_EML = 104;
  public static final String TAG = "QMReadEmlActivity";
  private static final long UPDATE_TRIGGER_TIME = 200L;
  private static final String WAP_MALI_URL = "http://m.mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftnapp_download_android&f=xhtml";
  private static String miscCheckLinkUrl = null;
  private HashMap<Long, BigAttachDownloader> bigAttachDownloaderHashMap = new HashMap();
  private DownloadWatcher downloadWatcher = new QMReadEmlActivity.3(this);
  private boolean isFileShare = false;
  private int lastOpenFileIndex = -1;
  private long lastUpdateTime;
  private int mAccountId;
  private LinearLayout mAttachListView;
  private AttachListViewAdapter mAttachListViewAdapter;
  private ReadMailDetailView mDetailView;
  private Attach mEmlAttach;
  private long mEmlAttachId;
  private String mEmlEncode;
  private String mEmlFid;
  private long mEmlMailId;
  private boolean mFileSaveSingle = false;
  private int mFromFolderId;
  private ArrayList<String> mFtnStoreList;
  private ViewGroup mHeader;
  private boolean mImageSaveSingle = false;
  private boolean mIsAnimScale = true;
  private boolean mIsBig;
  private boolean mIsFtn;
  private boolean mIsGroup;
  private boolean mIsImageLoad;
  private boolean mIsLoadContent;
  private boolean mIsReload = true;
  private TinyImageSeqLoader mLoader = null;
  private Mail mMail;
  private MailUI mMailData;
  private int mParentMailId;
  private QMReadMailView mReadMailView;
  private View.OnClickListener mReload = new QMReadEmlActivity.13(this);
  private String mSenderEmail;
  private String mSenderNickName;
  private String mSubject;
  private QMTips mTips;
  private ReadMailTitle mTitleView;
  private DropdownWebViewLayout mWebContainer;
  private QMScaleWebViewController mWebViewController;
  private List<MediaItemInfo> mediaInfos;
  private IObserver observerFtnFailExceedLimit = new QMReadEmlActivity.7(this, null);
  private IObserver observerFtnFailWithExpireTime = new QMReadEmlActivity.6(this, null);
  private IObserver observerSaveFileError = new QMReadEmlActivity.5(this, null);
  private IObserver observerSaveFileSuccess = new QMReadEmlActivity.4(this, null);
  private ParseEmlWatcher parseEmlWatcher = new QMReadEmlActivity.2(this);
  private ReadMailDefaultWatcher readMailWatcher = new QMReadEmlActivity.1(this);
  private int retryCnt = 1;
  private ArrayList<MailBigAttach> saveFtnIdList = new ArrayList();
  
  private void abortDownloadBigAttach(MailBigAttach paramMailBigAttach)
  {
    QMLog.log(4, "QMReadEmlActivity", "going to abort download bigAttach " + paramMailBigAttach.getName());
    paramMailBigAttach = (BigAttachDownloader)this.bigAttachDownloaderHashMap.remove(Long.valueOf(paramMailBigAttach.getHashId()));
    if (paramMailBigAttach != null) {
      paramMailBigAttach.abort();
    }
  }
  
  private void attachSaveAs(int paramInt)
  {
    this.mFileSaveSingle = true;
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    localIntent.putExtra("position", paramInt);
    startActivityForResult(localIntent, 101);
  }
  
  private void attachSaveToFtn(MailBigAttach paramMailBigAttach, boolean paramBoolean)
  {
    if (paramMailBigAttach == null) {
      return;
    }
    FtnManager localFtnManager = FtnManager.sharedInstance();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = new ArrayList();
    this.saveFtnIdList.clear();
    if (!paramBoolean)
    {
      ((ArrayList)localObject1).add(QMAttachUtils.removeIllegalString(paramMailBigAttach.getPreview().getDownloadUrl()));
      this.saveFtnIdList.add(paramMailBigAttach);
    }
    for (paramMailBigAttach = (MailBigAttach)localObject1;; paramMailBigAttach = DownloadUtil.getBigAttAchDownloadList(this.mMailData.getInformation()))
    {
      localObject1 = new UrlQuerySanitizer();
      ((UrlQuerySanitizer)localObject1).setAllowUnregisteredParamaters(true);
      int i = 0;
      Object localObject3;
      while (i < paramMailBigAttach.size())
      {
        ((UrlQuerySanitizer)localObject1).parseUrl(QMAttachUtils.removeIllegalString((String)paramMailBigAttach.get(i)));
        localObject2 = ((UrlQuerySanitizer)localObject1).getValue("k");
        localObject3 = ((UrlQuerySanitizer)localObject1).getValue("code");
        if ((!StringExtention.isNullOrEmpty((String)localObject2)) && (!StringExtention.isNullOrEmpty((String)localObject3)))
        {
          localArrayList1.add(localObject2);
          localArrayList2.add(localObject3);
        }
        i += 1;
      }
      paramMailBigAttach = this.mMailData.getInformation().getBigAttachList();
      Object localObject2 = new Date();
      i = 0;
      while (i < paramMailBigAttach.size())
      {
        localObject3 = (MailBigAttach)paramMailBigAttach.get(i);
        Date localDate = ((MailBigAttach)localObject3).getExpire();
        if ((((MailBigAttach)localObject3).isBizNetDiskAttach()) || ((localDate != null) && (localDate.getTime() - ((Date)localObject2).getTime() > 0L)))
        {
          ((ArrayList)localObject1).add(((MailBigAttach)localObject3).getPreview().getDownloadUrl());
          this.saveFtnIdList.add(localObject3);
        }
        i += 1;
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList1.size() == localArrayList2.size()))
    {
      getTips().showLoading(getString(2131718594));
      localFtnManager.saveFile(localArrayList1, localArrayList2);
      return;
    }
    getTips().showError(getString(2131718938));
  }
  
  private void attachSendTo(Attach paramAttach)
  {
    if (paramAttach == null) {
      return;
    }
    ComposeMailUI localComposeMailUI = new ComposeMailUI();
    Object localObject = localComposeMailUI.getInformation();
    ((MailInformation)localObject).setToList(null);
    ((MailInformation)localObject).setCcList(null);
    ((MailInformation)localObject).setSendContact(null);
    ((MailInformation)localObject).setSubject(paramAttach.getName());
    localComposeMailUI.setContent(new MailContent());
    localObject = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramAttach instanceof MailBigAttach))
    {
      localArrayList1.add(paramAttach);
      localComposeMailUI.getInformation().setAttachList((ArrayList)localObject);
      localComposeMailUI.getInformation().setBigAttachList(localArrayList1);
      localComposeMailUI.getInformation().setEditAttachList(localArrayList2);
      if (paramAttach == null) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      ValidateHelper.assertInDebug("", bool);
      startActivity(ComposeMailActivity.createIntentForFwdAttach(paramAttach.getHashId(), this.mEmlMailId, this.mAccountId, getClass().getName()));
      return;
      if ((paramAttach instanceof MailEditAttach))
      {
        localArrayList2.add(paramAttach);
        break;
      }
      ((ArrayList)localObject).add(paramAttach);
      break;
    }
  }
  
  private int buildImageAttachDownSeq(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    if (paramBoolean)
    {
      localObject1 = this.mMailData.getInformation().getAttachListNoInlineImg();
      localObject2 = this.mMailData.getInformation().getBigAttachList();
      i = ((ArrayList)localObject1).size();
      j = ((ArrayList)localObject2).size();
      if (paramInt < i)
      {
        localArrayList.add((Attach)((ArrayList)localObject1).get(paramInt));
        ImageAttachData.loadData(localArrayList, this.mMailData.getStatus().isProtocolMail(), false);
      }
    }
    for (;;)
    {
      return localArrayList.size();
      if ((paramInt < i) || (paramInt >= i + j)) {
        break;
      }
      localArrayList.add((Attach)((ArrayList)localObject2).get(paramInt - i));
      break;
      localObject2 = this.mMailData.getInformation().getImageAttachListNoInlineImg();
      localObject1 = this.mMailData.getInformation().getImageBigAttachList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add((Attach)((Iterator)localObject2).next());
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add((Attach)((Iterator)localObject1).next());
      }
      ImageAttachData.loadData(localArrayList, this.mMailData.getStatus().isProtocolMail(), false);
    }
  }
  
  public static Intent createIntentFromEml(int paramInt, Attach paramAttach, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMReadEmlActivity.class);
    localIntent.putExtra("arg_from_eml", true);
    localIntent.putExtra("arg_readmail_accountid", paramInt);
    localIntent.putExtra("arg_eml_attach", paramAttach);
    localIntent.putExtra("arg_eml_is_ftn", paramBoolean2);
    localIntent.putExtra("arg_eml_anim_scale", paramBoolean1);
    return localIntent;
  }
  
  private void downloadBigAttach(MailBigAttach paramMailBigAttach, String paramString)
  {
    QMLog.log(4, "QMReadEmlActivity", "going to download bigAttach " + paramMailBigAttach.getName());
    BigAttachDownloader localBigAttachDownloader2 = (BigAttachDownloader)this.bigAttachDownloaderHashMap.get(Long.valueOf(paramMailBigAttach.getHashId()));
    BigAttachDownloader localBigAttachDownloader1 = localBigAttachDownloader2;
    if (localBigAttachDownloader2 == null)
    {
      localBigAttachDownloader1 = new BigAttachDownloader(paramMailBigAttach, paramString, true);
      this.bigAttachDownloaderHashMap.put(Long.valueOf(paramMailBigAttach.getHashId()), localBigAttachDownloader1);
    }
    localBigAttachDownloader1.download();
  }
  
  private void downloadImageAttachSeq(String paramString, int paramInt, boolean paramBoolean)
  {
    paramInt = buildImageAttachDownSeq(paramInt, paramBoolean);
    this.mLoader = new TinyImageSeqLoader(this.mAccountId, paramString, ImageAttachData.imageInfoList, new QMReadEmlActivity.18(this, paramInt), null);
    getTips().setCanceledOnTouchOutside(false);
    this.mLoader.load(paramString, 0);
  }
  
  private void emlSaveAs()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 104);
  }
  
  private DownloadInfo getDownloadInfo(Attach paramAttach)
  {
    Object localObject;
    DownloadInfo localDownloadInfo;
    if (paramAttach.isBigAttach())
    {
      localObject = QMAttachUtils.removeIllegalString(paramAttach.getPreview().getDownloadUrl());
      int i = DownloadInfo.generateId(this.mAccountId, (String)localObject, paramAttach.getName());
      localDownloadInfo = DownloadInfoManager.shareInstance().getDownloadInfoById(i);
      if (localDownloadInfo != null)
      {
        localObject = AttachDownloadManager.shareInstance().getDownloadInfoByKey((String)localObject);
        if (localObject == null) {
          break label108;
        }
        localDownloadInfo.setDownloadSize(((DownloadInfo)localObject).getDownloadSize());
        localDownloadInfo.setFileSize(((DownloadInfo)localObject).getFileSize());
      }
    }
    for (;;)
    {
      if (localDownloadInfo.getFileSize() <= 0L) {
        localDownloadInfo.setFileSize(StringExtention.sizeStrToLong(paramAttach.getSize()));
      }
      return localDownloadInfo;
      localObject = DownloadUtil.getDownloadUrl(paramAttach);
      break;
      label108:
      if (localDownloadInfo.getStatus() == 2) {
        localDownloadInfo.setStatus(6);
      }
    }
  }
  
  private String getFilePath(Attach paramAttach)
  {
    File localFile = ImageDownloadManager.shareInstance().getThumbBitmapFromDiskCache(QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + paramAttach.getPreview().getIcon());
    if (paramAttach.isExist()) {
      return paramAttach.getPreview().getMyDisk();
    }
    if (localFile == null) {
      return null;
    }
    return localFile.getAbsolutePath();
  }
  
  private String getWapUrl(String paramString)
  {
    Object localObject1 = "";
    paramString = paramString.split("\\?");
    if (paramString.length >= 2)
    {
      String[] arrayOfString = paramString[1].split("&");
      paramString = "";
      int i = 0;
      for (;;)
      {
        localObject3 = paramString;
        localObject2 = localObject1;
        if (i >= arrayOfString.length) {
          break;
        }
        localObject2 = localObject1;
        if (arrayOfString[i].startsWith("k="))
        {
          localObject3 = arrayOfString[i].split("=");
          localObject2 = localObject1;
          if (localObject3.length >= 2) {
            localObject2 = (String)localObject1 + localObject3[1];
          }
        }
        localObject1 = paramString;
        if (arrayOfString[i].startsWith("code="))
        {
          localObject3 = arrayOfString[i].split("=");
          localObject1 = paramString;
          if (localObject3.length >= 2) {
            localObject1 = paramString + localObject3[1];
          }
        }
        i += 1;
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
    Object localObject3 = "";
    Object localObject2 = localObject1;
    return "http://m.mail.qq.com/cgi-bin/ftnExs_download?t=exs_ftnapp_download_android&f=xhtml&k=" + (String)localObject2 + "," + (String)localObject3 + "&sid=" + null + "&iswifi=" + QMNetworkUtils.isWifiConnected(this);
  }
  
  private void handleSeqDownloadBefore(SeqDownloadInfo paramSeqDownloadInfo)
  {
    if (this.mImageSaveSingle)
    {
      SeqDownloadInfo.lastCount = paramSeqDownloadInfo.currentCount;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getString(2131690585));
    if (paramSeqDownloadInfo.currentCount == 0) {}
    for (int i = 1;; i = paramSeqDownloadInfo.currentCount)
    {
      showProcessing(i + "/" + paramSeqDownloadInfo.totalCount);
      SeqDownloadInfo.lastCount = paramSeqDownloadInfo.currentCount;
      return;
    }
  }
  
  private void handleSeqDownloadComplete(SeqDownloadInfo paramSeqDownloadInfo)
  {
    if (this.mImageSaveSingle)
    {
      SeqDownloadInfo.lastCount = paramSeqDownloadInfo.currentCount;
      if ((paramSeqDownloadInfo.currentCount == paramSeqDownloadInfo.totalCount) && (paramSeqDownloadInfo.isComplete))
      {
        SeqDownloadInfo.lastCount = 0;
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131694769) + paramSeqDownloadInfo.filePath, 0).show();
      }
    }
    String str1;
    do
    {
      return;
      int i = SeqDownloadInfo.lastCount;
      while (i < paramSeqDownloadInfo.currentCount)
      {
        str1 = getString(2131690585);
        updateTipsProcessInfo(str1 + (i + 1) + "/" + paramSeqDownloadInfo.totalCount);
        i += 1;
      }
      SeqDownloadInfo.lastCount = paramSeqDownloadInfo.currentCount;
    } while ((paramSeqDownloadInfo.currentCount != paramSeqDownloadInfo.totalCount) || (!paramSeqDownloadInfo.isComplete));
    if (paramSeqDownloadInfo.successCount == paramSeqDownloadInfo.totalCount) {
      showTipsInfo(getString(2131690581));
    }
    for (;;)
    {
      SeqDownloadInfo.lastCount = 0;
      return;
      str1 = getString(2131690580);
      String str2 = getString(2131690579);
      showTipsInfo(str1 + paramSeqDownloadInfo.successCount + str2 + paramSeqDownloadInfo.failCount);
    }
  }
  
  private boolean hasSDCardAndHandleErrorIfNo()
  {
    if (FileUtil.hasSdcard()) {
      return true;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(2131690273).setTitle(2131690274)).addAction(2131696547, new QMReadEmlActivity.17(this))).create().show();
    return false;
  }
  
  private void hideErrorView()
  {
    this.mReadMailView.setStatus(1);
  }
  
  private void hideLoading()
  {
    this.mReadMailView.setStatus(1);
  }
  
  private void initIsImageLoad()
  {
    boolean bool = true;
    switch (QMSettingManager.sharedInstance().getMailLoadImgType())
    {
    default: 
      this.mIsImageLoad = true;
      return;
    case 0: 
      this.mIsImageLoad = true;
      return;
    case 2: 
      this.mIsImageLoad = false;
      return;
    }
    if (QMNetworkUtils.isWifiConnected(this)) {}
    for (;;)
    {
      this.mIsImageLoad = bool;
      return;
      bool = false;
    }
  }
  
  private void initTips()
  {
    this.mTips = new QMTips(this);
    this.mTips.setCanceledOnTouchOutside(true);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle("");
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setCenterOnclickListener(new QMReadEmlActivity.8(this));
    localQMTopBar.setButtonRightIcon(2130841095);
    localQMTopBar.setButtonRightOnclickListener(new QMReadEmlActivity.9(this));
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initWebView()
  {
    this.mWebViewController = new QMScaleWebViewController(this, this.mWebContainer, this.mHeader, null);
    this.mWebViewController.init();
    QMScaleWebViewController localQMScaleWebViewController1 = this.mWebViewController;
    QMScaleWebViewController localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setJavascriptInterface(new QMReadEmlActivity.14(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setWebViewClient(new QMReadEmlActivity.15(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setOnLongClickListener(new QMScaleWebViewController.QMScaleWebViewLongClickSaverListener(localQMScaleWebViewController2));
  }
  
  private boolean isAttachImage(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))) == AttachType.IMAGE;
  }
  
  private boolean isBigAttachExpireTime(Attach paramAttach)
  {
    if (this.mAttachListViewAdapter == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramAttach == null) || (!(paramAttach instanceof MailBigAttach)));
      paramAttach = (MailBigAttach)paramAttach;
    } while ((paramAttach.isBizNetDiskAttach()) || ((paramAttach.getExpireTimeMilli() != -2L) && (paramAttach.getExpireTimeMilli() >= System.currentTimeMillis())));
    return true;
  }
  
  private boolean isQQMail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    return (localAccount != null) && (localAccount.isQQMail());
  }
  
  private boolean isShowFtnOperEntrance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    return ((!this.mMailData.getStatus().isProtocolMail()) || (localQQMailAccount != null)) && (QMSettingManager.sharedInstance().getFtnDisplay());
  }
  
  private boolean isShowImage()
  {
    if (this.mIsImageLoad) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return true;
      } while ((this.mWebViewController == null) || (this.mWebViewController.getResourceLoader() == null));
      bool1 = this.mWebViewController.getResourceLoader().hasResource();
      bool2 = this.mWebViewController.getResourceLoader().isAllImageCached();
    } while ((bool1) && (bool2));
    return false;
  }
  
  private boolean isShowSaveToWeiYun()
  {
    boolean bool2 = false;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
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
  
  private void refreshData(boolean paramBoolean)
  {
    Object localObject = QMMailManager.sharedInstance();
    if (paramBoolean) {
      if (this.mIsFtn)
      {
        this.mEmlMailId = QMAttachManager.sharedInstance().getFtnRefMailId(this.mEmlFid);
        this.mMail = ((QMMailManager)localObject).readMailFromEmlAsync(this.mEmlMailId);
        if (this.mMail != null) {
          break label88;
        }
        showLoading();
        Threads.runInBackground(new QMReadEmlActivity.12(this));
      }
    }
    for (;;)
    {
      return;
      this.mEmlMailId = QMAttachManager.sharedInstance().getAttachRefMailId(this.mEmlAttachId, this.mEmlAttach.isBigAttach());
      break;
      label88:
      this.mMail.getStatus().setUnread(false);
      while (this.mMail != null)
      {
        this.mMailData = new MailUI(this.mMail, this.mFromFolderId, this.mParentMailId);
        this.mAccountId = this.mMailData.getInformation().getAccountId();
        return;
        localObject = ((QMMailManager)localObject).readMailInfo(this.mEmlMailId, true);
        if ((localObject != null) && (this.mMail != null)) {
          this.mMail.setStatus(((Mail)localObject).getStatus());
        }
      }
    }
  }
  
  private void reloadMail()
  {
    this.mIsReload = true;
    initWebView();
    if (this.mWebViewController != null) {
      this.mWebViewController.clearResourceLoader();
    }
    initIsImageLoad();
    refreshData(true);
  }
  
  private void renderAttaches()
  {
    if (this.mMailData != null)
    {
      if (((this.mMailData.getInformation().getAttachListNoInlineImg() == null) || (this.mMailData.getInformation().getAttachListNoInlineImg().size() <= 0)) && ((this.mMailData.getInformation().getBigAttachList() == null) || (this.mMailData.getInformation().getBigAttachList().size() <= 0)) && ((this.mMailData.getInformation().getEditAttachList() == null) || (this.mMailData.getInformation().getEditAttachList().size() <= 0))) {
        break label236;
      }
      localArrayList1 = this.mMailData.getInformation().getAttachListNoInlineImg();
      localArrayList2 = this.mMailData.getInformation().getBigAttachList();
      localArrayList3 = this.mMailData.getInformation().getEditAttachList();
      this.mAttachListViewAdapter = new AttachListViewAdapter(this);
      if (localArrayList1 != null) {
        this.mAttachListViewAdapter.setAttachList(localArrayList1);
      }
      if (localArrayList2 != null) {
        this.mAttachListViewAdapter.setBigAttachList(localArrayList2);
      }
      if (localArrayList3 != null) {
        this.mAttachListViewAdapter.setEditAttachList(localArrayList3);
      }
      if (this.mAttachListView == null) {
        this.mAttachListView = ((LinearLayout)LayoutInflater.from(this).inflate(2131562937, null).findViewById(2131376802));
      }
      this.mAttachListViewAdapter.renderAttachList(this.mAttachListView);
      this.mWebViewController.setToolBar((ViewGroup)this.mAttachListView.getParent());
    }
    label236:
    while (this.mAttachListView == null)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      return;
    }
    this.mAttachListView.removeAllViews();
    this.mAttachListView = null;
  }
  
  private void renderHeader()
  {
    this.mHeader.setVisibility(0);
    this.mTitleView = ((ReadMailTitle)this.mHeader.findViewById(2131376659));
    this.mTitleView.render(this.mMailData);
    this.mDetailView = ((ReadMailDetailView)this.mHeader.findViewById(2131376656));
    this.mDetailView.render(this.mMailData, this.mDetailView.isShowDetail());
    this.mDetailView.setShowDetailOnClickListener(new QMReadEmlActivity.10(this));
    this.mDetailView.setShowAttachOnClickListener(new QMReadEmlActivity.11(this));
  }
  
  private void renderLightHeader(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    MailUI localMailUI = new MailUI();
    localMailUI.setInformation(new MailInformation());
    localMailUI.setStatus(new MailStatus());
    localMailUI.getInformation().setSubject(paramString1);
    if (!paramBoolean) {
      localMailUI.getStatus().setGroupMail(paramBoolean);
    }
    paramString1 = new MailContact(paramString2, paramString3);
    paramString1.setName(paramString2);
    paramString1.setNick(paramString2);
    localMailUI.getInformation().setAccountId(this.mAccountId);
    localMailUI.getInformation().setFrom(paramString1);
    this.mHeader.setVisibility(0);
    this.mTitleView = ((ReadMailTitle)this.mHeader.findViewById(2131376659));
    this.mDetailView = ((ReadMailDetailView)this.mHeader.findViewById(2131376656));
    this.mTitleView.render(localMailUI);
    this.mDetailView.render(localMailUI, false);
  }
  
  private void renderWithContent()
  {
    hideErrorView();
    this.mMailData = new MailUI(this.mMail, this.mFromFolderId, this.mParentMailId);
    renderHeader();
    showContent();
  }
  
  private void retryLoadContent()
  {
    if (((this.mMailData.getContent() == null) || (StringExtention.isNullOrEmpty(this.mMailData.getContent().getBody()))) && (this.retryCnt > 0))
    {
      this.retryCnt -= 1;
      QMLog.log(5, "QMReadEmlActivity", "getMailContent is null with encode " + this.mEmlEncode);
    }
  }
  
  private void sharedAttachFile(int paramInt)
  {
    int i = this.mAttachListViewAdapter.getAttachListCount();
    Object localObject1;
    if (paramInt >= i)
    {
      i = paramInt - i;
      if (i != -1) {
        break label122;
      }
      localObject1 = (Attach)this.mMailData.getInformation().getAttachListNoInlineImg().get(paramInt);
      label41:
      if (!((Attach)localObject1).isBigAttach()) {
        break label144;
      }
    }
    label144:
    for (int j = 2131692325;; j = 2131690586)
    {
      this.isFileShare = true;
      if (!((Attach)localObject1).isBigAttach()) {
        break label151;
      }
      localObject1 = (MailBigAttach)localObject1;
      new QMShareFileDialogHelper(getActivity(), getString(j), ((MailBigAttach)localObject1).getPreview().getDownloadUrl(), QMShareFileDialogHelper.SHARE_TYPE_BIG_ATT, ((MailBigAttach)localObject1).getHashId()).createDialog().show();
      this.isFileShare = false;
      return;
      i = -1;
      break;
      label122:
      localObject1 = (Attach)this.mMailData.getInformation().getBigAttachList().get(i);
      break label41;
    }
    label151:
    String str1 = QMAttachManager.sharedInstance().getAttachMyDisk(((Attach)localObject1).getHashId(), 0);
    if (!StringExtention.isNullOrEmpty(str1)) {}
    for (Object localObject2 = new File(str1);; localObject2 = null)
    {
      if ((localObject2 != null) && (((File)localObject2).exists()))
      {
        localObject2 = getActivity();
        String str2 = getString(j);
        if (isAttachImage(((Attach)localObject1).getName())) {}
        for (paramInt = QMShareFileDialogHelper.SHARE_TYPE_IMG;; paramInt = QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT)
        {
          new QMShareFileDialogHelper((Context)localObject2, str2, str1, paramInt).createDialog().show();
          this.isFileShare = false;
          return;
        }
      }
      if (((Attach)localObject1).isBigAttach()) {
        paramInt = i;
      }
      this.mAttachListViewAdapter.startAttachmentActivityByPos(paramInt, null);
      return;
    }
  }
  
  private void showContent()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "main_head"));
    Object localObject = Boolean.valueOf(false);
    if ((this.mMailData.getContent() != null) && (!StringExtention.isNullOrEmpty(this.mMailData.getContent().getBody())))
    {
      localStringBuilder1.append(this.mMailData.getContent().getBody());
      localStringBuilder1.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "main_tail"));
      String str = localStringBuilder1.toString();
      localStringBuilder1.setLength(0);
      localStringBuilder1.append("file:///read?t=mail");
      if (((Boolean)localObject).booleanValue()) {
        localStringBuilder1.append("&contentNull=true");
      }
      localStringBuilder1.append("&pageWidth=").append(this.mWebViewController.getPageWidth());
      localObject = Resources.getSystem().getDisplayMetrics();
      localStringBuilder1.append("&fontSize=").append(18.0F * ((DisplayMetrics)localObject).scaledDensity / ((DisplayMetrics)localObject).density);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("&showimage=");
      if (!isShowImage()) {
        break label254;
      }
      localObject = "true";
      label190:
      localStringBuilder2.append((String)localObject);
      this.mWebViewController.loadHTML(localStringBuilder1.toString(), str);
      this.mWebViewController.setResourceLoader(new MailContentLoader(this.mMailData));
      if (!isShowImage()) {
        break label261;
      }
      this.mWebViewController.downloadResource();
    }
    for (;;)
    {
      renderAttaches();
      return;
      localObject = Boolean.valueOf(true);
      break;
      label254:
      localObject = "false";
      break label190;
      label261:
      QMLog.log(4, "QMReadEmlActivity", "not isShowImage");
    }
  }
  
  private void showEmlActionMore(View paramView)
  {
    View localView = paramView;
    if (paramView.getTag() != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof View)) {
        localView = (View)paramView.getTag();
      }
    }
    paramView = new ArrayList();
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if ((localFtnManager != null) && (localFtnManager.hasFtnAccount()) && (this.mIsBig) && (!this.mIsFtn)) {
      paramView.add(getString(2131690570));
    }
    if ((FileUtil.isFileExist(this.mEmlAttach.getPreview().getMyDisk())) && (IntentUtil.isExistFileBrowser(getActivity()))) {
      paramView.add(getString(2131690558));
    }
    paramView.add(getString(2131690582));
    paramView.add(getString(2131690550));
    if ((!this.mIsBig) && (!this.mIsFtn))
    {
      if (QMAttachManager.sharedInstance().isAttachFavorite(this.mEmlAttachId)) {
        break label226;
      }
      paramView.add(getString(2131690532));
    }
    for (;;)
    {
      paramView = new PopupAdapter(getActivity(), 2131559771, 2131373495, paramView);
      new QMReadEmlActivity.16(this, getActivity(), localView, paramView).show();
      return;
      label226:
      paramView.add(getString(2131690535));
    }
  }
  
  private void showErrorView()
  {
    this.mReadMailView.setStatus(2);
  }
  
  private void showLoading()
  {
    this.mReadMailView.setStatus(0);
  }
  
  private void showProcessing(String paramString)
  {
    getTips().showLoading(paramString);
  }
  
  private void showTipsError(String paramString)
  {
    getTips().showError(paramString);
  }
  
  private void showTipsInfo(String paramString)
  {
    getTips().showSuccess(paramString);
  }
  
  private void updateTipsProcessInfo(String paramString)
  {
    getTips().updateLoadingInfo(paramString);
  }
  
  public void initDataSource()
  {
    this.mEmlMailId = getIntent().getLongExtra("arg_readmail_mailid", 0L);
    this.mAccountId = getIntent().getIntExtra("arg_readmail_accountid", 0);
    this.mFromFolderId = getIntent().getIntExtra("arg_readmail_from_folderid", 0);
    this.mParentMailId = getIntent().getIntExtra("arg_readmail_parent_mailid", 0);
    this.mSubject = getIntent().getStringExtra("arg_readmail_mail_subject");
    this.mSenderNickName = getIntent().getStringExtra("arg_readmail_mail_sender_nickname");
    this.mSenderEmail = getIntent().getStringExtra("arg_readmail_mail_sender_nickname");
    this.mEmlAttach = ((Attach)getIntent().getSerializableExtra("arg_eml_attach"));
    if (this.mEmlAttach == null)
    {
      finish();
      return;
    }
    this.mIsGroup = getIntent().getBooleanExtra("is_group", false);
    this.mIsAnimScale = getIntent().getBooleanExtra("arg_eml_anim_scale", true);
    this.mIsFtn = getIntent().getBooleanExtra("arg_eml_is_ftn", false);
    if (((this.mEmlAttach instanceof MailBigAttach)) && (!this.mIsFtn)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsBig = bool;
      this.mEmlAttachId = this.mEmlAttach.getHashId();
      if (this.mIsFtn) {
        this.mEmlFid = ((MailBigAttach)this.mEmlAttach).getFid();
      }
      this.mEmlEncode = getIntent().getStringExtra("arg_eml_encode");
      miscCheckLinkUrl = QMSettingManager.sharedInstance().getMiscCheckLink();
      if (this.mediaInfos == null) {
        this.mediaInfos = ImageAttachData.getImageInfoList();
      }
      if (this.mEmlMailId != 0L) {
        break;
      }
      if (!this.mIsFtn) {
        break label293;
      }
      this.mEmlMailId = QMAttachManager.sharedInstance().getFtnRefMailId(this.mEmlFid);
      return;
    }
    label293:
    this.mEmlMailId = QMAttachManager.sharedInstance().getAttachRefMailId(this.mEmlAttachId, this.mEmlAttach.isBigAttach());
  }
  
  public void initDom()
  {
    this.mWebContainer = this.mReadMailView.getWebView();
    this.mWebContainer.setAbleToPull(false);
    this.mHeader = this.mReadMailView.getHeader();
    this.mHeader.setVisibility(4);
    initWebView();
    QMUIKit.expendTouchArea(this.mHeader.findViewById(2131378295), this.mWebContainer.findViewById(2131379773));
    initIsImageLoad();
    if ((this.mSubject != null) && (this.mSenderNickName != null) && (this.mSenderEmail != null)) {
      renderLightHeader(this.mSubject, this.mSenderNickName, this.mSenderEmail, this.mIsGroup);
    }
  }
  
  public void initUI()
  {
    this.mReadMailView = new QMReadMailView(this, true);
    this.mReadMailView.setViewListener(QMReadMailView.VIEW_ITEM.RELOAD, this.mReload);
    this.mReadMailView.setPullToReply(false);
    this.mReadMailView.setEnterReplyModel(false);
    this.mReadMailView.setMailType(0);
    setContentView(this.mReadMailView);
    initTopBar();
    initTips();
  }
  
  public boolean isImageAttachSingle()
  {
    if (this.mMailData == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return true;
      localArrayList1 = this.mMailData.getInformation().getImageAttachListNoInlineImg();
      localArrayList2 = this.mMailData.getInformation().getImageBigAttachList();
    } while (localArrayList1.size() + localArrayList2.size() <= 1);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              renderAttaches();
              return;
            } while (paramIntent == null);
            paramInt1 = paramIntent.getIntExtra("position", 0);
            paramIntent = paramIntent.getStringExtra("savePath");
            this.mAttachListViewAdapter.startAttachmentActivityByPos(paramInt1, paramIntent);
            QMLog.log(4, "QMReadEmlActivity", "onActivityResult saveAs filepath: " + paramIntent);
            return;
          } while (paramIntent == null);
          paramInt1 = paramIntent.getIntExtra("position", 0);
          paramIntent = paramIntent.getStringExtra("savePath");
          downloadImageAttachSeq(paramIntent, paramInt1, true);
          QMLog.log(4, "QMReadEmlActivity", "onActivityResult image-save-as save path: " + paramIntent);
          return;
        } while (paramIntent == null);
        paramInt1 = paramIntent.getIntExtra("position", 0);
        paramIntent = paramIntent.getStringExtra("savePath");
        downloadImageAttachSeq(paramIntent, paramInt1, false);
        QMLog.log(4, "QMReadEmlActivity", "onActivityResult seq download save path: " + paramIntent);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("savePath");
    } while (this.mEmlAttach == null);
    QMLog.log(4, "QMReadEmlActivity", "eml:" + this.mEmlAttach.getName() + ", saveTo:" + paramIntent);
    DownloadUtil.fileCopyTo(this.mEmlAttach.getPreview().getMyDisk(), paramIntent, this.mEmlAttach.getName());
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.readMailWatcher, paramBoolean);
    Watchers.bind(this.parseEmlWatcher, paramBoolean);
    Watchers.bind(this.downloadWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("actionsavefilesucc", this.observerSaveFileSuccess);
      QMNotification.registNotification("actionsavefileerror", this.observerSaveFileError);
      QMNotification.registNotification("ftnfailexpired", this.observerFtnFailWithExpireTime);
      QMNotification.registNotification("ftn_fail_exceed_limit", this.observerFtnFailExceedLimit);
      return;
    }
    QMNotification.unregistNotification("actionsavefilesucc", this.observerSaveFileSuccess);
    QMNotification.unregistNotification("actionsavefileerror", this.observerSaveFileError);
    QMNotification.unregistNotification("ftnfailexpired", this.observerFtnFailWithExpireTime);
    QMNotification.unregistNotification("ftn_fail_exceed_limit", this.observerFtnFailExceedLimit);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public Intent onLastFinish()
  {
    return MailFragmentActivity.createIntentToMailList(this.mAccountId, this.mFromFolderId, "");
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    if ((paramIntent != null) && (!this.mIsAnimScale)) {
      overridePendingTransition(2130772421, 2130772420);
    }
  }
  
  public void onRelease()
  {
    if (this.mReadMailView != null)
    {
      this.mReadMailView.setOnQuickReplyListener(null);
      this.mReadMailView.destroy();
      this.mReadMailView = null;
    }
    if (this.mDetailView != null)
    {
      this.mDetailView.destroy();
      this.mDetailView = null;
    }
    if (this.mWebContainer != null)
    {
      this.mWebContainer.release();
      this.mWebContainer = null;
    }
    if (this.mWebViewController != null)
    {
      this.mWebViewController.destroy();
      this.mWebViewController = null;
    }
    if (this.mTips != null) {
      this.mTips.dismissTipsManually();
    }
    this.mTitleView = null;
  }
  
  public void refreshData()
  {
    if (this.mIsReload)
    {
      refreshData(true);
      this.mIsReload = false;
    }
    for (;;)
    {
      this.lastOpenFileIndex = -1;
      return;
      refreshData(false);
    }
  }
  
  public void render()
  {
    renderAttaches();
  }
  
  public class AttachListViewAdapter
  {
    private boolean ableClick;
    private boolean ableLongClick;
    private ArrayList<Object> attachList = null;
    private View.OnClickListener attachOptOnClickListener = new QMReadEmlActivity.AttachListViewAdapter.16(this);
    private View.OnLongClickListener attachOptOnLongClickListener = new QMReadEmlActivity.AttachListViewAdapter.17(this);
    private ArrayList<Object> bigAttachList = null;
    private ArrayList<Object> editAttachList = null;
    private boolean hasLongClick;
    private boolean isBigAttach = false;
    private boolean isEditAttach = false;
    private boolean isNormalAttach = false;
    private View.OnClickListener itemOnClickListener = new QMReadEmlActivity.AttachListViewAdapter.19(this);
    private View.OnLongClickListener itemOnLongClickListener = new QMReadEmlActivity.AttachListViewAdapter.18(this);
    private View.OnTouchListener itemOnTouchListener = new QMReadEmlActivity.AttachListViewAdapter.20(this);
    private HashMap<Integer, Integer> mAttachRelativePosition = new HashMap();
    private Context mContext = null;
    
    public AttachListViewAdapter(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private int getAttachListCount()
    {
      if (this.attachList == null) {
        return 0;
      }
      return this.attachList.size();
    }
    
    private int getBigAttachListCount()
    {
      if (this.bigAttachList == null) {
        return 0;
      }
      return this.bigAttachList.size();
    }
    
    private int getCount()
    {
      return getAttachListCount() + getBigAttachListCount() + getEditAttachListCount();
    }
    
    private int getEditAttachListCount()
    {
      if (this.editAttachList == null) {
        return 0;
      }
      return this.editAttachList.size();
    }
    
    private int getRelativePosition(int paramInt)
    {
      int m = 0;
      this.mAttachRelativePosition.clear();
      int k = 0;
      int i = 0;
      int j = 0;
      Attach localAttach;
      if (k < this.attachList.size())
      {
        localAttach = (Attach)this.attachList.get(k);
        if ((!QMReadEmlActivity.this.isAttachImage(localAttach.getName())) || (FileUtil.isFileTypeTiff(localAttach.getName()))) {
          i += 1;
        }
        for (;;)
        {
          k += 1;
          break;
          this.mAttachRelativePosition.put(Integer.valueOf(i), Integer.valueOf(j));
          j += 1;
          i += 1;
        }
      }
      int n = 0;
      k = j;
      j = n;
      if (j < this.bigAttachList.size())
      {
        localAttach = (Attach)this.bigAttachList.get(j);
        if ((!QMReadEmlActivity.this.isAttachImage(localAttach.getName())) || (FileUtil.isFileTypeTiff(localAttach.getName()))) {
          i += 1;
        }
        for (;;)
        {
          j += 1;
          break;
          this.mAttachRelativePosition.put(Integer.valueOf(i), Integer.valueOf(k));
          k += 1;
          i += 1;
        }
      }
      i = m;
      if (this.mAttachRelativePosition.containsKey(Integer.valueOf(paramInt))) {
        i = ((Integer)this.mAttachRelativePosition.get(Integer.valueOf(paramInt))).intValue();
      }
      return i;
    }
    
    private View getView(int paramInt, ViewGroup paramViewGroup)
    {
      int i;
      int j;
      label19:
      View localView;
      if (this.attachList == null)
      {
        i = 0;
        if (this.bigAttachList != null) {
          break label113;
        }
        j = 0;
        localView = LayoutInflater.from(QMReadEmlActivity.this.getActivity()).inflate(2131562936, paramViewGroup, false);
        if ((paramInt != 0) || (getCount() != 1)) {
          break label125;
        }
        QMUIHelper.setBackgroundResource(localView, 2130850543);
        label58:
        if (paramInt >= i) {
          break label170;
        }
        paramViewGroup = (Attach)this.attachList.get(paramInt);
        renderAttach(localView, paramViewGroup);
      }
      for (;;)
      {
        if (!QMReadEmlActivity.this.isBigAttachExpireTime(paramViewGroup)) {
          break label194;
        }
        localView.setEnabled(false);
        return localView;
        i = this.attachList.size();
        break;
        label113:
        j = this.bigAttachList.size();
        break label19;
        label125:
        if ((paramInt == 0) && ((i == 0) || (paramInt < i)))
        {
          QMUIHelper.setBackgroundResource(localView, 2130850544);
          break label58;
        }
        if (paramInt != j + i - 1) {
          break label58;
        }
        QMUIHelper.setBackgroundResource(localView, 2130850541);
        break label58;
        label170:
        paramViewGroup = (MailBigAttach)this.bigAttachList.get(paramInt - i);
        renderBigAttach(localView, paramViewGroup);
      }
      label194:
      localView.setTag(Integer.valueOf(paramInt));
      DownloadThumbProgressBar localDownloadThumbProgressBar = (DownloadThumbProgressBar)localView.findViewById(2131373659);
      if (paramViewGroup.isExist()) {
        localDownloadThumbProgressBar.setState(3);
      }
      for (;;)
      {
        localDownloadThumbProgressBar.setTag(Integer.valueOf(paramInt));
        paramViewGroup = localView.findViewById(2131363050);
        paramViewGroup.setOnClickListener(this.attachOptOnClickListener);
        paramViewGroup.setOnLongClickListener(this.attachOptOnLongClickListener);
        paramViewGroup.setOnTouchListener(this.itemOnTouchListener);
        paramViewGroup.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(this.itemOnClickListener);
        localView.setOnLongClickListener(this.itemOnLongClickListener);
        localView.setOnTouchListener(this.itemOnTouchListener);
        return localView;
        paramViewGroup = QMReadEmlActivity.this.getDownloadInfo(paramViewGroup);
        if (paramViewGroup != null)
        {
          if (paramViewGroup.getStatus() == 4)
          {
            localDownloadThumbProgressBar.setState(0);
          }
          else
          {
            if (paramViewGroup.getStatus() == 2) {
              localDownloadThumbProgressBar.setState(1);
            }
            for (;;)
            {
              if (paramViewGroup.getFileSize() <= 0L) {
                break label398;
              }
              localDownloadThumbProgressBar.setCurrProgressNoAnim((int)(100L * paramViewGroup.getDownloadSize() / paramViewGroup.getFileSize()));
              break;
              if (paramViewGroup.getStatus() == 6) {
                localDownloadThumbProgressBar.pause(false);
              }
            }
          }
        }
        else {
          label398:
          localDownloadThumbProgressBar.setState(0);
        }
      }
    }
    
    private void renderAttach(View paramView, Attach paramAttach)
    {
      Object localObject1 = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))).name().toLowerCase(Locale.getDefault());
      ImageView localImageView = (ImageView)paramView.findViewById(2131363052);
      Object localObject2;
      if ((((String)localObject1).equals("image")) && (!QMReadEmlActivity.this.mMailData.getStatus().isProtocolMail()) && (!QMReadEmlActivity.this.mMailData.getStatus().isGroupMail()) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
      {
        localObject2 = QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + paramAttach.getPreview().getIcon();
        int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject2);
        if ((i == 2) || (i == 1))
        {
          localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject2);
          if (localObject2 != null) {
            localImageView.setImageDrawable(new BitmapDrawable(QMReadEmlActivity.this.getResources(), (Bitmap)localObject2));
          }
        }
      }
      for (;;)
      {
        ((TextView)paramView.findViewById(2131372190)).setText(paramAttach.getName() + QMUIKit.ELLIPSIZE_FIXED);
        ((TextView)paramView.findViewById(2131378460)).setText(paramAttach.getSize());
        return;
        setThumbByType(localImageView, (String)localObject1);
        continue;
        setThumbByType(localImageView, (String)localObject1);
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).setAccountId(QMReadEmlActivity.this.mAccountId);
        ((DownloadInfo)localObject1).setUrl((String)localObject2);
        ((DownloadInfo)localObject1).setImageDownloadListener(new QMReadEmlActivity.AttachListViewAdapter.21(this, (String)localObject2, localImageView));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject1);
        continue;
        if ((((String)localObject1).equals("image")) && (QMReadEmlActivity.this.mMailData.getStatus().isProtocolMail()) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
        {
          setThumbByType(localImageView, (String)localObject1);
          if (paramAttach.getPreview() != null)
          {
            localObject1 = paramAttach.getPreview().getMyDisk();
            if (!StringExtention.isNullOrEmpty((String)localObject1)) {
              ImageDownloadManager.shareInstance().getProtocolImageBitmap((String)localObject1, new QMReadEmlActivity.AttachListViewAdapter.22(this, localImageView));
            }
          }
        }
        else
        {
          setThumbByType(localImageView, (String)localObject1);
        }
      }
    }
    
    private void renderAttachList(LinearLayout paramLinearLayout)
    {
      int j = 0;
      paramLinearLayout.removeAllViewsInLayout();
      int k = getAttachListCount();
      int m = getBigAttachListCount();
      int i;
      if (k > 0)
      {
        int n = this.attachList.size();
        i = 0;
        while (i < n)
        {
          paramLinearLayout.addView(getView(i, paramLinearLayout));
          i += 1;
        }
      }
      if (m > 0)
      {
        m = this.bigAttachList.size();
        i = j;
        while (i < m)
        {
          paramLinearLayout.addView(getView(i + k, paramLinearLayout));
          i += 1;
        }
      }
    }
    
    private void renderBigAttach(View paramView, MailBigAttach paramMailBigAttach)
    {
      Object localObject = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramMailBigAttach.getName()))).name().toLowerCase(Locale.getDefault());
      ((ImageView)paramView.findViewById(2131363052)).setImageResource(ImageResourceUtil.getImageResource((String)localObject, ImageResourceUtil.IMAGE_SIZE_58));
      ((TextView)paramView.findViewById(2131372190)).setText(paramMailBigAttach.getName() + QMUIKit.ELLIPSIZE_FIXED);
      TextView localTextView = (TextView)paramView.findViewById(2131378460);
      long l;
      int i;
      if (paramMailBigAttach.isBizNetDiskAttach())
      {
        localObject = QMReadEmlActivity.this.getString(2131690873);
        localTextView.setText(paramMailBigAttach.getSize() + " " + (String)localObject + " ");
        localObject = (TextView)paramView.findViewById(2131379661);
        l = paramMailBigAttach.getExpireTimeMilli();
        if (l <= 0L) {
          break label364;
        }
        paramMailBigAttach = paramMailBigAttach.getExpire();
        paramView = FtnCommonUtils.getExpireTimeString(paramMailBigAttach);
        if ((paramView.equals("已过期")) || (paramView.equals("即将过期"))) {
          break label324;
        }
        i = 1;
        label208:
        if ((paramMailBigAttach.getTime() - new Date().getTime()) / 1000L / 24L / 60L / 60L >= 6L) {
          break label329;
        }
        ((TextView)localObject).setTextColor(QMReadEmlActivity.this.getResources().getColor(2131167539));
        if (i == 0) {
          break label453;
        }
        paramView = paramView + QMReadEmlActivity.this.getString(2131718579);
      }
      label296:
      label324:
      label453:
      for (;;)
      {
        ((TextView)localObject).setText(paramView);
        ((TextView)localObject).setVisibility(0);
        label329:
        label364:
        do
        {
          return;
          localObject = QMReadEmlActivity.this.getString(2131693301);
          break;
          i = 0;
          break label208;
          if (i == 0) {
            break label453;
          }
          paramView = paramView + QMReadEmlActivity.this.getString(2131718580);
          break label296;
          if (paramMailBigAttach.isBizNetDiskAttach())
          {
            ((TextView)localObject).setText(QMReadEmlActivity.this.getString(2131694055));
            ((TextView)localObject).setVisibility(0);
            ((TextView)localObject).setTextColor(QMReadEmlActivity.this.getResources().getColor(2131167531));
            return;
          }
        } while (l != -2L);
        ((TextView)localObject).setText("已过期");
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setTextColor(QMReadEmlActivity.this.getResources().getColor(2131167539));
        return;
      }
    }
    
    private void setThumbByType(ImageView paramImageView, String paramString)
    {
      paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
    }
    
    private void showAttachActionDialog(int paramInt)
    {
      this.isNormalAttach = false;
      this.isBigAttach = false;
      this.isEditAttach = false;
      int i = QMReadEmlActivity.this.mAttachListViewAdapter.getAttachListCount();
      int j = QMReadEmlActivity.this.mAttachListViewAdapter.getBigAttachListCount();
      if (paramInt < i) {
        this.isNormalAttach = true;
      }
      while (QMReadEmlActivity.this.getActivity() == null)
      {
        QMLog.log(6, "QMReadEmlActivity", "getActivity() returns null.");
        return;
        if (paramInt < i + j) {
          this.isBigAttach = true;
        } else {
          this.isEditAttach = true;
        }
      }
      QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(QMReadEmlActivity.this.getActivity());
      Object localObject1;
      if (this.isNormalAttach)
      {
        localObject1 = (Attach)QMReadEmlActivity.this.mMailData.getInformation().getAttachListNoInlineImg().get(paramInt);
        boolean bool1 = QMReadEmlActivity.this.isAttachImage(((Attach)localObject1).getName());
        boolean bool2 = QMReadEmlActivity.this.isImageAttachSingle();
        QMLog.log(4, "QMReadEmlActivity", "show attach more action:" + ((Attach)localObject1).getName());
        localBottomListSheetBuilder.setOnSheetItemClickListener(new QMReadEmlActivity.AttachListViewAdapter.5(this, (Attach)localObject1, paramInt, i));
        localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690550));
        if (!bool1) {
          break label573;
        }
        localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690583));
        label243:
        if ((bool1) && (!bool2)) {
          localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690584));
        }
        Object localObject2 = "";
        if (!this.isBigAttach) {
          break label598;
        }
        Object localObject3 = QMReadEmlActivity.this.mMailData.getInformation().getBigAttachList();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (paramInt - i < ((ArrayList)localObject3).size())
          {
            localObject2 = (MailBigAttach)((ArrayList)localObject3).get(paramInt - i);
            localObject1 = ((MailBigAttach)localObject2).getName();
            localObject3 = ((MailBigAttach)localObject2).getExpire();
            Date localDate = new Date();
            if (((((MailBigAttach)localObject2).isBizNetDiskAttach()) || (((Date)localObject3).getTime() - localDate.getTime() > 0L)) && (QMReadEmlActivity.this.isShowFtnOperEntrance()))
            {
              localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690570));
              if (QMReadEmlActivity.this.mAttachListViewAdapter.getBigAttachListCount() > 1) {
                localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690566));
              }
            }
          }
        }
      }
      for (;;)
      {
        if (!this.isEditAttach) {
          localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690586));
        }
        if ((QMReadEmlActivity.this.isShowSaveToWeiYun()) && (DeviceUtil.isQCloudInstalled()) && (!this.isEditAttach)) {
          localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690572));
        }
        localBottomListSheetBuilder.setTitle((String)localObject1);
        localBottomListSheetBuilder.build().show();
        return;
        if (this.isBigAttach)
        {
          localObject1 = (Attach)QMReadEmlActivity.this.mMailData.getInformation().getBigAttachList().get(paramInt - i);
          break;
        }
        localObject1 = (Attach)QMReadEmlActivity.this.mMailData.getInformation().getEditAttachList().get(paramInt - i - j);
        break;
        label573:
        if (this.isEditAttach) {
          break label243;
        }
        localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690582));
        break label243;
        label598:
        localObject1 = QMReadEmlActivity.this.mMailData.getInformation().getAttachListNoInlineImg();
        if ((localObject1 != null) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size())) {
          localObject1 = ((Attach)((ArrayList)localObject1).get(paramInt)).getName();
        } else {
          localObject1 = "";
        }
      }
    }
    
    private void showCanNotPreviewDialog(int paramInt)
    {
      QMLog.log(4, "QMReadEmlActivity", "can't preview attach of pos " + paramInt);
      QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(QMReadEmlActivity.this.getActivity());
      localBottomListSheetBuilder.setTitle(2131690562);
      localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690555));
      localBottomListSheetBuilder.addItem(QMReadEmlActivity.this.getString(2131690563));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new QMReadEmlActivity.AttachListViewAdapter.6(this));
      localBottomListSheetBuilder.build().show();
    }
    
    private void showCanNotPreviewDownloadConfirmDialog(QMUIDialogAction.ActionListener paramActionListener)
    {
      paramActionListener = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(QMReadEmlActivity.this.getActivity()).setMessage(2131690547).setTitle(2131696424)).addAction(2131691246, new QMReadEmlActivity.AttachListViewAdapter.14(this))).addAction(2131690539, new QMReadEmlActivity.AttachListViewAdapter.13(this, paramActionListener))).create();
      paramActionListener.setOnDismissListener(new QMReadEmlActivity.AttachListViewAdapter.15(this));
      paramActionListener.show();
    }
    
    private void showDownloadConfirmDialog(String paramString1, String paramString2, boolean paramBoolean, QMUIDialogAction.ActionListener paramActionListener)
    {
      String str = QMReadEmlActivity.this.getString(2131690545) + ", “";
      paramString2 = String.format(QMReadEmlActivity.this.getString(2131690549), new Object[] { paramString2 });
      if (paramBoolean) {}
      for (paramString2 = "”" + paramString2 + ", " + QMReadEmlActivity.this.getString(2131690537);; paramString2 = "”" + paramString2 + ", " + QMReadEmlActivity.this.getString(2131690538) + ", " + QMReadEmlActivity.this.getString(2131690537))
      {
        paramActionListener = ((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)new QMUIDialog.CustomDialogBuilder(QMReadEmlActivity.this.getActivity()).setTitle(2131690548)).setLayout(2131559230).addAction(2131691246, new QMReadEmlActivity.AttachListViewAdapter.10(this))).addAction(2131690539, new QMReadEmlActivity.AttachListViewAdapter.9(this, paramActionListener))).create();
        paramActionListener.setOnCancelListener(new QMReadEmlActivity.AttachListViewAdapter.11(this));
        AttachNamesHandlerTextView localAttachNamesHandlerTextView = (AttachNamesHandlerTextView)paramActionListener.findViewById(2131371310);
        localAttachNamesHandlerTextView.setText(str, new String[] { paramString1 }, paramString2, false);
        localAttachNamesHandlerTextView.setVisibility(0);
        paramActionListener.setOnDismissListener(new QMReadEmlActivity.AttachListViewAdapter.12(this));
        paramActionListener.show();
        return;
      }
    }
    
    private void showDownloadErrorDialog()
    {
      QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(QMReadEmlActivity.this.getActivity()).setMessage(2131690546).setTitle(2131696424)).addAction(2131696547, new QMReadEmlActivity.AttachListViewAdapter.7(this))).create();
      localQMUIDialog.setOnDismissListener(new QMReadEmlActivity.AttachListViewAdapter.8(this));
      localQMUIDialog.show();
    }
    
    private void startAttachPreview(Attach paramAttach)
    {
      QMLog.log(4, "QMReadEmlActivity", "startAttachPreview attach " + paramAttach.getName() + " path: " + paramAttach.getPreview().getMyDisk());
      boolean bool1 = AttachToolbox.isAttachEml(paramAttach.getName());
      boolean bool2 = AttachToolbox.isAttachICS(paramAttach.getName());
      Intent localIntent;
      if ((bool1) && (paramAttach.isExist()))
      {
        localIntent = QMReadEmlActivity.createIntentFromEml(QMReadEmlActivity.this.mAccountId, paramAttach, true, false);
        QMReadEmlActivity.this.startActivity(localIntent);
        QMReadEmlActivity.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        if ((paramAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMReadEmlActivity", "eml", "" });
          return;
        }
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMReadEmlActivity", "eml", "" });
        return;
      }
      if ((bool2) && (paramAttach.isExist()))
      {
        localIntent = MailFragmentActivity.createIntentToReadIcsEvent(paramAttach.getPreview().getMyDisk());
        QMReadEmlActivity.this.startActivity(localIntent);
        QMReadEmlActivity.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        if ((paramAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMReadEmlActivity", "ics", "" });
          return;
        }
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "QMReadEmlActivity", "ics", "" });
        return;
      }
      if ((FileUtil.getOpenType(QMReadEmlActivity.this.getActivity(), FileUtil.getFileNameSuffix(paramAttach.getName())) == 0) && (paramAttach.isExist()))
      {
        paramAttach = WebViewPreviewActivity.createIntent(QMReadEmlActivity.this.getActivity(), paramAttach, paramAttach.getFolderId(), true);
        QMReadEmlActivity.this.startActivity(paramAttach);
        return;
      }
      if ((paramAttach instanceof MailBigAttach)) {
        IntentUtil.openFile(QMReadEmlActivity.this.getActivity(), paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailBigAttachPreview);
      }
      for (;;)
      {
        QMReadEmlActivity.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        return;
        IntentUtil.openFile(QMReadEmlActivity.this.getActivity(), paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailNormalAttachPreview);
      }
    }
    
    private void startImageAttachPreview(int paramInt)
    {
      QMLog.log(4, "QMReadEmlActivity", "startImageAttachPreview of pos " + paramInt);
      Object localObject1 = new ArrayList();
      Iterator localIterator = this.attachList.iterator();
      Object localObject2;
      Attach localAttach;
      while (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        localAttach = (Attach)localObject2;
        if (QMReadEmlActivity.this.isAttachImage(localAttach.getName())) {
          ((List)localObject1).add((Attach)localObject2);
        }
      }
      localIterator = this.bigAttachList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        localAttach = (Attach)localObject2;
        if (QMReadEmlActivity.this.isAttachImage(localAttach.getName())) {
          ((List)localObject1).add((Attach)localObject2);
        }
      }
      if (((List)localObject1).size() <= 0)
      {
        QMUIHelper.showToast(QMReadEmlActivity.this.getActivity(), 2131690564, "");
        DataCollector.logException(7, 33, "Event_Error", QMApplicationContext.sharedInstance().getString(2131690564), false);
        return;
      }
      ImageAttachData.loadData((List)localObject1, QMReadEmlActivity.this.mMailData.getStatus().isProtocolMail(), false);
      localObject1 = ImageAttachBucketSelectActivity.createEmlIntent(QMReadEmlActivity.this.mAccountId, paramInt, 0, QMReadEmlActivity.this.mMailData.getStatus().isGroupMail());
      QMReadEmlActivity.this.startActivityForResult((Intent)localObject1, 100);
      QMReadEmlActivity.this.getActivity().overridePendingTransition(2130772422, 2130772419);
    }
    
    public ArrayList<Object> getAttachList()
    {
      return this.attachList;
    }
    
    public ArrayList<Object> getBigAttachList()
    {
      return this.bigAttachList;
    }
    
    public ArrayList<Object> getEditAttachList()
    {
      return this.editAttachList;
    }
    
    public Object getItem(int paramInt)
    {
      int i = getAttachListCount();
      int j = getBigAttachListCount();
      int k = getEditAttachListCount();
      if (paramInt < i) {
        return getAttachList().get(paramInt);
      }
      if ((paramInt >= i) && (paramInt < i + j)) {
        return getBigAttachList().get(paramInt - i);
      }
      if ((paramInt >= i + j) && (paramInt < k + (i + j))) {
        return getEditAttachList().get(paramInt - i - j);
      }
      return null;
    }
    
    public void setAttachList(ArrayList<Object> paramArrayList)
    {
      this.attachList = paramArrayList;
    }
    
    public void setBigAttachList(ArrayList<Object> paramArrayList)
    {
      this.bigAttachList = paramArrayList;
    }
    
    public void setEditAttachList(ArrayList<Object> paramArrayList)
    {
      this.editAttachList = paramArrayList;
    }
    
    public void startAttachmentActivityByPos(int paramInt, String paramString)
    {
      int j;
      int k;
      label20:
      int m;
      label30:
      Object localObject1;
      Object localObject2;
      String str;
      int i;
      label219:
      int n;
      if (this.editAttachList == null)
      {
        j = 0;
        if (this.bigAttachList != null) {
          break label558;
        }
        k = 0;
        if (this.attachList != null) {
          break label570;
        }
        m = 0;
        if ((m > 0) && (paramInt < m))
        {
          localObject1 = (Attach)this.attachList.get(paramInt);
          localObject2 = FileUtil.getFileNameSuffix(((Attach)localObject1).getName());
          str = QMAttachUtils.attachFileType((String)localObject2);
          i = FileUtil.getOpenType(QMReadEmlActivity.this.getActivity(), (String)localObject2);
          KvHelper.eventEmlClickNormalAttach(new double[0]);
          if (!((Attach)localObject1).isExist()) {
            break label689;
          }
          QMLog.log(4, "QMReadEmlActivity", "attach " + ((Attach)localObject1).getName() + " at " + paramInt + " is downloaded");
          if (!StringExtention.isNullOrEmpty(paramString)) {
            break label643;
          }
          QMAttachUtils.attachOpenOssLog(String.valueOf(((Attach)localObject1).getHashId()), ((Attach)localObject1).getPreview().getMyDisk());
          QMLog.log(4, "QMReadEmlActivity", "attach preview type:" + i + " suffix:" + (String)localObject2);
          if (i != 2) {
            break label582;
          }
          showCanNotPreviewDialog(paramInt);
        }
        i = paramInt;
        if (k > 0)
        {
          i = paramInt;
          if (paramInt >= m)
          {
            i = paramInt;
            if (paramInt < m + k)
            {
              i = paramInt - m;
              localObject1 = (MailBigAttach)this.bigAttachList.get(i);
              localObject2 = FileUtil.getFileNameSuffix(((MailBigAttach)localObject1).getName());
              str = QMAttachUtils.attachFileType((String)localObject2);
              n = FileUtil.getOpenType(QMReadEmlActivity.this.getActivity(), (String)localObject2);
              KvHelper.eventEmlClickBigAttach(new double[0]);
              if (!((MailBigAttach)localObject1).isExist()) {
                break label849;
              }
              QMLog.log(4, "QMReadEmlActivity", "bigAttach " + ((MailBigAttach)localObject1).getName() + " at " + i + " is downloaded");
              if (!StringExtention.isNullOrEmpty(paramString)) {
                break label803;
              }
              QMAttachUtils.attachOpenOssLog(String.valueOf(((MailBigAttach)localObject1).getHashId()), ((MailBigAttach)localObject1).getPreview().getMyDisk());
              QMLog.log(4, "QMReadEmlActivity", "bigAttach preview type:" + n + " suffix:" + (String)localObject2);
              if (n != 2) {
                break label739;
              }
              showCanNotPreviewDialog(paramInt);
            }
          }
        }
      }
      label558:
      label570:
      label582:
      label849:
      for (;;)
      {
        if ((j > 0) && (i >= m + k))
        {
          localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(QMReadEmlActivity.this.mAccountId);
          localObject1 = ((MailEditAttach)this.editAttachList.get(i - (m + k))).getUrl();
          paramString = (String)localObject1;
          if ((localObject2 instanceof QQMailAccount)) {
            paramString = (String)localObject1 + "&sid=" + ((QQMailAccount)localObject2).getSid();
          }
          paramString = SimpleWebViewExplorer.createIntent(paramString, SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON);
          QMReadEmlActivity.this.startActivity(paramString);
        }
        return;
        j = this.editAttachList.size();
        break;
        k = this.bigAttachList.size();
        break label20;
        m = this.attachList.size();
        break label30;
        if ((AttachType.valueOf(str) == AttachType.IMAGE) && (!FileUtil.isFileTypeTiff(((Attach)localObject1).getName())))
        {
          startImageAttachPreview(getRelativePosition(paramInt));
          QMReadEmlActivity.access$1902(QMReadEmlActivity.this, paramInt);
          break label219;
        }
        startAttachPreview((Attach)localObject1);
        QMReadEmlActivity.access$1902(QMReadEmlActivity.this, paramInt);
        break label219;
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + paramString, 0).show();
        DownloadUtil.existFileSaveAs((Attach)localObject1, paramString, false);
        break label219;
        QMLog.log(4, "QMReadEmlActivity", "attach " + ((Attach)localObject1).getName() + " at " + paramInt + " is not downloaded");
        break label219;
        label739:
        if ((AttachType.valueOf(str) == AttachType.IMAGE) && (!FileUtil.isFileTypeTiff(((MailBigAttach)localObject1).getName())))
        {
          startImageAttachPreview(getRelativePosition(i + m));
          QMReadEmlActivity.access$1902(QMReadEmlActivity.this, paramInt);
        }
        else
        {
          startAttachPreview((Attach)localObject1);
          QMReadEmlActivity.access$1902(QMReadEmlActivity.this, paramInt);
          continue;
          Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + paramString, 0).show();
          DownloadUtil.existFileSaveAs((Attach)localObject1, paramString, false);
          continue;
          QMLog.log(4, "QMReadEmlActivity", "bigAttach " + ((MailBigAttach)localObject1).getName() + " at " + i + " is not downloaded");
          if (QMReadEmlActivity.this.hasSDCardAndHandleErrorIfNo())
          {
            localObject2 = QMReadEmlActivity.this.mAttachListView.getChildAt(paramInt);
            ((View)localObject2).findViewById(2131378296).setVisibility(8);
            ((View)localObject2).findViewById(2131379661).setVisibility(0);
            localObject2 = (DownloadThumbProgressBar)((View)localObject2).findViewById(2131373659);
            if (StringExtention.isNullOrEmpty(paramString))
            {
              if (((DownloadThumbProgressBar)localObject2).getState() == 0)
              {
                if ((n == 2) && (QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
                {
                  QMLog.log(4, "QMReadEmlActivity", "bigAttach can not preview and with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                  showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), false, new QMReadEmlActivity.AttachListViewAdapter.1(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                }
                else if (n == 2)
                {
                  QMLog.log(4, "QMReadEmlActivity", "bigAttach can not preview download");
                  showCanNotPreviewDownloadConfirmDialog(new QMReadEmlActivity.AttachListViewAdapter.2(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                }
                else if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
                {
                  QMLog.log(4, "QMReadEmlActivity", "bigAttach download with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                  showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), true, new QMReadEmlActivity.AttachListViewAdapter.3(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                }
                else if (QMNetworkUtils.isNetworkConnected())
                {
                  QMLog.log(4, "QMReadEmlActivity", "bigAttach download with wifi");
                  ((DownloadThumbProgressBar)localObject2).start();
                  QMReadEmlActivity.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
                }
                else
                {
                  QMLog.log(4, "QMReadEmlActivity", "bigAttach download without network!");
                  showDownloadErrorDialog();
                }
              }
              else if (((DownloadThumbProgressBar)localObject2).getState() == 2)
              {
                QMLog.log(4, "QMReadEmlActivity", "bigAttach download restart");
                ((DownloadThumbProgressBar)localObject2).start();
                QMReadEmlActivity.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
              }
              else if (((DownloadThumbProgressBar)localObject2).getState() == 1)
              {
                QMLog.log(4, "QMReadEmlActivity", "bigAttach download pause");
                ((DownloadThumbProgressBar)localObject2).pause(false);
                QMReadEmlActivity.this.abortDownloadBigAttach((MailBigAttach)localObject1);
              }
            }
            else
            {
              QMLog.log(4, "QMReadEmlActivity", "bigAttach download with save path " + paramString);
              if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
              {
                QMLog.log(4, "QMReadEmlActivity", "bigAttach download with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), true, new QMReadEmlActivity.AttachListViewAdapter.4(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
              }
              else if (QMNetworkUtils.isNetworkConnected())
              {
                QMLog.log(4, "QMReadEmlActivity", "bigAttach download with wifi");
                ((DownloadThumbProgressBar)localObject2).start();
                QMReadEmlActivity.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
              }
              else
              {
                QMLog.log(4, "QMReadEmlActivity", "bigAttach download without network!");
                showDownloadErrorDialog();
              }
            }
          }
        }
      }
    }
  }
  
  static class SeqDownloadInfo
  {
    static int lastCount;
    int currentCount;
    int errCode;
    int failCount;
    String filePath;
    boolean isComplete = false;
    boolean isDownSuccess = false;
    int successCount;
    int totalCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity
 * JD-Core Version:    0.7.0.1
 */