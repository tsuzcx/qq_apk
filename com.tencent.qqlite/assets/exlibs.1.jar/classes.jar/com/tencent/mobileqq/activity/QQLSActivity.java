package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import bcl;
import bcm;
import bcn;
import bco;
import bcp;
import bcq;
import bcr;
import bcs;
import bct;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;

public class QQLSActivity
  extends AppActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, QQLSSensor.ProximitySensorChangeListener, Observer
{
  public static final String a = "QQLSActivity";
  public static boolean a;
  private final int jdField_a_of_type_Int = 300;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new bcq(this, Looper.getMainLooper());
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bcp(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcs jdField_a_of_type_Bcs;
  private bct jdField_a_of_type_Bct;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  public DragFrameLayout a;
  protected MessageObserver a;
  NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQLSRecentManager a;
  public QQLSSensor a;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final int jdField_b_of_type_Int = 1000;
  private long jdField_b_of_type_Long = 0L;
  private PowerManager.WakeLock jdField_b_of_type_AndroidOsPowerManager$WakeLock;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 1;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 2;
  private boolean jdField_d_of_type_Boolean = true;
  private final int jdField_e_of_type_Int = 3;
  private boolean jdField_e_of_type_Boolean = false;
  private final int jdField_f_of_type_Int = 4;
  private boolean jdField_f_of_type_Boolean = true;
  private final int g = 5;
  private final int h = 6;
  private final int i = 7;
  private final int j = 8;
  private final int k = 9;
  private final int l = 10;
  private final int m = 1500;
  private final int n = 1000;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public QQLSActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new bcn(this);
  }
  
  private int a()
  {
    int i2 = 10000;
    try
    {
      i1 = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getScreenOffTime " + i1);
      }
      return i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQLSActivity", 2, "getScreenOffTime e=" + localException.getMessage());
          i1 = i2;
        }
      }
    }
  }
  
  private SessionInfo a(RecentBaseData paramRecentBaseData)
  {
    int i1 = paramRecentBaseData.a();
    String str = paramRecentBaseData.a();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    if (i1 == 1)
    {
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        if (!((FriendManager)localObject).f(str)) {
          break label103;
        }
        localObject = ((FriendManager)localObject).a(str);
        if (localObject != null) {
          localSessionInfo.b = ((OpenTroopInfo)localObject).troopUin;
        }
      }
    }
    for (;;)
    {
      localSessionInfo.jdField_a_of_type_JavaLangString = str;
      localSessionInfo.jdField_a_of_type_Int = i1;
      localSessionInfo.d = paramRecentBaseData.jdField_a_of_type_JavaLangString;
      return localSessionInfo;
      label103:
      localObject = ((FriendManager)localObject).a(str + "");
      if ((localObject != null) && (((TroopInfo)localObject).troopcode != null))
      {
        localSessionInfo.b = ((TroopInfo)localObject).troopcode;
        continue;
        if (i1 == 1006)
        {
          localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
          localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
          localSessionInfo.f = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          if ((localSessionInfo.f == null) && (QLog.isColorLevel())) {
            QLog.d("QQLSActivity", 2, "contactUin == null");
          }
        }
        else if (((i1 == 1004) || (i1 == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
        {
          localSessionInfo.b = ((RecentUserBaseData)paramRecentBaseData).c();
        }
      }
    }
  }
  
  private List a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    Object localObject2 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item msg list size: " + ((List)localObject1).size());
    }
    if (MsgProxyUtils.a(paramInt)) {
      localObject1 = MsgProxy.a((List)localObject1, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString).first).longValue());
    }
    Object localObject3;
    while (paramInt == 1001)
    {
      return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 1, ((List)localObject1).size()));
      if ((paramInt == 3000) || (paramInt == 1))
      {
        localObject1 = MsgProxyUtils.a((List)localObject1, false);
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt == 4000)
        {
          localObject3 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
          MessageRecord localMessageRecord = new MessageRecord();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((NewFriendManager)localObject3).a() != null)
            {
              localMessageRecord.msg = ((NewFriendManager)localObject3).a().jdField_a_of_type_JavaLangString;
              localMessageRecord.istroop = paramInt;
              localMessageRecord.frienduin = paramString;
              ((List)localObject2).add(localMessageRecord);
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item continued msg list size: " + ((List)localObject1).size());
    }
    MsgProxyUtils.a((List)localObject1);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramString = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "single item continued msg list size= 0" + Thread.currentThread().getId());
      }
      finish();
      return new ArrayList();
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if ((((MessageRecord)localObject3).isread) || (((MessageRecord)localObject3).isSend())) {
        paramString.add(localObject3);
      }
    }
    ((List)localObject1).removeAll(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item unread msg list size: " + ((List)localObject1).size());
    }
    if (((List)localObject1).size() > 15) {
      return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 15, ((List)localObject1).size()));
    }
    return localObject1;
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    d();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enterAIO");
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {}
    for (Object localObject = ((RecentUserBaseData)paramRecentBaseData).a();; localObject = null)
    {
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
      QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_f_of_type_Boolean = true;
      if (b())
      {
        d();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramRecentBaseData = new Intent(this, SplashActivity.class);
        paramRecentBaseData.putExtra("tab_index", 0);
        paramRecentBaseData.setFlags(67108864);
        startActivity(paramRecentBaseData);
        paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
        return;
      }
      RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject, paramRecentBaseData.jdField_a_of_type_JavaLangString, true);
      paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (GesturePWDUtils.getJumpLock(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
      for (long l1 = 500L;; l1 = 0L)
      {
        ((Handler)localObject).sendMessageDelayed(paramRecentBaseData, l1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
        return;
      }
    }
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    QQLSRecentManager localQQLSRecentManager;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("judge need to wake up, now =").append(l1).append(", firstMsgTime =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_a_of_type_Long).append(", lastWakeUpTime = ");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_b_of_type_Long).append(", wakeUpTimeAfter30Minute =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "消息是群消息不点亮");
      }
    }
    do
    {
      return false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 < QQLSRecentManager.jdField_a_of_type_Long + 1800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "30分钟以内，每一条消息亮屏一次");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_b_of_type_Long = l1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = false;
        return true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      long l2 = Math.min(6, QQLSRecentManager.jdField_a_of_type_Int + 1) * 10 * 60 * 1000;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("之前提醒过");
        localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int + "次");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 > l2 + QQLSRecentManager.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "超过间隔时间，亮屏一次");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = true;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQLSActivity", 2, "不亮屏");
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent1.getEventTime() > 300L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isConsideredDoubleTap true");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(16)
  private boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {}
    }
    for (;;)
    {
      try
      {
        KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + localKeyguardManager.isKeyguardSecure());
        }
        if ((localKeyguardManager == null) || (!localKeyguardManager.isKeyguardLocked())) {
          continue;
        }
        bool1 = localKeyguardManager.isKeyguardSecure();
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (SecurityException localSecurityException)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
      }
      return bool1;
      bool1 = false;
    }
    return true;
  }
  
  private void c()
  {
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Long == 0L)
    {
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Long = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int = 0;
    }
    long l1;
    do
    {
      return;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      l1 = QQLSRecentManager.jdField_b_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (l1 >= QQLSRecentManager.jdField_a_of_type_Long);
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "clearRemindTime");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  @TargetApi(9)
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298262));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968633);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298265));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298274));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(0, (int)(getResources().getDisplayMetrics().density * -120.0F - 0.5D), 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298033));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298272));
    this.jdField_b_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_b_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131298276));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298277));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298264));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298280));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298279));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bcl(this));
    this.jdField_a_of_type_Bcs = new bcs(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bcs);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new bcm(this));
    this.jdField_a_of_type_Bct = new bct(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bct);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "initUI updateUI");
    }
    f();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateUI thread" + Thread.currentThread().getId());
    }
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a());
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentBaseData size = 0,  finish" + Thread.currentThread().getId());
      }
      finish();
    }
    if (localArrayList.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = ((RecentBaseData)localArrayList.get(0));
      g();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + localArrayList.size(), "", "", "");
      return;
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Bcs.a(localArrayList);
    }
  }
  
  private void g()
  {
    Object localObject2;
    Object localObject1;
    DragTextView localDragTextView;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
    {
      localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298266);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298269);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298270);
      localDragTextView = (DragTextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298273);
      localDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localDragTextView.setDragViewType(0);
      localDragTextView.setTag(Integer.valueOf(1000));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      ((RelativeLayout)localObject2).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((RelativeLayout)localObject2).requestLayout();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      ((TextView)localObject1).setText(((RecentBaseData)localObject2).jdField_a_of_type_JavaLangString);
      localTextView.setText(((RecentBaseData)localObject2).b);
      if ((((RecentBaseData)localObject2).a() != 4000) && (((RecentBaseData)localObject2).a() != 1001)) {
        break label251;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298274).setVisibility(8);
    }
    for (;;)
    {
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish" + Thread.currentThread().getId());
      }
      finish();
      return;
      label251:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298274).setVisibility(0);
    }
    this.jdField_a_of_type_Bct.a((List)localObject1);
    this.jdField_b_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_Bct.getCount() - 1);
    if (GesturePWDUtils.getGesturePWDState(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 2) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298274).setVisibility(8);
    }
    if (((RecentBaseData)localObject2).a() == 4000)
    {
      CustomWidgetUtil.a(localDragTextView, 3, ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a(), 0);
      return;
    }
    CustomWidgetUtil.a(localDragTextView, 3, ((RecentBaseData)localObject2).b(), 0);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
    }
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
        }
        j();
      }
    }
    else {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen hasSensor=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
      j();
      return;
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "some phone need to bright early");
      }
      j();
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
      }
      i();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      i();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
    }
    j();
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new wakeLock");
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new brightWakeLock");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = l1;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int += 1;
    }
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)getSystemService("power")).newWakeLock(268435462, "QQLSActivity");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire(10000L);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "release wakeLock");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "release Exception e=" + localException.getMessage());
        }
      }
    }
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      if ((AIOUtils.a()) && (Build.VERSION.SDK_INT == 15))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = Build.MANUFACTURER + "-" + Build.MODEL;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setPhoneNeedBright devicesInfo=== " + (String)localObject);
      }
      if ((((String)localObject).equalsIgnoreCase("oppo-x907")) || (((String)localObject).equalsIgnoreCase("samsung-sch-i779")) || (((String)localObject).equalsIgnoreCase("xiaomi-hm 1sc")) || (((String)localObject).endsWith("lenovo-lenovo a390t")) || (((String)localObject).endsWith("xiaomi-2013022")) || (((String)localObject).endsWith("bbk-vivo x3t")) || (((String)localObject).endsWith("bbk-vivo y3t")) || (((String)localObject).endsWith("oppo-r813t")) || (((String)localObject).endsWith("huawei-huawei t8833")) || (((String)localObject).equalsIgnoreCase("unknown-K-Touch W619")) || (((String)localObject).equalsIgnoreCase("COOLPAD-Coolpad 8079")) || (((String)localObject).endsWith("K-Touch-K-Touch T780")) || (((String)localObject).endsWith("HTC-HTC T328w")) || (((String)localObject).endsWith("HUAWEI-HUAWEI U9508")))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (QQLSRecentManager.a());
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_d_of_type_Boolean = false;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 203	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 942	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 203	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 288	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 946	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   28: goto -14 -> 14
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QQLSActivity
    //   9	2	1	bool	boolean
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	31	finally
    //   17	28	31	finally
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "sensor has callback sensorIsClose=" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    do
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "callback firstTimeToWakeScreen=" + this.jdField_d_of_type_Boolean);
      }
    } while (!this.jdField_d_of_type_Boolean);
    if (a()) {
      j();
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      break;
      i();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQLSActivity", 2, "onChange isDone " + paramBoolean);
      QLog.d("QQLSActivity", 2, "onChange mDragHost.getMode() " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a());
    }
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.a();
      if ((paramDragFrameLayout == null) || (paramDragFrameLayout.getTag() == null)) {
        break label887;
      }
      paramInt = ((Integer)paramDragFrameLayout.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "delete onChange position=" + paramInt);
      }
      if (paramInt == 1000)
      {
        paramInt = ((MessageRecord)this.jdField_a_of_type_Bct.a.get(0)).istroop;
        paramDragFrameLayout = ((MessageRecord)this.jdField_a_of_type_Bct.a.get(0)).frienduin;
        if (paramInt == 1001) {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).b(paramDragFrameLayout, paramInt);
        }
        do
        {
          for (;;)
          {
            RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, paramInt);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout, paramInt);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i();
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "single data remove finish");
            }
            finish();
            if (paramInt != 3000) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
            return;
            if (paramInt == 4000) {
              ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).f();
            }
          }
          if (paramInt == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
            return;
          }
          if (paramInt == 0)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
            return;
          }
        } while (paramInt != 1001);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        return;
      }
      i1 = ((RecentBaseData)bcs.a(this.jdField_a_of_type_Bcs).get(paramInt)).a();
      paramDragFrameLayout = ((RecentBaseData)bcs.a(this.jdField_a_of_type_Bcs).get(paramInt)).a();
      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, i1);
      if (i1 == 1001)
      {
        ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).b(paramDragFrameLayout, i1);
        localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.iterator();
        while (localIterator.hasNext())
        {
          localMessage = (QQMessageFacade.Message)localIterator.next();
          if (localMessage.istroop == i1) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localMessage);
          }
        }
      }
      if (i1 != 4000) {
        break label750;
      }
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(AppConstants.ad, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(AppConstants.V, 4000);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramDragFrameLayout, i1);
      bcs.a(this.jdField_a_of_type_Bcs).remove(paramInt);
      this.jdField_a_of_type_Bcs.notifyDataSetChanged();
      if (i1 != 3000) {
        break label766;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
    }
    label750:
    label766:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i1;
        Iterator localIterator;
        QQMessageFacade.Message localMessage;
        this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onChange updateUI" + Thread.currentThread().getId());
        }
        this.jdField_f_of_type_Boolean = true;
        runOnUiThread(new bcr(this));
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout, i1);
        continue;
        if (i1 == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
        } else if (i1 == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
        } else if (i1 == 1001) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        }
      }
    }
    label887:
    QLog.d("QQLSActivity", 2, "dragView = null");
    return;
    this.jdField_f_of_type_Boolean = false;
  }
  
  public boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord == null) || (!ActionMsgUtil.b(localMessageRecord.msgtype))) {}
    }
    return false;
  }
  
  public void b()
  {
    new SessionInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i();
      localSessionInfo = a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((localObject != null) && (((String)localObject).length() > 3478))
    {
      ChatActivityUtils.a(this, 2131362972, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1)
    {
      localObject = new ArrayList();
      String str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, str, (ArrayList)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().clear();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, (String)localObject, null);
    }
  }
  
  protected void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnBackPressed=== ");
    }
    finish();
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    StatisticCollector.a(this).c(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "dooncreate taskId" + getTaskId() + Thread.currentThread().getId());
    }
    setContentView(2130903509);
    getWindow().addFlags(524288);
    l();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = new QQLSSensor(getApplicationContext(), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.a();
    paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "app null,  finish");
      }
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager = ((QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31));
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    c();
    this.jdField_d_of_type_Boolean = true;
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnDestroy taskId" + getTaskId());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = null;
    }
    super.doOnDestroy();
    StatisticCollector.a(this).f(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnNewIntent taskId" + getTaskId());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))) {
      return;
    }
    f();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.a(this).e(this);
    this.mRuntime.isBackground_Pause = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnPause taskId" + getTaskId());
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1500L);
    if ((Build.MANUFACTURER + "-" + Build.MODEL).equalsIgnoreCase("Xiaomi-2013022"))
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 600L);
    }
    do
    {
      do
      {
        return;
        localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + (String)localObject);
      }
    } while (!((String)localObject).equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity"));
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
    }
    localObject = new Intent(this, QQLSActivity.class);
    ((Intent)localObject).addFlags(131072);
    startActivity((Intent)localObject);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    StatisticCollector.a(this).d(this);
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = true;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = true;
    this.mRuntime.isBackground_Pause = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnResume taskId" + getTaskId());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    Object localObject = GuardManager.a;
    if (localObject != null) {
      ((GuardManager)localObject).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnStart taskId" + getTaskId());
    }
    if (getTaskId() == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
      }
      finish();
    }
    try
    {
      localObject = Activity.class.getDeclaredField("mFinished");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).get(this);
      ((Field)localObject).set(this, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    localObject = GuardManager.a;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = null;
    }
    if (localObject != null) {
      ((GuardManager)localObject).c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnStop taskId" + getTaskId());
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "on finish taskId" + getTaskId());
    }
    Object localObject = new Exception("this is a log");
    ((Exception)localObject).printStackTrace();
    localObject = ((Exception)localObject).getStackTrace();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < localObject.length)
      {
        localStringBuilder.append(localObject[i1].getClassName() + ":");
        localStringBuilder.append(localObject[i1].getFileName() + ":");
        localStringBuilder.append(localObject[i1].getLineNumber() + ":");
        localStringBuilder.append(localObject[i1].getMethodName() + ":\n\n");
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    super.finish();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Object localObject = getWindow().getAttributes().token;
      String str = getClass().getName();
      localObject = localObject.toString() + "----->" + str;
      StatisticCollector.a(this).a("WindowToken2Activity", (String)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    d();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298277: 
      do
      {
        do
        {
          return;
          d();
        } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
      return;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      }
      Toast.makeText(getApplicationContext(), getString(2131364421), 0).show();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 3000) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramView = new Intent(this, SplashActivity.class);
        paramView.putExtra("tab_index", 0);
        paramView.setFlags(67108864);
        startActivity(paramView);
        paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
        }
      }
    }
    d();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    paramView = new Intent(this, SplashActivity.class);
    paramView.putExtra("tab_index", 0);
    paramView.setFlags(67108864);
    startActivity(paramView);
    paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1500L);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "logout finish");
    }
    finish();
    super.onLogout(paramLogoutReason);
  }
  
  protected void onUserLeaveHint()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onUserLeaveHint");
    }
    d();
    super.onUserLeaveHint();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "update" + Thread.currentThread().getId());
    }
    runOnUiThread(new bco(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */