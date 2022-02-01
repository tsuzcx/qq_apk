import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.qphone.base.util.QLog;

public class mcu
  implements lfp.a
{
  public mcu(ComponentPGCShortContentBig paramComponentPGCShortContentBig, SocializeFeedsInfo.o paramo) {}
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((ComponentPGCShortContentBig.a(this.this$0) != null) && ((ComponentPGCShortContentBig.a(this.this$0) instanceof VideoView)))
    {
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        paramArrayOfString2 = paramArrayOfString2[0];
        if ((!TextUtils.isEmpty(this.a.vid)) && (this.a.vid.equals(paramArrayOfString1[0])) && (this.a.vid.equals(((MediaVideoView)ComponentPGCShortContentBig.a(this.this$0)).getVideoVid())))
        {
          ComponentPGCShortContentBig.a(this.this$0, paramArrayOfString2);
          return;
        }
        QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not current video");
        return;
      }
      QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "urls null");
      return;
    }
    QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not vieoview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcu
 * JD-Core Version:    0.7.0.1
 */