import com.tencent.gdtad.views.image.GdtGifImageView;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.net.URL;

public class zba
  implements zaz
{
  public zba(GdtGifImageView paramGdtGifImageView) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      yxp.b("GdtImageView", String.format("onLoadSuccessful %s", new Object[] { str }));
      GdtGifImageView.a(this.a, paramURLDrawable, str);
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null) && (GdtGifImageView.a(this.a))) {
        ((zbb)GdtGifImageView.a(this.a).get()).a(true);
      }
      return;
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (String str = paramURLDrawable.getURL().toString();; str = null)
    {
      yxp.b("GdtImageView", String.format("onLoadFailed %s", new Object[] { str }));
      GdtGifImageView.a(this.a, paramURLDrawable, str);
      if ((GdtGifImageView.a(this.a) != null) && (GdtGifImageView.a(this.a).get() != null)) {
        ((zbb)GdtGifImageView.a(this.a).get()).a(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zba
 * JD-Core Version:    0.7.0.1
 */