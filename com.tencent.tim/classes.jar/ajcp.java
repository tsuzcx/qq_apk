import android.os.Bundle;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.oidb_0xb61.GetAppinfoRsp;
import tencent.im.oidb.oidb_0xb61.GetPkgUrlRsp;
import tencent.im.oidb.oidb_0xb61.RspBody;
import tencent.im.oidb.qqconnect.Appinfo;

public class ajcp
  extends jnm.a
{
  public ajcp(MiniAppInfoManager.1 param1) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppInfoManager", 2, "onResult type=" + this.a.c.appType + ", appid=" + this.a.c.appId + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label798;
      }
    }
    label798:
    for (;;)
    {
      try
      {
        paramBundle = ((oidb_0xb61.RspBody)new oidb_0xb61.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        StringBuilder localStringBuilder = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("MiniAppInfoManager", 2, paramArrayOfByte);
          if ((this.a.a != null) && (this.a.a.bs != null)) {
            this.a.a.a(this.a.a.bs.get(), false, this.a.c);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new oidb_0xb61.RspBody();
      for (;;)
      {
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.wording.has()) {
            this.a.c.wording = paramBundle.wording.get();
          }
          if ((this.a.YA != 1) || (!paramBundle.get_appinfo_rsp.appinfo.has())) {
            break label637;
          }
          this.a.c.platform = paramBundle.get_appinfo_rsp.appinfo.platform.get();
          this.a.c.appName = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
          this.a.c.appState = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
          this.a.c.iconUrl = paramBundle.get_appinfo_rsp.appinfo.icon_url.get();
          this.a.c.bQF = paramBundle.get_appinfo_rsp.appinfo.icon_small_url.get();
          this.a.c.bQE = paramBundle.get_appinfo_rsp.appinfo.icon_middle_url.get();
          if (paramBundle.next_req_duration.has()) {
            this.a.c.ace = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
          }
          if (QLog.isColorLevel()) {
            QLog.d("MiniAppInfoManager", 2, "receive appInfo: " + this.a.c);
          }
          ajcr.a().c(this.a.c);
          if ((this.a.a == null) || (this.a.a.bs == null)) {
            break;
          }
          this.a.a.a(this.a.a.bs.get(), true, this.a.c);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        if ((this.a.a == null) || (this.a.a.bs == null)) {
          break;
        }
        this.a.a.a(this.a.a.bs.get(), false, this.a.c);
        return;
        label637:
        if ((this.a.YA != 2) || (!paramBundle.get_mqqapp_url_rsp.has())) {
          break label743;
        }
        this.a.c.appVersion = paramBundle.get_mqqapp_url_rsp.app_version.get();
        this.a.c.bQG = paramBundle.get_mqqapp_url_rsp.pkg_url.get();
        if (paramBundle.next_req_duration.has()) {
          this.a.c.acf = (NetConnInfoCenter.getServerTimeMillis() + Math.max(paramBundle.next_req_duration.get() * 1000L, 300000L));
        }
      }
      label743:
      if ((this.a.a != null) && (this.a.a.bs != null))
      {
        this.a.a.a(this.a.a.bs.get(), false, this.a.c);
        return;
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */