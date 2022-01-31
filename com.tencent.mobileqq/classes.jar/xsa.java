import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class xsa
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xsb(this);
  View jdField_a_of_type_AndroidViewView;
  xrv jdField_a_of_type_Xrv;
  xrw jdField_a_of_type_Xrw;
  xsc jdField_a_of_type_Xsc;
  boolean b = false;
  
  public xsa(xsc paramxsc, View paramView)
  {
    this.jdField_a_of_type_Xsc = paramxsc;
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
  
  void a(xrv paramxrv)
  {
    this.jdField_a_of_type_Xrv = paramxrv;
  }
  
  public void a(xrw paramxrw)
  {
    this.jdField_a_of_type_Xrw = paramxrw;
    if (this.jdField_a_of_type_Xrw != null)
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
      xrv localxrv = this.jdField_a_of_type_Xrv;
      if (localxrv != null) {
        localxrv.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsa
 * JD-Core Version:    0.7.0.1
 */