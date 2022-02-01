package com.tencent.mobileqq.ar;

import acfp;
import adau;
import adfd;
import adfl;
import adfy;
import adfz;
import adgb;
import akqe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import anot;
import aqhu;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScanningSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private CopyOnWriteArrayList<ScanningData> T = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<String> U = new CopyOnWriteArrayList();
  private Runnable X = new ScanningSurfaceView.4(this);
  BlurMaskFilter jdField_a_of_type_AndroidGraphicsBlurMaskFilter;
  SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private ScanningData jdField_a_of_type_ComTencentMobileqqArScanningData;
  public adfd b;
  volatile boolean bMR = false;
  private final Object cT = new Object();
  int[] colors = { Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255) };
  private List<DrawView2.a> da;
  private ConcurrentHashMap<Integer, ScanningData> eG = new ConcurrentHashMap();
  private long eq = 50L;
  private boolean isRunning;
  private HandlerThread k;
  private Handler mDrawHandler;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  Matrix matrix = new Matrix();
  float[] positions = { 0.0F, 0.5F };
  private boolean qm;
  private float scale = 1.0F;
  View.OnTouchListener y = new adfy(this);
  
  public ScanningSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ScanningSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ScanningSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Be()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
        if (localCanvas != null)
        {
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          if (!this.qm) {
            continue;
          }
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          QLog.d("ScanningSurfaceView", 1, "clearCanvas");
        }
      }
      catch (Exception localException4)
      {
        Canvas localCanvas;
        localObject3 = localObject1;
        QLog.e("ScanningSurfaceView", 1, "doDraw catch an exception.", localException4);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localObject1);
          return;
        }
        catch (Exception localException1)
        {
          QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException1);
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label156;
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException2);
        return;
      }
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      Q(localCanvas);
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      QLog.d("ScanningSurfaceView", 1, "drawCanvas");
    }
    try
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localObject3);
      label156:
      throw localObject2;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        QLog.e("ScanningSurfaceView", 1, "doDraw finally catch an exception.", localException3);
      }
    }
  }
  
  private void Gv(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("finish_animation_up_down", true);
      getContext().startActivity(localIntent);
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).overridePendingTransition(2130772009, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ScanningSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void Gw(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      getContext().startActivity(localIntent);
      anot.a(null, "dc00898", "", "", "0X800834F", "0X800834F", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ScanningSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void Q(Canvas paramCanvas)
  {
    ScanningData localScanningData1;
    int n;
    int j;
    if (paramCanvas != null)
    {
      localScanningData1 = a();
      n = 0;
      j = 1;
      if (n >= this.T.size()) {
        break label5823;
      }
      localScanningData2 = (ScanningData)this.T.get(n);
      if (localScanningData2 != null) {
        break label48;
      }
    }
    label48:
    label337:
    label372:
    label4212:
    label4735:
    while ((j == 0) || (this.b.a.Hb() == 0))
    {
      ScanningData localScanningData2;
      return;
      Object localObject;
      if (!localScanningData2.ql)
      {
        this.mHandler.post(new ScanningSurfaceView.5(this, localScanningData2, localScanningData1));
        if ((localScanningData2.bMt) && (!localScanningData2.bMB) && (localScanningData2.bMu) && (!localScanningData2.bMD) && (!TextUtils.isEmpty(localScanningData2.uin)) && (!this.U.contains(localScanningData2.uin)))
        {
          localObject = localScanningData2.uin;
          String str = localScanningData2.url;
          this.mHandler.postDelayed(new ScanningSurfaceView.6(this, (String)localObject, str), 4000L);
        }
      }
      localScanningData2.F.setColor(localScanningData2.FG);
      localScanningData2.F.setStrokeWidth(localScanningData2.bY);
      float f1;
      float f5;
      float f2;
      float f3;
      float f4;
      float f6;
      float f7;
      if (((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
      {
        localScanningData2.F.setAlpha((int)(localScanningData2.cl * 255.0F));
        f1 = localScanningData2.bV * localScanningData2.bW + localScanningData2.bY;
        localObject = new RectF(localScanningData2.centerX - f1, localScanningData2.centerY - f1, localScanningData2.centerX + f1, f1 + localScanningData2.centerY);
        if ((localScanningData2.FG != -1) && (localScanningData2.bMt) && (!localScanningData2.bMD)) {
          break label3643;
        }
        localScanningData2.F.setShader(null);
        if (localScanningData2.dn == 0.0F) {
          break label3731;
        }
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = new BlurMaskFilter(localScanningData2.jdField_do * localScanningData2.dn, BlurMaskFilter.Blur.SOLID);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3739;
        }
        localScanningData2.F.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localScanningData2.F.setShader(null);
        f1 = localScanningData2.bZ;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.bX + f1, a(localScanningData2.bZ + localScanningData2.bX, localScanningData2.ca + localScanningData2.bX), false, localScanningData2.F);
        if ((localScanningData2.FG != -1) && (localScanningData2.bMt) && (!localScanningData2.bMD)) {
          break label3752;
        }
        localScanningData2.F.setShader(null);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3863;
        }
        localScanningData2.F.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localScanningData2.F.setShader(null);
        f1 = localScanningData2.cb;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.bX + f1, a(localScanningData2.cb + localScanningData2.bX, localScanningData2.cc + localScanningData2.bX), false, localScanningData2.F);
        if ((localScanningData2.ck > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          f5 = localScanningData2.bY;
          localScanningData2.cg = ((float)((localScanningData2.bV * localScanningData2.bW + f5) * Math.cos((localScanningData2.ce + localScanningData2.bX) * 3.141592653589793D / 180.0D) + localScanningData2.centerX));
          localScanningData2.ch = ((float)((localScanningData2.bV * localScanningData2.bW + f5) * Math.sin((localScanningData2.ce + localScanningData2.bX) * 3.141592653589793D / 180.0D) + localScanningData2.centerY));
          f2 = localScanningData2.cf + localScanningData2.bX;
          f3 = f2 + 120.0F;
          f4 = 120.0F + f3;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          f4 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f1 * 3.141592653589793D / 180.0D) + localScanningData2.cg);
          f1 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f1 * 3.141592653589793D / 180.0D) + localScanningData2.ch);
          f6 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f2 * 3.141592653589793D / 180.0D) + localScanningData2.cg);
          f2 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f2 * 3.141592653589793D / 180.0D) + localScanningData2.ch);
          f7 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f3 * 3.141592653589793D / 180.0D) + localScanningData2.cg);
          f3 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f3 * 3.141592653589793D / 180.0D) + localScanningData2.ch);
          localObject = new Path();
          ((Path)localObject).moveTo(f4, f1);
          ((Path)localObject).lineTo(f6, f2);
          ((Path)localObject).lineTo(f7, f3);
          ((Path)localObject).close();
          localScanningData2.G.setColor(localScanningData2.FE);
          localScanningData2.G.setAlpha((int)(localScanningData2.ck * 255.0F));
          paramCanvas.drawPath((Path)localObject, localScanningData2.G);
          localScanningData2.ci = ((float)((localScanningData2.bV * localScanningData2.bW + f5) * Math.cos((localScanningData2.cf + localScanningData2.bX) * 3.141592653589793D / 180.0D) + localScanningData2.centerX));
          localScanningData2.cj = ((float)((localScanningData2.bV * localScanningData2.bW + f5) * Math.sin((localScanningData2.cf + localScanningData2.bX) * 3.141592653589793D / 180.0D) + localScanningData2.centerY));
          f2 = localScanningData2.ce + localScanningData2.bX;
          f3 = f2 + 120.0F;
          f4 = 120.0F + f3;
          f1 = f2;
          if (f2 >= 360.0F) {
            f1 = f2 - 360.0F;
          }
          f2 = f3;
          if (f3 >= 360.0F) {
            f2 = f3 - 360.0F;
          }
          f3 = f4;
          if (f4 >= 360.0F) {
            f3 = f4 - 360.0F;
          }
          f4 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f1 * 3.141592653589793D / 180.0D) + localScanningData2.ci);
          f1 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f1 * 3.141592653589793D / 180.0D) + localScanningData2.cj);
          f5 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f2 * 3.141592653589793D / 180.0D) + localScanningData2.ci);
          f2 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f2 * 3.141592653589793D / 180.0D) + localScanningData2.cj);
          f6 = (float)(localScanningData2.cd * localScanningData2.bW * Math.cos(f3 * 3.141592653589793D / 180.0D) + localScanningData2.ci);
          f3 = (float)(localScanningData2.cd * localScanningData2.bW * Math.sin(f3 * 3.141592653589793D / 180.0D) + localScanningData2.cj);
          ((Path)localObject).reset();
          ((Path)localObject).moveTo(f4, f1);
          ((Path)localObject).lineTo(f5, f2);
          ((Path)localObject).lineTo(f6, f3);
          ((Path)localObject).close();
          localScanningData2.G.setColor(localScanningData2.FF);
          localScanningData2.G.setAlpha((int)(localScanningData2.ck * 255.0F));
          paramCanvas.drawPath((Path)localObject, localScanningData2.G);
        }
        if ((localScanningData2.cu > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          localScanningData2.H.setColor(localScanningData2.FH);
          localScanningData2.H.setStrokeWidth(localScanningData2.cp);
          localScanningData2.H.setAlpha((int)(localScanningData2.cu * 255.0F * 0.4D));
          f1 = localScanningData2.cm * localScanningData2.cn + localScanningData2.cp;
          localObject = new RectF(localScanningData2.centerX - f1, localScanningData2.centerY - f1, localScanningData2.centerX + f1, f1 + localScanningData2.centerY);
          f1 = localScanningData2.cq;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.co + f1, a(localScanningData2.cq + localScanningData2.co, localScanningData2.cr + localScanningData2.co), false, localScanningData2.H);
          f1 = localScanningData2.cs;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.co + f1, a(localScanningData2.cs + localScanningData2.co, localScanningData2.ct + localScanningData2.co), false, localScanningData2.H);
        }
        localScanningData2.I.setColor(localScanningData2.FI);
        localScanningData2.I.setStrokeWidth(localScanningData2.cC);
        localScanningData2.I.setAlpha((int)(localScanningData2.cJ * 255.0F * 0.3D));
        f1 = localScanningData2.cw * localScanningData2.cz + localScanningData2.cC;
        localObject = new RectF(localScanningData2.centerX - f1, localScanningData2.centerY - f1, localScanningData2.centerX + f1, f1 + localScanningData2.centerY);
        f1 = localScanningData2.cD;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cD + localScanningData2.cA, localScanningData2.cE + localScanningData2.cA), false, localScanningData2.I);
        f1 = localScanningData2.cH;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cH + localScanningData2.cA, localScanningData2.cI + localScanningData2.cA), false, localScanningData2.I);
        f1 = localScanningData2.cF;
        paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cF + localScanningData2.cA, localScanningData2.cG + localScanningData2.cA), false, localScanningData2.I);
        if ((localScanningData2.cS > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          localScanningData2.J.setColor(localScanningData2.FJ);
          localScanningData2.J.setStrokeWidth(localScanningData2.cL);
          localScanningData2.J.setAlpha((int)(localScanningData2.cS * 255.0F));
          f1 = localScanningData2.cM;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cM + localScanningData2.cA, localScanningData2.cN + localScanningData2.cA), false, localScanningData2.J);
          f1 = localScanningData2.cQ;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cQ + localScanningData2.cA, localScanningData2.cR + localScanningData2.cA), false, localScanningData2.J);
          f1 = localScanningData2.cO;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cA + f1, a(localScanningData2.cO + localScanningData2.cA, localScanningData2.cP + localScanningData2.cA), false, localScanningData2.J);
        }
        if ((localScanningData2.cW > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          localScanningData2.K.setColor(localScanningData2.FK);
          localScanningData2.K.setStrokeWidth(localScanningData2.cV);
          localScanningData2.K.setAlpha((int)(localScanningData2.cW * 255.0F * 0.1D));
          f1 = localScanningData2.cV / 2.0F;
          paramCanvas.drawCircle(localScanningData2.centerX, localScanningData2.centerY, f1 + localScanningData2.cT * localScanningData2.cU, localScanningData2.K);
        }
        if ((localScanningData2.dj > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          localScanningData2.L.setColor(localScanningData2.FL);
          localScanningData2.L.setStrokeWidth(localScanningData2.da);
          localScanningData2.L.setAlpha((int)(localScanningData2.dj * 255.0F * 0.3D));
          f1 = localScanningData2.cZ * localScanningData2.cX + localScanningData2.da;
          localObject = new RectF(localScanningData2.centerX - f1, localScanningData2.centerY - f1, localScanningData2.centerX + f1, f1 + localScanningData2.centerY);
          f1 = localScanningData2.dd;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cY + f1, a(localScanningData2.dd + localScanningData2.cY, localScanningData2.de + localScanningData2.cY), false, localScanningData2.L);
          f1 = localScanningData2.db;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cY + f1, a(localScanningData2.db + localScanningData2.cY, localScanningData2.dc + localScanningData2.cY), false, localScanningData2.L);
          f1 = localScanningData2.dh;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cY + f1, a(localScanningData2.dh + localScanningData2.cY, localScanningData2.di + localScanningData2.cY), false, localScanningData2.L);
          f1 = localScanningData2.df;
          paramCanvas.drawArc((RectF)localObject, localScanningData2.cY + f1, a(localScanningData2.df + localScanningData2.cY, localScanningData2.dg + localScanningData2.cY), false, localScanningData2.L);
        }
        if ((localScanningData2.dm > 0.0F) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD))
        {
          localScanningData2.M.setColor(localScanningData2.FM);
          localScanningData2.M.setAlpha((int)(localScanningData2.dm * 255.0F));
          paramCanvas.drawCircle(localScanningData2.centerX, localScanningData2.centerY, 0.0F + localScanningData2.dl * localScanningData2.dk, localScanningData2.M);
        }
        if ((!localScanningData2.isStar) || (localScanningData2.tG <= 0.0F) || (localScanningData2.bMD)) {
          break label4656;
        }
        localScanningData2.bB.setAlpha((int)(localScanningData2.tG * 255.0F));
        localScanningData2.bB.setStrokeWidth(localScanningData2.tr);
        localScanningData2.bA.setStrokeWidth(localScanningData2.tq);
        localScanningData2.bA.setAlpha((int)(localScanningData2.tG * 255.0F));
        if ((!localScanningData2.bMt) || (localScanningData2.cn == 0.0F)) {
          break label3876;
        }
        localScanningData2.tl = ((localScanningData2.cm * localScanningData2.cn + localScanningData2.cp) * 2.0F / 3.6F);
        if (localScanningData2.tl > localScanningData2.tm) {
          localScanningData2.tl = localScanningData2.tm;
        }
        if (localScanningData2.tl < localScanningData2.tn) {
          localScanningData2.tl = localScanningData2.tn;
        }
        localScanningData2.to = (localScanningData2.centerX - localScanningData2.bV * localScanningData2.bW - localScanningData2.bY - localScanningData2.tD);
        localScanningData2.tp = (localScanningData2.centerY - localScanningData2.bV * localScanningData2.bW - localScanningData2.bY - localScanningData2.tE * localScanningData2.tR);
        if ((!localScanningData2.bMt) || (!localScanningData2.isStar) || (localScanningData2.cn == 0.0F)) {
          break label3907;
        }
        localScanningData2.to = (localScanningData2.centerX - localScanningData2.bV * localScanningData2.bW - localScanningData2.bY - localScanningData2.tD - ScanningData.a.cEw);
        localScanningData2.an = (localScanningData2.tp - localScanningData2.tl);
        localScanningData2.tj = (localScanningData2.centerY + localScanningData2.cm * localScanningData2.cn + localScanningData2.cp);
        localScanningData2.tk = (localScanningData2.centerX + localScanningData2.cm * localScanningData2.cn + localScanningData2.cp);
        localScanningData2.am = localScanningData2.to;
        f2 = localScanningData2.centerX;
        f3 = localScanningData2.cw;
        f4 = localScanningData2.cV;
        f5 = localScanningData2.uB;
        f6 = localScanningData2.ut;
        f7 = localScanningData2.uu;
        if ((TextUtils.isEmpty(localScanningData2.bsz)) || (TextUtils.isEmpty(localScanningData2.bsA))) {
          break label4656;
        }
        localScanningData2.bsA = localScanningData2.bsA.toUpperCase();
        localScanningData2.bB.setTextSize(localScanningData2.tz * localScanningData2.tR);
        localScanningData2.bB.setTextAlign(Paint.Align.LEFT);
        if (localScanningData2.tG == 0.0F) {
          break label3992;
        }
        localScanningData2.bB.setShadowLayer(localScanningData2.tI, 0.0F, localScanningData2.tJ, localScanningData2.cEk);
      }
      float f8;
      float f9;
      float f10;
      float f11;
      for (;;)
      {
        localObject = localScanningData2.bB.getFontMetrics();
        f8 = localScanningData2.tp;
        f9 = ((Paint.FontMetrics)localObject).top;
        f1 = localScanningData2.tp;
        f1 = ((Paint.FontMetrics)localObject).ascent;
        f1 = localScanningData2.tp;
        f1 = ((Paint.FontMetrics)localObject).descent;
        f10 = localScanningData2.tp;
        f11 = ((Paint.FontMetrics)localObject).bottom;
        if (localScanningData2.tt != 0.0F) {
          break label4019;
        }
        float f12 = localScanningData2.am;
        f1 = localScanningData2.ts;
        localScanningData2.h.setTextSize(localScanningData2.tR * f1);
        while (localScanningData2.h.measureText(localScanningData2.bsz) > f2 + f3 + f4 + f5 - f6 - 4.0F * f7 - f12)
        {
          f1 -= 1.0F;
          localScanningData2.h.setTextSize(localScanningData2.tR * f1);
        }
        localScanningData2.F.setAlpha((int)(localScanningData2.cl * 255.0F * 0.5D));
        break;
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localScanningData2.centerX, localScanningData2.centerY, this.colors, this.positions);
        this.matrix.setRotate(localScanningData2.bZ + localScanningData2.bX - 5.0F, localScanningData2.centerX, localScanningData2.centerY);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.matrix);
        localScanningData2.F.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label337;
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = null;
        break label372;
        localScanningData2.F.setMaskFilter(null);
        break label402;
        this.colors = new int[] { localScanningData2.FD, localScanningData2.FC };
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localScanningData2.centerX, localScanningData2.centerY, this.colors, this.positions);
        this.matrix.setRotate(localScanningData2.cb + localScanningData2.bX - 5.0F, localScanningData2.centerX, localScanningData2.centerY);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.matrix);
        localScanningData2.F.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label488;
        localScanningData2.F.setMaskFilter(null);
        break label518;
        localScanningData2.tl = ((localScanningData2.bV * localScanningData2.bW + localScanningData2.bY) * 2.0F / 3.6F);
        break label3046;
        localScanningData2.an = (localScanningData2.tp - localScanningData2.tl);
        localScanningData2.tj = (localScanningData2.centerY + localScanningData2.bV * localScanningData2.bW + localScanningData2.bY);
        localScanningData2.tk = (localScanningData2.centerX + localScanningData2.bV * localScanningData2.bW + localScanningData2.bY);
        localScanningData2.am = localScanningData2.to;
        break label3315;
        localScanningData2.bB.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      localScanningData2.tt = (f1 / localScanningData2.scale);
      localScanningData2.ts = (localScanningData2.tt * localScanningData2.scale);
      if (localScanningData2.ts > localScanningData2.tv) {
        localScanningData2.ts = localScanningData2.tv;
      }
      if (localScanningData2.ts < localScanningData2.tw) {
        localScanningData2.ts = localScanningData2.tw;
      }
      if (localScanningData2.tz > localScanningData2.tB) {
        localScanningData2.tz = localScanningData2.tB;
      }
      if (localScanningData2.tz < localScanningData2.tC) {
        localScanningData2.tz = localScanningData2.tC;
      }
      localScanningData2.bA.setTextSize(localScanningData2.ts * localScanningData2.tR);
      localScanningData2.bA.setTextAlign(Paint.Align.LEFT);
      int m;
      int i;
      if (localScanningData2.bMt)
      {
        localScanningData2.bA.setFakeBoldText(true);
        if (localScanningData2.tG == 0.0F) {
          break label5714;
        }
        localScanningData2.bA.setShadowLayer(localScanningData2.tI, 0.0F, localScanningData2.tJ, localScanningData2.cEk);
        paramCanvas.drawText(localScanningData2.bsA, localScanningData2.to, localScanningData2.tp, localScanningData2.bB);
        paramCanvas.drawText(localScanningData2.bsz, localScanningData2.to, localScanningData2.tp - localScanningData2.tF - (f11 + f10 - (f8 + f9)), localScanningData2.bA);
        localScanningData2.bC.setAlpha((int)(localScanningData2.tN * 255.0F));
        f1 = localScanningData2.tp + localScanningData2.tE * localScanningData2.tR;
        f2 = localScanningData2.to + localScanningData2.tQ;
        f3 = f1 + localScanningData2.tO * localScanningData2.tR;
        f4 = f2 + (float)(localScanningData2.tP * localScanningData2.tR * Math.cos(localScanningData2.tL * 3.141592653589793D / 180.0D));
        f5 = f3 + (float)(localScanningData2.tP * localScanningData2.tR * Math.sin(localScanningData2.tL * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.tP * localScanningData2.tR * 2.0F / 3.0F * Math.cos(localScanningData2.tL * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.tP * localScanningData2.tR * 2.0F / 3.0F * Math.sin(localScanningData2.tL * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.tP * localScanningData2.tR / 3.0F * Math.cos(localScanningData2.tL * 3.141592653589793D / 180.0D));
        f6 = (float)(localScanningData2.tP * localScanningData2.tR / 3.0F * Math.sin(localScanningData2.tL * 3.141592653589793D / 180.0D));
        if (localScanningData2.tN >= 0.2D) {
          paramCanvas.drawLine(f4, f5, f2, f3, localScanningData2.bC);
        }
        if (localScanningData2.tN >= 0.5D) {
          paramCanvas.drawLine(f2, f3, f2, f1, localScanningData2.bC);
        }
        localScanningData2.bD.setAlpha((int)(localScanningData2.tN * 255.0F));
        paramCanvas.drawCircle(f4, f5, localScanningData2.tS, localScanningData2.bD);
        m = j;
        if (localScanningData2.tV <= 0.0F) {
          break label5789;
        }
        if (!localScanningData2.bMt)
        {
          m = j;
          if (!localScanningData2.isClicked) {
            break label5789;
          }
        }
        m = j;
        if (localScanningData2.bMD) {
          break label5789;
        }
        if (!localScanningData2.isStar) {
          break label5735;
        }
        if ((TextUtils.isEmpty(localScanningData2.bsB)) || (TextUtils.isEmpty(localScanningData2.bsC))) {
          break label5729;
        }
        i = 1;
        m = j;
        if (i == 0) {
          break label5789;
        }
        i = 0;
        j = this.b.a.Hb();
        if (!localScanningData2.isStar) {
          break label5758;
        }
        m = i;
        if (j == 3) {
          break label5789;
        }
        this.b.a.a(3, localScanningData2.bsB, localScanningData2.bsC, new adfz(this, localScanningData2));
        i = 0;
        if ((localScanningData2.bMu) && ((localScanningData2.bMt) || (localScanningData2.isClicked)) && (localScanningData2.isStar) && (!localScanningData2.bMD) && (localScanningData2.us > 0.0F))
        {
          localScanningData2.bI.setAlpha((int)(localScanningData2.us * 255.0F));
          localObject = new RectF(localScanningData2.centerX + localScanningData2.cw + localScanningData2.cV + localScanningData2.uB - localScanningData2.ut - 4.0F * localScanningData2.uu, localScanningData2.centerY - localScanningData2.cw - localScanningData2.cV - localScanningData2.uC + 4.0F * localScanningData2.uu, localScanningData2.centerX + localScanningData2.cw + localScanningData2.cV + localScanningData2.uB - 4.0F * localScanningData2.uu, localScanningData2.centerY - localScanningData2.cw - localScanningData2.cV - localScanningData2.uC + localScanningData2.ut + 4.0F * localScanningData2.uu);
          localScanningData2.uJ = ((RectF)localObject).left;
          localScanningData2.uK = ((RectF)localObject).right;
          localScanningData2.uL = ((RectF)localObject).top;
          localScanningData2.uM = ((RectF)localObject).bottom;
          localScanningData2.uH = ((RectF)localObject).centerX();
          localScanningData2.uI = ((RectF)localObject).centerY();
          if ((localScanningData2.eT != null) && ((localScanningData2.uE != localScanningData2.ut) || (localScanningData2.eS == null)))
          {
            localScanningData2.uE = localScanningData2.ut;
            localScanningData2.eS = b(localScanningData2.eT, localScanningData2.ut, localScanningData2.ut);
            if (localScanningData2.eS != null) {
              localScanningData2.eS = aqhu.b(localScanningData2.eS, localScanningData2.ut / 2.0F, (int)localScanningData2.ut, (int)localScanningData2.ut);
            }
          }
          if (localScanningData2.eS != null) {
            break label5796;
          }
          localScanningData2.bI.setColor(Color.parseColor("#e7e7e7"));
          localScanningData2.bI.setStyle(Paint.Style.FILL);
          paramCanvas.drawCircle(localScanningData2.uH, localScanningData2.uI, localScanningData2.ut / 2.0F, localScanningData2.bI);
        }
      }
      for (;;)
      {
        localScanningData2.bI.setColor(-1);
        localScanningData2.bI.setStyle(Paint.Style.STROKE);
        paramCanvas.drawCircle(localScanningData2.uH, localScanningData2.uI, localScanningData2.ut / 2.0F, localScanningData2.bI);
        localScanningData2.bK.setAlpha((int)(localScanningData2.uz * 255.0F * 0.5D));
        paramCanvas.drawCircle(localScanningData2.uH, localScanningData2.uI, localScanningData2.ux * localScanningData2.uA, localScanningData2.bK);
        localScanningData2.bJ.setAlpha((int)(localScanningData2.us * 255.0F));
        localScanningData2.uF = ((float)(localScanningData2.ux * 1.2D * Math.cos(localScanningData2.uw * 3.141592653589793D / 180.0D) + localScanningData2.uH));
        localScanningData2.uG = ((float)(localScanningData2.ux * 1.2D * Math.sin(localScanningData2.uw * 3.141592653589793D / 180.0D) + localScanningData2.uI));
        f1 = (float)(localScanningData2.uv * Math.cos(0.0F * 3.141592653589793D / 180.0D) + localScanningData2.uF);
        f2 = (float)(localScanningData2.uv * Math.sin(0.0F * 3.141592653589793D / 180.0D) + localScanningData2.uG);
        f3 = (float)(localScanningData2.uv * Math.cos(120.0F * 3.141592653589793D / 180.0D) + localScanningData2.uF);
        f4 = (float)(localScanningData2.uv * Math.sin(120.0F * 3.141592653589793D / 180.0D) + localScanningData2.uG);
        f5 = (float)(localScanningData2.uv * Math.cos(240.0F * 3.141592653589793D / 180.0D) + localScanningData2.uF);
        f6 = (float)(localScanningData2.uv * Math.sin(240.0F * 3.141592653589793D / 180.0D) + localScanningData2.uG);
        localObject = new Path();
        ((Path)localObject).moveTo(f1, f2);
        ((Path)localObject).lineTo(f3, f4);
        ((Path)localObject).lineTo(f5, f6);
        ((Path)localObject).close();
        paramCanvas.drawPath((Path)localObject, localScanningData2.bJ);
        n += 1;
        j = i;
        break;
        localScanningData2.bA.setFakeBoldText(false);
        break label4178;
        localScanningData2.bA.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label4212;
        i = 0;
        break label4735;
        if (!TextUtils.isEmpty(localScanningData2.bsB))
        {
          i = 1;
          break label4735;
        }
        i = 0;
        break label4735;
        m = i;
        if (j != 2)
        {
          this.b.a.v(2, localScanningData2.bsB, false);
          m = i;
        }
        i = m;
        break label4811;
        paramCanvas.drawBitmap(localScanningData2.eS, ((RectF)localObject).left, ((RectF)localObject).top, localScanningData2.bI);
      }
    }
    label402:
    label488:
    label3315:
    label5758:
    this.b.a.dCP();
    label518:
    label3046:
    label5735:
    return;
  }
  
  private void Y(MotionEvent paramMotionEvent)
  {
    QLog.d("ScanningSurfaceView", 1, "onClick" + paramMotionEvent.getRawX() + "---" + paramMotionEvent.getRawY());
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i = 0;
    paramMotionEvent = null;
    if (i < this.T.size())
    {
      paramMotionEvent = (ScanningData)this.T.get(i);
      if ((paramMotionEvent == null) || (f1 < paramMotionEvent.uJ) || (f1 > paramMotionEvent.uK) || (f2 > paramMotionEvent.uM) || (f2 < paramMotionEvent.uL)) {}
    }
    for (i = 1;; i = 0)
    {
      MotionEvent localMotionEvent = paramMotionEvent;
      int j;
      if (i == 0)
      {
        j = 0;
        label136:
        localMotionEvent = paramMotionEvent;
        if (j < this.T.size())
        {
          paramMotionEvent = (ScanningData)this.T.get(j);
          if ((paramMotionEvent != null) && (f1 >= paramMotionEvent.am) && (f1 <= paramMotionEvent.tk) && (f2 <= paramMotionEvent.tj) && (f2 >= paramMotionEvent.an + paramMotionEvent.tl))
          {
            j = 1;
            localMotionEvent = paramMotionEvent;
          }
        }
      }
      for (;;)
      {
        if ((j != 0) && (localMotionEvent != null) && (localMotionEvent.isStar) && (!localMotionEvent.bMt) && (!localMotionEvent.bMD))
        {
          paramMotionEvent = a();
          this.mHandler.post(new ScanningSurfaceView.8(this, paramMotionEvent, localMotionEvent));
        }
        if ((i != 0) && (localMotionEvent != null) && (localMotionEvent.bMu)) {
          Gw(localMotionEvent.url);
        }
        if (j != 0) {
          anot.a(null, "dc00898", "", "", "0X8008356", "0X8008356", 0, 0, "", "", "", "");
        }
        while (i == 0)
        {
          return;
          i += 1;
          break;
          j += 1;
          break label136;
        }
        anot.a(null, "dc00898", "", "", "0X800834D", "0X800834D", 0, 0, "", "", "", "");
        return;
        j = 0;
      }
    }
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= paramFloat1) {
      return paramFloat2 - paramFloat1;
    }
    return 360.0F + paramFloat2 - paramFloat1;
  }
  
  private ScanningData a()
  {
    int i = 0;
    ScanningData localScanningData1;
    if (i < this.T.size())
    {
      localScanningData1 = (ScanningData)this.T.get(i);
      if ((localScanningData1 == null) || (!localScanningData1.bMt) || (!localScanningData1.isStar) || (localScanningData1.bMD)) {}
    }
    for (;;)
    {
      if ((localScanningData1 == null) && (this.eG.size() > 0))
      {
        Iterator localIterator = this.eG.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ScanningData localScanningData2 = (ScanningData)((Map.Entry)localIterator.next()).getValue();
            if ((localScanningData2 != null) && (localScanningData2.bMt) && (localScanningData2.isStar) && (!localScanningData2.bMD))
            {
              return localScanningData2;
              i += 1;
              break;
            }
          }
        }
      }
      return localScanningData1;
      localScanningData1 = null;
    }
  }
  
  private void a(ScanningData paramScanningData)
  {
    if ((paramScanningData == null) || (paramScanningData.bMD) || (this.eG.contains(Integer.valueOf(paramScanningData.faceID)))) {
      return;
    }
    this.eG.put(Integer.valueOf(paramScanningData.faceID), paramScanningData);
  }
  
  private boolean a(ScanningData paramScanningData1, ScanningData paramScanningData2)
  {
    return (paramScanningData1 != null) && (paramScanningData2 != null) && (paramScanningData1.faceID == paramScanningData2.faceID);
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat1 / f1, paramFloat2 / f2);
    int i = (int)f1;
    int j = (int)f2;
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        QLog.e("ScanningSurfaceView", 1, "zoomImage got an OutOfMemoryError.", paramBitmap);
        paramBitmap = null;
      }
    }
  }
  
  private void b(ScanningData paramScanningData)
  {
    int i;
    if (paramScanningData != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.T.size())
        {
          ScanningData localScanningData = (ScanningData)this.T.get(i);
          if (localScanningData != null)
          {
            if ((localScanningData.faceID != paramScanningData.faceID) || (localScanningData.bMD != paramScanningData.bMD)) {
              break label90;
            }
            return;
          }
          this.T.remove(i);
          break label90;
        }
        this.T.add(paramScanningData);
        return;
      }
      catch (Exception paramScanningData)
      {
        QLog.e("ScanningSurfaceView", 1, "addFaceData", paramScanningData);
      }
      return;
      label90:
      i += 1;
    }
  }
  
  private void c(ScanningData paramScanningData)
  {
    if ((paramScanningData != null) && ((paramScanningData.eT == null) || (paramScanningData.eS == null)) && (!TextUtils.isEmpty(paramScanningData.imgUrl))) {
      ThreadManager.post(new ScanningSurfaceView.3(this, paramScanningData), 5, null, true);
    }
  }
  
  private void d(ScanningData paramScanningData)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.T.size())
      {
        ScanningData localScanningData = (ScanningData)this.T.get(i);
        if (a(localScanningData, paramScanningData))
        {
          localScanningData.bMt = paramScanningData.bMt;
          if (QLog.isColorLevel()) {
            QLog.d("ScanningSurfaceView", 2, "6=" + localScanningData.bMt);
          }
          localScanningData.isClicked = paramScanningData.isClicked;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void init()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.mHandlerThread = new HandlerThread("ScanningSurfaceAnimationThread");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.k = new HandlerThread("ScanningSurfaceDrawThread");
    this.k.start();
    this.mDrawHandler = new Handler(this.k.getLooper());
    setOnTouchListener(this.y);
  }
  
  private void jy(List<ScanningData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ScanningData)paramList.next());
      }
    }
  }
  
  public void cRm()
  {
    float f1;
    int i;
    int j;
    Object localObject2;
    int m;
    Object localObject1;
    DrawView2.a locala;
    RectF localRectF;
    if ((this.da != null) && (this.da.size() > 0))
    {
      if (a() == null)
      {
        if (this.da.get(0) != null) {}
        for (f1 = ((DrawView2.a)this.da.get(0)).confidence;; f1 = 0.0F)
        {
          i = 1;
          for (j = 0; i < this.da.size(); j = m)
          {
            localObject2 = (DrawView2.a)this.da.get(i);
            m = j;
            if (localObject2 != null)
            {
              m = j;
              if (((DrawView2.a)localObject2).confidence > f1) {
                m = i;
              }
            }
            if ((localObject2 != null) && (QLog.isColorLevel()))
            {
              localObject1 = acfp.m(2131714001);
              if (!TextUtils.isEmpty(((DrawView2.a)localObject2).name)) {
                localObject1 = ((DrawView2.a)localObject2).name;
              }
              QLog.d("ScanningSurfaceView", 2, "name = " + (String)localObject1 + ",confidence = " + ((DrawView2.a)localObject2).confidence + ",faceId = " + ((DrawView2.a)localObject2).faceID + ",isTmpFace = " + ((DrawView2.a)localObject2).bMw);
            }
            i += 1;
          }
        }
        localObject1 = (DrawView2.a)this.da.get(j);
        if (localObject1 != null) {
          ((DrawView2.a)localObject1).bMt = true;
        }
      }
      j = 0;
      if (j < this.da.size())
      {
        locala = (DrawView2.a)this.da.get(j);
        if (locala != null)
        {
          localRectF = locala.h();
          i = 0;
          if (i >= this.T.size()) {
            break label1702;
          }
          localObject2 = (ScanningData)this.T.get(i);
          if ((localObject2 != null) && (((ScanningData)localObject2).faceID == locala.faceID) && (((ScanningData)localObject2).bMD == locala.bMw)) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      m = i;
      if (!locala.bMw)
      {
        localObject1 = localObject2;
        m = i;
        if (i == 0)
        {
          localObject1 = localObject2;
          m = i;
          if (this.eG.containsKey(Integer.valueOf(locala.faceID)))
          {
            localObject2 = (ScanningData)this.eG.get(Integer.valueOf(locala.faceID));
            localObject1 = localObject2;
            m = i;
            if (localObject2 != null)
            {
              b((ScanningData)localObject2);
              this.eG.remove(Integer.valueOf(locala.faceID));
              m = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      label522:
      boolean bool;
      if (m == 0) {
        if ((locala.bMt) && (locala.isStar) && (!locala.bMw))
        {
          localObject1 = new adfl(getContext());
          ((ScanningData)localObject1).bMD = locala.bMw;
          ((ScanningData)localObject1).faceID = locala.faceID;
          if (!locala.bMw)
          {
            ((ScanningData)localObject1).bMt = locala.bMt;
            if (QLog.isColorLevel()) {
              QLog.d("ScanningSurfaceView", 2, "1=" + ((ScanningData)localObject1).bMt);
            }
            ((ScanningData)localObject1).uin = locala.uin;
            ((ScanningData)localObject1).bsz = locala.name;
            ((ScanningData)localObject1).bsA = locala.enName;
            ((ScanningData)localObject1).url = locala.url;
            ((ScanningData)localObject1).isStar = locala.isStar;
            ((ScanningData)localObject1).bMu = locala.bMu;
            ((ScanningData)localObject1).at = localRectF;
            ((ScanningData)localObject1).imgUrl = locala.imgUrl;
            ((ScanningData)localObject1).bsx = locala.bsx;
            if ((!((ScanningData)localObject1).bMu) || (TextUtils.isEmpty(((ScanningData)localObject1).url)) || (TextUtils.isEmpty(((ScanningData)localObject1).imgUrl))) {
              break label1044;
            }
            bool = true;
            label716:
            ((ScanningData)localObject1).bMu = bool;
            if (!((ScanningData)localObject1).isStar) {
              break label1050;
            }
            ((ScanningData)localObject1).bsB = locala.bsv;
            ((ScanningData)localObject1).bsC = locala.bsw;
            label751:
            if ((!((ScanningData)localObject1).bMC) && (QLog.isColorLevel()))
            {
              ((ScanningData)localObject1).bMC = true;
              QLog.d("ScanningSurfaceView", 2, "isMainFace = " + ((ScanningData)localObject1).bMt + ", fNCH = " + ((ScanningData)localObject1).bsz + ", faceID = " + ((ScanningData)localObject1).faceID + ", isStar = " + ((ScanningData)localObject1).isStar + ", isActivate = " + ((ScanningData)localObject1).bMu + ", fCTitleText = " + ((ScanningData)localObject1).bsB + ", fCContentText = " + ((ScanningData)localObject1).bsC + ", url = " + ((ScanningData)localObject1).url + ", imgUrl = " + ((ScanningData)localObject1).imgUrl + ", wikiUrl = " + ((ScanningData)localObject1).bsx);
            }
          }
          b((ScanningData)localObject1);
        }
      }
      for (;;)
      {
        ((ScanningData)localObject1).at = localRectF;
        if (((ScanningData)localObject1).bMt)
        {
          i = 0;
          for (;;)
          {
            if (i < this.T.size())
            {
              localObject2 = (ScanningData)this.T.get(i);
              if ((localObject2 != null) && (((ScanningData)localObject2).faceID != ((ScanningData)localObject1).faceID) && (!((ScanningData)localObject2).isStar) && (((ScanningData)localObject2).bMt)) {
                ((ScanningData)localObject2).bMt = false;
              }
              i += 1;
              continue;
              i += 1;
              break;
              localObject1 = new adgb(getContext());
              break label522;
              label1044:
              bool = false;
              break label716;
              label1050:
              localObject2 = adau.a(getContext()).a();
              if (localObject2 == null) {
                break label751;
              }
              ((ScanningData)localObject1).bsB = ((ARScanStarFaceConfigInfo)localObject2).bsM;
              break label751;
            }
          }
        }
        if (localRectF != null)
        {
          f1 = localRectF.centerX();
          float f2 = localRectF.centerY();
          this.jdField_a_of_type_ComTencentMobileqqArScanningData = ((ScanningData)localObject1);
          if ((Math.abs(f1 - ((ScanningData)localObject1).centerX) > ScanningData.a.FR) || (Math.abs(f2 - ((ScanningData)localObject1).centerY) > ScanningData.a.FR))
          {
            ((ScanningData)localObject1).centerX = f1;
            ((ScanningData)localObject1).centerY = f2;
          }
          QLog.d("ScanningSurfaceView", 1, "centerX = " + f1 + ", centerY = " + f2);
          f1 = (float)Math.sqrt(localRectF.width() * localRectF.width() + localRectF.height() * localRectF.height());
          f1 = Math.min(((ScanningData)localObject1).cv, f1 / 2.0F);
          if (((ScanningData)localObject1).cB > 0.0F)
          {
            this.scale = (f1 / ((ScanningData)localObject1).cB);
            label1249:
            if (this.scale > 100.0F) {
              this.scale = 1.0F;
            }
            if (!((ScanningData)localObject1).bMB) {
              break label1425;
            }
            this.scale *= 0.9F;
            label1285:
            QLog.d("ScanningSurfaceView", 1, "scale = " + this.scale + ",scanningData.scale = " + ((ScanningData)localObject1).scale + ", trueRadius = " + f1 + ", iBCRadiusFix = " + ((ScanningData)localObject1).cB);
          }
        }
        else
        {
          if (!this.isRunning) {
            break label1440;
          }
          if (Math.abs(((ScanningData)localObject1).scale - this.scale) >= 0.03D)
          {
            ((ScanningData)localObject1).reset();
            ((ScanningData)localObject1).k(this.scale);
          }
        }
        for (;;)
        {
          if (!((ScanningData)localObject1).bMD) {
            c((ScanningData)localObject1);
          }
          j += 1;
          break;
          this.scale = 1.0F;
          break label1249;
          label1425:
          this.scale *= 0.95F;
          break label1285;
          label1440:
          ((ScanningData)localObject1).reset();
          ((ScanningData)localObject1).k(this.scale);
        }
        i = 0;
        if (i < this.T.size())
        {
          localObject1 = (ScanningData)this.T.get(i);
          j = 0;
          label1486:
          if (j >= this.da.size()) {
            break label1693;
          }
          localObject2 = (DrawView2.a)this.da.get(j);
          if ((localObject2 == null) || (localObject1 == null) || (((ScanningData)localObject1).faceID != ((DrawView2.a)localObject2).faceID) || (((ScanningData)localObject1).bMD != ((DrawView2.a)localObject2).bMw)) {}
        }
        label1693:
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            a((ScanningData)localObject1);
            this.T.remove(i);
            QLog.d("ckwkenvencai", 1, "remove2");
          }
          i += 1;
          break;
          j += 1;
          break label1486;
          this.qm = false;
          if ((!this.isRunning) && (this.T.size() > 0))
          {
            this.isRunning = true;
            this.mDrawHandler.post(this.X);
          }
          if (this.T.size() == 0) {
            this.isRunning = false;
          }
          do
          {
            return;
            clear();
            QLog.e("ScanningSurfaceView", 1, "lost the face data.");
          } while (this.b.a.Hb() == 0);
          this.b.a.dCP();
          return;
        }
      }
      label1702:
      i = 0;
      localObject2 = null;
    }
  }
  
  public void cRy()
  {
    this.eG.clear();
  }
  
  public void clear()
  {
    this.qm = true;
    this.isRunning = false;
    jy(this.T);
    this.T.clear();
    if ((this.b != null) && (this.b.a != null) && (this.b.a.Hb() != 0)) {
      this.b.a.dCP();
    }
    QLog.d("ScanningSurfaceView", 1, "clear the animation and face data.");
  }
  
  public void setFaceData(List<DrawView2.a> paramList)
  {
    try
    {
      this.da = paramList;
      cRm();
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ScanningSurfaceView", 1, "setFaceData catch an exception.", paramList);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceChanged");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceCreated");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    clear();
    if (QLog.isColorLevel()) {
      QLog.d("ScanningSurfaceView", 2, "surfaceDestroyed");
    }
  }
  
  class DrawThread
    extends Thread
  {
    public void run()
    {
      while (ScanningSurfaceView.a(this.this$0))
      {
        long l = System.currentTimeMillis();
        ScanningSurfaceView.a(this.this$0);
        try
        {
          Thread.sleep(Math.max(0L, ScanningSurfaceView.a(this.this$0) - (System.currentTimeMillis() - l)));
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (ScanningSurfaceView.b(this.this$0)) {
        ScanningSurfaceView.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView
 * JD-Core Version:    0.7.0.1
 */