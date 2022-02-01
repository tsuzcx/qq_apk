import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

@TargetApi(18)
public class jha
{
  private String JV;
  private amae jdField_a_of_type_Amae;
  private amaf jdField_a_of_type_Amaf;
  private jgv jdField_a_of_type_Jgv;
  protected jgw a;
  private jha.a jdField_a_of_type_Jha$a;
  private int azE;
  private ByteArrayOutputStream d;
  private volatile boolean dp;
  private HandlerThread n = new HandlerThread("recode_thread");
  private long pt;
  private long pu;
  private long pv;
  
  public jha()
  {
    this.n.start();
    this.n.setPriority(10);
    this.jdField_a_of_type_Jha$a = new jha.a(this.n.getLooper(), this);
    this.jdField_a_of_type_Jgv = new jgv(this);
    this.jdField_a_of_type_Amaf = new amaf();
  }
  
  private void awn()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 1, "handleStopRecording, mPts[" + this.pv + "]");
    }
    if (this.dp) {}
    while (!QLog.isColorLevel()) {
      try
      {
        e(this.d.toByteArray(), this.pv);
        this.d.reset();
        this.jdField_a_of_type_Jgv.stop();
        this.jdField_a_of_type_Amaf.release();
        this.dp = false;
        if (this.jdField_a_of_type_Jgw != null)
        {
          this.jdField_a_of_type_Jgw.kf(this.JV);
          this.jdField_a_of_type_Jgw = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Amae);
        }
        if (this.jdField_a_of_type_Jgw != null) {
          this.jdField_a_of_type_Jgw.a(4, localException);
        }
        this.jdField_a_of_type_Jgv.release();
        this.jdField_a_of_type_Amaf.release();
        this.dp = false;
        return;
      }
    }
    QLog.w("QavVideoAudioRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2);
    }
    if (!this.dp) {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable mIsRecording = " + this.dp);
      }
    }
    for (;;)
    {
      return;
      if (this.pt < 0L) {
        this.pt = paramLong;
      }
      jgx.awj();
      if ((this.jdField_a_of_type_Jgv.Zi) && (!this.jdField_a_of_type_Jgv.mMuxerStarted) && (this.jdField_a_of_type_Jgv.xk()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
      }
      else {
        try
        {
          this.jdField_a_of_type_Jgv.awh();
          this.jdField_a_of_type_Amaf.e(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.pt);
          if (this.jdField_a_of_type_Jgw != null)
          {
            this.jdField_a_of_type_Jgw.auw();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Amae);
          }
          if (this.jdField_a_of_type_Jgw != null) {
            this.jdField_a_of_type_Jgw.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Jgv.release();
          this.jdField_a_of_type_Amaf.release();
          this.dp = false;
        }
      }
    }
  }
  
  private void b(amae paramamae)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + paramamae.a());
    }
    if (this.dp) {
      awn();
    }
    this.dp = true;
    this.pt = -1L;
    this.pu = -1L;
    this.azE = 0;
    this.d.reset();
    this.jdField_a_of_type_Amae = paramamae;
    this.JV = paramamae.outputFilePath;
    try
    {
      this.jdField_a_of_type_Jgv.a(paramamae);
      this.jdField_a_of_type_Amaf.a(paramamae, this.jdField_a_of_type_Jgv.getInputSurface());
      if (this.jdField_a_of_type_Jgw != null) {
        this.jdField_a_of_type_Jgw.auv();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramamae);
      }
      if (this.jdField_a_of_type_Jgw != null) {
        this.jdField_a_of_type_Jgw.a(1, localThrowable);
      }
      this.dp = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "videoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    this.jdField_a_of_type_Jha$a.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Jha$a.sendMessage(localMessage);
  }
  
  public void a(amae paramamae, jgw paramjgw)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + paramamae.a() + ", config=" + paramamae);
    }
    this.jdField_a_of_type_Jgw = paramjgw;
    paramjgw = Message.obtain();
    paramjgw.obj = paramamae;
    paramjgw.what = 0;
    this.jdField_a_of_type_Jha$a.sendMessage(paramjgw);
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.dp)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 1, "audioFrameAvailable, audioData[" + paramArrayOfByte.length + "], pts[" + paramLong + "], mAudioBufCount[" + this.azE + "], mPts[" + this.pv + "]");
      }
      if ((!this.jdField_a_of_type_Jgv.Zj) || (this.jdField_a_of_type_Jgv.mMuxerStarted)) {
        break label117;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
      }
    }
    for (;;)
    {
      return;
      label117:
      if (!this.jdField_a_of_type_Jgv.mMuxerStarted)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Jha$a.sendMessage(localMessage);
        return;
      }
      try
      {
        this.d.write(paramArrayOfByte);
        if (this.azE == 0) {
          this.pv = paramLong;
        }
        this.azE += 1;
        if (this.azE < 5) {
          continue;
        }
        this.azE = 0;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 3;
        paramArrayOfByte.obj = new Object[] { this.d.toByteArray(), Long.valueOf(this.pv) };
        this.jdField_a_of_type_Jha$a.sendMessage(paramArrayOfByte);
        this.d.reset();
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void e(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.pu < 0L)
      {
        this.pu = paramLong;
        QLog.w("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable, begin, mStartAudioPts[" + this.pu + "]");
      }
      this.jdField_a_of_type_Jgv.d(paramArrayOfByte, paramLong - this.pu);
      if (this.jdField_a_of_type_Jgw != null) {
        this.jdField_a_of_type_Jgw.aux();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Jgw != null) {
        this.jdField_a_of_type_Jgw.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public void onDestroy()
  {
    jha.a locala = this.jdField_a_of_type_Jha$a;
    HandlerThread localHandlerThread = this.n;
    amaf localamaf = this.jdField_a_of_type_Amaf;
    if (localHandlerThread != null) {
      locala.post(new QavVideoAudioRecorder.1(this, localamaf, localHandlerThread));
    }
  }
  
  public void stopRecording()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Jha$a.sendMessage(localMessage);
  }
  
  class a
    extends Handler
  {
    private WeakReference<jha> bJ;
    
    public a(Looper paramLooper, jha paramjha)
    {
      super();
      this.bJ = new WeakReference(paramjha);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      jha localjha = (jha)this.bJ.get();
      if (localjha == null) {
        if (QLog.isColorLevel()) {
          QLog.w("QavVideoAudioRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
        }
      }
      do
      {
        for (;;)
        {
          return;
          switch (i)
          {
          default: 
            throw new RuntimeException("Unhandled msg what=" + i);
          case 0: 
            if (jha.a(jha.this) == null) {
              jha.a(jha.this, new ByteArrayOutputStream(32768));
            }
            if (paramMessage.obj != null)
            {
              jha.a(localjha, (amae)paramMessage.obj);
              return;
            }
            throw new RuntimeException("MSG_START_RECORDING bundle == null");
          case 1: 
            jha.a(localjha);
            try
            {
              if (jha.a(jha.this) != null)
              {
                jha.a(jha.this).flush();
                jha.a(jha.this).close();
                jha.a(jha.this, null);
                return;
              }
            }
            catch (IOException paramMessage) {}
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("QavVideoAudioRecorder", 2, "AudioBuf.close() ", paramMessage);
      return;
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 5");
        }
        jha.a(localjha, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        localjha.e((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
        return;
      }
      throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jha
 * JD-Core Version:    0.7.0.1
 */