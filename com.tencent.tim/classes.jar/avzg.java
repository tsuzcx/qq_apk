import android.os.RemoteException;
import android.text.TextUtils;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class avzg
  extends IActionListener.Stub
{
  avzg(avzf paramavzf) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
    throws RemoteException
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (avzf.a(this.b) != null))
      {
        Iterator localIterator = avzf.a(this.b).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (avzi)((WeakReference)localObject).get();
            if (localObject != null) {
              ((avzi)localObject).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzg
 * JD-Core Version:    0.7.0.1
 */