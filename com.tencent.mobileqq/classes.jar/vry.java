import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.Locale;

public class vry
  implements vrp
{
  public vry(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.j, paramAIOImageData.j)))
      {
        if (localAIOImageData.i <= 0L) {
          break label141;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, AIOGalleryScene.az(this.a).getString(2131436130), new Object[] { FileUtil.a(localAIOImageData.i) }));
      }
    }
    for (;;)
    {
      this.a.c(true);
      AIOGalleryScene.b(this.a);
      AIOGalleryScene.c(this.a);
      return;
      label141:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131436129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vry
 * JD-Core Version:    0.7.0.1
 */