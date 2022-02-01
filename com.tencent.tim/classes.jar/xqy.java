import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.b;

public class xqy
  implements CustomFrameAnimationDrawable.a
{
  public xqy(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void onEnd()
  {
    UnlimitedBladeWorks.a(this.this$0).aPN = true;
    UnlimitedBladeWorks.a(this.this$0).hi = false;
    if (UnlimitedBladeWorks.a(this.this$0) != null)
    {
      UnlimitedBladeWorks.a(this.this$0).end();
      if (UnlimitedBladeWorks.b(this.this$0))
      {
        HapticManager.a().X(UnlimitedBladeWorks.a(this.this$0));
        UnlimitedBladeWorks.a(this.this$0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqy
 * JD-Core Version:    0.7.0.1
 */