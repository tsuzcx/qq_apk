import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class aibs
  implements aiev
{
  aibs(aibq paramaibq, File paramFile, Exception[] paramArrayOfException, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void onDownloadComplete()
  {
    QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
    if (!aibq.a(this.jdField_a_of_type_Aibq).renameTo(this.val$file)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(acfp.m(2131703519) + this.val$file.getAbsolutePath());
    }
    if (aibq.b(this.jdField_a_of_type_Aibq)) {}
    for (String str = "33669797";; str = "33669802")
    {
      aids.report(str);
      aibq.a(this.jdField_a_of_type_Aibq).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.abh)).report();
      this.val$countDownLatch.countDown();
      return;
    }
  }
  
  public void onDownloadFailed(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, " onDownloadFailed retCode =  " + paramInt1);
    }
    if (aibq.b(this.jdField_a_of_type_Aibq)) {}
    for (paramString = "33669798";; paramString = "33669803")
    {
      aids.report(paramString);
      aibq.a(this.jdField_a_of_type_Aibq).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.abh)).report();
      this.val$countDownLatch.countDown();
      return;
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibs
 * JD-Core Version:    0.7.0.1
 */