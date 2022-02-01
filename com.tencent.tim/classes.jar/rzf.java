import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class rzf
  implements aolm.b
{
  public rzf(SubscribeUtils.1 param1) {}
  
  public void onResp(aomh paramaomh)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramaomh.dPy);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.aDF);
      jqp.b(this.a.D, this.a.aDF);
      aqhq.deleteFile(this.a.D);
      return;
    }
    catch (Exception paramaomh)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramaomh);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzf
 * JD-Core Version:    0.7.0.1
 */