import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;

class vme
  implements Runnable
{
  vme(vmb paramvmb, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    AIOImageListModel localAIOImageListModel;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localAIOImageListModel = (AIOImageListModel)vma.a(this.jdField_a_of_type_Vmb.a);
      if (!localAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (vma.e(this.jdField_a_of_type_Vmb.a) != null) {
        ((AIOGalleryScene)vma.f(this.jdField_a_of_type_Vmb.a)).u();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vmb.a.a != null) {
        this.jdField_a_of_type_Vmb.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Vmb.a.a != null) && (this.jdField_a_of_type_Vmb.a.a() == this.jdField_a_of_type_Vmb.a.a))
      {
        localAIOImageListModel.a();
        if (vma.g(this.jdField_a_of_type_Vmb.a) != null) {
          ((AIOGalleryScene)vma.h(this.jdField_a_of_type_Vmb.a)).u();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */