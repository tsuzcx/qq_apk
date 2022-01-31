import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class waz
  implements INetEngine.INetEngineListener
{
  private Handler a;
  
  public waz(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = this.a.obtainMessage(8);
    ((Message)localObject).obj = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
    this.a.sendMessage((Message)localObject);
    Bundle localBundle = (Bundle)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    localObject = localBundle.getString("ReqUniqueKey");
    int i = localBundle.getInt("IdxInRes");
    if (QLog.isColorLevel())
    {
      long l = localBundle.getLong("StartTs");
      QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramNetResp.jdField_a_of_type_Long + " file.path = " + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c + " resp.result = " + paramNetResp.jdField_a_of_type_Int + " take time: " + Long.toString(System.currentTimeMillis() - l)));
    }
    if (paramNetResp.jdField_a_of_type_Int == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "OnResp", i, "result downloading, "));
      }
      return;
    }
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
      ZhituManager.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      if (localZhituImgResponse != null)
      {
        paramNetResp = this.a.obtainMessage(3);
        paramNetResp.obj = localBundle;
        this.a.sendMessage(paramNetResp);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a((String)localObject, "onResp", "download succ but md5 is mismatched"));
      }
      paramNetResp = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", 99999);
      paramNetResp.obj = localBundle;
    }
    for (;;)
    {
      break;
      localObject = this.a.obtainMessage(4);
      localBundle.putInt("ErrorCode", paramNetResp.b);
      ((Message)localObject).obj = localBundle;
      paramNetResp = (NetResp)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     waz
 * JD-Core Version:    0.7.0.1
 */