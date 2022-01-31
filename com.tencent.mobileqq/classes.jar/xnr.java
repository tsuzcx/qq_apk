import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class xnr
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xns(this);
  View jdField_a_of_type_AndroidViewView;
  xnm jdField_a_of_type_Xnm;
  xnn jdField_a_of_type_Xnn;
  xnt jdField_a_of_type_Xnt;
  boolean b = false;
  
  public xnr(xnt paramxnt, View paramView)
  {
    this.jdField_a_of_type_Xnt = paramxnt;
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
  
  void a(xnm paramxnm)
  {
    this.jdField_a_of_type_Xnm = paramxnm;
  }
  
  public void a(xnn paramxnn)
  {
    this.jdField_a_of_type_Xnn = paramxnn;
    if (this.jdField_a_of_type_Xnn != null)
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
      xnm localxnm = this.jdField_a_of_type_Xnm;
      if (localxnm != null) {
        localxnm.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnr
 * JD-Core Version:    0.7.0.1
 */