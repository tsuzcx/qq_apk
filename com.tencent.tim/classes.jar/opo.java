import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class opo
  implements oud
{
  int retryTime = 0;
  long startTime = System.currentTimeMillis();
  
  opo(String paramString, KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    ooz.e("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.retryTime < 2)
    {
      this.startTime = System.currentTimeMillis();
      ooz.e("WeishiUtils", "");
      this.retryTime += 1;
      this.ab.setImage(paramURL);
      return;
    }
    this.startTime = 0L;
    this.retryTime = 0;
  }
  
  public void a(URL paramURL, nov paramnov)
  {
    ooz.d("WeishiUtils", "onLoadSuccess!!!");
    this.retryTime = 0;
    if (this.startTime > 0L)
    {
      if (paramURL != null)
      {
        oiu.m(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.startTime;
        paramnov = aoiz.getFile(paramURL.toString());
        if (paramnov != null)
        {
          String str = paramnov.getAbsolutePath();
          long l2 = paramnov.length();
          ooz.w("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          if ("feeds".equals(this.apZ)) {
            onk.a().a(true, l1, l2);
          }
          onk.a().a(true, l1, l2, paramURL.toString(), this.apZ);
        }
      }
      this.startTime = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opo
 * JD-Core Version:    0.7.0.1
 */