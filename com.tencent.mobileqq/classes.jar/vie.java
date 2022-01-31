import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

class vie
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  vie(vid paramvid) {}
  
  public void a()
  {
    UnlimitedBladeWorks.a(this.a.a).b = true;
    UnlimitedBladeWorks.a(this.a.a).a = false;
    if (UnlimitedBladeWorks.a(this.a.a) != null)
    {
      UnlimitedBladeWorks.a(this.a.a).a();
      if (UnlimitedBladeWorks.b(this.a.a))
      {
        HapticManager.a().c(UnlimitedBladeWorks.a(this.a.a));
        UnlimitedBladeWorks.a(this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vie
 * JD-Core Version:    0.7.0.1
 */