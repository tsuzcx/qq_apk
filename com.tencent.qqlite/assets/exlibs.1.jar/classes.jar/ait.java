import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class ait
  implements Runnable
{
  public ait(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, String paramString) {}
  
  public void run()
  {
    ArrayList localArrayList = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getManager(45)).a(this.jdField_a_of_type_JavaLangString);
    if (localArrayList != null) {
      DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, localArrayList.size());
    }
    Message localMessage = new Message();
    localMessage.what = 18;
    localMessage.obj = localArrayList;
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ait
 * JD-Core Version:    0.7.0.1
 */