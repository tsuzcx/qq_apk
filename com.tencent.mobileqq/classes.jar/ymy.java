import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class ymy
  implements yxu
{
  ymy(ymx paramymx, SeekBar paramSeekBar) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    localMessage.arg2 = ((int)this.jdField_a_of_type_Ymx.a.a().b());
    localMessage.obj = Boolean.valueOf(false);
    this.jdField_a_of_type_Ymx.a.a().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */