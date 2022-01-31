import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;

class vjc
  implements Runnable
{
  vjc(viz paramviz, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    AIOImageListModel localAIOImageListModel;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localAIOImageListModel = (AIOImageListModel)viy.a(this.jdField_a_of_type_Viz.a);
      if (!localAIOImageListModel.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_Int)) {
        break label92;
      }
      if (viy.e(this.jdField_a_of_type_Viz.a) != null) {
        ((AIOGalleryScene)viy.f(this.jdField_a_of_type_Viz.a)).u();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Viz.a.a != null) {
        this.jdField_a_of_type_Viz.a.a.h();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Viz.a.a != null) && (this.jdField_a_of_type_Viz.a.a() == this.jdField_a_of_type_Viz.a.a))
      {
        localAIOImageListModel.a();
        if (viy.g(this.jdField_a_of_type_Viz.a) != null) {
          ((AIOGalleryScene)viy.h(this.jdField_a_of_type_Viz.a)).u();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjc
 * JD-Core Version:    0.7.0.1
 */