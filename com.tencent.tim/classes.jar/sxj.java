import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class sxj
  implements sxv
{
  sxj(sxi paramsxi) {}
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.b.getVisibility() != 0) {
      this.a.b.setVisibility(0);
    }
    this.a.onEnterAnimationEnd();
    if ((this.a.jdField_a_of_type_Sxu != null) && (!this.a.jdField_a_of_type_Sxu.isShow())) {
      this.a.jdField_a_of_type_Sxu.show();
    }
  }
  
  public void onEnterAnimationStart()
  {
    if (this.a.jdField_a_of_type_Sxz.a().isRectAnimation) {
      this.a.b.setVisibility(4);
    }
    this.a.onEnterAnimationStart();
    if ((this.a.jdField_a_of_type_Sxu != null) && (this.a.jdField_a_of_type_Sxu.isShow())) {
      this.a.jdField_a_of_type_Sxu.hide();
    }
  }
  
  public void onExitAnimationEnd()
  {
    this.a.onExitAnimationEnd();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gallery onExitAnimationEnd ");
      if (this.a.jdField_a_of_type_Sxz.a() != this.a) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GalleryComponent", 2, bool);
      if (this.a.jdField_a_of_type_Sxz.a() != this.a) {
        break;
      }
      this.a.mContext.finish();
      return;
    }
    this.a.b.setVisibility(0);
    this.a.onStop();
  }
  
  public void onExitAnimationStart()
  {
    if (this.a.jdField_a_of_type_Sxz.a().isRectAnimation) {
      this.a.b.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_Sxh != null) {
      this.a.jdField_a_of_type_Sxh.setVisibility(4);
    }
    if ((this.a.jdField_a_of_type_Sxu != null) && (this.a.jdField_a_of_type_Sxu.isShow())) {
      this.a.jdField_a_of_type_Sxu.hide();
    }
    this.a.onExitAnimationStart();
    this.a.b.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxj
 * JD-Core Version:    0.7.0.1
 */