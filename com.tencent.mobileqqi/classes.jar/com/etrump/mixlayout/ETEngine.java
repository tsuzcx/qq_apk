package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import ff;
import fg;
import fj;
import java.util.ArrayList;

public class ETEngine
{
  private static final int jdField_a_of_type_Int = 24;
  private static ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
  public static final String a = "ETEngine";
  private static final int jdField_b_of_type_Int = 1048576;
  private float jdField_a_of_type_Float = 1.0F;
  EtrumpJNI jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI = null;
  private FontManager jdField_a_of_type_ComEtrumpMixlayoutFontManager = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
  private boolean jdField_a_of_type_Boolean = false;
  private ff[] jdField_a_of_type_ArrayOfFf = { new ff(), new ff() };
  private boolean jdField_b_of_type_Boolean;
  
  private ETEngine()
  {
    this.b = false;
    if (a(1048576) == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static ETEngine a()
  {
    if (jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
      jdField_a_of_type_ComEtrumpMixlayoutETEngine = new ETEngine();
    }
    return jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  }
  
  private boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfInt == null) {}
    do
    {
      return false;
      switch (paramInt3)
      {
      default: 
        return false;
      }
      paramInt1 = paramInt1 * paramInt2 * paramInt3 / 8;
    } while ((paramInt1 <= 0) || (paramInt1 > paramArrayOfInt.length * 4));
    return true;
  }
  
  private int c(int paramInt)
  {
    if (!this.b) {
      return paramInt;
    }
    return (0xFF000000 & paramInt) + ((paramInt & 0xFF) << 16) + (0xFF00 & paramInt) + ((0xFF0000 & paramInt) >> 16);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a(float paramFloat)
  {
    float f = this.jdField_a_of_type_Float;
    if (this.jdField_a_of_type_Float <= 0.0F) {
      f = 1.0F;
    }
    return (int)(f * paramFloat + 0.5F);
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeInitEngine(paramInt);
  }
  
  public int a(Bitmap.Config paramConfig)
  {
    int i = 0;
    if (paramConfig.equals(Bitmap.Config.ALPHA_8)) {
      i = 8;
    }
    do
    {
      return i;
      if ((paramConfig.equals(Bitmap.Config.ARGB_4444)) || (paramConfig.equals(Bitmap.Config.RGB_565))) {
        return 16;
      }
    } while (!paramConfig.equals(Bitmap.Config.ARGB_8888));
    return 32;
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/etrump/mixlayout/ETEngine:jdField_a_of_type_Boolean	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   20: lstore 4
    //   22: new 98	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 6
    //   32: aload 6
    //   34: invokevirtual 105	java/io/File:exists	()Z
    //   37: ifeq +15 -> 52
    //   40: aload 6
    //   42: invokevirtual 108	java/io/File:lastModified	()J
    //   45: getstatic 113	com/etrump/mixlayout/FontManager:a	J
    //   48: lcmp
    //   49: ifne +52 -> 101
    //   52: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc 11
    //   60: iconst_2
    //   61: new 120	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   68: aload_1
    //   69: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 127
    //   74: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_0
    //   91: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: invokevirtual 142	java/util/ArrayList:size	()I
    //   97: istore_2
    //   98: goto -85 -> 13
    //   101: aload 6
    //   103: invokevirtual 108	java/io/File:lastModified	()J
    //   106: putstatic 113	com/etrump/mixlayout/FontManager:a	J
    //   109: new 47	java/util/ArrayList
    //   112: dup
    //   113: invokespecial 143	java/util/ArrayList:<init>	()V
    //   116: astore_1
    //   117: aload 6
    //   119: new 145	fh
    //   122: dup
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial 148	fh:<init>	(Lcom/etrump/mixlayout/ETEngine;Ljava/util/ArrayList;)V
    //   128: invokevirtual 152	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   131: pop
    //   132: aload_0
    //   133: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   136: astore 6
    //   138: aload 6
    //   140: monitorenter
    //   141: aload_0
    //   142: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   145: invokevirtual 155	java/util/ArrayList:clear	()V
    //   148: aload_0
    //   149: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   152: aload_1
    //   153: invokevirtual 159	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   156: pop
    //   157: aload 6
    //   159: monitorexit
    //   160: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +45 -> 208
    //   166: ldc 11
    //   168: iconst_2
    //   169: new 120	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   176: ldc 161
    //   178: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   184: lload 4
    //   186: lsub
    //   187: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc 166
    //   192: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   199: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_0
    //   209: getfield 52	com/etrump/mixlayout/ETEngine:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   212: invokevirtual 142	java/util/ArrayList:size	()I
    //   215: istore_2
    //   216: goto -203 -> 13
    //   219: astore_1
    //   220: aload 6
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	ETEngine
    //   0	230	1	paramString	String
    //   12	204	2	i	int
    //   6	2	3	bool	boolean
    //   20	165	4	l	long
    // Exception table:
    //   from	to	target	type
    //   141	160	219	finally
    //   220	223	219	finally
    //   2	7	225	finally
    //   17	52	225	finally
    //   52	90	225	finally
    //   90	98	225	finally
    //   101	141	225	finally
    //   160	208	225	finally
    //   208	216	225	finally
    //   223	225	225	finally
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutLock(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int a(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeDrawTextWithBitmap(paramString, paramBitmap, 0, paramInt1, paramInt2);
  }
  
  public int a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!a(paramArrayOfInt, paramInt1, paramInt2, paramInt3)) {
      return 0;
    }
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeDrawTextWithArray(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramInt5);
  }
  
  public EtrumpLayoutLine a(int paramInt1, int paramInt2)
  {
    return new EtrumpLayoutLine(this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutGetLineWidth(paramInt1, paramInt2), this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutGetLineHeight(paramInt1, paramInt2), this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutGetLineRangeFrom(paramInt1, paramInt2), this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutGetLineRangeTo(paramInt1, paramInt2));
  }
  
  public fg a(long paramLong)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          fg localfg = (fg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localfg.a == paramLong) {
            return localfg;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    int i = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontCreateFromFile(paramString);
    if (i == 0) {}
    do
    {
      return null;
      paramString = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeGetFontNameByLangId(i, 1033);
    } while ((paramString == null) || (paramString.length() == 0));
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontDelete(i);
    return paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = null;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = c(paramInt);
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetFontColor(paramInt);
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    paramInt = c(paramInt);
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetShadowInfo(paramInt, (int)paramFloat1, (int)paramFloat2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    paramInt1 = paramInt2;
    switch (paramInt2)
    {
    default: 
      paramInt1 = 1;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetAlignment(i, paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat)
  {
    int j = 24;
    int i = paramInt1;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    label61:
    int k;
    if (paramInt2 > 0)
    {
      if (!paramBoolean) {
        break label92;
      }
      paramInt1 = 1;
      k = (int)paramFloat;
      if (k >= 24) {
        break label97;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetLineBreakMode(i, paramInt2, paramInt1, j);
      return;
      paramInt2 = 0;
      break;
      label92:
      paramInt1 = 0;
      break label61;
      label97:
      j = k;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    arrayOfff = this.jdField_a_of_type_ArrayOfFf;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localff = this.jdField_a_of_type_ArrayOfFf[0];
        localff.jdField_b_of_type_Int = paramInt2;
        localff.jdField_a_of_type_Int = paramInt1;
        localff.jdField_b_of_type_JavaLangString = paramString1;
        localff.jdField_a_of_type_JavaLangString = paramString2;
        return;
      }
      finally {}
      ff localff = this.jdField_a_of_type_ArrayOfFf[1];
    }
  }
  
  public void a(FontManager paramFontManager)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = paramFontManager;
  }
  
  public void a(ff paramff)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontDelete(paramff.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("ETEngine", 2, "removeFont id=" + paramff.jdField_a_of_type_Int + ", handle=" + paramff.jdField_b_of_type_Int);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!a(paramArrayOfInt, paramInt1, paramInt2, paramInt3)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeDrawTextWithArray(paramString, paramArrayOfInt, paramInt1, paramInt2, paramInt3, 0, paramInt4, paramInt5);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeEnablePreMultiplyColor(paramBoolean);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt, byte paramByte)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeMemset(paramArrayOfInt, paramInt, paramByte);
  }
  
  public boolean a(char paramChar)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeIsPaintableChar(paramChar) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutHasPreline(paramInt);
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontCreateFromFile(paramString);
    if (i == 0)
    {
      paramBoolean = bool;
      if (QLog.isColorLevel())
      {
        QLog.d("ETEngine", 2, "create font fail id=" + paramInt + ", handle=" + i);
        paramBoolean = bool;
      }
    }
    String str;
    do
    {
      return paramBoolean;
      str = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeGetFontNameByLangId(i, 1033);
      if ((str == null) || (str.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ETEngine", 2, "get font name fail id=" + paramInt + ", handle=" + i);
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontDelete(i);
        return false;
      }
      a(paramInt, str, i, paramString, paramBoolean);
      bool = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSwitchFont(i);
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.d("ETEngine", 2, "register font name=" + str + ", id=" + paramInt + ", handle=" + i + "switch result=" + bool);
    return bool;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = true;
    for (;;)
    {
      ff[] arrayOfff;
      try
      {
        boolean bool2 = this.jdField_a_of_type_Boolean;
        if (!bool2)
        {
          paramBoolean = false;
          return paramBoolean;
        }
        if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(paramBoolean))
        {
          paramBoolean = false;
          continue;
        }
        arrayOfff = this.jdField_a_of_type_ArrayOfFf;
        if (paramBoolean) {
          try
          {
            ff localff = this.jdField_a_of_type_ArrayOfFf[0];
            if (localff.jdField_a_of_type_Int != paramInt) {
              break label101;
            }
            paramBoolean = bool1;
            continue;
          }
          finally {}
        }
        localObject3 = this.jdField_a_of_type_ArrayOfFf[1];
      }
      finally {}
      continue;
      label101:
      if ((((ff)localObject3).jdField_a_of_type_Int != paramInt) && (((ff)localObject3).jdField_b_of_type_Int > 0))
      {
        a((ff)localObject3);
        a(0, null, 0, null, paramBoolean);
      }
      long l = paramInt;
      Object localObject3 = a(l);
      if (localObject3 != null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(true, paramBoolean);
        ThreadManager.a(new fj(this, paramInt, (fg)localObject3, paramBoolean));
        paramBoolean = false;
      }
      else
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(paramInt, null);
        paramBoolean = false;
      }
    }
  }
  
  public boolean a(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    ff[] arrayOfff = this.jdField_a_of_type_ArrayOfFf;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_ArrayOfFf.length) {
          break;
        }
        ff localff = this.jdField_a_of_type_ArrayOfFf[i];
        if (localff.jdField_a_of_type_Int == paramLong)
        {
          boolean bool = this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSwitchFont(localff.jdField_b_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("ETEngine", 2, "switch font name=" + localff.jdField_b_of_type_JavaLangString + ",id=" + paramLong + ", handle=" + localff.jdField_b_of_type_Int + ",switch font=" + bool);
          }
          return true;
        }
      }
      finally {}
      i += 1;
    }
    return false;
  }
  
  public int b(float paramFloat)
  {
    float f = this.jdField_a_of_type_Float;
    if (this.jdField_a_of_type_Float <= 0.0F) {
      f = 1.0F;
    }
    return (int)(paramFloat / f + 0.5F);
  }
  
  public int b(int paramInt)
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutGetLineTotal(paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeDoneEngine();
  }
  
  public void b(float paramFloat)
  {
    int i = 24;
    int j = (int)paramFloat;
    if (j < 24) {}
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetFontSize(i);
      return;
      i = j;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetFontStyle(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_ArrayOfFf)
    {
      while (i < this.jdField_a_of_type_ArrayOfFf.length)
      {
        ff localff = this.jdField_a_of_type_ArrayOfFf[i];
        if (localff.jdField_b_of_type_Int > 0)
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeFontDelete(localff.jdField_b_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("ETEngine", 2, "removeAllFont id=" + localff.jdField_a_of_type_Int + ", active=" + localff.jdField_b_of_type_Int);
          }
        }
        localff.jdField_b_of_type_Int = 0;
        localff.jdField_a_of_type_Int = 0;
        localff.jdField_b_of_type_JavaLangString = null;
        localff.jdField_a_of_type_JavaLangString = null;
        i += 1;
      }
      return;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetCrochetWidth(paramInt);
  }
  
  public void d(int paramInt)
  {
    paramInt = c(paramInt);
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeSetEdgeColor(paramInt);
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutEtrumpJNI.nativeTextLayoutUnlock(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETEngine
 * JD-Core Version:    0.7.0.1
 */