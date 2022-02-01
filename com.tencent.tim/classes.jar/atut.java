import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atut
  implements ahcj.b
{
  atut(atur paramatur) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    anot.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_success", 0, 1, 0, "", "", "", "");
    paramBundle.getInt("_CB_SID");
    String str = paramBundle.getString("_CB_URL");
    paramBundle = paramBundle.getBundle("_CB_USERDATA");
    atur.a(this.this$0, str);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.this$0.app != null)
    {
      int i = 16;
      if (paramBundle != null) {
        i = paramBundle.getInt("FILE_FROM", 16);
      }
      this.this$0.app.a().a(null, -1, paramString, paramLong, i, null, paramBundle);
    }
    for (;;)
    {
      ahch.JQ(paramString);
      atur.a(this.this$0);
      return;
      audx.cZ(paramString);
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    atur.a(this.this$0);
  }
  
  public void p(int paramInt, Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle) {}
  
  public void r(int paramInt, Bundle paramBundle) {}
  
  public void s(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atut
 * JD-Core Version:    0.7.0.1
 */