import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;

class vrg
  implements Runnable
{
  vrg(vrd paramvrd, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    AIOImageListModel localAIOImageListModel;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localAIOImageListModel = (AIOImageListModel)vrc.a(this.jdField_a_of_type_Vrd.a);
      if (!localAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (vrc.e(this.jdField_a_of_type_Vrd.a) != null) {
        ((AIOGalleryScene)vrc.f(this.jdField_a_of_type_Vrd.a)).u();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vrd.a.a != null) {
        this.jdField_a_of_type_Vrd.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Vrd.a.a != null) && (this.jdField_a_of_type_Vrd.a.a() == this.jdField_a_of_type_Vrd.a.a))
      {
        localAIOImageListModel.a();
        if (vrc.g(this.jdField_a_of_type_Vrd.a) != null) {
          ((AIOGalleryScene)vrc.h(this.jdField_a_of_type_Vrd.a)).u();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrg
 * JD-Core Version:    0.7.0.1
 */