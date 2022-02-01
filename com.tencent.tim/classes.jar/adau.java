import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ARGlobalConfigService;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

public final class adau
{
  private static volatile adau jdField_a_of_type_Adau;
  private volatile adgl jdField_a_of_type_Adgl;
  private ServiceConnection j = new adav(this);
  private Context mContext;
  
  private adau(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static adau a(Context paramContext)
  {
    if (jdField_a_of_type_Adau == null) {}
    try
    {
      if (jdField_a_of_type_Adau == null) {
        jdField_a_of_type_Adau = new adau(paramContext.getApplicationContext());
      }
      return jdField_a_of_type_Adau;
    }
    finally {}
  }
  
  public ARScanStarFaceConfigInfo a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_Adgl != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Adgl.a();
      QLog.d("ARGlobalRemoteManager", 2, String.format("getScanStarFaceConfigInfo IService=%s configInfo=%s", new Object[] { this.jdField_a_of_type_Adgl, localObject1 }));
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ARGlobalRemoteManager", 1, "getScanStarFaceConfigInfo fail!", localRemoteException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void start()
  {
    try
    {
      if (this.jdField_a_of_type_Adgl == null)
      {
        Intent localIntent = new Intent(this.mContext, ARGlobalConfigService.class);
        this.mContext.bindService(localIntent, this.j, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adau
 * JD-Core Version:    0.7.0.1
 */