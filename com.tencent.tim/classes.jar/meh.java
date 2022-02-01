import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe1a.cmd0xe1a.ReqBody;
import tencent.im.oidb.cmd0xe1a.cmd0xe1a.RspBody;

public class meh
  implements mef.a
{
  private static String TAG = "RIJRedPacketModel";
  
  private void a(byte[] paramArrayOfByte, @NotNull mef.a.a parama)
  {
    try
    {
      cmd0xe1a.RspBody localRspBody = new cmd0xe1a.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      boolean bool1 = localRspBody.have_red_packet.get();
      boolean bool2 = localRspBody.opened_red_packet.get();
      paramArrayOfByte = localRspBody.wording.get();
      parama.a(0, bool2, paramArrayOfByte, localRspBody.wording2.get(), bool1);
      QLog.i(TAG, 1, "yyy_0xe1a haveRedPacket = " + bool1 + " haveOpen " + bool2 + " wording1 " + paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, QLog.getStackTraceString(paramArrayOfByte));
      }
      parama.a(-1, false, "", "", false);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, @NotNull mef.a.b paramb)
  {
    RIJRedPacketManager.a().a(paramInt, paramString1, paramString2, new mej(this, paramb));
  }
  
  public void a(@NotNull mef.a.a parama)
  {
    cmd0xe1a.ReqBody localReqBody = new cmd0xe1a.ReqBody();
    localReqBody.nothing.set("nothing");
    localReqBody.nothing.setHasFlag(true);
    jnm.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new mei(this, parama), localReqBody.toByteArray(), "OidbSvc.0xe1a", 3610, 1, new Bundle(), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     meh
 * JD-Core Version:    0.7.0.1
 */