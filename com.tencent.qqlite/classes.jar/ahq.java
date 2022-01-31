import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import java.util.List;

public class ahq
  implements DragFrameLayout.OnDragModeChangedListener
{
  private int jdField_a_of_type_Int = -2147483648;
  private List jdField_a_of_type_JavaUtilList;
  
  private ahq(Conversation paramConversation) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((paramDragFrameLayout.a() == -1) && ((this.jdField_a_of_type_Int == -2147483648) || (Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation) != null))) {
      Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).sendEmptyMessage(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ahq
 * JD-Core Version:    0.7.0.1
 */