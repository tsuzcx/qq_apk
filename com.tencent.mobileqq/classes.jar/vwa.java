import com.tencent.biz.subscribe.SubscribeUtils.1;
import com.tencent.qphone.base.util.QLog;

public class vwa
  implements axrt
{
  public vwa(SubscribeUtils.1 param1) {}
  
  public void onResp(axsq paramaxsq)
  {
    QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + paramaxsq.c);
    try
    {
      QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + vvs.a);
      mpx.a(this.a.a, vvs.a);
      ew.a(this.a.a);
      return;
    }
    catch (Exception paramaxsq)
    {
      QLog.i("DownLoadZipFile", 1, "unzip file failed" + paramaxsq);
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vwa
 * JD-Core Version:    0.7.0.1
 */