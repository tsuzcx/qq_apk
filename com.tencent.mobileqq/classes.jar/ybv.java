import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class ybv
  implements baug
{
  public ybv(SubscribeUtils.1 param1) {}
  
  public void onResp(bavf parambavf)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + parambavf.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      ndr.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      bdhb.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception parambavf)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambavf);
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybv
 * JD-Core Version:    0.7.0.1
 */