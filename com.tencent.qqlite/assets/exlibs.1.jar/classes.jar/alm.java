import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class alm
  extends DownloadListener
{
  public alm(EmosmDetailActivity paramEmosmDetailActivity, String paramString1, String paramString2)
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
      localEmojiManager = (EmojiManager)this.a.app.getManager(39);
      localObject1 = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      localObject2 = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
      i = ((Bundle)localObject1).getInt("jsonType", EmojiManager.c);
      paramDownloadTask = (File)paramDownloadTask.a.get(localObject2);
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localReqInfo = new ReqInfo();
      if (!paramDownloadTask.exists()) {
        break label135;
      }
    }
    label135:
    for (paramDownloadTask = FileUtils.a(paramDownloadTask); localEmojiManager.a(localEmoticonPackage, i, paramDownloadTask, (ArrayList)localObject1, (ArrayList)localObject2, localReqInfo) != null; paramDownloadTask = null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.EmosmDetailActivity", 2, "json is complete,result ok: " + EmosmDetailActivity.a(this.a));
    }
    this.a.app.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
    this.a.runOnUiThread(new aln(this, localEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alm
 * JD-Core Version:    0.7.0.1
 */