import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;

class yoc
  implements Runnable
{
  yoc(yob paramyob) {}
  
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
 * Qualified Name:     yoc
 * JD-Core Version:    0.7.0.1
 */