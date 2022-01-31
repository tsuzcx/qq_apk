import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;

public class yzk
  implements Runnable
{
  public yzk(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a = new TextView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setBackgroundResource(2130846351);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(52.0F, this.jdField_a_of_type_AndroidContentResResources));
    if (ApolloFloatActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setGravity(17);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setTextSize(17.0F);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setText(2131434953);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a, localLayoutParams);
      return;
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.rightMargin = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloFloatActivity.a.setTextColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131494216));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzk
 * JD-Core Version:    0.7.0.1
 */