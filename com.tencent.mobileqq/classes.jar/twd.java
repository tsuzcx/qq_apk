import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.MalformedURLException;
import java.net.URL;

public class twd
{
  private static void a(rvi paramrvi)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    if (paramrvi.a.a.a.K != null) {}
    try
    {
      localObject = URLDrawable.getDrawable(new URL(paramrvi.a.a.a.K), (URLDrawable.URLDrawableOptions)localObject);
      paramrvi.b.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramrvi)
    {
      paramrvi.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean1, rvv paramrvv, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    if (!(paramrvv instanceof rvi)) {}
    for (;;)
    {
      return;
      rvi localrvi = (rvi)paramrvv;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          int i = AIOUtils.dp2px(15.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.dp2px(202.0F, BaseApplication.getContext().getResources());
          ((rvi)paramrvv).f.setPadding(i, 0, 0, j);
        }
        localrvi.b.setVisibility(0);
        a(localrvi);
      }
      while (localrvi.b != null)
      {
        localrvi.b.setOnClickListener(paramOnClickListener);
        localrvi.b.setTag(localrvi);
        return;
        ((rvi)paramrvv).b.setVisibility(8);
      }
    }
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (paramVideoInfo.a.t == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twd
 * JD-Core Version:    0.7.0.1
 */