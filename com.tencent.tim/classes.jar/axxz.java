import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.a;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentPicker;
import java.lang.ref.WeakReference;
import java.util.List;

public class axxz
  implements View.OnClickListener
{
  public axxz(VideoSegmentPickerProviderView paramVideoSegmentPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    long l1 = 0L;
    VideoSegmentPickerProviderView.a locala;
    long l2;
    if (VideoSegmentPickerProviderView.a(this.a) != null)
    {
      List localList = VideoSegmentPickerProviderView.a(this.a).hZ();
      VideoSegmentPickerProviderView.a(this.a).mSegmentKeeper.clearSegments();
      VideoSegmentPickerProviderView.a(this.a).mSegmentKeeper.addSegment(localList);
      if (VideoSegmentPickerProviderView.a(this.a) != null)
      {
        locala = (VideoSegmentPickerProviderView.a)VideoSegmentPickerProviderView.a(this.a).get();
        if (locala != null)
        {
          if ((localList == null) || (localList.size() <= 0)) {
            break label158;
          }
          l2 = ((Long)((Pair)localList.get(0)).first).longValue();
          l1 = ((Long)((Pair)localList.get(0)).second).longValue();
        }
      }
    }
    for (;;)
    {
      locala.aS(l2, l1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label158:
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxz
 * JD-Core Version:    0.7.0.1
 */