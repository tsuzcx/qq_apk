import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class ynd
  implements Handler.Callback
{
  public ynd(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label258:
    do
    {
      do
      {
        return false;
        if (VideoPlayerView.g(this.a)) {}
        for (int i = paramMessage.arg2 - paramMessage.arg1;; i = paramMessage.arg1)
        {
          int j = i / 1000 / 60;
          i = i / 1000 % 60;
          if ((VideoPlayerView.a(this.a) != null) && (VideoPlayerView.a(this.a).a() > VideoPlayerView.a(this.a).b() / 2L) && (!VideoPlayerView.h(this.a))) {
            VideoPlayerView.f(this.a);
          }
          if (VideoPlayerView.i(this.a)) {
            break label258;
          }
          if (this.a.b != null) {
            this.a.b.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
          }
          if ((VideoPlayerView.a(this.a) == null) || (!((Boolean)paramMessage.obj).booleanValue())) {
            break;
          }
          VideoPlayerView.a(this.a).a(String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }), paramMessage.arg2, paramMessage.arg1);
          return false;
        }
      } while ((VideoPlayerView.a(this.a) == null) || (!((Boolean)paramMessage.obj).booleanValue()));
      VideoPlayerView.a(this.a).onVideoProgressUpdate(paramMessage.arg1);
      return false;
      VideoPlayerView.g(this.a);
      return false;
    } while (VideoPlayerView.d(this.a) == null);
    VideoPlayerView.d(this.a).setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynd
 * JD-Core Version:    0.7.0.1
 */