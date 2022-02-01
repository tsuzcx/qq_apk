import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastImageViewCreator.ImageViewHolder.1.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class nlt
  implements URLDrawableDownListener
{
  nlt(nls.a parama) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + nls.a.a(this.a));
    paramThrowable = (ImageData)this.a.g;
    boolean bool = nls.ec(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = nls.a(paramThrowable.url, paramThrowable);; paramView = paramThrowable.url)
    {
      paramView = obs.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if (nls.a.b(this.a) < 2) {
        nls.a.c(this.a);
      }
      nls.a.d(this.a);
      if ((bool) && (nls.a.a(this.a) < 3))
      {
        paramThrowable.atr = false;
        ThreadManager.getUIHandler().post(new WebFastImageViewCreator.ImageViewHolder.1.1(this, paramThrowable));
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", paramThrowable.url);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "NativeWebImageUI", false, 0L, 0L, paramView, "", true);
      return;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    ImageData localImageData = (ImageData)this.a.g;
    boolean bool = nls.ec(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = nls.a(localImageData.url, localImageData);; paramView = localImageData.url)
    {
      paramView = obs.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if ((localImageData.width == 0) || (localImageData.height == 0))
      {
        nls.a.a(this.a, paramURLDrawable);
        nls.a.a(this.a).setImageDrawable(paramURLDrawable);
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", localImageData.url);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "NativeWebImageUI", true, 0L, 0L, paramView, "", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlt
 * JD-Core Version:    0.7.0.1
 */