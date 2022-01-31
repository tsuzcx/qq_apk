import Wallet.PfaFriendRsp;
import android.content.Context;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.TopayManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public final class xbr
  implements Runnable
{
  public void run()
  {
    if (TopayManager.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = QWalletTools.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = BaseApplicationImpl.getContext().getApplicationContext().getFilesDir() + "/QWallet/.tmp/topay_recommends" + (String)localObject1;
      localObject1 = localObject2;
      if (TopayManager.b == 1)
      {
        localObject1 = localObject2;
        if (TopayManager.c > 0)
        {
          localObject1 = localObject2;
          if (TopayManager.c < 3) {
            localObject1 = (String)localObject2 + "_" + TopayManager.b + "_" + TopayManager.c;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      TopayManager.a.writeTo((JceOutputStream)localObject2);
      FileUtils.a(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbr
 * JD-Core Version:    0.7.0.1
 */