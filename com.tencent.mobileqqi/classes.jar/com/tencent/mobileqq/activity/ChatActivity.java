package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bww;
import bwx;
import bwy;
import bwz;
import bxa;
import bxb;
import bxc;
import bxd;
import bxe;
import bxf;
import bxg;
import bxh;
import bxi;
import bxj;
import bxk;
import bxl;
import bxm;
import bxn;
import bxo;
import bxp;
import bxq;
import bxr;
import bxs;
import bxt;
import bxu;
import bxv;
import bxw;
import bxx;
import bxy;
import bxz;
import bya;
import byb;
import byc;
import byd;
import bye;
import byg;
import byh;
import byi;
import byj;
import bym;
import byn;
import byp;
import byq;
import byr;
import byv;
import byw;
import byx;
import byy;
import byz;
import bza;
import bzb;
import bzf;
import bzg;
import bzi;
import bzj;
import bzl;
import bzm;
import bzo;
import bzp;
import bzq;
import bzr;
import bzs;
import bzt;
import bzw;
import bzx;
import com.etrump.mixlayout.ETLayoutCache;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.AITranslator;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.VoiceNotifyConfigHelper;
import com.tencent.mobileqq.activity.aio.VoiceNotifyConfigHelper.Callback;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.servlet.ReduFriendObserver;
import com.tencent.mobileqq.servlet.ReduFriendServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.stt.GuideActivity;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.CameraUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.CameraFrameLayoutProxy;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQProxyForQlink.Listener;
import cooperation.troop.TroopProxyActivity;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, MediaPlayerManager.Listener, VoiceNotifyConfigHelper.Callback, CheckPttListener, VibrateListener, EmoticonCallback, AbsListView.OnScrollListener, OverScrollViewListener, XPanelContainer.PanelCallback, Observer
{
  @Deprecated
  public static CountDownTimer a;
  public static final String a = "is_from_manage_stranger";
  private static final int bB = 1;
  private static final int bC = 2;
  private static final int bF = 0;
  private static final int bG = 1;
  private static final int bH = 2;
  private static final int bI = 101;
  private static final int bJ = 102;
  private static final int bz = 200;
  static final int jdField_d_of_type_Int = 1;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  private String jdField_A_of_type_JavaLangString;
  private boolean jdField_A_of_type_Boolean = false;
  private String jdField_B_of_type_JavaLangString;
  private boolean jdField_B_of_type_Boolean;
  private String jdField_C_of_type_JavaLangString;
  private boolean jdField_C_of_type_Boolean;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private boolean G = true;
  private boolean H = false;
  private boolean I = false;
  public float a;
  protected int a;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bxj(this);
  public final Handler a;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new byb(this);
  public View a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public EditText a;
  protected ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  private bzr jdField_a_of_type_Bzr;
  bzw jdField_a_of_type_Bzw;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  private AIOTipsController jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private PlusPanel jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private PressToSpeakPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToSpeakPanel;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new bxz(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new byw(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new byv(this);
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new byq(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new byn(this);
  public MessageObserver a;
  public QQMapActivityProxy a;
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new bym(this);
  private StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new byy(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new byp(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new bya(this);
  private QQMessageFacade.RefreshMessageContext jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new byx(this);
  public ChatXListView a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private EmotionPreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  private ReduFriendObserver jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = null;
  TroopAioTips jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = null;
  VideoPlayLogic jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  CameraFrameLayoutProxy jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private UpScrollHideView.onViewHideListener jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = new byd(this);
  protected XPanelContainer a;
  private QQProxyForQlink.Listener jdField_a_of_type_CooperationQlinkQQProxyForQlink$Listener = null;
  public Runnable a;
  private List jdField_a_of_type_JavaUtilList;
  protected boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 0;
  public long b;
  public Dialog b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private SpannableString jdField_b_of_type_AndroidTextSpannableString;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public TextView b;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public boolean b;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  private int bA = 0;
  private int bD;
  private int bE = 0;
  private final int bK = 0;
  private final int bL = 1;
  private final int bM = 2;
  private final int bN = 3;
  private final int bw = 300;
  private int bx = 0;
  private int by = 1;
  public int c;
  public Dialog c;
  private Handler jdField_c_of_type_AndroidOsHandler = new bww(this, Looper.getMainLooper());
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected RelativeLayout c;
  protected TextView c;
  public boolean c;
  private long jdField_d_of_type_Long = -1L;
  public Dialog d;
  private Handler jdField_d_of_type_AndroidOsHandler = new bxv(this);
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long;
  public Dialog e;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView = null;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public volatile boolean f;
  private long jdField_g_of_type_Long = -1L;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  boolean jdField_g_of_type_Boolean = true;
  private long jdField_h_of_type_Long;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  boolean jdField_h_of_type_Boolean = false;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  boolean jdField_i_of_type_Boolean = true;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  boolean jdField_j_of_type_Boolean = false;
  private View jdField_k_of_type_AndroidViewView;
  boolean jdField_k_of_type_Boolean = false;
  private View jdField_l_of_type_AndroidViewView;
  boolean jdField_l_of_type_Boolean = false;
  private View m;
  private View n;
  private View jdField_o_of_type_AndroidViewView;
  private boolean jdField_o_of_type_Boolean;
  private View p;
  private boolean t;
  private boolean u;
  private boolean v = true;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private final String jdField_z_of_type_JavaLangString = "ChatActivity";
  private boolean jdField_z_of_type_Boolean = false;
  
  public ChatActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 131074;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new bxq(this);
    this.jdField_p_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new byj(this);
  }
  
  private void C() {}
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnCreate_initData start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnCreate_initData");
    jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new bzs(this, null);
    this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$Listener = new bzt(this, null);
    this.jdField_b_of_type_Boolean = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.w();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_e_of_type_Boolean = true;
    StartupTracker.a("AIO_doOnCreate_initData", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnCreate_initData end: " + System.currentTimeMillis());
    }
  }
  
  private void E()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
      {
        Object localObject1 = new bzj(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131230820);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131427501));
        localLayoutParams.addRule(10);
        this.jdField_i_of_type_AndroidWidgetTextView = new TextView(this);
        this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
        if (ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131561963));
          this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
            break label691;
          }
          this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(false);
          this.jdField_i_of_type_AndroidWidgetTextView.setClickable(false);
          label228:
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131362105));
          this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2131427359));
          this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130837682));
          this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
          Object localObject2 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new View(this);
          ((View)localObject2).setBackgroundColor(-3486515);
          LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(1, -1);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, localLayoutParams1);
          this.jdField_j_of_type_AndroidWidgetTextView = new TextView(this);
          this.jdField_j_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_j_of_type_AndroidWidgetTextView.setText(getString(2131561587));
          this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131362105));
          this.jdField_j_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimensionPixelSize(2131427359));
          this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130837682));
          this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_j_of_type_AndroidWidgetTextView.getText());
          this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
          localObject1 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_j_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131230820);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, 0, localLayoutParams);
        }
      }
      else
      {
        if (!ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
          break label710;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131561963));
        this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.b(2131230820);
        }
        return;
        if (ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131563117));
          this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
          break;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131561712));
        this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        break;
        label691:
        this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_i_of_type_AndroidWidgetTextView.setClickable(true);
        break label228;
        label710:
        if (ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131563117));
          this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
        }
        else
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(getResources().getString(2131561712));
          this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        }
      }
    }
  }
  
  private void F()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void G()
  {
    if (CrmUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      F();
      return;
    }
    if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
    {
      E();
      return;
    }
    F();
  }
  
  private void H()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231201);
      localView.setBackgroundResource(2130837765);
      localView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(false, false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231201).setVisibility(8);
  }
  
  private void I()
  {
    if (this.bA != 2) {
      g(2);
    }
  }
  
  private void J()
  {
    if (this.bA == 2) {
      g(0);
    }
  }
  
  private void K()
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_A_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.E = true;
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (this.jdField_A_of_type_JavaLangString == null) {}
    for (String str = "";; str = this.jdField_A_of_type_JavaLangString)
    {
      localEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      this.E = false;
      return;
    }
  }
  
  private void L()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((!StringUtil.b(this.jdField_A_of_type_JavaLangString)) || (!StringUtil.b(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
        break label65;
      }
    }
    label65:
    while ((this.jdField_A_of_type_JavaLangString != null) && (this.jdField_A_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject1 = new ArrayList();
      localObject1 = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (ArrayList)localObject1);
    }
    Object localObject2;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() > 0))
    {
      localObject2 = new DraftTextInfo();
      ((DraftTextInfo)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((DraftTextInfo)localObject2).type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ((DraftTextInfo)localObject2).text = ((CharSequence)localObject1).toString();
      ((DraftTextInfo)localObject2).time = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (DraftTextInfo)localObject2);
    }
    for (;;)
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (localObject2 == null) {
        break;
      }
      ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ((DraftSummaryInfo)localObject2).getSummary(), ((DraftSummaryInfo)localObject2).getTime());
      return;
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, "", 0L);
  }
  
  private void M()
  {
    if (!isFinishing())
    {
      O();
      Y();
      ThreadManager.b(new bwx(this));
    }
  }
  
  private void N()
  {
    if (SttManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      int i1 = SttManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (i1 != 0)
      {
        this.jdField_k_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("free_call_first_enter_aio_show_ext_panel", false);
          ((SharedPreferences.Editor)localObject).commit();
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
        Object localObject = new Intent(this, GuideActivity.class);
        ((Intent)localObject).putExtra("k_guide", i1);
        startActivity((Intent)localObject);
        return;
      }
      this.jdField_k_of_type_Boolean = SttManager.jdField_a_of_type_Boolean;
      return;
    }
    this.jdField_k_of_type_Boolean = SttManager.jdField_a_of_type_Boolean;
  }
  
  private void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      if (!this.jdField_k_of_type_Boolean)
      {
        Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        this.jdField_l_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("free_call_first_enter_aio_show_ext_panel", true);
        if (!this.jdField_l_of_type_Boolean) {
          break label83;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("free_call_first_enter_aio_show_ext_panel", false);
        ((SharedPreferences.Editor)localObject).commit();
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      }
      label83:
      while (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver = new bwy(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
      return;
    }
    this.jdField_l_of_type_Boolean = false;
  }
  
  private void P()
  {
    bwz localbwz = new bwz(this);
    this.jdField_d_of_type_AndroidOsHandler.postDelayed(localbwz, 1000L);
  }
  
  private void Q()
  {
    if (StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
    }
  }
  
  private void R()
  {
    DialogUtil.a(this, 230, null, getString(2131560198), 2131560229, 2131560230, new bxc(this), new bxd(this)).show();
  }
  
  private void S()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_updateUI start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.e();
    }
    if (ChatBackground.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    av();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a();
    }
    StartupTracker.a("AIO_doOnResume_updateUI", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_updateUI end: " + System.currentTimeMillis());
    }
  }
  
  private void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_troopType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnResume_troopType");
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562025));
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    StartupTracker.a("AIO_doOnResume_troopType", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_troopType end: " + System.currentTimeMillis());
    }
  }
  
  private void U()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_discussType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnResume_discussType");
    DiscussionInfo localDiscussionInfo = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_b_of_type_AndroidWidgetTextView);
    }
    StartupTracker.a("AIO_doOnResume_discussType", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume_discussType end: " + System.currentTimeMillis());
    }
  }
  
  private void V()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((TroopInfo)localObject).wMemberNum == 0)) {
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l1));
            ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d("ChatActivity", 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "getTroopInfoIfNeed failed");
  }
  
  private void W()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void X()
  {
    at();
    if (this.jdField_a_of_type_Int == 0) {}
    label11:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i9 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    int i7 = this.jdField_a_of_type_Int;
    Object localObject1;
    int i3;
    int i8;
    int i2;
    int i5;
    label191:
    int i1;
    long l1;
    label297:
    label317:
    label372:
    boolean bool;
    switch (this.jdField_a_of_type_Int & 0xFFFF0000)
    {
    default: 
    case 65536: 
      for (localObject1 = localList;; localObject1 = localList)
      {
        i3 = this.bx;
        i8 = localList.size();
        i2 = ((List)localObject1).size();
        i5 = this.jdField_a_of_type_Int & 0xFFFF;
        if ((i5 != 0) || (this.jdField_c_of_type_AndroidViewView != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1))) {
          break label2164;
        }
        i5 = 2;
        switch (i5)
        {
        case 4: 
        default: 
          i1 = i3;
          if (localList != localObject1)
          {
            if ((i8 <= 0) || (i2 <= 0)) {
              break label2140;
            }
            l1 = ((ChatMessage)localList.get(i8 - 1)).uniseq;
            i1 = i2 - 1;
            if (i1 < 0) {
              break label2140;
            }
            if (((ChatMessage)((List)localObject1).get(i1)).uniseq != l1) {
              break label1702;
            }
            if (i1 < 0) {
              break label1709;
            }
            i1 = i2 - (i8 - this.bx + i2 - 1 - i1);
          }
          if (i5 != 5) {
            break label1714;
          }
          i1 = i2 - (i8 - this.bx);
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), -1, null);
          QQToast.a(this, 1, getString(2131560615), 3000).b(d());
          if ((!this.v) || (i2 == 0)) {
            break label1814;
          }
          bool = true;
          label386:
          g(bool);
          this.jdField_a_of_type_Int = 0;
          this.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.bx = i1;
          switch (i7 & 0xFFFF0000)
          {
          default: 
            label440:
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
              break label11;
            }
            localObject1 = (MessageForShakeWindow)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
            if (!((MessageForShakeWindow)localObject1).isSendFromLocal()) {
              break label1979;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bxn(this, (MessageForShakeWindow)localObject1), 20L);
            label513:
            this.jdField_a_of_type_JavaUtilList.clear();
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
          }
          break;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_g_of_type_Boolean);
      this.jdField_g_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label2174;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a((List)localObject1);
    }
    label1325:
    label1477:
    label1737:
    label2140:
    label2145:
    label2164:
    label2174:
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      if ((this.jdField_A_of_type_Boolean) && (((List)localObject1).size() > 0))
      {
        localObject5 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
        ((ChatMessage)localObject5).mAnimFlag = true;
        ((ChatMessage)localObject5).mPendantAnimatable = true;
        if ((localObject5 instanceof MessageForMarketFace))
        {
          localObject4 = ((MessageForMarketFace)localObject5).mMarkFaceMessage;
          localObject3 = localObject4;
          if (localObject4 == null)
          {
            ((ChatMessage)localObject5).parse();
            localObject3 = ((MessageForMarketFace)localObject5).mMarkFaceMessage;
          }
          if ((((MarkFaceMessage)localObject3).mobileparam != null) && (((MarkFaceMessage)localObject3).mobileparam.length > 0) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
            ((MessageForMarketFace)localObject5).needToPlay = true;
          }
        }
      }
      Object localObject3 = ChatActivityUtils.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_o_of_type_Boolean)
      {
        localObject4 = ChatActivityUtils.a(this, (MessageRecord)localObject3);
        if (localObject4 == null) {
          break label1325;
        }
        d(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject4);
      }
      for (;;)
      {
        localObject3 = ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((List)localObject1, (CharSequence)localObject3);
        break;
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        localObject4 = ((List)localObject3).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ChatMessage)((Iterator)localObject4).next();
          String str1;
          if ((localObject5 instanceof MessageForQzoneFeed))
          {
            try
            {
              localObject1 = new JSONObject(((MessageForQzoneFeed)localObject5).msg);
              str1 = ((JSONObject)localObject1).optString("summery");
              String str2 = ((JSONObject)localObject1).optString("content");
              if (!str1.equals("上传了照片")) {
                continue;
              }
              str2 = str2.substring(str2.indexOf("《"), str2.indexOf("》") + 1);
              localObject1 = getString(2131563329) + ((JSONObject)localObject1).optInt("imageCount") + getString(2131563330) + str2;
              ((MessageForQzoneFeed)localObject5).summery = LocaleString.i(getBaseContext(), str1);
              ((MessageForQzoneFeed)localObject5).content = ((String)localObject1);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AIOQzoneFeed", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
                }
                localObject2 = null;
              }
            }
          }
          else if ((localObject5 instanceof MessageForStructing))
          {
            ((ChatMessage)localObject5).mIsParsed = false;
            ((ChatMessage)localObject5).parse();
            if ((((MessageForStructing)localObject5).structingMsg instanceof StructMsgForGeneralShare))
            {
              localObject2 = (StructMsgForGeneralShare)((MessageForStructing)localObject5).structingMsg;
              str1 = ((StructMsgForGeneralShare)localObject2).mSourceName;
              if (str1.equals("QQ空间"))
              {
                ((StructMsgForGeneralShare)((MessageForStructing)localObject5).structingMsg).mSourceName = LocaleString.i(getBaseContext(), str1);
                if ((((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.get(0) instanceof StructMsgItemLayout2))
                {
                  localObject2 = ((StructMsgItemLayout2)((StructMsgForGeneralShare)localObject2).mStructMsgItemLists.get(0)).jdField_a_of_type_JavaUtilArrayList.iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject5 = (AbsStructMsgElement)((Iterator)localObject2).next();
                    if ((localObject5 instanceof StructMsgItemTitle))
                    {
                      str1 = ((StructMsgItemTitle)localObject5).b();
                      str1 = LocaleString.i(getBaseContext(), str1);
                      ((StructMsgItemTitle)localObject5).a(str1);
                    }
                    else if ((localObject5 instanceof StructMsgItemSummary))
                    {
                      str1 = ((StructMsgItemSummary)localObject5).b();
                      str1 = LocaleString.i(getBaseContext(), str1);
                      ((StructMsgItemSummary)localObject5).a(str1);
                    }
                  }
                }
              }
            }
          }
        }
        d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a() - 1, 0);
      i1 = i2;
      break label317;
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a() - 1);
      i1 = i2;
      break label317;
      i1 = i3;
      if (i8 <= 0) {
        break label317;
      }
      i1 = i3;
      if (i4 < 0) {
        break label317;
      }
      if (i2 > 0)
      {
        l1 = ((ChatMessage)localList.get(i4)).uniseq;
        i1 = 0;
        if (i1 < i2) {
          if (((ChatMessage)((List)localObject2).get(i1)).uniseq == l1)
          {
            if ((i1 >= 0) || (localList.size() <= i4 + 1)) {
              break label2145;
            }
            l1 = ((ChatMessage)localList.get(i4 + 1)).uniseq;
            i3 = 0;
            if (i3 >= i2) {
              break label2145;
            }
            if (((ChatMessage)((List)localObject2).get(i3)).uniseq != l1) {
              break label1560;
            }
            i1 = i3;
            i4 = 1;
          }
        }
      }
      for (;;)
      {
        if (i1 >= 0)
        {
          int i6 = this.bx + i1;
          i3 = i6;
          if (i4 != 0) {
            i3 = i6 - 1;
          }
          if ((i9 < 0) && (i1 == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.B();
            i1 = i3;
            break label317;
            i1 += 1;
            break label1413;
            i3 += 1;
            break label1477;
          }
          if (i9 < 0)
          {
            i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k()).getBottom();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), i4 - i6 + i9);
            i1 = i3;
            break label317;
          }
          i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
          i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k()).getBottom();
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), i4 - i6);
          i1 = i3;
          break label317;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
        i1 = i2;
        break label317;
        i1 -= 1;
        break;
        i1 = i2;
        break label317;
        if (i5 != 6) {
          break label372;
        }
        i4 = this.bx;
        i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
        i1 = 0;
        if (i1 < i3)
        {
          localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
          if ((localObject2 == null) || (((ChatMessage)localObject2).msgtype != -4009)) {}
        }
        for (;;)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
          if (i1 == 0) {}
          for (i3 = 0;; i3 = -1)
          {
            ((ScrollerRunnable)localObject2).a(i1, i3, null);
            i1 = i2 - (i8 - i4);
            break;
            i1 += 1;
            break label1737;
          }
          bool = false;
          break label386;
          if (!this.jdField_f_of_type_Boolean) {
            break label440;
          }
          if ((!this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean) && ((this.m == null) || (this.m.getVisibility() != 0)) && ((this.n == null) || (this.n.getVisibility() != 0)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
            ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (List)localObject2);
          }
          if ((!this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
            ChatActivityFacade.b(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (List)localObject2);
            ChatActivityFacade.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (List)localObject2);
          }
          this.jdField_f_of_type_Boolean = false;
          break label440;
          l1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + ((MessageForShakeWindow)localObject2).shmsgseq + ",msgUid is:" + ((MessageForShakeWindow)localObject2).msgUid + ",uniseq is:" + ((MessageForShakeWindow)localObject2).uniseq + ",onlineStatus is:" + l1 + ",userActiveStatus is:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.ah);
          }
          if ((l1 != 11L) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.ah != 0)) {
            break label513;
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bxo(this, (MessageForShakeWindow)localObject2), 20L);
          break label513;
          i1 = 0;
        }
        i1 = -1;
        break label297;
        i4 = 0;
        continue;
        i1 = -1;
        break label1438;
        i1 = -1;
        i4 = 0;
      }
      break label191;
      Object localObject2 = localObject3;
    }
  }
  
  private void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "isShowGuide is:" + this.jdField_k_of_type_Boolean + ",isShowPlusPanel is:" + this.jdField_l_of_type_Boolean + ",curType is:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if (m() == true) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ReduFriendServlet.jdField_b_of_type_JavaLangString, 2, "judgeResultForVoiceCallTip is:" + Arrays.toString(null));
      }
      return;
      if (!j()) {
        if (k())
        {
          aa();
        }
        else if (l())
        {
          if (this.jdField_i_of_type_AndroidViewView == null)
          {
            this.jdField_i_of_type_AndroidViewView = ChatActivityUtils.a(this, getString(2131563076), getString(2131561576), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener);
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_i_of_type_AndroidViewView);
        }
        else if (this.y)
        {
          if (this.jdField_j_of_type_AndroidViewView == null)
          {
            this.jdField_j_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903430, null);
            this.jdField_j_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_j_of_type_AndroidViewView);
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "mp_msg_zhushou_4", "share_succ", 0, 0, "", "", "", "");
          this.jdField_d_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 5000L);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
        }
      }
    }
  }
  
  private void Z()
  {
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localQQOperateManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
      return;
    }
    if (this.m == null)
    {
      this.m = LayoutInflater.from(this).inflate(2130903544, null);
      this.m.findViewById(2131232880).setOnClickListener(new bxs(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.m);
    ChatActivityFacade.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localQQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    String str2;
    String str3;
    String str1;
    if (paramInt2 == -1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        str2 = "";
        str3 = "";
        str1 = str2;
        paramString = str3;
        if (paramInt1 != 2) {
          break label138;
        }
        paramString = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (!g()) {
          break label58;
        }
      }
    }
    for (;;)
    {
      return;
      label58:
      Friends localFriends = paramString.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      str1 = str2;
      paramString = str3;
      if (localFriends != null)
      {
        str1 = "" + ContactUtils.a(localFriends);
        paramString = "" + ContactUtils.a(localFriends, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      label138:
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "clt", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "msg", paramInt1 + "", "", "", str1, paramString, this.by + "");
      this.by = 0;
      return;
      str1 = null;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
      while (str1 != null)
      {
        StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "pic", "", paramInt2 + "", paramString, "", "", "");
        return;
        str1 = "clt";
        continue;
        str1 = "grp";
        continue;
        str1 = "discuss";
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.bE == 1) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramInt) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString2))))
        {
          if (this.jdField_g_of_type_AndroidViewView == null)
          {
            this.jdField_g_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903087, null);
            this.jdField_g_of_type_AndroidViewView.setId(2131230793);
            this.jdField_g_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
            this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130837885);
            this.jdField_g_of_type_AndroidViewView.setClickable(true);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_g_of_type_AndroidViewView, -1, -2);
          }
          for (paramString1 = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131231106);; paramString1 = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131231106))
          {
            a(null, super.getResources().getString(2131560248), getResources().getColor(2131362083));
            this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
            this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130837885);
            this.jdField_g_of_type_AndroidViewView.setVisibility(0);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.b(this.jdField_g_of_type_AndroidViewView.getId());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
            return;
          }
        }
      } while (this.jdField_g_of_type_AndroidViewView == null);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.b(2131230820);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean3) {
      i1 = 2131561719;
    }
    for (;;)
    {
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
      return;
      if (paramBoolean2) {
        i1 = 2131563001;
      } else if (paramBoolean1) {
        i1 = 2131562961;
      } else {
        i1 = 2131561997;
      }
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime handleRequest start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnCreate_handleRequest");
    int i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "handleRequest requestCode " + i1);
    }
    if ((i1 == 2) || (i1 == 1))
    {
      if (a(true)) {
        return;
      }
      c(paramIntent);
    }
    if (paramInt == 1)
    {
      ChatActivityFacade.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ChatActivityFacade.f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatActivity", 2, "AIOTime handleRequest end: " + System.currentTimeMillis());
      return;
      if ((paramInt == 2) && (!this.G))
      {
        ChatActivityFacade.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ChatActivityFacade.f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
      paramIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage))) {}
    while (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) || ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.b()))) {
      return;
    }
    if ((paramMessage.msg.toString().equals("你的QQ暂不支持查看视频短片，请期待后续版本")) || (paramMessage.msg.toString().equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。")))
    {
      paramMessage.msg = "[视频] 您的QQ版本暂不支持查看视频短片。";
      paramMessage.emoRecentMsg = "[视频] 您的QQ版本暂不支持查看视频短片。";
    }
    runOnUiThread(new bxp(this, paramMessage, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this, paramMessage, false)));
  }
  
  private void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    if (m()) {}
    do
    {
      return;
      if (!c()) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("ChatActivity", 4, "multiVideoStatus bar is visible,return");
    return;
    View localView = LayoutInflater.from(this).inflate(2130903544, null);
    TextView localTextView = (TextView)localView.findViewById(2131232881);
    Button localButton = (Button)localView.findViewById(2131232880);
    localTextView.setText(paramQQOperationViopTipTask.adwords);
    localButton.setText(paramQQOperationViopTipTask.clickableWord);
    localButton.setOnClickListener(new bxt(this, paramQQOperationViopTipTask));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(localView);
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    String str2 = getString(2131560588);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new bxb(this, paramAbsShareMsg, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      TroopGagMgr.SelfGagInfo localSelfGagInfo = paramSelfGagInfo;
      if (paramSelfGagInfo == null) {
        localSelfGagInfo = ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean);
      }
      if (!localSelfGagInfo.jdField_a_of_type_Boolean) {
        break label150;
      }
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (2 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.bA != 1) || (this.jdField_e_of_type_Int != 0)))
      {
        I();
        if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.jdField_b_of_type_JavaLangString);
        }
        this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_c_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, localSelfGagInfo.jdField_a_of_type_Long * 1000L);
      }
    }
    else
    {
      return;
    }
    this.jdField_j_of_type_Boolean = true;
    return;
    label150:
    this.jdField_j_of_type_Boolean = false;
    J();
  }
  
  private void a(String paramString, int paramInt, long paramLong) {}
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    a(ChatActivity.RecordStatus.invalid, paramString, paramLong);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    StreamDataManager.a(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true);
    if (paramLong == 0L) {
      StreamDataManager.a(paramString);
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    int i2 = StreamDataManager.a(paramString);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    int i1;
    if (paramLong == 0L)
    {
      i1 = 1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      if (i1 == 0) {
        break label222;
      }
      MessageRecord localMessageRecord = ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
      paramLong = localMessageRecord.uniseq;
    }
    label222:
    for (;;)
    {
      if ((i1 != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)) {
        StreamDataManager.a(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong + ",time is:" + i2);
      }
      if (i2 >= 512)
      {
        ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, paramLong, false);
        c(paramInt1, paramInt2);
      }
      a(ChatActivity.RecordStatus.standby, paramString, paramLong);
      return;
      i1 = 0;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "genDiscussTitle, name == null");
      }
      return;
    }
    int i1 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (i1 <= 0)
    {
      paramTextView.setText(paramString1);
      return;
    }
    int i2 = getResources().getDisplayMetrics().widthPixels;
    int i3 = AIOUtils.a(207.0F, getResources());
    TextPaint localTextPaint = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
    float f2 = i2 - i3 - localTextPaint.measureText(String.format("(%d人)", new Object[] { Integer.valueOf(i1) })) - 4.0F * getResources().getDisplayMetrics().density;
    String str = paramString1;
    float f1;
    float f3;
    if (f2 > 0.0F)
    {
      f1 = localTextPaint.measureText(paramString1);
      str = paramString1;
      if (f1 > f2)
      {
        f3 = f2 - localTextPaint.measureText("…");
        paramString2 = paramString1;
      }
    }
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramString2.length() > 0))
      {
        paramString2 = paramString2.substring(0, paramString2.length() - 1);
        f2 = localTextPaint.measureText(paramString2);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramString2.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "genDiscussTitle : name widht = " + f1);
        }
      }
      else
      {
        str = paramString1;
        if (f3 > 0.0F)
        {
          str = paramString1;
          if (paramString2.length() > 0) {
            str = paramString2 + "…";
          }
        }
        paramTextView.setText(String.format(getResources().getString(2131559036), new Object[] { str, Integer.valueOf(i1) }));
        return;
      }
    }
  }
  
  private void aa()
  {
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_o_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903093, null);
      this.jdField_o_of_type_AndroidViewView.setOnClickListener(new bxy(this));
    }
    ((TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131231136)).setText(this.B);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_o_of_type_AndroidViewView);
  }
  
  private void ab()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 0);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    long l1 = getIntent().getLongExtra("res_share_id", 0L);
    if ((this.jdField_d_of_type_Boolean) && (l1 > 0L)) {
      ForwardOperations.a(this, true, "shareToQQ", AppShareIDUtil.b(l1));
    }
    finish();
  }
  
  private void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void ad()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopAssistantManager.a().e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) && (getIntent() != null))
    {
      FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      int i1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((i1 <= 99) || (TroopAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != 1) || (localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label208;
      }
      if (i1 <= 200) {
        break label195;
      }
      this.w = true;
    }
    for (;;)
    {
      if (this.w)
      {
        TroopAssistantManager.a().i(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
      }
      return;
      label195:
      this.w = false;
      this.x = true;
      continue;
      label208:
      this.w = false;
    }
  }
  
  private void ae()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (!CrmUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (this.jdField_b_of_type_Int >= 5) && (PubAccountAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.y = true;
      }
      if ((CrmUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Int >= 10) && (PubAccountAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.y = true;
      }
    } while (!this.y);
    PubAccountAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void af()
  {
    StartupTracker.a(null, "AIO_onShow_troopType");
    ThreadManager.b(new bye(this));
    V();
    ae();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
    }
    ap();
    StartupTracker.a("AIO_onShow_troopType", null);
  }
  
  private void ag()
  {
    StartupTracker.a(null, "AIO_onShow_AIORoad");
    if (isResume())
    {
      if ((!CameraUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) || (!CameraUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label281;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy = new CameraFrameLayoutProxy(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.a();
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "chat onShow oncreate");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "chat onShow oncreate emotionLayout start");
      }
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout = ((EmotionPreviewLayout)getLayoutInflater().inflate(2130903085, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131231200);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetEditText);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "chat onShow oncreate emotionLayout end time=" + (System.currentTimeMillis() - l1));
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12));
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) && (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.b(2131230820);
      }
      StartupTracker.a("AIO_onShow_AIORoad", null);
      return;
      label281:
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "chat onShow");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.b();
      }
    }
  }
  
  private void ah()
  {
    StartupTracker.a(null, "AIO_onShow_insertSomeTips");
    ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    StartupTracker.a("AIO_onShow_insertSomeTips", null);
  }
  
  private void ai()
  {
    StartupTracker.a(null, "AIO_onShow_videoStatus");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
    {
      ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0L);
    }
    StartupTracker.a("AIO_onShow_videoStatus", null);
  }
  
  private void aj()
  {
    startService(new Intent(this, PeakService.class));
  }
  
  private void ak()
  {
    StartupTracker.a(null, "AIO_onShow_updateUI");
    M();
    this.jdField_c_of_type_Boolean = SettingCloneUtil.readValue(this, null, getString(2131563454), "qqsetting_enter_sendmsg_key", false);
    String str;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(4);
      if (this.jdField_a_of_type_Bzr == null) {
        this.jdField_a_of_type_Bzr = new bzr(this, null);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_Bzr);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_Bzr);
      boolean bool = getIntent().getExtras().getBoolean("refuse_show_share_result_dialog", false);
      if ((this.jdField_d_of_type_Boolean) && (!bool) && (this.jdField_i_of_type_Boolean))
      {
        localObject = getIntent().getExtras();
        str = ((Bundle)localObject).getString("app_name");
        localObject = StructMsgFactory.a((Bundle)localObject);
        if ((localObject == null) || (!(localObject instanceof AbsShareMsg))) {
          break label208;
        }
      }
    }
    label208:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      a((AbsShareMsg)localObject, str);
      this.jdField_i_of_type_Boolean = false;
      aw();
      StartupTracker.a("AIO_onShow_updateUI", null);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(null);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(null);
      break;
    }
  }
  
  private void al()
  {
    StartupTracker.a(null, "AIO_onShow_YYVoIP");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new byg(this));
    }
    StartupTracker.a("AIO_onShow_YYVoIP", null);
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime onShow start: " + System.currentTimeMillis());
    }
    StartupTracker.a("AIO_Start_cost", "AIO_onShow");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      af();
    }
    ag();
    ah();
    ak();
    ai();
    q(getIntent());
    al();
    aj();
    ao();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    }
    ((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    ThreadPriorityManager.a(false);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime onShow end: " + System.currentTimeMillis());
    }
  }
  
  private void an()
  {
    AioAnimationDetector.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
  
  private void ao()
  {
    StartupTracker.a(null, "AIO_onShow_setReaded");
    ThreadManager.b().post(new byh(this));
    StartupTracker.a("AIO_onShow_setReaded", null);
  }
  
  private void ap()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.b(new byi(this));
    }
  }
  
  @TargetApi(11)
  private void aq()
  {
    if (this.bA == 1)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838676);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
      if (VersionUtils.e()) {
        this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      return;
      if (this.bA == 2)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
        if (VersionUtils.e()) {
          this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(0.6F);
        }
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840156);
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131563000));
          return;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840157);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562846));
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840156);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131563000));
      }
      while (VersionUtils.e())
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840157);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562846));
      }
    }
  }
  
  private void ar()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$Listener);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    VoiceNotifyConfigHelper.a().a(this);
  }
  
  private void as()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink$Listener);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqServletReduFriendObserver);
    }
    VoiceNotifyConfigHelper.a().b(this);
  }
  
  private void at()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(16);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.D();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  private void au()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      String str;
      do
      {
        return;
        str = ((Intent)localObject).getStringExtra("gid");
      } while (!ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str));
      localObject = StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    ShareMsgHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (AbsStructMsg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "mp_msg_sys_67", "twohand_send", 0, 1, 0, "", "1", "", "");
  }
  
  private void av()
  {
    if ((ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)) {
      if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
        break label316;
      }
    }
    label292:
    label316:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_k_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_k_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_k_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label292;
        }
        if ((this.jdField_k_of_type_AndroidViewView == null) || (this.jdField_k_of_type_AndroidViewView.getVisibility() != 0)) {
          break label213;
        }
      }
      label213:
      while (this.jdField_k_of_type_AndroidViewView == null)
      {
        return;
        if (this.jdField_k_of_type_AndroidViewView.getVisibility() == 4)
        {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
          break;
        }
        QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = GONE");
        break;
        if (this.jdField_k_of_type_AndroidViewView == null)
        {
          this.jdField_k_of_type_AndroidViewView = new View(this);
          this.jdField_k_of_type_AndroidViewView.setBackgroundColor(1996488704);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.addRule(6, 2131231198);
          localLayoutParams.addRule(8, 2131231198);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_k_of_type_AndroidViewView, localLayoutParams);
          return;
        }
        this.jdField_k_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_k_of_type_AndroidViewView);
      this.jdField_k_of_type_AndroidViewView = null;
      return;
    }
  }
  
  private void aw()
  {
    if (getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))
    {
      SharedPreferences localSharedPreferences = getSharedPreferences("mobileQQi", 0);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        e(str);
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ThreadManager.b(new bxa(this, paramInt1, paramInt2));
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnCreate_initUI start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)findViewById(2131231116));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231196));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231211));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231210));
    this.jdField_a_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new FakeImageView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131231455);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131231460);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230941));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231489));
    this.jdField_b_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.jdField_c_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131230941);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131231489);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)findViewById(2131231198));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStartTime(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)findViewById(2131231199));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    this.jdField_c_of_type_AndroidViewView = new View(this);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics())));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231206));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231204));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231208));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(new bxg(this));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231205));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new bxr(this));
    this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    ((XEditTextEx)this.jdField_a_of_type_AndroidWidgetEditText).setOnPrivateIMECommandListener(new byc(this));
    Object localObject = Build.MODEL;
    if ((localObject != null) && ((((String)localObject).startsWith("SH-")) || (((String)localObject).startsWith("SBM")) || (((String)localObject).startsWith("SHL")))) {}
    try
    {
      localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      int i1 = ((Integer)((Field)localObject).get(new TextView(this))).intValue();
      ((Field)localObject).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(i1));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231203));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(new byr(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231200));
      localObject = getIntent();
      this.jdField_h_of_type_Boolean = ((Intent)localObject).getBooleanExtra("fromSecHandCom", false);
      this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("isBack2Root");
      this.jdField_d_of_type_Boolean = ((Intent)localObject).getExtras().containsKey("res_share_id");
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = getIntent().getExtras().getBoolean("is_share_flag");
      }
      bool1 = ((Intent)localObject).getBooleanExtra("key_jump_from_qzone_feed", false);
      boolean bool2 = ((Intent)localObject).getBooleanExtra("isFromDiscussionFlyTicket", false);
      this.jdField_C_of_type_Boolean = ((Intent)localObject).getBooleanExtra("is_from_manage_stranger", false);
      if (bool2)
      {
        this.t = true;
        localObject = null;
        if (!this.t) {
          break label1144;
        }
        f();
        str2 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        localObject = str2;
        if (!getString(2131560958).equals(str2)) {
          localObject = getApplicationContext().getString(2131559035, new Object[] { str2 });
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("进入聊天信息界面");
        H();
        StartupTracker.a("AIO_doOnCreate_initUI", null);
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "AIOTime doOnCreate_initUI end: " + System.currentTimeMillis());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (bool1)
        {
          str1 = localException.getStringExtra("key_jump_from_qzone_feed_left_title");
          if (str1 == null) {}
          for (str1 = getString(2131561692);; str1 = getString(2131561521, new Object[] { str1 }))
          {
            this.t = false;
            break;
          }
        }
        String str1 = str1.getExtras().getString("leftViewText");
        if ((this.jdField_a_of_type_Boolean) || ((str1 != null) && (str1.contains(getString(2131561807))))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.t = bool1;
          break;
        }
        label1144:
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        String str2 = str1;
        if (str1 == null) {
          str2 = getString(2131561692);
        }
        localTextView.setText(str2);
      }
    }
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1041);
    long l1 = MessageCache.a();
    localMessageRecord.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramQQOperationViopTipTask.adwords + "|" + paramQQOperationViopTipTask.clickableWord + "|" + paramQQOperationViopTipTask.linkOffset + "|" + paramQQOperationViopTipTask.url + "|" + paramQQOperationViopTipTask.taskid, l1, -1041, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!AIOUtils.b())) {
      if (this.jdField_e_of_type_AndroidViewView == null)
      {
        getLayoutInflater().inflate(2130903090, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231113);
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231115));
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label147;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b())) {
          ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131231200);
        }
      }
    }
    label146:
    label147:
    while (this.jdField_e_of_type_AndroidViewView == null)
    {
      break label146;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131562208);
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidViewView.setSelected(paramBoolean2);
        return;
        if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
          break;
        }
        ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131231200);
        break;
        this.jdField_g_of_type_AndroidWidgetTextView.setText(2131561996);
      }
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i1 = paramIntent.getIntExtra("uintype", -1);
    paramIntent.getIntExtra("entrance", 0);
    if (str == null) {
      return false;
    }
    if (i1 == -1)
    {
      QQToast.a(this, getString(2131562949), 0).b(d());
      return false;
    }
    if (paramIntent.hasExtra("account"))
    {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "1", "", "", "");
      if (!((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(str))
      {
        d(paramIntent);
        return false;
      }
    }
    if ((paramIntent.getBooleanExtra("shortcut", false)) && (!((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(str)))
    {
      QQToast.a(getApplicationContext(), getString(2131562100), 0).b(d());
      return false;
    }
    return true;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      i1 = 1;
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        break label225;
      }
      QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramInt1 != 1) {
        break label219;
      }
      i2 = 1;
      label45:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i2 + "", i1 + "", paramInt2 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt1 + ", sessionType = " + i1 + ", seconds = " + paramInt2);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        i1 = 2;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        i1 = 3;
        break;
      }
      i1 = 4;
      break;
      label219:
      i2 = 2;
      break label45;
      label225:
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", i1 + "", paramInt2 + "", "");
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    aq();
    if (paramInt2 == 3)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839762);
      if (!this.u)
      {
        ImageSpan localImageSpan;
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this, 2130837653);
          localSpannableString = new SpannableString(getResources().getString(2131559039));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this, 2130837715);
          localSpannableString = new SpannableString(getResources().getString(2131559038));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
      }
      if (paramInt2 != 4) {
        break label199;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838052);
    }
    label199:
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838055);
        break;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837644);
      break;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838058);
    } while (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0);
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent.removeExtra("account");
    paramIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
    paramIntent.setClassName(this, ShortcutRouterActivity.class.getName());
    startActivity(paramIntent);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  private void e(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_initIntentData start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    StartupTracker.a("AIO_updateSession_initIntentData", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_initIntentData end: " + System.currentTimeMillis());
    }
  }
  
  private void f(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_businessCmrTmp start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_businessCmrTmp");
    this.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "From chatActivity : buinessCrm Sigt--->" + HexUtil.a(this.jdField_b_of_type_ArrayOfByte));
    }
    if (this.jdField_b_of_type_ArrayOfByte != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte);
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivity", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    StartupTracker.a("AIO_updateSession_businessCmrTmp", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_businessCmrTmp end: " + System.currentTimeMillis());
    }
  }
  
  private void f(String paramString)
  {
    if (!NetworkUtil.e(super.getApplicationContext())) {
      QQToast.a(super.getApplicationContext(), 2131562452, 0).b(super.getApplicationContext().getResources().getDimensionPixelSize(2131427376));
    }
    while (paramString == null) {
      return;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    int i2 = 1;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      i1 = 1;
      i2 = 0;
    }
    for (;;)
    {
      if ((i1 == 0) && (i2 == 0))
      {
        return;
        if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          i1 = 0;
        }
      }
      else
      {
        Object localObject;
        ChatMessage localChatMessage;
        long l1;
        if (paramBoolean)
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          int i3 = ((List)localObject).size();
          i2 = 0;
          if (i2 >= i3) {
            break label285;
          }
          localChatMessage = (ChatMessage)((List)localObject).get(i2);
          if (!localChatMessage.isread) {
            if (i1 != 0) {
              l1 = localChatMessage.shmsgseq;
            }
          }
        }
        for (;;)
        {
          label137:
          if (QLog.isColorLevel()) {
            QLog.d(AioAnimationDetector.jdField_a_of_type_JavaLangString, 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + paramBoolean + ", lastMsgTimeOrSeq=" + l1);
          }
          localObject = AioAnimationDetector.a();
          ((AioAnimationDetector)localObject).jdField_a_of_type_Boolean = paramBoolean;
          ((AioAnimationDetector)localObject).jdField_a_of_type_Long = l1;
          if (paramBoolean) {}
          for (;;)
          {
            ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l1 = localChatMessage.time;
            break label137;
            i2 += 1;
            break;
            localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (i1 != 0)
            {
              l1 = ((QQMessageFacade.Message)localObject).shmsgseq;
              break label137;
            }
            l1 = ((QQMessageFacade.Message)localObject).time;
            break label137;
            l1 += 1L;
          }
          label285:
          l1 = -1L;
        }
      }
      i2 = 0;
      i1 = 0;
    }
  }
  
  private void g(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_troopType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_troopType");
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this, new bzx(this), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      TroopFileError.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString.length() == 0))
      {
        paramIntent = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.troopcode;
        }
      }
      ad();
      StartupTracker.a("AIO_updateSession_troopType", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession_troopType end: " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null)
      {
        if (this.jdField_h_of_type_AndroidViewView == null) {
          this.jdField_h_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903136, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_h_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(getResources().getDrawable(2130838675));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  private void h(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_strangerType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_strangerType");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("troop_code");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString.trim().length() == 0))
      {
        paramIntent = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = paramIntent.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_updateSession_strangerType", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession_strangerType end: " + System.currentTimeMillis());
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramIntent = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = (paramIntent.nationCode + paramIntent.mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = ContactUtils.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) && (QLog.isColorLevel())) {
          QLog.e("ChatActivity", 2, "contactUin == null");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003)
      {
        j(paramIntent);
      }
    }
  }
  
  private void h(boolean paramBoolean)
  {
    f(paramBoolean);
  }
  
  private void i(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_lbsType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_lbsType");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("rich_accost_sig");
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "From chatActivity : accost Sig--->" + HexUtil.a(this.jdField_a_of_type_ArrayOfByte));
    }
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte);
    }
    j(paramIntent);
    StartupTracker.a("AIO_updateSession_lbsType", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_lbsType end: " + System.currentTimeMillis());
    }
  }
  
  private boolean i()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0;
  }
  
  private void j(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_lbsorStrangerRecordType start: " + System.currentTimeMillis());
    }
    if (2 == paramIntent.getExtras().getInt("cSpecialFlag")) {
      ChatActivityFacade.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession_lbsorStrangerRecordType end: " + System.currentTimeMillis());
      }
      return;
      paramIntent = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent == null) {
        Q();
      } else if ((paramIntent != null) && (paramIntent.strCertificationInfo != null) && (!paramIntent.strCertificationInfo.equals(""))) {
        ChatActivityFacade.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
  }
  
  private boolean j()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean) && (ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true) == 1);
  }
  
  private void k(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_h_of_type_AndroidWidgetTextView != null)) {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0) {
      return;
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this);
      ((TextView)localObject1).setId(2131230788);
      ((TextView)localObject1).setBackgroundResource(2130837713);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(3.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131231200);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(25.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(findViewById(2131231209));
      if (this.jdField_e_of_type_AndroidViewView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131230788);
      }
    }
    Object localObject2 = this.jdField_h_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void k(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_sameStateType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_sameStateType");
    paramIntent = paramIntent.getByteArrayExtra("rich_status_sig");
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "From chatActivity : sameState Sig--->" + HexUtil.a(paramIntent));
    }
    if (paramIntent != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
    }
    StartupTracker.a("AIO_updateSession_sameStateType", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_sameStateType end: " + System.currentTimeMillis());
    }
  }
  
  private boolean k()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {}
    String str;
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a()));
      str = localBundle.getString("bookname");
      if (!android.text.TextUtils.isEmpty(str)) {
        break;
      }
    } while ((this.B == null) || (!this.G));
    return true;
    this.B = String.format(getResources().getString(2131559037), new Object[] { str });
    this.jdField_h_of_type_Long = localBundle.getLong("bookid");
    return true;
  }
  
  private void l(int paramInt)
  {
    int i1;
    if (paramInt == 1) {
      i1 = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i1 + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 2) {
        i1 = 2;
      } else {
        i1 = 3;
      }
    }
  }
  
  private void l(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_updateUI start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_updateUI");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
    ChatActivityFacade.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    b(true);
    Object localObject = paramIntent.getStringExtra("uinname");
    label122:
    boolean bool;
    label134:
    label150:
    int i1;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject);
      if (3000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
        break label735;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        break label820;
      }
      bool = true;
      this.jdField_o_of_type_Boolean = bool;
      if (this.jdField_o_of_type_Boolean) {
        break label825;
      }
      k();
      G();
      g(0);
      i1 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this);
      switch (i1)
      {
      default: 
        i1 = 3;
        label218:
        this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(i1);
        this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1021) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1022))
        {
          bool = true;
          label387:
          this.u = bool;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1003) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000)) {
            break label863;
          }
          findViewById(2131231202).setVisibility(8);
          localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(getResources().getDisplayMetrics().density * 10.0F));
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          label484:
          localObject = paramIntent.getStringExtra("input_text");
          paramIntent.removeExtra("input_text");
          if (localObject == null) {
            break label904;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
          label514:
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
          }
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_d_of_type_Boolean = paramIntent.getExtras().getBoolean("is_share_flag");
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label911;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          label572:
          if (!ChatActivityUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
            break label938;
          }
          this.jdField_b_of_type_AndroidWidgetImageView = new FakeImageView(this);
          this.jdField_b_of_type_AndroidWidgetImageView.setId(2131231491);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840331);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bzo(this));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break label918;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131558454));
        }
        break;
      }
    }
    for (;;)
    {
      this.by = 1;
      this.v = true;
      g(false);
      StartupTracker.a("AIO_updateSession_updateUI", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession_updateUI end: " + System.currentTimeMillis());
      }
      return;
      h();
      break;
      label735:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(""))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        break label122;
      }
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      break label122;
      label820:
      bool = false;
      break label134;
      label825:
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label150;
      }
      d(false);
      break label150;
      i1 = 3;
      break label218;
      i1 = 2;
      break label218;
      i1 = 2;
      break label218;
      bool = false;
      break label387;
      label863:
      findViewById(2131231202).setVisibility(0);
      localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label484;
      label904:
      K();
      break label514;
      label911:
      g();
      break label572;
      label918:
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131558453));
      continue;
      label938:
      this.jdField_b_of_type_AndroidWidgetImageView = new FakeImageView(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131231491);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private boolean l()
  {
    if (!this.w) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a())) {
      return false;
    }
    return true;
  }
  
  private void m(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_forwardType start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_forwardType");
    int i1;
    if (paramIntent.getExtras().containsKey("forward_type"))
    {
      i1 = paramIntent.getIntExtra("forward_type", 2147483647);
      if (i1 != 0) {
        break label147;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561807);
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bzp(this, paramIntent, paramIntent), 500L);
      StartupTracker.a("AIO_updateSession_forwardType", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession_forwardType end: " + System.currentTimeMillis());
      }
      return;
      label147:
      if (i1 == 1001) {
        a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, paramIntent);
      }
    }
  }
  
  private boolean m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
      return false;
    }
    if (this.bE == 2) {
      return false;
    }
    if (this.bE == 1) {
      return true;
    }
    l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        localThrowable1.printStackTrace();
      }
      if (this.I) {
        break label126;
      }
      this.I = true;
      if (!UinFraudInfo.a().a(l1)) {
        break label126;
      }
      if (!QLog.isColorLevel()) {
        break label104;
      }
      QLog.d("ChatActivity", 2, "uin cache is out of date, update it! ");
      ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b("OidbSvc.0x476_146", (int)l1, 146);
      int i1 = UinFraudInfo.a().a(l1);
      if (i1 == 0) {
        break label368;
      }
      AntiFraudConfigFileUtil.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
      if (this.jdField_p_of_type_AndroidViewView != null) {
        break label169;
      }
      this.jdField_p_of_type_AndroidViewView = a(this, null, i1);
      if (this.jdField_p_of_type_AndroidViewView == null) {
        break label368;
      }
      Object localObject1 = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i1);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label204;
      }
      return false;
      Object localObject2 = (TextView)this.jdField_p_of_type_AndroidViewView.findViewById(2131233292);
      if (localObject2 != null) {
        break label226;
      }
      return false;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_p_of_type_AndroidViewView);
      this.bE = 1;
      ReportController.b(null, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i1, 0, "", "", "", "");
      localObject1 = new Timer();
      localObject2 = new bxw(this);
      String str = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerTTL", 146, i1);
      l1 = 15L;
      try
      {
        i1 = Integer.parseInt(str);
        l1 = i1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
      l1 *= 1000L;
      if (l1 <= 0L) {
        break label356;
      }
      ((Timer)localObject1).schedule((TimerTask)localObject2, l1);
      return true;
    }
    return l1 != 0L;
  }
  
  private void n(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_otherThings start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession_otherThings");
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    if (paramIntent.getLongExtra("res_share_id", 0L) > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bzq(this, paramIntent), 20L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || (CrmUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    MsgProxyUtils.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession_otherThings end: " + System.currentTimeMillis());
    }
  }
  
  private void o(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent_updateUI start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnNewIntent_updateUI");
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561807);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
      }
      AioAnimationDetector.a().a();
      StartupTracker.a("AIO_doOnNewIntent_updateUI", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent_updateUI end: " + System.currentTimeMillis());
      }
      return;
      if (localBundle != null)
      {
        this.jdField_a_of_type_Boolean = localBundle.getBoolean("isBack2Root");
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561807);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
        }
      }
    }
  }
  
  private void p(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent_updateData start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_doOnNewIntent_updateData");
    Object localObject1 = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
    }
    this.jdField_b_of_type_Boolean = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.w();
    ChatActivityFacade.a();
    Object localObject2 = paramIntent.getStringExtra("uin");
    int i1 = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("ChatActivity", 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + " sessionInfo.entrance " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    }
    if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != i1)) {}
    for (this.G = false; (!this.G) || (((Bundle)localObject1).containsKey("forward_type")); this.G = true)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.d();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
      }
      a(paramIntent);
      this.jdField_e_of_type_Boolean = true;
      setIntent(paramIntent);
      a(paramIntent, 2);
      StartupTracker.a("AIO_doOnNewIntent_updateData", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent_updateData end: " + System.currentTimeMillis());
      }
      return;
    }
    if (((Bundle)localObject1).containsKey("video_play_url"))
    {
      localObject1 = paramIntent.getStringExtra("video_play_url");
      long l1 = paramIntent.getLongExtra("video_play_msg", 0L);
      i1 = 0;
      label370:
      if (i1 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()) {
        break label660;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItemId(i1) != l1) {}
    }
    for (;;)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      if ((i1 < i2) || (i1 > i3 + i2 - 1)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1 - i2);
      if (localObject2 == null) {
        break;
      }
      Object localObject3 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
      if ((localObject3 == null) || (!(localObject3 instanceof MessageForStructing))) {
        break;
      }
      localObject3 = (MessageForStructing)localObject3;
      if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForGeneralShare))) {
        break;
      }
      localObject3 = (StructMsgForGeneralShare)((MessageForStructing)localObject3).structingMsg;
      if (localObject3 == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = new VideoPlayLogic(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      if (this.jdField_o_of_type_AndroidViewView != null) {
        this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      }
      this.B = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a((String)localObject1, (StructMsgForGeneralShare)localObject3, (View)localObject2);
      break;
      i1 += 1;
      break label370;
      if ((this.jdField_a_of_type_Int != 0) || (bool))
      {
        b(true);
        break;
      }
      if (((Bundle)localObject1).getLong("res_share_id", 0L) <= 0L) {
        break;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, paramIntent);
      break;
      label660:
      i1 = -1;
    }
  }
  
  private void q(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_e_of_type_Boolean))
    {
      paramIntent.getBoolean("start_from_notification", false);
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + i1);
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), String.valueOf(i1), "", "");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt)
  {
    PlusPanel localPlusPanel = null;
    if (paramInt == 3)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)getLayoutInflater().inflate(2130903088, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
      }
      localPlusPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
    }
    do
    {
      return localPlusPanel;
      if (paramInt == 2)
      {
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)getLayoutInflater().inflate(2130903212, null));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this, d(), this.jdField_C_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l1));
        }
        return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    } while (paramInt != 4);
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)getLayoutInflater().inflate(2130903540, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (InputLinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  }
  
  public View a(Context paramContext, String paramString, int paramInt)
  {
    if (this.jdField_p_of_type_AndroidViewView == null)
    {
      this.jdField_p_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130903658, null);
      this.jdField_p_of_type_AndroidViewView.setOnClickListener(new bxx(this, paramInt));
    }
    return this.jdField_p_of_type_AndroidViewView;
  }
  
  @Deprecated
  public QQAppInterface a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(int paramInt)
  {
    int i1 = paramInt & 0xFFFF0000;
    if ((paramInt & 0xFFFF) > (this.jdField_a_of_type_Int & 0xFFFF)) {
      paramInt &= 0xFFFF;
    }
    long l1;
    for (;;)
    {
      this.jdField_a_of_type_Int = (paramInt | i1);
      if (isResume())
      {
        if (i1 < 196608) {
          break label122;
        }
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(12))
        {
          l1 = SystemClock.uptimeMillis();
          if (l1 - this.jdField_g_of_type_Long <= 1000L) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
        }
      }
      return;
      paramInt = this.jdField_a_of_type_Int & 0xFFFF;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, 1000L - (l1 - this.jdField_g_of_type_Long));
    return;
    label122:
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    a(false);
  }
  
  void a(int paramInt, long paramLong)
  {
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.i(((ChatMessage)localObject2).msgtype));
      l1 = ((ChatMessage)localObject2).shmsgseq;
    }
    localObject1 = new bzm(this);
    if (paramInt == 1) {
      if ((int)l1 > 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label269;
        }
        paramLong = l1 - 200L;
      }
    }
    label269:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramInt != 4) && (paramInt != 3));
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        } while ((localObject2 == null) || (l1 - ((MessageRecord)localObject2).shmsgseq > 200L));
        if ((int)l1 > ((MessageRecord)localObject2).shmsgseq + 1L)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, ((MessageRecord)localObject2).shmsgseq, false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
          return;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2);
      } while (paramInt == -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, paramInt, null);
      return;
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(long paramLong)
  {
    AvatarPendantUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      String str2 = getIntent().getStringExtra("KEY_FROM");
      String str1 = str2;
      if (str2 == null)
      {
        ComponentName localComponentName = getCallingActivity();
        str1 = str2;
        if (localComponentName != null) {
          str1 = localComponentName.getClassName();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + paramLong + ",from:" + str1);
      }
    }
    PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
    PerformanceReportUtils.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
  }
  
  protected void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime updateSession start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_updateSession");
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    L();
    e(paramIntent);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
        TroopFileError.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      }
      break;
    }
    for (;;)
    {
      l(paramIntent);
      m(paramIntent);
      n(paramIntent);
      StartupTracker.a("AIO_updateSession", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime updateSession end: " + System.currentTimeMillis());
      }
      return;
      f(paramIntent);
      continue;
      g(paramIntent);
      continue;
      h(paramIntent);
      continue;
      i(paramIntent);
      continue;
      k(paramIntent);
    }
  }
  
  void a(ChatActivity.RecordStatus paramRecordStatus, String paramString, long paramLong)
  {
    switch (bzn.a[paramRecordStatus.ordinal()])
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      b(true);
      return;
    }
    if (paramString != null)
    {
      paramRecordStatus = StreamDataManager.a(paramString);
      if ((paramRecordStatus != null) && (paramRecordStatus.exists())) {
        paramRecordStatus.delete();
      }
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    b(true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageObserver paramMessageObserver, Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    if ((localAbsStructMsg instanceof StructMsgForImageShare)) {}
    for (;;)
    {
      Bundle localBundle = paramIntent.getExtras();
      String str = localBundle.getString("share_comment_message");
      paramMessageObserver = str;
      if (android.text.TextUtils.isEmpty(str)) {
        paramMessageObserver = localAbsStructMsg.mCommentText;
      }
      if (!android.text.TextUtils.isEmpty(paramMessageObserver)) {
        ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageObserver);
      }
      paramIntent.removeExtra("forward_type");
      paramIntent.getExtras().remove("forward_type");
      paramIntent.removeExtra("res_share_id");
      localBundle.remove("res_share_id");
      return;
      ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, paramMessageObserver);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      at();
    }
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage, false);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
    int i3 = i1 - i2;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i3 + ",firstPos is:" + i2 + ",pos is:" + i1);
      }
      a(196612);
      return;
    }
    boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
    boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
    this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this);
    if (localBitmap != null) {}
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(localBitmap);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "viewShotCopy is:" + localBitmap);
        }
        if (localBitmap != null)
        {
          localObject2 = (ViewGroup)findViewById(2131231196);
          i2 = ((ViewGroup)localObject2).getChildCount();
          i1 = 0;
          if (i1 >= i2) {
            break label920;
          }
          if (((ViewGroup)localObject2).getChildAt(i1) == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
          {
            if (i1 != -1) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "listViewIndex is:" + i1 + ",can not find listView");
            }
            a(196612);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = null;
        continue;
        i1 += 1;
        continue;
        Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131231198);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131231198);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131231198);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131231198);
        ((ViewGroup)localObject2).addView(this.jdField_a_of_type_AndroidViewViewGroup, i1 + 1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new byz(this));
        localObject3 = new ImageView(this);
        ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
        FrameLayout localFrameLayout = new FrameLayout(this);
        Object localObject2 = new FrameLayout.LayoutParams(this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        this.jdField_a_of_type_AndroidViewViewGroup.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        localFrameLayout.addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout.LayoutParams)localObject2).leftMargin = this.jdField_a_of_type_AndroidViewView.getLeft();
        ((FrameLayout.LayoutParams)localObject2).topMargin = this.jdField_a_of_type_AndroidViewView.getTop();
        ((FrameLayout.LayoutParams)localObject2).rightMargin = 0;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = 0;
        LinearInterpolator localLinearInterpolator = new LinearInterpolator();
        AnimationSet localAnimationSet = new AnimationSet(true);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject2).setDuration(400L);
        ((AlphaAnimation)localObject2).setInterpolator(localLinearInterpolator);
        localAnimationSet.addAnimation((Animation)localObject2);
        if (paramChatMessage.isSend())
        {
          localObject2 = new TranslateAnimation(0.0F, this.jdField_a_of_type_AndroidViewView.getRight(), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(400L);
          ((TranslateAnimation)localObject2).setInterpolator(localLinearInterpolator);
          localAnimationSet.addAnimation((Animation)localObject2);
          ((ImageView)localObject3).startAnimation(localAnimationSet);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bza(this, localFrameLayout), 400L);
          this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
          this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
          if (localObject1 != null)
          {
            localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(15);
            ((Message)localObject1).obj = paramChatMessage;
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 200L);
          }
        }
        else
        {
          localObject2 = new TranslateAnimation(0.0F, -this.jdField_a_of_type_AndroidViewView.getRight(), 0.0F, 0.0F);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 300L);
        return;
      }
      label920:
      i1 = -1;
      continue;
      Object localObject1 = null;
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() != 1)) {}
    while ((!paramBoolean) && (paramInt == 1) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
      return;
    }
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (a(true)) {
      return;
    }
    paramEmoticonInfo.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.jdField_b_of_type_Int == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramPicEmoticonInfo.a);
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
        a(ChatActivity.RecordStatus.standby, null, -1L);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    a(false);
    getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(a());
    }
    String str = BuddyTransfileProcessor.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null);
    if (QLog.isColorLevel()) {
      QLog.i("QQRecorder", 2, "path: " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
    AudioUtil.a(this, true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(str);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      AvatarPendantUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    URLDrawable.pause();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.l();
    int i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    int i3 = paramInt3 - i5 - i4;
    if (this.bx < i3)
    {
      int i2 = paramInt1 + paramInt2 - i4;
      int i1 = i2;
      if (i2 >= paramInt3 - i5 - i4) {
        i1 = i3 - 1;
      }
      if (i1 >= this.bx) {
        this.bx = (i1 + 1);
      }
    }
    for (paramInt3 = i3 - this.bx;; paramInt3 = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 13, paramInt3, i3 - paramInt1 - paramInt2).sendToTarget();
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    g(0);
    this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().append(paramCharSequence);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_e_of_type_Long);
    runOnUiThread(new bzi(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    f(2131165199);
    a(paramString, this.jdField_e_of_type_Long);
    l(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    f(2131165199);
    a(paramString, this.jdField_e_of_type_Long, paramInt1, paramInt2);
  }
  
  void a(String paramString1, String paramString2, int paramInt)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_g_of_type_AndroidViewView.findViewById(2131231105);
    localLinearLayout.removeAllViews();
    if (paramString1 != null)
    {
      TextView localTextView = new TextView(super.getApplicationContext());
      localTextView.setTextSize(14.0F);
      localTextView.setTextColor(paramInt);
      localTextView.setSingleLine();
      localTextView.setGravity(5);
      localTextView.setMaxWidth(super.getResources().getDimensionPixelSize(2131427675));
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setText(paramString1);
      localLinearLayout.addView(localTextView);
    }
    paramString1 = new TextView(super.getApplicationContext());
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(paramInt);
    paramString1.setText(paramString2);
    localLinearLayout.addView(paramString1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    StreamDataManager.a(paramString, 0, (int)(System.currentTimeMillis() / 1000L));
    StreamDataManager.a(paramString, "#!AMR\n".getBytes(), "#!AMR\n".getBytes().length, (short)0);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label92;
      }
      this.jdField_e_of_type_Long = 0L;
      f(2131165210);
    }
    for (;;)
    {
      b(true);
      return;
      label92:
      paramString = ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        paramString.setPttStreamFlag(10001);
      }
      this.jdField_e_of_type_Long = paramString.uniseq;
      f(2131165200);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    StreamDataManager.a(paramString, paramArrayOfByte, paramArrayOfByte.length, (short)0);
  }
  
  public void a(List paramList, String paramString) {}
  
  @TargetApi(13)
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 1;
    if (!paramBoolean)
    {
      this.bD = getRequestedOrientation();
      int i3 = getResources().getConfiguration().orientation;
      if (!VersionUtils.b()) {
        if (i3 == 1)
        {
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          setRequestedOrientation(i1);
        }
      }
      label56:
      do
      {
        do
        {
          do
          {
            break label56;
            do
            {
              return;
            } while (i3 != 2);
            if (VersionUtils.c()) {}
            for (i1 = 6;; i1 = 0)
            {
              setRequestedOrientation(i1);
              return;
            }
            if (VersionUtils.f())
            {
              Display localDisplay = getWindowManager().getDefaultDisplay();
              i2 = localDisplay.getRotation();
              Point localPoint = new Point();
              localDisplay.getSize(localPoint);
              if ((i2 == 0) || (i2 == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (i2 != 0) {}
                }
              }
              for (;;)
              {
                setRequestedOrientation(i1);
                return;
                i1 = 8;
                continue;
                if (i2 == 0)
                {
                  i1 = 1;
                }
                else
                {
                  i1 = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (i2 != 1) {
                      i1 = 8;
                    }
                  }
                  else if (i2 == 1) {
                    i1 = 9;
                  } else {
                    i1 = 1;
                  }
                }
              }
            }
            i1 = getWindowManager().getDefaultDisplay().getRotation();
            if ((i1 != 0) && (i1 != 1)) {
              break;
            }
            if (i3 == 1)
            {
              setRequestedOrientation(1);
              return;
            }
          } while (i3 != 2);
          setRequestedOrientation(0);
          return;
        } while ((i1 != 2) && (i1 != 3));
        if (i3 == 1)
        {
          setRequestedOrientation(9);
          return;
        }
      } while (i3 != 2);
      setRequestedOrientation(8);
      return;
    }
    setRequestedOrientation(this.bD);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isResume())
    {
      if (!paramBoolean1) {
        break label35;
      }
      i();
    }
    for (;;)
    {
      a(this, paramBoolean2, false, false);
      b(true, paramBoolean2);
      this.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      label35:
      j();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(this, paramBoolean3, paramBoolean1, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.d()) {
      if ((paramBoolean1) || (paramBoolean2)) {
        break label40;
      }
    }
    label40:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b(paramBoolean1, paramBoolean3);
      this.jdField_b_of_type_Boolean = paramBoolean3;
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_d_of_type_Long);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = true;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    g(false);
    return true;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return false;
      if ((!android.text.TextUtils.isEmpty(paramString1)) && (!android.text.TextUtils.isEmpty(paramString2)))
      {
        int i1;
        if (paramBoolean)
        {
          i1 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
          this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().delete(i1 - 1, i1);
        }
        FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          paramString1 = AtTroopMemberSpan.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_AndroidWidgetEditText);
        }
        while ((paramString1 != null) && (paramString1.length() != 0))
        {
          g(0);
          int i2 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
          i1 = i2;
          if (i2 < 0) {
            i1 = 0;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().insert(i1, paramString1);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          return true;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
            paramString1 = AtTroopMemberSpan.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, false, this.jdField_a_of_type_AndroidWidgetEditText, false);
          } else {
            paramString1 = null;
          }
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131560675, 0).b(d());
      }
      I();
      bool = true;
    }
    return bool;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.bA == 0)
    {
      if (!this.u) {
        break label69;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setSelected(true);
      if (paramEditable.length() <= 0) {
        break label50;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838055);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(true);
    }
    label50:
    label69:
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837644);
        this.jdField_d_of_type_AndroidWidgetImageView.setSelected(false);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
        if (paramEditable.length() <= 0) {
          break;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838055);
        this.jdField_d_of_type_AndroidWidgetImageView.setSelected(true);
      } while (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager == null);
      paramEditable = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramEditable.toString());
    } while ((paramEditable == null) || (paramEditable.size() <= 0));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setEmoticonKeywordList(paramEditable);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(0);
    return;
    if (this.jdField_b_of_type_AndroidTextSpannableString == null)
    {
      paramEditable = new ImageSpan(this, 2130837715);
      SpannableString localSpannableString = new SpannableString(getResources().getString(2131559038));
      localSpannableString.setSpan(paramEditable, 0, localSpannableString.length(), 33);
      this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837644);
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(false);
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start currenttime:" + System.currentTimeMillis());
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      PicPreDownloadUtils.a((String)localObject);
      if ((localObject != null) && (((String)localObject).length() > 3478)) {
        ChatActivityUtils.a(this, 2131561793, 1);
      }
    }
    else
    {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType == VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject = new ArrayList();
      String str = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, (ArrayList)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = false;
        au();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
    }
  }
  
  public void b(int paramInt)
  {
    setVolumeControlStream(3);
    b(false, false);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131560675, 0).b(d());
    }
    for (;;)
    {
      return;
      int i1 = paramIntent.getIntExtra("forward_type", 2147483647);
      if (i1 == 2147483647) {
        continue;
      }
      paramIntent.removeExtra("forward_type");
      paramIntent.getExtras().remove("forward_type");
      this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("isBack2Root");
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      Object localObject2;
      String str1;
      Object localObject3;
      long l1;
      switch (i1)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case -3: 
        a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, paramIntent);
        return;
      case -1: 
        paramIntent = paramIntent.getStringExtra("forward_text");
        ChatActivityFacade.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
        return;
      case 0: 
        try
        {
          localObject2 = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
          ChatActivityFacade.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2);
          return;
        }
        catch (Throwable paramIntent)
        {
          return;
        }
      case 1: 
        boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        if (bool1)
        {
          if (bool2) {
            continue;
          }
          localObject2 = paramIntent.getStringExtra("forward_download_image_task_key");
          str1 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i1 = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          localObject3 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
          ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject3, str1, l1, i1, (String)localObject2);
          b(true);
          return;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        i1 = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        paramIntent = PicBusiManager.a(i1, paramIntent);
        localObject1 = PicBusiManager.a(2, i1);
        ((PicReq)localObject1).a(paramIntent);
        PicBusiManager.a((PicReq)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      case 2: 
      case 8: 
        if (ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1) == -1L) {
          continue;
        }
        b(true);
        return;
      case -2: 
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 == null) {
            continue;
          }
          paramIntent = ((Bundle)localObject3).getString("forward_latitude");
          localObject1 = ((Bundle)localObject3).getString("forward_longitude");
          localObject2 = ((Bundle)localObject3).getString("forward_location");
          str1 = ((Bundle)localObject3).getString("title");
          localObject3 = ((Bundle)localObject3).getString("summary");
          ChatActivityFacade.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (String)localObject2, str1, (String)localObject3, "");
          return;
        }
        localObject1 = paramIntent.getStringExtra("forward_latitude");
        localObject2 = paramIntent.getStringExtra("forward_longitude");
        paramIntent = paramIntent.getStringExtra("forward_location");
        ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, paramIntent);
        return;
      case 10: 
        localObject1 = paramIntent.getExtras();
      case 9: 
        try
        {
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("forward_composite").iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Parcelable)((Iterator)localObject1).next();
            switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
            {
            case -1: 
              ChatActivityFacade.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
              break;
            case 1: 
              str1 = paramIntent.getStringExtra("forward_download_image_task_key");
              localObject3 = paramIntent.getStringExtra("forward_download_image_org_uin");
              i1 = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
              String str2 = paramIntent.getStringExtra("forward_download_image_server_path");
              l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
              ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Pic)localObject2).jdField_b_of_type_JavaLangString, str2, (String)localObject3, l1, i1, str1);
              b(true);
              continue;
              if (2 == MarketFaceItemBuilder.m) {
                ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                MarketFaceItemBuilder.a.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
                return;
                ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
              }
            }
          }
          return;
        }
        catch (Throwable paramIntent) {}
      }
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(String paramString)
  {
    a(true);
    getWindow().clearFlags(128);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      a(i1 | 0x20000);
      return;
    }
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b())) {}
    do
    {
      do
      {
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a()));
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    return true;
    if (getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
      moveTaskToBack(true);
    }
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", 0);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
    }
    if ((this.w) || (this.x)) {
      TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      try
      {
        localObject = (PendingIntent)getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if (localObject == null) {}
      }
      catch (Exception localException)
      {
        continue;
      }
      try
      {
        ((PendingIntent)localObject).send();
        return false;
      }
      catch (PendingIntent.CanceledException localCanceledException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("ChatActivity", 4, localCanceledException.getMessage());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Deprecated
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    setVolumeControlStream(paramInt);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "uploadPreviewPhoto");
    }
    ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(AlbumConstants.i, -1));
    Object localObject = null;
    if (paramIntent != null) {
      localObject = paramIntent.getExtras();
    }
    if (localObject == null) {}
    int i1;
    do
    {
      return;
      if (((Bundle)localObject).getBoolean("deleteImage", false))
      {
        b(true);
        return;
      }
      if (paramIntent.getExtras().getBoolean("fromdoodle", false))
      {
        paramIntent = paramIntent.getExtras().getString("filePath");
        if (FileUtils.b(paramIntent))
        {
          localObject = new PicUploadInfo.Builder();
          ((PicUploadInfo.Builder)localObject).a(paramIntent);
          ((PicUploadInfo.Builder)localObject).d(1005);
          ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.jdField_e_of_type_Int);
          ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          ((PicUploadInfo.Builder)localObject).c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          PicReq localPicReq = PicBusiManager.a(1, 1005);
          localPicReq.a(((PicUploadInfo.Builder)localObject).a());
          PicBusiManager.a(localPicReq, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          b(true);
        }
        for (;;)
        {
          ImageUtil.a(this, paramIntent, 6, "ChatActivity", "ChatActivity.uploadPreviewPhoto.fromdoodle");
          return;
          ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.uploadPreviewPhoto:fromdoodle file not exist");
        }
      }
      i1 = paramIntent.getIntExtra(AlbumConstants.i, -1);
    } while ((i1 != 2) && (i1 != 1));
    localObject = paramIntent.getParcelableArrayListExtra("imageInfos");
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (((List)localObject).size() != 1) {
        break label359;
      }
      if (i1 != 1) {
        break label344;
      }
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 1);
    }
    for (;;)
    {
      a((List)localObject, paramIntent.getStringExtra("extra_image_sender_tag"));
      return;
      label344:
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 2);
      continue;
      label359:
      if (((List)localObject).size() > 1) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 4, "" + ((List)localObject).size());
      }
    }
  }
  
  public void c(String paramString)
  {
    a(ChatActivity.RecordStatus.invalid, paramString, this.jdField_e_of_type_Long);
    runOnUiThread(new bzl(this));
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.post(new bzg(this));
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected String c_()
  {
    return "com.tencent.mobileqqi:peak";
  }
  
  @Deprecated
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_e_of_type_Int = paramInt;
      if (!this.jdField_j_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b();
      AudioUtil.a(this, false);
      a(true);
    }
    label126:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      StreamDataManager.a(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Long);
    }
  }
  
  public boolean d()
  {
    QQOperateManager localQQOperateManager = QQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localQQOperateManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {}
    do
    {
      do
      {
        return false;
        if ((this.jdField_o_of_type_AndroidViewView == null) || (this.jdField_o_of_type_AndroidViewView.getVisibility() != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VoiceTipMsg", 2, "tipsForReader bar is visible,return");
      return false;
      if (!c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoiceTipMsg", 2, "multiVideoStatus bar is visible,return");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTipMsg", 2, "showDiscChatFreqBarTip");
    }
    if (this.jdField_l_of_type_AndroidViewView == null)
    {
      this.jdField_l_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903544, null);
      ((TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131232881)).setText(2131563103);
      ((ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131232879)).setImageResource(2130839775);
      this.jdField_l_of_type_AndroidViewView.findViewById(2131232880).setOnClickListener(new bxu(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(this.jdField_l_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
      localQQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
    }
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool2 = false;
    G();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getExtras() != null) {
        bool1 = paramIntent.getExtras().getBoolean("progress2View");
      }
    }
    if (paramInt1 == 2)
    {
      this.jdField_p_of_type_Boolean = false;
      if ((paramInt1 == 5) || (paramInt1 == 2000) || (!a(true))) {
        break label136;
      }
    }
    for (;;)
    {
      return;
      if ((paramInt1 != 2000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!this.w) || (!TroopAssistantManager.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break;
      }
      this.w = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
      break;
      label136:
      if ((paramInt1 == 103) && (!bool1)) {
        b(false);
      }
      while (paramInt2 == 4)
      {
        Object localObject1;
        Object localObject2;
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          localObject1 = paramIntent.getExtras();
          localObject2 = new Intent(this, ChatActivity.class);
          ((Intent)localObject2).putExtras(new Bundle((Bundle)localObject1));
          ((Intent)localObject2).addFlags(268435456);
          ((Intent)localObject2).addFlags(67108864);
          startActivity((Intent)localObject2);
        }
        setResult(4, paramIntent);
        return;
        if ((paramInt1 == 101) && (paramInt2 != -1))
        {
          b(false);
        }
        else if (paramInt2 == -1)
        {
          Object localObject3;
          switch (paramInt1)
          {
          default: 
            break;
          case 0: 
            b(false);
            break;
          case 18: 
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
            }
            if (paramIntent != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
              }
              Object localObject4 = paramIntent.getExtras();
              if (localObject4 != null)
              {
                localObject1 = ((Bundle)localObject4).getString("latitude");
                localObject2 = ((Bundle)localObject4).getString("longitude");
                localObject3 = ((Bundle)localObject4).getString("description");
                String str1 = ((Bundle)localObject4).getString("title");
                str1 = LocaleString.i(getBaseContext(), str1);
                String str2 = ((Bundle)localObject4).getString("summary");
                localObject4 = ((Bundle)localObject4).getString("dianping_id");
                ChatActivityFacade.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, (String)localObject3, str1, str2, (String)localObject4);
              }
            }
            break;
          case 23: 
            localObject1 = new Intent(this, SendPhotoActivity.class);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramIntent.getData().getPath());
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName()).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi").putExtra("extra_image_sender_tag", "ChatActivity.ChatActivityConstants.UPLOAD_WATERMARK_SHOTPHOTO_REQUEST").putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
            startActivity((Intent)localObject1);
            break;
          case 1: 
            ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramIntent, "UPLOAD_SHOTPHOTO_REQUEST");
            break;
          case 10: 
            ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, "ChatActivityConstants.ADD_CUSTOMEMOTION_REQUEST");
            break;
          case 4: 
            c(paramIntent);
            break;
          case 20: 
            b(true);
            getWindow().clearFlags(1024);
            break;
          case 21: 
            a(paramIntent.getExtras());
            break;
          case 2000: 
            bool2 = false;
            bool1 = bool2;
            if (paramIntent != null)
            {
              bool1 = bool2;
              if (paramIntent.getExtras() != null) {
                bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
              }
            }
            if (bool1) {
              finish();
            } else {
              b(false);
            }
            break;
          case 5: 
            switch (paramInt2)
            {
            }
          case 10000: 
            for (;;)
            {
              b(false);
              break;
              n();
            }
          case 5001: 
            localObject3 = paramIntent.getExtras();
            localObject1 = Boolean.valueOf(false);
            localObject2 = "";
            if (((Bundle)localObject3).containsKey("TroopFile_DeleteFile")) {
              localObject1 = Boolean.valueOf(((Bundle)localObject3).getBoolean("TroopFile_DeleteFile"));
            }
            if (((Bundle)localObject3).containsKey("TroopFile_FileName")) {
              localObject2 = ((Bundle)localObject3).getString("TroopFile_FileName");
            }
            if (((Boolean)localObject1).booleanValue()) {
              TroopFileError.a(this, String.format(getString(2131560369), new Object[] { TroopFileUtils.a((String)localObject2) }));
            }
            break;
          case 6001: 
            if (a(paramIntent.getExtras().getString("member_uin"), paramIntent.getExtras().getString("member_display_name"), true)) {
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            }
            this.D = true;
          }
        }
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetTextView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (BaseActivity.a(getIntent())) {
      finish();
    }
    do
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatActivity", 2, "AIOTime doOnCreate start: " + System.currentTimeMillis());
        QLog.d("ChatActivity", 2, "AIOTime super.doOnCreate start: " + System.currentTimeMillis());
      }
      StartupTracker.a(null, "AIO_Start_cost");
      StartupTracker.a(null, "AIO_Super_doOnCreate");
      super.doOnCreate(paramBundle);
      StartupTracker.a("AIO_Super_doOnCreate", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime super.doOnCreate end: " + System.currentTimeMillis());
      }
      long l1 = SystemClock.uptimeMillis();
      if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
      {
        this.F = true;
        paramBundle = new Intent();
        paramBundle.setClass(this, LoginActivity.class);
        paramBundle.addFlags(262144);
        startActivity(paramBundle);
        finish();
        return false;
      }
      if (!b(getIntent()))
      {
        this.F = true;
        finish();
        return false;
      }
      StartupTracker.a(null, "AIO_doOnCreate");
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      setContentView(2130903102);
      getWindow().setBackgroundDrawable(null);
      b(l1);
      D();
      a(getIntent());
      ar();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      a(getIntent(), 1);
      C();
      StartupTracker.a("AIO_doOnCreate", null);
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "AIOTime doOnCreate end: " + System.currentTimeMillis());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c());
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
      }
      StructingMsgItemBuilder.d();
    } while (this.F);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    MsgProxyUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    as();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
    }
    ChatActivityFacade.a();
    AITranslator.a().a(this, true);
    BubbleUtils.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.e();
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.j();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_f_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_i_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_j_of_type_AndroidWidgetTextView.getBackground());
    }
    AioAnimationDetector.a().a();
    ThridAppShareHelper.a().a();
    ETLayoutCache.a().a();
    this.jdField_c_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent start: " + System.currentTimeMillis());
      QLog.d("ChatActivity", 2, "AIOTime super.doOnNewIntent start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_Super_doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    StartupTracker.a("AIO_Super_doOnNewIntent", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime super.doOnNewIntent end: " + System.currentTimeMillis());
    }
    if (isFinishing()) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onNewIntent isFinishing");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (BaseActivity.a(paramIntent))
          {
            QLog.d("ChatActivity", 2, "onNewIntent Invalid Intent");
            finish();
            return;
          }
          if (!ThridAppShareHelper.a().a(paramIntent, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatActivity", 2, "onNewIntent ThridApp to chatactivity");
        return;
        Bundle localBundle = paramIntent.getExtras();
        if ((localBundle == null) || (!localBundle.getBoolean("back_from_emojimall", false))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatActivity", 2, "onNewIntent KEY_EMOJIMALL_CLOSE_BACK to chatactivity");
      return;
      if (!b(paramIntent))
      {
        finish();
        return;
      }
      StartupTracker.a(null, "AIO_doOnNewIntent");
      o(paramIntent);
      p(paramIntent);
      StartupTracker.a("AIO_doOnNewIntent", null);
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "AIOTime doOnNewIntent end: " + System.currentTimeMillis());
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.c();
    }
    TextTranslationItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.d();
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (this.jdField_z_of_type_Boolean) {
      ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711689);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, " read confirm onPause  mReadConfirmHandler");
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
      }
      FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (localFriendManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
        if (l1 >= 1000L) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Open_group", "Stay_open_group", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + (l1 / 1000L + 1L), "", "");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b();
      }
      if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
      }
      if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
      }
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ChatActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ChatActivity", 2, "AIOTime doOnResume start: " + System.currentTimeMillis());
      QLog.d("ChatActivity", 2, "AIOTime super.doOnResume() start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_Super_doOnResume");
    super.doOnResume();
    StartupTracker.a("AIO_Super_doOnResume", "AIO_doOnResume");
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime super.doOnResume() end: " + System.currentTimeMillis());
    }
    Looper.myQueue().addIdleHandler(new bxe(this));
    S();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(131072);
    if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
      T();
    }
    for (;;)
    {
      if (3000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
        U();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711689);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16711689);
      o();
      W();
      StartupTracker.a("AIO_doOnResume", null);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "AIOTime doOnResume end: " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131561803));
    }
  }
  
  protected void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnStart start: " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "AIO_Super_doOnStart");
    super.doOnStart();
    StartupTracker.a("AIO_Super_doOnStart", null);
    StartupTracker.a(null, "AIO_doOnStart");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
    StartupTracker.a("AIO_doOnStart", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnStart end: " + System.currentTimeMillis());
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    super.doOnStop();
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.g();
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  protected void doOnUserLeaveHint()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    super.doOnUserLeaveHint();
  }
  
  public void e()
  {
    boolean bool = false;
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (((FriendManager)localObject).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      }
      TroopProxyActivity.a(this, (Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2000);
      return;
    }
    if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
      localObject = new Intent(this, ChatSettingForTroop.class);
      ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("vistor_type", 1);
    }
    for (;;)
    {
      startActivityForResult((Intent)localObject, 2000);
      return;
      Intent localIntent;
      if (3000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
        localIntent = new Intent(this, DiscussionInfoCardActivity.class);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
        {
          localObject = localIntent;
          if (1004 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
        }
        else
        {
          localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          localObject = localIntent;
        }
      }
      else if (CrmUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = new Intent(this, EnterpriseDetailActivity.class);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("need_finish", true);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      else
      {
        localIntent = new Intent(this, ChatSettingActivity.class);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))) {
            bool = true;
          }
          localIntent.putExtra("isShieldMsgSwitchUnClickable", bool);
        }
        if (1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
        {
          localObject = localIntent;
          if (1004 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
        }
        else
        {
          localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          localObject = localIntent;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
    }
    for (;;)
    {
      this.jdField_C_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.jdField_C_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
      else if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
    }
  }
  
  public boolean e()
  {
    return f();
  }
  
  public void f()
  {
    Object localObject;
    if (this.t)
    {
      localObject = (NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.R, 4000)) {
        break label157;
      }
    }
    label157:
    for (int i1 = ((NewFriendManager)localObject).a();; i1 = 0)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null)
      {
        i1 = ((QQMessageFacade)localObject).f() + i1;
        if (i1 > 0)
        {
          localObject = "" + i1;
          if (i1 > 99) {
            localObject = "99+";
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + (String)localObject + ")");
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807));
      return;
    }
  }
  
  public void f(int paramInt)
  {
    ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(paramInt, false);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void finish()
  {
    L();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localFileTransferManager != null) {
        localFileTransferManager.b();
      }
    }
    super.finish();
  }
  
  protected void g()
  {
    int i1;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i1 = 2130840117;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
      return;
      i1 = 2130840114;
      continue;
      i1 = 2130838032;
    }
  }
  
  @TargetApi(11)
  protected void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.bA + "currenttime:" + System.currentTimeMillis());
    }
    Object localObject2;
    if (paramInt != this.bA)
    {
      if (paramInt != 1) {
        break label404;
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        localObject1 = new Button(this);
        ((Button)localObject1).setId(2131230789);
        ((Button)localObject1).setBackgroundResource(2130839800);
        ((Button)localObject1).setTextSize(2, 14.0F);
        ((Button)localObject1).setTextColor(getResources().getColorStateList(2131362073));
        ((Button)localObject1).setText(2131562219);
        ((Button)localObject1).setOnTouchListener(this);
        int i1 = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).indexOfChild(this.jdField_a_of_type_AndroidWidgetEditText);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, i1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setSelected(false);
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject1 = new ImageSpan(this, 2130837653);
        localObject2 = new SpannableString(getResources().getString(2131559039));
        ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = ((SpannableString)localObject2);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      if (VersionUtils.e())
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    for (;;)
    {
      this.bA = paramInt;
      aq();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label404:
      if (paramInt != 2) {
        break;
      }
      localObject1 = ((TroopGagMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        localObject2 = new TextView(this);
        ((TextView)localObject2).setId(2131230855);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-7829368);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setEnabled(false);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(0, this.jdField_c_of_type_AndroidWidgetImageView.getId());
        localLayoutParams.leftMargin = 5;
        localLayoutParams.topMargin = 25;
        localLayoutParams.bottomMargin = 2;
        localLayoutParams.rightMargin = 5;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, localLayoutParams);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      }
      if (localObject1 != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((TroopGagMgr.SelfGagInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidTextSpannableString == null)
      {
        localObject1 = new ImageSpan(this, 2130837715);
        localObject2 = new SpannableString(getResources().getString(2131559038));
        ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
        this.jdField_b_of_type_AndroidTextSpannableString = ((SpannableString)localObject2);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e())
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.6F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(0.6F);
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    Object localObject1 = this.jdField_e_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ImageView)localObject1).setSelected(bool);
      if (this.jdField_b_of_type_AndroidTextSpannableString == null)
      {
        localObject1 = new ImageSpan(this, 2130837715);
        localObject2 = new SpannableString(getResources().getString(2131559038));
        ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
        this.jdField_b_of_type_AndroidTextSpannableString = ((SpannableString)localObject2);
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {}
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      if (!VersionUtils.e()) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
      this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      break;
    }
  }
  
  public boolean g()
  {
    return PublicAccountChatActivity.class.isInstance(this);
  }
  
  public void h()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004)) {
      localObject = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          localObject = ((PhoneContact)localObject).name;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) {
          localObject = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        String str = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
        if (str != null)
        {
          localObject = str;
          if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1005)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = str;
          }
        }
      }
    }
  }
  
  public void h(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new bzf(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 16711689: 
    case 16711681: 
    case 16711683: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
    case 16711688: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
    case 21: 
      do
      {
        do
        {
          do
          {
            return true;
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivity", 2, "read confirm send readconfirm");
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711689, 300000L);
            ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            return true;
            paramMessage = (String)paramMessage.obj;
          } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage));
          finish();
          return true;
          QQToast.a(this, 2131563033, 1).b(d());
          return true;
          ac();
          return true;
          d(2);
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b();
          if (this.jdField_e_of_type_Long == 0L) {
            f(2131165209);
          }
          AudioUtil.a(this, false);
          return true;
          a(ChatActivity.RecordStatus.standby, null, -1L);
          return true;
        } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f();
        return true;
        X();
        return true;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMessage.arg1);
          k(paramMessage.arg1);
          return true;
        }
        k(paramMessage.arg1);
        return true;
        d(paramMessage.arg1, paramMessage.arg2);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "delay MSG_START_VER_ANIM msg is handled,time is:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.obj);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 300L);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null)) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_AndroidViewView = null;
        this.jdField_a_of_type_AndroidViewViewGroup = null;
        a(196612);
        return true;
        b(false);
        return true;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d();
      return true;
    case 22: 
      e((String)paramMessage.obj);
      return true;
    case 23: 
      g(0);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return true;
    }
    finish();
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624452);
      ImageView localImageView = new ImageView(this);
      localImageView.setBackgroundResource(2130837652);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(paramInt);
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void k()
  {
    boolean bool1 = false;
    Object localObject;
    if (!this.jdField_o_of_type_Boolean)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (!g()) {
        break label32;
      }
    }
    label32:
    do
    {
      do
      {
        return;
        localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (ContactUtils.a(((Friends)localObject).status, ((Friends)localObject).detalStatusFlag, ((Friends)localObject).isMqqOnLine, ((Friends)localObject).sqqOnLineState, ((Friends)localObject).iTermType) != 0))
        {
          int i1 = ((Friends)localObject).status;
          int i2 = ((Friends)localObject).detalStatusFlag;
          boolean bool2 = ((Friends)localObject).isMqqOnLine;
          int i3 = ((Friends)localObject).sqqOnLineState;
          if (((Friends)localObject).isIphoneOnline == 1) {
            bool1 = true;
          }
          localObject = ContactUtils.a(this, i1, i2, bool2, i3, bool1, ((Friends)localObject).iTermType, ((Friends)localObject).getNetWorkType());
          d(true);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
          return;
        }
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
      d(false);
      if ((this.m != null) && (this.m.getVisibility() == 0))
      {
        ChatActivityFacade.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        Y();
        return;
      }
    } while ((this.n == null) || (this.n.getVisibility() != 0));
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006)
    {
      Intent localIntent = new Intent(this, AddFriendLogicActivity.class);
      localIntent.putExtra("type", 3);
      localIntent.putExtra("source_id", 3006);
      localIntent.putExtra("param_last_activity_name", a_());
      localIntent.putExtra("uin", "");
      localIntent.putExtra("friend_mobile_number", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("friend_mobile_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      startActivity(localIntent);
    }
  }
  
  public void m()
  {
    ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(2131165198, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a().getCount() - 1);
    }
  }
  
  void o()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    if (localSVIPHandler.a()) {
      localSVIPHandler.a();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    case 2131230793: 
    default: 
    case 2131231455: 
    case 2131231460: 
    case 2131230788: 
    case 2131231203: 
    case 2131230785: 
    case 2131231206: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            ab();
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d("reportEvent", 4, " curType : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            }
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", "", "");
            return;
            this.bx = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
            if (this.bx > 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a() - 1);
            }
            paramView.setVisibility(8);
            return;
            if (!a(true))
            {
              long l1 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " onClick fun_btn start mInputStat = " + this.bA + " text.length " + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "currenttime:" + System.currentTimeMillis());
              }
              if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) {
                this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
              }
              for (;;)
              {
                if (!QLog.isColorLevel()) {
                  break label416;
                }
                long l2 = System.currentTimeMillis();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("SendMsgBtn", 2, " onClick fun_btn end mInputStat = " + this.bA + "text.length" + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "cast time :" + (l2 - l1));
                return;
                this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
              }
            }
          }
          Intent localIntent = (Intent)paramView.getTag();
          if (localIntent.getExtras().getInt("uintype") == 0)
          {
            String str = localIntent.getExtras().getString("uin");
            if (!ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str))
            {
              localIntent.removeExtra("uintype");
              localIntent.putExtra("uintype", 1003);
            }
          }
          localIntent.putExtra("message_box_click", true);
          startActivity(localIntent);
          paramView.setVisibility(8);
          if (this.jdField_d_of_type_AndroidViewView != null) {
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          }
        } while (!this.w);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
        TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
      } while (this.bA == 1);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      return;
    case 2131231208: 
      label416:
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
        b();
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131563123));
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
          this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562120));
          g(0);
        }
      }
    }
    paramView = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!this.jdField_b_of_type_Boolean) {
      bool = true;
    }
    paramView.f(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 230: 
      this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2130903165);
      localTextView1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231468);
      localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231029);
      TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231471);
      TextView localTextView3 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231472);
      localTextView1.setText(2131562320);
      ((TextView)localObject).setText(2131561967);
      localTextView3.setText(2131562770);
      localTextView3.setOnClickListener(new bxf(this));
      localTextView2.setText(2131561746);
      localTextView2.setOnClickListener(new bxh(this));
      return this.jdField_b_of_type_AndroidAppDialog;
    case 231: 
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2130903073);
      ((TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131231029)).setText(2131562294);
      return this.jdField_c_of_type_AndroidAppDialog;
    case 232: 
      this.jdField_d_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2130904013);
      localTextView1 = (TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131232723);
      localObject = (ImageView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131231016);
      localTextView1.setText(2131562776);
      ((ImageView)localObject).setImageResource(2130837960);
      return this.jdField_d_of_type_AndroidAppDialog;
    }
    this.jdField_e_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
    this.jdField_e_of_type_AndroidAppDialog.setContentView(2130904013);
    TextView localTextView1 = (TextView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131232723);
    Object localObject = (ImageView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131231016);
    localTextView1.setText(2131562773);
    ((ImageView)localObject).setImageResource(2130837949);
    return this.jdField_e_of_type_AndroidAppDialog;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      return bool;
    case 2131231491: 
      this.jdField_b_of_type_AndroidWidgetImageView.performClick();
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.performClick();
    switch (paramMenuItem.getOrder())
    {
    case 0: 
    default: 
      return true;
    }
    e();
    return true;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    H();
    av();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPrepareDialog(paramInt, paramDialog);
      return;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bxi(this), 1000L);
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "onPrepareOptionsMenu");
    }
    paramMenu.clear();
    Object localObject;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetImageView.getDrawable() != null))
    {
      localObject = paramMenu.findItem(2131231491);
      if (localObject == null) {
        break label272;
      }
      ((MenuItem)localObject).setIcon(this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null))
      {
        localObject = paramMenu.add(0, 2131231460, 1, "");
        ((MenuItem)localObject).setTitle(getString(2131559925));
        ((MenuItem)localObject).setIcon(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
        MenuItemCompat.setShowAsAction((MenuItem)localObject, 1);
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null))
      {
        localObject = getSupportActionBar();
        if (localObject != null) {
          ((ActionBar)localObject).setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
      }
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetTextView.getText() != null) && (!this.jdField_c_of_type_AndroidWidgetTextView.getText().toString().equals("")))
      {
        localObject = getSupportActionBar();
        if (localObject != null) {
          ((ActionBar)localObject).setSubtitle(this.jdField_c_of_type_AndroidWidgetTextView.getText());
        }
      }
      return super.onPrepareOptionsMenu(paramMenu);
      label272:
      localObject = paramMenu.add(0, 2131231491, 0, 2131563192);
      ((MenuItem)localObject).setIcon(this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
      MenuItemCompat.setShowAsAction((MenuItem)localObject, 1);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString.length() != 0)) {
      if ((paramInt3 == 1) && (paramCharSequence.charAt(paramInt1) == '@') && (!this.E))
      {
        paramCharSequence = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (!paramCharSequence.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          paramCharSequence = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (paramCharSequence != null)
          {
            localIntent = new Intent(this, TroopMemberListActivity.class);
            localIntent.putExtra("troop_code", paramCharSequence.troopuin);
            localIntent.putExtra("troop_uin", paramCharSequence.troopcode);
            localIntent.putExtra("mode", 2);
            startActivityForResult(localIntent, 6001);
          }
        }
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0) || (paramInt3 != 1) || (paramCharSequence.charAt(paramInt1) != '@') || (this.E))
    {
      Intent localIntent;
      return;
    }
    paramCharSequence = new Intent(this, TroopMemberListActivity.class);
    paramCharSequence.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramCharSequence.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramCharSequence.putExtra("mode", 2);
    paramCharSequence.putExtra("param_from", 2);
    startActivityForResult(paramCharSequence, 6001);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == paramView)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.a(paramView, paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    switch (paramView.getId())
    {
    default: 
      bool = false;
    case 2131232866: 
      return bool;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
    }
    if (i1 == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
    }
    for (;;)
    {
      return false;
      if ((i1 == 1) || (i1 == 3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
      }
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void q()
  {
    b(true, this.jdField_b_of_type_Boolean);
    getWindow().addFlags(128);
  }
  
  public void r()
  {
    setVolumeControlStream(3);
    b(false, false);
    j();
    getWindow().clearFlags(128);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    getWindow().setFormat(-3);
  }
  
  public void s()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
  }
  
  public void t()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    v();
    bzb localbzb = new bzb(this, this);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(localbzb, 60L);
        return;
      }
      localbzb.run();
      return;
    }
  }
  
  public void u_()
  {
    Intent localIntent = new Intent(this, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    MessageRecord localMessageRecord;
    int i2;
    int i1;
    if ((paramObject instanceof MessageRecord)) {
      if ((paramObject instanceof ChatMessage))
      {
        localMessageRecord = (MessageRecord)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "update mr.msgseq" + localMessageRecord.msgseq + ",time is:" + System.currentTimeMillis());
        }
        if ((!AioAnimationDetector.a().jdField_a_of_type_Boolean) && (isResume()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == localMessageRecord.istroop) || ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.a(localMessageRecord.istroop)))))
        {
          i2 = 0;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
            break label457;
          }
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      Object localObject;
      if ((i1 != 0) || (i2 != 0))
      {
        paramObservable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        paramObject = AioAnimationDetector.a();
        l1 = paramObject.jdField_a_of_type_Long;
        i2 = paramObservable.size() - 1;
        if (i2 >= 0)
        {
          localObject = (ChatMessage)paramObservable.get(i2);
          if (i1 == 0) {
            break label579;
          }
          if (((ChatMessage)localObject).shmsgseq > l1) {
            break label478;
          }
        }
      }
      label263:
      if ((!MessageUtils.a(localMessageRecord.msgtype)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == localMessageRecord.istroop) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)))
      {
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        i2 = paramObject.size();
        if ((paramObject != null) && (i2 > 0))
        {
          paramObservable = new ArrayList();
          i1 = i2 - 1;
          if (i1 >= 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
            {
              localObject = (ChatMessage)paramObject.get(i1);
              if ((localObject == null) || (((ChatMessage)localObject).time <= this.jdField_a_of_type_Long)) {
                break label775;
              }
              if (((ChatMessage)localObject).uniseq != this.jdField_b_of_type_Long) {
                paramObservable.add(localObject);
              }
            }
            for (;;)
            {
              i1 -= 1;
              break label386;
              label457:
              if (!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
                break label1940;
              }
              i2 = 1;
              i1 = 0;
              break;
              label478:
              ArrayList localArrayList;
              if (!((ChatMessage)localObject).isAioAnimChecked)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(AioAnimationDetector.jdField_a_of_type_JavaLangString, 2, "handle troop&discussion new message ===> (" + ((ChatMessage)localObject).shmsgseq + ")");
                }
                localArrayList = paramObject.a((ChatMessage)localObject);
                if (localArrayList != null) {
                  paramObject.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, true, (ChatMessage)localObject, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 0);
                }
                paramObject.jdField_a_of_type_Long = ((ChatMessage)localObject).shmsgseq;
              }
              for (;;)
              {
                i2 -= 1;
                break;
                label579:
                if (((ChatMessage)localObject).time <= l1) {
                  break label263;
                }
                if (!((ChatMessage)localObject).isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(AioAnimationDetector.jdField_a_of_type_JavaLangString, 2, "handle c2c new message ===> (" + ((ChatMessage)localObject).time + ")");
                  }
                  localArrayList = paramObject.a((ChatMessage)localObject);
                  if (localArrayList != null) {
                    paramObject.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, false, (ChatMessage)localObject, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 0);
                  }
                  paramObject.jdField_a_of_type_Long = ((ChatMessage)localObject).time;
                }
              }
              this.jdField_a_of_type_Long = ((ChatMessage)localObject).time;
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
              {
                localObject = (ChatMessage)paramObject.get(i1);
                if ((localObject == null) || (((ChatMessage)localObject).shmsgseq <= this.jdField_a_of_type_Long)) {
                  break label775;
                }
                if (((ChatMessage)localObject).uniseq != this.jdField_b_of_type_Long) {
                  paramObservable.add(localObject);
                } else {
                  this.jdField_a_of_type_Long = ((ChatMessage)localObject).shmsgseq;
                }
              }
            }
          }
          if (paramObservable.size() > 0)
          {
            paramObject = (ChatMessage)paramObject.get(i2 - 1);
            if (paramObject != null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
                break label1352;
              }
              this.jdField_a_of_type_Long = paramObject.time;
              this.jdField_b_of_type_Long = paramObject.uniseq;
            }
            paramObject = QQOperateManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            paramObservable = paramObject.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable, false, -1);
            if (paramObservable.jdField_a_of_type_Boolean)
            {
              paramObservable = paramObservable.jdField_a_of_type_JavaUtilArrayList;
              paramObject.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObservable, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
      }
      label386:
      label775:
      if (!localMessageRecord.isSendFromLocal())
      {
        if ((localMessageRecord.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin))) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == localMessageRecord.istroop) || ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.a(localMessageRecord.istroop)))))
        {
          if (isResume())
          {
            if ((!localMessageRecord.isread) && ((localMessageRecord instanceof MessageForShakeWindow)))
            {
              paramObservable = (MessageForShakeWindow)localMessageRecord;
              paramObservable.parse();
              if ((paramObservable.mShakeWindowMsg != null) && (paramObservable.mShakeWindowMsg.onlineFlag == 1))
              {
                if (this.jdField_a_of_type_JavaUtilList == null) {
                  this.jdField_a_of_type_JavaUtilList = new ArrayList();
                }
                this.jdField_a_of_type_JavaUtilList.add(paramObservable);
              }
            }
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if ((!SystemMsg.isTroopSystemMessage(localMessageRecord.msgtype)) && (!"1000000".equalsIgnoreCase(localMessageRecord.senderuin)) && (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null))
            {
              localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop);
              if (((QQMessageFacade.Message)localObject).uniseq == localMessageRecord.uniseq)
              {
                paramObject = ((QQMessageFacade.Message)localObject).nickName;
                paramObservable = paramObject;
                if (((QQMessageFacade.Message)localObject).selfuin != null)
                {
                  paramObservable = paramObject;
                  if (((QQMessageFacade.Message)localObject).selfuin.equals(((QQMessageFacade.Message)localObject).senderuin)) {
                    paramObservable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
                  }
                }
                paramObject = new MsgSummary();
                MsgUtils.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObject, paramObservable, true, false);
                paramObject = paramObject.a(this);
                this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(paramObservable, paramObject);
              }
            }
            this.jdField_z_of_type_Boolean = true;
            this.jdField_A_of_type_Boolean = true;
            a(196608);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (localMessageRecord.msgtype == -3001))
          {
            paramObservable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == -3001)) {
              OpenAppClient.a(getApplicationContext(), paramObservable.action);
            }
          }
          this.jdField_f_of_type_Boolean = true;
        }
        for (;;)
        {
          runOnUiThread(new bxk(this));
          return;
          label1352:
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          this.jdField_a_of_type_Long = paramObject.shmsgseq;
          this.jdField_b_of_type_Long = paramObject.uniseq;
          break;
          if ((localMessageRecord.istroop == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(localMessageRecord.senderuin)) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
          {
            if ((String.valueOf(AppConstants.U).equalsIgnoreCase(localMessageRecord.frienduin)) && (!localMessageRecord.isread))
            {
              a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
            }
            else
            {
              if (isResume())
              {
                this.jdField_A_of_type_Boolean = true;
                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                a(196608);
              }
              this.jdField_f_of_type_Boolean = true;
            }
          }
          else if ((isResume()) && (!localMessageRecord.isread)) {
            a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
          }
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      this.jdField_z_of_type_Boolean = true;
      this.jdField_f_of_type_Boolean = true;
      b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.e();
      }
      runOnUiThread(new bxl(this));
      return;
      if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = ((QQMessageFacade.RefreshMessageContext)paramObject);
        if (!(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject instanceof ChatContext)) {
          break;
        }
        paramObservable = (ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.a())) || (this.jdField_d_of_type_Long != paramObservable.a()) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Boolean)) {
          break;
        }
        boolean bool;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean)
        {
          bool = true;
          this.v = bool;
          l1 = this.jdField_d_of_type_Long + 300L - SystemClock.uptimeMillis();
          if (l1 <= 0L) {
            break label1796;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new bxm(this), l1);
          return;
          bool = false;
          break;
          label1796:
          l1 = 0L;
        }
      }
      if ((paramObject instanceof QQMessageFacade.MessageNotifyParam))
      {
        paramObservable = (QQMessageFacade.MessageNotifyParam)paramObject;
        if ((!paramObservable.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramObservable.jdField_b_of_type_Int != 0)) {
          break;
        }
        b(false);
        return;
      }
      if (!(paramObject instanceof TroopAioAgent.Message)) {
        break;
      }
      paramObservable = (TroopAioAgent.Message)paramObject;
      if (paramObservable == null) {
        break;
      }
      if (paramObservable.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int)
      {
        if (paramObservable.jdField_c_of_type_Int == 1)
        {
          a(paramObservable.jdField_c_of_type_Int, paramObservable.jdField_a_of_type_Long);
          return;
        }
        a(paramObservable.jdField_c_of_type_Int, paramObservable.jdField_b_of_type_Long);
        return;
      }
      if ((paramObservable.jdField_a_of_type_Int != TroopAioAgent.jdField_b_of_type_Int) || (this.jdField_e_of_type_AndroidViewView == null)) {
        break;
      }
      ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObservable.jdField_b_of_type_Int);
      return;
      label1940:
      i1 = 0;
    }
  }
  
  public void v()
  {
    ((ViewGroup)getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_f_of_type_AndroidViewView.getParent()).removeView(this.jdField_f_of_type_AndroidViewView);
    }
    this.jdField_f_of_type_AndroidViewView = null;
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCameraFrameLayoutProxy.d();
    }
  }
  
  public void x()
  {
    int i1 = PttItemBuilder.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int i2 = VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i2 & 0x4) != 0) {
      i1 = PttItemBuilder.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, i1 - 200);
      return;
      if ((i2 & 0x2) != 0) {
        i1 = PttItemBuilder.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */