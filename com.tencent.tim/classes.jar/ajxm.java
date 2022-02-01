import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class ajxm
  implements URLDrawable.URLDrawableListener
{
  ajxm(String paramString1, ajxd.a parama, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130846222);
    WXShareHelper.a().a(new ajxo(this));
    WXShareHelper.a().a(this.adM, this.val$title, paramURLDrawable, this.aHr, this.val$jumpUrl);
    new ajxs().h("video").i("playpage_fw_suc").a().dy(this.val$app);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Bitmap localBitmap = ajxd.drawableToBitmap(paramURLDrawable);
    paramURLDrawable = localBitmap;
    if (localBitmap == null) {
      paramURLDrawable = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130846222);
    }
    WXShareHelper.a().a(new ajxn(this));
    WXShareHelper.a().a(this.adM, this.val$title, paramURLDrawable, this.aHr, this.val$jumpUrl);
    new ajxs().h("video").i("playpage_fw_suc").a().dy(this.val$app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxm
 * JD-Core Version:    0.7.0.1
 */