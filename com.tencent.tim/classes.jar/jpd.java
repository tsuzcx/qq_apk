import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.6;

public class jpd
  implements jox
{
  public jpd(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.val$start;
    if (jpa.a.isColorLevel()) {
      jpa.a.i("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (jpa.dh(this.a.val$businessId)) {
        this.a.d.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.la(this.a.val$businessId);
      jpa.a(this.a.val$businessId, paramInt, l, jqi.getNetworkType(this.a.val$context));
      return;
      this.a.d.loaded(null, 6);
      continue;
      this.a.d.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.d.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpd
 * JD-Core Version:    0.7.0.1
 */