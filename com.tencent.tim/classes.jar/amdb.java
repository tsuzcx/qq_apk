import android.app.Activity;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;

class amdb
  implements IGalleryImageListener
{
  amdb(amda paramamda, URLDrawable paramURLDrawable, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.a.a.Di.setVisibility(8);
    if (paramBoolean)
    {
      this.a.t(this.L);
      paramInt = this.L.getExifOrientation();
      this.c.orientation = paramInt;
      BasePresenter.updateRotation(this.a.a.galleryView, this.L, paramInt);
      return;
    }
    QQToast.a(this.a.a.mContext, this.a.a.mContext.getString(2131697153), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdb
 * JD-Core Version:    0.7.0.1
 */