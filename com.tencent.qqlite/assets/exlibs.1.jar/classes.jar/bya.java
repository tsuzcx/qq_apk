import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;

public class bya
  implements View.OnClickListener
{
  public bya(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onClick(View paramView)
  {
    paramView = (AIOImageInfo)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(AIOGalleryScene.a(this.a).b());
    if ((paramView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
    {
      this.a.a(true);
      this.a.jdField_a_of_type_Bye = new bye(this.a, null);
      this.a.jdField_a_of_type_Bye.jdField_a_of_type_Long = paramView.a.jdField_a_of_type_Long;
      this.a.jdField_a_of_type_Bye.jdField_a_of_type_Int = paramView.a.d;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.a.jdField_a_of_type_Bye.jdField_a_of_type_Long, this.a.jdField_a_of_type_Bye.jdField_a_of_type_Int, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bya
 * JD-Core Version:    0.7.0.1
 */