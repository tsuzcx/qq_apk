import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class ecq
  extends FriendListObserver
{
  public ecq(StatusManager paramStatusManager) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.set", 2, "onSetSelfSignatureResult " + paramBoolean);
    }
    StatusManager.a(this.a, null);
    if (paramBoolean) {}
    for (int i = 100; StatusManager.b(this.a) != null; i = -1)
    {
      RichStatus localRichStatus = this.a.a();
      Iterator localIterator = StatusManager.b(this.a).iterator();
      while (localIterator.hasNext()) {
        ((IStatusListener)localIterator.next()).a(i, localRichStatus);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecq
 * JD-Core Version:    0.7.0.1
 */