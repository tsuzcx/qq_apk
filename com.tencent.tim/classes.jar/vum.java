import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vum
  implements View.OnClickListener
{
  public vum(ShowReactiveActivity paramShowReactiveActivity, aerk paramaerk) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_Aerk.bAD);
    this.jdField_a_of_type_ComTencentMobileqqActivityShowReactiveActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vum
 * JD-Core Version:    0.7.0.1
 */