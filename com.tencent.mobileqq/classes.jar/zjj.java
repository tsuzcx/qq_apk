import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;

public abstract class zjj
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected zje a;
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  void a(zje paramzje)
  {
    this.jdField_a_of_type_Zje = paramzje;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public void h() {}
  
  public void k() {}
  
  public void l() {}
  
  public void p() {}
  
  public void s() {}
  
  public void t()
  {
    if (this.jdField_a_of_type_Zje != null) {
      this.jdField_a_of_type_Zje.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjj
 * JD-Core Version:    0.7.0.1
 */