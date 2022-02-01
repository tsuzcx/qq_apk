package com.tencent.qqmail.attachment.activity;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.animation.RotationAction;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.animation.SlideViewAnimation.SlideAction;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.attachment.util.ImagePagerCache;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.view.CustomViewPager;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnLogicStorage;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.animation.AnimUtil;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.FtnFileInformationView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMPopupWindow.PopupMenuItem;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FullWindowHelper;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ImagePagerActivity
  extends FragmentActivity
  implements RotationAction
{
  private static final String ARG_ATTACH = "attach";
  private static final String ARG_FILE_INFO = "fileinfo";
  public static final String ARG_FROM = "from";
  public static final String ARG_IMAGE = "extra_image";
  private static final String ARG_ITEM_POS = "itempos";
  public static final String ARG_UIN = "extra_uin";
  public static final String FROM_FTNLIST = "from_ftnlist";
  private static final int OPERATION_OPEN_OTHERS = 1;
  private static final int OPERATION_SAVE_IMAGE = 0;
  public static final int REQUEST_CODE_SAVE_IMAGE = 0;
  public static final String TAG = "ImagePagerActivity";
  public static String mUin;
  private ImagePagerAdapter adapter;
  private Animation animBottomGone;
  private Animation animBottomVisible;
  private QMBottomBar bottomBar;
  private ImageData curImageData;
  private int curImagePosition = -1;
  private ImagePagerFragment currentImagePagerFragment;
  private int currentPosition = -2;
  protected String desiredSavePath = "";
  private View.OnClickListener dialogItemClickListener = new ImagePagerActivity.18(this);
  private DialogInterface.OnDismissListener dismissDialogListener = new ImagePagerActivity.19(this);
  private Handler eventHandler = new Handler();
  private ArrayList<String> fidList = new ArrayList();
  private FileInfo fileInfo;
  private FtnFileInformationView fileInfoLayout;
  private ImageData imageData;
  private boolean isBottomBarActionProcess = false;
  private boolean isFirstPage = false;
  private boolean isFromFtn = false;
  private boolean isShowInfo = false;
  private ImagePagerFragment lastImagePagerFragment;
  private View mSelectView;
  private MailBigAttach mailAttach;
  private IObserver observerDelFileError = new ImagePagerActivity.6(this, null);
  private IObserver observerDelFileSuccess = new ImagePagerActivity.5(this, null);
  private IObserver observerGetShareUrlError = new ImagePagerActivity.2(this, null);
  private IObserver observerGetShareUrlSuccess = new ImagePagerActivity.1(this, null);
  private IObserver observerRenewFileError = new ImagePagerActivity.4(this, null);
  private IObserver observerRenewFileSuccess = new ImagePagerActivity.3(this, null);
  private CustomViewPager pager;
  private QMUIDialog qmDialog;
  private QMTips qmTips;
  private String qrResult;
  private ImagePreviewSlideAction slideAction;
  private SlideViewAnimation slideViewAnim;
  private QMTopBar topBar;
  private Drawable topBarDrawable;
  private ViewFlipper viewFlipper;
  
  private void adjustImageToFillLayout()
  {
    int i = QMUIKit.getStatusBarHeight(this);
    if (VersionUtils.hasLolipop())
    {
      StatusBarUtil.layoutUnderStatusBar(this, StatusBarUtil.WHITE_COLOR);
      this.topBar.setPadding(this.topBar.getPaddingLeft(), i, this.topBar.getPaddingRight(), this.topBar.getPaddingBottom());
    }
    while ((!VersionUtils.isKitKat()) || (this.pager == null)) {
      return;
    }
    this.pager.setPadding(this.pager.getPaddingLeft(), -i, this.pager.getPaddingRight(), this.pager.getPaddingBottom());
  }
  
  public static Intent createIntent(MailBigAttach paramMailBigAttach, int paramInt, String paramString)
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount == null) {
      throw new IllegalStateException("ftn account null");
    }
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ImagePagerActivity.class);
    if (ImagePagerCache.fidIndex.containsKey(paramMailBigAttach.getFid())) {
      localIntent.putExtra("extra_image", ((Integer)ImagePagerCache.fidIndex.get(paramMailBigAttach.getFid())).intValue());
    }
    localIntent.putExtra("extra_uin", localQQMailAccount.getUin());
    localIntent.putExtra("from", paramString);
    localIntent.putExtra("attach", paramMailBigAttach);
    localIntent.putExtra("fileinfo", paramMailBigAttach.getInfoBytes());
    localIntent.putExtra("itempos", paramInt);
    return localIntent;
  }
  
  private void createMoreDialog()
  {
    int k = 0;
    if (this.imageData == null) {
      return;
    }
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this);
    List localList = QMPopupWindow.praseShareMenuItem(2131886085, this);
    boolean bool = DeviceUtil.isQCloudInstalled();
    Object localObject = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(mUin);
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
        break label146;
      }
      j = ((QMPopupWindow.PopupMenuItem)((Iterator)localObject).next()).getButtonId();
      if (j == 2131367769)
      {
        ((Iterator)localObject).remove();
        continue;
        i = 0;
        break;
      }
      if ((j == 2131367771) && ((!bool) || (i != 0))) {
        ((Iterator)localObject).remove();
      }
    }
    label146:
    while (j < localList.size())
    {
      localBottomListSheetBuilder.addItem(((QMPopupWindow.PopupMenuItem)localList.get(j)).getIconResId(), ((QMPopupWindow.PopupMenuItem)localList.get(j)).getTitle(), ((QMPopupWindow.PopupMenuItem)localList.get(j)).getTitle());
      j += 1;
    }
    tryAddQrCodeEntrance(localBottomListSheetBuilder);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ImagePagerActivity.14(this));
    localBottomListSheetBuilder.build().show();
  }
  
  private void createRenewTypeDialog()
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this);
    String str1 = getString(2131718796) + "为" + FtnListActivity.mRenewDay + "天";
    localBottomListSheetBuilder.addItem(2130840833, str1, str1);
    String str2 = getString(2131718797) + "为" + FtnListActivity.mRenewDay + "天";
    localBottomListSheetBuilder.addItem(2130840814, str2, str2);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ImagePagerActivity.13(this, str1, str2));
    localBottomListSheetBuilder.build().show();
  }
  
  private void doChooseOpenMethod()
  {
    String str = getAttachImageSavePath();
    if (!StringExtention.isNullOrEmpty(str))
    {
      if (this.imageData != null)
      {
        showTipsFileOpening();
        IntentUtil.openFile(this, str, this.mailAttach.getSuffix(), AttachPreviewType.MailNormalAttachPreview);
        hideTips();
      }
      return;
    }
    downloadImageBeforeOperation(1);
  }
  
  private void doCopyShareLink(int paramInt)
  {
    showTipsCopyShareLink();
    FtnManager.sharedInstance().getShareUrl(this.imageData.getFid(), this.imageData.getName(), this.imageData.getKey(), this.imageData.getCode(), paramInt);
  }
  
  private void doDeleteAttach()
  {
    if (this.fidList.size() == 0) {
      return;
    }
    showTipsDelFileLoading();
    FtnManager.sharedInstance().delFile(this.fidList);
    setBottomBarActionProcess(true);
    this.pager.setPagingEnable(false);
  }
  
  private void doMailSend()
  {
    FtnCommonUtils.buildComposeData(FtnLogicStorage.getComposeInfos(), mUin, this.curImageData.getFileInfo());
    startActivity(ComposeMailActivity.createIntentFromFtn(getClass().getName()));
  }
  
  private void doRenewAllAttach()
  {
    showTipsRenewLoading();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FtnUI localFtnUI = FtnManager.sharedInstance().getFtnList();
    if ((localFtnUI != null) && (localFtnUI.getCount() > 0))
    {
      int i = 0;
      while (i < localFtnUI.getCount())
      {
        FileInfo localFileInfo = localFtnUI.get(i);
        localArrayList1.add(localFileInfo.fid);
        localArrayList2.add(Integer.valueOf(localFileInfo.expiretime - 2));
        i += 1;
      }
      FtnManager.sharedInstance().renewFile(localArrayList1, localArrayList2);
    }
    if (localFtnUI != null) {
      localFtnUI.release();
    }
  }
  
  private void doRenewAttach()
  {
    if (this.fidList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.fileInfo.expiretime - 2));
    FtnManager.sharedInstance().renewFile(this.fidList, localArrayList);
    showTipsRenewLoading();
    setBottomBarActionProcess(true);
    this.pager.setPagingEnable(false);
  }
  
  private void doSaveToAlbum()
  {
    Attach localAttach = new Attach(false);
    localAttach.setName(this.imageData.getName());
    String str = getAttachImageSavePath();
    Intent localIntent = new Intent();
    localIntent.setClass(this, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("iscomplete", 1);
    localIntent.putExtra("url", str);
    localIntent.putExtra("attachfile", localAttach);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 0);
  }
  
  private void doSaveToWeiYun()
  {
    if (StringExtention.sizeStrToLong(this.mailAttach.getSize()) >= 1073741824L) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(QMApplicationContext.sharedInstance()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new ImagePagerActivity.20(this))).create().show();
    }
    QQMailAccount localQQMailAccount;
    do
    {
      return;
      localQQMailAccount = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(mUin);
    } while (localQQMailAccount == null);
    startActivity(AttachSaveToWeiYunActivity.createIntent(this.mailAttach, false, localQQMailAccount.getId(), false, this.isFromFtn, false));
    overridePendingTransition(2130772401, 2130772430);
  }
  
  private void downloadImageBeforeOperation(int paramInt)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(-1);
    localDownloadInfo.setUrl(this.imageData.getDownUrl());
    localDownloadInfo.setKey(this.imageData.getDownUrl());
    localDownloadInfo.setFileName(this.imageData.getName());
    localDownloadInfo.setFtnKey(this.imageData.getKey());
    localDownloadInfo.setFtnCode(this.imageData.getCode());
    localDownloadInfo.setFtnBytes(StringExtention.sizeStrToLong(this.imageData.getSize()));
    localDownloadInfo.setFilePath("");
    localDownloadInfo.setIsNotify(false);
    localDownloadInfo.setDownloadType(1);
    localDownloadInfo.setAttachType(2);
    localDownloadInfo.setAttachDownloadListener(new ImagePagerActivity.21(this, paramInt));
    AttachDownloadManager.shareInstance().fetchAttach(localDownloadInfo);
  }
  
  private void finishForResult(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (isFirstPage())
    {
      this.curImagePosition = 0;
      setFirstPage(false);
    }
    localIntent.putExtra("curimagepos", this.curImagePosition);
    localIntent.putExtra("action", paramString1);
    if (paramString1.equals("delete")) {
      localIntent.putExtra("fid", paramString2);
    }
    setResult(2, localIntent);
    finish();
  }
  
  private String getAttachImageSavePath()
  {
    if (this.fileInfo != null)
    {
      Object localObject = FtnManager.sharedInstance().getDownloadInfo(this.fileInfo.fid);
      if (localObject != null)
      {
        localObject = ((FtnDownloadInfo)localObject).getSavePath();
        if (FileUtil.isFileExist((String)localObject))
        {
          this.mailAttach.getPreview().setMyDisk((String)localObject);
          return localObject;
        }
      }
    }
    return "";
  }
  
  private void hideBar(RelativeLayout paramRelativeLayout)
  {
    if (this.topBar != null) {
      this.topBar.getButtonRight().setEnabled(false);
    }
    this.topBar.animHide(new ImagePagerActivity.23(this));
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout.setVisibility(8);
      paramRelativeLayout.startAnimation(this.animBottomGone);
    }
    if (this.bottomBar != null) {
      this.bottomBar.setVisibility(8);
    }
  }
  
  private void hideTips()
  {
    this.qmTips.hide();
  }
  
  private void initAttachInfo()
  {
    this.fileInfoLayout = ((FtnFileInformationView)findViewById(2131367056));
    String str = FtnCommonUtils.getThumbUrl(mUin, this.mailAttach.getFid(), "2", "2", this.mailAttach.getAccountId());
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setUrl(str);
    localDownloadInfo.setImageDownloadListener(new ImagePagerActivity.16(this));
    if (ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo) != 1) {
      setFileInfoDefaultThumb();
    }
    setFileInfo(this.mailAttach.getName(), this.mailAttach.getCreateTime(), this.mailAttach.getDownloadTimes(), this.mailAttach.getExpire().getTime() / 1000L, this.mailAttach.getSize());
  }
  
  private void initBottomBar()
  {
    this.bottomBar = new QMBottomBar(this);
    this.bottomBar.setVisibility(0);
    this.bottomBar.addButton(2130840803, new ImagePagerActivity.10(this)).setId(2131367752);
    Object localObject = this.bottomBar.addButton(2130840807, new ImagePagerActivity.11(this));
    ((QMImageButton)localObject).setId(2131367777);
    if (FtnCommonUtils.isSupportRenew()) {
      ((QMImageButton)localObject).setEnabled(true);
    }
    for (;;)
    {
      this.bottomBar.addButton(2130840806, new ImagePagerActivity.12(this)).setId(2131367773);
      localObject = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297365));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.bottomBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((RelativeLayout)findViewById(2131367781)).addView(this.bottomBar);
      return;
      ((QMImageButton)localObject).setEnabled(false);
    }
  }
  
  private void initData()
  {
    mUin = getIntent().getStringExtra("extra_uin");
    if ((getIntent().getStringExtra("from") != null) && (getIntent().getStringExtra("from").equals("from_ftnlist"))) {
      this.isFromFtn = true;
    }
    this.slideAction = new ImagePreviewSlideAction();
    this.slideViewAnim = new SlideViewAnimation(this.slideAction);
    this.animBottomGone = AnimationUtils.loadAnimation(this, 2130772041);
    this.animBottomVisible = AnimationUtils.loadAnimation(this, 2130772042);
    this.mailAttach = ((MailBigAttach)getIntent().getSerializableExtra("attach"));
    try
    {
      this.fileInfo = new FileInfo();
      this.fileInfo.parseFrom(getIntent().getByteArrayExtra("fileinfo"));
      this.fidList.clear();
      this.fidList.add(this.mailAttach.getFid());
      if (getIntent().getIntExtra("itempos", -1) == 1) {
        setFirstPage(true);
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void initImagePager()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (ImagePagerCache.imageFtnUIs != null) {
      this.adapter = new ImagePagerAdapter(getSupportFragmentManager(), ImagePagerCache.imageFtnUIs.getCount());
    }
    for (;;)
    {
      this.pager = ((CustomViewPager)findViewById(2131368837));
      this.pager.setAdapter(this.adapter);
      this.pager.setPageMargin((int)getResources().getDimension(2131297468));
      this.pager.setOffscreenPageLimit(1);
      this.pager.setOnPageChangeListener(new ImagePagerActivity.15(this));
      int i = getIntent().getIntExtra("extra_image", -1);
      if (i != -1)
      {
        this.pager.setCurrentItem(i);
        this.imageData = ImagePagerCache.getImageData(mUin, i);
        if (i == 0) {
          this.curImageData = ImagePagerCache.getImageData(mUin, 0);
        }
      }
      return;
      finish();
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.onWindowFocusChanged(true);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ImagePagerActivity.8(this));
    this.topBar.setButtonRightIcon(2130841093);
    this.topBar.getButtonRight().setOnClickListener(new ImagePagerActivity.9(this));
    this.topBar.setTitle(this.mailAttach.getName());
  }
  
  private void initView()
  {
    this.viewFlipper = ((ViewFlipper)findViewById(2131381892));
    this.qmTips = new QMTips(this);
    this.qmTips.setCallback(new ImagePagerActivity.7(this));
    initTopBar();
    initBottomBar();
    initAttachInfo();
    initImagePager();
  }
  
  private void menuActionListen(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      doMailSend();
      return;
    case 1: 
      doChooseOpenMethod();
      return;
    case 2: 
      doCopyShareLink(2);
      return;
    case 3: 
      doSaveToAlbum();
      return;
    case 4: 
      doDeleteAttach();
      return;
    case 5: 
      doRenewAttach();
      return;
    }
    doRenewAllAttach();
  }
  
  private void recycleDrawable()
  {
    if (this.topBarDrawable != null)
    {
      this.topBarDrawable.setCallback(null);
      this.topBarDrawable = null;
    }
  }
  
  private void registerEvent()
  {
    QMNotification.registNotification("actiondelfilesucc", this.observerDelFileSuccess);
    QMNotification.registNotification("actiondelfileerror", this.observerDelFileError);
    QMNotification.registNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
    QMNotification.registNotification("actionrenewfileerror", this.observerRenewFileError);
    QMNotification.registNotification("actiongetshareurlsucc", this.observerGetShareUrlSuccess);
    QMNotification.registNotification("actiongetshareurlerror", this.observerGetShareUrlError);
  }
  
  private void renderAttachInfo()
  {
    this.isShowInfo = true;
    this.fileInfoLayout.setVisibility(0);
    this.topBar.getButtonRightIcon().setImageResource(2130841092);
    this.topBar.getButtonRight().setEnabled(true);
    this.pager.setVisibility(8);
  }
  
  private void renderPreview()
  {
    this.isShowInfo = false;
    this.fileInfoLayout.setVisibility(8);
    this.topBar.getButtonRightIcon().setImageResource(2130841093);
    this.topBar.getButtonRight().setEnabled(true);
    this.pager.setVisibility(0);
  }
  
  private void setBottomBarActionProcess(boolean paramBoolean)
  {
    this.isBottomBarActionProcess = paramBoolean;
  }
  
  private void setFileInfo(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2)
  {
    Object localObject = new Date(paramLong1 * 1000L);
    Date localDate = new Date(paramLong2 * 1000L);
    localObject = DateExtension.fullDateName_yyyyMMddHHmm((Date)localObject).split(" ");
    this.fileInfoLayout.setFileName(paramString1);
    this.fileInfoLayout.setFileCreatedDate(localObject[0]);
    this.fileInfoLayout.setFileValidTime(FtnCommonUtils.getExpireTimeString(localDate));
    this.fileInfoLayout.setFileSize(FtnCommonUtils.getFileSizeFormat(paramString2));
    this.fileInfoLayout.setFileDownloadCount(paramInt);
  }
  
  private void setFileInfoDefaultThumb()
  {
    if (this.fileInfoLayout != null) {
      this.fileInfoLayout.setFileThumbDrawable(2130840449, null);
    }
  }
  
  private void setViewSelected(View paramView)
  {
    if (this.mSelectView != null) {
      this.mSelectView.setSelected(false);
    }
    if (paramView != null)
    {
      this.mSelectView = paramView;
      this.mSelectView.setSelected(true);
    }
  }
  
  private void setViewUnSelected()
  {
    if (this.mSelectView != null) {
      this.mSelectView.setSelected(false);
    }
  }
  
  private void showBar(RelativeLayout paramRelativeLayout)
  {
    if (this.topBar != null) {
      this.topBar.getButtonRight().setEnabled(true);
    }
    this.topBar.animShow(new ImagePagerActivity.22(this));
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout.setVisibility(0);
      paramRelativeLayout.startAnimation(this.animBottomVisible);
    }
    if (this.bottomBar != null)
    {
      this.bottomBar.setVisibility(0);
      paramRelativeLayout = new AlphaAnimation(0.0F, 1.0F);
      paramRelativeLayout.setDuration(250L);
      this.bottomBar.setAnimation(paramRelativeLayout);
    }
  }
  
  private void showTipsCopyShareLink()
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
  
  private void showTipsFileOpening()
  {
    this.qmTips.showLoading("正在打开");
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
  
  private void tryAddQrCodeEntrance(QMBottomDialog.BottomListSheetBuilder paramBottomListSheetBuilder)
  {
    this.qrResult = null;
    paramBottomListSheetBuilder = FtnManager.sharedInstance().getDownloadInfo(this.imageData.getFid());
    if (paramBottomListSheetBuilder == null) {
      return;
    }
    paramBottomListSheetBuilder.getSavePath();
  }
  
  private void unregisterEvent()
  {
    QMNotification.unregistNotification("actiondelfilesucc", this.observerDelFileSuccess);
    QMNotification.unregistNotification("actiondelfileerror", this.observerDelFileError);
    QMNotification.unregistNotification("actionrenewfilesucc", this.observerRenewFileSuccess);
    QMNotification.unregistNotification("actionrenewfileerror", this.observerRenewFileError);
    QMNotification.unregistNotification("actiongetshareurlsucc", this.observerGetShareUrlSuccess);
    QMNotification.unregistNotification("actiongetshareurlerror", this.observerGetShareUrlError);
  }
  
  private void updateAttachInfo(ImageData paramImageData)
  {
    this.topBar.setTitle(paramImageData.getName());
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setUrl(paramImageData.getThumbUrl());
    localDownloadInfo.setImageDownloadListener(new ImagePagerActivity.17(this));
    if (ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo) != 1) {
      setFileInfoDefaultThumb();
    }
    setFileInfo(paramImageData.getName(), paramImageData.getCreateTime(), paramImageData.getDownloadTime(), paramImageData.getExpireTime(), paramImageData.getSize());
  }
  
  public void doAfterRotationBack()
  {
    renderPreview();
  }
  
  public void doAfterRotationFront()
  {
    renderAttachInfo();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public int getPageSelected()
  {
    return this.curImagePosition;
  }
  
  public boolean isBottomBarActionProcess()
  {
    return this.isBottomBarActionProcess;
  }
  
  public boolean isFirstPage()
  {
    return this.isFirstPage;
  }
  
  public boolean isPagingEnable()
  {
    return this.pager.isPagingEnable();
  }
  
  public boolean isShowInfo()
  {
    return this.isShowInfo;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt1 == 0))
    {
      this.desiredSavePath = paramIntent.getStringExtra("filePath");
      paramIntent = new File(this.desiredSavePath);
      if (paramIntent != null) {
        this.desiredSavePath = paramIntent.getParent();
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131694769) + this.desiredSavePath, 0).show();
      if (!StringExtention.isNullOrEmpty(getAttachImageSavePath())) {
        DownloadUtil.existFileSaveAs(this.mailAttach, this.desiredSavePath, true);
      }
    }
    else
    {
      return;
    }
    downloadImageBeforeOperation(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558491);
    getWindow().addFlags(128);
    initData();
    if (this.mailAttach != null) {
      initView();
    }
    for (;;)
    {
      StatusBarUtil.immerseWhite(this);
      adjustImageToFillLayout();
      return;
      QMUIHelper.showToast(this, 2131695454, "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.topBar != null) {
      this.topBar = null;
    }
    this.qmTips = null;
    this.bottomBar = null;
    recycleDrawable();
  }
  
  public void onPause()
  {
    super.onPause();
    unregisterEvent();
  }
  
  public void onResume()
  {
    super.onResume();
    registerEvent();
  }
  
  public void resetLastImagePagerView()
  {
    if (this.lastImagePagerFragment != null) {
      this.lastImagePagerFragment.fetchImage();
    }
  }
  
  public void setFirstPage(boolean paramBoolean)
  {
    this.isFirstPage = paramBoolean;
  }
  
  public void setPageSelected(int paramInt)
  {
    this.curImagePosition = paramInt;
  }
  
  public void setPagingEnable(boolean paramBoolean)
  {
    this.pager.setPagingEnable(paramBoolean);
  }
  
  public void setVisibilityOfBar(RelativeLayout paramRelativeLayout, Activity paramActivity)
  {
    if (this.topBar.isVisible())
    {
      AnimUtil.playAlphaBackgroundColor(findViewById(2131368837), getResources().getColor(2131167681), getResources().getColor(17170444), 100);
      hideBar(paramRelativeLayout);
      FullWindowHelper.changeToFullScreen(getWindow(), this);
      if ((VersionUtils.isKitKat()) && (this.pager != null)) {
        this.pager.setPadding(this.pager.getPaddingLeft(), 0, this.pager.getPaddingRight(), this.pager.getPaddingBottom());
      }
      return;
    }
    AnimUtil.playAlphaBackgroundColor(findViewById(2131368837), getResources().getColor(17170444), getResources().getColor(2131167681), 100);
    showBar(paramRelativeLayout);
    FullWindowHelper.changeToNotFullScreen(getWindow(), this);
    adjustImageToFillLayout();
  }
  
  public void updateAttachInfo(int paramInt)
  {
    synchronized (ImagePagerCache.imageFtnUIs)
    {
      this.imageData = ImagePagerCache.getImageData(mUin, paramInt);
      if (this.imageData != null) {
        updateAttachInfo(this.imageData);
      }
      return;
    }
  }
  
  class ImagePagerAdapter
    extends FragmentStatePagerAdapter
  {
    private Map<Integer, ImagePagerFragment> mPageReferenceMap = new HashMap();
    private final int mSize;
    
    public ImagePagerAdapter(FragmentManager paramFragmentManager, int paramInt)
    {
      super();
      this.mSize = paramInt;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      this.mPageReferenceMap.remove(Integer.valueOf(paramInt));
    }
    
    public int getCount()
    {
      return this.mSize;
    }
    
    public ImagePagerFragment getFragment(int paramInt)
    {
      return (ImagePagerFragment)this.mPageReferenceMap.get(Integer.valueOf(paramInt));
    }
    
    public Fragment getItem(int paramInt)
    {
      if (this.mPageReferenceMap.size() == 0) {}
      for (ImagePagerFragment localImagePagerFragment = ImagePagerFragment.newInstance(paramInt, "first");; localImagePagerFragment = ImagePagerFragment.newInstance(paramInt, ""))
      {
        this.mPageReferenceMap.put(Integer.valueOf(paramInt), localImagePagerFragment);
        return localImagePagerFragment;
      }
    }
  }
  
  class ImagePreviewSlideAction
    implements SlideViewAnimation.SlideAction
  {
    public ImagePreviewSlideAction() {}
    
    public void slideBottom2TopAction()
    {
      ImagePagerActivity.this.renderPreview();
    }
    
    public void slideLeft2RightAction()
    {
      ImagePagerActivity.this.renderPreview();
    }
    
    public void slideRight2LeftAction()
    {
      ImagePagerActivity.this.renderAttachInfo();
    }
    
    public void slideTop2BottomAction()
    {
      ImagePagerActivity.this.renderAttachInfo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity
 * JD-Core Version:    0.7.0.1
 */