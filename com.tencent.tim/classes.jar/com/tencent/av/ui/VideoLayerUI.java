package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofk;
import aofk.a;
import aqmj;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.widget.RotateLayout;
import com.tencent.av.widget.RotateLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import ijn;
import ild;
import ilf;
import ily;
import imy;
import ioa;
import ipl;
import ipl.a;
import ipm;
import iql;
import iqs;
import iqt;
import iqt.a;
import iqw;
import iqz;
import ira;
import irc;
import irn;
import ivv;
import iwu;
import iya;
import iya.f;
import izm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import jdl;
import jdt;
import jef;
import jfe;
import jff;
import jfg;
import jfh;
import jfi;
import jfj;
import jfm;
import jgg;
import jhj;
import jjb;
import jjk.c;
import jkm;
import jll;
import mqq.os.MqqHandler;
import wja;

public class VideoLayerUI
  extends VideoLayerUIBase
{
  boolean YA = false;
  private boolean YB;
  private volatile boolean Yu;
  private final boolean Yv = true;
  private boolean Yw = true;
  private boolean Yx = true;
  private boolean Yy;
  private boolean Yz;
  AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  protected MultiVideoOpenAnimation a;
  private d jdField_a_of_type_ComTencentAvUiVideoLayerUI$d;
  private RotateLayout jdField_a_of_type_ComTencentAvWidgetRotateLayout;
  private ipl jdField_a_of_type_Ipl;
  private iqw jdField_a_of_type_Iqw;
  private iqz jdField_a_of_type_Iqz;
  private irn jdField_a_of_type_Irn;
  private jef jdField_a_of_type_Jef = new jef(this.mContext, paramVideoAppInterface, this);
  private jfm jdField_a_of_type_Jfm = new jfm(this.jdField_a_of_type_ComTencentAvVideoController, this);
  jhj jdField_a_of_type_Jhj;
  private ConcurrentHashMap<Long, jfj> aN = new ConcurrentHashMap();
  private Rect am = new Rect();
  private Rect an = new Rect();
  private int axT = -1;
  private int axU = -1;
  public int axV;
  public int axW = 144;
  public int axX = 144;
  public int axY = 4;
  private int axZ;
  private int aya;
  private int ayb;
  private int ayc;
  private int ayd;
  private int aye = -1;
  private final int ayf = MultiVideoCtrlLayerUIBase.auk;
  int ayg = 0;
  private int ayh = -1;
  private int ayi = -1;
  private int ayj;
  private int ayk;
  private int ayl;
  private GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  private iqt.a jdField_b_of_type_Iqt$a;
  private Runnable cf = new NewMsgRunnable(null);
  private Runnable cg = new LastMsgRunnable(null);
  private LinearLayout di;
  private List<RecvMsg> fC = new LinkedList();
  private DisplayMetrics h = new DisplayMetrics();
  private ArrayList<iqt> iT = new ArrayList();
  private volatile int mContentLength = -1;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  public GestureDetector mGestureDetector;
  private TextView mMsgTextView;
  private TextView mNameTextView;
  private ScaleGestureDetector mScaleGestureDetector;
  private long oZ = -1L;
  private long pa;
  long pb = 0L;
  
  public VideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_a_of_type_Jdl = jdl.a(this.mContext, this.mApp, 1, false);
    initLogo();
    arx();
    avq();
    avr();
    ary();
    art();
    avp();
    avx();
    avs();
    avw();
    QLog.w(this.TAG, 1, "VideoLayerUI");
  }
  
  private void M(int paramInt, boolean paramBoolean)
  {
    if ((this.ayd == paramInt) && (!paramBoolean)) {
      return;
    }
    this.ayd = paramInt;
    avA();
  }
  
  private void N(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt == this.axZ)) {
      return;
    }
    this.axZ = paramInt;
    paramInt = mo();
    if ((this.axZ > paramInt) && (this.jdField_a_of_type_Iqz.isFinished()))
    {
      this.jdField_a_of_type_Iqz.setPosition(this.axZ);
      this.axZ = paramInt;
    }
    M(this.axZ, paramBoolean);
    ni(this.axZ);
  }
  
  private boolean P(int paramInt1, int paramInt2)
  {
    if ((this.pa != 0L) && (System.currentTimeMillis() - this.pa < 1000L))
    {
      QLog.w(this.TAG, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.pa + "]");
      return false;
    }
    izm localizm = this.jdField_a_of_type_ArrayOfIzm[paramInt2];
    localizm.f(Boolean.valueOf(false));
    localizm.setPaddings(0, 0, 0, 0);
    int i = localizm.getZOrder();
    localizm.setZOrder(1);
    float f1 = localizm.getBounds().left;
    float f2 = localizm.getBounds().top;
    Rect localRect = super.getPaddings();
    ira localira = new ira();
    localira.setDuration(100);
    localira.b(f1, f2, 0.0F, -localRect.left, -localRect.top, 0.0F);
    localira.setScale(localizm.getBounds().width(), localizm.getBounds().height(), super.getWidth() + localRect.left + localRect.right, super.getHeight() + localRect.top + localRect.bottom);
    localira.a(new jfh(this, paramInt2, i, paramInt1));
    localira.setSpeedType(2);
    localizm.a(localira);
    localizm.invalidate();
    this.pa = System.currentTimeMillis();
    return true;
  }
  
  private boolean Q(int paramInt1, int paramInt2)
  {
    if ((this.pa != 0L) && (System.currentTimeMillis() - this.pa < 1000L))
    {
      QLog.w(this.TAG, 1, "bigWindowToSmallWindowAnim, 大小窗正在切换中[" + this.pa + "]");
      return false;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfIzm[paramInt1];
    izm localizm = this.jdField_a_of_type_ArrayOfIzm[paramInt2];
    ((izm)localObject).f(Boolean.valueOf(false));
    ((izm)localObject).setPaddings(0, 0, 0, 0);
    localizm.f(Boolean.valueOf(false));
    localizm.setPaddings(0, 0, 0, 0);
    int i = localizm.getZOrder();
    localizm.setZOrder(((izm)localObject).getZOrder());
    Rect localRect = localizm.getBounds();
    localObject = ((izm)localObject).getBounds();
    ira localira = new ira();
    localira.setDuration(300);
    localira.b(localRect.left, localRect.top, 0.0F, ((Rect)localObject).left, ((Rect)localObject).top, 0.0F);
    localira.setScale(localRect.width(), localRect.height(), ((Rect)localObject).width(), ((Rect)localObject).height());
    localira.a(new jfi(this, paramInt2, i, paramInt1));
    localira.setSpeedType(2);
    localizm.a(localira);
    localizm.invalidate();
    this.pa = System.currentTimeMillis();
    return true;
  }
  
  private boolean R(int paramInt1, int paramInt2)
  {
    if ((this.pa != 0L) && (System.currentTimeMillis() - this.pa < 1000L))
    {
      QLog.w(this.TAG, 1, "sliderWindowBigToSmallAnimation, 大小窗正在切换中[" + this.pa + "]");
      return false;
    }
    izm localizm = this.jdField_a_of_type_ArrayOfIzm[paramInt2];
    localizm.f(Boolean.valueOf(false));
    localizm.setPaddings(0, 0, 0, 0);
    queueEvent(new VideoLayerUI.9(this, paramInt1, paramInt2));
    invalidate();
    this.pa = System.currentTimeMillis();
    return true;
  }
  
  private void T(long paramLong, int paramInt)
  {
    int i = c("refreshMicState", String.valueOf(paramLong), 1);
    if (i != -1) {
      this.jdField_a_of_type_ArrayOfIzm[i].ms(paramInt);
    }
  }
  
  public static int a(String paramString, Context paramContext, int paramInt, boolean paramBoolean, Display paramDisplay)
  {
    if (paramBoolean)
    {
      int i = paramDisplay.getRotation();
      int j = (i * 90 + paramInt) % 360;
      CameraUtils.a(paramContext).setSupportLandscape(true);
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "setRotation, rotation[" + paramInt + "], displayRotation[" + i + "], viewRotation[" + j + "]");
      }
      return j;
    }
    CameraUtils.a(paramContext).setSupportLandscape(false);
    return paramInt;
  }
  
  private Bitmap a(jfj paramjfj)
  {
    if (paramjfj.accountType == 0) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramjfj.uin), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), this.jdField_a_of_type_ComTencentAvVideoController.b().relationType, true, false);
    }
    return ((BitmapDrawable)this.mContext.getResources().getDrawable(2130842980)).getBitmap();
  }
  
  private String a(jfj paramjfj)
  {
    if (paramjfj.accountType == 0)
    {
      paramjfj = this.jdField_a_of_type_ComTencentAvVideoController.d(String.valueOf(paramjfj.uin), String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), this.jdField_a_of_type_ComTencentAvVideoController.b().relationType);
      return paramjfj;
    }
    long l = paramjfj.uin;
    if (paramjfj.b != null) {}
    for (AVPhoneUserInfo localAVPhoneUserInfo = paramjfj.b;; localAVPhoneUserInfo = this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.b().ii))
    {
      if ((localAVPhoneUserInfo == null) || (localAVPhoneUserInfo.telInfo.mobile == null)) {
        break label154;
      }
      paramjfj.name = localAVPhoneUserInfo.telInfo.mobile;
      String str = this.jdField_a_of_type_ComTencentAvVideoController.dd(localAVPhoneUserInfo.telInfo.mobile);
      paramjfj = str;
      if (str != null) {
        break;
      }
      return jkm.v(localAVPhoneUserInfo.telInfo.mobile, 4);
    }
    label154:
    if ((localAVPhoneUserInfo != null) && (QLog.isColorLevel())) {
      QLog.d(this.TAG, 2, "getMemmberName --> can not get Open Id. PhoneInfo = " + localAVPhoneUserInfo.toString());
    }
    return this.mContext.getResources().getString(2131694561);
  }
  
  private jfj a(long paramLong)
  {
    jfj localjfj2 = (jfj)this.aN.get(Long.valueOf(paramLong));
    jfj localjfj1 = localjfj2;
    if (localjfj2 == null)
    {
      localjfj1 = new jfj();
      localjfj1.uin = paramLong;
      this.aN.put(Long.valueOf(paramLong), localjfj1);
    }
    return localjfj1;
  }
  
  private void a(long paramLong, izm paramizm, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramizm != null)
    {
      u(paramString, paramInt);
      paramizm.an(paramString, paramInt);
      paramizm.setVisibility(0);
      paramizm.kc(this.mApp.getCurrentAccountUin());
    }
  }
  
  private void a(ipm paramipm, iqt paramiqt, boolean paramBoolean)
  {
    int k = 1;
    int i;
    if ((paramiqt.canRender()) || (paramiqt.vg()))
    {
      i = 1;
      if ((paramiqt.getBounds().left - this.axZ <= this.h.widthPixels) && (paramiqt.getBounds().right - this.axZ >= 0)) {
        break label90;
      }
      j = 1;
      label60:
      if ((j == 0) || (paramBoolean)) {
        break label96;
      }
    }
    label90:
    label96:
    for (int j = k;; j = 0)
    {
      if ((i != 0) && (j == 0)) {
        break label102;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label60;
    }
    label102:
    paramipm.translate(0, 0);
    paramiqt.d(paramipm);
    paramipm.translate(-0, -0);
  }
  
  private void a(izm paramizm, float paramFloat, long paramLong)
  {
    paramLong /= 10L;
    post(new VideoLayerUI.10(this, paramLong, paramizm, (float)Math.pow(paramFloat, 1.0D / paramLong)));
  }
  
  private void a(izm paramizm, boolean paramBoolean)
  {
    ira localira = new ira();
    localira.setDuration(50);
    localira.c(0.0F, 0.0F, 0.0F, 90.0F, 0.0F, 0.0F);
    localira.a(new jfe(this, paramizm, paramBoolean));
    localira.setSpeedType(1);
    paramizm.a(localira);
    paramizm.invalidate();
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramCharSequence instanceof aofk))
    {
      paramCharSequence = (aofk.a[])((aofk)paramCharSequence).getSpans(0, paramCharSequence.length(), aofk.a.class);
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramCharSequence.length)
      {
        if (paramCharSequence[i].emojiType == 2) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void art()
  {
    int j = 2130842802;
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1008) {
        i = 2130842961;
      }
    }
    this.jdField_a_of_type_ArrayOfIzm[0].setBackground(jll.b(this.mContext, i));
    super.setBackground(jll.b(this.mContext, i));
  }
  
  private void as(String paramString, int paramInt)
  {
    QLog.w(this.TAG, 1, "closeVideoView[" + paramString + "], index[" + paramInt + "]");
    paramString = ImageView.ScaleType.CENTER_INSIDE;
    int n = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    int j;
    float f;
    int i;
    boolean bool;
    if (paramInt == 0)
    {
      j = this.jdField_a_of_type_ArrayOfIzm[0].getTextColor();
      f = this.jdField_a_of_type_ArrayOfIzm[0].getTextSize();
      i = this.jdField_a_of_type_ArrayOfIzm[0].getMaxLength();
      bool = this.jdField_a_of_type_ArrayOfIzm[0].wh();
      if (n == 4) {
        paramString = this.jdField_a_of_type_ArrayOfIzm[0].getScaleType();
      }
    }
    for (;;)
    {
      int k;
      int m;
      if ((n == 4) && (this.jdField_a_of_type_Jdl.getStyle() == 3))
      {
        k = 1;
        if (Build.VERSION.SDK_INT < 21) {
          break label214;
        }
        m = 1;
      }
      label154:
      label214:
      int i1;
      izm localizm;
      for (;;)
      {
        if ((k != 0) && (m != 0))
        {
          k = -1;
          m = paramInt + 1;
          for (;;)
          {
            if (m < this.jdField_a_of_type_ArrayOfIzm.length)
            {
              if (this.jdField_a_of_type_ArrayOfIzm[m].getVisibility() == 0) {
                k = m;
              }
              m += 1;
              continue;
              k = 0;
              break;
              m = 0;
              break label154;
            }
          }
          if (k != -1)
          {
            m = this.jdField_a_of_type_ArrayOfIzm[paramInt].getZOrder();
            i1 = this.jdField_a_of_type_ArrayOfIzm[k].getZOrder();
            this.jdField_a_of_type_ArrayOfIzm[paramInt].setZOrder(i1);
            this.jdField_a_of_type_ArrayOfIzm[k].setZOrder(m);
            localizm = this.jdField_a_of_type_ArrayOfIzm[paramInt];
            this.jdField_a_of_type_ArrayOfIzm[paramInt] = this.jdField_a_of_type_ArrayOfIzm[k];
            this.jdField_a_of_type_ArrayOfIzm[k] = localizm;
            localizm.kc("");
            localizm = this.jdField_a_of_type_ArrayOfIzm[k];
            localizm.setVisibility(1);
            localizm.setText(null);
            localizm.jO(true);
            localizm.enableLoading(false);
            localizm.jK(false);
            localizm.flush(true);
            localizm.an(null, 0);
            label362:
            if (paramInt == 0)
            {
              this.jdField_a_of_type_ArrayOfIzm[0].jL(false);
              this.jdField_a_of_type_ArrayOfIzm[0].setTextColor(j);
              this.jdField_a_of_type_ArrayOfIzm[0].setTextSize(f);
              this.jdField_a_of_type_ArrayOfIzm[0].setMaxLength(i);
              this.jdField_a_of_type_ArrayOfIzm[0].jN(bool);
              if (n == 4)
              {
                if (this.jdField_a_of_type_ArrayOfIzm[0].getVideoSrcType() != 2) {
                  break label662;
                }
                this.jdField_a_of_type_ArrayOfIzm[0].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
              }
            }
          }
        }
      }
      for (;;)
      {
        jj(false);
        return;
        k = paramInt;
        break;
        k = paramInt;
        while (k < this.jdField_a_of_type_ArrayOfIzm.length)
        {
          if ((k >= this.jdField_a_of_type_ArrayOfIzm.length - 1) || (this.jdField_a_of_type_ArrayOfIzm[(k + 1)].getVisibility() != 0)) {
            break label599;
          }
          m = this.jdField_a_of_type_ArrayOfIzm[k].getZOrder();
          i1 = this.jdField_a_of_type_ArrayOfIzm[(k + 1)].getZOrder();
          this.jdField_a_of_type_ArrayOfIzm[k].setZOrder(i1);
          this.jdField_a_of_type_ArrayOfIzm[(k + 1)].setZOrder(m);
          localizm = this.jdField_a_of_type_ArrayOfIzm[k];
          this.jdField_a_of_type_ArrayOfIzm[k] = this.jdField_a_of_type_ArrayOfIzm[(k + 1)];
          this.jdField_a_of_type_ArrayOfIzm[(k + 1)] = localizm;
          k += 1;
        }
        break label362;
        label599:
        localizm = this.jdField_a_of_type_ArrayOfIzm[k];
        localizm.setVisibility(1);
        localizm.setText(null);
        localizm.jO(true);
        localizm.enableLoading(false);
        localizm.jK(false);
        localizm.flush(true);
        localizm.an(null, 0);
        localizm.kc("");
        break label362;
        label662:
        this.jdField_a_of_type_ArrayOfIzm[0].setScaleType(paramString);
      }
      continue;
      f = 0.0F;
      j = 0;
      i = 0;
      bool = false;
    }
  }
  
  private void avA()
  {
    int j = this.ayd;
    int i = Math.max(0, j / (this.axW + this.axY));
    int k = this.axW;
    int m = this.axY;
    j = (int)Math.ceil((mm() - ((i + 1) * (k + m) - j)) * 1.0F / (this.axW + this.axY));
    bZ(i, Math.min(mn() - 1, j + i));
  }
  
  private void avq()
  {
    this.h = new DisplayMetrics();
    ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getRealMetrics(this.h);
    this.axY = this.mContext.getResources().getDimensionPixelSize(2131298309);
    this.axW = ((this.h.widthPixels - this.axY * 5) / 4);
    this.axX = this.axW;
    int i = this.h.heightPixels;
    i = this.axW;
    i = this.mContext.getResources().getDimensionPixelSize(2131299734);
    this.am = new Rect(0, this.h.heightPixels - i - this.axX, this.h.widthPixels, this.h.heightPixels - i);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(this.mContext, new e(null));
    this.jdField_a_of_type_Iqz = new iqz(this.mContext);
    this.jdField_a_of_type_Iqz.iJ(true);
    this.jdField_a_of_type_Iqz.lt((int)jll.dp2px(this.mContext, 50.0F));
    this.e = new izm(this.mContext, this.mApp, String.format("%s_%s", new Object[] { this.TAG, Integer.valueOf(1000) }), this.jdField_a_of_type_ComTencentAvVideoController.getOnPeerFrameRenderEndFunctionPtr());
    this.e.setVisibility(1);
    this.e.kc(this.mApp.getCurrentAccountUin());
    this.e.an("null", 1);
    this.e.iH(true);
    this.e.jI(false);
    this.e.jL(false);
    this.e.jM(true);
    i = wja.dp2px(16.0F, this.mContext.getResources());
    this.e.setTextSize(i);
    this.e.jN(true);
    this.e.setBackgroundColor(Color.parseColor("#686E6C"));
    this.e.setTag(2, Boolean.valueOf(false));
    this.e.setZOrder(999);
    a(this.e);
  }
  
  private void avr()
  {
    this.mPosition = aqmj.j(this.mContext).getInt("video_position", 3);
  }
  
  private void avs()
  {
    this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, new f());
    this.mGestureDetector = new GestureDetector(this.mContext, new a());
    this.jdField_a_of_type_Ipl = new ipl(this.mContext, new b(null));
    this.jdField_b_of_type_Iqt$a = new g();
    a(this.jdField_b_of_type_Iqt$a);
    this.ayg = wja.dp2px(20.0F, this.mContext.getResources());
  }
  
  private void avt()
  {
    synchronized (this.mEventQueue)
    {
      this.mEventQueue.clear();
      this.axZ = 0;
      this.aya = 0;
      this.Yw = true;
      return;
    }
  }
  
  private void avu()
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = ((RotateLayout)this.mRootView.findViewById(2131363148));
      this.di = ((LinearLayout)this.mRootView.findViewById(2131363155));
      this.mNameTextView = ((TextView)this.mRootView.findViewById(2131363157));
      this.mMsgTextView = ((TextView)this.mRootView.findViewById(2131363156));
      Resources localResources = this.mContext.getApplicationContext().getResources();
      this.ayj = ((int)localResources.getDimension(2131298225));
      this.ayk = ((int)localResources.getDimension(2131298226));
      int i = (int)(localResources.getDimension(2131296404) + localResources.getDimension(2131296471));
      int j = (int)(localResources.getDimension(2131296406) + localResources.getDimension(2131296473));
      int k = (int)(localResources.getDimension(2131296403) + localResources.getDimension(2131296470));
      float f = localResources.getDimension(2131296405);
      int m = (int)(localResources.getDimension(2131296472) + f);
      this.mMsgTextView.setPadding(i, j, k, m);
      this.mMsgTextView.setTag(Long.valueOf(0L));
      this.mNameTextView.setMaxWidth(this.ayj);
      this.mMsgTextView.setMaxWidth(this.ayk);
      this.mMsgTextView.getBackground().setAlpha(128);
      if (AudioHelper.jY(0) == 1)
      {
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setBackgroundColor(-460545);
        this.di.setBackgroundColor(-984833);
        this.mMsgTextView.setBackgroundColor(-1);
      }
    }
  }
  
  private void avx()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$d = new d(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    ViewCompat.setAccessibilityDelegate(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$d);
  }
  
  private void avy()
  {
    if (this.jdField_a_of_type_Irn == null) {
      this.jdField_a_of_type_Irn = new irn(this.mApp, (AVActivity)this.mContext);
    }
  }
  
  private void avz()
  {
    if (this.jdField_a_of_type_Irn != null)
    {
      this.jdField_a_of_type_Irn.onDestroy();
      this.jdField_a_of_type_Irn = null;
    }
  }
  
  private void b(izm paramizm, boolean paramBoolean)
  {
    ira localira = new ira();
    localira.setDuration(50);
    localira.c(0.0F, 0.0F, -90.0F, 0.0F, 0.0F, 0.0F);
    localira.setSpeedType(2);
    localira.a(new jff(this));
    paramizm.a(localira);
    paramizm.invalidate();
  }
  
  private void bZ(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.ayb) && (paramInt2 == this.ayc)) {}
    for (;;)
    {
      return;
      if (paramInt1 < paramInt2)
      {
        this.ayb = paramInt1;
        this.ayc = paramInt2;
      }
      while (this.jdField_a_of_type_Iqw != null)
      {
        this.jdField_a_of_type_Iqw.bI(this.ayb, this.ayc);
        return;
        this.ayc = 0;
        this.ayb = 0;
      }
    }
  }
  
  private static final String c(CharSequence paramCharSequence)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramCharSequence);
    int i = paramCharSequence.length();
    aofk.a[] arrayOfa = (aofk.a[])((aofk)paramCharSequence).getSpans(0, i, aofk.a.class);
    i = 0;
    int k;
    for (int j = 0; i < arrayOfa.length; j = k)
    {
      Object localObject = arrayOfa[i];
      k = j;
      if ((localObject instanceof aofk.a))
      {
        int m = ((aofk)paramCharSequence).getSpanStart(localObject);
        int n = ((aofk)paramCharSequence).getSpanEnd(localObject);
        k = j;
        if (((aofk.a)localObject).emojiType == 2)
        {
          localObject = ((aofk.a)localObject).getDescription();
          localStringBuffer.replace(m + j, n + j, (String)localObject);
          k = j + (((String)localObject).length() - (n - m));
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void c(RecvMsg paramRecvMsg)
  {
    if (f().booleanValue()) {}
    do
    {
      return;
      String str2 = paramRecvMsg.hg();
      String str3 = paramRecvMsg.hf();
      String str1 = paramRecvMsg.getSenderName();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.OB)
        {
          localObject = str1;
          if (str3 != null) {
            localObject = this.jdField_a_of_type_ComTencentAvVideoController.d(str3, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), this.jdField_a_of_type_ComTencentAvVideoController.b().relationType);
          }
        }
      }
      paramRecvMsg = paramRecvMsg.getMsg();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "showRecvMsg friendUin: " + str2 + ", senderUin: " + str3 + ", senderName: " + (String)localObject + ", msg: " + paramRecvMsg);
      }
      nf(this.mOrientation);
      kE(true);
      if (this.mNameTextView != null) {
        this.mNameTextView.setText((CharSequence)localObject);
      }
    } while ((paramRecvMsg == null) || (this.mMsgTextView == null));
    Object localObject = new aofk(paramRecvMsg, 11);
    paramRecvMsg = (RecvMsg)localObject;
    if (a((CharSequence)localObject)) {
      paramRecvMsg = c((CharSequence)localObject);
    }
    this.mMsgTextView.setText(paramRecvMsg);
  }
  
  private void dE(long paramLong)
  {
    if ((this.mContext != null) && (!this.YA)) {
      ((AVActivity)this.mContext).mControlUI.dE(paramLong);
    }
  }
  
  private Boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static void j(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131363163);
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void kE(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showMsgbox: show = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {}
    do
    {
      return;
      localObject = this.mContext.getApplicationContext().getResources();
      int i = (int)(((Resources)localObject).getDimension(2131296404) + ((Resources)localObject).getDimension(2131296471));
      int j = (int)(((Resources)localObject).getDimension(2131296406) + ((Resources)localObject).getDimension(2131296473));
      int k = (int)(((Resources)localObject).getDimension(2131296403) + ((Resources)localObject).getDimension(2131296470));
      f = ((Resources)localObject).getDimension(2131296405);
      int m = (int)(((Resources)localObject).getDimension(2131296472) + f);
      this.mMsgTextView.setPadding(i, j, k, m);
      this.mMsgTextView.getBackground().setAlpha(128);
      if ((this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown()) && (!paramBoolean))
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(1000L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        ((AlphaAnimation)localObject).setAnimationListener(new c(null));
        this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
        return;
      }
    } while (!paramBoolean);
    Object localObject = new Transformation();
    ((Transformation)localObject).setAlpha(0.0F);
    AlphaAnimation localAlphaAnimation = (AlphaAnimation)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getAnimation();
    if (localAlphaAnimation != null)
    {
      localAlphaAnimation.setAnimationListener(null);
      localAlphaAnimation.getTransformation(System.currentTimeMillis(), (Transformation)localObject);
    }
    float f = ((Transformation)localObject).getAlpha();
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.clearAnimation();
    localObject = new AlphaAnimation(f, 1.0F);
    ((AlphaAnimation)localObject).setDuration(1000L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.startAnimation((Animation)localObject);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setTag(Long.valueOf(System.currentTimeMillis()));
  }
  
  private void m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.iT.size();
    paramInt3 = paramInt1 + this.axY;
    paramInt4 = this.axW;
    paramInt1 = paramInt3;
    paramInt3 += paramInt4;
    int i = 1;
    paramInt4 = paramInt1;
    paramInt1 = i;
    while (paramInt1 <= j)
    {
      ((iqt)this.iT.get(paramInt1 - 1)).layout(paramInt4, paramInt2, paramInt3, this.axX + paramInt2);
      paramInt4 += this.axW + this.axY;
      paramInt3 = paramInt4 + this.axW;
      paramInt1 += 1;
    }
    this.mContentLength = ((this.axW + this.axY) * j + this.axY);
  }
  
  private int ml()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_ArrayOfIzm.length; j = k)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      String str = localizm.getUin();
      k = j;
      if (localizm.getVisibility() == 0)
      {
        k = j;
        if (!TextUtils.isEmpty(str)) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  private int mm()
  {
    return this.am.right - this.am.left;
  }
  
  private int mn()
  {
    return ml();
  }
  
  private int mo()
  {
    int j = this.mContentLength - mm();
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    return i;
  }
  
  private void nf(int paramInt)
  {
    if ((this.YB) || (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getLayoutParams();
    int m = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299733);
    int k = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299734);
    int n = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299728);
    int j = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299729);
    int i1 = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299727);
    if ((this.ayt == 0) || (this.mTopOffset == 0))
    {
      j = n;
      k = m;
    }
    int i2 = ml();
    Object localObject1;
    int i;
    label270:
    label495:
    Object localObject2;
    if (i2 <= 0)
    {
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.leftMargin = n;
      localLayoutParams.bottomMargin = (j + this.ayt);
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      localObject1 = (RotateLayout.LayoutParams)this.di.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject1).angle = 0;
      this.di.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      j = this.mRootView.getWidth() - n * 2;
      i = j;
      if (j > this.ayk) {
        i = this.ayk;
      }
      this.mMsgTextView.setMaxWidth(i);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "setMsgboxLayout, orientation[" + paramInt + "], leftMargin[" + localLayoutParams.leftMargin + "], topMargin[" + localLayoutParams.topMargin + "], rightMargin[" + localLayoutParams.rightMargin + "], bottomMargin[" + localLayoutParams.bottomMargin + "], mMsgLayout[" + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getWidth() + ", " + this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getHeight() + "]");
      }
    }
    else
    {
      i = paramInt;
      if (this.ayt != 0)
      {
        i = paramInt;
        if (this.mTopOffset != 0) {
          i = 0;
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfIzm[1].getBounds();
      paramInt = mp();
      if (i != 0) {
        break label761;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(12, -1);
      if (i2 != 1) {
        break label683;
      }
      localLayoutParams.leftMargin = n;
      localLayoutParams.bottomMargin = (j + this.ayt);
      localLayoutParams.bottomMargin += this.ayl;
      this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.setLayoutParams(localLayoutParams);
      if (QLog.isDevelopLevel()) {
        QLog.d(this.TAG, 4, "setLayoutParams, [" + localLayoutParams.leftMargin + ", " + localLayoutParams.topMargin + ", " + localLayoutParams.rightMargin + ", " + localLayoutParams.bottomMargin + "]");
      }
      localObject2 = (RotateLayout.LayoutParams)this.di.getLayoutParams();
      ((RotateLayout.LayoutParams)localObject2).angle = i;
      this.di.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = super.getBounds();
      if (i2 != 1) {
        break label1167;
      }
    }
    label1167:
    for (paramInt = ((Rect)localObject2).width() - n * 2;; paramInt = ((Rect)localObject2).width() - ((Rect)localObject1).width() - m - n - i1)
    {
      j = paramInt;
      if (paramInt > this.ayk) {
        j = this.ayk;
      }
      this.mMsgTextView.setMaxWidth(j);
      paramInt = i;
      break label270;
      break;
      label683:
      if (i2 == 2)
      {
        if (paramInt == 4) {}
        for (localLayoutParams.leftMargin = (((Rect)localObject1).width() + m + i1);; localLayoutParams.leftMargin = n)
        {
          localLayoutParams.bottomMargin = (j + this.ayt);
          break;
        }
      }
      localLayoutParams.leftMargin = n;
      localLayoutParams.bottomMargin = (j + this.ayt + ((Rect)localObject1).height());
      break label495;
      label761:
      if (i == 90)
      {
        localLayoutParams.addRule(10, 0);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(12, -1);
        if (i2 == 1)
        {
          localLayoutParams.rightMargin = n;
          localLayoutParams.bottomMargin = (j + this.ayt);
          break label495;
        }
        if (i2 < 2) {
          break label495;
        }
        if (paramInt == 3) {}
        for (localLayoutParams.bottomMargin = (((Rect)localObject1).height() + k + i1 + this.ayt);; localLayoutParams.bottomMargin = (j + this.ayt))
        {
          localLayoutParams.rightMargin = n;
          break;
        }
      }
      if (i == 180)
      {
        localLayoutParams.addRule(9, 0);
        localLayoutParams.addRule(12, 0);
        localLayoutParams.addRule(11, -1);
        localLayoutParams.addRule(10, -1);
        if (i2 == 1)
        {
          localLayoutParams.rightMargin = n;
          localLayoutParams.topMargin = (j + this.mTopOffset);
          break label495;
        }
        if (i2 == 2)
        {
          if (paramInt == 2) {}
          for (localLayoutParams.rightMargin = (((Rect)localObject1).width() + m + i1);; localLayoutParams.rightMargin = n)
          {
            localLayoutParams.topMargin = (j + this.mTopOffset);
            break;
          }
        }
        localLayoutParams.rightMargin = n;
        if (paramInt == 2)
        {
          localLayoutParams.topMargin = (j + this.mTopOffset + ((Rect)localObject1).height());
          break label495;
        }
        localLayoutParams.topMargin = (j + this.mTopOffset);
        break label495;
      }
      if (i != 270) {
        break label495;
      }
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(9, -1);
      if (i2 == 1)
      {
        localLayoutParams.leftMargin = n;
        localLayoutParams.topMargin = (j + this.mTopOffset);
        break label495;
      }
      if (i2 < 2) {
        break label495;
      }
      if (paramInt == 1) {}
      for (localLayoutParams.topMargin = (((Rect)localObject1).height() + k + i1 + this.mTopOffset);; localLayoutParams.topMargin = (j + this.mTopOffset))
      {
        localLayoutParams.leftMargin = n;
        break;
      }
    }
  }
  
  private void nh(int paramInt)
  {
    if (paramInt > 0)
    {
      int i = 0;
      if (paramInt == 2) {
        i = 2131697680;
      }
      if ((i != 0) && (this.mApp != null)) {
        iwu.b(this.mApp, 1008, i);
      }
    }
  }
  
  private void o(ipm arg1)
  {
    synchronized (this.mEventQueue)
    {
      while (!this.mEventQueue.isEmpty())
      {
        Runnable localRunnable = (Runnable)this.mEventQueue.remove(0);
        if (localRunnable != null)
        {
          long l1 = System.currentTimeMillis();
          localRunnable.run();
          long l2 = System.currentTimeMillis();
          if (l2 - l1 >= 100L) {
            QLog.d("GLLinearLayout", 1, "event queue cost too long: " + (l2 - l1));
          }
        }
      }
    }
  }
  
  private void p(ipm paramipm)
  {
    o(paramipm);
    long l1 = iqs.get();
    boolean bool2 = this.jdField_a_of_type_Iqz.av(l1);
    this.iT.clear();
    int k = 1;
    int i = 1;
    Object localObject1;
    int i1;
    int n;
    int j;
    for (;;)
    {
      try
      {
        localObject1 = (izm)a(0);
        l1 = Long.parseLong(((izm)localObject1).getUin());
        i1 = ((izm)localObject1).getVideoSrcType();
        if (!(getAVActivity().mControlUI instanceof DoubleVideoMeetingCtrlUI))
        {
          localObject1 = this.jdField_a_of_type_Jfm.a(false);
          if (!this.Yx) {
            break label1308;
          }
          this.jdField_a_of_type_Jef.bF((ArrayList)localObject1);
          if (((ArrayList)localObject1).size() <= this.ayf) {
            break label675;
          }
          m = 1;
          n = 1;
          if ((n < ((ArrayList)localObject1).size()) && ((this.iT.size() != this.ayf - 2) || (m == 0))) {
            break;
          }
          j = i;
          if (m != 0)
          {
            this.e.setText(((ArrayList)localObject1).size() - this.ayf + 1 + "+");
            if (!((Boolean)this.e.getTag(2)).booleanValue()) {
              break label1291;
            }
            this.iT.add(this.e);
            j = i;
          }
          label224:
          if ((j >= 2) && (jll.cH(2))) {
            ThreadManager.getUIHandler().post(new VideoLayerUI.3(this));
          }
          paramipm.translate(getWidth() / 2, getHeight() / 2, 0.0F);
          f(paramipm);
          paramipm.translate(-getWidth() / 2, -getHeight() / 2, 0.0F);
          j = c("renderSliderWindowStyle", String.valueOf(((jfj)((ArrayList)localObject1).get(0)).uin), ((jfj)((ArrayList)localObject1).get(0)).getVideoSrcType());
          i = j;
          if (j == -1) {
            i = 0;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfIzm[i];
          if (!((jfj)((ArrayList)localObject1).get(0)).xc()) {
            break label1362;
          }
          i = 1;
          label369:
          j = i;
          if (i == 0)
          {
            if (!((jfj)((ArrayList)localObject1).get(0)).isSpeaking()) {
              break label1367;
            }
            j = 2;
          }
          label392:
          ((izm)localObject2).ms(j);
          ((izm)localObject2).jL(false);
          ((izm)localObject2).setPaddings(0, 0, 0, 0);
          ((izm)localObject2).layout(0, 0, super.getWidth(), super.getHeight());
          a(paramipm, (iqt)localObject2, true);
          if ((!((izm)localObject2).canRender()) && (QLog.isDevelopLevel())) {
            QLog.d(this.TAG, 1, "error happen big screen can not render with Uin:=" + ((izm)localObject2).getUin() + ",srcType:=" + ((izm)localObject2).getVideoSrcType());
          }
          m(this.an.left, this.an.top, this.an.right, this.an.bottom);
          i = this.jdField_a_of_type_Iqz.getPosition();
          if (!this.Yw) {
            break label1372;
          }
          bool1 = true;
          label546:
          N(i, bool1);
          if (this.Yw) {
            this.Yw = false;
          }
          paramipm.translate(-this.axZ, -this.aya);
          i = 0;
          if (i >= this.iT.size()) {
            break label1378;
          }
          a(paramipm, (iqt)this.iT.get(i), false);
          i += 1;
          continue;
          return;
        }
      }
      catch (NumberFormatException paramipm)
      {
        paramipm.printStackTrace();
      }
      label625:
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.aN();
      this.jdField_a_of_type_Jfm.bH((ArrayList)localObject1);
      localObject1 = this.jdField_a_of_type_Jfm.a(true);
      if (((ArrayList)localObject1).size() == 0) {
        QLog.d("GLLinearLayout", 1, "videoMemmberInfos size is zero");
      }
      continue;
      label675:
      int m = 0;
    }
    Object localObject2 = (jfj)((ArrayList)localObject1).get(n);
    long l2 = ((jfj)localObject2).getUin();
    k = ((jfj)localObject2).getVideoSrcType();
    ((jfj)localObject2).getAccountType();
    boolean bool1 = ((jfj)localObject2).Ww;
    boolean bool3 = ((jfj)localObject2).xb();
    ((jfj)localObject2).isSpeaking();
    Object localObject3;
    if (bool3)
    {
      j = i;
      if (l2 == l1)
      {
        j = i;
        if (k == i1)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(this.TAG, 1, "arraysToList3 bigindex index:=" + n);
          }
          j = i + 1;
        }
      }
      int i2 = c("renderSliderWindowStyle", String.valueOf(l2), k);
      if (i2 != -1)
      {
        localObject3 = this.jdField_a_of_type_ArrayOfIzm[i2];
        if (((jfj)localObject2).xc())
        {
          i = 1;
          label837:
          k = i;
          if (i == 0)
          {
            if (!((jfj)localObject2).isSpeaking()) {
              break label1109;
            }
            k = 2;
          }
          label855:
          ((izm)localObject3).ms(k);
          if (TextUtils.isEmpty(((izm)localObject3).getText()))
          {
            ((izm)localObject3).setText(a((jfj)localObject2));
            ((izm)localObject3).jN(true);
          }
          ((izm)localObject3).setMaxLength(12);
          ((izm)localObject3).setTextSize(jll.dp2px(this.mContext, 12.0F));
          ((izm)localObject3).jL(true);
          this.iT.add(this.jdField_a_of_type_ArrayOfIzm[i2]);
          i = j + 1;
          j = 1;
        }
      }
    }
    for (;;)
    {
      label939:
      izm localizm;
      if (((!bool3) && (bool1)) || (j == 0))
      {
        localizm = this.jdField_a_of_type_Jef.a(l2);
        localizm.jH(false);
        localizm.jL(true);
        if (((jfj)localObject2).xc())
        {
          j = 1;
          label986:
          k = j;
          if (j == 0)
          {
            if (!((jfj)localObject2).isSpeaking()) {
              break label1127;
            }
            k = 2;
          }
          label1004:
          localizm.ms(k);
          if (((Boolean)localizm.getTag(2)).booleanValue()) {
            break label1133;
          }
          localizm.setText(a((jfj)localObject2));
          localizm.jN(true);
          localObject3 = a((jfj)localObject2);
          localObject2 = localObject3;
          if (Build.VERSION.SDK_INT == 23) {
            localObject2 = r((Bitmap)localObject3);
          }
          localObject2 = new iql((Bitmap)localObject2);
          ((iql)localObject2).b(paramipm);
          localizm.a((iql)localObject2);
        }
      }
      for (;;)
      {
        n += 1;
        break;
        i = 0;
        break label837;
        label1109:
        k = 3;
        break label855;
        i = j;
        j = 0;
        break label939;
        j = 0;
        break label986;
        label1127:
        k = 3;
        break label1004;
        label1133:
        this.iT.add(localizm);
        continue;
        if (!bool1)
        {
          localizm = this.jdField_a_of_type_Jef.a(l2);
          localizm.jH(true);
          localizm.mr(Color.parseColor("#4C000000"));
          localizm.ms(-1);
          localizm.jL(true);
          if (!((Boolean)localizm.getTag(2)).booleanValue())
          {
            localizm.setText(a((jfj)localObject2));
            localizm.jN(true);
            localObject3 = a((jfj)localObject2);
            localObject2 = localObject3;
            if (Build.VERSION.SDK_INT == 23) {
              localObject2 = r((Bitmap)localObject3);
            }
            localObject2 = new iql((Bitmap)localObject2);
            ((iql)localObject2).b(paramipm);
            localizm.a((iql)localObject2);
          }
          else
          {
            this.iT.add(localizm);
          }
        }
      }
      label1291:
      this.e.setTag(2, Boolean.valueOf(true));
      j = i;
      break label224;
      label1308:
      i = 0;
      j = k;
      if (i >= this.jdField_a_of_type_ArrayOfIzm.length) {
        break label224;
      }
      localObject2 = this.jdField_a_of_type_ArrayOfIzm[i];
      if (!((iqt)localObject2).canRender()) {}
      for (;;)
      {
        i += 1;
        break;
        if (i != 0) {
          this.iT.add(localObject2);
        }
      }
      label1362:
      i = 0;
      break label369;
      label1367:
      j = 3;
      break label392;
      label1372:
      bool1 = false;
      break label546;
      label1378:
      paramipm.translate(this.axZ, this.aya);
      if (!(false | bool2)) {
        break label625;
      }
      invalidate();
      return;
      j = 1;
    }
  }
  
  private void q(boolean paramBoolean, long paramLong)
  {
    if (this.mApp.ch(0))
    {
      arz();
      Object localObject = this.jdField_a_of_type_Jhj.a();
      if (localObject != null)
      {
        localObject = ((ZimuItem)localObject).getId();
        int i = 1;
        if (!paramBoolean) {
          i = 4;
        }
        new iya.f(paramLong, "showLastZimu", i, (String)localObject).n(this.mApp);
      }
    }
  }
  
  private Bitmap r(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (paramBitmap == null) {
        break label93;
      }
      if (!paramBitmap.isRecycled())
      {
        localObject = paramBitmap;
        if (paramBitmap.getConfig() != null) {
          break label93;
        }
      }
    }
    Bitmap localBitmap = jll.b(this.mContext, 2130841275);
    Object localObject = localBitmap;
    if (QLog.isDevelopLevel())
    {
      localObject = this.TAG;
      if ("memory not enough or binder bad,so quit load headIcon,bitmap.getConfig():=" + localBitmap == null) {
        break label95;
      }
    }
    label93:
    label95:
    for (paramBitmap = localBitmap.getConfig();; paramBitmap = "bitmap null")
    {
      QLog.d((String)localObject, 1, new Object[] { paramBitmap });
      localObject = localBitmap;
      return localObject;
    }
  }
  
  public static String u(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private boolean wR()
  {
    return (this.jdField_a_of_type_Jdl != null) && (this.jdField_a_of_type_Jdl.getStyle() == 4) && (!this.Yu);
  }
  
  private boolean wc()
  {
    long l = this.oZ;
    this.oZ = System.currentTimeMillis();
    if (this.oZ - l > 1000L) {
      return true;
    }
    this.oZ = l;
    QLog.d(this.TAG, 1, "canPerformClick not allowed");
    return false;
  }
  
  public void F(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.YG) && (!wW())) {
      this.mCacheRotation = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.mRotation) || (paramInt == this.mCacheRotation))
      {
        if (paramInt % 90 != this.mRotation % 90) {
          this.axw = 0;
        }
        this.mRotation = paramInt;
        this.mCacheRotation = paramInt;
        int i = a(this.TAG, this.mContext, paramInt, paramBoolean, this.mDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2)
        {
          if (this.mOrientation != 0)
          {
            paramBoolean = bool;
            if (this.mOrientation != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          jj(paramBoolean);
          return;
          paramInt = 0;
          while (paramInt < super.getChildCount())
          {
            super.a(paramInt).setRotation(i);
            paramInt += 1;
          }
          nf(i);
          this.mOrientation = i;
        }
      }
    }
  }
  
  protected boolean L(int paramInt1, int paramInt2)
  {
    String str1;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
      String str2 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin();
      QLog.w(this.TAG, 1, "switchVideo, begin, [" + paramInt1 + "]=[" + str1 + "], [" + paramInt2 + "]=[" + str2 + "]", new Throwable("打印调用栈"));
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfIzm.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfIzm.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "switchVideo index invalid!");
      }
      return false;
    }
    if (paramInt2 == 0)
    {
      ca(paramInt1, paramInt2);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
    {
      if (paramInt1 != 0) {
        break label265;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    for (;;)
    {
      str1 = this.mApp.getCurrentAccountUin();
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
      if (str1.equals(this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin())) {
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      if ((this.jdField_a_of_type_Jdl == null) || (this.jdField_a_of_type_Jdl.getStyle() != 3)) {
        break;
      }
      return Q(paramInt1, paramInt2);
      label265:
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    if ((this.jdField_a_of_type_Jdl != null) && (this.jdField_a_of_type_Jdl.getStyle() == 4)) {
      return R(paramInt1, paramInt2);
    }
    return P(paramInt1, paramInt2);
  }
  
  public void P(long paramLong, boolean paramBoolean)
  {
    int j = 2;
    int i = 1;
    QLog.w(this.TAG, 1, "notifyAudioMemberChange");
    if (((this.jdField_a_of_type_ComTencentAvVideoController.b().relationType == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.b().relationType == 2))
    {
      jfj localjfj = a(paramLong);
      localjfj.Wu = paramBoolean;
      if (!localjfj.Pk) {
        break label129;
      }
      if (i != 0) {
        break label141;
      }
      if (!localjfj.isSpeaking()) {
        break label135;
      }
      i = j;
    }
    label129:
    label135:
    label141:
    for (;;)
    {
      T(paramLong, i);
      if ((this.jdField_a_of_type_Jfm != null) && (this.jdField_a_of_type_Jfm.g(paramLong, paramBoolean))) {
        invalidate();
      }
      return;
      i = 0;
      break;
      i = 3;
    }
  }
  
  public void Q(long paramLong, boolean paramBoolean)
  {
    int j = 2;
    int i = 1;
    if (((this.jdField_a_of_type_ComTencentAvVideoController.b().relationType == 1) && (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10)) || (this.jdField_a_of_type_ComTencentAvVideoController.b().relationType == 2))
    {
      jfj localjfj = a(paramLong);
      localjfj.Pk = paramBoolean;
      if (!localjfj.Pk) {
        break label118;
      }
      if (i != 0) {
        break label130;
      }
      if (!localjfj.isSpeaking()) {
        break label124;
      }
      i = j;
    }
    label130:
    for (;;)
    {
      T(paramLong, i);
      if ((this.jdField_a_of_type_Jfm != null) && (this.jdField_a_of_type_Jfm.h(paramLong, paramBoolean))) {
        invalidate();
      }
      return;
      label118:
      i = 0;
      break;
      label124:
      i = 3;
    }
  }
  
  public void a(long paramLong, Boolean paramBoolean)
  {
    String str = this.mApp.getCurrentAccountUin();
    dT(paramLong);
    int i = c("openSelfScreenShare", str, 2);
    if ((paramBoolean.booleanValue()) && (i > 0)) {
      L(0, i);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = c("setBackground", paramString, paramInt);
    int j = i;
    boolean bool;
    label58:
    izm localizm;
    if (i < 0)
    {
      j = cD(0);
      if (j >= 0)
      {
        if (paramString.equals(this.mApp.getCurrentAccountUin())) {
          break label264;
        }
        bool = true;
        localizm = this.jdField_a_of_type_ArrayOfIzm[j];
        b(paramLong, localizm, paramString, paramInt, bool);
        if ((localizm != null) && (!bool)) {
          localizm.J(paramLong, CameraUtils.a(this.mContext).isFrontCamera());
        }
      }
      i = j;
      if (paramBoolean2)
      {
        i = j;
        if (j > 0)
        {
          L(0, j);
          i = 0;
        }
      }
      j = i;
      if (i <= 0) {}
    }
    label264:
    int k;
    for (j = 1;; j = k)
    {
      if (i >= 0)
      {
        localizm = this.jdField_a_of_type_ArrayOfIzm[i];
        localizm.setBackground(paramBitmap);
        localizm.jO(paramBoolean1);
        if (!paramBoolean1) {
          localizm.enableLoading(false);
        }
      }
      if (j != 0) {
        ng(i);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.TAG, 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i + ", needRenderVideo: " + paramBoolean1);
      return;
      bool = false;
      break label58;
      k = 0;
      i = j;
    }
  }
  
  void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    izm localizm = null;
    int i = c("openPeerVideo, seq[" + paramLong + "]", paramString, paramInt);
    if (b(this.jdField_a_of_type_ComTencentAvVideoController.b())) {
      if ((paramBoolean1) || (wV())) {
        break label582;
      }
    }
    label262:
    label292:
    label565:
    label582:
    for (boolean bool = true;; bool = paramBoolean1)
    {
      if (i > 1)
      {
        ivv.arh();
        QLog.e(this.TAG, 1, "SetGlRender index break!!!!!! index=" + i + ", remotehasvideo=" + this.jdField_a_of_type_ComTencentAvVideoController.b().PZ);
        return;
        bool = paramBoolean1;
      }
      String str = u(paramString, paramInt);
      int j;
      if (i < 0)
      {
        i = cD(0);
        if (i >= 0)
        {
          localizm = this.jdField_a_of_type_ArrayOfIzm[i];
          b(paramLong, localizm, paramString, paramInt, true);
        }
        if ((localizm != null) && (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() <= 1) && (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)) {
          localizm.setTextSize(wja.dp2px(18.0F, this.mContext.getResources()));
        }
        if ((i <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4)) {
          break label565;
        }
        j = 1;
        paramString = localizm;
        paramInt = i;
        i = j;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.jK(paramBoolean2);
          paramString.J(paramLong, this.jdField_a_of_type_Jdl.vX());
          if (paramBoolean1) {
            break label525;
          }
          paramBoolean1 = true;
          paramString.enableLoading(paramBoolean1);
          paramString.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4) {
            break label541;
          }
          if (paramInt != 0) {
            break label531;
          }
          paramString.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().ani == 3) {
            paramString.jL(true);
          }
        }
        for (;;)
        {
          if ((bool) && (paramInt > 0) && (!wS()) && ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PX))) {
            L(0, paramInt);
          }
          if (i == 0) {
            break;
          }
          ng(paramInt);
          return;
          paramString = this.jdField_a_of_type_ArrayOfIzm[i];
          GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
          QLog.w(this.TAG, 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i + "], " + paramString.hl());
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, true);
          paramInt = i;
          i = 0;
          break label262;
          paramBoolean1 = false;
          break label292;
          paramString.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
            paramString.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
        }
        j = 0;
        paramString = localizm;
        paramInt = i;
        i = j;
      }
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.YG + "], isFillBlackEdge[" + paramBoolean3 + "], seq[" + paramLong + "]");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.mApp.getCurrentAccountUin())) || (!isSupport())) {}
    for (;;)
    {
      return;
      wY();
      if (paramBoolean1) {
        avy();
      }
      if (paramBoolean1) {
        a(paramLong, paramString, paramInt, paramBoolean2, paramBoolean3);
      }
      while ((this.jdField_a_of_type_Jhj != null) && (!wT()))
      {
        q(paramBoolean1, paramLong);
        return;
        h(paramLong, paramString, paramInt);
      }
    }
  }
  
  void a(RecvMsg paramRecvMsg)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011) {}
    String str2;
    do
    {
      return;
      String str1 = paramRecvMsg.hg();
      str2 = paramRecvMsg.hf();
      String str3 = paramRecvMsg.getSenderName();
      String str4 = paramRecvMsg.getMsg();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "onReceiveMsg friendUin: " + str1 + ", senderUin: " + str2 + ", senderName: " + str3 + ", msg: " + str4);
      }
    } while (str2.equals(this.mApp.getCurrentAccountUin()));
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      avu();
    }
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.isShown())
    {
      if (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_ComTencentAvWidgetRotateLayout.getTag()).longValue() >= 3000L)
      {
        this.mApp.getHandler().removeCallbacks(this.cf);
        this.mApp.getHandler().removeCallbacks(this.cg);
        c(paramRecvMsg);
        this.mApp.getHandler().postDelayed(this.cf, 3000L);
        this.mApp.getHandler().postDelayed(this.cg, 3000L);
        return;
      }
      this.fC.add(paramRecvMsg);
      return;
    }
    this.mApp.getHandler().removeCallbacks(this.cf);
    this.mApp.getHandler().removeCallbacks(this.cg);
    c(paramRecvMsg);
    this.mApp.getHandler().postDelayed(this.cf, 3000L);
    this.mApp.getHandler().postDelayed(this.cg, 3000L);
  }
  
  protected void a(ipm paramipm, boolean paramBoolean)
  {
    if (wR())
    {
      p(paramipm);
      return;
    }
    this.axZ = 0;
    this.aya = 0;
    this.mScrollX = 0;
    this.mScrollY = 0;
    super.a(paramipm, paramBoolean);
  }
  
  void a(iya.f paramf)
  {
    arz();
    String str = paramf.Rk;
    long l = paramf.bK();
    if (ilf.cu(str))
    {
      bool2 = imy.ue();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.jdField_a_of_type_Jhj.b(paramf.bK(), str, (ViewGroup)this.mRootView, this.mTopOffset, this.ayt);
      }
      if ((bool1) && ((this.mContext instanceof AVActivity))) {
        ((AVActivity)this.mContext).cP(l);
      }
    }
    while ((!this.jdField_a_of_type_Jhj.a(paramf.bK(), str, (ViewGroup)this.mRootView, this.mTopOffset, this.ayt)) || (!(this.mContext instanceof AVActivity)))
    {
      boolean bool2;
      boolean bool1;
      return;
    }
    ((AVActivity)this.mContext).cP(l);
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = true;
    int i = c("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setText, uin[" + paramString1 + "], videoSrcType[" + paramInt1 + "], text[" + paramString2 + "], textSize[" + paramFloat + "], textColor[" + paramInt2 + "], index[" + i + "]");
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfIzm[i];
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
      paramString1.setTextSize(paramFloat);
      paramString1.setTextColor(paramInt2);
      if (lI() != 3) {
        break label229;
      }
      if (i <= 0) {
        break label188;
      }
    }
    for (;;)
    {
      paramString1.jL(bool);
      if (i != 0) {
        break label247;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb != 2) {
        break;
      }
      paramString1.setText("");
      return;
      label188:
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() <= 1)
      {
        paramString1.setTextSize(wja.dp2px(18.0F, this.mContext.getResources()));
        bool = false;
        continue;
        label229:
        if (i == 0) {
          bool = false;
        }
      }
    }
    paramString1.setMaxLength(12);
    return;
    label247:
    if (c(this.jdField_a_of_type_ComTencentAvVideoController.b()))
    {
      paramString1.setMaxLength(12);
      return;
    }
    paramString1.setMaxLength(2147483647);
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isSupport()) {
      return false;
    }
    if (paramBoolean1) {
      a(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.YH = paramBoolean1;
      return true;
      dU(paramLong);
    }
  }
  
  protected void arx()
  {
    this.jdField_a_of_type_Jdt = new jdt(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  void arz()
  {
    if (this.jdField_a_of_type_Jhj == null) {
      this.jdField_a_of_type_Jhj = new jhj(this.mApp, this.mContext);
    }
  }
  
  protected void avp()
  {
    super.avp();
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.post(new VideoLayerUI.1(this));
  }
  
  protected void avv()
  {
    this.YB = false;
    nf(this.mOrientation);
  }
  
  void avw()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    if ((this.mApp.ch(0)) && (i == 2))
    {
      arz();
      this.jdField_a_of_type_Jhj.avw();
    }
  }
  
  public jfj b(long paramLong)
  {
    return (jfj)this.aN.get(Long.valueOf(paramLong));
  }
  
  public void b(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.ayh = c("notifyGLVideoViewChange", String.valueOf(paramLong1), paramInt1);
    this.ayi = c("notifyGLVideoViewChange", String.valueOf(paramLong2), paramInt2);
    queueEvent(new VideoLayerUI.2(this, this.ayh, this.ayi));
  }
  
  void b(long paramLong, izm paramizm, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramizm != null)
    {
      str = u(paramString, paramInt);
      paramizm.an(paramString, paramInt);
      paramizm.setVisibility(0);
      paramizm.kc(this.mApp.getCurrentAccountUin());
    }
    try
    {
      paramString = paramizm.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.mApp.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w(this.TAG, 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + paramizm.hl() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError paramizm)
    {
      paramizm.printStackTrace();
    }
  }
  
  void b(long paramLong, Boolean paramBoolean)
  {
    ThreadManager.post(this.ch, 8, null, false);
    int i = c("openSelfVideo", this.mApp.getCurrentAccountUin(), 1);
    dX(paramLong);
    if ((paramBoolean.booleanValue()) && (i > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.b().PX))) {
      L(0, i);
    }
  }
  
  void b(iya.f paramf)
  {
    boolean bool = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "requestZimu, mHandle[" + paramf.avE + "], seq[" + paramf.bK() + "]");
    }
    if (paramf.avE == 2) {
      if ((this.jdField_a_of_type_Jhj != null) && (this.mApp.ch(0)))
      {
        this.jdField_a_of_type_Jhj.a((ViewGroup)this.mRootView, paramf.bK());
        if ((this.mContext instanceof AVActivity)) {
          ((AVActivity)this.mContext).cP(paramf.bK());
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramf.avE == 1)
          {
            a(paramf);
            return;
          }
          if ((paramf.avE != 3) && (paramf.avE != 4)) {
            break;
          }
        } while (!this.mApp.ch(0));
        arz();
        if (paramf.avE == 3) {
          bool = true;
        }
      } while ((!this.jdField_a_of_type_Jhj.a(paramf.bK(), (ViewGroup)this.mRootView, bool)) || (!(this.mContext instanceof AVActivity)));
      ((AVActivity)this.mContext).cP(paramf.bK());
      return;
    } while (paramf.avE != 5);
    if (this.jdField_a_of_type_Jhj != null)
    {
      this.jdField_a_of_type_Jhj.eb(paramf.bK());
      return;
    }
    ilf.il(false);
  }
  
  protected void b(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
      return;
    case 6008: 
      arz();
      paramObservable = (ijn)paramObservable[1];
      this.jdField_a_of_type_Jhj.c(paramObservable);
      return;
    case 6010: 
      arz();
      nh(((Integer)paramObservable[1]).intValue());
      return;
    case 6005: 
      b((iya.f)iya.a(paramObservable));
      return;
    case 6501: 
      if ((this.jdField_a_of_type_Jhj != null) && (this.mApp.ch(0)))
      {
        this.jdField_a_of_type_Jhj.kP(true);
        return;
      }
      ilf.il(true);
      return;
    }
    jj(true);
  }
  
  public boolean b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!isSupport()) {
      return false;
    }
    if (paramBoolean1) {
      avy();
    }
    if (paramBoolean1) {
      b(paramLong, Boolean.valueOf(paramBoolean2));
    }
    for (;;)
    {
      this.YG = paramBoolean1;
      if ((this.jdField_a_of_type_Jhj != null) && (!wW())) {
        q(paramBoolean1, paramLong);
      }
      return true;
      dW(paramLong);
    }
  }
  
  public void bG(ArrayList<VideoController.b> paramArrayList)
  {
    QLog.w(this.TAG, 1, "notifyAudioMemberChange");
    if (this.jdField_a_of_type_Jfm != null) {
      this.jdField_a_of_type_Jfm.bH(paramArrayList);
    }
  }
  
  public void d(iiv paramiiv)
  {
    QLog.w(this.TAG, 1, "tryRegisterMemmberChangeListener");
    paramiiv.a(this.jdField_a_of_type_Jfm);
  }
  
  public void dT(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.mApp.getCurrentAccountUin();
    int i = c("openSelfScreenShareRender", (String)localObject2, 2);
    if (i < 0)
    {
      int j = cD(0);
      if (j >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfIzm[j];
        a(paramLong, (izm)localObject1, (String)localObject2, 2, true);
      }
      i = j;
      localObject2 = localObject1;
      if (j == 0)
      {
        i = j;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          i = j;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
          {
            ((izm)localObject1).jL(false);
            localObject2 = localObject1;
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      QLog.w(this.TAG, 1, "setGlRender[openSelfScreenShareRender], index:=" + i);
      if (localObject2 != null)
      {
        ((izm)localObject2).jK(false);
        ((izm)localObject2).enableLoading(false);
        ((izm)localObject2).jO(true);
        ((izm)localObject2).setVisibility(0);
        ((izm)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = u((String)localObject2, 2);
      localObject2 = this.jdField_a_of_type_ArrayOfIzm[i];
      QLog.w(this.TAG, 1, "setGlRender[openSelfScreenShareRender], key[" + (String)localObject1 + "], index[" + i + "], forceToBigView[" + false + "], " + ((izm)localObject2).hl());
    }
  }
  
  public void dU(long paramLong)
  {
    String str = this.mApp.getCurrentAccountUin();
    int i = c("closeSelfScreenShare", str, 2);
    if (i >= 0)
    {
      str = u(str, 2);
      QLog.w(this.TAG, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + i + "], seq[" + paramLong + "]");
      dV(paramLong);
    }
  }
  
  public void dV(long paramLong)
  {
    int i = c("closeSelfScreenShareRender", this.mApp.getCurrentAccountUin(), 2);
    if (i >= 0) {
      as("closeSelfScreenShareRender", i);
    }
  }
  
  void dW(long paramLong)
  {
    ThreadManager.post(this.ci, 8, null, false);
    String str = this.mApp.getCurrentAccountUin();
    int i = c("closeSelfVideo", str, 1);
    if (i >= 0)
    {
      str = u(str, 1);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(str);
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.setGlRender(str, null);
      QLog.w(this.TAG, 1, "setGlRender[closeSelfVideo_no], key[" + str + "], index[" + i + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, true, false);
      dY(paramLong);
    }
  }
  
  public void dX(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = this.mApp.getCurrentAccountUin();
    int i = c("openSelfVideo", (String)localObject2, 1);
    if (i < 0)
    {
      i = cD(0);
      if (i >= 0)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfIzm[i];
        b(paramLong, (izm)localObject1, (String)localObject2, 1, false);
      }
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
          {
            ((izm)localObject1).jL(false);
            localObject2 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (CameraUtils.a(this.mContext).ar(paramLong)) {
          ((izm)localObject2).J(paramLong, CameraUtils.a(this.mContext).isFrontCamera());
        }
        ((izm)localObject2).jK(false);
        ((izm)localObject2).enableLoading(false);
        ((izm)localObject2).jO(true);
        ((izm)localObject2).setVisibility(0);
        ((izm)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      localObject1 = u((String)localObject2, 1);
      localObject2 = this.jdField_a_of_type_ArrayOfIzm[i];
      GraphicRenderMgr.getInstance().setGlRender((String)localObject1, ((izm)localObject2).a());
      QLog.w(this.TAG, 1, "setGlRender[openSelfVideo], key[" + (String)localObject1 + "], index[" + i + "], forceToBigView[" + false + "], " + ((izm)localObject2).hl());
    }
  }
  
  public void dY(long paramLong)
  {
    int i = c("closeSelfRender", this.mApp.getCurrentAccountUin(), 1);
    if (i >= 0) {
      as("closeSelfRender", i);
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$d != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$d.dispatchHoverEvent(paramMotionEvent));
  }
  
  public void e(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "notifyControlUIOffset, mTopOffset[" + this.mTopOffset + "->" + paramInt1 + "], mBottomOffset[" + this.ayt + "->" + paramInt2 + "], mFullScreen[" + this.YA + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.YA = paramBoolean;
    this.mTopOffset = paramInt1;
    this.ayt = paramInt2;
    jj(true);
    nf(this.mOrientation);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
    {
      paramInt1 = j;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Qw)
      {
        paramInt1 = i;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfIzm.length)
        {
          this.jdField_a_of_type_ArrayOfIzm[paramInt1].jN(true);
          paramInt1 += 1;
        }
      }
      while (paramInt1 < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].jN(true);
        paramInt1 += 1;
      }
    }
    if (this.jdField_a_of_type_Jhj != null) {
      this.jdField_a_of_type_Jhj.a(this, this.mTopOffset, this.ayt);
    }
  }
  
  AVActivity getAVActivity()
  {
    if ((this.mContext instanceof AVActivity)) {
      return (AVActivity)this.mContext;
    }
    return null;
  }
  
  public int h(float paramFloat)
  {
    int i = Math.round(paramFloat) + this.ayd;
    if (i < 0) {
      return -1;
    }
    return i / (this.axW + this.axY);
  }
  
  void h(long paramLong, String paramString, int paramInt)
  {
    int i = c("closePeerVideo", paramString, paramInt);
    if (i >= 0)
    {
      paramString = u(paramString, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString);
      localGraphicRenderMgr.setGlRender(paramString, null);
      QLog.w(this.TAG, 1, "setGlRender[closePeerVideo_no], key[" + paramString + "], index[" + i + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.b().amI, true, true);
      as("closePeerVideo", i);
    }
  }
  
  boolean h(String paramString, int paramInt)
  {
    return c("hasVideoView", paramString, paramInt) >= 0;
  }
  
  public void initLogo() {}
  
  boolean isSupport()
  {
    return irc.getGLVersion(this.mContext) == 2;
  }
  
  public void jj(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    int i = super.getWidth();
    int j = super.getHeight();
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (b(localiiv))
    {
      jdl localjdl = this.jdField_a_of_type_Jdl;
      izm[] arrayOfizm = this.jdField_a_of_type_ArrayOfIzm;
      int k = this.mPosition;
      int m = this.mTopOffset;
      int n = this.ayt;
      if (!localiiv.PT)
      {
        paramBoolean = true;
        localjdl.a(arrayOfizm, i, j, k, m, n, paramBoolean);
        ild.bz(j, i);
      }
    }
    for (;;)
    {
      super.invalidate();
      return;
      paramBoolean = false;
      break;
      if (c(localiiv))
      {
        this.jdField_a_of_type_Jdl.a(this.ayt, this.am, this.an, this.aN);
        this.jdField_a_of_type_Jdl.a(localiiv, this.jdField_a_of_type_ArrayOfIzm, i, j, paramBoolean, this.mOrientation, this.ayt);
        new iya.f(l, "layoutVideoView", 5, null).n(this.mApp);
      }
    }
  }
  
  public void kC(boolean paramBoolean)
  {
    jjb.a("switch_camera", "onCameraSwitched", 3, new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onCameraSwitched isFrontCamera: " + paramBoolean);
    }
    String str = this.mApp.getCurrentAccountUin();
    int i = c("onCameraSwitched", str, 1);
    if (i >= 0)
    {
      str = str + "_" + 1;
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(str);
      this.jdField_a_of_type_ComTencentAvVideoController.hD(true);
      this.jdField_a_of_type_ArrayOfIzm[i].jQ(false);
      this.jdField_a_of_type_ComTencentAvVideoController.a(new jfg(this, i, paramBoolean));
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType != 3000) {
        break label300;
      }
      if (!paramBoolean) {
        break label264;
      }
      anot.a(null, "CliOper", "", "", "0X80041B5", "0X80041B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().Qw)
      {
        if (!paramBoolean) {
          break;
        }
        anot.a(null, "CliOper", "", "", "0X8005211", "0X8005211", 0, 0, "", "", "", "");
      }
      return;
      label264:
      anot.a(null, "CliOper", "", "", "0X80041B4", "0X80041B4", 0, 0, "", "", "", "");
      continue;
      label300:
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1) {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10) {
            anot.a(null, "CliOper", "", "", "0X800593B", "0X800593B", 0, 0, "", "", "", "");
          } else {
            anot.a(null, "CliOper", "", "", "0X80046E2", "0X80046E2", 0, 0, "", "", "", "");
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 10) {
          anot.a(null, "CliOper", "", "", "0X800593A", "0X800593A", 0, 0, "", "", "", "");
        } else {
          anot.a(null, "CliOper", "", "", "0X80046E1", "0X80046E1", 0, 0, "", "", "", "");
        }
      }
    }
    anot.a(null, "CliOper", "", "", "0X8005210", "0X8005210", 0, 0, "", "", "", "");
  }
  
  void kD(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      avu();
    }
    TextView localTextView;
    if (this.mNameTextView != null)
    {
      localTextView = this.mNameTextView;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  void kF(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      avu();
    }
    if ((this.mNameTextView == null) || (this.mMsgTextView == null)) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mNameTextView.setTextColor(Color.parseColor("#ffffff"));
      this.mMsgTextView.setBackgroundResource(2130850823);
      return;
    }
    this.mNameTextView.setTextColor(Color.parseColor("#5f656f"));
    this.mMsgTextView.setBackgroundResource(2130850824);
  }
  
  void kn(String paramString)
  {
    if (this.jdField_a_of_type_Jdl.getStyle() != 2)
    {
      String str = this.mApp.getCurrentAccountUin();
      y("switchLocalView_" + paramString, str);
    }
  }
  
  public int lI()
  {
    return this.jdField_a_of_type_Jdl.getStyle();
  }
  
  public void lS(int paramInt)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "changeLayoutMode, screenStyle[" + this.jdField_a_of_type_ComTencentAvVideoController.b().ani + "->" + paramInt + "], ScreenLayout[" + this.jdField_a_of_type_Jdl.getStyle() + "->" + paramInt + "], seq[" + l + "]");
    super.lS(paramInt);
    int i = this.jdField_a_of_type_Jdl.getStyle();
    if (i != paramInt)
    {
      this.Yu = true;
      this.jdField_a_of_type_Jdl = jdl.a(this.mContext, this.mApp, paramInt, false);
      if (vX())
      {
        super.setBackground(null);
        super.setBackgroundColor(-15197410);
        new iya.f(l, "changeLayoutMode", 5, null).n(this.mApp);
        jj(true);
        if ((i != 3) || (paramInt != 4)) {
          break label313;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label196:
      if (i == 1)
      {
        float f1 = jll.dp2px(this.mContext, 12.0F);
        float f2 = jll.dp2px(this.mContext, 18.0F);
        i = 0;
        label227:
        if (i < this.jdField_a_of_type_ArrayOfIzm.length)
        {
          if (i == 0)
          {
            this.jdField_a_of_type_ArrayOfIzm[i].jL(false);
            this.jdField_a_of_type_ArrayOfIzm[i].setMaxLength(12);
            this.jdField_a_of_type_ArrayOfIzm[i].setTextSize(f2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfIzm[i].asU();
            i += 1;
            break label227;
            art();
            notifyEvent(Integer.valueOf(6501), null);
            break;
            if ((i == 4) && (paramInt == 3))
            {
              i = 2;
              break label196;
            }
            if (paramInt != 3) {
              break label507;
            }
            i = 3;
            break label196;
            this.jdField_a_of_type_ArrayOfIzm[i].jL(true);
            this.jdField_a_of_type_ArrayOfIzm[i].setMaxLength(12);
            this.jdField_a_of_type_ArrayOfIzm[i].setTextSize(f1);
          }
        }
      }
      label313:
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[i].jI(this.jdField_a_of_type_Jdl.vX());
        izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
        if (paramInt == 3) {}
        for (boolean bool = true;; bool = false)
        {
          localizm.jJ(bool);
          a(l, this.jdField_a_of_type_ArrayOfIzm[i]);
          i += 1;
          break;
        }
      }
      if ((this.mContext instanceof AVActivity)) {
        ((AVActivity)this.mContext).cP(l);
      }
      this.Yu = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) {
        nc(paramInt);
      }
      return;
      label507:
      i = 0;
    }
  }
  
  protected void lU(int paramInt)
  {
    this.jdField_a_of_type_Jdl.a(this.jdField_a_of_type_ArrayOfIzm, paramInt, getWidth(), getHeight(), this.mTopOffset, this.ayt);
  }
  
  void m(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      avu();
    }
    if (this.mMsgTextView != null) {
      this.mMsgTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void nc(int paramInt)
  {
    if (this.aye != paramInt) {
      this.aye = paramInt;
    }
  }
  
  void nd(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvWidgetRotateLayout == null) {
      avu();
    }
    if (this.mMsgTextView != null)
    {
      this.mMsgTextView.setMaxLines(paramInt);
      if (paramInt == 1) {
        this.mMsgTextView.setSingleLine();
      }
    }
  }
  
  public void ne(int paramInt)
  {
    this.ayl = paramInt;
  }
  
  void ng(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation != null)
    {
      this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
      jj(false);
    }
    if (!wR())
    {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = new MultiVideoOpenAnimation(paramInt);
      this.mApp.getHandler().post(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
    }
  }
  
  protected void ni(int paramInt) {}
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    igd.aJ(this.TAG, "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.l(new Object[] { paramInteger, paramObject });
  }
  
  public void onDestroy()
  {
    this.mApp.getHandler().removeCallbacks(this.cf);
    this.mApp.getHandler().removeCallbacks(this.cg);
    this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation);
    this.cf = null;
    this.cg = null;
    this.fC.clear();
    this.fC = null;
    this.jdField_a_of_type_ComTencentAvWidgetRotateLayout = null;
    this.di = null;
    this.mNameTextView = null;
    this.mMsgTextView = null;
    this.fC = null;
    a(null);
    this.jdField_b_of_type_Iqt$a = null;
    this.mGestureDetector = null;
    this.jdField_a_of_type_Ipl = null;
    this.mScaleGestureDetector = null;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI$MultiVideoOpenAnimation = null;
    avz();
    if (this.jdField_a_of_type_Jhj != null)
    {
      if ((this.mContext instanceof AVActivity))
      {
        localObject = (AVActivity)this.mContext;
        this.jdField_a_of_type_Jhj.kO(((AVActivity)localObject).Ox);
      }
      this.jdField_a_of_type_Jhj = null;
    }
    int i;
    if ((this.aye == -1) || (this.aye == 2) || (this.aye == 1))
    {
      i = 1;
      if (i == 0) {
        if (this.jdField_a_of_type_Jdl.getStyle() != 3) {
          break label296;
        }
      }
    }
    label296:
    for (Object localObject = "1";; localObject = "2")
    {
      anot.a(null, "CliOper", "", "", "0X8009F5D", "0X8009F5D", 0, 0, (String)localObject, "", "", "");
      if (this.jdField_a_of_type_Jdl != null)
      {
        this.jdField_a_of_type_Jdl.onDestroy();
        this.jdField_a_of_type_Jdl = null;
      }
      avt();
      if (this.jdField_a_of_type_Jfm != null) {
        this.jdField_a_of_type_Jfm.doDestroy();
      }
      this.aN.clear();
      super.onDestroy();
      return;
      i = 0;
      break;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onResume()
  {
    super.onResume();
    nf(this.mOrientation);
  }
  
  public void onStart()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    synchronized (this.mEventQueue)
    {
      this.mEventQueue.add(paramRunnable);
      return;
    }
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = paramAnimationTrigger;
  }
  
  boolean wS()
  {
    if ((this.mContext instanceof AVActivity))
    {
      boolean bool3 = ((AVActivity)this.mContext).vU();
      boolean bool1;
      if (!wV())
      {
        bool1 = true;
        if ((!bool3) || (!bool1)) {
          break label84;
        }
      }
      label84:
      for (boolean bool2 = true;; bool2 = false)
      {
        igd.aJ(this.TAG, "SwitchLocalToBigView:" + bool3 + "|" + bool1);
        return bool2;
        bool1 = false;
        break;
      }
    }
    return false;
  }
  
  boolean wT()
  {
    boolean bool2 = false;
    String str = this.mApp.getCurrentAccountUin();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
        if ((localizm.getVisibility() == 0) && (str.equals(localizm.getUin()))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean wU()
  {
    return (this.ayt == 0) || (this.mTopOffset == 0) || (this.mTopOffset == this.axV) || (this.YA);
  }
  
  public boolean y(String paramString1, String paramString2)
  {
    boolean bool = false;
    int i = c("setVideoToBigView", paramString2, 1);
    if (i > 0) {
      bool = L(0, i);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 1, "setVideoToBigView[" + paramString1 + "], uin[" + paramString2 + "], index[" + i + "], bRet[" + bool + "]");
    }
    return bool;
  }
  
  class LastMsgRunnable
    implements Runnable
  {
    private LastMsgRunnable() {}
    
    public void run()
    {
      if (VideoLayerUI.this.mApp != null) {
        VideoLayerUI.this.mApp.getHandler().removeCallbacks(VideoLayerUI.b(VideoLayerUI.this));
      }
      VideoLayerUI.a(VideoLayerUI.this, false);
    }
  }
  
  public class MultiVideoOpenAnimation
    implements Runnable
  {
    private int ays;
    private float mDelta;
    private int mIndex;
    
    public MultiVideoOpenAnimation(int paramInt)
    {
      this.mIndex = paramInt;
      this$1 = VideoLayerUI.this.a[this.mIndex];
      Rect localRect = VideoLayerUI.this.getBounds();
      this.mDelta = (localRect.width() / 10.0F);
      paramInt = localRect.right;
      int i = localRect.width();
      VideoLayerUI.this.layout(paramInt, localRect.top, i + paramInt, localRect.bottom);
      VideoLayerUI.this.invalidate();
    }
    
    public void run()
    {
      if (this.ays == 9) {
        VideoLayerUI.this.jj(false);
      }
      for (;;)
      {
        this.ays += 1;
        if (this.ays <= 9) {
          VideoLayerUI.this.mApp.getHandler().postDelayed(this, 30L);
        }
        return;
        izm localizm = VideoLayerUI.this.a[this.mIndex];
        Rect localRect = localizm.getBounds();
        int i = (int)(localRect.left - this.mDelta);
        int j = localRect.width();
        localizm.layout(i, localRect.top, j + i, localRect.bottom);
        localizm.invalidate();
      }
    }
  }
  
  class NewMsgRunnable
    implements Runnable
  {
    private NewMsgRunnable() {}
    
    public void run()
    {
      if (VideoLayerUI.this.mApp == null) {
        return;
      }
      if (VideoLayerUI.a(VideoLayerUI.this).size() > 0)
      {
        VideoLayerUI.this.mApp.getHandler().removeCallbacks(VideoLayerUI.a(VideoLayerUI.this));
        VideoLayerUI.this.mApp.getHandler().removeCallbacks(VideoLayerUI.b(VideoLayerUI.this));
        RecvMsg localRecvMsg = (RecvMsg)VideoLayerUI.a(VideoLayerUI.this).remove(0);
        VideoLayerUI.a(VideoLayerUI.this, localRecvMsg);
        VideoLayerUI.this.mApp.getHandler().postDelayed(VideoLayerUI.a(VideoLayerUI.this), 3000L);
        VideoLayerUI.this.mApp.getHandler().postDelayed(VideoLayerUI.b(VideoLayerUI.this), 3000L);
        return;
      }
      VideoLayerUI.this.mApp.getHandler().removeCallbacks(VideoLayerUI.a(VideoLayerUI.this));
    }
  }
  
  public class a
    extends GestureDetector.SimpleOnGestureListener
  {
    public a() {}
    
    public boolean onDoubleTap(MotionEvent arg1)
    {
      int i;
      int j;
      if ((VideoLayerUI.this.mTargetIndex == 0) && ((VideoLayerUI.this.ayt == 0) || (VideoLayerUI.this.mTopOffset == 0)) && (2 == VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].getVideoSrcType()) && (!VideoLayerUIBase.c(VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b())))
      {
        i = (int)???.getX();
        j = (int)???.getY();
        float f = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].getScale();
        ??? = VideoLayerUI.this;
        ???.axw += 1;
        if (VideoLayerUI.this.axw % 2 == 1)
        {
          f = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].ac() / f;
          VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].a(f, i, j);
        }
        for (;;)
        {
          return true;
          f = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].ab() / f;
          i = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].getWidth() / 2;
          j = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].getHeight() / 2;
          VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].a(f, i, j);
          VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].g(i, j, true);
        }
      }
      if ((VideoLayerUI.this.jdField_a_of_type_Jdl != null) && (VideoLayerUI.this.jdField_a_of_type_Jdl.getStyle() == 3))
      {
        Object localObject1;
        Object localObject3;
        if (QLog.isColorLevel())
        {
          ??? = VideoLayerUI.this.TAG;
          localObject1 = new StringBuilder().append("GestureListener-->onDoubleTap in STYLE_MULTI_GRID_SCREEN  Index=").append(VideoLayerUI.this.mTargetIndex).append(",visibility:=");
          localObject3 = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm;
          if (VideoLayerUI.this.mTargetIndex >= 0) {
            break label420;
          }
        }
        label420:
        for (i = 0;; i = VideoLayerUI.this.mTargetIndex)
        {
          QLog.d(???, 2, localObject3[i].getVisibility());
          if ((VideoLayerUI.c(VideoLayerUI.this)) && (VideoLayerUI.this.mTargetIndex != -1) && (VideoLayerUI.this.mTargetIndex < VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length) && (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[VideoLayerUI.this.mTargetIndex].getVisibility() != 1) && (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0)) {
            break;
          }
          return true;
        }
        if (VideoLayerUI.this.mTargetIndex != 0)
        {
          long l = Long.parseLong(VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[VideoLayerUI.this.mTargetIndex].getUin());
          j = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[VideoLayerUI.this.mTargetIndex].getVideoSrcType();
          localObject1 = (ioa)VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0);
          i = 0;
          if (i < VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size())
          {
            localObject3 = (ioa)VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(i);
            if ((l != ((ioa)localObject3).uin) || (j != ((ioa)localObject3).videoSrcType)) {
              break label759;
            }
            ((ioa)localObject1).Tp = false;
            ((ioa)localObject3).Tp = true;
            VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.set(0, localObject3);
            VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.set(i, localObject1);
          }
        }
        for (;;)
        {
          synchronized (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().ig)
          {
            VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().ig.set(0, localObject3);
            VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().ig.set(i, localObject1);
            VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().amI();
            VideoLayerUI.this.l("onDoubleTap", 0, VideoLayerUI.this.mTargetIndex);
            anot.a(null, "CliOper", "", "", "0X8009F61", "0X8009F61", 0, 0, "", "", "", "");
            ((AVActivity)VideoLayerUI.this.mContext).G(4, false);
            return true;
          }
          label759:
          i += 1;
          break;
          if ((VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0) && (!((ioa)VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tp))
          {
            ((ioa)VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.get(0)).Tp = true;
            if (QLog.isColorLevel()) {
              QLog.d(VideoLayerUI.this.TAG, 2, "VideoUiLayer onLayoutModeChange --> displayList  not has big one");
            }
          }
        }
      }
      if ((VideoLayerUI.this.jdField_a_of_type_Jdl != null) && (VideoLayerUI.this.jdField_a_of_type_Jdl.getStyle() == 4))
      {
        if (!VideoLayerUI.c(VideoLayerUI.this)) {
          return true;
        }
        anot.a(null, "CliOper", "", "", "0X8009F60", "0X8009F60", 0, 0, "", "", "", "");
        ((AVActivity)VideoLayerUI.this.mContext).G(3, false);
      }
      return super.onDoubleTap(???);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((VideoLayerUI.this.mApp == null) || (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController == null) || (paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return false;
      }
      if (VideoLayerUI.this.pb > paramMotionEvent2.getDownTime()) {}
      for (boolean bool3 = true; bool3; bool3 = false)
      {
        QLog.w(VideoLayerUI.this.TAG, 1, "onFling, lastHandledEventTime[" + VideoLayerUI.this.pb + "], e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "]");
        return false;
      }
      AVActivity localAVActivity = VideoLayerUI.this.getAVActivity();
      if ((localAVActivity == null) || (localAVActivity.mControlUI == null) || (localAVActivity.mControlUI.a() == null) || (localAVActivity.jdField_a_of_type_Jgg == null)) {
        return false;
      }
      boolean bool8 = localAVActivity.mControlUI.wH();
      int i;
      int j;
      label209:
      boolean bool1;
      int k;
      label252:
      long l;
      label270:
      label281:
      label309:
      float f1;
      float f2;
      if (!localAVActivity.jdField_a_of_type_Jgg.xj())
      {
        i = 1;
        iiv localiiv = localAVActivity.jdField_a_of_type_ComTencentAvVideoController.b();
        if (localiiv.amI != 4) {
          break label613;
        }
        j = 1;
        bool1 = localAVActivity.mControlUI instanceof DoubleVideoMeetingCtrlUI;
        if ((!VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].WC) && (!VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[1].WC)) {
          break label619;
        }
        k = 1;
        if ((j == 0) || (!bool1) || (k == 0)) {
          break label625;
        }
        j = 1;
        if (localiiv.sW()) {
          break label631;
        }
        k = 1;
        if ((localAVActivity.mControlUI.a().cC(2)) || (j != 0) || (k == 0)) {
          break label637;
        }
        j = 1;
        l = AudioHelper.hG();
        f1 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
        f2 = Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY());
        if (f1 >= f2) {
          break label655;
        }
        if (paramMotionEvent1.getY() - paramMotionEvent2.getY() < VideoLayerUI.this.ayg) {
          break label643;
        }
        bool1 = true;
        label374:
        if (paramMotionEvent2.getY() - paramMotionEvent1.getY() < VideoLayerUI.this.ayg) {
          break label649;
        }
      }
      boolean bool5;
      boolean bool4;
      label643:
      label649:
      for (boolean bool2 = true;; bool2 = false)
      {
        boolean bool6 = false;
        boolean bool7 = false;
        bool5 = bool1;
        bool4 = bool2;
        bool2 = bool6;
        bool1 = bool7;
        QLog.w(VideoLayerUI.this.TAG, 1, "onFling, e1[" + paramMotionEvent1 + "], e2[" + paramMotionEvent2 + "], velocityX[" + paramFloat1 + "], velocityY[" + paramFloat2 + "], xOffset[" + f1 + "], yOffset[" + f2 + "], up[" + bool5 + "], down[" + bool4 + "], left[" + bool1 + "], right[" + bool2 + "], handle[" + bool3 + "], lastHandledEventTime[" + VideoLayerUI.this.pb + "], seq[" + l + "]");
        if ((bool8) || ((!bool5) && (!bool4))) {
          break label724;
        }
        return false;
        i = 0;
        break;
        label613:
        j = 0;
        break label209;
        label619:
        k = 0;
        break label252;
        label625:
        j = 0;
        break label270;
        label631:
        k = 0;
        break label281;
        label637:
        j = 0;
        break label309;
        bool1 = false;
        break label374;
      }
      label655:
      if (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= VideoLayerUI.this.ayg)
      {
        bool1 = true;
        label679:
        if (paramMotionEvent2.getX() - paramMotionEvent1.getX() < VideoLayerUI.this.ayg) {
          break label718;
        }
      }
      label718:
      for (bool2 = true;; bool2 = false)
      {
        bool4 = false;
        bool5 = false;
        break;
        bool1 = false;
        break label679;
      }
      label724:
      if ((bool5) && (i != 0))
      {
        if ((localAVActivity.mControlUI.a().cC(0)) && (localAVActivity.mControlUI.aE(l)))
        {
          jjk.c.S(true);
          localAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, localAVActivity, 0, 0);
          localAVActivity.mControlUI.a().L(l, -1);
          return true;
        }
      }
      else if ((bool4) && (i != 0))
      {
        if (localAVActivity.mControlUI.a().cC(2))
        {
          jjk.c.S(false);
          localAVActivity.mControlUI.a().c(l, 0, true);
          return true;
        }
      }
      else
      {
        if ((!bool2) || (j == 0)) {
          break label869;
        }
        localAVActivity.jdField_a_of_type_Jgg.nw(1);
        ily.report("0X800A8D2");
      }
      for (;;)
      {
        return false;
        label869:
        if ((bool1) && (j != 0))
        {
          localAVActivity.mControlUI.a().c(l, 0, false);
          localAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(l, localAVActivity, 0, 1);
          localAVActivity.jdField_a_of_type_Jgg.nt(2);
          if (!bool8) {
            localAVActivity.mControlUI.auZ();
          }
          ily.report("0X800A8D1");
        }
      }
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((VideoLayerUI.this.mApp == null) || (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController == null)) {
        bool1 = false;
      }
      long l;
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
                do
                {
                  boolean bool3;
                  do
                  {
                    do
                    {
                      return bool1;
                      try
                      {
                        l = AudioHelper.hG();
                        bool1 = VideoLayerUI.this.vX();
                        bool3 = VideoLayerUI.this.wU();
                        if (QLog.isColorLevel()) {
                          QLog.w(VideoLayerUI.this.TAG, 1, "onSingleTapConfirmed, mTargetIndex[" + VideoLayerUI.this.mTargetIndex + "], isDoubleScreen[" + bool1 + "], canMove[" + bool3 + "], seq[" + l + "]");
                        }
                        if ((!VideoLayerUI.b(VideoLayerUI.this)) && (VideoLayerUI.this.mTargetIndex > 0) && (!bool1)) {
                          break;
                        }
                        VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
                        return true;
                      }
                      catch (Exception paramMotionEvent)
                      {
                        bool1 = bool2;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.e(VideoLayerUI.this.TAG, 2, "onSingleTapConfirmed --> Exception = " + paramMotionEvent);
                    return true;
                    if (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 2) {
                      break;
                    }
                    bool1 = bool2;
                  } while (!VideoLayerUI.this.jdField_a_of_type_Jdl.wD());
                  VideoLayerUI.this.L(0, VideoLayerUI.this.mTargetIndex);
                  return true;
                  if (!bool3) {
                    break;
                  }
                  bool1 = bool2;
                } while (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm == null);
                bool1 = bool2;
              } while (VideoLayerUI.this.mTargetIndex <= 0);
              bool1 = bool2;
            } while (VideoLayerUI.this.mTargetIndex >= VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length);
            if (!VideoLayerUI.this.jdField_a_of_type_Jdl.wD()) {
              break;
            }
            localObject = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0];
            paramMotionEvent = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[VideoLayerUI.this.mTargetIndex];
            bool1 = bool2;
          } while (localObject == null);
          bool1 = bool2;
        } while (paramMotionEvent == null);
        String str = ((izm)localObject).getUin();
        int i = Integer.valueOf(((izm)localObject).getVideoSrcType()).intValue();
        Object localObject = paramMotionEvent.getUin();
        int j = Integer.valueOf(paramMotionEvent.getVideoSrcType()).intValue();
        VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), localObject, Integer.valueOf(j) });
        return true;
        bool1 = bool2;
      } while (VideoLayerUI.this.jdField_a_of_type_Jdl.getStyle() != 3);
      VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
      return true;
      VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
      return true;
    }
  }
  
  class b
    implements ipl.a
  {
    private int endX;
    private int endY;
    private int startPosition;
    private int startX;
    private int startY;
    
    private b() {}
    
    public void a(ipl paramipl)
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoLayerUI.this.TAG, 2, "onMoveEnd");
      }
      if (VideoLayerUI.this.jdField_a_of_type_Jdl.getStyle() == 2) {
        return;
      }
      PointF localPointF = paramipl.getFocusDelta();
      int i = (int)localPointF.x;
      int j = (int)localPointF.y;
      if (VideoLayerUI.this.mTargetIndex == 0) {
        VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].g(i, j, true);
      }
      for (;;)
      {
        ild.ij(false);
        VideoLayerUI.this.notifyEvent(Integer.valueOf(6503), Boolean.valueOf(false));
        return;
        if ((VideoLayerUI.this.mTargetIndex == 1) && (VideoLayerUI.this.wU()))
        {
          VideoLayerUI.this.cb(i, j);
          this.endX = ((int)paramipl.getFocusX());
          this.endY = ((int)paramipl.getFocusY());
          VideoLayerUI.this.mPosition = VideoLayerUI.this.b(this.startPosition, this.startX, this.startY, this.endX, this.endY);
          VideoLayerUI.this.nj(VideoLayerUI.this.mPosition);
        }
      }
    }
    
    public boolean a(ipl paramipl)
    {
      if (VideoLayerUI.this.jdField_a_of_type_Jdl.getStyle() == 2) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(VideoLayerUI.this.TAG, 2, "onMove");
      }
      paramipl = paramipl.getFocusDelta();
      int i = (int)paramipl.x;
      int j = (int)paramipl.y;
      if (VideoLayerUI.this.mTargetIndex == 0) {
        VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].g(i, j, false);
      }
      for (;;)
      {
        return true;
        if ((VideoLayerUI.this.mTargetIndex == 1) && (VideoLayerUI.this.wU()))
        {
          if ((Math.abs(i) > 5) || (Math.abs(j) > 5)) {
            VideoLayerUI.b(VideoLayerUI.this, true);
          }
          VideoLayerUI.this.cb(i, j);
        }
      }
    }
    
    public boolean b(ipl paramipl)
    {
      if (VideoLayerUI.this.mTargetIndex == 0)
      {
        paramipl = paramipl.getFocusDelta();
        int i = (int)paramipl.x;
        int j = (int)paramipl.y;
        VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].g(i, j, false);
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.w(VideoLayerUI.this.TAG, 1, "onMoveBegin, mTargetIndex[" + VideoLayerUI.this.mTargetIndex + "], startX[" + this.startX + "], startY[" + this.startY + "], startPosition[" + this.startPosition + "], mTopOffset[" + VideoLayerUI.this.mTopOffset + "], mBottomOffset[" + VideoLayerUI.this.ayt + "], mRecordCtrlBottom[" + VideoLayerUI.this.axV + "]");
          QLog.d(VideoLayerUI.this.TAG, 2, "onMoveBegin");
        }
        ild.ij(true);
        VideoLayerUI.this.notifyEvent(Integer.valueOf(6503), Boolean.valueOf(true));
        return true;
        if ((VideoLayerUI.this.mTargetIndex == 1) && (VideoLayerUI.this.wU()))
        {
          this.startX = ((int)paramipl.getFocusX());
          this.startY = ((int)paramipl.getFocusY());
          this.startPosition = VideoLayerUI.this.mp();
        }
      }
    }
  }
  
  class c
    implements Animation.AnimationListener
  {
    private c() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      VideoLayerUI.a(VideoLayerUI.this).setVisibility(4);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class d
    extends ExploreByTouchHelper
  {
    public d(View paramView)
    {
      super();
    }
    
    private String aU(int paramInt)
    {
      if ((VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm != null) && (paramInt >= 0) && (paramInt < VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length))
      {
        int i = -1;
        int j = VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().uinType;
        if (j == 3000) {
          i = 1004;
        }
        Resources localResources;
        String str2;
        for (;;)
        {
          localResources = VideoLayerUI.this.mContext.getApplicationContext().getResources();
          String str1 = VideoLayerUI.this.mApp.getCurrentAccountUin();
          str2 = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[paramInt].getUin();
          if (str2 == null) {
            break label214;
          }
          if (!str2.equals(str1)) {
            break;
          }
          return localResources.getString(2131696176) + localResources.getString(2131697754);
          if (j == 1) {
            i = 1000;
          } else if (j == 0) {
            i = 0;
          }
        }
        return VideoLayerUI.this.mApp.getDisplayName(i, str2, String.valueOf(VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().ll)) + localResources.getString(2131697754);
      }
      label214:
      return "";
    }
    
    private Rect getBoundsForIndex(int paramInt)
    {
      Rect localRect = new Rect(0, 0, 1, 1);
      if ((VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm != null) && (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[paramInt].getVisibility() == 0)) {
        localRect.set(VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[paramInt].getBounds());
      }
      return localRect;
    }
    
    public int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      if (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm != null)
      {
        int i = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length - 1;
        while (i >= 0)
        {
          if ((VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[i].getVisibility() == 0) && (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[i].getBounds().contains((int)paramFloat1, (int)paramFloat2))) {
            return i;
          }
          i -= 1;
        }
      }
      return 0;
    }
    
    public void getVisibleVirtualViews(List<Integer> paramList)
    {
      if (VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm != null)
      {
        int j = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length;
        int i = 0;
        while (i < j)
        {
          paramList.add(Integer.valueOf(i));
          i += 1;
        }
      }
    }
    
    public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return false;
    }
    
    public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
    {
      paramAccessibilityEvent.setContentDescription(aU(paramInt));
    }
    
    public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramAccessibilityNodeInfoCompat.setContentDescription(aU(paramInt));
      Rect localRect = getBoundsForIndex(paramInt);
      if (localRect.isEmpty()) {
        localRect.set(0, 0, 1, 1);
      }
      paramAccessibilityNodeInfoCompat.setBoundsInParent(localRect);
    }
  }
  
  class e
    implements GestureDetector.OnGestureListener
  {
    private boolean YD;
    private long gB = -1L;
    
    private e() {}
    
    private void kG(boolean paramBoolean)
    {
      if (!this.YD) {
        return;
      }
      this.YD = false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      kG(false);
      int i = VideoLayerUI.e(VideoLayerUI.this);
      if (i == 0) {
        return false;
      }
      VideoLayerUI.a(VideoLayerUI.this).z((int)-paramFloat1, 0, i);
      VideoLayerUI.this.invalidate();
      VideoLayerUI.a(VideoLayerUI.this, -1000L);
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      kG(true);
      if (VideoLayerUI.d(VideoLayerUI.this)) {}
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      kG(false);
      VideoLayerUI.a(VideoLayerUI.this).f(Math.round(paramFloat1), 0, VideoLayerUI.e(VideoLayerUI.this));
      VideoLayerUI.this.invalidate();
      VideoLayerUI.a(VideoLayerUI.this, -1001L);
      long l = System.currentTimeMillis();
      if (l - this.gB > 100L)
      {
        anot.a(null, "CliOper", "", "", "0X8009F62", "0X8009F62", 0, 0, "", "", "", "");
        this.gB = l;
      }
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      if (this.YD) {
        return;
      }
      if (VideoLayerUI.this.h(paramMotionEvent.getX()) != -1)
      {
        this.YD = true;
        return;
      }
      QLog.d(VideoLayerUI.this.TAG, 1, "error condition print onShowPress");
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      kG(false);
      VideoLayerUI.a(VideoLayerUI.this, -1002L);
      if ((VideoLayerUI.d(VideoLayerUI.this)) || (!VideoLayerUI.c(VideoLayerUI.this))) {
        return true;
      }
      int j = VideoLayerUI.this.h(paramMotionEvent.getX());
      int k;
      Object localObject1;
      int i;
      label270:
      label276:
      Object localObject2;
      if (VideoLayerUI.e(VideoLayerUI.this))
      {
        if (j == -1) {
          return true;
        }
        paramMotionEvent = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0];
        String str = paramMotionEvent.getUin();
        k = paramMotionEvent.getVideoSrcType();
        if (TextUtils.isEmpty(str))
        {
          QLog.d(VideoLayerUI.this.TAG, 1, "onSingleTapUp with empty UIN");
          return true;
        }
        localObject1 = VideoLayerUI.a(VideoLayerUI.this).aT();
        if (((ArrayList)localObject1).size() > VideoLayerUI.f(VideoLayerUI.this))
        {
          i = 1;
          if ((j != VideoLayerUI.f(VideoLayerUI.this) - 2) || (i == 0)) {
            break label276;
          }
          anot.a(null, "CliOper", "", "", "0X800A069", "0X800A069", 0, 0, "", "", "", "");
          paramMotionEvent = (AVActivity)VideoLayerUI.this.mContext;
          if ((!VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().QO) && (!VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().QP)) {
            break label270;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          VideoMsgTools.a(paramMotionEvent, String.valueOf(VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().ll), bool1, true);
          QLog.d(VideoLayerUI.this.TAG, 1, "onSingleTapUp jumpTo lists");
          return true;
          i = 0;
          break;
        }
        if (j + 1 > ((ArrayList)localObject1).size() - 1)
        {
          QLog.d(VideoLayerUI.this.TAG, 1, "onSingleTapUp ArrayOutOfList");
          return true;
        }
        localObject2 = (jfj)((ArrayList)localObject1).get(j + 1);
        boolean bool2;
        if (localObject2 != null)
        {
          bool2 = ((jfj)localObject2).xb();
          if (localObject2 == null) {
            break label761;
          }
          if ((!str.equalsIgnoreCase(String.valueOf(((jfj)localObject2).uin))) || (((jfj)localObject2).getVideoSrcType() != k)) {
            break label755;
          }
          bool1 = true;
          label363:
          if (QLog.isColorLevel()) {
            QLog.i(VideoLayerUI.this.TAG, 2, "onSingleTapUp, isVideoIn[" + bool2 + "], isSame[" + bool1 + "], uin[" + str + "], currentSelect[" + localObject2 + "], index[" + j + "]");
          }
          label670:
          label689:
          if ((localObject2 != null) && (!bool1))
          {
            bool1 = VideoLayerUI.this.jdField_a_of_type_Jdl.wD();
            if ((!bool1) || (!bool2)) {
              break label767;
            }
            anot.a(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
            str = paramMotionEvent.getUin();
            i = Integer.valueOf(paramMotionEvent.getVideoSrcType()).intValue();
            long l = ((jfj)localObject2).uin;
            k = Integer.valueOf(((jfj)localObject2).getVideoSrcType()).intValue();
            VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(115), str, Integer.valueOf(i), String.valueOf(l), Integer.valueOf(k) });
            QLog.d(VideoLayerUI.this.TAG, 1, "onSingleTapUp mTargetIndex:=" + j + ";Numberlist:=" + ((ArrayList)localObject1).size());
            label635:
            if (!bool2)
            {
              if (!((jfj)localObject2).wZ()) {
                break label848;
              }
              if (((jfj)localObject2).getUin() != VideoLayerUI.this.mApp.getLongAccountUin()) {
                break label825;
              }
              bool1 = true;
              if (!bool1) {
                break label831;
              }
              iwu.b(VideoLayerUI.this.mApp, 1051);
              QLog.d(VideoLayerUI.this.TAG, 1, "not open camera isSelfUin:=" + bool1);
            }
          }
        }
        for (;;)
        {
          anot.a(null, "CliOper", "", "", "0X800A068", "0X800A068", 0, 0, "", "", "", "");
          return true;
          bool2 = false;
          break;
          label755:
          bool1 = false;
          break label363;
          label761:
          bool1 = false;
          break label363;
          label767:
          if (!QLog.isColorLevel()) {
            break label635;
          }
          QLog.i(VideoLayerUI.this.TAG, 2, "onSingleTapUp, canSwitchView[" + bool1 + "], isVideoIn[" + bool2 + "]");
          break label635;
          label825:
          bool1 = false;
          break label670;
          label831:
          iwu.b(VideoLayerUI.this.mApp, 1052);
          break label689;
          label848:
          iwu.b(VideoLayerUI.this.mApp, 1053);
          QLog.d(VideoLayerUI.this.TAG, 1, "not attend video talking");
        }
      }
      if (j != -1)
      {
        i = j + 1;
        if ((VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm == null) || (i <= 0) || (i >= VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm.length)) {
          return true;
        }
        localObject2 = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0];
        paramMotionEvent = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[i];
        if ((localObject2 == null) || (paramMotionEvent == null)) {
          return true;
        }
        if (VideoLayerUI.this.jdField_a_of_type_Jdl.wD())
        {
          anot.a(null, "CliOper", "", "", "0X8009F63", "0X8009F63", 0, 0, "", "", "", "");
          localObject1 = ((izm)localObject2).getUin();
          j = Integer.valueOf(((izm)localObject2).getVideoSrcType()).intValue();
          localObject2 = paramMotionEvent.getUin();
          k = Integer.valueOf(paramMotionEvent.getVideoSrcType()).intValue();
          VideoLayerUI.this.mApp.l(new Object[] { Integer.valueOf(115), localObject1, Integer.valueOf(j), localObject2, Integer.valueOf(k) });
        }
        if (VideoLayerUI.a(VideoLayerUI.this) != null) {
          VideoLayerUI.a(VideoLayerUI.this).ls(i);
        }
        QLog.d(VideoLayerUI.this.TAG, 1, "condition print onSingleTapUp mTargetIndex:=" + VideoLayerUI.this.mTargetIndex + ",canSwitchView=" + VideoLayerUI.this.jdField_a_of_type_Jdl.wD());
      }
      for (;;)
      {
        return true;
        QLog.d(VideoLayerUI.this.TAG, 1, "error condition print onSingleTapUp");
      }
    }
  }
  
  public class f
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    public f() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoLayerUI.this.TAG, 2, "onScale");
      }
      if (VideoLayerUI.c(VideoLayerUI.this) < 0) {
        VideoLayerUI.a(VideoLayerUI.this, (int)paramScaleGestureDetector.getFocusX());
      }
      if (VideoLayerUI.d(VideoLayerUI.this) < 0) {
        VideoLayerUI.b(VideoLayerUI.this, (int)paramScaleGestureDetector.getFocusY());
      }
      float f = paramScaleGestureDetector.getScaleFactor();
      VideoLayerUI.this.a[0].a(f, VideoLayerUI.c(VideoLayerUI.this), VideoLayerUI.d(VideoLayerUI.this));
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoLayerUI.this.TAG, 2, "onScaleEnd");
      }
      float f1 = VideoLayerUI.this.a[0].getScale();
      float f2 = VideoLayerUI.this.a[0].ab();
      float f3 = VideoLayerUI.this.a[0].ac();
      if (f1 < f2) {
        VideoLayerUI.a(VideoLayerUI.this, VideoLayerUI.this.a[0], f2 / f1, 60L);
      }
      while (f1 <= f3) {
        return;
      }
      VideoLayerUI.a(VideoLayerUI.this, VideoLayerUI.this.a[0], f3 / f1, 60L);
    }
  }
  
  public class g
    implements iqt.a
  {
    private boolean YE;
    private boolean YF;
    private float downX;
    private float downY;
    private long pd;
    
    public g() {}
    
    public boolean a(iqt paramiqt, MotionEvent paramMotionEvent)
    {
      boolean bool = b(paramiqt, paramMotionEvent);
      if (paramMotionEvent.getAction() == 1) {
        VideoLayerUI.this.pb = 0L;
      }
      return bool;
    }
    
    boolean b(iqt paramiqt, MotionEvent paramMotionEvent)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((paramiqt == null) || (paramMotionEvent == null) || (VideoLayerUI.this.mApp == null) || (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController == null)) {
        bool1 = false;
      }
      label438:
      label459:
      label486:
      label998:
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
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool2;
                  } while (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().amU == 1);
                  if (paramMotionEvent.getAction() == 0)
                  {
                    this.downX = 0.0F;
                    this.downY = 0.0F;
                    this.pd = System.currentTimeMillis();
                    this.downX = paramMotionEvent.getX();
                    this.downY = paramMotionEvent.getY();
                    if (QLog.isColorLevel()) {
                      QLog.e(VideoLayerUI.this.TAG, 2, "[childLock] touch onDown: " + this.downX + " x " + this.downY + " ==========");
                    }
                    if (!VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().Ql) {
                      break label438;
                    }
                    VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.arQ();
                  }
                  for (;;)
                  {
                    this.YE = false;
                    this.YF = false;
                    if ((!VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().Ql) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.downX) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.downY) > 70.0F)))))
                    {
                      VideoLayerUI.this.mApp.getHandler().removeCallbacks(VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger);
                      if ((VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null) && (VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.vZ()))
                      {
                        if (paramMotionEvent.getAction() == 1) {
                          VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.cancel();
                        }
                        if (QLog.isColorLevel()) {
                          QLog.e(VideoLayerUI.this.TAG, 2, "[childLock] cancel animation");
                        }
                      }
                      if (QLog.isColorLevel()) {
                        QLog.e(VideoLayerUI.this.TAG, 2, "[childLock] touch end ==========");
                      }
                    }
                    if (!VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().Ql) {
                      break label459;
                    }
                    bool1 = bool2;
                    if (paramMotionEvent.getAction() != 1) {
                      break;
                    }
                    bool1 = bool2;
                    if (System.currentTimeMillis() - this.pd >= 200L) {
                      break;
                    }
                    bool1 = bool2;
                    if (VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger == null) {
                      break;
                    }
                    VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.arR();
                    return true;
                    VideoLayerUI.this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.u(this.downX, this.downY);
                  }
                  VideoLayerUI.this.mTargetIndex = -1;
                  izm[] arrayOfizm = VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm;
                  int k = arrayOfizm.length;
                  int i = 0;
                  int j = 0;
                  if (i < k)
                  {
                    if (paramiqt == arrayOfizm[i]) {
                      VideoLayerUI.this.mTargetIndex = j;
                    }
                  }
                  else if ((VideoLayerUI.b(VideoLayerUI.this)) && (VideoLayerUI.a(VideoLayerUI.this) != null) && (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController != null) && (VideoLayerUIBase.c(VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b())) && (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if != null) && (VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.size() > 0))
                  {
                    i = (int)paramMotionEvent.getX();
                    j = (int)paramMotionEvent.getY();
                    if ((paramMotionEvent.getAction() == 0) && (VideoLayerUI.a(VideoLayerUI.this).contains(i, j)))
                    {
                      VideoLayerUI.this.pb = paramMotionEvent.getEventTime();
                      this.YE = true;
                    }
                    if (this.YE == true)
                    {
                      if (!VideoLayerUI.a(VideoLayerUI.this).contains(i, j)) {
                        break label950;
                      }
                      VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramMotionEvent);
                      switch (paramMotionEvent.getAction())
                      {
                      }
                    }
                  }
                  for (;;)
                  {
                    if ((VideoLayerUI.this.gM != null) && (VideoLayerUI.this.gM.getVisibility() == 0)) {
                      VideoLayerUI.this.mTargetIndex = 0;
                    }
                    if ((VideoLayerUI.this.mGestureDetector != null) && (!this.YE)) {
                      VideoLayerUI.this.mGestureDetector.onTouchEvent(paramMotionEvent);
                    }
                    if (!VideoLayerUIBase.b(VideoLayerUI.this.jdField_a_of_type_ComTencentAvVideoController.b())) {
                      break label998;
                    }
                    bool1 = bool2;
                    if (VideoLayerUI.this.mTargetIndex != 1) {
                      break;
                    }
                    bool1 = bool2;
                    if (VideoLayerUI.a(VideoLayerUI.this) == null) {
                      break;
                    }
                    if ((!VideoLayerUI.a(VideoLayerUI.this).isInProgress()) && (paramMotionEvent.getAction() != 0))
                    {
                      paramiqt = MotionEvent.obtain(paramMotionEvent);
                      paramiqt.setAction(0);
                      VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramiqt);
                      paramiqt.recycle();
                    }
                    VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramMotionEvent);
                    VideoLayerUI.this.pb = paramMotionEvent.getEventTime();
                    return true;
                    j += 1;
                    i += 1;
                    break label486;
                    paramiqt = VideoLayerUI.this;
                    if (!VideoLayerUI.a(VideoLayerUI.this).isFinished()) {}
                    for (bool1 = true;; bool1 = false)
                    {
                      VideoLayerUI.c(paramiqt, bool1);
                      VideoLayerUI.a(VideoLayerUI.this).apC();
                      break;
                    }
                    VideoLayerUI.this.invalidate();
                    continue;
                    if (!this.YF)
                    {
                      paramiqt = MotionEvent.obtain(paramMotionEvent);
                      paramiqt.setAction(3);
                      VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramiqt);
                      this.YF = true;
                      VideoLayerUI.this.pb = paramMotionEvent.getEventTime();
                    }
                  }
                  bool1 = bool2;
                } while (VideoLayerUI.this.mTargetIndex != 0);
                if (VideoLayerUI.this.ayt == 0) {
                  break;
                }
                bool1 = bool2;
              } while (VideoLayerUI.this.mTopOffset != 0);
              bool1 = bool2;
            } while (2 != VideoLayerUI.this.jdField_a_of_type_ArrayOfIzm[0].getVideoSrcType());
            bool1 = bool2;
          } while (VideoLayerUI.a(VideoLayerUI.this) == null);
          VideoLayerUI.this.pb = paramMotionEvent.getEventTime();
          VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramMotionEvent);
          bool1 = bool2;
        } while (VideoLayerUI.a(VideoLayerUI.this).isInProgress());
        bool1 = bool2;
      } while (VideoLayerUI.a(VideoLayerUI.this) == null);
      label950:
      VideoLayerUI.a(VideoLayerUI.this).onTouchEvent(paramMotionEvent);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI
 * JD-Core Version:    0.7.0.1
 */