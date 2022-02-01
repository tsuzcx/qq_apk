package cooperation.qzone.zipanimate;

import awin;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public class ZipDrawableLoader$1
  implements Runnable
{
  public ZipDrawableLoader$1(awin paramawin, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, awin.a(this.this$0), awin.b(this.this$0), awin.c(this.this$0), this.val$count, awin.a(this.this$0))) {
      awin.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */