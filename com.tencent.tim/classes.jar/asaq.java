import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.1;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.2;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.3;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.4;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.5;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.6;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.7;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton.1.8;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class asaq
  implements aryx
{
  public asaq(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    arwt.i("ApkFileDownloadButton_", "[installSucceed] packageName=" + paramString2 + ",mApkInfo=" + this.this$0.c);
    if ((this.this$0.c != null) && (TextUtils.equals(paramString2, this.this$0.c.packageName))) {
      ThreadManager.excute(new ApkFileDownloadButton.1.8(this, paramString2), 16, null, true);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (this.this$0.a(paramDownloadInfo, this.this$0.c))
    {
      arwt.i("ApkFileDownloadButton_", "onDownloadCancel info.progress=" + paramDownloadInfo.progress);
      this.this$0.c.state = 1;
      this.this$0.c.progress = paramDownloadInfo.progress;
      if (this.this$0.c.length == 0L) {
        this.this$0.c.length = paramDownloadInfo.awN;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.5(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (this.this$0.a(paramDownloadInfo, this.this$0.c))
    {
      arwt.i("ApkFileDownloadButton_", "onDownloadError errorCode=" + paramInt1);
      if ((paramInt1 == 6) && (ApkFileDownloadButton.a(this.this$0) > 0))
      {
        ApkFileDownloadButton.a(this.this$0, paramDownloadInfo);
        ApkFileDownloadButton.a(this.this$0, ApkFileDownloadButton.a(this.this$0) - 1);
      }
    }
    else
    {
      return;
    }
    this.this$0.c.state = 30;
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.7(this));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (this.this$0.a(paramDownloadInfo, this.this$0.c))
    {
      arwt.i("ApkFileDownloadButton_", "onDownloadFinish info.progress=" + paramDownloadInfo.progress);
      this.this$0.c.state = 4;
      this.this$0.c.progress = paramDownloadInfo.progress;
      if (this.this$0.c.length == 0L) {
        this.this$0.c.length = paramDownloadInfo.awN;
      }
      ThreadManager.excute(new ApkFileDownloadButton.1.3(this), 16, null, true);
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.4(this));
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (this.this$0.a(paramDownloadInfo, this.this$0.c))
    {
      arwt.i("ApkFileDownloadButton_", "onDownloadPause info.progress=" + paramDownloadInfo.progress);
      this.this$0.c.state = 3;
      this.this$0.c.progress = paramDownloadInfo.progress;
      if (this.this$0.c.length == 0L) {
        this.this$0.c.length = paramDownloadInfo.awN;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.1(this));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localDownloadInfo = (DownloadInfo)paramList.next();
    } while (!this.this$0.a(localDownloadInfo, this.this$0.c));
    ApkFileDownloadButton.a(this.this$0, 1);
    arwt.i("ApkFileDownloadButton_", "onDownloadUpdate info.progress=" + localDownloadInfo.progress);
    this.this$0.c.state = 2;
    this.this$0.c.progress = localDownloadInfo.progress;
    if (this.this$0.c.length == 0L) {
      this.this$0.c.length = localDownloadInfo.awN;
    }
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.6(this));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (this.this$0.a(paramDownloadInfo, this.this$0.c))
    {
      arwt.i("ApkFileDownloadButton_", "onDownloadWait info.progress=" + paramDownloadInfo.progress);
      this.this$0.c.state = 20;
      if (this.this$0.c.length == 0L) {
        this.this$0.c.length = paramDownloadInfo.awN;
      }
      ThreadManager.getUIHandler().post(new ApkFileDownloadButton.1.2(this));
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asaq
 * JD-Core Version:    0.7.0.1
 */