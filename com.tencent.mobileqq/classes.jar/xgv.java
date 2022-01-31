import Wallet.GetSkinListRsp;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

class xgv
  implements Runnable
{
  xgv(xgu paramxgu, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    try
    {
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding("utf-8");
      this.jdField_a_of_type_WalletGetSkinListRsp.writeTo(localJceOutputStream);
      FileUtils.a(localJceOutputStream.toByteArray(), BaseApplicationImpl.getApplication().getFilesDir() + "skins" + this.jdField_a_of_type_Xgu.a.getCurrentAccountUin());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgv
 * JD-Core Version:    0.7.0.1
 */