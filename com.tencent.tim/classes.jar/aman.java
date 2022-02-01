import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

@TargetApi(18)
public class aman
{
  private String JV;
  private amae jdField_a_of_type_Amae;
  private amaf jdField_a_of_type_Amaf;
  private amam jdField_a_of_type_Amam;
  protected aman.a a;
  private amap jdField_a_of_type_Amap;
  private amag jdField_b_of_type_Amag;
  private amal jdField_b_of_type_Amal;
  private boolean cBL;
  private boolean cBM;
  private boolean cBN;
  private volatile boolean dp;
  private HandlerThread n = new HandlerThread("recode_thread");
  
  public aman()
  {
    this.n.start();
    this.jdField_a_of_type_Aman$a = a(this.n.getLooper());
    this.jdField_b_of_type_Amag = new amag();
    this.jdField_a_of_type_Amaf = new amaf();
    this.jdField_a_of_type_Amap = new amap();
  }
  
  private void a(aman.b paramb)
  {
    this.jdField_b_of_type_Amal = paramb.c;
    this.jdField_a_of_type_Amam = paramb.b;
    paramb = paramb.d;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramb.a());
    }
    if (this.dp) {
      awn();
    }
    this.dp = true;
    this.jdField_a_of_type_Amae = paramb;
    this.JV = paramb.outputFilePath;
    try
    {
      this.jdField_b_of_type_Amag.a(paramb);
      this.jdField_a_of_type_Amaf.a(paramb, this.jdField_b_of_type_Amag.getInputSurface());
      if (this.jdField_b_of_type_Amal != null) {
        this.jdField_b_of_type_Amal.auv();
      }
      this.cBL = true;
      this.cBM = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramb, localThrowable);
      }
      if (this.jdField_b_of_type_Amal != null) {
        this.jdField_b_of_type_Amal.a(1, localThrowable);
      }
      this.dp = false;
    }
  }
  
  private void awn()
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording");
    }
    if (this.dp) {
      this.dp = false;
    }
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_b_of_type_Amag.stop();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_b_of_type_Amal != null) && (this.jdField_a_of_type_Amae.a == null))
        {
          this.jdField_b_of_type_Amal.kf(this.JV);
          this.jdField_b_of_type_Amal = null;
        }
        this.jdField_a_of_type_Amaf.release();
        this.jdField_a_of_type_Amam = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Amae);
        }
        if (this.jdField_b_of_type_Amal != null) {
          this.jdField_b_of_type_Amal.a(2, localException);
        }
        this.jdField_b_of_type_Amag.release();
        this.jdField_a_of_type_Amaf.release();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  @NonNull
  protected aman.a a(Looper paramLooper)
  {
    return new aman.a(paramLooper, this);
  }
  
  public void a(amae paramamae, amal paramamal)
  {
    a(paramamae, paramamal, null);
  }
  
  public void a(amae paramamae, amal paramamal, amam paramamam)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramamae.a());
    }
    if (this.cBN) {
      this.jdField_a_of_type_Amap.init(paramamae.width, paramamae.height);
    }
    Message localMessage = Message.obtain();
    aman.b localb = new aman.b(null);
    localb.c = paramamal;
    localb.b = paramamam;
    localb.d = paramamae;
    localMessage.obj = localb;
    localMessage.what = 0;
    this.jdField_a_of_type_Aman$a.sendMessage(localMessage);
  }
  
  public void dLX()
  {
    this.cBN = true;
  }
  
  public void f(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "frameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    if (this.cBN) {}
    for (boolean bool = this.jdField_a_of_type_Amap.la(paramInt2);; bool = false)
    {
      if ((!this.cBN) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Aman$a.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Aman$a.removeMessages(2);
    }
  }
  
  public void g(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Amae.a());
    }
    if (!this.dp) {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoRecorder", 2, "handleFrameAvailable mIsRecording = " + this.dp);
      }
    }
    label304:
    do
    {
      return;
      for (;;)
      {
        try
        {
          this.jdField_b_of_type_Amag.dLU();
          if ((this.cBL) && (this.jdField_a_of_type_Amae.cBA))
          {
            this.cBL = false;
            ambf.a(paramInt2, this.jdField_a_of_type_Amae.width, this.jdField_a_of_type_Amae.height, this.jdField_a_of_type_Amae, new amao(this));
          }
          if (this.cBN)
          {
            paramInt2 = this.jdField_a_of_type_Amap.readBuffer();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Amaf.e(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.cBN) {
              this.jdField_a_of_type_Amap.bz(false, 1);
            }
            if (this.jdField_b_of_type_Amal == null) {
              break;
            }
            this.jdField_b_of_type_Amal.btD();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Amae, paramArrayOfFloat1);
          }
          if (this.jdField_b_of_type_Amal != null) {
            this.jdField_b_of_type_Amal.a(2, paramArrayOfFloat1);
          }
          this.jdField_b_of_type_Amag.release();
          this.jdField_a_of_type_Amaf.release();
          this.dp = false;
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HWVideoRecorder", 2, new Object[] { "ignore frame: ", Long.valueOf(paramLong) });
  }
  
  public MediaFormat getMediaFormat()
  {
    if (this.jdField_b_of_type_Amag != null) {
      return this.jdField_b_of_type_Amag.d;
    }
    return null;
  }
  
  public boolean isFinished()
  {
    return !this.dp;
  }
  
  public void release()
  {
    if (this.n != null)
    {
      this.n.quitSafely();
      this.n = null;
    }
    this.jdField_b_of_type_Amal = null;
    this.jdField_a_of_type_Amam = null;
    this.jdField_a_of_type_Amae = null;
  }
  
  public void stopRecording()
  {
    if (this.cBN) {
      this.jdField_a_of_type_Amap.destroy();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Aman$a.sendMessage(localMessage);
  }
  
  public class a
    extends Handler
  {
    protected WeakReference<aman> bJ;
    
    public a(Looper paramLooper, aman paramaman)
    {
      super();
      this.bJ = new WeakReference(paramaman);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      aman localaman = (aman)this.bJ.get();
      if (localaman == null) {
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
        }
      }
      label187:
      do
      {
        do
        {
          return;
          switch (i)
          {
          default: 
            throw new RuntimeException("Unhandled msg what=" + i);
          case 0: 
            if (paramMessage.obj != null)
            {
              aman.a(localaman, (aman.b)paramMessage.obj);
              return;
            }
            throw new RuntimeException("bundle == null");
          case 1: 
            if ((aman.a(aman.this)) || (aman.a(aman.this) == null) || (!aman.a(aman.this).cBA)) {
              break label187;
            }
            sendEmptyMessageDelayed(1, 100L);
          }
        } while ((!QLog.isColorLevel()) || (!QLog.isColorLevel()));
        QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
        return;
        aman.a(localaman);
        return;
        if (paramMessage.obj != null)
        {
          paramMessage = (Object[])paramMessage.obj;
          if ((paramMessage == null) || (paramMessage.length != 5)) {
            throw new IllegalArgumentException("args == null || args.length != 6");
          }
          localaman.g(((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
          return;
        }
        throw new RuntimeException("bundle == null");
      } while (aman.a(aman.this) == null);
      aman.a(aman.this).dLW();
    }
  }
  
  class b
  {
    amam b;
    amal jdField_c_of_type_Amal;
    amae d;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aman
 * JD-Core Version:    0.7.0.1
 */