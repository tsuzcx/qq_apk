package com.tencent.ditto.widget.text;

import android.os.Build.VERSION;
import android.text.StaticLayout;
import java.lang.reflect.Constructor;

public class StaticLayoutWithMaxLines
{
  private static final boolean DEG = false;
  private static final String TAG = StaticLayoutWithMaxLines.class.getSimpleName();
  private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
  private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
  private static final String TEXT_DIR_FIRST_STRONG_LTR = "FIRSTSTRONG_LTR";
  private static Constructor<StaticLayout> sConstructor;
  private static Object[] sConstructorArgs;
  private static boolean sInitialized;
  private static Object sTextDirection;
  
  /* Error */
  public static StaticLayout create(java.lang.CharSequence paramCharSequence, int paramInt1, int paramInt2, android.text.TextPaint paramTextPaint, int paramInt3, android.text.Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, android.text.TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 47	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:ensureInitialized	()V
    //   6: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   15: iconst_1
    //   16: iload_1
    //   17: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   24: iconst_2
    //   25: iload_2
    //   26: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   39: iconst_4
    //   40: iload 4
    //   42: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   49: iconst_5
    //   50: aload 5
    //   52: aastore
    //   53: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   56: bipush 6
    //   58: getstatic 57	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   61: aastore
    //   62: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   65: bipush 7
    //   67: fload 6
    //   69: invokestatic 62	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   72: aastore
    //   73: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   76: bipush 8
    //   78: fload 7
    //   80: invokestatic 62	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   83: aastore
    //   84: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   87: bipush 9
    //   89: iload 8
    //   91: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   98: bipush 10
    //   100: aload 9
    //   102: aastore
    //   103: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   106: bipush 11
    //   108: iload 10
    //   110: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   117: bipush 12
    //   119: iload 11
    //   121: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: getstatic 69	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   128: getstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   131: invokevirtual 75	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 77	android/text/StaticLayout
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: new 79	java/lang/IllegalStateException
    //   147: dup
    //   148: new 81	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   155: ldc 84
    //   157: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 97	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: astore_0
    //   172: ldc 2
    //   174: monitorexit
    //   175: aload_0
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramCharSequence	java.lang.CharSequence
    //   0	177	1	paramInt1	int
    //   0	177	2	paramInt2	int
    //   0	177	3	paramTextPaint	android.text.TextPaint
    //   0	177	4	paramInt3	int
    //   0	177	5	paramAlignment	android.text.Layout.Alignment
    //   0	177	6	paramFloat1	float
    //   0	177	7	paramFloat2	float
    //   0	177	8	paramBoolean	boolean
    //   0	177	9	paramTruncateAt	android.text.TextUtils.TruncateAt
    //   0	177	10	paramInt4	int
    //   0	177	11	paramInt5	int
    // Exception table:
    //   from	to	target	type
    //   6	138	143	java/lang/Exception
    //   3	6	171	finally
    //   6	138	171	finally
    //   144	171	171	finally
  }
  
  /* Error */
  @android.annotation.TargetApi(18)
  public static void ensureInitialized()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 116	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +134 -> 154
    //   23: ldc 118
    //   25: astore_1
    //   26: getstatic 123	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 57	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   32: bipush 13
    //   34: anewarray 30	java/lang/Class
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_0
    //   40: ldc 125
    //   42: aastore
    //   43: aload_2
    //   44: iconst_1
    //   45: getstatic 129	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   48: aastore
    //   49: aload_2
    //   50: iconst_2
    //   51: getstatic 129	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: aload_2
    //   56: iconst_3
    //   57: ldc 131
    //   59: aastore
    //   60: aload_2
    //   61: iconst_4
    //   62: getstatic 129	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   65: aastore
    //   66: aload_2
    //   67: iconst_5
    //   68: ldc 133
    //   70: aastore
    //   71: aload_2
    //   72: bipush 6
    //   74: aload_1
    //   75: aastore
    //   76: aload_2
    //   77: bipush 7
    //   79: getstatic 134	java/lang/Float:TYPE	Ljava/lang/Class;
    //   82: aastore
    //   83: aload_2
    //   84: bipush 8
    //   86: getstatic 134	java/lang/Float:TYPE	Ljava/lang/Class;
    //   89: aastore
    //   90: aload_2
    //   91: bipush 9
    //   93: getstatic 135	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   96: aastore
    //   97: aload_2
    //   98: bipush 10
    //   100: ldc 137
    //   102: aastore
    //   103: aload_2
    //   104: bipush 11
    //   106: getstatic 129	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   109: aastore
    //   110: aload_2
    //   111: bipush 12
    //   113: getstatic 129	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   116: aastore
    //   117: ldc 77
    //   119: aload_2
    //   120: invokevirtual 141	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   123: putstatic 69	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   126: getstatic 69	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructor	Ljava/lang/reflect/Constructor;
    //   129: iconst_1
    //   130: invokevirtual 145	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   133: aload_2
    //   134: arraylength
    //   135: anewarray 4	java/lang/Object
    //   138: putstatic 49	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sConstructorArgs	[Ljava/lang/Object;
    //   141: iconst_1
    //   142: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   145: goto -134 -> 11
    //   148: astore_1
    //   149: ldc 2
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: ldc 2
    //   156: invokevirtual 149	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnonnull +127 -> 288
    //   164: invokestatic 154	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +53 -> 222
    //   172: aload_1
    //   173: ldc 15
    //   175: invokestatic 160	com/tencent/ditto/utils/ClassLoadUtils:load	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;
    //   178: astore_2
    //   179: aload_1
    //   180: ldc 12
    //   182: invokestatic 160	com/tencent/ditto/utils/ClassLoadUtils:load	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;
    //   185: astore_1
    //   186: aload_1
    //   187: ldc 18
    //   189: invokevirtual 164	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   192: aload_1
    //   193: invokevirtual 170	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: putstatic 57	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sTextDirection	Ljava/lang/Object;
    //   199: aload_2
    //   200: astore_1
    //   201: goto -169 -> 32
    //   204: astore_1
    //   205: getstatic 36	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   208: ldc 172
    //   210: aload_1
    //   211: invokestatic 178	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: iconst_1
    //   216: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   219: goto -208 -> 11
    //   222: aconst_null
    //   223: astore_1
    //   224: goto -192 -> 32
    //   227: astore_1
    //   228: getstatic 36	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   231: ldc 180
    //   233: aload_1
    //   234: invokestatic 178	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: iconst_1
    //   239: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   242: goto -231 -> 11
    //   245: astore_1
    //   246: getstatic 36	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   249: ldc 182
    //   251: aload_1
    //   252: invokestatic 178	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   255: pop
    //   256: iconst_1
    //   257: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   260: goto -249 -> 11
    //   263: astore_1
    //   264: getstatic 36	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:TAG	Ljava/lang/String;
    //   267: ldc 184
    //   269: aload_1
    //   270: invokestatic 178	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   273: pop
    //   274: iconst_1
    //   275: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   278: goto -267 -> 11
    //   281: astore_1
    //   282: iconst_1
    //   283: putstatic 110	com/tencent/ditto/widget/text/StaticLayoutWithMaxLines:sInitialized	Z
    //   286: aload_1
    //   287: athrow
    //   288: goto -120 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	50	1	localTextDirectionHeuristic	android.text.TextDirectionHeuristic
    //   148	5	1	localObject1	Object
    //   159	42	1	localObject2	Object
    //   204	7	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   223	1	1	localObject3	Object
    //   227	7	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   245	7	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   263	7	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   281	6	1	localObject4	Object
    //   37	163	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	148	finally
    //   141	145	148	finally
    //   215	219	148	finally
    //   238	242	148	finally
    //   256	260	148	finally
    //   274	278	148	finally
    //   282	288	148	finally
    //   15	23	204	java/lang/NoSuchMethodException
    //   26	32	204	java/lang/NoSuchMethodException
    //   32	38	204	java/lang/NoSuchMethodException
    //   43	55	204	java/lang/NoSuchMethodException
    //   60	66	204	java/lang/NoSuchMethodException
    //   76	97	204	java/lang/NoSuchMethodException
    //   103	141	204	java/lang/NoSuchMethodException
    //   154	160	204	java/lang/NoSuchMethodException
    //   164	168	204	java/lang/NoSuchMethodException
    //   172	199	204	java/lang/NoSuchMethodException
    //   15	23	227	java/lang/ClassNotFoundException
    //   26	32	227	java/lang/ClassNotFoundException
    //   32	38	227	java/lang/ClassNotFoundException
    //   43	55	227	java/lang/ClassNotFoundException
    //   60	66	227	java/lang/ClassNotFoundException
    //   76	97	227	java/lang/ClassNotFoundException
    //   103	141	227	java/lang/ClassNotFoundException
    //   154	160	227	java/lang/ClassNotFoundException
    //   164	168	227	java/lang/ClassNotFoundException
    //   172	199	227	java/lang/ClassNotFoundException
    //   15	23	245	java/lang/NoSuchFieldException
    //   26	32	245	java/lang/NoSuchFieldException
    //   32	38	245	java/lang/NoSuchFieldException
    //   43	55	245	java/lang/NoSuchFieldException
    //   60	66	245	java/lang/NoSuchFieldException
    //   76	97	245	java/lang/NoSuchFieldException
    //   103	141	245	java/lang/NoSuchFieldException
    //   154	160	245	java/lang/NoSuchFieldException
    //   164	168	245	java/lang/NoSuchFieldException
    //   172	199	245	java/lang/NoSuchFieldException
    //   15	23	263	java/lang/IllegalAccessException
    //   26	32	263	java/lang/IllegalAccessException
    //   32	38	263	java/lang/IllegalAccessException
    //   43	55	263	java/lang/IllegalAccessException
    //   60	66	263	java/lang/IllegalAccessException
    //   76	97	263	java/lang/IllegalAccessException
    //   103	141	263	java/lang/IllegalAccessException
    //   154	160	263	java/lang/IllegalAccessException
    //   164	168	263	java/lang/IllegalAccessException
    //   172	199	263	java/lang/IllegalAccessException
    //   15	23	281	finally
    //   26	32	281	finally
    //   32	38	281	finally
    //   43	55	281	finally
    //   60	66	281	finally
    //   76	97	281	finally
    //   103	141	281	finally
    //   154	160	281	finally
    //   164	168	281	finally
    //   172	199	281	finally
    //   205	215	281	finally
    //   228	238	281	finally
    //   246	256	281	finally
    //   264	274	281	finally
  }
  
  public static boolean isSupported()
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return false;
      ensureInitialized();
    } while (sConstructor == null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.text.StaticLayoutWithMaxLines
 * JD-Core Version:    0.7.0.1
 */