import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class wiu
  implements aysc
{
  public wiu(SubscribeUtils.1 param1) {}
  
  public void onResp(aysz paramaysz)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramaysz.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      nav.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      gp.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception paramaysz)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramaysz);
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wiu
 * JD-Core Version:    0.7.0.1
 */