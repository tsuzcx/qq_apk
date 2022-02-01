package com.tencent.mobileqq.apollo;

import abhh;
import abhh.f;
import abii;
import abjb;
import abjc;
import abkv;
import abkw;
import abkx;
import abky;
import abla;
import ablc;
import abld;
import abrj;
import abrm;
import abrs;
import abvg;
import abwh;
import abxh;
import abxi;
import abyy;
import abzf;
import acej;
import altq;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import aqgz;
import aqrb;
import aqrd;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SettingMeRelativeLayout;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wja;

public class SettingMeApolloViewController
  implements Handler.Callback, View.OnClickListener
{
  public static long NB = 180000L;
  protected View AG;
  public abkv a;
  private abrm jdField_a_of_type_Abrm = new abjc(this);
  private abrs jdField_a_of_type_Abrs;
  private abzf jdField_a_of_type_Abzf;
  private RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask;
  private boolean aZP;
  protected ApolloBoxEnterView b;
  protected boolean bDn;
  public boolean bDo;
  int cpl;
  private int cpp = 0;
  public ApolloTextureView d;
  protected FrameGifView d;
  public aqrd e;
  auru e;
  protected FrameGifView e;
  private final WeakReference<QQSettingMe> fp;
  private final WeakReference<ViewGroup> fq;
  protected int[] mDressIds;
  public int mRoleId;
  protected float sl;
  
  public SettingMeApolloViewController(QQSettingMe paramQQSettingMe, ViewGroup paramViewGroup)
  {
    this.jdField_e_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Aqrd = new abjb(this);
    this.fp = new WeakReference(paramQQSettingMe);
    this.fq = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask = new RefreshApolloTask(paramQQSettingMe, this);
    this.b = ((ApolloBoxEnterView)paramViewGroup.findViewById(2131362771));
    this.b.setOnClickListener(this);
    this.b.setContentDescription(BaseApplicationImpl.getContext().getResources().getString(2131690392));
    this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)paramViewGroup.findViewById(2131362816));
    this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    this.AG = paramViewGroup.findViewById(2131362820);
    this.AG.setOnClickListener(this);
    this.jdField_a_of_type_Abkv = new abkv();
  }
  
  private void BI(String paramString)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.fp.get();
    if (localQQSettingMe == null) {}
    QQAppInterface localQQAppInterface;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localQQAppInterface = localQQSettingMe.getApp();
      } while (localQQAppInterface == null);
      localViewGroup = (ViewGroup)this.fq.get();
    } while (localViewGroup == null);
    if (this.b.getVisibility() == 0) {}
    abkx localabkx;
    Object localObject;
    for (int j = 1;; j = 0)
    {
      Intent localIntent = new Intent();
      String str2 = localQQAppInterface.getCurrentAccountUin();
      localIntent.putExtra("extra_key_box_uin", str2);
      localIntent.putExtra("extra_key_open_box", this.b.Zh());
      if (j != 0)
      {
        this.b.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.b.zQ());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      localabkx = this.jdField_a_of_type_Abkv.a();
      abhh localabhh = (abhh)localQQAppInterface.getManager(153);
      String str1 = localabhh.bga;
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onNotifyStatusChanged] lastTab=", str1 });
      }
      localObject = str1;
      if (localabkx != null)
      {
        localObject = str1;
        if ((localabkx instanceof abld))
        {
          abld localabld = (abld)localabkx;
          localObject = str1;
          if (localabld.bDz)
          {
            localObject = str1;
            if (localabld.c != null)
            {
              String str3 = localabld.c.scheme;
              localObject = str1;
              if (!TextUtils.isEmpty(str3))
              {
                str1 = str3.trim();
                localabld.ca(localQQAppInterface);
                localObject = str1;
                if (QLog.isColorLevel())
                {
                  QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onNotifyStatusChanged] scheme from bubble=", str1 });
                  localObject = str1;
                }
              }
            }
          }
        }
      }
      localObject = localabhh.s(1, (String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(abxi.bjv))) {
        localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + str2);
      }
      ApolloUtil.a(localViewGroup.getContext(), localIntent, "drawer", (String)localObject, null);
      localObject = (abhh)localQQAppInterface.getManager(153);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pet"))) {
        break label518;
      }
      VipUtils.a(null, "cmshow", "Apollo", "drawerpetclick", 0, 0, new String[] { ((abhh)localObject).is(localQQAppInterface.getCurrentUin()) });
      if (j != 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
        this.b.setVisibility(8);
      }
      localQQSettingMe.bUp();
      if (!(localabkx instanceof ablc)) {
        break;
      }
      ((ablc)localabkx).bZ(localQQAppInterface);
      return;
    }
    label518:
    int k = this.cpl;
    int m = abkw.fW(this.cpp);
    label541:
    int i;
    if (j != 0)
    {
      paramString = "0";
      if ((localabkx == null) || (!localabkx.bDz)) {
        break label599;
      }
      i = 2;
    }
    for (;;)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", k, m, new String[] { paramString, String.valueOf(i) });
      break;
      paramString = "1";
      break label541;
      label599:
      if (((abhh)localObject).bCD) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  @TargetApi(14)
  private void a(abhh.f paramf)
  {
    if (paramf == null) {}
    label691:
    label1117:
    for (;;)
    {
      return;
      QQSettingMe localQQSettingMe = (QQSettingMe)this.fp.get();
      if (localQQSettingMe != null)
      {
        QQAppInterface localQQAppInterface = localQQSettingMe.getApp();
        if (localQQAppInterface != null)
        {
          ViewGroup localViewGroup = (ViewGroup)this.fq.get();
          if (localViewGroup != null)
          {
            long l1 = System.currentTimeMillis();
            Object localObject = (abhh)localQQAppInterface.getManager(153);
            int j = this.cpl;
            int k = abkw.fW(this.cpp);
            if (((abhh)localObject).bCD) {}
            for (int i = 0;; i = 1)
            {
              VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_show", j, k, new String[] { "", String.valueOf(i) });
              if (QLog.isColorLevel()) {
                QLog.d("SettingMeApolloViewController", 2, new Object[] { "roleId->" + paramf.roleId + " apolloStatus->" + this.cpl + " needStatic->" + paramf.bDa, ",mApolloDrawerStatus->", Integer.valueOf(this.cpp) });
              }
              if (!this.aZP) {
                break;
              }
              QLog.i("SettingMeApolloViewController", 1, "checkApolloUI on DrawerClosed!");
              abwh.a(paramf.coR, 11, 106, new Object[] { "DrawerClosed" });
              return;
            }
            this.AG.setVisibility(8);
            this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
            this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.stop();
            this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
            float f2;
            float f1;
            if ((this.cpp == 1) || (this.cpp == 6)) {
              if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView == null)
              {
                abwh.a(paramf.coR, 11, 0, new Object[] { "checkUI done" });
                abwh.gN(paramf.coR, 100);
                long l2 = aqgz.hK();
                i = (int)((float)aqgz.hL() * 0.4F);
                j = abkw.c(i, l2);
                localObject = BaseApplicationImpl.getContext().getResources();
                l2 = Math.max(aqgz.hJ(), aqgz.hI());
                this.sl = ((j - wja.dp2px(66.0F, (Resources)localObject)) / aqgz.getDesity());
                f2 = acej.aV() / 16.0F;
                if (f2 != 0.0F)
                {
                  if (f2 > 1.0F)
                  {
                    f1 = 1.05F;
                    this.sl = (f1 * this.sl);
                  }
                }
                else
                {
                  f1 = (float)(l2 >> 2) / 368.0F;
                  if (l2 != aqgz.hL()) {
                    QLog.e("SettingMeApolloViewController", 1, "DeviceInfoUtil.getPortraitHeight():" + aqgz.hL() + " height:" + l2);
                  }
                  this.jdField_a_of_type_Abrs = new abrs(localQQAppInterface);
                  this.jdField_a_of_type_Abrs.g(f1, this.sl, 15);
                  this.jdField_a_of_type_Abzf = new abzf(this.jdField_a_of_type_Abrs, 1);
                  this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localViewGroup.getContext(), null);
                  this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Abzf);
                  this.jdField_a_of_type_Abrs.b(this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView);
                  ThreadManager.post(new SettingMeApolloViewController.4(this), 10, null, true);
                  this.mRoleId = paramf.roleId;
                  this.mDressIds = paramf.dressIds;
                  this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDrawerView = true;
                  this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.mManHeight = ((float)(l2 >> 2));
                  localQQAppInterface.addObserver(this.jdField_a_of_type_Abzf);
                  this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
                  this.jdField_a_of_type_Abrs.a(this.jdField_a_of_type_Abrm);
                  if (localQQSettingMe.a() == null) {
                    break label992;
                  }
                  f1 = localQQSettingMe.a().yC();
                  f1 = localQQSettingMe.a().yD();
                  paramf = new RelativeLayout.LayoutParams(j, i);
                  paramf.addRule(12, -1);
                  paramf.addRule(11, -1);
                  localViewGroup.addView(this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView, paramf);
                  if ((localViewGroup instanceof SettingMeRelativeLayout)) {
                    ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView, this.b, 0.0F, 0.0F);
                  }
                  this.b.bringToFront();
                  this.b.setVisibility(8);
                  this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                  float f3 = acej.aV() / 16.0F;
                  f2 = f3;
                  if (f3 == 0.0F) {
                    f2 = 1.0F;
                  }
                  f2 = aqgz.getDesity() / f2;
                  paramf = new RelativeLayout.LayoutParams((int)(45.0F * f2), (int)(45.0F * f2));
                  paramf.addRule(11, -1);
                  paramf.addRule(12, -1);
                  paramf.rightMargin = ((int)(f1 + 66.0F * f2 + wja.dp2px(8.0F, (Resources)localObject)));
                  paramf.bottomMargin = ((int)(f2 * 5.0F));
                  this.b.setLayoutParams(paramf);
                  if (this.cpp != 1) {
                    break label1024;
                  }
                  this.b.c(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
                  if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 0) {
                    this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
                  }
                  if ((localViewGroup instanceof SettingMeRelativeLayout)) {
                    ((SettingMeRelativeLayout)localViewGroup).bVt();
                  }
                }
              }
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label1117;
              }
              QLog.d("SettingMeApolloViewController", 2, "refresh ApolloSettingMe->" + (System.currentTimeMillis() - l1));
              return;
              f1 = f2;
              if (f2 >= 1.0F) {
                break;
              }
              f1 = 0.95F;
              break;
              label992:
              f1 = (float)(((Resources)localObject).getDisplayMetrics().density * 100.0F + 0.5D);
              f1 = ((Resources)localObject).getDimensionPixelSize(2131298881);
              break label691;
              this.b.setVisibility(8);
              break label905;
              abwh.a(paramf.coR, 11, 107, new Object[] { "already init" });
              if (this.cpp != 1) {
                break label905;
              }
              this.b.c(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
              break label905;
              abwh.a(paramf.coR, 11, 108, new Object[] { "mApolloDrawerStatus:", Integer.valueOf(this.cpp) });
            }
          }
        }
      }
    }
  }
  
  private void cCp()
  {
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while ((localObject == null) || (!BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean(((QQAppInterface)localObject).getAccount() + "apollo_settingme_first_enter", true)) || (abkw.hO(this.cpp)));
    localObject = new abla((QQAppInterface)localObject);
    this.jdField_a_of_type_Abkv.a((abkx)localObject);
  }
  
  private boolean hM(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "initApolloDrawerStatusView:", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    }
    do
    {
      return true;
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      this.b.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.AG.setVisibility(8);
    } while (paramInt == 0);
    return false;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    try
    {
      localObject1 = (QQSettingMe)this.fp.get();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((QQSettingMe)localObject1).getApp();
      if (localObject1 == null) {
        return false;
      }
      localObject2 = new JSONObject(paramString2);
      paramString2 = ((JSONObject)localObject2).optString("_show_mission");
      localObject2 = ((JSONObject)localObject2).optJSONObject("msg");
      if (localObject2 != null)
      {
        localJSONObject = ((JSONObject)localObject2).optJSONObject(paramString2);
        if (localJSONObject == null) {
          break label529;
        }
        int i = localJSONObject.optInt("time");
        int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramString1, 0);
        QLog.d("SettingMeApolloViewController", 1, new Object[] { "parseApolloRedTouchJson timestamp=", Integer.valueOf(i), ", spTimeStamp=", Integer.valueOf(j) });
        if (i == j) {
          return false;
        }
        localObject2 = localJSONObject.optString("content");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localJSONObject = new JSONObject((String)localObject2);
          localObject2 = new DrawerPushItem();
          ((DrawerPushItem)localObject2).msg_type = paramInt;
          ((DrawerPushItem)localObject2).is_reddot = 1;
          ((DrawerPushItem)localObject2).msg_id = paramString2;
          if (!localJSONObject.has("mainPriority")) {
            return false;
          }
          ((DrawerPushItem)localObject2).act_id = localJSONObject.optString("id");
          ((DrawerPushItem)localObject2).priority = localJSONObject.optInt("mainPriority");
          ((DrawerPushItem)localObject2).sub_priority = localJSONObject.optInt("subPriority");
          ((DrawerPushItem)localObject2).start_ts = localJSONObject.optInt("showTime");
          ((DrawerPushItem)localObject2).end_ts = localJSONObject.optInt("expireTime");
          ((DrawerPushItem)localObject2).send_time = i;
          ((DrawerPushItem)localObject2).action_id = localJSONObject.optInt("actionId");
          ((DrawerPushItem)localObject2).reddotGameId = localJSONObject.optInt("gameId");
          ((DrawerPushItem)localObject2).color = localJSONObject.optInt("fontColor");
          ((DrawerPushItem)localObject2).content = localJSONObject.optString("bubbleText");
          ((DrawerPushItem)localObject2).bubble_res_id = localJSONObject.optInt("bubbleID");
          ((DrawerPushItem)localObject2).target_model = localJSONObject.optInt("targetModel");
          paramInt = localJSONObject.optInt("type");
          ((DrawerPushItem)localObject2).scheme = localJSONObject.optString("scheme");
          if (paramInt == 0) {}
          for (;;)
          {
            ((DrawerPushItem)localObject2).show_counts = localJSONObject.optInt("showCounts");
            ((DrawerPushItem)localObject2).reddotPath = paramString1;
            paramString1 = (abhh)((QQAppInterface)localObject1).getManager(153);
            if (!paramBoolean) {
              break label521;
            }
            paramString1.c((DrawerPushItem)localObject2);
            break label581;
            if (paramInt != 1) {
              break;
            }
            ((DrawerPushItem)localObject2).ext_url = abxi.bjg;
          }
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "parseRedInfo error :" + paramString1.toString());
      }
    }
    while (paramInt == 2)
    {
      ((DrawerPushItem)localObject2).ext_url = localJSONObject.optString("url");
      break;
      label521:
      paramString1.BE(paramString2);
      break label581;
      label529:
      if ((!paramBoolean) && ((this.jdField_a_of_type_Abkv.a() instanceof abld)) && (((JSONObject)localObject2).has(String.valueOf(abld.bubbleId)))) {
        ((abhh)((QQAppInterface)localObject1).getManager(153)).BE(abld.bubbleId);
      }
    }
    label581:
    return true;
  }
  
  public void bHo()
  {
    QLog.i("SettingMeApolloViewController", 1, "destroyApollo");
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      ViewGroup localViewGroup;
      do
      {
        do
        {
          return;
          localObject = ((QQSettingMe)localObject).getApp();
        } while (localObject == null);
        localViewGroup = (ViewGroup)this.fq.get();
      } while (localViewGroup == null);
      if ((localViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(null, null, 1.0F, 0.0F);
      }
      if (this.jdField_a_of_type_Abrs != null)
      {
        this.jdField_a_of_type_Abrs.onDestroy();
        this.jdField_a_of_type_Abrs = null;
      }
      if ((localObject != null) && (this.jdField_a_of_type_Abzf != null))
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Abzf);
        this.jdField_a_of_type_Abzf = null;
      }
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        localViewGroup.removeView(this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView = null;
      }
      this.bDo = true;
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, "destroyApollo end");
  }
  
  public void bTD()
  {
    if ((this.cpp != 1) && (this.cpp != 6)) {
      return;
    }
    bHo();
    cCq();
  }
  
  public void cCl()
  {
    ThreadManager.post(new SettingMeApolloViewController.1(this), 5, null, true);
  }
  
  public void cCm()
  {
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while ((localObject == null) || (this.jdField_a_of_type_Abkv == null));
    localObject = new abky((QQAppInterface)localObject);
    this.jdField_a_of_type_Abkv.a((abkx)localObject);
  }
  
  public void cCn()
  {
    Object localObject1 = (QQSettingMe)this.fp.get();
    if (localObject1 == null) {}
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((QQSettingMe)localObject1).getApp();
        } while ((localObject1 == null) || (localObject1 == null) || (Build.VERSION.SDK_INT < 14));
        localObject2 = (altq)((QQAppInterface)localObject1).getManager(36);
      } while (!ApolloGameUtil.Z((QQAppInterface)localObject1));
      localObject1 = new ArrayList();
      i = 0;
      while (i < abxi.dF.length)
      {
        localObject3 = ((altq)localObject2).getAppInfoByPath(abxi.dF[i]);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get()))) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    int i = 0;
    label135:
    if (i < ((List)localObject1).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "buffer = " + ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get());
      }
      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).path.get();
      localObject3 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get();
      if (((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).iNewFlag.get() != 1) {
        break label268;
      }
    }
    label268:
    for (boolean bool = true;; bool = false)
    {
      a(0, (String)localObject2, (String)localObject3, bool);
      i += 1;
      break label135;
      break;
    }
  }
  
  public void cCo()
  {
    Object localObject1 = (QQSettingMe)this.fp.get();
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        localObject1 = ((QQSettingMe)localObject1).getApp();
      } while (localObject1 == null);
      localObject2 = (abhh)((QQAppInterface)localObject1).getManager(153);
    } while (!ApolloGameUtil.Z((QQAppInterface)localObject1));
    Object localObject2 = ((abhh)localObject2).a(0, abkw.fX(this.cpp));
    if (localObject2 != null)
    {
      localObject2 = new abld((QQAppInterface)localObject1, (DrawerPushItem)localObject2);
      this.jdField_a_of_type_Abkv.a((abkx)localObject2);
    }
    for (;;)
    {
      long l = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject1).getCurrentUin(), 0).getLong("hire_end", 0L);
      if ((NetConnInfoCenter.getServerTime() < l) && (!abkw.hO(this.cpp)))
      {
        localObject1 = new ablc((QQAppInterface)localObject1);
        this.jdField_a_of_type_Abkv.a((abkx)localObject1);
      }
      cCp();
      return;
      ((aqrb)((QQAppInterface)localObject1).getBusinessHandler(71)).XO(1);
    }
  }
  
  @TargetApi(14)
  public void cCq()
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.fp.get();
    if (localQQSettingMe == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        QLog.d("SettingMeApolloViewController", 1, new Object[] { "refreshApolloView isResume:", Boolean.valueOf(localQQSettingMe.isResume()) });
        this.jdField_e_of_type_Auru.removeMessages(65537);
      } while ((localQQSettingMe.isResume()) && (!this.bDo));
      this.bDo = false;
      bool = hM(this.cpp);
      if (bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, new Object[] { "refreshApolloView not show apollo,needShowApollo:", Boolean.valueOf(bool) });
    return;
    abyy.Df("drawer_pre");
    if (this.jdField_a_of_type_Abrs != null) {
      this.jdField_a_of_type_Abrs.doOnResume();
    }
    ThreadManagerV2.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16);
    ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16, null, true);
  }
  
  public void cCr()
  {
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while (localObject == null);
    this.cpp = 0;
    this.cpp = ((abhh)((QQAppInterface)localObject).getManager(153)).zy();
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "initApolloDrawerStatus:", Integer.valueOf(this.cpp) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 65536: 
      do
      {
        do
        {
          return false;
        } while ((QQSettingMe)this.fp.get() == null);
        if (this.aZP)
        {
          QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_REFRESH_APOLLO on DrawerClosed!");
          abwh.a(abrj.gf(1), 11, 106, new Object[] { "DrawerClosed" });
          return false;
        }
      } while (!(paramMessage.obj instanceof abhh.f));
      a((abhh.f)paramMessage.obj);
      return false;
    }
    QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND");
    bHo();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    QQSettingMe localQQSettingMe;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localQQSettingMe = (QQSettingMe)this.fp.get();
      } while (localQQSettingMe == null);
      localQQAppInterface = localQQSettingMe.getApp();
    } while (localQQAppInterface == null);
    Intent localIntent = new Intent();
    if (paramView.getId() == 2131362771)
    {
      localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_box_uin", localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_open_box", this.b.Zh());
      if (this.b.getVisibility() == 0)
      {
        this.b.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.b.zQ());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      ApolloUtil.a(paramView.getContext(), localIntent, "drawer", abxi.bjv, null);
      label231:
      if (this.b.getVisibility() != 0) {
        break label315;
      }
      this.b.setVisibility(8);
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.cpl, abkw.fW(this.cpp), new String[] { "1", "" });
    }
    for (;;)
    {
      localQQSettingMe.bUp();
      break;
      ApolloUtil.a(paramView.getContext(), localIntent, "drawer", abxi.bju, null);
      break label231;
      label315:
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.cpl, abkw.fW(this.cpp), new String[] { "0", "" });
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onDestroy();
    }
    if (this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.stop();
      this.jdField_d_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
    }
    bHo();
    QLog.i("SettingMeApolloViewController", 1, "onDestroy");
  }
  
  public void onDrawerClosed()
  {
    this.aZP = true;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16);
    this.bDn = false;
    if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().u(1, null, "Bubble");
    }
    if (this.jdField_a_of_type_Abkv != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "set apollodrawer status 9999");
      }
      this.jdField_a_of_type_Abkv.cCF();
    }
    QLog.i("SettingMeApolloViewController", 1, "onDrawerClosed sDisableDestroySettingmeSwitch:" + abxh.bGe);
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while ((localObject == null) || (abhh.h((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()) != 2) || (abxh.bGe));
    this.jdField_e_of_type_Auru.removeMessages(65537);
    if (abxh.cts > 0) {
      NB = abxh.cts * 1000;
    }
    this.jdField_e_of_type_Auru.sendEmptyMessageDelayed(65537, NB);
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "send delay msg MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND sDestroyTimeOut:", Long.valueOf(NB) });
  }
  
  public void onDrawerOpened()
  {
    this.aZP = false;
    this.jdField_e_of_type_Auru.removeCallbacksAndMessages(Integer.valueOf(65537));
  }
  
  public void onPause()
  {
    this.bDn = false;
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.jdField_a_of_type_Abrs != null) {
      this.jdField_a_of_type_Abrs.doOnPause();
    }
    if (this.b != null) {
      this.b.setVisibility(8);
    }
    if (this.jdField_e_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
    {
      this.jdField_e_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_e_of_type_ComTencentMobileqqApolloViewFrameGifView.stop();
    }
    Object localObject = (QQSettingMe)this.fp.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while (localObject == null);
    if (this.jdField_a_of_type_Abkv != null) {
      this.jdField_a_of_type_Abkv.a((QQAppInterface)localObject, this.jdField_a_of_type_Abrs);
    }
    QLog.i("SettingMeApolloViewController", 1, "onPause");
  }
  
  public void wc(String paramString)
  {
    ThreadManager.getUIHandler().post(new SettingMeApolloViewController.3(this, paramString));
  }
  
  static class RefreshApolloTask
    implements Runnable
  {
    private WeakReference<QQSettingMe> fp;
    private WeakReference<SettingMeApolloViewController> fr;
    
    public RefreshApolloTask(QQSettingMe paramQQSettingMe, SettingMeApolloViewController paramSettingMeApolloViewController)
    {
      this.fp = new WeakReference(paramQQSettingMe);
      this.fr = new WeakReference(paramSettingMeApolloViewController);
    }
    
    public void run()
    {
      if ((this.fp == null) || (this.fp.get() == null)) {}
      Object localObject1;
      int i;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = (QQSettingMe)this.fp.get();
            } while (localObject1 == null);
            localObject2 = ((QQSettingMe)localObject1).getApp();
          } while (localObject2 == null);
          localObject1 = (SettingMeApolloViewController)this.fr.get();
        } while (localObject1 == null);
        abyy.Dg("drawer_pre");
        i = abrj.gf(1);
        abwh.Il(i);
        abwh.gN(i, 1);
        abwh.gN(i, 10);
        localObject3 = (abhh)((QQAppInterface)localObject2).getManager(153);
        ((abhh)localObject3).cBG();
        localObject3 = ((abhh)localObject3).b(((QQAppInterface)localObject2).getCurrentAccountUin());
        if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)) {
          ((aqrb)((QQAppInterface)localObject2).getBusinessHandler(71)).Vw("qqSettingMe");
        }
        localObject3 = abkw.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).getCurrentUin(), (ApolloBaseInfo)localObject3, 1);
        if ((localObject3 == null) || (((abhh.f)localObject3).bDa))
        {
          QLog.w("SettingMeApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
          return;
        }
        if (abvg.f((QQAppInterface)localObject2, 11)) {
          break;
        }
        abwh.a(((abhh.f)localObject3).coR, 10, 110, new Object[] { "role 0 not ready" });
      } while (!QLog.isColorLevel());
      QLog.w("SettingMeApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
      return;
      abwh.a(((abhh.f)localObject3).coR, 10, 0, new Object[] { "switch done" });
      abwh.gN(i, 11);
      Object localObject2 = ((SettingMeApolloViewController)localObject1).e.obtainMessage(65536);
      ((Message)localObject2).obj = localObject3;
      ((SettingMeApolloViewController)localObject1).cpl = ((abhh.f)localObject3).coP;
      ((SettingMeApolloViewController)localObject1).e.sendMessageAtFrontOfQueue((Message)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController
 * JD-Core Version:    0.7.0.1
 */