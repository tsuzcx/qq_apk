import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import mqq.util.WeakReference;

class urp
  implements Runnable
{
  urp(uro paramuro) {}
  
  public void run()
  {
    if (DoodleMsgView.a(this.a.a) != null)
    {
      urt localurt = (urt)DoodleMsgView.a(this.a.a).get();
      if (localurt != null) {
        localurt.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urp
 * JD-Core Version:    0.7.0.1
 */