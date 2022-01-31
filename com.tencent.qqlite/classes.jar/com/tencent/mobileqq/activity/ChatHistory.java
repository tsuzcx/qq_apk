package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import acq;
import acs;
import act;
import acu;
import acv;
import acw;
import acx;
import acy;
import acz;
import ada;
import adc;
import add;
import ade;
import adf;
import adg;
import adh;
import adi;
import adk;
import adl;
import adm;
import ado;
import adp;
import adq;
import adr;
import ads;
import adt;
import adu;
import aee;
import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
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
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.MobileQQ;

public class ChatHistory
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  private static Toast jdField_a_of_type_AndroidWidgetToast;
  static final int jdField_d_of_type_Int = 8;
  static final String e = "http://m.qzone.com";
  static final String jdField_f_of_type_JavaLangString = "http://mobile.qzone.qq.com";
  private static final String jdField_g_of_type_JavaLangString = "http://kiss.3g.qq.com/activeQQ/mqq/groupMsg_wap20.jsp?bid=591&sid=%s&groupName=%s&groupCode=%s";
  static final int k = 0;
  static final int l = 1;
  static final int m = 2;
  static final int n = 3;
  static final int o = 4;
  static final int p = 5;
  public static final int q = 6;
  static final int r = 7;
  static final int s = 8;
  public static final int t = 200;
  static final int u = 1;
  private static final int w = 604800;
  float jdField_a_of_type_Float;
  public int a;
  public long a;
  aee jdField_a_of_type_Aee = new aee(this, null);
  public Dialog a;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new acq(this);
  public Handler a;
  public View a;
  AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new adl(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageView a;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChatHistory.ChatHistoryAdapter a;
  public ChatHistory.PlayingPttHistoryInfo a;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new adk(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public MessageSearchDialog a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new adh(this);
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new adi(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  public QQProgressDialog a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  final String jdField_a_of_type_JavaLangString = "ChatHistory";
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  public int b;
  public long b;
  public Dialog b;
  private AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_b_of_type_AndroidOsHandler = new add(this);
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  public TextView b;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public Dialog c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public String d;
  public int e = 0;
  int jdField_f_of_type_Int;
  int jdField_g_of_type_Int;
  int h;
  int i;
  final int j = 60;
  public int v;
  private int x;
  
  public ChatHistory()
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (ActionMsgUtil.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return ActionMsgUtil.a(paramString);
    }
    MsgBody localMsgBody = new MsgBody();
    localMsgBody.msg = paramString;
    localMsgBody.action = null;
    return localMsgBody;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.a().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + getString(2131364120) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  private void a(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a(true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        PicEmoticonInfo.b((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296799));
    m();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter = new ChatHistory.ChatHistoryAdapter(this, this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverscrollFooter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(paramString, paramInt, this.e);
  }
  
  public static boolean a(String paramString)
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
  
  private void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130838989));
    }
  }
  
  private void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.b();
      if ((paramPicEmoticonInfo instanceof URLDrawable)) {
        PicEmoticonInfo.a((URLDrawable)paramPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    Object localObject3 = "";
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    Cursor localCursor;
    label151:
    int i2;
    label227:
    int i1;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.b());
      if (localObject1 == null) {
        break label1139;
      }
      localCursor = this.app.b().a(((StringBuilder)localObject1).toString(), null);
      if (paramInt == 1)
      {
        paramString = ContactUtils.a(this.app, paramString, 1);
        localStringBuffer.append(getString(2131363401) + ":");
        localStringBuffer.append(paramString);
        localStringBuffer.append("\r\n===========================================\r\n");
      }
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        paramString = (String)localObject3;
        i2 = localCursor.getInt(localCursor.getColumnIndex("time"));
        localObject1 = localCursor.getString(localCursor.getColumnIndex("senderuin"));
        if (1 != paramInt) {
          break label588;
        }
        localObject1 = String.format("%s(%s)", new Object[] { ContactUtils.e(this.app, this.jdField_b_of_type_JavaLangString, (String)localObject1), localObject1 });
        i1 = localCursor.getInt(localCursor.getColumnIndex("issend"));
        if (!MsgUtils.a(i1)) {
          break label637;
        }
        localObject3 = d();
        label258:
        if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0)) {
          break label644;
        }
        paramString = localCursor.getString(localCursor.getColumnIndex("msg"));
      }
    }
    label309:
    Object localObject4;
    label384:
    label405:
    label588:
    label637:
    int i3;
    for (;;)
    {
      localObject4 = new QQText(paramString, 3).a();
      localObject1 = localObject4;
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        if (((String)localObject4).length() > 0)
        {
          localObject1 = localObject4;
          if (b((String)localObject4))
          {
            localObject1 = localObject4.split("\026")[1].split("\\|");
            if (localObject1.length >= 2) {
              break label1076;
            }
            i1 = 1;
            if ((i1 != 1) && (i1 != 65538)) {
              break label1090;
            }
            localObject1 = getString(2131363278);
          }
        }
      }
      localObject1 = a(i2 * 1000L) + "  " + (String)localObject3 + "\r\n" + (String)localObject1;
      localStringBuffer.append((String)localObject1 + "\r\n\r\n");
      label644:
      do
      {
        if (localCursor.moveToNext()) {
          break label1136;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        runOnUiThread(new adg(this, FileUtils.a(AppConstants.as, this.jdField_a_of_type_JavaLangStringBuffer, localStringBuffer.toString())));
        return;
        localObject1 = "( isValid=1 and msgtype " + MsgProxyUtils.b() + " ) ORDER BY time asc , longMsgIndex asc";
        localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.app.b(), (String)localObject1, null);
        break;
        if (3000 == paramInt)
        {
          localObject1 = String.format("%s(%s)", new Object[] { ContactUtils.a(this.app, (String)localObject1, 0), localObject1 });
          break label227;
        }
        localObject1 = this.jdField_c_of_type_JavaLangString;
        break label227;
        localObject3 = localObject1;
        break label258;
        i3 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (i3 == -2007)
        {
          paramString = getString(2131364093);
          break label309;
        }
        if (i3 == -2011)
        {
          paramString = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label309;
        }
        if (i3 == -2020)
        {
          if (MsgUtils.a(i1))
          {
            paramString = this.app.a().getString(2131362961, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
            break label309;
          }
          paramString = this.app.a().getString(2131362960);
          break label309;
        }
      } while (i3 == -2006);
      if (i3 == -2000)
      {
        paramString = "[图片]";
      }
      else if (i3 == -2002)
      {
        paramString = "[语音]";
      }
      else
      {
        if (i3 != -2022) {
          break label837;
        }
        paramString = "[视频]";
      }
    }
    label837:
    if (i3 == -1035) {
      paramString = new StringBuilder();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            localObject4 = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
            localObject1 = new MixedMsg.Msg();
            try
            {
              ((MixedMsg.Msg)localObject1).mergeFrom((byte[])localObject4);
              if (((MixedMsg.Msg)localObject1).elems.get().size() <= 0) {
                break;
              }
              i3 = ((MixedMsg.Msg)localObject1).elems.get().size();
              i1 = 0;
              if (i1 < i3)
              {
                localObject4 = (MixedMsg.Elem)((MixedMsg.Msg)localObject1).elems.get().get(i1);
                if (!((MixedMsg.Elem)localObject4).textMsg.has()) {
                  break label1009;
                }
                paramString.append(((MixedMsg.Elem)localObject4).textMsg.get());
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
            }
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatHistory", 2, "Parse mix message error");
          }
          paramString = paramString.toString();
        }
        label1009:
        if (!localInvalidProtocolBufferMicroException.picMsg.has()) {
          break label1145;
        }
        paramString.append("[图片]");
        break label1145;
        try
        {
          String str = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
          paramString = str;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      break label309;
      label1076:
      i1 = Integer.valueOf(localException2[2]).intValue();
      break label384;
      label1090:
      Object localObject2 = localInvalidProtocolBufferMicroException;
      if (i1 != 2) {
        break label405;
      }
      localObject2 = "[" + getString(2131363164) + "]";
      break label405;
      label1136:
      break label151;
      label1139:
      localCursor = null;
      break;
      label1145:
      i1 += 1;
    }
  }
  
  private String c()
  {
    return this.app.a();
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private boolean c(String paramString)
  {
    s();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
    return bool;
  }
  
  private String d()
  {
    String str = ContactUtils.g(this.app, this.app.a());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.app.a();
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidViewView = View.inflate(getActivity(), 2130903083, null);
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new adq(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131296689));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131296688);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296804));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296808));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364364));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364365));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new adu(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new acs(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839092);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838090);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296807));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296805));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new act(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131296809));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new acu(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131296810));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new acv(this));
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024)) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new acw(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
        if ((localFriendManager == null) || (!localFriendManager.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localFriendManager);
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
    }
  }
  
  private void o()
  {
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.e = ((this.jdField_c_of_type_Int - 1) * 8);
  }
  
  private void p()
  {
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131363398, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131363399));
    this.app.a().c(this.jdField_b_of_type_JavaLangString);
  }
  
  private void q()
  {
    String str = getResources().getString(2131363081);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.Y)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131363526);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.Y))) {
          break label298;
        }
        str = getResources().getString(2131363526);
      }
    }
    label298:
    for (;;)
    {
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      setTitle(str);
      this.d = d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_c_of_type_JavaLangString;
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_c_of_type_JavaLangString = ((FriendManager)this.app.getManager(8)).e(this.jdField_b_of_type_JavaLangString);
      } else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_c_of_type_JavaLangString = ((FriendManager)this.app.getManager(8)).a(this.jdField_b_of_type_JavaLangString);
      } else if (this.jdField_a_of_type_Int == 3000) {
        this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.app, this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void r()
  {
    if (jdField_a_of_type_AndroidWidgetToast != null)
    {
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_b_of_type_Float <= 10.0F) {
        break label66;
      }
    }
    label66:
    for (float f1 = 10.0F;; f1 = this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      return;
    }
  }
  
  private void u()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      str = "999";
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "AIO_chatlog arg:" + str);
      }
      ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", 0, 0, str, "", "", "");
      return;
      str = "0";
      continue;
      str = "3";
      continue;
      str = "2";
    }
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.app == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.a(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (this.jdField_a_of_type_Int != 3000) {
        break label243;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label243:
      if (this.jdField_a_of_type_Int == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (this.jdField_a_of_type_Int == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  public Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.b();
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
      paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase);
    } while (paramString2 == null);
    paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      paramString2.append(" where ");
      paramString2.append(paramString3);
    }
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
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
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
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
            paramString2 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
        }
      }
      else
      {
        if (paramString1.indexOf("mr_discusssion_") != -1)
        {
          paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase);
          if (paramString2 == null) {
            break;
          }
          paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          if ((paramString3 != null) && (paramString3.length() > 0))
          {
            paramString2.append(" where ");
            paramString2.append(paramString3);
          }
          try
          {
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        try
        {
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
        }
      }
    }
  }
  
  protected View a()
  {
    super.a();
    Object localObject;
    ImageView localImageView1;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int))
    {
      localObject = this.p;
      this.p.setImageResource(2130838043);
      this.p.setContentDescription("搜索");
      this.p.setOnClickListener(new ado(this));
      localImageView1 = (ImageView)findViewById(2131296909);
    }
    for (;;)
    {
      ((View)localObject).setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView = localImageView1;
      return localObject;
      localObject = findViewById(2131296907);
      ImageView localImageView2 = (ImageView)findViewById(2131296908);
      localImageView2.setImageResource(2130838043);
      localImageView2.setOnClickListener(new adp(this));
      localImageView1 = (ImageView)findViewById(2131296909);
      localImageView1.setImageResource(2130838042);
      localImageView2.setContentDescription("搜索");
      localImageView1.setContentDescription("漫游");
    }
  }
  
  public void a()
  {
    View localView1 = findViewById(2131296798);
    View localView2 = findViewById(2131296564);
    int i1 = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new adr(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new ads(this, localView2, i1));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new adt(this, localView2, i1, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131492887));
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Message paramMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 0L);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label113;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      localActionSheet.a(getResources().getString(2131362491));
      localActionSheet.a(2131363250, 3);
      localActionSheet.d(2131362794);
      localActionSheet.a(new adm(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label113:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903171, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131296760)).setText(2131363116);
      localView.findViewById(2131296998).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131363095)).setPositiveButton(getString(2131363250), new acz(this, paramString)).setNegativeButton(getString(2131363114), new acy(this)).addView(localView);
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131296760)).setText(2131363117);
        localView.findViewById(2131296998).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131296998).setVisibility(8);
      }
    }
  }
  
  protected boolean a()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    setResult(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a(false);
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if (this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int) > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296998)).isChecked()))
    {
      p();
      this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    new acx(this).run();
  }
  
  public void b(String paramString)
  {
    if (jdField_a_of_type_AndroidWidgetToast == null) {
      jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetToast.show();
      return;
      jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  boolean b(String paramString)
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
  
  public void c()
  {
    j();
    o();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e);
  }
  
  public void d()
  {
    j();
    if (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.e = ((this.jdField_c_of_type_Int - 1) * 8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().requery();
      return;
    } while (-1 != paramInt2);
    a(paramIntent.getExtras());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968647));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968634));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2130903108);
    b(getIntent());
    j();
    o();
    q();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    n();
    t();
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (this.app.a() != null) {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    u();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistory", 2, "ChatHistory : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    }
    r();
    l();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.b();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.app.a(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.app.a() != null) {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a().a();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.b();
    }
    super.doOnPause();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, getResources().getString(2131363170)).sendToTarget();
    this.app.a().a((short)1, (byte)1);
  }
  
  public void f()
  {
    this.app.a();
    long l1 = MessageCache.a();
    this.app.a().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    String str;
    if (this.jdField_c_of_type_JavaLangString.compareTo(this.jdField_b_of_type_JavaLangString) == 0)
    {
      str = this.jdField_c_of_type_JavaLangString;
      if (!a(str)) {
        break label196;
      }
      str = str.replaceAll("[\\\\/:*?\"<>|]", "");
      this.jdField_a_of_type_JavaLangStringBuffer.append(str + ".txt");
    }
    for (;;)
    {
      boolean bool = FileUtils.b(AppConstants.as, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131363119), getString(2131363119) + AppConstants.as + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new ada(this), new adc(this));
      if (!bool) {
        break label230;
      }
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
      str = String.format("%s(%s)", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
      break;
      label196:
      this.jdField_a_of_type_JavaLangStringBuffer.append(this.jdField_b_of_type_JavaLangString + ".txt");
    }
    label230:
    b(getString(2131363121));
  }
  
  public void h()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131363172), getString(2131363173), new ade(this), new adf(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null)
      {
        Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
        if (localCursor == null) {
          return;
        }
        localCursor.moveToFirst();
        int i1 = 0;
        if (i1 < localCursor.getCount())
        {
          Object localObject;
          label94:
          String str2;
          String str3;
          if ((localCursor.getColumnIndex("versionCode") < 0) || (localCursor.getInt(localCursor.getColumnIndex("versionCode")) <= 0))
          {
            localObject = localCursor.getString(localCursor.getColumnIndex("msg"));
            str2 = localCursor.getString(localCursor.getColumnIndex("senderuin"));
            if ((localObject != null) && (((String)localObject).length() > 0) && (((String)localObject).charAt(0) == '\026') && (b((String)localObject)))
            {
              localObject = localObject.split("\026")[1].split("\\|");
              str3 = localObject[0];
              if (localObject.length >= 2) {
                break label283;
              }
            }
          }
          String str1;
          label283:
          for (int i2 = 1;; i2 = Integer.valueOf(str1[2]).intValue())
          {
            for (;;)
            {
              if (i2 == 1) {
                new File(ImageUtil.a(this, Uri.parse(str3))).delete();
              }
              if ((!str2.equals(c())) || (i2 == 2)) {
                new File(str3).delete();
              }
              localCursor.moveToNext();
              i1 += 1;
              break;
              try
              {
                localObject = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                str1 = "";
              }
            }
            break label94;
          }
        }
      }
      return;
    }
    catch (Exception localException2) {}
  }
  
  void j()
  {
    this.x = a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, null);
    if (this.x < 8)
    {
      this.jdField_b_of_type_Int = 1;
      return;
    }
    if (this.x % 8 == 0) {}
    for (int i1 = this.x / 8;; i1 = this.x / 8 + 1)
    {
      this.jdField_b_of_type_Int = i1;
      return;
    }
  }
  
  public void k()
  {
    AudioUtil.b(2131165186, false);
  }
  
  public void l()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (AIOUtils.b()) {
      return;
    }
    boolean bool1;
    if (paramSensorEvent.values[0] < this.jdField_b_of_type_Float)
    {
      bool1 = true;
      label26:
      if (this.jdField_b_of_type_Boolean == bool1) {
        break label87;
      }
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (this.jdField_b_of_type_Boolean) {
          break label89;
        }
        bool1 = bool2;
        label61:
        paramSensorEvent.a(bool1);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label94;
      }
    }
    label87:
    label89:
    label94:
    for (int i1 = 2131363180;; i1 = 2131363181)
    {
      a(i1);
      return;
      bool1 = false;
      break label26;
      break;
      bool1 = false;
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */