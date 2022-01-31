import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import java.util.Iterator;
import java.util.LinkedList;

public class zoy
  implements Runnable
{
  public zoy(NewFriendManager paramNewFriendManager, int paramInt) {}
  
  public void run()
  {
    synchronized (NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager))
    {
      Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager).iterator();
      if (localIterator.hasNext()) {
        ((NewFriendManager.INewFriendListener)localIterator.next()).a(this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zoy
 * JD-Core Version:    0.7.0.1
 */