import com.tencent.mobileqq.ar.ArNativeSoManager;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public class zxz
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  public zxz(ArNativeSoManager paramArNativeSoManager, String paramString, ARPreSoResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramDownloadInfo.d + ", filename = " + paramDownloadInfo.c + ", url = " + paramDownloadInfo.jdField_a_of_type_JavaLangString);
    if (paramBoolean) {
      if (!ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c, paramDownloadInfo.b))
      {
        ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback == null)
    {
      return;
      if ((!paramDownloadInfo.d.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager.a(paramDownloadInfo.d, paramDownloadInfo.c, paramDownloadInfo.b) != 0)) {}
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARPreSoResourceDownload$ARResourceDownloadCallback.a(paramBoolean, paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */