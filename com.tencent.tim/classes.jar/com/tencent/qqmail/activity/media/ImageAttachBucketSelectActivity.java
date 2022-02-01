package com.tencent.qqmail.activity.media;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.animation.SlideViewAnimation.SlideAction;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.view.AttachFolderFileInfoView;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.LoadImageWatcher;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.animation.AnimUtil;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FullWindowHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

public class ImageAttachBucketSelectActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String ARG_FROM_GROUP_MAIL = "arg_from_group_mail";
  private static final String ARG_IMAGE_ACTION_TYPE = "arg_image_action_type";
  private static final String ARG_IS_ALL_IMAGE_CACHE = "arg_mail_is_all_image_cache";
  private static final String ARG_IS_FILE_SHARE = "arg_is_file_share";
  private static final String ARG_IS_FROM_COMPOSE = "arg_is_from_compose";
  private static final String ARG_IS_FROM_DOWNLOAD = "arg_is_from_download";
  private static final String ARG_IS_FROM_EML = "arg_is_from_eml";
  private static final String ARG_IS_IMAGE_LOAD = "arg_mail_is_image_load";
  private static final String ARG_MAIL_TYPE = "arg_mail_type";
  private static final String ARG_SELECTED_POSITION = "arg_selected_position";
  private static final String ARG_WHICH_FOLDER = "arg_which_folder";
  private static final int FTN_SAVE_DELETE = 3;
  private static final int FTN_SAVE_EXIST = 1;
  private static final int FTN_SAVE_FAIL = 4;
  private static final int FTN_SAVE_PART_FAIL = 2;
  private static final int FTN_SAVE_SUCCESS = 0;
  public static final int IMAGE_PREVIEW = 1;
  public static final int IMAGE_SAVE = 2;
  private static final int PW_NOFAV = 2;
  private static final int PW_NORMAL = 0;
  private static final int PW_ONLYFAV = 1;
  private static final int REQUEST_CODE_DELETE_MAIL = 1;
  private static final int REQUEST_CODE_SAVE_AS = 2;
  private static final int REQUEST_CODE_SEQ_SAVE_AS = 3;
  private static final String RESULT_CURRENT_POSITION = "result_current_position";
  private static final int SEQ_DOWNLOAD_BEGIN = 2;
  private static final int SEQ_DOWNLOAD_NEXT = 0;
  public static final String TAG = "ImageAttachBucketSelectActivity";
  public static MailUI extra_maildata;
  private int accountId = 0;
  private int actionType = 1;
  private int animationType;
  private AttachFolderFileInfoView attachInfoLayout;
  private QMBaseView baseView;
  private QMBottomBar bottomBar;
  private int currentPos = 0;
  private int fromFolder = 0;
  private ImagePagerAdapter imagePagerAdapter;
  private ViewPager imageViewPager;
  private boolean isAllImageCache = false;
  private boolean isFileShareFlag = false;
  private boolean isFromCompose = false;
  private boolean isFromDownload = false;
  private boolean isFromEML = false;
  private boolean isFromGroupMail = false;
  private boolean isImageLoad = false;
  private boolean isRenderInfo = false;
  private Handler mFtnOptHandler = new ImageAttachBucketSelectActivity.22(this);
  private LoadImageWatcher mLoadImageWatcher = new ImageAttachBucketSelectActivity.1(this);
  private TinyImageSeqLoader mLoader = null;
  private Handler mSeqDownloadHandler = new ImageAttachBucketSelectActivity.23(this);
  private MailUI mailData;
  private int mailType;
  private List<MediaItemInfo> mediaInfoList;
  private IObserver observerSaveFileError = new ImageAttachBucketSelectActivity.3(this, null);
  private IObserver observerSaveFileSuccess = new ImageAttachBucketSelectActivity.2(this, null);
  private View.OnClickListener onFavorite = new ImageAttachBucketSelectActivity.17(this);
  private View.OnClickListener onMore = new ImageAttachBucketSelectActivity.18(this);
  private ViewGroup pagerWrap;
  private PopupAdapter popupAdapter;
  private int position = 0;
  private QMTips qmTips;
  private String qrResult;
  private AttachInfoSlideAction slideAction;
  private SlideViewAnimation slideViewAnim;
  private QMTopBar topBar;
  private ViewFlipper viewFlipper;
  
  private void backToMail(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = MailFragmentActivity.createIntentToReadmailFromPush(paramInt1, paramInt2, paramLong, paramString4, paramString1, paramString2, paramString3, false, false, true);
    overridePendingTransition(2130772421, 2130772420);
    startActivityForResult(paramString1, 1);
  }
  
  private void backToMail(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("id", 0L);
    int i = paramIntent.getIntExtra("accountId", 0);
    int j = paramIntent.getIntExtra("folderId", 0);
    String str1 = paramIntent.getStringExtra("subject");
    String str2 = paramIntent.getStringExtra("fromnickname");
    String str3 = paramIntent.getStringExtra("fromaddress");
    paramIntent = MailFragmentActivity.createIntentToReadmailFromPush(i, j, l, paramIntent.getStringExtra("remoteid"), str1, str2, str3, false, false, true);
    overridePendingTransition(2130772421, 2130772420);
    startActivity(paramIntent);
  }
  
  private void bottomSheetDialog(int paramInt)
  {
    DataCollector.logEvent("Event_Attach_Click_More_Btn_From_Attach_Detail");
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    MediaItemInfo localMediaItemInfo;
    Attach localAttach;
    if ((this.mediaInfoList != null) && (this.imageViewPager != null))
    {
      localMediaItemInfo = (MediaItemInfo)this.mediaInfoList.get(this.imageViewPager.getCurrentItem());
      if (localMediaItemInfo == null) {
        break label331;
      }
      localAttach = localMediaItemInfo.getAttach();
      label62:
      if (paramInt != 1) {
        localBottomListSheetBuilder.addItem(2130840820, getString(2131690550), getString(2131690550));
      }
      if ((localMediaItemInfo.getAttach().isExist()) && (paramInt != 1))
      {
        localBottomListSheetBuilder.addItem(2130840836, getString(2131690583), getString(2131690583));
        localBottomListSheetBuilder.addItem(2130840829, getString(2131690556), getString(2131690556));
      }
      if ((paramInt == 1) && (isShowFavorite()))
      {
        if (QMAttachManager.sharedInstance().isAttachFavorite(localMediaItemInfo.getAttach().getHashId())) {
          break label336;
        }
        localBottomListSheetBuilder.addItem(2130840824, getString(2131690532), getString(2131690532));
      }
    }
    for (;;)
    {
      String str = QMAttachManager.sharedInstance().getAttachCopyDisk(localAttach.getHashId(), 0);
      if ((paramInt != 1) && ((localAttach.isExist()) || (!str.equals("")))) {
        localBottomListSheetBuilder.addItem(2130840838, getString(2131690586), getString(2131690586));
      }
      if ((paramInt != 1) && (isShowSaveToWeiYun(localAttach.getAccountId())) && (DeviceUtil.isQCloudInstalled())) {
        localBottomListSheetBuilder.addItem(2130840840, getString(2131690572), getString(2131690572));
      }
      localBottomListSheetBuilder.setOnSheetItemClickListener(new ImageAttachBucketSelectActivity.19(this, localMediaItemInfo, localAttach, str));
      localBottomListSheetBuilder.build().show();
      return;
      localMediaItemInfo = null;
      break;
      label331:
      localAttach = null;
      break label62;
      label336:
      localBottomListSheetBuilder.addItem(2130840826, getString(2131690535), getString(2131690535));
    }
  }
  
  public static Intent createAttachFolderIntent(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = createIntent(paramInt1, paramInt2, paramInt3, paramBoolean1);
    localIntent.putExtra("arg_is_file_share", paramBoolean2);
    return localIntent;
  }
  
  public static Intent createComposeIntent(int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = createIntent(paramInt1, paramInt2, paramInt3, false);
    localIntent.putExtra("arg_is_from_compose", true);
    localIntent.putExtra("animationType", 1);
    return localIntent;
  }
  
  public static Intent createDownloadIntent(int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = createIntent(paramInt1, paramInt2, paramInt3, false);
    localIntent.putExtra("arg_is_from_download", true);
    return localIntent;
  }
  
  public static Intent createEmlIntent(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intent localIntent = createIntent(paramInt1, paramInt2, paramInt3, paramBoolean);
    localIntent.putExtra("arg_is_from_eml", true);
    return localIntent;
  }
  
  public static Intent createIntent(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ImageAttachBucketSelectActivity.class);
    localIntent.putExtra("arg_account_id", paramInt1);
    localIntent.putExtra("arg_selected_position", paramInt2);
    localIntent.putExtra("arg_which_folder", paramInt3);
    localIntent.putExtra("arg_from_group_mail", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntent(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, MailUI paramMailUI)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ImageAttachBucketSelectActivity.class);
    localIntent.putExtra("arg_account_id", paramInt1);
    localIntent.putExtra("arg_selected_position", paramInt2);
    localIntent.putExtra("arg_which_folder", paramInt3);
    localIntent.putExtra("arg_from_group_mail", paramBoolean1);
    localIntent.putExtra("arg_mail_type", paramInt4);
    localIntent.putExtra("arg_mail_is_all_image_cache", paramBoolean2);
    localIntent.putExtra("arg_mail_is_image_load", paramBoolean3);
    extra_maildata = paramMailUI;
    return localIntent;
  }
  
  private void doAttachSaveAs(MediaItemInfo paramMediaItemInfo)
  {
    Attach localAttach = new Attach(false);
    localAttach.setName(paramMediaItemInfo.getFileName());
    Intent localIntent = new Intent(this, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("iscomplete", 1);
    localIntent.putExtra("attachfile", localAttach);
    localIntent.putExtra("savelastDownLoadPath", true);
    localIntent.putExtra("url", paramMediaItemInfo.getSourcePath());
    startActivityForResult(localIntent, 2);
  }
  
  private void doDownloadAttachSeq()
  {
    Intent localIntent = new Intent(this, SdcardFileExplorer.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("getSavePath", true);
    localIntent.putExtra("savelastDownLoadPath", true);
    startActivityForResult(localIntent, 3);
  }
  
  private void doDownloadImageAttachSeq(String paramString)
  {
    int i = this.mediaInfoList.size();
    this.mLoader = new TinyImageSeqLoader(this.accountId, paramString, ImageAttachData.imageInfoList, new ImageAttachBucketSelectActivity.21(this, i), this.imagePagerAdapter);
    this.qmTips.setCanceledOnTouchOutside(false);
    if (this.imagePagerAdapter != null)
    {
      this.imagePagerAdapter.abortDownloadAll();
      this.imagePagerAdapter.setImageSeqLoader(this.mLoader);
    }
    this.mLoader.load(paramString, 0);
  }
  
  private void doMailSend(long paramLong, Attach paramAttach)
  {
    Object localObject2 = SendMailHelper.getComposeMail(paramLong, ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ComposeMailUI();
    }
    localObject2 = ((ComposeMailUI)localObject1).getInformation();
    if (localObject2 == null)
    {
      localObject1 = new ComposeMailUI();
      localObject2 = ((ComposeMailUI)localObject1).getInformation();
    }
    for (;;)
    {
      ((MailInformation)localObject2).setToList(null);
      ((MailInformation)localObject2).setCcList(null);
      ((MailInformation)localObject2).setSendContact(null);
      ((MailInformation)localObject2).setSendContact(new MailContact());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramAttach);
      ((ComposeMailUI)localObject1).getInformation().setSubject(paramAttach.getName());
      ((ComposeMailUI)localObject1).getInformation().setAttachList((ArrayList)localObject2);
      ((ComposeMailUI)localObject1).getInformation().setBigAttachList((ArrayList)localObject2);
      startActivity(ComposeMailActivity.createIntentForFwdAttach(paramAttach.getHashId(), paramLong, this.accountId, getClass().getName()));
      return;
    }
  }
  
  private void doOpenBy(Attach paramAttach)
  {
    String str = FileUtil.getAttachDownloadDir();
    IntentUtil.openFile(this, str + paramAttach.getName(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailNormalAttachPreview);
  }
  
  private void doSaveAttachToFtn(int paramInt, boolean paramBoolean)
  {
    FtnManager localFtnManager = FtnManager.sharedInstance();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = new ArrayList();
      localObject1 = (MediaItemInfo)this.mediaInfoList.get(paramInt);
      if ((((MediaItemInfo)localObject1).getImageType() != 3) || (!(((MediaItemInfo)localObject1).getAttach() instanceof MailBigAttach))) {
        break label264;
      }
    }
    label264:
    for (Object localObject1 = (MailBigAttach)((MediaItemInfo)localObject1).getAttach();; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((ArrayList)localObject2).add(QMAttachUtils.removeIllegalString(((MailBigAttach)localObject1).getPreview().getDownloadUrl()));
        for (localObject1 = localObject2;; localObject1 = getBigAttachDownloadList())
        {
          localObject2 = new UrlQuerySanitizer();
          ((UrlQuerySanitizer)localObject2).setAllowUnregisteredParamaters(true);
          paramInt = 0;
          while (paramInt < ((ArrayList)localObject1).size())
          {
            ((UrlQuerySanitizer)localObject2).parseUrl((String)((ArrayList)localObject1).get(paramInt));
            String str1 = ((UrlQuerySanitizer)localObject2).getValue("k");
            String str2 = ((UrlQuerySanitizer)localObject2).getValue("code");
            if ((!StringExtention.isNullOrEmpty(str1)) && (!StringExtention.isNullOrEmpty(str2)))
            {
              localArrayList1.add(str1);
              localArrayList2.add(str2);
            }
            paramInt += 1;
          }
        }
        if ((localArrayList1.size() > 0) && (localArrayList1.size() == localArrayList2.size()))
        {
          getTips().showLoading(getString(2131718594));
          localFtnManager.saveFile(localArrayList1, localArrayList2);
        }
      }
      else
      {
        return;
      }
      getTips().showError(getString(2131718938));
      return;
    }
  }
  
  private void doSaveToWeiYun(Attach paramAttach)
  {
    if (StringExtention.sizeStrToLong(paramAttach.getSize()) >= 1073741824L)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new ImageAttachBucketSelectActivity.20(this))).create().show();
      return;
    }
    boolean bool2 = this.isFromGroupMail;
    int i = paramAttach.getAccountId();
    boolean bool3 = isFromAttachFolder();
    if (this.fromFolder == -5) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      startActivity(AttachSaveToWeiYunActivity.createIntent(paramAttach, bool2, i, bool3, bool1, false));
      getActivity().overridePendingTransition(2130772401, 2130772430);
      return;
    }
  }
  
  private void finishWithResult(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  private ArrayList<String> getBigAttachDownloadList()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mediaInfoList.size())
    {
      localObject = (MediaItemInfo)this.mediaInfoList.get(i);
      if ((((MediaItemInfo)localObject).getAttach() != null) && ((((MediaItemInfo)localObject).getAttach() instanceof MailBigAttach))) {
        localArrayList.add(((MediaItemInfo)localObject).getAttach());
      }
      i += 1;
    }
    Object localObject = new ArrayList();
    Date localDate1 = new Date();
    i = j;
    while (i < localArrayList.size())
    {
      MailBigAttach localMailBigAttach = (MailBigAttach)localArrayList.get(i);
      Date localDate2 = localMailBigAttach.getExpire();
      if ((localMailBigAttach.isBizNetDiskAttach()) || ((localDate2 != null) && (localDate2.getTime() - localDate1.getTime() > 0L))) {
        ((ArrayList)localObject).add(QMAttachUtils.removeIllegalString(localMailBigAttach.getPreview().getDownloadUrl()));
      }
      i += 1;
    }
    return localObject;
  }
  
  private void getCurrentInfo(onCurrentInfoListener paramonCurrentInfoListener)
  {
    if ((this.mediaInfoList != null) && (this.imageViewPager != null)) {}
    for (MediaItemInfo localMediaItemInfo = (MediaItemInfo)this.mediaInfoList.get(this.imageViewPager.getCurrentItem());; localMediaItemInfo = null)
    {
      if ((localMediaItemInfo != null) && (localMediaItemInfo.getAttach() != null) && (localMediaItemInfo.getAttach().isBigAttach())) {}
      for (MailBigAttach localMailBigAttach = (MailBigAttach)localMediaItemInfo.getAttach();; localMailBigAttach = null)
      {
        if ((this.mediaInfoList != null) && (this.imageViewPager != null))
        {
          if ((localMailBigAttach != null) && (localMailBigAttach.getExpireTimeMilli() < System.currentTimeMillis()) && (!localMailBigAttach.isBizNetDiskAttach())) {
            QMLog.log(4, "ImageAttachBucketSelectActivity", "mail bigAttach is expired");
          }
        }
        else {
          return;
        }
        paramonCurrentInfoListener.onCurrentInfo(localMediaItemInfo);
        return;
      }
    }
  }
  
  private void handleBack()
  {
    Intent localIntent = new Intent();
    if (this.imageViewPager != null) {
      localIntent.putExtra("result_current_position", this.imageViewPager.getCurrentItem());
    }
    finishWithResult(2, localIntent);
    if (!isFromAttachFolder()) {
      overridePendingTransition(2130772421, 2130772420);
    }
  }
  
  private void handleCancelAll()
  {
    finishWithResult(0, null);
  }
  
  private void hideAttachInfo()
  {
    this.isRenderInfo = false;
    this.attachInfoLayout.setVisibility(8);
  }
  
  private void initAttachInfo(Attach paramAttach)
  {
    if (paramAttach == null) {
      return;
    }
    this.attachInfoLayout = ((AttachFolderFileInfoView)findViewById(2131367056));
    setAttachInfoParams(paramAttach, new ImageAttachBucketSelectActivity.15(this));
  }
  
  private void initBottomBar()
  {
    if (this.bottomBar == null)
    {
      this.bottomBar = new QMBottomBar(this);
      this.bottomBar.addButton(2130840805, this.onFavorite);
      this.bottomBar.addButton(2130840806, this.onMore);
      this.bottomBar.getBottomBarButton(0).setContentDescription(getString(2131720833));
      this.bottomBar.getBottomBarButton(1).setContentDescription(getString(2131720837));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297365));
      localLayoutParams.gravity = 80;
      this.bottomBar.setLayoutParams(localLayoutParams);
      this.baseView.addView(this.bottomBar);
    }
  }
  
  private void initData()
  {
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    int i = getIntent().getIntExtra("arg_selected_position", 0);
    this.position = i;
    this.currentPos = i;
    this.actionType = getIntent().getIntExtra("arg_image_action_type", 1);
    this.isFileShareFlag = getIntent().getBooleanExtra("arg_is_file_share", false);
    this.isFromGroupMail = getIntent().getBooleanExtra("arg_from_group_mail", false);
    this.isFromDownload = getIntent().getBooleanExtra("arg_is_from_download", false);
    this.isFromCompose = getIntent().getBooleanExtra("arg_is_from_compose", false);
    this.isFromEML = getIntent().getBooleanExtra("arg_is_from_eml", false);
    this.fromFolder = getIntent().getIntExtra("arg_which_folder", 0);
    this.animationType = getIntent().getIntExtra("animationType", 0);
    this.mediaInfoList = ImageAttachData.getImageInfoList();
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.isAllImageCache = localBundle.getBoolean("arg_mail_is_all_image_cache");
      this.isImageLoad = localBundle.getBoolean("arg_mail_is_image_load");
      this.mailType = localBundle.getInt("arg_mail_type");
    }
    this.mailData = extra_maildata;
    extra_maildata = null;
  }
  
  private void initImageViewPager()
  {
    this.pagerWrap = ((ViewGroup)findViewById(2131363426));
    this.imageViewPager = ((ViewPager)findViewById(2131368921));
    this.imageViewPager.setPageMargin((int)getResources().getDimension(2131297468));
    if (QMNetworkUtils.isMobileConnected()) {
      this.imageViewPager.setOffscreenPageLimit(0);
    }
    for (;;)
    {
      this.imagePagerAdapter = new ImagePagerAdapter(this, this.accountId, new ImageAttachBucketSelectActivity.10(this), new ImageAttachBucketSelectActivity.11(this), new ImageAttachBucketSelectActivity.12(this));
      this.imagePagerAdapter.change(this.mediaInfoList, new boolean[this.mediaInfoList.size()]);
      this.imageViewPager.setAdapter(this.imagePagerAdapter);
      this.imageViewPager.setOnPageChangeListener(new ImageAttachBucketSelectActivity.13(this));
      this.imageViewPager.setCurrentItem(this.position);
      this.imageViewPager.setOnTouchListener(new ImageAttachBucketSelectActivity.14(this));
      return;
      this.imageViewPager.setOffscreenPageLimit(1);
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    if ((this.isFromDownload) || (this.isFromCompose))
    {
      this.topBar.setButtonLeftBack();
      this.topBar.getButtonLeft().setOnClickListener(new ImageAttachBucketSelectActivity.4(this));
      if (this.isFromCompose) {}
      return;
    }
    if (!isFromAttachFolder())
    {
      this.topBar.setButtonLeftBack();
      this.topBar.getButtonLeft().setOnClickListener(new ImageAttachBucketSelectActivity.5(this));
      this.topBar.setButtonRightIcon(2130841095);
      this.topBar.getButtonRight().setContentDescription(getString(2131720837));
      this.topBar.getButtonRight().setOnClickListener(new ImageAttachBucketSelectActivity.6(this));
      return;
    }
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ImageAttachBucketSelectActivity.7(this));
    this.topBar.setButtonRightIcon(2130841093);
    this.topBar.getButtonRight().setContentDescription(getString(2131720857));
    this.topBar.getButtonRight().setOnClickListener(new ImageAttachBucketSelectActivity.8(this));
    initBottomBar();
  }
  
  private void initView()
  {
    this.qmTips = new QMTips(this);
    this.viewFlipper = ((ViewFlipper)this.baseView.findViewById(2131381892));
    this.viewFlipper.setBackgroundResource(2131167682);
    this.slideAction = new AttachInfoSlideAction(null);
    this.slideViewAnim = new SlideViewAnimation(this.slideAction);
  }
  
  private boolean isCurrentImage(MediaItemInfo paramMediaItemInfo, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramMediaItemInfo == null) && (paramString2 == null)) {}
    Attach localAttach;
    String str;
    do
    {
      return false;
      localAttach = paramMediaItemInfo.getAttach();
      str = localAttach.getPreview().getDownloadUrl();
      if (paramMediaItemInfo.getImageType() != 3) {
        break;
      }
    } while (str == null);
    if (StringExtention.hashKeyForDisk(str).equals(paramString1)) {}
    for (;;)
    {
      return bool;
      if (paramMediaItemInfo.getImageType() == 2)
      {
        if ((str == null) || (paramString2 == null)) {
          break;
        }
        paramMediaItemInfo = str.replace(QMNetworkConfig.getCgiRequestHost(localAttach.getAccountId()), "");
        paramString1 = paramString2.replace(QMNetworkConfig.getCgiRequestHost(localAttach.getAccountId()), "");
        if ((!paramMediaItemInfo.contains(paramString1)) && (!paramString1.contains(paramMediaItemInfo))) {
          break;
        }
        return true;
      }
      if ((paramString3 == null) || (paramMediaItemInfo.getAttach() == null) || (!paramString3.equals(paramMediaItemInfo.getAttach().getPreview().getMyDisk()))) {
        break;
      }
      return true;
      bool = false;
    }
  }
  
  private boolean isFromAttachFolder()
  {
    return this.fromFolder == -19;
  }
  
  private boolean isFtnAccount()
  {
    return AccountManager.shareInstance().getAccountList().getDefaultFtnAccount() != null;
  }
  
  private boolean isShowFavorite()
  {
    if (this.isFromEML) {}
    while ((this.fromFolder == 4) || (this.fromFolder == 5) || (this.fromFolder == 6) || (this.fromFolder == 102) || (this.fromFolder == -1)) {
      return false;
    }
    return true;
  }
  
  private boolean isShowSaveToWeiYun(int paramInt)
  {
    boolean bool2 = false;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
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
  
  private void openTopBarMorePopup(View paramView, MediaItemInfo paramMediaItemInfo)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof View))) {
      paramView = (View)paramView.getTag();
    }
    for (;;)
    {
      if ((paramMediaItemInfo == null) || (paramMediaItemInfo.getAttach() == null)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(getString(2131690550));
      if ((paramMediaItemInfo.getAttach() != null) && (!paramMediaItemInfo.getAttach().isBigAttach()) && (isShowFavorite()))
      {
        if (!QMAttachManager.sharedInstance().isAttachFavorite(paramMediaItemInfo.getAttach().getHashId())) {
          localArrayList.add(getString(2131690532));
        }
      }
      else
      {
        if ((paramMediaItemInfo.getAttach().isExist()) && (IntentUtil.isExistFileBrowser(getActivity()))) {
          localArrayList.add(getString(2131690558));
        }
        if (paramMediaItemInfo.getAttach().isExist()) {
          localArrayList.add(getString(2131690583));
        }
        if ((!isFtnAccount()) || (paramMediaItemInfo.getImageType() != 3) || (!QMSettingManager.sharedInstance().getFtnDisplay())) {
          break label395;
        }
        if (this.mediaInfoList != null)
        {
          localArrayList.add(getString(2131690570));
          if (this.mediaInfoList.size() > 1) {
            localArrayList.add(getString(2131690566));
          }
        }
      }
      for (;;)
      {
        String str = QMAttachManager.sharedInstance().getAttachCopyDisk(paramMediaItemInfo.getAttach().getHashId(), 0);
        if ((paramMediaItemInfo.getAttach().isExist()) || (!str.equals("")) || (paramMediaItemInfo.getAttach().isBigAttach())) {
          localArrayList.add(getString(2131690586));
        }
        if ((isShowSaveToWeiYun(paramMediaItemInfo.getAttach().getAccountId())) && (DeviceUtil.isQCloudInstalled())) {
          localArrayList.add(getString(2131690572));
        }
        this.popupAdapter = new PopupAdapter(this, 2131559771, 2131373495, localArrayList);
        new ImageAttachBucketSelectActivity.9(this, this, paramView, this.popupAdapter, paramMediaItemInfo, str).show();
        return;
        localArrayList.add(getString(2131690535));
        break;
        label395:
        if ((this.mediaInfoList != null) && (this.mediaInfoList.size() > 1)) {
          localArrayList.add(getString(2131690584));
        }
      }
    }
  }
  
  private void renderAttachInfo()
  {
    this.isRenderInfo = true;
    this.attachInfoLayout.setVisibility(0);
  }
  
  private void setAttachInfoParams(Attach paramAttach, View.OnClickListener paramOnClickListener)
  {
    if ((this.attachInfoLayout == null) || (paramOnClickListener == null)) {
      return;
    }
    String str = paramAttach.getPreview().getIcon();
    Object localObject = str;
    if (!StringExtention.isNullOrEmpty(str)) {
      if ((!QMNetworkConfig.isContainCgiButDropHost(str, "magick")) && (!QMNetworkConfig.isContainGroupAttachButDropHost(str))) {
        break label195;
      }
    }
    label195:
    for (localObject = QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + str;; localObject = AttachToolbox.formatThumbnailUrl(str, 320, 350))
    {
      AttachToolbox.loadImageAttachThumb(paramAttach.getAccountId(), (String)localObject, this.attachInfoLayout.getImageView(), new AttachFolderInfoThumbListener(paramAttach.getAccountId(), this.attachInfoLayout.getImageView()));
      this.attachInfoLayout.setFileName(paramAttach.getName());
      this.attachInfoLayout.setSender(paramAttach.getMailSender());
      this.attachInfoLayout.setSubject(paramAttach.getMailSubject());
      localObject = DateExtension.fullDateName_yyyyMMddHHmm(new Date(paramAttach.getFavTime())).split(" ");
      this.attachInfoLayout.setSendTime(localObject[0]);
      this.attachInfoLayout.setFileSize(paramAttach.getSize());
      this.attachInfoLayout.setBackToMailOnClickListener(paramOnClickListener);
      return;
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
  
  private void toggleTopBar()
  {
    AlphaAnimation localAlphaAnimation;
    if (this.topBar.isVisible())
    {
      AnimUtil.playAlphaBackgroundColor(findViewById(2131368921), getResources().getColor(2131167681), getResources().getColor(17170444), 250);
      if (this.topBar != null)
      {
        if (this.topBar.getButtonRight() != null) {
          this.topBar.getButtonRight().setEnabled(false);
        }
        this.topBar.animHide(null);
      }
      if (this.bottomBar != null)
      {
        this.bottomBar.setVisibility(8);
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(getResources().getInteger(17694721));
        this.bottomBar.setAnimation(localAlphaAnimation);
      }
      FullWindowHelper.changeToFullScreen(getWindow(), this);
      if ((this.pagerWrap != null) && (VersionUtils.isKitKat())) {
        this.pagerWrap.setPadding(this.pagerWrap.getPaddingLeft(), 0, this.pagerWrap.getPaddingRight(), this.pagerWrap.getPaddingBottom());
      }
    }
    for (;;)
    {
      updateMoreBtnState();
      return;
      AnimUtil.playAlphaBackgroundColor(findViewById(2131368921), getResources().getColor(17170444), getResources().getColor(2131167681), 250);
      if (this.topBar != null)
      {
        if (this.topBar.getButtonRight() != null) {
          this.topBar.getButtonRight().setEnabled(true);
        }
        this.topBar.animShow(null);
      }
      if (this.bottomBar != null)
      {
        this.bottomBar.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(250L);
        this.bottomBar.setAnimation(localAlphaAnimation);
      }
      FullWindowHelper.changeToNotFullScreen(getWindow(), this);
      if (VersionUtils.hasLolipop())
      {
        StatusBarUtil.layoutUnderStatusBar(this, StatusBarUtil.WHITE_COLOR);
        this.topBar.setPadding(this.topBar.getPaddingLeft(), QMUIKit.getStatusBarHeight(this), this.topBar.getPaddingRight(), this.topBar.getPaddingBottom());
      }
      else if ((VersionUtils.isKitKat()) && (this.pagerWrap != null))
      {
        this.pagerWrap.setPadding(this.pagerWrap.getPaddingLeft(), -QMUIKit.getStatusBarHeight(this), this.pagerWrap.getPaddingRight(), this.pagerWrap.getPaddingBottom());
      }
    }
  }
  
  private void updateAttachInfo(Attach paramAttach)
  {
    if (paramAttach == null) {
      return;
    }
    this.attachInfoLayout = ((AttachFolderFileInfoView)findViewById(2131367056));
    setAttachInfoParams(paramAttach, new ImageAttachBucketSelectActivity.16(this, paramAttach));
  }
  
  private void updateMoreBtnState()
  {
    if (this.bottomBar == null) {}
    View localView;
    MediaItemInfo localMediaItemInfo;
    do
    {
      do
      {
        return;
        localView = this.bottomBar.getBottomBarButton(1);
      } while ((this.mediaInfoList == null) || (this.imageViewPager == null));
      localMediaItemInfo = (MediaItemInfo)this.mediaInfoList.get(this.imageViewPager.getCurrentItem());
    } while (localView == null);
    if ((localMediaItemInfo != null) && (!localMediaItemInfo.getAttach().isExist()))
    {
      localView.setEnabled(false);
      return;
    }
    localView.setEnabled(true);
  }
  
  private void updateTopBarTitle()
  {
    QMTopBar localQMTopBar = this.topBar;
    String str;
    if (this.imageViewPager == null)
    {
      str = "";
      localQMTopBar.setTitle(str);
      if (((this.mediaInfoList != null) && (this.imageViewPager != null)) || (this.topBar.getButtonRight() == null)) {
        break label103;
      }
      this.topBar.getButtonRight().setEnabled(false);
    }
    label103:
    while (this.topBar.getButtonRight() == null)
    {
      return;
      str = this.imageViewPager.getCurrentItem() + 1 + "/" + this.imageViewPager.getAdapter().getCount();
      break;
    }
    if ((this.mediaInfoList.size() == 1) && (!((MediaItemInfo)this.mediaInfoList.get(0)).getAttach().isExist()))
    {
      this.topBar.getButtonRight().setEnabled(false);
      return;
    }
    this.topBar.getButtonRight().setEnabled(true);
  }
  
  public void initDataSource()
  {
    initData();
  }
  
  public void initDom()
  {
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      initView();
      initTopBar();
      if ((this.mediaInfoList != null) && (this.mediaInfoList.size() > 0))
      {
        initImageViewPager();
        updateTopBarTitle();
        toggleTopBar();
        MediaItemInfo localMediaItemInfo = (MediaItemInfo)this.mediaInfoList.get(this.imageViewPager.getCurrentItem());
        if ((localMediaItemInfo != null) && (isFromAttachFolder())) {
          initAttachInfo(localMediaItemInfo.getAttach());
        }
      }
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
  
  public void initUI()
  {
    this.baseView = initBaseView(this, 2131558754);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        Attach localAttach;
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
                } while (paramInt2 != 105);
                finishWithResult(105, null);
                return;
              } while (paramIntent == null);
              paramIntent = new File(paramIntent.getStringExtra("filePath"));
            } while (paramIntent == null);
            paramIntent = paramIntent.getParent();
          } while (this.imageViewPager == null);
          paramInt1 = this.imageViewPager.getCurrentItem();
          localAttach = ((MediaItemInfo)this.mediaInfoList.get(paramInt1)).getAttach();
        } while (localAttach == null);
        Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131694769) + paramIntent, 0).show();
        AttachPreview localAttachPreview = localAttach.getPreview();
        QMAttachManager localQMAttachManager = QMAttachManager.sharedInstance();
        long l = localAttach.getHashId();
        if (localAttach.isBigAttach()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          localAttachPreview.setMyDisk(localQMAttachManager.getAttachMyDisk(l, paramInt1));
          DownloadUtil.existFileSaveAs(localAttach, paramIntent, false);
          return;
        }
      } while (paramIntent == null);
      doDownloadImageAttachSeq(paramIntent.getStringExtra("savePath"));
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra("EXTRA_PAINTPAD_INDEX", this.imageViewPager.getCurrentItem());
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.mLoadImageWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("actionsavefilesucc", this.observerSaveFileSuccess);
      QMNotification.registNotification("actionsavefileerror", this.observerSaveFileError);
      return;
    }
    QMNotification.unregistNotification("actionsavefilesucc", this.observerSaveFileSuccess);
    QMNotification.unregistNotification("actionsavefileerror", this.observerSaveFileError);
  }
  
  public void onButtonBackClick()
  {
    handleBack();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((this.isRenderInfo) || (this.currentPos == 0))
    {
      overridePendingTransition(2130772421, 2130772420);
      return true;
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      handleBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    this.mediaInfoList = null;
    if (this.qmTips != null) {
      this.qmTips.dismissTipsManually();
    }
    if (this.imagePagerAdapter != null)
    {
      this.imagePagerAdapter.recycle();
      this.imagePagerAdapter.abortDownloadAll();
    }
  }
  
  public void refreshData()
  {
    if (this.imagePagerAdapter != null) {
      this.imagePagerAdapter.notifyDataSetChanged();
    }
  }
  
  public void render() {}
  
  class AttachFolderInfoThumbListener
    implements ImageDownloadListener
  {
    private int mAccountId;
    private ImageView mThumbImage;
    
    public AttachFolderInfoThumbListener(int paramInt, ImageView paramImageView)
    {
      this.mAccountId = paramInt;
      this.mThumbImage = paramImageView;
    }
    
    public void onErrorInMainThread(String paramString, Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof QMNetworkError)))
      {
        paramString = (QMNetworkError)paramObject;
        if ((paramString.code == 302) && (!StringUtils.isEmpty(paramString.url)))
        {
          paramObject = new DownloadInfo();
          paramObject.setAccountId(this.mAccountId);
          paramObject.setUrl(paramString.url);
          paramObject.setImageDownloadListener(this);
          ImageDownloadManager.shareInstance().fetchImage(paramObject);
        }
      }
    }
    
    public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
    
    public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
    {
      paramString2 = new File(paramString2);
      if ((paramString2.exists()) && (paramString2.length() > 50000L)) {
        ImageCompresser.getInstance().compressImage(paramString1, paramString2.getAbsolutePath(), paramString2.getAbsolutePath(), 3, new ImageAttachBucketSelectActivity.AttachFolderInfoThumbListener.1(this, paramString2));
      }
      while (paramBitmap == null) {
        return;
      }
      paramString1 = new BitmapDrawable(ImageAttachBucketSelectActivity.this.getResources(), paramBitmap);
      this.mThumbImage.setImageDrawable(paramString1);
    }
  }
  
  class AttachInfoSlideAction
    implements SlideViewAnimation.SlideAction
  {
    private AttachInfoSlideAction() {}
    
    public void slideBottom2TopAction()
    {
      ImageAttachBucketSelectActivity.this.hideAttachInfo();
      if (ImageAttachBucketSelectActivity.this.topBar.getButtonRight() != null)
      {
        ImageAttachBucketSelectActivity.this.topBar.getButtonRightIcon().setImageResource(2130841093);
        ImageAttachBucketSelectActivity.this.topBar.getButtonRight().setEnabled(true);
      }
    }
    
    public void slideLeft2RightAction() {}
    
    public void slideRight2LeftAction() {}
    
    public void slideTop2BottomAction()
    {
      ImageAttachBucketSelectActivity.this.renderAttachInfo();
      if (ImageAttachBucketSelectActivity.this.topBar.getButtonRight() != null)
      {
        ImageAttachBucketSelectActivity.this.topBar.setButtonRightIcon(2130841092);
        ImageAttachBucketSelectActivity.this.topBar.getButtonRightIcon().setImageResource(2130841092);
        ImageAttachBucketSelectActivity.this.topBar.getButtonRight().setEnabled(true);
      }
    }
  }
  
  static class SaveInfo
  {
    public boolean finish = false;
    public String name;
    public String path;
    public int result;
  }
  
  static class SeqDownloadInfo
  {
    public static int lastCount;
    public int currentCount;
    public boolean downSuccess;
    public int errCode;
    public int failCount;
    public String filePath;
    public String key;
    public int successCount;
    public int totalCount;
  }
  
  static abstract interface onCurrentInfoListener
  {
    public abstract void onCurrentInfo(MediaItemInfo paramMediaItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity
 * JD-Core Version:    0.7.0.1
 */