import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.a;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class mqs
  extends AsyncTask<String, Void, Integer>
{
  private Long A = Long.valueOf(0L);
  private Long B = Long.valueOf(0L);
  private Long C = Long.valueOf(0L);
  private Long D = Long.valueOf(0L);
  private String Dh;
  private String Ka;
  mqs.b a;
  private String ajy;
  private boolean anf;
  private boolean ang;
  private Context mContext;
  private int outHeight;
  private int outWidth;
  private String outputPath;
  private long wj;
  private long wk;
  
  public mqs(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, mqs.b paramb)
  {
    this.mContext = paramContext;
    this.anf = paramBoolean1;
    this.ang = paramBoolean2;
    this.a = paramb;
  }
  
  private static int S(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i;
    if (paramInt1 <= paramInt2)
    {
      i = kwt.aMl;
      paramInt1 = awit.B(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 <= 0) {
        break label80;
      }
      i = paramInt1;
    }
    label80:
    for (;;)
    {
      if (paramInt2 >= 1280) {
        paramInt1 = j;
      }
      for (;;)
      {
        float f = i * 1.0F / 640.0F;
        return (int)(paramInt1 * f);
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960) {
          paramInt1 = 960;
        } else {
          paramInt1 = 640;
        }
      }
    }
  }
  
  private HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str2 = ShortVideoUtils.by(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    ShortVideoTrimmer.a locala = ShortVideoTrimmer.a(paramString);
    long l1;
    int i;
    if ((locala != null) && (locala.cHR))
    {
      l1 = new File(paramString).length();
      i = S(locala.srcWidth, locala.srcHeight);
      if ((l1 <= 52428800L) && (i > 0) && (locala.alX * 1024L / i < 1.3D))
      {
        locala.cHR = false;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, fileSize:" + l1 + ", no need compress!");
        }
      }
    }
    Object localObject1;
    Object localObject2;
    long l2;
    if ((locala != null) && (locala.cHR)) {
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject1 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject1).setDataSource(paramString);
        localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(9);
        ((MediaMetadataRetriever)localObject1).release();
        l2 = 0L;
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        i = anig.az(paramContext);
        if (((i & 0x1) > 0) && ((i & 0x2) > 0))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
          }
          if (!bool) {
            break label562;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
          }
          localObject1 = new File(paramString);
          localObject2 = new mqs.a(str2, (int)(locala.alX * 1024L), (int)locala.alW, 0L, l1);
          if ((!new anli().a((File)localObject1, (anli.a)localObject2, true)) || (((mqs.a)localObject2).e != null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
          }
          j = 0;
          i = j;
          localObject1 = str2;
          if (j != 0)
          {
            i = j;
            localObject1 = str2;
            if (!TextUtils.isEmpty(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
              }
              i = ShortVideoTrimmer.f(paramContext, paramString, str2);
              localObject1 = str2;
            }
          }
          localHashMap.put("outputPath", localObject1);
          localHashMap.put("ret", String.valueOf(i));
          if (locala != null)
          {
            j = 0;
            if ((!"90".equals(locala.rotate)) && (!"270".equals(locala.rotate))) {
              break label589;
            }
            i = 1;
            if (i == 0) {
              break label652;
            }
            localHashMap.put("outWidth", String.valueOf(locala.dJp));
            localHashMap.put("outHeight", String.valueOf(locala.dJo));
          }
          return localHashMap;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localNumberFormatException.printStackTrace();
        l1 = l2;
        continue;
        boolean bool = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr");
        }
      }
      label562:
      int j = -1;
      continue;
      String str1;
      if ((locala != null) && (!locala.cHR))
      {
        i = 0;
        str1 = paramString;
        continue;
        label589:
        i = j;
        if ("0".equals(locala.rotate))
        {
          paramString = ShortVideoTrimmer.o(paramString);
          i = j;
          if (paramString != null)
          {
            i = j;
            if (paramString.length == 5) {
              if (paramString[3] != 90)
              {
                i = j;
                if (paramString[3] != 270) {}
              }
              else
              {
                i = 1;
                continue;
                label652:
                localHashMap.put("outWidth", String.valueOf(locala.dJo));
                localHashMap.put("outHeight", String.valueOf(locala.dJp));
                return localHashMap;
              }
            }
          }
        }
      }
      else
      {
        i = -1;
        str1 = str2;
      }
    }
  }
  
  private void sk(int paramInt)
  {
    this.wk = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("video_size_before_compression", this.A.toString());
    localHashMap.put("source_video_bitrate", this.C.toString());
    localHashMap.put("target_video_bitrate", this.D.toString());
    anpc localanpc = anpc.a(this.mContext);
    String str = kxm.getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyDeliverVideoCompressVideo", bool, this.wk - this.wj, 0L, localHashMap, "");
      return;
    }
  }
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    int j = 1;
    paramVarArgs = paramVarArgs[0];
    this.a.O(0.0F);
    if ((TextUtils.isEmpty(paramVarArgs)) || (this.mContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, "error params");
      }
      return Integer.valueOf(-1);
    }
    this.Ka = paramVarArgs;
    File localFile = new File(this.Ka);
    Object localObject = ShortVideoTrimmer.a(this.Ka);
    if (localObject != null)
    {
      i = S(((ShortVideoTrimmer.a)localObject).srcWidth, ((ShortVideoTrimmer.a)localObject).srcHeight);
      this.C = Long.valueOf(((ShortVideoTrimmer.a)localObject).alX);
      this.D = Long.valueOf(i);
      if ((i <= 0) || (((ShortVideoTrimmer.a)localObject).alX * 1024L / i <= 1.3D)) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((localFile.exists()) && (localFile.length() <= 52428800L) && (i == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "file:" + paramVarArgs + ", size:" + localFile.length() + ", no need compress");
        }
        this.outputPath = this.Ka;
        if (localObject != null)
        {
          i = j;
          if (!"90".equals(((ShortVideoTrimmer.a)localObject).rotate))
          {
            if (!"270".equals(((ShortVideoTrimmer.a)localObject).rotate)) {
              break label290;
            }
            i = j;
          }
          if (i == 0) {
            break label345;
          }
          this.outWidth = ((ShortVideoTrimmer.a)localObject).srcHeight;
        }
        for (this.outHeight = ((ShortVideoTrimmer.a)localObject).srcWidth;; this.outHeight = ((ShortVideoTrimmer.a)localObject).srcHeight)
        {
          return Integer.valueOf(0);
          label290:
          if ("0".equals(((ShortVideoTrimmer.a)localObject).rotate))
          {
            paramVarArgs = ShortVideoTrimmer.o(paramVarArgs);
            if ((paramVarArgs != null) && (paramVarArgs.length == 5))
            {
              i = j;
              if (paramVarArgs[3] == 90) {
                break;
              }
              i = j;
              if (paramVarArgs[3] == 270) {
                break;
              }
            }
          }
          i = 0;
          break;
          label345:
          this.outWidth = ((ShortVideoTrimmer.a)localObject).srcWidth;
        }
      }
      localObject = new File(acbn.SDCARD_PATH + "shortvideo");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      long l2 = System.currentTimeMillis();
      if (ShortVideoTrimmer.b(this.mContext, 0, 0))
      {
        i = paramVarArgs.lastIndexOf(".");
        if (i == -1) {
          return Integer.valueOf(-1);
        }
        this.outputPath = ShortVideoUtils.by(paramVarArgs, paramVarArgs.substring(i + 1));
        localObject = a(paramVarArgs, this.mContext);
        i = Integer.parseInt((String)((HashMap)localObject).get("ret"));
        this.outputPath = ((String)((HashMap)localObject).get("outputPath"));
        this.outWidth = Integer.parseInt((String)((HashMap)localObject).get("outWidth"));
        this.outHeight = Integer.parseInt((String)((HashMap)localObject).get("outHeight"));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "Before Compress file:" + paramVarArgs + ", after Compress file:" + this.outputPath);
        }
        long l3 = System.currentTimeMillis();
        long l4 = new File(paramVarArgs).length();
        long l1 = 0L;
        if (!TextUtils.isEmpty(this.outputPath)) {
          l1 = new File(this.outputPath).length();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + i + ", cost:" + (l3 - l2) + "ms, fileSourceSize=" + l4 + ", fileTargetSize=" + l1);
        }
        this.A = Long.valueOf(l4);
        this.B = Long.valueOf(l1);
        return Integer.valueOf(i);
      }
      return Integer.valueOf(-1);
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int i;
    if (paramInteger.intValue() != 0) {
      if (!this.anf)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, not support shortvideo so");
        }
        if (this.a != null) {
          this.a.a(1, this.A.longValue(), this.B.longValue(), null, null, 0L);
        }
        i = 1004;
      }
    }
    for (;;)
    {
      sk(i);
      return;
      if (!this.ang)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, shortvideo so not ready");
        }
        if (this.a != null) {
          this.a.a(2, this.A.longValue(), this.B.longValue(), null, null, 0L);
        }
        i = 1004;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (this.a != null) {
          this.a.a(3, this.A.longValue(), this.B.longValue(), null, null, 0L);
        }
        i = 1004;
        continue;
        if (TextUtils.isEmpty(this.outputPath)) {}
        for (paramInteger = this.Ka;; paramInteger = this.outputPath)
        {
          this.Dh = paramInteger;
          paramInteger = MD5.getFileMd5(this.Dh);
          if (paramInteger != null) {
            this.ajy = new String(paramInteger);
          }
          long l = new File(this.Dh).length();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, finalSize:" + l);
          }
          if (l <= 314572800L) {
            break label382;
          }
          if (this.a != null) {
            this.a.a(4, this.A.longValue(), this.B.longValue(), this.Dh, this.ajy, this.C.longValue());
          }
          i = 1005;
          break;
        }
        label382:
        if (this.a != null) {
          this.a.a(0, this.A.longValue(), this.B.longValue(), this.Dh, this.ajy, this.D.longValue());
        }
        i = 0;
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.wj = System.currentTimeMillis();
  }
  
  class a
    implements anli.a
  {
    final String JV;
    final int agS;
    final int agT;
    Throwable e;
    final long mEndTime;
    final long mStartTime;
    
    a(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      this.JV = paramString;
      this.agS = paramInt1;
      this.mStartTime = paramLong1;
      this.mEndTime = paramLong2;
      if (paramInt2 > 0) {}
      for (this.agT = paramInt2;; this.agT = 30)
      {
        this.e = null;
        if (paramString == null) {}
        return;
      }
    }
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      int j = 1280;
      anli.b localb = new anli.b();
      Object localObject;
      int i;
      if (paramInt1 <= paramInt2)
      {
        localObject = new File(this.JV);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localb.as = ((File)localObject);
        i = kwt.aMl;
        paramInt1 = awit.B(BaseApplicationImpl.getApplication().getRuntime());
        if (paramInt1 > 0) {
          i = paramInt1;
        }
        if (paramInt2 < 1280) {
          break label307;
        }
        localObject = "720p";
        paramInt1 = j;
        label87:
        localb.videoBitRate = ((int)(i * 1.0F / 640.0F * paramInt1));
        localb.scaleRate = (paramInt1 / paramInt2);
        if (this.agT > 30) {
          break label336;
        }
      }
      label307:
      label336:
      for (j = this.agT;; j = 30)
      {
        localb.videoFrameRate = j;
        localb.cHX = rk();
        localb.beginTime = this.mStartTime;
        localb.endTime = this.mEndTime;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n quality:" + (String)localObject + ", sourceLongEdge:" + paramInt2 + ", targetLongEdge:" + paramInt1 + ", scaleRate:" + localb.scaleRate + "\n defaultBitRate:" + i + ", videoBitRate:" + localb.videoBitRate + ", videoFrameRate:" + localb.videoFrameRate + "\n setRotation:" + localb.cHX + ", beginTime:" + localb.beginTime + ", endTime:" + localb.endTime);
        }
        return localb;
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960)
        {
          localObject = "640p";
          paramInt1 = 960;
          break label87;
        }
        paramInt1 = 640;
        localObject = "480p";
        break label87;
      }
    }
    
    public void ahK() {}
    
    public void f(Throwable paramThrowable)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
      this.e = paramThrowable;
    }
    
    public void onCanceled() {}
    
    public void onProgress(int paramInt)
    {
      if ((mqs.this.a != null) && (!mqs.this.isCancelled())) {
        mqs.this.a.O(paramInt / 100.0F);
      }
    }
    
    public boolean rk()
    {
      boolean bool = false;
      if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
        bool = true;
      }
      while (Build.VERSION.SDK_INT <= 19) {
        return bool;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void O(float paramFloat);
    
    public abstract void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqs
 * JD-Core Version:    0.7.0.1
 */