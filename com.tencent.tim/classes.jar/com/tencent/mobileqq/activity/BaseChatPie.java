package com.tencent.mobileqq.activity;

import aavr;
import aavt;
import aavu;
import abgl;
import abgw;
import abhe;
import abhh;
import abij;
import abin;
import abrb;
import abrg;
import abrj;
import abzy;
import acbh;
import acbn;
import acbs;
import accn;
import accp;
import accq;
import accz;
import acea;
import acei;
import acfd;
import acff;
import acfp;
import acgr;
import acjz;
import aclr;
import acrb;
import acsb;
import aczy;
import adqr;
import adrl;
import adrm;
import adxn;
import adyf;
import aegu;
import afck;
import afdt;
import afdv;
import afdw;
import afef;
import afem;
import affc;
import afmf;
import afmi;
import afnd;
import afoc;
import afpu;
import aghq;
import agkf;
import agkh;
import agne;
import agnk;
import ahav;
import aheq;
import ahhz;
import ahjz;
import ahwa;
import ahwb;
import ahwv;
import ahxg.a;
import ahxs;
import ahxs.a;
import ahxs.b;
import ahyj;
import ahzd;
import ahzy;
import aily;
import aixt;
import aiyh;
import aiyr;
import aiyx;
import aizf;
import ajcy;
import ajdg;
import ajlc;
import ajol;
import ajoo;
import ajpc;
import ajpd;
import akxo;
import alid;
import alii;
import alkm;
import alte;
import altg;
import alvj;
import alvn;
import alwy;
import amia;
import amim;
import anaz;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;
import anfe;
import anii;
import anjo;
import ankq;
import ankt;
import anod;
import anot;
import anoz;
import anpc;
import anqo;
import anqs;
import aocq;
import aofr;
import aofy;
import aogk;
import aojs;
import aomq;
import aoqr;
import apab.a;
import apat;
import apdd;
import apdd.a;
import appb;
import appd;
import appe;
import apqk;
import apsa;
import apsw;
import apsw.e;
import aptl;
import aptl.a;
import apwy;
import aqcl;
import aqdj;
import aqfl;
import aqfp;
import aqfr;
import aqft;
import aqfv;
import aqfx;
import aqge;
import aqgm;
import aqgv;
import aqha;
import aqiw;
import aqiy;
import aqjc;
import aqjf;
import aqjh;
import aqju;
import aqlr;
import aqlv;
import aqmj;
import aqmq;
import aqmr;
import aqnl;
import aqpm;
import aqrb;
import aqrc;
import aqrd;
import aqym;
import arge;
import arhz;
import arjn;
import augb;
import aupd;
import aurd;
import aurf;
import ausb;
import ausj;
import auss;
import auuo;
import avdb;
import avfp;
import avhc;
import avkw;
import awou;
import awpl;
import awrl;
import awrp;
import awsw;
import axcg;
import axgk;
import ayag;
import com.immersion.stickersampleapp.HapticManager;
import com.rookery.translate.AITranslator;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.a;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.b;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.b;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.b;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.b;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.b;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.a;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.c;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.d;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.a;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.emoticonview.ReportWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.richstatus.RichStatus.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.mobileqq.widget.CommonTextView;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinEngine;
import com.tencent.tim.dingdong.DingdongPluginBizObserver;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.d;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AbsListView.g;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.e;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.a;
import com.tencent.widget.XPanelContainer.c;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import ija;
import inh;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jll;
import jof;
import jqs;
import jss;
import ku;
import lcm;
import lf;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import rnq;
import skd;
import smx;
import snf;
import syw;
import tat;
import tnt;
import tog;
import ton;
import top;
import txn;
import tzc;
import uic;
import uid;
import uie;
import uif;
import uig;
import uih;
import uii;
import uij;
import uik;
import uil;
import uin;
import uio;
import uip;
import uiq;
import uir;
import uis;
import uit;
import uiu;
import uiv;
import uiw;
import uix;
import uiy;
import uiz;
import ujb;
import uje;
import ujf;
import ujg;
import ujh;
import uji;
import ujj;
import ujk;
import ujl;
import ujm;
import ujn;
import ujo;
import ujp;
import ujq;
import ujr;
import ujs;
import ujt;
import ujt.d;
import wir;
import wiw;
import wja;
import wjw;
import wki;
import wkj;
import wkk;
import wla;
import wmj;
import wnc;
import wnf;
import wpj;
import wrq;
import wsd;
import wsr;
import wtk;
import wub;
import wun;
import wur;
import wvd;
import wvm;
import wvn;
import wvo;
import wvr;
import wvy;
import wwb;
import wwd;
import wwg;
import wwl;
import wwn;
import wwu;
import www;
import wwz;
import wxa;
import wxo;
import wyv;
import wyw;
import wzb.a;
import xje.a;
import xjx.a;
import xkl;
import xkr;
import xks;
import xkx;
import xmb;
import xmj;
import xmj.a;
import xov.a;
import xro;
import xru;
import xva;
import xvu;
import xyi;
import xzp;
import ycd;
import yfp;
import ygg;
import ygh;
import yhv;
import yhw;
import yhz;
import yia;
import yif;
import yih;
import yiq;
import yir;
import yiu;
import yja;
import yjc;
import yje;
import yjh;
import yjr;
import ykm;
import znh;
import zxj;

public class BaseChatPie
  implements accp, accq, afmf, Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, auuo, BaseChatItemLayout.b, MediaPlayerManager.b, PanelIconLinearLayout.b, ChatXListView.a, INetInfoHandler, AbsListView.d, AbsListView.e, AbsListView.g, XPanelContainer.a, XPanelContainer.c, Observer, ujs, znh
{
  public static boolean aSH;
  private static boolean aSz;
  public static boolean aTb;
  private static int bEA;
  public static int bEE = 30;
  private static int bEs;
  protected TextView A;
  protected ViewStub B;
  public aqju B;
  public Dialog C;
  protected TextView CA;
  protected TextView CB;
  protected TextView Cr;
  public TextView Cs;
  protected TextView Ct;
  public TextView Cu;
  public TextView Cv;
  private TextView Cw;
  protected TextView Cx;
  private TextView Cy;
  private TextView Cz;
  protected CharSequence E;
  public long Fp = -1L;
  protected long Fq;
  protected long Fr;
  private long Fs = -1L;
  public long Ft = -1L;
  private long Fu;
  private long Fv = -1L;
  protected int Hy;
  private Boolean T = Boolean.valueOf(true);
  public String TAG = "BaseChatPie";
  private Boolean U = Boolean.valueOf(false);
  public abin a;
  public abzy a;
  public acbh a;
  private acea jdField_a_of_type_Acea = new uiz(this);
  public acjz a;
  private aclr jdField_a_of_type_Aclr = new ujb(this);
  public adrl a;
  private afdw jdField_a_of_type_Afdw;
  public afef a;
  private afoc jdField_a_of_type_Afoc;
  ahxg.a jdField_a_of_type_Ahxg$a;
  ahxs.a jdField_a_of_type_Ahxs$a;
  ahxs.b jdField_a_of_type_Ahxs$b;
  private aiyr jdField_a_of_type_Aiyr;
  private aiyx jdField_a_of_type_Aiyx;
  private ajdg jdField_a_of_type_Ajdg;
  protected MessageQueue.IdleHandler a;
  private MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod;
  public ViewFlipper a;
  public apat a;
  protected apdd.a a;
  protected apwy a;
  aqrd jdField_a_of_type_Aqrd = new uiy(this);
  public arhz a;
  private arjn jdField_a_of_type_Arjn;
  private augb jdField_a_of_type_Augb = new ujn(this);
  private aupd jdField_a_of_type_Aupd = new ujp(this);
  private BaseChatpieHelper.a jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper$a;
  public BaseChatpieHelper a;
  public InputLinearLayout a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public AIOAnimationConatiner a;
  protected MoveToBottomScroller a;
  public AudioPanel a;
  protected VoiceTextEditPanel a;
  protected DoodlePanel a;
  final StructingMsgItemBuilder.b jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$b = new StructingMsgItemBuilder.b();
  protected AIOFakePanel a;
  protected PhotoListPanel.a a;
  protected PhotoListPanel.c a;
  private PhotoListPanel.d jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d = new ujm(this);
  public PhotoListPanel a;
  protected VideoStatusTipsBar a;
  public ApolloPanel a;
  public InputGlobalLayoutListener a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  private NoC2CExtensionInfo jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private EmotionKeywordLayout jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout;
  protected EmotionSearchPanel a;
  public FastImagePreviewLayout a;
  RichTextPanel jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
  public HotPicMainPanel a;
  public DrawerFrame a;
  public QQBlurView a;
  protected ScrollerRunnable a;
  public NavBarAIO a;
  private DingdongPluginBizObserver jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver = new ujo(this);
  XEditTextEx.e jdField_a_of_type_ComTencentWidgetXEditTextEx$e = new uie(this);
  public XEditTextEx a;
  private inh jdField_a_of_type_Inh;
  public smx a;
  public wiw a;
  public wki a;
  public wnc a;
  public wsr a;
  public wvm a;
  public xru a;
  private ygg jdField_a_of_type_Ygg;
  protected yhw a;
  protected yhz a;
  protected yif a;
  protected yir a;
  protected yiu a;
  public yja a;
  protected yje a;
  public yjh a;
  protected yjr a;
  public zxj a;
  public boolean aL;
  protected String aLA = "";
  protected String aLB;
  protected String aLy;
  public String aLz;
  boolean aM = false;
  protected boolean aN;
  protected boolean aO;
  public FrameLayout aQ;
  private boolean aSA = true;
  private volatile boolean aSB;
  private boolean aSC;
  public boolean aSD;
  public boolean aSE;
  protected boolean aSF;
  private boolean aSG = true;
  public boolean aSI;
  public boolean aSJ;
  public boolean aSK;
  public boolean aSL;
  public boolean aSM;
  public boolean aSN;
  private boolean aSO;
  private boolean aSP;
  private boolean aSQ;
  private boolean aSR;
  private boolean aSS;
  private boolean aST;
  private boolean aSU;
  protected boolean aSV = true;
  private boolean aSW;
  private boolean aSX = true;
  public boolean aSY;
  private boolean aSZ;
  public boolean aSc = true;
  protected boolean aSd;
  protected boolean aSe;
  public boolean aSf;
  private boolean aSg = true;
  protected boolean aSh;
  protected boolean aSi;
  public final boolean aSj = true;
  public boolean aSk = true;
  public boolean aSl;
  private boolean aSm = true;
  boolean aSn = false;
  boolean aSo = false;
  private boolean aSp;
  public boolean aSq;
  protected boolean aSr;
  boolean aSs = false;
  public volatile boolean aSt;
  protected boolean aSu;
  boolean aSv = true;
  boolean aSw = true;
  private boolean aSx;
  boolean aSy = false;
  public boolean aTa;
  public ImageButton ad;
  boolean aex = false;
  public boolean aey;
  public boolean ahi;
  public QQAppInterface app;
  private accz jdField_b_of_type_Accz = new uiw(this);
  private aghq jdField_b_of_type_Aghq;
  private View.OnLayoutChangeListener jdField_b_of_type_AndroidViewView$OnLayoutChangeListener;
  public arjn b;
  public QQMessageFacade.b b;
  public PanelIconLinearLayout b;
  protected PhotoListPanel b;
  protected FriendListHandler b;
  public ChatXListView b;
  protected QQRecorder b;
  public PatchedButton b;
  public XPanelContainer b;
  private int bEB = 0;
  private int bEC;
  protected int bED = -1;
  protected final int bEf = 300;
  private int bEg;
  private int bEh;
  public int bEi;
  int bEj = 0;
  protected int bEk = 131075;
  protected int bEl = 0;
  private int bEm = 0;
  private int bEn = 1;
  private int bEo;
  private int bEp = 10;
  int bEq = 0;
  private int bEr;
  private int bEt = -1;
  protected int bEu = -1;
  public int bEv = -1;
  private int bEw = -1;
  private int bEx = -1;
  private int bEy = -1;
  protected int bEz;
  private int baS;
  private TextView bs;
  public AtomicBoolean bt = new AtomicBoolean(false);
  private acfd jdField_c_of_type_Acfd = new uiu(this);
  Dialog jdField_c_of_type_AndroidAppDialog;
  protected EmoticonMainPanel c;
  public ViewGroup cJ;
  public ViewGroup cK;
  public ViewGroup cL;
  private accn cardObserver = new uix(this);
  private long createTime;
  private PowerManager.WakeLock d;
  private Runnable dG;
  private Runnable dH = new BaseChatPie.1(this);
  protected View.OnClickListener dd = new ujk(this);
  public boolean du = true;
  protected RelativeLayout f;
  protected int fateOfRecorder = 0;
  protected RelativeLayout fn;
  public RelativeLayout fs;
  Runnable g = new BaseChatPie.42(this);
  protected RelativeLayout gn;
  protected RelativeLayout go;
  protected View iX;
  private long lastRefreshTime = -1L;
  protected LinearLayout linearLayout;
  protected View loadingView;
  public ViewGroup mAIORootView;
  public FragmentActivity mActivity;
  public Context mContext;
  protected float mDensity;
  private GestureDetector mGestureDetector;
  private boolean mIsMsgSignalOpen = false;
  private int mMsgSignalCount;
  private int mMsgSignalNetType;
  private int mMsgSignalSum;
  private BroadcastReceiver mReceiver = new uig(this);
  int mScrollState = 0;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  protected int mTitleHeight;
  public ImageView mTitleIcon;
  public TextView mTitleText;
  public int playMode;
  protected ImageView pp;
  protected ImageView pq;
  protected ImageView pr;
  public ImageView ps;
  public ImageView pt;
  public ImageView pu;
  protected ImageView pv;
  public ImageView pw;
  public ImageView px;
  private ImageView py;
  public ImageView pz;
  protected List<QQOperationViopTipTask> qm = new ArrayList();
  protected View rA;
  protected View rB;
  public View rC;
  private View rD;
  protected View rE;
  public View rF;
  public View rG;
  public View rH;
  private View rI;
  private View rJ;
  protected View rK;
  protected View rL;
  protected View rM;
  protected View rz;
  RelativeLayout.LayoutParams s;
  public SessionInfo sessionInfo = new SessionInfo();
  RelativeLayout.LayoutParams t;
  public TextView tU;
  RelativeLayout.LayoutParams u;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  public arhz x;
  public arhz y;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    this.jdField_a_of_type_Acbh = new acbh(this);
    Ib();
    this.app = paramQQAppInterface;
    this.mAIORootView = paramViewGroup;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mTitleHeight = this.mContext.getResources().getDimensionPixelSize(2131299627);
    if (bEA == 0) {
      bEA = paramContext.getResources().getInteger(2131427349);
    }
    this.jdField_a_of_type_Wvm = new wvm(this);
    bJf();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper = new BaseChatpieHelper(this);
    this.jdField_a_of_type_Xru = new xru(paramContext, this);
  }
  
  private void Ab(int paramInt)
  {
    if (this.rG != null)
    {
      if (paramInt < 1) {
        break label43;
      }
      this.rG.setVisibility(8);
    }
    for (;;)
    {
      if (this.rH != null)
      {
        if (paramInt < 1) {
          break;
        }
        this.rH.setVisibility(8);
      }
      return;
      label43:
      this.rG.setVisibility(0);
    }
    this.rH.setVisibility(0);
  }
  
  private void Aj(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 25: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      return;
    case 21: 
      bIk();
      return;
    case 24: 
      bIv();
      return;
    case 3: 
      bIC();
      return;
    case 8: 
      bIB();
      return;
    case 2: 
      bIA();
      return;
    case 4: 
      bIy();
      return;
    case 9: 
      xro.a(this.app, this.mActivity);
      return;
    case 10: 
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(10);
      return;
    case 6: 
      bIx();
      return;
    case 5: 
      bIw();
      return;
    case 14: 
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(14);
      xro.i(this.app, "0X8005977", this.sessionInfo.cZ);
      return;
    case 23: 
    case 26: 
      Ak(paramInt);
      return;
    case 22: 
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(22);
      return;
    case 31: 
      bIu();
      return;
    }
    PublishHomeWorkFragment.k(this.app, this.mActivity, this.sessionInfo.aTl);
    aqfr.a(this.app, this.sessionInfo.aTl, "homework", "AioAssign_Clk", 0, 0, new String[] { this.sessionInfo.aTl, "", "", aqfr.r(this.app, this.sessionInfo.aTl) });
  }
  
  private void Ak(int paramInt)
  {
    switch (paramInt)
    {
    case 24: 
    case 25: 
    default: 
      return;
    case 23: 
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(23, false);
      xks.o(this.app, true);
      bIl();
      getApp().reportClickEvent("CliOper", "0X8007F20");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(26, false);
    xks.n(this.app, true);
    paramInt = xks.o(this.app);
    ujt.b(this.app, BaseApplicationImpl.getContext(), this.sessionInfo, paramInt, "", "");
    anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8007F23", "0X8007F23", paramInt, 0, "", "", "", "");
  }
  
  private void An(int paramInt)
  {
    if (this.rJ == null)
    {
      this.rI = new View(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      int i = Color.parseColor("#7f000000");
      this.rI.setBackgroundColor(i);
      this.rI.setId(2131374807);
      this.rI.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131374839);
      this.fs.addView(this.rI, (ViewGroup.LayoutParams)localObject);
      this.Cz = new TextView(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, wja.dp2px(40.0F, this.fs.getResources()));
      this.Cz.setGravity(17);
      this.Cz.setTextSize(14.0F);
      this.Cz.setId(2131374839);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
      this.fs.addView(this.Cz, (ViewGroup.LayoutParams)localObject);
      this.rJ = new View(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131299627));
      this.rJ.setBackgroundColor(i);
      this.rJ.setId(2131374837);
      this.rJ.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377361);
      this.cL.addView(this.rJ, (ViewGroup.LayoutParams)localObject);
    }
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131374839);
    this.rI.setVisibility(paramInt);
    this.Cz.setVisibility(paramInt);
    this.rJ.setVisibility(paramInt);
    Object localObject = (ChatFragment)this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((localObject == null) || (((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)) {
      return;
    }
    if (paramInt == 0)
    {
      ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(2130706432, PorterDuff.Mode.SRC_ATOP));
      return;
    }
    ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(null);
  }
  
  private void D(MessageRecord paramMessageRecord)
  {
    if ((32768 != paramMessageRecord.extraflag) && ((paramMessageRecord instanceof MessageForApollo))) {
      ((abhe)this.app.getManager(211)).a((MessageForApollo)paramMessageRecord, "aio");
    }
  }
  
  private void M(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private boolean OW()
  {
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      if ((i >= top.eW.length) || (this.sessionInfo.cZ == top.eW[i]))
      {
        if (i < top.eW.length) {
          bool = true;
        }
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean OX()
  {
    return (this.mContext != null) && (this.mActivity != null) && (this.mActivity.getIntent() != null) && (this.mActivity.getIntent().getExtras() != null) && (this.mActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"));
  }
  
  private boolean OY()
  {
    return (this.mActivity != null) && (this.mActivity.getIntent() != null) && (this.mActivity.getIntent().getExtras() != null) && (this.mActivity.getIntent().getExtras().containsKey("apollo_forward_key"));
  }
  
  private boolean OZ()
  {
    return (this.sessionInfo.cZ != 1008) && (!this.aN);
  }
  
  private boolean Pi()
  {
    if (SystemClock.uptimeMillis() - this.Ft <= 1000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        Object localObject = a();
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getIntent();
          bool2 = bool1;
          if (localObject != null)
          {
            bool1 = ((Intent)localObject).getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false);
            bool2 = bool1;
            if (bool1)
            {
              ((Intent)localObject).removeExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM");
              this.Ft = SystemClock.uptimeMillis();
              bool2 = bool1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "blockRefreshJumpBottom() block = " + bool2);
      }
      return bool2;
    }
  }
  
  private void Q(boolean paramBoolean, String paramString)
  {
    ThreadManager.post(new BaseChatPie.9(this, paramString, paramBoolean), 8, null, true);
  }
  
  private int a(List<ChatMessage> paramList, long paramLong)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
      {
        if (((ChatMessage)paramList.get(i)).shmsgseq != paramLong) {}
      }
      else {
        while (((ChatMessage)paramList.get(i)).time == paramLong) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    long l;
    switch (paramInt6)
    {
    case 5: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      if (paramList1 != paramList2)
      {
        if ((paramInt4 <= 0) || (paramInt5 <= 0)) {
          break label659;
        }
        l = ((ChatMessage)paramList1.get(paramInt4 - 1)).uniseq;
        paramInt1 = paramInt5 - 1;
        if (paramInt1 < 0) {
          break label659;
        }
        if ((paramInt1 == paramInt5 - 1) && (ahwb.aB((MessageRecord)paramList2.get(paramInt1)))) {
          paramInt1 = -1;
        }
      }
      break;
    }
    for (;;)
    {
      label148:
      if (paramInt1 >= 0) {
        paramInt1 = paramInt5 - (paramInt4 - this.bEg + paramInt5 - 1 - paramInt1);
      }
      for (;;)
      {
        label170:
        if (paramInt6 == 6)
        {
          paramInt1 = paramInt5 - (paramInt4 - this.bEg);
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), -1, null, 7);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.MM() == 22)) {
            QQToast.a(this.app.getApp(), 1, this.mContext.getString(2131700005), 3000).show(getTitleBarHeight());
          }
        }
        while (paramInt6 != 7)
        {
          return paramInt1;
          paramInt1 = eI(paramInt5);
          break label170;
          if (!Pi()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.start();
          }
          paramInt1 = paramInt5;
          break label170;
          if (paramInt4 == 0)
          {
            this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt5 - 1, 0);
            this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
            paramInt1 = paramInt5;
            break label170;
          }
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
          paramInt1 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
          break label170;
          bHx();
          paramInt1 = paramInt3;
          break label170;
          paramList1 = this.jdField_a_of_type_Wki.getList();
          if ((paramList1.size() <= 0) || (this.Fv < 0L)) {
            break label653;
          }
          paramInt1 = a(paramList1, this.Fv);
          if (paramInt1 >= 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.start(paramInt1, 1);
            this.Fv = -1L;
          }
          paramInt1 = paramInt3;
          break label170;
          BaseChatpieHelper.a(this.TAG, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, 0, paramList1, paramList2);
          paramInt1 = this.bEg + paramInt5 - paramInt4;
          break label170;
          if (((ChatMessage)paramList2.get(paramInt1)).uniseq == l) {
            break label148;
          }
          paramInt1 -= 1;
          break;
          if ((paramInt5 <= 0) || (ahwb.aB((MessageRecord)paramList2.get(paramInt5 - 1)))) {
            break label653;
          }
          paramInt1 = paramInt5;
          break label170;
          QQToast.a(this.app.getApp(), 1, this.mContext.getString(2131700006), 3000).show(getTitleBarHeight());
          return paramInt1;
        }
        paramInt3 = this.bEg;
        paramInt2 = this.jdField_a_of_type_Wki.getCount();
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          paramList1 = (ChatMessage)this.jdField_a_of_type_Wki.getItem(paramInt1);
          if ((paramList1 == null) || (paramList1.msgtype != -4009)) {}
        }
        for (;;)
        {
          paramList1 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
          if (paramInt1 == 0) {}
          for (paramInt2 = 0;; paramInt2 = -1)
          {
            paramList1.a(paramInt1, paramInt2, null, 8);
            return paramInt5 - (paramInt4 - paramInt3);
            paramInt1 += 1;
            break;
          }
          paramInt1 = 0;
        }
        label653:
        paramInt1 = paramInt3;
      }
      label659:
      paramInt1 = -1;
    }
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    int i = paramInt3;
    if (paramInt4 > 0)
    {
      i = paramInt3;
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt2 >= 0)
      {
        paramInt4 = -1;
        paramInt3 = paramInt4;
        if (paramInt5 <= 0) {
          break label455;
        }
        if (paramInt2 < paramList1.size()) {
          break label469;
        }
        paramInt2 = paramList1.size() - 1;
      }
    }
    label177:
    label455:
    label469:
    for (;;)
    {
      if (paramInt2 < 0) {}
      for (i = paramInt2 + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();; i = paramInt2)
      {
        long l = ((ChatMessage)paramList1.get(i)).uniseq;
        paramInt3 = 0;
        paramInt2 = paramInt4;
        if (paramInt3 < paramInt5)
        {
          if (((ChatMessage)paramList2.get(paramInt3)).uniseq == l) {
            paramInt2 = paramInt3;
          }
        }
        else
        {
          paramInt3 = paramInt2;
          if (paramInt2 >= 0) {
            break label455;
          }
          paramInt3 = paramInt2;
          if (paramList1.size() <= i + 1) {
            break label455;
          }
          l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
          paramInt4 = 0;
          paramInt3 = paramInt2;
          if (paramInt4 >= paramInt5) {
            break label455;
          }
          if (((ChatMessage)paramList2.get(paramInt4)).uniseq != l) {
            break label272;
          }
          paramBoolean = true;
        }
        for (;;)
        {
          if (paramInt4 >= 0)
          {
            paramInt3 = this.bEg + paramInt4;
            paramInt2 = paramInt3;
            if (paramBoolean) {
              paramInt2 = paramInt3 - 1;
            }
            if ((paramInt1 < 0) && (paramInt4 == 0))
            {
              this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
              i = paramInt2;
              return i;
              paramInt3 += 1;
              break;
              paramInt4 += 1;
              break label177;
            }
            if (paramInt1 < 0)
            {
              paramInt3 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
              try
              {
                paramInt5 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
                paramInt3 -= paramInt5;
              }
              catch (NullPointerException paramList1)
              {
                for (;;)
                {
                  paramInt3 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
                }
              }
              this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
              this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(paramInt4 + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), paramInt3 + paramInt1 - this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
              return paramInt2;
            }
            paramInt1 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            try
            {
              paramInt3 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
              paramInt1 -= paramInt3;
            }
            catch (NullPointerException paramList1)
            {
              for (;;)
              {
                paramInt1 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
              }
            }
            this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(paramInt4 + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), paramInt1 - this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
            return paramInt2;
          }
          this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
          return paramInt5;
          paramInt4 = paramInt3;
        }
      }
    }
  }
  
  @Nullable
  private CharSequence a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    Object localObject;
    if ((1000 != this.sessionInfo.cZ) && (1004 != this.sessionInfo.cZ))
    {
      localObject = paramCharSequence;
      if (this.sessionInfo.cZ != 10008) {}
    }
    else
    {
      CharSequence localCharSequence = paramCharSequence;
      if (paramList.size() >= 15)
      {
        localCharSequence = paramCharSequence;
        if (!((ChatMessage)paramList.get(0)).mNeedGrayTips) {
          localCharSequence = null;
        }
      }
      localObject = localCharSequence;
      if (!paramList.isEmpty())
      {
        localObject = localCharSequence;
        if (((ChatMessage)paramList.get(0)).mMessageSource == null)
        {
          localObject = localCharSequence;
          if (((ChatMessage)paramList.get(0)).mNeedGrayTips)
          {
            localObject = localCharSequence;
            if (localCharSequence == null)
            {
              ((ChatMessage)paramList.get(0)).mNeedGrayTips = false;
              localObject = localCharSequence;
            }
          }
        }
      }
    }
    paramList = (List<ChatMessage>)localObject;
    if (1001 == this.sessionInfo.cZ) {
      if (!ajpc.bl.contains(this.sessionInfo.aTl))
      {
        paramList = (List<ChatMessage>)localObject;
        if (!ajpc.e(this.app, this.sessionInfo.aTl)) {}
      }
      else
      {
        paramList = null;
      }
    }
    paramCharSequence = paramList;
    if (10002 == this.sessionInfo.cZ)
    {
      paramCharSequence = paramList;
      if (ajpc.e(this.app, this.sessionInfo.aTl)) {
        paramCharSequence = null;
      }
    }
    if (top.eD(this.sessionInfo.cZ) == 1032) {
      paramCharSequence = null;
    }
    if (this.sessionInfo.cZ == 10008) {
      return null;
    }
    return paramCharSequence;
  }
  
  @NotNull
  private String a(wvd paramwvd, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, ujt.d paramd)
  {
    if (paramd.mSourceMsgInfo != null)
    {
      paramd.mSourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramd.mSourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramd.mSourceMsgInfo.packSourceMsg(this.app, paramMessageRecord);
      }
    }
    Object localObject1 = new ArrayList();
    String str1 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    wg(true);
    Object localObject2 = new ArrayList();
    String str2 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
    boolean bool = OS();
    if ((this.aSM) || (bool)) {
      if (bool) {
        alvn.a().a(this.app, this.sessionInfo, str1, (ArrayList)localObject1, paramd, paramMessageRecord, str2, (ArrayList)localObject2);
      }
    }
    do
    {
      return str1;
      a(str1, paramd, (ArrayList)localObject1);
      return str1;
      if ((!paramwvd.isEmpty()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.aqq()))
      {
        ((ajcy)this.app.getManager(174)).a(this.app, this, (ArrayList)localObject1, paramMixedMsgInfo);
        paramwvd.bIN();
        return str1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.hT(str1)))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(true, this)) {
          a(str1, paramd, (ArrayList)localObject1);
        }
        ((wwg)this.jdField_a_of_type_Wvm.a(7)).CT(hashCode());
        return str1;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374485) == null) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374485) == null);
    paramMessageRecord = (MessageForTroopGift)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374485);
    paramd.mWantGiftSenderUin = paramMessageRecord.senderUin;
    paramwvd = acfp.m(2131703092);
    paramMixedMsgInfo = aqmj.Z(this.mContext, "wantWord");
    if (!TextUtils.isEmpty(paramMixedMsgInfo)) {
      paramwvd = paramMixedMsgInfo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramwvd);
      paramwvd = aqgv.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl, paramMessageRecord.senderUin + "");
      paramMixedMsgInfo = this.app;
      localObject1 = this.mContext;
      str1 = this.sessionInfo.aTl;
      paramMessageRecord = paramMessageRecord.senderUin + "";
      localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (this.sessionInfo.cZ == 1) {}
      for (bool = true;; bool = false)
      {
        paramwvd = appb.a(paramMixedMsgInfo, (Context)localObject1, str1, paramMessageRecord, paramwvd, false, (EditText)localObject2, bool);
        if ((paramwvd != null) && (paramwvd.length() != 0)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, paramwvd);
        }
        paramwvd = new ArrayList();
        paramMixedMsgInfo = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramwvd);
        a(paramMixedMsgInfo, paramd, paramwvd);
        return paramMixedMsgInfo;
      }
      a(str1, paramd, (ArrayList)localObject1);
      if ((paramInt1 + paramInt2 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false, null);
      ((wwg)this.jdField_a_of_type_Wvm.a(7)).CT(hashCode());
      return str1;
    }
  }
  
  private ygg a(View paramView)
  {
    if (this.jdField_a_of_type_Ygg == null)
    {
      ygh localygh = new ygh(this.mContext, this);
      this.jdField_a_of_type_Ygg = new ygg(localygh, paramView, xks.A(this.app));
      localygh.a(this.jdField_a_of_type_Ygg);
    }
    return this.jdField_a_of_type_Ygg;
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, int paramInt3)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    case 4: 
    default: 
    case 18: 
    case 0: 
    case 1: 
    case 17000: 
    case 10: 
    case 3: 
    case 20: 
    case 21: 
    case 2000: 
    case 5: 
    case 100017: 
    case 11: 
    case 9009: 
    case 85: 
      do
      {
        return;
        by(paramIntent);
        return;
        aG(false, false);
        return;
        anfe.a(this.app, this.mActivity, paramIntent, this.sessionInfo, paramInt3, paramInt1);
        return;
        ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo, paramInt1, paramIntent, 10);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bG(paramIntent);
        return;
        aG(true, false);
        this.mActivity.getWindow().clearFlags(1024);
        return;
        paramIntent.putExtra("selfSet_leftViewText", this.app.getApplication().getString(2131720735));
        bm(paramIntent.getExtras());
        return;
        bx(paramIntent);
        return;
        zO(paramInt2);
        return;
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("input_full_screen_mode_result");
        if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
        for (;;)
        {
          ((wvd)this.jdField_a_of_type_Wvm.a(24)).Z(localArrayList, bool);
          return;
          bool = false;
        }
        bw(paramIntent);
        return;
        bv(paramIntent);
        return;
      } while (paramIntent == null);
      ujt.a(this.app, this.mContext, this.sessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(avkw.cLz), null);
      return;
    case 9010: 
      anjo.a(paramIntent, a());
      return;
    case 9011: 
      bE(paramIntent);
      return;
    case 102: 
      a(false, null, false);
      return;
    }
    QQToast.a(this.mContext, 2, 2131695108, 1).show();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 2) {
      this.mActivity.setCanLock(false);
    }
    for (;;)
    {
      k(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 == 4001)
      {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.app.getCurrentAccountUin(), paramIntent);
      }
      else if ((paramInt1 == 103) && (!paramBoolean))
      {
        aG(false, true);
      }
      else if ((paramInt1 == 101) && (paramInt2 != -1))
      {
        aG(false, false);
      }
      else if ((paramInt1 == 4779) && (paramInt2 == 8213))
      {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.ME(17);
      }
      else if ((paramInt1 == 4813) && (paramInt2 == 8213))
      {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.ME(18);
      }
      else if (paramInt1 == 13007)
      {
        bB(paramIntent);
      }
      else if (paramInt1 == 11000)
      {
        l(paramInt1, paramInt2, paramIntent);
      }
      else if (paramInt1 == 13002)
      {
        bA(paramIntent);
      }
      else if (paramInt1 == 13006)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
        }
        bIH();
      }
      else if (paramInt1 == 100012)
      {
        if ((paramIntent != null) && (paramIntent.getIntExtra("camera_type", -1) == 103)) {
          bID();
        }
      }
      else if (paramInt1 == 14001)
      {
        bz(paramIntent);
      }
      else if (paramInt1 == 12007)
      {
        bHz();
      }
      else if (paramInt1 == 12008)
      {
        w(paramInt2, paramIntent);
      }
      else if (paramInt1 == 18000)
      {
        ((wvy)a(11)).o(paramInt2, paramIntent);
      }
      else if (paramInt2 == -1)
      {
        a(paramInt1, paramInt2, paramIntent, paramInt3);
      }
      else
      {
        zN(paramInt1);
      }
    }
  }
  
  private void a(acff paramacff)
  {
    ExtensionInfo localExtensionInfo = paramacff.a(this.sessionInfo.aTl, false);
    if ((localExtensionInfo == null) && (!paramacff.aaf())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.78(this, paramacff));
    }
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localExtensionInfo.audioPanelType, false);
    }
  }
  
  private void a(acff paramacff, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramacff.a(this.sessionInfo.aTl, false);
    paramacff = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramacff = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (paramacff.chatInputType != paramInt1)
      {
        paramacff.chatInputType = paramInt1;
        paramacff.isDataChanged = true;
      }
      if (paramacff.showC2CPanel != paramInt2)
      {
        paramacff.showC2CPanel = paramInt2;
        paramacff.isDataChanged = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
    }
  }
  
  private void a(acff paramacff, boolean paramBoolean1, boolean paramBoolean2)
  {
    ExtensionInfo localExtensionInfo = paramacff.a(this.sessionInfo.aTl, false);
    paramacff = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
        paramacff = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showAudioPanelIfNeedForC2C extInfo.chatInputType = " + paramacff.chatInputType + " extInfo.showC2CPanel = " + paramacff.showC2CPanel);
      }
      if (paramacff.chatInputType == 2) {
        break label111;
      }
    }
    label111:
    while (paramacff.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "showAudioPanelIfNeed | ExtensionInfo = null");
      return;
    }
    aI(paramBoolean1, paramBoolean2);
  }
  
  private void a(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    wjw localwjw;
    if (mc())
    {
      ((wun)this.jdField_a_of_type_Wvm.a(65)).J(paramMessageRecord);
      if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForPoke)) && (!paramMessageRecord.isSend()))
      {
        this.app.a().nc.put(Long.valueOf(paramMessageRecord.uniseq), (MessageForPoke)paramMessageRecord);
        ((MessageForPoke)paramMessageRecord).isPlayed = false;
      }
      if ((!paramMessageRecord.isread) && (!paramMessageRecord.isSend()) && ((paramMessageRecord instanceof MessageForArkFlashChat)) && (!isFullScreenMode())) {
        ((FlashChatManager)this.app.getManager(217)).a((MessageForArkFlashChat)paramMessageRecord);
      }
      aIH();
      if (this.sessionInfo.cZ == 1) {
        ajpd.ar(this.app, this.sessionInfo.aTl);
      }
      this.aSo = true;
      this.aex = true;
      if ((!paramMessageRecord.isSend()) && (paramMessageRecord.msgtype == -2039) && (!abhh.sI.contains(Long.valueOf(paramMessageRecord.uniseq)))) {
        abhh.sI.add(Long.valueOf(paramMessageRecord.uniseq));
      }
      localwjw = (wjw)this.app.getManager(218);
      if (paramMessageRecord.isSend()) {
        break label322;
      }
      localwjw.G(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((aocq)this.app.getManager(272)).Z(paramChatMessage);
      }
      if ((!(this instanceof ycd)) || (!((ycd)this).ob) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() != this.jdField_a_of_type_Wki.getCount() - 1)) {
        break label331;
      }
      this.uiHandler.postDelayed(new BaseChatPie.32(this), 800L);
    }
    for (;;)
    {
      this.aSt = true;
      return;
      label322:
      localwjw.a(this, paramMessageRecord);
      break;
      label331:
      paramChatMessage.mMsgAnimFlag = true;
      refresh(196608);
    }
  }
  
  private void a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype != -2006) || (!(paramObject instanceof MessageForFoldMsg)))
    {
      paramObject = this.app.b().a();
      if (MessageForPtt.class.isInstance(paramMessageRecord)) {
        paramObject.msg = ((MessageForPtt)paramMessageRecord).getSummaryMsg();
      }
      a(paramObject);
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    d(2, paramString, paramLong);
    if (paramRecorderParam.mUserData == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      anqo.cU(paramString, true);
      anqo.Rl(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramRecorderParam.dZN);
      anqo.a(paramString, this.app, this.sessionInfo.aTl, paramLong, true, 0, paramRecorderParam.mAudioType, paramRecorderParam.dZM, localBundle);
      return;
    }
    alid.Of(paramString);
  }
  
  private void a(String paramString, ujt.d paramd, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    if (this.aSM)
    {
      alte.a().a(this.app, this.sessionInfo, paramString, paramArrayList, paramd);
      bIR();
      return;
    }
    ujt.a(this.app, this.mContext, this.sessionInfo, paramString, paramArrayList, paramd);
  }
  
  private void a(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ReportWorker(paramString, paramBoolean, paramEmoticonMainPanel, paramQQAppInterface, getCurType()), 2, null, false);
  }
  
  private void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject;
    String str;
    StringBuilder localStringBuilder;
    boolean bool;
    if (this.aSc)
    {
      if ((1000 != this.sessionInfo.cZ) || (paramMessageRecord != null) || (paramList.size() != 0)) {
        break label215;
      }
      localObject = ChatActivityUtils.a(this.mContext, this.app, this.sessionInfo.aTm);
      if (QLog.isColorLevel())
      {
        str = this.TAG;
        localStringBuilder = new StringBuilder().append("sessionInfo.curType = ").append(this.sessionInfo.cZ).append(", mr = null ? ");
        if (paramMessageRecord != null) {
          break label405;
        }
        bool = true;
        label103:
        localStringBuilder = localStringBuilder.append(bool).append("，mr.type = ");
        if (paramMessageRecord != null) {
          break label411;
        }
      }
    }
    label405:
    label411:
    for (paramMessageRecord = "null";; paramMessageRecord = Integer.valueOf(paramMessageRecord.istroop))
    {
      QLog.d(str, 2, paramMessageRecord + ", newList.size() = " + paramList.size());
      if (localObject == null) {
        break label422;
      }
      vU(true);
      this.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.cJ.setOnClickListener(null);
      this.cK.setOnClickListener(null);
      vc((String)localObject);
      if (aTl) {
        this.Cu.setContentDescription((CharSequence)localObject);
      }
      return;
      label215:
      if ((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 1025))
      {
        localObject = ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo.aTl);
        break;
      }
      if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
      {
        localObject = this.mContext;
        if (this.sessionInfo.cZ == 1001) {}
        for (int i = 2131700709;; i = 2131696065)
        {
          localObject = ((Context)localObject).getString(i);
          break;
        }
      }
      if (this.sessionInfo.cZ == 10004)
      {
        localObject = this.mContext.getString(2131700710);
        break;
      }
      if ((this.sessionInfo.cZ == 10008) && (paramMessageRecord == null))
      {
        localObject = this.mContext.getString(2131700714);
        break;
      }
      localObject = ChatActivityUtils.a(this.mContext, paramMessageRecord, this.app);
      break;
      bool = false;
      break label103;
    }
    label422:
    vU(false);
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      abgw.a().gO(paramLong);
      return;
    }
    abgw.a().ar(paramLong, paramInt2);
    this.mActivity.runOnUiThread(new BaseChatPie.69(this, paramLong));
  }
  
  private boolean a(acff paramacff)
  {
    ExtensionInfo localExtensionInfo2 = paramacff.a(this.sessionInfo.aTl, false);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null) {
      if (paramacff.aaf()) {}
    }
    label26:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = this.sessionInfo.aTl;
      localExtensionInfo1.timestamp = System.currentTimeMillis();
      if (top.fv(this.sessionInfo.cZ)) {}
      for (localExtensionInfo1.chatInputType = 0;; localExtensionInfo1.chatInputType = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localExtensionInfo1;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doChooseC2CInputType extInfo.chatInputType = " + localExtensionInfo1.chatInputType);
        }
        if (wir.bcz) {
          break;
        }
        switch (localExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label26;
          }
          QLog.d(this.TAG, 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
          return false;
        }
      }
    } while ((this.mActivity == null) || (this.mActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.bEm = 2;
    return false;
  }
  
  private boolean a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sendback", 2, "update mr.isBlessMsg" + paramMessageRecord.isBlessMsg);
    }
    if ((paramMessageRecord.msgtype == -1004) && (!this.sessionInfo.aTl.equals(paramMessageRecord.frienduin))) {
      return true;
    }
    if (z(paramMessageRecord)) {
      a((ChatMessage)paramObject, paramMessageRecord);
    }
    for (;;)
    {
      aQ();
      if (((paramObject instanceof MessageForStructing)) || ((paramObject instanceof MessageForText))) {
        wja.a(this.app, this, this.jdField_a_of_type_Wki, (ChatMessage)paramObject);
      }
      return false;
      if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (this.sessionInfo.aTl.equals(paramMessageRecord.senderuin)) && (top.fv(this.sessionInfo.cZ))) {
        b((ChatMessage)paramObject, paramMessageRecord);
      } else if ((mc()) && (!paramMessageRecord.isread)) {
        a(paramObject, paramMessageRecord);
      }
    }
  }
  
  private void aI(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (OZ()))
      {
        wa(false);
        this.aSW = false;
      }
      if (DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.aio_input.name())) {
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (this.aSW)) && (OZ()))
        {
          wa(false);
          this.aSW = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "initAudioPanelFlag needShowAudioWhenResume  = " + this.aSW);
      }
      return;
      this.aSW = true;
      continue;
      if ((this.aSW) && (OZ()))
      {
        wa(true);
        this.aSW = false;
      }
    }
  }
  
  private void aJ()
  {
    this.jdField_b_of_type_AndroidViewView$OnLayoutChangeListener = new uil(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addOnLayoutChangeListener(this.jdField_b_of_type_AndroidViewView$OnLayoutChangeListener);
    if (this.aey) {
      zL(wja.dp2px(1.0F, this.mActivity.getResources()));
    }
    for (;;)
    {
      if (this.rC.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), wja.dp2px(11.0F, this.mActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      }
      return;
      ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this), true);
    }
  }
  
  private void aQ(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.sessionInfo.cZ != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while ((this.sessionInfo.cZ == 1034) || (((this.sessionInfo.cZ != 1006) || (!paramString.equals(this.sessionInfo.aTo))) && (!paramString.equals(this.sessionInfo.aTl))));
    String str = null;
    if ((this.sessionInfo.cZ == 1006) && (paramString.equals(this.sessionInfo.aTo))) {
      str = aqgv.A(this.app, paramString);
    }
    for (;;)
    {
      this.sessionInfo.aTn = str;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onUpdateFriendInfo title" + aqft.pk(str));
      }
      this.mTitleText.setText(this.sessionInfo.aTn);
      if (!AppSetting.enableTalkBack) {
        break;
      }
      paramString = this.mTitleText.getText().toString();
      this.mTitleText.setContentDescription(paramString);
      a().setTitle(this.mTitleText.getText());
      return;
      if (this.sessionInfo.cZ == 1024) {
        str = jqs.getNickName(this.app, paramString);
      } else if (paramString.equals(this.sessionInfo.aTl)) {
        str = aqgv.D(this.app, paramString);
      }
    }
  }
  
  private boolean ag(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (BaseChatItemLayout.bdx)
    {
      if (!this.aSN)
      {
        a(false, null, false);
        bool = true;
      }
    }
    else {
      return bool;
    }
    ajlc.a().djF = 0;
    return paramBoolean;
  }
  
  private void aj(Message paramMessage)
  {
    switch (paramMessage.what)
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
              do
              {
                return;
                vg((String)paramMessage.obj);
                return;
              } while (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
              this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.dak();
              return;
            } while (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
            this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.dap();
            return;
          } while (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.dam();
          return;
        } while (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null);
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.dao();
        return;
        bGX();
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.getVisibility() != 0));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
      this.uiHandler.removeMessages(67);
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(true);
      }
      bIe();
      return;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof String)) {
          localObject1 = (String)paramMessage.obj;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.show((String)localObject1);
      }
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(false);
      }
      if (this.jdField_a_of_type_Afdw != null) {
        this.jdField_a_of_type_Afdw.cYA();
      }
      bIf();
      EmojiStickerManager.a().v(this);
      this.uiHandler.removeMessages(67);
      this.uiHandler.sendEmptyMessageDelayed(67, 6000L);
      ((wxa)a(14)).ccR();
      return;
      bIZ();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramMessage.arg1 != 1));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
  }
  
  private void ak(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      anot.a(this.app, "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
      }
      if (this.jdField_a_of_type_Afdw == null) {
        this.jdField_a_of_type_Afdw = ((afdw)this.app.getManager(214));
      }
      this.jdField_a_of_type_Afdw.a(this.mContext, this.fs, this.mActivity, this.sessionInfo, this.uiHandler, (afdv)paramMessage.obj);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
        this.uiHandler.removeMessages(67);
      }
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(false);
      }
      bIf();
      return;
      if (this.jdField_a_of_type_Afdw != null) {
        this.jdField_a_of_type_Afdw.cYA();
      }
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(true);
      }
      bIe();
      return;
    } while ((this.jdField_a_of_type_Afdw == null) || (this.jdField_a_of_type_Afdw.b == null));
    this.jdField_a_of_type_Afdw.b.notifyDataSetChanged();
  }
  
  private void al(Message paramMessage)
  {
    if (this.cL == null) {
      paramMessage = "1";
    }
    for (;;)
    {
      vb(paramMessage);
      return;
      if (paramMessage.obj == null)
      {
        paramMessage = "2";
      }
      else
      {
        if ((paramMessage.obj instanceof Drawable)) {
          break;
        }
        paramMessage = "3, msg.obj=" + paramMessage.obj;
      }
    }
    if ((this.sessionInfo.beq) && (this.sessionInfo.bes) && (!this.sessionInfo.isNightMode))
    {
      this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
      this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      bIi();
      paramMessage = null;
      break;
      if ((this.sessionInfo.ber) && (this.sessionInfo.bet) && (!this.sessionInfo.isNightMode))
      {
        this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
      else if ((this.sessionInfo.cZ == 1033) || (this.sessionInfo.cZ == 1034))
      {
        this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
      else if (this.sessionInfo.cZ == 10007)
      {
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null))
        {
          this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
          this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
        }
      }
      else
      {
        this.cL.setBackgroundDrawable((Drawable)paramMessage.obj);
        if (aogk.a().azB()) {
          aogk.a().q(this.cL.getContext(), this.cL);
        }
        ((wwl)this.jdField_a_of_type_Wvm.a(17)).d(this.mContext, this.app, this.sessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND sessionInfo:  isQimUserOnline = " + this.sessionInfo.beq + "  isQimUserTitleForm = " + this.sessionInfo.bes + "  isTimUserOnline = " + this.sessionInfo.ber + " isTimUserTitleForm = " + this.sessionInfo.bet + "  isNightMode = " + this.sessionInfo.isNightMode + "  curType = " + this.sessionInfo.cZ);
        }
      }
    }
  }
  
  private void am(Message paramMessage)
  {
    Object localObject = (Map)paramMessage.obj;
    int i = this.jdField_a_of_type_Wki.b((ChatMessage)((Map)localObject).get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "updateZanInfo pos is:" + i);
    }
    if (i < 0) {}
    do
    {
      do
      {
        do
        {
          int j;
          int k;
          int m;
          int n;
          do
          {
            return;
            j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
            k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
            m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
            n = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          } while ((i < j - k) || (i > m - n));
          paramMessage = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        } while ((paramMessage == null) || (!(paramMessage instanceof LinearLayout)));
        localObject = (RichStatus.a)((Map)localObject).get("sigZanInfo");
      } while (!(wja.a(paramMessage) instanceof xmj.a));
      paramMessage = (xmj.a)wja.a(paramMessage);
    } while ((((RichStatus.a)localObject).feedid == null) || (!((RichStatus.a)localObject).feedid.equals(paramMessage.a.feedsId)));
    paramMessage.a.count = ((RichStatus.a)localObject).count;
    paramMessage.a.zanFlag = ((RichStatus.a)localObject).zanFlag;
    paramMessage.a.dNE();
  }
  
  private void an(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 40: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
      do
      {
        return;
        Ah(paramMessage.arg1);
        return;
        bHI();
        return;
        zV(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
        }
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.stop();
        bIK();
      } while (this.Fq != 0L);
      zX(2131230757);
      return;
    }
    d(0, null, -1L);
  }
  
  private void asY()
  {
    if (this.jdField_a_of_type_Arhz != null)
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz = null;
    }
    if ((this.C != null) && (this.C.isShowing()))
    {
      this.C.dismiss();
      this.C = null;
    }
    if ((this.x != null) && (this.x.isShowing()))
    {
      this.x.dismiss();
      this.x = null;
    }
    if ((this.jdField_B_of_type_Aqju != null) && (this.jdField_B_of_type_Aqju.isShowing())) {
      this.jdField_B_of_type_Aqju.dismiss();
    }
  }
  
  private void at(Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      localMessageRecord = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "update mr.msgseq" + localMessageRecord.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + localMessageRecord.extraflag);
      }
      D(localMessageRecord);
      if (b(paramObject, localMessageRecord)) {}
      do
      {
        return;
        if (localMessageRecord.isSendFromLocal()) {
          break;
        }
      } while (a(paramObject, localMessageRecord));
      for (;;)
      {
        anod.T(0, 0, ((MessageRecord)paramObject).istroop, 1);
        return;
        b(paramObject, localMessageRecord);
      }
    }
    MessageRecord localMessageRecord = (MessageRecord)paramObject;
    if (((paramObject instanceof DataLineMsgRecord)) && (!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal())) {
      a(this.app.b().a());
    }
    aQ();
  }
  
  private void au(Object paramObject)
  {
    paramObject = (QQMessageFacade.b)paramObject;
    Object localObject = (wkk)paramObject.context;
    if (!TextUtils.equals(this.sessionInfo.aTl, ((wkk)localObject).pf())) {}
    do
    {
      return;
      if ((this.sessionInfo.cZ == paramObject.uinType) && (this.Fp != ((wkk)localObject).em()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "refreshMessageContext sync other MiniAIO");
        }
        refresh(131073);
        return;
      }
    } while ((this.Fp != ((wkk)localObject).em()) || (!paramObject.aQh) || (!aegu.e(paramObject.uinType, paramObject.topicId, this.sessionInfo.cZ, this.sessionInfo.topicId)));
    localObject = paramObject.pX;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.bEi += 1;
    }
    boolean bool;
    long l;
    if (!paramObject.isComplete)
    {
      bool = true;
      this.aSm = bool;
      l = this.Fp + 300L - SystemClock.uptimeMillis();
      if (l <= 0L) {
        break label221;
      }
    }
    for (;;)
    {
      this.uiHandler.postDelayed(new BaseChatPie.33(this, paramObject), l);
      return;
      bool = false;
      break;
      label221:
      l = 0L;
    }
  }
  
  private void av(Object paramObject)
  {
    paramObject = (QQMessageFacade.a)paramObject;
    if ((paramObject.uin.equals(this.sessionInfo.aTl)) && (paramObject.operation == 0)) {
      aG(false, true);
    }
  }
  
  private void aw(Object paramObject)
  {
    if (this.mScrollState != 0) {}
    while ((xmj.Jd == 0L) || (!(paramObject instanceof RichStatus.a))) {
      return;
    }
    ThreadManager.post(new BaseChatPie.68(this, (RichStatus.a)paramObject), 5, null, false);
  }
  
  private MessageRecord b(List<ChatMessage> paramList)
  {
    if ((1000 == this.sessionInfo.cZ) || (1004 == this.sessionInfo.cZ) || (1022 == this.sessionInfo.cZ)) {
      return ChatActivityUtils.b(paramList, this.sessionInfo, this.app);
    }
    return ChatActivityUtils.a(paramList, this.sessionInfo, this.app);
  }
  
  @NotNull
  private String b(wvd paramwvd, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, ujt.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
    }
    if (paramd.mSourceMsgInfo != null)
    {
      paramd.mSourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramd.mSourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramd.mSourceMsgInfo.packSourceMsg(this.app, paramMessageRecord);
      }
    }
    ArrayList localArrayList = new ArrayList();
    String str = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    boolean bool = OS();
    if ((this.aSM) || (bool)) {
      if (bool) {
        alvn.a().a(this.app, this.sessionInfo, str, localArrayList, paramd, paramMessageRecord, null, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
      return str;
      a(str, paramd, localArrayList);
      continue;
      if ((!paramwvd.isEmpty()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.aqq()))
      {
        ((ajcy)this.app.getManager(174)).a(this.app, this, localArrayList, paramMixedMsgInfo);
        paramwvd.bIN();
      }
      else if ((this.sessionInfo.cZ == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.hT(str)))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(true, this)) {
          a(str, paramd, localArrayList);
        }
        ((wwg)this.jdField_a_of_type_Wvm.a(7)).CT(hashCode());
      }
      else
      {
        a(str, paramd, null);
        if ((paramInt1 + paramInt2 > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false, null);
          ((wwg)this.jdField_a_of_type_Wvm.a(7)).CT(hashCode());
        }
      }
    }
  }
  
  private void b(acff paramacff)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramacff.a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
    if ((localNoC2CExtensionInfo == null) && (!paramacff.aaf())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.79(this, paramacff));
    }
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localNoC2CExtensionInfo.audioPanelType, false);
    }
  }
  
  private void b(acff paramacff, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramacff.a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (localNoC2CExtensionInfo1.chatInputType != paramInt1)
      {
        localNoC2CExtensionInfo1.chatInputType = paramInt1;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      if (localNoC2CExtensionInfo1.showC2CPanel != paramInt2)
      {
        localNoC2CExtensionInfo1.showC2CPanel = paramInt2;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      paramacff.a(localNoC2CExtensionInfo1, false);
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = null;
    }
  }
  
  private void b(acff paramacff, boolean paramBoolean1, boolean paramBoolean2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramacff.a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
    paramacff = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null) {
        paramacff = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = " + paramacff.chatInputType + " noC2CExtInfo.showC2CPanel = " + paramacff.showC2CPanel);
      }
      if (paramacff.chatInputType == 2) {
        break label118;
      }
    }
    label118:
    while (paramacff.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
      return;
    }
    aI(paramBoolean1, paramBoolean2);
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = aqjf.b(paramBoolean1, paramBoolean2, paramBoolean3);
    if (i > 0) {
      QQToast.a(paramContext, i, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  private void b(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_forwardType intent type" + paramIntent.getIntExtra("uintype", -1) + "needToBottom=" + paramBoolean);
    }
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().containsKey("forward_type")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("forward", 2, "updateSession_forwardType from forward");
      }
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((apsw)this.app.getManager(48)).a(paramIntent.getStringExtra("uin"), true).cSk)) {
        QQToast.a(this.app.getApp(), 2131699615, 0).show(getTitleBarHeight());
      }
    }
    else
    {
      return;
    }
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    this.T = Boolean.valueOf(true);
    if (i == 0) {
      this.aL = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 1, "updateSession_forwardType, postDelayed!");
      }
      this.uiHandler.postDelayed(new BaseChatPie.11(this, paramBoolean, paramIntent, paramIntent), 500L);
      a(false, null, false);
      return;
      if ((i == 1001) || (i == -4)) {
        ForwardUtils.a(this.app, this.mContext, this.sessionInfo, paramIntent);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if ((String.valueOf(acbn.bkD).equalsIgnoreCase(paramMessageRecord.frienduin)) && (!paramMessageRecord.isread))
    {
      a(this.app.b().a());
      return;
    }
    if (mc())
    {
      this.aex = true;
      aIH();
      paramChatMessage.mMsgAnimFlag = true;
      refresh(196608);
    }
    this.aSt = true;
  }
  
  private void b(MessageForText paramMessageForText)
  {
    if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 0))
    {
      anot.a(this.app, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
      if ((paramMessageForText.atInfoList == null) || (paramMessageForText.atInfoList.size() != 1)) {
        break label125;
      }
      if (!((MessageForText.AtTroopMemberInfo)paramMessageForText.atInfoList.get(0)).isIncludingAll()) {
        anot.a(this.app, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      label125:
      if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 1))
      {
        paramMessageForText = paramMessageForText.atInfoList.iterator();
        do
        {
          if (!paramMessageForText.hasNext()) {
            break;
          }
        } while (!((MessageForText.AtTroopMemberInfo)paramMessageForText.next()).isIncludingAll());
        for (int i = 1; i == 0; i = 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
          return;
        }
      }
    }
  }
  
  private void b(Object paramObject, MessageRecord paramMessageRecord)
  {
    aIH();
    if (this.sessionInfo.cZ == 1) {
      ajpd.ar(this.app, this.sessionInfo.aTl);
    }
    this.aSo = true;
    this.aSt = true;
    c(paramObject, paramMessageRecord);
    if (((paramMessageRecord instanceof MessageForStructing)) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 0))) {
      if ("viewMultiMsg".equals(((MessageForStructing)paramMessageRecord).structingMsg.mMsgAction)) {
        ajlc.a().a(this.app, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, true);
      }
    }
    do
    {
      return;
      if (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.istroop == 3000) && (paramMessageRecord.extraflag == 0))
      {
        b((MessageForText)paramMessageRecord);
        return;
      }
    } while (!(paramMessageRecord instanceof MessageForArkFlashChat));
    ((FlashChatManager)this.app.getManager(217)).a((MessageForArkFlashChat)paramMessageRecord);
  }
  
  private boolean b(acff paramacff)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramacff.a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (paramacff.aaf()) {}
    }
    label36:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localNoC2CExtensionInfo1 = new NoC2CExtensionInfo();
      localNoC2CExtensionInfo1.type = this.sessionInfo.cZ;
      localNoC2CExtensionInfo1.uin = this.sessionInfo.aTl;
      localNoC2CExtensionInfo1.chatInputType = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = localNoC2CExtensionInfo1;
      if (this.sessionInfo.cZ == 1) {}
      for (int i = 1;; i = 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doChooseNoC2CInputType noC2CExtInfo.chatInputType = " + localNoC2CExtensionInfo1.chatInputType + " noC2CType = " + i);
        }
        switch (localNoC2CExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localNoC2CExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label36;
          }
          QLog.d(this.TAG, 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
          return false;
        }
      }
    } while ((this.mActivity == null) || (this.mActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.bEm = 2;
    return false;
  }
  
  private boolean b(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (mc())
    {
      if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (this.sessionInfo.aTl.equals(paramMessageRecord.senderuin)) && (aegu.e(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.cZ, this.sessionInfo.topicId)))
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramMessageRecord;
        String str = localMessageForUniteGrayTip.tipParam.wording;
        localMessageForUniteGrayTip.hasRead = 1;
        localMessageForUniteGrayTip.updateUniteGrayTipMsgData(this.app);
        if (localMessageForUniteGrayTip.tipParam.dbK == 2097153) {
          ajoo.a(this.app, this.sessionInfo, localMessageForUniteGrayTip, this.uiHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, localMessageForUniteGrayTip.subType);
        }
      }
      wnf.a().a(this.app, this.sessionInfo, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (apqk.a(this, this.app, paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  private void bA(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
    }
    aG(false, false);
    try
    {
      paramIntent = paramIntent.getStringExtra("babyq_video_type");
      if (!TextUtils.isEmpty(paramIntent))
      {
        int i = Integer.parseInt(paramIntent);
        paramIntent = (acbs)this.app.getBusinessHandler(53);
        if (paramIntent != null) {
          paramIntent.ID(i);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.TAG, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void bB(Intent paramIntent)
  {
    try
    {
      int i = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
      paramIntent = (acbs)this.app.getBusinessHandler(53);
      if (paramIntent != null) {
        paramIntent.ID(i);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.TAG, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void bC(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getExtras();
    } while ((paramIntent == null) || (!this.aSs));
    int i = paramIntent.getInt("aio_msg_source", 999);
    if (QLog.isDevelopLevel()) {
      QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + i);
    }
    anot.a(this.app, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.cs(this.sessionInfo.cZ), String.valueOf(i), "", "");
  }
  
  private void bD(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (OY()) {
      break label11;
    }
    label11:
    while ((this.aSu) || (OX()) || (w(paramIntent))) {
      return;
    }
    boolean bool2;
    boolean bool1;
    if ((this.sessionInfo != null) && (!this.aSh))
    {
      paramIntent = (acff)this.app.getManager(51);
      if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
      {
        bool2 = b(paramIntent);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "chooseChatInputType doChooseNoC2CInputType needGuide = " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      aH(false, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l));
      return;
      if (OW())
      {
        bool2 = a(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.TAG, 2, "chooseChatInputType doChooseC2CInputType needGuide = " + bool2);
        bool1 = bool2;
        continue;
        if ((this.sessionInfo != null) && (this.aSh) && (QLog.isColorLevel())) {
          QLog.d(this.TAG, 2, "chooseC2CChatInputType isSimpleBar = " + this.aSh);
        }
      }
      bool1 = false;
    }
  }
  
  private void bGF()
  {
    boolean bool = false;
    if (OI())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iD(this.mAIORootView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YK(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YJ(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.ae(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
      QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130838200);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new uio(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new uiv(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  private void bGI() {}
  
  private void bGM()
  {
    boolean bool1 = false;
    boolean bool2 = ChatActivityUtils.e(this.app, this.sessionInfo);
    if (bool2) {
      anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    FragmentActivity localFragmentActivity = this.mActivity;
    SessionInfo localSessionInfo = this.sessionInfo;
    String str = this.app.getApp().getString(2131691039);
    if (this.mActivity.getIntent().getStringExtra("param_return_addr") != null) {
      bool1 = true;
    }
    ChatActivityUtils.a(localFragmentActivity, localSessionInfo, str, bool1, bool2);
  }
  
  private void bGN()
  {
    ausj localausj = (ausj)auss.a(a(), null);
    localausj.setMainTitle(this.app.getApplication().getResources().getString(2131720351));
    localausj.addButton(2131720349, 3);
    localausj.addButton(2131720348);
    localausj.addCancelButton(2131721058);
    localausj.a(new uic(this, localausj));
    localausj.show();
    anot.a(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
  
  private void bHG()
  {
    if (this.app != null)
    {
      if (!this.aSB)
      {
        if (!aqmr.isEmpty(this.sessionInfo.aTl))
        {
          ujt.a(this.app, this.sessionInfo);
          aIH();
          if (this.sessionInfo.cZ == 1) {
            ajpd.ar(this.app, this.sessionInfo.aTl);
          }
          QLog.d(this.TAG, 1, "setReaded() call");
        }
        this.aSB = true;
      }
      if (this.jdField_a_of_type_Wki.getCount() > 0)
      {
        Object localObject = (ChatMessage)this.jdField_a_of_type_Wki.getItem(this.jdField_a_of_type_Wki.getCount() - 1);
        if ((localObject != null) && (((ChatMessage)localObject).msgtype == -2039))
        {
          localObject = (MessageForApollo)localObject;
          if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
            ApolloUtil.a((MessageForApollo)localObject, this.app, this.sessionInfo.aTl, this.sessionInfo.cZ);
          }
        }
      }
    }
  }
  
  private void bHI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_Wki.notifyDataSetChanged();
  }
  
  private void bHL()
  {
    if ((!mc()) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout == null)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout = ((EmotionKeywordLayout)View.inflate(this.mContext, 2131558649, null));
        localObject = (wxa)a(14);
        boolean bool = ((wxa)localObject).Sg();
        if (!bool) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((wxa)localObject).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setTouchListener(new uin(this));
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
        if (!bool) {
          continue;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(this.TAG, 2, "EmotionPreviewLayout InflateException = " + localException);
        continue;
        localException.addRule(11);
        continue;
      }
      this.fs.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Ajdg = ((ajdg)this.app.getManager(14));
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.findViewById(2131366371));
      this.jdField_a_of_type_Afoc = new afoc(this.mContext, this.app, this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_Afoc);
    }
  }
  
  private void bHN()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onShow_videoStatus: mEnterExtPanel = " + this.bEm + ", mExtPanelOnResumeTimes = " + this.bEn);
    }
    if (this.bEm != 0)
    {
      int i = this.bEn - 1;
      this.bEn = i;
      if (i == 0)
      {
        if (this.bEm != 1) {
          break label103;
        }
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.52(this));
      }
    }
    for (;;)
    {
      this.bEm = 0;
      return;
      label103:
      if (this.bEm == 2) {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.53(this));
      }
    }
  }
  
  private void bHO()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = xkl.bTD;
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.ETTextView.enableAnimation = true;
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    jss.a().azk();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.resume();
    ((AvatarPendantManager)this.app.getManager(46)).eeO();
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    this.jdField_a_of_type_Yjh.h(1000, new Object[0]);
    bIj();
    if ((this.aSW) && (!this.aSu))
    {
      aH(true, false);
      this.aSW = false;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(this);
    if ((this.aM) && (this.aSv))
    {
      ahjz.a(this.mActivity, this.jdField_a_of_type_Wvm);
      this.aSv = false;
    }
    if ((this.aSn) && (this.aSw))
    {
      localObject = (ahhz)this.jdField_a_of_type_Wvm.a(37);
      if (localObject != null) {
        ((ahhz)localObject).c(this.mActivity.getIntent(), true);
      }
      this.aSw = false;
    }
    Object localObject = this.app.getPreferences();
    if (((SharedPreferences)localObject).getBoolean("sdcard_related_download_failed", false))
    {
      if (Environment.getExternalStorageState().equals("mounted")) {
        break label321;
      }
      QQToast.a(BaseApplication.getContext(), 2131696376, 0).show(getTitleBarHeight());
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sdcard_related_download_failed", false);
      ((SharedPreferences.Editor)localObject).commit();
      if (!this.uiHandler.hasMessages(64))
      {
        int i = ajol.Gw();
        this.uiHandler.sendEmptyMessageDelayed(64, i * 1000);
      }
      EmojiStickerManager.a().t(this);
      return;
      label321:
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1) {
        QQToast.a(BaseApplication.getContext(), 2131719247, 0).show(getTitleBarHeight());
      }
    }
  }
  
  private void bHQ()
  {
    boolean bool = true;
    if (this.app.a().Jh() == 1) {}
    for (;;)
    {
      this.mIsMsgSignalOpen = bool;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "mIsMsgSignalOpen: " + this.mIsMsgSignalOpen);
      }
      return;
      bool = false;
    }
  }
  
  private void bHR()
  {
    Bundle localBundle = this.mActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      anot.a(this.app, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void bHT()
  {
    if ((aizf.cmU) && (aqlr.isScreenLocked(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onShow_setReaded");
    }
    ThreadManager.post(new BaseChatpieHelper.UnreadTask(this.app, this), 8, null, false);
  }
  
  private void bHU()
  {
    this.dG = new BaseChatPie.61(this);
  }
  
  private void bHW()
  {
    int i = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
    int j = this.qm.size();
    if (i != 0)
    {
      i = this.jdField_a_of_type_Yjh.wN();
      if ((i == 5) || (i == 6)) {
        this.jdField_a_of_type_Yjh.ciA();
      }
    }
    while ((j == 0) || (this.jdField_a_of_type_Yja == null) || (isFullScreenMode())) {
      return;
    }
    QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.qm.get(j - 1);
    this.jdField_a_of_type_Yja.a(localQQOperationViopTipTask);
  }
  
  private void bHc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew. path = " + wmj.aTf);
    }
    anot.a(this.app, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
    PreferenceManager.getDefaultSharedPreferences(this.mContext).edit().putString("camera_photo_path", wmj.aTf).commit();
    Intent localIntent;
    if ((this.sessionInfo != null) && (this.sessionInfo.cZ == 1) && (((HotChatManager)this.app.getManager(60)).kj(this.sessionInfo.aTl)))
    {
      localIntent = new Intent();
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    for (;;)
    {
      ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo, 1, localIntent, 8);
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      this.uiHandler.removeMessages(33);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
        this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
      }
      return;
      localIntent = null;
    }
  }
  
  private void bHe()
  {
    ((wtk)this.jdField_a_of_type_Wvm.a(54)).aex();
  }
  
  private void bHh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.stop();
    }
  }
  
  private void bHi()
  {
    if (this.app.a() != null) {
      this.app.a().diq();
    }
    if (!TextUtils.isEmpty(this.sessionInfo.aTl))
    {
      top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -3010);
      top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -4020);
    }
    wla localwla = wla.a(this.app);
    if (localwla != null) {
      localwla.bZd();
    }
  }
  
  private void bHj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    if (this.mActivity != null)
    {
      localObject = this.mActivity.getCurrentFocus();
      if (localObject != null)
      {
        QLog.i(this.TAG, 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    Object localObject = (InputMethodManager)this.mContext.getSystemService("input_method");
    vV(true);
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) && (localObject != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false) != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false).clear();
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, null);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.b = null;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(null);
      if (this.sessionInfo.beA) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        if (wja.Rd())
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver();
          Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
          localField.setAccessible(true);
          localField.set(localObject, new CopyOnWriteArrayList());
          QLog.d(this.TAG, 1, "force clear mOnTouchModeChangeListeners success.");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper$a.destroy();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeOnLayoutChangeListener(this.jdField_b_of_type_AndroidViewView$OnLayoutChangeListener);
        }
        return;
        localThrowable = localThrowable;
        QLog.e(this.TAG, 1, "doOnDestroy: ", localThrowable);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.TAG, 1, "force clear mOnTouchModeChangeListeners", localException);
        }
      }
    }
  }
  
  private void bHk()
  {
    BaseChatPie.21 local21 = new BaseChatPie.21(this);
    if (AppSetting.aNS)
    {
      ThreadManager.executeOnSubThread(local21, true);
      return;
    }
    local21.run();
  }
  
  private void bHl()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      this.jdField_a_of_type_Wnc.onDestroy();
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(null);
    }
    if (this.jdField_a_of_type_Wki != null) {
      this.jdField_a_of_type_Wki.destroy();
    }
  }
  
  private void bHm()
  {
    adrm.a().s(this);
    wyv.Da(2);
    ArkFlashChatContainerWrapper.Da(2);
    if (this.jdField_a_of_type_Adrl != null)
    {
      this.jdField_a_of_type_Adrl.doOnDestroy();
      this.jdField_a_of_type_Adrl = null;
    }
  }
  
  private void bHn()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      M(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getOverscrollHeader());
    }
    if (this.A != null) {
      M(this.A.getBackground());
    }
    if (this.CA != null) {
      M(this.CA.getBackground());
    }
    if (this.CB != null) {
      M(this.CB.getBackground());
    }
  }
  
  private void bHo()
  {
    if (this.jdField_a_of_type_Acbh != null)
    {
      if (this.jdField_a_of_type_Acbh.i != null) {
        this.jdField_a_of_type_Acbh.i.dismiss();
      }
      this.jdField_a_of_type_Acbh.bGN = false;
    }
    ((abhh)this.app.getManager(153)).n(null);
    if (this.jdField_a_of_type_Abin != null) {
      this.jdField_a_of_type_Abin.p(this);
    }
    abhh.aM.clear();
    ((abij)this.app.getManager(232)).cCc();
  }
  
  private void bHp()
  {
    if (this.aSM)
    {
      this.aSM = false;
      An(8);
    }
    alte.a().bup();
    if (this.rJ != null)
    {
      this.cL.removeViewInLayout(this.rJ);
      this.fs.removeViewInLayout(this.rI);
      this.fs.removeViewInLayout(this.Cz);
      this.rJ = null;
      this.rI = null;
      this.Cz = null;
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131369277);
    }
  }
  
  private void bHq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    }
    if ((this.jdField_b_of_type_Arjn != null) && (this.jdField_b_of_type_Arjn.isShowing()) && (this.jdField_b_of_type_Arjn.getWindow() != null))
    {
      this.jdField_b_of_type_Arjn.dismiss();
      this.jdField_b_of_type_Arjn = null;
    }
    if ((this.jdField_a_of_type_Arjn != null) && (this.jdField_a_of_type_Arjn.isShowing()) && (this.jdField_a_of_type_Arjn.getWindow() != null))
    {
      this.jdField_a_of_type_Arjn.dismiss();
      this.jdField_a_of_type_Arjn = null;
    }
    if (this.rE != null)
    {
      this.rE.setVisibility(4);
      this.rE = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stopBluetoothSco();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.release();
    }
  }
  
  private void bHr()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.cae();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.onDestory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
    {
      this.bEy = -1;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.unInit();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.onDestroy();
    }
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.exR();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    }
  }
  
  private void bHu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showInputPanelIfNeeded() called");
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
        if (localObject == null)
        {
          QLog.e(this.TAG, 1, "showInputPanelIfNeeded() intent == null");
          return;
        }
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "showInputPanelIfNeeded() requestShowInputPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer == null));
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJU()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "showInputPanelIfNeeded() isReadyToShow false");
    return;
    aey();
    this.uiHandler.postDelayed(new BaseChatPie.23(this, (Intent)localObject), 100L);
  }
  
  private void bHv()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showPlusPanelIfNeeded() called");
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          localObject = ((Activity)localObject).getIntent();
        } while (localObject == null);
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_PLUS_PANEL", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "showPlusPanelIfNeeded() requestShowPlusPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer == null));
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJU()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "showPlusPanelIfNeeded() isReadyToShow false");
    return;
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(8);
    this.uiHandler.postDelayed(new BaseChatPie.24(this, (Intent)localObject), 100L);
  }
  
  private void bHx()
  {
    long l;
    Object localObject;
    int i;
    if (this.aSG)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "do jumpToSpecifiedMsg");
      }
      l = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_Wki.getList();
      if (((List)localObject).size() > 0)
      {
        if ((this.mActivity.getIntent() == null) || (!this.mActivity.getIntent().getBooleanExtra("jump_from_shmsgseq", false))) {
          break label167;
        }
        int j = ((List)localObject).size();
        i = 0;
        if (i >= j) {
          break label312;
        }
        if (((ChatMessage)((List)localObject).get(i)).shmsgseq != this.Fr) {
          break label160;
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.26(this, i));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
        this.aSG = false;
        return;
        label160:
        i += 1;
        break;
        label167:
        i = a((List)localObject, this.Fr);
        continue;
      }
      List localList = this.app.b().a(this.sessionInfo.cZ).a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.Fr);
      if (1000 == this.sessionInfo.cZ) {}
      for (localObject = ChatActivityUtils.b(localList, this.sessionInfo, this.app);; localObject = ChatActivityUtils.a(localList, this.sessionInfo, this.app))
      {
        a(localList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, -1L));
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.27(this));
        break;
      }
      label312:
      i = -1;
    }
  }
  
  private void bHz()
  {
    if (this.jdField_a_of_type_Smx != null)
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_Smx.a();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(null);
      }
    }
  }
  
  private void bIA()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (a().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        a().requestPermissions(new ujj(this), 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
        i = 0;
      }
      else
      {
        wpj.a().dl(this.mContext);
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(2);
        xro.i(this.app, "0X8005CAC", this.sessionInfo.cZ);
        return;
        i = 1;
      }
    }
  }
  
  private void bIB()
  {
    bHS();
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(8);
    Aa(0);
    xro.i(this.app, "0X8004078", this.sessionInfo.cZ);
    Object localObject = (afem)this.app.getManager(77);
    if (localObject != null)
    {
      localObject = (affc)((afem)localObject).a("qq.android.poke.res_0625");
      if ((localObject != null) && (!((affc)localObject).isSuccess())) {
        ((affc)localObject).HL(false);
      }
    }
    if (this.sessionInfo.cZ == 0) {
      anpc.report("tim_msg_tab_c2c_aio_aio_plus_click");
    }
    while (1 != this.sessionInfo.cZ) {
      return;
    }
    anpc.report("tim_msg_tab_group_aio_aio_plus_click");
  }
  
  private void bIC()
  {
    if (this.bEl != 1)
    {
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.aSP = (isFullScreenMode() ^ this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYY);
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
      }
      bHe();
      xro.i(this.app, "0X8005CAD", this.sessionInfo.cZ);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void bIJ()
  {
    if (this.d == null) {
      this.d = ((PowerManager)this.mActivity.getSystemService("power")).newWakeLock(536870918, this.TAG);
    }
    if (!this.d.isHeld()) {
      this.d.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "remainScreenOn");
    }
  }
  
  private void bIW()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter() == null)) {}
    for (;;)
    {
      return;
      int i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      while ((i <= j) && (i < this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount()))
      {
        Object localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i);
        if ((localObject instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer != null) {
            ((MessageForArkApp)localObject).arkContainer.resetInputState();
          }
        }
        i += 1;
      }
    }
  }
  
  private void bIj()
  {
    if (OX())
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("mobileQQ", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.mActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        this.bEm = 3;
        vg(str);
      }
    }
  }
  
  private void bIn()
  {
    long l = System.currentTimeMillis();
    acff localacff;
    int i;
    if ((this.sessionInfo != null) && (!this.aSh))
    {
      localacff = (acff)this.app.getManager(51);
      if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 2) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE() == null) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE().getVisibility() != 0)) {
        break label138;
      }
      i = 1;
      if ((this.sessionInfo.cZ != 3000) && (this.sessionInfo.cZ != 1)) {
        break label143;
      }
      b(localacff, 0, i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "saveChatInputType cost :" + (System.currentTimeMillis() - l));
      }
      return;
      label138:
      i = 0;
      break;
      label143:
      if (OW()) {
        a(localacff, 0, i);
      }
    }
  }
  
  private void bIt()
  {
    if (this.aSo)
    {
      this.uiHandler.removeMessages(16711689);
      this.uiHandler.sendEmptyMessage(16711689);
    }
  }
  
  private void bIu()
  {
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    aptl localaptl = aptl.a();
    Object localObject2 = localaptl.getUrl("troop_homework_create_notice");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>";
    }
    localObject2 = new aptl.a();
    ((aptl.a)localObject2).crf = this.sessionInfo.aTl;
    ((aptl.a)localObject2).from = "aio";
    ((aptl.a)localObject2).content = "";
    localIntent.putExtra("url", localaptl.a((String)localObject1, (aptl.a)localObject2));
    this.mContext.startActivity(localIntent);
    this.mActivity.overridePendingTransition(2130772367, 2130772002);
    aqfr.a(this.app, this.sessionInfo.aTl, "Grp_notice", "CreateNotice_Clk", 0, 0, new String[] { this.sessionInfo.aTl, "", "", "" });
  }
  
  private void bIv()
  {
    if (this.bEl != 1) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(24);
    }
  }
  
  private void bIw()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (a().checkSelfPermission("android.permission.CAMERA") == 0)
      {
        i = 1;
        if ((i == 0) || (a().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
          break label129;
        }
        i = 1;
        label42:
        if ((i == 0) || (!aczy.bd(a()))) {
          break label134;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label58:
      if (i == 0) {
        a().requestPermissions(new ujh(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
      for (;;)
      {
        xro.i(this.app, "0X800407A", this.sessionInfo.cZ);
        return;
        i = 0;
        break;
        label129:
        i = 0;
        break label42;
        label134:
        i = 0;
        break label58;
        grantForCamera();
      }
      i = 1;
    }
  }
  
  private void bIx()
  {
    wf(true);
  }
  
  private void bIy()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if ((a().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (a().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        a().requestPermissions(new uji(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i = 0;
      }
      else
      {
        bIz();
        return;
        i = 1;
      }
    }
  }
  
  private void bIz()
  {
    int i = 0;
    wvd localwvd = (wvd)this.jdField_a_of_type_Wvm.a(24);
    boolean bool = localwvd.isFullScreenMode();
    int j = localwvd.getPicCount();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doPhotoListAction fullStatus:" + bool + ", cnt:" + j);
    }
    if (bool)
    {
      if (j >= 20)
      {
        QQToast.a(this.app.getApp(), 2131696916, 0).show(getTitleBarHeight());
        return;
      }
      if ((this.sessionInfo.cZ == 1033) || (this.sessionInfo.cZ == 1034)) {
        i = 1;
      }
      if ((i != 0) || (OS()))
      {
        localwvd.K(true);
        return;
      }
      wmj.l(a(), j);
      bJe();
      return;
    }
    if (j > 0)
    {
      QQToast.a(this.app.getApp(), 2131696886, 0).show(getTitleBarHeight());
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(4);
    xro.i(this.app, "0X8004079", this.sessionInfo.cZ);
  }
  
  private void bm(Intent paramIntent)
  {
    this.sessionInfo.aTl = paramIntent.getStringExtra("uin");
    this.sessionInfo.cZ = paramIntent.getIntExtra("uintype", -1);
    this.sessionInfo.beq = false;
    this.sessionInfo.ber = false;
    if (this.sessionInfo.cZ == 0)
    {
      xva.a().k(this.app, this.sessionInfo);
      yhv.a().k(this.app, this.sessionInfo);
    }
    if (this.sessionInfo.cZ == 1026)
    {
      this.sessionInfo.cZ = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.sessionInfo.phoneNum = paramIntent.getStringExtra("phonenum");
    this.sessionInfo.entrance = paramIntent.getIntExtra("entrance", 0);
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b = new QQMessageFacade.b();
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context = new wkk(this.sessionInfo.aTl);
    this.sessionInfo.troopUin = paramIntent.getStringExtra("troop_uin");
    this.sessionInfo.aTo = null;
    this.sessionInfo.aTm = null;
    this.sessionInfo.bPt = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.sessionInfo.topicId = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.topicId = this.sessionInfo.topicId;
    this.bEm = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.bEn = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.aL = paramIntent.getBooleanExtra("isBack2Root", false);
    this.aSf = paramIntent.getBooleanExtra("open_chat_from_voice_changer_guide", false);
    if (!this.aSf)
    {
      bool1 = true;
      this.aSg = bool1;
      if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
        this.aM = paramIntent.getExtras().containsKey("res_share_id");
      }
      if (!this.aM) {
        this.aM = paramIntent.getBooleanExtra("is_share_flag", false);
      }
      if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
        this.aM = false;
      }
      this.aSn = paramIntent.getBooleanExtra("thridparty_pull_aio", false);
      this.aSq = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
      boolean bool2 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
      if (paramIntent.getIntExtra("aio_msg_source", 999) != 1) {
        break label510;
      }
      bool1 = true;
      label439:
      this.aN = bool1;
      if ((this.aN) || (bool2))
      {
        this.Fr = paramIntent.getLongExtra("searched_timeorseq", -1L);
        if (this.Fr <= -1L) {
          break label515;
        }
      }
    }
    label515:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aSF = bool1;
      wja.bcO = false;
      this.aO = false;
      this.jdField_a_of_type_Wvm.CS(1);
      return;
      bool1 = false;
      break;
      label510:
      bool1 = false;
      break label439;
    }
  }
  
  private void bp(Intent paramIntent)
  {
    Aa(0);
    ((wvd)this.jdField_a_of_type_Wvm.a(24)).ccq();
    this.sessionInfo.cN = ChatTextSizeSettingActivity.ag(this.mContext);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.sessionInfo.cN);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    }
    while (amim.a(this, this.mActivity.getIntent())) {
      return;
    }
    bGV();
  }
  
  private void bq(Intent paramIntent)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    long l = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_otherThings appShareId=" + l);
    }
    if (l > 0L) {
      this.uiHandler.postDelayed(new BaseChatPie.12(this, paramIntent), 20L);
    }
    this.jdField_a_of_type_Wvm.CS(3);
    if (paramIntent.getIntExtra("entrance", 0) == 9)
    {
      this.aSN = true;
      bIg();
      return;
    }
    this.aSN = false;
  }
  
  private void bsq()
  {
    www localwww = (www)a(29);
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0)
    {
      localwww.zg(false);
      return;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, " onClick fun_btn start mInputStat = " + this.bEl + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + " currentPanel:" + this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() + " currenttime:" + System.currentTimeMillis());
    }
    send();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " onClick fun_btn end mInputStat = " + this.bEl + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
      }
    }
    localwww.zg(true);
  }
  
  private void bv(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nearby_profile_nickname");
      if ((paramIntent != null) && (!paramIntent.equals(this.sessionInfo.aTn)))
      {
        this.sessionInfo.aTn = paramIntent;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onActivityResult new nick is " + paramIntent);
        }
        this.uiHandler.post(new BaseChatPie.30(this));
      }
    }
  }
  
  private void bw(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("input_full_screen_mode", false))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramIntent = paramIntent.getStringExtra("input_full_screen_mode_result");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onActivityResult fullInputMode " + paramIntent);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramIntent);
        ((wvd)this.jdField_a_of_type_Wvm.a(24)).Z(localArrayList, false);
      }
      return;
    }
  }
  
  private void bx(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
    }
    bIH();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {}
    for (boolean bool = paramIntent.getExtras().getBoolean("isNeedFinish");; bool = false)
    {
      if (bool) {
        fV(1);
      }
      for (;;)
      {
        ((wvo)a(39)).cn(this.mActivity.getIntent());
        return;
        aG(false, false);
      }
    }
  }
  
  private void by(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Acjz != null)
    {
      this.jdField_a_of_type_Acjz.onDestory();
      this.jdField_a_of_type_Acjz = null;
    }
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
      }
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        String str4 = localBundle.getString("latitude");
        String str5 = localBundle.getString("longitude");
        String str6 = localBundle.getString("description");
        String str7 = localBundle.getString("title");
        String str8 = localBundle.getString("summary");
        String str9 = localBundle.getString("dianping_id");
        String str1 = localBundle.getString("poiId");
        String str2 = localBundle.getString("latSpan");
        String str3 = localBundle.getString("lngSpan");
        if ((str1 != null) && (str2 != null))
        {
          paramIntent = str3;
          if (str3 != null) {}
        }
        else
        {
          str1 = "";
          str2 = "";
          paramIntent = "";
        }
        ujt.a(this.mContext, this.app, this.sessionInfo, str4, str5, str6, str7, str8, str9, str1, str2, paramIntent, localBundle);
      }
    }
  }
  
  private void bz(Intent paramIntent)
  {
    int i = ChatTextSizeSettingActivity.ag(this.mContext);
    if (this.sessionInfo.cN != i)
    {
      this.sessionInfo.cN = i;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.sessionInfo.cN);
    }
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("uin_type", 0);
      String str = paramIntent.getStringExtra("peeruin");
      long l = paramIntent.getLongExtra("uniseq", 0L);
      d((ChatMessage)this.app.b().a(str, i, l));
    }
  }
  
  private void c(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!this.aSZ);
        a(paramView).n(paramMotionEvent);
        return;
        QLog.d(this.TAG, 1, "hiboom icon touch down");
      } while (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty());
      a(paramView).n(paramMotionEvent);
      this.aSZ = true;
      return;
    }
    QLog.d(this.TAG, 1, "hiboom icon touch up");
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty()) || (this.aSZ))
    {
      a(paramView).n(paramMotionEvent);
      this.aSZ = false;
      return;
    }
    onClick(this.ad);
  }
  
  private void c(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.frienduin.equals(this.sessionInfo.aTl)) && (aegu.e(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.cZ, this.sessionInfo.topicId)))
    {
      if ((!(paramObject instanceof MessageForArkApp)) || (((MessageForArkApp)paramObject).getProcessState() != 1002)) {
        break label172;
      }
      ((ChatMessage)paramObject).mMsgAnimFlag = false;
      if (paramMessageRecord.msgtype == -2058) {
        break label183;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "update need instantUpdate, msg= " + paramMessageRecord.toString());
      }
      aG(true, true);
    }
    for (;;)
    {
      ((wjw)this.app.getManager(218)).a(this, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((aocq)this.app.getManager(272)).Z((ChatMessage)paramObject);
      }
      return;
      label172:
      ((ChatMessage)paramObject).mMsgAnimFlag = true;
      break;
      label183:
      aG(false, false);
    }
  }
  
  @Nullable
  private MessageRecord d(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    int i;
    if (this.mSourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (TextUtils.isEmpty(this.mSourceMsgInfo.mAnonymousNickName))
      {
        localObject = paramMessageRecord;
        if (paramMessageRecord == null)
        {
          localObject = cF();
          i = ((List)localObject).size() - 1;
          if (i < 0) {
            break label106;
          }
          paramMessageRecord = (ChatMessage)((List)localObject).get(i);
          if (paramMessageRecord.shmsgseq != this.mSourceMsgInfo.mSourceMsgSeq) {
            break label99;
          }
        }
      }
    }
    for (;;)
    {
      MessageForReplyText.reportReplyMsg(this.app, "suc_replyMsg", "reply_suc", this.sessionInfo.aTl, paramMessageRecord);
      localObject = paramMessageRecord;
      return localObject;
      label99:
      i -= 1;
      break;
      label106:
      paramMessageRecord = null;
    }
  }
  
  private int eI(int paramInt)
  {
    if (this.sessionInfo.cZ == 1008)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new BaseChatPie.38(this), 300L);
      return paramInt;
    }
    this.bEr += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[refreshListAdapter]: refreshBottomCount=" + this.bEr + ",refreshDelayForNextPie=" + aSz);
    }
    if (aSz)
    {
      if (!Pi()) {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.39(this));
      }
      aSz = false;
      return paramInt;
    }
    if (this.bEr == 1)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
      return paramInt;
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.40(this));
    return paramInt;
  }
  
  private int eJ(int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshlistadapter dirtyFlag=" + paramInt);
    }
    int i;
    if ((this.aSF) && (this.aSG))
    {
      i = 8;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "refreshlistadapter after set dirtyFlag=" + i);
      }
      return i;
    }
    Object localObject;
    int k;
    if (paramInt == 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() < 0) {
        break label324;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1);
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() > 0)
        {
          i = paramInt;
          if (((View)localObject).getId() == 2131362462)
          {
            i = paramInt;
            if (!((aavt)a(4)).isSelected()) {
              i = 2;
            }
          }
        }
        j = ((View)localObject).getBottom();
      }
      int m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "refreshlistadapter=====lastbuttom=" + j + " listHeight=" + m);
      }
      paramInt = i;
      k = j;
      j = m;
    }
    for (;;)
    {
      localObject = (AIOLongShotHelper)a(15);
      i = paramInt;
      if (k > j) {
        break;
      }
      i = paramInt;
      if (((AIOLongShotHelper)localObject).RS()) {
        break;
      }
      i = paramInt;
      if (paramInt != 0) {
        break;
      }
      i = paramInt;
      if (((aavt)a(4)).isSelected()) {
        break;
      }
      i = 2;
      break;
      if (!Pe())
      {
        i = 0;
        break;
      }
      i = paramInt;
      if ((paramInt & 0x10) != 16) {
        break;
      }
      i = 16;
      break;
      label324:
      j = 0;
      k = 0;
    }
  }
  
  private void eR(int paramInt1, int paramInt2)
  {
    t(paramInt1, paramInt2, "");
  }
  
  private void eT(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 28)
    {
      this.ahi = false;
      this.ad.setActivated(false);
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.Af(false);
      }
    }
    if (paramInt2 == 28)
    {
      this.ahi = true;
      this.ad.setActivated(true);
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.Af(true);
      }
    }
  }
  
  private void eU(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.zC(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.Dz(1019);
      if ((this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
      }
    }
    PhotoListPanel localPhotoListPanel;
    if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceU();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.zC(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceT();
      if (((this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 0)) && (!this.aSM))
      {
        Object localObject = new ArrayList();
        localObject = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
        localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label203;
        }
      }
    }
    for (;;)
    {
      localPhotoListPanel.setMixedMsgMode(bool);
      return;
      label203:
      bool = false;
    }
  }
  
  private void eV(int paramInt1, int paramInt2)
  {
    if (!this.aSh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      }
      if (paramInt2 != 2) {
        break label107;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (wir.w(this.app))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.yI(false);
      }
    }
    label107:
    while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() != 0) {
      return;
    }
  }
  
  private void eW(int paramInt1, int paramInt2) {}
  
  private void eu(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369579: 
    case 2131369967: 
    case 2131370393: 
    case 2131380514: 
    case 2131369594: 
    case 2131378923: 
    case 2131379823: 
      do
      {
        return;
        if ((!this.aSN) && (BaseChatItemLayout.bdx))
        {
          a(false, null, false);
          if (this.sessionInfo.cZ == 1008)
          {
            paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
            anot.a(this.app, "dc00899", "Pb_account_lifeservice", this.sessionInfo.aTl, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
          }
        }
        for (;;)
        {
          try
          {
            paramView = this.Cr.getTag();
            String[] arrayOfString = (String[])paramView;
            if ((paramView == null) || (!"comic".equals(arrayOfString[0]))) {
              break;
            }
            avdb.a(this.app, "3006", "2", "40025", arrayOfString[1], new String[] { "1" });
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          vW(false);
        }
        if (this.sessionInfo.cZ == 0)
        {
          this.aSp = true;
          anpc.report("tim_msg_tab_c2c_aio_msg_set");
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.bZz();
          }
          bGY();
          if (QLog.isDevelopLevel()) {
            QLog.d("reportEvent", 4, " curType : " + this.sessionInfo.cZ + ", mEntryFriendCard: " + this.aSp);
          }
          anot.a(this.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.cs(this.sessionInfo.cZ), "", "", "");
          return;
          if (1 == this.sessionInfo.cZ) {
            anpc.report("tim_msg_tab_group_aio_msg_set");
          }
        }
      } while (this.aSN);
      ex(paramView);
      return;
    }
    bIR();
  }
  
  private void ev(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onClick case R.id.input");
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.exS();
      return;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
      return;
    } while (!wvn.a(getApp(), this.mContext, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), getCurType()));
    if (!ykm.a(this.app).b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))
    {
      QQToast.a(this.mContext, acfp.m(2131703091), 0).show();
      anot.a(getApp(), "dc00898", "", "", "0X800932D", "0X800932D", 0, 0, "", "", "", "");
      return;
    }
    if (aofy.pV(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))
    {
      QQToast.a(this.mContext, acfp.m(2131703063), 0).show();
      return;
    }
    boolean bool;
    if (!this.ahi)
    {
      bool = true;
      this.ahi = bool;
      this.ad.setImageResource(2130838164);
      this.ad.setActivated(this.ahi);
      if (!this.ahi) {
        break label346;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
      }
      if (this.jdField_a_of_type_Afdw != null) {
        this.jdField_a_of_type_Afdw.cYA();
      }
      if (abrb.S(this.app)) {
        break label341;
      }
    }
    label341:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        abrb.b(this.app, "zhitu", true);
      }
      ahxs.de.set(false);
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cm(28, false);
      return;
      bool = false;
      break;
    }
    label346:
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
  }
  
  private void ew(View paramView)
  {
    Intent localIntent = (Intent)paramView.getTag();
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.app).stop(false);
    paramView.setVisibility(8);
    if (this.rD != null) {
      this.rD.setVisibility(8);
    }
    int i = wja.a(this.app, this.mActivity, localIntent);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "openAIO by start SplashAct");
      }
      this.mActivity.startActivity(localIntent);
    }
    while (i != 2)
    {
      if ((localIntent.getBooleanExtra("finishAIO", false)) && ((this.mActivity instanceof ChatActivity))) {
        this.mActivity.finish();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " onClick R.id.msgbox ");
      }
      return;
    }
    QLog.e(this.TAG, 1, "openAIO rediectToAIOWithMt 2");
  }
  
  private List<ChatMessage> f(List<ChatMessage> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refreshListAdapter refreshFlag: " + paramInt);
    }
    switch (this.bEk & 0xFFFF0000)
    {
    default: 
      return paramList;
    case 65536: 
      this.jdField_a_of_type_Wki.notifyDataSetChanged();
      return paramList;
    }
    paramList = n(this.aSE);
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      aqmq.track(null, "AIO_BaseChatPie_Remove_Sticker_Cost");
      EmojiStickerManager.a().b(this, paramList);
      aqmq.track("AIO_BaseChatPie_Remove_Sticker_Cost", null);
    }
    fB(paramList);
    Object localObject = b(paramList);
    if (localObject != null) {
      this.Fs = ((MessageRecord)localObject).shmsgseq;
    }
    a(paramList, (MessageRecord)localObject);
    localObject = a(paramList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, this.Fs));
    if (this.sessionInfo.cZ == 1)
    {
      apsa localapsa = (apsa)this.app.getManager(132);
      if (localapsa.qQ(this.sessionInfo.aTl)) {
        localapsa.T(this.sessionInfo.aTl, paramList);
      }
    }
    fA(paramList);
    if (this.aSN) {
      paramList = aily.bi(paramList);
    }
    for (;;)
    {
      a(paramList, (CharSequence)localObject, this.bEk);
      Pe();
      ChatFragment.wp(true);
      this.mAIORootView.invalidate();
      return paramList;
    }
  }
  
  private void fA(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      if ((!paramList.isSend()) && (this.sessionInfo.cZ == 0) && (!isFullScreenMode()))
      {
        if (!(paramList instanceof MessageForPoke)) {
          break label151;
        }
        if (!((MessageForPoke)paramList).isPlayed)
        {
          MessageForPoke localMessageForPoke = (MessageForPoke)paramList;
          xkr.a().a(this.app, this.sessionInfo.aTl, localMessageForPoke.interactType, 0, localMessageForPoke.strength);
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "receive PokeMsg strength:" + localMessageForPoke.strength + "." + paramList);
          }
        }
      }
    }
    label151:
    do
    {
      return;
      xkr.a().a(this.app, this.sessionInfo.aTl, -1, 0, -1);
    } while (!QLog.isColorLevel());
    QLog.d("PokeMsg", 2, "receive unPokeMsg strength:-1." + paramList);
  }
  
  private void fB(List<ChatMessage> paramList)
  {
    if ((this.aex) && (paramList.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      localChatMessage.mPendantAnimatable = true;
      if (((localChatMessage instanceof MessageForMarketFace)) && (!isFullScreenMode()))
      {
        MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        paramList = localMarkFaceMessage;
        if (localMarkFaceMessage == null)
        {
          localChatMessage.parse();
          paramList = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        }
        if (((paramList.mobileparam != null) && (paramList.mobileparam.length > 0)) || ((paramList.mediaType == 3) && (top.fv(this.sessionInfo.cZ)))) {
          ((MessageForMarketFace)localChatMessage).needToPlay = true;
        }
      }
    }
  }
  
  private boolean fW(int paramInt)
  {
    wrq.a().cbn();
    if (this.uiHandler.hasMessages(59)) {
      this.uiHandler.removeMessages(59);
    }
    if (this.jdField_a_of_type_Acbh != null) {
      this.jdField_a_of_type_Acbh.aS(true, paramInt);
    }
    this.jdField_a_of_type_Wvm.CS(11);
    this.aSo = false;
    boolean bool1 = ag(false);
    if ((bool1) && (paramInt == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "basechatpie_finish 1,type:" + paramInt);
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (this.aSM)
          {
            bIR();
            bool1 = true;
          }
          if ((!bool1) || (paramInt != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.TAG, 2, "basechatpie_finish 1.1,type:" + paramInt);
        return true;
        bool2 = bool1;
        if (this.jdField_a_of_type_Aiyr != null)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_Aiyr.onBackEvent()) {
            bool2 = true;
          }
        }
        if ((!bool2) || (paramInt != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.TAG, 2, "basechatpie_finish 2,type:" + paramInt);
      return true;
      zP(paramInt);
      boolean bool2 = j(paramInt, bool2);
      bool1 = bool2;
      if (this.jdField_a_of_type_Smx != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Smx.isShow())
        {
          this.jdField_a_of_type_Smx.bzx();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == 0)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null)
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.RL()) {
              bool2 = true;
            }
          }
        }
      }
      if ((!bool2) || (paramInt != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "basechatpie_finish 3,type:" + paramInt);
    return true;
    return false;
  }
  
  private void g(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isDebugVersion()) {
        QLog.i(this.TAG, 1, "from : " + paramString3 + "updateScheduleMsg scheduleID value error : " + paramString1);
      }
      return;
    }
    ThreadManager.executeOnSubThread(new BaseChatPie.94(this, paramString3, paramString1, paramString2, paramBoolean));
  }
  
  private boolean h(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 16711689: 
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "read confirm send readconfirm");
      }
      this.uiHandler.sendEmptyMessageDelayed(16711689, 300000L);
      ThreadManager.post(new BaseChatPie.16(this), 8, null, false);
      return true;
    case 12: 
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "handleMessage MSG_REFRESH_LIST");
      }
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof MessageHandler.d)))
      {
        paramMessage = (MessageHandler.d)paramMessage.obj;
        paramMessage.Qv = (System.currentTimeMillis() - paramMessage.Qu);
        MessageHandler.a(paramMessage, this.app);
      }
      bHE();
      if (this.mScrollState == 0)
      {
        adxn.a().t(getApp(), 1500);
        abgl.a().l(getApp(), 1500);
      }
      return true;
    case 78: 
      long l = paramMessage.getData().getLong("messageUniseq");
      int i = paramMessage.arg1;
      ChatMessage localChatMessage = (ChatMessage)this.app.a(this.sessionInfo.cZ).a(this.sessionInfo.aTl, this.sessionInfo.cZ, l);
      if ((localChatMessage != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof MessageHandler.d)))
      {
        paramMessage = (MessageHandler.d)paramMessage.obj;
        paramMessage.Qv = (System.currentTimeMillis() - paramMessage.Qu);
        MessageHandler.a(paramMessage, this.app);
        localChatMessage.setIsSentByXG(paramMessage.bIz);
      }
      b(localChatMessage, i);
      return true;
    case 13: 
      zU(paramMessage.arg1);
      return true;
    case 18: 
      aG(false, false);
      return true;
    case 267387139: 
      if (this.jdField_a_of_type_Arhz != null)
      {
        this.jdField_a_of_type_Arhz.dismiss();
        this.jdField_a_of_type_Arhz.setBackAndSearchFilter(false);
      }
      this.app.a().PE(false);
      return true;
    }
    if (this.jdField_a_of_type_Arhz != null)
    {
      this.jdField_a_of_type_Arhz.dismiss();
      this.jdField_a_of_type_Arhz.setBackAndSearchFilter(false);
    }
    this.app.a().PE(false);
    QQToast.a(this.mContext, 2131696089, 0).show(getTitleBarHeight());
    if (paramMessage.arg1 == 1) {
      acsb.h(this.sessionInfo.aTl, this.sessionInfo.cZ, acsb.czw, acsb.czG);
    }
    return true;
  }
  
  private void i(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.sessionInfo == null) || (!aqft.equalsWithNullCheck(paramString1, this.sessionInfo.aTl))) {}
    do
    {
      return;
      switch (this.sessionInfo.cZ)
      {
      default: 
        return;
      }
      this.sessionInfo.aTn = paramString2;
      this.mTitleText.setText(this.sessionInfo.aTn);
      if (AppSetting.enableTalkBack)
      {
        paramString1 = this.mTitleText.getText().toString();
        this.mTitleText.setContentDescription(paramString1);
        a().setTitle(this.mTitleText.getText());
      }
    } while (!QLog.isDevelopLevel());
    afck.l(this.TAG, new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  private boolean i(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 25: 
      if ((this.jdField_a_of_type_Arjn != null) && (this.jdField_a_of_type_Arjn.isShowing()) && (this.jdField_a_of_type_Arjn.getWindow() != null))
      {
        this.jdField_a_of_type_Arjn.dismiss();
        this.jdField_a_of_type_Arjn = null;
      }
      return true;
    case 38: 
      if (this.jdField_a_of_type_Yir == null) {
        this.jdField_a_of_type_Yir = new yir(this.app, this.jdField_a_of_type_Yjh, this.sessionInfo, this.mActivity);
      }
      if (this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yir, new Object[0]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new BaseChatPie.17(this));
        anot.a(this.app, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
      }
      return true;
    case 35: 
      if (this.jdField_a_of_type_Yjr == null) {
        this.jdField_a_of_type_Yjr = new yjr(this.app, this.jdField_a_of_type_Yjh, this.mContext, this.sessionInfo.aTl, new uid(this));
      }
      this.jdField_a_of_type_Yjr.yK(this.sessionInfo.aTl);
      this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yjr, new Object[0]);
      return true;
    case 26: 
      ujt.b(this.app, this.sessionInfo, true);
      return true;
    case 58: 
      ujt.a(this, this.app, this.sessionInfo, true);
      return true;
    case 28: 
      this.jdField_a_of_type_Yjh.ciA();
      return true;
    case 31: 
      boolean bool = SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_notice_key", false);
      if ((!SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
      {
        SettingCloneUtil.writeValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.app.getAccount());
        BaseApplicationImpl.getApplication().startActivity(paramMessage);
      }
      return true;
    }
    bHY();
    return true;
  }
  
  private void j(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    switch (this.sessionInfo.cZ)
    {
    default: 
    case 0: 
    case 1037: 
    case 1044: 
    case 1045: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.sessionInfo.aTl));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.sessionInfo.aTn = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "onSetComment curFriendNick" + aqft.pk(this.sessionInfo.aTn));
        }
        this.mTitleText.setText(this.sessionInfo.aTn);
      } while (!AppSetting.enableTalkBack);
      paramString1 = this.mTitleText.getText().toString();
      this.mTitleText.setContentDescription(paramString1);
      a().setTitle(this.mTitleText.getText());
      return;
      this.sessionInfo.aTn = aqgv.D(this.app, this.sessionInfo.aTl);
      paramString2 = this.sessionInfo;
      if (this.sessionInfo.aTn != null) {}
      for (paramString1 = this.sessionInfo.aTn;; paramString1 = this.sessionInfo.aTl)
      {
        paramString2.aTn = paramString1;
        break;
      }
    case 1: 
      aG(false, false);
      return;
    }
    aG(false, false);
  }
  
  private boolean j(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0)
    {
      if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.onBackEvent())) {}
      for (int i = 1;; i = 0)
      {
        if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 36) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.caS();
        }
        if (i == 0)
        {
          if (paramInt == 1) {
            this.jdField_b_of_type_ComTencentWidgetXPanelContainer.bK(false);
          }
        }
        else {
          return true;
        }
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.bK(true);
        return true;
      }
    }
    return paramBoolean;
  }
  
  private boolean j(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 32: 
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "MSG_SHOW_FASTIMAGE,  mAllowFastImage = " + this.aSk);
      }
      if (!this.aSk) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
        this.uiHandler.removeMessages(67);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        vT(false);
      }
      this.fs.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.s);
      anot.a(this.app, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.dbo();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
      }
      this.uiHandler.sendMessageDelayed(this.uiHandler.obtainMessage(33), 5000L);
      return false;
    }
    vT(true);
    return false;
  }
  
  private void k(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false)) || (paramIntent.getBooleanExtra("destroy_last_activity", false)))) || (paramInt2 == 4))
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        Intent localIntent = wja.a(new Intent(this.mContext, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(localBundle));
        this.mActivity.startActivity(localIntent);
      }
      this.mActivity.setResult(4, paramIntent);
    }
    if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setLastRequestCode(paramInt1);
    }
    this.jdField_a_of_type_Wvm.dispatchOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setLastRequestCode(paramInt1);
    }
    if ((this.jdField_a_of_type_Wsr != null) && (this.jdField_a_of_type_Wsr.isOpen())) {
      this.jdField_a_of_type_Wsr.h(paramInt1, paramInt2, paramIntent);
    }
  }
  
  private boolean k(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l = System.currentTimeMillis();
      if (l - this.Fu < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
        }
      }
      else
      {
        this.Fu = l;
        if (this.mScrollState != 0)
        {
          this.aSy = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
          }
        }
        else
        {
          boolean bool = aqnl.a(this.app, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "MSG_BUBBLE_CACHE_UPDATE, needRefresh=" + bool);
          }
          if (bool) {
            refresh(196608);
          }
        }
      }
    }
  }
  
  private void l(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceGuide", 2, "onActivityResult = =" + paramInt1 + "resultCode" + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTh = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTi = false;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(5, true);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(6, true);
    if (1000 == paramInt2)
    {
      paramInt1 = paramIntent.getIntExtra("click_item", 1);
      if ((paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 14)) {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanel", 2, "onActivityResult = setPanel=" + paramInt1);
      }
      k(Integer.valueOf(paramInt1));
    }
    while (1001 != paramInt2) {
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
  }
  
  private boolean l(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 100: 
      if (awou.nP(0)) {
        awpl.b(this.app, a(), getTitleBarHeight());
      }
      return true;
    }
    int i = paramMessage.arg1;
    if (awou.nP(i))
    {
      if (!awou.nS(i)) {
        break label82;
      }
      awou.eZ(this.app);
    }
    for (;;)
    {
      return true;
      label82:
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.app.getApp(), paramMessage, 1).show(getTitleBarHeight());
    }
  }
  
  private boolean m(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 16711681: 
      paramMessage = (String)paramMessage.obj;
      if (this.sessionInfo.aTl.equals(paramMessage)) {
        fV(1);
      }
      return true;
    case 14: 
      o(paramMessage.arg1, paramMessage.arg2);
      return true;
    case 23: 
      Aa(0);
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
      return true;
    case 16711696: 
      fV(1);
      return true;
    case 24: 
      if (this.jdField_a_of_type_Arhz != null)
      {
        this.jdField_a_of_type_Arhz.dismiss();
        QQToast.a(this.app.getApp(), 2131700606, 0).show(this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299627));
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("nickCount", paramMessage.arg1 + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, localHashMap, "");
      return true;
    }
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
    return true;
  }
  
  private void q(boolean paramBoolean, Object paramObject)
  {
    this.uiHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.jdField_a_of_type_Arhz == null) || (!this.jdField_a_of_type_Arhz.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", aqiw.getSystemNetwork(BaseApplication.getContext()) + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label353;
        }
        i = 1;
        break;
        if (ajlc.a().djF != 2) {
          this.jdField_a_of_type_Arhz.dismiss();
        }
        ajlc.a().lD.clear();
        if ((paramBoolean) && (paramObject != null)) {
          ajlc.a().lD.putAll((Map)paramObject);
        }
        if (ajlc.a().lD.size() == 0) {
          QQToast.a(this.app.getApp(), 2131700605, 0).show(getTitleBarHeight());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            if (ajlc.a().djF == 6) {
              ((wvy)this.jdField_a_of_type_Wvm.a(11)).a((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
            } else {
              ((wwb)this.jdField_a_of_type_Wvm.a(1)).b((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
            }
          }
        }
      }
      label353:
      i = 0;
    }
  }
  
  private void r(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    aqnl.H(this.app);
    Set localSet = (Set)paramObject;
    int k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label47:
    Object localObject1;
    ChatMessage localChatMessage;
    label102:
    int j;
    if (i < k)
    {
      paramObject = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject1 = (BaseBubbleBuilder.e)wja.a(paramObject);
        localChatMessage = wja.a(paramObject);
        if (!localChatMessage.isSend()) {
          break label247;
        }
        paramObject = localChatMessage.selfuin;
        Object localObject2 = (acff)this.app.getManager(51);
        if ((localObject1 != null) && (((BaseBubbleBuilder.e)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          localObject2 = ((acff)localObject2).a(paramObject);
          if (localObject2 != null)
          {
            Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
            if (localObject3 != null)
            {
              if (((Long)localObject3).longValue() == 0L) {
                break label304;
              }
              localObject3 = ((AvatarPendantManager)this.app.getManager(46)).a(((Long)localObject3).longValue());
              localObject1 = ((BaseBubbleBuilder.e)localObject1).a;
              if (i == k) {
                break label298;
              }
              j = 1;
              label220:
              ((PendantInfo)localObject3).a((View)localObject1, j, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label247:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label102;
      }
      paramObject = localChatMessage.senderuin;
      break label102;
      label298:
      j = 2;
      break label220;
      label304:
      if (((BaseBubbleBuilder.e)localObject1).a.am != null)
      {
        ((BaseBubbleBuilder.e)localObject1).a.am.setImageDrawable(null);
        ((BaseBubbleBuilder.e)localObject1).a.am.setVisibility(8);
      }
    }
  }
  
  private void s(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.sessionInfo.aTl.equals(paramObject + "")) && (!this.mActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      fV(1);
    }
  }
  
  private void t(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.t(paramInt1, paramInt2, paramString);
  }
  
  private void t(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.sessionInfo.aTl != null) && (paramObject != null) && (this.sessionInfo.aTl.equals(paramObject.uin)) && ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 1003) || (this.sessionInfo.cZ == 10002)) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        ujt.h(this.app, this.sessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.sessionInfo.cZ)
      {
      default: 
        if ((this.sessionInfo.aTl != null) && (this.sessionInfo.aTl.equals(paramObject.uin)))
        {
          bHa();
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onCardDownload nick = " + aqft.pk(this.sessionInfo.aTn));
          }
          this.mTitleText.setText(this.sessionInfo.aTn);
          if (AppSetting.enableTalkBack)
          {
            paramObject = this.mTitleText.getText().toString();
            this.mTitleText.setContentDescription(paramObject);
            a().setTitle(this.mTitleText.getText());
          }
          if ((3000 == this.sessionInfo.cZ) && ((this instanceof xyi))) {
            ((xyi)this).b(this.sessionInfo.aTn, this.sessionInfo.aTl, this.mTitleText);
          }
        }
      case 1034: 
        return;
      }
      aG(false, false);
      return;
    }
  }
  
  private boolean u(Object paramObject)
  {
    if ((this.mActivity instanceof SplashActivity))
    {
      if (this.mActivity.isFinishing()) {
        return true;
      }
      Fragment localFragment = ((SplashActivity)this.mActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (!localFragment.isVisible())) {
        return true;
      }
    }
    return paramObject == null;
  }
  
  private void uZ(String paramString)
  {
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.cZ, paramString, this.sessionInfo.phoneNum, false);
    if (this.sessionInfo.cZ == 1010) {
      anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  private void vX(boolean paramBoolean)
  {
    if (this.mActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "mActivity == null");
      }
    }
    while (((wvo)a(39)).Sb()) {
      return;
    }
    if ((this.mActivity instanceof SplashActivity))
    {
      fV(1);
      return;
    }
    this.mActivity.finish();
  }
  
  private void vZ(boolean paramBoolean)
  {
    if ((!paramBoolean) && (mc())) {
      QQToast.a(this.app.getApp(), 2130840095, this.mContext.getString(2131721435), 0).show(getTitleBarHeight());
    }
  }
  
  private void va(String paramString)
  {
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.cZ, paramString, this.sessionInfo.phoneNum, true);
    if (this.sessionInfo.cZ == 1010) {
      anot.a(this.app, "CliOper", "", this.sessionInfo.aTl, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
    }
  }
  
  private void vb(String paramString)
  {
    if (paramString != null)
    {
      if ((this.cL == null) || (this.sessionInfo == null) || (this.sessionInfo.a == null) || ((this.sessionInfo.a.img == null) && (!wkj.a(this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.aTl, true, 7, this.sessionInfo.a)))) {
        break label330;
      }
      if ((!this.sessionInfo.beq) || (!this.sessionInfo.bes) || (this.sessionInfo.isNightMode)) {
        break label184;
      }
      this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
      this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=" + paramString + ", show Again img=" + this.sessionInfo.a.img);
      return;
      label184:
      if ((this.sessionInfo.ber) && (this.sessionInfo.bet) && (!this.sessionInfo.isNightMode))
      {
        this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
      else if ((this.sessionInfo.cZ == 1033) || (this.sessionInfo.cZ == 1034))
      {
        this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
      else
      {
        this.cL.setBackgroundDrawable(this.sessionInfo.a.img);
      }
    }
    label330:
    QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=" + paramString + ", afRoot=" + this.cL + ", sessionInfo=" + this.sessionInfo);
  }
  
  private void vf(String paramString)
  {
    int k = 0;
    if (!this.sessionInfo.aTl.equals(paramString)) {
      return;
    }
    paramString = top.eW;
    int m = paramString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        j = paramString[i];
        if (this.sessionInfo.cZ == j) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.mActivity.runOnUiThread(new BaseChatPie.70(this));
        return;
      }
      i += 1;
    }
  }
  
  private void w(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1))
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_Smx.a();
      if (localTroopGiftPanel != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          localTroopGiftPanel.e(paramIntent.getLong("duration_time"), paramIntent.getLong("elapsed_time"), paramIntent.getBoolean("profitable_flag", false));
        }
      }
    }
  }
  
  private void w(HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.sessionInfo.aTl)) {
      return;
    }
    int i = 0;
    label17:
    BaseBubbleBuilder.e locale;
    if (i < this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
      {
        locale = (BaseBubbleBuilder.e)wja.a(paramHashMap);
        paramHashMap = wja.a(paramHashMap);
        if ((locale != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000)) {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001) && (paramHashMap.istroop != 10002)) {
            break label155;
          }
        }
      }
    }
    label155:
    for (paramHashMap = aqdj.a(this.app, 200, paramHashMap.senderuin, true);; paramHashMap = aqdj.a(this.app, 1, paramHashMap.senderuin))
    {
      locale.a.setHeaderIcon(paramHashMap);
      i += 1;
      break label17;
      break;
    }
  }
  
  private boolean w(Intent paramIntent)
  {
    if ((this.sessionInfo != null) && ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "chooseChatInputType redPacketExtra");
        }
        Aa(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        return true;
      }
    }
    return false;
  }
  
  private void wd(boolean paramBoolean)
  {
    this.aSC = paramBoolean;
  }
  
  private void wk(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setReceiptMode(paramBoolean, this.app);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new ujl(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
  }
  
  private void zN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ((wvo)a(39)).cn(this.mActivity.getIntent());
  }
  
  private void zO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    bHF();
  }
  
  private void zP(int paramInt)
  {
    if (paramInt == 1) {
      bIn();
    }
    while ((paramInt != 0) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0)) {
      return;
    }
    bIn();
  }
  
  private void zW(int paramInt)
  {
    aqjh.Q(this.app, paramInt);
  }
  
  @TargetApi(11)
  protected void Aa(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.bEl + " currenttime:" + System.currentTimeMillis());
    }
    if (paramInt != this.bEl)
    {
      if (paramInt != 1) {
        break label346;
      }
      if (this.Cw == null)
      {
        Button localButton = new Button(this.mContext);
        localButton.setId(2131382067);
        localButton.setBackgroundResource(2130851007);
        localButton.setTextSize(2, 14.0F);
        localButton.setTextColor(this.mContext.getResources().getColorStateList(2131167284));
        localButton.setText(2131690221);
        localButton.setOnTouchListener(this);
        int i = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(localButton, i, localLayoutParams);
        this.Cw = localButton;
      }
      this.Cw.setVisibility(0);
      if (this.Cx != null) {
        this.Cx.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      vS(true);
      if (VersionUtils.isHoneycomb())
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    }
    for (;;)
    {
      this.bEl = paramInt;
      bHX();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label346:
      if (paramInt != 2) {
        break;
      }
      bHV();
    }
    if (this.Cw != null) {
      this.Cw.setVisibility(8);
    }
    if (this.Cx != null) {
      this.Cx.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    if ((this.bEn <= 0) || ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) || (vo() > 0))) {
      vS(true);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      if (VersionUtils.isHoneycomb())
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.mSourceMsgInfo == null) && (!(this instanceof xzp)) && (aheq.a(this.app).aP(this.app))) {
        bIY();
      }
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(true);
      }
      bIe();
      break;
      vS(false);
    }
  }
  
  public void Ac(int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(this.mActivity, this.app.getAccount(), paramInt);
    if (6 == paramInt) {
      anot.a(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }
    while (9 != paramInt) {
      return;
    }
    anot.a(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public void Ad(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.Cp(paramInt);
    }
    ((wxo)a(53)).Ad(paramInt);
  }
  
  public void Ae(int paramInt) {}
  
  public void Af(int paramInt)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.MD(paramInt);
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
    }
    for (;;)
    {
      this.bED = -1;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      }
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.bED = paramInt;
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
        if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
        }
      }
      else
      {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.MD(paramInt);
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
      }
    }
  }
  
  public void Ag(int paramInt)
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(paramInt);
  }
  
  protected void Ah(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {}
    acff localacff;
    do
    {
      do
      {
        return;
      } while (this.aSf);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(paramInt, false);
        return;
      }
      localacff = (acff)this.app.getManager(51);
      if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
      {
        b(localacff);
        return;
      }
    } while (!OW());
    a(localacff);
  }
  
  public void Ai(int paramInt)
  {
    if (bEs == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "setVivoSetting isButtom=" + paramInt);
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.82(this, paramInt));
    }
  }
  
  public void Al(int paramInt)
  {
    Object localObject = FlowCameraActivity2.class;
    if (anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.mContext, (Class)localObject);
    ((Intent)localObject).putExtra("flow_camera_height", XPanelContainer.aLe);
    ((Intent)localObject).putExtra("selected_item", 5);
    ((Intent)localObject).putExtra("selected_data", this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK());
    ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.sessionInfo);
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    ((Intent)localObject).putExtra("sv_whitelist", DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bH((Intent)localObject);
    if (((this.sessionInfo.cZ == 1) && (jof.a().dd(this.sessionInfo.aTl))) || (this.sessionInfo.cZ == 1010) || (this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002)) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    if (paramInt == 1) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("flow_camera_use_filter_function", ankq.f(this.app, BaseApplicationImpl.getContext()));
      this.mActivity.startActivityForResult((Intent)localObject, 11000);
      xro.i(this.app, "0X8005E7D", this.sessionInfo.cZ);
      if (MediaPlayerManager.a(this.app).isPlaying()) {
        MediaPlayerManager.a(this.app).stop(false);
      }
      if (avfp.h != null) {
        avfp.h.dqV();
      }
      return;
      if (paramInt == 2) {
        ((Intent)localObject).putExtra("flow_camera_video_mode", true);
      }
    }
  }
  
  public void Am(int paramInt)
  {
    if (paramInt < 0)
    {
      this.U = Boolean.valueOf(true);
      Ai(1);
      this.aSK = true;
      wxo localwxo = (wxo)a(53);
      if (localwxo != null) {
        localwxo.CY(paramInt);
      }
    }
  }
  
  protected void Ib()
  {
    this.TAG = "BaseChatPie";
  }
  
  public void N(Drawable paramDrawable)
  {
    Object localObject = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null) {
        ((SystemBarCompact)localObject).setStatusBarDrawable(paramDrawable);
      }
    }
  }
  
  protected boolean OI()
  {
    return false;
  }
  
  public boolean OJ()
  {
    return this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0;
  }
  
  public boolean OK()
  {
    bGI();
    if (this.jdField_a_of_type_Abin == null) {
      return false;
    }
    return this.jdField_a_of_type_Abin.c(this);
  }
  
  protected boolean OL()
  {
    return false;
  }
  
  protected boolean OM()
  {
    return false;
  }
  
  protected boolean ON()
  {
    return false;
  }
  
  public boolean OO()
  {
    return true;
  }
  
  public boolean OP()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof xyi));
  }
  
  public boolean OQ()
  {
    return isRecording();
  }
  
  public boolean OR()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTi;
  }
  
  public boolean OS()
  {
    return this.mSourceMsgInfo != null;
  }
  
  public boolean OT()
  {
    return this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0;
  }
  
  public boolean OU()
  {
    return getCurType() == 1008;
  }
  
  public boolean OV()
  {
    boolean bool = true;
    if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1)) {
      bool = false;
    }
    return bool;
  }
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ((aavt)a(4)).W(paramMotionEvent);
  }
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      return true;
    }
    if (((aavt)a(4)).isSelected()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
    while (i >= 0)
    {
      paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramMotionEvent != null) && ((wja.a(paramMotionEvent) instanceof wzb.a)))
      {
        paramMotionEvent = paramMotionEvent.findViewById(2131362952);
        Rect localRect = new Rect();
        paramMotionEvent.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)f1, (int)f2)) {
          return false;
        }
      }
      i -= 1;
    }
    return true;
  }
  
  public boolean Pa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    this.bEB = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
    if (this.bEB == 1)
    {
      if (!((InputMethodManager)this.mContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        this.aSA = false;
        return true;
      }
    }
    else if ((this.bEB == 0) || ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE() != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
        this.aSA = false;
      }
      return true;
    }
    return false;
  }
  
  public boolean Pb()
  {
    if (this.jdField_a_of_type_Yje == null)
    {
      this.jdField_a_of_type_Yje = new yje(this.app, this.mActivity, this.jdField_a_of_type_Yjh);
      this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yje);
    }
    return this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yje, new Object[0]);
  }
  
  protected final boolean Pc()
  {
    return false;
  }
  
  public boolean Pd()
  {
    return false;
  }
  
  protected boolean Pe()
  {
    return true;
  }
  
  public boolean Pf()
  {
    return this.aSE;
  }
  
  public boolean Pg()
  {
    return this.jdField_b_of_type_ComTencentWidgetPatchedButton.isEnabled();
  }
  
  public boolean Ph()
  {
    return this.bEl != 2;
  }
  
  public boolean Pj()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceY();
      return true;
    }
    return false;
  }
  
  protected void R(MotionEvent paramMotionEvent)
  {
    if ((!this.aSN) && (this.app != null))
    {
      paramMotionEvent = ((abrg)this.app.getManager(249)).a();
      if (paramMotionEvent != null) {
        paramMotionEvent.c(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl);
      }
    }
  }
  
  public void R(boolean paramBoolean, String paramString) {}
  
  public aiyr a()
  {
    if (this.jdField_a_of_type_Aiyr == null) {
      this.jdField_a_of_type_Aiyr = new aiyr(this);
    }
    return this.jdField_a_of_type_Aiyr;
  }
  
  public View a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Xru.a(paramInt);
    if (localObject != null) {
      return localObject;
    }
    long l;
    if (paramInt == 36)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel = ((VoiceTextEditPanel)View.inflate(this.mContext, 2131558711, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.a(this.app, this, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openVoiceTextEditPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel;
    }
    if (paramInt == 3)
    {
      l = System.currentTimeMillis();
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559281, null));
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      localObject = this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if ((isFullScreenMode()) || (this.aSM)) {}
      for (boolean bool = true;; bool = false)
      {
        ((EmoticonMainPanel)localObject).bYY = bool;
        if (isFullScreenMode()) {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setHideAllSettingTabs(true);
        }
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZc = this.aSM;
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYZ = this.aSM;
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, this.sessionInfo.cZ, this.mContext, getTitleBarHeight(), this.aLB, this.bED, this);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        return this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      }
    }
    if (paramInt == 2)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)View.inflate(this.mContext, 2131561180, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.app, this, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      Ah(0);
      if (this.aSM) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setReceiptMode(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenAudioPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    }
    if (paramInt == 4)
    {
      l = System.currentTimeMillis();
      localObject = ((wwg)this.jdField_a_of_type_Wvm.a(7)).a(hashCode());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = xro.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, (Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c = new uip(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a = new uiq(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setImageCountChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setCustomOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a);
      wk(this.aSM);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setImageSentListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 14)
    {
      if (!Pd()) {
        return null;
      }
      l = System.currentTimeMillis();
      localObject = ((wwg)this.jdField_a_of_type_Wvm.a(7)).a(hashCode());
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = xro.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, true, (Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenFlashPicPanel:" + (System.currentTimeMillis() - l));
      }
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = new AIOFakePanel(this.mActivity);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
    }
    if (paramInt == 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = ((ApolloPanel)View.inflate(this.mContext, 2131558636, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(this, this.sessionInfo, this.bEx, this.bEw, this.bEy);
      aqmq.track("apollo_panel_open", null);
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel;
    }
    if (paramInt == 22) {
      return this.jdField_a_of_type_Adrl.aR();
    }
    if (paramInt == 24)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = ((HotPicMainPanel)View.inflate(this.mContext, 2131558660, null));
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(this.app, this.mContext, this, this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, this.jdField_b_of_type_ComTencentWidgetXPanelContainer);
      return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    }
    if (paramInt == 18)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = ((DoodlePanel)View.inflate(this.mContext, 2131558644, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(this.app, this, Long.valueOf(this.sessionInfo.aTl).longValue(), this.sessionInfo.cZ, this.jdField_b_of_type_ComTencentWidgetXPanelContainer, new uir(this));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel;
    }
    if (paramInt == 28)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel = new RichTextPanel(this.mContext);
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.x(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
    }
    return null;
  }
  
  public apwy a()
  {
    if (this.jdField_a_of_type_Apwy == null) {
      this.jdField_a_of_type_Apwy = new apwy(this, this.mActivity, this.app);
    }
    return this.jdField_a_of_type_Apwy;
  }
  
  public SessionInfo a()
  {
    return this.sessionInfo;
  }
  
  public AIOAnimationConatiner a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  }
  
  public StructingMsgItemBuilder.b a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$b;
  }
  
  public PhotoListPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  }
  
  public BaseActivity a()
  {
    return this.mActivity;
  }
  
  public MessageForArkApp a(wyw paramwyw)
  {
    Object localObject;
    if (paramwyw == null)
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_Wki.getList().iterator();
    MessageForArkApp localMessageForArkApp;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (ChatMessage)localIterator.next();
          } while (!(localObject instanceof MessageForArkApp));
          localMessageForArkApp = (MessageForArkApp)localObject;
          localObject = localMessageForArkApp;
          if (localMessageForArkApp.arkContainer == paramwyw) {
            break;
          }
        } while (localMessageForArkApp.mExtendMsgArkAppList == null);
        localObject = localMessageForArkApp.mExtendMsgArkAppList.iterator();
      }
    } while (((MessageForArkApp)((Iterator)localObject).next()).arkContainer != paramwyw);
    return localMessageForArkApp;
    return null;
  }
  
  public EmoticonMainPanel a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public EmotionKeywordLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout;
  }
  
  public EntryModel a()
  {
    return new EntryModel(-1, 0L, "", false);
  }
  
  public QQRecorder.RecorderParam a()
  {
    return new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
  }
  
  public XPanelContainer a()
  {
    return this.jdField_b_of_type_ComTencentWidgetXPanelContainer;
  }
  
  protected List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, -1L, paramBoolean);
  }
  
  public snf a()
  {
    if (this.jdField_a_of_type_Smx != null) {
      return this.jdField_a_of_type_Smx.a();
    }
    return null;
  }
  
  public wsr a()
  {
    return null;
  }
  
  public <T extends wvr> T a(int paramInt)
  {
    return this.jdField_a_of_type_Wvm.a(paramInt);
  }
  
  public xru a()
  {
    return this.jdField_a_of_type_Xru;
  }
  
  public yhw a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Yhw == null)
    {
      this.jdField_a_of_type_Yhw = new yhw(this.jdField_a_of_type_Yjh, this.mActivity);
      this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yhw);
    }
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("showArkTips : hide? :");
      if (paramString == null)
      {
        bool = true;
        QLog.d(str, 2, bool + ",mID=" + paramLong);
      }
    }
    else
    {
      if (paramString != null) {
        break label119;
      }
      this.jdField_a_of_type_Yjh.ciA();
    }
    for (;;)
    {
      return this.jdField_a_of_type_Yhw;
      bool = false;
      break;
      label119:
      this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yhw, new Object[] { paramString, Long.valueOf(paramLong) });
    }
  }
  
  public yiu a()
  {
    return this.jdField_a_of_type_Yiu;
  }
  
  public yjh a()
  {
    return this.jdField_a_of_type_Yjh;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i;
    Object localObject;
    Message localMessage;
    if (this.bEg < paramInt6)
    {
      int j = paramInt1 + paramInt2 - paramInt4 - paramInt5;
      i = j;
      if (j >= paramInt3 - paramInt5 - paramInt4) {
        i = paramInt6 - 1;
      }
      if (i >= this.bEg) {
        this.bEg = (i + paramInt4);
      }
      if (paramInt7 == 0) {
        this.bEg = paramInt6;
      }
      i = paramInt6 - this.bEg;
      if (i != this.bEh)
      {
        if (this.uiHandler.hasMessages(13)) {
          this.uiHandler.removeMessages(13);
        }
        localObject = this.uiHandler;
        localMessage = this.uiHandler.obtainMessage(13, i, paramInt7);
        if (!this.T.booleanValue()) {
          break label218;
        }
      }
    }
    label218:
    for (long l = 1500L;; l = 0L)
    {
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.T = Boolean.valueOf(false);
      this.bEh = i;
      localObject = (wxo)a(53);
      if (localObject != null)
      {
        ((wxo)localObject).CZ(this.bEh);
        ((wxo)localObject).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    a(paramInt1, paramLong, paramInt2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.special_msg", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    long l2 = 0L;
    paramMessageRecord = this.jdField_a_of_type_Wki.getList();
    long l1 = l2;
    Object localObject;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      do
      {
        l1 = l2;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        localObject = (ChatMessage)paramMessageRecord.next();
      } while (top.s((MessageRecord)localObject));
      l1 = ((ChatMessage)localObject).shmsgseq;
    }
    paramMessageRecord = new BaseChatPie.35(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.YN(paramInt3);
    paramInt3 = 0;
    if (this.jdField_a_of_type_Yjh.wN() == 9) {
      paramInt3 = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG + ".troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + l1 + "|value:" + paramLong + "|type:" + paramInt1);
    }
    if (paramInt3 == 0)
    {
      if (paramInt1 != 1) {
        break label316;
      }
      if ((int)l1 >= 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label1343;
        }
        paramLong = l1 - 200L;
      }
    }
    label316:
    label1343:
    for (;;)
    {
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.j(l1, paramLong, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, paramMessageRecord, 6);
      do
      {
        do
        {
          return;
          if ((paramInt1 == 23) || (paramInt1 == 14) || (paramInt1 == 6) || (paramInt1 == 21) || (paramInt1 == 4) || (paramInt1 == 3) || (paramInt1 == 26) || (paramInt1 == 18) || (paramInt1 == 19) || (paramInt1 == 5) || (paramInt1 == 20) || (paramInt1 == 13) || (paramInt1 == 101) || (paramInt1 == 102))
          {
            ThreadManager.post(new BaseChatPie.36(this, paramLong, paramInt2, l1, paramInt1, paramMessageRecord), 8, null, true);
            return;
          }
          if (paramInt1 != 22) {
            break label877;
          }
          if (paramInt2 > 200) {
            break label837;
          }
          if (l1 - paramLong <= paramInt2) {
            break;
          }
          QQToast.a(this.mActivity, 2131699910, 0).show(this.mActivity.getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "refreshHeadMessage: invalidate unread count");
          }
        } while (paramInt4 != 1);
        xmb.a(this.app, null, "0X800A36B");
        return;
        if ((int)l1 < 1L + paramLong) {
          break label597;
        }
        if (aqiw.isNetworkAvailable(this.mActivity)) {
          break;
        }
        QQToast.a(this.mActivity, 2131699442, 0).show(this.mActivity.getTitleBarHeight());
      } while (paramInt4 != 1);
      xmb.a(this.app, null, "0X800A36B");
      return;
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.j(l1, paramLong, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, 6);
      return;
      label597:
      localObject = this.app.b().c(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong, 0L);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramInt2 = 0;
        if (paramInt2 < ((List)localObject).size())
        {
          paramMessageRecord = (MessageRecord)((List)localObject).get(paramInt2);
          if ((top.s(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips))) {}
        }
      }
      for (;;)
      {
        if ((paramMessageRecord != null) && (!ahwb.aB(paramMessageRecord)))
        {
          paramInt2 = this.jdField_a_of_type_Wki.K(paramMessageRecord.uniseq);
          if (paramInt2 != -1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 6);
            return;
            paramInt2 += 1;
            break label643;
          }
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.mActivity, acfp.m(2131703083), 0).show(this.mActivity.getTitleBarHeight());
          }
          if (paramInt4 != 1) {
            break;
          }
          xmb.a(this.app, null, "0X800A36B");
          return;
        }
        QQToast.a(this.mActivity, 2131699910, 0).show(this.mActivity.getTitleBarHeight());
        if (paramInt4 != 1) {
          break;
        }
        xmb.a(this.app, null, "0X800A36B");
        return;
        label837:
        QQToast.a(this.mActivity, 2131699911, 0).show(this.mActivity.getTitleBarHeight());
        if (paramInt4 != 1) {
          break;
        }
        xmb.a(this.app, null, "0X800A36B");
        return;
        label877:
        if ((paramInt1 != 17) && (paramInt1 != 10) && (paramInt1 != 100) && (paramInt1 != 11)) {
          break;
        }
        localObject = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong);
        if ((localObject != null) && (paramInt2 <= 200))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG + ".troop.special_msg", 2, "refreshHeadMessage==>unreadMsgCount:" + paramInt2 + ", fistseq:" + l1 + ", mr.shmsgseq:" + ((MessageRecord)localObject).shmsgseq);
          }
          if ((int)l1 >= ((MessageRecord)localObject).shmsgseq + 1L)
          {
            if (this.jdField_a_of_type_Apat != null) {
              this.jdField_a_of_type_Apat.j(l1, ((MessageRecord)localObject).shmsgseq, false);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, this.uiHandler, 6);
            return;
          }
          paramInt2 = this.jdField_a_of_type_Wki.M(paramLong);
          if (paramInt2 == -1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.uiHandler, 6);
          return;
        }
        boolean bool = this.app.b().a().qo(this.sessionInfo.aTl);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG + ".trooptroop_pull_msg", 2, "所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:" + paramLong + ",isAioParallelPullMsgDone:" + bool);
        }
        if (bool)
        {
          if ((int)l1 >= 1L + paramLong)
          {
            if (this.jdField_a_of_type_Apat != null) {
              this.jdField_a_of_type_Apat.j(l1, paramLong, false);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, paramMessageRecord, this.uiHandler, 6);
            return;
          }
          paramInt2 = this.jdField_a_of_type_Wki.M(paramLong);
          if (paramInt2 == -1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.uiHandler, 6);
          return;
        }
        this.jdField_a_of_type_Apdd$a = new apdd.a();
        this.jdField_a_of_type_Apdd$a.actionType = apdd.a.dTx;
        this.jdField_a_of_type_Apdd$a.a = apab.a.a(paramInt1, paramLong, paramInt2);
        this.app.b().a().addObserver(this);
        return;
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt, MessageHandler.d paramd, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "refresh with dirty: " + paramInt + " uniseq: " + paramLong + " currentPauseRefreshFlag: " + this.aSC);
    }
    if ((this.aSC) && (this.bEk == paramInt)) {}
    Message localMessage;
    label297:
    label300:
    label302:
    do
    {
      int i;
      for (;;)
      {
        return;
        i = paramInt & 0xFFFF0000;
        if ((paramInt & 0xFFFF) > (this.bEk & 0xFFFF))
        {
          paramInt &= 0xFFFF;
          this.bEk = (i | paramInt);
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "refresh with refreshFlag: " + i + " scrollFlag: " + paramInt);
          }
          if ((!mc()) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 6) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 5) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 35) && (!Pi())) {
            break label297;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label300;
          }
          if (i != 262144) {
            break label302;
          }
          localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramLong);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.obj = paramd;
          localMessage.arg1 = 0;
          this.uiHandler.sendMessageDelayed(localMessage, 400L);
          return;
          paramInt = this.bEk & 0xFFFF;
          break;
        }
      }
      localMessage = new Message();
      localMessage.what = 12;
      if (paramd != null) {
        localMessage.obj = paramd;
      }
      if (i < 196608) {
        break;
      }
    } while (this.uiHandler.hasMessages(12));
    paramLong = SystemClock.uptimeMillis();
    if (paramLong - this.lastRefreshTime > 1000L)
    {
      this.uiHandler.sendMessage(localMessage);
      return;
    }
    this.uiHandler.sendMessageDelayed(localMessage, 1000L - (paramLong - this.lastRefreshTime));
    return;
    paramd = (aavt)a(4);
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.mActivity.runOnUiThread(new BaseChatPie.34(this, paramd));
    }
    for (;;)
    {
      this.uiHandler.removeMessages(12);
      this.uiHandler.sendMessage(localMessage);
      return;
      if ((!paramd.isSelected()) && (this.jdField_a_of_type_Wki != null)) {
        this.jdField_a_of_type_Wki.bYX();
      }
    }
  }
  
  public void a(abzy paramabzy)
  {
    paramabzy.a(this.app, this.mActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.sessionInfo);
  }
  
  public void a(afmi paramafmi)
  {
    paramafmi.a(this.app, this.mActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.sessionInfo);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable)
  {
    if ((paramafmi2.type == 6) && ((paramafmi2 instanceof afpu)) && (((afpu)paramafmi2).ajH())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = aqjf.b(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = aqjf.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if ((i > 0) && (this.playMode != j))
    {
      this.playMode = j;
      QQToast.a(paramContext, i, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  protected void a(Editable paramEditable)
  {
    boolean bool2 = true;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "input stat is " + this.bEl);
    }
    if (this.bEl == 0)
    {
      if (((((wxa)a(14)).Sg()) && (this.sessionInfo.cZ != 1008)) && ((paramEditable.length() <= 0) && (vo() <= 0))) {
        break label197;
      }
      bool1 = true;
      vS(bool1);
      www localwww = (www)a(29);
      if (paramEditable.length() <= 0) {
        break label202;
      }
      bool1 = true;
      label124:
      localwww.zf(bool1);
      if (this.aSS) {
        if (paramEditable.length() <= 0) {
          break label207;
        }
      }
    }
    label197:
    label202:
    label207:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aSS = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l));
      }
      b(paramEditable);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label124;
    }
  }
  
  protected void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (this.aey) {
        paramImageView.setImageResource(paramInt2);
      }
    }
    else {
      return;
    }
    paramImageView.setImageResource(paramInt1);
  }
  
  protected void a(QQMessageFacade.Message paramMessage)
  {
    if (this.aSN) {}
    while ((!BaseChatpieHelper.a(this.sessionInfo, this.app, paramMessage)) || (isFullScreenMode()) || (ausb.a(this.app).i(paramMessage)) || (((wvo)a(39)).c(paramMessage)) || (24 == this.jdField_a_of_type_Yjh.wN())) {
      return;
    }
    Intent localIntent = this.app.a(this.mContext, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new BaseChatPie.41(this, paramMessage, localIntent);
    this.mActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.post(new BaseChatPie.76(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null)) {}
    do
    {
      return;
      if (paramLong == 0L) {
        xmb.a(this.app, this.sessionInfo, Long.parseLong(paramChatMessage.senderuin));
      }
      paramString = yfp.a(this.app, paramChatMessage, paramInt, paramLong, paramString);
    } while (paramString == null);
    this.mSourceMsgInfo = paramString;
    if (TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName))
    {
      paramString = this.dd;
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      paramString = appe.a(this.app, this.mActivity, this.mSourceMsgInfo, paramInt - i * 2, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), paramString);
      if (paramString == null) {
        break label313;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(20);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, paramString);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(appd.getInstance());
      bIZ();
      bIX();
      zM(2);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      if ((this.mSourceMsgInfo != null) && (!this.app.getCurrentUin().equals(String.valueOf(this.mSourceMsgInfo.mSourceMsgSenderUin)))) {
        wg(false);
      }
    }
    for (;;)
    {
      this.uiHandler.postDelayed(new BaseChatPie.86(this), 200L);
      MessageForReplyText.reportReplyMsg(this.app, this.sessionInfo, paramChatMessage);
      return;
      paramString = null;
      break;
      label313:
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    int m;
    int k;
    int j;
    int i;
    int n;
    if (!localAIOLongShotHelper.RS()) {
      if (wja.eU(1) == 0)
      {
        m = 1;
        if (m != 0)
        {
          paramChatMessage = ajlc.a().lC.entrySet().iterator();
          k = 0;
          j = 0;
          i = 1;
          if (!paramChatMessage.hasNext()) {
            break label283;
          }
          paramCompoundButton = (Map.Entry)paramChatMessage.next();
          if (!((Boolean)paramCompoundButton.getValue()).booleanValue()) {
            break label264;
          }
          n = k + 1;
          paramCompoundButton = (ChatMessage)paramCompoundButton.getKey();
          k = acei.W(paramCompoundButton) | j;
          j = i;
          if (m != 0)
          {
            j = i;
            if (i != 0) {
              if (acrb.D(paramCompoundButton))
              {
                j = i;
                if (n <= 1) {}
              }
              else
              {
                j = 0;
              }
            }
          }
          if (j != 0) {
            break label222;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        j = i2;
        label176:
        ((wub)a(66)).zb(i & j);
        i = ajlc.a().getCheckedItemCount();
        ((wwu)a(40)).setCheckedNum(i);
        return;
        m = 0;
        break;
        label222:
        i = n;
      }
      for (;;)
      {
        n = k;
        int i1 = j;
        k = i;
        j = n;
        i = i1;
        break;
        j = 0;
        break label176;
        localAIOLongShotHelper.a(paramChatMessage, paramCompoundButton, paramBoolean);
        return;
        label264:
        n = i;
        i = k;
        k = j;
        j = n;
      }
      label283:
      k = j;
    }
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo != null) {}
    for (Object localObject = paramDraftTextInfo.text;; localObject = "")
    {
      this.aLz = ((String)localObject);
      localObject = (wwn)a(27);
      if (((localObject == null) || (!((wwn)localObject).isShow())) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "skip set text draft");
      }
      return;
    }
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      this.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
      this.mSourceMsgInfo.mSourceMsgTroopName = paramDraftTextInfo.sourceMsgTroopName;
      this.mSourceMsgInfo.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
      this.mSourceMsgInfo.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
      this.mSourceMsgInfo.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
      this.mSourceMsgInfo.mSourceMsgToUin = paramDraftTextInfo.sourceToUin;
      this.mSourceMsgInfo.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
      this.mSourceMsgInfo.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
      this.mSourceMsgInfo.mType = paramDraftTextInfo.mSourceType;
      this.mSourceMsgInfo.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
      this.mSourceMsgInfo.mAtInfoStr = paramDraftTextInfo.mSourceAtInfoStr;
      this.mSourceMsgInfo.origUid = paramDraftTextInfo.mSourceUid;
      i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      if (TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName))
      {
        localObject = this.dd;
        localObject = appe.a(this.app, this.mActivity, this.mSourceMsgInfo, i - j - k, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), (View.OnClickListener)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, ((appe)localObject).getDrawable(), null, null);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(appd.getInstance());
        }
        zM(2);
      }
    }
    else
    {
      if (this.aLz == null) {
        break label506;
      }
    }
    label506:
    for (boolean bool = true;; bool = false)
    {
      this.aSS = bool;
      if ((paramDraftTextInfo == null) || (paramDraftTextInfo.mixedMsgInfoHtml == null)) {
        break label512;
      }
      ((wvd)this.jdField_a_of_type_Wvm.a(24)).xK(paramDraftTextInfo.mixedMsgInfoHtml);
      aqpm.a(paramDraftTextInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.aLz, this.app, a(), this.sessionInfo.aTl);
      if ((!TextUtils.isEmpty(this.aLz)) && (this.mSourceMsgInfo == null) && (!(this instanceof xzp)) && (aheq.a(this.app).aP(this.app))) {
        this.uiHandler.postDelayed(new BaseChatPie.13(this), 100L);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.aSr = false;
      return;
      localObject = null;
      break;
    }
    label512:
    Editable localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if (this.aLz == null) {}
    for (localObject = "";; localObject = this.aLz)
    {
      localEditable.insert(i, (CharSequence)localObject);
      break;
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    ujt.a(this.app, this.mContext, this.sessionInfo, paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getStatus() != 1)) {}
    aixt localaixt;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) && (paramInt == 1) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 0));
      localaixt = aiyh.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localaixt != null) && (paramInt == 1) && (!localaixt.isAutoPlay));
    a().b(paramEmoticon, paramInt, paramString);
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    ((wun)this.jdField_a_of_type_Wvm.a(65)).a(paramMessageForShakeWindow);
  }
  
  public void a(QQRecorder.a parama, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.uiHandler != null)
    {
      if (this.uiHandler.hasMessages(16711688))
      {
        this.uiHandler.removeMessages(16711688);
        d(0, null, -1L);
      }
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
    }
    setRequestedOrientation4Recording(false);
    bIJ();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startRecord() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.mContext);
    }
    if ((parama != null) && ((parama instanceof PressToSpeakPanel)) && (((PressToSpeakPanel)parama).RF()))
    {
      str = aoqr.A(acbn.SDCARD_PATH + "ppt/", true);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      this.aLy = (str + "pcmforvad.pcm");
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.US(this.aLy);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.b(paramRecorderParam);
    String str = aojs.a(this.app.getCurrentAccountUin(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.mAudioType, str);
    if ((str != null) && (!str.equals(paramRecorderParam))) {
      new File(str).deleteOnExit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + paramRecorderParam);
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.a(parama);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.start(paramRecorderParam, paramBoolean);
      if (this.bEv >= 0) {
        this.bEv += 1;
      }
      return;
      paramRecorderParam = str;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ThreadManager.postImmediately(new BaseChatPie.49(this), null, false);
    if (!this.aSM)
    {
      a(paramString, this.Fq, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    alte.a().a(this.app, this.sessionInfo, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    a().runOnUiThread(new BaseChatPie.50(this));
  }
  
  public void a(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.mUserData == null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramRecorderParam.dZN);
        anqo.a(paramString, this.app, this.sessionInfo.aTl, this.Fq, paramInt, paramRecorderParam.mAudioType, paramRecorderParam.dZM, localBundle);
      }
      return;
    }
  }
  
  protected void a(String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    Object localObject = ujt.a(this.app, paramString1, this.sessionInfo, -2, paramRecorderParam.mAudioType);
    if (localObject != null)
    {
      ((MessageForPtt)localObject).c2cViaOffline = true;
      long l = ((MessageRecord)localObject).uniseq;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.dZN);
      ujt.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl, paramString1, l, false, paramInt, paramRecorderParam.mAudioType, true, 0, 4, false, paramRecorderParam.dZM, (Bundle)localObject);
      d(0, paramString1, l);
      anot.a(this.app, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "3.4.4");
      paramString1 = anpc.a(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.collectPerformance("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i = 1;
      if (paramRecorderParam.mUserData != null) {
        break label130;
      }
    }
    long l;
    int j;
    String str1;
    Object localObject;
    label130:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l = SystemClock.uptimeMillis();
      j = this.sessionInfo.cZ;
      str1 = this.sessionInfo.aTl;
      if (i != 0) {
        break label441;
      }
      localObject = ujt.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.mAudioType);
      if (localObject != null) {
        break label136;
      }
      return;
      i = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool;
    paramLong = ((MessageRecord)localObject).uniseq;
    if ((localObject != null) && (MessageForPtt.class.isInstance(localObject)))
    {
      localObject = (MessageForPtt)localObject;
      ((MessageForPtt)localObject).waveformArray = PttAudioWaveView.a(paramRecorderParam.oY, paramRecorderParam.dZO);
      if (!aqmr.isEmpty(paramRecorderParam.cuc)) {
        ((MessageForPtt)localObject).sttText = paramRecorderParam.cuc;
      }
    }
    aomq.iG.put(paramString, Long.valueOf(l));
    if (!bool)
    {
      anqo.cU(paramString, false);
      anqo.Rl(paramString);
      label241:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong);
      }
      localObject = this.app;
      if (!aSH) {
        break label498;
      }
    }
    label441:
    label498:
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "3.4.4");
      aSH = true;
      i = eK(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.dZN);
      ArrayList localArrayList = new ArrayList();
      String str2 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      ujt.a(this.app, j, str1, paramString, paramLong, false, paramInt2, paramRecorderParam.mAudioType, bool, paramInt3, i, paramBoolean, paramRecorderParam.dZM, (Bundle)localObject, localArrayList, str2, false, paramInt4);
      eS(paramInt1, paramInt2);
      d(0, paramString, paramLong);
      return;
      localObject = this.app.b().a(str1, 0, paramLong);
      if ((localObject != null) && (MessageForPtt.class.isInstance(localObject))) {
        ((MessageForPtt)localObject).voiceLength = QQRecorder.d(paramInt2);
      }
      break;
      alid.nZ(paramString);
      break label241;
    }
  }
  
  public void a(String paramString, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.aSM) {}
    label569:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("EmojiStickerManager", 1, " send, emojiText is empty");
        return;
      }
      ujt.d locald;
      if ((paramString.length() > 0) && (paramStickerInfo != null))
      {
        this.mSourceMsgInfo = null;
        akxo.NQ(paramString);
        if (paramString.length() > 3478)
        {
          ChatActivityUtils.h(this.mContext, 2131719509, 1);
          return;
        }
        locald = new ujt.d();
        locald.mMsgSignalCount = this.mMsgSignalCount;
        locald.mMsgSignalSum = this.mMsgSignalSum;
        locald.mIsMsgSignalOpen = this.mIsMsgSignalOpen;
        locald.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
        locald.mMsgSendTime = System.currentTimeMillis();
        locald.mSourceMsgInfo = this.mSourceMsgInfo;
        locald.aSL = this.aSL;
        locald.stickerInfo = paramStickerInfo;
        this.aSL = false;
        if ((this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          a(paramString, locald, new ArrayList());
          a(paramString, false, this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.app);
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
          }
          eR(this.sessionInfo.entrance, -1);
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_Yjh.h(1002, new Object[] { paramString });
          if (this.app.getApplication().getResources().getConfiguration().orientation == 2) {
            anot.a(this.app, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Adrl == null) {
          break label569;
        }
        this.jdField_a_of_type_Adrl.cUb();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
        }
        new ArrayList();
        a(paramString, locald, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        break;
        QLog.e("EmojiStickerManager", 1, " send, sticker info is empty");
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    Object localObject = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    int i;
    if (paramRecorderParam.mUserData == null)
    {
      i = 1;
      if (i != 0) {
        break label127;
      }
      anqo.a(this.app, paramRecorderParam.mAudioType, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      anqo.a(paramString, (byte[])localObject, localObject.length, (short)0);
      label94:
      if (paramString != null)
      {
        if (paramBoolean) {
          break label145;
        }
        this.Fq = 0L;
        zX(2131230758);
        aG(true, false);
      }
    }
    label145:
    label279:
    for (;;)
    {
      return;
      i = 0;
      break;
      label127:
      alid.nY(paramString);
      alid.a(paramString, (byte[])localObject, localObject.length);
      break label94;
      if (this.aSM)
      {
        localObject = ujt.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.mAudioType);
        paramString = (String)localObject;
        if (localObject != null)
        {
          ((MessageForPtt)localObject).msgVia = this.sessionInfo.entrance;
          alte.a().f = ((MessageForPtt)localObject);
        }
      }
      for (paramString = (String)localObject;; paramString = ujt.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.mAudioType))
      {
        if (paramString == null) {
          break label279;
        }
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        this.Fq = paramString.uniseq;
        paramRecorderParam.dZM = paramString.vipSubBubbleId;
        paramRecorderParam.dZN = paramString.vipBubbleDiyTextId;
        zX(2131230746);
        break;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(paramString, this.Fq, paramBoolean2, paramRecorderParam);
    this.mActivity.runOnUiThread(new BaseChatPie.44(this, paramBoolean1));
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_Wki.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(ujt.d paramd)
  {
    paramd.mMsgSignalCount = this.mMsgSignalCount;
    paramd.mMsgSignalSum = this.mMsgSignalSum;
    paramd.mIsMsgSignalOpen = this.mIsMsgSignalOpen;
    paramd.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
    paramd.mMsgSendTime = System.currentTimeMillis();
    paramd.aTx = ahwv.a(this).ciK;
    if ((this.mSourceMsgInfo != null) && (this.mSourceMsgInfo.mSourceMsgText.length() > bEE))
    {
      this.mSourceMsgInfo.mSourceMsgText = this.mSourceMsgInfo.mSourceMsgText.substring(0, bEE);
      this.mSourceMsgInfo.mSourceSummaryFlag = 0;
      if (this.mSourceMsgInfo.mType == -1036) {
        this.mSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramd.mSourceMsgInfo = this.mSourceMsgInfo;
  }
  
  public void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel = ((EmotionSearchPanel)View.inflate(this.mContext, 2131558652, null));
      }
      afnd localafnd = (afnd)a().a().a(7);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.dbl();
      int i = ankt.getRealHeight(this.mContext) - paramInt1 - ImmersiveUtils.getStatusBarHeight(this.mContext);
      if (ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        Rect localRect = new Rect();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getGlobalVisibleRect(localRect);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.a(this.app, this, i, paramBoolean2, paramString, paramInt1 - localRect.bottom, paramInt2, localafnd);
        return;
      }
      paramInt1 = this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
      int j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.a(this.app, this, i, paramBoolean2, paramString, paramInt1 + j, paramInt2, localafnd);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel.onDestory();
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, paramBoolean3, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((BaseChatItemLayout.bdx == paramBoolean1) && (!paramBoolean4)) {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
    }
    label162:
    label433:
    label454:
    label585:
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        BaseChatItemLayout.a = this;
        this.aSU = true;
        BaseChatItemLayout.bdx = paramBoolean1;
        AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
        if (!paramBoolean3)
        {
          if (!localAIOLongShotHelper.RS()) {
            ajlc.a().a(paramChatMessage, paramBoolean1);
          }
          a(paramChatMessage, null, paramBoolean1);
        }
        if ((paramBoolean1) || (paramBoolean3)) {
          break label477;
        }
        this.Cr.setBackgroundResource(2130851758);
        if (QLog.isColorLevel()) {
          QLog.i(this.TAG, 2, "set left text from set checkbox: " + this.aLA);
        }
        if (!TextUtils.isEmpty(this.aLA)) {
          break label433;
        }
        this.Cr.setText("");
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejF();
        }
        if (!this.aey) {
          break label465;
        }
        if (!TextUtils.isEmpty(this.Cs.getText())) {
          break label454;
        }
        this.Cs.setVisibility(8);
        label205:
        ajlc.a().dyd();
        localAIOLongShotHelper.cbN();
        this.jdField_a_of_type_Wki.Y = Boolean.valueOf(true);
        ((wub)a(66)).ccc();
        this.pp.setVisibility(0);
        this.aQ.setVisibility(8);
        if (this.app != null)
        {
          bGT();
          bIL();
        }
        if (this.aSl)
        {
          showBottomBar();
          this.aSl = false;
        }
        this.mAIORootView.findViewById(2131369637).setVisibility(0);
        this.cJ.setVisibility(0);
        this.cK.setVisibility(0);
        paramChatMessage = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams)) {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
        }
        if ((this.Cy != null) && (!TextUtils.isEmpty(this.Cy.getText().toString())) && (!"0".equals(this.Cy.getText().toString())))
        {
          this.Cy.setVisibility(0);
          ((wxo)a(53)).cdj();
        }
        abrb.b(this.app, "select_more_msg", false);
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label585;
        }
        this.jdField_a_of_type_Wki.notifyDataSetChanged();
        return;
        BaseChatItemLayout.a = null;
        break;
        this.Cr.setText(this.aLA);
        this.aLA = "";
        break label162;
        this.Cs.setVisibility(0);
        break label205;
        label465:
        this.Cs.setVisibility(8);
        break label205;
        label477:
        this.jdField_a_of_type_Wki.Y = Boolean.valueOf(false);
        hidePanel();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0)
        {
          bIh();
          this.aSl = true;
        }
        paramChatMessage = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          if (this.bEq == 0) {
            this.bEq = paramChatMessage.bottomMargin;
          }
        }
        if (this.Cy != null) {
          this.Cy.setVisibility(8);
        }
        this.Cs.setVisibility(8);
        if (this.aST) {
          ajlc.a().dyd();
        }
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "listView onViewCompleteVisableAndReleased");
    }
    if (((this.jdField_a_of_type_Wki != null) && (this.jdField_a_of_type_Wki.getCount() > 0)) || ((this.sessionInfo.cZ == 0) && (!aqft.rj(this.sessionInfo.aTl))))
    {
      this.Fp = SystemClock.uptimeMillis();
      ((wkk)this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.context).fU(this.Fp);
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQi = false;
      this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b.aQj = true;
      if (this.sessionInfo.cZ == 1008)
      {
        this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 21, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
        return true;
      }
      this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, 20, this.jdField_b_of_type_ComTencentImcoreMessageQQMessageFacade$b);
      return true;
    }
    vY(false);
    return true;
  }
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  protected void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.Rw()) {
      paramBoolean1 = false;
    }
    if ((paramBoolean1) && (!wja.Rc())) {
      if (this.rE == null)
      {
        this.mActivity.getLayoutInflater().inflate(2131558690, this.fs);
        this.rE = this.fs.findViewById(2131362513);
        this.bs = ((TextView)this.fs.findViewById(2131362514));
        this.py = ((ImageView)this.fs.findViewById(2131362512));
        this.rE.setOnClickListener(this);
        if (this.sessionInfo.cZ != 1) {
          break label228;
        }
        if ((this.jdField_a_of_type_Apat != null) && (!this.jdField_a_of_type_Apat.aAJ())) {
          ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, 2131369277);
        }
      }
    }
    label227:
    label228:
    do
    {
      do
      {
        do
        {
          break label227;
          for (;;)
          {
            this.rE.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
              this.bs.setTextColor(Color.parseColor("#FF737373"));
            }
            if (!paramBoolean2) {
              break;
            }
            this.bs.setText(2131690245);
            this.py.setBackgroundResource(2130850969);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.bN(false, this.sessionInfo.cZ);
            }
            return;
            if (this.Cy == null) {
              ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, 2131369277);
            }
          }
          this.bs.setText(2131690244);
          this.py.setBackgroundResource(2130850968);
        } while (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.bN(true, this.sessionInfo.cZ);
        return;
      } while (this.rE == null);
      this.rE.setVisibility(8);
      paramBoolean1 = ija.Y(BaseApplicationImpl.getContext());
      paramBoolean2 = AudioHelper.bL(BaseApplicationImpl.getContext());
    } while (((!paramBoolean1) && (!paramBoolean2)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null));
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (!this.du) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localNavBarAIO.bN(paramBoolean1, this.sessionInfo.cZ);
      return;
    }
  }
  
  public void aG()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466);
      ((View)localObject).setBackgroundResource(2130839270);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466).setVisibility(8);
  }
  
  public void aG(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "instantUpdate: " + paramBoolean1 + " / " + paramBoolean2);
    }
    if (Pi())
    {
      QLog.d(this.TAG, 1, "instantUpdate: blockRefreshJumpBottom TRUE " + false + " / " + false);
      paramBoolean2 = false;
      paramBoolean1 = false;
    }
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (;;)
    {
      refresh(i | 0x20000);
      return;
      i = 3;
      continue;
      i = 0;
    }
  }
  
  protected void aH(QQAppInterface paramQQAppInterface)
  {
    int i = this.sessionInfo.cZ;
    if ((i != 1033) && (i != 1034))
    {
      i = this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ);
      anod.T(1, 0, this.sessionInfo.cZ, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "setReaded");
    }
    paramQQAppInterface.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, true, true);
  }
  
  protected void aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.bdx) {}
    for (;;)
    {
      return;
      if (!this.aSh)
      {
        acff localacff = (acff)this.app.getManager(51);
        if (!localacff.aaf())
        {
          ThreadManager.executeOnSubThread(new BaseChatPie.80(this));
          return;
        }
        long l = System.currentTimeMillis();
        if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1)) {
          b(localacff, paramBoolean1, paramBoolean2);
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l) + " isCallFromOnShow = " + paramBoolean1 + " guide = " + paramBoolean2);
          return;
          a(localacff, paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  protected void aI(QQAppInterface paramQQAppInterface)
  {
    this.aSB = true;
    wnf.a().a(paramQQAppInterface, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
  }
  
  protected void aIH()
  {
    aH(this.app);
  }
  
  protected void aQ()
  {
    Object localObject2;
    String str1;
    String str2;
    if ((this.aSe) && (!BaseChatItemLayout.bdx))
    {
      int j = alkm.X(this.app);
      int i = 0;
      localObject1 = this.app.b();
      if (localObject1 != null) {
        i = ((QQMessageFacade)localObject1).bl();
      }
      i = j + i;
      localObject2 = "";
      if (i <= 0) {
        break label182;
      }
      localObject1 = "" + i;
      if (i > 99) {
        localObject1 = "99+";
      }
      str1 = this.mContext.getString(2131720735) + "(" + (String)localObject1 + ")";
      str2 = acfp.m(2131703082) + this.mContext.getString(2131720735) + i + "条未读";
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = acfp.m(2131703087) + this.mContext.getString(2131720735))
    {
      aa(str1, (String)localObject1, (String)localObject2);
      return;
      label182:
      str1 = this.mContext.getString(2131720735);
    }
  }
  
  void aa(String paramString1, String paramString2, String paramString3)
  {
    this.uiHandler.post(new BaseChatPie.19(this, paramString1, paramString3, paramString2));
  }
  
  public void aey()
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
    }
  }
  
  protected boolean af(boolean paramBoolean)
  {
    this.createTime = NetConnInfoCenter.getServerTime();
    if (this.mAIORootView == null)
    {
      QLog.e(this.TAG, 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.mActivity.getChatFragment();
      if (localChatFragment != null) {
        this.mAIORootView = localChatFragment.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      if (this.mAIORootView == null)
      {
        QLog.e(this.TAG, 1, "root view is still null");
        return false;
      }
    }
    this.mAIORootView.setVisibility(0);
    this.sessionInfo.reset();
    bGD();
    this.bEu = 2;
    wja.h(this.TAG, "doOnCreate", hashCode(), this.bEu);
    br(this.mActivity.getIntent());
    aqmq.track("AIO_updateSession", "AIO_doOnCreate_otherCost");
    bHD();
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    bHZ();
    this.app.setHandler(ChatActivity.class, this.uiHandler);
    aqmq.track("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      g(this.mActivity.getIntent(), 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bJm();
      aqmq.track("AIO_doOnCreate_handleRequest", null);
      return true;
      g(this.mActivity.getIntent(), 2);
    }
  }
  
  public void afq()
  {
    int j = 0;
    if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131700686;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.mContext.getString(i));
        if (j == 0) {
          break label247;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.mContext.getResources().getColor(2131165750), this.mContext.getResources().getColor(2131165758)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        aqha.a(this.mContext, acfp.m(2131703090), (CharSequence)localObject, 0, 2131721303, null, null, new uij(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131700688;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131700687;
      }
      else
      {
        i = 2131700685;
        j = 1;
      }
    }
    label247:
    aqha.a(this.mContext, 230, acfp.m(2131703073), localException.toString(), acfp.m(2131703096), "", null, new uik(this)).show();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (((wvd)this.jdField_a_of_type_Wvm.a(24)).a(paramEditable)) {
      return;
    }
    wwn localwwn = (wwn)a(27);
    if (localwwn != null) {
      localwwn.d(paramEditable);
    }
    a(paramEditable);
  }
  
  public void aj(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_Smx == null) {
      this.jdField_a_of_type_Smx = new smx(this);
    }
    this.jdField_a_of_type_Smx.aj(paramBoolean, paramInt);
  }
  
  public void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mContext, getTitleBarHeight());
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    this.jdField_a_of_type_Arhz.show();
  }
  
  public void ay(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null)
      {
        ((SystemBarCompact)localObject).setStatusBarDrawable(null);
        ((SystemBarCompact)localObject).setStatusBarColor(paramInt);
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(afmi paramafmi) {}
  
  protected void b(Editable paramEditable)
  {
    if (this.mIsMsgSignalOpen)
    {
      if ((this.aSx) || (paramEditable.length() <= 0)) {
        break label82;
      }
      this.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
      if ((this.mMsgSignalNetType == 2) || (this.mMsgSignalNetType == 3))
      {
        this.aSx = true;
        this.mMsgSignalSum = 1;
        if (this.dG == null) {
          bHU();
        }
        ThreadManager.getSubThreadHandler().post(this.dG);
      }
    }
    label82:
    while (paramEditable.length() != 0) {
      return;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.dG);
    this.aSx = false;
    this.mMsgSignalSum = 40;
    this.mMsgSignalCount = 0;
    this.bEo = 0;
    this.mMsgSignalNetType = 0;
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_Wki.b(paramChatMessage) + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return;
    }
    int j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + (i - j) + ",firstPos is:" + j + ",pos is:" + i);
    }
    refresh(196613);
  }
  
  public void b(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_Wki.c(paramChatMessage, paramInt);
  }
  
  public void b(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2) {
      if (paramInt != 1) {
        break label39;
      }
    }
    label39:
    for (bool1 = bool2;; bool1 = false)
    {
      a(paramString, this.Fq, bool1, paramRecorderParam);
      zW(paramInt);
      return;
    }
  }
  
  public void b(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, int paramInt)
  {
    ujt.d locald = new ujt.d();
    locald.mMsgSignalCount = this.mMsgSignalCount;
    locald.mMsgSignalSum = this.mMsgSignalSum;
    locald.mIsMsgSignalOpen = this.mIsMsgSignalOpen;
    locald.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
    locald.mMsgSendTime = System.currentTimeMillis();
    locald.bEX = paramInt;
    a(paramString, locald, paramArrayList);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.mUserData == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      anqo.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    alid.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void bE(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((!paramIntent.getBooleanExtra("click_long_screen_shot", false)) || (this.jdField_a_of_type_Wki == null)) {
      return;
    }
    this.jdField_a_of_type_Wki.a.czK();
  }
  
  public void bFq() {}
  
  protected void bGD()
  {
    this.bEu = 2;
    wja.h(this.TAG, "preStartBaseAIO", hashCode(), this.bEu);
    this.aSY = false;
    this.aSB = false;
    this.aSC = false;
    this.aSD = true;
    this.aSI = false;
    this.aSK = false;
    this.aSE = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTh = false;
    this.aST = BaseChatItemLayout.bdx;
    BaseChatItemLayout.bdx = false;
    wja.yn(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    aqmq.track(null, "AIO_doOnCreate_initUI");
    bGE();
    aqmq.track("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    bGJ();
    aqmq.track("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  protected void bGE()
  {
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.mAIORootView.findViewById(2131377546));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionSearchPanel = ((EmotionSearchPanel)this.mAIORootView.findViewById(2131366391));
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setOnChangeMultiScreenListener(this);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setReadyToShowChangeListener(new uif(this));
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.es = true;
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    this.cL = ((ViewGroup)this.mAIORootView.findViewById(2131362332));
    xkr.a().a((FitSystemWindowsRelativeLayout)this.cL);
    this.fs = ((RelativeLayout)this.mAIORootView.findViewById(2131364469));
    this.rz = this.mAIORootView.findViewById(2131374819);
    this.f = ((RelativeLayout)this.mAIORootView.findViewById(2131364564));
    this.fn = ((RelativeLayout)this.mAIORootView.findViewById(2131374824));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.mAIORootView.findViewById(2131377361));
    this.pz = ((ImageView)this.mAIORootView.findViewById(2131377362));
    this.cJ = ((ViewGroup)this.mAIORootView.findViewById(2131379823));
    this.cK = ((ViewGroup)this.mAIORootView.findViewById(2131378923));
    this.Cr = ((TextView)this.mAIORootView.findViewById(2131369579));
    this.tU = ((TextView)this.mAIORootView.findViewById(2131369619));
    this.pq = ((ImageView)this.mAIORootView.findViewById(2131369967));
    this.Cs = ((TextView)this.mAIORootView.findViewById(2131380514));
    this.gn = ((RelativeLayout)this.mAIORootView.findViewById(2131369637));
    this.pp = ((ImageView)this.mAIORootView.findViewById(2131369594));
    this.aQ = ((FrameLayout)this.mAIORootView.findViewById(2131369610));
    this.pw = ((ImageView)this.mAIORootView.findViewById(2131377002));
    this.px = ((ImageView)this.mAIORootView.findViewById(2131377003));
    this.px.setVisibility(8);
    this.ps = ((ImageView)this.mAIORootView.findViewById(2131369588));
    this.ps.setContentDescription(this.app.getApp().getString(2131697550));
    this.Cr.setOnClickListener(this);
    this.pp.setOnClickListener(this);
    this.pq.setOnClickListener(this);
    this.Cs.setOnClickListener(this);
    this.mAIORootView.findViewById(2131370393).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnClickListener(this);
    this.pp.setContentDescription(this.app.getApp().getString(2131691436));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131379769));
    this.Ct = ((TextView)this.mAIORootView.findViewById(2131365958));
    this.mTitleIcon = ((ImageView)this.mAIORootView.findViewById(2131379813));
    this.pt = ((ImageView)this.mAIORootView.findViewById(2131379814));
    this.pu = ((ImageView)this.mAIORootView.findViewById(2131379815));
    this.jdField_a_of_type_AndroidWidgetViewFlipper = ((ViewFlipper)this.mAIORootView.findViewById(2131379859));
    this.jdField_a_of_type_AndroidWidgetViewFlipper.setMeasureAllChildren(false);
    this.Cu = ((TextView)this.mAIORootView.findViewById(2131379857));
    this.Cv = ((TextView)this.mAIORootView.findViewById(2131379858));
    this.jdField_B_of_type_AndroidViewViewStub = ((ViewStub)this.mAIORootView.findViewById(2131374652));
    this.pv = ((ImageView)this.mAIORootView.findViewById(2131366144));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mAIORootView.findViewById(2131370537));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(2);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.cVd();
    this.mGestureDetector = new GestureDetector(this.mContext, new c());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.mAIORootView.findViewById(2131362727));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.p(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_a_of_type_Acbh;
    this.jdField_a_of_type_Wnc = new wnc(this.mContext, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this);
    this.jdField_a_of_type_Wki = new wki(this.app, this.mActivity, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    ((aavt)a(4)).czJ();
    if (this.rM == null)
    {
      this.rM = new View(this.mContext);
      int i = this.mContext.getResources().getDimensionPixelSize(2131299627);
      this.rM.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.rM.setId(2131362463);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.rM, null, false);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i);
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Wki);
    this.jdField_a_of_type_Wki.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller = new MoveToBottomScroller(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Wnc);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mAIORootView.findViewById(2131381443));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372847));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setHelperProvider(this.jdField_a_of_type_Wvm);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.mAIORootView.findViewById(2131369276));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.b = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$e;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(aofr.c);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper$a = new BaseChatpieHelper.a(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper$a);
      tat.b(this.app.getApp(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      ((wvd)this.jdField_a_of_type_Wvm.a(24)).H(this.mAIORootView);
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.ja(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.go = ((RelativeLayout)this.mAIORootView.findViewById(2131381619));
      ayag.d(this.mAIORootView, true);
      this.jdField_a_of_type_Wvm.CS(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)this.mAIORootView.findViewById(2131369277));
      this.rC = this.mAIORootView.findViewById(2131362412);
      this.ad = ((ImageButton)this.mAIORootView.findViewById(2131362411));
      this.ad.setOnTouchListener(this);
      aqcl.a(this.ad, new uih(this));
      this.ad.setImageResource(2130838164);
      this.ahi = false;
      bIG();
      bIF();
      if (this.jdField_a_of_type_Adrl == null) {
        this.jdField_a_of_type_Adrl = new adrl(this);
      }
      this.pz.setVisibility(8);
      aJ();
      bGF();
      if (Build.VERSION.SDK_INT >= 16)
      {
        ViewGroup localViewGroup = (ViewGroup)this.mAIORootView.findViewById(2131373566);
        aqfl.a(this.app, localViewGroup, a(), a());
      }
      if ((this.mAIORootView.getParent() instanceof DrawerFrame))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = ((DrawerFrame)this.mAIORootView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.ehR();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "input set error", localException);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = new DrawerFrame(this.mContext, this.mAIORootView);
    }
  }
  
  public void bGG()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[initApolloSurfaceView],mCurrentAIOState:" + this.bEu);
    }
    bGI();
    this.jdField_a_of_type_Abin.l(this);
  }
  
  public void bGH()
  {
    bGI();
    this.jdField_a_of_type_Abin.m(this);
  }
  
  protected void bGJ()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.jdField_a_of_type_Wiw = new wiw(this.fn);
    this.sessionInfo.a = new wkj();
    if (this.jdField_b_of_type_Aghq == null) {
      this.jdField_b_of_type_Aghq = new b(null);
    }
    if (this.jdField_a_of_type_Inh == null) {
      this.jdField_a_of_type_Inh = new a(null);
    }
    this.du = this.app.getLoudSpeakerState();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.app);
    this.aSs = true;
    this.jdField_a_of_type_Yjh = new yjh(this.app, this.sessionInfo, this.jdField_a_of_type_Wiw, this.jdField_b_of_type_ComTencentWidgetXPanelContainer, this.qm);
    this.jdField_a_of_type_Zxj = ((zxj)this.app.getManager(125));
  }
  
  protected void bGK()
  {
    this.jdField_a_of_type_Yja = new yja(this.app, this.jdField_a_of_type_Yjh, this.app.getApp(), this.jdField_b_of_type_ComTencentWidgetXPanelContainer, this.qm, this.sessionInfo, this.jdField_a_of_type_Wki);
    yjc localyjc = new yjc(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.mActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.app, this.sessionInfo, this.jdField_a_of_type_Yjh, this.mActivity, this.uiHandler);
    this.jdField_a_of_type_Yif = new yif(this.app, this.jdField_a_of_type_Yjh, this.app.getApp(), this.sessionInfo, this.uiHandler);
    new SougouInputGrayTips(this.app, this.jdField_a_of_type_Yjh, this.mContext, this.sessionInfo);
    yiq localyiq = new yiq(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo, this.jdField_a_of_type_Wki);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo);
    yia localyia = new yia(this.app, this.jdField_a_of_type_Yjh, this.mActivity);
    this.jdField_a_of_type_Yiu = new yiu(this);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yja);
    this.jdField_a_of_type_Yjh.a(localyjc);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yif);
    this.jdField_a_of_type_Yjh.a(localyia);
    this.jdField_a_of_type_Yjh.a(localyiq);
    this.jdField_a_of_type_Yjh.a(localVipSpecialCareGrayTips);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yiu);
  }
  
  protected void bGL()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showAddFriendAndShield() ==== called.");
    }
    String str = this.sessionInfo.aTl;
    if (this.sessionInfo.cZ == 1006) {
      str = this.sessionInfo.aTo;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label247:
    View localView;
    if (this.linearLayout == null)
    {
      ujf localujf = new ujf(this);
      this.linearLayout = new LinearLayout(this.mContext);
      this.linearLayout.setId(2131362563);
      this.linearLayout.setVisibility(8);
      this.linearLayout.setOrientation(0);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297318));
      localLayoutParams.addRule(3, 2131377361);
      if (this.aey)
      {
        localLayoutParams.topMargin -= wja.dp2px(3.0F, this.app.getApplication().getResources());
        this.CA = new DrawableCenterTextView(this.mContext);
        if ((this.sessionInfo.cZ != 1006) || ((this.sessionInfo.aTo != null) && (!this.sessionInfo.aTo.equals("")))) {
          break label856;
        }
        this.CA.setEnabled(false);
        this.CA.setClickable(false);
        this.CA.setTextSize(0, this.app.getApplication().getResources().getDimension(2131296477));
        this.CA.setCompoundDrawablePadding(wja.dp2px(8.0F, this.app.getApplication().getResources()));
        this.CA.setOnClickListener(localujf);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams1.weight = 1.0F;
        localView = new View(this.mContext);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
        this.CB = new DrawableCenterTextView(this.mContext);
        this.CB.setText(this.mContext.getString(2131690100));
        this.CB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131296477));
        if (!this.aey) {
          break label875;
        }
        localObject = this.mContext.getResources().getDrawable(2130838043);
        label420:
        this.CB.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        this.CB.setCompoundDrawablePadding(wja.dp2px(8.0F, this.mContext.getResources()));
        this.CB.setContentDescription(this.CB.getText());
        this.CB.setOnClickListener(localujf);
        this.CB.setTag(Integer.valueOf(3));
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        if (!this.aey) {
          break label893;
        }
        localView.setBackgroundColor(Color.parseColor("#FFD9D9D9"));
        this.CA.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838374));
        this.CB.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838374));
        this.CA.setTextColor(-16777216);
        this.CB.setTextColor(-16777216);
        label584:
        this.linearLayout.addView(this.CA, localLayoutParams1);
        this.linearLayout.addView(localView, localLayoutParams2);
        this.linearLayout.addView(this.CB, (ViewGroup.LayoutParams)localObject);
        this.cL.addView(this.linearLayout, localLayoutParams);
      }
    }
    else
    {
      if (!this.aey) {
        break label1000;
      }
    }
    label856:
    label1000:
    for (Object localObject = this.app.getApplication().getResources().getDrawable(2130838375);; localObject = this.app.getApplication().getResources().getDrawable(2130838378))
    {
      boolean bool = ChatActivityUtils.e(this.app, this.sessionInfo);
      if (bool)
      {
        localObject = this.app.getApplication().getResources().getDrawable(2130838068);
        this.CA.setText(this.app.getApplication().getResources().getString(2131720349));
        this.CA.setTag(Integer.valueOf(4));
      }
      this.CA.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      Q(bool, str);
      this.linearLayout.setVisibility(0);
      if (this.rz != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
        int j = (int)this.mActivity.getResources().getDimension(2131297318) + (int)this.mActivity.getResources().getDimension(2131299627);
        int i = j;
        if (this.aey) {
          i = j - wja.dp2px(3.0F, this.app.getApplication().getResources());
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        this.rz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      localLayoutParams.topMargin = 0;
      break;
      this.CA.setEnabled(true);
      this.CA.setClickable(true);
      break label247;
      label875:
      localObject = this.mContext.getResources().getDrawable(2130838046);
      break label420;
      label893:
      this.CA.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838373));
      this.CB.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838373));
      localView.setBackgroundColor(this.mContext.getResources().getColor(2131166713));
      this.CA.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167375));
      this.CB.setTextColor(this.mContext.getResources().getColorStateList(2131167375));
      break label584;
    }
  }
  
  protected void bGO()
  {
    if (this.linearLayout != null) {
      this.linearLayout.setVisibility(8);
    }
    int i;
    if (this.rz != null)
    {
      i = (int)this.mActivity.getResources().getDimension(2131299627);
      if (!this.aey) {
        break label89;
      }
      i -= wja.dp2px(3.0F, this.app.getApplication().getResources());
    }
    label89:
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.rz.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void bGP()
  {
    if (OL())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      bGL();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    bGO();
  }
  
  protected void bGQ()
  {
    aqmq.track(null, "AIO_apolloFooterview");
    this.sessionInfo.cZ = this.mActivity.getIntent().getIntExtra("uintype", -1);
    int j;
    if (((this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 0) || ((this.sessionInfo.cZ == 3000) && (1 == abhh.ce("discuss")))) && (abhh.bCA) && (1 == ((abhh)this.app.getManager(153)).cd(this.app.getCurrentUin())) && (!((HotChatManager)this.app.getManager(60)).kj(this.sessionInfo.aTl)) && (!abrj.S(this.app)) && (abrj.f(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl)))
    {
      j = SpriteUIHandler.an(this.mContext);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, new Object[] { "add apollo footerview on init UI, footerHeight:", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      if (i > 0) {
        this.jdField_a_of_type_Wnc.c(i, false, "initUI", 0);
      }
      aqmq.track("AIO_apolloFooterview", null);
      return;
    }
  }
  
  protected void bGR() {}
  
  protected void bGS() {}
  
  protected void bGT()
  {
    this.ps.setVisibility(8);
  }
  
  protected void bGU()
  {
    this.jdField_a_of_type_Wsr = a();
  }
  
  protected void bGV()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.mSourceMsgInfo = null;
    this.jdField_a_of_type_Aiyx = aiyx.a(this.app);
    this.aSr = true;
    ThreadManager.post(new GetTextDraftJob(this.uiHandler, this.sessionInfo, this.jdField_a_of_type_Aiyx, this.app, this), 8, null, true);
  }
  
  protected void bGW() {}
  
  public void bGX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
      this.uiHandler.removeMessages(67);
    }
    if (this.jdField_a_of_type_Abin != null) {
      this.jdField_a_of_type_Abin.DF(true);
    }
    bIe();
    if (this.jdField_a_of_type_Afoc != null) {
      this.jdField_a_of_type_Afoc.dba();
    }
    ((wxa)a(14)).ccS();
  }
  
  public void bGY()
  {
    if ((aqft.rj(this.sessionInfo.aTl)) && (aqft.bK(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.aTl);
    localIntent.putExtra("uinname", this.sessionInfo.aTn);
    localIntent.putExtra("uintype", this.sessionInfo.cZ);
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void bGZ()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851145, 2130851146);
  }
  
  public void bHA()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "return MainFragment");
    }
    Object localObject;
    FragmentTransaction localFragmentTransaction;
    if ((this.mActivity instanceof SplashActivity))
    {
      localObject = this.mActivity.getSupportFragmentManager();
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      localFragmentTransaction.setCustomAnimations(2130772096, 2130772091);
      SplashActivity.bKT = 1;
      this.mActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localFragment != null)
      {
        localFragmentTransaction.show(localFragment);
        localFragmentTransaction.hide((Fragment)localObject);
        if ((localObject != null) && (((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
        {
          if ((!this.sessionInfo.beq) || (!this.sessionInfo.bes) || (this.sessionInfo.isNightMode)) {
            break label199;
          }
          ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
        label164:
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      anoz.a().traceEnd("ChatFragment");
      return;
      localFragmentTransaction.add(16908290, MainFragment.a(), MainFragment.class.getName());
      break;
      label199:
      if ((this.sessionInfo.ber) && (this.sessionInfo.bet) && (!this.sessionInfo.isNightMode))
      {
        ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        break label164;
      }
      ((ChatFragment)localObject).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
      break label164;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 4, "returnMainFragment() mActivity instanceof ChatActivity ");
      }
    }
  }
  
  protected void bHB()
  {
    try
    {
      if (this.baS == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        localIntentFilter.addAction("com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE");
        this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
        this.baS = 1;
      }
      for (;;)
      {
        AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this);
        QLog.d(this.TAG, 1, "AIOTime doOnRegReceivershashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "registerReceiver but done");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "registerReceiver " + localException);
        }
      }
    }
  }
  
  protected void bHC()
  {
    try
    {
      if (this.baS == 1)
      {
        this.mContext.unregisterReceiver(this.mReceiver);
        this.baS = 0;
      }
      for (;;)
      {
        boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
        QLog.d(this.TAG, 1, "AIOTime doOnUnRegReceivers :" + bool + "hashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "unRegisterReceiver but cannot");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "unregisterReceiver:" + localException);
        }
      }
    }
  }
  
  protected void bHD()
  {
    ThreadManager.post(new BaseChatPie.37(this), 8, null, true);
  }
  
  public void bHE()
  {
    if (this.aSC) {}
    do
    {
      do
      {
        return;
      } while ((this.bEk == 0) || (this.jdField_a_of_type_Wki == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null));
      this.aSB = false;
    } while (TextUtils.isEmpty(this.sessionInfo.aTl));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    List localList1 = this.jdField_a_of_type_Wki.getList();
    int k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int n = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i = this.bEk & 0xFFFF0000;
    List localList2 = f(localList1, i);
    int i1 = this.bEg;
    int i2 = localList1.size();
    int j = localList2.size();
    k = a(localList1, localList2, k, m - n, i1, i2, j, eJ(this.bEk & 0xFFFF));
    this.bEk = 0;
    this.lastRefreshTime = SystemClock.uptimeMillis();
    this.bEg = k;
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "refreshListAdapter, read count: " + this.bEg + " newsize " + j);
    }
    switch (i)
    {
    }
    for (;;)
    {
      ((wun)this.jdField_a_of_type_Wvm.a(65)).cch();
      if ((k == j) && (!((aavt)a(4)).isSelected())) {
        this.jdField_a_of_type_Wki.bYX();
      }
      wsd.a().gi(localList2);
      return;
      if (this.aSt)
      {
        this.jdField_a_of_type_Yjh.h(1001, new Object[0]);
        this.aSt = false;
      }
    }
  }
  
  void bHF()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount() - 1);
    }
  }
  
  protected void bHH()
  {
    wyv.Da(2);
    ArkFlashChatContainerWrapper.Da(2);
    aqfp.Sz(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.pause();
    ((AvatarPendantManager)this.app.getManager(46)).eeN();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void bHJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_Wki.notifyDataSetChanged();
  }
  
  public void bHK()
  {
    Object localObject = new TextView(this.mContext);
    ((TextView)localObject).setId(2131372041);
    ((TextView)localObject).setBackgroundResource(2130838460);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setPadding(0, (int)(2.0F * this.mDensity + 0.5F), 0, 0);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 16.0F);
    ((TextView)localObject).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(2, 2131369277);
    localLayoutParams.addRule(11);
    localLayoutParams.bottomMargin = ((int)(this.mDensity * 10.0F + 0.5F));
    localLayoutParams.rightMargin = ((int)(this.mDensity * 10.0F + 0.5F));
    this.fs.addView((View)localObject, localLayoutParams);
    this.Cy = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    if (this.rz != null) {
      this.fs.bringChildToFront(this.rz);
    }
    if (this.rE != null) {
      ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, 2131372041);
    }
    localObject = (wxo)a(53);
    ((wxo)localObject).w(this.Cy);
    ((wxo)localObject).CZ(this.bEh);
  }
  
  protected void bHM()
  {
    if (this.aSX)
    {
      bGK();
      this.aSX = false;
    }
    ((wjw)this.app.getManager(218)).bYw();
  }
  
  protected void bHP()
  {
    bIL();
    awsw.a(BaseApplicationImpl.getContext(), new BaseChatPie.54(this), null);
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {
      QLog.e(this.TAG, 1, "onShow_otherThings: intent == null");
    }
    String str;
    do
    {
      return;
      boolean bool = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onShow_otherThings, isPhotoPlusEditSend = " + bool);
      }
      if (bool)
      {
        localIntent.removeExtra("PhotoConst.SEND_FLAG");
        xro.a(this.mActivity, this.sessionInfo, localIntent);
        if (this.aSM) {
          bIR();
        }
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.55(this));
      this.app.a().ezW();
      this.uiHandler.sendEmptyMessageDelayed(31, 800L);
      bHR();
      aqgm.ez(this.app);
      adxn.a().t(this.app, 0);
      SignatureManager.a(this.app, this.sessionInfo.aTl, null);
      bi(BaseApplication.getContext(), "com.vivo.smartshot");
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "isvivo has shot" + bEs);
      }
      if (!DeviceProfileManager.isInited) {
        bHQ();
      }
      wja.a(this.app, this, this.jdField_a_of_type_Wki, null);
      wja.i(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), 0, 0);
      wja.i(this.pq, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
      str = localIntent.getStringExtra("panel");
    } while ((str == null) || (!str.equals("ptv")));
    bID();
    localIntent.removeExtra("panel");
  }
  
  protected void bHS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    if (!this.aSk) {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "initAndQueryFastImage return!,  mAllowFastImage = " + this.aSk);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.mActivity.getLayoutInflater().inflate(2131558653, null));
        this.s = new RelativeLayout.LayoutParams(-2, -2);
        this.s.addRule(2, 2131369277);
        this.s.addRule(7, 2131369277);
        this.s.rightMargin = ((int)(10.5D * this.mDensity + 0.5D));
        this.s.bottomMargin = ((int)(4.0F * this.mDensity + 0.5F));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131362404);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.uiHandler);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.dbp();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
  }
  
  @TargetApi(11)
  protected void bHV()
  {
    if (isFullScreenMode()) {
      vV(false);
    }
    if (this.app.b().oA() == null) {}
    do
    {
      apsw.e locale;
      do
      {
        return;
        locale = ((apsw)this.app.getManager(48)).a(this.sessionInfo.aTl, true);
      } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
      Object localObject = (wvd)this.jdField_a_of_type_Wvm.a(24);
      ((wvd)localObject).a.setVisibility(8);
      if (this.Cx == null)
      {
        TextView localTextView = new TextView(this.mContext);
        localTextView.setId(2131367831);
        localTextView.setBackgroundResource(2130850843);
        localTextView.setTextSize(1, 17.0F);
        localTextView.setTextColor(this.mContext.getResources().getColor(2131167285));
        localTextView.setEnabled(false);
        localTextView.setGravity(17);
        int i = ((ViewGroup)((wvd)localObject).l.getParent()).indexOfChild(((wvd)localObject).l);
        localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth(), -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(14.0F, a().getResources());
        ((LinearLayout.LayoutParams)localObject).gravity = 80;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(localTextView, i, (ViewGroup.LayoutParams)localObject);
        this.Cx = localTextView;
      }
      if (locale != null)
      {
        if (this.Cx != null)
        {
          QLog.d(this.TAG, 1, "fightgag.doDisableInputStat text" + locale.buttonText);
          this.Cx.setText(locale.buttonText);
        }
        if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) {
          this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        }
      }
      if (this.Cx != null) {
        this.Cx.setVisibility(0);
      }
      if (this.Cw != null) {
        this.Cw.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      vS(false);
      zM(3);
      if (VersionUtils.isHoneycomb())
      {
        if (!ThemeUtil.isInNightMode(this.app)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 0.6F);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
      }
      this.bEl = 2;
      bIX();
    } while (this.jdField_a_of_type_Abin == null);
    this.jdField_a_of_type_Abin.DF(false);
  }
  
  @TargetApi(11)
  protected void bHX()
  {
    if (this.bEl == 1) {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.bEl != 2) {
              break;
            }
          } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
        } while (!VersionUtils.isHoneycomb());
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        return;
      } while (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
    } while (!VersionUtils.isHoneycomb());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
  }
  
  public void bHY()
  {
    String str = this.mContext.getString(2131689842);
    aqha.a(this.mContext, 230, null, str, 2131693342, 2131693341, new uis(this), new uit(this)).show();
  }
  
  protected void bHZ()
  {
    this.app.addObserver(this.cardObserver);
    this.app.addObserver(this.jdField_c_of_type_Acfd);
    this.app.addObserver(this.jdField_b_of_type_Accz);
    this.app.a(this);
    this.app.a(this);
    this.app.a().addObserver(this.jdField_b_of_type_Aghq);
    this.app.b().addObserver(this);
    this.app.a().addObserver(this.jdField_a_of_type_Inh);
    this.app.addObserver(this.jdField_a_of_type_Acea);
    this.app.addObserver(this.jdField_a_of_type_Aqrd);
    this.app.addObserver(this.jdField_a_of_type_Acbh);
    this.app.addObserver(this.jdField_a_of_type_Aclr);
    this.jdField_a_of_type_Ahxs$a = new ahxs.a(a());
    this.app.addObserver(this.jdField_a_of_type_Ahxs$a);
    this.jdField_a_of_type_Ahxs$b = new ahxs.b(a());
    this.app.addObserver(this.jdField_a_of_type_Ahxs$b);
    this.jdField_a_of_type_Ahxg$a = new ahxg.a(this);
    this.app.addObserver(this.jdField_a_of_type_Ahxg$a);
    this.app.addObserver(this.jdField_a_of_type_Augb);
    this.app.addObserver(this.jdField_a_of_type_Aupd);
    this.app.addObserver(this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver);
  }
  
  protected void bHa()
  {
    this.sessionInfo.aTn = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
  }
  
  public void bHb()
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(this.mContext, 2131755365);
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setBackgroundResource(2130838161);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    try
    {
      if (!this.mActivity.isFinishing()) {
        this.jdField_c_of_type_AndroidAppDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.TAG, 1, "showPttMaskDialog", localException);
    }
  }
  
  public void bHd()
  {
    ((wtk)this.jdField_a_of_type_Wvm.a(54)).cbH();
  }
  
  public void bHf()
  {
    An(8);
    bJe();
  }
  
  public void bHg()
  {
    if (this.aSM) {
      An(0);
    }
  }
  
  public void bHs()
  {
    Intent localIntent = this.mActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", acgr.y(this.app, str));
      this.mActivity.setResult(-1, localIntent);
    }
  }
  
  protected void bHt()
  {
    aqmq.track(null, "AIO_doOnResume_updateUI");
    ((www)a(29)).v(this.Cr);
    wyv.Da(1);
    ArkFlashChatContainerWrapper.Da(1);
    bHw();
    if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onResume();
    }
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0)) {
      this.bEv = 0;
    }
    if ((this.jdField_b_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (vo() <= 0)) {
        break label340;
      }
    }
    label340:
    for (boolean bool = true;; bool = false)
    {
      vS(bool);
      aqmq.track("AIO_doOnResume_updateUI", null);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rz.getLayoutParams();
      int j = (int)this.mActivity.getResources().getDimension(2131299627);
      int i = j;
      if (this.linearLayout != null)
      {
        i = j;
        if (this.linearLayout.getVisibility() == 0) {
          i = j + (int)this.mActivity.getResources().getDimension(2131297318);
        }
      }
      j = i;
      if (this.aey) {
        j = i - wja.dp2px(3.0F, this.app.getApplication().getResources());
      }
      localLayoutParams.topMargin = j;
      this.rz.setLayoutParams(localLayoutParams);
      bIM();
      this.jdField_a_of_type_Wvm.CS(5);
      if (OI())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDebugTag("AIO." + this.sessionInfo.cZ + "." + MsfSdkUtils.getShortUin(this.sessionInfo.aTl));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
      }
      if (this.jdField_a_of_type_Wsr != null) {
        this.jdField_a_of_type_Wsr.onResume();
      }
      return;
    }
  }
  
  public void bHw()
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.RS()) && (localAIOLongShotHelper.RT()))
    {
      QLog.i(this.TAG, 1, "loadBackgroundAsync: skip for mosaic is on");
      return;
    }
    ThreadManager.postImmediately(new BaseChatPie.25(this), null, true);
  }
  
  protected void bHy()
  {
    aqjc.edW();
    this.jdField_a_of_type_Wvm.CS(20);
    wja.yn(false);
    this.aSC = false;
    this.aSB = false;
    this.aL = false;
    this.du = true;
    this.aSm = true;
    this.bEi = 0;
    this.aM = false;
    this.aSn = false;
    this.aSo = false;
    this.aex = false;
    this.aSq = false;
    this.aSr = false;
    this.aSs = false;
    this.aSt = false;
    this.aSu = false;
    this.aSv = true;
    this.aSw = true;
    this.aSy = false;
    this.U = Boolean.valueOf(false);
    this.aSK = false;
    this.aSV = true;
    this.aSW = false;
    this.aSX = true;
    this.aSA = true;
    this.aSc = true;
    this.aSd = false;
    this.aSe = false;
    this.aSh = false;
    this.aSE = false;
    if (this.f != null)
    {
      this.f.removeAllViews();
      this.A = null;
      this.rD = null;
    }
    if (this.jdField_a_of_type_Yjh != null) {
      this.jdField_a_of_type_Yjh.ciA();
    }
    if ((this.linearLayout != null) && (this.fs != null))
    {
      this.linearLayout.removeAllViews();
      this.fs.removeView(this.linearLayout);
      this.linearLayout = null;
      this.CA = null;
      this.CB = null;
    }
    if (this.rE != null)
    {
      this.rE.setVisibility(4);
      this.rE = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) && (this.fs != null))
    {
      this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.exR();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.reset();
    }
    this.Fr = 0L;
    this.aSF = false;
    this.aSG = true;
    if ((this.jdField_a_of_type_Afdw != null) && (this.jdField_a_of_type_Afdw.iF != null) && (this.fs != null))
    {
      this.fs.removeView(this.jdField_a_of_type_Afdw.iF);
      this.jdField_a_of_type_Afdw.cYA();
    }
    bzx();
  }
  
  public void bID()
  {
    wf(false);
  }
  
  public void bIE()
  {
    if (this.jdField_a_of_type_Afef != null) {
      this.jdField_a_of_type_Afef.clearViews();
    }
  }
  
  protected void bIF()
  {
    if (this.rH == null)
    {
      this.rH = new View(this.mActivity);
      this.u = new RelativeLayout.LayoutParams(-1, (int)(12.0F * this.mDensity + 0.5F));
      this.u.addRule(6, 2131369277);
      this.rH.setId(2131362403);
      if (this.fs != null) {
        this.fs.addView(this.rH, this.u);
      }
    }
    this.rH.setVisibility(0);
    this.rH.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      aqcl.Q(this.rH, false);
    }
  }
  
  protected void bIG()
  {
    if (this.rG == null)
    {
      this.rG = new View(this.mActivity);
      this.t = new RelativeLayout.LayoutParams(-1, (int)(15.0F * this.mDensity + 0.5F));
      this.t.addRule(3, 2131369277);
      this.rG.setId(2131362402);
      if (this.fs != null) {
        this.fs.addView(this.rG, this.t);
      }
    }
    this.rG.setVisibility(0);
    this.rG.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      aqcl.Q(this.rG, false);
    }
  }
  
  public void bIH() {}
  
  public void bII()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.zC(true);
      hidePanel();
    }
  }
  
  public void bIK()
  {
    if ((this.d != null) && (this.d.isHeld()))
    {
      this.d.release();
      this.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "cancelRemainScreenOn");
    }
  }
  
  public void bIL()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.bIL();
  }
  
  protected void bIM()
  {
    if ((this.sessionInfo == null) || (this.mContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e(this.sessionInfo);
    } while (!this.aSl);
    if (this.Cy != null) {
      this.Cy.setVisibility(8);
    }
    this.Cs.setVisibility(8);
  }
  
  public void bIN()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    this.mSourceMsgInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.zC(false);
    }
    if (vm() == 28) {
      hideAllPanels();
    }
    ((wvd)this.jdField_a_of_type_Wvm.a(24)).ccr();
  }
  
  public void bIO()
  {
    int j;
    Object localObject;
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
      {
        j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localObject = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localObject != null) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 0;; i = ((View)localObject).getTop())
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(j, i);
      if (this.rF == null)
      {
        this.rF = new View(this.mContext);
        this.rF.setId(2131374808);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.rF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.rF.getParent() == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.rF, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Wki);
        refresh(196608);
      }
      return;
    }
  }
  
  public void bIP()
  {
    int i = 0;
    int j;
    View localView;
    if ((this.rF != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
      {
        j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localView = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localView != null) {
          break label88;
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(j, i);
      if (this.rF != null) {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeFooterView(this.rF);
      }
      this.rF = null;
      refresh(196608);
      return;
      label88:
      i = localView.getTop();
    }
  }
  
  protected void bIQ() {}
  
  public void bIR()
  {
    String str1;
    if ((!this.aSM) && (altg.Z(this.app) <= 0))
    {
      str1 = a().getString(2131700663);
      QQToast.a(a(), str1, 0).show(a().getResources().getDimensionPixelSize(2131299627));
      anot.a(this.app, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    int i;
    if (!this.aSM)
    {
      bool = true;
      this.aSM = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        vT(true);
      }
      bHd();
      if (!this.aSM) {
        break label587;
      }
      if ((this.rC != null) && (this.rC.getVisibility() == 0)) {
        bIX();
      }
      bIQ();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.zx(true);
      An(0);
      i = altg.Z(this.app);
      str1 = String.valueOf(i);
      if (i >= 4) {
        break label551;
      }
      String str2 = String.format(a().getString(2131700678), new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131167425)), str2.length() - str1.length() - 2, str2.length() - 2, 18);
      this.Cz.setText(localSpannableString);
      label290:
      i = BaseApplicationImpl.getContext().getResources().getColor(2131167426);
      this.Cz.setTextColor(i);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374473, null);
      abrb.b(this.app, "receipt_msg", true);
      bIf();
      if (this.sessionInfo.cZ != 0) {
        break label564;
      }
      i = 1;
      label360:
      anot.a(this.app, "CliOper", "", "", "0x80083E8", "0x80083E8", i, 0, "", "", "", "");
      label396:
      wk(this.aSM);
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYY = this.aSM;
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZc = this.aSM;
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bYZ = this.aSM;
        if (!this.aSM) {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.bZa = true;
        }
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.app, this.sessionInfo.cZ, this.mContext, getTitleBarHeight(), this.aLB, this.bED, this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
      {
        this.aSO = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = null;
      }
      zM(1);
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (vo() <= 0)) {
        break label644;
      }
    }
    label644:
    for (boolean bool = true;; bool = false)
    {
      vS(bool);
      return;
      bool = false;
      break;
      label551:
      this.Cz.setText(2131700677);
      break label290;
      label564:
      if (this.sessionInfo.cZ == 3000)
      {
        i = 2;
        break label360;
      }
      i = 3;
      break label360;
      label587:
      hideAllPanels();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.app, this.sessionInfo, this);
      An(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      this.fs.post(new BaseChatPie.89(this));
      break label396;
    }
  }
  
  public void bIS()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.stop(true);
      aF(false, false);
    }
  }
  
  public void bIT()
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(18);
  }
  
  public void bIU()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
    }
  }
  
  public void bIV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
    }
    if (this.jdField_a_of_type_Abin != null) {
      this.jdField_a_of_type_Abin.DF(true);
    }
    bIe();
    if (this.jdField_a_of_type_Afoc != null) {
      this.jdField_a_of_type_Afoc.dba();
    }
  }
  
  public void bIX()
  {
    if ((this.mActivity != null) && (this.rC != null) && (this.rC.getVisibility() == 0))
    {
      this.ad.setImageResource(2130838164);
      this.rC.setVisibility(8);
      this.ahi = false;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), wja.dp2px(11.0F, this.mActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
    }
  }
  
  public void bIY() {}
  
  public void bIZ()
  {
    if ((this.rC != null) && (this.ahi))
    {
      ykm.a(this.app).ciX();
      this.ad.setImageResource(2130838164);
      this.ad.setActivated(false);
      this.ahi = false;
    }
  }
  
  protected void bIa()
  {
    if (this.app == null) {
      return;
    }
    this.app.removeObserver(this.cardObserver);
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app.removeObserver(this.jdField_b_of_type_Accz);
    this.app.a(null);
    this.app.a(null);
    this.app.a().deleteObserver(this.jdField_b_of_type_Aghq);
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    this.app.a().deleteObserver(this.jdField_a_of_type_Inh);
    this.app.removeObserver(this.jdField_a_of_type_Acea);
    this.app.removeObserver(this.jdField_a_of_type_Aqrd);
    this.app.removeObserver(this.jdField_a_of_type_Acbh);
    this.app.removeObserver(this.jdField_a_of_type_Aclr);
    if (this.jdField_a_of_type_Ahxs$a != null) {
      this.app.removeObserver(this.jdField_a_of_type_Ahxs$a);
    }
    if (this.jdField_a_of_type_Ahxs$b != null) {
      this.app.removeObserver(this.jdField_a_of_type_Ahxs$b);
    }
    this.app.removeObserver(this.jdField_a_of_type_Ahxg$a);
    this.app.removeObserver(this.jdField_a_of_type_Augb);
    this.app.removeObserver(this.jdField_a_of_type_Aupd);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver);
  }
  
  public void bIb()
  {
    wwn localwwn = null;
    if (isFullScreenMode()) {
      vV(false);
    }
    if (this.sessionInfo.beA)
    {
      BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, true);
      this.bEk = 131075;
      refresh(this.bEk);
      return;
    }
    wvd localwvd = (wvd)this.jdField_a_of_type_Wvm.a(24);
    ahwb.dqA();
    int i;
    label89:
    int j;
    label104:
    MixedMsgInfo localMixedMsgInfo;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.wz();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null) {
        break label311;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.wA();
      if ((localwvd.isEmpty()) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (i + j <= 0)) {
        break label314;
      }
      localMixedMsgInfo = localwvd.a();
      if (localMixedMsgInfo != null) {
        break label316;
      }
      localObject1 = "";
      label149:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label325;
      }
    }
    label311:
    label314:
    label316:
    label325:
    for (Object localObject3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; localObject3 = localObject1)
    {
      LogcatUtil.uC((String)localObject3);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374473) == null) {
        this.mSourceMsgInfo = null;
      }
      localObject2 = localwwn;
      if (this.mSourceMsgInfo != null)
      {
        localObject2 = localwwn;
        if (!TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName)) {
          localObject2 = ((alvj)this.app.getManager(340)).d(this.mSourceMsgInfo.getUniSeq());
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.mSourceMsgInfo != null) {
          localObject1 = yfp.c(this.app, this.sessionInfo, this.mSourceMsgInfo);
        }
      }
      akxo.NQ((String)localObject3);
      if (((String)localObject3).length() <= bEA) {
        break label331;
      }
      ChatActivityUtils.h(this.mContext, 2131719509, 1);
      return;
      i = 0;
      break label89;
      j = 0;
      break label104;
      break;
      localObject1 = localMixedMsgInfo.xi();
      break label149;
    }
    label331:
    Object localObject2 = new ujt.d();
    a((ujt.d)localObject2);
    ahwv.a(this).ciK = false;
    ((ujt.d)localObject2).aSL = this.aSL;
    this.aSL = false;
    localwwn = (wwn)a(27);
    if (localwwn != null) {
      localwwn.a((String)localObject3, (ujt.d)localObject2, 0);
    }
    if ((this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject1 = d((MessageRecord)localObject1);
    }
    for (localObject2 = a(localwvd, i, j, localMixedMsgInfo, (MessageRecord)localObject1, (ujt.d)localObject2);; localObject2 = b(localwvd, i, j, localMixedMsgInfo, (MessageRecord)localObject1, (ujt.d)localObject2))
    {
      a((String)localObject2, false, this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.app);
      bIN();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      eR(this.sessionInfo.entrance, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_Yjh.h(1002, new Object[] { localObject2 });
      if (this.app.getApplication().getResources().getConfiguration().orientation == 2) {
        anot.a(this.app, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
      }
      xmb.a(this.app, (MessageRecord)localObject1, "0X800A369");
      ((wvo)a(39)).ccu();
      ajcy.fa("0X800AE1B", localwvd.getPicCount() + i);
      return;
    }
  }
  
  public void bIc()
  {
    ((wun)this.jdField_a_of_type_Wvm.a(65)).bIc();
  }
  
  public void bId() {}
  
  public void bIe()
  {
    wur localwur = (wur)this.jdField_a_of_type_Wvm.a(52);
    if (localwur != null) {
      localwur.bIe();
    }
  }
  
  public void bIf()
  {
    wur localwur = (wur)this.jdField_a_of_type_Wvm.a(52);
    if (localwur != null) {
      localwur.bIf();
    }
  }
  
  public void bIg()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightToStr(acfp.m(2131703094), new uje(this));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    aily.f(this.app, a().getIntent());
    a(true, null, false, true);
  }
  
  public void bIh()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    if (this.rG != null) {
      this.rG.setVisibility(8);
    }
    if (this.rH != null) {
      this.rH.setVisibility(8);
    }
  }
  
  protected void bIi()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.sessionInfo.a != null) {
        if ((!"".equals(this.sessionInfo.a.path)) && (!"null".equals(this.sessionInfo.a.path))) {
          break label368;
        }
      }
    }
    label221:
    label368:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.iX + ", sessionInfo.chatBg.path=" + this.sessionInfo.a.path);
      }
      if ((this.iX != null) && (QLog.isColorLevel()))
      {
        if (this.iX.getVisibility() == 0) {
          QLog.d(this.TAG, 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label313;
        }
        if ((this.iX == null) || (this.iX.getVisibility() != 0)) {
          break label221;
        }
      }
      do
      {
        do
        {
          return;
          if (this.iX.getVisibility() == 4)
          {
            QLog.d(this.TAG, 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
            break;
          }
          QLog.d(this.TAG, 2, "#handleNightMask# : mMask getVisibility = GONE");
          break;
          if (this.iX == null)
          {
            this.iX = new View(this.mContext);
            this.iX.setBackgroundColor(1996488704);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(6, 2131370537);
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
            this.iX.setLayoutParams(localLayoutParams);
            this.fs.addView(this.iX);
            return;
          }
          this.iX.setVisibility(0);
          return;
        } while (this.iX == null);
        this.fs.removeView(this.iX);
        this.iX = null;
        return;
      } while ((this.iX == null) || (this.fs == null));
      this.fs.removeView(this.iX);
      this.iX = null;
      return;
    }
  }
  
  public void bIk()
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(21);
      if ((this.app != null) && (this.sessionInfo != null))
      {
        abhh localabhh = (abhh)this.app.getManager(153);
        if ((localabhh.cd(this.app.getCurrentUin()) == 0) || (localabhh.cd(this.app.getCurrentUin()) == 2)) {
          VipUtils.a(this.app, "cmshow", "Apollo", "panel_close_show", localabhh.cd(this.app.getCurrentUin()), ApolloUtil.gp(abhh.x(this.app)), new String[] { "" + ApolloUtil.gi(this.sessionInfo.cZ) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.Af();
          if (i != -1) {
            VipUtils.a(this.app, "cmshow", "Apollo", "game_show", ApolloUtil.gi(this.sessionInfo.cZ), 0, new String[] { Integer.toString(i) });
          }
        }
      }
    }
  }
  
  public void bIl()
  {
    ujt.d(this.app, BaseApplicationImpl.getContext(), this.sessionInfo);
  }
  
  public void bIm()
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(30);
  }
  
  public void bIo()
  {
    if ((this.sessionInfo == null) || (this.aSh)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (acff)this.app.getManager(51);
          if ((this.sessionInfo.cZ != 3000) && (this.sessionInfo.cZ != 1)) {
            break;
          }
          localObject = ((acff)localObject).a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
        } while ((localObject == null) || (!((NoC2CExtensionInfo)localObject).isDataChanged));
        ThreadManager.getFileThreadHandler().post(new SaveInputTypeTask((Entity)localObject, this.app));
        return;
      } while (!OW());
      localObject = ((acff)localObject).a(this.sessionInfo.aTl, false);
    } while ((localObject == null) || (!((ExtensionInfo)localObject).isDataChanged));
    ThreadManager.getFileThreadHandler().post(new SaveInputTypeTask((Entity)localObject, this.app));
  }
  
  public void bIp()
  {
    if (((aavt)a(4)).isSelected()) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Wki == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null));
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      j = this.jdField_a_of_type_Wki.getCount() - 1 + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() + this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (QLog.isColorLevel()) {
        QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue isScrollToButtom=" + this.aSK + "lastPosition=" + i + "toLast=" + j);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() != 0) || (i != j) || (!this.aSK));
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
    anot.a(this.app, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
  }
  
  public void bIq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.aSA = true;
  }
  
  public void bIr()
  {
    if (this.jdField_a_of_type_Yhz == null)
    {
      this.jdField_a_of_type_Yhz = new yhz(this.mActivity, this.jdField_a_of_type_Yjh);
      this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yhz);
    }
    this.jdField_a_of_type_Yhz.yI(this.sessionInfo.aTl);
  }
  
  public void bIs()
  {
    if (this.jdField_a_of_type_Acjz == null) {
      this.jdField_a_of_type_Acjz = new acjz(this.app.getAccount());
    }
  }
  
  public void bJa()
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 3)
    {
      View localView = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE();
      if (((localView instanceof EmoticonMainPanel)) && (localView.getVisibility() == 0)) {
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      }
    }
  }
  
  public void bJb()
  {
    int i = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (i != 1) && (i != 3))
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      aey();
    }
  }
  
  public void bJc()
  {
    if (this.f != null)
    {
      this.f.removeAllViews();
      this.A = null;
      this.rD = null;
    }
  }
  
  public void bJd()
  {
    String str;
    int i;
    Editable localEditable;
    if ((this.mTitleText != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      aurd.aO(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      str = this.mTitleText.getText().toString() + " ";
      i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      if ((i < 0) || (i >= localEditable.length())) {
        localEditable.append(str);
      }
    }
    else
    {
      return;
    }
    localEditable.insert(i, str);
  }
  
  public void bJe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.resetStatus();
    }
  }
  
  protected void bJf() {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      appb[] arrayOfappb = (appb[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, appb.class);
      if ((arrayOfappb != null) && (arrayOfappb.length > 0)) {
        anot.a(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 0, "", "", "", "");
      }
    }
    ((wwz)a(41)).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((wvd)this.jdField_a_of_type_Wvm.a(24)).f(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void bi(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "isPackageExist isVivoShot=" + bEs);
    }
    if (bEs != 0) {
      this.U = Boolean.valueOf(false);
    }
    for (;;)
    {
      return;
      String str = Build.MANUFACTURER.toUpperCase();
      if ((!str.endsWith("BBK")) && (!str.endsWith("VIVO")))
      {
        bEs = 2;
        return;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getApplicationInfo(paramString, 8192);
        bEs = 1;
        this.U = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vivo", 2, " isPackageExist isScrollToButtom=" + this.U);
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          bEs = 2;
        }
      }
    }
  }
  
  protected void bm(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    b(localIntent, false);
  }
  
  protected void bn(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130851761, 2130851762);
    this.jdField_a_of_type_Yjh.ciA();
    aG(true, false);
    bo(paramIntent);
    vU(false);
    bGR();
    this.aSh = ON();
    this.aSi = OM();
    bp(paramIntent);
    bt(paramIntent);
    bGZ();
    bGT();
    bGQ();
    bGU();
    this.aSm = true;
    this.bEi = 0;
    vY(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bn(paramIntent);
  }
  
  public void bo()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
    this.jdField_a_of_type_Xru.bo();
    if ((4 == this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.zC(false);
    }
    if (this.rG != null) {
      this.rG.setVisibility(0);
    }
    if (this.rH != null) {
      this.rH.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Adrl != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 22)) {
      this.jdField_a_of_type_Adrl.cUa();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.isHiden = true;
    }
  }
  
  protected void bo(Intent paramIntent)
  {
    aqmq.track(null, "AIO_updateSession_updateTitle");
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = aqgv.a(this.app, this.sessionInfo.aTl, this.sessionInfo.troopUin, aqgv.jZ(this.sessionInfo.cZ), 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateSession_updateTitle curFriendNick" + aqft.pk(paramIntent));
    }
    this.sessionInfo.aTn = paramIntent;
    if (this.sessionInfo.aTn != null)
    {
      this.mTitleText.setText(this.sessionInfo.aTn);
      if (AppSetting.enableTalkBack)
      {
        paramIntent = this.mTitleText.getText();
        this.mTitleText.setContentDescription(paramIntent);
        a().setTitle(this.mTitleText.getText());
      }
    }
    for (;;)
    {
      this.mTitleIcon.setVisibility(8);
      this.pt.setVisibility(8);
      aqmq.track("AIO_updateSession_updateTitle", null);
      return;
      QLog.e(this.TAG, 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
  }
  
  protected void bp()
  {
    int i = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      if (i == 1) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
    }
    else {
      return;
    }
    if (i == 21)
    {
      if (this.sessionInfo.cZ != 1) {
        break label195;
      }
      HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
      if ((localHotChatManager != null) && (localHotChatManager.kj(this.sessionInfo.aTl))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
        return;
        i = 0;
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
        return;
        if (i == 23)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i == 18)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i == 35)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i == 24)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i == 36)
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(2);
          return;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i);
        return;
        label195:
        i = 0;
      }
    }
  }
  
  public void br(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updateSession");
    }
    this.aSW = true;
    aqmq.track(null, "AIO_updateSession_initIntentData");
    bm(paramIntent);
    aqmq.track("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    bs(paramIntent);
    bn(paramIntent);
    aqmq.track("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    b(paramIntent, true);
    aqmq.track("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    bq(paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.app, this.sessionInfo, this);
    aqmq.track("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "AIOTime updateSession end");
    }
  }
  
  protected void bs(Intent paramIntent)
  {
    this.jdField_a_of_type_Wvm.CS(2);
  }
  
  protected void bt(Intent paramIntent)
  {
    boolean bool2 = true;
    Object localObject1 = paramIntent.getExtras();
    Object localObject3;
    Object localObject2;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.aL = true;
      bIL();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(acfp.m(2131703088));
      bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      if (!paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false)) {
        break label458;
      }
      this.aSe = true;
      localObject1 = null;
      if (!this.aSe) {
        break label595;
      }
      long l = System.currentTimeMillis();
      ThreadManagerV2.excute(new BaseChatPie.20(this), 32, null, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l));
      }
      localObject3 = paramIntent.getStringExtra("backName");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        this.Cr.setText((CharSequence)localObject3);
        bIL();
        localObject2 = paramIntent.getStringExtra("comicId");
        TextView localTextView = this.Cr;
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        localTextView.setTag(new String[] { "comic", paramIntent });
        this.Cr.setContentDescription("返回QQ动漫");
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "set left text from update left: " + (String)localObject1 + ", back: " + (String)localObject3);
      }
      if (ujs.aTl)
      {
        this.pp.setContentDescription(acfp.m(2131703065));
        if (!this.aSe)
        {
          localObject1 = this.Cr.getText().toString();
          paramIntent = (Intent)localObject1;
          if (!this.app.getApplication().getString(2131690700).equals(localObject1)) {
            paramIntent = acfp.m(2131703101) + (String)localObject1 + acfp.m(2131703067);
          }
          this.Cr.setContentDescription(paramIntent);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejF();
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.du) {
          break label642;
        }
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramIntent.bN(bool1, this.sessionInfo.cZ);
      return;
      if (localObject1 == null) {
        break;
      }
      this.aL = ((Bundle)localObject1).getBoolean("isBack2Root");
      if (!this.aL) {
        break;
      }
      bIL();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(acfp.m(2131703098));
      break;
      label458:
      if (bool1)
      {
        localObject1 = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (localObject1 == null) {}
        for (localObject1 = this.app.getApplication().getString(2131691039);; localObject1 = this.app.getApplication().getString(2131717859, new Object[] { localObject1 }))
        {
          this.aSe = false;
          break;
        }
      }
      localObject1 = paramIntent.getStringExtra("leftViewText");
      if ((this.aL) || ((localObject1 != null) && (((String)localObject1).contains(this.app.getApplication().getString(2131720735))))) {}
      for (bool1 = true;; bool1 = false)
      {
        this.aSe = bool1;
        if (this.aN) {
          this.aSe = true;
        }
        break;
      }
      label595:
      localObject3 = this.Cr;
      if (localObject1 == null) {}
      for (localObject2 = this.app.getApplication().getString(2131691039);; localObject2 = localObject1)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        bIL();
        break;
      }
    }
  }
  
  protected void bu(Intent paramIntent)
  {
    if (ForwardUtils.a(this.app, this.mActivity, this.mContext, paramIntent, this.uiHandler)) {
      this.aL = this.mActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  public void bzx()
  {
    if (this.jdField_a_of_type_Smx != null) {
      this.jdField_a_of_type_Smx.bzx();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "set left text from cancel");
    }
    this.aLA = this.Cr.getText().toString();
    this.Cr.setText(2131691040);
    this.Cr.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejF();
    }
    ((wub)a(66)).c(paramChatMessage);
    this.pp.setVisibility(4);
    this.ps.setVisibility(4);
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    if (localAIOLongShotHelper.RS())
    {
      localAIOLongShotHelper.showTitleBar();
      this.cJ.setVisibility(4);
      this.cK.setVisibility(4);
      this.mAIORootView.findViewById(2131369637).setVisibility(4);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
      a(true, paramChatMessage, false);
      return;
      this.mAIORootView.findViewById(2131369637).setVisibility(4);
    }
  }
  
  public void c(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(36);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.setParam(paramString, paramRecorderParam, paramInt, this.aLy);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.sendRequest();
    }
  }
  
  protected List<ChatMessage> cF()
  {
    return n(false);
  }
  
  protected void d(int paramInt, String paramString, long paramLong)
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
      ujt.a(this.app, this.sessionInfo, paramString, -3, paramLong);
      aG(true, true);
      return;
    }
    if (paramString != null)
    {
      paramString = anqo.getFile(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.uiHandler.hasMessages(16711688)) {
      this.uiHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L)
    {
      paramInt = this.sessionInfo.cZ;
      paramString = this.sessionInfo.aTl;
      this.app.b().t(paramString, paramInt, paramLong);
    }
    aG(true, false);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, 0, 0L, null);
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean4)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.SI(paramBoolean1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.isPlaying()) {
        return;
      }
    }
    this.du = paramBoolean3;
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.bM(this.app.getApp());
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.Rw()) {
      a(this.app.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.isPlaying()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label130;
      }
    }
    label130:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      aF(paramBoolean2, paramBoolean3);
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.SI(paramBoolean1);
      return;
    }
  }
  
  public void delete()
  {
    aofy.g(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  protected void dh(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374473);
      ThreadManager.post(new SaveTextDraftJob(this, this.sessionInfo, this.jdField_a_of_type_Aiyx, paramString1, paramString2, this.app, this.aLz, this.mSourceMsgInfo, localObject), 8, null, false);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    boolean bool = false;
    bGP();
    int i;
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      i = paramIntent.getIntExtra("camera_type", 1);
      bool = paramIntent.getExtras().getBoolean("progress2View");
      if ((paramInt1 == 11000) && (i == 103)) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, paramIntent, bool, i);
      return;
      continue;
      i = 1;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "onConfigurationChanged");
    }
    hideSoftInput();
    if (paramConfiguration.orientation == 2) {
      anot.a(this.app, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Wvm.CS(18);
    adqr.doOnConfigurationChanged(paramConfiguration);
  }
  
  @TargetApi(11)
  protected void doOnDestroy()
  {
    aTb = false;
    if (this.aSY) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnDestroy return");
      }
    }
    do
    {
      return;
      this.aSY = true;
      URLDrawable.resume();
      this.bEu = 9;
      wja.h(this.TAG, "doOnDestroy", hashCode(), this.bEu);
      this.bEr = 0;
      this.bEg = 0;
      bHo();
      bHl();
      bHj();
      bGO();
      if (this.jdField_a_of_type_Yjh != null) {
        this.jdField_a_of_type_Yjh.destory();
      }
      bIa();
      this.app.removeHandler(getClass());
      this.sessionInfo.Ib = -1L;
      bHq();
      bHh();
      bHm();
      Object localObject = (ajdg)this.app.getManager(14);
      ((ajdg)localObject).dwf();
      ((ajdg)localObject).dwg();
      EmojiStickerManager.a().a(this, this.sessionInfo.aTl, this.sessionInfo.cZ, this.aSE);
      bHr();
      xks.cdQ();
      xks.cdR();
      xkr.a().send(3);
      xkr.a().send(6);
      xkr.a().send(12);
      xkr.a().send(15);
      xkr.a().send(18);
      xkr.a().send(9);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
      {
        localObject = ahzd.a(this.app);
        if (localObject != null) {
          ((ahzd)localObject).KK(false);
        }
      }
      this.uiHandler.removeCallbacksAndMessages(null);
      this.uiHandler.removeCallbacks(this.dH);
      asY();
      this.app.removeHandler(ChatActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.stop();
      }
      ChatActivityUtils.bJs();
      ujt.bJq();
      bHn();
      this.T = Boolean.valueOf(true);
      if (this.Cy != null) {
        this.Cy.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bJn();
      bHi();
      if (AITranslator.sh()) {
        AITranslator.a().n(this.mContext, true);
      }
      this.aSx = false;
      this.mMsgSignalSum = 60;
      this.mMsgSignalCount = 0;
      this.mMsgSignalNetType = 0;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.dG);
      wnf.a().destory();
      skd.a().release();
      aSz = true;
      if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null) {
        Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      aqjc.edW();
      this.app.a().dDS();
      alii.clear();
      xmj.Jd = 0L;
      if (bEs == 1) {
        Ai(0);
      }
      ChatActivityUtils.bJr();
      aqfp.Sz(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$b.clear();
      jss.a().destroy();
      this.app.a().nc.clear();
      bHk();
      BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
      localObject = (apqk)this.app.getManager(223);
      if (localObject != null) {
        ((apqk)localObject).ebn();
      }
      aqfv.a().clear();
      bIK();
      afdw.a(this.fs, this.app);
      if (this.jdField_a_of_type_Afef != null)
      {
        this.jdField_a_of_type_Afef.uninit();
        this.jdField_a_of_type_Afef = null;
      }
      HotPicPageView.drh();
      ahzy.cZ(this.app);
      xva.a().zD(false);
      bHp();
      CustomizeStrategyFactory.a().yv(false);
      this.jdField_a_of_type_Wvm.CS(13);
      ykm.a(this.app).ciX();
      bIX();
      if (this.pp != null) {
        this.pp.setOnClickListener(null);
      }
      ahwb.dqB();
      this.playMode = 0;
      this.aSQ = false;
      this.aSR = false;
      aqnl.onAIODestroy();
      this.rK = null;
      this.rL = null;
      this.Hy = 0;
      this.bEz = 0;
      if ((OI()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
      }
    } while (this.jdField_a_of_type_Wsr == null);
    this.jdField_a_of_type_Wsr.onDestroy();
    this.jdField_a_of_type_Wsr = null;
  }
  
  protected void doOnPause()
  {
    this.bEu = 5;
    wja.h(this.TAG, "doOnPause", hashCode(), this.bEu);
    this.app.b().bEy();
    wyv.Da(0);
    ArkFlashChatContainerWrapper.Da(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    if (!mc()) {
      AbstractVideoImage.pauseAll();
    }
    ShortVideoPTVItemBuilder.r(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    ShortVideoItemBuilder.cea();
    ShortVideoRealItemBuilder.cea();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      vT(true);
    }
    ThreadManager.post(new BaseChatPie.22(this), 5, null, false);
    if (this.aSo) {
      ujt.a(this.app, this.sessionInfo);
    }
    this.uiHandler.removeMessages(16711689);
    if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onPause();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.pause();
    }
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.onPause();
    }
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJV()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.onPause();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.stop(0);
    }
    if (this.jdField_a_of_type_Aiyr != null) {
      this.jdField_a_of_type_Aiyr.onPause();
    }
    this.aSs = false;
    if (this.aSp)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.aSp = false;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.release();
    }
    if (this.jdField_a_of_type_Apwy != null) {
      this.jdField_a_of_type_Apwy.onPause();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.onPause();
    }
    if (this.jdField_a_of_type_Abin != null) {
      this.jdField_a_of_type_Abin.o(this);
    }
    this.jdField_a_of_type_Wvm.CS(9);
    if (OI()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
    }
    if (this.jdField_a_of_type_Wsr != null) {
      this.jdField_a_of_type_Wsr.onPause();
    }
  }
  
  protected void doOnResume()
  {
    this.bEu = 4;
    wja.h(this.TAG, "doOnResume", hashCode(), this.bEu);
    bHt();
    this.app.b().bY(this.sessionInfo.aTl, this.sessionInfo.cZ);
    if (this.aSD)
    {
      wja.yn(true);
      this.aSE = false;
      if (this.sessionInfo.cZ == 1008) {
        aqiy.bk(null, "pubAcc_structMsg_display", this.sessionInfo.aTl);
      }
    }
    for (;;)
    {
      synchronized (QQMessageFacade.bG)
      {
        bHE();
        wd(true);
        this.uiHandler.postDelayed(this.dH, 800L);
        this.aSD = false;
        if (DeviceProfileManager.isInited) {
          bHQ();
        }
        this.aSp = false;
        this.du = this.app.getLoudSpeakerState();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Wki, this);
        jss.a().a(this.app, this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.sessionInfo);
        aizf.cmV = true;
        ThreadRegulator.a().ab(1, 1500L);
        wm(((AIOLongShotHelper)a(15)).RV());
        ((www)a(29)).l(i());
        return;
      }
      refresh(131072);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onShow right now");
      }
      onShow();
    }
  }
  
  protected void doOnStart()
  {
    this.bEu = 3;
    wja.h(this.TAG, "doOnStart", hashCode(), this.bEu);
    this.jdField_a_of_type_Wvm.CS(4);
  }
  
  protected void doOnStop()
  {
    this.bEu = 6;
    wja.h(this.TAG, "doOnStop", hashCode(), this.bEu);
    this.aSs = false;
    if ((this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 1)) {
      hideSoftInput();
    }
    bIo();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!this.sessionInfo.beA))
    {
      localObject = (wvd)this.jdField_a_of_type_Wvm.a(24);
      dh(((wvd)localObject).pm(), ((wvd)localObject).pp());
    }
    this.T = Boolean.valueOf(true);
    if ((this.mActivity != null) && (this.mActivity.getWindow() != null)) {
      this.mActivity.getWindow().setSoftInputMode(32);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.onHide();
    }
    String str;
    int i;
    lcm locallcm;
    if ((this.mActivity != null) && (this.mActivity.getIntent() != null))
    {
      str = this.mActivity.getIntent().getStringExtra("uin");
      i = this.mActivity.getIntent().getIntExtra("uintype", -1);
      locallcm = lcm.a();
      if (this.jdField_a_of_type_Wki == null) {
        break label258;
      }
    }
    label258:
    for (Object localObject = this.jdField_a_of_type_Wki.getList();; localObject = null)
    {
      locallcm.a(0, (List)localObject, str, i, this.bEj);
      ShortVideoItemBuilder.cec();
      ShortVideoRealItemBuilder.cec();
      this.jdField_a_of_type_Wvm.CS(10);
      return;
    }
  }
  
  public void e(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    zY(0);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.mUserData != null) {
        break label28;
      }
    }
    label28:
    for (int i = 1; i == 0; i = 0)
    {
      anqo.cU(paramString, false);
      return;
    }
    alid.nZ(paramString);
  }
  
  protected int eK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  protected void eS(int paramInt1, int paramInt2)
  {
    aqjh.b(this.app, this.sessionInfo.cZ, paramInt1, paramInt2);
  }
  
  public void ex(View paramView) {}
  
  protected void ey(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = wja.a(paramView);
            if (ShortVideoItemBuilder.b.class.isInstance(paramView))
            {
              ((ShortVideoItemBuilder.b)paramView).cdi();
              return;
            }
            if (ShortVideoRealItemBuilder.a.class.isInstance(paramView))
            {
              ((ShortVideoRealItemBuilder.a)paramView).cee();
              return;
            }
            if (LightVideoItemBuilder.a.class.isInstance(paramView))
            {
              ((LightVideoItemBuilder.a)paramView).cdi();
              return;
            }
            if (!(paramView instanceof xov.a)) {
              break;
            }
            paramView = (xov.a)paramView;
          } while (paramView.a == null);
          paramView.a.detach();
          return;
          if (!(paramView instanceof xjx.a)) {
            break;
          }
          paramView = (xjx.a)paramView;
        } while (paramView.a == null);
        paramView.a.detach();
        return;
      } while (!(paramView instanceof xje.a));
      paramView = (xje.a)paramView;
    } while (paramView.a == null);
    paramView.a.detach();
  }
  
  public void f(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    setRequestedOrientation4Recording(true);
    bIK();
    zY(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "recorderEnd() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.mUserData != null) {
        break label66;
      }
    }
    while (i == 0)
    {
      anqo.cU(paramString, false);
      anqo.Rl(paramString);
      return;
      label66:
      i = 0;
    }
    alid.nZ(paramString);
  }
  
  public void fC(List<ChatMessage> paramList)
  {
    this.app.b().V(paramList, false);
    refresh(196613);
  }
  
  public void fD(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_Wki.getList();
    if (((List)localObject).size() > 0)
    {
      int i = a((List)localObject, paramLong);
      if (i >= 0) {
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.28(this, i));
      }
    }
    else
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
      return;
    }
    List localList = this.app.b().a(this.sessionInfo.cZ).a(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong);
    if (1000 == this.sessionInfo.cZ) {}
    for (localObject = ChatActivityUtils.b(localList, this.sessionInfo, this.app);; localObject = ChatActivityUtils.a(localList, this.sessionInfo, this.app))
    {
      a(localList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, -1L));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.post(new BaseChatPie.29(this));
      break;
    }
  }
  
  public void fE(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.Fv = paramLong;
    refresh(65552);
  }
  
  protected void fF(long paramLong)
  {
    this.Fv = paramLong;
  }
  
  public boolean fV(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      SplashActivity.bKV = tzc.a().a(0, 1, 0, 0, 2000, 302, 8L, Process.myTid(), "exitAIO");
      SplashActivity.GW = SystemClock.uptimeMillis();
    }
    this.bEu = 7;
    wja.h(this.TAG, "finish " + paramInt, hashCode(), this.bEu);
    if (fW(paramInt)) {
      return true;
    }
    wsd.destroy();
    bHH();
    bHG();
    if (this.mActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
      this.mActivity.moveTaskToBack(true);
    }
    bHs();
    this.uiHandler.removeCallbacks(this.dH);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.reset();
    if (paramInt == 0) {
      bHA();
    }
    while (paramInt != 1)
    {
      try
      {
        Object localObject = this.Cr.getTag();
        String[] arrayOfString = (String[])localObject;
        if ((localObject != null) && ("comic".equals(arrayOfString[0]))) {
          avdb.a(this.app, "3006", "2", "40025", arrayOfString[1], new String[] { "3" });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if ((this.aN) && (!this.aO) && (wja.bcO))
      {
        this.mActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
        this.aO = true;
      }
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(false);
      }
      bIf();
      DuiButtonImageView.cqt();
      this.jdField_a_of_type_Wvm.CS(12);
      this.bEu = 8;
      ListenTogetherManager.c(this.app, this.sessionInfo, hashCode());
      if (this.aSU) {
        a(false, null, false);
      }
      BaseChatItemLayout.bdx = this.aST;
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, String.format("finish preCheckBoxVisible=[%b]", new Object[] { Boolean.valueOf(this.aST) }));
      }
      return false;
    }
    if ((this.mActivity instanceof ChatActivity)) {
      this.mActivity.finish();
    }
    for (;;)
    {
      HapticManager localHapticManager = HapticManager.a();
      if (localHapticManager == null) {
        break;
      }
      localHapticManager.dispose();
      break;
      bHA();
    }
  }
  
  @Deprecated
  public void finish()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.RL();
    }
    if (!bool)
    {
      xks.cdQ();
      xks.cdR();
      xkr.a().releaseThread();
      fV(1);
    }
  }
  
  protected void g(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleRequest requestCode " + i);
    }
    if ((i == 2) || (i == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.bG(paramIntent);
    }
    if (paramInt == 1) {
      yih.t(this.app, this.sessionInfo.aTl);
    }
    while ((paramInt != 2) || (this.aSV)) {
      return;
    }
    yih.t(this.app, this.sessionInfo.aTl);
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mc())
    {
      if (!paramBoolean1) {
        break label41;
      }
      bHb();
    }
    for (;;)
    {
      a(this.app.getApp(), paramBoolean2, false, false);
      aF(true, paramBoolean2);
      this.du = paramBoolean2;
      return;
      label41:
      iS();
    }
  }
  
  public final QQAppInterface getApp()
  {
    return this.app;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getCurType()
  {
    return this.sessionInfo.cZ;
  }
  
  public int getFateOfRecorder()
  {
    return this.fateOfRecorder;
  }
  
  public int getTitleBarHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299627);
  }
  
  public final MqqHandler getUIHandler()
  {
    return this.uiHandler;
  }
  
  public void gq()
  {
    Ac(6);
  }
  
  public void grantForCamera()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user grant");
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.release();
    }
    if (this.sessionInfo.cZ == 9501) {}
    for (;;)
    {
      try
      {
        localObject = syw.b(this.app, Long.parseLong(this.sessionInfo.aTl));
        if (localObject == null) {
          continue;
        }
        i = ((DeviceInfo)localObject).productId;
      }
      catch (Exception localException)
      {
        Object localObject;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      wmj.a(this.app, this.mContext, a(), this.sessionInfo, i, 0);
      localObject = (acbs)this.app.getBusinessHandler(53);
      if (((acbs)localObject).io(0)) {
        ((acbs)localObject).cGZ();
      }
      return;
      int i = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    m(paramMessage);
    h(paramMessage);
    i(paramMessage);
    aj(paramMessage);
    ak(paramMessage);
    an(paramMessage);
    j(paramMessage);
    k(paramMessage);
    l(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 16711683: 
    case 54: 
    case 60: 
    case 51: 
    case 267387138: 
    case 42: 
    case 55: 
    case 56: 
    case 57: 
    case 64: 
    case 68: 
    case 95: 
      do
      {
        do
        {
          do
          {
            RelativeLayout.LayoutParams localLayoutParams;
            do
            {
              do
              {
                return true;
                QQToast.a(this.app.getApp(), 2131719484, 1).show(getTitleBarHeight());
                return true;
              } while ((this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramMessage.arg1 <= 50));
              localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
            } while ((localLayoutParams == null) || (localLayoutParams.bottomMargin == paramMessage.arg1));
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramMessage.arg1);
            this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(localLayoutParams);
            return true;
            al(paramMessage);
            return true;
            paramMessage = (PlusPanel)this.jdField_a_of_type_Xru.B(8);
          } while (paramMessage == null);
          paramMessage.update();
          return true;
          am(paramMessage);
          return true;
          boolean bool = paramMessage.getData().getBoolean("showRedDot");
          if (bool) {
            anot.a(this.app, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.TW(bool);
          return true;
          a((String)paramMessage.obj, true, this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.app);
          return true;
          eR(this.sessionInfo.entrance, 3);
          return true;
          aG(true, true);
          return true;
          bIH();
          return true;
        } while (this.jdField_a_of_type_Yjh == null);
        this.jdField_a_of_type_Yjh.ciB();
        return true;
      } while ((!(paramMessage.obj instanceof CharSequence)) || (this.A == null));
      paramMessage = (CharSequence)paramMessage.obj;
      this.A.setText(paramMessage);
      this.A.requestLayout();
      return true;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTypeface(lf.a());
    return true;
  }
  
  public void hideAllPanels()
  {
    wb(false);
  }
  
  public void hidePanel()
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
  }
  
  public void hideSoftInput()
  {
    if ((this.mActivity != null) && (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.mActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "hideSoftInput, ", this.jdField_b_of_type_ComTencentWidgetXPanelContainer.getWindowToken() });
        }
      }
    }
  }
  
  public RelativeLayout i()
  {
    return this.fs;
  }
  
  protected Boolean i()
  {
    return null;
  }
  
  public void iS()
  {
    if ((this.jdField_c_of_type_AndroidAppDialog != null) && (this.jdField_c_of_type_AndroidAppDialog.isShowing()) && (this.jdField_c_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.TAG, 1, "dismissPttMaskDialog", localException);
    }
  }
  
  public boolean isFullScreenMode()
  {
    return ((wvd)this.jdField_a_of_type_Wvm.a(24)).isFullScreenMode();
  }
  
  public boolean isRecording()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.isRecording());
  }
  
  public void k(Object paramObject)
  {
    if (this.ad != null)
    {
      this.ahi = false;
      this.ad.setActivated(this.ahi);
    }
    ykm.a(this.app).ciX();
    wja.bcO = true;
    if (!(paramObject instanceof Integer))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "panel clicked, id: " + paramObject);
      }
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      vT(true);
    }
    bHd();
    if ((isFullScreenMode()) && ((i == 2) || (i == 10) || (i == 8))) {
      vV(false);
    }
    if (i == this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm())
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      return;
    }
    Aj(i);
  }
  
  public void m(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1) {
      break label7;
    }
    label7:
    label217:
    label222:
    label223:
    for (;;)
    {
      return;
      if (!paramBoolean2)
      {
        Object localObject = (acff)this.app.getManager(51);
        if ((this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1))
        {
          localObject = ((acff)localObject).a(this.sessionInfo.aTl, this.sessionInfo.cZ, false);
          if (localObject != null) {
            break label222;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
        }
        for (;;)
        {
          if (localObject == null) {
            break label223;
          }
          if (paramInt == 1)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((NoC2CExtensionInfo)localObject).isDataChanged) {
            if (((NoC2CExtensionInfo)localObject).audioPanelType == paramInt) {
              break label132;
            }
          }
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((NoC2CExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
          ExtensionInfo localExtensionInfo = ((acff)localObject).a(this.sessionInfo.aTl, false);
          localObject = localExtensionInfo;
          if (localExtensionInfo == null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
          }
          if (localObject == null) {
            break;
          }
          if (paramInt == 1)
          {
            ((ExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((ExtensionInfo)localObject).isDataChanged) {
            if (((ExtensionInfo)localObject).audioPanelType == paramInt) {
              break label217;
            }
          }
          for (paramBoolean1 = bool;; paramBoolean1 = false)
          {
            ((ExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((ExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
        }
      }
    }
  }
  
  public boolean mc()
  {
    boolean bool = false;
    if (((this.mActivity != null) && ((this.mActivity.isResume()) || (this.mActivity.isInMultiWindow()))) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 6) || (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 5)) {
      bool = true;
    }
    if ((this.mActivity != null) && (QLog.isColorLevel())) {
      QLog.d(this.TAG, 2, "isActivityResume = " + bool);
    }
    return bool;
  }
  
  protected List<ChatMessage> n(boolean paramBoolean)
  {
    return a(this.app, paramBoolean);
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Xru.n(paramInt1, paramInt2);
    this.uiHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      aSH = false;
    }
    if (this.jdField_a_of_type_Adrl != null) {
      this.jdField_a_of_type_Adrl.hC(paramInt1, paramInt2);
    }
    boolean bool;
    if (paramInt1 == 24) {
      if (paramInt2 == 1)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.yQ(bool);
        label74:
        if (paramInt2 != 18) {
          break label276;
        }
        if (this.jdField_a_of_type_Abin != null)
        {
          this.jdField_a_of_type_Abin.stopRender();
          this.jdField_a_of_type_Abin.DF(false);
        }
        bIf();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.onShow();
        label113:
        if (paramInt2 != 1) {
          break label337;
        }
        if (this.jdField_a_of_type_Wsr != null) {
          this.jdField_a_of_type_Wsr.setEnable(false);
        }
      }
    }
    for (;;)
    {
      ((aavt)a(4)).czI();
      return;
      bool = false;
      break;
      if (paramInt1 == 18)
      {
        if (paramInt2 == 1) {}
        for (bool = true;; bool = false)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.yQ(bool);
          if (this.jdField_a_of_type_Abin != null)
          {
            this.jdField_a_of_type_Abin.DF(true);
            this.jdField_a_of_type_Abin.resumeRender();
          }
          bIe();
          break;
        }
      }
      if (paramInt1 == 3)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {
          break label74;
        }
        if (paramInt2 == 1) {}
        for (bool = true;; bool = false)
        {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.yQ(bool);
          break;
        }
      }
      if ((paramInt1 != 28) || (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)) {
        break label74;
      }
      if (paramInt2 == 1) {}
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.yQ(bool);
        break;
      }
      label276:
      if (paramInt2 == 24)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.onShow();
        break label113;
      }
      if (paramInt2 == 3)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {
          break label113;
        }
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onShow();
        break label113;
      }
      if ((paramInt2 != 28) || (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)) {
        break label113;
      }
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.dqS();
      break label113;
      label337:
      if ((this.jdField_a_of_type_Wsr != null) && (!this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJV())) {
        this.jdField_a_of_type_Wsr.setEnable(true);
      }
    }
  }
  
  protected void o(int paramInt1, int paramInt2)
  {
    bHX();
    bp();
    if (QLog.isColorLevel()) {
      QLog.d("inputx", 2, "doPanelChanged newPanel=" + paramInt2);
    }
    eW(paramInt1, paramInt2);
    Ab(paramInt2);
    eV(paramInt1, paramInt2);
    eU(paramInt1, paramInt2);
    if ((paramInt2 == 14) && (paramInt1 != 14) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.ceT();
    }
    if ((paramInt1 == 2) && (paramInt2 != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.onDestroy();
    }
    if ((paramInt1 != 2) && (paramInt2 == 2)) {
      this.bEv = 0;
    }
    if ((paramInt1 == 36) && (paramInt2 != 36) && (paramInt2 != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVoiceTextEditPanel.onDestroy();
    }
    bHW();
    eT(paramInt1, paramInt2);
    ((www)a(29)).o(paramInt1, paramInt2);
  }
  
  @Deprecated
  public String oL()
  {
    return this.sessionInfo.aTl;
  }
  
  @Deprecated
  public String oM()
  {
    return this.sessionInfo.aTn;
  }
  
  public String oN()
  {
    return this.sessionInfo.troopUin;
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Wsr != null) && (this.jdField_a_of_type_Wsr.isOpen()))
    {
      if (!this.jdField_a_of_type_Wsr.onBackEvent()) {
        this.jdField_a_of_type_Wsr.close(true);
      }
      return true;
    }
    aavt localaavt = (aavt)a(4);
    if ((localaavt != null) && (localaavt.XE())) {
      return true;
    }
    if (this.jdField_a_of_type_Afdw != null) {
      this.jdField_a_of_type_Afdw.cYA();
    }
    if (this.jdField_a_of_type_Afef != null) {
      this.jdField_a_of_type_Afef.cYI();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTh)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onBackEvent() disableBackForPTV true");
      }
      return false;
    }
    if (((wvo)a(39)).Sb()) {
      return true;
    }
    ((wwz)a(41)).caS();
    return fV(0);
  }
  
  public void onChangeMultiScreen(boolean paramBoolean)
  {
    Fragment localFragment = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean) {
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Wki != null) {
        this.jdField_a_of_type_Wki.bdC = paramBoolean;
      }
      return;
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_b_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i = paramView.getId();
    if ((i != 2131369579) && (i != 2131369967) && (i != 2131380514) && (i != 2131370393)) {
      wja.bcO = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) && (i != 2131362404) && (i != 2131373427))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      vT(true);
    }
    bHd();
    eu(paramView);
    ev(paramView);
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      abhh.sI.clear();
      this.bEg = this.jdField_a_of_type_Wki.getCount();
      if (this.bEg > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.stop();
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      ((wxo)a(53)).onClick(paramView);
      continue;
      bsq();
      continue;
      ew(paramView);
      continue;
      QQAppInterface localQQAppInterface = this.app;
      if (!this.du) {}
      for (;;)
      {
        localQQAppInterface.setLoudSpeakerState(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.gC();
        ((ajdg)this.app.getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(), this.sessionInfo, this.du);
        break;
        bool = false;
      }
      bHc();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    return this.jdField_a_of_type_Wvm.a(paramInt);
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            xkr.a().ft(paramView);
            localObject1 = wja.a(paramView);
          } while (!StructingMsgItemBuilder.a.class.isInstance(localObject1));
          localObject1 = (StructingMsgItemBuilder.a)localObject1;
        } while ((((StructingMsgItemBuilder.a)localObject1).hL == null) || (!MessageForStructing.class.isInstance(((StructingMsgItemBuilder.a)localObject1).mMessage)));
        localObject2 = (MessageForStructing)((StructingMsgItemBuilder.a)localObject1).mMessage;
      } while ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare)) || ((!(this.mContext instanceof ChatActivity)) && (!(this.mContext instanceof SplashActivity))));
      if (((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).mIsPAVideoStructMsg) {
        anqs.a().b(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg);
      }
      localObject1 = ((FragmentActivity)this.mContext).getChatFragment().a().a();
      localObject2 = ((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).getLayoutStr();
    } while (localObject1 == null);
    ((StructingMsgItemBuilder.b)localObject1).b((String)localObject2, (ViewGroup)paramView.findViewById(2131364503));
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onNetMobile2Wifi readconfirm network change");
    }
    bIt();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onNetNone2Mobile readconfirm network change");
    }
    bIt();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onNetNone2Wifi readconfirm network change");
    }
    bIt();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onNetWifi2Mobile readconfirm network change");
    }
    bIt();
  }
  
  public void onNetWifi2None() {}
  
  public void onPlayStart()
  {
    aF(true, this.du);
    this.mActivity.getWindow().addFlags(128);
  }
  
  public void onPlayStop()
  {
    this.mActivity.setVolumeControlStream(3);
    aF(false, false);
    iS();
    this.mActivity.getWindow().clearFlags(128);
    this.uiHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void onPostThemeChanged()
  {
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "isThemeDefault" + this.aey);
    }
    if ((this.app != null) && (this.mContext != null) && (this.cL != null) && (this.sessionInfo != null) && (this.sessionInfo.a != null))
    {
      this.sessionInfo.a.bdG = false;
      if (wkj.a(this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.aTl, true, 7, this.sessionInfo.a))
      {
        if ((!this.sessionInfo.beq) || (!this.sessionInfo.bes) || (this.sessionInfo.isNightMode)) {
          break label286;
        }
        this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.onPostThemeChanged();
      }
      try
      {
        bIM();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.kD(2130851761, 2130851762);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130851145, 2130851146);
        }
        ((aavt)a(4)).czJ();
        ((www)a(29)).l(i());
        adqr.onThemeChanged();
        aogk.a().q(a(), this.jdField_b_of_type_ComTencentWidgetXPanelContainer);
        return;
        label286:
        if ((this.sessionInfo.ber) && (this.sessionInfo.bet) && (!this.sessionInfo.isNightMode))
        {
          this.cL.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851035));
          this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
          continue;
        }
        this.cL.setBackgroundDrawable(this.sessionInfo.a.img);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.TAG, 2, "onPostThemeChanged e:" + localException.getMessage() + "isThemeDefault" + this.aey);
        }
      }
    }
  }
  
  public void onPreThemeChanged() {}
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    this.jdField_a_of_type_Wvm.a(paramInt, paramDialog);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Wvm.CS(19);
    int j = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i = paramInt3 - k - j;
    int m = i - (paramInt1 - k) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.i("BaseChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + j + ",headerCnt = " + k + ",botCnt=" + m);
    }
    Object localObject = (wwn)a(27);
    if (localObject != null) {
      ((wwn)localObject).CU(paramInt1);
    }
    a(paramInt1, paramInt2, paramInt3, j, k, i, m);
    localObject = wsd.a();
    if (paramAbsListView.getChildAt(0) != null)
    {
      i = paramAbsListView.getChildAt(0).getTop();
      ((wsd)localObject).a(paramInt1, paramInt2, k, j, paramInt3, i, paramAbsListView.getWidth(), paramAbsListView.getHeight());
      if (this.Hy >= paramInt1) {
        break label306;
      }
      ey(this.rK);
    }
    for (;;)
    {
      this.Hy = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.bEz = (paramInt1 + paramInt2 - 1);
      }
      this.rK = paramAbsListView.getChildAt(0);
      this.rL = paramAbsListView.getChildAt(paramInt2 - 1);
      if ((paramInt1 + paramInt2 == paramInt3) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.eiR();
      }
      return;
      i = 0;
      break;
      label306:
      if ((paramInt1 + paramInt2 - 1 < this.bEz) && (paramInt1 + paramInt2 - 1 > 0)) {
        ey(this.rL);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    jss.a().e(paramAbsListView, paramInt);
    ((aqrc)this.app.getManager(235)).a.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Wki, paramInt);
    if (paramInt == 0)
    {
      xvu.setScrolling(false);
      this.jdField_a_of_type_Wki.bYV();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      VasFaceManager.resume();
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      ku.a(this);
      ShortVideoItemBuilder.ceb();
      ShortVideoRealItemBuilder.ceb();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.resume();
      aqgm.ez(this.app);
      ((abhh)this.app.getManager(153)).cBN();
      ((abhe)this.app.getManager(211)).t(2, this.sessionInfo.aTl, this.sessionInfo.cZ);
      ((AvatarPendantManager)this.app.getManager(46)).eeO();
      if ((this.aSy) && (this.uiHandler != null))
      {
        this.aSy = false;
        this.uiHandler.removeMessages(16711697);
        paramAbsListView = this.uiHandler.obtainMessage(16711697);
        this.uiHandler.sendMessageDelayed(paramAbsListView, BubbleManager.VM);
      }
      adxn.a().t(this.app, 0);
      abgl.a().l(this.app, 0);
      EmojiStickerManager.a().u(this);
      txn.a().stopMonitorScene("list_aio_" + this.sessionInfo.cZ, false);
      DuiButtonImageView.cYH();
      if (this.bEk == 0) {
        aqfv.a().a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      ((aqym)this.app.getManager(290)).a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Wki);
      this.jdField_a_of_type_Wvm.CS(16);
      wsd.a().setScrollState(this.mScrollState);
      if (paramInt != 1) {
        break label520;
      }
      bIW();
      this.jdField_a_of_type_Wvm.CS(14);
    }
    for (;;)
    {
      if ((paramInt == 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.eiR();
      }
      return;
      xvu.setScrolling(true);
      if (paramInt == 2) {
        this.jdField_a_of_type_Wki.bYU();
      }
      for (;;)
      {
        VasFaceManager.pause();
        URLDrawable.pause();
        if (!xkl.bhc)
        {
          AbstractGifImage.pauseAll();
          ApngImage.pauseAll();
          com.etrump.mixlayout.ETTextView.enableAnimation = false;
        }
        AbstractVideoImage.pauseAll();
        ShortVideoItemBuilder.cea();
        ShortVideoRealItemBuilder.cea();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.pause();
        if (paramInt == 1) {
          wc(false);
        }
        ((AvatarPendantManager)this.app.getManager(46)).eeN();
        txn.a().startMonitorScene("list_aio_" + this.sessionInfo.cZ);
        DuiButtonImageView.cYG();
        ((aqym)this.app.getManager(290)).onScroll();
        break;
        this.jdField_a_of_type_Wki.bYV();
      }
      label520:
      if (paramInt == 2) {
        this.jdField_a_of_type_Wvm.CS(15);
      }
    }
  }
  
  protected void onShow()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    wja.h(this.TAG, "onShow start ", hashCode(), this.bEu);
    aqmq.track(null, "AIO_onShow");
    aqmq.track(null, "AIO_onShow_emotion");
    bHL();
    aqmq.track("AIO_onShow_emotion", null);
    bHM();
    aqmq.track(null, "AIO_onShow_updateUI");
    bHO();
    aqmq.track("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    bHN();
    aqmq.track("AIO_onShow_videoStatus", "AIO_onShow_report");
    bC(this.mActivity.getIntent());
    aqmq.track("AIO_onShow_report", "AIO_onShow_otherThings");
    bHP();
    aqmq.track("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    bHT();
    aqmq.track("AIO_onShow_setReaded", null);
    if ((this.mActivity.getIntent() != null) && (this.mActivity.getIntent().hasExtra("launchApolloGame")) && (this.mActivity.getIntent().getBooleanExtra("launchApolloGame", false))) {
      ((abhe)this.app.getManager(211)).l(this.mActivity.getIntent(), this.sessionInfo.cZ);
    }
    if (this.jdField_a_of_type_Abin != null) {
      this.jdField_a_of_type_Abin.n(this);
    }
    aqfp.Sz(false);
    this.jdField_a_of_type_Wvm.CS(8);
    aqmq.track("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "AIOTime onShow end");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.onShow();
    }
    if (this.jdField_a_of_type_Afef == null) {
      this.jdField_a_of_type_Afef = new afef(this.app, this.mActivity, this, this.fs, this.jdField_a_of_type_Apat, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    if (!(this instanceof TroopChatPie)) {
      wi(true);
    }
    bHu();
    bHv();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ahwv.a(this).Pu(paramInt3);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    bzx();
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordLayout.hide();
      if (this.jdField_a_of_type_Abin != null) {
        this.jdField_a_of_type_Abin.DF(true);
      }
      bIe();
    }
    if (this.jdField_a_of_type_Afdw != null) {
      this.jdField_a_of_type_Afdw.cYA();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      vT(true);
    }
    bHd();
    switch (paramView.getId())
    {
    default: 
      return false;
    case 2131370537: 
      if (this.ahi)
      {
        ykm.a(this.app).ciX();
        this.ad.setImageResource(2130838164);
        this.ad.setSelected(false);
        this.ahi = false;
      }
      if ((this.jdField_a_of_type_Apat != null) && (this.sessionInfo.cZ == 1)) {
        this.jdField_a_of_type_Apat.onTouchEvent(paramMotionEvent);
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.setAutoScroll(false);
      }
      for (;;)
      {
        this.mGestureDetector.onTouchEvent(paramMotionEvent);
        return false;
        if ((i == 1) || (i == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.setAutoScroll(true);
        }
      }
    case 2131369276: 
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.onTouch(paramView, paramMotionEvent);
      return false;
    }
    c(paramView, paramMotionEvent);
    if ((vm() != 28) && (paramMotionEvent.getAction() == 0)) {
      anot.a(this.app, "CliOper", "", "", "0X80094D1", "0X80094D1", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public boolean qh()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.isStop());
  }
  
  public ViewGroup r()
  {
    return this.mAIORootView;
  }
  
  public boolean r(int paramInt)
  {
    if ((paramInt == 2) && (this.aSO))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "recreate audio panel due to receipt message");
      }
      this.aSO = false;
      return true;
    }
    if ((paramInt == 3) && (this.aSP))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "recreate emotion panel due to full screen");
      }
      this.aSP = false;
      return true;
    }
    return this.jdField_a_of_type_Xru.r(paramInt);
  }
  
  public void refresh(int paramInt)
  {
    a(paramInt, null, -1L);
  }
  
  public void send()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
    }
    bIb();
    if (this.jdField_a_of_type_Adrl != null) {
      this.jdField_a_of_type_Adrl.cUb();
    }
  }
  
  public void setFateOfRecorder(int paramInt)
  {
    this.fateOfRecorder = paramInt;
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    int i = 0;
    int j = 1;
    if (!paramBoolean)
    {
      this.bEC = this.mActivity.getRequestedOrientation();
      int k = this.app.getApplication().getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.isrFroyo()) {
        if (k == 1)
        {
          localObject = this.mActivity;
          i = j;
          if (VersionUtils.isGingerBread()) {
            i = 7;
          }
          ((FragmentActivity)localObject).setRequestedOrientation(i);
        }
      }
      label72:
      do
      {
        do
        {
          do
          {
            break label72;
            do
            {
              return;
            } while (k != 2);
            localObject = this.mActivity;
            if (VersionUtils.isGingerBread()) {}
            for (i = 6;; i = 0)
            {
              ((FragmentActivity)localObject).setRequestedOrientation(i);
              return;
            }
            if (VersionUtils.isHoneycombMR2())
            {
              localObject = this.mActivity.getWindowManager().getDefaultDisplay();
              j = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((j == 0) || (j == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (j != 0) {}
                }
              }
              for (;;)
              {
                this.mActivity.setRequestedOrientation(i);
                return;
                i = 8;
                continue;
                if (j == 0)
                {
                  i = 1;
                }
                else
                {
                  i = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (j != 1) {
                      i = 8;
                    }
                  }
                  else if (j == 1) {
                    i = 9;
                  } else {
                    i = 1;
                  }
                }
              }
            }
            i = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i != 0) && (i != 1)) {
              break;
            }
            if (k == 1)
            {
              this.mActivity.setRequestedOrientation(1);
              return;
            }
          } while (k != 2);
          this.mActivity.setRequestedOrientation(0);
          return;
        } while ((i != 2) && (i != 3));
        if (k == 1)
        {
          this.mActivity.setRequestedOrientation(9);
          return;
        }
      } while (k != 2);
      this.mActivity.setRequestedOrientation(8);
      return;
    }
    this.mActivity.setRequestedOrientation(this.bEC);
  }
  
  public void setting()
  {
    Intent localIntent = new Intent(this.mContext, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.mActivity.startActivity(localIntent);
    anot.a(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void showBottomBar()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!(this instanceof ycd))) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.bWD);
    }
    ((www)a(29)).cct();
    if (this.rG != null) {
      this.rG.setVisibility(0);
    }
    if (this.rH != null) {
      this.rH.setVisibility(0);
    }
  }
  
  public void turnOffShake() {}
  
  public void turnOnShake() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (u(paramObject)) {}
    do
    {
      return;
      if ((paramObject instanceof MessageRecord))
      {
        at(paramObject);
        return;
      }
      if ((paramObject instanceof QQMessageFacade.b))
      {
        au(paramObject);
        return;
      }
    } while (!(paramObject instanceof QQMessageFacade.a));
    av(paramObject);
  }
  
  public void vS(boolean paramBoolean) {}
  
  protected void vT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
    }
    this.uiHandler.removeMessages(33);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.Ie(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
    this.fs.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
  }
  
  public void vU(boolean paramBoolean)
  {
    this.aTa = paramBoolean;
    if ((paramBoolean) && (this.Cu.getVisibility() == 8))
    {
      this.Cu.setVisibility(0);
      this.mTitleText.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.Cu.getVisibility() != 0)) {
      return;
    }
    this.Cu.setVisibility(8);
    this.mTitleText.setTextSize(1, 17.0F);
  }
  
  public void vV(boolean paramBoolean)
  {
    ((wvd)this.jdField_a_of_type_Wvm.a(24)).K(paramBoolean);
  }
  
  protected void vW(boolean paramBoolean)
  {
    if (isFullScreenMode()) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatpieHelper.aTh) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "leftBackEvent() disableBackForPTV true");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.t(true) > 0)) {
      anot.a(this.app, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.t(true) > 10))
    {
      uii localuii = new uii(this, paramBoolean);
      aqha.a(this.mContext, 230, null, this.mContext.getString(2131690118), this.mContext.getString(2131690116), this.mContext.getString(2131690117), localuii, localuii).show();
      return;
    }
    vX(paramBoolean);
  }
  
  protected void vY(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.loadingView == null) {
          this.loadingView = LayoutInflater.from(this.mContext).inflate(2131559032, null);
        }
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.loadingView);
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  protected void vc(String paramString)
  {
    this.Cu.setText(paramString);
  }
  
  public void vd(String paramString)
  {
    d(2, paramString, this.Fq);
    this.mActivity.runOnUiThread(new BaseChatPie.48(this));
  }
  
  public void ve(@Nullable String paramString) {}
  
  public void vg(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.Ia(paramString);
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
    }
    for (;;)
    {
      this.aLB = null;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      }
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.aLB = paramString;
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
        if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
        }
      }
      else if (paramString != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.Ia(paramString);
        this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(3);
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.preloadWebProcess();
      }
    }
  }
  
  public void vh(String paramString)
  {
    if (this.C == null)
    {
      this.C = acgr.a(this.mContext, paramString, new ujg(this), null);
      if (this.C != null) {
        ((TextView)this.C.findViewById(2131365858)).setText(this.mContext.getString(2131721079));
      }
    }
    if ((this.C != null) && (!this.C.isShowing()) && (!this.mActivity.isFinishing()))
    {
      ((TextView)this.C.findViewById(2131365863)).setText(paramString);
      this.C.show();
    }
  }
  
  public void vi(String paramString)
  {
    this.aLA = paramString;
  }
  
  protected int vk()
  {
    int i = this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public int vl()
  {
    int i = xkx.f(this.app, "Normal_MaxPtt") * 1000;
    int j = VipUtils.a(this.app, null);
    if ((j & 0x4) != 0) {
      i = xkx.f(this.app, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i -= 200;
      this.uiHandler.sendEmptyMessageDelayed(16711687, i);
      return i + 200;
      if ((j & 0x2) != 0) {
        i = xkx.f(this.app, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public int vm()
  {
    return this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm();
  }
  
  public int vn()
  {
    return this.bEu;
  }
  
  protected int vo()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.wz();; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.wA();
      }
      return i + j;
    }
  }
  
  public void wa(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cm(2, paramBoolean);
  }
  
  public void wb(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 1)
    {
      localObject = (InputMethodManager)this.mContext.getSystemService("input_method");
      if (((InputMethodManager)localObject).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        if (paramBoolean) {
          this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJT();
        }
      }
      else
      {
        View localView = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE();
        if ((localView != null) && ((localView instanceof VoiceTextEditPanel)) && (((InputMethodManager)localObject).isActive()))
        {
          if (!paramBoolean) {
            break label98;
          }
          this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJT();
        }
      }
    }
    label98:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      break;
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      return;
      localObject = this.jdField_b_of_type_ComTencentWidgetXPanelContainer.cE();
    } while ((localObject == null) || (((View)localObject).getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "hideAllPanels  curPanel = " + this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm());
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJT();
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
  }
  
  public void wc(boolean paramBoolean) {}
  
  public void we(boolean paramBoolean)
  {
    this.aSw = paramBoolean;
  }
  
  public void wf(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = (wvd)this.jdField_a_of_type_Wvm.a(24);
    if ((this.sessionInfo.cZ == 1033) || (this.sessionInfo.cZ == 1034)) {}
    for (int i = 1; (((wvd)localObject).isFullScreenMode()) && ((i != 0) || (OS())); i = 0)
    {
      ((wvd)localObject).K(true);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.release();
    }
    boolean bool;
    if ((paramBoolean) && (((wvd)localObject).isFullScreenMode()))
    {
      bool = true;
      label104:
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "doShowPtv clickAioPanel:" + paramBoolean + ", fullMode:" + isFullScreenMode());
      }
      if (!this.app.abk()) {
        break label226;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2131698108, 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    for (;;)
    {
      xro.i(this.app, "0X8005E91", this.sessionInfo.cZ);
      if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() != 1) {
        break;
      }
      hideSoftInput();
      return;
      bool = false;
      break label104;
      label226:
      if (!alwy.auJ()) {
        break label376;
      }
      localObject = null;
      if (this.sessionInfo != null) {
        localObject = new SessionWrap(this.sessionInfo.aTl, this.sessionInfo.aTn, this.sessionInfo.cZ, this.sessionInfo.troopUin);
      }
      localObject = awrp.a((SessionWrap)localObject, this.mActivity.getClass().getName(), 10000, 100);
      ((Bundle)localObject).putInt("VIDEO_STORY_FROM_TYPE", axcg.e.getId());
      ((Bundle)localObject).putInt("AECAMERA_MODE", 200);
      ((Bundle)localObject).putInt("qq_sub_business_id", 106);
      ((Bundle)localObject).putBoolean("input_full_screen_mode", bool);
      rnq.a().a(a(), (Bundle)localObject, 11);
      axgk.a().print(false);
      axgk.a().eJy();
    }
    label376:
    if (this.sessionInfo.cZ == 9501) {}
    for (;;)
    {
      try
      {
        localObject = syw.b(this.app, Long.parseLong(this.sessionInfo.aTl));
        i = j;
        if (localObject != null) {
          i = ((DeviceInfo)localObject).productId;
        }
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      wmj.a(this.app, this.mContext, a(), this.sessionInfo, i, 1);
      break;
      i = 0;
    }
  }
  
  public void wg(boolean paramBoolean)
  {
    int i = 0;
    if ((this.sessionInfo.cZ != 1) && (this.sessionInfo.cZ != 3000)) {
      break label26;
    }
    label26:
    while ((this.mSourceMsgInfo == null) || (!TextUtils.isEmpty(this.mSourceMsgInfo.mAnonymousNickName))) {
      return;
    }
    boolean bool1;
    label74:
    Object localObject;
    QQAppInterface localQQAppInterface;
    Context localContext;
    String str1;
    String str2;
    XEditTextEx localXEditTextEx;
    if (((HotChatManager)this.app.getManager(60)).a(this.sessionInfo.aTl) != null)
    {
      bool1 = true;
      localObject = aqgv.a(this.app, this.sessionInfo.cZ, this.sessionInfo.aTl, this.mSourceMsgInfo.mSourceMsgSenderUin + "");
      localQQAppInterface = this.app;
      localContext = this.mContext;
      str1 = this.sessionInfo.aTl;
      str2 = this.mSourceMsgInfo.mSourceMsgSenderUin + "";
      localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (this.sessionInfo.cZ != 1) {
        break label252;
      }
    }
    label252:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = appb.a(localQQAppInterface, localContext, str1, str2, (String)localObject, bool1, localXEditTextEx, bool2, true);
      if ((localObject == null) || (((SpannableString)localObject).length() <= 0)) {
        break;
      }
      if (!paramBoolean) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject);
      return;
      bool1 = false;
      break label74;
    }
    label258:
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, (CharSequence)localObject);
      return;
      i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    }
  }
  
  public void wh(boolean paramBoolean)
  {
    aj(paramBoolean, TroopGiftPanel.byn);
  }
  
  public void wi(boolean paramBoolean)
  {
    if (((a() instanceof SplashActivity)) && (SplashActivity.bKT != 2)) {
      return;
    }
    apqk localapqk = (apqk)this.app.getManager(223);
    localapqk.B(this);
    if (paramBoolean) {
      localapqk.ebm();
    }
    localapqk.e(this.mActivity.getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    this.uiHandler.post(new BaseChatPie.88(this, localapqk, paramBoolean));
  }
  
  public void wj(boolean paramBoolean)
  {
    wd(paramBoolean);
  }
  
  public void wl(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setIsInMultiScreen(paramBoolean);
    }
    if (this.jdField_a_of_type_Wki != null) {
      this.jdField_a_of_type_Wki.bdC = paramBoolean;
    }
  }
  
  public void wm(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((CommonTextView)this.mTitleText).setMosaicEffect(new arge(10));
      ((OnlineStatusLyricView)this.Cu).setMosaicEffect(new arge(10));
      ((CommonTextView)this.Cv).setMosaicEffect(new arge(10));
      ((CommonImageView)this.mTitleIcon).setMosaicEffect(new arge(10));
      ((CommonImageView)this.pt).setMosaicEffect(new arge(10));
      ((CommonImageView)this.pu).setMosaicEffect(new arge(10));
      localObject = this.mActivity.findViewById(2131366180);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new arge(10));
      }
      ((CommonTextView)this.Ct).setMosaicEffect(new arge(10));
      if (!jof.a().dd(this.sessionInfo.aTl))
      {
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130851035);
        this.cL.setBackgroundDrawable((Drawable)localObject);
        this.sessionInfo.a = new wkj();
        this.sessionInfo.a.img = ((Drawable)localObject);
        this.sessionInfo.a.k = ColorStateList.valueOf(1711276032);
      }
      return;
    }
    ((CommonTextView)this.mTitleText).setMosaicEffect(null);
    ((OnlineStatusLyricView)this.Cu).setMosaicEffect(null);
    ((CommonTextView)this.Cv).setMosaicEffect(null);
    ((CommonImageView)this.mTitleIcon).setMosaicEffect(null);
    ((CommonImageView)this.pt).setMosaicEffect(null);
    ((CommonImageView)this.pu).setMosaicEffect(null);
    Object localObject = this.mActivity.findViewById(2131366180);
    if (localObject != null) {
      ((CommonImageView)localObject).setMosaicEffect(null);
    }
    ((CommonTextView)this.Ct).setMosaicEffect(null);
    bHw();
  }
  
  public void wn(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public void yD(int paramInt)
  {
    if (this.jdField_a_of_type_Smx != null) {
      this.jdField_a_of_type_Smx.yD(paramInt);
    }
  }
  
  protected boolean z(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.aTl.equals(paramMessageRecord.frienduin)) && ((this.sessionInfo.cZ == paramMessageRecord.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramMessageRecord.istroop)))) && (aegu.e(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.cZ, this.sessionInfo.topicId));
  }
  
  public void zL(int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    Object localObject = (LinearLayout)this.mAIORootView.findViewById(2131367818);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    if (paramInt != localLayoutParams.bottomMargin)
    {
      localLayoutParams.bottomMargin = paramInt;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      ((www)a(29)).ccG();
    }
    if (this.rC != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.rC.getLayoutParams();
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() + paramInt;
      if (paramInt != ((RelativeLayout.LayoutParams)localObject).bottomMargin)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
        this.rC.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void zM(int paramInt)
  {
    if (LightVideoConfigMgr.a().aPY()) {
      ayag.a(paramInt, this.go, this.jdField_b_of_type_ComTencentWidgetPatchedButton, this.aSM, this.mSourceMsgInfo);
    }
  }
  
  public void zQ(int paramInt) {}
  
  public void zR(int paramInt)
  {
    this.mActivity.setVolumeControlStream(3);
    aF(false, false);
  }
  
  public void zS(int paramInt)
  {
    this.mActivity.setVolumeControlStream(paramInt);
  }
  
  public void zT(int paramInt)
  {
    if (paramInt == 0)
    {
      anot.a(this.app, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.uiHandler.removeMessages(25);
      if ((this.jdField_a_of_type_Arjn == null) || (!this.jdField_a_of_type_Arjn.isShowing()))
      {
        this.jdField_a_of_type_Arjn = new arjn(this.mContext);
        this.jdField_a_of_type_Arjn.setTips(this.mContext.getString(2131700646));
        this.jdField_a_of_type_Arjn.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Arjn == null) || (!this.jdField_a_of_type_Arjn.isShowing()) || (this.jdField_a_of_type_Arjn.getWindow() == null)) {
      return;
    }
    this.jdField_a_of_type_Arjn.dismiss();
  }
  
  protected void zU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "updateListUnRead: " + paramInt);
    }
    if ((paramInt == 0) && (this.Cy != null))
    {
      this.Cy.setText(Integer.toString(paramInt));
      this.Cy.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.Cy != null) && (BaseChatItemLayout.bdx)) {
        this.Cy.setVisibility(8);
      }
      return;
    }
    if (this.Cy == null) {
      bHK();
    }
    TextView localTextView = this.Cy;
    if (paramInt > 99) {}
    for (String str = "99";; str = Integer.toString(paramInt))
    {
      localTextView.setText(str);
      this.Cy.setVisibility(0);
      ((wxo)a(53)).cdj();
      break;
    }
  }
  
  public void zV(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.isStop()) && (!this.uiHandler.hasMessages(16711686)))
    {
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.fateOfRecorder = paramInt;
      Message localMessage = this.uiHandler.obtainMessage(16711686);
      this.uiHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  public void zX(int paramInt)
  {
    aqge.ce(paramInt, false);
  }
  
  public void zY(int paramInt)
  {
    this.mActivity.runOnUiThread(new BaseChatPie.47(this, paramInt));
  }
  
  protected void zZ(int paramInt)
  {
    this.jdField_a_of_type_Wvm.CS(6);
    this.jdField_b_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(true);
    aqmq.track("AIO_SysMsgCost", "AIO_onShow_first");
    this.aSE = true;
    this.uiHandler.removeCallbacks(this.dH);
    wja.h(this.TAG, "onShowFirst " + paramInt, hashCode(), this.bEu);
    wja.yn(false);
    wd(false);
    refresh(131072);
    bGP();
    aG();
    bD(this.mActivity.getIntent());
    vY(true);
    if ((this.sessionInfo.cZ == 0) && (aqft.rj(this.sessionInfo.aTl))) {
      ThreadManager.executeOnSubThread(new BaseChatPie.56(this), true);
    }
    Object localObject = new BaseChatPie.57(this);
    if (AppSetting.aNS) {
      ThreadManager.executeOnSubThread((Runnable)localObject, true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acbh != null) {
        this.jdField_a_of_type_Acbh.aS(false, 0);
      }
      bGI();
      onShow();
      abrj.cd(this.app);
      aqmq.track(null, "AIO_apolloSurface");
      if ((this.aSN) || (!OK()))
      {
        this.jdField_a_of_type_Wnc.bZM();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "remove footerview for initApolloSurfaceView failed");
        }
      }
      bGS();
      adrm.a().r(this);
      aqmq.track("AIO_apolloSurface", null);
      DuiButtonImageView.ciK();
      aqmq.track("AIO_onShow_first", null);
      localObject = (aqrb)this.app.getBusinessHandler(71);
      ((aqrb)localObject).Vz(this.sessionInfo.aTl);
      ((aqrb)localObject).VA(this.sessionInfo.aTl);
      if (Build.VERSION.SDK_INT >= 26) {}
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, new Object[] { Integer.valueOf(8) });
        CustomizeStrategyFactory.a().yv(true);
        PokePanel.aS(this.app);
        if (SplashActivity.bKU != 0)
        {
          tzc.a().stop(SplashActivity.bKU);
          SplashActivity.bKU = 0;
        }
        lf.a(this.app, getUIHandler(), this.sessionInfo);
        localObject = (aqym)this.app.getManager(290);
        ((aqym)localObject).eb(this.sessionInfo.cZ, this.sessionInfo.aTl);
        ((aqym)localObject).a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Wki);
        bHu();
        bHv();
        this.jdField_a_of_type_Wvm.CS(7);
        return;
        ((Runnable)localObject).run();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w(this.TAG, 2, "disable auto fill error", localException);
        }
      }
    }
  }
  
  public static class SaveInputTypeTask
    implements Runnable
  {
    private Entity a;
    private WeakReference<QQAppInterface> dF;
    
    public SaveInputTypeTask(Entity paramEntity, QQAppInterface paramQQAppInterface)
    {
      this.a = paramEntity;
      if (paramQQAppInterface != null) {
        this.dF = new WeakReference(paramQQAppInterface);
      }
    }
    
    public void run()
    {
      if (this.dF == null) {}
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.dF.get();
        } while (localObject == null);
        localObject = (acff)((QQAppInterface)localObject).getManager(51);
        if ((this.a instanceof ExtensionInfo))
        {
          ((acff)localObject).a((ExtensionInfo)this.a);
          return;
        }
      } while (!(this.a instanceof NoC2CExtensionInfo));
      ((acff)localObject).a((NoC2CExtensionInfo)this.a, true);
    }
  }
  
  public class a
    extends inh
  {
    private a() {}
    
    public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
    {
      super.a(paramLong1, paramInt1, paramLong2, paramInt2);
      QLog.d("OnManagerForbiddenOpenRoom", 2, " avtype:" + paramInt2);
      String str1;
      if ((BaseChatPie.this.sessionInfo.cZ == paramInt1) && (Long.valueOf(BaseChatPie.this.sessionInfo.aTl).longValue() == paramLong1))
      {
        if ((paramLong2 != 1L) && (paramLong2 != 2L) && (paramLong2 != 35L) && (paramLong2 != 42L) && (paramLong2 != 43L) && (paramLong2 != 41L) && (paramLong2 != 40L)) {
          break label312;
        }
        str1 = BaseChatPie.this.mContext.getString(2131697824);
        if (paramLong2 != 2L) {
          break label234;
        }
        str1 = BaseChatPie.this.mContext.getString(2131697825);
      }
      label233:
      label234:
      String str2;
      label312:
      do
      {
        do
        {
          break label233;
          break label233;
          if ((paramLong2 == 41L) || (paramLong2 == 40L)) {
            str1 = BaseChatPie.this.mContext.getString(2131697829);
          }
          for (;;)
          {
            aqha.a(BaseChatPie.this.mContext, 230, null, str1, 2131697614, 2131721737, new ujq(this), null).show();
            return;
            if (paramLong2 != 35L) {
              break;
            }
            str1 = BaseChatPie.this.mContext.getString(2131697826);
            break;
            if (paramLong2 == 42L) {
              str1 = BaseChatPie.this.mContext.getString(2131697827);
            } else if (paramLong2 == 43L) {
              str1 = BaseChatPie.this.mContext.getString(2131697828);
            }
          }
          if (paramLong2 == 3L)
          {
            QQToast.a(BaseChatPie.this.app.getApp(), BaseChatPie.this.mContext.getString(2131697786), 1).show(BaseChatPie.this.getTitleBarHeight());
            return;
          }
          if (paramLong2 == 4L)
          {
            QQToast.a(BaseChatPie.this.app.getApp(), BaseChatPie.this.mContext.getString(2131697783), 1).show(BaseChatPie.this.getTitleBarHeight());
            return;
          }
          if (paramLong2 == 8L)
          {
            QQToast.a(BaseChatPie.this.app.getApp(), BaseChatPie.this.mContext.getString(2131697782), 1).show(BaseChatPie.this.getTitleBarHeight());
            return;
          }
        } while (paramLong2 != 7L);
        str1 = String.valueOf(paramLong1);
        str2 = BaseChatPie.this.app.getCurrentAccountUin();
        if (paramInt2 == 10)
        {
          VideoMsgTools.a(BaseChatPie.this.app, 1, 59, false, str1, str2, false, null, false, paramInt2, new Object[0]);
          return;
        }
      } while (paramInt2 != 2);
      VideoMsgTools.a(BaseChatPie.this.app, 1, 60, false, str1, str2, false, null, false, paramInt2, new Object[0]);
    }
    
    public void a(long paramLong1, int paramInt, long paramLong2, String paramString)
    {
      super.a(paramLong1, paramInt, paramLong2, paramString);
      if ((BaseChatPie.this.sessionInfo.cZ == paramInt) && (Long.valueOf(BaseChatPie.this.sessionInfo.aTl).longValue() == paramLong1)) {
        aqha.a(BaseChatPie.this.mContext, 230, null, paramString, 2131697614, 2131721737, new ujr(this), null).show();
      }
    }
    
    public void aX(String paramString1, String paramString2)
    {
      boolean bool = false;
      super.aX(paramString1, paramString2);
      if (BaseChatPie.this.bEu != 4) {}
      while ((!BaseChatPie.this.sessionInfo.aTl.equals(paramString1)) || (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar == null) || (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) == null) || (BaseChatPie.this.app.a().sB())) {
        return;
      }
      TextView localTextView = (TextView)BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]).findViewById(2131379512);
      int i = BaseChatPie.this.app.a().getSessionType();
      String str;
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        str = "";
        if ((BaseChatPie.this.sessionInfo.cZ == 3000) || (BaseChatPie.this.sessionInfo.cZ == 1))
        {
          i = jll.cL(BaseChatPie.this.sessionInfo.cZ);
          long l = Long.valueOf(paramString1).longValue();
          l = BaseChatPie.this.app.a().d(i, l);
          String.format(BaseChatPie.this.mContext.getString(2131690194), new Object[] { Long.valueOf(l) });
          localTextView.setText(paramString2);
        }
      }
      else
      {
        paramString1 = BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
        if (BaseChatPie.this.app.a().ll() == 2) {
          bool = true;
        }
        paramString1.zZ(bool);
        return;
      }
      if (i == 2) {
        str = BaseChatPie.this.mContext.getString(2131698170);
      }
      for (;;)
      {
        i = BaseChatPie.this.mContext.getResources().getColor(2131167312);
        BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(null, str, i, paramString1, 0);
        break;
        if (i == 1) {
          str = BaseChatPie.this.mContext.getString(2131697562);
        }
      }
    }
    
    public void d(int paramInt, long paramLong1, long paramLong2)
    {
      try
      {
        if ((paramLong1 == Long.parseLong(BaseChatPie.this.sessionInfo.aTl)) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
          BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberInfo", BaseChatPie.this.sessionInfo.cZ, BaseChatPie.this.sessionInfo.aTl, 3, 0L);
        }
        super.d(paramInt, paramLong1, paramLong2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GAudioObserver", 2, "OnMemberInfo", localNumberFormatException);
          }
        }
      }
    }
    
    public void e(int paramInt, long paramLong1, long paramLong2)
    {
      try
      {
        if ((paramLong1 == Long.parseLong(BaseChatPie.this.sessionInfo.aTl)) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
          BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberJoin", BaseChatPie.this.sessionInfo.cZ, BaseChatPie.this.sessionInfo.aTl, 1, paramLong2);
        }
        super.e(paramInt, paramLong1, paramLong2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GAudioObserver", 2, "OnMemberJoin", localNumberFormatException);
          }
        }
      }
    }
    
    public void f(int paramInt, long paramLong1, long paramLong2)
    {
      try
      {
        if ((paramLong1 == Long.parseLong(BaseChatPie.this.sessionInfo.aTl)) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)) {
          BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a("OnMemberQuit", BaseChatPie.this.sessionInfo.cZ, BaseChatPie.this.sessionInfo.aTl, 2, paramLong2);
        }
        super.f(paramInt, paramLong1, paramLong2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GAudioObserver", 2, "OnMemberQuit", localNumberFormatException);
          }
        }
      }
    }
    
    public void i(int paramInt, String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioObserver", 2, "OnAudioChatting uinType: " + paramInt + ", peerUin: " + paramString1);
      }
      if (BaseChatPie.this.jdField_a_of_type_Afef != null) {
        BaseChatPie.this.jdField_a_of_type_Afef.cYI();
      }
      if ((BaseChatPie.this.sessionInfo.cZ != 3000) && (BaseChatPie.this.sessionInfo.cZ != 1) && ((BaseChatPie.this.sessionInfo.aTl.equals(paramString1)) || ((paramInt == 1006) && (BaseChatPie.this.sessionInfo.aTl.equals(paramString2)))) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null))
      {
        if (BaseChatPie.this.app.a().cw(String.valueOf(paramString1))) {
          return;
        }
        BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.q(paramInt, paramString1, paramString2);
      }
      super.i(paramInt, paramString1, paramString2);
    }
    
    public void jm(String paramString)
    {
      boolean bool = false;
      super.jm(paramString);
      if ((BaseChatPie.this.sessionInfo.aTl.equals(paramString)) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) && (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.a(new Object[0]) != null) && (BaseChatPie.this.app.bF()))
      {
        paramString = BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar;
        if (BaseChatPie.this.app.a().ll() == 2) {
          bool = true;
        }
        paramString.zZ(bool);
      }
    }
    
    public void t(int paramInt, long paramLong)
    {
      if (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null)
      {
        BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.ciE();
        super.t(paramInt, paramLong);
      }
    }
    
    public void u(int paramInt, long paramLong)
    {
      if (BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar != null) {
        BaseChatPie.this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar.ciF();
      }
      super.u(paramInt, paramLong);
    }
  }
  
  class b
    extends aghq
  {
    private b() {}
    
    public void Q(long paramLong1, long paramLong2)
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
    {
      if ((paramString != null) && (paramString.length() > 0)) {
        ahav.JI(paramString);
      }
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void a(agnk paramagnk)
    {
      if (paramagnk == null) {}
      label4:
      do
      {
        FileManagerEntity localFileManagerEntity;
        do
        {
          do
          {
            break label4;
            do
            {
              return;
            } while (!(paramagnk.context instanceof FileManagerEntity));
            localFileManagerEntity = (FileManagerEntity)paramagnk.context;
            if ((paramagnk.filePath == null) || (paramagnk.filePath.length() <= 0)) {
              break;
            }
            localFileManagerEntity.strThumbPath = paramagnk.filePath;
            BaseChatPie.this.app.a().u(localFileManagerEntity);
          } while (BaseChatPie.this.a == null);
          BaseChatPie.this.a.notifyDataSetChanged();
          return;
        } while (localFileManagerEntity.thumbInvalidCode != 1);
        BaseChatPie.this.app.a().u(localFileManagerEntity);
      } while (BaseChatPie.this.a == null);
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void a(Integer paramInteger, long paramLong, String paramString)
    {
      if (BaseChatPie.this.a != null) {
        BaseChatPie.this.a.notifyDataSetChanged();
      }
      ahav.n(paramLong, paramInteger.intValue(), paramString);
      awrl.u(null, paramInteger.intValue());
    }
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(BaseChatPie.this.TAG, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
      }
      paramString1 = BaseChatPie.this.app.a().b(paramLong2);
      if ((paramString1 != null) && (paramString1.nOpType == 6)) {
        if (awou.nP(paramInt2))
        {
          if (!paramBoolean) {
            break label154;
          }
          awpl.b(BaseChatPie.this.app, BaseChatPie.this.a(), BaseChatPie.this.getTitleBarHeight());
        }
      }
      for (;;)
      {
        BaseChatPie.this.a.notifyDataSetChanged();
        return;
        label154:
        if (awou.aNo())
        {
          awou.eZ(BaseChatPie.this.app);
        }
        else
        {
          if (!TextUtils.isEmpty(paramString2)) {
            QQToast.a(BaseChatPie.this.app.getApp(), paramString2, 1).show(BaseChatPie.this.getTitleBarHeight());
          }
          for (;;)
          {
            awrl.u(null, paramInt2);
            break;
            QQToast.a(BaseChatPie.this.app.getApp(), 2131694100, 1).show(BaseChatPie.this.getTitleBarHeight());
          }
          if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(BaseChatPie.this.sessionInfo.aTl)))
          {
            ahav.n(paramLong2, paramInt2, paramString2);
            awrl.u(null, paramInt2);
          }
        }
      }
    }
    
    public void b(long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void b(long paramLong, String paramString1, int paramInt, String paramString2)
    {
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        ahav.JI(paramString2);
        return;
      }
      ahav.jQ(paramLong);
    }
    
    public void bJi()
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void bJj()
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void bJk()
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void bJl()
    {
      if (BaseChatPie.this.a != null) {
        BaseChatPie.this.a.notifyDataSetChanged();
      }
    }
    
    public void c(long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      BaseChatPie.this.a.notifyDataSetChanged();
    }
    
    public void e(int paramInt, long paramLong, String paramString)
    {
      ahav.n(paramLong, paramInt, paramString);
      awrl.u(null, paramInt);
      if (BaseChatPie.this.a != null) {
        BaseChatPie.this.a.notifyDataSetChanged();
      }
    }
  }
  
  class c
    extends GestureDetector.SimpleOnGestureListener
  {
    c() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      BaseChatPie.this.R(paramMotionEvent);
      return super.onDoubleTap(paramMotionEvent);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return super.onDown(paramMotionEvent);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
      ((wwd)BaseChatPie.this.a(26)).ccA();
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((BaseChatPie.access$800() == 1) && (!BaseChatPie.a(BaseChatPie.this).booleanValue())) {
        if (BaseChatPie.this.b.getCount() != 0) {}
      }
      do
      {
        return false;
        if ((BaseChatPie.this.b != null) && (BaseChatPie.this.b.getLastVisiblePosition() >= BaseChatPie.this.b.getCount() - 1))
        {
          paramMotionEvent1 = new int[2];
          BaseChatPie.this.b.getChildAt(BaseChatPie.this.b.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
          int i = paramMotionEvent1[1];
          if (BaseChatPie.g(BaseChatPie.this) == i)
          {
            BaseChatPie.this.Ai(1);
            BaseChatPie.a(BaseChatPie.this, Boolean.valueOf(true));
            BaseChatPie.e(BaseChatPie.this, -1);
          }
          BaseChatPie.e(BaseChatPie.this, i);
        }
        if (BaseChatPie.a(BaseChatPie.this)) {
          BaseChatPie.this.wb(true);
        }
      } while (paramFloat2 >= 0.0F);
      BaseChatPie.this.aSK = false;
      return false;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(BaseChatPie.this.TAG, 2, "onShowPress");
      }
      BaseChatPie.this.wc(false);
      BaseChatPie.this.wb(true);
      super.onShowPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = (adyf)BaseChatPie.this.a(50);
      if (paramMotionEvent != null) {
        paramMotionEvent.GQ(true);
      }
      BaseChatPie.this.wc(false);
      BaseChatPie.this.wb(true);
      if (paramMotionEvent != null) {
        paramMotionEvent.GQ(false);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */