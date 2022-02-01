import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class izu
  extends iiz
{
  izu(izr paramizr) {}
  
  protected void U(String paramString, boolean paramBoolean)
  {
    super.U(paramString, paramBoolean);
    if (this.this$0.jdField_a_of_type_Jet != null) {
      this.this$0.jdField_a_of_type_Jet.hide();
    }
    this.this$0.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onDestroyUI, peerUin:" + paramString + ", isQuit:" + paramBoolean + ", mPeerUin:" + this.this$0.mPeerUin);
    }
  }
  
  protected void bQ(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onConnected, seq[" + paramLong + "]");
    }
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.alx();
    ivm.a(this.this$0.mApp).x(paramLong, false);
    if (this.this$0.jdField_a_of_type_Jet != null) {
      this.this$0.jdField_a_of_type_Jet.avn();
    }
    if (this.this$0.e.amI == 1) {
      this.this$0.QK = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    }
    TraeHelper.a().startService(this.this$0.QK);
    this.this$0.mApp.getHandler().postDelayed(this.this$0.bf, 1000L);
  }
  
  protected void c(long paramLong, int paramInt, String paramString)
  {
    if ((this.this$0.mPeerUin != null) && (this.this$0.mPeerUin.equals(paramString)))
    {
      this.this$0.H(paramLong, paramInt);
      this.this$0.onDestroy();
    }
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.this$0.mPeerUin + "], seq[" + paramLong + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izu
 * JD-Core Version:    0.7.0.1
 */