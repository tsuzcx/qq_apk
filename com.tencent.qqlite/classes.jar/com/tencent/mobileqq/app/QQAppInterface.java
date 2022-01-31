package com.tencent.mobileqq.app;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import QQService.TagInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.lbsapi.QLBSNotification;
import com.tencent.lbsapi.QLBSService;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.data.TagArrayByType;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.PrivacyInfoUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.managers.DiscussionMemberManager;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.StartService.StartServiceState;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PlistHandler;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import com.tencent.mobileqq.utils.pathtracker.VipPathTracker;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import com.weiyun.sdk.context.SdkContext;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginManagerV2;
import cooperation.qqfav.QfavHelper;
import cuy;
import cuz;
import cva;
import cvb;
import cvc;
import cvd;
import cvi;
import cvj;
import cvk;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AccountManagerImpl;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider, IHttpCommunicatorFlowCount
{
  public static final int A = 23;
  public static final int B = 24;
  public static final int C = 25;
  public static final int D = 26;
  public static final int E = 27;
  public static final int F = 28;
  public static final int G = 29;
  public static final int H = 30;
  public static final int I = 31;
  public static final int J = 32;
  public static final int K = 33;
  public static final int L = 34;
  public static final int M = 35;
  public static final int N = 36;
  public static final int O = 37;
  public static final int P = 38;
  public static final int Q = 39;
  public static final int R = 40;
  public static final int S = 41;
  public static final int T = 42;
  public static final int U = 43;
  public static final int V = 44;
  public static final int W = 45;
  public static final int X = 46;
  public static final int Y = 47;
  public static final int Z = 48;
  public static final byte a = 1;
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 2000L;
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final long[] a;
  public static final int aA = 9;
  public static final int aB = 10;
  public static final int aC = 11;
  public static final int aD = 12;
  public static final int aE = 13;
  public static final int aF = 14;
  public static final int aG = 15;
  public static final int aH = 16;
  public static final int aI = 17;
  public static final int aJ = 18;
  public static final int aK = 19;
  public static final int aL = 20;
  public static final int aM = 21;
  public static final int aN = 22;
  public static final int aO = 23;
  public static final int aP = 24;
  public static final int aQ = 25;
  public static final int aR = 26;
  public static final int aS = 27;
  public static final int aT = 28;
  public static final int aU = 29;
  public static final int aV = 30;
  public static final int aW = 31;
  public static final int aX = 32;
  public static final int aY = 33;
  public static final int aZ = 34;
  public static final int aa = 49;
  public static final int ab = 50;
  public static final int ac = 51;
  public static final int ad = 52;
  public static final int ae = 53;
  public static final int af = 54;
  public static final int ag = 55;
  public static final int ah = 56;
  public static final int ai = 57;
  public static final int aj = 58;
  public static final int ak = 59;
  public static final int am = 0;
  public static final int an = 1;
  public static final int ap = 1;
  public static final int aq = 2;
  public static final int ar = 0;
  public static final int as = 1;
  public static final int at = 2;
  public static final int au = 3;
  public static final int av = 4;
  public static final int aw = 5;
  public static final int ax = 6;
  public static final int ay = 7;
  public static final int az = 8;
  public static final byte b = 2;
  public static final int b = 2;
  public static final String b;
  private static final long[] jdField_b_of_type_ArrayOfLong;
  public static final int ba = 35;
  public static final int bb = 36;
  public static final int bc = 37;
  public static final int bd = 38;
  public static final int be = 3000;
  public static final int bf = 3;
  public static int bi = 0;
  public static int bj = 0;
  public static final int bk = 3;
  public static final int bl = 2;
  public static final int bm = 1;
  private static final int bn = -56;
  private static final int bo = -55;
  private static final int bp = 60;
  private static final int bq = 1;
  private static final int bt = 39;
  private static final int bu = 0;
  public static final byte c = 3;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 86400000L;
  public static final String c = "com.tencent.mobileqq.intent.logout";
  public static boolean c = false;
  public static final byte d = 3;
  public static final int d = 4;
  public static final String d = "Q.qqhead.qaif";
  public static final byte e = 1;
  public static final int e = 1;
  public static final String e = "para_sharealbum_operation_type";
  private static final byte jdField_f_of_type_Byte = 3;
  public static final int f = 4;
  static final String jdField_f_of_type_JavaLangString = "clean_unread_feed_type";
  public static final int g = 11;
  private static final long jdField_g_of_type_Long = 7200000L;
  public static final String g = "clean_unread_sharealbum_type";
  public static final int h = 100;
  public static final String h = "com.tencent.msg.newmessage";
  public static final int i = 32;
  public static final String i = "round";
  public static final int j = 101;
  public static final String j = "B1_QQ_Neighbor_android";
  public static final int k = 102;
  public static final String k = "NzVK_qGE";
  public static final int l = 8;
  private static final String l = "Q.qqhead.broadcast";
  public static final int m = 9;
  private static final String jdField_m_of_type_JavaLangString = "com.tencent.qzone.cleanunreadcount";
  public static final int n = 10;
  private static final String jdField_n_of_type_JavaLangString = "com.tencent.qzone.clean_sharealbum";
  public static final int o = 11;
  private static final String o = "com.tencent.qqhead.getheadreq";
  public static final int p = 12;
  private static final String p = "com.tencent.qqhead.getheadresp";
  public static final int q = 13;
  private static final String q = "notification";
  public static final int r = 14;
  public static final int s = 15;
  public static final int t = 16;
  public static final int u = 17;
  public static final int v = 18;
  public static final int w = 19;
  public static final int x = 20;
  public static final int y = 21;
  public static final int z = 22;
  private LBSInfo jdField_a_of_type_NearbyGroupLBSInfo;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cvb(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  QLBSNotification jdField_a_of_type_ComTencentLbsapiQLBSNotification;
  public QLBSService a;
  private CheckPttListener jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cvd(this);
  public LebaHelper a;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = null;
  private CacheManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  public Automator a;
  volatile ConversationFacade jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  public volatile QQMessageFacade a;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private SosoInterface jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface;
  public AboutConfig a;
  private Config jdField_a_of_type_ComTencentMobileqqConfigConfig;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private FileManagerEngine jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  private FileTransferHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  private FileManagerDataCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  private FileManagerNotifyCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  private FileManagerRSCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  private OnlineFileSessionCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  private PrivacyInfoUtil jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  private HwEngine jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  public MobileQQService a;
  private MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private ProtoReqManager jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_a_of_type_JavaUtilList = new Vector();
  public Set a;
  public boolean a;
  public byte[] a;
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[39];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager[60];
  public int al;
  public int ao = 0;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new cuz(this);
  private Intent jdField_b_of_type_AndroidContentIntent = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new cvc(this, Looper.getMainLooper());
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_b_of_type_JavaUtilList = new Vector();
  boolean jdField_b_of_type_Boolean = false;
  private volatile byte[] jdField_b_of_type_ArrayOfByte = new byte[2];
  public int bg;
  public int bh;
  private final int br = 990;
  private final int bs = 991;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  List jdField_c_of_type_JavaUtilList = new Vector();
  private byte[] jdField_c_of_type_ArrayOfByte;
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  private long jdField_d_of_type_Long = 31L;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  public boolean d;
  private long e;
  public boolean e;
  private long jdField_f_of_type_Long = 0L;
  public boolean f;
  boolean jdField_g_of_type_Boolean;
  public boolean h = true;
  public volatile boolean i = false;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  private boolean jdField_m_of_type_Boolean;
  private volatile boolean jdField_n_of_type_Boolean;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.jdField_a_of_type_JavaLangString))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.jdField_a_of_type_JavaLangString;
      try
      {
        throw new IllegalAccessError("QQAppInterface escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.jdField_b_of_type_JavaLangString = str + "\n" + Log.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "QQAppInterface escapes!");
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaLangString = QQAppInterface.class.getSimpleName();
      jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
      jdField_b_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
      jdField_a_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      jdField_c_of_type_Boolean = false;
      jdField_a_of_type_ArrayOfInt = new int[] { 16, 17, 8, 18, 26, 24, 25, 38, 42 };
      bi = 300000;
      bj = 30000;
      return;
      BaseApplicationImpl.jdField_b_of_type_JavaLangString = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.m = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Long = -1L;
    this.n = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new cvi(this, Looper.getMainLooper());
  }
  
  private void E()
  {
    SosoSrvAddrProvider.a().b();
  }
  
  private void F()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      int i1 = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size() * 3 / 4;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.trimToSize(i1);
    }
  }
  
  private void G()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = new HttpCommunicator(this, 128);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a();
  }
  
  private void H()
  {
    int i2 = 0;
    if (this.i) {
      return;
    }
    this.i = true;
    if (GuardManager.a != null) {
      GuardManager.a.a(false);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.b();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d();
    for (;;)
    {
      Object localObject2;
      int i3;
      int i1;
      Object localObject5;
      synchronized (this.jdField_a_of_type_ArrayOfMqqManagerManager)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfMqqManagerManager;
        i3 = localObject2.length;
        i1 = 0;
        if (i1 < i3)
        {
          localObject5 = localObject2[i1];
          if (localObject5 == null) {
            break label236;
          }
          localObject5.onDestroy();
          break label236;
        }
      }
      synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler;
        i3 = localObject2.length;
        i1 = i2;
        while (i1 < i3)
        {
          localObject5 = localObject2[i1];
          if (localObject5 != null) {
            localObject5.d();
          }
          i1 += 1;
          continue;
          localObject3 = finally;
          throw localObject3;
        }
        if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
        }
        FaceDecodeTask.a();
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.f();
        }
        ThemeSwitchManager.release();
        EquipLockWebImpl.a().a();
        return;
      }
      label236:
      i1 += 1;
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig = new AboutConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a();
    }
  }
  
  private void J()
  {
    ReportController.a(this, false);
    a(new cva(this));
    Object localObject = (GameCenterManagerImp)getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).b();
    }
    localObject = (QZoneManager)getManager(9);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "onstart.test if get qzone unread.");
      }
      ((QZoneManager)localObject).a(1);
    }
    d(false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "zsw subaccount onStart start get sub msg");
    }
  }
  
  private void K()
  {
    ReportController.a(this);
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt)
  {
    if (String.valueOf(AppConstants.Z).equals(paramString))
    {
      paramString = paramContext.getString(2131363241);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
    }
    for (;;)
    {
      paramContext.putExtra("uinname", paramString);
      return paramContext;
      if (String.valueOf(AppConstants.ad).equals(paramString))
      {
        paramString = paramContext.getString(2131363526);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("_key_mode", 3);
      }
      else if (String.valueOf(AppConstants.ae).equals(paramString))
      {
        paramString = paramContext.getString(2131363526);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.aa).equals(paramString))
      {
        paramString = new Intent(paramContext, QQBroadcastActivity.class);
        localObject = paramContext.getString(2131363524);
        paramContext = paramString;
        paramString = (String)localObject;
      }
      else if (String.valueOf(AppConstants.W).equals(paramString))
      {
        paramString = paramContext.getString(2131363526);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(a()));
      }
      else
      {
        if (!String.valueOf(AppConstants.T).equals(paramString)) {
          break;
        }
        paramString = new Intent(paramContext, LiteActivity.class);
        localObject = paramContext.getString(2131361822);
        paramContext = paramString;
        paramString = (String)localObject;
      }
    }
    Object localObject = new Intent(paramContext, ChatActivity.class);
    if (paramInt == 1009) {
      paramContext = paramContext.getString(2131363243);
    }
    for (;;)
    {
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).putExtra("uin", paramString);
      ((Intent)localObject).putExtra("uintype", paramInt);
      ((Intent)localObject).setAction("com.tencent.qqlite.action.CHAT");
      paramString = paramContext;
      paramContext = (Context)localObject;
      break;
      if (String.valueOf(1787740092L).equals(paramString))
      {
        paramContext = paramContext.getString(2131364096);
      }
      else if (paramInt == 1024)
      {
        ((Intent)localObject).setClass(paramContext, ChatActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 1);
        paramContext = ContactUtils.b(this, paramString, paramInt);
      }
      else
      {
        paramContext = ContactUtils.b(this, paramString, paramInt);
      }
    }
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private Drawable a(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = a(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = ImageUtil.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = ImageUtil.b();
      }
      return localObject;
    }
  }
  
  private SQLiteOpenHelper a()
  {
    if (!a().equals("0")) {
      return a().build(a());
    }
    return null;
  }
  
  private SQLiteOpenHelper a(String paramString)
  {
    return a(paramString).build(paramString);
  }
  
  private String a(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    default: 
      return "";
    case 3: 
      return a().getString(2131362887);
    case 4: 
      return a().getString(2131362492);
    }
    return a().getString(2131362493);
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = ContactUtils.c(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((FriendManager)getManager(8)).c(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label264;
          }
        }
      }
    }
    label264:
    for (Object localObject1 = ((Friends)localObject2).remark;; localObject1 = ((Friends)localObject2).name)
    {
      localObject2 = localObject1;
      if (paramBoolean) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(paramMessage.frienduin)) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramMessage.frienduin))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)a(1);
            a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).a(paramMessage.frienduin);
            localObject2 = localObject1;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = paramMessage.frienduin;
      }
      return localObject1;
      localObject1 = ContactUtils.b(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.aF);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    label164:
    label202:
    label208:
    do
    {
      return;
      int i3 = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramContext = new ArrayList();
      ??? = new ArrayList();
      paramIntent = new ArrayList();
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i1;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i1 = 0;
        if (i1 < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i1);
          int i2;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(a(i3, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label202;
            }
            i2 = 1;
            if (i2 == 0) {
              break label208;
            }
            localObject3 = a(i3, str, 0);
            paramContext.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label164;
            paramIntent.add(str);
          }
        }
      }
      if (paramContext.size() > 0)
      {
        localObject2 = new Intent("com.tencent.qqhead.getheadresp");
        ((Intent)localObject2).putExtra("faceType", i3);
        ((Intent)localObject2).putStringArrayListExtra("uinList", paramContext);
        ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
        a().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
      }
      if (paramIntent.size() > 0)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = (FriendListHandler)a(1);
        i1 = 0;
        while (i1 < paramIntent.size())
        {
          str = (String)paramIntent.get(i1);
          if (i3 == 1) {
            ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            do
            {
              this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
              i1 += 1;
              break;
            } while (i3 != 4);
            ((FriendListHandler)localObject2).c(str);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramContext);
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", paramIntent);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "showNotification. cmd=" + paramString4 + ", ticker=" + Utils.a(paramString1) + ",msgShow:" + Utils.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {}
    try
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130838046);
      if (localBitmap != null)
      {
        paramBitmap = new ToServiceMsg("mobileqq.service", a(), paramString4);
        paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
        paramBitmap.extraData.putParcelable("intent", paramIntent);
        paramBitmap.extraData.putParcelable("bitmap", localBitmap);
        a(paramBitmap);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        localBitmap = null;
      }
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    int i2;
    if (f())
    {
      a(paramMessage, true);
      i2 = 0;
      i1 = i2;
      if (this.ao == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      i2 = i1;
      if (paramMessage.istroop == 1001)
      {
        i2 = i1;
        if (paramMessage.msgtype == -3001) {
          i2 = 1;
        }
      }
      if (!AppConstants.Q.equals(paramMessage.senderuin)) {
        break label109;
      }
    }
    label109:
    for (int i1 = i3;; i1 = i2)
    {
      if (i1 != 0) {
        b(paramMessage, paramBoolean2);
      }
      return;
      g(true);
      break;
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = SAXParserFactory.newInstance().newSAXParser();
      Object localObject2 = new PlistHandler();
      ((SAXParser)localObject1).parse(paramInputStream, (DefaultHandler)localObject2);
      if ((((PlistHandler)localObject2).a() instanceof ArrayList))
      {
        paramInputStream = (ArrayList)((PlistHandler)localObject2).a();
        int i3 = paramInputStream.size();
        if (i3 >= 1)
        {
          this.al = Integer.parseInt((String)paramInputStream.get(0));
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i1 = 1;
          while (i1 < i3)
          {
            ArrayList localArrayList1 = (ArrayList)paramInputStream.get(i1);
            localObject1 = (String)localArrayList1.get(0);
            localObject2 = (String)localArrayList1.get(1);
            localArrayList1 = (ArrayList)localArrayList1.get(2);
            ArrayList localArrayList2 = new ArrayList();
            int i2 = 0;
            while (i2 < localArrayList1.size())
            {
              TagInfo localTagInfo = new TagInfo();
              localTagInfo.bType = Byte.parseByte((String)((HashMap)localArrayList1.get(i2)).get("itemTagType"));
              localTagInfo.iTagId = new BigDecimal((String)((HashMap)localArrayList1.get(i2)).get("itemTagID")).longValue();
              localTagInfo.strContent = ((String)((HashMap)localArrayList1.get(i2)).get("itemTagString"));
              localArrayList2.add(localTagInfo);
              i2 += 1;
            }
            localObject1 = new TagArrayByType((String)localObject1, (String)localObject2, localArrayList2);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            i1 += 1;
          }
        }
      }
      return;
    }
    catch (ParserConfigurationException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (SAXException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  private Object[] a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = paramInt1;
    String str = paramString;
    if (paramInt1 != 101)
    {
      i1 = paramInt1;
      str = paramString;
      if (paramString != null)
      {
        Setting localSetting = (Setting)a(paramInt1, paramString, paramInt2).second;
        i1 = paramInt1;
        str = paramString;
        if (localSetting != null)
        {
          i1 = paramInt1;
          str = paramString;
          if (localSetting.bHeadType == 0)
          {
            str = String.valueOf(localSetting.systemHeadID);
            if (paramInt1 != 4) {
              break label99;
            }
          }
        }
      }
    }
    label99:
    for (i1 = -56;; i1 = -55) {
      return new Object[] { Integer.valueOf(i1), str };
    }
  }
  
  private static LBSInfo b(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).b, ((SosoInterface.SosoCell)localObject2).c, ((SosoInterface.SosoCell)localObject2).d, (short)((SosoInterface.SosoCell)localObject2).e));
      }
    }
    Object localObject1 = new GPS(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b, -1, 0);
    Object localObject2 = new ArrayList();
    if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)localIterator.next();
        ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
      }
    }
    return new LBSInfo((GPS)localObject1, (ArrayList)localObject2, localArrayList, new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_b_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c));
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.addFlags(335544320);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    paramContext.setAction("com.tencent.qqlite.action.CHAT");
    return paramContext;
  }
  
  private BusinessHandler b(int paramInt)
  {
    switch (paramInt)
    {
    case 24: 
    default: 
      return null;
    case 0: 
      MessageHandler localMessageHandler = new MessageHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = localMessageHandler;
      return localMessageHandler;
    case 1: 
      return new FriendListHandler(this);
    case 2: 
      return new CardHandler(this);
    case 3: 
      return new LBSHandler(this);
    case 4: 
      return new ConfigHandler(this);
    case 5: 
      return new ReportHandler(this);
    case 6: 
      return new DiscussionHandler(this);
    case 7: 
      return new QZoneNotifyHandler(this);
    case 8: 
      return new DataLineHandler(this);
    case 9: 
      return new RegisterProxySvcPackHandler(this);
    case 11: 
      return new EmosmHandler(this);
    case 12: 
      return new SVIPHandler(this);
    case 13: 
      return new ThemeHandler(this);
    case 14: 
      return new ClubContentUpdateHandler(this);
    case 10: 
      return new PublicAccountHandler(this);
    case 15: 
      return new ShieldListHandler(this);
    case 16: 
      return new SaveTrafficHandler(this);
    case 19: 
      return new BizTroopHandler(this);
    case 17: 
      return new TroopHandler(this);
    case 18: 
      return new EnterpriseQQHandler(this);
    case 20: 
      return new StartAppCheckHandler(this);
    case 21: 
      return new SecSigHandler(this);
    case 22: 
      return new SafeCenterPushHandler(this);
    case 23: 
      return new PushSecSigHandler(this);
    case 25: 
      return new QPSafeCheckHandler(this);
    case 26: 
      return new StrangerHandler(this);
    case 27: 
      return new VipInfoHandler(this);
    case 28: 
      return new CardPayHandler(this);
    case 29: 
      return new QWalletOpenHandler(this);
    case 30: 
      return new RedTouchHandler(this);
    case 31: 
      return new QWalletHomeHandler(this);
    case 32: 
      return new NearFieldDiscussHandler(this);
    case 33: 
      return new SecSvcHandler(this);
    case 34: 
      return new IndividualExpireInfoHandler(this);
    case 35: 
      return new BmqqBusinessHandler(this);
    case 36: 
      return new QWalletAuthHandler(this);
    case 37: 
      return new TroopRedTouchHandler(this);
    }
    return new UniPayHandler(this);
  }
  
  private void b(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject;
    label124:
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if (QLog.isColorLevel())
    {
      localObject = null;
      if (paramMessage != null)
      {
        if (paramMessage.msgtype == -2020) {
          localObject = paramMessage.getBaseInfoString();
        }
      }
      else {
        QLog.d("notification", 2, "message is:" + (String)localObject + ",isOnline is:" + paramBoolean);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "previous vibrate time is:" + this.jdField_e_of_type_Long + ",curr time is:" + System.currentTimeMillis());
      }
      if (this.jdField_e_of_type_Long != -1L) {
        break label375;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      bool1 = h();
      bool4 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool4);
      }
      if ((paramMessage == null) || (!AppConstants.Q.equals(paramMessage.senderuin))) {
        break label499;
      }
      bool2 = false;
      bool3 = false;
      paramMessage = RingtoneManager.getActualDefaultRingtoneUri(a(), 2);
      localObject = (Vibrator)a().getSystemService("vibrator");
      if ((!k()) || (!bool4)) {
        break label423;
      }
      paramBoolean = true;
      bool1 = bool2;
      label259:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool1 + " uri: " + paramMessage);
      }
      if ((paramBoolean) && (localObject != null)) {
        ((Vibrator)localObject).vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((bool1) && (paramMessage != null)) {
        AudioUtil.a(paramMessage, false, false);
      }
    }
    label375:
    boolean bool5;
    label423:
    label499:
    do
    {
      do
      {
        do
        {
          return;
          localObject = "not shake msg,uinSeq is:" + paramMessage.uniseq;
          break;
          if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) > 2000L) {
            break label124;
          }
        } while ((paramMessage == null) || (paramMessage.msgtype != -2020) || (!paramBoolean));
        if (a() == 11L) {
          break label124;
        }
        return;
        if ((i()) && (j()) && (bool4))
        {
          bool1 = true;
          paramBoolean = true;
          break label259;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (!i()) {
          break label259;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (j()) {
          break label259;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (!bool4) {
          break label259;
        }
        bool1 = true;
        paramBoolean = bool3;
        break label259;
      } while ((bool1) || (!bool4));
      localObject = (Vibrator)a().getSystemService("vibrator");
      bool5 = d();
      bool4 = z();
      bool3 = y();
      bool1 = bool3;
      bool2 = bool4;
      if (paramMessage != null)
      {
        bool1 = bool3;
        bool2 = bool4;
        if (paramMessage.istroop == 1)
        {
          if ((!bool4) || (!x())) {
            break label788;
          }
          bool2 = true;
          if ((!bool3) || (!w())) {
            break label794;
          }
          bool1 = true;
        }
      }
      bool3 = m();
      bool4 = v();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool1 + ",isVideoing is:" + bool5 + ",isCallIdle is:" + bool3 + ",notRecordingPtt is:" + bool4);
      }
      if ((bool1) && (bool3) && (!bool5) && (bool4))
      {
        if ((paramMessage != null) && (paramBoolean) && (paramMessage.msgtype == -2020) && (a() == 11L)) {
          ((Vibrator)localObject).vibrate(jdField_a_of_type_ArrayOfLong, -1);
        }
        for (i1 = 2;; i1 = 1)
        {
          int i3 = this.jdField_d_of_type_JavaUtilList.size();
          i2 = 0;
          while (i2 < i3)
          {
            ((VibrateListener)this.jdField_d_of_type_JavaUtilList.get(i2)).k(i1);
            i2 += 1;
          }
          bool2 = false;
          break;
          bool1 = false;
          break label600;
          ((Vibrator)localObject).vibrate(jdField_b_of_type_ArrayOfLong, -1);
        }
      }
    } while ((!bool2) || (bool5) || (k()) || (l()) || (!bool3) || (!bool4));
    label600:
    int i2 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    label788:
    label794:
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = (AudioManager)a().getSystemService("audio");
      localStringBuilder = new StringBuilder().append("StreamVolume=");
      if (localObject != null) {
        break label1012;
      }
    }
    label1012:
    for (int i1 = 0;; i1 = ((AudioManager)localObject).getStreamVolume(2))
    {
      QLog.d("notification", 2, i1 + ",SoundRid=" + i2);
      if (i2 != SoundAndVibrateActivity.b) {
        break label1059;
      }
      localObject = ThemeUtil.getThemeVoiceRootPath();
      if (localObject == null) {
        break;
      }
      localObject = new File((String)localObject + File.separatorChar + "message.mp3");
      if (!((File)localObject).exists()) {
        break;
      }
      AudioUtil.a(Uri.fromFile((File)localObject), false, true);
      return;
    }
    label1059:
    for (i1 = 2131165185;; i1 = i2)
    {
      i2 = i1;
      if (paramMessage != null)
      {
        i2 = i1;
        if (c(paramMessage.frienduin)) {
          i2 = 2131165192;
        }
      }
      AudioUtil.a(i2, false);
      return;
    }
  }
  
  private boolean c(String paramString)
  {
    return (String.valueOf(AppConstants.Y).equals(paramString)) || (String.valueOf(AppConstants.aa).equals(paramString)) || (String.valueOf(AppConstants.Z).equals(paramString));
  }
  
  private String f()
  {
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    return str;
  }
  
  /* Error */
  private String g()
  {
    // Byte code:
    //   0: ldc_w 1553
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 810	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 1557	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 810	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 1560	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 1566	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: ifnull +99 -> 134
    //   38: aload 4
    //   40: astore_2
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: getfield 1571	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 1571	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 1573
    //   78: invokevirtual 1577	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 5
    //   83: iconst_3
    //   84: istore_1
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: astore_3
    //   91: iload_1
    //   92: aload 5
    //   94: arraylength
    //   95: if_icmple +39 -> 134
    //   98: aload 4
    //   100: astore_2
    //   101: new 308	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 1579
    //   116: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: iload_1
    //   125: iconst_1
    //   126: isub
    //   127: istore_1
    //   128: goto -43 -> 85
    //   131: astore_3
    //   132: aload_2
    //   133: astore_3
    //   134: aload_3
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	QQAppInterface
    //   84	44	1	i1	int
    //   15	118	2	str1	String
    //   12	79	3	localObject1	Object
    //   131	1	3	localException	Exception
    //   133	2	3	localObject2	Object
    //   3	120	4	str2	String
    //   28	65	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	30	131	java/lang/Exception
    //   44	52	131	java/lang/Exception
    //   55	62	131	java/lang/Exception
    //   73	83	131	java/lang/Exception
    //   91	98	131	java/lang/Exception
    //   101	124	131	java/lang/Exception
  }
  
  private void g(boolean paramBoolean)
  {
    if ((this.g) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
        break;
      }
      localIntent = a(a(), (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(a().getString(2131363908));
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(a().getString(2131363906));
      label138:
      if (!paramBoolean) {
        break label237;
      }
    }
    label237:
    for (String str = localStringBuffer.toString();; str = null)
    {
      a(localIntent, str, a().getResources().getString(2131363905), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", 0);
      break;
      localStringBuffer.append(i1).append(a().getString(2131363471));
      break label138;
    }
  }
  
  private boolean v()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  private boolean w()
  {
    return c() != 0;
  }
  
  private boolean x()
  {
    return b() != 0;
  }
  
  private boolean y()
  {
    return e() != 0;
  }
  
  private boolean z()
  {
    return d() != 0;
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.j();
    }
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    try
    {
      a(getApplication().getAssets().open("qqtags.xml"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void C()
  {
    int i1 = 2131364048;
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = a();
      bool1 = ((TransFileController)localObject1).c();
      bool2 = ((TransFileController)localObject1).a();
      bool3 = ((TransFileController)localObject1).b();
      localObject2 = BaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      }
      if ((bool1) || (bool2) || (bool3))
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        if (!bool2) {
          break label307;
        }
        if (!bool3) {
          break label296;
        }
      }
    }
    label296:
    label307:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i1 = 2131364047;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i1));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i1);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i1 = 2131364044;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i1 = 2131364045;
            }
          }
          else {
            i1 = 2131364046;
          }
        }
      }
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Wifi app = null,maybe not QQ process");
  }
  
  public int a()
  {
    return AppSetting.jdField_a_of_type_Int;
  }
  
  public int a(String paramString)
  {
    int i3 = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int i4 = arrayOfClass.length;
      int i1 = 0;
      for (;;)
      {
        int i2 = i3;
        if (i1 < i4)
        {
          Class localClass = arrayOfClass[i1];
          if ("id".equals(localClass.getSimpleName())) {
            i2 = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return i2;
        }
        i1 += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public long a()
  {
    if ((getAccount() != null) && (isLogin()))
    {
      if (this.jdField_d_of_type_Long == 31L)
      {
        this.jdField_d_of_type_Long = a().getSharedPreferences("acc_info" + getAccount(), 0).getLong("getProfileStatusNew", 11L);
        if (this.jdField_d_of_type_Long == 31L)
        {
          this.jdField_d_of_type_Long = 11L;
          a(11L, false);
        }
      }
      return this.jdField_d_of_type_Long;
    }
    return -1L;
  }
  
  public LBSInfo a()
  {
    return this.jdField_a_of_type_NearbyGroupLBSInfo;
  }
  
  public Intent a()
  {
    return this.jdField_b_of_type_AndroidContentIntent;
  }
  
  public Intent a(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004)) {
      return b(paramContext, paramMessage, paramBoolean);
    }
    return a(a(), paramMessage.frienduin, paramMessage.istroop);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramString != null) && ((paramString.equals(AppConstants.aa)) || (paramString.equals(AppConstants.Z)) || (paramString.equals(AppConstants.W)) || (paramString.equals(AppConstants.Y)))) {
      return ImageUtil.e();
    }
    if ((paramInt1 == 11) && (!StringUtil.e(paramString))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramInt1 == 101) {
      paramByte1 = 1;
    }
    String str1 = a(paramInt1, paramString, paramByte1, paramInt2);
    Object localObject2 = a(str1);
    int i2 = 0;
    Object localObject1;
    boolean bool1;
    String str2;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
    int i1;
    if (localObject2 == null) {
      if (paramBoolean)
      {
        localObject1 = a(paramInt1, paramString, paramInt2);
        if (localObject1 != null)
        {
          bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
          str2 = a(paramInt1, paramString, paramInt2);
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
          localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
          i1 = 0;
          do
          {
            BitmapManager.a(str2, (BitmapFactory.Options)localObject1, localBitmapDecodeResult);
            if (localBitmapDecodeResult.e == 1) {
              F();
            }
            i1 += 1;
          } while ((i1 < 2) && (localBitmapDecodeResult.e == 1));
          if ((QLog.isColorLevel()) && (localBitmapDecodeResult.e != 0)) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.e + ", facePath=" + str2);
          }
          if ((!bool1) && (localBitmapDecodeResult.e == 1)) {
            return null;
          }
          if (localBitmapDecodeResult.e != 2)
          {
            i1 = 1;
            label330:
            localObject1 = localBitmapDecodeResult.a;
            if ((localObject1 == null) && (localBitmapDecodeResult.e != 1) && (i1 != 0))
            {
              if (paramInt1 != 4) {
                break label1003;
              }
              localObject2 = "troop_" + paramString;
              label383:
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_JavaUtilHashMap == null) {
          this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
        if (localInteger == null)
        {
          i2 = 0;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", nDecodeFailCount = " + i2);
          }
          if (i2 < 1)
          {
            this.jdField_b_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i2 + 1));
            FileUtils.d(str2);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", del the damaged file");
            }
          }
          if (localObject1 == null) {
            break label988;
          }
        }
        switch (paramByte1)
        {
        case 2: 
        default: 
          localObject1 = a((Bitmap)localObject1);
          if (localObject1 == null) {
            break label771;
          }
          a(str1, (Bitmap)localObject1, paramByte2);
          localObject2 = localObject1;
          i2 = i1;
          bool2 = bool1;
          if (((localObject2 == null) && (paramBoolean) && (i2 == 0)) || (bool2))
          {
            if (i2 == 0) {
              break label870;
            }
            paramByte1 = 1;
            localObject1 = (FriendListHandler)a(1);
          }
          switch (paramInt1)
          {
          default: 
            return localObject2;
            i1 = 0;
            break label330;
            i2 = localInteger.intValue();
          }
          break;
        }
      }
      continue;
      localObject1 = a((Bitmap)localObject1, 50, 50);
      continue;
      label771:
      boolean bool2 = bool1;
      i2 = i1;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        i2 = i1;
        localObject2 = localObject1;
        if (localBitmapDecodeResult.e == 0)
        {
          QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte1);
          bool2 = bool1;
          i2 = i1;
          localObject2 = localObject1;
          continue;
          label870:
          paramByte1 = 2;
          continue;
          ((FriendListHandler)localObject1).b(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject1).a(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject1).a(paramString, (byte)0, paramByte1);
          continue;
          i1 = 3000;
          paramInt1 = i1;
          switch (paramInt2)
          {
          default: 
            paramInt1 = i1;
          }
          for (;;)
          {
            ((FriendListHandler)localObject1).a(paramString, paramInt1, (byte)1, paramByte1);
            break;
            paramInt1 = 3000;
            continue;
            paramInt1 = 3001;
            continue;
            paramInt1 = 3002;
          }
          label988:
          bool2 = bool1;
          i2 = i1;
          localObject2 = localObject1;
          continue;
          label1003:
          localObject2 = paramString;
          break label383;
          bool1 = false;
          break;
          bool2 = false;
        }
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return ImageUtil.a(paramBitmap, 50, 50);
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    }
    return null;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.c();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = ImageUtil.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = b((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    int i1 = 200;
    if (paramInt == 3001) {
      i1 = 202;
    }
    for (;;)
    {
      return a(32, paramString, true, i1);
      if (paramInt == 3002) {
        i1 = 204;
      }
    }
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public Drawable a(int paramInt)
  {
    return a(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), paramInt));
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(a(paramBitmap));
  }
  
  public Drawable a(String paramString)
  {
    return a(paramString, (byte)3, false, false);
  }
  
  public Drawable a(String paramString, byte paramByte)
  {
    Bitmap localBitmap = a(11, paramString, paramByte, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.a();
    }
    return new BitmapDrawable(paramString);
  }
  
  public Drawable a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.c();
    }
    return localObject;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, (byte)3);
  }
  
  public Pair a(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    Setting localSetting1;
    for (;;)
    {
      Setting localSetting2 = (Setting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      localSetting1 = localSetting2;
      if (localSetting2 == null)
      {
        localSetting1 = localSetting2;
        if (!this.m)
        {
          localSetting1 = localSetting2;
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
          {
            localSetting1 = localSetting2;
            if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
            {
              localSetting1 = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, str);
              this.jdField_a_of_type_JavaUtilHashMap.put(str, localSetting1);
            }
          }
        }
      }
      if (localSetting1 != null) {
        break;
      }
      return Pair.create(Boolean.valueOf(true), null);
      if (paramInt1 == 32) {
        str = "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      } else {
        str = paramString;
      }
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.d("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.jdField_f_of_type_Long + ", updateTimestamp=" + localSetting1.updateTimestamp);
      }
      return new Pair(Boolean.valueOf(bool), localSetting1);
      if ((localSetting1 == null) || ((localSetting1.updateTimestamp < this.jdField_f_of_type_Long) && (System.currentTimeMillis() - localSetting1.updateTimestamp > 86400000L))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Pair a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = a(1, paramString, (byte)3, true, 0);
    if (paramString == null) {
      paramString = ImageUtil.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public CheckPttListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  }
  
  public LebaHelper a()
  {
    m();
    return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper;
  }
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public SQLiteDatabase a()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.a();
    }
    return null;
  }
  
  public SQLiteDatabase a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public CacheManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)getManager(17));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  }
  
  public ConversationFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)getManager(26));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  }
  
  public MsgProxy a(int paramInt)
  {
    if (a() != null) {
      return a().a().a(paramInt);
    }
    return null;
  }
  
  public MultiMsgProxy a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
    }
    return null;
  }
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)getManager(18));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  }
  
  public DataLineMsgProxy a()
  {
    return a().a();
  }
  
  public ProxyManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)getManager(16));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  }
  
  public SosoInterface.SosoLbsInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  }
  
  public AboutConfig a()
  {
    I();
    return this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig;
  }
  
  public Config a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfig = new Config(this, paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
      return paramString;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localObject1 = (Setting)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
    }
    return localObject1;
  }
  
  public FileManagerEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine = new FileManagerEngine(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  }
  
  public FileTransferHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler = new FileTransferHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  }
  
  public FileManagerDataCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter = new FileManagerDataCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  }
  
  public FileManagerNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  }
  
  public FileManagerRSCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter = new FileManagerRSCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  }
  
  public OnlineFileSessionCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  }
  
  public FileManagerProxy a()
  {
    return a().a();
  }
  
  public PrivacyInfoUtil a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil = new PrivacyInfoUtil();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    return a().a();
  }
  
  public HwEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine = new HwEngine(getApplication(), a(), a(), this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = getAccount();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        localObject1 = new QQEntityManagerFactory((String)localObject1);
        ((QQEntityManagerFactory)localObject1).verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  @Deprecated
  public EntityManagerFactory a(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    return a();
  }
  
  public PicPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(35));
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  }
  
  public MessageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {}
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = new MessageCache(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
    }
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(19));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public ProtoReqManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = new ProtoReqManager(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager;
    }
    finally {}
  }
  
  public TransFileController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = new TransFileController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  }
  
  public HttpCommunicator a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator == null) {
      G();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramInt1 != 32);
    return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.aG);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_thd/");
      continue;
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.aF);
      } else {
        ((StringBuilder)localObject).append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
      }
    }
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object[] arrayOfObject = a(paramInt1, paramString, paramInt2);
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramByte > 0) {
        localStringBuilder.append("_").append(paramByte);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("stranger_").append(String.valueOf(paramInt2)).append("_");
    }
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    Object localObject;
    if (SystemUtil.a())
    {
      localStringBuilder.append(AppConstants.aF);
      localObject = a(paramInt1, paramString, paramInt2);
      switch (((Integer)localObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
      break;
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      paramString = a() + paramString;
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("stranger_").append(String.valueOf(paramInt2)).append("_");
    }
  }
  
  public String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    long l1 = System.currentTimeMillis();
    if ((this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramConfigType)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramConfigType)) && (l1 - ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(paramConfigType)).longValue() < 7200000L))
    {
      paramConfigType = (HashMap)this.jdField_b_of_type_JavaUtilHashtable.get(paramConfigType);
      if (paramConfigType.containsKey(paramString))
      {
        localStringBuilder.append((String)paramConfigType.get(paramString));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        return (String)paramConfigType.get(paramString);
      }
      localStringBuilder.append("null");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (getAccount() == null) {}
    for (Object localObject = "0";; localObject = getAccount())
    {
      localObject = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject, paramConfigType);
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break;
      }
      localStringBuilder.append("null, configText is null");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return null;
    }
    try
    {
      localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
      XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
      cvk localcvk = new cvk(this);
      localXMLReader.setContentHandler(localcvk);
      localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
      localObject = localcvk.a();
      this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
      localStringBuilder.append((String)((HashMap)localObject).get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      paramConfigType = (String)((HashMap)localObject).get(paramString);
      return paramConfigType;
    }
    catch (Exception paramConfigType)
    {
      localStringBuilder.append("null. Exception: ");
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString(), paramConfigType);
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return a(4, paramString, 0);
    }
    return a(1, paramString, 0);
  }
  
  /* Error */
  public HashMap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 388	java/util/HashMap
    //   9: dup
    //   10: invokespecial 532	java/util/HashMap:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 810	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 2189	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   22: new 308	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2191
    //   32: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 730	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   39: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 2194	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: iconst_1
    //   49: anewarray 302	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 2196
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 2202	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +133 -> 203
    //   73: aload 4
    //   75: invokeinterface 2207 1 0
    //   80: ifle +123 -> 203
    //   83: aload 4
    //   85: ldc_w 2196
    //   88: invokeinterface 2210 2 0
    //   93: istore_2
    //   94: new 424	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 425	java/util/ArrayList:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: astore_3
    //   106: aload 4
    //   108: invokeinterface 2213 1 0
    //   113: ifeq +92 -> 205
    //   116: aload 4
    //   118: iload_2
    //   119: invokeinterface 2214 2 0
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull -23 -> 103
    //   129: aload 5
    //   131: aload_3
    //   132: invokevirtual 972	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -33 -> 103
    //   139: astore_3
    //   140: aload 5
    //   142: astore_3
    //   143: aload_3
    //   144: astore 5
    //   146: aload 4
    //   148: ifnull +460 -> 608
    //   151: aload 4
    //   153: invokeinterface 2217 1 0
    //   158: iload_1
    //   159: bipush 254
    //   161: if_icmpne +77 -> 238
    //   164: aload_3
    //   165: ifnull +35 -> 200
    //   168: aload_3
    //   169: invokevirtual 952	java/util/ArrayList:size	()I
    //   172: ifle +28 -> 200
    //   175: aload 7
    //   177: bipush 254
    //   179: invokestatic 1189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aload_3
    //   183: aload_3
    //   184: invokevirtual 952	java/util/ArrayList:size	()I
    //   187: anewarray 302	java/lang/String
    //   190: invokevirtual 2221	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   193: checkcast 2223	[Ljava/lang/String;
    //   196: invokevirtual 1825	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload 7
    //   202: areturn
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore 5
    //   208: aload 4
    //   210: ifnull +398 -> 608
    //   213: aload 4
    //   215: invokeinterface 2217 1 0
    //   220: goto -62 -> 158
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 2217 1 0
    //   236: aload_3
    //   237: athrow
    //   238: aload_3
    //   239: ifnull +357 -> 596
    //   242: aload_0
    //   243: aload_3
    //   244: invokevirtual 2226	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   247: astore 8
    //   249: aload 8
    //   251: ifnull +316 -> 567
    //   254: new 424	java/util/ArrayList
    //   257: dup
    //   258: invokespecial 425	java/util/ArrayList:<init>	()V
    //   261: astore 6
    //   263: new 424	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 425	java/util/ArrayList:<init>	()V
    //   270: astore 4
    //   272: new 424	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 425	java/util/ArrayList:<init>	()V
    //   279: astore 5
    //   281: iconst_0
    //   282: istore_2
    //   283: iload_2
    //   284: aload_3
    //   285: invokevirtual 952	java/util/ArrayList:size	()I
    //   288: if_icmpge +130 -> 418
    //   291: aload_3
    //   292: iload_2
    //   293: invokevirtual 956	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   296: checkcast 302	java/lang/String
    //   299: astore 9
    //   301: aload 8
    //   303: aload 9
    //   305: invokeinterface 2229 2 0
    //   310: checkcast 1113	java/lang/Integer
    //   313: invokevirtual 1838	java/lang/Integer:intValue	()I
    //   316: tableswitch	default:+32 -> 348, 1:+39->355, 2:+60->376, 3:+32->348, 4:+81->397
    //   349: iconst_1
    //   350: iadd
    //   351: istore_2
    //   352: goto -69 -> 283
    //   355: iload_1
    //   356: iconst_m1
    //   357: if_icmpeq +8 -> 365
    //   360: iload_1
    //   361: iconst_1
    //   362: if_icmpne -14 -> 348
    //   365: aload 6
    //   367: aload 9
    //   369: invokevirtual 972	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: goto -25 -> 348
    //   376: iload_1
    //   377: iconst_m1
    //   378: if_icmpeq +8 -> 386
    //   381: iload_1
    //   382: iconst_2
    //   383: if_icmpne -35 -> 348
    //   386: aload 4
    //   388: aload 9
    //   390: invokevirtual 972	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   393: pop
    //   394: goto -46 -> 348
    //   397: iload_1
    //   398: iconst_m1
    //   399: if_icmpeq +8 -> 407
    //   402: iload_1
    //   403: iconst_4
    //   404: if_icmpne -56 -> 348
    //   407: aload 5
    //   409: aload 9
    //   411: invokevirtual 972	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   414: pop
    //   415: goto -67 -> 348
    //   418: aload 6
    //   420: astore_3
    //   421: aload_3
    //   422: ifnull +44 -> 466
    //   425: aload_3
    //   426: invokevirtual 952	java/util/ArrayList:size	()I
    //   429: ifle +37 -> 466
    //   432: iload_1
    //   433: iconst_m1
    //   434: if_icmpeq +8 -> 442
    //   437: iload_1
    //   438: iconst_1
    //   439: if_icmpne +27 -> 466
    //   442: aload 7
    //   444: iconst_1
    //   445: invokestatic 1189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aload_3
    //   449: aload_3
    //   450: invokevirtual 952	java/util/ArrayList:size	()I
    //   453: anewarray 302	java/lang/String
    //   456: invokevirtual 2221	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   459: checkcast 2223	[Ljava/lang/String;
    //   462: invokevirtual 1825	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload 4
    //   468: ifnull +47 -> 515
    //   471: aload 4
    //   473: invokevirtual 952	java/util/ArrayList:size	()I
    //   476: ifle +39 -> 515
    //   479: iload_1
    //   480: iconst_m1
    //   481: if_icmpeq +8 -> 489
    //   484: iload_1
    //   485: iconst_2
    //   486: if_icmpne +29 -> 515
    //   489: aload 7
    //   491: iconst_2
    //   492: invokestatic 1189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aload 4
    //   497: aload 4
    //   499: invokevirtual 952	java/util/ArrayList:size	()I
    //   502: anewarray 302	java/lang/String
    //   505: invokevirtual 2221	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   508: checkcast 2223	[Ljava/lang/String;
    //   511: invokevirtual 1825	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 5
    //   517: ifnull +47 -> 564
    //   520: aload 5
    //   522: invokevirtual 952	java/util/ArrayList:size	()I
    //   525: ifle +39 -> 564
    //   528: iload_1
    //   529: iconst_m1
    //   530: if_icmpeq +8 -> 538
    //   533: iload_1
    //   534: iconst_4
    //   535: if_icmpne +29 -> 564
    //   538: aload 7
    //   540: iconst_4
    //   541: invokestatic 1189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aload 5
    //   546: aload 5
    //   548: invokevirtual 952	java/util/ArrayList:size	()I
    //   551: anewarray 302	java/lang/String
    //   554: invokevirtual 2221	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   557: checkcast 2223	[Ljava/lang/String;
    //   560: invokevirtual 1825	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: aload 7
    //   566: areturn
    //   567: aconst_null
    //   568: astore 4
    //   570: aload 6
    //   572: astore 5
    //   574: goto -153 -> 421
    //   577: astore_3
    //   578: goto -354 -> 224
    //   581: astore_3
    //   582: aconst_null
    //   583: astore 4
    //   585: aconst_null
    //   586: astore_3
    //   587: goto -444 -> 143
    //   590: astore_3
    //   591: aconst_null
    //   592: astore_3
    //   593: goto -450 -> 143
    //   596: aconst_null
    //   597: astore 4
    //   599: aconst_null
    //   600: astore_3
    //   601: aload 6
    //   603: astore 5
    //   605: goto -184 -> 421
    //   608: aload 5
    //   610: astore_3
    //   611: goto -453 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	614	0	this	QQAppInterface
    //   0	614	1	paramInt	int
    //   93	259	2	i1	int
    //   64	68	3	localObject1	Object
    //   139	1	3	localException1	Exception
    //   142	64	3	localObject2	Object
    //   223	69	3	localList	List
    //   420	30	3	localArrayList1	ArrayList
    //   577	1	3	localObject3	Object
    //   581	1	3	localException2	Exception
    //   586	1	3	localObject4	Object
    //   590	1	3	localException3	Exception
    //   592	19	3	localObject5	Object
    //   4	594	4	localObject6	Object
    //   101	508	5	localObject7	Object
    //   1	601	6	localArrayList2	ArrayList
    //   13	552	7	localHashMap	HashMap
    //   247	55	8	localMap	Map
    //   299	111	9	str	String
    // Exception table:
    //   from	to	target	type
    //   106	125	139	java/lang/Exception
    //   129	136	139	java/lang/Exception
    //   15	65	223	finally
    //   73	103	577	finally
    //   106	125	577	finally
    //   129	136	577	finally
    //   15	65	581	java/lang/Exception
    //   73	103	590	java/lang/Exception
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
    return null;
  }
  
  public Map a(List paramList)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.a(paramList, 1);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = true;
    }
    while ((!isLogin()) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    QfavHelper.a(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ((ConfigHandler)a(4)).a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = 0;
    paramString = a(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i1;
    while (paramInt1 <= 3)
    {
      String str = paramString + "_" + paramInt1;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    QQMessageFacade.Message localMessage;
    label170:
    do
    {
      QQMessageFacade localQQMessageFacade;
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
                localQQMessageFacade = a();
              } while (localQQMessageFacade == null);
              localMessage = localQQMessageFacade.a();
            } while (localMessage == null);
            if ((1000 != localMessage.istroop) && (1020 != localMessage.istroop)) {
              break;
            }
            if ((localMessage.frienduin == null) || (!localMessage.frienduin.equalsIgnoreCase(a()))) {
              break label170;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
          return;
          if ((localMessage.senderuin == null) || (!localMessage.senderuin.equalsIgnoreCase(a()))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification ,self message");
        return;
        if ((!a(localMessage)) || (localMessage.needNotification())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("notification", 2, "receivedMsgNotification , isTroopMark");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "receivedMsgNotification , isRunBackground :" + this.isBackground_Pause + ",userActiveStatus:" + this.ao + ",needSoundVibrationsTip:" + paramBoolean1 + ",baseInfo:" + localMessage.getBaseInfoString());
      }
      if (GuardManager.a != null) {
        GuardManager.a.b(0, null);
      }
      boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (((this.isBackground_Pause) || (bool)) && ((localMessage.istroop == 6000) || (this.ao == 0) || ((localMessage.istroop == 1001) && (localMessage.msgtype == -3001))))
      {
        localMessage.counter += paramInt;
        localQQMessageFacade.c(localMessage);
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "receivedMsgNotification , frienduin " + localMessage.frienduin + ",type " + localMessage.istroop + ",counter:" + localMessage.counter);
        }
        a(localMessage, paramBoolean1, paramBoolean2);
        paramInt = localQQMessageFacade.e();
        BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramInt);
        return;
      }
    } while ((localMessage.msgtype == -1013) || (localMessage.msgtype == -1019) || (localMessage.msgtype == -1018));
    if ((paramBoolean1) && ((localMessage.istroop == 6000) || (this.ao == 0) || ((localMessage.istroop == 1001) && (localMessage.msgtype == -3001))))
    {
      if (this.n) {
        break label643;
      }
      b(localMessage, paramBoolean2);
    }
    label559:
    byte[] arrayOfByte;
    for (;;)
    {
      if ((paramBoolean1) && ((localMessage.istroop == 6000) || (this.ao == 0) || ((localMessage.istroop == 1001) && (localMessage.msgtype == -3001))) && (localMessage.istroop == 1001) && (localMessage.msgtype == -3001))
      {
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), localMessage.action);
        break;
        label643:
        if ((this.jdField_c_of_type_ArrayOfLong[0] == localMessage.uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L))
        {
          b(localMessage, paramBoolean2);
        }
        else
        {
          this.jdField_b_of_type_ArrayOfByte[0] = 1;
          arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
          if (!paramBoolean2) {
            break label707;
          }
        }
      }
    }
    label707:
    for (paramInt = 1;; paramInt = 0)
    {
      arrayOfByte[1] = ((byte)paramInt);
      break label559;
      break;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (e())
    {
      a().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getProfileStatusNew", paramLong).commit();
      this.jdField_d_of_type_Long = paramLong;
      if (paramBoolean) {
        l();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void a(Context paramContext, Class paramClass)
  {
    if (!b()) {
      break label7;
    }
    label7:
    while (paramContext == null) {
      return;
    }
    Object localObject;
    if (paramClass == null) {
      if ((paramContext instanceof Activity))
      {
        paramClass = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramContext.getClass());
        localObject = ((Activity)paramContext).getIntent().getExtras();
        paramContext = paramClass;
        if (localObject != null)
        {
          ((Bundle)localObject).remove("single");
          ((Bundle)localObject).remove("selfuin");
          paramClass.putExtras((Bundle)localObject);
          paramContext = paramClass;
        }
      }
    }
    for (;;)
    {
      paramContext.putExtra("fromNotification", true);
      paramContext.addFlags(536870912).addFlags(67108864);
      if (!e()) {
        break;
      }
      String str = a();
      localObject = null;
      Friends localFriends = ((FriendManager)getManager(8)).c(str);
      paramClass = str;
      if (localFriends != null)
      {
        Bitmap localBitmap = SkinUtils.a(a(localFriends.uin, false));
        paramClass = str;
        localObject = localBitmap;
        if (localFriends.name != null)
        {
          paramClass = str;
          localObject = localBitmap;
          if (localFriends.name.length() > 0)
          {
            paramClass = localFriends.name;
            localObject = localBitmap;
          }
        }
      }
      a(paramContext, "", paramClass, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131362788), (Bitmap)localObject, "CMD_IDLE_NOTIFIYCATION");
      return;
      paramContext = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), SplashActivity.class);
      continue;
      paramContext = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramClass);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    a(paramBusinessObserver, false);
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
      }
    }
    while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(CheckPttListener paramCheckPttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener = paramCheckPttListener;
  }
  
  public void a(MsgTabUnreadListener paramMsgTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = paramMsgTabUnreadListener;
  }
  
  public void a(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {}
    while (this.jdField_d_of_type_JavaUtilList.indexOf(paramVibrateListener) >= 0) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.add(paramVibrateListener);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification msgFacade.getMessages().size()" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() + ",msgFacade.getCounter():" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b());
    }
    if ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b() == 0))
    {
      j();
      return;
    }
    if (f())
    {
      a(paramMessage, false);
      return;
    }
    g(false);
  }
  
  public void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.g + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.g) || (!bool)) {
      return;
    }
    Object localObject3 = "";
    Object localObject8 = null;
    Object localObject5 = null;
    Object localObject1;
    if (ActionMsgUtil.d(paramMessage.msgtype)) {
      localObject1 = a().getString(2131364093);
    }
    for (;;)
    {
      Intent localIntent = a(a(), paramMessage, true);
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      Object localObject6 = localIntent.getStringExtra("uinname");
      if ((localObject6 == null) || ("".equals(localObject6))) {
        localObject6 = localIntent.getStringExtra("uin");
      }
      label384:
      label1922:
      for (;;)
      {
        label267:
        Object localObject4;
        label294:
        label366:
        Object localObject7;
        label374:
        label511:
        Object localObject2;
        label443:
        label450:
        label474:
        String str;
        switch (paramMessage.istroop)
        {
        default: 
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() == 1)
          {
            if (AppConstants.ad.equals(paramMessage.frienduin)) {
              localObject5 = a(paramMessage.senderuin, true);
            }
          }
          else
          {
            localObject3 = (String)localObject6 + ": ";
            localObject4 = localObject1;
          }
          break;
        case 3000: 
          for (;;)
          {
            if (ActionMsgUtil.a(paramMessage.msgtype)) {
              if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_b_of_type_JavaLangString, 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
                }
                localObject1 = paramMessage.actMsgContentValue;
                localObject7 = localObject1;
                localObject4 = localObject1;
                if (paramMessage.istroop != 7000) {
                  break label1535;
                }
                if (paramMessage.counter <= 1) {
                  break label1922;
                }
                if (paramMessage.counter <= 100) {
                  break label1560;
                }
                localObject1 = (String)localObject6 + " (" + a().getString(2131363907) + ")";
                if (paramBoolean) {
                  break label1915;
                }
                localObject6 = null;
                if ((paramMessage.istroop != 1001) || (paramMessage.msgtype != -3001)) {
                  break label1612;
                }
                localObject3 = localIntent;
                if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.V))) {
                  break label1848;
                }
                a((Intent)localObject3, (String)localObject6, (String)localObject1, (String)localObject4, (Bitmap)localObject5, "CMD_SHOW_NOTIFIYCATION");
                return;
                if (paramMessage.msgtype == -2009)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
                  break;
                }
                if (paramMessage.msgtype == -2011)
                {
                  try
                  {
                    localObject1 = StructMsgFactory.a(paramMessage.msgData);
                    if (localObject1 == null)
                    {
                      localObject1 = localObject3;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                        localObject1 = localObject3;
                      }
                    }
                    else
                    {
                      localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
                    }
                  }
                  catch (Exception localException)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
                    }
                    localObject2 = "";
                  }
                  break;
                }
                localObject2 = paramMessage.getMessageText();
                if ((localObject2 instanceof QQText))
                {
                  localObject2 = ((QQText)localObject2).a();
                  break;
                }
                localObject2 = new QQText(localObject2.toString(), 3).a();
                break;
                if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
                {
                  str = paramMessage.nickName + "(" + (String)localObject6 + ")" + ":";
                  localObject7 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject2;
                  label815:
                  localObject4 = localObject7;
                  localObject3 = str;
                  localObject5 = localObject8;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                    continue;
                  }
                  localObject3 = (DiscussionHandler)a(6);
                  if (localObject3 == null) {
                    break label1955;
                  }
                }
              }
            }
          }
        }
        label1560:
        label1955:
        for (localObject3 = ((DiscussionHandler)localObject3).a(paramMessage.frienduin, true);; localObject3 = null)
        {
          localObject5 = localObject3;
          localObject4 = localObject7;
          localObject3 = str;
          break label294;
          localObject3 = ContactUtils.a(this, paramMessage.senderuin, 0);
          str = (String)localObject3 + "(" + (String)localObject6 + ")" + ":";
          localObject7 = a(paramMessage) + (String)localObject3 + ": " + (String)localObject2;
          break label815;
          if (paramMessage.msgtype == -1013)
          {
            localObject3 = (String)localObject6 + ":";
            localObject4 = localObject2;
            localObject5 = localObject8;
            break label294;
          }
          if (AnonymousChatHelper.a(paramMessage))
          {
            localObject3 = AnonymousChatHelper.a(paramMessage).jdField_b_of_type_JavaLangString;
            localObject4 = a().getString(2131362566) + (String)localObject3 + "(" + (String)localObject6 + ")" + ":";
            localObject3 = a().getString(2131362566) + (String)localObject3 + ": " + (String)localObject2;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() == 1)
            {
              localObject7 = a(paramMessage.frienduin, (byte)3, false, false);
              localObject5 = localObject4;
              localObject4 = localObject3;
              localObject3 = localObject5;
              localObject5 = localObject7;
              break label294;
              if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
              {
                localObject4 = a(paramMessage) + paramMessage.nickName + "(" + (String)localObject6 + ")" + ":";
                localObject3 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject2;
              }
              else
              {
                localObject3 = ContactUtils.e(this, paramMessage.frienduin, paramMessage.senderuin);
                localObject4 = a(paramMessage) + (String)localObject3 + "(" + (String)localObject6 + ")" + ":";
                localObject3 = a(paramMessage) + (String)localObject3 + ": " + (String)localObject2;
                continue;
                localObject3 = (String)localObject6 + ": ";
                localObject4 = localObject2;
                localObject5 = localObject8;
                break label294;
                localObject5 = a(paramMessage.frienduin, true);
                break label267;
                localObject2 = a().a(AppShareIDUtil.a(paramMessage.shareAppID));
                if ((localObject2 == null) || (((AppShareID)localObject2).messagetail == null) || ("".equals(((AppShareID)localObject2).messagetail)))
                {
                  localObject2 = a().getString(2131363963);
                  break label366;
                }
                localObject2 = a().getString(2131363961) + ((AppShareID)localObject2).messagetail + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131363962);
                break label366;
                label1535:
                localObject3 = (String)localObject3 + (String)localObject7;
                break label384;
                localObject2 = (String)localObject6 + " (" + paramMessage.counter + a().getString(2131363471) + ")";
                break label443;
                label1612:
                if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() > 1)
                {
                  int i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
                  localObject4 = new StringBuffer();
                  ((StringBuffer)localObject4).append(String.format(a().getString(2131363909), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d()) }));
                  if (i1 == 0) {
                    break;
                  }
                  if (i1 > 1000) {
                    ((StringBuffer)localObject4).append(a().getString(2131363906));
                  }
                  for (;;)
                  {
                    localObject3 = new Intent(a(), SplashActivity.class);
                    ((Intent)localObject3).addFlags(335544320);
                    ((Intent)localObject3).putExtra("tab_index", 0);
                    localObject2 = a().getString(2131363905);
                    localObject4 = ((StringBuffer)localObject4).toString();
                    localObject5 = null;
                    break;
                    ((StringBuffer)localObject4).append(i1).append(a().getString(2131363471));
                  }
                }
                if (paramMessage.istroop == 0)
                {
                  localIntent.putExtra("need_report", true);
                  localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
                  localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
                  localIntent.putExtra("KEY_FROM", "notifcation");
                }
                localObject3 = localIntent;
                break label474;
                label1848:
                if (!QQUtils.a(a())) {
                  break label511;
                }
                localObject7 = (QQLSRecentManager)getManager(56);
                if (!SettingCloneUtil.readValue(a(), a(), a().getString(2131363738), "qqsetting_lock_screen_whenexit_key", true)) {
                  break label511;
                }
                ((QQLSRecentManager)localObject7).a(this, paramMessage.frienduin, paramMessage.istroop, true);
                break label511;
                label1915:
                localObject6 = localObject3;
                break label450;
                localObject2 = localObject6;
                break label443;
                localObject7 = localObject2;
                break label374;
              }
            }
          }
          localObject5 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject5;
          localObject5 = localObject8;
          break label294;
        }
      }
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a(paramResourcePluginListener);
  }
  
  public void a(Setting paramSetting)
  {
    paramSetting = paramSetting.clone();
    paramSetting.url = null;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramSetting.uin, paramSetting);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  public void a(String arg1, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {
      return;
    }
    Object localObject3;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        this.jdField_a_of_type_JavaUtilHashtable.remove(???);
        if (paramInt == 1)
        {
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 990;
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
          if (this.jdField_a_of_type_JavaUtilHashtable.size() <= 50) {
            break;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            long l1 = System.currentTimeMillis();
            ??? = new ArrayList();
            localObject3 = this.jdField_a_of_type_JavaUtilHashtable.keys();
            if (!((Enumeration)localObject3).hasMoreElements()) {
              break label268;
            }
            String str = (String)((Enumeration)localObject3).nextElement();
            if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) <= 180000L) {
              continue;
            }
            ((ArrayList)???).add(str);
          }
        }
      }
      if (paramInt == 4)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 991;
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
      }
    }
    label268:
    paramInt = 0;
    while (paramInt < localObject2.size())
    {
      localObject3 = (String)localObject2.get(paramInt);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject3);
      paramInt += 1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      return;
    }
    int i1;
    if (paramInt == 3000) {
      i1 = 200;
    }
    for (;;)
    {
      Object localObject = a(32, paramString, i1);
      if ((localObject == null) || (((Pair)localObject).second == null)) {
        break;
      }
      long l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      if (l1 == paramLong) {
        break;
      }
      localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
      return;
      if (paramInt == 3001)
      {
        i1 = 202;
      }
      else
      {
        if (paramInt != 3002) {
          break;
        }
        i1 = 204;
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 3000) && (paramInt != 3002) && (paramInt != 3001));
      if (paramBoolean)
      {
        int i1 = 202;
        if (paramInt == 3000) {
          i1 = 200;
        }
        a(32, paramString, i1);
        localObject = new File(a(32, paramString, i1));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null)
    {
      String str = RoamSettingController.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localRoamSettingController.a(str, paramInteger);
      TroopAssistantManager.a().a(this, paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    boolean bool1 = h();
    boolean bool2 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2);
    }
    if ((!bool1) && (bool2))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
      Vibrator localVibrator = (Vibrator)a().getSystemService("vibrator");
      bool1 = d();
      bool2 = z();
      boolean bool3 = y();
      boolean bool4 = m();
      boolean bool5 = v();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!k()) && (!l()) && (m()) && (v()))
      {
        int i1 = localSharedPreferences.getInt("sound_type" + a(), 2131165185);
        if (c(paramString)) {
          i1 = 2131165192;
        }
        AudioUtil.b(i1, false);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    B();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i1 = 0;
    label14:
    TagInfo localTagInfo1;
    TagArrayByType localTagArrayByType;
    int i2;
    if (i1 < paramArrayList.size())
    {
      localTagInfo1 = (TagInfo)paramArrayList.get(i1);
      if ((localTagInfo1 != null) && ((localTagInfo1.strContent == null) || ("".equals(localTagInfo1.strContent.trim()))))
      {
        localTagArrayByType = null;
        i2 = 0;
        label67:
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localTagArrayByType = (TagArrayByType)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if (localTagInfo1.bType != ((TagInfo)localTagArrayByType.mTags.get(0)).bType) {
            break label234;
          }
        }
        i2 = 0;
      }
    }
    for (;;)
    {
      if (i2 < localTagArrayByType.mTags.size())
      {
        TagInfo localTagInfo2 = (TagInfo)localTagArrayByType.mTags.get(i2);
        if ((localTagInfo2 != null) && (localTagInfo2.iTagId == localTagInfo1.iTagId)) {
          localTagInfo1.strContent = localTagInfo2.strContent;
        }
      }
      else
      {
        if ((localTagInfo1 != null) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.SetUserInfoReq", 2, "id = " + localTagInfo1.iTagId + ", strContent = " + localTagInfo1.strContent);
        }
        i1 += 1;
        break label14;
        break;
        label234:
        i2 += 1;
        break label67;
      }
      i2 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i1 = i2;
      while (i1 < i3)
      {
        getManager(arrayOfInt[i1]);
        i1 += 1;
      }
    }
    while (i1 < 60)
    {
      if (i1 != 22) {
        getManager(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(getAccount(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)a(2)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131363059) + a(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.wSignatureLen = ((short)this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature.length);
    }
  }
  
  public boolean a()
  {
    return isLogin();
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    byte b1 = 3;
    if (paramInt1 == 101) {
      b1 = 1;
    }
    String str = a(paramInt1, paramString, b1, paramInt2);
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null) {}
    do
    {
      return true;
      paramString = new File(a(paramInt1, paramString, paramInt2));
    } while ((paramString.exists()) && (paramString.isFile()));
    return false;
  }
  
  public boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(paramContext)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  @Deprecated
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences(a(), 0).getLong(a() + paramString, 1L) == 1L) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = b(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localRoamSettingController.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.bg;
      this.bg = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.bh;
      this.bh = (i1 + 1);
    } while (i1 >= 3);
    ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public byte[] a()
  {
    return a(true);
  }
  
  /* Error */
  public byte[] a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 511	com/tencent/mobileqq/app/QQAppInterface:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 1167	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_ArrayOfByte	[B
    //   12: iconst_0
    //   13: putstatic 2756	com/tencent/mobileqq/app/LBSHandler:A	I
    //   16: aload_0
    //   17: getfield 834	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: invokestatic 2761	com/tencent/mobileqq/app/soso/SosoInterface:a	()Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   27: putfield 834	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   30: aload_0
    //   31: new 2763	cve
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 2764	cve:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   39: putfield 828	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   42: invokestatic 648	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +13 -> 58
    //   48: ldc_w 2766
    //   51: iconst_2
    //   52: ldc_w 2768
    //   55: invokestatic 652	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: new 597	android/os/Handler
    //   61: dup
    //   62: invokestatic 469	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   65: invokespecial 2771	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   68: new 2773	cvf
    //   71: dup
    //   72: aload_0
    //   73: iload_1
    //   74: invokespecial 2776	cvf:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   77: invokevirtual 2780	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   80: pop
    //   81: aload_0
    //   82: getfield 834	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   85: astore_3
    //   86: aload_3
    //   87: monitorenter
    //   88: getstatic 2756	com/tencent/mobileqq/app/LBSHandler:A	I
    //   91: ifne +20 -> 111
    //   94: aload_0
    //   95: getfield 831	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   98: ifnonnull +13 -> 111
    //   101: aload_0
    //   102: getfield 834	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   105: ldc2_w 2781
    //   108: invokevirtual 2785	java/lang/Object:wait	(J)V
    //   111: aload_3
    //   112: monitorexit
    //   113: aload_2
    //   114: monitorexit
    //   115: aload_0
    //   116: getfield 1167	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_ArrayOfByte	[B
    //   119: areturn
    //   120: astore 4
    //   122: aload_3
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    //   127: astore_3
    //   128: invokestatic 648	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +33 -> 164
    //   134: ldc_w 2766
    //   137: iconst_2
    //   138: new 308	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 2787
    //   148: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_3
    //   152: invokevirtual 2788	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 652	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: bipush 245
    //   166: putstatic 2756	com/tencent/mobileqq/app/LBSHandler:A	I
    //   169: goto -56 -> 113
    //   172: astore_3
    //   173: aload_2
    //   174: monitorexit
    //   175: aload_3
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	QQAppInterface
    //   0	177	1	paramBoolean	boolean
    //   4	170	2	localObject1	Object
    //   127	25	3	localInterruptedException	java.lang.InterruptedException
    //   172	4	3	localObject2	Object
    //   120	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   88	111	120	finally
    //   111	113	120	finally
    //   122	124	120	finally
    //   81	88	127	java/lang/InterruptedException
    //   124	127	127	java/lang/InterruptedException
    //   7	42	172	finally
    //   42	58	172	finally
    //   58	81	172	finally
    //   81	88	172	finally
    //   113	115	172	finally
    //   124	127	172	finally
    //   128	164	172	finally
    //   164	169	172	finally
    //   173	175	172	finally
  }
  
  public String[] a()
  {
    Object localObject = a(-1);
    String[] arrayOfString1 = (String[])((HashMap)localObject).get(Integer.valueOf(1));
    String[] arrayOfString2 = (String[])((HashMap)localObject).get(Integer.valueOf(4));
    localObject = (String[])((HashMap)localObject).get(Integer.valueOf(2));
    if (arrayOfString1 != null) {}
    for (int i2 = arrayOfString1.length + 0;; i2 = 0)
    {
      int i1 = i2;
      if (arrayOfString2 != null) {
        i1 = i2 + arrayOfString2.length;
      }
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + localObject.length;
      }
      String[] arrayOfString3;
      if (i2 > 0)
      {
        arrayOfString3 = new String[i2];
        if (arrayOfString1 == null) {
          break label153;
        }
        System.arraycopy(arrayOfString1, 0, arrayOfString3, 0, arrayOfString1.length);
      }
      label153:
      for (i1 = arrayOfString1.length;; i1 = 0)
      {
        if (arrayOfString2 != null)
        {
          System.arraycopy(arrayOfString2, 0, arrayOfString3, 0, arrayOfString2.length);
          i1 = arrayOfString2.length;
        }
        if (localObject != null) {
          System.arraycopy(localObject, 0, arrayOfString3, i1, localObject.length);
        }
        return arrayOfString3;
        return null;
      }
    }
  }
  
  public String[] a(int paramInt)
  {
    return (String[])a(paramInt).get(Integer.valueOf(paramInt));
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] = paramManager;
  }
  
  public int b()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = a((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130839359);
    if (localBitmap != null) {
      new Canvas(paramBitmap).drawBitmap(localBitmap, paramBitmap.getWidth() - localBitmap.getWidth() - 1, paramBitmap.getHeight() - localBitmap.getHeight() - 1, new Paint());
    }
    return paramBitmap;
  }
  
  public Drawable b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public Drawable b(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public SQLiteDatabase b()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.b();
    }
    return null;
  }
  
  public SQLiteDatabase b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b();
    }
    return null;
  }
  
  public Config b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
      a(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
  }
  
  /* Error */
  public Setting b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 816	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   4: invokevirtual 2820	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ldc_w 1178
    //   14: aload_1
    //   15: invokevirtual 1914	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   18: checkcast 1178	com/tencent/mobileqq/data/Setting
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 2821	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 1659	java/lang/Exception:printStackTrace	()V
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: invokevirtual 2821	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 2821	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -11 -> 54
    //   68: astore_1
    //   69: goto -34 -> 35
    //   72: aconst_null
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QQAppInterface
    //   0	74	1	paramString	String
    //   9	50	2	localEntityManager1	EntityManager
    //   7	39	3	localEntityManager2	EntityManager
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/Exception
    //   0	8	51	finally
    //   10	22	64	finally
    //   37	41	64	finally
    //   10	22	68	java/lang/Exception
  }
  
  public String b()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("QQLite", 0);
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (Object localObject2 = ((SharedPreferences)localObject1).getString("serverlist_wifi", null);; localObject2 = ((SharedPreferences)localObject1).getString("serverlist_2g3g", null))
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).split(",");
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = localObject2[((int)(Math.random() * localObject2.length))];
        }
      }
      return localObject1;
    }
  }
  
  public String b(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public void b()
  {
    int i1 = 0;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      while (i1 < ((List)localObject).size())
      {
        Setting localSetting = (Setting)((List)localObject).get(i1);
        localSetting.url = null;
        this.jdField_a_of_type_JavaUtilHashMap.put(localSetting.uin, localSetting);
        i1 += 1;
      }
    }
    this.m = true;
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.qqhead.getheadreq");
    a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b(int paramInt)
  {
    boolean bool1 = d();
    boolean bool2 = g();
    if ((!h()) && (bool2) && (!bool1) && (!k()) && (!l()) && (m()) && (v()))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder((String)localObject);
        ((StringBuilder)localObject).append(File.separatorChar).append("voice").append(File.separatorChar).append("tab").append(paramInt).append(".mp3");
        File localFile = new File(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d("playThemeVoice", 2, "Uri:" + ((StringBuilder)localObject).toString());
        }
        if (localFile.exists()) {
          AudioUtil.a(Uri.fromFile(localFile), false, false);
        }
      }
    }
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (!this.jdField_c_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      this.jdField_c_of_type_JavaUtilList.add(paramBusinessObserver);
    }
  }
  
  public void b(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramVibrateListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    I();
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(paramResourcePluginListener);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
    }
    Handler localHandler = a(Conversation.class);
    if (localHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramString;
      localMessage.arg1 = 2;
      localMessage.what = 1134024;
      localHandler.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 3000) && (paramInt != 3002) && (paramInt != 3001));
      int i1 = 202;
      if (paramInt == 3000) {
        i1 = 200;
      }
      a(32, paramString, i1);
      paramString = new File(a(32, paramString, i1));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, a() + " qq start to exit ");
    }
    H();
    MobileQQ localMobileQQ;
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value in exit........... kickpc = false");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false);
        ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
      }
    }
    else
    {
      if (GuardManager.a != null) {
        GuardManager.a.a();
      }
      localMobileQQ = getApplication();
      if (this.jdField_a_of_type_Boolean) {
        break label183;
      }
    }
    label183:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localMobileQQ.QQProcessExit(paramBoolean);
      i();
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true);
      break;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "setVisibilityForPeople| visible = " + paramBoolean1 + ", updateLocOrNet = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSharedPreferences(a(), 0).edit().putLong("nearby_enter_time", System.currentTimeMillis() - 28800000L).commit();
    }
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131363056) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).a(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      String str = a().getString(2131363991);
      if (str != null) {
        bool = SettingCloneUtil.readValue(a(), null, str, "qqsetting_notify_icon_key", false);
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = a().k(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)a(2)).b();
    }
    return a().getBoolean(a().getString(2131363059) + a(), true);
  }
  
  /* Error */
  public byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 509	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 2982	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   11: ifnonnull +41 -> 52
    //   14: aload_0
    //   15: new 2984	cvg
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 2985	cvg:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: putfield 2987	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSNotification	Lcom/tencent/lbsapi/QLBSNotification;
    //   26: aload_0
    //   27: new 2989	com/tencent/lbsapi/QLBSService
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 782	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   35: aload_0
    //   36: getfield 2987	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSNotification	Lcom/tencent/lbsapi/QLBSNotification;
    //   39: ldc 203
    //   41: ldc 207
    //   43: ldc_w 2991
    //   46: invokespecial 2994	com/tencent/lbsapi/QLBSService:<init>	(Landroid/content/Context;Lcom/tencent/lbsapi/QLBSNotification;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: putfield 2982	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   52: invokestatic 648	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +13 -> 68
    //   58: ldc_w 2766
    //   61: iconst_2
    //   62: ldc_w 2996
    //   65: invokestatic 652	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: ldc_w 2766
    //   71: ldc_w 2998
    //   74: invokestatic 3003	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 507	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ArrayOfByte	[B
    //   82: new 597	android/os/Handler
    //   85: dup
    //   86: invokestatic 469	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   89: invokespecial 2771	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   92: new 3005	cvh
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 3006	cvh:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   100: invokevirtual 2780	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   103: pop
    //   104: aload_0
    //   105: getfield 2982	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   108: astore_2
    //   109: aload_2
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield 2982	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   115: ldc2_w 2781
    //   118: invokevirtual 2785	java/lang/Object:wait	(J)V
    //   121: aload_2
    //   122: monitorexit
    //   123: aload_1
    //   124: monitorexit
    //   125: aload_0
    //   126: getfield 507	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ArrayOfByte	[B
    //   129: areturn
    //   130: astore_3
    //   131: aload_2
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 3007	java/lang/InterruptedException:printStackTrace	()V
    //   140: goto -17 -> 123
    //   143: astore_2
    //   144: aload_1
    //   145: monitorexit
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	QQAppInterface
    //   4	141	1	localObject1	Object
    //   135	2	2	localInterruptedException	java.lang.InterruptedException
    //   143	4	2	localObject2	Object
    //   130	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   111	123	130	finally
    //   131	133	130	finally
    //   104	111	135	java/lang/InterruptedException
    //   133	135	135	java/lang/InterruptedException
    //   7	52	143	finally
    //   52	68	143	finally
    //   68	104	143	finally
    //   104	111	143	finally
    //   123	125	143	finally
    //   133	135	143	finally
    //   136	140	143	finally
    //   144	146	143	finally
  }
  
  public int c()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.vibrate", 0);
    }
    return 0;
  }
  
  public Drawable c(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public String c()
  {
    FriendManager localFriendManager = (FriendManager)getManager(8);
    if (localFriendManager != null) {
      return localFriendManager.a(a());
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onMessageConnect...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!e())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    }
    d();
    a().a();
  }
  
  public void c(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void c(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_c_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void c(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.b(paramResourcePluginListener);
    }
  }
  
  public void c(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.c(paramString);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131363057) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).b(paramBoolean1);
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(a(), a(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public final boolean c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).c();
    }
    return a().getBoolean(a().getString(2131364404) + a(), true);
  }
  
  public byte[] c()
  {
    if ((getAccount() != null) && (isLogin()) && (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey;
    }
    return null;
  }
  
  protected boolean canAutoLogin(String paramString)
  {
    boolean bool = SharedPreUtils.a(getApplication().getApplicationContext(), paramString);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "CNR canAutoLogin autoLogin = " + bool);
    }
    return bool;
  }
  
  public int d()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  public String d()
  {
    return ((TicketManager)getManager(2)).getVkey(getAccount());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnOpenAndStartGetMsg");
    }
    LoadingStateManager.a().a(1);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void d(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void d(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)a(1);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.d(paramString);
      return;
    }
    localFriendListHandler.b(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).d(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131364404) + a(), paramBoolean1).commit();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean);
    }
    if (0 != 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + false + " forground=" + BaseActivity.mAppForground);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
      }
    }
  }
  
  public int e()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public String e()
  {
    String str = d();
    if (str != null) {
      try
      {
        str = HexUtil.a(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  public void e()
  {
    BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(new cuy(this));
  }
  
  public void e(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    a().edit().putBoolean(a().getString(2131363055) + a(), paramBoolean).commit();
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.bg = 1;
    }
    for (;;)
    {
      ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.bh = 1;
    }
  }
  
  public boolean e()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  public int f()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnClose");
    }
    this.jdField_e_of_type_Boolean = false;
    LoadingStateManager.a().a(1);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void f(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void f(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131363045) + a(), paramBoolean);
    localEditor.commit();
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean f()
  {
    return SettingCloneUtil.readValue(a(), a(), a().getString(2131363281), "qqsetting_notify_showcontent_key", true);
  }
  
  protected void finalize()
  {
    super.finalize();
    EntityManagerFactory localEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    if (localEntityManagerFactory != null) {
      localEntityManagerFactory.close();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onRecvFistResp");
    }
    this.jdField_e_of_type_Boolean = true;
    Handler localHandler = a(Conversation.class);
    if (!LoadingStateManager.a().d())
    {
      LoadingStateManager.a().a(2);
      if (localHandler != null) {
        localHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    for (;;)
    {
      if (localHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.arg1 = 0;
        localMessage.what = 1134024;
        localHandler.sendMessage(localMessage);
      }
      return;
      if ((LoadingStateManager.a().b()) && (localHandler != null)) {
        localHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void g(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.b(paramBoolean1, paramBoolean2);
    }
  }
  
  boolean g()
  {
    if (z())
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(this);
      if ((localObject != null) && (!((String)localObject).equals("1000")))
      {
        localObject = ThemeUtil.getThemeInfo(getApplication(), (String)localObject);
        if ((localObject != null) && (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager1 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
    if (localManager1 == null) {}
    for (;;)
    {
      Manager localManager2;
      synchronized (this.jdField_a_of_type_ArrayOfMqqManagerManager)
      {
        localManager2 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
        if ((localManager2 == null) && ((getAccount() != null) || (paramInt <= 7))) {
          break label695;
        }
        return localManager2;
        if (localManager1 != null) {
          addManager(paramInt, localManager1);
        }
        return localManager1;
      }
      Object localObject2 = new ProxyIpManagerImpl(this);
      continue;
      localObject2 = new WtloginManagerImpl(this);
      continue;
      localObject2 = new TicketManagerImpl(this);
      continue;
      localObject2 = new AccountManagerImpl(this);
      continue;
      localObject2 = new FriendsManagerImp(this);
      continue;
      localObject2 = new TroopManager(this);
      continue;
      localObject2 = new TroopInfoManager(this);
      continue;
      localObject2 = new QZoneManagerImp(this);
      continue;
      localObject2 = new PhoneContactManagerImp(this);
      continue;
      localObject2 = new GameCenterManagerImp(this);
      continue;
      localObject2 = new WebProcessManager(this);
      continue;
      localObject2 = new EmoticonManagerImp(this);
      continue;
      localObject2 = new RoamSettingManager(this);
      continue;
      localObject2 = StatusManager.a(this);
      continue;
      localObject2 = new ShieldMsgManger(this);
      continue;
      localObject2 = new ProxyManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)localObject2);
      continue;
      localObject2 = new CacheManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)localObject2);
      continue;
      getManager(26);
      localObject2 = new QQMessageFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)localObject2);
      continue;
      localObject2 = new ConversationFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)localObject2);
      continue;
      localObject2 = new NetEngineFactory();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject2);
      continue;
      localObject2 = new FileTransferManager(this);
      continue;
      localObject2 = new MediaPlayerManager(this);
      continue;
      localObject2 = IPluginManager.a(this);
      continue;
      localObject2 = new RoamSettingController(this);
      continue;
      localObject2 = new DiscussionMemberManager(this);
      continue;
      localObject2 = new NewFriendManager(this);
      continue;
      localObject2 = new TroopCreateLogic(this);
      continue;
      localObject2 = new RecentManagerFor3rdPart(this);
      continue;
      localObject2 = new RedTouchManager(this);
      continue;
      localObject2 = new ContactSyncManager(this);
      continue;
      localObject2 = new PicPreDownloader(this);
      continue;
      localObject2 = new FontManager(this);
      continue;
      localObject2 = new BubbleManager(this);
      continue;
      localObject2 = new EmojiManager(this);
      continue;
      localObject2 = new DownloaderFactory(this);
      continue;
      localObject2 = new TroopGagMgr(this);
      continue;
      localObject2 = new FriendsManager(this);
      continue;
      localObject2 = new DiscussionManager(this);
      continue;
      localObject2 = new ContactFacade(this);
      continue;
      localObject2 = new SearchHistoryManager(this);
      continue;
      localObject2 = new ConditionSearchManager(this);
      continue;
      localObject2 = new ShortVideoTransManager(this);
      continue;
      localObject2 = new ChatBackgroundManagerImp(this);
      continue;
      localObject2 = new QQLSRecentManager(this);
      continue;
      localObject2 = new DeviceProfileManager.AccountDpcManager(this);
      continue;
      localObject2 = new EqqDetailDataManager(this);
      continue;
      localObject2 = new TroopTipsMsgMgr(this);
      continue;
      localObject2 = new TroopRedTouchManager(this);
      continue;
      localObject2 = new PicStatisticsManager(this);
      continue;
      localObject2 = new EarlyDownloadManager(this);
      continue;
      return localObject2;
      label695:
      localObject2 = localManager2;
      switch (paramInt)
      {
      }
      localObject2 = localManager2;
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "cmd_connAllFailed", "cmd_recvFirstResp", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnAllFailed");
    }
    LoadingStateManager.a().a(4);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i1 = localAudioManager.getRingerMode();
        if (i1 == 0) {
          return true;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        i1 = 2;
        continue;
      }
      return false;
      int i1 = 2;
    }
  }
  
  public void i()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      localNotificationManager.cancel(122);
      label31:
      a(new ToServiceMsg("mobileqq.service", a(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public boolean i()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void j()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      label25:
      a(a());
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public boolean j()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(a().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(a().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = null;
  }
  
  public boolean k()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
  
  public void l()
  {
    AppRuntime.Status localStatus;
    if (isLogin()) {
      switch ((int)a())
      {
      default: 
        localStatus = AppRuntime.Status.offline;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value in sendRegisterPush........... kickpc = " + c());
      }
      sendOnlineStatus(localStatus, c());
      return;
      localStatus = AppRuntime.Status.online;
      continue;
      localStatus = AppRuntime.Status.away;
      continue;
      localStatus = AppRuntime.Status.invisiable;
    }
  }
  
  public boolean l()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {}
    ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
    LoadingStateManager.a().a();
    H();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC in app  do logout");
    }
    String str = a();
    if (str != null) {
      SdkContext.cleanCokiee(a(), Long.parseLong(str));
    }
    super.logout(paramBoolean);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper = new LebaHelper(this);
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
  }
  
  public boolean m()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)a().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.c();
    }
  }
  
  public final boolean n()
  {
    return a().getBoolean(a().getString(2131363055) + a(), false);
  }
  
  public void o()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.jdField_b_of_type_ArrayOfByte));
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).a();
      } while (localObject == null);
      this.jdField_c_of_type_ArrayOfLong[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.jdField_c_of_type_ArrayOfLong[1] = 1L;
    } while (this.jdField_b_of_type_ArrayOfByte[0] != 1);
    if (this.jdField_b_of_type_ArrayOfByte[1] == 1) {}
    for (;;)
    {
      b((QQMessageFacade.Message)localObject, bool);
      this.jdField_b_of_type_ArrayOfByte[0] = 0;
      return;
      bool = false;
    }
  }
  
  public boolean o()
  {
    return a().getBoolean(a().getString(2131363056) + a(), false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReportController.a(this);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService = new MobileQQService(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (e())
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().createEntityManager();
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{{4,3,5,6},[11,13],16,19,20,21,36,37,[49,24,10,25,26,27,28,29,30,32,33,34,35,39,40,45,41,43,44,48,50],46,51}"));
      }
      if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
    }
    paramBundle = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
      ProfileCardUtil.a();
    }
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    this.jdField_d_of_type_Boolean = true;
    a().d();
  }
  
  protected void onDestroy()
  {
    int i1 = 0;
    super.onDestroy();
    BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    H();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundSettingActivity.f();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(a()).edit();
    ((SharedPreferences.Editor)localObject).putString("LastScreenShotUri", "");
    ((SharedPreferences.Editor)localObject).commit();
    localObject = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("no_auto_reply" + getAccount(), "");
    ((SharedPreferences.Editor)localObject).commit();
    i();
    n();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label140:
      UniformDownloadMgr.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
        a().b();
      }
      Config.b();
      AppLaucherHelper.a();
      TroopFileUploadingManager.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter.e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine != null) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine.closeEngine();
      }
      if (!TextUtils.isEmpty(a())) {
        QQOperateManager.a(this).a();
      }
      a().e();
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      }
      localObject = ((Context)localObject).getSharedPreferences("Last_Login", i1);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("exitUin", ((SharedPreferences)localObject).getString("uin", "")).commit();
      }
      return;
    }
    catch (Exception localException)
    {
      break label140;
    }
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (PluginManagerV2)getManager(25);
  }
  
  public void onProxyIpChanged()
  {
    Object localObject = BaseApplication.getContext();
    String str = a();
    localObject = ConfigManager.getInstance((Context)localObject, this, a(), str);
    if (localObject != null) {
      ((ConfigManager)localObject).onProxyIpChanged(this);
    }
  }
  
  public void onRunningBackground(Bundle paramBundle)
  {
    super.onRunningBackground(paramBundle);
    paramBundle = a();
    if (paramBundle != null)
    {
      int i1 = paramBundle.e();
      if (isLogin()) {
        BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
      K();
    }
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = a();
    if ((localObject != null) && (((QQMessageFacade)localObject).e() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    ReportController.a(this, false);
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
      J();
    }
  }
  
  public void p()
  {
    b(null, false);
  }
  
  public boolean p()
  {
    return a().getBoolean(a().getString(2131363057) + a(), false);
  }
  
  public void q()
  {
    ((LBSHandler)a(3)).b();
  }
  
  public boolean q()
  {
    Object localObject = a();
    localObject = ((FriendsManager)getManager(43)).a((String)localObject);
    if (localObject == null) {
      return false;
    }
    if (((Card)localObject).isShowZan()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void r()
  {
    ((CardHandler)a(2)).a();
  }
  
  public boolean r()
  {
    return a().getBoolean(a().getString(2131363058) + a(), false);
  }
  
  public void s()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.Y, 0);
      a().a().f();
      return;
    }
  }
  
  public boolean s()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "CNR setAutoLogin autoLogin = " + paramBoolean);
    }
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null)) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), new cvj(this, null));
    super.start(paramBoolean);
  }
  
  public void t()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.Y, 0);
      return;
    }
  }
  
  public boolean t()
  {
    String str1 = a();
    String str2 = ContactUtils.g(this, str1);
    Object localObject;
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      localObject = (FriendManager)getManager(8);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (((Friends)localObject).name != null)) {
          break label138;
        }
        localObject = (FriendListHandler)a(1);
        if (localObject == null) {
          break label138;
        }
        ((FriendListHandler)localObject).a(str1);
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((FriendManager)localObject).c(str1);
      break;
    }
  }
  
  public void u()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.ae, 0);
      a().a().f();
      return;
    }
  }
  
  public boolean u()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131363045) + a(), true);
  }
  
  protected void userLogoutReleaseData()
  {
    int i1 = 0;
    TroopFileManager.a();
    UpgradeController.a().a(true);
    SystemMsgController.a().c();
    FriendSystemMsgController.a().c();
    GroupSystemMsgController.a().c();
    MsgAutoMonitorUtil.a().a();
    ChatActivityUtils.b();
    BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 0);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("unreadcount", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    VipPathTracker.a().a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a());
    localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i1 = 4;
    }
    localObject = ((Context)localObject).getSharedPreferences("Last_Login", i1);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putString("exitUin", ((SharedPreferences)localObject).getString("uin", "")).commit();
    }
  }
  
  public void v()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.ae, 0);
      return;
    }
  }
  
  public void w()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsg");
      }
      a().a(AppConstants.ad, 0);
      a().a().d();
      return;
    }
  }
  
  public void x()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsgHistory");
      }
      a().a(AppConstants.ad, 0);
      return;
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener.a();
    }
  }
  
  public void z()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.l))
    {
      l1 = l2;
      if (this.jdField_b_of_type_Long != 0L)
      {
        l1 = bi - (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
        if (l1 >= 0L) {
          break label116;
        }
        l1 = l2;
      }
    }
    label116:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */