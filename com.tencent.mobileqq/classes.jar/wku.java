import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wku
  implements ThreadExcutor.IThreadListener
{
  public wku(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void a() {}
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new wkv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wku
 * JD-Core Version:    0.7.0.1
 */