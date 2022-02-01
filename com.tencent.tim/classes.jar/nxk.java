import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class nxk
  implements ntp.b
{
  public nxk(ViolaBaseView paramViolaBaseView, String paramString1, String paramString2, ViolaBaseView.a parama) {}
  
  public void bbp()
  {
    String str1 = jpe.dO(this.val$businessId);
    str1 = str1 + this.val$businessId + File.separator;
    String str2 = jpa.getFilePath(this.val$url);
    if (new File(str1 + str2).exists()) {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.access$700(), 2, "downloadOfflineSuccess js exists [url:" + this.val$url + "]");
      }
    }
    do
    {
      for (;;)
      {
        str1 = ntp.fc(this.val$url);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        if (this.a != null) {
          this.a.oD(str1);
        }
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.access$700(), 2, "downloadOfflineSuccess and jsSource succ [url:" + this.val$url + "]");
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e(ViolaBaseView.access$700(), 2, "downloadOfflineSuccess js no exists [url:" + this.val$url + "]");
        }
      }
      if (this.a != null) {
        this.a.bbs();
      }
    } while (!QLog.isColorLevel());
    QLog.e(ViolaBaseView.access$700(), 2, "downloadOfflineSuccess but js null [url:" + this.val$url + "]");
  }
  
  public void bbq()
  {
    if (this.a != null) {
      this.a.bbs();
    }
    if (QLog.isColorLevel()) {
      QLog.e(ViolaBaseView.access$700(), 2, "downloadOfflineFailed [url:" + this.val$url + "]");
    }
  }
  
  public void uk(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxk
 * JD-Core Version:    0.7.0.1
 */