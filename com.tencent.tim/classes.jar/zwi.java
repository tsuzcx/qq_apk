import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class zwi
  implements View.OnClickListener
{
  zwi(zwh paramzwh) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)zwh.a(this.a).selectedPhotoList.get(0), new zwj(this));
    AIOLongShotHelper.report("0X8009DEE");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zwi
 * JD-Core Version:    0.7.0.1
 */