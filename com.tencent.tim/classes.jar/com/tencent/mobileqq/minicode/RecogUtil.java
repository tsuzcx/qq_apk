package com.tencent.mobileqq.minicode;

import acbn;
import adjv;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import anjn;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;

public class RecogUtil
{
  public static final int CLASS_FOR_MINICODE = 2;
  public static final int CLASS_FOR_QRCODE = 1;
  public static final int CLASS_FOR_WEIXINCODE = 3;
  public static boolean DEBUG = false;
  public static final int MAX_DETECT_ERROR_COUNT = 2;
  public static volatile boolean SAVE_DETECT_IMAGE = false;
  public static String SP_FILE_MINIRECOG = "sp_file_minirecog";
  public static String SP_KEY_DETECT_INIT_ERROR = "sp_key_detect_init_error_";
  public static final String TAG = "MiniRecog";
  private static boolean s_bHasSupportReported;
  private static Boolean s_isX86VM;
  
  static
  {
    if (DEBUG)
    {
      String str1 = getSoPath();
      String str2 = getModelPath();
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(str2);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      copyRes("libQMCF_qr.so", "so_debug/", str1);
      copyRes("libyuvutil.so", "so_debug/", str1);
      copyRes("libminicode.so", "so_debug/", str1);
      copyRes("qr_detection_model.bin", "model_debug/", str2);
      copyRes("qr_detection_model.txt", "model_debug/", str2);
      copyRes("qr_anchor.bin", "model_debug/", str2);
    }
  }
  
  public static void clearMiniScanError(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(SP_KEY_DETECT_INIT_ERROR);
    if (paramBoolean) {}
    for (String str = "qq.android.minidecode.so_v8.2.0";; str = "qq.android.minidetect.so_v8.2.0")
    {
      str = str;
      BaseApplicationImpl.sApplication.getSharedPreferences(SP_FILE_MINIRECOG, 4).edit().remove(str).apply();
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog", 2, String.format("clearMiniScanError bDecodeElseDetect=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return;
    }
  }
  
  /* Error */
  private static boolean copyLibrary(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: new 46	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 46	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_0
    //   28: invokevirtual 54	java/io/File:exists	()Z
    //   31: ifeq +8 -> 39
    //   34: aload_0
    //   35: invokevirtual 151	java/io/File:delete	()Z
    //   38: pop
    //   39: new 153	java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_1
    //   48: new 158	java/io/FileOutputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_0
    //   57: sipush 2048
    //   60: newarray byte
    //   62: astore 5
    //   64: aload_1
    //   65: aload 5
    //   67: invokevirtual 163	java/io/FileInputStream:read	([B)I
    //   70: istore_2
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpeq +57 -> 130
    //   76: aload_0
    //   77: aload 5
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 167	java/io/FileOutputStream:write	([BII)V
    //   84: goto -20 -> 64
    //   87: astore 6
    //   89: aload_0
    //   90: astore 5
    //   92: aload_1
    //   93: astore_0
    //   94: aload 5
    //   96: astore_1
    //   97: aload 6
    //   99: astore 5
    //   101: aload 5
    //   103: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   114: iload 4
    //   116: istore_3
    //   117: aload_0
    //   118: ifnull +10 -> 128
    //   121: aload_0
    //   122: invokevirtual 174	java/io/FileInputStream:close	()V
    //   125: iload 4
    //   127: istore_3
    //   128: iload_3
    //   129: ireturn
    //   130: aload_0
    //   131: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   134: iconst_1
    //   135: istore_3
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   144: aload_1
    //   145: ifnull -17 -> 128
    //   148: aload_1
    //   149: invokevirtual 174	java/io/FileInputStream:close	()V
    //   152: iconst_1
    //   153: ireturn
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   166: goto -22 -> 144
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   174: goto -60 -> 114
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_1
    //   187: aload 5
    //   189: ifnull +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 174	java/io/FileInputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   214: goto -17 -> 197
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 170	java/lang/Exception:printStackTrace	()V
    //   222: goto -17 -> 205
    //   225: astore_0
    //   226: goto -39 -> 187
    //   229: astore 6
    //   231: aload_0
    //   232: astore 5
    //   234: aload 6
    //   236: astore_0
    //   237: goto -50 -> 187
    //   240: astore 5
    //   242: aload_0
    //   243: astore 6
    //   245: aload 5
    //   247: astore_0
    //   248: aload_1
    //   249: astore 5
    //   251: aload 6
    //   253: astore_1
    //   254: goto -67 -> 187
    //   257: astore 5
    //   259: aconst_null
    //   260: astore_0
    //   261: aload 6
    //   263: astore_1
    //   264: goto -163 -> 101
    //   267: astore 5
    //   269: aload_1
    //   270: astore_0
    //   271: aload 6
    //   273: astore_1
    //   274: goto -173 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramString1	String
    //   0	277	1	paramString2	String
    //   70	11	2	i	int
    //   116	20	3	bool1	boolean
    //   7	119	4	bool2	boolean
    //   1	192	5	localObject1	Object
    //   207	3	5	localException1	java.lang.Exception
    //   232	1	5	str1	String
    //   240	6	5	localObject2	Object
    //   249	1	5	str2	String
    //   257	1	5	localException2	java.lang.Exception
    //   267	1	5	localException3	java.lang.Exception
    //   4	1	6	localObject3	Object
    //   87	11	6	localException4	java.lang.Exception
    //   229	6	6	localObject4	Object
    //   243	29	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   57	64	87	java/lang/Exception
    //   64	71	87	java/lang/Exception
    //   76	84	87	java/lang/Exception
    //   130	134	87	java/lang/Exception
    //   148	152	154	java/lang/Exception
    //   140	144	161	java/lang/Exception
    //   110	114	169	java/lang/Exception
    //   121	125	177	java/lang/Exception
    //   9	39	184	finally
    //   39	48	184	finally
    //   192	197	207	java/lang/Exception
    //   201	205	217	java/lang/Exception
    //   48	57	225	finally
    //   57	64	229	finally
    //   64	71	229	finally
    //   76	84	229	finally
    //   130	134	229	finally
    //   101	106	240	finally
    //   9	39	257	java/lang/Exception
    //   39	48	257	java/lang/Exception
    //   48	57	267	java/lang/Exception
  }
  
  public static void copyRes(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = acbn.bnJ + paramString2 + paramString1;
    File localFile = new File(paramString2);
    paramString1 = paramString3 + paramString1;
    if (localFile.exists()) {}
    for (boolean bool = copyLibrary(paramString1, paramString2);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog", 2, String.format("copy %s %b", new Object[] { paramString1, Boolean.valueOf(bool) }));
      }
      return;
    }
  }
  
  public static final String getKernalBinPath()
  {
    return getMiniRecogDir() + "kernal_path/";
  }
  
  public static String getMiniRecogDir()
  {
    if (BaseApplicationImpl.sApplication.getFilesDir() == null)
    {
      QLog.i("MiniRecog", 2, "getAppDir is null.");
      return "";
    }
    return BaseApplicationImpl.getContext().getFilesDir() + "/minirecog/";
  }
  
  public static int getMiniScanErrorCnt(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(SP_KEY_DETECT_INIT_ERROR);
    if (paramBoolean) {}
    for (String str = "qq.android.minidecode.so_v8.2.0";; str = "qq.android.minidetect.so_v8.2.0")
    {
      str = str;
      int i = BaseApplicationImpl.sApplication.getSharedPreferences(SP_FILE_MINIRECOG, 4).getInt(str, 0);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog", 2, String.format("getMiniScanErrorCnt errorCnt=%d bDecodeElseDetect=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
      }
      return i;
    }
  }
  
  public static final String getModelPath()
  {
    return getMiniRecogDir() + "model_debug/";
  }
  
  public static int getProcessId()
  {
    Object localObject = BaseApplicationImpl.processName.split(":");
    if (localObject.length > 1)
    {
      localObject = localObject[1];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      return 0;
    }
    if (((String)localObject).equalsIgnoreCase("peak")) {
      return 1;
    }
    if (((String)localObject).equalsIgnoreCase("tool")) {
      return 2;
    }
    if (((String)localObject).equalsIgnoreCase("web")) {
      return 3;
    }
    if (((String)localObject).equalsIgnoreCase("qzone")) {
      return 4;
    }
    return 5;
  }
  
  public static final String getResPath()
  {
    return acbn.bnJ;
  }
  
  public static final String getSoPath()
  {
    return getMiniRecogDir() + "so_debug/";
  }
  
  public static int getSupportDetectType()
  {
    int j = 1;
    if (getMiniScanErrorCnt(false) >= 2)
    {
      i = -2;
      return i;
    }
    int m = anjn.JJ();
    int k = anjn.JK();
    if (!s_bHasSupportReported)
    {
      adjv.ht(m, k);
      s_bHasSupportReported = true;
    }
    if (k > 0) {}
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog", 2, String.format("getSupportDetectType supportType[loose,strict]=[%d,%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m) }));
      }
      if (i == 0) {
        break label98;
      }
      i = j;
      if (k == 4) {
        break;
      }
      return 0;
    }
    label98:
    return -1;
  }
  
  public static final String getTmpPath()
  {
    return acbn.bnJ + "tmp/";
  }
  
  public static boolean isX86VM()
  {
    boolean bool2;
    if (s_isX86VM == null)
    {
      bool2 = FlatBuffersParser.yl();
      if (!bool2) {
        break label179;
      }
    }
    label179:
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.os.SystemProperties");
        if (((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { new String("ro.kernel.qemu"), new Integer(0) })).intValue() == 1) {
          if (!"tencent".equals(Build.MANUFACTURER))
          {
            bool1 = "unknown".equals(Build.MANUFACTURER);
            if (!bool1) {}
          }
          else
          {
            bool1 = true;
            QLog.i("MiniRecog", 1, String.format("RecogUtil isX86 [%b,%b,%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Build.MANUFACTURER }));
            s_isX86VM = Boolean.valueOf(bool1);
            return s_isX86VM.booleanValue();
          }
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniRecog", 2, "RecogUtil.isX86()", localThrowable);
      }
    }
  }
  
  public static void jumpMiniCode(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("jumpMiniCode result=%s", new Object[] { paramString }));
    }
    MiniAppLauncher.launchAppByMiniCode(paramContext, paramString, 1048, null);
  }
  
  public static void markMiniScanError(boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append(SP_KEY_DETECT_INIT_ERROR);
    if (paramBoolean) {}
    for (String str = "qq.android.minidecode.so_v8.2.0";; str = "qq.android.minidetect.so_v8.2.0")
    {
      str = str;
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(SP_FILE_MINIRECOG, 4);
      int i = ((SharedPreferences)localObject).getInt(str, 0);
      ((SharedPreferences)localObject).edit().putInt(str, i + 1).apply();
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog", 2, String.format("markMiniScanError bDecodeElseDetect=%b old_errorCnt=%d new_errorCnt=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i + 1) }));
      }
      return;
    }
  }
  
  public static void scaleRect(Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, float paramFloat)
  {
    int j = 0;
    int n = paramRect1.centerX();
    int m = paramRect1.centerY();
    int k = paramRect1.width();
    int i = paramRect1.height();
    n -= (int)(k * 0.5F * paramFloat);
    int i1 = m - (int)(i * 0.5F * paramFloat);
    m = n + (int)(k * paramFloat);
    k = (int)(i * paramFloat) + i1;
    i = n;
    if (n < 0) {
      i = 0;
    }
    if (i1 < 0)
    {
      if (m <= paramInt1) {
        break label130;
      }
      label106:
      if (k <= paramInt2) {
        break label136;
      }
    }
    for (;;)
    {
      paramRect2.set(i, j, paramInt1, paramInt2);
      return;
      j = i1;
      break;
      label130:
      paramInt1 = m;
      break label106;
      label136:
      paramInt2 = k;
    }
  }
  
  public static void validBmpData(Bitmap paramBitmap, String paramString)
  {
    Utils.saveBitmapToFile(paramBitmap, getTmpPath() + paramString + ".png", Bitmap.CompressFormat.PNG, 100, false);
  }
  
  public static void validBmpData(int[] paramArrayOfInt, int paramInt1, int paramInt2, String paramString)
  {
    Utils.saveBitmapToFile(Bitmap.createBitmap(paramArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888), getTmpPath() + paramString + ".png", Bitmap.CompressFormat.PNG, 100, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.RecogUtil
 * JD-Core Version:    0.7.0.1
 */