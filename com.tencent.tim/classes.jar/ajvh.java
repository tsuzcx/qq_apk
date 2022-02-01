import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.qphone.base.util.QLog;

class ajvh
  extends ajvi.a
{
  ajvh(ajvf paramajvf) {}
  
  public BasicTypeDataParcel b(BasicTypeDataParcel paramBasicTypeDataParcel)
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
      arrayOfObject = this.b.b(paramBasicTypeDataParcel.what, paramBasicTypeDataParcel.s);
    } while (arrayOfObject == null);
    return new BasicTypeDataParcel(paramBasicTypeDataParcel.what, arrayOfObject);
  }
  
  public Message d(Message paramMessage)
    throws RemoteException
  {
    if (paramMessage == null) {
      return null;
    }
    return this.b.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvh
 * JD-Core Version:    0.7.0.1
 */