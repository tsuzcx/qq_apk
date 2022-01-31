import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class vyz
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vza(this);
  View jdField_a_of_type_AndroidViewView;
  vyu jdField_a_of_type_Vyu;
  vyv jdField_a_of_type_Vyv;
  vzb jdField_a_of_type_Vzb;
  boolean b = false;
  
  public vyz(vzb paramvzb, View paramView)
  {
    this.jdField_a_of_type_Vzb = paramvzb;
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
  
  void a(vyu paramvyu)
  {
    this.jdField_a_of_type_Vyu = paramvyu;
  }
  
  public void a(vyv paramvyv)
  {
    this.jdField_a_of_type_Vyv = paramvyv;
    if (this.jdField_a_of_type_Vyv != null)
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
      vyu localvyu = this.jdField_a_of_type_Vyu;
      if (localvyu != null) {
        localvyu.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyz
 * JD-Core Version:    0.7.0.1
 */