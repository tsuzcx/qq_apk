import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.WpsFileEditManager;
import com.tencent.tim.filemanager.core.WpsFileEditManager.SessionState;
import com.tencent.tim.filemanager.core.WpsFileEditManager.a;
import com.tencent.tim.filemanager.core.WpsFileEditManager.b;
import com.tencent.tim.filemanager.core.WpsFileEditManager.c;
import com.tencent.tim.filemanager.core.WpsFileEditManager.k;
import com.tencent.tim.filemanager.core.WpsFileEditManager.m;

public class atvi
  implements atvp.c
{
  public atvi(WpsFileEditManager paramWpsFileEditManager, WpsFileEditManager.c paramc) {}
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, atvp.b paramb, Bundle paramBundle)
  {
    QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + this.a.sessionId + "> checkIsUploadedCloud retun. isUploaded:" + paramBoolean2);
    if (paramBoolean2)
    {
      if (paramb != null)
      {
        QLog.i("WpsFileEditManager", 1, "[WPSEDIT]<" + this.a.sessionId + "> checkIsUploadedCloud retun. CloudFileInfo:" + paramb.toString());
        this.a.Zg(paramb.cHU);
        paramBundle = new WpsFileEditManager.k();
        paramBundle.hN = WpsFileEditManager.a(this.this$0);
        paramBundle.cHU = paramb.cHU;
        paramBundle.cloudId = paramb.cloudId;
        paramBundle.sessionid = this.a.sessionId;
        paramBundle.filePath = paramString;
        paramBundle.busType = this.a.busType;
        if (WpsFileEditManager.a(this.this$0).a(paramBundle) != WpsFileEditManager.m.NONE)
        {
          WpsFileEditManager.a(this.this$0, this.a.sessionId);
          auen.qw("同步云文件失败。");
          return;
        }
        this.a.a(WpsFileEditManager.SessionState.UPLOADING);
        return;
      }
      QLog.e("WpsFileEditManager", 1, "[WPSEDIT]<" + this.a.sessionId + "> saveFileToCloudDefaultDir fail. uploadinfo=null");
      return;
    }
    paramb = audx.getFileName(this.a.getFilePath());
    this.a.Zg(paramb);
    if (WpsFileEditManager.a(this.this$0).a(this.a.sessionId, paramString, WpsFileEditManager.a(this.this$0), paramb, this.a.busType) != WpsFileEditManager.m.NONE)
    {
      WpsFileEditManager.a(this.this$0, this.a.sessionId);
      auen.qw("同步云文件失败。");
      return;
    }
    this.a.a(WpsFileEditManager.SessionState.UPLOADING);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvi
 * JD-Core Version:    0.7.0.1
 */