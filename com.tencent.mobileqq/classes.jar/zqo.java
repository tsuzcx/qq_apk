import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class zqo
  implements INetEngine.INetEngineListener
{
  public zqo(SubscribeUtils.1 param1) {}
  
  public void onResp(NetResp paramNetResp)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramNetResp.mHttpCode);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + this.a.jdField_a_of_type_JavaLangString);
      nwp.a(this.a.jdField_a_of_type_JavaIoFile, this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramNetResp)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqo
 * JD-Core Version:    0.7.0.1
 */