package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import aoll;
import aolm;
import ayuz;
import aywt;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import ige;

public class VideoFilterListDownloader$1
  implements Runnable
{
  public VideoFilterListDownloader$1(ayuz paramayuz, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = this.this$0.a;
    localaoll.bZ = this.e.resurl;
    localaoll.mHttpMethod = 0;
    localaoll.atY = (aywt.bej + this.e.name + ".zip");
    localaoll.bw(this.e);
    localaoll.a = this.this$0;
    if (this.e.bundle == null) {
      this.e.bundle = new Bundle();
    }
    this.e.bundle.putLong("requestStartTime", System.currentTimeMillis());
    ige.a().a(localaoll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */