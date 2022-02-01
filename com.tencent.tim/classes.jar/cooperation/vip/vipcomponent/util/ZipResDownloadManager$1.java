package cooperation.vip.vipcomponent.util;

import awnf;
import awnh;

public class ZipResDownloadManager$1
  implements Runnable
{
  public ZipResDownloadManager$1(awnf paramawnf, String paramString) {}
  
  public void run()
  {
    String str = this.val$url;
    if (this.this$0.uc(str)) {}
    awnh localawnh;
    do
    {
      return;
      localawnh = awnf.a(this.this$0, str, -1, null, null);
    } while (!awnf.a(this.this$0, str, localawnh));
    awnf.a(this.this$0, localawnh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */