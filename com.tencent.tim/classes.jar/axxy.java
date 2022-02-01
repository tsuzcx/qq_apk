import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView.a;
import java.lang.ref.WeakReference;

public class axxy
  implements View.OnClickListener
{
  public axxy(VideoCoverPickerProviderView paramVideoCoverPickerProviderView) {}
  
  public void onClick(View paramView)
  {
    if (VideoCoverPickerProviderView.a(this.a) != null)
    {
      VideoCoverPickerProviderView.a locala = (VideoCoverPickerProviderView.a)VideoCoverPickerProviderView.a(this.a).get();
      if (locala != null) {
        locala.aF(VideoCoverPickerProviderView.b(this.a), false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxy
 * JD-Core Version:    0.7.0.1
 */