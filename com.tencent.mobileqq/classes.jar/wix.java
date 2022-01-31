import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class wix
  implements aysa
{
  public wix(SubscribeUtils.1 param1) {}
  
  public void onResp(aysx paramaysx)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramaysx.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      nay.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      gp.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception paramaysx)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramaysx);
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wix
 * JD-Core Version:    0.7.0.1
 */