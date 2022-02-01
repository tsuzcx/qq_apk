import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class cer
  implements Runnable
{
  cer(ceq paramceq, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_Ceq.a, true);
    PullRefreshHeader localPullRefreshHeader;
    if (Conversation.b(this.jdField_a_of_type_Ceq.a))
    {
      Conversation.a(this.jdField_a_of_type_Ceq.a, 800L);
      localPullRefreshHeader = Conversation.a(this.jdField_a_of_type_Ceq.a);
      if (!this.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cer
 * JD-Core Version:    0.7.0.1
 */