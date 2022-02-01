package dov.com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.AsyncTask;
import aqhq;
import azat;
import azat.a;
import azau;
import azav;
import azaw;
import azax;
import azba;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.util.SVMp4Merge;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jjd;

@TargetApi(18)
public class SVHwEncoder
{
  private static AtomicInteger bP = new AtomicInteger(0);
  private static boolean cGp;
  private ArrayList<a> AC = new ArrayList();
  private ArrayList<a> AD = new ArrayList();
  private ArrayList<a> AE = new ArrayList();
  private azav jdField_a_of_type_Azav;
  private HwEncode jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode;
  private volatile int bjA = 480000;
  private double bo;
  private double bp;
  private boolean cGl;
  private volatile boolean cGm;
  private volatile boolean cGn;
  private volatile boolean cGo;
  private String cea;
  public int dGn = 21;
  private int dGo = 44100;
  private int dGp = 1;
  private int dGq = 128000;
  private int dGr = 2;
  private int dGs = -1;
  private Object eQ = new Object();
  private int gP;
  private int mHeight;
  private int mOrientationDegree;
  private int mThumbWidth;
  private int mTotalFrames = -1;
  private volatile float mVideoFps = 30.0F;
  private int mWidth;
  private int[] nA = new int[4];
  
  private native boolean adjustDstresolution(int[] paramArrayOfInt);
  
  public void S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 8000) || (paramInt1 == 16000) || (paramInt1 == 44100)) {
      this.dGo = paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.dGp = paramInt2;
    }
    if ((paramInt3 == 64000) || (paramInt3 == 128000)) {
      this.dGq = paramInt3;
    }
    if ((paramInt4 == 1) || (paramInt4 == 2)) {
      this.dGr = paramInt4;
    }
  }
  
  a a(ArrayList<a> paramArrayList)
  {
    a locala = null;
    try
    {
      if (paramArrayList.size() > 0) {
        locala = (a)paramArrayList.get(0);
      }
      return locala;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void a(azav paramazav, azau paramazau, boolean paramBoolean)
  {
    this.jdField_a_of_type_Azav = paramazav;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode = new HwEncode(this.cea, paramazav, paramazau, paramBoolean, 0);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.run();
  }
  
  /* Error */
  public void a(a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 135	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:cGm	Z
    //   6: ifne +63 -> 69
    //   9: iload_2
    //   10: ifeq +62 -> 72
    //   13: aload_0
    //   14: getfield 108	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AD	Ljava/util/ArrayList;
    //   17: ifnull +55 -> 72
    //   20: aload_0
    //   21: getfield 108	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AD	Ljava/util/ArrayList;
    //   24: aload_1
    //   25: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   28: pop
    //   29: aload_0
    //   30: ldc 187
    //   32: new 189	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   39: ldc 192
    //   41: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: getfield 199	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:finish	Z
    //   48: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: ldc 204
    //   53: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: getfield 206	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:size	I
    //   60: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 217	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:hq	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 110	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AE	Ljava/util/ArrayList;
    //   76: ifnull -7 -> 69
    //   79: aload_0
    //   80: getfield 110	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AE	Ljava/util/ArrayList;
    //   83: aload_1
    //   84: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_0
    //   89: ldc 219
    //   91: new 189	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   98: ldc 192
    //   100: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: getfield 199	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:finish	Z
    //   107: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: ldc 204
    //   112: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: getfield 206	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:size	I
    //   119: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 217	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:hq	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: goto -59 -> 69
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	SVHwEncoder
    //   0	136	1	parama	a
    //   0	136	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	131	finally
    //   13	69	131	finally
    //   72	128	131	finally
  }
  
  void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, String paramString, int paramInt)
  {
    if (paramByteBuffer == null) {
      hq(paramString, "Configdata buferData=null");
    }
    do
    {
      return;
      if (paramBufferInfo.size != 0) {
        hq(paramString, "Configdata size=" + paramBufferInfo.size);
      }
    } while (paramBufferInfo.size >= paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < paramBufferInfo.size)
    {
      paramByteBuffer.position(paramBufferInfo.offset + paramInt);
      localStringBuilder.append(paramByteBuffer.get()).append(',');
      paramInt += 1;
    }
    hq(paramString, "Configdata =" + localStringBuilder.toString());
  }
  
  boolean a(a parama)
  {
    boolean bool = false;
    if (this.AC.size() < 3) {
      synchronized (this.eQ)
      {
        if (this.AC.size() < 3)
        {
          this.AC.add(parama);
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public void aF(String paramString, int paramInt1, int paramInt2)
  {
    this.cea = paramString;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    dPO();
  }
  
  /* Error */
  public a b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_1
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 135	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:cGm	Z
    //   8: ifne +136 -> 144
    //   11: aload_1
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 106	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AC	Ljava/util/ArrayList;
    //   17: ifnull +127 -> 144
    //   20: aload_0
    //   21: getfield 106	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AC	Ljava/util/ArrayList;
    //   24: invokevirtual 161	java/util/ArrayList:size	()I
    //   27: ifle +199 -> 226
    //   30: aload_0
    //   31: getfield 101	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:eQ	Ljava/lang/Object;
    //   34: astore_2
    //   35: aload_2
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 106	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AC	Ljava/util/ArrayList;
    //   41: invokevirtual 161	java/util/ArrayList:size	()I
    //   44: ifle +177 -> 221
    //   47: aload_0
    //   48: getfield 106	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AC	Ljava/util/ArrayList;
    //   51: iconst_0
    //   52: invokevirtual 165	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   55: checkcast 21	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 106	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:AC	Ljava/util/ArrayList;
    //   63: iconst_0
    //   64: invokevirtual 256	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   67: pop
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_1
    //   71: ifnull +10 -> 81
    //   74: aload_1
    //   75: getfield 260	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:data	[B
    //   78: ifnonnull +117 -> 195
    //   81: aload_0
    //   82: getfield 133	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:mWidth	I
    //   85: aload_0
    //   86: getfield 137	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:mHeight	I
    //   89: imul
    //   90: iconst_3
    //   91: imul
    //   92: iconst_2
    //   93: idiv
    //   94: newarray byte
    //   96: astore_3
    //   97: new 21	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a
    //   100: dup
    //   101: invokespecial 261	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: aload_3
    //   107: putfield 260	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:data	[B
    //   110: aload_2
    //   111: ldc_w 262
    //   114: putfield 265	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:zI	F
    //   117: aload_2
    //   118: iconst_m1
    //   119: putfield 268	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$a:bitrate	I
    //   122: aload_2
    //   123: astore_1
    //   124: aload_1
    //   125: astore_2
    //   126: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +15 -> 144
    //   132: ldc_w 276
    //   135: iconst_2
    //   136: ldc_w 278
    //   139: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: astore_2
    //   152: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +14 -> 169
    //   158: ldc_w 276
    //   161: iconst_2
    //   162: ldc_w 283
    //   165: aload_2
    //   166: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: aload_0
    //   170: getfield 170	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_Azav	Lazav;
    //   173: ifnull +15 -> 188
    //   176: aload_0
    //   177: getfield 170	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_Azav	Lazav;
    //   180: bipush 229
    //   182: iconst_0
    //   183: invokeinterface 292 3 0
    //   188: aload_0
    //   189: invokevirtual 295	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:dPQ	()V
    //   192: goto -68 -> 124
    //   195: invokestatic 274	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +13 -> 211
    //   201: ldc_w 276
    //   204: iconst_2
    //   205: ldc_w 297
    //   208: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload_1
    //   212: areturn
    //   213: astore_3
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: astore_2
    //   218: goto -66 -> 152
    //   221: aconst_null
    //   222: astore_1
    //   223: goto -155 -> 68
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -158 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	SVHwEncoder
    //   1	142	1	localObject1	Object
    //   146	66	1	locala	a
    //   215	13	1	localObject2	Object
    //   3	145	2	localObject3	Object
    //   151	64	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   217	1	2	localObject4	Object
    //   96	11	3	arrayOfByte	byte[]
    //   213	4	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   37	68	146	finally
    //   68	70	146	finally
    //   147	149	146	finally
    //   81	105	151	java/lang/OutOfMemoryError
    //   105	122	213	java/lang/OutOfMemoryError
  }
  
  int d(List<MediaCodecInfo> paramList, String paramString)
  {
    if (paramList.size() <= 0) {
      return -1;
    }
    int i = 0;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int k;
    for (int j = -1;; j = k)
    {
      if (i < paramList.size())
      {
        localCodecCapabilities = azat.getCodecCapabilities((MediaCodecInfo)paramList.get(i), paramString);
        if (localCodecCapabilities != null) {}
      }
      else
      {
        return j;
      }
      hq("selectAudioCodec", "name=" + ((MediaCodecInfo)paramList.get(i)).getName());
      k = j;
      if (localCodecCapabilities.profileLevels != null)
      {
        if (localCodecCapabilities.profileLevels.length > 0) {
          break;
        }
        k = j;
      }
      i += 1;
    }
    int m = 0;
    for (;;)
    {
      k = j;
      if (m >= localCodecCapabilities.profileLevels.length) {
        break;
      }
      if (localCodecCapabilities.profileLevels[m].profile == 2)
      {
        k = i;
        break;
      }
      m += 1;
    }
  }
  
  void dPO()
  {
    this.nA[0] = this.mWidth;
    this.nA[1] = this.mHeight;
    this.nA[2] = 0;
    this.nA[3] = 0;
    try
    {
      bool = adjustDstresolution(this.nA);
      if (!bool)
      {
        this.mWidth -= this.mWidth % 16;
        this.mHeight -= this.mHeight % 16;
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        boolean bool = false;
      }
      this.mWidth = this.nA[2];
      this.mHeight = this.nA[3];
    }
  }
  
  public void dPQ()
  {
    this.cGm = true;
    this.cGn = true;
  }
  
  void dPR()
  {
    try
    {
      a locala = new a();
      locala.finish = true;
      locala.isVideo = true;
      locala.zI = 30.0F;
      locala.bitrate = 480000;
      this.AD.add(locala);
      locala = new a();
      locala.finish = true;
      locala.isVideo = false;
      this.AE.add(locala);
      hq("hw_video_write_frame", "addMediaEndFrame finish...");
      hq("hw_audio_write_frame", "addMediaEndFrame finish...");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void eT(ArrayList<a> paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 0) {
        paramArrayList.remove(0);
      }
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  void eU(ArrayList<a> paramArrayList)
  {
    try
    {
      paramArrayList.clear();
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  void hq(String paramString1, String paramString2)
  {
    if ((!cGp) && (QLog.isColorLevel())) {
      QLog.d("SVHwEncoder", 2, paramString1 + ":" + paramString2);
    }
  }
  
  public boolean o(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cGl = true;
    this.mTotalFrames = paramInt1;
    this.dGs = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 90)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 180)
        {
          paramInt1 = paramInt3;
          if (paramInt3 != 270) {
            paramInt1 = 0;
          }
        }
      }
    }
    this.mOrientationDegree = paramInt1;
    if (this.dGs <= 0)
    {
      this.dGs = 1000;
      return false;
    }
    if (this.mTotalFrames <= 0)
    {
      this.mTotalFrames = 1;
      return false;
    }
    return true;
  }
  
  int t(ArrayList<a> paramArrayList)
  {
    try
    {
      int i = paramArrayList.size();
      return i;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  class HwEncode
    implements azau, azav, Runnable
  {
    private azau jdField_a_of_type_Azau;
    azaw jdField_a_of_type_Azaw = new azaw();
    private azax jdField_a_of_type_Azax = new azax();
    private b jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b = new b();
    c jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c = new c();
    private d jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d = new d();
    private MediaMuxer jdField_b_of_type_AndroidMediaMediaMuxer;
    private azat jdField_b_of_type_Azat = new azat();
    private azav jdField_b_of_type_Azav;
    private String bYI;
    private azat c = new azat();
    private boolean cGA;
    private boolean cGB = true;
    private boolean cGC;
    private volatile boolean cGD;
    private boolean cGE;
    private volatile boolean cGF;
    private boolean cGq;
    private boolean cGr;
    private boolean cGs;
    private boolean cGt;
    private boolean cGu;
    private boolean cGv = true;
    private boolean cGw = true;
    private boolean cGx;
    private boolean cGy;
    private boolean cGz;
    private String ceb;
    private String cec;
    private String ced;
    private String cee;
    private String cef;
    private int dGA;
    private int dGB;
    private int dGC;
    private int dGD;
    private int dGE;
    private int dGt = 0;
    private int dGu;
    private int dGv;
    private int dGw;
    private int dGx;
    private int dGy;
    private int dGz;
    private Object eR = new Object();
    private MediaFormat i;
    private MediaFormat j;
    private MediaFormat k;
    private MediaFormat l;
    private ArrayList<String> mS = new ArrayList();
    private int outputAudioTrack = -1;
    private int outputVideoTrack = -1;
    
    HwEncode(String paramString, azav paramazav, azau paramazau, boolean paramBoolean, int paramInt)
    {
      this.cee = paramString;
      this.cef = nv(paramString);
      this.cGw = paramBoolean;
      this.cGv = true;
      this.jdField_b_of_type_Azav = paramazav;
      this.jdField_a_of_type_Azau = paramazau;
      dPU();
      if (!this.cGw)
      {
        this.cGs = true;
        this.cGu = true;
      }
      this.dGt = 0;
      this.dGE = paramInt;
      this.cGz = false;
      this.cGA = false;
      this.cGC = false;
      this.cGD = false;
      this.cGE = false;
      this.dGx = 0;
    }
    
    public void E(String paramString, int paramInt, long paramLong)
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.E(paramString, paramInt, paramLong);
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svMergeOK:path=" + paramString + " totalTime=" + paramInt + " mergeTime=" + paramLong + " mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    int F(boolean paramBoolean)
    {
      int m = 0;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
      try
      {
        bool = a(paramBoolean).start();
        if (paramBoolean)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.all = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
          if (!bool) {
            m = -3;
          }
          return m;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("SVHwEncoder", 2, "Exception", localException);
          }
          boolean bool = false;
          continue;
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alq = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
        }
      }
    }
    
    int JA()
    {
      try
      {
        Thread.sleep(300L);
        label6:
        this.j = null;
        int m = Jw();
        if (m != 0) {
          SVHwEncoder.this.hq("audioEncodeInit", "err=" + this.dGt);
        }
        int n;
        do
        {
          return m;
          n = F(false);
          m = n;
        } while (n == 0);
        SVHwEncoder.this.hq("audioEncodeInit", "err=" + this.dGt);
        this.c.release();
        return n;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label6;
      }
    }
    
    int Jv()
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
      boolean bool = this.jdField_b_of_type_Azat.a(this.k, this.ceb);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alk = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
      if (!bool) {
        return -2;
      }
      return 0;
    }
    
    int Jw()
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
      if (this.ced != null) {
        this.l.setInteger("aac-profile", this.dGv);
      }
      for (boolean bool1 = this.c.a(this.l, this.ced);; bool1 = false)
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SVHwEncoder", 2, "audioEncodeInit: sfCodecinit error codecNameHw=" + this.ced);
          }
          bool2 = bool1;
          if (this.cec != null)
          {
            this.l.setInteger("aac-profile", this.dGu);
            bool2 = this.c.a(this.l, this.cec);
          }
        }
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alp = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
        if (!bool2) {
          return -8;
        }
        return 0;
      }
    }
    
    int Jx()
    {
      String str = azat.AVC_CODEC_MIME;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
      this.k = MediaFormat.createVideoFormat(str, SVHwEncoder.c(SVHwEncoder.this), SVHwEncoder.d(SVHwEncoder.this));
      int m = a(this.k, str, (int)SVHwEncoder.a(SVHwEncoder.this), SVHwEncoder.k(SVHwEncoder.this));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alj = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
      if (m != 0) {}
      int n;
      do
      {
        do
        {
          return m;
        } while (!this.cGw);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
        n = p(SVHwEncoder.h(SVHwEncoder.this), SVHwEncoder.i(SVHwEncoder.this), SVHwEncoder.l(SVHwEncoder.this));
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alo = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
        m = n;
      } while (n == 0);
      return n;
    }
    
    int Jy()
    {
      dPZ();
      int m = Jv();
      if (m != 0) {}
      int n;
      do
      {
        do
        {
          do
          {
            return m;
            dQa();
            n = F(true);
            m = n;
          } while (n != 0);
          m = n;
        } while (!this.cGw);
        n = Jw();
        m = n;
      } while (n != 0);
      return F(false);
    }
    
    int Jz()
    {
      this.k.setInteger("frame-rate", (int)SVHwEncoder.a(SVHwEncoder.this));
      this.k.setInteger("bitrate", SVHwEncoder.k(SVHwEncoder.this));
      this.i = null;
      int m = Jv();
      if (m != 0) {}
      int n;
      do
      {
        return m;
        n = F(true);
        m = n;
      } while (n == 0);
      SVHwEncoder.this.hq("VideoEncodeExit", "err=" + this.dGt);
      this.jdField_b_of_type_Azat.release();
      return n;
    }
    
    boolean M(ArrayList<SVHwEncoder.a> paramArrayList)
    {
      boolean bool2 = false;
      for (;;)
      {
        SVHwEncoder.a locala = SVHwEncoder.this.a(paramArrayList);
        bool1 = bool2;
        if (locala == null) {
          return bool1;
        }
        if (!locala.finish) {
          break;
        }
        SVHwEncoder.this.eT(paramArrayList);
      }
      boolean bool1 = true;
      return bool1;
    }
    
    void PL(boolean paramBoolean)
    {
      try
      {
        azat localazat = a(paramBoolean);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
        localazat.stop();
        if (paramBoolean) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.all = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
          localazat.release();
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.aln = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
          return;
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alq = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
        }
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.als = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    
    void Qy(String paramString)
    {
      SVHwEncoder.this.hq(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(SVHwEncoder.this) + " mVideoWritedFrameCount=" + this.dGy + " mVideoEncodedframeCount=" + this.dGz + " mVideoMuxeredframeCount=" + this.dGA);
      SVHwEncoder.this.hq(paramString, ": mExitVideoEncode=" + SVHwEncoder.c(SVHwEncoder.this) + " mAudioWritedFrameCount=" + this.dGB + " mAudioEncodedframeCount=" + this.dGC + " mAudioMuxeredframeCount=" + this.dGD);
    }
    
    public void Tt(int paramInt)
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.Tt(paramInt);
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svEncodeProgress: progress=" + paramInt + " mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    int a(MediaFormat paramMediaFormat, String paramString, int paramInt1, int paramInt2)
    {
      int i2 = 0;
      int i3 = -1;
      List localList = azat.i(paramString, true);
      if (localList.size() <= 0) {
        return -6;
      }
      int m = 0;
      while (m < localList.size())
      {
        SVHwEncoder.this.hq("encodeVideoInit", " codecname=" + ((MediaCodecInfo)localList.get(m)).getName());
        m += 1;
      }
      int n = 0;
      int i1;
      Object localObject;
      for (;;)
      {
        i1 = i3;
        m = i2;
        if (n < localList.size())
        {
          localObject = azat.getCodecCapabilities((MediaCodecInfo)localList.get(n), paramString);
          if (localObject == null) {
            return -26;
          }
          localObject = ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats;
          m = 0;
          while (m < localObject.length)
          {
            SVHwEncoder.this.hq("encodeVideoInit", " colorformat=0x" + Integer.toHexString(localObject[m]));
            m += 1;
          }
          if (jjd.contains((int[])localObject, 21))
          {
            m = 21;
            i1 = n;
          }
        }
        else
        {
          if (i1 >= 0) {
            break label420;
          }
          n = 0;
          if (n >= localList.size()) {
            break label420;
          }
          localObject = azat.getCodecCapabilities((MediaCodecInfo)localList.get(n), paramString);
          if (localObject != null) {
            break;
          }
          return -26;
        }
        n += 1;
      }
      if (jjd.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
        m = 19;
      }
      for (;;)
      {
        if ((m != 19) && (m != 21))
        {
          return -1;
          n += 1;
          break;
        }
        if ((m == 2130708361) || (m == 19)) {
          SVHwEncoder.this.dGn = 19;
        }
        for (;;)
        {
          paramMediaFormat.setInteger("color-format", m);
          paramMediaFormat.setInteger("frame-rate", paramInt1);
          paramMediaFormat.setInteger("bitrate", paramInt2);
          paramMediaFormat.setInteger("i-frame-interval", 1);
          this.ceb = ((MediaCodecInfo)localList.get(n)).getName();
          return 0;
          if (m == 21) {
            SVHwEncoder.this.dGn = 21;
          }
        }
        label420:
        n = i1;
      }
    }
    
    azat a(boolean paramBoolean)
    {
      if (paramBoolean) {
        return this.jdField_b_of_type_Azat;
      }
      return this.c;
    }
    
    public SVHwEncoder.a a()
    {
      return this.jdField_a_of_type_Azau.a();
    }
    
    public SVHwEncoder.a a(int paramInt)
    {
      return this.jdField_a_of_type_Azau.a(paramInt);
    }
    
    /* Error */
    boolean bm(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: iconst_0
      //   3: istore_3
      //   4: aload_0
      //   5: getfield 89	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:this$0	Ldov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
      //   8: ldc_w 506
      //   11: new 192	java/lang/StringBuilder
      //   14: dup
      //   15: invokespecial 193	java/lang/StringBuilder:<init>	()V
      //   18: ldc_w 508
      //   21: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: aload_0
      //   25: getfield 510	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:cGq	Z
      //   28: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   31: ldc_w 512
      //   34: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: iload_1
      //   38: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   41: ldc_w 514
      //   44: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: invokevirtual 222	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:hq	(Ljava/lang/String;Ljava/lang/String;)V
      //   53: aload_0
      //   54: getfield 510	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:cGq	Z
      //   57: ifeq +98 -> 155
      //   60: aload_0
      //   61: iconst_0
      //   62: putfield 510	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:cGq	Z
      //   65: aload_0
      //   66: iconst_m1
      //   67: putfield 100	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:outputVideoTrack	I
      //   70: aload_0
      //   71: iconst_m1
      //   72: putfield 102	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:outputAudioTrack	I
      //   75: iload_1
      //   76: ifeq +90 -> 166
      //   79: aload_0
      //   80: getfield 516	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
      //   83: invokevirtual 519	android/media/MediaMuxer:stop	()V
      //   86: aload_0
      //   87: getfield 89	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:this$0	Ldov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder;
      //   90: ldc_w 506
      //   93: new 192	java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial 193	java/lang/StringBuilder:<init>	()V
      //   100: ldc_w 508
      //   103: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: aload_0
      //   107: getfield 510	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:cGq	Z
      //   110: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   113: ldc_w 512
      //   116: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   119: iload_1
      //   120: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   123: ldc_w 521
      //   126: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   132: invokevirtual 222	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:hq	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: iload_1
      //   136: ifeq +52 -> 188
      //   139: aload_0
      //   140: getfield 516	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
      //   143: invokevirtual 522	android/media/MediaMuxer:release	()V
      //   146: iload_3
      //   147: istore_1
      //   148: aload_0
      //   149: aconst_null
      //   150: putfield 516	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
      //   153: iload_1
      //   154: istore_2
      //   155: iload_2
      //   156: ireturn
      //   157: astore 4
      //   159: aload 4
      //   161: invokevirtual 523	java/lang/IllegalStateException:printStackTrace	()V
      //   164: iconst_1
      //   165: ireturn
      //   166: aload_0
      //   167: getfield 516	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
      //   170: invokevirtual 519	android/media/MediaMuxer:stop	()V
      //   173: goto -87 -> 86
      //   176: astore 4
      //   178: aload 4
      //   180: invokevirtual 523	java/lang/IllegalStateException:printStackTrace	()V
      //   183: iconst_1
      //   184: istore_1
      //   185: goto -37 -> 148
      //   188: aload_0
      //   189: getfield 516	dov/com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder$HwEncode:jdField_b_of_type_AndroidMediaMediaMuxer	Landroid/media/MediaMuxer;
      //   192: invokevirtual 522	android/media/MediaMuxer:release	()V
      //   195: iload_3
      //   196: istore_1
      //   197: goto -49 -> 148
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	200	0	this	HwEncode
      //   0	200	1	paramBoolean	boolean
      //   1	155	2	bool1	boolean
      //   3	193	3	bool2	boolean
      //   157	3	4	localIllegalStateException1	IllegalStateException
      //   176	3	4	localIllegalStateException2	IllegalStateException
      // Exception table:
      //   from	to	target	type
      //   79	86	157	java/lang/IllegalStateException
      //   139	146	176	java/lang/IllegalStateException
    }
    
    public void dJV()
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.dJV();
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svEncodeBegin mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    public void dJW()
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.dJW();
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svEncodeEnd mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    void dPU()
    {
      this.bYI = (this.cef + "shortvideo_seg_" + this.dGw + ".mp4");
      this.dGw += 1;
    }
    
    void dPV()
    {
      if ((this.dGw == 1) && (!SVHwEncoder.b(SVHwEncoder.this)) && (!this.cGC) && (this.dGy >= 1))
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
        this.cGD = false;
        this.jdField_a_of_type_Azaw.atY = null;
        this.jdField_a_of_type_Azaw.aIf = null;
        this.jdField_a_of_type_Azaw.mErrCode = 0;
        this.jdField_a_of_type_Azaw.alE = 0L;
        new a().execute(new Void[0]);
        this.cGC = true;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alu = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
      }
    }
    
    void dPW()
    {
      this.dGt = 0;
      if ((this.cGD) && (!this.cGE))
      {
        if (this.jdField_a_of_type_Azaw.mErrCode == 0) {
          break label163;
        }
        this.dGt = -9;
        js(-9, this.jdField_a_of_type_Azaw.mErrCode);
        SVHwEncoder.this.hq("hw_av_merge_segment", "genThumbFile mLastErrCode=" + this.dGt + " subcode=" + this.jdField_a_of_type_Azaw.mErrCode);
      }
      for (;;)
      {
        SVHwEncoder.this.hq("hw_video_segment_notify_msg", "svThumbOK:mCallSegmentIndex=" + this.dGx + " mLastErrCode=" + this.dGt);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alt = this.jdField_a_of_type_Azaw.alE;
        this.cGE = true;
        return;
        label163:
        n(this.jdField_a_of_type_Azaw.atY, SVHwEncoder.f(SVHwEncoder.this), SVHwEncoder.g(SVHwEncoder.this), this.jdField_a_of_type_Azaw.aIf);
      }
    }
    
    void dPY()
    {
      int m = this.mS.size();
      String str = zT();
      if (m <= 0)
      {
        SVHwEncoder.this.hq("hw_av_merge_segment", "size <= 0");
        return;
      }
      long l1;
      File localFile1;
      File localFile2;
      if (m == 1)
      {
        l1 = System.nanoTime();
        SVHwEncoder.this.hq("hw_av_merge_segment", "renameTo.");
        localFile1 = new File((String)this.mS.get(0));
        localFile2 = new File(str);
        if (SVHwEncoder.b(SVHwEncoder.this)) {
          if ((this.dGA <= 0) && (this.dGD <= 0))
          {
            m = -2;
            aqhq.deleteFile(localFile1.getAbsolutePath());
            SVHwEncoder.this.hq("hw_av_merge_segment", "[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=" + this.dGA + " mAudioMuxeredframeCount=" + this.dGD);
            l1 = (System.nanoTime() - l1) / 1000L;
          }
        }
      }
      for (;;)
      {
        SVHwEncoder.this.hq("hw_av_merge_segment", "merge mp4 Over error=" + m);
        if (m != 0) {
          break label330;
        }
        E(str, SVHwEncoder.b(SVHwEncoder.this), l1);
        SVHwEncoder.this.hq("hw_av_merge_segment", "notify merge OK......");
        return;
        if (!localFile1.renameTo(localFile2))
        {
          m = -1;
          break;
          aqhq.copyFile(localFile1, localFile2);
        }
        m = 0;
        break;
        l1 = System.nanoTime();
        m = SVMp4Merge.e(this.mS, str);
        l1 = (System.nanoTime() - l1) / 1000L;
        SVHwEncoder.this.hq("hw_av_merge_segment", "merge:time=" + l1 + " us");
      }
      label330:
      js(-40, m);
      aqhq.cn(this.cef);
      SVHwEncoder.this.hq("hw_av_merge_segment", "merge error delete cache......");
    }
    
    void dPZ()
    {
      this.k.setInteger("width", SVHwEncoder.c(SVHwEncoder.this));
      this.k.setInteger("height", SVHwEncoder.d(SVHwEncoder.this));
    }
    
    void dQa() {}
    
    void dQb() {}
    
    void dQc()
    {
      this.dGy = 0;
      this.dGz = 0;
      this.dGA = 0;
      this.dGB = 0;
      this.dGC = 0;
      this.dGD = 0;
    }
    
    long gV()
    {
      long l1;
      if (SVHwEncoder.b(SVHwEncoder.this)) {
        l1 = this.dGE;
      }
      long l2;
      do
      {
        return l1;
        l2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gY();
        l1 = l2;
      } while (l2 <= this.dGE);
      return this.dGE;
    }
    
    long gW()
    {
      long l1;
      if (SVHwEncoder.b(SVHwEncoder.this)) {
        l1 = this.dGE;
      }
      long l2;
      do
      {
        return l1;
        l2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gZ();
        l1 = l2;
      } while (l2 <= this.dGE);
      return this.dGE;
    }
    
    public void js(int paramInt1, int paramInt2)
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.js(paramInt1, paramInt2);
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svErrorOcured:error=" + paramInt1 + " subcode=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    public void m(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.m(paramString, paramInt1, paramInt2, paramInt3);
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svSegmentOK:path=" + paramString + " index=" + paramInt1 + "width=" + paramInt2 + " height=" + paramInt3 + " mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    public void n(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      if ((this.jdField_b_of_type_Azav != null) && (!SVHwEncoder.a(SVHwEncoder.this))) {
        this.jdField_b_of_type_Azav.n(paramString1, paramInt1, paramInt2, paramString2);
      }
      SVHwEncoder.this.hq("hw_video_callback_msg", "svThumbOK:path=" + paramString1 + " md5=" + paramString2 + "width=" + paramInt1 + " height=" + paramInt2 + " mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
    }
    
    String nv(String paramString)
    {
      paramString = paramString + "_qq_hw/";
      File localFile = new File(paramString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return paramString;
    }
    
    int p(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject1 = null;
      int i2 = 2;
      Object localObject3 = azat.aN("audio/mp4a-latm");
      Object localObject2 = azat.i("audio/mp4a-latm", true);
      if ((((List)localObject3).size() <= 0) && (((List)localObject2).size() <= 0)) {
        return -7;
      }
      int m;
      String str;
      if (((List)localObject2).size() > 0)
      {
        SVHwEncoder.this.hq("audioEncodeInit", " HardCodecSize=" + ((List)localObject2).size());
        m = SVHwEncoder.this.d((List)localObject2, "audio/mp4a-latm");
        if (m < 0)
        {
          str = ((MediaCodecInfo)((List)localObject2).get(((List)localObject2).size() - 1)).getName();
          localObject2 = ((MediaCodecInfo)((List)localObject2).get(0)).getCapabilitiesForType("audio/mp4a-latm");
          if ((((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels == null) || (((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length <= 0)) {
            break label455;
          }
          m = localObject2.profileLevels[0].profile;
        }
      }
      for (;;)
      {
        int n;
        if (((List)localObject3).size() > 0)
        {
          SVHwEncoder.this.hq("audioEncodeInit", " softCodecSize=" + ((List)localObject3).size());
          n = SVHwEncoder.this.d((List)localObject3, "audio/mp4a-latm");
          if (n < 0)
          {
            localObject2 = ((MediaCodecInfo)((List)localObject3).get(0)).getName();
            localObject3 = ((MediaCodecInfo)((List)localObject3).get(0)).getCapabilitiesForType("audio/mp4a-latm");
            localObject1 = localObject2;
            if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels == null) {
              break label449;
            }
            localObject1 = localObject2;
            if (((MediaCodecInfo.CodecCapabilities)localObject3).profileLevels.length <= 0) {
              break label449;
            }
            n = localObject3.profileLevels[0].profile;
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          label324:
          int i1 = m;
          if (m == -1) {
            i1 = 2;
          }
          if (n == -1) {}
          for (m = i2;; m = n)
          {
            this.l = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
            this.l.setInteger("bitrate", paramInt3);
            this.cec = str;
            this.ced = ((String)localObject1);
            this.dGu = i1;
            this.dGv = m;
            return 0;
            str = ((MediaCodecInfo)((List)localObject2).get(m)).getName();
            m = 2;
            break;
            localObject1 = ((MediaCodecInfo)((List)localObject3).get(n)).getName();
            n = 2;
            break label324;
          }
          label449:
          n = -1;
        }
        label455:
        m = -1;
        continue;
        m = -1;
        str = null;
      }
    }
    
    void pauseThread()
    {
      synchronized (this.eR)
      {
        SVHwEncoder.this.hq("pauseThread", "pauseThread:mHavePaused=" + this.cGF);
        if (!this.cGF) {
          this.cGF = true;
        }
      }
      try
      {
        this.eR.wait();
        label59:
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label59;
      }
    }
    
    boolean pi(String paramString)
    {
      if (SVHwEncoder.a(SVHwEncoder.this))
      {
        Qy(paramString);
        return true;
      }
      if (SVHwEncoder.c(SVHwEncoder.this))
      {
        int m = SVHwEncoder.this.t(SVHwEncoder.a(SVHwEncoder.this));
        int n = SVHwEncoder.this.t(SVHwEncoder.b(SVHwEncoder.this));
        if ((m <= 0) && (n <= 0))
        {
          Qy(paramString + "videosize=" + m + " audiosize=" + n);
          return true;
        }
      }
      return false;
    }
    
    public void run()
    {
      this.dGt = Jx();
      if (this.dGt != 0)
      {
        SVHwEncoder.this.hq("configHardWareComponent", " err=" + this.dGt);
        js(this.dGt, 0);
        this.k = null;
        this.l = null;
        return;
      }
      if ((!SVHwEncoder.b(SVHwEncoder.this)) && (!azba.cHa)) {}
      for (;;)
      {
        boolean bool1;
        synchronized (azba.eS)
        {
          bool1 = azba.cHa;
          if (bool1) {}
        }
        try
        {
          azba.eS.wait(1000L);
          if (!SVHwEncoder.c(SVHwEncoder.this)) {
            continue;
          }
          return;
          localObject2 = finally;
          throw localObject2;
          SVHwEncoder.this.hq("[Lock.CAPTURE_LOCK=true]", "begin to record video......");
          dJV();
          this.dGt = Jy();
          if (this.dGt != 0)
          {
            SVHwEncoder.this.hq("initEncodeStatus", " err=" + this.dGt);
            js(this.dGt, 0);
            PL(true);
            PL(false);
            dQb();
            return;
          }
          if (SVHwEncoder.b(SVHwEncoder.this))
          {
            this.cGy = true;
            SVHwEncoder.a(SVHwEncoder.this, SVHwEncoder.a(SVHwEncoder.this) * 1000 / SVHwEncoder.b(SVHwEncoder.this));
            this.jdField_a_of_type_Azax.dQf();
            this.jdField_a_of_type_Azax.bd(SVHwEncoder.a(SVHwEncoder.this));
            SVHwEncoder.this.hq("HwEncodeHelper:mOnlyGenOneMp4", "mTotalFrames=" + SVHwEncoder.a(SVHwEncoder.this) + " mTotalTimes=" + SVHwEncoder.b(SVHwEncoder.this) + " mVideoFps=" + SVHwEncoder.a(SVHwEncoder.this));
          }
          if (SVHwEncoder.a(SVHwEncoder.this))
          {
            label367:
            PL(true);
            PL(false);
            dQb();
            SVHwEncoder.this.hq("hw_video_time_used_msg", "HwTimeUsed_End=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.toString());
            SVHwEncoder.this.hq("hw_av_merge_segment", "release resource ok......");
            if (this.dGt == 0) {
              break label5224;
            }
            SVHwEncoder.this.hq("hw_av_merge_segment", "mLastErrCode=" + this.dGt);
            SVHwEncoder.a(SVHwEncoder.this, true);
            bm(true);
            label485:
            if (!SVHwEncoder.a(SVHwEncoder.this)) {
              break label5231;
            }
            SVHwEncoder.this.hq("hw_av_merge_segment", "clear cache mCacellVideoEncode=" + SVHwEncoder.a(SVHwEncoder.this));
            aqhq.cn(this.cef);
          }
          for (;;)
          {
            for (;;)
            {
              this.jdField_b_of_type_Azav = null;
              this.jdField_a_of_type_Azau = null;
              SVHwEncoder.c(SVHwEncoder.this).clear();
              SVHwEncoder.a(SVHwEncoder.this).clear();
              SVHwEncoder.b(SVHwEncoder.this).clear();
              SVHwEncoder.a(SVHwEncoder.this, null);
              SVHwEncoder.b(SVHwEncoder.this, null);
              SVHwEncoder.c(SVHwEncoder.this, null);
              this.jdField_a_of_type_Azax.dQf();
              this.dGx = 0;
              return;
              Object localObject3 = null;
              ??? = localObject3;
              if (!SVHwEncoder.b(SVHwEncoder.this))
              {
                ??? = localObject3;
                if (!this.cGr) {
                  ??? = SVHwEncoder.this.a(SVHwEncoder.a(SVHwEncoder.this));
                }
              }
              SVHwEncoder.this.hq("hw_video_write_frame", "mVideoSourceDone=" + this.cGr + " mDataSource=" + this.jdField_a_of_type_Azau);
              SVHwEncoder.this.hq("hw_video_write_frame", "mMuxerCreated=" + this.cGq + " encoderOutputVideoFormat=" + this.i);
              if (((??? != null) || ((SVHwEncoder.b(SVHwEncoder.this)) && (!this.cGr))) && ((this.i == null) || (this.cGq))) {}
              label865:
              label1020:
              int m;
              label1506:
              int n;
              for (;;)
              {
                try
                {
                  l1 = gV();
                  SVHwEncoder.this.hq("hw_video_timestamp", "videotimeout=" + l1);
                  locala = this.jdField_b_of_type_Azat.a(l1);
                  if ((locala != null) && (locala.index != -1)) {
                    break label1506;
                  }
                  SVHwEncoder.this.hq("hw_video_write_frame", "INFO_TRY_AGAIN_LATER");
                  localObject3 = null;
                  ??? = localObject3;
                  if (!SVHwEncoder.b(SVHwEncoder.this))
                  {
                    ??? = localObject3;
                    if (!this.cGs) {
                      ??? = SVHwEncoder.this.a(SVHwEncoder.b(SVHwEncoder.this));
                    }
                  }
                  if ((??? != null) || ((SVHwEncoder.b(SVHwEncoder.this)) && (!this.cGs))) {
                    if (this.j != null) {
                      if (!this.cGq) {
                        continue;
                      }
                    }
                  }
                }
                catch (IllegalStateException localIllegalStateException1)
                {
                  for (;;)
                  {
                    azat.a locala;
                    try
                    {
                      l1 = gW();
                      SVHwEncoder.this.hq("hw_audio_timestamp", "audiotimeout=" + l1);
                      locala = this.c.a(l1);
                      if ((locala == null) || (locala.index == -1))
                      {
                        SVHwEncoder.this.hq("hw_audio_write_frame", "INFO_TRY_AGAIN_LATER");
                        if ((this.cGr) && (this.cGs) && (this.cGz) && (!SVHwEncoder.b(SVHwEncoder.this)))
                        {
                          SVHwEncoder.this.hq("hw_smooth_time_stamp", "mUpdateVideoFps=" + this.cGz + " mVideoFps=" + SVHwEncoder.a(SVHwEncoder.this));
                          this.cGz = false;
                          this.cGy = true;
                          this.jdField_a_of_type_Azax.dQf();
                          this.jdField_a_of_type_Azax.bd(SVHwEncoder.a(SVHwEncoder.this));
                        }
                        if ((this.cGB) && (!this.cGt)) {
                          if (this.i != null) {
                            if (!this.cGq) {
                              continue;
                            }
                          }
                        }
                      }
                    }
                    catch (IllegalStateException localIllegalStateException3)
                    {
                      c localc1;
                      localIllegalStateException3.printStackTrace();
                      this.dGt = -18;
                      js(this.dGt, 0);
                    }
                    try
                    {
                      l1 = gV();
                      SVHwEncoder.this.hq("hw_video_encode_frame", "videoOutTime=" + l1);
                      ??? = this.jdField_b_of_type_Azat.b(l1);
                      if (??? == null)
                      {
                        SVHwEncoder.this.hq("hw_video_encode_frame", "encoderOutputBuffer=null");
                        if ((this.cGB) && (!this.cGu)) {
                          if (this.j != null) {
                            if (!this.cGq) {
                              continue;
                            }
                          }
                        }
                      }
                    }
                    catch (IllegalStateException localIllegalStateException5)
                    {
                      c localc2;
                      int i1;
                      float f;
                      localIllegalStateException5.printStackTrace();
                      this.dGt = -23;
                      js(this.dGt, 0);
                    }
                    try
                    {
                      l1 = gW();
                      SVHwEncoder.this.hq("hw_audio_encode_frame", "audioOutTime=" + l1);
                      ??? = this.c.b(l1);
                      if (??? != null) {
                        break label3495;
                      }
                      SVHwEncoder.this.hq("hw_audio_encode_frame", "encoderOutputBuffer=null");
                      if ((SVHwEncoder.b(SVHwEncoder.this)) && (!this.cGx))
                      {
                        m = this.dGz * 100 / SVHwEncoder.a(SVHwEncoder.this);
                        Tt(m);
                        if (m >= 100) {
                          this.cGx = true;
                        }
                      }
                      if (SVHwEncoder.d(SVHwEncoder.this)) {
                        pauseThread();
                      }
                      dPV();
                      dPW();
                      if (this.dGt != 0) {
                        break;
                      }
                      if ((!this.cGt) || (!this.cGu)) {
                        break label4405;
                      }
                      bool1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.axk();
                      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.dQe();
                      if (bool1) {
                        break label3918;
                      }
                      SVHwEncoder.this.hq("releaseMuxer[check]", "validSegment=" + bool1);
                      this.dGt = -14;
                      js(this.dGt, 0);
                    }
                    catch (IllegalStateException localIllegalStateException6)
                    {
                      localIllegalStateException6.printStackTrace();
                      this.dGt = -22;
                      js(this.dGt, 0);
                    }
                  }
                  localIllegalStateException1 = localIllegalStateException1;
                  localIllegalStateException1.printStackTrace();
                  this.dGt = -19;
                  js(this.dGt, 0);
                }
                break;
                if (locala.buffer == null)
                {
                  localc1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c;
                  localc1.dGJ += 1;
                  SVHwEncoder.this.hq("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer = null mVideoBuferErrCount=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGJ);
                  if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGJ < 3) {
                    continue;
                  }
                  this.dGt = -21;
                  js(this.dGt, 0);
                  break;
                }
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGJ = 0;
                localObject3 = localc1;
                if (SVHwEncoder.b(SVHwEncoder.this))
                {
                  localObject3 = localc1;
                  if (this.jdField_a_of_type_Azau != null) {
                    localObject3 = a(SVHwEncoder.this.dGn);
                  }
                }
                if (!((SVHwEncoder.a)localObject3).finish)
                {
                  locala.buffer.clear();
                  m = locala.buffer.capacity();
                  n = ((SVHwEncoder.a)localObject3).size - ((SVHwEncoder.a)localObject3).offset;
                  if (m >= n)
                  {
                    locala.buffer.put(((SVHwEncoder.a)localObject3).data, ((SVHwEncoder.a)localObject3).offset, n);
                    ((SVHwEncoder.a)localObject3).offset += n;
                    l2 = 1000L * ((SVHwEncoder.a)localObject3).time;
                    if (!this.cGy) {
                      break label5263;
                    }
                    l1 = this.jdField_a_of_type_Azax.T(((SVHwEncoder.a)localObject3).time);
                    SVHwEncoder.this.hq("hw_video_timestamp", "oldTime=" + l2 + " frameTime=" + l1);
                  }
                }
                label2217:
                for (;;)
                {
                  try
                  {
                    this.jdField_b_of_type_Azat.a(locala, ((SVHwEncoder.a)localObject3).size, l1, 0);
                    this.dGy += 1;
                    SVHwEncoder.this.hq("hw_video_write_frame", "mVideoWritedFrameCount=" + this.dGy);
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PM(true);
                    if ((this.jdField_a_of_type_Azau != null) || (((SVHwEncoder.a)localObject3).offset != ((SVHwEncoder.a)localObject3).size)) {
                      break label865;
                    }
                    SVHwEncoder.this.eT(SVHwEncoder.a(SVHwEncoder.this));
                    if (SVHwEncoder.this.a((SVHwEncoder.a)localObject3)) {
                      break label865;
                    }
                    ((SVHwEncoder.a)localObject3).data = null;
                  }
                  catch (IllegalStateException localIllegalStateException2)
                  {
                    localIllegalStateException2.printStackTrace();
                    this.dGt = -17;
                    js(this.dGt, 0);
                  }
                  this.dGt = -12;
                  js(this.dGt, 0);
                  break;
                  break;
                  this.jdField_b_of_type_Azat.a(locala, 0, 0L, 4);
                  this.cGr = true;
                  SVHwEncoder.this.hq("hw_video_write_frame", "[end-of-stream] fps=" + ((SVHwEncoder.a)localObject3).zI + " bitrate" + ((SVHwEncoder.a)localObject3).bitrate);
                  if ((((SVHwEncoder.a)localObject3).zI > 0.0F) && (!SVHwEncoder.b(SVHwEncoder.this)))
                  {
                    SVHwEncoder.this.hq("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.cGy + " mUpdateVideoFps=" + this.cGz + " mVideoFps=" + SVHwEncoder.a(SVHwEncoder.this));
                    SVHwEncoder.a(SVHwEncoder.this, ((SVHwEncoder.a)localObject3).zI);
                    if (!this.cGy) {
                      break label2149;
                    }
                  }
                  for (;;)
                  {
                    if (((SVHwEncoder.a)localObject3).bitrate <= 0) {
                      break label2217;
                    }
                    SVHwEncoder.a(SVHwEncoder.this, ((SVHwEncoder.a)localObject3).bitrate);
                    break;
                    label2149:
                    this.cGz = true;
                    SVHwEncoder.this.hq("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.cGy + " mUpdateVideoFps=" + this.cGz + " mVideoFps=" + SVHwEncoder.a(SVHwEncoder.this));
                  }
                }
                break;
                if (locala.buffer == null)
                {
                  localc2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c;
                  localc2.dGK += 1;
                  SVHwEncoder.this.hq("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer=null mAudioBuferErrCount=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGK);
                  if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGK < 3) {
                    continue;
                  }
                  this.dGt = -20;
                  js(this.dGt, 0);
                  break;
                }
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$c.dGK = 0;
                localObject3 = localc2;
                if (SVHwEncoder.b(SVHwEncoder.this))
                {
                  localObject3 = localc2;
                  if (this.jdField_a_of_type_Azau != null) {
                    localObject3 = a();
                  }
                }
                if (!((SVHwEncoder.a)localObject3).finish)
                {
                  locala.buffer.clear();
                  n = locala.buffer.capacity();
                  i1 = ((SVHwEncoder.a)localObject3).size - ((SVHwEncoder.a)localObject3).offset;
                  if (n >= i1)
                  {
                    locala.buffer.put(((SVHwEncoder.a)localObject3).data, ((SVHwEncoder.a)localObject3).offset, i1);
                    ((SVHwEncoder.a)localObject3).offset += i1;
                    m = i1;
                    label2456:
                    SVHwEncoder.this.hq("hw_audio_write_frame", "offset=" + ((SVHwEncoder.a)localObject3).offset + " size=" + ((SVHwEncoder.a)localObject3).size + " audiovalidSize=" + i1);
                    SVHwEncoder.this.hq("hw_audio_write_frame", "audiocapacity=" + n + " writedByte=" + m);
                    l2 = 1000L * ((SVHwEncoder.a)localObject3).time;
                    if (!this.cGy) {
                      break label5256;
                    }
                    f = x(m);
                    l1 = this.jdField_a_of_type_Azax.a(f);
                    SVHwEncoder.this.hq("hw_audio_timestamp", "oldTime=" + l2 + " frameTime=" + l1);
                  }
                }
                for (;;)
                {
                  try
                  {
                    this.c.a(locala, m, l1, 0);
                    this.dGB += 1;
                    SVHwEncoder.this.hq("hw_audio_write_frame", "mWritedFrameCount=" + this.dGB);
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PM(false);
                    if ((this.jdField_a_of_type_Azau != null) || (((SVHwEncoder.a)localObject3).offset != ((SVHwEncoder.a)localObject3).size)) {
                      break label1020;
                    }
                    SVHwEncoder.this.eT(SVHwEncoder.b(SVHwEncoder.this));
                    ((SVHwEncoder.a)localObject3).data = null;
                  }
                  catch (IllegalStateException localIllegalStateException4)
                  {
                    SVHwEncoder.this.hq("hw_audio_timestamp", "offset=" + ((SVHwEncoder.a)localObject3).offset + " size=" + ((SVHwEncoder.a)localObject3).size + " audiovalidSize=" + i1);
                    SVHwEncoder.this.hq("hw_audio_timestamp", "audiocapacity=" + n + " writedByte=" + m);
                    localIllegalStateException4.printStackTrace();
                    this.dGt = -16;
                    js(this.dGt, 0);
                  }
                  locala.buffer.put(((SVHwEncoder.a)localObject3).data, ((SVHwEncoder.a)localObject3).offset, n);
                  ((SVHwEncoder.a)localObject3).offset += n;
                  m = n;
                  break label2456;
                  break;
                  this.c.a(locala, 0, 0L, 4);
                  this.cGs = true;
                  SVHwEncoder.this.hq("hw_audio_write_frame", "mWritedFrameCount=" + this.dGB + " [Finish]...");
                }
                break;
                localObject3 = localIllegalStateException5.info;
                m = localIllegalStateException5.index;
                if (m == -1)
                {
                  SVHwEncoder.this.hq("hw_video_encode_frame", "try later");
                }
                else if (m == -3)
                {
                  SVHwEncoder.this.hq("hw_video_encode_frame", "output buffers changed");
                }
                else if (m == -2)
                {
                  this.i = this.jdField_b_of_type_Azat.a().getOutputFormat();
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.h(this.i);
                  SVHwEncoder.this.hq("hw_video_encode_frame", "out format changed");
                }
                else if ((((MediaCodec.BufferInfo)localObject3).flags & 0x2) != 0)
                {
                  SVHwEncoder.this.hq("hw_video_encode_frame", "get Config data...");
                  SVHwEncoder.this.a(localIllegalStateException5.buffer, (MediaCodec.BufferInfo)localObject3, "mVideoEncoder_dequeueOutputBuffer", 30);
                  this.jdField_b_of_type_Azat.a(localIllegalStateException5);
                }
                else
                {
                  SVHwEncoder.this.hq("hw_video_encode_frame", "writedata size=" + ((MediaCodec.BufferInfo)localObject3).size);
                  if (((MediaCodec.BufferInfo)localObject3).size != 0)
                  {
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PN(true);
                    this.dGz += 1;
                    if (this.jdField_b_of_type_AndroidMediaMediaMuxer == null) {
                      break label3454;
                    }
                    if ((((MediaCodec.BufferInfo)localObject3).flags & 0x1) != 0)
                    {
                      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.cGG = true;
                      if (this.dGA == 0) {
                        this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.cGI = true;
                      }
                    }
                    if (this.dGA == 0)
                    {
                      if (this.dGD != 0) {
                        break label3406;
                      }
                      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.cGH = true;
                    }
                    label3262:
                    this.dGA += 1;
                    SVHwEncoder.this.hq("hw_video_writesample", "track=" + this.outputVideoTrack + " pts=" + ((MediaCodec.BufferInfo)localObject3).presentationTimeUs);
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.o(((MediaCodec.BufferInfo)localObject3).presentationTimeUs, true);
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
                  }
                  for (;;)
                  {
                    try
                    {
                      this.jdField_b_of_type_AndroidMediaMediaMuxer.writeSampleData(this.outputVideoTrack, localIllegalStateException5.buffer, (MediaCodec.BufferInfo)localObject3);
                      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PO(true);
                      if ((((MediaCodec.BufferInfo)localObject3).flags & 0x4) != 0)
                      {
                        this.cGt = true;
                        SVHwEncoder.this.hq("hw_video_encode_frame", "end of stream");
                      }
                      this.jdField_b_of_type_Azat.a(localIllegalStateException5);
                    }
                    catch (Throwable localThrowable1)
                    {
                      label3406:
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of video erro", localThrowable1);
                      this.dGt = -25;
                      js(this.dGt, 0);
                    }
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.cGH = false;
                    break label3262;
                    break;
                    label3454:
                    SVHwEncoder.this.hq("hw_video_encode_frame", "video encoder:muxer is null");
                  }
                  break;
                  label3495:
                  localObject3 = localIllegalStateException6.info;
                  m = localIllegalStateException6.index;
                  if (m == -1)
                  {
                    SVHwEncoder.this.hq("hw_audio_encode_frame", "try later");
                  }
                  else if (m == -3)
                  {
                    SVHwEncoder.this.hq("hw_audio_encode_frame", "out buffer change");
                  }
                  else if (m == -2)
                  {
                    this.j = this.c.a().getOutputFormat();
                    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.i(this.j);
                    SVHwEncoder.this.hq("hw_audio_encode_frame", "out format change");
                  }
                  else
                  {
                    if ((((MediaCodec.BufferInfo)localObject3).flags & 0x2) == 0) {
                      break label3652;
                    }
                    SVHwEncoder.this.hq("hw_audio_encode_frame", "get config......");
                    SVHwEncoder.this.a(localIllegalStateException6.buffer, (MediaCodec.BufferInfo)localObject3, "mAudioEncoder_dequeueOutputBuffer", 10);
                    this.c.a(localIllegalStateException6);
                  }
                }
              }
              label3652:
              SVHwEncoder.this.hq("hw_audio_encode_frame", "writedata size=" + ((MediaCodec.BufferInfo)localObject3).size);
              if (((MediaCodec.BufferInfo)localObject3).size != 0)
              {
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PN(false);
                this.dGC += 1;
                if (this.jdField_b_of_type_AndroidMediaMediaMuxer == null) {
                  break label3902;
                }
                this.dGD += 1;
                SVHwEncoder.this.hq("hw_audio_writesample", "track=" + this.outputAudioTrack + " pts=" + ((MediaCodec.BufferInfo)localObject3).presentationTimeUs);
                if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.o(((MediaCodec.BufferInfo)localObject3).presentationTimeUs, false)) {
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
                }
              }
              for (;;)
              {
                try
                {
                  this.jdField_b_of_type_AndroidMediaMediaMuxer.writeSampleData(this.outputAudioTrack, localIllegalStateException6.buffer, (MediaCodec.BufferInfo)localObject3);
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.PO(false);
                  if ((((MediaCodec.BufferInfo)localObject3).flags & 0x4) != 0)
                  {
                    this.cGu = true;
                    SVHwEncoder.this.hq("hw_audio_encode_frame", "end of stream");
                  }
                  this.c.a(localIllegalStateException6);
                }
                catch (Throwable localThrowable2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of audio erro", localThrowable2);
                  }
                  this.dGt = -24;
                  js(this.dGt, 0);
                }
                break;
                label3902:
                SVHwEncoder.this.hq("hw_audio_encode_frame", "muxer is null");
              }
              label3918:
              if (bm(true))
              {
                this.dGt = -14;
                js(this.dGt, 1);
                break label367;
              }
              if (this.cGE)
              {
                if (this.dGx + 1 < this.dGw)
                {
                  if (this.mS.size() != this.dGw - 1)
                  {
                    this.dGt = -15;
                    js(this.dGt, 0);
                    break label367;
                  }
                  m = 0;
                  while (m < this.mS.size())
                  {
                    SVHwEncoder.this.hq("hw_video_segment_notify_msg", "svSegmentOK:[roll] i=" + m + " mCallSegmentIndex=" + this.dGx);
                    m((String)this.mS.get(m), m + 1, SVHwEncoder.c(SVHwEncoder.this), SVHwEncoder.d(SVHwEncoder.this));
                    this.dGx += 1;
                    m += 1;
                  }
                }
                SVHwEncoder.this.hq("hw_video_segment_notify_msg", "svSegmentOK:[new]mCallSegmentIndex=" + this.dGx);
                m(this.bYI, this.dGw, SVHwEncoder.c(SVHwEncoder.this), SVHwEncoder.d(SVHwEncoder.this));
                this.mS.add(this.bYI);
                this.dGx += 1;
              }
              for (;;)
              {
                if ((SVHwEncoder.b(SVHwEncoder.this)) || (pi("VideoEncodeExit[one]"))) {
                  break label4343;
                }
                PL(true);
                PL(false);
                SVHwEncoder.this.hq("hw_video_time_used_msg", "HwTimeUsed=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.toString());
                dPU();
                this.dGt = Jz();
                if (this.dGt == 0) {
                  break label4345;
                }
                js(this.dGt, 0);
                break;
                this.mS.add(this.bYI);
                SVHwEncoder.this.hq("hw_video_segment_notify_msg", "mHasCallSVThumbOk=" + this.cGE + " size=" + this.mS.size());
              }
              label4343:
              break label367;
              label4345:
              if (this.cGw)
              {
                this.dGt = JA();
                if (this.dGt != 0)
                {
                  js(this.dGt, 0);
                  break label367;
                }
              }
              this.cGt = false;
              if (this.cGw) {
                this.cGu = false;
              }
              dQc();
              this.cGA = true;
              label4405:
              if (this.cGA)
              {
                if (pi("VideoEncodeExit[two]")) {
                  break label367;
                }
                bool1 = false;
                boolean bool2 = M(SVHwEncoder.a(SVHwEncoder.this));
                if (this.cGw) {
                  bool1 = M(SVHwEncoder.b(SVHwEncoder.this));
                }
                if (SVHwEncoder.c(SVHwEncoder.this))
                {
                  if (!bool2) {
                    this.cGv = false;
                  }
                  if (!bool1) {
                    this.cGw = false;
                  }
                  if ((!this.cGv) && (!this.cGw))
                  {
                    Qy("VideoEncodeExit[Four]startVideo=" + bool2 + " startAudio=" + bool1);
                    break label367;
                  }
                }
                if (!this.cGv)
                {
                  bool2 = true;
                  this.cGt = true;
                  this.i = null;
                }
                if (!this.cGw)
                {
                  bool1 = true;
                  this.cGu = true;
                  this.j = null;
                }
                if ((bool2) && (bool1))
                {
                  this.cGr = false;
                  this.cGs = false;
                  this.cGB = true;
                  this.cGA = false;
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$d.printLog("releaseMuxer[mEnableEncode=true]");
                  SVHwEncoder.this.hq("hw_video_writesample", "track=" + this.outputVideoTrack);
                  SVHwEncoder.this.hq("hw_audio_writesample", "track=" + this.outputAudioTrack);
                  SVHwEncoder.this.hq("hw_video_timestamp", "new segment");
                  SVHwEncoder.this.hq("hw_audio_timestamp", "new segment");
                  label4713:
                  if ((this.cGq) || ((this.i == null) && (this.cGv)) || ((this.j == null) && (this.cGw))) {
                    break;
                  }
                  this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
                }
              }
              try
              {
                this.jdField_b_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.bYI, 0);
                this.jdField_b_of_type_AndroidMediaMediaMuxer.setOrientationHint(SVHwEncoder.e(SVHwEncoder.this));
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alv = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
                if (this.dGt != 0)
                {
                  js(this.dGt, 0);
                  break label367;
                  this.cGB = false;
                  break label4713;
                  if (!SVHwEncoder.c(SVHwEncoder.this)) {
                    break label4713;
                  }
                  m = 0;
                  n = SVHwEncoder.this.t(SVHwEncoder.a(SVHwEncoder.this));
                  if (this.cGw) {
                    m = SVHwEncoder.this.t(SVHwEncoder.b(SVHwEncoder.this));
                  }
                  Qy("VideoEncodeExit[three]videoSize=" + n + " audioSize=" + m);
                  if (((n > 0) || (m > 0)) && ((!this.cGw) || (m > 0) || (!this.cGt) || (n > 3))) {
                    break label4713;
                  }
                  if (n > 0)
                  {
                    SVHwEncoder.this.hq("VideoEncodeExit[three]", "videoSize=" + n + " mVideoEncodeDone=" + this.cGt);
                    SVHwEncoder.this.eU(SVHwEncoder.a(SVHwEncoder.this));
                  }
                  Qy("VideoEncodeExit[three]");
                  SVHwEncoder.this.dPR();
                }
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  localIOException.printStackTrace();
                  this.jdField_b_of_type_AndroidMediaMediaMuxer = null;
                  this.cGq = false;
                  this.dGt = -11;
                }
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
                if (this.i != null)
                {
                  this.outputVideoTrack = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.i);
                  SVHwEncoder.this.hq("hw_media_muxer_seg", "adding video track:outputVideoTrack=" + this.outputVideoTrack);
                }
                if (this.j != null)
                {
                  this.outputAudioTrack = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.j);
                  SVHwEncoder.this.hq("hw_media_muxer_seg", " adding audio track:outputAudioTrack=" + this.outputAudioTrack);
                }
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alw = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
                SVHwEncoder.this.hq("hw_media_muxer_seg", "starting......");
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.dQd();
                this.jdField_b_of_type_AndroidMediaMediaMuxer.start();
                this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.alx = this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode$b.gX();
                this.cGq = true;
              }
            }
            break;
            label5224:
            dJW();
            break label485;
            label5231:
            SVHwEncoder.this.hq("hw_av_merge_segment", "begin merge segments.");
            dPY();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            long l2;
            continue;
            label5256:
            long l1 = l2;
            continue;
            label5263:
            l1 = l2;
          }
        }
      }
    }
    
    float x(int paramInt)
    {
      int m = SVHwEncoder.h(SVHwEncoder.this);
      int n = SVHwEncoder.i(SVHwEncoder.this);
      int i1 = SVHwEncoder.j(SVHwEncoder.this);
      return paramInt * 1000.0F / (m * n * i1);
    }
    
    String zT()
    {
      return this.cef + "shortvideo_merge.mp4";
    }
    
    class a
      extends AsyncTask<Void, Void, Integer>
    {
      a() {}
      
      protected Integer a(Void... paramVarArgs)
      {
        long l = System.currentTimeMillis();
        paramVarArgs = SVHwEncoder.HwEncode.a(SVHwEncoder.HwEncode.this) + "shortvideo_thumb.jpg";
        int j = SVHwEncoder.HwEncode.this.a.a(SVHwEncoder.HwEncode.b(SVHwEncoder.HwEncode.this), SVHwEncoder.f(SVHwEncoder.this), SVHwEncoder.g(SVHwEncoder.this), SVHwEncoder.a(SVHwEncoder.this), SVHwEncoder.b(SVHwEncoder.this), paramVarArgs);
        int i = j;
        String str;
        if (j == 0)
        {
          str = ShortVideoUtils.bw(SVHwEncoder.HwEncode.this.a.aIf, "jpg");
          if (!aqhq.rename(paramVarArgs, str)) {
            break label177;
          }
          SVHwEncoder.HwEncode.this.a.atY = str;
          i = j;
        }
        for (;;)
        {
          SVHwEncoder.HwEncode.this.a.alE = (System.currentTimeMillis() - l);
          SVHwEncoder.HwEncode.this.a.mErrCode = i;
          SVHwEncoder.HwEncode.a(SVHwEncoder.HwEncode.this, true);
          return Integer.valueOf(i);
          label177:
          i = j;
          if (!aqhq.fileExistsAndNotEmpty(str))
          {
            SVHwEncoder.this.hq("doInBackground()", "rename failure, mThumbFilePath = " + paramVarArgs + ",thumbPath=" + str);
            i = -3;
          }
        }
      }
    }
    
    class b
    {
      long alA = 9223372036854775807L;
      long alB = 0L;
      long alj;
      long alk;
      long all;
      long alm;
      long aln;
      long alo;
      long alp;
      long alq;
      long alr;
      long als;
      long alt;
      long alu;
      long alv;
      long alw;
      long alx;
      long aly = 9223372036854775807L;
      long alz = 0L;
      long[] ax = new long[3];
      long[] ay = new long[3];
      int dGF = 0;
      int dGG = 0;
      int dGH = 0;
      int dGI = 0;
      long mStartTime;
      
      b() {}
      
      void PM(boolean paramBoolean)
      {
        if ((paramBoolean) && (this.dGF < 3))
        {
          arrayOfLong = this.ax;
          i = this.dGF;
          this.dGF = (i + 1);
          arrayOfLong[i] = System.currentTimeMillis();
        }
        while (this.dGG >= 3) {
          return;
        }
        long[] arrayOfLong = this.ay;
        int i = this.dGG;
        this.dGG = (i + 1);
        arrayOfLong[i] = System.currentTimeMillis();
      }
      
      void PN(boolean paramBoolean)
      {
        if ((paramBoolean) && (this.dGH < 3))
        {
          this.ax[this.dGH] = (System.currentTimeMillis() - this.ax[this.dGH]);
          this.dGH += 1;
          if (this.dGH == 3)
          {
            SVHwEncoder.this.hq("hw_video_time_used_msg", "videoEncodeTime:cnt20=" + this.ax[0] + " cnt1=" + this.ax[1] + " cnt2" + this.ax[2]);
            this.ax[0] = ((this.ax[0] + this.ax[1] + this.ax[2]) / 3L * 1000L / 2L);
            SVHwEncoder.this.hq("hw_video_time_used_msg", "videoEncodeTime:timeout=" + this.ax[0]);
          }
        }
        do
        {
          do
          {
            return;
          } while (this.dGI >= 3);
          this.ay[this.dGI] = (System.currentTimeMillis() - this.ay[this.dGI]);
          this.dGI += 1;
        } while (this.dGI != 3);
        SVHwEncoder.this.hq("hw_video_time_used_msg", "audioEncodeTime:cnt20=" + this.ay[0] + " cnt1=" + this.ay[1] + " cnt2" + this.ay[2]);
        this.ay[0] = ((this.ay[0] + this.ay[1] + this.ay[2]) / 3L * 1000L / 2L);
        SVHwEncoder.this.hq("hw_video_time_used_msg", "audioEncodeTime:timeout=" + this.ay[0]);
      }
      
      void PO(boolean paramBoolean)
      {
        long l = gX();
        if (paramBoolean)
        {
          if (l > this.alz) {
            this.alz = l;
          }
          if (l < this.aly) {
            this.aly = l;
          }
        }
        do
        {
          return;
          if (l > this.alB) {
            this.alB = l;
          }
        } while (l >= this.alA);
        this.alA = l;
      }
      
      void dQd()
      {
        this.mStartTime = System.currentTimeMillis();
      }
      
      long gX()
      {
        return System.currentTimeMillis() - this.mStartTime;
      }
      
      long gY()
      {
        if (this.dGH < 3) {
          return 0L;
        }
        return this.ax[0];
      }
      
      long gZ()
      {
        if (this.dGI < 3) {
          return 0L;
        }
        return this.ay[0];
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mThumbGen=").append(this.alt).append(" ");
        localStringBuilder.append("mThumbGenFunc=").append(this.alu).append(" ");
        localStringBuilder.append("mMuxerCreate=").append(this.alv).append(" ");
        localStringBuilder.append("mMuxerAdd=").append(this.alw).append(" ");
        localStringBuilder.append("mMuxerStart=").append(this.alx).append(" ");
        localStringBuilder.append("mWriteVideoMax=").append(this.alz).append(" ");
        localStringBuilder.append("mWriteVideoMIn=").append(this.aly).append(" ");
        localStringBuilder.append("mWriteAudioMax=").append(this.alB).append(" ");
        localStringBuilder.append("mWriteAudioMIn=").append(this.alA).append(" ");
        localStringBuilder.append("vConfig=").append(this.alj).append(" ");
        localStringBuilder.append("vInit=").append(this.alk).append(" ");
        localStringBuilder.append("vStart=").append(this.all).append(" ");
        localStringBuilder.append("vStop=").append(this.alm).append(" ");
        localStringBuilder.append("vRelease=").append(this.aln).append(" ");
        localStringBuilder.append("aConfig=").append(this.alo).append(" ");
        localStringBuilder.append("aInit=").append(this.alp).append(" ");
        localStringBuilder.append("aStart=").append(this.alq).append(" ");
        localStringBuilder.append("aStop=").append(this.alr).append(" ");
        localStringBuilder.append("aRelease=").append(this.als).append(" ");
        return localStringBuilder.toString();
      }
    }
    
    class c
    {
      int dGJ = 0;
      int dGK = 0;
      
      c() {}
    }
    
    class d
    {
      long alC;
      long alD;
      boolean cGG;
      boolean cGH;
      boolean cGI;
      boolean cGJ;
      boolean cGK;
      boolean cGL;
      boolean cGM;
      int dGL;
      int dGM;
      
      d() {}
      
      boolean axi()
      {
        SVHwEncoder.this.hq("releaseMuxer[audioSpecOK]", "mNeedEncodeAudio=" + SVHwEncoder.HwEncode.a(SVHwEncoder.HwEncode.this) + " mAudioConfigOK=" + this.cGK);
        if (SVHwEncoder.HwEncode.a(SVHwEncoder.HwEncode.this)) {
          return this.cGK;
        }
        return true;
      }
      
      boolean axj()
      {
        SVHwEncoder.this.hq("releaseMuxer[videoSpecOK]", "mNeedEncodeVideo=" + SVHwEncoder.HwEncode.b(SVHwEncoder.HwEncode.this) + " mVideoConfigOK=" + this.cGJ);
        return (!SVHwEncoder.HwEncode.b(SVHwEncoder.HwEncode.this)) || ((this.cGG) && (this.cGH) && (this.cGI) && (this.cGJ) && (!this.cGL));
      }
      
      boolean axk()
      {
        return (axi()) && (axj());
      }
      
      void dQe()
      {
        printLog("releaseMuxer[resetValidData]");
        this.cGG = false;
        this.cGH = false;
        this.cGI = false;
        this.cGJ = false;
        this.cGK = false;
        this.cGL = false;
        this.cGM = false;
        this.dGL = 0;
        this.dGM = 0;
        this.alC = 0L;
        this.alD = 0L;
      }
      
      void h(MediaFormat paramMediaFormat)
      {
        if ((paramMediaFormat.containsKey("csd-0")) && (paramMediaFormat.containsKey("csd-1"))) {
          this.cGJ = true;
        }
      }
      
      void i(MediaFormat paramMediaFormat)
      {
        if (paramMediaFormat.containsKey("csd-0")) {
          this.cGK = true;
        }
      }
      
      boolean o(long paramLong, boolean paramBoolean)
      {
        boolean bool2 = true;
        boolean bool1 = true;
        if (paramBoolean)
        {
          if (this.alC <= paramLong) {
            break label83;
          }
          this.cGL = true;
          this.dGL += 1;
        }
        label83:
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          this.alC = paramLong;
          return paramBoolean;
          if (this.alD > paramLong)
          {
            this.cGM = true;
            this.dGM += 1;
          }
          for (paramBoolean = bool2;; paramBoolean = false)
          {
            this.alD = paramLong;
            return paramBoolean;
          }
        }
      }
      
      void printLog(String paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SVHwEncoder", 2, paramString + ": mHasKeyFrame=" + this.cGG + " mVideoFirst=" + this.cGH + " mFirstIsKey=" + this.cGI + " mVideoConfigOK=" + this.cGJ + " mAudioConfigOK=" + this.cGK + " mVideoMuxeredframeCount=" + SVHwEncoder.HwEncode.a(SVHwEncoder.HwEncode.this) + " mAudioMuxeredframeCount=" + SVHwEncoder.HwEncode.b(SVHwEncoder.HwEncode.this) + " mVideoOrderError=" + this.cGL + " mAudioOrderError=" + this.cGM + " mVideoOrderErrorCnt=" + this.dGL + " mAudioOrderErrorCnt=" + this.dGM);
        }
      }
    }
  }
  
  public static class a
  {
    public int bitrate;
    public byte[] data;
    public boolean finish;
    public boolean isVideo;
    public int offset;
    public int size;
    public long time;
    public float zI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder
 * JD-Core Version:    0.7.0.1
 */