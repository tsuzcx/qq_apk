package com.tencent.kingkong.xposed;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.kingkong.Common;
import com.tencent.kingkong.DvmPatch;
import dalvik.system.DexClassLoader;
import java.io.File;
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
  private static DexClassLoader cl;
  private static Class dexClass;
  private static boolean disableHooks;
  private static int runtime = 0;
  private static final Map<Member, CopyOnWriteSortedSet<XC_MethodHook>> sHookedMethodCallbacks;
  
  static
  {
    cl = null;
    dexClass = null;
    disableHooks = false;
    EMPTY_ARRAY = new Object[0];
    BOOTCLASSLOADER = ClassLoader.getSystemClassLoader();
    sHookedMethodCallbacks = new HashMap();
  }
  
  public static int doPatch(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!DvmPatch.isDeviceSupportDVM()) {
      return 12;
    }
    if (paramContext == null)
    {
      Log.d("KingKongXposedBridge", "DvmPatch doPath context is null");
      return 1;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5)))
    {
      Log.d("KingKongXposedBridge", "DvmPatch doPath value is empty");
      return 2;
    }
    Log.d("KingKongXposedBridge", "doPatch");
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = Common.GetPatchFolder();
        if (Build.VERSION.SDK_INT == 23)
        {
          System.load(localObject + "/" + "libxposed_art60.so");
          if (initNative()) {
            break;
          }
          Log.d("KingKongXposedBridge", "Xposed init native fail");
          return 4;
        }
        if (Build.VERSION.SDK_INT == 22)
        {
          System.load(localObject + "/" + "libxposed_art51.so");
          continue;
        }
      }
      catch (Exception paramContext)
      {
        Log.d("KingKongXposedBridge", "Load library failed : " + paramContext);
        return 3;
        if (Build.VERSION.SDK_INT == 21)
        {
          System.load(localObject + "/" + "libxposed_art50.so");
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        Log.d("KingKongXposedBridge", "Load library failed : " + paramContext);
        return 3;
      }
      if (Build.VERSION.SDK_INT >= 14) {
        System.load(localObject + "/" + "libxposed_dalvik.so");
      }
    }
    try
    {
      localObject = new File(paramString1 + "/" + paramString2 + ".jar");
      paramString1 = new File(paramString1);
      cl = new DexClassLoader(((File)localObject).getAbsolutePath(), paramString1.getAbsolutePath(), null, paramContext.getClassLoader());
      dexClass = cl.loadClass(paramString5);
      paramContext = Integer.TYPE;
      ((DvmPatchInterface)dexClass.getConstructor(new Class[] { paramContext, String.class, String.class, String.class }).newInstance(new Object[] { Integer.valueOf(0), paramString2, paramString3, paramString4 })).onLoad();
      return 0;
    }
    catch (Exception paramContext)
    {
      Log.d("KingKongXposedBridge", "Dex load fail");
      log(paramContext);
    }
    return 5;
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
    //   6: getstatic 52	com/tencent/kingkong/xposed/XposedBridge:disableHooks	Z
    //   9: ifeq +30 -> 39
    //   12: aload_0
    //   13: iload_1
    //   14: aload 9
    //   16: getfield 280	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   19: aload 9
    //   21: getfield 283	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   24: aload_3
    //   25: aload 4
    //   27: invokestatic 287	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 291	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   38: athrow
    //   39: aload 9
    //   41: getfield 295	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:callbacks	Lcom/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet;
    //   44: invokevirtual 298	com/tencent/kingkong/xposed/XposedBridge$CopyOnWriteSortedSet:getSnapshot	()[Ljava/lang/Object;
    //   47: astore_2
    //   48: aload_2
    //   49: arraylength
    //   50: istore 7
    //   52: iload 7
    //   54: ifne +30 -> 84
    //   57: aload_0
    //   58: iload_1
    //   59: aload 9
    //   61: getfield 280	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   64: aload 9
    //   66: getfield 283	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   69: aload_3
    //   70: aload 4
    //   72: invokestatic 287	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore_0
    //   76: aload_0
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 291	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   83: athrow
    //   84: new 300	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam
    //   87: dup
    //   88: invokespecial 301	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:<init>	()V
    //   91: astore 8
    //   93: aload 8
    //   95: aload_0
    //   96: putfield 305	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:method	Ljava/lang/reflect/Member;
    //   99: aload 8
    //   101: aload_3
    //   102: putfield 309	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   105: aload 8
    //   107: aload 4
    //   109: putfield 312	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   112: iconst_0
    //   113: istore 5
    //   115: aload_2
    //   116: iload 5
    //   118: aaload
    //   119: checkcast 233	com/tencent/kingkong/xposed/XC_MethodHook
    //   122: aload 8
    //   124: invokevirtual 316	com/tencent/kingkong/xposed/XC_MethodHook:beforeHookedMethod	(Lcom/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam;)V
    //   127: aload 8
    //   129: getfield 319	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   132: ifeq +119 -> 251
    //   135: iload 5
    //   137: iconst_1
    //   138: iadd
    //   139: istore 6
    //   141: aload 8
    //   143: getfield 319	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
    //   146: ifne +33 -> 179
    //   149: aload 8
    //   151: aload_0
    //   152: iload_1
    //   153: aload 9
    //   155: getfield 280	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:parameterTypes	[Ljava/lang/Class;
    //   158: aload 9
    //   160: getfield 283	com/tencent/kingkong/xposed/XposedBridge$AdditionalHookInfo:returnType	Ljava/lang/Class;
    //   163: aload 8
    //   165: getfield 309	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:thisObject	Ljava/lang/Object;
    //   168: aload 8
    //   170: getfield 312	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:args	[Ljava/lang/Object;
    //   173: invokestatic 287	com/tencent/kingkong/xposed/XposedBridge:invokeOriginalMethodNative	(Ljava/lang/reflect/Member;I[Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   176: invokevirtual 323	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   179: iload 6
    //   181: iconst_1
    //   182: isub
    //   183: istore_1
    //   184: aload 8
    //   186: invokevirtual 327	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
    //   189: astore_0
    //   190: aload 8
    //   192: invokevirtual 330	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   195: astore_3
    //   196: aload_2
    //   197: iload_1
    //   198: aaload
    //   199: checkcast 233	com/tencent/kingkong/xposed/XC_MethodHook
    //   202: aload 8
    //   204: invokevirtual 333	com/tencent/kingkong/xposed/XC_MethodHook:afterHookedMethod	(Lcom/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam;)V
    //   207: iload_1
    //   208: iconst_1
    //   209: isub
    //   210: istore 5
    //   212: iload 5
    //   214: istore_1
    //   215: iload 5
    //   217: ifge -33 -> 184
    //   220: aload 8
    //   222: invokevirtual 336	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:hasThrowable	()Z
    //   225: ifeq +88 -> 313
    //   228: aload 8
    //   230: invokevirtual 330	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getThrowable	()Ljava/lang/Throwable;
    //   233: athrow
    //   234: astore_3
    //   235: aload_3
    //   236: invokestatic 219	com/tencent/kingkong/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   239: aload 8
    //   241: aconst_null
    //   242: invokevirtual 323	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   245: aload 8
    //   247: iconst_0
    //   248: putfield 319	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:returnEarly	Z
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
    //   275: invokevirtual 291	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   278: invokevirtual 339	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   281: goto -102 -> 179
    //   284: astore 4
    //   286: aload 4
    //   288: invokestatic 219	com/tencent/kingkong/xposed/XposedBridge:log	(Ljava/lang/Throwable;)V
    //   291: aload_3
    //   292: ifnonnull +12 -> 304
    //   295: aload 8
    //   297: aload_0
    //   298: invokevirtual 323	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setResult	(Ljava/lang/Object;)V
    //   301: goto -94 -> 207
    //   304: aload 8
    //   306: aload_3
    //   307: invokevirtual 339	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:setThrowable	(Ljava/lang/Throwable;)V
    //   310: goto -103 -> 207
    //   313: aload 8
    //   315: invokevirtual 327	com/tencent/kingkong/xposed/XC_MethodHook$MethodHookParam:getResult	()Ljava/lang/Object;
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
    //   0: getstatic 74	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_0
    //   8: iload_0
    //   9: getstatic 74	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   12: invokevirtual 441	java/util/ArrayList:size	()I
    //   15: if_icmplt +12 -> 27
    //   18: getstatic 74	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   21: invokevirtual 444	java/util/ArrayList:clear	()V
    //   24: aload_1
    //   25: monitorexit
    //   26: return
    //   27: getstatic 74	com/tencent/kingkong/xposed/XposedBridge:allUnhookCallbacks	Ljava/util/ArrayList;
    //   30: iload_0
    //   31: invokevirtual 447	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 416	com/tencent/kingkong/xposed/XC_MethodHook$Unhook
    //   37: invokevirtual 450	com/tencent/kingkong/xposed/XC_MethodHook$Unhook:unhook	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.xposed.XposedBridge
 * JD-Core Version:    0.7.0.1
 */