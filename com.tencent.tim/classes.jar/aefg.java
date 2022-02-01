import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

class aefg
  implements URLDrawable.URLDrawableListener
{
  aefg(aefe paramaefe, RoundImageView paramRoundImageView, aexi paramaexi, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentDanmakuRender", 2, "onLoadCanceled : " + this.bhf);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentDanmakuRender", 2, "onLoadFailed : " + this.bhf);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.g.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_Aexi.setDrawCacheDirty(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefg
 * JD-Core Version:    0.7.0.1
 */