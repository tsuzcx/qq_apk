import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.voicechange.VoiceChange;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

public class aliu
  implements aliw
{
  aliy a;
  public int duF;
  FileOutputStream k;
  String mPath;
  int mSampleRate;
  
  public void a(aliv paramaliv, aliv.a parama) {}
  
  public boolean a(Context paramContext, String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    try
    {
      this.a = new aliy();
      if (paramInt != 0) {
        this.a.a(new VoiceChange(paramContext, paramInt, paramString2));
      }
      if (paramRecorderParam.mAudioType == 0) {
        this.a.a(new AmrInputStreamWrapper(paramContext));
      }
      for (;;)
      {
        this.a.init(paramRecorderParam.mSampleRate, paramRecorderParam.mBitRate, paramRecorderParam.mAudioType);
        this.mSampleRate = paramRecorderParam.mSampleRate;
        this.a.a(this);
        this.duF = 0;
        this.mPath = paramString1;
        paramContext = new File(this.mPath);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        paramContext.createNewFile();
        this.k = new FileOutputStream(paramContext);
        paramContext = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
        this.k.write(paramContext, 0, paramContext.length);
        this.k.flush();
        return true;
        this.a.a(new SilkCodecWrapper(paramContext));
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void b(aliv paramaliv, aliv.a parama)
  {
    if (((paramaliv instanceof SilkCodecWrapper)) || ((paramaliv instanceof AmrInputStreamWrapper))) {
      this.duF += (int)QQRecorder.a(this.mSampleRate, 4, 2, parama.size);
    }
  }
  
  public boolean d(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.a != null)
      {
        paramArrayOfByte = this.a.a(paramArrayOfByte, 0, paramInt);
        if (paramArrayOfByte != null) {
          this.k.write(paramArrayOfByte.data, 0, paramArrayOfByte.size);
        }
      }
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("PttPreSendManager", 4, "handleSliceDataIfNeed exception !!!");
      }
    }
    return false;
  }
  
  public void deleteFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttPreSendManager", 2, "delete tempfile, path : " + this.mPath);
    }
    if (!TextUtils.isEmpty(this.mPath))
    {
      File localFile = new File(this.mPath);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public int getPlayTime()
  {
    return this.duF;
  }
  
  public void release()
  {
    try
    {
      if (this.k != null)
      {
        this.k.close();
        this.k = null;
      }
      if (this.a != null)
      {
        this.a.release();
        this.a = null;
      }
      this.mSampleRate = 0;
      this.duF = 0;
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("PttPreSendManager", 2, "PttPreVoiceChanger.close error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aliu
 * JD-Core Version:    0.7.0.1
 */