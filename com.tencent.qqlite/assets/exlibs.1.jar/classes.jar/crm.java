import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

public class crm
  extends Thread
{
  public crm(CardHandler paramCardHandler, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a.a();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a.getManager(43);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crm
 * JD-Core Version:    0.7.0.1
 */