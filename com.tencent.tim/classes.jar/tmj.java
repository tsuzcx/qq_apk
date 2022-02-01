import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class tmj
  implements URLDrawable.URLDrawableListener
{
  tmj(tmi paramtmi) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    tmi.a(this.this$0, paramURLDrawable);
    tkw.i("GdtDrawableLoader", "onLoadCanceled " + tmi.a(this.this$0));
    tmi.a(this.this$0, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    tmi.a(this.this$0, paramURLDrawable);
    tkw.e("GdtDrawableLoader", "onLoadFialed " + tmi.a(this.this$0), paramThrowable);
    if (!tmi.a(this.this$0)) {
      tmi.a(this.this$0, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    tmi.a(this.this$0, paramURLDrawable);
    tkw.i("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + tmi.a(this.this$0));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    tmi.a(this.this$0, paramURLDrawable);
    tkw.i("GdtDrawableLoader", "onLoadSuccessed " + tmi.a(this.this$0));
    tmi.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmj
 * JD-Core Version:    0.7.0.1
 */