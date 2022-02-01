import android.text.TextUtils;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnDownloadListener;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

class vyz
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnStateListener
{
  WeakReference<vys> a;
  
  public vyz(vys paramvys)
  {
    this.a = new WeakReference(paramvys);
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    int i = -1;
    if ((this.a.get() == null) || (vys.a((vys)this.a.get()) != 2)) {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore download result");
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramString2.contains("\"callBackType\":\"4\"")) && (vys.b((vys)this.a.get()) != -1))
    {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 4");
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        break label209;
      }
      vys.a((vys)this.a.get());
    }
    for (;;)
    {
      vys.a((vys)this.a.get(), i);
      ((vys)this.a.get()).a();
      return;
      if ((!paramString2.contains("\"callBackType\":\"7\"")) || (vys.b((vys)this.a.get()) == 0)) {
        break;
      }
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 7");
      vys.a((vys)this.a.get(), 0);
      ((vys)this.a.get()).a();
      return;
      label209:
      i = -2;
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if ((this.a.get() == null) || (vys.a((vys)this.a.get()) != 2)) {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore onStateChange");
    }
    while (paramInt != 5) {
      return;
    }
    if ((paramObject instanceof QQLiveDrawable.ErrorInfo))
    {
      paramString = (QQLiveDrawable.ErrorInfo)paramObject;
      if ((paramString.model != 122) || (paramString.what != 204)) {}
    }
    for (paramInt = -1;; paramInt = -2)
    {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "onStateChange state=STATE_ERROR , set play state = %d", new Object[] { Integer.valueOf(paramInt) });
      vys.a((vys)this.a.get());
      vys.a((vys)this.a.get(), paramInt);
      ((vys)this.a.get()).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyz
 * JD-Core Version:    0.7.0.1
 */