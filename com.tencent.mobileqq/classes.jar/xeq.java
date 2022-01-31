import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public final class xeq
  implements Runnable
{
  public xeq(String paramString) {}
  
  public void run()
  {
    try
    {
      localObject = BaseApplicationImpl.getApplication().getFilesDir() + "/QWallet/.tmp/goldmsg_friends";
      if (!new File((String)localObject).exists()) {
        return;
      }
      localObject = FileUtils.a((String)localObject);
      if (localObject != null) {
        GoldMsgChatHelper.GoldMsgFriendSet.a(new String((byte[])localObject, "utf-8"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        Bundle localBundle;
        localException.printStackTrace();
      }
    }
    localObject = QWalletTools.a();
    if (localObject != null)
    {
      localBundle = new Bundle();
      localBundle.putString("friendUin", this.a);
      ((QQAppInterface)localObject).notifyObservers(GoldConfigObserver.class, 9, true, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xeq
 * JD-Core Version:    0.7.0.1
 */