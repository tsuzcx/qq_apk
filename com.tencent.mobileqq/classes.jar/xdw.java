import Wallet.GetGroupRedPackListRsp;
import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class xdw
  implements Runnable
{
  public xdw(RedPacketManager paramRedPacketManager, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_WalletGetGroupRedPackListRsp == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      String str = BaseApplicationImpl.getContext().getApplicationContext().getFilesDir() + "/QWallet/.tmp/group_available_list_" + this.jdField_a_of_type_JavaLangString + this.b + "_" + this.jdField_a_of_type_Int;
      Object localObject = new File(str);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf-8");
      this.jdField_a_of_type_WalletGetGroupRedPackListRsp.writeTo((JceOutputStream)localObject);
      FileUtils.a(((JceOutputStream)localObject).toByteArray(), str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdw
 * JD-Core Version:    0.7.0.1
 */