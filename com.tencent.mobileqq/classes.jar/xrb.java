import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class xrb
  implements Runnable
{
  public xrb(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void run()
  {
    VideoFilterViewPager.a(this.a).onPageSelected(this.a.getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrb
 * JD-Core Version:    0.7.0.1
 */