import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;

public class aynn
  implements URLDrawable.URLDrawableListener
{
  public aynn(NormalFaceAdapter paramNormalFaceAdapter, String paramString1, ayne paramayne, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ram.d("NormalFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.cXk);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ram.d("NormalFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.cXk);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    NormalFaceAdapter.a(this.this$0).h(this.cXk, paramURLDrawable);
    NormalFaceAdapter.a(this.this$0, this.b, paramURLDrawable, this.val$imageView, this.cXk, this.val$name, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynn
 * JD-Core Version:    0.7.0.1
 */