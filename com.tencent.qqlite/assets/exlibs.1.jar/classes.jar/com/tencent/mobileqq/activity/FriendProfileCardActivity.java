package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anw;
import anx;
import aob;
import aoc;
import aod;
import aoe;
import aof;
import aog;
import aoh;
import aoi;
import aoj;
import aok;
import aon;
import aoo;
import aop;
import aoq;
import aor;
import aos;
import aot;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements Handler.Callback, BounceScrollView.MotionEventInterceptor, Observer
{
  public static final float a = 16.0F;
  public static final int a = 5;
  public static long a = 0L;
  public static final String a = "Vip_SummaryCard";
  public static final float b = 0.125F;
  private static final int bE = 1;
  private static final int bG = 0;
  private static final int bH = 1;
  private static final int bI = 2;
  private static final int bJ = 3;
  private static final int bK = 4;
  private static final int bL = 5;
  private static final int bM = 6;
  private static final int bN = 7;
  private static final int bO = 8;
  private static final int bP = 2;
  private static final int bQ = 3;
  private static final int bR = 4;
  private static final int bS = 6;
  private static final int bT = 7;
  private static final int bU = 8;
  private static final int bV = 9;
  private static final int bW = 10;
  private static final int bX = 5;
  private static final int bZ = 2;
  private static final String cH = "FriendProfileCardActivity";
  private static final int ca = 5;
  private static final int cb = 6;
  private static final int cc = 7;
  private static final int cd = 8;
  static String jdField_d_of_type_JavaLangString = "http://m.qzone.com/l?g=754";
  public static final int e = 3;
  static String jdField_e_of_type_JavaLangString = "http://m.qzone.com/profile?";
  public static final int f = 11;
  private long M = 0L;
  public Dialog a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aoq(this);
  public DialogInterface.OnClickListener a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  public Uri a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aob(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new anx(this);
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.CardContactInfo a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aok(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new aoo(this);
  public ProfileCardInfo a;
  private ProfileCardTemplate jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
  public ProfileHeaderView a;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new aog(this);
  protected QQCustomDialog a;
  public TimeTraceUtil a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public ProfileCardMoreInfoView a;
  protected QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  Runnable jdField_a_of_type_JavaLangRunnable = new anw(this);
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  public long b;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  public DialogInterface.OnClickListener b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public View b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CardObserver jdField_b_of_type_ComTencentMobileqqAppCardObserver = new aon(this);
  public Runnable b;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  private int bF = 0;
  private int bY = 0;
  public int c;
  public long c;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  long jdField_e_of_type_Long;
  private boolean f = false;
  public int g;
  private boolean g;
  private boolean h = true;
  
  public FriendProfileCardActivity()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = new aoe(this);
    this.jdField_g_of_type_Int = 30000;
    this.jdField_b_of_type_JavaLangRunnable = new aoh(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aoi(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new aoj(this);
  }
  
  private TroopInfo a()
  {
    new ArrayList();
    Object localObject = ((TroopManager)this.app.getManager(44)).b();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject).next();
      int i = TroopListAdapter2.a(this.app.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        localArrayList1.add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        localArrayList2.add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
      } else {
        localArrayList3.add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
      }
    }
    localObject = new TroopListAdapter2.TroopCompator();
    Collections.sort(localArrayList1, (Comparator)localObject);
    Collections.sort(localArrayList2, (Comparator)localObject);
    Collections.sort(localArrayList3, (Comparator)localObject);
    if (localArrayList1.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList1.get(0)).a;
    }
    if (localArrayList2.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList2.get(0)).a;
    }
    if (localArrayList3.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList3.get(0)).a;
    }
    return null;
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
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 9, 2131363885, 2130838756, 2131361812);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131363884, 2130838753, 2131361810);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131363080, 2130838759, 2131361811);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131363884, 2130838753, 2131361810);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131363080, 2130838759, 2131361811);
      paramInt = 3;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 8, 2131363080, 2130838759, 2131361811);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131363884, 2130838753, 2131361810);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      paramInt = 2;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131363884, 2130838753, 2131361810);
      paramInt = 1;
      continue;
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 8, 2131363080, 2130838759, 2131361811);
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.bY);
    }
    if (this.bY > 5) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.a(2);
    } while (localCardHandler == null);
    this.bY += 1;
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
        case 71: 
        case 72: 
        default: 
          return;
        case 0: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 60: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 1: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 40: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 41: 
          i = 6;
          paramArrayOfByte1 = "";
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
          {
            i = 37;
            paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
          }
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2);
          return;
        case 42: 
        case 73: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 36: 
          localCardHandler.a(this.app.a(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, c(), l3, 3014, arrayOfByte2);
          return;
        case 30: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
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
          localCardHandler.a(this.app.a(), "0", i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, c(), l3, 10004, null);
          return;
        case 46: 
        case 47: 
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
            break;
          }
          l2 = 0L;
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
            {
              i = 4;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
            }
          }
          catch (Exception paramArrayOfByte1)
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
          l1 = ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
          {
            i = 2;
            b1 = 1;
          }
          for (;;)
          {
            localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
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
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 2: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 74: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 35: 
        case 37: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2);
          return;
        case 75: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2);
          return;
        case 61: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 70: 
          localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
          return;
        case 25: 
        case 26: 
        case 27: 
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 2004)) {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
          }
        case 4: 
        case 52: 
        case 19: 
        case 55: 
        case 56: 
        case 57: 
          label1962:
          label1970:
          for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
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
                  localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, arrayOfByte2);
                  return;
                  if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
                    break label1970;
                  }
                  paramArrayOfByte1 = (TroopInfo)this.app.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString });
                  if (paramArrayOfByte1 == null) {
                    break label1970;
                  }
                  paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                  break;
                  if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 2005)) {
                    break label1962;
                  }
                  paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
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
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
              return;
              localCardHandler.a(this.app.a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2);
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
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int)
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
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView != null)
    {
      DataTag localDataTag = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView = (TextView)paramView.findViewById(2131298339);
      paramView.setText(paramInt2);
      paramView.setContentDescription(getString(paramInt4));
      paramView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      if ((!a(paramInt1)) || (this.h)) {
        break label117;
      }
      paramView.setTextColor(getResources().getColor(2131427493));
    }
    for (;;)
    {
      paramView.setEnabled(this.h);
      return;
      label117:
      paramView.setTextColor(getResources().getColor(2131427491));
    }
  }
  
  private void a(View paramView, long paramLong1, long paramLong2)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramView != null))
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      }
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298365);
      if (localObject == null) {}
    }
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
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("headerViewRender", "initContentViewStart", false);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_d_of_type_AndroidViewView = null;
    int i = getResources().getColor(2131427446);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903517, null);
      Object localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(i);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(1, -1));
        this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903517, null);
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(i);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(1, -1));
        this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2130903517, null);
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        paramLinearLayout.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView start...");
    }
    b(paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initProfileMoreViewStart", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initProfileMoreViewEnd", "initProfileMoreViewStart", false);
    q();
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
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)))
    {
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
        break label717;
      }
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
      }
      if (paramInt == 1009) {
        localIntent.putExtra("rich_status_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      }
      if (paramInt == 1001)
      {
        localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "accost_sig = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
      }
      paramString = (FriendManager)this.app.getManager(8);
      if (paramString != null)
      {
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (paramString.cSpecialFlag == 1))
        {
          localIntent.setClass(getActivity(), ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int != 101)) {
        break label755;
      }
      localIntent.putExtra("is_from_manage_stranger", true);
      startActivityForResult(localIntent, 1010);
      return;
      if (((paramInt == 1000) || (paramInt == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      if (paramInt == 1004)
      {
        paramString = null;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null) {
          paramString = ContactUtils.b(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
        localIntent.putExtra("uinname", (String)localObject);
        break;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      localIntent.putExtra("uinname", (String)localObject);
      break;
      label717:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
      }
    }
    label755:
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
        localPhoneContactManager = (PhoneContactManager)this.app.getManager(10);
        if (localPhoneContactManager != null) {
          break label200;
        }
      }
    }
    return;
    label200:
    PhoneContact localPhoneContact;
    Object localObject;
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localPhoneContact = localPhoneContactManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = localPhoneContact;
      if (paramBoolean) {
        break label558;
      }
      localObject = (FriendListHandler)this.app.a(1);
      if ((!((FriendListHandler)localObject).a()) && (!((FriendListHandler)localObject).b())) {
        ((FriendListHandler)localObject).d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      localObject = localPhoneContact;
    }
    label558:
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject).name, ((PhoneContact)localObject).mobileCode, ((PhoneContact)localObject).nationCode));
        return;
        localPhoneContact = localPhoneContactManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject = localPhoneContact;
        if (localPhoneContact == null)
        {
          localPhoneContact = localPhoneContactManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject = localPhoneContact;
          if (localPhoneContact != null)
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
          break label519;
        }
        bool1 = true;
        label114:
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
          break label524;
        }
        bool2 = true;
        label171:
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
          break label530;
        }
        paramBoolean = true;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1] = paramCard.strTroopNick;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label278:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label540;
          }
        }
      }
      label519:
      label524:
      label530:
      label540:
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
        break label114;
        bool2 = false;
        break label171;
        paramBoolean = false;
        break label228;
        bool1 = false;
        break label278;
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
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 55)) {
        break label191;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int);
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
      label191:
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int = 0;
    }
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_g_of_type_Boolean;
        if (bool == true) {
          return;
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "start initHeaderView downloadProfileResTimes=" + this.jdField_c_of_type_Int + ",initProfileConfigTimes=" + this.jdField_d_of_type_Int);
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
        {
          int i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
          String str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl;
          long l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView user card lCurrentStyleId=" + 0L + ",templateRet=" + i + ",backgroundUrl=" + str + ",color=" + l);
          }
          if ((0L < 0L) && (NetworkUtil.f(this))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initHeaderView cardTemplate is null reset headerView downloadProfileResTimes=" + this.jdField_c_of_type_Int + ",initProfileConfigTimes=" + this.jdField_d_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
          x();
          continue;
        }
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard == null) {
          break label380;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by contactCard");
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
      x();
      continue;
      label380:
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
        x();
      }
    }
  }
  
  private String d()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.app, c());
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
  
  private void d(String paramString)
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363862);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363862);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131364516));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aor(this));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label156;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label540;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramString = new DataTag(16, null);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(paramString);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.h);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131363861);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363861);
      break;
      label156:
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70)
      {
        i = j;
        if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 21)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22)
              {
                i = j;
                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 46)
                {
                  i = j;
                  if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 47)
                  {
                    i = j;
                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41)
                    {
                      i = j;
                      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 42)
                      {
                        i = j;
                        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56)
                        {
                          i = j;
                          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57) {
                            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
                            {
                              i = j;
                              if (TextUtils.isEmpty(d())) {
                                i = 0;
                              }
                            }
                            else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
                            {
                              i = 0;
                            }
                            else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
                            {
                              i = j;
                              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int == 0) {
                                i = 0;
                              }
                            }
                            else
                            {
                              i = j;
                              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 2)
                              {
                                i = j;
                                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 74)
                                {
                                  i = j;
                                  if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                                    i = 0;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label540:
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void q()
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
  
  @TargetApi(11)
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutStart", true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    View localView = View.inflate(this, 2130903527, null);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131298402);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)localView.findViewById(2131296779));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new aos(this));
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131298404);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296897));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296901));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296891));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130903519, null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131298364));
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298365);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298366));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.app);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.addOnLayoutChangeListener(new aot(this));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298367));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131298403));
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33)
      {
        localObject = (FriendsManager)this.app.getManager(43);
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      else
      {
        u();
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 10000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initContentViewStart", true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.addView(this.jdField_a_of_type_AndroidViewView);
        setContentView(localView);
        getWindow().setBackgroundDrawable(null);
        d(null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutEnd", "initCardLayoutStart", false);
        return;
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
  
  private void s()
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_d_of_type_Long, l))
    {
      this.jdField_d_of_type_Long = l;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 40) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 58)) {
        break label268;
      }
      localObject = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.a())) {
        break label358;
      }
      localObject = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), Integer.valueOf(0), localObject });
      label127:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject);
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      localObject = this.app;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label401;
      }
    }
    label268:
    label401:
    for (int i = 23;; i = 24)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "vip", "logo_in", i, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
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
      label358:
      localObject = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123", new Object[] { this.app.getSid(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject });
      break label127;
    }
  }
  
  /* Error */
  private void t()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +13 -> 22
    //   12: ldc_w 356
    //   15: iconst_2
    //   16: ldc_w 1147
    //   19: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   26: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 779	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   38: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   41: getfield 707	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   49: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   52: getfield 710	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   61: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 1150	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:l	Ljava/lang/String;
    //   67: astore 11
    //   69: aload_0
    //   70: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   73: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   76: getfield 1153	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   79: astore 12
    //   81: aload_0
    //   82: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   85: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   88: getfield 1156	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:k	Ljava/lang/String;
    //   91: astore 9
    //   93: aload_0
    //   94: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   97: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   100: getfield 1158	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   103: astore 13
    //   105: aload 5
    //   107: astore 6
    //   109: aload 5
    //   111: astore 7
    //   113: aload_0
    //   114: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   117: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   120: invokestatic 789	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   123: ifeq +501 -> 624
    //   126: aload 5
    //   128: astore 6
    //   130: aload 5
    //   132: astore 7
    //   134: aload_0
    //   135: getfield 239	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   138: bipush 8
    //   140: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   143: checkcast 745	com/tencent/mobileqq/model/FriendManager
    //   146: astore_3
    //   147: aload_3
    //   148: ifnonnull +447 -> 595
    //   151: aload 5
    //   153: astore 8
    //   155: aload 10
    //   157: ifnull +803 -> 960
    //   160: aload 5
    //   162: astore_3
    //   163: aload 5
    //   165: astore 6
    //   167: aload 5
    //   169: astore 7
    //   171: aload 10
    //   173: getfield 1159	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   176: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +17 -> 196
    //   182: aload 5
    //   184: astore 6
    //   186: aload 5
    //   188: astore 7
    //   190: aload 10
    //   192: getfield 1159	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   195: astore_3
    //   196: aload_3
    //   197: astore 6
    //   199: aload_3
    //   200: astore 7
    //   202: aload_3
    //   203: astore 8
    //   205: aload 10
    //   207: getfield 1162	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   210: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   213: ifne +747 -> 960
    //   216: aload_3
    //   217: astore 6
    //   219: aload_3
    //   220: astore 7
    //   222: aload 10
    //   224: getfield 1162	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   227: astore 5
    //   229: aload_3
    //   230: astore_2
    //   231: aload 5
    //   233: astore_3
    //   234: aload_0
    //   235: getfield 239	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   238: bipush 8
    //   240: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   243: checkcast 1164	com/tencent/mobileqq/app/FriendsManagerImp
    //   246: astore 7
    //   248: aload_0
    //   249: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   252: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   255: getfield 438	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   258: astore 6
    //   260: aload 6
    //   262: astore 5
    //   264: aload 6
    //   266: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifeq +49 -> 318
    //   272: aload 6
    //   274: astore 5
    //   276: aload_0
    //   277: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   280: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   283: getfield 443	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   286: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +29 -> 318
    //   292: aload 6
    //   294: astore 5
    //   296: aload 7
    //   298: ifnull +20 -> 318
    //   301: aload 7
    //   303: aload_0
    //   304: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   307: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   310: getfield 443	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 1167	com/tencent/mobileqq/app/FriendsManagerImp:f	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 5
    //   318: aload 5
    //   320: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifne +623 -> 946
    //   326: aload 7
    //   328: ifnull +618 -> 946
    //   331: aload 7
    //   333: aload 5
    //   335: aload_0
    //   336: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   339: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   342: getfield 394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   345: invokevirtual 1170	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 5
    //   350: aload 5
    //   352: astore 4
    //   354: aload 9
    //   356: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifeq +580 -> 939
    //   362: aload_0
    //   363: invokevirtual 1173	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   366: astore 5
    //   368: aload 5
    //   370: ifnull +569 -> 939
    //   373: aload 5
    //   375: getfield 1174	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   378: astore 5
    //   380: aload 4
    //   382: astore 8
    //   384: aload 5
    //   386: astore 10
    //   388: aload_2
    //   389: astore 4
    //   391: aload_3
    //   392: astore 5
    //   394: aload_0
    //   395: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   398: bipush 7
    //   400: anewarray 407	java/lang/String
    //   403: putfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   406: aload_0
    //   407: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   410: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   413: iconst_0
    //   414: aload 4
    //   416: aastore
    //   417: aload_0
    //   418: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   421: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   424: iconst_4
    //   425: aload 5
    //   427: aastore
    //   428: aload_0
    //   429: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   432: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   435: iconst_3
    //   436: aload 10
    //   438: aastore
    //   439: aload_0
    //   440: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   443: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   446: iconst_2
    //   447: aload 12
    //   449: aastore
    //   450: aload_0
    //   451: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   454: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   457: iconst_5
    //   458: aload 11
    //   460: aastore
    //   461: aload_0
    //   462: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   465: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   468: iconst_1
    //   469: aload 8
    //   471: aastore
    //   472: aload_0
    //   473: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   476: getfield 705	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   479: bipush 6
    //   481: aload 13
    //   483: aastore
    //   484: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +107 -> 594
    //   490: new 358	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   497: astore_2
    //   498: aload_2
    //   499: ldc_w 1176
    //   502: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 862
    //   508: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 4
    //   513: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 864
    //   519: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 5
    //   524: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 866
    //   530: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 10
    //   535: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: ldc_w 868
    //   541: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 12
    //   546: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 870
    //   552: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 11
    //   557: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 872
    //   563: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 8
    //   568: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: ldc_w 874
    //   574: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 11
    //   579: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: ldc_w 356
    //   586: iconst_2
    //   587: aload_2
    //   588: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: return
    //   595: aload 5
    //   597: astore 6
    //   599: aload 5
    //   601: astore 7
    //   603: aload_3
    //   604: aload_0
    //   605: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   608: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   611: getfield 394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   614: invokeinterface 748 2 0
    //   619: astore 10
    //   621: goto -470 -> 151
    //   624: aload 5
    //   626: astore 6
    //   628: aload 5
    //   630: astore 7
    //   632: aload_0
    //   633: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   636: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   639: getfield 390	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   642: ifne +38 -> 680
    //   645: aload 5
    //   647: astore 6
    //   649: aload 5
    //   651: astore 7
    //   653: aload_0
    //   654: getfield 239	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   657: aload_0
    //   658: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   661: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   664: getfield 394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   667: invokestatic 1178	com/tencent/mobileqq/utils/ContactUtils:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   670: astore 5
    //   672: aload_2
    //   673: astore_3
    //   674: aload 5
    //   676: astore_2
    //   677: goto -443 -> 234
    //   680: aload 5
    //   682: astore 6
    //   684: aload 5
    //   686: astore 7
    //   688: aload 5
    //   690: astore_3
    //   691: aload 5
    //   693: invokestatic 403	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   696: ifeq +253 -> 949
    //   699: aload 5
    //   701: astore 6
    //   703: aload 5
    //   705: astore 7
    //   707: aload 5
    //   709: astore_3
    //   710: aload_0
    //   711: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   714: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   717: invokestatic 888	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   720: ifeq +229 -> 949
    //   723: aload 5
    //   725: astore 6
    //   727: aload 5
    //   729: astore 7
    //   731: aload_0
    //   732: getfield 239	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   735: aload_0
    //   736: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   739: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   742: getfield 394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   745: iconst_0
    //   746: invokestatic 1181	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   749: astore_3
    //   750: aload_3
    //   751: astore 6
    //   753: aload_3
    //   754: astore 7
    //   756: aload_3
    //   757: aload_0
    //   758: getfield 130	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   761: getfield 383	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   764: getfield 394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   767: invokestatic 841	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   770: istore_1
    //   771: iload_1
    //   772: ifeq +177 -> 949
    //   775: aload_2
    //   776: astore_3
    //   777: aload 8
    //   779: astore_2
    //   780: goto -546 -> 234
    //   783: astore 7
    //   785: aload_2
    //   786: astore_3
    //   787: aload 4
    //   789: astore_2
    //   790: aload_2
    //   791: astore 8
    //   793: aload_3
    //   794: astore 5
    //   796: aload 6
    //   798: astore 4
    //   800: aload 9
    //   802: astore 10
    //   804: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq -413 -> 394
    //   810: ldc_w 356
    //   813: iconst_2
    //   814: aload 7
    //   816: invokevirtual 427	java/lang/Exception:toString	()Ljava/lang/String;
    //   819: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: aload_2
    //   823: astore 8
    //   825: aload_3
    //   826: astore 5
    //   828: aload 6
    //   830: astore 4
    //   832: aload 9
    //   834: astore 10
    //   836: goto -442 -> 394
    //   839: astore 6
    //   841: aload_2
    //   842: astore_3
    //   843: aload 4
    //   845: astore_2
    //   846: aload_2
    //   847: astore 8
    //   849: aload_3
    //   850: astore 5
    //   852: aload 7
    //   854: astore 4
    //   856: aload 9
    //   858: astore 10
    //   860: invokestatic 354	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq -469 -> 394
    //   866: ldc_w 356
    //   869: iconst_2
    //   870: aload 6
    //   872: invokevirtual 1182	java/lang/Error:toString	()Ljava/lang/String;
    //   875: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: aload_2
    //   879: astore 8
    //   881: aload_3
    //   882: astore 5
    //   884: aload 7
    //   886: astore 4
    //   888: aload 9
    //   890: astore 10
    //   892: goto -498 -> 394
    //   895: astore 6
    //   897: aload_2
    //   898: astore 7
    //   900: aload 4
    //   902: astore_2
    //   903: goto -57 -> 846
    //   906: astore 6
    //   908: aload_2
    //   909: astore 7
    //   911: aload 4
    //   913: astore_2
    //   914: goto -68 -> 846
    //   917: astore 7
    //   919: aload_2
    //   920: astore 6
    //   922: aload 4
    //   924: astore_2
    //   925: goto -135 -> 790
    //   928: astore 7
    //   930: aload_2
    //   931: astore 6
    //   933: aload 4
    //   935: astore_2
    //   936: goto -146 -> 790
    //   939: aload 9
    //   941: astore 5
    //   943: goto -563 -> 380
    //   946: goto -592 -> 354
    //   949: aload_3
    //   950: astore 5
    //   952: aload_2
    //   953: astore_3
    //   954: aload 5
    //   956: astore_2
    //   957: goto -723 -> 234
    //   960: aload_2
    //   961: astore_3
    //   962: aload 8
    //   964: astore_2
    //   965: goto -731 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	FriendProfileCardActivity
    //   770	2	1	bool	boolean
    //   44	921	2	localObject1	Object
    //   146	816	3	localObject2	Object
    //   55	879	4	localObject3	Object
    //   32	923	5	localObject4	Object
    //   107	722	6	localObject5	Object
    //   839	32	6	localError1	java.lang.Error
    //   895	1	6	localError2	java.lang.Error
    //   906	1	6	localError3	java.lang.Error
    //   920	12	6	localObject6	Object
    //   111	644	7	localObject7	Object
    //   783	102	7	localException1	Exception
    //   898	12	7	localObject8	Object
    //   917	1	7	localException2	Exception
    //   928	1	7	localException3	Exception
    //   1	962	8	localObject9	Object
    //   91	849	9	str1	String
    //   4	887	10	localObject10	Object
    //   67	511	11	str2	String
    //   79	466	12	str3	String
    //   103	379	13	str4	String
    // Exception table:
    //   from	to	target	type
    //   113	126	783	java/lang/Exception
    //   134	147	783	java/lang/Exception
    //   171	182	783	java/lang/Exception
    //   190	196	783	java/lang/Exception
    //   205	216	783	java/lang/Exception
    //   222	229	783	java/lang/Exception
    //   603	621	783	java/lang/Exception
    //   632	645	783	java/lang/Exception
    //   653	672	783	java/lang/Exception
    //   691	699	783	java/lang/Exception
    //   710	723	783	java/lang/Exception
    //   731	750	783	java/lang/Exception
    //   756	771	783	java/lang/Exception
    //   113	126	839	java/lang/Error
    //   134	147	839	java/lang/Error
    //   171	182	839	java/lang/Error
    //   190	196	839	java/lang/Error
    //   205	216	839	java/lang/Error
    //   222	229	839	java/lang/Error
    //   603	621	839	java/lang/Error
    //   632	645	839	java/lang/Error
    //   653	672	839	java/lang/Error
    //   691	699	839	java/lang/Error
    //   710	723	839	java/lang/Error
    //   731	750	839	java/lang/Error
    //   756	771	839	java/lang/Error
    //   234	260	895	java/lang/Error
    //   264	272	895	java/lang/Error
    //   276	292	895	java/lang/Error
    //   301	318	895	java/lang/Error
    //   318	326	895	java/lang/Error
    //   331	350	895	java/lang/Error
    //   354	368	906	java/lang/Error
    //   373	380	906	java/lang/Error
    //   234	260	917	java/lang/Exception
    //   264	272	917	java/lang/Exception
    //   276	292	917	java/lang/Exception
    //   301	318	917	java/lang/Exception
    //   318	326	917	java/lang/Exception
    //   331	350	917	java/lang/Exception
    //   354	368	928	java/lang/Exception
    //   373	380	928	java/lang/Exception
  }
  
  private void u()
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
    case 2: 
    case 3: 
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
    case 19: 
    case 23: 
    case 24: 
    case 28: 
    case 29: 
    case 35: 
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
    case 55: 
    case 56: 
    case 57: 
    case 59: 
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
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      w();
    }
  }
  
  private void x()
  {
    try
    {
      ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130839259));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130837635);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837635);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
      }
      localException.printStackTrace();
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
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(43);
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
    if (this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "init");
    }
    this.f = true;
    Message localMessage = null;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {}
    for (;;)
    {
      if ((localMessage != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_in_client", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int), "", "");
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
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131364268);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ProfileCardUtil.a(this.app, paramLong1, paramLong2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.jdField_g_of_type_Int);
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label141;
      }
      paramCardContactInfo = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramCardContactInfo));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(paramCardContactInfo);
      }
      startActivity(paramCardContactInfo);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label141:
      a(2131363886, 1);
    }
  }
  
  public void a(Card paramCard)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())))
    {
      localObject1 = new Intent(this, VisitorsActivity.class);
      localObject2 = new Bundle();
      paramCard = (FriendManager)this.app.getManager(8);
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
    Object localObject1 = new HashMap();
    Object localObject2 = this.app.a();
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    if ((localCardHandler != null) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      long l1 = 0L;
      localObject1 = null;
      if (paramCard != null)
      {
        localObject2 = paramCard.vCookies;
        paramCard.lVoteCount += 1L;
        paramCard.bVoted = 1;
        long l2 = paramCard.lVoteCount;
        Message localMessage = Message.obtain();
        localMessage.what = 7;
        localMessage.obj = paramCard;
        l1 = l2;
        localObject1 = localObject2;
        if (this.jdField_b_of_type_AndroidOsHandler != null)
        {
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
          localObject1 = localObject2;
          l1 = l2;
        }
      }
      localCardHandler.a(Long.valueOf(this.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), (byte[])localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, l1);
      }
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
    }
    if (localCardHandler != null)
    {
      ((HashMap)localObject1).put("param_FailCode", "-203");
      StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
      a(2131363887, 1);
      return;
    }
    ((HashMap)localObject1).put("param_FailCode", "-204");
    StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
    a(2131363891, 1);
  }
  
  public void a(Card paramCard, String paramString)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a();
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    a(true);
    long l = 0L;
    if (paramCard != null)
    {
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
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      a(l, paramCard, paramString);
      return;
      r();
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo Card isNetRet = " + paramBoolean);
    }
    d(null);
    if (a(paramCard, paramBoolean)) {
      u();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramCard, paramBoolean);
    q();
    c();
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramContactCard, paramBoolean)) {
      u();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    q();
    c();
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    if (((localObject instanceof ProfileHeaderView)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
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
  
  void a(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        str = d();
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { str });
      }
      paramString = new Intent(this, MusicGeneQQBrowserActivity.class);
      paramString.putExtra("uin", this.app.a());
      paramString.putExtra("url", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label265;
      }
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      startActivity(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X8004182 ", "0X8004182", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label265:
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230726);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, paramInt);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localActionSheet.a(new aop(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(43);
    Card localCard = localFriendsManager.a(this.app.a());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
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
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label128;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label128:
      a(2131363886, 1);
    }
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void b(String paramString)
  {
    if (paramString != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        break label57;
      }
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "personal_profile", "copy_uin", 0, 0, "", "", "", "");
      return;
      label57:
      ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramString);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
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
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int k = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label230;
      }
    }
    label230:
    for (int j = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight();; j = 0)
    {
      int m = ((Resources)localObject).getDimensionPixelSize(2131492998);
      int n = Math.min(Math.max(k - j - i, m), k / 3);
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131298368);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updatePlaceHolder mScreenHeight=" + k + ",moreInfoViewHeight=" + i + ",headerViewHeight=" + j + ",minHeight=" + m + ",placeHolderViewHeight=" + n);
      }
      if (localObject != null)
      {
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, n));
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          break label235;
        }
        ProfileCardTemplate.a((View)localObject, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      }
      return;
      i = 0;
      break;
    }
    label235:
    ((View)localObject).setBackgroundColor(0);
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.e(BaseApplication.getContext())) {
          break label183;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label172;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label161;
        }
        localFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.bF |= 0x1;
        c(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label161:
      a(2131363890, 1);
      continue;
      label172:
      a(2131363889, 1);
      continue;
      label183:
      a(2131363449, 1);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(4, paramString);
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    u();
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
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      }
    }
  }
  
  public void d()
  {
    long l = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_e_of_type_Long, l))
    {
      this.jdField_e_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label287;
      }
      localObject = (TicketManager)this.app.getManager(2);
      if (localObject != null) {
        break label71;
      }
      localObject = null;
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label88;
      }
      a(2131363893, 1);
    }
    label71:
    label88:
    do
    {
      return;
      localObject = ((TicketManager)localObject).getStweb(this.app.a());
      break;
      localObject = String.format("http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localObject, "19", this.app.getSid() });
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQLevelWeb() url = " + (String)localObject);
      }
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 23, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, "getClientKey() time = " + System.currentTimeMillis());
    return;
    label287:
    Object localObject = String.format("http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getSid() });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", 24, 0, "", "", "", "");
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (!paramIntent.hasExtra("result")) {
        break label309;
      }
      Object localObject1 = paramIntent.getStringExtra("result");
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        break label216;
        break label216;
        break label216;
      }
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).get("payState");
        if ((localObject1 != null) && ("0".equals(String.valueOf(localObject1)))) {
          a(0L, null, null);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + localJSONException.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label185:
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + localException.getMessage());
        }
      }
    }
    if (paramInt1 == 1010) {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 101) && (paramInt2 == -1)) {
        finish();
      }
    }
    label785:
    for (;;)
    {
      label216:
      return;
      label309:
      if (!QLog.isColorLevel()) {
        break label185;
      }
      QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
      break label185;
      Object localObject2;
      if (paramInt1 == 1007)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        localObject2 = (FriendManager)this.app.getManager(8);
        if (localObject2 == null) {}
        for (localObject2 = null;; localObject2 = ((FriendManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = ((Card)localObject2).strNick;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = ((Card)localObject2).strNick;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = "";
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a((Card)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(((Card)localObject2).getRichStatus());
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          }
          setResult(-1, paramIntent);
          return;
        }
      }
      if (paramInt2 != -1) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        return;
      case 5: 
        paramIntent = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
        paramInt1 = Math.min(482, ProfileCardUtil.a(this));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Business_Origin", 100);
        PhotoUtils.a((Intent)localObject2, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
        return;
      case 1012: 
        if (paramIntent != null)
        {
          if (paramIntent.getBooleanExtra("finchat", false))
          {
            finish();
            return;
          }
          paramIntent = paramIntent.getStringExtra("remark");
          if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent))
          {
            c(paramIntent);
            return;
          }
        }
        break;
      case 1000: 
        setResult(-1);
        finish();
        return;
      case 800: 
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          a(2131363450, 1);
          return;
        }
        if (paramIntent != null) {}
        for (boolean bool = paramIntent.getBooleanExtra("avatar_changed", false);; bool = false)
        {
          if (!bool) {
            break label785;
          }
          paramIntent = paramIntent.getStringExtra("avatar_filepath");
          if (ProfileCardUtil.a(this.app, paramIntent))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            return;
          }
          a(2131363959, 1);
          return;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
    if (QLog.isColorLevel()) {
      this.M = System.currentTimeMillis();
    }
    Intent localIntent = getIntent();
    super.doOnCreate(paramBundle);
    if ((TextUtils.isEmpty(this.app.getAccount())) || (localIntent == null))
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
      this.h = false;
    }
    try
    {
      if (this.app.a().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
      b();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      paramBundle = (StatusManager)this.app.getManager(14);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int == 6) && (this.app.a() != null)) {
        this.app.a().addObserver(this);
      }
      long l;
      return false;
    }
    catch (Exception paramBundle)
    {
      try
      {
        a(false);
        t();
        r();
        v();
        l = System.currentTimeMillis() - this.M;
        if ((QLog.isColorLevel()) && (l > 100L)) {
          QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity onCreate used:" + l);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("doOnCreate", false);
        return true;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break label462;
        }
        QLog.e("Q.profilecard.FrdProfileCard", 2, "doOnCreate exception msg=" + paramBundle.toString());
        paramBundle.printStackTrace();
        finish();
      }
      paramBundle = paramBundle;
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, "qq_error|" + paramBundle.toString());
      }
      finish();
      return false;
    }
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
    if (this.app != null) {
      this.app.a(getClass());
    }
    if (this.jdField_a_of_type_Boolean) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
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
      if (!ProfileCardUtil.a(this.app, paramIntent)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    return;
    a(2131363959, 1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (!this.jdField_c_of_type_Boolean)
    {
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil != null)) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.toString());
      }
      StatisticCollector.a(this.app.a()).a(this.app.a(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a(), "", false);
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    addObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.f)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.a();
    localIntent.putExtra("title", getString(2131362426));
    localIntent.putExtra("nick", ContactUtils.g(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void f()
  {
    int m = 10004;
    int k = 0;
    int i = m;
    int j = k;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      j = k;
      i = m;
    case 19: 
    case 25: 
    case 26: 
    case 27: 
    case 70: 
      if ((i == 3007) && (!LBSHandler.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_b_of_type_AndroidAppDialog == null) {
          this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131364436), new aoc(this), new aod(this));
        }
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
      }
      break;
    }
    ProfileActivity.CardContactInfo localCardContactInfo;
    do
    {
      return;
      i = 3004;
      j = k;
      break;
      i = 3007;
      j = k;
      break;
      i = 3001;
      j = k;
      break;
      i = 3020;
      j = k;
      break;
      i = 3017;
      j = k;
      break;
      i = 3002;
      j = k;
      break;
      i = 3005;
      j = k;
      break;
      i = 3007;
      j = k;
      break;
      i = 3003;
      j = k;
      break;
      i = 3008;
      j = k;
      break;
      i = 3008;
      j = k;
      break;
      i = 3009;
      j = k;
      break;
      i = 3006;
      j = k;
      break;
      i = 3009;
      j = 1;
      break;
      i = 3006;
      j = 1;
      break;
      i = 3013;
      j = k;
      break;
      i = 3003;
      j = 1;
      break;
      i = 3014;
      j = k;
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
        break label813;
      }
      localCardContactInfo = a();
    } while ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0));
    String str3 = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.jdField_c_of_type_JavaLangString;
    String str2 = localCardContactInfo.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
        break label743;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
    }
    for (;;)
    {
      startActivity(AddFriendLogicActivity.a(this, 2, str3, null, i, j, str1, null, FriendProfileCardActivity.class.getName(), b_()));
      return;
      label743:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      else
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
        }
      }
    }
    label813:
    str2 = null;
    str1 = str2;
    if (3004 == i)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString.length() != 0) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        }
      }
    }
    str2 = null;
    if (TextUtils.isEmpty(null)) {
      str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, i, j, str2, null, AddContactsActivity.class.getName(), b_()));
      return;
    }
    startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, i, j, str2, null, FriendProfileCardActivity.class.getName(), b_()), 1000);
  }
  
  public void g()
  {
    ThreadPriorityManager.a(true);
    int i = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
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
        ReportController.b(this.app, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 102) {
        ReportController.b(this.app, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 103) {
        ReportController.b(this.app, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  public int getPathNodeID()
  {
    return 10;
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_d_of_type_JavaLangString);
    localStringBuilder.append("&sid=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.app.getSid(), "UTF-8"));
      localStringBuilder.append("&res_uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = (FriendsManager)this.app.getManager(43);
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
          paramMessage.nationCode = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString;
          paramMessage.mobileCode = ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;
          paramMessage.strContactName = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;
        }
        if ((paramMessage.nickName == null) || (paramMessage.nickName.length() == 0)) {
          paramMessage.nickName = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
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
        localObject1 = ProfileCardUtil.a(this.app, paramMessage);
      } while ((localObject1 == null) || (localObject2 == null));
      if ((((FriendsManager)localObject2).b(((Card)localObject1).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.a())) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      }
      paramMessage = Message.obtain();
      paramMessage.what = 4;
      paramMessage.obj = localObject1;
      paramMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      localObject2 = ((Card)localObject1).vSeed;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)) {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      break;
    }
    for (;;)
    {
      a(((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage);
      return true;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        continue;
        if ((this.app == null) || (localObject2 == null)) {
          break;
        }
        paramMessage = ((FriendsManager)localObject2).a(this.app.a());
        if (paramMessage == null) {
          break;
        }
        a(paramMessage.feedPreviewTime, paramMessage.vSeed, null);
        return true;
        localObject1 = this.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        localObject1 = this.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
      }
      paramMessage = null;
    }
  }
  
  public void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append("sid=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.app.getSid(), "UTF-8"));
      localStringBuilder.append("&hostuin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public void j()
  {
    QQAppInterface localQQAppInterface = this.app;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) {}
    for (String str = "listen_frd";; str = "listen_str")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Voice_profile", str, ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298368).setVisibility(8);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298368).setVisibility(0);
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.b(33);
  }
  
  /* Error */
  public void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   11: invokevirtual 2116	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   21: invokevirtual 2117	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 1321	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	FriendProfileCardActivity
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  public void o()
  {
    p();
    String str1;
    if (this.jdField_b_of_type_Int == 1) {
      str1 = getString(2131364262);
    }
    for (String str2 = "成为会员之后，即可使用该名片";; str2 = "成为超级会员之后，即可使用该名片")
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, str1, str2, 2131364263, 2131364264, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      str1 = getString(2131364261);
    }
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      localObject = (FriendsManager)this.app.getManager(43);
      if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label288;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label306;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
      label104:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label311;
      }
    }
    label288:
    label306:
    label311:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl;; localObject = "")
    {
      if ((this.jdField_b_of_type_Long != l) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.jdField_b_of_type_JavaLangString))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "onRestart  initContentView current templateId= " + this.jdField_b_of_type_Long + ", new templateId = " + l);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_g_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initContentViewStart", true);
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 10000L);
        }
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_Int = 0;
        a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = ((FriendsManager)localObject).a(c());
      break;
      l = 0L;
      break label104;
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new aof(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */