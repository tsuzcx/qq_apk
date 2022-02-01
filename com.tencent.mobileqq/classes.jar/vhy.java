import android.graphics.Paint;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class vhy
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vhy jdField_a_of_type_Vhy;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  public AtomicBoolean a;
  private ETEngine b;
  public AtomicBoolean b;
  private ETEngine c;
  public AtomicBoolean c;
  public AtomicBoolean d = new AtomicBoolean(false);
  
  public vhy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static vhy a()
  {
    if (jdField_a_of_type_Vhy == null) {
      jdField_a_of_type_Vhy = new vhy();
    }
    return jdField_a_of_type_Vhy;
  }
  
  private ETEngine d()
  {
    if (d()) {
      return ETEngine.getInstance();
    }
    return null;
  }
  
  private boolean d()
  {
    boolean bool = true;
    if ((!gk.b()) && (gk.a())) {
      bool = gk.c();
    }
    while (gk.a()) {
      return bool;
    }
    bmzc.a().a(null);
    QLog.d("ETSpace", 1, "initEngine but libvipfont.so didn't download, start download.");
    return false;
  }
  
  /* Error */
  public float a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	vhy:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   6: ifnull +27 -> 33
    //   9: aload_0
    //   10: getfield 74	vhy:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   13: aload_1
    //   14: iload_2
    //   15: iload_3
    //   16: aload 4
    //   18: aload 5
    //   20: invokevirtual 78	com/etrump/mixlayout/ETEngine:native_spaceMeasureText	(Ljava/lang/String;IILcom/etrump/mixlayout/ETFont;Landroid/graphics/Paint;)I
    //   23: istore_2
    //   24: iload_2
    //   25: i2f
    //   26: fstore 6
    //   28: aload_0
    //   29: monitorexit
    //   30: fload 6
    //   32: freturn
    //   33: fconst_0
    //   34: fstore 6
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	vhy
    //   0	44	1	paramString	String
    //   0	44	2	paramInt1	int
    //   0	44	3	paramInt2	int
    //   0	44	4	paramETFont	ETFont
    //   0	44	5	paramPaint	Paint
    //   26	9	6	f	float
    // Exception table:
    //   from	to	target	type
    //   2	24	39	finally
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, Paint paramPaint, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean) {}
    int[] arrayOfInt;
    int i;
    try
    {
      for (ETEngine localETEngine = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine; localETEngine != null; localETEngine = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine)
      {
        arrayOfInt = new int[paramArrayOfFloat.length];
        i = localETEngine.native_spaceGetTextWidths(paramString, paramInt1, paramInt2, paramETFont, paramPaint, arrayOfInt);
        paramInt2 = j;
        break label70;
      }
      paramInt1 = 0;
      return paramInt1;
    }
    finally {}
    for (;;)
    {
      label70:
      paramInt1 = i;
      if (paramInt2 >= i) {
        break;
      }
      paramArrayOfFloat[paramInt2] = arrayOfInt[paramInt2];
      paramInt2 += 1;
    }
  }
  
  /* Error */
  public android.graphics.Paint.FontMetrics a(ETFont paramETFont)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	vhy:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   6: ifnull +35 -> 41
    //   9: aload_1
    //   10: ifnull +31 -> 41
    //   13: new 88	android/graphics/Paint$FontMetrics
    //   16: dup
    //   17: invokespecial 89	android/graphics/Paint$FontMetrics:<init>	()V
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 74	vhy:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 93	com/etrump/mixlayout/ETEngine:native_getFontMetrics	(Landroid/graphics/Paint$FontMetrics;Lcom/etrump/mixlayout/ETFont;)Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifeq +9 -> 41
    //   35: aload_3
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -6 -> 37
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	vhy
    //   0	51	1	paramETFont	ETFont
    //   30	2	2	bool	boolean
    //   20	16	3	localFontMetrics	android.graphics.Paint.FontMetrics
    // Exception table:
    //   from	to	target	type
    //   2	9	46	finally
    //   13	31	46	finally
  }
  
  public ETEngine a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  }
  
  public boolean a()
  {
    return (b()) && (c());
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return true;
    }
    boolean bool;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = d();
      }
      ETEngine localETEngine = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine;
      if (localETEngine == null) {}
    }
    return false;
  }
  
  public ETEngine b()
  {
    b();
    return this.jdField_b_of_type_ComEtrumpMixlayoutETEngine;
  }
  
  public boolean b()
  {
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETEngine != null) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return true;
    }
    for (;;)
    {
      boolean bool;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ETEngine localETEngine;
        if (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine == null)
        {
          if (d())
          {
            localETEngine = ETEngine.getInstanceForSpace();
            this.jdField_b_of_type_ComEtrumpMixlayoutETEngine = localETEngine;
          }
        }
        else
        {
          localETEngine = this.jdField_b_of_type_ComEtrumpMixlayoutETEngine;
          if (localETEngine == null) {
            break;
          }
        }
      }
      Object localObject2 = null;
    }
    return false;
  }
  
  public ETEngine c()
  {
    c();
    return this.jdField_c_of_type_ComEtrumpMixlayoutETEngine;
  }
  
  public boolean c()
  {
    if ((this.jdField_c_of_type_ComEtrumpMixlayoutETEngine != null) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return true;
    }
    for (;;)
    {
      boolean bool;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        ETEngine localETEngine;
        if (this.jdField_c_of_type_ComEtrumpMixlayoutETEngine == null)
        {
          if (d())
          {
            localETEngine = ETEngine.getInstanceForAnimation();
            this.jdField_c_of_type_ComEtrumpMixlayoutETEngine = localETEngine;
          }
        }
        else
        {
          localETEngine = this.jdField_c_of_type_ComEtrumpMixlayoutETEngine;
          if (localETEngine == null) {
            break;
          }
        }
      }
      Object localObject2 = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhy
 * JD-Core Version:    0.7.0.1
 */