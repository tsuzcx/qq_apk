import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class vmg
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vmh(this);
  View jdField_a_of_type_AndroidViewView;
  vmb jdField_a_of_type_Vmb;
  vmc jdField_a_of_type_Vmc;
  vmi jdField_a_of_type_Vmi;
  boolean b = false;
  
  public vmg(vmi paramvmi, View paramView)
  {
    this.jdField_a_of_type_Vmi = paramvmi;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public Rect a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    return localRect;
  }
  
  public abstract CharSequence a();
  
  public void a(float paramFloat) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  void a(vmb paramvmb)
  {
    this.jdField_a_of_type_Vmb = paramvmb;
  }
  
  public void a(vmc paramvmc)
  {
    this.jdField_a_of_type_Vmc = paramvmc;
    if (this.jdField_a_of_type_Vmc != null)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return this.b;
  }
  
  public abstract CharSequence b();
  
  public void b(CharSequence paramCharSequence) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      vmb localvmb = this.jdField_a_of_type_Vmb;
      if (localvmb != null) {
        localvmb.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmg
 * JD-Core Version:    0.7.0.1
 */