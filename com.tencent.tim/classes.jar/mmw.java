import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.AbsPublishColumnFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class mmw
  implements URLDrawable.URLDrawableListener
{
  public mmw(AbsPublishColumnFragment paramAbsPublishColumnFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    AbsPublishColumnFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmw
 * JD-Core Version:    0.7.0.1
 */