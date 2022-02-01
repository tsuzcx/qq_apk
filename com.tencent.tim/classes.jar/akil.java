import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;

public class akil
  implements URLDrawable.URLDrawableListener
{
  public akil(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.a(this.this$0) == 0) {
      NearbyMomentFragment.a(this.this$0).setVisibility(8);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.a(this.this$0) == 0)
    {
      NearbyMomentFragment.a(this.this$0).setVisibility(0);
      NearbyMomentFragment.a(this.this$0).setImageDrawable(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akil
 * JD-Core Version:    0.7.0.1
 */