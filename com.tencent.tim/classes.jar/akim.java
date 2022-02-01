import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.qphone.base.util.QLog;

public class akim
  implements URLDrawable.URLDrawableListener
{
  public akim(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.a(this.this$0) == 1) {
      NearbyMomentFragment.a(this.this$0).setVisibility(8);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.a(this.this$0) == 1)
    {
      NearbyMomentFragment.a(this.this$0).setImageDrawable(paramURLDrawable);
      NearbyMomentFragment.a(this.this$0).setVisibility(0);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akim
 * JD-Core Version:    0.7.0.1
 */