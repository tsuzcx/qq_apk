package com.tencent.mobileqq.mini.utils;

import android.os.Looper;
import android.os.Message;
import aojg;
import aoko;
import aooi;
import aook;
import aool;
import aqmr;
import aroi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class ReportLogUtil
{
  private static final String TAG = "ReportLogUtil";
  private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");
  
  public static void compressAndUploadLog(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ReportLogUtil.2(MiniLog.getMiniLogFolderPath(paramString), paramString));
  }
  
  public static void uploadLog(String paramString, UploadLogListener paramUploadLogListener)
  {
    if (!new File(paramString).exists()) {
      QLog.d("ReportLogUtil", 2, "file not exist. ");
    }
    aool localaool;
    do
    {
      return;
      localaool = new aool();
      localaool.cNy = true;
      localaool.dQ = paramString;
      localaool.dOM = 65;
      localaool.mUniseq = ((Math.random() * 1000000.0D));
      localaool.mPeerUin = "0";
      localaool.mSelfUin = String.valueOf(aroi.a().getUin());
      localaool.mFileType = 24;
      localaool.ckW = "miniAppUserLog";
      paramString = new Bdh_extinfo.CommFileExtReq();
      paramString.uint32_action_type.set(0);
      paramString.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + ".zip"));
      localaool.gb = paramString.toByteArray();
      paramString = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramString instanceof QQAppInterface));
    paramString = (QQAppInterface)paramString;
    paramUploadLogListener = new MiniAppTransHandler(ThreadManagerV2.getFileThreadLooper(), paramUploadLogListener);
    paramUploadLogListener.addFilter(new Class[] { aojg.class });
    paramString.a().a(paramUploadLogListener);
    paramString.a().a(localaool);
  }
  
  public static void uploadLogAndReport(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      QLog.e("ReportLogUtil", 1, "log not exist.");
      return;
    }
    long l = localFile.length();
    if (l <= 0L)
    {
      QLog.e("ReportLogUtil", 1, "log file size error: " + l);
      return;
    }
    uploadLog(paramString2, new ReportLogUtil.1(paramString2, paramString1, l));
  }
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 255	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 257	java/io/FileOutputStream
    //   7: dup
    //   8: new 61	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 263	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 265	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 266	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 11
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 272	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface 277 1 0
    //   46: ifeq +255 -> 301
    //   49: aload_0
    //   50: invokeinterface 281 1 0
    //   55: checkcast 283	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile
    //   58: astore 12
    //   60: aload 12
    //   62: invokevirtual 284	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:exists	()Z
    //   65: ifeq +312 -> 377
    //   68: aload 11
    //   70: new 286	java/util/zip/ZipEntry
    //   73: dup
    //   74: new 151	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   81: aload 12
    //   83: invokevirtual 289	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 12
    //   91: getfield 292	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:stuffix	Ljava/lang/String;
    //   94: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 293	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 297	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 11
    //   108: bipush 9
    //   110: invokevirtual 300	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: aload 12
    //   115: invokevirtual 301	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:length	()J
    //   118: lstore 9
    //   120: new 303	java/io/FileInputStream
    //   123: dup
    //   124: aload 12
    //   126: invokespecial 304	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 12
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 13
    //   138: lconst_0
    //   139: lstore 5
    //   141: aload 12
    //   143: aload 13
    //   145: iconst_0
    //   146: sipush 20480
    //   149: invokevirtual 308	java/io/FileInputStream:read	([BII)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpeq +39 -> 196
    //   160: aload 11
    //   162: aload 13
    //   164: iconst_0
    //   165: iload 4
    //   167: invokevirtual 312	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: iconst_1
    //   171: istore_3
    //   172: iconst_1
    //   173: istore_2
    //   174: lload 5
    //   176: iload 4
    //   178: i2l
    //   179: ladd
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore 5
    //   186: lload 7
    //   188: lload 9
    //   190: lcmp
    //   191: iflt -50 -> 141
    //   194: iload_3
    //   195: istore_2
    //   196: aload 12
    //   198: invokevirtual 315	java/io/FileInputStream:close	()V
    //   201: aload 11
    //   203: invokevirtual 318	java/util/zip/ZipOutputStream:flush	()V
    //   206: aload 11
    //   208: invokevirtual 321	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto +166 -> 377
    //   214: astore_0
    //   215: aload 12
    //   217: invokevirtual 315	java/io/FileInputStream:close	()V
    //   220: aload 11
    //   222: invokevirtual 318	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 11
    //   227: invokevirtual 321	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +30 -> 266
    //   239: ldc 14
    //   241: iconst_2
    //   242: new 151	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 326
    //   252: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload_0
    //   263: invokestatic 333	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_1
    //   267: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   270: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +12 -> 285
    //   276: ldc 14
    //   278: iconst_2
    //   279: ldc_w 336
    //   282: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +12 -> 300
    //   291: ldc 14
    //   293: iconst_2
    //   294: ldc_w 338
    //   297: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: return
    //   301: iload_2
    //   302: ifeq +8 -> 310
    //   305: aload 11
    //   307: invokevirtual 341	java/util/zip/ZipOutputStream:close	()V
    //   310: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +12 -> 325
    //   316: ldc 14
    //   318: iconst_2
    //   319: ldc_w 343
    //   322: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   329: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -47 -> 285
    //   335: ldc 14
    //   337: iconst_2
    //   338: ldc_w 336
    //   341: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto -59 -> 285
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   352: goto -67 -> 285
    //   355: astore_0
    //   356: aload_1
    //   357: invokevirtual 334	java/io/BufferedOutputStream:close	()V
    //   360: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +12 -> 375
    //   366: ldc 14
    //   368: iconst_2
    //   369: ldc_w 336
    //   372: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_0
    //   376: athrow
    //   377: goto -337 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramArrayList	java.util.ArrayList<com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.LogFile>
    //   0	380	1	paramString	String
    //   34	268	2	i	int
    //   171	24	3	j	int
    //   152	25	4	k	int
    //   139	46	5	l1	long
    //   180	7	7	l2	long
    //   118	71	9	l3	long
    //   31	275	11	localZipOutputStream	java.util.zip.ZipOutputStream
    //   58	158	12	localObject	Object
    //   136	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	138	214	finally
    //   141	154	214	finally
    //   160	170	214	finally
    //   35	40	232	java/io/IOException
    //   40	131	232	java/io/IOException
    //   196	211	232	java/io/IOException
    //   215	232	232	java/io/IOException
    //   305	310	232	java/io/IOException
    //   310	325	232	java/io/IOException
    //   0	33	347	java/io/IOException
    //   266	285	347	java/io/IOException
    //   325	344	347	java/io/IOException
    //   356	375	347	java/io/IOException
    //   375	377	347	java/io/IOException
    //   35	40	355	finally
    //   40	131	355	finally
    //   196	211	355	finally
    //   215	232	355	finally
    //   233	266	355	finally
    //   305	310	355	finally
    //   310	325	355	finally
  }
  
  public static class MiniAppTransHandler
    extends aook
  {
    ReportLogUtil.UploadLogListener uploadLogListener;
    
    public MiniAppTransHandler(Looper paramLooper, ReportLogUtil.UploadLogListener paramUploadLogListener)
    {
      super();
      this.uploadLogListener = paramUploadLogListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      aoko localaoko = (aoko)paramMessage.obj;
      if ((localaoko == null) || (localaoko.commandId != 65) || (localaoko.fileType != 24)) {}
      do
      {
        do
        {
          return;
          if ((paramMessage.what != 1007) && (paramMessage.what != 1003)) {
            break;
          }
          QLog.d("BDH", 2, "handleMessage  STATUS_UPLOAD_FINISHED");
          paramMessage = new Bdh_extinfo.UploadPicExtInfo();
          try
          {
            paramMessage.mergeFrom(localaoko.fL);
            paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
            if (this.uploadLogListener != null) {
              this.uploadLogListener.onSuccess(paramMessage);
            }
            QLog.d("BDH", 2, "handleMessage :" + paramMessage);
            return;
          }
          catch (Exception paramMessage)
          {
            QLog.d("BDH", 2, "handleMessage " + paramMessage);
          }
        } while (this.uploadLogListener == null);
        this.uploadLogListener.onFail(paramMessage.getMessage());
        return;
        if (paramMessage.what != 1005) {
          break;
        }
        QLog.d("BDH", 2, "handleMessage  STATUS_SEND_ERROR");
      } while (this.uploadLogListener == null);
      this.uploadLogListener.onFail("send error, code:1005");
      return;
      if (paramMessage.what == 1001)
      {
        QLog.d("BDH", 2, "handleMessage  STATUS_SEND_START");
        return;
      }
      QLog.d("BDH", 2, "handleMessage  unkown:" + paramMessage.what);
    }
  }
  
  public static abstract interface UploadLogListener
  {
    public abstract void onFail(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil
 * JD-Core Version:    0.7.0.1
 */