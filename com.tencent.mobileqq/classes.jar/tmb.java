import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.qphone.base.util.QLog;

public class tmb
  implements tmc
{
  public tmb(RunningJob paramRunningJob, StringBuilder paramStringBuilder) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Tlw.b = paramString;
  }
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data error: " + paramInt + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Tlw.e = paramInt;
  }
  
  public void onFileDownloadStarted()
  {
    qdm.b(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Tlw);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    RunningJob.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_Tlw.i = paramLong;
    QLog.d(RunningJob.jdField_a_of_type_JavaLangString, 1, "receive image data success, total size: " + paramLong + " progress: " + this.jdField_a_of_type_JavaLangStringBuilder);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(System.currentTimeMillis() + " " + paramInt + " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmb
 * JD-Core Version:    0.7.0.1
 */