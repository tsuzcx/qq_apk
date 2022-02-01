package com.tencent.mobileqq.apollo;

import abhh;
import abhh.f;
import abkw;
import ablb;
import abrj;
import abrm;
import abrs;
import abvg;
import abwh;
import abyv;
import abzf;
import acej;
import acff;
import acfp;
import alcn;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqgz;
import aqrb;
import aqrd;
import arho;
import auru;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wja;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  public boolean VN;
  private abrs jdField_a_of_type_Abrs;
  private abzf jdField_a_of_type_Abzf;
  protected ApolloTextureView a;
  private RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask;
  private a jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$a;
  private b jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b;
  protected ApolloBoxEnterView a;
  public auru b;
  public ApolloBaseInfo b;
  boolean bDk;
  private boolean bDl;
  private boolean bDm;
  private String bgy = "";
  protected FrameGifView c;
  public int cpl;
  protected int cpm;
  private java.lang.ref.WeakReference<FriendProfileCardActivity> fk;
  private java.lang.ref.WeakReference<View> fl;
  private java.lang.ref.WeakReference<QQAppInterface> mAppRef;
  protected int[] mDressIds;
  protected int mRoleId;
  protected float sl;
  
  public FriendCardApolloViewController(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView)
  {
    this.fk = new java.lang.ref.WeakReference(paramFriendProfileCardActivity);
    this.fl = new java.lang.ref.WeakReference(paramView);
    this.mAppRef = new java.lang.ref.WeakReference(paramFriendProfileCardActivity.app);
    this.b = new auru(paramFriendProfileCardActivity.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask = new RefreshApolloTask(paramFriendProfileCardActivity, this);
  }
  
  public void DG(boolean paramBoolean)
  {
    Object localObject1 = (FriendProfileCardActivity)this.fk.get();
    if (localObject1 == null) {
      return;
    }
    alcn localalcn = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_Alcn;
    if ((localalcn != null) && (localalcn.e != null)) {}
    for (localObject1 = localalcn.e.uin;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localalcn != null)
        {
          localObject2 = localObject1;
          if (localalcn.d != null) {
            localObject2 = localalcn.d.uin;
          }
        }
      }
      localObject1 = getApp();
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (localObject1 == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.c((QQAppInterface)localObject1, "friendcard", (String)localObject2, -1);
      return;
    }
  }
  
  void a(abhh.f paramf)
  {
    View localView = (View)this.fl.get();
    QQAppInterface localQQAppInterface = getApp();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.fk.get();
    if ((paramf == null) || (localQQAppInterface == null) || (localView == null) || (localFriendProfileCardActivity == null) || (!(localView instanceof RelativeLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramf.roleId + " apolloStatus->" + this.cpl + " needStatic->" + paramf.bDa);
      }
    } while (paramf.bDa);
    Object localObject2 = null;
    alcn localalcn = localFriendProfileCardActivity.jdField_a_of_type_Alcn;
    Object localObject1 = localObject2;
    if (localalcn != null)
    {
      localObject1 = localObject2;
      if (localalcn.e != null) {
        localObject1 = localalcn.e.uin;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localalcn != null) && (localalcn.d != null)) {
      localObject1 = localalcn.d.uin;
    }
    for (;;)
    {
      boolean bool;
      label206:
      int i;
      int j;
      if (paramf.coQ == 2)
      {
        bool = true;
        this.bDl = bool;
        long l = Math.max(aqgz.hJ(), aqgz.hI());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label997;
        }
        abwh.a(paramf.coR, 10, 0, new Object[] { "switch done" });
        abwh.gN(paramf.coR, 100);
        float f = (float)aqgz.hK() / aqgz.getDesity();
        i = (int)(0.4D * l);
        j = abkw.c(i, aqgz.hK());
        this.sl = (j / aqgz.getDesity() - f * 204.0F / 1080.0F);
        f = acej.aV() / 16.0F;
        if (f != 0.0F) {
          this.sl = (f * this.sl);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_Abrs = new abrs(localQQAppInterface);
        this.jdField_a_of_type_Abrs.g(f, this.sl, 0.0F);
        this.jdField_a_of_type_Abzf = new abzf(this.jdField_a_of_type_Abrs, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Abzf);
          this.jdField_a_of_type_Abrs.b(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_Abrs.kc((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.mRoleId = paramf.roleId;
          this.mDressIds = paramf.dressIds;
          paramf = (RelativeLayout)localView.getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_Abzf);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.getCurrentUin())))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b == null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b = new b(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b);
            ((aqrb)localQQAppInterface.getBusinessHandler(71)).XO(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$a = new a(null);
          this.jdField_a_of_type_Abrs.a(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$a);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = wja.dp2px(56.0F, localFriendProfileCardActivity.getResources());
          paramf.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
          if (localObject1 != null)
          {
            if (!((String)localObject1).equals(localQQAppInterface.getCurrentUin())) {
              break label875;
            }
            if (!this.bDl) {
              break label870;
            }
            i = 1;
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_show", 0, i, new String[0]);
          }
          if ((this.bDk) && (abhh.h(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(wja.dp2px(45.0F, localFriendProfileCardActivity.getResources()), wja.dp2px(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = wja.dp2px(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(75.0F, localFriendProfileCardActivity.getResources());
            paramf.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            DG(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$a);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramf)
        {
          QLog.e("FriendCardApolloViewController", 1, paramf, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label206;
        label870:
        i = 0;
        continue;
        label875:
        localObject2 = ((abhh)localQQAppInterface.getManager(153)).b(localQQAppInterface.getCurrentUin());
        if (localObject2 != null) {
          this.cpm = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        j = this.cpm;
        if (this.bDl) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + abhh.a(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label997:
        abwh.a(paramf.coR, 10, 107, new Object[0]);
      }
    }
  }
  
  public void c(alcn paramalcn)
  {
    if ((paramalcn != null) && (paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(getApp(), paramalcn.troopUin))) {}
    do
    {
      do
      {
        return;
      } while ((paramalcn != null) && (paramalcn.e != null) && (paramalcn.e.pa == 53));
      paramalcn = (FriendProfileCardActivity)this.fk.get();
    } while ((this.b == null) || (getApp() == null) || (paramalcn == null) || (!(this.fl.get() instanceof RelativeLayout)) || (!abhh.a(paramalcn, Boolean.valueOf(false))) || (this.bDm) || (!paramalcn.jdField_a_of_type_Arho.mI(1)));
    this.bDm = true;
    int i = abrj.gf(2);
    abwh.Il(i);
    abwh.gN(i, 1);
    abwh.gN(i, 10);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16);
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16, null, true);
  }
  
  public QQAppInterface getApp()
  {
    if ((this.mAppRef == null) || (this.mAppRef.get() == null)) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof abhh.f)) {
        a((abhh.f)paramMessage.obj);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.b != null)
    {
      this.b.removeCallbacksAndMessages(null);
      this.b.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b);
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$b = null;
      }
      if (this.jdField_a_of_type_Abzf != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Abzf);
      }
    }
    abvg.bFT = false;
    if (this.jdField_a_of_type_Abrs != null) {
      this.jdField_a_of_type_Abrs.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Abrs != null) {
      this.jdField_a_of_type_Abrs.doOnPause();
    }
    this.bDm = false;
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Abrs != null) {
      this.jdField_a_of_type_Abrs.doOnResume();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
  }
  
  public void onStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.stop();
    }
  }
  
  public void z(int paramInt1, int paramInt2, String paramString)
  {
    QQAppInterface localQQAppInterface = getApp();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.fk.get();
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_Alcn == null)) {
      return;
    }
    alcn localalcn = localFriendProfileCardActivity.jdField_a_of_type_Alcn;
    Object localObject1 = (abhh)localQQAppInterface.getManager(153);
    if (localalcn.e != null) {}
    label1034:
    for (String str1 = localalcn.e.uin;; str1 = null)
    {
      if ((TextUtils.isEmpty(str1)) && (localalcn.d != null)) {
        str1 = localalcn.d.uin;
      }
      label909:
      label1295:
      for (;;)
      {
        Object localObject2;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.contains("pet")))
        {
          paramString = (abhh)localQQAppInterface.getManager(153);
          if (str1.equals(localQQAppInterface.getCurrentUin()))
          {
            i = 0;
            localObject2 = paramString.is(str1);
            if (paramInt1 != 0) {
              break label445;
            }
            paramString = "0";
            label170:
            VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, i, new String[] { localObject2, paramString });
          }
        }
        else
        {
          if (paramInt1 != 0) {
            break label544;
          }
          DG(true);
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.getCurrentUin()))) {
            break label457;
          }
          if (!this.bDl) {
            break label452;
          }
        }
        label410:
        label445:
        label452:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_jump", 0, paramInt2, new String[0]);
          paramString = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
          if ((this.b != null) && (paramString != null) && (((paramString instanceof ProfileTagView)) || ((paramString instanceof VipProfileSimpleView)))) {
            this.b.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.c != null) && (this.c.getVisibility() == 0) && (paramInt1 == 1)) {
            this.c.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localalcn != null)
          {
            paramInt2 = i;
            if (localalcn.e != null)
            {
              if (localalcn.e.pa != 0) {
                break label1486;
              }
              if (paramInt1 != 0) {
                break label1481;
              }
              paramInt2 = 1;
            }
          }
          anot.a(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
          return;
          i = 1;
          break;
          paramString = "1";
          break label170;
        }
        label457:
        int i = this.cpm;
        if (this.bDl) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + abhh.a(localQQAppInterface), "0", "0", str1 });
          break;
        }
        label544:
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str1 });
        }
        if ((localalcn.d != null) && (localQQAppInterface.getCurrentUin().equals(localalcn.d.uin)))
        {
          paramInt2 = 1;
          label618:
          if ((!this.bDk) && ((localalcn.e == null) || (localalcn.e.pa != 0)) && (paramInt2 == 0)) {
            break label1055;
          }
          if (paramInt2 == 0) {
            break label909;
          }
          paramString = ((abhh)localObject1).s(2, ((abhh)localObject1).bga);
          label664:
          localFriendProfileCardActivity.aWC = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_box_uin", str1);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)
          {
            ((Intent)localObject1).putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.Zh());
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
              ((Intent)localObject1).putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.zQ());
            }
          }
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ((Intent)localObject1).putExtra("extra_key_box_from", "friendcard");
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.getCurrentUin()))) {
            break label929;
          }
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile", paramString, null);
          if (!this.bDl) {
            break label924;
          }
          paramInt2 = 1;
          label829:
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_clk", 0, paramInt2, new String[0]);
          label849:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label1034;
          }
          if (!this.VN) {
            break label1048;
          }
        }
        label1041:
        label1048:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          break;
          paramInt2 = 0;
          break label618;
          paramString = ((abhh)localObject1).r(str1, this.bDl);
          break label664;
          label924:
          paramInt2 = 0;
          break label829;
          label929:
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.cpm;
          if (this.bDl)
          {
            paramInt2 = 1;
            label956:
            localObject1 = "" + abhh.a(localQQAppInterface);
            if (!this.VN) {
              break label1041;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break label849;
            break;
            paramInt2 = 0;
            break label956;
          }
        }
        label1055:
        if (!this.bDl)
        {
          localObject2 = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
          localObject1 = null;
          paramString = (String)localObject1;
          if (localalcn != null)
          {
            paramString = (String)localObject1;
            if (localalcn.e != null) {
              paramString = localalcn.e.nickname;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localalcn == null) || (localalcn.d == null)) {
            break label1500;
          }
          paramString = localalcn.d.strNick;
        }
        label1170:
        label1300:
        label1474:
        label1481:
        label1486:
        label1500:
        for (;;)
        {
          String str2;
          if (!TextUtils.isEmpty(str1))
          {
            ((Intent)localObject2).putExtra("extra_guest_uin", str1);
            i = this.cpm;
            if (!this.bDl) {
              break label1295;
            }
            paramInt2 = 1;
            str2 = "" + abhh.a(localQQAppInterface);
            if (!this.VN) {
              break label1300;
            }
          }
          for (localObject1 = "0";; localObject1 = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { str2, localObject1, "0", str1 });
            if (!TextUtils.isEmpty(paramString)) {
              ((Intent)localObject2).putExtra("extra_guest_nick", paramString);
            }
            ((Intent)localObject2).putExtra("extra_guest_from", 3);
            localFriendProfileCardActivity.startActivity((Intent)localObject2);
            localFriendProfileCardActivity.overridePendingTransition(2130772077, 0);
            break;
            paramInt2 = 0;
            break label1170;
          }
          paramString = ((abhh)localObject1).r(str1, true);
          localFriendProfileCardActivity.aWC = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.cpm;
          if (this.bDl)
          {
            paramInt2 = 1;
            label1389:
            localObject1 = "" + abhh.a(localQQAppInterface);
            if (!this.VN) {
              break label1474;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break;
            paramInt2 = 0;
            break label1389;
          }
          paramInt2 = 2;
          break label410;
          if (paramInt1 == 0)
          {
            paramInt2 = 3;
            break label410;
          }
          paramInt2 = 4;
          break label410;
        }
      }
    }
  }
  
  static class RefreshApolloTask
    implements Runnable
  {
    private java.lang.ref.WeakReference<FriendProfileCardActivity> fn;
    private java.lang.ref.WeakReference<FriendCardApolloViewController> fo;
    
    public RefreshApolloTask(FriendProfileCardActivity paramFriendProfileCardActivity, FriendCardApolloViewController paramFriendCardApolloViewController)
    {
      this.fn = new java.lang.ref.WeakReference(paramFriendProfileCardActivity);
      this.fo = new java.lang.ref.WeakReference(paramFriendCardApolloViewController);
    }
    
    public void run()
    {
      FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.fn.get();
      FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.fo.get();
      if ((localFriendProfileCardActivity == null) || (localFriendCardApolloViewController == null) || (localFriendCardApolloViewController.jdField_b_of_type_Auru == null)) {
        return;
      }
      Object localObject = (abhh)localFriendProfileCardActivity.app.getManager(153);
      int i = abrj.gf(2);
      if ((localObject != null) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.d != null)) {
        if ((localFriendProfileCardActivity.a.d.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin())) || ((localFriendProfileCardActivity.a.e != null) && (localFriendProfileCardActivity.a.e.uin.equals(localFriendProfileCardActivity.app.getCurrentAccountUin()))))
        {
          if (abhh.b(localFriendProfileCardActivity.app, "mycard", null) <= 0) {
            abwh.a(i, 10, 105, new Object[] { "mycard not open" });
          }
        }
        else if (abhh.b(localFriendProfileCardActivity.app, "friendcard", null) <= 0)
        {
          abwh.a(i, 10, 105, new Object[] { "friendcard not open" });
          return;
        }
      }
      abyv.loadSo("FriendCard");
      if ((localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.e != null)) {}
      for (localObject = localFriendProfileCardActivity.a.e.uin;; localObject = null)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject)) && (localFriendProfileCardActivity.a != null) && (localFriendProfileCardActivity.a.d != null)) {
          localObject = localFriendProfileCardActivity.a.d.uin;
        }
        for (;;)
        {
          abwh.b(i, (String)localObject, new int[0]);
          ApolloBaseInfo localApolloBaseInfo = ((abhh)localFriendProfileCardActivity.app.getManager(153)).b((String)localObject);
          if (localApolloBaseInfo != null)
          {
            localFriendCardApolloViewController.cpl = localApolloBaseInfo.apolloStatus;
            localFriendCardApolloViewController.jdField_b_of_type_ComTencentMobileqqDataApolloBaseInfo = localApolloBaseInfo;
          }
          localFriendCardApolloViewController.VN = ((acff)localFriendProfileCardActivity.app.getManager(51)).isFriend((String)localObject);
          if ((abhh.a(localFriendProfileCardActivity.app) != 1) || (localFriendCardApolloViewController.VN) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localFriendProfileCardActivity.app.getCurrentUin())))) {}
          abhh.f localf;
          for (boolean bool = true;; bool = false)
          {
            localFriendCardApolloViewController.bDk = bool;
            localf = abkw.a(localFriendProfileCardActivity.app, (String)localObject, localApolloBaseInfo, 2);
            if ((localf != null) && (!localf.bDa)) {
              break;
            }
            QLog.w("FriendCardApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
            return;
          }
          if (!abvg.f(localFriendProfileCardActivity.app, 7))
          {
            abwh.a(i, 10, 110, new Object[] { "role 0 not ready" });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("FriendCardApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
            return;
          }
          if ((localApolloBaseInfo != null) && (!localFriendCardApolloViewController.VN) && (abhh.R(localFriendProfileCardActivity.app)) && (localf.coQ != 0) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime >= 300L)) {
            ((aqrb)localFriendProfileCardActivity.app.getBusinessHandler(71)).Vx((String)localObject);
          }
          localObject = localFriendCardApolloViewController.jdField_b_of_type_Auru.obtainMessage(1);
          ((Message)localObject).obj = localf;
          localFriendCardApolloViewController.jdField_b_of_type_Auru.sendMessage((Message)localObject);
          return;
        }
      }
    }
  }
  
  class a
    implements abrm, View.OnClickListener
  {
    private a() {}
    
    public void A(int paramInt1, int paramInt2, String paramString)
    {
      ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.2(this, paramInt1, paramInt2, paramString));
    }
    
    public void TI()
    {
      Object localObject3 = null;
      QQAppInterface localQQAppInterface = FriendCardApolloViewController.this.getApp();
      FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)FriendCardApolloViewController.a(FriendCardApolloViewController.this).get();
      Object localObject1 = (View)FriendCardApolloViewController.b(FriendCardApolloViewController.this).get();
      if ((localQQAppInterface == null) || (localFriendProfileCardActivity == null) || (localObject1 == null)) {
        return;
      }
      if ((!TextUtils.isEmpty(FriendCardApolloViewController.a(FriendCardApolloViewController.this))) && ((FriendCardApolloViewController.this.a == null) || (FriendCardApolloViewController.this.a.getVisibility() != 0))) {
        ThreadManager.getUIHandler().post(new FriendCardApolloViewController.DrawerInfoCallback.1(this, localFriendProfileCardActivity, (View)localObject1));
      }
      Object localObject2 = localFriendProfileCardActivity.a;
      if ((localObject2 != null) && (((alcn)localObject2).e != null)) {}
      for (localObject1 = ((alcn)localObject2).e.uin;; localObject1 = null)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (((alcn)localObject2).d != null)) {}
        for (localObject2 = ((alcn)localObject2).d.uin;; localObject2 = localObject1)
        {
          abhh localabhh = (abhh)localQQAppInterface.getManager(153);
          localObject1 = localObject3;
          if (!FriendCardApolloViewController.a(FriendCardApolloViewController.this)) {
            localObject1 = localabhh.a(localQQAppInterface, (String)localObject2, new int[] { 4 });
          }
          int i = 5;
          if (localObject1 == null)
          {
            localObject1 = new ApolloActionData();
            ((ApolloActionData)localObject1).actionId = -1;
            ((ApolloActionData)localObject1).actionType = 0;
          }
          for (;;)
          {
            abrj.a(FriendCardApolloViewController.a(FriendCardApolloViewController.this), i, (ApolloActionData)localObject1);
            new ablb((String)localObject2).a(FriendCardApolloViewController.a(FriendCardApolloViewController.this), localFriendProfileCardActivity, localQQAppInterface, acfp.m(2131706570));
            return;
            i = 12;
          }
        }
      }
    }
    
    public void cCk() {}
    
    public void onClick(View paramView)
    {
      FriendCardApolloViewController.this.z(1, 0, null);
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  static class b
    extends aqrd
  {
    private java.lang.ref.WeakReference<FriendCardApolloViewController> fm;
    
    public b(FriendCardApolloViewController paramFriendCardApolloViewController)
    {
      this.fm = new mqq.util.WeakReference(paramFriendCardApolloViewController);
    }
    
    public void onGetExploreMsg(boolean paramBoolean, Object paramObject)
    {
      if (paramBoolean) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendCardApolloViewController", 1, "[onGetExploreMsg] get info end");
          }
          paramObject = new JSONObject((String)paramObject);
          if (paramObject.optInt("entry_id", -1) != 2) {
            return;
          }
          FriendCardApolloViewController localFriendCardApolloViewController = (FriendCardApolloViewController)this.fm.get();
          if (localFriendCardApolloViewController == null) {
            return;
          }
          FriendCardApolloViewController.a(localFriendCardApolloViewController, paramObject.optString("icon_url"));
          QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] iconUrl:" + FriendCardApolloViewController.a(localFriendCardApolloViewController));
          return;
        }
        catch (Exception paramObject) {}
      } else if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "[onGetExploreMsg] result:" + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */