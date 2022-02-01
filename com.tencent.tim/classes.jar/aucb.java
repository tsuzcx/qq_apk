import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class aucb
  implements atxy.a
{
  aucb(auby paramauby) {}
  
  public void Jy(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.b != null)) {
      this.a.b.iw();
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Aucs.a(this.a.jdField_a_of_type_Atzy.getFilePath(), this);
      if (this.a.jdField_a_of_type_Atzy.co()) {
        this.a.jdField_a_of_type_Aucs.b(this.a.jdField_a_of_type_Atzy.a());
      }
      this.a.cfm = false;
    }
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void as(boolean paramBoolean)
  {
    if (this.a.b != null) {
      this.a.b.as(paramBoolean);
    }
    if ((this.a.jdField_a_of_type_Aucs.amE()) && (paramBoolean)) {
      this.a.jdField_a_of_type_Aucs.dkv();
    }
    while ((this.a.jdField_a_of_type_Aucs.cb() == null) || (paramBoolean)) {
      return;
    }
    this.a.jdField_a_of_type_Aucs.b(this.a.jdField_a_of_type_Atzy.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucb
 * JD-Core Version:    0.7.0.1
 */