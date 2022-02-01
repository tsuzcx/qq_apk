import com.tencent.biz.qqcircle.hippy.QCircleHippyFragment;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

public class vod
  implements HippyQQEngine.HippyQQEngineListener
{
  public vod(QCircleHippyFragment paramQCircleHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    QCircleHippyFragment.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHippyFragment", 2, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    vrh.a("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("time_cost", String.valueOf(d)), vri.a("ret_code", String.valueOf(paramInt)), vri.a("attach_info", "errMsg:" + paramString + ",module name:" + QCircleHippyFragment.a(this.a)) }), false);
  }
  
  public void onSuccess()
  {
    this.a.a.d();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleHippyFragment", 2, "Hippy: initHippy success!");
    }
    double d = 0.0D;
    if (QCircleHippyFragment.a(this.a) > 0L)
    {
      d = (float)(System.currentTimeMillis() - QCircleHippyFragment.a(this.a)) / 1000.0F;
      QCircleHippyFragment.a(this.a, 0L);
    }
    vrh.a("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("time_cost", String.valueOf(d)), vri.a("ret_code", "0"), vri.a("attach_info", "module name:" + QCircleHippyFragment.a(this.a)) }), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */