import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;

class aacx
  implements IRedPacket.OnGetSkinListener
{
  aacx(aacv paramaacv, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    this.val$bundle.putParcelable("key_red_packet_info", paramRedPacketInfoBase);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "getRedPacketBundle | info resPath = " + paramRedPacketInfoBase.resPath);
    }
    if (this.i != null) {
      this.i.send(0, this.val$bundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacx
 * JD-Core Version:    0.7.0.1
 */