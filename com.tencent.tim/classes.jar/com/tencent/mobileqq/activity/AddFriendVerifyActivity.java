package com.tencent.mobileqq.activity;

import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import acci;
import accn;
import acfd;
import acff;
import acfp;
import achg;
import acms;
import acnd;
import acny;
import aeie;
import aemk;
import afxv;
import ahkr;
import aija;
import ajdq;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import aofk;
import aofk.b;
import aofv;
import aprb.a;
import apuh;
import aqdj;
import aqek;
import aqfr;
import aqft;
import aqgv;
import aqha;
import aqho;
import aqhu;
import aqiw;
import aqjb;
import aqju;
import aqsr;
import arhz;
import asgx;
import ashx;
import ausj;
import auss;
import avfw;
import avfw.d;
import azcl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.mobileqq.vas.PobingDecoder.a;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import udx;
import udy;
import udz;
import uea;
import ueb;
import uec;
import ued;
import uee;
import uef;
import ueg;
import ueh;
import uei;
import uej;
import uek;
import uel;
import uem;
import uen;
import ueo;
import uep;
import ueq;
import uer;
import ues;
import ueu;
import uev;
import uew;
import uex;
import uey;
import wja;
import xko;
import xko.a;
import yqv;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, aprb.a, xko.a
{
  public static final boolean aRi = AppSetting.enableTalkBack;
  private static int bmZ = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
  private TextView BE;
  private TextView BF;
  private TextView BG;
  private TextView BH;
  private TextView BI;
  public TextView BJ = null;
  TextView BK;
  public TextView BL;
  private TextView BM;
  private TextView BN;
  private TextView BO;
  private TextView BP;
  TextView BQ = null;
  private long Fe;
  private long Ff;
  private Bundle X;
  private ajdq<PobingDecoder.a> jdField_a_of_type_Ajdq = new uep(this);
  a jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  public KplRoleInfo.WZRYUIinfo a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  private xko jdField_a_of_type_Xko;
  protected String aKI;
  public String aKJ = "";
  public String aKK;
  protected boolean aRj;
  public boolean aRk;
  private boolean aRl;
  private URLImageView ae;
  public EditText aq;
  private EditText ar;
  public EditText as = null;
  private String authKey;
  private String authSig;
  private acnd jdField_b_of_type_Acnd = new ueh(this);
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new uer(this);
  private ashx jdField_b_of_type_Ashx = new ueg(this);
  a jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  private int bDA;
  private int bDB;
  private int bDC = 2000;
  private int bDD = 1000;
  private int bDE;
  private int bDF;
  private acfd c = new uef(this);
  private accn cardObserver = new uee(this);
  public InputMethodManager d;
  private TextWatcher e = new ued(this);
  private int eK = -1;
  LinearLayout fK;
  LinearLayout fL;
  private LinearLayout fM;
  private LinearLayout fN;
  private LinearLayout fO;
  private RelativeLayout gl;
  protected FormSwitchItem j;
  private String lS;
  public Handler mHandler = new uej(this);
  private boolean mIsUploading;
  private String mMd5;
  private View.OnClickListener mOnClickListener = new uek(this);
  private String mPicUrl;
  private String mRemark = "";
  public String mTroopUin;
  private int mType;
  private String mUin;
  private ArrayList<EditText> oJ = new ArrayList();
  private ArrayList<PhoneContact> oK = new ArrayList();
  private ImageView pk;
  private ImageView pl;
  private ImageView pm;
  public ImageView pn = null;
  private View rp;
  private RecyclerView s;
  public arhz u;
  private Uri v;
  public aqju x;
  private Switch y;
  public Dialog z;
  
  private boolean OD()
  {
    int i = getIntent().getExtras().getInt("source_id", 3999);
    return (i == 3003) || (i == 3006) || (i == 3007) || (i == 3009) || (i == 3013);
  }
  
  private boolean OE()
  {
    return getSharedPreferences("last_verify_msg", 0).getBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), false);
  }
  
  private boolean OF()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.Fe;
    this.Fe = l1;
    if ((l2 > 1000L) && (this.bDD != 1001) && (!this.aRl)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AddFriendVerifyActivity", 1, String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", new Object[] { Long.valueOf(l2), Integer.valueOf(this.bDD), Boolean.valueOf(this.aRl), Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  private void Qq()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(2131719499, 5);
    localausj.addButton(2131719488, 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new uel(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void bFH()
  {
    getSharedPreferences("last_verify_msg", 0).edit().putBoolean("add_friend_verify_msg_modify_flag" + this.app.getAccount(), true);
  }
  
  private void bFI()
  {
    if (yqv.a(this.app) != null)
    {
      int i = getIntent().getIntExtra("friend_setting", 0);
      int k = getIntent().getIntExtra("source_id", 3999);
      String str = getIntent().getExtras().getString("extra");
      int m = getIntent().getIntExtra("sub_source_id", 0);
      yqv.a(this.app).b(this.mUin, i, k, m, str);
    }
  }
  
  private void bFJ()
  {
    if ((this.j == null) || (this.j.getVisibility() == 8)) {
      return;
    }
    Switch localSwitch = this.j.a();
    localSwitch.setTag(Integer.valueOf(1));
    this.aRk = ((TroopManager)this.app.getManager(52)).kx(this.mTroopUin);
    localSwitch.setChecked(this.aRk);
    if (this.aRk == true) {}
    for (String str = getString(2131698419);; str = getString(2131698423))
    {
      localSwitch.setContentDescription(str);
      return;
    }
  }
  
  private void ba(int paramInt, String paramString)
  {
    if (this.bDB == 3090) {}
    try
    {
      ahkr.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AddFriendVerifyActivity", 1, "feedBackToGameSDK error = " + paramString);
    }
  }
  
  private void g(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable == null) || (this.app == null) || (this.pn == null)) {
      return;
    }
    Bitmap localBitmap = aqhu.g(paramURLDrawable);
    if (paramURLDrawable.getStatus() == 1)
    {
      paramURLDrawable = this.app;
      paramURLDrawable = QQAppInterface.getCircleFaceBitmap(localBitmap, 50, 50);
      this.pn.setImageDrawable(new BitmapDrawable(paramURLDrawable));
      return;
    }
    paramURLDrawable.setURLDrawableListener(new uea(this));
  }
  
  private void g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.u.setMessage(2131719519);
    this.u.show();
    acms localacms = (acms)this.app.getBusinessHandler(20);
    long l1 = Long.parseLong(this.app.getCurrentAccountUin());
    long l2 = Long.parseLong(paramString1);
    localacms.a(paramString1, paramString2, paramInt1, this.authKey, this.authSig, a(this.bDE, this.mMd5, paramString2, l1, l2, paramInt2), this.mPicUrl);
    if (!TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(this.mMd5))
      {
        paramString2 = "2";
        anot.a(this.app, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, paramString1, paramString2, "", "");
        aqfr.o(this.mTroopUin, 1, 0, paramInt1);
        if (!this.aRk) {
          break label334;
        }
        anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "set_open", 0, 0, paramString1, "", "", "");
      }
    }
    for (;;)
    {
      if ((this.aRj == true) && (!this.aRk)) {
        anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "close", 0, 0, paramString1, "", "", "");
      }
      if ((!this.aRj) && (this.aRk == true)) {
        anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "open", 0, 0, paramString1, "", "", "");
      }
      this.bDD = 1001;
      ((achg)this.app.getManager(159)).Eg(this.mUin);
      return;
      paramString2 = "0";
      break;
      if (!TextUtils.isEmpty(this.mMd5))
      {
        paramString2 = "1";
        break;
      }
      paramString2 = "3";
      break;
      label334:
      anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
    }
  }
  
  private String k(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  private String oK()
  {
    Object localObject3 = ((acff)this.app.getManager(51)).b(this.app.getCurrentUin());
    Object localObject2 = "";
    String str = "";
    Object localObject1 = "";
    int k = 0;
    int i;
    Object localObject4;
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AddFriendVerifyActivity", 2, "initParams: mFriendCard != null");
      }
      i = ((Card)localObject3).shGender;
      if (((Card)localObject3).shGender == 0)
      {
        localObject1 = getString(2131695654);
        k = ((Card)localObject3).age;
        str = ((Card)localObject3).strProvince;
        localObject2 = ((Card)localObject3).strCity;
        k = ((Card)localObject3).constellation;
        localObject4 = aqek.fY(((Card)localObject3).constellation);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(str);
      localObject4 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject4 = "";
      }
      if ((bool) && (k == 0) && (i == -1)) {
        localObject1 = acfp.m(2131702053);
      }
      for (;;)
      {
        return (String)localObject1 + "~";
        localObject1 = localObject2;
        if (((Card)localObject3).shGender != 1) {
          break;
        }
        localObject1 = getString(2131693477);
        break;
        if ((bool) && (k == 0)) {
          localObject1 = acfp.m(2131702071);
        } else if ((bool) && (i == -1)) {
          localObject1 = acfp.m(2131702068);
        } else if ((k == 0) && (i == -1)) {
          localObject1 = acfp.m(2131702059) + str + (String)localObject4;
        } else if (k == 0) {
          localObject1 = acfp.m(2131702080) + str + (String)localObject4;
        } else if (i == -1) {
          localObject1 = acfp.m(2131702061) + str + (String)localObject4 + acfp.m(2131702067) + (String)localObject2 + acfp.m(2131702056);
        } else if (bool) {
          localObject1 = (String)localObject2 + (String)localObject3 + acfp.m(2131702057);
        } else {
          localObject1 = acfp.m(2131702073) + str + (String)localObject4 + acfp.m(2131702052) + (String)localObject2 + (String)localObject3 + acfp.m(2131702076);
        }
      }
      localObject3 = "";
      localObject2 = "";
      i = -1;
    }
  }
  
  /* Error */
  public static void uR(String paramString)
  {
    // Byte code:
    //   0: new 749	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 751	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 754	java/io/File:getPath	()Ljava/lang/String;
    //   15: sipush 640
    //   18: invokestatic 757	aqhu:a	(Ljava/lang/String;I)Landroid/graphics/BitmapFactory$Options;
    //   21: astore_2
    //   22: aload 5
    //   24: invokevirtual 754	java/io/File:getPath	()Ljava/lang/String;
    //   27: aload_2
    //   28: invokestatic 763	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload_2
    //   36: astore_3
    //   37: aload_0
    //   38: invokestatic 769	apuh:U	(Ljava/lang/String;)I
    //   41: istore_1
    //   42: aload_2
    //   43: astore_3
    //   44: iload_1
    //   45: ifeq +34 -> 79
    //   48: aload_2
    //   49: astore 4
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: iload_1
    //   55: i2f
    //   56: invokestatic 772	aqhu:d	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   59: astore_0
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: ifnull +16 -> 79
    //   66: aload_0
    //   67: astore 4
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: aload 5
    //   74: invokestatic 776	aqhu:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   77: aload_0
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 781	android/graphics/Bitmap:recycle	()V
    //   87: return
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 784	java/lang/OutOfMemoryError:printStackTrace	()V
    //   93: return
    //   94: astore_0
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 785	java/io/IOException:printStackTrace	()V
    //   102: aload 4
    //   104: ifnull -17 -> 87
    //   107: aload 4
    //   109: invokevirtual 781	android/graphics/Bitmap:recycle	()V
    //   112: return
    //   113: astore_0
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 781	android/graphics/Bitmap:recycle	()V
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   41	14	1	i	int
    //   21	33	2	localObject1	Object
    //   36	83	3	localObject2	Object
    //   33	75	4	localObject3	Object
    //   8	65	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   22	32	88	java/lang/OutOfMemoryError
    //   37	42	94	java/io/IOException
    //   53	60	94	java/io/IOException
    //   71	77	94	java/io/IOException
    //   37	42	113	finally
    //   53	60	113	finally
    //   71	77	113	finally
    //   98	102	113	finally
  }
  
  private void uU(String paramString)
  {
    if ((this.z != null) && (this.z.isShowing()) && (this.z.getWindow() != null)) {}
    try
    {
      this.z.dismiss();
      label34:
      this.z = aqha.a(this, paramString, 0, 2131721079, null, new ueq(this, paramString));
      try
      {
        this.z.show();
        return;
      }
      catch (Throwable paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AddFriendVerifyActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  private void uV(String paramString)
  {
    runOnUiThread(new AddFriendVerifyActivity.30(this));
  }
  
  private void vI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "switchTroopShowExternal");
    }
    if (aqiw.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131698425, 0).show(getTitleBarHeight());
      bFJ();
    }
    while (((TroopManager)this.app.getManager(52) == null) || (this.mTroopUin == null)) {
      return;
    }
    ((acms)this.app.getBusinessHandler(20)).h(this.aKI, this.mTroopUin, paramBoolean, true);
  }
  
  private void zI(int paramInt)
  {
    String str3 = acfp.m(2131702086);
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      QLog.e("AddFriendVerifyActivity", 1, "showPayDialog, UNKOWN errorCode: " + paramInt);
      return;
    case 4002: 
      str2 = acfp.m(2131702048);
      paramInt = 1;
      str1 = "LTMCLUB";
    case 5002: 
    case 12002: 
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4FA", paramInt, 0, "", "", "", "");
        String str4 = String.format(acfp.m(2131702070), new Object[] { str2, str2 });
        str2 = String.format(acfp.m(2131702074), new Object[] { str2 });
        aqha.a(this, 230, str3, str4, acfp.m(2131702085), str2, new uem(this, str1, paramInt), new uen(this)).show();
        return;
        str2 = acfp.m(2131702055);
        paramInt = 2;
        str1 = "CJCLUBT";
        continue;
        str2 = acfp.m(2131702054);
        paramInt = 3;
        str1 = "SVHHZLH";
      }
    }
    QQToast.a(this, 1, acfp.m(2131702072), 1).show();
  }
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      if ((paramBoolean) && ((paramObject instanceof UniGetRsp)))
      {
        paramObject = ((UniGetRsp)paramObject).uniBusinessItemList.iterator();
        while (paramObject.hasNext())
        {
          UniBusinessItem localUniBusinessItem = (UniBusinessItem)paramObject.next();
          if (localUniBusinessItem.appid == 40)
          {
            this.bDC = localUniBusinessItem.itemid;
            this.jdField_a_of_type_Xko.setSelected(localUniBusinessItem.itemid);
            QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + this.bDC);
            return;
          }
        }
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP nothing: " + this.bDC);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + paramBoolean + " data=" + paramObject);
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)))
    {
      paramObject = (UniSetRsp)paramObject;
      if (paramObject.ret == 0)
      {
        this.bDC = paramInt2;
        QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP success: " + this.bDC);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramObject.ret + " msg:" + paramObject.errmsg);
      zI(paramObject.ret);
      this.jdField_a_of_type_Xko.setSelected(this.bDC);
      return;
    }
    QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_SET_RSP: " + paramBoolean + " data=" + paramObject);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramJSONObject == null);
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
        paramJSONObject = (JSONObject)paramJSONObject.get("result");
        if ((paramInt != 0) || (paramJSONObject == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
        }
        paramBundle = (JSONObject)paramJSONObject.get("basics");
        Object localObject2;
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (!QLog.isColorLevel()) {
                break label767;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, basics name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
              break label767;
            }
          }
        }
        paramBundle = (JSONObject)paramJSONObject.get("friendlink");
        if (paramBundle != null)
        {
          paramBundle = (JSONArray)paramBundle.get("datas");
          if (paramBundle != null)
          {
            paramInt = 0;
            if (paramInt < paramBundle.length())
            {
              localObject2 = (JSONObject)paramBundle.get(paramInt);
              str = (String)((JSONObject)localObject2).get("name");
              i = ((Integer)((JSONObject)localObject2).get("state")).intValue();
              localObject1 = (String)((JSONObject)localObject2).get("api");
              localObject2 = (String)((JSONObject)localObject2).get("msg");
              if (("add_friend".equals(localObject1)) && (i != 1)) {
                uV(getActivity().getResources().getString(2131721369));
              }
              if (!QLog.isColorLevel()) {
                break label774;
              }
              QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
              break label774;
            }
          }
        }
        paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, appid =" + paramInt + "\n");
        }
        paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
        if (paramJSONObject == null) {
          break;
        }
        paramJSONObject = (JSONArray)paramJSONObject.get("datas");
        if (paramJSONObject == null) {
          break;
        }
        paramInt = 0;
        if (paramInt >= paramJSONObject.length()) {
          break;
        }
        Object localObject1 = (JSONObject)paramJSONObject.get(paramInt);
        paramBundle = (String)((JSONObject)localObject1).get("name");
        int i = ((Integer)((JSONObject)localObject1).get("state")).intValue();
        String str = (String)((JSONObject)localObject1).get("api");
        localObject1 = (String)((JSONObject)localObject1).get("msg");
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i + " api = " + str + " msg= " + (String)localObject1 + "\n");
        }
        paramInt += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramJSONObject) {}
      QLog.d("AddFriendVerifyActivity", 2, "checkApiState onResult " + paramJSONObject.toString());
      return;
      label767:
      paramInt += 1;
      continue;
      label774:
      paramInt += 1;
    }
  }
  
  /* Error */
  public byte[] a(int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 630	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: aload_3
    //   8: invokestatic 630	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 1041	tencent/im/msg/im_msg_body$RichText
    //   19: dup
    //   20: invokespecial 1042	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: invokestatic 630	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +153 -> 181
    //   31: new 1044	tencent/im/msg/im_msg_body$Elem
    //   34: dup
    //   35: invokespecial 1045	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   38: astore 10
    //   40: new 1047	tencent/im/msg/im_msg_body$Text
    //   43: dup
    //   44: invokespecial 1048	tencent/im/msg/im_msg_body$Text:<init>	()V
    //   47: astore 11
    //   49: aload 11
    //   51: getfield 1052	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: aload_3
    //   55: invokestatic 1058	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   58: invokevirtual 1064	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   61: aload 10
    //   63: getfield 1068	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   66: aload 11
    //   68: invokevirtual 1071	tencent/im/msg/im_msg_body$Text:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   71: aload_2
    //   72: getfield 1075	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: aload 10
    //   77: invokevirtual 1080	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   80: new 1044	tencent/im/msg/im_msg_body$Elem
    //   83: dup
    //   84: invokespecial 1045	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: getfield 1084	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   94: aload_3
    //   95: iload 8
    //   97: invokestatic 1087	acms:a	(Ljava/lang/String;I)Ltencent/im/msg/im_msg_body$RichMsg;
    //   100: invokevirtual 1090	tencent/im/msg/im_msg_body$RichMsg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   103: aload_2
    //   104: getfield 1075	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   107: aload 10
    //   109: invokevirtual 1080	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   112: new 1044	tencent/im/msg/im_msg_body$Elem
    //   115: dup
    //   116: invokespecial 1045	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   119: astore_3
    //   120: new 1092	tencent/im/msg/im_msg_body$GeneralFlags
    //   123: dup
    //   124: invokespecial 1093	tencent/im/msg/im_msg_body$GeneralFlags:<init>	()V
    //   127: astore 10
    //   129: new 1095	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   132: dup
    //   133: invokespecial 1096	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   136: astore 11
    //   138: aload 11
    //   140: getfield 1100	tencent/im/msg/hummer/resv/generalflags$ResvAttr:uint32_troop_pobing_template	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iload 8
    //   145: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   148: aload 10
    //   150: getfield 1107	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: aload 11
    //   155: invokevirtual 1111	tencent/im/msg/hummer/resv/generalflags$ResvAttr:toByteArray	()[B
    //   158: invokestatic 1115	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 1064	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   164: aload_3
    //   165: getfield 1119	tencent/im/msg/im_msg_body$Elem:general_flags	Ltencent/im/msg/im_msg_body$GeneralFlags;
    //   168: aload 10
    //   170: invokevirtual 1120	tencent/im/msg/im_msg_body$GeneralFlags:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   173: aload_2
    //   174: getfield 1075	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: aload_3
    //   178: invokevirtual 1080	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: new 1122	tencent/im/msg/im_msg_body$MsgBody
    //   184: dup
    //   185: invokespecial 1123	tencent/im/msg/im_msg_body$MsgBody:<init>	()V
    //   188: astore_3
    //   189: aload_3
    //   190: getfield 1127	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   193: aload_2
    //   194: invokevirtual 1128	tencent/im/msg/im_msg_body$RichText:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   197: new 1130	tencent/im/msg/im_msg$Msg
    //   200: dup
    //   201: invokespecial 1131	tencent/im/msg/im_msg$Msg:<init>	()V
    //   204: astore 11
    //   206: aload 11
    //   208: getfield 1135	tencent/im/msg/im_msg$Msg:body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   211: aload_3
    //   212: invokevirtual 1136	tencent/im/msg/im_msg_body$MsgBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   215: new 1138	tencent/im/msg/im_msg$Group
    //   218: dup
    //   219: invokespecial 1139	tencent/im/msg/im_msg$Group:<init>	()V
    //   222: astore_3
    //   223: new 1141	tencent/im/msg/im_common$User
    //   226: dup
    //   227: invokespecial 1142	tencent/im/msg/im_common$User:<init>	()V
    //   230: astore 12
    //   232: aload 12
    //   234: getfield 1146	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   237: lload 4
    //   239: invokevirtual 1151	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   242: aload 12
    //   244: getfield 1154	tencent/im/msg/im_common$User:app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   247: sipush 1001
    //   250: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   253: aload 12
    //   255: getfield 1157	tencent/im/msg/im_common$User:instance_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: iconst_1
    //   259: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload 12
    //   264: getfield 1161	tencent/im/msg/im_common$User:client_ip	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   267: invokestatic 1165	cz:s	()J
    //   270: l2i
    //   271: invokevirtual 1168	com/tencent/mobileqq/pb/PBFixed32Field:set	(I)V
    //   274: aload 12
    //   276: getfield 1171	tencent/im/msg/im_common$User:platform_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: bipush 109
    //   281: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   284: aload 12
    //   286: getfield 1174	tencent/im/msg/im_common$User:version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokestatic 1177	com/tencent/common/config/AppSetting:getAppId	()I
    //   292: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   295: aload_3
    //   296: getfield 1181	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   299: aload 12
    //   301: invokevirtual 1182	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   304: aload_3
    //   305: getfield 1181	tencent/im/msg/im_msg$Group:sender	Ltencent/im/msg/im_common$User;
    //   308: getfield 1146	tencent/im/msg/im_common$User:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   311: lload 4
    //   313: invokevirtual 1151	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   316: new 1184	tencent/im/msg/im_common$GroupInfo
    //   319: dup
    //   320: invokespecial 1185	tencent/im/msg/im_common$GroupInfo:<init>	()V
    //   323: astore_2
    //   324: aload_3
    //   325: getfield 1189	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   328: aload_2
    //   329: invokevirtual 1190	tencent/im/msg/im_common$GroupInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   332: aload_3
    //   333: getfield 1189	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   336: getfield 1193	tencent/im/msg/im_common$GroupInfo:group_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   339: lload 6
    //   341: invokevirtual 1151	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   344: aload_3
    //   345: getfield 1189	tencent/im/msg/im_msg$Group:group_info	Ltencent/im/msg/im_common$GroupInfo;
    //   348: getfield 1197	tencent/im/msg/im_common$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   351: iconst_1
    //   352: invokevirtual 1200	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   355: new 1202	tencent/im/msg/im_msg$RoutingHead
    //   358: dup
    //   359: invokespecial 1203	tencent/im/msg/im_msg$RoutingHead:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: getfield 1207	tencent/im/msg/im_msg$RoutingHead:group	Ltencent/im/msg/im_msg$Group;
    //   367: aload_3
    //   368: invokevirtual 1208	tencent/im/msg/im_msg$Group:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   371: new 1210	tencent/im/msg/im_msg$ContentHead
    //   374: dup
    //   375: invokespecial 1211	tencent/im/msg/im_msg$ContentHead:<init>	()V
    //   378: astore_3
    //   379: aload_3
    //   380: getfield 1214	tencent/im/msg/im_msg$ContentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: astore 10
    //   385: getstatic 155	com/tencent/mobileqq/activity/AddFriendVerifyActivity:bmZ	I
    //   388: istore_1
    //   389: iload_1
    //   390: iconst_1
    //   391: iadd
    //   392: putstatic 155	com/tencent/mobileqq/activity/AddFriendVerifyActivity:bmZ	I
    //   395: aload 10
    //   397: iload_1
    //   398: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   401: new 1216	tencent/im/msg/im_msg$MsgHead
    //   404: dup
    //   405: invokespecial 1217	tencent/im/msg/im_msg$MsgHead:<init>	()V
    //   408: astore 10
    //   410: aload 10
    //   412: getfield 1221	tencent/im/msg/im_msg$MsgHead:content_head	Ltencent/im/msg/im_msg$ContentHead;
    //   415: aload_3
    //   416: invokevirtual 1222	tencent/im/msg/im_msg$ContentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   419: aload 10
    //   421: getfield 1226	tencent/im/msg/im_msg$MsgHead:routing_head	Ltencent/im/msg/im_msg$RoutingHead;
    //   424: aload_2
    //   425: invokevirtual 1227	tencent/im/msg/im_msg$RoutingHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   428: aload 11
    //   430: getfield 1231	tencent/im/msg/im_msg$Msg:head	Ltencent/im/msg/im_msg$MsgHead;
    //   433: aload 10
    //   435: invokevirtual 1232	tencent/im/msg/im_msg$MsgHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   438: new 1234	tencent/im/msg/im_imagent$Signature
    //   441: dup
    //   442: invokespecial 1235	tencent/im/msg/im_imagent$Signature:<init>	()V
    //   445: astore 13
    //   447: aload 13
    //   449: getfield 1238	tencent/im/msg/im_imagent$Signature:key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: iconst_1
    //   453: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   456: aload 13
    //   458: getfield 1241	tencent/im/msg/im_imagent$Signature:session_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: sipush 256
    //   464: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   467: aload_0
    //   468: getfield 273	com/tencent/mobileqq/activity/AddFriendVerifyActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: invokestatic 1247	assi:n	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   474: astore_2
    //   475: aload_2
    //   476: invokestatic 630	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: istore 9
    //   481: aload_2
    //   482: astore 10
    //   484: iload 9
    //   486: ifeq +51 -> 537
    //   489: aconst_null
    //   490: areturn
    //   491: astore_3
    //   492: ldc 170
    //   494: astore_2
    //   495: aload_2
    //   496: astore 10
    //   498: invokestatic 692	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +36 -> 537
    //   504: ldc_w 297
    //   507: iconst_2
    //   508: new 262	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 1249
    //   518: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_3
    //   522: invokevirtual 1252	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 1255	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_2
    //   535: astore 10
    //   537: aload 13
    //   539: getfield 1258	tencent/im/msg/im_imagent$Signature:session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   542: aload 10
    //   544: invokestatic 1058	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   547: invokevirtual 1064	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   550: new 1260	tencent/im/msg/im_imagent$ImAgentHead
    //   553: dup
    //   554: invokespecial 1261	tencent/im/msg/im_imagent$ImAgentHead:<init>	()V
    //   557: astore_2
    //   558: aload_2
    //   559: getfield 1264	tencent/im/msg/im_imagent$ImAgentHead:command	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   562: iconst_3
    //   563: invokevirtual 1200	com/tencent/mobileqq/pb/PBEnumField:set	(I)V
    //   566: aload_2
    //   567: getfield 1268	tencent/im/msg/im_imagent$ImAgentHead:signature	Ltencent/im/msg/im_imagent$Signature;
    //   570: aload 13
    //   572: invokevirtual 1269	tencent/im/msg/im_imagent$Signature:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   575: aload_2
    //   576: getfield 1272	tencent/im/msg/im_imagent$ImAgentHead:req_user	Ltencent/im/msg/im_common$User;
    //   579: aload 12
    //   581: invokevirtual 1182	tencent/im/msg/im_common$User:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   584: aload_2
    //   585: getfield 1273	tencent/im/msg/im_imagent$ImAgentHead:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   588: astore_3
    //   589: getstatic 155	com/tencent/mobileqq/activity/AddFriendVerifyActivity:bmZ	I
    //   592: istore_1
    //   593: iload_1
    //   594: iconst_1
    //   595: iadd
    //   596: putstatic 155	com/tencent/mobileqq/activity/AddFriendVerifyActivity:bmZ	I
    //   599: aload_3
    //   600: iload_1
    //   601: invokevirtual 1104	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   604: new 1275	tencent/im/msg/im_msg$MsgSendReq
    //   607: dup
    //   608: invokespecial 1276	tencent/im/msg/im_msg$MsgSendReq:<init>	()V
    //   611: astore_3
    //   612: aload_3
    //   613: getfield 1279	tencent/im/msg/im_msg$MsgSendReq:msg	Ltencent/im/msg/im_msg$Msg;
    //   616: aload 11
    //   618: invokevirtual 1280	tencent/im/msg/im_msg$Msg:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   621: new 1282	tencent/im/msg/im_imagent$ImAgentPackage
    //   624: dup
    //   625: invokespecial 1283	tencent/im/msg/im_imagent$ImAgentPackage:<init>	()V
    //   628: astore 10
    //   630: aload 10
    //   632: getfield 1286	tencent/im/msg/im_imagent$ImAgentPackage:head	Ltencent/im/msg/im_imagent$ImAgentHead;
    //   635: aload_2
    //   636: invokevirtual 1287	tencent/im/msg/im_imagent$ImAgentHead:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   639: aload 10
    //   641: getfield 1291	tencent/im/msg/im_imagent$ImAgentPackage:msg_send_req	Ltencent/im/msg/im_msg$MsgSendReq;
    //   644: aload_3
    //   645: invokevirtual 1292	tencent/im/msg/im_msg$MsgSendReq:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   648: aload 10
    //   650: invokevirtual 1293	tencent/im/msg/im_imagent$ImAgentPackage:toByteArray	()[B
    //   653: astore_2
    //   654: new 1295	java/io/ByteArrayOutputStream
    //   657: dup
    //   658: aload_2
    //   659: arraylength
    //   660: bipush 8
    //   662: iadd
    //   663: invokespecial 1297	java/io/ByteArrayOutputStream:<init>	(I)V
    //   666: astore_3
    //   667: new 1299	java/io/DataOutputStream
    //   670: dup
    //   671: aload_3
    //   672: invokespecial 1302	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   675: astore 10
    //   677: aload 10
    //   679: aload_2
    //   680: arraylength
    //   681: bipush 8
    //   683: iadd
    //   684: invokevirtual 1305	java/io/DataOutputStream:writeInt	(I)V
    //   687: aload 10
    //   689: bipush 123
    //   691: invokevirtual 1308	java/io/DataOutputStream:write	(I)V
    //   694: aload 10
    //   696: bipush 123
    //   698: invokevirtual 1308	java/io/DataOutputStream:write	(I)V
    //   701: aload 10
    //   703: aload_2
    //   704: invokevirtual 1311	java/io/DataOutputStream:write	([B)V
    //   707: aload 10
    //   709: bipush 125
    //   711: invokevirtual 1308	java/io/DataOutputStream:write	(I)V
    //   714: aload 10
    //   716: bipush 125
    //   718: invokevirtual 1308	java/io/DataOutputStream:write	(I)V
    //   721: aload_3
    //   722: invokevirtual 1312	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   725: astore 11
    //   727: new 262	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 1314
    //   737: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: astore 12
    //   742: aload 11
    //   744: ifnonnull +39 -> 783
    //   747: ldc_w 1316
    //   750: astore_2
    //   751: ldc_w 297
    //   754: iconst_1
    //   755: aload 12
    //   757: aload_2
    //   758: invokevirtual 547	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 549	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: aload_3
    //   768: invokevirtual 1318	java/io/ByteArrayOutputStream:close	()V
    //   771: aload 10
    //   773: invokevirtual 1319	java/io/DataOutputStream:close	()V
    //   776: aload 11
    //   778: areturn
    //   779: astore_2
    //   780: aload 11
    //   782: areturn
    //   783: aload 11
    //   785: arraylength
    //   786: istore_1
    //   787: iload_1
    //   788: invokestatic 312	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: astore_2
    //   792: goto -41 -> 751
    //   795: astore_2
    //   796: aload_2
    //   797: invokevirtual 1320	java/lang/Exception:printStackTrace	()V
    //   800: aload_3
    //   801: invokevirtual 1318	java/io/ByteArrayOutputStream:close	()V
    //   804: aload 10
    //   806: invokevirtual 1319	java/io/DataOutputStream:close	()V
    //   809: aconst_null
    //   810: areturn
    //   811: astore_2
    //   812: aload_3
    //   813: invokevirtual 1318	java/io/ByteArrayOutputStream:close	()V
    //   816: aload 10
    //   818: invokevirtual 1319	java/io/DataOutputStream:close	()V
    //   821: aload_2
    //   822: athrow
    //   823: astore_3
    //   824: goto -3 -> 821
    //   827: astore_2
    //   828: goto -19 -> 809
    //   831: astore_3
    //   832: goto -337 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	this	AddFriendVerifyActivity
    //   0	835	1	paramInt1	int
    //   0	835	2	paramString1	String
    //   0	835	3	paramString2	String
    //   0	835	4	paramLong1	long
    //   0	835	6	paramLong2	long
    //   0	835	8	paramInt2	int
    //   479	6	9	bool	boolean
    //   38	779	10	localObject1	Object
    //   47	737	11	localObject2	Object
    //   230	526	12	localObject3	Object
    //   445	126	13	localSignature	tencent.im.msg.im_imagent.Signature
    // Exception table:
    //   from	to	target	type
    //   467	475	491	java/lang/InterruptedException
    //   767	776	779	java/lang/Exception
    //   677	742	795	java/lang/Exception
    //   751	767	795	java/lang/Exception
    //   783	787	795	java/lang/Exception
    //   677	742	811	finally
    //   751	767	811	finally
    //   783	787	811	finally
    //   796	800	811	finally
    //   812	821	823	java/lang/Exception
    //   800	809	827	java/lang/Exception
    //   475	481	831	java/lang/InterruptedException
  }
  
  public void aN(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "saveVerifyMsg return from wzry");
      }
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.as.getText().toString();
    if (AutoRemarkActivity.bC(paramEditable) > 32)
    {
      int i = this.as.getSelectionStart();
      paramEditable = AutoRemarkActivity.hb(paramEditable);
      this.as.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.as.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.enableTalkBack) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131694937) + this.as.getText().toString());
    }
  }
  
  public void b(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (!aqiw.isNetSupport(this)) {}
    int m;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131696348), 0).show(getTitleBarHeight());
      for (;;)
      {
        return;
        if (!isFinishing())
        {
          if (this.u == null)
          {
            this.u = new arhz(this, getTitleBarHeight());
            this.u.setOnDismissListener(new ueb(this));
          }
          this.u.setMessage(2131719519);
          this.u.setCancelable(true);
          this.u.setCanceledOnTouchOutside(false);
          try
          {
            this.u.show();
            Intent localIntent = getIntent();
            m = localIntent.getIntExtra("sub_source_id", 0);
            int k = localIntent.getIntExtra("friend_setting", 0);
            int i = k;
            if (k == 3) {
              i = 100;
            }
            boolean bool = localIntent.getBooleanExtra("contact_bothway", false);
            String str = localIntent.getStringExtra("src_name");
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.mUin, localIntent.getStringExtra("extra"), i, (byte)this.bDA, paramString1, this.bDB, m, true, paramArrayOfByte, bool, this.as.getText().toString(), str, localIntent.getByteExtra("show_my_card", (byte)0), paramString2, localIntent.getBundleExtra("flc_extra_param"));
            if (!AutoRemarkActivity.a(i, this.bDB, bool)) {
              ((acff)this.app.getManager(51)).bF(this.mUin, true);
            }
            if (!this.as.getText().toString().equals(this.mRemark)) {
              anot.a(this.app, "dc00898", "", "", "0X80077B1", "0X80077B1", 0, 0, "", "", "", "");
            }
            if (localIntent.getIntExtra("sort_id", 0) == 3090) {
              anot.a(this.app, "CliOper", "", "", "0x80084AE", "0x80084AE", 0, 0, "", "", "", "");
            }
            if (this.bDB == 3094) {
              if (m == 1)
              {
                anot.c(this.app, "dc00898", "", this.mUin, "0X80092E3", "0X80092E3", 0, 0, "", afxv.uQ(), afxv.t(this.app), afxv.uS());
                return;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddFriendVerifyActivity", 2, localException.toString());
              }
            }
            if (m == 2)
            {
              anot.c(this.app, "dc00898", "", this.mUin, "0X80092CC", "0X80092CC", 0, 0, "", "", afxv.t(this.app), "");
              return;
            }
            if (m == 8)
            {
              anot.c(this.app, "dc00898", "", this.mUin, "0X800A69D", "0X800A69D", this.eK, 0, "", "", "", "");
              return;
            }
          }
        }
      }
    } while (m != 9);
    anot.c(this.app, "dc00898", "", this.mUin, "0X800A69D", "0X800A69D", this.eK, 0, "", "", "", "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doOnActivityResult, requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null)
      {
        bool1 = true;
        QLog.d("AddFriendVerifyActivity", 2, bool1);
      }
    }
    else if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    switch (paramInt1)
    {
    case 1003: 
    default: 
    case 1001: 
    case 1002: 
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          paramIntent = this.v.getPath();
        } while (TextUtils.isEmpty(paramIntent));
        this.lS = paramIntent;
        uR(this.lS);
        uT(this.lS);
        return;
      } while (paramIntent == null);
      paramInt1 = paramIntent.getByteExtra("result", (byte)0);
      this.bDA = paramInt1;
      this.BJ.setText(AutoRemarkActivity.e(this.app, paramInt1));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(acfp.m(2131702084) + AutoRemarkActivity.e(this.app, paramInt1));
      return;
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("ticket");
      if (this.X != null)
      {
        b(this.X.getString("msg", ""), this.X.getByteArray("sig"), paramIntent);
        bool1 = bool2;
        label284:
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "REQUEST_CODE_SECCHECK_H5_PAGE, isSuccuss=" + bool1);
        }
      }
      else
      {
        if (this.u != null)
        {
          this.u.cancel();
          this.u = null;
        }
        uU(getString(2131718832));
        bFI();
      }
    }
    for (;;)
    {
      bool1 = false;
      break label284;
      break;
      if (this.u != null)
      {
        this.u.cancel();
        this.u = null;
      }
      uU(getString(2131718832));
      bFI();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = getIntent();
    this.mUin = ((Intent)localObject2).getStringExtra("uin");
    this.mType = ((Intent)localObject2).getIntExtra("k_uin_type", 1);
    if (this.mType != 4) {
      setTheme(2131755343);
    }
    this.eK = ((Intent)localObject2).getIntExtra("entrance", -1);
    super.doOnCreate(paramBundle);
    this.d = ((InputMethodManager)getSystemService("input_method"));
    Object localObject3;
    int k;
    if (this.mType == 4)
    {
      setContentViewB(2131558539);
      this.fM = ((LinearLayout)findViewById(2131381513));
      this.BE = ((TextView)findViewById(2131381520));
      this.BF = ((TextView)findViewById(2131381517));
      this.BG = ((TextView)findViewById(2131381518));
      this.ar = ((EditText)findViewById(2131381514));
      this.BH = ((TextView)findViewById(2131381516));
      this.ar.addTextChangedListener(this.e);
      this.gl = ((RelativeLayout)findViewById(2131380299));
      this.pl = ((ImageView)this.gl.findViewById(2131362164));
      this.ae = ((URLImageView)this.gl.findViewById(2131368846));
      this.pk = ((ImageView)this.gl.findViewById(2131368926));
      this.gl.setVisibility(8);
      this.BN = ((TextView)findViewById(2131373913));
      this.fO = ((LinearLayout)findViewById(2131374467));
      this.BO = ((TextView)findViewById(2131374469));
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131374466));
      this.BP = ((TextView)findViewById(2131374468));
      this.s = ((RecyclerView)findViewById(2131373436));
      this.pm = ((ImageView)findViewById(2131381519));
      this.u = new arhz(this, getTitleBarHeight());
      this.u.setMessage(2131691369);
      this.authKey = ((Intent)localObject2).getStringExtra("authKey");
      this.authSig = ((Intent)localObject2).getStringExtra("authSig");
      if (this.authKey != null) {}
      paramBundle = getIntent().getExtras().getString("nick_name");
      if (this.mType != 4) {
        break label2878;
      }
      setTitle(2131689928);
      localObject3 = (TextView)findViewById(2131369579);
      localObject1 = getIntent().getExtras().getString("leftViewText");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getString(2131691039);
      }
      ((TextView)localObject3).setText(paramBundle);
      this.mTroopUin = this.mUin;
      this.aKI = getIntent().getExtras().getString("troop_code");
      addObserver(this.jdField_b_of_type_Acnd);
      this.aKK = getIntent().getExtras().getString("key_param_homework_intro_str");
      if (TextUtils.isEmpty(this.aKK)) {
        ((acms)this.app.getBusinessHandler(20)).EU(this.mTroopUin);
      }
      i = getIntent().getExtras().getShort("group_option", (short)2);
      paramBundle = getIntent().getExtras().getString("troop_question");
      getIntent().getExtras().getString("troop_answer");
      k = getIntent().getIntExtra("stat_option", 0);
      aqfr.o(this.mTroopUin, 1, 1, k);
      switch (i)
      {
      case 3: 
      default: 
        label676:
        getWindow().setSoftInputMode(5);
      }
    }
    for (;;)
    {
      if (this.mType == 3)
      {
        paramBundle = ((Intent)localObject2).getStringExtra("is_from_game");
        localObject1 = ((Intent)localObject2).getStringExtra("extra");
      }
      try
      {
        localObject2 = aeie.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(paramBundle)) || (((aemk)localObject2).ahl())) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          apuh.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "AddFriend enableCheckPermission = " + ((aemk)localObject2).ahl());
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int n;
          int i1;
          if (("true".equals(paramBundle)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            apuh.a(this.app, getApplicationContext(), (String)localObject1, this, 1003, null);
          }
          QLog.d("AddFriendVerifyActivity", 1, "AddFriend loadConfig exception = " + localException);
          continue;
          i = 0;
          continue;
        }
      }
      this.fN.setVisibility(8);
      enableRightHighlight(true);
      if (asgx.ag(this.app, this.mUin)) {
        this.BL.setVisibility(8);
      }
      this.aKJ = getIntent().getStringExtra("webImVisitId");
      return true;
      setContentViewB(2131558538);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
      i = getIntent().getIntExtra("sub_source_id", 0);
      this.bDB = ((Intent)localObject2).getIntExtra("source_id", 3999);
      if (((Intent)localObject2).hasExtra("param_wzry_data")) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)((Intent)localObject2).getSerializableExtra("param_wzry_data"));
      }
      if (AutoRemarkActivity.fU(this.bDB))
      {
        this.mRemark = ((Intent)localObject2).getStringExtra("nick_name");
        label950:
        if (QLog.isColorLevel()) {
          QLog.i("AddFriendVerifyActivity", 2, "AddFriendVerifyActivity remark = " + this.mRemark + ", source id=" + this.bDB + ", mTargetGroupId = " + this.bDA);
        }
        if ((paramBundle == null) && (aqiw.isNetSupport(this)) && (AutoRemarkActivity.i(this.bDB, this.mUin))) {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ac(this.mUin, this.bDB, ((Intent)localObject2).getIntExtra("sub_source_id", 0));
        }
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363711));
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(new udx(this));
        this.aq = ((EditText)findViewById(2131377168));
        this.BK = ((TextView)findViewById(2131377169));
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a = new a(100, this.aq);
        this.aq.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a);
        this.BL = ((TextView)findViewById(2131362334));
        this.BL.setVisibility(0);
        paramBundle = getIntent().getStringExtra("key_param_age_area");
        if (!TextUtils.isEmpty(paramBundle))
        {
          this.BL.setText(paramBundle);
          if (AppSetting.enableTalkBack) {
            this.BL.setContentDescription(paramBundle);
          }
        }
        this.aq.setOnTouchListener(this);
        this.fK = ((LinearLayout)findViewById(2131372254));
        this.fL = ((LinearLayout)findViewById(2131362735));
        this.pn = ((ImageView)findViewById(2131373517));
        this.BM = ((TextView)findViewById(2131372384));
        this.BI = ((TextView)findViewById(2131379838));
        this.fN = ((LinearLayout)findViewById(2131368156));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131377468));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131377427));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
        this.as = ((EditText)findViewById(2131366540));
        this.BJ = ((TextView)findViewById(2131380745));
        this.as.addTextChangedListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this);
        this.as.setText(this.mRemark);
        if (!TextUtils.isEmpty(this.mRemark)) {
          this.as.setSelection(this.mRemark.length());
        }
        this.BJ.setText(AutoRemarkActivity.e(this.app, this.bDA));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(acfp.m(2131702078) + AutoRemarkActivity.e(this.app, this.bDA));
        if (!aqft.rj(this.mUin)) {
          break label1803;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.BI.setText(getString(2131689792));
        label1531:
        if ((!azcl.oD(this.bDB)) && (this.bDB != 3016)) {
          break label1828;
        }
        i = 1;
        label1553:
        if (i == 0)
        {
          this.rp = findViewById(2131376250);
          this.rp.setVisibility(0);
          this.y = ((Switch)findViewById(2131376251));
          this.y.setOnCheckedChangeListener(this);
        }
        if (!AppSetting.enableTalkBack) {
          break;
        }
        this.pn.setContentDescription(getString(2131693350));
        if (aqft.rj(this.mUin)) {
          break label1833;
        }
        this.BI.setContentDescription(getString(2131718738));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setContentDescription(getResources().getString(2131694937) + this.as.getText().toString());
        this.as.setContentDescription(null);
        if (i != 0) {
          break;
        }
        this.rp.setFocusable(true);
        this.rp.setContentDescription(getResources().getString(2131718001));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
        {
          this.mRemark = ((Intent)localObject2).getStringExtra("nick_name");
          break label950;
        }
        if ((this.bDB != 3004) || ((i != 5) && (i != 6) && (i != 7) && (i != 8))) {
          break label950;
        }
        this.mRemark = ((Intent)localObject2).getStringExtra("nick_name");
        break label950;
        label1803:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
        this.BI.setText(getString(2131689791));
        break label1531;
        label1828:
        i = 0;
        break label1553;
        label1833:
        this.BI.setContentDescription(getString(2131718737));
      }
      this.fM.setVisibility(0);
      this.BE.setVisibility(8);
      this.BF.setVisibility(8);
      this.BN.setVisibility(0);
      this.BG.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.fM.getLayoutParams()).topMargin = 0;
      this.ae.setImageDrawable(aqdj.a(this.app, this.app.getCurrentAccountUin(), (byte)1));
      this.ae.setOnClickListener(this.mOnClickListener);
      this.pl.setOnClickListener(this.mOnClickListener);
      this.BH.setVisibility(0);
      this.ar.setHeight(wja.dp2px(160.0F, getResources()));
      this.ar.setSingleLine(false);
      this.ar.setGravity(48);
      this.ar.setHint("");
      i = wja.dp2px(10.0F, getResources());
      this.ar.setPadding(i, i, i, i);
      if (TextUtils.isEmpty(this.aKK))
      {
        paramBundle = getString(2131699760, new Object[] { this.app.getCurrentNickname() });
        label2055:
        uW(paramBundle);
        if (aqsr.isEnable())
        {
          anot.a(null, "dc00898", "", "", "qq_vip", "0X800A4F8", 0, 0, "", "", "", "");
          paramBundle = new GridLayoutManager(this, 2);
          this.jdField_a_of_type_Xko = new xko(this);
          this.s.setLayoutManager(paramBundle);
          this.s.setAdapter(this.jdField_a_of_type_Xko);
          this.s.setVisibility(0);
          paramBundle = (acny)this.app.getBusinessHandler(27);
          if (paramBundle == null) {
            break label2237;
          }
          localObject1 = new UniGetReq();
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(Integer.valueOf(40));
          ((UniGetReq)localObject1).appidList = ((ArrayList)localObject3);
          paramBundle.a((UniGetReq)localObject1, new b(this, 0), false);
        }
      }
      for (;;)
      {
        setRightHighlightButton(2131691441, new uei(this));
        break;
        paramBundle = this.aKK;
        break label2055;
        label2237:
        QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
      }
      this.fO.setVisibility(0);
      this.BG.setVisibility(8);
      paramBundle = new aofk(getString(2131717252) + ":" + paramBundle, 13);
      this.BO.setText(paramBundle);
      this.BO.setTag(this.mTroopUin);
      this.BO.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (aRi) {}
      setRightHighlightButton(2131691441, new ues(this));
      anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.mTroopUin, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label676;
      }
      k = 0;
      if (k >= paramBundle.mSpans.length) {
        break label676;
      }
      if (!(paramBundle.mSpans[k] instanceof aofk.b)) {}
      for (;;)
      {
        k += 1;
        break;
        localObject1 = ((aofk.b)paramBundle.mSpans[k]).mUrl;
        i = -1;
        if (aqjb.WEB_URL.matcher((CharSequence)localObject1).find()) {
          i = 0;
        }
        if (aofv.e.matcher((CharSequence)localObject1).find()) {
          i = 1;
        }
        if (!aofv.ah.matcher((CharSequence)localObject1).find()) {
          break label5099;
        }
        i = 2;
        anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.mTroopUin, "" + i, "", "");
      }
      this.fO.setVisibility(0);
      this.BG.setVisibility(8);
      paramBundle = new aofk(getString(2131717252) + ":" + paramBundle, 13);
      this.BO.setText(paramBundle);
      this.BO.setTag(this.mTroopUin);
      this.BO.setMovementMethod(LinkMovementMethod.getInstance());
      this.BO.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusableInTouchMode(true);
      if (aRi) {}
      setRightHighlightButton(2131691441, new ueu(this));
      anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.mTroopUin, "", "", "");
      if (paramBundle.mSpanCount <= 0) {
        break label676;
      }
      k = 0;
      label2733:
      if (k < paramBundle.mSpans.length) {
        if ((paramBundle.mSpans[k] instanceof aofk.b)) {
          break label2761;
        }
      }
      for (;;)
      {
        k += 1;
        break label2733;
        break;
        label2761:
        localObject1 = ((aofk.b)paramBundle.mSpans[k]).mUrl;
        i = -1;
        if (aqjb.WEB_URL.matcher((CharSequence)localObject1).find()) {
          i = 0;
        }
        if (aofv.e.matcher((CharSequence)localObject1).find()) {
          i = 1;
        }
        if (!aofv.ah.matcher((CharSequence)localObject1).find()) {
          break label5096;
        }
        i = 2;
        anot.a(this.app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, this.mTroopUin, "" + i, "", "");
      }
      label2878:
      setTitle(2131689787);
      setLeftButton(acfp.m(2131702049), null);
      localObject1 = (CardHandler)this.app.getBusinessHandler(2);
      m = getIntent().getExtras().getInt("source_id", 3999);
      n = getIntent().getIntExtra("sub_source_id", 0);
      if (azcl.oD(getIntent().getIntExtra("sort_id", 0)))
      {
        localObject3 = this.mUin;
        ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), "0", 16, 0L, (byte)0, 0L, 0L, null, (String)localObject3, 0L, 10004, null, (byte)0);
        label2992:
        addObserver(this.cardObserver);
        addObserver(this.c);
        addObserver(this.jdField_b_of_type_Ashx);
        if (this.mType != 2) {
          break label3413;
        }
        this.pn.setImageDrawable(aqdj.a(this.app, 11, this.mUin));
        localObject3 = this.BM;
        if (!TextUtils.isEmpty(paramBundle)) {
          break label3407;
        }
        localObject1 = this.mUin;
        label3063:
        ((TextView)localObject3).setText((CharSequence)localObject1);
        if (AppSetting.enableTalkBack)
        {
          localObject3 = this.BM;
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = this.mUin;
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
        }
        label3105:
        i1 = ((Intent)localObject2).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
      }
      switch (i1)
      {
      default: 
        break;
      case 0: 
      case 2: 
        if ((m == 3078) || (m == 3079))
        {
          this.aq.setVisibility(0);
          this.BK.setVisibility(0);
          this.BK.setText(getString(2131689765));
          this.pn.setVisibility(8);
          this.BM.setVisibility(8);
          this.BL.setVisibility(8);
          if (AppSetting.enableTalkBack)
          {
            this.aq.setContentDescription(this.aq.getText().toString());
            this.BK.setContentDescription(getString(2131689793));
          }
          this.fN.setVisibility(8);
          if (getIntent() != null) {}
          for (i = getIntent().getIntExtra("contact_from_type", 1);; i = 1)
          {
            setRightHighlightButton(2131691441, new uev(this, i));
            paramBundle = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
            paramBundle.addRule(3, this.aq.getId());
            paramBundle.topMargin = wja.dp2px(20.0F, getResources());
            this.fN.setLayoutParams(paramBundle);
            break;
            ((CardHandler)localObject1).a(this.app.getCurrentAccountUin(), this.mUin, 12, 0L, (byte)0, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
            break label2992;
            localObject1 = paramBundle;
            break label3063;
            if (this.mType == 3)
            {
              localObject1 = ((Intent)localObject2).getStringExtra("extra");
              localObject1 = URLDrawable.getDrawable(aqdj.bT(this.mUin, (String)localObject1), URLDrawable.URLDrawableOptions.obtain());
              if (anlm.Vr()) {
                this.pn.setImageDrawable((Drawable)localObject1);
              }
              for (;;)
              {
                this.BM.setText(paramBundle);
                if (AppSetting.enableTalkBack) {
                  this.BM.setContentDescription(paramBundle);
                }
                ((FriendListHandler)this.app.getBusinessHandler(1)).eI(this.mUin, getIntent().getStringExtra("extra"));
                break;
                g((URLDrawable)localObject1);
              }
            }
            if ((m == 3007) || (m == 2007) || (m == 4007) || (m == 3019) || (m == 2019)) {
              this.pn.setImageDrawable(aqdj.a(this.app, 200, this.mUin, true));
            }
            for (;;)
            {
              if (!OD()) {
                break label3645;
              }
              if (paramBundle == null) {
                break;
              }
              this.BM.setText(paramBundle);
              if (!AppSetting.enableTalkBack) {
                break;
              }
              this.BM.setContentDescription(paramBundle);
              break;
              this.pn.setImageDrawable(aqdj.a(this.app, 1, this.mUin));
            }
            ThreadManager.getSubThreadHandler().post(new AddFriendVerifyActivity.5(this, paramBundle));
            break label3105;
          }
        }
        setRightHighlightButton(2131691441, new uew(this, m, n));
        paramBundle = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
        paramBundle.addRule(3, this.pn.getId());
        paramBundle.topMargin = wja.dp2px(20.0F, getResources());
        this.fN.setLayoutParams(paramBundle);
        anot.a(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 2, 0, String.valueOf(m), String.valueOf(n), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + m + " subSourceId = " + n);
        }
        eP(m, i1);
        break;
      case 1: 
        this.aq.setVisibility(0);
        this.BK.setVisibility(0);
        if (AppSetting.enableTalkBack)
        {
          this.aq.setContentDescription(this.aq.getText().toString());
          this.BK.setContentDescription(getString(2131689793));
        }
        setRightHighlightButton(2131691441, new uex(this, m, n, i1));
        paramBundle = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
        paramBundle.addRule(3, this.aq.getId());
        paramBundle.topMargin = wja.dp2px(20.0F, getResources());
        this.fN.setLayoutParams(paramBundle);
        anot.a(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 1, 0, String.valueOf(m), String.valueOf(n), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + m + " subSourceId = " + n);
        }
        break;
      case 3: 
        this.fK.setVisibility(0);
        paramBundle = (String)((ArrayList)localObject1).get(0);
        localObject1 = (TextView)this.fK.findViewById(2131379420);
        localObject3 = (EditText)this.fK.findViewById(2131369295);
        this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a = new a(50, (EditText)localObject3);
        ((EditText)localObject3).addTextChangedListener(this.jdField_b_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity$a);
        ((TextView)localObject1).setText(getString(2131717252) + ":" + paramBundle);
        ((EditText)localObject3).setSingleLine(true);
        if (aRi) {
          ((TextView)localObject1).setContentDescription(getString(2131717252) + ":" + paramBundle);
        }
        setRightHighlightButton(2131691441, new uey(this, (EditText)localObject3, i1, m, n));
        getWindow().setSoftInputMode(5);
        paramBundle = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
        paramBundle.addRule(3, this.fK.getId());
        paramBundle.topMargin = wja.dp2px(20.0F, getResources());
        this.fN.setLayoutParams(paramBundle);
        anot.a(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 3, 0, String.valueOf(m), String.valueOf(n), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + m + " subSourceId = " + n);
        }
        break;
      case 4: 
        label3407:
        label3413:
        this.fL.setVisibility(0);
        label3645:
        localObject3 = new StringBuffer();
        if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
          break label5091;
        }
        i = 1;
        k = 0;
        if (k < ((ArrayList)localObject1).size())
        {
          switch (k)
          {
          default: 
            paramBundle = getResources().getString(2131717252);
          }
          for (;;)
          {
            Object localObject6 = getLayoutInflater().inflate(2131561160, this.fL, false);
            Object localObject4 = getLayoutInflater().inflate(2131561159, this.fL, false);
            if (k > 0)
            {
              localObject5 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
              if (localObject5 != null)
              {
                ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)aqho.convertDpToPixel(getApplication(), 19.0F));
                ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
            }
            this.fL.addView((View)localObject6);
            this.fL.addView((View)localObject4);
            Object localObject5 = (String)((ArrayList)localObject1).get(k);
            localObject6 = (TextView)((View)localObject6).findViewById(2131379420);
            ((TextView)localObject6).setText(paramBundle + (String)localObject5);
            localObject4 = (EditText)((View)localObject4).findViewById(2131369295);
            ((EditText)localObject4).addTextChangedListener(new a(50, (EditText)localObject4));
            this.oJ.add(localObject4);
            if (aRi) {
              ((TextView)localObject6).setContentDescription(paramBundle + (String)localObject5);
            }
            int i2 = k + 1;
            ((StringBuffer)localObject3).append(getString(2131717252) + i2 + ":" + (String)localObject5);
            ((StringBuffer)localObject3).append("\n");
            ((StringBuffer)localObject3).append(getString(2131690314) + ":${answer}");
            if (i2 != ((ArrayList)localObject1).size()) {
              ((StringBuffer)localObject3).append("\n");
            }
            k += 1;
            break;
            if (i != 0)
            {
              paramBundle = getResources().getString(2131717253);
            }
            else
            {
              paramBundle = getResources().getString(2131717254);
              continue;
              paramBundle = getResources().getString(2131717255);
              continue;
              paramBundle = getResources().getString(2131717256);
              continue;
              paramBundle = getResources().getString(2131717257);
              continue;
              paramBundle = getResources().getString(2131717258);
            }
          }
        }
        setRightHighlightButton(2131691441, new udy(this, (StringBuffer)localObject3, m, n, i1));
        findViewById(2131377472).setOnTouchListener(new udz(this));
        getWindow().setSoftInputMode(4);
        paramBundle = (RelativeLayout.LayoutParams)this.fN.getLayoutParams();
        paramBundle.addRule(3, this.fL.getId());
        paramBundle.topMargin = wja.dp2px(20.0F, getResources());
        this.fN.setLayoutParams(paramBundle);
        anot.a(this.app, "dc00898", "", "", "0X80077AF", "0X80077AF", 4, 0, String.valueOf(m), String.valueOf(n), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077AF  sourceId = " + m + " subSourceId = " + n);
        }
        break;
      }
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.z != null) && (this.z.isShowing()) && (this.z.getWindow() != null)) {}
    try
    {
      this.z.dismiss();
      label34:
      if (Build.VERSION.SDK_INT >= 16) {
        getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      for (;;)
      {
        super.doOnDestroy();
        return;
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      this.lS = ((String)paramIntent.get(0));
      uT(this.lS);
    }
  }
  
  public void doOnResume()
  {
    int i = 1;
    int k = 0;
    super.doOnResume();
    if (this.mType != 4) {}
    String str1;
    Object localObject2;
    switch (getIntent().getIntExtra("friend_setting", 0))
    {
    default: 
    case 0: 
      do
      {
        return;
      } while ((this.bDB != 3078) && (this.bDB != 3079));
      str1 = k(false);
      localObject2 = getString(2131693133);
      if (TextUtils.isEmpty(str1)) {
        if (!OE()) {
          str1 = (String)localObject2 + aqgv.s(this.app, this.app.getAccount());
        }
      }
      break;
    }
    for (;;)
    {
      this.aq.setHint("");
      this.aq.setText(str1);
      if (i != 0) {}
      try
      {
        this.aq.setSelection(((String)localObject2).length(), str1.length());
        for (;;)
        {
          label168:
          getWindow().setSoftInputMode(5);
          return;
          if (!TextUtils.isEmpty(str1)) {
            this.aq.setSelection(str1.length());
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        break label168;
      }
      String str4 = getString(2131693133);
      String str2;
      if (getIntent().getBooleanExtra("_FROM_QLINK_", false))
      {
        localObject2 = str4 + getString(2131700495) + " " + aqgv.s(this.app, this.app.getAccount());
        this.aq.setHint((CharSequence)localObject2);
        this.aq.setVisibility(0);
        this.BK.setVisibility(0);
        if (AppSetting.enableTalkBack)
        {
          this.aq.setContentDescription(this.aq.getText().toString());
          this.BK.setContentDescription(getString(2131689793));
        }
        if (this.mType != 3) {
          break label492;
        }
        str2 = getIntent().getStringExtra("msg");
        i = 1;
      }
      for (;;)
      {
        label358:
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
          str3 = k(false);
        }
        if (TextUtils.isEmpty(str3)) {}
        for (;;)
        {
          if ((i != 0) && (str4.equals(localObject2)) && (!OE())) {
            str2 = (String)localObject2 + aqgv.s(this.app, this.app.getAccount());
          }
          for (i = 1;; i = k)
          {
            for (;;)
            {
              this.aq.setText(str2);
              if (i != 0) {}
              try
              {
                this.aq.setSelection(str4.length(), str2.length());
                for (;;)
                {
                  label467:
                  getWindow().setSoftInputMode(5);
                  return;
                  this.aq.setHint("");
                  localObject2 = str4;
                  break;
                  label492:
                  if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) {
                    break label557;
                  }
                  str2 = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg;
                  if (TextUtils.isEmpty(str2)) {
                    break label552;
                  }
                  i = 0;
                  break label358;
                  this.aq.setSelection(str2.length());
                }
              }
              catch (Throwable localThrowable2)
              {
                break label467;
              }
            }
            localObject1 = localObject2;
          }
          localObject2 = str3;
        }
        label552:
        i = 1;
        continue;
        label557:
        localObject1 = null;
        i = 1;
      }
      i = 0;
      Object localObject1 = localObject2;
      continue;
      i = 0;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.c != null) {
      addObserver(this.c);
    }
    if (this.jdField_b_of_type_Acnd != null) {
      addObserver(this.jdField_b_of_type_Acnd);
    }
    if (this.cardObserver != null) {
      addObserver(this.cardObserver);
    }
    if (this.jdField_b_of_type_Ashx != null) {
      addObserver(this.jdField_b_of_type_Ashx);
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.c != null) {
      removeObserver(this.c);
    }
    if (this.jdField_b_of_type_Acnd != null) {
      removeObserver(this.jdField_b_of_type_Acnd);
    }
    if (this.cardObserver != null) {
      removeObserver(this.cardObserver);
    }
    if (this.jdField_b_of_type_Ashx != null) {
      removeObserver(this.jdField_b_of_type_Ashx);
    }
  }
  
  public void eP(int paramInt1, int paramInt2)
  {
    boolean bool = getIntent().getBooleanExtra("select_multi_mode", false);
    String str = getIntent().getStringExtra("troop_uin");
    ThreadManager.post(new AddFriendVerifyActivity.31(this, paramInt1, getIntent().getIntExtra("sub_source_id", 0), bool, str, paramInt2), 5, null, true);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
    localIntent.setPackage(getPackageName());
    localIntent.putExtra("ret_action", this.bDD);
    sendBroadcast(localIntent);
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.leftView.getWindowToken(), 0);
    getWindow().setSoftInputMode(2);
    super.finish();
    if (this.mType != 4) {
      overridePendingTransition(0, 2130772013);
    }
  }
  
  public void goBack()
  {
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      finish();
      return;
    }
    Object localObject = getIntent().getStringExtra("param_return_addr");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "goBack | retAddr = " + (String)localObject);
    }
    if (localObject != null) {
      for (;;)
      {
        Intent localIntent2;
        try
        {
          localObject = Class.forName((String)localObject);
          localIntent2 = new Intent();
          localIntent2.setComponent(new ComponentName("com.tencent.tim", ((Class)localObject).getName()));
          if ((localObject.equals(FriendProfileCardActivity.class)) || (localObject.equals(QidianProfileCardActivity.class)))
          {
            ProfileActivity.b(this, this.mUin, localIntent2);
            localIntent2.setFlags(67108864);
            localIntent2.putExtra("key_back_from_add_friend", true);
            startActivity(localIntent2);
            return;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AddFriendVerifyActivity", 2, "goBack | exception = ", localClassNotFoundException);
          }
          localClassNotFoundException.printStackTrace();
          setResult(-1);
          finish();
          return;
        }
        if (localClassNotFoundException.equals(NearbyPeopleProfileActivity.class))
        {
          localIntent2.putExtra("AllInOne", new ProfileActivity.AllInOne(this.mUin, 41));
          localIntent2.putExtra("param_mode", 3);
        }
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.mUin);
      setResult(-1, localIntent1);
    }
    for (;;)
    {
      finish();
      return;
      ba(0, "");
      setResult(-1);
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = true;
    bFI();
    Object localObject;
    if (getIntent().getBooleanExtra("need_jumpto_splash", false))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      return super.onBackEvent();
    }
    if (this.mType != 4)
    {
      localObject = this.aq.getText().toString();
      if (4 != this.mType) {
        break label177;
      }
    }
    for (;;)
    {
      aN((String)localObject, bool);
      if ((getString(2131693133).equals(localObject)) && (!OE())) {
        bFH();
      }
      if (!TextUtils.isEmpty(this.aKJ)) {
        anot.a(this.app, "dc00899", "Qidian", this.mUin, "0X8008802", "ClickAddFriendButton", 0, 0, "2", "", "", "");
      }
      return super.onBackEvent();
      label177:
      bool = false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject;
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, 1, 2131696272, 0).show(getTitleBarHeight());
      if (this.y != null)
      {
        localObject = this.y;
        if (!paramBoolean) {
          bool = true;
        }
        ((Switch)localObject).setChecked(bool);
        this.y.setOnClickListener(null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (this.y != null) {
        this.y.setOnClickListener(this);
      }
      if (paramCompoundButton == this.y)
      {
        if (AppSetting.enableTalkBack) {
          this.rp.setContentDescription(getResources().getString(2131718001));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.mUin);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        avfw.d locald = new avfw.d(0);
        locald.mPluginName = "QQ空间";
        locald.mPluginID = QzonePluginProxyActivity.Gg();
        locald.mUin = this.app.getCurrentAccountUin();
        locald.cKu = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        locald.mIntent = ((Intent)localObject);
        avfw.b(this.app.getApp(), locald);
        anot.a(this.app, "dc00898", "", "", "0X80077B3", "0X80077B3", 0, 0, "", "", "", "");
      }
      localObject = paramCompoundButton.getTag();
      if (((localObject instanceof Integer)) && (((TroopManager)this.app.getManager(52) == null) || (this.mTroopUin != null))) {
        switch (((Integer)localObject).intValue())
        {
        default: 
          break;
        case 1: 
          vI(paramBoolean);
        }
      }
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
      Intent localIntent = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.mUin).putExtra("mgid", (byte)this.bDA);
      localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
      startActivityForResult(localIntent, 1002);
      if (this.aq != null) {
        aN(this.aq.getText().toString(), false);
      }
      anot.a(this.app, "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131369295) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void select(int paramInt)
  {
    if (paramInt == 2000)
    {
      this.BH.setTextColor(getResources().getColor(2131167379));
      this.pm.setVisibility(8);
      this.ar.setBackgroundResource(2130851351);
      int i = wja.dp2px(10.0F, getResources());
      this.ar.setPadding(i, i, i, i);
      this.ar.setTextColor(getResources().getColor(2131167304));
    }
    label284:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "select: " + paramInt + " server: " + this.bDC);
      }
      Object localObject;
      if (this.bDC != paramInt)
      {
        localObject = (acny)this.app.getBusinessHandler(27);
        if (localObject != null)
        {
          UniSetReq localUniSetReq = new UniSetReq();
          localUniSetReq.stUniBusinessItem = new UniBusinessItem(40, paramInt);
          ((acny)localObject).a(localUniSetReq, new b(this, paramInt), false);
        }
      }
      else
      {
        return;
        localObject = (PobingDecoder.a)BaseApplicationImpl.sImageCache.get(aqsr.gm(paramInt));
        if (localObject == null) {
          new PobingDecoder(paramInt, aqsr.ph, this.jdField_a_of_type_Ajdq);
        }
        for (;;)
        {
          if (!anlm.ayn()) {
            break label284;
          }
          aqha.a(this, 0, acfp.m(2131702081), acfp.m(2131702075), null, acfp.m(2131702050), new ueo(this), null).show();
          break;
          this.jdField_a_of_type_Ajdq.postQuery(localObject);
        }
      }
    }
    QLog.e("AddFriendVerifyActivity", 1, "set fail, VipInfoHandler is null");
  }
  
  public void uS(String paramString)
  {
    if (!aqiw.isNetSupport(this)) {}
    ArrayList localArrayList;
    do
    {
      QQToast.a(this.app.getApp(), 1, getString(2131718832), 0).show(getTitleBarHeight());
      do
      {
        return;
      } while (!getIntent().hasExtra("contacts"));
      localArrayList = (ArrayList)getIntent().getSerializableExtra("contacts");
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    if (this.u == null)
    {
      this.u = new arhz(this, getTitleBarHeight());
      this.u.setOnDismissListener(new uec(this));
    }
    this.u.setCancelable(true);
    this.u.setCanceledOnTouchOutside(false);
    this.u.setMessage(2131719519);
    this.u.show();
    this.oK.clear();
    this.oK.addAll(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.oK, paramString, 0, this.bDB, new ArrayList());
  }
  
  public void uT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    if (!aqiw.isNetworkAvailable(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 1, 2131698298, 0).show(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new AddFriendVerifyActivity.23(this, paramString), 5, null, false);
  }
  
  public void uW(String paramString)
  {
    if (this.mType != 4) {
      this.BH.setText("30");
    }
    for (;;)
    {
      this.ar.setText(paramString);
      this.ar.setSelection(this.ar.getText().length());
      return;
      int k = 0;
      try
      {
        i = paramString.getBytes("utf-8").length;
        this.BH.setText(90 - i + "");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = k;
          if (QLog.isColorLevel())
          {
            QLog.d("AddFriendVerifyActivity", 2, "get intro length failed!");
            i = k;
          }
        }
      }
    }
  }
  
  public class StartRecommendPageTask
    implements Runnable
  {
    private long mStartTime = System.currentTimeMillis();
    private String mUrl;
    
    public StartRecommendPageTask(String paramString)
    {
      if (AddFriendVerifyActivity.this.getIntent().getIntExtra("friend_setting", 0) != 0) {
        i = 1;
      }
      this.mUrl = (paramString + "?_wv=1031&troopUin=" + AddFriendVerifyActivity.this.mTroopUin + "&isVerify=" + i);
    }
    
    public void run()
    {
      if (!TextUtils.isEmpty(AddFriendVerifyActivity.this.aKK))
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add("admin.qun.qq.com");
        aija.a("closeJoinWebView", null, (ArrayList)localObject, null);
      }
      Object localObject = new Intent();
      ((Intent)localObject).setAction("start_recomend_page");
      AddFriendVerifyActivity.this.sendBroadcast((Intent)localObject);
      localObject = new Intent(AddFriendVerifyActivity.this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.mUrl);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      AddFriendVerifyActivity.this.startActivity((Intent)localObject);
      AddFriendVerifyActivity.this.overridePendingTransition(2130772009, 2130772002);
      AddFriendVerifyActivity.a(AddFriendVerifyActivity.this, false);
      AddFriendVerifyActivity.this.finish();
    }
  }
  
  public static class a
    implements TextWatcher
  {
    int bDL;
    int bDM;
    EditText mEditText;
    int mMaxBytes;
    
    public a(int paramInt, EditText paramEditText)
    {
      this.mMaxBytes = paramInt;
      this.mEditText = paramEditText;
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      String str2 = this.mEditText.getText().toString();
      Object localObject2;
      String str3;
      String str1;
      Object localObject1;
      if (str2.getBytes().length > this.mMaxBytes)
      {
        localObject2 = "";
        str3 = "";
        str1 = "";
        paramEditable = str1;
        localObject1 = str3;
      }
      try
      {
        String str4 = str2.substring(0, this.bDL);
        paramEditable = str1;
        localObject1 = str3;
        localObject2 = str4;
        String str5 = str2.substring(this.bDL + this.bDM, str2.length());
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        str1 = str2.substring(this.bDL, this.bDL + this.bDM);
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        if (str4.getBytes().length + str5.getBytes().length <= this.mMaxBytes)
        {
          for (;;)
          {
            paramEditable = str1;
            localObject1 = str5;
            localObject2 = str4;
            if (str2.getBytes().length <= this.mMaxBytes) {
              break;
            }
            paramEditable = str1;
            localObject1 = str5;
            localObject2 = str4;
            if (str1.length() <= 0) {
              break;
            }
            paramEditable = str1;
            localObject1 = str5;
            localObject2 = str4;
            str1 = str1.substring(0, str1.length() - 1);
            paramEditable = str1;
            localObject1 = str5;
            localObject2 = str4;
            str2 = str4 + str1 + str5;
          }
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          byte[] arrayOfByte = String.valueOf(str2.charAt(str2.length() - 1)).getBytes("UTF-16BE");
          str3 = str2;
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          if (arrayOfByte.length == 2)
          {
            str3 = str2;
            paramEditable = str1;
            localObject1 = str5;
            localObject2 = str4;
            if (str2.length() > 1)
            {
              int i = (char)(arrayOfByte[0] & 0xFF);
              i = (char)((char)(arrayOfByte[1] & 0xFF) | i << 8);
              str3 = str2;
              if (i >= 55296)
              {
                str3 = str2;
                if (i <= 55359)
                {
                  paramEditable = str1;
                  localObject1 = str5;
                  localObject2 = str4;
                  str3 = str2.substring(0, str2.length() - 1);
                }
              }
            }
          }
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          this.mEditText.setText(str3);
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          this.mEditText.setSelection(str3.length());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AddFriendVerifyActivity", 2, "afterTextChanged, headStr:" + (String)localObject2 + ", tailStr = " + (String)localObject1 + ", insert = " + paramEditable, localThrowable);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.bDL = paramInt1;
      this.bDM = paramInt3;
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  static class b
    implements acci
  {
    private WeakReference<AddFriendVerifyActivity> S;
    private int templateId;
    
    public b(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt)
    {
      this.templateId = paramInt;
      this.S = new WeakReference(paramAddFriendVerifyActivity);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      AddFriendVerifyActivity localAddFriendVerifyActivity = (AddFriendVerifyActivity)this.S.get();
      if ((localAddFriendVerifyActivity != null) && (!localAddFriendVerifyActivity.isFinishing()))
      {
        localAddFriendVerifyActivity.a(paramInt, paramBoolean, paramObject, this.templateId);
        return;
      }
      QLog.e("AddFriendVerifyActivity", 1, "onUpdate: activity is null, type=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */