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

public class uke
{
  private static void a(swi paramswi)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    if (paramswi.a.a.a.K != null) {}
    try
    {
      localObject = URLDrawable.getDrawable(new URL(paramswi.a.a.a.K), (URLDrawable.URLDrawableOptions)localObject);
      paramswi.b.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramswi)
    {
      paramswi.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean1, swu paramswu, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    if (!(paramswu instanceof swi)) {}
    for (;;)
    {
      return;
      swi localswi = (swi)paramswu;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          int i = AIOUtils.dp2px(15.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.dp2px(202.0F, BaseApplication.getContext().getResources());
          ((swi)paramswu).d.setPadding(i, 0, 0, j);
        }
        localswi.b.setVisibility(0);
        a(localswi);
      }
      while (localswi.b != null)
      {
        localswi.b.setOnClickListener(paramOnClickListener);
        localswi.b.setTag(localswi);
        return;
        ((swi)paramswu).b.setVisibility(8);
      }
    }
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (paramVideoInfo.a.t == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */