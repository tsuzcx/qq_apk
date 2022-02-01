import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class anxa
  implements anwn
{
  anxa(anwy paramanwy, File paramFile, Exception[] paramArrayOfException, CountDownLatch paramCountDownLatch) {}
  
  public void onDownloadComplete()
  {
    QLog.d("studyroom.CdnPmUpdater", 1, " download cdn success");
    if (!anwy.a(this.jdField_a_of_type_Anwy).renameTo(this.val$file)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(acfp.m(2131703519) + this.val$file.getAbsolutePath());
    }
    this.val$countDownLatch.countDown();
  }
  
  public void onDownloadFailed(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("studyroom.CdnPmUpdater", 2, " onDownloadFailed ");
    }
    this.val$countDownLatch.countDown();
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxa
 * JD-Core Version:    0.7.0.1
 */