package com.tencent.mobileqq.nearby.profilecard;

import accv;
import accv.b;
import acfd;
import acff;
import acfp;
import acgf;
import advm;
import advm.a;
import advr;
import aeib;
import afka;
import ahmm;
import aija;
import ajph;
import ajpj;
import ajqh;
import ajqp;
import ajrb;
import ajrs;
import ajrw;
import akce;
import akcf;
import akcg;
import akch;
import akci;
import akck;
import akcl;
import akcm;
import akcn;
import akco;
import akcp;
import akcq;
import akcr;
import akcs;
import akct;
import akcu;
import akcw;
import akcx;
import akef;
import akfj;
import akfk;
import akgm;
import akkh;
import akkn;
import akks;
import amhj;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import anpo;
import anpo.a;
import aomd;
import aooi;
import aqep;
import aqft;
import aqfy;
import aqha;
import arhz;
import aurd;
import aurh;
import ausj;
import avpw;
import avpw.d;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import rpq;

public class NearbyPeopleProfileActivity
  extends FragmentActivity
{
  public static int dmp = 18;
  public static int dmq = 12;
  public static int dmr = dmq;
  public static int dmy;
  public static HashMap<String, Integer> lX = new HashMap();
  private View Fg;
  private View Fh;
  public URLDrawable H;
  public accv.b a;
  acgf jdField_a_of_type_Acgf = new akch(this);
  private advm jdField_a_of_type_Advm;
  ahmm jdField_a_of_type_Ahmm = new akcp(this);
  private akcw jdField_a_of_type_Akcw;
  private akfj jdField_a_of_type_Akfj;
  public amhj a;
  arhz jdField_a_of_type_Arhz;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private DownloadHDAvatarRunnable jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable;
  public boolean aWh;
  public boolean aWs = false;
  public long adP;
  private long adQ;
  public Intent aj;
  public Dialog av = null;
  public Dialog ax = null;
  protected accv.b b;
  protected advm.a b;
  private advr jdField_b_of_type_Advr;
  public ajrw b;
  PicInfo jdField_b_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  public String bTc;
  public String bTd;
  public boolean bkW;
  protected acfd c;
  public ajrs c;
  public boolean crA = false;
  public boolean crB = false;
  boolean crC = true;
  public boolean crD = false;
  public volatile boolean crE;
  private boolean crF;
  public boolean crG;
  public boolean crH;
  boolean crI = false;
  public boolean crJ = false;
  boolean crK = false;
  private boolean crL;
  private boolean crM;
  public boolean crt;
  public boolean cru = false;
  public boolean crv = false;
  public boolean crw = false;
  boolean crx = true;
  public boolean cry;
  public boolean crz = true;
  private ViewGroup dN;
  public int dmA = 18;
  public int dmB;
  private int dmC;
  public int dms;
  public int dmt;
  public int dmu;
  public int dmv = 0;
  public int dmw = 0;
  public int dmx = -1;
  private int dmz;
  public ProfileActivity.AllInOne e;
  public TopGestureLayout e;
  public accv f;
  public int from = 0;
  private Runnable hh;
  public int imageWidth;
  public boolean isFriend = false;
  public String mAlbumId;
  public float mDensity;
  public Handler mHandler = new akcq(this);
  public int mMode;
  private int mTitleBarHeight;
  public String mUin;
  public ArrayList<PicInfo> yi = new ArrayList(13);
  ArrayList<PicInfo> yj = new ArrayList(13);
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_c_of_type_Acfd = new akcg(this);
    this.jdField_b_of_type_Ajrw = new akci(this);
    this.jdField_b_of_type_Advm$a = new akcl(this);
    this.jdField_a_of_type_Accv$b = new akcm(this);
    this.jdField_b_of_type_Accv$b = new akcn(this);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("frome_where", paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void c(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    a(paramContext, paramAllInOne, paramBundle, 6);
  }
  
  private void dAD()
  {
    anot.a(this.app, "dc00899", "grp_lbs", "", "data_card", "up_pho", 0, 0, "", "", "", "");
  }
  
  public static boolean kI(int paramInt)
  {
    if (paramInt == 22) {}
    while ((paramInt >= 7) && (paramInt <= 12) && (paramInt != 11)) {
      return true;
    }
    return false;
  }
  
  void L(long paramLong, int paramInt1, int paramInt2)
  {
    this.mMode = 1;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new akce(this));
    if (this.Fg != null) {}
    try
    {
      this.dN.removeView(this.Fg);
      label65:
      if (this.jdField_a_of_type_Akfj != null) {
        this.jdField_a_of_type_Akfj.dzo();
      }
      this.Fg = null;
      this.jdField_a_of_type_Akfj = null;
      this.jdField_a_of_type_Akfj = a(this.from);
      this.Fg = this.jdField_a_of_type_Akfj.getContentView();
      this.dN.addView(this.Fg, new FrameLayout.LayoutParams(-1, -1));
      BounceScrollView localBounceScrollView = (BounceScrollView)this.Fg.findViewById(2131366254);
      localBounceScrollView.post(new NearbyPeopleProfileActivity.11(this, localBounceScrollView, this.Fh.findViewById(2131363709).getScrollY()));
      this.Fg.startAnimation(localAlphaAnimation);
      dAB();
      return;
    }
    catch (Exception localException)
    {
      break label65;
    }
  }
  
  public void MI(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.NearbyJsInterface");
    localIntent.putExtra("command_type", 3);
    localIntent.putExtra("exit_mode", this.mMode);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("exit_action", i);
      sendBroadcast(localIntent);
      return;
    }
  }
  
  public void MJ(boolean paramBoolean)
  {
    if (!this.crt) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isSuccess", paramBoolean);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("*.qq.com");
        aija.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, localJSONException.toString());
  }
  
  protected void MK(boolean paramBoolean)
  {
    if (paramBoolean) {
      dAA();
    }
    anot.a(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.aj.getBooleanExtra("param_no_miss", false)) {
      anot.a(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
  }
  
  public void Nj(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new NearbyPeopleProfileActivity.21(this, paramString), 5, null, true);
    }
  }
  
  public void RL(int paramInt)
  {
    this.ax = aqha.a(this, 0, getString(paramInt), 2131701362, 2131701361, new akcr(this), new akcs(this));
    if ((this.ax != null) && (!isFinishing())) {
      this.ax.show();
    }
  }
  
  public akcw a(int paramInt)
  {
    if (kI(paramInt)) {
      return new akef(this);
    }
    return new akcx(this);
  }
  
  public akfj a(int paramInt)
  {
    if (kI(paramInt)) {
      return new akgm(this);
    }
    return new akfk(this);
  }
  
  public void a(int paramInt, Rect paramRect)
  {
    if ((this.yi == null) || (this.yi.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhoto, currentPosition = " + paramInt + ", rect = " + paramRect + ", mPicInfo.size = " + this.yi != null) {
          break label89;
        }
      }
      label89:
      for (paramRect = "null";; paramRect = Integer.valueOf(this.yi.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", this.yi);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
  
  public void a(int paramInt, Rect paramRect, ArrayList<PicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhotoWithDelAndSetHeadView, currentPosition = " + paramInt + ", rect = " + paramRect + ", picInfos.size = " + paramArrayList != null) {
          break label80;
        }
      }
      label80:
      for (paramRect = "null";; paramRect = Integer.valueOf(paramArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", paramArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("intent_param_show_del_pic_and_set_head", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivityForResult(localIntent, 14);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.mMode != 1))
    {
      this.jdField_a_of_type_Akcw.c(paramNearbyPeopleCard);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.uin = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.nickname = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.cf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig;
    }
    if (this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.aOE != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime = this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.aOE;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
      dmr = dmp;
    }
    for (;;)
    {
      label174:
      label237:
      int i;
      label282:
      label301:
      long l2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
          anot.a(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
          break label430;
        }
        this.yi.clear();
        this.yi.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.crz = true;
        if (this.mMode == 3)
        {
          if (!aqft.equalsWithNullCheck(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
            break label462;
          }
          this.aj.putExtra("param_mode", 2);
          this.mMode = 2;
        }
        if (this.mMode != 1) {
          break label510;
        }
        this.jdField_a_of_type_Akfj.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        if ((this.crI) || (this.mMode == 1) || (this.isFriend)) {
          break;
        }
        this.crI = true;
        if (!kI(this.from)) {
          break label524;
        }
        i = 510;
        l2 = 0L;
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.jdField_c_of_type_Ajrs.o(l1, 0L, i);
        return;
        dmr = dmq;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
          break label174;
        }
        anot.a(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
        break label174;
        label430:
        if (1 == this.mMode) {
          break label237;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
        }
        this.crz = false;
        break label237;
        label462:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
          break label282;
        }
        paramNearbyPeopleCard = (acff)this.app.getManager(51);
        if (paramNearbyPeopleCard == null) {
          break label282;
        }
        this.isFriend = paramNearbyPeopleCard.isFriend(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        break label282;
        label510:
        this.jdField_a_of_type_Akcw.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        break label301;
        label524:
        i = 509;
      }
      catch (Exception paramNearbyPeopleCard)
      {
        for (;;)
        {
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.e("NearbyLikeLimitManager", 2, "req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void a(PicInfo paramPicInfo, Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPicInfo);
    paramPicInfo = new Intent(this, NearbyProfilePicBrowserActivity.class);
    paramPicInfo.putExtra("intent_param_index", 0);
    paramPicInfo.putExtra("intent_param_pic_infos", localArrayList);
    paramPicInfo.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    paramPicInfo.addFlags(536870912);
    startActivity(paramPicInfo);
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 == null) || (paramPicInfo2 == null)) {}
    while (paramPicInfo1.photoId != paramPicInfo2.photoId) {
      return false;
    }
    return true;
  }
  
  public void aL(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(this.mTitleBarHeight);
  }
  
  public void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void b(ImageView paramImageView, Drawable paramDrawable)
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "showVoteUpdateDialog invoke, but activity is finishing");
      }
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramDrawable = (ajqh)this.app.getManager(207);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, rpq.dip2px(this, 150.0F));
    new akkn(this).a(paramImageView, localLayoutParams).a(acfp.m(2131708789)).b(paramDrawable.h()).a(new akkh(acfp.m(2131708784), new akck(this))).show();
    this.H = null;
    paramDrawable.dyH();
  }
  
  public void b(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "editNearbyProfileCardResult() called with: isSuccess = [" + paramBoolean1 + "], card = [" + paramNearbyPeopleCard + "], isHeadChanged = [" + paramBoolean2 + "], errorTips = [" + paramString + "]");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "editNearbyProfileCardResult|[" + paramBoolean1 + "," + paramNearbyPeopleCard + "]");
    }
    aqz();
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      this.crv = false;
      aL(2, acfp.m(2131708788));
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, paramNearbyPeopleCard.college))
      {
        ajrb.c(this.app.getCurrentAccountUin(), "school_name", paramNearbyPeopleCard.college);
        ajrb.c(this.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.dmB));
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if (this.crw)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag = false;
        this.crw = false;
      }
      this.yi.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty()))
      {
        this.yi.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.crz = true;
      }
      this.jdField_b_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
      if (paramBoolean2) {
        ajpj.dv(this.app);
      }
      if (this.dmv != 1) {
        dAA();
      }
      if ((this.yi.isEmpty()) && (!this.yj.isEmpty()))
      {
        this.yi.addAll(this.yj);
        this.yj.clear();
      }
      if (this.jdField_a_of_type_Akcw != null) {
        this.jdField_a_of_type_Akcw.dAL();
      }
      this.aj.putExtra("param_mode", 2);
      dAz();
      ThreadManager.post(new NearbyPeopleProfileActivity.23(this), 5, null, true);
      paramNearbyPeopleCard = new Intent();
      paramNearbyPeopleCard.putExtra("param_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      paramNearbyPeopleCard.putExtra("param_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      paramNearbyPeopleCard.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      paramNearbyPeopleCard.putExtra("param_age", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
      paramNearbyPeopleCard.putExtra("param_career", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job);
      paramNearbyPeopleCard.putExtra("param_constellation", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation);
      paramNearbyPeopleCard.putExtra("param_marital_status", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus);
      paramNearbyPeopleCard.putExtra("param_god_flag", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag);
      int i = this.yi.size();
      paramNearbyPeopleCard.putExtra("param_photo_count", i);
      int j = ((Integer)ajrb.c(this.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      anot.a(this.app, "dc00899", "grp_lbs", "", "data_card", "upload_suc", 0, 0, i + "", j + "", "", "");
      setResult(-1, paramNearbyPeopleCard);
      if (this.crt)
      {
        MJ(true);
        finish();
      }
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      aL(1, acfp.m(2131708785));
    }
    for (;;)
    {
      this.crw = false;
      return;
      aL(1, paramString);
    }
  }
  
  public void c(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.crK)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable = new DownloadHDAvatarRunnable(paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable, 5, null, true);
  }
  
  protected void dAA()
  {
    ajph localajph = new ajph();
    localajph.gender = -1;
    ajph.a(this.app.getCurrentAccountUin(), localajph);
    this.dmv = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  protected void dAB()
  {
    this.yj.clear();
    this.yj.addAll(this.yi);
  }
  
  public void dAC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen() + ", addPicBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
    }
    String[] arrayOfString = getResources().getStringArray(2130968638);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl)))
    {
      ajpj.a(this, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    ausj localausj = ausj.b(this);
    localausj.addButton(arrayOfString[28]);
    localausj.addButton(arrayOfString[29]);
    localausj.addCancelButton(arrayOfString[16]);
    localausj.a(new akco(this, localausj));
    localausj.show();
  }
  
  public void dAE()
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = this.app.getCurrentAccountUin();
    locald.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131718034));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    avpw.a(this, locald, localBundle, 5);
    anot.a(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public void dAF()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.crL) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.crL = true;
    this.hh = new NearbyPeopleProfileActivity.22(this);
    ThreadManager.post(this.hh, 5, null, true);
  }
  
  public void dAy()
  {
    aurd.cE(this);
    this.yi.clear();
    this.yi.addAll(this.yj);
    this.yj.clear();
    if (this.jdField_a_of_type_Akcw != null) {
      this.jdField_a_of_type_Akcw.dAL();
    }
    if (this.crv)
    {
      this.crx = false;
      this.jdField_c_of_type_Ajrs.eA(new ArrayList());
    }
    int i = this.aj.getIntExtra("param_mode", 0);
    if (i == 1)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.aWh)
      {
        if (this.bkW)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.bkW);
          localIntent.setFlags(67108864);
          startActivity(localIntent);
        }
        finish();
      }
    }
    for (;;)
    {
      this.crv = false;
      MJ(false);
      return;
      MK(false);
      continue;
      if ((i == 2) && (this.mMode == 1)) {
        dAz();
      }
    }
  }
  
  protected void dAz()
  {
    if (this.mMode == 2)
    {
      if (this.jdField_a_of_type_Akcw != null) {
        this.jdField_a_of_type_Akcw.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      }
      return;
    }
    this.mMode = 2;
    if (this.jdField_a_of_type_Akfj != null) {
      this.jdField_a_of_type_Akfj.isEditing = false;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new akcf(this));
    this.Fg.clearAnimation();
    this.Fg.startAnimation(localAlphaAnimation);
  }
  
  public void dN(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.setMessage(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Arhz.show();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 14)
    {
      this.jdField_a_of_type_Akfj.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (this.mMode == 1)
    {
      this.jdField_a_of_type_Akfj.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_Akcw.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc_w 1154
    //   7: iconst_0
    //   8: invokevirtual 271	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11: pop
    //   12: aload_0
    //   13: invokevirtual 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   16: ldc_w 1156
    //   19: invokevirtual 1160	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +17 -> 42
    //   28: aload_0
    //   29: invokevirtual 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   32: ldc_w 1156
    //   35: ldc_w 1162
    //   38: invokevirtual 893	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: getstatic 1167	aurh:c	Laurh;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +20 -> 67
    //   50: aload_3
    //   51: invokevirtual 1170	aurh:aJB	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: iconst_0
    //   59: invokevirtual 1173	aurh:aaZ	(I)V
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 1176	aurh:aaY	(I)V
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 1179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mActNeedImmersive	Z
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 1182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mNeedStatusTrans	Z
    //   77: aload_1
    //   78: ifnull +11 -> 89
    //   81: aload_1
    //   82: ldc_w 1184
    //   85: aconst_null
    //   86: invokevirtual 1188	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 1190	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   94: pop
    //   95: aload_0
    //   96: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: aload_0
    //   100: getfield 190	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Ajrw	Lajrw;
    //   103: invokevirtual 1194	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lacci;)V
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   111: putfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   114: aload_0
    //   115: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: invokevirtual 1197	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   121: ifeq +10 -> 131
    //   124: aload_0
    //   125: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   128: ifnonnull +9 -> 137
    //   131: aload_0
    //   132: invokevirtual 941	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_0
    //   138: ldc_w 1198
    //   141: invokespecial 1201	android/support/v4/app/FragmentActivity:setContentView	(I)V
    //   144: aload_0
    //   145: invokevirtual 1205	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getWindow	()Landroid/view/Window;
    //   148: aconst_null
    //   149: invokevirtual 1210	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual 1001	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokevirtual 1214	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   160: getfield 1219	android/util/DisplayMetrics:density	F
    //   163: putfield 1221	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mDensity	F
    //   166: aload_0
    //   167: aload_0
    //   168: invokevirtual 1130	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getTitleBarHeight	()I
    //   171: putfield 742	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mTitleBarHeight	I
    //   174: aload_0
    //   175: aload_0
    //   176: invokevirtual 1001	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   179: invokevirtual 1214	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   182: getfield 1224	android/util/DisplayMetrics:widthPixels	I
    //   185: iconst_3
    //   186: idiv
    //   187: putfield 1226	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:imageWidth	I
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 1001	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   195: invokevirtual 1214	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   198: getfield 1224	android/util/DisplayMetrics:widthPixels	I
    //   201: putfield 1228	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmt	I
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: bipush 60
    //   211: invokevirtual 1232	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   214: checkcast 698	ajrs
    //   217: putfield 696	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_c_of_type_Ajrs	Lajrs;
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   225: bipush 15
    //   227: invokevirtual 710	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   230: checkcast 1234	amhj
    //   233: putfield 1236	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Amhj	Lamhj;
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: bipush 59
    //   243: invokevirtual 710	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   246: checkcast 1238	accv
    //   249: putfield 1240	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:f	Laccv;
    //   252: aload_0
    //   253: getfield 1240	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:f	Laccv;
    //   256: aload_0
    //   257: invokevirtual 1244	accv:aV	(Ljava/lang/Object;)V
    //   260: aload_0
    //   261: getfield 1240	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:f	Laccv;
    //   264: aload_0
    //   265: getfield 214	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Accv$b	Laccv$b;
    //   268: invokevirtual 1247	accv:addListener	(Ljava/lang/Object;)V
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: sipush 180
    //   279: invokevirtual 710	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   282: checkcast 1249	advr
    //   285: putfield 1251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advr	Ladvr;
    //   288: aload_0
    //   289: aload_0
    //   290: getfield 1251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advr	Ladvr;
    //   293: invokevirtual 1254	advr:a	()Ladvm;
    //   296: putfield 230	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Advm	Ladvm;
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 1251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advr	Ladvr;
    //   304: iconst_4
    //   305: invokevirtual 1257	advr:iQ	(I)Z
    //   308: putfield 1259	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:crG	Z
    //   311: aload_0
    //   312: getfield 1251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advr	Ladvr;
    //   315: invokevirtual 1262	advr:a	()Ladvl;
    //   318: ifnull +39 -> 357
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 1251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advr	Ladvr;
    //   326: invokevirtual 1262	advr:a	()Ladvl;
    //   329: getfield 1267	advl:cKo	I
    //   332: putfield 158	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmA	I
    //   335: aload_0
    //   336: getfield 158	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmA	I
    //   339: iflt +12 -> 351
    //   342: aload_0
    //   343: getfield 158	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmA	I
    //   346: bipush 30
    //   348: if_icmple +9 -> 357
    //   351: aload_0
    //   352: bipush 18
    //   354: putfield 158	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmA	I
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   362: ldc_w 258
    //   365: invokevirtual 1271	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   368: checkcast 626	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   371: putfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   374: aload_0
    //   375: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   378: ifnonnull +72 -> 450
    //   381: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +13 -> 397
    //   387: ldc_w 464
    //   390: iconst_2
    //   391: ldc_w 1273
    //   394: invokestatic 841	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload_0
    //   398: invokevirtual 941	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   401: iconst_1
    //   402: ireturn
    //   403: astore_1
    //   404: aload_0
    //   405: invokevirtual 941	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   408: iconst_0
    //   409: ireturn
    //   410: astore_1
    //   411: invokestatic 291	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -40 -> 374
    //   417: ldc_w 464
    //   420: iconst_2
    //   421: new 550	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 551	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 1275
    //   431: invokevirtual 557	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 1278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 557	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 568	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 841	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: goto -73 -> 374
    //   450: aload_0
    //   451: aload_0
    //   452: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   455: ldc_w 268
    //   458: iconst_0
    //   459: invokevirtual 1100	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   462: putfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   465: aload_0
    //   466: getfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   469: bipush 35
    //   471: if_icmpne +9 -> 480
    //   474: aload_0
    //   475: iconst_0
    //   476: iconst_1
    //   477: invokestatic 1284	aqfy:anim	(Landroid/app/Activity;ZZ)V
    //   480: aload_0
    //   481: getfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   484: invokestatic 532	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:kI	(I)Z
    //   487: ifeq +368 -> 855
    //   490: aload_0
    //   491: bipush 51
    //   493: putfield 1286	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dms	I
    //   496: aload_0
    //   497: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   500: ldc_w 686
    //   503: iconst_0
    //   504: invokevirtual 1100	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   507: istore_2
    //   508: iload_2
    //   509: iconst_2
    //   510: if_icmpeq +8 -> 518
    //   513: iload_2
    //   514: iconst_1
    //   515: if_icmpne +30 -> 545
    //   518: aload_0
    //   519: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   522: getfield 627	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   525: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifeq +17 -> 545
    //   531: aload_0
    //   532: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   535: aload_0
    //   536: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   539: invokevirtual 1289	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   542: putfield 627	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   550: ldc_w 686
    //   553: iconst_0
    //   554: invokevirtual 1100	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   557: putfield 336	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mMode	I
    //   560: aload_0
    //   561: aload_0
    //   562: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   565: ldc_w 1291
    //   568: iconst_0
    //   569: invokevirtual 483	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   572: putfield 146	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:crB	Z
    //   575: aload_0
    //   576: aload_0
    //   577: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   580: ldc_w 1293
    //   583: lconst_0
    //   584: invokevirtual 1297	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   587: putfield 1299	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:adP	J
    //   590: aload_0
    //   591: aload_0
    //   592: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   595: ldc_w 1301
    //   598: lconst_0
    //   599: invokevirtual 1297	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   602: putfield 227	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:adQ	J
    //   605: aload_0
    //   606: aload_0
    //   607: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   610: ldc_w 1303
    //   613: iconst_0
    //   614: invokevirtual 1100	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   617: putfield 224	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmC	I
    //   620: aload_0
    //   621: aload_0
    //   622: ldc_w 1304
    //   625: invokevirtual 1305	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:findViewById	(I)Landroid/view/View;
    //   628: checkcast 361	android/view/ViewGroup
    //   631: putfield 245	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dN	Landroid/view/ViewGroup;
    //   634: aload_0
    //   635: getfield 336	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mMode	I
    //   638: iconst_1
    //   639: if_icmpne +245 -> 884
    //   642: aload_0
    //   643: aload_0
    //   644: aload_0
    //   645: getfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   648: invokevirtual 373	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lakfj;
    //   651: putfield 237	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Akfj	Lakfj;
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 237	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Akfj	Lakfj;
    //   659: invokevirtual 377	akfj:getContentView	()Landroid/view/View;
    //   662: putfield 241	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fg	Landroid/view/View;
    //   665: aload_0
    //   666: getfield 245	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dN	Landroid/view/ViewGroup;
    //   669: aload_0
    //   670: getfield 241	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fg	Landroid/view/View;
    //   673: new 379	android/widget/FrameLayout$LayoutParams
    //   676: dup
    //   677: iconst_m1
    //   678: iconst_m1
    //   679: invokespecial 382	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   682: invokevirtual 386	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 154	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmw	I
    //   690: iconst_1
    //   691: iadd
    //   692: putfield 154	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmw	I
    //   695: aload_0
    //   696: iconst_1
    //   697: putfield 439	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:crt	Z
    //   700: aload_0
    //   701: getfield 230	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Advm	Ladvm;
    //   704: ifnull +14 -> 718
    //   707: aload_0
    //   708: getfield 230	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Advm	Ladvm;
    //   711: aload_0
    //   712: getfield 195	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Advm$a	Ladvm$a;
    //   715: invokevirtual 1310	advm:a	(Ladvm$a;)V
    //   718: aload_0
    //   719: ldc_w 1311
    //   722: invokestatic 791	acfp:m	(I)Ljava/lang/String;
    //   725: invokevirtual 1313	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dN	(Ljava/lang/String;)V
    //   728: new 1315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1
    //   731: dup
    //   732: aload_0
    //   733: invokespecial 1316	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V
    //   736: iconst_5
    //   737: aconst_null
    //   738: iconst_0
    //   739: invokestatic 503	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   742: aload_3
    //   743: ifnull +15 -> 758
    //   746: aload_3
    //   747: invokevirtual 1170	aurh:aJB	()Z
    //   750: ifeq +8 -> 758
    //   753: aload_3
    //   754: iconst_4
    //   755: invokevirtual 1176	aurh:aaY	(I)V
    //   758: new 1318	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2
    //   761: dup
    //   762: aload_0
    //   763: aload_3
    //   764: invokespecial 1321	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;Laurh;)V
    //   767: bipush 8
    //   769: aconst_null
    //   770: iconst_0
    //   771: invokestatic 503	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   774: aload_0
    //   775: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   778: bipush 71
    //   780: invokevirtual 710	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   783: checkcast 1323	afci
    //   786: astore_1
    //   787: aload_1
    //   788: invokevirtual 1326	afci:a	()Lafde;
    //   791: invokevirtual 1331	afde:getUnreadCount	()I
    //   794: ifle +10 -> 804
    //   797: aload_1
    //   798: invokevirtual 1326	afci:a	()Lafde;
    //   801: invokevirtual 1334	afde:aIH	()V
    //   804: aload_0
    //   805: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   808: ifnull +16 -> 824
    //   811: aload_0
    //   812: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   815: getfield 1337	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   818: sipush 999
    //   821: if_icmpne +184 -> 1005
    //   824: bipush 30
    //   826: istore_2
    //   827: aload_0
    //   828: getfield 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   831: aload_0
    //   832: invokevirtual 1341	java/lang/Object:getClass	()Ljava/lang/Class;
    //   835: aload_0
    //   836: invokevirtual 1344	java/lang/Object:hashCode	()I
    //   839: ldc_w 1346
    //   842: iload_2
    //   843: aload_0
    //   844: getfield 1299	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:adP	J
    //   847: invokestatic 1351	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   850: invokestatic 1356	anpo:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/Class;ILjava/lang/String;ILjava/lang/String;)V
    //   853: iconst_1
    //   854: ireturn
    //   855: aload_0
    //   856: aload_0
    //   857: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   860: getfield 1337	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   863: putfield 1286	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dms	I
    //   866: aload_0
    //   867: aload_0
    //   868: aload_0
    //   869: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   872: getfield 1337	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   875: invokevirtual 1360	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:ir	(I)I
    //   878: putfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   881: goto -385 -> 496
    //   884: aload_0
    //   885: aload_0
    //   886: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   889: ldc_w 1362
    //   892: invokevirtual 1160	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   895: putfield 1364	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:bTc	Ljava/lang/String;
    //   898: aload_0
    //   899: aload_0
    //   900: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   903: ldc_w 1366
    //   906: iconst_0
    //   907: invokevirtual 1100	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   910: putfield 1368	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dmu	I
    //   913: aload_0
    //   914: aload_0
    //   915: getfield 477	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:aj	Landroid/content/Intent;
    //   918: ldc_w 1370
    //   921: iconst_0
    //   922: invokevirtual 483	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   925: putfield 1372	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:cry	Z
    //   928: aload_0
    //   929: aload_0
    //   930: aload_0
    //   931: getfield 152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:from	I
    //   934: invokevirtual 1374	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lakcw;
    //   937: putfield 233	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Akcw	Lakcw;
    //   940: aload_0
    //   941: aload_0
    //   942: getfield 233	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Akcw	Lakcw;
    //   945: invokevirtual 1375	akcw:getContentView	()Landroid/view/View;
    //   948: putfield 308	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fh	Landroid/view/View;
    //   951: aload_0
    //   952: getfield 233	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Akcw	Lakcw;
    //   955: invokevirtual 1378	akcw:dAH	()V
    //   958: aload_0
    //   959: getfield 308	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fh	Landroid/view/View;
    //   962: instanceof 1380
    //   965: ifeq +17 -> 982
    //   968: aload_0
    //   969: getfield 308	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fh	Landroid/view/View;
    //   972: checkcast 1380	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   975: aload_0
    //   976: getfield 221	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ahmm	Lahmm;
    //   979: invokevirtual 1384	com/tencent/mobileqq/widget/PerfRelativeLayout:setOnDrawCompleteListener	(Lahmm;)V
    //   982: aload_0
    //   983: getfield 245	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:dN	Landroid/view/ViewGroup;
    //   986: aload_0
    //   987: getfield 308	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:Fh	Landroid/view/View;
    //   990: new 379	android/widget/FrameLayout$LayoutParams
    //   993: dup
    //   994: iconst_m1
    //   995: iconst_m1
    //   996: invokespecial 382	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   999: invokevirtual 386	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1002: goto -302 -> 700
    //   1005: aload_0
    //   1006: getfield 619	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1009: getfield 1337	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1012: istore_2
    //   1013: goto -186 -> 827
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	NearbyPeopleProfileActivity
    //   0	1016	1	paramBundle	Bundle
    //   507	506	2	i	int
    //   45	719	3	localaurh	aurh
    // Exception table:
    //   from	to	target	type
    //   137	144	403	java/lang/OutOfMemoryError
    //   357	374	410	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_b_of_type_Ajrw);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.f != null)
    {
      this.f.removeListener(this.jdField_b_of_type_Accv$b);
      this.f.removeListener(this.jdField_a_of_type_Accv$b);
      this.f.aW(this);
    }
    if (this.jdField_a_of_type_Akfj != null) {
      this.jdField_a_of_type_Akfj.dzo();
    }
    if (this.app.a().xX != null) {}
    for (int i = this.app.a().xX.size();; i = 0)
    {
      int j;
      if (this.jdField_a_of_type_Akcw != null)
      {
        j = this.jdField_a_of_type_Akcw.GN();
        this.jdField_a_of_type_Akcw.doOnDestory();
      }
      for (;;)
      {
        Object localObject = (aomd)this.app.a().a(null, 0L);
        if (localObject != null) {
          ((aomd)localObject).bme();
        }
        try
        {
          if (this.aj.getIntExtra("frome_where", 0) == -2)
          {
            if (this.dmz > 0) {
              anot.a(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_Akcw != null) {
              this.jdField_a_of_type_Akcw.dAI();
            }
            localObject = anpo.a(getClass(), hashCode());
            if (localObject != null)
            {
              anot.a(this.app, "CliOper", "", "", ((anpo.a)localObject).cgi, ((anpo.a)localObject).cgi, ((anpo.a)localObject).arg1, 0, String.valueOf(this.adP), Long.toString(SystemClock.elapsedRealtime() - ((anpo.a)localObject).startTime), "", "");
              int k = (int)(SystemClock.elapsedRealtime() - ((anpo.a)localObject).startTime) / 1000;
              if (ajqp.ba(this.jdField_e_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.bJa, this.mMode)) {
                this.app.a().f(this.adP, k, i, j);
              }
            }
            if (!Build.BRAND.startsWith("samsung")) {
              break label472;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              localObject = Class.forName("android.text.MeasuredText").getDeclaredField("sCached");
              ((Field)localObject).setAccessible(true);
              localObject = (Object[])((Field)localObject).get(null);
              i = 0;
              if (i >= localObject.length) {
                break;
              }
              localObject[i] = null;
              i += 1;
              continue;
              anot.a(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            localException = localException;
          }
        }
        label472:
        return;
        j = 0;
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    do
    {
      for (;;)
      {
        return;
        if (this.mMode != 1) {
          break label233;
        }
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break;
        }
        this.mAlbumId = null;
        int i = 0;
        while (i < paramIntent.size())
        {
          if (this.yi.size() < dmr)
          {
            localObject = new PicInfo();
            ((PicInfo)localObject).localPath = ((String)paramIntent.get(i));
            if (this.jdField_a_of_type_Akfj.a((PicInfo)localObject)) {
              this.mHandler.sendEmptyMessageDelayed(100, 1000L);
            }
          }
          i += 1;
        }
      }
    } while (TextUtils.isEmpty(this.mAlbumId));
    paramIntent = avpw.d.a();
    paramIntent.cMP = this.app.getCurrentAccountUin();
    paramIntent.nickname = this.app.getCurrentNickname();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", getString(2131718034));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.mAlbumId);
    ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
    avpw.a(this, paramIntent, (Bundle)localObject, 5);
    return;
    label233:
    akks.c(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    aurd.cE(this);
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app.removeObserver(this.jdField_a_of_type_Acgf);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    if (this.jdField_a_of_type_Akcw != null) {
      this.jdField_a_of_type_Akcw.doOnPause();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Akcw != null) {
      this.jdField_a_of_type_Akcw.doOnResume();
    }
    this.app.addObserver(this.jdField_c_of_type_Acfd);
    this.app.addObserver(this.jdField_a_of_type_Acgf);
    ApngImage.playByTag(15);
    AbstractVideoImage.resumeAll();
    if (getApplication() == null) {
      finish();
    }
    do
    {
      return;
      super.doOnResume();
      ajpj localajpj = (ajpj)this.app.getManager(106);
      if ((this.jdField_a_of_type_Akcw != null) && (this.jdField_a_of_type_Akcw.crN))
      {
        localajpj.go.put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
        this.jdField_a_of_type_Akcw.crN = false;
      }
      this.crC = localajpj.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "doOnResume, isNeedUpdateProfile=" + this.crC + ", isForceUpdateOnResume=" + this.crD);
      }
      if ((this.crC) || (this.crD))
      {
        this.crD = false;
        ThreadManager.post(new NearbyPeopleProfileActivity.3(this), 8, null, false);
        this.crF = false;
        return;
      }
      if ((!this.crF) || (this.mMode != 3) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L);
    ThreadManager.post(new NearbyPeopleProfileActivity.4(this), 8, null, false);
    this.crF = false;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Akcw != null) {
      this.jdField_a_of_type_Akcw.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.crF = true;
    if ((this.mMode == 2) && (this.jdField_a_of_type_Akcw != null) && (this.jdField_a_of_type_Akcw.arI()))
    {
      this.jdField_a_of_type_Akcw.dAJ();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_Akcw != null)) {
        this.jdField_a_of_type_Akcw.dAK();
      }
    }
    aurh localaurh = aurh.c;
    if ((localaurh != null) && (localaurh.bJ(true))) {
      localaurh.Zy(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_Akcw != null) {
      this.jdField_a_of_type_Akcw.doOnStop();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.crM)
    {
      this.dmv = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.aWh = this.aj.getBooleanExtra("is_from_web", false);
      this.bkW = this.aj.getBooleanExtra("abp_flag", false);
      if (this.aj.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.aj.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        anot.a(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.crM = true;
    }
  }
  
  public void dzt()
  {
    this.av = aqha.a(this, 2131701369, getString(2131701368), 2131721058, 2131701367, new akct(this), new akcu(this));
    if ((this.av != null) && (!isFinishing())) {
      this.av.show();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.bkW) {
      overridePendingTransition(2130772000, 2130772001);
    }
  }
  
  protected int ir(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 11;
    case 10: 
      return 1;
    case 5: 
      return 3;
    case 32: 
    case 34: 
    case 35: 
      return 4;
    case 20: 
    case 31: 
    case 33: 
      return 5;
    case 21: 
      return 6;
    case 99: 
      return 13;
    }
    return 14;
  }
  
  public boolean isWrapContent()
  {
    boolean bool = true;
    if (this.mMode == 1) {
      bool = false;
    }
    return bool;
  }
  
  public void ko(long paramLong)
  {
    L(paramLong, -1, -1);
  }
  
  public boolean onBackEvent()
  {
    int i = this.aj.getIntExtra("param_mode", 0);
    if (i == 1)
    {
      RL(2131701373);
      return true;
    }
    if ((i == 2) && (this.mMode == 1))
    {
      if (this.dmv == 0)
      {
        RL(2131701373);
        return true;
      }
      if (this.jdField_a_of_type_Akfj.arK())
      {
        RL(2131701363);
        return true;
      }
      dAy();
      return true;
    }
    if (this.bkW)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.bkW);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localIntent.putExtra("nearby_profile_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      localIntent.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      localIntent.putExtra("param_vote_num", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount);
      localIntent.putExtra("param_vote_num_add", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc);
      localIntent.putExtra("param_level", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel);
    }
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      Object localObject = this.app.b().f(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label477;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label467:
    label472:
    label477:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onBackEvent hasSayHi: " + bool);
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.adP));
      localIntent.putExtra("intent_key_has_ever_vote", this.aWs);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.videoUrl)))
        {
          bool = true;
          localIntent.putExtra("param_real_video_auth", bool);
        }
      }
      else
      {
        setResult(-1, localIntent);
        if (getIntent().getIntExtra("frome_where", 0) != 35) {
          break label467;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label472;
        }
        finish();
        aqfy.anim(this, false, false);
        return true;
        bool = false;
        break;
      }
      return super.onBackEvent();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      View localView = getWindow().getDecorView();
      if ((localView != null) && ((localView instanceof ViewGroup)))
      {
        localView = ((ViewGroup)localView).getChildAt(0);
        if ((localView != null) && ((localView instanceof TopGestureLayout))) {
          this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localView);
        }
      }
    }
    if (this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_e_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).show(this.mTitleBarHeight);
  }
  
  public static class CloseReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && (paramContext != null) && ((paramContext instanceof NearbyPeopleProfileActivity)))
      {
        paramContext = (NearbyPeopleProfileActivity)paramContext;
        paramIntent = paramIntent.getStringExtra("uin");
        if ((!TextUtils.isEmpty(paramIntent)) && (aqft.equalsWithNullCheck(paramIntent, paramContext.mUin)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "onReceive,close on uin:" + paramIntent);
          }
          paramContext.finish();
        }
      }
    }
  }
  
  class DownloadHDAvatarRunnable
    implements Runnable
  {
    private int dmE;
    private boolean isUpdate;
    private String uin;
    private String url;
    
    DownloadHDAvatarRunnable(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
    {
      this.uin = paramString1;
      this.dmE = paramInt;
      this.url = paramString2;
      this.isUpdate = paramBoolean;
    }
    
    public void run()
    {
      int j = 1;
      Object localObject = this.url + this.dmE;
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby_people_card.", 2, "downloadHDAvatar()  uin=" + this.uin + ", mgSize=" + this.dmE + ", url = " + (String)localObject);
      }
      File localFile1 = new File(aqep.pe(String.valueOf(this.uin)));
      boolean bool2;
      if ((localFile1.exists()) && (!this.isUpdate))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.nearby_people_card.", 2, "download HDAvatar file is exists");
        }
        bool2 = true;
        localObject = new Message();
        ((Message)localObject).what = 102;
        if (!bool2) {
          break label398;
        }
        i = 1;
        label158:
        ((Message)localObject).arg1 = i;
        if (!this.isUpdate) {
          break label403;
        }
      }
      label398:
      label403:
      for (int i = j;; i = 0)
      {
        for (;;)
        {
          ((Message)localObject).arg2 = i;
          NearbyPeopleProfileActivity.this.mHandler.sendMessage((Message)localObject);
          return;
          File localFile2 = new File(localFile1.getPath() + Long.toString(System.currentTimeMillis()));
          String str = MsfSdkUtils.insertMtype("friendlist", (String)localObject);
          try
          {
            localObject = new URL(str);
            localObject = new URL(((URL)localObject).getProtocol(), aeib.dR(0), ((URL)localObject).getFile()).toString();
            if (HttpDownloadUtil.a(NearbyPeopleProfileActivity.this.app, new afka((String)localObject, localFile2, 0), null) == 0)
            {
              bool2 = true;
              boolean bool1 = bool2;
              if (bool2) {
                bool1 = localFile2.renameTo(localFile1);
              }
              NearbyPeopleProfileActivity.this.crK = bool1;
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Q.nearby_people_card.", 2, "donwload HDAvatar finish : " + bool1);
              bool2 = bool1;
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localObject = str;
              if (QLog.isDevelopLevel())
              {
                localMalformedURLException.printStackTrace();
                localObject = str;
                continue;
                bool2 = false;
              }
            }
          }
        }
        i = 0;
        break label158;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */