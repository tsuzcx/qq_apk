package dov.com.qq.im.ae.download;

import axcd;
import axce;
import axiy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import java.util.List;
import java.util.Map;

public class AEResManager$3
  implements Runnable
{
  public AEResManager$3(axce paramaxce, axcd paramaxcd, QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.c paramc) {}
  
  public void run()
  {
    axiy.i("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.a);
    axce.a(this.this$0).put(this.a, Integer.valueOf(3));
    axce.b(this.this$0).put(this.a, Long.valueOf(System.currentTimeMillis()));
    ShortVideoResourceManager.b(this.val$appInterface, this.Gw, this.e, this.a.bvV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.3
 * JD-Core Version:    0.7.0.1
 */