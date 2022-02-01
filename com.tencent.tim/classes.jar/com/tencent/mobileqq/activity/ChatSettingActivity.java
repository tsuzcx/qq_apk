package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import abbf;
import abby;
import acbn;
import accn;
import acfd;
import acff;
import acfp;
import acgr;
import achq;
import acig;
import ackl;
import acle;
import aclh;
import aclp;
import acqe;
import aeif;
import aenw;
import aenw.a;
import afck;
import agkf;
import aizg;
import ajnn;
import ajol;
import amfh;
import amhj;
import anaz;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aohy;
import aoij;
import apuh;
import aqcu;
import aqcx;
import aqdj;
import aqft;
import aqgv;
import aqha;
import aqir;
import aqiw;
import aqju;
import aqqj;
import aqrb;
import arfj;
import argi;
import arhz;
import arjh;
import asgx;
import ausj;
import auvv;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import stj;
import uov;
import uow;
import uox;
import uoy;
import uoz;
import upa;
import upb;
import upc;
import upd;
import upe;
import upf;
import upg;
import uph;
import upi;
import upj;
import upk;
import wja;
import wvo;
import ydz;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final boolean aUi = AppSetting.enableTalkBack;
  private arhz A;
  public FormSwitchItem A;
  private arhz jdField_B_of_type_Arhz;
  private FormSwitchItem jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private Dialog C;
  TextView CG;
  public TextView CH;
  TextView CI;
  TextView CJ;
  private TextView CK;
  private TextView CL;
  public TextView CM;
  private String TAG = ChatSettingActivity.class.getSimpleName();
  accn jdField_a_of_type_Accn = new uox(this);
  acfd jdField_a_of_type_Acfd = new uow(this);
  private ackl jdField_a_of_type_Ackl = new uph(this);
  private aclh jdField_a_of_type_Aclh = new upi(this);
  private aclp jdField_a_of_type_Aclp = new uoy(this);
  private amfh jdField_a_of_type_Amfh = new upa(this);
  private auvv jdField_a_of_type_Auvv;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  public String aLY = "ChatSettingActivity.nearby";
  private String aLZ;
  private String aMa;
  private String aMb;
  private String aMc;
  private String aMd;
  private String aMe = "";
  private String aMf = "";
  private String aMg = "";
  private boolean aUj;
  private boolean aUk = true;
  private boolean aUl;
  private boolean aUm;
  MqqHandler b = new upk(this);
  private final int bFA = 3;
  private int bFB;
  private int bFC;
  private final int bFy = 1;
  private final int bFz = 2;
  private boolean bO;
  public RichStatus c;
  public ViewGroup cM;
  private WeakReference<aqdj> dG;
  private WeakReference<aqdj> dH;
  private Button da;
  private Button db;
  RelativeLayout gq;
  RelativeLayout gr;
  private RelativeLayout gs;
  private boolean isDestroy;
  private boolean isPause;
  private XListView m;
  TextView mC;
  private View mContentView;
  private int mCurType;
  private String mCurUin;
  private float mDensity;
  private Intent mIntent;
  public boolean mIsFollowed;
  private boolean mIsShield;
  achq mMsgObserver = new uoz(this);
  ImageView pH;
  private ImageView pI;
  private View rT;
  private View rU;
  public FormSimpleItem s;
  FormSimpleItem t;
  FormSimpleItem u;
  FormSimpleItem v;
  FormSimpleItem w;
  public FormSwitchItem w;
  FormSimpleItem x;
  public FormSwitchItem x;
  private FormSimpleItem y;
  public FormSwitchItem y;
  public FormSwitchItem z;
  
  private void Ad()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    switch (this.mCurType)
    {
    default: 
      bKr();
    }
    for (;;)
    {
      setTitle(2131691436);
      setLeftViewName(2131690700);
      setContentBackgroundResource(2130838900);
      return;
      bKp();
    }
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    } while (paramString == null);
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label152;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label152:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  private TextView a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null) || (!(paramView2 instanceof ViewGroup))) {
      return null;
    }
    TextView localTextView = (TextView)paramView1.findViewById(2131378811);
    if (localTextView == null) {
      return null;
    }
    ((ViewGroup)paramView1).removeView(localTextView);
    paramView1 = localTextView.getLayoutParams();
    if ((paramView1 instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)paramView1).setMargins(0, wja.dp2px(5.0F, getResources()), 0, 0);
    }
    ((ViewGroup)paramView2).addView(localTextView);
    return localTextView;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((acff)this.app.getManager(51)).a(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, a parama, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    arfj localarfj = new arfj(paramActivity, paramQQAppInterface, true);
    localarfj.a(new upd(parama, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localarfj.show(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.c = paramRichStatus;
    this.CM = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      amhj localamhj = (amhj)this.app.getManager(15);
      if (localamhj != null) {}
      for (paramRichStatus = localamhj.i(paramRichStatus.actionId, 200);; paramRichStatus = aqcu.decodeResource(getResources(), 2130850435))
      {
        paramRichStatus = new arjh(getResources(), paramRichStatus, false, false);
        int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, i, i);
        paramRichStatus = new argi(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void aFS()
  {
    this.mCurUin = this.mIntent.getStringExtra("uin");
    this.aLZ = this.mIntent.getStringExtra("uinname");
    if (this.aLZ == null) {
      this.aLZ = this.mCurUin;
    }
    this.mCurType = this.mIntent.getIntExtra("uintype", -1);
    this.mIsFollowed = this.mIntent.getBooleanExtra("follow_flag", false);
    if ((this.mCurType == 0) && (!hf(this.mCurUin))) {
      this.mCurType = 1003;
    }
    if ((1 == this.mCurType) || (1000 == this.mCurType) || (1004 == this.mCurType)) {
      this.aMa = this.mIntent.getStringExtra("troop_uin");
    }
    this.bFC = this.mIntent.getIntExtra("add_friend_source_id", 3999);
    this.aMb = this.mIntent.getStringExtra("real_troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
  }
  
  private void aL(int paramInt, String paramString)
  {
    if (this.isPause) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).show(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  private void addObserver()
  {
    addObserver(this.jdField_a_of_type_Acfd);
    addObserver(this.mMsgObserver);
    addObserver(this.jdField_a_of_type_Aclp);
    addObserver(this.jdField_a_of_type_Accn);
    addObserver(this.jdField_a_of_type_Ackl);
    addObserver(this.jdField_a_of_type_Aclh);
    this.app.setHandler(ChatSettingActivity.class, this.b);
    amhj localamhj = (amhj)this.app.getManager(15);
    if (localamhj != null) {
      localamhj.addListener(this.jdField_a_of_type_Amfh);
    }
  }
  
  private void bJ(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.aMc))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.C(this.mCurUin, paramIntent, false);
          this.bFB |= 0x1;
          vm(paramIntent);
          vp(getString(2131691366));
          this.jdField_A_of_type_Arhz.show();
          return;
        }
        cf(2131694914, 1);
        return;
      }
      cf(2131694895, 0);
      return;
    }
    cf(2131696346, 1);
  }
  
  private void bJs()
  {
    if ((this.jdField_B_of_type_Arhz != null) && (this.jdField_B_of_type_Arhz.isShowing())) {}
    try
    {
      this.jdField_B_of_type_Arhz.cancel();
      this.jdField_B_of_type_Arhz = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bK(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int i = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((acff)this.app.getManager(51)).a(String.valueOf(i));
    } while (paramIntent == null);
    vn(paramIntent.group_name);
  }
  
  private void bKA()
  {
    boolean bool = true;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.aUj);
    }
    do
    {
      return;
      bKB();
    } while (this.mCurType != 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      initHandler();
      return;
    }
    try
    {
      l = Long.parseLong(this.mCurUin);
      if (l > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.aUj)
        {
          localFriendListHandler.ai(l, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
        continue;
        bool = false;
      }
      aL(1, acfp.m(2131703730));
    }
  }
  
  private void bKB()
  {
    int j = 0;
    Object localObject = this.t;
    if (!this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked())
    {
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) || (this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked())) {
        break label67;
      }
    }
    label67:
    for (int i = j;; i = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      bKL();
      return;
      i = 8;
      break;
    }
  }
  
  private void bKC()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.mIsShield);
    }
    for (;;)
    {
      return;
      Object localObject1 = (aizg)this.app.getManager(16);
      if (localObject1 != null) {}
      try
      {
        l = Long.parseLong(this.aMe);
        if (l > 0L)
        {
          Object localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d(this.aLY, 2, "startStangerShield, tuin=" + l + ", mIsShield=" + this.mIsShield + ", mIsFollowed=" + this.mIsFollowed);
          }
          if (this.mIsShield)
          {
            ((aizg)localObject1).U(this.mCurType, (List)localObject2);
            this.aUl = true;
            QQAppInterface localQQAppInterface = this.app;
            if (!this.mIsShield) {
              break label515;
            }
            localObject2 = "cancel_aio";
            if (this.mCurType != 1001) {
              break label523;
            }
            str2 = "0";
            if (!this.mIsShield) {
              break label531;
            }
            localObject1 = "";
            anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
            if ((this.mCurType == 1001) || (this.mCurType == 10002) || (this.mCurType == 1003))
            {
              if (!this.mIsShield) {
                break label552;
              }
              if ((this.mCurUin != null) && (this.mCurUin.length() > 0))
              {
                this.app.a().Ek(this.mCurUin);
                this.aUl = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d(this.aLY, 2, "startStangerShield, mCurUin=" + this.mCurUin + ", mIsShield=" + this.mIsShield + ", mShieldByThis=" + this.aUl);
              }
            }
            if ((this.aUl) && (this.mCurType != 1010)) {
              continue;
            }
            if (!this.mIsShield) {
              break label591;
            }
            anot.a(this.app, "CliOper", "", this.aMe, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
          continue;
          if (this.mIsFollowed)
          {
            if (ChatActivityUtils.C.size() > 5) {
              ChatActivityUtils.C.poll();
            }
            ChatActivityUtils.C.offer(l + "");
          }
          ((aizg)localObject1).T(this.mCurType, localException);
          continue;
          aL(1, acfp.m(2131703773));
          continue;
          label515:
          String str1 = "block_aio";
          continue;
          label523:
          String str2 = "1";
          continue;
          label531:
          if (this.mIsFollowed)
          {
            localObject1 = "0";
          }
          else
          {
            localObject1 = "1";
            continue;
            label552:
            if ((this.mCurUin != null) && (this.mCurUin.length() > 0))
            {
              this.app.a().Ej(this.mCurUin);
              this.aUl = true;
            }
          }
        }
        label591:
        anot.a(this.app, "CliOper", "", this.aMe, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void bKD()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.aLY, 2, "refreshShieldButton, mCurType=" + this.mCurType + ", mIsShield=" + this.mIsShield);
    }
    if (this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.mIsShield);
      if (AppSetting.enableTalkBack) {
        this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691478));
      }
    }
    if ((this.mCurType == 1003) || (!this.aUk)) {
      if ((this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.rU != null))
      {
        this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.rU.setVisibility(8);
      }
    }
    while ((this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.rU == null)) {
      return;
    }
    this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.rU.setVisibility(0);
  }
  
  private void bKE()
  {
    int i;
    if ((1001 == this.mCurType) || (10002 == this.mCurType)) {
      if (this.mIsFollowed) {
        i = 2131698601;
      }
    }
    for (;;)
    {
      String str = getString(i);
      this.da.setText(str);
      this.da.setContentDescription(str);
      return;
      i = 2131698599;
      continue;
      i = 2131691474;
    }
  }
  
  private void bKF()
  {
    int i = 0;
    Object localObject = (acff)this.app.getManager(51);
    if ((localObject != null) && (!TextUtils.isEmpty(this.mCurUin))) {
      this.aUj = ((acff)localObject).ke(this.mCurUin);
    }
    if (this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.aUj);
      bKB();
      if (AppSetting.enableTalkBack) {
        this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691478));
      }
    }
    if (this.t == null) {
      return;
    }
    if (this.aUj)
    {
      this.t.setVisibility(8);
      localObject = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((!this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) && (!this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()))
      {
        i = 0;
        ((FormSwitchItem)localObject).setVisibility(i);
      }
    }
    for (;;)
    {
      label139:
      if (aUi)
      {
        return;
        i = 8;
        break;
        if (!this.app.getCurrentUin().equals(this.mCurUin))
        {
          this.t.setVisibility(0);
          localObject = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) || (this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked())) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      ((FormSwitchItem)localObject).setVisibility(i);
      break label139;
      break;
      label210:
      i = 8;
    }
  }
  
  private void bKG()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void bKH()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mCurUin, 46);
    localAllInOne.pa = 19;
    localAllInOne.nickname = aqgv.s(this.app, this.mCurUin);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.mCurUin))) {
      localAllInOne.nickname = this.aLZ;
    }
    localAllInOne.aOF = this.mCurUin;
    localAllInOne.bIX = this.mCurType;
    localAllInOne.bIZ = 5;
    localAllInOne.bJa = 61;
    Object localObject;
    switch (this.mCurType)
    {
    default: 
      localAllInOne.ae = stj.b(this.mCurUin, this.mCurType);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.ae }));
      }
      if ((this.mCurType != 1001) && (this.mCurType != 10002) && (this.mCurType != 10004) && (this.mCurType != 1010) && ((this.mCurType != 1022) || ((this.bFC != 3007) && (this.bFC != 2007) && (this.bFC != 4007) && (this.bFC != 3019) && (this.bFC != 2019)))) {
        break label690;
      }
      localObject = new Intent(this, NearbyPeopleProfileActivity.class);
      if (this.mCurType == 1001)
      {
        localAllInOne.bJa = 12;
        ((Intent)localObject).putExtra("frome_where", 21);
        label435:
        ((Intent)localObject).putExtra("AllInOne", localAllInOne);
        if (!aqft.equalsWithNullCheck(this.mCurUin, this.app.getCurrentAccountUin())) {
          break label678;
        }
        ((Intent)localObject).putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivityForResult((Intent)localObject, 3);
      return;
      localAllInOne.pa = 42;
      break;
      localAllInOne.pa = 86;
      break;
      localAllInOne.pa = 76;
      break;
      localAllInOne.pa = 22;
      localAllInOne.troopUin = this.aMf;
      break;
      localAllInOne.pa = 70;
      break;
      localAllInOne.pa = 47;
      localAllInOne.discussUin = this.aMf;
      break;
      localAllInOne.pa = 2;
      break;
      localAllInOne.pa = 34;
      break;
      localAllInOne.pa = 57;
      break;
      localAllInOne.pa = 72;
      break;
      localAllInOne.pa = 74;
      break;
      localAllInOne.pa = 27;
      break;
      localAllInOne.pa = 58;
      break;
      localAllInOne.pa = 96;
      break;
      localAllInOne.pa = 115;
      break;
      if (this.mCurType == 10002)
      {
        ((Intent)localObject).putExtra("frome_where", 22);
        break label435;
      }
      if (this.mCurType == 1010)
      {
        localAllInOne.bJa = 13;
        break label435;
      }
      localAllInOne.bJa = 30;
      break label435;
      label678:
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    label690:
    if ((this.mCurType == 1037) || (this.mCurType == 1044) || (this.mCurType == 1045))
    {
      ProfileActivity.a(this, localAllInOne, this.mIntent.getIntExtra("ExtendFriendLimitChatFromeType", 0), 3);
      return;
    }
    if (this.mIntent.hasExtra("param_wzry_data"))
    {
      localObject = this.mIntent.getSerializableExtra("param_wzry_data");
      if (localObject != null) {
        localAllInOne.data.putSerializable("param_wzry_data", (Serializable)localObject);
      }
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void bKI()
  {
    int i = 3999;
    int j = 0;
    Object localObject = null;
    switch (this.mCurType)
    {
    }
    while (i == 3007)
    {
      if (acgr.y(this.app, this.mCurUin)) {
        break label411;
      }
      bKM();
      return;
      i = 3004;
      j = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      i = 3007;
      j = 3;
      continue;
      i = 3043;
      j = 3;
      continue;
      i = 3071;
      j = 1;
      continue;
      i = 3003;
      continue;
      i = 3005;
      j = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      i = 3008;
      j = 12;
      continue;
      i = 3006;
      j = 12;
      continue;
      i = 3013;
      continue;
      i = 3008;
      j = 11;
      continue;
      i = 3003;
      j = 2;
      continue;
      i = 3041;
      j = 11;
      continue;
      i = 3019;
      continue;
      i = 3099;
      j = 1;
      continue;
      i = 3094;
      j = this.mIntent.getIntExtra("subId", 0);
      continue;
      i = 3072;
      j = 2;
      continue;
      i = 3080;
      j = 3;
    }
    if ((i == 3019) && (!afck.F(this.app, this.mCurUin)))
    {
      bKM();
      return;
    }
    label411:
    if ((this.mCurType == 3) || (this.mCurType == 4) || (this.mCurType == 4000) || (this.mCurType == 1006)) {}
    for (localObject = AddFriendLogicActivity.a(this, 2, this.aMg, null, i, j, this.aLZ, null, null, setLastActivityName(), null);; localObject = AddFriendLogicActivity.a(this, 1, this.mCurUin, (String)localObject, i, j, this.aLZ, null, null, setLastActivityName(), null))
    {
      if (i == 3094) {
        ((Intent)localObject).putExtra("entrance", 3);
      }
      if (localObject != null)
      {
        Serializable localSerializable = ydz.a(this, this.mCurType, false, false);
        if (localSerializable != null) {
          ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
        }
      }
      startActivity((Intent)localObject);
      return;
    }
  }
  
  private void bKJ()
  {
    if (TextUtils.equals(this.app.getCurrentAccountUin(), this.mCurUin)) {}
    for (int i = 0;; i = 1)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mCurUin, i);
      localAllInOne.nickname = aqgv.s(this.app, this.mCurUin);
      if (3000 != this.mCurType)
      {
        localAllInOne.aOF = this.mCurUin;
        localAllInOne.bIX = this.mCurType;
      }
      localAllInOne.bIZ = 5;
      localAllInOne.bJa = 61;
      localAllInOne.ae = stj.b(this.mCurUin, this.mCurType);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.ae }));
      }
      ProfileActivity.a(this, localAllInOne, 3);
      return;
    }
  }
  
  private void bKK()
  {
    ChatSettingActivity.14 local14 = new ChatSettingActivity.14(this);
    if (!this.isDestroy) {
      ThreadManager.post(local14, 8, null, true);
    }
  }
  
  private void bKN()
  {
    if (this.mCurType == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView != null) {
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.z(this.app, this.mCurUin, 2);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.setVisibility(8);
  }
  
  private void bKO()
  {
    boolean bool = FriendsStatusUtil.g(this.mCurUin, this.app);
    if (this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      bKL();
      this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.enableTalkBack) {
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131696084));
      }
    }
  }
  
  private void bKP()
  {
    boolean bool = wvo.b(this.mCurUin, this.app);
    FormSwitchItem localFormSwitchItem;
    if (this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      bKL();
      localFormSwitchItem = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) || (this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked())) {
        break label80;
      }
    }
    label80:
    for (int i = 0;; i = 8)
    {
      localFormSwitchItem.setVisibility(i);
      this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
  }
  
  private void bKp()
  {
    this.m = ((XListView)View.inflate(this, 2131559464, null));
    try
    {
      this.m.setBackgroundResource(2130838900);
      this.m.setDivider(null);
      this.m.setVerticalScrollBarEnabled(false);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.mContentView = View.inflate(this, 2131558936, null);
        this.m.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_Auvv = new auvv(this.mContentView);
        this.m.setAdapter(this.jdField_a_of_type_Auvv);
        super.setContentView(this.m);
        this.gq = ((RelativeLayout)this.mContentView.findViewById(2131367606));
        this.pH = ((ImageView)this.mContentView.findViewById(2131367605));
        this.mC = ((TextView)this.mContentView.findViewById(2131367607));
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.mContentView.findViewById(2131372138));
        this.gr = ((RelativeLayout)this.mContentView.findViewById(2131365528));
        this.s = ((FormSimpleItem)this.mContentView.findViewById(2131378439));
        this.v = ((FormSimpleItem)this.mContentView.findViewById(2131364478));
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131378080));
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.u = ((FormSimpleItem)this.mContentView.findViewById(2131362173));
        this.CI = ((TextView)this.mContentView.findViewById(2131365699));
        this.t = ((FormSimpleItem)this.mContentView.findViewById(2131378611));
        this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378086));
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378081));
        this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131378083));
        this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378082));
        this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378084));
        this.z = ((FormSwitchItem)this.mContentView.findViewById(2131378079));
        this.CG = ((TextView)this.mContentView.findViewById(2131364157));
        this.cM = ((ViewGroup)this.mContentView.findViewById(2131377533));
        this.CH = ((TextView)this.mContentView.findViewById(2131377534));
        this.mContentView.findViewById(2131365707).setOnClickListener(this);
        this.CI.setBackgroundResource(2130839682);
        this.mContentView.findViewById(2131377527).setOnClickListener(this);
        this.cM.setOnClickListener(this);
        this.gq.setOnClickListener(this);
        this.gr.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(FriendsStatusUtil.k(this.app, this.mCurUin, this.mCurType));
        this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.CI.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.CG.setOnClickListener(this);
        this.s.setOnClickListener(this);
        if (Build.VERSION.SDK_INT <= 25)
        {
          this.u.setVisibility(0);
          this.u.setOnClickListener(this);
          label642:
          if (AppSetting.enableTalkBack)
          {
            this.gq.setContentDescription(getString(2131694926));
            this.gr.setContentDescription(getString(2131689867));
            this.v.setContentDescription(getString(2131691414));
            this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719575));
            this.t.setContentDescription(getString(2131717467));
            this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131696477) + getString(2131719601));
            this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131696084));
            this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131698582));
            this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691479));
            this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131697336));
            this.z.setContentDescription(getString(2131697333));
            this.u.setContentDescription(getString(2131689817));
            this.CI.setContentDescription(getString(2131692515));
            this.CG.setContentDescription(getString(2131689648));
            this.s.setContentDescription(acfp.m(2131720346));
          }
          this.aMc = hc(this.mCurUin);
          if (this.aMc == null) {
            this.aMc = "";
          }
          vm(this.aMc);
          if (this.aMc != null) {
            this.mC.setText(this.aMc);
          }
          if (this.mCurUin != null)
          {
            localObject = aqdj.a(this.app, this.mCurUin, (byte)1);
            this.pH.setImageDrawable((Drawable)localObject);
          }
          this.aMd = hd(this.mCurUin);
          if (this.aMd == null) {
            this.aMd = "";
          }
          vn(this.aMd);
          bKy();
          if (!aqft.rj(this.mCurUin)) {
            break label1365;
          }
          this.gr.setVisibility(8);
          this.v.setVisibility(8);
          this.t.setVisibility(8);
          this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.u.setVisibility(8);
          this.CG.setVisibility(8);
          this.s.setVisibility(8);
          Object localObject = (LinearLayout.LayoutParams)this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this, 20.0F);
          this.jdField_w_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.z.setVisibility(0);
          localObject = ((acff)this.app.getManager(51)).c(acbn.blz);
          this.z.setChecked(((Card)localObject).babyQSwitch);
          this.z.setOnCheckedChangeListener(this);
          ((CardHandler)this.app.getBusinessHandler(2)).cHJ();
        }
        for (;;)
        {
          if (asgx.ag(this.app, this.mCurUin)) {
            this.gr.setVisibility(8);
          }
          if (this.app != null)
          {
            bKF();
            bKN();
            bKO();
          }
          bKP();
          if (this.app.getCurrentUin().equals(this.mCurUin))
          {
            this.t.setVisibility(8);
            this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.CI.setVisibility(8);
            this.CG.setVisibility(8);
            this.s.setVisibility(8);
            this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
          if (!hf(this.mCurUin)) {
            this.s.setVisibility(8);
          }
          bKq();
          return;
          localThrowable = localThrowable;
          QLog.i(this.TAG, 1, localThrowable.toString());
          break;
          this.u.setVisibility(8);
          break label642;
          label1365:
          this.z.setVisibility(8);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    }
  }
  
  private void bKq()
  {
    if (this.s == null) {}
    while (this.s.getVisibility() != 0) {
      return;
    }
    Object localObject = ((aenw)aeif.a().o(551)).a(4);
    FormSimpleItem localFormSimpleItem;
    if ((localObject != null) && (((aenw.a)localObject).bVh))
    {
      this.s.setVisibility(0);
      boolean bool = ((aohy)this.app.getManager(339)).e(4, 2, this.mCurUin);
      localFormSimpleItem = this.s;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!aoij.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false)) {
        break;
      }
      this.s.setRightIcon(getResources().getDrawable(2130842212));
      return;
      this.s.setVisibility(8);
      return;
    }
    this.s.setRightIcon(null);
  }
  
  private void bKr()
  {
    Object localObject1 = View.inflate(this, 2131558938, null);
    this.m = ((XListView)((View)localObject1).findViewById(2131365101));
    this.m.setPadding(0, 0, 0, 0);
    this.m.setDivider(null);
    this.m.setVerticalScrollBarEnabled(false);
    this.mContentView = View.inflate(this, 2131558937, null);
    this.jdField_a_of_type_Auvv = new auvv(this.mContentView);
    this.m.setAdapter(this.jdField_a_of_type_Auvv);
    super.setContentView((View)localObject1);
    this.rT = this.mContentView.findViewById(2131378808);
    this.gs = ((RelativeLayout)this.mContentView.findViewById(2131378810));
    this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131364663));
    this.pI = ((ImageView)this.mContentView.findViewById(2131378809));
    this.CK = ((TextView)this.mContentView.findViewById(2131378806));
    this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378085));
    this.da = ((Button)this.mContentView.findViewById(2131378807));
    this.db = ((Button)this.mContentView.findViewById(2131364010));
    this.db.setBackgroundResource(2130839682);
    int i;
    label472:
    label603:
    label745:
    String str;
    label523:
    label840:
    boolean bool;
    label912:
    label927:
    label1022:
    QQAppInterface localQQAppInterface;
    if (this.mCurType == 1036)
    {
      if (hf(this.mCurUin))
      {
        this.da.setVisibility(8);
        this.db.setVisibility(0);
        this.db.setOnClickListener(this);
        this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      if ((1001 == this.mCurType) || (10002 == this.mCurType)) {
        bKE();
      }
      if ((this.mCurType == 1037) || (this.mCurType == 1044) || (this.mCurType == 1045)) {
        this.CL = a((View)localObject1, this.mContentView);
      }
      if (this.CL == null) {
        this.CL = ((TextView)((View)localObject1).findViewById(2131378811));
      }
      if (AppSetting.enableTalkBack)
      {
        this.gs.setContentDescription(getString(2131694926));
        this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691475));
        this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131691479));
        localObject1 = this.da;
        if ((1001 != this.mCurType) && (10002 != this.mCurType)) {
          break label1341;
        }
        if (!this.mIsFollowed) {
          break label1334;
        }
        i = 2131698601;
        ((Button)localObject1).setContentDescription(getString(i));
        this.CL.setContentDescription(getString(2131689651));
      }
      if (this.mCurType != 10004) {
        break label1348;
      }
      this.gs.setContentDescription("");
      this.rT.setVisibility(8);
      this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.CL.setOnClickListener(this);
      if ((this.mCurType != 1006) || (this.mIntent == null) || (!this.mIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false))) {
        break label1359;
      }
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject1 = this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject1 != null) {
        ((Switch)localObject1).setEnabled(false);
      }
      this.da.setOnClickListener(this);
      this.CL.setOnClickListener(this);
      if ((this.mCurType != 1010) && (this.mCurType != 1001) && (this.mCurType != 10002) && ((this.mCurType != 1022) || ((this.bFC != 3007) && (this.bFC != 2007) && (this.bFC != 4007) && (this.bFC != 3019) && (this.bFC != 2019)))) {
        break label1386;
      }
      localObject1 = aqdj.a(this.app, 200, this.mCurUin, true);
      this.dG = new WeakReference(localObject1);
      this.pI.setImageDrawable((Drawable)localObject1);
      this.aMe = this.mCurUin;
      if ((this.mCurType == 1000) || (this.mCurType == 1004)) {
        this.aMf = this.mIntent.getStringExtra("troop_uin");
      }
      if ((this.mCurType == 1001) || (this.mCurType == 10002)) {
        break label1501;
      }
      if (this.mCurType == 1006)
      {
        this.aMg = this.mCurUin;
        if (!TextUtils.isEmpty(this.aMg)) {
          break label1456;
        }
        this.aUk = false;
      }
      localObject1 = (aizg)this.app.getManager(16);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.aMe))) {
        this.mIsShield = ((aizg)localObject1).nf(this.aMe);
      }
      if (QLog.isColorLevel())
      {
        str = this.aLY;
        localObject2 = new StringBuilder().append("initStrangerView, shieldMsgManger=");
        if (localObject1 != null) {
          break label1496;
        }
        bool = true;
        QLog.d(str, 2, bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.aLY, 2, "initStrangerView, curType=" + this.mCurType + ", mShieldUin=" + this.aMe + ", mIsShield=" + this.mIsShield + ", mShieldEnable=" + this.aUk);
      }
      if (!ga(this.mCurType)) {
        break label1604;
      }
      this.CL.setVisibility(0);
      this.CK.setText(this.aLZ);
      this.aUm = true;
      bKD();
      localObject1 = new String[1];
      localObject1[0] = this.mCurUin;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        initHandler();
      }
      if ((this.mCurType != 1010) && (this.mCurType != 1001) && (this.mCurType != 10002) && (this.mCurType != 10004) && ((this.mCurType != 1022) || ((this.bFC != 3007) && (this.bFC != 2007) && (this.bFC != 4007) && (this.bFC != 3019) && (this.bFC != 2019)))) {
        break label1616;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, true);
      label1174:
      if ((this.mCurType == 1001) || (this.mCurType == 10002))
      {
        localQQAppInterface = this.app;
        if (this.mCurType != 1001) {
          break label1628;
        }
        localObject1 = "0";
        label1214:
        if (!this.mIsFollowed) {
          break label1635;
        }
        str = "0";
        label1226:
        if (!this.mIsShield) {
          break label1643;
        }
      }
    }
    label1334:
    label1341:
    label1348:
    label1359:
    label1386:
    label1643:
    for (Object localObject2 = "0";; localObject2 = "1")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      if ((this.mCurType == 1037) || (this.mCurType == 1044) || (this.mCurType == 1045)) {
        this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
      this.jdField_y_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.da.setVisibility(0);
      this.db.setVisibility(8);
      break;
      i = 2131698599;
      break label472;
      i = 2131691474;
      break label472;
      this.gs.setOnClickListener(this);
      break label523;
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label603;
      if (this.mCurType == 1006)
      {
        localObject1 = aqdj.b(this.app, this.mCurUin, (byte)1);
        this.pI.setImageDrawable((Drawable)localObject1);
        break label745;
      }
      localObject1 = aqdj.a(this.app, 1, this.mCurUin);
      this.dG = new WeakReference(localObject1);
      this.pI.setImageDrawable((Drawable)localObject1);
      break label745;
      localObject1 = aqgv.x(this.app, this.aMg);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.aUk = false;
        break label840;
      }
      this.aUk = true;
      this.aMe = ((String)localObject1);
      break label840;
      bool = false;
      break label912;
      localObject1 = ((acff)this.app.getManager(51)).e(this.aMe);
      if (QLog.isColorLevel())
      {
        str = this.aLY;
        localObject2 = new StringBuilder().append("initStrangerView, f=");
        if (localObject1 != null) {
          break label1591;
        }
      }
      for (bool = true;; bool = false)
      {
        QLog.d(str, 2, bool);
        if ((localObject1 == null) || (((Friends)localObject1).groupid != -1002)) {
          break label1596;
        }
        this.mIsShield = true;
        break;
      }
      this.mIsShield = false;
      break label927;
      this.CL.setVisibility(8);
      break label1022;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, false);
      break label1174;
      localObject1 = "1";
      break label1214;
      str = "1";
      break label1226;
    }
  }
  
  private void bKs()
  {
    switch (this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0))
    {
    default: 
      return;
    case 5: 
      getResources().getString(2131717266);
      return;
    case 4: 
      getResources().getString(2131717264);
      return;
    case 3: 
      getResources().getString(2131717265);
      return;
    case 2: 
      getResources().getString(2131717267);
      return;
    }
    getResources().getString(2131717284);
  }
  
  private void bKt()
  {
    aqha.a(this, 230).setMessage(acfp.m(2131703736)).setPositiveButton(17039370, new upg(this)).setNegativeButton(17039360, new upf(this)).show();
  }
  
  private void bKu()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mCurUin);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_entrance", 29);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    startActivityForResult(localIntent, 2);
  }
  
  private void bKv()
  {
    ChatHistoryActivity.a(this, this.mCurUin, this.mCurType, this.aLZ, 1001);
  }
  
  private void bKw()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.mCurUin);
    localIntent.putExtra("uintype", this.mCurType);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.o(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void bKx()
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.mCurUin);
    localIntent.putExtra("uinname", this.aLZ);
    localIntent.putExtra("uintype", this.mCurType);
    localIntent.putExtra("isNeedUpdate", this.bO);
    startActivity(localIntent);
  }
  
  private void bKy()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!abbf.e(this.mCurUin, this.app)))
    {
      localObject = getResources().getDrawable(2130851403);
      this.t.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130851400);
    getResources().getDrawable(2130839512);
    this.t.setRightIcon((Drawable)localObject);
  }
  
  private void bKz()
  {
    ChatSettingActivity.7 local7 = new ChatSettingActivity.7(this, new StringBuilder());
    if (!this.isDestroy)
    {
      ThreadManager.post(local7, 8, null, true);
      aL(2, getString(2131690297));
    }
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  private void ci(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  private boolean ga(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private String hc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = (acff)this.app.getManager(51);
    } while (localObject == null);
    Friends localFriends = ((acff)localObject).e(paramString);
    if (localFriends != null) {
      if (localFriends.remark != null)
      {
        paramString = localFriends.remark;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (TextUtils.isEmpty(localFriends.name)) {}
        }
      }
    }
    for (Object localObject = localFriends.name;; localObject = null)
    {
      return localObject;
      paramString = null;
      break;
    }
  }
  
  private String hd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    acff localacff = (acff)this.app.getManager(51);
    paramString = localacff.e(paramString);
    if (paramString != null)
    {
      paramString = localacff.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private boolean hf(String paramString)
  {
    return ((acff)this.app.getManager(51)).isFriend(paramString);
  }
  
  private void initHandler()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
  }
  
  private void preloadWebProcess()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.aFT());
      localWebProcessManager.egu();
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "start preloadWebProcess");
  }
  
  private void removeObserver()
  {
    removeObserver(this.jdField_a_of_type_Acfd);
    removeObserver(this.mMsgObserver);
    removeObserver(this.jdField_a_of_type_Aclp);
    removeObserver(this.jdField_a_of_type_Accn);
    removeObserver(this.jdField_a_of_type_Ackl);
    removeObserver(this.jdField_a_of_type_Aclh);
    this.app.removeHandler(ChatSettingActivity.class);
    amhj localamhj = (amhj)this.app.getManager(15);
    if (localamhj != null)
    {
      localamhj.removeListener(this.jdField_a_of_type_Amfh);
      return;
    }
    this.jdField_a_of_type_Amfh = null;
  }
  
  private void vj(String paramString)
  {
    Object localObject = this.app.b().k(this.mCurUin, this.mCurType);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.b().N(this.mCurUin, this.mCurType);
        this.app.b().cc(this.mCurUin, this.mCurType);
        this.app.a().eE(this.mCurUin, this.mCurType);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.a().F(this.mCurUin, this.mCurType, l1);
          }
          paramString = this.app.getHandler(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.mCurUin;
          ((Message)localObject).arg1 = this.mCurType;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void vm(String paramString)
  {
    if (this.mC != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.mC.setText(paramString);
      }
    }
    else {
      return;
    }
    paramString = aqgv.s(this.app, this.mCurUin);
    this.mC.setText(paramString);
  }
  
  private void vn(String paramString)
  {
    if ((this.CJ != null) && (paramString != null)) {
      this.CJ.setText(paramString);
    }
  }
  
  private void vo(String paramString)
  {
    ausj localausj = ausj.b(this);
    if (aqft.rj(paramString)) {
      localausj.setMainTitle(2131690834);
    }
    for (;;)
    {
      localausj.addButton(2131692515, 3);
      localausj.addCancelButton(2131721058);
      localausj.a(new upj(this, paramString, localausj));
      localausj.show();
      return;
      if (ajnn.c(this.app, this.mCurUin, true)) {
        localausj.setMainTitle(2131690836);
      } else {
        localausj.setMainTitle(2131690835);
      }
    }
  }
  
  private void vp(String paramString)
  {
    this.jdField_A_of_type_Arhz = new arhz(this, getTitleBarHeight());
    this.jdField_A_of_type_Arhz.setContentView(2131562991);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_A_of_type_Arhz.setMessage(getString(2131719519));
      return;
    }
    this.jdField_A_of_type_Arhz.setMessage(paramString);
  }
  
  public void bKL()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_x_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if ((!this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) && (!this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) && (!this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked())) {}
    for (int i = 0;; i = 8)
    {
      localFormSimpleItem.setVisibility(i);
      return;
    }
  }
  
  public void bKM()
  {
    if (this.C == null) {
      this.C = acgr.a(this, getString(2131696214), new upb(this), new upc(this));
    }
    if ((this.C != null) && (!this.C.isShowing())) {
      this.C.show();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.isPause = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      return;
      bKx();
      finish();
      return;
      bJ(paramIntent);
      return;
      bK(paramIntent);
      return;
      switch (paramIntent.getIntExtra("param_subtype", -1))
      {
      default: 
        return;
      case 0: 
        anot.a(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        apuh.f(this, paramIntent.getStringExtra("roomId"), true);
        return;
      }
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", aqgv.b(this.app, getApplicationContext(), paramIntent));
      localIntent.putExtra("isBack2Root", true);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mIntent = getIntent();
    initHandler();
    addObserver();
    aFS();
    Ad();
    preloadWebProcess();
    anot.a(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.isDestroy = true;
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
    try
    {
      if ((this.jdField_A_of_type_Arhz != null) && (this.jdField_A_of_type_Arhz.isShowing()) && (!isFinishing()))
      {
        this.jdField_A_of_type_Arhz.dismiss();
        this.jdField_A_of_type_Arhz = null;
      }
      if ((this.C != null) && (this.C.isShowing()))
      {
        this.C.dismiss();
        this.C = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aqdj localaqdj;
        localThrowable.printStackTrace();
      }
    }
    if (this.dG != null)
    {
      localaqdj = (aqdj)this.dG.get();
      if (localaqdj != null) {
        localaqdj.cancel();
      }
    }
    if (this.dH != null)
    {
      localaqdj = (aqdj)this.dH.get();
      if (localaqdj != null) {
        localaqdj.cancel();
      }
    }
    removeObserver();
    this.aUm = false;
  }
  
  public void doOnPause()
  {
    this.isPause = true;
    bKG();
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    this.isPause = false;
    if (this.b != null)
    {
      if (this.aUm)
      {
        this.b.removeMessages(32);
        this.b.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.mCurType == 0)
      {
        this.b.removeMessages(33);
        this.b.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    ApngImage.playByTag(27);
    if (this.t != null)
    {
      str = getString(2131717467);
      SpecialCareInfo localSpecialCareInfo = ((acff)this.app.getManager(51)).a(this.mCurUin);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label254;
      }
      this.t.setRightText(getString(2131719368));
    }
    for (String str = str + getString(2131719368);; str = str + getString(2131719369))
    {
      this.t.setContentDescription(str);
      if ((this.mCurType == 0) && (this.b != null) && (!this.b.hasMessages(34)))
      {
        int i = ajol.Gw();
        this.b.sendEmptyMessageDelayed(34, i * 1000);
      }
      if (this.cM != null)
      {
        this.cM.setVisibility(8);
        ((acle)this.app.getBusinessHandler(13)).cMl();
      }
      bKq();
      return;
      label254:
      this.t.setRightText(getString(2131719369));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.mCurType == 0) && (this.v != null))
    {
      bKs();
      ((aqrb)this.app.getBusinessHandler(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void finish()
  {
    if ((1001 == this.mCurType) || (10002 == this.mCurType))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("follow_flag", this.mIsFollowed);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.z != null) && (paramCompoundButton == this.z.a())) {
      if (aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ((CardHandler)this.app.getBusinessHandler(2)).EC(paramBoolean);
        localObject = this.app;
        if (paramBoolean)
        {
          i = 1;
          anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(i), "", "", "");
        }
      }
    }
    boolean bool;
    label289:
    label347:
    label738:
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
          i = 0;
          break;
          cf(2131693404, 1);
          this.z.setOnCheckedChangeListener(null);
          localObject = this.z;
          if (!paramBoolean) {}
          for (bool = true;; bool = false)
          {
            ((FormSwitchItem)localObject).setChecked(bool);
            this.z.setOnCheckedChangeListener(this);
            break;
          }
          if ((this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_B_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton)) {
            break label289;
          }
        } while (this.mIsShield == paramBoolean);
        if (paramBoolean) {
          anot.a(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.aLY, 2, "onCheckedChanged, isCheck=" + paramBoolean);
          }
          bKC();
          break;
          anot.a(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
        }
        if ((this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
        {
          if (!FriendsStatusUtil.a(this.app, paramBoolean, this.mCurUin, this.mCurType))
          {
            this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
            localObject = this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if (!paramBoolean)
            {
              bool = true;
              ((FormSwitchItem)localObject).setChecked(bool);
              this.jdField_A_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              QQToast.a(this, 1, acfp.m(2131703742), 0).show(getTitleBarHeight());
            }
          }
          else
          {
            localObject = this.app;
            if (!paramBoolean) {
              break label433;
            }
          }
          for (i = 1;; i = 2)
          {
            anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
            break;
            bool = false;
            break label347;
          }
        }
        if ((this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton)) {
          break label592;
        }
        localObject = this.app;
        if (!paramBoolean) {
          break label552;
        }
        i = 1;
        anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, i, "0", "0", "", "");
      } while (this.aUj == paramBoolean);
      if (this.aUj) {
        anot.a(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
      }
      for (;;)
      {
        bKA();
        break;
        i = 2;
        break label468;
        anot.a(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
      }
      if ((this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
      {
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          cf(2131693404, 1);
          this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          localObject = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if (!paramCompoundButton.isChecked()) {}
          for (bool = true;; bool = false)
          {
            ((FormSwitchItem)localObject).setChecked(bool);
            this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
        }
        localObject = this.app;
        str = this.mCurUin;
        i = this.mCurType;
        long l;
        if (paramCompoundButton.isChecked())
        {
          l = anaz.gQ();
          FriendsStatusUtil.b((QQAppInterface)localObject, str, i, l, true, false);
          bKL();
          localObject = this.app;
          if (!paramCompoundButton.isChecked()) {
            break label808;
          }
        }
        for (i = 1;; i = 2)
        {
          anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, i, "0", "0", "", "");
          break;
          l = 0L;
          break label738;
        }
      }
    } while ((this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton));
    label433:
    label468:
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      cf(2131693404, 1);
      this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramCompoundButton.isChecked()) {}
      for (bool = true;; bool = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool);
        this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        break;
      }
    }
    label552:
    label592:
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "mHiddenChat switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
    }
    label808:
    if (paramBoolean) {
      acqe.a(this.app).bO(this);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    String str = this.mCurUin;
    int i = this.mCurType;
    ((FriendListHandler)localObject).a(new String[] { str }, new boolean[] { paramBoolean }, new int[] { i });
    bKL();
    localObject = this.jdField_w_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if ((!this.jdField_x_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()) && (!this.jdField_y_of_type_ComTencentMobileqqWidgetFormSwitchItem.isChecked()))
    {
      i = 0;
      label1022:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.app;
      if (!paramBoolean) {
        break label1079;
      }
    }
    label1079:
    for (i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800A348", "0X800A348", 1, i, "0", "0", "", "");
      break;
      i = 8;
      break label1022;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131382021: 
    default: 
    case 2131365528: 
    case 2131364478: 
    case 2131378080: 
    case 2131362173: 
    case 2131364663: 
    case 2131378811: 
    case 2131365707: 
    case 2131378810: 
    case 2131378807: 
    case 2131367606: 
    case 2131364010: 
    case 2131365699: 
    case 2131378611: 
    case 2131378083: 
    case 2131377533: 
    case 2131377527: 
    case 2131364157: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bKu();
        anot.a(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
        anot.a(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
        continue;
        bKv();
        anot.a(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
        anot.a(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
        continue;
        bKw();
        anot.a(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
        continue;
        bKK();
        anot.a(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
        continue;
        bKz();
        anot.a(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
        if (ga(this.mCurType))
        {
          stj.a(this, this.mCurType, this.mCurUin, this.app.getCurrentAccountUin(), this.aMb);
          continue;
          anot.a(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
          a(this.app, this, this.mCurUin, this.mCurType, new uov(this), 2);
          continue;
          bKH();
          continue;
          if ((1001 == this.mCurType) || (10002 == this.mCurType))
          {
            label586:
            Object localObject3;
            Object localObject4;
            if (this.mIsFollowed)
            {
              localObject1 = "2";
              localObject3 = this.app;
              localObject4 = this.mCurUin;
              if (this.mCurType != 1001) {
                break label757;
              }
              localObject2 = "2";
              label613:
              if (this.mCurType != 1001) {
                break label765;
              }
              label623:
              acig.a((QQAppInterface)localObject3, (String)localObject4, (String)localObject2, (String)localObject1, 3, new upe(this, (String)localObject1));
              aizg localaizg = (aizg)this.app.getManager(16);
              localObject4 = this.app;
              if (!"1".equals(localObject1)) {
                break label768;
              }
              localObject2 = "follow_aio";
              label678:
              if (this.mCurType != 1001) {
                break label776;
              }
              localObject3 = "0";
              label693:
              if (!"1".equals(localObject1)) {
                break label791;
              }
              if (!localaizg.nf(this.mCurUin)) {
                break label784;
              }
              localObject1 = "1";
            }
            for (;;)
            {
              anot.a((QQAppInterface)localObject4, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, (String)localObject3, "1", (String)localObject1, "");
              break;
              localObject1 = "1";
              break label586;
              label757:
              localObject2 = "1";
              break label613;
              label765:
              break label623;
              label768:
              localObject2 = "unfollow_aio";
              break label678;
              label776:
              localObject3 = "1";
              break label693;
              label784:
              localObject1 = "0";
              continue;
              label791:
              localObject1 = "";
            }
          }
          if ((1036 == this.mCurType) && (this.mIsShield))
          {
            bKt();
          }
          else
          {
            bKI();
            anot.a(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
            continue;
            bKJ();
            continue;
            vo(this.mCurUin);
            if (aqft.rj(this.mCurUin)) {
              anot.a(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
            }
            anot.a(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
            continue;
            localObject1 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
            ((SharedPreferences)localObject1).edit().putBoolean("special_care_chat_setting", false).commit();
            if (((SharedPreferences)localObject1).getBoolean("special_care_red_point_one", false)) {
              ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", false).commit();
            }
            this.t.setRightIcon(null);
            abby.m(this, this.mCurUin, 2);
            anot.a(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
            continue;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("uin", this.mCurUin);
            ((Intent)localObject1).putExtra("uintype", this.mCurType);
            MessageNotificationSettingFragment.launch(this, (Intent)localObject1);
            continue;
            localObject1 = (GetRoamToastRsp)this.cM.getTag();
            if (localObject1 != null)
            {
              anot.a(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
              localObject2 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", ((GetRoamToastRsp)localObject1).sUrl);
              ((Intent)localObject2).putExtra("isShowAd", false);
              startActivity((Intent)localObject2);
              continue;
              localObject1 = (GetRoamToastRsp)this.cM.getTag();
              if (localObject1 != null)
              {
                anot.a(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
                ((acle)this.app.getBusinessHandler(13)).a((GetRoamToastRsp)localObject1);
              }
              this.cM.setVisibility(8);
              continue;
              if (this.mCurType == 10008) {
                anot.a(this.app, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
              }
              stj.a(this, this.mCurType, this.mCurUin, this.app.getCurrentAccountUin());
            }
          }
        }
      }
    }
    anot.a(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.mCurUin, "", "", "");
    Object localObject1 = (aohy)this.app.getManager(339);
    boolean bool = ((aohy)localObject1).e(4, 2, this.mCurUin);
    Object localObject2 = aoij.a(bool, 5);
    if (bool) {
      ((aohy)localObject1).b(this, this.mCurUin, 2, 4, 5, (Bundle)localObject2);
    }
    for (;;)
    {
      aoij.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
      bKq();
      break;
      ((aohy)localObject1).a(this, this.mCurUin, 2, 4, 5, (Bundle)localObject2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bt(Activity paramActivity);
    
    public abstract void h(QQAppInterface paramQQAppInterface, int paramInt);
    
    public abstract void i(QQAppInterface paramQQAppInterface, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */