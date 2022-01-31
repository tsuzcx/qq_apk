import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.File;

class uxf
  implements Runnable
{
  uxf(uxe paramuxe) {}
  
  public void run()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
    URLDrawable.getDrawable(new File(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath), localURLDrawableOptions);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxf
 * JD-Core Version:    0.7.0.1
 */