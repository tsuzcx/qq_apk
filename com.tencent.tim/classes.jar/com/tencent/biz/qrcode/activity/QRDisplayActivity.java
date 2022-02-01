package com.tencent.biz.qrcode.activity;

import acdt;
import acdu;
import acdv;
import acff;
import acfp;
import aeng;
import aeng.a;
import aeni;
import afem;
import afet;
import afet.a;
import aldh;
import alkw;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anov;
import anpc;
import aqfr;
import aqge;
import aqgv;
import aqha;
import aqhu;
import aqiw;
import aqju;
import arhz;
import ashx;
import ausj;
import auss;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.a;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.chirp.PcmPlayer.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ivv;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import jll;
import lk;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import rts.a;
import rtu;
import rug;
import ruh;
import rui;
import ruj;
import ruk;
import rul;
import rum;
import run;
import ruo;
import rup;
import rur;
import rus;
import rut;
import ruu;
import ruv;
import ruw;
import rux;
import ruy;
import ruz;
import rva;
import rwt;
import wja;
import zcq;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements afet.a, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener, CodeMaskManager.a, PcmPlayer.a, rts.a
{
  public static final String aCw = acfp.m(2131712599);
  public View E;
  ausj L;
  public Bundle O;
  public String Qt;
  public boolean ZM = true;
  public acdt a;
  acdv jdField_a_of_type_Acdv = new ruw(this);
  protected aeng a;
  private afet jdField_a_of_type_Afet;
  ashx jdField_a_of_type_Ashx = new ruy(this);
  protected CodeMaskManager a;
  b jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$b = new rug(this);
  private c jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$c;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  public lk a;
  public String aCr;
  public String aCs;
  public String aCt;
  protected String aCu;
  protected String aCv;
  protected boolean aJL = true;
  protected boolean aJM;
  private boolean aJN;
  private volatile boolean aJO;
  private boolean aJP;
  public boolean ach;
  public int atU = -1;
  public int bvr;
  protected int bvs;
  protected int bvt;
  protected int bvu;
  int bvv;
  public int bvw;
  protected int bvx = -1;
  private Handler bw;
  private CountDownTimer c = new rur(this, 1000L, 200L);
  public Bitmap cT;
  protected Bitmap cU;
  protected Runnable dA = new QRDisplayActivity.7(this);
  protected long dk;
  protected long dwGroupFlagExt;
  public Runnable dy = new QRDisplayActivity.4(this);
  public Runnable dz = new QRDisplayActivity.5(this);
  public ausj e;
  protected ImageView gA;
  protected View gb;
  public boolean isLoading = true;
  protected boolean isQidianPrivateTroop;
  public boolean isTimeout;
  protected String mFrom;
  protected Handler mHandler;
  protected boolean mIsInit = true;
  protected TextView mNickName;
  protected Drawable mProgressDrawable;
  public View mScrollView;
  private ShareActionSheetBuilder mShareActionSheet;
  public long mValidTime;
  protected TextView my;
  public ImageView nC;
  protected ImageView nD;
  protected ImageView nE;
  protected ImageView nF;
  protected ImageView nG;
  protected ImageView nH;
  protected ImageView nI;
  protected ImageView nJ;
  protected ImageView nK;
  protected View pl;
  public View pm;
  public View pn;
  public List<String> pn;
  View po;
  protected View pp;
  protected View pq;
  protected View pr;
  protected View ps;
  public View pt;
  protected View pu;
  protected View pv;
  arhz jdField_q_of_type_Arhz;
  private URLDrawable jdField_q_of_type_ComTencentImageURLDrawable;
  public String tips;
  public int type;
  public String uin;
  List<String> uinList = new ArrayList();
  protected TextView zo;
  protected TextView zp;
  protected TextView zq;
  protected TextView zr;
  protected TextView zs;
  protected TextView zt;
  protected TextView zu;
  protected TextView zv;
  protected TextView zw;
  
  public QRDisplayActivity()
  {
    this.jdField_pn_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(aeng.a parama, int paramInt, boolean paramBoolean)
  {
    if ("default_bg".equals(parama.bzR))
    {
      b(parama, paramInt, paramBoolean);
      this.E.setBackgroundResource(2130847818);
      return;
    }
    int i;
    if (this.E.getBackground() == null) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i == 0) {
          break label237;
        }
        localDrawable = getResources().getDrawable(2130847818);
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        this.jdField_q_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(parama.bzR, localURLDrawableOptions);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "setURLDrawable: urlDrawable = " + this.jdField_q_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_q_of_type_ComTencentImageURLDrawable.getStatus());
        }
        if (this.jdField_q_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          break label249;
        }
        b(parama, paramInt, paramBoolean);
        this.E.setBackgroundDrawable(this.jdField_q_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        return;
      }
      catch (IllegalArgumentException parama)
      {
        QLog.d("QRDisplayActivity", 1, "bkgURL is illegal please check manage info e =" + parama);
        QQToast.a(this, getString(2131698697), 0).show();
        bwQ();
      }
      if (i == 0) {
        break;
      }
      this.E.setBackgroundResource(2130847818);
      return;
      i = 0;
      continue;
      label237:
      Drawable localDrawable = this.E.getBackground();
    }
    label249:
    if (i != 0) {
      this.E.setBackgroundResource(2130847818);
    }
    a(parama, paramInt, paramBoolean, this.jdField_q_of_type_ComTencentImageURLDrawable);
    bwP();
    this.jdField_q_of_type_ComTencentImageURLDrawable.startDownload();
    this.jdField_q_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
  }
  
  private void a(aeng.a parama, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + parama.bzR);
    }
    paramURLDrawable.setURLDrawableListener(new ruv(this, parama, paramInt, paramBoolean));
  }
  
  private void a(aeng.a parama, boolean paramBoolean)
  {
    if (parama == null) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
    }
    do
    {
      return;
      this.bvx = this.jdField_a_of_type_Aeng.yX.indexOf(parama);
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + parama.toString());
      }
    } while (TextUtils.isEmpty(parama.bzR));
    this.aCu = parama.bzS;
    this.aJL = parama.ahq();
    this.aCv = parama.bzR;
    a(parama, this.bvx, paramBoolean);
  }
  
  private void a(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    if (TextUtils.isEmpty(this.aCv)) {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130847818);
    }
    for (;;)
    {
      paramBundle = rwt.a(this, localBitmap1, this.cT, paramBitmap, paramArrayList, paramBundle.getInt("nameClr"), this.aCr, String.format(getString(2131701532), new Object[] { this.uin }), paramBundle.getInt("tipsClr"), this.tips, this.aJL, this.aCu, true);
      if (this.cU == null)
      {
        this.nH.setImageBitmap(paramBundle[0]);
        this.mNickName.setText(this.aCr);
        this.zr.setText(String.format(getString(2131701532), new Object[] { this.uin }));
        this.my.setText(getString(2131701542));
        this.gA.setImageBitmap(this.cT);
        bwQ();
      }
      this.cU = paramBundle[1];
      localBitmap1.recycle();
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "onMaskReady: qrcodeCardCache = " + this.cU);
      }
      return;
      try
      {
        localBitmap1 = aqhu.drawableToBitmap(URLDrawable.getDrawable(this.aCv).getCurrDrawable().mutate());
      }
      catch (Exception localException)
      {
        Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130847818);
      }
    }
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfByte[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
      paramArrayOfByte[(i * 2 + 1)] = ((byte)(paramArrayOfShort[i] >> 8 & 0xFF));
      i += 1;
    }
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void aS(int paramInt, String paramString)
  {
    try
    {
      ThreadManager.post(new QRDisplayActivity.28(this, "temp_qrcode_share_" + paramString + ".png", paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      rwt.ez(1, 2131698712);
    }
  }
  
  private void b(aeng.a parama, int paramInt, boolean paramBoolean)
  {
    int i = -1;
    if (paramBoolean) {
      bwD();
    }
    bwQ();
    rwt.c(this.app, paramInt);
    Object localObject;
    if (!parama.aho())
    {
      paramBoolean = true;
      ImmersiveUtils.setStatusTextColor(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130844509);
      if (!parama.ahp()) {
        break label168;
      }
      paramInt = -1;
      label63:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.nG.setBackgroundDrawable((Drawable)localObject);
      localObject = getResources().getDrawable(2130851758);
      if (!parama.ahp()) {
        break label175;
      }
      paramInt = -1;
      label102:
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!parama.ahp()) {
        break label182;
      }
    }
    label168:
    label175:
    label182:
    for (paramInt = i;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      this.gb.setBackgroundResource(2130845803);
      this.pp.setBackgroundResource(2130845803);
      return;
      paramBoolean = false;
      break;
      paramInt = -16777216;
      break label63;
      paramInt = -16777216;
      break label102;
    }
  }
  
  private void b(aeng.a parama, int paramInt, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setTroopDrawableListener(): ud = " + paramURLDrawable + " bkgURL = " + parama.bzR);
    }
    paramURLDrawable.setURLDrawableListener(new rux(this, paramBoolean, paramInt, parama));
  }
  
  private void b(aeng.a parama, boolean paramBoolean)
  {
    int j = -1;
    if (parama == null)
    {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme() qrCodeList is null just return");
      return;
    }
    this.bvx = this.jdField_a_of_type_Aeng.yX.indexOf(parama);
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "switchMyQrTheme().qrCodeList:" + parama.toString());
    }
    if (!TextUtils.isEmpty(parama.bzR))
    {
      this.aCv = parama.bzR;
      c(parama, this.bvx, paramBoolean);
    }
    Object localObject;
    if (!parama.aho())
    {
      paramBoolean = true;
      ImmersiveUtils.setStatusTextColor(paramBoolean, getWindow());
      localObject = getResources().getDrawable(2130851758);
      if (!parama.ahp()) {
        break label220;
      }
      i = -1;
      label138:
      ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      localObject = this.centerView;
      if (!parama.ahp()) {
        break label227;
      }
    }
    label220:
    label227:
    for (int i = j;; i = -16777216)
    {
      ((TextView)localObject).setTextColor(i);
      this.aCu = parama.bzS;
      this.aJL = parama.ahq();
      this.gb.setBackgroundResource(2130845803);
      this.pq.setBackgroundResource(2130845803);
      return;
      paramBoolean = false;
      break;
      i = -16777216;
      break label138;
    }
  }
  
  private void b(Bundle paramBundle, ArrayList<Rect> paramArrayList, Bitmap paramBitmap)
  {
    Bitmap localBitmap1;
    Bitmap localBitmap3;
    int i;
    String str1;
    String str2;
    int j;
    boolean bool2;
    String str3;
    if (TextUtils.isEmpty(this.aCv))
    {
      localBitmap1 = BitmapFactory.decodeResource(getResources(), 2130847818);
      localBitmap3 = this.cT;
      i = paramBundle.getInt("nameClr");
      str1 = this.aCr;
      str2 = String.format(getString(2131701853), new Object[] { this.uin });
      j = paramBundle.getInt("tipsClr");
      paramBundle = this.tips;
      bool2 = this.aJL;
      str3 = this.aCu;
      if (this.aJM) {
        break label258;
      }
    }
    label258:
    for (boolean bool1 = true;; bool1 = false)
    {
      for (;;)
      {
        paramBundle = rwt.a(this, localBitmap1, localBitmap3, paramBitmap, paramArrayList, i, str1, str2, j, paramBundle, bool2, str3, bool1);
        if (this.cU == null)
        {
          this.nJ.setImageBitmap(paramBundle[0]);
          this.zt.setText(this.aCr);
          this.zu.setText(String.format(getString(2131701853), new Object[] { this.uin }));
          this.zv.setText(getString(2131701542));
          this.nI.setImageBitmap(this.cT);
        }
        this.cU = paramBundle[1];
        localBitmap1.recycle();
        return;
        try
        {
          localBitmap1 = aqhu.drawableToBitmap(URLDrawable.getDrawable(this.aCv).getCurrDrawable().mutate());
        }
        catch (Exception localException)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(getResources(), 2130847818);
        }
      }
      break;
    }
  }
  
  private void bwG()
  {
    String str1;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131693404), 0).show(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      if (this.type == 2)
      {
        str1 = "";
        switch (this.atU)
        {
        }
        while (TextUtils.isEmpty(str1))
        {
          return;
          str1 = "qr_circle";
          continue;
          str1 = "qr_qq";
          continue;
          str1 = "qr_qzone";
          continue;
          str1 = "qr_wechat";
        }
        aqfr.b("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.uin, String.valueOf(this.bvr), "1" });
      }
      this.atU = -1;
      return;
    }
    switch (this.atU)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 3: 
      try
      {
        ThreadManager.post(new QRDisplayActivity.21(this, "temp_qrcode_share_" + this.uin + ".png"), 8, null, true);
        if (this.type != 2) {
          break;
        }
        anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.uin, "", String.valueOf(this.bvr), "");
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        int i;
        rwt.ez(1, 2131698712);
      }
      i = -1;
    }
    for (;;)
    {
      try
      {
        if (WXShareHelper.a().isWXinstalled()) {
          break label474;
        }
        i = 2131721935;
        if (i == -1) {
          break label490;
        }
        QQToast.a(this, getString(i), 0).show(getTitleBarHeight());
        if (this.type == 2)
        {
          if (this.atU != 2) {
            break label789;
          }
          str1 = "qr_wechat";
          aqfr.b("Grp_share", "grpData_admin", str1, 0, 0, new String[] { this.uin, String.valueOf(this.bvr), "1" });
        }
        this.atU = -1;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        rwt.ez(1, 2131698712);
      }
      if (this.type != 2) {
        break;
      }
      if (this.atU == 2) {}
      for (String str2 = "qr_wechat";; str2 = "qr_circle")
      {
        aqfr.b("Grp_share", "grpData_admin", str2, 0, 0, new String[] { this.uin, String.valueOf(this.bvr), "1" });
        return;
        label474:
        if (WXShareHelper.a().isWXsupportApi()) {
          break;
        }
        i = 2131721936;
        break;
        label490:
        if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new ruo(this);
          WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
        }
        ThreadManager.post(new QRDisplayActivity.20(this), 8, null, true);
        return;
      }
      if (this.type != 2) {
        break;
      }
      aqfr.b("Grp_share", "grpData_admin", "qr_qq", 0, 0, new String[] { this.uin, String.valueOf(this.bvr), "1" });
      return;
      if (this.type != 5) {
        break;
      }
      anot.a(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      bwC();
      if ((this.bvw & 0x1) != 0) {
        anot.a(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.type == 2)
      {
        anot.a(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.uin, "", String.valueOf(this.bvr), "");
        return;
      }
      if (this.type != 5) {
        break;
      }
      anot.a(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
      return;
      label789:
      String str3 = "qr_circle";
    }
  }
  
  private void bwI()
  {
    if ((this.app.bF()) || (!AppSetting.enableTalkBack)) {
      return;
    }
    Message localMessage = this.bw.obtainMessage(1000, 5, 0);
    this.bw.sendMessage(localMessage);
  }
  
  private void bwJ()
  {
    if ((this.app.bF()) || (!AppSetting.enableTalkBack)) {
      return;
    }
    this.bw.removeCallbacksAndMessages(null);
    this.bw.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  private void bwL()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.bk(2131698698, 1, 7);
    localausj.bk(2131698704, 1, 8);
    localausj.addCancelButton(2131721058);
    localausj.a(new rus(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void bwM()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().isWXinstalled();
    boolean bool2 = WXShareHelper.a().isWXsupportApi();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new rut(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void bwN()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().isWXinstalled();
    boolean bool2 = WXShareHelper.a().isWXsupportApi();
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() isWxInstalled = " + bool1 + " isWxSupportApi =" + bool2);
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, localArrayList);
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new ruu(this));
    ((ShareActionSheet)localObject1).show();
  }
  
  private void bwO()
  {
    Object localObject = String.format(getString(2131689805), new Object[] { getData() });
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "copyTroopLink.text:" + (String)localObject);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject);
    }
    for (;;)
    {
      QQToast.a(this, 2, getString(2131690298), 0).show(getTitleBarHeight());
      this.atU = -1;
      return;
      android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)getSystemService("clipboard");
      localObject = ClipData.newPlainText("my_qr_url", (CharSequence)localObject);
      alkw.a(localClipboardManager, (ClipData)localObject);
      localClipboardManager.setPrimaryClip((ClipData)localObject);
    }
  }
  
  private void bwP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "showURLProgressView() mTvProgress =" + this.zs);
    }
    if ((this.zs != null) && (this.mProgressDrawable != null))
    {
      this.zs.setVisibility(0);
      this.zs.setBackgroundDrawable(this.mProgressDrawable);
      ((Animatable)this.mProgressDrawable).start();
    }
  }
  
  private void bwQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "hideURLProgressView() mTvProgress =" + this.zs);
    }
    if ((this.zs != null) && (this.mProgressDrawable != null))
    {
      ((Animatable)this.mProgressDrawable).stop();
      this.zs.setBackgroundDrawable(null);
      this.zs.setVisibility(8);
    }
  }
  
  private void bwy()
  {
    Object localObject = (FrameLayout.LayoutParams)this.pm.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.pm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mScrollView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.nC.setVisibility(8);
    findViewById(2131375324).setBackgroundDrawable(null);
    this.jdField_pn_of_type_AndroidViewView.setVisibility(8);
    this.E = findViewById(16908290);
    this.nG = ((ImageView)findViewById(2131369594));
    this.nG.setVisibility(0);
    this.nG.setContentDescription(getString(2131699738));
    this.nG.setOnClickListener(this);
    this.leftView.setContentDescription(getString(2131720024));
    this.pr = findViewById(2131375345);
    this.pr.setVisibility(0);
    this.ps = this.pr.findViewById(2131375301);
    this.ps.setOnClickListener(this);
    this.ps.setContentDescription(getString(2131701542));
    this.gA = ((ImageView)this.pr.findViewById(2131369821));
    this.gA.setOnClickListener(this);
    this.nH = ((ImageView)this.pr.findViewById(2131369858));
    this.mNickName = ((TextView)this.pr.findViewById(2131380819));
    this.zr = ((TextView)this.pr.findViewById(2131381007));
    aldh.a(this.zr, this.uin, acfp.m(2131698699), new rup(this));
    this.my = ((TextView)this.pr.findViewById(2131380973));
    this.zr.setContentDescription(getString(2131717036));
    this.tips = getString(2131717229);
    localObject = findViewById(2131368202);
    ((View)localObject).setVisibility(0);
    this.gb = findViewById(2131375335);
    this.nD = ((ImageView)findViewById(2131375334));
    this.zo = ((TextView)findViewById(2131375336));
    this.pp = findViewById(2131375350);
    this.nE = ((ImageView)findViewById(2131375349));
    this.zp = ((TextView)findViewById(2131375351));
    int i = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298403) * 3) / 8;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    if (localMarginLayoutParams != null)
    {
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.rightMargin = i;
      ((View)localObject).setLayoutParams(localMarginLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$c = new c(null);
    this.gb.setOnClickListener(this);
    this.gb.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$c);
    this.pp.setOnClickListener(this);
    this.pp.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$c);
    this.mProgressDrawable = getResources().getDrawable(2130839657);
    this.zs = ((TextView)findViewById(2131374959));
    this.jdField_a_of_type_Aeng = aeni.a();
    if ((this.jdField_a_of_type_Aeng.yX.size() <= 0) || (TextUtils.isEmpty(((aeng.a)this.jdField_a_of_type_Aeng.yX.get(0)).bzR))) {
      this.my.setVisibility(8);
    }
    this.bvx = rwt.l(this.app);
    if ((this.bvx < 0) || (this.bvx >= this.jdField_a_of_type_Aeng.yX.size()))
    {
      this.E.setBackgroundResource(2130847818);
      localObject = getResources().getDrawable(2130844509);
      ((Drawable)localObject).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.nG.setBackgroundDrawable((Drawable)localObject);
      localObject = getResources().getDrawable(2130851758);
      ((Drawable)localObject).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject);
      this.centerView.setTextColor(-16777216);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800AEAB", "0X800AEAB", 0, 0, "", "", "", "");
      return;
      a((aeng.a)this.jdField_a_of_type_Aeng.yX.get(this.bvx), false);
    }
  }
  
  private void c(aeng.a parama, int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.pt.getBackground() == null) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (i != 0)
        {
          localObject = getResources().getDrawable(2130847818);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
          this.jdField_q_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(parama.bzR, localURLDrawableOptions);
          if (QLog.isColorLevel())
          {
            if ("setTroopURLDrawable: urlDrawable = " + this.jdField_q_of_type_ComTencentImageURLDrawable + " status = " + this.jdField_q_of_type_ComTencentImageURLDrawable == null) {
              break label300;
            }
            localObject = Integer.valueOf(this.jdField_q_of_type_ComTencentImageURLDrawable.getStatus());
            QLog.d("QRDisplayActivity", 2, new Object[] { localObject });
          }
          if (this.jdField_q_of_type_ComTencentImageURLDrawable.getStatus() == 1)
          {
            if (paramBoolean) {
              bwD();
            }
            bwQ();
            rwt.d(this.app, paramInt);
            this.pt.setBackgroundDrawable(this.jdField_q_of_type_ComTencentImageURLDrawable.getCurrDrawable());
          }
        }
        else
        {
          localObject = this.pt.getBackground();
          continue;
        }
        if (i != 0) {
          this.pt.setBackgroundResource(2130847818);
        }
        b(parama, paramInt, paramBoolean, this.jdField_q_of_type_ComTencentImageURLDrawable);
        bwP();
        this.jdField_q_of_type_ComTencentImageURLDrawable.startDownload();
        this.jdField_q_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        return;
      }
      catch (IllegalArgumentException parama)
      {
        QLog.d("QRDisplayActivity", 1, "setTroopURLDrawable bkgURL is illegal please check manage info e =" + parama);
        QQToast.a(this, getString(2131698697), 0).show();
        bwQ();
        if (i != 0) {
          this.pt.setBackgroundResource(2130847818);
        }
        return;
      }
      i = 0;
      continue;
      label300:
      Object localObject = " is null";
    }
  }
  
  /* Error */
  private boolean fG(String paramString)
  {
    // Byte code:
    //   0: new 1151	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 1154	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 1157	java/io/File:exists	()Z
    //   13: ifne +187 -> 200
    //   16: new 1159	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 1160	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 1163	com/tencent/chirp/ChirpWrapper:init	()I
    //   30: ifne +298 -> 328
    //   33: aload_0
    //   34: getfield 584	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 1166	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 245	java/lang/String
    //   44: dup
    //   45: ldc_w 1168
    //   48: invokespecial 1169	java/lang/String:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: new 300	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 1171
    //   63: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: iconst_0
    //   69: bipush 14
    //   71: aload_3
    //   72: invokevirtual 1174	java/lang/String:length	()I
    //   75: isub
    //   76: invokevirtual 1178	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_3
    //   90: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +30 -> 123
    //   96: ldc_w 298
    //   99: iconst_2
    //   100: new 300	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 1180
    //   110: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 5
    //   125: aload_3
    //   126: invokevirtual 1183	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   129: astore_3
    //   130: aload_3
    //   131: getfield 1189	android/util/Pair:first	Ljava/lang/Object;
    //   134: checkcast 1127	java/lang/Integer
    //   137: invokevirtual 1192	java/lang/Integer:intValue	()I
    //   140: istore_2
    //   141: aload_3
    //   142: getfield 1195	android/util/Pair:second	Ljava/lang/Object;
    //   145: checkcast 1197	[S
    //   148: astore 4
    //   150: iload_2
    //   151: ifne +137 -> 288
    //   154: aload 4
    //   156: ifnull +132 -> 288
    //   159: new 1199	java/io/FileOutputStream
    //   162: dup
    //   163: aload_1
    //   164: invokespecial 1202	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_3
    //   168: aload 4
    //   170: arraylength
    //   171: iconst_2
    //   172: imul
    //   173: newarray byte
    //   175: astore_1
    //   176: aload 4
    //   178: aload_1
    //   179: invokestatic 1204	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   182: aload_3
    //   183: aload_1
    //   184: invokevirtual 1208	java/io/FileOutputStream:write	([B)V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 1211	java/io/FileOutputStream:close	()V
    //   195: aload 5
    //   197: invokevirtual 1214	com/tencent/chirp/ChirpWrapper:release	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_1
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload 5
    //   208: invokevirtual 1214	com/tencent/chirp/ChirpWrapper:release	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_1
    //   216: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +14 -> 233
    //   222: ldc_w 298
    //   225: iconst_2
    //   226: ldc_w 540
    //   229: aload_3
    //   230: invokestatic 1217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload_1
    //   234: astore_3
    //   235: aload_1
    //   236: ifnull +9 -> 245
    //   239: aload_1
    //   240: invokevirtual 1211	java/io/FileOutputStream:close	()V
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 1211	java/io/FileOutputStream:close	()V
    //   253: aload 5
    //   255: invokevirtual 1214	com/tencent/chirp/ChirpWrapper:release	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -18 -> 245
    //   266: astore_1
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: ifnull +7 -> 280
    //   276: aload_3
    //   277: invokevirtual 1211	java/io/FileOutputStream:close	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload_1
    //   287: athrow
    //   288: invokestatic 296	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +30 -> 321
    //   294: ldc_w 298
    //   297: iconst_4
    //   298: new 300	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 1219
    //   308: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload_2
    //   312: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 5
    //   323: invokevirtual 1214	com/tencent/chirp/ChirpWrapper:release	()V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload 5
    //   330: invokevirtual 1214	com/tencent/chirp/ChirpWrapper:release	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: goto -141 -> 195
    //   339: astore_1
    //   340: goto -87 -> 253
    //   343: astore_3
    //   344: goto -64 -> 280
    //   347: astore_1
    //   348: goto -76 -> 272
    //   351: astore 4
    //   353: aload_1
    //   354: astore_3
    //   355: aload 4
    //   357: astore_1
    //   358: goto -86 -> 272
    //   361: astore 4
    //   363: aload_3
    //   364: astore_1
    //   365: aload 4
    //   367: astore_3
    //   368: goto -152 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	QRDisplayActivity
    //   0	371	1	paramString	String
    //   140	172	2	i	int
    //   40	152	3	localObject1	Object
    //   213	17	3	localException1	Exception
    //   234	43	3	str	String
    //   343	1	3	localIOException	java.io.IOException
    //   354	14	3	localObject2	Object
    //   51	126	4	localObject3	Object
    //   351	5	4	localObject4	Object
    //   361	5	4	localException2	Exception
    //   23	306	5	localChirpWrapper	ChirpWrapper
    // Exception table:
    //   from	to	target	type
    //   191	195	202	finally
    //   33	123	205	finally
    //   123	150	205	finally
    //   203	205	205	finally
    //   280	282	205	finally
    //   283	285	205	finally
    //   286	288	205	finally
    //   288	321	205	finally
    //   159	168	213	java/lang/Exception
    //   239	243	260	java/io/IOException
    //   239	243	266	finally
    //   159	168	269	finally
    //   267	269	269	finally
    //   249	253	282	finally
    //   276	280	285	finally
    //   191	195	335	java/io/IOException
    //   249	253	339	java/io/IOException
    //   276	280	343	java/io/IOException
    //   168	187	347	finally
    //   216	233	351	finally
    //   168	187	361	java/lang/Exception
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.ZM + " ,isResume = " + paramBoolean);
    }
    if (this.ZM) {
      ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  protected void Qq()
  {
    if (this.e == null)
    {
      this.e = ((ausj)auss.a(this, null));
      this.e.addButton(2131717162, 1);
      this.e.addButton(2131717164, 1);
      this.e.addButton(2131717161, 1);
      this.e.addCancelButton(2131721058);
      this.e.setOnDismissListener(new ruz(this));
      this.e.a(new rva(this));
    }
    if (!this.e.isShowing())
    {
      this.ach = false;
      this.e.show();
    }
  }
  
  void aL(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  public void aX(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if ((this.isTimeout) || (super.isFinishing())) {
      return;
    }
    this.mHandler.removeCallbacks(this.dA);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int m = paramBundle.getInt("B");
    int n = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i = paramBundle.getInt("qrsz");
      localObject = getData();
      if (localObject != null) {
        this.jdField_a_of_type_Lk = rwt.a((String)localObject, i);
      }
    }
    int i1 = this.jdField_a_of_type_Lk.getWidth();
    Object localObject = new int[i1 * i1];
    int i = 0;
    while (i < i1)
    {
      j = 0;
      if (j < i1)
      {
        if (this.jdField_a_of_type_Lk.get(j, i)) {}
        for (int k = m;; k = n)
        {
          localObject[(i * i1 + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i1, 0, 0, i1, i1);
    int j = 0;
    i = j;
    if ((this.dwGroupFlagExt & 0x800) != 0L)
    {
      if (this.bvs == 2) {
        i = 2130844648;
      }
    }
    else
    {
      this.pl.setVisibility(4);
      if ((this.cU != null) && (!this.cU.isRecycled())) {
        this.cU.recycle();
      }
      if (this.type != 1) {
        break label378;
      }
      a(paramBundle, localArrayList, localBitmap3);
      label332:
      localBitmap3.recycle();
      if (this.cU == null) {
        break label453;
      }
      this.nC.setImageBitmap(this.cU);
    }
    for (;;)
    {
      this.isLoading = false;
      return;
      i = j;
      if (this.bvs != 1) {
        break;
      }
      i = 2130844648;
      break;
      label378:
      if (this.type == 2)
      {
        b(paramBundle, localArrayList, localBitmap3);
        break label332;
      }
      this.cU = rwt.a(this, localBitmap1, this.cT, paramBundle.getInt("nameClr"), this.aCr, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.tips, localRect, localArrayList, i);
      break label332;
      label453:
      if (super.isResume())
      {
        paramBundle = aqha.a(this, 230);
        paramBundle.setMessage(2131719037);
        paramBundle.setPositiveButton(2131721079, new rui(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  public lk b(String paramString, int paramInt1, int paramInt2)
  {
    String str = nh();
    if (str == null) {}
    do
    {
      return null;
      str = getSharedPreferences("qrcode", 0).getString(str, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRDisplayActivity", 2, "getPrefMatrix uin: " + paramString + " type: " + paramInt1 + " data: " + str);
      }
    } while (str == null);
    return rwt.a(str, paramInt2);
  }
  
  public void bwA()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new ruh(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      bwB();
      return;
    }
    bwB();
  }
  
  public void bwB()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.11(this));
    String str = null;
    if (this.type == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.type == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void bwC()
  {
    ThreadManager.executeOnFileThread(new QRDisplayActivity.12(this));
    String str = null;
    if (this.type == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.type == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  public void bwD()
  {
    if ((this.isTimeout) || (super.isFinishing())) {
      return;
    }
    this.pl.setVisibility(0);
    this.isLoading = true;
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool3 = this.mIsInit;
    boolean bool1;
    int i;
    if ((this.dwGroupFlagExt & 0x800) != 0L)
    {
      bool1 = true;
      i = this.bvs;
      if ((this.type != 1) && (this.type != 2)) {
        break label123;
      }
    }
    label123:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool3, bool1, i, bool2);
      if (!this.mIsInit) {
        break label128;
      }
      this.mIsInit = false;
      return;
      bool1 = false;
      break;
    }
    label128:
    if (this.type == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      anpc.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  public void bwE()
  {
    this.mHandler.removeCallbacks(this.dA);
    if (super.isResume())
    {
      aqju localaqju = aqha.a(this, 230);
      localaqju.setMessage(2131719035);
      localaqju.setPositiveButton(2131721079, new ruj(this));
      localaqju.show();
      return;
    }
    finish();
  }
  
  protected void bwF()
  {
    if (this.mShareActionSheet == null)
    {
      rul localrul = new rul(this);
      rum localrum = new rum(this);
      this.mShareActionSheet = new ShareActionSheetBuilder(this);
      this.mShareActionSheet.setActionSheetTitle(getString(2131720177));
      this.mShareActionSheet.setActionSheetItems(a(this));
      this.mShareActionSheet.setOnDismissListener(localrum);
      this.mShareActionSheet.setCancelListener(new run(this));
      this.mShareActionSheet.setItemClickListener(localrul);
    }
    try
    {
      if ((this.mShareActionSheet != null) && (!this.mShareActionSheet.isShowing()))
      {
        this.ach = false;
        this.mShareActionSheet.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void bwH()
  {
    if (this.type == 1) {
      anot.a(this.app, "CliOper", "", "", "0X800AEAF", "0X800AEAF", 0, 0, "", "", "", "");
    }
    anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.mFrom))
    {
      if (isInMultiWindow()) {
        QQToast.a(this, acfp.m(2131712594), 0).show();
      }
      setResult(-1);
      finish();
      return;
    }
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131712596), 0).show();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void bwK()
  {
    if (isResume()) {
      this.bw.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void bwu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.bF());
    }
  }
  
  public void bwv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.bw.removeCallbacksAndMessages(null);
    Message.obtain(this.bw, 1001, 3, 0).sendToTarget();
  }
  
  protected void bwz()
  {
    Object localObject2 = (FrameLayout.LayoutParams)this.pm.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    this.pm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.mScrollView.setBackgroundDrawable(null);
    getTitleBarView().setBackgroundColor(0);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.nC.setVisibility(8);
    findViewById(2131375324).setBackgroundDrawable(null);
    this.jdField_pn_of_type_AndroidViewView.setVisibility(8);
    this.pt = findViewById(16908290);
    this.pu = findViewById(2131375356);
    this.pu.setVisibility(0);
    this.pv = this.pu.findViewById(2131375300);
    this.pv.setOnClickListener(this);
    this.pv.setOnTouchListener(jll.a);
    this.pv.setContentDescription(getString(2131701542));
    this.nI = ((ImageView)this.pu.findViewById(2131375292));
    this.nI.setOnClickListener(this);
    this.nJ = ((ImageView)this.pu.findViewById(2131375293));
    this.zt = ((TextView)this.pu.findViewById(2131375297));
    this.zt.setEllipsize(TextUtils.TruncateAt.END);
    this.zt.setSingleLine();
    this.zu = ((TextView)this.pu.findViewById(2131375299));
    this.nK = ((ImageView)this.pu.findViewById(2131375294));
    this.zw = ((TextView)this.pu.findViewById(2131375296));
    aldh.a(this.zu, this.uin, acfp.m(2131698700), null);
    this.zv = ((TextView)this.pu.findViewById(2131375298));
    this.zu.setContentDescription(getString(2131717035));
    Object localObject1 = findViewById(2131368203);
    ((View)localObject1).setVisibility(0);
    this.gb = findViewById(2131375338);
    this.nD = ((ImageView)findViewById(2131375337));
    this.zo = ((TextView)findViewById(2131375339));
    this.pq = findViewById(2131375358);
    this.nF = ((ImageView)findViewById(2131375357));
    this.zq = ((TextView)findViewById(2131375359));
    Object localObject3 = (TroopManager)this.app.getManager(52);
    if (localObject3 != null)
    {
      localObject3 = ((TroopManager)localObject3).b(this.uin);
      if (localObject3 != null)
      {
        if (((TroopInfo)localObject3).isNewTroop)
        {
          this.aJM = true;
          this.zu.setVisibility(8);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zu.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
          this.zu.setLayoutParams(localLayoutParams);
          localObject2 = (RelativeLayout.LayoutParams)this.pv.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).height -= 42;
          this.pv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if ((((TroopInfo)localObject3).cGroupOption != 3) || ((TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject3).troopPrivilegeFlag, 512)))) {
          break label923;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not allow join mask");
        }
        this.nK.setVisibility(0);
        this.zw.setVisibility(0);
        this.zw.setText(getString(2131698713));
        this.gb.setVisibility(8);
        this.pq.setVisibility(8);
      }
    }
    for (;;)
    {
      int i = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131298403) * 3) / 8;
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.gb.setOnClickListener(this);
      this.gb.setOnTouchListener(jll.a);
      this.pq.setOnClickListener(this);
      this.pq.setOnTouchListener(jll.a);
      this.mProgressDrawable = getResources().getDrawable(2130839657);
      this.zs = ((TextView)findViewById(2131374959));
      this.tips = getString(2131717183);
      this.leftView.setContentDescription(getString(2131699919));
      this.jdField_a_of_type_Aeng = aeni.a();
      if ((this.jdField_a_of_type_Aeng.yX.size() <= 0) || (TextUtils.isEmpty(((aeng.a)this.jdField_a_of_type_Aeng.yX.get(0)).bzR))) {
        this.zv.setVisibility(8);
      }
      this.bvx = rwt.m(this.app);
      if ((this.bvx >= 0) && (this.bvx < this.jdField_a_of_type_Aeng.yX.size())) {
        break;
      }
      this.pt.setBackgroundResource(2130847818);
      localObject1 = getResources().getDrawable(2130851758);
      ((Drawable)localObject1).setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.leftView.setBackgroundDrawable((Drawable)localObject1);
      this.centerView.setTextColor(-16777216);
      return;
      label923:
      if (((((TroopInfo)localObject3).dwGroupFlagExt & 0x80) != 0L) && (!((TroopInfo)localObject3).isAdmin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "initTroopQrCodeUI: not invite join mask");
        }
        this.nK.setVisibility(0);
        this.zw.setVisibility(0);
        this.zw.setText(getString(2131698714));
        this.gb.setVisibility(8);
        this.pq.setVisibility(8);
      }
    }
    b((aeng.a)this.jdField_a_of_type_Aeng.yX.get(this.bvx), false);
  }
  
  public void cB(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (this.type == 2) {
      localObject1 = "";
    }
    Object localObject2;
    label58:
    boolean bool;
    switch (paramInt1)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (paramInt2 == -1)
        {
          localObject2 = "0";
          aqfr.b("Grp_share", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.uin, String.valueOf(this.bvr), localObject2 });
        }
      }
      else
      {
        if (paramInt2 != -1) {
          break label226;
        }
        bool = true;
        label105:
        um(bool);
        if (paramInt2 == -1)
        {
          if (paramInt1 != 1) {
            break label232;
          }
          aL(0, getString(2131717163));
          if (QLog.isColorLevel()) {
            QLog.i("QRDisplayActivity", 2, "shareQRCode success");
          }
          if ((this.bvw & 0x1) != 0) {
            anot.a(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
          }
        }
      }
      break;
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      localObject1 = "qr_qzone";
      break;
      localObject1 = "qr_qq";
      break;
      localObject2 = "1";
      break label58;
      label226:
      bool = false;
      break label105;
      label232:
      if (paramInt1 == 2)
      {
        localObject1 = new Intent(this, SplashActivity.class);
        ((Intent)localObject1).putExtras(paramIntent);
        localObject2 = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, (SessionInfo)localObject2, (Intent)localObject1);
      }
      else if (paramInt1 == 21)
      {
        localObject1 = wja.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject1);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((1 == super.getIntent().getIntExtra("type", 1)) || (2 == super.getIntent().getIntExtra("type", 2))) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    this.mHandler = new Handler();
    super.setContentView(2131560587);
    paramBundle = super.getIntent();
    this.mFrom = paramBundle.getStringExtra("from");
    this.bvw = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.aCr = paramBundle.getStringExtra("nick");
    this.cT = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.type = paramBundle.getIntExtra("type", 1);
    this.uin = paramBundle.getStringExtra("uin");
    this.bvr = paramBundle.getIntExtra("adminLevel", 2);
    this.dwGroupFlagExt = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.bvs = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    this.isQidianPrivateTroop = paramBundle.getBooleanExtra("isQidianPrivateTroop", false);
    this.nC = ((ImageView)super.findViewById(2131375325));
    this.mScrollView = super.findViewById(2131375353);
    this.jdField_pn_of_type_AndroidViewView = findViewById(2131375343);
    this.pm = super.findViewById(2131375360);
    if (this.type == 1) {
      bwy();
    }
    Object localObject1;
    int i;
    for (;;)
    {
      this.pl = super.findViewById(2131375341);
      this.po = findViewById(2131374348);
      this.jdField_pn_of_type_AndroidViewView.setContentDescription(getString(2131698703));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.type);
      }
      if (this.type != 5) {
        break label1188;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_Acdv);
      if (this.app != null)
      {
        this.jdField_a_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$b);
      }
      this.leftView.setContentDescription(getString(2131698327));
      this.jdField_pn_of_type_AndroidViewView.setContentDescription(getString(2131698328));
      setResult(-1, getIntent());
      paramBundle = (acff)this.app.getManager(51);
      localObject2 = (acdu)this.app.getManager(53);
      localObject1 = ((acdu)localObject2).a(this.uin);
      if (localObject1 != null) {
        break;
      }
      bwE();
      i = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.type);
      this.mHandler.postDelayed(this.dA, 60000L);
      if (i != 0)
      {
        this.nC.setContentDescription(this.aCr + "," + this.tips);
        this.mScrollView.post(this.dy);
      }
      if ((this.bvw & 0x1) != 0) {
        anot.a(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.bw = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.bw.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.type == 2)
      {
        bwz();
      }
      else if (this.type == 5)
      {
        findViewById(2131374347).setVisibility(0);
        findViewById(2131368201).setVisibility(0);
        findViewById(2131375332).setOnClickListener(this);
        findViewById(2131375333).setOnClickListener(this);
        this.tips = getString(2131717179);
      }
      else if (this.type == 11)
      {
        findViewById(2131374347).setVisibility(0);
        findViewById(2131368201).setVisibility(0);
        findViewById(2131375332).setOnClickListener(this);
        findViewById(2131375333).setOnClickListener(this);
        this.tips = getString(2131717213);
      }
    }
    Object localObject2 = ((acdu)localObject2).z(this.uin);
    if (localObject2 != null)
    {
      this.bvv = ((List)localObject2).size();
      if (!((DiscussionInfo)localObject1).hasRenamed())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
        }
        if (localObject2 != null) {
          localObject1 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1017;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_pn_of_type_JavaUtilList.add(aqgv.n(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
          continue;
          this.bvv = 0;
          break;
        }
        Friends localFriends = paramBundle.e(((DiscussionMemberInfo)localObject2).memberUin);
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          this.jdField_pn_of_type_JavaUtilList.add(localFriends.name);
        } else if (getNickName(((DiscussionMemberInfo)localObject2).memberUin) != null) {
          this.jdField_pn_of_type_JavaUtilList.add(getNickName(((DiscussionMemberInfo)localObject2).memberUin));
        } else {
          this.uinList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
      label1017:
      if ((this.jdField_pn_of_type_JavaUtilList.size() >= 5) || (this.uinList.size() <= 0)) {
        break label1287;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.uinList.size()];
      localObject1 = this.uinList.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
      ((acdt)this.app.getBusinessHandler(6)).b(new String[] { "20002" }, paramBundle);
    }
    label1287:
    for (int j = 0;; j = 1)
    {
      i = j;
      if (this.jdField_pn_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_pn_of_type_JavaUtilList, new a());
      this.aCr = u(this.jdField_pn_of_type_JavaUtilList);
      i = j;
      break;
      label1188:
      if (this.type == 2)
      {
        this.jdField_pn_of_type_AndroidViewView.setContentDescription(getString(2131717181, new Object[] { this.aCr, this.tips }));
        addObserver(this.jdField_a_of_type_Ashx);
        i = 1;
        break;
      }
      if (this.type == 11) {
        this.jdField_pn_of_type_AndroidViewView.setContentDescription(getString(2131717181, new Object[] { this.aCr, this.tips }));
      }
      i = 1;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    this.mHandler.removeCallbacks(this.dA);
    if ((this.cU != null) && (!this.cU.isRecycled()))
    {
      this.cU.recycle();
      this.cU = null;
    }
    this.nC.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.release();
    if (this.type == 5)
    {
      removeObserver(this.jdField_a_of_type_Acdv);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$b);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null)
      {
        WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = null;
      }
      if (this.jdField_a_of_type_Afet != null) {
        this.jdField_a_of_type_Afet.b(this);
      }
      super.doOnDestroy();
      return;
      if (this.type == 2) {
        removeObserver(this.jdField_a_of_type_Ashx);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.bw != null)
    {
      this.bw.removeCallbacksAndMessages(null);
      this.bw.sendEmptyMessage(1001);
    }
    iA(false);
    bwQ();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.bw.obtainMessage(1004, 2, 0).sendToTarget();
    iA(true);
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  public String getData()
  {
    String str = nh();
    if (str == null) {
      return null;
    }
    return getSharedPreferences("qrcode", 0).getString(str, null);
  }
  
  public String getNickName(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  @TargetApi(14)
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.cKW();
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.enableTalkBack);
        }
        if ((AppSetting.enableTalkBack) && (this.type == 1))
        {
          bool1 = ChirpWrapper.loadLibrary();
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "isSoLoaded " + bool1);
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_Afet == null) {
              this.jdField_a_of_type_Afet = ((afet)((afem)this.app.getManager(77)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_Afet.a(this);
            this.jdField_a_of_type_Afet.HL(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.23(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.aJP)
      {
        BaseApplicationImpl.sUiHandler.post(new QRDisplayActivity.22(this));
        this.aJP = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.aJO);
        }
        if (this.aJO) {
          break;
        }
        String str = getFilesDir() + this.app.getCurrentAccountUin() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (fG(str)) {
            break label530;
          }
        }
        label530:
        for (bool1 = true;; bool1 = false)
        {
          this.aJO = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.aJO);
          }
          if (this.aJO) {
            break label535;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.startPlay();
            aqge.m(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          anot.a(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label535:
        this.bw.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.stopPlay();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          anot.a(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          anot.a(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        aqge.m(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.startPlay();
        break;
        QQAppInterface.EI(aCw);
        break;
        bool1 = false;
      }
    }
  }
  
  public String nh()
  {
    if (this.type == 1) {
      return "user" + this.uin;
    }
    if (this.type == 2) {
      return "group" + this.uin;
    }
    if (this.type == 5) {
      return "discussion" + this.uin;
    }
    if (this.type == 11) {
      return "groupqav" + this.uin;
    }
    return null;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.dk) <= 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.dk = l;
      if (paramView.getId() == 2131375343)
      {
        if (this.isLoading) {
          continue;
        }
        if (this.type == 2)
        {
          bwD();
          if ((this.bvw & 0x1) == 0) {
            continue;
          }
          anot.a(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.type == 5) || (this.type == 11))
        {
          bwD();
          anot.a(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          continue;
        }
        Qq();
        continue;
      }
      if (paramView.getId() == 2131375327) {
        if (this.L == null) {
          this.L = new zcq(this).a(this);
        }
      }
      try
      {
        this.L.show();
        label217:
        anot.a(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        continue;
        if (paramView.getId() == 2131375332)
        {
          if (this.isLoading) {
            continue;
          }
          bwA();
          if ((this.bvw & 0x1) != 0) {
            anot.a(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.type == 5) {
            anot.a(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          }
          if (this.type != 2) {
            continue;
          }
          new anov(this.app).a("P_CliOper").b("Grp_set").c("Grp_data").d("qr_save").a(new String[] { this.uin, "", String.valueOf(this.bvr) }).report();
          continue;
        }
        if (paramView.getId() == 2131375333)
        {
          bwF();
          if (this.type != 5) {
            continue;
          }
          anot.a(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          continue;
        }
        if ((paramView.getId() == 2131375349) || (paramView.getId() == 2131375351))
        {
          bwH();
          continue;
        }
        if (paramView.getId() == 2131375335)
        {
          anot.a(this.app, "CliOper", "", "", "0X800AEAD", "0X800AEAD", 0, 0, "", "", "", "");
          bwM();
          continue;
        }
        if (paramView.getId() == 2131375338)
        {
          bwN();
          continue;
        }
        if (paramView.getId() == 2131375358)
        {
          bwA();
          continue;
        }
        if (paramView.getId() == 2131375350)
        {
          bwH();
          continue;
        }
        if (paramView.getId() == 2131369594)
        {
          anot.a(this.app, "CliOper", "", "", "0X800AEB5", "0X800AEB5", 0, 0, "", "", "", "");
          bwL();
          continue;
        }
        if (paramView.getId() == 2131375301)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "onClick qr_code_white_bg isLoading =" + this.isLoading);
          }
          if (this.isLoading) {
            continue;
          }
          anot.a(this.app, "CliOper", "", "", "0X800AEB4", "0X800AEB4", 0, 0, "", "", "", "");
          a(rwt.a(this.app, this.jdField_a_of_type_Aeng, this.bvx), true);
          continue;
        }
        if (paramView.getId() != 2131375300) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "onClick qr_code_troop_white_bg isLoading =" + this.isLoading);
        }
        if (this.isLoading) {
          continue;
        }
        b(rwt.a(this.app, this.jdField_a_of_type_Aeng, this.bvx), true);
      }
      catch (Exception localException)
      {
        break label217;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.L.dismiss();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = -1;
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
      for (;;)
      {
        if (i == -1) {
          break label104;
        }
        rwt.ez(1, i);
        break;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      label104:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new ruk(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
      }
      Object localObject = this.app;
      String str1;
      label149:
      String str2;
      Bitmap localBitmap;
      String str3;
      if (paramInt == 2)
      {
        str1 = "1";
        anot.a((QQAppInterface)localObject, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, str1, "", "", "");
        this.Qt = String.valueOf(System.currentTimeMillis());
        str1 = String.format(getString(2131692846), new Object[] { this.aCr });
        if (this.type == 11) {
          str1 = getString(2131694563);
        }
        localObject = WXShareHelper.a();
        str2 = this.Qt;
        localBitmap = this.cT;
        str3 = this.aCs;
        if (paramInt != 2) {
          break label293;
        }
      }
      label293:
      for (i = 0;; i = 1)
      {
        ((WXShareHelper)localObject).a(str2, str1, localBitmap, "", str3, i);
        break;
        str1 = "0";
        break label149;
      }
      if (this.jdField_q_of_type_Arhz == null)
      {
        this.jdField_q_of_type_Arhz = new arhz(this, getTitleBarHeight());
        this.jdField_q_of_type_Arhz.setMessage(2131696693);
        this.jdField_q_of_type_Arhz.setBackAndSearchFilter(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.aCt, this.uin, this.aCr, this.bvv, this.jdField_q_of_type_Arhz);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.aCs, this.uin, this.aCr);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.mValidTime, this.aCs, this.aCr);
    }
  }
  
  public void onPlayStart() {}
  
  public String u(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void u(String paramString1, int paramInt, String paramString2)
  {
    String str = nh();
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "setPrefMatrix uin: " + paramString1 + " type: " + paramInt + " data: " + paramString2);
    }
    paramString1 = getSharedPreferences("qrcode", 0).edit();
    paramString1.putString(str, paramString2);
    paramString1.commit();
  }
  
  public void um(boolean paramBoolean)
  {
    Intent localIntent;
    Object localObject;
    if (this.type == 11)
    {
      localIntent = getIntent();
      localObject = localIntent.getParcelableExtra("PARAM_QRForwardReceiver");
      if ((localObject instanceof ResultReceiver))
      {
        localObject = (ResultReceiver)localObject;
        if (!paramBoolean) {
          break label55;
        }
      }
    }
    label55:
    for (int i = -1;; i = 0)
    {
      ((ResultReceiver)localObject).send(i, localIntent.getExtras());
      return;
    }
  }
  
  public void xZ(int paramInt)
  {
    this.mHandler.removeCallbacks(this.dA);
    String str;
    switch (paramInt)
    {
    default: 
      str = acfp.m(2131712597);
    }
    for (;;)
    {
      aL(2130840095, str);
      finish();
      return;
      str = acfp.m(2131712598);
      continue;
      str = acfp.m(2131712595);
    }
  }
  
  public void ya(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "1", 0, null);
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1&seq=" + l));
    startActivityForResult(localIntent, -1);
  }
  
  public void yb(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0)) {
      QLog.d("QRDisplayActivity", 2, "onPlayStop, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.bw.sendEmptyMessage(1001);
      this.bw.sendEmptyMessageDelayed(1003, 500L);
      return;
    } while (this.bw.hasMessages(1001));
    this.bw.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public class a
    implements Comparator<String>
  {
    public a() {}
    
    public int compare(String paramString1, String paramString2)
    {
      int i = 1;
      if ((paramString1 != null) && (paramString2 != null)) {
        i = ChnToSpell.aJ(paramString1, 1).compareTo(ChnToSpell.aJ(paramString2, 1));
      }
      while (paramString1 != null) {
        return i;
      }
      if (paramString2 != null) {
        return -1;
      }
      return 0;
    }
  }
  
  public class b
    implements BusinessObserver
  {
    public b() {}
    
    protected void c(boolean paramBoolean, List<String> paramList1, List<String> paramList2) {}
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      if (paramBoolean)
      {
        c(paramBoolean, paramBundle.getStringArrayList("nickname_list"), paramBundle.getStringArrayList("uin_list"));
        return;
      }
      QRDisplayActivity.this.bwE();
    }
  }
  
  class c
    implements View.OnTouchListener
  {
    private c() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return false;
        if ((2131375335 == paramView.getId()) && (QRDisplayActivity.this.nD != null) && (QRDisplayActivity.this.zo != null))
        {
          QRDisplayActivity.this.nD.setAlpha(0.5F);
          QRDisplayActivity.this.zo.setAlpha(0.5F);
        }
        else if ((2131375350 == paramView.getId()) && (QRDisplayActivity.this.nE != null) && (QRDisplayActivity.this.zp != null))
        {
          QRDisplayActivity.this.nE.setAlpha(0.5F);
          QRDisplayActivity.this.zp.setAlpha(0.5F);
          continue;
          if ((2131375335 == paramView.getId()) && (QRDisplayActivity.this.nD != null) && (QRDisplayActivity.this.zo != null))
          {
            QRDisplayActivity.this.nD.setAlpha(1.0F);
            QRDisplayActivity.this.zo.setAlpha(1.0F);
          }
          else if ((2131375350 == paramView.getId()) && (QRDisplayActivity.this.nE != null) && (QRDisplayActivity.this.zp != null))
          {
            QRDisplayActivity.this.nE.setAlpha(1.0F);
            QRDisplayActivity.this.zp.setAlpha(1.0F);
          }
        }
      }
    }
  }
  
  static class d
    implements rtu
  {
    public String aCy;
    public WeakReference<QRDisplayActivity> activityRef;
    public int uinType;
    
    public void F(boolean paramBoolean, String paramString)
    {
      if (this.activityRef == null) {}
      QRDisplayActivity localQRDisplayActivity;
      do
      {
        do
        {
          return;
          localQRDisplayActivity = (QRDisplayActivity)this.activityRef.get();
        } while (localQRDisplayActivity == null);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, String.format("onReceive qrcode url:%s suc:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
        }
      } while ((localQRDisplayActivity.isTimeout) || (localQRDisplayActivity.isFinishing()));
      if (!paramBoolean)
      {
        localQRDisplayActivity.bwE();
        return;
      }
      localQRDisplayActivity.u(this.aCy, this.uinType, paramString);
      paramString = rwt.a(paramString, -1);
      if (paramString != null)
      {
        localQRDisplayActivity.a = paramString;
        localQRDisplayActivity.bwD();
        return;
      }
      localQRDisplayActivity.bwE();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */