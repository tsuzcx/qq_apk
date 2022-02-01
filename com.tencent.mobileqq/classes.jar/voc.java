import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.hippy.QCircleHippyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class voc
  implements View.OnClickListener
{
  public voc(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    QCircleHippyFragment.a(this.a);
    vrh.a("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ret_code", "-1"), vri.a("attach_info", "network error,module name:" + QCircleHippyFragment.a(this.a)) }), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voc
 * JD-Core Version:    0.7.0.1
 */