import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;

public class lfm
  implements lfp.a
{
  public lfm(VideoView paramVideoView) {}
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      paramArrayOfString2 = paramArrayOfString2[0];
      try
      {
        if ((!TextUtils.isEmpty(VideoView.d(this.this$0))) && (VideoView.d(this.this$0).equals(paramArrayOfString1[0]))) {
          this.this$0.nf(paramArrayOfString2);
        }
        for (;;)
        {
          return;
          QLog.d("gifvideo.VideoView", 2, "not current video");
        }
        QLog.d("gifvideo.VideoView", 2, "urls null");
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfm
 * JD-Core Version:    0.7.0.1
 */