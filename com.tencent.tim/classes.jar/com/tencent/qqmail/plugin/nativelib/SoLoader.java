package com.tencent.qqmail.plugin.nativelib;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMApplicationContext;
import java.io.File;

public class SoLoader
{
  private static final String TAG = "SoLoader";
  
  /* Error */
  private static boolean addNativeLibraryPath(android.content.Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   4: invokestatic 37	moai/patch/multidex/MultiDex:getPathListFieldObject	(Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   7: astore_2
    //   8: invokestatic 43	com/tencent/qqmail/utilities/VersionUtils:hasMarshmallow	()Z
    //   11: ifne +48 -> 59
    //   14: aload_2
    //   15: ldc 45
    //   17: iconst_1
    //   18: anewarray 47	java/io/File
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: invokestatic 53	moai/patch/reflect/MoaiReflect:expandFieldArray	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: iconst_4
    //   29: ldc 8
    //   31: new 55	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   38: ldc 58
    //   40: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 75	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   56: goto +227 -> 283
    //   59: aload_2
    //   60: ldc 45
    //   62: invokestatic 79	moai/patch/reflect/MoaiReflect:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: aload_2
    //   66: invokevirtual 85	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 87	java/util/List
    //   72: astore_3
    //   73: aload_3
    //   74: iconst_0
    //   75: aload_1
    //   76: invokeinterface 91 3 0
    //   81: aload_2
    //   82: ldc 93
    //   84: invokestatic 79	moai/patch/reflect/MoaiReflect:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   87: aload_2
    //   88: invokevirtual 85	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 87	java/util/List
    //   94: astore_0
    //   95: new 95	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 96	java/util/ArrayList:<init>	()V
    //   102: astore 4
    //   104: aload_3
    //   105: aload_0
    //   106: invokeinterface 100 2 0
    //   111: pop
    //   112: aload_2
    //   113: ldc 102
    //   115: iconst_1
    //   116: anewarray 104	java/lang/Class
    //   119: dup
    //   120: iconst_0
    //   121: ldc 87
    //   123: aastore
    //   124: invokestatic 108	moai/patch/reflect/MoaiReflect:findMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   127: aload_2
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_3
    //   135: aastore
    //   136: invokevirtual 114	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 116	[Ljava/lang/Object;
    //   142: checkcast 116	[Ljava/lang/Object;
    //   145: astore_0
    //   146: aload_2
    //   147: ldc 118
    //   149: invokestatic 79	moai/patch/reflect/MoaiReflect:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   152: astore_3
    //   153: aload_3
    //   154: iconst_1
    //   155: invokevirtual 122	java/lang/reflect/Field:setAccessible	(Z)V
    //   158: aload_3
    //   159: aload_2
    //   160: aload_0
    //   161: invokevirtual 126	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: iconst_4
    //   165: ldc 8
    //   167: new 55	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   174: ldc 128
    //   176: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 75	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   192: goto +91 -> 283
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 131	java/lang/NoSuchFieldException:printStackTrace	()V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_0
    //   203: aload_2
    //   204: ldc 102
    //   206: iconst_3
    //   207: anewarray 104	java/lang/Class
    //   210: dup
    //   211: iconst_0
    //   212: ldc 87
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: ldc 47
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: ldc 87
    //   224: aastore
    //   225: invokestatic 108	moai/patch/reflect/MoaiReflect:findMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   228: aload_2
    //   229: iconst_3
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_3
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aconst_null
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: aload 4
    //   245: aastore
    //   246: invokevirtual 114	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   249: checkcast 116	[Ljava/lang/Object;
    //   252: checkcast 116	[Ljava/lang/Object;
    //   255: astore_0
    //   256: goto -110 -> 146
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 132	java/lang/IllegalAccessException:printStackTrace	()V
    //   264: goto -64 -> 200
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 133	java/lang/NoSuchMethodException:printStackTrace	()V
    //   272: goto -72 -> 200
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 134	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   280: goto -80 -> 200
    //   283: iconst_1
    //   284: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	android.content.Context
    //   0	285	1	paramFile	File
    //   7	222	2	localObject1	Object
    //   72	164	3	localObject2	Object
    //   102	142	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	56	195	java/lang/NoSuchFieldException
    //   59	112	195	java/lang/NoSuchFieldException
    //   112	146	195	java/lang/NoSuchFieldException
    //   146	192	195	java/lang/NoSuchFieldException
    //   203	256	195	java/lang/NoSuchFieldException
    //   112	146	202	java/lang/Throwable
    //   0	56	259	java/lang/IllegalAccessException
    //   59	112	259	java/lang/IllegalAccessException
    //   112	146	259	java/lang/IllegalAccessException
    //   146	192	259	java/lang/IllegalAccessException
    //   203	256	259	java/lang/IllegalAccessException
    //   0	56	267	java/lang/NoSuchMethodException
    //   59	112	267	java/lang/NoSuchMethodException
    //   112	146	267	java/lang/NoSuchMethodException
    //   146	192	267	java/lang/NoSuchMethodException
    //   203	256	267	java/lang/NoSuchMethodException
    //   0	56	275	java/lang/reflect/InvocationTargetException
    //   59	112	275	java/lang/reflect/InvocationTargetException
    //   112	146	275	java/lang/reflect/InvocationTargetException
    //   146	192	275	java/lang/reflect/InvocationTargetException
    //   203	256	275	java/lang/reflect/InvocationTargetException
  }
  
  public static boolean loadAllLibrary(@NonNull String paramString)
  {
    int i = 0;
    Object localObject = new File(paramString);
    if ((localObject == null) || (!((File)localObject).isDirectory()) || (!((File)localObject).exists())) {}
    do
    {
      return false;
      paramString = ((File)localObject).listFiles(new SoLoader.1());
    } while ((paramString == null) || (paramString.length <= 0) || (!addNativeLibraryPath(QMApplicationContext.sharedInstance(), (File)localObject)));
    int j = paramString.length;
    while (i < j)
    {
      localObject = paramString[i].getName().replace(".so", "").substring(3);
      Log.i("SoLoader", "loadLibrary libName = " + (String)localObject);
      System.loadLibrary((String)localObject);
      i += 1;
    }
    return true;
  }
  
  public static boolean loadLibrary(@NonNull String paramString)
  {
    if (!paramString.endsWith(".so")) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    } while ((localFile == null) || (!localFile.exists()) || (!addNativeLibraryPath(QMApplicationContext.sharedInstance(), localFile.getParentFile())));
    paramString = paramString.replace(".so", "").substring(3);
    Log.i("SoLoader", "loadLibrary libName = " + paramString);
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.plugin.nativelib.SoLoader
 * JD-Core Version:    0.7.0.1
 */