import android.text.TextUtils;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class izx
  extends iiz
{
  public izx(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void U(String paramString, boolean paramBoolean)
  {
    QLog.w(this.this$0.TAG, 1, "VideoObserver_onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.this$0.mPeerUin + "]");
    if (TextUtils.equals(this.this$0.mPeerUin, paramString)) {
      this.this$0.kd("VideoObserver_onDestroyUI");
    }
  }
  
  protected void c(long paramLong, int paramInt, String paramString)
  {
    QLog.w(this.this$0.TAG, 1, "VideoObserver_onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.this$0.mPeerUin + "], seq[" + paramLong + "]");
    if (TextUtils.equals(this.this$0.mPeerUin, paramString))
    {
      this.this$0.kd("VideoObserver_onClose");
      this.this$0.H(paramLong, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izx
 * JD-Core Version:    0.7.0.1
 */