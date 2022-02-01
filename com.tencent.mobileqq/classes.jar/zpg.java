import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class zpg
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zph(this);
  View jdField_a_of_type_AndroidViewView;
  zpb jdField_a_of_type_Zpb;
  zpc jdField_a_of_type_Zpc;
  zpi jdField_a_of_type_Zpi;
  boolean b = false;
  
  public zpg(zpi paramzpi, View paramView)
  {
    this.jdField_a_of_type_Zpi = paramzpi;
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
  
  void a(zpb paramzpb)
  {
    this.jdField_a_of_type_Zpb = paramzpb;
  }
  
  public void a(zpc paramzpc)
  {
    this.jdField_a_of_type_Zpc = paramzpc;
    if (this.jdField_a_of_type_Zpc != null)
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
      zpb localzpb = this.jdField_a_of_type_Zpb;
      if (localzpb != null) {
        localzpb.a(this, paramBoolean);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpg
 * JD-Core Version:    0.7.0.1
 */