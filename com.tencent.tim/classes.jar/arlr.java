import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.qphone.base.util.QLog;

class arlr
  implements IVideoInnerStatusListener
{
  arlr(arlq paramarlq) {}
  
  public void notifyVideoClose(int paramInt)
  {
    this.this$0.destory();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    if (arlq.a(this.this$0) != null)
    {
      int i = (int)(paramInt * arlq.a(this.this$0).getVideoDurationMs() / 100.0D);
      arlq.a(this.this$0, i);
      if (QLog.isColorLevel()) {
        QLog.d("TVKVideoController", 2, "mOuterStatusListener notifyVideoSeek : " + paramInt + "  seekMillSec :" + i);
      }
    }
  }
  
  public void notifyVideoStart()
  {
    arlq.a(this.this$0);
  }
  
  public void notifyVideoStop()
  {
    arlq.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlr
 * JD-Core Version:    0.7.0.1
 */