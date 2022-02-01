import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ajxi
  implements URLDrawable.URLDrawableListener
{
  ajxi(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, ajxd.a parama) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ram.i("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ajxd.b(this.val$app, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, null, this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ram.i("ShortVideoShareUtil", "onLoadProgressed --" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ajxd.drawableToBitmap(paramURLDrawable);
    ajxd.b(this.val$app, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, paramURLDrawable, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxi
 * JD-Core Version:    0.7.0.1
 */