import Wallet.GetSkinListRsp;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

public class xgs
  implements Runnable
{
  public xgs(RedPacketManager paramRedPacketManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = FileUtils.a(BaseApplicationImpl.getApplication().getFilesDir() + "skins" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = new JceInputStream((byte[])localObject);
        ((JceInputStream)localObject).setServerEncoding("utf-8");
        GetSkinListRsp localGetSkinListRsp = new GetSkinListRsp();
        localGetSkinListRsp.readFrom((JceInputStream)localObject);
        if (localGetSkinListRsp != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new xgt(this, localGetSkinListRsp));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgs
 * JD-Core Version:    0.7.0.1
 */