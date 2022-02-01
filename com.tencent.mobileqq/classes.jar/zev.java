import android.view.View;
import android.view.View.OnClickListener;

public abstract class zev
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zew(this);
  View jdField_a_of_type_AndroidViewView;
  zeq jdField_a_of_type_Zeq;
  zer jdField_a_of_type_Zer;
  zex jdField_a_of_type_Zex;
  boolean b = false;
  
  public zev(zex paramzex, View paramView)
  {
    this.jdField_a_of_type_Zex = paramzex;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(float paramFloat) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  void a(zeq paramzeq)
  {
    this.jdField_a_of_type_Zeq = paramzeq;
  }
  
  public void a(zer paramzer)
  {
    this.jdField_a_of_type_Zer = paramzer;
    if (this.jdField_a_of_type_Zer != null)
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
      zeq localzeq = this.jdField_a_of_type_Zeq;
      if (localzeq != null) {
        localzeq.a(this, paramBoolean);
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
 * Qualified Name:     zev
 * JD-Core Version:    0.7.0.1
 */