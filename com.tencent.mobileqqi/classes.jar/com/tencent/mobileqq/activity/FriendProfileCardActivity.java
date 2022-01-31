package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import ctf;
import cti;
import ctj;
import ctk;
import ctl;
import ctm;
import ctn;
import cto;
import ctp;
import ctq;
import ctr;
import cts;
import ctt;
import ctu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.TicketManager;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements Handler.Callback, BounceScrollView.MotionEventInterceptor, Observer
{
  public static final int a = 20;
  public static long a = 0L;
  public static final int b = 5;
  private static final int bA = 3;
  private static final int bB = 4;
  private static final int bC = 6;
  private static final int bD = 7;
  private static final int bE = 8;
  private static final int bF = 9;
  private static final int bG = 10;
  private static final int bH = 5;
  private static final int bJ = 1;
  private static final int bK = 2;
  private static final int bL = 4;
  private static final int bM = 5;
  private static final int bN = 6;
  private static final int bn = 1;
  private static final int bp = 0;
  private static final int bq = 1;
  private static final int br = 2;
  private static final int bs = 3;
  private static final int bt = 4;
  private static final int bu = 5;
  private static final int bv = 6;
  private static final int bw = 7;
  private static final int bx = 8;
  private static final int by = 1;
  private static final int bz = 2;
  private static final String cl = "FriendProfileCardActivity";
  private static boolean h = false;
  private long M = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ctp(this);
  public Uri a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cti(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new ctu(this);
  public View a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ctm(this);
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.CardContactInfo a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ctf(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ctn(this);
  public ProfileCardInfo a;
  private ProfileCardTemplate jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
  public ProfileHeaderView a;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ctl(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public ProfileCardMoreInfoView a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public View b;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  private int bI = 0;
  private int bo = 0;
  public int c;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  long d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_a_of_type_AndroidOsHandler = new ctj(this);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramInt == 0) {
        i = 8;
      }
      ((LinearLayout)localObject).setVisibility(i);
      while (paramInt < j)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        paramInt += 1;
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 9, 2131562005, 2130838996, 2131558430);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131563190, 2130838993, 2131558429);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131561795, 2130838999, 2131558428);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131561607, 2130838990, 2131558427);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131561795, 2130838999, 2131558428);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131563190, 2130838993, 2131558429);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131561795, 2130838999, 2131558428);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131561607, 2130838990, 2131558427);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, 2131563190, 2130838993, 2131558429);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131561607, 2130838990, 2131558427);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 8, 2131561795, 2130838999, 2131558428);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131563190, 2130838993, 2131558429);
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.bI);
    }
    if (this.bI > 5) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    } while (localCardHandler == null);
    this.bI += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int i = 12;
        byte b1 = 0;
        long l3 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        long l2;
        long l1;
        switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 23: 
        case 24: 
        case 28: 
        case 29: 
        case 33: 
        case 37: 
        case 38: 
        case 39: 
        case 43: 
        case 44: 
        case 45: 
        case 48: 
        case 49: 
        case 53: 
        case 54: 
        case 59: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        default: 
          return;
        case 0: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 60: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 1: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 40: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 41: 
          i = 6;
          paramArrayOfByte1 = "";
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
          {
            i = 37;
            paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
          }
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2);
          return;
        case 42: 
        case 73: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 36: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, c(), l3, 3014, arrayOfByte2);
          return;
        case 30: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 31: 
        case 32: 
        case 34: 
        case 50: 
        case 51: 
          i = 16;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
            i = 17;
          }
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0", i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, c(), l3, 10004, null);
          return;
        case 46: 
        case 47: 
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString == null) {
            break;
          }
          l2 = 0L;
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString).longValue();
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
            {
              i = 4;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
            }
          }
          catch (NullPointerException paramArrayOfByte1)
          {
            for (;;)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                l1 = l2;
                continue;
                i = 14;
              }
            }
          }
        case 20: 
        case 21: 
        case 22: 
        case 58: 
          l1 = ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
          {
            i = 2;
            b1 = 1;
          }
          for (;;)
          {
            localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
            return;
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
            {
              i = 5;
              b1 = 0;
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22)
            {
              i = 7;
              b1 = 0;
            }
          }
        case 3: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 2: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 74: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 35: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2);
          return;
        case 75: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2);
          return;
        case 61: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 70: 
          localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 25: 
        case 26: 
        case 27: 
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int == 2004)) {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b)) {}
          }
        case 4: 
        case 52: 
        case 19: 
        case 55: 
        case 56: 
        case 57: 
        case 72: 
        case 71: 
          label2065:
          label2073:
          for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramArrayOfByte1 = "0")
          {
            paramArrayOfByte2 = paramArrayOfByte1;
            if (paramArrayOfByte1 == null) {}
            for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
            {
              for (;;)
              {
                l2 = 0L;
                try
                {
                  l1 = Long.parseLong(paramArrayOfByte2);
                  i = 11;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                    i = 35;
                  }
                  localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int, arrayOfByte2);
                  return;
                  if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
                    break label2073;
                  }
                  paramArrayOfByte1 = (TroopInfo)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c });
                  if (paramArrayOfByte1 == null) {
                    break label2073;
                  }
                  paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                  break;
                  if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int != 2005)) {
                    break label2065;
                  }
                  paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
                }
                catch (Exception paramArrayOfByte1)
                {
                  for (;;)
                  {
                    l1 = l2;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                      l1 = l2;
                    }
                  }
                }
              }
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
            }
          }
          arrayOfByte2 = paramArrayOfByte2;
        }
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.putExtra("qzone_uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    paramIntent.putExtra("nickname", str1);
    paramIntent.putExtra("sid", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (paramView != null))
    {
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233043);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if ((localObject != null) && (((Animatable)localObject).isRunning())) {
          ((Animatable)localObject).stop();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          int i;
          localException.printStackTrace();
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
        this.f = true;
      }
      j = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).d();
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      DataTag localDataTag = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131233038);
      paramView.setText(paramInt2);
      paramView.setContentDescription(getString(paramInt4));
      paramView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      if ((!a(paramInt1)) || (this.g)) {
        break label117;
      }
      paramView.setTextColor(getResources().getColor(2131362097));
    }
    for (;;)
    {
      paramView.setEnabled(this.g);
      return;
      label117:
      paramView.setTextColor(getResources().getColor(2131362095));
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    int i = getResources().getColor(2131362036);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33)
    {
      View localView = View.inflate(this, 2130903601, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams.weight = 1.0F;
      paramLinearLayout.addView(localView, localLayoutParams);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        localView = new View(this);
        localView.setBackgroundColor(i);
        paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
        localView = View.inflate(this, 2130903683, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams.weight = 1.0F;
        paramLinearLayout.addView(localView, localLayoutParams);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        localView = new View(this);
        localView.setBackgroundColor(i);
        paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
        localView = View.inflate(this, 2130903601, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams.weight = 1.0F;
        paramLinearLayout.addView(localView, localLayoutParams);
        localView = new View(this);
        localView.setBackgroundColor(i);
        paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(1, -1));
        localView = View.inflate(this, 2130903601, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams.weight = 1.0F;
        paramLinearLayout.addView(localView, localLayoutParams);
      }
    }
  }
  
  private void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initContentView");
    }
    b(paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    m();
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.l;
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
        break label667;
      }
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b)) {
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte);
        }
      }
      paramString = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (paramString != null)
      {
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (paramString.cSpecialFlag == 1)) {
          localIntent.setClass(a(), ChatForEnterpriseActivity.class);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 101)) {
        break label705;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      startActivityForResult(localIntent, 1010);
      return;
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      if ((paramInt == 1021) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])))
      {
        localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2]);
        break;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_JavaLangString;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break;
      label667:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
      }
    }
    label705:
    startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    PhoneContactManager localPhoneContactManager;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localPhoneContactManager = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localPhoneContactManager != null) {
          break label199;
        }
      }
    }
    return;
    label199:
    PhoneContact localPhoneContact;
    Object localObject;
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localPhoneContact = localPhoneContactManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = localPhoneContact;
      if (paramBoolean) {
        break label571;
      }
      localObject = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      if ((!((FriendListHandler)localObject).a()) && (!((FriendListHandler)localObject).b())) {
        ((FriendListHandler)localObject).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      localObject = localPhoneContact;
    }
    label571:
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject).name, ((PhoneContact)localObject).mobileCode, ((PhoneContact)localObject).nationCode));
        return;
        localPhoneContact = localPhoneContactManager.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject = localPhoneContact;
        if (localPhoneContact == null)
        {
          localPhoneContact = localPhoneContactManager.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject = localPhoneContact;
          if (localPhoneContact != null)
          {
            localObject = localPhoneContact;
            if (!TextUtils.isEmpty(localPhoneContact.nationCode))
            {
              localObject = localPhoneContact;
              if (!TextUtils.isEmpty(localPhoneContact.mobileCode))
              {
                this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = (localPhoneContact.nationCode + localPhoneContact.mobileCode);
                localObject = localPhoneContact;
              }
            }
          }
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label517;
        }
        bool1 = true;
        label113:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label522;
        }
        bool2 = true;
        label170:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (TextUtils.isEmpty(paramCard.strTroopNick)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1], paramCard.strTroopNick))) {
          break label528;
        }
        paramBoolean = true;
        label227:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1] = paramCard.strTroopNick;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label277:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label538;
          }
        }
      }
      label517:
      label522:
      label528:
      label538:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]).append(", strRemark = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4]).append(", strContactName = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3]).append(", strCircleName = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2]).append(", strRecommenName = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5]).append(", strTroopNickName = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1]).append(", strAutoRemark = ").append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6]);
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label113;
        bool2 = false;
        break label170;
        paramBoolean = false;
        break label227;
        bool1 = false;
        break label277;
      }
      bool2 = false;
    }
  }
  
  private boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
        return paramBoolean;
        paramBoolean = false;
        break;
      }
      return paramBoolean;
      paramBoolean = false;
    }
  }
  
  private boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      Long.parseLong(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f);
        }
      }
      for (;;)
      {
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramProfileCardInfo) {}
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 7)
    {
      onBackPressed();
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int, -1);
  }
  
  private void b(Intent paramIntent)
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo)
  {
    for (;;)
    {
      long l;
      int i;
      try
      {
        boolean bool = this.f;
        if (bool == true) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView");
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label423;
        }
        l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentTemplateId;
        i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView user currentTemplateId=" + l + ",templateRet=" + i);
        }
        if ((l < 0L) && (NetworkUtil.f(this)))
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "get card add timeout msg");
          }
          paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramProfileCardInfo, 10000L);
          continue;
        }
        if (0 == 0) {
          break label170;
        }
      }
      finally {}
      if (i != 0)
      {
        label170:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView cardTemplate is null reset headerView");
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
        s();
      }
      else if (ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null, true))
      {
        if (QLog.isColorLevel())
        {
          new StringBuilder().append("create headerView and cardTemplate=");
          throw new NullPointerException();
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
            break label392;
          }
          l = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a;
          throw new NullPointerException();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView Exception msg=" + localException.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
          s();
        }
        continue;
        label392:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        d();
      }
      else
      {
        a(null);
        continue;
        label423:
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by contactCard");
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
          s();
        }
        else if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_c_of_type_AndroidViewView);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView);
          s();
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    int j = 1;
    label44:
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562665);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f != 6) {
        break label141;
      }
      k();
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ctq(this));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label158;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramString = new DataTag(16, null);
        this.jdField_c_of_type_AndroidWidgetTextView.setTag(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.g);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131562666);
        break;
        label141:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561692));
        break label44;
        label158:
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) {
          break label700;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 70)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        i = j;
        if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58)) {
          break label700;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
          break label700;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
          break label700;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) {
          break label700;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
        {
          i = j;
          if (!TextUtils.isEmpty(d())) {
            continue;
          }
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2)
        {
          i = 0;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74)
        {
          i = 0;
          continue;
        }
        if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          i = 0;
          continue;
        }
        i = 0;
        continue;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label700:
      i = 0;
    }
  }
  
  private String d()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c());
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      a(1);
      return;
    }
    boolean bool1 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool2 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((bool1) && (bool2) && (bool3))
    {
      a(2);
      return;
    }
    if ((bool1) && (bool2))
    {
      a(3);
      return;
    }
    if ((bool2) && (bool3))
    {
      a(4);
      return;
    }
    if ((bool1) && (bool3))
    {
      a(5);
      return;
    }
    if (bool1)
    {
      a(6);
      return;
    }
    if (bool2)
    {
      a(7);
      return;
    }
    if (bool3)
    {
      a(5);
      return;
    }
    a(0);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
    int i = ((Resources)localObject1).getDimensionPixelSize(2131427376);
    this.jdField_c_of_type_Int = (((Resources)localObject1).getDimensionPixelSize(2131427495) - i - (int)(((DisplayMetrics)localObject2).density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    localObject1 = View.inflate(this, 2130903611, null);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject1).findViewById(2131233074);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)((View)localObject1).findViewById(2131231313));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.f = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new ctr(this));
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1).findViewById(2131233077);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131231456));
    this.jdField_c_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setId(2131231380);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131562408);
    this.jdField_b_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131231376);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903603, null);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131233042));
      localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233043);
      if (localObject2 != null) {}
      try
      {
        localObject2 = (Animatable)((ImageView)localObject2).getDrawable();
        if (!((Animatable)localObject2).isRunning()) {
          ((Animatable)localObject2).start();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233044));
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject1).findViewById(2131233075));
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33)
        {
          localObject2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
          if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
          }
        }
        else
        {
          q();
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.addView(this.jdField_a_of_type_AndroidViewView);
          setContentView((View)localObject1);
          getWindow().setBackgroundDrawable(null);
          c(null);
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = localException.a(c());
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard, false);
        }
      }
    }
  }
  
  private void o()
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_c_of_type_Long, l))
    {
      this.jdField_c_of_type_Long = l;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 40) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41)) {
        break label258;
      }
      localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label363;
      }
      localObject = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s", new Object[] { this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), Integer.valueOf(0), localObject });
      label112:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label406;
      }
    }
    label258:
    label406:
    for (int i = 23;; i = 24)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "vip", "logo_in", i, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        break;
      }
      localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      break;
      label363:
      localObject = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s", new Object[] { this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject });
      break label112;
    }
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 229
    //   11: iconst_2
    //   12: ldc_w 1095
    //   15: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   22: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   25: getfield 654	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   34: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 579	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   45: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   48: getfield 582	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   51: astore 7
    //   53: aload_0
    //   54: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   57: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   60: getfield 1097	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:k	Ljava/lang/String;
    //   63: astore 13
    //   65: aload_0
    //   66: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   69: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   72: getfield 1099	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   75: astore 5
    //   77: aload_0
    //   78: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   81: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   84: getfield 1102	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:j	Ljava/lang/String;
    //   87: astore 6
    //   89: aload_0
    //   90: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   93: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   96: getfield 1104	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   99: astore 14
    //   101: aload 4
    //   103: astore 8
    //   105: aload 4
    //   107: astore 9
    //   109: aload_0
    //   110: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   113: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   116: invokestatic 661	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   119: ifeq +687 -> 806
    //   122: aload 4
    //   124: astore 8
    //   126: aload 4
    //   128: astore 9
    //   130: aload_0
    //   131: getfield 251	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: bipush 8
    //   136: invokevirtual 619	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 621	com/tencent/mobileqq/model/FriendManager
    //   142: astore_3
    //   143: aload_3
    //   144: ifnonnull +633 -> 777
    //   147: aload 4
    //   149: astore 10
    //   151: aload 11
    //   153: ifnull +1183 -> 1336
    //   156: aload 4
    //   158: astore_3
    //   159: aload 4
    //   161: astore 8
    //   163: aload 4
    //   165: astore 9
    //   167: aload 11
    //   169: getfield 1105	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   172: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +17 -> 192
    //   178: aload 4
    //   180: astore 8
    //   182: aload 4
    //   184: astore 9
    //   186: aload 11
    //   188: getfield 1105	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   191: astore_3
    //   192: aload_3
    //   193: astore 8
    //   195: aload_3
    //   196: astore 9
    //   198: aload_3
    //   199: astore 10
    //   201: aload 11
    //   203: getfield 1108	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   206: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +1127 -> 1336
    //   212: aload_3
    //   213: astore 8
    //   215: aload_3
    //   216: astore 9
    //   218: aload 11
    //   220: getfield 1108	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   223: astore 4
    //   225: aload_3
    //   226: astore_2
    //   227: aload 4
    //   229: astore_3
    //   230: aload 7
    //   232: astore 8
    //   234: aload 7
    //   236: astore 9
    //   238: aload_0
    //   239: getfield 251	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   242: bipush 8
    //   244: invokevirtual 619	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   247: checkcast 1110	com/tencent/mobileqq/app/FriendsManagerImp
    //   250: astore 11
    //   252: aload 7
    //   254: astore 8
    //   256: aload 7
    //   258: astore 9
    //   260: aload_0
    //   261: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   264: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   267: getfield 321	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	Ljava/lang/String;
    //   270: astore 4
    //   272: aload 4
    //   274: astore 10
    //   276: aload 7
    //   278: astore 8
    //   280: aload 7
    //   282: astore 9
    //   284: aload 4
    //   286: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifeq +65 -> 354
    //   292: aload 4
    //   294: astore 10
    //   296: aload 7
    //   298: astore 8
    //   300: aload 7
    //   302: astore 9
    //   304: aload_0
    //   305: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   308: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   311: getfield 327	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   314: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   317: ifne +37 -> 354
    //   320: aload 4
    //   322: astore 10
    //   324: aload 11
    //   326: ifnull +28 -> 354
    //   329: aload 7
    //   331: astore 8
    //   333: aload 7
    //   335: astore 9
    //   337: aload 11
    //   339: aload_0
    //   340: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   343: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   346: getfield 327	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   349: invokevirtual 1113	com/tencent/mobileqq/app/FriendsManagerImp:f	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 10
    //   354: aload 7
    //   356: astore 4
    //   358: aload 7
    //   360: astore 8
    //   362: aload 7
    //   364: astore 9
    //   366: aload 10
    //   368: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +39 -> 410
    //   374: aload 7
    //   376: astore 4
    //   378: aload 11
    //   380: ifnull +30 -> 410
    //   383: aload 7
    //   385: astore 8
    //   387: aload 7
    //   389: astore 9
    //   391: aload 11
    //   393: aload 10
    //   395: aload_0
    //   396: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   399: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   402: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   405: invokevirtual 1116	com/tencent/mobileqq/app/FriendsManagerImp:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   408: astore 4
    //   410: aload 4
    //   412: astore 8
    //   414: aload 4
    //   416: astore 9
    //   418: aload 6
    //   420: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   423: ifeq +899 -> 1322
    //   426: aload 4
    //   428: astore 8
    //   430: aload 4
    //   432: astore 9
    //   434: aload_0
    //   435: invokevirtual 1119	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +880 -> 1322
    //   445: aload 4
    //   447: astore 8
    //   449: aload 4
    //   451: astore 9
    //   453: aload 7
    //   455: getfield 1120	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   458: astore 7
    //   460: aload 7
    //   462: astore 6
    //   464: aload_0
    //   465: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   468: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   471: invokestatic 1122	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:j	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   474: ifeq +842 -> 1316
    //   477: aload 5
    //   479: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifeq +834 -> 1316
    //   485: aload_0
    //   486: getfield 251	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: bipush 33
    //   491: invokevirtual 619	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   494: checkcast 1124	com/tencent/mobileqq/app/CircleManager
    //   497: astore 7
    //   499: aload 7
    //   501: ifnull +815 -> 1316
    //   504: aload 7
    //   506: aload_0
    //   507: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   510: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   513: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   516: invokevirtual 1127	com/tencent/mobileqq/app/CircleManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/CircleBuddy;
    //   519: astore 9
    //   521: aload 9
    //   523: ifnull +793 -> 1316
    //   526: aload 9
    //   528: getfield 1130	com/tencent/mobileqq/data/CircleBuddy:remark	Ljava/lang/String;
    //   531: astore 7
    //   533: aload 7
    //   535: astore 5
    //   537: aload_2
    //   538: astore 8
    //   540: aload 9
    //   542: getfield 1131	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   545: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   548: ifne +14 -> 562
    //   551: aload 9
    //   553: getfield 1131	com/tencent/mobileqq/data/CircleBuddy:nickName	Ljava/lang/String;
    //   556: astore 8
    //   558: aload 7
    //   560: astore 5
    //   562: aload_3
    //   563: astore 9
    //   565: aload 4
    //   567: astore 10
    //   569: aload 5
    //   571: astore 11
    //   573: aload 6
    //   575: astore 12
    //   577: aload_0
    //   578: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   581: bipush 7
    //   583: anewarray 287	java/lang/String
    //   586: putfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   593: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   596: iconst_0
    //   597: aload 8
    //   599: aastore
    //   600: aload_0
    //   601: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   604: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   607: iconst_4
    //   608: aload 9
    //   610: aastore
    //   611: aload_0
    //   612: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   615: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   618: iconst_3
    //   619: aload 12
    //   621: aastore
    //   622: aload_0
    //   623: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   626: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   629: iconst_2
    //   630: aload 11
    //   632: aastore
    //   633: aload_0
    //   634: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   637: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   640: iconst_5
    //   641: aload 13
    //   643: aastore
    //   644: aload_0
    //   645: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   648: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   651: iconst_1
    //   652: aload 10
    //   654: aastore
    //   655: aload_0
    //   656: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   659: getfield 577	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   662: bipush 6
    //   664: aload 14
    //   666: aastore
    //   667: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +106 -> 776
    //   673: new 231	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   680: astore_2
    //   681: aload_2
    //   682: ldc_w 1133
    //   685: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc_w 742
    //   691: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 8
    //   696: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc_w 744
    //   702: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 9
    //   707: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 746
    //   713: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 12
    //   718: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: ldc_w 748
    //   724: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 11
    //   729: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: ldc_w 750
    //   735: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 13
    //   740: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: ldc_w 752
    //   746: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 10
    //   751: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: ldc_w 754
    //   757: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload 13
    //   762: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: ldc 229
    //   768: iconst_2
    //   769: aload_2
    //   770: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: return
    //   777: aload 4
    //   779: astore 8
    //   781: aload 4
    //   783: astore 9
    //   785: aload_3
    //   786: aload_0
    //   787: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   790: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   793: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   796: invokeinterface 624 2 0
    //   801: astore 11
    //   803: goto -656 -> 147
    //   806: aload 4
    //   808: astore 8
    //   810: aload 4
    //   812: astore 9
    //   814: aload_0
    //   815: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   818: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   821: getfield 268	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   824: ifne +38 -> 862
    //   827: aload 4
    //   829: astore 8
    //   831: aload 4
    //   833: astore 9
    //   835: aload_0
    //   836: getfield 251	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   839: aload_0
    //   840: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   843: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   846: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   849: invokestatic 372	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   852: astore 4
    //   854: aload_2
    //   855: astore_3
    //   856: aload 4
    //   858: astore_2
    //   859: goto -629 -> 230
    //   862: aload 4
    //   864: astore 8
    //   866: aload 4
    //   868: astore 9
    //   870: aload 4
    //   872: astore_3
    //   873: aload 4
    //   875: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   878: ifeq +447 -> 1325
    //   881: aload 4
    //   883: astore 8
    //   885: aload 4
    //   887: astore 9
    //   889: aload 4
    //   891: astore_3
    //   892: aload_0
    //   893: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   896: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   899: invokestatic 770	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   902: ifeq +423 -> 1325
    //   905: aload 4
    //   907: astore 8
    //   909: aload 4
    //   911: astore 9
    //   913: aload_0
    //   914: getfield 251	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   917: aload_0
    //   918: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   921: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   924: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   927: iconst_0
    //   928: invokestatic 1136	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   931: astore_3
    //   932: aload_3
    //   933: astore 8
    //   935: aload_3
    //   936: astore 9
    //   938: aload_3
    //   939: aload_0
    //   940: getfield 114	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   943: getfield 261	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   946: getfield 272	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   949: invokestatic 721	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   952: istore_1
    //   953: iload_1
    //   954: ifeq +371 -> 1325
    //   957: aconst_null
    //   958: astore 4
    //   960: aload_2
    //   961: astore_3
    //   962: aload 4
    //   964: astore_2
    //   965: goto -735 -> 230
    //   968: astore 4
    //   970: aload 6
    //   972: astore 9
    //   974: aload 5
    //   976: astore_3
    //   977: aload 8
    //   979: astore 6
    //   981: aload 7
    //   983: astore 8
    //   985: aload 4
    //   987: astore 7
    //   989: aload_2
    //   990: astore 5
    //   992: aload 8
    //   994: astore 4
    //   996: aload 9
    //   998: astore_2
    //   999: aload_2
    //   1000: astore 12
    //   1002: aload_3
    //   1003: astore 11
    //   1005: aload 4
    //   1007: astore 10
    //   1009: aload 5
    //   1011: astore 9
    //   1013: aload 6
    //   1015: astore 8
    //   1017: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq -443 -> 577
    //   1023: ldc 229
    //   1025: iconst_2
    //   1026: aload 7
    //   1028: invokevirtual 349	java/lang/Exception:toString	()Ljava/lang/String;
    //   1031: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: aload_2
    //   1035: astore 12
    //   1037: aload_3
    //   1038: astore 11
    //   1040: aload 4
    //   1042: astore 10
    //   1044: aload 5
    //   1046: astore 9
    //   1048: aload 6
    //   1050: astore 8
    //   1052: goto -475 -> 577
    //   1055: astore 4
    //   1057: aload 6
    //   1059: astore 8
    //   1061: aload 5
    //   1063: astore_3
    //   1064: aload 9
    //   1066: astore 6
    //   1068: aload 7
    //   1070: astore 9
    //   1072: aload 4
    //   1074: astore 7
    //   1076: aload_2
    //   1077: astore 5
    //   1079: aload 9
    //   1081: astore 4
    //   1083: aload 8
    //   1085: astore_2
    //   1086: aload_2
    //   1087: astore 12
    //   1089: aload_3
    //   1090: astore 11
    //   1092: aload 4
    //   1094: astore 10
    //   1096: aload 5
    //   1098: astore 9
    //   1100: aload 6
    //   1102: astore 8
    //   1104: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1107: ifeq -530 -> 577
    //   1110: ldc 229
    //   1112: iconst_2
    //   1113: aload 7
    //   1115: invokevirtual 1137	java/lang/Error:toString	()Ljava/lang/String;
    //   1118: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: aload_2
    //   1122: astore 12
    //   1124: aload_3
    //   1125: astore 11
    //   1127: aload 4
    //   1129: astore 10
    //   1131: aload 5
    //   1133: astore 9
    //   1135: aload 6
    //   1137: astore 8
    //   1139: goto -562 -> 577
    //   1142: astore 10
    //   1144: aload 8
    //   1146: astore 4
    //   1148: aload_2
    //   1149: astore 7
    //   1151: aload 5
    //   1153: astore 9
    //   1155: aload_3
    //   1156: astore 5
    //   1158: aload 10
    //   1160: astore 8
    //   1162: aload 6
    //   1164: astore_2
    //   1165: aload 9
    //   1167: astore_3
    //   1168: aload 7
    //   1170: astore 6
    //   1172: aload 8
    //   1174: astore 7
    //   1176: goto -90 -> 1086
    //   1179: astore 8
    //   1181: aload 6
    //   1183: astore 7
    //   1185: aload_2
    //   1186: astore 6
    //   1188: aload 5
    //   1190: astore 9
    //   1192: aload_3
    //   1193: astore 5
    //   1195: aload 7
    //   1197: astore_2
    //   1198: aload 9
    //   1200: astore_3
    //   1201: aload 8
    //   1203: astore 7
    //   1205: goto -119 -> 1086
    //   1208: astore 8
    //   1210: aload_3
    //   1211: astore 5
    //   1213: aload 6
    //   1215: astore_3
    //   1216: aload_2
    //   1217: astore 6
    //   1219: aload_3
    //   1220: astore_2
    //   1221: aload 7
    //   1223: astore_3
    //   1224: aload 8
    //   1226: astore 7
    //   1228: goto -142 -> 1086
    //   1231: astore 8
    //   1233: aload 9
    //   1235: astore 4
    //   1237: aload_2
    //   1238: astore 7
    //   1240: aload 5
    //   1242: astore 9
    //   1244: aload_3
    //   1245: astore 5
    //   1247: aload 6
    //   1249: astore_2
    //   1250: aload 9
    //   1252: astore_3
    //   1253: aload 7
    //   1255: astore 6
    //   1257: aload 8
    //   1259: astore 7
    //   1261: goto -262 -> 999
    //   1264: astore 8
    //   1266: aload 6
    //   1268: astore 7
    //   1270: aload_2
    //   1271: astore 6
    //   1273: aload 5
    //   1275: astore 9
    //   1277: aload_3
    //   1278: astore 5
    //   1280: aload 7
    //   1282: astore_2
    //   1283: aload 9
    //   1285: astore_3
    //   1286: aload 8
    //   1288: astore 7
    //   1290: goto -291 -> 999
    //   1293: astore 8
    //   1295: aload_3
    //   1296: astore 5
    //   1298: aload 6
    //   1300: astore_3
    //   1301: aload_2
    //   1302: astore 6
    //   1304: aload_3
    //   1305: astore_2
    //   1306: aload 7
    //   1308: astore_3
    //   1309: aload 8
    //   1311: astore 7
    //   1313: goto -314 -> 999
    //   1316: aload_2
    //   1317: astore 8
    //   1319: goto -757 -> 562
    //   1322: goto -858 -> 464
    //   1325: aload_2
    //   1326: astore 4
    //   1328: aload_3
    //   1329: astore_2
    //   1330: aload 4
    //   1332: astore_3
    //   1333: goto -1103 -> 230
    //   1336: aload_2
    //   1337: astore_3
    //   1338: aload 10
    //   1340: astore_2
    //   1341: goto -1111 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1344	0	this	FriendProfileCardActivity
    //   952	2	1	bool	boolean
    //   40	1301	2	localObject1	Object
    //   142	1196	3	localObject2	Object
    //   28	935	4	localObject3	Object
    //   968	18	4	localException1	Exception
    //   994	47	4	localObject4	Object
    //   1055	18	4	localError1	java.lang.Error
    //   1081	250	4	localObject5	Object
    //   75	1222	5	localObject6	Object
    //   87	1216	6	localObject7	Object
    //   51	1261	7	localObject8	Object
    //   103	1070	8	localObject9	Object
    //   1179	23	8	localError2	java.lang.Error
    //   1208	17	8	localError3	java.lang.Error
    //   1231	27	8	localException2	Exception
    //   1264	23	8	localException3	Exception
    //   1293	17	8	localException4	Exception
    //   1317	1	8	localObject10	Object
    //   107	1177	9	localObject11	Object
    //   149	981	10	localObject12	Object
    //   1142	197	10	localError4	java.lang.Error
    //   1	1125	11	localObject13	Object
    //   575	548	12	localObject14	Object
    //   63	698	13	str1	String
    //   99	566	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   109	122	968	java/lang/Exception
    //   130	143	968	java/lang/Exception
    //   167	178	968	java/lang/Exception
    //   186	192	968	java/lang/Exception
    //   201	212	968	java/lang/Exception
    //   218	225	968	java/lang/Exception
    //   785	803	968	java/lang/Exception
    //   814	827	968	java/lang/Exception
    //   835	854	968	java/lang/Exception
    //   873	881	968	java/lang/Exception
    //   892	905	968	java/lang/Exception
    //   913	932	968	java/lang/Exception
    //   938	953	968	java/lang/Exception
    //   109	122	1055	java/lang/Error
    //   130	143	1055	java/lang/Error
    //   167	178	1055	java/lang/Error
    //   186	192	1055	java/lang/Error
    //   201	212	1055	java/lang/Error
    //   218	225	1055	java/lang/Error
    //   785	803	1055	java/lang/Error
    //   814	827	1055	java/lang/Error
    //   835	854	1055	java/lang/Error
    //   873	881	1055	java/lang/Error
    //   892	905	1055	java/lang/Error
    //   913	932	1055	java/lang/Error
    //   938	953	1055	java/lang/Error
    //   238	252	1142	java/lang/Error
    //   260	272	1142	java/lang/Error
    //   284	292	1142	java/lang/Error
    //   304	320	1142	java/lang/Error
    //   337	354	1142	java/lang/Error
    //   366	374	1142	java/lang/Error
    //   391	410	1142	java/lang/Error
    //   418	426	1142	java/lang/Error
    //   434	440	1142	java/lang/Error
    //   453	460	1142	java/lang/Error
    //   464	499	1179	java/lang/Error
    //   504	521	1179	java/lang/Error
    //   526	533	1179	java/lang/Error
    //   540	558	1208	java/lang/Error
    //   238	252	1231	java/lang/Exception
    //   260	272	1231	java/lang/Exception
    //   284	292	1231	java/lang/Exception
    //   304	320	1231	java/lang/Exception
    //   337	354	1231	java/lang/Exception
    //   366	374	1231	java/lang/Exception
    //   391	410	1231	java/lang/Exception
    //   418	426	1231	java/lang/Exception
    //   434	440	1231	java/lang/Exception
    //   453	460	1231	java/lang/Exception
    //   464	499	1264	java/lang/Exception
    //   504	521	1264	java/lang/Exception
    //   526	533	1264	java/lang/Exception
    //   540	558	1293	java/lang/Exception
  }
  
  private void q()
  {
    int m = 3;
    int k = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    int j = k;
    int i = m;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      i = 0;
      j = k;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(i, j, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateProfileName profileName=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString());
      }
      return;
      i = 1;
      j = 2;
      continue;
      j = 2;
      i = 2;
      continue;
      j = 2;
      i = m;
      continue;
      i = 4;
      j = k;
      continue;
      j = 2;
      i = 6;
      continue;
      i = 6;
      j = k;
      continue;
      j = 2;
      i = 7;
      continue;
      i = 7;
      j = k;
      continue;
      i = 8;
      j = k;
      continue;
      i = 9;
      j = k;
      continue;
      i = 11;
      j = k;
      continue;
      i = 10;
      j = k;
      continue;
      i = 5;
      j = k;
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int == 100) && (GesturePWDUtils.getJumpLock(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      B();
    }
  }
  
  private void s()
  {
    try
    {
      FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
      {
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
        ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView, "contentBackground", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
        ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
        if (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
          if (this.jdField_b_of_type_AndroidViewView != null) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        while (!this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
          return;
          if (this.jdField_b_of_type_AndroidViewView != null) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      localException.setForeground(getResources().getDrawable(2130840100));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
      }
      localException.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130837729);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837729);
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  public void a()
  {
    if (this.e) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "init");
    }
    this.e = true;
    Message localMessage = null;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {}
    for (;;)
    {
      if ((localMessage != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71)) {
        break;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Network_circle_prof", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int), "", "");
      return;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localMessage = Message.obtain();
        localMessage.what = 6;
        localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_in_client", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int), "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label146;
      }
      paramCardContactInfo = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramCardContactInfo));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(paramCardContactInfo);
      }
      startActivity(paramCardContactInfo);
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label146:
      a(2131562581, 1);
    }
  }
  
  public void a(Card paramCard)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
    {
      localObject1 = new Intent(this, VisitorsActivity.class);
      localObject2 = new Bundle();
      paramCard = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (paramCard == null)
      {
        paramCard = null;
        ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
        if (paramCard == null) {
          break label226;
        }
        ((Bundle)localObject2).putLong("totalVoters", paramCard.lVoteCount);
      }
      for (;;)
      {
        ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
        ((Bundle)localObject2).putBoolean("votersOnly", true);
        if ((paramCard == null) || (paramCard.lVoteCount == 0L)) {
          ((Bundle)localObject2).putBoolean("hasVoters", false);
        }
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        startActivity((Intent)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.get("map_key_like_image");
          if (paramCard != null) {
            paramCard.setVisibility(8);
          }
        }
        return;
        paramCard = paramCard.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        label226:
        ((Bundle)localObject2).putLong("totalVoters", 0L);
      }
    }
    Object localObject2 = (CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    EntityManager localEntityManager;
    long l;
    if ((localObject2 != null) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (paramCard == null) {
        break label458;
      }
      localObject1 = paramCard.vCookies;
      paramCard.lVoteCount += 1L;
      paramCard.bVoted = 1;
      l = paramCard.lVoteCount;
      localEntityManager.a(paramCard);
      paramCard = (Card)localObject1;
    }
    for (;;)
    {
      localEntityManager.a();
      ((CardHandler)localObject2).a(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), paramCard);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, l);
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Prof_good", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      if (localObject2 != null)
      {
        a(2131562964, 1);
        return;
      }
      a(2131562281, 1);
      return;
      label458:
      paramCard = null;
      l = 0L;
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    Object localObject = null;
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, 1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).b();
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
      a(true);
      if (paramCard == null) {
        break label300;
      }
      l = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
    }
    for (paramCard = paramString;; paramCard = null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
      {
        paramString = localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57) {}
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte;
      }
      a(l, paramCard, paramString);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i = 1;
      }
      localProfileHeaderView.a(str, i);
      break;
      label300:
      n();
      l = 0L;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo Card isNetRet = " + paramBoolean);
    }
    c(null);
    if (a(paramCard, paramBoolean)) {
      q();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramCard, paramBoolean);
    m();
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramContactCard, paramBoolean)) {
      q();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    m();
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0);
    if ((localObject instanceof ProfileHeaderView))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
      }
      localObject = (ProfileHeaderView)localObject;
      if (localObject != null)
      {
        ((ProfileHeaderView)localObject).a(paramProfileCardInfo, paramBoolean);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
    }
    b(paramProfileCardInfo);
  }
  
  public void a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if ((QLog.isColorLevel()) && (paramProfileCardTemplate != null)) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "revice request to downloadCardTemplate cardTemplate= " + paramProfileCardTemplate.toString());
    }
    ThreadManager.a(new ctt(this, paramProfileCardTemplate));
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        break label63;
      }
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "personal_profile", "copy_uin", 0, 0, "", "", "", "");
      return;
      label63:
      ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(int[] paramArrayOfInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689494);
    }
    ActionSheet localActionSheet2;
    ActionSheet localActionSheet1;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33))
    {
      localActionSheet2 = (ActionSheet)ActionSheetHelper.a(this, null);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
      {
        localActionSheet1 = localActionSheet2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo != null)
        {
          localActionSheet2.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.c);
          i = j;
          localActionSheet1 = localActionSheet2;
        }
        if (i >= paramArrayOfInt.length) {
          break label305;
        }
        if (paramArrayOfInt[i] != 16) {
          break label271;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localActionSheet1 = localActionSheet2;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break;
      }
      localActionSheet2.a(getString(2131561258));
      localActionSheet1 = localActionSheet2;
      i = j;
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) && (h == true))
      {
        localActionSheet1 = (ActionSheet)ActionSheetHelper.a(this, null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo != null) {
          localActionSheet1.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.jdField_a_of_type_JavaLangString + "  " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo.c);
        }
        h = false;
        i = j;
        break;
      }
      localActionSheet1 = (ActionSheet)ActionSheetHelper.b(this, null);
      i = j;
      break;
      label271:
      if ((paramArrayOfInt[i] >= 0) && (paramArrayOfInt[i] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
        localActionSheet1.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i]], 1);
      }
    }
    label305:
    localActionSheet1.a(new cto(this, localActionSheet1));
    localActionSheet1.show();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramView, paramMotionEvent);
    }
    return false;
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.addAction("com.tencent.mobileqq.view.self.album");
    localIntentFilter.setPriority(2147483647);
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label133;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label133:
      a(2131562581, 1);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = paramString;
    a(4, paramString);
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    q();
    switch (paramString.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      }
    }
  }
  
  public String c()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (ProfileActivity.a(this.d, l))
    {
      this.d = l;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject1 = d();
      }
      localObject2 = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { localObject1 });
      localObject1 = new Intent(this, MusicGeneQQBrowserActivity.class);
      ((Intent)localObject1).putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label257;
      }
      ((Intent)localObject1).putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject2 = Calendar.getInstance();
      if ((localObject2 != null) && (QLog.isColorLevel()))
      {
        localObject2 = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject2).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "musicgene123 startactivity " + (String)localObject2);
        }
      }
      startActivity((Intent)localObject1);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004182 ", "0X8004182", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label257:
      ((Intent)localObject1).putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.e(BaseApplication.getContext())) {
          break label188;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString))) {
          break label177;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (localFriendListHandler == null) {
          break label166;
        }
        localFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo);
        this.bo |= 0x1;
        b(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label166:
      a(2131562435, 1);
      continue;
      label177:
      a(2131562516, 1);
      continue;
      label188:
      a(2131562445, 1);
    }
  }
  
  public void d()
  {
    ThreadManager.b(new cts(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt1 == 1010) {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int == 101) && (paramInt2 == -1)) {
        finish();
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
            Object localObject;
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
                      if (paramInt1 != 1008) {
                        break;
                      }
                    } while (paramIntent == null);
                    bool = paramIntent.getExtras().getBoolean("photowall_updated");
                    paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
                    if (((paramInt2 == -1) || (bool)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
                      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
                    }
                  } while (paramIntent == null);
                  localObject = Message.obtain();
                  ((Message)localObject).what = 1;
                  ((Message)localObject).obj = paramIntent;
                } while (this.jdField_b_of_type_AndroidOsHandler == null);
                this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject);
                return;
                if (paramInt1 != 1007) {
                  break;
                }
              } while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
              localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              if (localObject == null) {}
              for (localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
              {
                if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
                {
                  this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
                  this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
                  this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a((Card)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(((Card)localObject).getRichStatus());
                  this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = ((Card)localObject).strNick;
                  this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
                }
                setResult(-1, paramIntent);
                return;
              }
            } while (paramInt2 != -1);
            switch (paramInt1)
            {
            default: 
              return;
            case 5: 
              paramIntent = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
              paramInt1 = Math.min(482, ProfileCardUtil.a(this));
              localObject = new Intent();
              ((Intent)localObject).putExtra("Business_Origin", 100);
              PhotoUtils.a((Intent)localObject, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
              return;
            }
          } while (paramIntent == null);
          if (paramIntent.getBooleanExtra("finchat", false))
          {
            finish();
            return;
          }
          paramIntent = paramIntent.getStringExtra("remark");
        } while (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString, paramIntent));
        b(paramIntent);
        return;
        setResult(-1);
        finish();
        return;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          a(2131562488, 1);
          return;
        }
        if (paramIntent != null) {
          bool = paramIntent.getBooleanExtra("avatar_changed", false);
        }
      } while (!bool);
      paramIntent = paramIntent.getStringExtra("avatar_filepath");
      if (!ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    return;
    a(2131562885, 1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      this.M = System.currentTimeMillis();
    }
    Intent localIntent = getIntent();
    super.doOnCreate(paramBundle);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) || (localIntent == null))
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener = this.jdField_a_of_type_AndroidViewView$OnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localIntent.getParcelableExtra("AllInOne"));
    if (!a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo))
    {
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
      this.g = false;
    }
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
      b();
      a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      paramBundle = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f == 6) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      }
      a(false);
      p();
      n();
      r();
      long l = System.currentTimeMillis() - this.M;
      if ((QLog.isColorLevel()) && (l > 100L)) {
        QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity onCreate used:" + l);
      }
      return true;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, "qq_error|" + paramBundle.toString());
      }
      finish();
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    }
    if (this.jdField_a_of_type_Boolean) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    Object localObject = (StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d();
    }
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      int j = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).d();
        }
        i += 1;
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      } while (paramIntent == null);
      if (!ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    return;
    a(2131562885, 1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.M > 0L)
    {
      long l = System.currentTimeMillis() - this.M;
      if ((QLog.isColorLevel()) && (l > 500L)) {
        QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity Ui render used:" + l);
      }
      this.M = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f == 6) {
      k();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.e)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.d, l))
    {
      this.d = l;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label291;
      }
      localObject = (TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (localObject != null) {
        break label71;
      }
      localObject = null;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label88;
      }
      a(2131562038, 1);
    }
    label71:
    label88:
    do
    {
      return;
      localObject = ((TicketManager)localObject).getStweb(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      break;
      localObject = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject, "19", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + (String)localObject);
      }
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
    return;
    label291:
    Object localObject = String.format("http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid() });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQ_rank", "click_qrank_in", 24, 0, "", "", "", "");
  }
  
  public void f()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localIntent.putExtra("title", getString(2131560517));
    localIntent.putExtra("nick", ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    startActivity(localIntent);
  }
  
  public void g()
  {
    int k = 3003;
    int j;
    int i;
    Intent localIntent;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      k = 10004;
      j = 0;
      i = 0;
      localIntent = new Intent(this, AddFriendLogicActivity.class);
      localIntent.putExtra("type", j);
      localIntent.putExtra("source_id", k);
      localIntent.putExtra("param_last_activity_name", a_());
      localIntent.putExtra("sub_source_id", i);
      if (3004 == k)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c.length() != 0)) {
          localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
        }
        label375:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
          break label922;
        }
        localIntent.putExtra("uin", "");
        localObject1 = a();
        if ((localObject1 != null) && (((ProfileActivity.CardContactInfo)localObject1).c != null) && (((ProfileActivity.CardContactInfo)localObject1).c.length() > 0))
        {
          localIntent.putExtra("friend_mobile_number", ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).c);
          if (!TextUtils.isEmpty(((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString)) {
            break label905;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label825;
          }
          localIntent.putExtra("friend_mobile_name", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3]);
        }
      }
      break;
    }
    label905:
    for (;;)
    {
      startActivity(localIntent);
      return;
      k = 3004;
      j = 0;
      i = 0;
      break;
      k = 3007;
      j = 0;
      i = 0;
      break;
      k = 3001;
      j = 0;
      i = 0;
      break;
      k = 3017;
      j = 0;
      i = 0;
      break;
      k = 3002;
      j = 0;
      i = 0;
      break;
      k = 3005;
      j = 0;
      i = 0;
      break;
      k = 3007;
      j = 0;
      i = 0;
      break;
      i = 0;
      j = 0;
      break;
      k = 3008;
      j = 0;
      i = 0;
      break;
      k = 3008;
      j = 0;
      i = 0;
      break;
      k = 10004;
      j = 0;
      i = 0;
      break;
      j = 4;
      k = 3009;
      i = 0;
      break;
      k = 3006;
      j = 3;
      i = 0;
      break;
      k = 3009;
      j = 4000;
      i = 0;
      break;
      k = 3006;
      j = 4000;
      i = 0;
      break;
      k = 3013;
      j = 0;
      i = 0;
      break;
      i = 1;
      j = 0;
      break;
      k = 3014;
      j = 3;
      i = 0;
      break;
      i = 2;
      j = 0;
      break;
      k = 10004;
      j = 0;
      i = 0;
      break;
      if (4000 != j) {
        break label375;
      }
      localIntent.putExtra("sub_source_id", 1);
      break label375;
      label825:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        localIntent.putExtra("friend_mobile_name", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]);
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString))
      {
        localIntent.putExtra("friend_mobile_name", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString);
        continue;
        localIntent.putExtra("friend_mobile_name", ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString);
      }
    }
    label922:
    Object localObject1 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("nick_name", (String)localObject2);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      localIntent.putExtra("param_return_addr", AddContactsActivity.class.getName());
      startActivity(localIntent);
      return;
    }
    localIntent.putExtra("param_return_addr", FriendProfileCardActivity.class.getName());
    startActivity(localIntent);
  }
  
  public void h()
  {
    int i = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      setResult(0, (Intent)localObject);
      finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      localObject = c();
    }
    for (;;)
    {
      a((String)localObject, i);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int == 102) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int == 103) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    Object localObject1;
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    default: 
    case 6: 
    case 5: 
      do
      {
        do
        {
          return true;
          paramMessage = c();
        } while ((localObject2 == null) || (paramMessage == null) || (paramMessage.length() <= 0));
        paramMessage = ((FriendsManager)localObject2).b(paramMessage);
        localObject1 = a();
        if (localObject1 != null)
        {
          paramMessage.nationCode = ((ProfileActivity.CardContactInfo)localObject1).b;
          paramMessage.mobileCode = ((ProfileActivity.CardContactInfo)localObject1).c;
          paramMessage.strContactName = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;
        }
        if ((paramMessage.nickName == null) || (paramMessage.nickName.length() == 0)) {
          paramMessage.nickName = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_JavaLangString;
        }
        ((FriendsManager)localObject2).a(paramMessage);
        a(0L, null, null);
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 4;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return true;
        paramMessage = (String)paramMessage.obj;
        localObject1 = ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage);
      } while ((localObject1 == null) || (localObject2 == null));
      if ((((FriendsManager)localObject2).b(((Card)localObject1).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      }
      paramMessage = Message.obtain();
      paramMessage.what = 4;
      paramMessage.obj = localObject1;
      paramMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      localObject2 = ((Card)localObject1).vSeed;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)) {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte;
      }
      break;
    }
    for (;;)
    {
      a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage);
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_ArrayOfByte;
        continue;
        localObject2 = (CoverCacheData)paramMessage.obj;
        EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localEntityManager == null)
        {
          paramMessage = null;
          localObject1 = paramMessage;
          if (paramMessage == null)
          {
            localObject1 = new QZoneCover();
            ((QZoneCover)localObject1).uin = Long.toString(((CoverCacheData)localObject2).uin);
          }
          ((QZoneCover)localObject1).updateQzoneCover((CoverCacheData)localObject2);
          if (((QZoneCover)localObject1).getStatus() != 1000) {
            break label506;
          }
          localEntityManager.a((Entity)localObject1);
        }
        for (;;)
        {
          localEntityManager.a();
          return true;
          paramMessage = (QZoneCover)localEntityManager.a(QZoneCover.class, Long.toString(((CoverCacheData)localObject2).uin));
          break;
          label506:
          localEntityManager.a((Entity)localObject1);
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localObject2 == null)) {
          break;
        }
        paramMessage = ((FriendsManager)localObject2).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (paramMessage == null) {
          break;
        }
        a(paramMessage.feedPreviewTime, paramMessage.vSeed, null);
        return true;
      }
      paramMessage = null;
    }
  }
  
  public void i()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.a(this, localUserInfo, Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)), 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int, -1);
  }
  
  public void j()
  {
    int j = 0;
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label130;
      }
      localObject = new Card();
    }
    label130:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      if (i != 0) {
        localEntityManager.a((Entity)localObject);
      }
      for (;;)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f;
        }
        b(i);
        return;
        localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        localEntityManager.a((Entity)localObject);
      }
    }
  }
  
  public void k()
  {
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i;
    if (localQQMessageFacade != null)
    {
      i = localQQMessageFacade.f();
      if (i <= 0) {
        break label117;
      }
      if (i > 99) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + "99+" + ")");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + i + ")");
    return;
    label117:
    getIntent().putExtra("leftViewText", getString(2131561807));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807));
  }
  
  public void l()
  {
    QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) {}
    for (String str = "listen_frd";; str = "listen_str")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Voice_profile", str, ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.performClick();
    return true;
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "onPrepareOptionsMenu");
    }
    Object localObject;
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetTextView.getText() != null))
    {
      localObject = paramMenu.findItem(this.jdField_c_of_type_AndroidWidgetTextView.getId());
      if (localObject == null) {
        break label117;
      }
      ((MenuItem)localObject).setTitle(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null))
      {
        localObject = getSupportActionBar();
        if (localObject != null) {
          ((ActionBar)localObject).setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
      }
      return super.onPrepareOptionsMenu(paramMenu);
      label117:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, this.jdField_c_of_type_AndroidWidgetTextView.getId(), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText()), 1);
    }
  }
  
  protected void onRestart()
  {
    long l2 = 0L;
    super.onRestart();
    FriendsManager localFriendsManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33)
      {
        localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label190;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
        break label209;
      }
    }
    label190:
    label209:
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a;; l1 = 0L)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        l2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentTemplateId;
      }
      if (l1 != l2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onRestart  initContentView current templateId= " + l1 + ", new templateId = " + l2);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.f = false;
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = localFriendsManager.a(c());
      break;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new ctk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */