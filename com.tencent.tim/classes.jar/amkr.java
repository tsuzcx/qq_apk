import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amkr
  implements View.OnClickListener
{
  amkr(amkp paramamkp, argu paramargu) {}
  
  public void onClick(View paramView)
  {
    ((aclk)amkn.a(this.jdField_a_of_type_Amkp.a).getManager(299)).cMp();
    this.jdField_a_of_type_Argu.dismiss();
    amkn.a(this.jdField_a_of_type_Amkp.a);
    amub.a(this.jdField_a_of_type_Amkp.val$app, new ReportModelDC02528().module("all_result").action("clk_his_del").ver2(amub.eZ(this.jdField_a_of_type_Amkp.a.fromType)).ver7("{experiment_id:" + amub.cce + "}"));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkr
 * JD-Core Version:    0.7.0.1
 */