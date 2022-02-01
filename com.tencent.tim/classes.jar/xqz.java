import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.a;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.a;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.b;

public class xqz
  implements CustomFrameAnimationDrawable.a
{
  public xqz(UnlimitedBladeWorks.a parama) {}
  
  public void onEnd()
  {
    UnlimitedBladeWorks.a(this.b.this$0).aPN = true;
    UnlimitedBladeWorks.a(this.b.this$0).hi = false;
    if (UnlimitedBladeWorks.a(this.b.this$0) != null)
    {
      UnlimitedBladeWorks.a(this.b.this$0).end();
      if (UnlimitedBladeWorks.b(this.b.this$0))
      {
        HapticManager.a().X(UnlimitedBladeWorks.a(this.b.this$0));
        UnlimitedBladeWorks.a(this.b.this$0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqz
 * JD-Core Version:    0.7.0.1
 */