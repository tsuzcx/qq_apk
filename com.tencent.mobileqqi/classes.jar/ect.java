import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ect
  extends Drawable
  implements Runnable
{
  static final int jdField_a_of_type_Int = -1;
  private static final String jdField_a_of_type_JavaLangString = "VipBubbleAnimation";
  static final int jdField_b_of_type_Int = 50;
  private static final int jdField_c_of_type_Int = 0;
  private static final int jdField_d_of_type_Int = 1;
  private static final int e = 2;
  Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  ecu jdField_a_of_type_Ecu;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = true;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private int f = -1;
  private int g = -1;
  private int h = 0;
  private int i = 50;
  private int j;
  private int k;
  private int l = 0;
  
  public ect(Resources paramResources)
  {
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  private void b()
  {
    if ((this.f == 1) && (this.g >= 0)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.i);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.i;
    this.jdField_a_of_type_Ecu = new ecu(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Ecu.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.g), Long.valueOf(this.f) });
  }
  
  @TargetApi(11)
  Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
      paramObject = (ecv)paramObject;
      localOptions.inDensity = 320;
      localOptions.inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
      return BitmapFactory.decodeFile(paramObject.jdField_a_of_type_JavaLangString, localOptions);
    case 2: 
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramInt1, localOptions);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/")) {
      paramObject = paramObject.substring("file:///android_assets/".length());
    }
    for (paramObject = this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramObject);; paramObject = new FileInputStream(paramObject)) {
      return BitmapFactory.decodeStream(paramObject, null, localOptions);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_Ecu != null)
    {
      this.jdField_a_of_type_Ecu.cancel(false);
      this.jdField_a_of_type_Ecu = null;
    }
    this.f = -1;
    this.jdField_a_of_type_Boolean = true;
    this.g = -1;
    this.i = 50;
    this.l = -1;
    this.d = true;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.f == 1) && (((ecv)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    a();
    this.f = 1;
    this.jdField_a_of_type_JavaLangObject = new ecv(this, paramString, paramInt1, paramInt2);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    paramInt1 = localOptions.outWidth / paramInt1;
    paramInt2 = localOptions.outHeight / paramInt2;
    this.j = Utils.a(paramInt1, 320, localOptions.inTargetDensity);
    this.k = Utils.a(paramInt2, 320, localOptions.inTargetDensity);
    this.i = paramInt3;
    this.d = false;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if ((this.f == 2) && (Arrays.equals((int[])this.jdField_a_of_type_JavaLangObject, paramArrayOfInt))) {
      return;
    }
    a();
    this.f = 2;
    this.jdField_a_of_type_JavaLangObject = paramArrayOfInt;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramArrayOfInt[0], localOptions);
    this.j = Utils.a(localOptions.outWidth, localOptions.inDensity, localOptions.inTargetDensity);
    this.k = Utils.a(localOptions.outHeight, localOptions.inDensity, localOptions.inTargetDensity);
    this.h = paramArrayOfInt.length;
    this.d = false;
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if ((this.f == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      try
      {
        a();
        this.f = 0;
        this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        String str = paramArrayOfString[0];
        if (str.startsWith("file:///android_assets/bubbles/"))
        {
          str = str.substring("file:///android_assets/".length());
          BitmapFactory.decodeStream(this.jdField_a_of_type_AndroidContentResResources.getAssets().open(str), null, localOptions);
          this.j = Utils.a(localOptions.outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
          this.k = Utils.a(localOptions.outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
          this.h = paramArrayOfString.length;
          this.d = false;
          return;
        }
      }
      catch (IOException paramArrayOfString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("VipBubbleAnimation", 4, "", paramArrayOfString);
        }
        a();
        return;
      }
      BitmapFactory.decodeFile(paramArrayOfString[0], localOptions);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      invalidateSelf();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == -1) {
      return;
    }
    int m;
    if (this.g != -1)
    {
      Object localObject = getBounds();
      m = 0;
      if (this.c)
      {
        m = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, ((Rect)localObject).centerX(), ((Rect)localObject).centerY());
      }
      if (this.f != 1) {
        break label240;
      }
      localObject = (ecv)this.jdField_a_of_type_JavaLangObject;
      int i3 = this.g;
      int i4 = ((ecv)localObject).jdField_a_of_type_Int;
      int i2 = this.g / ((ecv)localObject).jdField_a_of_type_Int;
      int n = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / ((ecv)localObject).jdField_a_of_type_Int;
      int i1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / ((ecv)localObject).b;
      i3 = i3 % i4 * this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / ((ecv)localObject).jdField_a_of_type_Int;
      i2 = i2 * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / ((ecv)localObject).b;
      this.jdField_a_of_type_AndroidGraphicsRect.set(i3, i2, n + i3, i1 + i2);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      if (this.c) {
        paramCanvas.restoreToCount(m);
      }
      if (this.l != 0) {
        break;
      }
      a();
      invalidateSelf();
      this.d = true;
      return;
      label240:
      if ((this.f == 0) || (this.f == 2)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    b();
  }
  
  public int getIntrinsicHeight()
  {
    return this.k;
  }
  
  public int getIntrinsicWidth()
  {
    return this.j;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (this.g == this.h - 1)
      {
        this.g = 0;
        this.l -= 1;
      }
      while ((this.f != -1) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_b_of_type_AndroidGraphicsBitmap))
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
        invalidateSelf();
        return;
        this.g += 1;
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ect
 * JD-Core Version:    0.7.0.1
 */