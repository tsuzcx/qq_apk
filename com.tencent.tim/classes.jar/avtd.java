import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.FootNavigationLayout;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;

public class avtd
  implements View.OnClickListener
{
  public avtd(FootNavigationLayout paramFootNavigationLayout, avtr paramavtr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aqik.c(((BaseActivity)this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext()).app, this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), this.jdField_a_of_type_Avtr.url);
    if (localObject != null) {
      ((aqhv)localObject).ace();
    }
    for (;;)
    {
      localObject = new LpReportInfo_dc02880(7, FootNavigationLayout.p()[this.val$index]);
      LpReportManager.getInstance().reportToDC02880((LpReportInfo_dc02880)localObject, false, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = new Intent(this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Avtr.url);
      avpw.ay((Intent)localObject);
      this.jdField_a_of_type_CooperationQzoneContentboxFootNavigationLayout.getContext().startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtd
 * JD-Core Version:    0.7.0.1
 */