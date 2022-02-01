import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import android.util.SparseArray;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.SoftReference;

public class vhx
  extends Paint
{
  private static int jdField_a_of_type_Int = -1;
  private static Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private static SoftReference<SparseArray<Bitmap>> jdField_a_of_type_JavaLangRefSoftReference;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
  public boolean a;
  
  public vhx()
  {
    this(0);
  }
  
  public vhx(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private Bitmap a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaLangRefSoftReference == null) {
          jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(new SparseArray(5));
        }
        SparseArray localSparseArray = (SparseArray)jdField_a_of_type_JavaLangRefSoftReference.get();
        if (localSparseArray == null)
        {
          localSparseArray = new SparseArray(5);
          jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localSparseArray);
          Bitmap localBitmap2 = (Bitmap)localSparseArray.get(paramInt);
          Bitmap localBitmap1 = localBitmap2;
          if (localBitmap2 == null) {}
          try
          {
            localBitmap1 = Bitmap.createBitmap(vvv.a(), paramInt, Bitmap.Config.ARGB_8888);
            localSparseArray.put(paramInt, localBitmap1);
            localBitmap1.eraseColor(0);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
            Object localObject1 = null;
            continue;
          }
          return localBitmap1;
        }
      }
      finally {}
    }
  }
  
  private void a(Paint paramPaint)
  {
    setTextSize(paramPaint.getTextSize());
    setColor(paramPaint.getColor());
    setFakeBoldText(paramPaint.isFakeBoldText());
  }
  
  private boolean b()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getPath());
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) {
      return false;
    }
    if (!vhy.a().a().native_isFontLoaded(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)) {
      return vhy.a().a().native_loadFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, true);
    }
    return true;
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getPath();
  }
  
  public void a(String paramString, int paramInt, float paramFloat1, float paramFloat2, Canvas paramCanvas, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (a())
    {
      ETEngine localETEngine = vhy.a().b();
      if ((localETEngine != null) && (c()))
      {
        if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
        {
          localETEngine.native_spaceDrawText(paramString, paramCanvas, paramBitmap, (int)paramFloat1, (int)paramFloat2, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
        }
        paramBitmap = Bitmap.createBitmap(localETEngine.native_spaceMeasureText(paramString, 0, paramString.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, null), paramInt, Bitmap.Config.ARGB_8888);
        paramBitmap.eraseColor(0);
        if (jdField_a_of_type_AndroidGraphicsCanvas == null) {
          jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
        }
        jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(paramBitmap);
        localETEngine.native_spaceDrawText(paramString, jdField_a_of_type_AndroidGraphicsCanvas, paramBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(paramBitmap, paramFloat1, paramFloat2, null);
        paramBitmap.recycle();
        return;
      }
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = a(paramInt);
      if ((paramBitmap == null) || (vhy.a().a() == null) || (!c()))
      {
        paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      if (jdField_a_of_type_AndroidGraphicsCanvas == null) {
        jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
      }
      jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(paramBitmap);
      vhy.a().a().native_spaceDrawText(paramString, jdField_a_of_type_AndroidGraphicsCanvas, paramBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramInt = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int j = paramInt * i;
      if ((jdField_a_of_type_ArrayOfInt == null) || (jdField_a_of_type_ArrayOfInt.length < j)) {}
      try
      {
        jdField_a_of_type_ArrayOfInt = new int[j];
        paramBitmap.getPixels(jdField_a_of_type_ArrayOfInt, 0, paramInt, 0, 0, paramInt, i);
        paramCanvas.drawBitmap(jdField_a_of_type_ArrayOfInt, 0, paramInt, paramFloat1, paramFloat2, paramInt, i, true, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
    }
    if ((vhy.a().a() == null) || (!c()))
    {
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - ascent(), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    vhy.a().a().native_spaceDrawText(paramString, paramCanvas, paramBitmap, (int)paramFloat1, (int)paramFloat2, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4;
  }
  
  public boolean a(int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setId(paramInt1);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setPath(paramString);
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType = paramInt2;
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
      }
      a(paramPaint);
      if (!b()) {
        break;
      }
      if (jdField_a_of_type_Int <= 0)
      {
        paramInt1 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296404);
        jdField_a_of_type_Int = Math.max(paramInt1 * paramInt1 * 240 * 8, 1048576);
      }
    } while ((!vhy.a().a(8, jdField_a_of_type_Int)) || ((paramInt2 == 4) && (!vhy.a().a())) || (vhy.a().a() == null) || (!c()));
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = vhy.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    return true;
  }
  
  public float ascent()
  {
    if ((b()) && (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics != null)) {
      return this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.ascent;
    }
    return super.ascent();
  }
  
  public float descent()
  {
    if ((b()) && (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics != null)) {
      return this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.descent;
    }
    return super.descent();
  }
  
  public Paint.FontMetrics getFontMetrics()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics == null) {
      return super.getFontMetrics();
    }
    return this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  }
  
  public int getTextWidths(String paramString, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    boolean bool = false;
    int j = 0;
    int i;
    if (!b()) {
      i = super.getTextWidths(paramString, paramInt1, paramInt2, paramArrayOfFloat);
    }
    do
    {
      do
      {
        return i;
        if (paramString == null) {
          throw new IllegalArgumentException("text cannot be null");
        }
        if ((paramInt1 | paramInt2 | paramInt2 - paramInt1 | paramString.length() - paramInt2) < 0) {
          throw new IndexOutOfBoundsException();
        }
        if (paramInt2 - paramInt1 > paramArrayOfFloat.length) {
          throw new ArrayIndexOutOfBoundsException();
        }
        i = j;
      } while (paramString.length() == 0);
      i = j;
    } while (paramInt1 == paramInt2);
    vhy localvhy = vhy.a();
    ETFont localETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 4) {
      bool = true;
    }
    return localvhy.a(paramString, paramInt1, paramInt2, localETFont, localPaint, paramArrayOfFloat, bool);
  }
  
  public float measureText(String paramString)
  {
    return measureText(paramString, 0, paramString.length());
  }
  
  public float measureText(String paramString, int paramInt1, int paramInt2)
  {
    if (!b()) {
      return super.measureText(paramString, paramInt1, paramInt2);
    }
    if (paramString == null) {
      throw new IllegalArgumentException("text cannot be null");
    }
    if ((paramInt1 | paramInt2 | paramInt2 - paramInt1 | paramString.length() - paramInt2) < 0) {
      throw new IndexOutOfBoundsException();
    }
    if ((paramString.length() == 0) || (paramInt1 == paramInt2)) {
      return 0.0F;
    }
    return vhy.a().a(paramString, paramInt1, paramInt2, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setColor(int paramInt)
  {
    super.setColor(paramInt);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt);
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
  
  public void setFakeBoldText(boolean paramBoolean)
  {
    super.setFakeBoldText(paramBoolean);
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(paramBoolean);
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setBold(paramBoolean);
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = vhy.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
  }
  
  public void setTextSize(float paramFloat)
  {
    super.setTextSize(paramFloat);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(paramFloat);
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = vhy.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhx
 * JD-Core Version:    0.7.0.1
 */