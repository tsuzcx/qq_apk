import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QQServiceForAV.e;
import com.tencent.qphone.base.util.QLog;

public class iuo
  extends jnm.d
{
  public iuo(QQServiceForAV.e parame, String paramString, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle arg3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "sendNearbyVideoChatPbReq, cmd " + this.Qz + "==>onResult, errorCode:" + paramInt);
    }
    synchronized (this.a.a.mCallbacks)
    {
      int j = this.a.a.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((itz)this.a.a.mCallbacks.getBroadcastItem(i)).a(this.Qz, this.atG, paramInt, paramArrayOfByte);
            i += 1;
          }
          catch (RemoteException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "callBack RemoteException", paramArrayOfByte);
            }
          }
        }
      }
      this.a.a.mCallbacks.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iuo
 * JD-Core Version:    0.7.0.1
 */