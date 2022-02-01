package com.youtu.arsdk;

import adep;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import axcd;
import axce;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ARShell
{
  public static final int ERROR_LOST_TARGET = 3;
  public static final int ERROR_OK = 0;
  public static final int ERROR_TARGET_EMPTY = 4;
  public static final int ERROR_TARGET_RECOGNIZED = 1;
  public static final int ERROR_TARGET_TRACKED = 2;
  public static final int ERROR_TRAINING_DATA_LOAD_FAILED = -1001;
  private static volatile boolean loadARCoreSoSuccess;
  private static volatile boolean loadARFeatureSoSuccess;
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  
  public static boolean getARCoreSoHasLoadSuccess()
  {
    return loadARCoreSoSuccess;
  }
  
  public static String getCommonSoFilename()
  {
    return axce.a(axcd.c) + "libYTCommon.so";
  }
  
  public static native int getMarkerCount();
  
  public static native int getMarkerInfo(long paramLong, ARPatternInfo paramARPatternInfo);
  
  public static native void getPatternSizeById(int paramInt, float[] paramArrayOfFloat);
  
  public static native void getProjectionMatrix(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public static native String getSDKVersion();
  
  public static boolean loadARFeatureNativeLibrary()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary");
        }
        boolean bool3 = loadARFeatureSoSuccess;
        if (bool3) {
          return bool1;
        }
        if (!adep.adM())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "native so is not exist!");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary soLoaded=" + soLoaded);
          }
          loadARFeatureSoSuccess = true;
          try
          {
            int i = adep.cF("libARFeature");
            if (i != 0) {
              break label219;
            }
            bool1 = bool2;
            loadARFeatureSoSuccess = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary ret1=" + i);
            }
          }
          catch (Throwable localThrowable)
          {
            loadARFeatureSoSuccess = false;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ARShell", 2, "loadARFeatureNativeLibrary", localThrowable);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary loadSoSuccess=" + loadARFeatureSoSuccess);
          }
          bool1 = loadARFeatureSoSuccess;
          continue;
        }
        bool1 = false;
      }
      finally {}
      continue;
      label219:
      bool1 = false;
    }
  }
  
  /* Error */
  public static boolean loadArCoreNativeLibrary()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 76
    //   13: iconst_2
    //   14: new 35	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   21: ldc 119
    //   23: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   29: invokevirtual 98	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +8 -> 51
    //   46: ldc 2
    //   48: monitorexit
    //   49: iload_1
    //   50: ireturn
    //   51: invokestatic 124	adgt:a	()Ladgv;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +14 -> 70
    //   59: iconst_0
    //   60: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   63: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   66: istore_1
    //   67: goto -21 -> 46
    //   70: aload_3
    //   71: invokestatic 127	adgt:a	(Ladgv;)Z
    //   74: ifeq +162 -> 236
    //   77: aload_3
    //   78: invokeinterface 133 1 0
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +13 -> 100
    //   90: aload 4
    //   92: invokeinterface 138 1 0
    //   97: ifne +14 -> 111
    //   100: iconst_0
    //   101: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   104: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   107: istore_1
    //   108: goto -62 -> 46
    //   111: aload 4
    //   113: invokeinterface 142 1 0
    //   118: astore 4
    //   120: aload 4
    //   122: invokeinterface 147 1 0
    //   127: ifeq +98 -> 225
    //   130: aload 4
    //   132: invokeinterface 151 1 0
    //   137: checkcast 153	java/lang/String
    //   140: astore 5
    //   142: aload_3
    //   143: aload 5
    //   145: invokestatic 156	adgt:a	(Ladgv;Ljava/lang/String;)I
    //   148: istore_0
    //   149: iload_0
    //   150: ifeq -30 -> 120
    //   153: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +38 -> 194
    //   159: ldc 76
    //   161: iconst_2
    //   162: new 35	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   169: ldc 158
    //   171: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_0
    //   175: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 160
    //   180: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   198: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   201: istore_1
    //   202: goto -156 -> 46
    //   205: astore_3
    //   206: iconst_0
    //   207: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   210: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +12 -> 225
    //   216: ldc 76
    //   218: iconst_2
    //   219: ldc 161
    //   221: aload_3
    //   222: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: iconst_1
    //   226: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   229: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   232: istore_1
    //   233: goto -187 -> 46
    //   236: iconst_0
    //   237: putstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   240: getstatic 31	com/youtu/arsdk/ARShell:loadARCoreSoSuccess	Z
    //   243: istore_1
    //   244: goto -198 -> 46
    //   247: astore_3
    //   248: ldc 2
    //   250: monitorexit
    //   251: aload_3
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   148	27	0	i	int
    //   1	243	1	bool1	boolean
    //   41	2	2	bool2	boolean
    //   54	89	3	localadgv	adgv
    //   205	17	3	localThrowable	Throwable
    //   247	5	3	localObject1	Object
    //   83	48	4	localObject2	Object
    //   140	44	5	str	String
    // Exception table:
    //   from	to	target	type
    //   111	120	205	java/lang/Throwable
    //   120	149	205	java/lang/Throwable
    //   153	194	205	java/lang/Throwable
    //   194	202	205	java/lang/Throwable
    //   5	38	247	finally
    //   38	42	247	finally
    //   51	55	247	finally
    //   59	67	247	finally
    //   70	85	247	finally
    //   90	100	247	finally
    //   100	108	247	finally
    //   111	120	247	finally
    //   120	149	247	finally
    //   153	194	247	finally
    //   194	202	247	finally
    //   206	225	247	finally
    //   225	233	247	finally
    //   236	244	247	finally
  }
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: invokestatic 166	com/youtu/arsdk/ARShell:getCommonSoFilename	()Ljava/lang/String;
    //   10: astore_3
    //   11: ldc 168
    //   13: invokestatic 174	adey:kQ	(Ljava/lang/String;)Z
    //   16: ifeq +24 -> 40
    //   19: aload_3
    //   20: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +17 -> 40
    //   26: new 182	java/io/File
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: invokevirtual 188	java/io/File:exists	()Z
    //   37: ifne +26 -> 63
    //   40: iload_2
    //   41: istore_1
    //   42: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +13 -> 58
    //   48: ldc 76
    //   50: iconst_2
    //   51: ldc 190
    //   53: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload_2
    //   57: istore_1
    //   58: ldc 2
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +30 -> 96
    //   69: ldc 76
    //   71: iconst_2
    //   72: new 35	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   79: ldc 192
    //   81: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 95	com/youtu/arsdk/ARShell:soLoaded	Z
    //   87: invokevirtual 98	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   90: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: iconst_1
    //   97: putstatic 95	com/youtu/arsdk/ARShell:soLoaded	Z
    //   100: aload_3
    //   101: invokestatic 197	java/lang/System:load	(Ljava/lang/String;)V
    //   104: ldc 168
    //   106: invokestatic 198	adey:cF	(Ljava/lang/String;)I
    //   109: istore_0
    //   110: iload_0
    //   111: ifne +5 -> 116
    //   114: iconst_1
    //   115: istore_1
    //   116: iload_1
    //   117: putstatic 200	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   120: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +28 -> 151
    //   126: ldc 76
    //   128: iconst_2
    //   129: new 35	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   136: ldc 202
    //   138: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_0
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +30 -> 184
    //   157: ldc 76
    //   159: iconst_2
    //   160: new 35	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   167: ldc 204
    //   169: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: getstatic 200	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   175: invokevirtual 98	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   178: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: getstatic 200	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   187: istore_1
    //   188: goto -130 -> 58
    //   191: astore_3
    //   192: iconst_0
    //   193: putstatic 200	com/youtu/arsdk/ARShell:loadSoSuccess	Z
    //   196: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -48 -> 151
    //   202: ldc 76
    //   204: iconst_2
    //   205: ldc 205
    //   207: aload_3
    //   208: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto -60 -> 151
    //   214: astore_3
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_3
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   109	33	0	i	int
    //   1	187	1	bool1	boolean
    //   3	54	2	bool2	boolean
    //   10	91	3	str	String
    //   191	17	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   214	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	110	191	java/lang/UnsatisfiedLinkError
    //   116	151	191	java/lang/UnsatisfiedLinkError
    //   7	40	214	finally
    //   42	56	214	finally
    //   63	96	214	finally
    //   96	100	214	finally
    //   100	110	214	finally
    //   116	151	214	finally
    //   151	184	214	finally
    //   184	188	214	finally
    //   192	211	214	finally
  }
  
  private static boolean loadSo()
  {
    soLoaded = true;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Object localObject2;
    Object localObject1;
    String str;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject2 = localBaseApplicationImpl.getApplicationInfo().nativeLibraryDir + "/";
      localObject1 = (String)localObject2 + "libAlphaAR.so";
      str = localBaseApplicationImpl.getFilesDir() + "libAlphaAR.so";
      if (!new File((String)localObject1).exists()) {
        break label287;
      }
    }
    for (;;)
    {
      label102:
      localObject2 = (String)localObject2 + "libYTCommon.so";
      str = localBaseApplicationImpl.getFilesDir() + "libYTCommon.so";
      if (new File((String)localObject2).exists()) {}
      for (;;)
      {
        if ((!((String)localObject1).equals("")) && (!((String)localObject2).equals("")))
        {
          try
          {
            System.load((String)localObject2);
            System.load((String)localObject1);
            QLog.i("ARShell", 1, "load " + (String)localObject1 + " successfully!");
            QLog.i("ARShell", 1, "load " + (String)localObject2 + " successfully!");
            loadSoSuccess = true;
            boolean bool = loadSoSuccess;
            return bool;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            label287:
            QLog.i("ARShell", 1, "load " + (String)localObject1 + " failed!" + localUnsatisfiedLinkError.getMessage());
            QLog.i("ARShell", 1, "load " + (String)localObject2 + " failed!" + localUnsatisfiedLinkError.getMessage());
          }
          localObject2 = localBaseApplicationImpl.getApplicationInfo().dataDir + "/lib/";
          break;
          if (!new File(str).exists()) {
            break label478;
          }
          localObject1 = str;
          break label102;
          if (!new File(str).exists()) {
            break label472;
          }
          localObject2 = str;
          continue;
        }
        QLog.i("ARShell", 1, "load " + (String)localObject1 + " failed!");
        QLog.i("ARShell", 1, "load " + (String)localObject2 + " failed!");
        loadSoSuccess = false;
        return loadSoSuccess;
        label472:
        localObject2 = "";
      }
      label478:
      localObject1 = "";
    }
  }
  
  public static native int nativeAddMarker(String paramString1, String paramString2);
  
  public static native int nativeAddMarkers(String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public static native boolean nativeCreate(Context paramContext);
  
  public static native boolean nativeDestroy();
  
  public static native long[] nativeGetMarkerIndice();
  
  public static native int nativeGetScore(byte[] paramArrayOfByte);
  
  public static native int nativeInitialize(AROption paramAROption);
  
  public static native int nativeRecognize(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native boolean nativeStart();
  
  public static native boolean nativeStop();
  
  public static native int nativeTrack(byte[] paramArrayOfByte, ARTargetInfo[] paramArrayOfARTargetInfo);
  
  public static native int removeAllMarkers();
  
  public static native int removeMarker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.youtu.arsdk.ARShell
 * JD-Core Version:    0.7.0.1
 */