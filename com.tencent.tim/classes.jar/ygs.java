import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import org.apache.http.Header;

class ygs
  implements URLDrawableDownListener
{
  ygs(ygr paramygr) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "drawableListener onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ygr.a(this.this$0, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.e("StickerRecBarAdapter", 2, "drawableListener onLoadFialed:" + paramURLDrawable.getURL(), paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "drawableListener onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    l2 = -1L;
    try
    {
      Object localObject = paramURLDrawable.getHeader("report_key_start_download");
      l1 = l2;
      if (localObject != null)
      {
        localObject = ((Header)localObject).getValue();
        l1 = l2;
        if (localObject != null)
        {
          l1 = Long.parseLong((String)localObject);
          long l3 = System.currentTimeMillis();
          l1 = l3 - l1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("StickerRecBarAdapter", 2, "onLoadSuccessed:get start download time");
          l1 = l2;
        }
      }
    }
    ygr.a(this.this$0, paramURLDrawable, l1);
    paramView = paramView.getTag();
    if (yhf.b((ygl)paramView))
    {
      paramView = (ygz)paramView;
      if ((yhf.b(paramView)) && (!ygr.a(this.this$0).contains(paramView.getMd5())))
      {
        ygr.a(this.this$0).add(paramView.getMd5());
        paramURLDrawable = paramView.getFilePath();
        ygr.a(this.this$0).add(new StickerRecCacheEntity(paramURLDrawable, System.currentTimeMillis(), paramView.getMd5()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygs
 * JD-Core Version:    0.7.0.1
 */