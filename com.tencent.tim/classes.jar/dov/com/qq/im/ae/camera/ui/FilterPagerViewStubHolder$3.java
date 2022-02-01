package dov.com.qq.im.ae.camera.ui;

import awwp;
import axov;
import axpr;
import ayva.a;
import ayva.b;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(awwp paramawwp, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((axpr)axov.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = awwp.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((ayva.a)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.bD(((ayva.b)localObject).filterList);
      }
      if (!this.dto) {
        awwp.a(this.this$0).adv(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      awwp.a(this.this$0).eTQ();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */