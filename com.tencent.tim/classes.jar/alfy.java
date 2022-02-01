import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class alfy
  implements Manager
{
  public alfy(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, alfu paramalfu)
  {
    avsf localavsf = new avsf();
    if (paramalfu != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramalfu, null, null, localavsf, localavsf);
      return;
    }
    paramalfu = new alfz(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramalfu, null, null, localavsf, localavsf);
  }
  
  public void a(QQAppInterface paramQQAppInterface, alfu paramalfu)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramalfu);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, alfv paramalfv, alfu paramalfu)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramalfu);
    }
    paramalfv.upload();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfy
 * JD-Core Version:    0.7.0.1
 */