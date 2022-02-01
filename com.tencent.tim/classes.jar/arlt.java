import android.graphics.Bitmap;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;

class arlt
  implements VideoPlayerCallback
{
  arlt(arlq paramarlq) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TVKVideoController", 1, "module ===== " + paramInt1 + "  errorType ===== " + paramInt2 + "  errorCode ==== " + paramInt3 + "  exInfo === " + paramString);
    arlq.a(this.this$0, paramInt1, paramInt3);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (arlq.a(this.this$0) != null) {
      arlq.a(this.this$0).onVideoProgressUpdate((int)paramLong2);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TVKVideoController", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 4: 
      arlq.c(this.this$0);
      arlq.a(this.this$0, 4);
      return;
    case 3: 
      if ((arlq.a(this.this$0) != null) && (arlq.a(this.this$0) != null))
      {
        arlq.a(this.this$0).onSetVideoCover(arlq.a(this.this$0));
        arlq.a(this.this$0).onVideoSize(arlq.a(this.this$0), arlq.b(this.this$0));
      }
      arlq.a(this.this$0, 3);
      return;
    case 8: 
      if (arlq.a(this.this$0) != null) {
        arlq.a(this.this$0).Lx = 0L;
      }
      if (arlq.a(this.this$0) != null) {
        arlq.a(this.this$0).mStartPlayPosMs = 0L;
      }
      arlq.d(this.this$0);
      if (arlq.a(this.this$0) != null)
      {
        arlq.a(this.this$0).onVideoComplete(true);
        arlq.a(this.this$0).onVideoProgressUpdate(0);
      }
      arlq.a(this.this$0, 8);
      return;
    case 7: 
      arlq.a(this.this$0, 7);
      return;
    }
    if (arlq.a(this.this$0) != null) {
      arlq.a(this.this$0).onVideoBuffering();
    }
    arlq.a(this.this$0, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlt
 * JD-Core Version:    0.7.0.1
 */