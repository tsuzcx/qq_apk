import android.os.RemoteException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

@Deprecated
public abstract class aefh
  extends IBaseActionListener.Stub
{
  public void onActionResult(FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {}
  
  public void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    onRecvResp((ToServiceMsg)paramFromServiceMsg.attributes.get(FromServiceMsg.class.getSimpleName()), paramFromServiceMsg);
  }
  
  public abstract void onRecvResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aefh
 * JD-Core Version:    0.7.0.1
 */