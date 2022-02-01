import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.wps.WPSFilePreviewActivity;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.1;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.2;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.3;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.4;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.5;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;

public class atmw
  extends atwm.a
{
  public atmw(WpsFilePreviewFragment paramWpsFilePreviewFragment) {}
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (paramLong1 > 0L)
    {
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.p(paramLong1);
      localForwardFileInfo.Oj(3);
      localForwardFileInfo.setType(10000);
      localForwardFileInfo.setLocalPath(paramString1);
      localForwardFileInfo.setFileName(paramString2);
      localForwardFileInfo.setFileSize(paramLong2);
      paramString1 = new Intent(this.a.mApp.getApp().getApplicationContext(), FileBrowserActivity.class);
      paramString1.setFlags(268435456);
      paramString1.putExtra("fileinfo", localForwardFileInfo);
      this.a.getActivity().startActivity(paramString1);
      return;
    }
    WPSFilePreviewActivity.a(this.a.a, this.a.getActivity(), WpsFilePreviewFragment.a(this.a), WpsFilePreviewFragment.b(this.a), WpsFilePreviewFragment.c(this.a), WpsFilePreviewFragment.a(this.a), WpsFilePreviewFragment.d(this.a));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    WpsFilePreviewFragment.a(this.a).post(new WpsFilePreviewFragment.1.4(this, paramBundle, paramString));
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i("IFileManagerProviderCallback", 1, "onDownloadFailed errCode[" + paramInt + "], errStr[" + paramString + "]");
    WpsFilePreviewFragment.a(this.a).post(new WpsFilePreviewFragment.1.5(this));
  }
  
  public void cE(Bundle paramBundle)
  {
    WpsFilePreviewFragment.a(this.a).post(new WpsFilePreviewFragment.1.1(this));
  }
  
  public void q(int paramInt, Bundle paramBundle)
  {
    WpsFilePreviewFragment.a(this.a).post(new WpsFilePreviewFragment.1.2(this, paramInt));
  }
  
  public void r(int paramInt, Bundle paramBundle)
  {
    QLog.i("IFileManagerProviderCallback", 1, "onDownloadPause progress[" + paramInt + "]");
    WpsFilePreviewFragment.a(this.a).post(new WpsFilePreviewFragment.1.3(this));
  }
  
  public void s(int paramInt, Bundle paramBundle)
  {
    QLog.i("IFileManagerProviderCallback", 1, "onDownloadResume progress[" + paramInt + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmw
 * JD-Core Version:    0.7.0.1
 */