import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbh
  implements View.OnClickListener
{
  public afbh(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    aqha.b(this.a.getActivity(), 0, 2131559808, acfp.m(2131704648), "", acfp.m(2131704643), acfp.m(2131704649), new afbi(this), new afbj(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbh
 * JD-Core Version:    0.7.0.1
 */