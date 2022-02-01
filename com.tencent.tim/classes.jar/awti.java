import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout.a;

class awti
  implements TabLayout.a
{
  awti(awth paramawth) {}
  
  public boolean nX(int paramInt)
  {
    return (paramInt != 1) || (awth.a(this.a));
  }
  
  public void of(int paramInt)
  {
    if (paramInt == 0)
    {
      awth.a(this.a).setCurrentItem(0, true);
      awth.a(this.a).onActivityPause();
      awth.a(this.a).onActivityStop();
      axim.a().eLj();
      return;
    }
    if (awth.a(this.a))
    {
      awth.a(this.a);
      axim.a().eLk();
      return;
    }
    awth.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awti
 * JD-Core Version:    0.7.0.1
 */