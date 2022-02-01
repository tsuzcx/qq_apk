import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

class amef
  implements IGalleryImageListener
{
  amef(amea paramamea, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.this$0.Di.setVisibility(8);
    if (paramBoolean)
    {
      amea.a(this.this$0, this.d, this.val$filePath, this.L, paramInt);
      return;
    }
    if ((!amea.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!amea.b(this.this$0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!amea.c(this.this$0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView))) {
      amea.a(this.this$0, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView);
    }
    amea.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.msgId, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.subId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amef
 * JD-Core Version:    0.7.0.1
 */