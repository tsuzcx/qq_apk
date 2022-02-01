package com.tencent.mobileqq.cuckoo;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cuckoo
{
  private static final int CLASSLOAD_CLASSFILELOADHOOK = 2;
  private static final int CLASSLOAD_CLASSLOADFIRST = 1;
  private static final int CLASSLOAD_CLASSPREPARE = 3;
  private static final String TAG = "Cuckoo";
  private static final Map<String, String> TYPETOSIGNATURE;
  private static boolean isSOLoaded;
  private static Map<Integer, String> mRegistMethoForClass;
  private static Map<Integer, MethodCopyOnWriteSet> mRegistMethods = new ConcurrentHashMap();
  private static String packageCodePath;
  private static ClassLoadCallback registClassLoadCallback = new Cuckoo.1();
  
  static
  {
    mRegistMethoForClass = new ConcurrentHashMap();
    packageCodePath = "";
    isSOLoaded = false;
    TYPETOSIGNATURE = new HashMap();
    TYPETOSIGNATURE.put("boolean", "Z");
    TYPETOSIGNATURE.put("byte", "B");
    TYPETOSIGNATURE.put("char", "C");
    TYPETOSIGNATURE.put("short", "S");
    TYPETOSIGNATURE.put("int", "I");
    TYPETOSIGNATURE.put("long", "J");
    TYPETOSIGNATURE.put("float", "F");
    TYPETOSIGNATURE.put("double", "D");
  }
  
  private static void callbackClassLoadJNI(Class paramClass, int paramInt)
  {
    if (paramInt == 1) {
      registClassLoadCallback.onClassLoadCallbackFirst(paramClass);
    }
    if (paramInt == 2) {
      registClassLoadCallback.onClassLoadCallbackFileLoadHook(paramClass);
    }
    if (paramInt == 3) {
      registClassLoadCallback.onClassLoadCallbackPrepare(paramClass);
    }
  }
  
  private static Object[] callbackEntryJNI(int paramInt, String paramString1, String paramString2, Object[] paramArrayOfObject, Object paramObject)
  {
    int k = 0;
    MethodCallback[] arrayOfMethodCallback = ((MethodCopyOnWriteSet)mRegistMethods.get(Integer.valueOf(paramInt))).getSnapshot();
    Object[] arrayOfObject = new Object[paramArrayOfObject.length + 1];
    arrayOfObject[0] = paramObject;
    int m = paramArrayOfObject.length;
    int i = 1;
    int j = 0;
    while (j < m)
    {
      arrayOfObject[i] = paramArrayOfObject[j];
      j += 1;
      i += 1;
    }
    j = arrayOfMethodCallback.length;
    i = k;
    while (i < j)
    {
      MethodCallback localMethodCallback = arrayOfMethodCallback[i];
      localMethodCallback.methodCallbackEntry(paramArrayOfObject);
      localMethodCallback.methodCallbackEntry(paramArrayOfObject, paramObject);
      localMethodCallback.methodCallbackEntry((String)mRegistMethoForClass.get(Integer.valueOf(paramInt)), paramString1, paramString2, arrayOfObject);
      paramArrayOfObject = localMethodCallback.methodCallbackSetArgs(paramArrayOfObject);
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  private static Object callbackExitJNI(int paramInt, Object paramObject)
  {
    MethodCallback[] arrayOfMethodCallback = ((MethodCopyOnWriteSet)mRegistMethods.get(Integer.valueOf(paramInt))).getSnapshot();
    int i = arrayOfMethodCallback.length;
    paramInt = 0;
    if (paramInt < i)
    {
      MethodCallback localMethodCallback = arrayOfMethodCallback[paramInt];
      if (paramObject == null) {
        localMethodCallback.methodCallbackExit(null);
      }
      for (;;)
      {
        paramObject = localMethodCallback.methodCallbackSetResult(paramObject);
        paramInt += 1;
        break;
        localMethodCallback.methodCallbackExit(paramObject);
      }
    }
    return paramObject;
  }
  
  private static void callbackThrowJNI(int paramInt, Object paramObject)
  {
    MethodCallback[] arrayOfMethodCallback = ((MethodCopyOnWriteSet)mRegistMethods.get(Integer.valueOf(paramInt))).getSnapshot();
    int i = arrayOfMethodCallback.length;
    paramInt = 0;
    if (paramInt < i)
    {
      MethodCallback localMethodCallback = arrayOfMethodCallback[paramInt];
      if (paramObject == null) {
        localMethodCallback.methodCallbackExitThrowable(null);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localMethodCallback.methodCallbackExitThrowable(paramObject);
      }
    }
  }
  
  public static void destoryClassCallback() {}
  
  private static native void destoryClassJNI();
  
  public static void destoryMethod(Class<?> paramClass, String paramString)
    throws IllegalArgumentException
  {
    paramClass = destoryMethodAllJNI(paramClass, paramString);
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      int k = paramClass[i];
      Log.i(paramString, k + "");
      destoryRegistedSet(k);
      i += 1;
    }
  }
  
  public static void destoryMethod(Class<?> paramClass, String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    destoryRegistedSet(destoryMethodJNI(paramClass, paramString1, paramString2));
    Log.i("erase success", paramString1 + " " + paramString2);
  }
  
  public static void destoryMethod(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    paramString1 = destoryMethodAllByClassNameJNI(paramString1, paramString2);
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString1[i];
      Log.i(paramString2, k + "");
      destoryRegistedSet(k);
      i += 1;
    }
  }
  
  public static void destoryMethod(String paramString1, String paramString2, String paramString3)
    throws IllegalArgumentException
  {
    destoryRegistedSet(destoryMethodByClassNameJNI(paramString1, paramString2, paramString3));
    Log.i("erase success", paramString2 + " " + paramString3);
  }
  
  private static native int[] destoryMethodAllByClassNameJNI(String paramString1, String paramString2);
  
  private static native int[] destoryMethodAllJNI(Class paramClass, String paramString);
  
  private static native int destoryMethodByClassNameJNI(String paramString1, String paramString2, String paramString3);
  
  private static native int destoryMethodJNI(Class paramClass, String paramString1, String paramString2);
  
  private static void destoryRegistedSet(int paramInt)
    throws IllegalArgumentException
  {
    if (mRegistMethods.containsKey(Integer.valueOf(paramInt)))
    {
      mRegistMethods.remove(Integer.valueOf(paramInt));
      return;
    }
    throw new IllegalArgumentException("not find method");
  }
  
  /* Error */
  public static void init(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 49	com/tencent/mobileqq/cuckoo/Cuckoo:isSOLoaded	Z
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: iload_0
    //   17: ifeq +7 -> 24
    //   20: invokestatic 237	com/tencent/mobileqq/warbler/Warbler:makeArtDebuggable	()Z
    //   23: pop
    //   24: ldc 239
    //   26: invokestatic 244	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   29: getstatic 249	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 28
    //   34: if_icmplt +15 -> 49
    //   37: ldc 251
    //   39: ldc 45
    //   41: ldc 2
    //   43: invokevirtual 257	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   46: invokestatic 263	android/os/Debug:attachJvmtiAgent	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   49: invokestatic 266	com/tencent/mobileqq/cuckoo/Cuckoo:startCuckoo	()V
    //   52: iconst_1
    //   53: putstatic 49	com/tencent/mobileqq/cuckoo/Cuckoo:isSOLoaded	Z
    //   56: goto -44 -> 12
    //   59: astore_2
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   70: goto -21 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramBoolean	boolean
    //   6	4	1	bool	boolean
    //   59	5	2	localObject	Object
    //   65	2	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   3	7	59	finally
    //   20	24	59	finally
    //   24	29	59	finally
    //   29	49	59	finally
    //   49	56	59	finally
    //   66	70	59	finally
    //   29	49	65	java/io/IOException
  }
  
  private static void insertRegistedSet(int paramInt, Callback paramCallback)
    throws IllegalArgumentException
  {
    MethodCopyOnWriteSet localMethodCopyOnWriteSet1;
    if (mRegistMethods.containsKey(Integer.valueOf(paramInt)))
    {
      MethodCopyOnWriteSet localMethodCopyOnWriteSet2 = (MethodCopyOnWriteSet)mRegistMethods.get(Integer.valueOf(paramInt));
      localMethodCopyOnWriteSet1 = localMethodCopyOnWriteSet2;
      if (localMethodCopyOnWriteSet2.indexOf(paramCallback) != -1) {
        throw new IllegalArgumentException("Callback has been registered");
      }
    }
    else
    {
      localMethodCopyOnWriteSet1 = new MethodCopyOnWriteSet();
    }
    localMethodCopyOnWriteSet1.add((MethodCallback)paramCallback);
    mRegistMethods.put(Integer.valueOf(paramInt), localMethodCopyOnWriteSet1);
  }
  
  public static void registClassCallback(ClassLoadCallback paramClassLoadCallback)
  {
    registClassLoadCallback = paramClassLoadCallback;
    registClassJNI();
  }
  
  private static native void registClassJNI();
  
  public static void registMethod(Class<?> paramClass, String paramString, Callback paramCallback)
    throws IllegalArgumentException
  {
    paramString = registMethodAllJNI(paramClass, paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("not find method");
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString[i];
      if (k == -1) {
        throw new IllegalArgumentException("not find method");
      }
      mRegistMethoForClass.put(Integer.valueOf(k), paramClass.getName());
      insertRegistedSet(k, paramCallback);
      i += 1;
    }
  }
  
  public static void registMethod(Class<?> paramClass, String paramString1, String paramString2, Callback paramCallback)
    throws IllegalArgumentException
  {
    int i = registMethodJNI(paramClass, paramString1, paramString2);
    if (i == -1) {
      throw new IllegalArgumentException("not find method");
    }
    mRegistMethoForClass.put(Integer.valueOf(i), paramClass.getName());
    insertRegistedSet(i, paramCallback);
  }
  
  public static void registMethod(String paramString1, String paramString2, Callback paramCallback)
    throws IllegalArgumentException
  {
    paramString2 = registMethodAllByClassNameJNI(paramString1, paramString2);
    if (paramString2 == null) {
      throw new IllegalArgumentException("not find method");
    }
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      int k = paramString2[i];
      if (k == -1) {
        throw new IllegalArgumentException("not find method");
      }
      mRegistMethoForClass.put(Integer.valueOf(k), paramString1);
      insertRegistedSet(k, (MethodCallback)paramCallback);
      i += 1;
    }
  }
  
  public static void registMethod(String paramString1, String paramString2, String paramString3, Callback paramCallback)
    throws IllegalArgumentException
  {
    int i = registMethodByClassNameJNI(paramString1, paramString2, paramString3);
    if (i == -1) {
      throw new IllegalArgumentException("not find method");
    }
    mRegistMethoForClass.put(Integer.valueOf(i), paramString1);
    insertRegistedSet(i, paramCallback);
  }
  
  private static native int[] registMethodAllByClassNameJNI(String paramString1, String paramString2);
  
  private static native int[] registMethodAllJNI(Class paramClass, String paramString);
  
  private static native int registMethodByClassNameJNI(String paramString1, String paramString2, String paramString3);
  
  private static native int registMethodJNI(Class paramClass, String paramString1, String paramString2);
  
  private static native void startCuckoo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.Cuckoo
 * JD-Core Version:    0.7.0.1
 */