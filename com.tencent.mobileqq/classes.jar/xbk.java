import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

public final class xbk
  implements Runnable
{
  public void run()
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getFilesDir() + "/QWallet/.tmp/goldmsg_friends";
      Object localObject = new File(str);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (GoldMsgChatHelper.GoldMsgFriendSet.a().size() <= 0) {
        return;
      }
      localObject = GoldMsgChatHelper.GoldMsgFriendSet.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        FileUtils.a(((String)localObject).getBytes("utf-8"), str);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbk
 * JD-Core Version:    0.7.0.1
 */