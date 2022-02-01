package com.tencent.qqmail.activity.readmail;

import alld;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.QMApplicationContext.LowMemoryListener;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.MailAddrsViewControl;
import com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity;
import com.tencent.qqmail.activity.media.ImageAttachData;
import com.tencent.qqmail.activity.reademl.QMReadEmlActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.activity.webviewexplorer.CardWebViewExplorer;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.WebViewPreviewActivity;
import com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.view.DataPickerViewGroup.DatePickerListener;
import com.tencent.qqmail.calendar.view.PopupFrame;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.loader.BigAttachDownloader;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.download.watcher.DownloadWatcher;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.inquirymail.InquiryMailManager;
import com.tencent.qqmail.maillist.fragment.ConvMailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.maillist.fragment.MailRecallListFragment;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.model.mail.watcher.MailDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailModifySendUtcWatcher;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.model.mail.watcher.MailPurgeDeleteWatcher;
import com.tencent.qqmail.model.mail.watcher.MailRejectWatcher;
import com.tencent.qqmail.model.mail.watcher.MailSpamWatcher;
import com.tencent.qqmail.model.mail.watcher.MailStartWatcher;
import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.model.mail.watcher.MailTopWatcher;
import com.tencent.qqmail.model.mail.watcher.MailUnReadWatcher;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.mail.watcher.ReadMailDefaultWatcher;
import com.tencent.qqmail.model.mail.watcher.RenderAttachWatcher;
import com.tencent.qqmail.model.mail.watcher.TranslateMailWatcher;
import com.tencent.qqmail.model.mail.watcher.UpdateFtnExpireTimeWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.readmail.BigAttachHelper;
import com.tencent.qqmail.model.readmail.ReadMailHelper;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailOperate;
import com.tencent.qqmail.model.uidomain.MailReference;
import com.tencent.qqmail.model.uidomain.MailReferenceNav;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.namelist.watcher.AddNameListWatcher;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.CustomDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.EditTextDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.search.model.SearchMailUI;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.XSSTagFilter;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.screenshot.ScreenShotServiceClient;
import com.tencent.qqmail.utilities.screenshot.ScreenshotWatcher.ScreenshotCallback;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.translate.TranslateUtil;
import com.tencent.qqmail.utilities.ui.ITranslateCallBack;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomGridSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.AttachNamesHandlerTextView;
import com.tencent.qqmail.view.ClockedMailHelper;
import com.tencent.qqmail.view.DownloadThumbProgressBar;
import com.tencent.qqmail.view.DropdownWebViewLayout;
import com.tencent.qqmail.view.EditTextInWebView;
import com.tencent.qqmail.view.EnsureDialogUtil;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.JBTitleBarWebView2;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMQuickReplyView;
import com.tencent.qqmail.view.QMReadMailView;
import com.tencent.qqmail.view.QMReadMailView.VIEW_ITEM;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.ReadMailDetailView;
import com.tencent.qqmail.view.ReadMailTagViews;
import com.tencent.qqmail.view.ReadMailTitle;
import com.tencent.qqmail.view.TitleBarWebView2;
import com.tencent.qqmail.view.TitleBarWebView2.OnScrollListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment;
import moai.fragment.base.BaseFragmentActivity;
import moai.fragment.base.SaveArgumentField;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

public class ReadMailFragment
  extends MailFragment
{
  private static final int ANIM_STEP_END = 2;
  private static final int ANIM_STEP_START = 1;
  private static final Integer DELAY_RENDER_WITH_CONTENT = Integer.valueOf(2);
  private static final Integer DELAY_SHOW_LOADING;
  private static final int DIR_NEXT = -1;
  private static final int DIR_NO = 0;
  private static final int DIR_PREV = 1;
  private static final String FOXMAIL_ATTACH_URL = "/cgi-bin/ftnExs_download?";
  private static final int LOAD_CONTENT_BEGIN = 1;
  private static final int LOAD_CONTENT_FINISH = 2;
  private static final int LOAD_CONTENT_NONE = 0;
  public static final String QUICK_REPLY_CONTENT_FILENAME = "quickreply";
  private static final int REJECT_GROUP = 2;
  private static final int REJECT_MAIL = 1;
  private static final int REJECT_SUBS = 3;
  private static final int REJECT_TYPE_CANCEL = 3;
  private static final int REJECT_TYPE_PROTOCOL = 2;
  private static final int REJECT_TYPE_QQ = 1;
  private static final int REQUEST_CODE_ATTACH_DOWNLOAD = 100;
  private static final int REQUEST_CODE_ATTACH_SAVE_AS = 101;
  private static final int REQUEST_CODE_DOWNLOAD_MANAGER = 107;
  public static final int REQUEST_CODE_DRAFT_COMPOSE = 1000;
  private static final int REQUEST_CODE_IMAGE_SAVE_AS = 102;
  private static final int REQUEST_CODE_IMAGE_SEQ_DOWNLOAD = 103;
  private static final int REQUEST_CODE_MAIL_TO_NOTE = 104;
  private static final int REQUEST_CODE_MOVE_MAIL = 105;
  private static final int REQUEST_CODE_SELECT_CONTACT = 106;
  public static final int REQUEST_CODE_TAG_MAIL = 1001;
  public static final int RESULT_CODE_NO_SIBLING = 1002;
  private static final long SEND_BIZ_MAIL_OVERTIME = 86400000L;
  private static final long SEND_MAIL_OVERTIME = 1296000000L;
  public static final String TAG = "ReadMailFragment";
  private static final long UPDATE_TRIGGER_TIME = 30L;
  private static final String WAP_MALI_URL = "http://m.mailData.qq.com/cgi-bin/ftnExs_download?t=exs_ftnapp_download_android&f=xhtml";
  private static HashMap<String, Long> loadMailFilterHashMap = new HashMap();
  private static ReadMailViewHolder sViewHolder = null;
  protected int MAX_REFRESH_SKEY_TIME = 20;
  protected int MAX_REFRESH_TOKEN_TIME = 20;
  private final int RECALL_ERROR_TYPE_BIZ_OVERTIME = 4;
  private final int RECALL_ERROR_TYPE_DIFF_SENDER = 3;
  private final int RECALL_ERROR_TYPE_OK = 0;
  private final int RECALL_ERROR_TYPE_OVERTIME = 1;
  private final int RECALL_ERROR_TYPE_TO_NOT_QQ = 2;
  private boolean ableFlingToBack = false;
  private AddNameListWatcher addNameListWatcher = new ReadMailFragment.21(this);
  @SaveArgumentField
  private long aggregateType;
  private LinearLayout attachListView;
  private AttachListViewAdapter attachListViewAdapter;
  private HashMap<Long, BigAttachDownloader> bigAttachDownloaderHashMap = new HashMap();
  private DataPickerViewGroup.DatePickerListener calendarDatePickerListener = null;
  private DataPickerViewGroup.DatePickerListener clockedMailDatePickerListener = null;
  private final HashSet<Integer> delayRunList = new HashSet();
  private final MailDeleteWatcher deleteWatcher = new ReadMailFragment.16(this);
  private ReadMailDetailView detailView;
  private DownloadWatcher downloadWatcher = new ReadMailFragment.29(this);
  private QMUnlockFolderPwdWatcher folderLockWatcher = new ReadMailFragment.30(this);
  private boolean hasGuideRecall = false;
  private AtomicBoolean hasRenderCombineTranslateData = new AtomicBoolean(false);
  private long hasShowContentMailId;
  private ViewGroup header;
  @SaveArgumentField
  private long id = 0L;
  private boolean isBigAttach = false;
  private boolean isCancelFail = false;
  private boolean isContentDirty = false;
  private Future<Boolean> isDoneReadMailFromId = null;
  private Future<Boolean> isDoneReadingMailExtra = null;
  private boolean isEditAttach = false;
  private boolean isFileShare = false;
  private boolean isFinish = false;
  private boolean isImageLoad = false;
  private boolean isNormalAttach = false;
  boolean isPopupMoreThroughTranslateBubble = false;
  private boolean isRenderHeader = false;
  private boolean isScreenshotBubbleShow = true;
  private boolean isUnlockNoteFolder = false;
  private boolean isUnreadOperation = false;
  private boolean isUpdateAttachFolder = false;
  private String journeyDestination;
  private String journeyDestinationTime;
  private int lastOpenFileIndex = -1;
  private long lastUpdateTime;
  private int loadContentStatus = 0;
  private View.OnClickListener loadImageClickListener = new ReadMailFragment.100(this);
  private String loadUrl = "";
  private FolderLockDialog lockDialog;
  private long logMailId;
  private AccountLoginWatcher loginWatcher = new ReadMailFragment.9(this);
  @SaveArgumentField
  private int mAccountId = 0;
  private int mAnimationStep = 0;
  private LoadAttachFolderListWatcher mCheckAttachFolderListWatcher = new ReadMailFragment.31(this);
  private boolean mEditMode = false;
  private boolean mFileSaveSingle = false;
  private QMFolder mFolder;
  @SaveArgumentField
  private boolean mFromAttachFolder;
  @SaveArgumentField
  private int mFromFolderId;
  @SaveArgumentField
  private boolean mFromInquiryMail;
  @SaveArgumentField
  private boolean mFromPush;
  private boolean mFromScheme = false;
  private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ReadMailFragment.111(this);
  private boolean mImageSaveSingle = false;
  @SaveArgumentField
  private boolean mIsGroup;
  private TinyImageSeqLoader mLoader = null;
  private MailTranslate mMailTranslate;
  private long mManualOptId;
  @SaveArgumentField
  private long mParentMailId;
  private final QuickReplyViewScrollListener mQuickReplyViewScrollListener = new QuickReplyViewScrollListener();
  private int mReadMailDirection = 0;
  private String mRemoteId;
  public IObserver mSaveMailSucc = new IObserver(new ReadMailFragment.99(this));
  private ScreenshotWatcher.ScreenshotCallback mScreenshotCallback = new ReadMailFragment.7(this);
  @SaveArgumentField
  private int mSearchFolderId;
  private String mSenderEmail;
  private String mSenderNick;
  private boolean mShowContentAllLoading = false;
  private String mSubject;
  private ITranslateCallBack mTranslateCallBack = new ReadMailFragment.126(this);
  private QMScaleWebViewController mWebViewController;
  private final Object mWebViewControllerLocker = new Object();
  private MailUI mailData;
  @SaveArgumentField
  private int mailFlag;
  @SaveArgumentField
  private long[] mailIds;
  private Future<long[]> mailIdsTask;
  private MailModifySendUtcWatcher mailModifySendUtcWatcher = new ReadMailFragment.33(this);
  private MailOperate mailOperate = new MailOperate();
  private DisplayMetrics metrics;
  private final MailMoveWatcher moveWatcher = new ReadMailFragment.15(this);
  private boolean needDropConv = false;
  private boolean needReload = true;
  private boolean needRender = false;
  private View nextBtn;
  private long notifyReadMailBeginTime;
  private IObserver observerFtnFailExceedLimit = new ReadMailFragment.6(this, null);
  private IObserver observerFtnFailWithExpireTime = new ReadMailFragment.5(this, null);
  private IObserver observerSaveFileError = new ReadMailFragment.4(this, null);
  private IObserver observerSaveFileSuccess = new ReadMailFragment.3(this, null);
  private View.OnClickListener onClockSend = new ReadMailFragment.91(this);
  private View.OnClickListener onDelete = new ReadMailFragment.65(this);
  private View.OnClickListener onMark = new ReadMailFragment.57(this);
  private View.OnClickListener onMore = new ReadMailFragment.76(this);
  private View.OnClickListener onSend = new ReadMailFragment.60(this);
  @SaveArgumentField
  private long[] parentListIds;
  private View preBtn;
  private final MailPurgeDeleteWatcher purgeDeleteWatcher = new ReadMailFragment.17(this);
  private EditTextInWebView quickEditText;
  private final Object quickEditTextLock = new Object();
  private QMQuickReplyView quickReplyView;
  private QMReadMailView readMailView;
  private ReadMailDefaultWatcher readMailWatcher = new ReadMailFragment.10(this);
  protected String refreshSkeyCallbackId;
  protected int refreshSkeyTime;
  protected String refreshTokenCallbackId;
  protected int refreshTokenTimes;
  private int rejectMail = 0;
  private int rejectType = 0;
  private final MailRejectWatcher rejectWatcher = new ReadMailFragment.20(this);
  private View.OnClickListener reload = new ReadMailFragment.90(this);
  private long reloadMailId = -1L;
  private int remindAhead = -1;
  private boolean remindOpen = false;
  private boolean remindSettingSynced = false;
  private int renderAttachCount = 0;
  private RenderAttachWatcher renderAttachWatcher = new ReadMailFragment.28(this);
  private int renderContentLength = -1;
  private long renderMailId = 0L;
  private ArrayList<MailBigAttach> saveFtnIdList = new ArrayList();
  private final Runnable saveQuickReplyContentRunnable = new ReadMailFragment.116(this);
  private ScreenShotServiceClient screenshotWatcher;
  private volatile int scrollPositionBeforeTranslate = 0;
  @SaveArgumentField
  private long[] searchMailIds;
  protected String selectContactsCallbackId;
  private PopupFrame selectTimePopupFrame;
  private final MailSpamWatcher spamWatcher = new ReadMailFragment.19(this);
  private final MailStartWatcher starWatch = new ReadMailFragment.13(this);
  private long startEnterTimeNew;
  private ReadMailTagViews tagView;
  private final MailTagWatcher tagWatcher = new ReadMailFragment.18(this);
  private final TextWatcher textWatcher = new ReadMailFragment.112(this);
  private ReadMailTitle titleView;
  private final MailTopWatcher topWatch = new ReadMailFragment.12(this);
  private TranslateMailWatcher translateMailWatcher = new ReadMailFragment.32(this);
  private final MailUnReadWatcher unreadWatch = new ReadMailFragment.14(this);
  private UpdateFtnExpireTimeWatcher updateFtnExpireTimeWatcher = new ReadMailFragment.34(this);
  private DropdownWebViewLayout webContainer;
  
  static
  {
    DELAY_SHOW_LOADING = Integer.valueOf(1);
  }
  
  public ReadMailFragment()
  {
    super(false);
  }
  
  public ReadMailFragment(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this(paramInt2, paramLong);
    this.mAccountId = paramInt1;
    this.mSubject = paramString1;
    this.mSenderNick = paramString2;
    this.mSenderEmail = paramString3;
  }
  
  public ReadMailFragment(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this(paramInt1, paramInt2, paramLong, paramString2, paramString3, paramString4);
    this.mRemoteId = paramString1;
    this.mFromPush = paramBoolean1;
    this.mFromScheme = paramBoolean2;
    this.mFromAttachFolder = paramBoolean3;
    this.mFromInquiryMail = paramBoolean4;
  }
  
  public ReadMailFragment(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Future<long[]> paramFuture)
  {
    this(paramInt1, paramInt2, paramLong, paramString1, paramString2, paramString3);
    this.mIsGroup = paramBoolean;
    this.mailIdsTask = paramFuture;
  }
  
  public ReadMailFragment(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, Future<long[]> paramFuture, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2, paramLong, paramString1, paramString2, paramString3);
    this.isCancelFail = paramBoolean2;
    this.mIsGroup = paramBoolean1;
    this.mailIdsTask = paramFuture;
  }
  
  public ReadMailFragment(int paramInt1, int paramInt2, long paramLong, long[] paramArrayOfLong, Future<long[]> paramFuture)
  {
    this(paramInt2, paramLong);
    this.mAccountId = paramInt1;
    this.mFromFolderId = 110;
    this.mSearchFolderId = paramInt2;
    this.searchMailIds = paramArrayOfLong;
    this.mailIdsTask = paramFuture;
  }
  
  private ReadMailFragment(int paramInt, long paramLong)
  {
    super(true);
    this.mFromFolderId = paramInt;
    this.id = paramLong;
  }
  
  public ReadMailFragment(int paramInt, long paramLong1, long paramLong2, long paramLong3, Future<long[]> paramFuture, long[] paramArrayOfLong)
  {
    this(paramInt, paramLong1);
    this.mParentMailId = paramLong2;
    this.aggregateType = paramLong3;
    this.mailIdsTask = paramFuture;
    this.parentListIds = paramArrayOfLong;
    if (paramInt == 110) {
      this.mFromFolderId = paramInt;
    }
  }
  
  public ReadMailFragment(int paramInt, long paramLong1, long paramLong2, Future<long[]> paramFuture)
  {
    this(paramInt, paramLong1);
    this.aggregateType = paramLong2;
    this.mailIdsTask = paramFuture;
  }
  
  private void abortDownloadAttach(Attach paramAttach)
  {
    QMLog.log(4, "ReadMailFragment", "going to abort download attach " + paramAttach.getName());
    AttachDownloadManager.shareInstance().abort(DownloadUtil.getDownloadUrl(paramAttach));
    DataCollector.logEvent("Event_Abort_Download_Attach_From_Readmail");
  }
  
  private void abortDownloadBigAttach(MailBigAttach paramMailBigAttach)
  {
    QMLog.log(4, "ReadMailFragment", "going to abort download bigAttach " + paramMailBigAttach.getName());
    paramMailBigAttach = (BigAttachDownloader)this.bigAttachDownloaderHashMap.remove(Long.valueOf(paramMailBigAttach.getHashId()));
    if (paramMailBigAttach != null) {
      paramMailBigAttach.abort();
    }
    DataCollector.logEvent("Event_Abort_Download_Attach_From_Readmail");
  }
  
  private void afterCreateRule(int paramInt)
  {
    if ((this.mailIds == null) || (this.mailIds.length == 0))
    {
      popBackStack();
      return;
    }
    boolean bool = this.mailData.getStatus().isConversationChild();
    if (bool) {
      dropConvFragment(true);
    }
    long[] arrayOfLong;
    for (long l1 = this.mParentMailId;; l1 = this.mailData.getInformation().getId())
    {
      arrayOfLong = QMMailManager.sharedInstance().getExistMailIdsAfterAutoMove(this.mAccountId, l1, this.mailIds);
      if (arrayOfLong != null) {
        break;
      }
      gotoSiblingMail();
      return;
    }
    QMLog.log(4, "ReadMailFragment", "afterCreateRule:isInConv:" + bool + ", nowMailId:" + l1 + ", restMailIds cnt:" + arrayOfLong.length + ", mailIds cnt:" + this.mailIds.length);
    int i = -1;
    Object localObject = new StringBuilder();
    paramInt = 0;
    while (paramInt < arrayOfLong.length)
    {
      ((StringBuilder)localObject).append(arrayOfLong[paramInt] + "|");
      paramInt += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    paramInt = 0;
    if (paramInt < this.mailIds.length)
    {
      int j;
      if (this.mailIds[paramInt] == l1) {
        j = paramInt;
      }
      do
      {
        do
        {
          paramInt += 1;
          i = j;
          break;
          j = i;
        } while (i <= -1);
        j = i;
      } while (!((String)localObject).contains(this.mailIds[paramInt] + "|"));
    }
    for (l1 = this.mailIds[paramInt];; l1 = 0L)
    {
      QMLog.log(4, "ReadMailFragment", "afterCreateRule:next - " + i + " nextMailId:" + l1);
      long l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (i > -1) {
          paramInt = i - 1;
        }
      }
      for (;;)
      {
        l2 = l1;
        if (paramInt >= 0)
        {
          if (((String)localObject).contains(this.mailIds[paramInt] + "|")) {
            l2 = this.mailIds[paramInt];
          }
        }
        else
        {
          QMLog.log(4, "ReadMailFragment", "afterCreateRule:prev - " + i + " nextMailId:" + l2);
          if (l2 != 0L) {
            break;
          }
          popBackStack();
          return;
        }
        paramInt -= 1;
      }
      this.mailIds = arrayOfLong;
      if (QMMailManager.sharedInstance().readMail(l2, true).getStatus().isConversation()) {}
      for (this.mParentMailId = l2;; this.mParentMailId = 0L)
      {
        reloadMail(l2);
        return;
      }
    }
  }
  
  private void afterMoveAd(boolean paramBoolean)
  {
    runOnMainThread(new ReadMailFragment.94(this, paramBoolean));
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
  
  private void attachSaveToFtn(int paramInt, boolean paramBoolean)
  {
    FtnManager localFtnManager = FtnManager.sharedInstance();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    this.saveFtnIdList.clear();
    Object localObject1 = (MailBigAttach)this.mailData.getInformation().getBigAttachList().get(paramInt);
    if (!paramBoolean)
    {
      localArrayList1.add(QMAttachUtils.removeIllegalString(((MailBigAttach)localObject1).getPreview().getDownloadUrl()));
      this.saveFtnIdList.add(localObject1);
    }
    for (;;)
    {
      localObject1 = new UrlQuerySanitizer();
      ((UrlQuerySanitizer)localObject1).setAllowUnregisteredParamaters(true);
      paramInt = 0;
      Object localObject3;
      while (paramInt < localArrayList1.size())
      {
        ((UrlQuerySanitizer)localObject1).parseUrl(QMAttachUtils.removeIllegalString((String)localArrayList1.get(paramInt)));
        localObject2 = ((UrlQuerySanitizer)localObject1).getValue("k");
        localObject3 = ((UrlQuerySanitizer)localObject1).getValue("code");
        if ((!StringExtention.isNullOrEmpty((String)localObject2)) && (!StringExtention.isNullOrEmpty((String)localObject3)))
        {
          localArrayList2.add(localObject2);
          localArrayList3.add(localObject3);
        }
        paramInt += 1;
      }
      localObject1 = this.mailData.getInformation().getBigAttachList();
      Object localObject2 = new Date();
      paramInt = 0;
      while (paramInt < ((ArrayList)localObject1).size())
      {
        localObject3 = (MailBigAttach)((ArrayList)localObject1).get(paramInt);
        Date localDate = ((MailBigAttach)localObject3).getExpire();
        if ((((MailBigAttach)localObject3).isBizNetDiskAttach()) || ((localDate != null) && (localDate.getTime() - ((Date)localObject2).getTime() > 0L)))
        {
          localArrayList1.add(((MailBigAttach)localObject3).getPreview().getDownloadUrl());
          this.saveFtnIdList.add(localObject3);
        }
        paramInt += 1;
      }
      localArrayList1 = DownloadUtil.getBigAttAchDownloadList(this.mailData.getInformation());
    }
    if ((localArrayList2.size() > 0) && (localArrayList2.size() == localArrayList3.size()))
    {
      getTips().showLoading(getString(2131718594));
      localFtnManager.saveFile(localArrayList2, localArrayList3);
      return;
    }
    getTips().showError(getString(2131718938));
  }
  
  private void autoUnreadMail()
  {
    if ((this.mManualOptId != this.id) && (!isMailContentNull(false)) && (this.mailData.getStatus().isUnread()))
    {
      QMLog.log(4, "ReadMailFragment", "autoUnreadMail: " + this.id);
      Threads.runInBackground(new ReadMailFragment.48(this));
    }
    QMPushMailNotify.getInstance().clearNewMailNotify(this.id);
  }
  
  private void bindHeaderOnClickListener()
  {
    this.detailView.setShowDetailOnClickListener(new ReadMailFragment.104(this));
    this.detailView.setShowAttachOnClickListener(new ReadMailFragment.105(this));
    this.detailView.setMailContactClickListener(new ReadMailFragment.106(this));
    this.detailView.setMailGroupContactClickListener(new ReadMailFragment.107(this));
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
      localObject1 = this.mailData.getInformation().getAttachListNoInlineImg();
      localObject2 = this.mailData.getInformation().getBigAttachList();
      i = ((ArrayList)localObject1).size();
      j = ((ArrayList)localObject2).size();
      if (paramInt < i)
      {
        localArrayList.add((Attach)((ArrayList)localObject1).get(paramInt));
        ImageAttachData.loadData(localArrayList, this.mailData.getStatus().isProtocolMail(), false);
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
      localObject2 = this.mailData.getInformation().getImageAttachListNoInlineImg();
      localObject1 = this.mailData.getInformation().getImageBigAttachList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add((Attach)((Iterator)localObject2).next());
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add((Attach)((Iterator)localObject1).next());
      }
      ImageAttachData.loadData(localArrayList, this.mailData.getStatus().isProtocolMail(), false);
    }
  }
  
  private void cacheMailDataIntoMailTranslate()
  {
    if (this.mMailTranslate == null) {
      this.mMailTranslate = new MailTranslate();
    }
    if (this.mailData.getContent() != null) {
      this.mMailTranslate.setOriginalMailContent(this.mailData.getContent().getBody());
    }
    if (this.mailData.getInformation() != null) {
      this.mMailTranslate.setOriginalMailSubj(this.mailData.getInformation().getSubject());
    }
  }
  
  private boolean canDetectMailLanguage()
  {
    boolean bool2 = true;
    if (this.mFromFolderId == 110) {}
    QMFolder localQMFolder;
    for (int i = this.mSearchFolderId;; i = this.mFromFolderId)
    {
      localQMFolder = getMailFolder(i);
      if (localQMFolder != null) {
        break;
      }
      return false;
    }
    if ((localQMFolder.getType() == 4) || (localQMFolder.getType() == 3))
    {
      bool1 = true;
      boolean bool3 = QMSettingManager.sharedInstance().isEnableTranslate();
      QMLog.log(4, "translate", "canDetectMailLanguage: " + bool1 + ", " + bool3);
      if ((bool1) || (!bool3)) {
        break label122;
      }
    }
    label122:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  private boolean canEnableTranslateMail()
  {
    boolean bool3 = canDetectMailLanguage();
    boolean bool1;
    if (this.readMailView != null)
    {
      bool1 = true;
      if ((!bool1) || (this.readMailView.isInTranslationMode())) {
        break label92;
      }
    }
    label92:
    for (boolean bool2 = true;; bool2 = false)
    {
      QMLog.log(4, "translate", "canEnableTranslateMail: " + bool3 + ", " + bool1 + ", " + bool2);
      if ((!bool3) || (!bool2)) {
        break label97;
      }
      return true;
      bool1 = false;
      break;
    }
    label97:
    return false;
  }
  
  private void changeMailContentAndSubj(String paramString1, String paramString2)
  {
    if ((this.mailData != null) && (this.mailData.getContent() != null)) {
      this.mailData.getContent().setBody(paramString1);
    }
    changeMailSubj(paramString2);
  }
  
  private void changeMailSubj(String paramString)
  {
    if ((this.mailData != null) && (this.mailData.getInformation() != null)) {
      this.mailData.getInformation().setSubject(paramString);
    }
  }
  
  private void changeRenderMailData()
  {
    int j = 0;
    this.renderMailId = this.mailData.getInformation().getId();
    Object localObject = this.mailData.getContent();
    if (localObject != null)
    {
      localObject = ((MailContent)localObject).getBody();
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int i = ((String)localObject).length();; i = 0)
    {
      this.renderContentLength = i;
      localObject = this.mailData.getInformation().getAttachList();
      i = j;
      if (localObject != null) {
        i = ((ArrayList)localObject).size();
      }
      this.renderAttachCount = i;
      return;
      localObject = null;
      break;
    }
  }
  
  private boolean checkAndroidVersion5()
  {
    if (Build.VERSION.RELEASE.equals("5.0"))
    {
      QMLog.log(3, "ReadMailFragment", "is AndroidVersion5!");
      if (isReadMailChange())
      {
        QMLog.log(4, "ReadMailFragment", "AndroidVersion5 and readmail change, clear ViewHolder!");
        clearViewHolder();
        return false;
      }
    }
    return true;
  }
  
  private void checkAppleIdVerifyCode(String paramString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if ((localAccount != null) && (localAccount.isQQMail())) {
      QMMailManager.sharedInstance().checkAppleidVerifyCode(this.mAccountId, this.mailData.getInformation().getRemoteId(), paramString).subscribe(new ReadMailFragment.124(this, paramString));
    }
  }
  
  private void clearIcsBarEvent()
  {
    View localView = this.header.findViewById(2131376811);
    if (localView != null) {
      localView.setOnClickListener(null);
    }
  }
  
  private void clearTipBarEvent()
  {
    Object localObject = this.header.findViewById(2131376808);
    if (localObject != null)
    {
      localObject = (Button)((View)localObject).findViewById(2131376809);
      if (localObject != null) {
        ((Button)localObject).setOnClickListener(null);
      }
    }
  }
  
  private void clearTranslateCache()
  {
    this.mMailTranslate = null;
    if ((this.readMailView != null) && (this.readMailView.isInTranslationMode())) {
      this.readMailView.setTranslateStatus(0);
    }
  }
  
  private static void clearViewHolder()
  {
    if ((sViewHolder != null) && (sViewHolder.activeFragment == null))
    {
      destroyDom(sViewHolder.readMailView, sViewHolder.webContainer, sViewHolder.webViewController);
      QMApplicationContext.sharedInstance().removeLowMemoryListener(sViewHolder.lowMemoryListener);
      sViewHolder.lowMemoryListener = null;
      sViewHolder.readMailView = null;
      sViewHolder.webContainer = null;
      sViewHolder.webViewController = null;
      sViewHolder = null;
    }
  }
  
  private void clearWebViewContent()
  {
    if (this.mWebViewController != null) {
      this.mWebViewController.clearHtml();
    }
    resetRenderMailData();
    this.isRenderHeader = false;
    runOnMainThread(new ReadMailFragment.35(this), 200L);
  }
  
  private void deleteClockSendMail(boolean paramBoolean)
  {
    removeFromMailIds(this.id);
    moveInquiryMailToTrash(paramBoolean);
    this.mailOperate.deleteWithClockSendMail(this.mAccountId, this.id, paramBoolean);
  }
  
  private void deleteMail(boolean paramBoolean)
  {
    removeFromMailIds(this.id);
    moveInquiryMailToTrash(paramBoolean);
    this.mailOperate.deleteMail(this.mAccountId, this.id, paramBoolean);
  }
  
  private static void destroyDom(QMReadMailView paramQMReadMailView, DropdownWebViewLayout paramDropdownWebViewLayout, QMScaleWebViewController paramQMScaleWebViewController)
  {
    if (paramDropdownWebViewLayout != null)
    {
      QMQuickReplyView localQMQuickReplyView = (QMQuickReplyView)paramDropdownWebViewLayout.findViewById(2131375396);
      if (localQMQuickReplyView != null) {
        localQMQuickReplyView.destroy();
      }
      paramDropdownWebViewLayout.release();
    }
    if (paramQMReadMailView != null)
    {
      paramDropdownWebViewLayout = (ReadMailDetailView)paramQMReadMailView.getHeader().findViewById(2131376656);
      if (paramDropdownWebViewLayout != null) {
        paramDropdownWebViewLayout.destroy();
      }
      paramQMReadMailView.setOnQuickReplyListener(null);
      paramQMReadMailView.destroy();
    }
    if (paramQMScaleWebViewController != null) {
      paramQMScaleWebViewController.destroy();
    }
  }
  
  private void detectLanguageAfterDomRender()
  {
    boolean bool = canEnableTranslateMail();
    if ((!bool) || (this.mailData == null) || (this.mailData.getStatus() == null) || (this.mailData.getStatus().hasFixDetectLanguageResult()))
    {
      localStringBuilder = new StringBuilder().append("dont detect after DomRender because: ");
      if (!bool)
      {
        str = "canEnableTranslateMail:" + bool;
        QMLog.log(4, "ReadMailFragment", str);
      }
    }
    while (this.mWebViewController == null) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        String str;
        return;
        if (this.mailData == null) {
          str = "mailData is null";
        } else if (this.mailData.getStatus() == null) {
          str = "mailData.getStatus() is null";
        } else {
          str = "hasFixDetectLanguageResult:" + this.mailData.getStatus().hasFixDetectLanguageResult();
        }
      }
    }
    this.mWebViewController.execJs("getMailContentHtml();");
  }
  
  private void detectLanguageAfterGetMailContent(String paramString)
  {
    boolean bool = canDetectMailLanguage();
    if ((!bool) || (paramString == null) || (this.mailData == null) || (this.mailData.getStatus() == null))
    {
      if (!bool) {
        paramString = "canEnableTranslateMail:" + bool;
      }
      for (;;)
      {
        QMLog.log(4, "ReadMailFragment", "dont detect after getmailcontent because: " + paramString);
        return;
        if (paramString == null) {
          paramString = "content is null";
        } else if (this.mailData == null) {
          paramString = "mailData is null";
        } else if (this.mailData.getStatus() == null) {
          paramString = "mailData.getStatus() is null";
        } else {
          paramString = "hasDetectLanguageByMailContent:" + this.mailData.getStatus().hasDetectLanguageByMailContent() + ", hasFixDetectLanguageResult:" + this.mailData.getStatus().hasFixDetectLanguageResult();
        }
      }
    }
    bool = false;
    try
    {
      if (paramString.trim().length() != 0) {
        bool = TranslateUtil.isFroeignLanguageSupport(paramString);
      }
      if ((bool) && (!this.mailData.getStatus().isForeignLanguageSupport())) {
        DataCollector.logEvent("Event_Translate_Judge_Success");
      }
      this.mailData.getStatus().setHasDetectLanguageByMailContent(true);
      this.mailData.getStatus().setIsForeignLanguageSupport(bool);
      QMMailManager.sharedInstance().updateMailDetectLanguageAttrByMailContent(this.mailData.getInformation().getId(), this.mailData.getStatus().hasDetectLanguageByMailContent(), this.mailData.getStatus().isForeignLanguageSupport());
      QMLog.log(4, "ReadMailFragment", "detectLanguage After GetMailContent. isFroeignLanguageSupport=" + bool);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.log(6, "ReadMailFragment", "detect language error!!", paramString);
    }
  }
  
  private void doCompressPreview(Attach paramAttach)
  {
    if ((paramAttach instanceof MailBigAttach)) {}
    for (paramAttach = ZipOnlinePreviewActivity.createIntentForBigAttach(paramAttach, String.valueOf(paramAttach.getBelongMailId()));; paramAttach = ZipOnlinePreviewActivity.createIntentForNormalAttach(paramAttach, String.valueOf(paramAttach.getBelongMailId())))
    {
      startActivity(paramAttach);
      return;
    }
  }
  
  private void downloadAttach(Attach paramAttach, String paramString)
  {
    QMLog.log(4, "ReadMailFragment", "going to download attach " + paramAttach.getName() + " savePath " + paramString);
    AttachDownloadManager.shareInstance().fetchAttach(DownloadUtil.createDownloadInfoForNormal(paramAttach, paramString, true));
    DataCollector.logEvent("Event_Download_Attach_From_Readmail");
  }
  
  private void downloadBigAttach(MailBigAttach paramMailBigAttach, String paramString)
  {
    QMLog.log(4, "ReadMailFragment", "going to download bigAttach " + paramMailBigAttach.getName());
    BigAttachDownloader localBigAttachDownloader2 = (BigAttachDownloader)this.bigAttachDownloaderHashMap.get(Long.valueOf(paramMailBigAttach.getHashId()));
    BigAttachDownloader localBigAttachDownloader1 = localBigAttachDownloader2;
    if (localBigAttachDownloader2 == null)
    {
      localBigAttachDownloader1 = new BigAttachDownloader(paramMailBigAttach, paramString, true);
      this.bigAttachDownloaderHashMap.put(Long.valueOf(paramMailBigAttach.getHashId()), localBigAttachDownloader1);
    }
    localBigAttachDownloader1.download();
    DataCollector.logEvent("Event_Download_Attach_From_Readmail");
  }
  
  private void downloadImageAttachSeq(String paramString, int paramInt, boolean paramBoolean)
  {
    paramInt = buildImageAttachDownSeq(paramInt, paramBoolean);
    this.mLoader = new TinyImageSeqLoader(this.mAccountId, paramString, ImageAttachData.imageInfoList, new ReadMailFragment.140(this, paramInt), null);
    getTips().setCanceledOnTouchOutside(false);
    this.mLoader.load(paramString, 0);
  }
  
  private void dropConvFragment(boolean paramBoolean)
  {
    this.needDropConv = paramBoolean;
  }
  
  private void ensureReadMode()
  {
    if (this.mEditMode) {
      enterReadMode();
    }
  }
  
  private void enterQuickReplyMode()
  {
    boolean bool = false;
    resetTranslateStatus();
    this.mEditMode = true;
    if (this.quickReplyView == null)
    {
      this.quickReplyView = ((QMQuickReplyView)this.webContainer.findViewById(2131375396));
      this.quickEditText = ((EditTextInWebView)this.quickReplyView.findViewById(14));
    }
    Object localObject2 = (TextView)this.quickReplyView.findViewById(13);
    int i = this.mailData.getInformation().getAccountId();
    Object localObject1 = this.mailData.getInformation().getFrom().getName();
    Object localObject3 = this.mailData.getInformation().getFrom().getAddress();
    if (this.mailData.getStatus().isGroupMail()) {
      localObject1 = this.mailData.getInformation().getGroupContact().getNick();
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.header.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
      localObject1 = restoreQuickReplyContent(this.id);
      this.quickEditText.setFocusable(true);
      this.quickEditText.setText((CharSequence)localObject1);
      this.quickEditText.setSelection(((String)localObject1).length());
      this.quickEditText.addTextChangedListener(this.textWatcher);
      this.quickEditText.setOnFocusChangeListener(this.mQuickReplyViewScrollListener);
      this.mWebViewController.setOnScrollChanged(this.mQuickReplyViewScrollListener);
      this.quickReplyView.findViewById(15).setOnClickListener(new ReadMailFragment.113(this));
      this.quickEditText.setTitleBarWebView(this.mWebViewController.getWebView());
      localObject2 = getTopBar();
      ((QMTopBar)localObject2).setButtonRightBlue(2131719473);
      localObject3 = ((QMTopBar)localObject2).getButtonRight();
      if (((String)localObject1).length() > 0) {
        bool = true;
      }
      ((View)localObject3).setEnabled(bool);
      ((QMTopBar)localObject2).setButtonRightOnclickListener(new ReadMailFragment.114(this));
      ((QMTopBar)localObject2).setButtonLeftNormal(2131691246);
      ((QMTopBar)localObject2).setButtonLeftOnclickListener(new ReadMailFragment.115(this));
      ((QMTopBar)localObject2).setTitle(2131718807);
      KeyBoardHelper.showSoftInputDelay(this.quickEditText, 0L);
      getActivity().setRequestedOrientation(1);
      return;
      if (this.mailData.canReplyAll())
      {
        localObject1 = SendMailHelper.getReplyAllToList(this.mailData);
        localObject3 = SendMailHelper.getReplyAllCcList(this.mailData);
        ArrayList localArrayList = new ArrayList();
        if (localObject1 != null)
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            localArrayList.add((MailContact)((ArrayList)localObject1).get(i));
            i += 1;
          }
        }
        if (localObject3 != null)
        {
          i = 0;
          while (i < ((ArrayList)localObject3).size())
          {
            localArrayList.add((MailContact)((ArrayList)localObject3).get(i));
            i += 1;
          }
        }
        localObject1 = MailAddrsViewControl.truncateShowText((TextView)localObject2, this.header.getWidth() / 2, localArrayList);
      }
      else
      {
        localObject1 = QMContactManager.sharedInstance().getPossibleNickname(i, (String)localObject3, (String)localObject1, this.mailData);
      }
    }
  }
  
  private void enterReadMode()
  {
    this.mEditMode = false;
    initTopBar();
    this.readMailView.setStatus(4);
    this.webContainer.findViewById(2131373842).setVisibility(0);
    this.webContainer.setAbleToPull(true);
    this.quickEditText.setFocusable(false);
    this.quickEditText.setTitleBarWebView(null);
    getTopBar().setButtonLeftOnclickListener(new ReadMailFragment.110(this));
    this.mWebViewController.setOnScrollChanged(null);
    hideKeyBoard();
    getBaseFragmentActivity().setRequestedOrientation(2);
  }
  
  private void enterTranslateMode()
  {
    if ((this.readMailView != null) && (!this.readMailView.isInTranslationMode()))
    {
      if (hasTranslateMailCached())
      {
        this.readMailView.setTranslateStatus(4);
        changeMailContentAndSubj(this.mMailTranslate.getTranslateContent(), this.mMailTranslate.getTranslateSubj());
        if (this.mWebViewController != null) {
          this.scrollPositionBeforeTranslate = this.mWebViewController.getScrollY();
        }
        render(true);
        DataCollector.logEvent("Event_Translate_Turn_On");
      }
    }
    else {
      return;
    }
    this.readMailView.setTranslateStatus(3);
    QMMailManager.sharedInstance().loadTranslateMail(this.mailData);
  }
  
  private void fillMailTranslate(MailTranslate paramMailTranslate)
  {
    if (paramMailTranslate == null) {
      return;
    }
    if (this.mMailTranslate == null) {
      this.mMailTranslate = new MailTranslate();
    }
    this.mMailTranslate.setTranslateContent(paramMailTranslate.getTranslateContent());
    this.mMailTranslate.setTranslateSubj(paramMailTranslate.getTranslateSubj());
  }
  
  private void followShareCalendar(String paramString1, String paramString2)
  {
    if (!QMCalendarManager.getInstance().isExistAccountForCalendar(this.mAccountId))
    {
      showCalendarSettingDialog();
      return;
    }
    QMCalendarManager.getInstance().followShareCalendarFolder(this.mAccountId, false, paramString1, paramString2);
  }
  
  private void genAppleIdVerifyCode(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if ((localAccount != null) && (localAccount.isQQMail())) {
      QMMailManager.sharedInstance().genAppleIdVerifyCode(this.mAccountId, this.mailData.getInformation().getRemoteId(), paramInt).subscribe(new ReadMailFragment.120(this));
    }
  }
  
  private DataPickerViewGroup.DatePickerListener getCalendarDatePickerListener()
  {
    if (this.calendarDatePickerListener == null) {
      this.calendarDatePickerListener = new ReadMailFragment.93(this);
    }
    return this.calendarDatePickerListener;
  }
  
  private DataPickerViewGroup.DatePickerListener getClockedMailDatePickerListener()
  {
    if (this.clockedMailDatePickerListener == null) {
      this.clockedMailDatePickerListener = new ReadMailFragment.92(this);
    }
    return this.clockedMailDatePickerListener;
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
  
  private String getFormattedAddress()
  {
    if ((this.mailData != null) && (this.mailData.getInformation() != null) && (this.mailData.getInformation().getFrom() != null))
    {
      if ((this.mailData.getInformation().getFrom().getName() != null) && (!this.mailData.getInformation().getFrom().getName().equals("")))
      {
        String str1 = this.mailData.getInformation().getFrom().getAddress();
        String str2 = this.mailData.getInformation().getFrom().getName();
        return QMContactManager.sharedInstance().getPossibleNickname(this.mAccountId, str1, str2, this.mailData) + "<" + this.mailData.getInformation().getFrom().getAddress() + ">";
      }
      return this.mailData.getInformation().getFrom().getAddress();
    }
    return "";
  }
  
  private QMFolder getMailFolder()
  {
    if (this.mailData != null)
    {
      if ((this.mFolder == null) || (this.mFolder.getId() == this.mailData.getInformation().getFolderId())) {
        this.mFolder = QMFolderManager.sharedInstance().getFolder(this.mailData.getInformation().getFolderId());
      }
      return this.mFolder;
    }
    return null;
  }
  
  private QMFolder getMailFolder(int paramInt)
  {
    if (this.mFolder == null) {
      this.mFolder = QMFolderManager.sharedInstance().getFolder(paramInt);
    }
    return this.mFolder;
  }
  
  private Mail getSiblingMail(int paramInt)
  {
    return QMMailManager.sharedInstance().readMailInfo(this.mailIds[paramInt], false);
  }
  
  private String[] getThirdPartyAttachName()
  {
    Object localObject1 = SendMailInterAppsManager.getInstance().getFilePaths();
    int i = ((List)localObject1).size();
    Object localObject2;
    if (i > 0)
    {
      localObject1 = (String)((List)localObject1).get(0);
      localObject2 = ((String)localObject1).split("/");
      if (FileUtil.isFileExist((String)localObject1)) {
        if (localObject2.length == 0) {
          localObject1 = "";
        }
      }
    }
    for (;;)
    {
      if (i == 1) {}
      for (localObject2 = " 为附件";; localObject2 = " 等" + i + "个文件为附件")
      {
        return new String[] { "添加 ", localObject1, localObject2 };
        localObject1 = localObject2[(localObject2.length - 1)];
        break;
      }
      localObject1 = "";
    }
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
    return "http://m.mailData.qq.com/cgi-bin/ftnExs_download?t=exs_ftnapp_download_android&f=xhtml&k=" + (String)localObject2 + "," + (String)localObject3 + "&sid=" + null + "&iswifi=" + QMNetworkUtils.isWifiConnected(getActivity());
  }
  
  private void goNext()
  {
    if ((this.mailData == null) || (this.mailData.getReference() == null)) {}
    MailReferenceNav localMailReferenceNav;
    do
    {
      return;
      localMailReferenceNav = this.mailData.getReference().getNext();
    } while (localMailReferenceNav == null);
    long l = localMailReferenceNav.getId();
    if (localMailReferenceNav.isConv())
    {
      this.mReadMailDirection = -1;
      this.mParentMailId = l;
    }
    for (;;)
    {
      if (this.readMailView != null) {
        this.readMailView.setStatus(1);
      }
      clearWebViewContent();
      if (this.detailView != null) {
        this.detailView.setShowDetail(false);
      }
      QMLog.log(4, "ReadMailFragment", "goNext : " + l);
      this.reloadMailId = l;
      Threads.runInBackground(new ReadMailFragment.54(this, l), 500L);
      clearTranslateCache();
      hideTranslateBubble(false);
      return;
      this.mReadMailDirection = 0;
      if (!localMailReferenceNav.isConvChild()) {
        this.mParentMailId = 0L;
      }
    }
  }
  
  private void goPrevious()
  {
    if ((this.mailData == null) || (this.mailData.getReference() == null)) {}
    MailReferenceNav localMailReferenceNav;
    do
    {
      return;
      localMailReferenceNav = this.mailData.getReference().getPrev();
    } while (localMailReferenceNav == null);
    long l = localMailReferenceNav.getId();
    if (localMailReferenceNav.isConv())
    {
      this.mReadMailDirection = 1;
      this.mParentMailId = l;
    }
    for (;;)
    {
      runOnMainThread(new ReadMailFragment.55(this));
      QMLog.log(4, "ReadMailFragment", "goPrevious : " + l);
      this.reloadMailId = l;
      Threads.runInBackground(new ReadMailFragment.56(this, l), 500L);
      clearTranslateCache();
      hideTranslateBubble(false);
      return;
      this.mReadMailDirection = 0;
      if (!localMailReferenceNav.isConvChild()) {
        this.mParentMailId = 0L;
      }
    }
  }
  
  private void gotoSiblingMail()
  {
    if (this.mailData == null)
    {
      setFragmentResult(1002, null);
      onButtonBackClick();
      return;
    }
    MailReference localMailReference = this.mailData.getReference();
    if (localMailReference == null)
    {
      setFragmentResult(1002, null);
      onButtonBackClick();
      return;
    }
    if (localMailReference.getNext() != null)
    {
      goNext();
      return;
    }
    if (localMailReference.getPrev() != null)
    {
      goPrevious();
      return;
    }
    setFragmentResult(1002, null);
    onButtonBackClick();
  }
  
  private void gotoSiblingMailInConv(long paramLong)
  {
    int i = 0;
    dropConvFragment(true);
    if (this.parentListIds != null)
    {
      if (this.parentListIds.length >= 2)
      {
        Object localObject1 = new long[this.parentListIds.length];
        int j = 0;
        int k = 0;
        if (k < this.parentListIds.length)
        {
          if (this.parentListIds[k] != paramLong)
          {
            localObject1[j] = this.parentListIds[k];
            j += 1;
          }
          for (;;)
          {
            k += 1;
            break;
            i = j;
          }
        }
        this.mailIds = ((long[])localObject1);
        j = i;
        if (i > this.mailIds.length - 1) {
          j = i - 1;
        }
        Object localObject2;
        for (localObject1 = getSiblingMail(j);; localObject1 = getSiblingMail(j))
        {
          localObject2 = localObject1;
          i = j;
          if (localObject1 != null) {
            break;
          }
          j += 1;
          localObject2 = localObject1;
          i = j;
          if (j >= this.mailIds.length) {
            break;
          }
        }
        while (localObject2 == null)
        {
          i -= 1;
          if (i < 0) {
            break;
          }
          localObject2 = getSiblingMail(i);
        }
        if (localObject2 != null)
        {
          paramLong = this.mailData.getInformation().getId();
          if ((this.mailData.getStatus().isConversation()) || (this.mailData.getStatus().isAdConv()) || (this.mailData.getStatus().isSubscribeConv())) {}
          for (this.mParentMailId = paramLong;; this.mParentMailId = 0L)
          {
            reloadMail(paramLong);
            return;
          }
        }
        popBackStack();
        return;
      }
      popBackStack();
      return;
    }
    onButtonBackClick();
  }
  
  private void handleRecallMail()
  {
    int i = 0;
    if ((isBizMail()) && (System.currentTimeMillis() - this.mailData.getInformation().getUtc().getTime() > 86400000L)) {
      i = 4;
    }
    while (i != 0)
    {
      showRecallErrorDialog(i);
      return;
      if (System.currentTimeMillis() - this.mailData.getInformation().getUtc().getTime() > 1296000000L) {
        i = 1;
      } else if ((!isQQMail()) && (this.mailData.getInformation().getLocalCount() == 0)) {
        i = 2;
      } else if (this.mailData.getStatus().getSendStatus() == 0) {
        i = 3;
      }
    }
    showRecallMailConfirmDialog();
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
      if ((paramSeqDownloadInfo.currentCount == paramSeqDownloadInfo.totalCount) && (paramSeqDownloadInfo.isComplete)) {
        SeqDownloadInfo.lastCount = 0;
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
  
  private boolean hasAttach(Mail paramMail)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramMail != null)
    {
      bool1 = bool2;
      if (paramMail.getInformation() != null)
      {
        localObject = paramMail.getInformation();
        bool1 = bool2;
        if (((MailInformation)localObject).getAttachList() != null)
        {
          bool1 = bool2;
          if (((MailInformation)localObject).getAttachList().size() > 0)
          {
            if (paramMail.getStatus().isProtocolMail()) {
              break label65;
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label65:
    paramMail = ((MailInformation)localObject).getAttachList();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramMail.size()) {
        break;
      }
      localObject = (Attach)paramMail.get(i);
      if ((((Attach)localObject).getProtocol().getType() != null) && (!((Attach)localObject).getProtocol().getType().equals("inline"))) {
        return true;
      }
      i += 1;
    }
  }
  
  private boolean hasMailAttach()
  {
    if ((this.mailData != null) && (this.mailData.getInformation() != null) && ((hasAttach(this.mailData)) || ((this.mailData.getInformation().getBigAttachList() != null) && (this.mailData.getInformation().getBigAttachList().size() > 0)) || ((this.mailData.getInformation().getEditAttachList() != null) && (this.mailData.getInformation().getEditAttachList().size() > 0))))
    {
      if (this.mailData.getContent() == null) {
        this.mailData.setContent(new MailContent());
      }
      if (this.mailData.getContent().getBody() == null) {
        this.mailData.getContent().setBody("");
      }
      return true;
    }
    return false;
  }
  
  private boolean hasSDCardAndHandleErrorIfNo()
  {
    if (FileUtil.hasSdcard()) {
      return true;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(2131690273).setTitle(2131690274)).addAction(2131696547, new ReadMailFragment.139(this))).create().show();
    return false;
  }
  
  private boolean hasTranslateMailCached()
  {
    return (this.mMailTranslate != null) && (this.mMailTranslate.getTranslateContent() != null) && (this.mMailTranslate.getTranslateSubj() != null) && (this.hasRenderCombineTranslateData != null) && (this.hasRenderCombineTranslateData.get() == true);
  }
  
  private boolean hasUndefineAttachFavorite()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    ArrayList localArrayList;
    int i;
    if (this.mailData != null)
    {
      localArrayList = this.mailData.getInformation().getAttachList();
      bool1 = bool2;
      if (localArrayList != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localArrayList.size())
      {
        Attach localAttach = (Attach)localArrayList.get(i);
        String str = localAttach.key();
        if ((localAttach.isFav()) && ((StringExtention.isNullOrEmpty(str)) || (str.equals("0")))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void hideIcsBar()
  {
    this.header.findViewById(2131376811).setVisibility(8);
  }
  
  private void hideLoading()
  {
    if ((this.readMailView != null) && ((this.readMailView.getStatus() == 0) || (this.readMailView.getStatus() == 5)))
    {
      this.readMailView.setProtocolRemoteSearchFlag(isProtocolRemoteSearchMail());
      this.readMailView.setStatus(1);
    }
  }
  
  private void hideTipsBar()
  {
    this.header.findViewById(2131376808).setVisibility(8);
  }
  
  private void hideTranslateBubble(boolean paramBoolean)
  {
    if ((this.readMailView != null) && (this.readMailView.getTranslateBubble() != null))
    {
      if (paramBoolean)
      {
        this.isPopupMoreThroughTranslateBubble = true;
        DataCollector.logEvent("Event_Translate_More_Operation_With_Tips");
        QMSettingManager.sharedInstance().setTranslatePromotionBubble(false);
      }
      QMReadMailView localQMReadMailView1 = this.readMailView;
      QMReadMailView localQMReadMailView2 = this.readMailView;
      localQMReadMailView1.removeTargetBubble(QMReadMailView.BUBBLE_TYPE_TRANSLATE);
    }
  }
  
  private void initHeader()
  {
    this.titleView = ((ReadMailTitle)this.header.findViewById(2131376659));
    this.tagView = ((ReadMailTagViews)this.header.findViewById(2131376658));
    this.detailView = ((ReadMailDetailView)this.header.findViewById(2131376656));
    this.detailView.initDoms();
    this.detailView.setShowDetail(false);
    bindHeaderOnClickListener();
  }
  
  private void initIsImageLoad()
  {
    switch (QMSettingManager.sharedInstance().getMailLoadImgType())
    {
    default: 
      this.isImageLoad = true;
      return;
    case 0: 
      this.isImageLoad = true;
      return;
    case 2: 
      this.isImageLoad = false;
      return;
    }
    this.isImageLoad = QMNetworkUtils.isWifiConnected();
  }
  
  private void initQuickReply()
  {
    QMFolder localQMFolder = getMailFolder();
    if ((localQMFolder != null) && (localQMFolder.getType() != 4) && (this.mailData != null) && (this.mailData.canReply())) {}
    for (boolean bool = true; FolderLockDialog.isFolderLock(this.mailData.getInformation().getFolderId()); bool = false)
    {
      this.readMailView.setPullToReply(false);
      this.readMailView.setEnterReplyModel(false);
      return;
    }
    this.readMailView.setPullToReply(bool);
    this.readMailView.setEnterReplyModel(bool);
  }
  
  private void initToolbar()
  {
    this.readMailView.resetBottomBar();
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.MARK, this.onMark);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.COMPOSE, this.onSend);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.EDIT, this.onSend);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.CLOCK, this.onClockSend);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.DELETE, this.onDelete);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.MORE, this.onMore);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.RELOAD, this.reload);
    this.readMailView.setViewListener(QMReadMailView.VIEW_ITEM.VERIFY, new ReadMailFragment.52(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle("");
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.getButtonLeft().setEnabled(true);
    this.preBtn = localQMTopBar.getButtonPrev();
    this.nextBtn = localQMTopBar.getButtonNext();
    localQMTopBar.setCenterOnclickListener(new ReadMailFragment.49(this));
    localQMTopBar.getButtonPrev().setContentDescription(getString(2131720825));
    localQMTopBar.getButtonNext().setContentDescription(getString(2131720823));
  }
  
  private void initTranslateIcon()
  {
    if (this.readMailView != null) {
      this.readMailView.setTranslateIconClickListener(new ReadMailFragment.127(this));
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initWebView()
  {
    if (this.mWebViewController == null) {
      return;
    }
    this.mManualOptId = 0L;
    QMScaleWebViewController localQMScaleWebViewController1 = this.mWebViewController;
    QMScaleWebViewController localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setJavascriptInterface(new ReadMailFragment.117(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setWebViewClient(new ReadMailFragment.118(this, localQMScaleWebViewController2));
    localQMScaleWebViewController1 = this.mWebViewController;
    localQMScaleWebViewController2 = this.mWebViewController;
    localQMScaleWebViewController2.getClass();
    localQMScaleWebViewController1.setOnLongClickListener(new ReadMailFragment.119(this, localQMScaleWebViewController2));
    this.mWebViewController.hideScrollbar();
    this.mWebViewController.setToolBar(null);
    this.attachListView = null;
    this.mWebViewController.setTranslateCallBack(this.mTranslateCallBack);
  }
  
  private void innerDialog(String paramString)
  {
    if (!isActivityAlive()) {
      return;
    }
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.147(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131692344));
    localBottomListSheetBuilder.addItem(getString(2131689844));
    String str = getExistContactName(paramString);
    if (str.equals("")) {}
    for (paramString = paramString + " " + getResources().getString(2131695686);; paramString = str + "(" + paramString + ") " + getResources().getString(2131693280))
    {
      localBottomListSheetBuilder.setTitle(paramString);
      localBottomListSheetBuilder.build().show();
      return;
    }
  }
  
  private boolean isActivityAlive()
  {
    return (isAttachedToActivity()) && (getActivity() != null);
  }
  
  private boolean isAppleIdMail()
  {
    if (this.mailData != null)
    {
      MailStatus localMailStatus = this.mailData.getStatus();
      if (localMailStatus != null) {
        return localMailStatus.isAppleIdMail();
      }
    }
    return false;
  }
  
  private boolean isAttachImage(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))) == AttachType.IMAGE;
  }
  
  private boolean isAttachOverOnlinePreviewSize(Attach paramAttach)
  {
    return BigAttachHelper.attachSizeOverOnlinePreview(paramAttach);
  }
  
  private boolean isAttachOverSize(Attach paramAttach)
  {
    return (isTencentAccount()) && (BigAttachHelper.attachSizeExcceedTen(paramAttach));
  }
  
  private boolean isBigAttachExpireTime(int paramInt)
  {
    if (this.attachListViewAdapter == null) {
      return false;
    }
    int i = this.attachListViewAdapter.getAttachListCount();
    int j = this.attachListViewAdapter.getBigAttachListCount();
    if ((paramInt >= i) && (paramInt < i + j) && (j > 0)) {
      paramInt -= i;
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        if (this.mailData == null) {
          return false;
        }
        ArrayList localArrayList = this.mailData.getInformation().getBigAttachList();
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localArrayList != null)
        {
          localObject1 = localObject2;
          if (paramInt < localArrayList.size()) {
            localObject1 = (MailBigAttach)localArrayList.get(paramInt);
          }
        }
        if ((localObject1 != null) && (((MailBigAttach)localObject1).isBizNetDiskAttach())) {
          return false;
        }
        if ((localObject1 != null) && ((((MailBigAttach)localObject1).getExpireTimeMilli() == -2L) || (((MailBigAttach)localObject1).getExpireTimeMilli() < System.currentTimeMillis()))) {
          return true;
        }
      }
      return false;
      paramInt = -1;
    }
  }
  
  private boolean isBizMail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    return (localAccount != null) && (localAccount.isBizMail());
  }
  
  /* Error */
  private boolean isBonusAccount(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 2990	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: new 2992	java/io/BufferedReader
    //   14: dup
    //   15: new 2994	java/io/InputStreamReader
    //   18: dup
    //   19: invokestatic 1595	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   22: invokevirtual 2995	com/tencent/qqmail/QMApplicationContext:getResources	()Landroid/content/res/Resources;
    //   25: invokevirtual 2999	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   28: ldc_w 3001
    //   31: invokevirtual 3007	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: invokespecial 3010	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 3013	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 5
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: invokevirtual 3016	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 6
    //   53: iload_3
    //   54: istore_2
    //   55: aload 6
    //   57: ifnull +20 -> 77
    //   60: aload 5
    //   62: astore 4
    //   64: aload_1
    //   65: aload 6
    //   67: invokevirtual 1568	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: istore_2
    //   71: iload_2
    //   72: ifeq -30 -> 42
    //   75: iconst_1
    //   76: istore_2
    //   77: aload 5
    //   79: invokevirtual 3019	java/io/BufferedReader:close	()V
    //   82: iload_2
    //   83: ireturn
    //   84: astore_1
    //   85: iload_2
    //   86: ireturn
    //   87: astore 6
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore 4
    //   94: bipush 6
    //   96: ldc_w 3021
    //   99: new 709	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 710	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 3023
    //   109: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 6
    //   114: invokevirtual 3024	java/io/IOException:toString	()Ljava/lang/String;
    //   117: invokevirtual 716	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 725	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 731	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 3019	java/io/BufferedReader:close	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_1
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_1
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: invokevirtual 3019	java/io/BufferedReader:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore 4
    //   148: goto -4 -> 144
    //   151: astore_1
    //   152: goto -13 -> 139
    //   155: astore 6
    //   157: aload 5
    //   159: astore_1
    //   160: goto -69 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	ReadMailFragment
    //   0	163	1	paramString	String
    //   54	32	2	bool1	boolean
    //   1	53	3	bool2	boolean
    //   44	96	4	localObject	Object
    //   146	1	4	localException	Exception
    //   40	118	5	localBufferedReader	java.io.BufferedReader
    //   51	15	6	str	String
    //   87	26	6	localIOException1	java.io.IOException
    //   155	1	6	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   77	82	84	java/lang/Exception
    //   11	42	87	java/io/IOException
    //   126	130	132	java/lang/Exception
    //   11	42	135	finally
    //   139	144	146	java/lang/Exception
    //   46	53	151	finally
    //   64	71	151	finally
    //   94	126	151	finally
    //   46	53	155	java/io/IOException
    //   64	71	155	java/io/IOException
  }
  
  private boolean isFromAttachFolder()
  {
    return this.mFromAttachFolder;
  }
  
  private boolean isFromPush()
  {
    return (this.mFromPush) || (this.mFromScheme) || (this.mFromAttachFolder);
  }
  
  private boolean isFromRemoteSearch()
  {
    return (isFromSearch()) && (QMMailManager.sharedInstance().isRemoteSearchMail(this.id));
  }
  
  private boolean isFromSearch()
  {
    return this.mFromFolderId == 110;
  }
  
  private boolean isInTranslateMode()
  {
    return (this.readMailView != null) && (this.readMailView.isInTranslationMode());
  }
  
  private boolean isMailContentNull(boolean paramBoolean)
  {
    Object localObject = this.mailData;
    if (localObject != null)
    {
      localObject = ((MailUI)localObject).getContent();
      if (localObject != null)
      {
        localObject = ((MailContent)localObject).getBody();
        if ((localObject != null) && ((!"".equals(localObject)) || (!paramBoolean))) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean isPopMail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    return (localAccount != null) && (localAccount.isPopMail());
  }
  
  private boolean isProtocolRemoteSearchMail()
  {
    if (this.mailData == null) {}
    while ((!isFromRemoteSearch()) || (isQQMail())) {
      return false;
    }
    return true;
  }
  
  private boolean isQQMail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if (localAccount != null) {
      return localAccount.isQQMail();
    }
    return false;
  }
  
  private boolean isReadMailChange()
  {
    return (sViewHolder.mailId != this.id) || (sViewHolder.folderId != this.mFromFolderId) || (sViewHolder.webViewController.isScale()) || (!sViewHolder.webViewController.isHTMLLoaded()) || ((sViewHolder.readMailView != null) && (sViewHolder.readMailView.isInTranslationMode()));
  }
  
  private boolean isRejectedMail()
  {
    if (this.mailData != null)
    {
      int i = this.mailData.getInformation().getAccountId();
      String str = this.mailData.getInformation().getFrom().getAddress();
      return QMMailManager.sharedInstance().isRejectedAddr(i, str);
    }
    return false;
  }
  
  private boolean isRenderMailChange()
  {
    return (this.mailData.getInformation().getId() != this.renderMailId) || (this.mailData.getContent() == null) || (this.mailData.getContent().getBody() == null) || (this.renderContentLength != this.mailData.getContent().getBody().length()) || (((this.mailData.getInformation().getAttachList() != null) || (this.renderAttachCount != 0)) && ((this.mailData.getInformation().getAttachList() == null) || (this.mailData.getInformation().getAttachList().size() != this.renderAttachCount)));
  }
  
  private boolean isShowFtnOperEntrance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    return ((!this.mailData.getStatus().isProtocolMail()) || (localQQMailAccount != null)) && (QMSettingManager.sharedInstance().getFtnDisplay());
  }
  
  private boolean isShowImage()
  {
    if (this.isImageLoad) {}
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
  
  private boolean isShowPopDelete()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mailData != null)
    {
      bool1 = bool2;
      if (!QMMailManager.sharedInstance().isPopMailComplete(this.mAccountId, this.id))
      {
        bool1 = bool2;
        if (QMMailManager.sharedInstance().isPopMailDeleted(this.mAccountId, this.id)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isShowReject(boolean paramBoolean)
  {
    int i;
    if (this.mailData != null) {
      i = this.mailData.getInformation().getAccountId();
    }
    return (!isTrashFolder(i)) || (isQQMail()) || ((isTrashFolder(i)) && (!isQQMail()) && (paramBoolean));
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
  
  private boolean isSpamFolder(int paramInt)
  {
    return this.mFromFolderId == QMFolderManager.sharedInstance().getSpamFolderId(paramInt);
  }
  
  private boolean isStranger(String paramString)
  {
    paramString = QMContactManager.sharedInstance().getContactByAccountAndEmail(this.mAccountId, paramString);
    return (paramString == null) || (QMContactManager.sharedInstance().isStranger(paramString));
  }
  
  private boolean isSystemMail()
  {
    if (this.mailData != null)
    {
      MailStatus localMailStatus = this.mailData.getStatus();
      if (localMailStatus != null) {
        return localMailStatus.isSystemMail();
      }
    }
    return false;
  }
  
  private boolean isTencentAccount()
  {
    return AccountManager.shareInstance().getAccountList().getAccountById(this.mailData.getInformation().getAccountId()).getEmail().contains("@tencent.com");
  }
  
  private boolean isTrashFolder(int paramInt)
  {
    return (this.mFromFolderId == QMFolderManager.sharedInstance().getTrashFolderId(paramInt)) || (this.mFromFolderId == -12);
  }
  
  private void leadToBlackNameListTips(String paramString)
  {
    String str1 = String.format(getString(2131690889), new Object[] { paramString });
    String str2 = getString(2131690888);
    String str3 = getString(2131691483);
    String str4 = getString(2131690879);
    paramString = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(str1).setTitle(str2)).addAction(str4, new ReadMailFragment.23(this))).addAction(str3, new ReadMailFragment.22(this, paramString))).create();
    paramString.setOnDismissListener(new ReadMailFragment.24(this));
    paramString.show();
    DataCollector.logEvent("Event_Black_White_Name_List_Popup_Dialog_In_Readmail_Reject");
  }
  
  private void leadToWhiteNameListTips(String paramString)
  {
    String str1 = String.format(getString(2131690891), new Object[] { paramString });
    String str2 = getString(2131690890);
    String str3 = getString(2131691487);
    String str4 = getString(2131690879);
    paramString = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(str1).setTitle(str2)).addAction(str4, new ReadMailFragment.26(this))).addAction(str3, new ReadMailFragment.25(this, paramString))).create();
    paramString.setOnDismissListener(new ReadMailFragment.27(this));
    paramString.show();
    DataCollector.logEvent("Event_Black_White_Name_List_Popup_Dialog_In_Spam_Not");
  }
  
  private void loadMailAll()
  {
    String str = "loadMailAll_" + this.id;
    if (loadMailFilterHashMap.containsKey(str))
    {
      if (((Long)loadMailFilterHashMap.get(str)).longValue() - System.currentTimeMillis() > 60000L)
      {
        loadMailFilterHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        QMMailManager.sharedInstance().loadMailAll(this.id);
      }
      return;
    }
    loadMailFilterHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
    QMMailManager.sharedInstance().loadMailAll(this.id);
  }
  
  private void logReadMail()
  {
    if (this.mailData == null) {
      return;
    }
    this.logMailId = this.mailData.getInformation().getId();
    long l = this.mAccountId;
    if (this.mailData.getInformation() != null) {}
    for (Object localObject = Long.valueOf(this.mailData.getInformation().getId());; localObject = "")
    {
      DataCollector.logDetailEvent("DetailEvent_ReadMail", l, 0L, String.valueOf(localObject));
      return;
    }
  }
  
  private void moveAdConfirm(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    String str2;
    if (isTencentAccount())
    {
      str1 = getString(2131693931);
      str2 = getFormattedAddress();
      paramString = (QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(paramString);
      if (!paramBoolean2) {
        break label132;
      }
    }
    label132:
    for (int i = 2131718761;; i = 2131718760)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)paramString.setMessage(String.format(getString(i), new Object[] { str2, str1 })).addAction(2131691246, new ReadMailFragment.96(this))).addAction(2131691971, new ReadMailFragment.95(this, paramBoolean2, paramBoolean1))).create().show();
      return;
      str1 = getString(2131718581);
      break;
    }
  }
  
  private void moveInquiryMailToTrash(boolean paramBoolean)
  {
    if (this.mFromInquiryMail) {
      InquiryMailManager.sharedInstance().moveInquiryMailToTrash(new String[] { this.mRemoteId }, paramBoolean);
    }
  }
  
  private void mustBeAdConfirm(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    String str2;
    if (isTencentAccount())
    {
      str1 = getString(2131693931);
      str2 = getFormattedAddress();
      paramString = (QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(paramString);
      if (!paramBoolean2) {
        break label132;
      }
    }
    label132:
    for (int i = 2131718760;; i = 2131718761)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)paramString.setMessage(String.format(getString(i), new Object[] { str2, str1 })).addAction(2131691246, new ReadMailFragment.98(this))).addAction(2131691971, new ReadMailFragment.97(this, paramBoolean2, paramBoolean1))).create().show();
      return;
      str1 = getString(2131693930);
      break;
    }
  }
  
  private boolean needDropConvFragment()
  {
    return this.needDropConv;
  }
  
  private void popUpCreditCardRemindDialog()
  {
    boolean bool = false;
    int j = SharedPreferenceUtil.getCreditCardBillRemindDate(this.mailData.getInformation().getRemoteId());
    int i = j;
    if (this.remindSettingSynced)
    {
      if (!this.remindOpen) {
        break label278;
      }
      i = j;
      if (this.remindAhead >= 0)
      {
        i = j;
        if (this.remindAhead <= 3) {
          i = this.remindAhead + 1;
        }
        if ((this.remindAhead != 7) && (this.remindAhead != 14)) {}
      }
    }
    label278:
    for (i = 5;; i = 0)
    {
      Object localObject = getActivity();
      if (i >= 0) {
        bool = true;
      }
      localObject = new QMBottomDialog.BottomListSheetBuilder((Context)localObject, bool);
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718748), getString(2131718748));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718747), getString(2131718747));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718743), getString(2131718743));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718745), getString(2131718745));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718744), getString(2131718744));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718742), getString(2131718742));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(2131718773);
      if (i >= 0) {
        ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(i);
      }
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ReadMailFragment.82(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).setOnDismissListener(new ReadMailFragment.83(this));
      ((QMBottomDialog)localObject).show();
      pauseObserveScreenShot();
      return;
    }
  }
  
  private void popupJourneyRemindDialog()
  {
    int j = SharedPreferenceUtil.getJourneyRemindDate(this.mailData.getInformation().getRemoteId());
    int i = j;
    if (this.remindSettingSynced)
    {
      if (!this.remindOpen) {
        break label254;
      }
      i = j;
      if (this.remindAhead >= 0)
      {
        i = j;
        if (this.remindAhead <= 3) {
          i = this.remindAhead;
        }
        if ((this.remindAhead != 7) && (this.remindAhead != 14)) {}
      }
    }
    label254:
    for (i = 4;; i = 0)
    {
      Object localObject = new QMBottomDialog.BottomListSheetBuilder(getActivity(), true);
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718753), getString(2131718753));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718749), getString(2131718749));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718752), getString(2131718752));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718751), getString(2131718751));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).addItem(getString(2131718750), getString(2131718750));
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setTitle(getString(2131718777, new Object[] { this.journeyDestination, this.journeyDestinationTime }));
      if (i >= 0) {
        ((QMBottomDialog.BottomListSheetBuilder)localObject).setCheckedIndex(i);
      }
      ((QMBottomDialog.BottomListSheetBuilder)localObject).setOnSheetItemClickListener(new ReadMailFragment.85(this));
      localObject = ((QMBottomDialog.BottomListSheetBuilder)localObject).build();
      ((QMBottomDialog)localObject).setOnDismissListener(new ReadMailFragment.86(this));
      ((QMBottomDialog)localObject).show();
      pauseObserveScreenShot();
      return;
    }
  }
  
  private void queryReminderSetting(boolean paramBoolean)
  {
    QMLog.log(4, "ReadMailFragment", "queryReminderSetting");
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new ReadMailFragment.44(this));
    localQMCallback.setOnError(new ReadMailFragment.45(this));
    QMMailManager.sharedInstance().getMailReminderSetting(paramBoolean, this.mailData, localQMCallback);
  }
  
  private void readMailData(boolean paramBoolean)
  {
    if (isFromSearch())
    {
      this.mailData = new SearchMailUI(QMMailManager.sharedInstance().readMailOrSearchMail(this.id), this.mParentMailId, this.searchMailIds, this.mailIdsTask);
      if ((this.mailData == null) || (this.mailData.getStatus() == null)) {
        break label203;
      }
      if ((!this.mailData.getStatus().isLoaded()) && (!QMMailManager.sharedInstance().isPopMailDeleted(this.mAccountId, this.id)))
      {
        QMMailManager.sharedInstance().tryLoadMail(this.mailData, this.mailFlag);
        runOnMainThread(new ReadMailFragment.40(this));
      }
    }
    label203:
    Account localAccount;
    do
    {
      do
      {
        return;
        if (paramBoolean)
        {
          if (!QMMailManager.sharedInstance().isPopMailDeleted(this.mAccountId, this.id)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            this.mailData = MailUI.readMailData(this.id, this.aggregateType, paramBoolean, this.mailIdsTask, this.mParentMailId);
            break;
          }
        }
        if (this.mailData == null) {
          break;
        }
        QMMailManager.sharedInstance().updateMailAttaches(this.mailData);
        QMMailManager.sharedInstance().updateMailStatus(this.mailData, isFromRemoteSearch());
        break;
      } while ((this.mAccountId == 0) || (StringUtils.isBlank(this.mRemoteId)));
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    } while ((localAccount == null) || (!localAccount.isQQMail()));
    QMMailManager.sharedInstance().loadQQMail(this.mAccountId, this.mRemoteId, null);
    runOnMainThread(new ReadMailFragment.41(this));
  }
  
  private void reedit()
  {
    ReadMailHelper.expireAttachReEditLocal(new ReadMailFragment.63(this), this.mailData, getActivity());
  }
  
  private void refreshBigAttach()
  {
    Object localObject1 = this.mailData.getInformation().getBigAttachList();
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof MailBigAttach)) {
          new BigAttachDownloader((MailBigAttach)localObject2, "", false).refreshBigAttach();
        }
      }
    }
  }
  
  private void rejectActionDialog(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 2131692671;
    }
    for (;;)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(paramInt).addAction(2131696547, new ReadMailFragment.64(this))).create().show();
      return;
      if (paramInt == 1) {
        paramInt = 2131692670;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private boolean reloadAggregateMailChild()
  {
    int i = 0;
    Object localObject = QMMailManager.sharedInstance();
    MailStatus localMailStatus = this.mailData.getStatus();
    MailInformation localMailInformation = this.mailData.getInformation();
    if (localMailStatus == null) {}
    do
    {
      return false;
      if (localMailStatus.isSubscribeConv())
      {
        this.mParentMailId = localMailInformation.getId();
        this.isContentDirty = true;
        if (localMailStatus.isHybirdList()) {}
        for (;;)
        {
          reloadMail(((QMMailManager)localObject).getRecentSubscribeMail(i).getInformation().getId());
          return true;
          i = localMailInformation.getAccountId();
        }
      }
      if (localMailStatus.isAdConv())
      {
        this.mParentMailId = localMailInformation.getId();
        this.isContentDirty = true;
        if (localMailStatus.isHybirdList()) {}
        for (i = 0;; i = localMailInformation.getAccountId())
        {
          localObject = ((QMMailManager)localObject).getRecentAdvertiseMail(i);
          if (localObject == null) {
            break;
          }
          localObject = ((Mail)localObject).getInformation();
          if (localObject == null) {
            break;
          }
          reloadMail(((MailInformation)localObject).getId());
          return true;
        }
      }
    } while ((!localMailStatus.isConversation()) || (!localMailStatus.isLoaded()));
    this.isContentDirty = true;
    if (this.mReadMailDirection == 1) {
      reloadMail(((QMMailManager)localObject).getConvLastChildId(this.mailData));
    }
    for (;;)
    {
      return true;
      if (this.mReadMailDirection == -1) {
        reloadMail(((QMMailManager)localObject).getConvFirstChildId(this.mailData));
      } else {
        reloadMail(((QMMailManager)localObject).getConvFirstChildId(this.mailData));
      }
    }
  }
  
  private void reloadMail()
  {
    this.needReload = true;
    initWebView();
    refreshData(true);
    render(true);
  }
  
  private void reloadMail(long paramLong)
  {
    if (this.id != paramLong) {}
    for (boolean bool = true;; bool = false)
    {
      this.needReload = bool;
      if (this.needReload)
      {
        this.id = paramLong;
        runOnMainThread(new ReadMailFragment.108(this));
      }
      return;
    }
  }
  
  private String removeCardTwoPxPicture(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf("greetingCard_mobi_img") > 0) {
      str = paramString.replaceAll("<img\\s+class\\s*=\\s*\"\\s*greetingCard_mobi_img\\s*\"", "<img ");
    }
    return str;
  }
  
  private String removeDataTextHtml(String paramString)
  {
    String str = paramString;
    if (!isQQMail()) {
      str = XSSTagFilter.removeDataTextHtml(paramString);
    }
    return str;
  }
  
  private void removeFromMailIds(long paramLong)
  {
    int j = 0;
    if ((this.mailIds == null) || (this.mailIds.length == 0)) {
      return;
    }
    long[] arrayOfLong = new long[this.mailIds.length - 1];
    int i = 0;
    while ((i < this.mailIds.length) && (j < arrayOfLong.length))
    {
      int k = j;
      if (this.mailIds[i] != paramLong)
      {
        arrayOfLong[j] = this.mailIds[i];
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    this.mailIds = arrayOfLong;
  }
  
  private void removeQuickReplyContent(long paramLong)
  {
    removeCallbackInBackground(this.saveQuickReplyContentRunnable);
    getActivity().getSharedPreferences("quickreply", 0).edit().remove("" + paramLong).commit();
  }
  
  private String removeRefreshMeta(String paramString)
  {
    for (;;)
    {
      String str = paramString;
      if (paramString.indexOf("http-equiv") > 0)
      {
        str = paramString;
        if (paramString.indexOf("refresh") > 0)
        {
          str = paramString.replaceFirst("<(meta).*?(http-equiv.*?=.*?\".*?refresh.*?\").*?>", "");
          if (!paramString.equals(str)) {
            break label45;
          }
        }
      }
      return str;
      label45:
      paramString = str;
    }
  }
  
  private String removeViewPortMeta(String paramString)
  {
    String str = paramString;
    if (isSystemMail()) {
      str = paramString.replaceFirst("<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\" name=\"viewport\"/>", "");
    }
    return str;
  }
  
  private void render(boolean paramBoolean)
  {
    MailUI localMailUI = this.mailData;
    Object localObject1;
    if (localMailUI != null)
    {
      localObject1 = localMailUI.getInformation();
      if (localMailUI == null) {
        break label242;
      }
      localObject2 = localMailUI.getStatus();
      label30:
      StringBuilder localStringBuilder = new StringBuilder().append("render, force: ").append(paramBoolean).append(", mailData: ");
      if (localMailUI == null) {
        break label248;
      }
      bool1 = true;
      label63:
      localStringBuilder = localStringBuilder.append(bool1).append(", mailInfo: ");
      if (localObject1 == null) {
        break label254;
      }
      bool1 = true;
      label86:
      localStringBuilder = localStringBuilder.append(bool1).append(", mailStatus: ");
      if (localObject2 == null) {
        break label260;
      }
      bool1 = true;
      label109:
      QMLog.log(4, "ReadMailFragment", bool1 + ", mailId: " + this.hasShowContentMailId + "/" + this.id + ", isContentDirty: " + this.isContentDirty);
      if ((localMailUI == null) || (localObject1 == null) || (localObject2 == null)) {
        break label266;
      }
    }
    label260:
    label266:
    for (boolean bool1 = true;; bool1 = false)
    {
      ValidateHelper.assertInDebug("invalid data", bool1);
      if (((this.hasShowContentMailId != this.id) || (paramBoolean) || (this.isContentDirty)) && (this.mWebViewController != null) && (localMailUI != null) && (localObject1 != null) && (localObject2 != null)) {
        break label272;
      }
      return;
      localObject1 = null;
      break;
      label242:
      localObject2 = null;
      break label30;
      label248:
      bool1 = false;
      break label63;
      label254:
      bool1 = false;
      break label86;
      bool1 = false;
      break label109;
    }
    label272:
    this.isContentDirty = false;
    renderHeader();
    int i = ((MailInformation)localObject1).getFolderId();
    if (FolderLockDialog.isFolderLock(i))
    {
      if (((this.lockDialog == null) || (!this.lockDialog.isShowing())) && (getActivity() != null))
      {
        this.lockDialog = new FolderLockDialog(getActivity(), i, this.mAccountId, this.folderLockWatcher);
        this.lockDialog.createDialog(1);
        this.lockDialog.showDialog();
      }
      this.hasShowContentMailId = -2L;
      this.isUnlockNoteFolder = false;
      return;
    }
    if (this.readMailView.getMailType() != resetMailType()) {
      this.readMailView.resetBottomBar();
    }
    paramBoolean = ((MailStatus)localObject2).isLoaded();
    Object localObject2 = localMailUI.getContent();
    label418:
    label429:
    int j;
    label452:
    int k;
    label470:
    int m;
    label488:
    int n;
    if (localObject2 != null)
    {
      localObject2 = ((MailContent)localObject2).getBody();
      if (localObject2 == null) {
        break label942;
      }
      i = ((String)localObject2).length();
      bool1 = hasMailAttach();
      if (((MailInformation)localObject1).getBigAttachList() == null) {
        break label947;
      }
      j = ((MailInformation)localObject1).getBigAttachList().size();
      if (((MailInformation)localObject1).getAttachList() == null) {
        break label952;
      }
      k = ((MailInformation)localObject1).getAttachList().size();
      if (((MailInformation)localObject1).getEditAttachList() == null) {
        break label958;
      }
      m = ((MailInformation)localObject1).getEditAttachList().size();
      n = this.readMailView.getStatus();
      QMLog.log(4, "ReadMailFragment", "render, isLoaded: " + paramBoolean + ", contentLen: " + this.renderContentLength + "/" + i + ", subject: " + ((MailInformation)localObject1).getSubject() + ", remoteId: " + ((MailInformation)localObject1).getRemoteId() + ", mailId: " + this.renderMailId + "/" + ((MailInformation)localObject1).getId() + ", hasMailAttach: " + bool1 + ", attach: " + this.renderAttachCount + "/" + k + ", bigAttach: " + j + ", editAttachSize:" + m + ", readMailStatus: " + n + ", accId: " + this.mAccountId);
      if ((!paramBoolean) || ((i == 0) && (!bool1))) {
        break label1018;
      }
      this.hasShowContentMailId = this.id;
      this.readMailView.setStatus(1);
      if (!isRenderMailChange()) {
        break label975;
      }
      if (!isShowPopDelete()) {
        break label964;
      }
      showMailDeleted();
      label728:
      if ((this.logMailId == 0L) || (((MailInformation)localObject1).getId() != this.logMailId)) {
        logReadMail();
      }
      if (!isFromPush()) {
        break label982;
      }
      DataCollector.logPerformanceEnd("Performance_Notify_Read_Mail_Time" + this.notifyReadMailBeginTime, "");
      label790:
      localObject1 = getMailFolder();
      if ((localObject1 == null) || (((QMFolder)localObject1).getType() == 4) || (!localMailUI.canReply())) {
        break label1013;
      }
      i = 1;
      label820:
      if ((this.readMailView != null) && (i != 0))
      {
        this.readMailView.setPullToReply(true);
        this.readMailView.setEnterReplyModel(true);
      }
    }
    for (;;)
    {
      paramBoolean = SharedPreferenceUtil.getCreditCardBillRemindOutterRedPoint();
      bool1 = localMailUI.getStatus().isAttrIsCreditMail();
      boolean bool2 = localMailUI.getStatus().isAttrIsJourneyMail();
      QMLog.log(4, "ReadMailFragment", "hasShowRedPtHint = " + paramBoolean + " isCreditCardBillMail = " + bool1);
      if ((!paramBoolean) && (bool1)) {
        this.readMailView.toggleRedPointVisibility(3, true);
      }
      if (!bool2) {
        break;
      }
      requestJourneyParseResult();
      return;
      localObject2 = null;
      break label418;
      label942:
      i = 0;
      break label429;
      label947:
      j = 0;
      break label452;
      label952:
      k = 0;
      break label470;
      label958:
      m = 0;
      break label488;
      label964:
      changeRenderMailData();
      showContent();
      break label728;
      label975:
      renderAttaches();
      break label728;
      label982:
      DataCollector.logPerformanceEnd("Performance_List_Read_Mail" + MailListFragment.listReadMailBeginTime, "");
      break label790;
      label1013:
      i = 0;
      break label820;
      label1018:
      if ((n == 0) && (!paramBoolean) && (i != 0)) {
        this.readMailView.setStatus(1);
      }
    }
  }
  
  private void renderAttaches()
  {
    if ((this.mailData != null) && (((this.mailData.getInformation().getAttachListNoInlineImg() != null) && (this.mailData.getInformation().getAttachListNoInlineImg().size() > 0)) || ((this.mailData.getInformation().getBigAttachList() != null) && (this.mailData.getInformation().getBigAttachList().size() > 0)) || ((this.mailData.getInformation().getEditAttachList() != null) && (this.mailData.getInformation().getEditAttachList().size() > 0))))
    {
      localArrayList1 = this.mailData.getInformation().getAttachListNoInlineImg();
      localArrayList2 = this.mailData.getInformation().getBigAttachList();
      localArrayList3 = this.mailData.getInformation().getEditAttachList();
      this.attachListViewAdapter = new AttachListViewAdapter();
      if (localArrayList1 != null)
      {
        this.attachListViewAdapter.setAttachList(localArrayList1);
        QMLog.log(4, "ReadMailFragment", "Render-attach attach count: " + localArrayList1.size());
      }
      if (localArrayList2 != null)
      {
        this.attachListViewAdapter.setBigAttachList(localArrayList2);
        QMLog.log(4, "ReadMailFragment", "Render-attach bigAttach count: " + localArrayList2.size());
      }
      if (localArrayList3 != null)
      {
        this.attachListViewAdapter.setEditAttachList(localArrayList3);
        QMLog.log(4, "ReadMailFragment", "Render-attach editAttach count: " + localArrayList3.size());
      }
      if (this.attachListView == null) {
        this.attachListView = ((LinearLayout)LayoutInflater.from(getActivity()).inflate(2131562937, null).findViewById(2131376802));
      }
      this.attachListViewAdapter.renderAttachList(this.attachListView);
      this.mWebViewController.setToolBar((ViewGroup)this.attachListView.getParent());
      updateMailBigAttachExpireTime();
    }
    while (this.attachListView == null)
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      return;
    }
    this.attachListView.removeAllViews();
    this.attachListView = null;
  }
  
  private void renderCombineTranslateData()
  {
    runOnMainThread(new ReadMailFragment.38(this));
  }
  
  private void renderHeader()
  {
    this.isRenderHeader = true;
    boolean bool1 = false;
    if (this.detailView != null)
    {
      boolean bool2 = this.detailView.isShowDetail();
      bool1 = bool2;
      if (this.mFolder != null)
      {
        this.detailView.setFromFolderType(this.mFolder.getType());
        bool1 = bool2;
      }
    }
    renderHeader(bool1);
  }
  
  private void renderHeader(boolean paramBoolean)
  {
    if ((this.header == null) || (this.mailData == null)) {}
    do
    {
      return;
      this.header.setVisibility(0);
      this.titleView.render(this.mailData);
      this.tagView.render(this.mailData);
      this.detailView.render(this.mailData, paramBoolean);
      initQuickReply();
      renderIcsBar();
      renderSendUtcBar();
    } while (this.mailData == null);
    if ((this.mailIds == null) || (this.mailIds.length == 0)) {
      this.mailIds = this.mailData.getMailIds();
    }
    this.mailData.updateReference(this.mailIds);
    updateTopbarNavigation();
  }
  
  private void renderIcsBar()
  {
    boolean bool = false;
    Object localObject1;
    if ((this.header == null) || (this.header.findViewById(2131376811) == null))
    {
      localObject1 = new StringBuilder().append("icsBar null: ");
      if (this.header == null) {
        bool = true;
      }
      QMLog.log(6, "ReadMailFragment", bool);
      return;
    }
    if ((this.mailData != null) && (this.mailData.getIcsEvent() != null))
    {
      localObject1 = this.mailData.getIcsEvent();
      Object localObject2 = this.header.findViewById(2131376811);
      ((View)localObject2).setVisibility(0);
      TextView localTextView = (TextView)((View)localObject2).findViewById(2131368763);
      localObject2 = (TextView)((View)localObject2).findViewById(2131368762);
      localTextView.setText(DateExtension.getIcsDateFormat(((QMCalendarEvent)localObject1).getStartTime(), ((QMCalendarEvent)localObject1).getEndTime(), ((QMCalendarEvent)localObject1).isAllDay()));
      ((TextView)localObject2).setText(((QMCalendarEvent)localObject1).getLocation());
      setIcsBarEvent();
      return;
    }
    this.header.findViewById(2131376811).setVisibility(8);
  }
  
  private void renderSendUtcBar()
  {
    boolean bool = false;
    Object localObject;
    if ((this.header == null) || (this.header.findViewById(2131376812) == null))
    {
      localObject = new StringBuilder().append("send utc bar  null: ");
      if (this.header == null) {
        bool = true;
      }
      QMLog.log(6, "ReadMailFragment", bool);
      return;
    }
    if (this.mFromFolderId == 110) {}
    for (int i = this.mSearchFolderId;; i = this.mFromFolderId)
    {
      localObject = getMailFolder(i);
      if ((this.mailData == null) || (this.mailData.getInformation() == null) || (this.mailData.getInformation().getSendUtc() <= 0L) || (localObject == null) || (((QMFolder)localObject).getType() != 4)) {
        break;
      }
      localObject = this.header.findViewById(2131376812);
      ((View)localObject).setVisibility(0);
      ((TextView)((View)localObject).findViewById(2131376807)).setText(DateExtension.fullDateName_yyyyMMddHHmm(this.mailData.getInformation().getSendUtc()));
      setSendUtcBarEvent();
      return;
    }
    this.header.findViewById(2131376812).setVisibility(8);
  }
  
  private void renderTipBar()
  {
    Object localObject1;
    boolean bool;
    if ((this.header == null) || (this.header.findViewById(2131376808) == null))
    {
      localObject1 = new StringBuilder().append("tipsBar null: ");
      if (this.header == null)
      {
        bool = true;
        QMLog.log(6, "ReadMailFragment", bool);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      localObject1 = (ViewGroup)this.header.findViewById(2131376808);
      ((ViewGroup)localObject1).setVisibility(8);
      if ((!isShowImage()) && (this.mWebViewController.getResourceLoader() != null) && (this.mWebViewController.getResourceLoader().hasResource()) && (!isPopMail()))
      {
        ((ViewGroup)localObject1).setVisibility(0);
        localObject2 = (Button)((ViewGroup)localObject1).findViewById(2131376809);
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject2).setOnClickListener(this.loadImageClickListener);
        localObject2 = (TextView)((ViewGroup)localObject1).findViewById(2131376807);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(getString(2131718599));
        ((PressableImageView)((ViewGroup)localObject1).findViewById(2131376810)).setVisibility(8);
        return;
      }
    } while ((this.mailData == null) || (this.mailData.getInformation() == null));
    int i = this.mailData.getStatus().getCheat();
    if (i <= 0)
    {
      this.header.findViewById(2131376808).setVisibility(8);
      return;
    }
    ((ViewGroup)localObject1).setVisibility(0);
    ((ViewGroup)localObject1).findViewById(2131376809).setVisibility(8);
    Object localObject2 = (TextView)((ViewGroup)localObject1).findViewById(2131376807);
    PressableImageView localPressableImageView = (PressableImageView)((ViewGroup)localObject1).findViewById(2131376810);
    Drawable localDrawable = getResources().getDrawable(2130841027).mutate();
    if (i == 103)
    {
      QMUIKit.setBackgroundKeepingPadding((View)localObject1, getResources().getDrawable(2130850401));
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167142));
      QMUIKit.setDrawableTintColor(localDrawable, getResources().getColor(2131167142));
      DataCollector.logEvent("Event_Show_Red_Spam_Bar");
      if ((i == 103) || (i == 101) || (i == 1) || (i == 102) || (i == 999))
      {
        if (i != 103) {
          break label494;
        }
        ((TextView)localObject2).setText(getString(2131718603));
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setVisibility(0);
      localPressableImageView.setImageDrawable(localDrawable);
      localPressableImageView.setVisibility(0);
      localPressableImageView.setOnClickListener(new ReadMailFragment.101(this, (ViewGroup)localObject1));
      return;
      QMUIKit.setBackgroundKeepingPadding((View)localObject1, getResources().getDrawable(2130850399));
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167141));
      QMUIKit.setDrawableTintColor(localDrawable, getResources().getColor(2131167141));
      DataCollector.logEvent("Event_Show_Normal_Spam_Bar");
      break;
      label494:
      if ((i == 101) || (i == 1)) {
        ((TextView)localObject2).setText(getString(2131718604));
      } else if (i == 102) {
        ((TextView)localObject2).setText(getString(2131718605));
      } else if (i == 999) {
        ((TextView)localObject2).setText(getString(2131718602));
      }
    }
  }
  
  private void renderTranslateMail(MailTranslate paramMailTranslate)
  {
    if ((this.mailData != null) && (paramMailTranslate != null))
    {
      fillMailTranslate(paramMailTranslate);
      cacheMailDataIntoMailTranslate();
      renderCombineTranslateData();
    }
  }
  
  private void renderWithContent()
  {
    if (this.mAnimationStep < 2)
    {
      this.delayRunList.add(DELAY_RENDER_WITH_CONTENT);
      return;
    }
    autoUnreadMail();
    render(true);
  }
  
  private void requestJourneyParseResult()
  {
    String str = this.mailData.getInformation().getRemoteId();
    int i = this.mailData.getInformation().getAccountId();
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new ReadMailFragment.79(this));
    localQMCallback.setOnError(new ReadMailFragment.80(this));
    QMMailManager.sharedInstance().getMailWeatherParseResult(i, str, localQMCallback);
  }
  
  private void requestToReadCreditCardBill()
  {
    SharedPreferenceUtil.setCreditCardBillRemindInnerRedPoint();
    int i = this.mailData.getInformation().getAccountId();
    if (SharedPreferenceUtil.getCreditCardDialogShown(i))
    {
      popUpCreditCardRemindDialog();
      return;
    }
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(i);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Account)localObject).getEmail())
    {
      localObject = String.format(getActivity().getString(2131718772), new Object[] { localObject });
      KvHelper.creditCardBillRemingdPopPermissionDialog(new double[0]);
      EnsureDialogUtil.ensureDialog(getActivity(), getString(2131718764), (String)localObject, 2131691246, 2131689596, new ReadMailFragment.81(this));
      return;
    }
  }
  
  private void requestToReadJourney()
  {
    if (!SharedPreferenceUtil.getJourneyDialogShown(this.mailData.getInformation().getAccountId()))
    {
      EnsureDialogUtil.ensureDialog(getActivity(), getString(2131718764), getString(2131718764), 2131691246, 2131689596, new ReadMailFragment.84(this));
      return;
    }
    popupJourneyRemindDialog();
  }
  
  private void resetLoadMailFilter(long paramLong)
  {
    String str = "loadMailAll_" + paramLong;
    loadMailFilterHashMap.remove(str);
  }
  
  private int resetMailType()
  {
    int i;
    if (this.mFromFolderId == 110)
    {
      i = this.mSearchFolderId;
      QMFolder localQMFolder = getMailFolder(i);
      if ((localQMFolder == null) || (localQMFolder.getType() != 4)) {
        break label112;
      }
      if ((this.mailData == null) || (this.mailData.getInformation() == null) || (this.mailData.getInformation().getSendUtc() <= 0L)) {
        break label84;
      }
      i = 5;
    }
    for (;;)
    {
      this.readMailView.setMailType(i);
      return i;
      i = this.mFromFolderId;
      break;
      label84:
      if ((AccountManager.shareInstance().getAccountList().hasQQMailAccounts()) && (NoteManager.sharedInstance() != null))
      {
        i = 1;
      }
      else
      {
        i = 2;
        continue;
        label112:
        i = 0;
      }
    }
  }
  
  private void resetRenderMailData()
  {
    this.renderContentLength = -1;
    this.renderAttachCount = 0;
    this.renderMailId = 0L;
  }
  
  private void resetTranslateStatus()
  {
    if ((this.readMailView != null) && (this.readMailView.isInTranslationMode()))
    {
      if (this.readMailView.getTranslateStatus() == 4) {
        showOriginalContentByJs();
      }
      this.readMailView.setTranslateStatus(0);
    }
  }
  
  private String restoreQuickReplyContent(long paramLong)
  {
    return getActivity().getSharedPreferences("quickreply", 0).getString("" + paramLong, "");
  }
  
  private void saveQuickReplyContent(boolean paramBoolean)
  {
    removeCallbackInBackground(this.saveQuickReplyContentRunnable);
    if (paramBoolean)
    {
      runInBackground(this.saveQuickReplyContentRunnable, 5000L);
      return;
    }
    this.saveQuickReplyContentRunnable.run();
  }
  
  private void scrollToPositonBeforeLoadTranslateHtml()
  {
    runOnMainThread(new ReadMailFragment.125(this), 80L);
  }
  
  private void selectTime(String paramString, long paramLong, DataPickerViewGroup.DatePickerListener paramDatePickerListener)
  {
    if (this.selectTimePopupFrame == null)
    {
      FrameLayout localFrameLayout = (FrameLayout)getActivity().getWindow().getDecorView();
      this.selectTimePopupFrame = ClockedMailHelper.getTimePickFrame(getActivity(), localFrameLayout, paramString, paramLong, 1, paramDatePickerListener);
    }
    if (!this.selectTimePopupFrame.hasShow()) {
      this.selectTimePopupFrame.show();
    }
  }
  
  private void sendQuickReply()
  {
    if (this.mailData.canReplyAll()) {}
    ComposeMailUI localComposeMailUI;
    for (Object localObject1 = ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL;; localObject1 = ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY)
    {
      localComposeMailUI = SendMailHelper.getComposeMail(this.id, (ComposeMailUI.QMComposeMailType)localObject1);
      if (localComposeMailUI != null) {
        break;
      }
      return;
    }
    if (localComposeMailUI.getStatus().isGroupMail()) {
      this.needRender = true;
    }
    localObject1 = this.quickEditText.getText().toString();
    int j = ((String)localObject1).length();
    int i = j;
    if (j > 50) {
      i = 50;
    }
    localComposeMailUI.getInformation().setAbstractContent(((String)localObject1).substring(0, i));
    Object localObject2 = StringExtention.textToHtml((String)localObject1);
    String str = QMSettingManager.sharedInstance().getAccountSignature(this.mAccountId);
    if ((str != null) && (!"".equals(str)))
    {
      i = 1;
      localObject1 = localObject2;
      if (i != 0) {
        localObject1 = (String)localObject2 + "<br/><br/><sign>" + StringExtention.textToHtml(str) + "</sign>";
      }
      localComposeMailUI.getContent().setBody((String)localObject1 + "<br/><br/>" + localComposeMailUI.getContent().getOrigin());
      localComposeMailUI.setRetryCount(0);
      localComposeMailUI.getStatus().setContentComplete(true);
      localComposeMailUI.setOriginAccountId(this.mAccountId);
      localComposeMailUI.getInformation().setAccountId(this.mAccountId);
      localComposeMailUI.setRlyHideInline(SendMailHelper.isRlyHideInline(localComposeMailUI));
      if (localComposeMailUI.getStatus().isGroupMail()) {
        break label374;
      }
    }
    label374:
    for (boolean bool = true;; bool = false)
    {
      localComposeMailUI.setQuickReply(bool);
      localComposeMailUI.setQuickReplyGroup(localComposeMailUI.getStatus().isGroupMail());
      localObject1 = QMTaskManager.sharedInstance(1);
      localObject2 = new QMSendMailTask();
      ((QMSendMailTask)localObject2).setAccountId(this.mAccountId);
      ((QMSendMailTask)localObject2).setMail(localComposeMailUI);
      Threads.runInBackground(new ReadMailFragment.109(this, (QMTaskManager)localObject1, (QMSendMailTask)localObject2));
      this.quickEditText.setText("");
      removeQuickReplyContent(this.id);
      enterReadMode();
      return;
      i = 0;
      break;
    }
  }
  
  private void setCheatTipNeverShow()
  {
    if ((this.mailData == null) || (this.mailData.getInformation() == null)) {}
    int i;
    do
    {
      return;
      i = this.mailData.getStatus().getCheat();
    } while ((i != 103) && (i != 101) && (i != 1) && (i != 102) && (i != 999));
    QMMailManager.sharedInstance().updateMailInfoCheat(this.mailData.getInformation().getId(), -i);
  }
  
  private void setIcsBarEvent()
  {
    View localView = this.header.findViewById(2131376811);
    if (localView != null) {
      localView.setOnClickListener(new ReadMailFragment.102(this));
    }
  }
  
  private void setSendUtcBarEvent()
  {
    View localView = this.header.findViewById(2131376812);
    if (localView != null) {
      localView.setOnClickListener(new ReadMailFragment.103(this));
    }
  }
  
  private void setTipBarEvent()
  {
    Button localButton = (Button)this.header.findViewById(2131376808).findViewById(2131376809);
    if ((localButton != null) && (localButton.getVisibility() == 0)) {
      localButton.setOnClickListener(this.loadImageClickListener);
    }
  }
  
  private void setToolBarBtnSelected(View paramView)
  {
    if (this.readMailView != null) {
      this.readMailView.setBottomBarBtnSelected(paramView);
    }
  }
  
  private void setToolBarBtnUNSelected()
  {
    runOnMainThread(new ReadMailFragment.53(this));
  }
  
  private void shareMailContent()
  {
    if (this.mWebViewController == null) {
      return;
    }
    QMTips localQMTips = getTips();
    localQMTips.showLoading(getString(2131696752));
    localQMTips.setCanceledOnTouchOutside(false);
    localQMTips.setCanceledWithBackKey(false);
    if ((this.mailData == null) || (this.mailData.getInformation() == null) || (TextUtils.isEmpty(this.mailData.getInformation().getSubject()))) {}
    for (String str = System.currentTimeMillis() + "";; str = this.mailData.getInformation().getSubject())
    {
      WebviewCaptureTask.startNewTask(this.mWebViewController.getWebView(), this.header, this.detailView, str, new ReadMailFragment.87(this, localQMTips));
      return;
    }
  }
  
  private void sharedAttachFile(int paramInt)
  {
    int i = this.attachListViewAdapter.getAttachListCount();
    Object localObject1;
    if (paramInt >= i)
    {
      i = paramInt - i;
      if (i != -1) {
        break label128;
      }
      localObject1 = (Attach)this.mailData.getInformation().getAttachListNoInlineImg().get(paramInt);
      label41:
      if (!((Attach)localObject1).isBigAttach()) {
        break label150;
      }
    }
    label128:
    label150:
    for (int j = 2131692325;; j = 2131690586)
    {
      this.isFileShare = true;
      if (!((Attach)localObject1).isBigAttach()) {
        break label157;
      }
      localObject1 = (MailBigAttach)localObject1;
      new QMShareFileDialogHelper(getActivity(), getString(j), ((MailBigAttach)localObject1).getPreview().getDownloadUrl(), QMShareFileDialogHelper.SHARE_TYPE_BIG_ATT, ((MailBigAttach)localObject1).getHashId()).createDialog().show();
      this.isFileShare = false;
      DataCollector.logEvent("Event_Share_Big_Attach_From_Readmail");
      return;
      i = -1;
      break;
      localObject1 = (Attach)this.mailData.getInformation().getBigAttachList().get(i);
      break label41;
    }
    label157:
    String str1 = QMAttachManager.sharedInstance().getAttachMyDisk(((Attach)localObject1).getHashId(), 0);
    if (!StringExtention.isNullOrEmpty(str1)) {}
    for (Object localObject2 = new File(str1);; localObject2 = null)
    {
      if ((localObject2 != null) && (((File)localObject2).exists()))
      {
        localObject2 = getActivity();
        String str2 = getString(j);
        if (isAttachImage((Attach)localObject1)) {}
        for (paramInt = QMShareFileDialogHelper.SHARE_TYPE_IMG;; paramInt = QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT)
        {
          new QMShareFileDialogHelper((Context)localObject2, str2, str1, paramInt).createDialog().show();
          this.isFileShare = false;
          DataCollector.logEvent("Event_Share_Normal_Attach_From_Readmail");
          return;
        }
      }
      if (((Attach)localObject1).isBigAttach()) {
        paramInt = i;
      }
      this.attachListViewAdapter.startAttachmentActivityByPos(paramInt, null);
      return;
    }
  }
  
  private void showAppleIdVerifyCodeView(String paramString)
  {
    Object localObject = new QMUIDialog.EditTextDialogBuilder(getActivity());
    EditText localEditText = ((QMUIDialog.EditTextDialogBuilder)localObject).getEditText();
    ((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)localObject).setTitle(paramString)).setPlaceholder(2131721666).addAction(2131691246, new ReadMailFragment.123(this))).addAction(2131696547, new ReadMailFragment.122(this, localEditText))).setLeftAction(getString(2131689495), new ReadMailFragment.121(this));
    paramString = ((QMUIDialog.EditTextDialogBuilder)localObject).create();
    ((QMUIDialog.EditTextDialogBuilder)localObject).getTitleView().setSingleLine(false);
    localObject = ((QMUIDialog.EditTextDialogBuilder)localObject).getRightImageView();
    ((ImageView)localObject).setImageResource(2130841401);
    Helper.initEditTextAndClearButton(localEditText, (View)localObject, null, null);
    localEditText.setHint(getString(2131721675));
    localEditText.setInputType(2);
    localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
    paramString.show();
    KeyBoardHelper.showSoftInputDelay(localEditText, 100L);
  }
  
  private void showAsyncDeleteClockSendMailDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131691551)).setMessage(2131692979).addAction(2131696547, new ReadMailFragment.72(this))).create().show();
  }
  
  private void showAttachActionDialog(int paramInt, View paramView, boolean paramBoolean)
  {
    this.isNormalAttach = false;
    this.isBigAttach = false;
    this.isEditAttach = false;
    DataCollector.logEvent("Event_Attach_Click_More_Btn_From_Readmail");
    int j = this.attachListViewAdapter.getAttachListCount();
    int k = this.attachListViewAdapter.getBigAttachListCount();
    if (paramInt < j)
    {
      this.isNormalAttach = true;
      if (super.isAttachedToActivity()) {
        break label93;
      }
      QMLog.log(6, "ReadMailFragment", "showattachdialog not attach to activity");
    }
    label93:
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder;
    Object localObject2;
    label150:
    boolean bool1;
    Object localObject1;
    label305:
    label334:
    do
    {
      return;
      if (paramInt < j + k)
      {
        this.isBigAttach = true;
        break;
      }
      this.isEditAttach = true;
      break;
      if (getActivity() == null)
      {
        QMLog.log(6, "ReadMailFragment", "getActivity() returns null.");
        return;
      }
      localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
      if (!this.isNormalAttach) {
        break label655;
      }
      localObject2 = (Attach)this.mailData.getInformation().getAttachListNoInlineImg().get(paramInt);
      bool1 = isAttachImage((Attach)localObject2);
      boolean bool2 = isImageAttachSingle();
      QMLog.log(4, "ReadMailFragment", "show attach more action:" + ((Attach)localObject2).getName());
      localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.141(this, paramInt, j, k, (Attach)localObject2));
      localBottomListSheetBuilder.addItem(getString(2131690550));
      localObject1 = getMailFolder();
      int i = -1;
      if (localObject1 != null) {
        i = ((QMFolder)localObject1).getType();
      }
      if ((this.isNormalAttach) && (i != -1) && (i != 4) && (i != 5) && (i != 6))
      {
        if (QMAttachManager.sharedInstance().isAttachFavorite(((Attach)localObject2).getHashId())) {
          break label715;
        }
        localBottomListSheetBuilder.addItem(getString(2131690532));
      }
      if (!bool1) {
        break label730;
      }
      localBottomListSheetBuilder.addItem(getString(2131690583));
      if (!TextUtils.isEmpty(getFilePath((Attach)localObject2))) {}
      if ((bool1) && (!bool2)) {
        localBottomListSheetBuilder.addItem(getString(2131690584));
      }
      Object localObject3 = "";
      if (!this.isBigAttach) {
        break label752;
      }
      Object localObject4 = this.mailData.getInformation().getBigAttachList();
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (paramInt - j < ((ArrayList)localObject4).size())
        {
          localObject3 = (MailBigAttach)((ArrayList)localObject4).get(paramInt - j);
          localObject1 = ((MailBigAttach)localObject3).getName();
          localObject4 = ((MailBigAttach)localObject3).getExpire();
          Date localDate = new Date();
          if (((((MailBigAttach)localObject3).isBizNetDiskAttach()) || ((localObject4 != null) && (((Date)localObject4).getTime() - localDate.getTime() > 0L))) && (isShowFtnOperEntrance()))
          {
            localBottomListSheetBuilder.addItem(getString(2131690570));
            if (this.attachListViewAdapter.getBigAttachListCount() > 1) {
              localBottomListSheetBuilder.addItem(getString(2131690566));
            }
          }
        }
      }
      if (!this.isEditAttach) {
        localBottomListSheetBuilder.addItem(getString(2131690586));
      }
      if ((isShowSaveToWeiYun()) && (DeviceUtil.isQCloudInstalled()) && (!this.isEditAttach)) {
        localBottomListSheetBuilder.addItem(getString(2131690572));
      }
      localBottomListSheetBuilder.setTitle((String)localObject1);
      localBottomListSheetBuilder.build().show();
    } while ((!paramBoolean) || (!OneStepUtils.isOneStepShowing()));
    label513:
    if (((Attach)localObject2).isExist())
    {
      localObject2 = ((Attach)localObject2).getPreview().getMyDisk();
      label608:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label874;
      }
      if (!bool1) {
        break label876;
      }
    }
    label655:
    label715:
    label730:
    label874:
    label876:
    for (paramBoolean = OneStepUtils.dragImageByOneStep(paramView, (String)localObject2);; paramBoolean = OneStepUtils.dragFileByOneStep(paramView, (String)localObject2, (String)localObject1))
    {
      Log.d("ReadMailFragment", "dragByOneStep:" + paramBoolean);
      return;
      if (this.isBigAttach)
      {
        localObject2 = (Attach)this.mailData.getInformation().getBigAttachList().get(paramInt - j);
        break label150;
      }
      localObject2 = (Attach)this.mailData.getInformation().getEditAttachList().get(paramInt - j - k);
      break label150;
      localBottomListSheetBuilder.addItem(getString(2131690535));
      break label305;
      if (this.isEditAttach) {
        break label334;
      }
      localBottomListSheetBuilder.addItem(getString(2131690582));
      break label334;
      label752:
      if (this.isNormalAttach)
      {
        localObject1 = this.mailData.getInformation().getAttachListNoInlineImg();
        if ((localObject1 != null) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject1).size()))
        {
          localObject1 = ((Attach)((ArrayList)localObject1).get(paramInt)).getName();
          break label513;
        }
        localObject1 = "";
        break label513;
      }
      localObject1 = this.mailData.getInformation().getEditAttachList();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((MailEditAttach)((ArrayList)localObject1).get(paramInt - j - k)).getName();
        break label513;
      }
      localObject1 = "";
      break label513;
      localObject2 = null;
      break label608;
      break;
    }
  }
  
  private void showCalendarSettingDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131691168).addAction(2131691246, new ReadMailFragment.154(this))).addAction(2131719634, new ReadMailFragment.153(this))).create().show();
  }
  
  private void showCanNotPreviewDialog(int paramInt)
  {
    QMLog.log(4, "ReadMailFragment", "can't preview attach of pos " + paramInt);
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131690562);
    localBottomListSheetBuilder.addItem(getString(2131690555));
    localBottomListSheetBuilder.addItem(getString(2131690563));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.137(this, paramInt));
    localBottomListSheetBuilder.build().show();
  }
  
  private void showCanNotPreviewDownloadConfirmDialog(QMUIDialogAction.ActionListener paramActionListener)
  {
    paramActionListener = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(2131690547).setTitle(2131696424)).addAction(2131691246, new ReadMailFragment.135(this))).addAction(2131690539, new ReadMailFragment.134(this, paramActionListener))).create();
    paramActionListener.setOnDismissListener(new ReadMailFragment.136(this));
    paramActionListener.show();
  }
  
  private void showClockSendMailDeleteConfirmDialog()
  {
    if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      showAsyncDeleteClockSendMailDialog();
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131691551)).setMessage(2131691549).addAction(2131691246, new ReadMailFragment.71(this))).addAction(0, 2131691840, 2, new ReadMailFragment.70(this))).create().show();
  }
  
  private void showComposeWithType(ComposeMailUI.QMComposeMailType paramQMComposeMailType, String paramString)
  {
    this.mailData.getInformation().setAccountId(this.mAccountId);
    if ((paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramQMComposeMailType == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)) {
      TimReportManager.reportClickEvent(getActivity(), "0X8008906", 0, 0, 0, 0, 0, "", "", "", "");
    }
    if (paramString == null) {}
    for (paramString = ComposeMailActivity.createIntentWithMail(paramQMComposeMailType, 0, this.mailData);; paramString = ComposeMailActivity.createIntentToReply(paramQMComposeMailType, 0, this.mailData, paramString))
    {
      if (SendMailInterAppsManager.getInstance().hasFile()) {
        paramString.putExtra("arg_from_third_party", true);
      }
      if (paramQMComposeMailType != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_DRAFT) {
        break;
      }
      startActivityForResult(paramString, 1000);
      return;
    }
    startActivity(paramString);
  }
  
  private void showCompressPreviewDialog(Attach paramAttach, int paramInt)
  {
    QMLog.log(4, "ReadMailFragment", "can't preview zip attach" + paramAttach.getName());
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131690562);
    localBottomListSheetBuilder.addItem(getString(2131690582));
    if (!isAttachOverOnlinePreviewSize(paramAttach)) {
      localBottomListSheetBuilder.addItem(getString(2131690554));
    }
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.138(this, paramInt, paramAttach));
    localBottomListSheetBuilder.build().show();
  }
  
  private void showContent()
  {
    int k = 1;
    this.loadContentStatus = 1;
    if (((this.isCancelFail) || (getActivity().getIntent().getBooleanExtra("arg_is_cancel_fail", false))) && (!this.hasGuideRecall))
    {
      this.hasGuideRecall = true;
      handleRecallMail();
    }
    this.needRender = false;
    if ((this.mWebViewController == null) || (this.mailData == null)) {
      return;
    }
    Object localObject2 = this.mWebViewController.getScaleInfo(this.mailData.getInformation().getId());
    String str1 = this.mWebViewController.parseScaleInfo((String[])localObject2, "content");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = QMApplicationContext.sharedInstance();
    String str2 = Template.CONTENT_HTML_TEMPLATE;
    Object localObject1;
    label137:
    int j;
    label164:
    int i;
    if (!this.mailData.getStatus().isProtocolMail())
    {
      localObject1 = "main_head_system_mail";
      localStringBuilder.append(Template.getTemplateSectionWithName((Context)localObject3, str2, (String)localObject1));
      if (this.mailData.getContent() != null) {
        break label743;
      }
      j = 1;
      if (j != 0) {
        break label831;
      }
      localObject1 = this.mailData.getContent().getBody();
      if ((str1 != null) && (!isInTranslateMode())) {
        break label748;
      }
      localObject1 = this.mWebViewController.reFormatHtml((String)localObject1);
      i = 0;
      label205:
      localStringBuilder.append(removeCardTwoPxPicture(removeDataTextHtml(removeViewPortMeta(removeRefreshMeta((String)localObject1)))));
    }
    for (;;)
    {
      localStringBuilder.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "main_tail"));
      str1 = localStringBuilder.toString();
      localStringBuilder.setLength(0);
      localStringBuilder.append("file:///read?t=mail");
      if (j != 0) {
        localStringBuilder.append("&contentNull=true");
      }
      if (j == 0)
      {
        localObject3 = localStringBuilder.append("&tableFix=");
        if (i != 0)
        {
          localObject1 = "true";
          label305:
          ((StringBuilder)localObject3).append((String)localObject1);
        }
      }
      else
      {
        localObject1 = this.mWebViewController.parseScaleInfo((String[])localObject2, "scale");
        if (localObject1 != null) {
          localStringBuilder.append("&scale=").append((String)localObject1);
        }
        localObject1 = this.mWebViewController.parseScaleInfo((String[])localObject2, "contentWidth");
        if (localObject1 != null) {
          localStringBuilder.append("&contentWidth=").append((String)localObject1);
        }
        localStringBuilder.append("&pageWidth=").append(this.mWebViewController.getPageWidth());
        localObject1 = Resources.getSystem().getDisplayMetrics();
        localStringBuilder.append("&fontSize=").append(18.0F * ((DisplayMetrics)localObject1).scaledDensity / ((DisplayMetrics)localObject1).density);
        localObject2 = localStringBuilder.append("&showdownloadalldiv=");
        if ((!this.mailData.getStatus().isProtocolMail()) || (this.mailData.getStatus().isContentComplete())) {
          break label786;
        }
        localObject1 = "true";
        label474:
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = localStringBuilder.append("&admail=");
        if ((!this.mailData.getStatus().isAdMail()) && (!this.mailData.getStatus().isAdByUser())) {
          break label794;
        }
        localObject1 = "true";
        label523:
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = localStringBuilder.append("&showimage=");
        if (!isShowImage()) {
          break label802;
        }
        localObject1 = "true";
        label553:
        ((StringBuilder)localObject2).append((String)localObject1);
        if ((!QMSettingManager.sharedInstance().getCalendarDisplay()) || (QMCalendarManager.getInstance().getCountOfAccountEnabled() <= 0)) {
          break label810;
        }
        i = k;
        label581:
        localObject2 = localStringBuilder.append("&isCalendarOpen=");
        if (i == 0) {
          break label815;
        }
        localObject1 = "true";
        label600:
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = localStringBuilder.append("&isSystemMail=");
        if (!this.mailData.getStatus().isSystemMail()) {
          break label823;
        }
      }
      label786:
      label794:
      label802:
      label810:
      label815:
      label823:
      for (localObject1 = "true";; localObject1 = "false")
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuilder.append("&appVersion=").append(AppConfig.getCodeVersion());
        this.loadUrl = localStringBuilder.toString();
        if (isPopMail()) {
          renderHeader();
        }
        this.mWebViewController.setMail(this.mailData);
        this.mWebViewController.loadHTML(localStringBuilder.toString(), str1);
        renderAttaches();
        renderTipBar();
        renderIcsBar();
        renderSendUtcBar();
        if (!isShowImage()) {
          break;
        }
        this.mWebViewController.downloadResource();
        return;
        localObject1 = "main_head";
        break label137;
        label743:
        j = 0;
        break label164;
        label748:
        if ((str1 != null) && (!str1.equals("<!--NotFixTable-->")))
        {
          localObject1 = str1;
          i = 1;
          break label205;
        }
        i = 1;
        break label205;
        localObject1 = "false";
        break label305;
        localObject1 = "false";
        break label474;
        localObject1 = "false";
        break label523;
        localObject1 = "false";
        break label553;
        i = 0;
        break label581;
        localObject1 = "false";
        break label600;
      }
      label831:
      i = 0;
    }
  }
  
  private void showDownloadConfirmDialog(String paramString1, String paramString2, boolean paramBoolean, QMUIDialogAction.ActionListener paramActionListener)
  {
    String str = getString(2131690545) + ", “";
    paramString2 = String.format(getString(2131690549), new Object[] { paramString2 });
    if (paramBoolean) {}
    for (paramString2 = "”" + paramString2 + ", " + getString(2131690537);; paramString2 = "”" + paramString2 + ", " + getString(2131690538) + ", " + getString(2131690537))
    {
      KvHelper.eventReadmailShowMobileDownload(new double[0]);
      paramActionListener = ((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)new QMUIDialog.CustomDialogBuilder(getActivity()).setTitle(2131690548)).setLayout(2131559230).addAction(2131691246, new ReadMailFragment.129(this))).addAction(2131690539, new ReadMailFragment.128(this, paramActionListener))).create();
      paramActionListener.setOnCancelListener(new ReadMailFragment.130(this));
      AttachNamesHandlerTextView localAttachNamesHandlerTextView = (AttachNamesHandlerTextView)paramActionListener.findViewById(2131371310);
      localAttachNamesHandlerTextView.setText(str, new String[] { paramString1 }, paramString2, false);
      localAttachNamesHandlerTextView.setVisibility(0);
      paramActionListener.setOnDismissListener(new ReadMailFragment.131(this));
      paramActionListener.show();
      return;
    }
  }
  
  private void showDownloadWithoutNetworkDialog()
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(2131690546).setTitle(2131696424)).addAction(2131696547, new ReadMailFragment.132(this))).create();
    localQMUIDialog.setOnDismissListener(new ReadMailFragment.133(this));
    localQMUIDialog.show();
  }
  
  private void showDraftDeleteConfirmDialog()
  {
    if (!isAttachedToActivity()) {
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131692977)).setMessage(2131692978).addAction(2131691246, new ReadMailFragment.69(this))).addAction(0, 2131691840, 2, new ReadMailFragment.68(this))).create().show();
  }
  
  private void showErrorView()
  {
    clearWebViewContent();
    if (this.readMailView != null) {
      this.readMailView.setStatus(2);
    }
  }
  
  private void showLoading()
  {
    if (this.mAnimationStep < 2) {
      this.delayRunList.add(DELAY_SHOW_LOADING);
    }
    do
    {
      return;
      resetRenderMailData();
    } while (this.readMailView == null);
    this.readMailView.setStatus(0);
  }
  
  private void showMailDeleted()
  {
    clearWebViewContent();
    if (this.readMailView != null) {
      this.readMailView.setStatus(6);
    }
  }
  
  private void showMarkMailPopup()
  {
    if (!isActivityAlive()) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!super.isAttachedToActivity());
      localObject = getMailFolder();
    } while ((this.mailData == null) || (this.mailData.getInformation() == null) || (localObject == null));
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    int i = ((QMFolder)localObject).getType();
    if ((i != 4) && (i != 5) && (i != 6) && (!Mail.isAdConv(this.aggregateType)))
    {
      if (this.mailData.getStatus().isUnread()) {
        localBottomListSheetBuilder.addItem(2130840823, getString(2131695668), getString(2131695668));
      }
    }
    else
    {
      if ((i != 6) && (i != 5) && (i != 4) && (!isProtocolRemoteSearchMail())) {
        localBottomListSheetBuilder.addItem(2130840841, getString(2131689933), getString(2131689933));
      }
      if (!this.mailData.getStatus().isStarred()) {
        break label308;
      }
      localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
      label196:
      if ((QMSettingManager.sharedInstance().getBonus()) && (this.mailData.canTop()))
      {
        if (!this.mailData.isTopped()) {
          break label332;
        }
        localBottomListSheetBuilder.addItem(2130840844, getString(2131695641), getString(2131695641));
      }
    }
    for (;;)
    {
      localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.58(this));
      localObject = localBottomListSheetBuilder.build();
      ((QMBottomDialog)localObject).setOnDismissListener(new ReadMailFragment.59(this));
      ((QMBottomDialog)localObject).show();
      pauseObserveScreenShot();
      return;
      localBottomListSheetBuilder.addItem(2130840825, getString(2131695671), getString(2131695671));
      break;
      label308:
      localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
      break label196;
      label332:
      localBottomListSheetBuilder.addItem(2130840842, getString(2131695634), getString(2131695634));
    }
  }
  
  private void showMoreActionsPopup()
  {
    SharedPreferenceUtil.setCreditCardBillRemindOutterRedPoint();
    Object localObject1 = getMailFolder();
    if ((this.mailData == null) || (this.mailData.getInformation() == null) || (this.mailData.getStatus() == null) || (localObject1 == null))
    {
      if (this.mailData == null) {
        QMLog.log(6, "ReadMailFragment", "showMoreActionsPopup error : mailData is null");
      }
      do
      {
        return;
        if (this.mailData.getInformation() == null)
        {
          QMLog.log(6, "ReadMailFragment", "showMoreActionsPopup error : mailData's information is null");
          return;
        }
        if (this.mailData.getStatus() == null)
        {
          QMLog.log(6, "ReadMailFragment", "showMoreActionsPopup error : mailData's status is null");
          return;
        }
      } while (localObject1 != null);
      QMLog.log(6, "ReadMailFragment", "showMoreActionsPopup error : folder is null");
      return;
    }
    int k = ((QMFolder)localObject1).getType();
    int m = this.mailData.getInformation().getAccountId();
    boolean bool3 = this.mailData.getStatus().isConversationChild();
    boolean bool1;
    boolean bool2;
    boolean bool4;
    label253:
    String str1;
    String str2;
    Object localObject2;
    int j;
    int i;
    if (this.mailData.getStatus().isConversationChild())
    {
      localObject1 = QMMailManager.sharedInstance().readMailInfo(this.mParentMailId);
      if (localObject1 != null) {
        if (((((Mail)localObject1).getStatus().isAdMail()) && (!((Mail)localObject1).getStatus().isNotAdByUser())) || (((Mail)localObject1).getStatus().isAdByUser()))
        {
          bool1 = true;
          bool2 = isProtocolRemoteSearchMail();
          boolean bool5 = this.mailData.getStatus().isSubscribeMail();
          bool4 = isRejectedMail();
          if (!isTencentAccount()) {
            break label912;
          }
          localObject1 = getString(2131693931);
          str1 = String.format(getString(2131718763), new Object[] { localObject1 });
          str2 = String.format(getString(2131718762), new Object[] { localObject1 });
          localObject2 = getString(2131695627);
          j = 2130840783;
          if (!this.mailData.getStatus().isSubscribeMail()) {
            break label924;
          }
          localObject1 = getString(2131695640);
          i = 2130840801;
          label334:
          localObject2 = new QMBottomDialog.BottomGridSheetBuilder(getActivity());
          if ((canEnableTranslateMail()) && (this.mailData.getStatus().isForeignLanguageSupport())) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840800, getString(2131721274), getString(2131721274), 0);
          }
          if ((this.readMailView != null) && (this.readMailView.isInTranslationMode())) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840800, getString(2131691558), getString(2131691558), 0);
          }
          if ((k == 3) && (isQQMail()))
          {
            if (!this.mailData.getStatus().isRecall()) {
              break label966;
            }
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840789, getString(2131717247), getString(2131717247), 0);
          }
          label478:
          if ((k != 6) && (k != 4) && (k != 5) && (!bool2)) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840784, getString(2131697042), getString(2131697042), 1);
          }
          if ((this.mailData.canSpam()) && (!bool2)) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840787, getString(2131695632), getString(2131695632), 1);
          }
          if ((!bool2) && (isShowReject(bool4)) && (k != 3) && (k != 4) && ((this.mailData.canReject()) || (this.mailData.getStatus().isSubscribeMail()))) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(i, (String)localObject1, (String)localObject1, 1);
          }
          if (k == 6) {
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840790, getString(2131695630), getString(2131695630), 1);
          }
          QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(this.mFromFolderId);
          if ((k != 4) && ((!bool5) || (k == 5)) && (!bool2))
          {
            if (bool4) {
              break label992;
            }
            bool2 = true;
            label687:
            if ((isShowReject(bool2)) && ((this.mailData == null) || (!this.mailData.getStatus().isProtocolMail()) || ((k != -2) && ((localQMFolder == null) || (localQMFolder.getType() != -2))))) {
              break label998;
            }
          }
          label737:
          if ((k == 1) && (QMSettingManager.sharedInstance().getAggregateAdMail()))
          {
            if (!bool1) {
              break label1024;
            }
            ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840777, str1, str1, 1);
          }
        }
      }
    }
    for (;;)
    {
      ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840792, getString(2131696757), getString(2131696757), 0);
      ((QMBottomDialog.BottomGridSheetBuilder)localObject2).setOnSheetItemClickListener(new ReadMailFragment.77(this, m, (String)localObject1, bool4, str1, bool1, bool3, str2));
      localObject1 = ((QMBottomDialog.BottomGridSheetBuilder)localObject2).build();
      ((QMBottomDialog)localObject1).setOnDismissListener(new ReadMailFragment.78(this));
      ((QMBottomDialog)localObject1).show();
      pauseObserveScreenShot();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break;
      if (((this.mailData.getStatus().isAdMail()) && (!this.mailData.getStatus().isNotAdByUser())) || (this.mailData.getStatus().isAdByUser())) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label912:
      localObject1 = getString(2131693930);
      break label253;
      label924:
      i = j;
      localObject1 = localObject2;
      if (!bool4) {
        break label334;
      }
      i = j;
      localObject1 = localObject2;
      if (!isTrashFolder(m)) {
        break label334;
      }
      localObject1 = getString(2131695638);
      i = 2130840783;
      break label334;
      label966:
      ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840788, getString(2131718613), getString(2131718613), 0);
      break label478;
      label992:
      bool2 = false;
      break label687;
      label998:
      ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840776, getString(2131696007), getString(2131696007), 0);
      break label737;
      label1024:
      ((QMBottomDialog.BottomGridSheetBuilder)localObject2).addItem(2130840772, str2, str2, 1);
    }
  }
  
  private void showOriginalContentByJs()
  {
    if ((this.mWebViewController == null) || (this.readMailView == null)) {
      return;
    }
    if (this.mWebViewController.isWebViewTitleVisible()) {
      this.mWebViewController.execJs("mailAppOriginal(false);");
    }
    for (;;)
    {
      this.readMailView.setTranslateStatus(5);
      if (this.mMailTranslate != null) {
        changeMailSubj(this.mMailTranslate.getOriginalMailSubj());
      }
      renderHeader();
      return;
      this.mWebViewController.execJs("mailAppOriginal(true);");
    }
  }
  
  private void showProcessing(String paramString)
  {
    getTips().showLoading(paramString);
  }
  
  private void showRecallErrorDialog(int paramInt)
  {
    if (paramInt == 4) {
      paramInt = 2131718615;
    }
    for (;;)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131718614)).setMessage(paramInt).addAction(2131696547, new ReadMailFragment.73(this))).create().show();
      return;
      if (paramInt == 1) {
        paramInt = 2131718619;
      } else if (paramInt == 2) {
        paramInt = 2131718621;
      } else if (paramInt == 3) {
        paramInt = 2131718616;
      } else {
        paramInt = 2131718614;
      }
    }
  }
  
  private void showRecallMailConfirmDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131718624).addAction(2131691246, new ReadMailFragment.75(this))).addAction(2131718613, new ReadMailFragment.74(this))).create().show();
  }
  
  private void showSendMailPopup()
  {
    Object localObject1 = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    if (SendMailInterAppsManager.getInstance().hasFile())
    {
      localObject2 = LayoutInflater.from(getActivity()).inflate(2131558787, null, false);
      AttachNamesHandlerTextView localAttachNamesHandlerTextView = (AttachNamesHandlerTextView)((View)localObject2).findViewById(2131363691);
      ((View)localObject2).setTag(getString(2131718578));
      String str1 = getThirdPartyAttachName()[0];
      String str2 = getThirdPartyAttachName()[1];
      String str3 = getThirdPartyAttachName()[2];
      localAttachNamesHandlerTextView.setText(str1, new String[] { str2 }, str3, false);
      ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(2131296717)));
      ((QMBottomDialog.BottomListSheetBuilder)localObject1).addHeaderView((View)localObject2);
      this.readMailView.getAttachBubbleView().setVisibility(8);
    }
    if ((this.mailData != null) && (this.mailData.getStatus() != null) && (this.mailData.canReply())) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject1).addItem(2130840834, getString(2131718803), getString(2131718803));
    }
    Object localObject2 = getMailFolder();
    if (localObject2 == null) {
      return;
    }
    int i = ((QMFolder)localObject2).getType();
    if ((this.mailData != null) && (this.mailData.canReplyAll())) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject1).addItem(2130840835, getString(2131718802), getString(2131718802));
    }
    ((QMBottomDialog.BottomListSheetBuilder)localObject1).addItem(2130840819, getString(2131693977), getString(2131693977));
    if ((i == 3) || ((i == 14) && (QMFolderManager.sharedInstance().getFolder(this.mailData.getInformation().getFolderId()).getType() == 3))) {
      ((QMBottomDialog.BottomListSheetBuilder)localObject1).addItem(2130840832, getString(2131718665), getString(2131718665));
    }
    ((QMBottomDialog.BottomListSheetBuilder)localObject1).setOnSheetItemClickListener(new ReadMailFragment.61(this));
    localObject1 = ((QMBottomDialog.BottomListSheetBuilder)localObject1).build();
    this.readMailView.getAttachBubbleView().setTag(2131363628, Boolean.valueOf(false));
    ((QMBottomDialog)localObject1).setOnDismissListener(new ReadMailFragment.62(this));
    pauseObserveScreenShot();
    ((QMBottomDialog)localObject1).show();
  }
  
  private void showShiftDeleteMailConfirmDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131697042)).setMessage(2131697043).addAction(2131691246, new ReadMailFragment.67(this))).addAction(0, 2131691840, 2, new ReadMailFragment.66(this))).create().show();
  }
  
  private void showTipsError(String paramString)
  {
    getTips().showError(paramString);
  }
  
  private void showTipsInfo(String paramString)
  {
    getTips().showSuccess(paramString);
  }
  
  private void showTranslateContentByJs()
  {
    if ((this.mWebViewController == null) || (this.readMailView == null)) {
      return;
    }
    if (this.mWebViewController.isWebViewTitleVisible()) {
      this.mWebViewController.execJs("mailAppTranslate(false);");
    }
    for (;;)
    {
      this.readMailView.setTranslateStatus(4);
      changeMailSubj(this.mMailTranslate.getTranslateSubj());
      renderHeader();
      return;
      this.mWebViewController.execJs("mailAppTranslate(true);");
    }
  }
  
  private void showTranslateProtocolMailDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setMessage(getString(2131721275)).addAction(2131691255, new ReadMailFragment.89(this))).addAction(2131696548, new ReadMailFragment.88(this))).create().show();
  }
  
  private void startRecallMailFragment(int paramInt)
  {
    startFragment(new MailRecallListFragment(this.mailData.getInformation().getId(), paramInt));
  }
  
  private void unBindHeaderOnClickListener()
  {
    if (this.detailView != null)
    {
      this.detailView.setShowDetailOnClickListener(null);
      this.detailView.setShowAttachOnClickListener(null);
      this.detailView.setMailContactClickListener(null);
      this.detailView.setMailGroupContactClickListener(null);
    }
  }
  
  private void updateAfterVote(String paramString)
  {
    runOnMainThread(new ReadMailFragment.145(this));
    this.mailData.getStatus().setLoaded(false);
    QMMailManager.sharedInstance().tryLoadMail(this.mailData, this.mailFlag);
  }
  
  private void updateMailBigAttachExpireTime()
  {
    ArrayList localArrayList = this.mailData.getInformation().getBigAttachList();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      if (i < localArrayList.size())
      {
        MailBigAttach localMailBigAttach = (MailBigAttach)localArrayList.get(i);
        if ((localMailBigAttach.isBizNetDiskAttach()) || (localMailBigAttach.getExpireTimeMilli() == -2L)) {
          QMLog.log(4, "ReadMailFragment", "updateMailBigAttachExpireTime, mailBigAttach isBizNetDiskAttach:" + localMailBigAttach.isBizNetDiskAttach() + ", getExpireTimeMilli:" + localMailBigAttach.getExpireTimeMilli());
        }
        for (;;)
        {
          i += 1;
          break;
          if (localMailBigAttach.getExpireTimeMilli() < System.currentTimeMillis()) {
            QMAttachManager.sharedInstance().updateMailBigAttachExpireTime(this.mAccountId, localMailBigAttach, i);
          }
        }
      }
    }
  }
  
  private void updateMailDataAfterLoadMail()
  {
    boolean bool = isFromRemoteSearch();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if ((this.mailData == null) || (isFromPush()))
    {
      Object localObject = QMMailManager.sharedInstance().getMailInfoByRemoteId(this.mAccountId, this.mRemoteId);
      if (localObject != null)
      {
        this.mailData = new MailUI((Mail)localObject);
        localObject = ((Mail)localObject).getInformation();
        this.mFromFolderId = ((MailInformation)localObject).getFolderId();
        this.mSubject = ((MailInformation)localObject).getSubject();
      }
    }
    else
    {
      if ((localAccount == null) || (!localAccount.isQQMail())) {
        break label203;
      }
      if (this.mailData.getStatus().isGroupMail()) {
        QMMailManager.sharedInstance().updateMailUTC(this.mailData, bool);
      }
      QMMailManager.sharedInstance().updateMailStatus(this.mailData, bool);
    }
    for (;;)
    {
      QMMailManager.sharedInstance().updateMailInfo(this.mailData, bool);
      QMMailManager.sharedInstance().updateMailStatus(this.mailData, bool);
      QMMailManager.sharedInstance().fillMailExtra(this.mailData, bool, false);
      if (this.mailData.getInformation().getUtc() == null) {
        QMMailManager.sharedInstance().updateMailUTC(this.mailData, bool);
      }
      return;
      runOnMainThread(new ReadMailFragment.11(this));
      return;
      label203:
      QMMailManager.sharedInstance().updateMailStatus(this.mailData, bool);
    }
  }
  
  private void updateTipsProcessInfo(String paramString)
  {
    getTips().updateLoadingInfo(paramString);
  }
  
  private void updateTopbarNavigation()
  {
    if (this.mailData == null) {}
    for (;;)
    {
      return;
      MailReference localMailReference = this.mailData.getReference();
      if ((localMailReference == null) || (isFromPush()))
      {
        this.preBtn.setEnabled(false);
        this.nextBtn.setEnabled(false);
        if (isFromAttachFolder())
        {
          this.preBtn.setVisibility(8);
          this.nextBtn.setVisibility(8);
          return;
        }
        this.preBtn.setVisibility(0);
        this.nextBtn.setVisibility(0);
        return;
      }
      if (this.nextBtn != null)
      {
        if (localMailReference.getNext() == null) {
          break label161;
        }
        this.nextBtn.setEnabled(true);
        this.nextBtn.setOnClickListener(new ReadMailFragment.50(this));
      }
      while (this.preBtn != null)
      {
        if (localMailReference.getPrev() == null) {
          break label172;
        }
        this.preBtn.setEnabled(true);
        this.preBtn.setOnClickListener(new ReadMailFragment.51(this));
        return;
        label161:
        this.nextBtn.setEnabled(false);
      }
    }
    label172:
    this.preBtn.setEnabled(false);
  }
  
  private void voteInGroupMail(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {}
    while ((!this.mailData.getStatus().isGroupVote()) || (this.mailData.getVote() == null)) {
      return;
    }
    runOnMainThread(new ReadMailFragment.142(this));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new ReadMailFragment.143(this, paramString));
    localQMCallback.setOnError(new ReadMailFragment.144(this));
    QMMailManager.sharedInstance().voteGroupMail(this.mAccountId, this.mailData, paramString, localQMCallback);
  }
  
  public boolean canDragBack()
  {
    return false;
  }
  
  public void clearEvents()
  {
    unBindHeaderOnClickListener();
    if (this.quickEditText != null)
    {
      this.quickEditText.removeTextChangedListener(this.textWatcher);
      this.quickEditText.setOnFocusChangeListener(null);
    }
    if (this.mWebViewController != null) {
      this.mWebViewController.setOnScrollChanged(null);
    }
    if ((this.header != null) && (this.header.getViewTreeObserver() != null))
    {
      clearTipBarEvent();
      clearIcsBarEvent();
      this.header.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    }
  }
  
  public void copy(String paramString)
  {
    if (!isActivityAlive()) {
      return;
    }
    CommUtils.copyText(paramString);
    showTipsInfo(getResources().getString(2131692323));
  }
  
  public void createNewContact(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  public void dial(String paramString)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("qqbookdial:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Dial");
      return;
    }
    catch (Exception localException)
    {
      paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
    }
    try
    {
      startActivity(paramString);
      DataCollector.logEvent("Event_Content_Recognize_Dial");
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      for (;;)
      {
        QMLog.log(5, "ReadMailFragment", "tel start activity", paramString);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void downloadWeChatPhoneBook()
  {
    if (ChannelDefine.isGooglePlay())
    {
      IntentUtil.intentToMarket(getActivity(), "com.tencent.pb");
      return;
    }
    try
    {
      int i = getActivity().getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
      if ((i == 2) || (i == 3) || (i == 4))
      {
        Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.parse("package:" + "com.android.providers.downloads"));
        QMLog.log(5, "ReadMailFragment", "download app not started");
        Toast.makeText(QMApplicationContext.sharedInstance(), "请启动下载应用", 0).show();
        startActivity(localIntent);
        return;
      }
    }
    catch (Exception localException)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "找不到下载应用", 0).show();
      return;
    }
    Object localObject1 = getActivity();
    getActivity();
    localObject1 = (DownloadManager)((FragmentActivity)localObject1).getSystemService("download");
    Object localObject2 = new File("Download");
    if ((!((File)localObject2).exists()) || (((File)localObject2).isDirectory())) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new DownloadManager.Request(Uri.parse("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100012"));
    ((DownloadManager.Request)localObject2).setDestinationInExternalPublicDir("Download", "phonebook.apk");
    Toast.makeText(QMApplicationContext.sharedInstance(), "正在下载微信电话本...", 0).show();
    if (Build.VERSION.SDK_INT > 10) {
      ((DownloadManager.Request)localObject2).setNotificationVisibility(1);
    }
    long l = ((DownloadManager)localObject1).enqueue((DownloadManager.Request)localObject2);
    localObject2 = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    localObject1 = new ReadMailFragment.151(this, l, (DownloadManager)localObject1);
    getActivity().registerReceiver((BroadcastReceiver)localObject1, (IntentFilter)localObject2);
  }
  
  public String getExistContactName(String paramString)
  {
    try
    {
      Object localObject = getActivity().getContentResolver();
      Uri localUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
      paramString = "replace(data1,'-','') = '" + paramString.replaceAll("\\-", "") + "'";
      paramString = alld.query((ContentResolver)localObject, localUri, new String[] { "display_name", "data1" }, paramString, null, null);
      if (paramString == null) {
        return "";
      }
      if (paramString.getCount() == 0)
      {
        paramString.close();
        return "";
      }
      paramString.moveToFirst();
      localObject = paramString.getString(paramString.getColumnIndex("display_name"));
      paramString.close();
      return localObject;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public void initDataSource()
  {
    this.metrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
    if (this.mailIds == null) {
      this.mailIds = new long[0];
    }
    if (isFromPush())
    {
      this.notifyReadMailBeginTime = new Date().getTime();
      DataCollector.logPerformanceBegin("Performance_Notify_Read_Mail_Time", this.mAccountId, "Performance_Notify_Read_Mail_Time" + this.notifyReadMailBeginTime);
    }
    this.hasRenderCombineTranslateData.set(false);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if (this.mFromPush) {
      DataCollector.logEvent("Event_Notify_Readmail");
    }
    paramView = (ReadMailViewHolder)paramViewHolder;
    this.header = this.readMailView.getHeader();
    if ((paramView != null) && (getActivity() == paramView.webViewController.getActivity()) && (checkAndroidVersion5()))
    {
      this.webContainer = paramView.webContainer;
      this.mWebViewController = paramView.webViewController;
      if ((this.mWebViewController == null) || (this.mWebViewController.getWebView() == null))
      {
        this.mWebViewController = new QMScaleWebViewController(getActivity(), this.webContainer, this.header, null);
        this.mWebViewController.init();
      }
      if (isReadMailChange())
      {
        this.mWebViewController.clearHtml();
        this.header.setVisibility(4);
        hideTipsBar();
        hideIcsBar();
        if ((this.mWebViewController.getWebView() instanceof JBTitleBarWebView2)) {
          ((JBTitleBarWebView2)this.mWebViewController.getWebView()).startScrollToTop();
        }
        this.readMailView.setStatus(1);
        this.readMailView.getAttachBubbleView().setVisibility(8);
        this.isRenderHeader = false;
        runOnMainThread(new ReadMailFragment.36(this), 200L);
        this.readMailView.resetAnimationView();
      }
    }
    for (;;)
    {
      resetMailType();
      initWebView();
      initHeader();
      initToolbar();
      initTopBar();
      this.attachListView = null;
      QMUIKit.expendTouchArea(this.header.findViewById(2131378295), this.webContainer.findViewById(2131379773));
      initIsImageLoad();
      if (this.mailData != null) {
        renderHeader();
      }
      showLoading();
      this.readMailView.setOnQuickReplyListener(new ReadMailFragment.37(this));
      initTranslateIcon();
      return;
      logReadMail();
      this.header.setVisibility(0);
      if ((this.mWebViewController == null) || (this.mWebViewController.getWebView() == null)) {
        break;
      }
      this.mWebViewController.getWebView().scrollTo(0, 0);
      break;
      QMLog.log(4, "ReadMailFragment", "initDom create new Webview");
      sViewHolder = null;
      this.webContainer = this.readMailView.getWebView();
      this.mWebViewController = new QMScaleWebViewController(getActivity(), this.webContainer, this.header, null);
      this.mWebViewController.init();
      this.header.setVisibility(4);
    }
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    getActivity().getWindow().setSoftInputMode(16);
    ReadMailViewHolder localReadMailViewHolder = (ReadMailViewHolder)paramViewHolder;
    if ((paramViewHolder != null) && (localReadMailViewHolder.readMailView != null) && (checkAndroidVersion5())) {}
    for (this.readMailView = localReadMailViewHolder.readMailView;; this.readMailView = new QMReadMailView(getActivity(), false)) {
      return this.readMailView;
    }
  }
  
  public void insertExistContact(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.putExtra("phone", paramString);
    startActivity(localIntent);
  }
  
  public boolean isAttachImage(Attach paramAttach)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))) == AttachType.IMAGE;
  }
  
  public boolean isChineseLanguageSystem()
  {
    if (Locale.getDefault() != null) {}
    for (String str = Locale.getDefault().getLanguage(); (str != null) && (str.equalsIgnoreCase("zh")); str = "") {
      return true;
    }
    QMLog.log(4, "translate", "current system language: " + str);
    return false;
  }
  
  public boolean isImageAttachSingle()
  {
    if (this.mailData == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return true;
      localArrayList1 = this.mailData.getInformation().getImageAttachListNoInlineImg();
      localArrayList2 = this.mailData.getInformation().getImageBigAttachList();
    } while (localArrayList1.size() + localArrayList2.size() <= 1);
    return false;
  }
  
  public boolean isShareToWXWhileList()
  {
    return this.mailData.getStatus().isSystemMail();
  }
  
  public boolean isTelEnable()
  {
    FragmentActivity localFragmentActivity = getActivity();
    getActivity();
    return ((TelephonyManager)localFragmentActivity.getSystemService("phone")).getPhoneType() != 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 1000: 
    case 105: 
    case 1001: 
    case 106: 
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
                  this.attachListViewAdapter.startAttachmentActivityByPos(paramInt1, paramIntent);
                  QMLog.log(4, "ReadMailFragment", "onActivityResult saveAs filepath: " + paramIntent);
                  return;
                } while (paramIntent == null);
                paramInt1 = paramIntent.getIntExtra("position", 0);
                paramIntent = paramIntent.getStringExtra("savePath");
                this.attachListViewAdapter.startAttachmentActivityByPos(paramInt1, paramIntent);
                QMLog.log(4, "ReadMailFragment", "onActivityResult image-save-as save path: " + paramIntent);
                return;
              } while (paramIntent == null);
              paramInt1 = paramIntent.getIntExtra("position", 0);
              paramIntent = paramIntent.getStringExtra("savePath");
              downloadImageAttachSeq(paramIntent, paramInt1, false);
              QMLog.log(4, "ReadMailFragment", "onActivityResult seq download save path: " + paramIntent);
              return;
            } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("saved", false)));
            getTips().showSuccess("保存成功");
            return;
            if (1001 == paramInt2)
            {
              this.isFinish = true;
              popBackStack();
              overridePendingTransition(0, 0);
              return;
            }
          } while (1002 != paramInt2);
          this.hasShowContentMailId = -1L;
          resetRenderMailData();
          this.needReload = true;
          return;
          if (paramInt2 == -1)
          {
            setToolBarBtnUNSelected();
            if (isFromPush())
            {
              popBackStack();
              return;
            }
            boolean bool = paramIntent.getBooleanExtra("createRule", false);
            paramInt1 = paramIntent.getIntExtra("folderId", 0);
            if (bool) {
              afterCreateRule(paramInt1);
            }
            for (;;)
            {
              getTips().showSuccess(2131696006);
              return;
              gotoSiblingMail();
            }
          }
        } while ((paramInt2 == 2) || (paramInt2 == 0));
        getTips().showError(2131696001);
        return;
        runOnMainThread(new ReadMailFragment.46(this, paramIntent));
        return;
      } while ((paramIntent == null) || (this.mWebViewController == null) || (this.mWebViewController.getWebView() == null));
      JSApiUitil.excuteJavaScript(this.mWebViewController.getWebView(), JSApiUitil.handleSelectContacts(paramIntent.getLongArrayExtra("result_select_contact_ids"), this.selectContactsCallbackId));
      return;
    }
    renderAttaches();
  }
  
  @SuppressLint({"NewApi"})
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.mAnimationStep = 2;
    runOnMainThread(new ReadMailFragment.47(this), 1L);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.mAnimationStep < 1) {
      this.mAnimationStep = 1;
    }
  }
  
  public void onBackPressed()
  {
    if ((this.selectTimePopupFrame != null) && (this.selectTimePopupFrame.getVisibility() == 0))
    {
      this.selectTimePopupFrame.onBackPressed();
      return;
    }
    Threads.cancelTask(this.mailIdsTask);
    setFragmentResult(2, null);
    ensureReadMode();
    if ((needDropConvFragment()) && (getBaseFragmentActivity() != null))
    {
      getBaseFragmentActivity().popBackStackInclusive(ConvMailListFragment.class);
      return;
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    pauseObserveScreenShot();
    if (this.readMailView != null)
    {
      QMReadMailView localQMReadMailView1 = this.readMailView;
      QMReadMailView localQMReadMailView2 = this.readMailView;
      localQMReadMailView1.removeTargetBubble(QMReadMailView.BUBBLE_TYPE_SCREEN_SHOT);
      this.readMailView.hideNightModeGuideImmedially();
    }
    if ((this.readMailView.getAttachBubbleView() != null) && (this.readMailView.getAttachBubbleView().isShown())) {
      this.readMailView.getAttachBubbleView().setVisibility(8);
    }
    getActivity().getIntent().putExtra("arg_is_cancel_fail", false);
    if ((this.mailData != null) && (this.mailData.getStatus() != null) && (this.startEnterTimeNew != 0L) && ((System.currentTimeMillis() - this.startEnterTimeNew) / 1000L > 0L))
    {
      if ((this.mailData.getStatus().isAdMail()) || (this.mailData.getStatus().isAdByUser())) {
        KvHelper.detaileventReadMailAdReadTimeNew(new double[] { (System.currentTimeMillis() - this.startEnterTimeNew) / 1000L });
      }
    }
    else {
      return;
    }
    KvHelper.detaileventReadMailNormalReadTimeNew(new double[] { (System.currentTimeMillis() - this.startEnterTimeNew) / 1000L });
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.readMailWatcher, paramBoolean);
    Watchers.bind(this.topWatch, paramBoolean);
    Watchers.bind(this.starWatch, paramBoolean);
    Watchers.bind(this.unreadWatch, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.purgeDeleteWatcher, paramBoolean);
    Watchers.bind(this.tagWatcher, paramBoolean);
    Watchers.bind(this.rejectWatcher, paramBoolean);
    Watchers.bind(this.spamWatcher, paramBoolean);
    Watchers.bind(this.moveWatcher, paramBoolean);
    Watchers.bind(this.mCheckAttachFolderListWatcher, paramBoolean);
    Watchers.bind(this.translateMailWatcher, paramBoolean);
    Watchers.bind(this.mailModifySendUtcWatcher, paramBoolean);
    Watchers.bind(this.addNameListWatcher, paramBoolean);
    Watchers.bind(this.downloadWatcher, paramBoolean);
    Watchers.bind(this.renderAttachWatcher, paramBoolean);
    Watchers.bind(this.updateFtnExpireTimeWatcher, paramBoolean);
    LoginManager.shareInstance().bindLoginListener(this.loginWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("actionsavefilesucc", this.observerSaveFileSuccess);
      QMNotification.registNotification("actionsavefileerror", this.observerSaveFileError);
      QMNotification.registNotification("ftnfailexpired", this.observerFtnFailWithExpireTime);
      QMNotification.registNotification("ftn_fail_exceed_limit", this.observerFtnFailExceedLimit);
      this.screenshotWatcher = new ScreenShotServiceClient(this.mScreenshotCallback);
      this.screenshotWatcher.startWatching();
      return;
    }
    QMNotification.unregistNotification("actionsavefilesucc", this.observerSaveFileSuccess);
    QMNotification.unregistNotification("actionsavefileerror", this.observerSaveFileError);
    QMNotification.unregistNotification("ftnfailexpired", this.observerFtnFailWithExpireTime);
    QMNotification.unregistNotification("ftn_fail_exceed_limit", this.observerFtnFailExceedLimit);
    this.screenshotWatcher.stopWatching();
  }
  
  public void onButtonBackClick()
  {
    setFragmentResult(2, null);
    if ((needDropConvFragment()) && (getBaseFragmentActivity() != null))
    {
      getBaseFragmentActivity().popBackStackInclusive(ConvMailListFragment.class);
      return;
    }
    super.onButtonBackClick();
  }
  
  public QMBaseFragment.ViewHolder onCacheView()
  {
    if (sViewHolder != null)
    {
      if (sViewHolder.webViewController.getActivity() != getActivity())
      {
        clearViewHolder();
        return null;
      }
      sViewHolder.activeFragment = this;
    }
    return sViewHolder;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (sViewHolder != null) {
      sViewHolder.activeFragment = this;
    }
    TimReportManager.reportClickEvent(getActivity(), "0X8008903", 0, 0, 0, 0, 0, "", "", "", "");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.ableFlingToBack = WebviewUtilities.isOnLeftEdge(this.mWebViewController.getWebView());
    }
    Threads.cancelTask(this.mailIdsTask);
    return this.ableFlingToBack;
  }
  
  public void onForeground()
  {
    super.onForeground();
    resumeObserveScreenShot();
    this.startEnterTimeNew = System.currentTimeMillis();
  }
  
  public Object onLastFragmentFinish()
  {
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(this.mFromFolderId);
    Object localObject1 = AccountManager.shareInstance().getAccountList();
    int i = ((AccountList)localObject1).size();
    Account localAccount = ((AccountList)localObject1).getAccountById(this.mAccountId);
    Object localObject3 = new StringBuilder().append("onLastFragmentFinish, accountSize: ").append(i).append(", account: ");
    if (localAccount == null) {}
    for (localObject1 = null;; localObject1 = localAccount.getEmail())
    {
      QMLog.log(5, "ReadMailFragment", (String)localObject1 + ", folder: " + localQMFolder);
      if ((this.mailData == null) || (this.mailData.getStatus() == null) || (!this.mailData.getStatus().isConversation()) || (this.mailData.getInformation() == null)) {
        break;
      }
      QMLog.log(5, "ReadMailFragment", "onLastFragmentFinish, go to ConvMailListFragment");
      return new ConvMailListFragment(this.mAccountId, this.mFromFolderId, this.mailData.getInformation().getConvType(), this.parentListIds);
    }
    int j;
    if ((localQMFolder != null) && (localQMFolder.getType() == 15) && (QMSettingManager.sharedInstance().getAggregateSubscribeMail()))
    {
      j = QMFolderManager.sharedInstance().getInboxFolderId(this.mAccountId);
      localObject3 = QMFolderManager.sharedInstance().getFolder(j);
      localObject1 = ((QMFolder)localObject3).getName();
      if ((i <= 1) || (localAccount == null)) {
        break label455;
      }
      localObject1 = localAccount.getName() + "的" + ((QMFolder)localObject3).getName();
    }
    label452:
    label455:
    for (;;)
    {
      try
      {
        localObject1 = new MailListFragment(this.mAccountId, j, (String)localObject1);
        return localObject1;
      }
      catch (MailListFragment.NullFolderException localNullFolderException)
      {
        QMLog.log(5, "ReadMailFragment", "onLastFragmentFinish, go to Inbox failed", localNullFolderException);
      }
      if (FolderLockDialog.isFolderLock(this.mFromFolderId)) {
        return new FolderListFragment(this.mAccountId);
      }
      if (localQMFolder != null) {}
      for (;;)
      {
        try
        {
          localObject2 = localQMFolder.getName();
          if ((localQMFolder == null) || (localQMFolder.getType() != 1) || (i <= 1) || (localAccount == null)) {
            break label452;
          }
          localObject2 = localAccount.getName() + "的" + localQMFolder.getName();
          localObject2 = new MailListFragment(this.mAccountId, this.mFromFolderId, (String)localObject2);
          return localObject2;
        }
        catch (Exception localException)
        {
          Object localObject2;
          QMLog.log(5, "ReadMailFragment", "onLastFragmentFinish, go to " + localQMFolder + " failed", localException);
          return null;
        }
        localObject2 = null;
      }
    }
  }
  
  public void onRelease()
  {
    if (sViewHolder != null)
    {
      clearEvents();
      if (this.readMailView != null)
      {
        this.readMailView.clearEvents();
        this.readMailView = null;
      }
      this.quickReplyView = null;
      this.detailView = null;
      this.webContainer = null;
      synchronized (this.mWebViewControllerLocker)
      {
        if (this.mWebViewController != null)
        {
          this.mWebViewController.setToolBar(null);
          this.mWebViewController = null;
        }
        if (this.quickEditText == null) {}
      }
    }
    synchronized (this.quickEditTextLock)
    {
      for (;;)
      {
        this.quickEditText = null;
        this.titleView = null;
        this.tagView = null;
        if (this.nextBtn != null)
        {
          this.nextBtn.setOnClickListener(null);
          this.nextBtn = null;
        }
        if (this.preBtn != null)
        {
          this.preBtn.setOnClickListener(null);
          this.preBtn = null;
        }
        this.quickReplyView = null;
        this.quickEditText = null;
        this.searchMailIds = null;
        resetRenderMailData();
        if (this.screenshotWatcher != null) {
          this.screenshotWatcher.release();
        }
        return;
        localObject2 = finally;
        throw localObject2;
        synchronized (this.mWebViewControllerLocker)
        {
          destroyDom(this.readMailView, this.webContainer, this.mWebViewController);
        }
      }
    }
  }
  
  public void onSaveViewHolder()
  {
    if (this.mWebViewController != null) {
      this.mWebViewController.clearResourceLoader();
    }
    if (sViewHolder == null)
    {
      sViewHolder = new ReadMailViewHolder(null);
      sViewHolder.readMailView = this.readMailView;
      sViewHolder.webContainer = this.webContainer;
      sViewHolder.webViewController = this.mWebViewController;
      sViewHolder.lowMemoryListener = new ViewHolderRelease(null);
      QMApplicationContext.sharedInstance().addLowMemoryListener(sViewHolder.lowMemoryListener);
    }
    sViewHolder.mailId = this.id;
    sViewHolder.folderId = this.mFromFolderId;
    sViewHolder.needRender = this.needRender;
    sViewHolder.activeFragment = null;
  }
  
  public void openUrl(String paramString)
  {
    MailStatus localMailStatus = null;
    if (!isActivityAlive()) {
      return;
    }
    DataCollector.logEvent("Event_Content_Recognize_Open_Url");
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    Object localObject2 = QMSettingManager.sharedInstance().getMiscCheckLink();
    Account localAccount;
    if ((localObject2 != null) && ((((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://"))) && (!WebviewUtilities.isQQMailDomainLink(paramString))) {
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    }
    for (;;)
    {
      try
      {
        Object localObject1 = (QQMailAccount)localAccount;
        if (localObject1 == null) {
          break label734;
        }
        str2 = ((QQMailAccount)localObject1).getSid();
        localObject1 = str2;
        if (str2 == null) {
          localObject1 = "";
        }
        if (this.mailData == null)
        {
          localMailInformation = null;
          if (this.mailData != null) {
            continue;
          }
          localObject2 = localStringBuilder.append((String)localObject2).append(Uri.encode(paramString)).append("&mailid=");
          if (localMailInformation == null) {
            continue;
          }
          str2 = localMailInformation.getRemoteId();
          localObject2 = ((StringBuilder)localObject2).append(str2).append("&sid=").append((String)localObject1).append("&os=android").append("&version=").append(AppConfig.getCodeVersion()).append("&from=");
          if ((localMailInformation == null) || (localMailInformation.getFrom() == null)) {
            continue;
          }
          str2 = Uri.encode(localMailInformation.getFrom().getAddress());
          localObject2 = ((StringBuilder)localObject2).append(str2).append("&from_nick=");
          if ((localMailInformation == null) || (localMailInformation.getFrom() == null)) {
            continue;
          }
          str2 = Uri.encode(localMailInformation.getFrom().getNick());
          localObject2 = ((StringBuilder)localObject2).append(str2).append("&to=");
          if (!((String)localObject1).equals("")) {
            continue;
          }
          str2 = Uri.encode(localAccount.getEmail());
          localObject2 = ((StringBuilder)localObject2).append(str2).append("&spam=");
          if (localMailStatus == null) {
            continue;
          }
          if (localMailStatus.getCheat() > 0) {
            continue;
          }
          str2 = "0";
          ((StringBuilder)localObject2).append(str2);
          if (localMailInformation == null) {
            continue;
          }
          str2 = Uri.encode(localMailInformation.getRemoteId());
          localHashMap.put("mailid", str2);
          localHashMap.put("sid", Uri.encode((String)localObject1));
          if ((localMailInformation == null) || (localMailInformation.getFrom() == null)) {
            continue;
          }
          str2 = Uri.encode(localMailInformation.getFrom().getAddress());
          localHashMap.put("from", str2);
          if ((localMailInformation == null) || (localMailInformation.getFrom() == null)) {
            continue;
          }
          str2 = Uri.encode(localMailInformation.getFrom().getNick());
          localHashMap.put("from_nick", str2);
          if (!((String)localObject1).equals("")) {
            continue;
          }
          localObject1 = Uri.encode(localAccount.getEmail());
          localHashMap.put("to", localObject1);
          if (localMailStatus == null) {
            continue;
          }
          if (localMailStatus.getCheat() > 0) {
            continue;
          }
          localObject1 = "0";
          localHashMap.put("spam", localObject1);
          if (paramString == null) {
            continue;
          }
          paramString = Uri.encode(paramString);
          localHashMap.put("src_url", paramString);
          if ((!localStringBuilder.toString().startsWith("http://qumas.mail.qq.com/cgi-bin/uma_read_card")) && (!localStringBuilder.toString().startsWith("https://qumas.mail.qq.com/cgi-bin/uma_read_card"))) {
            break label711;
          }
          paramString = CardWebViewExplorer.createIntent(localStringBuilder.toString());
          startActivity(paramString);
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "ReadMailFragment", localException.toString());
        str1 = null;
        continue;
        MailInformation localMailInformation = this.mailData.getInformation();
        continue;
        localMailStatus = this.mailData.getStatus();
        continue;
        String str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "1";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str2 = "";
        continue;
        str1 = "";
        continue;
        str1 = "1";
        continue;
        str1 = "";
        continue;
        paramString = "";
        continue;
      }
      localStringBuilder.append(paramString);
      continue;
      label711:
      paramString = WebViewExplorer.createIntent(localStringBuilder.toString(), "", this.mAccountId, true, localHashMap, true);
      continue;
      label734:
      String str1 = "";
    }
  }
  
  public void pauseObserveScreenShot()
  {
    this.isScreenshotBubbleShow = false;
  }
  
  public void popupScreenShotBubble(String paramString)
  {
    if (!this.isScreenshotBubbleShow) {
      return;
    }
    Threads.runOnMainThread(new ReadMailFragment.8(this, paramString));
  }
  
  public void readMailFromRemoteId(int paramInt, String paramString)
  {
    if (this.isDoneReadMailFromId != null) {
      this.isDoneReadMailFromId.cancel(true);
    }
    this.isDoneReadMailFromId = Threads.submitTask(new ReadMailFragment.2(this, paramInt, paramString));
  }
  
  public int refreshData()
  {
    if (this.isFinish)
    {
      this.isFinish = false;
      popBackStack();
    }
    if (this.needReload)
    {
      QMLog.log(4, "ReadMailFragment", "RefreshData reload true");
      refreshData(true);
      this.needReload = false;
    }
    for (;;)
    {
      this.lastOpenFileIndex = -1;
      return 0;
      QMLog.log(4, "ReadMailFragment", "RefreshData normal: " + isMailContentNull(true));
      if (isMailContentNull(true)) {
        refreshData(true);
      } else {
        refreshData(false);
      }
    }
  }
  
  protected void refreshData(boolean paramBoolean)
  {
    boolean bool = false;
    int j = 0;
    if (isFromRemoteSearch())
    {
      i = 128;
      this.mailFlag = i;
      if ((this.isDoneReadingMailExtra == null) && (this.isDoneReadMailFromId == null)) {}
    }
    else
    {
      try
      {
        if (this.isDoneReadMailFromId == null) {
          break label218;
        }
        this.isDoneReadMailFromId.get();
        this.isDoneReadMailFromId = null;
        label57:
        if ((this.mailData == null) || (QMMailManager.sharedInstance().isPopMailDeleted(this.mAccountId, this.id)) || (((this.mailData.getStatus() == null) || (this.mailData.getStatus().isLoaded())) && (!isMailContentNull(true)))) {
          break label258;
        }
        QMLog.log(4, "ReadMailFragment", "try load mail again:" + this.mailData.getInformation().getRemoteId());
        Threads.runInBackground(new ReadMailFragment.39(this));
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          try
          {
            Account localAccount;
            localInterruptedException.printStackTrace();
            readMailData(paramBoolean);
            continue;
          }
          finally
          {
            i = 1;
            continue;
          }
          if ((this.mAccountId != 0) && (!StringUtils.isBlank(this.mRemoteId)) && (AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId).isQQMail())) {
            QMMailManager.sharedInstance().loadQQMail(this.mAccountId, this.mRemoteId, null);
          }
        }
      }
      catch (ExecutionException localExecutionException)
      {
        for (;;)
        {
          label158:
          localExecutionException.printStackTrace();
          readMailData(paramBoolean);
        }
      }
      finally
      {
        i = j;
      }
      if (this.mailData != null) {
        break label503;
      }
      if (isFromPush())
      {
        this.mailData = new MailUI();
        localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
        if (localAccount != null) {
          break label351;
        }
        QMLog.log(5, "ReadMailFragment", "account is null");
      }
    }
    label218:
    label351:
    label503:
    do
    {
      return;
      i = 0;
      break;
      if (this.isDoneReadingMailExtra == null) {
        break label57;
      }
      this.isDoneReadingMailExtra.get();
      this.isDoneReadingMailExtra = null;
      break label57;
      if (i != 0) {
        readMailData(paramBoolean);
      }
      throw localObject1;
      readMailData(paramBoolean);
      break label158;
      Object localObject3 = new MailInformation();
      ((MailInformation)localObject3).setAccountId(this.mAccountId);
      ((MailInformation)localObject3).setSubject(this.mSubject);
      ((MailInformation)localObject3).setFolderId(this.mFromFolderId);
      ((MailInformation)localObject3).setRemoteId(this.mRemoteId);
      ((MailInformation)localObject3).setId(this.id);
      ((MailInformation)localObject3).setFrom(new MailContact(this.mSenderNick, this.mSenderEmail));
      this.mailData.setInformation((MailInformation)localObject3);
      localObject3 = new MailStatus();
      ((MailStatus)localObject3).setLocalMail(false);
      ((MailStatus)localObject3).setLoaded(false);
      ((MailStatus)localObject3).setConversation(false);
      paramBoolean = bool;
      if (!localObject1.isQQMail()) {
        paramBoolean = true;
      }
      ((MailStatus)localObject3).setProtocolMail(paramBoolean);
      this.mailData.setStatus((MailStatus)localObject3);
      QMMailManager.sharedInstance().loadRemoteMail(this.mailData, 256);
      return;
      if (this.mailData.getInformation() == null)
      {
        MailInformation localMailInformation = new MailInformation();
        localMailInformation.setAccountId(this.mAccountId);
        localMailInformation.setSubject(this.mSubject);
        localMailInformation.setFolderId(this.mFromFolderId);
        localMailInformation.setRemoteId(this.mRemoteId);
        localMailInformation.setId(this.id);
        localMailInformation.setFrom(new MailContact(this.mSenderNick, this.mSenderEmail));
        this.mailData.setInformation(localMailInformation);
      }
    } while (reloadAggregateMailChild());
    label258:
    this.mAccountId = this.mailData.getInformation().getAccountId();
  }
  
  public void render(int paramInt)
  {
    updateTopbarNavigation();
    if ((!isAnimationInto()) || (this.mAnimationStep == 2))
    {
      this.mAnimationStep = 2;
      if ((sViewHolder == null) || (sViewHolder.mailId != this.id) || (sViewHolder.folderId != this.mFromFolderId) || (this.mailData == null) || (this.mailData.getStatus() == null) || (!this.mailData.getStatus().isLoaded()) || (!sViewHolder.webViewController.isHTMLLoaded()) || (sViewHolder.webViewController.isScale()) || (sViewHolder.needRender)) {
        break label368;
      }
      this.readMailView.setStatus(1);
      renderAttaches();
      renderHeader();
      initQuickReply();
      autoUnreadMail();
      if (this.attachListView != null) {
        ((View)this.attachListView.getParent()).setVisibility(0);
      }
      setTipBarEvent();
      setIcsBarEvent();
      setSendUtcBarEvent();
      if (isShowImage()) {
        this.mWebViewController.downloadResource();
      }
      if (isShowPopDelete()) {
        showMailDeleted();
      }
      if ((sViewHolder != null) && (sViewHolder.webViewController != null)) {
        sViewHolder.webViewController.resetIsScale();
      }
    }
    if ((!this.isUpdateAttachFolder) && (isQQMail()) && (hasUndefineAttachFavorite()))
    {
      Threads.runInBackground(new ReadMailFragment.43(this));
      this.isUpdateAttachFolder = true;
    }
    Object localObject = this.readMailView.getAttachBubbleView().getTag(2131363628);
    if ((SendMailInterAppsManager.getInstance().hasFile()) && (this.readMailView.getStatus() == 1) && (this.readMailView.getStatus() == 4) && ((localObject == null) || (((Boolean)localObject).booleanValue()))) {
      this.readMailView.getAttachBubbleView().setVisibility(0);
    }
    if ((this.readMailView.getAttachBubbleView().isShown()) && (!SendMailInterAppsManager.getInstance().hasFile())) {
      this.readMailView.getAttachBubbleView().setVisibility(8);
    }
    return;
    label368:
    if (this.mailData != null) {
      if (isShowPopDelete()) {
        showMailDeleted();
      }
    }
    for (;;)
    {
      renderWithContent();
      if (!isFromPush()) {
        break;
      }
      runOnMainThread(new ReadMailFragment.42(this), 200L);
      break;
      if ((isMailContentNull(true)) && (this.readMailView != null) && (this.readMailView.getStatus() != 2))
      {
        clearWebViewContent();
        this.readMailView.setStatus(0);
        continue;
        if (this.id == 0L) {
          showErrorView();
        }
      }
    }
  }
  
  public void resumeObserveScreenShot()
  {
    this.isScreenshotBubbleShow = true;
  }
  
  public void reuseMailData(Mail paramMail)
  {
    if (this.isDoneReadingMailExtra != null) {
      this.isDoneReadingMailExtra.cancel(true);
    }
    if (isFromSearch()) {
      this.mailData = new SearchMailUI(paramMail, this.mParentMailId, this.searchMailIds, this.mailIdsTask);
    }
    for (;;)
    {
      if (this.mailData.getInformation() == null)
      {
        paramMail = new MailInformation();
        paramMail.setAccountId(this.mAccountId);
        paramMail.setSubject(this.mSubject);
        paramMail.setFolderId(this.mFromFolderId);
        paramMail.setRemoteId(this.mRemoteId);
        paramMail.setId(this.id);
        paramMail.setFrom(new MailContact(this.mSenderNick, this.mSenderEmail));
        this.mailData.setInformation(paramMail);
      }
      this.isDoneReadingMailExtra = Threads.submitTask(new ReadMailFragment.1(this));
      return;
      this.mailData = new MailUI(paramMail, this.aggregateType, this.mParentMailId);
      this.mailData.setTask(this.mailIdsTask);
    }
  }
  
  public void shareMailToWX(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    if (WXEntryActivity.canShareToWX(QMApplicationContext.sharedInstance()))
    {
      WXWebpageObject localWXWebpageObject = new WXWebpageObject();
      localWXWebpageObject.webpageUrl = paramString1;
      paramString1 = new WXMediaMessage(localWXWebpageObject);
      paramString1.title = paramString2;
      paramString1.description = paramString3;
      paramString2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString4);
      if (paramString2 == null) {
        break label78;
      }
      paramString1.thumbData = WXEntryActivity.bmpToByteArray(paramString2, false);
    }
    for (;;)
    {
      WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), paramInt1, paramString1, paramInt2);
      return;
      label78:
      paramString2 = new DownloadInfo();
      paramString2.setUrl(paramString4);
      paramString2.setImageDownloadListener(new ReadMailFragment.152(this, paramString1));
      ImageDownloadManager.shareInstance().fetchImage(paramString2);
    }
  }
  
  public void showCalendarDialog(String paramString, Long paramLong)
  {
    if (!isActivityAlive()) {
      return;
    }
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.149(this, paramLong, paramString));
    if (QMSettingManager.sharedInstance().getCalendarDisplay())
    {
      if (!this.mailData.getStatus().isAttrIsCreditMail()) {
        break label135;
      }
      localBottomListSheetBuilder.addItem(getString(2131718775));
    }
    for (;;)
    {
      localBottomListSheetBuilder.addItem(getString(2131691484));
      localBottomListSheetBuilder.addItem(getString(2131692324));
      localBottomListSheetBuilder.setTitle(paramString + " " + getResources().getString(2131695684));
      localBottomListSheetBuilder.build().show();
      return;
      label135:
      localBottomListSheetBuilder.addItem(getString(2131696292));
    }
  }
  
  public void showMailToDialog(String paramString)
  {
    if (!isActivityAlive()) {
      return;
    }
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.148(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131721918));
    localBottomListSheetBuilder.addItem(getString(2131692324));
    if (!isStranger(paramString)) {
      localBottomListSheetBuilder.addItem(getString(2131691485));
    }
    for (;;)
    {
      localBottomListSheetBuilder.setTitle(paramString);
      localBottomListSheetBuilder.build().show();
      return;
      localBottomListSheetBuilder.addItem(getString(2131692342));
    }
  }
  
  public void showTelDialog(String paramString)
  {
    if (!isActivityAlive()) {
      return;
    }
    String str = getExistContactName(paramString);
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.146(this, paramString, str));
    if (isTelEnable()) {
      localBottomListSheetBuilder.addItem(getString(2131692640));
    }
    if (ContactsHelper.filterPhoneNum(paramString) != null)
    {
      localBottomListSheetBuilder.addItem(getString(2131720364));
      localBottomListSheetBuilder.addItem(getString(2131721918));
    }
    if (str.equals(""))
    {
      localBottomListSheetBuilder.addItem(getString(2131689836));
      localBottomListSheetBuilder.addItem(getString(2131692324));
      if (!DeviceUtil.isWeChatPhoneBookInstalled()) {
        localBottomListSheetBuilder.addItem(getString(2131721643));
      }
      str = getExistContactName(paramString);
      if (!str.equals("")) {
        break label214;
      }
    }
    label214:
    for (paramString = paramString + " " + getResources().getString(2131695686);; paramString = str + "(" + paramString + ") " + getResources().getString(2131693280))
    {
      localBottomListSheetBuilder.setTitle(paramString);
      localBottomListSheetBuilder.build().show();
      return;
      localBottomListSheetBuilder.addItem(getString(2131693004));
      break;
    }
  }
  
  public void showUrlDialog(String paramString)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.150(this, paramString));
    localBottomListSheetBuilder.addItem(getString(2131696621));
    localBottomListSheetBuilder.addItem(getString(2131692324));
    localBottomListSheetBuilder.setTitle(Uri.decode(paramString));
    localBottomListSheetBuilder.build().show();
  }
  
  public void sms(String paramString)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("qqbooksms:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Has_Wx_Book_Sms");
      return;
    }
    catch (Exception localException)
    {
      startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
      DataCollector.logEvent("Event_Content_Recognize_Sms");
    }
  }
  
  class AttachListViewAdapter
  {
    private boolean ableClick;
    private boolean ableLongClick;
    private ArrayList<Object> attachList = null;
    private View.OnClickListener attachOptOnClickListener = new ReadMailFragment.AttachListViewAdapter.9(this);
    private View.OnLongClickListener attachOptOnLongClickListener = new ReadMailFragment.AttachListViewAdapter.10(this);
    private ArrayList<Object> bigAttachList = null;
    private ArrayList<Object> editAttachList = null;
    private boolean hasLongClick;
    private View.OnClickListener itemOnClickListener = new ReadMailFragment.AttachListViewAdapter.12(this);
    private View.OnLongClickListener itemOnLongClickListener = new ReadMailFragment.AttachListViewAdapter.11(this);
    private View.OnTouchListener itemOnTouchListener = new ReadMailFragment.AttachListViewAdapter.13(this);
    private HashMap<Integer, Integer> mAttachRelativePosition = new HashMap();
    
    public AttachListViewAdapter() {}
    
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
      Object localObject = ReadMailFragment.this.mailData.getInformation().getAttachListNoInlineImg();
      ArrayList localArrayList = ReadMailFragment.this.mailData.getInformation().getBigAttachList();
      int k = 0;
      int i = 0;
      int j = 0;
      if (k < ((ArrayList)localObject).size())
      {
        Attach localAttach = (Attach)((ArrayList)localObject).get(k);
        if ((!ReadMailFragment.this.isAttachImage(localAttach.getName())) || (FileUtil.isFileTypeTiff(localAttach.getName()))) {
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
      if (j < localArrayList.size())
      {
        localObject = (Attach)localArrayList.get(j);
        if ((!ReadMailFragment.this.isAttachImage(((Attach)localObject).getName())) || (FileUtil.isFileTypeTiff(((Attach)localObject).getName()))) {
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
      label26:
      View localView1;
      label61:
      DownloadThumbProgressBar localDownloadThumbProgressBar;
      View localView2;
      if (this.attachList == null)
      {
        i = 0;
        if (this.bigAttachList != null) {
          break label159;
        }
        j = 0;
        if (this.editAttachList != null) {
          break label171;
        }
        localView1 = LayoutInflater.from(ReadMailFragment.this.getActivity()).inflate(2131562936, paramViewGroup, false);
        if (getCount() != 1) {
          break label182;
        }
        QMUIHelper.setBackgroundResource(localView1, 2130850543);
        localDownloadThumbProgressBar = (DownloadThumbProgressBar)localView1.findViewById(2131373659);
        localView2 = localView1.findViewById(2131366208);
        localDownloadThumbProgressBar.setVisibility(0);
        localView2.setVisibility(8);
        if (paramInt >= i) {
          break label216;
        }
        paramViewGroup = (Attach)this.attachList.get(paramInt);
        renderAttach(localView1, paramViewGroup);
        i = 0;
      }
      for (;;)
      {
        if ((!(paramViewGroup instanceof MailBigAttach)) || (!ReadMailFragment.this.isBigAttachExpireTime(paramInt))) {
          break label292;
        }
        localView1.setEnabled(false);
        return localView1;
        i = this.attachList.size();
        break;
        label159:
        j = this.bigAttachList.size();
        break label19;
        label171:
        this.editAttachList.size();
        break label26;
        label182:
        if (getCount() <= 1) {
          break label61;
        }
        if (paramInt == 0)
        {
          QMUIHelper.setBackgroundResource(localView1, 2130850544);
          break label61;
        }
        QMUIHelper.setBackgroundResource(localView1, 2130850541);
        break label61;
        label216:
        if (paramInt < i + j)
        {
          paramViewGroup = (MailBigAttach)this.bigAttachList.get(paramInt - i);
          renderBigAttach(localView1, paramViewGroup);
          i = 0;
        }
        else
        {
          paramViewGroup = (MailEditAttach)this.editAttachList.get(paramInt - i - j);
          localDownloadThumbProgressBar.setVisibility(8);
          localView2.setVisibility(0);
          renderEditAttach(localView1, paramViewGroup);
          i = 1;
        }
      }
      label292:
      localView1.setTag(Integer.valueOf(paramInt));
      if (i == 0)
      {
        if (!paramViewGroup.isExist()) {
          break label412;
        }
        localDownloadThumbProgressBar.setState(3);
      }
      for (;;)
      {
        localDownloadThumbProgressBar.setTag(Integer.valueOf(paramInt));
        paramViewGroup = localView1.findViewById(2131363050);
        paramViewGroup.setOnClickListener(this.attachOptOnClickListener);
        paramViewGroup.setOnLongClickListener(this.attachOptOnLongClickListener);
        paramViewGroup.setOnTouchListener(this.itemOnTouchListener);
        paramViewGroup.setTag(Integer.valueOf(paramInt));
        paramViewGroup.setContentDescription(ReadMailFragment.this.getString(2131720837));
        localView1.setOnClickListener(this.itemOnClickListener);
        localView1.setOnLongClickListener(this.itemOnLongClickListener);
        localView1.setOnTouchListener(this.itemOnTouchListener);
        return localView1;
        label412:
        paramViewGroup = ReadMailFragment.this.getDownloadInfo(paramViewGroup);
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
                break label503;
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
          label503:
          localDownloadThumbProgressBar.setState(0);
        }
      }
    }
    
    private void renderAttach(View paramView, Attach paramAttach)
    {
      Object localObject1 = AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName()))).name().toLowerCase(Locale.getDefault());
      ImageView localImageView = (ImageView)paramView.findViewById(2131363052);
      Object localObject2;
      if ((((String)localObject1).equals("image")) && (!ReadMailFragment.this.mailData.getStatus().isProtocolMail()) && (!ReadMailFragment.this.mailData.getStatus().isGroupMail()) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
      {
        localObject2 = QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + paramAttach.getPreview().getIcon();
        int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject2);
        if ((i == 2) || (i == 1))
        {
          localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject2);
          if (localObject2 != null) {
            localImageView.setImageDrawable(new BitmapDrawable(ReadMailFragment.this.getResources(), (Bitmap)localObject2));
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
        ((DownloadInfo)localObject1).setAccountId(ReadMailFragment.this.mAccountId);
        ((DownloadInfo)localObject1).setUrl((String)localObject2);
        ((DownloadInfo)localObject1).setImageDownloadListener(new ReadMailFragment.AttachListViewAdapter.14(this, (String)localObject2, localImageView));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject1);
        continue;
        if ((((String)localObject1).equals("image")) && (ReadMailFragment.this.mailData.getStatus().isProtocolMail()) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
        {
          setThumbByType(localImageView, (String)localObject1);
          if (paramAttach.getPreview() != null)
          {
            localObject1 = paramAttach.getPreview().getMyDisk();
            if (!StringExtention.isNullOrEmpty((String)localObject1)) {
              ImageDownloadManager.shareInstance().getProtocolImageBitmap((String)localObject1, new ReadMailFragment.AttachListViewAdapter.15(this, localImageView));
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
      int n = getEditAttachListCount();
      int i1;
      int i;
      if (k > 0)
      {
        i1 = this.attachList.size();
        i = 0;
        while (i < i1)
        {
          paramLinearLayout.addView(getView(i, paramLinearLayout));
          i += 1;
        }
      }
      if (m > 0)
      {
        i1 = this.bigAttachList.size();
        i = 0;
        while (i < i1)
        {
          paramLinearLayout.addView(getView(i + k, paramLinearLayout));
          i += 1;
        }
      }
      if (n > 0)
      {
        n = this.editAttachList.size();
        i = j;
        while (i < n)
        {
          paramLinearLayout.addView(getView(i + k + m, paramLinearLayout));
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
        localObject = ReadMailFragment.this.getString(2131690873);
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
        ((TextView)localObject).setTextColor(ReadMailFragment.this.getResources().getColor(2131167539));
        if (i == 0) {
          break label453;
        }
        paramView = paramView + ReadMailFragment.this.getString(2131718580);
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
          localObject = ReadMailFragment.this.getString(2131693301);
          break;
          i = 0;
          break label208;
          if (i == 0) {
            break label453;
          }
          paramView = paramView + ReadMailFragment.this.getString(2131718579);
          break label296;
          if (paramMailBigAttach.isBizNetDiskAttach())
          {
            ((TextView)localObject).setText(ReadMailFragment.this.getString(2131694055));
            ((TextView)localObject).setVisibility(0);
            ((TextView)localObject).setTextColor(ReadMailFragment.this.getResources().getColor(2131167531));
            return;
          }
        } while (l != -2L);
        ((TextView)localObject).setText("已过期");
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setTextColor(ReadMailFragment.this.getResources().getColor(2131167539));
        return;
      }
    }
    
    private void renderEditAttach(View paramView, MailEditAttach paramMailEditAttach)
    {
      String str = paramMailEditAttach.getType();
      ((ImageView)paramView.findViewById(2131363052)).setImageResource(ImageResourceUtil.getImageResource(str, ImageResourceUtil.IMAGE_SIZE_58));
      ((TextView)paramView.findViewById(2131372190)).setText(paramMailEditAttach.getName() + QMUIKit.ELLIPSIZE_FIXED);
      ((TextView)paramView.findViewById(2131378460)).setText(paramMailEditAttach.getSize());
    }
    
    private void setThumbByType(ImageView paramImageView, String paramString)
    {
      paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
    }
    
    private void startAttachPreview(Attach paramAttach, int paramInt1, int paramInt2)
    {
      QMLog.log(4, "ReadMailFragment", "startAttachPreview attach " + paramAttach.getName() + " path: " + paramAttach.getPreview().getMyDisk());
      boolean bool1 = AttachToolbox.isAttachEml(paramAttach.getName());
      boolean bool2 = AttachToolbox.isAttachICS(paramAttach.getName());
      Object localObject;
      if ((bool1) && (paramAttach.isExist()))
      {
        localObject = QMReadEmlActivity.createIntentFromEml(ReadMailFragment.this.mAccountId, paramAttach, true, false);
        ReadMailFragment.this.startActivity((Intent)localObject);
        ReadMailFragment.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        if ((paramAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ReadMailFragment", "eml", "" });
          return;
        }
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ReadMailFragment", "eml", "" });
        return;
      }
      if ((bool2) && (paramAttach.isExist()))
      {
        localObject = new ReadIcsFragment(paramAttach.getPreview().getMyDisk());
        ReadMailFragment.this.startFragment((BaseFragment)localObject);
        ReadMailFragment.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        if ((paramAttach instanceof MailBigAttach))
        {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ReadMailFragment", "ics", "" });
          return;
        }
        OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "ReadMailFragment", "ics", "" });
        return;
      }
      if ((paramInt1 == 0) && (paramAttach.isExist()))
      {
        paramAttach = WebViewPreviewActivity.createIntent(ReadMailFragment.this.getActivity(), paramAttach, paramAttach.getFolderId(), true);
        ReadMailFragment.this.startActivity(paramAttach);
        return;
      }
      paramInt1 = IntentUtil.OPEN_FILE_NORMAL;
      if ((paramAttach instanceof MailBigAttach)) {}
      for (paramInt1 = IntentUtil.openFile(ReadMailFragment.this.getActivity(), paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailBigAttachPreview); paramInt1 == IntentUtil.OPEN_FILE_FAIL; paramInt1 = IntentUtil.openFile(ReadMailFragment.this.getActivity(), paramAttach.getPreview().getMyDisk(), FileUtil.getFileNameSuffix(paramAttach.getName()), AttachPreviewType.MailNormalAttachPreview))
      {
        ReadMailFragment.this.showCanNotPreviewDialog(paramInt2);
        return;
      }
      ReadMailFragment.this.getActivity().overridePendingTransition(2130772422, 2130772419);
    }
    
    private void startImageAttachPreview(int paramInt)
    {
      QMLog.log(4, "ReadMailFragment", "startImageAttachPreview of pos " + paramInt);
      Object localObject3 = ReadMailFragment.this.mailData.getInformation().getImageAttachListNoInlineImg();
      Object localObject2 = ReadMailFragment.this.mailData.getInformation().getImageBigAttachList();
      Object localObject1 = new ArrayList();
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Attach localAttach = (Attach)((Iterator)localObject3).next();
        if (!ReadMailFragment.this.isAttachOverSize(localAttach)) {
          ((List)localObject1).add(localAttach);
        }
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((Attach)((Iterator)localObject2).next());
      }
      if (((List)localObject1).size() <= 0)
      {
        QMUIHelper.showToast(ReadMailFragment.this.getActivity(), 2131690564, "");
        DataCollector.logException(7, 33, "Event_Error", QMApplicationContext.sharedInstance().getString(2131690564), false);
        return;
      }
      ImageAttachData.loadData((List)localObject1, ReadMailFragment.this.mailData.getStatus().isProtocolMail(), false);
      int j = ReadMailFragment.this.readMailView.getMailType();
      boolean bool;
      int k;
      if ((ReadMailFragment.this.mWebViewController != null) && (ReadMailFragment.this.mWebViewController.getResourceLoader() != null) && (ReadMailFragment.this.mWebViewController.getResourceLoader().isAllImageCached()))
      {
        bool = true;
        k = ReadMailFragment.this.mAccountId;
        if (ReadMailFragment.this.getMailFolder() != null) {
          break label371;
        }
      }
      label371:
      for (int i = 0;; i = ReadMailFragment.this.getMailFolder().getType())
      {
        localObject1 = ImageAttachBucketSelectActivity.createIntent(k, paramInt, i, ReadMailFragment.this.mailData.getStatus().isGroupMail(), bool, ReadMailFragment.this.isImageLoad, j, ReadMailFragment.this.mailData);
        ReadMailFragment.this.startActivityForResult((Intent)localObject1, 100);
        ReadMailFragment.this.getActivity().overridePendingTransition(2130772422, 2130772419);
        return;
        bool = false;
        break;
      }
    }
    
    private void updateMailBigAttachExpireTimeView(View paramView, MailBigAttach paramMailBigAttach, int paramInt)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131379661);
      long l = paramMailBigAttach.getExpireTimeMilli();
      int i;
      if (l > 0L)
      {
        Date localDate = paramMailBigAttach.getExpire();
        paramMailBigAttach = FtnCommonUtils.getExpireTimeString(localDate);
        if ((!paramMailBigAttach.equals("已过期")) && (!paramMailBigAttach.equals("即将过期")))
        {
          i = 1;
          if ((localDate.getTime() - new Date().getTime()) / 1000L / 24L / 60L / 60L >= 6L) {
            break label246;
          }
          localTextView.setTextColor(ReadMailFragment.this.getResources().getColor(2131167539));
          if (i == 0) {
            break label398;
          }
          paramMailBigAttach = paramMailBigAttach + ReadMailFragment.this.getString(2131718580);
        }
      }
      label398:
      for (;;)
      {
        label150:
        localTextView.setText(paramMailBigAttach);
        localTextView.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setTag(Integer.valueOf(paramInt));
        paramMailBigAttach = paramView.findViewById(2131363050);
        paramMailBigAttach.setOnClickListener(this.attachOptOnClickListener);
        paramMailBigAttach.setOnLongClickListener(this.attachOptOnLongClickListener);
        paramMailBigAttach.setOnTouchListener(this.itemOnTouchListener);
        paramMailBigAttach.setTag(Integer.valueOf(paramInt));
        paramView.setOnClickListener(this.itemOnClickListener);
        paramView.setOnLongClickListener(this.itemOnLongClickListener);
        paramView.setOnTouchListener(this.itemOnTouchListener);
        label246:
        do
        {
          return;
          i = 0;
          break;
          localTextView.setTextColor(ReadMailFragment.this.getResources().getColor(2131167531));
          if (i == 0) {
            break label398;
          }
          paramMailBigAttach = paramMailBigAttach + ReadMailFragment.this.getString(2131718579);
          break label150;
          if (paramMailBigAttach.isBizNetDiskAttach())
          {
            localTextView.setText(ReadMailFragment.this.getString(2131694055));
            localTextView.setVisibility(0);
            localTextView.setTextColor(ReadMailFragment.this.getResources().getColor(2131167531));
            return;
          }
        } while ((l != -2L) && (l >= System.currentTimeMillis()));
        localTextView.setText("已过期");
        localTextView.setVisibility(0);
        localTextView.setTextColor(ReadMailFragment.this.getResources().getColor(2131167539));
        return;
      }
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
      if ((ReadMailFragment.this.mailData == null) || (ReadMailFragment.this.mailData.getInformation() == null)) {}
      label263:
      label2442:
      for (;;)
      {
        return;
        this.bigAttachList = ReadMailFragment.this.mailData.getInformation().getBigAttachList();
        int j;
        int k;
        label78:
        int m;
        if (this.bigAttachList == null)
        {
          j = 0;
          this.attachList = ReadMailFragment.this.mailData.getInformation().getAttachListNoInlineImg();
          if (this.attachList != null) {
            break label251;
          }
          k = 0;
          this.editAttachList = ReadMailFragment.this.mailData.getInformation().getEditAttachList();
          if (this.editAttachList != null) {
            break label263;
          }
          m = 0;
        }
        Object localObject1;
        String str;
        Object localObject2;
        for (;;)
        {
          if ((k > 0) && (paramInt < k))
          {
            localObject1 = (Attach)this.attachList.get(paramInt);
            str = FileUtil.getFileNameSuffix(((Attach)localObject1).getName());
            localObject2 = QMAttachUtils.attachFileType(str);
            i = FileUtil.getOpenType(ReadMailFragment.this.getActivity(), str);
            if (ReadMailFragment.this.isAttachOverSize((Attach)localObject1))
            {
              QMUIHelper.showToast(ReadMailFragment.this.getActivity(), 2131690564, "");
              QMLog.log(5, "ReadMailFragment", "normal attach over size:" + ((Attach)localObject1).getSize());
              DataCollector.logException(7, 33, "Event_Error", QMApplicationContext.sharedInstance().getString(2131690564), false);
              return;
              j = this.bigAttachList.size();
              break;
              label251:
              k = this.attachList.size();
              break label78;
              m = this.editAttachList.size();
              continue;
            }
            if (!((Attach)localObject1).isExist()) {
              break label846;
            }
            QMLog.log(4, "ReadMailFragment", "attach " + ((Attach)localObject1).getName() + " at " + paramInt + " is downloaded");
            if (!StringExtention.isNullOrEmpty(paramString)) {
              break label817;
            }
            DataCollector.logEvent("Event_Attach_Open_File_From_ReadMail");
            QMAttachUtils.attachOpenOssLog(String.valueOf(((Attach)localObject1).getHashId()), ((Attach)localObject1).getPreview().getMyDisk());
            QMLog.log(4, "ReadMailFragment", "attach preview type:" + i + " suffix:" + str);
            if (i != 2) {
              break label754;
            }
            if ((!FileUtil.isCompressSuffix(str)) || (!ReadMailFragment.this.isQQMail())) {
              break label743;
            }
            ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
          }
        }
        int i = paramInt;
        int n;
        if (j > 0)
        {
          i = paramInt;
          if (paramInt >= k)
          {
            i = paramInt;
            if (paramInt < k + j)
            {
              i = paramInt - k;
              localObject1 = (MailBigAttach)this.bigAttachList.get(i);
              str = FileUtil.getFileNameSuffix(((MailBigAttach)localObject1).getName());
              localObject2 = QMAttachUtils.attachFileType(str);
              n = FileUtil.getOpenType(ReadMailFragment.this.getActivity(), str);
              if (!((MailBigAttach)localObject1).isExist()) {
                break label1706;
              }
              QMLog.log(4, "ReadMailFragment", "bigAttach " + ((MailBigAttach)localObject1).getName() + " at " + i + " is downloaded");
              if (!StringExtention.isNullOrEmpty(paramString)) {
                break label1660;
              }
              DataCollector.logEvent("Event_Attach_Open_File_From_ReadMail");
              QMAttachUtils.attachOpenOssLog(String.valueOf(((MailBigAttach)localObject1).getHashId()), ((MailBigAttach)localObject1).getPreview().getMyDisk());
              QMLog.log(4, "ReadMailFragment", "bigAttach preview type:" + n + " suffix:" + str);
              if (n != 2) {
                break label1593;
              }
              if ((!FileUtil.isCompressSuffix(str)) || (!ReadMailFragment.this.isQQMail())) {
                break label1582;
              }
              ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
            }
          }
        }
        label1706:
        for (;;)
        {
          if ((m <= 0) || (i < k + j)) {
            break label2442;
          }
          AccountManager.shareInstance().getAccountList().getAccountById(ReadMailFragment.this.mAccountId);
          paramString = SimpleWebViewExplorer.createIntent(((MailEditAttach)this.editAttachList.get(i - (k + j))).getUrl(), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON, ReadMailFragment.this.mAccountId, true);
          ReadMailFragment.this.startActivity(paramString);
          return;
          label743:
          ReadMailFragment.this.showCanNotPreviewDialog(paramInt);
          break;
          label754:
          if ((AttachType.valueOf((String)localObject2) == AttachType.IMAGE) && (!FileUtil.isFileTypeTiff(((Attach)localObject1).getName())))
          {
            startImageAttachPreview(getRelativePosition(paramInt));
            ReadMailFragment.access$8902(ReadMailFragment.this, paramInt);
            break;
          }
          startAttachPreview((Attach)localObject1, i, paramInt);
          ReadMailFragment.access$8902(ReadMailFragment.this, paramInt);
          break;
          label817:
          Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690571), 0).show();
          DownloadUtil.existFileSaveAs((Attach)localObject1, paramString, false);
          break;
          label846:
          QMLog.log(4, "ReadMailFragment", "attach " + ((Attach)localObject1).getName() + " at " + paramInt + " is not downloaded");
          if (!ReadMailFragment.this.hasSDCardAndHandleErrorIfNo()) {
            break;
          }
          localObject2 = ReadMailFragment.this.attachListView.getChildAt(paramInt);
          ((View)localObject2).findViewById(2131378296).setVisibility(8);
          ((View)localObject2).findViewById(2131379661).setVisibility(0);
          localObject2 = (DownloadThumbProgressBar)((View)localObject2).findViewById(2131373659);
          if ((StringExtention.isNullOrEmpty(paramString)) && (!ReadMailFragment.this.isFileShare))
          {
            if (((DownloadThumbProgressBar)localObject2).getState() == 0)
            {
              if ((i == 2) && (QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((Attach)localObject1).getSize()) > 2097152L))
              {
                QMLog.log(4, "ReadMailFragment", "attach can not preview and with mobile network,size:" + ((Attach)localObject1).getSize());
                if ((FileUtil.isCompressSuffix(str)) && (ReadMailFragment.this.isQQMail()))
                {
                  ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
                  break;
                }
                ReadMailFragment.this.showDownloadConfirmDialog(((Attach)localObject1).getName(), ((Attach)localObject1).getSize(), false, new ReadMailFragment.AttachListViewAdapter.1(this, (DownloadThumbProgressBar)localObject2, (Attach)localObject1, paramString));
                break;
              }
              if ((i == 2) && (QMNetworkUtils.isNetworkConnected()))
              {
                QMLog.log(4, "ReadMailFragment", "attach can not preview download");
                if ((FileUtil.isCompressSuffix(str)) && (ReadMailFragment.this.isQQMail()))
                {
                  ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
                  break;
                }
                ReadMailFragment.this.showCanNotPreviewDownloadConfirmDialog(new ReadMailFragment.AttachListViewAdapter.2(this, (DownloadThumbProgressBar)localObject2, (Attach)localObject1, paramString));
                break;
              }
              if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((Attach)localObject1).getSize()) > 2097152L))
              {
                QMLog.log(4, "ReadMailFragment", "attach download with mobile network,size:" + ((Attach)localObject1).getSize());
                ReadMailFragment.this.showDownloadConfirmDialog(((Attach)localObject1).getName(), ((Attach)localObject1).getSize(), true, new ReadMailFragment.AttachListViewAdapter.3(this, (DownloadThumbProgressBar)localObject2, (Attach)localObject1, paramString));
                break;
              }
              if (QMNetworkUtils.isNetworkConnected())
              {
                QMLog.log(4, "ReadMailFragment", "attach download with network");
                ((DownloadThumbProgressBar)localObject2).start();
                ReadMailFragment.this.downloadAttach((Attach)localObject1, paramString);
                break;
              }
              QMLog.log(4, "ReadMailFragment", "attach download without network!");
              ReadMailFragment.this.showDownloadWithoutNetworkDialog();
              break;
            }
            if (((DownloadThumbProgressBar)localObject2).getState() == 2)
            {
              if (QMNetworkUtils.isNetworkConnected())
              {
                QMLog.log(4, "ReadMailFragment", "attach download restart with network");
                ((DownloadThumbProgressBar)localObject2).start();
                ReadMailFragment.this.downloadAttach((Attach)localObject1, paramString);
                break;
              }
              QMLog.log(4, "ReadMailFragment", "attach download restart without network!");
              ReadMailFragment.this.showDownloadWithoutNetworkDialog();
              break;
            }
            if (((DownloadThumbProgressBar)localObject2).getState() != 1) {
              break;
            }
            QMLog.log(4, "ReadMailFragment", "attach download pause");
            ((DownloadThumbProgressBar)localObject2).pause(false);
            ReadMailFragment.this.abortDownloadAttach((Attach)localObject1);
            break;
          }
          QMLog.log(4, "ReadMailFragment", "attach download with save path " + paramString);
          if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((Attach)localObject1).getSize()) > 2097152L))
          {
            QMLog.log(4, "ReadMailFragment", "attach download with mobile network,size:" + ((Attach)localObject1).getSize());
            ReadMailFragment.this.showDownloadConfirmDialog(((Attach)localObject1).getName(), ((Attach)localObject1).getSize(), true, new ReadMailFragment.AttachListViewAdapter.4(this, (DownloadThumbProgressBar)localObject2, (Attach)localObject1, paramString));
            break;
          }
          if (QMNetworkUtils.isNetworkConnected())
          {
            QMLog.log(4, "ReadMailFragment", "attach download with wifi");
            ((DownloadThumbProgressBar)localObject2).start();
            ReadMailFragment.this.downloadAttach((Attach)localObject1, paramString);
            break;
          }
          QMLog.log(4, "ReadMailFragment", "attach download without network!");
          ReadMailFragment.this.showDownloadWithoutNetworkDialog();
          break;
          label1582:
          ReadMailFragment.this.showCanNotPreviewDialog(paramInt);
          continue;
          label1593:
          if ((AttachType.valueOf((String)localObject2) == AttachType.IMAGE) && (!FileUtil.isFileTypeTiff(((MailBigAttach)localObject1).getName())))
          {
            startImageAttachPreview(getRelativePosition(i + k));
            ReadMailFragment.access$8902(ReadMailFragment.this, paramInt);
          }
          else
          {
            startAttachPreview((Attach)localObject1, n, paramInt);
            ReadMailFragment.access$8902(ReadMailFragment.this, paramInt);
            continue;
            label1660:
            Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131690569) + paramString, 0).show();
            DownloadUtil.existFileSaveAs((Attach)localObject1, paramString, false);
            continue;
            QMLog.log(4, "ReadMailFragment", "bigAttach " + ((MailBigAttach)localObject1).getName() + " at " + i + " is not downloaded");
            if (ReadMailFragment.this.hasSDCardAndHandleErrorIfNo())
            {
              localObject2 = ReadMailFragment.this.attachListView.getChildAt(paramInt);
              ((View)localObject2).findViewById(2131378296).setVisibility(8);
              ((View)localObject2).findViewById(2131379661).setVisibility(0);
              localObject2 = (DownloadThumbProgressBar)((View)localObject2).findViewById(2131373659);
              if ((StringExtention.isNullOrEmpty(paramString)) && (!ReadMailFragment.this.isFileShare))
              {
                if (((DownloadThumbProgressBar)localObject2).getState() == 0)
                {
                  if ((n == 2) && (QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach can not preview and with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                    if ((FileUtil.isCompressSuffix(str)) && (ReadMailFragment.this.isQQMail())) {
                      ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
                    } else {
                      ReadMailFragment.this.showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), false, new ReadMailFragment.AttachListViewAdapter.5(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                    }
                  }
                  else if ((n == 2) && (QMNetworkUtils.isNetworkConnected()))
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach can not preview download");
                    if ((FileUtil.isCompressSuffix(str)) && (ReadMailFragment.this.isQQMail())) {
                      ReadMailFragment.this.showCompressPreviewDialog((Attach)localObject1, paramInt);
                    } else {
                      ReadMailFragment.this.showCanNotPreviewDownloadConfirmDialog(new ReadMailFragment.AttachListViewAdapter.6(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                    }
                  }
                  else if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach download with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                    ReadMailFragment.this.showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), true, new ReadMailFragment.AttachListViewAdapter.7(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                  }
                  else if (QMNetworkUtils.isNetworkConnected())
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach download with network");
                    ((DownloadThumbProgressBar)localObject2).start();
                    ReadMailFragment.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
                  }
                  else
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach download without network!");
                    ReadMailFragment.this.showDownloadWithoutNetworkDialog();
                  }
                }
                else if (((DownloadThumbProgressBar)localObject2).getState() == 2)
                {
                  if (QMNetworkUtils.isNetworkConnected())
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach download restart with network");
                    ((DownloadThumbProgressBar)localObject2).start();
                    ReadMailFragment.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
                  }
                  else
                  {
                    QMLog.log(4, "ReadMailFragment", "bigAttach download restart without network!");
                    ReadMailFragment.this.showDownloadWithoutNetworkDialog();
                  }
                }
                else if (((DownloadThumbProgressBar)localObject2).getState() == 1)
                {
                  QMLog.log(4, "ReadMailFragment", "bigAttach download pause");
                  ((DownloadThumbProgressBar)localObject2).pause(false);
                  ReadMailFragment.this.abortDownloadBigAttach((MailBigAttach)localObject1);
                }
              }
              else
              {
                QMLog.log(4, "ReadMailFragment", "bigAttach download with save path " + paramString);
                if ((QMNetworkUtils.isMobileConnected()) && (StringExtention.sizeStrToLong(((MailBigAttach)localObject1).getSize()) > 2097152L))
                {
                  QMLog.log(4, "ReadMailFragment", "bigAttach download with mobile network,size:" + ((MailBigAttach)localObject1).getSize());
                  ReadMailFragment.this.showDownloadConfirmDialog(((MailBigAttach)localObject1).getName(), ((MailBigAttach)localObject1).getSize(), true, new ReadMailFragment.AttachListViewAdapter.8(this, (DownloadThumbProgressBar)localObject2, (MailBigAttach)localObject1, paramString));
                }
                else if (QMNetworkUtils.isNetworkConnected())
                {
                  QMLog.log(4, "ReadMailFragment", "bigAttach download with network");
                  ((DownloadThumbProgressBar)localObject2).start();
                  ReadMailFragment.this.downloadBigAttach((MailBigAttach)localObject1, paramString);
                }
                else
                {
                  QMLog.log(4, "ReadMailFragment", "bigAttach download without network!");
                  ReadMailFragment.this.showDownloadWithoutNetworkDialog();
                }
              }
            }
          }
        }
      }
    }
  }
  
  class QuickReplyViewScrollListener
    implements View.OnFocusChangeListener, TitleBarWebView2.OnScrollListener
  {
    private boolean hasFocusBeforeScroll = false;
    private boolean scrollingAfterFocus = false;
    
    QuickReplyViewScrollListener() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.hasFocusBeforeScroll = paramBoolean;
        return;
      }
    }
    
    public void onScrollBegin() {}
    
    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if ((!this.scrollingAfterFocus) && (ReadMailFragment.this.quickReplyView != null) && (ReadMailFragment.this.quickReplyView.getHeight() - ReadMailFragment.this.quickReplyView.getMinHeight() - paramInt2 <= 0)) {
        this.hasFocusBeforeScroll = false;
      }
    }
    
    public void onScrollEnd()
    {
      if ((this.hasFocusBeforeScroll) && (ReadMailFragment.this.quickEditText != null)) {
        ReadMailFragment.this.quickEditText.requestFocus();
      }
      this.scrollingAfterFocus = false;
    }
  }
  
  static class ReadMailViewHolder
    extends QMBaseFragment.ViewHolder
  {
    ReadMailFragment activeFragment;
    int folderId;
    QMApplicationContext.LowMemoryListener lowMemoryListener;
    long mailId;
    boolean needRender;
    QMReadMailView readMailView;
    DropdownWebViewLayout webContainer;
    QMScaleWebViewController webViewController;
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
  
  static class ViewHolderRelease
    implements QMApplicationContext.LowMemoryListener
  {
    public void onRelease()
    {
      ValidateHelper.mainThread();
      StringBuilder localStringBuilder = new StringBuilder().append("LowMemory ViewHolderRelease: ").append(ReadMailFragment.sViewHolder).append(", ");
      if (ReadMailFragment.sViewHolder != null) {}
      for (ReadMailFragment localReadMailFragment = ReadMailFragment.sViewHolder.activeFragment;; localReadMailFragment = null)
      {
        QMLog.log(4, "ReadMailFragment", localReadMailFragment);
        ReadMailFragment.access$1000();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment
 * JD-Core Version:    0.7.0.1
 */