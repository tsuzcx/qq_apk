import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteVideoActivity;
import com.dataline.mpfile.LiteMpFileMainActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class av
  implements AdapterView.OnItemClickListener
{
  public av(LiteActivity paramLiteActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (LiteActivity.a(this.a).a()[paramInt][1])
    {
    case 2130837692: 
    case 2130837693: 
    case 2130837694: 
    case 2130837695: 
    case 2130837697: 
    case 2130837699: 
    default: 
      return;
    case 2130837690: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_cktkphoto");
      this.a.a_();
      ReportController.b(this.a.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      return;
    case 2130837696: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckpic");
      this.a.c();
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return;
    case 2130837700: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckvideo");
      paramAdapterView = new Intent(this.a.getApplicationContext(), LiteVideoActivity.class);
      this.a.startActivityForResult(paramAdapterView, 1);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
      return;
    case 2130837698: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckfile");
      paramAdapterView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramAdapterView.putExtra("category", 6);
      paramAdapterView.putExtra("selectMode", true);
      paramAdapterView.putExtra("targetUin", AppConstants.T);
      paramAdapterView.putExtra("tab_tab_type", 5);
      this.a.startActivityForResult(paramAdapterView, 2);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
      return;
    }
    paramAdapterView = new Intent(this.a.getApplicationContext(), LiteMpFileMainActivity.class);
    this.a.startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     av
 * JD-Core Version:    0.7.0.1
 */