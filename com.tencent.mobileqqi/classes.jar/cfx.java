import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import java.util.List;

public class cfx
  implements DragRelativeLayout.OnDragModeChangedListener
{
  private int jdField_a_of_type_Int = -2147483648;
  private List jdField_a_of_type_JavaUtilList;
  
  private cfx(Conversation paramConversation) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramDragRelativeLayout.a() == -1)
    {
      if ((this.jdField_a_of_type_Int == -2147483648) || (Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation) != null)) {
        Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).sendEmptyMessage(10);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.setDrawerEnabled(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.setDrawerEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfx
 * JD-Core Version:    0.7.0.1
 */