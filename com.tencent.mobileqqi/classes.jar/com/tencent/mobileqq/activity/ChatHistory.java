package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
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
import android.support.v4.view.MenuItemCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cbh;
import cbj;
import cbk;
import cbl;
import cbm;
import cbn;
import cbo;
import cbq;
import cbr;
import cbs;
import cbt;
import cbu;
import cbv;
import cbw;
import cby;
import cbz;
import cca;
import ccc;
import ccd;
import cce;
import ccf;
import ccg;
import cch;
import cci;
import ccr;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
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
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
  private static final int y = 0;
  float jdField_a_of_type_Float;
  public int a;
  public long a;
  public Dialog a;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new cbh(this);
  public Handler a;
  public View a;
  AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new cbz(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageView a;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  public TextView a;
  ccr jdField_a_of_type_Ccr = new ccr(this, null);
  public ChatHistory.ChatHistoryAdapter a;
  public ChatHistory.PlayingPttHistoryInfo a;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new cby(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public MessageSearchDialog a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cbv(this);
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new cbw(this);
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
  private Handler jdField_b_of_type_AndroidOsHandler = new cbu(this);
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public Dialog c;
  View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public TextView c;
  public String c;
  private Dialog jdField_d_of_type_AndroidAppDialog;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
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
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = MsgUtils.b(paramInt3);
      localMsgBody.msg = MsgUtils.a(TransfileUtile.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
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
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager();
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
        localStringBuffer.append(" " + getString(2131562902) + " ");
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
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131231333));
    b();
    n();
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
      paramImageView.setImageDrawable(getResources().getDrawable(2130839148));
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
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b());
      if (localObject1 == null) {
        break label944;
      }
    }
    label258:
    label644:
    label941:
    label944:
    for (Cursor localCursor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b().a(((StringBuilder)localObject1).toString(), null);; localCursor = null)
    {
      if (paramInt == 1)
      {
        paramString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
        localStringBuffer.append(getString(2131562431) + ":");
        localStringBuffer.append(paramString);
        localStringBuffer.append("\r\n===========================================\r\n");
      }
      if ((localCursor != null) && (localCursor.moveToFirst())) {
        paramString = (String)localObject3;
      }
      for (;;)
      {
        int i2 = localCursor.getInt(localCursor.getColumnIndex("time"));
        localObject1 = localCursor.getString(localCursor.getColumnIndex("senderuin"));
        label227:
        int i1;
        label309:
        String str;
        if (1 == paramInt)
        {
          localObject1 = String.format("%s(%s)", new Object[] { ContactUtils.f(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, (String)localObject1), localObject1 });
          i1 = localCursor.getInt(localCursor.getColumnIndex("issend"));
          if (!MsgUtils.a(i1)) {
            break label637;
          }
          localObject3 = d();
          if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0)) {
            break label644;
          }
          paramString = localCursor.getString(localCursor.getColumnIndex("msg"));
          str = new QQText(paramString, 3).a();
          localObject1 = str;
          if (str != null)
          {
            localObject1 = str;
            if (str.length() > 0)
            {
              localObject1 = str;
              if (b(str))
              {
                localObject1 = str.split("\026")[1].split("\\|");
                if (localObject1.length >= 2) {
                  break label881;
                }
                i1 = 1;
                if ((i1 != 1) && (i1 != 65538)) {
                  break label895;
                }
                localObject1 = getString(2131561542);
              }
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            localObject1 = a(i2 * 1000L) + "  " + (String)localObject3 + "\r\n" + (String)localObject1;
            localStringBuffer.append((String)localObject1 + "\r\n\r\n");
            label637:
            int i3;
            do
            {
              if (localCursor.moveToNext()) {
                break label941;
              }
              if (localCursor != null) {
                localCursor.close();
              }
              runOnUiThread(new cbt(this, FileUtils.a(AppConstants.an, this.jdField_a_of_type_JavaLangStringBuffer, localStringBuffer.toString())));
              return;
              localObject1 = "( isValid=1 and msgtype " + MsgProxyUtils.b() + " ) ORDER BY time asc , longMsgIndex asc";
              localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(), (String)localObject1, null);
              break;
              if (3000 == paramInt)
              {
                localObject1 = String.format("%s(%s)", new Object[] { ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, 0), localObject1 });
                break label227;
              }
              localObject1 = this.jdField_c_of_type_JavaLangString;
              break label227;
              localObject3 = localObject1;
              break label258;
              i3 = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
              if (i3 == -2007)
              {
                paramString = getString(2131561548);
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
                  paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563283, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
                  break label309;
                }
                paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562920);
                break label309;
              }
            } while (i3 == -2006);
            if (i3 == -2000)
            {
              paramString = getResources().getString(2131559041);
              break label309;
            }
            if (i3 == -2002)
            {
              paramString = getResources().getString(2131559042);
              break label309;
            }
            try
            {
              localObject1 = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
              paramString = (String)localObject1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          break label309;
          label881:
          i1 = Integer.valueOf(localException[2]).intValue();
          break label384;
          label895:
          Object localObject2 = str;
          if (i1 == 2) {
            localObject2 = "[" + getString(2131563014) + "]";
          }
        }
      }
    }
  }
  
  private String c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private boolean c(String paramString)
  {
    t();
    MediaPlayerManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
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
    String str = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidViewView = View.inflate(a(), 2130903104, null);
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new ccc(this));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131231219));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131231163);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231338));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231342));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562661));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131562465));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ccf(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ccg(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839665);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838078);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231341));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231339));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cch(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231343));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cci(this));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131231344));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new cbj(this));
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new cbk(this));
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localFriendManager == null) || (!localFriendManager.b(String.valueOf(this.jdField_b_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistory", 2, "--mSyncHistory button: fm is null or the uin is not my friend: fm:" + localFriendManager);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
  }
  
  private void p()
  {
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.e = ((this.jdField_c_of_type_Int - 1) * 8);
  }
  
  private void q()
  {
    if (!NetworkUtil.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131561425, 1).a();
      return;
    }
    c(getApplication().getResources().getString(2131561932));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_b_of_type_JavaLangString);
  }
  
  private void r()
  {
    String str = getResources().getString(2131562216);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.U)))
      {
        this.jdField_c_of_type_JavaLangString = getResources().getString(2131562249);
        if (!this.jdField_b_of_type_JavaLangString.equals(String.valueOf(AppConstants.U))) {
          break label310;
        }
        str = getResources().getString(2131562249);
      }
    }
    label310:
    for (;;)
    {
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      setTitle(str);
      this.jdField_d_of_type_JavaLangString = d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      findViewById(2131231332).setVisibility(8);
      return;
      this.jdField_c_of_type_JavaLangString = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_c_of_type_JavaLangString = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).e(this.jdField_b_of_type_JavaLangString);
      } else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_c_of_type_JavaLangString = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_b_of_type_JavaLangString);
      } else if (this.jdField_a_of_type_Int == 3000) {
        this.jdField_c_of_type_JavaLangString = ContactUtils.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void s()
  {
    if (jdField_a_of_type_AndroidWidgetToast != null)
    {
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  private void u()
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
  
  private void v()
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
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_chatlog", 0, 0, str, "", "", "");
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
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b();
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
  
  protected View a()
  {
    super.a();
    TextView localTextView = this.m;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.m.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131562795);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.m.setVisibility(0);
    }
  }
  
  public void a()
  {
    findViewById(2131231332);
    findViewById(2131231116);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new ccd(this));
  }
  
  public void a(int paramInt)
  {
    QQToast.a(a(), paramInt, 0).b(getResources().getDimensionPixelSize(2131427376));
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(d());
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
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getResources().getString(2131560601));
      localActionSheet.a(2131561917, 3);
      localActionSheet.d(2131561746);
      localActionSheet.a(new cca(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903199, null);
    if (1 == this.jdField_a_of_type_Int)
    {
      ((TextView)localView.findViewById(2131231294)).setText(2131561442);
      localView.findViewById(2131231554).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131561827)).setPositiveButton(getString(2131561917), new cbn(this, paramString)).setNegativeButton(getString(2131561751), new cbm(this)).addView(localView);
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        ((TextView)localView.findViewById(2131231294)).setText(2131561441);
        localView.findViewById(2131231554).setVisibility(8);
      }
      else if ((1001 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int))
      {
        localView.findViewById(2131231554).setVisibility(8);
      }
    }
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidViewView = View.inflate(a(), 2130903944, null);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131233086).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131233087);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(new cce(this));
    b(this.jdField_c_of_type_AndroidViewView);
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
  
  protected boolean b()
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    setResult(-1);
    return super.b();
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
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int) > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if ((this.jdField_a_of_type_Int == 0) && (((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131231554)).isChecked()))
    {
      q();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    new cbl(this).run();
  }
  
  public void d()
  {
    k();
    p();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968692));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968666));
    paramBundle = getIntent().getExtras();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
    f(2130903129);
    b(getIntent());
    k();
    p();
    r();
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
    o();
    u();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    v();
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
    s();
    m();
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
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
    k();
    if (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.e = ((this.jdField_c_of_type_Int - 1) * 8);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.e);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, getResources().getString(2131563008)).sendToTarget();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((short)1, (byte)1);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void g()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = MessageCache.a();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, l1 - 604800L, 0L, l1, (short)0, 0L);
  }
  
  public void h()
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
      boolean bool = FileUtils.b(AppConstants.an, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131562050), getString(2131562050) + AppConstants.an + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new cbo(this), new cbq(this));
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
    b(getString(2131561467));
  }
  
  public void i()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131561985), getString(2131561986), new cbr(this), new cbs(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void j()
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
  
  void k()
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
  
  public void l()
  {
    ((BaseApplicationImpl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(2131165198, false);
  }
  
  public void m()
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
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
      {
        this.jdField_a_of_type_Long = l1;
        a();
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
    localMenuItem.setIcon(2130839698);
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
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
        break label80;
      }
      this.jdField_b_of_type_Boolean = bool1;
      paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
      if (this.jdField_b_of_type_Boolean) {
        break label82;
      }
      bool1 = bool2;
      label54:
      paramSensorEvent.a(bool1);
      if (!this.jdField_b_of_type_Boolean) {
        break label87;
      }
    }
    label80:
    label82:
    label87:
    for (int i1 = 2131561997;; i1 = 2131562961)
    {
      a(i1);
      return;
      bool1 = false;
      break label26;
      break;
      bool1 = false;
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory
 * JD-Core Version:    0.7.0.1
 */