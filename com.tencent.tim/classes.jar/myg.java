import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.3;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class myg
  implements kxv.a
{
  public myg(VideoPlayManager.3 param3, kxv paramkxv) {}
  
  public void b(kxz paramkxz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid=" + paramkxz.vid + ", url=" + paramkxz.url + ", isH265=, isHWCodec=" + paramkxz.Tx + "，urlType=" + paramkxz.videoType + ", hwBackupUrl=" + paramkxz.adF);
    }
    if ((this.a.c != null) && (mye.a(this.a.this$0) == this.a.c) && (paramkxz.vid.equals(this.a.i.videoVid))) {
      if (paramkxz.errorCode == 2) {
        if (mye.a(this.a.this$0) != null) {
          mye.a(this.a.this$0).a(this.a.c, 123, 108, 0, "vid2url failed, video deleted", null);
        }
      }
    }
    label452:
    label625:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramkxz.url)) {
          break;
        }
      } while (mye.a(this.a.this$0) == null);
      mye.a(this.a.this$0).a(this.a.c, 123, 107, 0, "vid2url failed, get null", null);
      return;
      Object localObject = this.a.c;
      int i;
      boolean bool;
      if (paramkxz.aiJ)
      {
        i = 1;
        ((myi)localObject).aVZ = i;
        this.a.i.ahw = paramkxz.url;
        this.a.i.c.vz = this.c.r.longValue();
        this.a.i.c.aSo = paramkxz.errorCode;
        this.a.i.c.aiJ = paramkxz.aiJ;
        this.a.i.c.adD = paramkxz.adD;
        this.a.i.c.Tx = paramkxz.Tx;
        this.a.i.c.amE = false;
        this.a.i.c.ahy = "";
        this.a.i.c.videoReportInfo = paramkxz.videoReportInfo;
        this.a.i.c.adE = paramkxz.adE;
        localObject = this.a.i.c;
        if (TextUtils.isEmpty(paramkxz.adF)) {
          break label625;
        }
        bool = true;
        ((mhu)localObject).amG = bool;
      }
      for (;;)
      {
        try
        {
          String str = new URL(paramkxz.url).getHost();
          localObject = aopd.a().a(str, 1006);
          mhu localmhu = this.a.i.c;
          if (localObject != null) {
            continue;
          }
          i = 0;
          localmhu.aSv = i;
          localmhu = this.a.i.c;
          if (localObject != null) {
            continue;
          }
          localObject = "";
          localmhu.ahB = ((String)localObject);
          this.a.i.c.ahA = str;
        }
        catch (Exception localException)
        {
          continue;
        }
        if (paramkxz.videoType != 1) {
          continue;
        }
        this.a.c.a(paramkxz.vid, paramkxz.url, 104, this.a.i.xb, this.a.i.fileSize, this.a.i.videoDuration, paramkxz.Tx, true, false);
        return;
        i = 0;
        break;
        bool = false;
        break label452;
        i = ((ArrayList)localObject).size();
        continue;
        localObject = ((ArrayList)localObject).toString();
      }
      this.a.c.a(paramkxz.vid, paramkxz.url, 101, this.a.i.xb, this.a.i.fileSize, this.a.i.videoDuration, paramkxz.Tx, true, false, paramkxz.adF);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramkxz.vid + " url:" + paramkxz.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myg
 * JD-Core Version:    0.7.0.1
 */