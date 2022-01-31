import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class zhy
  implements Runnable
{
  public zhy(CardHandler paramCardHandler, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getCurrentAccountUin();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b.getManager(50);
    Card localCard = localFriendsManager.a(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.jdField_a_of_type_Int;
      localFriendsManager.a(localCard);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      CardHandler.a(str, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhy
 * JD-Core Version:    0.7.0.1
 */