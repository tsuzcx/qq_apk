import android.content.Intent;
import android.view.View;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class cc
  implements ActionSheet.OnButtonClickListener
{
  public cc(LiteAdvanceActivity paramLiteAdvanceActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.b.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.b.a(), "dl_ckclearmsg");
      paramView = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.b.a(8);
      paramView.d(32);
      paramView.e();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.b.a().b();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent().putExtra("clear_flag", true);
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.setResult(-1, this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent());
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cc
 * JD-Core Version:    0.7.0.1
 */