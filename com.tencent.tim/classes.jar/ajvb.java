import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.qphone.base.util.QLog;

public class ajvb
  extends ajvc.a
{
  public ajvb(ConnectNearbyProcService paramConnectNearbyProcService) {}
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
    throws RemoteException
  {
    if (paramBasicTypeDataParcel == null) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("nearby_ipc_log_tag", 2, paramBasicTypeDataParcel.toString());
      }
      arrayOfObject = ConnectNearbyProcService.a(this.a, paramBasicTypeDataParcel.what, paramBasicTypeDataParcel.s);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.what, arrayOfObject);
  }
  
  public void a(ajvi paramajvi)
    throws RemoteException
  {
    ConnectNearbyProcService.a(paramajvi);
    if (ConnectNearbyProcService.a(this.a) != null) {
      ConnectNearbyProcService.a(this.a).dyL();
    }
  }
  
  public Message c(Message paramMessage)
    throws RemoteException
  {
    if (paramMessage == null) {
      return null;
    }
    return ConnectNearbyProcService.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvb
 * JD-Core Version:    0.7.0.1
 */