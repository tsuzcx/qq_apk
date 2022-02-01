package com.tencent.YTFace.cluster;

import adfc;
import ahbj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import axcd;
import axce;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FaceCluster
{
  public static final int ERROR_INIT_TRACK_ERROR = -1001;
  public static final int ERROR_MODEL_NOT_EXIST = -1000;
  public static final int FACE_DETECT_FORMAT_BITMAP = 1;
  public static final int FACE_DETECT_FORMAT_PIC = 2;
  private static final String TAG = "FaceCluster";
  private static FaceCluster instance;
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  public static boolean useAssetSo;
  private long nativeFeaturePtr;
  private long nativeTrackPtr;
  
  private FaceCluster()
  {
    try
    {
      String str1 = adfc.jM("YTFaceExtFeature");
      String str2 = adfc.jM("YTFaceClusterJNI_V836");
      BaseApplicationImpl.sApplication.getSharedPreferences("StatisticCollector", 4).edit().putString("facefeature_ext_so_md5", str1).commit();
      QLog.d("FaceCluster", 1, "FaceCluster faceFeatureExtSoMD5 = " + str1 + " faceJniSoMD5 =  " + str2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FaceCluster", 1, "FaceCluster exception", localException);
    }
  }
  
  public static FaceCluster getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new FaceCluster();
      }
      if (!loadSoSuccess) {
        loadNativeLibrary();
      }
      FaceCluster localFaceCluster = instance;
      return localFaceCluster;
    }
    finally {}
  }
  
  /* Error */
  public static boolean loadNativeLibrary()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 114	adfc:aed	()Z
    //   12: istore 8
    //   14: iload 8
    //   16: ifne +9 -> 25
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload 6
    //   24: ireturn
    //   25: getstatic 116	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   28: ifeq +11 -> 39
    //   31: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   34: istore 6
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: putstatic 116	com/tencent/YTFace/cluster/FaceCluster:soLoaded	Z
    //   43: invokestatic 119	adfc:su	()Ljava/lang/String;
    //   46: invokestatic 123	adfc:f	(Ljava/lang/String;)B
    //   49: istore_0
    //   50: invokestatic 126	adfc:st	()Ljava/lang/String;
    //   53: invokestatic 123	adfc:f	(Ljava/lang/String;)B
    //   56: istore_1
    //   57: ldc 128
    //   59: invokestatic 131	adfc:g	(Ljava/lang/String;)B
    //   62: istore_2
    //   63: invokestatic 134	adfc:sv	()Ljava/lang/String;
    //   66: invokestatic 123	adfc:f	(Ljava/lang/String;)B
    //   69: istore_3
    //   70: ldc 34
    //   72: invokestatic 131	adfc:g	(Ljava/lang/String;)B
    //   75: istore 4
    //   77: ldc 42
    //   79: invokestatic 131	adfc:g	(Ljava/lang/String;)B
    //   82: istore 5
    //   84: iload 7
    //   86: istore 6
    //   88: iload_1
    //   89: ifne +40 -> 129
    //   92: iload 7
    //   94: istore 6
    //   96: iload_2
    //   97: ifne +32 -> 129
    //   100: iload 7
    //   102: istore 6
    //   104: iload 4
    //   106: ifne +23 -> 129
    //   109: iload 7
    //   111: istore 6
    //   113: iload_3
    //   114: ifne +15 -> 129
    //   117: iload 7
    //   119: istore 6
    //   121: iload 5
    //   123: ifne +6 -> 129
    //   126: iconst_1
    //   127: istore 6
    //   129: iload 6
    //   131: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   134: ldc 17
    //   136: iconst_1
    //   137: new 74	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   144: ldc 136
    //   146: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_1
    //   150: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 141
    //   155: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload_0
    //   159: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: ldc 143
    //   164: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload_2
    //   168: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc 145
    //   173: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_3
    //   177: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 147
    //   182: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload 4
    //   187: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: ldc 149
    //   192: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload 5
    //   197: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: getstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   209: istore 6
    //   211: goto -192 -> 19
    //   214: astore 9
    //   216: ldc 17
    //   218: iconst_1
    //   219: ldc 154
    //   221: aload 9
    //   223: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iconst_0
    //   227: putstatic 106	com/tencent/YTFace/cluster/FaceCluster:loadSoSuccess	Z
    //   230: goto -24 -> 206
    //   233: astore 9
    //   235: ldc 2
    //   237: monitorexit
    //   238: aload 9
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	110	0	i	int
    //   56	94	1	j	int
    //   62	106	2	k	int
    //   69	108	3	m	int
    //   75	111	4	n	int
    //   82	114	5	i1	int
    //   4	206	6	bool1	boolean
    //   1	117	7	bool2	boolean
    //   12	3	8	bool3	boolean
    //   214	8	9	localThrowable	java.lang.Throwable
    //   233	6	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	84	214	java/lang/Throwable
    //   129	206	214	java/lang/Throwable
    //   9	14	233	finally
    //   25	36	233	finally
    //   39	43	233	finally
    //   43	84	233	finally
    //   129	206	233	finally
    //   206	211	233	finally
    //   216	230	233	finally
  }
  
  public static final void printQLog(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public native float[] calcuFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3);
  
  public native float calcuSimilarity(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public boolean checkFaceTrackModelExistOrNot()
  {
    Object localObject1 = new FaceDetectInitializer().getModelInfos();
    boolean bool;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ModelInfo)((Iterator)localObject1).next();
          localObject2 = axce.a(axcd.c) + ((ModelInfo)localObject2).fileName;
          if (!ahbj.isFileExists((String)localObject2)) {
            if (QLog.isColorLevel())
            {
              QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot false,path = " + (String)localObject2);
              bool = false;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceCluster", 2, "checkFaceTrackModelExistOrNot result = " + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public native int[] clusterFaces(float[][] paramArrayOfFloat);
  
  public native FaceStatus[] detectFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int faceDetect(Object paramObject, int paramInt, FaceTarget paramFaceTarget);
  
  public native int faceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceTarget paramFaceTarget, boolean paramBoolean);
  
  public native float[] getFaceFeature(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, boolean paramBoolean);
  
  public native float[] getFaceFeature2(Object paramObject, int paramInt, float[] paramArrayOfFloat);
  
  public int init(String paramString1, String paramString2, String paramString3)
  {
    int j = -1000;
    if (QLog.isColorLevel()) {
      QLog.d("FaceCluster", 2, "init start,face_feature_model_path = " + paramString3);
    }
    int i;
    if (TextUtils.isEmpty(paramString3))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FaceCluster", 2, "init return1");
        i = j;
      }
    }
    do
    {
      for (;;)
      {
        return i;
        paramString1 = new File(paramString3);
        if ((!checkFaceTrackModelExistOrNot()) || (!paramString1.exists()))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("FaceCluster", 2, "init return2");
            return -1000;
          }
        }
        else
        {
          try
          {
            j = initTrackPro(axce.a(axcd.c));
            QLog.d("FaceCluster", 1, "init initTrackPro ret = " + j);
            if (j != 0)
            {
              i = j;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FaceCluster", 2, "init return3");
              return j;
            }
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            QLog.e("FaceCluster", 1, "Exception", paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("FaceCluster", 2, "init return4");
            }
            return -1001;
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            paramString1.printStackTrace();
            QLog.e("FaceCluster", 1, "UnsatisfiedLinkError", paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("FaceCluster", 2, "init return4");
            }
            return -1001;
          }
        }
      }
      j = initFaceExtFeature(paramString3);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("FaceCluster", 2, "init finish result = " + j);
    return j;
  }
  
  @Deprecated
  public native int initFaceExtFeature(String paramString);
  
  public native int initTrackPro(String paramString);
  
  public boolean isLoadSoSuccess()
  {
    return loadSoSuccess;
  }
  
  public native void release();
  
  public void releaseFaceStatusArray(FaceStatus[] paramArrayOfFaceStatus)
  {
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      int j = paramArrayOfFaceStatus.length;
      int i = 0;
      while (i < j)
      {
        FaceStatus localFaceStatus = paramArrayOfFaceStatus[i];
        if (localFaceStatus.nativeFaceAlignmentPtr != 0L) {
          releaseNativeFaceStatus(localFaceStatus);
        }
        i += 1;
      }
    }
  }
  
  public native int releaseNativeFaceStatus(FaceStatus paramFaceStatus);
  
  public native int trackSingleFace(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, boolean paramBoolean);
  
  public native int trackSingleFace2(byte[] paramArrayOfByte, int paramInt1, int paramInt2, FaceStatus paramFaceStatus, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.YTFace.cluster.FaceCluster
 * JD-Core Version:    0.7.0.1
 */