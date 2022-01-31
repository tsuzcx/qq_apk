import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class xpg
  implements xps
{
  xpg(xpf paramxpf) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    this.a.b();
    if ((this.a.jdField_a_of_type_Xpr != null) && (!this.a.jdField_a_of_type_Xpr.a())) {
      this.a.jdField_a_of_type_Xpr.a();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_Xpw.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    this.a.c();
    if ((this.a.jdField_a_of_type_Xpr != null) && (this.a.jdField_a_of_type_Xpr.a())) {
      this.a.jdField_a_of_type_Xpr.b();
    }
  }
  
  public void d()
  {
    if (this.a.jdField_a_of_type_Xpw.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_Xpe != null) {
      this.a.jdField_a_of_type_Xpe.a(4);
    }
    if ((this.a.jdField_a_of_type_Xpr != null) && (this.a.jdField_a_of_type_Xpr.a())) {
      this.a.jdField_a_of_type_Xpr.b();
    }
    this.a.d();
    this.a.jdField_a_of_type_ComTencentWidgetGallery.e();
  }
  
  public void e()
  {
    this.a.e();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gallery onExitAnimationEnd ");
      if (this.a.jdField_a_of_type_Xpw.a() != this.a) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GalleryComponent", 2, bool);
      if (this.a.jdField_a_of_type_Xpw.a() != this.a) {
        break;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpg
 * JD-Core Version:    0.7.0.1
 */