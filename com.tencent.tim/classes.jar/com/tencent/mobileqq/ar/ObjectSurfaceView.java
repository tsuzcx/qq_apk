package com.tencent.mobileqq.ar;

import acfp;
import adfd;
import adfm;
import adfo;
import akqe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import anot;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private CopyOnWriteArrayList<ObjectBaseData> T = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<String> U = new CopyOnWriteArrayList();
  private Runnable X = new ObjectSurfaceView.1(this);
  BlurMaskFilter jdField_a_of_type_AndroidGraphicsBlurMaskFilter;
  SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  public adfd b;
  int[] colors = { Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255) };
  private List<DrawView2.a> da;
  private ConcurrentHashMap<String, ObjectBaseData> eG = new ConcurrentHashMap();
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
  
  public ObjectSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ObjectSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
          QLog.d("ObjectSurfaceView", 1, "clearCanvas");
        }
      }
      catch (Exception localException4)
      {
        Canvas localCanvas;
        localObject3 = localObject1;
        QLog.e("ObjectSurfaceView", 1, "doDraw catch an exception.", localException4);
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
          QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException1);
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
        QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException2);
        return;
      }
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      Q(localCanvas);
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      QLog.d("ObjectSurfaceView", 1, "drawCanvas");
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
        QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", localException3);
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
      anot.a(null, "dc00898", "", "", "0X800899A", "0X800899A", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
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
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  private void Q(Canvas paramCanvas)
  {
    ObjectBaseData localObjectBaseData1;
    int n;
    int j;
    if (paramCanvas != null)
    {
      localObjectBaseData1 = a();
      n = 0;
      j = 1;
      if (n >= this.T.size()) {
        break label6541;
      }
      localObjectBaseData2 = (ObjectBaseData)this.T.get(n);
      if (localObjectBaseData2 != null) {
        break label48;
      }
    }
    label48:
    label247:
    while (j == 0)
    {
      ObjectBaseData localObjectBaseData2;
      return;
      Object localObject1;
      Object localObject2;
      if (!localObjectBaseData2.ql)
      {
        this.mHandler.post(new ObjectSurfaceView.2(this, localObjectBaseData2, localObjectBaseData1));
        if ((localObjectBaseData2.bMt) && (!localObjectBaseData2.bMB) && (localObjectBaseData2.bMu) && (!localObjectBaseData2.bMD))
        {
          if (TextUtils.isEmpty(localObjectBaseData2.uin)) {
            break label3632;
          }
          if (!this.U.contains(localObjectBaseData2.uin))
          {
            localObject1 = localObjectBaseData2.uin;
            localObject2 = localObjectBaseData2.url;
            this.mHandler.postDelayed(new ObjectSurfaceView.3(this, (String)localObject1, (String)localObject2), 4000L);
          }
        }
      }
      localObjectBaseData2.F.setColor(localObjectBaseData2.FG);
      localObjectBaseData2.F.setStrokeWidth(localObjectBaseData2.bY);
      float f1;
      float f5;
      float f2;
      float f3;
      float f4;
      float f6;
      float f7;
      float f8;
      if (((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
      {
        localObjectBaseData2.F.setAlpha((int)(localObjectBaseData2.cl * 255.0F));
        f1 = localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY;
        localObject1 = new RectF(localObjectBaseData2.centerX - f1, localObjectBaseData2.centerY - f1, localObjectBaseData2.centerX + f1, f1 + localObjectBaseData2.centerY);
        if ((localObjectBaseData2.FG != -1) && (localObjectBaseData2.bMt) && (!localObjectBaseData2.bMD)) {
          break label3690;
        }
        localObjectBaseData2.F.setShader(null);
        if (localObjectBaseData2.dn == 0.0F) {
          break label3778;
        }
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = new BlurMaskFilter(localObjectBaseData2.jdField_do * localObjectBaseData2.dn, BlurMaskFilter.Blur.SOLID);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3786;
        }
        localObjectBaseData2.F.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localObjectBaseData2.F.setShader(null);
        f1 = localObjectBaseData2.bZ;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.bX + f1, a(localObjectBaseData2.bZ + localObjectBaseData2.bX, localObjectBaseData2.ca + localObjectBaseData2.bX), false, localObjectBaseData2.F);
        if ((localObjectBaseData2.FG != -1) && (localObjectBaseData2.bMt) && (!localObjectBaseData2.bMD)) {
          break label3799;
        }
        localObjectBaseData2.F.setShader(null);
        if (this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter == null) {
          break label3910;
        }
        localObjectBaseData2.F.setMaskFilter(this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter);
        localObjectBaseData2.F.setShader(null);
        f1 = localObjectBaseData2.cb;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.bX + f1, a(localObjectBaseData2.cb + localObjectBaseData2.bX, localObjectBaseData2.cc + localObjectBaseData2.bX), false, localObjectBaseData2.F);
        if ((localObjectBaseData2.ck > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          f5 = localObjectBaseData2.bY;
          localObjectBaseData2.cg = ((float)((localObjectBaseData2.bV * localObjectBaseData2.bW + f5) * Math.cos((localObjectBaseData2.ce + localObjectBaseData2.bX) * 3.141592653589793D / 180.0D) + localObjectBaseData2.centerX));
          localObjectBaseData2.ch = ((float)((localObjectBaseData2.bV * localObjectBaseData2.bW + f5) * Math.sin((localObjectBaseData2.ce + localObjectBaseData2.bX) * 3.141592653589793D / 180.0D) + localObjectBaseData2.centerY));
          f2 = localObjectBaseData2.cf + localObjectBaseData2.bX;
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
          f4 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cg);
          f1 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ch);
          f6 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cg);
          f2 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ch);
          f7 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cg);
          f3 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ch);
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f4, f1);
          ((Path)localObject1).lineTo(f6, f2);
          ((Path)localObject1).lineTo(f7, f3);
          ((Path)localObject1).close();
          localObjectBaseData2.G.setColor(localObjectBaseData2.FE);
          localObjectBaseData2.G.setAlpha((int)(localObjectBaseData2.ck * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.G);
          localObjectBaseData2.ci = ((float)((localObjectBaseData2.bV * localObjectBaseData2.bW + f5) * Math.cos((localObjectBaseData2.cf + localObjectBaseData2.bX) * 3.141592653589793D / 180.0D) + localObjectBaseData2.centerX));
          localObjectBaseData2.cj = ((float)((localObjectBaseData2.bV * localObjectBaseData2.bW + f5) * Math.sin((localObjectBaseData2.cf + localObjectBaseData2.bX) * 3.141592653589793D / 180.0D) + localObjectBaseData2.centerY));
          f2 = localObjectBaseData2.ce + localObjectBaseData2.bX;
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
          f4 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ci);
          f1 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f1 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cj);
          f5 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ci);
          f2 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f2 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cj);
          f6 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.cos(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.ci);
          f3 = (float)(localObjectBaseData2.cd * localObjectBaseData2.bW * Math.sin(f3 * 3.141592653589793D / 180.0D) + localObjectBaseData2.cj);
          ((Path)localObject1).reset();
          ((Path)localObject1).moveTo(f4, f1);
          ((Path)localObject1).lineTo(f5, f2);
          ((Path)localObject1).lineTo(f6, f3);
          ((Path)localObject1).close();
          localObjectBaseData2.G.setColor(localObjectBaseData2.FF);
          localObjectBaseData2.G.setAlpha((int)(localObjectBaseData2.ck * 255.0F));
          paramCanvas.drawPath((Path)localObject1, localObjectBaseData2.G);
        }
        if ((localObjectBaseData2.cu > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          localObjectBaseData2.H.setColor(localObjectBaseData2.FH);
          localObjectBaseData2.H.setStrokeWidth(localObjectBaseData2.cp);
          localObjectBaseData2.H.setAlpha((int)(localObjectBaseData2.cu * 255.0F * 0.4D));
          f1 = localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp;
          localObject1 = new RectF(localObjectBaseData2.centerX - f1, localObjectBaseData2.centerY - f1, localObjectBaseData2.centerX + f1, f1 + localObjectBaseData2.centerY);
          f1 = localObjectBaseData2.cq;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.co + f1, a(localObjectBaseData2.cq + localObjectBaseData2.co, localObjectBaseData2.cr + localObjectBaseData2.co), false, localObjectBaseData2.H);
          f1 = localObjectBaseData2.cs;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.co + f1, a(localObjectBaseData2.cs + localObjectBaseData2.co, localObjectBaseData2.ct + localObjectBaseData2.co), false, localObjectBaseData2.H);
        }
        localObjectBaseData2.I.setColor(localObjectBaseData2.FI);
        localObjectBaseData2.I.setStrokeWidth(localObjectBaseData2.cC);
        localObjectBaseData2.I.setAlpha((int)(localObjectBaseData2.cJ * 255.0F * 0.3D));
        f1 = localObjectBaseData2.cw * localObjectBaseData2.cz + localObjectBaseData2.cC;
        localObject1 = new RectF(localObjectBaseData2.centerX - f1, localObjectBaseData2.centerY - f1, localObjectBaseData2.centerX + f1, f1 + localObjectBaseData2.centerY);
        f1 = localObjectBaseData2.cD;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cD + localObjectBaseData2.cA, localObjectBaseData2.cE + localObjectBaseData2.cA), false, localObjectBaseData2.I);
        f1 = localObjectBaseData2.cH;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cH + localObjectBaseData2.cA, localObjectBaseData2.cI + localObjectBaseData2.cA), false, localObjectBaseData2.I);
        f1 = localObjectBaseData2.cF;
        paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cF + localObjectBaseData2.cA, localObjectBaseData2.cG + localObjectBaseData2.cA), false, localObjectBaseData2.I);
        if ((localObjectBaseData2.cS > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          localObjectBaseData2.J.setColor(localObjectBaseData2.FJ);
          localObjectBaseData2.J.setStrokeWidth(localObjectBaseData2.cL);
          localObjectBaseData2.J.setAlpha((int)(localObjectBaseData2.cS * 255.0F));
          f1 = localObjectBaseData2.cM;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cM + localObjectBaseData2.cA, localObjectBaseData2.cN + localObjectBaseData2.cA), false, localObjectBaseData2.J);
          f1 = localObjectBaseData2.cQ;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cQ + localObjectBaseData2.cA, localObjectBaseData2.cR + localObjectBaseData2.cA), false, localObjectBaseData2.J);
          f1 = localObjectBaseData2.cO;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cA + f1, a(localObjectBaseData2.cO + localObjectBaseData2.cA, localObjectBaseData2.cP + localObjectBaseData2.cA), false, localObjectBaseData2.J);
        }
        if ((localObjectBaseData2.cW > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          localObjectBaseData2.K.setColor(localObjectBaseData2.FK);
          localObjectBaseData2.K.setStrokeWidth(localObjectBaseData2.cV);
          localObjectBaseData2.K.setAlpha((int)(localObjectBaseData2.cW * 255.0F * 0.1D));
          f1 = localObjectBaseData2.cV / 2.0F;
          paramCanvas.drawCircle(localObjectBaseData2.centerX, localObjectBaseData2.centerY, f1 + localObjectBaseData2.cT * localObjectBaseData2.cU, localObjectBaseData2.K);
        }
        if ((localObjectBaseData2.dj > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          localObjectBaseData2.L.setColor(localObjectBaseData2.FL);
          localObjectBaseData2.L.setStrokeWidth(localObjectBaseData2.da);
          localObjectBaseData2.L.setAlpha((int)(localObjectBaseData2.dj * 255.0F * 0.3D));
          f1 = localObjectBaseData2.cZ * localObjectBaseData2.cX + localObjectBaseData2.da;
          localObject1 = new RectF(localObjectBaseData2.centerX - f1, localObjectBaseData2.centerY - f1, localObjectBaseData2.centerX + f1, f1 + localObjectBaseData2.centerY);
          f1 = localObjectBaseData2.dd;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cY + f1, a(localObjectBaseData2.dd + localObjectBaseData2.cY, localObjectBaseData2.de + localObjectBaseData2.cY), false, localObjectBaseData2.L);
          f1 = localObjectBaseData2.db;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cY + f1, a(localObjectBaseData2.db + localObjectBaseData2.cY, localObjectBaseData2.dc + localObjectBaseData2.cY), false, localObjectBaseData2.L);
          f1 = localObjectBaseData2.dh;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cY + f1, a(localObjectBaseData2.dh + localObjectBaseData2.cY, localObjectBaseData2.di + localObjectBaseData2.cY), false, localObjectBaseData2.L);
          f1 = localObjectBaseData2.df;
          paramCanvas.drawArc((RectF)localObject1, localObjectBaseData2.cY + f1, a(localObjectBaseData2.df + localObjectBaseData2.cY, localObjectBaseData2.dg + localObjectBaseData2.cY), false, localObjectBaseData2.L);
        }
        if ((localObjectBaseData2.dm > 0.0F) && ((localObjectBaseData2.bMt) || (localObjectBaseData2.isClicked)) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
        {
          localObjectBaseData2.M.setColor(localObjectBaseData2.FM);
          localObjectBaseData2.M.setAlpha((int)(localObjectBaseData2.dm * 255.0F));
          paramCanvas.drawCircle(localObjectBaseData2.centerX, localObjectBaseData2.centerY, 0.0F + localObjectBaseData2.dl * localObjectBaseData2.dk, localObjectBaseData2.M);
        }
        i = 1;
        if (localObjectBaseData2.centerY < localObjectBaseData2.bV + (float)a(localObjectBaseData2) + 80.0F) {
          i = 2;
        }
        if ((!localObjectBaseData2.isStar) || (localObjectBaseData2.tG <= 0.0F) || (localObjectBaseData2.bMD) || (i != 1)) {
          break label4900;
        }
        localObjectBaseData2.bB.setAlpha((int)(localObjectBaseData2.tG * 255.0F));
        localObjectBaseData2.bB.setStrokeWidth(localObjectBaseData2.tr);
        localObjectBaseData2.bA.setStrokeWidth(localObjectBaseData2.tq);
        localObjectBaseData2.bA.setAlpha((int)(localObjectBaseData2.tG * 255.0F));
        if ((!localObjectBaseData2.bMt) || (localObjectBaseData2.cn == 0.0F)) {
          break label3923;
        }
        localObjectBaseData2.tl = ((localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp) * 2.0F / 3.6F);
        if (localObjectBaseData2.tl > localObjectBaseData2.tm) {
          localObjectBaseData2.tl = localObjectBaseData2.tm;
        }
        if (localObjectBaseData2.tl < localObjectBaseData2.tn) {
          localObjectBaseData2.tl = localObjectBaseData2.tn;
        }
        localObjectBaseData2.to = (localObjectBaseData2.centerX - localObjectBaseData2.bV * localObjectBaseData2.bW - localObjectBaseData2.bY - localObjectBaseData2.tD);
        localObjectBaseData2.tp = (localObjectBaseData2.centerY - localObjectBaseData2.bV * localObjectBaseData2.bW - localObjectBaseData2.bY - localObjectBaseData2.tE * localObjectBaseData2.tR);
        if ((!localObjectBaseData2.bMt) || (!localObjectBaseData2.isStar) || (localObjectBaseData2.cn == 0.0F)) {
          break label3954;
        }
        localObjectBaseData2.to = (localObjectBaseData2.centerX - localObjectBaseData2.bV * localObjectBaseData2.bW - localObjectBaseData2.bY - localObjectBaseData2.tD - ObjectBaseData.a.cEw);
        localObjectBaseData2.an = (localObjectBaseData2.tp - localObjectBaseData2.tl);
        localObjectBaseData2.tj = (localObjectBaseData2.centerY + localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp);
        localObjectBaseData2.tk = (localObjectBaseData2.centerX + localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp);
        localObjectBaseData2.am = localObjectBaseData2.to;
        f3 = localObjectBaseData2.centerX;
        f4 = localObjectBaseData2.cw;
        f5 = localObjectBaseData2.cV;
        f6 = localObjectBaseData2.uB;
        f7 = localObjectBaseData2.ut;
        f8 = localObjectBaseData2.uu;
        if ((TextUtils.isEmpty(localObjectBaseData2.bsz)) || (TextUtils.isEmpty(localObjectBaseData2.bsA))) {
          break label4485;
        }
        localObjectBaseData2.bsA = localObjectBaseData2.bsA.toUpperCase();
        localObjectBaseData2.bB.setTextSize(localObjectBaseData2.tz * localObjectBaseData2.tR);
        localObjectBaseData2.bB.setTextAlign(Paint.Align.LEFT);
        if (localObjectBaseData2.tG == 0.0F) {
          break label4039;
        }
        localObjectBaseData2.bB.setShadowLayer(localObjectBaseData2.tI, 0.0F, localObjectBaseData2.tJ, localObjectBaseData2.cEk);
      }
      float f9;
      float f10;
      for (;;)
      {
        localObject1 = localObjectBaseData2.bB.getFontMetrics();
        f2 = localObjectBaseData2.tp + ((Paint.FontMetrics)localObject1).top;
        f1 = localObjectBaseData2.tp;
        f9 = ((Paint.FontMetrics)localObject1).bottom + f1;
        if (localObjectBaseData2.tt != 0.0F) {
          break label4066;
        }
        f10 = localObjectBaseData2.am;
        f1 = localObjectBaseData2.ts;
        localObjectBaseData2.h.setTextSize(localObjectBaseData2.tR * f1);
        while (localObjectBaseData2.h.measureText(localObjectBaseData2.bsz) > f3 + f4 + f5 + f6 - f7 - 4.0F * f8 - f10)
        {
          f1 -= 1.0F;
          localObjectBaseData2.h.setTextSize(localObjectBaseData2.tR * f1);
        }
        if (!localObjectBaseData2.bMu) {
          break;
        }
        this.mHandler.postDelayed(new ObjectSurfaceView.4(this, localObjectBaseData2), 4000L);
        break;
        localObjectBaseData2.F.setAlpha((int)(localObjectBaseData2.cl * 255.0F * 0.5D));
        break label247;
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.centerX, localObjectBaseData2.centerY, this.colors, this.positions);
        this.matrix.setRotate(localObjectBaseData2.bZ + localObjectBaseData2.bX - 5.0F, localObjectBaseData2.centerX, localObjectBaseData2.centerY);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.matrix);
        localObjectBaseData2.F.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label337;
        this.jdField_a_of_type_AndroidGraphicsBlurMaskFilter = null;
        break label372;
        localObjectBaseData2.F.setMaskFilter(null);
        break label402;
        this.colors = new int[] { localObjectBaseData2.FD, localObjectBaseData2.FC };
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(localObjectBaseData2.centerX, localObjectBaseData2.centerY, this.colors, this.positions);
        this.matrix.setRotate(localObjectBaseData2.cb + localObjectBaseData2.bX - 5.0F, localObjectBaseData2.centerX, localObjectBaseData2.centerY);
        this.jdField_a_of_type_AndroidGraphicsSweepGradient.setLocalMatrix(this.matrix);
        localObjectBaseData2.F.setShader(this.jdField_a_of_type_AndroidGraphicsSweepGradient);
        break label488;
        localObjectBaseData2.F.setMaskFilter(null);
        break label518;
        localObjectBaseData2.tl = ((localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY) * 2.0F / 3.6F);
        break label3084;
        localObjectBaseData2.an = (localObjectBaseData2.tp - localObjectBaseData2.tl);
        localObjectBaseData2.tj = (localObjectBaseData2.centerY + localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY);
        localObjectBaseData2.tk = (localObjectBaseData2.centerX + localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY);
        localObjectBaseData2.am = localObjectBaseData2.to;
        break label3353;
        localObjectBaseData2.bB.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      localObjectBaseData2.tt = (f1 / localObjectBaseData2.scale);
      localObjectBaseData2.ts = (localObjectBaseData2.tt * localObjectBaseData2.scale);
      localObjectBaseData2.ts = localObjectBaseData2.tv;
      localObjectBaseData2.tz = localObjectBaseData2.tB;
      localObjectBaseData2.bA.setTextSize(localObjectBaseData2.ts * localObjectBaseData2.tR);
      localObjectBaseData2.bA.setTextAlign(Paint.Align.LEFT);
      int m;
      String str;
      boolean bool;
      if (localObjectBaseData2.bMt)
      {
        localObjectBaseData2.bA.setFakeBoldText(true);
        if (localObjectBaseData2.tG == 0.0F) {
          break label4696;
        }
        localObjectBaseData2.bA.setShadowLayer(localObjectBaseData2.tI, 0.0F, localObjectBaseData2.tJ, localObjectBaseData2.cEk);
        paramCanvas.drawText(localObjectBaseData2.bsA, localObjectBaseData2.to, localObjectBaseData2.tp, localObjectBaseData2.bB);
        i = localObjectBaseData2.bsz.length();
        if (i >= 9) {
          break label4711;
        }
        paramCanvas.drawText(localObjectBaseData2.bsz, localObjectBaseData2.to, localObjectBaseData2.tp - localObjectBaseData2.tF - (f9 - f2), localObjectBaseData2.bA);
        localObjectBaseData2.bC.setAlpha((int)(localObjectBaseData2.tN * 255.0F));
        f1 = localObjectBaseData2.tp + localObjectBaseData2.tE * localObjectBaseData2.tR;
        f2 = localObjectBaseData2.to + localObjectBaseData2.tQ;
        f3 = f1 + localObjectBaseData2.tO * localObjectBaseData2.tR;
        f4 = f2 + (float)(localObjectBaseData2.tP * localObjectBaseData2.tR * Math.cos(localObjectBaseData2.tL * 3.141592653589793D / 180.0D));
        f5 = f3 + (float)(localObjectBaseData2.tP * localObjectBaseData2.tR * Math.sin(localObjectBaseData2.tL * 3.141592653589793D / 180.0D));
        if (localObjectBaseData2.tN >= 0.2D) {
          paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.bC);
        }
        if (localObjectBaseData2.tN >= 0.5D) {
          paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.bC);
        }
        localObjectBaseData2.bD.setAlpha((int)(localObjectBaseData2.tN * 255.0F));
        paramCanvas.drawCircle(f4, f5, localObjectBaseData2.tS, localObjectBaseData2.bD);
        m = j;
        if (localObjectBaseData2.tV <= 0.0F) {
          break label6534;
        }
        if (!localObjectBaseData2.bMt)
        {
          m = j;
          if (!localObjectBaseData2.isClicked) {
            break label6534;
          }
        }
        m = j;
        if (localObjectBaseData2.bMD) {
          break label6534;
        }
        if (!localObjectBaseData2.isStar) {
          break label6474;
        }
        if ((TextUtils.isEmpty(localObjectBaseData2.bsB)) || (TextUtils.isEmpty(localObjectBaseData2.bsC))) {
          break label6468;
        }
        i = 1;
        m = j;
        if (i == 0) {
          break label6534;
        }
        i = 0;
        j = this.b.a.Hb();
        if (!localObjectBaseData2.isStar) {
          break label6503;
        }
        m = i;
        if (j == 3) {
          break label6534;
        }
        localObject1 = this.b.a;
        localObject2 = localObjectBaseData2.bsB;
        str = localObjectBaseData2.bsC;
        adfo localadfo = new adfo(this, localObjectBaseData2);
        if (TextUtils.isEmpty(localObjectBaseData2.bsx)) {
          break label6497;
        }
        bool = true;
        ((akqe)localObject1).a((String)localObject2, str, localadfo, bool);
      }
      for (int i = 0;; i = m)
      {
        n += 1;
        j = i;
        break;
        localObjectBaseData2.bA.setFakeBoldText(false);
        break label4149;
        localObjectBaseData2.bA.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label4183;
        str = localObjectBaseData2.bsz.substring(0, 7);
        localObject2 = localObjectBaseData2.bsz.substring(7, i);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = ((String)localObject2).substring(0, 6) + "...";
        }
        localObject2 = new Rect();
        localObjectBaseData2.bA.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
        f1 = localObjectBaseData2.tF;
        i = (int)(((Rect)localObject2).bottom - ((Rect)localObject2).top + f1);
        paramCanvas.drawText((String)localObject1, localObjectBaseData2.to, localObjectBaseData2.tp - (f9 - f2), localObjectBaseData2.bA);
        i = (int)(i + (f9 - f2 + 20.0F));
        paramCanvas.drawText(str, localObjectBaseData2.to, localObjectBaseData2.tp - i, localObjectBaseData2.bA);
        break label4259;
        if ((!localObjectBaseData2.isStar) || (localObjectBaseData2.tG <= 0.0F) || (localObjectBaseData2.bMD) || (i != 2)) {
          break label4485;
        }
        localObjectBaseData2.bB.setAlpha((int)(localObjectBaseData2.tG * 255.0F));
        localObjectBaseData2.bB.setStrokeWidth(localObjectBaseData2.tr);
        localObjectBaseData2.bA.setStrokeWidth(localObjectBaseData2.tq);
        localObjectBaseData2.bA.setAlpha((int)(localObjectBaseData2.tG * 255.0F));
        if ((localObjectBaseData2.bMt) && (localObjectBaseData2.cn != 0.0F))
        {
          localObjectBaseData2.tl = ((localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp) * 2.0F / 3.6F);
          if (localObjectBaseData2.tl > localObjectBaseData2.tm) {
            localObjectBaseData2.tl = localObjectBaseData2.tm;
          }
          if (localObjectBaseData2.tl < localObjectBaseData2.tn) {
            localObjectBaseData2.tl = localObjectBaseData2.tn;
          }
          localObjectBaseData2.to = (localObjectBaseData2.centerX - localObjectBaseData2.bV * localObjectBaseData2.bW - localObjectBaseData2.bY - localObjectBaseData2.tD);
          localObjectBaseData2.tp = (localObjectBaseData2.centerY + localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY + localObjectBaseData2.tE * localObjectBaseData2.tR);
          if ((!localObjectBaseData2.bMt) || (!localObjectBaseData2.isStar) || (localObjectBaseData2.cn == 0.0F)) {
            break label5619;
          }
          localObjectBaseData2.to = (localObjectBaseData2.centerX - localObjectBaseData2.bV * localObjectBaseData2.bW - localObjectBaseData2.bY - localObjectBaseData2.tD - ObjectBaseData.a.cEw);
          localObjectBaseData2.an = (localObjectBaseData2.centerY + localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp);
          localObjectBaseData2.tj = (localObjectBaseData2.tp + localObjectBaseData2.tl);
          localObjectBaseData2.tk = (localObjectBaseData2.centerX + localObjectBaseData2.cm * localObjectBaseData2.cn + localObjectBaseData2.cp);
          localObjectBaseData2.am = localObjectBaseData2.to;
          f4 = localObjectBaseData2.centerX;
          f5 = localObjectBaseData2.cw;
          f6 = localObjectBaseData2.cV;
          f7 = localObjectBaseData2.uB;
          f8 = localObjectBaseData2.ut;
          f9 = localObjectBaseData2.uu;
          if ((TextUtils.isEmpty(localObjectBaseData2.bsz)) || (TextUtils.isEmpty(localObjectBaseData2.bsA))) {
            break label4485;
          }
          localObjectBaseData2.bsA = localObjectBaseData2.bsA.toUpperCase();
          localObjectBaseData2.bB.setTextSize(localObjectBaseData2.tz * localObjectBaseData2.tR);
          localObjectBaseData2.bB.setTextAlign(Paint.Align.LEFT);
          if (localObjectBaseData2.tG == 0.0F) {
            break label5704;
          }
          localObjectBaseData2.bB.setShadowLayer(localObjectBaseData2.tI, 0.0F, localObjectBaseData2.tJ, localObjectBaseData2.cEk);
        }
        for (;;)
        {
          localObject1 = localObjectBaseData2.bB.getFontMetrics();
          f2 = localObjectBaseData2.tp + ((Paint.FontMetrics)localObject1).top;
          f1 = localObjectBaseData2.tp;
          f3 = ((Paint.FontMetrics)localObject1).bottom + f1;
          if (localObjectBaseData2.tt != 0.0F) {
            break label5731;
          }
          f10 = localObjectBaseData2.am;
          f1 = localObjectBaseData2.ts;
          localObjectBaseData2.h.setTextSize(localObjectBaseData2.tR * f1);
          while (localObjectBaseData2.h.measureText(localObjectBaseData2.bsz) > f4 + f5 + f6 + f7 - f8 - 4.0F * f9 - f10)
          {
            f1 -= 1.0F;
            localObjectBaseData2.h.setTextSize(localObjectBaseData2.tR * f1);
          }
          localObjectBaseData2.tl = ((localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY) * 2.0F / 3.6F);
          break;
          localObjectBaseData2.an = (localObjectBaseData2.tp - localObjectBaseData2.tl);
          localObjectBaseData2.tj = (localObjectBaseData2.centerY + localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY);
          localObjectBaseData2.tk = (localObjectBaseData2.centerX + localObjectBaseData2.bV * localObjectBaseData2.bW + localObjectBaseData2.bY);
          localObjectBaseData2.am = localObjectBaseData2.to;
          break label5309;
          localObjectBaseData2.bB.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        localObjectBaseData2.tt = (f1 / localObjectBaseData2.scale);
        localObjectBaseData2.ts = (localObjectBaseData2.tt * localObjectBaseData2.scale);
        localObjectBaseData2.ts = localObjectBaseData2.tv;
        localObjectBaseData2.tz = localObjectBaseData2.tB;
        localObjectBaseData2.bA.setTextSize(localObjectBaseData2.ts * localObjectBaseData2.tR);
        localObjectBaseData2.bA.setTextAlign(Paint.Align.LEFT);
        long l1;
        long l2;
        if (localObjectBaseData2.bMt)
        {
          localObjectBaseData2.bA.setFakeBoldText(true);
          if (localObjectBaseData2.tG == 0.0F) {
            break label6401;
          }
          localObjectBaseData2.bA.setShadowLayer(localObjectBaseData2.tI, 0.0F, localObjectBaseData2.tJ, localObjectBaseData2.cEk);
          i = localObjectBaseData2.bsz.length();
          m = (int)(f3 - f2);
          if (i < 9) {
            break label6416;
          }
          str = localObjectBaseData2.bsz.substring(0, 7);
          localObject2 = localObjectBaseData2.bsz.substring(7, i);
          localObject1 = localObject2;
          if (((String)localObject2).length() > 7) {
            localObject1 = ((String)localObject2).substring(0, 6) + "...";
          }
          localObject2 = new Rect();
          localObjectBaseData2.bA.getTextBounds(str, 0, str.length(), (Rect)localObject2);
          l1 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
          paramCanvas.drawText(str, localObjectBaseData2.to, localObjectBaseData2.tp + (float)l1, localObjectBaseData2.bA);
          localObjectBaseData2.bA.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
          l2 = ((Rect)localObject2).bottom - ((Rect)localObject2).top;
          paramCanvas.drawText((String)localObject1, localObjectBaseData2.to, localObjectBaseData2.tp + (float)l2 + (float)l1 + 20.0F, localObjectBaseData2.bA);
        }
        for (f1 = (float)(l1 + l2 + 20L);; f1 = f3 - f2 + localObjectBaseData2.tF)
        {
          localObject1 = new Rect();
          localObjectBaseData2.bB.getTextBounds(localObjectBaseData2.bsA, 0, localObjectBaseData2.bsA.length(), (Rect)localObject1);
          paramCanvas.drawText(localObjectBaseData2.bsA, localObjectBaseData2.to, f1 + localObjectBaseData2.tp + (((Rect)localObject1).bottom - ((Rect)localObject1).top) + 20.0F, localObjectBaseData2.bB);
          localObjectBaseData2.bC.setAlpha((int)(localObjectBaseData2.tN * 255.0F));
          f1 = localObjectBaseData2.tp - localObjectBaseData2.tE * localObjectBaseData2.tR;
          f2 = localObjectBaseData2.to + localObjectBaseData2.tQ;
          f3 = f1 - localObjectBaseData2.tO * localObjectBaseData2.tR;
          f4 = f2 + (float)(localObjectBaseData2.tP * localObjectBaseData2.tR * Math.cos(localObjectBaseData2.tL * 3.141592653589793D / 180.0D));
          f5 = f3 - (float)(localObjectBaseData2.tP * localObjectBaseData2.tR * Math.sin(localObjectBaseData2.tL * 3.141592653589793D / 180.0D));
          if (localObjectBaseData2.tN >= 0.2D) {
            paramCanvas.drawLine(f4, f5, f2, f3, localObjectBaseData2.bC);
          }
          if (localObjectBaseData2.tN >= 0.5D) {
            paramCanvas.drawLine(f2, f3, f2, f1, localObjectBaseData2.bC);
          }
          localObjectBaseData2.bD.setAlpha((int)(localObjectBaseData2.tN * 255.0F));
          paramCanvas.drawCircle(f4, f5, localObjectBaseData2.tS, localObjectBaseData2.bD);
          break;
          localObjectBaseData2.bA.setFakeBoldText(false);
          break label5814;
          localObjectBaseData2.bA.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label5848;
          localObject1 = localObjectBaseData2.bsz;
          f1 = localObjectBaseData2.to;
          f4 = localObjectBaseData2.tp;
          paramCanvas.drawText((String)localObject1, f1, m + f4, localObjectBaseData2.bA);
        }
        i = 0;
        break label4564;
        if (!TextUtils.isEmpty(localObjectBaseData2.bsB))
        {
          i = 1;
          break label4564;
        }
        i = 0;
        break label4564;
        bool = false;
        break label4655;
        m = i;
        if (j != 2)
        {
          this.b.a.v(2, localObjectBaseData2.bsB, false);
          m = i;
        }
      }
    }
    label337:
    label372:
    this.b.a.Hb();
    label402:
    label488:
    label3690:
    label3954:
    label5619:
    this.b.a.dCP();
    label518:
    label3084:
    label3353:
    label3632:
    label3778:
    label3786:
    label3799:
    label4066:
    label4711:
    return;
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= paramFloat1) {
      return paramFloat2 - paramFloat1;
    }
    return 360.0F + paramFloat2 - paramFloat1;
  }
  
  private long a(ObjectBaseData paramObjectBaseData)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramObjectBaseData.isStar)
    {
      l1 = l2;
      if (paramObjectBaseData.tG > 0.0F)
      {
        l1 = l2;
        if (!paramObjectBaseData.bMD)
        {
          l1 = l2;
          if (!TextUtils.isEmpty(paramObjectBaseData.bsz))
          {
            l1 = l2;
            if (!TextUtils.isEmpty(paramObjectBaseData.bsA))
            {
              l2 = 0L + dip2px(getContext(), 10.0F) + 32L;
              if (paramObjectBaseData.bsz.length() >= 8) {
                break label101;
              }
              l1 = l2 + 60L;
            }
          }
        }
      }
    }
    label101:
    do
    {
      return l1;
      if (paramObjectBaseData.bsz.length() == 8) {
        return l2 + 52L;
      }
      l1 = l2;
    } while (paramObjectBaseData.bsz.length() <= 8);
    return l2 + 160L;
  }
  
  private ObjectBaseData a()
  {
    int i = 0;
    ObjectBaseData localObjectBaseData1;
    if (i < this.T.size())
    {
      localObjectBaseData1 = (ObjectBaseData)this.T.get(i);
      if ((localObjectBaseData1 == null) || (!localObjectBaseData1.bMt) || (!localObjectBaseData1.isStar) || (localObjectBaseData1.bMD)) {}
    }
    for (;;)
    {
      if ((localObjectBaseData1 == null) && (this.eG.size() > 0))
      {
        Iterator localIterator = this.eG.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ObjectBaseData localObjectBaseData2 = (ObjectBaseData)((Map.Entry)localIterator.next()).getValue();
            if ((localObjectBaseData2 != null) && (localObjectBaseData2.bMt) && (localObjectBaseData2.isStar) && (!localObjectBaseData2.bMD))
            {
              return localObjectBaseData2;
              i += 1;
              break;
            }
          }
        }
      }
      return localObjectBaseData1;
      localObjectBaseData1 = null;
    }
  }
  
  private void a(ObjectBaseData paramObjectBaseData)
  {
    if ((paramObjectBaseData == null) || (paramObjectBaseData.bMD) || (this.eG.contains(paramObjectBaseData.bsy))) {
      return;
    }
    this.eG.put(paramObjectBaseData.bsy, paramObjectBaseData);
  }
  
  private void b(ObjectBaseData paramObjectBaseData)
  {
    int i;
    if (paramObjectBaseData != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.T.size())
        {
          ObjectBaseData localObjectBaseData = (ObjectBaseData)this.T.get(i);
          if (localObjectBaseData != null)
          {
            if ((!localObjectBaseData.bsy.equals(paramObjectBaseData.bsy)) || (localObjectBaseData.bMD != paramObjectBaseData.bMD)) {
              break label93;
            }
            return;
          }
          this.T.remove(i);
          break label93;
        }
        this.T.add(paramObjectBaseData);
        return;
      }
      catch (Exception paramObjectBaseData)
      {
        QLog.e("ObjectSurfaceView", 1, "addObjectData", paramObjectBaseData);
      }
      return;
      label93:
      i += 1;
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.mHandlerThread = new HandlerThread("ObjectSurfaceViewAnimationThread");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.k = new HandlerThread("ObjectSurfaceViewDrawThread");
    this.k.start();
    this.mDrawHandler = new Handler(this.k.getLooper());
  }
  
  private void jx(List<ObjectBaseData> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ObjectBaseData)paramList.next());
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
              localObject1 = acfp.m(2131709217);
              if (!TextUtils.isEmpty(((DrawView2.a)localObject2).name)) {
                localObject1 = ((DrawView2.a)localObject2).name;
              }
              QLog.d("ObjectSurfaceView", 2, "name = " + (String)localObject1 + ",confidence = " + ((DrawView2.a)localObject2).confidence + ",faceId = " + ((DrawView2.a)localObject2).faceID + ",isTmpFace = " + ((DrawView2.a)localObject2).bMw);
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
            break label1490;
          }
          localObject2 = (ObjectBaseData)this.T.get(i);
          if ((localObject2 != null) && (((ObjectBaseData)localObject2).bsy.equals(locala.name)) && (((ObjectBaseData)localObject2).bMD == locala.bMw)) {
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
            localObject2 = (ObjectBaseData)this.eG.get(Integer.valueOf(locala.faceID));
            localObject1 = localObject2;
            m = i;
            if (localObject2 != null)
            {
              b((ObjectBaseData)localObject2);
              this.eG.remove(Integer.valueOf(locala.faceID));
              m = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      if (m == 0)
      {
        localObject1 = new adfm(getContext());
        ((ObjectBaseData)localObject1).bMD = locala.bMw;
        ((ObjectBaseData)localObject1).bsy = locala.name;
        if (!locala.bMw)
        {
          ((ObjectBaseData)localObject1).bMt = locala.bMt;
          if (QLog.isColorLevel()) {
            QLog.d("ObjectSurfaceView", 2, "1=" + ((ObjectBaseData)localObject1).bMt);
          }
          ((ObjectBaseData)localObject1).uin = locala.uin;
          ((ObjectBaseData)localObject1).bsz = locala.name;
          ((ObjectBaseData)localObject1).url = locala.url;
          ((ObjectBaseData)localObject1).isStar = locala.isStar;
          ((ObjectBaseData)localObject1).bMu = locala.bMu;
          ((ObjectBaseData)localObject1).at = localRectF;
          ((ObjectBaseData)localObject1).imgUrl = locala.imgUrl;
          ((ObjectBaseData)localObject1).bsx = locala.bsx;
          ((ObjectBaseData)localObject1).bsB = locala.bsv;
          ((ObjectBaseData)localObject1).bsC = locala.bsw;
          if ((!((ObjectBaseData)localObject1).bMC) && (QLog.isColorLevel()))
          {
            ((ObjectBaseData)localObject1).bMC = true;
            QLog.d("ObjectSurfaceView", 2, "isMainFace = " + ((ObjectBaseData)localObject1).bMt + ", fNCH = " + ((ObjectBaseData)localObject1).bsz + ", faceID = " + ((ObjectBaseData)localObject1).bsy + ", isStar = " + ((ObjectBaseData)localObject1).isStar + ", isActivate = " + ((ObjectBaseData)localObject1).bMu + ", fCTitleText = " + ((ObjectBaseData)localObject1).bsB + ", fCContentText = " + ((ObjectBaseData)localObject1).bsC + ", url = " + ((ObjectBaseData)localObject1).url + ", imgUrl = " + ((ObjectBaseData)localObject1).imgUrl + ", wikiUrl = " + ((ObjectBaseData)localObject1).bsx);
          }
        }
        b((ObjectBaseData)localObject1);
      }
      for (;;)
      {
        ((ObjectBaseData)localObject1).at = localRectF;
        ((ObjectBaseData)localObject1).bsA = locala.enName;
        if (((ObjectBaseData)localObject1).bMt)
        {
          i = 0;
          for (;;)
          {
            if (i < this.T.size())
            {
              localObject2 = (ObjectBaseData)this.T.get(i);
              if ((localObject2 != null) && (!((ObjectBaseData)localObject2).bsy.equals(((ObjectBaseData)localObject1).bsy)) && (!((ObjectBaseData)localObject2).isStar) && (((ObjectBaseData)localObject2).bMt)) {
                ((ObjectBaseData)localObject2).bMt = false;
              }
              i += 1;
              continue;
              i += 1;
              break;
            }
          }
        }
        if (localRectF != null)
        {
          f1 = localRectF.centerX();
          float f2 = localRectF.centerY();
          if ((Math.abs(f1 - ((ObjectBaseData)localObject1).centerX) > ObjectBaseData.a.FR) || (Math.abs(f2 - ((ObjectBaseData)localObject1).centerY) > ObjectBaseData.a.FR))
          {
            ((ObjectBaseData)localObject1).centerX = f1;
            ((ObjectBaseData)localObject1).centerY = f2;
          }
          QLog.d("ObjectSurfaceView", 1, "centerX = " + f1 + ", centerY = " + f2);
          f1 = (float)Math.sqrt(localRectF.width() * localRectF.width() + localRectF.height() * localRectF.height());
          f1 = Math.min(((ObjectBaseData)localObject1).cv, f1 / 2.0F);
          this.scale = 1.0F;
          QLog.d("ObjectSurfaceView", 1, "scale = " + this.scale + ",scanningData.scale = " + ((ObjectBaseData)localObject1).scale + ", trueRadius = " + f1 + ", iBCRadiusFix = " + ((ObjectBaseData)localObject1).cB);
        }
        if (this.isRunning) {
          if (Math.abs(((ObjectBaseData)localObject1).scale - this.scale) >= 0.03D)
          {
            ((ObjectBaseData)localObject1).reset();
            ((ObjectBaseData)localObject1).k(this.scale);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          ((ObjectBaseData)localObject1).reset();
          ((ObjectBaseData)localObject1).k(this.scale);
        }
        i = 0;
        if (i < this.T.size())
        {
          localObject1 = (ObjectBaseData)this.T.get(i);
          j = 0;
          label1273:
          if (j >= this.da.size()) {
            break label1481;
          }
          localObject2 = (DrawView2.a)this.da.get(j);
          if ((localObject2 == null) || (localObject1 == null) || (!((ObjectBaseData)localObject1).bsy.equals(((DrawView2.a)localObject2).name)) || (((ObjectBaseData)localObject1).bMD != ((DrawView2.a)localObject2).bMw)) {}
        }
        label1481:
        for (j = 1;; j = 0)
        {
          if (j == 0)
          {
            a((ObjectBaseData)localObject1);
            this.T.remove(i);
            QLog.d("ckwkenvencai", 1, "remove2");
          }
          i += 1;
          break;
          j += 1;
          break label1273;
          this.qm = false;
          if ((!this.isRunning) && (this.T.size() > 0))
          {
            this.isRunning = true;
            this.mDrawHandler.post(this.X);
          }
          if (this.T.size() == 0) {
            this.isRunning = false;
          }
          return;
          clear();
          QLog.e("ObjectSurfaceView", 1, "lost the face data.");
          this.b.a.Hb();
          this.b.a.dCP();
          return;
        }
      }
      label1490:
      i = 0;
      localObject2 = null;
    }
  }
  
  public void clear()
  {
    this.qm = true;
    this.isRunning = false;
    jx(this.T);
    this.T.clear();
    this.b.a.Hb();
    this.b.a.dCP();
    QLog.d("ObjectSurfaceView", 1, "clear the animation and face data.");
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
      QLog.e("ObjectSurfaceView", 1, "setFaceData catch an exception.", paramList);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceChanged");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceCreated");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    clear();
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView
 * JD-Core Version:    0.7.0.1
 */