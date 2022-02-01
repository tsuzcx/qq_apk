import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class chh
  implements Runnable
{
  public chh(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.b.getManager(48);
    new ArrayList();
    localObject = ((DiscussionManager)localObject).a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, ((List)localObject).size());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chh
 * JD-Core Version:    0.7.0.1
 */