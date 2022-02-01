import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class alvs
{
  static volatile alvs jdField_a_of_type_Alvs;
  alvq jdField_a_of_type_Alvq;
  alvs.a jdField_a_of_type_Alvs$a;
  alvv jdField_a_of_type_Alvv;
  AtomicBoolean dD = new AtomicBoolean(false);
  ServiceConnection mConnection;
  Messenger mMessenger;
  Messenger mService;
  HandlerThread mWorkerThread;
  
  private alvs()
  {
    alvr.d("PTV.RichmediaClient", "RichmediaClient");
    this.mWorkerThread = new HandlerThread("RichmediaClientWorkerThread");
    this.mWorkerThread.start();
    this.jdField_a_of_type_Alvs$a = new alvs.a(this.mWorkerThread.getLooper(), this);
    this.mMessenger = new Messenger(this.jdField_a_of_type_Alvs$a);
    this.mConnection = new alvt(this);
    this.jdField_a_of_type_Alvq = new alvu(this);
  }
  
  public static alvs a()
  {
    alvr.d("PTV.RichmediaClient", "getInstance");
    if (jdField_a_of_type_Alvs == null) {}
    try
    {
      if (jdField_a_of_type_Alvs == null) {
        jdField_a_of_type_Alvs = new alvs();
      }
      return jdField_a_of_type_Alvs;
    }
    finally {}
  }
  
  public alvv a()
  {
    if (this.jdField_a_of_type_Alvv == null) {
      this.jdField_a_of_type_Alvv = new alvv();
    }
    return this.jdField_a_of_type_Alvv;
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    alvr.d("PTV.RichmediaClient", "sendToService,msgCode = " + paramInt1 + ",subCmd = " + paramInt2 + ",data = " + paramBundle);
    if (this.mService == null)
    {
      alvr.e("PTV.RichmediaClient", "sendToService failed. mService is null ");
      return false;
    }
    Message localMessage = Message.obtain(null, paramInt1);
    if (paramBundle != null) {
      paramBundle.putInt("msg_sub_cmd", paramInt2);
    }
    localMessage.setData(paramBundle);
    try
    {
      this.mService.send(localMessage);
      return true;
    }
    catch (RemoteException paramBundle)
    {
      alvr.e("PTV.RichmediaClient", "sendToService failed. e = " + paramBundle);
    }
    return false;
  }
  
  public void bu(Context paramContext)
  {
    alvr.d("PTV.RichmediaClient", "bindService");
    if (this.dD.compareAndSet(false, true)) {}
    try
    {
      paramContext.bindService(new Intent(paramContext, RichmediaService.class), this.mConnection, 1);
      alvr.d("PTV.RichmediaClient", "bindService,bingding");
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        alvr.e("PTV.RichmediaClient", "bindService failed. e = " + paramContext);
      }
    }
  }
  
  public void unbindService(Context paramContext)
  {
    alvr.d("PTV.RichmediaClient", "unbindService");
    if (this.dD.compareAndSet(true, false)) {}
    try
    {
      a(2, -1, null);
      paramContext.unbindService(this.mConnection);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("PTV.RichmediaClient", 1, "unbindService error.", paramContext);
      return;
    }
    finally
    {
      this.mService = null;
    }
  }
  
  static class a
    extends Handler
  {
    final WeakReference<alvs> hH;
    
    public a(Looper paramLooper, alvs paramalvs)
    {
      super();
      this.hH = new WeakReference(paramalvs);
    }
    
    public void handleMessage(Message paramMessage)
    {
      alvr.d("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
      alvs localalvs = (alvs)this.hH.get();
      if (localalvs == null) {}
      do
      {
        return;
        if (paramMessage.getData() != null) {
          paramMessage.getData().getInt("msg_sub_cmd");
        }
        switch (paramMessage.what)
        {
        case 1001: 
        default: 
          super.handleMessage(paramMessage);
          return;
        case 1000: 
          alvr.d("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
          return;
        case 1002: 
          alvr.d("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
          paramMessage = paramMessage.getData();
        }
      } while (paramMessage == null);
      paramMessage = paramMessage.getString("vidoe_record_uniseq");
      localalvs.a().oy(paramMessage);
      return;
      AIOLongCaptureCtrl.eA(paramMessage.getData());
      return;
      AIOLongCaptureCtrl.eB(paramMessage.getData());
      return;
      paramMessage = paramMessage.getData();
      xsi.a().bA(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvs
 * JD-Core Version:    0.7.0.1
 */