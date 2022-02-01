package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import anot;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import iiv;
import ije;
import ijv;
import iog;
import ioh;
import iop;
import ipm;
import ipn;
import iqt;
import iqu;
import iwo;
import iya;
import iya.e;
import izm;
import izp;
import java.lang.ref.WeakReference;
import java.util.BitSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jdh;
import jdl;
import jdt;
import jgl;
import jll;
import mqq.os.MqqHandler;
import wja;

public class VideoLayerUIBase
  extends iqu
{
  public final String TAG = getClass().getSimpleName() + "_" + AudioHelper.hG();
  protected boolean YG;
  protected boolean YH;
  private boolean YI;
  private boolean YJ;
  protected VideoController a;
  protected a a;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private iwo jdField_a_of_type_Iwo;
  protected jdl a;
  protected jdt a;
  jgl jdField_a_of_type_Jgl = null;
  public izm[] a;
  private float[] ag;
  private Rect ao = new Rect();
  protected int axw;
  protected int ayt;
  protected GLRootView b;
  private jdh b;
  protected Runnable ch = new VideoLayerUIBase.1(this);
  protected Runnable ci = new VideoLayerUIBase.2(this);
  private TextureRender d;
  protected izm e;
  protected ImageView gM;
  public VideoAppInterface mApp;
  protected int mCacheRotation;
  protected Context mContext;
  private boolean mDestroyed;
  protected Display mDisplay;
  protected int mOrientation;
  protected int mPosition = 2;
  public View mRootView;
  protected int mRotation;
  public int mTargetIndex = -1;
  protected int mTopOffset;
  long pe = 0L;
  
  public VideoLayerUIBase(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramContext);
    QLog.d(this.TAG, 1, "onCreate:" + this + ", VideoAppInterface:" + paramVideoAppInterface + ", rootView:" + paramView);
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    this.mContext = paramContext;
    this.mRootView = paramView;
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.gM = ((ImageView)this.mRootView.findViewById(2131363161));
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$a = new a(this);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$a);
  }
  
  public static boolean b(iiv paramiiv)
  {
    return (paramiiv.amI == 1) || (paramiiv.amI == 2);
  }
  
  public static boolean c(iiv paramiiv)
  {
    return (paramiiv.amI == 3) || (paramiiv.amI == 4);
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    default: 
      b(paramObservable, paramObject);
    }
    label154:
    label158:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramObservable = (iya.e)iya.a(arrayOfObject);
          paramObject = (FaceItem)((ijv)this.mApp.a(3)).a(paramObservable.mId);
          int i;
          if ((paramObject != null) && (paramObject.isInCreative()))
          {
            i = 1;
            if ((paramObject == null) || (!paramObject.isInteract())) {
              break label154;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((!vX()) && (j != 0) && (i == 0)) {
              break label158;
            }
            avD();
            this.jdField_a_of_type_Jgl.a(paramObservable.bK(), (ViewGroup)this.mRootView, paramObservable);
            return;
            i = 0;
            break;
          }
        }
      } while (!this.mApp.ch(3));
      avD();
      paramObservable = (String)arrayOfObject[1];
      paramObject = (Boolean)arrayOfObject[2];
      this.jdField_a_of_type_Jgl.a((ViewGroup)this.mRootView, paramObservable, paramObject.booleanValue());
      return;
    } while (!this.mApp.ch(3));
    avD();
    this.jdField_a_of_type_Jgl.f((ViewGroup)this.mRootView);
  }
  
  public void F(int paramInt, boolean paramBoolean) {}
  
  protected boolean L(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void R(long paramLong, boolean paramBoolean)
  {
    String str = this.mApp.getCurrentAccountUin();
    int i = c("onCameraOpened_" + paramBoolean, str, 1);
    if (i >= 0) {
      this.jdField_a_of_type_ArrayOfIzm[i].J(paramLong, paramBoolean);
    }
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public void a(long paramLong, izm paramizm)
  {
    if ((paramizm != null) && (!paramizm.vh())) {
      paramizm.J(paramLong, this.jdField_a_of_type_Jdl.vX());
    }
  }
  
  protected void a(ipm paramipm, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      ije localije = ije.a(this.mApp);
      if (localije != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (((iiv)localObject).amI == 2) {}
        for (int i = 1;; i = 0)
        {
          boolean bool = ((iiv)localObject).b.get(5);
          if ((i == 0) || (bool)) {
            break;
          }
          localObject = ((iiv)localObject).peerUin;
          int j = getChildCount();
          i = 0;
          while (i < j)
          {
            izm localizm = (izm)a(i);
            if ((localObject != null) && (((String)localObject).equals(localizm.getUin())))
            {
              byte[] arrayOfByte = localizm.a().A();
              localije.c(localizm.getUin(), arrayOfByte);
            }
            i += 1;
          }
        }
      }
    }
    if (this.jdField_a_of_type_Iwo != null) {
      this.jdField_a_of_type_Iwo.a(this.mApp, paramipm);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null))
    {
      if (!vi())
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        super.d(paramipm);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        return;
      }
      super.iI(true);
      super.d(paramipm);
      super.iI(false);
      return;
    }
    super.d(paramipm);
  }
  
  public void a(jdh paramjdh)
  {
    this.jdField_b_of_type_Jdh = paramjdh;
  }
  
  public void aa(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
        if ((paramString.equals((String)localizm.getTag(0))) && (localizm.getVisibility() == 0)) {
          localizm.jK(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  public void apx()
  {
    if (this.jdField_a_of_type_Jdt != null) {
      this.jdField_a_of_type_Jdt.doOnDestroy();
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    this.c = null;
  }
  
  public void apy()
  {
    if (this.jdField_a_of_type_Jdt != null) {
      this.jdField_a_of_type_Jdt.auP();
    }
  }
  
  protected void arx() {}
  
  protected void ary()
  {
    this.jdField_a_of_type_ArrayOfIzm = new izm[MultiVideoCtrlLayerUIBase.auk];
    int i = wja.dp2px(115.0F, this.mContext.getResources());
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i -= ImmersiveUtils.getStatusBarHeight(this.mContext);
    }
    for (;;)
    {
      int j = 0;
      if (j < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[j] = new izm(this.mContext, this.mApp, String.format("%s_%s", new Object[] { this.TAG, Integer.valueOf(j) }), this.jdField_a_of_type_ComTencentAvVideoController.getOnPeerFrameRenderEndFunctionPtr());
        this.jdField_a_of_type_ArrayOfIzm[j].setActivityContext(this.mContext);
        this.jdField_a_of_type_ArrayOfIzm[j].setVisibility(1);
        this.jdField_a_of_type_ArrayOfIzm[j].ms(-1);
        this.jdField_a_of_type_ArrayOfIzm[j].bU(2130843003, 2130843002);
        this.jdField_a_of_type_ArrayOfIzm[j].jI(this.jdField_a_of_type_Jdl.vX());
        if (j == 0) {
          this.jdField_a_of_type_ArrayOfIzm[j].setZOrder(j * 2);
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfIzm[j].mt(i);
          a(this.jdField_a_of_type_ArrayOfIzm[j]);
          j += 1;
          break;
          this.jdField_a_of_type_ArrayOfIzm[j].setZOrder((this.jdField_a_of_type_ArrayOfIzm.length - j) * 2);
        }
      }
      return;
    }
  }
  
  public void at(String paramString, int paramInt)
  {
    int i = c("showNick", paramString, paramInt);
    if (i >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfIzm[i];
      if (this.jdField_a_of_type_Jdl == null) {
        break label86;
      }
      if (this.jdField_a_of_type_Jdl.getStyle() != 3) {
        break label69;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if ((i == 0) && (paramInt == 0))
      {
        if ((this.mTopOffset != 0) && (this.ayt != 0))
        {
          paramString.jN(false);
          return;
          label69:
          paramInt = 0;
        }
        else
        {
          paramString.jN(true);
        }
      }
      else
      {
        paramString.jN(true);
        return;
        label86:
        paramInt = 0;
      }
    }
  }
  
  public void avB()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(0);
    }
  }
  
  public void avC()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(8);
    }
  }
  
  void avD()
  {
    if (this.jdField_a_of_type_Jgl == null) {
      this.jdField_a_of_type_Jgl = new jgl(this.mApp, this.mContext);
    }
  }
  
  protected void avp()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.mRootView.findViewById(2131363162));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
    this.jdField_a_of_type_Iwo = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.a();
    if (this.jdField_a_of_type_Iwo != null) {
      this.jdField_a_of_type_Iwo.a(this);
    }
  }
  
  protected void avv() {}
  
  public int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 0;
    int i = 1;
    int m = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299736);
    int k = this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299737);
    if (paramInt4 - paramInt2 > m)
    {
      paramInt2 = 1;
      if (paramInt5 - paramInt3 <= k) {
        break label106;
      }
      paramInt4 = 1;
      label65:
      paramInt5 = mp();
      if (paramInt5 != 3) {
        break label174;
      }
      if (paramInt1 != 1) {
        break label126;
      }
      paramInt3 = 3;
    }
    label106:
    label126:
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
                            return paramInt3;
                            if (paramInt4 - paramInt2 < -m)
                            {
                              paramInt2 = 2;
                              break;
                            }
                            paramInt2 = 0;
                            break;
                            paramInt4 = j;
                            if (paramInt5 - paramInt3 >= -k) {
                              break label65;
                            }
                            paramInt4 = 2;
                            break label65;
                            if (paramInt1 == 2) {
                              return 3;
                            }
                            if (paramInt1 == 4) {
                              return 3;
                            }
                            paramInt3 = i;
                          } while (paramInt1 != 3);
                          if (paramInt2 != 2) {
                            break label164;
                          }
                          paramInt3 = i;
                        } while (paramInt4 == 2);
                        return 4;
                        if (paramInt4 == 2) {
                          return 2;
                        }
                        return 3;
                        if (paramInt5 != 2) {
                          break label235;
                        }
                        if (paramInt1 == 1) {
                          return 2;
                        }
                        if (paramInt1 == 3) {
                          return 2;
                        }
                        if (paramInt1 == 4) {
                          return 2;
                        }
                        paramInt3 = i;
                      } while (paramInt1 != 2);
                      if (paramInt2 != 2) {
                        break label225;
                      }
                      paramInt3 = i;
                    } while (paramInt4 != 1);
                    return 4;
                    if (paramInt4 == 1) {
                      return 3;
                    }
                    return 2;
                    if (paramInt5 != 1) {
                      break label299;
                    }
                    paramInt3 = i;
                  } while (paramInt1 == 2);
                  paramInt3 = i;
                } while (paramInt1 == 3);
                paramInt3 = i;
              } while (paramInt1 == 4);
              paramInt3 = i;
            } while (paramInt1 != 1);
            if (paramInt2 == 1)
            {
              if (paramInt4 == 1) {
                return 3;
              }
              return 2;
            }
            paramInt3 = i;
          } while (paramInt4 != 1);
          return 4;
          paramInt3 = i;
        } while (paramInt5 != 4);
        if (paramInt1 == 1) {
          return 4;
        }
        if (paramInt1 == 2) {
          return 4;
        }
        if (paramInt1 == 3) {
          return 4;
        }
        paramInt3 = i;
      } while (paramInt1 != 4);
      if (paramInt2 == 1)
      {
        if (paramInt4 == 2) {
          return 2;
        }
        return 3;
      }
      paramInt3 = i;
    } while (paramInt4 == 2);
    label164:
    label174:
    label225:
    label235:
    return 4;
  }
  
  protected void b(Observable paramObservable, Object paramObject) {}
  
  protected int c(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfIzm[i];
        if ((paramString2.equals(paramString1.getUin())) && (paramInt == paramString1.getVideoSrcType()) && (paramString1.getVisibility() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  protected int cD(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfIzm == null) {
      return -1;
    }
    int i = paramInt;
    if (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      j = i;
      if (!TextUtils.isEmpty(localizm.getUin())) {
        if (localizm.getVisibility() != 1) {
          break label94;
        }
      }
    }
    for (int j = i;; j = -1)
    {
      ko("getUnusedView, start[" + paramInt + "], result_index[" + j + "]");
      return j;
      label94:
      i += 1;
      break;
    }
  }
  
  public void ca(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getZOrder();
    int j = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getZOrder();
    this.jdField_a_of_type_ArrayOfIzm[paramInt1].setZOrder(j);
    this.jdField_a_of_type_ArrayOfIzm[paramInt2].setZOrder(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.mApp.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
        str2 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin();
        if (!((String)localObject).equals(str1)) {
          break label694;
        }
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getTextColor();
        f1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getTextSize();
        j = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getMaxLength();
        bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wh();
        boolean bool2 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wg();
        int k = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getTextColor();
        f2 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getTextSize();
        int m = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getMaxLength();
        boolean bool3 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wh();
        boolean bool4 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wg();
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].jL(bool4);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextColor(k);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f2);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setMaxLength(m);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].jN(bool3);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].jL(bool2);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextColor(i);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f1);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setMaxLength(j);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].jN(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfIzm[paramInt1];
      this.jdField_a_of_type_ArrayOfIzm[paramInt1] = this.jdField_a_of_type_ArrayOfIzm[paramInt2];
      this.jdField_a_of_type_ArrayOfIzm[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wf();
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].jK(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wf();
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].jK(bool1);
      f1 = jll.dp2px(BaseApplicationImpl.getContext(), 12.0F);
      f2 = jll.dp2px(BaseApplicationImpl.getContext(), 18.0F);
      if (paramInt1 != 0) {
        break label719;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f2);
      label465:
      if (paramInt2 != 0) {
        break label732;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f2);
    }
    for (;;)
    {
      jj(false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.b().PX = wV();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4) {
        e(this.jdField_a_of_type_ComTencentAvVideoController.b());
      }
      localObject = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
      str1 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin();
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "switchVideo, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]");
      }
      this.mApp.l(new Object[] { Integer.valueOf(8005), localObject, str1 });
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label694:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label719:
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f1);
      break label465;
      label732:
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f1);
    }
  }
  
  public void cb(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.mContext == null) {
      return;
    }
    int n = this.mContext.getResources().getDimensionPixelSize(2131299735);
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131299732);
    Rect localRect = super.getBounds();
    int k = localRect.width() - n;
    int j = localRect.height() - i1;
    int m = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().left + paramInt1;
    paramInt2 = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().top + paramInt2;
    if (m < 0)
    {
      paramInt1 = 0;
      if (paramInt2 >= 0) {
        break label146;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfIzm[1].layout(paramInt1, paramInt2, paramInt1 + n, paramInt2 + i1);
      return;
      paramInt1 = k;
      if (m > k) {
        break;
      }
      paramInt1 = m;
      break;
      label146:
      if (paramInt2 > j) {
        paramInt2 = j;
      }
    }
  }
  
  @RequiresApi(api=17)
  public void d(ipm paramipm)
  {
    int i;
    if ((this.jdField_b_of_type_Jdh != null) && (this.jdField_b_of_type_Jdh.isRecording()))
    {
      Object localObject;
      if (!this.YI)
      {
        this.YI = true;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramipm.getWidth(), paramipm.getHeight(), 33984);
        this.d = new TextureRender();
        this.YJ = this.jdField_b_of_type_Jdh.vX();
        if (this.YJ)
        {
          localObject = this.jdField_b_of_type_Jdh.a(paramipm.getWidth(), paramipm.getHeight(), true);
          this.ag = new float[16];
          Matrix.setIdentityM(this.ag, 0);
          float[] arrayOfFloat = this.ag;
          float f = localObject[1];
          i = paramipm.getHeight();
          arrayOfFloat[5] = (f * 1.0F / (localObject[0] * i / paramipm.getWidth()));
          this.ag[13] = (1.0F - this.ag[5]);
        }
      }
      else
      {
        a(paramipm, true);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, paramipm.getWidth(), paramipm.getHeight());
        this.d.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
        localObject = this.jdField_b_of_type_Jdh;
        i = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
        if (!this.YJ) {
          break label292;
        }
      }
      label292:
      for (paramipm = this.ag;; paramipm = null)
      {
        ((jdh)localObject).a(3553, i, paramipm, null, SystemClock.elapsedRealtimeNanos());
        return;
        this.jdField_b_of_type_Jdh.a(paramipm.getWidth(), paramipm.getHeight(), false);
        break;
      }
    }
    if (this.YI)
    {
      this.YI = false;
      i = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.d.release();
      this.d = null;
      this.ag = null;
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
    GLES20.glBindFramebuffer(36160, 0);
    a(paramipm, false);
    q(paramipm);
  }
  
  public void dZ(long paramLong)
  {
    this.pe = paramLong;
  }
  
  void e(iiv paramiiv)
  {
    if (paramiiv.uinType == 3000) {
      if (wV()) {
        anot.a(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
      }
    }
    while (paramiiv.uinType != 1)
    {
      return;
      anot.a(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (wV())
    {
      if (paramiiv.anb == 10)
      {
        anot.a(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
        return;
      }
      anot.a(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
      return;
    }
    if (paramiiv.anb == 10)
    {
      anot.a(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
  }
  
  public void g(ipm paramipm)
  {
    int i2 = paramipm.getWidth();
    int i3 = paramipm.getHeight();
    int[] arrayOfInt = new int[4];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = -1;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = -1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = -1;
    int[] tmp35_31 = tmp31_27;
    tmp35_31[3] = -1;
    tmp35_31;
    int i = 0;
    if (this.jdField_a_of_type_Jdt != null)
    {
      this.jdField_a_of_type_Jdt.bY(i2, i3);
      this.jdField_a_of_type_Jdt.auO();
    }
    int i4 = getChildCount();
    int j = 0;
    Object localObject1;
    izp localizp;
    boolean bool1;
    Object localObject2;
    int n;
    boolean bool2;
    String str;
    int m;
    int k;
    if (j < i4)
    {
      localObject1 = a(j);
      if (!((iqt)localObject1).canRender()) {
        break label853;
      }
      localizp = ((iqt)localObject1).a(paramipm);
      bool1 = ((iqt)localObject1).vh();
      localObject2 = ((izm)localObject1).a().A();
      n = 0;
      int i1 = 0;
      bool2 = ((izm)localObject1).isMirror();
      str = null;
      m = n;
      k = i1;
      localObject1 = str;
      if (localObject2 != null)
      {
        iog localiog = (iog)ioh.a((byte[])localObject2).get(6);
        m = n;
        k = i1;
        localObject1 = str;
        if (localiog != null)
        {
          localObject1 = localiog.getValue();
          k = (short)(localObject1[0] << 8 | localObject1[1] & 0xFF);
          m = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          localObject1 = FaceDetectUtil.parseOrigFaceDataModelJson(new String((byte[])localObject1, 4, localObject1.length - 4));
        }
      }
      if ((bool1) && (localObject2 != null)) {
        if (QLog.isDebugVersion())
        {
          str = this.TAG;
          localObject2 = new StringBuilder().append("bufAll self length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(k).append(",detectFaceWidth:=").append(m).append(",faceTextureWidth:=").append(localizp.awu).append(",faceTextureHeight:=").append(localizp.awv).append("faceModel size:=");
          if (localObject1 != null)
          {
            n = ((List)localObject1).size();
            label370:
            QLog.i(str, 2, n + ":isMirror:=" + bool2);
          }
        }
        else
        {
          label397:
          arrayOfInt[i] = localizp.awt;
          if (this.jdField_a_of_type_Jdt != null) {
            this.jdField_a_of_type_Jdt.a(arrayOfInt[i], localizp.awu, localizp.awv, m, k, bool2, (List)localObject1, bool1);
          }
          i += 1;
        }
      }
    }
    label642:
    label663:
    label853:
    for (;;)
    {
      j += 1;
      break;
      n = 0;
      break label370;
      if ((localObject2 == null) || (!QLog.isDebugVersion())) {
        break label397;
      }
      str = this.TAG;
      localObject2 = new StringBuilder().append("bufAll peer length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(k).append(",detectFaceWidth:=").append(m).append(",faceTextureWidth:=").append(localizp.awu).append(",faceTextureHeight:=").append(localizp.awv).append("faceModel size:=");
      if (localObject1 != null) {}
      for (n = ((List)localObject1).size();; n = 0)
      {
        QLog.i(str, 2, n + ":isMirror:=" + bool2);
        break;
      }
      paramipm = null;
      if (this.jdField_a_of_type_Jdt != null)
      {
        bool1 = iop.uQ();
        paramipm = this.jdField_a_of_type_Jdt;
        if (bool1)
        {
          i = 720;
          if (!bool1) {
            break label756;
          }
          j = 1280;
          paramipm = paramipm.a(i, j);
        }
      }
      else
      {
        if (!this.Uh) {
          break label763;
        }
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        if (this.c == null) {
          this.c = new TextureRender();
        }
        if (paramipm == null) {
          break label782;
        }
        localObject1 = this.jdField_a_of_type_Jdt.d();
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramipm.getTextureId(), null, (float[])localObject1);
        paramipm.unlock();
      }
      for (;;)
      {
        if (this.Uh) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        }
        return;
        i = 540;
        break;
        label756:
        j = 960;
        break label642;
        label763:
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i2, i3);
        break label663;
        if (arrayOfInt[0] != -1) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, arrayOfInt[0], null, null);
        }
        if (arrayOfInt[1] != -1)
        {
          GLES20.glViewport(0, 0, 300, 300);
          this.c.drawTexture(3553, arrayOfInt[1], null, null);
          GLES20.glViewport(0, 0, i2, i3);
        }
      }
    }
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  String hl()
  {
    String str = "[" + this.TAG + "]VideoView[5]:\r\n";
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      str = str + "---------index[" + i + "], size[" + localizm.getWidth() + ", " + localizm.getHeight() + "], " + localizm.hl() + "\r\n";
      i += 1;
    }
    return str;
  }
  
  public boolean i(String paramString, int paramInt)
  {
    int i = c("isBigView", paramString, paramInt);
    ko("isBigView, uin[" + paramString + "], videoSrcType[" + paramInt + "], result_index[" + i + "]");
    return i == 0;
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  public void jj(boolean paramBoolean) {}
  
  void ko(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = "printGLVideoView[" + paramString + "]\r\n";
      str = str + hl();
      QLog.d(this.TAG, 2, str);
    }
    if (QLog.isColorLevel())
    {
      paramString = "printItemList[" + paramString + "]\r\n";
      paramString = paramString + this.jdField_a_of_type_ComTencentAvVideoController.f(this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if);
      QLog.d(this.TAG, 2, paramString);
    }
  }
  
  public void l(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getZOrder();
    int j = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getZOrder();
    this.jdField_a_of_type_ArrayOfIzm[paramInt1].setZOrder(j);
    this.jdField_a_of_type_ArrayOfIzm[paramInt2].setZOrder(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.mApp.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
        str2 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin();
        if (!((String)localObject).equals(str1)) {
          break label700;
        }
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getTextColor();
        f1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getTextSize();
        j = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getMaxLength();
        bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wh();
        boolean bool2 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wg();
        int k = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getTextColor();
        f2 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getTextSize();
        int m = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getMaxLength();
        boolean bool3 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wh();
        boolean bool4 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wg();
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].jL(bool4);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextColor(k);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f2);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].setMaxLength(m);
        this.jdField_a_of_type_ArrayOfIzm[paramInt1].jN(bool3);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].jL(bool2);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextColor(i);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f1);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].setMaxLength(j);
        this.jdField_a_of_type_ArrayOfIzm[paramInt2].jN(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfIzm[paramInt1];
      this.jdField_a_of_type_ArrayOfIzm[paramInt1] = this.jdField_a_of_type_ArrayOfIzm[paramInt2];
      this.jdField_a_of_type_ArrayOfIzm[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt1].wf();
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].jK(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].wf();
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].jK(bool1);
      f1 = jll.dp2px(BaseApplicationImpl.getContext(), 12.0F);
      f2 = jll.dp2px(BaseApplicationImpl.getContext(), 18.0F);
      if (paramInt1 != 0) {
        break label725;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f2);
      label468:
      if (paramInt2 != 0) {
        break label739;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfIzm[0].setPaddings(0, 0, 0, 0);
      this.jdField_a_of_type_ArrayOfIzm[0].layout(0, 0, super.getWidth(), super.getHeight());
      this.jdField_a_of_type_ArrayOfIzm[0].setBackgroundColor(-15197410);
      apz();
      localObject = this.jdField_a_of_type_ArrayOfIzm[paramInt1].getUin();
      str1 = this.jdField_a_of_type_ArrayOfIzm[paramInt2].getUin();
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "swapGLVideoView, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]=[" + paramString + "]", new Throwable("who call SwapGLVideoView"));
      }
      this.mApp.getHandler().post(new VideoLayerUIBase.3(this, (String)localObject, str1));
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      break;
      label700:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setScaleType(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label725:
      this.jdField_a_of_type_ArrayOfIzm[paramInt1].setTextSize(f1);
      break label468;
      label739:
      this.jdField_a_of_type_ArrayOfIzm[paramInt2].setTextSize(f1);
    }
  }
  
  public void lS(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.b().ani = paramInt;
  }
  
  protected void lU(int paramInt) {}
  
  public int mp()
  {
    Rect localRect = super.getBounds();
    int i = localRect.centerX();
    int j = localRect.centerY();
    int k = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().centerX();
    int m = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().centerY();
    if ((k < i) && (m < j)) {
      return 1;
    }
    if ((k < i) && (m > j)) {
      return 4;
    }
    if ((k > i) && (m < j)) {
      return 2;
    }
    if ((k > i) && (m > j)) {
      return 3;
    }
    return 0;
  }
  
  public void nj(int paramInt)
  {
    int k = 0;
    int i1 = this.mContext.getResources().getDimensionPixelSize(2131299735);
    int i2 = this.mContext.getResources().getDimensionPixelSize(2131299732);
    int i = this.mContext.getResources().getDimensionPixelSize(2131299733);
    int j = this.mContext.getResources().getDimensionPixelSize(2131299734);
    if (this.ayt == 0) {
      j = i;
    }
    Object localObject = super.getBounds();
    int m = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().left;
    int n = this.jdField_a_of_type_ArrayOfIzm[1].getBounds().top;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = k;
    }
    for (;;)
    {
      localObject = new MoveSmallViewAnimation(paramInt, m, n, i, j, null);
      this.mApp.getHandler().post((Runnable)localObject);
      return;
      j += this.mTopOffset;
      continue;
      k = ((Rect)localObject).width();
      j += this.mTopOffset;
      i = k - i - i1;
      continue;
      k = ((Rect)localObject).width();
      j = ((Rect)localObject).height() - j - i2;
      i = k - i - i1;
      continue;
      j = ((Rect)localObject).height() - j - i2;
    }
  }
  
  public void nk(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfIzm == null) {}
    for (;;)
    {
      return;
      int i = wja.dp2px(paramInt, this.mContext.getResources());
      paramInt = i;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        paramInt = i - ImmersiveUtils.getStatusBarHeight(this.mContext);
      }
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        this.jdField_a_of_type_ArrayOfIzm[i].mt(paramInt);
        i += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "onDestroy, mDestroyed[" + this.mDestroyed + "]");
    }
    this.mDestroyed = true;
    this.mApp.deleteObserver(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$a);
    this.mApp.getHandler().removeCallbacks(this.ci);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.removeAllView();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      this.jdField_a_of_type_ArrayOfIzm[i].setVisibility(1);
      this.jdField_a_of_type_ArrayOfIzm[i].jO(true);
      this.jdField_a_of_type_ArrayOfIzm[i].enableLoading(false);
      this.jdField_a_of_type_ArrayOfIzm[i].jK(false);
      this.jdField_a_of_type_ArrayOfIzm[i].flush(true);
      i += 1;
    }
    if (this.jdField_a_of_type_Iwo != null) {
      this.jdField_a_of_type_Iwo.onDestroy();
    }
    this.mApp = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.gM = null;
    this.mContext = null;
    this.mRootView = null;
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfIzm = null;
    this.jdField_a_of_type_Iwo = null;
    if (this.jdField_a_of_type_Jdt != null) {
      this.jdField_a_of_type_Jdt.doOnDestroy();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    jj(false);
  }
  
  public void onPause()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_Iwo != null) {
      this.jdField_a_of_type_Iwo.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
    F(this.mCacheRotation, false);
  }
  
  void q(ipm paramipm)
  {
    if (this.pe == 0L) {}
    long l1;
    do
    {
      return;
      l1 = this.pe;
      this.pe = 0L;
      if ((paramipm instanceof ipn))
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramipm.getWidth(), paramipm.getHeight(), Bitmap.Config.ARGB_8888);
        long l2 = AudioHelper.elapsedRealtimeNanos();
        paramipm.f(localBitmap, paramipm.getWidth(), paramipm.getHeight());
        long l3 = AudioHelper.elapsedRealtimeNanos();
        QLog.w(this.TAG, 1, "tryScreenShot, screenShotFlag[" + l1 + "], cost_nanos[" + (l3 - l2) + "]");
        ThreadManager.getSubThreadHandler().post(new VideoLayerUIBase.4(this, localBitmap, l1));
        return;
      }
    } while (this.mApp == null);
    this.mApp.l(new Object[] { Integer.valueOf(20001), Long.valueOf(l1), Boolean.valueOf(false), null });
  }
  
  public boolean vX()
  {
    if (isDestroyed()) {
      return false;
    }
    return this.jdField_a_of_type_Jdl.vX();
  }
  
  public boolean vi()
  {
    return (this.jdField_a_of_type_Jdt != null) && (this.jdField_a_of_type_Jdt.a(this.jdField_a_of_type_Jdl));
  }
  
  protected boolean wV()
  {
    String str = this.mApp.getCurrentAccountUin();
    izm localizm = this.jdField_a_of_type_ArrayOfIzm[0];
    if ((localizm.getVisibility() == 0) && (str.equals(localizm.getUin()))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "isLocalFront: " + bool);
      }
      ko(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  protected boolean wW()
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
        if ((localizm.getVisibility() == 0) && (!str.equals(localizm.getUin()))) {
          bool1 = true;
        }
      }
      else
      {
        ko("isRemoteHasVideo, peer isRemoteHasVideo[" + bool1 + "]");
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean wX()
  {
    int i = 0;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      izm localizm;
      if (i < this.jdField_a_of_type_ArrayOfIzm.length)
      {
        localizm = this.jdField_a_of_type_ArrayOfIzm[i];
        bool2 = bool1;
        if (localizm.getVisibility() == 0)
        {
          bool1 = localizm.we();
          bool2 = bool1;
          if (!bool1)
          {
            QLog.d(this.TAG, 1, "doGlassRemoteVideo failed !!!! i=" + i + ", getVisibility=" + localizm.getVisibility());
            bool2 = bool1;
          }
        }
      }
      else
      {
        if (!bool2) {
          break;
        }
        if (this.gM != null) {
          this.gM.setVisibility(0);
        }
        return false;
      }
      QLog.d(this.TAG, 1, "doGlassRemoteVideo i=" + i + ", getVisibility=" + localizm.getVisibility());
      i += 1;
    }
    QLog.d(this.TAG, 1, "doGlassRemoteVideo failed and cancel Glass");
    wY();
    return false;
  }
  
  public boolean wY()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIzm.length)
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      if (localizm.getVisibility() == 0) {
        localizm.asT();
      }
      QLog.d(this.TAG, 1, "doCancelGlassRemoteVideo i=" + i + ", getVisibility=" + localizm.getVisibility());
      i += 1;
    }
    if (this.gM != null) {
      this.gM.setVisibility(8);
    }
    return false;
  }
  
  public long z(String paramString)
  {
    int i = 0;
    while ((this.jdField_a_of_type_ArrayOfIzm != null) && (i < this.jdField_a_of_type_ArrayOfIzm.length))
    {
      izm localizm = this.jdField_a_of_type_ArrayOfIzm[i];
      if ((localizm.getVisibility() == 0) && (paramString.equals(localizm.getUin()))) {
        return localizm.bM();
      }
      i += 1;
    }
    return 0L;
  }
  
  class MoveSmallViewAnimation
    implements Runnable
  {
    private int ays;
    private final int ayu = 9;
    private float mDeltaX;
    private float mDeltaY;
    private int mPosition = 1;
    
    private MoveSmallViewAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.mDeltaX = ((paramInt4 - paramInt2) / 10.0F);
      this.mDeltaY = ((paramInt5 - paramInt3) / 10.0F);
      this.mPosition = paramInt1;
    }
    
    public void run()
    {
      if (VideoLayerUIBase.this.isDestroyed()) {
        return;
      }
      if (this.ays == 9) {
        VideoLayerUIBase.this.lU(this.mPosition);
      }
      for (;;)
      {
        this.ays += 1;
        if (VideoLayerUIBase.this.mApp == null) {
          break;
        }
        if (this.ays > 9) {
          break label99;
        }
        VideoLayerUIBase.this.mApp.getHandler().postDelayed(this, 10L);
        return;
        VideoLayerUIBase.this.cb((int)this.mDeltaX, (int)this.mDeltaY);
      }
      label99:
      VideoLayerUIBase.this.avv();
      VideoLayerUIBase.this.mApp.l(new Object[] { Integer.valueOf(121) });
    }
  }
  
  static class a
    implements Observer
  {
    private WeakReference<VideoLayerUIBase> bk;
    
    a(VideoLayerUIBase paramVideoLayerUIBase)
    {
      this.bk = new WeakReference(paramVideoLayerUIBase);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.bk.get();
      if (localVideoLayerUIBase == null) {
        return;
      }
      VideoLayerUIBase.a(localVideoLayerUIBase, paramObservable, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */