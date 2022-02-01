package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import acbn;
import accn;
import acfp;
import acoe;
import acof;
import acog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqmr;
import aqnm;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import rpq;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;
import wgw;
import wgx;
import wgy;
import wgz;
import wha;
import whb;
import whc;
import whj;
import whn;
import wif;
import wig;
import wih;
import wii;
import wja;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
{
  private static final int bNf = aqnm.dpToPx(16.0F);
  private long HF;
  private acof jdField_a_of_type_Acof;
  private acog jdField_a_of_type_Acog = new whc(this);
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  private BirthdayActivatePageArkView jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView;
  MemorialActivatePage jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage;
  private ReminderViewPager jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager;
  private wif jdField_a_of_type_Wif;
  private int atZ;
  private int bNg;
  private int bNh;
  private boolean bcl;
  private boolean bcm;
  private accn cardObserver = new whb(this);
  private int entranceId;
  private LinearLayout gQ;
  private boolean jm;
  Handler mHandler = new Handler(Looper.getMainLooper(), new wgz(this));
  private TextView mLeftBackText;
  private wii mReminderDataManager;
  private ImageView rO;
  
  private boolean QX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bF();
    } while ((localArrayList == null) || (localArrayList.isEmpty()));
    return (ActivateBasePage)localArrayList.get(0) instanceof ReminderCardItemPage;
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage = new MemorialActivatePage(this, this.app, paramInt1, String.valueOf(paramLong2), paramInt2, paramString1, paramString2, paramString3, paramString4, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage.fS(paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendMemorialActivatePage);
  }
  
  private void a(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.show");
      }
      anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.show", 0, 0, "", "", paramAcsMsg.busi_id, paramAcsMsg.msg_id);
    }
    for (;;)
    {
      ReminderCardItemPage localReminderCardItemPage = new ReminderCardItemPage(this, this.app);
      localReminderCardItemPage.b(paramAcsMsg);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localReminderCardItemPage);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.none");
      }
      anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.none", 0, 0, "", "", "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView = new BirthdayActivatePageArkView(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.i(paramLong, paramString, this.bNh);
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.i(paramLong, paramString, this.bNh);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ActivateFriends.MainActivity", 1, "erro " + paramQQAppInterface.toString());
    }
  }
  
  private TopGestureLayout b()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  private void bXY()
  {
    if (this.bcl)
    {
      a(this.app, System.currentTimeMillis(), whj.a(null, this.app));
      this.jdField_a_of_type_Acof.cNg();
      bYa();
      return;
    }
    a(this.app, System.currentTimeMillis(), null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.ym(false);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.mRootView.findViewById(2131366430);
    SpannableString localSpannableString = new SpannableString(acfp.m(2131701989));
    localSpannableString.setSpan(new wgw(this), 0, 2, 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void bXZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.getCount();; i = 0)
    {
      this.bNg = i;
      if (this.bNg <= 1) {
        break label160;
      }
      this.gQ.removeAllViews();
      this.gQ.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dpToPx(7.0F), aqnm.dpToPx(7.0F));
      i = 0;
      while (i < this.bNg)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageDrawable(getResources().getDrawable(2130838099));
        if (i != 0) {
          localLayoutParams.leftMargin = wja.dp2px(5.0F, getResources());
        }
        localImageView.setLayoutParams(localLayoutParams);
        this.gQ.addView(localImageView);
        i += 1;
      }
    }
    this.atZ = 0;
    BV(this.atZ);
    label160:
    do
    {
      return;
      this.gQ.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.BX(0);
  }
  
  private void setupUI()
  {
    super.setContentView(2131561170);
    super.setTitle(2131689680);
    this.rO = ((ImageView)super.findViewById(2131369594));
    this.rO.setVisibility(0);
    this.rO.setImageResource(2130840663);
    this.rO.setOnClickListener(this);
    this.mLeftBackText = ((TextView)findViewById(2131369579));
    this.gQ = ((LinearLayout)super.findViewById(2131374118));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager = ((ReminderViewPager)findViewById(2131362037));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setPageMargin(bNf);
    this.entranceId = getIntent().getIntExtra("af_key_from", 1);
    this.jdField_a_of_type_Acof = ((acof)this.app.getManager(85));
    this.jdField_a_of_type_Wif = ((wif)this.app.getManager(321));
    this.bcl = this.jdField_a_of_type_Acof.aX(true);
    if (AppSetting.enableTalkBack) {
      this.rO.setContentDescription(getString(2131719875));
    }
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.gQ.getLayoutParams();
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends.MainActivity", 2, "mViewPager height: " + localLayoutParams1.height);
      QLog.d("ActivateFriends.MainActivity", 2, "mPageIndicator topMargin: " + localLayoutParams2.topMargin);
      QLog.d("ActivateFriends.MainActivity", 2, "screen height: " + rpq.getScreenHeight(this));
    }
    int i;
    if (localLayoutParams1 != null)
    {
      this.bNh = ((int)(0.785D * rpq.getScreenHeight(this)));
      i = aqnm.dpToPx(550.0F);
      if (this.bNh >= i) {
        break label416;
      }
    }
    for (;;)
    {
      this.bNh = i;
      localLayoutParams1.height = this.bNh;
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderViewPager.setLayoutParams(localLayoutParams1);
      if (localLayoutParams2 != null)
      {
        localLayoutParams2.topMargin = ((int)(0.8050000000000001D * rpq.getScreenHeight(this)));
        this.gQ.setLayoutParams(localLayoutParams2);
      }
      return;
      label416:
      i = this.bNh;
    }
  }
  
  private boolean vz()
  {
    Object localObject1;
    int i;
    label64:
    Object localObject2;
    Object localObject3;
    label170:
    Object localObject4;
    if (this.bcl)
    {
      this.jdField_a_of_type_Acof.cNi();
      localObject1 = null;
      if (getIntent().getExtras() != null) {
        localObject1 = getIntent().getExtras().getString("leftViewText");
      }
      if ((localObject1 == null) || (!((String)localObject1).contains(getString(2131720735)))) {
        break label217;
      }
      i = 1;
      if (i != 0) {
        this.app.b().addObserver(this);
      }
      localObject1 = this.app.b().k(acbn.bla, 9002);
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "current message count = " + ((List)localObject1).size());
      }
      localObject2 = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label1879;
      }
      localObject3 = ((List)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label253;
      }
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      if (!(localObject4 instanceof MessageForActivateFriends)) {
        break label222;
      }
      i += 1;
    }
    for (;;)
    {
      break label170;
      this.jdField_a_of_type_Wif.bYn();
      break;
      label217:
      i = 0;
      break label64;
      label222:
      if ((localObject4 instanceof MessageForText))
      {
        ((List)localObject2).add((MessageForText)localObject4);
        ((Iterator)localObject3).remove();
      }
    }
    label253:
    for (int k = i;; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + k);
      }
      localObject2 = new ArrayList(((List)localObject1).size());
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        if (((localObject4 instanceof MessageForActivateFriends)) && (!((MessageRecord)localObject4).isread) && ((((MessageRecord)localObject4).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject4).extStr))) {
          ((List)localObject2).add(((MessageRecord)localObject4).extStr);
        }
      }
      if (((List)localObject2).size() > 0) {
        acoe.e(this.app, (ArrayList)localObject2);
      }
      this.app.b().ca(acbn.bla, 9002);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bYe();
      }
      Collections.sort((List)localObject1, new wgx(this));
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
      }
      if (k > 0)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForActivateFriends))
          {
            localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
            i = -1;
            if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != 1) {
              break label718;
            }
            i = 2;
          }
        }
      }
      for (;;)
      {
        anot.a(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
        localObject2 = new ArrayList();
        if (k <= 0) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject3 instanceof MessageForActivateFriends))
          {
            localObject4 = new wig();
            ((wig)localObject4).HI = ((MessageRecord)localObject3).time;
            ((wig)localObject4).messageRecord = ((MessageRecord)localObject3);
            ((wig)localObject4).c = null;
            ((ArrayList)localObject2).add(localObject4);
          }
        }
        if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2) {
          i = 1;
        } else if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 3) {
          i = (int)((SubMsgType0x76.OneMemorialDayInfo)((MessageForActivateFriends)localObject2).getMsgBody().msg_memorialday_notify.rpt_anniversary_info.get(0)).uint32_type.get() + 2;
        }
      }
      if (this.bcl)
      {
        localObject1 = this.mReminderDataManager.cK();
        if ((QLog.isColorLevel()) && (localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          QLog.i("ActivateFriends.MainActivity", 2, "get today's list size: " + ((List)localObject1).size());
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (AcsMsg)((Iterator)localObject3).next();
            QLog.i("ActivateFriends.MainActivity", 2, "acsMsg notice time: " + whn.h(((AcsMsg)localObject4).notice_time * 1000L, "yyyy-MM-dd HH:mm:ss"));
          }
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (AcsMsg)((Iterator)localObject1).next();
            localObject4 = new wig();
            ((wig)localObject4).HI = ((AcsMsg)localObject3).notice_time;
            ((wig)localObject4).messageRecord = null;
            ((wig)localObject4).c = ((AcsMsg)localObject3);
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "after order list : " + localObject2);
      }
      Collections.sort((List)localObject2, new wgy(this));
      localObject1 = new SparseBooleanArray(3);
      int j;
      int m;
      long l1;
      if (!((ArrayList)localObject2).isEmpty())
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        i = 0;
        j = 1;
        m = i;
        if (!((Iterator)localObject2).hasNext()) {
          break label1657;
        }
        localObject3 = (wig)((Iterator)localObject2).next();
        if (((wig)localObject3).messageRecord != null)
        {
          localObject3 = ((wig)localObject3).messageRecord;
          localObject4 = ((MessageForActivateFriends)localObject3).getMsgBody();
          l1 = ((MessageRecord)localObject3).time * 1000L;
          m = ((SubMsgType0x76.MsgBody)localObject4).uint32_msg_type.get();
          if ((m == 1) && (!((SparseBooleanArray)localObject1).get(1, false)))
          {
            QLog.w("ActivateFriends.MainActivity", 1, "MSG_TYPE_GEO is no longer support!");
            m = 0;
            j = i;
            i = m;
          }
        }
      }
      for (;;)
      {
        m = j;
        j = i;
        i = m;
        break;
        if ((m == 2) && (!((SparseBooleanArray)localObject1).get(2, false)))
        {
          localObject3 = whj.a(((SubMsgType0x76.MsgBody)localObject4).msg_birthday_notify, this.app);
          a(this.app, l1, (String)localObject3);
          ((SparseBooleanArray)localObject1).put(2, true);
          if (j == 0) {
            break label1187;
          }
          LpReportInfo_pf00064.allReport(220, 2, 1);
          break label1187;
        }
        if ((m != 3) || (((SparseBooleanArray)localObject1).get(3, false))) {
          break label1187;
        }
        Object localObject5 = (SubMsgType0x76.OneMemorialDayInfo)((SubMsgType0x76.MsgBody)localObject4).msg_memorialday_notify.rpt_anniversary_info.get(0);
        long l2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint64_uin.get();
        m = (int)((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_type.get();
        int n = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_memorial_time.get();
        localObject3 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_main_wording_nick.get().toStringUtf8();
        localObject4 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_main_wording_event.get().toStringUtf8();
        String str1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_sub_wording.get().toStringUtf8();
        String str2 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).bytes_greetings.get().toStringUtf8();
        int i1 = ((SubMsgType0x76.OneMemorialDayInfo)localObject5).uint32_friend_gender.get();
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("memorial_type:").append(m);
          ((StringBuilder)localObject5).append(" pushTime:").append(l1);
          ((StringBuilder)localObject5).append(" uin:").append(l2);
          ((StringBuilder)localObject5).append(" timeStamp:").append(n);
          ((StringBuilder)localObject5).append(" titleNick:").append((String)localObject3);
          ((StringBuilder)localObject5).append(" titleEvent:").append((String)localObject4);
          ((StringBuilder)localObject5).append(" subTitle:").append(str1);
          ((StringBuilder)localObject5).append(" greetings:").append(str2);
          ((StringBuilder)localObject5).append(" gender:").append(i1);
          QLog.d("ActivateFriends.MainActivity", 2, ((StringBuilder)localObject5).toString());
        }
        a(m, l1, l2, n, (String)localObject3, (String)localObject4, str1, str2, i1);
        ((SparseBooleanArray)localObject1).put(3, true);
        if (j == 0) {
          break label1187;
        }
        LpReportInfo_pf00064.allReport(220, 2, 2);
        break label1187;
        if ((((wig)localObject3).c != null) && (whn.isToday(((wig)localObject3).c.notice_time * 1000L)) && (this.HF > ((wig)localObject3).c.notice_time * 1000L))
        {
          a(((wig)localObject3).c);
          i = j;
          j = 1;
          continue;
          m = 0;
          if (k == 0) {
            bXY();
          }
          if (m == 0) {
            a(null);
          }
          bXZ();
          if ((k > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.hideLoading();
          }
          if ((!this.bcm) && (QX()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
            }
            anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
            if (getIntent() != null)
            {
              i = getIntent().getIntExtra("af_key_from", 0);
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "from : " + i);
              }
              if (i != 4) {
                break label1817;
              }
            }
          }
          for (;;)
          {
            this.bcm = true;
            return true;
            if (i == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
              }
              anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
            }
          }
        }
        else
        {
          m = i;
          i = j;
          j = m;
        }
      }
    }
  }
  
  void BV(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.bNg <= 1)
    {
      paramInt = i;
      while (paramInt < this.gQ.getChildCount())
      {
        this.gQ.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
    }
    i = 0;
    while (i < this.bNg)
    {
      this.gQ.getChildAt(i).setVisibility(0);
      i += 1;
    }
    i = 0;
    if (i < this.gQ.getChildCount())
    {
      if (i == paramInt) {
        ((ImageView)this.gQ.getChildAt(i)).setImageResource(2130838100);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.gQ.getChildAt(i)).setImageResource(2130838099);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.BX(paramInt);
    }
  }
  
  public void Qq()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addRadioButton(getString(2131689678), this.bcl);
    localausj.a(new wha(this, localausj));
    localausj.addCancelButton(2131721058);
    localausj.show();
  }
  
  public void bYa()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePageArkView.showLoading();
      this.mHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult").append(" | rs code = ").append(paramInt2);
    long[] arrayOfLong;
    Object localObject1;
    Object localObject2;
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      if (paramIntent != null)
      {
        arrayOfLong = paramIntent.getLongArrayExtra("key_friend_list");
        int i = paramIntent.getIntExtra("key_msg_type", -1);
        localObject1 = paramIntent.getLongArrayExtra("key_time_list");
        localObject2 = paramIntent.getStringExtra("key_msg_content");
        paramInt2 = paramIntent.getIntExtra("key_gift_id", -1);
        if ((arrayOfLong != null) && (arrayOfLong.length > 0) && (i != -1))
        {
          this.jdField_a_of_type_Acof.b(arrayOfLong, i);
          if ((i == 2) && (localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (((String)localObject2).length() != 0) && (paramInt2 != -1))
          {
            this.jdField_a_of_type_Acof.a(i, arrayOfLong, (long[])localObject1, (String)localObject2, paramInt2);
            anot.a(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", arrayOfLong.length, 0, "", "", "", "");
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("uinArray_stampList:");
              paramInt1 = 0;
              while (paramInt1 < arrayOfLong.length)
              {
                localStringBuilder.append(arrayOfLong[paramInt1] + "_" + localObject1[paramInt1] + "|");
                paramInt1 += 1;
              }
            }
          }
        }
        paramIntent = localStringBuilder.append(" | uinArray len = ");
        if (arrayOfLong == null)
        {
          paramInt1 = -1;
          paramIntent.append(paramInt1).append(" | type = ").append(i);
          paramIntent = localStringBuilder.append(" | stampList len = ");
          if (localObject1 != null) {
            break label376;
          }
          paramInt1 = -1;
          label317:
          paramIntent.append(paramInt1).append(" | message = ").append((String)localObject2);
          localStringBuilder.append(" | giftId id = ").append(paramInt2);
        }
      }
      else
      {
        super.finish();
        label350:
        break label641;
        break label478;
        break label478;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
      return;
      paramInt1 = arrayOfLong.length;
      break;
      label376:
      paramInt1 = localObject1.length;
      break label317;
      if ((paramInt1 == 2000) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("msg_id");
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "从全部列表中返回-----" + paramIntent);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter == null) || (aqmr.isEmpty(paramIntent))) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bF();
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        label478:
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (ActivateBasePage)((Iterator)localObject1).next();
        if (!(localObject2 instanceof ReminderCardItemPage)) {
          break label350;
        }
        localObject2 = (ReminderCardItemPage)localObject2;
        if ((((ReminderCardItemPage)localObject2).a == null) || (!paramIntent.equals(((ReminderCardItemPage)localObject2).a.msg_id)) || (this.HF < ((ReminderCardItemPage)localObject2).a.notice_time * 1000L)) {
          break label350;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bYe();
        vz();
        continue;
      }
      if ((paramInt1 == 2001) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------ qqbrowser");
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bF();
        if ((paramIntent != null) && (!paramIntent.isEmpty()))
        {
          paramIntent = paramIntent.iterator();
          label641:
          if (paramIntent.hasNext())
          {
            localObject1 = (ActivateBasePage)paramIntent.next();
            if ((!(localObject1 instanceof ReminderCardItemPage)) || (((ReminderCardItemPage)localObject1).a == null)) {
              break label350;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.MainActivity", 2, "----------刷新页面------");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bYe();
            vz();
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.HF = NetConnInfoCenter.getServerTimeMillis();
    this.mReminderDataManager = new wii(this.app);
    wih.e(this.app);
    setupUI();
    addObserver(this.cardObserver);
    this.app.registObserver(this.jdField_a_of_type_Acog);
    this.bcm = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.cardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_Acog);
    this.app.b().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.destroy();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    wih.clear();
    this.bcm = false;
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bYe();
      vz();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jm)
    {
      this.jm = true;
      vz();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.refresh();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.set");
      }
      anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.set", 0, 0, "", "", "", "");
      Qq();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.atZ = paramInt;
    anot.a(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
    LpReportInfo_pf00064.allReport(220, 3);
    BV(paramInt);
    Object localObject = b();
    if (localObject != null)
    {
      if (this.atZ != 0) {
        break label152;
      }
      ((TopGestureLayout)localObject).setInterceptTouchFlag(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.bF();
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (((ActivateBasePage)((ArrayList)localObject).get(paramInt) instanceof ReminderCardItemPage)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
          }
          anot.a(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
        }
      }
      return;
      label152:
      ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      int j = 1;
      int i = j;
      if ((paramObject instanceof ChatMessage))
      {
        i = j;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          i = 0;
        }
      }
      if (i != 0) {
        runOnUiThread(new ActivateFriendActivity.8(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */