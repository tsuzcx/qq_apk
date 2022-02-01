import android.annotation.TargetApi;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.a;
import java.util.ArrayList;
import java.util.Iterator;

public class utf
  implements DrawerFrame.a
{
  public utf(Conversation paramConversation) {}
  
  public void AD(int paramInt)
  {
    if (this.this$0.jdField_a_of_type_Aajg != null) {
      this.this$0.jdField_a_of_type_Aajg.hi();
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.isResume())) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.bUa();
    }
    if (this.this$0.b != null) {
      this.this$0.b.bnl();
    }
  }
  
  public void aC(int paramInt, boolean paramBoolean) {}
  
  public void eZ(int paramInt1, int paramInt2)
  {
    this.this$0.jdField_a_of_type_Akze.onDrawerOpened();
    if (this.this$0.pb != null)
    {
      Iterator localIterator = this.this$0.pb.iterator();
      while (localIterator.hasNext())
      {
        adue localadue = (adue)localIterator.next();
        if (localadue != null) {
          localadue.onDrawerOpened();
        }
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.onDrawerOpened();
    }
    if (this.this$0.b != null) {
      this.this$0.b.onDrawerOpened();
    }
  }
  
  public void fa(int paramInt1, int paramInt2)
  {
    Conversation.j(this.this$0);
    this.this$0.jdField_a_of_type_Akze.onDrawerClosed();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.onDrawerClosed();
    }
    if (this.this$0.b != null) {
      this.this$0.b.onDrawerClosed();
    }
    if (this.this$0.jdField_a_of_type_Aamm != null) {
      this.this$0.jdField_a_of_type_Aamm.onDrawerClosed();
    }
  }
  
  @TargetApi(11)
  public void m(int paramInt, float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     utf
 * JD-Core Version:    0.7.0.1
 */