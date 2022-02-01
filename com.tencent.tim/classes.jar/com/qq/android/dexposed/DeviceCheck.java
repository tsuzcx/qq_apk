package com.qq.android.dexposed;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;

public class DeviceCheck
{
  private static final String LIB_ART = "libart.so";
  private static final String LIB_ART_D = "libartd.so";
  private static final String LIB_DALVIK = "libdvm.so";
  private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
  private static boolean isCheckedDeviceSupport = false;
  private static boolean isDeviceSupportable = false;
  
  /* Error */
  private static String getCurrentRuntimeValue()
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 52
    //   9: iconst_2
    //   10: anewarray 46	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 54
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 54
    //   22: aastore
    //   23: invokevirtual 58	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +8 -> 36
    //   31: ldc 60
    //   33: astore_1
    //   34: aload_1
    //   35: areturn
    //   36: aload_2
    //   37: aload_1
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 17
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 62
    //   51: aastore
    //   52: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 54	java/lang/String
    //   58: astore_1
    //   59: ldc 14
    //   61: aload_1
    //   62: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: istore_0
    //   66: iload_0
    //   67: ifeq +6 -> 73
    //   70: ldc 62
    //   72: areturn
    //   73: ldc 8
    //   75: aload_1
    //   76: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: istore_0
    //   80: iload_0
    //   81: ifeq +6 -> 87
    //   84: ldc 74
    //   86: areturn
    //   87: ldc 11
    //   89: aload_1
    //   90: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: istore_0
    //   94: iload_0
    //   95: ifeq -61 -> 34
    //   98: ldc 76
    //   100: areturn
    //   101: astore_1
    //   102: ldc 78
    //   104: areturn
    //   105: astore_1
    //   106: ldc 80
    //   108: areturn
    //   109: astore_1
    //   110: ldc 82
    //   112: areturn
    //   113: astore_1
    //   114: ldc 84
    //   116: areturn
    //   117: astore_1
    //   118: ldc 86
    //   120: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	30	0	bool	boolean
    //   5	85	1	localObject	Object
    //   101	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   105	1	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   109	1	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   113	1	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   117	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   26	11	2	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   36	66	101	java/lang/IllegalAccessException
    //   73	80	101	java/lang/IllegalAccessException
    //   87	94	101	java/lang/IllegalAccessException
    //   36	66	105	java/lang/IllegalArgumentException
    //   73	80	105	java/lang/IllegalArgumentException
    //   87	94	105	java/lang/IllegalArgumentException
    //   36	66	109	java/lang/reflect/InvocationTargetException
    //   73	80	109	java/lang/reflect/InvocationTargetException
    //   87	94	109	java/lang/reflect/InvocationTargetException
    //   6	27	113	java/lang/NoSuchMethodException
    //   36	66	113	java/lang/NoSuchMethodException
    //   73	80	113	java/lang/NoSuchMethodException
    //   87	94	113	java/lang/NoSuchMethodException
    //   0	6	117	java/lang/ClassNotFoundException
    //   6	27	117	java/lang/ClassNotFoundException
    //   36	66	117	java/lang/ClassNotFoundException
    //   73	80	117	java/lang/ClassNotFoundException
    //   87	94	117	java/lang/ClassNotFoundException
  }
  
  private static boolean isDalvikMode()
  {
    return "Dalvik".equals(getCurrentRuntimeValue());
  }
  
  public static boolean isDeviceSupport(Context paramContext)
  {
    try
    {
      if (isCheckedDeviceSupport) {
        bool = isDeviceSupportable;
      }
    }
    finally
    {
      boolean bool;
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
    }
    try
    {
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
      return bool;
    }
    finally {}
    if ((!isX86CPU()) && (!isYunOS())) {}
    for (isDeviceSupportable = true;; isDeviceSupportable = false)
    {
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
      bool = isDeviceSupportable;
      break;
    }
  }
  
  private static boolean isSupportSDKVersion()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (Build.VERSION.SDK_INT < 20)) {}
    while ((Build.VERSION.SDK_INT == 10) || (Build.VERSION.SDK_INT == 9)) {
      return true;
    }
    return false;
  }
  
  /* Error */
  private static boolean isX86CPU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: invokestatic 140	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   9: ldc 142
    //   11: invokevirtual 146	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   14: astore_1
    //   15: new 148	java/io/InputStreamReader
    //   18: dup
    //   19: aload_1
    //   20: invokevirtual 154	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   23: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_3
    //   27: new 159	java/io/BufferedReader
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: ldc 167
    //   42: invokevirtual 171	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   45: istore_0
    //   46: iload_0
    //   47: ifeq +96 -> 143
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 174	java/io/BufferedReader:close	()V
    //   58: aload_3
    //   59: ifnull +7 -> 66
    //   62: aload_3
    //   63: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 178	java/lang/Process:destroy	()V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload 5
    //   83: astore_3
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 174	java/io/BufferedReader:close	()V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 178	java/lang/Process:destroy	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_1
    //   115: aload 4
    //   117: ifnull +8 -> 125
    //   120: aload 4
    //   122: invokevirtual 174	java/io/BufferedReader:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 178	java/lang/Process:destroy	()V
    //   141: aload_2
    //   142: athrow
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 174	java/io/BufferedReader:close	()V
    //   151: aload_3
    //   152: ifnull +7 -> 159
    //   155: aload_3
    //   156: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   159: aload_1
    //   160: ifnull -52 -> 108
    //   163: aload_1
    //   164: invokevirtual 178	java/lang/Process:destroy	()V
    //   167: goto -59 -> 108
    //   170: astore_1
    //   171: goto -63 -> 108
    //   174: astore_2
    //   175: goto -117 -> 58
    //   178: astore_2
    //   179: goto -113 -> 66
    //   182: astore_1
    //   183: goto -109 -> 74
    //   186: astore_1
    //   187: goto -95 -> 92
    //   190: astore_1
    //   191: goto -91 -> 100
    //   194: astore_1
    //   195: goto -87 -> 108
    //   198: astore 4
    //   200: goto -75 -> 125
    //   203: astore_3
    //   204: goto -71 -> 133
    //   207: astore_1
    //   208: goto -67 -> 141
    //   211: astore_2
    //   212: goto -61 -> 151
    //   215: astore_2
    //   216: goto -57 -> 159
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_3
    //   222: goto -107 -> 115
    //   225: astore_2
    //   226: goto -111 -> 115
    //   229: astore 5
    //   231: aload_2
    //   232: astore 4
    //   234: aload 5
    //   236: astore_2
    //   237: goto -122 -> 115
    //   240: astore_2
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_1
    //   244: astore_2
    //   245: aload_3
    //   246: astore_1
    //   247: aload 5
    //   249: astore_3
    //   250: goto -166 -> 84
    //   253: astore_2
    //   254: aconst_null
    //   255: astore 4
    //   257: aload_1
    //   258: astore_2
    //   259: aload 4
    //   261: astore_1
    //   262: goto -178 -> 84
    //   265: astore 4
    //   267: aload_1
    //   268: astore 4
    //   270: aload_2
    //   271: astore_1
    //   272: aload 4
    //   274: astore_2
    //   275: goto -191 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	2	0	bool	boolean
    //   14	57	1	localProcess	java.lang.Process
    //   76	1	1	localException1	java.lang.Exception
    //   78	86	1	localObject1	Object
    //   170	1	1	localException2	java.lang.Exception
    //   182	1	1	localException3	java.lang.Exception
    //   186	1	1	localException4	java.lang.Exception
    //   190	1	1	localException5	java.lang.Exception
    //   194	1	1	localException6	java.lang.Exception
    //   207	37	1	localException7	java.lang.Exception
    //   246	26	1	localObject2	Object
    //   35	70	2	localBufferedReader	java.io.BufferedReader
    //   110	38	2	localObject3	Object
    //   174	1	2	localException8	java.lang.Exception
    //   178	1	2	localException9	java.lang.Exception
    //   211	1	2	localException10	java.lang.Exception
    //   215	1	2	localException11	java.lang.Exception
    //   219	1	2	localObject4	Object
    //   225	7	2	localObject5	Object
    //   236	1	2	localObject6	Object
    //   240	1	2	localException12	java.lang.Exception
    //   244	1	2	localException13	java.lang.Exception
    //   253	1	2	localException14	java.lang.Exception
    //   258	17	2	localObject7	Object
    //   26	130	3	localObject8	Object
    //   203	1	3	localException15	java.lang.Exception
    //   221	29	3	localObject9	Object
    //   1	120	4	localObject10	Object
    //   198	1	4	localException16	java.lang.Exception
    //   232	28	4	localObject11	Object
    //   265	1	4	localException17	java.lang.Exception
    //   268	5	4	localObject12	Object
    //   4	78	5	localObject13	Object
    //   229	19	5	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	76	java/lang/Exception
    //   6	15	110	finally
    //   163	167	170	java/lang/Exception
    //   54	58	174	java/lang/Exception
    //   62	66	178	java/lang/Exception
    //   70	74	182	java/lang/Exception
    //   88	92	186	java/lang/Exception
    //   96	100	190	java/lang/Exception
    //   104	108	194	java/lang/Exception
    //   120	125	198	java/lang/Exception
    //   129	133	203	java/lang/Exception
    //   137	141	207	java/lang/Exception
    //   147	151	211	java/lang/Exception
    //   155	159	215	java/lang/Exception
    //   15	27	219	finally
    //   27	36	225	finally
    //   36	46	229	finally
    //   15	27	240	java/lang/Exception
    //   27	36	253	java/lang/Exception
    //   36	46	265	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.SuppressLint({"DefaultLocale"})
  public static boolean isYunOS()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 44
    //   4: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   7: ldc 52
    //   9: iconst_1
    //   10: anewarray 46	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 54
    //   17: aastore
    //   18: invokevirtual 58	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: astore_2
    //   22: aload_2
    //   23: aconst_null
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: ldc 183
    //   32: aastore
    //   33: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 54	java/lang/String
    //   39: astore_0
    //   40: aload_2
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 185
    //   50: aastore
    //   51: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 54	java/lang/String
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +15 -> 76
    //   64: aload_1
    //   65: invokevirtual 188	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   68: ldc 190
    //   70: invokevirtual 171	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifne +17 -> 90
    //   76: aload_0
    //   77: ifnull +15 -> 92
    //   80: aload_0
    //   81: invokevirtual 193	java/lang/String:trim	()Ljava/lang/String;
    //   84: invokevirtual 197	java/lang/String:length	()I
    //   87: ifle +5 -> 92
    //   90: iconst_1
    //   91: ireturn
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_0
    //   97: goto -37 -> 60
    //   100: astore_2
    //   101: goto -41 -> 60
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -47 -> 60
    //   110: astore_2
    //   111: goto -51 -> 60
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -57 -> 60
    //   120: astore_2
    //   121: goto -61 -> 60
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_0
    //   127: goto -67 -> 60
    //   130: astore_2
    //   131: goto -71 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	42	0	str	String
    //   94	1	0	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   96	1	0	localObject1	Object
    //   104	1	0	localIllegalAccessException1	java.lang.IllegalAccessException
    //   106	1	0	localObject2	Object
    //   114	1	0	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   116	1	0	localObject3	Object
    //   124	1	0	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   126	1	0	localObject4	Object
    //   1	64	1	localObject5	Object
    //   21	38	2	localObject6	Object
    //   100	1	2	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   110	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   120	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   130	1	2	localNoSuchMethodException2	java.lang.NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   2	40	94	java/lang/reflect/InvocationTargetException
    //   40	58	100	java/lang/reflect/InvocationTargetException
    //   2	40	104	java/lang/IllegalAccessException
    //   40	58	110	java/lang/IllegalAccessException
    //   2	40	114	java/lang/ClassNotFoundException
    //   40	58	120	java/lang/ClassNotFoundException
    //   2	40	124	java/lang/NoSuchMethodException
    //   40	58	130	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.android.dexposed.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */