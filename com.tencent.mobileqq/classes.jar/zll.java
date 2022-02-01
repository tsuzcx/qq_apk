import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class zll
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zlm(this);
  View jdField_a_of_type_AndroidViewView;
  zlg jdField_a_of_type_Zlg;
  zlh jdField_a_of_type_Zlh;
  zln jdField_a_of_type_Zln;
  boolean b = false;
  
  public zll(zln paramzln, View paramView)
  {
    this.jdField_a_of_type_Zln = paramzln;
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
  
  void a(zlg paramzlg)
  {
    this.jdField_a_of_type_Zlg = paramzlg;
  }
  
  public void a(zlh paramzlh)
  {
    this.jdField_a_of_type_Zlh = paramzlh;
    if (this.jdField_a_of_type_Zlh != null)
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
      zlg localzlg = this.jdField_a_of_type_Zlg;
      if (localzlg != null) {
        localzlg.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zll
 * JD-Core Version:    0.7.0.1
 */