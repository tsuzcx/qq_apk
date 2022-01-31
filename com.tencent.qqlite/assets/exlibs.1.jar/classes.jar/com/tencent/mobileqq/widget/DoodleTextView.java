package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DoodleTextView
  extends View
{
  public static final int a = 800;
  public static final int b = 600;
  private static final int jdField_c_of_type_Int = 20;
  private static int jdField_d_of_type_Int = 5;
  private static int jdField_e_of_type_Int = 8;
  private static final float jdField_f_of_type_Float = 4.0F;
  private float jdField_a_of_type_Float = 0.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Integer jdField_a_of_type_JavaLangInteger;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_e_of_type_Float;
  private Paint jdField_e_of_type_AndroidGraphicsPaint;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float = 0.0F;
  private int jdField_g_of_type_Int = 0;
  private float h = 0.0F;
  private float i;
  private float j;
  
  public DoodleTextView(Context paramContext)
  {
    super(paramContext);
    this.f = 0;
    a();
  }
  
  public DoodleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = 0;
    a();
  }
  
  public DoodleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = 0;
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat1, paramFloat2);
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_d_of_type_Float = (paramFloat1 / jdField_e_of_type_Int);
    this.jdField_e_of_type_Float = (paramFloat2 / jdField_e_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPath.moveTo(this.jdField_d_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_e_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.i = this.jdField_d_of_type_Float;
    this.j = this.jdField_d_of_type_Float;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat2 < 0.0F) || (paramFloat2 > this.jdField_g_of_type_Int)) {}
    float f1;
    float f2;
    do
    {
      return;
      f1 = Math.abs(paramFloat1 - this.jdField_b_of_type_Float);
      f2 = Math.abs(paramFloat2 - this.jdField_c_of_type_Float);
    } while ((f1 < 4.0F) && (f2 < 4.0F));
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, (this.jdField_b_of_type_Float + paramFloat1) / 2.0F, (this.jdField_c_of_type_Float + paramFloat2) / 2.0F);
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    paramFloat1 /= jdField_e_of_type_Int;
    paramFloat2 /= jdField_e_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsPath.quadTo(this.jdField_d_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_e_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.top, (this.jdField_d_of_type_Float + paramFloat1) / 2.0F + this.jdField_a_of_type_AndroidGraphicsRectF.right, (this.jdField_e_of_type_Float + paramFloat2) / 2.0F + this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_d_of_type_Float = paramFloat1;
    this.jdField_e_of_type_Float = paramFloat2;
    this.i = Math.min(this.i, this.jdField_d_of_type_Float);
    this.j = Math.max(this.j, this.jdField_d_of_type_Float);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void g()
  {
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsCanvas != null) && (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)) {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_d_of_type_AndroidGraphicsPaint.getColor());
      }
    }
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 800L);
      do
      {
        return;
      } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null));
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.jdField_d_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_e_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.top);
      this.jdField_g_of_type_Float = Math.min(this.i, this.jdField_g_of_type_Float);
      this.h = Math.max(this.j, this.h);
      this.jdField_d_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidGraphicsPath);
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_d_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_d_of_type_AndroidGraphicsPaint.getColor());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 800L);
  }
  
  public Bitmap a()
  {
    int k;
    int m;
    if (this.jdField_a_of_type_AndroidGraphicsRectF.bottom > this.jdField_a_of_type_Float + 1.0F)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      m = k;
      if (k > this.jdField_g_of_type_Int) {
        m = this.jdField_g_of_type_Int;
      }
      k = this.f;
    }
    for (;;)
    {
      if ((k <= 0) || (m <= 0)) {
        break label167;
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(-461330);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int n;
        int i1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("DoodleTextView", 2, "getSendBitmap ", localOutOfMemoryError);
        return null;
      }
      n = (int)this.jdField_a_of_type_Float;
      i1 = (int)this.jdField_a_of_type_AndroidGraphicsRectF.right;
      m = n;
      k = i1;
      if (i1 > this.f)
      {
        k = this.f;
        m = n;
      }
    }
    label167:
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(4);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(11.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-2237490);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-11842741);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() < 1;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (boolean bool = false;; bool = true)
    {
      this.jdField_b_of_type_Boolean = bool;
      invalidate((int)this.jdField_a_of_type_AndroidGraphicsRectF.right - jdField_d_of_type_Int, (int)this.jdField_a_of_type_AndroidGraphicsRectF.top, (int)this.jdField_a_of_type_AndroidGraphicsRectF.right + jdField_d_of_type_Int, (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
      return;
    }
  }
  
  public void c()
  {
    int m = 0;
    int n = this.jdField_d_of_type_AndroidGraphicsPaint.getColor();
    int i1 = this.jdField_d_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      int k;
      if (this.jdField_a_of_type_AndroidGraphicsRectF.right + this.h > this.f)
      {
        k = 0;
        while (k < i1)
        {
          ((Path)this.jdField_d_of_type_JavaUtilArrayList.get(k)).offset(0.0F - this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_Float);
          k += 1;
        }
        this.jdField_a_of_type_AndroidGraphicsRectF.top = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.h + jdField_d_of_type_Int);
        if (this.jdField_a_of_type_AndroidGraphicsRectF.bottom <= this.jdField_g_of_type_Int) {
          break label311;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        label169:
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        k = m;
      }
      for (;;)
      {
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label364;
        }
        this.jdField_d_of_type_AndroidGraphicsPaint.setColor(((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(k)).intValue());
        Object localObject = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(k)).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Path localPath = (Path)((Iterator)localObject).next();
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(localPath, this.jdField_d_of_type_AndroidGraphicsPaint);
            continue;
            this.jdField_a_of_type_AndroidGraphicsRectF.left = this.jdField_a_of_type_AndroidGraphicsRectF.right;
            localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
            ((RectF)localObject).right += this.h + jdField_d_of_type_Int;
            break;
            label311:
            this.jdField_b_of_type_JavaUtilArrayList.add(new RectF(this.jdField_a_of_type_AndroidGraphicsRectF));
            this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_JavaUtilArrayList);
            this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangInteger);
            break label169;
          }
        }
        k += 1;
      }
    }
    label364:
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Float = 0.0F;
    this.h = 0.0F;
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(n);
    invalidate();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    c();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = 0.0F;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    invalidate();
  }
  
  public void f()
  {
    d();
    int k = this.jdField_c_of_type_JavaUtilArrayList.size();
    int m = this.jdField_b_of_type_JavaUtilArrayList.size();
    int n = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (n > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      this.jdField_b_of_type_JavaUtilArrayList.remove(m - 1);
      this.jdField_a_of_type_JavaUtilArrayList.remove(n - 1);
      this.jdField_c_of_type_JavaUtilArrayList.remove(k - 1);
      k = this.jdField_b_of_type_JavaUtilArrayList.size();
      Object localObject;
      int i1;
      if (k > 0)
      {
        localObject = (RectF)this.jdField_b_of_type_JavaUtilArrayList.get(k - 1);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = ((RectF)localObject).top;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((RectF)localObject).bottom;
        this.jdField_a_of_type_AndroidGraphicsRectF.left = ((RectF)localObject).left;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = ((RectF)localObject).right;
        n = this.jdField_d_of_type_AndroidGraphicsPaint.getColor();
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
        k = 0;
      }
      for (;;)
      {
        if (k >= i1) {
          break label297;
        }
        localObject = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        int i2 = ((ArrayList)localObject).size();
        this.jdField_d_of_type_AndroidGraphicsPaint.setColor(((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(k)).intValue());
        m = 0;
        for (;;)
        {
          if (m < i2)
          {
            this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath((Path)((ArrayList)localObject).get(m), this.jdField_d_of_type_AndroidGraphicsPaint);
            m += 1;
            continue;
            this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
            this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_Float;
            this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
            this.jdField_a_of_type_AndroidGraphicsRectF.right = 0.0F;
            break;
          }
        }
        k += 1;
      }
      label297:
      this.jdField_d_of_type_AndroidGraphicsPaint.setColor(n);
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_Float = (this.jdField_g_of_type_Int / jdField_e_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = 0.0F;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 600L);
      }
    }
    float f1 = this.jdField_a_of_type_Float;
    int k = 1;
    while (k < jdField_e_of_type_Int)
    {
      paramCanvas.drawLine(0.0F, f1, this.f, f1, this.jdField_c_of_type_AndroidGraphicsPaint);
      f1 += this.jdField_a_of_type_Float;
      k += 1;
    }
    paramCanvas.drawLine(0.0F, f1 - 1.0F, this.f, f1 - 1.0F, this.jdField_c_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRectF.right < 20.0F) {
        this.jdField_a_of_type_AndroidGraphicsRectF.right = 20.0F;
      }
      int m = (int)(this.jdField_a_of_type_AndroidGraphicsRectF.right + 1.5D);
      k = m;
      if (m + 2 > this.f) {
        k = this.f - 2;
      }
      paramCanvas.drawLine(k, (int)(this.jdField_a_of_type_AndroidGraphicsRectF.top + 5.5D), k, (int)(this.jdField_a_of_type_AndroidGraphicsRectF.bottom - 5.0F), this.jdField_e_of_type_AndroidGraphicsPaint);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = getWidth();
    this.jdField_g_of_type_Int = getHeight();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.f, this.jdField_g_of_type_Int, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleTextView", 2, "onLayout ", localOutOfMemoryError);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      a(f1, f2);
      invalidate();
      continue;
      b(f1, f2);
      invalidate();
      continue;
      g();
      invalidate();
    }
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setPaintColor(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
    if (this.jdField_d_of_type_AndroidGraphicsPaint != null) {
      this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DoodleTextView
 * JD-Core Version:    0.7.0.1
 */