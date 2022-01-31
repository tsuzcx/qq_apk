import com.tencent.mobileqq.app.ChatBackgroundManagerImp;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

public class cqo
  implements Runnable
{
  public cqo(ChatBackgroundManagerImp paramChatBackgroundManagerImp) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(ChatBackgroundManagerImp.c);
      HttpDownloadUtil.a(ChatBackgroundManagerImp.a(this.a), EmosmUtils.insertMtype("VIP_emosm", "http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/xydata.js"), localFile);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqo
 * JD-Core Version:    0.7.0.1
 */