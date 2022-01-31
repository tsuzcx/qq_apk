package com.tencent.kingkong.xposed;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class XposedBridge
{
  public static final ClassLoader BOOTCLASSLOADER;
  private static final Object[] EMPTY_ARRAY;
  private static final String LOG_TAG = "KingKongXposedBridge";
  private static final int RUNTIME_ART = 2;
  private static final int RUNTIME_DALVIK = 1;
  private static final int RUNTIME_UNKNOW = 0;
  private static final ArrayList<XC_MethodHook.Unhook> allUnhookCallbacks = new ArrayList();
  private static Map<Class, String> builtInMap = new HashMap() {};
  private static boolean disableHooks;
  private static int runtime = 0;
  private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks;
  
  static
  {
    disableHooks = false;
    EMPTY_ARRAY = new Object[0];
    BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
    sHookedMethodCallbacks = new HashMap();
  }
  
  /* Error */
  public static int doPatch(android.content.Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: invokestatic 87	com/tencent/kingkong/DvmPatch:isDeviceSupportDVM	()Z
    //   3: ifne +6 -> 9
    //   6: bipush 12
    //   8: ireturn
    //   9: aload_0
    //   10: ifnonnull +13 -> 23
    //   13: ldc 20
    //   15: ldc 89
    //   17: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: iconst_1
    //   22: ireturn
    //   23: aload_1
    //   24: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +33 -> 60
    //   30: aload_2
    //   31: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +26 -> 60
    //   37: aload_3
    //   38: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +19 -> 60
    //   44: aload 4
    //   46: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +11 -> 60
    //   52: aload 5
    //   54: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifeq +13 -> 70
    //   60: ldc 20
    //   62: ldc 103
    //   64: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: iconst_2
    //   69: ireturn
    //   70: ldc 20
    //   72: ldc 104
    //   74: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 21
    //   83: if_icmplt +57 -> 140
    //   86: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   89: bipush 23
    //   91: if_icmpgt +49 -> 140
    //   94: new 111	java/lang/StringBuilder
    //   97: dup
    //   98: invokestatic 117	com/tencent/kingkong/Common:getDriverFolder	()Ljava/lang/String;
    //   101: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   110: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 137
    //   115: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 145	java/lang/System:load	(Ljava/lang/String;)V
    //   124: invokestatic 148	com/tencent/kingkong/xposed/XposedBridge:initNative	()Z
    //   127: ifne +104 -> 231
    //   130: ldc 20
    //   132: ldc 150
    //   134: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: iconst_4
    //   139: ireturn
    //   140: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   143: bipush 14
    //   145: if_icmplt -21 -> 124
    //   148: new 111	java/lang/StringBuilder
    //   151: dup
    //   152: invokestatic 117	com/tencent/kingkong/Common:getDriverFolder	()Ljava/lang/String;
    //   155: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   164: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 152
    //   169: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 145	java/lang/System:load	(Ljava/lang/String;)V
    //   178: goto -54 -> 124
    //   181: astore_0
    //   182: ldc 20
    //   184: new 111	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 154
    //   190: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: iconst_3
    //   205: ireturn
    //   206: astore_0
    //   207: ldc 20
    //   209: new 111	java/lang/StringBuilder
    //   212: dup
    //   213: ldc 154
    //   215: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_0
    //   219: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   228: pop
    //   229: iconst_3
    //   230: ireturn
    //   231: new 159	dalvik/system/DexClassLoader
    //   234: dup
    //   235: new 111	java/lang/StringBuilder
    //   238: dup
    //   239: aload_1
    //   240: invokestatic 123	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   243: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   249: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc 161
    //   258: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: aload_1
    //   265: aconst_null
    //   266: invokestatic 165	com/tencent/kingkong/Common:getDexClassLoader	()Ldalvik/system/DexClassLoader;
    //   269: invokespecial 168	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   272: astore_1
    //   273: aload_1
    //   274: aload 5
    //   276: invokevirtual 172	dalvik/system/DexClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   279: iconst_4
    //   280: anewarray 174	java/lang/Class
    //   283: dup
    //   284: iconst_0
    //   285: getstatic 180	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: ldc 119
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: ldc 119
    //   298: aastore
    //   299: dup
    //   300: iconst_3
    //   301: ldc 119
    //   303: aastore
    //   304: invokevirtual 184	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   307: iconst_4
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: iconst_0
    //   314: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload_2
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: aload_3
    //   325: aastore
    //   326: dup
    //   327: iconst_3
    //   328: aload 4
    //   330: aastore
    //   331: invokevirtual 193	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   334: checkcast 195	com/tencent/kingkong/xposed/DvmPatchInterface
    //   337: aload_0
    //   338: invokevirtual 199	com/tencent/kingkong/xposed/DvmPatchInterface:onLoad	(Landroid/content/Context;)V
    //   341: iconst_0
    //   342: ireturn
    //   343: astore_0
    //   344: ldc 20
    //   346: ldc 201
    //   348: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   351: pop
    //   352: aload_0
    //   353: invokestatic 205	com/tencent/kingkong/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   356: iconst_5
    //   357: ireturn
    //   358: astore_0
    //   359: goto -15 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramContext	android.content.Context
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramString3	String
    //   0	362	4	paramString4	String
    //   0	362	5	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   78	124	181	java/lang/Exception
    //   140	178	181	java/lang/Exception
    //   78	124	206	java/lang/Throwable
    //   140	178	206	java/lang/Throwable
    //   231	273	343	java/lang/Exception
    //   273	341	358	java/lang/Exception
  }
  
  private static int extractIntPart(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= k) {}
      int m;
      do
      {
        return j;
        m = paramString.charAt(i);
      } while ((48 > m) || (m > 57));
      j = j * 10 + (m - 48);
      i += 1;
    }
  }
  
  public static XC_MethodHook.Unhook findAndHookMethod(Class<?> paramClass, String arg1, Object... paramVarArgs)
  {
    if ((paramVarArgs.length == 0) || (!(paramVarArgs[(paramVarArgs.length - 1)] instanceof XC_MethodHook))) {
      throw new IllegalArgumentException("no callback defined");
    }
    XC_MethodHook localXC_MethodHook = (XC_MethodHook)paramVarArgs[(paramVarArgs.length - 1)];
    paramClass = hookMethod(XposedHelpers.findMethodExact(paramClass, ???, paramVarArgs), localXC_MethodHook);
    if ((!(localXC_MethodHook instanceof XC_MethodHook.XC_MethodKeepHook)) && (!(localXC_MethodHook instanceof XC_MethodReplacement.XC_MethodKeepReplacement))) {
      synchronized (allUnhookCallbacks)
      {
        allUnhookCallbacks.add(paramClass);
        return paramClass;
      }
    }
    return paramClass;
  }
  
  private static int getRuntime()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    do
    {
      return 2;
      if (Build.VERSION.SDK_INT < 20) {
        break;
      }
    } while (System.getProperty("persist.sys.dalvik.vm.lib", "").contains("art"));
    return 1;
    return 1;
  }
  
  /* Error */
  private static Object handleHookedMethod(Member paramMember, int paramInt, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
    throws Throwable
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 8	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo
    //   4: astore 9
    //   6: getstatic 44	com/tencent/kingkong/xposed/XposedBridge:disableHooks	Z
    //   9: ifeq +30 -> 39
    //   12: aload_0
    //   13: iload_1
    //   14: aload 9
    //   16: getfield 266	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   19: aload 9
    //   21: getfield 269	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   24: aload_3
    //   25: aload 4
    //   27: invokestatic 273	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 277	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   38: athrow
    //   39: aload 9
    //   41: getfield 281	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:callbacks	Lcom/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet;
    //   44: invokevirtual 284	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:getSnapshot	()[Ljava/lang/Object;
    //   47: astore_2
    //   48: aload_2
    //   49: arraylength
    //   50: istore 7
    //   52: iload 7
    //   54: ifne +30 -> 84
    //   57: aload_0
    //   58: iload_1
    //   59: aload 9
    //   61: getfield 266	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   64: aload 9
    //   66: getfield 269	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   69: aload_3
    //   70: aload 4
    //   72: invokestatic 273	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore_0
    //   76: aload_0
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 277	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   83: athrow
    //   84: new 286	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam
    //   87: dup
    //   88: invokespecial 287	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:<init>	()V
    //   91: astore 8
    //   93: aload 8
    //   95: aload_0
    //   96: putfield 291	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:method	Ljava/lang/reflect/Member;
    //   99: aload 8
    //   101: aload_3
    //   102: putfield 295	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   105: aload 8
    //   107: aload 4
    //   109: putfield 298	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   112: iconst_0
    //   113: istore 5
    //   115: aload_2
    //   116: iload 5
    //   118: aaload
    //   119: checkcast 219	com/tencent/kingkong/xposed/XC_MethodHook
    //   122: aload 8
    //   124: invokevirtual 302	com/tencent/kingkong/xposed/XC_MethodHook:beforeHookedMethod	(Lcom/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam;)V
    //   127: aload 8
    //   129: getfield 305	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   132: ifeq +119 -> 251
    //   135: iload 5
    //   137: iconst_1
    //   138: iadd
    //   139: istore 6
    //   141: aload 8
    //   143: getfield 305	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   146: ifne +33 -> 179
    //   149: aload 8
    //   151: aload_0
    //   152: iload_1
    //   153: aload 9
    //   155: getfield 266	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   158: aload 9
    //   160: getfield 269	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   163: aload 8
    //   165: getfield 295	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   168: aload 8
    //   170: getfield 298	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   173: invokestatic 273	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   176: invokevirtual 309	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   179: iload 6
    //   181: iconst_1
    //   182: isub
    //   183: istore_1
    //   184: aload 8
    //   186: invokevirtual 313	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   189: astore_0
    //   190: aload 8
    //   192: invokevirtual 316	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   195: astore_3
    //   196: aload_2
    //   197: iload_1
    //   198: aaload
    //   199: checkcast 219	com/tencent/kingkong/xposed/XC_MethodHook
    //   202: aload 8
    //   204: invokevirtual 319	com/tencent/kingkong/xposed/XC_MethodHook:afterHookedMethod	(Lcom/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam;)V
    //   207: iload_1
    //   208: iconst_1
    //   209: isub
    //   210: istore 5
    //   212: iload 5
    //   214: istore_1
    //   215: iload 5
    //   217: ifge -33 -> 184
    //   220: aload 8
    //   222: invokevirtual 322	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:hasThrowable	()Z
    //   225: ifeq +88 -> 313
    //   228: aload 8
    //   230: invokevirtual 316	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   233: athrow
    //   234: astore_3
    //   235: aload_3
    //   236: invokestatic 205	com/tencent/kingkong/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   239: aload 8
    //   241: aconst_null
    //   242: invokevirtual 309	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   245: aload 8
    //   247: iconst_0
    //   248: putfield 305	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   251: iload 5
    //   253: iconst_1
    //   254: iadd
    //   255: istore 6
    //   257: iload 6
    //   259: istore 5
    //   261: iload 6
    //   263: iload 7
    //   265: if_icmplt -150 -> 115
    //   268: goto -127 -> 141
    //   271: astore_0
    //   272: aload 8
    //   274: aload_0
    //   275: invokevirtual 277	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   278: invokevirtual 325	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   281: goto -102 -> 179
    //   284: astore 4
    //   286: aload 4
    //   288: invokestatic 205	com/tencent/kingkong/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   291: aload_3
    //   292: ifnonnull +12 -> 304
    //   295: aload 8
    //   297: aload_0
    //   298: invokevirtual 309	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   301: goto -94 -> 207
    //   304: aload 8
    //   306: aload_3
    //   307: invokevirtual 325	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   310: goto -103 -> 207
    //   313: aload 8
    //   315: invokevirtual 313	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   318: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramMember	Member
    //   0	319	1	paramInt	int
    //   0	319	2	paramObject1	Object
    //   0	319	3	paramObject2	Object
    //   0	319	4	paramArrayOfObject	Object[]
    //   113	147	5	i	int
    //   139	127	6	j	int
    //   50	216	7	k	int
    //   91	223	8	localMethodHookParam	XC_MethodHook.MethodHookParam
    //   4	155	9	localAdditionalHookInfo	AdditionalHookInfo
    // Exception table:
    //   from	to	target	type
    //   12	31	33	java/lang/reflect/InvocationTargetException
    //   57	76	78	java/lang/reflect/InvocationTargetException
    //   115	127	234	java/lang/Throwable
    //   149	179	271	java/lang/reflect/InvocationTargetException
    //   196	207	284	java/lang/Throwable
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> paramClass, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredConstructors();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localHashSet;
      }
      localHashSet.add(hookMethod(paramClass[i], paramXC_MethodHook));
      i += 1;
    }
  }
  
  public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> paramClass, String paramString, XC_MethodHook paramXC_MethodHook)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localHashSet;
      }
      Member localMember = paramClass[i];
      if (localMember.getName().equals(paramString)) {
        localHashSet.add(hookMethod(localMember, paramXC_MethodHook));
      }
      i += 1;
    }
  }
  
  public static XC_MethodHook.Unhook hookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    if ((!(paramMember instanceof Method)) && (!(paramMember instanceof Constructor))) {
      throw new IllegalArgumentException("Only methods and constructors can be hooked: " + paramMember.toString());
    }
    int i = 0;
    for (;;)
    {
      synchronized (sHookedMethodCallbacks)
      {
        localObject2 = (CopyOnWriteSortedSet)sHookedMethodCallbacks.get(paramMember);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new CopyOnWriteSortedSet();
          sHookedMethodCallbacks.put(paramMember, localObject1);
          i = 1;
        }
        ((CopyOnWriteSortedSet)localObject1).add(paramXC_MethodHook);
        if (i != 0)
        {
          Class localClass = paramMember.getDeclaringClass();
          if (runtime == 0) {
            runtime = getRuntime();
          }
          if (runtime == 1)
          {
            i = XposedHelpers.getIntField(paramMember, "slot");
            if (!(paramMember instanceof Method)) {
              break label214;
            }
            localObject2 = ((Method)paramMember).getParameterTypes();
            ??? = ((Method)paramMember).getReturnType();
            hookMethodNative(paramMember, localClass, i, new AdditionalHookInfo((CopyOnWriteSortedSet)localObject1, (Class[])localObject2, (Class)???, null));
          }
        }
        else
        {
          paramXC_MethodHook.getClass();
          return new XC_MethodHook.Unhook(paramXC_MethodHook, paramMember);
        }
      }
      i = 0;
      continue;
      label214:
      Object localObject2 = ((Constructor)paramMember).getParameterTypes();
      ??? = null;
    }
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  private static native boolean initNative();
  
  public static boolean initPatch()
  {
    return true;
  }
  
  public static Object invokeOriginalMethod(Member paramMember, Object paramObject, Object[] paramArrayOfObject)
    throws NullPointerException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = EMPTY_ARRAY;
    }
    if ((paramMember instanceof Method)) {
      paramArrayOfObject = ((Method)paramMember).getParameterTypes();
    }
    for (Class localClass = ((Method)paramMember).getReturnType();; localClass = null)
    {
      return invokeOriginalMethodNative(paramMember, 0, paramArrayOfObject, localClass, paramObject, arrayOfObject);
      if (!(paramMember instanceof Constructor)) {
        break;
      }
      paramArrayOfObject = ((Constructor)paramMember).getParameterTypes();
    }
    throw new IllegalArgumentException("method must be of type Method or Constructor");
  }
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
  
  public static void log(String paramString)
  {
    try
    {
      Log.d("Xposed", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void log(Throwable paramThrowable)
  {
    try
    {
      log(Log.getStackTraceString(paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  /* Error */
  public static void unhookAllMethods()
  {
    // Byte code:
    //   0: getstatic 66	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_0
    //   8: iload_0
    //   9: getstatic 66	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   12: invokevirtual 427	java/util/ArrayList:size	()I
    //   15: if_icmplt +12 -> 27
    //   18: getstatic 66	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   21: invokevirtual 430	java/util/ArrayList:clear	()V
    //   24: aload_1
    //   25: monitorexit
    //   26: return
    //   27: getstatic 66	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   30: iload_0
    //   31: invokevirtual 433	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 402	com/tencent/kingkong/xposed/XC_MethodHook$Unhook
    //   37: invokevirtual 436	com/tencent/kingkong/xposed/XC_MethodHook$Unhook:unhook	()V
    //   40: iload_0
    //   41: iconst_1
    //   42: iadd
    //   43: istore_0
    //   44: goto -36 -> 8
    //   47: astore_2
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	37	0	i	int
    //   3	46	1	localArrayList	ArrayList
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	26	47	finally
    //   27	40	47	finally
    //   48	50	47	finally
  }
  
  public static void unhookMethod(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    synchronized (sHookedMethodCallbacks)
    {
      paramMember = (CopyOnWriteSortedSet)sHookedMethodCallbacks.get(paramMember);
      if (paramMember == null) {
        return;
      }
      paramMember.remove(paramXC_MethodHook);
      return;
    }
  }
  
  private static class AdditionalHookInfo
  {
    final XposedBridge.CopyOnWriteSortedSet<XC_MethodHook> callbacks;
    final Class<?>[] parameterTypes;
    final Class<?> returnType;
    String shorty;
    
    private AdditionalHookInfo(XposedBridge.CopyOnWriteSortedSet<XC_MethodHook> paramCopyOnWriteSortedSet, Class<?>[] paramArrayOfClass, Class<?> paramClass)
    {
      this.callbacks = paramCopyOnWriteSortedSet;
      this.parameterTypes = paramArrayOfClass;
      this.returnType = paramClass;
      paramCopyOnWriteSortedSet = new StringBuilder(64);
      paramCopyOnWriteSortedSet.append(Class2Shorty(paramClass));
      int j = paramArrayOfClass.length;
      int i = 0;
      for (;;)
      {
        if (i >= j)
        {
          this.shorty = paramCopyOnWriteSortedSet.toString();
          return;
        }
        paramCopyOnWriteSortedSet.append(Class2Shorty(paramArrayOfClass[i]));
        i += 1;
      }
    }
    
    String Class2Shorty(Class<?> paramClass)
    {
      if (paramClass.isPrimitive()) {
        return (String)XposedBridge.builtInMap.get(paramClass);
      }
      return "L";
    }
  }
  
  public static class CopyOnWriteSortedSet<E>
  {
    private volatile transient Object[] elements = XposedBridge.EMPTY_ARRAY;
    
    private int indexOf(Object paramObject)
    {
      int i = 0;
      for (;;)
      {
        int j;
        if (i >= this.elements.length) {
          j = -1;
        }
        do
        {
          return j;
          j = i;
        } while (paramObject.equals(this.elements[i]));
        i += 1;
      }
    }
    
    /* Error */
    public boolean add(E paramE)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: aload_1
      //   6: invokespecial 30	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:indexOf	(Ljava/lang/Object;)I
      //   9: istore_2
      //   10: iload_2
      //   11: iflt +7 -> 18
      //   14: aload_0
      //   15: monitorexit
      //   16: iload_3
      //   17: ireturn
      //   18: aload_0
      //   19: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   22: arraylength
      //   23: iconst_1
      //   24: iadd
      //   25: anewarray 5	java/lang/Object
      //   28: astore 4
      //   30: aload_0
      //   31: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   34: iconst_0
      //   35: aload 4
      //   37: iconst_0
      //   38: aload_0
      //   39: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   42: arraylength
      //   43: invokestatic 36	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   46: aload 4
      //   48: aload_0
      //   49: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   52: arraylength
      //   53: aload_1
      //   54: aastore
      //   55: aload 4
      //   57: invokestatic 42	java/util/Arrays:sort	([Ljava/lang/Object;)V
      //   60: aload_0
      //   61: aload 4
      //   63: putfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   66: iconst_1
      //   67: istore_3
      //   68: goto -54 -> 14
      //   71: astore_1
      //   72: aload_0
      //   73: monitorexit
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	CopyOnWriteSortedSet
      //   0	76	1	paramE	E
      //   9	2	2	i	int
      //   1	67	3	bool	boolean
      //   28	34	4	arrayOfObject	Object[]
      // Exception table:
      //   from	to	target	type
      //   4	10	71	finally
      //   18	66	71	finally
    }
    
    public void clear()
    {
      try
      {
        this.elements = XposedBridge.EMPTY_ARRAY;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public Object[] getSnapshot()
    {
      return this.elements;
    }
    
    /* Error */
    public boolean remove(E paramE)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: aload_1
      //   6: invokespecial 30	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:indexOf	(Ljava/lang/Object;)I
      //   9: istore_2
      //   10: iload_2
      //   11: iconst_m1
      //   12: if_icmpne +7 -> 19
      //   15: aload_0
      //   16: monitorexit
      //   17: iload_3
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   23: arraylength
      //   24: iconst_1
      //   25: isub
      //   26: anewarray 5	java/lang/Object
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   34: iconst_0
      //   35: aload_1
      //   36: iconst_0
      //   37: iload_2
      //   38: invokestatic 36	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   41: aload_0
      //   42: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   45: iload_2
      //   46: iconst_1
      //   47: iadd
      //   48: aload_1
      //   49: iload_2
      //   50: aload_0
      //   51: getfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   54: arraylength
      //   55: iload_2
      //   56: isub
      //   57: iconst_1
      //   58: isub
      //   59: invokestatic 36	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   62: aload_0
      //   63: aload_1
      //   64: putfield 20	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
      //   67: iconst_1
      //   68: istore_3
      //   69: goto -54 -> 15
      //   72: astore_1
      //   73: aload_0
      //   74: monitorexit
      //   75: aload_1
      //   76: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	77	0	this	CopyOnWriteSortedSet
      //   0	77	1	paramE	E
      //   9	48	2	i	int
      //   1	68	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   4	10	72	finally
      //   19	67	72	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.xposed.XposedBridge
 * JD-Core Version:    0.7.0.1
 */