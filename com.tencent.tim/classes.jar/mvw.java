import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.c;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class mvw
  extends Handler
{
  public mvw(VideoFeedsPlayManager paramVideoFeedsPlayManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (VideoFeedsPlayManager.e(this.this$0)) {}
    do
    {
      return;
      if (!(paramMessage.obj instanceof VideoFeedsPlayManager.b)) {
        break;
      }
    } while (!VideoFeedsPlayManager.a(this.this$0, (VideoFeedsPlayManager.b)paramMessage.obj));
    super.dispatchMessage(paramMessage);
    return;
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case -3: 
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "prePlay timeout, try rePlay");
      }
      if ((VideoFeedsPlayManager.a(this.this$0, VideoFeedsPlayManager.b(this.this$0)) != null) && (VideoFeedsPlayManager.a(this.this$0, VideoFeedsPlayManager.b(this.this$0)).isReady()) && (VideoFeedsPlayManager.a(this.this$0, VideoFeedsPlayManager.b(this.this$0)).getTag() == VideoFeedsPlayManager.b(this.this$0).d))
      {
        VideoFeedsPlayManager.a(this.this$0).d(VideoFeedsPlayManager.a(this.this$0, VideoFeedsPlayManager.b(this.this$0)));
        return;
      }
      VideoFeedsPlayManager.b(this.this$0).apw = false;
      this.this$0.o(VideoFeedsPlayManager.b(this.this$0));
      VideoFeedsPlayManager.a(this.this$0, VideoFeedsPlayManager.b(this.this$0), false);
      return;
    }
    paramMessage = VideoFeedsPlayManager.a(this.this$0);
    VideoFeedsPlayManager.b localb = VideoFeedsPlayManager.b(this.this$0);
    long l1;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.isPlaying()) && ((localb.a == null) || (!localb.a.d(localb))) && (!paramMessage.isSeeking()))
    {
      l1 = paramMessage.dc();
      long l2 = paramMessage.getDuration();
      if (localb.a != null) {
        localb.a.a(localb, l1, l2);
      }
      if (l1 < l2 - 300L) {
        break label495;
      }
      VideoFeedsPlayManager.d(this.this$0, true);
      int i = (int)(l2 - l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoEndSoon: pos=" + l1 + ", duration=" + l2 + ", remainDuration=" + i + ", mHasCallEndingSoon=" + VideoFeedsPlayManager.f(this.this$0));
      }
      if ((!VideoFeedsPlayManager.f(this.this$0)) && (VideoFeedsPlayManager.a(this.this$0) != null))
      {
        VideoFeedsPlayManager.e(this.this$0, true);
        if ((localb.a != null) && (!VideoFeedsPlayManager.g(this.this$0)))
        {
          if ((!VideoFeedsPlayManager.h(this.this$0)) && (!VideoFeedsPlayManager.i(this.this$0))) {
            break label489;
          }
          bool = true;
          localb.a.a(VideoFeedsPlayManager.b(this.this$0), i, bool);
        }
      }
    }
    for (;;)
    {
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).onProgressChanged(l1);
      }
      VideoFeedsPlayManager.a(this.this$0).sendEmptyMessageDelayed(-2, 100);
      return;
      label489:
      bool = false;
      break;
      label495:
      if ((l1 <= 500L) && (l1 >= 0L) && (VideoFeedsPlayManager.j(this.this$0)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "onVideoReplayOnLoop: pos=" + l1);
        }
        VideoFeedsPlayManager.f(this.this$0, false);
        VideoFeedsPlayManager.e(this.this$0, false);
        VideoFeedsPlayManager.d(this.this$0, false);
        VideoFeedsPlayManager.a(this.this$0);
        paramMessage.aTT();
        if ((VideoFeedsPlayManager.b(this.this$0).d.isAD) && (knc.a(VideoFeedsPlayManager.b(this.this$0).d.b)))
        {
          VideoFeedsPlayManager.a(this.this$0).pause();
          VideoFeedsPlayManager.a(this.this$0).post(new VideoFeedsPlayManager.1.1(this));
        }
        else if (VideoFeedsPlayManager.a(this.this$0) != null)
        {
          paramMessage = VideoFeedsPlayManager.a(this.this$0).iterator();
          while (paramMessage.hasNext()) {
            ((VideoFeedsPlayManager.d)paramMessage.next()).a(VideoFeedsPlayManager.b(this.this$0), VideoFeedsPlayManager.b(this.this$0));
          }
        }
      }
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (VideoFeedsPlayManager.e(this.this$0)) {
      return false;
    }
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramLong <= SystemClock.uptimeMillis()))
    {
      if (paramMessage.getCallback() != null) {
        paramMessage.getCallback().run();
      }
      for (;;)
      {
        return true;
        handleMessage(paramMessage);
      }
    }
    if (paramMessage.obj == null) {
      paramMessage.obj = VideoFeedsPlayManager.b(this.this$0);
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvw
 * JD-Core Version:    0.7.0.1
 */