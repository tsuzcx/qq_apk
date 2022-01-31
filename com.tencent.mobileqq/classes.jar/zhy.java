import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class zhy
  implements PhoneContactManager.IPhoneContactListener
{
  public zhy(NewFriendManager paramNewFriendManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onBindStateChanged = " + paramInt);
    }
    this.a.b();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onRecommendCountChanged = " + paramInt);
    }
    this.a.b();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onUpdateContactList = " + paramInt);
    }
    if ((paramInt & 0x1) != 0) {
      synchronized (NewFriendManager.a(this.a))
      {
        Iterator localIterator = NewFriendManager.a(this.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhy
 * JD-Core Version:    0.7.0.1
 */