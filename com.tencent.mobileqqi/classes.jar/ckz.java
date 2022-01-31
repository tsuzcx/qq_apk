import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class ckz
  implements Runnable
{
  ckz(cky paramcky, boolean paramBoolean) {}
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_Cky.a, true);
    PullRefreshHeader localPullRefreshHeader;
    if (Conversation.b(this.jdField_a_of_type_Cky.a))
    {
      Conversation.a(this.jdField_a_of_type_Cky.a, 800L);
      localPullRefreshHeader = Conversation.a(this.jdField_a_of_type_Cky.a);
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
 * Qualified Name:     ckz
 * JD-Core Version:    0.7.0.1
 */