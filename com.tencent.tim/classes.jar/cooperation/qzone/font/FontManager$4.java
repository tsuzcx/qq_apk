package cooperation.qzone.font;

import avua;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FontManager$4
  implements Runnable
{
  public FontManager$4(avua paramavua, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FontManager", 4, "begin to download font file from network, url =" + this.cNN);
    }
    if (HttpDownloadUtil.a(null, this.cNN, new File(avua.a(this.this$0, this.If)))) {
      avua.a(this.this$0, this.If);
    }
    for (;;)
    {
      avua.a(this.this$0, this.If);
      return;
      QLog.e("FontManager", 1, "Font Download Failed, font url = " + this.cNN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.4
 * JD-Core Version:    0.7.0.1
 */