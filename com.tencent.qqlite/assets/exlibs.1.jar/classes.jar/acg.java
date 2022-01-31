import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.ChatBackgroundManagerImp;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

public class acg
  implements Runnable
{
  public acg(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(ChatBackgroundManagerImp.c);
      HttpDownloadUtil.a(this.a.app, EmosmUtils.insertMtype("VIP_other", "http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/xydata.js"), (File)localObject);
      localObject = new Message();
      ((Message)localObject).what = 1;
      this.a.b.sendMessage((Message)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acg
 * JD-Core Version:    0.7.0.1
 */