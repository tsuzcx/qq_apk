import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.ScreenRecordHelper.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;

@RequiresApi(api=21)
public class jds
{
  static final int[][] m = { { 720, 1280 }, { 1080, 1920 }, { 1080, 1920 } };
  private boolean XW;
  private boolean XX;
  private VirtualDisplay jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay;
  private iot jdField_a_of_type_Iot;
  private jds.a jdField_a_of_type_Jds$a;
  private int axp;
  private int axq;
  private int axr;
  private final itn b = new itn();
  private WeakReference<Context> mContext;
  private MediaProjection mMediaProjection;
  private MediaProjectionManager mMediaProjectionManager;
  private long mRecordTime;
  private Timer n;
  
  private void auM()
  {
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenRecordHelper", this.axq, this.axr, this.axp, 16, this.jdField_a_of_type_Iot.getSurface(), null, null);
  }
  
  private void kj(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_Jds$a != null)) {
      this.jdField_a_of_type_Jds$a.lK(1);
    }
  }
  
  public void I(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int i;
    label55:
    int i1;
    int j;
    if (this.axq < this.axr)
    {
      k = 1;
      switch (AEFilterSupport.lo())
      {
      case 5: 
      case 6: 
      default: 
        i = 0;
        i1 = m[i][0];
        j = m[i][1];
        if ((paramInt1 != 0) && (paramInt2 != 0) && (Math.max(paramInt1, paramInt2) < Math.max(i1, j)))
        {
          i = Math.min(paramInt1, paramInt2);
          j = Math.max(paramInt1, paramInt2);
        }
        break;
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        i1 = i;
        i = j;
        j = i1;
      }
      for (;;)
      {
        if (k != 0)
        {
          k = Math.min(this.axr, j) / 8 * 8;
          i1 = (int)(k * (this.axq / this.axr)) / 16 * 16;
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("ScreenRecordHelper", 4, "updateRecordParam, pre[" + this.b + "], display[" + this.axq + "," + this.axr + "], limit[" + i + "," + j + "], come[" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "], record[" + i1 + "," + k + "]");
          }
          this.b.width = i1;
          this.b.height = k;
          if (paramInt3 > 0) {
            this.b.fps = paramInt3;
          }
          if (this.jdField_a_of_type_Iot != null) {
            this.jdField_a_of_type_Iot.a(this.b);
          }
          return;
          k = 0;
          break;
          i = 2;
          break label55;
          i = 1;
          break label55;
          i = 0;
          break label55;
          i1 = Math.min(this.axq, i) / 16 * 16;
          k = (int)(i1 * this.axr / this.axq) / 8 * 8;
        }
      }
      i = i1;
    }
  }
  
  public void a(iot.b paramb)
  {
    if (this.jdField_a_of_type_Iot != null) {
      this.jdField_a_of_type_Iot.a(paramb);
    }
  }
  
  public void a(jds.a parama)
  {
    this.jdField_a_of_type_Jds$a = parama;
  }
  
  public void auK()
  {
    if (this.mContext == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof Activity)) {
        break label81;
      }
    }
    label81:
    Object localObject2;
    for (Object localObject1 = (Activity)localObject1;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        QLog.i("ScreenRecordHelper", 1, "requestScreenCapture, context not bind Activity .");
        return;
        localObject1 = (Context)this.mContext.get();
        break;
      }
      QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture");
      try
      {
        ((Activity)localObject1).startActivityForResult(this.mMediaProjectionManager.createScreenCaptureIntent(), 8080);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture fail ActivityNotFoundException");
        return;
      }
    }
  }
  
  public void auL()
  {
    kj(false);
  }
  
  public void bw(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    if (this.XW) {}
    do
    {
      return;
      this.XW = true;
      this.mMediaProjectionManager = ((MediaProjectionManager)paramContext.getApplicationContext().getSystemService("media_projection"));
      Object localObject = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.axp = ((DisplayMetrics)localObject).densityDpi;
      localObject = new Point();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealSize((Point)localObject);
      this.axq = ((Point)localObject).x;
      this.axr = ((Point)localObject).y;
      I(0, 0, 15);
      this.jdField_a_of_type_Iot = new iot();
      this.jdField_a_of_type_Iot.setTextureSize(this.axq, this.axr);
      this.jdField_a_of_type_Iot.a(this.b);
      this.jdField_a_of_type_Iot.start();
    } while (!QLog.isDevelopLevel());
    QLog.i("ScreenRecordHelper", 4, "doBindActivityContext, density[" + this.axp + "], size[" + this.axq + "," + this.axr + "]");
  }
  
  public boolean cD(int paramInt)
  {
    Context localContext = null;
    long l = AudioHelper.hG();
    QLog.d("ScreenRecordHelper", 1, "Start stopProjection fromType:=" + paramInt);
    if (this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay != null)
    {
      this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay.release();
      this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
    }
    if (this.mMediaProjection != null)
    {
      this.mMediaProjection.stop();
      this.mMediaProjection = null;
    }
    if (this.jdField_a_of_type_Jds$a != null) {
      this.jdField_a_of_type_Jds$a.lJ(paramInt);
    }
    a(null);
    a(null);
    this.XX = false;
    iwu.a(VideoController.a().mApp, true);
    if (this.mContext == null) {
      if ((localContext != null) && (Build.VERSION.SDK_INT >= 21))
      {
        if (paramInt != 1) {
          break label162;
        }
        ivv.a(l, 3, localContext);
      }
    }
    label162:
    while (paramInt == 2)
    {
      return true;
      localContext = (Context)this.mContext.get();
      break;
    }
    ivv.a(l, 3, localContext);
    return true;
  }
  
  public boolean n(Intent paramIntent)
  {
    QLog.d("ScreenRecordHelper", 1, "Start startProjection");
    long l = AudioHelper.hG();
    if (this.mContext == null) {}
    for (Context localContext = null; localContext == null; localContext = (Context)this.mContext.get())
    {
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, context is null.");
      return false;
    }
    if (this.mMediaProjectionManager == null)
    {
      kj(false);
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, mMediaProjectionManager is null.");
      return false;
    }
    this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(-1, paramIntent);
    if (this.mMediaProjection == null)
    {
      kj(false);
      return false;
    }
    kj(true);
    auM();
    if (this.jdField_a_of_type_Jds$a != null) {
      this.jdField_a_of_type_Jds$a.b(this.b, this.axq, this.axr);
    }
    paramIntent = VideoController.a().mApp;
    if (Build.VERSION.SDK_INT >= 21) {
      ivv.a(l, 3, localContext, true, paramIntent.getCurrentAccountUin(), true);
    }
    iwu.a(paramIntent, 8, 0L, true);
    this.n = new Timer();
    this.mRecordTime = 0L;
    this.n.scheduleAtFixedRate(new ScreenRecordHelper.1(this), 0L, 1000L);
    this.XX = true;
    return true;
  }
  
  public void quit()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "quit");
    }
    if (this.jdField_a_of_type_Iot != null)
    {
      this.jdField_a_of_type_Iot.iD(true);
      this.jdField_a_of_type_Iot = null;
    }
    this.mMediaProjectionManager = null;
    this.XX = false;
    this.XW = false;
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
  }
  
  public void stop(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "stop, fromType[" + paramInt + "]");
    }
    wF();
    cD(paramInt);
    quit();
  }
  
  public boolean wE()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "attachRecorder");
      if (this.n != null)
      {
        this.n.cancel();
        this.n = null;
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean wF()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "detachRecorder");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean wG()
  {
    return (this.XW) && (this.XX);
  }
  
  public static abstract interface a
  {
    public abstract void b(itn paramitn, int paramInt1, int paramInt2);
    
    public abstract void cA(long paramLong);
    
    public abstract void lJ(int paramInt);
    
    public abstract void lK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jds
 * JD-Core Version:    0.7.0.1
 */