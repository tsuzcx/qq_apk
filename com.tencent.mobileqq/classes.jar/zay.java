import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.superplayer.api.ISuperPlayer;

public class zay
  implements zvn
{
  public zay(BaseVideoView paramBaseVideoView, SeekBar paramSeekBar) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = -1001;
    localMessage.arg1 = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    localMessage.arg2 = ((int)this.jdField_a_of_type_ComTencentBizRichframeworkWidgetBaseVideoView.a().getDurationMs());
    localMessage.obj = Boolean.valueOf(false);
    if (this.jdField_a_of_type_ComTencentBizRichframeworkWidgetBaseVideoView.c()) {
      this.jdField_a_of_type_ComTencentBizRichframeworkWidgetBaseVideoView.a(this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress());
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkWidgetBaseVideoView.a().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */