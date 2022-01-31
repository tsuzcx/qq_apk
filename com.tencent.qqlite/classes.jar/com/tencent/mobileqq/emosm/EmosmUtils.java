package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;

public class EmosmUtils
{
  public static final int CRYPTION_LENGH = 200;
  
  public static String bytes2eId(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt == 2) {
      return new String(paramArrayOfByte);
    }
    return PkgTools.b(paramArrayOfByte).toLowerCase();
  }
  
  public static int checkResultCode(int paramInt)
  {
    int i = 11001;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "default RESULT_CODE_OTHER_ERROR .");
      }
      paramInt = 11011;
    }
    label304:
    label358:
    label380:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return paramInt;
                              paramInt = 11002;
                            } while (!QLog.isColorLevel());
                            QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_UNKNOWN_HOST ");
                            return 11002;
                            paramInt = 11003;
                          } while (!QLog.isColorLevel());
                          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_UNUSABLE .");
                          return 11003;
                          paramInt = 11006;
                        } while (!QLog.isColorLevel());
                        QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_CONTENT_LOSSY .");
                        return 11006;
                        paramInt = 11007;
                      } while (!QLog.isColorLevel());
                      QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_USER_CANCEL .");
                      return 11007;
                      paramInt = 11004;
                    } while (!QLog.isColorLevel());
                    QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_CONNECT_TIMEOUT .");
                    return 11004;
                    paramInt = 11005;
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_SO_TIMEOUT .");
                  return 11005;
                  paramInt = 11012;
                } while (!QLog.isColorLevel());
                QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SOCKET_EXCEPTION_ERROR .");
                return 11012;
                if (!Utils.e()) {
                  break label304;
                }
                if (Utils.b() >= 1048576L) {
                  break;
                }
                paramInt = i;
              } while (!QLog.isColorLevel());
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD less 1mb .");
              return 11001;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_DOWNLOAD_OTHER_ERROR .");
              return 11011;
              if (!QLog.isColorLevel()) {
                break label464;
              }
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD_UNUSABLE .");
              return 11000;
              if (!Utils.e()) {
                break label380;
              }
              if (Utils.b() >= 1048576L) {
                break label358;
              }
              paramInt = i;
            } while (!QLog.isColorLevel());
            QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD less 1mb .");
            return 11001;
            paramInt = 11013;
          } while (!QLog.isColorLevel());
          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_LOCAL_FILESYSTEM_FAIL .");
          return 11013;
          if (!QLog.isColorLevel()) {
            break label464;
          }
          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD_UNUSABLE .");
          return 11000;
          paramInt = 11016;
        } while (!QLog.isColorLevel());
        QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_HTTP_RESPONSE_NO_OK .");
        return 11016;
        paramInt = 11014;
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_URL_STRING_ILLEGAL .");
      return 11014;
      paramInt = 11021;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_IS_HTML .");
    return 11021;
    label464:
    return 11000;
  }
  
  public static void decryptFi(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    SecurityUtile.a(paramArrayOfByte, paramInt1, paramInt2, paramLong, 200);
  }
  
  public static byte[] decryptFi(byte[] paramArrayOfByte)
  {
    SecurityUtile.a(paramArrayOfByte, 0, paramArrayOfByte.length, 0L, 200);
    return paramArrayOfByte;
  }
  
  public static byte[] decryptTEA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte;
    if (!VersionUtils.b()) {
      arrayOfByte = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    do
    {
      return arrayOfByte;
      arrayOfByte = null;
    } while (0 != 0);
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] eId2Byte(String paramString, int paramInt)
  {
    Object localObject = null;
    if ((paramInt == 0) || (paramInt == 2))
    {
      int i = paramString.length() / 2;
      byte[] arrayOfByte = new byte[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= i) {
          break;
        }
        arrayOfByte[paramInt] = Integer.valueOf(paramString.substring(paramInt * 2, paramInt * 2 + 2), 16).byteValue();
        paramInt += 1;
      }
    }
    if (paramInt == 1) {
      localObject = paramString.getBytes();
    }
    return localObject;
  }
  
  public static byte[] encrytFi(byte[] paramArrayOfByte)
  {
    return SecurityUtile.b(paramArrayOfByte, 200);
  }
  
  public static Bitmap getCoverBitmap(int paramInt, String paramString)
  {
    paramString = getCoverPath(paramInt, paramString);
    if (new File(paramString).exists()) {
      try
      {
        paramString = BitmapFactory.decodeFile(paramString);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmosmUtils", 2, "getCoverBitmap OOM.");
        }
      }
    }
    return null;
  }
  
  public static String getCoverPath(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString));
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("color.png");
      continue;
      localStringBuilder.append("gray.png");
      continue;
      localStringBuilder.append("list.png");
    }
  }
  
  public static String getCoverUrl(int paramInt, String paramString)
  {
    int i;
    StringBuilder localStringBuilder;
    try
    {
      i = Integer.parseInt(paramString);
      if (i == -1) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = -1;
      }
      i %= 10;
      localStringBuilder = new StringBuilder();
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return insertMtype("VIP_emosm", localStringBuilder.toString());
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_color.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_gray.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/126x126.png");
    }
  }
  
  public static byte[] getDecryptFileData(String paramString)
  {
    paramString = getFileData(paramString);
    if (paramString != null) {
      return decryptFi(paramString);
    }
    return null;
  }
  
  public static String getEmosmJsonFile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString));
    localStringBuilder.append(paramString + ".jtmp");
    return localStringBuilder.toString();
  }
  
  public static String getEmosmJsonUrl(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if (i == -1) {
        return null;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        localException.printStackTrace();
        i = -1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/" + i % 10 + "/" + paramString + "_android.json");
      return insertMtype("VIP_emosm", localStringBuilder.toString());
    }
  }
  
  public static String getEmoticonAIOPreviewPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString1));
    localStringBuilder.append(paramString2 + "_aio.png");
    return localStringBuilder.toString();
  }
  
  public static String getEmoticonAIOPreviewUrl(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("http://i.gtimg.cn/club/item/parcel/item/" + paramString2.substring(0, 2) + "/" + paramString2 + "/200x200.png");
    return insertMtype("VIP_emosm", paramString1.toString());
  }
  
  public static String getEmoticonEncryptPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString1));
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String getEmoticonEncrytUrl(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("http://i.gtimg.cn/club/item/parcel/item/" + paramString2.substring(0, 2) + "/" + paramString2 + "/200_200");
    return insertMtype("VIP_emosm", paramString1.toString());
  }
  
  public static String getEmoticonPackageFolder(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.aN);
    localStringBuilder.append(paramString + File.separator);
    return localStringBuilder.toString();
  }
  
  public static String getEmoticonPreviewPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.aN);
    localStringBuilder.append(paramString1 + File.separator + paramString2 + "_thu.png");
    return localStringBuilder.toString();
  }
  
  public static String getEmoticonPreviewUrl(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("http://i.gtimg.cn/club/item/parcel/item/" + paramString2.substring(0, 2) + "/" + paramString2 + "/126x126.png");
    return insertMtype("VIP_emosm", paramString1.toString());
  }
  
  public static String getEmoticonSoundPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString1));
    localStringBuilder.append(paramString2 + ".amr");
    return localStringBuilder.toString();
  }
  
  public static String getEmoticonSoundUrl(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("http://i.gtimg.cn/club/item/parcel/item/" + paramString2.substring(0, 2) + "/" + paramString2 + "/ring.amr");
    return insertMtype("VIP_emosm", paramString1.toString());
  }
  
  /* Error */
  public static byte[] getFileData(String paramString)
  {
    // Byte code:
    //   0: new 142	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 148	java/io/File:exists	()Z
    //   11: ifeq +63 -> 74
    //   14: new 259	java/io/FileInputStream
    //   17: dup
    //   18: new 142	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 265	java/io/FileInputStream:available	()I
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 269	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 272	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 273	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 272	java/io/FileInputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull -12 -> 74
    //   89: aload_1
    //   90: invokevirtual 272	java/io/FileInputStream:close	()V
    //   93: goto -19 -> 74
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 272	java/io/FileInputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_0
    //   114: aload_2
    //   115: areturn
    //   116: astore_0
    //   117: goto -43 -> 74
    //   120: astore_0
    //   121: goto -10 -> 111
    //   124: astore_1
    //   125: goto -22 -> 103
    //   128: astore_2
    //   129: goto -50 -> 79
    //   132: astore_2
    //   133: goto -73 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   29	61	1	localFileInputStream	java.io.FileInputStream
    //   100	12	1	localObject1	Object
    //   124	1	1	localObject2	Object
    //   38	18	2	arrayOfByte	byte[]
    //   57	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	39	2	localIOException1	java.io.IOException
    //   128	1	2	localIOException2	java.io.IOException
    //   132	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	30	57	java/io/FileNotFoundException
    //   14	30	76	java/io/IOException
    //   89	93	96	java/io/IOException
    //   14	30	100	finally
    //   51	55	113	java/io/IOException
    //   70	74	116	java/io/IOException
    //   107	111	120	java/io/IOException
    //   32	39	124	finally
    //   41	47	124	finally
    //   62	66	124	finally
    //   81	85	124	finally
    //   32	39	128	java/io/IOException
    //   41	47	128	java/io/IOException
    //   32	39	132	java/io/FileNotFoundException
    //   41	47	132	java/io/FileNotFoundException
  }
  
  public static String getMagicFaceMaterialPackageUrl(String paramString, int paramInt)
  {
    int i;
    StringBuilder localStringBuilder;
    try
    {
      i = Integer.parseInt(paramString);
      if (i == -1) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = -1;
      }
      i %= 10;
      localStringBuilder = new StringBuilder();
      if (paramInt != 0) {
        break label89;
      }
    }
    localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/audio.zip");
    for (;;)
    {
      return insertMtype("VIP_emosm", localStringBuilder.toString());
      label89:
      if (1 == paramInt) {
        if ("sbig".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsbig.zip");
        } else if ("xbig".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidxbig.zip");
        } else if ("big".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidbig.zip");
        } else {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsmall.zip");
        }
      }
    }
  }
  
  public static String getMagicFaceZipPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString));
    localStringBuilder.append(paramString + ".zip");
    return localStringBuilder.toString();
  }
  
  public static String getMagicfaceFolderPath(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append(AppConstants.aN);
    paramString2.append(paramString1 + File.separator);
    return paramString2.toString();
  }
  
  public static String getQFaceGifPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEmoticonPackageFolder(paramString1));
    localStringBuilder.append(paramString2 + ".gif");
    return localStringBuilder.toString();
  }
  
  public static String getQFaceGifUrl(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://ugc.qpic.cn/q_face/0/");
    localStringBuilder.append(paramString1 + "_" + paramString2 + "_" + paramString3);
    localStringBuilder.append("/0");
    return insertMtype("VIP_emosm", localStringBuilder.toString());
  }
  
  public static String getQFaceMaterialFolderPath(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.aO);
    localStringBuilder.append(paramString + File.separator);
    if (paramBoolean) {
      localStringBuilder.append("sc_200" + File.separator);
    }
    return localStringBuilder.toString();
  }
  
  public static String getQFaceMaterialUrl(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if (i == -1) {
        return null;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        localException.printStackTrace();
        i = -1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/" + i % 10 + "/" + paramString + "/material.zip");
      return insertMtype("VIP_emosm", localStringBuilder.toString());
    }
  }
  
  public static String getQFaceMaterialZipPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQFaceMaterialFolderPath(paramString, false));
    localStringBuilder.append(paramString + ".zip");
    return localStringBuilder.toString();
  }
  
  public static String getQFaceThumbUrl(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://ugc.qpic.cn/q_face/0/");
    localStringBuilder.append(paramString1 + "_" + paramString2 + "_" + paramString3);
    localStringBuilder.append("/200");
    return insertMtype("VIP_emosm", localStringBuilder.toString());
  }
  
  public static String insertMtype(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static boolean isGifFile(String paramString)
  {
    paramString = new EmosmRandomAccessFile(paramString, "r");
    byte[] arrayOfByte = new byte[10];
    paramString.read(arrayOfByte);
    if ((arrayOfByte[0] != 71) || (arrayOfByte[1] != 73) || (arrayOfByte[2] != 70))
    {
      paramString.close();
      return false;
    }
    paramString.close();
    return true;
  }
  
  public static boolean isNumeral(String paramString)
  {
    try
    {
      Integer.parseInt(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static void printStackTraces(int paramInt)
  {
    if (paramInt <= 0) {}
    String str;
    do
    {
      return;
      str = "";
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = Math.min(paramInt, arrayOfStackTraceElement.length);
      paramInt = 2;
      while (paramInt < i)
      {
        Object localObject = arrayOfStackTraceElement[paramInt];
        localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName();
        str = str + " " + (String)localObject;
        paramInt += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.emoji.EmoDown", 4, "epId illegale,stacktrace:" + str);
  }
  
  public static int saveEmosm(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      i = 11017;
    }
    boolean bool;
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doing decryptTEA,srcData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = decryptTEA(paramArrayOfByte, paramString1.getBytes());
      if (paramArrayOfByte == null) {
        return 11017;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. decryptTEA,clearData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = encrytFi(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return 11018;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      bool = FileUtils.a(paramString2, paramArrayOfByte, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + bool + ",data.len=" + paramArrayOfByte.length + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
    } while (bool);
    return 11019;
  }
  
  public static boolean showNetEnable(Activity paramActivity)
  {
    boolean bool = NetworkUtil.e(paramActivity);
    if (!bool) {
      Toast.makeText(paramActivity, 2131362797, 0).show();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmUtils
 * JD-Core Version:    0.7.0.1
 */