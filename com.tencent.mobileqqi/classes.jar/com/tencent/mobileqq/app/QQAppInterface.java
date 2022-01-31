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
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import android.util.Pair;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.tencent.TencentTranslator;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.lbsapi.QLBSNotification;
import com.tencent.lbsapi.QLBSService;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.HelloListActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.voip.VoipSSOHandler;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
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
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.data.TagArrayByType;
import com.tencent.mobileqq.emoticon.EmoticonController;
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
import com.tencent.mobileqq.managers.DiscussionMemberManager;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.maproam.RoamMapController;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountGetMessageControll;
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
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.theme.SkinEngine;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import com.weiyun.sdk.context.SdkContext;
import cooperation.plugin.IPluginManager;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQServiceForQlink;
import cooperation.qlink.QlinkServiceManager;
import fjm;
import fjo;
import fjp;
import fjq;
import fjr;
import fjs;
import fjt;
import fju;
import fjv;
import fjw;
import fjx;
import fjy;
import fjz;
import fkd;
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
import java.util.Date;
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
  implements IHttpCommunicatorFlowCount
{
  public static final int A = 24;
  public static final int B = 25;
  public static final int C = 26;
  public static final int D = 27;
  public static final int E = 28;
  public static final int F = 29;
  public static final int G = 30;
  public static final int H = 31;
  public static final int I = 32;
  public static final int J = 33;
  public static final int K = 34;
  public static final int L = 35;
  public static final int M = 36;
  public static final int N = 37;
  public static final int O = 38;
  public static final int P = 39;
  public static final int Q = 40;
  public static final int R = 41;
  public static final int S = 42;
  public static final int T = 43;
  public static final int U = 44;
  public static final int V = 45;
  public static final int W = 46;
  public static final int X = 47;
  public static final int Y = 48;
  public static final int Z = 49;
  public static final byte a = 1;
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 2000L;
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  public static final String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16, 8, 17, 26, 25, 23, 24, 41, 44 };
  public static final long[] a;
  public static final int aA = 15;
  public static final int aB = 16;
  public static final int aC = 17;
  public static final int aD = 18;
  public static final int aE = 19;
  public static final int aF = 20;
  public static final int aG = 21;
  public static final int aH = 22;
  public static final int aI = 23;
  public static final int aJ = 24;
  public static final int aK = 25;
  public static final int aL = 26;
  public static final int aM = 27;
  public static final int aN = 28;
  public static final int aO = 29;
  public static final int aP = 30;
  public static final int aQ = 31;
  public static final int aR = 32;
  public static final int aS = 33;
  public static final int aT = 34;
  public static final int aU = 35;
  public static final int aV = 36;
  public static final int aW = 37;
  public static final int aX = 38;
  public static final int aY = 39;
  public static final int aZ = 40;
  public static final int aa = 50;
  public static final int ab = 51;
  public static final int ac = 52;
  public static final int ad = 53;
  public static final int af = 0;
  public static final int ag = 1;
  public static final int ai = 1;
  public static final int aj = 2;
  public static final int ak = 3;
  public static final int al = 0;
  public static final int am = 1;
  public static final int an = 2;
  public static final int ao = 3;
  public static final int ap = 4;
  public static final int aq = 5;
  public static final int ar = 6;
  public static final int as = 7;
  public static final int at = 8;
  public static final int au = 9;
  public static final int av = 10;
  public static final int aw = 11;
  public static final int ax = 12;
  public static final int ay = 13;
  public static final int az = 14;
  public static final byte b = 2;
  public static final int b = 2;
  public static final String b = "com.tencent.mobileqq.intent.logout";
  private static final long[] jdField_b_of_type_ArrayOfLong;
  public static final int ba = 41;
  public static final int bb = 42;
  public static final int bc = 3000;
  public static final int bd = 3;
  public static int bg = 300000;
  public static int bh = 30000;
  public static final int bi = 3;
  public static final int bj = 2;
  public static final int bk = 1;
  private static final int bl = -56;
  private static final int bm = -55;
  private static final int bn = 54;
  private static final int bo = 1;
  private static final int bq = 43;
  private static final int br = 0;
  private static final int bs = 202020;
  public static final byte c = 3;
  public static final int c = 3;
  private static final long jdField_c_of_type_Long = 86400000L;
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
  public static final String g = "clean_unread_sharealbum_type";
  public static final int h = 100;
  private static final long h = 7200000L;
  public static final String h = "com.tencent.msg.newmessage";
  public static final int i = 101;
  public static final String i = "round";
  public static final int j = 102;
  public static final String j = "B1_QQ_Neighbor_android";
  public static final int k = 8;
  public static final String k = "NzVK_qGE";
  public static final int l = 9;
  static final String jdField_l_of_type_JavaLangString = "security_scan";
  public static final int m = 10;
  public static final String m = "notification_cancelled";
  public static final int n = 11;
  private static final String n = "Q.qqhead.broadcast";
  public static final int o = 12;
  private static final String o = "com.tencent.qzone.cleanunreadcount";
  public static final int p = 13;
  private static final String p = "com.tencent.qzone.clean_sharealbum";
  public static final int q = 14;
  private static final String q = "com.tencent.qqhead.getheadreq";
  public static final int r = 15;
  private static final String r = "com.tencent.qqhead.getheadresp";
  public static final int s = 16;
  private static final String s = "tencent.av.v2q.StartVideoChat";
  public static final int t = 17;
  private static final String t = "tencent.av.v2q.StopVideoChat";
  public static final int u = 18;
  private static final String u = "tencent.av.v2q.AvSwitch";
  public static final int v = 19;
  private static final String v = "com.tencent.mobileqqi:video";
  public static final int w = 20;
  private static final String w = "notification";
  public static final int x = 21;
  public static final int y = 22;
  public static final int z = 23;
  private LBSInfo jdField_a_of_type_NearbyGroupLBSInfo;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new fjw(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private GAudioNotifyCenter jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter;
  QLBSNotification jdField_a_of_type_ComTencentLbsapiQLBSNotification;
  public QLBSService a;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = null;
  private CheckPttListener jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fjy(this);
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = null;
  private QQGAudioMsgHandler jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  public Automator a;
  volatile ConversationFacade jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  public volatile QQMessageFacade a;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private SosoInterface jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface;
  public AboutConfig a;
  private Config jdField_a_of_type_ComTencentMobileqqConfigConfig;
  public LebaConfig a;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private FileManagerEngine jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  private FileTransferHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  private FileManagerDataCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  private FileManagerNotifyCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  private FileManagerRSCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  private OnlineFileSessionCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  private PrivacyInfoUtil jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  private HwEngine jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new fjm(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  public MobileQQService a;
  private MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private ProtoReqManager jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private CloudScanListener jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener;
  private ISecureModuleService jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  private QQProxyForQlink jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  private QQServiceForQlink jdField_a_of_type_CooperationQlinkQQServiceForQlink;
  private QlinkServiceManager jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_a_of_type_JavaUtilList = new Vector();
  public Set a;
  public boolean a;
  public byte[] a;
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[43];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager[54];
  public int ae;
  public int ah = 0;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new fjz(this);
  private Intent jdField_b_of_type_AndroidContentIntent = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new fjx(this, Looper.getMainLooper());
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_b_of_type_JavaUtilList = new Vector();
  boolean jdField_b_of_type_Boolean = false;
  private volatile byte[] jdField_b_of_type_ArrayOfByte = new byte[2];
  public int be;
  public int bf;
  private final int bp = 990;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new fjr(this);
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  List jdField_c_of_type_JavaUtilList = new Vector();
  private byte[] jdField_c_of_type_ArrayOfByte;
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  private long jdField_d_of_type_Long = 31L;
  private BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new fjs(this);
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  public boolean d;
  private long jdField_e_of_type_Long = -1L;
  private BroadcastReceiver jdField_e_of_type_AndroidContentBroadcastReceiver = new fju(this);
  public boolean e;
  private long jdField_f_of_type_Long = 0L;
  boolean jdField_f_of_type_Boolean;
  private long g;
  public boolean g;
  public volatile boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  private boolean jdField_l_of_type_Boolean;
  private volatile boolean m = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQAppInterface.class.getSimpleName();
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
    jdField_a_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
    jdField_c_of_type_Boolean = false;
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.l = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new fjq(this, Looper.getMainLooper());
    this.jdField_g_of_type_Long = 60000L;
  }
  
  private boolean A()
  {
    return e() != 0;
  }
  
  private boolean B()
  {
    return d() != 0;
  }
  
  private void K()
  {
    SosoSrvAddrProvider.a().b();
  }
  
  private void L()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      int i1 = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size() * 3 / 4;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.trimToSize(i1);
    }
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = new HttpCommunicator(this, 128);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a();
  }
  
  private void N()
  {
    int i2 = 0;
    if (this.h) {
      return;
    }
    this.h = true;
    if (GuardManager.a != null) {
      GuardManager.a.a(false);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.b();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
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
            break label267;
          }
          localObject5.onDestroy();
          break label267;
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
            localObject5.c();
          }
          i1 += 1;
          continue;
          localObject3 = finally;
          throw localObject3;
        }
        if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener != null) {
          a().unregisterCloudScanListener(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getBaseContext(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
        }
        Q();
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
      label267:
      i1 += 1;
    }
  }
  
  private void O()
  {
    try
    {
      if (SubAccountAssistantImpl.a().a(this))
      {
        Object localObject = SubAccountAssistantImpl.a().a(this);
        String str = SubAccountAssistantImpl.a().a();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy subAccount = " + (String)localObject + ";subAccountA2 is null =" + TextUtils.isEmpty(str));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          SubAccountAssistantImpl localSubAccountAssistantImpl = SubAccountAssistantImpl.a();
          long l1 = Long.parseLong((String)localObject);
          if (str == null) {}
          for (localObject = null;; localObject = HexUtil.a(str))
          {
            localSubAccountAssistantImpl.a(this, (byte)0, l1, (byte[])localObject, 21);
            return;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void P()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.v2q.AddMsgSig");
    localIntentFilter.addAction("tencent.video.v2q.AddContactsToDiscuss");
    localIntentFilter.addAction("tencent.video.v2q.AddContactsFromC2C");
    localIntentFilter.addAction("tencent.video.v2q.AddVideoMsg");
    localIntentFilter.addAction("tencent.video.v2q.VideoFlowSize");
    localIntentFilter.addAction("tencent.av.v2q.MultiVideo");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.AvSwitch");
    synchronized (this.jdField_b_of_type_AndroidContentBroadcastReceiver)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_b_of_type_Boolean = true;
      G();
      return;
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {}
    synchronized (this.jdField_b_of_type_AndroidContentBroadcastReceiver)
    {
      if ((this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_Boolean = false;
      }
      H();
      return;
    }
  }
  
  private void R()
  {
    I18nPublicAccountsManagerImp localI18nPublicAccountsManagerImp = (I18nPublicAccountsManagerImp)getManager(53);
    if (localI18nPublicAccountsManagerImp != null) {
      localI18nPublicAccountsManagerImp.a();
    }
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig = new AboutConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a();
    }
  }
  
  private void T()
  {
    ReportController.a(this, false);
    a(new fjt(this));
    Object localObject = (GameCenterManagerImp)getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).c();
    }
    localObject = (QZoneManager)getManager(9);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onstart.test if get qzone unread.");
      }
      ((QZoneManager)localObject).a(1);
    }
    e(false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "zsw subaccount onStart start get sub msg");
    }
  }
  
  private void U()
  {
    ReportController.a(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "zsw subaccount onStop stop get sub msg ");
    }
    u();
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt)
  {
    if (AppConstants.O.equals(paramString))
    {
      paramString = paramContext.getString(2131561706);
      paramContext = new Intent(paramContext, SubAccountMessageActivity.class);
      paramContext.putExtra("subAccountLatestNick", SubAccountDataControll.a().b(this));
    }
    String str;
    for (;;)
    {
      paramContext.putExtra("uinname", paramString);
      return paramContext;
      if (String.valueOf(AppConstants.V).equals(paramString))
      {
        paramString = paramContext.getString(2131562371);
        paramContext = new Intent(paramContext, HelloListActivity.class).putExtra(HelloListActivity.jdField_a_of_type_JavaLangString, HelloListActivity.c);
      }
      else if (String.valueOf(AppConstants.Z).equals(paramString))
      {
        paramString = paramContext.getString(2131562249);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("_key_mode", 3);
      }
      else if (String.valueOf(AppConstants.aa).equals(paramString))
      {
        paramString = paramContext.getString(2131562249);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.W).equals(paramString))
      {
        paramString = new Intent(paramContext, QQBroadcastActivity.class);
        str = paramContext.getString(2131562677);
        paramContext = paramString;
        paramString = str;
      }
      else if (String.valueOf(AppConstants.S).equals(paramString))
      {
        paramString = paramContext.getString(2131562249);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(a()));
      }
      else
      {
        if (!String.valueOf(AppConstants.P).equals(paramString)) {
          break;
        }
        paramString = new Intent(paramContext, LiteActivity.class);
        str = paramContext.getString(2131558496);
        paramContext = paramString;
        paramString = str;
      }
    }
    if (paramInt == 1009) {
      str = paramContext.getString(2131562365);
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      if ((paramInt == 1024) || (CrmUtils.b(this, paramString))) {
        localIntent.setClass(paramContext, ChatForEnterpriseActivity.class);
      }
      localIntent.addFlags(335544320);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", paramInt);
      paramString = str;
      paramContext = localIntent;
      break;
      if (String.valueOf(1787740092L).equals(paramString)) {
        str = paramContext.getString(2131561661);
      } else {
        str = ContactUtils.b(this, paramString, paramInt);
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
    Object localObject = a(1, paramString, paramByte, true);
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
        localObject = ImageUtil.a();
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
      return a().getString(2131561541);
    case 4: 
      return a().getString(2131560610);
    }
    return a().getString(2131560611);
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
              QLog.d(jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
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
      localStringBuilder.append(AppConstants.ay);
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
    label149:
    label185:
    label191:
    do
    {
      return;
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
            Object localObject3 = new File(b(1, str));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label185;
            }
            i2 = 1;
            if (i2 == 0) {
              break label191;
            }
            localObject3 = b(1, str);
            paramContext.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label149;
            paramIntent.add(str);
          }
        }
      }
      if (paramContext.size() > 0)
      {
        localObject2 = new Intent("com.tencent.qqhead.getheadresp");
        ((Intent)localObject2).putStringArrayListExtra("uinList", paramContext);
        ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
        a().sendBroadcast((Intent)localObject2);
      }
      if (paramIntent.size() > 0)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = (FriendListHandler)a(1);
        i1 = 0;
        while (i1 < paramIntent.size())
        {
          str = (String)paramIntent.get(i1);
          ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
            i1 += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramContext);
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", paramIntent);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showNotification. cmd=" + paramString4 + ", ticker=" + Utils.a(paramString1) + ",msgShow:" + Utils.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {}
    try
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130838016);
      if (localBitmap != null)
      {
        paramBitmap = new ToServiceMsg("mobileqq.service", a(), paramString4);
        paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
        paramBitmap.extraData.putParcelable("intent", paramIntent);
        paramBitmap.extraData.putParcelable("bitmap", localBitmap);
        paramBitmap.extraData.putInt("msgCount", paramInt);
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
    if (e()) {
      a(paramMessage, true);
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.ah == 0)
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
      i1 = i2;
      if (paramMessage.istroop == 1008)
      {
        i1 = i2;
        if (paramMessage.extStr != null)
        {
          i1 = i2;
          if (paramMessage.extStr.contains("lockDisplay"))
          {
            i1 = i2;
            if (paramBoolean1) {
              i1 = 1;
            }
          }
        }
      }
      i2 = i1;
      if (paramMessage.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.L.equals(paramMessage.senderuin)) {
          i2 = 1;
        }
      }
      if (i2 != 0) {
        b(paramMessage, paramBoolean2);
      }
      return;
      g(true);
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
          this.ae = Integer.parseInt((String)paramInputStream.get(0));
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
  
  private Object[] a(int paramInt, String paramString)
  {
    int i1 = paramInt;
    String str = paramString;
    if (paramInt != 101)
    {
      i1 = paramInt;
      str = paramString;
      if (paramString != null)
      {
        Setting localSetting = (Setting)a(paramInt, paramString).second;
        i1 = paramInt;
        str = paramString;
        if (localSetting != null)
        {
          i1 = paramInt;
          str = paramString;
          if (localSetting.bHeadType == 0)
          {
            str = String.valueOf(localSetting.systemHeadID);
            if (paramInt != 4) {
              break label92;
            }
          }
        }
      }
    }
    label92:
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
    return new LBSInfo((GPS)localObject1, (ArrayList)localObject2, localArrayList, new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c));
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.addFlags(335544320);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    return paramContext;
  }
  
  private BusinessHandler b(int paramInt)
  {
    switch (paramInt)
    {
    case 33: 
    case 35: 
    case 37: 
    case 39: 
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
      return new QvipSpecialCareHandler(this);
    case 15: 
      return new ClubContentUpdateHandler(this);
    case 10: 
      return new PublicAccountHandler(this);
    case 16: 
      return new SubAccountBindHandler(this);
    case 17: 
      return new ShieldListHandler(this);
    case 18: 
      return new SaveTrafficHandler(this);
    case 21: 
      return new BizTroopHandler(this);
    case 19: 
      return new TroopHandler(this);
    case 20: 
      return new EnterpriseQQHandler(this);
    case 22: 
      return new StartAppCheckHandler(this);
    case 23: 
      return new SecSigHandler(this);
    case 30: 
      return new TroopQZoneUploadAlbumHandler(this);
    case 24: 
      return new SafeCenterPushHandler(this);
    case 25: 
      return new PushSecSigHandler(this);
    case 26: 
      return new MQPIntChkHandler(this);
    case 27: 
      return new QPSafeCheckHandler(this);
    case 28: 
      return new StrangerHandler(this);
    case 29: 
      return new VipInfoHandler(this);
    case 31: 
      return new NearHornHandler(this);
    case 32: 
      return new CardPayHandler(this);
    case 34: 
      return new RedTouchHandler(this);
    case 40: 
      return new NearFieldDiscussHandler(this);
    case 36: 
      return new I18nTranslatorHandler(this);
    case 41: 
      return new AntiFraudGetConfigHandler(this);
    case 38: 
      return new I18nPublicAccountHandler(this);
    }
    return new VoipSSOHandler(this);
  }
  
  private void b(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject1;
    label124:
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if (QLog.isColorLevel())
    {
      localObject1 = null;
      if (paramMessage != null)
      {
        if (paramMessage.msgtype == -2020) {
          localObject1 = paramMessage.getBaseInfoString();
        }
      }
      else {
        QLog.d("notification", 2, "message is:" + (String)localObject1 + ",isOnline is:" + paramBoolean);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "previous vibrate time is:" + this.jdField_e_of_type_Long + ",curr time is:" + System.currentTimeMillis());
      }
      if (this.jdField_e_of_type_Long != -1L) {
        break label391;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      bool1 = g();
      bool4 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool4);
      }
      if ((paramMessage == null) || (paramMessage.istroop != 1008) || (!AppConstants.L.equals(paramMessage.senderuin))) {
        break label515;
      }
      bool2 = false;
      bool3 = false;
      paramMessage = RingtoneManager.getActualDefaultRingtoneUri(a(), 2);
      localObject1 = (Vibrator)a().getSystemService("vibrator");
      if ((!j()) || (!bool4)) {
        break label439;
      }
      paramBoolean = true;
      bool1 = bool2;
      label269:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool1 + " uri: " + paramMessage);
      }
      if ((paramBoolean) && (localObject1 != null)) {
        ((Vibrator)localObject1).vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((bool1) && (paramMessage != null)) {
        ((BaseApplicationImpl)a()).a(paramMessage, false);
      }
    }
    label391:
    label439:
    SharedPreferences localSharedPreferences;
    label515:
    Object localObject4;
    boolean bool5;
    Object localObject3;
    label680:
    label695:
    int i3;
    int i2;
    label892:
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = "not shake msg,uinSeq is:" + paramMessage.uniseq;
          break;
          if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) > 2000L) {
            break label124;
          }
        } while ((paramMessage == null) || (paramMessage.msgtype != -2020) || (!paramBoolean));
        if (a() == 11L) {
          break label124;
        }
        return;
        if ((h()) && (i()) && (bool4))
        {
          bool1 = true;
          paramBoolean = true;
          break label269;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (!h()) {
          break label269;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (i()) {
          break label269;
        }
        paramBoolean = bool3;
        bool1 = bool2;
        if (!bool4) {
          break label269;
        }
        bool1 = true;
        paramBoolean = bool3;
        break label269;
      } while ((bool1) || (!bool4));
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
      localObject4 = (Vibrator)a().getSystemService("vibrator");
      bool5 = c();
      localObject3 = "";
      localObject1 = "";
      if (paramMessage != null)
      {
        if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1004))
        {
          localObject1 = paramMessage.frienduin;
          localObject3 = "special_sound_type" + a() + (String)localObject1;
        }
      }
      else
      {
        bool4 = B();
        bool3 = A();
        bool1 = bool3;
        bool2 = bool4;
        if (paramMessage != null)
        {
          bool1 = bool3;
          bool2 = bool4;
          if (paramMessage.istroop == 1)
          {
            if ((!bool4) || (!z())) {
              break label892;
            }
            bool2 = true;
            if ((!bool3) || (!y())) {
              break label898;
            }
            bool1 = true;
          }
        }
        bool3 = l();
        bool4 = x();
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "canVibrator is:" + bool1 + ",isVideoing is:" + bool5 + ",isCallIdle is:" + bool3 + ",notRecordingPtt is:" + bool4);
        }
        if ((!bool1) || (!bool3) || (bool5) || (!bool4)) {
          continue;
        }
        if ((paramMessage == null) || (!paramBoolean) || (paramMessage.msgtype != -2020) || (a() != 11L)) {
          break label904;
        }
        ((Vibrator)localObject4).vibrate(jdField_a_of_type_ArrayOfLong, -1);
        i1 = 2;
      }
      for (;;)
      {
        i3 = this.jdField_d_of_type_JavaUtilList.size();
        i2 = 0;
        while (i2 < i3)
        {
          ((VibrateListener)this.jdField_d_of_type_JavaUtilList.get(i2)).h(i1);
          i2 += 1;
        }
        localObject1 = paramMessage.senderuin;
        break;
        bool2 = false;
        break label680;
        bool1 = false;
        break label695;
        if (localSharedPreferences.contains((String)localObject3))
        {
          ((Vibrator)localObject4).vibrate(1000L);
          i1 = 3;
        }
        else
        {
          ((Vibrator)localObject4).vibrate(jdField_b_of_type_ArrayOfLong, -1);
          i1 = 1;
        }
      }
    } while ((!bool2) || (bool5) || (j()) || (k()) || (!bool3) || (!bool4));
    label898:
    label904:
    int i1 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", 2131165184);
    if (QLog.isColorLevel())
    {
      localObject4 = (AudioManager)a().getSystemService("audio");
      StringBuilder localStringBuilder = new StringBuilder().append("StreamVolume=");
      if (localObject4 == null)
      {
        i2 = 0;
        QLog.d("notification", 2, i2 + ",SoundRid=" + i1);
      }
    }
    else
    {
      if (!localSharedPreferences.contains((String)localObject3)) {
        break label1471;
      }
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "SpecialSound");
      }
      localObject4 = (FriendsManagerImp)getManager(8);
      if ((localObject4 == null) || (!((FriendsManagerImp)localObject4).b((String)localObject1))) {
        break label1471;
      }
      i3 = localSharedPreferences.getInt((String)localObject3, i1);
      if (i3 != 1) {
        break label1276;
      }
      i2 = 2131165214;
      try
      {
        ((BaseApplicationImpl)a()).a(2131165214, false);
        return;
      }
      catch (Exception localException)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("notification", 2, localException.getMessage());
          i1 = i2;
        }
      }
    }
    label1471:
    for (;;)
    {
      i2 = i1;
      if (i1 == SoundAndVibrateActivity.b)
      {
        Object localObject2 = ThemeUtil.getThemeVoiceRootPath();
        if (localObject2 != null)
        {
          localObject2 = new File((String)localObject2 + File.separatorChar + "message.mp3");
          if (((File)localObject2).exists())
          {
            ((BaseApplicationImpl)a()).a(Uri.fromFile((File)localObject2), false);
            return;
            i2 = ((AudioManager)localObject4).getStreamVolume(2);
            break;
            label1276:
            i2 = i1;
            localObject2 = localSharedPreferences.getString("special_sound_url" + i3, "");
            i2 = i1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              i2 = i1;
              localObject3 = new File(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), (String)localObject2);
              i2 = i1;
              if (((File)localObject3).exists())
              {
                i2 = i1;
                ((BaseApplicationImpl)a()).a(((File)localObject3).getAbsolutePath(), false);
                return;
              }
              i2 = i1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager == null)
              {
                i2 = i1;
                this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
              }
              i2 = i1;
              a(new fjo(this, (String)localObject2, (File)localObject3));
            }
            continue;
          }
        }
        i2 = 2131165197;
      }
      if (paramMessage != null) {
        if (c(paramMessage.frienduin)) {
          i2 = 2131165215;
        }
      }
      for (;;)
      {
        ((BaseApplicationImpl)a()).a(i2, false);
        return;
      }
    }
  }
  
  private boolean b(QQMessageFacade.Message paramMessage)
  {
    return (String.valueOf(AppConstants.U).equals(paramMessage.frienduin)) || (String.valueOf(AppConstants.W).equals(paramMessage.frienduin)) || (String.valueOf(AppConstants.V).equals(paramMessage.frienduin));
  }
  
  private boolean c(String paramString)
  {
    return (String.valueOf(AppConstants.U).equals(paramString)) || (String.valueOf(AppConstants.W).equals(paramString)) || (String.valueOf(AppConstants.V).equals(paramString));
  }
  
  private void g(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_Boolean) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Intent localIntent;
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.e() != 1) {
        break;
      }
      localIntent = a(a(), (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      localIntent.putExtra("entrance", 6);
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(a().getString(2131563271));
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      ((StringBuffer)localObject).append(a().getString(2131561563));
      label129:
      if (!paramBoolean) {
        break label237;
      }
    }
    label237:
    for (Object localObject = ((StringBuffer)localObject).toString();; localObject = null)
    {
      a(localIntent, (String)localObject, a().getResources().getString(2131562387), a().getResources().getString(2131559798), i1, null, "CMD_SHOW_NOTIFIYCATION");
      return;
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", 0);
      break;
      ((StringBuffer)localObject).append(i1).append(a().getString(2131561409));
      break label129;
    }
  }
  
  private String h()
  {
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    return str;
  }
  
  /* Error */
  private String i()
  {
    // Byte code:
    //   0: ldc_w 1764
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 584	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 1768	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 584	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 1771	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 1777	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
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
    //   46: getfield 1782	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 1782	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 1784
    //   78: invokevirtual 1788	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   101: new 647	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 648	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 1790
    //   116: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
  
  private boolean w()
  {
    return SettingCloneUtil.readValue(a(), null, a().getString(2131563427), "qqsetting_notify_icon_key", false);
  }
  
  private boolean x()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  private boolean y()
  {
    return c() != 0;
  }
  
  private boolean z()
  {
    return b() != 0;
  }
  
  public void A()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsgHistory");
      }
      a().a(AppConstants.Z, 0);
      return;
    }
  }
  
  public void B()
  {
    ISecureModuleService localISecureModuleService = a();
    if (localISecureModuleService.register(new ProductInfo(6, i(), Integer.parseInt("6600"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener == null) {
        this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener = new fjp(this);
      }
      localISecureModuleService.registerCloudScanListener(a(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener.a();
    }
  }
  
  public void D()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.k))
    {
      l1 = l2;
      if (this.jdField_b_of_type_Long != 0L)
      {
        l1 = bg - (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.n();
    }
    SubAccountDataControll.a().a();
  }
  
  public void F()
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
  
  public void G()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("notification_cancelled");
    synchronized (this.jdField_e_of_type_AndroidContentBroadcastReceiver)
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_e_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
  }
  
  public void H()
  {
    if (this.jdField_e_of_type_AndroidContentBroadcastReceiver != null) {
      synchronized (this.jdField_e_of_type_AndroidContentBroadcastReceiver)
      {
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_e_of_type_AndroidContentBroadcastReceiver);
        return;
      }
    }
  }
  
  public void I()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      bool = a().a();
      localObject2 = BaseActivity.a;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      }
      if (bool)
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        ((Context)localObject1).startActivity((Intent)localObject2);
      }
    }
    while (!QLog.isColorLevel())
    {
      boolean bool;
      Object localObject2;
      Object localObject1;
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onX2Wifi app = null,maybe not QQ process");
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
  
  public Bitmap a(int paramInt, String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(paramInt, paramString, paramByte, paramBoolean, (byte)1);
  }
  
  public Bitmap a(int paramInt, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2)
  {
    if ((paramInt == 1) && (paramString != null) && ((paramString.equals(AppConstants.W)) || (paramString.equals(AppConstants.V)) || (paramString.equals(AppConstants.S)) || (paramString.equals(AppConstants.U)))) {
      return ImageUtil.e();
    }
    if ((paramInt == 11) && (!StringUtil.e(paramString))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramInt == 101) {
      paramByte1 = 1;
    }
    String str1 = a(paramInt, paramString, paramByte1);
    Object localObject1 = a(str1);
    boolean bool;
    String str2;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
    int i1;
    label321:
    Object localObject2;
    if (localObject1 == null) {
      if (paramBoolean)
      {
        localObject1 = a(paramInt, paramString);
        if (localObject1 != null)
        {
          bool = ((Boolean)((Pair)localObject1).first).booleanValue();
          str2 = b(paramInt, paramString);
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
          localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
          i1 = 0;
          do
          {
            BitmapManager.a(str2, (BitmapFactory.Options)localObject1, localBitmapDecodeResult);
            if (localBitmapDecodeResult.e == 1) {
              L();
            }
            i1 += 1;
          } while ((i1 < 2) && (localBitmapDecodeResult.e == 1));
          if ((QLog.isColorLevel()) && (localBitmapDecodeResult.e != 0)) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.e + ", facePath=" + str2);
          }
          if ((!bool) && (localBitmapDecodeResult.e == 1)) {
            return null;
          }
          if (localBitmapDecodeResult.e != 2)
          {
            i1 = 1;
            localObject1 = localBitmapDecodeResult.a;
            if ((localObject1 == null) && (localBitmapDecodeResult.e != 1) && (i1 != 0))
            {
              if (paramInt != 4) {
                break label845;
              }
              localObject2 = "troop_" + paramString;
              label374:
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
        int i2;
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
            break label842;
          }
        }
        switch (paramByte1)
        {
        case 2: 
        default: 
          localObject1 = a((Bitmap)localObject1);
          if (localObject1 == null) {
            break label743;
          }
          a(str1, (Bitmap)localObject1, paramByte2);
          if (((localObject1 == null) && (paramBoolean) && (i1 == 0)) || (bool))
          {
            if (i1 == 0) {
              break label806;
            }
            paramByte1 = 1;
            localObject2 = (FriendListHandler)a(1);
          }
          switch (paramInt)
          {
          default: 
            return localObject1;
            i1 = 0;
            break label321;
            i2 = localInteger.intValue();
          }
          break;
        }
      }
      continue;
      localObject1 = a((Bitmap)localObject1, 50, 50);
      continue;
      label743:
      if ((QLog.isColorLevel()) && (localBitmapDecodeResult.e == 0)) {
        QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt + ", uin=" + paramString + ", shape=" + paramByte1);
      }
      continue;
      label806:
      paramByte1 = 2;
      continue;
      ((FriendListHandler)localObject2).b(paramString, paramByte1);
      continue;
      ((FriendListHandler)localObject2).a(paramString, paramByte1);
      continue;
      ((FriendListHandler)localObject2).a(paramString, (byte)0, paramByte1);
      continue;
      label842:
      continue;
      label845:
      localObject2 = paramString;
      break label374;
      bool = false;
      break;
      bool = false;
      i1 = 0;
    }
  }
  
  public Bitmap a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, (byte)3, paramBoolean);
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
    return a(1, paramString, paramByte, paramBoolean);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true);
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
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean);
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
    Bitmap localBitmap = a(11, paramString, paramByte, true);
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
      localObject = ImageUtil.b();
    }
    return localObject;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, (byte)3);
  }
  
  public Pair a(int paramInt, String paramString)
  {
    if (paramInt == 4) {}
    Setting localSetting1;
    for (String str = "troop_" + paramString;; str = paramString)
    {
      Setting localSetting2 = (Setting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      localSetting1 = localSetting2;
      if (localSetting2 == null)
      {
        localSetting1 = localSetting2;
        if (!this.l)
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
    }
    boolean bool;
    switch (paramInt)
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
    boolean bool = true;
    Bitmap localBitmap = a(1, paramString, (byte)3, true);
    paramString = localBitmap;
    if (localBitmap == null)
    {
      bool = false;
      paramString = ImageUtil.a();
    }
    return Pair.create(Boolean.valueOf(bool), paramString);
  }
  
  public GAudioNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter = new GAudioNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvGaudioGAudioNotifyCenter;
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
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public QQGAudioMsgHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler = new QQGAudioMsgHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
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
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)getManager(17));
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
    S();
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
  
  public LebaConfig a()
  {
    o();
    return this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig;
  }
  
  /* Error */
  public Setting a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: iload_1
    //   3: iconst_4
    //   4: if_icmpne +24 -> 28
    //   7: new 647	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 648	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 2028
    //   17: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   32: invokevirtual 2209	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   35: astore_2
    //   36: aload_2
    //   37: ldc_w 1296
    //   40: aload_3
    //   41: invokevirtual 2116	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   44: checkcast 1296	com/tencent/mobileqq/data/Setting
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 2210	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   56: aload_3
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +30 -> 92
    //   65: aload_2
    //   66: invokevirtual 2210	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 2210	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   82: aload_3
    //   83: athrow
    //   84: astore_3
    //   85: goto -11 -> 74
    //   88: astore_3
    //   89: goto -28 -> 61
    //   92: aconst_null
    //   93: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	QQAppInterface
    //   0	94	1	paramInt	int
    //   0	94	2	paramString	String
    //   1	56	3	localObject1	Object
    //   71	12	3	localObject2	Object
    //   84	1	3	localObject3	Object
    //   88	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   28	36	58	java/lang/Exception
    //   28	36	71	finally
    //   36	48	84	finally
    //   36	48	88	java/lang/Exception
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
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
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
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
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
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(37));
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
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(18));
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
      M();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public ISecureModuleService a()
  {
    if (this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService == null) {
      this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService = SecureModuleService.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    }
    return this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  }
  
  public QQProxyForQlink a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink == null) {
      this.jdField_a_of_type_CooperationQlinkQQProxyForQlink = new QQProxyForQlink(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  }
  
  public QQServiceForQlink a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQQServiceForQlink == null) {
      this.jdField_a_of_type_CooperationQlinkQQServiceForQlink = new QQServiceForQlink(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQQServiceForQlink;
  }
  
  public QlinkServiceManager a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQlinkServiceManager == null) {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceManager = new QlinkServiceManager(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.az);
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
        ((StringBuilder)localObject).append(AppConstants.ay);
      } else {
        ((StringBuilder)localObject).append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
      }
    }
  }
  
  public String a(int paramInt, String paramString, byte paramByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object[] arrayOfObject = a(paramInt, paramString);
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
      localStringBuilder.append("t_s_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("s_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("d_");
      continue;
      localStringBuilder.append("t_");
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        return (String)paramConfigType.get(paramString);
      }
      localStringBuilder.append("null");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return null;
    }
    try
    {
      localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
      XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
      fkd localfkd = new fkd(this);
      localXMLReader.setContentHandler(localfkd);
      localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
      localObject = localfkd.a();
      this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
      localStringBuilder.append((String)((HashMap)localObject).get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      paramConfigType = (String)((HashMap)localObject).get(paramString);
      return paramConfigType;
    }
    catch (Exception paramConfigType)
    {
      localStringBuilder.append("null. Exception: ");
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString(), paramConfigType);
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return b(4, paramString);
    }
    return b(1, paramString);
  }
  
  /* Error */
  public HashMap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 349	java/util/HashMap
    //   9: dup
    //   10: invokespecial 514	java/util/HashMap:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 584	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 2424	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   22: new 647	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 648	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2426
    //   32: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 854	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   39: invokevirtual 654	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 2429	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: iconst_1
    //   49: anewarray 776	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 2431
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 2437	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +133 -> 203
    //   73: aload 4
    //   75: invokeinterface 2442 1 0
    //   80: ifle +123 -> 203
    //   83: aload 4
    //   85: ldc_w 2431
    //   88: invokeinterface 2445 2 0
    //   93: istore_2
    //   94: new 388	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 389	java/util/ArrayList:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: astore_3
    //   106: aload 4
    //   108: invokeinterface 2448 1 0
    //   113: ifeq +92 -> 205
    //   116: aload 4
    //   118: iload_2
    //   119: invokeinterface 2449 2 0
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull -23 -> 103
    //   129: aload 5
    //   131: aload_3
    //   132: invokevirtual 1081	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   153: invokeinterface 2452 1 0
    //   158: iload_1
    //   159: bipush 254
    //   161: if_icmpne +77 -> 238
    //   164: aload_3
    //   165: ifnull +35 -> 200
    //   168: aload_3
    //   169: invokevirtual 1060	java/util/ArrayList:size	()I
    //   172: ifle +28 -> 200
    //   175: aload 7
    //   177: bipush 254
    //   179: invokestatic 1307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aload_3
    //   183: aload_3
    //   184: invokevirtual 1060	java/util/ArrayList:size	()I
    //   187: anewarray 776	java/lang/String
    //   190: invokevirtual 2456	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   193: checkcast 2458	[Ljava/lang/String;
    //   196: invokevirtual 2035	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   215: invokeinterface 2452 1 0
    //   220: goto -62 -> 158
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 2452 1 0
    //   236: aload_3
    //   237: athrow
    //   238: aload_3
    //   239: ifnull +357 -> 596
    //   242: aload_0
    //   243: aload_3
    //   244: invokevirtual 2461	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   247: astore 8
    //   249: aload 8
    //   251: ifnull +316 -> 567
    //   254: new 388	java/util/ArrayList
    //   257: dup
    //   258: invokespecial 389	java/util/ArrayList:<init>	()V
    //   261: astore 6
    //   263: new 388	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 389	java/util/ArrayList:<init>	()V
    //   270: astore 4
    //   272: new 388	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 389	java/util/ArrayList:<init>	()V
    //   279: astore 5
    //   281: iconst_0
    //   282: istore_2
    //   283: iload_2
    //   284: aload_3
    //   285: invokevirtual 1060	java/util/ArrayList:size	()I
    //   288: if_icmpge +130 -> 418
    //   291: aload_3
    //   292: iload_2
    //   293: invokevirtual 1064	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   296: checkcast 776	java/lang/String
    //   299: astore 9
    //   301: aload 8
    //   303: aload 9
    //   305: invokeinterface 2464 2 0
    //   310: checkcast 1233	java/lang/Integer
    //   313: invokevirtual 2048	java/lang/Integer:intValue	()I
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
    //   369: invokevirtual 1081	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   390: invokevirtual 1081	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   411: invokevirtual 1081	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   414: pop
    //   415: goto -67 -> 348
    //   418: aload 6
    //   420: astore_3
    //   421: aload_3
    //   422: ifnull +44 -> 466
    //   425: aload_3
    //   426: invokevirtual 1060	java/util/ArrayList:size	()I
    //   429: ifle +37 -> 466
    //   432: iload_1
    //   433: iconst_m1
    //   434: if_icmpeq +8 -> 442
    //   437: iload_1
    //   438: iconst_1
    //   439: if_icmpne +27 -> 466
    //   442: aload 7
    //   444: iconst_1
    //   445: invokestatic 1307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aload_3
    //   449: aload_3
    //   450: invokevirtual 1060	java/util/ArrayList:size	()I
    //   453: anewarray 776	java/lang/String
    //   456: invokevirtual 2456	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   459: checkcast 2458	[Ljava/lang/String;
    //   462: invokevirtual 2035	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload 4
    //   468: ifnull +47 -> 515
    //   471: aload 4
    //   473: invokevirtual 1060	java/util/ArrayList:size	()I
    //   476: ifle +39 -> 515
    //   479: iload_1
    //   480: iconst_m1
    //   481: if_icmpeq +8 -> 489
    //   484: iload_1
    //   485: iconst_2
    //   486: if_icmpne +29 -> 515
    //   489: aload 7
    //   491: iconst_2
    //   492: invokestatic 1307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aload 4
    //   497: aload 4
    //   499: invokevirtual 1060	java/util/ArrayList:size	()I
    //   502: anewarray 776	java/lang/String
    //   505: invokevirtual 2456	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   508: checkcast 2458	[Ljava/lang/String;
    //   511: invokevirtual 2035	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 5
    //   517: ifnull +47 -> 564
    //   520: aload 5
    //   522: invokevirtual 1060	java/util/ArrayList:size	()I
    //   525: ifle +39 -> 564
    //   528: iload_1
    //   529: iconst_m1
    //   530: if_icmpeq +8 -> 538
    //   533: iload_1
    //   534: iconst_4
    //   535: if_icmpne +29 -> 564
    //   538: aload 7
    //   540: iconst_4
    //   541: invokestatic 1307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aload 5
    //   546: aload 5
    //   548: invokevirtual 1060	java/util/ArrayList:size	()I
    //   551: anewarray 776	java/lang/String
    //   554: invokevirtual 2456	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   557: checkcast 2458	[Ljava/lang/String;
    //   560: invokevirtual 2035	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    if (this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.a();
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
    this.l = true;
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.qqhead.getheadreq");
    a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
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
  
  public void a(int paramInt, String paramString)
  {
    int i1 = 0;
    paramString = a(paramInt, paramString, (byte)0);
    paramInt = i1;
    while (paramInt <= 3)
    {
      String str = paramString + "_" + paramInt;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    Object localObject1;
    Object localObject2;
    label228:
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localQQMessageFacade = a();
                    } while (localQQMessageFacade == null);
                    localObject1 = localQQMessageFacade.a();
                  } while (localObject1 == null);
                  localObject2 = (I18nPublicAccountsManagerImp)getManager(53);
                } while ((localObject2 != null) && (((QQMessageFacade.Message)localObject1).istroop == 1008) && (!((I18nPublicAccountsManagerImp)localObject2).a(((QQMessageFacade.Message)localObject1).senderuin)) && (!((QQMessageFacade.Message)localObject1).senderuin.equals(a())));
                if ((1000 != ((QQMessageFacade.Message)localObject1).istroop) && (1020 != ((QQMessageFacade.Message)localObject1).istroop)) {
                  break;
                }
                if ((((QQMessageFacade.Message)localObject1).frienduin == null) || (!((QQMessageFacade.Message)localObject1).frienduin.equalsIgnoreCase(a()))) {
                  break label228;
                }
              } while (!QLog.isColorLevel());
              QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
              return;
              if ((((QQMessageFacade.Message)localObject1).senderuin == null) || (!((QQMessageFacade.Message)localObject1).senderuin.equalsIgnoreCase(a()))) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("notification", 2, "receivedMsgNotification ,self message");
            return;
            if ((!a((QQMessageFacade.Message)localObject1)) || (((QQMessageFacade.Message)localObject1).needNotification())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification , isTroopMark");
          return;
        } while (((1008 == ((QQMessageFacade.Message)localObject1).istroop) || (1024 == ((QQMessageFacade.Message)localObject1).istroop)) && ((PubAccountAssistantManager.a().a(this, ((QQMessageFacade.Message)localObject1).senderuin)) || ((((QQMessageFacade.Message)localObject1).istroop == 1008) && ((((QQMessageFacade.Message)localObject1).extStr == null) || (!((QQMessageFacade.Message)localObject1).extStr.contains("lockDisplay"))))));
        if (!UserguideActivity.a(a(), a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "receivedMsgNotification , isRunBackground :" + this.isBackground_Pause + ",userActiveStatus:" + this.ah + ",needSoundVibrationsTip:" + paramBoolean1 + ",baseInfo:" + ((QQMessageFacade.Message)localObject1).getBaseInfoString());
      }
      if (GuardManager.a != null) {
        GuardManager.a.b(0, null);
      }
      boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (((this.isBackground_Pause) || (bool)) && ((((QQMessageFacade.Message)localObject1).istroop == 6000) || (this.ah == 0) || ((((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001)) || (((QQMessageFacade.Message)localObject1).istroop == 1008)))
      {
        ((QQMessageFacade.Message)localObject1).counter += paramInt;
        localQQMessageFacade.c((QQMessageFacade.Message)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "receivedMsgNotification , frienduin " + ((QQMessageFacade.Message)localObject1).frienduin + ",type " + ((QQMessageFacade.Message)localObject1).istroop + ",counter:" + ((QQMessageFacade.Message)localObject1).counter);
        }
        a((QQMessageFacade.Message)localObject1, paramBoolean1, paramBoolean2);
        localObject1 = (NewFriendManager)getManager(32);
        paramInt = i1;
        if (localObject1 != null) {
          paramInt = ((NewFriendManager)localObject1).a(1);
        }
        i1 = localQQMessageFacade.f();
        BadgeUtils.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i1 + paramInt);
        return;
      }
    } while (((QQMessageFacade.Message)localObject1).msgtype == -1013);
    if ((((QQMessageFacade.Message)localObject1).istroop == 1008) && (AppConstants.L.equals(((QQMessageFacade.Message)localObject1).senderuin)))
    {
      b((QQMessageFacade.Message)localObject1, paramBoolean2);
      return;
    }
    if ((paramBoolean1) && ((((QQMessageFacade.Message)localObject1).istroop == 6000) || (this.ah == 0) || ((((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001)) || (((QQMessageFacade.Message)localObject1).istroop == 1008)))
    {
      if (this.m) {
        break label864;
      }
      b((QQMessageFacade.Message)localObject1, paramBoolean2);
    }
    for (;;)
    {
      label780:
      if ((paramBoolean1) && ((((QQMessageFacade.Message)localObject1).istroop == 6000) || (this.ah == 0) || ((((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001))) && (((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001))
      {
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), ((QQMessageFacade.Message)localObject1).action);
        break;
        label864:
        if ((this.jdField_c_of_type_ArrayOfLong[0] == ((QQMessageFacade.Message)localObject1).uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L))
        {
          b((QQMessageFacade.Message)localObject1, paramBoolean2);
        }
        else
        {
          this.jdField_b_of_type_ArrayOfByte[0] = 1;
          localObject2 = this.jdField_b_of_type_ArrayOfByte;
          if (!paramBoolean2) {
            break label928;
          }
        }
      }
    }
    label928:
    for (paramInt = 1;; paramInt = 0)
    {
      localObject2[1] = ((byte)paramInt);
      break label780;
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
    if (d())
    {
      a().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getProfileStatusNew", paramLong).commit();
      this.jdField_d_of_type_Long = paramLong;
      if (paramBoolean) {
        m();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void a(Context paramContext, Class paramClass)
  {
    if (!w()) {
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
      if (!d()) {
        break;
      }
      String str = a();
      localObject = null;
      Friends localFriends = ((FriendManager)getManager(8)).c(str);
      paramClass = str;
      if (localFriends != null)
      {
        Bitmap localBitmap = SkinUtils.a(a(localFriends.uin, false, (byte)1));
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
      a(paramContext, "", paramClass, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131562683), 1, (Bitmap)localObject, "CMD_IDLE_NOTIFIYCATION");
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
      QLog.d("notification", 2, "showReadedMsgNotification msgFacade.getMessages().size()" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() + ",msgFacade.getCounter():" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c());
    }
    if ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c() == 0))
    {
      j();
      return;
    }
    if (e())
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
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.jdField_f_of_type_Boolean + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.jdField_f_of_type_Boolean) || (!bool)) {
      return;
    }
    Object localObject2 = "";
    Object localObject1;
    if (ActionMsgUtil.d(paramMessage.msgtype))
    {
      localObject1 = a().getString(2131561548);
      label119:
      if ((!((String)localObject1).equals("你的QQ暂不支持查看视频短片，请期待后续版本")) && (!((String)localObject1).equals("[视频]你的QQ暂不支持查看视频短片，请升级到最新版本后查看。"))) {
        break label2384;
      }
    }
    label285:
    label312:
    label2375:
    label2384:
    for (Object localObject5 = "[视频] 您的QQ版本暂不支持查看视频短片。";; localObject5 = localObject1)
    {
      Object localObject7 = a(a(), paramMessage, true);
      ((Intent)localObject7).putExtra("entrance", 6);
      Object localObject6 = ((Intent)localObject7).getStringExtra("uinname");
      if ((localObject6 == null) || ("".equals(localObject6))) {
        localObject6 = ((Intent)localObject7).getStringExtra("uin");
      }
      for (;;)
      {
        Object localObject3;
        switch (paramMessage.istroop)
        {
        default: 
          if (AppConstants.Z.equals(paramMessage.frienduin))
          {
            localObject1 = a(paramMessage.senderuin, (byte)1, true);
            localObject2 = (String)localObject6 + ": ";
            localObject3 = localObject5;
          }
          break;
        }
        for (;;)
        {
          Object localObject8;
          int i2;
          for (;;)
          {
            if (!ActionMsgUtil.a(paramMessage.msgtype)) {
              break label2357;
            }
            if ((paramMessage.actMsgContentValue == null) || ("".endsWith(paramMessage.actMsgContentValue))) {
              break label1674;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
            }
            localObject3 = paramMessage.actMsgContentValue;
            localObject8 = localObject3;
            localObject5 = localObject3;
            if (paramMessage.istroop != 1008) {
              break label1781;
            }
            localObject3 = (String)localObject2 + (String)localObject5;
            localObject2 = localObject5;
            if (paramMessage.msgtype == -2016)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
              localObject3 = localObject2;
            }
            i2 = paramMessage.counter;
            if (!paramBoolean) {
              localObject3 = null;
            }
            if (paramMessage.istroop != 1008) {
              break label1835;
            }
            if ((paramMessage.extStr == null) || (!paramMessage.extStr.contains("lockDisplay"))) {
              break;
            }
            ((Intent)localObject7).putExtra("need_report", true);
            ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
            ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
            localObject2 = (String)localObject6 + " : " + (String)localObject2;
            localObject3 = ((Intent)localObject7).getStringExtra("uin");
            if (!AppConstants.L.equals(localObject3)) {
              break label1820;
            }
            localObject1 = a(paramMessage.frienduin, true);
            label596:
            localObject8 = localObject1;
            localObject5 = localObject2;
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject6 = localObject8;
            label616:
            if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (paramMessage.istroop != 1001)) {
              break label2071;
            }
            a((Intent)localObject1, (String)localObject2, (String)localObject3, (String)localObject5, i2, (Bitmap)localObject6, "CMD_SHOW_NOTIFIYCATION");
            return;
            if (paramMessage.msgtype == -2009)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
              break label119;
            }
            if (paramMessage.msgtype != -2011) {
              break label811;
            }
            try
            {
              localObject1 = StructMsgFactory.a(paramMessage.msgData);
              if (localObject1 != null) {
                break label801;
              }
              localObject1 = localObject2;
              if (!QLog.isColorLevel()) {
                break label119;
              }
              QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              localObject1 = localObject2;
            }
          }
          if (!QLog.isColorLevel()) {
            break label119;
          }
          QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
          localObject1 = localObject2;
          break label119;
          localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
          break label119;
          localObject1 = paramMessage.getMessageText();
          if ((localObject1 instanceof QQText))
          {
            localObject1 = ((QQText)localObject1).a();
            break label119;
          }
          localObject1 = new QQText(((CharSequence)localObject1).toString(), 3).a();
          break label119;
          if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName))) {
            localObject2 = a(paramMessage) + paramMessage.nickName + "(" + (String)localObject6 + ")" + ":";
          }
          for (Object localObject4 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject5;; localObject4 = a(paramMessage) + (String)localObject1 + ": " + (String)localObject5)
          {
            localObject1 = (DiscussionHandler)a(6);
            if (localObject1 == null) {
              break label2375;
            }
            localObject1 = ((DiscussionHandler)localObject1).a(paramMessage.frienduin, true);
            break;
            localObject1 = ContactUtils.a(this, paramMessage.senderuin, 0);
            localObject2 = a(paramMessage) + (String)localObject1 + "(" + (String)localObject6 + ")" + ":";
          }
          if (paramMessage.msgtype == -1013)
          {
            localObject2 = (String)localObject6 + ":";
            localObject1 = null;
            localObject4 = localObject5;
          }
          else
          {
            if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName))) {
              localObject2 = a(paramMessage) + paramMessage.nickName + "(" + (String)localObject6 + ")" + ":";
            }
            for (localObject1 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject5;; localObject1 = a(paramMessage) + (String)localObject1 + ": " + (String)localObject5)
            {
              localObject8 = a(paramMessage.frienduin, (byte)1, false, false);
              localObject4 = localObject1;
              localObject1 = localObject8;
              break;
              localObject1 = ContactUtils.f(this, paramMessage.frienduin, paramMessage.senderuin);
              localObject2 = a(paramMessage) + (String)localObject1 + "(" + (String)localObject6 + ")" + ":";
            }
            localObject2 = ((Intent)localObject7).getStringExtra("subAccountLatestNick");
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((String)localObject2).length() != 0) {}
            }
            else
            {
              localObject1 = paramMessage.senderuin;
            }
            localObject2 = (String)localObject6 + "-" + (String)localObject1 + ":" + (String)localObject5;
            localObject4 = (String)localObject1 + ":" + (String)localObject5;
            localObject1 = null;
            continue;
            localObject2 = (String)localObject6 + ": ";
            localObject1 = null;
            localObject4 = localObject5;
            continue;
            localObject2 = SkinUtils.a(a().getResources().getDrawable(2130838025));
            localObject4 = XMLMessageUtils.a(paramMessage);
            if ((localObject4 != null) && (!((PAMessage)localObject4).items.isEmpty()))
            {
              localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
              {
                localObject4 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                localObject6 = localObject1;
                localObject1 = localObject4;
              }
            }
            for (;;)
            {
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = "";
              break label312;
              continue;
              localObject1 = a(paramMessage.frienduin, (byte)1, true);
              break label285;
              localObject4 = a().a(AppShareIDUtil.a(paramMessage.shareAppID));
              if ((localObject4 == null) || (((AppShareID)localObject4).messagetail == null) || ("".equals(((AppShareID)localObject4).messagetail)))
              {
                localObject4 = a().getString(2131561662);
                break label384;
              }
              localObject4 = a().getString(2131563302) + ((AppShareID)localObject4).messagetail + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131562904);
              break label384;
              label1781:
              localObject4 = localObject2;
              if (paramMessage.istroop == 7000) {
                break label424;
              }
              localObject4 = (String)localObject2 + (String)localObject8;
              break label424;
              localObject6 = a().getString(2131562981);
              break label596;
              if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
              {
                if (OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramMessage.action, paramMessage.frienduin, paramMessage.istroop) == null) {
                  break;
                }
                localObject8 = localObject1;
                localObject5 = localObject2;
                localObject1 = localObject7;
                localObject2 = localObject4;
                localObject4 = localObject6;
                localObject6 = localObject8;
                break label616;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.e() > 1)
              {
                i2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.c();
                localObject5 = new Intent(a(), SplashActivity.class);
                ((Intent)localObject5).addFlags(335544320);
                ((Intent)localObject5).putExtra("tab_index", 0);
                localObject7 = localObject1;
                localObject1 = localObject5;
                localObject5 = localObject2;
                localObject2 = localObject4;
                localObject4 = localObject6;
                localObject6 = localObject7;
                break label616;
              }
              if (paramMessage.istroop == 0)
              {
                ((Intent)localObject7).putExtra("need_report", true);
                ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
                ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
                ((Intent)localObject7).putExtra("KEY_FROM", "notifcation");
              }
              localObject8 = localObject1;
              localObject5 = localObject2;
              localObject1 = localObject7;
              localObject2 = localObject4;
              localObject4 = localObject6;
              localObject6 = localObject8;
              break label616;
              if ((!QQUtils.a(a())) || (!SettingCloneUtil.readValue(a(), a(), a().getString(2131562309), "qqsetting_lock_screen_whenexit_key", true))) {
                break label650;
              }
              localObject7 = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getRunningTasks(1);
              int i1;
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                localObject7 = (ActivityManager.RunningTaskInfo)((List)localObject7).get(0);
                if (QLog.isDevelopLevel()) {
                  QLog.d("QQLSActivity", 4, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject7).topActivity.getClassName());
                }
                localObject7 = ((ActivityManager.RunningTaskInfo)localObject7).topActivity.getClassName();
                if ((((String)localObject7).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject7).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject7).equals("com.tencent.av.ui.AVActivity"))) {
                  i1 = 1;
                }
              }
              for (;;)
              {
                if ((i1 != 0) || (PhoneStatusTools.e(a())) || (!SettingCloneUtil.readValue(a(), a(), null, "qqsetting_msg_lockscreen_key", true))) {
                  break label2355;
                }
                QQLSRecentManager.a().a(this, paramMessage.frienduin, paramMessage.istroop);
                paramMessage = new Intent(a(), QQLSActivity.class);
                paramMessage.addFlags(67108864);
                paramMessage.addFlags(268435456);
                paramMessage.addFlags(262144);
                paramMessage.addFlags(1073741824);
                a().startActivity(paramMessage);
                break;
                i1 = 0;
                continue;
                i1 = 0;
              }
              break label650;
              localObject8 = localObject5;
              localObject5 = localObject4;
              break label392;
              localObject1 = localObject5;
            }
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    o();
    this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.a(paramResourcePluginListener);
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
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString != null) && ("".equals(paramString))) {}
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
    ((TroopHandler)a(19)).a(paramString, paramBoolean);
  }
  
  public void a(ArrayList paramArrayList)
  {
    F();
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
    while (i1 < 54)
    {
      if (i1 != 21) {
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
    a().edit().putBoolean(a().getString(2131562278) + a(), paramBoolean1).commit();
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
  
  public boolean a(byte paramByte)
  {
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), 2131562451, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramByte);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), 2131562451, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(int paramInt, String paramString)
  {
    byte b1 = 3;
    if (paramInt == 101) {
      b1 = 1;
    }
    String str = a(paramInt, paramString, b1);
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null) {}
    do
    {
      return true;
      paramString = new File(b(paramInt, paramString));
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localRoamSettingController.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.be;
      this.be = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.bf;
      this.bf = (i1 + 1);
    } while (i1 >= 3);
    ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), 2131562451, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramArrayOfByte1, paramArrayOfByte2);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 3034	com/tencent/mobileqq/app/QQAppInterface:m	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 479	com/tencent/mobileqq/app/QQAppInterface:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield 1285	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_ArrayOfByte	[B
    //   21: iconst_0
    //   22: putstatic 3036	com/tencent/mobileqq/app/LBSHandler:v	I
    //   25: aload_0
    //   26: getfield 953	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   29: ifnonnull +22 -> 51
    //   32: aload_0
    //   33: invokestatic 3041	com/tencent/mobileqq/app/soso/SosoInterface:a	()Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   36: putfield 953	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   39: aload_0
    //   40: new 3043	fka
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 3044	fka:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   48: putfield 947	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   51: invokestatic 645	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc_w 3046
    //   60: iconst_2
    //   61: ldc_w 3048
    //   64: invokestatic 671	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: new 604	android/os/Handler
    //   70: dup
    //   71: invokestatic 432	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   74: invokespecial 3051	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   77: new 3053	fkb
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 3054	fkb:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   85: invokevirtual 3058	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 953	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   93: astore_2
    //   94: aload_2
    //   95: monitorenter
    //   96: getstatic 3036	com/tencent/mobileqq/app/LBSHandler:v	I
    //   99: ifne +20 -> 119
    //   102: aload_0
    //   103: getfield 950	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo;
    //   106: ifnonnull +13 -> 119
    //   109: aload_0
    //   110: getfield 953	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface	Lcom/tencent/mobileqq/app/soso/SosoInterface;
    //   113: ldc2_w 3059
    //   116: invokevirtual 3063	java/lang/Object:wait	(J)V
    //   119: aload_2
    //   120: monitorexit
    //   121: aload_1
    //   122: monitorexit
    //   123: aload_0
    //   124: getfield 1285	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_ArrayOfByte	[B
    //   127: areturn
    //   128: astore_3
    //   129: aload_2
    //   130: monitorexit
    //   131: aload_3
    //   132: athrow
    //   133: astore_2
    //   134: bipush 245
    //   136: putstatic 3036	com/tencent/mobileqq/app/LBSHandler:v	I
    //   139: goto -18 -> 121
    //   142: astore_2
    //   143: aload_1
    //   144: monitorexit
    //   145: aload_2
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	QQAppInterface
    //   13	131	1	localObject1	Object
    //   133	1	2	localInterruptedException	java.lang.InterruptedException
    //   142	4	2	localObject2	Object
    //   128	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   96	119	128	finally
    //   119	121	128	finally
    //   129	131	128	finally
    //   89	96	133	java/lang/InterruptedException
    //   131	133	133	java/lang/InterruptedException
    //   16	51	142	finally
    //   51	67	142	finally
    //   67	89	142	finally
    //   89	96	142	finally
    //   121	123	142	finally
    //   131	133	142	finally
    //   134	139	142	finally
    //   143	145	142	finally
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
    Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130840233);
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
  
  public String b()
  {
    return "6.0.1";
  }
  
  public String b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    Object localObject;
    if (SystemUtil.a())
    {
      localStringBuilder.append(AppConstants.ay);
      localObject = a(paramInt, paramString);
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
      localStringBuilder.append("troop_sys_b");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      paramString = a() + paramString;
      continue;
      localStringBuilder.append("troop_");
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
    if (QLog.isColorLevel()) {
      QLog.d("turnOffNotifyPush", 2, "start");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext();
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences((Context)localObject2);
    try
    {
      String str1 = ((Context)localObject2).getString(2131563431);
      String str2 = ((Context)localObject2).getString(2131563428);
      localObject2 = ((Context)localObject2).getString(2131563429);
      String str3 = a();
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putBoolean(str1 + str3, false);
      ((SharedPreferences.Editor)localObject1).putBoolean(str2 + str3, false);
      ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2 + str3, false);
      ((SharedPreferences.Editor)localObject1).putBoolean("discussion_msg_notify" + str3, false);
      ((SharedPreferences.Editor)localObject1).commit();
      if (QLog.isColorLevel()) {
        QLog.d("turnOffNotifyPush", 2, "end");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool1 = c();
    boolean bool2 = f();
    if ((!g()) && (bool2) && (!bool1) && (!j()) && (!k()) && (l()) && (x()))
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
        if (localFile.exists())
        {
          localObject = Uri.fromFile(localFile);
          ((BaseApplicationImpl)a()).a((Uri)localObject, false);
        }
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_g_of_type_Long = paramLong;
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
    S();
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(paramResourcePluginListener);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
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
  
  public void b(String paramString, boolean paramBoolean)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    boolean bool1 = g();
    boolean bool2 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2);
    }
    int i1;
    if ((!bool1) && (bool2))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
      Vibrator localVibrator = (Vibrator)a().getSystemService("vibrator");
      bool1 = c();
      bool2 = B();
      boolean bool3 = A();
      boolean bool4 = l();
      boolean bool5 = x();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!j()) && (!k()) && (l()) && (x()))
      {
        i1 = localSharedPreferences.getInt("sound_type" + a(), 2131165197);
        if (!c(paramString)) {
          break label330;
        }
        i1 = 2131165215;
      }
    }
    label330:
    for (;;)
    {
      ((BaseApplicationImpl)a()).a(i1, false);
      return;
    }
  }
  
  public void b(boolean paramBoolean) {}
  
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
      a().edit().putBoolean(a().getString(2131563188) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).a(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(a(), a(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean b(byte paramByte, String paramString)
  {
    if (!NetworkUtil.e(getApplication()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), 2131562451, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.b(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
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
    return a().getBoolean(a().getString(2131562278) + a(), true);
  }
  
  /* Error */
  public byte[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 3034	com/tencent/mobileqq/app/QQAppInterface:m	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 477	com/tencent/mobileqq/app/QQAppInterface:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 3204	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   20: ifnonnull +41 -> 61
    //   23: aload_0
    //   24: new 3206	fkc
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 3207	fkc:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   32: putfield 3209	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSNotification	Lcom/tencent/lbsapi/QLBSNotification;
    //   35: aload_0
    //   36: new 3211	com/tencent/lbsapi/QLBSService
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 903	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload_0
    //   45: getfield 3209	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSNotification	Lcom/tencent/lbsapi/QLBSNotification;
    //   48: ldc 196
    //   50: ldc 199
    //   52: ldc_w 3213
    //   55: invokespecial 3216	com/tencent/lbsapi/QLBSService:<init>	(Landroid/content/Context;Lcom/tencent/lbsapi/QLBSNotification;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   58: putfield 3204	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   61: invokestatic 645	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +13 -> 77
    //   67: ldc_w 3046
    //   70: iconst_2
    //   71: ldc_w 3218
    //   74: invokestatic 671	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: ldc_w 3046
    //   80: ldc_w 3220
    //   83: invokestatic 3225	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 475	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ArrayOfByte	[B
    //   91: new 604	android/os/Handler
    //   94: dup
    //   95: invokestatic 432	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   98: invokespecial 3051	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   101: new 3227	fjn
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 3228	fjn:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   109: invokevirtual 3058	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   112: pop
    //   113: aload_0
    //   114: getfield 3204	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   117: astore_2
    //   118: aload_2
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 3204	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentLbsapiQLBSService	Lcom/tencent/lbsapi/QLBSService;
    //   124: ldc2_w 3059
    //   127: invokevirtual 3063	java/lang/Object:wait	(J)V
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_0
    //   135: getfield 475	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ArrayOfByte	[B
    //   138: areturn
    //   139: astore_3
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_3
    //   143: athrow
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 3229	java/lang/InterruptedException:printStackTrace	()V
    //   149: goto -17 -> 132
    //   152: astore_2
    //   153: aload_1
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	QQAppInterface
    //   13	141	1	localObject1	Object
    //   144	2	2	localInterruptedException	java.lang.InterruptedException
    //   152	4	2	localObject2	Object
    //   139	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   120	132	139	finally
    //   140	142	139	finally
    //   113	120	144	java/lang/InterruptedException
    //   142	144	144	java/lang/InterruptedException
    //   16	61	152	finally
    //   61	77	152	finally
    //   77	113	152	finally
    //   113	120	152	finally
    //   132	134	152	finally
    //   142	144	152	finally
    //   145	149	152	finally
    //   153	155	152	finally
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
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQi", 0);
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMessageConnect...");
    }
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!d())) {}
    Handler localHandler;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d();
      }
      d();
      a().a();
      localHandler = a(Conversation.class);
    } while (localHandler == null);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 0;
    localMessage.what = 1134024;
    localHandler.sendMessage(localMessage);
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
    if (this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.b(paramResourcePluginListener);
    }
  }
  
  public void c(String arg1)
  {
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {}
    Object localObject3;
    for (;;)
    {
      return;
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        this.jdField_a_of_type_JavaUtilHashtable.remove(???);
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 990;
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        if (this.jdField_a_of_type_JavaUtilHashtable.size() > 50) {
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            long l1 = System.currentTimeMillis();
            ??? = new ArrayList();
            localObject3 = this.jdField_a_of_type_JavaUtilHashtable.keys();
            while (((Enumeration)localObject3).hasMoreElements())
            {
              String str = (String)((Enumeration)localObject3).nextElement();
              if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) > 180000L) {
                ((ArrayList)???).add(str);
              }
            }
          }
        }
      }
    }
    int i1 = 0;
    while (i1 < localObject2.size())
    {
      localObject3 = (String)localObject2.get(i1);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject3);
      i1 += 1;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131562916) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).b(paramBoolean1);
  }
  
  public boolean c()
  {
    if (!this.j) {
      return false;
    }
    Object localObject = ((ActivityManager)a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqqi:video")) {
          return true;
        }
      }
    }
    this.j = false;
    return false;
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "CNR canAutoLogin autoLogin = " + bool);
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
    return ((TicketManager)getManager(2)).getSkey(getAccount());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnOpenAndStartGetMsg");
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
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.c(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    a().edit().putBoolean(a().getString(2131563425) + a(), paramBoolean).commit();
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.be = 1;
    }
    for (;;)
    {
      ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.bf = 1;
    }
  }
  
  public boolean d()
  {
    return (getAccount() != null) && (isLogin());
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
    FriendManager localFriendManager = (FriendManager)getManager(8);
    if (localFriendManager != null) {
      return localFriendManager.a(a());
    }
    return "";
  }
  
  public void e()
  {
    BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(new fjv(this));
  }
  
  public void e(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(String paramString)
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
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startSubMessageAccountMsg xxxxxxxx zsw 0");
    }
    if (((SubAccountGetMessageControll)getManager(29) != null) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startSubMessageAccountMsg xxxxxxxx zsw 1");
    }
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean e()
  {
    return SettingCloneUtil.readValue(a(), a(), a().getString(2131563430), "qqsetting_notify_showcontent_key", true);
  }
  
  public int f()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public String f()
  {
    return ((TicketManager)getManager(2)).getVkey(getAccount());
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnClose");
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
    localEditor.putBoolean(BaseApplication.getContext().getString(2131563422) + a(), paramBoolean);
    localEditor.commit();
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.b(paramBoolean1, paramBoolean2);
    }
  }
  
  boolean f()
  {
    if (B())
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
  
  protected void finalize()
  {
    super.finalize();
    EntityManagerFactory localEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    if (localEntityManagerFactory != null) {
      localEntityManagerFactory.close();
    }
  }
  
  public String g()
  {
    String str = f();
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
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvFistResp");
    }
    Handler localHandler;
    if (!LoadingStateManager.a().d())
    {
      LoadingStateManager.a().a(2);
      localHandler = a(Conversation.class);
      if (localHandler != null) {
        localHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    do
    {
      do
      {
        return;
      } while (!LoadingStateManager.a().b());
      localHandler = a(Conversation.class);
    } while (localHandler == null);
    localHandler.obtainMessage(1134015, null).sendToTarget();
  }
  
  public void g(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(28);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public boolean g()
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
          break label666;
        }
        return localManager2;
        if (localManager1 != null) {
          addManager(paramInt, localManager1);
        }
        return localManager1;
      }
      Object localObject2 = new WtloginManagerImpl(this);
      continue;
      localObject2 = new TicketManagerImpl(this);
      continue;
      localObject2 = new ProxyIpManagerImpl(this);
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
      localObject2 = new EmoticonManagerImp(this);
      continue;
      localObject2 = new RoamSettingManager(this);
      continue;
      localObject2 = StatusManager.a(this);
      continue;
      localObject2 = new ShieldMsgManger(this);
      continue;
      localObject2 = new SttManager(this);
      continue;
      localObject2 = new ProxyManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)localObject2);
      continue;
      getManager(26);
      localObject2 = new QQMessageFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)localObject2);
      continue;
      localObject2 = new ConversationFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)localObject2);
      continue;
      localObject2 = new RecommendTroopManagerImp(this);
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
      localObject2 = new SubAccountProtocManager(this);
      continue;
      localObject2 = new RoamSettingController(this);
      continue;
      localObject2 = new SubAccountGetMessageControll(this);
      continue;
      localObject2 = new DiscussionMemberManager(this);
      continue;
      localObject2 = new NewFriendManager(this);
      continue;
      localObject2 = new CircleManager(this);
      continue;
      localObject2 = new TroopCreateLogic(this);
      continue;
      localObject2 = new RecentManagerFor3rdPart(this);
      continue;
      localObject2 = new RedTouchManager(this);
      continue;
      localObject2 = new QCallFacade(this);
      continue;
      localObject2 = new ContactSyncManager(this);
      continue;
      localObject2 = new PicPreDownloader(this);
      continue;
      localObject2 = new RoamMapController(this);
      continue;
      localObject2 = new FontManager(this);
      continue;
      localObject2 = new BubbleManager(this);
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
      localObject2 = new PublicAccountDataManager(this);
      continue;
      localObject2 = new MyBusinessManager(this);
      continue;
      localObject2 = new ConditionSearchManager(this);
      continue;
      localObject2 = new I18nPublicAccountsManagerImp(this);
      continue;
      return localObject2;
      label666:
      localObject2 = localManager2;
      switch (paramInt)
      {
      }
      localObject2 = localManager2;
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConnAllFailed");
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
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void i()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(2130838143);
      localNotificationManager.cancel(2130838142);
      localNotificationManager.cancel(122);
      label33:
      a(new ToServiceMsg("mobileqq.service", a(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  public boolean i()
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
  
  public void j()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(2130838143);
      localNotificationManager.cancel(2130838142);
      label27:
      a(a());
      return;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public boolean j()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, a() + " qq start to exit ");
    }
    O();
    N();
    MobileQQ localMobileQQ;
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value in exit........... kickpc = false");
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
        break label172;
      }
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      localMobileQQ.QQProcessExit(bool);
      i();
      return;
      sendOnlineStatus(AppRuntime.Status.offline, false);
      break;
    }
  }
  
  public boolean k()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = null;
  }
  
  public boolean l()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)a().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      O();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
    LoadingStateManager.a().a();
    N();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC in app  do logout");
    }
    String str = a();
    if (str != null) {
      SdkContext.cleanCokiee(a(), Long.parseLong(str));
    }
    TencentTranslator.a(this).a();
    super.logout(paramBoolean);
  }
  
  public void m()
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
      ((PushManager)getManager(5)).registProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video", "com.tencent.av.ui.qqi.VChatActivity", new String[] { "VideoSvc.Send", "VideoCCSvc.PutInfo", "SharpSvr.c2sack", "SharpSvr.s2c" });
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "kickPC get value in sendRegisterPush........... kickpc = " + b());
      }
      sendOnlineStatus(localStatus, b());
      return;
      localStatus = AppRuntime.Status.online;
      continue;
      localStatus = AppRuntime.Status.away;
      continue;
      localStatus = AppRuntime.Status.invisiable;
    }
  }
  
  public final boolean m()
  {
    return a().getBoolean(a().getString(2131563425) + a(), false);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
    R();
  }
  
  public boolean n()
  {
    return a().getBoolean(a().getString(2131563188) + a(), false);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig == null)
    {
      p();
      this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig = new LebaConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.a();
    }
  }
  
  public boolean o()
  {
    return a().getBoolean(a().getString(2131562916) + a(), false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReportController.a(this);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService = new MobileQQService(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (d())
    {
      QCallFacade.a(this, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().createEntityManager();
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{{4,3,5,6},[10,11,13],16,19,20,21,38,39,[24,9,25,27,28,29,30,31,32,33,35,36,37,41,42,43,45,46],49,50}"));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
    }
    paramBundle = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, paramBundle);
    paramBundle = new IntentFilter("com.tencent.qzone.clean_sharealbum");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, paramBundle);
    P();
    if (StartService.jdField_a_of_type_Boolean) {
      ProfileCardUtil.a();
    }
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    this.jdField_d_of_type_Boolean = true;
    a().a();
    a().d();
    UniformDownloadMgr.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    N();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundSettingActivity.f();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(a()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    localEditor = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
    localEditor.putString("no_auto_reply" + getAccount(), "");
    localEditor.commit();
    i();
    p();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      try
      {
        label153:
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
        label164:
        UniformDownloadMgr.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
          a().b();
        }
        Config.b();
        AppLaucherHelper.a();
        EmoticonController.a(this);
        TroopFileUploadingManager.a(this);
        QZoneShareAlbumAssistantManager.k(this);
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
        return;
      }
      catch (Exception localException1)
      {
        break label164;
      }
    }
    catch (Exception localException2)
    {
      break label153;
    }
  }
  
  public void onRunningBackground(Bundle paramBundle)
  {
    super.onRunningBackground(paramBundle);
    paramBundle = (NewFriendManager)getManager(32);
    if (paramBundle != null) {}
    for (int i1 = paramBundle.a(1);; i1 = 0)
    {
      paramBundle = a();
      if (paramBundle != null)
      {
        int i2 = paramBundle.f();
        if (isLogin()) {
          BadgeUtils.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i1 + i2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.e();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
        U();
      }
      return;
    }
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    QQMessageFacade localQQMessageFacade = a();
    if ((localQQMessageFacade != null) && (localQQMessageFacade.f() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    ReportController.a(this, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
      T();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig.b();
      this.jdField_a_of_type_ComTencentMobileqqConfigLebaConfig = null;
    }
  }
  
  public boolean p()
  {
    Object localObject = a();
    localObject = ((FriendsManager)getManager(46)).a((String)localObject);
    if (localObject == null) {
      return false;
    }
    if (((Card)localObject).isShowZan()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void q()
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
  
  public boolean q()
  {
    return a().getBoolean(a().getString(2131561651) + a(), false);
  }
  
  public void r()
  {
    b(null, false);
  }
  
  public boolean r()
  {
    SubAccountGetMessageControll localSubAccountGetMessageControll = (SubAccountGetMessageControll)getManager(29);
    if (localSubAccountGetMessageControll != null) {
      return localSubAccountGetMessageControll.a();
    }
    return false;
  }
  
  public void s()
  {
    ((LBSHandler)a(3)).b();
  }
  
  public boolean s()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "CNR setAutoLogin autoLogin = " + paramBoolean);
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), h(), paramBoolean);
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null)) {
      return;
    }
    super.start(paramBoolean);
  }
  
  public void t()
  {
    ((CardHandler)a(2)).a();
  }
  
  public boolean t()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    boolean bool3 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l1 = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l1);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l1 != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stopSubMessageAccountMsg xxxxxxxx zsw 0");
    }
    SubAccountGetMessageControll localSubAccountGetMessageControll = (SubAccountGetMessageControll)getManager(29);
    if (localSubAccountGetMessageControll != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "stopSubMessageAccountMsg xxxxxxxx zsw 1");
      }
      localSubAccountGetMessageControll.a();
    }
  }
  
  public boolean u()
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
        QLog.i(jdField_a_of_type_JavaLangString, 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((FriendManager)localObject).c(str1);
      break;
    }
  }
  
  protected void userLogoutReleaseData()
  {
    O();
    TroopFileManager.a();
    UpgradeController.a().a(true);
    SystemMsgController.a().c();
    FriendSystemMsgController.a().c();
    GroupSystemMsgController.a().c();
    MsgAutoMonitorUtil.a().a();
    BadgeUtils.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 0);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("unreadcount", 0).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    try
    {
      CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      CookieManager.getInstance().removeSessionCookie();
      CookieSyncManager.getInstance().sync();
      TencentTranslator.a(this).a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "userLogoutReleaseData ", localException);
        }
      }
    }
  }
  
  public void v()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.U, 0);
      a().a().f();
      return;
    }
  }
  
  public boolean v()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131563422) + a(), true);
  }
  
  public void w()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.U, 0);
      return;
    }
  }
  
  public void x()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.aa, 0);
      a().a().f();
      return;
    }
  }
  
  public void y()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.aa, 0);
      return;
    }
  }
  
  public void z()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsg");
      }
      a().a(AppConstants.Z, 0);
      a().a().d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */