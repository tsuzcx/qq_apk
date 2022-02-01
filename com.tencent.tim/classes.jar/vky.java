import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class vky
  implements URLDrawable.URLDrawableListener
{
  public vky(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PermisionPrivacyActivity.b(this.this$0) != null) {
      PermisionPrivacyActivity.b(this.this$0).postInvalidate();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PermisionPrivacyActivity.b(this.this$0) != null) {
      PermisionPrivacyActivity.b(this.this$0).postInvalidate();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, rpq.dip2px(this.this$0.app.getApp(), 47.0F), rpq.dip2px(this.this$0.app.getApp(), 14.0F));
    }
    if (PermisionPrivacyActivity.b(this.this$0) != null) {
      PermisionPrivacyActivity.b(this.this$0).postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vky
 * JD-Core Version:    0.7.0.1
 */