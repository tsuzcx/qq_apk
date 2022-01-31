import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class wsi
  extends bhwk
{
  private bhwf<wsh> jdField_a_of_type_Bhwf = new bhwf();
  private wsh jdField_a_of_type_Wsh;
  private boolean jdField_a_of_type_Boolean;
  private wsh jdField_b_of_type_Wsh;
  private boolean jdField_b_of_type_Boolean;
  
  public bhwf<wsh> a()
  {
    return this.jdField_a_of_type_Bhwf;
  }
  
  public wsh a()
  {
    String str;
    if (this.jdField_b_of_type_Wsh == null) {
      str = avzg.e;
    }
    try
    {
      i = Integer.parseInt(str);
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < wsh.a().length) {}
      }
      else
      {
        j = 0;
      }
      this.jdField_b_of_type_Wsh = wsh.a()[j];
      if (QLog.isColorLevel()) {
        QLog.i("AEVideoStoryCaptureModeViewModel", 2, "[getTestingMode], app_alg_entrance_id=" + j);
      }
      return this.jdField_b_of_type_Wsh;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public void a(@NonNull wsh paramwsh)
  {
    this.jdField_a_of_type_Wsh = paramwsh;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bhwf.a() == null) {
      if (this.jdField_a_of_type_Wsh != wsh.c) {}
    }
    while (this.jdField_a_of_type_Bhwf.a() == wsh.c)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bhwf.a() == null) {
      if (this.jdField_a_of_type_Wsh != wsh.jdField_a_of_type_Wsh) {}
    }
    while (this.jdField_a_of_type_Bhwf.a() == wsh.jdField_a_of_type_Wsh)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Bhwf.a() == null) {
      if (this.jdField_a_of_type_Wsh != wsh.jdField_b_of_type_Wsh) {}
    }
    while (this.jdField_a_of_type_Bhwf.a() == wsh.jdField_b_of_type_Wsh)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */