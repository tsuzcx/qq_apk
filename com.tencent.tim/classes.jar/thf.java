import android.content.Context;
import android.view.View;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerViewWithLetterStyle;
import java.lang.ref.WeakReference;

public class thf
{
  public static the a(thd paramthd)
  {
    GdtBannerViewWithLetterStyle localGdtBannerViewWithLetterStyle = null;
    Object localObject = null;
    if ((paramthd == null) || (!paramthd.isValid()) || (!paramthd.c.isValid())) {
      tkw.e("GdtBannerViewBuilder", "build error");
    }
    do
    {
      return localObject;
      if (paramthd.style == 0) {
        localGdtBannerViewWithLetterStyle = new GdtBannerViewWithLetterStyle((Context)paramthd.c.activity.get(), paramthd.c.ad);
      }
      if ((localGdtBannerViewWithLetterStyle != null) && (localGdtBannerViewWithLetterStyle.getView() != null) && (the.a != null))
      {
        localGdtBannerViewWithLetterStyle.getView().setOnTouchListener(new thg(localGdtBannerViewWithLetterStyle));
        localGdtBannerViewWithLetterStyle.getView().setOnClickListener(new thh(localGdtBannerViewWithLetterStyle, paramthd));
      }
      localObject = localGdtBannerViewWithLetterStyle;
    } while (localGdtBannerViewWithLetterStyle == null);
    localGdtBannerViewWithLetterStyle.setSize(paramthd.width, paramthd.height);
    return localGdtBannerViewWithLetterStyle;
  }
  
  public static int ad(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return Double.valueOf(1.0D * paramInt2 / 1026.0D * 249.0D).intValue();
    }
    tkw.e("GdtBannerViewBuilder", "getHeight error");
    return -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thf
 * JD-Core Version:    0.7.0.1
 */