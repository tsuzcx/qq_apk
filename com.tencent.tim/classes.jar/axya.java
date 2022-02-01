import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.a;
import java.lang.ref.WeakReference;

public class axya
  implements View.OnClickListener
{
  public axya(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    VideoSegmentPickerProviderView.a(this.a).mSegmentKeeper.clearSegments();
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      VideoSegmentPickerProviderView.a locala = (VideoSegmentPickerProviderView.a)VideoSegmentPickerProviderView.a(this.a).get();
      if (locala != null) {
        locala.aS(0L, 0L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axya
 * JD-Core Version:    0.7.0.1
 */