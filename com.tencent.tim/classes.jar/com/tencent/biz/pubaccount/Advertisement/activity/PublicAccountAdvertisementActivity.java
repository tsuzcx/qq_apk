package com.tencent.biz.pubaccount.Advertisement.activity;

import aibd;
import aibh;
import alwy;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import anku;
import anot;
import aqiw;
import arvh;
import arvh.a;
import arvk;
import arvl;
import ausj;
import ausj.a;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout;
import com.tencent.biz.pubaccount.Advertisement.view.DragFrameLayout.a;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.a;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.b;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import jwo;
import jwp;
import jwq;
import jwr;
import jws;
import jwt;
import jwu;
import jwv;
import jww;
import jwx;
import jwy;
import jwz;
import jxa;
import jxb;
import jxc;
import jxd;
import jxe;
import jxm;
import jxp;
import kbp;
import mqq.os.MqqHandler;

public class PublicAccountAdvertisementActivity
  extends QQBrowserActivity
  implements arvh.a
{
  public static boolean acx;
  public static HashMap<String, Integer> cV = new HashMap();
  public static long qS;
  private String Uv = "";
  private aibh jdField_a_of_type_Aibh;
  private VideoCoverFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment;
  private WebpageFragment jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentWebpageFragment;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private DragFrameLayout.a jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$a;
  private DragFrameLayout jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout;
  private VerticalPagerView.a jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a;
  private VerticalPagerView.b jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b;
  private VerticalPagerView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView;
  private jxc jdField_a_of_type_Jxc;
  private int aDO;
  private int aDP;
  private boolean acA;
  private boolean acp;
  private boolean acq = true;
  private boolean acr;
  private boolean acs;
  private boolean act = true;
  private boolean acu;
  private boolean acv = true;
  private boolean acw;
  private boolean acy;
  private boolean acz = true;
  private AudioManager audioManager;
  private ViewPager.OnPageChangeListener c;
  private View.OnClickListener cf;
  private ausj.a e;
  private ausj.a f;
  private View iX;
  private ausj mActionSheet;
  private String mAppId;
  private String mAppName;
  private String mDownloadUrl;
  private String mPackageName;
  private int mScreenHeight;
  private int mScreenWidth;
  public Handler mUIHandler = new jwr(this, Looper.getMainLooper());
  private long qO;
  private long qP;
  private long qQ;
  private long qR;
  private long qT;
  public long qU;
  private View.OnClickListener x;
  
  public static void a(Context paramContext, jxc paramjxc)
  {
    if (paramjxc == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("arg_ad_json", paramjxc.hV());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  private void a(jxe paramjxe)
  {
    if (paramjxe == null) {
      return;
    }
    if ((paramjxe.acD) && (paramjxe.jumpType == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.acu = bool;
      this.mAppId = paramjxe.appId;
      this.mPackageName = paramjxe.packagename;
      this.mDownloadUrl = paramjxe.downloadUrl;
      this.mAppName = paramjxe.appName;
      this.Uv = paramjxe.hT;
      this.acw = paramjxe.acE;
      if ((TextUtils.isEmpty(this.mAppId)) || (TextUtils.isEmpty(this.mPackageName)) || (TextUtils.isEmpty(this.mDownloadUrl))) {
        this.acu = false;
      }
      if (!this.acu) {
        break;
      }
      arvh.a().c(this);
      paramjxe = new arvl(this.mAppId, this.mPackageName, this.mAppName, this.mDownloadUrl, true);
      paramjxe.ddf = false;
      if ((yz()) || (yA()) || (!this.acu) || (!this.acw) || (!aqiw.isWifiEnabled(this))) {
        break;
      }
      int i = arvh.a().a(this, paramjxe);
      this.acv = true;
      if ((QLog.isColorLevel()) && (200 == i)) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "app download silent start success");
      }
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "1", "", this.jdField_a_of_type_Jxc.a.mNickName);
      return;
    }
  }
  
  private void aAC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download start get download progress");
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new arvl(this.mAppId, this.mPackageName));
    arvh.a().B(localLinkedList);
  }
  
  private void aAD()
  {
    if (yz())
    {
      aAG();
      return;
    }
    if (yA())
    {
      aAF();
      return;
    }
    if (NetworkState.isNetSupport())
    {
      if (NetworkState.isWifiConn())
      {
        startDownload();
        return;
      }
      aAE();
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = 202;
    this.mUIHandler.sendMessage(localMessage);
  }
  
  private void aAF()
  {
    if (!this.acu) {
      return;
    }
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F72", "0X8008F72", 0, 0, this.Uv, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_Jxc.a.mNickName);
    arvh.a().ah(this.mAppId, this.mPackageName);
  }
  
  private void aAG()
  {
    if (!this.acu) {
      return;
    }
    if (yz())
    {
      localObject = getPackageManager().getLaunchIntentForPackage(this.mPackageName);
      if (localObject != null) {
        startActivity((Intent)localObject);
      }
      kbp.a(null, "", "0X8007F7B", "0X8007F7B", 0, 0, this.Uv, "", "", "", false);
      return;
    }
    Object localObject = new Message();
    ((Message)localObject).what = 3;
    this.mUIHandler.sendMessage((Message)localObject);
  }
  
  private void aAH()
  {
    if (this.jdField_a_of_type_Jxc.jw.size() == 1)
    {
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_Jxc.a.hT, String.valueOf(this.qU / 1000L), ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC, this.jdField_a_of_type_Jxc.a.mNickName);
      return;
    }
    Iterator localIterator = cV.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F79", "0X8008F79", 0, 0, this.jdField_a_of_type_Jxc.a.hT, ((Integer)localEntry.getValue()).intValue() + "", (String)localEntry.getKey(), this.jdField_a_of_type_Jxc.a.mNickName);
    }
    cV.clear();
  }
  
  private void aAI()
  {
    QQAppInterface localQQAppInterface = this.app;
    String str1 = this.jdField_a_of_type_Jxc.a.UD;
    String str2 = this.jdField_a_of_type_Jxc.a.hT;
    if (VideoCoverFragment.acH) {}
    for (int i = 1;; i = 2)
    {
      anot.c(localQQAppInterface, "dc00898", "", str1, "0X8008F61", "0X8008F61", 0, 0, str2, String.valueOf(i), ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC, this.jdField_a_of_type_Jxc.a.mNickName);
      anot.c(this.app, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F66", "0X8008F66", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC, jxp.gP() + "(" + this.jdField_a_of_type_Jxc.a.mNickName + ")");
      return;
    }
  }
  
  private void aAJ()
  {
    if (this.jdField_a_of_type_Jxc.jw.size() == 1)
    {
      this.qT = System.currentTimeMillis();
      this.qU += this.qT - qS;
    }
    int i;
    String str;
    do
    {
      return;
      i = (int)(((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).b.bY() / 1000L);
      str = ((jxd)this.jdField_a_of_type_Jxc.jw.get(this.aDO)).UC;
    } while (i <= 0);
    Integer localInteger = (Integer)cV.get(str);
    if (localInteger == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "current time =" + i);
      }
      cV.put(str, Integer.valueOf(i));
      return;
    }
    cV.put(str, Integer.valueOf(localInteger.intValue() + i));
  }
  
  private void aAK()
  {
    int i = this.audioManager.getRingerMode();
    if (acx) {}
    while ((i != 0) && (i != 1)) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountAdvertisementActivity.13(this), 300L);
  }
  
  private void aAL()
  {
    if (this.jdField_a_of_type_Aibh == null) {
      this.jdField_a_of_type_Aibh = new aibh(this, this.jdField_a_of_type_Jxc);
    }
    this.jdField_a_of_type_Aibh.aAL();
  }
  
  private void aAy()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = ((AdControlView)super.findViewById(2131362073));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout = ((DragFrameLayout)super.findViewById(2131366128));
    FrameLayout localFrameLayout = (FrameLayout)super.findViewById(2131366140);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setDraggableView(localFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setOnDraggingListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$a);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.minWidth = (this.mScreenWidth / 4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.bringToFront();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ae().setOnClickListener(this.x);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ac().setOnClickListener(this.x);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ad().setOnClickListener(this.x);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.setFitsSystemWindows(true);
    }
  }
  
  private void aAz()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$a = new jwo(this);
    this.c = new jwv(this);
    this.x = new jww(this);
    if (yy())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b = new jwx(this);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a = new jwy(this);
    }
  }
  
  private void showActionSheet(int paramInt)
  {
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X80090FB", "0X80090FB", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "", "", this.jdField_a_of_type_Jxc.a.mNickName);
    this.mActionSheet = ausj.e(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.cf == null) {
        this.cf = new jwu(this);
      }
      this.mActionSheet.setOnBottomCancelListener(this.cf);
      this.mActionSheet.show();
      return;
      this.mActionSheet.addButton(2131694736);
      this.mActionSheet.addCancelButton(2131721058);
      if (this.e == null) {
        this.e = new jws(this);
      }
      this.mActionSheet.a(this.e);
      continue;
      this.mActionSheet.addButton(2131693966);
      this.mActionSheet.addButton(2131694736);
      this.mActionSheet.addCancelButton(2131721058);
      if (this.f == null) {
        this.f = new jwt(this);
      }
      this.mActionSheet.a(this.f);
    }
  }
  
  private void startDownload()
  {
    if (!this.acu) {}
    int i;
    do
    {
      return;
      localObject = new arvl(this.mAppId, this.mPackageName, this.mAppName, this.mDownloadUrl, false);
      this.acv = false;
      ((arvl)localObject).ddf = false;
      ((arvl)localObject).ddg = false;
      i = arvh.a().a(this, (arvl)localObject);
      switch (i)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.i("PublicAccountAdvertisementActivity", 2, "app download start failed " + i);
    return;
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F6E", "0X8008F6E", 0, 0, this.Uv, "", "", this.jdField_a_of_type_Jxc.a.mNickName);
    Object localObject = new Message();
    ((Message)localObject).what = 4;
    ((Message)localObject).arg1 = 1;
    this.mUIHandler.sendMessage((Message)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download start succeeded");
    }
    anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F6D", "0X8008F6D", 0, 0, this.jdField_a_of_type_Jxc.a.hT, "2", "", this.jdField_a_of_type_Jxc.a.mNickName);
  }
  
  public void a(arvk paramarvk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download state change " + paramarvk.packageName + " " + paramarvk.state);
    }
    if ((this.acu) && (paramarvk.appId.equals(this.mAppId)) && (paramarvk.packageName.equals(this.mPackageName))) {
      switch (paramarvk.state)
      {
      }
    }
    do
    {
      return;
      anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F70", "0X8008F70", 0, 0, this.Uv, String.valueOf(System.currentTimeMillis() / 1000L), "", this.jdField_a_of_type_Jxc.a.mNickName);
    } while (this.acv);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = paramarvk.progress;
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public void aAA()
  {
    Object localObject = this.jdField_a_of_type_Jxc.a;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpType = " + ((jxe)localObject).jumpType);
      }
      if (((jxe)localObject).jumpType == 1) {
        if ((((jxe)localObject).UI != null) && (!TextUtils.isEmpty(((jxe)localObject).UI))) {
          lp(((jxe)localObject).UI);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          return;
          aAD();
          return;
          if (((jxe)localObject).jumpType != 2) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpUrl = " + ((jxe)localObject).jumpType);
          }
        } while ((((jxe)localObject).jumpUrl == null) || (TextUtils.isEmpty(((jxe)localObject).jumpUrl)));
        lp(((jxe)localObject).jumpUrl);
        anot.c(null, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F74", "0X8008F74", 0, 0, this.Uv, "", "", this.jdField_a_of_type_Jxc.a.mNickName);
        return;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject instanceof ToolAppRuntime));
      aibd.a().a(this.jdField_a_of_type_Jxc, this, (AppInterface)((ToolAppRuntime)localObject).onGetSubRuntime("imax"));
      return;
    }
    QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem is null");
  }
  
  public void aAB()
  {
    f(this);
  }
  
  void aAE()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(2131689689);
    localTextView1.setGravity(3);
    localTextView2.setText(2131689690);
    localTextView3.setText(2131689691);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new jxa(this, localReportDialog));
    localTextView3.setOnClickListener(new jxb(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(arvk paramarvk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "app download error " + paramarvk.packageName + " " + paramarvk.errCode);
    }
    if ((this.acu) && (paramarvk.appId.equals(this.mAppId)) && (paramarvk.packageName.equals(this.mPackageName)) && (!this.acv))
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.arg1 = paramarvk.errCode;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void c(arvk paramarvk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download progress " + paramarvk.packageName + " " + paramarvk.progress);
    }
    if ((this.acu) && (paramarvk.appId.equals(this.mAppId)) && (paramarvk.packageName.equals(this.mPackageName)) && (!this.acv))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = paramarvk.progress;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void d(arvk paramarvk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountAdvertisementActivity", 2, "app download get progress" + paramarvk.packageName + " " + paramarvk.progress);
    }
    if ((this.acu) && (paramarvk.appId.equals(this.mAppId)) && (paramarvk.packageName.equals(this.mPackageName)) && ((!this.acv) || (paramarvk.progress == 0)))
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = paramarvk.progress;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void doOnBackPressed()
  {
    finish();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mScreenWidth = localDisplayMetrics.widthPixels;
    this.mScreenHeight = localDisplayMetrics.heightPixels;
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.w(paramBundle);
    setContentView(2131559799);
    overridePendingTransition(2130772188, 0);
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    aAz();
    aAy();
    this.audioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment = new VideoCoverFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.a(this.jdField_a_of_type_Jxc, this.c, this.x, this.audioManager, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView, this.acz);
    paramBundle = super.getSupportFragmentManager().beginTransaction();
    if (yy())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView = ((VerticalPagerView)findViewById(2131381533));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnPagerChangedListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setOnInterceptTouchListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.setVisibility(0);
      this.iX = findViewById(2131371159);
      paramBundle.add(2131381576, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
    for (;;)
    {
      paramBundle.commit();
      paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
      if ((Build.VERSION.SDK_INT > 10) && (!ap.contains(paramBundle))) {
        getWindow().addFlags(16777216);
      }
      getWindow().setFormat(-3);
      return true;
      paramBundle.add(2131366140, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    arvh.a().d(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout$a = null;
    this.c = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$b = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$a = null;
    this.x = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.onDestroy();
    }
    acx = false;
    anot.c(this.app, "dc00898", "", this.jdField_a_of_type_Jxc.a.UD, "0X8008F69", "0X8008F69", 0, 0, this.jdField_a_of_type_Jxc.a.hT, String.valueOf(this.qO / 1000L), "", this.jdField_a_of_type_Jxc.a.mNickName);
    aAH();
    qS = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.destory();
    if (this.jdField_a_of_type_Aibh != null)
    {
      this.jdField_a_of_type_Aibh.onDestory();
      this.jdField_a_of_type_Aibh = null;
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aBb();
      acx = true;
      if (!this.acy)
      {
        this.audioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.aEh, 0);
        this.acy = true;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842440);
      VideoCoverFragment.acH = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.aAR();
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.aBb();
      acx = true;
      if (!this.acy)
      {
        this.audioManager.setStreamVolume(3, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment.aEh, 0);
        this.acy = true;
      }
      if (this.audioManager.getStreamVolume(3) <= 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.ab().setBackgroundResource(2130842439);
        VideoCoverFragment.acH = true;
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView != null) {
          if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView.aEr == 1)
          {
            this.qR = System.currentTimeMillis();
            this.qO += this.qR - this.qQ;
          }
          else
          {
            aAK();
            aAJ();
            aAI();
          }
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.acu)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.arg1 = 0;
      this.mUIHandler.sendMessage(localMessage);
      aAC();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      jxm.a().aAW();
    }
  }
  
  public void finish()
  {
    acx = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewDragFrameLayout.a(this.mScreenWidth / 2, this.mScreenHeight / 2, 0, 0, 300, new jwz(this));
  }
  
  protected void lp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    startActivity(localIntent);
  }
  
  public void lv(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131689688);
    localTextView3.setText(2131689692);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new jwp(this, localReportDialog));
    localTextView3.setOnClickListener(new jwq(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    int i;
    try
    {
      this.jdField_a_of_type_Jxc = jxc.a(localIntent.getStringExtra("arg_ad_json"));
      if (this.jdField_a_of_type_Jxc != null)
      {
        a(this.jdField_a_of_type_Jxc.a);
        long l = localIntent.getLongExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
        bool1 = localIntent.getBooleanExtra("is_first_open_imax_ad", true);
        jxm.a().f(this.Uv, l, bool1);
      }
      if (this.jdField_a_of_type_Jxc == null)
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate object null");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
          this.jdField_a_of_type_Jxc = null;
        }
        if ((this.jdField_a_of_type_Jxc.jw != null) && (this.jdField_a_of_type_Jxc.jw.size() > 0)) {
          break;
        }
        finish();
      } while (!QLog.isColorLevel());
      QLog.d("PublicAccountAdvertisementActivity", 2, "onCreate no video");
      return;
      i = this.jdField_a_of_type_Jxc.a.jumpType;
      if (i <= 3) {
        break label214;
      }
    }
    boolean bool1 = alwy.auJ();
    boolean bool2 = anku.z(this.app);
    if (i == 5) {
      if ((bool1) && (bool2))
      {
        bool1 = true;
        this.acz = bool1;
        label214:
        if (!this.acz) {
          break label373;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_Jxc.a.jumpUrl)) {
          break label302;
        }
        this.acp = true;
        localIntent.putExtra("isFullScreen", true);
        localIntent.putExtra("isTransparentTitle", true);
        localIntent.putExtra("url", this.jdField_a_of_type_Jxc.a.jumpUrl);
      }
    }
    for (;;)
    {
      super.bv(paramBundle);
      return;
      bool1 = false;
      break;
      this.acz = bool1;
      break label214;
      label302:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Jxc.a.UI))
      {
        this.acp = true;
        localIntent.putExtra("isFullScreen", true);
        localIntent.putExtra("isTransparentTitle", true);
        localIntent.putExtra("url", this.jdField_a_of_type_Jxc.a.UI);
      }
      else
      {
        this.acp = false;
        continue;
        label373:
        this.acp = false;
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, null, false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    super.setContentView(localView);
    getWindow().setFeatureInt(7, 2131559169);
    try
    {
      ((View)findViewById(2131367153).getParent()).setVisibility(8);
      label65:
      super.setContentView(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label65;
    }
  }
  
  public void showToast(int paramInt)
  {
    QQToast.a(this, 1, paramInt, 0).show(getTitleBarHeight());
  }
  
  public boolean yA()
  {
    switch (arvh.a().a(new arvl(this.mAppId, this.mPackageName)))
    {
    default: 
      this.acu = false;
    case 0: 
      return false;
    }
    return true;
  }
  
  public boolean yy()
  {
    return (this.acp) && (this.jdField_a_of_type_Jxc.a.acF);
  }
  
  public boolean yz()
  {
    return arvh.a().isInstalled(this.mPackageName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity
 * JD-Core Version:    0.7.0.1
 */