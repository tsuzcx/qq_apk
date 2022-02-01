import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;

public class ryw
  implements sow.a
{
  public ryw(BaseVideoView paramBaseVideoView, SeekBar paramSeekBar) {}
  
  public void bkR()
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = this.i.getProgress();
    localMessage.arg2 = ((int)this.this$0.a().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (this.this$0.HK()) {
      this.this$0.seek(this.i.getProgress());
    }
    this.this$0.getMainHandler().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryw
 * JD-Core Version:    0.7.0.1
 */