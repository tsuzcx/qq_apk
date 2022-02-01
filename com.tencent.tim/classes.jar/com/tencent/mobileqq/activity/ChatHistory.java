package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import acbn;
import acei;
import acff;
import acfp;
import achq;
import achs;
import acja;
import aczw;
import afnu;
import afpu;
import agkf;
import aixk;
import ajdg;
import akwh;
import anbk;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import anqu;
import anqv;
import anre;
import aofk;
import aoon;
import apdg;
import apdg.a;
import appb;
import apsa;
import apsb;
import apsb.a;
import apuh;
import aqdx;
import aqeb;
import aqft;
import aqfw;
import aqge;
import aqgq;
import aqgv;
import aqha;
import aqho;
import aqhq;
import aqir;
import aqiu;
import aqiw;
import aqju;
import aqoa;
import arhz;
import asgx;
import aurd;
import aurf;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.tencent.tim.todo.MessageForToDo;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jof;
import jof.a;
import jqs;
import localpb.richMsg.RichMsg.PttRec;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import obt;
import org.json.JSONObject;
import top;
import uml;
import umn;
import umo;
import ump;
import umq;
import umr;
import ums;
import umt;
import umu;
import umv;
import umw;
import umx;
import umy;
import umz;
import una;
import unb;
import unc;
import und;
import unf;
import ung;
import unh;
import uni;
import unj;
import unk;
import unl;
import unm;
import unn;
import uno;
import unp;
import unq;
import unr;
import uns;
import vea;
import wja;
import wly;
import wlz;
import xkl;
import zme;

public class ChatHistory
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  protected static Toast mToast;
  public String Bn;
  public TextView CC;
  TextView CD;
  public TextView CE;
  public Dialog D;
  public Dialog E;
  public Dialog F;
  protected long FF;
  final String TAG = "ChatHistory";
  aqeb jdField_a_of_type_Aqeb;
  public a a;
  b jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b = new b();
  public d a;
  protected AudioPlayer a;
  protected AudioPlayerBase.a a;
  protected ProxyObserver a;
  public TipsBar a;
  public zme a;
  public String aLT;
  protected int aN;
  protected boolean aTM;
  protected boolean aTN;
  protected boolean aTO;
  public boolean aTP = false;
  protected float ai;
  public EditText au;
  public akwh b;
  Handler.Callback b;
  protected Object bE = new Object();
  public int bFe = 0;
  int bFf;
  int bFg;
  int bFh;
  int bFi;
  final int bFj = 60;
  public int bFk = 999;
  int bFl = 0;
  public Handler bK = new umx(this);
  public SessionInfo c;
  protected Button cY;
  protected Button cZ;
  protected EntityManager d;
  protected boolean dy;
  protected achq e = new umz(this);
  AbsListView.e h = new unc(this);
  protected StringBuffer i = new StringBuffer();
  public long iu = 0L;
  public XListView k;
  public float mDensity;
  public int mScrollState;
  protected Sensor mSensor;
  public SensorManager mSensorManager;
  public int mType;
  public String mUin;
  AnimationDrawable n = null;
  AnimationDrawable o;
  public MqqHandler o;
  protected AnimationDrawable p;
  public ImageView pA;
  public ImageView pB;
  public int pageCount;
  View rO;
  protected arhz u;
  public int uo = 1;
  public arhz z;
  
  public ChatHistory()
  {
    this.jdField_o_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    this.jdField_b_of_type_Akwh = null;
    this.jdField_b_of_type_AndroidOsHandler$Callback = new uml(this);
    this.jdField_o_of_type_MqqOsMqqHandler = new aurf(this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new una(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a = new unb(this);
  }
  
  private void Aq(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "recordCount : " + paramInt);
    }
    paramInt = this.bFl + paramInt;
    if (paramInt <= 0) {}
    int j;
    do
    {
      return;
      j = (paramInt - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "pageIndex = " + j);
      }
    } while (j < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo = ((paramInt - 1) % 8);
    this.au.setText(String.valueOf(j));
    this.au.setSelection(this.au.getText().length());
  }
  
  private void E(MessageRecord paramMessageRecord)
  {
    Aq(this.app.b().a(this.mUin, this.mType, paramMessageRecord));
  }
  
  public static final int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = paramQQAppInterface.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    if (paramInt == 0)
    {
      paramQQAppInterface = new StringBuilder(" msgtype ");
      paramQQAppInterface.append(top.ox());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    for (paramQQAppInterface = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", paramQQAppInterface.toString(), ""); paramQQAppInterface == null; paramQQAppInterface = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, paramQQAppInterface.toString()))
    {
      return 0;
      paramQQAppInterface = new StringBuilder(" where msgtype ");
      paramQQAppInterface.append(top.ox());
      paramQQAppInterface.append(" and isValid=1 ");
    }
    paramQQAppInterface = localSQLiteDatabase.rawQuery(paramQQAppInterface.toString(), null);
    if (paramQQAppInterface == null) {
      return 0;
    }
    long l;
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      if (paramInt != 3000) {
        break label225;
      }
      l = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramQQAppInterface.getCount();
      paramQQAppInterface.close();
      return paramInt;
      label225:
      if (paramInt == 0) {
        l = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof XListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static boolean hd(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.trim().equals("")) || (paramString.contains("\n"))) {
      bool = false;
    }
    while (!Pattern.compile("^[*+,./\\\"=_-]+").matcher(paramString.substring(0, 1)).matches()) {
      return bool;
    }
    return false;
  }
  
  public void Ar(int paramInt)
  {
    if (paramInt > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.mType == 0) && (((CheckBox)this.E.findViewById(2131365677)).isChecked()))
    {
      bJJ();
      this.app.a().eE(this.mUin, this.mType);
    }
  }
  
  public void As(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).show(getResources().getDimensionPixelSize(2131299627));
  }
  
  void F(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ausj localausj = (ausj)auss.a(this, null);
      localausj.setMainTitle(getResources().getString(2131698325));
      localausj.addButton(2131692505, 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new und(this, paramMessageRecord, localausj));
      localausj.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  protected MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (paramInt1 == 10002) || (aqfw.mn(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return aqfw.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = aqiu.mt(paramInt3);
      localMsgBody.msg = aqiu.a(aoon.t(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = aqiu.a(this.app, aoon.t(paramString), this, this.mUin, null, this.mType);
      localMsgBody.action = null;
      return localMsgBody;
    }
    MsgBody localMsgBody = new MsgBody();
    localMsgBody.msg = paramString;
    localMsgBody.action = null;
    return localMsgBody;
  }
  
  public Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistory", 2, "MessageProvide getDB null!");
      }
    }
    do
    {
      return null;
      if (paramString1.indexOf("mr_troop_") == -1) {
        break;
      }
      paramString3 = " where " + paramString3;
      paramString2 = aqir.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
    } while (paramString2 == null);
    paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
        continue;
      }
      return paramString1;
      if (paramString1.indexOf("mr_grp_") != -1)
      {
        paramString2 = new StringBuilder("select * from ");
        paramString2.append(paramString1);
        paramString2.append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString2.append(" where ");
          paramString2.append(paramString3);
        }
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("gene", 2, "cursor: " + paramString2);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          for (;;)
          {
            paramString2 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
        }
      }
      else
      {
        if (paramString1.indexOf("mr_discusssion_") != -1)
        {
          paramString3 = " where " + paramString3;
          paramString2 = aqir.b(paramString2, paramString1, localSQLiteDatabase, paramString3);
          if (paramString2 == null) {
            break;
          }
          paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          try
          {
            paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = aqir.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        if (paramString2 != null) {
          try
          {
            paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.query(paramString1, null, paramString3, null, null, null);
          }
        } else {
          paramString1 = null;
        }
      }
    }
  }
  
  protected void a(ImageView paramImageView, afpu paramafpu)
  {
    if ((paramImageView != null) && (paramafpu != null) && (paramafpu.ajH()))
    {
      paramafpu = paramafpu.a("fromAIO", true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        afpu.p((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramafpu);
    }
  }
  
  public void aL(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  protected String aS(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  public void ao(Message paramMessage)
  {
    this.jdField_o_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 0L);
  }
  
  public void az(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new ChatHistory.8(this, paramBoolean, paramInt));
  }
  
  protected EntityManager b()
  {
    if ((this.d == null) || (!this.d.isOpen())) {}
    synchronized (this.bE)
    {
      if ((this.d == null) || (!this.d.isOpen())) {
        this.d = this.app.a().createMessageRecordEntityManager();
      }
      return this.d;
    }
  }
  
  protected String b(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramAbsStructMsg.mMsgServiceID == 80)
    {
      localStringBuffer.append("[");
      localStringBuffer.append(paramAbsStructMsg.mSourceName);
      localStringBuffer.append("]");
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
      return localStringBuffer.toString();
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + getString(2131720494) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  protected void b(ImageView paramImageView, afpu paramafpu)
  {
    if ((paramImageView != null) && (paramafpu != null) && (paramafpu.ajH()))
    {
      paramafpu = paramafpu.a("fromAIO", true);
      if ((paramafpu instanceof URLDrawable)) {
        afpu.o((URLDrawable)paramafpu);
      }
      paramImageView.setImageDrawable(paramafpu);
    }
  }
  
  protected void bJB()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = new TipsBar(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setBarType(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsIcon(getActivity().getResources().getDrawable(2130838366));
    localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar, localLayoutParams);
    this.k.addHeaderView(localRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new unf(this));
    this.CE = this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.getTextView();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  void bJC()
  {
    if (this.aTM) {
      return;
    }
    this.rO = ((RelativeLayout)View.inflate(this, 2131563007, null));
    int j = (int)aqho.convertDpToPixel(this, 6.0F);
    Object localObject = new RelativeLayout(this);
    ((RelativeLayout)localObject).setPadding(0, j, 0, j);
    ((RelativeLayout)localObject).setBackgroundResource(2130851331);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299266));
    ((RelativeLayout)localObject).addView(this.rO, localLayoutParams);
    this.k.addHeaderView((View)localObject);
    this.rO.findViewById(2131363801).setVisibility(8);
    localObject = (EditText)this.rO.findViewById(2131366542);
    ((EditText)localObject).setFocusableInTouchMode(false);
    ((EditText)localObject).setCursorVisible(false);
    ((EditText)localObject).setOnClickListener(new unj(this));
    setLayerType(this.rO);
  }
  
  public void bJD()
  {
    this.pA = ((ImageView)findViewById(2131368853));
    this.pB = ((ImageView)findViewById(2131368854));
    this.pA.setContentDescription(getString(2131691422));
    this.pB.setContentDescription(getString(2131691421));
    this.pA.setOnClickListener(new unk(this));
    this.pB.setOnClickListener(new umn(this));
    this.pB.setEnabled(false);
    this.pB.setImageResource(2130850446);
    if (this.pageCount == 1)
    {
      this.pA.setEnabled(false);
      this.pA.setImageResource(2130841231);
    }
    this.CD = ((TextView)findViewById(2131379429));
    this.CD.setText(String.valueOf(this.pageCount));
    this.au = ((EditText)findViewById(2131366205));
    this.au.setText(String.valueOf(this.uo));
    this.au.setSelection(this.au.getText().toString().length());
    this.au.addTextChangedListener(new umo(this));
    this.cY = ((Button)findViewById(2131364090));
    this.cY.setOnClickListener(new ump(this));
    this.cZ = ((Button)findViewById(2131364089));
    this.cZ.setOnClickListener(new umq(this));
    if (this.aTM)
    {
      this.cY.setVisibility(8);
      this.cZ.setVisibility(8);
    }
    if ((this.mType == 1001) || (this.mType == 10002) || (this.mType == 10004) || (this.mType == 1000) || (this.mType == 1020) || (this.mType == 1005) || (this.mType == 1004) || (this.mType == 1009) || (this.mType == 1010) || (this.mType == 1023) || (this.mType == 1024)) {
      this.CC.setVisibility(4);
    }
    for (;;)
    {
      this.CC.setOnClickListener(new umr(this));
      return;
      if ((this.mType != 1) && (this.mType != 3000))
      {
        acff localacff = (acff)this.app.getManager(51);
        if ((localacff == null) || (!localacff.isFriend(String.valueOf(this.mUin))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localacff);
          }
          this.CC.setVisibility(4);
        }
      }
    }
  }
  
  public void bJE()
  {
    bJF();
    this.au.setText(String.valueOf(this.uo));
    this.au.setSelection(this.au.getText().length());
    this.CD.setText(String.valueOf(this.pageCount));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.O(this.mUin, this.mType, this.bFe);
  }
  
  public void bJF()
  {
    this.uo = this.pageCount;
    this.bFe = ((this.uo - 1) * 8);
  }
  
  public void bJG()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.uo > this.pageCount)
    {
      this.uo = this.pageCount;
      this.bFe = ((this.uo - 1) * 8);
    }
    this.au.setText(String.valueOf(this.uo));
    this.au.setSelection(this.au.getText().length());
    this.CD.setText(String.valueOf(this.pageCount));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.O(this.mUin, this.mType, this.bFe);
  }
  
  public void bJH()
  {
    this.jdField_o_of_type_MqqOsMqqHandler.obtainMessage(4, getResources().getString(2131720488)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void bJI()
  {
    achs localachs = (achs)this.app.getManager(92);
    if (localachs != null)
    {
      long l = NetConnInfoCenter.getServerTime();
      this.app.a().a(this.mUin, l - 604800L, 0L, l, (short)0, 0L, 1, null, localachs.getAuthMode(), false, 0, false);
    }
  }
  
  protected void bJJ()
  {
    if (!aqiw.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131692530, 1).show();
      return;
    }
    vl(getApplication().getResources().getString(2131692531));
    this.app.a().El(this.mUin);
  }
  
  public void bJK()
  {
    this.i.setLength(0);
    String str;
    if (this.Bn.compareTo(this.mUin) == 0)
    {
      str = this.Bn;
      if (!hd(str)) {
        break label197;
      }
      str = str.replaceAll("[\\\\/:*?\"<>|]", "");
      this.i.append(str + ".txt");
    }
    for (;;)
    {
      boolean bool = aqhq.a(acbn.blW, this.i, ".txt");
      this.F = aqha.a(this, 230, getString(2131691983), getString(2131691983) + acbn.blW + this.i.toString(), new umu(this), new umv(this));
      if (!bool) {
        break label231;
      }
      this.F.show();
      return;
      str = String.format("%s(%s)", new Object[] { this.Bn, this.mUin });
      break;
      label197:
      this.i.append(this.mUin + ".txt");
    }
    label231:
    vk(getString(2131693299));
  }
  
  public void bJL()
  {
    this.F = aqha.a(this, 230, getString(2131720490), getString(2131721136), new umw(this), new umy(this));
    this.F.show();
  }
  
  protected void bJM()
  {
    if (mToast != null)
    {
      mToast.cancel();
      mToast = null;
    }
  }
  
  protected void bJN()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.stop();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  public void bJO()
  {
    aqge.ce(2131230744, false);
  }
  
  protected void bJP()
  {
    this.mSensorManager = ((SensorManager)this.app.getApplication().getSystemService("sensor"));
    this.mSensor = this.mSensorManager.getDefaultSensor(8);
    if (this.mSensor != null)
    {
      this.ai = this.mSensor.getMaximumRange();
      if (this.ai <= 10.0F) {
        break label72;
      }
    }
    label72:
    for (float f = 10.0F;; f = this.ai)
    {
      this.ai = f;
      return;
    }
  }
  
  public void bJQ()
  {
    try
    {
      if (this.u != null)
      {
        this.u.dismiss();
        this.u.cancel();
        this.u = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void bJR()
  {
    if (this.c != null) {
      switch (this.c.cZ)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "AIO_chatlog arg:" + this.bFk);
      }
      anot.a(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", this.bFk, 0, String.valueOf(this.bFk), "", "", "");
      return;
      this.bFk = 0;
      continue;
      this.bFk = 3;
      continue;
      this.bFk = 2;
    }
  }
  
  public void bJS()
  {
    if (this.aTO) {
      return;
    }
    this.aTO = true;
    anot.a(this.app, "CliOper", "", "", "0X8005690", "0X8005690", this.bFk, 0, "", "", "", "");
  }
  
  protected void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  @SuppressLint({"NewApi"})
  protected void cg(String paramString, int paramInt)
  {
    this.k = ((XListView)findViewById(2131370538));
    bJC();
    bJB();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a = new a(this, null);
    this.k.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a);
    this.k.setOnScrollListener(this.h);
    this.k.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.k.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.O(paramString, paramInt, this.bFe);
  }
  
  /* Error */
  protected void ch(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 296
    //   3: astore 7
    //   5: new 115	java/lang/StringBuffer
    //   8: dup
    //   9: invokespecial 116	java/lang/StringBuffer:<init>	()V
    //   12: astore 10
    //   14: iload_2
    //   15: iconst_1
    //   16: if_icmpeq +10 -> 26
    //   19: iload_2
    //   20: sipush 3000
    //   23: if_icmpne +506 -> 529
    //   26: aload_1
    //   27: iload_2
    //   28: invokestatic 291	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   31: aload_1
    //   32: iload_2
    //   33: invokestatic 294	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   43: invokestatic 1207	aqir:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/lang/StringBuilder;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnull +1264 -> 1314
    //   53: aload_0
    //   54: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   60: aload 6
    //   62: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: aconst_null
    //   66: invokevirtual 312	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore 8
    //   71: iload_2
    //   72: iconst_1
    //   73: if_icmpne +61 -> 134
    //   76: aload_0
    //   77: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   80: aload_1
    //   81: iconst_1
    //   82: invokestatic 1212	aqgv:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   85: astore_1
    //   86: aload 10
    //   88: new 196	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   95: aload_0
    //   96: ldc_w 1213
    //   99: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   102: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 1215
    //   108: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 698	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: aload 10
    //   120: aload_1
    //   121: invokevirtual 698	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   124: pop
    //   125: aload 10
    //   127: ldc_w 1217
    //   130: invokevirtual 698	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: aload 8
    //   136: ifnull +350 -> 486
    //   139: aload 8
    //   141: invokeinterface 1220 1 0
    //   146: ifeq +340 -> 486
    //   149: aload 7
    //   151: astore 6
    //   153: aload 8
    //   155: aload 8
    //   157: ldc_w 338
    //   160: invokeinterface 326 2 0
    //   165: invokeinterface 1223 2 0
    //   170: istore 4
    //   172: aload 8
    //   174: aload 8
    //   176: ldc_w 1225
    //   179: invokeinterface 326 2 0
    //   184: invokeinterface 1226 2 0
    //   189: astore_1
    //   190: iconst_1
    //   191: iload_2
    //   192: if_icmpne +428 -> 620
    //   195: aload_0
    //   196: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   199: aload_0
    //   200: getfield 259	com/tencent/mobileqq/activity/ChatHistory:mUin	Ljava/lang/String;
    //   203: invokestatic 1232	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   206: ifeq +381 -> 587
    //   209: aload_0
    //   210: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   213: aload_0
    //   214: getfield 259	com/tencent/mobileqq/activity/ChatHistory:mUin	Ljava/lang/String;
    //   217: aload_1
    //   218: invokestatic 1235	aqgv:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   221: astore_1
    //   222: aload 8
    //   224: aload 8
    //   226: ldc_w 1237
    //   229: invokeinterface 326 2 0
    //   234: invokeinterface 1223 2 0
    //   239: istore_3
    //   240: iload_3
    //   241: invokestatic 1240	aqiu:ms	(I)Z
    //   244: ifeq +421 -> 665
    //   247: aload_0
    //   248: invokevirtual 1243	com/tencent/mobileqq/activity/ChatHistory:oO	()Ljava/lang/String;
    //   251: astore 9
    //   253: aload 8
    //   255: ldc_w 1245
    //   258: invokeinterface 326 2 0
    //   263: iflt +23 -> 286
    //   266: aload 8
    //   268: aload 8
    //   270: ldc_w 1245
    //   273: invokeinterface 326 2 0
    //   278: invokeinterface 1223 2 0
    //   283: ifgt +388 -> 671
    //   286: aload 8
    //   288: aload 8
    //   290: ldc_w 1246
    //   293: invokeinterface 326 2 0
    //   298: invokeinterface 1226 2 0
    //   303: astore_1
    //   304: aconst_null
    //   305: astore 6
    //   307: aload_1
    //   308: ifnull +17 -> 325
    //   311: new 1248	aofk
    //   314: dup
    //   315: aload_1
    //   316: iconst_3
    //   317: invokespecial 1251	aofk:<init>	(Ljava/lang/CharSequence;I)V
    //   320: invokevirtual 1254	aofk:AE	()Ljava/lang/String;
    //   323: astore 6
    //   325: aload 6
    //   327: astore 7
    //   329: aload 6
    //   331: ifnull +67 -> 398
    //   334: aload 6
    //   336: astore 7
    //   338: aload 6
    //   340: invokevirtual 567	java/lang/String:length	()I
    //   343: ifle +55 -> 398
    //   346: aload 6
    //   348: astore 7
    //   350: aload_0
    //   351: aload 6
    //   353: invokevirtual 1257	com/tencent/mobileqq/activity/ChatHistory:gK	(Ljava/lang/String;)Z
    //   356: ifeq +42 -> 398
    //   359: aload 6
    //   361: ldc_w 1259
    //   364: invokevirtual 1262	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   367: iconst_1
    //   368: aaload
    //   369: ldc_w 1264
    //   372: invokevirtual 1262	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   375: astore 7
    //   377: aload 7
    //   379: arraylength
    //   380: iconst_2
    //   381: if_icmpge +853 -> 1234
    //   384: iconst_1
    //   385: istore_3
    //   386: goto +934 -> 1320
    //   389: aload_0
    //   390: ldc_w 1265
    //   393: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   396: astore 7
    //   398: new 196	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   405: aload_0
    //   406: iload 4
    //   408: i2l
    //   409: ldc2_w 1266
    //   412: lmul
    //   413: invokevirtual 1269	com/tencent/mobileqq/activity/ChatHistory:aS	(J)Ljava/lang/String;
    //   416: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc_w 1271
    //   422: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 9
    //   427: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 1273
    //   433: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 7
    //   438: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: astore 6
    //   446: aload 10
    //   448: new 196	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   455: aload 6
    //   457: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc_w 1275
    //   463: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokevirtual 698	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   472: pop
    //   473: aload_1
    //   474: astore 6
    //   476: aload 8
    //   478: invokeinterface 1278 1 0
    //   483: ifne -330 -> 153
    //   486: aload 8
    //   488: ifnull +10 -> 498
    //   491: aload 8
    //   493: invokeinterface 336 1 0
    //   498: aload_0
    //   499: new 1280	com/tencent/mobileqq/activity/ChatHistory$21
    //   502: dup
    //   503: aload_0
    //   504: getstatic 1005	acbn:blW	Ljava/lang/String;
    //   507: aload_0
    //   508: getfield 118	com/tencent/mobileqq/activity/ChatHistory:i	Ljava/lang/StringBuffer;
    //   511: invokevirtual 707	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   514: aload 10
    //   516: invokevirtual 707	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   519: invokestatic 1283	aqhq:z	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   522: invokespecial 1286	com/tencent/mobileqq/activity/ChatHistory$21:<init>	(Lcom/tencent/mobileqq/activity/ChatHistory;Z)V
    //   525: invokevirtual 1290	com/tencent/mobileqq/activity/ChatHistory:runOnUiThread	(Ljava/lang/Runnable;)V
    //   528: return
    //   529: new 196	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 1292
    //   539: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokestatic 283	top:ox	()Ljava/lang/String;
    //   545: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc_w 1294
    //   551: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: astore 6
    //   559: aload_1
    //   560: iload_2
    //   561: invokestatic 291	com/tencent/mobileqq/data/MessageRecord:getOldTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   564: aload_1
    //   565: iload_2
    //   566: invokestatic 294	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   569: aload_0
    //   570: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   573: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   576: aload 6
    //   578: aconst_null
    //   579: invokestatic 581	aqir:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: astore 6
    //   584: goto -536 -> 48
    //   587: ldc_w 1027
    //   590: iconst_2
    //   591: anewarray 134	java/lang/Object
    //   594: dup
    //   595: iconst_0
    //   596: aload_0
    //   597: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   600: aload_0
    //   601: getfield 259	com/tencent/mobileqq/activity/ChatHistory:mUin	Ljava/lang/String;
    //   604: aload_1
    //   605: invokestatic 1235	aqgv:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   608: aastore
    //   609: dup
    //   610: iconst_1
    //   611: aload_1
    //   612: aastore
    //   613: invokestatic 1030	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   616: astore_1
    //   617: goto -395 -> 222
    //   620: sipush 3000
    //   623: iload_2
    //   624: if_icmpne +33 -> 657
    //   627: ldc_w 1027
    //   630: iconst_2
    //   631: anewarray 134	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: aload_0
    //   637: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   640: aload_1
    //   641: iconst_0
    //   642: invokestatic 1212	aqgv:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   645: aastore
    //   646: dup
    //   647: iconst_1
    //   648: aload_1
    //   649: aastore
    //   650: invokestatic 1030	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   653: astore_1
    //   654: goto -432 -> 222
    //   657: aload_0
    //   658: getfield 987	com/tencent/mobileqq/activity/ChatHistory:Bn	Ljava/lang/String;
    //   661: astore_1
    //   662: goto -440 -> 222
    //   665: aload_1
    //   666: astore 9
    //   668: goto -415 -> 253
    //   671: aload 8
    //   673: aload 8
    //   675: ldc_w 1296
    //   678: invokeinterface 326 2 0
    //   683: invokeinterface 1223 2 0
    //   688: istore 5
    //   690: iload 5
    //   692: sipush -2007
    //   695: if_icmpne +14 -> 709
    //   698: aload_0
    //   699: ldc_w 1297
    //   702: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   705: astore_1
    //   706: goto -402 -> 304
    //   709: iload 5
    //   711: sipush -2058
    //   714: if_icmpne +14 -> 728
    //   717: aload_0
    //   718: ldc_w 1298
    //   721: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   724: astore_1
    //   725: goto -421 -> 304
    //   728: iload 5
    //   730: sipush -2039
    //   733: if_icmpne +50 -> 783
    //   736: aload 8
    //   738: aload 8
    //   740: ldc_w 1300
    //   743: invokeinterface 326 2 0
    //   748: invokeinterface 1304 2 0
    //   753: astore_1
    //   754: new 1306	com/tencent/mobileqq/data/MessageForApollo
    //   757: dup
    //   758: invokespecial 1307	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   761: astore 6
    //   763: aload 6
    //   765: aload_1
    //   766: putfield 1310	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   769: aload 6
    //   771: invokevirtual 1313	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   774: aload 6
    //   776: invokestatic 1318	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Lcom/tencent/mobileqq/data/MessageForApollo;)Ljava/lang/String;
    //   779: astore_1
    //   780: goto -476 -> 304
    //   783: iload 5
    //   785: sipush -2011
    //   788: if_icmpne +31 -> 819
    //   791: aload_0
    //   792: aload 8
    //   794: aload 8
    //   796: ldc_w 1300
    //   799: invokeinterface 326 2 0
    //   804: invokeinterface 1304 2 0
    //   809: invokestatic 1323	anre:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   812: invokevirtual 1325	com/tencent/mobileqq/activity/ChatHistory:b	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;)Ljava/lang/String;
    //   815: astore_1
    //   816: goto -512 -> 304
    //   819: iload 5
    //   821: sipush -2020
    //   824: if_icmpne +58 -> 882
    //   827: iload_3
    //   828: invokestatic 1240	aqiu:ms	(I)Z
    //   831: ifeq +34 -> 865
    //   834: aload_0
    //   835: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   838: invokevirtual 1329	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   841: ldc_w 1330
    //   844: iconst_1
    //   845: anewarray 134	java/lang/Object
    //   848: dup
    //   849: iconst_0
    //   850: aload_0
    //   851: getfield 1119	com/tencent/mobileqq/activity/ChatHistory:c	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   854: getfield 1333	com/tencent/mobileqq/activity/aio/SessionInfo:aTn	Ljava/lang/String;
    //   857: aastore
    //   858: invokevirtual 1338	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   861: astore_1
    //   862: goto -558 -> 304
    //   865: aload_0
    //   866: getfield 252	com/tencent/mobileqq/activity/ChatHistory:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   869: invokevirtual 1329	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   872: ldc_w 1339
    //   875: invokevirtual 1340	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   878: astore_1
    //   879: goto -575 -> 304
    //   882: aload 6
    //   884: astore_1
    //   885: iload 5
    //   887: sipush -2006
    //   890: if_icmpeq -417 -> 473
    //   893: iload 5
    //   895: sipush -2000
    //   898: if_icmpne +13 -> 911
    //   901: ldc_w 1341
    //   904: invokestatic 1346	acfp:m	(I)Ljava/lang/String;
    //   907: astore_1
    //   908: goto -604 -> 304
    //   911: iload 5
    //   913: sipush -2002
    //   916: if_icmpne +13 -> 929
    //   919: ldc_w 1347
    //   922: invokestatic 1346	acfp:m	(I)Ljava/lang/String;
    //   925: astore_1
    //   926: goto -622 -> 304
    //   929: iload 5
    //   931: sipush -2022
    //   934: if_icmpne +13 -> 947
    //   937: ldc_w 1348
    //   940: invokestatic 1346	acfp:m	(I)Ljava/lang/String;
    //   943: astore_1
    //   944: goto -640 -> 304
    //   947: iload 5
    //   949: sipush -2071
    //   952: if_icmpne +14 -> 966
    //   955: aload_0
    //   956: ldc_w 1349
    //   959: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   962: astore_1
    //   963: goto -659 -> 304
    //   966: iload 5
    //   968: sipush -7001
    //   971: if_icmpne +14 -> 985
    //   974: aload_0
    //   975: ldc_w 1350
    //   978: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   981: astore_1
    //   982: goto -678 -> 304
    //   985: iload 5
    //   987: sipush -1035
    //   990: if_icmpne +202 -> 1192
    //   993: new 196	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1000: astore_1
    //   1001: aload 8
    //   1003: aload 8
    //   1005: ldc_w 1300
    //   1008: invokeinterface 326 2 0
    //   1013: invokeinterface 1304 2 0
    //   1018: astore 7
    //   1020: new 1352	localpb/richMsg/MixedMsg$Msg
    //   1023: dup
    //   1024: invokespecial 1353	localpb/richMsg/MixedMsg$Msg:<init>	()V
    //   1027: astore 6
    //   1029: aload 6
    //   1031: aload 7
    //   1033: invokevirtual 1357	localpb/richMsg/MixedMsg$Msg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1036: pop
    //   1037: aload 6
    //   1039: getfield 1361	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1042: invokevirtual 1367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1045: invokeinterface 1372 1 0
    //   1050: ifgt +51 -> 1101
    //   1053: aload 8
    //   1055: ifnull -527 -> 528
    //   1058: aload 8
    //   1060: invokeinterface 336 1 0
    //   1065: return
    //   1066: astore 6
    //   1068: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1071: ifeq +12 -> 1083
    //   1074: ldc 111
    //   1076: iconst_2
    //   1077: ldc_w 1374
    //   1080: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: aload_1
    //   1084: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: astore_1
    //   1088: goto -784 -> 304
    //   1091: astore 7
    //   1093: aload 7
    //   1095: invokevirtual 1375	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1098: goto -61 -> 1037
    //   1101: aload 6
    //   1103: getfield 1361	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1106: invokevirtual 1367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1109: invokeinterface 1372 1 0
    //   1114: istore 5
    //   1116: iconst_0
    //   1117: istore_3
    //   1118: iload_3
    //   1119: iload 5
    //   1121: if_icmpge -38 -> 1083
    //   1124: aload 6
    //   1126: getfield 1361	localpb/richMsg/MixedMsg$Msg:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1129: invokevirtual 1367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1132: iload_3
    //   1133: invokeinterface 1378 2 0
    //   1138: checkcast 1380	localpb/richMsg/MixedMsg$Elem
    //   1141: astore 7
    //   1143: aload 7
    //   1145: getfield 1384	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1148: invokevirtual 1389	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1151: ifeq +19 -> 1170
    //   1154: aload_1
    //   1155: aload 7
    //   1157: getfield 1384	localpb/richMsg/MixedMsg$Elem:textMsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1160: invokevirtual 1391	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1163: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: goto +168 -> 1335
    //   1170: aload 7
    //   1172: getfield 1395	localpb/richMsg/MixedMsg$Elem:picMsg	Llocalpb/richMsg/RichMsg$PicRec;
    //   1175: invokevirtual 1398	localpb/richMsg/RichMsg$PicRec:has	()Z
    //   1178: ifeq +157 -> 1335
    //   1181: aload_1
    //   1182: ldc_w 1400
    //   1185: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: goto +146 -> 1335
    //   1192: new 224	java/lang/String
    //   1195: dup
    //   1196: aload 8
    //   1198: aload 8
    //   1200: ldc_w 1300
    //   1203: invokeinterface 326 2 0
    //   1208: invokeinterface 1304 2 0
    //   1213: ldc_w 1402
    //   1216: invokespecial 1405	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1219: astore_1
    //   1220: goto -916 -> 304
    //   1223: astore_1
    //   1224: aload_1
    //   1225: invokevirtual 1406	java/lang/Exception:printStackTrace	()V
    //   1228: aload 6
    //   1230: astore_1
    //   1231: goto -927 -> 304
    //   1234: aload 7
    //   1236: iconst_2
    //   1237: aaload
    //   1238: invokestatic 1411	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1241: invokevirtual 1414	java/lang/Integer:intValue	()I
    //   1244: istore_3
    //   1245: goto +75 -> 1320
    //   1248: aload 6
    //   1250: astore 7
    //   1252: iload_3
    //   1253: iconst_2
    //   1254: if_icmpne -856 -> 398
    //   1257: new 196	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 695
    //   1267: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload_0
    //   1271: ldc_w 1415
    //   1274: invokevirtual 716	com/tencent/mobileqq/activity/ChatHistory:getString	(I)Ljava/lang/String;
    //   1277: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc_w 703
    //   1283: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1289: astore 7
    //   1291: goto -893 -> 398
    //   1294: astore 7
    //   1296: ldc 111
    //   1298: iconst_1
    //   1299: ldc_w 296
    //   1302: aload 7
    //   1304: invokestatic 1418	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1307: aload 6
    //   1309: astore 7
    //   1311: goto -913 -> 398
    //   1314: aconst_null
    //   1315: astore 8
    //   1317: goto -1246 -> 71
    //   1320: iload_3
    //   1321: iconst_1
    //   1322: if_icmpeq -933 -> 389
    //   1325: iload_3
    //   1326: ldc_w 1419
    //   1329: if_icmpne -81 -> 1248
    //   1332: goto -943 -> 389
    //   1335: iload_3
    //   1336: iconst_1
    //   1337: iadd
    //   1338: istore_3
    //   1339: goto -221 -> 1118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1342	0	this	ChatHistory
    //   0	1342	1	paramString	String
    //   0	1342	2	paramInt	int
    //   239	1100	3	j	int
    //   170	237	4	m	int
    //   688	434	5	i1	int
    //   46	992	6	localObject1	Object
    //   1066	242	6	localException1	Exception
    //   3	1029	7	localObject2	Object
    //   1091	3	7	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1141	149	7	localObject3	Object
    //   1294	9	7	localException2	Exception
    //   1309	1	7	localObject4	Object
    //   69	1247	8	localCursor	Cursor
    //   251	416	9	str	String
    //   12	503	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   1001	1029	1066	java/lang/Exception
    //   1029	1037	1066	java/lang/Exception
    //   1037	1053	1066	java/lang/Exception
    //   1058	1065	1066	java/lang/Exception
    //   1093	1098	1066	java/lang/Exception
    //   1101	1116	1066	java/lang/Exception
    //   1124	1167	1066	java/lang/Exception
    //   1170	1189	1066	java/lang/Exception
    //   1029	1037	1091	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1192	1220	1223	java/lang/Exception
    //   377	384	1294	java/lang/Exception
    //   389	398	1294	java/lang/Exception
    //   1234	1245	1294	java/lang/Exception
    //   1257	1291	1294	java/lang/Exception
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    bm(paramIntent.getExtras());
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.e);
    this.mDensity = getResources().getDisplayMetrics().density;
    this.n = ((AnimationDrawable)getResources().getDrawable(2130772432));
    this.jdField_o_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130772433));
    this.p = ((AnimationDrawable)getResources().getDrawable(2130772334));
    paramBundle = getIntent().getExtras();
    this.mUin = paramBundle.getString("uin");
    this.mType = paramBundle.getInt("uintype");
    this.c = new SessionInfo();
    this.c.aTl = this.mUin;
    this.c.cZ = this.mType;
    this.c.aTn = this.Bn;
    this.c.troopUin = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2131558943);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLinearLayout.setFitsSystemWindows(true);
      localLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.aTM = bool;
    if (bool) {
      this.FF = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    this.app.setHandler(getClass(), this.jdField_o_of_type_MqqOsMqqHandler);
    this.jdField_b_of_type_Akwh = ((akwh)this.app.getManager(201));
    az(9, false);
    initTitle();
    cg(this.mUin, this.mType);
    bJP();
    if (this.app.a() != null) {
      this.app.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().saveNotify();
    this.jdField_a_of_type_Aqeb = new aqeb(this);
    this.jdField_a_of_type_Aqeb.kh((int)(150.0F * this.mDensity), (int)(100.0F * this.mDensity));
    bJR();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.closeCursor();
    }
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this);
    }
    if ((this.d != null) && (this.d.isOpen()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.d.close();
      this.d = null;
    }
    bJM();
    bJQ();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.isFinish))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.bJV();
      this.n.stop();
      this.n = null;
      this.jdField_o_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_o_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.p.stop();
      this.p = null;
    }
    this.jdField_o_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.e);
    if (this.app.a() != null) {
      this.app.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().saveNotify();
    try
    {
      this.jdField_a_of_type_Aqeb.a().edy();
      label251:
      findViewById(2131377546).clearAnimation();
      return;
    }
    catch (Exception localException)
    {
      break label251;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = ChatHistoryC2CAllFragment.a(paramIntent);
    if (paramIntent != null) {
      E(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.isFinish)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.bJV();
    }
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    if ((this.aTM) && (!this.aTN) && (this.jdField_o_of_type_MqqOsMqqHandler != null))
    {
      this.aTN = true;
      this.jdField_o_of_type_MqqOsMqqHandler.postDelayed(new ChatHistory.22(this), 300L);
    }
  }
  
  public void eX(int paramInt1, int paramInt2)
  {
    this.aN = paramInt1;
    if (paramInt2 > 0)
    {
      if (paramInt2 < 8)
      {
        paramInt2 = 1;
        if (paramInt1 >= 8) {
          break label79;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        this.pageCount = (paramInt1 + paramInt2);
        this.bFl = (paramInt2 * 8);
        this.aN += this.bFl;
        return;
        if (paramInt2 % 8 == 0) {
          paramInt2 /= 8;
        }
        for (;;)
        {
          break;
          paramInt2 = paramInt2 / 8 + 1;
        }
        label79:
        if (paramInt1 % 8 == 0) {
          paramInt1 /= 8;
        } else {
          paramInt1 = paramInt1 / 8 + 1;
        }
      }
    }
    if (this.aN < 8)
    {
      this.pageCount = 1;
      return;
    }
    if (this.aN % 8 == 0) {}
    for (paramInt1 = this.aN / 8;; paramInt1 = this.aN / 8 + 1)
    {
      this.pageCount = paramInt1;
      return;
    }
  }
  
  boolean fZ(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.pageCount * 8)) {
      return false;
    }
    this.aTN = true;
    int j = (paramInt - 1) / 8;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$a.bFo = ((paramInt - 1) % 8);
    this.au.setText(String.valueOf(j + 1));
    this.au.setSelection(this.au.getText().length());
    return true;
  }
  
  public void finish()
  {
    super.finish();
  }
  
  boolean gK(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public void gX()
  {
    View localView1 = findViewById(2131379879);
    View localView2 = findViewById(2131377546);
    int j = localView1.getHeight();
    this.jdField_a_of_type_Zme = new zme(this, this.app, this.c);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -j);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -j, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new ung(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new unh(this, localView2, j));
    this.jdField_a_of_type_Zme.setOnDismissListener(new uni(this, localView2, j, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  protected boolean he(String paramString)
  {
    bJN();
    MediaPlayerManager.a(this.app).stop(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.play(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.mSensor != null)) {
      this.mSensorManager.registerListener(this, this.mSensor, 2);
    }
    return bool;
  }
  
  protected void initTitle()
  {
    String str = getResources().getString(2131691410);
    if (this.mType == 0) {
      if (this.mUin.equals(String.valueOf(acbn.bkD)))
      {
        this.Bn = getResources().getString(2131720683);
        if (!this.mUin.equals(String.valueOf(acbn.bkD))) {
          break label366;
        }
        str = getResources().getString(2131720683);
      }
    }
    label366:
    for (;;)
    {
      if ((this.Bn == null) || (this.Bn.trim().equals(""))) {
        this.Bn = this.mUin;
      }
      setTitle(str);
      this.aLT = oO();
      this.c.aTn = this.Bn;
      this.leftView = ((TextView)findViewById(2131369579));
      return;
      this.Bn = aqgv.a(this.app, this.c.aTl, this.c.troopUin, aqgv.jZ(this.c.cZ), 3);
      break;
      if (this.mType == 1)
      {
        this.Bn = ((TroopManager)this.app.getManager(52)).jo(this.mUin);
      }
      else if ((this.mType == 1000) || (this.mType == 1020) || (this.mType == 1001) || (this.mType == 10002) || (this.mType == 10004) || (this.mType == 1004))
      {
        this.Bn = aqgv.o(this.app, this.mUin);
      }
      else if (this.mType == 3000)
      {
        this.Bn = aqgv.v(this.app, this.mUin);
      }
      else if (this.mType == 1024)
      {
        PublicAccountInfo localPublicAccountInfo = ((acja)this.app.getManager(56)).b(this.mUin);
        if (localPublicAccountInfo != null) {
          this.Bn = localPublicAccountInfo.name;
        }
      }
    }
  }
  
  protected String oO()
  {
    String str = aqgv.n(this.app, this.app.getCurrentAccountUin());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.app.getCurrentAccountUin();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.au != null) {
        aurd.hide(this.au);
      }
      setResult(-1);
      if ((this.jdField_a_of_type_Zme != null) && (this.jdField_a_of_type_Zme.Vv()))
      {
        this.jdField_a_of_type_Zme.show();
        this.jdField_a_of_type_Zme.BM(false);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return super.onBackEvent();
  }
  
  public View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.mType) || (1 == this.mType)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131718889);
      this.CC = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (wja.Rc()) {}
    boolean bool1;
    label26:
    label61:
    do
    {
      return;
      if (paramSensorEvent.values[0] >= this.ai) {
        break;
      }
      bool1 = true;
      if (this.dy == bool1) {
        break label93;
      }
      this.dy = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (this.dy) {
          break label95;
        }
        bool1 = bool2;
        paramSensorEvent.ar(bool1);
      }
    } while (AppSetting.enableTalkBack);
    if (this.dy) {}
    for (int j = 2131720476;; j = 2131720479)
    {
      As(j);
      return;
      bool1 = false;
      break label26;
      label93:
      break;
      label95:
      bool1 = false;
      break label61;
    }
  }
  
  protected void s(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.p.setBounds(0, 0, this.p.getMinimumWidth(), this.p.getMinimumHeight());
      paramImageView.setImageDrawable(this.p);
      this.p.stop();
      this.p.start();
    }
  }
  
  protected void t(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.p.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130848001));
    }
  }
  
  public void vj(String paramString)
  {
    View localView = getLayoutInflater().inflate(2131559227, null);
    if (1 == this.mType)
    {
      ((TextView)localView.findViewById(2131379420)).setText(2131691979);
      localView.findViewById(2131365677).setVisibility(8);
    }
    for (;;)
    {
      if (!isFinishing())
      {
        this.E = aqha.a(this, 230).setTitle(getString(2131692526)).setPositiveButton(getString(2131692505), new umt(this, paramString)).setNegativeButton(getString(2131691040), new ums(this)).addView(localView);
        this.E.show();
      }
      return;
      if (3000 == this.mType)
      {
        ((TextView)localView.findViewById(2131379420)).setText(2131691976);
        localView.findViewById(2131365677).setVisibility(8);
      }
      else if ((1001 == this.mType) || (10002 == this.mType) || (1000 == this.mType) || (10004 == this.mType) || (1020 == this.mType) || (1004 == this.mType))
      {
        localView.findViewById(2131365677).setVisibility(8);
      }
    }
  }
  
  public void vk(String paramString)
  {
    if (mToast == null) {
      mToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      mToast.show();
      return;
      mToast.setText(paramString);
    }
  }
  
  protected void vl(String paramString)
  {
    if (this.u == null) {
      this.u = new arhz(this, getTitleBarHeight());
    }
    this.u.setCancelable(true);
    this.u.setMessage(paramString);
    this.u.show();
  }
  
  public class a
    extends CursorAdapter
  {
    protected int bFn = 1000;
    public int bFo = -1;
    protected int displayWidth;
    public Context mContext;
    protected LayoutInflater mInflater;
    
    public a(Context paramContext, Cursor paramCursor)
    {
      super(paramCursor);
      this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      this.mContext = paramContext;
      if (ChatHistory.this.mDensity < 1.0F)
      {
        ChatHistory.this.bFg = ((int)(100.0F * ChatHistory.this.mDensity));
        ChatHistory.this.bFf = ((int)(ChatHistory.this.mDensity * 34.0F));
        ChatHistory.this.bFh = ((int)(ChatHistory.this.mDensity * 14.0F));
      }
      for (ChatHistory.this.bFi = ((int)(ChatHistory.this.mDensity * 15.0F));; ChatHistory.this.bFi = ((int)(ChatHistory.this.mDensity * 15.0F)))
      {
        this$1 = paramContext.getResources().getDisplayMetrics();
        this.displayWidth = Math.min(ChatHistory.this.widthPixels, ChatHistory.this.heightPixels);
        return;
        ChatHistory.this.bFg = ((int)(120.0F * ChatHistory.this.mDensity));
        ChatHistory.this.bFf = ((int)(ChatHistory.this.mDensity * 34.0F));
        ChatHistory.this.bFh = ((int)(ChatHistory.this.mDensity * 14.0F));
      }
    }
    
    public void O(String paramString, int paramInt1, int paramInt2)
    {
      ThreadManager.getSubThreadHandler().post(new ChatHistory.ChatHistoryAdapter.10(this, paramInt1, paramInt2, paramString));
    }
    
    public void a(Cursor paramCursor, TextView paramTextView1, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, TextView paramTextView2, ChatHistory.c paramc, ImageView paramImageView1, CharSequence paramCharSequence, ChatThumbView paramChatThumbView, View paramView1, View paramView2, ImageView paramImageView2, long paramLong)
      throws Exception
    {
      Object localObject = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("Emoji_Sticker_Info"))
        {
          i = new JSONObject(((JSONObject)localObject).getString("Emoji_Sticker_Info")).getInt("msgType");
          if (i != -1000) {
            break label286;
          }
          i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          paramTextView1.setVisibility(0);
          if (!anbk.ls(paramInt1))
          {
            paramTextView1.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            paramTextView1.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
          }
          if (!String.valueOf(acbn.bkD).equals(paramString1)) {
            break label184;
          }
          paramCursor = SystemMsg.decode(ChatHistory.this.app, paramString2, paramString3, i);
          if (paramCursor != null)
          {
            paramTextView1.setText(paramCursor.message);
            if (paramInt2 == 32769) {
              paramTextView2.setText(paramCursor.troopCode);
            }
          }
        }
      }
      for (;;)
      {
        return;
        label184:
        if (-2008 == i)
        {
          paramTextView1.setText(ChatHistory.this.getString(2131719353));
          return;
        }
        if (-1002 == i)
        {
          paramTextView1.setText(paramc.message.getExtInfoFromExtStr("sens_msg_original_text"));
          return;
        }
        paramInt1 = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
        if ((paramImageView1 != null) && (paramInt1 == 32768)) {
          paramImageView1.setVisibility(0);
        }
        paramTextView1.setText(new aofk(paramCharSequence, 13, 32, ChatHistory.this.mType));
        return;
        label286:
        if (i == -2000)
        {
          if ((paramc.message instanceof MessageForPic))
          {
            if (acei.W(paramc.message))
            {
              paramTextView1.setVisibility(0);
              paramTextView1.setText(ChatHistory.this.getString(2131692311));
              paramTextView1.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              paramTextView1.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              return;
            }
            paramCursor = (MessageForPic)paramc.message;
            paramCursor.parse();
            paramTextView1 = new vea();
            paramChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            paramChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            paramTextView1.b = paramCursor;
            paramTextView1.I = paramChatThumbView;
            if (QLog.isColorLevel()) {
              QLog.d("history", 2, "bindView pic.path:" + paramCursor.path + ",pic.uuid:" + paramCursor.uuid);
            }
            if ((paramTextView1.b != null) && (paramTextView1.b.path != null)) {
              a(paramTextView1);
            }
          }
          else if ((QLog.isColorLevel()) && (paramc.message != null))
          {
            QLog.d("history", 2, "not messageforpicuniseq:" + paramc.message.uniseq + ",dbid:" + paramc.message.getId() + "istroop:" + paramc.message.istroop + ",msgtype:" + paramc.message.msgtype);
          }
        }
        else if (i == -2007)
        {
          paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
          try
          {
            paramCursor = aczw.c(paramCursor);
            if ((paramCursor instanceof MarkFaceMessage))
            {
              paramChatThumbView.setVisibility(0);
              paramTextView1.setVisibility(8);
              paramImageView1.setVisibility(8);
              paramView1.setVisibility(8);
              paramView2.setVisibility(8);
              paramChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              paramChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              paramChatThumbView.setTag(paramString1 + paramLong);
              paramImageView2.setTag(null);
              a(paramChatThumbView, (MarkFaceMessage)paramCursor, paramImageView2, paramc.message);
              return;
            }
          }
          catch (Exception paramCursor)
          {
            QLog.e("ChatHistory", 1, "dealStikerMessage e = " + paramCursor);
          }
        }
      }
    }
    
    public void a(ImageView paramImageView, int paramInt, afpu paramafpu, MessageRecord paramMessageRecord)
    {
      if (paramafpu == null) {
        paramImageView.setImageResource(2130838097);
      }
      do
      {
        for (;;)
        {
          paramImageView.setOnClickListener(new unq(this, paramMessageRecord));
          return;
          if (paramInt != 2) {
            break label242;
          }
          if (paramafpu.ajH()) {
            break;
          }
          paramafpu = paramafpu.a(this.mContext, ChatHistory.this.mDensity);
          if (paramafpu != null)
          {
            paramImageView.setImageDrawable(paramafpu);
            paramImageView.setOnClickListener(null);
          }
        }
      } while (paramafpu.a("fromAIO", true) == null);
      paramImageView.setOnClickListener(new unp(this, paramafpu));
      Object localObject = (View)paramImageView.getParent();
      if ((ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d != null) && (ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.a(0, paramImageView.getTag())))
      {
        paramafpu = afnu.bEr.replace("[epId]", paramafpu.e.epId).replace("[eId]", paramafpu.e.eId);
        ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.k((View)localObject, paramafpu);
        if (localObject == null) {
          break label450;
        }
      }
      label450:
      for (paramafpu = (ImageView)((View)localObject).findViewById(2131378385);; paramafpu = null)
      {
        ChatHistory.this.s(paramafpu);
        break;
        if (localObject != null) {}
        for (localObject = (ImageView)((View)localObject).findViewById(2131378385);; localObject = null)
        {
          ChatHistory.this.t((ImageView)localObject);
          ChatHistory.this.a(paramImageView, paramafpu);
          break;
          label242:
          if (paramInt == 1)
          {
            paramafpu = paramafpu.c();
            if (paramafpu == null) {
              break;
            }
            paramImageView.setImageDrawable(paramafpu);
            break;
          }
          if (paramInt == 3)
          {
            MarketFaceItemBuilder.b localb = new MarketFaceItemBuilder.b();
            paramImageView.setOnClickListener(null);
            localb.image = paramImageView;
            localb.c = paramafpu;
            aixk localaixk = (aixk)ChatHistory.this.app.getManager(83);
            localb.tag = paramafpu.e.getId();
            MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)localb.mMessage;
            String str = "";
            localObject = str;
            if (localMessageForMarketFace != null)
            {
              localObject = str;
              if (localMessageForMarketFace.mMarkFaceMessage != null)
              {
                localObject = str;
                if (localMessageForMarketFace.mMarkFaceMessage.mobileparam != null)
                {
                  localObject = str;
                  if (localMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0) {
                    localObject = new String(localMessageForMarketFace.mMarkFaceMessage.mobileparam);
                  }
                }
              }
            }
            localaixk.a((String)localObject, localb, paramafpu.e.getId(), false, false, null);
            break;
          }
          if (paramInt != 0) {
            break;
          }
          paramImageView.setImageResource(2130838097);
          break;
        }
      }
    }
    
    protected void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord)
    {
      if (paramMarkFaceMessage == null)
      {
        a(paramImageView1, 0, null, paramMessageRecord);
        return;
      }
      ((ajdg)ChatHistory.this.app.getManager(14)).a(paramMarkFaceMessage, new unr(this, paramImageView2, paramMarkFaceMessage, paramImageView1, paramMessageRecord));
    }
    
    public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
    {
      paramMessageForMixedMsg.parse();
      int j = paramMessageForMixedMsg.msgElemList.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
        if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).time == 0L)) {
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
        }
        i += 1;
      }
      paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList, null);
      Object localObject1 = new wly();
      ((wly)localObject1).sessionInfo = ChatHistory.this.c;
      int k = paramMessageForMixedMsg.msgElemList.size();
      i = 0;
      if (i < k)
      {
        Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
        View localView = paramMixedMsgLinearLayout.getChildAt(i);
        Object localObject3;
        if ((localObject2 instanceof MessageForText))
        {
          localObject3 = (AnimationTextView)localView;
          ((AnimationTextView)localObject3).setTextColor(ChatHistory.this.getResources().getColor(2131167366));
          ((AnimationTextView)localObject3).setTextSize(0, wja.dp2px(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
          if (TextUtils.isEmpty(((MessageForText)localObject2).sb2))
          {
            ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
            label226:
            localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.bOa;
            if (i != j - 1) {
              break label412;
            }
          }
        }
        label412:
        for (((LinearLayout.LayoutParams)localObject2).bottomMargin = BaseChatItemLayout.bOa;; ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0)
        {
          localView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
          localView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
          i += 1;
          break;
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb2);
          break label226;
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            localObject3 = (ChatThumbView)localView;
            URLDrawable localURLDrawable = xkl.b(this.mContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
            ((ChatThumbView)localObject3).setTag(2131364517, localObject2);
            ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
            ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
            break label226;
          }
          if (!QLog.isColorLevel()) {
            break label226;
          }
          QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
          break label226;
        }
      }
      paramMixedMsgLinearLayout.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
      paramMixedMsgLinearLayout.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
    }
    
    protected void a(vea paramvea)
    {
      Object localObject = xkl.b(ChatHistory.this, paramvea.b);
      paramvea.I.setImageDrawable((Drawable)localObject);
      paramvea.I.setVisibility(0);
      int i = paramvea.b.msgtype;
      localObject = paramvea.b.action;
      paramvea.I.setOnClickListener(new uns(this, i, paramvea, (String)localObject));
    }
    
    protected String aT(long paramLong)
    {
      Time localTime1 = new Time();
      Time localTime2 = new Time();
      localTime1.set(paramLong);
      localTime2.setToNow();
      if (localTime1.year != localTime2.year) {
        return localTime1.format("%Y-%m-%d %H:%M:%S");
      }
      if (localTime1.yearDay != localTime2.yearDay) {
        return localTime1.format("%m-%d %H:%M:%S");
      }
      return localTime1.format("%H:%M:%S");
    }
    
    public void bindView(View paramView, Context paramContext, Cursor paramCursor)
    {
      ChatHistory.c localc = (ChatHistory.c)paramView.getTag();
      if (localc == null)
      {
        localc = new ChatHistory.c(ChatHistory.this);
        paramView.setTag(localc);
      }
      label99:
      label1512:
      label5994:
      for (;;)
      {
        Object localObject1 = MessageRecord.getTableName(ChatHistory.this.mUin, ChatHistory.this.mType);
        localc.message = ((MessageRecord)ChatHistory.this.b().cursor2Entity(MessageRecord.class, (String)localObject1, paramCursor));
        if (localc.message == null) {
          if (QLog.isColorLevel()) {
            QLog.w("ChatHistory", 2, "bindView message is null !!");
          }
        }
        TextView localTextView1;
        PatchedTextView localPatchedTextView;
        ImageView localImageView1;
        int j;
        label1779:
        do
        {
          do
          {
            return;
            if (!ChatHistory.this.aTP) {
              ChatHistory.this.app.b().d(localc.message.frienduin, localc.message.istroop, localc.message);
            }
            long l3 = paramCursor.getLong(0);
            localc.message.setId(l3);
            LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131370401);
            TextView localTextView3 = (TextView)paramView.findViewById(2131380347);
            localTextView1 = (TextView)paramView.findViewById(2131380520);
            TextView localTextView4 = (TextView)paramView.findViewById(2131380521);
            localPatchedTextView = (PatchedTextView)paramView.findViewById(2131380524);
            localImageView1 = (ImageView)paramView.findViewById(2131377607);
            MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131371865);
            TextView localTextView2 = (TextView)paramView.findViewById(2131380519);
            localLinearLayout.setVisibility(0);
            localPatchedTextView.setVisibility(0);
            localTextView2.setVisibility(8);
            ChatThumbView localChatThumbView = (ChatThumbView)paramView.findViewById(2131368974);
            localChatThumbView.flag = false;
            ImageView localImageView3 = (ImageView)paramView.findViewById(2131368978);
            Button localButton = (Button)paramView.findViewById(2131373735);
            ImageView localImageView2 = (ImageView)paramView.findViewById(2131378385);
            localImageView2.setVisibility(8);
            localTextView3.setVisibility(8);
            localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
            String str1 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
            String str2 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
            i = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
            int k = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
            j = paramCursor.getInt(paramCursor.getColumnIndex("time"));
            int m;
            Object localObject3;
            Object localObject6;
            Object localObject5;
            if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
            {
              localObject1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
              m = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
              localObject1 = ChatHistory.this.a(i, m, (String)localObject1, k).msg;
              localObject3 = apsb.a(localc.message);
              localObject6 = (TroopManager)ChatHistory.this.app.getManager(52);
              localObject5 = ((TroopManager)localObject6).b(ChatHistory.this.mUin);
              if ((localObject5 != null) && (((TroopInfo)localObject5).cGroupRankSysFlag == 1) && (((TroopInfo)localObject5).cGroupRankUserFlag == 1) && (localObject3 == null))
              {
                localObject6 = ((TroopManager)localObject6).b(str1, str2);
                localObject5 = apdg.a().a((TroopMemberInfo)localObject6, (TroopInfo)localObject5);
                if (localObject5 != null)
                {
                  localTextView3.setVisibility(0);
                  localTextView3.setText(((apdg.a)localObject5).title);
                  apdg.i(localTextView3, ((apdg.a)localObject5).bgColor);
                }
              }
              if (localObject3 == null) {
                break label1306;
              }
              localTextView1.setText(((apsb.a)localObject3).nickname);
              localTextView3.setVisibility(0);
              localTextView3.setText(((apsb.a)localObject3).cqY);
              localTextView3.setBackgroundDrawable(apuh.k(ChatHistory.this.getResources(), ((apsb.a)localObject3).dVD));
              if ((localObject3 == null) || (!ThemeUtil.isNowThemeIsDefault(ChatHistory.this.app, false, null))) {
                break label1485;
              }
              localTextView1.setTextColor(((apsb.a)localObject3).dVB);
              localTextView4.setText(aT(j * 1000L));
              j = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
              if (j != 32768) {
                break label1506;
              }
            }
            for (i = 1;; i = 0)
            {
              for (;;)
              {
                if (i != 0) {
                  localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * ChatHistory.this.mDensity));
                }
                localChatThumbView.setVisibility(8);
                localPatchedTextView.setVisibility(8);
                localImageView1.setVisibility(8);
                localImageView3.setVisibility(8);
                localButton.setVisibility(8);
                localMixedMsgLinearLayout.setVisibility(8);
                localPatchedTextView.setOnTouchListener(null);
                localPatchedTextView.setOnLongClickListener(null);
                localPatchedTextView.setOnClickListener(null);
                localButton.setOnClickListener(null);
                m = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
                if (m != -2007) {
                  break label1512;
                }
                localChatThumbView.setVisibility(0);
                localPatchedTextView.setVisibility(8);
                localImageView1.setVisibility(8);
                localImageView3.setVisibility(8);
                localButton.setVisibility(8);
                localChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                localChatThumbView.setTag(str1 + l3);
                localImageView2.setTag(null);
                try
                {
                  a(localChatThumbView, (MarkFaceMessage)aczw.c(paramView), localImageView2, localc.message);
                  return;
                }
                catch (Exception paramView)
                {
                  paramView.printStackTrace();
                  a(localChatThumbView, null, localImageView2, localc.message);
                  return;
                }
                if (((localc.message instanceof MessageForFoldMsg)) || ((localc.message instanceof MessageForUniteGrayTip)))
                {
                  localObject1 = localc.message.msg;
                  break;
                }
                try
                {
                  localObject5 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
                  for (;;)
                  {
                    try
                    {
                      localObject1 = new StringBuilder((String)localObject5);
                      localObject3 = localObject1;
                      if ((localc.message instanceof MessageForText))
                      {
                        localObject3 = localObject1;
                        if (localc.message.istroop == 3000)
                        {
                          localObject6 = localc.message.getExtInfoFromExtStr("disc_at_info_list");
                          bool = TextUtils.isEmpty((CharSequence)localObject6);
                          localObject3 = localObject1;
                          if (bool) {}
                        }
                      }
                      try
                      {
                        localObject3 = BaseApplicationImpl.sApplication.getRuntime();
                        if (!QQAppInterface.class.isInstance(localObject3)) {
                          continue;
                        }
                        localObject3 = appb.a((QQAppInterface)localObject3, (StringBuilder)localObject1, (String)localObject6, str1, localc.message.isSend());
                        localObject1 = localObject3;
                        localObject3 = localObject1;
                      }
                      catch (Exception localException2)
                      {
                        QLog.e("ChatHistory", 1, "replaceAtMsgByMarkName", localException2);
                        localObject4 = localObject1;
                        continue;
                      }
                      localObject1 = ((StringBuilder)localObject3).toString();
                    }
                    catch (Exception localException1)
                    {
                      localObject4 = localObject5;
                      localObject5 = localException1;
                      localObject2 = localObject4;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatHistory", 2, "We get error AppRuntime");
                    }
                  }
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    boolean bool;
                    Object localObject4;
                    long l2;
                    long l1;
                    Object localObject2 = "";
                    continue;
                  }
                }
              }
              QLog.e("ChatHistory", 1, "cursor Error", (Throwable)localObject5);
              break;
              if (jof.a(localc.message))
              {
                localTextView1.setText(ChatHistory.this.getResources().getString(2131699453) + jof.a(localc.message).TG);
                localTextView3.setVisibility(8);
                break label696;
              }
              if (apsa.B(localc.message))
              {
                localTextView1.setText(obt.a(ChatHistory.this.app, BaseApplicationImpl.getContext()));
                break label696;
              }
              if ((!TextUtils.isEmpty(localc.name)) && (!TextUtils.isEmpty(localc.senderUin)) && (localc.senderUin.equals(str2)))
              {
                localTextView1.setText(localc.name);
                break label696;
              }
              localc.senderUin = str2;
              ThreadManager.post(new ChatHistory.ChatHistoryAdapter.1(this, k, str2, localc, localTextView1), 8, null, true);
              break label696;
              localTextView1.setTextColor(ChatHistory.this.getResources().getColor(2131167312));
              break label726;
            }
            if (m == -2058) {
              try
              {
                a(paramCursor, localPatchedTextView, m, str1, (String)localObject2, str2, j, localTextView1, localc, localImageView1, (CharSequence)localObject2, localChatThumbView, localImageView3, localButton, localImageView2, l3);
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                a(localChatThumbView, null, localImageView2, localc.message);
                return;
              }
            }
            if (m == -2039)
            {
              paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramContext = new MessageForApollo();
              paramContext.msgData = paramView;
              paramContext.parse();
              localPatchedTextView.setVisibility(0);
              if (!TextUtils.isEmpty(paramContext.msg))
              {
                localPatchedTextView.setText(paramContext.msg);
                return;
              }
              localPatchedTextView.setText(acfp.m(2131703650));
              return;
            }
            if (m == -2010)
            {
              localChatThumbView.setVisibility(8);
              localPatchedTextView.setVisibility(0);
              localImageView1.setVisibility(8);
              localImageView3.setVisibility(8);
              localButton.setVisibility(8);
              localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              if ((localObject2 == null) || (((String)localObject2).length() <= 0) || (!ChatHistory.this.gK(((String)localObject2).toString()))) {
                break label5761;
              }
              paramContext = localObject2.split("\026")[1].split("\\|");
              paramCursor = paramContext[0];
              if (paramContext.length >= 2) {
                break label5235;
              }
              i = 1;
              if (paramContext.length >= 5) {
                localObject4 = paramContext[4];
              }
              if (paramContext.length >= 6) {
                aoon.oy(((String)localObject2).toString());
              }
              l2 = 0L;
              l1 = l2;
              if (paramContext != null)
              {
                l1 = l2;
                if (paramContext.length > 1) {
                  if (paramContext[1] != null) {
                    break label5249;
                  }
                }
              }
            }
            for (paramContext = "0";; paramContext = paramContext[1])
            {
              for (;;)
              {
                l1 = Long.parseLong(paramContext);
                Uri.parse(paramCursor);
                switch (i)
                {
                default: 
                  return;
                case 0: 
                  localPatchedTextView.setText(ChatHistory.this.getString(2131721065));
                  localPatchedTextView.setVisibility(0);
                  localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  return;
                  if ((m == -2011) || (m == -2051) || (m == -7002) || (m == -2054))
                  {
                    paramCursor = anre.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                    paramView = ChatHistory.this.b(paramCursor);
                    if ((localc.message instanceof MessageForStructing))
                    {
                      paramContext = (MessageForStructing)localc.message;
                      if (((paramContext.istroop == 1024) && (!asgx.ag(ChatHistory.this.app, paramContext.frienduin))) || (jqs.d(ChatHistory.this.app, paramContext.frienduin, paramContext.istroop)))
                      {
                        paramContext = paramView;
                        if (TextUtils.isEmpty(paramView))
                        {
                          paramContext = paramView;
                          if (paramCursor != null)
                          {
                            paramContext = paramView;
                            if ((paramCursor instanceof AbsShareMsg))
                            {
                              paramContext = ((AbsShareMsg)paramCursor).getStructMsgItemLists().iterator();
                              while (paramContext.hasNext())
                              {
                                paramCursor = (anqu)paramContext.next();
                                if (!(paramCursor instanceof anqv)) {
                                  break label5994;
                                }
                                paramCursor = ((anqv)paramCursor).rz.iterator();
                                do
                                {
                                  if (!paramCursor.hasNext()) {
                                    break;
                                  }
                                  localObject2 = (anqu)paramCursor.next();
                                } while (!(localObject2 instanceof StructMsgItemTitle));
                                paramView = ((StructMsgItemTitle)localObject2).getText();
                              }
                              paramContext = paramView;
                            }
                          }
                        }
                        if (TextUtils.isEmpty(paramContext)) {
                          break label99;
                        }
                        paramView = String.format(ChatHistory.this.app.getApp().getString(2131699895), new Object[] { acfp.m(2131703604) });
                        localPatchedTextView.setText(paramView + paramContext);
                        localPatchedTextView.setVisibility(0);
                        localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                        localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                        return;
                      }
                    }
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    paramContext = paramView;
                    if (apsa.B(localc.message))
                    {
                      paramContext = String.format(ChatHistory.this.app.getApp().getString(2131699895), new Object[] { obt.a(ChatHistory.this.app, BaseApplicationImpl.getContext()) });
                      paramContext = paramContext + paramView;
                    }
                    localPatchedTextView.setText(paramContext);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m == -3006)
                  {
                    paramView = MessageForPubAccount.getMsgSummary(ChatHistory.this.app, localc.message, true);
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramView);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m == -5008)
                  {
                    paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                    paramContext = new ArkAppMessage();
                    paramContext.fromBytes(paramView);
                    paramView = paramContext.promptText;
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramView);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m == -5017)
                  {
                    paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                    paramContext = new ArkAppMessage();
                    paramContext.fromBytes(paramView);
                    paramView = paramContext.promptText;
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramView);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m == -5016)
                  {
                    paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                    paramContext = new MessageForArkBabyqReply();
                    paramContext.fromBytes(paramView);
                    paramView = paramContext.babyqReplyText;
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramView);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m == -5013)
                  {
                    paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                    paramContext = new ArkFlashChatMessage();
                    paramContext.fromBytes(paramView);
                    paramView = paramContext.promptText;
                    if (TextUtils.isEmpty(paramView)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramView);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  if (m != -5014) {
                    break label2897;
                  }
                  paramContext = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                  try
                  {
                    paramContext = ((HiBoomMessage)aczw.c(paramContext)).text;
                    if (TextUtils.isEmpty(paramContext)) {
                      break label99;
                    }
                    localPatchedTextView.setText(paramContext);
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  catch (Exception paramContext)
                  {
                    paramContext.printStackTrace();
                  }
                }
              }
              break label1721;
              if ((m == -2000) || (m == -20000) || (m == -3004) || (m == -3005) || (m == -3000) || (m == -3001) || (m == -5015))
              {
                if ((localc.message != null) && ((localc.message instanceof MessageForPic)))
                {
                  if (acei.W(localc.message))
                  {
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setText(ChatHistory.this.getString(2131692311));
                    localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                    return;
                  }
                  paramView = (MessageForPic)localc.message;
                  paramView.parse();
                  paramContext = new vea();
                  localChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  localChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  paramContext.b = paramView;
                  paramContext.I = localChatThumbView;
                  if (QLog.isColorLevel()) {
                    QLog.d("history", 2, "bindView pic.path:" + paramView.path + ",pic.uuid:" + paramView.uuid);
                  }
                  if ((paramContext.b == null) || (paramContext.b.path == null)) {
                    break;
                  }
                  a(paramContext);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("history", 2, "not messageforpicuniseq:" + localc.message.uniseq + ",dbid:" + localc.message.getId() + "istroop:" + localc.message.istroop + ",msgtype:" + localc.message.msgtype);
                return;
              }
              if (m == -2002)
              {
                localObject4 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new RichMsg.PttRec();
                try
                {
                  paramContext.mergeFrom((byte[])localObject4);
                  i = 1;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    i = 0;
                    localException3.printStackTrace();
                    continue;
                    bool = false;
                    continue;
                    j = 0;
                  }
                  localButton.setText(String.valueOf(j) + "\"");
                  localButton.setPadding(k, 0, eL(j), 0);
                  if (ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d == null) {
                    break label3741;
                  }
                }
                if (i == 0) {
                  break label1721;
                }
                i = paramContext.voiceLength.get();
                if ((localc == null) || (localc.message == null) || (!(localc.message instanceof MessageForPtt))) {
                  break label5991;
                }
                if (((MessageForPtt)localc.message).voiceChangeFlag == 1)
                {
                  bool = true;
                  localc.aTS = bool;
                  if (i > 0) {
                    break label5991;
                  }
                  i = QQRecorder.n(localc.message);
                  bool = localc.aTS;
                  if (!paramContext.voiceType.has()) {
                    break label3633;
                  }
                  j = paramContext.voiceType.get();
                  paramCursor = MessageForPtt.getLocalFilePath(j, paramContext.localPath.get());
                  l1 = paramContext.size.get();
                  k = ChatHistory.this.bFh;
                  j = ChatHistory.this.bFi;
                  localButton.setTag(paramCursor + str1 + l3);
                  localButton.setVisibility(0);
                  localButton.setText("");
                  localButton.setText(null);
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setPadding(k, 0, j, 0);
                  localButton.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  localButton.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  j = i;
                  if (i <= 0) {
                    j = QQRecorder.fi(paramCursor);
                  }
                  if ((paramCursor.startsWith(acbn.SDCARD_ROOT)) && (j > 0)) {
                    break label3639;
                  }
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setText("[" + ChatHistory.this.getString(2131697382) + "]");
                  localButton.setOnClickListener(null);
                }
                if (ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.a(0, localButton.getTag()))
                {
                  ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.k(paramView, paramCursor);
                  localButton.setOnClickListener(new unl(this, j, paramCursor));
                  return;
                }
                if (bool) {}
                for (paramView = this.mContext.getResources().getDrawable(2130850975);; paramView = this.mContext.getResources().getDrawable(2130850974))
                {
                  paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                  localButton.setCompoundDrawables(paramView, null, null, null);
                  if (l1 > 0L) {
                    break;
                  }
                  localButton.setText("[" + ChatHistory.this.getString(2131697386) + "]");
                  break;
                }
              }
              if (m == -1035)
              {
                localMixedMsgLinearLayout.setVisibility(0);
                a(localMixedMsgLinearLayout, (MessageForMixedMsg)localc.message);
                return;
              }
              if (m == -7001)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(ChatHistory.this.getString(2131696093));
                return;
              }
              if (m == -2017)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(aqiu.pC(null));
                return;
              }
              if (m == -2020)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnClickListener(new unm(this, str1));
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                if (aqiu.ms(k))
                {
                  localPatchedTextView.setText(ChatHistory.this.app.getApp().getString(2131720018, new Object[] { ChatHistory.this.c.aTn }));
                  return;
                }
                localPatchedTextView.setText(ChatHistory.this.app.getApp().getString(2131720017));
                return;
              }
              if (m == -3008)
              {
                localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131693546) + "\"" + (String)localObject2 + "\"");
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -2022)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(ChatHistory.this.getString(2131720252));
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -5002)
              {
                if ((localc.message != null) && ((localc.message instanceof MessageForIncompatibleGrayTips)))
                {
                  paramView = (MessageForIncompatibleGrayTips)localc.message;
                  paramView.parse();
                  localPatchedTextView.setText(paramView.msg);
                  localPatchedTextView.setVisibility(0);
                  paramCursor = paramView.url;
                  paramContext = new SpannableString(paramView.msg);
                  paramCursor = new unn(this, paramCursor, str1);
                  paramContext.setSpan(new ForegroundColorSpan(2131167522), paramView.linkStart, paramView.linkEnd, 33);
                  paramContext.setSpan(paramCursor, paramView.linkStart, paramView.linkEnd, 33);
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                  localPatchedTextView.setHighlightColor(17170445);
                  localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("history", 2, "not MessageForIncompatibleGrayTipsuniseq:" + localc.message.uniseq + ",dbid:" + localc.message.getId() + "istroop:" + localc.message.istroop + ",msgtype:" + localc.message.msgtype);
                return;
              }
              if (m == -2025)
              {
                paramView = new MessageForQQWalletMsg();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getMsgSummary());
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -2036)
              {
                paramView = new MessageForTroopFee();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -2035)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(".troop.send_gift", 2, "ChatHistory decode MessageForDeliverGiftTips. seq:" + localc.message.shmsgseq + "msgtype:" + localc.message.msgtype + "msg:" + localc.message.msg);
                }
                paramView = (MessageForDeliverGiftTips)localc.message;
                localLinearLayout.setVisibility(8);
                localPatchedTextView.setVisibility(8);
                localTextView2.setVisibility(0);
                localTextView2.setClickable(true);
                localTextView2.setFocusable(true);
                localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
                localTextView2.setVisibility(0);
                localTextView2.setText(paramView.getHightlightMsgText(ChatHistory.this.app, this.mContext, false, localTextView2));
                return;
              }
              if (m == -2038)
              {
                paramView = new MessageForTroopGift();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.summary);
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -2048)
              {
                paramView = new MessageForTroopReward();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if ((m == -2052) || (m == -2057) || (m == -2059))
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(((ChatMessage)localc.message).getSummaryMsg());
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -2071)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(ChatHistory.this.getString(2131692312));
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m == -5010)
              {
                paramView = (MessageForDingdongSchedule)localc.message;
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.msg);
                localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
                return;
              }
              if (m != -8002) {
                break label1721;
              }
              paramView = (MessageForToDo)localc.message;
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText("[待办]" + paramView.msg);
              localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              return;
              i = Integer.valueOf(paramContext[2]).intValue();
              break label1779;
            }
            localChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            localChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            return;
            k = ChatHistory.this.bFh;
            i = ChatHistory.this.bFi;
            localButton.setTag(paramCursor + str1 + l3);
            localButton.setVisibility(0);
            localButton.setText("");
            localButton.setText(null);
            localButton.setCompoundDrawables(null, null, null, null);
            localButton.setPadding(k, 0, i, 0);
            localButton.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            localButton.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            j = 0;
            i = j;
            if (localc != null)
            {
              i = j;
              if (localc.message != null)
              {
                i = j;
                if ((localc.message instanceof MessageForPtt)) {
                  i = QQRecorder.n(localc.message);
                }
              }
            }
            j = i;
            if (i <= 0) {
              j = QQRecorder.fi(paramCursor);
            }
            if ((!paramCursor.startsWith(acbn.SDCARD_PATH)) || (j <= 0))
            {
              localButton.setCompoundDrawables(null, null, null, null);
              localButton.setText("[" + ChatHistory.this.getString(2131697382) + "]");
              localButton.setOnClickListener(null);
              return;
            }
            localButton.setText(String.valueOf(j) + "\"");
            localButton.setPadding(k, 0, eL(j), 0);
            if ((ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d != null) && (ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.a(0, localButton.getTag()))) {
              ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$d.k(paramView, paramCursor);
            }
            for (;;)
            {
              localButton.setOnClickListener(new uno(this, j, paramCursor));
              return;
              paramView = this.mContext.getResources().getDrawable(2130850974);
              paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
              localButton.setCompoundDrawables(paramView, null, null, null);
              if (l1 <= 0L) {
                localButton.setText("[" + ChatHistory.this.getString(2131697386) + "]");
              }
            }
            localChatThumbView.setVisibility(0);
            localChatThumbView.setOnClickListener(null);
            localChatThumbView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            localChatThumbView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            localChatThumbView.setImageResource(2130839259);
            return;
            i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            localPatchedTextView.setVisibility(0);
            if (!anbk.ls(m))
            {
              localPatchedTextView.setOnTouchListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
              localPatchedTextView.setOnLongClickListener(ChatHistory.this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$b);
            }
            if (!String.valueOf(acbn.bkD).equals(str1)) {
              break;
            }
            paramView = SystemMsg.decode(ChatHistory.this.app, (String)localObject2, str2, i);
          } while (paramView == null);
          localPatchedTextView.setText(paramView.message);
        } while (j != 32769);
        label5235:
        localTextView1.setText(paramView.troopCode);
        return;
        if (-2008 == i)
        {
          localPatchedTextView.setText(ChatHistory.this.getString(2131719353));
          return;
        }
        if (-1002 == i)
        {
          localPatchedTextView.setText(localc.message.getExtInfoFromExtStr("sens_msg_original_text"));
          return;
        }
        int i = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
        if ((localImageView1 != null) && (i == 32768)) {
          localImageView1.setVisibility(0);
        }
        localPatchedTextView.setText(new aofk((CharSequence)localObject2, 13, 32, localc.message));
        return;
      }
    }
    
    public void changeCursor(Cursor paramCursor)
    {
      if (paramCursor != null)
      {
        if (getCursor() != null) {
          getCursor().deactivate();
        }
        super.changeCursor(paramCursor);
        notifyDataSetChanged();
      }
    }
    
    public void closeCursor()
    {
      super.changeCursor(null);
    }
    
    protected int eL(int paramInt)
    {
      int j = ChatHistory.this.bFf;
      int i;
      if (paramInt >= 60) {
        i = ChatHistory.this.bFg;
      }
      do
      {
        do
        {
          return i;
          if ((paramInt > 45) && (paramInt < 60)) {
            return ChatHistory.this.bFg * 15 / 16 + (paramInt - 45) * ChatHistory.this.bFg / 15 / 16 + ChatHistory.this.bFf;
          }
          if ((paramInt > 30) && (paramInt <= 45)) {
            return ChatHistory.this.bFg * 13 / 16 + (paramInt - 30) * ChatHistory.this.bFg * 2 / 15 / 16 + ChatHistory.this.bFf;
          }
          if ((paramInt > 15) && (paramInt <= 30)) {
            return ChatHistory.this.bFg * 9 / 16 + (paramInt - 15) * ChatHistory.this.bFg * 4 / 15 / 16 + ChatHistory.this.bFf;
          }
          i = j;
        } while (paramInt <= 0);
        i = j;
      } while (paramInt > 15);
      return ChatHistory.this.bFg * paramInt * 9 / 16 / 15 + ChatHistory.this.bFf;
    }
    
    public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
    {
      return this.mInflater.inflate(2131558952, paramViewGroup, false);
    }
  }
  
  public class b
    implements View.OnClickListener, BubblePopupWindow.b, wlz
  {
    BubblePopupWindow a;
    protected PointF downPoint = new PointF();
    MessageRecord i;
    
    protected b() {}
    
    void ez(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    
    public void onClick(View paramView)
    {
      if (paramView.getId() == 2131365686) {
        ChatHistory.this.F(this.i);
      }
      this.i = null;
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void onDismiss()
    {
      this.a = null;
    }
    
    public boolean onLongClick(View paramView)
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        ez(paramView);
        return false;
      }
      aqoa localaqoa = new aqoa();
      localaqoa.Z(2131365686, ChatHistory.this.getString(2131691404), 2130839081);
      if (localaqoa.size() > 0)
      {
        this.i = ((ChatHistory.c)ChatHistory.a(paramView)).message;
        int j = (int)this.downPoint.y;
        int k = wja.dp2px(10.0F, paramView.getResources());
        this.a = aqgq.a(paramView, (int)this.downPoint.x, j - k, localaqoa, this);
        this.a.a(this);
        ez(paramView);
        return true;
      }
      ez(paramView);
      return false;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downPoint.x = paramMotionEvent.getRawX();
        this.downPoint.y = paramMotionEvent.getRawY();
      }
      return false;
    }
  }
  
  public class c
  {
    boolean aTS;
    MessageRecord message;
    String name;
    String senderUin;
    
    protected c() {}
  }
  
  public class d
  {
    public Object bK;
    public boolean isFinish;
    public int nType;
    public String path;
    public View rR;
    
    public d()
    {
      reset();
    }
    
    public void a(int paramInt, View paramView, Object paramObject, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "playPtt() type = " + paramInt + ", isFinish = " + this.isFinish);
      }
      if ((!this.isFinish) && (aqft.equalsWithNullCheck(paramObject, this.bK)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatHistory", 2, "playPtt() 点击正在播放，即要停止啦！");
        }
        bJV();
        return;
      }
      if (!this.isFinish) {
        bJV();
      }
      if (!ChatHistory.this.he(paramString))
      {
        bJV();
        return;
      }
      this.isFinish = false;
      this.nType = paramInt;
      this.rR = paramView;
      this.bK = paramObject;
      this.path = paramString;
      bJT();
    }
    
    public boolean a(int paramInt, Object paramObject)
    {
      return (!this.isFinish) && (paramInt == this.nType) && (aqft.equalsWithNullCheck(this.bK, paramObject));
    }
    
    protected void bJT()
    {
      Object localObject1 = null;
      if (this.nType == 0) {
        if (this.rR == null) {
          break label307;
        }
      }
      label300:
      label302:
      label307:
      for (localObject1 = (Button)this.rR.findViewById(2131373735);; localObject1 = null)
      {
        if (localObject1 != null) {
          if ((this.rR.getTag() == null) || (!(this.rR.getTag() instanceof ChatHistory.c))) {
            break label302;
          }
        }
        for (boolean bool = ((ChatHistory.c)this.rR.getTag()).aTS;; bool = false)
        {
          if (bool)
          {
            ChatHistory.this.o.setBounds(0, 0, ChatHistory.this.o.getMinimumWidth(), ChatHistory.this.o.getMinimumHeight());
            ((Button)localObject1).setCompoundDrawables(ChatHistory.this.o, null, null, null);
            ChatHistory.this.o.stop();
            ChatHistory.this.o.start();
          }
          for (;;)
          {
            return;
            ChatHistory.this.n.setBounds(0, 0, ChatHistory.this.n.getMinimumWidth(), ChatHistory.this.n.getMinimumHeight());
            ((Button)localObject1).setCompoundDrawables(ChatHistory.this.n, null, null, null);
            ChatHistory.this.n.stop();
            ChatHistory.this.n.start();
            return;
            if (this.nType == 1)
            {
              ImageView localImageView;
              if (this.rR != null)
              {
                localImageView = (ImageView)this.rR.findViewById(2131378385);
                localObject1 = (ImageView)this.rR.findViewById(2131368974);
              }
              for (;;)
              {
                if ((localImageView == null) || (localObject1 == null)) {
                  break label300;
                }
                Object localObject2 = localImageView.getTag();
                if (!(localObject2 instanceof afpu)) {
                  break;
                }
                localObject2 = (afpu)localObject2;
                ChatHistory.this.s(localImageView);
                ChatHistory.this.b((ImageView)localObject1, (afpu)localObject2);
                return;
                localImageView = null;
              }
            }
          }
        }
      }
    }
    
    protected void bJU()
    {
      Object localObject1 = null;
      if (this.nType == 0) {
        if (this.rR == null) {
          break label282;
        }
      }
      label275:
      label277:
      label282:
      for (localObject1 = (Button)this.rR.findViewById(2131373735);; localObject1 = null)
      {
        if ((localObject1 != null) && (((Button)localObject1).getTag().equals(this.bK))) {
          if ((this.rR.getTag() == null) || (!(this.rR.getTag() instanceof ChatHistory.c))) {
            break label277;
          }
        }
        for (boolean bool = ((ChatHistory.c)this.rR.getTag()).aTS;; bool = false)
        {
          Object localObject2;
          if (bool)
          {
            ChatHistory.this.o.stop();
            localObject2 = ChatHistory.this.getResources().getDrawable(2130850975);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
            ((Button)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
          for (;;)
          {
            return;
            ChatHistory.this.n.stop();
            localObject2 = ChatHistory.this.getResources().getDrawable(2130850974);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
            break;
            if (this.nType == 1)
            {
              if (this.rR != null)
              {
                localObject2 = (ImageView)this.rR.findViewById(2131378385);
                localObject1 = (ImageView)this.rR.findViewById(2131368974);
              }
              for (;;)
              {
                if ((localObject2 == null) || (localObject1 == null)) {
                  break label275;
                }
                Object localObject3 = ((ImageView)localObject2).getTag();
                if (!(localObject3 instanceof afpu)) {
                  break;
                }
                localObject3 = (afpu)localObject3;
                ((afpu)localObject3).a("fromAIO", true);
                ChatHistory.this.t((ImageView)localObject2);
                ChatHistory.this.a((ImageView)localObject1, (afpu)localObject3);
                return;
                localObject2 = null;
              }
            }
          }
        }
      }
    }
    
    public void bJV()
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "stopPlayPtt()");
      }
      ChatHistory.this.bJN();
      this.isFinish = true;
      bJU();
      reset();
    }
    
    public void k(View paramView, String paramString)
    {
      this.rR = paramView;
      this.path = paramString;
      if (this.nType != 1) {
        bJT();
      }
    }
    
    public void reset()
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "reset()");
      }
      this.nType = -1;
      this.rR = null;
      this.bK = null;
      this.isFinish = true;
      this.path = null;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[type = ").append(this.nType).append(", curTag = ").append(this.bK).append(", isFinish = ").append(this.isFinish).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */