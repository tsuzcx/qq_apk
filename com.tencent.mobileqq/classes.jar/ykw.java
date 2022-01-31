import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;

class ykw
  implements Runnable
{
  ykw(ykv paramykv) {}
  
  public void run()
  {
    if (HotChatCenterFragment.a(this.a.a) != null)
    {
      HotChatCenterFragment.a(this.a.a).a(4);
      HotChatCenterFragment.a(this.a.a).a(HotChatCenterFragment.a(this.a.a));
      HotChatCenterFragment.a(this.a.a).notifyDataSetChanged();
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykw
 * JD-Core Version:    0.7.0.1
 */