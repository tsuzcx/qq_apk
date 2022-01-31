import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class xku
  implements EarlyDownloadManager.EarlyDownLoadListener
{
  public xku(RecentOptPopBar paramRecentOptPopBar, ArNativeSoDownloadHandler paramArNativeSoDownloadHandler) {}
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "ArMap, ArNativeSoDownloadHandler, onDownloadBegin, data=" + paramXmlData);
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "ArMap, onDownloadProgress, onDownloadBegin, data=" + paramXmlData + ", cur=" + paramLong1 + ", total=" + paramLong2);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "ArMap, ArNativeSoDownloadHandler, onDownloadFinish, data=" + paramXmlData + ", result=" + paramBoolean1 + ", errCode=" + paramInt + ", delRes=" + paramBoolean2 + ", filePath=" + paramString);
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a.runOnUiThread(new xkv(this));
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerArNativeSoDownloadHandler.b(this);
      return;
    }
    if (!ARNativeBridge.loadNativeLibrary())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a.runOnUiThread(new xkw(this));
      QLog.d("RecentOptPopBar", 1, "ArMap, ArNativeSoDownloadHandler, onDownloadFinish, loadNativeLibrary failed");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a.runOnUiThread(new xkx(this));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("RecentOptPopBar", 2, "ArMap, ArNativeSoDownloadHandler, load so success");
      }
      RecentOptPopBar.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentOptPopBar", 2, "ArMap, ArNativeSoDownloadHandler, onDownloadCancel, data=" + paramXmlData);
    }
    this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerArNativeSoDownloadHandler.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a.runOnUiThread(new xky(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xku
 * JD-Core Version:    0.7.0.1
 */