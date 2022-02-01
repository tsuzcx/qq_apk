import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;

class awrw
  implements MediaScanner.OnMediaInfoScannerListener
{
  awrw(awrq paramawrq) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.this$0.onCaptureError(101);
      return;
    }
    this.this$0.a(this.this$0.c, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrw
 * JD-Core Version:    0.7.0.1
 */