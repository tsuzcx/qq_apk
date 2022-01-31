import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class wnz
  implements ThreadExcutor.IThreadListener
{
  public wnz(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void a() {}
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new woa(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnz
 * JD-Core Version:    0.7.0.1
 */