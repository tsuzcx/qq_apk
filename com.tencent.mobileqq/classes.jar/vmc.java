import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.qphone.base.util.QLog;

class vmc
  implements Runnable
{
  vmc(vmb paramvmb, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (vma.a(this.jdField_a_of_type_Vmb.a) != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.jdField_a_of_type_Boolean);
      }
      ((AIOGalleryScene)vma.b(this.jdField_a_of_type_Vmb.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Vmb.a.a != null) {
      ((AIOImageListScene)this.jdField_a_of_type_Vmb.a.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmc
 * JD-Core Version:    0.7.0.1
 */