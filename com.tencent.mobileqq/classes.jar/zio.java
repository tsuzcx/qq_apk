import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class zio
  implements zja
{
  zio(zin paramzin) {}
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    this.a.b();
    if ((this.a.jdField_a_of_type_Ziz != null) && (!this.a.jdField_a_of_type_Ziz.a())) {
      this.a.jdField_a_of_type_Ziz.a();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_Zje.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    this.a.c();
    if ((this.a.jdField_a_of_type_Ziz != null) && (this.a.jdField_a_of_type_Ziz.a())) {
      this.a.jdField_a_of_type_Ziz.b();
    }
  }
  
  public void d()
  {
    if (this.a.jdField_a_of_type_Zje.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_Zim != null) {
      this.a.jdField_a_of_type_Zim.a(4);
    }
    if ((this.a.jdField_a_of_type_Ziz != null) && (this.a.jdField_a_of_type_Ziz.a())) {
      this.a.jdField_a_of_type_Ziz.b();
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
      if (this.a.jdField_a_of_type_Zje.a() != this.a) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GalleryComponent", 2, bool);
      if (this.a.jdField_a_of_type_Zje.a() != this.a) {
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
 * Qualified Name:     zio
 * JD-Core Version:    0.7.0.1
 */