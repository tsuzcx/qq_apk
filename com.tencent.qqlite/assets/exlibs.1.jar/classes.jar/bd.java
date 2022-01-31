import android.content.Intent;
import android.view.View;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class bd
  implements ActionSheet.OnButtonClickListener
{
  public bd(LiteAdvanceActivity paramLiteAdvanceActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.a(), "dl_ckclearmsg");
      paramView = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.a(8);
      paramView.d(32);
      paramView.e();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.a().a().a();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent().putExtra("clear_flag", true);
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.setResult(-1, this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent());
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */