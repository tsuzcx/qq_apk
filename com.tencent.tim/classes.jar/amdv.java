import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

class amdv
  implements IGalleryImageListener
{
  amdv(amdr paramamdr, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.this$0.Di.setVisibility(8);
    if (paramBoolean)
    {
      amdr.a(this.this$0, this.d, this.val$filePath, this.L, paramInt);
      return;
    }
    if ((!amdr.a(this.this$0, this.b, this.a)) && (!amdr.b(this.this$0, this.b, this.a))) {
      amdr.a(this.this$0, this.a);
    }
    amdr.a(this.this$0, this.b.msgId, this.b.subId, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdv
 * JD-Core Version:    0.7.0.1
 */