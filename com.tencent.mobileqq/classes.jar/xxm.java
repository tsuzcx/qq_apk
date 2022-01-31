import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class xxm
  implements bapx
{
  public xxm(SubscribeUtils.1 param1) {}
  
  public void onResp(baqw parambaqw)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + parambaqw.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      ndr.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      bdcs.a(this.a.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Exception parambaqw)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + parambaqw);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xxm
 * JD-Core Version:    0.7.0.1
 */