package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import dbv;
import dbw;
import dbx;
import dby;
import dbz;
import dca;
import dcb;
import dcc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;

public class QQLSActivity
  extends AppActivity
  implements View.OnClickListener, Observer
{
  public static final String a = "QQLSActivity";
  public static boolean a;
  private final int jdField_a_of_type_Int = 300;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new dca(this, Looper.getMainLooper());
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new dbz(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQLSRecentManager jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dcb jdField_a_of_type_Dcb;
  private dcc jdField_a_of_type_Dcc;
  private final int jdField_b_of_type_Int = 1000;
  private long jdField_b_of_type_Long = 0L;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 0;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private final int d = 1;
  private final int e = 2;
  private final int f = 1500;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private SessionInfo a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    String str = paramRecentBaseData.a();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    if (i == 1)
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
      localSessionInfo.jdField_a_of_type_Int = i;
      localSessionInfo.d = paramRecentBaseData.jdField_a_of_type_JavaLangString;
      return localSessionInfo;
      label103:
      localObject = ((FriendManager)localObject).a(str + "");
      if ((localObject != null) && (((TroopInfo)localObject).troopcode != null))
      {
        localSessionInfo.b = ((TroopInfo)localObject).troopcode;
        continue;
        if (i == 1006)
        {
          localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
          localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
          localSessionInfo.f = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          if ((localSessionInfo.f == null) && (QLog.isColorLevel())) {
            QLog.d("QQLSActivity", 2, "contactUin == null");
          }
        }
        else if (((i == 1004) || (i == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
        {
          localSessionInfo.b = ((RecentUserBaseData)paramRecentBaseData).c();
        }
      }
    }
  }
  
  private List a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = new ArrayList();
    }
    Object localObject1;
    do
    {
      return paramString;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
      localObject1 = new ArrayList();
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "single item msg list size: " + ((List)localObject2).size());
      }
      if (MsgProxyUtils.a(paramInt)) {
        localObject1 = MsgProxy.a((List)localObject2, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString).first).longValue());
      }
      MessageRecord localMessageRecord;
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "single item continued msg list size: " + ((List)localObject1).size());
        }
        MsgProxyUtils.a((List)localObject1);
        MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString = new ArrayList();
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "single item continued msg list size= 0");
        }
        finish();
        return new ArrayList();
        if ((paramInt == 3000) || (paramInt == 1))
        {
          localObject1 = MsgProxyUtils.a((List)localObject2, false);
        }
        else if (paramInt == 7000)
        {
          localObject2 = SubAccountDataControll.a();
          localMessageRecord = new MessageRecord();
          localMessageRecord.msg = ((SubAccountDataControll)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).toString();
          localMessageRecord.istroop = paramInt;
          localMessageRecord.frienduin = paramString;
          ((List)localObject1).add(localMessageRecord);
        }
      }
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((localMessageRecord.isread) || (localMessageRecord.isSend())) {
          paramString.add(localMessageRecord);
        }
      }
      ((List)localObject1).removeAll(paramString);
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "single item unread msg list size: " + ((List)localObject1).size());
      }
      paramString = (String)localObject1;
    } while (((List)localObject1).size() <= 15);
    return ((List)localObject1).subList(((List)localObject1).size() - 15, ((List)localObject1).size());
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    d();
    Object localObject = null;
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {
      localObject = ((RecentUserBaseData)paramRecentBaseData).a();
    }
    RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject, paramRecentBaseData.jdField_a_of_type_JavaLangString, true);
    if (paramRecentBaseData != null) {
      paramRecentBaseData.b();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
    if (Build.VERSION.SDK_INT < 16)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
      return;
    }
    paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler;
    localObject = new dbx(this);
    if (GesturePWDUtils.getJumpLock(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
    for (long l = 500L;; l = 0L)
    {
      paramRecentBaseData.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
      return;
    }
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    QQLSRecentManager localQQLSRecentManager;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("judge need to wake up, now =").append(l1).append(", firstMsgTime =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_a_of_type_Long).append(", lastWakeUpTime = ");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_b_of_type_Long).append(", wakeUpTimeAfter30Minute =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QLog.d("QQLSActivity", 4, QQLSRecentManager.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (l1 < QQLSRecentManager.jdField_a_of_type_Long + 1800000L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "30分钟以内，每一条消息亮屏一次");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = l1;
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    long l2 = Math.min(6, QQLSRecentManager.jdField_a_of_type_Int + 1) * 10 * 60 * 1000;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("之前提醒过");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QLog.d("QQLSActivity", 4, QQLSRecentManager.jdField_a_of_type_Int + "次");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (l1 > l2 + QQLSRecentManager.jdField_b_of_type_Long)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "超过间隔时间，亮屏一次");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = l1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int += 1;
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "不亮屏");
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3000);
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
  
  private boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 16) {}
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
    long l;
    do
    {
      return;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      l = QQLSRecentManager.jdField_b_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (l >= QQLSRecentManager.jdField_a_of_type_Long);
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  private void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "clearRemindTime");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232999));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968652);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131233001));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233010));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(0, (int)(getResources().getDisplayMetrics().density * -56.0F - 0.5D), 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131233016));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131233008));
    this.jdField_b_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_b_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131233012));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131233013));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233014));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231662));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new dbv(this));
    this.jdField_a_of_type_Dcb = new dcb(this, new ArrayList());
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dcb);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new dbw(this));
    this.jdField_a_of_type_Dcc = new dcc(this, new ArrayList());
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dcc);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    f();
  }
  
  private void f()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
      if ((localRecentBaseData != null) && (localRecentBaseData.A == 0)) {
        localArrayList2.add(localRecentBaseData);
      }
    }
    localArrayList1.removeAll(localArrayList2);
    if (localArrayList1.size() == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "recentBaseData size = 0,  finish");
      }
      finish();
    }
    if (localArrayList1.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = ((RecentBaseData)localArrayList1.get(0));
      g();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + localArrayList1.size(), "", "", "");
      return;
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      dcb.a(this.jdField_a_of_type_Dcb).clear();
      dcb.a(this.jdField_a_of_type_Dcb).addAll(localArrayList1);
      this.jdField_a_of_type_Dcb.notifyDataSetChanged();
    }
  }
  
  private void g()
  {
    Object localObject;
    TextView localTextView3;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233002);
      TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233005);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233006);
      localTextView3 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233009);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      ((RelativeLayout)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((RelativeLayout)localObject).requestLayout();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      localTextView1.setText(((RecentBaseData)localObject).jdField_a_of_type_JavaLangString);
      localTextView2.setText(((RecentBaseData)localObject).b);
      if (((RecentBaseData)localObject).a() != 7000) {
        break label323;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233010).setVisibility(8);
      if (!a(((RecentBaseData)localObject).a())) {
        break label340;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839765);
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(true);
      label173:
      dcc.a(this.jdField_a_of_type_Dcc).clear();
      dcc.a(this.jdField_a_of_type_Dcc).addAll(a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a()));
      this.jdField_a_of_type_Dcc.notifyDataSetChanged();
      if (dcc.a(this.jdField_a_of_type_Dcc).size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish");
        }
        finish();
      }
      if (Build.VERSION.SDK_INT < 8) {
        break label361;
      }
      this.jdField_b_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Dcc.getCount() - 1);
    }
    for (;;)
    {
      if (GesturePWDUtils.getGesturePWDState(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 2) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233010).setVisibility(8);
      }
      CustomWidgetUtil.a(localTextView3, 3, ((RecentBaseData)localObject).b(), 0);
      return;
      label323:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233010).setVisibility(0);
      break;
      label340:
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130839766);
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(false);
      break label173;
      label361:
      this.jdField_b_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_Dcc.getCount() - 1);
    }
  }
  
  private void h()
  {
    if (a()) {
      ((PowerManager)getSystemService("power")).newWakeLock(268435462, "bright").acquire(10000L);
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 762	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 107	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 766	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
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
  
  public void b()
  {
    new SessionInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      localSessionInfo = a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((localObject != null) && (((String)localObject).length() > 3478))
    {
      ChatActivityUtils.a(this, 2131561793, 1);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "oncreate");
    }
    setContentView(2130903591);
    getWindow().addFlags(524288);
    this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager = QQLSRecentManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "app null,  finish");
      }
      finish();
    }
    do
    {
      return true;
      e();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      c();
      h();
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
    } while (paramBundle == null);
    paramBundle.sendMessage(paramBundle.obtainMessage(16711696));
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))) {
      return;
    }
    f();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.mRuntime.isBackground_Pause = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "onPause,isbackground_pause : true");
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mRuntime.isBackground_Pause = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null) {
      localGuardManager.b();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null) {
      localGuardManager.c();
    }
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "on finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a();
    }
    super.finish();
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
    case 2131233012: 
    case 2131233014: 
      do
      {
        do
        {
          return;
          d();
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() != 3000) && (!MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a()))));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 3000)
        {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), true, true, null);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DB", "0X80040DB", 0, 0, "1", "", "", "");
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
          paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1500L);
          return;
        }
        Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1006) {
          paramView = ((PhoneContactManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
        }
        for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a();; localObject = ((PhoneContactManager)localObject).c(paramView))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.jdField_a_of_type_JavaLangString, (String)localObject, true, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), true, true, null, "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DB", "0X80040DB", 0, 0, "0", "", "", "");
          break;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a();
        }
        d();
      } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      }
      Toast.makeText(getApplicationContext(), getString(2131563332), 0).show();
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
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "logout finish");
    }
    finish();
    super.onLogout(paramLogoutReason);
  }
  
  protected void onUserLeaveHint()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "onUserLeaveHint");
    }
    d();
    super.onUserLeaveHint();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "update");
    }
    if (isFinishing()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("QQLSActivity", 4, "LS is finish but still update");
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
            if ((paramObject != null) && ((paramObject instanceof ChatMessage))) {
              break;
            }
          } while ((paramObject == null) || (!(paramObject instanceof QQMessageFacade.Message)));
          if (QLog.isDevelopLevel()) {
            QLog.d("QQLSActivity", 4, "update finish");
          }
        } while (AppConstants.Z.equals(((QQMessageFacade.Message)paramObject).frienduin));
        finish();
        return;
        paramObservable = (ChatMessage)paramObject;
      } while ((paramObservable.isSend()) || (paramObservable.istroop == 6000) || (paramObservable.istroop == 1009) || (paramObservable.istroop == 1001));
      if (paramObservable.istroop != 1) {
        break;
      }
      paramObject = (RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(28);
    } while ((paramObject != null) && (paramObject.a(paramObservable.frienduin, 1) != 1));
    QQLSRecentManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop);
    runOnUiThread(new dby(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */