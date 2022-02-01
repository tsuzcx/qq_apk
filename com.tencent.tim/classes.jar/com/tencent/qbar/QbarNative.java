package com.tencent.qbar;

import adfx;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QbarNative
{
  static boolean deg;
  static boolean deh;
  private int elL = -1;
  
  static
  {
    if (BaseApplicationImpl.getContext() != null) {}
    try
    {
      deh = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
      if (!deh) {
        QLog.e("QbarNative", 1, "Init load c++_shared fail, try system load.");
      }
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        System.loadLibrary("c++_shared");
        deh = true;
        if (BaseApplicationImpl.getContext() == null) {}
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          deg = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "QBarMod");
          if (!deg) {
            QLog.e("QbarNative", 1, "Init load QBarMod fail, try system load.");
          }
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            for (;;)
            {
              System.loadLibrary("QBarMod");
              deg = true;
              if (BaseApplicationImpl.getContext() != null) {
                adfx.a().Ga(deg);
              }
              return;
              localThrowable1 = localThrowable1;
              deh = false;
              QLog.w("QbarNative", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable1);
              continue;
              localThrowable2 = localThrowable2;
              deh = false;
              QLog.e("QbarNative", 1, "Init system load c++_shared fail:", localThrowable2);
            }
            localThrowable3 = localThrowable3;
            deg = false;
            QLog.e("QbarNative", 1, "loadSoByName, load libQBarMod.so failed:", localThrowable3);
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              QLog.e("QbarNative", 1, "Init system load QBarMod fail:", localThrowable4);
              deg = false;
            }
          }
        }
      }
    }
  }
  
  protected static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  protected static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  protected static native String GetVersion();
  
  public static String getVersion()
  {
    return GetVersion();
  }
  
  public static native int nativeArrayConvert(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  public static native int nativeCropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int nativeGrayRotateCropSub(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt7, int paramInt8);
  
  public static native int nativeTransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeTransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeYUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native int nativeYUVrotateLess(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeYuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  protected native int GetCodeDetectInfo(QBarCodeDetectInfo[] paramArrayOfQBarCodeDetectInfo, QBarPoint[] paramArrayOfQBarPoint, int paramInt);
  
  protected native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt, int paramInt);
  
  protected native int GetResults(QBarResultJNI[] paramArrayOfQBarResultJNI, int paramInt);
  
  protected native int GetZoomInfo(QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  protected native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarAiModelParam paramQbarAiModelParam);
  
  protected native int Release(int paramInt);
  
  protected native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  protected native int SetReaders(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public int a(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarAiModelParam paramQbarAiModelParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : init qbarId:" + this.elL + " hasSoLoad:" + deg);
    }
    if (!deg) {
      return -1;
    }
    if (this.elL < 0) {}
    for (;;)
    {
      try
      {
        if (paramQbarAiModelParam == null) {}
      }
      catch (Throwable paramString1)
      {
        this.elL = -1;
        QLog.e("QbarNative", 1, "QbarNative init hasSoLoad:" + deg + " error:" + paramString1.getMessage());
        continue;
      }
      try
      {
        this.elL = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
        if (this.elL >= 0) {
          break label201;
        }
        return -1;
      }
      finally {}
      paramQbarAiModelParam = new QbarAiModelParam();
      paramQbarAiModelParam.detect_model_bin_path_ = "";
      paramQbarAiModelParam.detect_model_param_path_ = "";
      paramQbarAiModelParam.superresolution_model_bin_path_ = "";
      paramQbarAiModelParam.superresolution_model_param_path_ = "";
      this.elL = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
    }
    label201:
    return 0;
  }
  
  public int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    List localList = aq(3);
    if ((localList != null) && (localList.size() > 0))
    {
      paramStringBuilder1.append(((a)localList.get(0)).typeName);
      paramStringBuilder2.append(((a)localList.get(0)).data);
      return 1;
    }
    return 0;
  }
  
  /* Error */
  public List<a> aq(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: ldc 49
    //   10: iconst_2
    //   11: new 144	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   18: ldc 215
    //   20: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 98	com/tencent/qbar/QbarNative:elL	I
    //   27: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 156
    //   32: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 67	com/tencent/qbar/QbarNative:deg	Z
    //   38: invokevirtual 159	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iload_1
    //   48: ifle +10 -> 58
    //   51: aload_0
    //   52: getfield 98	com/tencent/qbar/QbarNative:elL	I
    //   55: ifge +9 -> 64
    //   58: aconst_null
    //   59: astore 4
    //   61: aload 4
    //   63: areturn
    //   64: iload_1
    //   65: anewarray 12	com/tencent/qbar/QbarNative$QBarResultJNI
    //   68: astore 6
    //   70: iconst_0
    //   71: istore_1
    //   72: iload_1
    //   73: aload 6
    //   75: arraylength
    //   76: if_icmpge +61 -> 137
    //   79: aload 6
    //   81: iload_1
    //   82: new 12	com/tencent/qbar/QbarNative$QBarResultJNI
    //   85: dup
    //   86: invokespecial 216	com/tencent/qbar/QbarNative$QBarResultJNI:<init>	()V
    //   89: aastore
    //   90: aload 6
    //   92: iload_1
    //   93: aaload
    //   94: new 218	java/lang/String
    //   97: dup
    //   98: invokespecial 219	java/lang/String:<init>	()V
    //   101: putfield 222	com/tencent/qbar/QbarNative$QBarResultJNI:charset	Ljava/lang/String;
    //   104: aload 6
    //   106: iload_1
    //   107: aaload
    //   108: sipush 1024
    //   111: newarray byte
    //   113: putfield 225	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   116: aload 6
    //   118: iload_1
    //   119: aaload
    //   120: new 218	java/lang/String
    //   123: dup
    //   124: invokespecial 219	java/lang/String:<init>	()V
    //   127: putfield 226	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -62 -> 72
    //   137: aload_0
    //   138: monitorenter
    //   139: aload_0
    //   140: getfield 98	com/tencent/qbar/QbarNative:elL	I
    //   143: ifge +7 -> 150
    //   146: aload_0
    //   147: monitorexit
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: aload 6
    //   153: aload_0
    //   154: getfield 98	com/tencent/qbar/QbarNative:elL	I
    //   157: invokevirtual 228	com/tencent/qbar/QbarNative:GetResults	([Lcom/tencent/qbar/QbarNative$QBarResultJNI;I)I
    //   160: pop
    //   161: aload_0
    //   162: monitorexit
    //   163: new 230	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 231	java/util/ArrayList:<init>	()V
    //   170: astore 5
    //   172: aload 6
    //   174: arraylength
    //   175: istore_3
    //   176: iload_2
    //   177: istore_1
    //   178: aload 5
    //   180: astore 4
    //   182: iload_1
    //   183: iload_3
    //   184: if_icmpge -123 -> 61
    //   187: aload 6
    //   189: iload_1
    //   190: aaload
    //   191: astore 4
    //   193: aload 4
    //   195: getfield 226	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   198: ifnull +136 -> 334
    //   201: aload 4
    //   203: getfield 226	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   206: invokevirtual 234	java/lang/String:isEmpty	()Z
    //   209: ifne +125 -> 334
    //   212: new 21	com/tencent/qbar/QbarNative$a
    //   215: dup
    //   216: invokespecial 235	com/tencent/qbar/QbarNative$a:<init>	()V
    //   219: astore 7
    //   221: aload 7
    //   223: aload 4
    //   225: getfield 222	com/tencent/qbar/QbarNative$QBarResultJNI:charset	Ljava/lang/String;
    //   228: putfield 236	com/tencent/qbar/QbarNative$a:charset	Ljava/lang/String;
    //   231: aload 7
    //   233: aload 4
    //   235: getfield 239	com/tencent/qbar/QbarNative$QBarResultJNI:typeID	I
    //   238: putfield 240	com/tencent/qbar/QbarNative$a:typeID	I
    //   241: aload 7
    //   243: aload 4
    //   245: getfield 226	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   248: putfield 208	com/tencent/qbar/QbarNative$a:typeName	Ljava/lang/String;
    //   251: aload 7
    //   253: aload 4
    //   255: getfield 225	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   258: putfield 243	com/tencent/qbar/QbarNative$a:cW	[B
    //   261: aload 7
    //   263: getfield 236	com/tencent/qbar/QbarNative$a:charset	Ljava/lang/String;
    //   266: ldc 245
    //   268: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifeq +77 -> 348
    //   274: aload 7
    //   276: new 218	java/lang/String
    //   279: dup
    //   280: aload 4
    //   282: getfield 225	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   285: ldc 251
    //   287: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   290: putfield 211	com/tencent/qbar/QbarNative$a:data	Ljava/lang/String;
    //   293: aload 7
    //   295: getfield 211	com/tencent/qbar/QbarNative$a:data	Ljava/lang/String;
    //   298: invokestatic 259	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifeq +23 -> 324
    //   304: aload 7
    //   306: new 218	java/lang/String
    //   309: dup
    //   310: aload 4
    //   312: getfield 225	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   315: ldc_w 261
    //   318: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   321: putfield 211	com/tencent/qbar/QbarNative$a:data	Ljava/lang/String;
    //   324: aload 5
    //   326: aload 7
    //   328: invokeinterface 264 2 0
    //   333: pop
    //   334: iload_1
    //   335: iconst_1
    //   336: iadd
    //   337: istore_1
    //   338: goto -160 -> 178
    //   341: astore 4
    //   343: aload_0
    //   344: monitorexit
    //   345: aload 4
    //   347: athrow
    //   348: aload 7
    //   350: new 218	java/lang/String
    //   353: dup
    //   354: aload 4
    //   356: getfield 225	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   359: aload 7
    //   361: getfield 236	com/tencent/qbar/QbarNative$a:charset	Ljava/lang/String;
    //   364: invokespecial 254	java/lang/String:<init>	([BLjava/lang/String;)V
    //   367: putfield 211	com/tencent/qbar/QbarNative$a:data	Ljava/lang/String;
    //   370: goto -46 -> 324
    //   373: astore 4
    //   375: ldc 49
    //   377: iconst_1
    //   378: new 144	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 266
    //   388: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 4
    //   393: invokevirtual 267	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 57	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload 5
    //   407: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	QbarNative
    //   0	408	1	paramInt	int
    //   1	176	2	i	int
    //   175	10	3	j	int
    //   59	252	4	localObject1	Object
    //   341	14	4	localObject2	Object
    //   373	19	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   170	236	5	localArrayList	java.util.ArrayList
    //   68	120	6	arrayOfQBarResultJNI	QBarResultJNI[]
    //   219	141	7	locala	a
    // Exception table:
    //   from	to	target	type
    //   139	148	341	finally
    //   150	163	341	finally
    //   343	345	341	finally
    //   172	176	373	java/io/UnsupportedEncodingException
    //   193	324	373	java/io/UnsupportedEncodingException
    //   324	334	373	java/io/UnsupportedEncodingException
    //   348	370	373	java/io/UnsupportedEncodingException
  }
  
  public int b(int[] paramArrayOfInt, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : setReaders qbarId:" + this.elL + " hasSoLoad:" + deg);
    }
    try
    {
      if (this.elL < 0) {
        return -1;
      }
      paramInt = SetReaders(paramArrayOfInt, paramInt, this.elL);
      return paramInt;
    }
    finally {}
  }
  
  public int k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : scanImage qbarId:" + this.elL + " hasSoLoad:" + deg);
    }
    try
    {
      if (this.elL < 0) {
        return -1;
      }
      if (ScanImage(paramArrayOfByte, paramInt1, paramInt2, this.elL) < 0) {
        return -1;
      }
    }
    finally {}
    paramInt1 = i;
    if (aq(3).size() > 0) {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public int release()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : release qbarId:" + this.elL + " hasSoLoad:" + deg);
    }
    try
    {
      if (this.elL < 0) {
        return 0;
      }
      int i = Release(this.elL);
      this.elL = -1;
      return i;
    }
    finally {}
  }
  
  public static class QBarCodeDetectInfo
  {
    public float prob;
    public int readerId;
  }
  
  public static class QBarPoint
  {
    public int point_cnt;
    public float x0;
    public float x1;
    public float x2;
    public float x3;
    public float y0;
    public float y1;
    public float y2;
    public float y3;
  }
  
  public static class QBarResultJNI
  {
    public String charset;
    public byte[] data;
    public int typeID;
    public String typeName;
  }
  
  public static class QBarZoomInfo
  {
    public boolean isZoom;
    public float zoomFactor;
  }
  
  public static class QbarAiModelParam
  {
    public String detect_model_bin_path_;
    public String detect_model_param_path_;
    public String superresolution_model_bin_path_;
    public String superresolution_model_param_path_;
  }
  
  public static class a
  {
    public byte[] cW;
    public String charset;
    public String data;
    public int typeID;
    public String typeName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */