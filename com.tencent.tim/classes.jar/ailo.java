import android.os.Bundle;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ailo
  implements BusinessObserver
{
  public ailo(UiApiPlugin paramUiApiPlugin, Integer paramInteger, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new oidb_sso.OIDBSSOPkg();
      }
    }
    try
    {
      paramBundle = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
      paramInt = paramBundle.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x716_48Rsp, resultCode:" + paramInt);
      }
      paramBundle = paramBundle.bytes_bodybuffer.get().toByteArray();
      if (paramInt == 0)
      {
        localObject = new byte[4];
        System.arraycopy(paramBundle, 0, localObject, 0, 4);
        paramBundle = ByteBuffer.wrap((byte[])localObject).getInt() + "";
        if (this.this$0.mClient == null)
        {
          this.this$0.mClient = skj.a();
          this.this$0.mClient.bzj();
        }
        this.this$0.mClient.a(this.af, this.bOT, this.val$accessToken, new ailp(this, paramBundle));
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailo
 * JD-Core Version:    0.7.0.1
 */