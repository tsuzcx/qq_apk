import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.6.1;
import java.util.List;
import java.util.concurrent.Executor;

public class afhq
  implements URLDrawable.URLDrawableListener
{
  afhq(afhl paramafhl, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    afhl.a(this.this$0).zG.remove(this.y);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    afhl.a(this.this$0).zG.remove(this.y);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afhl.a(this.this$0).zG.remove(this.y);
    afhl.c().execute(new EmoticonFromGroupManager.6.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhq
 * JD-Core Version:    0.7.0.1
 */