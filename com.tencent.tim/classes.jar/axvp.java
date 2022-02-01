import android.text.StaticLayout;
import java.lang.reflect.Constructor;

public class axvp
{
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
    //   3: invokestatic 25	axvp:ensureInitialized	()V
    //   6: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   15: iconst_1
    //   16: iload_1
    //   17: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   24: iconst_2
    //   25: iload_2
    //   26: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   39: iconst_4
    //   40: iload 4
    //   42: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   49: iconst_5
    //   50: aload 5
    //   52: aastore
    //   53: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   56: bipush 6
    //   58: getstatic 35	axvp:sTextDirection	Ljava/lang/Object;
    //   61: aastore
    //   62: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   65: bipush 7
    //   67: fload 6
    //   69: invokestatic 40	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   72: aastore
    //   73: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   76: bipush 8
    //   78: fload 7
    //   80: invokestatic 40	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   83: aastore
    //   84: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   87: bipush 9
    //   89: iload 8
    //   91: invokestatic 45	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   98: bipush 10
    //   100: aload 9
    //   102: aastore
    //   103: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   106: bipush 11
    //   108: iload 10
    //   110: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   117: bipush 12
    //   119: iload 11
    //   121: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: getstatic 47	axvp:sConstructor	Ljava/lang/reflect/Constructor;
    //   128: getstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   131: invokevirtual 53	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 55	android/text/StaticLayout
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: areturn
    //   143: astore_0
    //   144: new 57	java/lang/IllegalStateException
    //   147: dup
    //   148: new 59	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   155: ldc 62
    //   157: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 76	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
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
  public static void ensureInitialized()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 86	axvp:sInitialized	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 92	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 18
    //   20: if_icmplt +134 -> 154
    //   23: ldc 94
    //   25: astore_1
    //   26: getstatic 100	android/text/TextDirectionHeuristics:FIRSTSTRONG_LTR	Landroid/text/TextDirectionHeuristic;
    //   29: putstatic 35	axvp:sTextDirection	Ljava/lang/Object;
    //   32: bipush 13
    //   34: anewarray 102	java/lang/Class
    //   37: astore_2
    //   38: aload_2
    //   39: iconst_0
    //   40: ldc 104
    //   42: aastore
    //   43: aload_2
    //   44: iconst_1
    //   45: getstatic 108	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   48: aastore
    //   49: aload_2
    //   50: iconst_2
    //   51: getstatic 108	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: aload_2
    //   56: iconst_3
    //   57: ldc 110
    //   59: aastore
    //   60: aload_2
    //   61: iconst_4
    //   62: getstatic 108	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   65: aastore
    //   66: aload_2
    //   67: iconst_5
    //   68: ldc 112
    //   70: aastore
    //   71: aload_2
    //   72: bipush 6
    //   74: aload_1
    //   75: aastore
    //   76: aload_2
    //   77: bipush 7
    //   79: getstatic 113	java/lang/Float:TYPE	Ljava/lang/Class;
    //   82: aastore
    //   83: aload_2
    //   84: bipush 8
    //   86: getstatic 113	java/lang/Float:TYPE	Ljava/lang/Class;
    //   89: aastore
    //   90: aload_2
    //   91: bipush 9
    //   93: getstatic 114	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   96: aastore
    //   97: aload_2
    //   98: bipush 10
    //   100: ldc 116
    //   102: aastore
    //   103: aload_2
    //   104: bipush 11
    //   106: getstatic 108	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   109: aastore
    //   110: aload_2
    //   111: bipush 12
    //   113: getstatic 108	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   116: aastore
    //   117: ldc 55
    //   119: aload_2
    //   120: invokevirtual 120	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   123: putstatic 47	axvp:sConstructor	Ljava/lang/reflect/Constructor;
    //   126: getstatic 47	axvp:sConstructor	Ljava/lang/reflect/Constructor;
    //   129: iconst_1
    //   130: invokevirtual 124	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   133: aload_2
    //   134: arraylength
    //   135: anewarray 4	java/lang/Object
    //   138: putstatic 27	axvp:sConstructorArgs	[Ljava/lang/Object;
    //   141: iconst_1
    //   142: putstatic 86	axvp:sInitialized	Z
    //   145: goto -134 -> 11
    //   148: astore_1
    //   149: ldc 2
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: ldc 2
    //   156: invokevirtual 128	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: astore_2
    //   160: aload_2
    //   161: ldc 130
    //   163: invokevirtual 136	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   166: astore_1
    //   167: aload_2
    //   168: ldc 138
    //   170: invokevirtual 136	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore_2
    //   174: aload_2
    //   175: ldc 139
    //   177: invokevirtual 143	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   180: aload_2
    //   181: invokevirtual 149	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: putstatic 35	axvp:sTextDirection	Ljava/lang/Object;
    //   187: goto -155 -> 32
    //   190: astore_1
    //   191: ldc 151
    //   193: ldc 153
    //   195: aload_1
    //   196: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   199: pop
    //   200: iconst_1
    //   201: putstatic 86	axvp:sInitialized	Z
    //   204: goto -193 -> 11
    //   207: astore_1
    //   208: ldc 151
    //   210: ldc 161
    //   212: aload_1
    //   213: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   216: pop
    //   217: iconst_1
    //   218: putstatic 86	axvp:sInitialized	Z
    //   221: goto -210 -> 11
    //   224: astore_1
    //   225: ldc 151
    //   227: ldc 163
    //   229: aload_1
    //   230: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: iconst_1
    //   235: putstatic 86	axvp:sInitialized	Z
    //   238: goto -227 -> 11
    //   241: astore_1
    //   242: ldc 151
    //   244: ldc 165
    //   246: aload_1
    //   247: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   250: pop
    //   251: iconst_1
    //   252: putstatic 86	axvp:sInitialized	Z
    //   255: goto -244 -> 11
    //   258: astore_1
    //   259: iconst_1
    //   260: putstatic 86	axvp:sInitialized	Z
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   25	50	1	localTextDirectionHeuristic	android.text.TextDirectionHeuristic
    //   148	5	1	localObject1	Object
    //   166	1	1	localClass	java.lang.Class
    //   190	6	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   207	6	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   224	6	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   241	6	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   258	6	1	localObject2	Object
    //   37	144	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	148	finally
    //   141	145	148	finally
    //   200	204	148	finally
    //   217	221	148	finally
    //   234	238	148	finally
    //   251	255	148	finally
    //   259	265	148	finally
    //   15	23	190	java/lang/NoSuchMethodException
    //   26	32	190	java/lang/NoSuchMethodException
    //   32	38	190	java/lang/NoSuchMethodException
    //   43	55	190	java/lang/NoSuchMethodException
    //   60	66	190	java/lang/NoSuchMethodException
    //   76	97	190	java/lang/NoSuchMethodException
    //   103	141	190	java/lang/NoSuchMethodException
    //   154	187	190	java/lang/NoSuchMethodException
    //   15	23	207	java/lang/ClassNotFoundException
    //   26	32	207	java/lang/ClassNotFoundException
    //   32	38	207	java/lang/ClassNotFoundException
    //   43	55	207	java/lang/ClassNotFoundException
    //   60	66	207	java/lang/ClassNotFoundException
    //   76	97	207	java/lang/ClassNotFoundException
    //   103	141	207	java/lang/ClassNotFoundException
    //   154	187	207	java/lang/ClassNotFoundException
    //   15	23	224	java/lang/NoSuchFieldException
    //   26	32	224	java/lang/NoSuchFieldException
    //   32	38	224	java/lang/NoSuchFieldException
    //   43	55	224	java/lang/NoSuchFieldException
    //   60	66	224	java/lang/NoSuchFieldException
    //   76	97	224	java/lang/NoSuchFieldException
    //   103	141	224	java/lang/NoSuchFieldException
    //   154	187	224	java/lang/NoSuchFieldException
    //   15	23	241	java/lang/IllegalAccessException
    //   26	32	241	java/lang/IllegalAccessException
    //   32	38	241	java/lang/IllegalAccessException
    //   43	55	241	java/lang/IllegalAccessException
    //   60	66	241	java/lang/IllegalAccessException
    //   76	97	241	java/lang/IllegalAccessException
    //   103	141	241	java/lang/IllegalAccessException
    //   154	187	241	java/lang/IllegalAccessException
    //   15	23	258	finally
    //   26	32	258	finally
    //   32	38	258	finally
    //   43	55	258	finally
    //   60	66	258	finally
    //   76	97	258	finally
    //   103	141	258	finally
    //   154	187	258	finally
    //   191	200	258	finally
    //   208	217	258	finally
    //   225	234	258	finally
    //   242	251	258	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvp
 * JD-Core Version:    0.7.0.1
 */