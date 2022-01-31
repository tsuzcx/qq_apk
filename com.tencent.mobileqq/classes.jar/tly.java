import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.ApolloStepInfo;
import com.tencent.mobileqq.apollo.drawer.StepDrawerStatus;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;

class tly
  implements Runnable
{
  tly(tlx paramtlx) {}
  
  public void run()
  {
    Object localObject = new ApolloStepInfo(SSOHttpUtils.a());
    localObject = new StepDrawerStatus(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloStepInfo)localObject);
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a((ApolloDrawerStatus)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */