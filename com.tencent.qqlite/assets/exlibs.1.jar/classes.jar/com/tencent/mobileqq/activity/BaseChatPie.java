package com.tencent.mobileqq.activity;

import aaa;
import aab;
import aac;
import aae;
import aag;
import aah;
import aai;
import aaj;
import aak;
import aao;
import aap;
import aaq;
import aar;
import aas;
import aat;
import aau;
import aav;
import aaw;
import aax;
import aay;
import aaz;
import aba;
import abb;
import abc;
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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import com.tencent.theme.SkinEngine;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import zg;
import zh;
import zi;
import zj;
import zk;
import zl;
import zm;
import zn;
import zo;
import zp;
import zq;
import zr;
import zs;
import zt;
import zu;
import zv;
import zw;
import zx;
import zy;
import zz;

public class BaseChatPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, MediaPlayerManager.Listener, CheckPttListener, VibrateListener, ChatXListView.OnBottomOverScrollListener, EmoticonCallback, AbsListView.OnScrollListener, OverScrollViewListener, XPanelContainer.PanelCallback, Observer
{
  protected static final int b = 200;
  public static final String b = "is_from_manage_stranger";
  private static final int bR = 1;
  private static final int bS = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  private static boolean v = false;
  private String H;
  public float a;
  protected int a;
  long jdField_a_of_type_Long;
  private aaz jdField_a_of_type_Aaz;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new zn(this);
  public final Handler a;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public View a;
  protected ViewGroup a;
  public EditText a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  protected RelativeLayout a;
  public TextView a;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  public AIOTipsController a;
  public ChatAdapter1 a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  protected PlusPanel a;
  public SessionInfo a;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  public FraudTipsBar a;
  public QQOperateTips a;
  protected TipsManager a;
  public BaseActivity a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aah(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new aag(this);
  protected FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new aae(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  public QQMessageFacade.RefreshMessageContext a;
  public ChatXListView a;
  protected ChatMessage a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  private SogouEmoji jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji;
  protected EmoticonMainPanel a;
  private EmotionPreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout;
  private FastImagePreviewLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public TroopAioTips a;
  protected QQRecorder a;
  public QQProgressDialog a;
  protected ScrollerRunnable a;
  public ToastStyleDialog a;
  public XPanelContainer a;
  protected CharSequence a;
  public Runnable a;
  public final String a;
  public Comparator a;
  protected List a;
  protected boolean a;
  protected long b;
  public Dialog b;
  private SpannableString jdField_b_of_type_AndroidTextSpannableString;
  protected View b;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public TextView b;
  private ToastStyleDialog jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  public Comparator b;
  private List jdField_b_of_type_JavaUtilList;
  protected boolean b;
  private final int bM = 300;
  private int bN = 0;
  private int bO = 1;
  private int bP = 0;
  private int bQ = 1;
  private int bT = 0;
  private int bU = 0;
  private int bV = 0;
  private int bW;
  protected int c;
  protected long c;
  public Dialog c;
  private View c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  protected String c;
  public boolean c;
  public Dialog d;
  private View d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  protected String d;
  public boolean d;
  private long jdField_e_of_type_Long;
  public Dialog e;
  private View jdField_e_of_type_AndroidViewView = null;
  protected ImageView e;
  protected TextView e;
  public boolean e;
  private long jdField_f_of_type_Long;
  public Dialog f;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  public TextView f;
  public boolean f;
  protected int g;
  private long jdField_g_of_type_Long = -1L;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private TextView h;
  protected boolean h;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  boolean jdField_i_of_type_Boolean = false;
  private TextView j;
  public volatile boolean j;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  boolean jdField_k_of_type_Boolean = true;
  protected boolean l = true;
  private boolean n;
  private boolean o;
  private boolean p = true;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean w = true;
  private boolean x = false;
  private boolean y = true;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_JavaLangString = "ChatActivity";
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 131074;
    this.jdField_c_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new zu(this);
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilComparator = new aap(this);
    this.jdField_b_of_type_JavaUtilComparator = new aaq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    String str1;
    if (paramInt2 == -1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        String str2 = "";
        String str3 = "";
        str1 = str2;
        paramString = str3;
        if (paramInt1 == 2)
        {
          Friends localFriends = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          str1 = str2;
          paramString = str3;
          if (localFriends != null)
          {
            str1 = "" + ContactUtils.a(localFriends);
            paramString = "" + ContactUtils.a(localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clt", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "msg", paramInt1 + "", "", "", str1, paramString, this.bO + "");
        this.bO = 0;
      }
    }
    for (;;)
    {
      return;
      str1 = null;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
      while (str1 != null)
      {
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "pic", "", paramInt2 + "", paramString, "", "", "");
        return;
        str1 = "clt";
        continue;
        str1 = "grp";
        continue;
        str1 = "discuss";
      }
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m;
    if (paramBoolean3) {
      m = 2131363182;
    }
    for (;;)
    {
      QQToast.a(paramContext, m, 0).b(paramContext.getResources().getDimensionPixelSize(2131492887));
      return;
      if (paramBoolean2) {
        m = 2131363183;
      } else if (paramBoolean1) {
        m = 2131363181;
      } else {
        m = 2131363180;
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
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362483);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new zh(this, paramAbsShareMsg, localBaseActivity);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    a(2, paramString, paramLong);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true);
    if (paramLong == 0L) {
      StreamDataManager.a(paramString);
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    int i1 = StreamDataManager.a(paramString);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    int m;
    if (paramLong == 0L)
    {
      m = 1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      if (m == 0) {
        break label220;
      }
      MessageRecord localMessageRecord = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      ((MessageForPtt)localMessageRecord).c2cViaOffline = true;
      paramLong = localMessageRecord.uniseq;
    }
    label220:
    for (;;)
    {
      if ((m != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)) {
        StreamDataManager.a(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong + ",time is:" + i1);
      }
      if (i1 >= 512)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString, paramLong, false);
        d(paramInt1, paramInt2);
      }
      a(0, paramString, paramLong);
      return;
      m = 0;
      break;
    }
  }
  
  private void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "showAddFriendAndShield() ==== called.");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
      {
        Object localObject2 = new aac(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296350);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492998));
        localLayoutParams.addRule(10);
        this.jdField_j_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_j_of_type_AndroidWidgetTextView.setGravity(17);
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364294));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
            break label788;
          }
          this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(false);
          this.jdField_j_of_type_AndroidWidgetTextView.setClickable(false);
          label254:
          this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427491));
          this.jdField_j_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492871));
          this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837588));
          this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject2);
          Object localObject3 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_j_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
          localObject3 = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((View)localObject3).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427446));
          LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(1, -1);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, localLayoutParams1);
          this.jdField_k_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_k_of_type_AndroidWidgetTextView.setGravity(17);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362985));
          this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427491));
          this.jdField_k_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492871));
          this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837588));
          this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_k_of_type_AndroidWidgetTextView.getText());
          this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject2);
          this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
          localObject2 = new LinearLayout.LayoutParams(0, -1);
          ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_k_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131296350);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, 0, localLayoutParams);
        }
      }
      else
      {
        if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
          break label807;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131364294));
        this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296670);
        localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        localLayoutParams.topMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131492998));
        ((View)localObject1).setLayoutParams(localLayoutParams);
        return;
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362987));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
          break;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362986));
        this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        break;
        label788:
        this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_j_of_type_AndroidWidgetTextView.setClickable(true);
        break label254;
        label807:
        if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362987));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
        }
        else
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362986));
          this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
        }
      }
    }
  }
  
  private void ab()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296670);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localView.setLayoutParams(localLayoutParams);
  }
  
  private void ac()
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.H = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_h_of_type_Boolean = true;
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (this.H == null) {}
    for (String str = "";; str = this.H)
    {
      localEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
      this.jdField_h_of_type_Boolean = false;
      return;
    }
  }
  
  private void ad()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((!StringUtil.b(this.H)) || (!StringUtil.b(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
        break label65;
      }
    }
    label65:
    while ((this.H != null) && (this.H.equals(String.valueOf(this.jdField_a_of_type_AndroidWidgetEditText.getText())))) {
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetEditText.getText());
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    DraftSummaryInfo localDraftSummaryInfo = this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (localDraftSummaryInfo != null)
    {
      localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localDraftSummaryInfo.getSummary(), localDraftSummaryInfo.getTime());
      return;
    }
    localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, "", 0L);
  }
  
  private void ae()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void af()
  {
    am();
    if (this.jdField_a_of_type_Int == 0) {}
    label11:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
      return;
    }
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i8 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    int i6 = this.jdField_a_of_type_Int;
    Object localObject1;
    label112:
    int i2;
    int i7;
    int i1;
    int i4;
    switch (this.jdField_a_of_type_Int & 0xFFFF0000)
    {
    default: 
      localObject1 = localList1;
      i2 = this.bN;
      i7 = localList1.size();
      i1 = ((List)localObject1).size();
      i4 = this.jdField_a_of_type_Int & 0xFFFF;
      if ((i4 == 0) && (this.jdField_c_of_type_AndroidViewView == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1))) {
        i4 = 2;
      }
      break;
    }
    for (;;)
    {
      int m;
      long l1;
      switch (i4)
      {
      case 4: 
      default: 
        m = i2;
        if (localList1 != localObject1)
        {
          if ((i7 <= 0) || (i1 <= 0)) {
            break label1537;
          }
          l1 = ((ChatMessage)localList1.get(i7 - 1)).uniseq;
          m = i1 - 1;
          if (m < 0) {
            break label1537;
          }
          if (((ChatMessage)((List)localObject1).get(m)).uniseq != l1) {
            break label1226;
          }
          label281:
          if (m < 0) {
            break label1233;
          }
          m = i1 - (i7 - this.bN + i1 - 1 - m);
        }
        break;
      }
      label301:
      label370:
      boolean bool;
      for (;;)
      {
        if (i4 == 5)
        {
          m = this.bN;
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), -1, null);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362497), 3000).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          m = i1 - (i7 - m);
          if ((!this.p) || (i1 == 0)) {
            break label1338;
          }
          bool = true;
          label384:
          e(bool);
          this.jdField_a_of_type_Int = 0;
          this.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.bN = m;
          switch (i6 & 0xFFFF0000)
          {
          default: 
            label440:
            if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
            {
              localObject1 = (MessageForShakeWindow)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
              if (!((MessageForShakeWindow)localObject1).isSendFromLocal()) {
                break label1373;
              }
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new zq(this, (MessageForShakeWindow)localObject1), 20L);
              this.jdField_b_of_type_JavaUtilList.clear();
            }
            label513:
            if (m != i1) {
              break label11;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
            localObject1 = localList1;
            break label112;
            List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(localList2);
            }
            Object localObject2;
            if ((this.r) && (localList2.size() > 0))
            {
              ChatMessage localChatMessage = (ChatMessage)localList2.get(localList2.size() - 1);
              localChatMessage.mAnimFlag = true;
              localChatMessage.mPendantAnimatable = true;
              if ((localChatMessage instanceof MessageForMarketFace))
              {
                localObject2 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localChatMessage.parse();
                  localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
                }
                if ((((MarkFaceMessage)localObject1).mobileparam != null) && (((MarkFaceMessage)localObject1).mobileparam.length > 0) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
                  ((MessageForMarketFace)localChatMessage).needToPlay = true;
                }
              }
            }
            localObject1 = ChatActivityUtils.a(localList2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (this.jdField_a_of_type_Boolean)
            {
              localObject2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (MessageRecord)localObject1);
              if (localObject2 == null) {
                break label832;
              }
              a(true);
              this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject2);
            }
            for (;;)
            {
              localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(localList2, (CharSequence)localObject1);
              localObject1 = localList2;
              break;
              label832:
              a(false);
            }
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1, 0);
            m = i1;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1);
            m = i1;
            continue;
            m = i2;
            if (i7 > 0)
            {
              m = i2;
              if (i5 >= 0)
              {
                i3 = -1;
                i2 = i3;
                if (i1 <= 0) {
                  break label1542;
                }
                l1 = ((ChatMessage)localList1.get(i5)).uniseq;
                i2 = 0;
                label926:
                m = i3;
                if (i2 < i1)
                {
                  if (((ChatMessage)((List)localObject1).get(i2)).uniseq == l1) {
                    m = i2;
                  }
                }
                else
                {
                  i2 = m;
                  if (m >= 0) {
                    break label1542;
                  }
                  i2 = m;
                  if (localList1.size() <= i5 + 1) {
                    break label1542;
                  }
                  l1 = ((ChatMessage)localList1.get(i5 + 1)).uniseq;
                  i3 = 0;
                  label1000:
                  i2 = m;
                  if (i3 >= i1) {
                    break label1542;
                  }
                  if (((ChatMessage)((List)localObject1).get(i3)).uniseq != l1) {
                    break label1086;
                  }
                  i2 = i3;
                }
              }
            }
            break;
          }
        }
      }
      label1537:
      label1542:
      for (int i3 = 1;; i3 = 0)
      {
        if (i2 >= 0)
        {
          i5 = this.bN + i2;
          m = i5;
          if (i3 != 0) {
            m = i5 - 1;
          }
          if ((i8 < 0) && (i2 == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.B();
            break label301;
            i2 += 1;
            break label926;
            label1086:
            i3 += 1;
            break label1000;
          }
          if (i8 < 0)
          {
            i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k()).getBottom();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i2 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), i3 - i5 + i8);
            break label301;
          }
          i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
          i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k()).getBottom();
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i2 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k(), i3 - i5);
          break label301;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.C();
        m = i1;
        break label301;
        label1226:
        m -= 1;
        break;
        label1233:
        m = i1;
        break label301;
        if (i4 == 6)
        {
          i3 = this.bN;
          i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
          m = 0;
          label1261:
          if (m < i2)
          {
            localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(m);
            if ((localObject1 == null) || (((ChatMessage)localObject1).msgtype != -4009)) {}
          }
          for (;;)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
            if (m == 0) {}
            for (i2 = 0;; i2 = -1)
            {
              ((ScrollerRunnable)localObject1).a(m, i2, null);
              m = i1 - (i7 - i3);
              break;
              m += 1;
              break label1261;
            }
            label1338:
            bool = false;
            break label384;
            if (!this.jdField_j_of_type_Boolean) {
              break label440;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1001, new Object[0]);
            this.jdField_j_of_type_Boolean = false;
            break label440;
            label1373:
            l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + ((MessageForShakeWindow)localObject1).shmsgseq + ",msgUid is:" + ((MessageForShakeWindow)localObject1).msgUid + ",uniseq is:" + ((MessageForShakeWindow)localObject1).uniseq + ",onlineStatus is:" + l1 + ",userActiveStatus is:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao);
            }
            if ((l1 != 11L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ao != 0)) {
              break label513;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new zs(this, (MessageForShakeWindow)localObject1), 20L);
            break label513;
            m = 0;
          }
        }
        break label370;
        m = -1;
        break label281;
      }
    }
  }
  
  private void ag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void ah()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout = ((EmotionPreviewLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903060, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131296663);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    }
  }
  
  private void ai()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onShow_videoStatus: mEnterExtPanel = " + this.bP + ", mExtPanelOnResumeTimes = " + this.bQ);
    }
    if (this.bP != 0)
    {
      int m = this.bQ - 1;
      this.bQ = m;
      if (m == 0)
      {
        if (this.bP != 1) {
          break label101;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new zz(this));
      }
    }
    for (;;)
    {
      this.bP = 0;
      return;
      label101:
      if (this.bP == 4) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new aaa(this));
      }
    }
  }
  
  private void aj()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    if (this.u)
    {
      m(true);
      this.u = false;
    }
    this.jdField_e_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363071), "qqsetting_enter_sendmsg_key", false);
    String str;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(4);
      if (this.jdField_a_of_type_Aaz == null) {
        this.jdField_a_of_type_Aaz = new aaz(this, null);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_Aaz);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_Aaz);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("refuse_show_share_result_dialog", false);
      if ((this.jdField_f_of_type_Boolean) && (!bool) && (this.jdField_k_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
        str = ((Bundle)localObject).getString("app_name");
        localObject = StructMsgFactory.a((Bundle)localObject);
        if ((localObject == null) || (!(localObject instanceof AbsShareMsg))) {
          break label233;
        }
      }
    }
    label233:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      a((AbsShareMsg)localObject, str);
      this.jdField_k_of_type_Boolean = false;
      ao();
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(null);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(null);
      break;
    }
  }
  
  private void ak()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void al()
  {
    if (QQLSRecentManager.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    ThreadManager.b().post(new aab(this));
  }
  
  private void am()
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
    if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
      ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
  }
  
  private void an()
  {
    if ((ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)) {
      if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
        break label328;
      }
    }
    label304:
    label328:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_g_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_g_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label304;
        }
        if ((this.jdField_g_of_type_AndroidViewView == null) || (this.jdField_g_of_type_AndroidViewView.getVisibility() != 0)) {
          break label212;
        }
      }
      label212:
      while (this.jdField_g_of_type_AndroidViewView == null)
      {
        return;
        if (this.jdField_g_of_type_AndroidViewView.getVisibility() == 4)
        {
          QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
          break;
        }
        QLog.d("ChatActivity", 2, "#handleNightMask# : mMask getVisibility = GONE");
        break;
        if (this.jdField_g_of_type_AndroidViewView == null)
        {
          this.jdField_g_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_g_of_type_AndroidViewView.setBackgroundColor(1996488704);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.addRule(6, 2131296662);
          localLayoutParams.addRule(2, this.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
          this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_g_of_type_AndroidViewView);
          return;
        }
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_g_of_type_AndroidViewView);
      this.jdField_g_of_type_AndroidViewView = null;
      return;
    }
  }
  
  private void ao()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("QQLite", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        f(str);
      }
    }
  }
  
  private void ap()
  {
    long l1 = System.currentTimeMillis();
    ExtensionInfo localExtensionInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.o))
    {
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localExtensionInfo = localFriendsManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      if (localExtensionInfo != null) {
        break label339;
      }
      if (!localFriendsManagerImp.d()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localExtensionInfo.timestamp = System.currentTimeMillis();
      if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        localExtensionInfo.chatInputType = 0;
        label119:
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localExtensionInfo;
      }
    }
    label339:
    for (;;)
    {
      switch (localExtensionInfo.chatInputType)
      {
      }
      for (;;)
      {
        m(false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("save_inptut", 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
        return;
        localExtensionInfo.chatInputType = 1;
        break label119;
        AIOInputTypeHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (AIOInputTypeHelper.jdField_a_of_type_Boolean)
        {
          localExtensionInfo.chatInputType = 2;
          l(true);
        }
        else if (AIOInputTypeHelper.jdField_b_of_type_Boolean)
        {
          localExtensionInfo.chatInputType = 1;
          l(false);
        }
        else
        {
          localExtensionInfo.chatInputType = 2;
          l(true);
          continue;
          l(true);
          continue;
          l(false);
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.o))
          {
            if (QLog.isColorLevel()) {
              QLog.d("save_inptut", 2, "chooseC2CChatInputType isSimpleBar = " + this.o);
            }
            l(false);
          }
        }
      }
    }
  }
  
  private void aq()
  {
    boolean bool = true;
    long l1 = System.currentTimeMillis();
    Object localObject;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.o))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null) {
          break label261;
        }
        if (QLog.isColorLevel()) {
          QLog.d("save_inptut", 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label262;
      }
      i1 = 2;
      if (((ExtensionInfo)localObject).chatInputType == i1) {
        break label278;
      }
      ((ExtensionInfo)localObject).chatInputType = i1;
    }
    label149:
    label278:
    for (int m = 1;; m = 0)
    {
      int i2;
      if ((this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() == 0))
      {
        i2 = 1;
        if (((ExtensionInfo)localObject).showC2CPanel != i2)
        {
          ((ExtensionInfo)localObject).showC2CPanel = i2;
          m = 1;
        }
        if (m != 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new abc(this, (ExtensionInfo)localObject));
        }
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
        if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (i1 != 1) {
            break label272;
          }
        }
      }
      for (;;)
      {
        AIOInputTypeHelper.a((QQAppInterface)localObject, bool);
        if (QLog.isColorLevel()) {
          QLog.d("save_inptut", 2, "saveC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
        }
        return;
        i1 = 1;
        break;
        i2 = 0;
        break label149;
        bool = false;
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!AIOUtils.b())) {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903067, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296561);
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296563));
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b())) {
          ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131296663);
        }
      }
    }
    label149:
    label150:
    while (this.jdField_b_of_type_AndroidViewView == null)
    {
      break label149;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(2131362974);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean2);
        return;
        if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
          break;
        }
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131296663);
        break;
        this.jdField_h_of_type_AndroidWidgetTextView.setText(2131362975);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    ThreadManager.b(new aaw(this, paramInt1, paramInt2));
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int m;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      m = 1;
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        break label219;
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramInt1 != 1) {
        break label213;
      }
      i1 = 1;
      label45:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i1 + "", m + "", paramInt2 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt1 + ", sessionType = " + m + ", seconds = " + paramInt2);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        m = 2;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        m = 3;
        break;
      }
      m = 4;
      break;
      label213:
      i1 = 2;
      break label45;
      label219:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", m + "", paramInt2 + "", "");
    }
  }
  
  private void h(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(32);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
  }
  
  private void i(boolean paramBoolean)
  {
    int i1 = 1;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      m = 1;
      i1 = 0;
    }
    for (;;)
    {
      if ((m == 0) && (i1 == 0))
      {
        return;
        if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          m = 0;
        }
      }
      else
      {
        Object localObject;
        ChatMessage localChatMessage;
        long l1;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          int i2 = ((List)localObject).size();
          i1 = 0;
          if (i1 >= i2) {
            break label223;
          }
          localChatMessage = (ChatMessage)((List)localObject).get(i1);
          if (!localChatMessage.isread) {
            if (m != 0) {
              l1 = localChatMessage.shmsgseq;
            }
          }
        }
        for (;;)
        {
          label137:
          if (paramBoolean) {}
          for (;;)
          {
            ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l1 = localChatMessage.time;
            break label137;
            i1 += 1;
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (m != 0)
            {
              l1 = ((QQMessageFacade.Message)localObject).shmsgseq;
              break label137;
            }
            l1 = ((QQMessageFacade.Message)localObject).time;
            break label137;
            l1 += 1L;
          }
          label223:
          l1 = -1L;
        }
      }
      i1 = 0;
      m = 0;
    }
  }
  
  private void j(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 10004);
    this.bP = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.bQ = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("isBack2Root");
    this.jdField_f_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("is_share_flag");
    }
    this.jdField_g_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
  }
  
  private void j(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  private void k(Intent paramIntent)
  {
    int i1 = 3;
    j(0);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    int m = i1;
    switch (i2)
    {
    default: 
      m = i1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(m);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      String str = paramIntent.getStringExtra("input_text");
      paramIntent.removeExtra("input_text");
      if (str == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      return;
      m = 2;
      continue;
      m = 2;
    }
    ac();
  }
  
  private void k(boolean paramBoolean)
  {
    l(true);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4, paramBoolean);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837523);
  }
  
  private void l(Intent paramIntent)
  {
    if (paramIntent.getExtras().containsKey("forward_type"))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131362553, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
    }
    else {
      return;
    }
    int m = paramIntent.getIntExtra("forward_type", 2147483647);
    if (m == 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aas(this, paramIntent, paramIntent), 500L);
      a(false, null);
      return;
      if ((m == 1001) || (m == -4)) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
      }
    }
  }
  
  private void l(boolean paramBoolean)
  {
    int i1 = 0;
    this.jdField_f_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_f_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      m = 0;
      ((ImageView)localObject).setVisibility(m);
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      if (paramBoolean) {
        break label66;
      }
    }
    label66:
    for (int m = i1;; m = 8)
    {
      ((EditText)localObject).setVisibility(m);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837556);
      }
      return;
      m = 8;
      break;
    }
  }
  
  private void m(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_i_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_b_of_type_Boolean)) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((TextView)localObject1).setId(2131296315);
      ((TextView)localObject1).setBackgroundResource(2130837620);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(3.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131296663);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(25.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296670));
      if (this.jdField_b_of_type_AndroidViewView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131296315);
      }
    }
    Object localObject2 = this.jdField_i_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void m(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    if (paramIntent.getLongExtra("res_share_id", 0L) > 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aau(this, paramIntent), 20L);
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (this.o) {
      break label7;
    }
    label7:
    label192:
    label213:
    for (;;)
    {
      return;
      if (!BaseChatItemLayout.jdField_b_of_type_Boolean)
      {
        Object localObject = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (!((FriendsManagerImp)localObject).d())
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
            n(paramBoolean);
          }
          ThreadManager.b(new aar(this));
          return;
        }
        long l1 = System.currentTimeMillis();
        ExtensionInfo localExtensionInfo = ((FriendsManagerImp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        localObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
          }
        }
        else
        {
          if (((ExtensionInfo)localObject).chatInputType != 2) {
            break;
          }
          if (((ExtensionInfo)localObject).showC2CPanel != 1) {
            break label192;
          }
          n(paramBoolean);
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label213;
          }
          QLog.d("save_inptut", 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l1));
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("save_inptut", 2, "showAudioPanelIfNeed | ExtensionInfo = null");
          return;
          if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
            this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837524);
          }
        }
      }
    }
  }
  
  private void n(int paramInt)
  {
    int m;
    if (paramInt == 1) {
      m = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, m + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 2) {
        m = 2;
      } else {
        m = 3;
      }
    }
  }
  
  private void n(Intent paramIntent)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean) {
      a(false, null);
    }
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
    }
    for (;;)
    {
      this.bP = paramIntent.getIntExtra("enter_ext_panel", 0);
      this.bQ = paramIntent.getIntExtra("ext_panel_onresume", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "mEnterExtPanel = " + this.bP + ", mExtPanelOnResumeTimes = " + this.bQ);
      }
      return;
      if (localBundle != null)
      {
        this.jdField_c_of_type_Boolean = localBundle.getBoolean("isBack2Root");
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
        }
      }
    }
  }
  
  private void n(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_input.name()))
      {
        k(false);
        this.u = false;
      }
    }
    while (!this.u)
    {
      return;
      this.u = true;
      return;
    }
    k(true);
    this.u = false;
  }
  
  private void o(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_i_of_type_Boolean))
    {
      int m = paramIntent.getInt("aio_msg_source", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + m);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), String.valueOf(m), "", "");
    }
  }
  
  private void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      if (((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).isActive(this.jdField_a_of_type_AndroidWidgetEditText)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    do
    {
      do
      {
        View localView;
        do
        {
          return;
          localView = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        } while ((localView == null) || (localView.getVisibility() != 0));
        if (localView != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel) {
          break;
        }
      } while (!paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    } while (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837524);
  }
  
  public void A()
  {
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.e;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    Looper.myQueue().addIdleHandler(new zi(this));
    z();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (v)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new zj(this));
      v = false;
    }
    for (;;)
    {
      ae();
      return;
      a(131072);
    }
  }
  
  public void B()
  {
    AudioUtil.b(2131165186, false);
  }
  
  public void C()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_b_of_type_Int = 0;
    this.p = true;
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a().getCount() - 1);
    }
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", 0);
      ((Intent)localObject).setFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    }
    Object localObject = (PendingIntent)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
    if ((localObject != null) && ((localObject instanceof PendingIntent))) {}
    try
    {
      ((PendingIntent)localObject).send();
      if (f()) {
        t();
      }
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatActivity", 4, localCanceledException.getMessage());
        }
      }
    }
  }
  
  void F()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    if (localSVIPHandler.a()) {
      localSVIPHandler.b();
    }
  }
  
  public void G()
  {
    i();
    an();
  }
  
  public void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void I()
  {
    b(true, this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
  }
  
  public void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void K()
  {
    int m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i1 & 0x4) != 0) {
      m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, m - 200);
      return;
      if ((i1 & 0x2) != 0) {
        m = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void L()
  {
    if (this.w)
    {
      g();
      this.w = false;
    }
  }
  
  public void M()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PeakService.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startService(localIntent);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
    ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(30, 800L);
    ak();
  }
  
  public void N()
  {
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    ah();
    StartupTracker.a("AIO_onShow_emotion", null);
    L();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    aj();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    ai();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    o(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    M();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    al();
    StartupTracker.a("AIO_onShow_setReaded", null);
    ThreadPriorityManager.a(false);
    StartupTracker.a("AIO_onShow", null);
  }
  
  @TargetApi(11)
  public void O()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838617);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      if (VersionUtils.e()) {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
        if (VersionUtils.e()) {
          this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.6F);
        }
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837556);
          this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362983));
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839035);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362982));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837556);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362983));
      }
      while (VersionUtils.e())
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130839035);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362982));
      }
    }
  }
  
  public void P()
  {
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
  }
  
  public void Q()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  public void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  public void S()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    U();
    aak localaak = new aak(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(localaak, 60L);
        return;
      }
      localaak.run();
      return;
    }
  }
  
  public void U()
  {
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_e_of_type_AndroidViewView.getParent()).removeView(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView = null;
  }
  
  public void V() {}
  
  public void W()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue");
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.r() == this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()))
    {
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        k(true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004453", "0X8004453", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.y = true;
  }
  
  public void Z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  protected Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624119);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2130903139);
      localTextView1 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296911);
      localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296470);
      TextView localTextView2 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296914);
      TextView localTextView3 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131296915);
      localTextView1.setText(2131363586);
      ((TextView)localObject).setText(2131363589);
      localTextView3.setText(2131363588);
      localTextView3.setOnClickListener(new zk(this));
      localTextView2.setText(2131362794);
      localTextView2.setOnClickListener(new zl(this));
      return this.jdField_c_of_type_AndroidAppDialog;
    case 231: 
      this.jdField_d_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624119);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2130903049);
      ((TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131296470)).setText(2131363582);
      return this.jdField_d_of_type_AndroidAppDialog;
    case 232: 
      this.jdField_e_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624119);
      this.jdField_e_of_type_AndroidAppDialog.setContentView(2130903658);
      localTextView1 = (TextView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131297963);
      localObject = (ImageView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131296957);
      localTextView1.setText(2131363024);
      ((ImageView)localObject).setImageResource(2130837985);
      return this.jdField_e_of_type_AndroidAppDialog;
    }
    this.jdField_f_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624119);
    this.jdField_f_of_type_AndroidAppDialog.setContentView(2130903658);
    TextView localTextView1 = (TextView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131297963);
    Object localObject = (ImageView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131296957);
    localTextView1.setText(2131363023);
    ((ImageView)localObject).setImageResource(2130837975);
    return this.jdField_f_of_type_AndroidAppDialog;
  }
  
  public View a(int paramInt)
  {
    PlusPanel localPlusPanel = null;
    if (paramInt == 3)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903065, null));
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
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903183, null));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight(), this.jdField_d_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l1));
        }
        return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    } while (paramInt != 4);
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903461, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (InputLinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @Deprecated
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(int paramInt)
  {
    int m = paramInt & 0xFFFF0000;
    if ((paramInt & 0xFFFF) > (this.jdField_a_of_type_Int & 0xFFFF)) {
      paramInt &= 0xFFFF;
    }
    long l1;
    for (;;)
    {
      this.jdField_a_of_type_Int = (paramInt | m);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
      {
        if (m < 196608) {
          break label125;
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
    label125:
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new zp(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    h();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getExtras() != null) {
        bool1 = paramIntent.getExtras().getBoolean("progress2View");
      }
    }
    if (paramInt1 == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setCanLock(false);
    }
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          localObject1 = paramIntent.getExtras();
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatActivity.class);
          ((Intent)localObject2).putExtras(new Bundle((Bundle)localObject1));
          ((Intent)localObject2).addFlags(268435456);
          ((Intent)localObject2).addFlags(67108864);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(4, paramIntent);
      }
      return;
      if (paramInt1 == 4001) {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramIntent);
      } else if ((paramInt1 == 103) && (!bool1)) {
        d(false);
      } else if ((paramInt1 == 101) && (paramInt2 != -1)) {
        d(false);
      } else if (paramInt2 == -1) {
        switch (paramInt1)
        {
        default: 
          break;
        case 0: 
          d(false);
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
            Object localObject3 = paramIntent.getExtras();
            if (localObject3 != null)
            {
              localObject1 = ((Bundle)localObject3).getString("latitude");
              localObject2 = ((Bundle)localObject3).getString("longitude");
              String str1 = ((Bundle)localObject3).getString("description");
              String str2 = ((Bundle)localObject3).getString("title");
              String str3 = ((Bundle)localObject3).getString("summary");
              localObject3 = ((Bundle)localObject3).getString("dianping_id");
              ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, str1, str2, str3, (String)localObject3);
            }
          }
          break;
        case 1: 
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramIntent, "UPLOAD_SHOTPHOTO_REQUEST");
          break;
        case 10: 
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, "ChatActivityConstants.ADD_CUSTOMEMOTION_REQUEST");
          break;
        case 3: 
          i(paramIntent);
          break;
        case 20: 
          d(true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
          break;
        case 21: 
          paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362950));
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
            t();
          } else {
            d(false);
          }
          break;
        }
      }
    }
    label656:
    int m;
    switch (paramInt2)
    {
    default: 
      if ((paramIntent != null) && ("AioVIP".equals(paramIntent.getStringExtra("callbackSn"))))
      {
        localObject1 = paramIntent.getStringExtra("result");
        m = -1;
      }
      break;
    }
    for (int i2 = -1;; i2 = paramInt1)
    {
      for (;;)
      {
        int i1;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          paramInt1 = i2;
        }
        catch (JSONException localJSONException1)
        {
          int i3;
          localObject1 = null;
          paramInt1 = i2;
        }
        try
        {
          i1 = Integer.parseInt(((JSONObject)localObject1).getString("resultCode"));
          paramInt1 = i2;
          m = i1;
          i2 = Integer.parseInt(((JSONObject)localObject1).getString("payState"));
          paramInt1 = i2;
          m = i1;
          i3 = Integer.parseInt(((JSONObject)localObject1).getString("provideState"));
          paramInt1 = i3;
          m = i1;
          i1 = paramInt1;
          if ((localObject1 == null) || (m != 0) || (i2 != 0) || (i1 != 0)) {
            break;
          }
          MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
          paramInt1 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "renewal_tail_tip_exit");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_paysucc", 0, 0, "" + paramInt1, "", "", "");
        }
        catch (JSONException localJSONException2)
        {
          label906:
          break label906;
        }
      }
      D();
      break label656;
      break;
      localJSONException1.printStackTrace();
      i1 = -1;
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new zm(this), 1000L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  void a(int paramInt, String paramString, long paramLong)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      d(true);
      return;
    }
    if (paramString != null)
    {
      paramString = StreamDataManager.a(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    d(true);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    d(true);
    b(paramIntent);
    a(false);
    j();
    h();
    this.o = b();
    i();
    k();
    k(paramIntent);
    ap();
    n();
    this.bO = 1;
    this.p = true;
    e(false);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    paramInt = paramIntent.getIntExtra(AlbumConstants.i, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "handleRequest requestCode " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1)) {
      i(paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    P();
    if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837524);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageObserver paramMessageObserver, Intent paramIntent)
  {
    try
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (QLog.isDevelopLevel()) {
        QLog.d("Fight", 4, "fight.test.AbsStructMsg.STRUCT_TYPE_MULTI_MSG = 35");
      }
      while (localAbsStructMsg != null)
      {
        if ((localAbsStructMsg instanceof StructMsgForImageShare))
        {
          String str = paramIntent.getStringExtra("share_comment_message");
          paramMessageObserver = str;
          if (android.text.TextUtils.isEmpty(str)) {
            paramMessageObserver = localAbsStructMsg.mCommentText;
          }
          if (!android.text.TextUtils.isEmpty(paramMessageObserver))
          {
            AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
            ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageObserver);
          }
          paramIntent.removeExtra("forward_type");
          paramIntent.removeExtra("res_share_id");
          return;
        }
        if (35 == localAbsStructMsg.mMsgServiceID)
        {
          paramMessageObserver = MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.iterator();
          do
          {
            if (!paramMessageObserver.hasNext()) {
              break;
            }
          } while (((ChatMessage)paramMessageObserver.next()).isSend());
        }
        for (paramMessageObserver = Boolean.valueOf(false);; paramMessageObserver = Boolean.valueOf(true))
        {
          if (paramMessageObserver.booleanValue())
          {
            MultiMsgManager.a().a(paramQQAppInterface, paramContext, paramSessionInfo, null, paramIntent, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList);
            break;
          }
          MultiMsgManager.a().b();
          MultiMsgManager.a().c();
          paramMessageObserver = ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg);
          MultiMsgManager.a().b("StructMsg save db ");
          MultiMsgManager.a().c();
          MultiMsgManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().b, paramMessageObserver, null);
          break;
          ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
          break;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage))) {
      return;
    }
    paramMessage = new zt(this, paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramMessage, false));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      am();
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage, false);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + m);
    }
    if (m < 0) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.q();
    int i2 = m - i1;
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i2);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i2 + ",firstPos is:" + i1 + ",pos is:" + m);
      }
      a(196612);
      return;
    }
    boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
    boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
    this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
    this.jdField_b_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
          localObject2 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296661);
          i1 = ((ViewGroup)localObject2).getChildCount();
          m = 0;
          if (m >= i1) {
            break label932;
          }
          if (((ViewGroup)localObject2).getChildAt(m) == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)
          {
            if (m != -1) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "listViewIndex is:" + m + ",can not find listView");
            }
            a(196612);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = null;
        continue;
        m += 1;
        continue;
        Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131296662);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131296662);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131296662);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131296662);
        ((ViewGroup)localObject2).addView(this.jdField_b_of_type_AndroidViewViewGroup, m + 1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(new aai(this));
        localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((ImageView)localObject3).setImageBitmap((Bitmap)localObject1);
        FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        Object localObject2 = new FrameLayout.LayoutParams(this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        this.jdField_b_of_type_AndroidViewViewGroup.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
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
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aaj(this, localFrameLayout), 400L);
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
      label932:
      m = -1;
      continue;
      Object localObject1 = null;
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() != 1)) {}
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.jdField_c_of_type_Int == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramPicEmoticonInfo.a);
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711688))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
        a(0, null, -1L);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    c(false);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    String str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null);
    if (QLog.isColorLevel()) {
      QLog.i("QQRecorder", 2, "path: " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
    AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(str);
  }
  
  public void a(AbsListView.RecyclerListener paramRecyclerListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(paramRecyclerListener);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.bU = paramInt;
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
      if ((this.s) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.s = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711697);
        paramAbsListView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711697);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
    }
    do
    {
      return;
      URLDrawable.pause();
      if (!PicItemBuilder.jdField_g_of_type_Boolean)
      {
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
      }
    } while (paramInt != 1);
    f(false);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.l();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.k();
    int i2 = paramInt3 - i4 - i3;
    if (this.bN < i2)
    {
      int i1 = paramInt1 + paramInt2 - i3;
      int m = i1;
      if (i1 >= paramInt3 - i4 - i3) {
        m = i2 - 1;
      }
      if (m >= this.bN) {
        this.bN = (m + 1);
      }
    }
    for (paramInt3 = i2 - this.bN;; paramInt3 = 0)
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 13, paramInt3, i2 - paramInt1 - paramInt2).sendToTarget();
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      DraftTextInfo localDraftTextInfo = new DraftTextInfo();
      localDraftTextInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localDraftTextInfo.type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localDraftTextInfo.text = paramCharSequence.toString();
      localDraftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDraftTextInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_e_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new zv(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    g(2131165187);
    a(paramString, this.jdField_e_of_type_Long);
    n(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    g(2131165187);
    a(paramString, this.jdField_e_of_type_Long, paramInt1, paramInt2);
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new aav(this, paramString2));
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
      g(2131165190);
    }
    for (;;)
    {
      d(true);
      return;
      label92:
      paramString = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        paramString.setPttStreamFlag(10001);
      }
      this.jdField_e_of_type_Long = paramString.uniseq;
      g(2131165188);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    StreamDataManager.a(paramString, paramArrayOfByte, paramArrayOfByte.length, (short)0);
  }
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    String str = " ";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
    for (str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString) {
      do
      {
        paramMap = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, paramArrayList, paramMap);
        paramMap.mMsg_A_ActionData = null;
        new Intent();
        paramArrayList = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardRecentActivity.class);
        paramArrayList.putExtra("forward_type", -3);
        paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramArrayList, 21);
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000));
    }
  }
  
  protected void a(boolean paramBoolean)
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
  
  public void a(boolean paramBoolean, ChatMessage paramChatMessage)
  {
    if (BaseChatItemLayout.jdField_b_of_type_Boolean == paramBoolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivity", 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
      return;
    }
    BaseChatItemLayout.jdField_b_of_type_Boolean = paramBoolean;
    MultiMsgManager.a().a(paramChatMessage, paramBoolean);
    if (!paramBoolean)
    {
      if ((!"".equals(this.jdField_c_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363114).equals(this.jdField_c_of_type_JavaLangString))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      MultiMsgManager.a().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296934).setVisibility(0);
      if (this.bT > 0)
      {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.bT);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
        }
      }
      if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (!android.text.TextUtils.isEmpty(this.jdField_i_of_type_AndroidWidgetTextView.getText().toString())) && (!"0".equals(this.jdField_i_of_type_AndroidWidgetTextView.getText().toString()))) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      return;
      this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363114);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      S();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
      {
        paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
        if (this.bT == 0) {
          this.bT = paramChatMessage.bottomMargin;
        }
        paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, 0);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
      }
      if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
    {
      if (!paramBoolean1) {
        break label44;
      }
      p();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean2, false, false);
      b(true, paramBoolean2);
      this.jdField_d_of_type_Boolean = paramBoolean2;
      return;
      label44:
      q();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean3, paramBoolean1, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      if ((paramBoolean1) || (paramBoolean2)) {
        break label46;
      }
    }
    label46:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b(paramBoolean1, paramBoolean3);
      this.jdField_d_of_type_Boolean = paramBoolean3;
      return;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    e(false);
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.a(paramMessageRecord.istroop))));
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
    {
      ((FavoriteEmoticonInfo)paramEmoticonInfo).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
    this.t = true;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    e();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    f();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
    c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    Q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 1);
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      return true;
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 2);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int m = 2130837585;
    long l1 = System.currentTimeMillis();
    Object localObject;
    boolean bool;
    if (this.jdField_c_of_type_Int == 0)
    {
      if (!this.o) {
        break label127;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (paramEditable.length() <= 0) {
        break label114;
      }
      ((ImageButton)localObject).setImageResource(m);
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (paramEditable.length() <= 0) {
        break label121;
      }
      bool = true;
      label69:
      ((ImageButton)localObject).setEnabled(bool);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l1));
      }
      return;
      label114:
      m = 2130837586;
      break;
      label121:
      bool = false;
      break label69;
      label127:
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      if (paramEditable.length() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837585);
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
        if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramEditable.toString());
          m = ((EmoticonManagerImp)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager).a(paramEditable.toString());
          if (((localObject != null) && (((List)localObject).size() > 0)) || (m > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setEmoticonKeywordList((List)localObject, m);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(0);
          }
        }
      }
      else if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837622);
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      }
    }
  }
  
  public int b()
  {
    return this.jdField_g_of_type_Int;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start currenttime:" + System.currentTimeMillis());
    }
    String str;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
    {
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      PicPreDownloadUtils.a(str);
      if ((str != null) && (str.length() > 3478)) {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131362976, 1);
      }
    }
    else
    {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType == VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject = new ArrayList();
      str = AtTroopMemberSpan.a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, (ArrayList)localObject);
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType == VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        localObject = str;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { localObject });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null);
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        localObject = str;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    O();
    if (paramInt2 == 3)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837556);
      if (!this.o)
      {
        if (paramInt2 != 4) {
          break label137;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837556);
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      }
      label51:
      if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
      }
      paramInt1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
      if (paramInt1 == 0) {
        break label232;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if ((paramInt1 == 5) || (paramInt1 == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
    label137:
    label232:
    while ((paramInt2 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null))
    {
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130837545);
      break;
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
        bool = true;
      }
      ((ImageButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837585);
        break label51;
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837622);
        break label51;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837556);
      break label51;
    }
    Object localObject = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(paramInt2 - 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a((QQOperationViopTipTask)localObject);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_d_of_type_AndroidWidgetTextView.setId(2131296321);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)(44.0F * this.jdField_a_of_type_Float));
      localLayoutParams.rightMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427462));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(17.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131363562);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296890)).addView(this.jdField_d_of_type_AndroidWidgetTextView);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296934).setVisibility(8);
    a(true, paramChatMessage);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(CharSequence paramCharSequence)
  {
    j(0);
    this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().append(paramCharSequence);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
  }
  
  public void b(String paramString)
  {
    i(0);
  }
  
  public void b(boolean paramBoolean) {}
  
  protected boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int c()
  {
    return 6;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(paramInt);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Intent paramIntent)
  {
    this.u = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    j(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    l(paramIntent);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    m(paramIntent);
    StartupTracker.a("AIO_updateSession_otherThings", null);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    MessageRecord localMessageRecord1 = MessageRecordFactory.a(paramChatMessage);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramChatMessage.uniseq);
    Object localObject1 = ((ArrayList)localObject2).iterator();
    MessageRecord localMessageRecord2;
    while (((Iterator)localObject1).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject1).next();
      if ((localMessageRecord2 instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord2);
      }
    }
    localObject1 = new HashMap();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
      if (!((HashMap)localObject1).containsKey(localMessageRecord2.senderuin))
      {
        String str = MultiMsgManager.a().a(localMessageRecord2.senderuin, localMessageRecord2.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((HashMap)localObject1).put(localMessageRecord2.senderuin, str);
      }
    }
    MultiMsgManager.a().a((HashMap)localObject1, localMessageRecord1.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localArrayList, (HashMap)localObject1, localMessageRecord1, null);
  }
  
  public void c(String paramString)
  {
    c(true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    i(0);
  }
  
  @TargetApi(13)
  public void c(boolean paramBoolean)
  {
    int m = 0;
    int i1 = 1;
    if (!paramBoolean)
    {
      this.bW = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (i2 == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          m = i1;
          if (VersionUtils.c()) {
            m = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(m);
        }
      }
      label69:
      do
      {
        do
        {
          do
          {
            break label69;
            do
            {
              return;
            } while (i2 != 2);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            if (VersionUtils.c()) {}
            for (m = 6;; m = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(m);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
              i1 = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((i1 == 0) || (i1 == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (i1 != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(m);
                return;
                m = 8;
                continue;
                if (i1 == 0)
                {
                  m = 1;
                }
                else
                {
                  m = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (i1 != 1) {
                      m = 8;
                    }
                  }
                  else if (i1 == 1) {
                    m = 9;
                  } else {
                    m = 1;
                  }
                }
              }
            }
            m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((m != 0) && (m != 1)) {
              break;
            }
            if (i2 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
              return;
            }
          } while (i2 != 2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
          return;
        } while ((m != 2) && (m != 3));
        if (i2 == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(9);
          return;
        }
      } while (i2 != 2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.bW);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void d()
  {
    aq();
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
  }
  
  public void d(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362981));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  public void d(Intent paramIntent) {}
  
  public void d(String paramString)
  {
    a(2, paramString, this.jdField_e_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new zy(this));
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 2;; m = 0)
    {
      a(m | 0x20000);
      return;
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a())) {
        return true;
      }
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837524);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.moveTaskToBack(true);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", 0);
      ((Intent)localObject).setFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
    }
    Object localObject = (PendingIntent)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
    if ((localObject != null) && ((localObject instanceof PendingIntent))) {}
    try
    {
      ((PendingIntent)localObject).send();
      if (BaseChatItemLayout.jdField_b_of_type_Boolean)
      {
        a(false, null);
        return true;
      }
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatActivity", 4, localCanceledException.getMessage());
        }
      }
    }
    return false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296564));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296661));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296672));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296671));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296890));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296897));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296902));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296935));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364516));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363664));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296896).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296932));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().findViewById(2131296933));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296662));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new abb(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_c_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics())));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296665));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296666));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296667));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new zg(this));
    this.jdField_a_of_type_AndroidWidgetEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
    ((XEditTextEx)this.jdField_a_of_type_AndroidWidgetEditText).setOnPrivateIMECommandListener(new zr(this));
    Object localObject = Build.MODEL;
    if ((localObject != null) && ((((String)localObject).startsWith("SH-")) || (((String)localObject).startsWith("SBM")) || (((String)localObject).startsWith("SHL")))) {}
    try
    {
      localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      int m = ((Integer)((Field)localObject).get(new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))).intValue();
      ((Field)localObject).set(this.jdField_a_of_type_AndroidWidgetEditText, Integer.valueOf(m));
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296669));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296663));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296668));
      this.jdField_f_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362988));
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_g_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
  
  public void e(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131362553, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    int m;
    Object localObject2;
    do
    {
      do
      {
        return;
        m = paramIntent.getIntExtra("forward_type", 2147483647);
      } while (m == 2147483647);
      paramIntent.removeExtra("forward_type");
      paramIntent.getExtras().remove("forward_type");
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getBoolean("isBack2Root");
      localObject1 = paramIntent.getStringExtra("forward_filepath");
      switch (m)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case -3: 
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
        return;
      case -1: 
        paramIntent = paramIntent.getStringExtra("forward_text");
        if (!android.text.TextUtils.isEmpty(paramIntent)) {
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
        }
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
        return;
      case 0: 
        try
        {
          localObject2 = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
          if (paramIntent.getBooleanExtra("foward_editbar", false)) {
            break label420;
          }
          if ((localObject2 == null) || (((ForwardFileInfo)localObject2).c() != 3)) {
            break label398;
          }
          if ((!FileManagerUtil.a()) || (((ForwardFileInfo)localObject2).d() <= 5242880L)) {
            break label376;
          }
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131362018, 2131362016, new aax(this, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2));
          return;
        }
        catch (Exception paramIntent) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "FORWARD_TYPE.FILE failed. " + paramIntent, paramIntent);
    return;
    label376:
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label398:
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (ForwardFileInfo)localObject2, false);
    return;
    label420:
    Object localObject1 = paramIntent.getParcelableArrayListExtra("fileinfo_array");
    long l1 = 0L;
    long l2 = l1;
    if (localObject1 != null)
    {
      l2 = l1;
      if (((ArrayList)localObject1).size() > 0) {
        localObject2 = ((ArrayList)localObject1).iterator();
      }
    }
    for (;;)
    {
      l2 = l1;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ForwardFileInfo)((Iterator)localObject2).next();
        if (((ForwardFileInfo)localObject3).c() == 3) {
          l1 += ((ForwardFileInfo)localObject3).d();
        }
      }
      else
      {
        if ((FileManagerUtil.a()) && (l2 > 5242880L))
        {
          FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131362018, 2131362016, new aay(this, (ArrayList)localObject1, paramIntent));
          return;
        }
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ForwardFileInfo)((Iterator)localObject1).next();
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, ((ForwardFileInfo)localObject2).a(), (ForwardFileInfo)localObject2, true);
        }
        boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        Object localObject4;
        if (bool1)
        {
          if (bool2) {
            break;
          }
          localObject2 = paramIntent.getStringExtra("forward_download_image_task_key");
          localObject3 = paramIntent.getStringExtra("forward_download_image_org_uin");
          m = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          localObject4 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject4, (String)localObject3, l1, m, (String)localObject2);
          d(true);
          return;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        m = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        paramIntent = PicBusiManager.a(m, paramIntent);
        localObject1 = PicBusiManager.a(2, m);
        ((PicReq)localObject1).a(paramIntent);
        PicBusiManager.a((PicReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1) == -1L) {
          break;
        }
        d(true);
        return;
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          localObject4 = paramIntent.getExtras();
          if (localObject4 == null) {
            break;
          }
          paramIntent = ((Bundle)localObject4).getString("forward_latitude");
          localObject1 = ((Bundle)localObject4).getString("forward_longitude");
          localObject2 = ((Bundle)localObject4).getString("forward_location");
          localObject3 = ((Bundle)localObject4).getString("title");
          localObject4 = ((Bundle)localObject4).getString("summary");
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "");
          return;
        }
        localObject1 = paramIntent.getStringExtra("forward_latitude");
        localObject2 = paramIntent.getStringExtra("forward_longitude");
        paramIntent = paramIntent.getStringExtra("forward_location");
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject1, (String)localObject2, paramIntent);
        return;
        localObject1 = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
          {
          case 0: 
          default: 
            break;
          case -1: 
            if (!android.text.TextUtils.isEmpty(((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString)) {
              AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
            }
            ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 1: 
            localObject3 = paramIntent.getStringExtra("forward_download_image_task_key");
            localObject4 = paramIntent.getStringExtra("forward_download_image_org_uin");
            m = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            String str = paramIntent.getStringExtra("forward_download_image_server_path");
            l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((ForwardUtils.Section_Pic)localObject2).jdField_b_of_type_JavaLangString, str, (String)localObject4, l1, m, (String)localObject3);
            d(true);
          }
        }
        if (2 == MarketFaceItemBuilder.m) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramIntent = MarketFaceItemBuilder.a;
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
          paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Long);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null)
      {
        if (this.jdField_f_of_type_AndroidViewView == null) {
          this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903115, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_f_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c() == null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838616));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  public boolean e()
  {
    return h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new aba(this, null);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void f(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void f(Intent paramIntent)
  {
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("ChatActivity", 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + " sessionInfo.entrance " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    }
    g(paramIntent);
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setIntent(paramIntent);
    a(paramIntent, 2);
  }
  
  public void f(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = null;
      if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        l(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.jdField_d_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
      else if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      }
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  protected boolean f()
  {
    return true;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidOsHandler);
    SougouInputGrayTips localSougouInputGrayTips = new SougouInputGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localSougouInputGrayTips);
  }
  
  public void g(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  public void g(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = paramIntent.getStringExtra("uin");
    int m = paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    if ((!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != m))
    {
      this.l = false;
      if ((this.l) && (!localBundle.containsKey("forward_type"))) {
        break label96;
      }
      c(paramIntent);
    }
    label96:
    do
    {
      return;
      this.l = true;
      break;
      if ((this.jdField_a_of_type_Int != 0) || (bool))
      {
        d(true);
        return;
      }
    } while (localBundle.getLong("res_share_id", 0L) <= 0L);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramIntent);
  }
  
  public void g(String paramString)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, new aat(this), null);
      if (this.jdField_b_of_type_AndroidAppDialog != null) {
        ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296915)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362795));
      }
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296470)).setText(paramString);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if ((this.t) && (paramBoolean))
    {
      StartupTracker.a(null, "AIO_onWindowFocusChanged");
      long l1 = SystemClock.uptimeMillis() - this.jdField_f_of_type_Long;
      if (QLog.isColorLevel())
      {
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("KEY_FROM");
        String str1 = str2;
        if (str2 == null)
        {
          ComponentName localComponentName = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCallingActivity();
          str1 = str2;
          if (localComponentName != null) {
            str1 = localComponentName.getClassName();
          }
        }
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + l1 + ",from:" + str1);
      }
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
      this.t = false;
      StartupTracker.a("AIO_onWindowFocusChanged", null);
    }
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  public void h()
  {
    if (a())
    {
      aa();
      return;
    }
    ab();
  }
  
  public void h(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362979));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427392), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427393)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "权限提示", localSpannableString, 0, 2131363660, null, null, new zw(this)).show();
  }
  
  protected void h(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_doOnNewIntent_updateUI");
    n(paramIntent);
    StartupTracker.a("AIO_doOnNewIntent_updateUI", "AIO_doOnNewIntent_updateData");
    f(paramIntent);
    StartupTracker.a("AIO_doOnNewIntent_updateData", null);
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
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
    case 21: 
    case 22: 
    case 23: 
    case 16711696: 
    case 24: 
    case 16711697: 
      for (;;)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "read confirm send readconfirm");
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711689, 300000L);
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        continue;
        paramMessage = (String)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage))
        {
          t();
          continue;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363132, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          continue;
          ag();
          continue;
          e(2);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
          if (this.jdField_e_of_type_Long == 0L) {
            g(2131165189);
          }
          AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
          continue;
          a(0, null, -1L);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
            continue;
            af();
            continue;
            m(paramMessage.arg1);
            continue;
            b(paramMessage.arg1, paramMessage.arg2);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "delay MSG_START_VER_ANIM msg is handled,time is:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.obj);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16, 300L);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
            }
            if (this.jdField_a_of_type_AndroidViewView != null) {
              this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            }
            if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
              ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
            }
            this.jdField_a_of_type_AndroidViewView = null;
            this.jdField_b_of_type_AndroidViewViewGroup = null;
            a(196612);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d();
              continue;
              f((String)paramMessage.obj);
              continue;
              j(0);
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
              continue;
              t();
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131363001, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getResources().getDimensionPixelSize(2131492887));
              }
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("nickCount", paramMessage.arg1 + "");
              StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject1, "");
              continue;
              if (this.bU == 0) {
                break;
              }
              this.s = true;
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
    }
    for (paramMessage = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(40);; paramMessage = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage != null))
      {
        m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
        label864:
        if (m >= 0)
        {
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(m);
          if ((localObject2 != null) && ((localObject2 instanceof BaseChatItemLayout)))
          {
            localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2);
            localObject2 = AIOUtils.a((View)localObject2);
            if ((localObject2 == null) || (!((ChatMessage)localObject2).needVipBubble()) || (localObject1 == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_Int != BubbleUtils.a.jdField_a_of_type_Int) || (!paramMessage.a(((ChatMessage)localObject2).vipBubbleID))) {}
          }
        }
      }
      for (int m = 1; m != 0; m = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "MSG_BUBBLE_CACHE_UPDATE, real refresh");
        }
        a(196608);
        break;
        m -= 1;
        break label864;
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        break;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        break;
        boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
        if ((SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) || (!bool)) {
          break;
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqql.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        BaseApplicationImpl.a().startActivity(paramMessage);
        break;
        if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 2000L) {
          return true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          h(false);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 32), 5000L);
        break;
        h(true);
        break;
      }
    }
  }
  
  protected void i()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296664);
      localView.setBackgroundResource(2130837685);
      localView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(false, false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296664).setVisibility(8);
  }
  
  public void i(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new zx(this, paramInt));
  }
  
  protected void i(Intent paramIntent)
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
    do
    {
      int m;
      do
      {
        do
        {
          return;
          if (((Bundle)localObject).getBoolean("deleteImage", false))
          {
            d(true);
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
              ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.e);
              ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
              ((PicUploadInfo.Builder)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              ((PicUploadInfo.Builder)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              PicReq localPicReq = PicBusiManager.a(1, 1005);
              localPicReq.a(((PicUploadInfo.Builder)localObject).a());
              PicBusiManager.a(localPicReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              d(true);
            }
            for (;;)
            {
              ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, 6, "ChatActivity", "ChatActivity.uploadPreviewPhoto.fromdoodle");
              return;
              ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.uploadPreviewPhoto:fromdoodle file not exist");
            }
          }
          m = paramIntent.getIntExtra(AlbumConstants.i, -1);
        } while ((m != 2) && (m != 1));
        paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
      } while ((paramIntent == null) || (paramIntent.isEmpty()));
      if (paramIntent.size() == 1)
      {
        if (m == 1)
        {
          c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 1);
          return;
        }
        c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 2);
        return;
      }
    } while (paramIntent.size() <= 1);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 4, "" + paramIntent.size());
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY");
    }
    this.bV = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.bV == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).isActive(this.jdField_a_of_type_AndroidWidgetEditText))
      {
        this.y = false;
        return true;
      }
    }
    else if ((this.bV == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText.getVisibility() == 0) {
        this.y = false;
      }
      return true;
    }
    return false;
  }
  
  protected void j() {}
  
  @TargetApi(11)
  public void j(int paramInt)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.jdField_c_of_type_Int + "currenttime:" + System.currentTimeMillis());
    }
    Object localObject1;
    int m;
    Object localObject2;
    if (paramInt != this.jdField_c_of_type_Int)
    {
      if (paramInt != 1) {
        break label363;
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        localObject1 = new Button(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((Button)localObject1).setId(2131296316);
        ((Button)localObject1).setBackgroundResource(2130839210);
        ((Button)localObject1).setTextSize(2, 14.0F);
        ((Button)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131427459));
        ((Button)localObject1).setText(2131363137);
        ((Button)localObject1).setOnTouchListener(this);
        m = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).indexOfChild(this.jdField_a_of_type_AndroidWidgetEditText);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, m, (ViewGroup.LayoutParams)localObject2);
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837556);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      if (VersionUtils.e())
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      O();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label363:
      if (paramInt != 2) {
        break;
      }
      localObject1 = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((TextView)localObject2).setId(2131296380);
        ((TextView)localObject2).setBackgroundResource(2130839184);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-7829368);
        ((TextView)localObject2).setEnabled(false);
        ((TextView)localObject2).setGravity(17);
        m = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).indexOfChild(this.jdField_a_of_type_AndroidWidgetEditText);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, m, localLayoutParams);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      }
      if (localObject1 != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((TroopGagMgr.SelfGagInfo)localObject1).jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) || (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0))
        {
          l(false);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837622);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      if (VersionUtils.e())
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(0.6F);
        this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(0.6F);
        this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(0.6F);
      }
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    boolean bool1;
    if (this.bQ > 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) && (this.bP == 1))
      {
        bool1 = true;
        label748:
        ((ImageButton)localObject1).setSelected(bool1);
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {
          bool1 = true;
        }
        ((ImageButton)localObject1).setSelected(bool1);
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0) {
          break label910;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837585);
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      if (!VersionUtils.e()) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetEditText.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(1.0F);
      break;
      bool1 = false;
      break label748;
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        ((ImageButton)localObject1).setSelected(bool1);
        break;
      }
      label910:
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837622);
    }
  }
  
  public void k()
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
    }
  }
  
  public void k(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new aao(this));
    }
  }
  
  protected void l()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void l(int paramInt) {}
  
  public void m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839273);
  }
  
  public void o()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int m = paramView.getId();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) && (m != 2131296410) && (m != 2131296666))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      h(true);
    }
    label572:
    Object localObject1;
    Object localObject2;
    switch (m)
    {
    default: 
    case 2131296896: 
    case 2131296897: 
    case 2131296902: 
    case 2131296315: 
    case 2131296669: 
    case 2131296312: 
    case 2131296665: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (BaseChatItemLayout.jdField_b_of_type_Boolean)
              {
                a(false, null);
                return;
              }
              E();
              return;
              m();
              if (QLog.isDevelopLevel()) {
                QLog.d("reportEvent", 4, " curType : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", "", "");
              return;
              this.bN = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
              if (this.bN > 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b() - 1);
              }
              paramView.setVisibility(8);
              return;
              long l1 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " onClick fun_btn start mInputStat = " + this.jdField_c_of_type_Int + " text.length " + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "currenttime:" + System.currentTimeMillis());
              }
              if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 4)) {
                b();
              }
              for (;;)
              {
                if (!QLog.isColorLevel()) {
                  break label572;
                }
                long l2 = System.currentTimeMillis();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("SendMsgBtn", 2, " onClick fun_btn end mInputStat = " + this.jdField_c_of_type_Int + "text.length" + this.jdField_a_of_type_AndroidWidgetEditText.getText().length() + "cast time :" + (l2 - l1));
                return;
                if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) || (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0))
                {
                  l(false);
                  if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 2) {
                    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                  }
                  this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
                }
                else
                {
                  k(true);
                }
              }
            }
            localObject1 = (Intent)paramView.getTag();
            if (((Intent)localObject1).getExtras().getInt("uintype") == 0)
            {
              localObject2 = ((Intent)localObject1).getExtras().getString("uin");
              if (!ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2))
              {
                ((Intent)localObject1).removeExtra("uintype");
                ((Intent)localObject1).putExtra("uintype", 1003);
              }
            }
            ((Intent)localObject1).putExtra("message_box_click", true);
            aq();
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
            paramView.setVisibility(8);
            if (this.jdField_d_of_type_AndroidViewView != null) {
              this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            }
          } while (!((Intent)localObject1).getExtras().getBoolean("finishAIO"));
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
          return;
        } while (this.jdField_c_of_type_Int == 1);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      } while (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() != 0);
      l(false);
      return;
    case 2131296666: 
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364352));
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
          }
          h(true);
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903062, null));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131296663);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(5.0F * this.jdField_a_of_type_Float + 0.5F));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131296410);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_AndroidOsHandler);
        }
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        if (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0) {
          l(false);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364353));
        j(0);
      }
    case 2131296561: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_d_of_type_Boolean) {
        bool = true;
      }
      paramView.f(bool);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
      return;
    case 2131296668: 
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837524);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130837523);
      return;
    case 2131296321: 
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131362790, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      paramView = new ArrayList();
      localObject1 = new ArrayList();
      localObject2 = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap;
      Object localObject3 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (((Boolean)((HashMap)localObject2).get(localEntry.getKey())).booleanValue()) {
          ((List)localObject1).add((ChatMessage)localEntry.getKey());
        }
      }
      if (((List)localObject1).size() == 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131362999, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
      if (((List)localObject1).size() == 1)
      {
        paramView = (ChatMessage)((List)localObject1).get(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).a(2131296652, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "checklist.size = " + ((List)localObject1).size());
        }
        if (((List)localObject1).size() == 0) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362998);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if (!paramView.contains(((ChatMessage)localObject3).senderuin)) {
            paramView.add(((ChatMessage)localObject3).senderuin);
          }
        }
        if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          Collections.sort((List)localObject1, this.jdField_b_of_type_JavaUtilComparator);
        }
      }
      MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
      MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramView);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(24);
        ((Message)localObject1).arg1 = paramView.size();
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 30000L);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramView);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).edit().putString("camera_photo_path", PlusPanelUtils.jdField_b_of_type_JavaLangString).commit();
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, (Intent)null, "callFromFastImage");
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
    }
    h(false);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "chat list onTouch() is called,action is:" + m);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      h(true);
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
    }
    if (m == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return false;
      if ((m == 1) || (m == 3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
      }
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131624167);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localImageView.setBackgroundResource(2130837555);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (ContactUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) == 0)) {
        break label77;
      }
      localObject = ContactUtils.b((Friends)localObject);
      a(true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
    }
    label77:
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0);
      a(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 5);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  public void s()
  {
    StartupTracker.a(null, "AIO_doOnDestroy");
    this.bN = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.c());
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
    }
    ab();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.b();
    R();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
    }
    a(false, null);
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(26);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
    ChatActivityUtils.a();
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_f_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_j_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_k_of_type_AndroidWidgetTextView != null) {
      a(this.jdField_k_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a();
    MultiMsgManager.a().a();
    ThridAppShareHelper.a().a();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive(this.jdField_a_of_type_AndroidWidgetEditText))
    {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
      v = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a();
    }
    PerformanceReportUtils.a();
    StartupTracker.a("AIO_doOnDestroy", null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime doOnDestroy end: " + System.currentTimeMillis());
    }
  }
  
  public void t()
  {
    v();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void u()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    label518:
    label563:
    label711:
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
                  do
                  {
                    return;
                    if (!(paramObject instanceof MessageRecord)) {
                      break label563;
                    }
                    if (!(paramObject instanceof ChatMessage)) {
                      break label518;
                    }
                    paramObservable = (MessageRecord)paramObject;
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatActivity", 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis());
                    }
                    if (paramObservable.isSendFromLocal()) {
                      break;
                    }
                  } while ((paramObservable.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)));
                  if (a(paramObservable))
                  {
                    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
                    {
                      if ((!paramObservable.isread) && ((paramObservable instanceof MessageForShakeWindow)))
                      {
                        paramObservable = (MessageForShakeWindow)paramObservable;
                        paramObservable.parse();
                        if ((paramObservable.mShakeWindowMsg != null) && (paramObservable.mShakeWindowMsg.onlineFlag == 1))
                        {
                          if (this.jdField_b_of_type_JavaUtilList == null) {
                            this.jdField_b_of_type_JavaUtilList = new ArrayList();
                          }
                          this.jdField_b_of_type_JavaUtilList.add(paramObservable);
                        }
                      }
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                      this.q = true;
                      this.r = true;
                      a(196608);
                    }
                    this.jdField_j_of_type_Boolean = true;
                    return;
                  }
                  if ((paramObservable.istroop == 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.senderuin)) && (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
                  {
                    if ((String.valueOf(AppConstants.Y).equalsIgnoreCase(paramObservable.frienduin)) && (!paramObservable.isread))
                    {
                      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
                      return;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
                    {
                      this.r = true;
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                      a(196608);
                    }
                    this.jdField_j_of_type_Boolean = true;
                    return;
                  }
                } while ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) || (paramObservable.isread));
                a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
                return;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                this.q = true;
                this.jdField_j_of_type_Boolean = true;
                d(true);
              } while ((!(paramObservable instanceof MessageForStructing)) || ((paramObservable.istroop != 1) && (paramObservable.istroop != 3000) && (paramObservable.istroop != 0)) || (!"viewMultiMsg".equals(((MessageForStructing)paramObservable).structingMsg.mMsgAction)));
              MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, paramObservable.uniseq, true);
              return;
              paramObservable = (MessageRecord)paramObject;
            } while ((paramObject == null) || (!(paramObject instanceof DataLineMsgRecord)) || (paramObservable.isread) || (paramObservable.isSendFromLocal()));
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
            return;
            if (!(paramObject instanceof QQMessageFacade.RefreshMessageContext)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = ((QQMessageFacade.RefreshMessageContext)paramObject);
          } while (!(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject instanceof ChatContext));
          paramObservable = (ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.a())) || (this.jdField_b_of_type_Long != paramObservable.a()) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Boolean));
        long l1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean)
        {
          this.p = bool;
          l1 = this.jdField_b_of_type_Long + 300L - SystemClock.uptimeMillis();
          if (l1 <= 0L) {
            break label711;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new zo(this), l1);
          return;
          bool = false;
          break;
          l1 = 0L;
        }
      } while (!(paramObject instanceof QQMessageFacade.MessageNotifyParam));
      paramObservable = (QQMessageFacade.MessageNotifyParam)paramObject;
    } while ((!paramObservable.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramObservable.jdField_b_of_type_Int != 0));
    d(false);
  }
  
  public void v()
  {
    ad();
    u();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localFileTransferManager != null) {
        localFileTransferManager.b();
      }
    }
  }
  
  public void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
  }
  
  public void x()
  {
    this.jdField_i_of_type_Boolean = false;
    aq();
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      P();
    }
  }
  
  public void y()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      h(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (this.q) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711689);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, " read confirm onPause  mReadConfirmHandler");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
      }
      this.jdField_i_of_type_Boolean = false;
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
  
  public void z()
  {
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    if (ChatBackground.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    an();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a();
    }
    StartupTracker.a("AIO_doOnResume_updateUI", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */