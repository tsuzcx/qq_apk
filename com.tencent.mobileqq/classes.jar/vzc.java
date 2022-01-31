import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class vzc
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vzd(this);
  View jdField_a_of_type_AndroidViewView;
  vyx jdField_a_of_type_Vyx;
  vyy jdField_a_of_type_Vyy;
  vze jdField_a_of_type_Vze;
  boolean b = false;
  
  public vzc(vze paramvze, View paramView)
  {
    this.jdField_a_of_type_Vze = paramvze;
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
  
  void a(vyx paramvyx)
  {
    this.jdField_a_of_type_Vyx = paramvyx;
  }
  
  public void a(vyy paramvyy)
  {
    this.jdField_a_of_type_Vyy = paramvyy;
    if (this.jdField_a_of_type_Vyy != null)
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
      vyx localvyx = this.jdField_a_of_type_Vyx;
      if (localvyx != null) {
        localvyx.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzc
 * JD-Core Version:    0.7.0.1
 */