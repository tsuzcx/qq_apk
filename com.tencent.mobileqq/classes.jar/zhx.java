import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import java.util.Iterator;
import java.util.LinkedList;

class zhx
  implements Runnable
{
  zhx(zhw paramzhw, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (NewFriendManager.a(this.jdField_a_of_type_Zhw.a))
      {
        Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_Zhw.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).Q_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhx
 * JD-Core Version:    0.7.0.1
 */