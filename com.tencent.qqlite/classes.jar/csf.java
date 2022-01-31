import android.os.Bundle;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class csf
  extends DownloadListener
{
  public csf(EmoticonManagerImp paramEmoticonManagerImp, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    EmojiManager localEmojiManager;
    Object localObject1;
    EmoticonPackage localEmoticonPackage;
    Object localObject2;
    int i;
    ReqInfo localReqInfo;
    if (paramDownloadTask.a() == 3)
    {
      localEmojiManager = (EmojiManager)EmoticonManagerImp.a(this.a).getManager(39);
      localObject1 = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      localObject2 = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
      i = ((Bundle)localObject1).getInt("jsonType", EmojiManager.c);
      paramDownloadTask = (File)paramDownloadTask.a.get(localObject2);
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localReqInfo = new ReqInfo();
      if (!paramDownloadTask.exists()) {
        break label153;
      }
    }
    label153:
    for (paramDownloadTask = FileUtils.a(paramDownloadTask);; paramDownloadTask = null)
    {
      paramDownloadTask = localEmojiManager.a(localEmoticonPackage, i, paramDownloadTask, (ArrayList)localObject1, (ArrayList)localObject2, localReqInfo);
      if (paramDownloadTask == null) {
        break;
      }
      localEmojiManager.a("param_error", paramDownloadTask);
      localEmojiManager.a(localEmoticonPackage, 11008);
      return;
    }
    EmoticonManagerImp.a(this.a, localEmoticonPackage.epId);
    EmoticonManagerImp.a(this.a, true, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     csf
 * JD-Core Version:    0.7.0.1
 */