import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageProc;
import com.tencent.mobileqq.ar.arengine.ARCloudPretreatmentManager.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class adhm
{
  public static int cGb;
  public static int cGc = -1;
  private String bsR = "";
  private int cGa;
  private byte[] dm;
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte, YuvImage paramYuvImage)
  {
    // Byte code:
    //   0: new 37	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: new 37	java/io/File
    //   13: dup
    //   14: new 42	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   21: aload_1
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload 5
    //   38: invokevirtual 55	java/io/File:exists	()Z
    //   41: ifne +9 -> 50
    //   44: aload 5
    //   46: invokevirtual 58	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 55	java/io/File:exists	()Z
    //   54: ifne +8 -> 62
    //   57: aload_1
    //   58: invokevirtual 61	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: new 63	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore_2
    //   71: aload_3
    //   72: ifnull +33 -> 105
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 70	java/io/FileOutputStream:write	([B)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: invokevirtual 73	java/io/FileOutputStream:flush	()V
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   102: goto -40 -> 62
    //   105: aload 4
    //   107: ifnull -25 -> 82
    //   110: aload_2
    //   111: astore_1
    //   112: aload 4
    //   114: new 81	android/graphics/Rect
    //   117: dup
    //   118: iconst_0
    //   119: iconst_0
    //   120: aload 4
    //   122: invokevirtual 87	android/graphics/YuvImage:getWidth	()I
    //   125: aload 4
    //   127: invokevirtual 90	android/graphics/YuvImage:getHeight	()I
    //   130: invokespecial 93	android/graphics/Rect:<init>	(IIII)V
    //   133: bipush 50
    //   135: aload_2
    //   136: invokevirtual 97	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   139: pop
    //   140: goto -58 -> 82
    //   143: astore_3
    //   144: aload_2
    //   145: astore_1
    //   146: aload_3
    //   147: invokevirtual 98	java/io/FileNotFoundException:printStackTrace	()V
    //   150: aload_2
    //   151: ifnull -55 -> 96
    //   154: aload_2
    //   155: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   164: return
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   170: return
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_2
    //   174: aload_2
    //   175: astore_1
    //   176: aload_3
    //   177: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   180: aload_2
    //   181: ifnull -85 -> 96
    //   184: aload_2
    //   185: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   188: return
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   194: return
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   213: goto -7 -> 206
    //   216: astore_2
    //   217: goto -19 -> 198
    //   220: astore_3
    //   221: goto -47 -> 174
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_2
    //   227: goto -83 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	adhm
    //   0	230	1	paramString1	String
    //   0	230	2	paramString2	String
    //   0	230	3	paramArrayOfByte	byte[]
    //   0	230	4	paramYuvImage	YuvImage
    //   8	37	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	62	97	java/io/IOException
    //   77	82	143	java/io/FileNotFoundException
    //   84	88	143	java/io/FileNotFoundException
    //   112	140	143	java/io/FileNotFoundException
    //   154	158	159	java/io/IOException
    //   92	96	165	java/io/IOException
    //   62	71	171	java/io/IOException
    //   184	188	189	java/io/IOException
    //   62	71	195	finally
    //   202	206	208	java/io/IOException
    //   77	82	216	finally
    //   84	88	216	finally
    //   112	140	216	finally
    //   146	150	216	finally
    //   176	180	216	finally
    //   77	82	220	java/io/IOException
    //   84	88	220	java/io/IOException
    //   112	140	220	java/io/IOException
    //   62	71	224	java/io/FileNotFoundException
  }
  
  private void cRO()
  {
    QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "delete backup file.");
    Object localObject1 = new File(this.bsR);
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.exists()) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  private String hd()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    return "FilteredImg" + str + ".jpg";
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ARRecognition paramARRecognition, adhm.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace]pretreatFaceRecogInfo,  FaceScanModelsLoader.hasFaceModelInit =  " + adfb.bMx);
    }
    if (adfb.isReleasing)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return for releasing");
      return;
    }
    if (!adfb.bMx)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return1 FaceModel not init!");
      return;
    }
    adhn localadhn = new adhn();
    localadhn.timeout = ((int)paramARRecognition.RZ);
    FaceCluster localFaceCluster = FaceCluster.getInstance();
    long l1 = SystemClock.uptimeMillis();
    if (!adfb.bMx)
    {
      QLog.d("AREngine_ARCloudPretreatmentManagert", 1, "pretreatFaceRecogInfo,return2 FaceModel not init!");
      return;
    }
    paramARRecognition = localFaceCluster.detectFace(paramArrayOfByte, paramInt1, paramInt2, 0);
    if (adie.handler != null)
    {
      if (adie.handler.hasMessages(4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] pretreatFaceRecogInfo, remove pending task");
        }
        adie.handler.removeMessages(4);
      }
      paramArrayOfByte = Message.obtain(adie.handler, new ARCloudPretreatmentManager.1(this, paramARRecognition, localFaceCluster, paramArrayOfByte, paramInt1, paramInt2));
      paramArrayOfByte.what = 4;
      if (adie.handler != null) {
        adie.handler.sendMessage(paramArrayOfByte);
      }
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "[ScanStarFace][TimeCost]pretreatFaceRecogInfo  cost = " + (l2 - l1) + ", faceStatus = " + Arrays.toString(paramARRecognition));
      }
      if ((paramARRecognition != null) && (paramARRecognition.length > 0))
      {
        localadhn.b = paramARRecognition;
        anot.a(null, "dc00898", "", "", "0X800834C", "0X800834C", 0, 0, "", "", "", "");
      }
      parama.a(localadhn);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudPretreatmentManagert", 2, "pretreatFaceRecogInfo ,handler is null");
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, ARRecognition paramARRecognition, adhm.a parama)
  {
    paramArrayOfByte = new adhw();
    paramArrayOfByte.timeout = ((int)paramARRecognition.RZ);
    parama.a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList, adhm.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "[DEBUG_SCAN_yt_face] Preprocess start");
    }
    int j;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (paramInt1 <= paramInt2) {
        break label260;
      }
      j = 480;
      i = (paramInt1 * 480 / paramInt2 + 3) / 4 * 4;
    }
    for (;;)
    {
      int k = 90;
      if (anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
        k = 270;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "pretreatAllType  degree = " + k);
      }
      int m = (int)(j * i * 1.5D);
      if ((this.dm == null) || (this.cGa != m))
      {
        this.dm = new byte[m];
        this.cGa = m;
      }
      if (ARCloudImageProc.nativeScaleAndRotate(this.dm, i, j, k, paramArrayOfByte, paramInt1, paramInt2) != 0) {
        break;
      }
      QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "Preprocess failed. ScaleAndRotate failed. scaledWidth = " + i + ", scaledHeight = " + j + ", degree = " + k + ", srcWidth = " + paramInt1 + ", srcHeight = " + paramInt2);
      parama.a(cGc, null, -1L);
      return;
      label260:
      i = 480;
      j = (paramInt2 * 480 / paramInt1 + 3) / 4 * 4;
    }
    paramArrayOfByte = paramArrayList.iterator();
    long l1 = -1L;
    if (paramArrayOfByte.hasNext())
    {
      paramArrayList = (ARRecognition)paramArrayOfByte.next();
      long l3 = 1 << (int)paramArrayList.type;
      if (l3 == 1L) {
        a(this.dm, paramArrayList, parama);
      }
      for (;;)
      {
        break;
        if (l3 == 2L)
        {
          b(this.dm, paramArrayList, parama);
        }
        else if (l3 == 4L)
        {
          l1 = System.currentTimeMillis();
          a(this.dm, j, i, paramArrayList, parama);
          l1 = System.currentTimeMillis() - l1;
        }
        else if (l3 == 64L)
        {
          d(this.dm, paramArrayList, parama);
        }
        else if (l3 == 128L)
        {
          c(this.dm, paramArrayList, parama);
        }
        else if (l3 == 2048L)
        {
          e(this.dm, paramArrayList, parama);
        }
      }
    }
    paramArrayList = new YuvImage(this.dm, paramInt3, j, i, null);
    paramArrayOfByte = hd();
    paramArrayOfByte = new adhm.b(this.bsR, paramArrayOfByte, this.dm);
    a(paramArrayOfByte.filePath, paramArrayOfByte.fileName, null, paramArrayList);
    l2 = System.currentTimeMillis() - l2;
    QLog.i("AREngine_ARCloudPretreatmentManagert", 1, "[DEBUG_SCAN_yt_face] Preprocess end. save img: " + paramArrayOfByte.filePath + paramArrayOfByte.fileName + ",preProcessCost = " + l2 + ",pretreatFaceRecogCost = " + l1);
    paramArrayList = new adhu();
    paramArrayList.fileName = (paramArrayOfByte.filePath + paramArrayOfByte.fileName);
    paramArrayList.fileFormat = 0;
    adic localadic = adic.a();
    localadic.Te = l1;
    localadic.Td = l2;
    l1 = paramArrayOfByte.fileData.length / 8192;
    parama.a(cGb, paramArrayList, l1);
  }
  
  public void b(byte[] paramArrayOfByte, ARRecognition paramARRecognition, adhm.a parama)
  {
    paramArrayOfByte = new adho();
    paramArrayOfByte.timeout = ((int)paramARRecognition.RZ);
    parama.a(paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, ARRecognition paramARRecognition, adhm.a parama)
  {
    paramArrayOfByte = new adho();
    paramArrayOfByte.timeout = ((int)paramARRecognition.RZ);
    parama.b(paramArrayOfByte);
  }
  
  public void d(byte[] paramArrayOfByte, ARRecognition paramARRecognition, adhm.a parama)
  {
    paramArrayOfByte = new adhp();
    paramArrayOfByte.timeout = ((int)paramARRecognition.RZ);
    parama.a(paramArrayOfByte);
  }
  
  public void e(byte[] paramArrayOfByte, ARRecognition paramARRecognition, adhm.a parama)
  {
    paramArrayOfByte = new adhq();
    paramArrayOfByte.timeout = ((int)paramARRecognition.RZ);
    parama.a(paramArrayOfByte);
  }
  
  public void init()
  {
    this.bsR = (aden.sl() + "ar_cloud_img/");
    ARCloudImageProc.nativeInit();
    if (QLog.isColorLevel()) {
      QLog.i("AREngine_ARCloudPretreatmentManagert", 2, "ARCloudPretreatmentManager mImgDir = " + this.bsR);
    }
  }
  
  public void uninit()
  {
    cRO();
    ARCloudImageProc.nativeUninit();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, adhu paramadhu, long paramLong);
    
    public abstract void a(adhn paramadhn);
    
    public abstract void a(adho paramadho);
    
    public abstract void a(adhp paramadhp);
    
    public abstract void a(adhq paramadhq);
    
    public abstract void a(adhw paramadhw);
    
    public abstract void b(adho paramadho);
  }
  
  public static class b
  {
    public byte[] fileData;
    public String fileName;
    public String filePath;
    
    public b(String paramString1, String paramString2, byte[] paramArrayOfByte)
    {
      this.filePath = paramString1;
      this.fileName = paramString2;
      this.fileData = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhm
 * JD-Core Version:    0.7.0.1
 */