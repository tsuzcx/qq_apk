import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ncf
  extends AsyncTask<String, Void, Integer>
{
  private String Dh;
  private ncf.b a;
  private String ale;
  private anli jdField_b_of_type_Anli;
  private nch jdField_b_of_type_Nch;
  private nch c;
  private Context mContext;
  private String mOutputPath;
  private long wj;
  private long wk;
  
  public ncf(Context paramContext, ncf.b paramb)
  {
    this.mContext = paramContext;
    this.a = paramb;
  }
  
  private int a(Context paramContext, String paramString1, nch paramnch, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      int i = anig.az(paramContext);
      if (((i & 0x1) > 0) && ((i & 0x2) > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: isHWCodecSupported = " + bool);
        }
        if (!bool) {
          break label198;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
        }
        paramContext = new File(paramString1);
        paramString1 = new ncf.a(paramString2, (int)(paramnch.bitrate * 1024L), (int)paramnch.xk, 0L, paramnch.duration);
        this.jdField_b_of_type_Anli = new anli();
        if ((!this.jdField_b_of_type_Anli.a(paramContext, paramString1, true)) || (paramString1.exception != null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
        }
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodecr", paramString1.exception);
      }
      return -4;
    }
    return -2;
    label198:
    return -4;
  }
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    this.a.O(0.0F);
    if (TextUtils.isEmpty(paramVarArgs))
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, sdk version too low: " + Build.VERSION.SDK_INT);
      return Integer.valueOf(-2);
    }
    this.ale = paramVarArgs;
    this.jdField_b_of_type_Nch = nch.a(this.ale);
    if (this.jdField_b_of_type_Nch == null)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, retrive mSourceMediaInfo failed! ");
      return Integer.valueOf(-3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: retrive mSourceMediaInfo = " + this.jdField_b_of_type_Nch);
    }
    if (!ncg.a(this.jdField_b_of_type_Nch))
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, no need compress! ");
      return Integer.valueOf(-5);
    }
    long l1 = System.currentTimeMillis();
    File localFile = new File(ncg.kD());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    int i = this.ale.lastIndexOf(".");
    if (i == -1)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    this.mOutputPath = ncg.X(paramVarArgs, paramVarArgs.substring(i + 1));
    i = a(this.mContext, this.ale, this.jdField_b_of_type_Nch, this.mOutputPath);
    if (i == 0) {
      this.c = nch.a(this.mOutputPath);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask run finish! compress ret = " + i + ", cost:" + (l2 - l1) + "ms, mTargetMdeiaInfo=" + this.c);
    }
    return Integer.valueOf(i);
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    int i = 2;
    super.onPostExecute(paramInteger);
    if (isCancelled()) {}
    label261:
    for (;;)
    {
      return;
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (paramInteger.intValue() != -2) {}
      }
      for (;;)
      {
        if (this.a == null) {
          break label261;
        }
        this.a.a(i, this.ale, this.jdField_b_of_type_Nch);
        return;
        if (paramInteger.intValue() == -3)
        {
          i = 3;
        }
        else
        {
          if (paramInteger.intValue() == -5)
          {
            i = 1;
            continue;
            this.wk = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.mOutputPath)) {}
            for (paramInteger = this.ale;; paramInteger = this.mOutputPath)
            {
              this.Dh = paramInteger;
              long l = new File(this.Dh).length();
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, finalSize:" + l);
              }
              if (l <= ncg.qq()) {
                break label232;
              }
              if (this.a == null) {
                break;
              }
              this.a.a(5, this.mOutputPath, this.c);
              return;
            }
            label232:
            if (this.a == null) {
              break;
            }
            this.a.a(0, this.mOutputPath, this.c);
            return;
          }
          i = 4;
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.wj = System.currentTimeMillis();
  }
  
  public void stopTask()
  {
    cancel(false);
    if (this.jdField_b_of_type_Anli != null)
    {
      this.jdField_b_of_type_Anli.stop();
      this.jdField_b_of_type_Anli.cancel();
    }
  }
  
  class a
    implements anli.a
  {
    final String JV;
    final int agS;
    final int agT;
    Throwable exception;
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
        this.exception = null;
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("null == outputFilePath");
      }
    }
    
    private void aVs()
    {
      File localFile = new File(this.JV);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      int i = 30;
      anli.b localb = new anli.b();
      File localFile = new File(this.JV);
      if (localFile.exists()) {
        localFile.delete();
      }
      localb.as = localFile;
      long l = ncg.e(paramInt1, paramInt2);
      int j = ncg.U(paramInt1, paramInt2);
      localb.videoBitRate = ((int)l);
      paramInt2 = Math.min(paramInt1, paramInt2);
      localb.scaleRate = (j / paramInt2);
      paramInt1 = i;
      if (this.agT <= 30) {
        paramInt1 = this.agT;
      }
      localb.videoFrameRate = paramInt1;
      localb.cHX = rk();
      localb.beginTime = this.mStartTime;
      localb.endTime = this.mEndTime;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n  sourceShortEdge:" + paramInt2 + ", dstResolution:" + j + ", scaleRate:" + localb.scaleRate + "\n  targetVideoBitRate:" + localb.videoBitRate + ", videoFrameRate:" + localb.videoFrameRate + "\n setRotation:" + localb.cHX + ", beginTime:" + localb.beginTime + ", endTime:" + localb.endTime);
      }
      return localb;
    }
    
    public void ahK() {}
    
    public void f(Throwable paramThrowable)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
      this.exception = paramThrowable;
    }
    
    public void onCanceled()
    {
      QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
      aVs();
      if (ncf.a(ncf.this) != null) {
        ncf.a(ncf.this).a(6, null, null);
      }
    }
    
    public void onProgress(int paramInt)
    {
      if ((ncf.a(ncf.this) != null) && (!ncf.this.isCancelled())) {
        ncf.a(ncf.this).O(paramInt / 100.0F);
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
    
    public abstract void a(int paramInt, String paramString, nch paramnch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncf
 * JD-Core Version:    0.7.0.1
 */