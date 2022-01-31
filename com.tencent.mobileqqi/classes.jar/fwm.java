import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class fwm
  implements UniformDownloader.IUniformDownloaderListener
{
  public fwm(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public String a(File paramFile)
  {
    String str1 = "*/*";
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf('.');
    Object localObject;
    if (i < 0) {
      localObject = str1;
    }
    String str2;
    do
    {
      return localObject;
      str2 = paramFile.substring(i, paramFile.length()).toLowerCase();
      localObject = str1;
    } while (TextUtils.isEmpty(str2));
    i = 0;
    paramFile = str1;
    for (;;)
    {
      localObject = paramFile;
      if (i >= UniformDownloadMgr.a().length) {
        break;
      }
      if (str2.equals(UniformDownloadMgr.a()[i][0])) {
        paramFile = UniformDownloadMgr.a()[i][1];
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.a(this.a);
  }
  
  public void a(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    String str = a(paramFile);
    localIntent.setDataAndType(Uri.fromFile(paramFile), str);
    paramContext.startActivity(localIntent);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    paramBundle.getInt("_CB_SID");
    paramBundle = paramBundle.getString("_CB_URL");
    UniformDownloadMgr.a(this.a, paramBundle);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>insertFM and install. PH:" + paramString + " SZ:" + paramLong);
    if (this.a.a != null) {
      this.a.a.a().a(null, -1, paramString, paramLong, 16, null, null);
    }
    for (;;)
    {
      if (UniformDownloadUtil.a(paramString) == -1) {
        a(this.a.a.a(), new File(paramString));
      }
      UniformDownloadMgr.a(this.a);
      return;
      FileManagerUtil.c(paramString);
    }
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle) {}
  
  public void d(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwm
 * JD-Core Version:    0.7.0.1
 */