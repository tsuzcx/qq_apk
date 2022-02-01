import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

final class jpc
  implements BusinessObserver
{
  jpc(NewIntent paramNewIntent, jox paramjox, boolean paramBoolean1, boolean paramBoolean2, AppRuntime paramAppRuntime, boolean paramBoolean3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate,onReceive:isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          return;
        }
        OfflinePkg.RspBody localRspBody = new OfflinePkg.RspBody();
        localRspBody.mergeFrom(paramBundle);
        paramBundle = new String(localRspBody.str_offline_pkg.get().toByteArray(), "UTF-8");
        if (this.d != null) {
          this.d.loaded(paramBundle, 0);
        }
        if (!this.abd) {
          return;
        }
        if (this.abc)
        {
          jpa.c(paramBundle, this.val$app, this.abb, this.d);
          return;
        }
        jpa.c(paramBundle, this.val$app, this.abb, null);
        return;
      }
      catch (Exception paramBundle)
      {
        this.d.loaded("{\"r\":-1}", 2);
        return;
      }
    } else if (this.d != null) {
      this.d.loaded("{\"r\":-1}", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpc
 * JD-Core Version:    0.7.0.1
 */