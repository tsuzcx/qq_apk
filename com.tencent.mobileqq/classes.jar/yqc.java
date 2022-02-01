import android.view.View;
import android.view.View.OnClickListener;

public abstract class yqc
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new yqd(this);
  View jdField_a_of_type_AndroidViewView;
  ypx jdField_a_of_type_Ypx;
  ypy jdField_a_of_type_Ypy;
  yqe jdField_a_of_type_Yqe;
  boolean b = false;
  
  public yqc(yqe paramyqe, View paramView)
  {
    this.jdField_a_of_type_Yqe = paramyqe;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(float paramFloat) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  void a(ypx paramypx)
  {
    this.jdField_a_of_type_Ypx = paramypx;
  }
  
  public void a(ypy paramypy)
  {
    this.jdField_a_of_type_Ypy = paramypy;
    if (this.jdField_a_of_type_Ypy != null)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      ypx localypx = this.jdField_a_of_type_Ypx;
      if (localypx != null) {
        localypx.a(this, paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void d(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqc
 * JD-Core Version:    0.7.0.1
 */