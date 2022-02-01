import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;

public class aynk
  implements URLDrawable.URLDrawableListener
{
  public aynk(InformationFaceAdapter paramInformationFaceAdapter, String paramString, ayna.c paramc) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ram.d("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.cXk);
    InformationFaceAdapter.a(this.this$0, this.cXk);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ram.d("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.cXk);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    InformationFaceAdapter.a(this.this$0).h(this.cXk, paramURLDrawable);
    InformationFaceAdapter.a(this.this$0, paramURLDrawable, this.cXk, this.b.cWb, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynk
 * JD-Core Version:    0.7.0.1
 */