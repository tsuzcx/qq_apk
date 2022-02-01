import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class aajf
  implements URLDrawable.URLDrawableListener
{
  aajf(aaje paramaaje, aajc paramaajc, aajc.a parama) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load failed.");
    paramURLDrawable = null;
    if (paramThrowable != null) {
      paramURLDrawable = paramThrowable.getMessage();
    }
    try
    {
      if (this.b != null) {
        avyz.a().s(2741, this.b.taskId, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.a.resUrl + " filePath = " + this.a.filePath);
      }
      this.this$0.cuI();
      return;
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadFailed Exception");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load success.");
    try
    {
      if ((this.this$0.zz != null) && (this.this$0.ai != null) && (paramURLDrawable != null))
      {
        this.this$0.zz.setVisibility(0);
        this.this$0.ai.setImageDrawable(paramURLDrawable);
        aaje.a(this.this$0, this.b);
        this.this$0.a(this.b);
        return;
      }
      if (this.this$0.zz != null)
      {
        this.this$0.zz.setVisibility(8);
        return;
      }
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadSuccessed Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajf
 * JD-Core Version:    0.7.0.1
 */