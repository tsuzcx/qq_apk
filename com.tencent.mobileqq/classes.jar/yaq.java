import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class yaq
  implements Runnable
{
  public yaq(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void run()
  {
    VideoFilterViewPager.a(this.a).onPageSelected(this.a.getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yaq
 * JD-Core Version:    0.7.0.1
 */