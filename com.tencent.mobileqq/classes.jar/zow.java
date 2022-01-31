import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import java.util.Iterator;
import java.util.LinkedList;

class zow
  implements Runnable
{
  zow(zov paramzov, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (NewFriendManager.a(this.jdField_a_of_type_Zov.a))
      {
        Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_Zov.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).R_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zow
 * JD-Core Version:    0.7.0.1
 */