import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVGQuality;
import com.tencent.av.gaudio.AVGQuality.AudioQos;
import com.tencent.av.gaudio.AVGQuality.VideoQos;
import com.tencent.av.gaudio.AVGQuality.VideoQuality;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.qphone.base.util.QLog;

public class bkh
  implements Runnable
{
  public bkh(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoCtrlLayerUI", 2, "can not get shape info");
        }
        return;
      }
      String str1 = new String();
      str1 = str1 + "audioQos: ";
      String str2 = String.format("bitR = %d, packDuration = %d, RECN = %d, RECM = %d, MTU = %d, INFEC = %.2f. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).audioQos.bitR), Integer.valueOf(((AVGQuality)localObject).audioQos.packDuration), Integer.valueOf(((AVGQuality)localObject).audioQos.RECN), Integer.valueOf(((AVGQuality)localObject).audioQos.RECM), Integer.valueOf(((AVGQuality)localObject).audioQos.MTU), Float.valueOf(((AVGQuality)localObject).audioQos.INFEC) });
      str1 = str1 + str2;
      str1 = str1 + "mainVideoSendBigViewQua: ";
      str2 = String.format("w = %d, h = %d, fps = %d, codecType = %d, quality = %d, STnSB = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.width), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.height), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.fps), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.codecType), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.quality), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQua.STnSB) });
      str1 = str1 + str2;
      str1 = str1 + "mainVideoSendBigViewQos: ";
      str2 = String.format("w = %d, h = %d, fps = %d, bitR = %d, codecType = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQos.width), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQos.height), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQos.fps), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQos.bitR), Integer.valueOf(((AVGQuality)localObject).mainVideoSendBigViewQos.codecType) });
      str1 = str1 + str2;
      str1 = str1 + "mainVideoSendSmallViewQua: ";
      str2 = String.format("w = %d, h = %d, fps = %d, codecType = %d, quality = %d, STnSB = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.width), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.height), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.fps), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.codecType), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.quality), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQua.STnSB) });
      str1 = str1 + str2;
      str1 = str1 + "mainVideoSendSmallViewQos: ";
      str2 = String.format("w = %d, h = %d, fps = %d, bitR = %d, codecType = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQos.width), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQos.height), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQos.fps), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQos.bitR), Integer.valueOf(((AVGQuality)localObject).mainVideoSendSmallViewQos.codecType) });
      str1 = str1 + str2;
      str1 = str1 + "mainVideoRecvQua: ";
      str2 = String.format("w = %d, h = %d, fps = %d, codecType = %d, quality = %d, STnSB = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.width), Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.height), Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.fps), Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.codecType), Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.quality), Integer.valueOf(((AVGQuality)localObject).mainVideoRecvQua.STnSB) });
      str1 = str1 + str2;
      str1 = str1 + "subVideoRecvQua: ";
      str2 = String.format("w = %d, h = %d, fps = %d, codecType = %d, quality = %d, STnSB = %d. \n\n", new Object[] { Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.width), Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.height), Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.fps), Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.codecType), Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.quality), Integer.valueOf(((AVGQuality)localObject).subVideoRecvQua.STnSB) });
      str1 = str1 + str2;
      str1 = str1 + "Common: ";
      localObject = String.format("sendLossR = %.2f, sendJitterR = %d, sendBitR = %d, sendPktR = %d, recvLossR = %.2f, recvJitterR = %d, recvBitR = %d, recvPktR = %d, sysCpu = %.2f, RTT = %d. \n\n", new Object[] { Float.valueOf(((AVGQuality)localObject).sendLossR), Integer.valueOf(((AVGQuality)localObject).sendJitterR), Integer.valueOf(((AVGQuality)localObject).sendBitR), Integer.valueOf(((AVGQuality)localObject).sendPktR), Float.valueOf(((AVGQuality)localObject).recvLossR), Integer.valueOf(((AVGQuality)localObject).recvJitterR), Integer.valueOf(((AVGQuality)localObject).recvBitR), Integer.valueOf(((AVGQuality)localObject).recvPktR), Float.valueOf(((AVGQuality)localObject).sysCpu), Integer.valueOf(((AVGQuality)localObject).RTT) });
      localObject = str1 + (String)localObject;
      if (this.a.e != null) {
        this.a.e.setText((CharSequence)localObject);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkh
 * JD-Core Version:    0.7.0.1
 */