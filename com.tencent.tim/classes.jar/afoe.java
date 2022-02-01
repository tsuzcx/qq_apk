import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afoe
  implements URLDrawable.URLDrawableListener
{
  afoe(afoc paramafoc) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.this$0.qV.remove(paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = paramURLDrawable.getTag();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
      {
        paramURLDrawable = (Emoticon)paramURLDrawable;
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener onLoadCanceled eId = " + paramURLDrawable.eId);
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.this$0.qV.remove(paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = paramURLDrawable.getTag();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
      {
        paramURLDrawable = (Emoticon)paramURLDrawable;
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener onLoadFialed eId = " + paramURLDrawable.eId);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.this$0.qV.remove(paramURLDrawable);
    paramURLDrawable = paramURLDrawable.getTag();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof Emoticon)))
    {
      paramURLDrawable = (Emoticon)paramURLDrawable;
      if (!this.this$0.Af.contains(paramURLDrawable)) {
        this.this$0.Af.add(paramURLDrawable);
      }
      this.this$0.cik();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionKeywordAdapter", 2, "firstScreenListener downloadSucess eId = " + paramURLDrawable.eId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoe
 * JD-Core Version:    0.7.0.1
 */