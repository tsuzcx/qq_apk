import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.10.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoButton.10.2;

public class ayfj
  implements ModuleDownloadListener
{
  ayfj(ayfh paramayfh) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadCanceled " + paramString);
  }
  
  public void onDownloadFailed(String paramString)
  {
    QLog.i("Q.qqstory.record.EditVideoButton", 2, "onDownloadFailed " + paramString);
    if ((this.a.a != null) && (this.a.a.getActivity() != null)) {
      this.a.a.getActivity().runOnUiThread(new EditVideoButton.10.2(this));
    }
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("cyber_clink_version_2.jar")) {}
    while ((this.a.a == null) || (this.a.a.getActivity() == null)) {
      return;
    }
    this.a.a.getActivity().runOnUiThread(new EditVideoButton.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfj
 * JD-Core Version:    0.7.0.1
 */