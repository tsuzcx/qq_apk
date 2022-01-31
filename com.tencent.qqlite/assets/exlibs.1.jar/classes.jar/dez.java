import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class dez
  extends DownloadListener
{
  public dez(EmotionPreviewLayout paramEmotionPreviewLayout, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    EmojiManager localEmojiManager;
    EmoticonPackage localEmoticonPackage;
    if (paramDownloadTask.a() == 3)
    {
      localEmojiManager = (EmojiManager)EmotionPreviewLayout.a(this.a).getManager(39);
      localObject1 = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      if ((localEmoticonPackage != null) && (!TextUtils.isEmpty(localEmoticonPackage.epId))) {}
    }
    else
    {
      return;
    }
    Object localObject2 = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
    int i = ((Bundle)localObject1).getInt("jsonType", EmojiManager.c);
    paramDownloadTask = (File)paramDownloadTask.a.get(localObject2);
    Object localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    if (paramDownloadTask.exists()) {}
    for (paramDownloadTask = FileUtils.a(paramDownloadTask);; paramDownloadTask = null)
    {
      localEmojiManager.a(localEmoticonPackage, i, paramDownloadTask, (ArrayList)localObject1, (ArrayList)localObject2, localReqInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dez
 * JD-Core Version:    0.7.0.1
 */