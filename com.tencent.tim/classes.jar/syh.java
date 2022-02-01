import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class syh
  extends URLDrawableDownListener.Adapter
{
  syh(syg paramsyg, int paramInt, ViewGroup paramViewGroup) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.onLoadFinish(this.val$position, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.a.onLoadProgressUpdate(this.val$position, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.onLoadFinish(this.val$position, true);
    paramView = this.a.a(paramURLDrawable.getURL(), this.val$parent);
    if (paramView != null) {
      this.a.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     syh
 * JD-Core Version:    0.7.0.1
 */