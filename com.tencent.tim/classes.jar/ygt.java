import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ygt
  implements URLDrawable.URLDrawableListener
{
  ygt(ygr paramygr) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ygr.a(this.this$0).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ygr.a(this.this$0, paramURLDrawable);
    ygr.a(this.this$0).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = ygr.a(this.this$0);
    ygr.a(this.this$0, paramURLDrawable, l1 - l2);
    ygr.a(this.this$0, true);
    ygr.a(this.this$0).remove(paramURLDrawable);
    this.this$0.cik();
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygt
 * JD-Core Version:    0.7.0.1
 */