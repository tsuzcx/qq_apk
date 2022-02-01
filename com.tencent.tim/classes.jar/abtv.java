import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloImageShareLayout;
import com.tencent.mobileqq.apollo.store.ApolloViewController.2;
import com.tencent.mobileqq.apollo.store.ApolloViewController.3;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class abtv
  implements abja, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener, TouchWebView.OnScrollChangedListener
{
  private RelativeLayout.LayoutParams D;
  TextView PW;
  private TextView PX;
  public int Sy;
  private abtv.b jdField_a_of_type_Abtv$b;
  private abty jdField_a_of_type_Abty;
  private abuc jdField_a_of_type_Abuc;
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  private auru jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private ApolloImageShareLayout jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout;
  private ApolloWebAvatarParam jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
  private abiy jdField_b_of_type_Abiy;
  BarrageView jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView;
  boolean bFq;
  boolean bFr;
  private boolean bFs;
  private boolean bFt;
  private boolean bFu;
  private boolean bFv;
  public boolean bFw;
  private boolean bFx;
  String bhE;
  private String bhF;
  String bhG;
  String bhH;
  FrameLayout bp;
  private abiy c;
  int crJ = 1;
  private int crK;
  private int crL;
  private int crM;
  private int crN;
  private int crO;
  private int cre;
  Button fD;
  private WeakReference<abja> fP;
  ApolloTextureView g;
  LinearLayout ii;
  private HashMap<String, ApolloWebAvatarParam> iz = new HashMap();
  RelativeLayout jq;
  RelativeLayout jr;
  int mApolloStatus;
  private AudioManager mAudioManager;
  boolean mInited;
  private MediaPlayer mPlayer;
  private RelativeLayout mRootView;
  boolean mSurfaceReady;
  private String mTab;
  TextView mTitleView;
  private float sC;
  public float sF;
  private float sG = 2.0F;
  private float sH = 1.0F;
  float sI;
  float sJ;
  private ImageView xG;
  private ImageView xH;
  
  public abtv(RelativeLayout paramRelativeLayout, abuc paramabuc)
  {
    this.jdField_a_of_type_Abuc = paramabuc;
    this.mRootView = paramRelativeLayout;
    if (this.mRootView == null) {
      throw new RuntimeException("rootView must not null");
    }
    paramRelativeLayout = this.mRootView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramRelativeLayout, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLongPressTimeout(350);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setClickable(false);
    paramabuc = new RelativeLayout.LayoutParams(100, 100);
    this.jdField_b_of_type_Abiy = new abtw(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_b_of_type_Abiy);
    this.mRootView.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramabuc);
    this.sH = (acej.aV() / 16.0F);
    if (this.sH != 0.0F) {
      this.sG = (aqgz.getDesity() / this.sH);
    }
    if (this.sG == 0.0F) {
      this.sG = aqgz.getDesity();
    }
    this.xG = new ImageView(paramRelativeLayout);
    this.xG.setImageResource(2130839651);
    this.crK = ApolloUtil.dp2px(25.0F, this.sG);
    this.crL = ApolloUtil.dp2px(25.0F, this.sG);
    this.D = new RelativeLayout.LayoutParams(this.crK, this.crL);
    this.D.addRule(9, -1);
    this.D.addRule(10, -1);
    this.xG.setVisibility(8);
    this.mRootView.addView(this.xG, this.D);
    this.jdField_a_of_type_Abty = new abty();
    this.jr = new RelativeLayout(paramRelativeLayout);
    paramabuc = new ImageView(paramRelativeLayout);
    paramabuc.setImageResource(2130839651);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    this.jr.addView(paramabuc, localLayoutParams);
    this.mRootView.addView(this.jr, new RelativeLayout.LayoutParams(-1, -1));
    this.bp = new FrameLayout(paramRelativeLayout);
    this.PW = new TextView(paramRelativeLayout);
    this.PW.setTextColor(-8366104);
    this.PW.setTextSize(12.0F);
    this.PW.setGravity(17);
    this.PW.setSingleLine(false);
    paramRelativeLayout = new FrameLayout.LayoutParams(-1, -1);
    paramRelativeLayout.leftMargin = ApolloUtil.dp2px(15.0F, this.sG);
    paramRelativeLayout.rightMargin = ApolloUtil.dp2px(15.0F, this.sG);
    this.bp.addView(this.PW, paramRelativeLayout);
    this.bp.setBackgroundResource(2130838703);
    paramRelativeLayout = new RelativeLayout.LayoutParams(ApolloUtil.dp2px(81.0F, this.sG), ApolloUtil.dp2px(58.0F, this.sG));
    this.mRootView.addView(this.bp, paramRelativeLayout);
    this.bp.setVisibility(8);
    if (this.sH != 0.0F) {
      this.PW.setTextSize(12.0F / this.sH);
    }
    cFm();
  }
  
  private MediaPlayer b()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setOnPreparedListener(this);
    localMediaPlayer.setOnErrorListener(this);
    return localMediaPlayer;
  }
  
  private String b(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return iJ("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return iJ("no apolloId");
    }
    if (!abvg.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.a(this.mRootView.getContext(), acfp.m(2131702719), 0).show();
      return iJ("dresses is not download!");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam = paramApolloWebAvatarParam;
    this.mTab = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab;
    for (;;)
    {
      synchronized (this.iz)
      {
        this.iz.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
        this.bFx = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        if ((paramApolloWebAvatarParam.tapRectWidth > 0) && (paramApolloWebAvatarParam.tapRectHeight > 0))
        {
          float f1 = paramApolloWebAvatarParam.tapRectX * this.sG;
          float f2 = paramApolloWebAvatarParam.tapRectY * this.sG;
          ??? = new RectF(f1, f2, paramApolloWebAvatarParam.tapRectWidth * this.sG + f1, paramApolloWebAvatarParam.tapRectHeight * this.sG + f2);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTouchableRect((RectF)???);
          ??? = new RelativeLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.bringToFront();
          this.crO = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.type;
          this.bFt = paramBoolean;
          this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(23, 500L);
          if (Float.compare(0.0F, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate) == 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate = 0.2F;
          }
          this.sF = ApolloUtil.y(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate);
          this.sI = (this.sF * 330.0F / this.sG);
          ??? = (RelativeLayout.LayoutParams)this.bp.getLayoutParams();
          ((RelativeLayout.LayoutParams)???).addRule(10);
          ((RelativeLayout.LayoutParams)???).addRule(11);
          ((RelativeLayout.LayoutParams)???).width = ApolloUtil.dp2px(81.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F, this.sG);
          ((RelativeLayout.LayoutParams)???).height = ApolloUtil.dp2px(58.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F, this.sG);
          ((RelativeLayout.LayoutParams)???).topMargin = ((int)(paramApolloWebAvatarParam.y * this.sG - (float)aqgz.hL() * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate));
          ((RelativeLayout.LayoutParams)???).rightMargin = ((int)((float)aqgz.hK() - this.sG * paramApolloWebAvatarParam.x - ((RelativeLayout.LayoutParams)???).width - ApolloUtil.dp2px(68.0F, this.sG) * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F));
          this.PW.setTextSize(12.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F);
          cFo();
          this.crJ = 1;
          paramApolloWebAvatarParam = Message.obtain();
          paramApolloWebAvatarParam.getData().putInt("key_operation", 1);
          paramApolloWebAvatarParam.what = 18;
          this.jdField_a_of_type_Auru.sendMessage(paramApolloWebAvatarParam);
          b(false, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
          Eh(false);
          this.bhF = null;
          this.bFs = false;
          if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
          }
          return iK("initAvatar成功");
        }
      }
      ??? = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y * this.sG));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTouchableRect(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
    }
  }
  
  private void cFn()
  {
    int m = 0;
    if (this.bFu) {}
    int i;
    label136:
    int k;
    label155:
    label356:
    label361:
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) {
          if (this.cre == 0) {
            try
            {
              String str = ApolloUtil.dv(this.Sy);
              if (aqhq.fileExists(str))
              {
                if (this.mAudioManager == null) {
                  this.mAudioManager = ((AudioManager)this.mRootView.getContext().getSystemService("audio"));
                }
                if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
                  this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.mRootView.getContext().getSystemService("phone"));
                }
                if ((this.mAudioManager != null) && (this.mAudioManager.getRingerMode() == 1))
                {
                  i = 1;
                  if ((this.mAudioManager == null) || (this.mAudioManager.getStreamVolume(2) != 0)) {
                    break label356;
                  }
                  j = 1;
                  if ((this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() != 0)) {
                    break label361;
                  }
                  k = 1;
                  if ((i != 0) || (j != 0) || (k == 0) || (!abky.Yv())) {
                    continue;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloViewController", 2, "[playActionSound] " + this.Sy + " " + str);
                  }
                  try
                  {
                    aqge.m(BaseApplicationImpl.getContext(), true);
                    if (this.mPlayer == null) {
                      this.mPlayer = b();
                    }
                    this.mPlayer.reset();
                    this.mPlayer.setDataSource(str);
                    this.mPlayer.prepareAsync();
                    return;
                  }
                  catch (Throwable localThrowable1)
                  {
                    QLog.e("ApolloViewController", 1, localThrowable1.getMessage());
                    return;
                  }
                  if (this.cre <= 0) {
                    break;
                  }
                }
              }
            }
            catch (Throwable localThrowable2)
            {
              QLog.e("ApolloViewController", 1, localThrowable2, new Object[] { "[playActionSound] exception" });
            }
          } else {
            for (;;)
            {
              if (!new File(abto.di(this.cre)).exists()) {
                break label395;
              }
              this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(24, (int)(this.sC * 1000.0F));
              return;
              i = 0;
              break;
              j = 0;
              break label136;
              k = 0;
              break label155;
              QLog.e("ApolloViewController", 1, "[playActionSound] not found file for " + localThrowable2);
            }
          }
        }
      }
      if ((!TextUtils.isEmpty(abvh.a().bic)) && ("interactive".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab)))
      {
        this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(24, 0L);
        return;
      }
    } while (!this.bFv);
    label395:
    if (this.mPlayer == null) {
      this.mPlayer = b();
    }
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.mRootView.getContext().getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.mRootView.getContext().getSystemService("phone"));
    }
    if ((this.mAudioManager != null) && (this.mAudioManager.getRingerMode() == 1))
    {
      i = 1;
      label533:
      if ((this.mAudioManager == null) || (this.mAudioManager.getStreamVolume(2) != 0)) {
        break label692;
      }
    }
    label692:
    for (int j = 1;; j = 0)
    {
      k = m;
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        k = m;
        if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() == 0) {
          k = 1;
        }
      }
      if ((!abto.hV(this.Sy)) || (j != 0) || (i != 0) || (k == 0)) {
        break;
      }
      try
      {
        aqge.m(BaseApplicationImpl.getContext(), true);
        this.mPlayer.reset();
        this.mPlayer.setDataSource(abxi.bip + this.Sy + "/" + "music.amr");
        this.mPlayer.prepare();
        this.mPlayer.start();
        return;
      }
      catch (Throwable localThrowable3)
      {
        QLog.e("ApolloViewController", 1, localThrowable3.getMessage());
        return;
      }
      i = 0;
      break label533;
    }
  }
  
  private void cFo()
  {
    try
    {
      if ((this.mPlayer != null) && (this.mPlayer.isPlaying()))
      {
        aqge.m(BaseApplicationImpl.getContext(), false);
        this.mPlayer.stop();
      }
      if (this.jdField_a_of_type_Auru != null) {
        this.jdField_a_of_type_Auru.removeMessages(24);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloViewController", 1, localThrowable.getMessage());
    }
  }
  
  private void cFq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "[destoryAllAvatars]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      synchronized (this.iz)
      {
        Iterator localIterator = this.iz.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(str);
          }
        }
      }
      this.iz.clear();
      return;
    }
    QLog.e("ApolloViewController", 1, "[destoryAllAvatars] surfaceView null");
  }
  
  public static String iJ(String paramString)
  {
    return "{\"result\":1,\"msg\":\"" + paramString + "\"}";
  }
  
  public static String iK(String paramString)
  {
    return "{\"result\":0,\"msg\":\"" + paramString + "\"}";
  }
  
  public void Eh(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jr != null)
    {
      localRelativeLayout = this.jr;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void Ei(boolean paramBoolean)
  {
    cFo();
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.bhF)))
    {
      if (!paramBoolean) {
        break label79;
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.DI(false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().stopLoopDelayed(0L);
      }
      this.crJ = 1;
      this.jdField_a_of_type_Auru.obtainMessage(18).sendToTarget();
      return;
      label79:
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.cCw();
    }
  }
  
  public void If(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      if (paramInt <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().run();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().stopLoopDelayed(1000L);
      }
      this.bFx = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "setApolloViewVisibility visibility:", Integer.valueOf(paramInt) });
      }
      return;
      label95:
      this.bFx = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      cFo();
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.bhF))) {
        this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.DI(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().stopLoopDelayed(0L);
      }
    }
  }
  
  public void Ih(int paramInt)
  {
    this.jdField_a_of_type_Auru.removeMessages(23);
    this.mApolloStatus = paramInt;
    if (this.bFt)
    {
      this.jdField_a_of_type_Auru.removeMessages(16);
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(16, 3000L);
    }
    label218:
    label250:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
      {
        if ("mall".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab)) {
          if (this.mApolloStatus == 0)
          {
            this.bhE = acfp.m(2131702724);
            if (this.crO == 1) {
              this.bhE = abto.dh(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)) {
              this.bhE = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting;
            }
            if (TextUtils.isEmpty(this.bhE)) {
              break label218;
            }
            this.jdField_a_of_type_Auru.sendEmptyMessage(17);
          }
        }
        for (;;)
        {
          if (this.mApolloStatus != 1) {
            break label250;
          }
          this.jdField_a_of_type_Auru.removeMessages(16);
          this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(16, 3000L);
          return;
          if (this.mApolloStatus == 2)
          {
            this.bhE = acfp.m(2131702709);
            break;
          }
          this.bhE = null;
          break;
          this.bhE = null;
          break;
          if (Looper.myLooper() == Looper.getMainLooper()) {
            this.bp.setVisibility(8);
          } else {
            this.jdField_a_of_type_Auru.sendEmptyMessage(16);
          }
        }
      }
    }
  }
  
  public String a(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return iJ("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return iJ("no apolloId");
    }
    if (!ApolloEngine.BJ())
    {
      QLog.e("ApolloViewController", 1, "ApolloEngine is not ready");
      return iJ("ApolloEngine is not ready");
    }
    if (!abvg.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      QQToast.a(this.mRootView.getContext(), acfp.m(2131702706), 0).show();
      return iJ("dresses is not download!");
    }
    if ((!TextUtils.isEmpty(this.mTab)) && (!this.mTab.equals(paramApolloWebAvatarParam.tab)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onExecDispose(paramApolloWebAvatarParam.apolloId);
      }
      this.jdField_a_of_type_Auru.postDelayed(new ApolloViewController.2(this, paramInt, paramBoolean, paramApolloWebAvatarParam), 100L);
    }
    for (;;)
    {
      return iK("initAvatar成功");
      b(paramInt, paramBoolean, paramApolloWebAvatarParam);
    }
  }
  
  public String a(abtv.b paramb)
  {
    if (this.bFx)
    {
      QLog.e("ApolloViewController", 1, "previewAction 小人已隐藏");
      return iJ(acfp.m(2131702712));
    }
    if (paramb == null) {
      return iJ("actionData is null");
    }
    if (paramb.playCount > 1) {}
    for (this.jdField_a_of_type_Abtv$b = paramb; (paramb.actionType == 1) && (!TextUtils.isEmpty(paramb.apolloId)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramb.apolloId.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)); this.jdField_a_of_type_Abtv$b = null) {
      return iJ(acfp.m(2131702717));
    }
    if ((TextUtils.isEmpty(paramb.apolloId)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)) {
      paramb.apolloId = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId;
    }
    if (TextUtils.isEmpty(paramb.apolloId)) {
      return iJ("未传apolloId");
    }
    if (!this.iz.containsKey(paramb.apolloId)) {
      return iJ(acfp.m(2131702715));
    }
    Object localObject1 = (ApolloWebAvatarParam)this.iz.get(paramb.apolloId);
    if (localObject1 == null) {
      return iJ(acfp.m(2131702701));
    }
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
    {
      i = j;
      if (paramb.apolloId.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)) {
        i = 1;
      }
    }
    if ((i != 0) && (!abvg.a(((ApolloWebAvatarParam)localObject1).uin, ((ApolloWebAvatarParam)localObject1).roleId, ((ApolloWebAvatarParam)localObject1).dressIds, null)))
    {
      QQToast.a(this.mRootView.getContext(), acfp.m(2131702702), 0).show();
      return iJ(acfp.m(2131702713));
    }
    if (!ApolloUtil.aF(paramb.crP, paramb.actionType))
    {
      if (i != 0) {
        QQToast.a(this.mRootView.getContext(), acfp.m(2131702720), 0).show();
      }
      return iJ(acfp.m(2131702703));
    }
    if ((!this.mInited) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jq == null) || (this.mRootView == null))
    {
      if (i != 0) {
        QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131702718), 0).show();
      }
      return iJ(acfp.m(2131702708));
    }
    if (i != 0) {
      cFo();
    }
    this.cre = paramb.audioId;
    this.sC = paramb.audioStartTime;
    boolean bool;
    label556:
    label616:
    float f1;
    label837:
    label890:
    Object localObject2;
    int k;
    if (paramb.playOriginalAudio == 0)
    {
      bool = true;
      this.bFv = bool;
      this.bFu = paramb.bFz;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (paramb.apolloId.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
        this.Sy = paramb.crP;
      }
      this.bFq = true;
      this.bp.setVisibility(8);
      this.jdField_a_of_type_Auru.removeMessages(16);
      this.crM = paramb.crT;
      this.bhF = paramb.text;
      this.crN = paramb.textType;
      if (paramb.crU != 1) {
        break label1141;
      }
      bool = true;
      this.bFs = bool;
      if ((!paramb.bFz) && (this.jdField_a_of_type_Abty != null)) {
        this.jdField_a_of_type_Abty.cFr();
      }
      if ((!TextUtils.isEmpty(paramb.text)) && (!paramb.bFz)) {
        break label1147;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      }
      if (paramb.crQ != 0) {
        break label1518;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if (this.g != null)
      {
        this.g.onExecDispose();
        this.g.stopLoopDelayed(50L);
      }
      if (this.crJ != paramb.actionType)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        f1 = 0.0F;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) {
          f1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.sG - ((ApolloWebAvatarParam)localObject1).y;
        }
        if (paramb.actionType != 1) {
          break label1218;
        }
        if (ApolloUtil.ih(this.crM))
        {
          float f2 = this.sI / 2.0F;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, this.crM, this.sF, ((ApolloWebAvatarParam)localObject1).x - f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, abto.j(this.crM), null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.sF, ((ApolloWebAvatarParam)localObject1).x + f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
      }
      if (!paramb.bFz) {
        break label1277;
      }
      this.jdField_a_of_type_Abty.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramb.crP, ((ApolloWebAvatarParam)localObject1).roleId, paramb.actionType);
      this.jdField_a_of_type_Abty.y(paramb.sK);
      this.crJ = paramb.actionType;
      this.jq.setVisibility(8);
      if (TextUtils.isEmpty(paramb.text)) {
        break label1496;
      }
      if (paramb.textType != 1) {
        break label1453;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().u(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
      if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
      {
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
        k = (int)((float)aqgz.hL() * ((ApolloWebAvatarParam)localObject1).rate * 1.14F);
        if (this.mRootView == localObject2) {
          break label1384;
        }
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView(this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        }
        localObject2 = new RelativeLayout.LayoutParams(-1, k);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.sG - k));
        j = this.mRootView.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) - 1;
        i = j;
        if (j < 0) {
          i = 0;
        }
        this.mRootView.addView(this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView, i, (ViewGroup.LayoutParams)localObject2);
        label1086:
        if (!paramb.bFz) {
          abju.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), k, this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", paramb.text, true);
        }
      }
    }
    for (;;)
    {
      Eh(false);
      return iK(acfp.m(2131702716));
      bool = false;
      break;
      label1141:
      bool = false;
      break label556;
      label1147:
      if (paramb.textType == 1)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView == null)
        {
          this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(this.mRootView.getContext());
          this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setClickable(false);
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(0);
        break label616;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView == null) {
        break label616;
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      break label616;
      label1218:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.sF, ((ApolloWebAvatarParam)localObject1).x, f1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
      break label837;
      label1277:
      ApolloUtil.endTrace("ready resource");
      localObject2 = abvg.a(13, paramb.crP, ((ApolloWebAvatarParam)localObject1).roleId, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, paramb.crP, 0, localObject2[0], localObject2[1]);
      if (paramb.actionType != 1) {
        break label890;
      }
      localObject2 = abvg.a(13, paramb.crP, ((ApolloWebAvatarParam)localObject1).roleId, false);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, paramb.crP, 0, localObject2[0], localObject2[1]);
      break label890;
      label1384:
      if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getHeight() == k) {
        break label1086;
      }
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.sG - k));
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams().height = k;
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1086;
      label1453:
      abvh.a().aY.set(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, ((ApolloWebAvatarParam)localObject1).apolloId, 1, ((ApolloWebAvatarParam)localObject1).roleId, this.bhF, null);
      continue;
      label1496:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().u(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
    }
    label1518:
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramb.apolloId.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
      return iJ(acfp.m(2131702725));
    }
    cFm();
    if ((!this.bFr) || (this.g == null))
    {
      this.jq.setVisibility(0);
      this.g = new ApolloTextureView(this.mRootView.getContext(), null);
      localObject1 = new RelativeLayout.LayoutParams(-2, (int)(this.mRootView.getContext().getResources().getDisplayMetrics().heightPixels * 0.6F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtil.dp2px(25.0F, this.sG);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtil.dp2px(25.0F, this.sG);
      this.jq.addView(this.g, (ViewGroup.LayoutParams)localObject1);
      localObject1 = this.mRootView.getContext().getResources().getDisplayMetrics();
      this.g.init(new abtx(this, (DisplayMetrics)localObject1, paramb));
      if (this.c == null) {
        this.c = new abtv.a(this);
      }
      this.g.getRender().setRenderCallback(this.c);
      label1745:
      this.crJ = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(50L);
      this.jdField_a_of_type_Auru.removeMessages(15);
      localObject2 = this.mTitleView;
      if (!TextUtils.isEmpty(this.bhG)) {
        break label1995;
      }
      localObject1 = acfp.m(2131702721);
      label1800:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(this.bhH)) {
        break label2004;
      }
      this.PX.setVisibility(0);
      this.PX.setText(this.bhH);
      label1836:
      if ((paramb.feeType != 1) && (paramb.vipLevel > 0)) {
        break label2016;
      }
      this.ii.setVisibility(8);
      if (TextUtils.isEmpty(this.bhH)) {
        this.PX.setVisibility(8);
      }
      this.xH.setVisibility(8);
    }
    for (;;)
    {
      this.fD.setTag(Integer.valueOf(paramb.crP));
      this.ii.setTag(Integer.valueOf(paramb.crP));
      break;
      this.g.onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.jq.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Auru.obtainMessage(19, paramb.actionType, paramb.crP);
      if (paramb.bFz) {
        ((Message)localObject1).obj = Float.valueOf(paramb.sK);
      }
      this.jdField_a_of_type_Auru.sendMessageDelayed((Message)localObject1, 100L);
      break label1745;
      label1995:
      localObject1 = this.bhG;
      break label1800;
      label2004:
      this.PX.setVisibility(8);
      break label1836;
      label2016:
      bool = avqy.a().aLr();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "isSuperYellow:", Boolean.valueOf(bool) });
      }
      if (TextUtils.isEmpty(this.bhH)) {
        this.PX.setText(this.mRootView.getContext().getResources().getString(2131690342));
      }
      this.PX.setVisibility(0);
      this.xH.setVisibility(0);
      ApolloUtil.c(this.xH, paramb.vipLevel);
      if (!bool) {
        this.ii.setVisibility(0);
      } else {
        this.ii.setVisibility(8);
      }
    }
  }
  
  public void a(abja paramabja)
  {
    this.fP = new WeakReference(paramabja);
  }
  
  public void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    Ei(false);
    this.jdField_a_of_type_Auru.postDelayed(new ApolloViewController.3(this, paramActivity, paramAppInterface, paramString1, paramString2), 500L);
  }
  
  public ApolloTextureView b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public void b(int paramInt, int[] paramArrayOfInt)
  {
    this.mApolloStatus = 1;
    this.bhE = null;
    this.bp.setVisibility(8);
  }
  
  public void b(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.xG.setVisibility(0);
      this.D.leftMargin = ((int)(this.sG * paramFloat1) - (this.crK >> 1));
      this.D.topMargin = ((int)(this.sG * paramFloat2 * 0.75F));
      this.xG.setLayoutParams(this.D);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      }
      return;
    }
    this.xG.setVisibility(8);
  }
  
  public void cFm()
  {
    if (this.jq == null)
    {
      this.jq = new RelativeLayout(this.mRootView.getContext());
      this.jq.setClickable(true);
      this.jq.setBackgroundColor(this.mRootView.getContext().getResources().getColor(2131167202));
      this.jq.setVisibility(4);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, (int)((float)aqgz.hL() * 0.6F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtil.dp2px(25.0F, this.sG);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtil.dp2px(25.0F, this.sG);
      Object localObject2 = LayoutInflater.from(this.mRootView.getContext()).inflate(2131558736, null);
      this.fD = ((Button)((View)localObject2).findViewById(2131364138));
      this.ii = ((LinearLayout)((View)localObject2).findViewById(2131362823));
      this.ii.setOnClickListener(this);
      this.mTitleView = ((TextView)((View)localObject2).findViewById(2131362753));
      this.fD.setOnClickListener(this);
      this.PX = ((TextView)((View)localObject2).findViewById(2131362752));
      this.xH = ((ImageView)((View)localObject2).findViewById(2131362750));
      this.jq.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.mRootView.addView(this.jq, new RelativeLayout.LayoutParams(-1, -1));
      long l = Math.max(aqgz.hJ(), aqgz.hI());
      localObject1 = new ImageView(this.mRootView.getContext());
      ((ImageView)localObject1).setId(2131362781);
      localObject2 = new RelativeLayout.LayoutParams((int)(l / 16.68D + 0.5D), (int)(l / 16.68D + 0.5D));
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(l / 19.899999999999999D + 0.5D));
      ((ImageView)localObject1).setBackgroundResource(2130838543);
      ((ImageView)localObject1).setOnClickListener(this);
      this.jq.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void cFp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.bFx = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "hideAndDispose");
      }
    }
  }
  
  public String d(int[] paramArrayOfInt)
  {
    if (this.bFx)
    {
      QLog.e("ApolloViewController", 1, "preview 小人已隐藏");
      return iJ(acfp.m(2131702714));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null) {
      return iJ(acfp.m(2131702705));
    }
    if (!abvg.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.uin, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, paramArrayOfInt, null))
    {
      QQToast.a(this.mRootView.getContext(), acfp.m(2131702722), 0).show();
      return iJ(acfp.m(2131702711));
    }
    if ((this.mInited) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = paramArrayOfInt;
      if (this.bFq)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.sF, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.sG - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
      }
      if ((!TextUtils.isEmpty(this.bhF)) && (this.bFs)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().u(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, paramArrayOfInt, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
    }
    Eh(false);
    this.bFq = false;
    this.crJ = 0;
    this.bFs = false;
    this.bhF = null;
    if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
    }
    cFo();
    return iK(acfp.m(2131702710));
  }
  
  public void disableTouchEvent(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.disableTouchEvent(paramBoolean);
    }
  }
  
  public void du(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[destoryAvatar] apolloIdList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    synchronized (this.iz)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.iz.containsKey(str)))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(str);
          this.iz.remove(str);
        }
      }
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    int j;
    label189:
    int k;
    label209:
    label874:
    ApolloWebAvatarParam localApolloWebAvatarParam;
    label412:
    label418:
    label1187:
    label1244:
    float f2;
    label1995:
    float f4;
    float f3;
    switch (???.what)
    {
    case 20: 
    case 26: 
    default: 
    case 24: 
    case 22: 
    case 15: 
    case 16: 
    case 17: 
    case 23: 
    case 21: 
    case 18: 
    case 27: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              if (this.mPlayer == null) {
                this.mPlayer = b();
              }
              if (this.mAudioManager == null) {
                this.mAudioManager = ((AudioManager)this.mRootView.getContext().getSystemService("audio"));
              }
              if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
                this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.mRootView.getContext().getSystemService("phone"));
              }
              if ((this.mAudioManager != null) && (this.mAudioManager.getRingerMode() == 1))
              {
                i = 1;
                if ((this.mAudioManager == null) || (this.mAudioManager.getStreamVolume(2) != 0)) {
                  break label412;
                }
                j = 1;
                if ((this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() != 0)) {
                  break label418;
                }
                k = 1;
                if ((!new File(abto.di(this.cre)).exists()) || (j != 0) || (i != 0) || (k == 0)) {}
              }
              try
              {
                aqge.m(BaseApplicationImpl.getContext(), true);
                this.mPlayer.reset();
                this.mPlayer.setDataSource(abto.di(this.cre));
                this.mPlayer.prepare();
                this.mPlayer.start();
                if (!TextUtils.isEmpty(abvh.a().bic))
                {
                  ??? = abvh.a().bic;
                  if (???.startsWith("def"))
                  {
                    ??? = abxi.bio + "/" + ???;
                    abvh.a().bic = "";
                    ??? = ApolloUtil.b(???, "amr");
                    if (??? == null) {}
                  }
                }
              }
              catch (Throwable ???)
              {
                try
                {
                  for (;;)
                  {
                    aqge.m(BaseApplicationImpl.getContext(), true);
                    this.mPlayer.reset();
                    this.mPlayer.setDataSource(???.getPath());
                    this.mPlayer.prepare();
                    this.mPlayer.start();
                    return false;
                    i = 0;
                    break;
                    j = 0;
                    break label189;
                    k = 0;
                    break label209;
                    ??? = ???;
                    QLog.e("ApolloViewController", 1, ???.getMessage());
                  }
                  ??? = abxi.bim + "/" + ???;
                }
                catch (IOException ???)
                {
                  for (;;)
                  {
                    ???.printStackTrace();
                  }
                }
              }
            }
          } while ((!this.mSurfaceReady) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null));
          ??? = abvg.a(4, -1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, ???[0], ???[1]);
          return false;
          if (this.jq != null) {
            this.jq.setVisibility(8);
          }
          if (this.g != null) {
            this.g.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.DI(false);
          }
          this.jdField_a_of_type_Auru.sendEmptyMessage(18);
          return true;
          if (this.bp != null) {
            this.bp.setVisibility(8);
          }
          if (this.bFw)
          {
            if ((this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().u(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
            }
            this.bFw = false;
          }
          return true;
          if (this.bhE != null)
          {
            this.PW.setText(this.bhE);
            this.bp.setVisibility(0);
          }
          for (;;)
          {
            return true;
            this.bp.setVisibility(8);
          }
          Ih(this.mApolloStatus);
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0));
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloViewController", 2, "handleMessage MSG_CODE_REFRESH_APOLLO");
        }
        if ((this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.crJ != 0))
        {
          i = ???.getData().getInt("key_operation");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloViewController", 2, new Object[] { "handleMessage MSG_CODE_REFRESH_APOLLO, opFlag=", Integer.valueOf(i) });
          }
          if (i != 1) {
            break label1187;
          }
          cFq();
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose("friend");
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.sF, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.sG - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId != 0) {
              break label1244;
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, abto.jS, null);
          }
        }
        for (;;)
        {
          synchronized (this.iz)
          {
            this.iz.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
            if ((???.arg1 > 0) && (!TextUtils.isEmpty(this.bhF)) && (this.bFs) && (this.crN == 0))
            {
              this.bFw = false;
              abvh.a().aY.set(8);
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.bhF, null);
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
              this.crJ = 0;
              this.mInited = true;
              this.bFq = false;
              if (this.jdField_a_of_type_Abuc != null) {
                this.jdField_a_of_type_Abuc.b(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
              }
              Eh(false);
              if ((!this.mSurfaceReady) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0)) {
                break;
              }
              this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(21, 100L);
              return false;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)) {
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId);
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose("friend");
                break label874;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId <= 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds == null)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
            }
          }
          if ((this.bFt) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)))
          {
            abvh.a().aY.set(8);
            this.bFw = true;
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting, null);
          }
          else
          {
            this.bFw = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloViewController", 2, "handleMessage MSG_ADD_APOLLO");
        }
      } while ((!this.mSurfaceReady) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null));
      ??? = (ArrayList)???.getData().getSerializable("key_add_avatar_list");
      if ((??? != null) && (((ArrayList)???).size() > 0))
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
        if (??? != null)
        {
          ??? = ((ArrayList)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)???).next();
            if (localApolloWebAvatarParam != null) {
              for (;;)
              {
                synchronized (this.iz)
                {
                  for (;;)
                  {
                    if (this.iz.containsKey(localApolloWebAvatarParam.apolloId))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloViewController", 2, new Object[] { "handleMessage MSG_ADD_APOLLO, ", localApolloWebAvatarParam.apolloId, " is showing, destroy" });
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
                        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(localApolloWebAvatarParam.apolloId);
                      }
                      this.iz.remove(localApolloWebAvatarParam.apolloId);
                    }
                    ???.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtil.y(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.sG - localApolloWebAvatarParam.y);
                    if (localApolloWebAvatarParam.roleId == 0)
                    {
                      ???.a(1, localApolloWebAvatarParam.apolloId, abto.jS, null);
                      synchronized (this.iz)
                      {
                        this.iz.put(localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam);
                      }
                    }
                  }
                }
                if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
                  ???.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
        }
      }
      for (;;)
      {
        return false;
        QLog.e("ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, renderInterface null");
        continue;
        QLog.e("ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, avatar list null");
      }
    case 28: 
      ??? = (String)???.obj;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "[handleMessage] MSG_RESET_APOLLO, apolloId=", ??? });
      }
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        if ((this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)) {
          synchronized (this.iz)
          {
            if (this.iz.containsKey(???))
            {
              localApolloWebAvatarParam = (ApolloWebAvatarParam)this.iz.get(???);
              if (localApolloWebAvatarParam != null)
              {
                ??? = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
                if (??? != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose((String)???);
                  ((abii)???).a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtil.y(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.sG - localApolloWebAvatarParam.y);
                  if (localApolloWebAvatarParam.roleId != 0) {
                    break label1995;
                  }
                  ((abii)???).a(1, localApolloWebAvatarParam.apolloId, abto.jS, null);
                }
              }
            }
            while ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null))
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
              return false;
            }
            ((abii)???).a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
          }
        }
        QLog.e("ApolloViewController", 1, new Object[] { "[handleMessage] MSG_RESET_APOLLO, surface not ready, mSurfaceReady=", Boolean.valueOf(this.mSurfaceReady), ", mSurfaceView=", this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView });
        return false;
      }
      QLog.e("ApolloViewController", 1, "[handleMessage] MSG_RESET_APOLLO, apolloId null");
      return false;
    case 19: 
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.g == null) || (this.ii == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null)) {
        return true;
      }
      j = ???.arg1;
      k = ???.arg2;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      this.g.setVisibility(0);
      if (this.ii.getVisibility() == 0)
      {
        f2 = 77.0F;
        f4 = (float)(Math.max(aqgz.hJ(), aqgz.hI()) / 7L) / 368.0F;
        ??? = ???.obj;
        if ((??? == null) || (!(??? instanceof Float))) {
          break label2858;
        }
        f3 = ((Float)???).floatValue();
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      float f1;
      if ((j == 1) && (ApolloUtil.ih(this.crM)))
      {
        f1 = 330.0F * f4 / aqgz.density / 2.0F;
        this.g.getRenderImpl().a(2, null, this.crM, f4, this.sJ - f1, f2);
        this.g.getRenderImpl().a(2, null, abto.j(this.crM), null);
        ??? = abvg.a(13, k, this.crM, false);
        if (i != 0)
        {
          this.jdField_a_of_type_Abty.a(this.g, k, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, j);
          this.jdField_a_of_type_Abty.y(f3);
        }
      }
      for (;;)
      {
        label2339:
        this.g.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, f4, f1 + this.sJ, f2);
        this.g.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
        ??? = abvg.a(13, k, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
        this.g.stopLoopDelayed(1000L);
        if (i != 0)
        {
          this.jdField_a_of_type_Abty.a(this.g, k, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, j);
          this.jdField_a_of_type_Abty.y(f3);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.bhF))
          {
            if (this.crN == 1)
            {
              this.g.getRenderImpl().u(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
              if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView == null) {
                break label2851;
              }
              i = (int)((float)(aqgz.hL() / 7L) * 1.14F);
              ??? = this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
              if (this.jq != ???)
              {
                if (??? != null) {
                  ((ViewGroup)???).removeView(this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView);
                }
                ??? = new RelativeLayout.LayoutParams(-1, i);
                ???.addRule(12, -1);
                ???.leftMargin = ApolloUtil.dp2px(25.0F, this.sG);
                ???.rightMargin = ApolloUtil.dp2px(25.0F, this.sG);
                ???.bottomMargin = (wja.dp2px(f2, this.mRootView.getContext().getResources()) + (this.jq.getHeight() - this.g.getHeight()) / 2);
                this.jq.addView(this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView, 1, ???);
              }
              abju.a(this.jq.getWidth(), i, this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", this.bhF, true);
              return true;
              f2 = 42.0F;
              break;
              this.g.getRenderImpl().a(2, null, k, 0, ???[0], ???[1]);
              break label2339;
              this.g.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, k, 0, ???[0], ???[1]);
              continue;
            }
            abvh.a().aY.set(0);
            this.g.getRenderImpl().b(0, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.bhF, null);
            return true;
          }
        }
        this.g.getRenderImpl().u(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
        return true;
        if ((this.jdField_a_of_type_Abtv$b == null) || (this.jdField_a_of_type_Abtv$b.playCount <= 0)) {
          break;
        }
        ??? = this.jdField_a_of_type_Abtv$b;
        ???.playCount -= 1;
        a(this.jdField_a_of_type_Abtv$b);
        return false;
        label2851:
        return true;
        f1 = 0.0F;
      }
      label2858:
      f3 = 0.0F;
    }
  }
  
  public boolean isSurfaceReady()
  {
    return (this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362781)
    {
      this.jdField_a_of_type_Auru.sendEmptyMessage(15);
      cFo();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.ii) || (paramView == this.fD))
      {
        cFo();
        if ((this.jdField_a_of_type_Abuc != null) && ((paramView.getTag() instanceof Integer))) {
          this.jdField_a_of_type_Abuc.Ic(((Integer)paramView.getTag()).intValue());
        }
        this.jdField_a_of_type_Auru.sendEmptyMessage(15);
      }
    }
  }
  
  public void onDestroy()
  {
    ViewParent localViewParent;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localViewParent = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onDestroy();
    }
    if (this.g != null)
    {
      localViewParent = this.g.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.g);
      }
      this.g.getRenderImpl().onDestroy();
    }
    this.jdField_a_of_type_Auru.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.destroy();
    }
    cFq();
    cFo();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout.close(true);
    }
    if (this.mPlayer != null)
    {
      this.mPlayer.release();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "[onDestroy] release player");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "onDestroy");
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("ApolloViewController", 1, "[onError] " + paramInt1 + paramInt2);
    return false;
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if ((this.fP != null) && (this.fP.get() != null)) {
      ((abja)this.fP.get()).onNotifyLongTouch(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if ((this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.fP != null) && (this.fP.get() != null)) {
      ((abja)this.fP.get()).onNotifyStatusChanged(paramInt, paramString);
    }
  }
  
  public void onPause()
  {
    if (this.mPlayer != null)
    {
      aqge.m(BaseApplicationImpl.getContext(), false);
      this.mPlayer.stop();
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.mPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "[onPrepared] start play");
      }
      this.mPlayer.start();
    }
  }
  
  @TargetApi(14)
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if ((this.bp != null) && (this.bp.getVisibility() == 0))
      {
        this.bp.setTranslationX(-paramInt1);
        this.bp.setTranslationY(-paramInt2);
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.getVisibility() == 0))
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationX(-paramInt1);
        this.jdField_b_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationY(-paramInt2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationX(-paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationY(-paramInt2);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.mSurfaceReady = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "Avatar view is Ready.");
    }
    this.jdField_a_of_type_Auru.sendEmptyMessage(18);
    if ((this.fP != null) && (this.fP.get() != null)) {
      ((abja)this.fP.get()).onSurfaceReady(paramInt1, paramInt2);
    }
  }
  
  public String p(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[addAvatar] avatarParams=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return iJ("no params");
    }
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)localObject).next();
      if (!abvg.a(localApolloWebAvatarParam.uin, localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, null))
      {
        QQToast.a(this.mRootView.getContext(), acfp.m(2131702704), 0).show();
        return iJ("dresses is not download!");
      }
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 27;
    ((Message)localObject).getData().putSerializable("key_add_avatar_list", paramArrayList);
    this.jdField_a_of_type_Auru.sendMessage((Message)localObject);
    return iK("updateAvatar成功");
  }
  
  public String rl()
  {
    this.cre = 0;
    if ((this.mSurfaceReady) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null))
    {
      this.Sy = 5;
      String[] arrayOfString = abvg.a(10, -1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
      if ((arrayOfString.length > 0) && (!TextUtils.isEmpty(arrayOfString[0])) && (arrayOfString[0].length() - "action".length() > 0)) {}
      abvh.a().bic = arrayOfString[0].substring(0, arrayOfString[0].length() - "action".length());
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, arrayOfString[0], arrayOfString[1]);
      return iK("sayHi Ok");
    }
    this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(22, 100L);
    return iJ(acfp.m(2131702707));
  }
  
  public int zS()
  {
    return this.Sy;
  }
  
  static class a
    implements abiy
  {
    private WeakReference<abtv> activityRef;
    
    public a(abtv paramabtv)
    {
      this.activityRef = new WeakReference(paramabtv);
    }
    
    public void B(int paramInt1, int paramInt2, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onCompleteRender, roleName=", paramString });
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return;
        if (this.activityRef != null)
        {
          abtv localabtv = (abtv)this.activityRef.get();
          ApolloWebAvatarParam localApolloWebAvatarParam;
          if (localabtv != null)
          {
            localApolloWebAvatarParam = abtv.a(localabtv);
            if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localabtv.g != null))
            {
              abtv.b(localabtv);
              abtv.a(localabtv).removeMessages(24);
              localabtv.g.stopLoopDelayed(1000L);
              if (!TextUtils.isEmpty(abtv.a(localabtv)))
              {
                if (!abtv.a(localabtv)) {
                  break label173;
                }
                if ((abtv.a(localabtv) == 1) && (localabtv.b != null)) {
                  localabtv.b.cCw();
                }
              }
            }
          }
          while ((localabtv != null) && (localabtv.g != null))
          {
            return;
            label173:
            if (abtv.a(localabtv) == 1)
            {
              if (localabtv.b != null) {
                localabtv.b.DI(true);
              }
            }
            else {
              localabtv.g.getRenderImpl().u(1, localApolloWebAvatarParam.apolloId, "Bubble");
            }
          }
        }
      }
    }
    
    public void bH(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onStartRender, roleName=", paramString });
      }
      if (TextUtils.isEmpty(paramString)) {}
      abtv localabtv;
      ApolloWebAvatarParam localApolloWebAvatarParam;
      do
      {
        do
        {
          do
          {
            return;
          } while (this.activityRef == null);
          localabtv = (abtv)this.activityRef.get();
        } while (localabtv == null);
        localApolloWebAvatarParam = abtv.a(localabtv);
      } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
      abtv.a(localabtv);
    }
  }
  
  public static class b
  {
    public int actionType;
    public String apolloId;
    public int audioId;
    public float audioStartTime;
    public boolean bFA;
    public boolean bFz;
    public int crP;
    public int crQ;
    public int crR;
    public int crS;
    public int crT;
    public int crU;
    public int feeType;
    public int playCount;
    public int playOriginalAudio;
    public float sK;
    public String subTitle;
    public String text;
    public int textType;
    public String title;
    public int vipLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtv
 * JD-Core Version:    0.7.0.1
 */