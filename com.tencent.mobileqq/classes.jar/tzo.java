import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.biz.qqcircle.widgets.BaseVideoView;

public class tzo
  implements ytf
{
  public tzo(BaseVideoView paramBaseVideoView, SeekBar paramSeekBar) {}
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress();
    localMessage.arg2 = ((int)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsBaseVideoView.a().b());
    localMessage.obj = Boolean.valueOf(false);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsBaseVideoView.a(this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsBaseVideoView.a().sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzo
 * JD-Core Version:    0.7.0.1
 */