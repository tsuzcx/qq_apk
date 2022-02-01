import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agmc
  implements ahcj.b
{
  agmc(aglz paramaglz) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    anot.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_success", 0, 1, 0, "", "", "", "");
    paramBundle.getInt("_CB_SID");
    String str = paramBundle.getString("_CB_URL");
    paramBundle = paramBundle.getBundle("_CB_USERDATA");
    aglz.a(this.this$0, str);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.this$0.app != null) {
      this.this$0.app.a().a(null, -1, paramString, paramLong, 16, null, paramBundle);
    }
    for (;;)
    {
      if (paramBundle != null) {
        ahch.fV(paramString, paramBundle.getString("big_brother_source_key"));
      }
      aglz.a(this.this$0);
      if ("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean".equals(str)) {
        anot.a(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "download secure apk sucess", 0, 0, "", "", "", "");
      }
      return;
      ahav.cZ(paramString);
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    aglz.a(this.this$0);
  }
  
  public void p(int paramInt, Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle) {}
  
  public void r(int paramInt, Bundle paramBundle) {}
  
  public void s(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmc
 * JD-Core Version:    0.7.0.1
 */