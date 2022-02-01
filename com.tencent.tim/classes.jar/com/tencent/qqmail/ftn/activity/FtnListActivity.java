package com.tencent.qqmail.ftn.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.activity.ImagePagerActivity;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnLogicStorage;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnComposeInfo;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.ftn.util.FtnCommonUtils.SingleSizeInfo;
import com.tencent.qqmail.ftn.util.FtnDialogUtils;
import com.tencent.qqmail.model.ImageSizeInfo;
import com.tencent.qqmail.model.InterAppsManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMFtnUploadNotification;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import moai.oss.KvHelper;
import rx.Observable;

public class FtnListActivity
  extends BaseActivityEx
{
  public static final String ACTION_CAMERA = "camera";
  public static final String ACTION_FILE = "file";
  public static final String ACTION_IMAGE = "image";
  public static final String ARG_ACTION = "action";
  public static final String ARG_FROM = "from";
  public static final String ARG_FTN_UNREAD_INFO = "arg_ftn_unread_info";
  public static final String ARG_FTN_UNREAD_IS_UPDATE = "arg_ftn_unread_isupdate";
  public static final String ARG_OPEN_UPLOAD = "arg_open_upload";
  public static final int RESULT_FTN_UNREAD_UPDATE = 9;
  private static final int SHOW_STATUS_ERROR = 4;
  private static final int SHOW_STATUS_FILE = 3;
  private static final int SHOW_STATUS_LOADING = 1;
  private static final int SHOW_STATUS_NOFILE = 2;
  private static final int SHOW_STATUS_NOT_OPEN = 5;
  public static final String TAG = "FtnListActivity";
  public static long mPreserverDay = 30L;
  public static int mRenewDay = 7;
  public static long mSingleMaxSize = 2147483648L;
  private int animationType;
  private QMBaseView baseView;
  private QMBottomBar bottomBar;
  private View.OnClickListener cancelCompressListener = new FtnListActivity.41(this);
  private QMBottomDialog compressDialog;
  private Dialog currentDialog;
  private ComposeMailUI.ImageScaleDegree degree = ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin;
  private boolean firstShowList = true;
  private FtnListAdapter ftnListAdapter;
  private PtrListView ftnListView;
  private FtnQueryAccountWatcher ftnQueryAccountWatcher = new FtnListActivity.2(this);
  private FtnQueryExpireUnreadWatcher ftnQueryExpireUnreadWatcher = new FtnListActivity.1(this);
  private View.OnClickListener highCompressListener = new FtnListActivity.39(this);
  private ImageSizeInfo imageSizeInfo;
  private volatile boolean isCompressProcess = false;
  private boolean isEditing = false;
  private boolean isMultiOperation = false;
  private boolean isNeedChooseCompressImage = false;
  private boolean isRestoreLastPosition = false;
  private boolean isSelectAll = false;
  private boolean isUploadContinue = false;
  private boolean isZip = false;
  private int lastIndex = -1;
  private int lastTop = -1;
  private QMContentLoadingView listEmptyView;
  private View.OnClickListener lowCompressListener = new FtnListActivity.37(this);
  private QQMailAccount mAccount;
  private ArrayList<CheckBox> mCheckBox = new ArrayList();
  private SparseArray<FileInfo> mCheckFid = new SparseArray();
  private SparseBooleanArray mChecked = new SparseBooleanArray();
  private View mCurSelectView = null;
  private FtnExpireInfo mFtnExpireInfo = null;
  private FtnManager mFtnManager = FtnManager.sharedInstance();
  private boolean mIsUpdateUnread = false;
  private CurSelectItem mSelectItem = new CurSelectItem(null);
  private View.OnClickListener middleCompressListener = new FtnListActivity.38(this);
  private int multiOperationCount = 0;
  private Object multiOperationLock = new Object();
  private IObserver observerCreateFileError = new FtnListActivity.16(this, null);
  private IObserver observerCreateFileSuccess = new FtnListActivity.15(this, null);
  private IObserver observerDelFileError = new FtnListActivity.6(this, null);
  private IObserver observerDelFileSuccess = new FtnListActivity.5(this, null);
  private IObserver observerGetListError = new FtnListActivity.4(this, null);
  private IObserver observerGetListSuccess = new FtnListActivity.3(this, null);
  private IObserver observerRenewFileError = new FtnListActivity.8(this, null);
  private IObserver observerRenewFileSuccess = new FtnListActivity.7(this, null);
  private IObserver observerSignFileError = new FtnListActivity.11(this, null);
  private IObserver observerSignFileSuccess = new FtnListActivity.10(this, null);
  private IObserver observerUploadFileError = new FtnListActivity.14(this, null);
  private IObserver observerUploadFileProgress = new FtnListActivity.12(this, null);
  private IObserver observerUploadFileSuccess = new FtnListActivity.13(this, null);
  private IObserver observerWebPush = new FtnListActivity.9(this, null);
  private View.OnClickListener originCompressListener = new FtnListActivity.40(this);
  private PopularizeBanner popularizeBanner;
  private HashMap<String, Boolean> realPauseSet = new HashMap();
  private QMSearchBar searchBar;
  private QMTips tips;
  private QMTopBar topBar;
  private int uploadFileFailCount = 0;
  private Object uploadFileFailCountLock = new Object();
  private int waitCompressCount = 0;
  private Object waitCompressCountLock = new Object();
  private CopyOnWriteArrayList<FtnUploadInfo> waitCompressImages = new CopyOnWriteArrayList();
  private SparseBooleanArray waitCompressStates = new SparseBooleanArray();
  private CopyOnWriteArrayList<FtnUploadInfo> waitUploadFiles = new CopyOnWriteArrayList();
  
  private void bindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("actiongetlistsucc", this.observerGetListSuccess);
      QMNotification.registNotification("actiongetlisterror", this.observerGetListError);
      QMNotification.registNotification("actionsignfilesucc", this.observerSignFileSuccess);
      QMNotification.registNotification("actionsignfileerror", this.observerSignFileError);
      QMNotification.registNotification("actioncreatefilesucc", this.observerCreateFileSuccess);
      QMNotification.registNotification("actioncreatefileerror", this.observerCreateFileError);
      QMNotification.registNotification("actionuploadfileprogress", this.observerUploadFileProgress);
      QMNotification.registNotification("actionuploadfilesucc", this.observerUploadFileSuccess);
      QMNotification.registNotification("actionuploadfileerror", this.observerUploadFileError);
      QMNotification.registNotification("actiondelfilesucc", this.observerDelFileSuccess);
      QMNotification.registNotification("actiondelfileerror", this.observerDelFileError);
      QMNotification.registNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
      QMNotification.registNotification("actionrenewfileerror", this.observerRenewFileError);
      QMNotification.registNotification("receivePushFTN", this.observerWebPush);
    }
    for (;;)
    {
      FtnManager localFtnManager = this.mFtnManager;
      if (localFtnManager != null)
      {
        localFtnManager.bindFtnQueryAccountListener(this.ftnQueryAccountWatcher, paramBoolean);
        localFtnManager.bindFtnQueryExpireUnreadListener(this.ftnQueryExpireUnreadWatcher, paramBoolean);
      }
      return;
      QMNotification.unregistNotification("actiongetlistsucc", this.observerGetListSuccess);
      QMNotification.unregistNotification("actiongetlisterror", this.observerGetListError);
      QMNotification.unregistNotification("actionsignfilesucc", this.observerSignFileSuccess);
      QMNotification.unregistNotification("actionsignfileerror", this.observerSignFileError);
      QMNotification.unregistNotification("actioncreatefilesucc", this.observerCreateFileSuccess);
      QMNotification.unregistNotification("actioncreatefileerror", this.observerCreateFileError);
      QMNotification.unregistNotification("actionuploadfileprogress", this.observerUploadFileProgress);
      QMNotification.unregistNotification("actionuploadfilesucc", this.observerUploadFileSuccess);
      QMNotification.unregistNotification("actionuploadfileerror", this.observerUploadFileError);
      QMNotification.unregistNotification("actiondelfilesucc", this.observerDelFileSuccess);
      QMNotification.unregistNotification("actiondelfileerror", this.observerDelFileError);
      QMNotification.unregistNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
      QMNotification.unregistNotification("actionrenewfileerror", this.observerRenewFileError);
      QMNotification.unregistNotification("receivePushFTN", this.observerWebPush);
    }
  }
  
  private void buildComposeData(ArrayList<FtnComposeInfo> paramArrayList)
  {
    paramArrayList.clear();
    int i = 0;
    while (i < this.mCheckFid.size())
    {
      FileInfo localFileInfo = (FileInfo)this.mCheckFid.valueAt(i);
      paramArrayList.add(FtnCommonUtils.fileInfo2ComposeInfo(this.mAccount.getUin(), localFileInfo));
      i += 1;
    }
  }
  
  private void calcImageSize(CopyOnWriteArrayList<FtnUploadInfo> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (this.imageSizeInfo == null) {
        this.imageSizeInfo = new ImageSizeInfo();
      }
      this.imageSizeInfo.reset();
      int i = 0;
      while (i < paramCopyOnWriteArrayList.size())
      {
        FtnCommonUtils.SingleSizeInfo localSingleSizeInfo = FtnCommonUtils.estimateSize(((FtnUploadInfo)paramCopyOnWriteArrayList.get(i)).getAbsolutePath());
        ImageSizeInfo localImageSizeInfo = this.imageSizeInfo;
        localImageSizeInfo.lowSize += (int)localSingleSizeInfo.getLowSize();
        localImageSizeInfo = this.imageSizeInfo;
        localImageSizeInfo.middleSize += (int)localSingleSizeInfo.getMiddleSize();
        localImageSizeInfo = this.imageSizeInfo;
        localImageSizeInfo.highSize += (int)localSingleSizeInfo.getHighSize();
        localImageSizeInfo = this.imageSizeInfo;
        localImageSizeInfo.realSize += (int)localSingleSizeInfo.getRealSize();
        i += 1;
      }
    }
  }
  
  private void changeShowStatus(int paramInt)
  {
    QMLog.log(2, "FtnListActivity", "changeShowStatus:" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      showNormal();
      return;
    case 2: 
      showNoFile();
      return;
    case 4: 
      showError();
      return;
    case 1: 
      showLoading();
      return;
    }
    showNoOpen();
  }
  
  private void clearCheck()
  {
    this.ftnListView.clearChoices();
    this.ftnListView.invalidateViews();
    this.mCheckFid.clear();
    this.mChecked.clear();
  }
  
  private void clearWaitCompress()
  {
    synchronized (this.waitCompressCountLock)
    {
      this.waitCompressImages.clear();
      this.waitCompressCount = 0;
      return;
    }
  }
  
  private void clearWaitUploadFiles()
  {
    this.waitUploadFiles.clear();
  }
  
  private void clickCameraButton()
  {
    String str = FileUtil.getAttachDownloadDir();
    if ((str != null) && (!str.equals("")))
    {
      str = FileUtil.createPhotoDirAtRootPath(str) + QMAttachUtils.generateUploadFileName(null);
      QMCameraManager.sharedInstance().setCameraPhotoPath(str);
      RxPermissions.getInstance(getActivity()).request(new String[] { "android.permission.CAMERA" }).subscribe(new FtnListActivity.46(this));
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), "还没有创建缓存目录", 0).show();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), FtnListActivity.class);
  }
  
  public static Intent createIntentWithUpload()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), FtnListActivity.class);
    localIntent.putExtra("arg_open_upload", true);
    return localIntent;
  }
  
  private void createUploadCompressDialog()
  {
    this.compressDialog = FtnDialogUtils.createChooseCompressImageDialog(this, this.imageSizeInfo, this.lowCompressListener, this.middleCompressListener, this.highCompressListener, this.originCompressListener, this.cancelCompressListener);
  }
  
  private void doCompressImages(ComposeMailUI.ImageScaleDegree paramImageScaleDegree)
  {
    if (paramImageScaleDegree != ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin) {
      showCompressImageLoading();
    }
    Threads.runInBackground(new FtnListActivity.47(this, paramImageScaleDegree));
  }
  
  private void dragFtnFileByOneStep(View paramView, FileInfo paramFileInfo)
  {
    if (!OneStepUtils.isOneStepShowing()) {}
    Object localObject;
    do
    {
      do
      {
        FtnManager localFtnManager;
        do
        {
          return;
          localObject = paramFileInfo.fid;
          localFtnManager = FtnManager.sharedInstance();
        } while ((localFtnManager == null) || (StringExtention.isNullOrEmpty((String)localObject)));
        localObject = localFtnManager.getDownloadInfo((String)localObject);
      } while (localObject == null);
      localObject = ((FtnDownloadInfo)localObject).getSavePath();
    } while (!FileUtil.isFileExist((String)localObject));
    if (QMAttachUtils.isSuffixImage(FileUtil.getFileNameSuffix(paramFileInfo.filename)))
    {
      OneStepUtils.dragImageByOneStep(paramView, (String)localObject);
      return;
    }
    OneStepUtils.dragFileByOneStep(paramView, (String)localObject, paramFileInfo.filename);
  }
  
  private void enableBottomBar(boolean paramBoolean)
  {
    if (this.bottomBar != null)
    {
      int i = 0;
      if (i < 3)
      {
        Button localButton;
        if ((this.bottomBar.getChildAt(i) instanceof FrameLayout))
        {
          localButton = (Button)((FrameLayout)this.bottomBar.getChildAt(i)).getChildAt(0);
          if (localButton != null) {
            localButton.setEnabled(paramBoolean);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((this.bottomBar.getChildAt(i) instanceof Button))
          {
            localButton = (Button)this.bottomBar.getChildAt(i);
            if (localButton != null) {
              localButton.setEnabled(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private void flushUploadPbProgress(FtnUploadInfo paramFtnUploadInfo, int paramInt, double paramDouble)
  {
    if ((!paramFtnUploadInfo.needFlushProgress.getAndSet(false)) && (paramInt != 100)) {
      return;
    }
    Threads.runOnMainThread(new FtnListActivity.48(this, paramFtnUploadInfo, paramInt, paramDouble));
    Threads.runInBackground(new FtnListActivity.49(this, paramFtnUploadInfo), 500L);
  }
  
  private boolean fromPlusMenu()
  {
    boolean bool2 = false;
    Intent localIntent = getIntent();
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      bool1 = bool2;
      if (localIntent.getBooleanExtra("arg_open_upload", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Object getItemAtPosition(int paramInt)
  {
    if (paramInt < 0) {}
    do
    {
      return null;
      paramInt -= this.ftnListView.getHeaderViewsCount();
    } while (paramInt < 0);
    return this.ftnListAdapter.getItem(paramInt);
  }
  
  private boolean getRealPause(String paramString)
  {
    if (this.realPauseSet.containsKey(paramString)) {
      return ((Boolean)this.realPauseSet.get(paramString)).booleanValue();
    }
    return false;
  }
  
  private void goToQQBrowserFileExplorer()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.QQBrowser.action.sdk.picker");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.putExtra("isMultiSelect", true);
      startActivityForResult(localIntent, 100);
      overridePendingTransition(2130772401, 2130772430);
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(4, "FtnListActivity", "goToQQBrowserFileExplorer", localException);
    }
  }
  
  private void goToSystemFileExplorer()
  {
    Intent localIntent = new Intent(getActivity(), SdcardFileExplorer.class);
    localIntent.putExtra("intentType", QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN.toString());
    localIntent.putExtra("multiChoose", true);
    startActivityForResult(localIntent, 5);
  }
  
  private void handleComposeMail()
  {
    buildComposeData(FtnLogicStorage.getComposeInfos());
    if (FtnLogicStorage.getComposeInfos().size() != 0)
    {
      startActivity(ComposeMailActivity.createIntentFromFtn(getClass().getName()));
      toNormalView();
      showComposeTipsLoading();
      return;
    }
    showTipsNoFileSelected();
  }
  
  private void handleDeleteConfirm()
  {
    if (this.mCheckFid.size() != 0)
    {
      this.currentDialog = FtnDialogUtils.createDeleteConfirmDialog(this, new FtnListActivity.27(this), new FtnListActivity.28(this));
      return;
    }
    showTipsNoFileSelected();
  }
  
  private void handleRenew()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < this.mCheckFid.size())
    {
      FileInfo localFileInfo = (FileInfo)this.mCheckFid.valueAt(i);
      localArrayList1.add(localFileInfo.fid);
      localArrayList2.add(Integer.valueOf(localFileInfo.expiretime - 2));
      i += 1;
    }
    if (localArrayList1.size() != 0)
    {
      this.mFtnManager.renewFile(localArrayList1, localArrayList2);
      setMultiOperationStatus(localArrayList1.size());
      showRenewTipsLoading();
      return;
    }
    showTipsNoFileSelected();
  }
  
  private void handleSelectFile(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      FtnListAdapter localFtnListAdapter = this.ftnListAdapter;
      int j = paramArrayOfString.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfString[i];
        int k = FtnCommonUtils.detectFileSizeLegal((String)localObject, 0L, 2147483648L);
        if (k == 0)
        {
          changeShowStatus(3);
          localObject = new FtnUploadInfo(this, (String)localObject, 1, -1);
          localFtnListAdapter.putUploadItem((FtnUploadInfo)localObject);
          this.mFtnManager.signFile((FtnUploadInfo)localObject);
          this.waitUploadFiles.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == -1) {
            showUploadErrEmptyFile();
          } else if (k == 1) {
            showUploadErrOverSize();
          } else {
            showUploadErrFileNotExist();
          }
        }
      }
      localFtnListAdapter.notifyDataSetChanged();
    }
  }
  
  private void handleSelectFromOtherApp()
  {
    InterAppsManager localInterAppsManager = InterAppsManager.getInstance();
    FtnListAdapter localFtnListAdapter = this.ftnListAdapter;
    Iterator localIterator = localInterAppsManager.getFilePaths().iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      FtnUploadInfo localFtnUploadInfo;
      label114:
      int n;
      if (str != null)
      {
        j = FtnCommonUtils.detectFileSizeLegal(str, 0L, 2147483648L);
        if (j == 0)
        {
          localFtnUploadInfo = new FtnUploadInfo(this, str, 1, -1);
          if (FtnCommonUtils.getFileType(str).equals("image"))
          {
            this.waitCompressImages.add(localFtnUploadInfo);
            i += 1;
            n = k;
            k = j;
            j = i;
            i = n;
          }
        }
      }
      for (;;)
      {
        localFtnListAdapter.notifyDataSetChanged();
        n = k;
        k = i;
        i = j;
        j = n;
        break;
        localFtnListAdapter.putUploadItem(localFtnUploadInfo);
        this.mFtnManager.signFile(localFtnUploadInfo);
        this.waitUploadFiles.add(localFtnUploadInfo);
        break label114;
        m += 1;
        break;
        int i1 = k + 1;
        k = i;
        n = j;
        i = i1;
        j = k;
        k = n;
      }
    }
    if ((localInterAppsManager.getFilePaths().size() == k) || (localInterAppsManager.getFilePaths().size() == 0))
    {
      showUploadErrFileNotExist();
      return;
    }
    if (m > 0)
    {
      if (localInterAppsManager.getFilePaths().size() != 1) {
        break label325;
      }
      if (j != -1) {
        break label306;
      }
      showUploadErrEmptyFile();
    }
    for (;;)
    {
      QMLog.log(6, "FtnListActivity", "Handle select image upload part fail, size exception count: " + m);
      if (i <= 0) {
        break;
      }
      calcImageSize(this.waitCompressImages);
      createUploadCompressDialog();
      return;
      label306:
      if (j == 1)
      {
        showUploadErrOverSize();
      }
      else
      {
        showUploadErrFileNotExist();
        continue;
        label325:
        showUploadErrPartSizeExcept(m);
      }
    }
  }
  
  private void handleSelectImage(Intent paramIntent)
  {
    clearWaitCompress();
    clearWaitUploadFiles();
    paramIntent = MediaFolderSelectActivity.getSelectedResult();
    MediaFolderSelectActivity.setSelectedResult(null);
    if (paramIntent != null)
    {
      int i = 0;
      int k = 1;
      int j = 0;
      if (i < paramIntent.size())
      {
        Object localObject = (AttachInfo)paramIntent.get(i);
        if (((AttachInfo)localObject).isImage()) {
          k = 0;
        }
        if (FtnCommonUtils.detectFileSizeLegal(((AttachInfo)localObject).getAttachPath(), 0L, 2147483648L) == 0)
        {
          localObject = new FtnUploadInfo(this, ((AttachInfo)localObject).getAttachPath(), 1, this.mFtnManager.syncFtnUploadIndex());
          this.waitCompressImages.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          j += 1;
        }
      }
      if (j > 0)
      {
        showUploadErrPartSizeExcept(j);
        QMLog.log(6, "FtnListActivity", "Handle select image upload part fail, size exception count: " + j);
      }
      if ((k == 0) && (this.waitCompressImages.size() > 0))
      {
        calcImageSize(this.waitCompressImages);
        createUploadCompressDialog();
        changeShowStatus(3);
      }
    }
    else
    {
      return;
    }
    changeShowStatus(3);
    initCompressImages();
    this.degree = ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin;
  }
  
  private void handleTakePhoto(Intent paramIntent)
  {
    paramIntent = new File(QMCameraManager.sharedInstance().getCameraPhotoPath());
    if (paramIntent.length() > 0L)
    {
      paramIntent = paramIntent.getAbsolutePath();
      changeShowStatus(3);
      clearWaitCompress();
      clearWaitUploadFiles();
      paramIntent = new FtnUploadInfo(this, paramIntent, 1, this.mFtnManager.syncFtnUploadIndex());
      this.waitCompressImages.add(paramIntent);
      this.waitCompressStates.put(0, false);
      calcImageSize(this.waitCompressImages);
      createUploadCompressDialog();
      return;
    }
    QMLog.log(6, "Take-photo", "pic exist: " + paramIntent.exists() + " path: " + QMCameraManager.sharedInstance().getCameraPhotoPath());
  }
  
  private void handleUploadFileAction(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (!isExternalUpload());
      if (paramString.equals("camera"))
      {
        clickCameraButton();
        return;
      }
      if (paramString.equals("image"))
      {
        QMAlbumManager.shareInstance().startAlbum(this, QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN);
        return;
      }
    } while (!paramString.equals("file"));
    paramString = new Intent(getActivity(), SdcardFileExplorer.class);
    paramString.putExtra("intentType", QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN.toString());
    paramString.putExtra("multiChoose", true);
    startActivityForResult(paramString, 5);
  }
  
  private void hiddenBottomBar()
  {
    if (this.bottomBar != null) {
      this.bottomBar.setVisibility(8);
    }
  }
  
  private void hideDialog()
  {
    if (this.currentDialog != null) {
      this.currentDialog.cancel();
    }
  }
  
  private void hideTips()
  {
    if (this.tips != null) {
      this.tips.hide();
    }
  }
  
  private void initBottomBarButton()
  {
    this.bottomBar.addButton(1, getString(2131692498), new FtnListActivity.23(this));
    this.bottomBar.addButton(0, getString(2131694070), new FtnListActivity.24(this));
    this.bottomBar.addButton(0, getString(2131719473), new FtnListActivity.25(this));
  }
  
  private void initCompressImages()
  {
    this.isCompressProcess = true;
    synchronized (this.waitCompressCountLock)
    {
      this.waitCompressCount = this.waitCompressImages.size();
      int i = 0;
      while (i < this.waitCompressCount)
      {
        this.mFtnManager.signFile((FtnUploadInfo)this.waitCompressImages.get(i));
        i += 1;
      }
      this.ftnListView.setSelection(0);
      return;
    }
  }
  
  private void initListView()
  {
    this.ftnListView.setDividerHeight(0);
    this.ftnListView.setOnItemClickListener(new FtnListActivity.34(this));
    this.ftnListView.setOnItemLongClickListener(new FtnListActivity.35(this));
    this.ftnListView.setOnRefreshListener(new FtnListActivity.36(this));
    this.popularizeBanner.render(this.ftnListView, false);
    this.ftnListView.addHeaderView(this.searchBar);
    this.ftnListAdapter = new FtnListAdapter(this.ftnListView, this);
    this.ftnListView.setAdapter(this.ftnListAdapter);
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(5);
  }
  
  private void initSearchBar()
  {
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.searchBar = new QMSearchBar(this);
    this.searchBar.setStateNormal();
    this.searchBar.setLayoutParams(localLayoutParams);
    this.searchBar.setBtnRight();
    this.searchBar.getBtnRight().setText(2131693000);
    this.searchBar.getBtnRight().setVisibility(8);
    this.searchBar.getBtnRight().setOnClickListener(new FtnListActivity.19(this));
    this.searchBar.setSearchHint(2131694073);
    this.searchBar.searchInitWrap.setOnTouchListener(new FtnListActivity.20(this));
  }
  
  private void initTips()
  {
    this.tips = new QMTips(this);
    this.tips.setCanceledOnTouchOutside(true);
  }
  
  private void initTopBar()
  {
    refreshTopBar();
  }
  
  private void initUnFinishUploadState()
  {
    this.isUploadContinue = QMApplicationContext.sharedInstance().isFtnUploadContinue();
    QMApplicationContext.sharedInstance().setFtnUploadContinue(true);
  }
  
  private boolean isAbortTime2GetList()
  {
    synchronized (this.uploadFileFailCountLock)
    {
      int i = this.ftnListAdapter.getUploadItemCount();
      if ((i == 0) || (i - this.uploadFileFailCount == 0))
      {
        this.uploadFileFailCount = 0;
        return true;
      }
      return false;
    }
  }
  
  private boolean isCancelUpload(int paramInt, Intent paramIntent)
  {
    return ((paramIntent == null) && (paramInt != 3)) || ((paramIntent != null) && (paramInt == 3));
  }
  
  private boolean isExternalUpload()
  {
    String str = getIntent().getStringExtra("action");
    return (str != null) && ((str.equals("camera")) || (str.equals("image")) || (str.equals("file")));
  }
  
  private boolean isNetworkConnect()
  {
    return QMNetworkUtils.isNetworkConnected(this);
  }
  
  private void itemClickEdit(int paramInt)
  {
    int i = paramInt - this.ftnListView.getHeaderViewsCount();
    Object localObject = this.ftnListAdapter.getItem(i);
    if ((localObject instanceof FileInfo))
    {
      localObject = (FileInfo)localObject;
      if (!this.ftnListView.isItemChecked(paramInt)) {
        break label109;
      }
      this.mChecked.put(i, true);
      this.mCheckFid.put(i, localObject);
      this.ftnListView.setItemChecked(paramInt, true);
      paramInt = this.mChecked.size();
      if (paramInt != this.ftnListAdapter.getFtnUI().getCount()) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      setTopBarAllSelectState(bool);
      renderTopBarTitleForEditMode(paramInt);
      return;
      label109:
      this.mChecked.delete(i);
      this.mCheckFid.remove(i);
      this.ftnListView.setItemChecked(paramInt, false);
      break;
    }
  }
  
  private void itemClickNormal(int paramInt)
  {
    FileInfo localFileInfo = (FileInfo)getItemAtPosition(paramInt);
    MailBigAttach localMailBigAttach = new MailBigAttach(false);
    localMailBigAttach.setAccountId(this.mAccount.getId());
    String str2 = localFileInfo.filename;
    String str1 = FileUtil.getFileNameSuffix(str2);
    localMailBigAttach.setFid(localFileInfo.fid);
    localMailBigAttach.setName(str2);
    localMailBigAttach.setSuffix(str1);
    long l2 = localFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    localMailBigAttach.setSize(l1 + "");
    if (FtnCommonUtils.getFileType(str2).equals("compress")) {
      this.isZip = true;
    }
    for (;;)
    {
      localMailBigAttach.getPreview().setItype(AttachType.valueOf(QMAttachUtils.attachFileType(str1)));
      localMailBigAttach.getPreview().setIviewtype(localFileInfo.viewtype + "");
      localMailBigAttach.setCode(localFileInfo.code);
      localMailBigAttach.setKey(localFileInfo.key);
      localMailBigAttach.setSha(localFileInfo.sha);
      localMailBigAttach.setMd5(localFileInfo.md5);
      localMailBigAttach.setType("qqmail");
      localMailBigAttach.setExpire(new Date(localFileInfo.expiretime * 1000L));
      localMailBigAttach.getPreview().setDownloadUrl("http://mail.qq.com/cgi-bin/ftnExs_download?k=" + localFileInfo.key + "&t=exs_ftn_download&code=" + localFileInfo.code);
      localMailBigAttach.setCreateTime(localFileInfo.createtime);
      localMailBigAttach.setBytes(l1);
      localMailBigAttach.setDownloadTimes(localFileInfo.downloadtimes);
      this.mSelectItem.fid = localMailBigAttach.getFid();
      this.mSelectItem.filename = localMailBigAttach.getName();
      this.mSelectItem.fileInfo = localFileInfo;
      str2 = FtnCommonUtils.getExpireTimeString(new Date((int)localMailBigAttach.getExpire().getTime() / 1000 * 1000L));
      if ((!str2.equals("已过期")) && (!str2.equals("小时"))) {
        this.mSelectItem.aboutExpire = false;
      }
      try
      {
        for (;;)
        {
          localMailBigAttach.setInfoBytes(localFileInfo.toByteArray());
          if (!QMAttachUtils.isSuffixImage(str1)) {
            break label494;
          }
          startActivityForResult(ImagePagerActivity.createIntent(localMailBigAttach, paramInt, "from_ftnlist"), 2);
          return;
          this.isZip = false;
          break;
          this.mSelectItem.aboutExpire = true;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
        label494:
        startActivityForResult(FtnAttachmentActivity.createIntentToPreview(getActivity(), localMailBigAttach), 9);
      }
    }
  }
  
  private void recoverPauseUpload()
  {
    int j = this.ftnListAdapter.getUploadItemCount();
    QMLog.log(4, "FtnListActivity", "recoverPauseUpload, uploadItemCount: " + j);
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = this.ftnListAdapter.getUploadItem(i);
      if (localObject != null)
      {
        String str = ((FtnUploadInfo)localObject).getFid();
        if ((str != null) && (!str.equals(""))) {
          this.mFtnManager.abortRequest(((FtnUploadInfo)localObject).getFid());
        }
      }
      i += 1;
    }
    if ((this.mFtnManager != null) && (this.ftnListAdapter != null))
    {
      localObject = this.mFtnManager.getUploadInfo();
      QMLog.log(4, "FtnListActivity", "recoverPauseUpload, pauseUploadItem: " + localObject);
      this.ftnListAdapter.putUploadItemsPause((List)localObject);
    }
  }
  
  private void recoverUnFinishUpload()
  {
    if ((this.mFtnManager != null) && (this.ftnListAdapter != null))
    {
      ArrayList localArrayList = this.mFtnManager.getAllUploadData();
      QMLog.log(4, "FtnListActivity", "recoverUnFinishUpload, unfinishUploadItems: " + localArrayList);
      this.ftnListAdapter.putUploadItemsUnFinish(localArrayList);
    }
  }
  
  private FtnUserProfile recoverUserProfile()
  {
    FtnUserProfile localFtnUserProfile2 = this.mFtnManager.getUserProfile(this.mAccount.getUin());
    FtnUserProfile localFtnUserProfile1;
    if (localFtnUserProfile2 == null) {
      localFtnUserProfile1 = null;
    }
    long l2;
    do
    {
      do
      {
        return localFtnUserProfile1;
        int i = localFtnUserProfile2.getRenewDay();
        long l1 = localFtnUserProfile2.getPreserverDay();
        l2 = localFtnUserProfile2.getSingleMaxSize();
        if ((i >= 7) && (i != mRenewDay)) {
          mRenewDay = i;
        }
        if ((l1 > 0L) && (l1 != mPreserverDay)) {
          mPreserverDay = l1;
        }
        localFtnUserProfile1 = localFtnUserProfile2;
      } while (l2 <= 0L);
      localFtnUserProfile1 = localFtnUserProfile2;
    } while (l2 == mSingleMaxSize);
    mSingleMaxSize = l2;
    return localFtnUserProfile2;
  }
  
  private void refreshTopBar()
  {
    if (!this.isEditing)
    {
      this.topBar.setTitle(2131694083);
      if (AccountManager.shareInstance().getAccountList().getPureQQMailAccountNumber() > 1)
      {
        Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(QMSettingManager.sharedInstance().getDefaultFtnAccountID());
        this.topBar.setSubTitle(localAccount.getEmail());
      }
      this.topBar.setButtonLeftBack();
      if (fromPlusMenu()) {
        this.topBar.setButtonLeftIcon(2130841088);
      }
      this.topBar.setButtonRightIcon(2130841098);
      this.topBar.getButtonRight().setContentDescription(getString(2131720830));
    }
    for (;;)
    {
      this.topBar.setButtonLeftOnclickListener(new FtnListActivity.21(this));
      this.topBar.setButtonRightOnclickListener(new FtnListActivity.22(this));
      return;
      this.topBar.setButtonLeftNormal(2131719469);
      this.topBar.setButtonRightBlue(2131691246);
    }
  }
  
  private void releaseFtnUI(FtnUI paramFtnUI)
  {
    if (paramFtnUI != null) {
      paramFtnUI.release();
    }
  }
  
  private void removeRealPause(String paramString)
  {
    if (this.realPauseSet.containsKey(paramString)) {
      this.realPauseSet.remove(paramString);
    }
  }
  
  private void removeUnFinishUploadItem(FtnUploadInfo paramFtnUploadInfo)
  {
    this.ftnListAdapter.removeUnFinishUploadFile(paramFtnUploadInfo);
    FtnManager localFtnManager = this.mFtnManager;
    if (localFtnManager != null)
    {
      localFtnManager.removeUploadData(paramFtnUploadInfo.getFid());
      localFtnManager.deleteUploadInfo(paramFtnUploadInfo.getRid());
    }
  }
  
  private void renderTopBarTitleForEditMode(int paramInt)
  {
    if (paramInt < 1)
    {
      this.topBar.setTitle(getString(2131694081));
      enableBottomBar(false);
    }
    do
    {
      return;
      this.topBar.setTitle(String.format(getString(2131694051), new Object[] { Integer.valueOf(paramInt) }));
      enableBottomBar(true);
    } while (this.bottomBar == null);
    Button localButton = (Button)((FrameLayout)this.bottomBar.getChildAt(1)).getChildAt(0);
    if (FtnCommonUtils.isSupportRenew())
    {
      localButton.setEnabled(true);
      return;
    }
    localButton.setEnabled(false);
  }
  
  private void restorePosition()
  {
    if (this.lastIndex > -1)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.ftnListView.setSelectionFromTop(this.lastIndex, this.lastTop);
      }
      this.lastIndex = -1;
      this.lastTop = -1;
    }
  }
  
  private void savePosition()
  {
    int i = 0;
    this.lastIndex = this.ftnListView.getFirstVisiblePosition();
    View localView = this.ftnListView.getChildAt(0);
    if (localView == null) {}
    for (;;)
    {
      this.lastTop = i;
      return;
      i = localView.getTop();
    }
  }
  
  private void setBackParams()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_ftn_unread_info", this.mFtnExpireInfo);
    localIntent.putExtra("arg_ftn_unread_isupdate", this.mIsUpdateUnread);
    localIntent.putExtra("from", "ftn");
    setResult(9, localIntent);
  }
  
  private void setItemPressed(View paramView)
  {
    if (paramView != null)
    {
      this.mCurSelectView = paramView;
      QMListItemView.setItemPressedSafty(this.mCurSelectView, true);
    }
  }
  
  private void setMultiOperationStatus(int paramInt)
  {
    if (paramInt > 1) {
      synchronized (this.multiOperationLock)
      {
        this.isMultiOperation = true;
        this.multiOperationCount = paramInt;
        return;
      }
    }
  }
  
  private void setTopBarAllSelectState(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.isSelectAll)
      {
        this.topBar.setButtonLeftNormal(2131719470);
        this.isSelectAll = true;
      }
    }
    while (!this.isSelectAll) {
      return;
    }
    this.topBar.setButtonLeftNormal(2131719469);
    this.isSelectAll = false;
  }
  
  private void showAttachPopup(View paramView)
  {
    new FtnListActivity.33(this, this, paramView, new PopupAdapter(this, 2131559771, 2131373495, Lists.newArrayList(new String[] { getString(2131691239), getString(2131691491), getString(2131693505) }))).showDown();
  }
  
  private void showAttachSheet()
  {
    Object localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(getString(2131721609));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new FtnListActivity.31(this));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691239));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131691491));
    ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131693505));
    localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
    ((QMBottomDialog)localObject).setOnCancelListener(new FtnListActivity.32(this));
    ((QMBottomDialog)localObject).show();
  }
  
  private void showBottomBar()
  {
    if (this.bottomBar != null) {
      this.bottomBar.setVisibility(0);
    }
  }
  
  private void showComposeTipsLoading()
  {
    this.tips.showLoading("正在发送");
    this.tips.setCanceledOnTouchOutside(false);
  }
  
  private void showCompressImageLoading()
  {
    this.tips.showLoading(getString(2131691936));
    this.tips.setCanceledOnTouchOutside(false);
  }
  
  private void showDelFileTipsLoading()
  {
    this.tips.showLoading(getString(2131692499));
    this.tips.setCanceledOnTouchOutside(false);
  }
  
  private void showError()
  {
    this.listEmptyView.showTipsReload(2131694065, new FtnListActivity.18(this));
    this.ftnListView.setVisibility(8);
  }
  
  private void showLoading()
  {
    this.listEmptyView.showLoading(true);
    this.ftnListView.setVisibility(8);
  }
  
  private void showNetworkError()
  {
    Threads.runOnMainThread(new FtnListActivity.26(this));
  }
  
  private void showNoFile()
  {
    this.listEmptyView.showTips(2131694064);
    this.ftnListView.setVisibility(8);
  }
  
  private void showNoOpen()
  {
    this.listEmptyView.showTips(2131694067);
    this.ftnListView.setVisibility(8);
  }
  
  private void showNormal()
  {
    this.listEmptyView.hide();
    this.ftnListView.setVisibility(0);
  }
  
  private void showRenewTipsError()
  {
    this.tips.showError("续期失败");
    DataCollector.logException(7, 14, "Event_Error", "续期失败", true);
  }
  
  private void showRenewTipsLoading()
  {
    this.tips.showLoading("续期中...");
    this.tips.setCanceledOnTouchOutside(false);
  }
  
  private void showRenewTipsSuccess()
  {
    this.tips.showSuccess("续期成功");
  }
  
  private void showTipsNoFileSelected()
  {
    this.tips.showInfo(getString(2131694081));
  }
  
  private void showUploadErrEmptyFile()
  {
    Threads.runOnMainThread(new FtnListActivity.44(this));
  }
  
  private void showUploadErrFileNotExist()
  {
    Threads.runOnMainThread(new FtnListActivity.43(this));
  }
  
  private void showUploadErrOverSize()
  {
    Threads.runOnMainThread(new FtnListActivity.45(this));
  }
  
  private void showUploadErrPartSizeExcept(int paramInt)
  {
    Threads.runOnMainThread(new FtnListActivity.42(this, paramInt));
  }
  
  private void toEditView()
  {
    setEditing(true);
    this.ftnListView.setChoiceMode(2);
    refreshTopBar();
    renderTopBarTitleForEditMode(0);
    showBottomBar();
    this.searchBar.setSearchbarEnable(false);
    this.popularizeBanner.render(this.ftnListView, false);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ftnListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    this.ftnListView.setLayoutParams(localLayoutParams);
  }
  
  private void toNormalView()
  {
    setEditing(false);
    setTopBarAllSelectState(false);
    clearCheck();
    this.ftnListView.setChoiceMode(0);
    refreshTopBar();
    hiddenBottomBar();
    this.searchBar.setSearchbarEnable(true);
    this.popularizeBanner.render(this.ftnListView, false);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ftnListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.ftnListView.setLayoutParams(localLayoutParams);
  }
  
  private void updateFtnList()
  {
    this.mFtnManager.getList();
    updateFtnList(this.mFtnManager.getFtnList());
    if (this.ftnListAdapter.getCount() > 0)
    {
      this.ftnListView.setSelection(0);
      if (this.isRestoreLastPosition)
      {
        restorePosition();
        this.isRestoreLastPosition = false;
      }
      return;
    }
    changeShowStatus(1);
  }
  
  private void updateFtnList(FtnUI paramFtnUI)
  {
    if (paramFtnUI == null) {
      return;
    }
    if (!this.isRestoreLastPosition) {
      savePosition();
    }
    updateImageData();
    this.ftnListAdapter.setFtnUI(paramFtnUI);
    if (this.ftnListAdapter.getCount() > 0) {
      changeShowStatus(3);
    }
    while (this.firstShowList)
    {
      this.firstShowList = false;
      return;
      changeShowStatus(2);
    }
    restorePosition();
  }
  
  private void updateImageData()
  {
    releaseFtnUI(ImagePagerCache.imageFtnUIs);
    ImagePagerCache.imageFtnUIs = this.mFtnManager.getFtnList(1);
    ImagePagerCache.fidIndex = this.mFtnManager.getFidIndex(1);
  }
  
  private void updateItemExpireTime()
  {
    if (this.mSelectItem.fileInfo == null) {}
    int i;
    int j;
    do
    {
      return;
      i = this.mSelectItem.fileInfo.expiretime;
      j = FtnCommonUtils.getExpireTimeFromNowSecond(mRenewDay);
      QMLog.log(4, "FtnListActivity", "updateItemExpireTime, abort: " + i + ", renew: " + j);
    } while (i > j);
    this.mFtnManager.updateFtn(this.mSelectItem.fid, "expiretime", j + "");
  }
  
  private void updateUserProfile(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt >= 7) {
      mRenewDay = paramInt;
    }
    if (paramLong1 > 0L) {
      mPreserverDay = paramLong1;
    }
    if (paramLong2 > 2147483648L) {
      mSingleMaxSize = paramLong2;
    }
  }
  
  public boolean canEnter()
  {
    return this.mFtnManager != null;
  }
  
  public void handleUploadFileSuccess(FtnUploadInfo paramFtnUploadInfo)
  {
    removeRealPause(paramFtnUploadInfo.getFid());
    this.ftnListAdapter.removeUploadItemData(this.ftnListAdapter.getUploadItemList(), paramFtnUploadInfo, true);
    this.isMultiOperation = false;
  }
  
  public void initDataSource()
  {
    this.mAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    handleUploadFileAction(getIntent().getStringExtra("action"));
    this.mFtnManager.setAccessFtnBefore(this.mFtnManager.getAccountId(), true);
  }
  
  public void initDom()
  {
    initTips();
    initTopBar();
    initSearchBar();
    initPopularizeBannerView();
    initListView();
    initBottomBarButton();
    recoverUserProfile();
    initUnFinishUploadState();
    if (this.isUploadContinue) {
      recoverUnFinishUpload();
    }
    for (;;)
    {
      updateFtnList();
      this.mFtnManager.queryAccount();
      if (fromPlusMenu()) {
        showAttachSheet();
      }
      return;
      recoverPauseUpload();
    }
  }
  
  public void initUI()
  {
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      this.baseView = initBaseView(this);
      this.topBar = getTopBar();
      this.listEmptyView = this.baseView.addListEmptyView();
      this.ftnListView = this.baseView.addPtrListView(true);
      this.bottomBar = new QMBottomBar(this);
      this.bottomBar.setVisibility(8);
      this.baseView.addView(this.bottomBar);
      bindEvent(true);
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
  
  public boolean isEditing()
  {
    return this.isEditing;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((isExternalUpload()) && (isCancelUpload(paramInt1, paramIntent))) {
      finish();
    }
    for (;;)
    {
      return;
      if (paramInt1 == 8)
      {
        updateImageData();
        return;
      }
      if (paramInt1 == 2)
      {
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getIntExtra("curimagepos", 1);
          this.ftnListView.setSelection(paramInt1 - 3);
        }
      }
      else if (paramInt1 == 9)
      {
        if (paramIntent == null) {}
      }
      else
      {
        switch (paramInt1)
        {
        }
        while ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 5))
        {
          if (!QMNetworkUtils.isWifiConnected()) {
            break label365;
          }
          KvHelper.eventUploadFileUseWifi(new double[0]);
          return;
          this.isNeedChooseCompressImage = true;
          this.ftnListView.setSelection(0);
          handleTakePhoto(paramIntent);
          continue;
          this.isNeedChooseCompressImage = true;
          this.ftnListView.setSelection(0);
          if (paramInt2 != 0)
          {
            handleSelectImage(paramIntent);
            continue;
            if (paramIntent != null)
            {
              handleSelectFile(paramIntent.getStringArrayExtra("filePathArray"));
              continue;
              if (paramIntent != null)
              {
                GesturePasswordManager.getInstance().setGesturePwdPassed(true);
                if (paramIntent.getExtras().get("paths") != null) {
                  try
                  {
                    handleSelectFile((String[])paramIntent.getExtras().get("paths"));
                  }
                  catch (Exception paramIntent)
                  {
                    QMLog.log(6, "FtnListActivity", "get browser paths error:" + paramIntent);
                  }
                } else if (paramIntent.getExtras().get("path") != null) {
                  try
                  {
                    handleSelectFile(new String[] { (String)paramIntent.getExtras().get("path") });
                  }
                  catch (Exception paramIntent)
                  {
                    QMLog.log(6, "FtnListActivity", "get browser path error:" + paramIntent);
                  }
                }
              }
            }
          }
        }
      }
    }
    label365:
    KvHelper.eventUploadFileUseMobileNetwork(new double[0]);
  }
  
  public void onBackPressed()
  {
    if (this.isEditing)
    {
      toNormalView();
      return;
    }
    setBackParams();
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    hideDialog();
    hideTips();
    FtnManager localFtnManager = this.mFtnManager;
    QMFtnUploadNotification localQMFtnUploadNotification = QMFtnUploadNotification.getInstance();
    if (localFtnManager.getUploadCountByState(2) > 0) {
      localQMFtnUploadNotification.uploading("文件正在上传");
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    setBackParams();
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return !this.isEditing;
  }
  
  public Intent onLastFinish()
  {
    if (("from_send_file".equals(getIntent().getStringExtra("from"))) || ("from_schema".equals(getIntent().getStringExtra("from"))))
    {
      if (AccountManager.shareInstance().getAccountList().size() == 1) {
        return MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      }
      return MailFragmentActivity.createIntentToAccountList();
    }
    return null;
  }
  
  public void onOverridePendingTransition()
  {
    if (fromPlusMenu()) {
      overridePendingTransition(2130772401, 2130772430);
    }
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    if (fromPlusMenu()) {
      overridePendingTransition(0, 2130772402);
    }
    while ((!"from_send_file".equals(getIntent().getStringExtra("from"))) && (!"from_schema".equals(getIntent().getStringExtra("from")))) {
      return;
    }
    overridePendingTransition(2130772421, 2130772420);
  }
  
  public void onRelease()
  {
    savePosition();
    if (this.ftnListAdapter != null)
    {
      releaseFtnUI(this.ftnListAdapter.getFtnUI());
      this.ftnListAdapter.clearFtnCache();
    }
    bindEvent(false);
  }
  
  public void refreshData()
  {
    hideTips();
    if (!this.isNeedChooseCompressImage) {
      hideDialog();
    }
    if (!isEditing()) {
      toNormalView();
    }
    this.ftnListAdapter.setFtnUI(this.mFtnManager.getFtnList());
    this.ftnListAdapter.notifyDataSetChanged();
    InterAppsManager localInterAppsManager = InterAppsManager.getInstance();
    if ((localInterAppsManager.isFromOtherApp()) && (localInterAppsManager.hasFile()))
    {
      handleSelectFromOtherApp();
      localInterAppsManager.recycle();
    }
    this.mFtnManager.queryAccount();
    runOnMainThread(new FtnListActivity.17(this), 1000L);
  }
  
  public void render() {}
  
  public void setCreateFileParam(FtnUploadInfo paramFtnUploadInfo, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramFtnUploadInfo != null)
    {
      paramFtnUploadInfo.setIp(paramString1);
      paramFtnUploadInfo.setPort(paramInt);
      paramFtnUploadInfo.setKey(paramString2);
      paramFtnUploadInfo.setShakey(paramString3);
      paramFtnUploadInfo.setIsCreateFile(paramBoolean);
    }
  }
  
  public void setEditing(boolean paramBoolean)
  {
    this.isEditing = paramBoolean;
  }
  
  public void showUploadDialog(int paramInt)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131694074);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new FtnListActivity.29(this, localAtomicBoolean));
    localBottomListSheetBuilder.addItem(getString(2131692498));
    if (paramInt == 2) {
      localBottomListSheetBuilder.addItem(getString(2131718842));
    }
    for (;;)
    {
      this.currentDialog = null;
      this.currentDialog = localBottomListSheetBuilder.build();
      this.currentDialog.setOnDismissListener(new FtnListActivity.30(this, localAtomicBoolean));
      this.currentDialog.show();
      return;
      if (paramInt == 3) {
        localBottomListSheetBuilder.addItem(getString(2131696736));
      } else if (paramInt == 4) {
        localBottomListSheetBuilder.addItem(getString(2131718843));
      }
    }
  }
  
  public void updateRealPause(String paramString, boolean paramBoolean)
  {
    this.realPauseSet.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void updateUploadItemState(FtnUploadInfo paramFtnUploadInfo, int paramInt)
  {
    paramFtnUploadInfo.setState(paramInt);
    this.ftnListAdapter.setUploadViewHolderState(this.ftnListAdapter.getVisibleView(paramFtnUploadInfo), paramInt);
    this.ftnListAdapter.changeUploadItemViewState(this.ftnListAdapter.getVisibleView(paramFtnUploadInfo), paramInt);
  }
  
  static class CurSelectItem
  {
    public boolean aboutExpire = false;
    public String fid = "";
    public FileInfo fileInfo;
    public String filename = "";
    public MailBigAttach mailAttach;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity
 * JD-Core Version:    0.7.0.1
 */