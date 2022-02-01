package cooperation.qzone.webviewplugin;

import avzf;
import avzh;
import awfn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QzoneDynamicAlbumPlugin$7
  implements Runnable
{
  public QzoneDynamicAlbumPlugin$7(awfn paramawfn, List paramList, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.LS.size())
    {
      if (this.LS.get(i) == null) {}
      label167:
      for (;;)
      {
        i += 1;
        break;
        boolean bool = awfn.a(BaseApplicationImpl.getContext(), (String)this.LS.get(i), this.jd[i], awfn.p()[0], awfn.p()[1]);
        if ((bool) && (i == 0) && (!awfn.b(this.this$0)))
        {
          QLog.d("QzoneDynamicAlbumPlugin", 1, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + this.jd[0]);
          avzf.a().a().gX(this.jd[0], this.LS.size());
        }
        for (;;)
        {
          if (bool) {
            break label167;
          }
          QLog.e("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress failed! ");
          break;
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress all done  ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.7
 * JD-Core Version:    0.7.0.1
 */