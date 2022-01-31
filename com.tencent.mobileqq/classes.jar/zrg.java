import com.tencent.qphone.base.util.QLog;

public class zrg
{
  public double a;
  public long a;
  public String a;
  public zrf a;
  public zrk a;
  public double b;
  
  public zrg()
  {
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_b_of_type_Double = -1.0D;
  }
  
  public void a(zrf paramzrf)
  {
    if (this.jdField_a_of_type_Zrf != null)
    {
      this.jdField_a_of_type_Double = ((this.jdField_a_of_type_Double + paramzrf.jdField_a_of_type_Double) / 2.0D);
      this.jdField_b_of_type_Double = ((this.jdField_b_of_type_Double + paramzrf.jdField_b_of_type_Double) / 2.0D);
      this.jdField_a_of_type_Long = ((this.jdField_a_of_type_Long + paramzrf.jdField_b_of_type_Long) / 2L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zrf = paramzrf;
      return;
      this.jdField_a_of_type_Long = paramzrf.jdField_b_of_type_Long;
      this.jdField_a_of_type_Double = paramzrf.jdField_a_of_type_Double;
      this.jdField_b_of_type_Double = paramzrf.jdField_b_of_type_Double;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Long > 0L)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Long < 9223372036854775807L)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Double >= 0.0D) {
          bool1 = true;
        }
      }
    }
    if ((!bool1) && (QLog.isColorLevel())) {
      QLog.i("reportToDenta", 2, "failed" + this.jdField_a_of_type_Long + " " + this.jdField_a_of_type_Double);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zrg
 * JD-Core Version:    0.7.0.1
 */