package cooperation.qzone.webviewplugin;

import android.os.Handler;
import android.os.Message;
import avzf;
import avzh;
import awfn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Date;

public class QzoneDynamicAlbumPlugin$6
  implements Runnable
{
  public QzoneDynamicAlbumPlugin$6(awfn paramawfn, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.Fo.size())
    {
      if (this.Fo.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = awfn.cPP + (new Date().getTime() + i);
        String str2 = (String)this.Fo.get(i);
        boolean bool = awfn.a(BaseApplicationImpl.getContext(), str2, str1, awfn.p()[0], awfn.p()[1]);
        if ((bool) && (i == 0) && (!awfn.b(this.this$0)))
        {
          QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + str1);
          avzf.a().a().gX(str1, this.Fo.size());
        }
        for (;;)
        {
          if (!bool) {
            break label234;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 2, "pickDynamicAlbumImage sendMsg: MSG_PICK_PHOTO_COMPRESS_FINISH");
          Message localMessage = Message.obtain();
          localMessage.what = 2;
          localMessage.arg1 = this.eAv;
          localMessage.obj = new String[] { str2, str1 };
          this.this$0.handler.sendMessage(localMessage);
          break;
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
        label234:
        QLog.e("QzoneDynamicAlbumPlugin", 2, "compressDynamicAlbumImage failed! skip this photo.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6
 * JD-Core Version:    0.7.0.1
 */