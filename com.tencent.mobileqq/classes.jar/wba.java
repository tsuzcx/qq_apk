import android.os.Handler;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class wba
  implements INetEngine.INetEngineListener
{
  private Handler a;
  
  public wba(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + paramNetResp);
    }
    if (paramNetResp.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(ZhituManager.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
      {
        this.a.sendEmptyMessage(100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "font download but md5 is not matched");
      }
      this.a.sendEmptyMessage(101);
      return;
    }
    this.a.sendEmptyMessage(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wba
 * JD-Core Version:    0.7.0.1
 */