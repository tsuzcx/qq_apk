import com.tencent.gdtad.api.banner.GdtBannerImageView;
import com.tencent.image.URLDrawable;
import java.net.URL;

public class thc
  implements tmi.a
{
  public thc(GdtBannerImageView paramGdtBannerImageView) {}
  
  public void e(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      tkw.i("GdtBannerImageView", String.format("onLoadSuccessful %s", new Object[] { paramURLDrawable }));
      return;
    }
  }
  
  public void f(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {}
    for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = null)
    {
      tkw.i("GdtBannerImageView", String.format("onLoadFailed %s", new Object[] { paramURLDrawable }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thc
 * JD-Core Version:    0.7.0.1
 */