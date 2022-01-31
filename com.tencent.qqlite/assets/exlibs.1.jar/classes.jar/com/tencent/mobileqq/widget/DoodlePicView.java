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
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import exz;
import java.util.ArrayList;

public class DoodlePicView
  extends View
{
  private static final float jdField_c_of_type_Float = 4.0F;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  
  public DoodlePicView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public DoodlePicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public DoodlePicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int k = 1;
    int m = 1;
    int i = m;
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0) {
        break label25;
      }
      i = m;
    }
    label25:
    int j;
    int n;
    do
    {
      do
      {
        return i;
        j = getWidth();
        n = getHeight();
        i = m;
      } while (j <= 0);
      i = m;
    } while (n <= 0);
    float f = j / n;
    if (paramInt1 / paramInt2 > f)
    {
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 <= j) {
        break;
      }
      paramInt2 /= 2;
      paramInt1 *= 2;
      continue;
      j = n;
      paramInt1 = k;
    }
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0) || (paramInt4 <= 0)) {
      return localRect;
    }
    float f = paramInt3 / paramInt4;
    if (paramInt1 / paramInt2 > f)
    {
      paramInt1 = paramInt3 * paramInt2 / paramInt1;
      localRect.left = 0;
      localRect.top = ((paramInt4 - paramInt1) / 2);
      localRect.right = paramInt3;
      localRect.bottom = (paramInt4 - localRect.top);
      return localRect;
    }
    localRect.left = ((paramInt3 - paramInt4 * paramInt1 / paramInt2) / 2);
    localRect.top = 0;
    localRect.right = (paramInt3 - localRect.left);
    localRect.bottom = paramInt4;
    return localRect;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_b_of_type_Boolean = false;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +161 -> 162
    //   4: new 102	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 108	java/io/File:exists	()Z
    //   19: ifeq +143 -> 162
    //   22: aconst_null
    //   23: astore 4
    //   25: new 110	java/io/FileInputStream
    //   28: dup
    //   29: aload 5
    //   31: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: invokestatic 118	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   45: astore 6
    //   47: aload 5
    //   49: astore 4
    //   51: aload 6
    //   53: getfield 123	android/graphics/BitmapFactory$Options:outWidth	I
    //   56: istore_2
    //   57: aload 5
    //   59: astore 4
    //   61: aload 6
    //   63: getfield 126	android/graphics/BitmapFactory$Options:outHeight	I
    //   66: istore_3
    //   67: aload 5
    //   69: astore 4
    //   71: new 120	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 127	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 6
    //   80: aload 5
    //   82: astore 4
    //   84: aload 6
    //   86: iconst_1
    //   87: putfield 130	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   90: aload 5
    //   92: astore 4
    //   94: aload 6
    //   96: aload_0
    //   97: iload_2
    //   98: iload_3
    //   99: invokespecial 132	com/tencent/mobileqq/widget/DoodlePicView:a	(II)I
    //   102: putfield 130	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 5
    //   107: astore 4
    //   109: aload_1
    //   110: aload 6
    //   112: invokestatic 137	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   115: astore 6
    //   117: aload 5
    //   119: astore 4
    //   121: new 139	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 140	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   129: aload 6
    //   131: invokevirtual 143	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +21 -> 157
    //   139: aload 5
    //   141: astore 4
    //   143: aload_0
    //   144: iconst_1
    //   145: putfield 42	com/tencent/mobileqq/widget/DoodlePicView:jdField_c_of_type_Boolean	Z
    //   148: aload 5
    //   150: astore 4
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 147	com/tencent/mobileqq/widget/DoodlePicView:setPhoto	(Landroid/graphics/Bitmap;)V
    //   157: aload 5
    //   159: invokevirtual 150	java/io/FileInputStream:close	()V
    //   162: return
    //   163: astore_1
    //   164: aconst_null
    //   165: astore 5
    //   167: aload 5
    //   169: astore 4
    //   171: aload_0
    //   172: iconst_0
    //   173: putfield 42	com/tencent/mobileqq/widget/DoodlePicView:jdField_c_of_type_Boolean	Z
    //   176: aload 5
    //   178: invokevirtual 150	java/io/FileInputStream:close	()V
    //   181: return
    //   182: astore_1
    //   183: return
    //   184: astore_1
    //   185: aconst_null
    //   186: astore 5
    //   188: aload 5
    //   190: astore 4
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield 42	com/tencent/mobileqq/widget/DoodlePicView:jdField_c_of_type_Boolean	Z
    //   197: aload 5
    //   199: invokevirtual 150	java/io/FileInputStream:close	()V
    //   202: return
    //   203: astore_1
    //   204: return
    //   205: astore_1
    //   206: aload 4
    //   208: invokevirtual 150	java/io/FileInputStream:close	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_1
    //   214: return
    //   215: astore 4
    //   217: goto -6 -> 211
    //   220: astore_1
    //   221: goto -15 -> 206
    //   224: astore_1
    //   225: goto -37 -> 188
    //   228: astore_1
    //   229: goto -62 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	DoodlePicView
    //   0	232	1	paramString	String
    //   56	42	2	i	int
    //   66	33	3	j	int
    //   23	184	4	localObject1	java.lang.Object
    //   215	1	4	localException	java.lang.Exception
    //   12	186	5	localObject2	java.lang.Object
    //   45	85	6	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   25	36	163	java/lang/Exception
    //   176	181	182	java/lang/Exception
    //   25	36	184	java/lang/OutOfMemoryError
    //   197	202	203	java/lang/Exception
    //   25	36	205	finally
    //   157	162	213	java/lang/Exception
    //   206	211	215	java/lang/Exception
    //   40	47	220	finally
    //   51	57	220	finally
    //   61	67	220	finally
    //   71	80	220	finally
    //   84	90	220	finally
    //   94	105	220	finally
    //   109	117	220	finally
    //   121	135	220	finally
    //   143	148	220	finally
    //   152	157	220	finally
    //   171	176	220	finally
    //   192	197	220	finally
    //   40	47	224	java/lang/OutOfMemoryError
    //   51	57	224	java/lang/OutOfMemoryError
    //   61	67	224	java/lang/OutOfMemoryError
    //   71	80	224	java/lang/OutOfMemoryError
    //   84	90	224	java/lang/OutOfMemoryError
    //   94	105	224	java/lang/OutOfMemoryError
    //   109	117	224	java/lang/OutOfMemoryError
    //   121	135	224	java/lang/OutOfMemoryError
    //   143	148	224	java/lang/OutOfMemoryError
    //   152	157	224	java/lang/OutOfMemoryError
    //   40	47	228	java/lang/Exception
    //   51	57	228	java/lang/Exception
    //   61	67	228	java/lang/Exception
    //   71	80	228	java/lang/Exception
    //   84	90	228	java/lang/Exception
    //   94	105	228	java/lang/Exception
    //   109	117	228	java/lang/Exception
    //   121	135	228	java/lang/Exception
    //   143	148	228	java/lang/Exception
    //   152	157	228	java/lang/Exception
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat2 < 0.0F) || (paramFloat2 > this.jdField_b_of_type_Int)) {}
    float f1;
    float f2;
    do
    {
      return;
      f1 = Math.abs(paramFloat1 - this.jdField_a_of_type_Float);
      f2 = Math.abs(paramFloat2 - this.jdField_b_of_type_Float);
    } while ((f1 < 4.0F) && (f2 < 4.0F));
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, (this.jdField_a_of_type_Float + paramFloat1) / 2.0F, (this.jdField_b_of_type_Float + paramFloat2) / 2.0F);
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void d()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_JavaUtilArrayList.add(new Path(this.jdField_a_of_type_AndroidGraphicsPath));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(this.jdField_b_of_type_AndroidGraphicsPaint.getColor()));
    this.jdField_c_of_type_JavaUtilArrayList.add(Float.valueOf(this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth()));
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
  }
  
  private void e()
  {
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString != null)) {
      new Thread(new exz(this)).start();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
      draw(new Canvas(localBitmap));
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodlePicView", 2, "getSendBitmap() oom ");
      }
    }
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
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-2237490);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    e();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 1);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    invalidate();
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
      this.jdField_b_of_type_JavaUtilArrayList.remove(i - 1);
      this.jdField_c_of_type_JavaUtilArrayList.remove(i - 1);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int k = this.jdField_b_of_type_AndroidGraphicsPaint.getColor();
      float f = this.jdField_b_of_type_AndroidGraphicsPaint.getStrokeWidth();
      i = 0;
      while (i < j)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(i)).intValue());
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(((Float)this.jdField_c_of_type_JavaUtilArrayList.get(i)).floatValue());
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath((Path)this.jdField_a_of_type_JavaUtilArrayList.get(i), this.jdField_b_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(k);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(f);
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsCanvas == null))
    {
      this.jdField_a_of_type_Int = getWidth();
      this.jdField_b_of_type_Int = getHeight();
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
        }
        e();
        paramCanvas.drawLine(0.0F, this.jdField_b_of_type_Int - 1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - 1, this.jdField_c_of_type_AndroidGraphicsPaint);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          if ((this.jdField_a_of_type_Int > this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (this.jdField_b_of_type_Int > this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight())) {
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F, (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          }
        }
        else
        {
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
          return;
        }
      }
      catch (OutOfMemoryError paramCanvas)
      {
        System.gc();
        return;
      }
      Rect localRect1 = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      Rect localRect2 = a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect1, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      d();
      invalidate();
    }
  }
  
  public void setPaintColor(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
  
  public void setPaintThickness(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
    }
  }
  
  public void setPhoto(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setPhotoFile(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Boolean = false;
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DoodlePicView
 * JD-Core Version:    0.7.0.1
 */