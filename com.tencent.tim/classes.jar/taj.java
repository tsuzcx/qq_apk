import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.qfind.QFind.DeviceInfo;

public class taj
  extends SosoInterface.a
{
  public taj(QFindBLEScanMgr paramQFindBLEScanMgr, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      QFind.DeviceInfo localDeviceInfo = (QFind.DeviceInfo)this.this$0.gr.get(this.aIA);
      taf localtaf = (taf)this.this$0.gp.remove(this.aIA);
      localtaf.d = paramSosoLbsInfo;
      byte[] arrayOfByte;
      boolean bool;
      if (localDeviceInfo.bytes_sig.has())
      {
        arrayOfByte = localDeviceInfo.bytes_sig.get().toByteArray();
        localtaf.sig = arrayOfByte;
        localtaf.bAu = localDeviceInfo.uint32_need_verify_dev.get();
        if ((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L) - localDeviceInfo.timestamp.get() <= localDeviceInfo.uint32_verify_dev_interval.get()) {
          break label246;
        }
        bool = true;
        label122:
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "reportDevWithLoc get location errorCode=" + paramInt + " ; needVerify = " + localtaf.bAu + " ; exceedVerifyInterval= " + bool + " ; peerInfo.ble_id = " + localtaf.bAs);
        }
        if ((localtaf.bAu <= 0) || (!bool)) {
          break label251;
        }
        localtaf.connected = true;
        syo.a().a(this.this$0.a(localtaf));
      }
      for (;;)
      {
        this.this$0.gp.put(this.aIA, localtaf);
        return;
        arrayOfByte = null;
        break;
        label246:
        bool = false;
        break label122;
        label251:
        localtaf.connected = false;
        QFindBLEScanMgr.a(this.this$0, localtaf, paramSosoLbsInfo, false);
      }
    }
    QLog.e("QFindBLE", 1, "reportDevWithLoc get location failed errorCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     taj
 * JD-Core Version:    0.7.0.1
 */